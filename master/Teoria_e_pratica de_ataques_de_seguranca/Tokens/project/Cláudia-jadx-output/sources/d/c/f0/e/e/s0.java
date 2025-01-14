package d.c.f0.e.e;

import d.c.f0.e.e.g0;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
/* compiled from: SingleZipArray.java */
/* loaded from: classes.dex */
public final class s0<T, R> extends d.c.u<R> {

    /* renamed from: a  reason: collision with root package name */
    public final d.c.z<? extends T>[] f5225a;

    /* renamed from: b  reason: collision with root package name */
    public final d.c.e0.n<? super Object[], ? extends R> f5226b;

    /* compiled from: SingleZipArray.java */
    /* loaded from: classes.dex */
    public class a implements d.c.e0.n<T, R> {
        public a() {
        }

        /* JADX WARN: Type inference failed for: r1v1, types: [java.lang.Object[], java.lang.Object] */
        @Override // d.c.e0.n
        public R a(T t) {
            return s0.this.f5226b.a(new Object[]{t});
        }
    }

    /* compiled from: SingleZipArray.java */
    /* loaded from: classes.dex */
    public static final class c<T> extends AtomicReference<d.c.c0.b> implements d.c.w<T> {

        /* renamed from: a  reason: collision with root package name */
        public final b<T, ?> f5232a;

        /* renamed from: b  reason: collision with root package name */
        public final int f5233b;

        public c(b<T, ?> bVar, int i2) {
            this.f5232a = bVar;
            this.f5233b = i2;
        }

        public void a() {
            d.c.f0.a.b.a(this);
        }

        @Override // d.c.w
        public void b(T t) {
            this.f5232a.a((b<T, ?>) t, this.f5233b);
        }

        @Override // d.c.w
        public void a(d.c.c0.b bVar) {
            d.c.f0.a.b.c(this, bVar);
        }

        @Override // d.c.w
        public void a(Throwable th) {
            this.f5232a.a(th, this.f5233b);
        }
    }

    public s0(d.c.z<? extends T>[] zVarArr, d.c.e0.n<? super Object[], ? extends R> nVar) {
        this.f5225a = zVarArr;
        this.f5226b = nVar;
    }

    @Override // d.c.u
    public void subscribeActual(d.c.w<? super R> wVar) {
        d.c.z<? extends T>[] zVarArr = this.f5225a;
        int length = zVarArr.length;
        if (length == 1) {
            zVarArr[0].subscribe(new g0.a(wVar, new a()));
            return;
        }
        b bVar = new b(wVar, length, this.f5226b);
        wVar.a(bVar);
        for (int i2 = 0; i2 < length && !bVar.c(); i2++) {
            d.c.z<? extends T> zVar = zVarArr[i2];
            if (zVar == null) {
                bVar.a((Throwable) new NullPointerException("One of the sources is null"), i2);
                return;
            }
            zVar.subscribe(bVar.f5230c[i2]);
        }
    }

    /* compiled from: SingleZipArray.java */
    /* loaded from: classes.dex */
    public static final class b<T, R> extends AtomicInteger implements d.c.c0.b {

        /* renamed from: a  reason: collision with root package name */
        public final d.c.w<? super R> f5228a;

        /* renamed from: b  reason: collision with root package name */
        public final d.c.e0.n<? super Object[], ? extends R> f5229b;

        /* renamed from: c  reason: collision with root package name */
        public final c<T>[] f5230c;

        /* renamed from: d  reason: collision with root package name */
        public final Object[] f5231d;

        public b(d.c.w<? super R> wVar, int i2, d.c.e0.n<? super Object[], ? extends R> nVar) {
            super(i2);
            this.f5228a = wVar;
            this.f5229b = nVar;
            c<T>[] cVarArr = new c[i2];
            for (int i3 = 0; i3 < i2; i3++) {
                cVarArr[i3] = new c<>(this, i3);
            }
            this.f5230c = cVarArr;
            this.f5231d = new Object[i2];
        }

        public void a(T t, int i2) {
            this.f5231d[i2] = t;
            if (decrementAndGet() == 0) {
                try {
                    R a2 = this.f5229b.a(this.f5231d);
                    d.c.f0.b.b.a(a2, "The zipper returned a null value");
                    this.f5228a.b(a2);
                } catch (Throwable th) {
                    d.c.d0.a.b(th);
                    this.f5228a.a(th);
                }
            }
        }

        @Override // d.c.c0.b
        public void b() {
            if (getAndSet(0) > 0) {
                for (c<T> cVar : this.f5230c) {
                    cVar.a();
                }
            }
        }

        @Override // d.c.c0.b
        public boolean c() {
            return get() <= 0;
        }

        public void a(int i2) {
            c<T>[] cVarArr = this.f5230c;
            int length = cVarArr.length;
            for (int i3 = 0; i3 < i2; i3++) {
                cVarArr[i3].a();
            }
            while (true) {
                i2++;
                if (i2 >= length) {
                    return;
                }
                cVarArr[i2].a();
            }
        }

        public void a(Throwable th, int i2) {
            if (getAndSet(0) > 0) {
                a(i2);
                this.f5228a.a(th);
                return;
            }
            d.c.h0.a.b(th);
        }
    }
}
