package c.g.c.a.a;

import android.util.Base64;
import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
/* loaded from: classes.dex */
public class e {

    /* renamed from: a  reason: collision with root package name */
    public static String f4022a;

    public static String a() {
        if (f4022a == null) {
            f4022a = a("l8S3vOxjMkkRMjoafgEec7w+KtKyKMbaDxpeN/j1vp3uv1UVb7Izndv07csC8it2", "surpass");
        }
        return f4022a;
    }

    public static String a(String str, String str2) {
        try {
            Cipher cipher = Cipher.getInstance("DES");
            cipher.init(2, a(str2));
            return new String(cipher.doFinal(Base64.decode(str, 2)), "UTF-8");
        } catch (Exception e2) {
            a.a("decrypt", e.class, e2);
            return "";
        }
    }

    public static SecretKey a(String str) {
        return new SecretKeySpec(a(str.getBytes()), "DES");
    }

    public static byte[] a(byte[] bArr) {
        byte[] bArr2 = new byte[8];
        for (int i2 = 0; i2 < bArr2.length; i2++) {
            if (i2 < bArr.length) {
                bArr2[i2] = bArr[i2];
            } else {
                bArr2[i2] = 1;
            }
        }
        return bArr2;
    }
}
