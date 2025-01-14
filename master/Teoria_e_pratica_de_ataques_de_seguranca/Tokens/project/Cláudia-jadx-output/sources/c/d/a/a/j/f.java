package c.d.a.a.j;

import java.util.concurrent.Executor;
/* loaded from: classes.dex */
public final class f<TResult> implements j<TResult> {

    /* renamed from: a  reason: collision with root package name */
    public final Executor f3683a;

    /* renamed from: b  reason: collision with root package name */
    public final Object f3684b = new Object();

    /* renamed from: c  reason: collision with root package name */
    public a<TResult> f3685c;

    public f(Executor executor, a<TResult> aVar) {
        this.f3683a = executor;
        this.f3685c = aVar;
    }

    @Override // c.d.a.a.j.j
    public final void cancel() {
        synchronized (this.f3684b) {
            this.f3685c = null;
        }
    }

    @Override // c.d.a.a.j.j
    public final void onComplete(c<TResult> cVar) {
        synchronized (this.f3684b) {
            if (this.f3685c == null) {
                return;
            }
            this.f3683a.execute(new g(this, cVar));
        }
    }
}
