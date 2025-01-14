package android.support.p067v7.widget;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.AttributeSet;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewPropertyAnimator;
import android.view.Window;
import android.widget.OverScroller;
import p000a.p006b.p030g.p045k.NestedScrollingParent;
import p000a.p006b.p030g.p045k.NestedScrollingParentHelper;
import p000a.p006b.p030g.p045k.ViewCompat;
import p000a.p006b.p049h.p051b.C0354a;
import p000a.p006b.p049h.p051b.C0359f;
import p000a.p006b.p049h.p061j.p062j.MenuPresenter;
import p000a.p006b.p049h.p063k.C0504t1;
import p000a.p006b.p049h.p063k.DecorContentParent;
import p000a.p006b.p049h.p063k.DecorToolbar;

/* renamed from: android.support.v7.widget.ActionBarOverlayLayout */
/* loaded from: classes.dex */
public class ActionBarOverlayLayout extends ViewGroup implements DecorContentParent, NestedScrollingParent {

    /* renamed from: C */
    public static final int[] f3975C = {C0354a.actionBarSize, 16842841};

    /* renamed from: A */
    public final Runnable f3976A;

    /* renamed from: B */
    public final NestedScrollingParentHelper f3977B;

    /* renamed from: a */
    public int f3978a;

    /* renamed from: b */
    public int f3979b;

    /* renamed from: c */
    public ContentFrameLayout f3980c;

    /* renamed from: d */
    public ActionBarContainer f3981d;

    /* renamed from: e */
    public DecorToolbar f3982e;

    /* renamed from: f */
    public Drawable f3983f;

    /* renamed from: g */
    public boolean f3984g;

    /* renamed from: h */
    public boolean f3985h;

    /* renamed from: i */
    public boolean f3986i;

    /* renamed from: j */
    public boolean f3987j;

    /* renamed from: k */
    public boolean f3988k;

    /* renamed from: m */
    public int f3989m;

    /* renamed from: n */
    public int f3990n;

    /* renamed from: o */
    public final Rect f3991o;

    /* renamed from: p */
    public final Rect f3992p;

    /* renamed from: q */
    public final Rect f3993q;

    /* renamed from: r */
    public final Rect f3994r;

    /* renamed from: s */
    public final Rect f3995s;

    /* renamed from: t */
    public final Rect f3996t;

    /* renamed from: u */
    public final Rect f3997u;

    /* renamed from: v */
    public InterfaceC0684d f3998v;

    /* renamed from: w */
    public OverScroller f3999w;

    /* renamed from: x */
    public ViewPropertyAnimator f4000x;

    /* renamed from: y */
    public final AnimatorListenerAdapter f4001y;

    /* renamed from: z */
    public final Runnable f4002z;

