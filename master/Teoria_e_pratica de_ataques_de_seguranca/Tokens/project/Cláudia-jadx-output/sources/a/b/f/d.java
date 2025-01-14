package a.b.f;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.view.View;
import android.view.ViewGroup;
/* compiled from: Fade.java */
/* loaded from: classes.dex */
public class d extends i0 {

    /* compiled from: Fade.java */
    /* loaded from: classes.dex */
    public class a extends n {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ View f507a;

        public a(d dVar, View view) {
            this.f507a = view;
        }

        @Override // a.b.f.m.f
        public void b(m mVar) {
            d0.a(this.f507a, 1.0f);
            d0.a(this.f507a);
            mVar.b(this);
        }
    }

    /* compiled from: Fade.java */
    /* loaded from: classes.dex */
    public static class b extends AnimatorListenerAdapter {

        /* renamed from: a  reason: collision with root package name */
        public final View f508a;

        /* renamed from: b  reason: collision with root package name */
        public boolean f509b = false;

        public b(View view) {
            this.f508a = view;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            d0.a(this.f508a, 1.0f);
            if (this.f509b) {
                this.f508a.setLayerType(0, null);
            }
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            if (a.b.g.k.u.u(this.f508a) && this.f508a.getLayerType() == 0) {
                this.f509b = true;
                this.f508a.setLayerType(2, null);
            }
        }
    }

    public d(int i2) {
        a(i2);
    }

    public final Animator a(View view, float f2, float f3) {
        if (f2 == f3) {
            return null;
        }
        d0.a(view, f2);
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(view, d0.f513d, f3);
        ofFloat.addListener(new b(view));
        a(new a(this, view));
        return ofFloat;
    }

    @Override // a.b.f.i0
    public Animator b(ViewGroup viewGroup, View view, s sVar, s sVar2) {
        d0.e(view);
        return a(view, a(sVar, 1.0f), 0.0f);
    }

    @Override // a.b.f.i0, a.b.f.m
    public void c(s sVar) {
        super.c(sVar);
        sVar.f586a.put("android:fade:transitionAlpha", Float.valueOf(d0.c(sVar.f587b)));
    }

    @Override // a.b.f.i0
    public Animator a(ViewGroup viewGroup, View view, s sVar, s sVar2) {
        float a2 = a(sVar, 0.0f);
        return a(view, a2 != 1.0f ? a2 : 0.0f, 1.0f);
    }

    public static float a(s sVar, float f2) {
        Float f3;
        return (sVar == null || (f3 = (Float) sVar.f586a.get("android:fade:transitionAlpha")) == null) ? f2 : f3.floatValue();
    }
}
