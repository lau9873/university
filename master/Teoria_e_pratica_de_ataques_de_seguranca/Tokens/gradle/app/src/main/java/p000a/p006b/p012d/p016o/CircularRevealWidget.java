package p000a.p006b.p012d.p016o;

import android.animation.TypeEvaluator;
import android.graphics.drawable.Drawable;
import android.util.Property;
import p000a.p006b.p012d.p016o.CircularRevealHelper;
import p000a.p006b.p012d.p026x.MathUtils;

/* renamed from: a.b.d.o.d */
/* loaded from: classes.dex */
public interface CircularRevealWidget extends CircularRevealHelper.InterfaceC0051a {

    /* compiled from: CircularRevealWidget.java */
    /* renamed from: a.b.d.o.d$b */
    /* loaded from: classes.dex */
    public static class C0053b implements TypeEvaluator<C0056e> {

        /* renamed from: b */
        public static final TypeEvaluator<C0056e> f477b = new C0053b();

        /* renamed from: a */
        public final C0056e f478a = new C0056e();

        @Override // android.animation.TypeEvaluator
        /* renamed from: a */
        public C0056e evaluate(float f, C0056e c0056e, C0056e c0056e2) {
            this.f478a.m10892a(MathUtils.m10694a(c0056e.f481a, c0056e2.f481a, f), MathUtils.m10694a(c0056e.f482b, c0056e2.f482b, f), MathUtils.m10694a(c0056e.f483c, c0056e2.f483c, f));
            return this.f478a;
        }
    }

    /* compiled from: CircularRevealWidget.java */
    /* renamed from: a.b.d.o.d$c */
    /* loaded from: classes.dex */
    public static class C0054c extends Property<CircularRevealWidget, C0056e> {

        /* renamed from: a */
        public static final Property<CircularRevealWidget, C0056e> f479a = new C0054c("circularReveal");

        public C0054c(String str) {
            super(C0056e.class, str);
        }

        @Override // android.util.Property
        /* renamed from: a */
        public C0056e get(CircularRevealWidget circularRevealWidget) {
            return circularRevealWidget.getRevealInfo();
        }

        @Override // android.util.Property
        /* renamed from: a */
        public void set(CircularRevealWidget circularRevealWidget, C0056e c0056e) {
            circularRevealWidget.setRevealInfo(c0056e);
        }
    }

    /* compiled from: CircularRevealWidget.java */
    /* renamed from: a.b.d.o.d$d */
    /* loaded from: classes.dex */
    public static class C0055d extends Property<CircularRevealWidget, Integer> {

        /* renamed from: a */
        public static final Property<CircularRevealWidget, Integer> f480a = new C0055d("circularRevealScrimColor");

        public C0055d(String str) {
            super(Integer.class, str);
        }

        @Override // android.util.Property
        /* renamed from: a */
        public Integer get(CircularRevealWidget circularRevealWidget) {
            return Integer.valueOf(circularRevealWidget.getCircularRevealScrimColor());
        }

        @Override // android.util.Property
        /* renamed from: a */
        public void set(CircularRevealWidget circularRevealWidget, Integer num) {
            circularRevealWidget.setCircularRevealScrimColor(num.intValue());
        }
    }

    /* compiled from: CircularRevealWidget.java */
    /* renamed from: a.b.d.o.d$e */
    /* loaded from: classes.dex */
    public static class C0056e {

        /* renamed from: a */
        public float f481a;

        /* renamed from: b */
        public float f482b;

        /* renamed from: c */
        public float f483c;

        /* renamed from: a */
        public void m10892a(float f, float f2, float f3) {
            this.f481a = f;
            this.f482b = f2;
            this.f483c = f3;
        }

        public C0056e() {
        }

        public C0056e(float f, float f2, float f3) {
            this.f481a = f;
            this.f482b = f2;
            this.f483c = f3;
        }
    }

    /* renamed from: a */
    void mo10891a();

    /* renamed from: b */
    void mo10890b();

    int getCircularRevealScrimColor();

    C0056e getRevealInfo();

    void setCircularRevealOverlayDrawable(Drawable drawable);

    void setCircularRevealScrimColor(int i);

    void setRevealInfo(C0056e c0056e);
}
