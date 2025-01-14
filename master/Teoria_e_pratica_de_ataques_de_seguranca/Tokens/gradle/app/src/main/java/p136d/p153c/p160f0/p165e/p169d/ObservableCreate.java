package p136d.p153c.p160f0.p165e.p169d;

import java.util.concurrent.atomic.AtomicReference;
import p136d.p153c.InterfaceC1730s;
import p136d.p153c.Observable;
import p136d.p153c.ObservableEmitter;
import p136d.p153c.ObservableOnSubscribe;
import p136d.p153c.p157c0.Disposable;
import p136d.p153c.p158d0.Exceptions;
import p136d.p153c.p160f0.p161a.DisposableHelper;
import p136d.p153c.p177h0.RxJavaPlugins;

/* renamed from: d.c.f0.e.d.c */
/* loaded from: classes.dex */
public final class ObservableCreate<T> extends Observable<T> {

    /* renamed from: a */
    public final ObservableOnSubscribe<T> f7311a;

    public ObservableCreate(ObservableOnSubscribe<T> observableOnSubscribe) {
        this.f7311a = observableOnSubscribe;
    }

    @Override // p136d.p153c.Observable
    /* renamed from: b */
    public void mo574b(InterfaceC1730s<? super T> interfaceC1730s) {
        C1639a c1639a = new C1639a(interfaceC1730s);
        interfaceC1730s.mo572a((Disposable) c1639a);
        try {
            this.f7311a.mo1212a(c1639a);
        } catch (Throwable th) {
            Exceptions.m3660b(th);
            c1639a.m3528a(th);
        }
    }

    /* compiled from: ObservableCreate.java */
    /* renamed from: d.c.f0.e.d.c$a */
    /* loaded from: classes.dex */
    public static final class C1639a<T> extends AtomicReference<Disposable> implements ObservableEmitter<T>, Disposable {

        /* renamed from: a */
        public final InterfaceC1730s<? super T> f7312a;

        public C1639a(InterfaceC1730s<? super T> interfaceC1730s) {
            this.f7312a = interfaceC1730s;
        }

        /* renamed from: a */
        public void m3528a(Throwable th) {
            if (th == null) {
                th = new NullPointerException("onError called with null. Null values are generally not allowed in 2.x operators and sources.");
            }
            if (!mo577c()) {
                try {
                    this.f7312a.mo569a(th);
                    return;
                } finally {
                    mo578b();
                }
            }
            RxJavaPlugins.m3371b(th);
        }

        @Override // p136d.p153c.p157c0.Disposable
        /* renamed from: b */
        public void mo578b() {
            DisposableHelper.m3647a((AtomicReference<Disposable>) this);
        }

        @Override // p136d.p153c.p157c0.Disposable
        /* renamed from: c */
        public boolean mo577c() {
            return DisposableHelper.m3649a(get());
        }

        @Override // p136d.p153c.Emitter
        /* renamed from: a */
        public void mo3365a() {
            if (mo577c()) {
                return;
            }
            try {
                this.f7312a.mo573a();
            } finally {
                mo578b();
            }
        }
    }
}
