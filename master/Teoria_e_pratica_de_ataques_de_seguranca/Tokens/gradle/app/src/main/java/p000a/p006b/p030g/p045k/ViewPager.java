package p000a.p006b.p030g.p045k;

import android.content.Context;
import android.content.res.TypedArray;
import android.database.DataSetObserver;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.FocusFinder;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.SoundEffectConstants;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;
import android.view.animation.Interpolator;
import android.widget.EdgeEffect;
import android.widget.Scroller;
import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import p000a.p006b.p030g.p032b.ContextCompat;
import p000a.p006b.p030g.p045k.p046e0.AccessibilityNodeInfoCompat;

/* renamed from: a.b.g.k.x */
/* loaded from: classes.dex */
public class ViewPager extends ViewGroup {

    /* renamed from: g0 */
    public static final int[] f1658g0 = {16842931};

    /* renamed from: h0 */
    public static final Comparator<C0295f> f1659h0 = new C0290a();

    /* renamed from: i0 */
    public static final Interpolator f1660i0 = new animationInterpolatorC0291b();

    /* renamed from: j0 */
    public static final C0304n f1661j0 = new C0304n();

    /* renamed from: A */
    public int f1662A;

    /* renamed from: B */
    public int f1663B;

    /* renamed from: C */
    public int f1664C;

    /* renamed from: D */
    public float f1665D;

    /* renamed from: E */
    public float f1666E;

    /* renamed from: F */
    public float f1667F;

    /* renamed from: G */
    public float f1668G;

    /* renamed from: H */
    public int f1669H;

    /* renamed from: I */
    public VelocityTracker f1670I;

    /* renamed from: J */
    public int f1671J;

    /* renamed from: K */
    public int f1672K;

    /* renamed from: L */
    public int f1673L;

    /* renamed from: M */
    public int f1674M;

    /* renamed from: N */
    public boolean f1675N;

    /* renamed from: O */
    public EdgeEffect f1676O;

    /* renamed from: P */
    public EdgeEffect f1677P;

    /* renamed from: Q */
    public boolean f1678Q;

    /* renamed from: R */
    public boolean f1679R;

    /* renamed from: S */
    public int f1680S;

    /* renamed from: T */
    public List<InterfaceC0299j> f1681T;

    /* renamed from: U */
    public InterfaceC0299j f1682U;

    /* renamed from: V */
    public InterfaceC0299j f1683V;

    /* renamed from: W */
    public List<InterfaceC0298i> f1684W;

    /* renamed from: a */
    public int f1685a;

    /* renamed from: a0 */
    public InterfaceC0300k f1686a0;

    /* renamed from: b */
    public final ArrayList<C0295f> f1687b;

    /* renamed from: b0 */
    public int f1688b0;

    /* renamed from: c */
    public final C0295f f1689c;

    /* renamed from: c0 */
    public int f1690c0;

    /* renamed from: d */
    public final Rect f1691d;

    /* renamed from: d0 */
    public ArrayList<View> f1692d0;

    /* renamed from: e */
    public PagerAdapter f1693e;

    /* renamed from: e0 */
    public final Runnable f1694e0;

    /* renamed from: f */
    public int f1695f;

    /* renamed from: f0 */
    public int f1696f0;

    /* renamed from: g */
    public int f1697g;

    /* renamed from: h */
    public Parcelable f1698h;

    /* renamed from: i */
    public ClassLoader f1699i;

    /* renamed from: j */
    public Scroller f1700j;

    /* renamed from: k */
    public boolean f1701k;

    /* renamed from: m */
    public C0301l f1702m;

    /* renamed from: n */
    public int f1703n;

    /* renamed from: o */
    public Drawable f1704o;

    /* renamed from: p */
    public int f1705p;

    /* renamed from: q */
    public int f1706q;

    /* renamed from: r */
    public float f1707r;

    /* renamed from: s */
    public float f1708s;

    /* renamed from: t */
    public int f1709t;

    /* renamed from: u */
    public boolean f1710u;

    /* renamed from: v */
    public boolean f1711v;

    /* renamed from: w */
    public boolean f1712w;

    /* renamed from: x */
    public int f1713x;

    /* renamed from: y */
    public boolean f1714y;

    /* renamed from: z */
    public boolean f1715z;

    /* compiled from: ViewPager.java */
    /* renamed from: a.b.g.k.x$a */
    /* loaded from: classes.dex */
    public static class C0290a implements Comparator<C0295f> {
        @Override // java.util.Comparator
        /* renamed from: a */
        public int compare(C0295f c0295f, C0295f c0295f2) {
            return c0295f.f1720b - c0295f2.f1720b;
        }
    }

    /* compiled from: ViewPager.java */
    /* renamed from: a.b.g.k.x$b  reason: invalid class name */
    /* loaded from: classes.dex */
    public static class animationInterpolatorC0291b implements Interpolator {
        @Override // android.animation.TimeInterpolator
        public float getInterpolation(float f) {
            float f2 = f - 1.0f;
            return (f2 * f2 * f2 * f2 * f2) + 1.0f;
        }
    }

    /* compiled from: ViewPager.java */
    /* renamed from: a.b.g.k.x$c */
    /* loaded from: classes.dex */
    public class RunnableC0292c implements Runnable {
        public RunnableC0292c() {
        }

        @Override // java.lang.Runnable
        public void run() {
            ViewPager.this.setScrollState(0);
            ViewPager.this.m9356g();
        }
    }

    /* compiled from: ViewPager.java */
    /* renamed from: a.b.g.k.x$d */
    /* loaded from: classes.dex */
    public class C0293d implements OnApplyWindowInsetsListener {

        /* renamed from: a */
        public final Rect f1717a = new Rect();

        public C0293d() {
        }

        @Override // p000a.p006b.p030g.p045k.OnApplyWindowInsetsListener
        /* renamed from: a */
        public WindowInsetsCompat mo7712a(View view, WindowInsetsCompat windowInsetsCompat) {
            WindowInsetsCompat m9439b = ViewCompat.m9439b(view, windowInsetsCompat);
            if (m9439b.m9570e()) {
                return m9439b;
            }
            Rect rect = this.f1717a;
            rect.left = m9439b.m9573b();
            rect.top = m9439b.m9571d();
            rect.right = m9439b.m9572c();
            rect.bottom = m9439b.m9577a();
            int childCount = ViewPager.this.getChildCount();
            for (int i = 0; i < childCount; i++) {
                WindowInsetsCompat m9453a = ViewCompat.m9453a(ViewPager.this.getChildAt(i), m9439b);
                rect.left = Math.min(m9453a.m9573b(), rect.left);
                rect.top = Math.min(m9453a.m9571d(), rect.top);
                rect.right = Math.min(m9453a.m9572c(), rect.right);
                rect.bottom = Math.min(m9453a.m9577a(), rect.bottom);
            }
            return m9439b.m9576a(rect.left, rect.top, rect.right, rect.bottom);
        }
    }

    /* compiled from: ViewPager.java */
    @Target({ElementType.TYPE})
    @Inherited
    @Retention(RetentionPolicy.RUNTIME)
    /* renamed from: a.b.g.k.x$e */
    /* loaded from: classes.dex */
    public @interface InterfaceC0294e {
    }

    /* compiled from: ViewPager.java */
    /* renamed from: a.b.g.k.x$f */
    /* loaded from: classes.dex */
    public static class C0295f {

        /* renamed from: a */
        public Object f1719a;

        /* renamed from: b */
        public int f1720b;

        /* renamed from: c */
        public boolean f1721c;

        /* renamed from: d */
        public float f1722d;

        /* renamed from: e */
        public float f1723e;
    }

    /* compiled from: ViewPager.java */
    /* renamed from: a.b.g.k.x$i */
    /* loaded from: classes.dex */
    public interface InterfaceC0298i {
        /* renamed from: a */
        void m9350a(ViewPager viewPager, PagerAdapter pagerAdapter, PagerAdapter pagerAdapter2);
    }

    /* compiled from: ViewPager.java */
    /* renamed from: a.b.g.k.x$j */
    /* loaded from: classes.dex */
    public interface InterfaceC0299j {
        /* renamed from: a */
        void m9349a(int i);

        /* renamed from: a */
        void m9348a(int i, float f, int i2);

        /* renamed from: b */
        void m9347b(int i);
    }

    /* compiled from: ViewPager.java */
    /* renamed from: a.b.g.k.x$k */
    /* loaded from: classes.dex */
    public interface InterfaceC0300k {
        /* renamed from: a */
        void m9346a(View view, float f);
    }

    /* compiled from: ViewPager.java */
    /* renamed from: a.b.g.k.x$l */
    /* loaded from: classes.dex */
    public class C0301l extends DataSetObserver {
        public C0301l() {
        }

