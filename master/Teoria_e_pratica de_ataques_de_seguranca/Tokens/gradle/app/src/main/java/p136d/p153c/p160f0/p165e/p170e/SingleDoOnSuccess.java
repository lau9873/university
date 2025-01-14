package p136d.p153c.p160f0.p165e.p170e;

import p136d.p153c.Single;
import p136d.p153c.SingleObserver;
import p136d.p153c.SingleSource;
import p136d.p153c.p157c0.Disposable;
import p136d.p153c.p158d0.Exceptions;
import p136d.p153c.p159e0.Consumer;

/* renamed from: d.c.f0.e.e.r */
/* loaded from: classes.dex */
public final class SingleDoOnSuccess<T> extends Single<T> {

    /* renamed from: a */
    public final SingleSource<T> f7541a;

    /* renamed from: b */
    public final Consumer<? super T> f7542b;

    /* compiled from: SingleDoOnSuccess.java */
    /* renamed from: d.c.f0.e.e.r$a */
    /* loaded from: classes.dex */
    public class C1690a implements SingleObserver<T> {

        /* renamed from: a */
        public final /* synthetic */ SingleObserver f7543a;

        public C1690a(SingleObserver singleObserver) {
            this.f7543a = singleObserver;
        }

        @Override // p136d.p153c.SingleObserver
        /* renamed from: a */
        public void mo3284a(Disposable disposable) {
            this.f7543a.mo3284a(disposable);
        }

        @Override // p136d.p153c.SingleObserver
        /* renamed from: b */
        public void mo3282b(T t) {
            try {
                SingleDoOnSuccess.this.f7542b.accept(t);
                this.f7543a.mo3282b(t);
            } catch (Throwable th) {
                Exceptions.m3660b(th);
                this.f7543a.mo3283a(th);
            }
        }

        @Override // p136d.p153c.SingleObserver
        /* renamed from: a */
        public void mo3283a(Throwable th) {
            this.f7543a.mo3283a(th);
        }
    }

    public SingleDoOnSuccess(SingleSource<T> singleSource, Consumer<? super T> consumer) {
        this.f7541a = singleSource;
        this.f7542b = consumer;
    }

    @Override // p136d.p153c.Single
    public void subscribeActual(SingleObserver<? super T> singleObserver) {
        this.f7541a.subscribe(new C1690a(singleObserver));
    }
}
