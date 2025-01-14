package p136d.p153c.p160f0.p165e.p169d;

import p136d.p153c.Completable;
import p136d.p153c.CompletableObserver;
import p136d.p153c.InterfaceC1730s;
import p136d.p153c.Observable;
import p136d.p153c.ObservableSource;
import p136d.p153c.p157c0.Disposable;
import p136d.p153c.p160f0.p163c.FuseToObservable;
import p136d.p153c.p177h0.RxJavaPlugins;

/* renamed from: d.c.f0.e.d.j */
/* loaded from: classes.dex */
public final class ObservableIgnoreElementsCompletable<T> extends Completable implements FuseToObservable<T> {

    /* renamed from: a */
    public final ObservableSource<T> f7357a;

    public ObservableIgnoreElementsCompletable(ObservableSource<T> observableSource) {
        this.f7357a = observableSource;
    }

    @Override // p136d.p153c.p160f0.p163c.FuseToObservable
    /* renamed from: b */
    public Observable<T> mo3516b() {
        return RxJavaPlugins.m3381a(new ObservableIgnoreElements(this.f7357a));
    }

    @Override // p136d.p153c.Completable
    public void subscribeActual(CompletableObserver completableObserver) {
        this.f7357a.mo3294a(new C1646a(completableObserver));
    }

    /* compiled from: ObservableIgnoreElementsCompletable.java */
    /* renamed from: d.c.f0.e.d.j$a */
    /* loaded from: classes.dex */
    public static final class C1646a<T> implements InterfaceC1730s<T>, Disposable {

        /* renamed from: a */
        public final CompletableObserver f7358a;

        /* renamed from: b */
        public Disposable f7359b;

        public C1646a(CompletableObserver completableObserver) {
            this.f7358a = completableObserver;
        }

        @Override // p136d.p153c.InterfaceC1730s
        /* renamed from: a */
        public void mo572a(Disposable disposable) {
            this.f7359b = disposable;
            this.f7358a.mo3502a(this);
        }

        @Override // p136d.p153c.InterfaceC1730s
        /* renamed from: a */
        public void mo570a(T t) {
        }

        @Override // p136d.p153c.p157c0.Disposable
        /* renamed from: b */
        public void mo578b() {
            this.f7359b.mo578b();
        }

        @Override // p136d.p153c.p157c0.Disposable
        /* renamed from: c */
        public boolean mo577c() {
            return this.f7359b.mo577c();
        }

        @Override // p136d.p153c.InterfaceC1730s
        /* renamed from: a */
        public void mo569a(Throwable th) {
            this.f7358a.mo3501a(th);
        }

        @Override // p136d.p153c.InterfaceC1730s
        /* renamed from: a */
        public void mo573a() {
            this.f7358a.mo3489a();
        }
    }
}
