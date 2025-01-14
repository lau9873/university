package p000a.p006b.p012d.p026x;

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
import p000a.p006b.p012d.C0039a;
import p000a.p006b.p012d.C0041c;
import p000a.p006b.p012d.p013l.AnimationUtils;
import p000a.p006b.p012d.p013l.AnimatorSetCompat;
import p000a.p006b.p012d.p013l.ImageMatrixProperty;
import p000a.p006b.p012d.p013l.MatrixEvaluator;
import p000a.p006b.p012d.p013l.MotionSpec;
import p000a.p006b.p012d.p021s.RippleUtils;
import p000a.p006b.p030g.p032b.ContextCompat;
import p000a.p006b.p030g.p034c.p035j.DrawableCompat;
import p000a.p006b.p030g.p045k.ViewCompat;

/* renamed from: a.b.d.x.g */
/* loaded from: classes.dex */
public class FloatingActionButtonImpl {

    /* renamed from: B */
    public static final TimeInterpolator f621B = AnimationUtils.f423c;

    /* renamed from: C */
    public static final int[] f622C = {16842919, 16842910};

    /* renamed from: D */
    public static final int[] f623D = {16843623, 16842908, 16842910};

    /* renamed from: E */
    public static final int[] f624E = {16842908, 16842910};

    /* renamed from: F */
    public static final int[] f625F = {16843623, 16842910};

    /* renamed from: G */
    public static final int[] f626G = {16842910};

    /* renamed from: H */
    public static final int[] f627H = new int[0];

    /* renamed from: A */
    public ViewTreeObserver.OnPreDrawListener f628A;

    /* renamed from: b */
    public Animator f630b;

    /* renamed from: c */
    public MotionSpec f631c;

    /* renamed from: d */
    public MotionSpec f632d;

    /* renamed from: e */
    public MotionSpec f633e;

    /* renamed from: f */
    public MotionSpec f634f;

    /* renamed from: h */
    public ShadowDrawableWrapper f636h;

    /* renamed from: i */
    public float f637i;

    /* renamed from: j */
    public Drawable f638j;

    /* renamed from: k */
    public Drawable f639k;

    /* renamed from: l */
    public CircularBorderDrawable f640l;

    /* renamed from: m */
    public Drawable f641m;

    /* renamed from: n */
    public float f642n;

    /* renamed from: o */
    public float f643o;

    /* renamed from: p */
    public float f644p;

    /* renamed from: q */
    public int f645q;

    /* renamed from: s */
    public ArrayList<Animator.AnimatorListener> f647s;

    /* renamed from: t */
    public ArrayList<Animator.AnimatorListener> f648t;

    /* renamed from: u */
    public final VisibilityAwareImageButton f649u;

    /* renamed from: v */
    public final ShadowViewDelegate f650v;

    /* renamed from: a */
    public int f629a = 0;

    /* renamed from: r */
    public float f646r = 1.0f;

    /* renamed from: w */
    public final Rect f651w = new Rect();

    /* renamed from: x */
    public final RectF f652x = new RectF();

    /* renamed from: y */
    public final RectF f653y = new RectF();

    /* renamed from: z */
    public final Matrix f654z = new Matrix();

    /* renamed from: g */
    public final StateListAnimator f635g = new StateListAnimator();

    /* compiled from: FloatingActionButtonImpl.java */
    /* renamed from: a.b.d.x.g$a */
    /* loaded from: classes.dex */
    public class C0064a extends AnimatorListenerAdapter {

        /* renamed from: a */
        public boolean f655a;

        /* renamed from: b */
        public final /* synthetic */ boolean f656b;

        /* renamed from: c */
        public final /* synthetic */ InterfaceC0070g f657c;

        public C0064a(boolean z, InterfaceC0070g interfaceC0070g) {
            this.f656b = z;
            this.f657c = interfaceC0070g;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            this.f655a = true;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            FloatingActionButtonImpl floatingActionButtonImpl = FloatingActionButtonImpl.this;
            floatingActionButtonImpl.f629a = 0;
            floatingActionButtonImpl.f630b = null;
            if (this.f655a) {
                return;
            }
            floatingActionButtonImpl.f649u.m10647a(this.f656b ? 8 : 4, this.f656b);
            InterfaceC0070g interfaceC0070g = this.f657c;
            if (interfaceC0070g != null) {
                interfaceC0070g.mo7636b();
            }
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            FloatingActionButtonImpl.this.f649u.m10647a(0, this.f656b);
            FloatingActionButtonImpl floatingActionButtonImpl = FloatingActionButtonImpl.this;
            floatingActionButtonImpl.f629a = 1;
            floatingActionButtonImpl.f630b = animator;
            this.f655a = false;
        }
    }

