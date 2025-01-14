package a.b.b.h;
/* compiled from: Pools.java */
/* loaded from: classes.dex */
public class h<T> implements g<T> {

    /* renamed from: a  reason: collision with root package name */
    public final Object[] f111a;

    /* renamed from: b  reason: collision with root package name */
    public int f112b;

    public h(int i2) {
        if (i2 > 0) {
            this.f111a = new Object[i2];
            return;
        }
        throw new IllegalArgumentException("The max pool size must be > 0");
    }

    @Override // a.b.b.h.g
    public T a() {
        int i2 = this.f112b;
        if (i2 > 0) {
            int i3 = i2 - 1;
            Object[] objArr = this.f111a;
            T t = (T) objArr[i3];
            objArr[i3] = null;
            this.f112b = i2 - 1;
            return t;
        }
        return null;
    }

    @Override // a.b.b.h.g
    public boolean a(T t) {
        int i2 = this.f112b;
        Object[] objArr = this.f111a;
        if (i2 < objArr.length) {
            objArr[i2] = t;
            this.f112b = i2 + 1;
            return true;
        }
        return false;
    }

    @Override // a.b.b.h.g
    public void a(T[] tArr, int i2) {
        if (i2 > tArr.length) {
            i2 = tArr.length;
        }
        for (int i3 = 0; i3 < i2; i3++) {
            T t = tArr[i3];
            int i4 = this.f112b;
            Object[] objArr = this.f111a;
            if (i4 < objArr.length) {
                objArr[i4] = t;
                this.f112b = i4 + 1;
            }
        }
    }
}
