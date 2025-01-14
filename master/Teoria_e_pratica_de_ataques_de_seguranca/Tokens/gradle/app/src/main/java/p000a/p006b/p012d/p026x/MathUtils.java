package p000a.p006b.p012d.p026x;

/* renamed from: a.b.d.x.l */
/* loaded from: classes.dex */
public final class MathUtils {
    /* renamed from: a */
    public static float m10694a(float f, float f2, float f3) {
        return ((1.0f - f3) * f) + (f3 * f2);
    }

    /* renamed from: a */
    public static float m10693a(float f, float f2, float f3, float f4) {
        return (float) Math.hypot(f3 - f, f4 - f2);
    }

    /* renamed from: b */
    public static float m10691b(float f, float f2, float f3, float f4) {
        return (f <= f2 || f <= f3 || f <= f4) ? (f2 <= f3 || f2 <= f4) ? f3 > f4 ? f3 : f4 : f2 : f;
    }

    /* renamed from: a */
    public static float m10692a(float f, float f2, float f3, float f4, float f5, float f6) {
        return m10691b(m10693a(f, f2, f3, f4), m10693a(f, f2, f5, f4), m10693a(f, f2, f5, f6), m10693a(f, f2, f3, f6));
    }
}