    /* renamed from: android.support.v7.widget.ActionBarOverlayLayout$a */
    /* loaded from: classes.dex */
    public class C0681a extends AnimatorListenerAdapter {
        public C0681a() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            ActionBarOverlayLayout actionBarOverlayLayout = ActionBarOverlayLayout.this;
            actionBarOverlayLayout.f4000x = null;
            actionBarOverlayLayout.f3988k = false;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            ActionBarOverlayLayout actionBarOverlayLayout = ActionBarOverlayLayout.this;
            actionBarOverlayLayout.f4000x = null;
            actionBarOverlayLayout.f3988k = false;
        }
    }

    /* renamed from: android.support.v7.widget.ActionBarOverlayLayout$b */
    /* loaded from: classes.dex */
    public class RunnableC0682b implements Runnable {
        public RunnableC0682b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            ActionBarOverlayLayout.this.m7108i();
            ActionBarOverlayLayout actionBarOverlayLayout = ActionBarOverlayLayout.this;
            actionBarOverlayLayout.f4000x = actionBarOverlayLayout.f3981d.animate().translationY(0.0f).setListener(ActionBarOverlayLayout.this.f4001y);
        }
    }

    /* renamed from: android.support.v7.widget.ActionBarOverlayLayout$c */
    /* loaded from: classes.dex */
    public class RunnableC0683c implements Runnable {
        public RunnableC0683c() {
        }

        @Override // java.lang.Runnable
        public void run() {
            ActionBarOverlayLayout.this.m7108i();
            ActionBarOverlayLayout actionBarOverlayLayout = ActionBarOverlayLayout.this;
            actionBarOverlayLayout.f4000x = actionBarOverlayLayout.f3981d.animate().translationY(-ActionBarOverlayLayout.this.f3981d.getHeight()).setListener(ActionBarOverlayLayout.this.f4001y);
        }
    }

    /* renamed from: android.support.v7.widget.ActionBarOverlayLayout$d */
    /* loaded from: classes.dex */
    public interface InterfaceC0684d {
        /* renamed from: a */
        void mo7102a();

        /* renamed from: a */
        void mo7101a(int i);

        /* renamed from: a */
        void mo7100a(boolean z);

        /* renamed from: b */
        void mo7099b();

        /* renamed from: c */
        void mo7098c();

        /* renamed from: d */
        void mo7097d();
    }

    /* renamed from: android.support.v7.widget.ActionBarOverlayLayout$e */
    /* loaded from: classes.dex */
    public static class C0685e extends ViewGroup.MarginLayoutParams {
        public C0685e(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }

        public C0685e(int i, int i2) {
            super(i, i2);
        }

        public C0685e(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
        }
    }

    public ActionBarOverlayLayout(Context context) {
        this(context, null);
    }

    /* renamed from: a */
    public final void m7119a(Context context) {
        TypedArray obtainStyledAttributes = getContext().getTheme().obtainStyledAttributes(f3975C);
        this.f3978a = obtainStyledAttributes.getDimensionPixelSize(0, 0);
        this.f3983f = obtainStyledAttributes.getDrawable(1);
        setWillNotDraw(this.f3983f == null);
        obtainStyledAttributes.recycle();
        this.f3984g = context.getApplicationInfo().targetSdkVersion < 19;
        this.f3999w = new OverScroller(context);
    }

    @Override // p000a.p006b.p049h.p063k.DecorContentParent
    /* renamed from: b */
    public void mo7115b() {
        m7104m();
        this.f3982e.mo8212b();
    }

    @Override // p000a.p006b.p049h.p063k.DecorContentParent
    /* renamed from: c */
    public boolean mo7114c() {
        m7104m();
        return this.f3982e.mo8207c();
    }

    @Override // android.view.ViewGroup
    public boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof C0685e;
    }

    @Override // p000a.p006b.p049h.p063k.DecorContentParent
    /* renamed from: d */
    public boolean mo7113d() {
        m7104m();
        return this.f3982e.mo8204d();
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        super.draw(canvas);
        if (this.f3983f == null || this.f3984g) {
            return;
        }
        int bottom = this.f3981d.getVisibility() == 0 ? (int) (this.f3981d.getBottom() + this.f3981d.getTranslationY() + 0.5f) : 0;
        this.f3983f.setBounds(0, bottom, getWidth(), this.f3983f.getIntrinsicHeight() + bottom);
        this.f3983f.draw(canvas);
    }

    @Override // p000a.p006b.p049h.p063k.DecorContentParent
    /* renamed from: e */
    public boolean mo7112e() {
        m7104m();
        return this.f3982e.mo8201e();
    }

    @Override // p000a.p006b.p049h.p063k.DecorContentParent
    /* renamed from: f */
    public boolean mo7111f() {
        m7104m();
        return this.f3982e.mo8199f();
    }

    @Override // android.view.View
    public boolean fitSystemWindows(Rect rect) {
        m7104m();
        int m9416q = ViewCompat.m9416q(this) & 256;
        boolean m7116a = m7116a(this.f3981d, rect, true, true, false, true);
        this.f3994r.set(rect);
        C0504t1.m8046a(this, this.f3994r, this.f3991o);
        if (!this.f3995s.equals(this.f3994r)) {
            this.f3995s.set(this.f3994r);
            m7116a = true;
        }
        if (!this.f3992p.equals(this.f3991o)) {
            this.f3992p.set(this.f3991o);
            m7116a = true;
        }
        if (m7116a) {
            requestLayout();
        }
        return true;
    }

    @Override // p000a.p006b.p049h.p063k.DecorContentParent
    /* renamed from: g */
    public void mo7110g() {
        m7104m();
        this.f3982e.mo8198g();
    }

    public int getActionBarHideOffset() {
        ActionBarContainer actionBarContainer = this.f3981d;
        if (actionBarContainer != null) {
            return -((int) actionBarContainer.getTranslationY());
        }
        return 0;
    }

    @Override // android.view.ViewGroup
    public int getNestedScrollAxes() {
        return this.f3977B.m9482a();
    }

    public CharSequence getTitle() {
        m7104m();
        return this.f3982e.getTitle();
    }

    /* renamed from: h */
    public final void m7109h() {
        m7108i();
        this.f3976A.run();
    }

    /* renamed from: i */
    public void m7108i() {
        removeCallbacks(this.f4002z);
        removeCallbacks(this.f3976A);
        ViewPropertyAnimator viewPropertyAnimator = this.f4000x;
        if (viewPropertyAnimator != null) {
            viewPropertyAnimator.cancel();
        }
    }

    /* renamed from: j */
    public boolean m7107j() {
        return this.f3985h;
    }

    /* renamed from: k */
    public final void m7106k() {
        m7108i();
        postDelayed(this.f3976A, 600L);
    }

    /* renamed from: l */
    public final void m7105l() {
        m7108i();
        postDelayed(this.f4002z, 600L);
    }

    /* renamed from: m */
    public void m7104m() {
        if (this.f3980c == null) {
            this.f3980c = (ContentFrameLayout) findViewById(C0359f.action_bar_activity_content);
            this.f3981d = (ActionBarContainer) findViewById(C0359f.action_bar_container);
            this.f3982e = m7117a(findViewById(C0359f.action_bar));
        }
    }

    /* renamed from: n */
    public final void m7103n() {
        m7108i();
        this.f4002z.run();
    }

    @Override // android.view.View
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        m7119a(getContext());
        ViewCompat.m9463B(this);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        m7108i();
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int childCount = getChildCount();
        int paddingLeft = getPaddingLeft();
        getPaddingRight();
        int paddingTop = getPaddingTop();
        getPaddingBottom();
        for (int i5 = 0; i5 < childCount; i5++) {
            View childAt = getChildAt(i5);
            if (childAt.getVisibility() != 8) {
                C0685e c0685e = (C0685e) childAt.getLayoutParams();
                int measuredWidth = childAt.getMeasuredWidth();
                int measuredHeight = childAt.getMeasuredHeight();
                int i6 = ((ViewGroup.MarginLayoutParams) c0685e).leftMargin + paddingLeft;
                int i7 = ((ViewGroup.MarginLayoutParams) c0685e).topMargin + paddingTop;
                childAt.layout(i6, i7, measuredWidth + i6, measuredHeight + i7);
            }
        }
    }

    @Override // android.view.View
    public void onMeasure(int i, int i2) {
        int measuredHeight;
        m7104m();
        measureChildWithMargins(this.f3981d, i, 0, i2, 0);
        C0685e c0685e = (C0685e) this.f3981d.getLayoutParams();
        int max = Math.max(0, this.f3981d.getMeasuredWidth() + ((ViewGroup.MarginLayoutParams) c0685e).leftMargin + ((ViewGroup.MarginLayoutParams) c0685e).rightMargin);
        int max2 = Math.max(0, this.f3981d.getMeasuredHeight() + ((ViewGroup.MarginLayoutParams) c0685e).topMargin + ((ViewGroup.MarginLayoutParams) c0685e).bottomMargin);
        int combineMeasuredStates = View.combineMeasuredStates(0, this.f3981d.getMeasuredState());
        boolean z = (ViewCompat.m9416q(this) & 256) != 0;
        if (z) {
            measuredHeight = this.f3978a;
            if (this.f3986i && this.f3981d.getTabContainer() != null) {
                measuredHeight += this.f3978a;
            }
        } else {
            measuredHeight = this.f3981d.getVisibility() != 8 ? this.f3981d.getMeasuredHeight() : 0;
        }
        this.f3993q.set(this.f3991o);
        this.f3996t.set(this.f3994r);
        if (!this.f3985h && !z) {
            Rect rect = this.f3993q;
            rect.top += measuredHeight;
            rect.bottom += 0;
        } else {
            Rect rect2 = this.f3996t;
            rect2.top += measuredHeight;
            rect2.bottom += 0;
        }
        m7116a(this.f3980c, this.f3993q, true, true, true, true);
        if (!this.f3997u.equals(this.f3996t)) {
            this.f3997u.set(this.f3996t);
            this.f3980c.m7059a(this.f3996t);
        }
        measureChildWithMargins(this.f3980c, i, 0, i2, 0);
        C0685e c0685e2 = (C0685e) this.f3980c.getLayoutParams();
        int max3 = Math.max(max, this.f3980c.getMeasuredWidth() + ((ViewGroup.MarginLayoutParams) c0685e2).leftMargin + ((ViewGroup.MarginLayoutParams) c0685e2).rightMargin);
        int max4 = Math.max(max2, this.f3980c.getMeasuredHeight() + ((ViewGroup.MarginLayoutParams) c0685e2).topMargin + ((ViewGroup.MarginLayoutParams) c0685e2).bottomMargin);
        int combineMeasuredStates2 = View.combineMeasuredStates(combineMeasuredStates, this.f3980c.getMeasuredState());
        setMeasuredDimension(View.resolveSizeAndState(Math.max(max3 + getPaddingLeft() + getPaddingRight(), getSuggestedMinimumWidth()), i, combineMeasuredStates2), View.resolveSizeAndState(Math.max(max4 + getPaddingTop() + getPaddingBottom(), getSuggestedMinimumHeight()), i2, combineMeasuredStates2 << 16));
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, p000a.p006b.p030g.p045k.NestedScrollingParent
    public boolean onNestedFling(View view, float f, float f2, boolean z) {
        if (this.f3987j && z) {
            if (m7121a(f, f2)) {
                m7109h();
            } else {
                m7103n();
            }
            this.f3988k = true;
            return true;
        }
        return false;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, p000a.p006b.p030g.p045k.NestedScrollingParent
    public boolean onNestedPreFling(View view, float f, float f2) {
        return false;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, p000a.p006b.p030g.p045k.NestedScrollingParent
    public void onNestedPreScroll(View view, int i, int i2, int[] iArr) {
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, p000a.p006b.p030g.p045k.NestedScrollingParent
    public void onNestedScroll(View view, int i, int i2, int i3, int i4) {
        this.f3989m += i2;
        setActionBarHideOffset(this.f3989m);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, p000a.p006b.p030g.p045k.NestedScrollingParent
    public void onNestedScrollAccepted(View view, View view2, int i) {
        this.f3977B.m9479a(view, view2, i);
        this.f3989m = getActionBarHideOffset();
        m7108i();
        InterfaceC0684d interfaceC0684d = this.f3998v;
        if (interfaceC0684d != null) {
            interfaceC0684d.mo7099b();
        }
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, p000a.p006b.p030g.p045k.NestedScrollingParent
    public boolean onStartNestedScroll(View view, View view2, int i) {
        if ((i & 2) == 0 || this.f3981d.getVisibility() != 0) {
            return false;
        }
        return this.f3987j;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, p000a.p006b.p030g.p045k.NestedScrollingParent
    public void onStopNestedScroll(View view) {
        if (this.f3987j && !this.f3988k) {
            if (this.f3989m <= this.f3981d.getHeight()) {
                m7105l();
            } else {
                m7106k();
            }
        }
        InterfaceC0684d interfaceC0684d = this.f3998v;
        if (interfaceC0684d != null) {
            interfaceC0684d.mo7098c();
        }
    }

    @Override // android.view.View
    public void onWindowSystemUiVisibilityChanged(int i) {
        if (Build.VERSION.SDK_INT >= 16) {
            super.onWindowSystemUiVisibilityChanged(i);
        }
        m7104m();
        int i2 = this.f3990n ^ i;
        this.f3990n = i;
        boolean z = (i & 4) == 0;
        boolean z2 = (i & 256) != 0;
        InterfaceC0684d interfaceC0684d = this.f3998v;
        if (interfaceC0684d != null) {
            interfaceC0684d.mo7100a(!z2);
            if (!z && z2) {
                this.f3998v.mo7097d();
            } else {
                this.f3998v.mo7102a();
            }
        }
        if ((i2 & 256) == 0 || this.f3998v == null) {
            return;
        }
        ViewCompat.m9463B(this);
    }

    @Override // android.view.View
    public void onWindowVisibilityChanged(int i) {
        super.onWindowVisibilityChanged(i);
        this.f3979b = i;
        InterfaceC0684d interfaceC0684d = this.f3998v;
        if (interfaceC0684d != null) {
            interfaceC0684d.mo7101a(i);
        }
    }

    public void setActionBarHideOffset(int i) {
        m7108i();
        this.f3981d.setTranslationY(-Math.max(0, Math.min(i, this.f3981d.getHeight())));
    }

    public void setActionBarVisibilityCallback(InterfaceC0684d interfaceC0684d) {
        this.f3998v = interfaceC0684d;
        if (getWindowToken() != null) {
            this.f3998v.mo7101a(this.f3979b);
            int i = this.f3990n;
            if (i != 0) {
                onWindowSystemUiVisibilityChanged(i);
                ViewCompat.m9463B(this);
            }
        }
    }

    public void setHasNonEmbeddedTabs(boolean z) {
        this.f3986i = z;
    }

    public void setHideOnContentScrollEnabled(boolean z) {
        if (z != this.f3987j) {
            this.f3987j = z;
            if (z) {
                return;
            }
            m7108i();
            setActionBarHideOffset(0);
        }
    }

    public void setIcon(int i) {
        m7104m();
        this.f3982e.setIcon(i);
    }

    public void setLogo(int i) {
        m7104m();
        this.f3982e.mo8206c(i);
    }

    public void setOverlayMode(boolean z) {
        this.f3985h = z;
        this.f3984g = z && getContext().getApplicationInfo().targetSdkVersion < 19;
    }

    public void setShowingForActionMode(boolean z) {
    }

    public void setUiOptions(int i) {
    }

    @Override // p000a.p006b.p049h.p063k.DecorContentParent
    public void setWindowCallback(Window.Callback callback) {
        m7104m();
        this.f3982e.setWindowCallback(callback);
    }

    @Override // p000a.p006b.p049h.p063k.DecorContentParent
    public void setWindowTitle(CharSequence charSequence) {
        m7104m();
        this.f3982e.setWindowTitle(charSequence);
    }

    @Override // android.view.ViewGroup
    public boolean shouldDelayChildPressedState() {
        return false;
    }

    public ActionBarOverlayLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f3979b = 0;
        this.f3991o = new Rect();
        this.f3992p = new Rect();
        this.f3993q = new Rect();
        this.f3994r = new Rect();
        this.f3995s = new Rect();
        this.f3996t = new Rect();
        this.f3997u = new Rect();
        this.f4001y = new C0681a();
        this.f4002z = new RunnableC0682b();
        this.f3976A = new RunnableC0683c();
        m7119a(context);
        this.f3977B = new NestedScrollingParentHelper(this);
    }

    @Override // android.view.ViewGroup
    public C0685e generateDefaultLayoutParams() {
        return new C0685e(-1, -1);
    }

    @Override // android.view.ViewGroup
    public C0685e generateLayoutParams(AttributeSet attributeSet) {
        return new C0685e(getContext(), attributeSet);
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return new C0685e(layoutParams);
    }

    public void setIcon(Drawable drawable) {
        m7104m();
        this.f3982e.setIcon(drawable);
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x0021  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x002c  */
    /* JADX WARN: Removed duplicated region for block: B:21:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0016  */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final boolean m7116a(android.view.View r3, android.graphics.Rect r4, boolean r5, boolean r6, boolean r7, boolean r8) {
        /*
            r2 = this;
            android.view.ViewGroup$LayoutParams r3 = r3.getLayoutParams()
            android.support.v7.widget.ActionBarOverlayLayout$e r3 = (android.support.p067v7.widget.ActionBarOverlayLayout.C0685e) r3
            r0 = 1
            if (r5 == 0) goto L13
            int r5 = r3.leftMargin
            int r1 = r4.left
            if (r5 == r1) goto L13
            r3.leftMargin = r1
            r5 = 1
            goto L14
        L13:
            r5 = 0
        L14:
            if (r6 == 0) goto L1f
            int r6 = r3.topMargin
            int r1 = r4.top
            if (r6 == r1) goto L1f
            r3.topMargin = r1
            r5 = 1
        L1f:
            if (r8 == 0) goto L2a
            int r6 = r3.rightMargin
            int r8 = r4.right
            if (r6 == r8) goto L2a
            r3.rightMargin = r8
            r5 = 1
        L2a:
            if (r7 == 0) goto L35
            int r6 = r3.bottomMargin
            int r4 = r4.bottom
            if (r6 == r4) goto L35
            r3.bottomMargin = r4
            r5 = 1
        L35:
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.p067v7.widget.ActionBarOverlayLayout.m7116a(android.view.View, android.graphics.Rect, boolean, boolean, boolean, boolean):boolean");
    }

    /* renamed from: a */
    public final DecorToolbar m7117a(View view) {
        if (view instanceof DecorToolbar) {
            return (DecorToolbar) view;
        }
        if (view instanceof Toolbar) {
            return ((Toolbar) view).getWrapper();
        }
        throw new IllegalStateException("Can't make a decor toolbar out of " + view.getClass().getSimpleName());
    }

    /* renamed from: a */
    public final boolean m7121a(float f, float f2) {
        this.f3999w.fling(0, 0, 0, (int) f2, 0, 0, Integer.MIN_VALUE, Integer.MAX_VALUE);
        return this.f3999w.getFinalY() > this.f3981d.getHeight();
    }

    @Override // p000a.p006b.p049h.p063k.DecorContentParent
    /* renamed from: a */
    public void mo7120a(int i) {
        m7104m();
        if (i == 2) {
            this.f3982e.mo8191n();
        } else if (i == 5) {
            this.f3982e.mo8190o();
        } else if (i != 109) {
        } else {
            setOverlayMode(true);
        }
    }

    @Override // p000a.p006b.p049h.p063k.DecorContentParent
    /* renamed from: a */
    public boolean mo7122a() {
        m7104m();
        return this.f3982e.mo8222a();
    }

    @Override // p000a.p006b.p049h.p063k.DecorContentParent
    /* renamed from: a */
    public void mo7118a(Menu menu, MenuPresenter.InterfaceC0434a interfaceC0434a) {
        m7104m();
        this.f3982e.mo8216a(menu, interfaceC0434a);
    }
}
