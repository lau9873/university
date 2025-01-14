package p000a.p006b.p030g.p044j;

import java.io.PrintWriter;

/* renamed from: a.b.g.j.p */
/* loaded from: classes.dex */
public final class TimeUtils {

    /* renamed from: a */
    public static final Object f1609a = new Object();

    /* renamed from: b */
    public static char[] f1610b = new char[24];

    /* renamed from: a */
    public static int m9594a(int i, int i2, boolean z, int i3) {
        if (i > 99 || (z && i3 >= 3)) {
            return i2 + 3;
        }
        if (i > 9 || (z && i3 >= 2)) {
            return i2 + 2;
        }
        if (z || i > 0) {
            return i2 + 1;
        }
        return 0;
    }

    /* renamed from: a */
    public static int m9589a(char[] cArr, int i, char c, int i2, boolean z, int i3) {
        int i4;
        if (z || i > 0) {
            if ((!z || i3 < 3) && i <= 99) {
                i4 = i2;
            } else {
                int i5 = i / 100;
                cArr[i2] = (char) (i5 + 48);
                i4 = i2 + 1;
                i -= i5 * 100;
            }
            if ((z && i3 >= 2) || i > 9 || i2 != i4) {
                int i6 = i / 10;
                cArr[i4] = (char) (i6 + 48);
                i4++;
                i -= i6 * 10;
            }
            cArr[i4] = (char) (i + 48);
            int i7 = i4 + 1;
            cArr[i7] = c;
            return i7 + 1;
        }
        return i2;
    }

    /* renamed from: a */
    public static int m9593a(long j, int i) {
        char c;
        int i2;
        int i3;
        int i4;
        int i5;
        int i6;
        long j2 = j;
        if (f1610b.length < i) {
            f1610b = new char[i];
        }
        char[] cArr = f1610b;
        int i7 = (j2 > 0L ? 1 : (j2 == 0L ? 0 : -1));
        if (i7 == 0) {
            int i8 = i - 1;
            while (i8 > 0) {
                cArr[0] = ' ';
            }
            cArr[0] = '0';
            return 1;
        }
        if (i7 > 0) {
            c = '+';
        } else {
            c = '-';
            j2 = -j2;
        }
        int i9 = (int) (j2 % 1000);
        int floor = (int) Math.floor(j2 / 1000);
        if (floor > 86400) {
            i2 = floor / 86400;
            floor -= 86400 * i2;
        } else {
            i2 = 0;
        }
        if (floor > 3600) {
            i3 = floor / 3600;
            floor -= i3 * 3600;
        } else {
            i3 = 0;
        }
        if (floor > 60) {
            int i10 = floor / 60;
            i4 = floor - (i10 * 60);
            i5 = i10;
        } else {
            i4 = floor;
            i5 = 0;
        }
        if (i != 0) {
            int m9594a = m9594a(i2, 1, false, 0);
            int m9594a2 = m9594a + m9594a(i3, 1, m9594a > 0, 2);
            int m9594a3 = m9594a2 + m9594a(i5, 1, m9594a2 > 0, 2);
            int m9594a4 = m9594a3 + m9594a(i4, 1, m9594a3 > 0, 2);
            i6 = 0;
            for (int m9594a5 = m9594a4 + m9594a(i9, 2, true, m9594a4 > 0 ? 3 : 0) + 1; m9594a5 < i; m9594a5++) {
                cArr[i6] = ' ';
                i6++;
            }
        } else {
            i6 = 0;
        }
        cArr[i6] = c;
        int i11 = i6 + 1;
        boolean z = i != 0;
        int m9589a = m9589a(cArr, i2, 'd', i11, false, 0);
        int m9589a2 = m9589a(cArr, i3, 'h', m9589a, m9589a != i11, z ? 2 : 0);
        int m9589a3 = m9589a(cArr, i5, 'm', m9589a2, m9589a2 != i11, z ? 2 : 0);
        int m9589a4 = m9589a(cArr, i4, 's', m9589a3, m9589a3 != i11, z ? 2 : 0);
        int m9589a5 = m9589a(cArr, i9, 'm', m9589a4, true, (!z || m9589a4 == i11) ? 0 : 3);
        cArr[m9589a5] = 's';
        return m9589a5 + 1;
    }

    /* renamed from: a */
    public static void m9590a(long j, PrintWriter printWriter, int i) {
        synchronized (f1609a) {
            printWriter.print(new String(f1610b, 0, m9593a(j, i)));
        }
    }

    /* renamed from: a */
    public static void m9591a(long j, PrintWriter printWriter) {
        m9590a(j, printWriter, 0);
    }

    /* renamed from: a */
    public static void m9592a(long j, long j2, PrintWriter printWriter) {
        if (j == 0) {
            printWriter.print("--");
        } else {
            m9590a(j - j2, printWriter, 0);
        }
    }
}
