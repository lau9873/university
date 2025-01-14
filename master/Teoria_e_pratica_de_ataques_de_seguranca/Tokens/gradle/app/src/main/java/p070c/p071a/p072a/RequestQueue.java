package p070c.p071a.p072a;

import android.os.Handler;
import android.os.Looper;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.atomic.AtomicInteger;

/* renamed from: c.a.a.j */
/* loaded from: classes.dex */
public class RequestQueue {

    /* renamed from: a */
    public final AtomicInteger f4586a;

    /* renamed from: b */
    public final Set<Request<?>> f4587b;

    /* renamed from: c */
    public final PriorityBlockingQueue<Request<?>> f4588c;

    /* renamed from: d */
    public final PriorityBlockingQueue<Request<?>> f4589d;

    /* renamed from: e */
    public final InterfaceC0779a f4590e;

    /* renamed from: f */
    public final Network f4591f;

    /* renamed from: g */
    public final ResponseDelivery f4592g;

    /* renamed from: h */
    public final NetworkDispatcher[] f4593h;

    /* renamed from: i */
    public CacheDispatcher f4594i;

    /* renamed from: j */
    public final List<InterfaceC0788a> f4595j;

    /* compiled from: RequestQueue.java */
    /* renamed from: c.a.a.j$a */
    /* loaded from: classes.dex */
    public interface InterfaceC0788a<T> {
        /* renamed from: a */
        void m6180a(Request<T> request);
    }

    public RequestQueue(InterfaceC0779a interfaceC0779a, Network network, int i, ResponseDelivery responseDelivery) {
        this.f4586a = new AtomicInteger();
        this.f4587b = new HashSet();
        this.f4588c = new PriorityBlockingQueue<>();
        this.f4589d = new PriorityBlockingQueue<>();
        this.f4595j = new ArrayList();
        this.f4590e = interfaceC0779a;
        this.f4591f = network;
        this.f4593h = new NetworkDispatcher[i];
        this.f4592g = responseDelivery;
    }

    /* renamed from: a */
    public int m6185a() {
        return this.f4586a.incrementAndGet();
    }

    /* renamed from: b */
    public void m6183b() {
        m6181c();
        this.f4594i = new CacheDispatcher(this.f4588c, this.f4589d, this.f4590e, this.f4592g);
        this.f4594i.start();
        for (int i = 0; i < this.f4593h.length; i++) {
            NetworkDispatcher networkDispatcher = new NetworkDispatcher(this.f4589d, this.f4591f, this.f4590e, this.f4592g);
            this.f4593h[i] = networkDispatcher;
            networkDispatcher.start();
        }
    }

    /* renamed from: c */
    public void m6181c() {
        NetworkDispatcher[] networkDispatcherArr;
        CacheDispatcher cacheDispatcher = this.f4594i;
        if (cacheDispatcher != null) {
            cacheDispatcher.m6234b();
        }
        for (NetworkDispatcher networkDispatcher : this.f4593h) {
            if (networkDispatcher != null) {
                networkDispatcher.m6224b();
            }
        }
    }

    /* renamed from: a */
    public <T> Request<T> m6184a(Request<T> request) {
        request.m6215a(this);
        synchronized (this.f4587b) {
            this.f4587b.add(request);
        }
        request.m6219a(m6185a());
        request.m6211a("add-to-queue");
        if (!request.m6189w()) {
            this.f4589d.add(request);
            return request;
        }
        this.f4588c.add(request);
        return request;
    }

    /* renamed from: b */
    public <T> void m6182b(Request<T> request) {
        synchronized (this.f4587b) {
            this.f4587b.remove(request);
        }
        synchronized (this.f4595j) {
            for (InterfaceC0788a interfaceC0788a : this.f4595j) {
                interfaceC0788a.m6180a(request);
            }
        }
    }

    public RequestQueue(InterfaceC0779a interfaceC0779a, Network network, int i) {
        this(interfaceC0779a, network, i, new ExecutorDelivery(new Handler(Looper.getMainLooper())));
    }

    public RequestQueue(InterfaceC0779a interfaceC0779a, Network network) {
        this(interfaceC0779a, network, 4);
    }
}
