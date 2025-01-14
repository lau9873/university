package p070c.p084d.p085a.p086a.p102h;

import android.os.Handler;
import android.os.Looper;
import java.util.concurrent.Executor;

/* renamed from: c.d.a.a.h.f */
/* loaded from: classes.dex */
public final class ExecutorC1149f implements Executor {

    /* renamed from: a */
    public final Handler f5531a;

    public ExecutorC1149f(Looper looper) {
        this.f5531a = new Handler(looper);
    }

    @Override // java.util.concurrent.Executor
    public final void execute(Runnable runnable) {
        this.f5531a.post(runnable);
    }
}
