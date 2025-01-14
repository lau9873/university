package p136d.p153c.p160f0.p165e.p169d;

import java.util.NoSuchElementException;
import p136d.p153c.InterfaceC1730s;
import p136d.p153c.ObservableSource;
import p136d.p153c.Single;
import p136d.p153c.SingleObserver;
import p136d.p153c.p157c0.Disposable;
import p136d.p153c.p160f0.p161a.DisposableHelper;
import p136d.p153c.p177h0.RxJavaPlugins;

/* renamed from: d.c.f0.e.d.o */
/* loaded from: classes.dex */
public final class ObservableSingleSingle<T> extends Single<T> {

    /* renamed from: a */
    public final ObservableSource<? extends T> f7371a;

    /* renamed from: b */
    public final T f7372b;

    public ObservableSingleSingle(ObservableSource<? extends T> observableSource, T t) {
        this.f7371a = observableSource;
        this.f7372b = t;
    }

    @Override // p136d.p153c.Single
    public void subscribeActual(SingleObserver<? super T> singleObserver) {
        this.f7371a.mo3294a(new C1650a(singleObserver, this.f7372b));
    }

    /* compiled from: ObservableSingleSingle.java */
    /* renamed from: d.c.f0.e.d.o$a */
    /* loaded from: classes.dex */
    public static final class C1650a<T> implements InterfaceC1730s<T>, Disposable {

        /* renamed from: a */
        public final SingleObserver<? super T> f7373a;

        /* renamed from: b */
        public final T f7374b;

        /* renamed from: c */
        public Disposable f7375c;

        /* renamed from: d */
        public T f7376d;

        /* renamed from: e */
        public boolean f7377e;

        public C1650a(SingleObserver<? super T> singleObserver, T t) {
            this.f7373a = singleObserver;
            this.f7374b = t;
        }

        @Override // p136d.p153c.InterfaceC1730s
        /* renamed from: a */
        public void mo572a(Disposable disposable) {
            if (DisposableHelper.m3648a(this.f7375c, disposable)) {
                this.f7375c = disposable;
                this.f7373a.mo3284a(this);
            }
        }

        @Override // p136d.p153c.p157c0.Disposable
        /* renamed from: b */
        public void mo578b() {
            this.f7375c.mo578b();
        }

        @Override // p136d.p153c.p157c0.Disposable
        /* renamed from: c */
        public boolean mo577c() {
            return this.f7375c.mo577c();
        }

        @Override // p136d.p153c.InterfaceC1730s
        /* renamed from: a */
        public void mo570a(T t) {
            if (this.f7377e) {
                return;
            }
            if (this.f7376d != null) {
                this.f7377e = true;
                this.f7375c.mo578b();
                this.f7373a.mo3283a(new IllegalArgumentException("Sequence contains more than one element!"));
                return;
            }
            this.f7376d = t;
        }

        @Override // p136d.p153c.InterfaceC1730s
        /* renamed from: a */
        public void mo569a(Throwable th) {
            if (this.f7377e) {
                RxJavaPlugins.m3371b(th);
                return;
            }
            this.f7377e = true;
            this.f7373a.mo3283a(th);
        }

        @Override // p136d.p153c.InterfaceC1730s
        /* renamed from: a */
        public void mo573a() {
            if (this.f7377e) {
                return;
            }
            this.f7377e = true;
            T t = this.f7376d;
            this.f7376d = null;
            if (t == null) {
                t = this.f7374b;
            }
            if (t != null) {
                this.f7373a.mo3282b(t);
            } else {
                this.f7373a.mo3283a(new NoSuchElementException());
            }
        }
    }
}
