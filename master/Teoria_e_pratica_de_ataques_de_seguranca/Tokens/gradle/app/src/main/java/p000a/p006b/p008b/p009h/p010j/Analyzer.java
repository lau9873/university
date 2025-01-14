package p000a.p006b.p008b.p009h.p010j;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import p000a.p006b.p008b.p009h.p010j.ConstraintWidget;

/* renamed from: a.b.b.h.j.a */
/* loaded from: classes.dex */
public class Analyzer {
    /* renamed from: a */
    public static void m11151a(ConstraintWidgetContainer constraintWidgetContainer) {
        if ((constraintWidgetContainer.m11049N() & 32) != 32) {
            m11147b(constraintWidgetContainer);
            return;
        }
        constraintWidgetContainer.f354D0 = true;
        constraintWidgetContainer.f369x0 = false;
        constraintWidgetContainer.f370y0 = false;
        constraintWidgetContainer.f371z0 = false;
        ArrayList<ConstraintWidget> arrayList = constraintWidgetContainer.f417k0;
        List<ConstraintWidgetGroup> list = constraintWidgetContainer.f368w0;
        boolean z = constraintWidgetContainer.m11075k() == ConstraintWidget.EnumC0033b.WRAP_CONTENT;
        boolean z2 = constraintWidgetContainer.m11061r() == ConstraintWidget.EnumC0033b.WRAP_CONTENT;
        boolean z3 = z || z2;
        list.clear();
        for (ConstraintWidget constraintWidget : arrayList) {
            constraintWidget.f333p = null;
            constraintWidget.f316d0 = false;
            constraintWidget.mo11120G();
        }
        for (ConstraintWidget constraintWidget2 : arrayList) {
            if (constraintWidget2.f333p == null && !m11152a(constraintWidget2, list, z3)) {
                m11147b(constraintWidgetContainer);
                constraintWidgetContainer.f354D0 = false;
                return;
            }
        }
        int i = 0;
        int i2 = 0;
        for (ConstraintWidgetGroup constraintWidgetGroup : list) {
            i = Math.max(i, m11149a(constraintWidgetGroup, 0));
            i2 = Math.max(i2, m11149a(constraintWidgetGroup, 1));
        }
        if (z) {
            constraintWidgetContainer.m11109a(ConstraintWidget.EnumC0033b.FIXED);
            constraintWidgetContainer.m11064p(i);
            constraintWidgetContainer.f369x0 = true;
            constraintWidgetContainer.f370y0 = true;
            constraintWidgetContainer.f351A0 = i;
        }
        if (z2) {
            constraintWidgetContainer.m11098b(ConstraintWidget.EnumC0033b.FIXED);
            constraintWidgetContainer.m11080h(i2);
            constraintWidgetContainer.f369x0 = true;
            constraintWidgetContainer.f371z0 = true;
            constraintWidgetContainer.f352B0 = i2;
        }
        m11148a(list, 0, constraintWidgetContainer.m11057t());
        m11148a(list, 1, constraintWidgetContainer.m11077j());
    }

    /* renamed from: b */
    public static void m11147b(ConstraintWidgetContainer constraintWidgetContainer) {
        constraintWidgetContainer.f368w0.clear();
        constraintWidgetContainer.f368w0.add(0, new ConstraintWidgetGroup(constraintWidgetContainer.f417k0));
    }

    /* renamed from: a */
    public static boolean m11152a(ConstraintWidget constraintWidget, List<ConstraintWidgetGroup> list, boolean z) {
        ConstraintWidgetGroup constraintWidgetGroup = new ConstraintWidgetGroup(new ArrayList(), true);
        list.add(constraintWidgetGroup);
        return m11153a(constraintWidget, constraintWidgetGroup, list, z);
    }