    /* compiled from: FloatingActionButtonImpl.java */
    /* renamed from: a.b.d.x.g$b */
    /* loaded from: classes.dex */
    public class C0065b extends AnimatorListenerAdapter {

        /* renamed from: a */
        public final /* synthetic */ boolean f659a;

        /* renamed from: b */
        public final /* synthetic */ InterfaceC0070g f660b;

        public C0065b(boolean z, InterfaceC0070g interfaceC0070g) {
            this.f659a = z;
            this.f660b = interfaceC0070g;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            FloatingActionButtonImpl floatingActionButtonImpl = FloatingActionButtonImpl.this;
            floatingActionButtonImpl.f629a = 0;
            floatingActionButtonImpl.f630b = null;
            InterfaceC0070g interfaceC0070g = this.f660b;
            if (interfaceC0070g != null) {
                interfaceC0070g.mo7637a();
            }
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            FloatingActionButtonImpl.this.f649u.m10647a(0, this.f659a);
            FloatingActionButtonImpl floatingActionButtonImpl = FloatingActionButtonImpl.this;
            floatingActionButtonImpl.f629a = 2;
            floatingActionButtonImpl.f630b = animator;
        }
    }

    /* compiled from: FloatingActionButtonImpl.java */
    /* renamed from: a.b.d.x.g$c */
    /* loaded from: classes.dex */
    public class ViewTreeObserver$OnPreDrawListenerC0066c implements ViewTreeObserver.OnPreDrawListener {
        public ViewTreeObserver$OnPreDrawListenerC0066c() {
        }

        @Override // android.view.ViewTreeObserver.OnPreDrawListener
        public boolean onPreDraw() {
            FloatingActionButtonImpl.this.m10760s();
            return true;
        }
    }

    /* compiled from: FloatingActionButtonImpl.java */
    /* renamed from: a.b.d.x.g$d */
    /* loaded from: classes.dex */
    public class C0067d extends AbstractC0072i {
        public C0067d(FloatingActionButtonImpl floatingActionButtonImpl) {
            super(floatingActionButtonImpl, null);
        }

        @Override // p000a.p006b.p012d.p026x.FloatingActionButtonImpl.AbstractC0072i
        /* renamed from: a */
        public float mo10755a() {
            return 0.0f;
        }
    }

    /* compiled from: FloatingActionButtonImpl.java */
    /* renamed from: a.b.d.x.g$e */
    /* loaded from: classes.dex */
    public class C0068e extends AbstractC0072i {
        public C0068e() {
            super(FloatingActionButtonImpl.this, null);
        }

        @Override // p000a.p006b.p012d.p026x.FloatingActionButtonImpl.AbstractC0072i
        /* renamed from: a */
        public float mo10755a() {
            FloatingActionButtonImpl floatingActionButtonImpl = FloatingActionButtonImpl.this;
            return floatingActionButtonImpl.f642n + floatingActionButtonImpl.f643o;
        }
    }

    /* compiled from: FloatingActionButtonImpl.java */
    /* renamed from: a.b.d.x.g$f */
    /* loaded from: classes.dex */
    public class C0069f extends AbstractC0072i {
        public C0069f() {
            super(FloatingActionButtonImpl.this, null);
        }

        @Override // p000a.p006b.p012d.p026x.FloatingActionButtonImpl.AbstractC0072i
        /* renamed from: a */
        public float mo10755a() {
            FloatingActionButtonImpl floatingActionButtonImpl = FloatingActionButtonImpl.this;
            return floatingActionButtonImpl.f642n + floatingActionButtonImpl.f644p;
        }
    }

    /* compiled from: FloatingActionButtonImpl.java */
    /* renamed from: a.b.d.x.g$g */
    /* loaded from: classes.dex */
    public interface InterfaceC0070g {
        /* renamed from: a */
        void mo7637a();

        /* renamed from: b */
        void mo7636b();
    }

