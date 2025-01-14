package p070c.p084d.p085a.p086a.p104j;

/* renamed from: c.d.a.a.j.i */
/* loaded from: classes.dex */
public final class RunnableC1244i implements Runnable {

    /* renamed from: a */
    public /* synthetic */ AbstractC1237c f5634a;

    /* renamed from: b */
    public /* synthetic */ C1243h f5635b;

    public RunnableC1244i(C1243h c1243h, AbstractC1237c abstractC1237c) {
        this.f5635b = c1243h;
        this.f5634a = abstractC1237c;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Object obj;
        InterfaceC1236b interfaceC1236b;
        InterfaceC1236b interfaceC1236b2;
        obj = this.f5635b.f5632b;
        synchronized (obj) {
            interfaceC1236b = this.f5635b.f5633c;
            if (interfaceC1236b != null) {
                interfaceC1236b2 = this.f5635b.f5633c;
                interfaceC1236b2.mo781b(this.f5634a.mo4964b());
            }
        }
    }
}
