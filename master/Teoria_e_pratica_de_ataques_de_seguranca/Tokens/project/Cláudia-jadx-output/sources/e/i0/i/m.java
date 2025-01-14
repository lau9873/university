package e.i0.i;

import java.util.Arrays;
/* compiled from: Settings.java */
/* loaded from: classes.dex */
public final class m {

    /* renamed from: a  reason: collision with root package name */
    public int f5815a;

    /* renamed from: b  reason: collision with root package name */
    public final int[] f5816b = new int[10];

    public void a() {
        this.f5815a = 0;
        Arrays.fill(this.f5816b, 0);
    }

    public int b() {
        if ((this.f5815a & 2) != 0) {
            return this.f5816b[1];
        }
        return -1;
    }

    public int c(int i2) {
        return (this.f5815a & 32) != 0 ? this.f5816b[5] : i2;
    }

    public boolean d(int i2) {
        return ((1 << i2) & this.f5815a) != 0;
    }

    public int b(int i2) {
        return (this.f5815a & 16) != 0 ? this.f5816b[4] : i2;
    }

    public int c() {
        if ((this.f5815a & 128) != 0) {
            return this.f5816b[7];
        }
        return 65535;
    }

    public int d() {
        return Integer.bitCount(this.f5815a);
    }

    public m a(int i2, int i3) {
        int[] iArr = this.f5816b;
        if (i2 >= iArr.length) {
            return this;
        }
        this.f5815a = (1 << i2) | this.f5815a;
        iArr[i2] = i3;
        return this;
    }

    public int a(int i2) {
        return this.f5816b[i2];
    }

    public void a(m mVar) {
        for (int i2 = 0; i2 < 10; i2++) {
            if (mVar.d(i2)) {
                a(i2, mVar.a(i2));
            }
        }
    }
}
