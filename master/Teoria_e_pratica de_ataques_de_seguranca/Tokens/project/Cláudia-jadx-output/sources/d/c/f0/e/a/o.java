package d.c.f0.e.a;
/* compiled from: CompletableFromAction.java */
/* loaded from: classes.dex */
public final class o extends d.c.b {

    /* renamed from: a  reason: collision with root package name */
    public final d.c.e0.a f4760a;

    public o(d.c.e0.a aVar) {
        this.f4760a = aVar;
    }

    @Override // d.c.b
    public void subscribeActual(d.c.d dVar) {
        d.c.c0.b b2 = d.c.c0.c.b();
        dVar.a(b2);
        try {
            this.f4760a.run();
            if (b2.c()) {
                return;
            }
            dVar.a();
        } catch (Throwable th) {
            d.c.d0.a.b(th);
            if (b2.c()) {
                return;
            }
            dVar.a(th);
        }
    }
}
