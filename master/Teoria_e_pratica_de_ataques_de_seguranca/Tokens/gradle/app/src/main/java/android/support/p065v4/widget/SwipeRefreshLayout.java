package android.support.p065v4.widget;

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
import p000a.p006b.p030g.p032b.ContextCompat;
import p000a.p006b.p030g.p045k.NestedScrollingChild;
import p000a.p006b.p030g.p045k.NestedScrollingChildHelper;
import p000a.p006b.p030g.p045k.NestedScrollingParent;
import p000a.p006b.p030g.p045k.NestedScrollingParentHelper;
import p000a.p006b.p030g.p045k.ViewCompat;
import p000a.p006b.p030g.p048l.CircleImageView;
import p000a.p006b.p030g.p048l.CircularProgressDrawable;
import p000a.p006b.p030g.p048l.ListViewCompat;

/* renamed from: android.support.v4.widget.SwipeRefreshLayout */
/* loaded from: classes.dex */
public class SwipeRefreshLayout extends ViewGroup implements NestedScrollingParent, NestedScrollingChild {

    /* renamed from: P */
    public static final String f3655P = SwipeRefreshLayout.class.getSimpleName();

    /* renamed from: Q */
    public static final int[] f3656Q = {16842766};

    /* renamed from: A */
    public int f3657A;

    /* renamed from: B */
    public int f3658B;

    /* renamed from: C */
    public CircularProgressDrawable f3659C;

    /* renamed from: D */
    public Animation f3660D;

    /* renamed from: E */
    public Animation f3661E;

    /* renamed from: F */
    public Animation f3662F;

    /* renamed from: G */
    public Animation f3663G;

    /* renamed from: H */
    public Animation f3664H;

    /* renamed from: I */
    public boolean f3665I;

    /* renamed from: J */
    public int f3666J;

    /* renamed from: K */
    public boolean f3667K;

    /* renamed from: L */
    public InterfaceC0637i f3668L;

    /* renamed from: M */
    public Animation.AnimationListener f3669M;

    /* renamed from: N */
    public final Animation f3670N;

    /* renamed from: O */
    public final Animation f3671O;

    /* renamed from: a */
    public View f3672a;

    /* renamed from: b */
    public InterfaceC0638j f3673b;

    /* renamed from: c */
    public boolean f3674c;

    /* renamed from: d */
    public int f3675d;

    /* renamed from: e */
    public float f3676e;

    /* renamed from: f */
    public float f3677f;

    /* renamed from: g */
    public final NestedScrollingParentHelper f3678g;

    /* renamed from: h */
    public final NestedScrollingChildHelper f3679h;

    /* renamed from: i */
    public final int[] f3680i;

    /* renamed from: j */
    public final int[] f3681j;

    /* renamed from: k */
    public boolean f3682k;

    /* renamed from: m */
    public int f3683m;

    /* renamed from: n */
    public int f3684n;

    /* renamed from: o */
    public float f3685o;

    /* renamed from: p */
    public float f3686p;

    /* renamed from: q */
    public boolean f3687q;

    /* renamed from: r */
    public int f3688r;

    /* renamed from: s */
    public boolean f3689s;

    /* renamed from: t */
    public boolean f3690t;

    /* renamed from: u */
    public final DecelerateInterpolator f3691u;

    /* renamed from: v */
    public CircleImageView f3692v;

    /* renamed from: w */
    public int f3693w;

    /* renamed from: x */
    public int f3694x;

    /* renamed from: y */
    public float f3695y;

    /* renamed from: z */
    public int f3696z;

