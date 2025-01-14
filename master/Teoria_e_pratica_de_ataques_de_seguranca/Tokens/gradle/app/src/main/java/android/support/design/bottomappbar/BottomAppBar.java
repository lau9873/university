package android.support.design.bottomappbar;

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
import android.support.p067v7.widget.ActionMenuView;
import android.support.p067v7.widget.Toolbar;
import android.util.AttributeSet;
import android.view.View;
import java.util.ArrayList;
import java.util.List;
import p000a.p006b.p012d.p013l.AnimationUtils;
import p000a.p006b.p012d.p014m.BottomAppBarTopEdgeTreatment;
import p000a.p006b.p012d.p022t.MaterialShapeDrawable;
import p000a.p006b.p030g.p034c.p035j.DrawableCompat;
import p000a.p006b.p030g.p045k.AbsSavedState;
import p000a.p006b.p030g.p045k.ViewCompat;

/* loaded from: classes.dex */
public class BottomAppBar extends Toolbar implements CoordinatorLayout.InterfaceC0574b {

    /* renamed from: Q */
    public final int f3139Q;

    /* renamed from: R */
    public final MaterialShapeDrawable f3140R;

    /* renamed from: S */
    public final BottomAppBarTopEdgeTreatment f3141S;

    /* renamed from: T */
    public Animator f3142T;

    /* renamed from: U */
    public Animator f3143U;

    /* renamed from: V */
    public Animator f3144V;

    /* renamed from: W */
    public int f3145W;

    /* renamed from: a0 */
    public boolean f3146a0;

    /* renamed from: b0 */
    public boolean f3147b0;

    /* renamed from: c0 */
    public AnimatorListenerAdapter f3148c0;

