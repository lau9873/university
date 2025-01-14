package p136d.p153c.p160f0.p165e.p170e;

import java.util.concurrent.atomic.AtomicInteger;
import p136d.p153c.Single;
import p136d.p153c.SingleObserver;
import p136d.p153c.SingleSource;
import p136d.p153c.p157c0.Disposable;
import p136d.p153c.p158d0.Exceptions;
import p136d.p153c.p159e0.Action;
import p136d.p153c.p160f0.p161a.DisposableHelper;
import p136d.p153c.p177h0.RxJavaPlugins;

/* renamed from: d.c.f0.e.e.m */
/* loaded from: classes.dex */
public final class SingleDoFinally<T> extends Single<T> {

    /* renamed from: a */
    public final SingleSource<T> f7492a;

    /* renamed from: b */
    public final Action f7493b;

    public SingleDoFinally(SingleSource<T> singleSource, Action action) {
        this.f7492a = singleSource;
        this.f7493b = action;
    }

    @Override // p136d.p153c.Single
    public void subscribeActual(SingleObserver<? super T> singleObserver) {
        this.f7492a.subscribe(new C1677a(singleObserver, this.f7493b));
    }

    /* compiled from: SingleDoFinally.java */
    /* renamed from: d.c.f0.e.e.m$a */
    /* loaded from: classes.dex */
    public static final class C1677a<T> extends AtomicInteger implements SingleObserver<T>, Disposable {

        /* renamed from: a */
        public final SingleObserver<? super T> f7494a;

        /* renamed from: b */
        public final Action f7495b;

        /* renamed from: c */
        public Disposable f7496c;

        public C1677a(SingleObserver<? super T> singleObserver, Action action) {
            this.f7494a = singleObserver;
            this.f7495b = action;
        }

        @Override // p136d.p153c.SingleObserver
        /* renamed from: a */
        public void mo3284a(Disposable disposable) {
            if (DisposableHelper.m3648a(this.f7496c, disposable)) {
                this.f7496c = disposable;
                this.f7494a.mo3284a(this);
            }
        }

        @Override // p136d.p153c.SingleObserver
        /* renamed from: b */
        public void mo3282b(T t) {
            this.f7494a.mo3282b(t);
            m3499a();
        }

        @Override // p136d.p153c.p157c0.Disposable
        /* renamed from: c */
        public boolean mo577c() {
            return this.f7496c.mo577c();
        }

        @Override // p136d.p153c.p157c0.Disposable
        /* renamed from: b */
        public void mo578b() {
            this.f7496c.mo578b();
            m3499a();
        }

        @Override // p136d.p153c.SingleObserver
        /* renamed from: a */
        public void mo3283a(Throwable th) {
            this.f7494a.mo3283a(th);
            m3499a();
        }

        /* renamed from: a */
        public void m3499a() {
            if (compareAndSet(0, 1)) {
                try {
                    this.f7495b.run();
                } catch (Throwable th) {
                    Exceptions.m3660b(th);
                    RxJavaPlugins.m3371b(th);
                }
            }
        }
    }
}
