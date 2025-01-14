package c.d.a.a.e.e.l;
/* loaded from: classes.dex */
public final class o0 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public /* synthetic */ c.d.a.a.e.a f3377a;

    /* renamed from: b  reason: collision with root package name */
    public /* synthetic */ l0 f3378b;

    public o0(l0 l0Var, c.d.a.a.e.a aVar) {
        this.f3378b = l0Var;
        this.f3377a = aVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f3378b.onConnectionFailed(this.f3377a);
    }
}
