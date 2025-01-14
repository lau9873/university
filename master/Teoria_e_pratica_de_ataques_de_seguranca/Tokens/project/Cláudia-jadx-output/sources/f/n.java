package f;
/* compiled from: Segment.java */
/* loaded from: classes.dex */
public final class n {

    /* renamed from: a  reason: collision with root package name */
    public final byte[] f6030a;

    /* renamed from: b  reason: collision with root package name */
    public int f6031b;

    /* renamed from: c  reason: collision with root package name */
    public int f6032c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f6033d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f6034e;

    /* renamed from: f  reason: collision with root package name */
    public n f6035f;

    /* renamed from: g  reason: collision with root package name */
    public n f6036g;

    public n() {
        this.f6030a = new byte[8192];
        this.f6034e = true;
        this.f6033d = false;
    }

    public n a(n nVar) {
        nVar.f6036g = this;
        nVar.f6035f = this.f6035f;
        this.f6035f.f6036g = nVar;
        this.f6035f = nVar;
        return nVar;
    }

    public n b() {
        n nVar = this.f6035f;
        if (nVar == this) {
            nVar = null;
        }
        n nVar2 = this.f6036g;
        nVar2.f6035f = this.f6035f;
        this.f6035f.f6036g = nVar2;
        this.f6035f = null;
        this.f6036g = null;
        return nVar;
    }

    public n(n nVar) {
        this(nVar.f6030a, nVar.f6031b, nVar.f6032c);
        nVar.f6033d = true;
    }

    public n a(int i2) {
        n a2;
        if (i2 > 0 && i2 <= this.f6032c - this.f6031b) {
            if (i2 >= 1024) {
                a2 = new n(this);
            } else {
                a2 = o.a();
                System.arraycopy(this.f6030a, this.f6031b, a2.f6030a, 0, i2);
            }
            a2.f6032c = a2.f6031b + i2;
            this.f6031b += i2;
            this.f6036g.a(a2);
            return a2;
        }
        throw new IllegalArgumentException();
    }

    public n(byte[] bArr, int i2, int i3) {
        this.f6030a = bArr;
        this.f6031b = i2;
        this.f6032c = i3;
        this.f6034e = false;
        this.f6033d = true;
    }

    public void a() {
        n nVar = this.f6036g;
        if (nVar != this) {
            if (nVar.f6034e) {
                int i2 = this.f6032c - this.f6031b;
                if (i2 > (8192 - nVar.f6032c) + (nVar.f6033d ? 0 : nVar.f6031b)) {
                    return;
                }
                a(this.f6036g, i2);
                b();
                o.a(this);
                return;
            }
            return;
        }
        throw new IllegalStateException();
    }

    public void a(n nVar, int i2) {
        if (nVar.f6034e) {
            int i3 = nVar.f6032c;
            if (i3 + i2 > 8192) {
                if (!nVar.f6033d) {
                    int i4 = nVar.f6031b;
                    if ((i3 + i2) - i4 <= 8192) {
                        byte[] bArr = nVar.f6030a;
                        System.arraycopy(bArr, i4, bArr, 0, i3 - i4);
                        nVar.f6032c -= nVar.f6031b;
                        nVar.f6031b = 0;
                    } else {
                        throw new IllegalArgumentException();
                    }
                } else {
                    throw new IllegalArgumentException();
                }
            }
            System.arraycopy(this.f6030a, this.f6031b, nVar.f6030a, nVar.f6032c, i2);
            nVar.f6032c += i2;
            this.f6031b += i2;
            return;
        }
        throw new IllegalArgumentException();
    }
}
