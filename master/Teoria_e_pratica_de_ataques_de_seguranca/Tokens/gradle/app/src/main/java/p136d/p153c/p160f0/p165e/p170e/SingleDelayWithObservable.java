package p136d.p153c.p160f0.p165e.p170e;

import java.util.concurrent.atomic.AtomicReference;
import p136d.p153c.InterfaceC1730s;
import p136d.p153c.ObservableSource;
import p136d.p153c.Single;
import p136d.p153c.SingleObserver;
import p136d.p153c.SingleSource;
import p136d.p153c.p157c0.Disposable;
import p136d.p153c.p160f0.p161a.DisposableHelper;
import p136d.p153c.p160f0.p164d.ResumeSingleObserver;
import p136d.p153c.p177h0.RxJavaPlugins;

/* renamed from: d.c.f0.e.e.h */
/* loaded from: classes.dex */
public final class SingleDelayWithObservable<T, U> extends Single<T> {

    /* renamed from: a */
    public final SingleSource<T> f7446a;

    /* renamed from: b */
    public final ObservableSource<U> f7447b;

    public SingleDelayWithObservable(SingleSource<T> singleSource, ObservableSource<U> observableSource) {
        this.f7446a = singleSource;
        this.f7447b = observableSource;
    }

    @Override // p136d.p153c.Single
    public void subscribeActual(SingleObserver<? super T> singleObserver) {
        this.f7447b.mo3294a(new C1668a(singleObserver, this.f7446a));
    }

    /* compiled from: SingleDelayWithObservable.java */
    /* renamed from: d.c.f0.e.e.h$a */
    /* loaded from: classes.dex */
    public static final class C1668a<T, U> extends AtomicReference<Disposable> implements InterfaceC1730s<U>, Disposable {

        /* renamed from: a */
        public final SingleObserver<? super T> f7448a;

        /* renamed from: b */
        public final SingleSource<T> f7449b;

        /* renamed from: c */
        public boolean f7450c;

        public C1668a(SingleObserver<? super T> singleObserver, SingleSource<T> singleSource) {
            this.f7448a = singleObserver;
            this.f7449b = singleSource;
        }

        @Override // p136d.p153c.InterfaceC1730s
        /* renamed from: a */
        public void mo572a(Disposable disposable) {
            if (DisposableHelper.m3645b(this, disposable)) {
                this.f7448a.mo3284a(this);
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

        @Override // p136d.p153c.InterfaceC1730s
        /* renamed from: a */
        public void mo570a(U u) {
            get().mo578b();
            mo573a();
        }

        @Override // p136d.p153c.InterfaceC1730s
        /* renamed from: a */
        public void mo569a(Throwable th) {
            if (this.f7450c) {
                RxJavaPlugins.m3371b(th);
                return;
            }
            this.f7450c = true;
            this.f7448a.mo3283a(th);
        }

        @Override // p136d.p153c.InterfaceC1730s
        /* renamed from: a */
        public void mo573a() {
            if (this.f7450c) {
                return;
            }
            this.f7450c = true;
            this.f7449b.subscribe(new ResumeSingleObserver(this, this.f7448a));
        }
    }
}
