package p220i.p221p.p222a;

import io.reactivex.exceptions.CompositeException;
import p136d.p153c.InterfaceC1730s;
import p136d.p153c.Observable;
import p136d.p153c.p157c0.Disposable;
import p136d.p153c.p158d0.Exceptions;
import p136d.p153c.p177h0.RxJavaPlugins;
import p220i.C2632l;

/* renamed from: i.p.a.e */
/* loaded from: classes.dex */
public final class ResultObservable<T> extends Observable<Result<T>> {

    /* renamed from: a */
    public final Observable<C2632l<T>> f10517a;

    /* compiled from: ResultObservable.java */
    /* renamed from: i.p.a.e$a */
    /* loaded from: classes.dex */
    public static class C2643a<R> implements InterfaceC1730s<C2632l<R>> {

        /* renamed from: a */
        public final InterfaceC1730s<? super Result<R>> f10518a;

        public C2643a(InterfaceC1730s<? super Result<R>> interfaceC1730s) {
            this.f10518a = interfaceC1730s;
        }

        @Override // p136d.p153c.InterfaceC1730s
        /* renamed from: a */
        public /* bridge */ /* synthetic */ void mo570a(Object obj) {
            m571a((C2632l) ((C2632l) obj));
        }

        @Override // p136d.p153c.InterfaceC1730s
        /* renamed from: a */
        public void mo572a(Disposable disposable) {
            this.f10518a.mo572a(disposable);
        }

        /* renamed from: a */
        public void m571a(C2632l<R> c2632l) {
            this.f10518a.mo570a((InterfaceC1730s<? super Result<R>>) Result.m576a(c2632l));
        }

        @Override // p136d.p153c.InterfaceC1730s
        /* renamed from: a */
        public void mo569a(Throwable th) {
            try {
                this.f10518a.mo570a((InterfaceC1730s<? super Result<R>>) Result.m575a(th));
                this.f10518a.mo573a();
            } catch (Throwable th2) {
                try {
                    this.f10518a.mo569a(th2);
                } catch (Throwable th3) {
                    Exceptions.m3660b(th3);
                    RxJavaPlugins.m3371b(new CompositeException(th2, th3));
                }
            }
        }

        @Override // p136d.p153c.InterfaceC1730s
        /* renamed from: a */
        public void mo573a() {
            this.f10518a.mo573a();
        }
    }

    public ResultObservable(Observable<C2632l<T>> observable) {
        this.f10517a = observable;
    }

    @Override // p136d.p153c.Observable
    /* renamed from: b */
    public void mo574b(InterfaceC1730s<? super Result<T>> interfaceC1730s) {
        this.f10517a.mo3294a(new C2643a(interfaceC1730s));
    }
}
