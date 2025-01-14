package d.c.f0.i;

import d.c.f0.c.k;
/* compiled from: EmptySubscription.java */
/* loaded from: classes.dex */
public enum d implements k<Object> {
    INSTANCE;

    @Override // d.c.f0.c.j
    public int a(int i2) {
        return i2 & 2;
    }

    @Override // g.b.d
    public void a(long j) {
        g.c(j);
    }

    @Override // g.b.d
    public void cancel() {
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

    @Override // java.lang.Enum
    public String toString() {
        return "EmptySubscription";
    }

    public static void a(Throwable th, g.b.c<?> cVar) {
        cVar.a((g.b.d) INSTANCE);
        cVar.a(th);
    }

    public static void a(g.b.c<?> cVar) {
        cVar.a((g.b.d) INSTANCE);
        cVar.a();
    }
}
