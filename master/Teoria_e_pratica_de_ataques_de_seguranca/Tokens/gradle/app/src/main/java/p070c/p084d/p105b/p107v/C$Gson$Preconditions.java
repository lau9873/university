package p070c.p084d.p105b.p107v;

/* renamed from: c.d.b.v.a  reason: invalid class name */
/* loaded from: classes.dex */
public final class C$Gson$Preconditions {
    /* renamed from: a */
    public static <T> T m4886a(T t) {
        if (t != null) {
            return t;
        }
        throw new NullPointerException();
    }

    /* renamed from: a */
    public static void m4885a(boolean z) {
        if (!z) {
            throw new IllegalArgumentException();
        }
    }
}
