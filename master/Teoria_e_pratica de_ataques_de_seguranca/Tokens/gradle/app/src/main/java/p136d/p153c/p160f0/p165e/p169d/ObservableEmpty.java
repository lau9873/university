package p136d.p153c.p160f0.p165e.p169d;

import p136d.p153c.InterfaceC1730s;
import p136d.p153c.Observable;
import p136d.p153c.p160f0.p161a.EmptyDisposable;
import p136d.p153c.p160f0.p163c.ScalarCallable;

/* renamed from: d.c.f0.e.d.e */
/* loaded from: classes.dex */
public final class ObservableEmpty extends Observable<Object> implements ScalarCallable<Object> {

    /* renamed from: a */
    public static final Observable<Object> f7320a = new ObservableEmpty();

    @Override // p136d.p153c.Observable
    /* renamed from: b */
    public void mo574b(InterfaceC1730s<? super Object> interfaceC1730s) {
        EmptyDisposable.m3640a(interfaceC1730s);
    }

    @Override // p136d.p153c.p160f0.p163c.ScalarCallable, java.util.concurrent.Callable
    public Object call() {
        return null;
    }
}
