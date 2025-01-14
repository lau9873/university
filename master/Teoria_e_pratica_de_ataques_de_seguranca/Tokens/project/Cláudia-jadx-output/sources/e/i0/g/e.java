package e.i0.g;

import e.d0;
import e.l;
import e.m;
import e.t;
import e.u;
import java.util.List;
import java.util.regex.Pattern;
/* compiled from: HttpHeaders.java */
/* loaded from: classes.dex */
public final class e {
    static {
        Pattern.compile(" +([^ \"=]*)=(:?\"([^\"]*)\"|([^ \"=]*)) *(:?,|$)");
    }

    public static long a(d0 d0Var) {
        return a(d0Var.n());
    }

    public static boolean b(d0 d0Var) {
        if (d0Var.s().e().equals("HEAD")) {
            return false;
        }
        int l = d0Var.l();
        return (((l >= 100 && l < 200) || l == 204 || l == 304) && a(d0Var) == -1 && !"chunked".equalsIgnoreCase(d0Var.b("Transfer-Encoding"))) ? false : true;
    }

    public static long a(t tVar) {
        return a(tVar.a("Content-Length"));
    }

    public static long a(String str) {
        if (str == null) {
            return -1L;
        }
        try {
            return Long.parseLong(str);
        } catch (NumberFormatException unused) {
            return -1L;
        }
    }

    public static void a(m mVar, u uVar, t tVar) {
        if (mVar == m.f5899a) {
            return;
        }
        List<l> a2 = l.a(uVar, tVar);
        if (a2.isEmpty()) {
            return;
        }
        mVar.a(uVar, a2);
    }

    public static int b(String str, int i2) {
        char charAt;
        while (i2 < str.length() && ((charAt = str.charAt(i2)) == ' ' || charAt == '\t')) {
            i2++;
        }
        return i2;
    }

    public static int a(String str, int i2, String str2) {
        while (i2 < str.length() && str2.indexOf(str.charAt(i2)) == -1) {
            i2++;
        }
        return i2;
    }

    public static int a(String str, int i2) {
        try {
            long parseLong = Long.parseLong(str);
            if (parseLong > 2147483647L) {
                return Integer.MAX_VALUE;
            }
            if (parseLong < 0) {
                return 0;
            }
            return (int) parseLong;
        } catch (NumberFormatException unused) {
            return i2;
        }
    }
}
