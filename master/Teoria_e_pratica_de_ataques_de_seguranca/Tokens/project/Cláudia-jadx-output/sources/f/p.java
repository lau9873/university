package f;

import java.util.Arrays;
/* compiled from: SegmentedByteString.java */
/* loaded from: classes.dex */
public final class p extends f {

    /* renamed from: f  reason: collision with root package name */
    public final transient byte[][] f6039f;

    /* renamed from: g  reason: collision with root package name */
    public final transient int[] f6040g;

    public p(c cVar, int i2) {
        super(null);
        t.a(cVar.f5999b, 0L, i2);
        int i3 = 0;
        n nVar = cVar.f5998a;
        int i4 = 0;
        int i5 = 0;
        while (i4 < i2) {
            int i6 = nVar.f6032c;
            int i7 = nVar.f6031b;
            if (i6 != i7) {
                i4 += i6 - i7;
                i5++;
                nVar = nVar.f6035f;
            } else {
                throw new AssertionError("s.limit == s.pos");
            }
        }
        this.f6039f = new byte[i5];
        this.f6040g = new int[i5 * 2];
        n nVar2 = cVar.f5998a;
        int i8 = 0;
        while (i3 < i2) {
            this.f6039f[i8] = nVar2.f6030a;
            i3 += nVar2.f6032c - nVar2.f6031b;
            if (i3 > i2) {
                i3 = i2;
            }
            int[] iArr = this.f6040g;
            iArr[i8] = i3;
            iArr[this.f6039f.length + i8] = nVar2.f6031b;
            nVar2.f6033d = true;
            i8++;
            nVar2 = nVar2.f6035f;
        }
    }

    @Override // f.f
    public f a(int i2, int i3) {
        return j().a(i2, i3);
    }

    @Override // f.f
    public String b() {
        return j().b();
    }

    @Override // f.f
    public String c() {
        return j().c();
    }

    @Override // f.f
    public f d() {
        return j().d();
    }

    @Override // f.f
    public f e() {
        return j().e();
    }

    @Override // f.f
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof f) {
            f fVar = (f) obj;
            if (fVar.f() == f() && a(0, fVar, 0, f())) {
                return true;
            }
        }
        return false;
    }

    @Override // f.f
    public int f() {
        return this.f6040g[this.f6039f.length - 1];
    }

    @Override // f.f
    public f g() {
        return j().g();
    }

    @Override // f.f
    public byte[] h() {
        int[] iArr = this.f6040g;
        byte[][] bArr = this.f6039f;
        byte[] bArr2 = new byte[iArr[bArr.length - 1]];
        int length = bArr.length;
        int i2 = 0;
        int i3 = 0;
        while (i2 < length) {
            int[] iArr2 = this.f6040g;
            int i4 = iArr2[length + i2];
            int i5 = iArr2[i2];
            System.arraycopy(this.f6039f[i2], i4, bArr2, i3, i5 - i3);
            i2++;
            i3 = i5;
        }
        return bArr2;
    }

    @Override // f.f
    public int hashCode() {
        int i2 = this.f6005b;
        if (i2 != 0) {
            return i2;
        }
        int length = this.f6039f.length;
        int i3 = 0;
        int i4 = 1;
        int i5 = 0;
        while (i3 < length) {
            byte[] bArr = this.f6039f[i3];
            int[] iArr = this.f6040g;
            int i6 = iArr[length + i3];
            int i7 = iArr[i3];
            int i8 = (i7 - i5) + i6;
            while (i6 < i8) {
                i4 = (i4 * 31) + bArr[i6];
                i6++;
            }
            i3++;
            i5 = i7;
        }
        this.f6005b = i4;
        return i4;
    }

    @Override // f.f
    public String i() {
        return j().i();
    }

    public final f j() {
        return new f(h());
    }

    @Override // f.f
    public String toString() {
        return j().toString();
    }

    @Override // f.f
    public byte a(int i2) {
        t.a(this.f6040g[this.f6039f.length - 1], i2, 1L);
        int b2 = b(i2);
        int i3 = b2 == 0 ? 0 : this.f6040g[b2 - 1];
        int[] iArr = this.f6040g;
        byte[][] bArr = this.f6039f;
        return bArr[b2][(i2 - i3) + iArr[bArr.length + b2]];
    }

    public final int b(int i2) {
        int binarySearch = Arrays.binarySearch(this.f6040g, 0, this.f6039f.length, i2 + 1);
        return binarySearch >= 0 ? binarySearch : ~binarySearch;
    }

    @Override // f.f
    public void a(c cVar) {
        int length = this.f6039f.length;
        int i2 = 0;
        int i3 = 0;
        while (i2 < length) {
            int[] iArr = this.f6040g;
            int i4 = iArr[length + i2];
            int i5 = iArr[i2];
            n nVar = new n(this.f6039f[i2], i4, (i4 + i5) - i3);
            n nVar2 = cVar.f5998a;
            if (nVar2 == null) {
                nVar.f6036g = nVar;
                nVar.f6035f = nVar;
                cVar.f5998a = nVar;
            } else {
                nVar2.f6036g.a(nVar);
            }
            i2++;
            i3 = i5;
        }
        cVar.f5999b += i3;
    }

    @Override // f.f
    public boolean a(int i2, f fVar, int i3, int i4) {
        if (i2 < 0 || i2 > f() - i4) {
            return false;
        }
        int b2 = b(i2);
        while (i4 > 0) {
            int i5 = b2 == 0 ? 0 : this.f6040g[b2 - 1];
            int min = Math.min(i4, ((this.f6040g[b2] - i5) + i5) - i2);
            int[] iArr = this.f6040g;
            byte[][] bArr = this.f6039f;
            if (!fVar.a(i3, bArr[b2], (i2 - i5) + iArr[bArr.length + b2], min)) {
                return false;
            }
            i2 += min;
            i3 += min;
            i4 -= min;
            b2++;
        }
        return true;
    }

    @Override // f.f
    public boolean a(int i2, byte[] bArr, int i3, int i4) {
        if (i2 < 0 || i2 > f() - i4 || i3 < 0 || i3 > bArr.length - i4) {
            return false;
        }
        int b2 = b(i2);
        while (i4 > 0) {
            int i5 = b2 == 0 ? 0 : this.f6040g[b2 - 1];
            int min = Math.min(i4, ((this.f6040g[b2] - i5) + i5) - i2);
            int[] iArr = this.f6040g;
            byte[][] bArr2 = this.f6039f;
            if (!t.a(bArr2[b2], (i2 - i5) + iArr[bArr2.length + b2], bArr, i3, min)) {
                return false;
            }
            i2 += min;
            i3 += min;
            i4 -= min;
            b2++;
        }
        return true;
    }
}
