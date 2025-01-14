package a.b.d.x;

import a.b.g.k.u;
import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Matrix;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.LayerDrawable;
import android.os.Build;
import android.view.View;
import android.view.ViewTreeObserver;
import java.util.ArrayList;
import java.util.Iterator;
/* compiled from: FloatingActionButtonImpl.java */
/* loaded from: classes.dex */
public class g {
    public static final TimeInterpolator B = a.b.d.l.a.f212c;
    public static final int[] C = {16842919, 16842910};
    public static final int[] D = {16843623, 16842908, 16842910};
    public static final int[] E = {16842908, 16842910};
    public static final int[] F = {16843623, 16842910};
    public static final int[] G = {16842910};
    public static final int[] H = new int[0];
    public ViewTreeObserver.OnPreDrawListener A;

    /* renamed from: b  reason: collision with root package name */
    public Animator f325b;

    /* renamed from: c  reason: collision with root package name */
    public a.b.d.l.h f326c;

    /* renamed from: d  reason: collision with root package name */
    public a.b.d.l.h f327d;

    /* renamed from: e  reason: collision with root package name */
    public a.b.d.l.h f328e;

    /* renamed from: f  reason: collision with root package name */
    public a.b.d.l.h f329f;

    /* renamed from: h  reason: collision with root package name */
    public m f331h;

    /* renamed from: i  reason: collision with root package name */
    public float f332i;
    public Drawable j;
    public Drawable k;
    public a.b.d.x.a l;
    public Drawable m;
    public float n;
    public float o;
    public float p;
    public int q;
    public ArrayList<Animator.AnimatorListener> s;
    public ArrayList<Animator.AnimatorListener> t;
    public final t u;
    public final n v;

    /* renamed from: a  reason: collision with root package name */
    public int f324a = 0;
    public float r = 1.0f;
    public final Rect w = new Rect();
    public final RectF x = new RectF();
    public final RectF y = new RectF();
    public final Matrix z = new Matrix();

    /* renamed from: g  reason: collision with root package name */
    public final p f330g = new p();

    /* compiled from: FloatingActionButtonImpl.java */
    /* loaded from: classes.dex */
    public class a extends AnimatorListenerAdapter {

        /* renamed from: a  reason: collision with root package name */
        public boolean f333a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ boolean f334b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ InterfaceC0008g f335c;

        public a(boolean z, InterfaceC0008g interfaceC0008g) {
            this.f334b = z;
            this.f335c = interfaceC0008g;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            this.f333a = true;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            g gVar = g.this;
            gVar.f324a = 0;
            gVar.f325b = null;
            if (this.f333a) {
                return;
            }
            gVar.u.a(this.f334b ? 8 : 4, this.f334b);
            InterfaceC0008g interfaceC0008g = this.f335c;
            if (interfaceC0008g != null) {
                interfaceC0008g.b();
            }
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            g.this.u.a(0, this.f334b);
            g gVar = g.this;
            gVar.f324a = 1;
            gVar.f325b = animator;
            this.f333a = false;
        }
    }

    /* compiled from: FloatingActionButtonImpl.java */
    /* loaded from: classes.dex */
    public class b extends AnimatorListenerAdapter {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ boolean f337a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ InterfaceC0008g f338b;

        public b(boolean z, InterfaceC0008g interfaceC0008g) {
            this.f337a = z;
            this.f338b = interfaceC0008g;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            g gVar = g.this;
            gVar.f324a = 0;
            gVar.f325b = null;
            InterfaceC0008g interfaceC0008g = this.f338b;
            if (interfaceC0008g != null) {
                interfaceC0008g.a();
            }
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            g.this.u.a(0, this.f337a);
            g gVar = g.this;
            gVar.f324a = 2;
            gVar.f325b = animator;
        }
    }

    /* compiled from: FloatingActionButtonImpl.java */
    /* loaded from: classes.dex */
    public class c implements ViewTreeObserver.OnPreDrawListener {
        public c() {
        }

        @Override // android.view.ViewTreeObserver.OnPreDrawListener
        public boolean onPreDraw() {
            g.this.s();
            return true;
        }
    }

    /* compiled from: FloatingActionButtonImpl.java */
    /* loaded from: classes.dex */
    public class d extends i {
        public d(g gVar) {
            super(gVar, null);
        }

        @Override // a.b.d.x.g.i
        public float a() {
            return 0.0f;
        }
    }

    /* compiled from: FloatingActionButtonImpl.java */
    /* loaded from: classes.dex */
    public class e extends i {
        public e() {
            super(g.this, null);
        }

