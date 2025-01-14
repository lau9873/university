package d.c.f0.d;
/* compiled from: SubscriberCompletableObserver.java */
/* loaded from: classes.dex */
public final class k<T> implements d.c.d, g.b.d {

    /* renamed from: a  reason: collision with root package name */
    public final g.b.c<? super T> f4623a;

    /* renamed from: b  reason: collision with root package name */
    public d.c.c0.b f4624b;

    public k(g.b.c<? super T> cVar) {
        this.f4623a = cVar;
    }

    @Override // d.c.d
    public void a() {
        this.f4623a.a();
    }

    @Override // g.b.d
    public void a(long j) {
    }

    @Override // g.b.d
    public void cancel() {
        this.f4624b.b();
    }

    @Override // d.c.d
    public void a(Throwable th) {
        this.f4623a.a(th);
    }

    @Override // d.c.d
    public void a(d.c.c0.b bVar) {
        if (d.c.f0.a.b.a(this.f4624b, bVar)) {
            this.f4624b = bVar;
            this.f4623a.a((g.b.d) this);
        }
    }
}
