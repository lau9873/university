package h.b.a.e.b;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.animation.TimeInterpolator;
import android.annotation.TargetApi;
import android.graphics.Path;
import android.graphics.Rect;
import android.transition.CircularPropagation;
import android.transition.Transition;
import android.transition.TransitionValues;
import android.transition.Visibility;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
/* compiled from: ExplodeVertically.java */
@TargetApi(21)
/* loaded from: classes.dex */
public class a extends Visibility {

    /* renamed from: b  reason: collision with root package name */
    public static final TimeInterpolator f7073b = new DecelerateInterpolator();

    /* renamed from: c  reason: collision with root package name */
    public static final TimeInterpolator f7074c = new AccelerateInterpolator();

    /* renamed from: a  reason: collision with root package name */
    public int[] f7075a = new int[2];

    /* compiled from: ExplodeVertically.java */
    /* loaded from: classes.dex */
    public static class b extends AnimatorListenerAdapter implements Transition.TransitionListener {

        /* renamed from: a  reason: collision with root package name */
        public final View f7076a;

        /* renamed from: b  reason: collision with root package name */
        public final View f7077b;

        /* renamed from: c  reason: collision with root package name */
        public final int f7078c;

        /* renamed from: d  reason: collision with root package name */
        public final int f7079d;

        /* renamed from: e  reason: collision with root package name */
        public int[] f7080e;

        /* renamed from: f  reason: collision with root package name */
        public float f7081f;

        /* renamed from: g  reason: collision with root package name */
        public float f7082g;

        /* renamed from: h  reason: collision with root package name */
        public final float f7083h;

        /* renamed from: i  reason: collision with root package name */
        public final float f7084i;

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            if (this.f7080e == null) {
                this.f7080e = new int[2];
            }
            this.f7080e[0] = Math.round(this.f7078c + this.f7077b.getTranslationX());
            this.f7080e[1] = Math.round(this.f7079d + this.f7077b.getTranslationY());
            this.f7076a.setTag(2131230811, this.f7080e);
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorPauseListener
        public void onAnimationPause(Animator animator) {
            this.f7081f = this.f7077b.getTranslationX();
            this.f7082g = this.f7077b.getTranslationY();
            this.f7077b.setTranslationX(this.f7083h);
            this.f7077b.setTranslationY(this.f7084i);
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorPauseListener
        public void onAnimationResume(Animator animator) {
            this.f7077b.setTranslationX(this.f7081f);
            this.f7077b.setTranslationY(this.f7082g);
        }

        @Override // android.transition.Transition.TransitionListener
        public void onTransitionCancel(Transition transition) {
        }

        @Override // android.transition.Transition.TransitionListener
        public void onTransitionEnd(Transition transition) {
            this.f7077b.setTranslationX(this.f7083h);
            this.f7077b.setTranslationY(this.f7084i);
        }

        @Override // android.transition.Transition.TransitionListener
        public void onTransitionPause(Transition transition) {
        }

        @Override // android.transition.Transition.TransitionListener
        public void onTransitionResume(Transition transition) {
        }

        @Override // android.transition.Transition.TransitionListener
        public void onTransitionStart(Transition transition) {
        }

        public b(View view, View view2, int i2, int i3, float f2, float f3) {
            this.f7077b = view;
            this.f7076a = view2;
            this.f7078c = i2 - Math.round(this.f7077b.getTranslationX());
            this.f7079d = i3 - Math.round(this.f7077b.getTranslationY());
            this.f7083h = f2;
            this.f7084i = f3;
            this.f7080e = (int[]) this.f7076a.getTag(2131230811);
            if (this.f7080e != null) {
                this.f7076a.setTag(2131230811, null);
            }
        }
    }

    public a() {
        setPropagation(new CircularPropagation());
    }

    public final void a(TransitionValues transitionValues) {
        View view = transitionValues.view;
        view.getLocationOnScreen(this.f7075a);
        int[] iArr = this.f7075a;
        int i2 = iArr[0];
        int i3 = iArr[1];
        transitionValues.values.put("explode:screenBounds", new Rect(i2, i3, view.getWidth() + i2, view.getHeight() + i3));
    }

