package p136d.p153c.p160f0.p165e.p170e;

import p136d.p153c.Maybe;
import p136d.p153c.MaybeSource;
import p136d.p153c.SingleSource;
import p136d.p153c.p159e0.Function;

/* renamed from: d.c.f0.e.e.y */
/* loaded from: classes.dex */
public final class SingleFlatMapMaybe<T, R> extends Maybe<R> {
    public SingleFlatMapMaybe(SingleSource<? extends T> singleSource, Function<? super T, ? extends MaybeSource<? extends R>> function) {
    }
}
