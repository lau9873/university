package p000a.p006b.p008b.p009h.p010j;

import p000a.p006b.p008b.p009h.LinearSystem;
import p000a.p006b.p008b.p009h.p010j.ConstraintWidget;

/* renamed from: a.b.b.h.j.k */
/* loaded from: classes.dex */
public class Optimizer {

    /* renamed from: a */
    public static boolean[] f392a = new boolean[3];

    /* renamed from: a */
    public static void m11006a(ConstraintWidgetContainer constraintWidgetContainer, LinearSystem linearSystem, ConstraintWidget constraintWidget) {
        if (constraintWidgetContainer.f285C[0] != ConstraintWidget.EnumC0033b.WRAP_CONTENT && constraintWidget.f285C[0] == ConstraintWidget.EnumC0033b.MATCH_PARENT) {
            int i = constraintWidget.f336s.f259e;
            int m11057t = constraintWidgetContainer.m11057t() - constraintWidget.f338u.f259e;
            ConstraintAnchor constraintAnchor = constraintWidget.f336s;
            constraintAnchor.f263i = linearSystem.m11188a(constraintAnchor);
            ConstraintAnchor constraintAnchor2 = constraintWidget.f338u;
            constraintAnchor2.f263i = linearSystem.m11188a(constraintAnchor2);
            linearSystem.m11194a(constraintWidget.f336s.f263i, i);
            linearSystem.m11194a(constraintWidget.f338u.f263i, m11057t);
            constraintWidget.f309a = 2;
            constraintWidget.m11115a(i, m11057t);
        }
        if (constraintWidgetContainer.f285C[1] == ConstraintWidget.EnumC0033b.WRAP_CONTENT || constraintWidget.f285C[1] != ConstraintWidget.EnumC0033b.MATCH_PARENT) {
            return;
        }
        int i2 = constraintWidget.f337t.f259e;
        int m11077j = constraintWidgetContainer.m11077j() - constraintWidget.f339v.f259e;
        ConstraintAnchor constraintAnchor3 = constraintWidget.f337t;
        constraintAnchor3.f263i = linearSystem.m11188a(constraintAnchor3);
        ConstraintAnchor constraintAnchor4 = constraintWidget.f339v;
        constraintAnchor4.f263i = linearSystem.m11188a(constraintAnchor4);
        linearSystem.m11194a(constraintWidget.f337t.f263i, i2);
        linearSystem.m11194a(constraintWidget.f339v.f263i, m11077j);
        if (constraintWidget.f299Q > 0 || constraintWidget.m11059s() == 8) {
            ConstraintAnchor constraintAnchor5 = constraintWidget.f340w;
            constraintAnchor5.f263i = linearSystem.m11188a(constraintAnchor5);
            linearSystem.m11194a(constraintWidget.f340w.f263i, constraintWidget.f299Q + i2);
        }
        constraintWidget.f311b = 2;
        constraintWidget.m11086e(i2, m11077j);
    }

    /* renamed from: a */
    public static boolean m11009a(ConstraintWidget constraintWidget, int i) {
        ConstraintWidget.EnumC0033b[] enumC0033bArr = constraintWidget.f285C;
        if (enumC0033bArr[i] != ConstraintWidget.EnumC0033b.MATCH_CONSTRAINT) {
            return false;
        }
        if (constraintWidget.f289G != 0.0f) {
            if (enumC0033bArr[i != 0 ? (char) 0 : (char) 1] == ConstraintWidget.EnumC0033b.MATCH_CONSTRAINT) {
            }
            return false;
        }
        if (i == 0) {
            if (constraintWidget.f317e != 0 || constraintWidget.f323h != 0 || constraintWidget.f325i != 0) {
                return false;
            }
        } else if (constraintWidget.f319f != 0 || constraintWidget.f328k != 0 || constraintWidget.f329l != 0) {
            return false;
        }
        return true;
    }

