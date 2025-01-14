package c.d.a.a.j;

import android.os.Handler;
import android.os.Looper;
import java.util.concurrent.Executor;
/* loaded from: classes.dex */
public final class e {

    /* renamed from: a  reason: collision with root package name */
    public static final Executor f3681a = new a();

    /* loaded from: classes.dex */
    public static final class a implements Executor {

        /* renamed from: a  reason: collision with root package name */
        public final Handler f3682a = new Handler(Looper.getMainLooper());

        @Override // java.util.concurrent.Executor
        public final void execute(Runnable runnable) {
            this.f3682a.post(runnable);
        }
    }

    static {
        new l();
    }
}
