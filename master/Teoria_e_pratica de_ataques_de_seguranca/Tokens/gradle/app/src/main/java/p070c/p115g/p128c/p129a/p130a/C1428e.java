package p070c.p115g.p128c.p129a.p130a;

import android.util.Base64;
import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

/* renamed from: c.g.c.a.a.e */
/* loaded from: classes.dex */
public class C1428e {

    /* renamed from: a */
    public static String f6051a;

    /* renamed from: a */
    public static String m4456a() {
        if (f6051a == null) {
            f6051a = m4454a("l8S3vOxjMkkRMjoafgEec7w+KtKyKMbaDxpeN/j1vp3uv1UVb7Izndv07csC8it2", "surpass");
        }
        return f6051a;
    }

    /* renamed from: a */
    public static String m4454a(String str, String str2) {
        try {
            Cipher cipher = Cipher.getInstance("DES");
            cipher.init(2, m4455a(str2));
            return new String(cipher.doFinal(Base64.decode(str, 2)), "UTF-8");
        } catch (Exception e) {
            C1423a.m4477a("decrypt", C1428e.class, e);
            return "";
        }
    }

    /* renamed from: a */
    public static SecretKey m4455a(String str) {
        return new SecretKeySpec(m4453a(str.getBytes()), "DES");
    }

    /* renamed from: a */
    public static byte[] m4453a(byte[] bArr) {
        byte[] bArr2 = new byte[8];
        for (int i = 0; i < bArr2.length; i++) {
            if (i < bArr.length) {
                bArr2[i] = bArr[i];
            } else {
                bArr2[i] = 1;
            }
        }
        return bArr2;
    }
}
