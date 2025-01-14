package android.support.design.behavior;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.TimeInterpolator;
import android.content.Context;
import android.support.design.widget.CoordinatorLayout;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewPropertyAnimator;
/* loaded from: classes.dex */
public class HideBottomViewOnScrollBehavior<V extends View> extends CoordinatorLayout.c<V> {

    /* renamed from: a  reason: collision with root package name */
    public int f2061a;

    /* renamed from: b  reason: collision with root package name */
    public int f2062b;

    /* renamed from: c  reason: collision with root package name */
    public ViewPropertyAnimator f2063c;

    /* loaded from: classes.dex */
    public class a extends AnimatorListenerAdapter {
        public a() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            HideBottomViewOnScrollBehavior.this.f2063c = null;
        }
    }

    public HideBottomViewOnScrollBehavior() {
        this.f2061a = 0;
        this.f2062b = 2;
    }

    public void b(V v) {
        ViewPropertyAnimator viewPropertyAnimator = this.f2063c;
        if (viewPropertyAnimator != null) {
            viewPropertyAnimator.cancel();
            v.clearAnimation();
        }
        this.f2062b = 2;
        a((HideBottomViewOnScrollBehavior<V>) v, 0, 225L, a.b.d.l.a.f213d);
    }

    @Override // android.support.design.widget.CoordinatorLayout.c
    public boolean b(CoordinatorLayout coordinatorLayout, V v, View view, View view2, int i2) {
        return i2 == 2;
    }

    @Override // android.support.design.widget.CoordinatorLayout.c
    public boolean a(CoordinatorLayout coordinatorLayout, V v, int i2) {
        this.f2061a = v.getMeasuredHeight();
        return super.a(coordinatorLayout, (CoordinatorLayout) v, i2);
    }

    public HideBottomViewOnScrollBehavior(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f2061a = 0;
        this.f2062b = 2;
    }

    @Override // android.support.design.widget.CoordinatorLayout.c
    public void a(CoordinatorLayout coordinatorLayout, V v, View view, int i2, int i3, int i4, int i5) {
        if (this.f2062b != 1 && i3 > 0) {
            a((HideBottomViewOnScrollBehavior<V>) v);
        } else if (this.f2062b == 2 || i3 >= 0) {
        } else {
            b(v);
        }
    }

    public void a(V v) {
        ViewPropertyAnimator viewPropertyAnimator = this.f2063c;
        if (viewPropertyAnimator != null) {
            viewPropertyAnimator.cancel();
            v.clearAnimation();
        }
        this.f2062b = 1;
        a((HideBottomViewOnScrollBehavior<V>) v, this.f2061a, 175L, a.b.d.l.a.f212c);
    }

    public final void a(V v, int i2, long j, TimeInterpolator timeInterpolator) {
        this.f2063c = v.animate().translationY(i2).setInterpolator(timeInterpolator).setDuration(j).setListener(new a());
    }
}
