package p192f;

/* renamed from: f.n */
/* loaded from: classes.dex */
public final class Segment {

    /* renamed from: a */
    public final byte[] f8482a;

    /* renamed from: b */
    public int f8483b;

    /* renamed from: c */
    public int f8484c;

    /* renamed from: d */
    public boolean f8485d;

    /* renamed from: e */
    public boolean f8486e;

    /* renamed from: f */
    public Segment f8487f;

    /* renamed from: g */
    public Segment f8488g;

    public Segment() {
        this.f8482a = new byte[8192];
        this.f8486e = true;
        this.f8485d = false;
    }

    /* renamed from: a */
    public Segment m2550a(Segment segment) {
        segment.f8488g = this;
        segment.f8487f = this.f8487f;
        this.f8487f.f8488g = segment;
        this.f8487f = segment;
        return segment;
    }

    /* renamed from: b */
    public Segment m2548b() {
        Segment segment = this.f8487f;
        if (segment == this) {
            segment = null;
        }
        Segment segment2 = this.f8488g;
        segment2.f8487f = this.f8487f;
        this.f8487f.f8488g = segment2;
        this.f8487f = null;
        this.f8488g = null;
        return segment;
    }

    public Segment(Segment segment) {
        this(segment.f8482a, segment.f8483b, segment.f8484c);
        segment.f8485d = true;
    }

    /* renamed from: a */
    public Segment m2551a(int i) {
        Segment m2547a;
        if (i > 0 && i <= this.f8484c - this.f8483b) {
            if (i >= 1024) {
                m2547a = new Segment(this);
            } else {
                m2547a = SegmentPool.m2547a();
                System.arraycopy(this.f8482a, this.f8483b, m2547a.f8482a, 0, i);
            }
            m2547a.f8484c = m2547a.f8483b + i;
            this.f8483b += i;
            this.f8488g.m2550a(m2547a);
            return m2547a;
        }
        throw new IllegalArgumentException();
    }

    public Segment(byte[] bArr, int i, int i2) {
        this.f8482a = bArr;
        this.f8483b = i;
        this.f8484c = i2;
        this.f8486e = false;
        this.f8485d = true;
    }

    /* renamed from: a */
    public void m2552a() {
        Segment segment = this.f8488g;
        if (segment != this) {
            if (segment.f8486e) {
                int i = this.f8484c - this.f8483b;
                if (i > (8192 - segment.f8484c) + (segment.f8485d ? 0 : segment.f8483b)) {
                    return;
                }
                m2549a(this.f8488g, i);
                m2548b();
                SegmentPool.m2546a(this);
                return;
            }
            return;
        }
        throw new IllegalStateException();
    }

    /* renamed from: a */
    public void m2549a(Segment segment, int i) {
        if (segment.f8486e) {
            int i2 = segment.f8484c;
            if (i2 + i > 8192) {
                if (!segment.f8485d) {
                    int i3 = segment.f8483b;
                    if ((i2 + i) - i3 <= 8192) {
                        byte[] bArr = segment.f8482a;
                        System.arraycopy(bArr, i3, bArr, 0, i2 - i3);
                        segment.f8484c -= segment.f8483b;
                        segment.f8483b = 0;
                    } else {
                        throw new IllegalArgumentException();
                    }
                } else {
                    throw new IllegalArgumentException();
                }
            }
            System.arraycopy(this.f8482a, this.f8483b, segment.f8482a, segment.f8484c, i);
            segment.f8484c += i;
            this.f8483b += i;
            return;
        }
        throw new IllegalArgumentException();
    }
}