        @Override // android.database.DataSetObserver
        public void onChanged() {
            ViewPager.this.m9392a();
        }

        @Override // android.database.DataSetObserver
        public void onInvalidated() {
            ViewPager.this.m9392a();
        }
    }

    /* compiled from: ViewPager.java */
    /* renamed from: a.b.g.k.x$m */
    /* loaded from: classes.dex */
    public static class C0302m extends AbsSavedState {
        public static final Parcelable.Creator<C0302m> CREATOR = new C0303a();

        /* renamed from: c */
        public int f1732c;

        /* renamed from: d */
        public Parcelable f1733d;

        /* renamed from: e */
        public ClassLoader f1734e;

        /* compiled from: ViewPager.java */
        /* renamed from: a.b.g.k.x$m$a */
        /* loaded from: classes.dex */
        public static class C0303a implements Parcelable.ClassLoaderCreator<C0302m> {
            @Override // android.os.Parcelable.Creator
            public C0302m[] newArray(int i) {
                return new C0302m[i];
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.ClassLoaderCreator
            public C0302m createFromParcel(Parcel parcel, ClassLoader classLoader) {
                return new C0302m(parcel, classLoader);
            }

            @Override // android.os.Parcelable.Creator
            public C0302m createFromParcel(Parcel parcel) {
                return new C0302m(parcel, null);
            }
        }

        public C0302m(Parcelable parcelable) {
            super(parcelable);
        }

        public String toString() {
            return "FragmentPager.SavedState{" + Integer.toHexString(System.identityHashCode(this)) + " position=" + this.f1732c + "}";
        }

        @Override // p000a.p006b.p030g.p045k.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeInt(this.f1732c);
            parcel.writeParcelable(this.f1733d, i);
        }

        public C0302m(Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            classLoader = classLoader == null ? C0302m.class.getClassLoader() : classLoader;
            this.f1732c = parcel.readInt();
            this.f1733d = parcel.readParcelable(classLoader);
            this.f1734e = classLoader;
        }
    }

    /* compiled from: ViewPager.java */
    /* renamed from: a.b.g.k.x$n */
    /* loaded from: classes.dex */
    public static class C0304n implements Comparator<View> {
        @Override // java.util.Comparator
        /* renamed from: a */
        public int compare(View view, View view2) {
            C0296g c0296g = (C0296g) view.getLayoutParams();
            C0296g c0296g2 = (C0296g) view2.getLayoutParams();
            boolean z = c0296g.f1724a;
            if (z != c0296g2.f1724a) {
                return z ? 1 : -1;
            }
            return c0296g.f1728e - c0296g2.f1728e;
        }
    }

    public ViewPager(Context context) {
        super(context);
        this.f1687b = new ArrayList<>();
        this.f1689c = new C0295f();
        this.f1691d = new Rect();
        this.f1697g = -1;
        this.f1698h = null;
        this.f1699i = null;
        this.f1707r = -3.4028235E38f;
        this.f1708s = Float.MAX_VALUE;
        this.f1713x = 1;
        this.f1669H = -1;
        this.f1678Q = true;
        this.f1694e0 = new RunnableC0292c();
        this.f1696f0 = 0;
        m9362d();
    }

    /* renamed from: c */
    public static boolean m9364c(View view) {
        return view.getClass().getAnnotation(InterfaceC0294e.class) != null;
    }

    private int getClientWidth() {
        return (getMeasuredWidth() - getPaddingLeft()) - getPaddingRight();
    }

    private void setScrollingCacheEnabled(boolean z) {
        if (this.f1711v != z) {
            this.f1711v = z;
        }
    }

