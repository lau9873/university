package a.b.d.x;

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
/* compiled from: FloatingActionButtonImplLollipop.java */
/* loaded from: classes.dex */
public class h extends g {
    public InsetDrawable I;

    /* compiled from: FloatingActionButtonImplLollipop.java */
    /* loaded from: classes.dex */
    public static class a extends GradientDrawable {
        @Override // android.graphics.drawable.GradientDrawable, android.graphics.drawable.Drawable
        public boolean isStateful() {
            return true;
        }
    }

    public h(t tVar, n nVar) {
        super(tVar, nVar);
    }

    @Override // a.b.d.x.g
    public void a(ColorStateList colorStateList, PorterDuff.Mode mode, ColorStateList colorStateList2, int i2) {
        Drawable drawable;
        this.j = a.b.g.c.j.a.i(a());
        a.b.g.c.j.a.a(this.j, colorStateList);
        if (mode != null) {
            a.b.g.c.j.a.a(this.j, mode);
        }
        if (i2 > 0) {
            this.l = a(i2, colorStateList);
            drawable = new LayerDrawable(new Drawable[]{this.l, this.j});
        } else {
            this.l = null;
            drawable = this.j;
        }
        this.k = new RippleDrawable(a.b.d.s.a.a(colorStateList2), drawable, null);
        Drawable drawable2 = this.k;
        this.m = drawable2;
        this.v.a(drawable2);
    }

    @Override // a.b.d.x.g
    public void b(ColorStateList colorStateList) {
        Drawable drawable = this.k;
        if (drawable instanceof RippleDrawable) {
            ((RippleDrawable) drawable).setColor(a.b.d.s.a.a(colorStateList));
        } else {
            super.b(colorStateList);
        }
    }

    @Override // a.b.d.x.g
    public float f() {
        return this.u.getElevation();
    }

    @Override // a.b.d.x.g
    public void m() {
    }

    @Override // a.b.d.x.g
    public a.b.d.x.a n() {
        return new b();
    }

    @Override // a.b.d.x.g
    public GradientDrawable o() {
        return new a();
    }

    @Override // a.b.d.x.g
    public void q() {
        x();
    }

    @Override // a.b.d.x.g
    public boolean t() {
        return false;
    }

    @Override // a.b.d.x.g
    public void b(Rect rect) {
        if (this.v.a()) {
            this.I = new InsetDrawable(this.k, rect.left, rect.top, rect.right, rect.bottom);
            this.v.a(this.I);
            return;
        }
        this.v.a(this.k);
    }

    @Override // a.b.d.x.g
    public void a(float f2, float f3, float f4) {
        if (Build.VERSION.SDK_INT == 21) {
            this.u.refreshDrawableState();
        } else {
            StateListAnimator stateListAnimator = new StateListAnimator();
            stateListAnimator.addState(g.C, a(f2, f4));
            stateListAnimator.addState(g.D, a(f2, f3));
            stateListAnimator.addState(g.E, a(f2, f3));
            stateListAnimator.addState(g.F, a(f2, f3));
            AnimatorSet animatorSet = new AnimatorSet();
            ArrayList arrayList = new ArrayList();
            arrayList.add(ObjectAnimator.ofFloat(this.u, "elevation", f2).setDuration(0L));
            int i2 = Build.VERSION.SDK_INT;
            if (i2 >= 22 && i2 <= 24) {
                t tVar = this.u;
                arrayList.add(ObjectAnimator.ofFloat(tVar, View.TRANSLATION_Z, tVar.getTranslationZ()).setDuration(100L));
            }
            arrayList.add(ObjectAnimator.ofFloat(this.u, View.TRANSLATION_Z, 0.0f).setDuration(100L));
            animatorSet.playSequentially((Animator[]) arrayList.toArray(new Animator[0]));
            animatorSet.setInterpolator(g.B);
            stateListAnimator.addState(g.G, animatorSet);
            stateListAnimator.addState(g.H, a(0.0f, 0.0f));
            this.u.setStateListAnimator(stateListAnimator);
        }
        if (this.v.a()) {
            x();
        }
    }

    public final Animator a(float f2, float f3) {
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.play(ObjectAnimator.ofFloat(this.u, "elevation", f2).setDuration(0L)).with(ObjectAnimator.ofFloat(this.u, View.TRANSLATION_Z, f3).setDuration(100L));
        animatorSet.setInterpolator(g.B);
        return animatorSet;
    }

    @Override // a.b.d.x.g
    public void a(int[] iArr) {
        if (Build.VERSION.SDK_INT == 21) {
            if (this.u.isEnabled()) {
                this.u.setElevation(this.n);
                if (this.u.isPressed()) {
                    this.u.setTranslationZ(this.p);
                    return;
                } else if (!this.u.isFocused() && !this.u.isHovered()) {
                    this.u.setTranslationZ(0.0f);
                    return;
                } else {
                    this.u.setTranslationZ(this.o);
                    return;
                }
            }
            this.u.setElevation(0.0f);
            this.u.setTranslationZ(0.0f);
        }
    }

    @Override // a.b.d.x.g
    public void a(Rect rect) {
        if (this.v.a()) {
            float b2 = this.v.b();
            float f2 = f() + this.p;
            int ceil = (int) Math.ceil(m.a(f2, b2, false));
            int ceil2 = (int) Math.ceil(m.b(f2, b2, false));
            rect.set(ceil, ceil2, ceil, ceil2);
            return;
        }
        rect.set(0, 0, 0, 0);
    }
}
