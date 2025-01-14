package p000a.p006b.p008b.p009h.p010j;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/* renamed from: a.b.b.h.j.h */
/* loaded from: classes.dex */
public class ConstraintWidgetGroup {

    /* renamed from: a */
    public List<ConstraintWidget> f372a;

    /* renamed from: b */
    public int f373b;

    /* renamed from: c */
    public int f374c;

    /* renamed from: d */
    public boolean f375d;

    /* renamed from: e */
    public final int[] f376e;

    /* renamed from: f */
    public List<ConstraintWidget> f377f;

    /* renamed from: g */
    public List<ConstraintWidget> f378g;

    /* renamed from: h */
    public HashSet<ConstraintWidget> f379h;

    /* renamed from: i */
    public HashSet<ConstraintWidget> f380i;

    /* renamed from: j */
    public List<ConstraintWidget> f381j;

    /* renamed from: k */
    public List<ConstraintWidget> f382k;

    public ConstraintWidgetGroup(List<ConstraintWidget> list) {
        this.f373b = -1;
        this.f374c = -1;
        this.f375d = false;
        this.f376e = new int[]{this.f373b, this.f374c};
        this.f377f = new ArrayList();
        this.f378g = new ArrayList();
        this.f379h = new HashSet<>();
        this.f380i = new HashSet<>();
        this.f381j = new ArrayList();
        this.f382k = new ArrayList();
        this.f372a = list;
    }

    /* renamed from: a */
    public List<ConstraintWidget> m11029a(int i) {
        if (i == 0) {
            return this.f377f;
        }
        if (i == 1) {
            return this.f378g;
        }
        return null;
    }

    /* renamed from: b */
    public Set<ConstraintWidget> m11024b(int i) {
        if (i == 0) {
            return this.f379h;
        }
        if (i == 1) {
            return this.f380i;
        }
        return null;
    }

    /* renamed from: a */
    public void m11027a(ConstraintWidget constraintWidget, int i) {
        if (i == 0) {
            this.f379h.add(constraintWidget);
        } else if (i == 1) {
            this.f380i.add(constraintWidget);
        }
    }

    /* renamed from: b */
    public void m11025b() {
        int size = this.f382k.size();
        for (int i = 0; i < size; i++) {
            m11028a(this.f382k.get(i));
        }
    }

    /* renamed from: a */
    public List<ConstraintWidget> m11030a() {
        if (!this.f381j.isEmpty()) {
            return this.f381j;
        }
        int size = this.f372a.size();
        for (int i = 0; i < size; i++) {
            ConstraintWidget constraintWidget = this.f372a.get(i);
            if (!constraintWidget.f312b0) {
                m11026a((ArrayList) this.f381j, constraintWidget);
            }
        }
        this.f382k.clear();
        this.f382k.addAll(this.f372a);
        this.f382k.removeAll(this.f381j);
        return this.f381j;
    }

    public ConstraintWidgetGroup(List<ConstraintWidget> list, boolean z) {
        this.f373b = -1;
        this.f374c = -1;
        this.f375d = false;
        this.f376e = new int[]{this.f373b, this.f374c};
        this.f377f = new ArrayList();
        this.f378g = new ArrayList();
        this.f379h = new HashSet<>();
        this.f380i = new HashSet<>();
        this.f381j = new ArrayList();
        this.f382k = new ArrayList();
        this.f372a = list;
        this.f375d = z;
    }

    /* renamed from: a */
    public final void m11026a(ArrayList<ConstraintWidget> arrayList, ConstraintWidget constraintWidget) {
        if (constraintWidget.f316d0) {
            return;
        }
        arrayList.add(constraintWidget);
        constraintWidget.f316d0 = true;
        if (constraintWidget.m11050z()) {
            return;
        }
        if (constraintWidget instanceof Helper) {
            Helper helper = (Helper) constraintWidget;
            int i = helper.f391l0;
            for (int i2 = 0; i2 < i; i2++) {
                m11026a(arrayList, helper.f390k0[i2]);
            }
        }
        int length = constraintWidget.f283A.length;
        for (int i3 = 0; i3 < length; i3++) {
            ConstraintAnchor constraintAnchor = constraintWidget.f283A[i3].f258d;
            if (constraintAnchor != null) {
                ConstraintWidget constraintWidget2 = constraintAnchor.f256b;
                if (constraintAnchor != null && constraintWidget2 != constraintWidget.m11073l()) {
                    m11026a(arrayList, constraintWidget2);
                }
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:26:0x0048  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0050  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x006b  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x0087  */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void m11028a(p000a.p006b.p008b.p009h.p010j.ConstraintWidget r7) {
        /*
            Method dump skipped, instructions count: 222
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: p000a.p006b.p008b.p009h.p010j.ConstraintWidgetGroup.m11028a(a.b.b.h.j.f):void");
    }
}
