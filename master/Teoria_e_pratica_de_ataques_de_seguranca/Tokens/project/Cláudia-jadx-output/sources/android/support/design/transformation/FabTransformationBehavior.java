package android.support.design.transformation;

import a.b.d.f;
import a.b.d.l.h;
import a.b.d.l.i;
import a.b.d.l.j;
import a.b.d.o.d;
import a.b.d.x.l;
import a.b.g.k.u;
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
/* loaded from: classes.dex */
public abstract class FabTransformationBehavior extends ExpandableTransformationBehavior {

    /* renamed from: c  reason: collision with root package name */
    public final Rect f2084c;

    /* renamed from: d  reason: collision with root package name */
    public final RectF f2085d;

    /* renamed from: e  reason: collision with root package name */
    public final RectF f2086e;

    /* renamed from: f  reason: collision with root package name */
    public final int[] f2087f;

    /* loaded from: classes.dex */
    public class a extends AnimatorListenerAdapter {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ boolean f2088a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ View f2089b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ View f2090c;

        public a(FabTransformationBehavior fabTransformationBehavior, boolean z, View view, View view2) {
            this.f2088a = z;
            this.f2089b = view;
            this.f2090c = view2;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            if (this.f2088a) {
                return;
            }
            this.f2089b.setVisibility(4);
            this.f2090c.setAlpha(1.0f);
            this.f2090c.setVisibility(0);
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            if (this.f2088a) {
                this.f2089b.setVisibility(0);
                this.f2090c.setAlpha(0.0f);
                this.f2090c.setVisibility(4);
            }
        }
    }

    /* loaded from: classes.dex */
    public class b implements ValueAnimator.AnimatorUpdateListener {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ View f2091a;

        public b(FabTransformationBehavior fabTransformationBehavior, View view) {
            this.f2091a = view;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            this.f2091a.invalidate();
        }
    }

    /* loaded from: classes.dex */
    public class c extends AnimatorListenerAdapter {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ a.b.d.o.d f2092a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ Drawable f2093b;

        public c(FabTransformationBehavior fabTransformationBehavior, a.b.d.o.d dVar, Drawable drawable) {
            this.f2092a = dVar;
            this.f2093b = drawable;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            this.f2092a.setCircularRevealOverlayDrawable(null);
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            this.f2092a.setCircularRevealOverlayDrawable(this.f2093b);
        }
    }

    /* loaded from: classes.dex */
    public class d extends AnimatorListenerAdapter {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ a.b.d.o.d f2094a;

        public d(FabTransformationBehavior fabTransformationBehavior, a.b.d.o.d dVar) {
            this.f2094a = dVar;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            d.e revealInfo = this.f2094a.getRevealInfo();
            revealInfo.f257c = Float.MAX_VALUE;
            this.f2094a.setRevealInfo(revealInfo);
        }
    }

    /* loaded from: classes.dex */
    public static class e {

        /* renamed from: a  reason: collision with root package name */
        public h f2095a;

        /* renamed from: b  reason: collision with root package name */
        public j f2096b;
    }

    public FabTransformationBehavior() {
        this.f2084c = new Rect();
        this.f2085d = new RectF();
        this.f2086e = new RectF();
        this.f2087f = new int[2];
    }

    public abstract e a(Context context, boolean z);