    /* renamed from: android.support.v4.widget.SwipeRefreshLayout$a  reason: invalid class name */
    /* loaded from: classes.dex */
    public class animationAnimation$AnimationListenerC0629a implements Animation.AnimationListener {
        public animationAnimation$AnimationListenerC0629a() {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            InterfaceC0638j interfaceC0638j;
            SwipeRefreshLayout swipeRefreshLayout = SwipeRefreshLayout.this;
            if (swipeRefreshLayout.f3674c) {
                swipeRefreshLayout.f3659C.setAlpha(255);
                SwipeRefreshLayout.this.f3659C.start();
                SwipeRefreshLayout swipeRefreshLayout2 = SwipeRefreshLayout.this;
                if (swipeRefreshLayout2.f3665I && (interfaceC0638j = swipeRefreshLayout2.f3673b) != null) {
                    interfaceC0638j.mo989e();
                }
                SwipeRefreshLayout swipeRefreshLayout3 = SwipeRefreshLayout.this;
                swipeRefreshLayout3.f3684n = swipeRefreshLayout3.f3692v.getTop();
                return;
            }
            swipeRefreshLayout.m7313e();
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
        }
    }

    /* renamed from: android.support.v4.widget.SwipeRefreshLayout$b */
    /* loaded from: classes.dex */
    public class C0630b extends Animation {
        public C0630b() {
        }

        @Override // android.view.animation.Animation
        public void applyTransformation(float f, Transformation transformation) {
            SwipeRefreshLayout.this.setAnimationProgress(f);
        }
    }

    /* renamed from: android.support.v4.widget.SwipeRefreshLayout$c */
    /* loaded from: classes.dex */
    public class C0631c extends Animation {
        public C0631c() {
        }

        @Override // android.view.animation.Animation
        public void applyTransformation(float f, Transformation transformation) {
            SwipeRefreshLayout.this.setAnimationProgress(1.0f - f);
        }
    }

    /* renamed from: android.support.v4.widget.SwipeRefreshLayout$d */
    /* loaded from: classes.dex */
    public class C0632d extends Animation {

        /* renamed from: a */
        public final /* synthetic */ int f3700a;

        /* renamed from: b */
        public final /* synthetic */ int f3701b;

        public C0632d(int i, int i2) {
            this.f3700a = i;
            this.f3701b = i2;
        }

        @Override // android.view.animation.Animation
        public void applyTransformation(float f, Transformation transformation) {
            CircularProgressDrawable circularProgressDrawable = SwipeRefreshLayout.this.f3659C;
            int i = this.f3700a;
            circularProgressDrawable.setAlpha((int) (i + ((this.f3701b - i) * f)));
        }
    }

    /* renamed from: android.support.v4.widget.SwipeRefreshLayout$e  reason: invalid class name */
    /* loaded from: classes.dex */
    public class animationAnimation$AnimationListenerC0633e implements Animation.AnimationListener {
        public animationAnimation$AnimationListenerC0633e() {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            SwipeRefreshLayout swipeRefreshLayout = SwipeRefreshLayout.this;
            if (swipeRefreshLayout.f3689s) {
                return;
            }
            swipeRefreshLayout.m7325a((Animation.AnimationListener) null);
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
        }
    }

    /* renamed from: android.support.v4.widget.SwipeRefreshLayout$f */
    /* loaded from: classes.dex */
    public class C0634f extends Animation {
        public C0634f() {
        }

        @Override // android.view.animation.Animation
        public void applyTransformation(float f, Transformation transformation) {
            int i;
            SwipeRefreshLayout swipeRefreshLayout = SwipeRefreshLayout.this;
            if (!swipeRefreshLayout.f3667K) {
                i = swipeRefreshLayout.f3657A - Math.abs(swipeRefreshLayout.f3696z);
            } else {
                i = swipeRefreshLayout.f3657A;
            }
            SwipeRefreshLayout swipeRefreshLayout2 = SwipeRefreshLayout.this;
            int i2 = swipeRefreshLayout2.f3694x;
            SwipeRefreshLayout.this.setTargetOffsetTopAndBottom((i2 + ((int) ((i - i2) * f))) - swipeRefreshLayout2.f3692v.getTop());
            SwipeRefreshLayout.this.f3659C.m9290a(1.0f - f);
        }
    }

    /* renamed from: android.support.v4.widget.SwipeRefreshLayout$g */
    /* loaded from: classes.dex */
    public class C0635g extends Animation {
        public C0635g() {
        }

