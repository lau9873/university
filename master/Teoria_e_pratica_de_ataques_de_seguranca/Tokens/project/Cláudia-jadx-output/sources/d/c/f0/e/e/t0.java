package d.c.f0.e.e;

import d.c.f0.e.e.g0;
import d.c.f0.e.e.s0;
import java.util.Arrays;
import java.util.NoSuchElementException;
/* compiled from: SingleZipIterable.java */
/* loaded from: classes.dex */
public final class t0<T, R> extends d.c.u<R> {

    /* renamed from: a  reason: collision with root package name */
    public final Iterable<? extends d.c.z<? extends T>> f5235a;

    /* renamed from: b  reason: collision with root package name */
    public final d.c.e0.n<? super Object[], ? extends R> f5236b;

    /* compiled from: SingleZipIterable.java */
    /* loaded from: classes.dex */
    public class a implements d.c.e0.n<T, R> {
        public a() {
        }

        /* JADX WARN: Type inference failed for: r1v1, types: [java.lang.Object[], java.lang.Object] */
        @Override // d.c.e0.n
        public R a(T t) {
            return t0.this.f5236b.a(new Object[]{t});
        }
    }

    public t0(Iterable<? extends d.c.z<? extends T>> iterable, d.c.e0.n<? super Object[], ? extends R> nVar) {
        this.f5235a = iterable;
        this.f5236b = nVar;
    }

    @Override // d.c.u
    public void subscribeActual(d.c.w<? super R> wVar) {
        d.c.z[] zVarArr = new d.c.z[8];
        try {
            d.c.z[] zVarArr2 = zVarArr;
            int i2 = 0;
            for (d.c.z<? extends T> zVar : this.f5235a) {
                if (zVar == null) {
                    d.c.f0.a.c.a(new NullPointerException("One of the sources is null"), wVar);
                    return;
                }
                if (i2 == zVarArr2.length) {
                    zVarArr2 = (d.c.z[]) Arrays.copyOf(zVarArr2, (i2 >> 2) + i2);
                }
                int i3 = i2 + 1;
                zVarArr2[i2] = zVar;
                i2 = i3;
            }
            if (i2 == 0) {
                d.c.f0.a.c.a(new NoSuchElementException(), wVar);
            } else if (i2 == 1) {
                zVarArr2[0].subscribe(new g0.a(wVar, new a()));
            } else {
                s0.b bVar = new s0.b(wVar, i2, this.f5236b);
                wVar.a(bVar);
                for (int i4 = 0; i4 < i2 && !bVar.c(); i4++) {
                    zVarArr2[i4].subscribe(bVar.f5230c[i4]);
                }
            }
        } catch (Throwable th) {
            d.c.d0.a.b(th);
            d.c.f0.a.c.a(th, wVar);
        }
    }
}
