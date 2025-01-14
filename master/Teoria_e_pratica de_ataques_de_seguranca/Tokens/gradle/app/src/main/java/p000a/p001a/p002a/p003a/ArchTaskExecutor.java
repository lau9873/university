package p000a.p001a.p002a.p003a;

import java.util.concurrent.Executor;

/* renamed from: a.a.a.a.a */
/* loaded from: classes.dex */
public class ArchTaskExecutor extends TaskExecutor {

    /* renamed from: c */
    public static volatile ArchTaskExecutor f0c;

    /* renamed from: b */
    public TaskExecutor f2b = new DefaultTaskExecutor();

    /* renamed from: a */
    public TaskExecutor f1a = this.f2b;

    /* compiled from: ArchTaskExecutor.java */
    /* renamed from: a.a.a.a.a$a */
    /* loaded from: classes.dex */
    public static class ExecutorC0000a implements Executor {
        @Override // java.util.concurrent.Executor
        public void execute(Runnable runnable) {
            ArchTaskExecutor.m11325b().mo11322b(runnable);
        }
    }

    /* compiled from: ArchTaskExecutor.java */
    /* renamed from: a.a.a.a.a$b */
    /* loaded from: classes.dex */
    public static class ExecutorC0001b implements Executor {
        @Override // java.util.concurrent.Executor
        public void execute(Runnable runnable) {
            ArchTaskExecutor.m11325b().mo11323a(runnable);
        }
    }

    static {
        new ExecutorC0000a();
        new ExecutorC0001b();
    }

    /* renamed from: b */
    public static ArchTaskExecutor m11325b() {
        if (f0c != null) {
            return f0c;
        }
        synchronized (ArchTaskExecutor.class) {
            if (f0c == null) {
                f0c = new ArchTaskExecutor();
            }
        }
        return f0c;
    }

    @Override // p000a.p001a.p002a.p003a.TaskExecutor
    /* renamed from: a */
    public void mo11323a(Runnable runnable) {
        this.f1a.mo11323a(runnable);
    }

    @Override // p000a.p001a.p002a.p003a.TaskExecutor
    /* renamed from: a */
    public boolean mo11324a() {
        return this.f1a.mo11324a();
    }

    @Override // p000a.p001a.p002a.p003a.TaskExecutor
    /* renamed from: b */
    public void mo11322b(Runnable runnable) {
        this.f1a.mo11322b(runnable);
    }
}