        @Override // android.view.animation.Animation
        public void applyTransformation(float f, Transformation transformation) {
            SwipeRefreshLayout.this.m7317c(f);
        }
    }

    /* renamed from: android.support.v4.widget.SwipeRefreshLayout$h */
    /* loaded from: classes.dex */
    public class C0636h extends Animation {
        public C0636h() {
        }

        @Override // android.view.animation.Animation
        public void applyTransformation(float f, Transformation transformation) {
            SwipeRefreshLayout swipeRefreshLayout = SwipeRefreshLayout.this;
            float f2 = swipeRefreshLayout.f3695y;
            swipeRefreshLayout.setAnimationProgress(f2 + ((-f2) * f));
            SwipeRefreshLayout.this.m7317c(f);
        }
    }

    /* renamed from: android.support.v4.widget.SwipeRefreshLayout$i */
    /* loaded from: classes.dex */
    public interface InterfaceC0637i {
        /* renamed from: a */
        boolean m7310a(SwipeRefreshLayout swipeRefreshLayout, View view);
    }

    /* renamed from: android.support.v4.widget.SwipeRefreshLayout$j */
    /* loaded from: classes.dex */
    public interface InterfaceC0638j {
        /* renamed from: e */
        void mo989e();
    }

    public SwipeRefreshLayout(Context context) {
        this(context, null);
    }

    private void setColorViewAlpha(int i) {
        this.f3692v.getBackground().setAlpha(i);
        this.f3659C.setAlpha(i);
    }

    /* renamed from: a */
    public final void m7323a(boolean z, boolean z2) {
        if (this.f3674c != z) {
            this.f3665I = z2;
            m7318c();
            this.f3674c = z;
            if (this.f3674c) {
                m7327a(this.f3684n, this.f3669M);
            } else {
                m7325a(this.f3669M);
            }
        }
    }

    /* renamed from: b */
    public final void m7322b() {
        this.f3692v = new CircleImageView(getContext(), -328966);
        this.f3659C = new CircularProgressDrawable(getContext());
        this.f3659C.m9284a(1);
        this.f3692v.setImageDrawable(this.f3659C);
        this.f3692v.setVisibility(8);
        addView(this.f3692v);
    }

    /* renamed from: c */
    public final void m7318c() {
        if (this.f3672a == null) {
            for (int i = 0; i < getChildCount(); i++) {
                View childAt = getChildAt(i);
                if (!childAt.equals(this.f3692v)) {
                    this.f3672a = childAt;
                    return;
                }
            }
        }
    }

    /* renamed from: d */
    public boolean m7315d() {
        return this.f3674c;
    }

    @Override // android.view.View
    public boolean dispatchNestedFling(float f, float f2, boolean z) {
        return this.f3679h.m9496a(f, f2, z);
    }

    @Override // android.view.View
    public boolean dispatchNestedPreFling(float f, float f2) {
        return this.f3679h.m9497a(f, f2);
    }

    @Override // android.view.View
    public boolean dispatchNestedPreScroll(int i, int i2, int[] iArr, int[] iArr2) {
        return this.f3679h.m9491a(i, i2, iArr, iArr2);
    }

    @Override // android.view.View
    public boolean dispatchNestedScroll(int i, int i2, int i3, int i4, int[] iArr) {
        return this.f3679h.m9493a(i, i2, i3, i4, iArr);
    }

    /* renamed from: e */
    public void m7313e() {
        this.f3692v.clearAnimation();
        this.f3659C.stop();
        this.f3692v.setVisibility(8);
        setColorViewAlpha(255);
        if (this.f3689s) {
            setAnimationProgress(0.0f);
        } else {
            setTargetOffsetTopAndBottom(this.f3696z - this.f3684n);
        }
        this.f3684n = this.f3692v.getTop();
    }

    /* renamed from: f */
    public final void m7312f() {
        this.f3663G = m7328a(this.f3659C.getAlpha(), 255);
    }

