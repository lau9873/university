package a.b.g.j;

import java.io.PrintWriter;
/* compiled from: TimeUtils.java */
/* loaded from: classes.dex */
public final class p {

    /* renamed from: a  reason: collision with root package name */
    public static final Object f1098a = new Object();

    /* renamed from: b  reason: collision with root package name */
    public static char[] f1099b = new char[24];

    public static int a(int i2, int i3, boolean z, int i4) {
        if (i2 > 99 || (z && i4 >= 3)) {
            return i3 + 3;
        }
        if (i2 > 9 || (z && i4 >= 2)) {
            return i3 + 2;
        }
        if (z || i2 > 0) {
            return i3 + 1;
        }
        return 0;
    }

    public static int a(char[] cArr, int i2, char c2, int i3, boolean z, int i4) {
        int i5;
        if (z || i2 > 0) {
            if ((!z || i4 < 3) && i2 <= 99) {
                i5 = i3;
            } else {
                int i6 = i2 / 100;
                cArr[i3] = (char) (i6 + 48);
                i5 = i3 + 1;
                i2 -= i6 * 100;
            }
            if ((z && i4 >= 2) || i2 > 9 || i3 != i5) {
                int i7 = i2 / 10;
                cArr[i5] = (char) (i7 + 48);
                i5++;
                i2 -= i7 * 10;
            }
            cArr[i5] = (char) (i2 + 48);
            int i8 = i5 + 1;
            cArr[i8] = c2;
            return i8 + 1;
        }
        return i3;
    }

    public static int a(long j, int i2) {
        char c2;
        int i3;
        int i4;
        int i5;
        int i6;
        int i7;
        long j2 = j;
        if (f1099b.length < i2) {
            f1099b = new char[i2];
        }
        char[] cArr = f1099b;
        int i8 = (j2 > 0L ? 1 : (j2 == 0L ? 0 : -1));
        if (i8 == 0) {
            int i9 = i2 - 1;
            while (i9 > 0) {
                cArr[0] = ' ';
            }
            cArr[0] = '0';
            return 1;
        }
        if (i8 > 0) {
            c2 = '+';
        } else {
            c2 = '-';
            j2 = -j2;
        }
        int i10 = (int) (j2 % 1000);
        int floor = (int) Math.floor(j2 / 1000);
        if (floor > 86400) {
            i3 = floor / 86400;
            floor -= 86400 * i3;
        } else {
            i3 = 0;
        }
        if (floor > 3600) {
            i4 = floor / 3600;
            floor -= i4 * 3600;
        } else {
            i4 = 0;
        }
        if (floor > 60) {
            int i11 = floor / 60;
            i5 = floor - (i11 * 60);
            i6 = i11;
        } else {
            i5 = floor;
            i6 = 0;
        }
        if (i2 != 0) {
            int a2 = a(i3, 1, false, 0);
            int a3 = a2 + a(i4, 1, a2 > 0, 2);
            int a4 = a3 + a(i6, 1, a3 > 0, 2);
            int a5 = a4 + a(i5, 1, a4 > 0, 2);
            i7 = 0;
            for (int a6 = a5 + a(i10, 2, true, a5 > 0 ? 3 : 0) + 1; a6 < i2; a6++) {
                cArr[i7] = ' ';
                i7++;
            }
        } else {
            i7 = 0;
        }
        cArr[i7] = c2;
        int i12 = i7 + 1;
        boolean z = i2 != 0;
        int a7 = a(cArr, i3, 'd', i12, false, 0);
        int a8 = a(cArr, i4, 'h', a7, a7 != i12, z ? 2 : 0);
        int a9 = a(cArr, i6, 'm', a8, a8 != i12, z ? 2 : 0);
        int a10 = a(cArr, i5, 's', a9, a9 != i12, z ? 2 : 0);
        int a11 = a(cArr, i10, 'm', a10, true, (!z || a10 == i12) ? 0 : 3);
        cArr[a11] = 's';
        return a11 + 1;
    }

    public static void a(long j, PrintWriter printWriter, int i2) {
        synchronized (f1098a) {
            printWriter.print(new String(f1099b, 0, a(j, i2)));
        }
    }

    public static void a(long j, PrintWriter printWriter) {
        a(j, printWriter, 0);
    }

    public static void a(long j, long j2, PrintWriter printWriter) {
        if (j == 0) {
            printWriter.print("--");
        } else {
            a(j - j2, printWriter, 0);
        }
    }
}
