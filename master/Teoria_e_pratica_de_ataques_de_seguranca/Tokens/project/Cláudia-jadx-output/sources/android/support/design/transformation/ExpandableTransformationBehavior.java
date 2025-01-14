package android.support.design.transformation;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
/* loaded from: classes.dex */
public abstract class ExpandableTransformationBehavior extends ExpandableBehavior {

    /* renamed from: b  reason: collision with root package name */
    public AnimatorSet f2082b;

    /* loaded from: classes.dex */
    public class a extends AnimatorListenerAdapter {
        public a() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            ExpandableTransformationBehavior.this.f2082b = null;
        }
    }

    public ExpandableTransformationBehavior() {
    }

    public abstract AnimatorSet b(View view, View view2, boolean z, boolean z2);

    public ExpandableTransformationBehavior(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    @Override // android.support.design.transformation.ExpandableBehavior
    public boolean a(View view, View view2, boolean z, boolean z2) {
        boolean z3 = this.f2082b != null;
        if (z3) {
            this.f2082b.cancel();
        }
        this.f2082b = b(view, view2, z, z3);
        this.f2082b.addListener(new a());
        this.f2082b.start();
        if (!z2) {
            this.f2082b.end();
        }
        return true;
    }
}
