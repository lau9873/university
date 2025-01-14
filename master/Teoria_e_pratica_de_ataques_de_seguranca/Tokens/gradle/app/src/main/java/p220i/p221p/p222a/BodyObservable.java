package p220i.p221p.p222a;

import io.reactivex.exceptions.CompositeException;
import p136d.p153c.InterfaceC1730s;
import p136d.p153c.Observable;
import p136d.p153c.p157c0.Disposable;
import p136d.p153c.p158d0.Exceptions;
import p136d.p153c.p177h0.RxJavaPlugins;
import p220i.C2632l;
import retrofit2.adapter.rxjava2.HttpException;

/* renamed from: i.p.a.a */
/* loaded from: classes.dex */
public final class BodyObservable<T> extends Observable<T> {

    /* renamed from: a */
    public final Observable<C2632l<T>> f10508a;

    /* compiled from: BodyObservable.java */
    /* renamed from: i.p.a.a$a */
    /* loaded from: classes.dex */
    public static class C2640a<R> implements InterfaceC1730s<C2632l<R>> {

        /* renamed from: a */
        public final InterfaceC1730s<? super R> f10509a;

        /* renamed from: b */
        public boolean f10510b;

        public C2640a(InterfaceC1730s<? super R> interfaceC1730s) {
            this.f10509a = interfaceC1730s;
        }

        @Override // p136d.p153c.InterfaceC1730s
        /* renamed from: a */
        public /* bridge */ /* synthetic */ void mo570a(Object obj) {
            m581a((C2632l) ((C2632l) obj));
        }

        @Override // p136d.p153c.InterfaceC1730s
        /* renamed from: a */
        public void mo572a(Disposable disposable) {
            this.f10509a.mo572a(disposable);
        }

        /* renamed from: a */
        public void m581a(C2632l<R> c2632l) {
            if (c2632l.m638c()) {
                this.f10509a.mo570a((InterfaceC1730s<? super R>) c2632l.m642a());
                return;
            }
            this.f10510b = true;
            HttpException httpException = new HttpException(c2632l);
            try {
                this.f10509a.mo569a((Throwable) httpException);
            } catch (Throwable th) {
                Exceptions.m3660b(th);
                RxJavaPlugins.m3371b(new CompositeException(httpException, th));
            }
        }

        @Override // p136d.p153c.InterfaceC1730s
        /* renamed from: a */
        public void mo573a() {
            if (this.f10510b) {
                return;
            }
            this.f10509a.mo573a();
        }

        @Override // p136d.p153c.InterfaceC1730s
        /* renamed from: a */
        public void mo569a(Throwable th) {
            if (!this.f10510b) {
                this.f10509a.mo569a(th);
                return;
            }
            AssertionError assertionError = new AssertionError("This should never happen! Report as a bug with the full stacktrace.");
            assertionError.initCause(th);
            RxJavaPlugins.m3371b(assertionError);
        }
    }

    public BodyObservable(Observable<C2632l<T>> observable) {
        this.f10508a = observable;
    }

    @Override // p136d.p153c.Observable
    /* renamed from: b */
    public void mo574b(InterfaceC1730s<? super T> interfaceC1730s) {
        this.f10508a.mo3294a(new C2640a(interfaceC1730s));
    }
}
