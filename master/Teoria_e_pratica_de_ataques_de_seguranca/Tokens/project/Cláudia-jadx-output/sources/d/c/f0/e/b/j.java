package d.c.f0.e.b;

import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
/* compiled from: FlowableFromFuture.java */
/* loaded from: classes.dex */
public final class j<T> extends d.c.j<T> {

    /* renamed from: b  reason: collision with root package name */
    public final Future<? extends T> f4880b;

    /* renamed from: c  reason: collision with root package name */
    public final long f4881c;

    /* renamed from: d  reason: collision with root package name */
    public final TimeUnit f4882d;

    public j(Future<? extends T> future, long j, TimeUnit timeUnit) {
        this.f4880b = future;
        this.f4881c = j;
        this.f4882d = timeUnit;
    }

    @Override // d.c.j
    public void b(g.b.c<? super T> cVar) {
        d.c.f0.i.c cVar2 = new d.c.f0.i.c(cVar);
        cVar.a((g.b.d) cVar2);
        try {
            T t = this.f4882d != null ? this.f4880b.get(this.f4881c, this.f4882d) : this.f4880b.get();
            if (t == null) {
                cVar.a((Throwable) new NullPointerException("The future returned null"));
            } else {
                cVar2.d(t);
            }
        } catch (Throwable th) {
            d.c.d0.a.b(th);
            if (cVar2.b()) {
                return;
            }
            cVar.a(th);
        }
    }
}
