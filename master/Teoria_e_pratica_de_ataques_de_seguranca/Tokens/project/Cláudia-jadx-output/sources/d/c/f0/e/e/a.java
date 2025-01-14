package d.c.f0.e.e;

import java.util.concurrent.atomic.AtomicBoolean;
/* compiled from: SingleAmb.java */
/* loaded from: classes.dex */
public final class a<T> extends d.c.u<T> {

    /* renamed from: a  reason: collision with root package name */
    public final d.c.z<? extends T>[] f5052a;

    /* renamed from: b  reason: collision with root package name */
    public final Iterable<? extends d.c.z<? extends T>> f5053b;

    /* compiled from: SingleAmb.java */
    /* renamed from: d.c.f0.e.e.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static final class C0108a<T> extends AtomicBoolean implements d.c.w<T> {

        /* renamed from: a  reason: collision with root package name */
        public final d.c.c0.a f5054a;

        /* renamed from: b  reason: collision with root package name */
        public final d.c.w<? super T> f5055b;

        public C0108a(d.c.w<? super T> wVar, d.c.c0.a aVar) {
            this.f5055b = wVar;
            this.f5054a = aVar;
        }

        @Override // d.c.w
        public void a(d.c.c0.b bVar) {
            this.f5054a.c(bVar);
        }

        @Override // d.c.w
        public void b(T t) {
            if (compareAndSet(false, true)) {
                this.f5054a.b();
                this.f5055b.b(t);
            }
        }

        @Override // d.c.w
        public void a(Throwable th) {
            if (compareAndSet(false, true)) {
                this.f5054a.b();
                this.f5055b.a(th);
                return;
            }
            d.c.h0.a.b(th);
        }
    }

    public a(d.c.z<? extends T>[] zVarArr, Iterable<? extends d.c.z<? extends T>> iterable) {
        this.f5052a = zVarArr;
        this.f5053b = iterable;
    }

    @Override // d.c.u
    public void subscribeActual(d.c.w<? super T> wVar) {
        int length;
        d.c.z<? extends T>[] zVarArr = this.f5052a;
        if (zVarArr == null) {
            zVarArr = new d.c.z[8];
            try {
                length = 0;
                for (d.c.z<? extends T> zVar : this.f5053b) {
                    if (zVar == null) {
                        d.c.f0.a.c.a(new NullPointerException("One of the sources is null"), wVar);
                        return;
                    }
                    if (length == zVarArr.length) {
                        d.c.z<? extends T>[] zVarArr2 = new d.c.z[(length >> 2) + length];
                        System.arraycopy(zVarArr, 0, zVarArr2, 0, length);
                        zVarArr = zVarArr2;
                    }
                    int i2 = length + 1;
                    zVarArr[length] = zVar;
                    length = i2;
                }
            } catch (Throwable th) {
                d.c.d0.a.b(th);
                d.c.f0.a.c.a(th, wVar);
                return;
            }
        } else {
            length = zVarArr.length;
        }
        d.c.c0.a aVar = new d.c.c0.a();
        C0108a c0108a = new C0108a(wVar, aVar);
        wVar.a(aVar);
        for (int i3 = 0; i3 < length; i3++) {
            d.c.z<? extends T> zVar2 = zVarArr[i3];
            if (c0108a.get()) {
                return;
            }
            if (zVar2 == null) {
                aVar.b();
                NullPointerException nullPointerException = new NullPointerException("One of the sources is null");
                if (c0108a.compareAndSet(false, true)) {
                    wVar.a(nullPointerException);
                    return;
                } else {
                    d.c.h0.a.b(nullPointerException);
                    return;
                }
            }
            zVar2.subscribe(c0108a);
        }
    }
}
