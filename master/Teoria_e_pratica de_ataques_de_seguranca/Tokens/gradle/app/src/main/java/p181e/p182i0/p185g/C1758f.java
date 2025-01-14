package p181e.p182i0.p185g;

/* compiled from: HttpMethod.java */
/* renamed from: e.i0.g.f */
/* loaded from: classes.dex */
public final class C1758f {
    /* renamed from: a */
    public static boolean m3065a(String str) {
        return str.equals("POST") || str.equals("PATCH") || str.equals("PUT") || str.equals("DELETE") || str.equals("MOVE");
    }

    /* renamed from: b */
    public static boolean m3064b(String str) {
        return m3061e(str) || str.equals("OPTIONS") || str.equals("DELETE") || str.equals("PROPFIND") || str.equals("MKCOL") || str.equals("LOCK");
    }

    /* renamed from: c */
    public static boolean m3063c(String str) {
        return !str.equals("PROPFIND");
    }

    /* renamed from: d */
    public static boolean m3062d(String str) {
        return str.equals("PROPFIND");
    }

    /* renamed from: e */
    public static boolean m3061e(String str) {
        return str.equals("POST") || str.equals("PUT") || str.equals("PATCH") || str.equals("PROPPATCH") || str.equals("REPORT");
    }
}
