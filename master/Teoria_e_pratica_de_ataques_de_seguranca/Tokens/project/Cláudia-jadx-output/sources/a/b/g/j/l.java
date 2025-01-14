package a.b.g.j;
/* compiled from: Pools.java */
/* loaded from: classes.dex */
public class l<T> extends k<T> {

    /* renamed from: c  reason: collision with root package name */
    public final Object f1085c;

    public l(int i2) {
        super(i2);
        this.f1085c = new Object();
    }

    @Override // a.b.g.j.k, a.b.g.j.j
    public T a() {
        T t;
        synchronized (this.f1085c) {
            t = (T) super.a();
        }
        return t;
    }

    @Override // a.b.g.j.k, a.b.g.j.j
    public boolean a(T t) {
        boolean a2;
        synchronized (this.f1085c) {
            a2 = super.a(t);
        }
        return a2;
    }
}
