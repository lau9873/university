package p000a.p006b.p008b.p009h;

/* compiled from: Pools.java */
/* renamed from: a.b.b.h.h */
/* loaded from: classes.dex */
public class C0025h<T> implements Pools<T> {

    /* renamed from: a */
    public final Object[] f216a;

    /* renamed from: b */
    public int f217b;

    public C0025h(int i) {
        if (i > 0) {
            this.f216a = new Object[i];
            return;
        }
        throw new IllegalArgumentException("The max pool size must be > 0");
    }

    @Override // p000a.p006b.p008b.p009h.Pools
    /* renamed from: a */
    public T mo11167a() {
        int i = this.f217b;
        if (i > 0) {
            int i2 = i - 1;
            Object[] objArr = this.f216a;
            T t = (T) objArr[i2];
            objArr[i2] = null;
            this.f217b = i - 1;
            return t;
        }
        return null;
    }

    @Override // p000a.p006b.p008b.p009h.Pools
    /* renamed from: a */
    public boolean mo11166a(T t) {
        int i = this.f217b;
        Object[] objArr = this.f216a;
        if (i < objArr.length) {
            objArr[i] = t;
            this.f217b = i + 1;
            return true;
        }
        return false;
    }

    @Override // p000a.p006b.p008b.p009h.Pools
    /* renamed from: a */
    public void mo11165a(T[] tArr, int i) {
        if (i > tArr.length) {
            i = tArr.length;
        }
        for (int i2 = 0; i2 < i; i2++) {
            T t = tArr[i2];
            int i3 = this.f217b;
            Object[] objArr = this.f216a;
            if (i3 < objArr.length) {
                objArr[i3] = t;
                this.f217b = i3 + 1;
            }
        }
    }
}
