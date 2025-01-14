package p000a.p001a.p002a.p003a;

import android.os.Handler;
import android.os.Looper;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/* renamed from: a.a.a.a.b */
/* loaded from: classes.dex */
public class DefaultTaskExecutor extends TaskExecutor {

    /* renamed from: a */
    public final Object f3a = new Object();

    /* renamed from: b */
    public ExecutorService f4b = Executors.newFixedThreadPool(2);

    /* renamed from: c */
    public volatile Handler f5c;

    @Override // p000a.p001a.p002a.p003a.TaskExecutor
    /* renamed from: a */
    public void mo11323a(Runnable runnable) {
        this.f4b.execute(runnable);
    }

    @Override // p000a.p001a.p002a.p003a.TaskExecutor
    /* renamed from: b */
    public void mo11322b(Runnable runnable) {
        if (this.f5c == null) {
            synchronized (this.f3a) {
                if (this.f5c == null) {
                    this.f5c = new Handler(Looper.getMainLooper());
                }
            }
        }
        this.f5c.post(runnable);
    }

    @Override // p000a.p001a.p002a.p003a.TaskExecutor
    /* renamed from: a */
    public boolean mo11324a() {
        return Looper.getMainLooper().getThread() == Thread.currentThread();
    }
}
