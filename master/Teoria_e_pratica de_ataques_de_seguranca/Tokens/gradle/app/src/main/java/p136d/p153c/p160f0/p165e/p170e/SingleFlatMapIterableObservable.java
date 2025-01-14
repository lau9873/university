package p136d.p153c.p160f0.p165e.p170e;

import java.util.Iterator;
import p136d.p153c.InterfaceC1730s;
import p136d.p153c.Observable;
import p136d.p153c.SingleObserver;
import p136d.p153c.SingleSource;
import p136d.p153c.p157c0.Disposable;
import p136d.p153c.p158d0.Exceptions;
import p136d.p153c.p159e0.Function;
import p136d.p153c.p160f0.p161a.DisposableHelper;
import p136d.p153c.p160f0.p162b.ObjectHelper;
import p136d.p153c.p160f0.p164d.BasicIntQueueDisposable;

/* renamed from: d.c.f0.e.e.x */
/* loaded from: classes.dex */
public final class SingleFlatMapIterableObservable<T, R> extends Observable<R> {

    /* renamed from: a */
    public final SingleSource<T> f7592a;

    /* renamed from: b */
    public final Function<? super T, ? extends Iterable<? extends R>> f7593b;

    public SingleFlatMapIterableObservable(SingleSource<T> singleSource, Function<? super T, ? extends Iterable<? extends R>> function) {
        this.f7592a = singleSource;
        this.f7593b = function;
    }

    @Override // p136d.p153c.Observable
    /* renamed from: b */
    public void mo574b(InterfaceC1730s<? super R> interfaceC1730s) {
        this.f7592a.subscribe(new C1701a(interfaceC1730s, this.f7593b));
    }

    /* compiled from: SingleFlatMapIterableObservable.java */
    /* renamed from: d.c.f0.e.e.x$a */
    /* loaded from: classes.dex */
    public static final class C1701a<T, R> extends BasicIntQueueDisposable<R> implements SingleObserver<T> {

        /* renamed from: a */
        public final InterfaceC1730s<? super R> f7594a;

        /* renamed from: b */
        public final Function<? super T, ? extends Iterable<? extends R>> f7595b;

        /* renamed from: c */
        public Disposable f7596c;

        /* renamed from: d */
        public volatile Iterator<? extends R> f7597d;

        /* renamed from: e */
        public volatile boolean f7598e;

        /* renamed from: f */
        public boolean f7599f;

        public C1701a(InterfaceC1730s<? super R> interfaceC1730s, Function<? super T, ? extends Iterable<? extends R>> function) {
            this.f7594a = interfaceC1730s;
            this.f7595b = function;
        }

        @Override // p136d.p153c.SingleObserver
        /* renamed from: a */
        public void mo3284a(Disposable disposable) {
            if (DisposableHelper.m3648a(this.f7596c, disposable)) {
                this.f7596c = disposable;
                this.f7594a.mo572a((Disposable) this);
            }
        }

        @Override // p136d.p153c.SingleObserver
        /* renamed from: b */
        public void mo3282b(T t) {
            InterfaceC1730s<? super R> interfaceC1730s = this.f7594a;
            try {
                Iterator<? extends R> it = this.f7595b.mo3490a(t).iterator();
                if (!it.hasNext()) {
                    interfaceC1730s.mo573a();
                } else if (this.f7599f) {
                    this.f7597d = it;
                    interfaceC1730s.mo570a((InterfaceC1730s<? super R>) null);
                    interfaceC1730s.mo573a();
                } else {
                    while (!this.f7598e) {
                        try {
                            interfaceC1730s.mo570a((InterfaceC1730s<? super R>) ((R) it.next()));
                            if (this.f7598e) {
                                return;
                            }
                            try {
                                if (!it.hasNext()) {
                                    interfaceC1730s.mo573a();
                                    return;
                                }
                            } catch (Throwable th) {
                                Exceptions.m3660b(th);
                                interfaceC1730s.mo569a(th);
                                return;
                            }
                        } catch (Throwable th2) {
                            Exceptions.m3660b(th2);
                            interfaceC1730s.mo569a(th2);
                            return;
                        }
                    }
                }
            } catch (Throwable th3) {
                Exceptions.m3660b(th3);
                this.f7594a.mo569a(th3);
            }
        }

        @Override // p136d.p153c.p157c0.Disposable
        /* renamed from: c */
        public boolean mo577c() {
            return this.f7598e;
        }

        @Override // p136d.p153c.p160f0.p163c.SimpleQueue
        public void clear() {
            this.f7597d = null;
        }

        @Override // p136d.p153c.p160f0.p163c.SimpleQueue
        public boolean isEmpty() {
            return this.f7597d == null;
        }

        @Override // p136d.p153c.p160f0.p163c.SimpleQueue
        public R poll() {
            Iterator<? extends R> it = this.f7597d;
            if (it != null) {
                R next = it.next();
                ObjectHelper.m3598a(next, "The iterator returned a null value");
                if (!it.hasNext()) {
                    this.f7597d = null;
                }
                return next;
            }
            return null;
        }

        @Override // p136d.p153c.SingleObserver
        /* renamed from: a */
        public void mo3283a(Throwable th) {
            this.f7596c = DisposableHelper.DISPOSED;
            this.f7594a.mo569a(th);
        }

        @Override // p136d.p153c.p160f0.p163c.QueueFuseable
        /* renamed from: a */
        public int mo3356a(int i) {
            if ((i & 2) != 0) {
                this.f7599f = true;
                return 2;
            }
            return 0;
        }

        @Override // p136d.p153c.p157c0.Disposable
        /* renamed from: b */
        public void mo578b() {
            this.f7598e = true;
            this.f7596c.mo578b();
            this.f7596c = DisposableHelper.DISPOSED;
        }
    }
}
