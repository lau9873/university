package p000a.p006b.p030g.p032b.p033g;

import java.lang.reflect.Array;

/* renamed from: a.b.g.b.g.e */
/* loaded from: classes.dex */
public final class GrowingArrayUtils {
    /* renamed from: a */
    public static int m9955a(int i) {
        if (i <= 4) {
            return 8;
        }
        return i * 2;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v4, types: [java.lang.Object[], java.lang.Object] */
    /* renamed from: a */
    public static <T> T[] m9953a(T[] tArr, int i, T t) {
        if (i + 1 > tArr.length) {
            ?? r0 = (Object[]) Array.newInstance(tArr.getClass().getComponentType(), m9955a(i));
            System.arraycopy(tArr, 0, r0, 0, i);
            tArr = r0;
        }
        tArr[i] = t;
        return tArr;
    }

    /* renamed from: a */
    public static int[] m9954a(int[] iArr, int i, int i2) {
        if (i + 1 > iArr.length) {
            int[] iArr2 = new int[m9955a(i)];
            System.arraycopy(iArr, 0, iArr2, 0, i);
            iArr = iArr2;
        }
        iArr[i] = i2;
        return iArr;
    }
}
