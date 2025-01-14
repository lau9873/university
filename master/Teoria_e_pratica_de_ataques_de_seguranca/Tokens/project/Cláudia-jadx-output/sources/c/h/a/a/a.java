package c.h.a.a;

import android.os.Build;
import android.os.Process;
import android.util.Base64;
import android.util.Log;
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
/* compiled from: AesCbcWithIntegrity.java */
/* loaded from: classes.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public static final AtomicBoolean f4026a = new AtomicBoolean(false);

    /* compiled from: AesCbcWithIntegrity.java */
    /* renamed from: c.h.a.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0081a {

        /* renamed from: a  reason: collision with root package name */
        public final byte[] f4027a;

        /* renamed from: b  reason: collision with root package name */
        public final byte[] f4028b;

        /* renamed from: c  reason: collision with root package name */
        public final byte[] f4029c;

        public C0081a(byte[] bArr, byte[] bArr2, byte[] bArr3) {
            this.f4027a = new byte[bArr.length];
            System.arraycopy(bArr, 0, this.f4027a, 0, bArr.length);
            this.f4028b = new byte[bArr2.length];
            System.arraycopy(bArr2, 0, this.f4028b, 0, bArr2.length);
            this.f4029c = new byte[bArr3.length];
            System.arraycopy(bArr3, 0, this.f4029c, 0, bArr3.length);
        }

        public byte[] a() {
            return this.f4027a;
        }

        public byte[] b() {
            return this.f4028b;
        }

        public byte[] c() {
            return this.f4029c;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj != null && C0081a.class == obj.getClass()) {
                C0081a c0081a = (C0081a) obj;
                return Arrays.equals(this.f4027a, c0081a.f4027a) && Arrays.equals(this.f4028b, c0081a.f4028b) && Arrays.equals(this.f4029c, c0081a.f4029c);
            }
            return false;
        }

        public int hashCode() {
            return ((((Arrays.hashCode(this.f4027a) + 31) * 31) + Arrays.hashCode(this.f4028b)) * 31) + Arrays.hashCode(this.f4029c);
        }

        public String toString() {
            String encodeToString = Base64.encodeToString(this.f4028b, 2);
            String encodeToString2 = Base64.encodeToString(this.f4027a, 2);
            String encodeToString3 = Base64.encodeToString(this.f4029c, 2);
            return String.format(encodeToString + ":" + encodeToString3 + ":" + encodeToString2, new Object[0]);
        }

        public static byte[] a(byte[] bArr, byte[] bArr2) {
            byte[] bArr3 = new byte[bArr.length + bArr2.length];
            System.arraycopy(bArr, 0, bArr3, 0, bArr.length);
            System.arraycopy(bArr2, 0, bArr3, bArr.length, bArr2.length);
            return bArr3;
        }

        public C0081a(String str) {
            String[] split = str.split(":");
            if (split.length == 3) {
                this.f4028b = Base64.decode(split[0], 2);
                this.f4029c = Base64.decode(split[1], 2);
                this.f4027a = Base64.decode(split[2], 2);
                return;
            }
            throw new IllegalArgumentException("Cannot parse iv:ciphertext:mac");
        }
    }

    /* compiled from: AesCbcWithIntegrity.java */
    /* loaded from: classes.dex */
    public static final class b {

        /* renamed from: a  reason: collision with root package name */
        public static final byte[] f4030a = e();

        /* compiled from: AesCbcWithIntegrity.java */
        /* renamed from: c.h.a.a.a$b$a  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        public static class C0082a extends SecureRandomSpi {

            /* renamed from: b  reason: collision with root package name */
            public static final File f4031b = new File("/dev/urandom");

            /* renamed from: c  reason: collision with root package name */
            public static final Object f4032c = new Object();

            /* renamed from: d  reason: collision with root package name */
            public static DataInputStream f4033d;

            /* renamed from: e  reason: collision with root package name */
            public static OutputStream f4034e;

            /* renamed from: a  reason: collision with root package name */
            public boolean f4035a;

            public final DataInputStream a() {
                DataInputStream dataInputStream;
                synchronized (f4032c) {
                    if (f4033d == null) {
                        try {
                            f4033d = new DataInputStream(new FileInputStream(f4031b));
                        } catch (IOException e2) {
                            throw new SecurityException("Failed to open " + f4031b + " for reading", e2);
                        }
                    }
                    dataInputStream = f4033d;
                }
                return dataInputStream;
            }

            public final OutputStream b() {
                OutputStream outputStream;
                synchronized (f4032c) {
                    if (f4034e == null) {
                        f4034e = new FileOutputStream(f4031b);
                    }
                    outputStream = f4034e;
                }
                return outputStream;
            }

            @Override // java.security.SecureRandomSpi
            public byte[] engineGenerateSeed(int i2) {
                byte[] bArr = new byte[i2];
                engineNextBytes(bArr);
                return bArr;
            }

            @Override // java.security.SecureRandomSpi
            public void engineNextBytes(byte[] bArr) {
                DataInputStream a2;
                if (!this.f4035a) {
                    engineSetSeed(b.d());
                }
                try {
                    synchronized (f4032c) {
                        a2 = a();
                    }
                    synchronized (a2) {
                        a2.readFully(bArr);
                    }
                } catch (IOException e2) {
                    throw new SecurityException("Failed to read from " + f4031b, e2);
                }
            }

            @Override // java.security.SecureRandomSpi
            public void engineSetSeed(byte[] bArr) {
                OutputStream b2;
                try {
                    try {
                        synchronized (f4032c) {
                            b2 = b();
                        }
                        b2.write(bArr);
                        b2.flush();
                    } catch (IOException unused) {
                        String simpleName = b.class.getSimpleName();
                        Log.w(simpleName, "Failed to mix seed into " + f4031b);
                    }
                } finally {
                    this.f4035a = true;
                }
            }
        }

        /* compiled from: AesCbcWithIntegrity.java */
        /* renamed from: c.h.a.a.a$b$b  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        public static class C0083b extends Provider {
            public C0083b() {
                super("LinuxPRNG", 1.0d, "A Linux-specific random number provider that uses /dev/urandom");
                put("SecureRandom.SHA1PRNG", C0082a.class.getName());
                put("SecureRandom.SHA1PRNG ImplementedIn", "Software");
            }
        }

        public static void b() {
            c();
            g();
        }

        public static void c() {
            int i2 = Build.VERSION.SDK_INT;
            if (i2 < 16 || i2 > 18) {
                return;
            }
            try {
                Class.forName("org.apache.harmony.xnet.provider.jsse.NativeCrypto").getMethod("RAND_seed", byte[].class).invoke(null, d());
                int intValue = ((Integer) Class.forName("org.apache.harmony.xnet.provider.jsse.NativeCrypto").getMethod("RAND_load_file", String.class, Long.TYPE).invoke(null, "/dev/urandom", 1024)).intValue();
                if (intValue == 1024) {
                    return;
                }
                throw new IOException("Unexpected number of bytes read from Linux PRNG: " + intValue);
            } catch (Exception e2) {
                throw new SecurityException("Failed to seed OpenSSL PRNG", e2);
            }
        }

        public static byte[] d() {
            try {
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                DataOutputStream dataOutputStream = new DataOutputStream(byteArrayOutputStream);
                dataOutputStream.writeLong(System.currentTimeMillis());
                dataOutputStream.writeLong(System.nanoTime());
                dataOutputStream.writeInt(Process.myPid());
                dataOutputStream.writeInt(Process.myUid());
                dataOutputStream.write(f4030a);
                dataOutputStream.close();
                return byteArrayOutputStream.toByteArray();
            } catch (IOException e2) {
                throw new SecurityException("Failed to generate seed", e2);
            }
        }

        public static byte[] e() {
            StringBuilder sb = new StringBuilder();
            String str = Build.FINGERPRINT;
            if (str != null) {
                sb.append(str);
            }
            String f2 = f();
            if (f2 != null) {
                sb.append(f2);
            }
            try {
                return sb.toString().getBytes("UTF-8");
            } catch (UnsupportedEncodingException unused) {
                throw new RuntimeException("UTF-8 encoding not supported");
            }
        }

        public static String f() {
            try {
                return (String) Build.class.getField("SERIAL").get(null);
            } catch (Exception unused) {
                return null;
            }
        }

        /* JADX WARN: Code restructure failed: missing block: B:12:0x002b, code lost:
            if (r0[0].getClass().getSimpleName().equals(c.h.a.a.a.b.C0083b.class.getSimpleName()) != false) goto L10;
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public static void g() {
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
                java.lang.Class<c.h.a.a.a$b$b> r3 = c.h.a.a.a.b.C0083b.class
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
                java.lang.Class<c.h.a.a.a$b$b> r3 = c.h.a.a.a.b.C0083b.class
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
                java.lang.Class<c.h.a.a.a$b$b> r3 = c.h.a.a.a.b.C0083b.class
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
            throw new UnsupportedOperationException("Method not decompiled: c.h.a.a.a.b.g():void");
        }
    }

    /* compiled from: AesCbcWithIntegrity.java */
    /* loaded from: classes.dex */
    public static class c {

        /* renamed from: a  reason: collision with root package name */
        public SecretKey f4036a;

        /* renamed from: b  reason: collision with root package name */
        public SecretKey f4037b;

        public c(SecretKey secretKey, SecretKey secretKey2) {
            a(secretKey);
            b(secretKey2);
        }

        public SecretKey a() {
            return this.f4036a;
        }

        public SecretKey b() {
            return this.f4037b;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj != null && c.class == obj.getClass()) {
                c cVar = (c) obj;
                return this.f4037b.equals(cVar.f4037b) && this.f4036a.equals(cVar.f4036a);
            }
            return false;
        }

        public int hashCode() {
            return ((this.f4036a.hashCode() + 31) * 31) + this.f4037b.hashCode();
        }

        public String toString() {
            return Base64.encodeToString(a().getEncoded(), 2) + ":" + Base64.encodeToString(b().getEncoded(), 2);
        }

        public void a(SecretKey secretKey) {
            this.f4036a = secretKey;
        }

        public void b(SecretKey secretKey) {
            this.f4037b = secretKey;
        }
    }

    public static c a(String str) {
        String[] split = str.split(":");
        if (split.length == 2) {
            byte[] decode = Base64.decode(split[0], 2);
            if (decode.length == 16) {
                byte[] decode2 = Base64.decode(split[1], 2);
                if (decode2.length == 32) {
                    return new c(new SecretKeySpec(decode, 0, decode.length, "AES"), new SecretKeySpec(decode2, "HmacSHA256"));
                }
                throw new InvalidKeyException("Base64 decoded key is not 256 bytes");
            }
            throw new InvalidKeyException("Base64 decoded key is not 128 bytes");
        }
        throw new IllegalArgumentException("Cannot parse aesKey:hmacKey");
    }

    public static byte[] b() {
        return a(16);
    }

    public static c c() {
        a();
        KeyGenerator keyGenerator = KeyGenerator.getInstance("AES");
        keyGenerator.init(128);
        return new c(keyGenerator.generateKey(), new SecretKeySpec(a(32), "HmacSHA256"));
    }

    public static String b(C0081a c0081a, c cVar) {
        return a(c0081a, cVar, "UTF-8");
    }

    public static c a(String str, byte[] bArr, int i2) {
        a();
        byte[] encoded = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA1").generateSecret(new PBEKeySpec(str.toCharArray(), bArr, i2, 384)).getEncoded();
        return new c(new SecretKeySpec(a(encoded, 0, 16), "AES"), new SecretKeySpec(a(encoded, 16, 48), "HmacSHA256"));
    }

    public static byte[] a(int i2) {
        a();
        byte[] bArr = new byte[i2];
        new SecureRandom().nextBytes(bArr);
        return bArr;
    }

    public static C0081a a(String str, c cVar) {
        return a(str, cVar, "UTF-8");
    }

    public static C0081a a(String str, c cVar, String str2) {
        return a(str.getBytes(str2), cVar);
    }

    public static C0081a a(byte[] bArr, c cVar) {
        byte[] b2 = b();
        Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
        cipher.init(1, cVar.a(), new IvParameterSpec(b2));
        byte[] iv = cipher.getIV();
        byte[] doFinal = cipher.doFinal(bArr);
        return new C0081a(doFinal, iv, a(C0081a.a(iv, doFinal), cVar.b()));
    }

    public static void a() {
        if (f4026a.get()) {
            return;
        }
        synchronized (b.class) {
            if (!f4026a.get()) {
                b.b();
                f4026a.set(true);
            }
        }
    }

    public static String a(C0081a c0081a, c cVar, String str) {
        return new String(a(c0081a, cVar), str);
    }

    public static byte[] a(C0081a c0081a, c cVar) {
        if (a(a(C0081a.a(c0081a.b(), c0081a.a()), cVar.b()), c0081a.c())) {
            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
            cipher.init(2, cVar.a(), new IvParameterSpec(c0081a.b()));
            return cipher.doFinal(c0081a.a());
        }
        throw new GeneralSecurityException("MAC stored in civ does not match computed MAC.");
    }

    public static byte[] a(byte[] bArr, SecretKey secretKey) {
        Mac mac = Mac.getInstance("HmacSHA256");
        mac.init(secretKey);
        return mac.doFinal(bArr);
    }

    public static boolean a(byte[] bArr, byte[] bArr2) {
        if (bArr.length != bArr2.length) {
            return false;
        }
        int i2 = 0;
        for (int i3 = 0; i3 < bArr.length; i3++) {
            i2 |= bArr[i3] ^ bArr2[i3];
        }
        return i2 == 0;
    }

    public static byte[] a(byte[] bArr, int i2, int i3) {
        int i4 = i3 - i2;
        byte[] bArr2 = new byte[i4];
        System.arraycopy(bArr, i2, bArr2, 0, i4);
        return bArr2;
    }
}
