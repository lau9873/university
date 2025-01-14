package a.b.b.h.j;

import a.b.b.h.j.e;
/* compiled from: ResolutionAnchor.java */
/* loaded from: classes.dex */
public class m extends o {

    /* renamed from: c  reason: collision with root package name */
    public e f190c;

    /* renamed from: d  reason: collision with root package name */
    public m f191d;

    /* renamed from: e  reason: collision with root package name */
    public float f192e;

    /* renamed from: f  reason: collision with root package name */
    public m f193f;

    /* renamed from: g  reason: collision with root package name */
    public float f194g;

    /* renamed from: i  reason: collision with root package name */
    public m f196i;

    /* renamed from: h  reason: collision with root package name */
    public int f195h = 0;
    public n j = null;
    public int k = 1;
    public n l = null;
    public int m = 1;

    public m(e eVar) {
        this.f190c = eVar;
    }

    public String a(int i2) {
        return i2 == 1 ? "DIRECT" : i2 == 2 ? "CENTER" : i2 == 3 ? "MATCH" : i2 == 4 ? "CHAIN" : i2 == 5 ? "BARRIER" : "UNCONNECTED";
    }

    public void a(m mVar, float f2) {
        if (this.f199b == 0 || !(this.f193f == mVar || this.f194g == f2)) {
            this.f193f = mVar;
            this.f194g = f2;
            if (this.f199b == 1) {
                b();
            }
            a();
        }
    }

    public void b(int i2) {
        this.f195h = i2;
    }

    @Override // a.b.b.h.j.o
    public void d() {
        super.d();
        this.f191d = null;
        this.f192e = 0.0f;
        this.j = null;
        this.k = 1;
        this.l = null;
        this.m = 1;
        this.f193f = null;
        this.f194g = 0.0f;
        this.f196i = null;
        this.f195h = 0;
    }

    @Override // a.b.b.h.j.o
    public void e() {
        m mVar;
        m mVar2;
        m mVar3;
        m mVar4;
        m mVar5;
        m mVar6;
        float f2;
        float f3;
        e eVar;
        float t;
        float f4;
        m mVar7;
        boolean z = true;
        if (this.f199b == 1 || this.f195h == 4) {
            return;
        }
        n nVar = this.j;
        if (nVar != null) {
            if (nVar.f199b != 1) {
                return;
            }
            this.f192e = this.k * nVar.f197c;
        }
        n nVar2 = this.l;
        if (nVar2 != null) {
            if (nVar2.f199b != 1) {
                return;
            }
            float f5 = nVar2.f197c;
        }
        if (this.f195h == 1 && ((mVar7 = this.f191d) == null || mVar7.f199b == 1)) {
            m mVar8 = this.f191d;
            if (mVar8 == null) {
                this.f193f = this;
                this.f194g = this.f192e;
            } else {
                this.f193f = mVar8.f193f;
                this.f194g = mVar8.f194g + this.f192e;
            }
            a();
        } else if (this.f195h == 2 && (mVar4 = this.f191d) != null && mVar4.f199b == 1 && (mVar5 = this.f196i) != null && (mVar6 = mVar5.f191d) != null && mVar6.f199b == 1) {
            if (a.b.b.h.e.j() != null) {
                a.b.b.h.e.j().v++;
            }
            this.f193f = this.f191d.f193f;
            m mVar9 = this.f196i;
            mVar9.f193f = mVar9.f191d.f193f;
            e.d dVar = this.f190c.f139c;
            int i2 = 0;
            if (dVar != e.d.RIGHT && dVar != e.d.BOTTOM) {
                z = false;
            }
            if (z) {
                f2 = this.f191d.f194g;
                f3 = this.f196i.f191d.f194g;
            } else {
                f2 = this.f196i.f191d.f194g;
                f3 = this.f191d.f194g;
            }
            float f6 = f2 - f3;
            e.d dVar2 = this.f190c.f139c;
            if (dVar2 != e.d.LEFT && dVar2 != e.d.RIGHT) {
                t = f6 - eVar.f138b.j();
                f4 = this.f190c.f138b.W;
            } else {
                t = f6 - this.f190c.f138b.t();
                f4 = this.f190c.f138b.V;
            }
            int b2 = this.f190c.b();
            int b3 = this.f196i.f190c.b();
            if (this.f190c.g() == this.f196i.f190c.g()) {
                f4 = 0.5f;
                b3 = 0;
            } else {
                i2 = b2;
            }
            float f7 = i2;
            float f8 = b3;
            float f9 = (t - f7) - f8;
            if (z) {
                m mVar10 = this.f196i;
                mVar10.f194g = mVar10.f191d.f194g + f8 + (f9 * f4);
                this.f194g = (this.f191d.f194g - f7) - (f9 * (1.0f - f4));
            } else {
                this.f194g = this.f191d.f194g + f7 + (f9 * f4);
                m mVar11 = this.f196i;
                mVar11.f194g = (mVar11.f191d.f194g - f8) - (f9 * (1.0f - f4));
            }
            a();
            this.f196i.a();
        } else if (this.f195h == 3 && (mVar = this.f191d) != null && mVar.f199b == 1 && (mVar2 = this.f196i) != null && (mVar3 = mVar2.f191d) != null && mVar3.f199b == 1) {
            if (a.b.b.h.e.j() != null) {
                a.b.b.h.e.j().w++;
            }
            m mVar12 = this.f191d;
            this.f193f = mVar12.f193f;
            m mVar13 = this.f196i;
            m mVar14 = mVar13.f191d;
            mVar13.f193f = mVar14.f193f;
            this.f194g = mVar12.f194g + this.f192e;
            mVar13.f194g = mVar14.f194g + mVar13.f192e;
            a();
            this.f196i.a();
        } else if (this.f195h == 5) {
            this.f190c.f138b.H();
        }
    }