    @Override // android.transition.Visibility, android.transition.Transition
    public void captureEndValues(TransitionValues transitionValues) {
        super.captureEndValues(transitionValues);
        a(transitionValues);
    }

    @Override // android.transition.Visibility, android.transition.Transition
    public void captureStartValues(TransitionValues transitionValues) {
        super.captureStartValues(transitionValues);
        a(transitionValues);
    }

    @Override // android.transition.Visibility
    public Animator onAppear(ViewGroup viewGroup, View view, TransitionValues transitionValues, TransitionValues transitionValues2) {
        if (transitionValues2 == null) {
            return null;
        }
        Rect rect = (Rect) transitionValues2.values.get("explode:screenBounds");
        float translationX = view.getTranslationX();
        float translationY = view.getTranslationY();
        a(viewGroup, rect, this.f7075a);
        int[] iArr = this.f7075a;
        return a(view, transitionValues2, rect.left, rect.top, translationX + iArr[0], translationY + iArr[1], translationX, translationY, f7073b, this);
    }

    @Override // android.transition.Visibility
    public Animator onDisappear(ViewGroup viewGroup, View view, TransitionValues transitionValues, TransitionValues transitionValues2) {
        float f2;
        float f3;
        if (transitionValues == null) {
            return null;
        }
        Rect rect = (Rect) transitionValues.values.get("explode:screenBounds");
        int i2 = rect.left;
        int i3 = rect.top;
        float translationX = view.getTranslationX();
        float translationY = view.getTranslationY();
        int[] iArr = (int[]) transitionValues.view.getTag(2131230811);
        if (iArr != null) {
            f2 = (iArr[0] - rect.left) + translationX;
            f3 = (iArr[1] - rect.top) + translationY;
            rect.offsetTo(iArr[0], iArr[1]);
        } else {
            f2 = translationX;
            f3 = translationY;
        }
        a(viewGroup, rect, this.f7075a);
        int[] iArr2 = this.f7075a;
        return a(view, transitionValues, i2, i3, translationX, translationY, f2 + iArr2[0], f3 + iArr2[1], f7074c, this);
    }

    public final void a(View view, Rect rect, int[] iArr) {
        int centerY;
        view.getLocationOnScreen(this.f7075a);
        int i2 = this.f7075a[1];
        Rect epicenter = getEpicenter();
        if (epicenter == null) {
            centerY = i2 + (view.getHeight() / 2) + Math.round(view.getTranslationY());
        } else {
            centerY = epicenter.centerY();
        }
        int centerY2 = rect.centerY();
        iArr[0] = 0;
        iArr[1] = centerY2 > centerY ? view.getHeight() + centerY2 : -centerY2;
    }

    public static Animator a(View view, TransitionValues transitionValues, int i2, int i3, float f2, float f3, float f4, float f5, TimeInterpolator timeInterpolator, Transition transition) {
        float f6;
        float f7;
        float translationX = view.getTranslationX();
        float translationY = view.getTranslationY();
        int[] iArr = (int[]) transitionValues.view.getTag(2131230811);
        if (iArr != null) {
            f6 = (iArr[0] - i2) + translationX;
            f7 = (iArr[1] - i3) + translationY;
        } else {
            f6 = f2;
            f7 = f3;
        }
        int round = Math.round(f6 - translationX) + i2;
        int round2 = Math.round(f7 - translationY) + i3;
        view.setTranslationX(f6);
        view.setTranslationY(f7);
        if (f6 == f4 && f7 == f5) {
            return null;
        }
        Path path = new Path();
        path.moveTo(f6, f7);
        path.lineTo(f4, f5);
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(view, View.TRANSLATION_X, View.TRANSLATION_Y, path);
        b bVar = new b(view, transitionValues.view, round, round2, translationX, translationY);
        transition.addListener(bVar);
        ofFloat.addListener(bVar);
        ofFloat.addPauseListener(bVar);
        ofFloat.setInterpolator(timeInterpolator);
        return ofFloat;
    }
}
