package p136d.p153c.p160f0.p165e.p170e;

import java.util.concurrent.atomic.AtomicReference;
import p136d.p153c.Single;
import p136d.p153c.SingleObserver;
import p136d.p153c.SingleSource;
import p136d.p153c.p157c0.Disposable;
import p136d.p153c.p158d0.Exceptions;
import p136d.p153c.p159e0.Function;
import p136d.p153c.p160f0.p161a.DisposableHelper;
import p136d.p153c.p160f0.p162b.ObjectHelper;

/* renamed from: d.c.f0.e.e.u */
/* loaded from: classes.dex */
public final class SingleFlatMap<T, R> extends Single<R> {

    /* renamed from: a */
    public final SingleSource<? extends T> f7573a;

    /* renamed from: b */
    public final Function<? super T, ? extends SingleSource<? extends R>> f7574b;

    /* compiled from: SingleFlatMap.java */
    /* renamed from: d.c.f0.e.e.u$a */
    /* loaded from: classes.dex */
    public static final class C1697a<T, R> extends AtomicReference<Disposable> implements SingleObserver<T>, Disposable {

        /* renamed from: a */
        public final SingleObserver<? super R> f7575a;

        /* renamed from: b */
        public final Function<? super T, ? extends SingleSource<? extends R>> f7576b;

        /* compiled from: SingleFlatMap.java */
        /* renamed from: d.c.f0.e.e.u$a$a */
        /* loaded from: classes.dex */
        public static final class C1698a<R> implements SingleObserver<R> {

            /* renamed from: a */
            public final AtomicReference<Disposable> f7577a;

            /* renamed from: b */
            public final SingleObserver<? super R> f7578b;

            public C1698a(AtomicReference<Disposable> atomicReference, SingleObserver<? super R> singleObserver) {
                this.f7577a = atomicReference;
                this.f7578b = singleObserver;
            }

            @Override // p136d.p153c.SingleObserver
            /* renamed from: a */
            public void mo3284a(Disposable disposable) {
                DisposableHelper.m3646a(this.f7577a, disposable);
            }

            @Override // p136d.p153c.SingleObserver
            /* renamed from: b */
            public void mo3282b(R r) {
                this.f7578b.mo3282b(r);
            }

            @Override // p136d.p153c.SingleObserver
            /* renamed from: a */
            public void mo3283a(Throwable th) {
                this.f7578b.mo3283a(th);
            }
        }

        public C1697a(SingleObserver<? super R> singleObserver, Function<? super T, ? extends SingleSource<? extends R>> function) {
            this.f7575a = singleObserver;
            this.f7576b = function;
        }

        @Override // p136d.p153c.SingleObserver
        /* renamed from: a */
        public void mo3284a(Disposable disposable) {
            if (DisposableHelper.m3644c(this, disposable)) {
                this.f7575a.mo3284a(this);
            }
        }

        @Override // p136d.p153c.p157c0.Disposable
        /* renamed from: b */
        public void mo578b() {
            DisposableHelper.m3647a((AtomicReference<Disposable>) this);
        }

        @Override // p136d.p153c.p157c0.Disposable
        /* renamed from: c */
        public boolean mo577c() {
            return DisposableHelper.m3649a(get());
        }

        @Override // p136d.p153c.SingleObserver
        /* renamed from: b */
        public void mo3282b(T t) {
            try {
                SingleSource<? extends R> mo3490a = this.f7576b.mo3490a(t);
                ObjectHelper.m3598a(mo3490a, "The single returned by the mapper is null");
                SingleSource<? extends R> singleSource = mo3490a;
                if (mo577c()) {
                    return;
                }
                singleSource.subscribe(new C1698a(this, this.f7575a));
            } catch (Throwable th) {
                Exceptions.m3660b(th);
                this.f7575a.mo3283a(th);
            }
        }

        @Override // p136d.p153c.SingleObserver
        /* renamed from: a */
        public void mo3283a(Throwable th) {
            this.f7575a.mo3283a(th);
        }
    }

    public SingleFlatMap(SingleSource<? extends T> singleSource, Function<? super T, ? extends SingleSource<? extends R>> function) {
        this.f7574b = function;
        this.f7573a = singleSource;
    }

    @Override // p136d.p153c.Single
    public void subscribeActual(SingleObserver<? super R> singleObserver) {
        this.f7573a.subscribe(new C1697a(singleObserver, this.f7574b));
    }
}
