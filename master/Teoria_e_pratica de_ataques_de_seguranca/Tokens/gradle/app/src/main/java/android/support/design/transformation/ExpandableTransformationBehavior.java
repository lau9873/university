package android.support.design.transformation;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;

/* loaded from: classes.dex */
public abstract class ExpandableTransformationBehavior extends ExpandableBehavior {

    /* renamed from: b */
    public AnimatorSet f3177b;

    /* renamed from: android.support.design.transformation.ExpandableTransformationBehavior$a */
    /* loaded from: classes.dex */
    public class C0530a extends AnimatorListenerAdapter {
        public C0530a() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            ExpandableTransformationBehavior.this.f3177b = null;
        }
    }

    public ExpandableTransformationBehavior() {
    }

    /* renamed from: b */
    public abstract AnimatorSet mo7863b(View view, View view2, boolean z, boolean z2);

    public ExpandableTransformationBehavior(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    @Override // android.support.design.transformation.ExpandableBehavior
    /* renamed from: a */
    public boolean mo7861a(View view, View view2, boolean z, boolean z2) {
        boolean z3 = this.f3177b != null;
        if (z3) {
            this.f3177b.cancel();
        }
        this.f3177b = mo7863b(view, view2, z, z3);
        this.f3177b.addListener(new C0530a());
        this.f3177b.start();
        if (!z2) {
            this.f3177b.end();
        }
        return true;
    }
}
