package p136d.p153c.p160f0.p165e.p169d;

import p136d.p153c.InterfaceC1730s;
import p136d.p153c.Observable;
import p136d.p153c.ObservableSource;

/* renamed from: d.c.f0.e.d.h */
/* loaded from: classes.dex */
public final class ObservableFromUnsafeSource<T> extends Observable<T> {

    /* renamed from: a */
    public final ObservableSource<T> f7354a;

    public ObservableFromUnsafeSource(ObservableSource<T> observableSource) {
        this.f7354a = observableSource;
    }

    @Override // p136d.p153c.Observable
    /* renamed from: b */
    public void mo574b(InterfaceC1730s<? super T> interfaceC1730s) {
        this.f7354a.mo3294a(interfaceC1730s);
    }
}
