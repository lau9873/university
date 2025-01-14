package p205h.p208b.p209a.p219f;

/* renamed from: h.b.a.f.a */
/* loaded from: classes.dex */
public class StringHelper {
    /* renamed from: a */
    public static String m691a(int i) {
        StringBuilder sb = new StringBuilder(i);
        for (int i2 = 0; i2 < i; i2++) {
            sb.append("ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789abcdefghijklmnopqrstuvxyz".charAt((int) (61 * Math.random())));
        }
        return sb.toString();
    }
}
