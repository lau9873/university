package p136d.p153c.p160f0.p165e.p166a;

import p136d.p153c.CompletableObserver;
import p136d.p153c.CompletableSource;
import p136d.p153c.InterfaceC1730s;
import p136d.p153c.Observable;
import p136d.p153c.p157c0.Disposable;

/* renamed from: d.c.f0.e.a.l0 */
/* loaded from: classes.dex */
public final class CompletableToObservable<T> extends Observable<T> {

    /* renamed from: a */
    public final CompletableSource f7038a;

    /* compiled from: CompletableToObservable.java */
    /* renamed from: d.c.f0.e.a.l0$a */
    /* loaded from: classes.dex */
    public static final class C1587a implements CompletableObserver {

        /* renamed from: a */
        public final InterfaceC1730s<?> f7039a;

        public C1587a(InterfaceC1730s<?> interfaceC1730s) {
            this.f7039a = interfaceC1730s;
        }

        @Override // p136d.p153c.CompletableObserver
        /* renamed from: a */
        public void mo3489a() {
            this.f7039a.mo573a();
        }

        @Override // p136d.p153c.CompletableObserver
        /* renamed from: a */
        public void mo3501a(Throwable th) {
            this.f7039a.mo569a(th);
        }

        @Override // p136d.p153c.CompletableObserver
        /* renamed from: a */
        public void mo3502a(Disposable disposable) {
            this.f7039a.mo572a(disposable);
        }
    }

    public CompletableToObservable(CompletableSource completableSource) {
        this.f7038a = completableSource;
    }

    @Override // p136d.p153c.Observable
    /* renamed from: b */
    public void mo574b(InterfaceC1730s<? super T> interfaceC1730s) {
        this.f7038a.subscribe(new C1587a(interfaceC1730s));
    }
}
