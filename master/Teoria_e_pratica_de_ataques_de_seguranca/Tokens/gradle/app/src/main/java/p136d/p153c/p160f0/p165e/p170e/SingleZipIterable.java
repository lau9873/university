package p136d.p153c.p160f0.p165e.p170e;

import java.util.Arrays;
import java.util.NoSuchElementException;
import p136d.p153c.Single;
import p136d.p153c.SingleObserver;
import p136d.p153c.SingleSource;
import p136d.p153c.p158d0.Exceptions;
import p136d.p153c.p159e0.Function;
import p136d.p153c.p160f0.p161a.EmptyDisposable;
import p136d.p153c.p160f0.p165e.p170e.SingleMap;
import p136d.p153c.p160f0.p165e.p170e.SingleZipArray;

/* renamed from: d.c.f0.e.e.t0 */
/* loaded from: classes.dex */
public final class SingleZipIterable<T, R> extends Single<R> {

    /* renamed from: a */
    public final Iterable<? extends SingleSource<? extends T>> f7570a;

    /* renamed from: b */
    public final Function<? super Object[], ? extends R> f7571b;

    /* compiled from: SingleZipIterable.java */
    /* renamed from: d.c.f0.e.e.t0$a */
    /* loaded from: classes.dex */
    public class C1696a implements Function<T, R> {
        public C1696a() {
        }

        /* JADX WARN: Type inference failed for: r1v1, types: [java.lang.Object[], java.lang.Object] */
        @Override // p136d.p153c.p159e0.Function
        /* renamed from: a */
        public R mo3490a(T t) {
            return SingleZipIterable.this.f7571b.mo3490a(new Object[]{t});
        }
    }

    public SingleZipIterable(Iterable<? extends SingleSource<? extends T>> iterable, Function<? super Object[], ? extends R> function) {
        this.f7570a = iterable;
        this.f7571b = function;
    }

    @Override // p136d.p153c.Single
    public void subscribeActual(SingleObserver<? super R> singleObserver) {
        SingleSource[] singleSourceArr = new SingleSource[8];
        try {
            SingleSource[] singleSourceArr2 = singleSourceArr;
            int i = 0;
            for (SingleSource<? extends T> singleSource : this.f7570a) {
                if (singleSource == null) {
                    EmptyDisposable.m3637a(new NullPointerException("One of the sources is null"), singleObserver);
                    return;
                }
                if (i == singleSourceArr2.length) {
                    singleSourceArr2 = (SingleSource[]) Arrays.copyOf(singleSourceArr2, (i >> 2) + i);
                }
                int i2 = i + 1;
                singleSourceArr2[i] = singleSource;
                i = i2;
            }
            if (i == 0) {
                EmptyDisposable.m3637a(new NoSuchElementException(), singleObserver);
            } else if (i == 1) {
                singleSourceArr2[0].subscribe(new SingleMap.C1667a(singleObserver, new C1696a()));
            } else {
                SingleZipArray.C1694b c1694b = new SingleZipArray.C1694b(singleObserver, i, this.f7571b);
                singleObserver.mo3284a(c1694b);
                for (int i3 = 0; i3 < i && !c1694b.mo577c(); i3++) {
                    singleSourceArr2[i3].subscribe(c1694b.f7565c[i3]);
                }
            }
        } catch (Throwable th) {
            Exceptions.m3660b(th);
            EmptyDisposable.m3637a(th, singleObserver);
        }
    }
}
