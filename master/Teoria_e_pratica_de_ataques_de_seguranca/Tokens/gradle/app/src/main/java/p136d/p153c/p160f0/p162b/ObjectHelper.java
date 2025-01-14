package p136d.p153c.p160f0.p162b;

import p136d.p153c.p159e0.BiPredicate;

/* renamed from: d.c.f0.b.b */
/* loaded from: classes.dex */
public final class ObjectHelper {

    /* renamed from: a */
    public static final BiPredicate<Object, Object> f6897a = new C1561a();

    /* compiled from: ObjectHelper.java */
    /* renamed from: d.c.f0.b.b$a */
    /* loaded from: classes.dex */
    public static class C1561a implements BiPredicate<Object, Object> {
        @Override // p136d.p153c.p159e0.BiPredicate
        /* renamed from: a */
        public boolean mo3597a(Object obj, Object obj2) {
            return ObjectHelper.m3599a(obj, obj2);
        }
    }

    /* renamed from: a */
    public static int m3602a(int i, int i2) {
        if (i < i2) {
            return -1;
        }
        return i > i2 ? 1 : 0;
    }

    /* renamed from: a */
    public static int m3600a(long j, long j2) {
        int i = (j > j2 ? 1 : (j == j2 ? 0 : -1));
        if (i < 0) {
            return -1;
        }
        return i > 0 ? 1 : 0;
    }

    /* renamed from: a */
    public static <T> T m3598a(T t, String str) {
        if (t != null) {
            return t;
        }
        throw new NullPointerException(str);
    }

    /* renamed from: a */
    public static boolean m3599a(Object obj, Object obj2) {
        return obj == obj2 || (obj != null && obj.equals(obj2));
    }

    /* renamed from: a */
    public static <T> BiPredicate<T, T> m3603a() {
        return (BiPredicate<T, T>) f6897a;
    }

    /* renamed from: a */
    public static int m3601a(int i, String str) {
        if (i > 0) {
            return i;
        }
        throw new IllegalArgumentException(str + " > 0 required but it was " + i);
    }
}
