package p000a.p006b.p008b.p009h.p010j;

import java.util.ArrayList;
import p000a.p006b.p008b.p009h.p010j.ConstraintAnchor;

/* renamed from: a.b.b.h.j.p */
/* loaded from: classes.dex */
public class Snapshot {

    /* renamed from: a */
    public int f407a;

    /* renamed from: b */
    public int f408b;

    /* renamed from: c */
    public int f409c;

    /* renamed from: d */
    public int f410d;

    /* renamed from: e */
    public ArrayList<C0035a> f411e = new ArrayList<>();

    /* compiled from: Snapshot.java */
    /* renamed from: a.b.b.h.j.p$a */
    /* loaded from: classes.dex */
    public static class C0035a {

        /* renamed from: a */
        public ConstraintAnchor f412a;

        /* renamed from: b */
        public ConstraintAnchor f413b;

        /* renamed from: c */
        public int f414c;

        /* renamed from: d */
        public ConstraintAnchor.EnumC0030c f415d;

        /* renamed from: e */
        public int f416e;

        public C0035a(ConstraintAnchor constraintAnchor) {
            this.f412a = constraintAnchor;
            this.f413b = constraintAnchor.m11129g();
            this.f414c = constraintAnchor.m11134b();
            this.f415d = constraintAnchor.m11130f();
            this.f416e = constraintAnchor.m11139a();
        }

        /* renamed from: a */
        public void m10984a(ConstraintWidget constraintWidget) {
            constraintWidget.mo11020a(this.f412a.m11128h()).m11135a(this.f413b, this.f414c, this.f415d, this.f416e);
        }

        /* renamed from: b */
        public void m10983b(ConstraintWidget constraintWidget) {
            this.f412a = constraintWidget.mo11020a(this.f412a.m11128h());
            ConstraintAnchor constraintAnchor = this.f412a;
            if (constraintAnchor != null) {
                this.f413b = constraintAnchor.m11129g();
                this.f414c = this.f412a.m11134b();
                this.f415d = this.f412a.m11130f();
                this.f416e = this.f412a.m11139a();
                return;
            }
            this.f413b = null;
            this.f414c = 0;
            this.f415d = ConstraintAnchor.EnumC0030c.STRONG;
            this.f416e = 0;
        }
    }

    public Snapshot(ConstraintWidget constraintWidget) {
        this.f407a = constraintWidget.m11053w();
        this.f408b = constraintWidget.m11052x();
        this.f409c = constraintWidget.m11057t();
        this.f410d = constraintWidget.m11077j();
        ArrayList<ConstraintAnchor> mo11018c = constraintWidget.mo11018c();
        int size = mo11018c.size();
        for (int i = 0; i < size; i++) {
            this.f411e.add(new C0035a(mo11018c.get(i)));
        }
    }

    /* renamed from: a */
    public void m10986a(ConstraintWidget constraintWidget) {
        constraintWidget.m11058s(this.f407a);
        constraintWidget.m11056t(this.f408b);
        constraintWidget.m11064p(this.f409c);
        constraintWidget.m11080h(this.f410d);
        int size = this.f411e.size();
        for (int i = 0; i < size; i++) {
            this.f411e.get(i).m10984a(constraintWidget);
        }
    }

    /* renamed from: b */
    public void m10985b(ConstraintWidget constraintWidget) {
        this.f407a = constraintWidget.m11053w();
        this.f408b = constraintWidget.m11052x();
        this.f409c = constraintWidget.m11057t();
        this.f410d = constraintWidget.m11077j();
        int size = this.f411e.size();
        for (int i = 0; i < size; i++) {
            this.f411e.get(i).m10983b(constraintWidget);
        }
    }
}
