package e.i0.g;

import e.b0;
import e.u;
import java.net.Proxy;
/* compiled from: RequestLine.java */
/* loaded from: classes.dex */
public final class i {
    public static String a(b0 b0Var, Proxy.Type type) {
        StringBuilder sb = new StringBuilder();
        sb.append(b0Var.e());
        sb.append(' ');
        if (b(b0Var, type)) {
            sb.append(b0Var.g());
        } else {
            sb.append(a(b0Var.g()));
        }
        sb.append(" HTTP/1.1");
        return sb.toString();
    }

    public static boolean b(b0 b0Var, Proxy.Type type) {
        return !b0Var.d() && type == Proxy.Type.HTTP;
    }

    public static String a(u uVar) {
        String c2 = uVar.c();
        String e2 = uVar.e();
        if (e2 != null) {
            return c2 + '?' + e2;
        }
        return c2;
    }
}
