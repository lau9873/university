package p136d.p153c.p160f0.p165e.p170e;

import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import p136d.p153c.Single;
import p136d.p153c.SingleObserver;
import p136d.p153c.SingleSource;
import p136d.p153c.p157c0.Disposable;

/* renamed from: d.c.f0.e.e.b */
/* loaded from: classes.dex */
public final class SingleCache<T> extends Single<T> implements SingleObserver<T> {

    /* renamed from: f */
    public static final C1656a[] f7397f = new C1656a[0];

    /* renamed from: g */
    public static final C1656a[] f7398g = new C1656a[0];

    /* renamed from: a */
    public final SingleSource<? extends T> f7399a;

    /* renamed from: b */
    public final AtomicInteger f7400b = new AtomicInteger();

    /* renamed from: c */
    public final AtomicReference<C1656a<T>[]> f7401c = new AtomicReference<>(f7397f);

    /* renamed from: d */
    public T f7402d;

    /* renamed from: e */
    public Throwable f7403e;

    /* compiled from: SingleCache.java */
    /* renamed from: d.c.f0.e.e.b$a */
    /* loaded from: classes.dex */
    public static final class C1656a<T> extends AtomicBoolean implements Disposable {

        /* renamed from: a */
        public final SingleObserver<? super T> f7404a;

        /* renamed from: b */
        public final SingleCache<T> f7405b;

        public C1656a(SingleObserver<? super T> singleObserver, SingleCache<T> singleCache) {
            this.f7404a = singleObserver;
            this.f7405b = singleCache;
        }

        @Override // p136d.p153c.p157c0.Disposable
        /* renamed from: b */
        public void mo578b() {
            if (compareAndSet(false, true)) {
                this.f7405b.m3509b((C1656a) this);
            }
        }

        @Override // p136d.p153c.p157c0.Disposable
        /* renamed from: c */
        public boolean mo577c() {
            return get();
        }
    }

    public SingleCache(SingleSource<? extends T> singleSource) {
        this.f7399a = singleSource;
    }

    @Override // p136d.p153c.SingleObserver
    /* renamed from: a */
    public void mo3284a(Disposable disposable) {
    }

    /* renamed from: a */
    public boolean m3510a(C1656a<T> c1656a) {
        C1656a<T>[] c1656aArr;
        C1656a<T>[] c1656aArr2;
        do {
            c1656aArr = this.f7401c.get();
            if (c1656aArr == f7398g) {
                return false;
            }
            int length = c1656aArr.length;
            c1656aArr2 = new C1656a[length + 1];
            System.arraycopy(c1656aArr, 0, c1656aArr2, 0, length);
            c1656aArr2[length] = c1656a;
        } while (!this.f7401c.compareAndSet(c1656aArr, c1656aArr2));
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: b */
    public void m3509b(C1656a<T> c1656a) {
        C1656a<T>[] c1656aArr;
        C1656a[] c1656aArr2;
        do {
            c1656aArr = this.f7401c.get();
            int length = c1656aArr.length;
            if (length == 0) {
                return;
            }
            int i = -1;
            int i2 = 0;
            while (true) {
                if (i2 >= length) {
                    break;
                } else if (c1656aArr[i2] == c1656a) {
                    i = i2;
                    break;
                } else {
                    i2++;
                }
            }
            if (i < 0) {
                return;
            }
            if (length == 1) {
                c1656aArr2 = f7397f;
            } else {
                C1656a[] c1656aArr3 = new C1656a[length - 1];
                System.arraycopy(c1656aArr, 0, c1656aArr3, 0, i);
                System.arraycopy(c1656aArr, i + 1, c1656aArr3, i, (length - i) - 1);
                c1656aArr2 = c1656aArr3;
            }
        } while (!this.f7401c.compareAndSet(c1656aArr, c1656aArr2));
    }

    @Override // p136d.p153c.Single
    public void subscribeActual(SingleObserver<? super T> singleObserver) {
        C1656a<T> c1656a = new C1656a<>(singleObserver, this);
        singleObserver.mo3284a(c1656a);
        if (m3510a((C1656a) c1656a)) {
            if (c1656a.mo577c()) {
                m3509b((C1656a) c1656a);
            }
            if (this.f7400b.getAndIncrement() == 0) {
                this.f7399a.subscribe(this);
                return;
            }
            return;
        }
        Throwable th = this.f7403e;
        if (th != null) {
            singleObserver.mo3283a(th);
        } else {
            singleObserver.mo3282b((T) this.f7402d);
        }
    }

    @Override // p136d.p153c.SingleObserver
    /* renamed from: a */
    public void mo3283a(Throwable th) {
        C1656a<T>[] andSet;
        this.f7403e = th;
        for (C1656a<T> c1656a : this.f7401c.getAndSet(f7398g)) {
            if (!c1656a.mo577c()) {
                c1656a.f7404a.mo3283a(th);
            }
        }
    }

    @Override // p136d.p153c.SingleObserver
    /* renamed from: b */
    public void mo3282b(T t) {
        C1656a<T>[] andSet;
        this.f7402d = t;
        for (C1656a<T> c1656a : this.f7401c.getAndSet(f7398g)) {
            if (!c1656a.mo577c()) {
                c1656a.f7404a.mo3282b(t);
            }
        }
    }
}
