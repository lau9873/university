package a.b.d.o;

import a.b.d.o.d;
import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.TypeEvaluator;
import android.os.Build;
import android.util.Property;
import android.view.View;
import android.view.ViewAnimationUtils;
/* compiled from: CircularRevealCompat.java */
/* loaded from: classes.dex */
public final class a {

    /* compiled from: CircularRevealCompat.java */
    /* renamed from: a.b.d.o.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0003a extends AnimatorListenerAdapter {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d f248a;

        public C0003a(d dVar) {
            this.f248a = dVar;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            this.f248a.a();
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            this.f248a.b();
        }
    }

    public static Animator a(d dVar, float f2, float f3, float f4) {
        ObjectAnimator ofObject = ObjectAnimator.ofObject(dVar, (Property<d, V>) d.c.f253a, (TypeEvaluator) d.b.f251b, (Object[]) new d.e[]{new d.e(f2, f3, f4)});
        if (Build.VERSION.SDK_INT >= 21) {
            d.e revealInfo = dVar.getRevealInfo();
            if (revealInfo != null) {
                Animator createCircularReveal = ViewAnimationUtils.createCircularReveal((View) dVar, (int) f2, (int) f3, revealInfo.f257c, f4);
                AnimatorSet animatorSet = new AnimatorSet();
                animatorSet.playTogether(ofObject, createCircularReveal);
                return animatorSet;
            }
            throw new IllegalStateException("Caller must set a non-null RevealInfo before calling this.");
        }
        return ofObject;
    }

    public static Animator.AnimatorListener a(d dVar) {
        return new C0003a(dVar);
    }
}
