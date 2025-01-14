package p136d.p153c.p160f0.p165e.p170e;

import java.util.NoSuchElementException;
import java.util.concurrent.Callable;
import p136d.p153c.Observable;
import p136d.p153c.SingleSource;
import p136d.p153c.p159e0.Function;
import p193g.p204b.Publisher;

/* renamed from: d.c.f0.e.e.d0 */
/* loaded from: classes.dex */
public final class SingleInternalHelper {

    /* compiled from: SingleInternalHelper.java */
    /* renamed from: d.c.f0.e.e.d0$a */
    /* loaded from: classes.dex */
    public enum EnumC1660a implements Callable<NoSuchElementException> {
        INSTANCE;

        @Override // java.util.concurrent.Callable
        public NoSuchElementException call() {
            return new NoSuchElementException();
        }
    }

    /* compiled from: SingleInternalHelper.java */
    /* renamed from: d.c.f0.e.e.d0$b */
    /* loaded from: classes.dex */
    public enum EnumC1661b implements Function<SingleSource, Publisher> {
        INSTANCE;

        @Override // p136d.p153c.p159e0.Function
        /* renamed from: a  reason: avoid collision after fix types in other method */
        public Publisher mo3490a(SingleSource singleSource) {
            return new SingleToFlowable(singleSource);
        }
    }

    /* compiled from: SingleInternalHelper.java */
    /* renamed from: d.c.f0.e.e.d0$c */
    /* loaded from: classes.dex */
    public enum EnumC1662c implements Function<SingleSource, Observable> {
        INSTANCE;

        @Override // p136d.p153c.p159e0.Function
        /* renamed from: a  reason: avoid collision after fix types in other method */
        public Observable mo3490a(SingleSource singleSource) {
            return new SingleToObservable(singleSource);
        }
    }

    /* renamed from: a */
    public static <T> Callable<NoSuchElementException> m3507a() {
        return EnumC1660a.INSTANCE;
    }

    /* renamed from: b */
    public static <T> Function<SingleSource<? extends T>, Publisher<? extends T>> m3506b() {
        return EnumC1661b.INSTANCE;
    }

    /* renamed from: c */
    public static <T> Function<SingleSource<? extends T>, Observable<? extends T>> m3505c() {
        return EnumC1662c.INSTANCE;
    }
}
