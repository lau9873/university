package p136d.p153c.p176g0;

import java.util.concurrent.atomic.AtomicReference;
import p136d.p153c.CompletableObserver;
import p136d.p153c.InterfaceC1730s;
import p136d.p153c.MaybeObserver;
import p136d.p153c.SingleObserver;
import p136d.p153c.p157c0.Disposable;
import p136d.p153c.p160f0.p161a.DisposableHelper;
import p136d.p153c.p160f0.p163c.QueueDisposable;

/* renamed from: d.c.g0.c */
/* loaded from: classes.dex */
public class TestObserver<T> extends BaseTestConsumer<T, TestObserver<T>> implements InterfaceC1730s<T>, Disposable, MaybeObserver<T>, SingleObserver<T>, CompletableObserver {

    /* renamed from: h */
    public final InterfaceC1730s<? super T> f7736h;

    /* renamed from: i */
    public final AtomicReference<Disposable> f7737i;

    /* renamed from: j */
    public QueueDisposable<T> f7738j;

    /* compiled from: TestObserver.java */
    /* renamed from: d.c.g0.c$a */
    /* loaded from: classes.dex */
    public enum EnumC1719a implements InterfaceC1730s<Object> {
        INSTANCE;

        @Override // p136d.p153c.InterfaceC1730s
        /* renamed from: a */
        public void mo573a() {
        }

        @Override // p136d.p153c.InterfaceC1730s
        /* renamed from: a */
        public void mo572a(Disposable disposable) {
        }

        @Override // p136d.p153c.InterfaceC1730s
        /* renamed from: a */
        public void mo570a(Object obj) {
        }

        @Override // p136d.p153c.InterfaceC1730s
        /* renamed from: a */
        public void mo569a(Throwable th) {
        }
    }

    public TestObserver() {
        this(EnumC1719a.INSTANCE);
    }

    @Override // p136d.p153c.InterfaceC1730s
    /* renamed from: a */
    public void mo572a(Disposable disposable) {
        Thread.currentThread();
        if (disposable == null) {
            this.f7725c.add(new NullPointerException("onSubscribe received a null Subscription"));
        } else if (!this.f7737i.compareAndSet(null, disposable)) {
            disposable.mo578b();
            if (this.f7737i.get() != DisposableHelper.DISPOSED) {
                this.f7725c.add(new IllegalStateException("onSubscribe received multiple subscriptions: " + disposable));
            }
        } else {
            int i = this.f7728f;
            if (i != 0 && (disposable instanceof QueueDisposable)) {
                this.f7738j = (QueueDisposable) disposable;
                int mo3356a = this.f7738j.mo3356a(i);
                this.f7729g = mo3356a;
                if (mo3356a == 1) {
                    this.f7727e = true;
                    Thread.currentThread();
                    while (true) {
                        try {
                            T poll = this.f7738j.poll();
                            if (poll != null) {
                                this.f7724b.add(poll);
                            } else {
                                this.f7726d++;
                                this.f7737i.lazySet(DisposableHelper.DISPOSED);
                                return;
                            }
                        } catch (Throwable th) {
                            this.f7725c.add(th);
                            return;
                        }
                    }
                }
            }
            this.f7736h.mo572a(disposable);
        }
    }

    @Override // p136d.p153c.p157c0.Disposable
    /* renamed from: b */
    public final void mo578b() {
        DisposableHelper.m3647a(this.f7737i);
    }

    @Override // p136d.p153c.p157c0.Disposable
    /* renamed from: c */
    public final boolean mo577c() {
        return DisposableHelper.m3649a(this.f7737i.get());
    }

    /* renamed from: d */
    public final void m3393d() {
        mo578b();
    }

    public TestObserver(InterfaceC1730s<? super T> interfaceC1730s) {
        this.f7737i = new AtomicReference<>();
        this.f7736h = interfaceC1730s;
    }

    @Override // p136d.p153c.SingleObserver
    /* renamed from: b */
    public void mo3282b(T t) {
        mo570a((TestObserver<T>) t);
        mo573a();
    }

    @Override // p136d.p153c.InterfaceC1730s
    /* renamed from: a */
    public void mo570a(T t) {
        if (!this.f7727e) {
            this.f7727e = true;
            if (this.f7737i.get() == null) {
                this.f7725c.add(new IllegalStateException("onSubscribe not called in proper order"));
            }
        }
        Thread.currentThread();
        if (this.f7729g != 2) {
            this.f7724b.add(t);
            if (t == null) {
                this.f7725c.add(new NullPointerException("onNext received a null value"));
            }
            this.f7736h.mo570a((InterfaceC1730s<? super T>) t);
            return;
        }
        while (true) {
            try {
                T poll = this.f7738j.poll();
                if (poll == null) {
                    return;
                }
                this.f7724b.add(poll);
            } catch (Throwable th) {
                this.f7725c.add(th);
                return;
            }
        }
    }

    @Override // p136d.p153c.InterfaceC1730s
    /* renamed from: a */
    public void mo569a(Throwable th) {
        if (!this.f7727e) {
            this.f7727e = true;
            if (this.f7737i.get() == null) {
                this.f7725c.add(new IllegalStateException("onSubscribe not called in proper order"));
            }
        }
        try {
            Thread.currentThread();
            if (th == null) {
                this.f7725c.add(new NullPointerException("onError received a null Throwable"));
            } else {
                this.f7725c.add(th);
            }
            this.f7736h.mo569a(th);
        } finally {
            this.f7723a.countDown();
        }
    }

    @Override // p136d.p153c.InterfaceC1730s
    /* renamed from: a */
    public void mo573a() {
        if (!this.f7727e) {
            this.f7727e = true;
            if (this.f7737i.get() == null) {
                this.f7725c.add(new IllegalStateException("onSubscribe not called in proper order"));
            }
        }
        try {
            Thread.currentThread();
            this.f7726d++;
            this.f7736h.mo573a();
        } finally {
            this.f7723a.countDown();
        }
    }
}
