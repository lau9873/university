package p136d.p153c.p160f0.p165e.p170e;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import p136d.p153c.Single;
import p136d.p153c.SingleObserver;
import p136d.p153c.SingleSource;
import p136d.p153c.p157c0.Disposable;
import p136d.p153c.p158d0.Exceptions;
import p136d.p153c.p159e0.Function;
import p136d.p153c.p160f0.p161a.DisposableHelper;
import p136d.p153c.p160f0.p162b.ObjectHelper;
import p136d.p153c.p160f0.p165e.p170e.SingleMap;
import p136d.p153c.p177h0.RxJavaPlugins;

/* renamed from: d.c.f0.e.e.s0 */
/* loaded from: classes.dex */
public final class SingleZipArray<T, R> extends Single<R> {

    /* renamed from: a */
    public final SingleSource<? extends T>[] f7560a;

    /* renamed from: b */
    public final Function<? super Object[], ? extends R> f7561b;

    /* compiled from: SingleZipArray.java */
    /* renamed from: d.c.f0.e.e.s0$a */
    /* loaded from: classes.dex */
    public class C1693a implements Function<T, R> {
        public C1693a() {
        }

        /* JADX WARN: Type inference failed for: r1v1, types: [java.lang.Object[], java.lang.Object] */
        @Override // p136d.p153c.p159e0.Function
        /* renamed from: a */
        public R mo3490a(T t) {
            return SingleZipArray.this.f7561b.mo3490a(new Object[]{t});
        }
    }

    /* compiled from: SingleZipArray.java */
    /* renamed from: d.c.f0.e.e.s0$c */
    /* loaded from: classes.dex */
    public static final class C1695c<T> extends AtomicReference<Disposable> implements SingleObserver<T> {

        /* renamed from: a */
        public final C1694b<T, ?> f7567a;

        /* renamed from: b */
        public final int f7568b;

        public C1695c(C1694b<T, ?> c1694b, int i) {
            this.f7567a = c1694b;
            this.f7568b = i;
        }

        /* renamed from: a */
        public void m3491a() {
            DisposableHelper.m3647a(this);
        }

        @Override // p136d.p153c.SingleObserver
        /* renamed from: b */
        public void mo3282b(T t) {
            this.f7567a.m3493a((C1694b<T, ?>) t, this.f7568b);
        }

        @Override // p136d.p153c.SingleObserver
        /* renamed from: a */
        public void mo3284a(Disposable disposable) {
            DisposableHelper.m3644c(this, disposable);
        }

        @Override // p136d.p153c.SingleObserver
        /* renamed from: a */
        public void mo3283a(Throwable th) {
            this.f7567a.m3492a(th, this.f7568b);
        }
    }

    public SingleZipArray(SingleSource<? extends T>[] singleSourceArr, Function<? super Object[], ? extends R> function) {
        this.f7560a = singleSourceArr;
        this.f7561b = function;
    }

    @Override // p136d.p153c.Single
    public void subscribeActual(SingleObserver<? super R> singleObserver) {
        SingleSource<? extends T>[] singleSourceArr = this.f7560a;
        int length = singleSourceArr.length;
        if (length == 1) {
            singleSourceArr[0].subscribe(new SingleMap.C1667a(singleObserver, new C1693a()));
            return;
        }
        C1694b c1694b = new C1694b(singleObserver, length, this.f7561b);
        singleObserver.mo3284a(c1694b);
        for (int i = 0; i < length && !c1694b.mo577c(); i++) {
            SingleSource<? extends T> singleSource = singleSourceArr[i];
            if (singleSource == null) {
                c1694b.m3492a((Throwable) new NullPointerException("One of the sources is null"), i);
                return;
            }
            singleSource.subscribe(c1694b.f7565c[i]);
        }
    }

    /* compiled from: SingleZipArray.java */
    /* renamed from: d.c.f0.e.e.s0$b */
    /* loaded from: classes.dex */
    public static final class C1694b<T, R> extends AtomicInteger implements Disposable {

        /* renamed from: a */
        public final SingleObserver<? super R> f7563a;

        /* renamed from: b */
        public final Function<? super Object[], ? extends R> f7564b;

        /* renamed from: c */
        public final C1695c<T>[] f7565c;

        /* renamed from: d */
        public final Object[] f7566d;

        public C1694b(SingleObserver<? super R> singleObserver, int i, Function<? super Object[], ? extends R> function) {
            super(i);
            this.f7563a = singleObserver;
            this.f7564b = function;
            C1695c<T>[] c1695cArr = new C1695c[i];
            for (int i2 = 0; i2 < i; i2++) {
                c1695cArr[i2] = new C1695c<>(this, i2);
            }
            this.f7565c = c1695cArr;
            this.f7566d = new Object[i];
        }

        /* renamed from: a */
        public void m3493a(T t, int i) {
            this.f7566d[i] = t;
            if (decrementAndGet() == 0) {
                try {
                    R mo3490a = this.f7564b.mo3490a(this.f7566d);
                    ObjectHelper.m3598a(mo3490a, "The zipper returned a null value");
                    this.f7563a.mo3282b(mo3490a);
                } catch (Throwable th) {
                    Exceptions.m3660b(th);
                    this.f7563a.mo3283a(th);
                }
            }
        }

        @Override // p136d.p153c.p157c0.Disposable
        /* renamed from: b */
        public void mo578b() {
            if (getAndSet(0) > 0) {
                for (C1695c<T> c1695c : this.f7565c) {
                    c1695c.m3491a();
                }
            }
        }

        @Override // p136d.p153c.p157c0.Disposable
        /* renamed from: c */
        public boolean mo577c() {
            return get() <= 0;
        }

        /* renamed from: a */
        public void m3494a(int i) {
            C1695c<T>[] c1695cArr = this.f7565c;
            int length = c1695cArr.length;
            for (int i2 = 0; i2 < i; i2++) {
                c1695cArr[i2].m3491a();
            }
            while (true) {
                i++;
                if (i >= length) {
                    return;
                }
                c1695cArr[i].m3491a();
            }
        }

        /* renamed from: a */
        public void m3492a(Throwable th, int i) {
            if (getAndSet(0) > 0) {
                m3494a(i);
                this.f7563a.mo3283a(th);
                return;
            }
            RxJavaPlugins.m3371b(th);
        }
    }
}
