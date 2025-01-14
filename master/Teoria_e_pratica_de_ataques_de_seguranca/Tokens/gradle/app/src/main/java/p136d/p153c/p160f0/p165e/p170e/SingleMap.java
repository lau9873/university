package p136d.p153c.p160f0.p165e.p170e;

import p136d.p153c.Single;
import p136d.p153c.SingleObserver;
import p136d.p153c.SingleSource;
import p136d.p153c.p157c0.Disposable;
import p136d.p153c.p158d0.Exceptions;
import p136d.p153c.p159e0.Function;

/* renamed from: d.c.f0.e.e.g0 */
/* loaded from: classes.dex */
public final class SingleMap<T, R> extends Single<R> {

    /* renamed from: a */
    public final SingleSource<? extends T> f7442a;

    /* renamed from: b */
    public final Function<? super T, ? extends R> f7443b;

    /* compiled from: SingleMap.java */
    /* renamed from: d.c.f0.e.e.g0$a */
    /* loaded from: classes.dex */
    public static final class C1667a<T, R> implements SingleObserver<T> {

        /* renamed from: a */
        public final SingleObserver<? super R> f7444a;

        /* renamed from: b */
        public final Function<? super T, ? extends R> f7445b;

        public C1667a(SingleObserver<? super R> singleObserver, Function<? super T, ? extends R> function) {
            this.f7444a = singleObserver;
            this.f7445b = function;
        }

        @Override // p136d.p153c.SingleObserver
        /* renamed from: a */
        public void mo3284a(Disposable disposable) {
            this.f7444a.mo3284a(disposable);
        }

        @Override // p136d.p153c.SingleObserver
        /* renamed from: b */
        public void mo3282b(T t) {
            try {
                this.f7444a.mo3282b(this.f7445b.mo3490a(t));
            } catch (Throwable th) {
                Exceptions.m3660b(th);
                mo3283a(th);
            }
        }

        @Override // p136d.p153c.SingleObserver
        /* renamed from: a */
        public void mo3283a(Throwable th) {
            this.f7444a.mo3283a(th);
        }
    }

    public SingleMap(SingleSource<? extends T> singleSource, Function<? super T, ? extends R> function) {
        this.f7442a = singleSource;
        this.f7443b = function;
    }

    @Override // p136d.p153c.Single
    public void subscribeActual(SingleObserver<? super R> singleObserver) {
        this.f7442a.subscribe(new C1667a(singleObserver, this.f7443b));
    }
}
