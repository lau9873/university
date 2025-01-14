package p000a.p006b.p012d.p026x;

import android.animation.AnimatorInflater;
import android.animation.ObjectAnimator;
import android.animation.StateListAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewOutlineProvider;
import p000a.p006b.p012d.C0040b;
import p000a.p006b.p012d.C0045g;
import p000a.p006b.p012d.p019q.ThemeEnforcement;

/* renamed from: a.b.d.x.s */
/* loaded from: classes.dex */
public class ViewUtilsLollipop {

    /* renamed from: a */
    public static final int[] f749a = {16843848};

    /* renamed from: a */
    public static void m10650a(View view) {
        view.setOutlineProvider(ViewOutlineProvider.BOUNDS);
    }

    /* renamed from: a */
    public static void m10648a(View view, AttributeSet attributeSet, int i, int i2) {
        Context context = view.getContext();
        TypedArray m10861c = ThemeEnforcement.m10861c(context, attributeSet, f749a, i, i2, new int[0]);
        try {
            if (m10861c.hasValue(0)) {
                view.setStateListAnimator(AnimatorInflater.loadStateListAnimator(context, m10861c.getResourceId(0, 0)));
            }
        } finally {
            m10861c.recycle();
        }
    }

    /* renamed from: a */
    public static void m10649a(View view, float f) {
        int integer = view.getResources().getInteger(C0045g.app_bar_elevation_anim_duration);
        StateListAnimator stateListAnimator = new StateListAnimator();
        long j = integer;
        stateListAnimator.addState(new int[]{16842766, C0040b.state_liftable, -C0040b.state_lifted}, ObjectAnimator.ofFloat(view, "elevation", 0.0f).setDuration(j));
        stateListAnimator.addState(new int[]{16842766}, ObjectAnimator.ofFloat(view, "elevation", f).setDuration(j));
        stateListAnimator.addState(new int[0], ObjectAnimator.ofFloat(view, "elevation", 0.0f).setDuration(0L));
        view.setStateListAnimator(stateListAnimator);
    }
}
