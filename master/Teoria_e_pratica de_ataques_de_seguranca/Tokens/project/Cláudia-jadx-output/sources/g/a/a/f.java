package g.a.a;

import android.annotation.TargetApi;
import java.io.Serializable;
import java.nio.ByteBuffer;
import java.nio.LongBuffer;
import java.util.Arrays;
import java.util.UUID;
import java.util.regex.Pattern;
/* compiled from: Identifier.java */
/* loaded from: classes.dex */
public class f implements Comparable<f>, Serializable {

    /* renamed from: b  reason: collision with root package name */
    public static final Pattern f6059b = Pattern.compile("^0x[0-9A-Fa-f]*$");

    /* renamed from: c  reason: collision with root package name */
    public static final Pattern f6060c = Pattern.compile("^[0-9A-Fa-f]*$");

    /* renamed from: d  reason: collision with root package name */
    public static final Pattern f6061d = Pattern.compile("^0|[1-9][0-9]*$");

    /* renamed from: e  reason: collision with root package name */
    public static final Pattern f6062e = Pattern.compile("^[0-9A-Fa-f]{8}-?[0-9A-Fa-f]{4}-?[0-9A-Fa-f]{4}-?[0-9A-Fa-f]{4}-?[0-9A-Fa-f]{12}$");

