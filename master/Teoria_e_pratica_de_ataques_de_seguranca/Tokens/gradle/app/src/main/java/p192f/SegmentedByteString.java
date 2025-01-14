package p192f;

import java.util.Arrays;

/* renamed from: f.p */
/* loaded from: classes.dex */
public final class SegmentedByteString extends C1822f {

    /* renamed from: f */
    public final transient byte[][] f8491f;

    /* renamed from: g */
    public final transient int[] f8492g;

    public SegmentedByteString(Buffer buffer, int i) {
        super(null);
        C1828t.m2518a(buffer.f8450b, 0L, i);
        int i2 = 0;
        Segment segment = buffer.f8449a;
        int i3 = 0;
        int i4 = 0;
        while (i3 < i) {
            int i5 = segment.f8484c;
            int i6 = segment.f8483b;
            if (i5 != i6) {
                i3 += i5 - i6;
                i4++;
                segment = segment.f8487f;
            } else {
                throw new AssertionError("s.limit == s.pos");
            }
        }
        this.f8491f = new byte[i4];
        this.f8492g = new int[i4 * 2];
        Segment segment2 = buffer.f8449a;
        int i7 = 0;
        while (i2 < i) {
            this.f8491f[i7] = segment2.f8482a;
            i2 += segment2.f8484c - segment2.f8483b;
            if (i2 > i) {
                i2 = i;
            }
            int[] iArr = this.f8492g;
            iArr[i7] = i2;
            iArr[this.f8491f.length + i7] = segment2.f8483b;
            segment2.f8485d = true;
            i7++;
            segment2 = segment2.f8487f;
        }
    }

    @Override // p192f.C1822f
    /* renamed from: a */
    public C1822f mo2544a(int i, int i2) {
        return m2531j().mo2544a(i, i2);
    }

    @Override // p192f.C1822f
    /* renamed from: b */
    public String mo2540b() {
        return m2531j().mo2540b();
    }

    @Override // p192f.C1822f
    /* renamed from: c */
    public String mo2538c() {
        return m2531j().mo2538c();
    }

    @Override // p192f.C1822f
    /* renamed from: d */
    public C1822f mo2537d() {
        return m2531j().mo2537d();
    }

    @Override // p192f.C1822f
    /* renamed from: e */
    public C1822f mo2536e() {
        return m2531j().mo2536e();
    }

