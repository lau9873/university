package p000a.p006b.p012d.p026x;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.StateListAnimator;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.InsetDrawable;
import android.graphics.drawable.LayerDrawable;
import android.graphics.drawable.RippleDrawable;
import android.os.Build;
import android.view.View;
import java.util.ArrayList;
import p000a.p006b.p012d.p021s.RippleUtils;
import p000a.p006b.p030g.p034c.p035j.DrawableCompat;

/* renamed from: a.b.d.x.h */
/* loaded from: classes.dex */
public class FloatingActionButtonImplLollipop extends FloatingActionButtonImpl {

    /* renamed from: I */
    public InsetDrawable f670I;

    /* compiled from: FloatingActionButtonImplLollipop.java */
    /* renamed from: a.b.d.x.h$a */
    /* loaded from: classes.dex */
    public static class C0073a extends GradientDrawable {
        @Override // android.graphics.drawable.GradientDrawable, android.graphics.drawable.Drawable
        public boolean isStateful() {
            return true;
        }
    }

    public FloatingActionButtonImplLollipop(VisibilityAwareImageButton visibilityAwareImageButton, ShadowViewDelegate shadowViewDelegate) {
        super(visibilityAwareImageButton, shadowViewDelegate);
    }

    @Override // p000a.p006b.p012d.p026x.FloatingActionButtonImpl
    /* renamed from: a */
    public void mo10752a(ColorStateList colorStateList, PorterDuff.Mode mode, ColorStateList colorStateList2, int i) {
        Drawable drawable;
        this.f638j = DrawableCompat.m9848i(m10792a());
        DrawableCompat.m9861a(this.f638j, colorStateList);
        if (mode != null) {
            DrawableCompat.m9858a(this.f638j, mode);
        }
        if (i > 0) {
            this.f640l = m10788a(i, colorStateList);
            drawable = new LayerDrawable(new Drawable[]{this.f640l, this.f638j});
        } else {
            this.f640l = null;
            drawable = this.f638j;
        }
        this.f639k = new RippleDrawable(RippleUtils.m10854a(colorStateList2), drawable, null);
        Drawable drawable2 = this.f639k;
        this.f641m = drawable2;
        this.f650v.mo7631a(drawable2);
    }

    @Override // p000a.p006b.p012d.p026x.FloatingActionButtonImpl
    /* renamed from: b */
    public void mo10749b(ColorStateList colorStateList) {
        Drawable drawable = this.f639k;
        if (drawable instanceof RippleDrawable) {
            ((RippleDrawable) drawable).setColor(RippleUtils.m10854a(colorStateList));
        } else {
            super.mo10749b(colorStateList);
        }
    }

    @Override // p000a.p006b.p012d.p026x.FloatingActionButtonImpl
    /* renamed from: f */
    public float mo10747f() {
        return this.f649u.getElevation();
    }

    @Override // p000a.p006b.p012d.p026x.FloatingActionButtonImpl
    /* renamed from: m */
    public void mo10746m() {
    }

    @Override // p000a.p006b.p012d.p026x.FloatingActionButtonImpl
    /* renamed from: n */
    public CircularBorderDrawable mo10745n() {
        return new CircularBorderDrawableLollipop();
    }

    @Override // p000a.p006b.p012d.p026x.FloatingActionButtonImpl
    /* renamed from: o */
    public GradientDrawable mo10744o() {
        return new C0073a();
    }

    @Override // p000a.p006b.p012d.p026x.FloatingActionButtonImpl
    /* renamed from: q */
    public void mo10743q() {
        m10756x();
    }

    @Override // p000a.p006b.p012d.p026x.FloatingActionButtonImpl
    /* renamed from: t */
    public boolean mo10742t() {
        return false;
    }

    @Override // p000a.p006b.p012d.p026x.FloatingActionButtonImpl
    /* renamed from: b */
    public void mo10748b(Rect rect) {
        if (this.f650v.mo7633a()) {
            this.f670I = new InsetDrawable(this.f639k, rect.left, rect.top, rect.right, rect.bottom);
            this.f650v.mo7631a(this.f670I);
            return;
        }
        this.f650v.mo7631a(this.f639k);
    }

