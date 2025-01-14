package p193g.p194a.p203b;

import android.annotation.TargetApi;

/* renamed from: g.a.b.d */
/* loaded from: classes.dex */
public class Pdu {

    /* renamed from: a */
    public byte f8743a;

    /* renamed from: b */
    public int f8744b;

    /* renamed from: c */
    public int f8745c;

    /* renamed from: d */
    public int f8746d;

    @TargetApi(9)
    /* renamed from: a */
    public static Pdu m2194a(byte[] bArr, int i) {
        int i2;
        if (bArr.length - i >= 2 && (i2 = bArr[i]) > 0) {
            byte b = bArr[i + 1];
            int i3 = i + 2;
            if (i3 < bArr.length) {
                Pdu pdu = new Pdu();
                pdu.f8746d = i + i2;
                if (pdu.f8746d >= bArr.length) {
                    pdu.f8746d = bArr.length - 1;
                }
                pdu.f8743a = b;
                pdu.f8744b = i2;
                pdu.f8745c = i3;
                return pdu;
            }
        }
        return null;
    }

    /* renamed from: b */
    public int m2193b() {
        return this.f8746d;
    }

    /* renamed from: c */
    public int m2192c() {
        return this.f8745c;
    }

    /* renamed from: d */
    public byte m2191d() {
        return this.f8743a;
    }

    /* renamed from: a */
    public int m2195a() {
        return this.f8744b;
    }
}