    @Override // p192f.C1822f
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof C1822f) {
            C1822f c1822f = (C1822f) obj;
            if (c1822f.mo2535f() == mo2535f() && mo2543a(0, c1822f, 0, mo2535f())) {
                return true;
            }
        }
        return false;
    }

    @Override // p192f.C1822f
    /* renamed from: f */
    public int mo2535f() {
        return this.f8492g[this.f8491f.length - 1];
    }

    @Override // p192f.C1822f
    /* renamed from: g */
    public C1822f mo2534g() {
        return m2531j().mo2534g();
    }

    @Override // p192f.C1822f
    /* renamed from: h */
    public byte[] mo2533h() {
        int[] iArr = this.f8492g;
        byte[][] bArr = this.f8491f;
        byte[] bArr2 = new byte[iArr[bArr.length - 1]];
        int length = bArr.length;
        int i = 0;
        int i2 = 0;
        while (i < length) {
            int[] iArr2 = this.f8492g;
            int i3 = iArr2[length + i];
            int i4 = iArr2[i];
            System.arraycopy(this.f8491f[i], i3, bArr2, i2, i4 - i2);
            i++;
            i2 = i4;
        }
        return bArr2;
    }

    @Override // p192f.C1822f
    public int hashCode() {
        int i = this.f8456b;
        if (i != 0) {
            return i;
        }
        int length = this.f8491f.length;
        int i2 = 0;
        int i3 = 1;
        int i4 = 0;
        while (i2 < length) {
            byte[] bArr = this.f8491f[i2];
            int[] iArr = this.f8492g;
            int i5 = iArr[length + i2];
            int i6 = iArr[i2];
            int i7 = (i6 - i4) + i5;
            while (i5 < i7) {
                i3 = (i3 * 31) + bArr[i5];
                i5++;
            }
            i2++;
            i4 = i6;
        }
        this.f8456b = i3;
        return i3;
    }

    @Override // p192f.C1822f
    /* renamed from: i */
    public String mo2532i() {
        return m2531j().mo2532i();
    }

    /* renamed from: j */
    public final C1822f m2531j() {
        return new C1822f(mo2533h());
    }

    @Override // p192f.C1822f
    public String toString() {
        return m2531j().toString();
    }

    @Override // p192f.C1822f
    /* renamed from: a */
    public byte mo2545a(int i) {
        C1828t.m2518a(this.f8492g[this.f8491f.length - 1], i, 1L);
        int m2539b = m2539b(i);
        int i2 = m2539b == 0 ? 0 : this.f8492g[m2539b - 1];
        int[] iArr = this.f8492g;
        byte[][] bArr = this.f8491f;
        return bArr[m2539b][(i - i2) + iArr[bArr.length + m2539b]];
    }

    /* renamed from: b */
    public final int m2539b(int i) {
        int binarySearch = Arrays.binarySearch(this.f8492g, 0, this.f8491f.length, i + 1);
        return binarySearch >= 0 ? binarySearch : ~binarySearch;
    }

    @Override // p192f.C1822f
    /* renamed from: a */
    public void mo2541a(Buffer buffer) {
        int length = this.f8491f.length;
        int i = 0;
        int i2 = 0;
        while (i < length) {
            int[] iArr = this.f8492g;
            int i3 = iArr[length + i];
            int i4 = iArr[i];
            Segment segment = new Segment(this.f8491f[i], i3, (i3 + i4) - i2);
            Segment segment2 = buffer.f8449a;
            if (segment2 == null) {
                segment.f8488g = segment;
                segment.f8487f = segment;
                buffer.f8449a = segment;
            } else {
                segment2.f8488g.m2550a(segment);
            }
            i++;
            i2 = i4;
        }
        buffer.f8450b += i2;
    }

    @Override // p192f.C1822f
    /* renamed from: a */
    public boolean mo2543a(int i, C1822f c1822f, int i2, int i3) {
        if (i < 0 || i > mo2535f() - i3) {
            return false;
        }
        int m2539b = m2539b(i);
        while (i3 > 0) {
            int i4 = m2539b == 0 ? 0 : this.f8492g[m2539b - 1];
            int min = Math.min(i3, ((this.f8492g[m2539b] - i4) + i4) - i);
            int[] iArr = this.f8492g;
            byte[][] bArr = this.f8491f;
            if (!c1822f.mo2542a(i2, bArr[m2539b], (i - i4) + iArr[bArr.length + m2539b], min)) {
                return false;
            }
            i += min;
            i2 += min;
            i3 -= min;
            m2539b++;
        }
        return true;
    }

    @Override // p192f.C1822f
    /* renamed from: a */
    public boolean mo2542a(int i, byte[] bArr, int i2, int i3) {
        if (i < 0 || i > mo2535f() - i3 || i2 < 0 || i2 > bArr.length - i3) {
            return false;
        }
        int m2539b = m2539b(i);
        while (i3 > 0) {
            int i4 = m2539b == 0 ? 0 : this.f8492g[m2539b - 1];
            int min = Math.min(i3, ((this.f8492g[m2539b] - i4) + i4) - i);
            int[] iArr = this.f8492g;
            byte[][] bArr2 = this.f8491f;
            if (!C1828t.m2515a(bArr2[m2539b], (i - i4) + iArr[bArr2.length + m2539b], bArr, i2, min)) {
                return false;
            }
            i += min;
            i2 += min;
            i3 -= min;
            m2539b++;
        }
        return true;
    }
}
