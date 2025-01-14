package android.support.design.transformation;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.FloatingActionButton;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewAnimationUtils;
import android.view.ViewGroup;
import android.widget.ImageView;
import java.util.ArrayList;
import java.util.List;
import p000a.p006b.p012d.C0044f;
import p000a.p006b.p012d.p013l.AnimationUtils;
import p000a.p006b.p012d.p013l.AnimatorSetCompat;
import p000a.p006b.p012d.p013l.ArgbEvaluatorCompat;
import p000a.p006b.p012d.p013l.ChildrenAlphaProperty;
import p000a.p006b.p012d.p013l.DrawableAlphaProperty;
import p000a.p006b.p012d.p013l.MotionSpec;
import p000a.p006b.p012d.p013l.MotionTiming;
import p000a.p006b.p012d.p013l.Positioning;
import p000a.p006b.p012d.p016o.CircularRevealCompat;
import p000a.p006b.p012d.p016o.CircularRevealHelper;
import p000a.p006b.p012d.p016o.CircularRevealWidget;
import p000a.p006b.p012d.p025w.TransformationChildCard;
import p000a.p006b.p012d.p025w.TransformationChildLayout;
import p000a.p006b.p012d.p026x.MathUtils;
import p000a.p006b.p030g.p045k.ViewCompat;

/* loaded from: classes.dex */
public abstract class FabTransformationBehavior extends ExpandableTransformationBehavior {

    /* renamed from: c */
    public final Rect f3179c;

    /* renamed from: d */
    public final RectF f3180d;

    /* renamed from: e */
    public final RectF f3181e;

    /* renamed from: f */
    public final int[] f3182f;

    /* renamed from: android.support.design.transformation.FabTransformationBehavior$a */
    /* loaded from: classes.dex */
    public class C0531a extends AnimatorListenerAdapter {

        /* renamed from: a */
        public final /* synthetic */ boolean f3183a;

        /* renamed from: b */
        public final /* synthetic */ View f3184b;

        /* renamed from: c */
        public final /* synthetic */ View f3185c;

        public C0531a(FabTransformationBehavior fabTransformationBehavior, boolean z, View view, View view2) {
            this.f3183a = z;
            this.f3184b = view;
            this.f3185c = view2;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            if (this.f3183a) {
                return;
            }
            this.f3184b.setVisibility(4);
            this.f3185c.setAlpha(1.0f);
            this.f3185c.setVisibility(0);
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            if (this.f3183a) {
                this.f3184b.setVisibility(0);
                this.f3185c.setAlpha(0.0f);
                this.f3185c.setVisibility(4);
            }
        }
    }

    /* renamed from: android.support.design.transformation.FabTransformationBehavior$b */
    /* loaded from: classes.dex */
    public class C0532b implements ValueAnimator.AnimatorUpdateListener {

        /* renamed from: a */
        public final /* synthetic */ View f3186a;

        public C0532b(FabTransformationBehavior fabTransformationBehavior, View view) {
            this.f3186a = view;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            this.f3186a.invalidate();
        }
    }

    /* renamed from: android.support.design.transformation.FabTransformationBehavior$c */
    /* loaded from: classes.dex */
    public class C0533c extends AnimatorListenerAdapter {

        /* renamed from: a */
        public final /* synthetic */ CircularRevealWidget f3187a;

        /* renamed from: b */
        public final /* synthetic */ Drawable f3188b;

        public C0533c(FabTransformationBehavior fabTransformationBehavior, CircularRevealWidget circularRevealWidget, Drawable drawable) {
            this.f3187a = circularRevealWidget;
            this.f3188b = drawable;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            this.f3187a.setCircularRevealOverlayDrawable(null);
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            this.f3187a.setCircularRevealOverlayDrawable(this.f3188b);
        }
    }

    /* renamed from: android.support.design.transformation.FabTransformationBehavior$d */
    /* loaded from: classes.dex */
    public class C0534d extends AnimatorListenerAdapter {

        /* renamed from: a */
        public final /* synthetic */ CircularRevealWidget f3189a;

        public C0534d(FabTransformationBehavior fabTransformationBehavior, CircularRevealWidget circularRevealWidget) {
            this.f3189a = circularRevealWidget;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            CircularRevealWidget.C0056e revealInfo = this.f3189a.getRevealInfo();
            revealInfo.f483c = Float.MAX_VALUE;
            this.f3189a.setRevealInfo(revealInfo);
        }
    }

