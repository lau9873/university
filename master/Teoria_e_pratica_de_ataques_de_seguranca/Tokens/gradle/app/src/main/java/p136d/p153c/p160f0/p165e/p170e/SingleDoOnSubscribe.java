package p136d.p153c.p160f0.p165e.p170e;

import p136d.p153c.Single;
import p136d.p153c.SingleObserver;
import p136d.p153c.SingleSource;
import p136d.p153c.p157c0.Disposable;
import p136d.p153c.p158d0.Exceptions;
import p136d.p153c.p159e0.Consumer;
import p136d.p153c.p160f0.p161a.EmptyDisposable;
import p136d.p153c.p177h0.RxJavaPlugins;

/* renamed from: d.c.f0.e.e.q */
/* loaded from: classes.dex */
public final class SingleDoOnSubscribe<T> extends Single<T> {

    /* renamed from: a */
    public final SingleSource<T> f7533a;

    /* renamed from: b */
    public final Consumer<? super Disposable> f7534b;

    public SingleDoOnSubscribe(SingleSource<T> singleSource, Consumer<? super Disposable> consumer) {
        this.f7533a = singleSource;
        this.f7534b = consumer;
    }

    @Override // p136d.p153c.Single
    public void subscribeActual(SingleObserver<? super T> singleObserver) {
        this.f7533a.subscribe(new C1688a(singleObserver, this.f7534b));
    }

    /* compiled from: SingleDoOnSubscribe.java */
    /* renamed from: d.c.f0.e.e.q$a */
    /* loaded from: classes.dex */
    public static final class C1688a<T> implements SingleObserver<T> {

        /* renamed from: a */
        public final SingleObserver<? super T> f7535a;

        /* renamed from: b */
        public final Consumer<? super Disposable> f7536b;

        /* renamed from: c */
        public boolean f7537c;

        public C1688a(SingleObserver<? super T> singleObserver, Consumer<? super Disposable> consumer) {
            this.f7535a = singleObserver;
            this.f7536b = consumer;
        }

        @Override // p136d.p153c.SingleObserver
        /* renamed from: a */
        public void mo3284a(Disposable disposable) {
            try {
                this.f7536b.accept(disposable);
                this.f7535a.mo3284a(disposable);
            } catch (Throwable th) {
                Exceptions.m3660b(th);
                this.f7537c = true;
                disposable.mo578b();
                EmptyDisposable.m3637a(th, this.f7535a);
            }
        }

        @Override // p136d.p153c.SingleObserver
        /* renamed from: b */
        public void mo3282b(T t) {
            if (this.f7537c) {
                return;
            }
            this.f7535a.mo3282b(t);
        }

        @Override // p136d.p153c.SingleObserver
        /* renamed from: a */
        public void mo3283a(Throwable th) {
            if (this.f7537c) {
                RxJavaPlugins.m3371b(th);
            } else {
                this.f7535a.mo3283a(th);
            }
        }
    }
}
