package p136d.p137a.p138a.p139a.p140m.p143c;

import java.util.Collection;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import p136d.p137a.p138a.p139a.p140m.p143c.AsyncTask;

/* renamed from: d.a.a.a.m.c.g */
/* loaded from: classes.dex */
public abstract class PriorityAsyncTask<Params, Progress, Result> extends AsyncTask<Params, Progress, Result> implements Dependency<Task>, PriorityProvider, Task, DelegateProvider {

    /* renamed from: o */
    public final PriorityTask f6544o = new PriorityTask();

    /* compiled from: PriorityAsyncTask.java */
    /* renamed from: d.a.a.a.m.c.g$a */
    /* loaded from: classes.dex */
    public static class ExecutorC1513a<Result> implements Executor {

        /* renamed from: a */
        public final Executor f6545a;

        /* renamed from: b */
        public final PriorityAsyncTask f6546b;

        /* compiled from: PriorityAsyncTask.java */
        /* renamed from: d.a.a.a.m.c.g$a$a */
        /* loaded from: classes.dex */
        public class C1514a extends PriorityFutureTask<Result> {
            public C1514a(Runnable runnable, Object obj) {
                super(runnable, obj);
            }

            /* JADX WARN: Incorrect return type in method signature: <T::Ld/a/a/a/m/c/c<Ld/a/a/a/m/c/m;>;:Ld/a/a/a/m/c/j;:Ld/a/a/a/m/c/m;>()TT; */
            @Override // p136d.p137a.p138a.p139a.p140m.p143c.PriorityFutureTask
            /* renamed from: e */
            public Dependency mo3973e() {
                return ExecutorC1513a.this.f6546b;
            }
        }

        public ExecutorC1513a(Executor executor, PriorityAsyncTask priorityAsyncTask) {
            this.f6545a = executor;
            this.f6546b = priorityAsyncTask;
        }

        @Override // java.util.concurrent.Executor
        public void execute(Runnable runnable) {
            this.f6545a.execute(new C1514a(runnable, null));
        }
    }

    @Override // p136d.p137a.p138a.p139a.p140m.p143c.Task
    /* renamed from: b */
    public boolean mo3962b() {
        return ((Task) ((PriorityProvider) m3977h())).mo3962b();
    }

    @Override // p136d.p137a.p138a.p139a.p140m.p143c.Dependency
    /* renamed from: c */
    public boolean mo3968c() {
        return ((Dependency) ((PriorityProvider) m3977h())).mo3968c();
    }

    @Override // java.lang.Comparable
    public int compareTo(Object obj) {
        return Priority.m3980a(this, obj);
    }

    @Override // p136d.p137a.p138a.p139a.p140m.p143c.Dependency
    /* renamed from: d */
    public Collection<Task> mo3967d() {
        return ((Dependency) ((PriorityProvider) m3977h())).mo3967d();
    }

    /* JADX WARN: Incorrect return type in method signature: <T::Ld/a/a/a/m/c/c<Ld/a/a/a/m/c/m;>;:Ld/a/a/a/m/c/j;:Ld/a/a/a/m/c/m;>()TT; */
    /* renamed from: h */
    public Dependency m3977h() {
        return this.f6544o;
    }

    /* renamed from: a */
    public final void m3978a(ExecutorService executorService, Params... paramsArr) {
        super.m4001a(new ExecutorC1513a(executorService, this), paramsArr);
    }

    @Override // p136d.p137a.p138a.p139a.p140m.p143c.Dependency
    /* renamed from: a  reason: avoid collision after fix types in other method */
    public void mo3970a(Task task) {
        if (m3992e() == AsyncTask.EnumC1511h.PENDING) {
            ((Dependency) ((PriorityProvider) m3977h())).mo3970a(task);
            return;
        }
        throw new IllegalStateException("Must not add Dependency after task is running");
    }

    @Override // p136d.p137a.p138a.p139a.p140m.p143c.Task
    /* renamed from: a */
    public void mo3963a(boolean z) {
        ((Task) ((PriorityProvider) m3977h())).mo3963a(z);
    }

    @Override // p136d.p137a.p138a.p139a.p140m.p143c.Task
    /* renamed from: a */
    public void mo3964a(Throwable th) {
        ((Task) ((PriorityProvider) m3977h())).mo3964a(th);
    }
}
