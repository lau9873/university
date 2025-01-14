package d.c.f0.e.a;
/* compiled from: CompletableFromRunnable.java */
/* loaded from: classes.dex */
public final class s extends d.c.b {

    /* renamed from: a  reason: collision with root package name */
    public final Runnable f4767a;

    public s(Runnable runnable) {
        this.f4767a = runnable;
    }

    @Override // d.c.b
    public void subscribeActual(d.c.d dVar) {
        d.c.c0.b b2 = d.c.c0.c.b();
        dVar.a(b2);
        try {
            this.f4767a.run();
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
