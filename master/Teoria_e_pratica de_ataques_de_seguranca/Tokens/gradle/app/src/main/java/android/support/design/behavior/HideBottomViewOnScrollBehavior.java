package android.support.design.behavior;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.TimeInterpolator;
import android.content.Context;
import android.support.design.widget.CoordinatorLayout;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewPropertyAnimator;
import p000a.p006b.p012d.p013l.AnimationUtils;

/* loaded from: classes.dex */
public class HideBottomViewOnScrollBehavior<V extends View> extends CoordinatorLayout.AbstractC0575c<V> {

    /* renamed from: a */
    public int f3135a;

    /* renamed from: b */
    public int f3136b;

    /* renamed from: c */
    public ViewPropertyAnimator f3137c;

    /* renamed from: android.support.design.behavior.HideBottomViewOnScrollBehavior$a */
    /* loaded from: classes.dex */
    public class C0522a extends AnimatorListenerAdapter {
        public C0522a() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            HideBottomViewOnScrollBehavior.this.f3137c = null;
        }
    }

    public HideBottomViewOnScrollBehavior() {
        this.f3135a = 0;
        this.f3136b = 2;
    }

    /* renamed from: b */
    public void mo7890b(V v) {
        ViewPropertyAnimator viewPropertyAnimator = this.f3137c;
        if (viewPropertyAnimator != null) {
            viewPropertyAnimator.cancel();
            v.clearAnimation();
        }
        this.f3136b = 2;
        m7920a((HideBottomViewOnScrollBehavior<V>) v, 0, 225L, AnimationUtils.f424d);
    }

    @Override // android.support.design.widget.CoordinatorLayout.AbstractC0575c
    /* renamed from: b */
    public boolean mo7694b(CoordinatorLayout coordinatorLayout, V v, View view, View view2, int i) {
        return i == 2;
    }

    @Override // android.support.design.widget.CoordinatorLayout.AbstractC0575c
    /* renamed from: a */
    public boolean mo7643a(CoordinatorLayout coordinatorLayout, V v, int i) {
        this.f3135a = v.getMeasuredHeight();
        return super.mo7643a(coordinatorLayout, (CoordinatorLayout) v, i);
    }

    public HideBottomViewOnScrollBehavior(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f3135a = 0;
        this.f3136b = 2;
    }

    @Override // android.support.design.widget.CoordinatorLayout.AbstractC0575c
    /* renamed from: a */
    public void mo7701a(CoordinatorLayout coordinatorLayout, V v, View view, int i, int i2, int i3, int i4) {
        if (this.f3136b != 1 && i2 > 0) {
            mo7892a((HideBottomViewOnScrollBehavior<V>) v);
        } else if (this.f3136b == 2 || i2 >= 0) {
        } else {
            mo7890b(v);
        }
    }

    /* renamed from: a */
    public void mo7892a(V v) {
        ViewPropertyAnimator viewPropertyAnimator = this.f3137c;
        if (viewPropertyAnimator != null) {
            viewPropertyAnimator.cancel();
            v.clearAnimation();
        }
        this.f3136b = 1;
        m7920a((HideBottomViewOnScrollBehavior<V>) v, this.f3135a, 175L, AnimationUtils.f423c);
    }

    /* renamed from: a */
    public final void m7920a(V v, int i, long j, TimeInterpolator timeInterpolator) {
        this.f3137c = v.animate().translationY(i).setInterpolator(timeInterpolator).setDuration(j).setListener(new C0522a());
    }
}
