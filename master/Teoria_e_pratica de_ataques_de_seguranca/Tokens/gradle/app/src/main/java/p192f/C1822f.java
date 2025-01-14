package p192f;

import java.io.Serializable;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;

/* compiled from: ByteString.java */
/* renamed from: f.f */
/* loaded from: classes.dex */
public class C1822f implements Serializable, Comparable<C1822f> {

    /* renamed from: d */
    public static final char[] f8453d = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};

    /* renamed from: e */
    public static final C1822f f8454e = m2599a(new byte[0]);

    /* renamed from: a */
    public final byte[] f8455a;

    /* renamed from: b */
    public transient int f8456b;

    /* renamed from: c */
    public transient String f8457c;

    public C1822f(byte[] bArr) {
        this.f8455a = bArr;
    }

    /* renamed from: a */
    public static C1822f m2599a(byte... bArr) {
        if (bArr != null) {
            return new C1822f((byte[]) bArr.clone());
        }
        throw new IllegalArgumentException("data == null");
    }

    /* renamed from: c */
    public static C1822f m2596c(String str) {
        if (str != null) {
            C1822f c1822f = new C1822f(str.getBytes(C1828t.f8497a));
            c1822f.f8457c = str;
            return c1822f;
        }
        throw new IllegalArgumentException("s == null");
    }

    /* renamed from: b */
    public String mo2540b() {
        return Base64.m2628a(this.f8455a);
    }

    /* renamed from: d */
    public C1822f mo2537d() {
        return m2601a("SHA-1");
    }

    /* renamed from: e */
    public C1822f mo2536e() {
        return m2601a("SHA-256");
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof C1822f) {
            C1822f c1822f = (C1822f) obj;
            int mo2535f = c1822f.mo2535f();
            byte[] bArr = this.f8455a;
            if (mo2535f == bArr.length && c1822f.mo2542a(0, bArr, 0, bArr.length)) {
                return true;
            }
        }
        return false;
    }

    /* renamed from: f */
    public int mo2535f() {
        return this.f8455a.length;
    }

    /* renamed from: g */
    public C1822f mo2534g() {
        int i = 0;
        while (true) {
            byte[] bArr = this.f8455a;
            if (i >= bArr.length) {
                return this;
            }
            byte b = bArr[i];
            if (b >= 65 && b <= 90) {
                byte[] bArr2 = (byte[]) bArr.clone();
                bArr2[i] = (byte) (b + 32);
                for (int i2 = i + 1; i2 < bArr2.length; i2++) {
                    byte b2 = bArr2[i2];
                    if (b2 >= 65 && b2 <= 90) {
                        bArr2[i2] = (byte) (b2 + 32);
                    }
                }
                return new C1822f(bArr2);
            }
            i++;
        }
    }

    /* renamed from: h */
    public byte[] mo2533h() {
        return (byte[]) this.f8455a.clone();
    }

    public int hashCode() {
        int i = this.f8456b;
        if (i != 0) {
            return i;
        }
        int hashCode = Arrays.hashCode(this.f8455a);
        this.f8456b = hashCode;
        return hashCode;
    }

    /* renamed from: i */
    public String mo2532i() {
        String str = this.f8457c;
        if (str != null) {
            return str;
        }
        String str2 = new String(this.f8455a, C1828t.f8497a);
        this.f8457c = str2;
        return str2;
    }

    public String toString() {
        if (this.f8455a.length == 0) {
            return "[size=0]";
        }
        String mo2532i = mo2532i();
        int m2600a = m2600a(mo2532i, 64);
        if (m2600a == -1) {
            if (this.f8455a.length <= 64) {
                return "[hex=" + mo2538c() + "]";
            }
            return "[size=" + this.f8455a.length + " hex=" + mo2544a(0, 64).mo2538c() + "…]";
        }
        String replace = mo2532i.substring(0, m2600a).replace("\\", "\\\\").replace("\n", "\\n").replace("\r", "\\r");
        if (m2600a < mo2532i.length()) {
            return "[size=" + this.f8455a.length + " text=" + replace + "…]";
        }
        return "[text=" + replace + "]";
    }

    /* renamed from: b */
    public static C1822f m2597b(String str) {
        if (str != null) {
            if (str.length() % 2 == 0) {
                byte[] bArr = new byte[str.length() / 2];
                for (int i = 0; i < bArr.length; i++) {
                    int i2 = i * 2;
                    bArr[i] = (byte) ((m2603a(str.charAt(i2)) << 4) + m2603a(str.charAt(i2 + 1)));
                }
                return m2599a(bArr);
            }
            throw new IllegalArgumentException("Unexpected hex string: " + str);
        }
        throw new IllegalArgumentException("hex == null");
    }

    /* renamed from: a */
    public final C1822f m2601a(String str) {
        try {
            return m2599a(MessageDigest.getInstance(str).digest(this.f8455a));
        } catch (NoSuchAlgorithmException e) {
            throw new AssertionError(e);
        }
    }

    /* renamed from: c */
    public String mo2538c() {
        byte[] bArr = this.f8455a;
        char[] cArr = new char[bArr.length * 2];
        int i = 0;
        for (byte b : bArr) {
            int i2 = i + 1;
            char[] cArr2 = f8453d;
            cArr[i] = cArr2[(b >> 4) & 15];
            i = i2 + 1;
            cArr[i2] = cArr2[b & 15];
        }
        return new String(cArr);
    }

    /* renamed from: a */
    public static int m2603a(char c) {
        if (c < '0' || c > '9') {
            char c2 = 'a';
            if (c < 'a' || c > 'f') {
                c2 = 'A';
                if (c < 'A' || c > 'F') {
                    throw new IllegalArgumentException("Unexpected hex digit: " + c);
                }
            }
            return (c - c2) + 10;
        }
        return c - '0';
    }

    /* renamed from: a */
    public C1822f mo2544a(int i, int i2) {
        if (i >= 0) {
            byte[] bArr = this.f8455a;
            if (i2 > bArr.length) {
                throw new IllegalArgumentException("endIndex > length(" + this.f8455a.length + ")");
            }
            int i3 = i2 - i;
            if (i3 >= 0) {
                if (i == 0 && i2 == bArr.length) {
                    return this;
                }
                byte[] bArr2 = new byte[i3];
                System.arraycopy(this.f8455a, i, bArr2, 0, i3);
                return new C1822f(bArr2);
            }
            throw new IllegalArgumentException("endIndex < beginIndex");
        }
        throw new IllegalArgumentException("beginIndex < 0");
    }

    /* renamed from: b */
    public final boolean m2598b(C1822f c1822f) {
        return mo2543a(0, c1822f, 0, c1822f.mo2535f());
    }

    /* renamed from: a */
    public byte mo2545a(int i) {
        return this.f8455a[i];
    }

    /* renamed from: a */
    public void mo2541a(Buffer buffer) {
        byte[] bArr = this.f8455a;
        buffer.write(bArr, 0, bArr.length);
    }

    /* renamed from: a */
    public boolean mo2543a(int i, C1822f c1822f, int i2, int i3) {
        return c1822f.mo2542a(i2, this.f8455a, i, i3);
    }

    /* renamed from: a */
    public boolean mo2542a(int i, byte[] bArr, int i2, int i3) {
        if (i >= 0) {
            byte[] bArr2 = this.f8455a;
            if (i <= bArr2.length - i3 && i2 >= 0 && i2 <= bArr.length - i3 && C1828t.m2515a(bArr2, i, bArr, i2, i3)) {
                return true;
            }
        }
        return false;
    }

    @Override // java.lang.Comparable
    /* renamed from: a */
    public int compareTo(C1822f c1822f) {
        int mo2535f = mo2535f();
        int mo2535f2 = c1822f.mo2535f();
        int min = Math.min(mo2535f, mo2535f2);
        for (int i = 0; i < min; i++) {
            int mo2545a = mo2545a(i) & 255;
            int mo2545a2 = c1822f.mo2545a(i) & 255;
            if (mo2545a != mo2545a2) {
                return mo2545a < mo2545a2 ? -1 : 1;
            }
        }
        if (mo2535f == mo2535f2) {
            return 0;
        }
        return mo2535f < mo2535f2 ? -1 : 1;
    }

    /* renamed from: a */
    public static int m2600a(String str, int i) {
        int length = str.length();
        int i2 = 0;
        int i3 = 0;
        while (i2 < length) {
            if (i3 == i) {
                return i2;
            }
            int codePointAt = str.codePointAt(i2);
            if ((Character.isISOControl(codePointAt) && codePointAt != 10 && codePointAt != 13) || codePointAt == 65533) {
                return -1;
            }
            i3++;
            i2 += Character.charCount(codePointAt);
        }
        return str.length();
    }
}
