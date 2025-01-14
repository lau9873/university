package c.d.a.a.j;

import java.util.concurrent.Executor;
/* loaded from: classes.dex */
public final class h<TResult> implements j<TResult> {

    /* renamed from: a  reason: collision with root package name */
    public final Executor f3688a;

    /* renamed from: b  reason: collision with root package name */
    public final Object f3689b = new Object();

    /* renamed from: c  reason: collision with root package name */
    public b<? super TResult> f3690c;

    public h(Executor executor, b<? super TResult> bVar) {
        this.f3688a = executor;
        this.f3690c = bVar;
    }

    @Override // c.d.a.a.j.j
    public final void cancel() {
        synchronized (this.f3689b) {
            this.f3690c = null;
        }
    }

    @Override // c.d.a.a.j.j
    public final void onComplete(c<TResult> cVar) {
        if (cVar.c()) {
            synchronized (this.f3689b) {
                if (this.f3690c == null) {
                    return;
                }
                this.f3688a.execute(new i(this, cVar));
            }
        }
    }
}
