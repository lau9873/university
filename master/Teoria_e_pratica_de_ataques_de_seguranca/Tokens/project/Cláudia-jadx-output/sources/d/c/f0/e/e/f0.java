package d.c.f0.e.e;
/* compiled from: SingleLift.java */
/* loaded from: classes.dex */
public final class f0<T, R> extends d.c.u<R> {

    /* renamed from: a  reason: collision with root package name */
    public final d.c.z<T> f5101a;

    /* renamed from: b  reason: collision with root package name */
    public final d.c.y<? extends R, ? super T> f5102b;

    public f0(d.c.z<T> zVar, d.c.y<? extends R, ? super T> yVar) {
        this.f5101a = zVar;
        this.f5102b = yVar;
    }

    @Override // d.c.u
    public void subscribeActual(d.c.w<? super R> wVar) {
        try {
            d.c.w<? super Object> a2 = this.f5102b.a(wVar);
            d.c.f0.b.b.a(a2, "The onLift returned a null SingleObserver");
            this.f5101a.subscribe(a2);
        } catch (Throwable th) {
            d.c.d0.a.b(th);
            d.c.f0.a.c.a(th, wVar);
        }
    }
}
