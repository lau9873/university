package p181e.p182i0.p187i;

import java.io.IOException;
import p181e.p182i0.Util;
import p192f.C1822f;

/* renamed from: e.i0.i.d */
/* loaded from: classes.dex */
public final class Http2 {

    /* renamed from: a */
    public static final C1822f f8092a = C1822f.m2596c("PRI * HTTP/2.0\r\n\r\nSM\r\n\r\n");

    /* renamed from: b */
    public static final String[] f8093b = {"DATA", "HEADERS", "PRIORITY", "RST_STREAM", "SETTINGS", "PUSH_PROMISE", "PING", "GOAWAY", "WINDOW_UPDATE", "CONTINUATION"};

    /* renamed from: c */
    public static final String[] f8094c = new String[64];

    /* renamed from: d */
    public static final String[] f8095d = new String[256];

    static {
        int[] iArr;
        int i = 0;
        int i2 = 0;
        while (true) {
            String[] strArr = f8095d;
            if (i2 >= strArr.length) {
                break;
            }
            strArr[i2] = Util.m3161a("%8s", Integer.toBinaryString(i2)).replace(' ', '0');
            i2++;
        }
        String[] strArr2 = f8094c;
        strArr2[0] = "";
        strArr2[1] = "END_STREAM";
        int[] iArr2 = {1};
        strArr2[8] = "PADDED";
        for (int i3 : iArr2) {
            f8094c[i3 | 8] = f8094c[i3] + "|PADDED";
        }
        String[] strArr3 = f8094c;
        strArr3[4] = "END_HEADERS";
        strArr3[32] = "PRIORITY";
        strArr3[36] = "END_HEADERS|PRIORITY";
        for (int i4 : new int[]{4, 32, 36}) {
            for (int i5 : iArr2) {
                int i6 = i5 | i4;
                f8094c[i6] = f8094c[i5] + '|' + f8094c[i4];
                f8094c[i6 | 8] = f8094c[i5] + '|' + f8094c[i4] + "|PADDED";
            }
        }
        while (true) {
            String[] strArr4 = f8094c;
            if (i >= strArr4.length) {
                return;
            }
            if (strArr4[i] == null) {
                strArr4[i] = f8095d[i];
            }
            i++;
        }
    }

    /* renamed from: a */
    public static IllegalArgumentException m3005a(String str, Object... objArr) {
        throw new IllegalArgumentException(Util.m3161a(str, objArr));
    }

    /* renamed from: b */
    public static IOException m3003b(String str, Object... objArr) {
        throw new IOException(Util.m3161a(str, objArr));
    }

    /* renamed from: a */
    public static String m3004a(boolean z, int i, int i2, byte b, byte b2) {
        String[] strArr = f8093b;
        String m3161a = b < strArr.length ? strArr[b] : Util.m3161a("0x%02x", Byte.valueOf(b));
        String m3006a = m3006a(b, b2);
        Object[] objArr = new Object[5];
        objArr[0] = z ? "<<" : ">>";
        objArr[1] = Integer.valueOf(i);
        objArr[2] = Integer.valueOf(i2);
        objArr[3] = m3161a;
        objArr[4] = m3006a;
        return Util.m3161a("%s 0x%08x %5d %-13s %s", objArr);
    }

    /* renamed from: a */
    public static String m3006a(byte b, byte b2) {
        if (b2 == 0) {
            return "";
        }
        if (b != 2 && b != 3) {
            if (b == 4 || b == 6) {
                return b2 == 1 ? "ACK" : f8095d[b2];
            } else if (b != 7 && b != 8) {
                String[] strArr = f8094c;
                String str = b2 < strArr.length ? strArr[b2] : f8095d[b2];
                if (b != 5 || (b2 & 4) == 0) {
                    return (b != 0 || (b2 & 32) == 0) ? str : str.replace("PRIORITY", "COMPRESSED");
                }
                return str.replace("HEADERS", "PUSH_PROMISE");
            }
        }
        return f8095d[b2];
    }
}
