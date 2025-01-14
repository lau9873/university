package p070c.p084d.p085a.p086a.p104j;

/* renamed from: c.d.a.a.j.g */
/* loaded from: classes.dex */
public final class RunnableC1242g implements Runnable {

    /* renamed from: a */
    public /* synthetic */ AbstractC1237c f5629a;

    /* renamed from: b */
    public /* synthetic */ C1241f f5630b;

    public RunnableC1242g(C1241f c1241f, AbstractC1237c abstractC1237c) {
        this.f5630b = c1241f;
        this.f5629a = abstractC1237c;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Object obj;
        InterfaceC1235a interfaceC1235a;
        InterfaceC1235a interfaceC1235a2;
        obj = this.f5630b.f5627b;
        synchronized (obj) {
            interfaceC1235a = this.f5630b.f5628c;
            if (interfaceC1235a != null) {
                interfaceC1235a2 = this.f5630b.f5628c;
                interfaceC1235a2.onComplete(this.f5629a);
            }
        }
    }
}