    /* renamed from: f  reason: collision with root package name */
    public static final char[] f6063f = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};

    /* renamed from: a  reason: collision with root package name */
    public final byte[] f6064a;

    public f(byte[] bArr) {
        if (bArr != null) {
            this.f6064a = bArr;
            return;
        }
        throw new NullPointerException("Identifiers cannot be constructed from null pointers but \"value\" is null.");
    }

    public static f a(String str) {
        return a(str, -1);
    }

    public static f b(String str, int i2) {
        String str2 = (str.length() % 2 == 0 ? "" : "0") + str.toUpperCase();
        if (i2 > 0 && i2 < str2.length() / 2) {
            str2 = str2.substring(str2.length() - (i2 * 2));
        }
        if (i2 > 0 && i2 > str2.length() / 2) {
            int length = (i2 * 2) - str2.length();
            StringBuilder sb = new StringBuilder();
            while (sb.length() < length) {
                sb.append("0");
            }
            str2 = sb.toString() + str2;
        }
        byte[] bArr = new byte[str2.length() / 2];
        for (int i3 = 0; i3 < bArr.length; i3++) {
            int i4 = i3 * 2;
            bArr[i3] = (byte) (Integer.parseInt(str2.substring(i4, i4 + 2), 16) & 255);
        }
        return new f(bArr);
    }

    public byte[] c() {
        return (byte[]) this.f6064a.clone();
    }

    public String d() {
        int length = this.f6064a.length;
        int i2 = 2;
        char[] cArr = new char[(length * 2) + 2];
        cArr[0] = '0';
        cArr[1] = 'x';
        for (int i3 = 0; i3 < length; i3++) {
            int i4 = i2 + 1;
            char[] cArr2 = f6063f;
            byte[] bArr = this.f6064a;
            cArr[i2] = cArr2[(bArr[i3] & 240) >>> 4];
            i2 = i4 + 1;
            cArr[i4] = cArr2[bArr[i3] & 15];
        }
        return new String(cArr);
    }

    public int e() {
        if (this.f6064a.length > 2) {
            throw new UnsupportedOperationException("Only supported for Identifiers with max byte length of 2");
        }
        int i2 = 0;
        int i3 = 0;
        while (true) {
            byte[] bArr = this.f6064a;
            if (i2 >= bArr.length) {
                return i3;
            }
            i3 |= (bArr[i2] & 255) << (((bArr.length - i2) - 1) * 8);
            i2++;
        }
    }

    public boolean equals(Object obj) {
        if (obj instanceof f) {
            return Arrays.equals(this.f6064a, ((f) obj).f6064a);
        }
        return false;
    }

    public UUID f() {
        byte[] bArr = this.f6064a;
        if (bArr.length == 16) {
            LongBuffer asLongBuffer = ByteBuffer.wrap(bArr).asLongBuffer();
            return new UUID(asLongBuffer.get(), asLongBuffer.get());
        }
        throw new UnsupportedOperationException("Only Identifiers backed by a byte array with length of exactly 16 can be UUIDs.");
    }

    public int hashCode() {
        return Arrays.hashCode(this.f6064a);
    }

    public String toString() {
        byte[] bArr = this.f6064a;
        if (bArr.length == 2) {
            return Integer.toString(e());
        }
        if (bArr.length == 16) {
            return f().toString();
        }
        return d();
    }

    public static f a(String str, int i2) {
        if (str != null) {
            if (f6059b.matcher(str).matches()) {
                return b(str.substring(2), i2);
            }
            if (f6062e.matcher(str).matches()) {
                return b(str.replace("-", ""), i2);
            }
            if (f6061d.matcher(str).matches()) {
                try {
                    int intValue = Integer.valueOf(str).intValue();
                    if (i2 > 0 && i2 != 2) {
                        return a(intValue, i2);
                    }
                    return a(intValue);
                } catch (Throwable th) {
                    throw new IllegalArgumentException("Unable to parse Identifier in decimal format.", th);
                }
            } else if (f6060c.matcher(str).matches()) {
                return b(str, i2);
            } else {
                throw new IllegalArgumentException("Unable to parse Identifier.");
            }
        }
        throw new NullPointerException("Identifiers cannot be constructed from null pointers but \"stringValue\" is null.");
    }

    public static f a(long j, int i2) {
        if (i2 >= 0) {
            byte[] bArr = new byte[i2];
            for (int i3 = i2 - 1; i3 >= 0; i3--) {
                bArr[i3] = (byte) (255 & j);
                j >>= 8;
            }
            return new f(bArr);
        }
        throw new IllegalArgumentException("Identifier length must be > 0.");
    }

    public int b() {
        return this.f6064a.length;
    }

    public static f a(int i2) {
        if (i2 >= 0 && i2 <= 65535) {
            return new f(new byte[]{(byte) (i2 >> 8), (byte) i2});
        }
        throw new IllegalArgumentException("Identifiers can only be constructed from integers between 0 and 65535 (inclusive).");
    }

    @TargetApi(9)
    public static f a(byte[] bArr, int i2, int i3, boolean z) {
        if (bArr != null) {
            if (i2 >= 0 && i2 <= bArr.length) {
                if (i3 <= bArr.length) {
                    if (i2 <= i3) {
                        byte[] copyOfRange = Arrays.copyOfRange(bArr, i2, i3);
                        if (z) {
                            a(copyOfRange);
                        }
                        return new f(copyOfRange);
                    }
                    throw new IllegalArgumentException("start > end");
                }
                throw new ArrayIndexOutOfBoundsException("end > bytes.length");
            }
            throw new ArrayIndexOutOfBoundsException("start < 0 || start > bytes.length");
        }
        throw new NullPointerException("Identifiers cannot be constructed from null pointers but \"bytes\" is null.");
    }

    public static void a(byte[] bArr) {
        for (int i2 = 0; i2 < bArr.length / 2; i2++) {
            int length = (bArr.length - i2) - 1;
            byte b2 = bArr[i2];
            bArr[i2] = bArr[length];
            bArr[length] = b2;
        }
    }

    @Override // java.lang.Comparable
    /* renamed from: a */
    public int compareTo(f fVar) {
        byte[] bArr = this.f6064a;
        int length = bArr.length;
        byte[] bArr2 = fVar.f6064a;
        if (length != bArr2.length) {
            return bArr.length < bArr2.length ? -1 : 1;
        }
        int i2 = 0;
        while (true) {
            byte[] bArr3 = this.f6064a;
            if (i2 >= bArr3.length) {
                return 0;
            }
            byte b2 = bArr3[i2];
            byte[] bArr4 = fVar.f6064a;
            if (b2 != bArr4[i2]) {
                return bArr3[i2] < bArr4[i2] ? -1 : 1;
            }
            i2++;
        }
    }
}