    /* renamed from: g */
    public final void m7311g() {
        this.f3662F = m7328a(this.f3659C.getAlpha(), 76);
    }

    @Override // android.view.ViewGroup
    public int getChildDrawingOrder(int i, int i2) {
        int i3 = this.f3693w;
        return i3 < 0 ? i2 : i2 == i + (-1) ? i3 : i2 >= i3 ? i2 + 1 : i2;
    }

    @Override // android.view.ViewGroup
    public int getNestedScrollAxes() {
        return this.f3678g.m9482a();
    }

    public int getProgressCircleDiameter() {
        return this.f3666J;
    }

    public int getProgressViewEndOffset() {
        return this.f3657A;
    }

    public int getProgressViewStartOffset() {
        return this.f3696z;
    }

    @Override // android.view.View
    public boolean hasNestedScrollingParent() {
        return this.f3679h.m9498a();
    }

    @Override // android.view.View, p000a.p006b.p030g.p045k.NestedScrollingChild
    public boolean isNestedScrollingEnabled() {
        return this.f3679h.m9487b();
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        m7313e();
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        m7318c();
        int actionMasked = motionEvent.getActionMasked();
        if (this.f3690t && actionMasked == 0) {
            this.f3690t = false;
        }
        if (!isEnabled() || this.f3690t || m7330a() || this.f3674c || this.f3682k) {
            return false;
        }
        if (actionMasked != 0) {
            if (actionMasked != 1) {
                if (actionMasked == 2) {
                    int i = this.f3688r;
                    if (i == -1) {
                        Log.e(f3655P, "Got ACTION_MOVE event but don't have an active pointer id.");
                        return false;
                    }
                    int findPointerIndex = motionEvent.findPointerIndex(i);
                    if (findPointerIndex < 0) {
                        return false;
                    }
                    m7314d(motionEvent.getY(findPointerIndex));
                } else if (actionMasked != 3) {
                    if (actionMasked == 6) {
                        m7326a(motionEvent);
                    }
                }
            }
            this.f3687q = false;
            this.f3688r = -1;
        } else {
            setTargetOffsetTopAndBottom(this.f3696z - this.f3692v.getTop());
            this.f3688r = motionEvent.getPointerId(0);
            this.f3687q = false;
            int findPointerIndex2 = motionEvent.findPointerIndex(this.f3688r);
            if (findPointerIndex2 < 0) {
                return false;
            }
            this.f3686p = motionEvent.getY(findPointerIndex2);
        }
        return this.f3687q;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int measuredWidth = getMeasuredWidth();
        int measuredHeight = getMeasuredHeight();
        if (getChildCount() == 0) {
            return;
        }
        if (this.f3672a == null) {
            m7318c();
        }
        View view = this.f3672a;
        if (view == null) {
            return;
        }
        int paddingLeft = getPaddingLeft();
        int paddingTop = getPaddingTop();
        view.layout(paddingLeft, paddingTop, ((measuredWidth - getPaddingLeft()) - getPaddingRight()) + paddingLeft, ((measuredHeight - getPaddingTop()) - getPaddingBottom()) + paddingTop);
        int measuredWidth2 = this.f3692v.getMeasuredWidth();
        int measuredHeight2 = this.f3692v.getMeasuredHeight();
        int i5 = measuredWidth / 2;
        int i6 = measuredWidth2 / 2;
        int i7 = this.f3684n;
        this.f3692v.layout(i5 - i6, i7, i5 + i6, measuredHeight2 + i7);
    }

