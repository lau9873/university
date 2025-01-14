package p070c.p084d.p085a.p086a.p104j;

import java.util.concurrent.Executor;

/* renamed from: c.d.a.a.j.f */
/* loaded from: classes.dex */
public final class C1241f<TResult> implements InterfaceC1245j<TResult> {

    /* renamed from: a */
    public final Executor f5626a;

    /* renamed from: b */
    public final Object f5627b = new Object();

    /* renamed from: c */
    public InterfaceC1235a<TResult> f5628c;

    public C1241f(Executor executor, InterfaceC1235a<TResult> interfaceC1235a) {
        this.f5626a = executor;
        this.f5628c = interfaceC1235a;
    }

    @Override // p070c.p084d.p085a.p086a.p104j.InterfaceC1245j
    public final void cancel() {
        synchronized (this.f5627b) {
            this.f5628c = null;
        }
    }

    @Override // p070c.p084d.p085a.p086a.p104j.InterfaceC1245j
    public final void onComplete(AbstractC1237c<TResult> abstractC1237c) {
        synchronized (this.f5627b) {
            if (this.f5628c == null) {
                return;
            }
            this.f5626a.execute(new RunnableC1242g(this, abstractC1237c));
        }
    }
}
