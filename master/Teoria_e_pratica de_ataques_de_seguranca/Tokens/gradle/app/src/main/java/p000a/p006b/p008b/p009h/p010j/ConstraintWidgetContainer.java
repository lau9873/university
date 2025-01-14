package p000a.p006b.p008b.p009h.p010j;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import p000a.p006b.p008b.p009h.LinearSystem;
import p000a.p006b.p008b.p009h.p010j.ConstraintAnchor;
import p000a.p006b.p008b.p009h.p010j.ConstraintWidget;

/* renamed from: a.b.b.h.j.g */
/* loaded from: classes.dex */
public class ConstraintWidgetContainer extends WidgetContainer {

    /* renamed from: n0 */
    public Snapshot f359n0;

    /* renamed from: o0 */
    public int f360o0;

    /* renamed from: p0 */
    public int f361p0;

    /* renamed from: q0 */
    public int f362q0;

    /* renamed from: r0 */
    public int f363r0;

    /* renamed from: l0 */
    public boolean f357l0 = false;

    /* renamed from: m0 */
    public LinearSystem f358m0 = new LinearSystem();

    /* renamed from: s0 */
    public int f364s0 = 0;

    /* renamed from: t0 */
    public int f365t0 = 0;

    /* renamed from: u0 */
    public ChainHead[] f366u0 = new ChainHead[4];

    /* renamed from: v0 */
    public ChainHead[] f367v0 = new ChainHead[4];

    /* renamed from: w0 */
    public List<ConstraintWidgetGroup> f368w0 = new ArrayList();

    /* renamed from: x0 */
    public boolean f369x0 = false;

    /* renamed from: y0 */
    public boolean f370y0 = false;

    /* renamed from: z0 */
    public boolean f371z0 = false;

    /* renamed from: A0 */
    public int f351A0 = 0;

    /* renamed from: B0 */
    public int f352B0 = 0;

    /* renamed from: C0 */
    public int f353C0 = 7;

    /* renamed from: D0 */
    public boolean f354D0 = false;

    /* renamed from: E0 */
    public boolean f355E0 = false;

    /* renamed from: F0 */
    public boolean f356F0 = false;

    @Override // p000a.p006b.p008b.p009h.p010j.WidgetContainer, p000a.p006b.p008b.p009h.p010j.ConstraintWidget
    /* renamed from: E */
    public void mo10982E() {
        this.f358m0.m11172i();
        this.f360o0 = 0;
        this.f362q0 = 0;
        this.f361p0 = 0;
        this.f363r0 = 0;
        this.f368w0.clear();
        this.f354D0 = false;
        super.mo10982E();
    }

