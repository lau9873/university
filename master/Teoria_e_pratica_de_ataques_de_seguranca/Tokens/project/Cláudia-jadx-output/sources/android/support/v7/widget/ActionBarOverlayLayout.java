package android.support.v7.widget;

import a.b.g.k.n;
import a.b.g.k.o;
import a.b.g.k.u;
import a.b.h.b.f;
import a.b.h.j.j.p;
import a.b.h.k.h0;
import a.b.h.k.i0;
import a.b.h.k.t1;
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
/* loaded from: classes.dex */
public class ActionBarOverlayLayout extends ViewGroup implements h0, n {
    public static final int[] C = {a.b.h.b.a.actionBarSize, 16842841};
    public final Runnable A;
    public final o B;

    /* renamed from: a  reason: collision with root package name */
    public int f2483a;

    /* renamed from: b  reason: collision with root package name */
    public int f2484b;

    /* renamed from: c  reason: collision with root package name */
    public ContentFrameLayout f2485c;

    /* renamed from: d  reason: collision with root package name */
    public ActionBarContainer f2486d;

    /* renamed from: e  reason: collision with root package name */
    public i0 f2487e;

    /* renamed from: f  reason: collision with root package name */
    public Drawable f2488f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f2489g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f2490h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f2491i;
    public boolean j;
    public boolean k;
    public int m;
    public int n;
    public final Rect o;
    public final Rect p;
    public final Rect q;
    public final Rect r;
    public final Rect s;
    public final Rect t;
    public final Rect u;
    public d v;
    public OverScroller w;
    public ViewPropertyAnimator x;
    public final AnimatorListenerAdapter y;
    public final Runnable z;

