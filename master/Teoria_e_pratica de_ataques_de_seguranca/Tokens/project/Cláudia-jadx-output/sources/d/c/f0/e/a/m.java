package d.c.f0.e.a;
/* compiled from: CompletableError.java */
/* loaded from: classes.dex */
public final class m extends d.c.b {

    /* renamed from: a  reason: collision with root package name */
    public final Throwable f4745a;

    public m(Throwable th) {
        this.f4745a = th;
    }

    @Override // d.c.b
    public void subscribeActual(d.c.d dVar) {
        d.c.f0.a.c.a(this.f4745a, dVar);
    }
}