    /* renamed from: a */
    public void m9383a(int i, boolean z) {
        this.f1712w = false;
        m9381a(i, z, false);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void addFocusables(ArrayList<View> arrayList, int i, int i2) {
        C0295f m9368b;
        int size = arrayList.size();
        int descendantFocusability = getDescendantFocusability();
        if (descendantFocusability != 393216) {
            for (int i3 = 0; i3 < getChildCount(); i3++) {
                View childAt = getChildAt(i3);
                if (childAt.getVisibility() == 0 && (m9368b = m9368b(childAt)) != null && m9368b.f1720b == this.f1695f) {
                    childAt.addFocusables(arrayList, i, i2);
                }
            }
        }
        if ((descendantFocusability != 262144 || size == arrayList.size()) && isFocusable()) {
            if (((i2 & 1) == 1 && isInTouchMode() && !isFocusableInTouchMode()) || arrayList == null) {
                return;
            }
            arrayList.add(this);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void addTouchables(ArrayList<View> arrayList) {
        C0295f m9368b;
        for (int i = 0; i < getChildCount(); i++) {
            View childAt = getChildAt(i);
            if (childAt.getVisibility() == 0 && (m9368b = m9368b(childAt)) != null && m9368b.f1720b == this.f1695f) {
                childAt.addTouchables(arrayList);
            }
        }
    }

    @Override // android.view.ViewGroup
    public void addView(View view, int i, ViewGroup.LayoutParams layoutParams) {
        if (!checkLayoutParams(layoutParams)) {
            layoutParams = generateLayoutParams(layoutParams);
        }
        C0296g c0296g = (C0296g) layoutParams;
        c0296g.f1724a |= m9364c(view);
        if (this.f1710u) {
            if (c0296g != null && c0296g.f1724a) {
                throw new IllegalStateException("Cannot add pager decor view during layout");
            }
            c0296g.f1727d = true;
            addViewInLayout(view, i, layoutParams);
            return;
        }
        super.addView(view, i, layoutParams);
    }

    /* renamed from: b */
    public C0295f m9368b(View view) {
        for (int i = 0; i < this.f1687b.size(); i++) {
            C0295f c0295f = this.f1687b.get(i);
            if (this.f1693e.mo9474a(view, c0295f.f1719a)) {
                return c0295f;
            }
        }
        return null;
    }

    @Override // android.view.View
    public boolean canScrollHorizontally(int i) {
        if (this.f1693e == null) {
            return false;
        }
        int clientWidth = getClientWidth();
        int scrollX = getScrollX();
        return i < 0 ? scrollX > ((int) (((float) clientWidth) * this.f1707r)) : i > 0 && scrollX < ((int) (((float) clientWidth) * this.f1708s));
    }

    @Override // android.view.ViewGroup
    public boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return (layoutParams instanceof C0296g) && super.checkLayoutParams(layoutParams);
    }

    @Override // android.view.View
    public void computeScroll() {
        this.f1701k = true;
        if (!this.f1700j.isFinished() && this.f1700j.computeScrollOffset()) {
            int scrollX = getScrollX();
            int scrollY = getScrollY();
            int currX = this.f1700j.getCurrX();
            int currY = this.f1700j.getCurrY();
            if (scrollX != currX || scrollY != currY) {
                scrollTo(currX, currY);
                if (!m9359e(currX)) {
                    this.f1700j.abortAnimation();
                    scrollTo(0, currY);
                }
            }
            ViewCompat.m9464A(this);
            return;
        }
        m9373a(true);
    }

    /* renamed from: d */
    public void m9362d() {
        setWillNotDraw(false);
        setDescendantFocusability(262144);
        setFocusable(true);
        Context context = getContext();
        this.f1700j = new Scroller(context, f1660i0);
        ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
        float f = context.getResources().getDisplayMetrics().density;
        this.f1664C = viewConfiguration.getScaledPagingTouchSlop();
        this.f1671J = (int) (400.0f * f);
        this.f1672K = viewConfiguration.getScaledMaximumFlingVelocity();
        this.f1676O = new EdgeEffect(context);
        this.f1677P = new EdgeEffect(context);
        this.f1673L = (int) (25.0f * f);
        this.f1674M = (int) (2.0f * f);
        this.f1662A = (int) (f * 16.0f);
        ViewCompat.m9454a(this, new C0297h());
        if (ViewCompat.m9424i(this) == 0) {
            ViewCompat.m9429f(this, 1);
        }
        ViewCompat.m9452a(this, new C0293d());
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        return super.dispatchKeyEvent(keyEvent) || m9377a(keyEvent);
    }

    @Override // android.view.View
    public boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        C0295f m9368b;
        if (accessibilityEvent.getEventType() == 4096) {
            return super.dispatchPopulateAccessibilityEvent(accessibilityEvent);
        }
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = getChildAt(i);
            if (childAt.getVisibility() == 0 && (m9368b = m9368b(childAt)) != null && m9368b.f1720b == this.f1695f && childAt.dispatchPopulateAccessibilityEvent(accessibilityEvent)) {
                return true;
            }
        }
        return false;
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        PagerAdapter pagerAdapter;
        super.draw(canvas);
        int overScrollMode = getOverScrollMode();
        boolean z = false;
        if (overScrollMode != 0 && (overScrollMode != 1 || (pagerAdapter = this.f1693e) == null || pagerAdapter.mo1193a() <= 1)) {
            this.f1676O.finish();
            this.f1677P.finish();
        } else {
            if (!this.f1676O.isFinished()) {
                int save = canvas.save();
                int height = (getHeight() - getPaddingTop()) - getPaddingBottom();
                int width = getWidth();
                canvas.rotate(270.0f);
                canvas.translate((-height) + getPaddingTop(), this.f1707r * width);
                this.f1676O.setSize(height, width);
                z = false | this.f1676O.draw(canvas);
                canvas.restoreToCount(save);
            }
            if (!this.f1677P.isFinished()) {
                int save2 = canvas.save();
                int width2 = getWidth();
                int height2 = (getHeight() - getPaddingTop()) - getPaddingBottom();
                canvas.rotate(90.0f);
                canvas.translate(-getPaddingTop(), (-(this.f1708s + 1.0f)) * width2);
                this.f1677P.setSize(height2, width2);
                z |= this.f1677P.draw(canvas);
                canvas.restoreToCount(save2);
            }
        }
        if (z) {
            ViewCompat.m9464A(this);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void drawableStateChanged() {
        super.drawableStateChanged();
        Drawable drawable = this.f1704o;
        if (drawable == null || !drawable.isStateful()) {
            return;
        }
        drawable.setState(getDrawableState());
    }

    /* renamed from: e */
    public final boolean m9359e(int i) {
        if (this.f1687b.size() == 0) {
            if (this.f1678Q) {
                return false;
            }
            this.f1679R = false;
            m9369b(0, 0.0f, 0);
            if (this.f1679R) {
                return false;
            }
            throw new IllegalStateException("onPageScrolled did not call superclass implementation");
        }
        C0295f m9366c = m9366c();
        int clientWidth = getClientWidth();
        int i2 = this.f1703n;
        int i3 = clientWidth + i2;
        float f = clientWidth;
        int i4 = m9366c.f1720b;
        float f2 = ((i / f) - m9366c.f1723e) / (m9366c.f1722d + (i2 / f));
        this.f1679R = false;
        m9369b(i4, f2, (int) (i3 * f2));
        if (this.f1679R) {
            return true;
        }
        throw new IllegalStateException("onPageScrolled did not call superclass implementation");
    }

    /* JADX WARN: Code restructure failed: missing block: B:24:0x0060, code lost:
        if (r9 == r10) goto L27;
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x0066, code lost:
        r8 = null;
     */
    /* renamed from: f */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void m9357f(int r18) {
        /*
            Method dump skipped, instructions count: 617
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: p000a.p006b.p030g.p045k.ViewPager.m9357f(int):void");
    }

    /* renamed from: g */
    public void m9356g() {
        m9357f(this.f1695f);
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return new C0296g();
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return generateDefaultLayoutParams();
    }

    public PagerAdapter getAdapter() {
        return this.f1693e;
    }

    @Override // android.view.ViewGroup
    public int getChildDrawingOrder(int i, int i2) {
        if (this.f1690c0 == 2) {
            i2 = (i - 1) - i2;
        }
        return ((C0296g) this.f1692d0.get(i2).getLayoutParams()).f1729f;
    }

    public int getCurrentItem() {
        return this.f1695f;
    }

    public int getOffscreenPageLimit() {
        return this.f1713x;
    }

    public int getPageMargin() {
        return this.f1703n;
    }

    /* renamed from: h */
    public final void m9355h() {
        int i = 0;
        while (i < getChildCount()) {
            if (!((C0296g) getChildAt(i).getLayoutParams()).f1724a) {
                removeViewAt(i);
                i--;
            }
            i++;
        }
    }

    /* renamed from: i */
    public final boolean m9354i() {
        this.f1669H = -1;
        m9372b();
        this.f1676O.onRelease();
        this.f1677P.onRelease();
        return this.f1676O.isFinished() || this.f1677P.isFinished();
    }

    /* renamed from: j */
    public final void m9353j() {
        if (this.f1690c0 != 0) {
            ArrayList<View> arrayList = this.f1692d0;
            if (arrayList == null) {
                this.f1692d0 = new ArrayList<>();
            } else {
                arrayList.clear();
            }
            int childCount = getChildCount();
            for (int i = 0; i < childCount; i++) {
                this.f1692d0.add(getChildAt(i));
            }
            Collections.sort(this.f1692d0, f1661j0);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.f1678Q = true;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        removeCallbacks(this.f1694e0);
        Scroller scroller = this.f1700j;
        if (scroller != null && !scroller.isFinished()) {
            this.f1700j.abortAnimation();
        }
        super.onDetachedFromWindow();
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        int width;
        float f;
        float f2;
        super.onDraw(canvas);
        if (this.f1703n <= 0 || this.f1704o == null || this.f1687b.size() <= 0 || this.f1693e == null) {
            return;
        }
        int scrollX = getScrollX();
        float width2 = getWidth();
        float f3 = this.f1703n / width2;
        int i = 0;
        C0295f c0295f = this.f1687b.get(0);
        float f4 = c0295f.f1723e;
        int size = this.f1687b.size();
        int i2 = c0295f.f1720b;
        int i3 = this.f1687b.get(size - 1).f1720b;
        while (i2 < i3) {
            while (i2 > c0295f.f1720b && i < size) {
                i++;
                c0295f = this.f1687b.get(i);
            }
            if (i2 == c0295f.f1720b) {
                float f5 = c0295f.f1723e;
                float f6 = c0295f.f1722d;
                f = (f5 + f6) * width2;
                f4 = f5 + f6 + f3;
            } else {
                float m9477a = this.f1693e.m9477a(i2);
                f = (f4 + m9477a) * width2;
                f4 += m9477a + f3;
            }
            if (this.f1703n + f > scrollX) {
                f2 = f3;
                this.f1704o.setBounds(Math.round(f), this.f1705p, Math.round(this.f1703n + f), this.f1706q);
                this.f1704o.draw(canvas);
            } else {
                f2 = f3;
            }
            if (f > scrollX + width) {
                return;
            }
            i2++;
            f3 = f2;
        }
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction() & 255;
        if (action != 3 && action != 1) {
            if (action != 0) {
                if (this.f1714y) {
                    return true;
                }
                if (this.f1715z) {
                    return false;
                }
            }
            if (action == 0) {
                float x = motionEvent.getX();
                this.f1667F = x;
                this.f1665D = x;
                float y = motionEvent.getY();
                this.f1668G = y;
                this.f1666E = y;
                this.f1669H = motionEvent.getPointerId(0);
                this.f1715z = false;
                this.f1701k = true;
                this.f1700j.computeScrollOffset();
                if (this.f1696f0 == 2 && Math.abs(this.f1700j.getFinalX() - this.f1700j.getCurrX()) > this.f1674M) {
                    this.f1700j.abortAnimation();
                    this.f1712w = false;
                    m9356g();
                    this.f1714y = true;
                    m9363c(true);
                    setScrollState(1);
                } else {
                    m9373a(false);
                    this.f1714y = false;
                }
            } else if (action == 2) {
                int i = this.f1669H;
                if (i != -1) {
                    int findPointerIndex = motionEvent.findPointerIndex(i);
                    float x2 = motionEvent.getX(findPointerIndex);
                    float f = x2 - this.f1665D;
                    float abs = Math.abs(f);
                    float y2 = motionEvent.getY(findPointerIndex);
                    float abs2 = Math.abs(y2 - this.f1668G);
                    int i2 = (f > 0.0f ? 1 : (f == 0.0f ? 0 : -1));
                    if (i2 != 0 && !m9390a(this.f1665D, f) && m9374a(this, false, (int) f, (int) x2, (int) y2)) {
                        this.f1665D = x2;
                        this.f1666E = y2;
                        this.f1715z = true;
                        return false;
                    }
                    if (abs > this.f1664C && abs * 0.5f > abs2) {
                        this.f1714y = true;
                        m9363c(true);
                        setScrollState(1);
                        float f2 = this.f1667F;
                        float f3 = this.f1664C;
                        this.f1665D = i2 > 0 ? f2 + f3 : f2 - f3;
                        this.f1666E = y2;
                        setScrollingCacheEnabled(true);
                    } else if (abs2 > this.f1664C) {
                        this.f1715z = true;
                    }
                    if (this.f1714y && m9371b(x2)) {
                        ViewCompat.m9464A(this);
                    }
                }
            } else if (action == 6) {
                m9376a(motionEvent);
            }
            if (this.f1670I == null) {
                this.f1670I = VelocityTracker.obtain();
            }
            this.f1670I.addMovement(motionEvent);
            return this.f1714y;
        }
        m9354i();
        return false;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        boolean z2;
        C0295f m9368b;
        int max;
        int max2;
        int childCount = getChildCount();
        int i5 = i3 - i;
        int i6 = i4 - i2;
        int paddingLeft = getPaddingLeft();
        int paddingTop = getPaddingTop();
        int paddingRight = getPaddingRight();
        int paddingBottom = getPaddingBottom();
        int scrollX = getScrollX();
        int i7 = paddingBottom;
        int i8 = 0;
        int i9 = paddingTop;
        int i10 = paddingLeft;
        for (int i11 = 0; i11 < childCount; i11++) {
            View childAt = getChildAt(i11);
            if (childAt.getVisibility() != 8) {
                C0296g c0296g = (C0296g) childAt.getLayoutParams();
                if (c0296g.f1724a) {
                    int i12 = c0296g.f1725b;
                    int i13 = i12 & 7;
                    int i14 = i12 & 112;
                    if (i13 == 1) {
                        max = Math.max((i5 - childAt.getMeasuredWidth()) / 2, i10);
                    } else if (i13 == 3) {
                        max = i10;
                        i10 = childAt.getMeasuredWidth() + i10;
                    } else if (i13 != 5) {
                        max = i10;
                    } else {
                        max = (i5 - paddingRight) - childAt.getMeasuredWidth();
                        paddingRight += childAt.getMeasuredWidth();
                    }
                    if (i14 == 16) {
                        max2 = Math.max((i6 - childAt.getMeasuredHeight()) / 2, i9);
                    } else if (i14 == 48) {
                        max2 = i9;
                        i9 = childAt.getMeasuredHeight() + i9;
                    } else if (i14 != 80) {
                        max2 = i9;
                    } else {
                        max2 = (i6 - i7) - childAt.getMeasuredHeight();
                        i7 += childAt.getMeasuredHeight();
                    }
                    int i15 = max + scrollX;
                    childAt.layout(i15, max2, childAt.getMeasuredWidth() + i15, max2 + childAt.getMeasuredHeight());
                    i8++;
                }
            }
        }
        int i16 = (i5 - i10) - paddingRight;
        for (int i17 = 0; i17 < childCount; i17++) {
            View childAt2 = getChildAt(i17);
            if (childAt2.getVisibility() != 8) {
                C0296g c0296g2 = (C0296g) childAt2.getLayoutParams();
                if (!c0296g2.f1724a && (m9368b = m9368b(childAt2)) != null) {
                    float f = i16;
                    int i18 = ((int) (m9368b.f1723e * f)) + i10;
                    if (c0296g2.f1727d) {
                        c0296g2.f1727d = false;
                        childAt2.measure(View.MeasureSpec.makeMeasureSpec((int) (f * c0296g2.f1726c), 1073741824), View.MeasureSpec.makeMeasureSpec((i6 - i9) - i7, 1073741824));
                    }
                    childAt2.layout(i18, i9, childAt2.getMeasuredWidth() + i18, childAt2.getMeasuredHeight() + i9);
                }
            }
        }
        this.f1705p = i9;
        this.f1706q = i6 - i7;
        this.f1680S = i8;
        if (this.f1678Q) {
            z2 = false;
            m9382a(this.f1695f, false, 0, false);
        } else {
            z2 = false;
        }
        this.f1678Q = z2;
    }

    /* JADX WARN: Removed duplicated region for block: B:32:0x0084  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x008b  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x0090  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x0095  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x00a4  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x00aa  */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void onMeasure(int r14, int r15) {
        /*
            Method dump skipped, instructions count: 243
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: p000a.p006b.p030g.p045k.ViewPager.onMeasure(int, int):void");
    }

    @Override // android.view.ViewGroup
    public boolean onRequestFocusInDescendants(int i, Rect rect) {
        int i2;
        int i3;
        C0295f m9368b;
        int childCount = getChildCount();
        int i4 = -1;
        if ((i & 2) != 0) {
            i4 = childCount;
            i2 = 0;
            i3 = 1;
        } else {
            i2 = childCount - 1;
            i3 = -1;
        }
        while (i2 != i4) {
            View childAt = getChildAt(i2);
            if (childAt.getVisibility() == 0 && (m9368b = m9368b(childAt)) != null && m9368b.f1720b == this.f1695f && childAt.requestFocus(i, rect)) {
                return true;
            }
            i2 += i3;
        }
        return false;
    }

    @Override // android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof C0302m)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        C0302m c0302m = (C0302m) parcelable;
        super.onRestoreInstanceState(c0302m.m9588a());
        PagerAdapter pagerAdapter = this.f1693e;
        if (pagerAdapter != null) {
            pagerAdapter.mo9475a(c0302m.f1733d, c0302m.f1734e);
            m9381a(c0302m.f1732c, false, true);
            return;
        }
        this.f1697g = c0302m.f1732c;
        this.f1698h = c0302m.f1733d;
        this.f1699i = c0302m.f1734e;
    }

    @Override // android.view.View
    public Parcelable onSaveInstanceState() {
        C0302m c0302m = new C0302m(super.onSaveInstanceState());
        c0302m.f1732c = this.f1695f;
        PagerAdapter pagerAdapter = this.f1693e;
        if (pagerAdapter != null) {
            c0302m.f1733d = pagerAdapter.mo9469b();
        }
        return c0302m;
    }

    @Override // android.view.View
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        if (i != i3) {
            int i5 = this.f1703n;
            m9384a(i, i3, i5, i5);
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        PagerAdapter pagerAdapter;
        if (this.f1675N) {
            return true;
        }
        boolean z = false;
        if ((motionEvent.getAction() == 0 && motionEvent.getEdgeFlags() != 0) || (pagerAdapter = this.f1693e) == null || pagerAdapter.mo1193a() == 0) {
            return false;
        }
        if (this.f1670I == null) {
            this.f1670I = VelocityTracker.obtain();
        }
        this.f1670I.addMovement(motionEvent);
        int action = motionEvent.getAction() & 255;
        if (action == 0) {
            this.f1700j.abortAnimation();
            this.f1712w = false;
            m9356g();
            float x = motionEvent.getX();
            this.f1667F = x;
            this.f1665D = x;
            float y = motionEvent.getY();
            this.f1668G = y;
            this.f1666E = y;
            this.f1669H = motionEvent.getPointerId(0);
        } else if (action != 1) {
            if (action == 2) {
                if (!this.f1714y) {
                    int findPointerIndex = motionEvent.findPointerIndex(this.f1669H);
                    if (findPointerIndex == -1) {
                        z = m9354i();
                    } else {
                        float x2 = motionEvent.getX(findPointerIndex);
                        float abs = Math.abs(x2 - this.f1665D);
                        float y2 = motionEvent.getY(findPointerIndex);
                        float abs2 = Math.abs(y2 - this.f1666E);
                        if (abs > this.f1664C && abs > abs2) {
                            this.f1714y = true;
                            m9363c(true);
                            float f = this.f1667F;
                            this.f1665D = x2 - f > 0.0f ? f + this.f1664C : f - this.f1664C;
                            this.f1666E = y2;
                            setScrollState(1);
                            setScrollingCacheEnabled(true);
                            ViewParent parent = getParent();
                            if (parent != null) {
                                parent.requestDisallowInterceptTouchEvent(true);
                            }
                        }
                    }
                }
                if (this.f1714y) {
                    z = false | m9371b(motionEvent.getX(motionEvent.findPointerIndex(this.f1669H)));
                }
            } else if (action != 3) {
                if (action == 5) {
                    int actionIndex = motionEvent.getActionIndex();
                    this.f1665D = motionEvent.getX(actionIndex);
                    this.f1669H = motionEvent.getPointerId(actionIndex);
                } else if (action == 6) {
                    m9376a(motionEvent);
                    this.f1665D = motionEvent.getX(motionEvent.findPointerIndex(this.f1669H));
                }
            } else if (this.f1714y) {
                m9382a(this.f1695f, true, 0, false);
                z = m9354i();
            }
        } else if (this.f1714y) {
            VelocityTracker velocityTracker = this.f1670I;
            velocityTracker.computeCurrentVelocity(1000, this.f1672K);
            int xVelocity = (int) velocityTracker.getXVelocity(this.f1669H);
            this.f1712w = true;
            int clientWidth = getClientWidth();
            int scrollX = getScrollX();
            C0295f m9366c = m9366c();
            float f2 = clientWidth;
            m9380a(m9387a(m9366c.f1720b, ((scrollX / f2) - m9366c.f1723e) / (m9366c.f1722d + (this.f1703n / f2)), xVelocity, (int) (motionEvent.getX(motionEvent.findPointerIndex(this.f1669H)) - this.f1667F)), true, true, xVelocity);
            z = m9354i();
        }
        if (z) {
            ViewCompat.m9464A(this);
        }
        return true;
    }

    @Override // android.view.ViewGroup, android.view.ViewManager
    public void removeView(View view) {
        if (this.f1710u) {
            removeViewInLayout(view);
        } else {
            super.removeView(view);
        }
    }

    public void setAdapter(PagerAdapter pagerAdapter) {
        PagerAdapter pagerAdapter2 = this.f1693e;
        if (pagerAdapter2 != null) {
            pagerAdapter2.m9476a((DataSetObserver) null);
            this.f1693e.mo9468b(this);
            for (int i = 0; i < this.f1687b.size(); i++) {
                C0295f c0295f = this.f1687b.get(i);
                this.f1693e.mo9471a(this, c0295f.f1720b, c0295f.f1719a);
            }
            this.f1693e.mo9473a((ViewGroup) this);
            this.f1687b.clear();
            m9355h();
            this.f1695f = 0;
            scrollTo(0, 0);
        }
        PagerAdapter pagerAdapter3 = this.f1693e;
        this.f1693e = pagerAdapter;
        this.f1685a = 0;
        if (this.f1693e != null) {
            if (this.f1702m == null) {
                this.f1702m = new C0301l();
            }
            this.f1693e.m9476a((DataSetObserver) this.f1702m);
            this.f1712w = false;
            boolean z = this.f1678Q;
            this.f1678Q = true;
            this.f1685a = this.f1693e.mo1193a();
            if (this.f1697g >= 0) {
                this.f1693e.mo9475a(this.f1698h, this.f1699i);
                m9381a(this.f1697g, false, true);
                this.f1697g = -1;
                this.f1698h = null;
                this.f1699i = null;
            } else if (!z) {
                m9356g();
            } else {
                requestLayout();
            }
        }
        List<InterfaceC0298i> list = this.f1684W;
        if (list == null || list.isEmpty()) {
            return;
        }
        int size = this.f1684W.size();
        for (int i2 = 0; i2 < size; i2++) {
            this.f1684W.get(i2).m9350a(this, pagerAdapter3, pagerAdapter);
        }
    }

    public void setCurrentItem(int i) {
        this.f1712w = false;
        m9381a(i, !this.f1678Q, false);
    }

    public void setOffscreenPageLimit(int i) {
        if (i < 1) {
            Log.w("ViewPager", "Requested offscreen page limit " + i + " too small; defaulting to 1");
            i = 1;
        }
        if (i != this.f1713x) {
            this.f1713x = i;
            m9356g();
        }
    }

    @Deprecated
    public void setOnPageChangeListener(InterfaceC0299j interfaceC0299j) {
        this.f1682U = interfaceC0299j;
    }

    public void setPageMargin(int i) {
        int i2 = this.f1703n;
        this.f1703n = i;
        int width = getWidth();
        m9384a(width, width, i, i2);
        requestLayout();
    }

    public void setPageMarginDrawable(Drawable drawable) {
        this.f1704o = drawable;
        if (drawable != null) {
            refreshDrawableState();
        }
        setWillNotDraw(drawable == null);
        invalidate();
    }

    public void setScrollState(int i) {
        if (this.f1696f0 == i) {
            return;
        }
        this.f1696f0 = i;
        if (this.f1686a0 != null) {
            m9367b(i != 0);
        }
        m9365c(i);
    }

    @Override // android.view.View
    public boolean verifyDrawable(Drawable drawable) {
        return super.verifyDrawable(drawable) || drawable == this.f1704o;
    }

    /* compiled from: ViewPager.java */
    /* renamed from: a.b.g.k.x$g */
    /* loaded from: classes.dex */
    public static class C0296g extends ViewGroup.LayoutParams {

        /* renamed from: a */
        public boolean f1724a;

        /* renamed from: b */
        public int f1725b;

        /* renamed from: c */
        public float f1726c;

        /* renamed from: d */
        public boolean f1727d;

        /* renamed from: e */
        public int f1728e;

        /* renamed from: f */
        public int f1729f;

        public C0296g() {
            super(-1, -1);
            this.f1726c = 0.0f;
        }

        public C0296g(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            this.f1726c = 0.0f;
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, ViewPager.f1658g0);
            this.f1725b = obtainStyledAttributes.getInteger(0, 48);
            obtainStyledAttributes.recycle();
        }
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new C0296g(getContext(), attributeSet);
    }

    /* renamed from: a */
    public void m9381a(int i, boolean z, boolean z2) {
        m9380a(i, z, z2, 0);
    }

    /* renamed from: c */
    public final void m9365c(int i) {
        InterfaceC0299j interfaceC0299j = this.f1682U;
        if (interfaceC0299j != null) {
            interfaceC0299j.m9349a(i);
        }
        List<InterfaceC0299j> list = this.f1681T;
        if (list != null) {
            int size = list.size();
            for (int i2 = 0; i2 < size; i2++) {
                InterfaceC0299j interfaceC0299j2 = this.f1681T.get(i2);
                if (interfaceC0299j2 != null) {
                    interfaceC0299j2.m9349a(i);
                }
            }
        }
        InterfaceC0299j interfaceC0299j3 = this.f1683V;
        if (interfaceC0299j3 != null) {
            interfaceC0299j3.m9349a(i);
        }
    }

    /* renamed from: a */
    public void m9380a(int i, boolean z, boolean z2, int i2) {
        PagerAdapter pagerAdapter = this.f1693e;
        if (pagerAdapter != null && pagerAdapter.mo1193a() > 0) {
            if (!z2 && this.f1695f == i && this.f1687b.size() != 0) {
                setScrollingCacheEnabled(false);
                return;
            }
            if (i < 0) {
                i = 0;
            } else if (i >= this.f1693e.mo1193a()) {
                i = this.f1693e.mo1193a() - 1;
            }
            int i3 = this.f1713x;
            int i4 = this.f1695f;
            if (i > i4 + i3 || i < i4 - i3) {
                for (int i5 = 0; i5 < this.f1687b.size(); i5++) {
                    this.f1687b.get(i5).f1721c = true;
                }
            }
            boolean z3 = this.f1695f != i;
            if (this.f1678Q) {
                this.f1695f = i;
                if (z3) {
                    m9370b(i);
                }
                requestLayout();
                return;
            }
            m9357f(i);
            m9382a(i, z, i2, z3);
            return;
        }
        setScrollingCacheEnabled(false);
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x0066  */
    /* renamed from: b */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void m9369b(int r13, float r14, int r15) {
        /*
            r12 = this;
            int r0 = r12.f1680S
            r1 = 0
            r2 = 1
            if (r0 <= 0) goto L6d
            int r0 = r12.getScrollX()
            int r3 = r12.getPaddingLeft()
            int r4 = r12.getPaddingRight()
            int r5 = r12.getWidth()
            int r6 = r12.getChildCount()
            r7 = r4
            r4 = r3
            r3 = 0
        L1d:
            if (r3 >= r6) goto L6d
            android.view.View r8 = r12.getChildAt(r3)
            android.view.ViewGroup$LayoutParams r9 = r8.getLayoutParams()
            a.b.g.k.x$g r9 = (p000a.p006b.p030g.p045k.ViewPager.C0296g) r9
            boolean r10 = r9.f1724a
            if (r10 != 0) goto L2e
            goto L6a
        L2e:
            int r9 = r9.f1725b
            r9 = r9 & 7
            if (r9 == r2) goto L4f
            r10 = 3
            if (r9 == r10) goto L49
            r10 = 5
            if (r9 == r10) goto L3c
            r9 = r4
            goto L5e
        L3c:
            int r9 = r5 - r7
            int r10 = r8.getMeasuredWidth()
            int r9 = r9 - r10
            int r10 = r8.getMeasuredWidth()
            int r7 = r7 + r10
            goto L5b
        L49:
            int r9 = r8.getWidth()
            int r9 = r9 + r4
            goto L5e
        L4f:
            int r9 = r8.getMeasuredWidth()
            int r9 = r5 - r9
            int r9 = r9 / 2
            int r9 = java.lang.Math.max(r9, r4)
        L5b:
            r11 = r9
            r9 = r4
            r4 = r11
        L5e:
            int r4 = r4 + r0
            int r10 = r8.getLeft()
            int r4 = r4 - r10
            if (r4 == 0) goto L69
            r8.offsetLeftAndRight(r4)
        L69:
            r4 = r9
        L6a:
            int r3 = r3 + 1
            goto L1d
        L6d:
            r12.m9388a(r13, r14, r15)
            a.b.g.k.x$k r13 = r12.f1686a0
            if (r13 == 0) goto La1
            int r13 = r12.getScrollX()
            int r14 = r12.getChildCount()
        L7c:
            if (r1 >= r14) goto La1
            android.view.View r15 = r12.getChildAt(r1)
            android.view.ViewGroup$LayoutParams r0 = r15.getLayoutParams()
            a.b.g.k.x$g r0 = (p000a.p006b.p030g.p045k.ViewPager.C0296g) r0
            boolean r0 = r0.f1724a
            if (r0 == 0) goto L8d
            goto L9e
        L8d:
            int r0 = r15.getLeft()
            int r0 = r0 - r13
            float r0 = (float) r0
            int r3 = r12.getClientWidth()
            float r3 = (float) r3
            float r0 = r0 / r3
            a.b.g.k.x$k r3 = r12.f1686a0
            r3.m9346a(r15, r0)
        L9e:
            int r1 = r1 + 1
            goto L7c
        La1:
            r12.f1679R = r2
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: p000a.p006b.p030g.p045k.ViewPager.m9369b(int, float, int):void");
    }

    public void setPageMarginDrawable(int i) {
        setPageMarginDrawable(ContextCompat.m10016c(getContext(), i));
    }

    /* compiled from: ViewPager.java */
    /* renamed from: a.b.g.k.x$h */
    /* loaded from: classes.dex */
    public class C0297h extends AccessibilityDelegateCompat {
        public C0297h() {
        }

        @Override // p000a.p006b.p030g.p045k.AccessibilityDelegateCompat
        /* renamed from: a */
        public void mo7332a(View view, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
            super.mo7332a(view, accessibilityNodeInfoCompat);
            accessibilityNodeInfoCompat.m9554a((CharSequence) ViewPager.class.getName());
            accessibilityNodeInfoCompat.m9538e(m9351b());
            if (ViewPager.this.canScrollHorizontally(1)) {
                accessibilityNodeInfoCompat.m9558a(4096);
            }
            if (ViewPager.this.canScrollHorizontally(-1)) {
                accessibilityNodeInfoCompat.m9558a(8192);
            }
        }

        @Override // p000a.p006b.p030g.p045k.AccessibilityDelegateCompat
        /* renamed from: b */
        public void mo7331b(View view, AccessibilityEvent accessibilityEvent) {
            PagerAdapter pagerAdapter;
            super.mo7331b(view, accessibilityEvent);
            accessibilityEvent.setClassName(ViewPager.class.getName());
            accessibilityEvent.setScrollable(m9351b());
            if (accessibilityEvent.getEventType() != 4096 || (pagerAdapter = ViewPager.this.f1693e) == null) {
                return;
            }
            accessibilityEvent.setItemCount(pagerAdapter.mo1193a());
            accessibilityEvent.setFromIndex(ViewPager.this.f1695f);
            accessibilityEvent.setToIndex(ViewPager.this.f1695f);
        }

        @Override // p000a.p006b.p030g.p045k.AccessibilityDelegateCompat
        /* renamed from: a */
        public boolean mo7333a(View view, int i, Bundle bundle) {
            if (super.mo7333a(view, i, bundle)) {
                return true;
            }
            if (i != 4096) {
                if (i == 8192 && ViewPager.this.canScrollHorizontally(-1)) {
                    ViewPager viewPager = ViewPager.this;
                    viewPager.setCurrentItem(viewPager.f1695f - 1);
                    return true;
                }
                return false;
            } else if (ViewPager.this.canScrollHorizontally(1)) {
                ViewPager viewPager2 = ViewPager.this;
                viewPager2.setCurrentItem(viewPager2.f1695f + 1);
                return true;
            } else {
                return false;
            }
        }

        /* renamed from: b */
        public final boolean m9351b() {
            PagerAdapter pagerAdapter = ViewPager.this.f1693e;
            return pagerAdapter != null && pagerAdapter.mo1193a() > 1;
        }
    }

    /* renamed from: c */
    public final void m9363c(boolean z) {
        ViewParent parent = getParent();
        if (parent != null) {
            parent.requestDisallowInterceptTouchEvent(z);
        }
    }

    /* renamed from: c */
    public final C0295f m9366c() {
        int i;
        int clientWidth = getClientWidth();
        float scrollX = clientWidth > 0 ? getScrollX() / clientWidth : 0.0f;
        float f = clientWidth > 0 ? this.f1703n / clientWidth : 0.0f;
        C0295f c0295f = null;
        int i2 = 0;
        boolean z = true;
        int i3 = -1;
        float f2 = 0.0f;
        float f3 = 0.0f;
        while (i2 < this.f1687b.size()) {
            C0295f c0295f2 = this.f1687b.get(i2);
            if (!z && c0295f2.f1720b != (i = i3 + 1)) {
                c0295f2 = this.f1689c;
                c0295f2.f1723e = f2 + f3 + f;
                c0295f2.f1720b = i;
                c0295f2.f1722d = this.f1693e.m9477a(c0295f2.f1720b);
                i2--;
            }
            f2 = c0295f2.f1723e;
            float f4 = c0295f2.f1722d + f2 + f;
            if (!z && scrollX < f2) {
                return c0295f;
            }
            if (scrollX < f4 || i2 == this.f1687b.size() - 1) {
                return c0295f2;
            }
            i3 = c0295f2.f1720b;
            f3 = c0295f2.f1722d;
            i2++;
            c0295f = c0295f2;
            z = false;
        }
        return c0295f;
    }

    public ViewPager(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f1687b = new ArrayList<>();
        this.f1689c = new C0295f();
        this.f1691d = new Rect();
        this.f1697g = -1;
        this.f1698h = null;
        this.f1699i = null;
        this.f1707r = -3.4028235E38f;
        this.f1708s = Float.MAX_VALUE;
        this.f1713x = 1;
        this.f1669H = -1;
        this.f1678Q = true;
        this.f1694e0 = new RunnableC0292c();
        this.f1696f0 = 0;
        m9362d();
    }

    /* renamed from: e */
    public boolean m9360e() {
        int i = this.f1695f;
        if (i > 0) {
            m9383a(i - 1, true);
            return true;
        }
        return false;
    }

    /* renamed from: d */
    public C0295f m9361d(int i) {
        for (int i2 = 0; i2 < this.f1687b.size(); i2++) {
            C0295f c0295f = this.f1687b.get(i2);
            if (c0295f.f1720b == i) {
                return c0295f;
            }
        }
        return null;
    }

    /* renamed from: a */
    public final void m9382a(int i, boolean z, int i2, boolean z2) {
        C0295f m9361d = m9361d(i);
        int clientWidth = m9361d != null ? (int) (getClientWidth() * Math.max(this.f1707r, Math.min(m9361d.f1723e, this.f1708s))) : 0;
        if (z) {
            m9385a(clientWidth, 0, i2);
            if (z2) {
                m9370b(i);
                return;
            }
            return;
        }
        if (z2) {
            m9370b(i);
        }
        m9373a(false);
        scrollTo(clientWidth, 0);
        m9359e(clientWidth);
    }

    /* renamed from: b */
    public final void m9370b(int i) {
        InterfaceC0299j interfaceC0299j = this.f1682U;
        if (interfaceC0299j != null) {
            interfaceC0299j.m9347b(i);
        }
        List<InterfaceC0299j> list = this.f1681T;
        if (list != null) {
            int size = list.size();
            for (int i2 = 0; i2 < size; i2++) {
                InterfaceC0299j interfaceC0299j2 = this.f1681T.get(i2);
                if (interfaceC0299j2 != null) {
                    interfaceC0299j2.m9347b(i);
                }
            }
        }
        InterfaceC0299j interfaceC0299j3 = this.f1683V;
        if (interfaceC0299j3 != null) {
            interfaceC0299j3.m9347b(i);
        }
    }

    /* renamed from: a */
    public float m9391a(float f) {
        return (float) Math.sin((f - 0.5f) * 0.47123894f);
    }

    /* renamed from: a */
    public void m9385a(int i, int i2, int i3) {
        int scrollX;
        int abs;
        if (getChildCount() == 0) {
            setScrollingCacheEnabled(false);
            return;
        }
        Scroller scroller = this.f1700j;
        if ((scroller == null || scroller.isFinished()) ? false : true) {
            scrollX = this.f1701k ? this.f1700j.getCurrX() : this.f1700j.getStartX();
            this.f1700j.abortAnimation();
            setScrollingCacheEnabled(false);
        } else {
            scrollX = getScrollX();
        }
        int i4 = scrollX;
        int scrollY = getScrollY();
        int i5 = i - i4;
        int i6 = i2 - scrollY;
        if (i5 == 0 && i6 == 0) {
            m9373a(false);
            m9356g();
            setScrollState(0);
            return;
        }
        setScrollingCacheEnabled(true);
        setScrollState(2);
        int clientWidth = getClientWidth();
        int i7 = clientWidth / 2;
        float f = clientWidth;
        float f2 = i7;
        float m9391a = f2 + (m9391a(Math.min(1.0f, (Math.abs(i5) * 1.0f) / f)) * f2);
        int abs2 = Math.abs(i3);
        if (abs2 > 0) {
            abs = Math.round(Math.abs(m9391a / abs2) * 1000.0f) * 4;
        } else {
            abs = (int) (((Math.abs(i5) / ((f * this.f1693e.m9477a(this.f1695f)) + this.f1703n)) + 1.0f) * 100.0f);
        }
        int min = Math.min(abs, 600);
        this.f1701k = false;
        this.f1700j.startScroll(i4, scrollY, i5, i6, min);
        ViewCompat.m9464A(this);
    }

    /* renamed from: b */
    public final void m9367b(boolean z) {
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            getChildAt(i).setLayerType(z ? this.f1688b0 : 0, null);
        }
    }

    /* renamed from: b */
    public final boolean m9371b(float f) {
        boolean z;
        boolean z2;
        float f2 = this.f1665D - f;
        this.f1665D = f;
        float scrollX = getScrollX() + f2;
        float clientWidth = getClientWidth();
        float f3 = this.f1707r * clientWidth;
        float f4 = this.f1708s * clientWidth;
        boolean z3 = false;
        C0295f c0295f = this.f1687b.get(0);
        ArrayList<C0295f> arrayList = this.f1687b;
        C0295f c0295f2 = arrayList.get(arrayList.size() - 1);
        if (c0295f.f1720b != 0) {
            f3 = c0295f.f1723e * clientWidth;
            z = false;
        } else {
            z = true;
        }
        if (c0295f2.f1720b != this.f1693e.mo1193a() - 1) {
            f4 = c0295f2.f1723e * clientWidth;
            z2 = false;
        } else {
            z2 = true;
        }
        if (scrollX < f3) {
            if (z) {
                this.f1676O.onPull(Math.abs(f3 - scrollX) / clientWidth);
                z3 = true;
            }
            scrollX = f3;
        } else if (scrollX > f4) {
            if (z2) {
                this.f1677P.onPull(Math.abs(scrollX - f4) / clientWidth);
                z3 = true;
            }
            scrollX = f4;
        }
        int i = (int) scrollX;
        this.f1665D += scrollX - i;
        scrollTo(i, getScrollY());
        m9359e(i);
        return z3;
    }

    /* renamed from: a */
    public C0295f m9386a(int i, int i2) {
        C0295f c0295f = new C0295f();
        c0295f.f1720b = i;
        c0295f.f1719a = this.f1693e.mo9472a(this, i);
        c0295f.f1722d = this.f1693e.m9477a(i);
        if (i2 >= 0 && i2 < this.f1687b.size()) {
            this.f1687b.add(i2, c0295f);
        } else {
            this.f1687b.add(c0295f);
        }
        return c0295f;
    }

    /* renamed from: b */
    public final void m9372b() {
        this.f1714y = false;
        this.f1715z = false;
        VelocityTracker velocityTracker = this.f1670I;
        if (velocityTracker != null) {
            velocityTracker.recycle();
            this.f1670I = null;
        }
    }

    /* renamed from: a */
    public void m9392a() {
        int mo1193a = this.f1693e.mo1193a();
        this.f1685a = mo1193a;
        boolean z = this.f1687b.size() < (this.f1713x * 2) + 1 && this.f1687b.size() < mo1193a;
        int i = this.f1695f;
        int i2 = 0;
        boolean z2 = false;
        while (i2 < this.f1687b.size()) {
            C0295f c0295f = this.f1687b.get(i2);
            int m9470a = this.f1693e.m9470a(c0295f.f1719a);
            if (m9470a != -1) {
                if (m9470a == -2) {
                    this.f1687b.remove(i2);
                    i2--;
                    if (!z2) {
                        this.f1693e.mo9468b(this);
                        z2 = true;
                    }
                    this.f1693e.mo9471a(this, c0295f.f1720b, c0295f.f1719a);
                    int i3 = this.f1695f;
                    if (i3 == c0295f.f1720b) {
                        i = Math.max(0, Math.min(i3, mo1193a - 1));
                    }
                } else {
                    int i4 = c0295f.f1720b;
                    if (i4 != m9470a) {
                        if (i4 == this.f1695f) {
                            i = m9470a;
                        }
                        c0295f.f1720b = m9470a;
                    }
                }
                z = true;
            }
            i2++;
        }
        if (z2) {
            this.f1693e.mo9473a((ViewGroup) this);
        }
        Collections.sort(this.f1687b, f1659h0);
        if (z) {
            int childCount = getChildCount();
            for (int i5 = 0; i5 < childCount; i5++) {
                C0296g c0296g = (C0296g) getChildAt(i5).getLayoutParams();
                if (!c0296g.f1724a) {
                    c0296g.f1726c = 0.0f;
                }
            }
            m9381a(i, false, true);
            requestLayout();
        }
    }

    /* renamed from: f */
    public boolean m9358f() {
        PagerAdapter pagerAdapter = this.f1693e;
        if (pagerAdapter == null || this.f1695f >= pagerAdapter.mo1193a() - 1) {
            return false;
        }
        m9383a(this.f1695f + 1, true);
        return true;
    }

    /* renamed from: a */
    public final void m9379a(C0295f c0295f, int i, C0295f c0295f2) {
        int i2;
        int i3;
        C0295f c0295f3;
        C0295f c0295f4;
        int mo1193a = this.f1693e.mo1193a();
        int clientWidth = getClientWidth();
        float f = clientWidth > 0 ? this.f1703n / clientWidth : 0.0f;
        if (c0295f2 != null) {
            int i4 = c0295f2.f1720b;
            int i5 = c0295f.f1720b;
            if (i4 < i5) {
                int i6 = 0;
                float f2 = c0295f2.f1723e + c0295f2.f1722d + f;
                while (true) {
                    i4++;
                    if (i4 > c0295f.f1720b || i6 >= this.f1687b.size()) {
                        break;
                    }
                    C0295f c0295f5 = this.f1687b.get(i6);
                    while (true) {
                        c0295f4 = c0295f5;
                        if (i4 <= c0295f4.f1720b || i6 >= this.f1687b.size() - 1) {
                            break;
                        }
                        i6++;
                        c0295f5 = this.f1687b.get(i6);
                    }
                    while (i4 < c0295f4.f1720b) {
                        f2 += this.f1693e.m9477a(i4) + f;
                        i4++;
                    }
                    c0295f4.f1723e = f2;
                    f2 += c0295f4.f1722d + f;
                }
            } else if (i4 > i5) {
                int size = this.f1687b.size() - 1;
                float f3 = c0295f2.f1723e;
                while (true) {
                    i4--;
                    if (i4 < c0295f.f1720b || size < 0) {
                        break;
                    }
                    C0295f c0295f6 = this.f1687b.get(size);
                    while (true) {
                        c0295f3 = c0295f6;
                        if (i4 >= c0295f3.f1720b || size <= 0) {
                            break;
                        }
                        size--;
                        c0295f6 = this.f1687b.get(size);
                    }
                    while (i4 > c0295f3.f1720b) {
                        f3 -= this.f1693e.m9477a(i4) + f;
                        i4--;
                    }
                    f3 -= c0295f3.f1722d + f;
                    c0295f3.f1723e = f3;
                }
            }
        }
        int size2 = this.f1687b.size();
        float f4 = c0295f.f1723e;
        int i7 = c0295f.f1720b;
        int i8 = i7 - 1;
        this.f1707r = i7 == 0 ? f4 : -3.4028235E38f;
        int i9 = mo1193a - 1;
        this.f1708s = c0295f.f1720b == i9 ? (c0295f.f1723e + c0295f.f1722d) - 1.0f : Float.MAX_VALUE;
        int i10 = i - 1;
        while (i10 >= 0) {
            C0295f c0295f7 = this.f1687b.get(i10);
            while (true) {
                i3 = c0295f7.f1720b;
                if (i8 <= i3) {
                    break;
                }
                f4 -= this.f1693e.m9477a(i8) + f;
                i8--;
            }
            f4 -= c0295f7.f1722d + f;
            c0295f7.f1723e = f4;
            if (i3 == 0) {
                this.f1707r = f4;
            }
            i10--;
            i8--;
        }
        float f5 = c0295f.f1723e + c0295f.f1722d + f;
        int i11 = c0295f.f1720b + 1;
        int i12 = i + 1;
        while (i12 < size2) {
            C0295f c0295f8 = this.f1687b.get(i12);
            while (true) {
                i2 = c0295f8.f1720b;
                if (i11 >= i2) {
                    break;
                }
                f5 += this.f1693e.m9477a(i11) + f;
                i11++;
            }
            if (i2 == i9) {
                this.f1708s = (c0295f8.f1722d + f5) - 1.0f;
            }
            c0295f8.f1723e = f5;
            f5 += c0295f8.f1722d + f;
            i12++;
            i11++;
        }
    }

    /* renamed from: a */
    public C0295f m9375a(View view) {
        while (true) {
            ViewParent parent = view.getParent();
            if (parent != this) {
                if (parent == null || !(parent instanceof View)) {
                    return null;
                }
                view = (View) parent;
            } else {
                return m9368b(view);
            }
        }
    }

    /* renamed from: a */
    public final void m9384a(int i, int i2, int i3, int i4) {
        if (i2 > 0 && !this.f1687b.isEmpty()) {
            if (!this.f1700j.isFinished()) {
                this.f1700j.setFinalX(getCurrentItem() * getClientWidth());
                return;
            } else {
                scrollTo((int) ((getScrollX() / (((i2 - getPaddingLeft()) - getPaddingRight()) + i4)) * (((i - getPaddingLeft()) - getPaddingRight()) + i3)), getScrollY());
                return;
            }
        }
        C0295f m9361d = m9361d(this.f1695f);
        int min = (int) ((m9361d != null ? Math.min(m9361d.f1723e, this.f1708s) : 0.0f) * ((i - getPaddingLeft()) - getPaddingRight()));
        if (min != getScrollX()) {
            m9373a(false);
            scrollTo(min, getScrollY());
        }
    }

    /* renamed from: a */
    public final void m9388a(int i, float f, int i2) {
        InterfaceC0299j interfaceC0299j = this.f1682U;
        if (interfaceC0299j != null) {
            interfaceC0299j.m9348a(i, f, i2);
        }
        List<InterfaceC0299j> list = this.f1681T;
        if (list != null) {
            int size = list.size();
            for (int i3 = 0; i3 < size; i3++) {
                InterfaceC0299j interfaceC0299j2 = this.f1681T.get(i3);
                if (interfaceC0299j2 != null) {
                    interfaceC0299j2.m9348a(i, f, i2);
                }
            }
        }
        InterfaceC0299j interfaceC0299j3 = this.f1683V;
        if (interfaceC0299j3 != null) {
            interfaceC0299j3.m9348a(i, f, i2);
        }
    }

    /* renamed from: a */
    public final void m9373a(boolean z) {
        boolean z2 = this.f1696f0 == 2;
        if (z2) {
            setScrollingCacheEnabled(false);
            if (!this.f1700j.isFinished()) {
                this.f1700j.abortAnimation();
                int scrollX = getScrollX();
                int scrollY = getScrollY();
                int currX = this.f1700j.getCurrX();
                int currY = this.f1700j.getCurrY();
                if (scrollX != currX || scrollY != currY) {
                    scrollTo(currX, currY);
                    if (currX != scrollX) {
                        m9359e(currX);
                    }
                }
            }
        }
        this.f1712w = false;
        boolean z3 = z2;
        for (int i = 0; i < this.f1687b.size(); i++) {
            C0295f c0295f = this.f1687b.get(i);
            if (c0295f.f1721c) {
                c0295f.f1721c = false;
                z3 = true;
            }
        }
        if (z3) {
            if (z) {
                ViewCompat.m9445a(this, this.f1694e0);
            } else {
                this.f1694e0.run();
            }
        }
    }

    /* renamed from: a */
    public final boolean m9390a(float f, float f2) {
        return (f < ((float) this.f1663B) && f2 > 0.0f) || (f > ((float) (getWidth() - this.f1663B)) && f2 < 0.0f);
    }

    /* renamed from: a */
    public final int m9387a(int i, float f, int i2, int i3) {
        if (Math.abs(i3) <= this.f1673L || Math.abs(i2) <= this.f1671J) {
            i += (int) (f + (i >= this.f1695f ? 0.4f : 0.6f));
        } else if (i2 <= 0) {
            i++;
        }
        if (this.f1687b.size() > 0) {
            ArrayList<C0295f> arrayList = this.f1687b;
            return Math.max(this.f1687b.get(0).f1720b, Math.min(i, arrayList.get(arrayList.size() - 1).f1720b));
        }
        return i;
    }

    /* renamed from: a */
    public final void m9376a(MotionEvent motionEvent) {
        int actionIndex = motionEvent.getActionIndex();
        if (motionEvent.getPointerId(actionIndex) == this.f1669H) {
            int i = actionIndex == 0 ? 1 : 0;
            this.f1665D = motionEvent.getX(i);
            this.f1669H = motionEvent.getPointerId(i);
            VelocityTracker velocityTracker = this.f1670I;
            if (velocityTracker != null) {
                velocityTracker.clear();
            }
        }
    }

    /* renamed from: a */
    public boolean m9374a(View view, boolean z, int i, int i2, int i3) {
        int i4;
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            int scrollX = view.getScrollX();
            int scrollY = view.getScrollY();
            for (int childCount = viewGroup.getChildCount() - 1; childCount >= 0; childCount--) {
                View childAt = viewGroup.getChildAt(childCount);
                int i5 = i2 + scrollX;
                if (i5 >= childAt.getLeft() && i5 < childAt.getRight() && (i4 = i3 + scrollY) >= childAt.getTop() && i4 < childAt.getBottom() && m9374a(childAt, true, i, i5 - childAt.getLeft(), i4 - childAt.getTop())) {
                    return true;
                }
            }
        }
        return z && view.canScrollHorizontally(-i);
    }

    /* renamed from: a */
    public boolean m9377a(KeyEvent keyEvent) {
        if (keyEvent.getAction() == 0) {
            int keyCode = keyEvent.getKeyCode();
            if (keyCode == 21) {
                if (keyEvent.hasModifiers(2)) {
                    return m9360e();
                }
                return m9389a(17);
            } else if (keyCode == 22) {
                if (keyEvent.hasModifiers(2)) {
                    return m9358f();
                }
                return m9389a(66);
            } else if (keyCode == 61) {
                if (keyEvent.hasNoModifiers()) {
                    return m9389a(2);
                }
                if (keyEvent.hasModifiers(1)) {
                    return m9389a(1);
                }
            }
        }
        return false;
    }

    /* renamed from: a */
    public boolean m9389a(int i) {
        boolean requestFocus;
        boolean z;
        View findFocus = findFocus();
        boolean z2 = false;
        View view = null;
        if (findFocus != this) {
            if (findFocus != null) {
                ViewParent parent = findFocus.getParent();
                while (true) {
                    if (!(parent instanceof ViewGroup)) {
                        z = false;
                        break;
                    } else if (parent == this) {
                        z = true;
                        break;
                    } else {
                        parent = parent.getParent();
                    }
                }
                if (!z) {
                    StringBuilder sb = new StringBuilder();
                    sb.append(findFocus.getClass().getSimpleName());
                    for (ViewParent parent2 = findFocus.getParent(); parent2 instanceof ViewGroup; parent2 = parent2.getParent()) {
                        sb.append(" => ");
                        sb.append(parent2.getClass().getSimpleName());
                    }
                    Log.e("ViewPager", "arrowScroll tried to find focus based on non-child current focused view " + sb.toString());
                }
            }
            view = findFocus;
        }
        View findNextFocus = FocusFinder.getInstance().findNextFocus(this, view, i);
        if (findNextFocus != null && findNextFocus != view) {
            if (i == 17) {
                int i2 = m9378a(this.f1691d, findNextFocus).left;
                int i3 = m9378a(this.f1691d, view).left;
                if (view != null && i2 >= i3) {
                    requestFocus = m9360e();
                } else {
                    requestFocus = findNextFocus.requestFocus();
                }
            } else if (i == 66) {
                int i4 = m9378a(this.f1691d, findNextFocus).left;
                int i5 = m9378a(this.f1691d, view).left;
                if (view != null && i4 <= i5) {
                    requestFocus = m9358f();
                } else {
                    requestFocus = findNextFocus.requestFocus();
                }
            }
            z2 = requestFocus;
        } else if (i == 17 || i == 1) {
            z2 = m9360e();
        } else if (i == 66 || i == 2) {
            z2 = m9358f();
        }
        if (z2) {
            playSoundEffect(SoundEffectConstants.getContantForFocusDirection(i));
        }
        return z2;
    }

    /* renamed from: a */
    public final Rect m9378a(Rect rect, View view) {
        if (rect == null) {
            rect = new Rect();
        }
        if (view == null) {
            rect.set(0, 0, 0, 0);
            return rect;
        }
        rect.left = view.getLeft();
        rect.right = view.getRight();
        rect.top = view.getTop();
        rect.bottom = view.getBottom();
        ViewParent parent = view.getParent();
        while ((parent instanceof ViewGroup) && parent != this) {
            ViewGroup viewGroup = (ViewGroup) parent;
            rect.left += viewGroup.getLeft();
            rect.right += viewGroup.getRight();
            rect.top += viewGroup.getTop();
            rect.bottom += viewGroup.getBottom();
            parent = viewGroup.getParent();
        }
        return rect;
    }
}
