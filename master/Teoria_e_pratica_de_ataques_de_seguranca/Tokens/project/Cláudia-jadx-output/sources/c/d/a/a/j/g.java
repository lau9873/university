package c.d.a.a.j;
/* loaded from: classes.dex */
public final class g implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public /* synthetic */ c f3686a;

    /* renamed from: b  reason: collision with root package name */
    public /* synthetic */ f f3687b;

    public g(f fVar, c cVar) {
        this.f3687b = fVar;
        this.f3686a = cVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Object obj;
        a aVar;
        a aVar2;
        obj = this.f3687b.f3684b;
        synchronized (obj) {
            aVar = this.f3687b.f3685c;
            if (aVar != null) {
                aVar2 = this.f3687b.f3685c;
                aVar2.onComplete(this.f3686a);
            }
        }
    }
}
