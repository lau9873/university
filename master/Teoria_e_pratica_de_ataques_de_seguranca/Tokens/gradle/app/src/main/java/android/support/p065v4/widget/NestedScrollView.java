package android.support.p065v4.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.Log;
import android.util.TypedValue;
import android.view.FocusFinder;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;
import android.view.animation.AnimationUtils;
import android.widget.EdgeEffect;
import android.widget.FrameLayout;
import android.widget.OverScroller;
import android.widget.ScrollView;
import java.util.ArrayList;
import p000a.p006b.p030g.p045k.AccessibilityDelegateCompat;
import p000a.p006b.p030g.p045k.NestedScrollingChild2;
import p000a.p006b.p030g.p045k.NestedScrollingChildHelper;
import p000a.p006b.p030g.p045k.NestedScrollingParent2;
import p000a.p006b.p030g.p045k.NestedScrollingParentHelper;
import p000a.p006b.p030g.p045k.ScrollingView;
import p000a.p006b.p030g.p045k.ViewCompat;
import p000a.p006b.p030g.p045k.p046e0.AccessibilityNodeInfoCompat;
import p000a.p006b.p030g.p045k.p046e0.AccessibilityRecordCompat;
import p000a.p006b.p030g.p048l.EdgeEffectCompat;

/* renamed from: android.support.v4.widget.NestedScrollView */
/* loaded from: classes.dex */
public class NestedScrollView extends FrameLayout implements NestedScrollingParent2, NestedScrollingChild2, ScrollingView {

    /* renamed from: B */
    public static final C0625a f3626B = new C0625a();

    /* renamed from: C */
    public static final int[] f3627C = {16843130};

    /* renamed from: A */
    public InterfaceC0626b f3628A;

    /* renamed from: a */
    public long f3629a;

    /* renamed from: b */
    public final Rect f3630b;

    /* renamed from: c */
    public OverScroller f3631c;

    /* renamed from: d */
    public EdgeEffect f3632d;

    /* renamed from: e */
    public EdgeEffect f3633e;

    /* renamed from: f */
    public int f3634f;

    /* renamed from: g */
    public boolean f3635g;

    /* renamed from: h */
    public boolean f3636h;

    /* renamed from: i */
    public View f3637i;

    /* renamed from: j */
    public boolean f3638j;

    /* renamed from: k */
    public VelocityTracker f3639k;

    /* renamed from: m */
    public boolean f3640m;

    /* renamed from: n */
    public boolean f3641n;

    /* renamed from: o */
    public int f3642o;

    /* renamed from: p */
    public int f3643p;

    /* renamed from: q */
    public int f3644q;

    /* renamed from: r */
    public int f3645r;

    /* renamed from: s */
    public final int[] f3646s;

    /* renamed from: t */
    public final int[] f3647t;

    /* renamed from: u */
    public int f3648u;

    /* renamed from: v */
    public int f3649v;

    /* renamed from: w */
    public C0627c f3650w;

    /* renamed from: x */
    public final NestedScrollingParentHelper f3651x;

    /* renamed from: y */
    public final NestedScrollingChildHelper f3652y;

    /* renamed from: z */
    public float f3653z;

    /* renamed from: android.support.v4.widget.NestedScrollView$b */
    /* loaded from: classes.dex */
    public interface InterfaceC0626b {
        /* renamed from: a */
        void mo7283a(NestedScrollView nestedScrollView, int i, int i2, int i3, int i4);
    }

    /* renamed from: android.support.v4.widget.NestedScrollView$c */
    /* loaded from: classes.dex */
    public static class C0627c extends View.BaseSavedState {
        public static final Parcelable.Creator<C0627c> CREATOR = new C0628a();

        /* renamed from: a */
        public int f3654a;

        /* renamed from: android.support.v4.widget.NestedScrollView$c$a */
        /* loaded from: classes.dex */
        public static class C0628a implements Parcelable.Creator<C0627c> {
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public C0627c createFromParcel(Parcel parcel) {
                return new C0627c(parcel);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public C0627c[] newArray(int i) {
                return new C0627c[i];
            }
        }

        public C0627c(Parcelable parcelable) {
            super(parcelable);
        }

        public String toString() {
            return "HorizontalScrollView.SavedState{" + Integer.toHexString(System.identityHashCode(this)) + " scrollPosition=" + this.f3654a + "}";
        }

        @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeInt(this.f3654a);
        }

        public C0627c(Parcel parcel) {
            super(parcel);
            this.f3654a = parcel.readInt();
        }
    }

    public NestedScrollView(Context context) {
        this(context, null);
    }

    /* renamed from: b */
    public static int m7349b(int i, int i2, int i3) {
        if (i2 >= i3 || i < 0) {
            return 0;
        }
        return i2 + i > i3 ? i3 - i2 : i;
    }

    private float getVerticalScrollFactorCompat() {
        if (this.f3653z == 0.0f) {
            TypedValue typedValue = new TypedValue();
            Context context = getContext();
            if (context.getTheme().resolveAttribute(16842829, typedValue, true)) {
                this.f3653z = typedValue.getDimension(context.getResources().getDisplayMetrics());
            } else {
                throw new IllegalStateException("Expected theme to define listPreferredItemHeight.");
            }
        }
        return this.f3653z;
    }

    @Override // p000a.p006b.p030g.p045k.NestedScrollingChild2
    /* renamed from: a */
    public void mo6951a(int i) {
        this.f3652y.m9483d(i);
    }

    @Override // android.view.ViewGroup
    public void addView(View view) {
        if (getChildCount() <= 0) {
            super.addView(view);
            return;
        }
        throw new IllegalStateException("ScrollView can host only one direct child");
    }

    /* renamed from: b */
    public boolean m7351b(int i) {
        View findFocus = findFocus();
        if (findFocus == this) {
            findFocus = null;
        }
        View findNextFocus = FocusFinder.getInstance().findNextFocus(this, findFocus, i);
        int maxScrollAmount = getMaxScrollAmount();
        if (findNextFocus != null && m7358a(findNextFocus, maxScrollAmount, getHeight())) {
            findNextFocus.getDrawingRect(this.f3630b);
            offsetDescendantRectToMyCoords(findNextFocus, this.f3630b);
            m7345c(m7364a(this.f3630b));
            findNextFocus.requestFocus(i);
        } else {
            if (i == 33 && getScrollY() < maxScrollAmount) {
                maxScrollAmount = getScrollY();
            } else if (i == 130 && getChildCount() > 0) {
                View childAt = getChildAt(0);
                maxScrollAmount = Math.min((childAt.getBottom() + ((FrameLayout.LayoutParams) childAt.getLayoutParams()).bottomMargin) - ((getScrollY() + getHeight()) - getPaddingBottom()), maxScrollAmount);
            }
            if (maxScrollAmount == 0) {
                return false;
            }
            if (i != 130) {
                maxScrollAmount = -maxScrollAmount;
            }
            m7345c(maxScrollAmount);
        }
        if (findFocus != null && findFocus.isFocused() && m7360a(findFocus)) {
            int descendantFocusability = getDescendantFocusability();
            setDescendantFocusability(131072);
            requestFocus();
            setDescendantFocusability(descendantFocusability);
            return true;
        }
        return true;
    }

