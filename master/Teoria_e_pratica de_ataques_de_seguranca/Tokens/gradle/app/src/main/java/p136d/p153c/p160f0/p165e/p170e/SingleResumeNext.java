package p136d.p153c.p160f0.p165e.p170e;

import io.reactivex.exceptions.CompositeException;
import java.util.concurrent.atomic.AtomicReference;
import p136d.p153c.Single;
import p136d.p153c.SingleObserver;
import p136d.p153c.SingleSource;
import p136d.p153c.p157c0.Disposable;
import p136d.p153c.p158d0.Exceptions;
import p136d.p153c.p159e0.Function;
import p136d.p153c.p160f0.p161a.DisposableHelper;
import p136d.p153c.p160f0.p162b.ObjectHelper;
import p136d.p153c.p160f0.p164d.ResumeSingleObserver;

/* renamed from: d.c.f0.e.e.k0 */
/* loaded from: classes.dex */
public final class SingleResumeNext<T> extends Single<T> {

    /* renamed from: a */
    public final SingleSource<? extends T> f7478a;

    /* renamed from: b */
    public final Function<? super Throwable, ? extends SingleSource<? extends T>> f7479b;

    /* compiled from: SingleResumeNext.java */
    /* renamed from: d.c.f0.e.e.k0$a */
    /* loaded from: classes.dex */
    public static final class C1674a<T> extends AtomicReference<Disposable> implements SingleObserver<T>, Disposable {

        /* renamed from: a */
        public final SingleObserver<? super T> f7480a;

        /* renamed from: b */
        public final Function<? super Throwable, ? extends SingleSource<? extends T>> f7481b;

        public C1674a(SingleObserver<? super T> singleObserver, Function<? super Throwable, ? extends SingleSource<? extends T>> function) {
            this.f7480a = singleObserver;
            this.f7481b = function;
        }

        @Override // p136d.p153c.SingleObserver
        /* renamed from: a */
        public void mo3284a(Disposable disposable) {
            if (DisposableHelper.m3644c(this, disposable)) {
                this.f7480a.mo3284a(this);
            }
        }

        @Override // p136d.p153c.SingleObserver
        /* renamed from: b */
        public void mo3282b(T t) {
            this.f7480a.mo3282b(t);
        }

        @Override // p136d.p153c.p157c0.Disposable
        /* renamed from: c */
        public boolean mo577c() {
            return DisposableHelper.m3649a(get());
        }

        @Override // p136d.p153c.p157c0.Disposable
        /* renamed from: b */
        public void mo578b() {
            DisposableHelper.m3647a((AtomicReference<Disposable>) this);
        }

        @Override // p136d.p153c.SingleObserver
        /* renamed from: a */
        public void mo3283a(Throwable th) {
            try {
                ((SingleSource) ObjectHelper.m3598a(this.f7481b.mo3490a(th), "The nextFunction returned a null SingleSource.")).subscribe(new ResumeSingleObserver(this, this.f7480a));
            } catch (Throwable th2) {
                Exceptions.m3660b(th2);
                this.f7480a.mo3283a(new CompositeException(th, th2));
            }
        }
    }

    public SingleResumeNext(SingleSource<? extends T> singleSource, Function<? super Throwable, ? extends SingleSource<? extends T>> function) {
        this.f7478a = singleSource;
        this.f7479b = function;
    }

    @Override // p136d.p153c.Single
    public void subscribeActual(SingleObserver<? super T> singleObserver) {
        this.f7478a.subscribe(new C1674a(singleObserver, this.f7479b));
    }
}
