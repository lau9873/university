package f;

import java.io.Serializable;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
/* compiled from: ByteString.java */
/* loaded from: classes.dex */
public class f implements Serializable, Comparable<f> {

    /* renamed from: d  reason: collision with root package name */
    public static final char[] f6002d = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};

    /* renamed from: e  reason: collision with root package name */
    public static final f f6003e = a(new byte[0]);

    /* renamed from: a  reason: collision with root package name */
    public final byte[] f6004a;

    /* renamed from: b  reason: collision with root package name */
    public transient int f6005b;

    /* renamed from: c  reason: collision with root package name */
    public transient String f6006c;

    public f(byte[] bArr) {
        this.f6004a = bArr;
    }

    public static f a(byte... bArr) {
        if (bArr != null) {
            return new f((byte[]) bArr.clone());
        }
        throw new IllegalArgumentException("data == null");
    }

    public static f c(String str) {
        if (str != null) {
            f fVar = new f(str.getBytes(t.f6045a));
            fVar.f6006c = str;
            return fVar;
        }
        throw new IllegalArgumentException("s == null");
    }

    public String b() {
        return b.a(this.f6004a);
    }

    public f d() {
        return a("SHA-1");
    }

    public f e() {
        return a("SHA-256");
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof f) {
            f fVar = (f) obj;
            int f2 = fVar.f();
            byte[] bArr = this.f6004a;
            if (f2 == bArr.length && fVar.a(0, bArr, 0, bArr.length)) {
                return true;
            }
        }
        return false;
    }

    public int f() {
        return this.f6004a.length;
    }

    public f g() {
        int i2 = 0;
        while (true) {
            byte[] bArr = this.f6004a;
            if (i2 >= bArr.length) {
                return this;
            }
            byte b2 = bArr[i2];
            if (b2 >= 65 && b2 <= 90) {
                byte[] bArr2 = (byte[]) bArr.clone();
                bArr2[i2] = (byte) (b2 + 32);
                for (int i3 = i2 + 1; i3 < bArr2.length; i3++) {
                    byte b3 = bArr2[i3];
                    if (b3 >= 65 && b3 <= 90) {
                        bArr2[i3] = (byte) (b3 + 32);
                    }
                }
                return new f(bArr2);
            }
            i2++;
        }
    }

    public byte[] h() {
        return (byte[]) this.f6004a.clone();
    }

    public int hashCode() {
        int i2 = this.f6005b;
        if (i2 != 0) {
            return i2;
        }
        int hashCode = Arrays.hashCode(this.f6004a);
        this.f6005b = hashCode;
        return hashCode;
    }

    public String i() {
        String str = this.f6006c;
        if (str != null) {
            return str;
        }
        String str2 = new String(this.f6004a, t.f6045a);
        this.f6006c = str2;
        return str2;
    }

    public String toString() {
        if (this.f6004a.length == 0) {
            return "[size=0]";
        }
        String i2 = i();
        int a2 = a(i2, 64);
        if (a2 == -1) {
            if (this.f6004a.length <= 64) {
                return "[hex=" + c() + "]";
            }
            return "[size=" + this.f6004a.length + " hex=" + a(0, 64).c() + "…]";
        }
        String replace = i2.substring(0, a2).replace("\\", "\\\\").replace("\n", "\\n").replace("\r", "\\r");
        if (a2 < i2.length()) {
            return "[size=" + this.f6004a.length + " text=" + replace + "…]";
        }
        return "[text=" + replace + "]";
    }

    public static f b(String str) {
        if (str != null) {
            if (str.length() % 2 == 0) {
                byte[] bArr = new byte[str.length() / 2];
                for (int i2 = 0; i2 < bArr.length; i2++) {
                    int i3 = i2 * 2;
                    bArr[i2] = (byte) ((a(str.charAt(i3)) << 4) + a(str.charAt(i3 + 1)));
                }
                return a(bArr);
            }
            throw new IllegalArgumentException("Unexpected hex string: " + str);
        }
        throw new IllegalArgumentException("hex == null");
    }

    public final f a(String str) {
        try {
            return a(MessageDigest.getInstance(str).digest(this.f6004a));
        } catch (NoSuchAlgorithmException e2) {
            throw new AssertionError(e2);
        }
    }

    public String c() {
        byte[] bArr = this.f6004a;
        char[] cArr = new char[bArr.length * 2];
        int i2 = 0;
        for (byte b2 : bArr) {
            int i3 = i2 + 1;
            char[] cArr2 = f6002d;
            cArr[i2] = cArr2[(b2 >> 4) & 15];
            i2 = i3 + 1;
            cArr[i3] = cArr2[b2 & 15];
        }
        return new String(cArr);
    }

    public static int a(char c2) {
        if (c2 < '0' || c2 > '9') {
            char c3 = 'a';
            if (c2 < 'a' || c2 > 'f') {
                c3 = 'A';
                if (c2 < 'A' || c2 > 'F') {
                    throw new IllegalArgumentException("Unexpected hex digit: " + c2);
                }
            }
            return (c2 - c3) + 10;
        }
        return c2 - '0';
    }

    public f a(int i2, int i3) {
        if (i2 >= 0) {
            byte[] bArr = this.f6004a;
            if (i3 > bArr.length) {
                throw new IllegalArgumentException("endIndex > length(" + this.f6004a.length + ")");
            }
            int i4 = i3 - i2;
            if (i4 >= 0) {
                if (i2 == 0 && i3 == bArr.length) {
                    return this;
                }
                byte[] bArr2 = new byte[i4];
                System.arraycopy(this.f6004a, i2, bArr2, 0, i4);
                return new f(bArr2);
            }
            throw new IllegalArgumentException("endIndex < beginIndex");
        }
        throw new IllegalArgumentException("beginIndex < 0");
    }

    public final boolean b(f fVar) {
        return a(0, fVar, 0, fVar.f());
    }

    public byte a(int i2) {
        return this.f6004a[i2];
    }

    public void a(c cVar) {
        byte[] bArr = this.f6004a;
        cVar.write(bArr, 0, bArr.length);
    }

    public boolean a(int i2, f fVar, int i3, int i4) {
        return fVar.a(i3, this.f6004a, i2, i4);
    }

    public boolean a(int i2, byte[] bArr, int i3, int i4) {
        if (i2 >= 0) {
            byte[] bArr2 = this.f6004a;
            if (i2 <= bArr2.length - i4 && i3 >= 0 && i3 <= bArr.length - i4 && t.a(bArr2, i2, bArr, i3, i4)) {
                return true;
            }
        }
        return false;
    }

    @Override // java.lang.Comparable
    /* renamed from: a */
    public int compareTo(f fVar) {
        int f2 = f();
        int f3 = fVar.f();
        int min = Math.min(f2, f3);
        for (int i2 = 0; i2 < min; i2++) {
            int a2 = a(i2) & 255;
            int a3 = fVar.a(i2) & 255;
            if (a2 != a3) {
                return a2 < a3 ? -1 : 1;
            }
        }
        if (f2 == f3) {
            return 0;
        }
        return f2 < f3 ? -1 : 1;
    }

    public static int a(String str, int i2) {
        int length = str.length();
        int i3 = 0;
        int i4 = 0;
        while (i3 < length) {
            if (i4 == i2) {
                return i3;
            }
            int codePointAt = str.codePointAt(i3);
            if ((Character.isISOControl(codePointAt) && codePointAt != 10 && codePointAt != 13) || codePointAt == 65533) {
                return -1;
            }
            i4++;
            i3 += Character.charCount(codePointAt);
        }
        return str.length();
    }
}
