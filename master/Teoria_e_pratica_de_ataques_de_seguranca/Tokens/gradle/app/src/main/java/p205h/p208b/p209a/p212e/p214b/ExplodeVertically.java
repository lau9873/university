package p205h.p208b.p209a.p212e.p214b;

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
import com.hbb20.C1444R;

@TargetApi(21)
/* renamed from: h.b.a.e.b.a */
/* loaded from: classes.dex */
public class ExplodeVertically extends Visibility {

    /* renamed from: b */
    public static final TimeInterpolator f9728b = new DecelerateInterpolator();

    /* renamed from: c */
    public static final TimeInterpolator f9729c = new AccelerateInterpolator();

    /* renamed from: a */
    public int[] f9730a = new int[2];

    /* compiled from: ExplodeVertically.java */
    /* renamed from: h.b.a.e.b.a$b */
    /* loaded from: classes.dex */
    public static class C2386b extends AnimatorListenerAdapter implements Transition.TransitionListener {

        /* renamed from: a */
        public final View f9731a;

        /* renamed from: b */
        public final View f9732b;

        /* renamed from: c */
        public final int f9733c;

        /* renamed from: d */
        public final int f9734d;

        /* renamed from: e */
        public int[] f9735e;

        /* renamed from: f */
        public float f9736f;

        /* renamed from: g */
        public float f9737g;

        /* renamed from: h */
        public final float f9738h;

