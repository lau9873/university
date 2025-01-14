package p136d.p153c.p160f0.p165e.p170e;

import p136d.p153c.InterfaceC1730s;
import p136d.p153c.Observable;
import p136d.p153c.SingleObserver;
import p136d.p153c.SingleSource;
import p136d.p153c.p157c0.Disposable;
import p136d.p153c.p160f0.p161a.DisposableHelper;

/* renamed from: d.c.f0.e.e.q0 */
/* loaded from: classes.dex */
public final class SingleToObservable<T> extends Observable<T> {

    /* renamed from: a */
    public final SingleSource<? extends T> f7538a;

    public SingleToObservable(SingleSource<? extends T> singleSource) {
        this.f7538a = singleSource;
    }

    @Override // p136d.p153c.Observable
    /* renamed from: b */
    public void mo574b(InterfaceC1730s<? super T> interfaceC1730s) {
        this.f7538a.subscribe(new C1689a(interfaceC1730s));
    }

    /* compiled from: SingleToObservable.java */
    /* renamed from: d.c.f0.e.e.q0$a */
    /* loaded from: classes.dex */
    public static final class C1689a<T> implements SingleObserver<T>, Disposable {

        /* renamed from: a */
        public final InterfaceC1730s<? super T> f7539a;

        /* renamed from: b */
        public Disposable f7540b;

        public C1689a(InterfaceC1730s<? super T> interfaceC1730s) {
            this.f7539a = interfaceC1730s;
        }

        @Override // p136d.p153c.SingleObserver
        /* renamed from: a */
        public void mo3284a(Disposable disposable) {
            if (DisposableHelper.m3648a(this.f7540b, disposable)) {
                this.f7540b = disposable;
                this.f7539a.mo572a((Disposable) this);
            }
        }

        @Override // p136d.p153c.SingleObserver
        /* renamed from: b */
        public void mo3282b(T t) {
            this.f7539a.mo570a((InterfaceC1730s<? super T>) t);
            this.f7539a.mo573a();
        }

        @Override // p136d.p153c.p157c0.Disposable
        /* renamed from: c */
        public boolean mo577c() {
            return this.f7540b.mo577c();
        }

        @Override // p136d.p153c.p157c0.Disposable
        /* renamed from: b */
        public void mo578b() {
            this.f7540b.mo578b();
        }

        @Override // p136d.p153c.SingleObserver
        /* renamed from: a */
        public void mo3283a(Throwable th) {
            this.f7539a.mo569a(th);
        }
    }
}