    @Override // p000a.p006b.p030g.p045k.NestedScrollingParent2
    /* renamed from: b */
    public boolean mo7347b(View view, View view2, int i, int i2) {
        return (i & 2) != 0;
    }

    /* renamed from: c */
    public final void m7345c(int i) {
        if (i != 0) {
            if (this.f3641n) {
                m7350b(0, i);
            } else {
                scrollBy(0, i);
            }
        }
    }

    @Override // android.view.View
    public int computeHorizontalScrollExtent() {
        return super.computeHorizontalScrollExtent();
    }

    @Override // android.view.View
    public int computeHorizontalScrollOffset() {
        return super.computeHorizontalScrollOffset();
    }

    @Override // android.view.View
    public int computeHorizontalScrollRange() {
        return super.computeHorizontalScrollRange();
    }

    @Override // android.view.View
    public void computeScroll() {
        if (this.f3631c.computeScrollOffset()) {
            this.f3631c.getCurrX();
            int currY = this.f3631c.getCurrY();
            int i = currY - this.f3649v;
            if (m7365a(0, i, this.f3647t, (int[]) null, 1)) {
                i -= this.f3647t[1];
            }
            int i2 = i;
            if (i2 != 0) {
                int scrollRange = getScrollRange();
                int scrollY = getScrollY();
                m7367a(0, i2, getScrollX(), scrollY, 0, scrollRange, 0, 0, false);
                int scrollY2 = getScrollY() - scrollY;
                if (!m7366a(0, scrollY2, 0, i2 - scrollY2, (int[]) null, 1)) {
                    int overScrollMode = getOverScrollMode();
                    if (overScrollMode == 0 || (overScrollMode == 1 && scrollRange > 0)) {
                        m7346c();
                        if (currY <= 0 && scrollY > 0) {
                            this.f3632d.onAbsorb((int) this.f3631c.getCurrVelocity());
                        } else if (currY >= scrollRange && scrollY < scrollRange) {
                            this.f3633e.onAbsorb((int) this.f3631c.getCurrVelocity());
                        }
                    }
                }
            }
            this.f3649v = currY;
            ViewCompat.m9464A(this);
            return;
        }
        if (m7335g(1)) {
            mo6951a(1);
        }
        this.f3649v = 0;
    }

    @Override // android.view.View
    public int computeVerticalScrollExtent() {
        return super.computeVerticalScrollExtent();
    }

    @Override // android.view.View
    public int computeVerticalScrollOffset() {
        return Math.max(0, super.computeVerticalScrollOffset());
    }

    @Override // android.view.View
    public int computeVerticalScrollRange() {
        int childCount = getChildCount();
        int height = (getHeight() - getPaddingBottom()) - getPaddingTop();
        if (childCount == 0) {
            return height;
        }
        View childAt = getChildAt(0);
        int bottom = childAt.getBottom() + ((FrameLayout.LayoutParams) childAt.getLayoutParams()).bottomMargin;
        int scrollY = getScrollY();
        int max = Math.max(0, bottom - height);
        return scrollY < 0 ? bottom - scrollY : scrollY > max ? bottom + (scrollY - max) : bottom;
    }

    /* renamed from: d */
    public boolean m7341d(int i, int i2) {
        return this.f3652y.m9494a(i, i2);
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        return super.dispatchKeyEvent(keyEvent) || m7362a(keyEvent);
    }

    @Override // android.view.View
    public boolean dispatchNestedFling(float f, float f2, boolean z) {
        return this.f3652y.m9496a(f, f2, z);
    }

    @Override // android.view.View
    public boolean dispatchNestedPreFling(float f, float f2) {
        return this.f3652y.m9497a(f, f2);
    }

    @Override // android.view.View
    public boolean dispatchNestedPreScroll(int i, int i2, int[] iArr, int[] iArr2) {
        return m7365a(i, i2, iArr, iArr2, 0);
    }

    @Override // android.view.View
    public boolean dispatchNestedScroll(int i, int i2, int i3, int i4, int[] iArr) {
        return m7366a(i, i2, i3, i4, iArr, 0);
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        int paddingLeft;
        super.draw(canvas);
        if (this.f3632d != null) {
            int scrollY = getScrollY();
            int i = 0;
            if (!this.f3632d.isFinished()) {
                int save = canvas.save();
                int width = getWidth();
                int height = getHeight();
                int min = Math.min(0, scrollY);
                if (Build.VERSION.SDK_INT < 21 || getClipToPadding()) {
                    width -= getPaddingLeft() + getPaddingRight();
                    paddingLeft = getPaddingLeft() + 0;
                } else {
                    paddingLeft = 0;
                }
                if (Build.VERSION.SDK_INT >= 21 && getClipToPadding()) {
                    height -= getPaddingTop() + getPaddingBottom();
                    min += getPaddingTop();
                }
                canvas.translate(paddingLeft, min);
                this.f3632d.setSize(width, height);
                if (this.f3632d.draw(canvas)) {
                    ViewCompat.m9464A(this);
                }
                canvas.restoreToCount(save);
            }
            if (this.f3633e.isFinished()) {
                return;
            }
            int save2 = canvas.save();
            int width2 = getWidth();
            int height2 = getHeight();
            int max = Math.max(getScrollRange(), scrollY) + height2;
            if (Build.VERSION.SDK_INT < 21 || getClipToPadding()) {
                width2 -= getPaddingLeft() + getPaddingRight();
                i = 0 + getPaddingLeft();
            }
            if (Build.VERSION.SDK_INT >= 21 && getClipToPadding()) {
                height2 -= getPaddingTop() + getPaddingBottom();
                max -= getPaddingBottom();
            }
            canvas.translate(i - width2, max);
            canvas.rotate(180.0f, width2, 0.0f);
            this.f3633e.setSize(width2, height2);
            if (this.f3633e.draw(canvas)) {
                ViewCompat.m9464A(this);
            }
            canvas.restoreToCount(save2);
        }
    }