    /* renamed from: android.support.design.transformation.FabTransformationBehavior$e */
    /* loaded from: classes.dex */
    public static class C0535e {

        /* renamed from: a */
        public MotionSpec f3190a;

        /* renamed from: b */
        public Positioning f3191b;
    }

    public FabTransformationBehavior() {
        this.f3179c = new Rect();
        this.f3180d = new RectF();
        this.f3181e = new RectF();
        this.f3182f = new int[2];
    }

    /* renamed from: a */
    public abstract C0535e mo7862a(Context context, boolean z);

    @Override // android.support.design.widget.CoordinatorLayout.AbstractC0575c
    /* renamed from: a */
    public boolean mo7705a(CoordinatorLayout coordinatorLayout, View view, View view2) {
        if (view.getVisibility() != 8) {
            if (view2 instanceof FloatingActionButton) {
                int expandedComponentIdHint = ((FloatingActionButton) view2).getExpandedComponentIdHint();
                return expandedComponentIdHint == 0 || expandedComponentIdHint == view.getId();
            }
            return false;
        }
        throw new IllegalStateException("This behavior cannot be attached to a GONE view. Set the view to INVISIBLE instead.");
    }

    @Override // android.support.design.transformation.ExpandableTransformationBehavior
    /* renamed from: b */
    public AnimatorSet mo7863b(View view, View view2, boolean z, boolean z2) {
        C0535e mo7862a = mo7862a(view2.getContext(), z);
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        if (Build.VERSION.SDK_INT >= 21) {
            m7867c(view, view2, z, z2, mo7862a, arrayList, arrayList2);
        }
        RectF rectF = this.f3180d;
        m7873a(view, view2, z, z2, mo7862a, arrayList, arrayList2, rectF);
        float width = rectF.width();
        float height = rectF.height();
        m7865d(view, view2, z, z2, mo7862a, arrayList, arrayList2);
        m7875a(view, view2, z, z2, mo7862a, width, height, arrayList, arrayList2);
        m7870b(view, view2, z, z2, mo7862a, arrayList, arrayList2);
        m7874a(view, view2, z, z2, mo7862a, arrayList, arrayList2);
        AnimatorSet animatorSet = new AnimatorSet();
        AnimatorSetCompat.m10972a(animatorSet, arrayList);
        animatorSet.addListener(new C0531a(this, z, view2, view));
        int size = arrayList2.size();
        for (int i = 0; i < size; i++) {
            animatorSet.addListener(arrayList2.get(i));
        }
        return animatorSet;
    }

    @TargetApi(21)
    /* renamed from: c */
    public final void m7867c(View view, View view2, boolean z, boolean z2, C0535e c0535e, List<Animator> list, List<Animator.AnimatorListener> list2) {
        ObjectAnimator ofFloat;
        float m9428g = ViewCompat.m9428g(view2) - ViewCompat.m9428g(view);
        if (z) {
            if (!z2) {
                view2.setTranslationZ(-m9428g);
            }
            ofFloat = ObjectAnimator.ofFloat(view2, View.TRANSLATION_Z, 0.0f);
        } else {
            ofFloat = ObjectAnimator.ofFloat(view2, View.TRANSLATION_Z, -m9428g);
        }
        c0535e.f3190a.m10958a("elevation").m10953a((Animator) ofFloat);
        list.add(ofFloat);
    }

    /* renamed from: d */
    public final void m7865d(View view, View view2, boolean z, boolean z2, C0535e c0535e, List<Animator> list, List<Animator.AnimatorListener> list2) {
        ObjectAnimator ofInt;
        if ((view2 instanceof CircularRevealWidget) && (view instanceof ImageView)) {
            CircularRevealWidget circularRevealWidget = (CircularRevealWidget) view2;
            Drawable drawable = ((ImageView) view).getDrawable();
            if (drawable == null) {
                return;
            }
            drawable.mutate();
            if (z) {
                if (!z2) {
                    drawable.setAlpha(255);
                }
                ofInt = ObjectAnimator.ofInt(drawable, DrawableAlphaProperty.f428b, 0);
            } else {
                ofInt = ObjectAnimator.ofInt(drawable, DrawableAlphaProperty.f428b, 255);
            }
            ofInt.addUpdateListener(new C0532b(this, view2));
            c0535e.f3190a.m10958a("iconFade").m10953a((Animator) ofInt);
            list.add(ofInt);
            list2.add(new C0533c(this, circularRevealWidget, drawable));
        }
    }

