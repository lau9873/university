package d.c.f0.d;

import d.c.w;
import java.util.concurrent.atomic.AtomicReference;
/* compiled from: ResumeSingleObserver.java */
/* loaded from: classes.dex */
public final class j<T> implements w<T> {

    /* renamed from: a  reason: collision with root package name */
    public final AtomicReference<d.c.c0.b> f4621a;

    /* renamed from: b  reason: collision with root package name */
    public final w<? super T> f4622b;

    public j(AtomicReference<d.c.c0.b> atomicReference, w<? super T> wVar) {
        this.f4621a = atomicReference;
        this.f4622b = wVar;
    }

    @Override // d.c.w
    public void a(d.c.c0.b bVar) {
        d.c.f0.a.b.a(this.f4621a, bVar);
    }

    @Override // d.c.w
    public void b(T t) {
        this.f4622b.b(t);
    }

    @Override // d.c.w
    public void a(Throwable th) {
        this.f4622b.a(th);
    }
}
