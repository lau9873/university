package e.i0.g;

import e.z;
import java.net.ProtocolException;
/* compiled from: StatusLine.java */
/* loaded from: classes.dex */
public final class k {

    /* renamed from: a  reason: collision with root package name */
    public final z f5641a;

    /* renamed from: b  reason: collision with root package name */
    public final int f5642b;

    /* renamed from: c  reason: collision with root package name */
    public final String f5643c;

    public k(z zVar, int i2, String str) {
        this.f5641a = zVar;
        this.f5642b = i2;
        this.f5643c = str;
    }

    public static k a(String str) {
        z zVar;
        String str2;
        int i2 = 9;
        if (str.startsWith("HTTP/1.")) {
            if (str.length() >= 9 && str.charAt(8) == ' ') {
                int charAt = str.charAt(7) - '0';
                if (charAt == 0) {
                    zVar = z.HTTP_1_0;
                } else if (charAt == 1) {
                    zVar = z.HTTP_1_1;
                } else {
                    throw new ProtocolException("Unexpected status line: " + str);
                }
            } else {
                throw new ProtocolException("Unexpected status line: " + str);
            }
        } else if (str.startsWith("ICY ")) {
            zVar = z.HTTP_1_0;
            i2 = 4;
        } else {
            throw new ProtocolException("Unexpected status line: " + str);
        }
        int i3 = i2 + 3;
        if (str.length() >= i3) {
            try {
                int parseInt = Integer.parseInt(str.substring(i2, i3));
                if (str.length() <= i3) {
                    str2 = "";
                } else if (str.charAt(i3) == ' ') {
                    str2 = str.substring(i2 + 4);
                } else {
                    throw new ProtocolException("Unexpected status line: " + str);
                }
                return new k(zVar, parseInt, str2);
            } catch (NumberFormatException unused) {
                throw new ProtocolException("Unexpected status line: " + str);
            }
        }
        throw new ProtocolException("Unexpected status line: " + str);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.f5641a == z.HTTP_1_0 ? "HTTP/1.0" : "HTTP/1.1");
        sb.append(' ');
        sb.append(this.f5642b);
        if (this.f5643c != null) {
            sb.append(' ');
            sb.append(this.f5643c);
        }
        return sb.toString();
    }
}