    /* JADX WARN: Removed duplicated region for block: B:110:0x0267  */
    /* JADX WARN: Removed duplicated region for block: B:113:0x0283  */
    /* JADX WARN: Removed duplicated region for block: B:114:0x0290  */
    /* JADX WARN: Removed duplicated region for block: B:116:0x0293  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x0186  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x018f  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x01da  */
    /* JADX WARN: Type inference failed for: r8v20 */
    /* JADX WARN: Type inference failed for: r8v21, types: [boolean] */
    /* JADX WARN: Type inference failed for: r8v22 */
    @Override // p000a.p006b.p008b.p009h.p010j.WidgetContainer
    /* renamed from: L */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void mo10979L() {
        /*
            Method dump skipped, instructions count: 839
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: p000a.p006b.p008b.p009h.p010j.ConstraintWidgetContainer.mo10979L():void");
    }

    /* renamed from: N */
    public int m11049N() {
        return this.f353C0;
    }

    /* renamed from: O */
    public boolean m11048O() {
        return false;
    }

    /* renamed from: P */
    public boolean m11047P() {
        return this.f356F0;
    }

    /* renamed from: Q */
    public boolean m11046Q() {
        return this.f357l0;
    }

    /* renamed from: R */
    public boolean m11045R() {
        return this.f355E0;
    }

    /* renamed from: S */
    public void m11044S() {
        if (!m11032u(8)) {
            mo11022a(this.f353C0);
        }
        m11040W();
    }

    /* renamed from: T */
    public void m11043T() {
        int size = this.f417k0.size();
        mo11120G();
        for (int i = 0; i < size; i++) {
            this.f417k0.get(i).mo11120G();
        }
    }

    /* renamed from: U */
    public void m11042U() {
        m11043T();
        mo11022a(this.f353C0);
    }

    /* renamed from: V */
    public final void m11041V() {
        this.f364s0 = 0;
        this.f365t0 = 0;
    }

    /* renamed from: W */
    public void m11040W() {
        ResolutionAnchor m11132d = mo11020a(ConstraintAnchor.EnumC0031d.LEFT).m11132d();
        ResolutionAnchor m11132d2 = mo11020a(ConstraintAnchor.EnumC0031d.TOP).m11132d();
        m11132d.m11002a((ResolutionAnchor) null, 0.0f);
        m11132d2.m11002a((ResolutionAnchor) null, 0.0f);
    }

    /* renamed from: a */
    public void m11039a(LinearSystem linearSystem, boolean[] zArr) {
        zArr[2] = false;
        mo11017c(linearSystem);
        int size = this.f417k0.size();
        for (int i = 0; i < size; i++) {
            ConstraintWidget constraintWidget = this.f417k0.get(i);
            constraintWidget.mo11017c(linearSystem);
            if (constraintWidget.f285C[0] == ConstraintWidget.EnumC0033b.MATCH_CONSTRAINT && constraintWidget.m11057t() < constraintWidget.m11054v()) {
                zArr[2] = true;
            }
            if (constraintWidget.f285C[1] == ConstraintWidget.EnumC0033b.MATCH_CONSTRAINT && constraintWidget.m11077j() < constraintWidget.m11055u()) {
                zArr[2] = true;
            }
        }
    }

    /* renamed from: c */
    public void m11037c(boolean z) {
        this.f357l0 = z;
    }

    /* renamed from: d */
    public boolean m11036d(LinearSystem linearSystem) {
        mo11021a(linearSystem);
        int size = this.f417k0.size();
        for (int i = 0; i < size; i++) {
            ConstraintWidget constraintWidget = this.f417k0.get(i);
            if (constraintWidget instanceof ConstraintWidgetContainer) {
                ConstraintWidget.EnumC0033b[] enumC0033bArr = constraintWidget.f285C;
                ConstraintWidget.EnumC0033b enumC0033b = enumC0033bArr[0];
                ConstraintWidget.EnumC0033b enumC0033b2 = enumC0033bArr[1];
                if (enumC0033b == ConstraintWidget.EnumC0033b.WRAP_CONTENT) {
                    constraintWidget.m11109a(ConstraintWidget.EnumC0033b.FIXED);
                }
                if (enumC0033b2 == ConstraintWidget.EnumC0033b.WRAP_CONTENT) {
                    constraintWidget.m11098b(ConstraintWidget.EnumC0033b.FIXED);
                }
                constraintWidget.mo11021a(linearSystem);
                if (enumC0033b == ConstraintWidget.EnumC0033b.WRAP_CONTENT) {
                    constraintWidget.m11109a(enumC0033b);
                }
                if (enumC0033b2 == ConstraintWidget.EnumC0033b.WRAP_CONTENT) {
                    constraintWidget.m11098b(enumC0033b2);
                }
            } else {
                Optimizer.m11006a(this, linearSystem, constraintWidget);
                constraintWidget.mo11021a(linearSystem);
            }
        }
        if (this.f364s0 > 0) {
            Chain.m11144a(this, linearSystem, 0);
        }
        if (this.f365t0 > 0) {
            Chain.m11144a(this, linearSystem, 1);
        }
        return true;
    }

    /* renamed from: e */
    public final void m11034e(ConstraintWidget constraintWidget) {
        int i = this.f365t0 + 1;
        ChainHead[] chainHeadArr = this.f366u0;
        if (i >= chainHeadArr.length) {
            this.f366u0 = (ChainHead[]) Arrays.copyOf(chainHeadArr, chainHeadArr.length * 2);
        }
        this.f366u0[this.f365t0] = new ChainHead(constraintWidget, 1, m11046Q());
        this.f365t0++;
    }

    /* renamed from: f */
    public void m11033f(int i, int i2) {
        ResolutionDimension resolutionDimension;
        ResolutionDimension resolutionDimension2;
        if (this.f285C[0] != ConstraintWidget.EnumC0033b.WRAP_CONTENT && (resolutionDimension2 = this.f313c) != null) {
            resolutionDimension2.m10994a(i);
        }
        if (this.f285C[1] == ConstraintWidget.EnumC0033b.WRAP_CONTENT || (resolutionDimension = this.f315d) == null) {
            return;
        }
        resolutionDimension.m10994a(i2);
    }

    /* renamed from: u */
    public boolean m11032u(int i) {
        return (this.f353C0 & i) == i;
    }

    /* renamed from: v */
    public void m11031v(int i) {
        this.f353C0 = i;
    }

    @Override // p000a.p006b.p008b.p009h.p010j.ConstraintWidget
    /* renamed from: a */
    public void mo11022a(int i) {
        super.mo11022a(i);
        int size = this.f417k0.size();
        for (int i2 = 0; i2 < size; i2++) {
            this.f417k0.get(i2).mo11022a(i);
        }
    }

    /* renamed from: a */
    public void m11038a(ConstraintWidget constraintWidget, int i) {
        if (i == 0) {
            m11035d(constraintWidget);
        } else if (i == 1) {
            m11034e(constraintWidget);
        }
    }

    /* renamed from: d */
    public final void m11035d(ConstraintWidget constraintWidget) {
        int i = this.f364s0 + 1;
        ChainHead[] chainHeadArr = this.f367v0;
        if (i >= chainHeadArr.length) {
            this.f367v0 = (ChainHead[]) Arrays.copyOf(chainHeadArr, chainHeadArr.length * 2);
        }
        this.f367v0[this.f364s0] = new ChainHead(constraintWidget, 0, m11046Q());
        this.f364s0++;
    }
}
