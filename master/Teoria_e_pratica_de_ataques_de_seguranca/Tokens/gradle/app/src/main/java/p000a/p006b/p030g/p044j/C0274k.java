package p000a.p006b.p030g.p044j;

/* compiled from: Pools.java */
/* renamed from: a.b.g.j.k */
/* loaded from: classes.dex */
public class C0274k<T> implements InterfaceC0273j<T> {

    /* renamed from: a */
    public final Object[] f1594a;

    /* renamed from: b */
    public int f1595b;

    public C0274k(int i) {
        if (i > 0) {
            this.f1594a = new Object[i];
            return;
        }
        throw new IllegalArgumentException("The max pool size must be > 0");
    }

    @Override // p000a.p006b.p030g.p044j.InterfaceC0273j
    /* renamed from: a */
    public T mo9624a() {
        int i = this.f1595b;
        if (i > 0) {
            int i2 = i - 1;
            Object[] objArr = this.f1594a;
            T t = (T) objArr[i2];
            objArr[i2] = null;
            this.f1595b = i - 1;
            return t;
        }
        return null;
    }

    /* renamed from: b */
    public final boolean m9625b(T t) {
        for (int i = 0; i < this.f1595b; i++) {
            if (this.f1594a[i] == t) {
                return true;
            }
        }
        return false;
    }

    @Override // p000a.p006b.p030g.p044j.InterfaceC0273j
    /* renamed from: a */
    public boolean mo9623a(T t) {
        if (!m9625b(t)) {
            int i = this.f1595b;
            Object[] objArr = this.f1594a;
            if (i < objArr.length) {
                objArr[i] = t;
                this.f1595b = i + 1;
                return true;
            }
            return false;
        }
        throw new IllegalStateException("Already in the pool!");
    }
}
