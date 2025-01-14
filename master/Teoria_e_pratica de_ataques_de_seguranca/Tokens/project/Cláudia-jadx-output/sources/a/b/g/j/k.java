package a.b.g.j;
/* compiled from: Pools.java */
/* loaded from: classes.dex */
public class k<T> implements j<T> {

    /* renamed from: a  reason: collision with root package name */
    public final Object[] f1083a;

    /* renamed from: b  reason: collision with root package name */
    public int f1084b;

    public k(int i2) {
        if (i2 > 0) {
            this.f1083a = new Object[i2];
            return;
        }
        throw new IllegalArgumentException("The max pool size must be > 0");
    }

    @Override // a.b.g.j.j
    public T a() {
        int i2 = this.f1084b;
        if (i2 > 0) {
            int i3 = i2 - 1;
            Object[] objArr = this.f1083a;
            T t = (T) objArr[i3];
            objArr[i3] = null;
            this.f1084b = i2 - 1;
            return t;
        }
        return null;
    }

    public final boolean b(T t) {
        for (int i2 = 0; i2 < this.f1084b; i2++) {
            if (this.f1083a[i2] == t) {
                return true;
            }
        }
        return false;
    }

    @Override // a.b.g.j.j
    public boolean a(T t) {
        if (!b(t)) {
            int i2 = this.f1084b;
            Object[] objArr = this.f1083a;
            if (i2 < objArr.length) {
                objArr[i2] = t;
                this.f1084b = i2 + 1;
                return true;
            }
            return false;
        }
        throw new IllegalStateException("Already in the pool!");
    }
}