        @Override // a.b.d.x.g.i
        public float a() {
            g gVar = g.this;
            return gVar.n + gVar.o;
        }
    }

    /* compiled from: FloatingActionButtonImpl.java */
    /* loaded from: classes.dex */
    public class f extends i {
        public f() {
            super(g.this, null);
        }

        @Override // a.b.d.x.g.i
        public float a() {
            g gVar = g.this;
            return gVar.n + gVar.p;
        }
    }

    /* compiled from: FloatingActionButtonImpl.java */
    /* renamed from: a.b.d.x.g$g  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0008g {
        void a();

        void b();
    }

    /* compiled from: FloatingActionButtonImpl.java */
    /* loaded from: classes.dex */
    public class h extends i {
        public h() {
            super(g.this, null);
        }

        @Override // a.b.d.x.g.i
        public float a() {
            return g.this.n;
        }
    }

    /* compiled from: FloatingActionButtonImpl.java */
    /* loaded from: classes.dex */
    public abstract class i extends AnimatorListenerAdapter implements ValueAnimator.AnimatorUpdateListener {

        /* renamed from: a  reason: collision with root package name */
        public boolean f344a;

        /* renamed from: b  reason: collision with root package name */
        public float f345b;

        /* renamed from: c  reason: collision with root package name */
        public float f346c;

        public i() {
        }

        public abstract float a();

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            g.this.f331h.b(this.f346c);
            this.f344a = false;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            if (!this.f344a) {
                this.f345b = g.this.f331h.c();
                this.f346c = a();
                this.f344a = true;
            }
            m mVar = g.this.f331h;
            float f2 = this.f345b;
            mVar.b(f2 + ((this.f346c - f2) * valueAnimator.getAnimatedFraction()));
        }

