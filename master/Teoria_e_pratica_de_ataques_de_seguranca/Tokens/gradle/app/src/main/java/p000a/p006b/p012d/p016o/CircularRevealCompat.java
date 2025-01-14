package p000a.p006b.p012d.p016o;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.TypeEvaluator;
import android.os.Build;
import android.util.Property;
import android.view.View;
import android.view.ViewAnimationUtils;
import p000a.p006b.p012d.p016o.CircularRevealWidget;

/* renamed from: a.b.d.o.a */
/* loaded from: classes.dex */
public final class CircularRevealCompat {

    /* compiled from: CircularRevealCompat.java */
    /* renamed from: a.b.d.o.a$a */
    /* loaded from: classes.dex */
    public static class C0050a extends AnimatorListenerAdapter {

        /* renamed from: a */
        public final /* synthetic */ CircularRevealWidget f474a;

        public C0050a(CircularRevealWidget circularRevealWidget) {
            this.f474a = circularRevealWidget;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            this.f474a.mo10891a();
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            this.f474a.mo10890b();
        }
    }

    /* renamed from: a */
    public static Animator m10908a(CircularRevealWidget circularRevealWidget, float f, float f2, float f3) {
        ObjectAnimator ofObject = ObjectAnimator.ofObject(circularRevealWidget, (Property<CircularRevealWidget, V>) CircularRevealWidget.C0054c.f479a, (TypeEvaluator) CircularRevealWidget.C0053b.f477b, (Object[]) new CircularRevealWidget.C0056e[]{new CircularRevealWidget.C0056e(f, f2, f3)});
        if (Build.VERSION.SDK_INT >= 21) {
            CircularRevealWidget.C0056e revealInfo = circularRevealWidget.getRevealInfo();
            if (revealInfo != null) {
                Animator createCircularReveal = ViewAnimationUtils.createCircularReveal((View) circularRevealWidget, (int) f, (int) f2, revealInfo.f483c, f3);
                AnimatorSet animatorSet = new AnimatorSet();
                animatorSet.playTogether(ofObject, createCircularReveal);
                return animatorSet;
            }
            throw new IllegalStateException("Caller must set a non-null RevealInfo before calling this.");
        }
        return ofObject;
    }

    /* renamed from: a */
    public static Animator.AnimatorListener m10909a(CircularRevealWidget circularRevealWidget) {
        return new C0050a(circularRevealWidget);
    }
}
