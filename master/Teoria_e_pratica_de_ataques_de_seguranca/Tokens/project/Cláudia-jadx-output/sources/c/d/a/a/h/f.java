package c.d.a.a.h;

import android.os.Handler;
import android.os.Looper;
import java.util.concurrent.Executor;
/* loaded from: classes.dex */
public final class f implements Executor {

    /* renamed from: a  reason: collision with root package name */
    public final Handler f3598a;

    public f(Looper looper) {
        this.f3598a = new Handler(looper);
    }

    @Override // java.util.concurrent.Executor
    public final void execute(Runnable runnable) {
        this.f3598a.post(runnable);
    }
}
