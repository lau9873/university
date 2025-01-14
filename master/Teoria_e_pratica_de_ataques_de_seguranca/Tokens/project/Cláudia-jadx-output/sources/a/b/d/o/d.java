package a.b.d.o;

import a.b.d.o.c;
import a.b.d.x.l;
import android.animation.TypeEvaluator;
import android.graphics.drawable.Drawable;
import android.util.Property;
/* compiled from: CircularRevealWidget.java */
/* loaded from: classes.dex */
public interface d extends c.a {

    /* compiled from: CircularRevealWidget.java */
    /* loaded from: classes.dex */
    public static class b implements TypeEvaluator<e> {

        /* renamed from: b  reason: collision with root package name */
        public static final TypeEvaluator<e> f251b = new b();

        /* renamed from: a  reason: collision with root package name */
        public final e f252a = new e();

        @Override // android.animation.TypeEvaluator
        /* renamed from: a */
        public e evaluate(float f2, e eVar, e eVar2) {
            this.f252a.a(l.a(eVar.f255a, eVar2.f255a, f2), l.a(eVar.f256b, eVar2.f256b, f2), l.a(eVar.f257c, eVar2.f257c, f2));
            return this.f252a;
        }
    }

    /* compiled from: CircularRevealWidget.java */
    /* loaded from: classes.dex */
    public static class c extends Property<d, e> {

        /* renamed from: a  reason: collision with root package name */
        public static final Property<d, e> f253a = new c("circularReveal");

        public c(String str) {
            super(e.class, str);
        }

        @Override // android.util.Property
        /* renamed from: a */
        public e get(d dVar) {
            return dVar.getRevealInfo();
        }

        @Override // android.util.Property
        /* renamed from: a */
        public void set(d dVar, e eVar) {
            dVar.setRevealInfo(eVar);
        }
    }

    /* compiled from: CircularRevealWidget.java */
    /* renamed from: a.b.d.o.d$d  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0004d extends Property<d, Integer> {

        /* renamed from: a  reason: collision with root package name */
        public static final Property<d, Integer> f254a = new C0004d("circularRevealScrimColor");

        public C0004d(String str) {
            super(Integer.class, str);
        }

        @Override // android.util.Property
        /* renamed from: a */
        public Integer get(d dVar) {
            return Integer.valueOf(dVar.getCircularRevealScrimColor());
        }

        @Override // android.util.Property
        /* renamed from: a */
        public void set(d dVar, Integer num) {
            dVar.setCircularRevealScrimColor(num.intValue());
        }
    }

    /* compiled from: CircularRevealWidget.java */
    /* loaded from: classes.dex */
    public static class e {

        /* renamed from: a  reason: collision with root package name */
        public float f255a;

        /* renamed from: b  reason: collision with root package name */
        public float f256b;

        /* renamed from: c  reason: collision with root package name */
        public float f257c;

        public void a(float f2, float f3, float f4) {
            this.f255a = f2;
            this.f256b = f3;
            this.f257c = f4;
        }

        public e() {
        }

        public e(float f2, float f3, float f4) {
            this.f255a = f2;
            this.f256b = f3;
            this.f257c = f4;
        }
    }

    void a();

    void b();

    int getCircularRevealScrimColor();

    e getRevealInfo();

    void setCircularRevealOverlayDrawable(Drawable drawable);

    void setCircularRevealScrimColor(int i2);

    void setRevealInfo(e eVar);
}
