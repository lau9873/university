package p136d.p153c.p160f0.p165e.p169d;

import p136d.p153c.Observable;
import p136d.p153c.ObservableSource;
import p136d.p153c.p160f0.p163c.HasUpstreamObservableSource;

/* renamed from: d.c.f0.e.d.a */
/* loaded from: classes.dex */
public abstract class AbstractObservableWithUpstream<T, U> extends Observable<U> implements HasUpstreamObservableSource<T> {

    /* renamed from: a */
    public final ObservableSource<T> f7279a;

    public AbstractObservableWithUpstream(ObservableSource<T> observableSource) {
        this.f7279a = observableSource;
    }
}
