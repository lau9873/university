package p070c.p131h.p132a.p133a;

import android.os.Build;
import android.os.Process;
import android.util.Base64;
import android.util.Log;
import com.j256.ormlite.logger.Logger;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.security.GeneralSecurityException;
import java.security.InvalidKeyException;
import java.security.Provider;
import java.security.SecureRandom;
import java.security.SecureRandomSpi;
import java.util.Arrays;
import java.util.concurrent.atomic.AtomicBoolean;
import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.Mac;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.spec.SecretKeySpec;

/* renamed from: c.h.a.a.a */
/* loaded from: classes.dex */
public class AesCbcWithIntegrity {

    /* renamed from: a */
    public static final AtomicBoolean f6055a = new AtomicBoolean(false);

    /* compiled from: AesCbcWithIntegrity.java */
    /* renamed from: c.h.a.a.a$a */
    /* loaded from: classes.dex */
    public static class C1430a {

        /* renamed from: a */
        public final byte[] f6056a;

        /* renamed from: b */
        public final byte[] f6057b;

        /* renamed from: c */
        public final byte[] f6058c;

        public C1430a(byte[] bArr, byte[] bArr2, byte[] bArr3) {
            this.f6056a = new byte[bArr.length];
            System.arraycopy(bArr, 0, this.f6056a, 0, bArr.length);
            this.f6057b = new byte[bArr2.length];
            System.arraycopy(bArr2, 0, this.f6057b, 0, bArr2.length);
            this.f6058c = new byte[bArr3.length];
            System.arraycopy(bArr3, 0, this.f6058c, 0, bArr3.length);
        }

        /* renamed from: a */
        public byte[] m4423a() {
            return this.f6056a;
        }

        /* renamed from: b */
        public byte[] m4421b() {
            return this.f6057b;
        }

        /* renamed from: c */
        public byte[] m4420c() {
            return this.f6058c;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj != null && C1430a.class == obj.getClass()) {
                C1430a c1430a = (C1430a) obj;
                return Arrays.equals(this.f6056a, c1430a.f6056a) && Arrays.equals(this.f6057b, c1430a.f6057b) && Arrays.equals(this.f6058c, c1430a.f6058c);
            }
            return false;
        }

        public int hashCode() {
            return ((((Arrays.hashCode(this.f6056a) + 31) * 31) + Arrays.hashCode(this.f6057b)) * 31) + Arrays.hashCode(this.f6058c);
        }

        public String toString() {
            String encodeToString = Base64.encodeToString(this.f6057b, 2);
            String encodeToString2 = Base64.encodeToString(this.f6056a, 2);
            String encodeToString3 = Base64.encodeToString(this.f6058c, 2);
            return String.format(encodeToString + ":" + encodeToString3 + ":" + encodeToString2, new Object[0]);
        }

        /* renamed from: a */
        public static byte[] m4422a(byte[] bArr, byte[] bArr2) {
            byte[] bArr3 = new byte[bArr.length + bArr2.length];
            System.arraycopy(bArr, 0, bArr3, 0, bArr.length);
            System.arraycopy(bArr2, 0, bArr3, bArr.length, bArr2.length);
            return bArr3;
        }

