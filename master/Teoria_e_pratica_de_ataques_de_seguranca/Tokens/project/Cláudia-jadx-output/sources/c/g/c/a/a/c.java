package c.g.c.a.a;

import java.math.BigInteger;
/* loaded from: classes.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    public static final char[] f4016a = "0123456789ABCDEF".toCharArray();

    static {
        "0123456789ABCDEF".toCharArray();
    }

    public static String a(byte[] bArr) {
        char[] cArr = new char[bArr.length * 2];
        for (int i2 = 0; i2 < bArr.length; i2++) {
            int i3 = bArr[i2] & 255;
            int i4 = i2 * 2;
            char[] cArr2 = f4016a;
            cArr[i4] = cArr2[i3 >>> 4];
            cArr[i4 + 1] = cArr2[i3 & 15];
        }
        return new String(cArr);
    }

    public static byte[] a(String str) {
        int i2;
        int i3;
        int length = str.length();
        byte[] bArr = new byte[(length + 1) / 2];
        int length2 = bArr.length;
        loop0: while (true) {
            i2 = -1;
            while (true) {
                length--;
                if (length < 0) {
                    break loop0;
                }
                char charAt = str.charAt(length);
                if (charAt >= '0' && charAt <= '9') {
                    i3 = charAt - '0';
                } else if (charAt >= 'a' && charAt <= 'f') {
                    i3 = charAt - 'W';
                } else if (charAt >= 'A' && charAt <= 'F') {
                    i3 = charAt - '7';
                } else if (charAt < 0 || charAt > ' ') {
                    break loop0;
                }
                if (i2 < 0) {
                    i2 = i3;
                }
            }
            length2--;
            bArr[length2] = (byte) (i2 | (i3 << 4));
        }
        if (i2 >= 0) {
            length2--;
            bArr[length2] = (byte) i2;
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

    public static byte[] a(byte[] bArr, byte[] bArr2) {
        byte[] bArr3 = new byte[bArr.length + bArr2.length];
        System.arraycopy(bArr, 0, bArr3, 0, bArr.length);
        System.arraycopy(bArr2, 0, bArr3, bArr.length, bArr2.length);
        return bArr3;
    }

    public static byte[] a(byte[]... bArr) {
        if (bArr.length == 2) {
            return a(bArr[0], bArr[1]);
        }
        byte[] a2 = a(bArr[bArr.length - 2], bArr[bArr.length - 1]);
        byte[][] bArr2 = new byte[bArr.length - 1];
        for (int i2 = 0; i2 < bArr.length - 2; i2++) {
            bArr2[i2] = bArr[i2];
        }
        bArr2[bArr.length - 2] = a2;
        return a(bArr2);
    }

    public static String b(String str) {
        return new BigInteger(str, 16).toString(10);
    }

    public static byte[] b(byte... bArr) {
        return bArr;
    }
}
