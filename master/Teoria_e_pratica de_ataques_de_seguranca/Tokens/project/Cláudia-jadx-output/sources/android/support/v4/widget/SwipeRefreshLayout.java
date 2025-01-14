package android.support.v4.widget;

import a.b.g.k.k;
import a.b.g.k.l;
import a.b.g.k.n;
import a.b.g.k.o;
import a.b.g.k.u;
import android.content.Context;
import android.content.res.TypedArray;
import android.os.Build;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Transformation;
import android.widget.AbsListView;
import android.widget.ListView;
/* loaded from: classes.dex */
public class SwipeRefreshLayout extends ViewGroup implements n, k {
    public static final String P = SwipeRefreshLayout.class.getSimpleName();
    public static final int[] Q = {16842766};
    public int A;
    public int B;
    public a.b.g.l.d C;
    public Animation D;
    public Animation E;
    public Animation F;
    public Animation G;
    public Animation H;
    public boolean I;
    public int J;
    public boolean K;
    public i L;
    public Animation.AnimationListener M;
    public final Animation N;
    public final Animation O;

    /* renamed from: a  reason: collision with root package name */
    public View f2362a;

    /* renamed from: b  reason: collision with root package name */
    public j f2363b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f2364c;

    /* renamed from: d  reason: collision with root package name */
    public int f2365d;

    /* renamed from: e  reason: collision with root package name */
    public float f2366e;

    /* renamed from: f  reason: collision with root package name */
    public float f2367f;

    /* renamed from: g  reason: collision with root package name */
    public final o f2368g;

    /* renamed from: h  reason: collision with root package name */
    public final l f2369h;

    /* renamed from: i  reason: collision with root package name */
    public final int[] f2370i;
    public final int[] j;
    public boolean k;
    public int m;
    public int n;
    public float o;
    public float p;
    public boolean q;
    public int r;
    public boolean s;
    public boolean t;
    public final DecelerateInterpolator u;
    public a.b.g.l.c v;
    public int w;
    public int x;
    public float y;
    public int z;

    /* loaded from: classes.dex */
    public class a implements Animation.AnimationListener {
        public a() {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            j jVar;
            SwipeRefreshLayout swipeRefreshLayout = SwipeRefreshLayout.this;
            if (swipeRefreshLayout.f2364c) {
                swipeRefreshLayout.C.setAlpha(255);
                SwipeRefreshLayout.this.C.start();
                SwipeRefreshLayout swipeRefreshLayout2 = SwipeRefreshLayout.this;
                if (swipeRefreshLayout2.I && (jVar = swipeRefreshLayout2.f2363b) != null) {
                    jVar.e();
                }
                SwipeRefreshLayout swipeRefreshLayout3 = SwipeRefreshLayout.this;
                swipeRefreshLayout3.n = swipeRefreshLayout3.v.getTop();
                return;
            }
            swipeRefreshLayout.e();
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
        }
    }

    /* loaded from: classes.dex */
    public class b extends Animation {
        public b() {
        }

        @Override // android.view.animation.Animation
        public void applyTransformation(float f2, Transformation transformation) {
            SwipeRefreshLayout.this.setAnimationProgress(f2);
        }
    }

    /* loaded from: classes.dex */
    public class c extends Animation {
        public c() {
        }

        @Override // android.view.animation.Animation
        public void applyTransformation(float f2, Transformation transformation) {
            SwipeRefreshLayout.this.setAnimationProgress(1.0f - f2);
        }
    }

    /* loaded from: classes.dex */
    public class d extends Animation {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ int f2374a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ int f2375b;

        public d(int i2, int i3) {
            this.f2374a = i2;
            this.f2375b = i3;
        }

        @Override // android.view.animation.Animation
        public void applyTransformation(float f2, Transformation transformation) {
            a.b.g.l.d dVar = SwipeRefreshLayout.this.C;
            int i2 = this.f2374a;
            dVar.setAlpha((int) (i2 + ((this.f2375b - i2) * f2)));
        }
    }

    /* loaded from: classes.dex */
    public class e implements Animation.AnimationListener {
        public e() {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            SwipeRefreshLayout swipeRefreshLayout = SwipeRefreshLayout.this;
            if (swipeRefreshLayout.s) {
                return;
            }
            swipeRefreshLayout.a((Animation.AnimationListener) null);
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
        }
    }

