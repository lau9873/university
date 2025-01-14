package a.b.h.k;
/* compiled from: RtlSpacingHelper.java */
/* loaded from: classes.dex */
public class b1 {

    /* renamed from: a  reason: collision with root package name */
    public int f1662a = 0;

    /* renamed from: b  reason: collision with root package name */
    public int f1663b = 0;

    /* renamed from: c  reason: collision with root package name */
    public int f1664c = Integer.MIN_VALUE;

    /* renamed from: d  reason: collision with root package name */
    public int f1665d = Integer.MIN_VALUE;

    /* renamed from: e  reason: collision with root package name */
    public int f1666e = 0;

    /* renamed from: f  reason: collision with root package name */
    public int f1667f = 0;

    /* renamed from: g  reason: collision with root package name */
    public boolean f1668g = false;

    /* renamed from: h  reason: collision with root package name */
    public boolean f1669h = false;

    public int a() {
        return this.f1668g ? this.f1662a : this.f1663b;
    }

    public int b() {
        return this.f1662a;
    }

    public int c() {
        return this.f1663b;
    }

    public int d() {
        return this.f1668g ? this.f1663b : this.f1662a;
    }

    public void a(int i2, int i3) {
        this.f1669h = false;
        if (i2 != Integer.MIN_VALUE) {
            this.f1666e = i2;
            this.f1662a = i2;
        }
        if (i3 != Integer.MIN_VALUE) {
            this.f1667f = i3;
            this.f1663b = i3;
        }
    }

    public void b(int i2, int i3) {
        this.f1664c = i2;
        this.f1665d = i3;
        this.f1669h = true;
        if (this.f1668g) {
            if (i3 != Integer.MIN_VALUE) {
                this.f1662a = i3;
            }
            if (i2 != Integer.MIN_VALUE) {
                this.f1663b = i2;
                return;
            }
            return;
        }
        if (i2 != Integer.MIN_VALUE) {
            this.f1662a = i2;
        }
        if (i3 != Integer.MIN_VALUE) {
            this.f1663b = i3;
        }
    }

    public void a(boolean z) {
        if (z == this.f1668g) {
            return;
        }
        this.f1668g = z;
        if (!this.f1669h) {
            this.f1662a = this.f1666e;
            this.f1663b = this.f1667f;
        } else if (z) {
            int i2 = this.f1665d;
            if (i2 == Integer.MIN_VALUE) {
                i2 = this.f1666e;
            }
            this.f1662a = i2;
            int i3 = this.f1664c;
            if (i3 == Integer.MIN_VALUE) {
                i3 = this.f1667f;
            }
            this.f1663b = i3;
        } else {
            int i4 = this.f1664c;
            if (i4 == Integer.MIN_VALUE) {
                i4 = this.f1666e;
            }
            this.f1662a = i4;
            int i5 = this.f1665d;
            if (i5 == Integer.MIN_VALUE) {
                i5 = this.f1667f;
            }
            this.f1663b = i5;
        }
    }
}
