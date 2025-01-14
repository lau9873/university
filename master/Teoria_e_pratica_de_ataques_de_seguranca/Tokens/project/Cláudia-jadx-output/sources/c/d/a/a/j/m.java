package c.d.a.a.j;

import android.app.Activity;
import c.d.a.a.e.e.l.a1;
import c.d.a.a.e.f.c0;
import com.google.android.gms.common.api.internal.LifecycleCallback;
import com.google.android.gms.tasks.RuntimeExecutionException;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executor;
/* loaded from: classes.dex */
public final class m<TResult> extends c<TResult> {

    /* renamed from: a  reason: collision with root package name */
    public final Object f3696a = new Object();

    /* renamed from: b  reason: collision with root package name */
    public final k<TResult> f3697b = new k<>();

    /* renamed from: c  reason: collision with root package name */
    public boolean f3698c;

    /* renamed from: d  reason: collision with root package name */
    public TResult f3699d;

    /* renamed from: e  reason: collision with root package name */
    public Exception f3700e;

    /* loaded from: classes.dex */
    public static class a extends LifecycleCallback {

        /* renamed from: b  reason: collision with root package name */
        public final List<WeakReference<j<?>>> f3701b;

        public a(a1 a1Var) {
            super(a1Var);
            this.f3701b = new ArrayList();
            this.f4085a.a("TaskOnStopCallback", this);
        }

        public static a b(Activity activity) {
            a1 a2 = LifecycleCallback.a(activity);
            a aVar = (a) a2.a("TaskOnStopCallback", a.class);
            return aVar == null ? new a(a2) : aVar;
        }

        public final <T> void a(j<T> jVar) {
            synchronized (this.f3701b) {
                this.f3701b.add(new WeakReference<>(jVar));
            }
        }

        @Override // com.google.android.gms.common.api.internal.LifecycleCallback
        public final void e() {
            synchronized (this.f3701b) {
                for (WeakReference<j<?>> weakReference : this.f3701b) {
                    j<?> jVar = weakReference.get();
                    if (jVar != null) {
                        jVar.cancel();
                    }
                }
                this.f3701b.clear();
            }
        }
    }

    @Override // c.d.a.a.j.c
    public final c<TResult> a(Activity activity, b<? super TResult> bVar) {
        h hVar = new h(e.f3681a, bVar);
        this.f3697b.a(hVar);
        a.b(activity).a(hVar);
        f();
        return this;
    }

    @Override // c.d.a.a.j.c
    public final c<TResult> a(c.d.a.a.j.a<TResult> aVar) {
        a(e.f3681a, aVar);
        return this;
    }

    @Override // c.d.a.a.j.c
    public final c<TResult> a(Executor executor, c.d.a.a.j.a<TResult> aVar) {
        this.f3697b.a(new f(executor, aVar));
        f();
        return this;
    }

    @Override // c.d.a.a.j.c
    public final Exception a() {
        Exception exc;
        synchronized (this.f3696a) {
            exc = this.f3700e;
        }
        return exc;
    }

    public final void a(Exception exc) {
        c0.a(exc, "Exception must not be null");
        synchronized (this.f3696a) {
            e();
            this.f3698c = true;
            this.f3700e = exc;
        }
        this.f3697b.a(this);
    }

    public final void a(TResult tresult) {
        synchronized (this.f3696a) {
            e();
            this.f3698c = true;
            this.f3699d = tresult;
        }
        this.f3697b.a(this);
    }

    @Override // c.d.a.a.j.c
    public final TResult b() {
        TResult tresult;
        synchronized (this.f3696a) {
            d();
            if (this.f3700e != null) {
                throw new RuntimeExecutionException(this.f3700e);
            }
            tresult = this.f3699d;
        }
        return tresult;
    }

    public final boolean b(Exception exc) {
        c0.a(exc, "Exception must not be null");
        synchronized (this.f3696a) {
            if (this.f3698c) {
                return false;
            }
            this.f3698c = true;
            this.f3700e = exc;
            this.f3697b.a(this);
            return true;
        }
    }

    public final boolean b(TResult tresult) {
        synchronized (this.f3696a) {
            if (this.f3698c) {
                return false;
            }
            this.f3698c = true;
            this.f3699d = tresult;
            this.f3697b.a(this);
            return true;
        }
    }

    @Override // c.d.a.a.j.c
    public final boolean c() {
        boolean z;
        synchronized (this.f3696a) {
            z = this.f3698c && this.f3700e == null;
        }
        return z;
    }

    public final void d() {
        c0.b(this.f3698c, "Task is not yet complete");
    }

    public final void e() {
        c0.b(!this.f3698c, "Task is already complete");
    }

    public final void f() {
        synchronized (this.f3696a) {
            if (this.f3698c) {
                this.f3697b.a(this);
            }
        }
    }
}
