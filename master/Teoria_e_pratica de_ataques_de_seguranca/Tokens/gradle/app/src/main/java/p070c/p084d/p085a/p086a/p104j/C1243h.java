package p070c.p084d.p085a.p086a.p104j;

import java.util.concurrent.Executor;

/* renamed from: c.d.a.a.j.h */
/* loaded from: classes.dex */
public final class C1243h<TResult> implements InterfaceC1245j<TResult> {

    /* renamed from: a */
    public final Executor f5631a;

    /* renamed from: b */
    public final Object f5632b = new Object();

    /* renamed from: c */
    public InterfaceC1236b<? super TResult> f5633c;

    public C1243h(Executor executor, InterfaceC1236b<? super TResult> interfaceC1236b) {
        this.f5631a = executor;
        this.f5633c = interfaceC1236b;
    }

    @Override // p070c.p084d.p085a.p086a.p104j.InterfaceC1245j
    public final void cancel() {
        synchronized (this.f5632b) {
            this.f5633c = null;
        }
    }

    @Override // p070c.p084d.p085a.p086a.p104j.InterfaceC1245j
    public final void onComplete(AbstractC1237c<TResult> abstractC1237c) {
        if (abstractC1237c.mo4961c()) {
            synchronized (this.f5632b) {
                if (this.f5633c == null) {
                    return;
                }
                this.f5631a.execute(new RunnableC1244i(this, abstractC1237c));
            }
        }
    }
}
