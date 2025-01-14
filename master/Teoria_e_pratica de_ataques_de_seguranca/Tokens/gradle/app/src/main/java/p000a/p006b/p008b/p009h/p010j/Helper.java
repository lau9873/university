package p000a.p006b.p008b.p009h.p010j;

import java.util.Arrays;

/* renamed from: a.b.b.h.j.j */
/* loaded from: classes.dex */
public class Helper extends ConstraintWidget {

    /* renamed from: k0 */
    public ConstraintWidget[] f390k0 = new ConstraintWidget[4];

    /* renamed from: l0 */
    public int f391l0 = 0;

    /* renamed from: K */
    public void m11012K() {
        this.f391l0 = 0;
    }

    /* renamed from: b */
    public void m11011b(ConstraintWidget constraintWidget) {
        int i = this.f391l0 + 1;
        ConstraintWidget[] constraintWidgetArr = this.f390k0;
        if (i > constraintWidgetArr.length) {
            this.f390k0 = (ConstraintWidget[]) Arrays.copyOf(constraintWidgetArr, constraintWidgetArr.length * 2);
        }
        ConstraintWidget[] constraintWidgetArr2 = this.f390k0;
        int i2 = this.f391l0;
        constraintWidgetArr2[i2] = constraintWidget;
        this.f391l0 = i2 + 1;
    }
}
