package a.a.a.a;

import java.util.concurrent.Executor;
/* compiled from: ArchTaskExecutor.java */
/* loaded from: classes.dex */
public class a extends c {

    /* renamed from: c  reason: collision with root package name */
    public static volatile a f1c;

    /* renamed from: b  reason: collision with root package name */
    public c f3b = new a.a.a.a.b();

    /* renamed from: a  reason: collision with root package name */
    public c f2a = this.f3b;

    /* compiled from: ArchTaskExecutor.java */
    /* renamed from: a.a.a.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class ExecutorC0000a implements Executor {
        @Override // java.util.concurrent.Executor
        public void execute(Runnable runnable) {
            a.b().b(runnable);
        }
    }

    /* compiled from: ArchTaskExecutor.java */
    /* loaded from: classes.dex */
    public static class b implements Executor {
        @Override // java.util.concurrent.Executor
        public void execute(Runnable runnable) {
            a.b().a(runnable);
        }
    }

    static {
        new ExecutorC0000a();
        new b();
    }

    public static a b() {
        if (f1c != null) {
            return f1c;
        }
        synchronized (a.class) {
            if (f1c == null) {
                f1c = new a();
            }
        }
        return f1c;
    }

    @Override // a.a.a.a.c
    public void a(Runnable runnable) {
        this.f2a.a(runnable);
    }

    @Override // a.a.a.a.c
    public boolean a() {
        return this.f2a.a();
    }

    @Override // a.a.a.a.c
    public void b(Runnable runnable) {
        this.f2a.b(runnable);
    }
}
