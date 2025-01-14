package p205h.p206a.p207a;

/* compiled from: Preconditions.java */
/* renamed from: h.a.a.t */
/* loaded from: classes.dex */
public class C2222t {
    /* renamed from: a */
    public static <T> T m1568a(T t, Object obj) {
        if (t != null) {
            return t;
        }
        throw new NullPointerException(String.valueOf(obj));
    }

    /* renamed from: a */
    public static <T> T m1569a(T t) {
        t.getClass();
        return t;
    }

    /* renamed from: a */
    public static void m1567a(boolean z, Object obj) {
        if (!z) {
            throw new IllegalArgumentException(String.valueOf(obj));
        }
    }
}
