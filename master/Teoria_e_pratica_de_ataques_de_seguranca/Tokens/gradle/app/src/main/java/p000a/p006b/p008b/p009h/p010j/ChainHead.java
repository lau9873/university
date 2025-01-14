package p000a.p006b.p008b.p009h.p010j;

import java.util.ArrayList;
import p000a.p006b.p008b.p009h.p010j.ConstraintWidget;

/* renamed from: a.b.b.h.j.d */
/* loaded from: classes.dex */
public class ChainHead {

    /* renamed from: a */
    public ConstraintWidget f238a;

    /* renamed from: b */
    public ConstraintWidget f239b;

    /* renamed from: c */
    public ConstraintWidget f240c;

    /* renamed from: d */
    public ConstraintWidget f241d;

    /* renamed from: e */
    public ConstraintWidget f242e;

    /* renamed from: f */
    public ConstraintWidget f243f;

    /* renamed from: g */
    public ConstraintWidget f244g;

    /* renamed from: h */
    public ArrayList<ConstraintWidget> f245h;

    /* renamed from: i */
    public int f246i;

    /* renamed from: j */
    public int f247j;

    /* renamed from: k */
    public float f248k = 0.0f;

    /* renamed from: l */
    public int f249l;

    /* renamed from: m */
    public boolean f250m;

    /* renamed from: n */
    public boolean f251n;

    /* renamed from: o */
    public boolean f252o;

    /* renamed from: p */
    public boolean f253p;

    /* renamed from: q */
    public boolean f254q;

    public ChainHead(ConstraintWidget constraintWidget, int i, boolean z) {
        this.f250m = false;
        this.f238a = constraintWidget;
        this.f249l = i;
        this.f250m = z;
    }

    /* renamed from: a */
    public static boolean m11141a(ConstraintWidget constraintWidget, int i) {
        if (constraintWidget.m11059s() != 8 && constraintWidget.f285C[i] == ConstraintWidget.EnumC0033b.MATCH_CONSTRAINT) {
            int[] iArr = constraintWidget.f321g;
            if (iArr[i] == 0 || iArr[i] == 3) {
                return true;
            }
        }
        return false;
    }

    /* renamed from: b */
    public final void m11140b() {
        int i = this.f249l * 2;
        boolean z = false;
        ConstraintWidget constraintWidget = this.f238a;
        ConstraintWidget constraintWidget2 = constraintWidget;
        boolean z2 = false;
        while (!z2) {
            this.f246i++;
            ConstraintWidget[] constraintWidgetArr = constraintWidget.f326i0;
            int i2 = this.f249l;
            ConstraintWidget constraintWidget3 = null;
            constraintWidgetArr[i2] = null;
            constraintWidget.f324h0[i2] = null;
            if (constraintWidget.m11059s() != 8) {
                if (this.f239b == null) {
                    this.f239b = constraintWidget;
                }
                this.f241d = constraintWidget;
                ConstraintWidget.EnumC0033b[] enumC0033bArr = constraintWidget.f285C;
                int i3 = this.f249l;
                if (enumC0033bArr[i3] == ConstraintWidget.EnumC0033b.MATCH_CONSTRAINT) {
                    int[] iArr = constraintWidget.f321g;
                    if (iArr[i3] == 0 || iArr[i3] == 3 || iArr[i3] == 2) {
                        this.f247j++;
                        float[] fArr = constraintWidget.f322g0;
                        int i4 = this.f249l;
                        float f = fArr[i4];
                        if (f > 0.0f) {
                            this.f248k += fArr[i4];
                        }
                        if (m11141a(constraintWidget, this.f249l)) {
                            if (f < 0.0f) {
                                this.f251n = true;
                            } else {
                                this.f252o = true;
                            }
                            if (this.f245h == null) {
                                this.f245h = new ArrayList<>();
                            }
                            this.f245h.add(constraintWidget);
                        }
                        if (this.f243f == null) {
                            this.f243f = constraintWidget;
                        }
                        ConstraintWidget constraintWidget4 = this.f244g;
                        if (constraintWidget4 != null) {
                            constraintWidget4.f324h0[this.f249l] = constraintWidget;
                        }
                        this.f244g = constraintWidget;
                    }
                }
            }
            if (constraintWidget2 != constraintWidget) {
                constraintWidget2.f326i0[this.f249l] = constraintWidget;
            }
            ConstraintAnchor constraintAnchor = constraintWidget.f283A[i + 1].f258d;
            if (constraintAnchor != null) {
                ConstraintWidget constraintWidget5 = constraintAnchor.f256b;
                ConstraintAnchor[] constraintAnchorArr = constraintWidget5.f283A;
                if (constraintAnchorArr[i].f258d != null && constraintAnchorArr[i].f258d.f256b == constraintWidget) {
                    constraintWidget3 = constraintWidget5;
                }
            }
            if (constraintWidget3 == null) {
                constraintWidget3 = constraintWidget;
                z2 = true;
            }
            constraintWidget2 = constraintWidget;
            constraintWidget = constraintWidget3;
        }
        this.f240c = constraintWidget;
        if (this.f249l == 0 && this.f250m) {
            this.f242e = this.f240c;
        } else {
            this.f242e = this.f238a;
        }
        if (this.f252o && this.f251n) {
            z = true;
        }
        this.f253p = z;
    }

    /* renamed from: a */
    public void m11142a() {
        if (!this.f254q) {
            m11140b();
        }
        this.f254q = true;
    }
}
