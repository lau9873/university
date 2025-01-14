package p070c.p074b.p075a.p078d;

import java.util.HashMap;

/* renamed from: c.b.a.d.d0 */
/* loaded from: classes.dex */
public class RemoveRepeatsStrategy implements StackTraceTrimmingStrategy {

    /* renamed from: a */
    public final int f4802a;

    public RemoveRepeatsStrategy(int i) {
        this.f4802a = i;
    }

    @Override // p070c.p074b.p075a.p078d.StackTraceTrimmingStrategy
    /* renamed from: a */
    public StackTraceElement[] mo5703a(StackTraceElement[] stackTraceElementArr) {
        StackTraceElement[] m5958a = m5958a(stackTraceElementArr, this.f4802a);
        return m5958a.length < stackTraceElementArr.length ? m5958a : stackTraceElementArr;
    }

    /* renamed from: a */
    public static StackTraceElement[] m5958a(StackTraceElement[] stackTraceElementArr, int i) {
        int i2;
        HashMap hashMap = new HashMap();
        StackTraceElement[] stackTraceElementArr2 = new StackTraceElement[stackTraceElementArr.length];
        int i3 = 0;
        int i4 = 0;
        int i5 = 1;
        while (i3 < stackTraceElementArr.length) {
            StackTraceElement stackTraceElement = stackTraceElementArr[i3];
            Integer num = (Integer) hashMap.get(stackTraceElement);
            if (num != null && m5957a(stackTraceElementArr, num.intValue(), i3)) {
                int intValue = i3 - num.intValue();
                if (i5 < i) {
                    System.arraycopy(stackTraceElementArr, i3, stackTraceElementArr2, i4, intValue);
                    i4 += intValue;
                    i5++;
                }
                i2 = (intValue - 1) + i3;
            } else {
                stackTraceElementArr2[i4] = stackTraceElementArr[i3];
                i4++;
                i2 = i3;
                i5 = 1;
            }
            hashMap.put(stackTraceElement, Integer.valueOf(i3));
            i3 = i2 + 1;
        }
        StackTraceElement[] stackTraceElementArr3 = new StackTraceElement[i4];
        System.arraycopy(stackTraceElementArr2, 0, stackTraceElementArr3, 0, stackTraceElementArr3.length);
        return stackTraceElementArr3;
    }

    /* renamed from: a */
    public static boolean m5957a(StackTraceElement[] stackTraceElementArr, int i, int i2) {
        int i3 = i2 - i;
        if (i2 + i3 > stackTraceElementArr.length) {
            return false;
        }
        for (int i4 = 0; i4 < i3; i4++) {
            if (!stackTraceElementArr[i + i4].equals(stackTraceElementArr[i2 + i4])) {
                return false;
            }
        }
        return true;
    }
}
