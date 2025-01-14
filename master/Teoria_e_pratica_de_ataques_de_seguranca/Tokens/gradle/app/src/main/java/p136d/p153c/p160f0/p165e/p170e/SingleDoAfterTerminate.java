package p136d.p153c.p160f0.p165e.p170e;

import p136d.p153c.Single;
import p136d.p153c.SingleObserver;
import p136d.p153c.SingleSource;
import p136d.p153c.p157c0.Disposable;
import p136d.p153c.p158d0.Exceptions;
import p136d.p153c.p159e0.Action;
import p136d.p153c.p160f0.p161a.DisposableHelper;
import p136d.p153c.p177h0.RxJavaPlugins;

/* renamed from: d.c.f0.e.e.l */
/* loaded from: classes.dex */
public final class SingleDoAfterTerminate<T> extends Single<T> {

    /* renamed from: a */
    public final SingleSource<T> f7482a;

    /* renamed from: b */
    public final Action f7483b;

    public SingleDoAfterTerminate(SingleSource<T> singleSource, Action action) {
        this.f7482a = singleSource;
        this.f7483b = action;
    }

    @Override // p136d.p153c.Single
    public void subscribeActual(SingleObserver<? super T> singleObserver) {
        this.f7482a.subscribe(new C1675a(singleObserver, this.f7483b));
    }

    /* compiled from: SingleDoAfterTerminate.java */
    /* renamed from: d.c.f0.e.e.l$a */
    /* loaded from: classes.dex */
    public static final class C1675a<T> implements SingleObserver<T>, Disposable {

        /* renamed from: a */
        public final SingleObserver<? super T> f7484a;

        /* renamed from: b */
        public final Action f7485b;

        /* renamed from: c */
        public Disposable f7486c;

        public C1675a(SingleObserver<? super T> singleObserver, Action action) {
            this.f7484a = singleObserver;
            this.f7485b = action;
        }

        @Override // p136d.p153c.SingleObserver
        /* renamed from: a */
        public void mo3284a(Disposable disposable) {
            if (DisposableHelper.m3648a(this.f7486c, disposable)) {
                this.f7486c = disposable;
                this.f7484a.mo3284a(this);
            }
        }

        @Override // p136d.p153c.SingleObserver
        /* renamed from: b */
        public void mo3282b(T t) {
            this.f7484a.mo3282b(t);
            m3500a();
        }

        @Override // p136d.p153c.p157c0.Disposable
        /* renamed from: c */
        public boolean mo577c() {
            return this.f7486c.mo577c();
        }

        @Override // p136d.p153c.p157c0.Disposable
        /* renamed from: b */
        public void mo578b() {
            this.f7486c.mo578b();
        }

        @Override // p136d.p153c.SingleObserver
        /* renamed from: a */
        public void mo3283a(Throwable th) {
            this.f7484a.mo3283a(th);
            m3500a();
        }

        /* renamed from: a */
        public final void m3500a() {
            try {
                this.f7485b.run();
            } catch (Throwable th) {
                Exceptions.m3660b(th);
                RxJavaPlugins.m3371b(th);
            }
        }
    }
}
