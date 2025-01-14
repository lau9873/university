package p181e.p182i0.p187i;

import com.j256.ormlite.logger.Logger;
import java.util.Arrays;

/* compiled from: Settings.java */
/* renamed from: e.i0.i.m */
/* loaded from: classes.dex */
public final class C1791m {

    /* renamed from: a */
    public int f8223a;

    /* renamed from: b */
    public final int[] f8224b = new int[10];

    /* renamed from: a */
    public void m2885a() {
        this.f8223a = 0;
        Arrays.fill(this.f8224b, 0);
    }

    /* renamed from: b */
    public int m2881b() {
        if ((this.f8223a & 2) != 0) {
            return this.f8224b[1];
        }
        return -1;
    }

    /* renamed from: c */
    public int m2878c(int i) {
        return (this.f8223a & 32) != 0 ? this.f8224b[5] : i;
    }

    /* renamed from: d */
    public boolean m2876d(int i) {
        return ((1 << i) & this.f8223a) != 0;
    }

    /* renamed from: b */
    public int m2880b(int i) {
        return (this.f8223a & 16) != 0 ? this.f8224b[4] : i;
    }

    /* renamed from: c */
    public int m2879c() {
        if ((this.f8223a & Logger.DEFAULT_FULL_MESSAGE_LENGTH) != 0) {
            return this.f8224b[7];
        }
        return 65535;
    }

    /* renamed from: d */
    public int m2877d() {
        return Integer.bitCount(this.f8223a);
    }

    /* renamed from: a */
    public C1791m m2883a(int i, int i2) {
        int[] iArr = this.f8224b;
        if (i >= iArr.length) {
            return this;
        }
        this.f8223a = (1 << i) | this.f8223a;
        iArr[i] = i2;
        return this;
    }

    /* renamed from: a */
    public int m2884a(int i) {
        return this.f8224b[i];
    }

    /* renamed from: a */
    public void m2882a(C1791m c1791m) {
        for (int i = 0; i < 10; i++) {
            if (c1791m.m2876d(i)) {
                m2883a(i, c1791m.m2884a(i));
            }
        }
    }
}
