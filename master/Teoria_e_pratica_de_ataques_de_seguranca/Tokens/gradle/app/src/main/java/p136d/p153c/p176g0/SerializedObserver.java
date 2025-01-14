package p136d.p153c.p176g0;

import p136d.p153c.InterfaceC1730s;
import p136d.p153c.p157c0.Disposable;
import p136d.p153c.p160f0.p161a.DisposableHelper;
import p136d.p153c.p160f0.p175j.AppendOnlyLinkedArrayList;
import p136d.p153c.p160f0.p175j.NotificationLite;
import p136d.p153c.p177h0.RxJavaPlugins;

/* renamed from: d.c.g0.b */
/* loaded from: classes.dex */
public final class SerializedObserver<T> implements InterfaceC1730s<T>, Disposable {

    /* renamed from: a */
    public final InterfaceC1730s<? super T> f7730a;

    /* renamed from: b */
    public final boolean f7731b;

    /* renamed from: c */
    public Disposable f7732c;

    /* renamed from: d */
    public boolean f7733d;

    /* renamed from: e */
    public AppendOnlyLinkedArrayList<Object> f7734e;

    /* renamed from: f */
    public volatile boolean f7735f;

    public SerializedObserver(InterfaceC1730s<? super T> interfaceC1730s) {
        this(interfaceC1730s, false);
    }

    @Override // p136d.p153c.InterfaceC1730s
    /* renamed from: a */
    public void mo572a(Disposable disposable) {
        if (DisposableHelper.m3648a(this.f7732c, disposable)) {
            this.f7732c = disposable;
            this.f7730a.mo572a((Disposable) this);
        }
    }

    @Override // p136d.p153c.p157c0.Disposable
    /* renamed from: b */
    public void mo578b() {
        this.f7732c.mo578b();
    }

    @Override // p136d.p153c.p157c0.Disposable
    /* renamed from: c */
    public boolean mo577c() {
        return this.f7732c.mo577c();
    }

    /* renamed from: d */
    public void m3394d() {
        AppendOnlyLinkedArrayList<Object> appendOnlyLinkedArrayList;
        do {
            synchronized (this) {
                appendOnlyLinkedArrayList = this.f7734e;
                if (appendOnlyLinkedArrayList == null) {
                    this.f7733d = false;
                    return;
                }
                this.f7734e = null;
            }
        } while (!appendOnlyLinkedArrayList.m3423a((InterfaceC1730s<? super T>) this.f7730a));
    }

    public SerializedObserver(InterfaceC1730s<? super T> interfaceC1730s, boolean z) {
        this.f7730a = interfaceC1730s;
        this.f7731b = z;
    }

    @Override // p136d.p153c.InterfaceC1730s
    /* renamed from: a */
    public void mo570a(T t) {
        if (this.f7735f) {
            return;
        }
        if (t == null) {
            this.f7732c.mo578b();
            mo569a((Throwable) new NullPointerException("onNext called with null. Null values are generally not allowed in 2.x operators and sources."));
            return;
        }
        synchronized (this) {
            if (this.f7735f) {
                return;
            }
            if (this.f7733d) {
                AppendOnlyLinkedArrayList<Object> appendOnlyLinkedArrayList = this.f7734e;
                if (appendOnlyLinkedArrayList == null) {
                    appendOnlyLinkedArrayList = new AppendOnlyLinkedArrayList<>(4);
                    this.f7734e = appendOnlyLinkedArrayList;
                }
                NotificationLite.m3406a(t);
                appendOnlyLinkedArrayList.m3421a((AppendOnlyLinkedArrayList<Object>) t);
                return;
            }
            this.f7733d = true;
            this.f7730a.mo570a((InterfaceC1730s<? super T>) t);
            m3394d();
        }
    }

    @Override // p136d.p153c.InterfaceC1730s
    /* renamed from: a */
    public void mo569a(Throwable th) {
        if (this.f7735f) {
            RxJavaPlugins.m3371b(th);
            return;
        }
        synchronized (this) {
            boolean z = true;
            if (!this.f7735f) {
                if (this.f7733d) {
                    this.f7735f = true;
                    AppendOnlyLinkedArrayList<Object> appendOnlyLinkedArrayList = this.f7734e;
                    if (appendOnlyLinkedArrayList == null) {
                        appendOnlyLinkedArrayList = new AppendOnlyLinkedArrayList<>(4);
                        this.f7734e = appendOnlyLinkedArrayList;
                    }
                    Object m3403a = NotificationLite.m3403a(th);
                    if (this.f7731b) {
                        appendOnlyLinkedArrayList.m3421a((AppendOnlyLinkedArrayList<Object>) m3403a);
                    } else {
                        appendOnlyLinkedArrayList.m3420b(m3403a);
                    }
                    return;
                }
                this.f7735f = true;
                this.f7733d = true;
                z = false;
            }
            if (z) {
                RxJavaPlugins.m3371b(th);
            } else {
                this.f7730a.mo569a(th);
            }
        }
    }

    @Override // p136d.p153c.InterfaceC1730s
    /* renamed from: a */
    public void mo573a() {
        if (this.f7735f) {
            return;
        }
        synchronized (this) {
            if (this.f7735f) {
                return;
            }
            if (this.f7733d) {
                AppendOnlyLinkedArrayList<Object> appendOnlyLinkedArrayList = this.f7734e;
                if (appendOnlyLinkedArrayList == null) {
                    appendOnlyLinkedArrayList = new AppendOnlyLinkedArrayList<>(4);
                    this.f7734e = appendOnlyLinkedArrayList;
                }
                appendOnlyLinkedArrayList.m3421a((AppendOnlyLinkedArrayList<Object>) NotificationLite.m3402b());
                return;
            }
            this.f7735f = true;
            this.f7733d = true;
            this.f7730a.mo573a();
        }
    }
}