    /* loaded from: classes.dex */
    public class f extends Animation {
        public f() {
        }

        @Override // android.view.animation.Animation
        public void applyTransformation(float f2, Transformation transformation) {
            int i2;
            SwipeRefreshLayout swipeRefreshLayout = SwipeRefreshLayout.this;
            if (!swipeRefreshLayout.K) {
                i2 = swipeRefreshLayout.A - Math.abs(swipeRefreshLayout.z);
            } else {
                i2 = swipeRefreshLayout.A;
            }
            SwipeRefreshLayout swipeRefreshLayout2 = SwipeRefreshLayout.this;
            int i3 = swipeRefreshLayout2.x;
            SwipeRefreshLayout.this.setTargetOffsetTopAndBottom((i3 + ((int) ((i2 - i3) * f2))) - swipeRefreshLayout2.v.getTop());
            SwipeRefreshLayout.this.C.a(1.0f - f2);
        }
    }

    /* loaded from: classes.dex */
    public class g extends Animation {
        public g() {
        }

        @Override // android.view.animation.Animation
        public void applyTransformation(float f2, Transformation transformation) {
            SwipeRefreshLayout.this.c(f2);
        }
    }

    /* loaded from: classes.dex */
    public class h extends Animation {
        public h() {
        }

        @Override // android.view.animation.Animation
        public void applyTransformation(float f2, Transformation transformation) {
            SwipeRefreshLayout swipeRefreshLayout = SwipeRefreshLayout.this;
            float f3 = swipeRefreshLayout.y;
            swipeRefreshLayout.setAnimationProgress(f3 + ((-f3) * f2));
            SwipeRefreshLayout.this.c(f2);
        }
    }

    /* loaded from: classes.dex */
    public interface i {
        boolean a(SwipeRefreshLayout swipeRefreshLayout, View view);
    }

    /* loaded from: classes.dex */
    public interface j {
        void e();
    }

    public SwipeRefreshLayout(Context context) {
        this(context, null);
    }

    private void setColorViewAlpha(int i2) {
        this.v.getBackground().setAlpha(i2);
        this.C.setAlpha(i2);
    }

    public final void a(boolean z, boolean z2) {
        if (this.f2364c != z) {
            this.I = z2;
            c();
            this.f2364c = z;
            if (this.f2364c) {
                a(this.n, this.M);
            } else {
                a(this.M);
            }
        }
    }

    public final void b() {
        this.v = new a.b.g.l.c(getContext(), -328966);
        this.C = new a.b.g.l.d(getContext());
        this.C.a(1);
        this.v.setImageDrawable(this.C);
        this.v.setVisibility(8);
        addView(this.v);
    }

    public final void c() {
        if (this.f2362a == null) {
            for (int i2 = 0; i2 < getChildCount(); i2++) {
                View childAt = getChildAt(i2);
                if (!childAt.equals(this.v)) {
                    this.f2362a = childAt;
                    return;
                }
            }
        }
    }

    public boolean d() {
        return this.f2364c;
    }

    @Override // android.view.View
    public boolean dispatchNestedFling(float f2, float f3, boolean z) {
        return this.f2369h.a(f2, f3, z);
    }

    @Override // android.view.View
    public boolean dispatchNestedPreFling(float f2, float f3) {
        return this.f2369h.a(f2, f3);
    }

    @Override // android.view.View
    public boolean dispatchNestedPreScroll(int i2, int i3, int[] iArr, int[] iArr2) {
        return this.f2369h.a(i2, i3, iArr, iArr2);
    }

    @Override // android.view.View
    public boolean dispatchNestedScroll(int i2, int i3, int i4, int i5, int[] iArr) {
        return this.f2369h.a(i2, i3, i4, i5, iArr);
    }

    public void e() {
        this.v.clearAnimation();
        this.C.stop();
        this.v.setVisibility(8);
        setColorViewAlpha(255);
        if (this.s) {
            setAnimationProgress(0.0f);
        } else {
            setTargetOffsetTopAndBottom(this.z - this.n);
        }
        this.n = this.v.getTop();
    }

    public final void f() {
        this.G = a(this.C.getAlpha(), 255);
    }

    public final void g() {
        this.F = a(this.C.getAlpha(), 76);
    }

