package android.support.design.transformation;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.FloatingActionButton;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import java.util.ArrayList;
import java.util.List;
import p000a.p006b.p012d.p013l.AnimatorSetCompat;
import p000a.p006b.p012d.p013l.MotionTiming;

/* loaded from: classes.dex */
public class FabTransformationScrimBehavior extends ExpandableTransformationBehavior {

    /* renamed from: c */
    public final MotionTiming f3192c;

    /* renamed from: d */
    public final MotionTiming f3193d;

    /* renamed from: android.support.design.transformation.FabTransformationScrimBehavior$a */
    /* loaded from: classes.dex */
    public class C0536a extends AnimatorListenerAdapter {

        /* renamed from: a */
        public final /* synthetic */ boolean f3194a;

        /* renamed from: b */
        public final /* synthetic */ View f3195b;

        public C0536a(FabTransformationScrimBehavior fabTransformationScrimBehavior, boolean z, View view) {
            this.f3194a = z;
            this.f3195b = view;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            if (this.f3194a) {
                return;
            }
            this.f3195b.setVisibility(4);
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            if (this.f3194a) {
                this.f3195b.setVisibility(0);
            }
        }
    }

    public FabTransformationScrimBehavior() {
        this.f3192c = new MotionTiming(75L, 150L);
        this.f3193d = new MotionTiming(0L, 150L);
    }

    @Override // android.support.design.widget.CoordinatorLayout.AbstractC0575c
    /* renamed from: a */
    public boolean mo7705a(CoordinatorLayout coordinatorLayout, View view, View view2) {
        return view2 instanceof FloatingActionButton;
    }

    @Override // android.support.design.widget.CoordinatorLayout.AbstractC0575c
    /* renamed from: b */
    public boolean mo7602b(CoordinatorLayout coordinatorLayout, View view, MotionEvent motionEvent) {
        return super.mo7602b(coordinatorLayout, (CoordinatorLayout) view, motionEvent);
    }

    /* renamed from: a */
    public final void m7864a(View view, boolean z, boolean z2, List<Animator> list, List<Animator.AnimatorListener> list2) {
        ObjectAnimator ofFloat;
        MotionTiming motionTiming = z ? this.f3192c : this.f3193d;
        if (z) {
            if (!z2) {
                view.setAlpha(0.0f);
            }
            ofFloat = ObjectAnimator.ofFloat(view, View.ALPHA, 1.0f);
        } else {
            ofFloat = ObjectAnimator.ofFloat(view, View.ALPHA, 0.0f);
        }
        motionTiming.m10953a((Animator) ofFloat);
        list.add(ofFloat);
    }

    @Override // android.support.design.transformation.ExpandableTransformationBehavior
    /* renamed from: b */
    public AnimatorSet mo7863b(View view, View view2, boolean z, boolean z2) {
        ArrayList arrayList = new ArrayList();
        m7864a(view2, z, z2, arrayList, new ArrayList());
        AnimatorSet animatorSet = new AnimatorSet();
        AnimatorSetCompat.m10972a(animatorSet, arrayList);
        animatorSet.addListener(new C0536a(this, z, view2));
        return animatorSet;
    }

    public FabTransformationScrimBehavior(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f3192c = new MotionTiming(75L, 150L);
        this.f3193d = new MotionTiming(0L, 150L);
    }
}