    @Override // android.view.View
    public void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        if (this.f3672a == null) {
            m7318c();
        }
        View view = this.f3672a;
        if (view == null) {
            return;
        }
        view.measure(View.MeasureSpec.makeMeasureSpec((getMeasuredWidth() - getPaddingLeft()) - getPaddingRight(), 1073741824), View.MeasureSpec.makeMeasureSpec((getMeasuredHeight() - getPaddingTop()) - getPaddingBottom(), 1073741824));
        this.f3692v.measure(View.MeasureSpec.makeMeasureSpec(this.f3666J, 1073741824), View.MeasureSpec.makeMeasureSpec(this.f3666J, 1073741824));
        this.f3693w = -1;
        for (int i3 = 0; i3 < getChildCount(); i3++) {
            if (getChildAt(i3) == this.f3692v) {
                this.f3693w = i3;
                return;
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, p000a.p006b.p030g.p045k.NestedScrollingParent
    public boolean onNestedFling(View view, float f, float f2, boolean z) {
        return dispatchNestedFling(f, f2, z);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, p000a.p006b.p030g.p045k.NestedScrollingParent
    public boolean onNestedPreFling(View view, float f, float f2) {
        return dispatchNestedPreFling(f, f2);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, p000a.p006b.p030g.p045k.NestedScrollingParent
    public void onNestedPreScroll(View view, int i, int i2, int[] iArr) {
        if (i2 > 0) {
            float f = this.f3677f;
            if (f > 0.0f) {
                float f2 = i2;
                if (f2 > f) {
                    iArr[1] = i2 - ((int) f);
                    this.f3677f = 0.0f;
                } else {
                    this.f3677f = f - f2;
                    iArr[1] = i2;
                }
                m7321b(this.f3677f);
            }
        }
        if (this.f3667K && i2 > 0 && this.f3677f == 0.0f && Math.abs(i2 - iArr[1]) > 0) {
            this.f3692v.setVisibility(8);
        }
        int[] iArr2 = this.f3680i;
        if (dispatchNestedPreScroll(i - iArr[0], i2 - iArr[1], iArr2, null)) {
            iArr[0] = iArr[0] + iArr2[0];
            iArr[1] = iArr[1] + iArr2[1];
        }
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, p000a.p006b.p030g.p045k.NestedScrollingParent
    public void onNestedScroll(View view, int i, int i2, int i3, int i4) {
        int i5;
        dispatchNestedScroll(i, i2, i3, i4, this.f3681j);
        if (i4 + this.f3681j[1] >= 0 || m7330a()) {
            return;
        }
        this.f3677f += Math.abs(i5);
        m7321b(this.f3677f);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, p000a.p006b.p030g.p045k.NestedScrollingParent
    public void onNestedScrollAccepted(View view, View view2, int i) {
        this.f3678g.m9479a(view, view2, i);
        startNestedScroll(i & 2);
        this.f3677f = 0.0f;
        this.f3682k = true;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, p000a.p006b.p030g.p045k.NestedScrollingParent
    public boolean onStartNestedScroll(View view, View view2, int i) {
        return (!isEnabled() || this.f3690t || this.f3674c || (i & 2) == 0) ? false : true;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, p000a.p006b.p030g.p045k.NestedScrollingParent
    public void onStopNestedScroll(View view) {
        this.f3678g.m9481a(view);
        this.f3682k = false;
        float f = this.f3677f;
        if (f > 0.0f) {
            m7329a(f);
            this.f3677f = 0.0f;
        }
        stopNestedScroll();
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        int actionMasked = motionEvent.getActionMasked();
        if (this.f3690t && actionMasked == 0) {
            this.f3690t = false;
        }
        if (!isEnabled() || this.f3690t || m7330a() || this.f3674c || this.f3682k) {
            return false;
        }
        if (actionMasked == 0) {
            this.f3688r = motionEvent.getPointerId(0);
            this.f3687q = false;
        } else if (actionMasked == 1) {
            int findPointerIndex = motionEvent.findPointerIndex(this.f3688r);
            if (findPointerIndex < 0) {
                Log.e(f3655P, "Got ACTION_UP event but don't have an active pointer id.");
                return false;
            }
            if (this.f3687q) {
                this.f3687q = false;
                m7329a((motionEvent.getY(findPointerIndex) - this.f3685o) * 0.5f);
            }
            this.f3688r = -1;
            return false;
        } else if (actionMasked == 2) {
            int findPointerIndex2 = motionEvent.findPointerIndex(this.f3688r);
            if (findPointerIndex2 < 0) {
                Log.e(f3655P, "Got ACTION_MOVE event but have an invalid active pointer id.");
                return false;
            }
            float y = motionEvent.getY(findPointerIndex2);
            m7314d(y);
            if (this.f3687q) {
                float f = (y - this.f3685o) * 0.5f;
                if (f <= 0.0f) {
                    return false;
                }
                m7321b(f);
            }
        } else if (actionMasked == 3) {
            return false;
        } else {
            if (actionMasked == 5) {
                int actionIndex = motionEvent.getActionIndex();
                if (actionIndex < 0) {
                    Log.e(f3655P, "Got ACTION_POINTER_DOWN event but have an invalid action index.");
                    return false;
                }
                this.f3688r = motionEvent.getPointerId(actionIndex);
            } else if (actionMasked == 6) {
                m7326a(motionEvent);
            }
        }
        return true;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void requestDisallowInterceptTouchEvent(boolean z) {
        if (Build.VERSION.SDK_INT >= 21 || !(this.f3672a instanceof AbsListView)) {
            View view = this.f3672a;
            if (view == null || ViewCompat.m9408y(view)) {
                super.requestDisallowInterceptTouchEvent(z);
            }
        }
    }

    public void setAnimationProgress(float f) {
        this.f3692v.setScaleX(f);
        this.f3692v.setScaleY(f);
    }

    @Deprecated
    public void setColorScheme(int... iArr) {
        setColorSchemeResources(iArr);
    }

    public void setColorSchemeColors(int... iArr) {
        m7318c();
        this.f3659C.m9282a(iArr);
    }

    public void setColorSchemeResources(int... iArr) {
        Context context = getContext();
        int[] iArr2 = new int[iArr.length];
        for (int i = 0; i < iArr.length; i++) {
            iArr2[i] = ContextCompat.m10022a(context, iArr[i]);
        }
        setColorSchemeColors(iArr2);
    }

    public void setDistanceToTriggerSync(int i) {
        this.f3676e = i;
    }

    @Override // android.view.View
    public void setEnabled(boolean z) {
        super.setEnabled(z);
        if (z) {
            return;
        }
        m7313e();
    }

    @Override // android.view.View
    public void setNestedScrollingEnabled(boolean z) {
        this.f3679h.m9488a(z);
    }

    public void setOnChildScrollUpCallback(InterfaceC0637i interfaceC0637i) {
        this.f3668L = interfaceC0637i;
    }

    public void setOnRefreshListener(InterfaceC0638j interfaceC0638j) {
        this.f3673b = interfaceC0638j;
    }

    @Deprecated
    public void setProgressBackgroundColor(int i) {
        setProgressBackgroundColorSchemeResource(i);
    }

    public void setProgressBackgroundColorSchemeColor(int i) {
        this.f3692v.setBackgroundColor(i);
    }

    public void setProgressBackgroundColorSchemeResource(int i) {
        setProgressBackgroundColorSchemeColor(ContextCompat.m10022a(getContext(), i));
    }

    public void setRefreshing(boolean z) {
        int i;
        if (z && this.f3674c != z) {
            this.f3674c = z;
            if (!this.f3667K) {
                i = this.f3657A + this.f3696z;
            } else {
                i = this.f3657A;
            }
            setTargetOffsetTopAndBottom(i - this.f3684n);
            this.f3665I = false;
            m7319b(this.f3669M);
            return;
        }
        m7323a(z, false);
    }

    public void setSize(int i) {
        if (i == 0 || i == 1) {
            DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
            if (i == 0) {
                this.f3666J = (int) (displayMetrics.density * 56.0f);
            } else {
                this.f3666J = (int) (displayMetrics.density * 40.0f);
            }
            this.f3692v.setImageDrawable(null);
            this.f3659C.m9284a(i);
            this.f3692v.setImageDrawable(this.f3659C);
        }
    }

    public void setSlingshotDistance(int i) {
        this.f3658B = i;
    }

    public void setTargetOffsetTopAndBottom(int i) {
        this.f3692v.bringToFront();
        ViewCompat.m9433d(this.f3692v, i);
        this.f3684n = this.f3692v.getTop();
    }

    @Override // android.view.View
    public boolean startNestedScroll(int i) {
        return this.f3679h.m9484c(i);
    }

    @Override // android.view.View, p000a.p006b.p030g.p045k.NestedScrollingChild
    public void stopNestedScroll() {
        this.f3679h.m9485c();
    }

    public SwipeRefreshLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f3674c = false;
        this.f3676e = -1.0f;
        this.f3680i = new int[2];
        this.f3681j = new int[2];
        this.f3688r = -1;
        this.f3693w = -1;
        this.f3669M = new animationAnimation$AnimationListenerC0629a();
        this.f3670N = new C0634f();
        this.f3671O = new C0635g();
        this.f3675d = ViewConfiguration.get(context).getScaledTouchSlop();
        this.f3683m = getResources().getInteger(17694721);
        setWillNotDraw(false);
        this.f3691u = new DecelerateInterpolator(2.0f);
        DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
        this.f3666J = (int) (displayMetrics.density * 40.0f);
        m7322b();
        setChildrenDrawingOrderEnabled(true);
        this.f3657A = (int) (displayMetrics.density * 64.0f);
        this.f3676e = this.f3657A;
        this.f3678g = new NestedScrollingParentHelper(this);
        this.f3679h = new NestedScrollingChildHelper(this);
        setNestedScrollingEnabled(true);
        int i = -this.f3666J;
        this.f3684n = i;
        this.f3696z = i;
        m7317c(1.0f);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, f3656Q);
        setEnabled(obtainStyledAttributes.getBoolean(0, true));
        obtainStyledAttributes.recycle();
    }

    /* renamed from: d */
    public final void m7314d(float f) {
        float f2 = this.f3686p;
        int i = this.f3675d;
        if (f - f2 <= i || this.f3687q) {
            return;
        }
        this.f3685o = f2 + i;
        this.f3687q = true;
        this.f3659C.setAlpha(76);
    }

    /* renamed from: c */
    public void m7317c(float f) {
        int i = this.f3694x;
        setTargetOffsetTopAndBottom((i + ((int) ((this.f3696z - i) * f))) - this.f3692v.getTop());
    }

    /* renamed from: b */
    public final void m7319b(Animation.AnimationListener animationListener) {
        this.f3692v.setVisibility(0);
        this.f3659C.setAlpha(255);
        this.f3660D = new C0630b();
        this.f3660D.setDuration(this.f3683m);
        if (animationListener != null) {
            this.f3692v.m9293a(animationListener);
        }
        this.f3692v.clearAnimation();
        this.f3692v.startAnimation(this.f3660D);
    }

    /* renamed from: a */
    public void m7325a(Animation.AnimationListener animationListener) {
        this.f3661E = new C0631c();
        this.f3661E.setDuration(150L);
        this.f3692v.m9293a(animationListener);
        this.f3692v.clearAnimation();
        this.f3692v.startAnimation(this.f3661E);
    }

    /* renamed from: c */
    public final void m7316c(int i, Animation.AnimationListener animationListener) {
        this.f3694x = i;
        this.f3695y = this.f3692v.getScaleX();
        this.f3664H = new C0636h();
        this.f3664H.setDuration(150L);
        if (animationListener != null) {
            this.f3692v.m9293a(animationListener);
        }
        this.f3692v.clearAnimation();
        this.f3692v.startAnimation(this.f3664H);
    }

    /* renamed from: a */
    public final Animation m7328a(int i, int i2) {
        C0632d c0632d = new C0632d(i, i2);
        c0632d.setDuration(300L);
        this.f3692v.m9293a(null);
        this.f3692v.clearAnimation();
        this.f3692v.startAnimation(c0632d);
        return c0632d;
    }

    /* renamed from: b */
    public final void m7321b(float f) {
        this.f3659C.m9283a(true);
        float min = Math.min(1.0f, Math.abs(f / this.f3676e));
        float max = (((float) Math.max(min - 0.4d, 0.0d)) * 5.0f) / 3.0f;
        float abs = Math.abs(f) - this.f3676e;
        int i = this.f3658B;
        if (i <= 0) {
            i = this.f3667K ? this.f3657A - this.f3696z : this.f3657A;
        }
        float f2 = i;
        double max2 = Math.max(0.0f, Math.min(abs, f2 * 2.0f) / f2) / 4.0f;
        float pow = ((float) (max2 - Math.pow(max2, 2.0d))) * 2.0f;
        int i2 = this.f3696z + ((int) ((f2 * min) + (f2 * pow * 2.0f)));
        if (this.f3692v.getVisibility() != 0) {
            this.f3692v.setVisibility(0);
        }
        if (!this.f3689s) {
            this.f3692v.setScaleX(1.0f);
            this.f3692v.setScaleY(1.0f);
        }
        if (this.f3689s) {
            setAnimationProgress(Math.min(1.0f, f / this.f3676e));
        }
        if (f < this.f3676e) {
            if (this.f3659C.getAlpha() > 76 && !m7324a(this.f3662F)) {
                m7311g();
            }
        } else if (this.f3659C.getAlpha() < 255 && !m7324a(this.f3663G)) {
            m7312f();
        }
        this.f3659C.m9289a(0.0f, Math.min(0.8f, max * 0.8f));
        this.f3659C.m9290a(Math.min(1.0f, max));
        this.f3659C.m9281b((((max * 0.4f) - 0.25f) + (pow * 2.0f)) * 0.5f);
        setTargetOffsetTopAndBottom(i2 - this.f3684n);
    }

    /* renamed from: a */
    public boolean m7330a() {
        InterfaceC0637i interfaceC0637i = this.f3668L;
        if (interfaceC0637i != null) {
            return interfaceC0637i.m7310a(this, this.f3672a);
        }
        View view = this.f3672a;
        if (view instanceof ListView) {
            return ListViewCompat.m9224a((ListView) view, -1);
        }
        return view.canScrollVertically(-1);
    }

    /* renamed from: a */
    public final boolean m7324a(Animation animation) {
        return (animation == null || !animation.hasStarted() || animation.hasEnded()) ? false : true;
    }

    /* renamed from: a */
    public final void m7329a(float f) {
        if (f > this.f3676e) {
            m7323a(true, true);
            return;
        }
        this.f3674c = false;
        this.f3659C.m9289a(0.0f, 0.0f);
        m7320b(this.f3684n, this.f3689s ? null : new animationAnimation$AnimationListenerC0633e());
        this.f3659C.m9283a(false);
    }

    /* renamed from: a */
    public final void m7327a(int i, Animation.AnimationListener animationListener) {
        this.f3694x = i;
        this.f3670N.reset();
        this.f3670N.setDuration(200L);
        this.f3670N.setInterpolator(this.f3691u);
        if (animationListener != null) {
            this.f3692v.m9293a(animationListener);
        }
        this.f3692v.clearAnimation();
        this.f3692v.startAnimation(this.f3670N);
    }

    /* renamed from: a */
    public final void m7326a(MotionEvent motionEvent) {
        int actionIndex = motionEvent.getActionIndex();
        if (motionEvent.getPointerId(actionIndex) == this.f3688r) {
            this.f3688r = motionEvent.getPointerId(actionIndex == 0 ? 1 : 0);
        }
    }

    /* renamed from: b */
    public final void m7320b(int i, Animation.AnimationListener animationListener) {
        if (this.f3689s) {
            m7316c(i, animationListener);
            return;
        }
        this.f3694x = i;
        this.f3671O.reset();
        this.f3671O.setDuration(200L);
        this.f3671O.setInterpolator(this.f3691u);
        if (animationListener != null) {
            this.f3692v.m9293a(animationListener);
        }
        this.f3692v.clearAnimation();
        this.f3692v.startAnimation(this.f3671O);
    }
}
