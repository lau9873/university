package p181e.p182i0.p185g;

import java.net.ProtocolException;
import p181e.Protocol;

/* renamed from: e.i0.g.k */
/* loaded from: classes.dex */
public final class StatusLine {

    /* renamed from: a */
    public final Protocol f8030a;

    /* renamed from: b */
    public final int f8031b;

    /* renamed from: c */
    public final String f8032c;

    public StatusLine(Protocol protocol, int i, String str) {
        this.f8030a = protocol;
        this.f8031b = i;
        this.f8032c = str;
    }

    /* renamed from: a */
    public static StatusLine m3046a(String str) {
        Protocol protocol;
        String str2;
        int i = 9;
        if (str.startsWith("HTTP/1.")) {
            if (str.length() >= 9 && str.charAt(8) == ' ') {
                int charAt = str.charAt(7) - '0';
                if (charAt == 0) {
                    protocol = Protocol.HTTP_1_0;
                } else if (charAt == 1) {
                    protocol = Protocol.HTTP_1_1;
                } else {
                    throw new ProtocolException("Unexpected status line: " + str);
                }
            } else {
                throw new ProtocolException("Unexpected status line: " + str);
            }
        } else if (str.startsWith("ICY ")) {
            protocol = Protocol.HTTP_1_0;
            i = 4;
        } else {
            throw new ProtocolException("Unexpected status line: " + str);
        }
        int i2 = i + 3;
        if (str.length() >= i2) {
            try {
                int parseInt = Integer.parseInt(str.substring(i, i2));
                if (str.length() <= i2) {
                    str2 = "";
                } else if (str.charAt(i2) == ' ') {
                    str2 = str.substring(i + 4);
                } else {
                    throw new ProtocolException("Unexpected status line: " + str);
                }
                return new StatusLine(protocol, parseInt, str2);
            } catch (NumberFormatException unused) {
                throw new ProtocolException("Unexpected status line: " + str);
            }
        }
        throw new ProtocolException("Unexpected status line: " + str);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.f8030a == Protocol.HTTP_1_0 ? "HTTP/1.0" : "HTTP/1.1");
        sb.append(' ');
        sb.append(this.f8031b);
        if (this.f8032c != null) {
            sb.append(' ');
            sb.append(this.f8032c);
        }
        return sb.toString();
    }
}
