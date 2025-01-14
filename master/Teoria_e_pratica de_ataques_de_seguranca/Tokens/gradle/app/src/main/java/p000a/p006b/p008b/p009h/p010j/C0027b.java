package p000a.p006b.p008b.p009h.p010j;

import java.util.ArrayList;
import p000a.p006b.p008b.p009h.LinearSystem;
import p000a.p006b.p008b.p009h.SolverVariable;
import p000a.p006b.p008b.p009h.p010j.ConstraintWidget;

/* compiled from: Barrier.java */
/* renamed from: a.b.b.h.j.b */
/* loaded from: classes.dex */
public class C0027b extends Helper {

    /* renamed from: m0 */
    public int f235m0 = 0;

    /* renamed from: n0 */
    public ArrayList<ResolutionAnchor> f236n0 = new ArrayList<>(4);

    /* renamed from: o0 */
    public boolean f237o0 = true;

    @Override // p000a.p006b.p008b.p009h.p010j.ConstraintWidget
    /* renamed from: G */
    public void mo11120G() {
        super.mo11120G();
        this.f236n0.clear();
    }

    @Override // p000a.p006b.p008b.p009h.p010j.ConstraintWidget
    /* renamed from: H */
    public void mo11119H() {
        ResolutionAnchor m11132d;
        float f;
        ResolutionAnchor resolutionAnchor;
        int i = this.f235m0;
        float f2 = Float.MAX_VALUE;
        if (i != 0) {
            if (i == 1) {
                m11132d = this.f338u.m11132d();
            } else if (i == 2) {
                m11132d = this.f337t.m11132d();
            } else if (i != 3) {
                return;
            } else {
                m11132d = this.f339v.m11132d();
            }
            f2 = 0.0f;
        } else {
            m11132d = this.f336s.m11132d();
        }
        int size = this.f236n0.size();
        ResolutionAnchor resolutionAnchor2 = null;
        for (int i2 = 0; i2 < size; i2++) {
            ResolutionAnchor resolutionAnchor3 = this.f236n0.get(i2);
            if (resolutionAnchor3.f406b != 1) {
                return;
            }
            int i3 = this.f235m0;
            if (i3 != 0 && i3 != 2) {
                f = resolutionAnchor3.f397g;
                if (f > f2) {
                    resolutionAnchor = resolutionAnchor3.f396f;
                    resolutionAnchor2 = resolutionAnchor;
                    f2 = f;
                }
            } else {
                f = resolutionAnchor3.f397g;
                if (f < f2) {
                    resolutionAnchor = resolutionAnchor3.f396f;
                    resolutionAnchor2 = resolutionAnchor;
                    f2 = f;
                }
            }
        }
        if (LinearSystem.m11171j() != null) {
            LinearSystem.m11171j().f214y++;
        }
        m11132d.f396f = resolutionAnchor2;
        m11132d.f397g = f2;
        m11132d.m10992a();
        int i4 = this.f235m0;
        if (i4 == 0) {
            this.f338u.m11132d().m11002a(resolutionAnchor2, f2);
        } else if (i4 == 1) {
            this.f336s.m11132d().m11002a(resolutionAnchor2, f2);
        } else if (i4 == 2) {
            this.f339v.m11132d().m11002a(resolutionAnchor2, f2);
        } else if (i4 == 3) {
            this.f337t.m11132d().m11002a(resolutionAnchor2, f2);
        }
    }

    @Override // p000a.p006b.p008b.p009h.p010j.ConstraintWidget
    /* renamed from: a */
    public void mo11022a(int i) {
        ResolutionAnchor m11132d;
        ResolutionAnchor m11132d2;
        ConstraintWidget constraintWidget = this.f286D;
        if (constraintWidget != null && ((ConstraintWidgetContainer) constraintWidget).m11032u(2)) {
            int i2 = this.f235m0;
            if (i2 == 0) {
                m11132d = this.f336s.m11132d();
            } else if (i2 == 1) {
                m11132d = this.f338u.m11132d();
            } else if (i2 == 2) {
                m11132d = this.f337t.m11132d();
            } else if (i2 != 3) {
                return;
            } else {
                m11132d = this.f339v.m11132d();
            }
            m11132d.m10999b(5);
            int i3 = this.f235m0;
            if (i3 != 0 && i3 != 1) {
                this.f336s.m11132d().m11002a((ResolutionAnchor) null, 0.0f);
                this.f338u.m11132d().m11002a((ResolutionAnchor) null, 0.0f);
            } else {
                this.f337t.m11132d().m11002a((ResolutionAnchor) null, 0.0f);
                this.f339v.m11132d().m11002a((ResolutionAnchor) null, 0.0f);
            }
            this.f236n0.clear();
            for (int i4 = 0; i4 < this.f391l0; i4++) {
                ConstraintWidget constraintWidget2 = this.f390k0[i4];
                if (this.f237o0 || constraintWidget2.mo11019b()) {
                    int i5 = this.f235m0;
                    if (i5 == 0) {
                        m11132d2 = constraintWidget2.f336s.m11132d();
                    } else if (i5 == 1) {
                        m11132d2 = constraintWidget2.f338u.m11132d();
                    } else if (i5 != 2) {
                        m11132d2 = i5 != 3 ? null : constraintWidget2.f339v.m11132d();
                    } else {
                        m11132d2 = constraintWidget2.f337t.m11132d();
                    }
                    if (m11132d2 != null) {
                        this.f236n0.add(m11132d2);
                        m11132d2.m10991a(m11132d);
                    }
                }
            }
        }
    }