    /* renamed from: e */
    public final void m7340e() {
        this.f3631c = new OverScroller(getContext());
        setFocusable(true);
        setDescendantFocusability(262144);
        setWillNotDraw(false);
        ViewConfiguration viewConfiguration = ViewConfiguration.get(getContext());
        this.f3642o = viewConfiguration.getScaledTouchSlop();
        this.f3643p = viewConfiguration.getScaledMinimumFlingVelocity();
        this.f3644q = viewConfiguration.getScaledMaximumFlingVelocity();
    }

    /* renamed from: f */
    public final void m7338f() {
        if (this.f3639k == null) {
            this.f3639k = VelocityTracker.obtain();
        }
    }

    /* renamed from: g */
    public boolean m7335g(int i) {
        return this.f3652y.m9486b(i);
    }

    @Override // android.view.View
    public float getBottomFadingEdgeStrength() {
        if (getChildCount() == 0) {
            return 0.0f;
        }
        View childAt = getChildAt(0);
        int verticalFadingEdgeLength = getVerticalFadingEdgeLength();
        int bottom = ((childAt.getBottom() + ((FrameLayout.LayoutParams) childAt.getLayoutParams()).bottomMargin) - getScrollY()) - (getHeight() - getPaddingBottom());
        if (bottom < verticalFadingEdgeLength) {
            return bottom / verticalFadingEdgeLength;
        }
        return 1.0f;
    }

    public int getMaxScrollAmount() {
        return (int) (getHeight() * 0.5f);
    }

    @Override // android.view.ViewGroup
    public int getNestedScrollAxes() {
        return this.f3651x.m9482a();
    }

