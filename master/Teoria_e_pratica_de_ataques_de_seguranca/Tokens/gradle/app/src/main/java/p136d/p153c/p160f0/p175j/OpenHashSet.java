package p136d.p153c.p160f0.p175j;

/* renamed from: d.c.f0.j.i */
/* loaded from: classes.dex */
public final class OpenHashSet<T> {

    /* renamed from: a */
    public final float f7717a;

    /* renamed from: b */
    public int f7718b;

    /* renamed from: c */
    public int f7719c;

    /* renamed from: d */
    public int f7720d;

    /* renamed from: e */
    public T[] f7721e;

    public OpenHashSet() {
        this(16, 0.75f);
    }

    /* renamed from: a */
    public static int m3400a(int i) {
        int i2 = i * (-1640531527);
        return i2 ^ (i2 >>> 16);
    }

    /* renamed from: a */
    public boolean m3398a(T t) {
        T t2;
        T[] tArr = this.f7721e;
        int i = this.f7718b;
        int m3400a = m3400a(t.hashCode()) & i;
        T t3 = tArr[m3400a];
        if (t3 != null) {
            if (t3.equals(t)) {
                return false;
            }
            do {
                m3400a = (m3400a + 1) & i;
                t2 = tArr[m3400a];
                if (t2 == null) {
                }
            } while (!t2.equals(t));
            return false;
        }
        tArr[m3400a] = t;
        int i2 = this.f7719c + 1;
        this.f7719c = i2;
        if (i2 >= this.f7720d) {
            m3397b();
        }
        return true;
    }

    /* renamed from: b */
    public boolean m3396b(T t) {
        T t2;
        T[] tArr = this.f7721e;
        int i = this.f7718b;
        int m3400a = m3400a(t.hashCode()) & i;
        T t3 = tArr[m3400a];
        if (t3 == null) {
            return false;
        }
        if (t3.equals(t)) {
            return m3399a(m3400a, tArr, i);
        }
        do {
            m3400a = (m3400a + 1) & i;
            t2 = tArr[m3400a];
            if (t2 == null) {
                return false;
            }
        } while (!t2.equals(t));
        return m3399a(m3400a, tArr, i);
    }

    public OpenHashSet(int i, float f) {
        this.f7717a = f;
        int m3395a = Pow2.m3395a(i);
        this.f7718b = m3395a - 1;
        this.f7720d = (int) (f * m3395a);
        this.f7721e = (T[]) new Object[m3395a];
    }

    /* renamed from: b */
    public void m3397b() {
        T[] tArr = this.f7721e;
        int length = tArr.length;
        int i = length << 1;
        int i2 = i - 1;
        T[] tArr2 = (T[]) new Object[i];
        int i3 = this.f7719c;
        while (true) {
            int i4 = i3 - 1;
            if (i3 != 0) {
                do {
                    length--;
                } while (tArr[length] == null);
                int m3400a = m3400a(tArr[length].hashCode()) & i2;
                if (tArr2[m3400a] != null) {
                    do {
                        m3400a = (m3400a + 1) & i2;
                    } while (tArr2[m3400a] != null);
                }
                tArr2[m3400a] = tArr[length];
                i3 = i4;
            } else {
                this.f7718b = i2;
                this.f7720d = (int) (i * this.f7717a);
                this.f7721e = tArr2;
                return;
            }
        }
    }

    /* renamed from: a */
    public boolean m3399a(int i, T[] tArr, int i2) {
        int i3;
        T t;
        this.f7719c--;
        while (true) {
            int i4 = i + 1;
            while (true) {
                i3 = i4 & i2;
                t = tArr[i3];
                if (t == null) {
                    tArr[i] = null;
                    return true;
                }
                int m3400a = m3400a(t.hashCode()) & i2;
                if (i > i3) {
                    if (i >= m3400a && m3400a > i3) {
                        break;
                    }
                    i4 = i3 + 1;
                } else if (i < m3400a && m3400a <= i3) {
                    i4 = i3 + 1;
                }
            }
            tArr[i] = t;
            i = i3;
        }
    }

    /* renamed from: a */
    public Object[] m3401a() {
        return this.f7721e;
    }
}