    /* renamed from: a */
    public static void m11010a(int i, ConstraintWidget constraintWidget) {
        constraintWidget.m11118J();
        ResolutionAnchor m11132d = constraintWidget.f336s.m11132d();
        ResolutionAnchor m11132d2 = constraintWidget.f337t.m11132d();
        ResolutionAnchor m11132d3 = constraintWidget.f338u.m11132d();
        ResolutionAnchor m11132d4 = constraintWidget.f339v.m11132d();
        boolean z = (i & 8) == 8;
        boolean z2 = constraintWidget.f285C[0] == ConstraintWidget.EnumC0033b.MATCH_CONSTRAINT && m11009a(constraintWidget, 0);
        if (m11132d.f398h != 4 && m11132d3.f398h != 4) {
            if (constraintWidget.f285C[0] == ConstraintWidget.EnumC0033b.FIXED || (z2 && constraintWidget.m11059s() == 8)) {
                if (constraintWidget.f336s.f258d == null && constraintWidget.f338u.f258d == null) {
                    m11132d.m10999b(1);
                    m11132d3.m10999b(1);
                    if (z) {
                        m11132d3.m11000a(m11132d, 1, constraintWidget.m11069n());
                    } else {
                        m11132d3.m11001a(m11132d, constraintWidget.m11057t());
                    }
                } else if (constraintWidget.f336s.f258d != null && constraintWidget.f338u.f258d == null) {
                    m11132d.m10999b(1);
                    m11132d3.m10999b(1);
                    if (z) {
                        m11132d3.m11000a(m11132d, 1, constraintWidget.m11069n());
                    } else {
                        m11132d3.m11001a(m11132d, constraintWidget.m11057t());
                    }
                } else if (constraintWidget.f336s.f258d == null && constraintWidget.f338u.f258d != null) {
                    m11132d.m10999b(1);
                    m11132d3.m10999b(1);
                    m11132d.m11001a(m11132d3, -constraintWidget.m11057t());
                    if (z) {
                        m11132d.m11000a(m11132d3, -1, constraintWidget.m11069n());
                    } else {
                        m11132d.m11001a(m11132d3, -constraintWidget.m11057t());
                    }
                } else if (constraintWidget.f336s.f258d != null && constraintWidget.f338u.f258d != null) {
                    m11132d.m10999b(2);
                    m11132d3.m10999b(2);
                    if (z) {
                        constraintWidget.m11069n().m10991a(m11132d);
                        constraintWidget.m11069n().m10991a(m11132d3);
                        m11132d.m10997b(m11132d3, -1, constraintWidget.m11069n());
                        m11132d3.m10997b(m11132d, 1, constraintWidget.m11069n());
                    } else {
                        m11132d.m10998b(m11132d3, -constraintWidget.m11057t());
                        m11132d3.m10998b(m11132d, constraintWidget.m11057t());
                    }
                }
            } else if (z2) {
                int m11057t = constraintWidget.m11057t();
                m11132d.m10999b(1);
                m11132d3.m10999b(1);
                if (constraintWidget.f336s.f258d == null && constraintWidget.f338u.f258d == null) {
                    if (z) {
                        m11132d3.m11000a(m11132d, 1, constraintWidget.m11069n());
                    } else {
                        m11132d3.m11001a(m11132d, m11057t);
                    }
                } else if (constraintWidget.f336s.f258d == null || constraintWidget.f338u.f258d != null) {
                    if (constraintWidget.f336s.f258d != null || constraintWidget.f338u.f258d == null) {
                        if (constraintWidget.f336s.f258d != null && constraintWidget.f338u.f258d != null) {
                            if (z) {
                                constraintWidget.m11069n().m10991a(m11132d);
                                constraintWidget.m11069n().m10991a(m11132d3);
                            }
                            if (constraintWidget.f289G == 0.0f) {
                                m11132d.m10999b(3);
                                m11132d3.m10999b(3);
                                m11132d.m10998b(m11132d3, 0.0f);
                                m11132d3.m10998b(m11132d, 0.0f);
                            } else {
                                m11132d.m10999b(2);
                                m11132d3.m10999b(2);
                                m11132d.m10998b(m11132d3, -m11057t);
                                m11132d3.m10998b(m11132d, m11057t);
                                constraintWidget.m11064p(m11057t);
                            }
                        }
                    } else if (z) {
                        m11132d.m11000a(m11132d3, -1, constraintWidget.m11069n());
                    } else {
                        m11132d.m11001a(m11132d3, -m11057t);
                    }
                } else if (z) {
                    m11132d3.m11000a(m11132d, 1, constraintWidget.m11069n());
                } else {
                    m11132d3.m11001a(m11132d, m11057t);
                }
            }
        }
        boolean z3 = constraintWidget.f285C[1] == ConstraintWidget.EnumC0033b.MATCH_CONSTRAINT && m11009a(constraintWidget, 1);
        if (m11132d2.f398h == 4 || m11132d4.f398h == 4) {
            return;
        }
        if (constraintWidget.f285C[1] != ConstraintWidget.EnumC0033b.FIXED && (!z3 || constraintWidget.m11059s() != 8)) {
            if (z3) {
                int m11077j = constraintWidget.m11077j();
                m11132d2.m10999b(1);
                m11132d4.m10999b(1);
                if (constraintWidget.f337t.f258d == null && constraintWidget.f339v.f258d == null) {
                    if (z) {
                        m11132d4.m11000a(m11132d2, 1, constraintWidget.m11071m());
                    } else {
                        m11132d4.m11001a(m11132d2, m11077j);
                    }
                } else if (constraintWidget.f337t.f258d != null && constraintWidget.f339v.f258d == null) {
                    if (z) {
                        m11132d4.m11000a(m11132d2, 1, constraintWidget.m11071m());
                    } else {
                        m11132d4.m11001a(m11132d2, m11077j);
                    }
                } else if (constraintWidget.f337t.f258d == null && constraintWidget.f339v.f258d != null) {
                    if (z) {
                        m11132d2.m11000a(m11132d4, -1, constraintWidget.m11071m());
                    } else {
                        m11132d2.m11001a(m11132d4, -m11077j);
                    }
                } else if (constraintWidget.f337t.f258d == null || constraintWidget.f339v.f258d == null) {
                } else {
                    if (z) {
                        constraintWidget.m11071m().m10991a(m11132d2);
                        constraintWidget.m11069n().m10991a(m11132d4);
                    }
                    if (constraintWidget.f289G == 0.0f) {
                        m11132d2.m10999b(3);
                        m11132d4.m10999b(3);
                        m11132d2.m10998b(m11132d4, 0.0f);
                        m11132d4.m10998b(m11132d2, 0.0f);
                        return;
                    }
                    m11132d2.m10999b(2);
                    m11132d4.m10999b(2);
                    m11132d2.m10998b(m11132d4, -m11077j);
                    m11132d4.m10998b(m11132d2, m11077j);
                    constraintWidget.m11080h(m11077j);
                    if (constraintWidget.f299Q > 0) {
                        constraintWidget.f340w.m11132d().m11004a(1, m11132d2, constraintWidget.f299Q);
                    }
                }
            }
        } else if (constraintWidget.f337t.f258d == null && constraintWidget.f339v.f258d == null) {
            m11132d2.m10999b(1);
            m11132d4.m10999b(1);
            if (z) {
                m11132d4.m11000a(m11132d2, 1, constraintWidget.m11071m());
            } else {
                m11132d4.m11001a(m11132d2, constraintWidget.m11077j());
            }
            ConstraintAnchor constraintAnchor = constraintWidget.f340w;
            if (constraintAnchor.f258d != null) {
                constraintAnchor.m11132d().m10999b(1);
                m11132d2.m11004a(1, constraintWidget.f340w.m11132d(), -constraintWidget.f299Q);
            }
        } else if (constraintWidget.f337t.f258d != null && constraintWidget.f339v.f258d == null) {
            m11132d2.m10999b(1);
            m11132d4.m10999b(1);
            if (z) {
                m11132d4.m11000a(m11132d2, 1, constraintWidget.m11071m());
            } else {
                m11132d4.m11001a(m11132d2, constraintWidget.m11077j());
            }
            if (constraintWidget.f299Q > 0) {
                constraintWidget.f340w.m11132d().m11004a(1, m11132d2, constraintWidget.f299Q);
            }
        } else if (constraintWidget.f337t.f258d == null && constraintWidget.f339v.f258d != null) {
            m11132d2.m10999b(1);
            m11132d4.m10999b(1);
            if (z) {
                m11132d2.m11000a(m11132d4, -1, constraintWidget.m11071m());
            } else {
                m11132d2.m11001a(m11132d4, -constraintWidget.m11077j());
            }
            if (constraintWidget.f299Q > 0) {
                constraintWidget.f340w.m11132d().m11004a(1, m11132d2, constraintWidget.f299Q);
            }
        } else if (constraintWidget.f337t.f258d == null || constraintWidget.f339v.f258d == null) {
        } else {
            m11132d2.m10999b(2);
            m11132d4.m10999b(2);
            if (z) {
                m11132d2.m10997b(m11132d4, -1, constraintWidget.m11071m());
                m11132d4.m10997b(m11132d2, 1, constraintWidget.m11071m());
                constraintWidget.m11071m().m10991a(m11132d2);
                constraintWidget.m11069n().m10991a(m11132d4);
            } else {
                m11132d2.m10998b(m11132d4, -constraintWidget.m11077j());
                m11132d4.m10998b(m11132d2, constraintWidget.m11077j());
            }
            if (constraintWidget.f299Q > 0) {
                constraintWidget.f340w.m11132d().m11004a(1, m11132d2, constraintWidget.f299Q);
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:13:0x0032, code lost:
        if (r7.f318e0 == 2) goto L11;
     */
    /* JADX WARN: Code restructure failed: missing block: B:14:0x0034, code lost:
        r2 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x0036, code lost:
        r2 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x0048, code lost:
        if (r7.f320f0 == 2) goto L11;
     */
    /* JADX WARN: Removed duplicated region for block: B:136:0x01d6  */
    /* JADX WARN: Removed duplicated region for block: B:212:0x0109 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:220:0x0105 A[SYNTHETIC] */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static boolean m11007a(p000a.p006b.p008b.p009h.p010j.ConstraintWidgetContainer r24, p000a.p006b.p008b.p009h.LinearSystem r25, int r26, int r27, p000a.p006b.p008b.p009h.p010j.ChainHead r28) {
        /*
            Method dump skipped, instructions count: 900
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: p000a.p006b.p008b.p009h.p010j.Optimizer.m11007a(a.b.b.h.j.g, a.b.b.h.e, int, int, a.b.b.h.j.d):boolean");
    }

    /* renamed from: a */
    public static void m11008a(ConstraintWidget constraintWidget, int i, int i2) {
        int i3 = i * 2;
        int i4 = i3 + 1;
        constraintWidget.f283A[i3].m11132d().f396f = constraintWidget.m11073l().f336s.m11132d();
        constraintWidget.f283A[i3].m11132d().f397g = i2;
        constraintWidget.f283A[i3].m11132d().f406b = 1;
        constraintWidget.f283A[i4].m11132d().f396f = constraintWidget.f283A[i3].m11132d();
        constraintWidget.f283A[i4].m11132d().f397g = constraintWidget.m11090d(i);
        constraintWidget.f283A[i4].m11132d().f406b = 1;
    }
}
