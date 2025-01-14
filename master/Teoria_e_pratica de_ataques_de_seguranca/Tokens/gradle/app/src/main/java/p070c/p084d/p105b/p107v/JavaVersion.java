package p070c.p084d.p105b.p107v;

/* renamed from: c.d.b.v.e */
/* loaded from: classes.dex */
public final class JavaVersion {

    /* renamed from: a */
    public static final int f5724a = m4848a();

    /* renamed from: a */
    public static int m4848a() {
        return m4845b(System.getProperty("java.version"));
    }

    /* renamed from: b */
    public static int m4845b(String str) {
        int m4843c = m4843c(str);
        if (m4843c == -1) {
            m4843c = m4847a(str);
        }
        if (m4843c == -1) {
            return 6;
        }
        return m4843c;
    }

    /* renamed from: c */
    public static int m4843c(String str) {
        try {
            String[] split = str.split("[._]");
            int parseInt = Integer.parseInt(split[0]);
            return (parseInt != 1 || split.length <= 1) ? parseInt : Integer.parseInt(split[1]);
        } catch (NumberFormatException unused) {
            return -1;
        }
    }

    /* renamed from: a */
    public static int m4847a(String str) {
        try {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < str.length(); i++) {
                char charAt = str.charAt(i);
                if (!Character.isDigit(charAt)) {
                    break;
                }
                sb.append(charAt);
            }
            return Integer.parseInt(sb.toString());
        } catch (NumberFormatException unused) {
            return -1;
        }
    }

    /* renamed from: b */
    public static int m4846b() {
        return f5724a;
    }

    /* renamed from: c */
    public static boolean m4844c() {
        return f5724a >= 9;
    }
}
