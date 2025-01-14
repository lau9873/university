package p070c.p071a.p072a;

import android.os.Process;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.BlockingQueue;
import p070c.p071a.p072a.InterfaceC0779a;
import p070c.p071a.p072a.Request;

/* renamed from: c.a.a.b */
/* loaded from: classes.dex */
public class CacheDispatcher extends Thread {

    /* renamed from: g */
    public static final boolean f4532g = VolleyLog.f4601b;

    /* renamed from: a */
    public final BlockingQueue<Request<?>> f4533a;

    /* renamed from: b */
    public final BlockingQueue<Request<?>> f4534b;

    /* renamed from: c */
    public final InterfaceC0779a f4535c;

    /* renamed from: d */
    public final ResponseDelivery f4536d;

    /* renamed from: e */
    public volatile boolean f4537e = false;

    /* renamed from: f */
    public final C0782b f4538f = new C0782b(this);

    /* compiled from: CacheDispatcher.java */
    /* renamed from: c.a.a.b$a */
    /* loaded from: classes.dex */
    public class RunnableC0781a implements Runnable {

        /* renamed from: a */
        public final /* synthetic */ Request f4539a;

        public RunnableC0781a(Request request) {
            this.f4539a = request;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                CacheDispatcher.this.f4534b.put(this.f4539a);
            } catch (InterruptedException unused) {
                Thread.currentThread().interrupt();
            }
        }
    }

    /* compiled from: CacheDispatcher.java */
    /* renamed from: c.a.a.b$b */
    /* loaded from: classes.dex */
    public static class C0782b implements Request.InterfaceC0786b {

        /* renamed from: a */
        public final Map<String, List<Request<?>>> f4541a = new HashMap();

        /* renamed from: b */
        public final CacheDispatcher f4542b;

        public C0782b(CacheDispatcher cacheDispatcher) {
            this.f4542b = cacheDispatcher;
        }

        /* renamed from: b */
        public final synchronized boolean m6231b(Request<?> request) {
            String m6204f = request.m6204f();
            if (this.f4541a.containsKey(m6204f)) {
                List<Request<?>> list = this.f4541a.get(m6204f);
                if (list == null) {
                    list = new ArrayList<>();
                }
                request.m6211a("waiting-for-response");
                list.add(request);
                this.f4541a.put(m6204f, list);
                if (VolleyLog.f4601b) {
                    VolleyLog.m6168b("Request for cacheKey=%s is in flight, putting on hold.", m6204f);
                }
                return true;
            }
            this.f4541a.put(m6204f, null);
            request.m6217a((Request.InterfaceC0786b) this);
            if (VolleyLog.f4601b) {
                VolleyLog.m6168b("new request, sending to network %s", m6204f);
            }
            return false;
        }

        @Override // p070c.p071a.p072a.Request.InterfaceC0786b
        /* renamed from: a */
        public void mo6186a(Request<?> request, Response<?> response) {
            List<Request<?>> remove;
            InterfaceC0779a.C0780a c0780a = response.f4597b;
            if (c0780a != null && !c0780a.m6239a()) {
                String m6204f = request.m6204f();
                synchronized (this) {
                    remove = this.f4541a.remove(m6204f);
                }
                if (remove != null) {
                    if (VolleyLog.f4601b) {
                        VolleyLog.m6166d("Releasing %d waiting requests for cacheKey=%s.", Integer.valueOf(remove.size()), m6204f);
                    }
                    for (Request<?> request2 : remove) {
                        this.f4542b.f4536d.mo6176a(request2, response);
                    }
                    return;
                }
                return;
            }
            mo6187a(request);
        }

        @Override // p070c.p071a.p072a.Request.InterfaceC0786b
        /* renamed from: a */
        public synchronized void mo6187a(Request<?> request) {
            String m6204f = request.m6204f();
            List<Request<?>> remove = this.f4541a.remove(m6204f);
            if (remove != null && !remove.isEmpty()) {
                if (VolleyLog.f4601b) {
                    VolleyLog.m6166d("%d waiting requests for cacheKey=%s; resend to network", Integer.valueOf(remove.size()), m6204f);
                }
                Request<?> remove2 = remove.remove(0);
                this.f4541a.put(m6204f, remove);
                remove2.m6217a((Request.InterfaceC0786b) this);
                try {
                    this.f4542b.f4534b.put(remove2);
                } catch (InterruptedException e) {
                    VolleyLog.m6167c("Couldn't add request to queue. %s", e.toString());
                    Thread.currentThread().interrupt();
                    this.f4542b.m6234b();
                }
            }
        }
    }

    public CacheDispatcher(BlockingQueue<Request<?>> blockingQueue, BlockingQueue<Request<?>> blockingQueue2, InterfaceC0779a interfaceC0779a, ResponseDelivery responseDelivery) {
        this.f4533a = blockingQueue;
        this.f4534b = blockingQueue2;
        this.f4535c = interfaceC0779a;
        this.f4536d = responseDelivery;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        if (f4532g) {
            VolleyLog.m6166d("start new dispatcher", new Object[0]);
        }
        Process.setThreadPriority(10);
        this.f4535c.mo6151a();
        while (true) {
            try {
                m6237a();
            } catch (InterruptedException unused) {
                if (this.f4537e) {
                    Thread.currentThread().interrupt();
                    return;
                }
                VolleyLog.m6167c("Ignoring spurious interrupt of CacheDispatcher thread; use quit() to terminate it", new Object[0]);
            }
        }
    }

    /* renamed from: a */
    public final void m6237a() {
        m6235a(this.f4533a.take());
    }

    /* renamed from: b */
    public void m6234b() {
        this.f4537e = true;
        interrupt();
    }

    /* renamed from: a */
    public void m6235a(Request<?> request) {
        request.m6211a("cache-queue-take");
        if (request.m6192t()) {
            request.m6207b("cache-discard-canceled");
            return;
        }
        InterfaceC0779a.C0780a mo6142a = this.f4535c.mo6142a(request.m6204f());
        if (mo6142a == null) {
            request.m6211a("cache-miss");
            if (this.f4538f.m6231b(request)) {
                return;
            }
            this.f4534b.put(request);
        } else if (mo6142a.m6239a()) {
            request.m6211a("cache-hit-expired");
            request.m6218a(mo6142a);
            if (this.f4538f.m6231b(request)) {
                return;
            }
            this.f4534b.put(request);
        } else {
            request.m6211a("cache-hit");
            Response<?> mo6098a = request.mo6098a(new NetworkResponse(mo6142a.f4524a, mo6142a.f4530g));
            request.m6211a("cache-hit-parsed");
            if (!mo6142a.m6238b()) {
                this.f4536d.mo6176a(request, mo6098a);
                return;
            }
            request.m6211a("cache-hit-refresh-needed");
            request.m6218a(mo6142a);
            mo6098a.f4599d = true;
            if (!this.f4538f.m6231b(request)) {
                this.f4536d.mo6175a(request, mo6098a, new RunnableC0781a(request));
            } else {
                this.f4536d.mo6176a(request, mo6098a);
            }
        }
    }
}
