package a.a.a.a;

import android.os.Handler;
import android.os.Looper;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
/* compiled from: DefaultTaskExecutor.java */
/* loaded from: classes.dex */
public class b extends c {

    /* renamed from: a  reason: collision with root package name */
    public final Object f4a = new Object();

    /* renamed from: b  reason: collision with root package name */
    public ExecutorService f5b = Executors.newFixedThreadPool(2);

    /* renamed from: c  reason: collision with root package name */
    public volatile Handler f6c;

    @Override // a.a.a.a.c
    public void a(Runnable runnable) {
        this.f5b.execute(runnable);
    }

    @Override // a.a.a.a.c
    public void b(Runnable runnable) {
        if (this.f6c == null) {
            synchronized (this.f4a) {
                if (this.f6c == null) {
                    this.f6c = new Handler(Looper.getMainLooper());
                }
            }
        }
        this.f6c.post(runnable);
    }

    @Override // a.a.a.a.c
    public boolean a() {
        return Looper.getMainLooper().getThread() == Thread.currentThread();
    }
}
