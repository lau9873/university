package android.support.design.bottomappbar;

import a.b.g.k.u;
import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Rect;
import android.os.Parcel;
import android.os.Parcelable;
import android.support.design.behavior.HideBottomViewOnScrollBehavior;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.widget.ActionMenuView;
import android.support.v7.widget.Toolbar;
import android.util.AttributeSet;
import android.view.View;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class BottomAppBar extends Toolbar implements CoordinatorLayout.b {
    public final int Q;
    public final a.b.d.t.b R;
    public final a.b.d.m.a S;
    public Animator T;
    public Animator U;
    public Animator V;
    public int W;
    public boolean a0;
    public boolean b0;
    public AnimatorListenerAdapter c0;

    /* loaded from: classes.dex */
    public class a extends AnimatorListenerAdapter {
        public a() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            BottomAppBar.this.U = null;
        }
    }

    /* loaded from: classes.dex */
    public class b extends AnimatorListenerAdapter {
        public b() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            BottomAppBar.this.V = null;
        }
    }

    /* loaded from: classes.dex */
    public class c extends AnimatorListenerAdapter {

        /* renamed from: a  reason: collision with root package name */
        public boolean f2068a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ ActionMenuView f2069b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ int f2070c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ boolean f2071d;

        public c(ActionMenuView actionMenuView, int i2, boolean z) {
            this.f2069b = actionMenuView;
            this.f2070c = i2;
            this.f2071d = z;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            this.f2068a = true;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            if (this.f2068a) {
                return;
            }
            BottomAppBar.this.a(this.f2069b, this.f2070c, this.f2071d);
        }
    }

    /* loaded from: classes.dex */
    public static class d extends a.b.g.k.a {
        public static final Parcelable.Creator<d> CREATOR = new a();

        /* renamed from: c  reason: collision with root package name */
        public int f2073c;

        /* renamed from: d  reason: collision with root package name */
        public boolean f2074d;

        /* loaded from: classes.dex */
        public static class a implements Parcelable.ClassLoaderCreator<d> {
            @Override // android.os.Parcelable.Creator
            public d[] newArray(int i2) {
                return new d[i2];
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.ClassLoaderCreator
            public d createFromParcel(Parcel parcel, ClassLoader classLoader) {
                return new d(parcel, classLoader);
            }

            @Override // android.os.Parcelable.Creator
            public d createFromParcel(Parcel parcel) {
                return new d(parcel, null);
            }
        }

        public d(Parcelable parcelable) {
            super(parcelable);
        }

        @Override // a.b.g.k.a, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i2) {
            super.writeToParcel(parcel, i2);
            parcel.writeInt(this.f2073c);
            parcel.writeInt(this.f2074d ? 1 : 0);
        }

        public d(Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            this.f2073c = parcel.readInt();
            this.f2074d = parcel.readInt() != 0;
        }
    }

    public static /* synthetic */ void c(BottomAppBar bottomAppBar) {
        bottomAppBar.w();
        throw null;
    }

    private ActionMenuView getActionMenuView() {
        for (int i2 = 0; i2 < getChildCount(); i2++) {
            View childAt = getChildAt(i2);
            if (childAt instanceof ActionMenuView) {
                return (ActionMenuView) childAt;
            }
        }
        return null;
    }

    private float getFabTranslationX() {
        return d(this.W);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public float getFabTranslationY() {
        return a(this.b0);
    }

    public final void e(int i2) {
        if (this.W == i2 || !u.x(this)) {
            return;
        }
        Animator animator = this.U;
        if (animator != null) {
            animator.cancel();
        }
        ArrayList arrayList = new ArrayList();
        a(i2, arrayList);
        b(i2, arrayList);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playTogether(arrayList);
        this.U = animatorSet;
        this.U.addListener(new a());
        this.U.start();
    }

    public ColorStateList getBackgroundTint() {
        this.R.a();
        throw null;
    }

    @Override // android.support.design.widget.CoordinatorLayout.b
    public CoordinatorLayout.c<BottomAppBar> getBehavior() {
        return new Behavior();
    }

    public float getCradleVerticalOffset() {
        this.S.a();
        throw null;
    }

    public int getFabAlignmentMode() {
        return this.W;
    }

    public float getFabCradleMargin() {
        this.S.b();
        throw null;
    }

    public float getFabCradleRoundedCornerRadius() {
        this.S.c();
        throw null;
    }

    public boolean getHideOnScroll() {
        return this.a0;
    }

    @Override // android.support.v7.widget.Toolbar, android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        super.onLayout(z, i2, i3, i4, i5);
        s();
        w();
        throw null;
    }

    @Override // android.support.v7.widget.Toolbar, android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof d)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        d dVar = (d) parcelable;
        super.onRestoreInstanceState(dVar.a());
        this.W = dVar.f2073c;
        this.b0 = dVar.f2074d;
    }

    @Override // android.support.v7.widget.Toolbar, android.view.View
    public Parcelable onSaveInstanceState() {
        d dVar = new d(super.onSaveInstanceState());
        dVar.f2073c = this.W;
        dVar.f2074d = this.b0;
        return dVar;
    }

    public final void s() {
        Animator animator = this.T;
        if (animator != null) {
            animator.cancel();
        }
        Animator animator2 = this.V;
        if (animator2 != null) {
            animator2.cancel();
        }
        Animator animator3 = this.U;
        if (animator3 != null) {
            animator3.cancel();
        }
    }

    public void setBackgroundTint(ColorStateList colorStateList) {
        a.b.g.c.j.a.a(this.R, colorStateList);
    }

    public void setCradleVerticalOffset(float f2) {
        if (f2 == getCradleVerticalOffset()) {
            return;
        }
        this.S.a(f2);
        throw null;
    }

    public void setFabAlignmentMode(int i2) {
        e(i2);
        a(i2, this.b0);
        this.W = i2;
    }

    public void setFabCradleMargin(float f2) {
        if (f2 == getFabCradleMargin()) {
            return;
        }
        this.S.b(f2);
        throw null;
    }

    public void setFabCradleRoundedCornerRadius(float f2) {
        if (f2 == getFabCradleRoundedCornerRadius()) {
            return;
        }
        this.S.c(f2);
        throw null;
    }

    public void setFabDiameter(int i2) {
        this.S.d();
        throw null;
    }

    public void setHideOnScroll(boolean z) {
        this.a0 = z;
    }

    @Override // android.support.v7.widget.Toolbar
    public void setSubtitle(CharSequence charSequence) {
    }

    @Override // android.support.v7.widget.Toolbar
    public void setTitle(CharSequence charSequence) {
    }

    public final FloatingActionButton t() {
        if (getParent() instanceof CoordinatorLayout) {
            for (View view : ((CoordinatorLayout) getParent()).c(this)) {
                if (view instanceof FloatingActionButton) {
                    return (FloatingActionButton) view;
                }
            }
            return null;
        }
        return null;
    }

    public final boolean u() {
        Animator animator;
        Animator animator2;
        Animator animator3 = this.T;
        return (animator3 != null && animator3.isRunning()) || ((animator = this.V) != null && animator.isRunning()) || ((animator2 = this.U) != null && animator2.isRunning());
    }

    public final boolean v() {
        FloatingActionButton t = t();
        return t != null && t.c();
    }

    public final void w() {
        this.S.d(getFabTranslationX());
        throw null;
    }

    /* loaded from: classes.dex */
    public static class Behavior extends HideBottomViewOnScrollBehavior<BottomAppBar> {

        /* renamed from: d  reason: collision with root package name */
        public final Rect f2065d;

        public Behavior() {
            this.f2065d = new Rect();
        }

        public Behavior(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            this.f2065d = new Rect();
        }

        public final boolean a(FloatingActionButton floatingActionButton, BottomAppBar bottomAppBar) {
            ((CoordinatorLayout.f) floatingActionButton.getLayoutParams()).f2188d = 17;
            bottomAppBar.a(floatingActionButton);
            return true;
        }

        @Override // android.support.design.behavior.HideBottomViewOnScrollBehavior
        public void b(BottomAppBar bottomAppBar) {
            super.b((Behavior) bottomAppBar);
            FloatingActionButton t = bottomAppBar.t();
            if (t != null) {
                t.clearAnimation();
                t.animate().translationY(bottomAppBar.getFabTranslationY()).setInterpolator(a.b.d.l.a.f213d).setDuration(225L);
            }
        }

        @Override // android.support.design.behavior.HideBottomViewOnScrollBehavior, android.support.design.widget.CoordinatorLayout.c
        public boolean a(CoordinatorLayout coordinatorLayout, BottomAppBar bottomAppBar, int i2) {
            FloatingActionButton t = bottomAppBar.t();
            if (t != null) {
                a(t, bottomAppBar);
                t.b(this.f2065d);
                bottomAppBar.setFabDiameter(this.f2065d.height());
            }
            if (bottomAppBar.u()) {
                coordinatorLayout.d(bottomAppBar, i2);
                return super.a(coordinatorLayout, (CoordinatorLayout) bottomAppBar, i2);
            }
            BottomAppBar.c(bottomAppBar);
            throw null;
        }

        @Override // android.support.design.widget.CoordinatorLayout.c
        /* renamed from: a */
        public boolean b(CoordinatorLayout coordinatorLayout, BottomAppBar bottomAppBar, View view, View view2, int i2, int i3) {
            return bottomAppBar.getHideOnScroll() && super.b(coordinatorLayout, bottomAppBar, view, view2, i2, i3);
        }

        @Override // android.support.design.behavior.HideBottomViewOnScrollBehavior
        public void a(BottomAppBar bottomAppBar) {
            super.a((Behavior) bottomAppBar);
            FloatingActionButton t = bottomAppBar.t();
            if (t != null) {
                t.a(this.f2065d);
                t.clearAnimation();
                t.animate().translationY((-t.getPaddingBottom()) + (t.getMeasuredHeight() - this.f2065d.height())).setInterpolator(a.b.d.l.a.f212c).setDuration(175L);
            }
        }
    }

    public final int d(int i2) {
        boolean z = u.k(this) == 1;
        if (i2 == 1) {
            return ((getMeasuredWidth() / 2) - this.Q) * (z ? -1 : 1);
        }
        return 0;
    }

    public final void b(int i2, List<Animator> list) {
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(t(), "translationX", d(i2));
        ofFloat.setDuration(300L);
        list.add(ofFloat);
    }

    public final void a(int i2, List<Animator> list) {
        if (this.b0) {
            this.S.e();
            throw null;
        }
    }

    public final void b(FloatingActionButton floatingActionButton) {
        floatingActionButton.c(this.c0);
        floatingActionButton.d(this.c0);
    }

    public final void a(int i2, boolean z) {
        if (u.x(this)) {
            Animator animator = this.V;
            if (animator != null) {
                animator.cancel();
            }
            ArrayList arrayList = new ArrayList();
            if (!v()) {
                i2 = 0;
                z = false;
            }
            a(i2, z, arrayList);
            AnimatorSet animatorSet = new AnimatorSet();
            animatorSet.playTogether(arrayList);
            this.V = animatorSet;
            this.V.addListener(new b());
            this.V.start();
        }
    }

    public final void a(int i2, boolean z, List<Animator> list) {
        ActionMenuView actionMenuView = getActionMenuView();
        if (actionMenuView == null) {
            return;
        }
        Animator ofFloat = ObjectAnimator.ofFloat(actionMenuView, "alpha", 1.0f);
        if ((!this.b0 && (!z || !v())) || (this.W != 1 && i2 != 1)) {
            if (actionMenuView.getAlpha() < 1.0f) {
                list.add(ofFloat);
                return;
            }
            return;
        }
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(actionMenuView, "alpha", 0.0f);
        ofFloat2.addListener(new c(actionMenuView, i2, z));
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.setDuration(150L);
        animatorSet.playSequentially(ofFloat2, ofFloat);
        list.add(animatorSet);
    }

    public final float a(boolean z) {
        FloatingActionButton t = t();
        if (t == null) {
            return 0.0f;
        }
        Rect rect = new Rect();
        t.a(rect);
        float height = rect.height();
        if (height == 0.0f) {
            height = t.getMeasuredHeight();
        }
        float height2 = t.getHeight() - rect.height();
        float height3 = (-getCradleVerticalOffset()) + (height / 2.0f) + (t.getHeight() - rect.bottom);
        float paddingBottom = height2 - t.getPaddingBottom();
        float f2 = -getMeasuredHeight();
        if (z) {
            paddingBottom = height3;
        }
        return f2 + paddingBottom;
    }

    public final void a(ActionMenuView actionMenuView, int i2, boolean z) {
        boolean z2 = u.k(this) == 1;
        int i3 = 0;
        for (int i4 = 0; i4 < getChildCount(); i4++) {
            View childAt = getChildAt(i4);
            if ((childAt.getLayoutParams() instanceof Toolbar.e) && (((Toolbar.e) childAt.getLayoutParams()).f1271a & 8388615) == 8388611) {
                i3 = Math.max(i3, z2 ? childAt.getLeft() : childAt.getRight());
            }
        }
        actionMenuView.setTranslationX((i2 == 1 && z) ? i3 - (z2 ? actionMenuView.getRight() : actionMenuView.getLeft()) : 0.0f);
    }

    public final void a(FloatingActionButton floatingActionButton) {
        b(floatingActionButton);
        floatingActionButton.a(this.c0);
        floatingActionButton.b(this.c0);
    }
}
