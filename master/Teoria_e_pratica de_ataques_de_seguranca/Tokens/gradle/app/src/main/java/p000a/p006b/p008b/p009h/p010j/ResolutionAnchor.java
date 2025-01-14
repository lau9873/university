package p000a.p006b.p008b.p009h.p010j;

import p000a.p006b.p008b.p009h.LinearSystem;
import p000a.p006b.p008b.p009h.SolverVariable;
import p000a.p006b.p008b.p009h.p010j.ConstraintAnchor;

/* renamed from: a.b.b.h.j.m */
/* loaded from: classes.dex */
public class ResolutionAnchor extends ResolutionNode {

    /* renamed from: c */
    public ConstraintAnchor f393c;

    /* renamed from: d */
    public ResolutionAnchor f394d;

    /* renamed from: e */
    public float f395e;

    /* renamed from: f */
    public ResolutionAnchor f396f;

    /* renamed from: g */
    public float f397g;

    /* renamed from: i */
    public ResolutionAnchor f399i;

    /* renamed from: h */
    public int f398h = 0;

    /* renamed from: j */
    public ResolutionDimension f400j = null;

    /* renamed from: k */
    public int f401k = 1;

    /* renamed from: l */
    public ResolutionDimension f402l = null;

    /* renamed from: m */
    public int f403m = 1;

    public ResolutionAnchor(ConstraintAnchor constraintAnchor) {
        this.f393c = constraintAnchor;
    }

    /* renamed from: a */
    public String m11005a(int i) {
        return i == 1 ? "DIRECT" : i == 2 ? "CENTER" : i == 3 ? "MATCH" : i == 4 ? "CHAIN" : i == 5 ? "BARRIER" : "UNCONNECTED";
    }

    /* renamed from: a */
    public void m11002a(ResolutionAnchor resolutionAnchor, float f) {
        if (this.f406b == 0 || !(this.f396f == resolutionAnchor || this.f397g == f)) {
            this.f396f = resolutionAnchor;
            this.f397g = f;
            if (this.f406b == 1) {
                m10990b();
            }
            m10992a();
        }
    }

    /* renamed from: b */
    public void m10999b(int i) {
        this.f398h = i;
    }

    @Override // p000a.p006b.p008b.p009h.p010j.ResolutionNode
    /* renamed from: d */
    public void mo10988d() {
        super.mo10988d();
        this.f394d = null;
        this.f395e = 0.0f;
        this.f400j = null;
        this.f401k = 1;
        this.f402l = null;
        this.f403m = 1;
        this.f396f = null;
        this.f397g = 0.0f;
        this.f399i = null;
        this.f398h = 0;
    }

    @Override // p000a.p006b.p008b.p009h.p010j.ResolutionNode
    /* renamed from: e */
    public void mo10987e() {
        ResolutionAnchor resolutionAnchor;
        ResolutionAnchor resolutionAnchor2;
        ResolutionAnchor resolutionAnchor3;
        ResolutionAnchor resolutionAnchor4;
        ResolutionAnchor resolutionAnchor5;
        ResolutionAnchor resolutionAnchor6;
        float f;
        float f2;
        ConstraintAnchor constraintAnchor;
        float m11057t;
        float f3;
        ResolutionAnchor resolutionAnchor7;
        boolean z = true;
        if (this.f406b == 1 || this.f398h == 4) {
            return;
        }
        ResolutionDimension resolutionDimension = this.f400j;
        if (resolutionDimension != null) {
            if (resolutionDimension.f406b != 1) {
                return;
            }
            this.f395e = this.f401k * resolutionDimension.f404c;
        }
        ResolutionDimension resolutionDimension2 = this.f402l;
        if (resolutionDimension2 != null) {
            if (resolutionDimension2.f406b != 1) {
                return;
            }
            float f4 = resolutionDimension2.f404c;
        }
        if (this.f398h == 1 && ((resolutionAnchor7 = this.f394d) == null || resolutionAnchor7.f406b == 1)) {
            ResolutionAnchor resolutionAnchor8 = this.f394d;
            if (resolutionAnchor8 == null) {
                this.f396f = this;
                this.f397g = this.f395e;
            } else {
                this.f396f = resolutionAnchor8.f396f;
                this.f397g = resolutionAnchor8.f397g + this.f395e;
            }
            m10992a();
        } else if (this.f398h == 2 && (resolutionAnchor4 = this.f394d) != null && resolutionAnchor4.f406b == 1 && (resolutionAnchor5 = this.f399i) != null && (resolutionAnchor6 = resolutionAnchor5.f394d) != null && resolutionAnchor6.f406b == 1) {
            if (LinearSystem.m11171j() != null) {
                LinearSystem.m11171j().f211v++;
            }
            this.f396f = this.f394d.f396f;
            ResolutionAnchor resolutionAnchor9 = this.f399i;
            resolutionAnchor9.f396f = resolutionAnchor9.f394d.f396f;
            ConstraintAnchor.EnumC0031d enumC0031d = this.f393c.f257c;
            int i = 0;
            if (enumC0031d != ConstraintAnchor.EnumC0031d.RIGHT && enumC0031d != ConstraintAnchor.EnumC0031d.BOTTOM) {
                z = false;
            }
            if (z) {
                f = this.f394d.f397g;
                f2 = this.f399i.f394d.f397g;
            } else {
                f = this.f399i.f394d.f397g;
                f2 = this.f394d.f397g;
            }
            float f5 = f - f2;
            ConstraintAnchor.EnumC0031d enumC0031d2 = this.f393c.f257c;
            if (enumC0031d2 != ConstraintAnchor.EnumC0031d.LEFT && enumC0031d2 != ConstraintAnchor.EnumC0031d.RIGHT) {
                m11057t = f5 - constraintAnchor.f256b.m11077j();
                f3 = this.f393c.f256b.f305W;
            } else {
                m11057t = f5 - this.f393c.f256b.m11057t();
                f3 = this.f393c.f256b.f304V;
            }
            int m11134b = this.f393c.m11134b();
            int m11134b2 = this.f399i.f393c.m11134b();
            if (this.f393c.m11129g() == this.f399i.f393c.m11129g()) {
                f3 = 0.5f;
                m11134b2 = 0;
            } else {
                i = m11134b;
            }
            float f6 = i;
            float f7 = m11134b2;
            float f8 = (m11057t - f6) - f7;
            if (z) {
                ResolutionAnchor resolutionAnchor10 = this.f399i;
                resolutionAnchor10.f397g = resolutionAnchor10.f394d.f397g + f7 + (f8 * f3);
                this.f397g = (this.f394d.f397g - f6) - (f8 * (1.0f - f3));
            } else {
                this.f397g = this.f394d.f397g + f6 + (f8 * f3);
                ResolutionAnchor resolutionAnchor11 = this.f399i;
                resolutionAnchor11.f397g = (resolutionAnchor11.f394d.f397g - f7) - (f8 * (1.0f - f3));
            }
            m10992a();
            this.f399i.m10992a();
        } else if (this.f398h == 3 && (resolutionAnchor = this.f394d) != null && resolutionAnchor.f406b == 1 && (resolutionAnchor2 = this.f399i) != null && (resolutionAnchor3 = resolutionAnchor2.f394d) != null && resolutionAnchor3.f406b == 1) {
            if (LinearSystem.m11171j() != null) {
                LinearSystem.m11171j().f212w++;
            }
            ResolutionAnchor resolutionAnchor12 = this.f394d;
            this.f396f = resolutionAnchor12.f396f;
            ResolutionAnchor resolutionAnchor13 = this.f399i;
            ResolutionAnchor resolutionAnchor14 = resolutionAnchor13.f394d;
            resolutionAnchor13.f396f = resolutionAnchor14.f396f;
            this.f397g = resolutionAnchor12.f397g + this.f395e;
            resolutionAnchor13.f397g = resolutionAnchor14.f397g + resolutionAnchor13.f395e;
            m10992a();
            this.f399i.m10992a();
        } else if (this.f398h == 5) {
            this.f393c.f256b.mo11119H();
        }
    }