    @Override // p000a.p006b.p012d.p026x.FloatingActionButtonImpl
    /* renamed from: a */
    public void mo10753a(float f, float f2, float f3) {
        if (Build.VERSION.SDK_INT == 21) {
            this.f649u.refreshDrawableState();
        } else {
            StateListAnimator stateListAnimator = new StateListAnimator();
            stateListAnimator.addState(FloatingActionButtonImpl.f622C, m10754a(f, f3));
            stateListAnimator.addState(FloatingActionButtonImpl.f623D, m10754a(f, f2));
            stateListAnimator.addState(FloatingActionButtonImpl.f624E, m10754a(f, f2));
            stateListAnimator.addState(FloatingActionButtonImpl.f625F, m10754a(f, f2));
            AnimatorSet animatorSet = new AnimatorSet();
            ArrayList arrayList = new ArrayList();
            arrayList.add(ObjectAnimator.ofFloat(this.f649u, "elevation", f).setDuration(0L));
            int i = Build.VERSION.SDK_INT;
            if (i >= 22 && i <= 24) {
                VisibilityAwareImageButton visibilityAwareImageButton = this.f649u;
                arrayList.add(ObjectAnimator.ofFloat(visibilityAwareImageButton, View.TRANSLATION_Z, visibilityAwareImageButton.getTranslationZ()).setDuration(100L));
            }
            arrayList.add(ObjectAnimator.ofFloat(this.f649u, View.TRANSLATION_Z, 0.0f).setDuration(100L));
            animatorSet.playSequentially((Animator[]) arrayList.toArray(new Animator[0]));
            animatorSet.setInterpolator(FloatingActionButtonImpl.f621B);
            stateListAnimator.addState(FloatingActionButtonImpl.f626G, animatorSet);
            stateListAnimator.addState(FloatingActionButtonImpl.f627H, m10754a(0.0f, 0.0f));
            this.f649u.setStateListAnimator(stateListAnimator);
        }
        if (this.f650v.mo7633a()) {
            m10756x();
        }
    }

    /* renamed from: a */
    public final Animator m10754a(float f, float f2) {
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.play(ObjectAnimator.ofFloat(this.f649u, "elevation", f).setDuration(0L)).with(ObjectAnimator.ofFloat(this.f649u, View.TRANSLATION_Z, f2).setDuration(100L));
        animatorSet.setInterpolator(FloatingActionButtonImpl.f621B);
        return animatorSet;
    }

    @Override // p000a.p006b.p012d.p026x.FloatingActionButtonImpl
    /* renamed from: a */
    public void mo10750a(int[] iArr) {
        if (Build.VERSION.SDK_INT == 21) {
            if (this.f649u.isEnabled()) {
                this.f649u.setElevation(this.f642n);
                if (this.f649u.isPressed()) {
                    this.f649u.setTranslationZ(this.f644p);
                    return;
                } else if (!this.f649u.isFocused() && !this.f649u.isHovered()) {
                    this.f649u.setTranslationZ(0.0f);
                    return;
                } else {
                    this.f649u.setTranslationZ(this.f643o);
                    return;
                }
            }
            this.f649u.setElevation(0.0f);
            this.f649u.setTranslationZ(0.0f);
        }
    }

    @Override // p000a.p006b.p012d.p026x.FloatingActionButtonImpl
    /* renamed from: a */
    public void mo10751a(Rect rect) {
        if (this.f650v.mo7633a()) {
            float mo7630b = this.f650v.mo7630b();
            float mo10747f = mo10747f() + this.f644p;
            int ceil = (int) Math.ceil(ShadowDrawableWrapper.m10688a(mo10747f, mo7630b, false));
            int ceil2 = (int) Math.ceil(ShadowDrawableWrapper.m10682b(mo10747f, mo7630b, false));
            rect.set(ceil, ceil2, ceil, ceil2);
            return;
        }
        rect.set(0, 0, 0, 0);
    }
}