    public FabTransformationBehavior(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f3179c = new Rect();
        this.f3180d = new RectF();
        this.f3181e = new RectF();
        this.f3182f = new int[2];
    }

    @Override // android.support.design.widget.CoordinatorLayout.AbstractC0575c
    /* renamed from: a */
    public void mo7649a(CoordinatorLayout.C0578f c0578f) {
        if (c0578f.f3334h == 0) {
            c0578f.f3334h = 80;
        }
    }

    /* renamed from: c */
    public final float m7868c(View view, View view2, Positioning positioning) {
        float centerX;
        float centerX2;
        float f;
        RectF rectF = this.f3180d;
        RectF rectF2 = this.f3181e;
        m7878a(view, rectF);
        m7878a(view2, rectF2);
        int i = positioning.f440a & 7;
        if (i == 1) {
            centerX = rectF2.centerX();
            centerX2 = rectF.centerX();
        } else if (i == 3) {
            centerX = rectF2.left;
            centerX2 = rectF.left;
        } else if (i == 5) {
            centerX = rectF2.right;
            centerX2 = rectF.right;
        } else {
            f = 0.0f;
            return f + positioning.f441b;
        }
        f = centerX - centerX2;
        return f + positioning.f441b;
    }

    /* renamed from: a */
    public final void m7873a(View view, View view2, boolean z, boolean z2, C0535e c0535e, List<Animator> list, List<Animator.AnimatorListener> list2, RectF rectF) {
        MotionTiming m10958a;
        MotionTiming m10958a2;
        ObjectAnimator ofFloat;
        ObjectAnimator ofFloat2;
        int i;
        float m7868c = m7868c(view, view2, c0535e.f3191b);
        float m7866d = m7866d(view, view2, c0535e.f3191b);
        if (m7868c == 0.0f || m7866d == 0.0f) {
            m10958a = c0535e.f3190a.m10958a("translationXLinear");
            m10958a2 = c0535e.f3190a.m10958a("translationYLinear");
        } else if ((z && m7866d < 0.0f) || (!z && i > 0)) {
            m10958a = c0535e.f3190a.m10958a("translationXCurveUpwards");
            m10958a2 = c0535e.f3190a.m10958a("translationYCurveUpwards");
        } else {
            m10958a = c0535e.f3190a.m10958a("translationXCurveDownwards");
            m10958a2 = c0535e.f3190a.m10958a("translationYCurveDownwards");
        }
        MotionTiming motionTiming = m10958a;
        MotionTiming motionTiming2 = m10958a2;
        if (z) {
            if (!z2) {
                view2.setTranslationX(-m7868c);
                view2.setTranslationY(-m7866d);
            }
            ofFloat = ObjectAnimator.ofFloat(view2, View.TRANSLATION_X, 0.0f);
            ofFloat2 = ObjectAnimator.ofFloat(view2, View.TRANSLATION_Y, 0.0f);
            m7877a(view2, c0535e, motionTiming, motionTiming2, -m7868c, -m7866d, 0.0f, 0.0f, rectF);
        } else {
            ofFloat = ObjectAnimator.ofFloat(view2, View.TRANSLATION_X, -m7868c);
            ofFloat2 = ObjectAnimator.ofFloat(view2, View.TRANSLATION_Y, -m7866d);
        }
        motionTiming.m10953a((Animator) ofFloat);
        motionTiming2.m10953a((Animator) ofFloat2);
        list.add(ofFloat);
        list.add(ofFloat2);
    }

    /* renamed from: d */
    public final float m7866d(View view, View view2, Positioning positioning) {
        float centerY;
        float centerY2;
        float f;
        RectF rectF = this.f3180d;
        RectF rectF2 = this.f3181e;
        m7878a(view, rectF);
        m7878a(view2, rectF2);
        int i = positioning.f440a & 112;
        if (i == 16) {
            centerY = rectF2.centerY();
            centerY2 = rectF.centerY();
        } else if (i == 48) {
            centerY = rectF2.top;
            centerY2 = rectF.top;
        } else if (i == 80) {
            centerY = rectF2.bottom;
            centerY2 = rectF.bottom;
        } else {
            f = 0.0f;
            return f + positioning.f442c;
        }
        f = centerY - centerY2;
        return f + positioning.f442c;
    }

