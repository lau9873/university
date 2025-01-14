package d.a.a.a.m.c;

import d.a.a.a.m.c.a;
import java.util.Collection;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
/* compiled from: PriorityAsyncTask.java */
/* loaded from: classes.dex */
public abstract class g<Params, Progress, Result> extends d.a.a.a.m.c.a<Params, Progress, Result> implements c<m>, j, m, b {
    public final k o = new k();

    /* compiled from: PriorityAsyncTask.java */
    /* loaded from: classes.dex */
    public static class a<Result> implements Executor {

        /* renamed from: a  reason: collision with root package name */
        public final Executor f4341a;

        /* renamed from: b  reason: collision with root package name */
        public final g f4342b;

        /* compiled from: PriorityAsyncTask.java */
        /* renamed from: d.a.a.a.m.c.g$a$a  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        public class C0090a extends i<Result> {
            public C0090a(Runnable runnable, Object obj) {
                super(runnable, obj);
            }

            /* JADX WARN: Incorrect return type in method signature: <T::Ld/a/a/a/m/c/c<Ld/a/a/a/m/c/m;>;:Ld/a/a/a/m/c/j;:Ld/a/a/a/m/c/m;>()TT; */
            @Override // d.a.a.a.m.c.i
            public c e() {
                return a.this.f4342b;
            }
        }

        public a(Executor executor, g gVar) {
            this.f4341a = executor;
            this.f4342b = gVar;
        }

        @Override // java.util.concurrent.Executor
        public void execute(Runnable runnable) {
            this.f4341a.execute(new C0090a(runnable, null));
        }
    }

    @Override // d.a.a.a.m.c.m
    public boolean b() {
        return ((m) ((j) h())).b();
    }

    @Override // d.a.a.a.m.c.c
    public boolean c() {
        return ((c) ((j) h())).c();
    }

    @Override // java.lang.Comparable
    public int compareTo(Object obj) {
        return f.a(this, obj);
    }

    @Override // d.a.a.a.m.c.c
    public Collection<m> d() {
        return ((c) ((j) h())).d();
    }

    /* JADX WARN: Incorrect return type in method signature: <T::Ld/a/a/a/m/c/c<Ld/a/a/a/m/c/m;>;:Ld/a/a/a/m/c/j;:Ld/a/a/a/m/c/m;>()TT; */
    public c h() {
        return this.o;
    }

    public final void a(ExecutorService executorService, Params... paramsArr) {
        super.a(new a(executorService, this), paramsArr);
    }

    @Override // d.a.a.a.m.c.c
    public void a(m mVar) {
        if (e() == a.h.PENDING) {
            ((c) ((j) h())).a(mVar);
            return;
        }
        throw new IllegalStateException("Must not add Dependency after task is running");
    }

    @Override // d.a.a.a.m.c.m
    public void a(boolean z) {
        ((m) ((j) h())).a(z);
    }

    @Override // d.a.a.a.m.c.m
    public void a(Throwable th) {
        ((m) ((j) h())).a(th);
    }
}
