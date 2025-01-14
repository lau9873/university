package p136d.p153c.p160f0.p165e.p170e;

import java.util.concurrent.atomic.AtomicBoolean;
import p136d.p153c.Single;
import p136d.p153c.SingleObserver;
import p136d.p153c.SingleSource;
import p136d.p153c.p157c0.CompositeDisposable;
import p136d.p153c.p157c0.Disposable;
import p136d.p153c.p158d0.Exceptions;
import p136d.p153c.p160f0.p161a.EmptyDisposable;
import p136d.p153c.p177h0.RxJavaPlugins;

/* renamed from: d.c.f0.e.e.a */
/* loaded from: classes.dex */
public final class SingleAmb<T> extends Single<T> {

    /* renamed from: a */
    public final SingleSource<? extends T>[] f7387a;

    /* renamed from: b */
    public final Iterable<? extends SingleSource<? extends T>> f7388b;

    /* compiled from: SingleAmb.java */
    /* renamed from: d.c.f0.e.e.a$a */
    /* loaded from: classes.dex */
    public static final class C1654a<T> extends AtomicBoolean implements SingleObserver<T> {

        /* renamed from: a */
        public final CompositeDisposable f7389a;

        /* renamed from: b */
        public final SingleObserver<? super T> f7390b;

        public C1654a(SingleObserver<? super T> singleObserver, CompositeDisposable compositeDisposable) {
            this.f7390b = singleObserver;
            this.f7389a = compositeDisposable;
        }

        @Override // p136d.p153c.SingleObserver
        /* renamed from: a */
        public void mo3284a(Disposable disposable) {
            this.f7389a.mo3633c(disposable);
        }

        @Override // p136d.p153c.SingleObserver
        /* renamed from: b */
        public void mo3282b(T t) {
            if (compareAndSet(false, true)) {
                this.f7389a.mo578b();
                this.f7390b.mo3282b(t);
            }
        }

        @Override // p136d.p153c.SingleObserver
        /* renamed from: a */
        public void mo3283a(Throwable th) {
            if (compareAndSet(false, true)) {
                this.f7389a.mo578b();
                this.f7390b.mo3283a(th);
                return;
            }
            RxJavaPlugins.m3371b(th);
        }
    }

    public SingleAmb(SingleSource<? extends T>[] singleSourceArr, Iterable<? extends SingleSource<? extends T>> iterable) {
        this.f7387a = singleSourceArr;
        this.f7388b = iterable;
    }

    @Override // p136d.p153c.Single
    public void subscribeActual(SingleObserver<? super T> singleObserver) {
        int length;
        SingleSource<? extends T>[] singleSourceArr = this.f7387a;
        if (singleSourceArr == null) {
            singleSourceArr = new SingleSource[8];
            try {
                length = 0;
                for (SingleSource<? extends T> singleSource : this.f7388b) {
                    if (singleSource == null) {
                        EmptyDisposable.m3637a(new NullPointerException("One of the sources is null"), singleObserver);
                        return;
                    }
                    if (length == singleSourceArr.length) {
                        SingleSource<? extends T>[] singleSourceArr2 = new SingleSource[(length >> 2) + length];
                        System.arraycopy(singleSourceArr, 0, singleSourceArr2, 0, length);
                        singleSourceArr = singleSourceArr2;
                    }
                    int i = length + 1;
                    singleSourceArr[length] = singleSource;
                    length = i;
                }
            } catch (Throwable th) {
                Exceptions.m3660b(th);
                EmptyDisposable.m3637a(th, singleObserver);
                return;
            }
        } else {
            length = singleSourceArr.length;
        }
        CompositeDisposable compositeDisposable = new CompositeDisposable();
        C1654a c1654a = new C1654a(singleObserver, compositeDisposable);
        singleObserver.mo3284a(compositeDisposable);
        for (int i2 = 0; i2 < length; i2++) {
            SingleSource<? extends T> singleSource2 = singleSourceArr[i2];
            if (c1654a.get()) {
                return;
            }
            if (singleSource2 == null) {
                compositeDisposable.mo578b();
                NullPointerException nullPointerException = new NullPointerException("One of the sources is null");
                if (c1654a.compareAndSet(false, true)) {
                    singleObserver.mo3283a(nullPointerException);
                    return;
                } else {
                    RxJavaPlugins.m3371b(nullPointerException);
                    return;
                }
            }
            singleSource2.subscribe(c1654a);
        }
    }
}
