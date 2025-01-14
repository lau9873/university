package c.a.a;

import android.os.Process;
import c.a.a.a;
import c.a.a.i;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.BlockingQueue;
/* compiled from: CacheDispatcher.java */
/* loaded from: classes.dex */
public class b extends Thread {

    /* renamed from: g  reason: collision with root package name */
    public static final boolean f2742g = n.f2804b;

    /* renamed from: a  reason: collision with root package name */
    public final BlockingQueue<i<?>> f2743a;

    /* renamed from: b  reason: collision with root package name */
    public final BlockingQueue<i<?>> f2744b;

    /* renamed from: c  reason: collision with root package name */
    public final c.a.a.a f2745c;

    /* renamed from: d  reason: collision with root package name */
    public final l f2746d;

    /* renamed from: e  reason: collision with root package name */
    public volatile boolean f2747e = false;

    /* renamed from: f  reason: collision with root package name */
    public final C0052b f2748f = new C0052b(this);

    /* compiled from: CacheDispatcher.java */
    /* loaded from: classes.dex */
    public class a implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ i f2749a;

        public a(i iVar) {
            this.f2749a = iVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                b.this.f2744b.put(this.f2749a);
            } catch (InterruptedException unused) {
                Thread.currentThread().interrupt();
            }
        }
    }

    /* compiled from: CacheDispatcher.java */
    /* renamed from: c.a.a.b$b  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0052b implements i.b {

        /* renamed from: a  reason: collision with root package name */
        public final Map<String, List<i<?>>> f2751a = new HashMap();

        /* renamed from: b  reason: collision with root package name */
        public final b f2752b;

        public C0052b(b bVar) {
            this.f2752b = bVar;
        }

        public final synchronized boolean b(i<?> iVar) {
            String f2 = iVar.f();
            if (this.f2751a.containsKey(f2)) {
                List<i<?>> list = this.f2751a.get(f2);
                if (list == null) {
                    list = new ArrayList<>();
                }
                iVar.a("waiting-for-response");
                list.add(iVar);
                this.f2751a.put(f2, list);
                if (n.f2804b) {
                    n.b("Request for cacheKey=%s is in flight, putting on hold.", f2);
                }
                return true;
            }
            this.f2751a.put(f2, null);
            iVar.a((i.b) this);
            if (n.f2804b) {
                n.b("new request, sending to network %s", f2);
            }
            return false;
        }

        @Override // c.a.a.i.b
        public void a(i<?> iVar, k<?> kVar) {
            List<i<?>> remove;
            a.C0051a c0051a = kVar.f2800b;
            if (c0051a != null && !c0051a.a()) {
                String f2 = iVar.f();
                synchronized (this) {
                    remove = this.f2751a.remove(f2);
                }
                if (remove != null) {
                    if (n.f2804b) {
                        n.d("Releasing %d waiting requests for cacheKey=%s.", Integer.valueOf(remove.size()), f2);
                    }
                    for (i<?> iVar2 : remove) {
                        this.f2752b.f2746d.a(iVar2, kVar);
                    }
                    return;
                }
                return;
            }
            a(iVar);
        }

        @Override // c.a.a.i.b
        public synchronized void a(i<?> iVar) {
            String f2 = iVar.f();
            List<i<?>> remove = this.f2751a.remove(f2);
            if (remove != null && !remove.isEmpty()) {
                if (n.f2804b) {
                    n.d("%d waiting requests for cacheKey=%s; resend to network", Integer.valueOf(remove.size()), f2);
                }
                i<?> remove2 = remove.remove(0);
                this.f2751a.put(f2, remove);
                remove2.a((i.b) this);
                try {
                    this.f2752b.f2744b.put(remove2);
                } catch (InterruptedException e2) {
                    n.c("Couldn't add request to queue. %s", e2.toString());
                    Thread.currentThread().interrupt();
                    this.f2752b.b();
                }
            }
        }
    }

    public b(BlockingQueue<i<?>> blockingQueue, BlockingQueue<i<?>> blockingQueue2, c.a.a.a aVar, l lVar) {
        this.f2743a = blockingQueue;
        this.f2744b = blockingQueue2;
        this.f2745c = aVar;
        this.f2746d = lVar;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        if (f2742g) {
            n.d("start new dispatcher", new Object[0]);
        }
        Process.setThreadPriority(10);
        this.f2745c.a();
        while (true) {
            try {
                a();
            } catch (InterruptedException unused) {
                if (this.f2747e) {
                    Thread.currentThread().interrupt();
                    return;
                }
                n.c("Ignoring spurious interrupt of CacheDispatcher thread; use quit() to terminate it", new Object[0]);
            }
        }
    }

    public final void a() {
        a(this.f2743a.take());
    }

    public void b() {
        this.f2747e = true;
        interrupt();
    }

    public void a(i<?> iVar) {
        iVar.a("cache-queue-take");
        if (iVar.t()) {
            iVar.b("cache-discard-canceled");
            return;
        }
        a.C0051a a2 = this.f2745c.a(iVar.f());
        if (a2 == null) {
            iVar.a("cache-miss");
            if (this.f2748f.b(iVar)) {
                return;
            }
            this.f2744b.put(iVar);
        } else if (a2.a()) {
            iVar.a("cache-hit-expired");
            iVar.a(a2);
            if (this.f2748f.b(iVar)) {
                return;
            }
            this.f2744b.put(iVar);
        } else {
            iVar.a("cache-hit");
            k<?> a3 = iVar.a(new h(a2.f2734a, a2.f2740g));
            iVar.a("cache-hit-parsed");
            if (!a2.b()) {
                this.f2746d.a(iVar, a3);
                return;
            }
            iVar.a("cache-hit-refresh-needed");
            iVar.a(a2);
            a3.f2802d = true;
            if (!this.f2748f.b(iVar)) {
                this.f2746d.a(iVar, a3, new a(iVar));
            } else {
                this.f2746d.a(iVar, a3);
            }
        }
    }
}
