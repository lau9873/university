package d.c.f0.j;
/* compiled from: Pow2.java */
/* loaded from: classes.dex */
public final class j {
    public static int a(int i2) {
        return 1 << (32 - Integer.numberOfLeadingZeros(i2 - 1));
    }
}
