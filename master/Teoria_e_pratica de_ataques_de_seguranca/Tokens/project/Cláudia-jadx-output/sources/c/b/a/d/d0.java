package c.b.a.d;

import java.util.HashMap;
/* compiled from: RemoveRepeatsStrategy.java */
/* loaded from: classes.dex */
public class d0 implements i0 {

    /* renamed from: a  reason: collision with root package name */
    public final int f2989a;

    public d0(int i2) {
        this.f2989a = i2;
    }

    @Override // c.b.a.d.i0
    public StackTraceElement[] a(StackTraceElement[] stackTraceElementArr) {
        StackTraceElement[] a2 = a(stackTraceElementArr, this.f2989a);
        return a2.length < stackTraceElementArr.length ? a2 : stackTraceElementArr;
    }

    public static StackTraceElement[] a(StackTraceElement[] stackTraceElementArr, int i2) {
        int i3;
        HashMap hashMap = new HashMap();
        StackTraceElement[] stackTraceElementArr2 = new StackTraceElement[stackTraceElementArr.length];
        int i4 = 0;
        int i5 = 0;
        int i6 = 1;
        while (i4 < stackTraceElementArr.length) {
            StackTraceElement stackTraceElement = stackTraceElementArr[i4];
            Integer num = (Integer) hashMap.get(stackTraceElement);
            if (num != null && a(stackTraceElementArr, num.intValue(), i4)) {
                int intValue = i4 - num.intValue();
                if (i6 < i2) {
                    System.arraycopy(stackTraceElementArr, i4, stackTraceElementArr2, i5, intValue);
                    i5 += intValue;
                    i6++;
                }
                i3 = (intValue - 1) + i4;
            } else {
                stackTraceElementArr2[i5] = stackTraceElementArr[i4];
                i5++;
                i3 = i4;
                i6 = 1;
            }
            hashMap.put(stackTraceElement, Integer.valueOf(i4));
            i4 = i3 + 1;
        }
        StackTraceElement[] stackTraceElementArr3 = new StackTraceElement[i5];
        System.arraycopy(stackTraceElementArr2, 0, stackTraceElementArr3, 0, stackTraceElementArr3.length);
        return stackTraceElementArr3;
    }

    public static boolean a(StackTraceElement[] stackTraceElementArr, int i2, int i3) {
        int i4 = i3 - i2;
        if (i3 + i4 > stackTraceElementArr.length) {
            return false;
        }
        for (int i5 = 0; i5 < i4; i5++) {
            if (!stackTraceElementArr[i2 + i5].equals(stackTraceElementArr[i3 + i5])) {
                return false;
            }
        }
        return true;
    }
}