    /* compiled from: FloatingActionButtonImpl.java */
    /* renamed from: a.b.d.x.g$h */
    /* loaded from: classes.dex */
    public class C0071h extends AbstractC0072i {
        public C0071h() {
            super(FloatingActionButtonImpl.this, null);
        }

        @Override // p000a.p006b.p012d.p026x.FloatingActionButtonImpl.AbstractC0072i
        /* renamed from: a */
        public float mo10755a() {
            return FloatingActionButtonImpl.this.f642n;
        }
    }

    /* compiled from: FloatingActionButtonImpl.java */
    /* renamed from: a.b.d.x.g$i */
    /* loaded from: classes.dex */
    public abstract class AbstractC0072i extends AnimatorListenerAdapter implements ValueAnimator.AnimatorUpdateListener {

        /* renamed from: a */
        public boolean f666a;

        /* renamed from: b */
        public float f667b;

        /* renamed from: c */
        public float f668c;

        public AbstractC0072i() {
        }

        /* renamed from: a */
        public abstract float mo10755a();

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            FloatingActionButtonImpl.this.f636h.m10683b(this.f668c);
            this.f666a = false;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            if (!this.f666a) {
                this.f667b = FloatingActionButtonImpl.this.f636h.m10681c();
                this.f668c = mo10755a();
                this.f666a = true;
            }
            ShadowDrawableWrapper shadowDrawableWrapper = FloatingActionButtonImpl.this.f636h;
            float f = this.f667b;
            shadowDrawableWrapper.m10683b(f + ((this.f668c - f) * valueAnimator.getAnimatedFraction()));
        }

