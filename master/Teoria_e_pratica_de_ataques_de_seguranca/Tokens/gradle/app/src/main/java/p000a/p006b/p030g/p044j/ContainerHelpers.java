package p000a.p006b.p030g.p044j;

/* renamed from: a.b.g.j.c */
/* loaded from: classes.dex */
public class ContainerHelpers {

    /* renamed from: a */
    public static final int[] f1561a = new int[0];

    /* renamed from: b */
    public static final long[] f1562b = new long[0];

    /* renamed from: c */
    public static final Object[] f1563c = new Object[0];

    /* renamed from: a */
    public static int m9673a(int i) {
        for (int i2 = 4; i2 < 32; i2++) {
            int i3 = (1 << i2) - 12;
            if (i <= i3) {
                return i3;
            }
        }
        return i;
    }

    /* renamed from: a */
    public static boolean m9672a(Object obj, Object obj2) {
        return obj == obj2 || (obj != null && obj.equals(obj2));
    }

    /* renamed from: b */
    public static int m9669b(int i) {
        return m9673a(i * 4) / 4;
    }

    /* renamed from: c */
    public static int m9668c(int i) {
        return m9673a(i * 8) / 8;
    }

    /* renamed from: a */
    public static int m9671a(int[] iArr, int i, int i2) {
        int i3 = i - 1;
        int i4 = 0;
        while (i4 <= i3) {
            int i5 = (i4 + i3) >>> 1;
            int i6 = iArr[i5];
            if (i6 < i2) {
                i4 = i5 + 1;
            } else if (i6 <= i2) {
                return i5;
            } else {
                i3 = i5 - 1;
            }
        }
        return ~i4;
    }

    /* renamed from: a */
    public static int m9670a(long[] jArr, int i, long j) {
        int i2 = i - 1;
        int i3 = 0;
        while (i3 <= i2) {
            int i4 = (i3 + i2) >>> 1;
            int i5 = (jArr[i4] > j ? 1 : (jArr[i4] == j ? 0 : -1));
            if (i5 < 0) {
                i3 = i4 + 1;
            } else if (i5 <= 0) {
                return i4;
            } else {
                i2 = i4 - 1;
            }
        }
        return ~i3;
    }
}
