package p136d.p153c.p160f0.p165e.p170e;

import p136d.p153c.Single;
import p136d.p153c.SingleObserver;
import p136d.p153c.SingleSource;
import p136d.p153c.p157c0.Disposable;
import p136d.p153c.p158d0.Exceptions;
import p136d.p153c.p159e0.Consumer;
import p136d.p153c.p160f0.p161a.DisposableHelper;
import p136d.p153c.p177h0.RxJavaPlugins;

/* renamed from: d.c.f0.e.e.k */
/* loaded from: classes.dex */
public final class SingleDoAfterSuccess<T> extends Single<T> {

    /* renamed from: a */
    public final SingleSource<T> f7473a;

    /* renamed from: b */
    public final Consumer<? super T> f7474b;

    public SingleDoAfterSuccess(SingleSource<T> singleSource, Consumer<? super T> consumer) {
        this.f7473a = singleSource;
        this.f7474b = consumer;
    }

    @Override // p136d.p153c.Single
    public void subscribeActual(SingleObserver<? super T> singleObserver) {
        this.f7473a.subscribe(new C1673a(singleObserver, this.f7474b));
    }

    /* compiled from: SingleDoAfterSuccess.java */
    /* renamed from: d.c.f0.e.e.k$a */
    /* loaded from: classes.dex */
    public static final class C1673a<T> implements SingleObserver<T>, Disposable {

        /* renamed from: a */
        public final SingleObserver<? super T> f7475a;

        /* renamed from: b */
        public final Consumer<? super T> f7476b;

        /* renamed from: c */
        public Disposable f7477c;

        public C1673a(SingleObserver<? super T> singleObserver, Consumer<? super T> consumer) {
            this.f7475a = singleObserver;
            this.f7476b = consumer;
        }

        @Override // p136d.p153c.SingleObserver
        /* renamed from: a */
        public void mo3284a(Disposable disposable) {
            if (DisposableHelper.m3648a(this.f7477c, disposable)) {
                this.f7477c = disposable;
                this.f7475a.mo3284a(this);
            }
        }

        @Override // p136d.p153c.SingleObserver
        /* renamed from: b */
        public void mo3282b(T t) {
            this.f7475a.mo3282b(t);
            try {
                this.f7476b.accept(t);
            } catch (Throwable th) {
                Exceptions.m3660b(th);
                RxJavaPlugins.m3371b(th);
            }
        }

        @Override // p136d.p153c.p157c0.Disposable
        /* renamed from: c */
        public boolean mo577c() {
            return this.f7477c.mo577c();
        }

        @Override // p136d.p153c.SingleObserver
        /* renamed from: a */
        public void mo3283a(Throwable th) {
            this.f7475a.mo3283a(th);
        }

        @Override // p136d.p153c.p157c0.Disposable
        /* renamed from: b */
        public void mo578b() {
            this.f7477c.mo578b();
        }
    }
}
