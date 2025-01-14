package p136d.p153c.p160f0.p165e.p170e;

import java.util.concurrent.atomic.AtomicReference;
import p136d.p153c.Single;
import p136d.p153c.SingleObserver;
import p136d.p153c.SingleSource;
import p136d.p153c.p157c0.Disposable;
import p136d.p153c.p160f0.p161a.DisposableHelper;
import p136d.p153c.p160f0.p164d.ResumeSingleObserver;

/* renamed from: d.c.f0.e.e.j */
/* loaded from: classes.dex */
public final class SingleDelayWithSingle<T, U> extends Single<T> {

    /* renamed from: a */
    public final SingleSource<T> f7464a;

    /* renamed from: b */
    public final SingleSource<U> f7465b;

    /* compiled from: SingleDelayWithSingle.java */
    /* renamed from: d.c.f0.e.e.j$a */
    /* loaded from: classes.dex */
    public static final class C1671a<T, U> extends AtomicReference<Disposable> implements SingleObserver<U>, Disposable {

        /* renamed from: a */
        public final SingleObserver<? super T> f7466a;

        /* renamed from: b */
        public final SingleSource<T> f7467b;

        public C1671a(SingleObserver<? super T> singleObserver, SingleSource<T> singleSource) {
            this.f7466a = singleObserver;
            this.f7467b = singleSource;
        }

        @Override // p136d.p153c.SingleObserver
        /* renamed from: a */
        public void mo3284a(Disposable disposable) {
            if (DisposableHelper.m3645b(this, disposable)) {
                this.f7466a.mo3284a(this);
            }
        }

        @Override // p136d.p153c.SingleObserver
        /* renamed from: b */
        public void mo3282b(U u) {
            this.f7467b.subscribe(new ResumeSingleObserver(this, this.f7466a));
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
            this.f7466a.mo3283a(th);
        }
    }

    public SingleDelayWithSingle(SingleSource<T> singleSource, SingleSource<U> singleSource2) {
        this.f7464a = singleSource;
        this.f7465b = singleSource2;
    }

    @Override // p136d.p153c.Single
    public void subscribeActual(SingleObserver<? super T> singleObserver) {
        this.f7465b.subscribe(new C1671a(singleObserver, this.f7464a));
    }
}
