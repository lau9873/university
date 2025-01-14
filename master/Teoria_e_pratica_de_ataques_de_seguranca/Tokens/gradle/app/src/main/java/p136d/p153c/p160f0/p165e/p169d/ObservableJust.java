package p136d.p153c.p160f0.p165e.p169d;

import p136d.p153c.InterfaceC1730s;
import p136d.p153c.Observable;
import p136d.p153c.p157c0.Disposable;
import p136d.p153c.p160f0.p163c.ScalarCallable;
import p136d.p153c.p160f0.p165e.p169d.ObservableScalarXMap;

/* renamed from: d.c.f0.e.d.l */
/* loaded from: classes.dex */
public final class ObservableJust<T> extends Observable<T> implements ScalarCallable<T> {

    /* renamed from: a */
    public final T f7366a;

    public ObservableJust(T t) {
        this.f7366a = t;
    }

    @Override // p136d.p153c.Observable
    /* renamed from: b */
    public void mo574b(InterfaceC1730s<? super T> interfaceC1730s) {
        ObservableScalarXMap.RunnableC1648a runnableC1648a = new ObservableScalarXMap.RunnableC1648a(interfaceC1730s, this.f7366a);
        interfaceC1730s.mo572a((Disposable) runnableC1648a);
        runnableC1648a.run();
    }

    @Override // p136d.p153c.p160f0.p163c.ScalarCallable, java.util.concurrent.Callable
    public T call() {
        return this.f7366a;
    }
}