    /* JADX WARN: Code restructure failed: missing block: B:122:0x0181, code lost:
        if (r3.f256b == r4) goto L74;
     */
    /* JADX WARN: Code restructure failed: missing block: B:91:0x0128, code lost:
        if (r3.f256b == r4) goto L63;
     */
    /* JADX WARN: Removed duplicated region for block: B:117:0x0173  */
    /* JADX WARN: Removed duplicated region for block: B:134:0x01a0  */
    /* JADX WARN: Removed duplicated region for block: B:146:0x01c2  */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static boolean m11153a(p000a.p006b.p008b.p009h.p010j.ConstraintWidget r8, p000a.p006b.p008b.p009h.p010j.ConstraintWidgetGroup r9, java.util.List<p000a.p006b.p008b.p009h.p010j.ConstraintWidgetGroup> r10, boolean r11) {
        /*
            Method dump skipped, instructions count: 560
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: p000a.p006b.p008b.p009h.p010j.Analyzer.m11153a(a.b.b.h.j.f, a.b.b.h.j.h, java.util.List, boolean):boolean");
    }

    /* renamed from: a */
    public static void m11150a(ConstraintWidgetContainer constraintWidgetContainer, ConstraintWidget constraintWidget, ConstraintWidgetGroup constraintWidgetGroup) {
        constraintWidgetGroup.f375d = false;
        constraintWidgetContainer.f354D0 = false;
        constraintWidget.f312b0 = false;
    }

    /* renamed from: a */
    public static int m11149a(ConstraintWidgetGroup constraintWidgetGroup, int i) {
        int i2 = i * 2;
        List<ConstraintWidget> m11029a = constraintWidgetGroup.m11029a(i);
        int size = m11029a.size();
        int i3 = 0;
        for (int i4 = 0; i4 < size; i4++) {
            ConstraintWidget constraintWidget = m11029a.get(i4);
            ConstraintAnchor[] constraintAnchorArr = constraintWidget.f283A;
            int i5 = i2 + 1;
            i3 = Math.max(i3, m11154a(constraintWidget, i, constraintAnchorArr[i5].f258d == null || !(constraintAnchorArr[i2].f258d == null || constraintAnchorArr[i5].f258d == null), 0));
        }
        constraintWidgetGroup.f376e[i] = i3;
        return i3;
    }

    /* renamed from: a */
    public static int m11154a(ConstraintWidget constraintWidget, int i, boolean z, int i2) {
        int m11077j;
        int m11092d;
        int i3;
        int i4;
        int i5;
        int i6;
        int m11057t;
        int i7;
        int i8;
        int i9;
        int i10 = 0;
        if (constraintWidget.f312b0) {
            boolean z2 = constraintWidget.f340w.f258d != null && i == 1;
            if (z) {
                m11077j = constraintWidget.m11092d();
                m11092d = constraintWidget.m11077j() - constraintWidget.m11092d();
                i4 = i * 2;
                i3 = i4 + 1;
            } else {
                m11077j = constraintWidget.m11077j() - constraintWidget.m11092d();
                m11092d = constraintWidget.m11092d();
                i3 = i * 2;
                i4 = i3 + 1;
            }
            ConstraintAnchor[] constraintAnchorArr = constraintWidget.f283A;
            if (constraintAnchorArr[i3].f258d == null || constraintAnchorArr[i4].f258d != null) {
                i5 = i3;
                i6 = 1;
            } else {
                i5 = i4;
                i4 = i3;
                i6 = -1;
            }
            int i11 = z2 ? i2 - m11077j : i2;
            int m11134b = (constraintWidget.f283A[i4].m11134b() * i6) + m11156a(constraintWidget, i);
            int i12 = i11 + m11134b;
            int m11057t2 = (i == 0 ? constraintWidget.m11057t() : constraintWidget.m11077j()) * i6;
            Iterator<ResolutionNode> it = constraintWidget.f283A[i4].m11132d().f405a.iterator();
            while (it.hasNext()) {
                i10 = Math.max(i10, m11154a(((ResolutionAnchor) it.next()).f393c.f256b, i, z, i12));
            }
            int i13 = 0;
            for (Iterator<ResolutionNode> it2 = constraintWidget.f283A[i5].m11132d().f405a.iterator(); it2.hasNext(); it2 = it2) {
                i13 = Math.max(i13, m11154a(((ResolutionAnchor) it2.next()).f393c.f256b, i, z, m11057t2 + i12));
            }
            if (z2) {
                i10 -= m11077j;
                m11057t = i13 + m11092d;
            } else {
                m11057t = i13 + ((i == 0 ? constraintWidget.m11057t() : constraintWidget.m11077j()) * i6);
            }
            int i14 = 1;
            if (i == 1) {
                Iterator<ResolutionNode> it3 = constraintWidget.f340w.m11132d().f405a.iterator();
                int i15 = 0;
                while (it3.hasNext()) {
                    Iterator<ResolutionNode> it4 = it3;
                    ResolutionAnchor resolutionAnchor = (ResolutionAnchor) it3.next();
                    if (i6 == i14) {
                        i15 = Math.max(i15, m11154a(resolutionAnchor.f393c.f256b, i, z, m11077j + i12));
                        i9 = i5;
                    } else {
                        i9 = i5;
                        i15 = Math.max(i15, m11154a(resolutionAnchor.f393c.f256b, i, z, (m11092d * i6) + i12));
                    }
                    it3 = it4;
                    i5 = i9;
                    i14 = 1;
                }
                i7 = i5;
                int i16 = i15;
                i8 = (constraintWidget.f340w.m11132d().f405a.size() <= 0 || z2) ? i16 : i6 == 1 ? i16 + m11077j : i16 - m11092d;
            } else {
                i7 = i5;
                i8 = 0;
            }
            int max = m11134b + Math.max(i10, Math.max(m11057t, i8));
            int i17 = i12 + m11057t2;
            if (i6 != -1) {
                i12 = i17;
                i17 = i12;
            }
            if (z) {
                Optimizer.m11008a(constraintWidget, i, i17);
                constraintWidget.m11114a(i17, i12, i);
            } else {
                constraintWidget.f333p.m11027a(constraintWidget, i);
                constraintWidget.m11089d(i17, i);
            }
            if (constraintWidget.m11094c(i) == ConstraintWidget.EnumC0033b.MATCH_CONSTRAINT && constraintWidget.f289G != 0.0f) {
                constraintWidget.f333p.m11027a(constraintWidget, i);
            }
            ConstraintAnchor[] constraintAnchorArr2 = constraintWidget.f283A;
            if (constraintAnchorArr2[i4].f258d != null && constraintAnchorArr2[i7].f258d != null) {
                ConstraintWidget m11073l = constraintWidget.m11073l();
                ConstraintAnchor[] constraintAnchorArr3 = constraintWidget.f283A;
                if (constraintAnchorArr3[i4].f258d.f256b == m11073l && constraintAnchorArr3[i7].f258d.f256b == m11073l) {
                    constraintWidget.f333p.m11027a(constraintWidget, i);
                }
            }
            return max;
        }
        return 0;
    }

    /* renamed from: a */
    public static void m11158a(ConstraintAnchor constraintAnchor) {
        ResolutionAnchor m11132d = constraintAnchor.m11132d();
        ConstraintAnchor constraintAnchor2 = constraintAnchor.f258d;
        if (constraintAnchor2 == null || constraintAnchor2.f258d == constraintAnchor) {
            return;
        }
        constraintAnchor2.m11132d().m10991a(m11132d);
    }

    /* renamed from: a */
    public static void m11148a(List<ConstraintWidgetGroup> list, int i, int i2) {
        int size = list.size();
        for (int i3 = 0; i3 < size; i3++) {
            for (ConstraintWidget constraintWidget : list.get(i3).m11024b(i)) {
                if (constraintWidget.f312b0) {
                    m11155a(constraintWidget, i, i2);
                }
            }
        }
    }

    /* renamed from: a */
    public static void m11155a(ConstraintWidget constraintWidget, int i, int i2) {
        int i3 = i * 2;
        ConstraintAnchor[] constraintAnchorArr = constraintWidget.f283A;
        ConstraintAnchor constraintAnchor = constraintAnchorArr[i3];
        ConstraintAnchor constraintAnchor2 = constraintAnchorArr[i3 + 1];
        if ((constraintAnchor.f258d == null || constraintAnchor2.f258d == null) ? false : true) {
            Optimizer.m11008a(constraintWidget, i, m11156a(constraintWidget, i) + constraintAnchor.m11134b());
        } else if (constraintWidget.f289G != 0.0f && constraintWidget.m11094c(i) == ConstraintWidget.EnumC0033b.MATCH_CONSTRAINT) {
            int m11157a = m11157a(constraintWidget);
            int i4 = (int) constraintWidget.f283A[i3].m11132d().f397g;
            constraintAnchor2.m11132d().f396f = constraintAnchor.m11132d();
            constraintAnchor2.m11132d().f397g = m11157a;
            constraintAnchor2.m11132d().f406b = 1;
            constraintWidget.m11114a(i4, i4 + m11157a, i);
        } else {
            int m11087e = i2 - constraintWidget.m11087e(i);
            int m11090d = m11087e - constraintWidget.m11090d(i);
            constraintWidget.m11114a(m11090d, m11087e, i);
            Optimizer.m11008a(constraintWidget, i, m11090d);
        }
    }

    /* renamed from: a */
    public static int m11156a(ConstraintWidget constraintWidget, int i) {
        ConstraintAnchor constraintAnchor;
        int i2 = i * 2;
        ConstraintAnchor[] constraintAnchorArr = constraintWidget.f283A;
        ConstraintAnchor constraintAnchor2 = constraintAnchorArr[i2];
        ConstraintAnchor constraintAnchor3 = constraintAnchorArr[i2 + 1];
        ConstraintAnchor constraintAnchor4 = constraintAnchor2.f258d;
        if (constraintAnchor4 != null) {
            ConstraintWidget constraintWidget2 = constraintAnchor4.f256b;
            ConstraintWidget constraintWidget3 = constraintWidget.f286D;
            if (constraintWidget2 == constraintWidget3 && (constraintAnchor = constraintAnchor3.f258d) != null && constraintAnchor.f256b == constraintWidget3) {
                return (int) ((((constraintWidget3.m11090d(i) - constraintAnchor2.m11134b()) - constraintAnchor3.m11134b()) - constraintWidget.m11090d(i)) * (i == 0 ? constraintWidget.f304V : constraintWidget.f305W));
            }
            return 0;
        }
        return 0;
    }

    /* renamed from: a */
    public static int m11157a(ConstraintWidget constraintWidget) {
        float m11057t;
        float m11077j;
        if (constraintWidget.m11075k() == ConstraintWidget.EnumC0033b.MATCH_CONSTRAINT) {
            if (constraintWidget.f290H == 0) {
                m11077j = constraintWidget.m11077j() * constraintWidget.f289G;
            } else {
                m11077j = constraintWidget.m11077j() / constraintWidget.f289G;
            }
            int i = (int) m11077j;
            constraintWidget.m11064p(i);
            return i;
        } else if (constraintWidget.m11061r() == ConstraintWidget.EnumC0033b.MATCH_CONSTRAINT) {
            if (constraintWidget.f290H == 1) {
                m11057t = constraintWidget.m11057t() * constraintWidget.f289G;
            } else {
                m11057t = constraintWidget.m11057t() / constraintWidget.f289G;
            }
            int i2 = (int) m11057t;
            constraintWidget.m11080h(i2);
            return i2;
        } else {
            return -1;
        }
    }
}