    /* renamed from: android.support.design.bottomappbar.BottomAppBar$a */
    /* loaded from: classes.dex */
    public class C0523a extends AnimatorListenerAdapter {
        public C0523a() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            BottomAppBar.this.f3143U = null;
        }
    }

    /* renamed from: android.support.design.bottomappbar.BottomAppBar$b */
    /* loaded from: classes.dex */
    public class C0524b extends AnimatorListenerAdapter {
        public C0524b() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            BottomAppBar.this.f3144V = null;
        }
    }

    /* renamed from: android.support.design.bottomappbar.BottomAppBar$c */
    /* loaded from: classes.dex */
    public class C0525c extends AnimatorListenerAdapter {

        /* renamed from: a */
        public boolean f3152a;

        /* renamed from: b */
        public final /* synthetic */ ActionMenuView f3153b;

        /* renamed from: c */
        public final /* synthetic */ int f3154c;

        /* renamed from: d */
        public final /* synthetic */ boolean f3155d;

        public C0525c(ActionMenuView actionMenuView, int i, boolean z) {
            this.f3153b = actionMenuView;
            this.f3154c = i;
            this.f3155d = z;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            this.f3152a = true;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            if (this.f3152a) {
                return;
            }
            BottomAppBar.this.m7911a(this.f3153b, this.f3154c, this.f3155d);
        }
    }

    /* renamed from: android.support.design.bottomappbar.BottomAppBar$d */
    /* loaded from: classes.dex */
    public static class C0526d extends AbsSavedState {
        public static final Parcelable.Creator<C0526d> CREATOR = new C0527a();

        /* renamed from: c */
        public int f3157c;

        /* renamed from: d */
        public boolean f3158d;

        /* renamed from: android.support.design.bottomappbar.BottomAppBar$d$a */
        /* loaded from: classes.dex */
        public static class C0527a implements Parcelable.ClassLoaderCreator<C0526d> {
            @Override // android.os.Parcelable.Creator
            public C0526d[] newArray(int i) {
                return new C0526d[i];
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.ClassLoaderCreator
            public C0526d createFromParcel(Parcel parcel, ClassLoader classLoader) {
                return new C0526d(parcel, classLoader);
            }

            @Override // android.os.Parcelable.Creator
            public C0526d createFromParcel(Parcel parcel) {
                return new C0526d(parcel, null);
            }
        }

        public C0526d(Parcelable parcelable) {
            super(parcelable);
        }

        @Override // p000a.p006b.p030g.p045k.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeInt(this.f3157c);
            parcel.writeInt(this.f3158d ? 1 : 0);
        }

        public C0526d(Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            this.f3157c = parcel.readInt();
            this.f3158d = parcel.readInt() != 0;
        }
    }

    /* renamed from: c */
    public static /* synthetic */ void m7905c(BottomAppBar bottomAppBar) {
        bottomAppBar.m7897w();
        throw null;
    }

    private ActionMenuView getActionMenuView() {
        for (int i = 0; i < getChildCount(); i++) {
            View childAt = getChildAt(i);
            if (childAt instanceof ActionMenuView) {
                return (ActionMenuView) childAt;
            }
        }
        return null;
    }

    private float getFabTranslationX() {
        return m7904d(this.f3145W);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public float getFabTranslationY() {
        return m7910a(this.f3147b0);
    }

    /* renamed from: e */
    public final void m7902e(int i) {
        if (this.f3145W == i || !ViewCompat.m9409x(this)) {
            return;
        }
        Animator animator = this.f3143U;
        if (animator != null) {
            animator.cancel();
        }
        ArrayList arrayList = new ArrayList();
        m7919a(i, arrayList);
        m7909b(i, arrayList);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playTogether(arrayList);
        this.f3143U = animatorSet;
        this.f3143U.addListener(new C0523a());
        this.f3143U.start();
    }

    public ColorStateList getBackgroundTint() {
        this.f3140R.m10852a();
        throw null;
    }

    @Override // android.support.design.widget.CoordinatorLayout.InterfaceC0574b
    public CoordinatorLayout.AbstractC0575c<BottomAppBar> getBehavior() {
        return new Behavior();
    }

    public float getCradleVerticalOffset() {
        this.f3141S.m10946a();
        throw null;
    }

    public int getFabAlignmentMode() {
        return this.f3145W;
    }

    public float getFabCradleMargin() {
        this.f3141S.m10944b();
        throw null;
    }

    public float getFabCradleRoundedCornerRadius() {
        this.f3141S.m10942c();
        throw null;
    }

    public boolean getHideOnScroll() {
        return this.f3146a0;
    }

    @Override // android.support.p067v7.widget.Toolbar, android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        m7901s();
        m7897w();
        throw null;
    }

    @Override // android.support.p067v7.widget.Toolbar, android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof C0526d)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        C0526d c0526d = (C0526d) parcelable;
        super.onRestoreInstanceState(c0526d.m9588a());
        this.f3145W = c0526d.f3157c;
        this.f3147b0 = c0526d.f3158d;
    }

    @Override // android.support.p067v7.widget.Toolbar, android.view.View
    public Parcelable onSaveInstanceState() {
        C0526d c0526d = new C0526d(super.onSaveInstanceState());
        c0526d.f3157c = this.f3145W;
        c0526d.f3158d = this.f3147b0;
        return c0526d;
    }

    /* renamed from: s */
    public final void m7901s() {
        Animator animator = this.f3142T;
        if (animator != null) {
            animator.cancel();
        }
        Animator animator2 = this.f3144V;
        if (animator2 != null) {
            animator2.cancel();
        }
        Animator animator3 = this.f3143U;
        if (animator3 != null) {
            animator3.cancel();
        }
    }

    public void setBackgroundTint(ColorStateList colorStateList) {
        DrawableCompat.m9861a(this.f3140R, colorStateList);
    }

    public void setCradleVerticalOffset(float f) {
        if (f == getCradleVerticalOffset()) {
            return;
        }
        this.f3141S.m10945a(f);
        throw null;
    }

    public void setFabAlignmentMode(int i) {
        m7902e(i);
        m7918a(i, this.f3147b0);
        this.f3145W = i;
    }

    public void setFabCradleMargin(float f) {
        if (f == getFabCradleMargin()) {
            return;
        }
        this.f3141S.m10943b(f);
        throw null;
    }

    public void setFabCradleRoundedCornerRadius(float f) {
        if (f == getFabCradleRoundedCornerRadius()) {
            return;
        }
        this.f3141S.m10941c(f);
        throw null;
    }

    public void setFabDiameter(int i) {
        this.f3141S.m10940d();
        throw null;
    }

    public void setHideOnScroll(boolean z) {
        this.f3146a0 = z;
    }

    @Override // android.support.p067v7.widget.Toolbar
    public void setSubtitle(CharSequence charSequence) {
    }

    @Override // android.support.p067v7.widget.Toolbar
    public void setTitle(CharSequence charSequence) {
    }

    /* renamed from: t */
    public final FloatingActionButton m7900t() {
        if (getParent() instanceof CoordinatorLayout) {
            for (View view : ((CoordinatorLayout) getParent()).m7725c(this)) {
                if (view instanceof FloatingActionButton) {
                    return (FloatingActionButton) view;
                }
            }
            return null;
        }
        return null;
    }

    /* renamed from: u */
    public final boolean m7899u() {
        Animator animator;
        Animator animator2;
        Animator animator3 = this.f3142T;
        return (animator3 != null && animator3.isRunning()) || ((animator = this.f3144V) != null && animator.isRunning()) || ((animator2 = this.f3143U) != null && animator2.isRunning());
    }

    /* renamed from: v */
    public final boolean m7898v() {
        FloatingActionButton m7900t = m7900t();
        return m7900t != null && m7900t.m7654c();
    }

    /* renamed from: w */
    public final void m7897w() {
        this.f3141S.m10939d(getFabTranslationX());
        throw null;
    }

    /* loaded from: classes.dex */
    public static class Behavior extends HideBottomViewOnScrollBehavior<BottomAppBar> {

        /* renamed from: d */
        public final Rect f3149d;

        public Behavior() {
            this.f3149d = new Rect();
        }

        public Behavior(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            this.f3149d = new Rect();
        }

        /* renamed from: a */
        public final boolean m7893a(FloatingActionButton floatingActionButton, BottomAppBar bottomAppBar) {
            ((CoordinatorLayout.C0578f) floatingActionButton.getLayoutParams()).f3330d = 17;
            bottomAppBar.m7912a(floatingActionButton);
            return true;
        }

        @Override // android.support.design.behavior.HideBottomViewOnScrollBehavior
        /* renamed from: b  reason: avoid collision after fix types in other method */
        public void mo7890b(BottomAppBar bottomAppBar) {
            super.mo7890b((Behavior) bottomAppBar);
            FloatingActionButton m7900t = bottomAppBar.m7900t();
            if (m7900t != null) {
                m7900t.clearAnimation();
                m7900t.animate().translationY(bottomAppBar.getFabTranslationY()).setInterpolator(AnimationUtils.f424d).setDuration(225L);
            }
        }

        @Override // android.support.design.behavior.HideBottomViewOnScrollBehavior, android.support.design.widget.CoordinatorLayout.AbstractC0575c
        /* renamed from: a */
        public boolean mo7643a(CoordinatorLayout coordinatorLayout, BottomAppBar bottomAppBar, int i) {
            FloatingActionButton m7900t = bottomAppBar.m7900t();
            if (m7900t != null) {
                m7893a(m7900t, bottomAppBar);
                m7900t.m7656b(this.f3149d);
                bottomAppBar.setFabDiameter(this.f3149d.height());
            }
            if (bottomAppBar.m7899u()) {
                coordinatorLayout.m7719d(bottomAppBar, i);
                return super.mo7643a(coordinatorLayout, (CoordinatorLayout) bottomAppBar, i);
            }
            BottomAppBar.m7905c(bottomAppBar);
            throw null;
        }

        @Override // android.support.design.widget.CoordinatorLayout.AbstractC0575c
        /* renamed from: a */
        public boolean mo7693b(CoordinatorLayout coordinatorLayout, BottomAppBar bottomAppBar, View view, View view2, int i, int i2) {
            return bottomAppBar.getHideOnScroll() && super.mo7693b(coordinatorLayout, bottomAppBar, view, view2, i, i2);
        }

        @Override // android.support.design.behavior.HideBottomViewOnScrollBehavior
        /* renamed from: a  reason: avoid collision after fix types in other method */
        public void mo7892a(BottomAppBar bottomAppBar) {
            super.mo7892a((Behavior) bottomAppBar);
            FloatingActionButton m7900t = bottomAppBar.m7900t();
            if (m7900t != null) {
                m7900t.m7663a(this.f3149d);
                m7900t.clearAnimation();
                m7900t.animate().translationY((-m7900t.getPaddingBottom()) + (m7900t.getMeasuredHeight() - this.f3149d.height())).setInterpolator(AnimationUtils.f423c).setDuration(175L);
            }
        }
    }

    /* renamed from: d */
    public final int m7904d(int i) {
        boolean z = ViewCompat.m9422k(this) == 1;
        if (i == 1) {
            return ((getMeasuredWidth() / 2) - this.f3139Q) * (z ? -1 : 1);
        }
        return 0;
    }

    /* renamed from: b */
    public final void m7909b(int i, List<Animator> list) {
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(m7900t(), "translationX", m7904d(i));
        ofFloat.setDuration(300L);
        list.add(ofFloat);
    }

    /* renamed from: a */
    public final void m7919a(int i, List<Animator> list) {
        if (this.f3147b0) {
            this.f3141S.m10938e();
            throw null;
        }
    }

    /* renamed from: b */
    public final void m7906b(FloatingActionButton floatingActionButton) {
        floatingActionButton.m7653c(this.f3148c0);
        floatingActionButton.m7650d(this.f3148c0);
    }

    /* renamed from: a */
    public final void m7918a(int i, boolean z) {
        if (ViewCompat.m9409x(this)) {
            Animator animator = this.f3144V;
            if (animator != null) {
                animator.cancel();
            }
            ArrayList arrayList = new ArrayList();
            if (!m7898v()) {
                i = 0;
                z = false;
            }
            m7917a(i, z, arrayList);
            AnimatorSet animatorSet = new AnimatorSet();
            animatorSet.playTogether(arrayList);
            this.f3144V = animatorSet;
            this.f3144V.addListener(new C0524b());
            this.f3144V.start();
        }
    }

    /* renamed from: a */
    public final void m7917a(int i, boolean z, List<Animator> list) {
        ActionMenuView actionMenuView = getActionMenuView();
        if (actionMenuView == null) {
            return;
        }
        Animator ofFloat = ObjectAnimator.ofFloat(actionMenuView, "alpha", 1.0f);
        if ((!this.f3147b0 && (!z || !m7898v())) || (this.f3145W != 1 && i != 1)) {
            if (actionMenuView.getAlpha() < 1.0f) {
                list.add(ofFloat);
                return;
            }
            return;
        }
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(actionMenuView, "alpha", 0.0f);
        ofFloat2.addListener(new C0525c(actionMenuView, i, z));
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.setDuration(150L);
        animatorSet.playSequentially(ofFloat2, ofFloat);
        list.add(animatorSet);
    }

    /* renamed from: a */
    public final float m7910a(boolean z) {
        FloatingActionButton m7900t = m7900t();
        if (m7900t == null) {
            return 0.0f;
        }
        Rect rect = new Rect();
        m7900t.m7663a(rect);
        float height = rect.height();
        if (height == 0.0f) {
            height = m7900t.getMeasuredHeight();
        }
        float height2 = m7900t.getHeight() - rect.height();
        float height3 = (-getCradleVerticalOffset()) + (height / 2.0f) + (m7900t.getHeight() - rect.bottom);
        float paddingBottom = height2 - m7900t.getPaddingBottom();
        float f = -getMeasuredHeight();
        if (z) {
            paddingBottom = height3;
        }
        return f + paddingBottom;
    }

    /* renamed from: a */
    public final void m7911a(ActionMenuView actionMenuView, int i, boolean z) {
        boolean z2 = ViewCompat.m9422k(this) == 1;
        int i2 = 0;
        for (int i3 = 0; i3 < getChildCount(); i3++) {
            View childAt = getChildAt(i3);
            if ((childAt.getLayoutParams() instanceof Toolbar.C0773e) && (((Toolbar.C0773e) childAt.getLayoutParams()).f1872a & 8388615) == 8388611) {
                i2 = Math.max(i2, z2 ? childAt.getLeft() : childAt.getRight());
            }
        }
        actionMenuView.setTranslationX((i == 1 && z) ? i2 - (z2 ? actionMenuView.getRight() : actionMenuView.getLeft()) : 0.0f);
    }

    /* renamed from: a */
    public final void m7912a(FloatingActionButton floatingActionButton) {
        m7906b(floatingActionButton);
        floatingActionButton.m7664a(this.f3148c0);
        floatingActionButton.m7657b(this.f3148c0);
    }
}
