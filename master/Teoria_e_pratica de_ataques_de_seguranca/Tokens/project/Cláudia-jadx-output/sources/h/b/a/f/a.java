package h.b.a.f;
/* compiled from: StringHelper.java */
/* loaded from: classes.dex */
public class a {
    public static String a(int i2) {
        StringBuilder sb = new StringBuilder(i2);
        for (int i3 = 0; i3 < i2; i3++) {
            sb.append("ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789abcdefghijklmnopqrstuvxyz".charAt((int) (61 * Math.random())));
        }
        return sb.toString();
    }
}
