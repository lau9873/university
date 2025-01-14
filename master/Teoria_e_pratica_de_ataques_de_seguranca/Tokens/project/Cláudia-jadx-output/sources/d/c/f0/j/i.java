package d.c.f0.j;
/* compiled from: OpenHashSet.java */
/* loaded from: classes.dex */
public final class i<T> {

    /* renamed from: a  reason: collision with root package name */
    public final float f5381a;

    /* renamed from: b  reason: collision with root package name */
    public int f5382b;

    /* renamed from: c  reason: collision with root package name */
    public int f5383c;

    /* renamed from: d  reason: collision with root package name */
    public int f5384d;

    /* renamed from: e  reason: collision with root package name */
    public T[] f5385e;

    public i() {
        this(16, 0.75f);
    }

    public static int a(int i2) {
        int i3 = i2 * (-1640531527);
        return i3 ^ (i3 >>> 16);
    }

    public boolean a(T t) {
        T t2;
        T[] tArr = this.f5385e;
        int i2 = this.f5382b;
        int a2 = a(t.hashCode()) & i2;
        T t3 = tArr[a2];
        if (t3 != null) {
            if (t3.equals(t)) {
                return false;
            }
            do {
                a2 = (a2 + 1) & i2;
                t2 = tArr[a2];
                if (t2 == null) {
                }
            } while (!t2.equals(t));
            return false;
        }
        tArr[a2] = t;
        int i3 = this.f5383c + 1;
        this.f5383c = i3;
        if (i3 >= this.f5384d) {
            b();
        }
        return true;
    }

    public boolean b(T t) {
        T t2;
        T[] tArr = this.f5385e;
        int i2 = this.f5382b;
        int a2 = a(t.hashCode()) & i2;
        T t3 = tArr[a2];
        if (t3 == null) {
            return false;
        }
        if (t3.equals(t)) {
            return a(a2, tArr, i2);
        }
        do {
            a2 = (a2 + 1) & i2;
            t2 = tArr[a2];
            if (t2 == null) {
                return false;
            }
        } while (!t2.equals(t));
        return a(a2, tArr, i2);
    }

    public i(int i2, float f2) {
        this.f5381a = f2;
        int a2 = j.a(i2);
        this.f5382b = a2 - 1;
        this.f5384d = (int) (f2 * a2);
        this.f5385e = (T[]) new Object[a2];
    }

    public void b() {
        T[] tArr = this.f5385e;
        int length = tArr.length;
        int i2 = length << 1;
        int i3 = i2 - 1;
        T[] tArr2 = (T[]) new Object[i2];
        int i4 = this.f5383c;
        while (true) {
            int i5 = i4 - 1;
            if (i4 != 0) {
                do {
                    length--;
                } while (tArr[length] == null);
                int a2 = a(tArr[length].hashCode()) & i3;
                if (tArr2[a2] != null) {
                    do {
                        a2 = (a2 + 1) & i3;
                    } while (tArr2[a2] != null);
                }
                tArr2[a2] = tArr[length];
                i4 = i5;
            } else {
                this.f5382b = i3;
                this.f5384d = (int) (i2 * this.f5381a);
                this.f5385e = tArr2;
                return;
            }
        }
    }

    public boolean a(int i2, T[] tArr, int i3) {
        int i4;
        T t;
        this.f5383c--;
        while (true) {
            int i5 = i2 + 1;
            while (true) {
                i4 = i5 & i3;
                t = tArr[i4];
                if (t == null) {
                    tArr[i2] = null;
                    return true;
                }
                int a2 = a(t.hashCode()) & i3;
                if (i2 > i4) {
                    if (i2 >= a2 && a2 > i4) {
                        break;
                    }
                    i5 = i4 + 1;
                } else if (i2 < a2 && a2 <= i4) {
                    i5 = i4 + 1;
                }
            }
            tArr[i2] = t;
            i2 = i4;
        }
    }

    public Object[] a() {
        return this.f5385e;
    }
}
