package p000a.p006b.p029f;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.view.View;
import android.view.ViewGroup;
import p000a.p006b.p030g.p045k.ViewCompat;

/* renamed from: a.b.f.d */
/* loaded from: classes.dex */
public class Fade extends Visibility {

    /* compiled from: Fade.java */
    /* renamed from: a.b.f.d$a */
    /* loaded from: classes.dex */
    public class C0107a extends TransitionListenerAdapter {

        /* renamed from: a */
        public final /* synthetic */ View f886a;

        public C0107a(Fade fade, View view) {
            this.f886a = view;
        }

        @Override // p000a.p006b.p029f.Transition.InterfaceC0125f
        /* renamed from: b */
        public void mo10433b(Transition transition) {
            C0109d0.m10543a(this.f886a, 1.0f);
            C0109d0.m10544a(this.f886a);
            transition.mo10442b(this);
        }
    }

    /* compiled from: Fade.java */
    /* renamed from: a.b.f.d$b */
    /* loaded from: classes.dex */
    public static class C0108b extends AnimatorListenerAdapter {

        /* renamed from: a */
        public final View f887a;

        /* renamed from: b */
        public boolean f888b = false;

        public C0108b(View view) {
            this.f887a = view;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            C0109d0.m10543a(this.f887a, 1.0f);
            if (this.f888b) {
                this.f887a.setLayerType(0, null);
            }
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            if (ViewCompat.m9412u(this.f887a) && this.f887a.getLayerType() == 0) {
                this.f888b = true;
                this.f887a.setLayerType(2, null);
            }
        }
    }

    public Fade(int i) {
        m10514a(i);
    }

    /* renamed from: a */
    public final Animator m10546a(View view, float f, float f2) {
        if (f == f2) {
            return null;
        }
        C0109d0.m10543a(view, f);
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(view, C0109d0.f892d, f2);
        ofFloat.addListener(new C0108b(view));
        mo10452a(new C0107a(this, view));
        return ofFloat;
    }

    @Override // p000a.p006b.p029f.Visibility
    /* renamed from: b */
    public Animator mo10509b(ViewGroup viewGroup, View view, TransitionValues transitionValues, TransitionValues transitionValues2) {
        C0109d0.m10535e(view);
        return m10546a(view, m10547a(transitionValues, 1.0f), 0.0f);
    }

    @Override // p000a.p006b.p029f.Visibility, p000a.p006b.p029f.Transition
    /* renamed from: c */
    public void mo10440c(TransitionValues transitionValues) {
        super.mo10440c(transitionValues);
        transitionValues.f999a.put("android:fade:transitionAlpha", Float.valueOf(C0109d0.m10537c(transitionValues.f1000b)));
    }

    @Override // p000a.p006b.p029f.Visibility
    /* renamed from: a */
    public Animator mo10512a(ViewGroup viewGroup, View view, TransitionValues transitionValues, TransitionValues transitionValues2) {
        float m10547a = m10547a(transitionValues, 0.0f);
        return m10546a(view, m10547a != 1.0f ? m10547a : 0.0f, 1.0f);
    }

    /* renamed from: a */
    public static float m10547a(TransitionValues transitionValues, float f) {
        Float f2;
        return (transitionValues == null || (f2 = (Float) transitionValues.f999a.get("android:fade:transitionAlpha")) == null) ? f : f2.floatValue();
    }
}