        public /* synthetic */ i(g gVar, a aVar) {
            this();
        }
    }

    public g(t tVar, n nVar) {
        this.u = tVar;
        this.v = nVar;
        this.f330g.a(C, a((i) new f()));
        this.f330g.a(D, a((i) new e()));
        this.f330g.a(E, a((i) new e()));
        this.f330g.a(F, a((i) new e()));
        this.f330g.a(G, a((i) new h()));
        this.f330g.a(H, a((i) new d(this)));
        this.f332i = this.u.getRotation();
    }

    public void a(ColorStateList colorStateList, PorterDuff.Mode mode, ColorStateList colorStateList2, int i2) {
        Drawable[] drawableArr;
        this.j = a.b.g.c.j.a.i(a());
        a.b.g.c.j.a.a(this.j, colorStateList);
        if (mode != null) {
            a.b.g.c.j.a.a(this.j, mode);
        }
        this.k = a.b.g.c.j.a.i(a());
        a.b.g.c.j.a.a(this.k, a.b.d.s.a.a(colorStateList2));
        if (i2 > 0) {
            this.l = a(i2, colorStateList);
            drawableArr = new Drawable[]{this.l, this.j, this.k};
        } else {
            this.l = null;
            drawableArr = new Drawable[]{this.j, this.k};
        }
        this.m = new LayerDrawable(drawableArr);
        Context context = this.u.getContext();
        Drawable drawable = this.m;
        float b2 = this.v.b();
        float f2 = this.n;
        this.f331h = new m(context, drawable, b2, f2, f2 + this.p);
        this.f331h.a(false);
        this.v.a(this.f331h);
    }

    public void b(ColorStateList colorStateList) {
        Drawable drawable = this.k;
        if (drawable != null) {
            a.b.g.c.j.a.a(drawable, a.b.d.s.a.a(colorStateList));
        }
    }

    public void b(Rect rect) {
    }

    public final void c(float f2) {
        this.r = f2;
        Matrix matrix = this.z;
        a(f2, matrix);
        this.u.setImageMatrix(matrix);
    }

    public final void d(float f2) {
        if (this.p != f2) {
            this.p = f2;
            a(this.n, this.o, this.p);
        }
    }

    public final a.b.d.l.h e() {
        if (this.f328e == null) {
            this.f328e = a.b.d.l.h.a(this.u.getContext(), a.b.d.a.design_fab_show_motion_spec);
        }
        return this.f328e;
    }

    public float f() {
        return this.n;
    }

    public final a.b.d.l.h g() {
        return this.f327d;
    }

    public float h() {
        return this.o;
    }

    public float i() {
        return this.p;
    }

    public final a.b.d.l.h j() {
        return this.f326c;
    }

    public boolean k() {
        return this.u.getVisibility() == 0 ? this.f324a == 1 : this.f324a != 2;
    }

    public boolean l() {
        return this.u.getVisibility() != 0 ? this.f324a == 2 : this.f324a != 1;
    }

    public void m() {
        this.f330g.b();
    }

    public a.b.d.x.a n() {
        return new a.b.d.x.a();
    }

    public GradientDrawable o() {
        return new GradientDrawable();
    }

    public void p() {
        if (t()) {
            b();
            this.u.getViewTreeObserver().addOnPreDrawListener(this.A);
        }
    }

    public void q() {
    }

    public void r() {
        if (this.A != null) {
            this.u.getViewTreeObserver().removeOnPreDrawListener(this.A);
            this.A = null;
        }
    }

    public void s() {
        float rotation = this.u.getRotation();
        if (this.f332i != rotation) {
            this.f332i = rotation;
            v();
        }
    }

    public boolean t() {
        return true;
    }

    public final boolean u() {
        return u.x(this.u) && !this.u.isInEditMode();
    }

    public final void v() {
        if (Build.VERSION.SDK_INT == 19) {
            if (this.f332i % 90.0f != 0.0f) {
                if (this.u.getLayerType() != 1) {
                    this.u.setLayerType(1, null);
                }
            } else if (this.u.getLayerType() != 0) {
                this.u.setLayerType(0, null);
            }
        }
        m mVar = this.f331h;
        if (mVar != null) {
            mVar.a(-this.f332i);
        }
        a.b.d.x.a aVar = this.l;
        if (aVar != null) {
            aVar.b(-this.f332i);
        }
    }

    public final void w() {
        c(this.r);
    }

    public final void x() {
        Rect rect = this.w;
        a(rect);
        b(rect);
        this.v.a(rect.left, rect.top, rect.right, rect.bottom);
    }

    public final void b(float f2) {
        if (this.o != f2) {
            this.o = f2;
            a(this.n, this.o, this.p);
        }
    }

    public void d(Animator.AnimatorListener animatorListener) {
        ArrayList<Animator.AnimatorListener> arrayList = this.s;
        if (arrayList == null) {
            return;
        }
        arrayList.remove(animatorListener);
    }

    public void c(Animator.AnimatorListener animatorListener) {
        ArrayList<Animator.AnimatorListener> arrayList = this.t;
        if (arrayList == null) {
            return;
        }
        arrayList.remove(animatorListener);
    }

    public final a.b.d.l.h d() {
        if (this.f329f == null) {
            this.f329f = a.b.d.l.h.a(this.u.getContext(), a.b.d.a.design_fab_hide_motion_spec);
        }
        return this.f329f;
    }

    public final void b(a.b.d.l.h hVar) {
        this.f326c = hVar;
    }

    public final Drawable c() {
        return this.m;
    }

    public void b(Animator.AnimatorListener animatorListener) {
        if (this.s == null) {
            this.s = new ArrayList<>();
        }
        this.s.add(animatorListener);
    }

    public void b(InterfaceC0008g interfaceC0008g, boolean z) {
        if (l()) {
            return;
        }
        Animator animator = this.f325b;
        if (animator != null) {
            animator.cancel();
        }
        if (u()) {
            if (this.u.getVisibility() != 0) {
                this.u.setAlpha(0.0f);
                this.u.setScaleY(0.0f);
                this.u.setScaleX(0.0f);
                c(0.0f);
            }
            a.b.d.l.h hVar = this.f326c;
            if (hVar == null) {
                hVar = e();
            }
            AnimatorSet a2 = a(hVar, 1.0f, 1.0f, 1.0f);
            a2.addListener(new b(z, interfaceC0008g));
            ArrayList<Animator.AnimatorListener> arrayList = this.s;
            if (arrayList != null) {
                Iterator<Animator.AnimatorListener> it = arrayList.iterator();
                while (it.hasNext()) {
                    a2.addListener(it.next());
                }
            }
            a2.start();
            return;
        }
        this.u.a(0, z);
        this.u.setAlpha(1.0f);
        this.u.setScaleY(1.0f);
        this.u.setScaleX(1.0f);
        c(1.0f);
        if (interfaceC0008g != null) {
            interfaceC0008g.a();
        }
    }

    public void a(ColorStateList colorStateList) {
        Drawable drawable = this.j;
        if (drawable != null) {
            a.b.g.c.j.a.a(drawable, colorStateList);
        }
        a.b.d.x.a aVar = this.l;
        if (aVar != null) {
            aVar.a(colorStateList);
        }
    }

    public void a(PorterDuff.Mode mode) {
        Drawable drawable = this.j;
        if (drawable != null) {
            a.b.g.c.j.a.a(drawable, mode);
        }
    }

    public final void a(float f2) {
        if (this.n != f2) {
            this.n = f2;
            a(this.n, this.o, this.p);
        }
    }

    public final void a(int i2) {
        if (this.q != i2) {
            this.q = i2;
            w();
        }
    }

    public final void a(float f2, Matrix matrix) {
        matrix.reset();
        Drawable drawable = this.u.getDrawable();
        if (drawable == null || this.q == 0) {
            return;
        }
        RectF rectF = this.x;
        RectF rectF2 = this.y;
        rectF.set(0.0f, 0.0f, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
        int i2 = this.q;
        rectF2.set(0.0f, 0.0f, i2, i2);
        matrix.setRectToRect(rectF, rectF2, Matrix.ScaleToFit.CENTER);
        int i3 = this.q;
        matrix.postScale(f2, f2, i3 / 2.0f, i3 / 2.0f);
    }

    public final void b() {
        if (this.A == null) {
            this.A = new c();
        }
    }

    public final void a(a.b.d.l.h hVar) {
        this.f327d = hVar;
    }

    public void a(float f2, float f3, float f4) {
        m mVar = this.f331h;
        if (mVar != null) {
            mVar.a(f2, this.p + f2);
            x();
        }
    }

    public void a(int[] iArr) {
        this.f330g.a(iArr);
    }

    public void a(Animator.AnimatorListener animatorListener) {
        if (this.t == null) {
            this.t = new ArrayList<>();
        }
        this.t.add(animatorListener);
    }

    public void a(InterfaceC0008g interfaceC0008g, boolean z) {
        if (k()) {
            return;
        }
        Animator animator = this.f325b;
        if (animator != null) {
            animator.cancel();
        }
        if (u()) {
            a.b.d.l.h hVar = this.f327d;
            if (hVar == null) {
                hVar = d();
            }
            AnimatorSet a2 = a(hVar, 0.0f, 0.0f, 0.0f);
            a2.addListener(new a(z, interfaceC0008g));
            ArrayList<Animator.AnimatorListener> arrayList = this.t;
            if (arrayList != null) {
                Iterator<Animator.AnimatorListener> it = arrayList.iterator();
                while (it.hasNext()) {
                    a2.addListener(it.next());
                }
            }
            a2.start();
            return;
        }
        this.u.a(z ? 8 : 4, z);
        if (interfaceC0008g != null) {
            interfaceC0008g.b();
        }
    }

    public final AnimatorSet a(a.b.d.l.h hVar, float f2, float f3, float f4) {
        ArrayList arrayList = new ArrayList();
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.u, View.ALPHA, f2);
        hVar.a("opacity").a((Animator) ofFloat);
        arrayList.add(ofFloat);
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this.u, View.SCALE_X, f3);
        hVar.a("scale").a((Animator) ofFloat2);
        arrayList.add(ofFloat2);
        ObjectAnimator ofFloat3 = ObjectAnimator.ofFloat(this.u, View.SCALE_Y, f3);
        hVar.a("scale").a((Animator) ofFloat3);
        arrayList.add(ofFloat3);
        a(f4, this.z);
        ObjectAnimator ofObject = ObjectAnimator.ofObject(this.u, new a.b.d.l.f(), new a.b.d.l.g(), new Matrix(this.z));
        hVar.a("iconScale").a((Animator) ofObject);
        arrayList.add(ofObject);
        AnimatorSet animatorSet = new AnimatorSet();
        a.b.d.l.b.a(animatorSet, arrayList);
        return animatorSet;
    }

    public void a(Rect rect) {
        this.f331h.getPadding(rect);
    }

    public a.b.d.x.a a(int i2, ColorStateList colorStateList) {
        Context context = this.u.getContext();
        a.b.d.x.a n = n();
        n.a(a.b.g.b.b.a(context, a.b.d.c.design_fab_stroke_top_outer_color), a.b.g.b.b.a(context, a.b.d.c.design_fab_stroke_top_inner_color), a.b.g.b.b.a(context, a.b.d.c.design_fab_stroke_end_inner_color), a.b.g.b.b.a(context, a.b.d.c.design_fab_stroke_end_outer_color));
        n.a(i2);
        n.a(colorStateList);
        return n;
    }

    public GradientDrawable a() {
        GradientDrawable o = o();
        o.setShape(1);
        o.setColor(-1);
        return o;
    }

    public final ValueAnimator a(i iVar) {
        ValueAnimator valueAnimator = new ValueAnimator();
        valueAnimator.setInterpolator(B);
        valueAnimator.setDuration(100L);
        valueAnimator.addListener(iVar);
        valueAnimator.addUpdateListener(iVar);
        valueAnimator.setFloatValues(0.0f, 1.0f);
        return valueAnimator;
    }
}
