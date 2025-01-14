package p000a.p006b.p008b.p009h.p010j;

import java.util.ArrayList;
import p000a.p006b.p008b.p009h.LinearSystem;
import p000a.p006b.p008b.p009h.SolverVariable;
import p000a.p006b.p008b.p009h.p010j.ConstraintAnchor;
import p000a.p006b.p008b.p009h.p010j.ConstraintWidget;

/* renamed from: a.b.b.h.j.i */
/* loaded from: classes.dex */
public class Guideline extends ConstraintWidget {

    /* renamed from: k0 */
    public float f383k0 = -1.0f;

    /* renamed from: l0 */
    public int f384l0 = -1;

    /* renamed from: m0 */
    public int f385m0 = -1;

    /* renamed from: n0 */
    public ConstraintAnchor f386n0 = this.f337t;

    /* renamed from: o0 */
    public int f387o0 = 0;

    /* renamed from: p0 */
    public boolean f388p0 = false;

    /* compiled from: Guideline.java */
    /* renamed from: a.b.b.h.j.i$a */
    /* loaded from: classes.dex */
    public static /* synthetic */ class C0034a {

        /* renamed from: a */
        public static final /* synthetic */ int[] f389a = new int[ConstraintAnchor.EnumC0031d.values().length];

        static {
            try {
                f389a[ConstraintAnchor.EnumC0031d.LEFT.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f389a[ConstraintAnchor.EnumC0031d.RIGHT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f389a[ConstraintAnchor.EnumC0031d.TOP.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f389a[ConstraintAnchor.EnumC0031d.BOTTOM.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f389a[ConstraintAnchor.EnumC0031d.BASELINE.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f389a[ConstraintAnchor.EnumC0031d.CENTER.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f389a[ConstraintAnchor.EnumC0031d.CENTER_X.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                f389a[ConstraintAnchor.EnumC0031d.CENTER_Y.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                f389a[ConstraintAnchor.EnumC0031d.NONE.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
        }
    }

    public Guideline() {
        new Rectangle();
        this.f284B.clear();
        this.f284B.add(this.f386n0);
        int length = this.f283A.length;
        for (int i = 0; i < length; i++) {
            this.f283A[i] = this.f386n0;
        }
    }

    /* renamed from: K */
    public int m11023K() {
        return this.f387o0;
    }

    @Override // p000a.p006b.p008b.p009h.p010j.ConstraintWidget
    /* renamed from: a */
    public ConstraintAnchor mo11020a(ConstraintAnchor.EnumC0031d enumC0031d) {
        switch (C0034a.f389a[enumC0031d.ordinal()]) {
            case 1:
            case 2:
                if (this.f387o0 == 1) {
                    return this.f386n0;
                }
                break;
            case 3:
            case 4:
                if (this.f387o0 == 0) {
                    return this.f386n0;
                }
                break;
            case 5:
            case 6:
            case 7:
            case 8:
            case 9:
                return null;
        }
        throw new AssertionError(enumC0031d.name());
    }

    @Override // p000a.p006b.p008b.p009h.p010j.ConstraintWidget
    /* renamed from: b */
    public boolean mo11019b() {
        return true;
    }

    @Override // p000a.p006b.p008b.p009h.p010j.ConstraintWidget
    /* renamed from: c */
    public ArrayList<ConstraintAnchor> mo11018c() {
        return this.f284B;
    }

    /* renamed from: e */
    public void m11016e(float f) {
        if (f > -1.0f) {
            this.f383k0 = f;
            this.f384l0 = -1;
            this.f385m0 = -1;
        }
    }

    /* renamed from: u */
    public void m11015u(int i) {
        if (i > -1) {
            this.f383k0 = -1.0f;
            this.f384l0 = i;
            this.f385m0 = -1;
        }
    }

    /* renamed from: v */
    public void m11014v(int i) {
        if (i > -1) {
            this.f383k0 = -1.0f;
            this.f384l0 = -1;
            this.f385m0 = i;
        }
    }

    /* renamed from: w */
    public void m11013w(int i) {
        if (this.f387o0 == i) {
            return;
        }
        this.f387o0 = i;
        this.f284B.clear();
        if (this.f387o0 == 1) {
            this.f386n0 = this.f336s;
        } else {
            this.f386n0 = this.f337t;
        }
        this.f284B.add(this.f386n0);
        int length = this.f283A.length;
        for (int i2 = 0; i2 < length; i2++) {
            this.f283A[i2] = this.f386n0;
        }
    }

    @Override // p000a.p006b.p008b.p009h.p010j.ConstraintWidget
    /* renamed from: c */
    public void mo11017c(LinearSystem linearSystem) {
        if (m11073l() == null) {
            return;
        }
        int m11182b = linearSystem.m11182b(this.f386n0);
        if (this.f387o0 == 1) {
            m11058s(m11182b);
            m11056t(0);
            m11080h(m11073l().m11077j());
            m11064p(0);
            return;
        }
        m11058s(0);
        m11056t(m11182b);
        m11064p(m11073l().m11057t());
        m11080h(0);
    }

    @Override // p000a.p006b.p008b.p009h.p010j.ConstraintWidget
    /* renamed from: a */
    public void mo11022a(int i) {
        ConstraintWidget m11073l = m11073l();
        if (m11073l == null) {
            return;
        }
        if (m11023K() == 1) {
            this.f337t.m11132d().m11004a(1, m11073l.f337t.m11132d(), 0);
            this.f339v.m11132d().m11004a(1, m11073l.f337t.m11132d(), 0);
            if (this.f384l0 != -1) {
                this.f336s.m11132d().m11004a(1, m11073l.f336s.m11132d(), this.f384l0);
                this.f338u.m11132d().m11004a(1, m11073l.f336s.m11132d(), this.f384l0);
                return;
            } else if (this.f385m0 != -1) {
                this.f336s.m11132d().m11004a(1, m11073l.f338u.m11132d(), -this.f385m0);
                this.f338u.m11132d().m11004a(1, m11073l.f338u.m11132d(), -this.f385m0);
                return;
            } else if (this.f383k0 == -1.0f || m11073l.m11075k() != ConstraintWidget.EnumC0033b.FIXED) {
                return;
            } else {
                int i2 = (int) (m11073l.f287E * this.f383k0);
                this.f336s.m11132d().m11004a(1, m11073l.f336s.m11132d(), i2);
                this.f338u.m11132d().m11004a(1, m11073l.f336s.m11132d(), i2);
                return;
            }
        }
        this.f336s.m11132d().m11004a(1, m11073l.f336s.m11132d(), 0);
        this.f338u.m11132d().m11004a(1, m11073l.f336s.m11132d(), 0);
        if (this.f384l0 != -1) {
            this.f337t.m11132d().m11004a(1, m11073l.f337t.m11132d(), this.f384l0);
            this.f339v.m11132d().m11004a(1, m11073l.f337t.m11132d(), this.f384l0);
        } else if (this.f385m0 != -1) {
            this.f337t.m11132d().m11004a(1, m11073l.f339v.m11132d(), -this.f385m0);
            this.f339v.m11132d().m11004a(1, m11073l.f339v.m11132d(), -this.f385m0);
        } else if (this.f383k0 == -1.0f || m11073l.m11061r() != ConstraintWidget.EnumC0033b.FIXED) {
        } else {
            int i3 = (int) (m11073l.f288F * this.f383k0);
            this.f337t.m11132d().m11004a(1, m11073l.f337t.m11132d(), i3);
            this.f339v.m11132d().m11004a(1, m11073l.f337t.m11132d(), i3);
        }
    }

    @Override // p000a.p006b.p008b.p009h.p010j.ConstraintWidget
    /* renamed from: a */
    public void mo11021a(LinearSystem linearSystem) {
        ConstraintWidgetContainer constraintWidgetContainer = (ConstraintWidgetContainer) m11073l();
        if (constraintWidgetContainer == null) {
            return;
        }
        ConstraintAnchor mo11020a = constraintWidgetContainer.mo11020a(ConstraintAnchor.EnumC0031d.LEFT);
        ConstraintAnchor mo11020a2 = constraintWidgetContainer.mo11020a(ConstraintAnchor.EnumC0031d.RIGHT);
        ConstraintWidget constraintWidget = this.f286D;
        boolean z = constraintWidget != null && constraintWidget.f285C[0] == ConstraintWidget.EnumC0033b.WRAP_CONTENT;
        if (this.f387o0 == 0) {
            mo11020a = constraintWidgetContainer.mo11020a(ConstraintAnchor.EnumC0031d.TOP);
            mo11020a2 = constraintWidgetContainer.mo11020a(ConstraintAnchor.EnumC0031d.BOTTOM);
            ConstraintWidget constraintWidget2 = this.f286D;
            z = constraintWidget2 != null && constraintWidget2.f285C[1] == ConstraintWidget.EnumC0033b.WRAP_CONTENT;
        }
        if (this.f384l0 != -1) {
            SolverVariable m11188a = linearSystem.m11188a(this.f386n0);
            linearSystem.m11192a(m11188a, linearSystem.m11188a(mo11020a), this.f384l0, 6);
            if (z) {
                linearSystem.m11184b(linearSystem.m11188a(mo11020a2), m11188a, 0, 5);
            }
        } else if (this.f385m0 != -1) {
            SolverVariable m11188a2 = linearSystem.m11188a(this.f386n0);
            SolverVariable m11188a3 = linearSystem.m11188a(mo11020a2);
            linearSystem.m11192a(m11188a2, m11188a3, -this.f385m0, 6);
            if (z) {
                linearSystem.m11184b(m11188a2, linearSystem.m11188a(mo11020a), 0, 5);
                linearSystem.m11184b(m11188a3, m11188a2, 0, 5);
            }
        } else if (this.f383k0 != -1.0f) {
            linearSystem.m11200a(LinearSystem.m11196a(linearSystem, linearSystem.m11188a(this.f386n0), linearSystem.m11188a(mo11020a), linearSystem.m11188a(mo11020a2), this.f383k0, this.f388p0));
        }
    }
}
