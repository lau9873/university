package a.b.d.x;

import android.animation.AnimatorInflater;
import android.animation.ObjectAnimator;
import android.animation.StateListAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewOutlineProvider;
/* compiled from: ViewUtilsLollipop.java */
/* loaded from: classes.dex */
public class s {

    /* renamed from: a  reason: collision with root package name */
    public static final int[] f407a = {16843848};

    public static void a(View view) {
        view.setOutlineProvider(ViewOutlineProvider.BOUNDS);
    }

    public static void a(View view, AttributeSet attributeSet, int i2, int i3) {
        Context context = view.getContext();
        TypedArray c2 = a.b.d.q.g.c(context, attributeSet, f407a, i2, i3, new int[0]);
        try {
            if (c2.hasValue(0)) {
                view.setStateListAnimator(AnimatorInflater.loadStateListAnimator(context, c2.getResourceId(0, 0)));
            }
        } finally {
            c2.recycle();
        }
    }

    public static void a(View view, float f2) {
        int integer = view.getResources().getInteger(a.b.d.g.app_bar_elevation_anim_duration);
        StateListAnimator stateListAnimator = new StateListAnimator();
        long j = integer;
        stateListAnimator.addState(new int[]{16842766, a.b.d.b.state_liftable, -a.b.d.b.state_lifted}, ObjectAnimator.ofFloat(view, "elevation", 0.0f).setDuration(j));
        stateListAnimator.addState(new int[]{16842766}, ObjectAnimator.ofFloat(view, "elevation", f2).setDuration(j));
        stateListAnimator.addState(new int[0], ObjectAnimator.ofFloat(view, "elevation", 0.0f).setDuration(0L));
        view.setStateListAnimator(stateListAnimator);
    }
}
