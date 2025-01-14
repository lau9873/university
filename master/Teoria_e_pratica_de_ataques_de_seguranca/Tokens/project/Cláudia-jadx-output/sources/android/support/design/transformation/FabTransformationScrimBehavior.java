package android.support.design.transformation;

import a.b.d.l.b;
import a.b.d.l.i;
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
/* loaded from: classes.dex */
public class FabTransformationScrimBehavior extends ExpandableTransformationBehavior {

    /* renamed from: c  reason: collision with root package name */
    public final i f2097c;

    /* renamed from: d  reason: collision with root package name */
    public final i f2098d;

    /* loaded from: classes.dex */
    public class a extends AnimatorListenerAdapter {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ boolean f2099a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ View f2100b;

        public a(FabTransformationScrimBehavior fabTransformationScrimBehavior, boolean z, View view) {
            this.f2099a = z;
            this.f2100b = view;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            if (this.f2099a) {
                return;
            }
            this.f2100b.setVisibility(4);
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            if (this.f2099a) {
                this.f2100b.setVisibility(0);
            }
        }
    }

    public FabTransformationScrimBehavior() {
        this.f2097c = new i(75L, 150L);
        this.f2098d = new i(0L, 150L);
    }

    @Override // android.support.design.widget.CoordinatorLayout.c
    public boolean a(CoordinatorLayout coordinatorLayout, View view, View view2) {
        return view2 instanceof FloatingActionButton;
    }

    @Override // android.support.design.widget.CoordinatorLayout.c
    public boolean b(CoordinatorLayout coordinatorLayout, View view, MotionEvent motionEvent) {
        return super.b(coordinatorLayout, (CoordinatorLayout) view, motionEvent);
    }

    public final void a(View view, boolean z, boolean z2, List<Animator> list, List<Animator.AnimatorListener> list2) {
        ObjectAnimator ofFloat;
        i iVar = z ? this.f2097c : this.f2098d;
        if (z) {
            if (!z2) {
                view.setAlpha(0.0f);
            }
            ofFloat = ObjectAnimator.ofFloat(view, View.ALPHA, 1.0f);
        } else {
            ofFloat = ObjectAnimator.ofFloat(view, View.ALPHA, 0.0f);
        }
        iVar.a((Animator) ofFloat);
        list.add(ofFloat);
    }

    @Override // android.support.design.transformation.ExpandableTransformationBehavior
    public AnimatorSet b(View view, View view2, boolean z, boolean z2) {
        ArrayList arrayList = new ArrayList();
        a(view2, z, z2, arrayList, new ArrayList());
        AnimatorSet animatorSet = new AnimatorSet();
        b.a(animatorSet, arrayList);
        animatorSet.addListener(new a(this, z, view2));
        return animatorSet;
    }

    public FabTransformationScrimBehavior(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f2097c = new i(75L, 150L);
        this.f2098d = new i(0L, 150L);
    }
}