    public float f() {
        return this.f194g;
    }

    public void g() {
        e g2 = this.f190c.g();
        if (g2 == null) {
            return;
        }
        if (g2.g() == this.f190c) {
            this.f195h = 4;
            g2.d().f195h = 4;
        }
        int b2 = this.f190c.b();
        e.d dVar = this.f190c.f139c;
        if (dVar == e.d.RIGHT || dVar == e.d.BOTTOM) {
            b2 = -b2;
        }
        a(g2.d(), b2);
    }

    public String toString() {
        if (this.f199b == 1) {
            if (this.f193f == this) {
                return "[" + this.f190c + ", RESOLVED: " + this.f194g + "]  type: " + a(this.f195h);
            }
            return "[" + this.f190c + ", RESOLVED: " + this.f193f + ":" + this.f194g + "] type: " + a(this.f195h);
        }
        return "{ " + this.f190c + " UNRESOLVED} type: " + a(this.f195h);
    }

    public void b(m mVar, float f2) {
        this.f196i = mVar;
    }

    public void b(m mVar, int i2, n nVar) {
        this.f196i = mVar;
        this.l = nVar;
        this.m = i2;
    }

    public void a(int i2, m mVar, int i3) {
        this.f195h = i2;
        this.f191d = mVar;
        this.f192e = i3;
        this.f191d.a(this);
    }

    public void a(m mVar, int i2) {
        this.f191d = mVar;
        this.f192e = i2;
        this.f191d.a(this);
    }

    public void a(m mVar, int i2, n nVar) {
        this.f191d = mVar;
        this.f191d.a(this);
        this.j = nVar;
        this.k = i2;
        this.j.a(this);
    }

    public void a(a.b.b.h.e eVar) {
        a.b.b.h.i e2 = this.f190c.e();
        m mVar = this.f193f;
        if (mVar == null) {
            eVar.a(e2, (int) (this.f194g + 0.5f));
        } else {
            eVar.a(e2, eVar.a(mVar.f190c), (int) (this.f194g + 0.5f), 6);
        }
    }
}