    @Override // p000a.p006b.p008b.p009h.p010j.ConstraintWidget
    /* renamed from: b */
    public boolean mo11019b() {
        return true;
    }

    /* renamed from: c */
    public void m11146c(boolean z) {
        this.f237o0 = z;
    }

    /* renamed from: u */
    public void m11145u(int i) {
        this.f235m0 = i;
    }

    @Override // p000a.p006b.p008b.p009h.p010j.ConstraintWidget
    /* renamed from: a */
    public void mo11021a(LinearSystem linearSystem) {
        Object[] objArr;
        boolean z;
        int i;
        int i2;
        ConstraintAnchor[] constraintAnchorArr = this.f283A;
        constraintAnchorArr[0] = this.f336s;
        constraintAnchorArr[2] = this.f337t;
        constraintAnchorArr[1] = this.f338u;
        constraintAnchorArr[3] = this.f339v;
        int i3 = 0;
        while (true) {
            objArr = this.f283A;
            if (i3 >= objArr.length) {
                break;
            }
            objArr[i3].f263i = linearSystem.m11188a(objArr[i3]);
            i3++;
        }
        int i4 = this.f235m0;
        if (i4 < 0 || i4 >= 4) {
            return;
        }
        ConstraintAnchor constraintAnchor = objArr[i4];
        for (int i5 = 0; i5 < this.f391l0; i5++) {
            ConstraintWidget constraintWidget = this.f390k0[i5];
            if ((this.f237o0 || constraintWidget.mo11019b()) && ((((i = this.f235m0) == 0 || i == 1) && constraintWidget.m11075k() == ConstraintWidget.EnumC0033b.MATCH_CONSTRAINT) || (((i2 = this.f235m0) == 2 || i2 == 3) && constraintWidget.m11061r() == ConstraintWidget.EnumC0033b.MATCH_CONSTRAINT))) {
                z = true;
                break;
            }
        }
        z = false;
        int i6 = this.f235m0;
        if (i6 == 0 || i6 == 1 ? m11073l().m11075k() == ConstraintWidget.EnumC0033b.WRAP_CONTENT : m11073l().m11061r() == ConstraintWidget.EnumC0033b.WRAP_CONTENT) {
            z = false;
        }
        for (int i7 = 0; i7 < this.f391l0; i7++) {
            ConstraintWidget constraintWidget2 = this.f390k0[i7];
            if (this.f237o0 || constraintWidget2.mo11019b()) {
                SolverVariable m11188a = linearSystem.m11188a(constraintWidget2.f283A[this.f235m0]);
                ConstraintAnchor[] constraintAnchorArr2 = constraintWidget2.f283A;
                int i8 = this.f235m0;
                constraintAnchorArr2[i8].f263i = m11188a;
                if (i8 != 0 && i8 != 2) {
                    linearSystem.m11190a(constraintAnchor.f263i, m11188a, z);
                } else {
                    linearSystem.m11183b(constraintAnchor.f263i, m11188a, z);
                }
            }
        }
        int i9 = this.f235m0;
        if (i9 == 0) {
            linearSystem.m11192a(this.f338u.f263i, this.f336s.f263i, 0, 6);
            if (z) {
                return;
            }
            linearSystem.m11192a(this.f336s.f263i, this.f286D.f338u.f263i, 0, 5);
        } else if (i9 == 1) {
            linearSystem.m11192a(this.f336s.f263i, this.f338u.f263i, 0, 6);
            if (z) {
                return;
            }
            linearSystem.m11192a(this.f336s.f263i, this.f286D.f336s.f263i, 0, 5);
        } else if (i9 == 2) {
            linearSystem.m11192a(this.f339v.f263i, this.f337t.f263i, 0, 6);
            if (z) {
                return;
            }
            linearSystem.m11192a(this.f337t.f263i, this.f286D.f339v.f263i, 0, 5);
        } else if (i9 == 3) {
            linearSystem.m11192a(this.f337t.f263i, this.f339v.f263i, 0, 6);
            if (z) {
                return;
            }
            linearSystem.m11192a(this.f337t.f263i, this.f286D.f337t.f263i, 0, 5);
        }
    }
}
