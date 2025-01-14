package p000a.p006b.p008b.p009h.p010j;

import p000a.p006b.p008b.p009h.LinearSystem;

/* renamed from: a.b.b.h.j.c */
/* loaded from: classes.dex */
public class Chain {
    /* renamed from: a */
    public static void m11144a(ConstraintWidgetContainer constraintWidgetContainer, LinearSystem linearSystem, int i) {
        int i2;
        int i3;
        ChainHead[] chainHeadArr;
        if (i == 0) {
            int i4 = constraintWidgetContainer.f364s0;
            chainHeadArr = constraintWidgetContainer.f367v0;
            i3 = i4;
            i2 = 0;
        } else {
            i2 = 2;
            i3 = constraintWidgetContainer.f365t0;
            chainHeadArr = constraintWidgetContainer.f366u0;
        }
        for (int i5 = 0; i5 < i3; i5++) {
            ChainHead chainHead = chainHeadArr[i5];
            chainHead.m11142a();
            if (constraintWidgetContainer.m11032u(4)) {
                if (!Optimizer.m11007a(constraintWidgetContainer, linearSystem, i, i2, chainHead)) {
                    m11143a(constraintWidgetContainer, linearSystem, i, i2, chainHead);
                }
            } else {
                m11143a(constraintWidgetContainer, linearSystem, i, i2, chainHead);
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:17:0x0035, code lost:
        if (r2.f318e0 == 2) goto L294;
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x0048, code lost:
        if (r2.f320f0 == 2) goto L294;
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x004a, code lost:
        r5 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x004c, code lost:
        r5 = false;
     */
    /* JADX WARN: Removed duplicated region for block: B:100:0x0188  */
    /* JADX WARN: Removed duplicated region for block: B:196:0x0366  */
    /* JADX WARN: Removed duplicated region for block: B:209:0x0386  */
    /* JADX WARN: Removed duplicated region for block: B:258:0x0454  */
    /* JADX WARN: Removed duplicated region for block: B:263:0x0489  */
    /* JADX WARN: Removed duplicated region for block: B:272:0x04ae  */
    /* JADX WARN: Removed duplicated region for block: B:273:0x04b1  */
    /* JADX WARN: Removed duplicated region for block: B:276:0x04b7  */
    /* JADX WARN: Removed duplicated region for block: B:277:0x04ba  */
    /* JADX WARN: Removed duplicated region for block: B:279:0x04be  */
    /* JADX WARN: Removed duplicated region for block: B:285:0x04ce  */
    /* JADX WARN: Removed duplicated region for block: B:302:0x0367 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:87:0x014f  */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static void m11143a(p000a.p006b.p008b.p009h.p010j.ConstraintWidgetContainer r36, p000a.p006b.p008b.p009h.LinearSystem r37, int r38, int r39, p000a.p006b.p008b.p009h.p010j.ChainHead r40) {
        /*
            Method dump skipped, instructions count: 1279
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: p000a.p006b.p008b.p009h.p010j.Chain.m11143a(a.b.b.h.j.g, a.b.b.h.e, int, int, a.b.b.h.j.d):void");
    }
}
