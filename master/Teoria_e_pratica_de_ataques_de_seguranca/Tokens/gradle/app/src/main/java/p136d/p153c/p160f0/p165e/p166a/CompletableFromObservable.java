package p136d.p153c.p160f0.p165e.p166a;

import p136d.p153c.Completable;
import p136d.p153c.CompletableObserver;
import p136d.p153c.InterfaceC1730s;
import p136d.p153c.ObservableSource;
import p136d.p153c.p157c0.Disposable;

/* renamed from: d.c.f0.e.a.q */
/* loaded from: classes.dex */
public final class CompletableFromObservable<T> extends Completable {

    /* renamed from: a */
    public final ObservableSource<T> f7057a;

    /* compiled from: CompletableFromObservable.java */
    /* renamed from: d.c.f0.e.a.q$a */
    /* loaded from: classes.dex */
    public static final class C1590a<T> implements InterfaceC1730s<T> {

        /* renamed from: a */
        public final CompletableObserver f7058a;

        public C1590a(CompletableObserver completableObserver) {
            this.f7058a = completableObserver;
        }

        @Override // p136d.p153c.InterfaceC1730s
        /* renamed from: a */
        public void mo572a(Disposable disposable) {
            this.f7058a.mo3502a(disposable);
        }

        @Override // p136d.p153c.InterfaceC1730s
        /* renamed from: a */
        public void mo570a(T t) {
        }

        @Override // p136d.p153c.InterfaceC1730s
        /* renamed from: a */
        public void mo569a(Throwable th) {
            this.f7058a.mo3501a(th);
        }

        @Override // p136d.p153c.InterfaceC1730s
        /* renamed from: a */
        public void mo573a() {
            this.f7058a.mo3489a();
        }
    }

    public CompletableFromObservable(ObservableSource<T> observableSource) {
        this.f7057a = observableSource;
    }

    @Override // p136d.p153c.Completable
    public void subscribeActual(CompletableObserver completableObserver) {
        this.f7057a.mo3294a(new C1590a(completableObserver));
    }
}
