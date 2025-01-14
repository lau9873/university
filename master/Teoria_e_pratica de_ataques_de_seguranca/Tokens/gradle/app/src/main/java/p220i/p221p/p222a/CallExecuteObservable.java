package p220i.p221p.p222a;

import io.reactivex.exceptions.CompositeException;
import p136d.p153c.InterfaceC1730s;
import p136d.p153c.Observable;
import p136d.p153c.p157c0.Disposable;
import p136d.p153c.p158d0.Exceptions;
import p136d.p153c.p177h0.RxJavaPlugins;
import p220i.C2632l;
import p220i.InterfaceC2600b;

/* renamed from: i.p.a.c */
/* loaded from: classes.dex */
public final class CallExecuteObservable<T> extends Observable<C2632l<T>> {

    /* renamed from: a */
    public final InterfaceC2600b<T> f10515a;

    /* compiled from: CallExecuteObservable.java */
    /* renamed from: i.p.a.c$a */
    /* loaded from: classes.dex */
    public static final class C2642a implements Disposable {

        /* renamed from: a */
        public final InterfaceC2600b<?> f10516a;

        public C2642a(InterfaceC2600b<?> interfaceC2600b) {
            this.f10516a = interfaceC2600b;
        }

        @Override // p136d.p153c.p157c0.Disposable
        /* renamed from: b */
        public void mo578b() {
            this.f10516a.cancel();
        }

        @Override // p136d.p153c.p157c0.Disposable
        /* renamed from: c */
        public boolean mo577c() {
            return this.f10516a.mo679k();
        }
    }

    public CallExecuteObservable(InterfaceC2600b<T> interfaceC2600b) {
        this.f10515a = interfaceC2600b;
    }

    @Override // p136d.p153c.Observable
    /* renamed from: b */
    public void mo574b(InterfaceC1730s<? super C2632l<T>> interfaceC1730s) {
        boolean z;
        InterfaceC2600b<T> clone = this.f10515a.clone();
        interfaceC1730s.mo572a((Disposable) new C2642a(clone));
        try {
            C2632l<T> mo680j = clone.mo680j();
            if (!clone.mo679k()) {
                interfaceC1730s.mo570a((InterfaceC1730s<? super C2632l<T>>) mo680j);
            }
            if (clone.mo679k()) {
                return;
            }
            try {
                interfaceC1730s.mo573a();
            } catch (Throwable th) {
                th = th;
                z = true;
                Exceptions.m3660b(th);
                if (z) {
                    RxJavaPlugins.m3371b(th);
                } else if (clone.mo679k()) {
                } else {
                    try {
                        interfaceC1730s.mo569a(th);
                    } catch (Throwable th2) {
                        Exceptions.m3660b(th2);
                        RxJavaPlugins.m3371b(new CompositeException(th, th2));
                    }
                }
            }
        } catch (Throwable th3) {
            th = th3;
            z = false;
        }
    }
}
