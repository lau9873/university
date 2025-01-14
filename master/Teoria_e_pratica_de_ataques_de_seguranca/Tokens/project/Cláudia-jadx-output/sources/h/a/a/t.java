package h.a.a;
/* compiled from: Preconditions.java */
/* loaded from: classes.dex */
public class t {
    public static <T> T a(T t, Object obj) {
        if (t != null) {
            return t;
        }
        throw new NullPointerException(String.valueOf(obj));
    }

    public static <T> T a(T t) {
        t.getClass();
        return t;
    }

    public static void a(boolean z, Object obj) {
        if (!z) {
            throw new IllegalArgumentException(String.valueOf(obj));
        }
    }
}