    public int getScrollRange() {
        if (getChildCount() > 0) {
            View childAt = getChildAt(0);
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) childAt.getLayoutParams();
            return Math.max(0, ((childAt.getHeight() + layoutParams.topMargin) + layoutParams.bottomMargin) - ((getHeight() - getPaddingTop()) - getPaddingBottom()));
        }
        return 0;
    }

    @Override // android.view.View
    public float getTopFadingEdgeStrength() {
        if (getChildCount() == 0) {
            return 0.0f;
        }
        int verticalFadingEdgeLength = getVerticalFadingEdgeLength();
        int scrollY = getScrollY();
        if (scrollY < verticalFadingEdgeLength) {
            return scrollY / verticalFadingEdgeLength;
        }
        return 1.0f;
    }

    /* renamed from: h */
    public boolean m7334h(int i) {
        boolean z = i == 130;
        int height = getHeight();
        if (z) {
            this.f3630b.top = getScrollY() + height;
            int childCount = getChildCount();
            if (childCount > 0) {
                View childAt = getChildAt(childCount - 1);
                int bottom = childAt.getBottom() + ((FrameLayout.LayoutParams) childAt.getLayoutParams()).bottomMargin + getPaddingBottom();
                Rect rect = this.f3630b;
                if (rect.top + height > bottom) {
                    rect.top = bottom - height;
                }
            }
        } else {
            this.f3630b.top = getScrollY() - height;
            Rect rect2 = this.f3630b;
            if (rect2.top < 0) {
                rect2.top = 0;
            }
        }
        Rect rect3 = this.f3630b;
        int i2 = rect3.top;
        rect3.bottom = height + i2;
        return m7368a(i, i2, rect3.bottom);
    }

    @Override // android.view.View
    public boolean hasNestedScrollingParent() {
        return m7335g(0);
    }

    @Override // android.view.View, p000a.p006b.p030g.p045k.NestedScrollingChild
    public boolean isNestedScrollingEnabled() {
        return this.f3652y.m9487b();
    }

    @Override // android.view.ViewGroup
    public void measureChild(View view, int i, int i2) {
        view.measure(FrameLayout.getChildMeasureSpec(i, getPaddingLeft() + getPaddingRight(), view.getLayoutParams().width), View.MeasureSpec.makeMeasureSpec(0, 0));
    }

    @Override // android.view.ViewGroup
    public void measureChildWithMargins(View view, int i, int i2, int i3, int i4) {
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
        view.measure(FrameLayout.getChildMeasureSpec(i, getPaddingLeft() + getPaddingRight() + marginLayoutParams.leftMargin + marginLayoutParams.rightMargin + i2, marginLayoutParams.width), View.MeasureSpec.makeMeasureSpec(marginLayoutParams.topMargin + marginLayoutParams.bottomMargin, 0));
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.f3636h = false;
    }

    @Override // android.view.View
    public boolean onGenericMotionEvent(MotionEvent motionEvent) {
        if ((motionEvent.getSource() & 2) != 0 && motionEvent.getAction() == 8 && !this.f3638j) {
            float axisValue = motionEvent.getAxisValue(9);
            if (axisValue != 0.0f) {
                int scrollRange = getScrollRange();
                int scrollY = getScrollY();
                int verticalScrollFactorCompat = scrollY - ((int) (axisValue * getVerticalScrollFactorCompat()));
                if (verticalScrollFactorCompat < 0) {
                    verticalScrollFactorCompat = 0;
                } else if (verticalScrollFactorCompat > scrollRange) {
                    verticalScrollFactorCompat = scrollRange;
                }
                if (verticalScrollFactorCompat != scrollY) {
                    super.scrollTo(getScrollX(), verticalScrollFactorCompat);
                    return true;
                }
            }
        }
        return false;
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (action == 2 && this.f3638j) {
            return true;
        }
        int i = action & 255;
        if (i != 0) {
            if (i != 1) {
                if (i == 2) {
                    int i2 = this.f3645r;
                    if (i2 != -1) {
                        int findPointerIndex = motionEvent.findPointerIndex(i2);
                        if (findPointerIndex == -1) {
                            Log.e("NestedScrollView", "Invalid pointerId=" + i2 + " in onInterceptTouchEvent");
                        } else {
                            int y = (int) motionEvent.getY(findPointerIndex);
                            if (Math.abs(y - this.f3634f) > this.f3642o && (2 & getNestedScrollAxes()) == 0) {
                                this.f3638j = true;
                                this.f3634f = y;
                                m7338f();
                                this.f3639k.addMovement(motionEvent);
                                this.f3648u = 0;
                                ViewParent parent = getParent();
                                if (parent != null) {
                                    parent.requestDisallowInterceptTouchEvent(true);
                                }
                            }
                        }
                    }
                } else if (i != 3) {
                    if (i == 6) {
                        m7361a(motionEvent);
                    }
                }
            }
            this.f3638j = false;
            this.f3645r = -1;
            m7336g();
            if (this.f3631c.springBack(getScrollX(), getScrollY(), 0, 0, 0, getScrollRange())) {
                ViewCompat.m9464A(this);
            }
            mo6951a(0);
        } else {
            int y2 = (int) motionEvent.getY();
            if (!m7369a((int) motionEvent.getX(), y2)) {
                this.f3638j = false;
                m7336g();
            } else {
                this.f3634f = y2;
                this.f3645r = motionEvent.getPointerId(0);
                m7343d();
                this.f3639k.addMovement(motionEvent);
                this.f3631c.computeScrollOffset();
                this.f3638j = !this.f3631c.isFinished();
                m7341d(2, 0);
            }
        }
        return this.f3638j;
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        int i5 = 0;
        this.f3635g = false;
        View view = this.f3637i;
        if (view != null && m7355a(view, this)) {
            m7348b(this.f3637i);
        }
        this.f3637i = null;
        if (!this.f3636h) {
            if (this.f3650w != null) {
                scrollTo(getScrollX(), this.f3650w.f3654a);
                this.f3650w = null;
            }
            if (getChildCount() > 0) {
                View childAt = getChildAt(0);
                FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) childAt.getLayoutParams();
                i5 = childAt.getMeasuredHeight() + layoutParams.topMargin + layoutParams.bottomMargin;
            }
            int paddingTop = ((i4 - i2) - getPaddingTop()) - getPaddingBottom();
            int scrollY = getScrollY();
            int m7349b = m7349b(scrollY, paddingTop, i5);
            if (m7349b != scrollY) {
                scrollTo(getScrollX(), m7349b);
            }
        }
        scrollTo(getScrollX(), getScrollY());
        this.f3636h = true;
    }

    @Override // android.widget.FrameLayout, android.view.View
    public void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        if (this.f3640m && View.MeasureSpec.getMode(i2) != 0 && getChildCount() > 0) {
            View childAt = getChildAt(0);
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) childAt.getLayoutParams();
            int measuredHeight = childAt.getMeasuredHeight();
            int measuredHeight2 = (((getMeasuredHeight() - getPaddingTop()) - getPaddingBottom()) - layoutParams.topMargin) - layoutParams.bottomMargin;
            if (measuredHeight < measuredHeight2) {
                childAt.measure(FrameLayout.getChildMeasureSpec(i, getPaddingLeft() + getPaddingRight() + layoutParams.leftMargin + layoutParams.rightMargin, layoutParams.width), View.MeasureSpec.makeMeasureSpec(measuredHeight2, 1073741824));
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, p000a.p006b.p030g.p045k.NestedScrollingParent
    public boolean onNestedFling(View view, float f, float f2, boolean z) {
        if (z) {
            return false;
        }
        m7339e((int) f2);
        return true;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, p000a.p006b.p030g.p045k.NestedScrollingParent
    public boolean onNestedPreFling(View view, float f, float f2) {
        return dispatchNestedPreFling(f, f2);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, p000a.p006b.p030g.p045k.NestedScrollingParent
    public void onNestedPreScroll(View view, int i, int i2, int[] iArr) {
        mo7356a(view, i, i2, iArr, 0);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, p000a.p006b.p030g.p045k.NestedScrollingParent
    public void onNestedScroll(View view, int i, int i2, int i3, int i4) {
        mo7357a(view, i, i2, i3, i4, 0);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, p000a.p006b.p030g.p045k.NestedScrollingParent
    public void onNestedScrollAccepted(View view, View view2, int i) {
        mo7354a(view, view2, i, 0);
    }

    @Override // android.view.View
    public void onOverScrolled(int i, int i2, boolean z, boolean z2) {
        super.scrollTo(i, i2);
    }

    @Override // android.view.ViewGroup
    public boolean onRequestFocusInDescendants(int i, Rect rect) {
        View findNextFocusFromRect;
        if (i == 2) {
            i = 130;
        } else if (i == 1) {
            i = 33;
        }
        if (rect == null) {
            findNextFocusFromRect = FocusFinder.getInstance().findNextFocus(this, null, i);
        } else {
            findNextFocusFromRect = FocusFinder.getInstance().findNextFocusFromRect(this, rect, i);
        }
        if (findNextFocusFromRect == null || m7360a(findNextFocusFromRect)) {
            return false;
        }
        return findNextFocusFromRect.requestFocus(i, rect);
    }

    @Override // android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof C0627c)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        C0627c c0627c = (C0627c) parcelable;
        super.onRestoreInstanceState(c0627c.getSuperState());
        this.f3650w = c0627c;
        requestLayout();
    }

    @Override // android.view.View
    public Parcelable onSaveInstanceState() {
        C0627c c0627c = new C0627c(super.onSaveInstanceState());
        c0627c.f3654a = getScrollY();
        return c0627c;
    }

    @Override // android.view.View
    public void onScrollChanged(int i, int i2, int i3, int i4) {
        super.onScrollChanged(i, i2, i3, i4);
        InterfaceC0626b interfaceC0626b = this.f3628A;
        if (interfaceC0626b != null) {
            interfaceC0626b.mo7283a(this, i, i2, i3, i4);
        }
    }

    @Override // android.view.View
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        View findFocus = findFocus();
        if (findFocus == null || this == findFocus || !m7358a(findFocus, 0, i4)) {
            return;
        }
        findFocus.getDrawingRect(this.f3630b);
        offsetDescendantRectToMyCoords(findFocus, this.f3630b);
        m7345c(m7364a(this.f3630b));
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, p000a.p006b.p030g.p045k.NestedScrollingParent
    public boolean onStartNestedScroll(View view, View view2, int i) {
        return mo7347b(view, view2, i, 0);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, p000a.p006b.p030g.p045k.NestedScrollingParent
    public void onStopNestedScroll(View view) {
        mo7359a(view, 0);
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        ViewParent parent;
        int[] iArr;
        m7338f();
        MotionEvent obtain = MotionEvent.obtain(motionEvent);
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 0) {
            this.f3648u = 0;
        }
        obtain.offsetLocation(0.0f, this.f3648u);
        if (actionMasked != 0) {
            if (actionMasked == 1) {
                VelocityTracker velocityTracker = this.f3639k;
                velocityTracker.computeCurrentVelocity(1000, this.f3644q);
                int yVelocity = (int) velocityTracker.getYVelocity(this.f3645r);
                if (Math.abs(yVelocity) > this.f3643p) {
                    m7339e(-yVelocity);
                } else if (this.f3631c.springBack(getScrollX(), getScrollY(), 0, 0, 0, getScrollRange())) {
                    ViewCompat.m9464A(this);
                }
                this.f3645r = -1;
                m7352b();
            } else if (actionMasked == 2) {
                int findPointerIndex = motionEvent.findPointerIndex(this.f3645r);
                if (findPointerIndex == -1) {
                    Log.e("NestedScrollView", "Invalid pointerId=" + this.f3645r + " in onTouchEvent");
                } else {
                    int y = (int) motionEvent.getY(findPointerIndex);
                    int i = this.f3634f - y;
                    if (m7365a(0, i, this.f3647t, this.f3646s, 0)) {
                        i -= this.f3647t[1];
                        obtain.offsetLocation(0.0f, this.f3646s[1]);
                        this.f3648u += this.f3646s[1];
                    }
                    if (!this.f3638j && Math.abs(i) > this.f3642o) {
                        ViewParent parent2 = getParent();
                        if (parent2 != null) {
                            parent2.requestDisallowInterceptTouchEvent(true);
                        }
                        this.f3638j = true;
                        if (i > 0) {
                            i -= this.f3642o;
                        } else {
                            i += this.f3642o;
                        }
                    }
                    int i2 = i;
                    if (this.f3638j) {
                        this.f3634f = y - this.f3646s[1];
                        int scrollY = getScrollY();
                        int scrollRange = getScrollRange();
                        int overScrollMode = getOverScrollMode();
                        boolean z = overScrollMode == 0 || (overScrollMode == 1 && scrollRange > 0);
                        if (m7367a(0, i2, 0, getScrollY(), 0, scrollRange, 0, 0, true) && !m7335g(0)) {
                            this.f3639k.clear();
                        }
                        int scrollY2 = getScrollY() - scrollY;
                        if (m7366a(0, scrollY2, 0, i2 - scrollY2, this.f3646s, 0)) {
                            this.f3634f = this.f3634f - this.f3646s[1];
                            obtain.offsetLocation(0.0f, iArr[1]);
                            this.f3648u += this.f3646s[1];
                        } else if (z) {
                            m7346c();
                            int i3 = scrollY + i2;
                            if (i3 < 0) {
                                EdgeEffectCompat.m9232a(this.f3632d, i2 / getHeight(), motionEvent.getX(findPointerIndex) / getWidth());
                                if (!this.f3633e.isFinished()) {
                                    this.f3633e.onRelease();
                                }
                            } else if (i3 > scrollRange) {
                                EdgeEffectCompat.m9232a(this.f3633e, i2 / getHeight(), 1.0f - (motionEvent.getX(findPointerIndex) / getWidth()));
                                if (!this.f3632d.isFinished()) {
                                    this.f3632d.onRelease();
                                }
                            }
                            EdgeEffect edgeEffect = this.f3632d;
                            if (edgeEffect != null && (!edgeEffect.isFinished() || !this.f3633e.isFinished())) {
                                ViewCompat.m9464A(this);
                            }
                        }
                    }
                }
            } else if (actionMasked == 3) {
                if (this.f3638j && getChildCount() > 0 && this.f3631c.springBack(getScrollX(), getScrollY(), 0, 0, 0, getScrollRange())) {
                    ViewCompat.m9464A(this);
                }
                this.f3645r = -1;
                m7352b();
            } else if (actionMasked == 5) {
                int actionIndex = motionEvent.getActionIndex();
                this.f3634f = (int) motionEvent.getY(actionIndex);
                this.f3645r = motionEvent.getPointerId(actionIndex);
            } else if (actionMasked == 6) {
                m7361a(motionEvent);
                this.f3634f = (int) motionEvent.getY(motionEvent.findPointerIndex(this.f3645r));
            }
        } else if (getChildCount() == 0) {
            return false;
        } else {
            boolean z2 = !this.f3631c.isFinished();
            this.f3638j = z2;
            if (z2 && (parent = getParent()) != null) {
                parent.requestDisallowInterceptTouchEvent(true);
            }
            if (!this.f3631c.isFinished()) {
                this.f3631c.abortAnimation();
            }
            this.f3634f = (int) motionEvent.getY();
            this.f3645r = motionEvent.getPointerId(0);
            m7341d(2, 0);
        }
        VelocityTracker velocityTracker2 = this.f3639k;
        if (velocityTracker2 != null) {
            velocityTracker2.addMovement(obtain);
        }
        obtain.recycle();
        return true;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void requestChildFocus(View view, View view2) {
        if (!this.f3635g) {
            m7348b(view2);
        } else {
            this.f3637i = view2;
        }
        super.requestChildFocus(view, view2);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public boolean requestChildRectangleOnScreen(View view, Rect rect, boolean z) {
        rect.offset(view.getLeft() - view.getScrollX(), view.getTop() - view.getScrollY());
        return m7363a(rect, z);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void requestDisallowInterceptTouchEvent(boolean z) {
        if (z) {
            m7336g();
        }
        super.requestDisallowInterceptTouchEvent(z);
    }

    @Override // android.view.View, android.view.ViewParent
    public void requestLayout() {
        this.f3635g = true;
        super.requestLayout();
    }

    @Override // android.view.View
    public void scrollTo(int i, int i2) {
        if (getChildCount() > 0) {
            View childAt = getChildAt(0);
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) childAt.getLayoutParams();
            int m7349b = m7349b(i, (getWidth() - getPaddingLeft()) - getPaddingRight(), childAt.getWidth() + layoutParams.leftMargin + layoutParams.rightMargin);
            int m7349b2 = m7349b(i2, (getHeight() - getPaddingTop()) - getPaddingBottom(), childAt.getHeight() + layoutParams.topMargin + layoutParams.bottomMargin);
            if (m7349b == getScrollX() && m7349b2 == getScrollY()) {
                return;
            }
            super.scrollTo(m7349b, m7349b2);
        }
    }

    public void setFillViewport(boolean z) {
        if (z != this.f3640m) {
            this.f3640m = z;
            requestLayout();
        }
    }

    @Override // android.view.View
    public void setNestedScrollingEnabled(boolean z) {
        this.f3652y.m9488a(z);
    }

    public void setOnScrollChangeListener(InterfaceC0626b interfaceC0626b) {
        this.f3628A = interfaceC0626b;
    }

    public void setSmoothScrollingEnabled(boolean z) {
        this.f3641n = z;
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup
    public boolean shouldDelayChildPressedState() {
        return true;
    }

    @Override // android.view.View
    public boolean startNestedScroll(int i) {
        return m7341d(i, 0);
    }

    @Override // android.view.View, p000a.p006b.p030g.p045k.NestedScrollingChild
    public void stopNestedScroll() {
        mo6951a(0);
    }

    public NestedScrollView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    /* renamed from: a */
    public boolean m7366a(int i, int i2, int i3, int i4, int[] iArr, int i5) {
        return this.f3652y.m9492a(i, i2, i3, i4, iArr, i5);
    }

    /* renamed from: d */
    public final void m7343d() {
        VelocityTracker velocityTracker = this.f3639k;
        if (velocityTracker == null) {
            this.f3639k = VelocityTracker.obtain();
        } else {
            velocityTracker.clear();
        }
    }

    /* renamed from: g */
    public final void m7336g() {
        VelocityTracker velocityTracker = this.f3639k;
        if (velocityTracker != null) {
            velocityTracker.recycle();
            this.f3639k = null;
        }
    }

    public NestedScrollView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f3630b = new Rect();
        this.f3635g = true;
        this.f3636h = false;
        this.f3637i = null;
        this.f3638j = false;
        this.f3641n = true;
        this.f3645r = -1;
        this.f3646s = new int[2];
        this.f3647t = new int[2];
        m7340e();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, f3627C, i, 0);
        setFillViewport(obtainStyledAttributes.getBoolean(0, false));
        obtainStyledAttributes.recycle();
        this.f3651x = new NestedScrollingParentHelper(this);
        this.f3652y = new NestedScrollingChildHelper(this);
        setNestedScrollingEnabled(true);
        ViewCompat.m9454a(this, f3626B);
    }

    /* renamed from: a */
    public boolean m7365a(int i, int i2, int[] iArr, int[] iArr2, int i3) {
        return this.f3652y.m9490a(i, i2, iArr, iArr2, i3);
    }

    /* renamed from: f */
    public boolean m7337f(int i) {
        int childCount;
        boolean z = i == 130;
        int height = getHeight();
        Rect rect = this.f3630b;
        rect.top = 0;
        rect.bottom = height;
        if (z && (childCount = getChildCount()) > 0) {
            View childAt = getChildAt(childCount - 1);
            this.f3630b.bottom = childAt.getBottom() + ((FrameLayout.LayoutParams) childAt.getLayoutParams()).bottomMargin + getPaddingBottom();
            Rect rect2 = this.f3630b;
            rect2.top = rect2.bottom - height;
        }
        Rect rect3 = this.f3630b;
        return m7368a(i, rect3.top, rect3.bottom);
    }

    @Override // p000a.p006b.p030g.p045k.NestedScrollingParent2
    /* renamed from: a */
    public void mo7354a(View view, View view2, int i, int i2) {
        this.f3651x.m9478a(view, view2, i, i2);
        m7341d(2, i2);
    }

    @Override // android.view.ViewGroup
    public void addView(View view, int i) {
        if (getChildCount() <= 0) {
            super.addView(view, i);
            return;
        }
        throw new IllegalStateException("ScrollView can host only one direct child");
    }

    /* renamed from: c */
    public final void m7344c(int i, int i2) {
        m7350b(i - getScrollX(), i2 - getScrollY());
    }

    /* renamed from: c */
    public final void m7346c() {
        if (getOverScrollMode() != 2) {
            if (this.f3632d == null) {
                Context context = getContext();
                this.f3632d = new EdgeEffect(context);
                this.f3633e = new EdgeEffect(context);
                return;
            }
            return;
        }
        this.f3632d = null;
        this.f3633e = null;
    }

    /* renamed from: d */
    public void m7342d(int i) {
        if (getChildCount() > 0) {
            m7341d(2, 1);
            this.f3631c.fling(getScrollX(), getScrollY(), 0, i, 0, 0, Integer.MIN_VALUE, Integer.MAX_VALUE, 0, 0);
            this.f3649v = getScrollY();
            ViewCompat.m9464A(this);
        }
    }

    @Override // p000a.p006b.p030g.p045k.NestedScrollingParent2
    /* renamed from: a */
    public void mo7359a(View view, int i) {
        this.f3651x.m9480a(view, i);
        mo6951a(i);
    }

    @Override // android.view.ViewGroup, android.view.ViewManager
    public void addView(View view, ViewGroup.LayoutParams layoutParams) {
        if (getChildCount() <= 0) {
            super.addView(view, layoutParams);
            return;
        }
        throw new IllegalStateException("ScrollView can host only one direct child");
    }

    @Override // p000a.p006b.p030g.p045k.NestedScrollingParent2
    /* renamed from: a */
    public void mo7357a(View view, int i, int i2, int i3, int i4, int i5) {
        int scrollY = getScrollY();
        scrollBy(0, i4);
        int scrollY2 = getScrollY() - scrollY;
        m7366a(0, scrollY2, 0, i4 - scrollY2, (int[]) null, i5);
    }

    /* renamed from: e */
    public final void m7339e(int i) {
        int scrollY = getScrollY();
        boolean z = (scrollY > 0 || i > 0) && (scrollY < getScrollRange() || i < 0);
        float f = i;
        if (dispatchNestedPreFling(0.0f, f)) {
            return;
        }
        dispatchNestedFling(0.0f, f, z);
        m7342d(i);
    }

    @Override // android.view.ViewGroup
    public void addView(View view, int i, ViewGroup.LayoutParams layoutParams) {
        if (getChildCount() <= 0) {
            super.addView(view, i, layoutParams);
            return;
        }
        throw new IllegalStateException("ScrollView can host only one direct child");
    }

    @Override // p000a.p006b.p030g.p045k.NestedScrollingParent2
    /* renamed from: a */
    public void mo7356a(View view, int i, int i2, int[] iArr, int i3) {
        m7365a(i, i2, iArr, (int[]) null, i3);
    }

    /* renamed from: a */
    public final boolean m7370a() {
        if (getChildCount() > 0) {
            View childAt = getChildAt(0);
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) childAt.getLayoutParams();
            return (childAt.getHeight() + layoutParams.topMargin) + layoutParams.bottomMargin > (getHeight() - getPaddingTop()) - getPaddingBottom();
        }
        return false;
    }

    /* renamed from: android.support.v4.widget.NestedScrollView$a */
    /* loaded from: classes.dex */
    public static class C0625a extends AccessibilityDelegateCompat {
        @Override // p000a.p006b.p030g.p045k.AccessibilityDelegateCompat
        /* renamed from: a */
        public boolean mo7333a(View view, int i, Bundle bundle) {
            if (super.mo7333a(view, i, bundle)) {
                return true;
            }
            NestedScrollView nestedScrollView = (NestedScrollView) view;
            if (nestedScrollView.isEnabled()) {
                if (i == 4096) {
                    int min = Math.min(nestedScrollView.getScrollY() + ((nestedScrollView.getHeight() - nestedScrollView.getPaddingBottom()) - nestedScrollView.getPaddingTop()), nestedScrollView.getScrollRange());
                    if (min != nestedScrollView.getScrollY()) {
                        nestedScrollView.m7344c(0, min);
                        return true;
                    }
                    return false;
                } else if (i != 8192) {
                    return false;
                } else {
                    int max = Math.max(nestedScrollView.getScrollY() - ((nestedScrollView.getHeight() - nestedScrollView.getPaddingBottom()) - nestedScrollView.getPaddingTop()), 0);
                    if (max != nestedScrollView.getScrollY()) {
                        nestedScrollView.m7344c(0, max);
                        return true;
                    }
                    return false;
                }
            }
            return false;
        }

        @Override // p000a.p006b.p030g.p045k.AccessibilityDelegateCompat
        /* renamed from: b */
        public void mo7331b(View view, AccessibilityEvent accessibilityEvent) {
            super.mo7331b(view, accessibilityEvent);
            NestedScrollView nestedScrollView = (NestedScrollView) view;
            accessibilityEvent.setClassName(ScrollView.class.getName());
            accessibilityEvent.setScrollable(nestedScrollView.getScrollRange() > 0);
            accessibilityEvent.setScrollX(nestedScrollView.getScrollX());
            accessibilityEvent.setScrollY(nestedScrollView.getScrollY());
            AccessibilityRecordCompat.m9514a(accessibilityEvent, nestedScrollView.getScrollX());
            AccessibilityRecordCompat.m9513b(accessibilityEvent, nestedScrollView.getScrollRange());
        }

        @Override // p000a.p006b.p030g.p045k.AccessibilityDelegateCompat
        /* renamed from: a */
        public void mo7332a(View view, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
            int scrollRange;
            super.mo7332a(view, accessibilityNodeInfoCompat);
            NestedScrollView nestedScrollView = (NestedScrollView) view;
            accessibilityNodeInfoCompat.m9554a((CharSequence) ScrollView.class.getName());
            if (!nestedScrollView.isEnabled() || (scrollRange = nestedScrollView.getScrollRange()) <= 0) {
                return;
            }
            accessibilityNodeInfoCompat.m9538e(true);
            if (nestedScrollView.getScrollY() > 0) {
                accessibilityNodeInfoCompat.m9558a(8192);
            }
            if (nestedScrollView.getScrollY() < scrollRange) {
                accessibilityNodeInfoCompat.m9558a(4096);
            }
        }
    }

    /* renamed from: a */
    public boolean m7362a(KeyEvent keyEvent) {
        this.f3630b.setEmpty();
        if (!m7370a()) {
            if (!isFocused() || keyEvent.getKeyCode() == 4) {
                return false;
            }
            View findFocus = findFocus();
            if (findFocus == this) {
                findFocus = null;
            }
            View findNextFocus = FocusFinder.getInstance().findNextFocus(this, findFocus, 130);
            return (findNextFocus == null || findNextFocus == this || !findNextFocus.requestFocus(130)) ? false : true;
        } else if (keyEvent.getAction() == 0) {
            int keyCode = keyEvent.getKeyCode();
            if (keyCode == 19) {
                if (!keyEvent.isAltPressed()) {
                    return m7351b(33);
                }
                return m7337f(33);
            } else if (keyCode == 20) {
                if (!keyEvent.isAltPressed()) {
                    return m7351b(130);
                }
                return m7337f(130);
            } else if (keyCode != 62) {
                return false;
            } else {
                m7334h(keyEvent.isShiftPressed() ? 33 : 130);
                return false;
            }
        } else {
            return false;
        }
    }

    /* renamed from: b */
    public final void m7350b(int i, int i2) {
        if (getChildCount() == 0) {
            return;
        }
        if (AnimationUtils.currentAnimationTimeMillis() - this.f3629a > 250) {
            View childAt = getChildAt(0);
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) childAt.getLayoutParams();
            int height = childAt.getHeight() + layoutParams.topMargin + layoutParams.bottomMargin;
            int height2 = (getHeight() - getPaddingTop()) - getPaddingBottom();
            int scrollY = getScrollY();
            this.f3649v = getScrollY();
            OverScroller overScroller = this.f3631c;
            int scrollX = getScrollX();
            overScroller.startScroll(scrollX, scrollY, 0, Math.max(0, Math.min(i2 + scrollY, Math.max(0, height - height2))) - scrollY);
            ViewCompat.m9464A(this);
        } else {
            if (!this.f3631c.isFinished()) {
                this.f3631c.abortAnimation();
            }
            scrollBy(i, i2);
        }
        this.f3629a = AnimationUtils.currentAnimationTimeMillis();
    }

    /* renamed from: a */
    public final boolean m7369a(int i, int i2) {
        if (getChildCount() > 0) {
            int scrollY = getScrollY();
            View childAt = getChildAt(0);
            return i2 >= childAt.getTop() - scrollY && i2 < childAt.getBottom() - scrollY && i >= childAt.getLeft() && i < childAt.getRight();
        }
        return false;
    }

    /* renamed from: a */
    public final void m7361a(MotionEvent motionEvent) {
        int actionIndex = motionEvent.getActionIndex();
        if (motionEvent.getPointerId(actionIndex) == this.f3645r) {
            int i = actionIndex == 0 ? 1 : 0;
            this.f3634f = (int) motionEvent.getY(i);
            this.f3645r = motionEvent.getPointerId(i);
            VelocityTracker velocityTracker = this.f3639k;
            if (velocityTracker != null) {
                velocityTracker.clear();
            }
        }
    }

    /* renamed from: b */
    public final void m7348b(View view) {
        view.getDrawingRect(this.f3630b);
        offsetDescendantRectToMyCoords(view, this.f3630b);
        int m7364a = m7364a(this.f3630b);
        if (m7364a != 0) {
            scrollBy(0, m7364a);
        }
    }

    /* renamed from: b */
    public final void m7352b() {
        this.f3638j = false;
        m7336g();
        mo6951a(0);
        EdgeEffect edgeEffect = this.f3632d;
        if (edgeEffect != null) {
            edgeEffect.onRelease();
            this.f3633e.onRelease();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:38:0x0057  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x005a  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x0061  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x0083 A[ADDED_TO_REGION] */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean m7367a(int r13, int r14, int r15, int r16, int r17, int r18, int r19, int r20, boolean r21) {
        /*
            r12 = this;
            r0 = r12
            int r1 = r12.getOverScrollMode()
            int r2 = r12.computeHorizontalScrollRange()
            int r3 = r12.computeHorizontalScrollExtent()
            r4 = 0
            r5 = 1
            if (r2 <= r3) goto L13
            r2 = 1
            goto L14
        L13:
            r2 = 0
        L14:
            int r3 = r12.computeVerticalScrollRange()
            int r6 = r12.computeVerticalScrollExtent()
            if (r3 <= r6) goto L20
            r3 = 1
            goto L21
        L20:
            r3 = 0
        L21:
            if (r1 == 0) goto L2a
            if (r1 != r5) goto L28
            if (r2 == 0) goto L28
            goto L2a
        L28:
            r2 = 0
            goto L2b
        L2a:
            r2 = 1
        L2b:
            if (r1 == 0) goto L34
            if (r1 != r5) goto L32
            if (r3 == 0) goto L32
            goto L34
        L32:
            r1 = 0
            goto L35
        L34:
            r1 = 1
        L35:
            int r3 = r15 + r13
            if (r2 != 0) goto L3b
            r2 = 0
            goto L3d
        L3b:
            r2 = r19
        L3d:
            int r6 = r16 + r14
            if (r1 != 0) goto L43
            r1 = 0
            goto L45
        L43:
            r1 = r20
        L45:
            int r7 = -r2
            int r2 = r2 + r17
            int r8 = -r1
            int r1 = r1 + r18
            if (r3 <= r2) goto L50
            r7 = r2
        L4e:
            r2 = 1
            goto L55
        L50:
            if (r3 >= r7) goto L53
            goto L4e
        L53:
            r7 = r3
            r2 = 0
        L55:
            if (r6 <= r1) goto L5a
            r6 = r1
        L58:
            r1 = 1
            goto L5f
        L5a:
            if (r6 >= r8) goto L5e
            r6 = r8
            goto L58
        L5e:
            r1 = 0
        L5f:
            if (r1 == 0) goto L7e
            boolean r3 = r12.m7335g(r5)
            if (r3 != 0) goto L7e
            android.widget.OverScroller r3 = r0.f3631c
            r8 = 0
            r9 = 0
            r10 = 0
            int r11 = r12.getScrollRange()
            r13 = r3
            r14 = r7
            r15 = r6
            r16 = r8
            r17 = r9
            r18 = r10
            r19 = r11
            r13.springBack(r14, r15, r16, r17, r18, r19)
        L7e:
            r12.onOverScrolled(r7, r6, r2, r1)
            if (r2 != 0) goto L85
            if (r1 == 0) goto L86
        L85:
            r4 = 1
        L86:
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.p065v4.widget.NestedScrollView.m7367a(int, int, int, int, int, int, int, int, boolean):boolean");
    }

    /* renamed from: a */
    public final View m7353a(boolean z, int i, int i2) {
        ArrayList focusables = getFocusables(2);
        int size = focusables.size();
        View view = null;
        boolean z2 = false;
        for (int i3 = 0; i3 < size; i3++) {
            View view2 = (View) focusables.get(i3);
            int top = view2.getTop();
            int bottom = view2.getBottom();
            if (i < bottom && top < i2) {
                boolean z3 = i < top && bottom < i2;
                if (view == null) {
                    view = view2;
                    z2 = z3;
                } else {
                    boolean z4 = (z && top < view.getTop()) || (!z && bottom > view.getBottom());
                    if (z2) {
                        if (z3) {
                            if (!z4) {
                            }
                            view = view2;
                        }
                    } else if (z3) {
                        view = view2;
                        z2 = true;
                    } else {
                        if (!z4) {
                        }
                        view = view2;
                    }
                }
            }
        }
        return view;
    }

    /* renamed from: a */
    public final boolean m7368a(int i, int i2, int i3) {
        int height = getHeight();
        int scrollY = getScrollY();
        int i4 = height + scrollY;
        boolean z = false;
        boolean z2 = i == 33;
        View m7353a = m7353a(z2, i2, i3);
        if (m7353a == null) {
            m7353a = this;
        }
        if (i2 < scrollY || i3 > i4) {
            m7345c(z2 ? i2 - scrollY : i3 - i4);
            z = true;
        }
        if (m7353a != findFocus()) {
            m7353a.requestFocus(i);
        }
        return z;
    }

    /* renamed from: a */
    public final boolean m7360a(View view) {
        return !m7358a(view, 0, getHeight());
    }

    /* renamed from: a */
    public final boolean m7358a(View view, int i, int i2) {
        view.getDrawingRect(this.f3630b);
        offsetDescendantRectToMyCoords(view, this.f3630b);
        return this.f3630b.bottom + i >= getScrollY() && this.f3630b.top - i <= getScrollY() + i2;
    }

    /* renamed from: a */
    public final boolean m7363a(Rect rect, boolean z) {
        int m7364a = m7364a(rect);
        boolean z2 = m7364a != 0;
        if (z2) {
            if (z) {
                scrollBy(0, m7364a);
            } else {
                m7350b(0, m7364a);
            }
        }
        return z2;
    }

    /* renamed from: a */
    public int m7364a(Rect rect) {
        int i;
        int i2;
        if (getChildCount() == 0) {
            return 0;
        }
        int height = getHeight();
        int scrollY = getScrollY();
        int i3 = scrollY + height;
        int verticalFadingEdgeLength = getVerticalFadingEdgeLength();
        if (rect.top > 0) {
            scrollY += verticalFadingEdgeLength;
        }
        View childAt = getChildAt(0);
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) childAt.getLayoutParams();
        int i4 = rect.bottom < (childAt.getHeight() + layoutParams.topMargin) + layoutParams.bottomMargin ? i3 - verticalFadingEdgeLength : i3;
        if (rect.bottom > i4 && rect.top > scrollY) {
            if (rect.height() > height) {
                i2 = rect.top - scrollY;
            } else {
                i2 = rect.bottom - i4;
            }
            return Math.min(i2 + 0, (childAt.getBottom() + layoutParams.bottomMargin) - i3);
        } else if (rect.top >= scrollY || rect.bottom >= i4) {
            return 0;
        } else {
            if (rect.height() > height) {
                i = 0 - (i4 - rect.bottom);
            } else {
                i = 0 - (scrollY - rect.top);
            }
            return Math.max(i, -getScrollY());
        }
    }

    /* renamed from: a */
    public static boolean m7355a(View view, View view2) {
        if (view == view2) {
            return true;
        }
        ViewParent parent = view.getParent();
        return (parent instanceof ViewGroup) && m7355a((View) parent, view2);
    }
}