    /* renamed from: c */
    public final ViewGroup m7869c(View view) {
        if (view instanceof ViewGroup) {
            return (ViewGroup) view;
        }
        return null;
    }

    /* renamed from: b */
    public final void m7870b(View view, View view2, boolean z, boolean z2, C0535e c0535e, List<Animator> list, List<Animator.AnimatorListener> list2) {
        ObjectAnimator ofInt;
        if (view2 instanceof CircularRevealWidget) {
            CircularRevealWidget circularRevealWidget = (CircularRevealWidget) view2;
            int m7872b = m7872b(view);
            int i = 16777215 & m7872b;
            if (z) {
                if (!z2) {
                    circularRevealWidget.setCircularRevealScrimColor(m7872b);
                }
                ofInt = ObjectAnimator.ofInt(circularRevealWidget, CircularRevealWidget.C0055d.f480a, i);
            } else {
                ofInt = ObjectAnimator.ofInt(circularRevealWidget, CircularRevealWidget.C0055d.f480a, m7872b);
            }
            ofInt.setEvaluator(ArgbEvaluatorCompat.m10971a());
            c0535e.f3190a.m10958a("color").m10953a((Animator) ofInt);
            list.add(ofInt);
        }
    }

    /* renamed from: a */
    public final void m7875a(View view, View view2, boolean z, boolean z2, C0535e c0535e, float f, float f2, List<Animator> list, List<Animator.AnimatorListener> list2) {
        Animator animator;
        if (view2 instanceof CircularRevealWidget) {
            CircularRevealWidget circularRevealWidget = (CircularRevealWidget) view2;
            float m7876a = m7876a(view, view2, c0535e.f3191b);
            float m7871b = m7871b(view, view2, c0535e.f3191b);
            ((FloatingActionButton) view).m7663a(this.f3179c);
            float width = this.f3179c.width() / 2.0f;
            MotionTiming m10958a = c0535e.f3190a.m10958a("expansion");
            if (z) {
                if (!z2) {
                    circularRevealWidget.setRevealInfo(new CircularRevealWidget.C0056e(m7876a, m7871b, width));
                }
                if (z2) {
                    width = circularRevealWidget.getRevealInfo().f483c;
                }
                animator = CircularRevealCompat.m10908a(circularRevealWidget, m7876a, m7871b, MathUtils.m10692a(m7876a, m7871b, 0.0f, 0.0f, f, f2));
                animator.addListener(new C0534d(this, circularRevealWidget));
                m7880a(view2, m10958a.m10954a(), (int) m7876a, (int) m7871b, width, list);
            } else {
                float f3 = circularRevealWidget.getRevealInfo().f483c;
                Animator m10908a = CircularRevealCompat.m10908a(circularRevealWidget, m7876a, m7871b, width);
                int i = (int) m7876a;
                int i2 = (int) m7871b;
                m7880a(view2, m10958a.m10954a(), i, i2, f3, list);
                m7879a(view2, m10958a.m10954a(), m10958a.m10951b(), c0535e.f3190a.m10962a(), i, i2, width, list);
                animator = m10908a;
            }
            m10958a.m10953a(animator);
            list.add(animator);
            list2.add(CircularRevealCompat.m10909a(circularRevealWidget));
        }
    }

    /* renamed from: b */
    public final float m7871b(View view, View view2, Positioning positioning) {
        RectF rectF = this.f3180d;
        RectF rectF2 = this.f3181e;
        m7878a(view, rectF);
        m7878a(view2, rectF2);
        rectF2.offset(0.0f, -m7866d(view, view2, positioning));
        return rectF.centerY() - rectF2.top;
    }

    /* renamed from: b */
    public final int m7872b(View view) {
        ColorStateList m9436c = ViewCompat.m9436c(view);
        if (m9436c != null) {
            return m9436c.getColorForState(view.getDrawableState(), m9436c.getDefaultColor());
        }
        return 0;
    }

