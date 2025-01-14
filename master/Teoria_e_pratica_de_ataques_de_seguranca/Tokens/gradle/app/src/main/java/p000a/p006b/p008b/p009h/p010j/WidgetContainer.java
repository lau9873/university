package p000a.p006b.p008b.p009h.p010j;

import java.util.ArrayList;
import p000a.p006b.p008b.p009h.Cache;

/* renamed from: a.b.b.h.j.q */
/* loaded from: classes.dex */
public class WidgetContainer extends ConstraintWidget {

    /* renamed from: k0 */
    public ArrayList<ConstraintWidget> f417k0 = new ArrayList<>();

    @Override // p000a.p006b.p008b.p009h.p010j.ConstraintWidget
    /* renamed from: E */
    public void mo10982E() {
        this.f417k0.clear();
        super.mo10982E();
    }

    @Override // p000a.p006b.p008b.p009h.p010j.ConstraintWidget
    /* renamed from: I */
    public void mo10981I() {
        super.mo10981I();
        ArrayList<ConstraintWidget> arrayList = this.f417k0;
        if (arrayList == null) {
            return;
        }
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            ConstraintWidget constraintWidget = this.f417k0.get(i);
            constraintWidget.mo10976b(m11081h(), m11079i());
            if (!(constraintWidget instanceof ConstraintWidgetContainer)) {
                constraintWidget.mo10981I();
            }
        }
    }

    /* renamed from: K */
    public ConstraintWidgetContainer m10980K() {
        ConstraintWidget m11073l = m11073l();
        ConstraintWidgetContainer constraintWidgetContainer = this instanceof ConstraintWidgetContainer ? (ConstraintWidgetContainer) this : null;
        while (m11073l != null) {
            ConstraintWidget m11073l2 = m11073l.m11073l();
            if (m11073l instanceof ConstraintWidgetContainer) {
                constraintWidgetContainer = (ConstraintWidgetContainer) m11073l;
            }
            m11073l = m11073l2;
        }
        return constraintWidgetContainer;
    }

    /* renamed from: L */
    public void mo10979L() {
        mo10981I();
        ArrayList<ConstraintWidget> arrayList = this.f417k0;
        if (arrayList == null) {
            return;
        }
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            ConstraintWidget constraintWidget = this.f417k0.get(i);
            if (constraintWidget instanceof WidgetContainer) {
                ((WidgetContainer) constraintWidget).mo10979L();
            }
        }
    }

    /* renamed from: M */
    public void m10978M() {
        this.f417k0.clear();
    }

    @Override // p000a.p006b.p008b.p009h.p010j.ConstraintWidget
    /* renamed from: a */
    public void mo10977a(Cache cache) {
        super.mo10977a(cache);
        int size = this.f417k0.size();
        for (int i = 0; i < size; i++) {
            this.f417k0.get(i).mo10977a(cache);
        }
    }

    /* renamed from: b */
    public void m10975b(ConstraintWidget constraintWidget) {
        this.f417k0.add(constraintWidget);
        if (constraintWidget.m11073l() != null) {
            ((WidgetContainer) constraintWidget.m11073l()).m10974c(constraintWidget);
        }
        constraintWidget.m11108a((ConstraintWidget) this);
    }

    /* renamed from: c */
    public void m10974c(ConstraintWidget constraintWidget) {
        this.f417k0.remove(constraintWidget);
        constraintWidget.m11108a((ConstraintWidget) null);
    }

    @Override // p000a.p006b.p008b.p009h.p010j.ConstraintWidget
    /* renamed from: b */
    public void mo10976b(int i, int i2) {
        super.mo10976b(i, i2);
        int size = this.f417k0.size();
        for (int i3 = 0; i3 < size; i3++) {
            this.f417k0.get(i3).mo10976b(m11065p(), m11063q());
        }
    }
}
