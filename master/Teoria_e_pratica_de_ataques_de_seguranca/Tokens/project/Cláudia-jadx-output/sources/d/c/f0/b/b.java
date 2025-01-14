package d.c.f0.b;

import d.c.e0.d;
/* compiled from: ObjectHelper.java */
/* loaded from: classes.dex */
public final class b {

    /* renamed from: a  reason: collision with root package name */
    public static final d<Object, Object> f4604a = new a();

    /* compiled from: ObjectHelper.java */
    /* loaded from: classes.dex */
    public static class a implements d<Object, Object> {
        @Override // d.c.e0.d
        public boolean a(Object obj, Object obj2) {
            return b.a(obj, obj2);
        }
    }

    public static int a(int i2, int i3) {
        if (i2 < i3) {
            return -1;
        }
        return i2 > i3 ? 1 : 0;
    }

    public static int a(long j, long j2) {
        int i2 = (j > j2 ? 1 : (j == j2 ? 0 : -1));
        if (i2 < 0) {
            return -1;
        }
        return i2 > 0 ? 1 : 0;
    }

    public static <T> T a(T t, String str) {
        if (t != null) {
            return t;
        }
        throw new NullPointerException(str);
    }

    public static boolean a(Object obj, Object obj2) {
        return obj == obj2 || (obj != null && obj.equals(obj2));
    }

    public static <T> d<T, T> a() {
        return (d<T, T>) f4604a;
    }

    public static int a(int i2, String str) {
        if (i2 > 0) {
            return i2;
        }
        throw new IllegalArgumentException(str + " > 0 required but it was " + i2);
    }
}