        public C1430a(String str) {
            String[] split = str.split(":");
            if (split.length == 3) {
                this.f6057b = Base64.decode(split[0], 2);
                this.f6058c = Base64.decode(split[1], 2);
                this.f6056a = Base64.decode(split[2], 2);
                return;
            }
            throw new IllegalArgumentException("Cannot parse iv:ciphertext:mac");
        }
    }

    /* compiled from: AesCbcWithIntegrity.java */
    /* renamed from: c.h.a.a.a$b */
    /* loaded from: classes.dex */
    public static final class C1431b {

        /* renamed from: a */
        public static final byte[] f6059a = m4415e();

        /* compiled from: AesCbcWithIntegrity.java */
        /* renamed from: c.h.a.a.a$b$a */
        /* loaded from: classes.dex */
        public static class C1432a extends SecureRandomSpi {

            /* renamed from: b */
            public static final File f6060b = new File("/dev/urandom");

            /* renamed from: c */
            public static final Object f6061c = new Object();

            /* renamed from: d */
            public static DataInputStream f6062d;

            /* renamed from: e */
            public static OutputStream f6063e;

            /* renamed from: a */
            public boolean f6064a;

            /* renamed from: a */
            public final DataInputStream m4412a() {
                DataInputStream dataInputStream;
                synchronized (f6061c) {
                    if (f6062d == null) {
                        try {
                            f6062d = new DataInputStream(new FileInputStream(f6060b));
                        } catch (IOException e) {
                            throw new SecurityException("Failed to open " + f6060b + " for reading", e);
                        }
                    }
                    dataInputStream = f6062d;
                }
                return dataInputStream;
            }

            /* renamed from: b */
            public final OutputStream m4411b() {
                OutputStream outputStream;
                synchronized (f6061c) {
                    if (f6063e == null) {
                        f6063e = new FileOutputStream(f6060b);
                    }
                    outputStream = f6063e;
                }
                return outputStream;
            }

            @Override // java.security.SecureRandomSpi
            public byte[] engineGenerateSeed(int i) {
                byte[] bArr = new byte[i];
                engineNextBytes(bArr);
                return bArr;
            }

            @Override // java.security.SecureRandomSpi
            public void engineNextBytes(byte[] bArr) {
                DataInputStream m4412a;
                if (!this.f6064a) {
                    engineSetSeed(C1431b.m4416d());
                }
                try {
                    synchronized (f6061c) {
                        m4412a = m4412a();
                    }
                    synchronized (m4412a) {
                        m4412a.readFully(bArr);
                    }
                } catch (IOException e) {
                    throw new SecurityException("Failed to read from " + f6060b, e);
                }
            }

            @Override // java.security.SecureRandomSpi
            public void engineSetSeed(byte[] bArr) {
                OutputStream m4411b;
                try {
                    try {
                        synchronized (f6061c) {
                            m4411b = m4411b();
                        }
                        m4411b.write(bArr);
                        m4411b.flush();
                    } catch (IOException unused) {
                        String simpleName = C1431b.class.getSimpleName();
                        Log.w(simpleName, "Failed to mix seed into " + f6060b);
                    }
                } finally {
                    this.f6064a = true;
                }
            }
        }

        /* compiled from: AesCbcWithIntegrity.java */
        /* renamed from: c.h.a.a.a$b$b */
        /* loaded from: classes.dex */
        public static class C1433b extends Provider {
            public C1433b() {
                super("LinuxPRNG", 1.0d, "A Linux-specific random number provider that uses /dev/urandom");
                put("SecureRandom.SHA1PRNG", C1432a.class.getName());
                put("SecureRandom.SHA1PRNG ImplementedIn", "Software");
            }
        }

        /* renamed from: b */
        public static void m4418b() {
            m4417c();
            m4413g();
        }

        /* renamed from: c */
        public static void m4417c() {
            int i = Build.VERSION.SDK_INT;
            if (i < 16 || i > 18) {
                return;
            }
            try {
                Class.forName("org.apache.harmony.xnet.provider.jsse.NativeCrypto").getMethod("RAND_seed", byte[].class).invoke(null, m4416d());
                int intValue = ((Integer) Class.forName("org.apache.harmony.xnet.provider.jsse.NativeCrypto").getMethod("RAND_load_file", String.class, Long.TYPE).invoke(null, "/dev/urandom", 1024)).intValue();
                if (intValue == 1024) {
                    return;
                }
                throw new IOException("Unexpected number of bytes read from Linux PRNG: " + intValue);
            } catch (Exception e) {
                throw new SecurityException("Failed to seed OpenSSL PRNG", e);
            }
        }

        /* renamed from: d */
        public static byte[] m4416d() {
            try {
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                DataOutputStream dataOutputStream = new DataOutputStream(byteArrayOutputStream);
                dataOutputStream.writeLong(System.currentTimeMillis());
                dataOutputStream.writeLong(System.nanoTime());
                dataOutputStream.writeInt(Process.myPid());
                dataOutputStream.writeInt(Process.myUid());
                dataOutputStream.write(f6059a);
                dataOutputStream.close();
                return byteArrayOutputStream.toByteArray();
            } catch (IOException e) {
                throw new SecurityException("Failed to generate seed", e);
            }
        }

        /* renamed from: e */
        public static byte[] m4415e() {
            StringBuilder sb = new StringBuilder();
            String str = Build.FINGERPRINT;
            if (str != null) {
                sb.append(str);
            }
            String m4414f = m4414f();
            if (m4414f != null) {
                sb.append(m4414f);
            }
            try {
                return sb.toString().getBytes("UTF-8");
            } catch (UnsupportedEncodingException unused) {
                throw new RuntimeException("UTF-8 encoding not supported");
            }
        }

        /* renamed from: f */
        public static String m4414f() {
            try {
                return (String) Build.class.getField("SERIAL").get(null);
            } catch (Exception unused) {
                return null;
            }
        }

        /* JADX WARN: Code restructure failed: missing block: B:12:0x002b, code lost:
            if (r0[0].getClass().getSimpleName().equals(p070c.p131h.p132a.p133a.AesCbcWithIntegrity.C1431b.C1433b.class.getSimpleName()) != false) goto L10;
         */
        /* renamed from: g */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public static void m4413g() {
            /*
                int r0 = android.os.Build.VERSION.SDK_INT
                r1 = 18
                if (r0 <= r1) goto L7
                return
            L7:
                java.lang.String r0 = "SecureRandom.SHA1PRNG"
                java.security.Provider[] r0 = java.security.Security.getProviders(r0)
                java.lang.Class<java.security.Security> r1 = java.security.Security.class
                monitor-enter(r1)
                r2 = 1
                if (r0 == 0) goto L2d
                int r3 = r0.length     // Catch: java.lang.Throwable -> Lba
                if (r3 < r2) goto L2d
                r3 = 0
                r0 = r0[r3]     // Catch: java.lang.Throwable -> Lba
                java.lang.Class r0 = r0.getClass()     // Catch: java.lang.Throwable -> Lba
                java.lang.String r0 = r0.getSimpleName()     // Catch: java.lang.Throwable -> Lba
                java.lang.Class<c.h.a.a.a$b$b> r3 = p070c.p131h.p132a.p133a.AesCbcWithIntegrity.C1431b.C1433b.class
                java.lang.String r3 = r3.getSimpleName()     // Catch: java.lang.Throwable -> Lba
                boolean r0 = r0.equals(r3)     // Catch: java.lang.Throwable -> Lba
                if (r0 != 0) goto L35
            L2d:
                c.h.a.a.a$b$b r0 = new c.h.a.a.a$b$b     // Catch: java.lang.Throwable -> Lba
                r0.<init>()     // Catch: java.lang.Throwable -> Lba
                java.security.Security.insertProviderAt(r0, r2)     // Catch: java.lang.Throwable -> Lba
            L35:
                java.security.SecureRandom r0 = new java.security.SecureRandom     // Catch: java.lang.Throwable -> Lba
                r0.<init>()     // Catch: java.lang.Throwable -> Lba
                java.security.Provider r2 = r0.getProvider()     // Catch: java.lang.Throwable -> Lba
                java.lang.Class r2 = r2.getClass()     // Catch: java.lang.Throwable -> Lba
                java.lang.String r2 = r2.getSimpleName()     // Catch: java.lang.Throwable -> Lba
                java.lang.Class<c.h.a.a.a$b$b> r3 = p070c.p131h.p132a.p133a.AesCbcWithIntegrity.C1431b.C1433b.class
                java.lang.String r3 = r3.getSimpleName()     // Catch: java.lang.Throwable -> Lba
                boolean r2 = r2.equals(r3)     // Catch: java.lang.Throwable -> Lba
                if (r2 == 0) goto L9b
                r0 = 0
                java.lang.String r2 = "SHA1PRNG"
                java.security.SecureRandom r0 = java.security.SecureRandom.getInstance(r2)     // Catch: java.security.NoSuchAlgorithmException -> L5a java.lang.Throwable -> Lba
                goto L62
            L5a:
                r2 = move-exception
                java.lang.SecurityException r3 = new java.lang.SecurityException     // Catch: java.lang.Throwable -> Lba
                java.lang.String r4 = "SHA1PRNG not available"
                r3.<init>(r4, r2)     // Catch: java.lang.Throwable -> Lba
            L62:
                java.security.Provider r2 = r0.getProvider()     // Catch: java.lang.Throwable -> Lba
                java.lang.Class r2 = r2.getClass()     // Catch: java.lang.Throwable -> Lba
                java.lang.String r2 = r2.getSimpleName()     // Catch: java.lang.Throwable -> Lba
                java.lang.Class<c.h.a.a.a$b$b> r3 = p070c.p131h.p132a.p133a.AesCbcWithIntegrity.C1431b.C1433b.class
                java.lang.String r3 = r3.getSimpleName()     // Catch: java.lang.Throwable -> Lba
                boolean r2 = r2.equals(r3)     // Catch: java.lang.Throwable -> Lba
                if (r2 == 0) goto L7c
                monitor-exit(r1)     // Catch: java.lang.Throwable -> Lba
                return
            L7c:
                java.lang.SecurityException r2 = new java.lang.SecurityException     // Catch: java.lang.Throwable -> Lba
                java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> Lba
                r3.<init>()     // Catch: java.lang.Throwable -> Lba
                java.lang.String r4 = "SecureRandom.getInstance(\"SHA1PRNG\") backed by wrong Provider: "
                r3.append(r4)     // Catch: java.lang.Throwable -> Lba
                java.security.Provider r0 = r0.getProvider()     // Catch: java.lang.Throwable -> Lba
                java.lang.Class r0 = r0.getClass()     // Catch: java.lang.Throwable -> Lba
                r3.append(r0)     // Catch: java.lang.Throwable -> Lba
                java.lang.String r0 = r3.toString()     // Catch: java.lang.Throwable -> Lba
                r2.<init>(r0)     // Catch: java.lang.Throwable -> Lba
                throw r2     // Catch: java.lang.Throwable -> Lba
            L9b:
                java.lang.SecurityException r2 = new java.lang.SecurityException     // Catch: java.lang.Throwable -> Lba
                java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> Lba
                r3.<init>()     // Catch: java.lang.Throwable -> Lba
                java.lang.String r4 = "new SecureRandom() backed by wrong Provider: "
                r3.append(r4)     // Catch: java.lang.Throwable -> Lba
                java.security.Provider r0 = r0.getProvider()     // Catch: java.lang.Throwable -> Lba
                java.lang.Class r0 = r0.getClass()     // Catch: java.lang.Throwable -> Lba
                r3.append(r0)     // Catch: java.lang.Throwable -> Lba
                java.lang.String r0 = r3.toString()     // Catch: java.lang.Throwable -> Lba
                r2.<init>(r0)     // Catch: java.lang.Throwable -> Lba
                throw r2     // Catch: java.lang.Throwable -> Lba
            Lba:
                r0 = move-exception
                monitor-exit(r1)     // Catch: java.lang.Throwable -> Lba
                throw r0
            */
            throw new UnsupportedOperationException("Method not decompiled: p070c.p131h.p132a.p133a.AesCbcWithIntegrity.C1431b.m4413g():void");
        }
    }

    /* compiled from: AesCbcWithIntegrity.java */
    /* renamed from: c.h.a.a.a$c */
    /* loaded from: classes.dex */
    public static class C1434c {

        /* renamed from: a */
        public SecretKey f6065a;

        /* renamed from: b */
        public SecretKey f6066b;

        public C1434c(SecretKey secretKey, SecretKey secretKey2) {
            m4409a(secretKey);
            m4407b(secretKey2);
        }

        /* renamed from: a */
        public SecretKey m4410a() {
            return this.f6065a;
        }

        /* renamed from: b */
        public SecretKey m4408b() {
            return this.f6066b;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj != null && C1434c.class == obj.getClass()) {
                C1434c c1434c = (C1434c) obj;
                return this.f6066b.equals(c1434c.f6066b) && this.f6065a.equals(c1434c.f6065a);
            }
            return false;
        }

        public int hashCode() {
            return ((this.f6065a.hashCode() + 31) * 31) + this.f6066b.hashCode();
        }

        public String toString() {
            return Base64.encodeToString(m4410a().getEncoded(), 2) + ":" + Base64.encodeToString(m4408b().getEncoded(), 2);
        }

        /* renamed from: a */
        public void m4409a(SecretKey secretKey) {
            this.f6065a = secretKey;
        }

        /* renamed from: b */
        public void m4407b(SecretKey secretKey) {
            this.f6066b = secretKey;
        }
    }

    /* renamed from: a */
    public static C1434c m4434a(String str) {
        String[] split = str.split(":");
        if (split.length == 2) {
            byte[] decode = Base64.decode(split[0], 2);
            if (decode.length == 16) {
                byte[] decode2 = Base64.decode(split[1], 2);
                if (decode2.length == 32) {
                    return new C1434c(new SecretKeySpec(decode, 0, decode.length, "AES"), new SecretKeySpec(decode2, "HmacSHA256"));
                }
                throw new InvalidKeyException("Base64 decoded key is not 256 bytes");
            }
            throw new InvalidKeyException("Base64 decoded key is not 128 bytes");
        }
        throw new IllegalArgumentException("Cannot parse aesKey:hmacKey");
    }

    /* renamed from: b */
    public static byte[] m4426b() {
        return m4437a(16);
    }

    /* renamed from: c */
    public static C1434c m4424c() {
        m4438a();
        KeyGenerator keyGenerator = KeyGenerator.getInstance("AES");
        keyGenerator.init(Logger.DEFAULT_FULL_MESSAGE_LENGTH);
        return new C1434c(keyGenerator.generateKey(), new SecretKeySpec(m4437a(32), "HmacSHA256"));
    }

    /* renamed from: b */
    public static String m4425b(C1430a c1430a, C1434c c1434c) {
        return m4435a(c1430a, c1434c, "UTF-8");
    }

    /* renamed from: a */
    public static C1434c m4431a(String str, byte[] bArr, int i) {
        m4438a();
        byte[] encoded = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA1").generateSecret(new PBEKeySpec(str.toCharArray(), bArr, i, 384)).getEncoded();
        return new C1434c(new SecretKeySpec(m4430a(encoded, 0, 16), "AES"), new SecretKeySpec(m4430a(encoded, 16, 48), "HmacSHA256"));
    }

    /* renamed from: a */
    public static byte[] m4437a(int i) {
        m4438a();
        byte[] bArr = new byte[i];
        new SecureRandom().nextBytes(bArr);
        return bArr;
    }

    /* renamed from: a */
    public static C1430a m4433a(String str, C1434c c1434c) {
        return m4432a(str, c1434c, "UTF-8");
    }

    /* renamed from: a */
    public static C1430a m4432a(String str, C1434c c1434c, String str2) {
        return m4429a(str.getBytes(str2), c1434c);
    }

    /* renamed from: a */
    public static C1430a m4429a(byte[] bArr, C1434c c1434c) {
        byte[] m4426b = m4426b();
        Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
        cipher.init(1, c1434c.m4410a(), new IvParameterSpec(m4426b));
        byte[] iv = cipher.getIV();
        byte[] doFinal = cipher.doFinal(bArr);
        return new C1430a(doFinal, iv, m4428a(C1430a.m4422a(iv, doFinal), c1434c.m4408b()));
    }

    /* renamed from: a */
    public static void m4438a() {
        if (f6055a.get()) {
            return;
        }
        synchronized (C1431b.class) {
            if (!f6055a.get()) {
                C1431b.m4418b();
                f6055a.set(true);
            }
        }
    }

    /* renamed from: a */
    public static String m4435a(C1430a c1430a, C1434c c1434c, String str) {
        return new String(m4436a(c1430a, c1434c), str);
    }

    /* renamed from: a */
    public static byte[] m4436a(C1430a c1430a, C1434c c1434c) {
        if (m4427a(m4428a(C1430a.m4422a(c1430a.m4421b(), c1430a.m4423a()), c1434c.m4408b()), c1430a.m4420c())) {
            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
            cipher.init(2, c1434c.m4410a(), new IvParameterSpec(c1430a.m4421b()));
            return cipher.doFinal(c1430a.m4423a());
        }
        throw new GeneralSecurityException("MAC stored in civ does not match computed MAC.");
    }

    /* renamed from: a */
    public static byte[] m4428a(byte[] bArr, SecretKey secretKey) {
        Mac mac = Mac.getInstance("HmacSHA256");
        mac.init(secretKey);
        return mac.doFinal(bArr);
    }

    /* renamed from: a */
    public static boolean m4427a(byte[] bArr, byte[] bArr2) {
        if (bArr.length != bArr2.length) {
            return false;
        }
        int i = 0;
        for (int i2 = 0; i2 < bArr.length; i2++) {
            i |= bArr[i2] ^ bArr2[i2];
        }
        return i == 0;
    }

    /* renamed from: a */
    public static byte[] m4430a(byte[] bArr, int i, int i2) {
        int i3 = i2 - i;
        byte[] bArr2 = new byte[i3];
        System.arraycopy(bArr, i, bArr2, 0, i3);
        return bArr2;
    }
}
