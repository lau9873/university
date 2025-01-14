package p136d.p153c.p160f0.p165e.p170e;

import io.reactivex.exceptions.CompositeException;
import p136d.p153c.Single;
import p136d.p153c.SingleObserver;
import p136d.p153c.SingleSource;
import p136d.p153c.p157c0.Disposable;
import p136d.p153c.p158d0.Exceptions;
import p136d.p153c.p159e0.Consumer;

/* renamed from: d.c.f0.e.e.o */
/* loaded from: classes.dex */
public final class SingleDoOnError<T> extends Single<T> {

    /* renamed from: a */
    public final SingleSource<T> f7519a;

    /* renamed from: b */
    public final Consumer<? super Throwable> f7520b;

    /* compiled from: SingleDoOnError.java */
    /* renamed from: d.c.f0.e.e.o$a */
    /* loaded from: classes.dex */
    public class C1684a implements SingleObserver<T> {

        /* renamed from: a */
        public final /* synthetic */ SingleObserver f7521a;

        public C1684a(SingleObserver singleObserver) {
            this.f7521a = singleObserver;
        }

        @Override // p136d.p153c.SingleObserver
        /* renamed from: a */
        public void mo3284a(Disposable disposable) {
            this.f7521a.mo3284a(disposable);
        }

        @Override // p136d.p153c.SingleObserver
        /* renamed from: b */
        public void mo3282b(T t) {
            this.f7521a.mo3282b(t);
        }

        @Override // p136d.p153c.SingleObserver
        /* renamed from: a */
        public void mo3283a(Throwable th) {
            try {
                SingleDoOnError.this.f7520b.accept(th);
            } catch (Throwable th2) {
                Exceptions.m3660b(th2);
                th = new CompositeException(th, th2);
            }
            this.f7521a.mo3283a(th);
        }
    }

    public SingleDoOnError(SingleSource<T> singleSource, Consumer<? super Throwable> consumer) {
        this.f7519a = singleSource;
        this.f7520b = consumer;
    }

    @Override // p136d.p153c.Single
    public void subscribeActual(SingleObserver<? super T> singleObserver) {
        this.f7519a.subscribe(new C1684a(singleObserver));
    }
}
