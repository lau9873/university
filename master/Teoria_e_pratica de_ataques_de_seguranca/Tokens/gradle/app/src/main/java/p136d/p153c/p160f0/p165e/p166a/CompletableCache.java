package p136d.p153c.p160f0.p165e.p166a;

import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;
import p136d.p153c.Completable;
import p136d.p153c.CompletableObserver;
import p136d.p153c.CompletableSource;
import p136d.p153c.p157c0.Disposable;

/* renamed from: d.c.f0.e.a.b */
/* loaded from: classes.dex */
public final class CompletableCache extends Completable implements CompletableObserver {

    /* renamed from: e */
    public static final C1563a[] f6924e = new C1563a[0];

    /* renamed from: f */
    public static final C1563a[] f6925f = new C1563a[0];

    /* renamed from: a */
    public final CompletableSource f6926a;

    /* renamed from: b */
    public final AtomicReference<C1563a[]> f6927b = new AtomicReference<>(f6924e);

    /* renamed from: c */
    public final AtomicBoolean f6928c = new AtomicBoolean();

    /* renamed from: d */
    public Throwable f6929d;

    /* compiled from: CompletableCache.java */
    /* renamed from: d.c.f0.e.a.b$a */
    /* loaded from: classes.dex */
    public final class C1563a extends AtomicBoolean implements Disposable {

        /* renamed from: a */
        public final CompletableObserver f6930a;

        public C1563a(CompletableObserver completableObserver) {
            this.f6930a = completableObserver;
        }

        @Override // p136d.p153c.p157c0.Disposable
        /* renamed from: b */
        public void mo578b() {
            if (compareAndSet(false, true)) {
                CompletableCache.this.m3587b(this);
            }
        }

        @Override // p136d.p153c.p157c0.Disposable
        /* renamed from: c */
        public boolean mo577c() {
            return get();
        }
    }

    public CompletableCache(CompletableSource completableSource) {
        this.f6926a = completableSource;
    }

    @Override // p136d.p153c.CompletableObserver
    /* renamed from: a */
    public void mo3502a(Disposable disposable) {
    }

    @Override // p136d.p153c.CompletableObserver
    /* renamed from: a */
    public void mo3501a(Throwable th) {
        C1563a[] andSet;
        this.f6929d = th;
        for (C1563a c1563a : this.f6927b.getAndSet(f6925f)) {
            if (!c1563a.get()) {
                c1563a.f6930a.mo3501a(th);
            }
        }
    }

    /* renamed from: b */
    public void m3587b(C1563a c1563a) {
        C1563a[] c1563aArr;
        C1563a[] c1563aArr2;
        do {
            c1563aArr = this.f6927b.get();
            int length = c1563aArr.length;
            if (length == 0) {
                return;
            }
            int i = -1;
            int i2 = 0;
            while (true) {
                if (i2 >= length) {
                    break;
                } else if (c1563aArr[i2] == c1563a) {
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
                c1563aArr2 = f6924e;
            } else {
                C1563a[] c1563aArr3 = new C1563a[length - 1];
                System.arraycopy(c1563aArr, 0, c1563aArr3, 0, i);
                System.arraycopy(c1563aArr, i + 1, c1563aArr3, i, (length - i) - 1);
                c1563aArr2 = c1563aArr3;
            }
        } while (!this.f6927b.compareAndSet(c1563aArr, c1563aArr2));
    }

    @Override // p136d.p153c.Completable
    public void subscribeActual(CompletableObserver completableObserver) {
        C1563a c1563a = new C1563a(completableObserver);
        completableObserver.mo3502a(c1563a);
        if (m3588a(c1563a)) {
            if (c1563a.mo577c()) {
                m3587b(c1563a);
            }
            if (this.f6928c.compareAndSet(false, true)) {
                this.f6926a.subscribe(this);
                return;
            }
            return;
        }
        Throwable th = this.f6929d;
        if (th != null) {
            completableObserver.mo3501a(th);
        } else {
            completableObserver.mo3489a();
        }
    }

    @Override // p136d.p153c.CompletableObserver
    /* renamed from: a */
    public void mo3489a() {
        C1563a[] andSet;
        for (C1563a c1563a : this.f6927b.getAndSet(f6925f)) {
            if (!c1563a.get()) {
                c1563a.f6930a.mo3489a();
            }
        }
    }

    /* renamed from: a */
    public boolean m3588a(C1563a c1563a) {
        C1563a[] c1563aArr;
        C1563a[] c1563aArr2;
        do {
            c1563aArr = this.f6927b.get();
            if (c1563aArr == f6925f) {
                return false;
            }
            int length = c1563aArr.length;
            c1563aArr2 = new C1563a[length + 1];
            System.arraycopy(c1563aArr, 0, c1563aArr2, 0, length);
            c1563aArr2[length] = c1563a;
        } while (!this.f6927b.compareAndSet(c1563aArr, c1563aArr2));
        return true;
    }
}
