package p136d.p153c.p157c0;

import java.util.concurrent.Future;
import java.util.concurrent.atomic.AtomicReference;

/* renamed from: d.c.c0.d */
/* loaded from: classes.dex */
public final class FutureDisposable extends AtomicReference<Future<?>> implements Disposable {

    /* renamed from: a */
    public final boolean f6872a;

    public FutureDisposable(Future<?> future, boolean z) {
        super(future);
        this.f6872a = z;
    }

    @Override // p136d.p153c.p157c0.Disposable
    /* renamed from: b */
    public void mo578b() {
        Future<?> andSet = getAndSet(null);
        if (andSet != null) {
            andSet.cancel(this.f6872a);
        }
    }

    @Override // p136d.p153c.p157c0.Disposable
    /* renamed from: c */
    public boolean mo577c() {
        Future<?> future = get();
        return future == null || future.isDone();
    }
}