    @Override // android.support.design.widget.CoordinatorLayout.c
    public boolean a(CoordinatorLayout coordinatorLayout, View view, View view2) {
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
    public AnimatorSet b(View view, View view2, boolean z, boolean z2) {
        e a2 = a(view2.getContext(), z);
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        if (Build.VERSION.SDK_INT >= 21) {
            c(view, view2, z, z2, a2, arrayList, arrayList2);
        }
        RectF rectF = this.f2085d;
        a(view, view2, z, z2, a2, arrayList, arrayList2, rectF);
        float width = rectF.width();
        float height = rectF.height();
        d(view, view2, z, z2, a2, arrayList, arrayList2);
        a(view, view2, z, z2, a2, width, height, arrayList, arrayList2);
        b(view, view2, z, z2, a2, arrayList, arrayList2);
        a(view, view2, z, z2, a2, arrayList, arrayList2);
        AnimatorSet animatorSet = new AnimatorSet();
        a.b.d.l.b.a(animatorSet, arrayList);
        animatorSet.addListener(new a(this, z, view2, view));
        int size = arrayList2.size();
        for (int i2 = 0; i2 < size; i2++) {
            animatorSet.addListener(arrayList2.get(i2));
        }
        return animatorSet;
    }

    @TargetApi(21)
    public final void c(View view, View view2, boolean z, boolean z2, e eVar, List<Animator> list, List<Animator.AnimatorListener> list2) {
        ObjectAnimator ofFloat;
        float g2 = u.g(view2) - u.g(view);
        if (z) {
            if (!z2) {
                view2.setTranslationZ(-g2);
            }
            ofFloat = ObjectAnimator.ofFloat(view2, View.TRANSLATION_Z, 0.0f);
        } else {
            ofFloat = ObjectAnimator.ofFloat(view2, View.TRANSLATION_Z, -g2);
        }
        eVar.f2095a.a("elevation").a((Animator) ofFloat);
        list.add(ofFloat);
    }

    public final void d(View view, View view2, boolean z, boolean z2, e eVar, List<Animator> list, List<Animator.AnimatorListener> list2) {
        ObjectAnimator ofInt;
        if ((view2 instanceof a.b.d.o.d) && (view instanceof ImageView)) {
            a.b.d.o.d dVar = (a.b.d.o.d) view2;
            Drawable drawable = ((ImageView) view).getDrawable();
            if (drawable == null) {
                return;
            }
            drawable.mutate();
            if (z) {
                if (!z2) {
                    drawable.setAlpha(255);
                }
                ofInt = ObjectAnimator.ofInt(drawable, a.b.d.l.e.f217b, 0);
            } else {
                ofInt = ObjectAnimator.ofInt(drawable, a.b.d.l.e.f217b, 255);
            }
            ofInt.addUpdateListener(new b(this, view2));
            eVar.f2095a.a("iconFade").a((Animator) ofInt);
            list.add(ofInt);
            list2.add(new c(this, dVar, drawable));
        }
    }

    public FabTransformationBehavior(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f2084c = new Rect();
        this.f2085d = new RectF();
        this.f2086e = new RectF();
        this.f2087f = new int[2];
    }

    @Override // android.support.design.widget.CoordinatorLayout.c
    public void a(CoordinatorLayout.f fVar) {
        if (fVar.f2192h == 0) {
            fVar.f2192h = 80;
        }
    }

    public final float c(View view, View view2, j jVar) {
        float centerX;
        float centerX2;
        float f2;
        RectF rectF = this.f2085d;
        RectF rectF2 = this.f2086e;
        a(view, rectF);
        a(view2, rectF2);
        int i2 = jVar.f229a & 7;
        if (i2 == 1) {
            centerX = rectF2.centerX();
            centerX2 = rectF.centerX();
        } else if (i2 == 3) {
            centerX = rectF2.left;
            centerX2 = rectF.left;
        } else if (i2 == 5) {
            centerX = rectF2.right;
            centerX2 = rectF.right;
        } else {
            f2 = 0.0f;
            return f2 + jVar.f230b;
        }
        f2 = centerX - centerX2;
        return f2 + jVar.f230b;
    }

    public final void a(View view, View view2, boolean z, boolean z2, e eVar, List<Animator> list, List<Animator.AnimatorListener> list2, RectF rectF) {
        i a2;
        i a3;
        ObjectAnimator ofFloat;
        ObjectAnimator ofFloat2;
        int i2;
        float c2 = c(view, view2, eVar.f2096b);
        float d2 = d(view, view2, eVar.f2096b);
        if (c2 == 0.0f || d2 == 0.0f) {
            a2 = eVar.f2095a.a("translationXLinear");
            a3 = eVar.f2095a.a("translationYLinear");
        } else if ((z && d2 < 0.0f) || (!z && i2 > 0)) {
            a2 = eVar.f2095a.a("translationXCurveUpwards");
            a3 = eVar.f2095a.a("translationYCurveUpwards");
        } else {
            a2 = eVar.f2095a.a("translationXCurveDownwards");
            a3 = eVar.f2095a.a("translationYCurveDownwards");
        }
        i iVar = a2;
        i iVar2 = a3;
        if (z) {
            if (!z2) {
                view2.setTranslationX(-c2);
                view2.setTranslationY(-d2);
            }
            ofFloat = ObjectAnimator.ofFloat(view2, View.TRANSLATION_X, 0.0f);
            ofFloat2 = ObjectAnimator.ofFloat(view2, View.TRANSLATION_Y, 0.0f);
            a(view2, eVar, iVar, iVar2, -c2, -d2, 0.0f, 0.0f, rectF);
        } else {
            ofFloat = ObjectAnimator.ofFloat(view2, View.TRANSLATION_X, -c2);
            ofFloat2 = ObjectAnimator.ofFloat(view2, View.TRANSLATION_Y, -d2);
        }
        iVar.a((Animator) ofFloat);
        iVar2.a((Animator) ofFloat2);
        list.add(ofFloat);
        list.add(ofFloat2);
    }

    public final float d(View view, View view2, j jVar) {
        float centerY;
        float centerY2;
        float f2;
        RectF rectF = this.f2085d;
        RectF rectF2 = this.f2086e;
        a(view, rectF);
        a(view2, rectF2);
        int i2 = jVar.f229a & 112;
        if (i2 == 16) {
            centerY = rectF2.centerY();
            centerY2 = rectF.centerY();
        } else if (i2 == 48) {
            centerY = rectF2.top;
            centerY2 = rectF.top;
        } else if (i2 == 80) {
            centerY = rectF2.bottom;
            centerY2 = rectF.bottom;
        } else {
            f2 = 0.0f;
            return f2 + jVar.f231c;
        }
        f2 = centerY - centerY2;
        return f2 + jVar.f231c;
    }

    public final ViewGroup c(View view) {
        if (view instanceof ViewGroup) {
            return (ViewGroup) view;
        }
        return null;
    }

    public final void b(View view, View view2, boolean z, boolean z2, e eVar, List<Animator> list, List<Animator.AnimatorListener> list2) {
        ObjectAnimator ofInt;
        if (view2 instanceof a.b.d.o.d) {
            a.b.d.o.d dVar = (a.b.d.o.d) view2;
            int b2 = b(view);
            int i2 = 16777215 & b2;
            if (z) {
                if (!z2) {
                    dVar.setCircularRevealScrimColor(b2);
                }
                ofInt = ObjectAnimator.ofInt(dVar, d.C0004d.f254a, i2);
            } else {
                ofInt = ObjectAnimator.ofInt(dVar, d.C0004d.f254a, b2);
            }
            ofInt.setEvaluator(a.b.d.l.c.a());
            eVar.f2095a.a("color").a((Animator) ofInt);
            list.add(ofInt);
        }
    }

    public final void a(View view, View view2, boolean z, boolean z2, e eVar, float f2, float f3, List<Animator> list, List<Animator.AnimatorListener> list2) {
        Animator animator;
        if (view2 instanceof a.b.d.o.d) {
            a.b.d.o.d dVar = (a.b.d.o.d) view2;
            float a2 = a(view, view2, eVar.f2096b);
            float b2 = b(view, view2, eVar.f2096b);
            ((FloatingActionButton) view).a(this.f2084c);
            float width = this.f2084c.width() / 2.0f;
            i a3 = eVar.f2095a.a("expansion");
            if (z) {
                if (!z2) {
                    dVar.setRevealInfo(new d.e(a2, b2, width));
                }
                if (z2) {
                    width = dVar.getRevealInfo().f257c;
                }
                animator = a.b.d.o.a.a(dVar, a2, b2, l.a(a2, b2, 0.0f, 0.0f, f2, f3));
                animator.addListener(new d(this, dVar));
                a(view2, a3.a(), (int) a2, (int) b2, width, list);
            } else {
                float f4 = dVar.getRevealInfo().f257c;
                Animator a4 = a.b.d.o.a.a(dVar, a2, b2, width);
                int i2 = (int) a2;
                int i3 = (int) b2;
                a(view2, a3.a(), i2, i3, f4, list);
                a(view2, a3.a(), a3.b(), eVar.f2095a.a(), i2, i3, width, list);
                animator = a4;
            }
            a3.a(animator);
            list.add(animator);
            list2.add(a.b.d.o.a.a(dVar));
        }
    }

    public final float b(View view, View view2, j jVar) {
        RectF rectF = this.f2085d;
        RectF rectF2 = this.f2086e;
        a(view, rectF);
        a(view2, rectF2);
        rectF2.offset(0.0f, -d(view, view2, jVar));
        return rectF.centerY() - rectF2.top;
    }

    public final int b(View view) {
        ColorStateList c2 = u.c(view);
        if (c2 != null) {
            return c2.getColorForState(view.getDrawableState(), c2.getDefaultColor());
        }
        return 0;
    }

    public final void a(View view, View view2, boolean z, boolean z2, e eVar, List<Animator> list, List<Animator.AnimatorListener> list2) {
        ViewGroup a2;
        ObjectAnimator ofFloat;
        if (view2 instanceof ViewGroup) {
            if (((view2 instanceof a.b.d.o.d) && a.b.d.o.c.f250a == 0) || (a2 = a(view2)) == null) {
                return;
            }
            if (z) {
                if (!z2) {
                    a.b.d.l.d.f216a.set(a2, Float.valueOf(0.0f));
                }
                ofFloat = ObjectAnimator.ofFloat(a2, a.b.d.l.d.f216a, 1.0f);
            } else {
                ofFloat = ObjectAnimator.ofFloat(a2, a.b.d.l.d.f216a, 0.0f);
            }
            eVar.f2095a.a("contentFade").a((Animator) ofFloat);
            list.add(ofFloat);
        }
    }

    public final void a(View view, RectF rectF) {
        rectF.set(0.0f, 0.0f, view.getWidth(), view.getHeight());
        int[] iArr = this.f2087f;
        view.getLocationInWindow(iArr);
        rectF.offsetTo(iArr[0], iArr[1]);
        rectF.offset((int) (-view.getTranslationX()), (int) (-view.getTranslationY()));
    }

    public final float a(View view, View view2, j jVar) {
        RectF rectF = this.f2085d;
        RectF rectF2 = this.f2086e;
        a(view, rectF);
        a(view2, rectF2);
        rectF2.offset(-c(view, view2, jVar), 0.0f);
        return rectF.centerX() - rectF2.left;
    }

    public final void a(View view, e eVar, i iVar, i iVar2, float f2, float f3, float f4, float f5, RectF rectF) {
        float a2 = a(eVar, iVar, f2, f4);
        float a3 = a(eVar, iVar2, f3, f5);
        Rect rect = this.f2084c;
        view.getWindowVisibleDisplayFrame(rect);
        RectF rectF2 = this.f2085d;
        rectF2.set(rect);
        RectF rectF3 = this.f2086e;
        a(view, rectF3);
        rectF3.offset(a2, a3);
        rectF3.intersect(rectF2);
        rectF.set(rectF3);
    }

    public final float a(e eVar, i iVar, float f2, float f3) {
        long a2 = iVar.a();
        long b2 = iVar.b();
        i a3 = eVar.f2095a.a("expansion");
        return a.b.d.l.a.a(f2, f3, iVar.c().getInterpolation(((float) (((a3.a() + a3.b()) + 17) - a2)) / ((float) b2)));
    }

    public final ViewGroup a(View view) {
        View findViewById = view.findViewById(f.mtrl_child_content_container);
        if (findViewById != null) {
            return c(findViewById);
        }
        if (!(view instanceof a.b.d.w.b) && !(view instanceof a.b.d.w.a)) {
            return c(view);
        }
        return c(((ViewGroup) view).getChildAt(0));
    }

    public final void a(View view, long j, int i2, int i3, float f2, List<Animator> list) {
        if (Build.VERSION.SDK_INT < 21 || j <= 0) {
            return;
        }
        Animator createCircularReveal = ViewAnimationUtils.createCircularReveal(view, i2, i3, f2, f2);
        createCircularReveal.setStartDelay(0L);
        createCircularReveal.setDuration(j);
        list.add(createCircularReveal);
    }

    public final void a(View view, long j, long j2, long j3, int i2, int i3, float f2, List<Animator> list) {
        if (Build.VERSION.SDK_INT >= 21) {
            long j4 = j + j2;
            if (j4 < j3) {
                Animator createCircularReveal = ViewAnimationUtils.createCircularReveal(view, i2, i3, f2, f2);
                createCircularReveal.setStartDelay(j4);
                createCircularReveal.setDuration(j3 - j4);
                list.add(createCircularReveal);
            }
        }
    }
}
