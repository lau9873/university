package p000a.p006b.p030g.p044j;

/* renamed from: a.b.g.j.m */
/* loaded from: classes.dex */
public class Preconditions {
    /* renamed from: a */
    public static <T> T m9621a(T t) {
        if (t != null) {
            return t;
        }
        throw new NullPointerException();
    }

    /* renamed from: a */
    public static <T> T m9620a(T t, Object obj) {
        if (t != null) {
            return t;
        }
        throw new NullPointerException(String.valueOf(obj));
    }

    /* renamed from: a */
    public static int m9622a(int i) {
        if (i >= 0) {
            return i;
        }
        throw new IllegalArgumentException();
    }
}
