package p070c.p084d.p085a.p086a.p104j;

import android.app.Activity;
import com.google.android.gms.common.api.internal.LifecycleCallback;
import com.google.android.gms.tasks.RuntimeExecutionException;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executor;
import p070c.p084d.p085a.p086a.p093e.p094e.p095l.InterfaceC0935a1;
import p070c.p084d.p085a.p086a.p093e.p096f.C1049c0;

/* renamed from: c.d.a.a.j.m */
/* loaded from: classes.dex */
public final class C1248m<TResult> extends AbstractC1237c<TResult> {

    /* renamed from: a */
    public final Object f5639a = new Object();

    /* renamed from: b */
    public final C1246k<TResult> f5640b = new C1246k<>();

    /* renamed from: c */
    public boolean f5641c;

    /* renamed from: d */
    public TResult f5642d;

    /* renamed from: e */
    public Exception f5643e;

    /* renamed from: c.d.a.a.j.m$a */
    /* loaded from: classes.dex */
    public static class C1249a extends LifecycleCallback {

        /* renamed from: b */
        public final List<WeakReference<InterfaceC1245j<?>>> f5644b;

        public C1249a(InterfaceC0935a1 interfaceC0935a1) {
            super(interfaceC0935a1);
            this.f5644b = new ArrayList();
            this.f6131a.mo5379a("TaskOnStopCallback", this);
        }

        /* renamed from: b */
        public static C1249a m4956b(Activity activity) {
            InterfaceC0935a1 m4349a = LifecycleCallback.m4349a(activity);
            C1249a c1249a = (C1249a) m4349a.mo5377a("TaskOnStopCallback", C1249a.class);
            return c1249a == null ? new C1249a(m4349a) : c1249a;
        }

        /* renamed from: a */
        public final <T> void m4957a(InterfaceC1245j<T> interfaceC1245j) {
            synchronized (this.f5644b) {
                this.f5644b.add(new WeakReference<>(interfaceC1245j));
            }
        }

        @Override // com.google.android.gms.common.api.internal.LifecycleCallback
        /* renamed from: e */
        public final void mo4341e() {
            synchronized (this.f5644b) {
                for (WeakReference<InterfaceC1245j<?>> weakReference : this.f5644b) {
                    InterfaceC1245j<?> interfaceC1245j = weakReference.get();
                    if (interfaceC1245j != null) {
                        interfaceC1245j.cancel();
                    }
                }
                this.f5644b.clear();
            }
        }
    }

    @Override // p070c.p084d.p085a.p086a.p104j.AbstractC1237c
    /* renamed from: a */
    public final AbstractC1237c<TResult> mo4969a(Activity activity, InterfaceC1236b<? super TResult> interfaceC1236b) {
        C1243h c1243h = new C1243h(C1239e.f5624a, interfaceC1236b);
        this.f5640b.m4971a(c1243h);
        C1249a.m4956b(activity).m4957a(c1243h);
        m4958f();
        return this;
    }

    @Override // p070c.p084d.p085a.p086a.p104j.AbstractC1237c
    /* renamed from: a */
    public final AbstractC1237c<TResult> mo4968a(InterfaceC1235a<TResult> interfaceC1235a) {
        mo4965a(C1239e.f5624a, interfaceC1235a);
        return this;
    }

    @Override // p070c.p084d.p085a.p086a.p104j.AbstractC1237c
    /* renamed from: a */
    public final AbstractC1237c<TResult> mo4965a(Executor executor, InterfaceC1235a<TResult> interfaceC1235a) {
        this.f5640b.m4971a(new C1241f(executor, interfaceC1235a));
        m4958f();
        return this;
    }

    @Override // p070c.p084d.p085a.p086a.p104j.AbstractC1237c
    /* renamed from: a */
    public final Exception mo4970a() {
        Exception exc;
        synchronized (this.f5639a) {
            exc = this.f5643e;
        }
        return exc;
    }

    /* renamed from: a */
    public final void m4967a(Exception exc) {
        C1049c0.m5293a(exc, "Exception must not be null");
        synchronized (this.f5639a) {
            m4959e();
            this.f5641c = true;
            this.f5643e = exc;
        }
        this.f5640b.m4972a(this);
    }

    /* renamed from: a */
    public final void m4966a(TResult tresult) {
        synchronized (this.f5639a) {
            m4959e();
            this.f5641c = true;
            this.f5642d = tresult;
        }
        this.f5640b.m4972a(this);
    }

    @Override // p070c.p084d.p085a.p086a.p104j.AbstractC1237c
    /* renamed from: b */
    public final TResult mo4964b() {
        TResult tresult;
        synchronized (this.f5639a) {
            m4960d();
            if (this.f5643e != null) {
                throw new RuntimeExecutionException(this.f5643e);
            }
            tresult = this.f5642d;
        }
        return tresult;
    }

    /* renamed from: b */
    public final boolean m4963b(Exception exc) {
        C1049c0.m5293a(exc, "Exception must not be null");
        synchronized (this.f5639a) {
            if (this.f5641c) {
                return false;
            }
            this.f5641c = true;
            this.f5643e = exc;
            this.f5640b.m4972a(this);
            return true;
        }
    }

    /* renamed from: b */
    public final boolean m4962b(TResult tresult) {
        synchronized (this.f5639a) {
            if (this.f5641c) {
                return false;
            }
            this.f5641c = true;
            this.f5642d = tresult;
            this.f5640b.m4972a(this);
            return true;
        }
    }

    @Override // p070c.p084d.p085a.p086a.p104j.AbstractC1237c
    /* renamed from: c */
    public final boolean mo4961c() {
        boolean z;
        synchronized (this.f5639a) {
            z = this.f5641c && this.f5643e == null;
        }
        return z;
    }

    /* renamed from: d */
    public final void m4960d() {
        C1049c0.m5285b(this.f5641c, "Task is not yet complete");
    }

    /* renamed from: e */
    public final void m4959e() {
        C1049c0.m5285b(!this.f5641c, "Task is already complete");
    }

    /* renamed from: f */
    public final void m4958f() {
        synchronized (this.f5639a) {
            if (this.f5641c) {
                this.f5640b.m4972a(this);
            }
        }
    }
}