    @Override // android.view.ViewGroup
    public int getChildDrawingOrder(int i2, int i3) {
        int i4 = this.w;
        return i4 < 0 ? i3 : i3 == i2 + (-1) ? i4 : i3 >= i4 ? i3 + 1 : i3;
    }

    @Override // android.view.ViewGroup
    public int getNestedScrollAxes() {
        return this.f2368g.a();
    }

    public int getProgressCircleDiameter() {
        return this.J;
    }

    public int getProgressViewEndOffset() {
        return this.A;
    }

    public int getProgressViewStartOffset() {
        return this.z;
    }

    @Override // android.view.View
    public boolean hasNestedScrollingParent() {
        return this.f2369h.a();
    }

    @Override // android.view.View, a.b.g.k.k
    public boolean isNestedScrollingEnabled() {
        return this.f2369h.b();
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        e();
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        c();
        int actionMasked = motionEvent.getActionMasked();
        if (this.t && actionMasked == 0) {
            this.t = false;
        }
        if (!isEnabled() || this.t || a() || this.f2364c || this.k) {
            return false;
        }
        if (actionMasked != 0) {
            if (actionMasked != 1) {
                if (actionMasked == 2) {
                    int i2 = this.r;
                    if (i2 == -1) {
                        Log.e(P, "Got ACTION_MOVE event but don't have an active pointer id.");
                        return false;
                    }
                    int findPointerIndex = motionEvent.findPointerIndex(i2);
                    if (findPointerIndex < 0) {
                        return false;
                    }
                    d(motionEvent.getY(findPointerIndex));
                } else if (actionMasked != 3) {
                    if (actionMasked == 6) {
                        a(motionEvent);
                    }
                }
            }
            this.q = false;
            this.r = -1;
        } else {
            setTargetOffsetTopAndBottom(this.z - this.v.getTop());
            this.r = motionEvent.getPointerId(0);
            this.q = false;
            int findPointerIndex2 = motionEvent.findPointerIndex(this.r);
            if (findPointerIndex2 < 0) {
                return false;
            }
            this.p = motionEvent.getY(findPointerIndex2);
        }
        return this.q;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        int measuredWidth = getMeasuredWidth();
        int measuredHeight = getMeasuredHeight();
        if (getChildCount() == 0) {
            return;
        }
        if (this.f2362a == null) {
            c();
        }
        View view = this.f2362a;
        if (view == null) {
            return;
        }
        int paddingLeft = getPaddingLeft();
        int paddingTop = getPaddingTop();
        view.layout(paddingLeft, paddingTop, ((measuredWidth - getPaddingLeft()) - getPaddingRight()) + paddingLeft, ((measuredHeight - getPaddingTop()) - getPaddingBottom()) + paddingTop);
        int measuredWidth2 = this.v.getMeasuredWidth();
        int measuredHeight2 = this.v.getMeasuredHeight();
        int i6 = measuredWidth / 2;
        int i7 = measuredWidth2 / 2;
        int i8 = this.n;
        this.v.layout(i6 - i7, i8, i6 + i7, measuredHeight2 + i8);
    }

