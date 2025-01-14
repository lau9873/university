package p136d.p153c.p160f0.p165e.p169d;

import p136d.p153c.InterfaceC1730s;
import p136d.p153c.ObservableSource;
import p136d.p153c.p157c0.Disposable;

/* renamed from: d.c.f0.e.d.i */
/* loaded from: classes.dex */
public final class ObservableIgnoreElements<T> extends AbstractObservableWithUpstream<T, T> {
    public ObservableIgnoreElements(ObservableSource<T> observableSource) {
        super(observableSource);
    }

    @Override // p136d.p153c.Observable
    /* renamed from: b */
    public void mo574b(InterfaceC1730s<? super T> interfaceC1730s) {
        this.f7279a.mo3294a(new C1645a(interfaceC1730s));
    }

    /* compiled from: ObservableIgnoreElements.java */
    /* renamed from: d.c.f0.e.d.i$a */
    /* loaded from: classes.dex */
    public static final class C1645a<T> implements InterfaceC1730s<T>, Disposable {

        /* renamed from: a */
        public final InterfaceC1730s<? super T> f7355a;

        /* renamed from: b */
        public Disposable f7356b;

        public C1645a(InterfaceC1730s<? super T> interfaceC1730s) {
            this.f7355a = interfaceC1730s;
        }

        @Override // p136d.p153c.InterfaceC1730s
        /* renamed from: a */
        public void mo572a(Disposable disposable) {
            this.f7356b = disposable;
            this.f7355a.mo572a((Disposable) this);
        }

        @Override // p136d.p153c.InterfaceC1730s
        /* renamed from: a */
        public void mo570a(T t) {
        }

        @Override // p136d.p153c.p157c0.Disposable
        /* renamed from: b */
        public void mo578b() {
            this.f7356b.mo578b();
        }

        @Override // p136d.p153c.p157c0.Disposable
        /* renamed from: c */
        public boolean mo577c() {
            return this.f7356b.mo577c();
        }

        @Override // p136d.p153c.InterfaceC1730s
        /* renamed from: a */
        public void mo569a(Throwable th) {
            this.f7355a.mo569a(th);
        }

        @Override // p136d.p153c.InterfaceC1730s
        /* renamed from: a */
        public void mo573a() {
            this.f7355a.mo573a();
        }
    }
}
