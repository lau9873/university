package p193g.p194a.p195a;

import android.annotation.TargetApi;
import java.io.Serializable;
import java.nio.ByteBuffer;
import java.nio.LongBuffer;
import java.util.Arrays;
import java.util.UUID;
import java.util.regex.Pattern;

/* renamed from: g.a.a.f */
/* loaded from: classes.dex */
public class Identifier implements Comparable<Identifier>, Serializable {

    /* renamed from: b */
    public static final Pattern f8521b = Pattern.compile("^0x[0-9A-Fa-f]*$");

    /* renamed from: c */
    public static final Pattern f8522c = Pattern.compile("^[0-9A-Fa-f]*$");

    /* renamed from: d */
    public static final Pattern f8523d = Pattern.compile("^0|[1-9][0-9]*$");

    /* renamed from: e */
    public static final Pattern f8524e = Pattern.compile("^[0-9A-Fa-f]{8}-?[0-9A-Fa-f]{4}-?[0-9A-Fa-f]{4}-?[0-9A-Fa-f]{4}-?[0-9A-Fa-f]{12}$");

    /* renamed from: f */
    public static final char[] f8525f = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};

    /* renamed from: a */
    public final byte[] f8526a;

    public Identifier(byte[] bArr) {
        if (bArr != null) {
            this.f8526a = bArr;
            return;
        }
        throw new NullPointerException("Identifiers cannot be constructed from null pointers but \"value\" is null.");
    }

    /* renamed from: a */
    public static Identifier m2483a(String str) {
        return m2482a(str, -1);
    }

    /* renamed from: b */
    public static Identifier m2478b(String str, int i) {
        String str2 = (str.length() % 2 == 0 ? "" : "0") + str.toUpperCase();
        if (i > 0 && i < str2.length() / 2) {
            str2 = str2.substring(str2.length() - (i * 2));
        }
        if (i > 0 && i > str2.length() / 2) {
            int length = (i * 2) - str2.length();
            StringBuilder sb = new StringBuilder();
            while (sb.length() < length) {
                sb.append("0");
            }
            str2 = sb.toString() + str2;
        }
        byte[] bArr = new byte[str2.length() / 2];
        for (int i2 = 0; i2 < bArr.length; i2++) {
            int i3 = i2 * 2;
            bArr[i2] = (byte) (Integer.parseInt(str2.substring(i3, i3 + 2), 16) & 255);
        }
        return new Identifier(bArr);
    }

    /* renamed from: c */
    public byte[] m2477c() {
        return (byte[]) this.f8526a.clone();
    }

    /* renamed from: d */
    public String m2476d() {
        int length = this.f8526a.length;
        int i = 2;
        char[] cArr = new char[(length * 2) + 2];
        cArr[0] = '0';
        cArr[1] = 'x';
        for (int i2 = 0; i2 < length; i2++) {
            int i3 = i + 1;
            char[] cArr2 = f8525f;
            byte[] bArr = this.f8526a;
            cArr[i] = cArr2[(bArr[i2] & 240) >>> 4];
            i = i3 + 1;
            cArr[i3] = cArr2[bArr[i2] & 15];
        }
        return new String(cArr);
    }

    /* renamed from: e */
    public int m2475e() {
        if (this.f8526a.length > 2) {
            throw new UnsupportedOperationException("Only supported for Identifiers with max byte length of 2");
        }
        int i = 0;
        int i2 = 0;
        while (true) {
            byte[] bArr = this.f8526a;
            if (i >= bArr.length) {
                return i2;
            }
            i2 |= (bArr[i] & 255) << (((bArr.length - i) - 1) * 8);
            i++;
        }
    }

    public boolean equals(Object obj) {
        if (obj instanceof Identifier) {
            return Arrays.equals(this.f8526a, ((Identifier) obj).f8526a);
        }
        return false;
    }

    /* renamed from: f */
    public UUID m2474f() {
        byte[] bArr = this.f8526a;
        if (bArr.length == 16) {
            LongBuffer asLongBuffer = ByteBuffer.wrap(bArr).asLongBuffer();
            return new UUID(asLongBuffer.get(), asLongBuffer.get());
        }
        throw new UnsupportedOperationException("Only Identifiers backed by a byte array with length of exactly 16 can be UUIDs.");
    }

    public int hashCode() {
        return Arrays.hashCode(this.f8526a);
    }

    public String toString() {
        byte[] bArr = this.f8526a;
        if (bArr.length == 2) {
            return Integer.toString(m2475e());
        }
        if (bArr.length == 16) {
            return m2474f().toString();
        }
        return m2476d();
    }

    /* renamed from: a */
    public static Identifier m2482a(String str, int i) {
        if (str != null) {
            if (f8521b.matcher(str).matches()) {
                return m2478b(str.substring(2), i);
            }
            if (f8524e.matcher(str).matches()) {
                return m2478b(str.replace("-", ""), i);
            }
            if (f8523d.matcher(str).matches()) {
                try {
                    int intValue = Integer.valueOf(str).intValue();
                    if (i > 0 && i != 2) {
                        return m2485a(intValue, i);
                    }
                    return m2486a(intValue);
                } catch (Throwable th) {
                    throw new IllegalArgumentException("Unable to parse Identifier in decimal format.", th);
                }
            } else if (f8522c.matcher(str).matches()) {
                return m2478b(str, i);
            } else {
                throw new IllegalArgumentException("Unable to parse Identifier.");
            }
        }
        throw new NullPointerException("Identifiers cannot be constructed from null pointers but \"stringValue\" is null.");
    }

    /* renamed from: a */
    public static Identifier m2485a(long j, int i) {
        if (i >= 0) {
            byte[] bArr = new byte[i];
            for (int i2 = i - 1; i2 >= 0; i2--) {
                bArr[i2] = (byte) (255 & j);
                j >>= 8;
            }
            return new Identifier(bArr);
        }
        throw new IllegalArgumentException("Identifier length must be > 0.");
    }

    /* renamed from: b */
    public int m2479b() {
        return this.f8526a.length;
    }

    /* renamed from: a */
    public static Identifier m2486a(int i) {
        if (i >= 0 && i <= 65535) {
            return new Identifier(new byte[]{(byte) (i >> 8), (byte) i});
        }
        throw new IllegalArgumentException("Identifiers can only be constructed from integers between 0 and 65535 (inclusive).");
    }

    @TargetApi(9)
    /* renamed from: a */
    public static Identifier m2480a(byte[] bArr, int i, int i2, boolean z) {
        if (bArr != null) {
            if (i >= 0 && i <= bArr.length) {
                if (i2 <= bArr.length) {
                    if (i <= i2) {
                        byte[] copyOfRange = Arrays.copyOfRange(bArr, i, i2);
                        if (z) {
                            m2481a(copyOfRange);
                        }
                        return new Identifier(copyOfRange);
                    }
                    throw new IllegalArgumentException("start > end");
                }
                throw new ArrayIndexOutOfBoundsException("end > bytes.length");
            }
            throw new ArrayIndexOutOfBoundsException("start < 0 || start > bytes.length");
        }
        throw new NullPointerException("Identifiers cannot be constructed from null pointers but \"bytes\" is null.");
    }

    /* renamed from: a */
    public static void m2481a(byte[] bArr) {
        for (int i = 0; i < bArr.length / 2; i++) {
            int length = (bArr.length - i) - 1;
            byte b = bArr[i];
            bArr[i] = bArr[length];
            bArr[length] = b;
        }
    }

    @Override // java.lang.Comparable
    /* renamed from: a */
    public int compareTo(Identifier identifier) {
        byte[] bArr = this.f8526a;
        int length = bArr.length;
        byte[] bArr2 = identifier.f8526a;
        if (length != bArr2.length) {
            return bArr.length < bArr2.length ? -1 : 1;
        }
        int i = 0;
        while (true) {
            byte[] bArr3 = this.f8526a;
            if (i >= bArr3.length) {
                return 0;
            }
            byte b = bArr3[i];
            byte[] bArr4 = identifier.f8526a;
            if (b != bArr4[i]) {
                return bArr3[i] < bArr4[i] ? -1 : 1;
            }
            i++;
        }
    }
}
