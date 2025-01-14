package c.a.a;

import android.os.Handler;
import android.os.Looper;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.atomic.AtomicInteger;
/* compiled from: RequestQueue.java */
/* loaded from: classes.dex */
public class j {

    /* renamed from: a  reason: collision with root package name */
    public final AtomicInteger f2790a;

    /* renamed from: b  reason: collision with root package name */
    public final Set<i<?>> f2791b;

    /* renamed from: c  reason: collision with root package name */
    public final PriorityBlockingQueue<i<?>> f2792c;

    /* renamed from: d  reason: collision with root package name */
    public final PriorityBlockingQueue<i<?>> f2793d;

    /* renamed from: e  reason: collision with root package name */
    public final c.a.a.a f2794e;

    /* renamed from: f  reason: collision with root package name */
    public final f f2795f;

    /* renamed from: g  reason: collision with root package name */
    public final l f2796g;

    /* renamed from: h  reason: collision with root package name */
    public final g[] f2797h;

    /* renamed from: i  reason: collision with root package name */
    public b f2798i;
    public final List<a> j;

    /* compiled from: RequestQueue.java */
    /* loaded from: classes.dex */
    public interface a<T> {
        void a(i<T> iVar);
    }

    public j(c.a.a.a aVar, f fVar, int i2, l lVar) {
        this.f2790a = new AtomicInteger();
        this.f2791b = new HashSet();
        this.f2792c = new PriorityBlockingQueue<>();
        this.f2793d = new PriorityBlockingQueue<>();
        this.j = new ArrayList();
        this.f2794e = aVar;
        this.f2795f = fVar;
        this.f2797h = new g[i2];
        this.f2796g = lVar;
    }

    public int a() {
        return this.f2790a.incrementAndGet();
    }

    public void b() {
        c();
        this.f2798i = new b(this.f2792c, this.f2793d, this.f2794e, this.f2796g);
        this.f2798i.start();
        for (int i2 = 0; i2 < this.f2797h.length; i2++) {
            g gVar = new g(this.f2793d, this.f2795f, this.f2794e, this.f2796g);
            this.f2797h[i2] = gVar;
            gVar.start();
        }
    }

    public void c() {
        g[] gVarArr;
        b bVar = this.f2798i;
        if (bVar != null) {
            bVar.b();
        }
        for (g gVar : this.f2797h) {
            if (gVar != null) {
                gVar.b();
            }
        }
    }

    public <T> i<T> a(i<T> iVar) {
        iVar.a(this);
        synchronized (this.f2791b) {
            this.f2791b.add(iVar);
        }
        iVar.a(a());
        iVar.a("add-to-queue");
        if (!iVar.w()) {
            this.f2793d.add(iVar);
            return iVar;
        }
        this.f2792c.add(iVar);
        return iVar;
    }

    public <T> void b(i<T> iVar) {
        synchronized (this.f2791b) {
            this.f2791b.remove(iVar);
        }
        synchronized (this.j) {
            for (a aVar : this.j) {
                aVar.a(iVar);
            }
        }
    }

    public j(c.a.a.a aVar, f fVar, int i2) {
        this(aVar, fVar, i2, new d(new Handler(Looper.getMainLooper())));
    }

    public j(c.a.a.a aVar, f fVar) {
        this(aVar, fVar, 4);
    }
}
