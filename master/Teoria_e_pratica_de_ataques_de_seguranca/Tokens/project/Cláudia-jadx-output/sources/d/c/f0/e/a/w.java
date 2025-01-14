package d.c.f0.e.a;
/* compiled from: CompletableLift.java */
/* loaded from: classes.dex */
public final class w extends d.c.b {

    /* renamed from: a  reason: collision with root package name */
    public final d.c.g f4774a;

    /* renamed from: b  reason: collision with root package name */
    public final d.c.f f4775b;

    public w(d.c.g gVar, d.c.f fVar) {
        this.f4774a = gVar;
        this.f4775b = fVar;
    }

    @Override // d.c.b
    public void subscribeActual(d.c.d dVar) {
        try {
            this.f4774a.subscribe(this.f4775b.a(dVar));
        } catch (NullPointerException e2) {
            throw e2;
        } catch (Throwable th) {
            d.c.d0.a.b(th);
            d.c.h0.a.b(th);
        }
    }
}