    /* renamed from: a */
    public final void m7874a(View view, View view2, boolean z, boolean z2, C0535e c0535e, List<Animator> list, List<Animator.AnimatorListener> list2) {
        ViewGroup m7881a;
        ObjectAnimator ofFloat;
        if (view2 instanceof ViewGroup) {
            if (((view2 instanceof CircularRevealWidget) && CircularRevealHelper.f476a == 0) || (m7881a = m7881a(view2)) == null) {
                return;
            }
            if (z) {
                if (!z2) {
                    ChildrenAlphaProperty.f427a.set(m7881a, Float.valueOf(0.0f));
                }
                ofFloat = ObjectAnimator.ofFloat(m7881a, ChildrenAlphaProperty.f427a, 1.0f);
            } else {
                ofFloat = ObjectAnimator.ofFloat(m7881a, ChildrenAlphaProperty.f427a, 0.0f);
            }
            c0535e.f3190a.m10958a("contentFade").m10953a((Animator) ofFloat);
            list.add(ofFloat);
        }
    }

    /* renamed from: a */
    public final void m7878a(View view, RectF rectF) {
        rectF.set(0.0f, 0.0f, view.getWidth(), view.getHeight());
        int[] iArr = this.f3182f;
        view.getLocationInWindow(iArr);
        rectF.offsetTo(iArr[0], iArr[1]);
        rectF.offset((int) (-view.getTranslationX()), (int) (-view.getTranslationY()));
    }

    /* renamed from: a */
    public final float m7876a(View view, View view2, Positioning positioning) {
        RectF rectF = this.f3180d;
        RectF rectF2 = this.f3181e;
        m7878a(view, rectF);
        m7878a(view2, rectF2);
        rectF2.offset(-m7868c(view, view2, positioning), 0.0f);
        return rectF.centerX() - rectF2.left;
    }

    /* renamed from: a */
    public final void m7877a(View view, C0535e c0535e, MotionTiming motionTiming, MotionTiming motionTiming2, float f, float f2, float f3, float f4, RectF rectF) {
        float m7882a = m7882a(c0535e, motionTiming, f, f3);
        float m7882a2 = m7882a(c0535e, motionTiming2, f2, f4);
        Rect rect = this.f3179c;
        view.getWindowVisibleDisplayFrame(rect);
        RectF rectF2 = this.f3180d;
        rectF2.set(rect);
        RectF rectF3 = this.f3181e;
        m7878a(view, rectF3);
        rectF3.offset(m7882a, m7882a2);
        rectF3.intersect(rectF2);
        rectF.set(rectF3);
    }

    /* renamed from: a */
    public final float m7882a(C0535e c0535e, MotionTiming motionTiming, float f, float f2) {
        long m10954a = motionTiming.m10954a();
        long m10951b = motionTiming.m10951b();
        MotionTiming m10958a = c0535e.f3190a.m10958a("expansion");
        return AnimationUtils.m10973a(f, f2, motionTiming.m10949c().getInterpolation(((float) (((m10958a.m10954a() + m10958a.m10951b()) + 17) - m10954a)) / ((float) m10951b)));
    }

    /* renamed from: a */
    public final ViewGroup m7881a(View view) {
        View findViewById = view.findViewById(C0044f.mtrl_child_content_container);
        if (findViewById != null) {
            return m7869c(findViewById);
        }
        if (!(view instanceof TransformationChildLayout) && !(view instanceof TransformationChildCard)) {
            return m7869c(view);
        }
        return m7869c(((ViewGroup) view).getChildAt(0));
    }

    /* renamed from: a */
    public final void m7880a(View view, long j, int i, int i2, float f, List<Animator> list) {
        if (Build.VERSION.SDK_INT < 21 || j <= 0) {
            return;
        }
        Animator createCircularReveal = ViewAnimationUtils.createCircularReveal(view, i, i2, f, f);
        createCircularReveal.setStartDelay(0L);
        createCircularReveal.setDuration(j);
        list.add(createCircularReveal);
    }

    /* renamed from: a */
    public final void m7879a(View view, long j, long j2, long j3, int i, int i2, float f, List<Animator> list) {
        if (Build.VERSION.SDK_INT >= 21) {
            long j4 = j + j2;
            if (j4 < j3) {
                Animator createCircularReveal = ViewAnimationUtils.createCircularReveal(view, i, i2, f, f);
                createCircularReveal.setStartDelay(j4);
                createCircularReveal.setDuration(j3 - j4);
                list.add(createCircularReveal);
            }
        }
    }
}
