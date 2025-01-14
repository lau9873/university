package p070c.p084d.p085a.p086a.p104j;

import android.os.Handler;
import android.os.Looper;
import java.util.concurrent.Executor;

/* renamed from: c.d.a.a.j.e */
/* loaded from: classes.dex */
public final class C1239e {

    /* renamed from: a */
    public static final Executor f5624a = new ExecutorC1240a();

    /* renamed from: c.d.a.a.j.e$a */
    /* loaded from: classes.dex */
    public static final class ExecutorC1240a implements Executor {

        /* renamed from: a */
        public final Handler f5625a = new Handler(Looper.getMainLooper());

        @Override // java.util.concurrent.Executor
        public final void execute(Runnable runnable) {
            this.f5625a.post(runnable);
        }
    }

    static {
        new ExecutorC1247l();
    }
}
