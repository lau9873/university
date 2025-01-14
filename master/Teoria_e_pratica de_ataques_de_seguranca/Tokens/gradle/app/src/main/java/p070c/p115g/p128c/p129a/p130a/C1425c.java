package p070c.p115g.p128c.p129a.p130a;

import java.math.BigInteger;

/* renamed from: c.g.c.a.a.c */
/* loaded from: classes.dex */
public class C1425c {

    /* renamed from: a */
    public static final char[] f6045a = "0123456789ABCDEF".toCharArray();

    static {
        "0123456789ABCDEF".toCharArray();
    }

    /* renamed from: a */
    public static String m4469a(byte[] bArr) {
        char[] cArr = new char[bArr.length * 2];
        for (int i = 0; i < bArr.length; i++) {
            int i2 = bArr[i] & 255;
            int i3 = i * 2;
            char[] cArr2 = f6045a;
            cArr[i3] = cArr2[i2 >>> 4];
            cArr[i3 + 1] = cArr2[i2 & 15];
        }
        return new String(cArr);
    }

    /* renamed from: a */
    public static byte[] m4470a(String str) {
        int i;
        int i2;
        int length = str.length();
        byte[] bArr = new byte[(length + 1) / 2];
        int length2 = bArr.length;
        loop0: while (true) {
            i = -1;
            while (true) {
                length--;
                if (length < 0) {
                    break loop0;
                }
                char charAt = str.charAt(length);
                if (charAt >= '0' && charAt <= '9') {
                    i2 = charAt - '0';
                } else if (charAt >= 'a' && charAt <= 'f') {
                    i2 = charAt - 'W';
                } else if (charAt >= 'A' && charAt <= 'F') {
                    i2 = charAt - '7';
                } else if (charAt < 0 || charAt > ' ') {
                    break loop0;
                }
                if (i < 0) {
                    i = i2;
                }
            }
            length2--;
            bArr[length2] = (byte) (i | (i2 << 4));
        }
        if (i >= 0) {
            length2--;
            bArr[length2] = (byte) i;
        }
        if (length2 > 0) {
            byte[] bArr2 = new byte[bArr.length - length2];
            if (bArr.length > length2) {
                System.arraycopy(bArr, length2, bArr2, 0, bArr2.length);
            }
            return bArr2;
        }
        return bArr;
    }

    /* renamed from: a */
    public static byte[] m4468a(byte[] bArr, byte[] bArr2) {
        byte[] bArr3 = new byte[bArr.length + bArr2.length];
        System.arraycopy(bArr, 0, bArr3, 0, bArr.length);
        System.arraycopy(bArr2, 0, bArr3, bArr.length, bArr2.length);
        return bArr3;
    }

    /* renamed from: a */
    public static byte[] m4467a(byte[]... bArr) {
        if (bArr.length == 2) {
            return m4468a(bArr[0], bArr[1]);
        }
        byte[] m4468a = m4468a(bArr[bArr.length - 2], bArr[bArr.length - 1]);
        byte[][] bArr2 = new byte[bArr.length - 1];
        for (int i = 0; i < bArr.length - 2; i++) {
            bArr2[i] = bArr[i];
        }
        bArr2[bArr.length - 2] = m4468a;
        return m4467a(bArr2);
    }

    /* renamed from: b */
    public static String m4466b(String str) {
        return new BigInteger(str, 16).toString(10);
    }

    /* renamed from: b */
    public static byte[] m4465b(byte... bArr) {
        return bArr;
    }
}
