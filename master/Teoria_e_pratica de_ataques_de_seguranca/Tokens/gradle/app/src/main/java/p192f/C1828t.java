package p192f;

import java.nio.charset.Charset;

/* compiled from: Util.java */
/* renamed from: f.t */
/* loaded from: classes.dex */
public final class C1828t {

    /* renamed from: a */
    public static final Charset f8497a = Charset.forName("UTF-8");

    /* renamed from: a */
    public static int m2519a(int i) {
        return ((i & 255) << 24) | (((-16777216) & i) >>> 24) | ((16711680 & i) >>> 8) | ((65280 & i) << 8);
    }

    /* renamed from: a */
    public static short m2516a(short s) {
        int i = s & 65535;
        return (short) (((i & 255) << 8) | ((65280 & i) >>> 8));
    }

    /* renamed from: a */
    public static void m2518a(long j, long j2, long j3) {
        if ((j2 | j3) < 0 || j2 > j || j - j2 < j3) {
            throw new ArrayIndexOutOfBoundsException(String.format("size=%s offset=%s byteCount=%s", Long.valueOf(j), Long.valueOf(j2), Long.valueOf(j3)));
        }
    }

    /* renamed from: b */
    public static <T extends Throwable> void m2514b(Throwable th) {
        throw th;
    }

    /* renamed from: a */
    public static void m2517a(Throwable th) {
        m2514b(th);
        throw null;
    }

    /* renamed from: a */
    public static boolean m2515a(byte[] bArr, int i, byte[] bArr2, int i2, int i3) {
        for (int i4 = 0; i4 < i3; i4++) {
            if (bArr[i4 + i] != bArr2[i4 + i2]) {
                return false;
            }
        }
        return true;
    }
}
