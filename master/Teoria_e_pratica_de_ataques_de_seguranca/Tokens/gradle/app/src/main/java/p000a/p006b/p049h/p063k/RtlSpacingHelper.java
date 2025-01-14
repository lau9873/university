package p000a.p006b.p049h.p063k;

/* renamed from: a.b.h.k.b1 */
/* loaded from: classes.dex */
public class RtlSpacingHelper {

    /* renamed from: a */
    public int f2535a = 0;

    /* renamed from: b */
    public int f2536b = 0;

    /* renamed from: c */
    public int f2537c = Integer.MIN_VALUE;

    /* renamed from: d */
    public int f2538d = Integer.MIN_VALUE;

    /* renamed from: e */
    public int f2539e = 0;

    /* renamed from: f */
    public int f2540f = 0;

    /* renamed from: g */
    public boolean f2541g = false;

    /* renamed from: h */
    public boolean f2542h = false;

    /* renamed from: a */
    public int m8515a() {
        return this.f2541g ? this.f2535a : this.f2536b;
    }

    /* renamed from: b */
    public int m8512b() {
        return this.f2535a;
    }

    /* renamed from: c */
    public int m8510c() {
        return this.f2536b;
    }

    /* renamed from: d */
    public int m8509d() {
        return this.f2541g ? this.f2536b : this.f2535a;
    }

    /* renamed from: a */
    public void m8514a(int i, int i2) {
        this.f2542h = false;
        if (i != Integer.MIN_VALUE) {
            this.f2539e = i;
            this.f2535a = i;
        }
        if (i2 != Integer.MIN_VALUE) {
            this.f2540f = i2;
            this.f2536b = i2;
        }
    }

    /* renamed from: b */
    public void m8511b(int i, int i2) {
        this.f2537c = i;
        this.f2538d = i2;
        this.f2542h = true;
        if (this.f2541g) {
            if (i2 != Integer.MIN_VALUE) {
                this.f2535a = i2;
            }
            if (i != Integer.MIN_VALUE) {
                this.f2536b = i;
                return;
            }
            return;
        }
        if (i != Integer.MIN_VALUE) {
            this.f2535a = i;
        }
        if (i2 != Integer.MIN_VALUE) {
            this.f2536b = i2;
        }
    }

    /* renamed from: a */
    public void m8513a(boolean z) {
        if (z == this.f2541g) {
            return;
        }
        this.f2541g = z;
        if (!this.f2542h) {
            this.f2535a = this.f2539e;
            this.f2536b = this.f2540f;
        } else if (z) {
            int i = this.f2538d;
            if (i == Integer.MIN_VALUE) {
                i = this.f2539e;
            }
            this.f2535a = i;
            int i2 = this.f2537c;
            if (i2 == Integer.MIN_VALUE) {
                i2 = this.f2540f;
            }
            this.f2536b = i2;
        } else {
            int i3 = this.f2537c;
            if (i3 == Integer.MIN_VALUE) {
                i3 = this.f2539e;
            }
            this.f2535a = i3;
            int i4 = this.f2538d;
            if (i4 == Integer.MIN_VALUE) {
                i4 = this.f2540f;
            }
            this.f2536b = i4;
        }
    }
}
