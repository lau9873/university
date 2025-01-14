package p136d.p153c.p160f0.p165e.p170e;

import io.reactivex.exceptions.CompositeException;
import p136d.p153c.Single;
import p136d.p153c.SingleObserver;
import p136d.p153c.SingleSource;
import p136d.p153c.p157c0.Disposable;
import p136d.p153c.p158d0.Exceptions;
import p136d.p153c.p159e0.Function;

/* renamed from: d.c.f0.e.e.j0 */
/* loaded from: classes.dex */
public final class SingleOnErrorReturn<T> extends Single<T> {

    /* renamed from: a */
    public final SingleSource<? extends T> f7468a;

    /* renamed from: b */
    public final Function<? super Throwable, ? extends T> f7469b;

    /* renamed from: c */
    public final T f7470c;

    public SingleOnErrorReturn(SingleSource<? extends T> singleSource, Function<? super Throwable, ? extends T> function, T t) {
        this.f7468a = singleSource;
        this.f7469b = function;
        this.f7470c = t;
    }

    @Override // p136d.p153c.Single
    public void subscribeActual(SingleObserver<? super T> singleObserver) {
        this.f7468a.subscribe(new C1672a(singleObserver));
    }

    /* compiled from: SingleOnErrorReturn.java */
    /* renamed from: d.c.f0.e.e.j0$a */
    /* loaded from: classes.dex */
    public class C1672a implements SingleObserver<T> {

        /* renamed from: a */
        public final /* synthetic */ SingleObserver f7471a;

        public C1672a(SingleObserver singleObserver) {
            this.f7471a = singleObserver;
        }

        @Override // p136d.p153c.SingleObserver
        /* renamed from: a */
        public void mo3283a(Throwable th) {
            T mo3490a;
            SingleOnErrorReturn singleOnErrorReturn = SingleOnErrorReturn.this;
            Function<? super Throwable, ? extends T> function = singleOnErrorReturn.f7469b;
            if (function != null) {
                try {
                    mo3490a = function.mo3490a(th);
                } catch (Throwable th2) {
                    Exceptions.m3660b(th2);
                    this.f7471a.mo3283a(new CompositeException(th, th2));
                    return;
                }
            } else {
                mo3490a = singleOnErrorReturn.f7470c;
            }
            if (mo3490a == null) {
                NullPointerException nullPointerException = new NullPointerException("Value supplied was null");
                nullPointerException.initCause(th);
                this.f7471a.mo3283a(nullPointerException);
                return;
            }
            this.f7471a.mo3282b(mo3490a);
        }

        @Override // p136d.p153c.SingleObserver
        /* renamed from: b */
        public void mo3282b(T t) {
            this.f7471a.mo3282b(t);
        }

        @Override // p136d.p153c.SingleObserver
        /* renamed from: a */
        public void mo3284a(Disposable disposable) {
            this.f7471a.mo3284a(disposable);
        }
    }
}