        /* renamed from: i */
        public final float f9739i;

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            if (this.f9735e == null) {
                this.f9735e = new int[2];
            }
            this.f9735e[0] = Math.round(this.f9733c + this.f9732b.getTranslationX());
            this.f9735e[1] = Math.round(this.f9734d + this.f9732b.getTranslationY());
            this.f9731a.setTag(C1444R.C1446id.background, this.f9735e);
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorPauseListener
        public void onAnimationPause(Animator animator) {
            this.f9736f = this.f9732b.getTranslationX();
            this.f9737g = this.f9732b.getTranslationY();
            this.f9732b.setTranslationX(this.f9738h);
            this.f9732b.setTranslationY(this.f9739i);
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorPauseListener
        public void onAnimationResume(Animator animator) {
            this.f9732b.setTranslationX(this.f9736f);
            this.f9732b.setTranslationY(this.f9737g);
        }

        @Override // android.transition.Transition.TransitionListener
        public void onTransitionCancel(Transition transition) {
        }

        @Override // android.transition.Transition.TransitionListener
        public void onTransitionEnd(Transition transition) {
            this.f9732b.setTranslationX(this.f9738h);
            this.f9732b.setTranslationY(this.f9739i);
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

        public C2386b(View view, View view2, int i, int i2, float f, float f2) {
            this.f9732b = view;
            this.f9731a = view2;
            this.f9733c = i - Math.round(this.f9732b.getTranslationX());
            this.f9734d = i2 - Math.round(this.f9732b.getTranslationY());
            this.f9738h = f;
            this.f9739i = f2;
            this.f9735e = (int[]) this.f9731a.getTag(C1444R.C1446id.background);
            if (this.f9735e != null) {
                this.f9731a.setTag(C1444R.C1446id.background, null);
            }
        }
    }

    public ExplodeVertically() {
        setPropagation(new CircularPropagation());
    }

    /* renamed from: a */
    public final void m1211a(TransitionValues transitionValues) {
        View view = transitionValues.view;
        view.getLocationOnScreen(this.f9730a);
        int[] iArr = this.f9730a;
        int i = iArr[0];
        int i2 = iArr[1];
        transitionValues.values.put("explode:screenBounds", new Rect(i, i2, view.getWidth() + i, view.getHeight() + i2));
    }

    @Override // android.transition.Visibility, android.transition.Transition
    public void captureEndValues(TransitionValues transitionValues) {
        super.captureEndValues(transitionValues);
        m1211a(transitionValues);
    }

    @Override // android.transition.Visibility, android.transition.Transition
    public void captureStartValues(TransitionValues transitionValues) {
        super.captureStartValues(transitionValues);
        m1211a(transitionValues);
    }

    @Override // android.transition.Visibility
    public Animator onAppear(ViewGroup viewGroup, View view, TransitionValues transitionValues, TransitionValues transitionValues2) {
        if (transitionValues2 == null) {
            return null;
        }
        Rect rect = (Rect) transitionValues2.values.get("explode:screenBounds");
        float translationX = view.getTranslationX();
        float translationY = view.getTranslationY();
        m1210a(viewGroup, rect, this.f9730a);
        int[] iArr = this.f9730a;
        return m1209a(view, transitionValues2, rect.left, rect.top, translationX + iArr[0], translationY + iArr[1], translationX, translationY, f9728b, this);
    }

    @Override // android.transition.Visibility
    public Animator onDisappear(ViewGroup viewGroup, View view, TransitionValues transitionValues, TransitionValues transitionValues2) {
        float f;
        float f2;
        if (transitionValues == null) {
            return null;
        }
        Rect rect = (Rect) transitionValues.values.get("explode:screenBounds");
        int i = rect.left;
        int i2 = rect.top;
        float translationX = view.getTranslationX();
        float translationY = view.getTranslationY();
        int[] iArr = (int[]) transitionValues.view.getTag(C1444R.C1446id.background);
        if (iArr != null) {
            f = (iArr[0] - rect.left) + translationX;
            f2 = (iArr[1] - rect.top) + translationY;
            rect.offsetTo(iArr[0], iArr[1]);
        } else {
            f = translationX;
            f2 = translationY;
        }
        m1210a(viewGroup, rect, this.f9730a);
        int[] iArr2 = this.f9730a;
        return m1209a(view, transitionValues, i, i2, translationX, translationY, f + iArr2[0], f2 + iArr2[1], f9729c, this);
    }

    /* renamed from: a */
    public final void m1210a(View view, Rect rect, int[] iArr) {
        int centerY;
        view.getLocationOnScreen(this.f9730a);
        int i = this.f9730a[1];
        Rect epicenter = getEpicenter();
        if (epicenter == null) {
            centerY = i + (view.getHeight() / 2) + Math.round(view.getTranslationY());
        } else {
            centerY = epicenter.centerY();
        }
        int centerY2 = rect.centerY();
        iArr[0] = 0;
        iArr[1] = centerY2 > centerY ? view.getHeight() + centerY2 : -centerY2;
    }

    /* renamed from: a */
    public static Animator m1209a(View view, TransitionValues transitionValues, int i, int i2, float f, float f2, float f3, float f4, TimeInterpolator timeInterpolator, Transition transition) {
        float f5;
        float f6;
        float translationX = view.getTranslationX();
        float translationY = view.getTranslationY();
        int[] iArr = (int[]) transitionValues.view.getTag(C1444R.C1446id.background);
        if (iArr != null) {
            f5 = (iArr[0] - i) + translationX;
            f6 = (iArr[1] - i2) + translationY;
        } else {
            f5 = f;
            f6 = f2;
        }
        int round = Math.round(f5 - translationX) + i;
        int round2 = Math.round(f6 - translationY) + i2;
        view.setTranslationX(f5);
        view.setTranslationY(f6);
        if (f5 == f3 && f6 == f4) {
            return null;
        }
        Path path = new Path();
        path.moveTo(f5, f6);
        path.lineTo(f3, f4);
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(view, View.TRANSLATION_X, View.TRANSLATION_Y, path);
        C2386b c2386b = new C2386b(view, transitionValues.view, round, round2, translationX, translationY);
        transition.addListener(c2386b);
        ofFloat.addListener(c2386b);
        ofFloat.addPauseListener(c2386b);
        ofFloat.setInterpolator(timeInterpolator);
        return ofFloat;
    }
}