    @Override // android.view.View
    public void onMeasure(int i2, int i3) {
        super.onMeasure(i2, i3);
        if (this.f2362a == null) {
            c();
        }
        View view = this.f2362a;
        if (view == null) {
            return;
        }
        view.measure(View.MeasureSpec.makeMeasureSpec((getMeasuredWidth() - getPaddingLeft()) - getPaddingRight(), 1073741824), View.MeasureSpec.makeMeasureSpec((getMeasuredHeight() - getPaddingTop()) - getPaddingBottom(), 1073741824));
        this.v.measure(View.MeasureSpec.makeMeasureSpec(this.J, 1073741824), View.MeasureSpec.makeMeasureSpec(this.J, 1073741824));
        this.w = -1;
        for (int i4 = 0; i4 < getChildCount(); i4++) {
            if (getChildAt(i4) == this.v) {
                this.w = i4;
                return;
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, a.b.g.k.n
    public boolean onNestedFling(View view, float f2, float f3, boolean z) {
        return dispatchNestedFling(f2, f3, z);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, a.b.g.k.n
    public boolean onNestedPreFling(View view, float f2, float f3) {
        return dispatchNestedPreFling(f2, f3);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, a.b.g.k.n
    public void onNestedPreScroll(View view, int i2, int i3, int[] iArr) {
        if (i3 > 0) {
            float f2 = this.f2367f;
            if (f2 > 0.0f) {
                float f3 = i3;
                if (f3 > f2) {
                    iArr[1] = i3 - ((int) f2);
                    this.f2367f = 0.0f;
                } else {
                    this.f2367f = f2 - f3;
                    iArr[1] = i3;
                }
                b(this.f2367f);
            }
        }
        if (this.K && i3 > 0 && this.f2367f == 0.0f && Math.abs(i3 - iArr[1]) > 0) {
            this.v.setVisibility(8);
        }
        int[] iArr2 = this.f2370i;
        if (dispatchNestedPreScroll(i2 - iArr[0], i3 - iArr[1], iArr2, null)) {
            iArr[0] = iArr[0] + iArr2[0];
            iArr[1] = iArr[1] + iArr2[1];
        }
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, a.b.g.k.n
    public void onNestedScroll(View view, int i2, int i3, int i4, int i5) {
        int i6;
        dispatchNestedScroll(i2, i3, i4, i5, this.j);
        if (i5 + this.j[1] >= 0 || a()) {
            return;
        }
        this.f2367f += Math.abs(i6);
        b(this.f2367f);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, a.b.g.k.n
    public void onNestedScrollAccepted(View view, View view2, int i2) {
        this.f2368g.a(view, view2, i2);
        startNestedScroll(i2 & 2);
        this.f2367f = 0.0f;
        this.k = true;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, a.b.g.k.n
    public boolean onStartNestedScroll(View view, View view2, int i2) {
        return (!isEnabled() || this.t || this.f2364c || (i2 & 2) == 0) ? false : true;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, a.b.g.k.n
    public void onStopNestedScroll(View view) {
        this.f2368g.a(view);
        this.k = false;
        float f2 = this.f2367f;
        if (f2 > 0.0f) {
            a(f2);
            this.f2367f = 0.0f;
        }
        stopNestedScroll();
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        int actionMasked = motionEvent.getActionMasked();
        if (this.t && actionMasked == 0) {
            this.t = false;
        }
        if (!isEnabled() || this.t || a() || this.f2364c || this.k) {
            return false;
        }
        if (actionMasked == 0) {
            this.r = motionEvent.getPointerId(0);
            this.q = false;
        } else if (actionMasked == 1) {
            int findPointerIndex = motionEvent.findPointerIndex(this.r);
            if (findPointerIndex < 0) {
                Log.e(P, "Got ACTION_UP event but don't have an active pointer id.");
                return false;
            }
            if (this.q) {
                this.q = false;
                a((motionEvent.getY(findPointerIndex) - this.o) * 0.5f);
            }
            this.r = -1;
            return false;
        } else if (actionMasked == 2) {
            int findPointerIndex2 = motionEvent.findPointerIndex(this.r);
            if (findPointerIndex2 < 0) {
                Log.e(P, "Got ACTION_MOVE event but have an invalid active pointer id.");
                return false;
            }
            float y = motionEvent.getY(findPointerIndex2);
            d(y);
            if (this.q) {
                float f2 = (y - this.o) * 0.5f;
                if (f2 <= 0.0f) {
                    return false;
                }
                b(f2);
            }
        } else if (actionMasked == 3) {
            return false;
        } else {
            if (actionMasked == 5) {
                int actionIndex = motionEvent.getActionIndex();
                if (actionIndex < 0) {
                    Log.e(P, "Got ACTION_POINTER_DOWN event but have an invalid action index.");
                    return false;
                }
                this.r = motionEvent.getPointerId(actionIndex);
            } else if (actionMasked == 6) {
                a(motionEvent);
            }
        }
        return true;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void requestDisallowInterceptTouchEvent(boolean z) {
        if (Build.VERSION.SDK_INT >= 21 || !(this.f2362a instanceof AbsListView)) {
            View view = this.f2362a;
            if (view == null || u.y(view)) {
                super.requestDisallowInterceptTouchEvent(z);
            }
        }
    }

    public void setAnimationProgress(float f2) {
        this.v.setScaleX(f2);
        this.v.setScaleY(f2);
    }

    @Deprecated
    public void setColorScheme(int... iArr) {
        setColorSchemeResources(iArr);
    }

    public void setColorSchemeColors(int... iArr) {
        c();
        this.C.a(iArr);
    }

    public void setColorSchemeResources(int... iArr) {
        Context context = getContext();
        int[] iArr2 = new int[iArr.length];
        for (int i2 = 0; i2 < iArr.length; i2++) {
            iArr2[i2] = a.b.g.b.b.a(context, iArr[i2]);
        }
        setColorSchemeColors(iArr2);
    }

    public void setDistanceToTriggerSync(int i2) {
        this.f2366e = i2;
    }

    @Override // android.view.View
    public void setEnabled(boolean z) {
        super.setEnabled(z);
        if (z) {
            return;
        }
        e();
    }

    @Override // android.view.View
    public void setNestedScrollingEnabled(boolean z) {
        this.f2369h.a(z);
    }

    public void setOnChildScrollUpCallback(i iVar) {
        this.L = iVar;
    }

    public void setOnRefreshListener(j jVar) {
        this.f2363b = jVar;
    }

    @Deprecated
    public void setProgressBackgroundColor(int i2) {
        setProgressBackgroundColorSchemeResource(i2);
    }

    public void setProgressBackgroundColorSchemeColor(int i2) {
        this.v.setBackgroundColor(i2);
    }

    public void setProgressBackgroundColorSchemeResource(int i2) {
        setProgressBackgroundColorSchemeColor(a.b.g.b.b.a(getContext(), i2));
    }

    public void setRefreshing(boolean z) {
        int i2;
        if (z && this.f2364c != z) {
            this.f2364c = z;
            if (!this.K) {
                i2 = this.A + this.z;
            } else {
                i2 = this.A;
            }
            setTargetOffsetTopAndBottom(i2 - this.n);
            this.I = false;
            b(this.M);
            return;
        }
        a(z, false);
    }

    public void setSize(int i2) {
        if (i2 == 0 || i2 == 1) {
            DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
            if (i2 == 0) {
                this.J = (int) (displayMetrics.density * 56.0f);
            } else {
                this.J = (int) (displayMetrics.density * 40.0f);
            }
            this.v.setImageDrawable(null);
            this.C.a(i2);
            this.v.setImageDrawable(this.C);
        }
    }

    public void setSlingshotDistance(int i2) {
        this.B = i2;
    }

    public void setTargetOffsetTopAndBottom(int i2) {
        this.v.bringToFront();
        u.d(this.v, i2);
        this.n = this.v.getTop();
    }

    @Override // android.view.View
    public boolean startNestedScroll(int i2) {
        return this.f2369h.c(i2);
    }

    @Override // android.view.View, a.b.g.k.k
    public void stopNestedScroll() {
        this.f2369h.c();
    }

    public SwipeRefreshLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f2364c = false;
        this.f2366e = -1.0f;
        this.f2370i = new int[2];
        this.j = new int[2];
        this.r = -1;
        this.w = -1;
        this.M = new a();
        this.N = new f();
        this.O = new g();
        this.f2365d = ViewConfiguration.get(context).getScaledTouchSlop();
        this.m = getResources().getInteger(17694721);
        setWillNotDraw(false);
        this.u = new DecelerateInterpolator(2.0f);
        DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
        this.J = (int) (displayMetrics.density * 40.0f);
        b();
        setChildrenDrawingOrderEnabled(true);
        this.A = (int) (displayMetrics.density * 64.0f);
        this.f2366e = this.A;
        this.f2368g = new o(this);
        this.f2369h = new l(this);
        setNestedScrollingEnabled(true);
        int i2 = -this.J;
        this.n = i2;
        this.z = i2;
        c(1.0f);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, Q);
        setEnabled(obtainStyledAttributes.getBoolean(0, true));
        obtainStyledAttributes.recycle();
    }

    public final void d(float f2) {
        float f3 = this.p;
        int i2 = this.f2365d;
        if (f2 - f3 <= i2 || this.q) {
            return;
        }
        this.o = f3 + i2;
        this.q = true;
        this.C.setAlpha(76);
    }

    public void c(float f2) {
        int i2 = this.x;
        setTargetOffsetTopAndBottom((i2 + ((int) ((this.z - i2) * f2))) - this.v.getTop());
    }

    public final void b(Animation.AnimationListener animationListener) {
        this.v.setVisibility(0);
        this.C.setAlpha(255);
        this.D = new b();
        this.D.setDuration(this.m);
        if (animationListener != null) {
            this.v.a(animationListener);
        }
        this.v.clearAnimation();
        this.v.startAnimation(this.D);
    }

    public void a(Animation.AnimationListener animationListener) {
        this.E = new c();
        this.E.setDuration(150L);
        this.v.a(animationListener);
        this.v.clearAnimation();
        this.v.startAnimation(this.E);
    }

    public final void c(int i2, Animation.AnimationListener animationListener) {
        this.x = i2;
        this.y = this.v.getScaleX();
        this.H = new h();
        this.H.setDuration(150L);
        if (animationListener != null) {
            this.v.a(animationListener);
        }
        this.v.clearAnimation();
        this.v.startAnimation(this.H);
    }

    public final Animation a(int i2, int i3) {
        d dVar = new d(i2, i3);
        dVar.setDuration(300L);
        this.v.a(null);
        this.v.clearAnimation();
        this.v.startAnimation(dVar);
        return dVar;
    }

    public final void b(float f2) {
        this.C.a(true);
        float min = Math.min(1.0f, Math.abs(f2 / this.f2366e));
        float max = (((float) Math.max(min - 0.4d, 0.0d)) * 5.0f) / 3.0f;
        float abs = Math.abs(f2) - this.f2366e;
        int i2 = this.B;
        if (i2 <= 0) {
            i2 = this.K ? this.A - this.z : this.A;
        }
        float f3 = i2;
        double max2 = Math.max(0.0f, Math.min(abs, f3 * 2.0f) / f3) / 4.0f;
        float pow = ((float) (max2 - Math.pow(max2, 2.0d))) * 2.0f;
        int i3 = this.z + ((int) ((f3 * min) + (f3 * pow * 2.0f)));
        if (this.v.getVisibility() != 0) {
            this.v.setVisibility(0);
        }
        if (!this.s) {
            this.v.setScaleX(1.0f);
            this.v.setScaleY(1.0f);
        }
        if (this.s) {
            setAnimationProgress(Math.min(1.0f, f2 / this.f2366e));
        }
        if (f2 < this.f2366e) {
            if (this.C.getAlpha() > 76 && !a(this.F)) {
                g();
            }
        } else if (this.C.getAlpha() < 255 && !a(this.G)) {
            f();
        }
        this.C.a(0.0f, Math.min(0.8f, max * 0.8f));
        this.C.a(Math.min(1.0f, max));
        this.C.b((((max * 0.4f) - 0.25f) + (pow * 2.0f)) * 0.5f);
        setTargetOffsetTopAndBottom(i3 - this.n);
    }

    public boolean a() {
        i iVar = this.L;
        if (iVar != null) {
            return iVar.a(this, this.f2362a);
        }
        View view = this.f2362a;
        if (view instanceof ListView) {
            return a.b.g.l.l.a((ListView) view, -1);
        }
        return view.canScrollVertically(-1);
    }

    public final boolean a(Animation animation) {
        return (animation == null || !animation.hasStarted() || animation.hasEnded()) ? false : true;
    }

    public final void a(float f2) {
        if (f2 > this.f2366e) {
            a(true, true);
            return;
        }
        this.f2364c = false;
        this.C.a(0.0f, 0.0f);
        b(this.n, this.s ? null : new e());
        this.C.a(false);
    }

    public final void a(int i2, Animation.AnimationListener animationListener) {
        this.x = i2;
        this.N.reset();
        this.N.setDuration(200L);
        this.N.setInterpolator(this.u);
        if (animationListener != null) {
            this.v.a(animationListener);
        }
        this.v.clearAnimation();
        this.v.startAnimation(this.N);
    }

    public final void a(MotionEvent motionEvent) {
        int actionIndex = motionEvent.getActionIndex();
        if (motionEvent.getPointerId(actionIndex) == this.r) {
            this.r = motionEvent.getPointerId(actionIndex == 0 ? 1 : 0);
        }
    }

    public final void b(int i2, Animation.AnimationListener animationListener) {
        if (this.s) {
            c(i2, animationListener);
            return;
        }
        this.x = i2;
        this.O.reset();
        this.O.setDuration(200L);
        this.O.setInterpolator(this.u);
        if (animationListener != null) {
            this.v.a(animationListener);
        }
        this.v.clearAnimation();
        this.v.startAnimation(this.O);
    }
}