    /* loaded from: classes.dex */
    public class a extends AnimatorListenerAdapter {
        public a() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            ActionBarOverlayLayout actionBarOverlayLayout = ActionBarOverlayLayout.this;
            actionBarOverlayLayout.x = null;
            actionBarOverlayLayout.k = false;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            ActionBarOverlayLayout actionBarOverlayLayout = ActionBarOverlayLayout.this;
            actionBarOverlayLayout.x = null;
            actionBarOverlayLayout.k = false;
        }
    }

    /* loaded from: classes.dex */
    public class b implements Runnable {
        public b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            ActionBarOverlayLayout.this.i();
            ActionBarOverlayLayout actionBarOverlayLayout = ActionBarOverlayLayout.this;
            actionBarOverlayLayout.x = actionBarOverlayLayout.f2486d.animate().translationY(0.0f).setListener(ActionBarOverlayLayout.this.y);
        }
    }

    /* loaded from: classes.dex */
    public class c implements Runnable {
        public c() {
        }

        @Override // java.lang.Runnable
        public void run() {
            ActionBarOverlayLayout.this.i();
            ActionBarOverlayLayout actionBarOverlayLayout = ActionBarOverlayLayout.this;
            actionBarOverlayLayout.x = actionBarOverlayLayout.f2486d.animate().translationY(-ActionBarOverlayLayout.this.f2486d.getHeight()).setListener(ActionBarOverlayLayout.this.y);
        }
    }

    /* loaded from: classes.dex */
    public interface d {
        void a();

        void a(int i2);

        void a(boolean z);

        void b();

        void c();

        void d();
    }

    /* loaded from: classes.dex */
    public static class e extends ViewGroup.MarginLayoutParams {
        public e(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }

        public e(int i2, int i3) {
            super(i2, i3);
        }

        public e(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
        }
    }

    public ActionBarOverlayLayout(Context context) {
        this(context, null);
    }

    public final void a(Context context) {
        TypedArray obtainStyledAttributes = getContext().getTheme().obtainStyledAttributes(C);
        this.f2483a = obtainStyledAttributes.getDimensionPixelSize(0, 0);
        this.f2488f = obtainStyledAttributes.getDrawable(1);
        setWillNotDraw(this.f2488f == null);
        obtainStyledAttributes.recycle();
        this.f2489g = context.getApplicationInfo().targetSdkVersion < 19;
        this.w = new OverScroller(context);
    }

    @Override // a.b.h.k.h0
    public void b() {
        m();
        this.f2487e.b();
    }

    @Override // a.b.h.k.h0
    public boolean c() {
        m();
        return this.f2487e.c();
    }

    @Override // android.view.ViewGroup
    public boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof e;
    }

    @Override // a.b.h.k.h0
    public boolean d() {
        m();
        return this.f2487e.d();
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        super.draw(canvas);
        if (this.f2488f == null || this.f2489g) {
            return;
        }
        int bottom = this.f2486d.getVisibility() == 0 ? (int) (this.f2486d.getBottom() + this.f2486d.getTranslationY() + 0.5f) : 0;
        this.f2488f.setBounds(0, bottom, getWidth(), this.f2488f.getIntrinsicHeight() + bottom);
        this.f2488f.draw(canvas);
    }

    @Override // a.b.h.k.h0
    public boolean e() {
        m();
        return this.f2487e.e();
    }

    @Override // a.b.h.k.h0
    public boolean f() {
        m();
        return this.f2487e.f();
    }

    @Override // android.view.View
    public boolean fitSystemWindows(Rect rect) {
        m();
        int q = u.q(this) & 256;
        boolean a2 = a(this.f2486d, rect, true, true, false, true);
        this.r.set(rect);
        t1.a(this, this.r, this.o);
        if (!this.s.equals(this.r)) {
            this.s.set(this.r);
            a2 = true;
        }
        if (!this.p.equals(this.o)) {
            this.p.set(this.o);
            a2 = true;
        }
        if (a2) {
            requestLayout();
        }
        return true;
    }

    @Override // a.b.h.k.h0
    public void g() {
        m();
        this.f2487e.g();
    }

    public int getActionBarHideOffset() {
        ActionBarContainer actionBarContainer = this.f2486d;
        if (actionBarContainer != null) {
            return -((int) actionBarContainer.getTranslationY());
        }
        return 0;
    }

    @Override // android.view.ViewGroup
    public int getNestedScrollAxes() {
        return this.B.a();
    }

    public CharSequence getTitle() {
        m();
        return this.f2487e.getTitle();
    }

    public final void h() {
        i();
        this.A.run();
    }

    public void i() {
        removeCallbacks(this.z);
        removeCallbacks(this.A);
        ViewPropertyAnimator viewPropertyAnimator = this.x;
        if (viewPropertyAnimator != null) {
            viewPropertyAnimator.cancel();
        }
    }

    public boolean j() {
        return this.f2490h;
    }

    public final void k() {
        i();
        postDelayed(this.A, 600L);
    }

    public final void l() {
        i();
        postDelayed(this.z, 600L);
    }

    public void m() {
        if (this.f2485c == null) {
            this.f2485c = (ContentFrameLayout) findViewById(f.action_bar_activity_content);
            this.f2486d = (ActionBarContainer) findViewById(f.action_bar_container);
            this.f2487e = a(findViewById(f.action_bar));
        }
    }

    public final void n() {
        i();
        this.z.run();
    }

    @Override // android.view.View
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        a(getContext());
        u.B(this);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        i();
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        int childCount = getChildCount();
        int paddingLeft = getPaddingLeft();
        getPaddingRight();
        int paddingTop = getPaddingTop();
        getPaddingBottom();
        for (int i6 = 0; i6 < childCount; i6++) {
            View childAt = getChildAt(i6);
            if (childAt.getVisibility() != 8) {
                e eVar = (e) childAt.getLayoutParams();
                int measuredWidth = childAt.getMeasuredWidth();
                int measuredHeight = childAt.getMeasuredHeight();
                int i7 = ((ViewGroup.MarginLayoutParams) eVar).leftMargin + paddingLeft;
                int i8 = ((ViewGroup.MarginLayoutParams) eVar).topMargin + paddingTop;
                childAt.layout(i7, i8, measuredWidth + i7, measuredHeight + i8);
            }
        }
    }

    @Override // android.view.View
    public void onMeasure(int i2, int i3) {
        int measuredHeight;
        m();
        measureChildWithMargins(this.f2486d, i2, 0, i3, 0);
        e eVar = (e) this.f2486d.getLayoutParams();
        int max = Math.max(0, this.f2486d.getMeasuredWidth() + ((ViewGroup.MarginLayoutParams) eVar).leftMargin + ((ViewGroup.MarginLayoutParams) eVar).rightMargin);
        int max2 = Math.max(0, this.f2486d.getMeasuredHeight() + ((ViewGroup.MarginLayoutParams) eVar).topMargin + ((ViewGroup.MarginLayoutParams) eVar).bottomMargin);
        int combineMeasuredStates = View.combineMeasuredStates(0, this.f2486d.getMeasuredState());
        boolean z = (u.q(this) & 256) != 0;
        if (z) {
            measuredHeight = this.f2483a;
            if (this.f2491i && this.f2486d.getTabContainer() != null) {
                measuredHeight += this.f2483a;
            }
        } else {
            measuredHeight = this.f2486d.getVisibility() != 8 ? this.f2486d.getMeasuredHeight() : 0;
        }
        this.q.set(this.o);
        this.t.set(this.r);
        if (!this.f2490h && !z) {
            Rect rect = this.q;
            rect.top += measuredHeight;
            rect.bottom += 0;
        } else {
            Rect rect2 = this.t;
            rect2.top += measuredHeight;
            rect2.bottom += 0;
        }
        a(this.f2485c, this.q, true, true, true, true);
        if (!this.u.equals(this.t)) {
            this.u.set(this.t);
            this.f2485c.a(this.t);
        }
        measureChildWithMargins(this.f2485c, i2, 0, i3, 0);
        e eVar2 = (e) this.f2485c.getLayoutParams();
        int max3 = Math.max(max, this.f2485c.getMeasuredWidth() + ((ViewGroup.MarginLayoutParams) eVar2).leftMargin + ((ViewGroup.MarginLayoutParams) eVar2).rightMargin);
        int max4 = Math.max(max2, this.f2485c.getMeasuredHeight() + ((ViewGroup.MarginLayoutParams) eVar2).topMargin + ((ViewGroup.MarginLayoutParams) eVar2).bottomMargin);
        int combineMeasuredStates2 = View.combineMeasuredStates(combineMeasuredStates, this.f2485c.getMeasuredState());
        setMeasuredDimension(View.resolveSizeAndState(Math.max(max3 + getPaddingLeft() + getPaddingRight(), getSuggestedMinimumWidth()), i2, combineMeasuredStates2), View.resolveSizeAndState(Math.max(max4 + getPaddingTop() + getPaddingBottom(), getSuggestedMinimumHeight()), i3, combineMeasuredStates2 << 16));
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, a.b.g.k.n
    public boolean onNestedFling(View view, float f2, float f3, boolean z) {
        if (this.j && z) {
            if (a(f2, f3)) {
                h();
            } else {
                n();
            }
            this.k = true;
            return true;
        }
        return false;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, a.b.g.k.n
    public boolean onNestedPreFling(View view, float f2, float f3) {
        return false;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, a.b.g.k.n
    public void onNestedPreScroll(View view, int i2, int i3, int[] iArr) {
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, a.b.g.k.n
    public void onNestedScroll(View view, int i2, int i3, int i4, int i5) {
        this.m += i3;
        setActionBarHideOffset(this.m);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, a.b.g.k.n
    public void onNestedScrollAccepted(View view, View view2, int i2) {
        this.B.a(view, view2, i2);
        this.m = getActionBarHideOffset();
        i();
        d dVar = this.v;
        if (dVar != null) {
            dVar.b();
        }
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, a.b.g.k.n
    public boolean onStartNestedScroll(View view, View view2, int i2) {
        if ((i2 & 2) == 0 || this.f2486d.getVisibility() != 0) {
            return false;
        }
        return this.j;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, a.b.g.k.n
    public void onStopNestedScroll(View view) {
        if (this.j && !this.k) {
            if (this.m <= this.f2486d.getHeight()) {
                l();
            } else {
                k();
            }
        }
        d dVar = this.v;
        if (dVar != null) {
            dVar.c();
        }
    }

    @Override // android.view.View
    public void onWindowSystemUiVisibilityChanged(int i2) {
        if (Build.VERSION.SDK_INT >= 16) {
            super.onWindowSystemUiVisibilityChanged(i2);
        }
        m();
        int i3 = this.n ^ i2;
        this.n = i2;
        boolean z = (i2 & 4) == 0;
        boolean z2 = (i2 & 256) != 0;
        d dVar = this.v;
        if (dVar != null) {
            dVar.a(!z2);
            if (!z && z2) {
                this.v.d();
            } else {
                this.v.a();
            }
        }
        if ((i3 & 256) == 0 || this.v == null) {
            return;
        }
        u.B(this);
    }

    @Override // android.view.View
    public void onWindowVisibilityChanged(int i2) {
        super.onWindowVisibilityChanged(i2);
        this.f2484b = i2;
        d dVar = this.v;
        if (dVar != null) {
            dVar.a(i2);
        }
    }

    public void setActionBarHideOffset(int i2) {
        i();
        this.f2486d.setTranslationY(-Math.max(0, Math.min(i2, this.f2486d.getHeight())));
    }

    public void setActionBarVisibilityCallback(d dVar) {
        this.v = dVar;
        if (getWindowToken() != null) {
            this.v.a(this.f2484b);
            int i2 = this.n;
            if (i2 != 0) {
                onWindowSystemUiVisibilityChanged(i2);
                u.B(this);
            }
        }
    }

    public void setHasNonEmbeddedTabs(boolean z) {
        this.f2491i = z;
    }

    public void setHideOnContentScrollEnabled(boolean z) {
        if (z != this.j) {
            this.j = z;
            if (z) {
                return;
            }
            i();
            setActionBarHideOffset(0);
        }
    }

    public void setIcon(int i2) {
        m();
        this.f2487e.setIcon(i2);
    }

    public void setLogo(int i2) {
        m();
        this.f2487e.c(i2);
    }

    public void setOverlayMode(boolean z) {
        this.f2490h = z;
        this.f2489g = z && getContext().getApplicationInfo().targetSdkVersion < 19;
    }

    public void setShowingForActionMode(boolean z) {
    }

    public void setUiOptions(int i2) {
    }

    @Override // a.b.h.k.h0
    public void setWindowCallback(Window.Callback callback) {
        m();
        this.f2487e.setWindowCallback(callback);
    }

    @Override // a.b.h.k.h0
    public void setWindowTitle(CharSequence charSequence) {
        m();
        this.f2487e.setWindowTitle(charSequence);
    }

    @Override // android.view.ViewGroup
    public boolean shouldDelayChildPressedState() {
        return false;
    }

    public ActionBarOverlayLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f2484b = 0;
        this.o = new Rect();
        this.p = new Rect();
        this.q = new Rect();
        this.r = new Rect();
        this.s = new Rect();
        this.t = new Rect();
        this.u = new Rect();
        this.y = new a();
        this.z = new b();
        this.A = new c();
        a(context);
        this.B = new o(this);
    }

    @Override // android.view.ViewGroup
    public e generateDefaultLayoutParams() {
        return new e(-1, -1);
    }

    @Override // android.view.ViewGroup
    public e generateLayoutParams(AttributeSet attributeSet) {
        return new e(getContext(), attributeSet);
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return new e(layoutParams);
    }

    public void setIcon(Drawable drawable) {
        m();
        this.f2487e.setIcon(drawable);
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x0021  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x002c  */
    /* JADX WARN: Removed duplicated region for block: B:21:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0016  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean a(android.view.View r3, android.graphics.Rect r4, boolean r5, boolean r6, boolean r7, boolean r8) {
        /*
            r2 = this;
            android.view.ViewGroup$LayoutParams r3 = r3.getLayoutParams()
            android.support.v7.widget.ActionBarOverlayLayout$e r3 = (android.support.v7.widget.ActionBarOverlayLayout.e) r3
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
        throw new UnsupportedOperationException("Method not decompiled: android.support.v7.widget.ActionBarOverlayLayout.a(android.view.View, android.graphics.Rect, boolean, boolean, boolean, boolean):boolean");
    }

    public final i0 a(View view) {
        if (view instanceof i0) {
            return (i0) view;
        }
        if (view instanceof Toolbar) {
            return ((Toolbar) view).getWrapper();
        }
        throw new IllegalStateException("Can't make a decor toolbar out of " + view.getClass().getSimpleName());
    }

    public final boolean a(float f2, float f3) {
        this.w.fling(0, 0, 0, (int) f3, 0, 0, Integer.MIN_VALUE, Integer.MAX_VALUE);
        return this.w.getFinalY() > this.f2486d.getHeight();
    }

    @Override // a.b.h.k.h0
    public void a(int i2) {
        m();
        if (i2 == 2) {
            this.f2487e.n();
        } else if (i2 == 5) {
            this.f2487e.o();
        } else if (i2 != 109) {
        } else {
            setOverlayMode(true);
        }
    }

    @Override // a.b.h.k.h0
    public boolean a() {
        m();
        return this.f2487e.a();
    }

    @Override // a.b.h.k.h0
    public void a(Menu menu, p.a aVar) {
        m();
        this.f2487e.a(menu, aVar);
    }
}