        public /* synthetic */ AbstractC0072i(FloatingActionButtonImpl floatingActionButtonImpl, C0064a c0064a) {
            this();
        }
    }

    public FloatingActionButtonImpl(VisibilityAwareImageButton visibilityAwareImageButton, ShadowViewDelegate shadowViewDelegate) {
        this.f649u = visibilityAwareImageButton;
        this.f650v = shadowViewDelegate;
        this.f635g.m10660a(f622C, m10784a((AbstractC0072i) new C0069f()));
        this.f635g.m10660a(f623D, m10784a((AbstractC0072i) new C0068e()));
        this.f635g.m10660a(f624E, m10784a((AbstractC0072i) new C0068e()));
        this.f635g.m10660a(f625F, m10784a((AbstractC0072i) new C0068e()));
        this.f635g.m10660a(f626G, m10784a((AbstractC0072i) new C0071h()));
        this.f635g.m10660a(f627H, m10784a((AbstractC0072i) new C0067d(this)));
        this.f637i = this.f649u.getRotation();
    }

    /* renamed from: a */
    public void mo10752a(ColorStateList colorStateList, PorterDuff.Mode mode, ColorStateList colorStateList2, int i) {
        Drawable[] drawableArr;
        this.f638j = DrawableCompat.m9848i(m10792a());
        DrawableCompat.m9861a(this.f638j, colorStateList);
        if (mode != null) {
            DrawableCompat.m9858a(this.f638j, mode);
        }
        this.f639k = DrawableCompat.m9848i(m10792a());
        DrawableCompat.m9861a(this.f639k, RippleUtils.m10854a(colorStateList2));
        if (i > 0) {
            this.f640l = m10788a(i, colorStateList);
            drawableArr = new Drawable[]{this.f640l, this.f638j, this.f639k};
        } else {
            this.f640l = null;
            drawableArr = new Drawable[]{this.f638j, this.f639k};
        }
        this.f641m = new LayerDrawable(drawableArr);
        Context context = this.f649u.getContext();
        Drawable drawable = this.f641m;
        float mo7630b = this.f650v.mo7630b();
        float f = this.f642n;
        this.f636h = new ShadowDrawableWrapper(context, drawable, mo7630b, f, f + this.f644p);
        this.f636h.m10685a(false);
        this.f650v.mo7631a(this.f636h);
    }

    /* renamed from: b */
    public void mo10749b(ColorStateList colorStateList) {
        Drawable drawable = this.f639k;
        if (drawable != null) {
            DrawableCompat.m9861a(drawable, RippleUtils.m10854a(colorStateList));
        }
    }

    /* renamed from: b */
    public void mo10748b(Rect rect) {
    }

    /* renamed from: c */
    public final void m10774c(float f) {
        this.f646r = f;
        Matrix matrix = this.f654z;
        m10790a(f, matrix);
        this.f649u.setImageMatrix(matrix);
    }

    /* renamed from: d */
    public final void m10771d(float f) {
        if (this.f644p != f) {
            this.f644p = f;
            mo10753a(this.f642n, this.f643o, this.f644p);
        }
    }

    /* renamed from: e */
    public final MotionSpec m10769e() {
        if (this.f633e == null) {
            this.f633e = MotionSpec.m10960a(this.f649u.getContext(), C0039a.design_fab_show_motion_spec);
        }
        return this.f633e;
    }

    /* renamed from: f */
    public float mo10747f() {
        return this.f642n;
    }

    /* renamed from: g */
    public final MotionSpec m10768g() {
        return this.f632d;
    }

    /* renamed from: h */
    public float m10767h() {
        return this.f643o;
    }

    /* renamed from: i */
    public float m10766i() {
        return this.f644p;
    }

    /* renamed from: j */
    public final MotionSpec m10765j() {
        return this.f631c;
    }

    /* renamed from: k */
    public boolean m10764k() {
        return this.f649u.getVisibility() == 0 ? this.f629a == 1 : this.f629a != 2;
    }

    /* renamed from: l */
    public boolean m10763l() {
        return this.f649u.getVisibility() != 0 ? this.f629a == 2 : this.f629a != 1;
    }

    /* renamed from: m */
    public void mo10746m() {
        this.f635g.m10659b();
    }

    /* renamed from: n */
    public CircularBorderDrawable mo10745n() {
        return new CircularBorderDrawable();
    }

    /* renamed from: o */
    public GradientDrawable mo10744o() {
        return new GradientDrawable();
    }

    /* renamed from: p */
    public void m10762p() {
        if (mo10742t()) {
            m10780b();
            this.f649u.getViewTreeObserver().addOnPreDrawListener(this.f628A);
        }
    }

    /* renamed from: q */
    public void mo10743q() {
    }

    /* renamed from: r */
    public void m10761r() {
        if (this.f628A != null) {
            this.f649u.getViewTreeObserver().removeOnPreDrawListener(this.f628A);
            this.f628A = null;
        }
    }

    /* renamed from: s */
    public void m10760s() {
        float rotation = this.f649u.getRotation();
        if (this.f637i != rotation) {
            this.f637i = rotation;
            m10758v();
        }
    }

    /* renamed from: t */
    public boolean mo10742t() {
        return true;
    }

    /* renamed from: u */
    public final boolean m10759u() {
        return ViewCompat.m9409x(this.f649u) && !this.f649u.isInEditMode();
    }

    /* renamed from: v */
    public final void m10758v() {
        if (Build.VERSION.SDK_INT == 19) {
            if (this.f637i % 90.0f != 0.0f) {
                if (this.f649u.getLayerType() != 1) {
                    this.f649u.setLayerType(1, null);
                }
            } else if (this.f649u.getLayerType() != 0) {
                this.f649u.setLayerType(0, null);
            }
        }
        ShadowDrawableWrapper shadowDrawableWrapper = this.f636h;
        if (shadowDrawableWrapper != null) {
            shadowDrawableWrapper.m10690a(-this.f637i);
        }
        CircularBorderDrawable circularBorderDrawable = this.f640l;
        if (circularBorderDrawable != null) {
            circularBorderDrawable.m10847b(-this.f637i);
        }
    }

    /* renamed from: w */
    public final void m10757w() {
        m10774c(this.f646r);
    }

    /* renamed from: x */
    public final void m10756x() {
        Rect rect = this.f651w;
        mo10751a(rect);
        mo10748b(rect);
        this.f650v.mo7632a(rect.left, rect.top, rect.right, rect.bottom);
    }

    /* renamed from: b */
    public final void m10779b(float f) {
        if (this.f643o != f) {
            this.f643o = f;
            mo10753a(this.f642n, this.f643o, this.f644p);
        }
    }

    /* renamed from: d */
    public void m10770d(Animator.AnimatorListener animatorListener) {
        ArrayList<Animator.AnimatorListener> arrayList = this.f647s;
        if (arrayList == null) {
            return;
        }
        arrayList.remove(animatorListener);
    }

    /* renamed from: c */
    public void m10773c(Animator.AnimatorListener animatorListener) {
        ArrayList<Animator.AnimatorListener> arrayList = this.f648t;
        if (arrayList == null) {
            return;
        }
        arrayList.remove(animatorListener);
    }

    /* renamed from: d */
    public final MotionSpec m10772d() {
        if (this.f634f == null) {
            this.f634f = MotionSpec.m10960a(this.f649u.getContext(), C0039a.design_fab_hide_motion_spec);
        }
        return this.f634f;
    }

    /* renamed from: b */
    public final void m10778b(MotionSpec motionSpec) {
        this.f631c = motionSpec;
    }

    /* renamed from: c */
    public final Drawable m10775c() {
        return this.f641m;
    }

    /* renamed from: b */
    public void m10776b(Animator.AnimatorListener animatorListener) {
        if (this.f647s == null) {
            this.f647s = new ArrayList<>();
        }
        this.f647s.add(animatorListener);
    }

    /* renamed from: b */
    public void m10777b(InterfaceC0070g interfaceC0070g, boolean z) {
        if (m10763l()) {
            return;
        }
        Animator animator = this.f630b;
        if (animator != null) {
            animator.cancel();
        }
        if (m10759u()) {
            if (this.f649u.getVisibility() != 0) {
                this.f649u.setAlpha(0.0f);
                this.f649u.setScaleY(0.0f);
                this.f649u.setScaleX(0.0f);
                m10774c(0.0f);
            }
            MotionSpec motionSpec = this.f631c;
            if (motionSpec == null) {
                motionSpec = m10769e();
            }
            AnimatorSet m10786a = m10786a(motionSpec, 1.0f, 1.0f, 1.0f);
            m10786a.addListener(new C0065b(z, interfaceC0070g));
            ArrayList<Animator.AnimatorListener> arrayList = this.f647s;
            if (arrayList != null) {
                Iterator<Animator.AnimatorListener> it = arrayList.iterator();
                while (it.hasNext()) {
                    m10786a.addListener(it.next());
                }
            }
            m10786a.start();
            return;
        }
        this.f649u.m10647a(0, z);
        this.f649u.setAlpha(1.0f);
        this.f649u.setScaleY(1.0f);
        this.f649u.setScaleX(1.0f);
        m10774c(1.0f);
        if (interfaceC0070g != null) {
            interfaceC0070g.mo7637a();
        }
    }

    /* renamed from: a */
    public void m10782a(ColorStateList colorStateList) {
        Drawable drawable = this.f638j;
        if (drawable != null) {
            DrawableCompat.m9861a(drawable, colorStateList);
        }
        CircularBorderDrawable circularBorderDrawable = this.f640l;
        if (circularBorderDrawable != null) {
            circularBorderDrawable.m10848a(colorStateList);
        }
    }

    /* renamed from: a */
    public void m10781a(PorterDuff.Mode mode) {
        Drawable drawable = this.f638j;
        if (drawable != null) {
            DrawableCompat.m9858a(drawable, mode);
        }
    }

    /* renamed from: a */
    public final void m10791a(float f) {
        if (this.f642n != f) {
            this.f642n = f;
            mo10753a(this.f642n, this.f643o, this.f644p);
        }
    }

    /* renamed from: a */
    public final void m10789a(int i) {
        if (this.f645q != i) {
            this.f645q = i;
            m10757w();
        }
    }

    /* renamed from: a */
    public final void m10790a(float f, Matrix matrix) {
        matrix.reset();
        Drawable drawable = this.f649u.getDrawable();
        if (drawable == null || this.f645q == 0) {
            return;
        }
        RectF rectF = this.f652x;
        RectF rectF2 = this.f653y;
        rectF.set(0.0f, 0.0f, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
        int i = this.f645q;
        rectF2.set(0.0f, 0.0f, i, i);
        matrix.setRectToRect(rectF, rectF2, Matrix.ScaleToFit.CENTER);
        int i2 = this.f645q;
        matrix.postScale(f, f, i2 / 2.0f, i2 / 2.0f);
    }

    /* renamed from: b */
    public final void m10780b() {
        if (this.f628A == null) {
            this.f628A = new ViewTreeObserver$OnPreDrawListenerC0066c();
        }
    }

    /* renamed from: a */
    public final void m10787a(MotionSpec motionSpec) {
        this.f632d = motionSpec;
    }

    /* renamed from: a */
    public void mo10753a(float f, float f2, float f3) {
        ShadowDrawableWrapper shadowDrawableWrapper = this.f636h;
        if (shadowDrawableWrapper != null) {
            shadowDrawableWrapper.m10689a(f, this.f644p + f);
            m10756x();
        }
    }

    /* renamed from: a */
    public void mo10750a(int[] iArr) {
        this.f635g.m10661a(iArr);
    }

    /* renamed from: a */
    public void m10783a(Animator.AnimatorListener animatorListener) {
        if (this.f648t == null) {
            this.f648t = new ArrayList<>();
        }
        this.f648t.add(animatorListener);
    }

    /* renamed from: a */
    public void m10785a(InterfaceC0070g interfaceC0070g, boolean z) {
        if (m10764k()) {
            return;
        }
        Animator animator = this.f630b;
        if (animator != null) {
            animator.cancel();
        }
        if (m10759u()) {
            MotionSpec motionSpec = this.f632d;
            if (motionSpec == null) {
                motionSpec = m10772d();
            }
            AnimatorSet m10786a = m10786a(motionSpec, 0.0f, 0.0f, 0.0f);
            m10786a.addListener(new C0064a(z, interfaceC0070g));
            ArrayList<Animator.AnimatorListener> arrayList = this.f648t;
            if (arrayList != null) {
                Iterator<Animator.AnimatorListener> it = arrayList.iterator();
                while (it.hasNext()) {
                    m10786a.addListener(it.next());
                }
            }
            m10786a.start();
            return;
        }
        this.f649u.m10647a(z ? 8 : 4, z);
        if (interfaceC0070g != null) {
            interfaceC0070g.mo7636b();
        }
    }

    /* renamed from: a */
    public final AnimatorSet m10786a(MotionSpec motionSpec, float f, float f2, float f3) {
        ArrayList arrayList = new ArrayList();
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.f649u, View.ALPHA, f);
        motionSpec.m10958a("opacity").m10953a((Animator) ofFloat);
        arrayList.add(ofFloat);
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this.f649u, View.SCALE_X, f2);
        motionSpec.m10958a("scale").m10953a((Animator) ofFloat2);
        arrayList.add(ofFloat2);
        ObjectAnimator ofFloat3 = ObjectAnimator.ofFloat(this.f649u, View.SCALE_Y, f2);
        motionSpec.m10958a("scale").m10953a((Animator) ofFloat3);
        arrayList.add(ofFloat3);
        m10790a(f3, this.f654z);
        ObjectAnimator ofObject = ObjectAnimator.ofObject(this.f649u, new ImageMatrixProperty(), new MatrixEvaluator(), new Matrix(this.f654z));
        motionSpec.m10958a("iconScale").m10953a((Animator) ofObject);
        arrayList.add(ofObject);
        AnimatorSet animatorSet = new AnimatorSet();
        AnimatorSetCompat.m10972a(animatorSet, arrayList);
        return animatorSet;
    }

    /* renamed from: a */
    public void mo10751a(Rect rect) {
        this.f636h.getPadding(rect);
    }

    /* renamed from: a */
    public CircularBorderDrawable m10788a(int i, ColorStateList colorStateList) {
        Context context = this.f649u.getContext();
        CircularBorderDrawable mo10745n = mo10745n();
        mo10745n.m10849a(ContextCompat.m10022a(context, C0041c.design_fab_stroke_top_outer_color), ContextCompat.m10022a(context, C0041c.design_fab_stroke_top_inner_color), ContextCompat.m10022a(context, C0041c.design_fab_stroke_end_inner_color), ContextCompat.m10022a(context, C0041c.design_fab_stroke_end_outer_color));
        mo10745n.m10850a(i);
        mo10745n.m10848a(colorStateList);
        return mo10745n;
    }

    /* renamed from: a */
    public GradientDrawable m10792a() {
        GradientDrawable mo10744o = mo10744o();
        mo10744o.setShape(1);
        mo10744o.setColor(-1);
        return mo10744o;
    }

    /* renamed from: a */
    public final ValueAnimator m10784a(AbstractC0072i abstractC0072i) {
        ValueAnimator valueAnimator = new ValueAnimator();
        valueAnimator.setInterpolator(f621B);
        valueAnimator.setDuration(100L);
        valueAnimator.addListener(abstractC0072i);
        valueAnimator.addUpdateListener(abstractC0072i);
        valueAnimator.setFloatValues(0.0f, 1.0f);
        return valueAnimator;
    }
}