    /* renamed from: f */
    public float m10996f() {
        return this.f397g;
    }

    /* renamed from: g */
    public void m10995g() {
        ConstraintAnchor m11129g = this.f393c.m11129g();
        if (m11129g == null) {
            return;
        }
        if (m11129g.m11129g() == this.f393c) {
            this.f398h = 4;
            m11129g.m11132d().f398h = 4;
        }
        int m11134b = this.f393c.m11134b();
        ConstraintAnchor.EnumC0031d enumC0031d = this.f393c.f257c;
        if (enumC0031d == ConstraintAnchor.EnumC0031d.RIGHT || enumC0031d == ConstraintAnchor.EnumC0031d.BOTTOM) {
            m11134b = -m11134b;
        }
        m11001a(m11129g.m11132d(), m11134b);
    }

    public String toString() {
        if (this.f406b == 1) {
            if (this.f396f == this) {
                return "[" + this.f393c + ", RESOLVED: " + this.f397g + "]  type: " + m11005a(this.f398h);
            }
            return "[" + this.f393c + ", RESOLVED: " + this.f396f + ":" + this.f397g + "] type: " + m11005a(this.f398h);
        }
        return "{ " + this.f393c + " UNRESOLVED} type: " + m11005a(this.f398h);
    }

    /* renamed from: b */
    public void m10998b(ResolutionAnchor resolutionAnchor, float f) {
        this.f399i = resolutionAnchor;
    }

    /* renamed from: b */
    public void m10997b(ResolutionAnchor resolutionAnchor, int i, ResolutionDimension resolutionDimension) {
        this.f399i = resolutionAnchor;
        this.f402l = resolutionDimension;
        this.f403m = i;
    }

    /* renamed from: a */
    public void m11004a(int i, ResolutionAnchor resolutionAnchor, int i2) {
        this.f398h = i;
        this.f394d = resolutionAnchor;
        this.f395e = i2;
        this.f394d.m10991a(this);
    }

    /* renamed from: a */
    public void m11001a(ResolutionAnchor resolutionAnchor, int i) {
        this.f394d = resolutionAnchor;
        this.f395e = i;
        this.f394d.m10991a(this);
    }

    /* renamed from: a */
    public void m11000a(ResolutionAnchor resolutionAnchor, int i, ResolutionDimension resolutionDimension) {
        this.f394d = resolutionAnchor;
        this.f394d.m10991a(this);
        this.f400j = resolutionDimension;
        this.f401k = i;
        this.f400j.m10991a(this);
    }

    /* renamed from: a */
    public void m11003a(LinearSystem linearSystem) {
        SolverVariable m11131e = this.f393c.m11131e();
        ResolutionAnchor resolutionAnchor = this.f396f;
        if (resolutionAnchor == null) {
            linearSystem.m11194a(m11131e, (int) (this.f397g + 0.5f));
        } else {
            linearSystem.m11192a(m11131e, linearSystem.m11188a(resolutionAnchor.f393c), (int) (this.f397g + 0.5f), 6);
        }
    }
}
