package p220i.p221p.p222a;

import io.reactivex.exceptions.CompositeException;
import p136d.p153c.InterfaceC1730s;
import p136d.p153c.Observable;
import p136d.p153c.p157c0.Disposable;
import p136d.p153c.p158d0.Exceptions;
import p136d.p153c.p177h0.RxJavaPlugins;
import p220i.C2632l;
import p220i.InterfaceC2600b;
import p220i.InterfaceC2602d;

/* renamed from: i.p.a.b */
/* loaded from: classes.dex */
public final class CallEnqueueObservable<T> extends Observable<C2632l<T>> {

    /* renamed from: a */
    public final InterfaceC2600b<T> f10511a;

    public CallEnqueueObservable(InterfaceC2600b<T> interfaceC2600b) {
        this.f10511a = interfaceC2600b;
    }

    @Override // p136d.p153c.Observable
    /* renamed from: b */
    public void mo574b(InterfaceC1730s<? super C2632l<T>> interfaceC1730s) {
        InterfaceC2600b<T> clone = this.f10511a.clone();
        C2641a c2641a = new C2641a(clone, interfaceC1730s);
        interfaceC1730s.mo572a((Disposable) c2641a);
        clone.mo681a(c2641a);
    }

    /* compiled from: CallEnqueueObservable.java */
    /* renamed from: i.p.a.b$a */
    /* loaded from: classes.dex */
    public static final class C2641a<T> implements Disposable, InterfaceC2602d<T> {

        /* renamed from: a */
        public final InterfaceC2600b<?> f10512a;

        /* renamed from: b */
        public final InterfaceC1730s<? super C2632l<T>> f10513b;

        /* renamed from: c */
        public boolean f10514c = false;

        public C2641a(InterfaceC2600b<?> interfaceC2600b, InterfaceC1730s<? super C2632l<T>> interfaceC1730s) {
            this.f10512a = interfaceC2600b;
            this.f10513b = interfaceC1730s;
        }

        @Override // p220i.InterfaceC2602d
        /* renamed from: a */
        public void mo580a(InterfaceC2600b<T> interfaceC2600b, C2632l<T> c2632l) {
            if (interfaceC2600b.mo679k()) {
                return;
            }
            try {
                this.f10513b.mo570a((InterfaceC1730s<? super C2632l<T>>) c2632l);
                if (interfaceC2600b.mo679k()) {
                    return;
                }
                this.f10514c = true;
                this.f10513b.mo573a();
            } catch (Throwable th) {
                if (this.f10514c) {
                    RxJavaPlugins.m3371b(th);
                } else if (interfaceC2600b.mo679k()) {
                } else {
                    try {
                        this.f10513b.mo569a(th);
                    } catch (Throwable th2) {
                        Exceptions.m3660b(th2);
                        RxJavaPlugins.m3371b(new CompositeException(th, th2));
                    }
                }
            }
        }

        @Override // p136d.p153c.p157c0.Disposable
        /* renamed from: b */
        public void mo578b() {
            this.f10512a.cancel();
        }

        @Override // p136d.p153c.p157c0.Disposable
        /* renamed from: c */
        public boolean mo577c() {
            return this.f10512a.mo679k();
        }

        @Override // p220i.InterfaceC2602d
        /* renamed from: a */
        public void mo579a(InterfaceC2600b<T> interfaceC2600b, Throwable th) {
            if (interfaceC2600b.mo679k()) {
                return;
            }
            try {
                this.f10513b.mo569a(th);
            } catch (Throwable th2) {
                Exceptions.m3660b(th2);
                RxJavaPlugins.m3371b(new CompositeException(th, th2));
            }
        }
    }
}
