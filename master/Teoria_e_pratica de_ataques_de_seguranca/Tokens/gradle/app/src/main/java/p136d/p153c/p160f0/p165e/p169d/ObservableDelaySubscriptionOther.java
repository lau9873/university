package p136d.p153c.p160f0.p165e.p169d;

import p136d.p153c.InterfaceC1730s;
import p136d.p153c.Observable;
import p136d.p153c.ObservableSource;
import p136d.p153c.p157c0.Disposable;
import p136d.p153c.p160f0.p161a.SequentialDisposable;
import p136d.p153c.p177h0.RxJavaPlugins;

/* renamed from: d.c.f0.e.d.d */
/* loaded from: classes.dex */
public final class ObservableDelaySubscriptionOther<T, U> extends Observable<T> {

    /* renamed from: a */
    public final ObservableSource<? extends T> f7313a;

    /* renamed from: b */
    public final ObservableSource<U> f7314b;

    /* compiled from: ObservableDelaySubscriptionOther.java */
    /* renamed from: d.c.f0.e.d.d$a */
    /* loaded from: classes.dex */
    public class C1640a implements InterfaceC1730s<U> {

        /* renamed from: a */
        public boolean f7315a;

        /* renamed from: b */
        public final /* synthetic */ SequentialDisposable f7316b;

        /* renamed from: c */
        public final /* synthetic */ InterfaceC1730s f7317c;

        /* compiled from: ObservableDelaySubscriptionOther.java */
        /* renamed from: d.c.f0.e.d.d$a$a */
        /* loaded from: classes.dex */
        public class C1641a implements InterfaceC1730s<T> {
            public C1641a() {
            }

            @Override // p136d.p153c.InterfaceC1730s
            /* renamed from: a */
            public void mo572a(Disposable disposable) {
                C1640a.this.f7316b.m3631b(disposable);
            }

            @Override // p136d.p153c.InterfaceC1730s
            /* renamed from: a */
            public void mo570a(T t) {
                C1640a.this.f7317c.mo570a((InterfaceC1730s) t);
            }

            @Override // p136d.p153c.InterfaceC1730s
            /* renamed from: a */
            public void mo569a(Throwable th) {
                C1640a.this.f7317c.mo569a(th);
            }

            @Override // p136d.p153c.InterfaceC1730s
            /* renamed from: a */
            public void mo573a() {
                C1640a.this.f7317c.mo573a();
            }
        }

        public C1640a(SequentialDisposable sequentialDisposable, InterfaceC1730s interfaceC1730s) {
            this.f7316b = sequentialDisposable;
            this.f7317c = interfaceC1730s;
        }

        @Override // p136d.p153c.InterfaceC1730s
        /* renamed from: a */
        public void mo572a(Disposable disposable) {
            this.f7316b.m3631b(disposable);
        }

        @Override // p136d.p153c.InterfaceC1730s
        /* renamed from: a */
        public void mo570a(U u) {
            mo573a();
        }

        @Override // p136d.p153c.InterfaceC1730s
        /* renamed from: a */
        public void mo569a(Throwable th) {
            if (this.f7315a) {
                RxJavaPlugins.m3371b(th);
                return;
            }
            this.f7315a = true;
            this.f7317c.mo569a(th);
        }

        @Override // p136d.p153c.InterfaceC1730s
        /* renamed from: a */
        public void mo573a() {
            if (this.f7315a) {
                return;
            }
            this.f7315a = true;
            ObservableDelaySubscriptionOther.this.f7313a.mo3294a(new C1641a());
        }
    }

    public ObservableDelaySubscriptionOther(ObservableSource<? extends T> observableSource, ObservableSource<U> observableSource2) {
        this.f7313a = observableSource;
        this.f7314b = observableSource2;
    }

    @Override // p136d.p153c.Observable
    /* renamed from: b */
    public void mo574b(InterfaceC1730s<? super T> interfaceC1730s) {
        SequentialDisposable sequentialDisposable = new SequentialDisposable();
        interfaceC1730s.mo572a((Disposable) sequentialDisposable);
        this.f7314b.mo3294a(new C1640a(sequentialDisposable, interfaceC1730s));
    }
}
