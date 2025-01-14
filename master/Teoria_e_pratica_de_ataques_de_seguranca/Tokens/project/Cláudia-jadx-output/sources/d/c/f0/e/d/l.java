package d.c.f0.e.d;

import d.c.f0.e.d.m;
import d.c.s;
/* compiled from: ObservableJust.java */
/* loaded from: classes.dex */
public final class l<T> extends d.c.o<T> implements d.c.f0.c.l<T> {

    /* renamed from: a  reason: collision with root package name */
    public final T f5031a;

    public l(T t) {
        this.f5031a = t;
    }

    @Override // d.c.o
    public void b(s<? super T> sVar) {
        m.a aVar = new m.a(sVar, this.f5031a);
        sVar.a((d.c.c0.b) aVar);
        aVar.run();
    }

    @Override // d.c.f0.c.l, java.util.concurrent.Callable
    public T call() {
        return this.f5031a;
    }
}
