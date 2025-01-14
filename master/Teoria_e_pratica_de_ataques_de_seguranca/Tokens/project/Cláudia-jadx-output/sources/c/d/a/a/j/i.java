package c.d.a.a.j;
/* loaded from: classes.dex */
public final class i implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public /* synthetic */ c f3691a;

    /* renamed from: b  reason: collision with root package name */
    public /* synthetic */ h f3692b;

    public i(h hVar, c cVar) {
        this.f3692b = hVar;
        this.f3691a = cVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Object obj;
        b bVar;
        b bVar2;
        obj = this.f3692b.f3689b;
        synchronized (obj) {
            bVar = this.f3692b.f3690c;
            if (bVar != null) {
                bVar2 = this.f3692b.f3690c;
                bVar2.b(this.f3691a.b());
            }
        }
    }
}
