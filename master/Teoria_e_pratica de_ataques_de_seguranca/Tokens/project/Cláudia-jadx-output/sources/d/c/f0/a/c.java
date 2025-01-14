package d.c.f0.a;

import d.c.f0.c.i;
import d.c.s;
import d.c.w;
/* compiled from: EmptyDisposable.java */
/* loaded from: classes.dex */
public enum c implements i<Object> {
    INSTANCE,
    NEVER;

    public static void a(s<?> sVar) {
        sVar.a((d.c.c0.b) INSTANCE);
        sVar.a();
    }

    @Override // d.c.f0.c.j
    public int a(int i2) {
        return i2 & 2;
    }

    @Override // d.c.c0.b
    public void b() {
    }

    @Override // d.c.c0.b
    public boolean c() {
        return this == INSTANCE;
    }

    @Override // d.c.f0.c.n
    public void clear() {
    }

    @Override // d.c.f0.c.n
    public boolean isEmpty() {
        return true;
    }

    @Override // d.c.f0.c.n
    public boolean offer(Object obj) {
        throw new UnsupportedOperationException("Should not be called!");
    }

    @Override // d.c.f0.c.n
    public Object poll() {
        return null;
    }

    public static void a(Throwable th, s<?> sVar) {
        sVar.a((d.c.c0.b) INSTANCE);
        sVar.a(th);
    }

    public static void a(d.c.d dVar) {
        dVar.a(INSTANCE);
        dVar.a();
    }

    public static void a(Throwable th, d.c.d dVar) {
        dVar.a(INSTANCE);
        dVar.a(th);
    }

    public static void a(Throwable th, w<?> wVar) {
        wVar.a(INSTANCE);
        wVar.a(th);
    }
}
