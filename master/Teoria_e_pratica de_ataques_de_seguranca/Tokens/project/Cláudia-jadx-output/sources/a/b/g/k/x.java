package a.b.g.k;

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
/* compiled from: ViewPager.java */
/* loaded from: classes.dex */
public class x extends ViewGroup {
    public static final int[] g0 = {16842931};
    public static final Comparator<f> h0 = new a();
    public static final Interpolator i0 = new b();
    public static final n j0 = new n();
    public int A;
    public int B;
    public int C;
    public float D;
    public float E;
    public float F;
    public float G;
    public int H;
    public VelocityTracker I;
    public int J;
    public int K;
    public int L;
    public int M;
    public boolean N;
    public EdgeEffect O;
    public EdgeEffect P;
    public boolean Q;
    public boolean R;
    public int S;
    public List<j> T;
    public j U;
    public j V;
    public List<i> W;

    /* renamed from: a  reason: collision with root package name */
    public int f1147a;
    public k a0;

    /* renamed from: b  reason: collision with root package name */
    public final ArrayList<f> f1148b;
    public int b0;

    /* renamed from: c  reason: collision with root package name */
    public final f f1149c;
    public int c0;

    /* renamed from: d  reason: collision with root package name */
    public final Rect f1150d;
    public ArrayList<View> d0;

    /* renamed from: e  reason: collision with root package name */
    public q f1151e;
    public final Runnable e0;

    /* renamed from: f  reason: collision with root package name */
    public int f1152f;
    public int f0;

    /* renamed from: g  reason: collision with root package name */
    public int f1153g;

    /* renamed from: h  reason: collision with root package name */
    public Parcelable f1154h;

    /* renamed from: i  reason: collision with root package name */
    public ClassLoader f1155i;
    public Scroller j;
    public boolean k;
    public l m;
    public int n;
    public Drawable o;
    public int p;
    public int q;
    public float r;
    public float s;
    public int t;
    public boolean u;
    public boolean v;
    public boolean w;
    public int x;
    public boolean y;
    public boolean z;

    /* compiled from: ViewPager.java */
    /* loaded from: classes.dex */
    public static class a implements Comparator<f> {
        @Override // java.util.Comparator
        /* renamed from: a */
        public int compare(f fVar, f fVar2) {
            return fVar.f1160b - fVar2.f1160b;
        }
    }

    /* compiled from: ViewPager.java */
    /* loaded from: classes.dex */
    public static class b implements Interpolator {
        @Override // android.animation.TimeInterpolator
        public float getInterpolation(float f2) {
            float f3 = f2 - 1.0f;
            return (f3 * f3 * f3 * f3 * f3) + 1.0f;
        }
    }

    /* compiled from: ViewPager.java */
    /* loaded from: classes.dex */
    public class c implements Runnable {
        public c() {
        }

        @Override // java.lang.Runnable
        public void run() {
            x.this.setScrollState(0);
            x.this.g();
        }
    }

    /* compiled from: ViewPager.java */
    /* loaded from: classes.dex */
    public class d implements p {

        /* renamed from: a  reason: collision with root package name */
        public final Rect f1157a = new Rect();

        public d() {
        }

        @Override // a.b.g.k.p
        public d0 a(View view, d0 d0Var) {
            d0 b2 = u.b(view, d0Var);
            if (b2.e()) {
                return b2;
            }
            Rect rect = this.f1157a;
            rect.left = b2.b();
            rect.top = b2.d();
            rect.right = b2.c();
            rect.bottom = b2.a();
            int childCount = x.this.getChildCount();
            for (int i2 = 0; i2 < childCount; i2++) {
                d0 a2 = u.a(x.this.getChildAt(i2), b2);
                rect.left = Math.min(a2.b(), rect.left);
                rect.top = Math.min(a2.d(), rect.top);
                rect.right = Math.min(a2.c(), rect.right);
                rect.bottom = Math.min(a2.a(), rect.bottom);
            }
            return b2.a(rect.left, rect.top, rect.right, rect.bottom);
        }
    }

    /* compiled from: ViewPager.java */
    @Target({ElementType.TYPE})
    @Inherited
    @Retention(RetentionPolicy.RUNTIME)
    /* loaded from: classes.dex */
    public @interface e {
    }

    /* compiled from: ViewPager.java */
    /* loaded from: classes.dex */
    public static class f {

        /* renamed from: a  reason: collision with root package name */
        public Object f1159a;

        /* renamed from: b  reason: collision with root package name */
        public int f1160b;

        /* renamed from: c  reason: collision with root package name */
        public boolean f1161c;

        /* renamed from: d  reason: collision with root package name */
        public float f1162d;

        /* renamed from: e  reason: collision with root package name */
        public float f1163e;
    }

    /* compiled from: ViewPager.java */
    /* loaded from: classes.dex */
    public interface i {
        void a(x xVar, q qVar, q qVar2);
    }

    /* compiled from: ViewPager.java */
    /* loaded from: classes.dex */
    public interface j {
        void a(int i2);

        void a(int i2, float f2, int i3);

        void b(int i2);
    }

    /* compiled from: ViewPager.java */
    /* loaded from: classes.dex */
    public interface k {
        void a(View view, float f2);
    }

    /* compiled from: ViewPager.java */
    /* loaded from: classes.dex */
    public class l extends DataSetObserver {
        public l() {
        }

        @Override // android.database.DataSetObserver
        public void onChanged() {
            x.this.a();
        }

        @Override // android.database.DataSetObserver
        public void onInvalidated() {
            x.this.a();
        }
    }

    /* compiled from: ViewPager.java */
    /* loaded from: classes.dex */
    public static class m extends a.b.g.k.a {
        public static final Parcelable.Creator<m> CREATOR = new a();

        /* renamed from: c  reason: collision with root package name */
        public int f1172c;

        /* renamed from: d  reason: collision with root package name */
        public Parcelable f1173d;

        /* renamed from: e  reason: collision with root package name */
        public ClassLoader f1174e;

        /* compiled from: ViewPager.java */
        /* loaded from: classes.dex */
        public static class a implements Parcelable.ClassLoaderCreator<m> {
            @Override // android.os.Parcelable.Creator
            public m[] newArray(int i2) {
                return new m[i2];
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.ClassLoaderCreator
            public m createFromParcel(Parcel parcel, ClassLoader classLoader) {
                return new m(parcel, classLoader);
            }

            @Override // android.os.Parcelable.Creator
            public m createFromParcel(Parcel parcel) {
                return new m(parcel, null);
            }
        }

        public m(Parcelable parcelable) {
            super(parcelable);
        }

        public String toString() {
            return "FragmentPager.SavedState{" + Integer.toHexString(System.identityHashCode(this)) + " position=" + this.f1172c + "}";
        }

        @Override // a.b.g.k.a, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i2) {
            super.writeToParcel(parcel, i2);
            parcel.writeInt(this.f1172c);
            parcel.writeParcelable(this.f1173d, i2);
        }

        public m(Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            classLoader = classLoader == null ? m.class.getClassLoader() : classLoader;
            this.f1172c = parcel.readInt();
            this.f1173d = parcel.readParcelable(classLoader);
            this.f1174e = classLoader;
        }
    }

    /* compiled from: ViewPager.java */
    /* loaded from: classes.dex */
    public static class n implements Comparator<View> {
        @Override // java.util.Comparator
        /* renamed from: a */
        public int compare(View view, View view2) {
            g gVar = (g) view.getLayoutParams();
            g gVar2 = (g) view2.getLayoutParams();
            boolean z = gVar.f1164a;
            if (z != gVar2.f1164a) {
                return z ? 1 : -1;
            }
            return gVar.f1168e - gVar2.f1168e;
        }
    }

    public x(Context context) {
        super(context);
        this.f1148b = new ArrayList<>();
        this.f1149c = new f();
        this.f1150d = new Rect();
        this.f1153g = -1;
        this.f1154h = null;
        this.f1155i = null;
        this.r = -3.4028235E38f;
        this.s = Float.MAX_VALUE;
        this.x = 1;
        this.H = -1;
        this.Q = true;
        this.e0 = new c();
        this.f0 = 0;
        d();
    }

    public static boolean c(View view) {
        return view.getClass().getAnnotation(e.class) != null;
    }

    private int getClientWidth() {
        return (getMeasuredWidth() - getPaddingLeft()) - getPaddingRight();
    }

    private void setScrollingCacheEnabled(boolean z) {
        if (this.v != z) {
            this.v = z;
        }
    }

    public void a(int i2, boolean z) {
        this.w = false;
        a(i2, z, false);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void addFocusables(ArrayList<View> arrayList, int i2, int i3) {
        f b2;
        int size = arrayList.size();
        int descendantFocusability = getDescendantFocusability();
        if (descendantFocusability != 393216) {
            for (int i4 = 0; i4 < getChildCount(); i4++) {
                View childAt = getChildAt(i4);
                if (childAt.getVisibility() == 0 && (b2 = b(childAt)) != null && b2.f1160b == this.f1152f) {
                    childAt.addFocusables(arrayList, i2, i3);
                }
            }
        }
        if ((descendantFocusability != 262144 || size == arrayList.size()) && isFocusable()) {
            if (((i3 & 1) == 1 && isInTouchMode() && !isFocusableInTouchMode()) || arrayList == null) {
                return;
            }
            arrayList.add(this);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void addTouchables(ArrayList<View> arrayList) {
        f b2;
        for (int i2 = 0; i2 < getChildCount(); i2++) {
            View childAt = getChildAt(i2);
            if (childAt.getVisibility() == 0 && (b2 = b(childAt)) != null && b2.f1160b == this.f1152f) {
                childAt.addTouchables(arrayList);
            }
        }
    }

    @Override // android.view.ViewGroup
    public void addView(View view, int i2, ViewGroup.LayoutParams layoutParams) {
        if (!checkLayoutParams(layoutParams)) {
            layoutParams = generateLayoutParams(layoutParams);
        }
        g gVar = (g) layoutParams;
        gVar.f1164a |= c(view);
        if (this.u) {
            if (gVar != null && gVar.f1164a) {
                throw new IllegalStateException("Cannot add pager decor view during layout");
            }
            gVar.f1167d = true;
            addViewInLayout(view, i2, layoutParams);
            return;
        }
        super.addView(view, i2, layoutParams);
    }

    public f b(View view) {
        for (int i2 = 0; i2 < this.f1148b.size(); i2++) {
            f fVar = this.f1148b.get(i2);
            if (this.f1151e.a(view, fVar.f1159a)) {
                return fVar;
            }
        }
        return null;
    }

    @Override // android.view.View
    public boolean canScrollHorizontally(int i2) {
        if (this.f1151e == null) {
            return false;
        }
        int clientWidth = getClientWidth();
        int scrollX = getScrollX();
        return i2 < 0 ? scrollX > ((int) (((float) clientWidth) * this.r)) : i2 > 0 && scrollX < ((int) (((float) clientWidth) * this.s));
    }

    @Override // android.view.ViewGroup
    public boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return (layoutParams instanceof g) && super.checkLayoutParams(layoutParams);
    }

    @Override // android.view.View
    public void computeScroll() {
        this.k = true;
        if (!this.j.isFinished() && this.j.computeScrollOffset()) {
            int scrollX = getScrollX();
            int scrollY = getScrollY();
            int currX = this.j.getCurrX();
            int currY = this.j.getCurrY();
            if (scrollX != currX || scrollY != currY) {
                scrollTo(currX, currY);
                if (!e(currX)) {
                    this.j.abortAnimation();
                    scrollTo(0, currY);
                }
            }
            u.A(this);
            return;
        }
        a(true);
    }

    public void d() {
        setWillNotDraw(false);
        setDescendantFocusability(262144);
        setFocusable(true);
        Context context = getContext();
        this.j = new Scroller(context, i0);
        ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
        float f2 = context.getResources().getDisplayMetrics().density;
        this.C = viewConfiguration.getScaledPagingTouchSlop();
        this.J = (int) (400.0f * f2);
        this.K = viewConfiguration.getScaledMaximumFlingVelocity();
        this.O = new EdgeEffect(context);
        this.P = new EdgeEffect(context);
        this.L = (int) (25.0f * f2);
        this.M = (int) (2.0f * f2);
        this.A = (int) (f2 * 16.0f);
        u.a(this, new h());
        if (u.i(this) == 0) {
            u.f(this, 1);
        }
        u.a(this, new d());
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        return super.dispatchKeyEvent(keyEvent) || a(keyEvent);
    }

    @Override // android.view.View
    public boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        f b2;
        if (accessibilityEvent.getEventType() == 4096) {
            return super.dispatchPopulateAccessibilityEvent(accessibilityEvent);
        }
        int childCount = getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = getChildAt(i2);
            if (childAt.getVisibility() == 0 && (b2 = b(childAt)) != null && b2.f1160b == this.f1152f && childAt.dispatchPopulateAccessibilityEvent(accessibilityEvent)) {
                return true;
            }
        }
        return false;
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        q qVar;
        super.draw(canvas);
        int overScrollMode = getOverScrollMode();
        boolean z = false;
        if (overScrollMode != 0 && (overScrollMode != 1 || (qVar = this.f1151e) == null || qVar.a() <= 1)) {
            this.O.finish();
            this.P.finish();
        } else {
            if (!this.O.isFinished()) {
                int save = canvas.save();
                int height = (getHeight() - getPaddingTop()) - getPaddingBottom();
                int width = getWidth();
                canvas.rotate(270.0f);
                canvas.translate((-height) + getPaddingTop(), this.r * width);
                this.O.setSize(height, width);
                z = false | this.O.draw(canvas);
                canvas.restoreToCount(save);
            }
            if (!this.P.isFinished()) {
                int save2 = canvas.save();
                int width2 = getWidth();
                int height2 = (getHeight() - getPaddingTop()) - getPaddingBottom();
                canvas.rotate(90.0f);
                canvas.translate(-getPaddingTop(), (-(this.s + 1.0f)) * width2);
                this.P.setSize(height2, width2);
                z |= this.P.draw(canvas);
                canvas.restoreToCount(save2);
            }
        }
        if (z) {
            u.A(this);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void drawableStateChanged() {
        super.drawableStateChanged();
        Drawable drawable = this.o;
        if (drawable == null || !drawable.isStateful()) {
            return;
        }
        drawable.setState(getDrawableState());
    }

    public final boolean e(int i2) {
        if (this.f1148b.size() == 0) {
            if (this.Q) {
                return false;
            }
            this.R = false;
            b(0, 0.0f, 0);
            if (this.R) {
                return false;
            }
            throw new IllegalStateException("onPageScrolled did not call superclass implementation");
        }
        f c2 = c();
        int clientWidth = getClientWidth();
        int i3 = this.n;
        int i4 = clientWidth + i3;
        float f2 = clientWidth;
        int i5 = c2.f1160b;
        float f3 = ((i2 / f2) - c2.f1163e) / (c2.f1162d + (i3 / f2));
        this.R = false;
        b(i5, f3, (int) (i4 * f3));
        if (this.R) {
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
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void f(int r18) {
        /*
            Method dump skipped, instructions count: 617
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: a.b.g.k.x.f(int):void");
    }

    public void g() {
        f(this.f1152f);
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return new g();
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return generateDefaultLayoutParams();
    }

    public q getAdapter() {
        return this.f1151e;
    }

    @Override // android.view.ViewGroup
    public int getChildDrawingOrder(int i2, int i3) {
        if (this.c0 == 2) {
            i3 = (i2 - 1) - i3;
        }
        return ((g) this.d0.get(i3).getLayoutParams()).f1169f;
    }

    public int getCurrentItem() {
        return this.f1152f;
    }

    public int getOffscreenPageLimit() {
        return this.x;
    }

    public int getPageMargin() {
        return this.n;
    }

    public final void h() {
        int i2 = 0;
        while (i2 < getChildCount()) {
            if (!((g) getChildAt(i2).getLayoutParams()).f1164a) {
                removeViewAt(i2);
                i2--;
            }
            i2++;
        }
    }

    public final boolean i() {
        this.H = -1;
        b();
        this.O.onRelease();
        this.P.onRelease();
        return this.O.isFinished() || this.P.isFinished();
    }

    public final void j() {
        if (this.c0 != 0) {
            ArrayList<View> arrayList = this.d0;
            if (arrayList == null) {
                this.d0 = new ArrayList<>();
            } else {
                arrayList.clear();
            }
            int childCount = getChildCount();
            for (int i2 = 0; i2 < childCount; i2++) {
                this.d0.add(getChildAt(i2));
            }
            Collections.sort(this.d0, j0);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.Q = true;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        removeCallbacks(this.e0);
        Scroller scroller = this.j;
        if (scroller != null && !scroller.isFinished()) {
            this.j.abortAnimation();
        }
        super.onDetachedFromWindow();
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        int width;
        float f2;
        float f3;
        super.onDraw(canvas);
        if (this.n <= 0 || this.o == null || this.f1148b.size() <= 0 || this.f1151e == null) {
            return;
        }
        int scrollX = getScrollX();
        float width2 = getWidth();
        float f4 = this.n / width2;
        int i2 = 0;
        f fVar = this.f1148b.get(0);
        float f5 = fVar.f1163e;
        int size = this.f1148b.size();
        int i3 = fVar.f1160b;
        int i4 = this.f1148b.get(size - 1).f1160b;
        while (i3 < i4) {
            while (i3 > fVar.f1160b && i2 < size) {
                i2++;
                fVar = this.f1148b.get(i2);
            }
            if (i3 == fVar.f1160b) {
                float f6 = fVar.f1163e;
                float f7 = fVar.f1162d;
                f2 = (f6 + f7) * width2;
                f5 = f6 + f7 + f4;
            } else {
                float a2 = this.f1151e.a(i3);
                f2 = (f5 + a2) * width2;
                f5 += a2 + f4;
            }
            if (this.n + f2 > scrollX) {
                f3 = f4;
                this.o.setBounds(Math.round(f2), this.p, Math.round(this.n + f2), this.q);
                this.o.draw(canvas);
            } else {
                f3 = f4;
            }
            if (f2 > scrollX + width) {
                return;
            }
            i3++;
            f4 = f3;
        }
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction() & 255;
        if (action != 3 && action != 1) {
            if (action != 0) {
                if (this.y) {
                    return true;
                }
                if (this.z) {
                    return false;
                }
            }
            if (action == 0) {
                float x = motionEvent.getX();
                this.F = x;
                this.D = x;
                float y = motionEvent.getY();
                this.G = y;
                this.E = y;
                this.H = motionEvent.getPointerId(0);
                this.z = false;
                this.k = true;
                this.j.computeScrollOffset();
                if (this.f0 == 2 && Math.abs(this.j.getFinalX() - this.j.getCurrX()) > this.M) {
                    this.j.abortAnimation();
                    this.w = false;
                    g();
                    this.y = true;
                    c(true);
                    setScrollState(1);
                } else {
                    a(false);
                    this.y = false;
                }
            } else if (action == 2) {
                int i2 = this.H;
                if (i2 != -1) {
                    int findPointerIndex = motionEvent.findPointerIndex(i2);
                    float x2 = motionEvent.getX(findPointerIndex);
                    float f2 = x2 - this.D;
                    float abs = Math.abs(f2);
                    float y2 = motionEvent.getY(findPointerIndex);
                    float abs2 = Math.abs(y2 - this.G);
                    int i3 = (f2 > 0.0f ? 1 : (f2 == 0.0f ? 0 : -1));
                    if (i3 != 0 && !a(this.D, f2) && a(this, false, (int) f2, (int) x2, (int) y2)) {
                        this.D = x2;
                        this.E = y2;
                        this.z = true;
                        return false;
                    }
                    if (abs > this.C && abs * 0.5f > abs2) {
                        this.y = true;
                        c(true);
                        setScrollState(1);
                        float f3 = this.F;
                        float f4 = this.C;
                        this.D = i3 > 0 ? f3 + f4 : f3 - f4;
                        this.E = y2;
                        setScrollingCacheEnabled(true);
                    } else if (abs2 > this.C) {
                        this.z = true;
                    }
                    if (this.y && b(x2)) {
                        u.A(this);
                    }
                }
            } else if (action == 6) {
                a(motionEvent);
            }
            if (this.I == null) {
                this.I = VelocityTracker.obtain();
            }
            this.I.addMovement(motionEvent);
            return this.y;
        }
        i();
        return false;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        boolean z2;
        f b2;
        int max;
        int max2;
        int childCount = getChildCount();
        int i6 = i4 - i2;
        int i7 = i5 - i3;
        int paddingLeft = getPaddingLeft();
        int paddingTop = getPaddingTop();
        int paddingRight = getPaddingRight();
        int paddingBottom = getPaddingBottom();
        int scrollX = getScrollX();
        int i8 = paddingBottom;
        int i9 = 0;
        int i10 = paddingTop;
        int i11 = paddingLeft;
        for (int i12 = 0; i12 < childCount; i12++) {
            View childAt = getChildAt(i12);
            if (childAt.getVisibility() != 8) {
                g gVar = (g) childAt.getLayoutParams();
                if (gVar.f1164a) {
                    int i13 = gVar.f1165b;
                    int i14 = i13 & 7;
                    int i15 = i13 & 112;
                    if (i14 == 1) {
                        max = Math.max((i6 - childAt.getMeasuredWidth()) / 2, i11);
                    } else if (i14 == 3) {
                        max = i11;
                        i11 = childAt.getMeasuredWidth() + i11;
                    } else if (i14 != 5) {
                        max = i11;
                    } else {
                        max = (i6 - paddingRight) - childAt.getMeasuredWidth();
                        paddingRight += childAt.getMeasuredWidth();
                    }
                    if (i15 == 16) {
                        max2 = Math.max((i7 - childAt.getMeasuredHeight()) / 2, i10);
                    } else if (i15 == 48) {
                        max2 = i10;
                        i10 = childAt.getMeasuredHeight() + i10;
                    } else if (i15 != 80) {
                        max2 = i10;
                    } else {
                        max2 = (i7 - i8) - childAt.getMeasuredHeight();
                        i8 += childAt.getMeasuredHeight();
                    }
                    int i16 = max + scrollX;
                    childAt.layout(i16, max2, childAt.getMeasuredWidth() + i16, max2 + childAt.getMeasuredHeight());
                    i9++;
                }
            }
        }
        int i17 = (i6 - i11) - paddingRight;
        for (int i18 = 0; i18 < childCount; i18++) {
            View childAt2 = getChildAt(i18);
            if (childAt2.getVisibility() != 8) {
                g gVar2 = (g) childAt2.getLayoutParams();
                if (!gVar2.f1164a && (b2 = b(childAt2)) != null) {
                    float f2 = i17;
                    int i19 = ((int) (b2.f1163e * f2)) + i11;
                    if (gVar2.f1167d) {
                        gVar2.f1167d = false;
                        childAt2.measure(View.MeasureSpec.makeMeasureSpec((int) (f2 * gVar2.f1166c), 1073741824), View.MeasureSpec.makeMeasureSpec((i7 - i10) - i8, 1073741824));
                    }
                    childAt2.layout(i19, i10, childAt2.getMeasuredWidth() + i19, childAt2.getMeasuredHeight() + i10);
                }
            }
        }
        this.p = i10;
        this.q = i7 - i8;
        this.S = i9;
        if (this.Q) {
            z2 = false;
            a(this.f1152f, false, 0, false);
        } else {
            z2 = false;
        }
        this.Q = z2;
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
        To view partially-correct add '--show-bad-code' argument
    */
    public void onMeasure(int r14, int r15) {
        /*
            Method dump skipped, instructions count: 243
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: a.b.g.k.x.onMeasure(int, int):void");
    }

    @Override // android.view.ViewGroup
    public boolean onRequestFocusInDescendants(int i2, Rect rect) {
        int i3;
        int i4;
        f b2;
        int childCount = getChildCount();
        int i5 = -1;
        if ((i2 & 2) != 0) {
            i5 = childCount;
            i3 = 0;
            i4 = 1;
        } else {
            i3 = childCount - 1;
            i4 = -1;
        }
        while (i3 != i5) {
            View childAt = getChildAt(i3);
            if (childAt.getVisibility() == 0 && (b2 = b(childAt)) != null && b2.f1160b == this.f1152f && childAt.requestFocus(i2, rect)) {
                return true;
            }
            i3 += i4;
        }
        return false;
    }

    @Override // android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof m)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        m mVar = (m) parcelable;
        super.onRestoreInstanceState(mVar.a());
        q qVar = this.f1151e;
        if (qVar != null) {
            qVar.a(mVar.f1173d, mVar.f1174e);
            a(mVar.f1172c, false, true);
            return;
        }
        this.f1153g = mVar.f1172c;
        this.f1154h = mVar.f1173d;
        this.f1155i = mVar.f1174e;
    }

    @Override // android.view.View
    public Parcelable onSaveInstanceState() {
        m mVar = new m(super.onSaveInstanceState());
        mVar.f1172c = this.f1152f;
        q qVar = this.f1151e;
        if (qVar != null) {
            mVar.f1173d = qVar.b();
        }
        return mVar;
    }

    @Override // android.view.View
    public void onSizeChanged(int i2, int i3, int i4, int i5) {
        super.onSizeChanged(i2, i3, i4, i5);
        if (i2 != i4) {
            int i6 = this.n;
            a(i2, i4, i6, i6);
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        q qVar;
        if (this.N) {
            return true;
        }
        boolean z = false;
        if ((motionEvent.getAction() == 0 && motionEvent.getEdgeFlags() != 0) || (qVar = this.f1151e) == null || qVar.a() == 0) {
            return false;
        }
        if (this.I == null) {
            this.I = VelocityTracker.obtain();
        }
        this.I.addMovement(motionEvent);
        int action = motionEvent.getAction() & 255;
        if (action == 0) {
            this.j.abortAnimation();
            this.w = false;
            g();
            float x = motionEvent.getX();
            this.F = x;
            this.D = x;
            float y = motionEvent.getY();
            this.G = y;
            this.E = y;
            this.H = motionEvent.getPointerId(0);
        } else if (action != 1) {
            if (action == 2) {
                if (!this.y) {
                    int findPointerIndex = motionEvent.findPointerIndex(this.H);
                    if (findPointerIndex == -1) {
                        z = i();
                    } else {
                        float x2 = motionEvent.getX(findPointerIndex);
                        float abs = Math.abs(x2 - this.D);
                        float y2 = motionEvent.getY(findPointerIndex);
                        float abs2 = Math.abs(y2 - this.E);
                        if (abs > this.C && abs > abs2) {
                            this.y = true;
                            c(true);
                            float f2 = this.F;
                            this.D = x2 - f2 > 0.0f ? f2 + this.C : f2 - this.C;
                            this.E = y2;
                            setScrollState(1);
                            setScrollingCacheEnabled(true);
                            ViewParent parent = getParent();
                            if (parent != null) {
                                parent.requestDisallowInterceptTouchEvent(true);
                            }
                        }
                    }
                }
                if (this.y) {
                    z = false | b(motionEvent.getX(motionEvent.findPointerIndex(this.H)));
                }
            } else if (action != 3) {
                if (action == 5) {
                    int actionIndex = motionEvent.getActionIndex();
                    this.D = motionEvent.getX(actionIndex);
                    this.H = motionEvent.getPointerId(actionIndex);
                } else if (action == 6) {
                    a(motionEvent);
                    this.D = motionEvent.getX(motionEvent.findPointerIndex(this.H));
                }
            } else if (this.y) {
                a(this.f1152f, true, 0, false);
                z = i();
            }
        } else if (this.y) {
            VelocityTracker velocityTracker = this.I;
            velocityTracker.computeCurrentVelocity(1000, this.K);
            int xVelocity = (int) velocityTracker.getXVelocity(this.H);
            this.w = true;
            int clientWidth = getClientWidth();
            int scrollX = getScrollX();
            f c2 = c();
            float f3 = clientWidth;
            a(a(c2.f1160b, ((scrollX / f3) - c2.f1163e) / (c2.f1162d + (this.n / f3)), xVelocity, (int) (motionEvent.getX(motionEvent.findPointerIndex(this.H)) - this.F)), true, true, xVelocity);
            z = i();
        }
        if (z) {
            u.A(this);
        }
        return true;
    }

    @Override // android.view.ViewGroup, android.view.ViewManager
    public void removeView(View view) {
        if (this.u) {
            removeViewInLayout(view);
        } else {
            super.removeView(view);
        }
    }

    public void setAdapter(q qVar) {
        q qVar2 = this.f1151e;
        if (qVar2 != null) {
            qVar2.a((DataSetObserver) null);
            this.f1151e.b(this);
            for (int i2 = 0; i2 < this.f1148b.size(); i2++) {
                f fVar = this.f1148b.get(i2);
                this.f1151e.a(this, fVar.f1160b, fVar.f1159a);
            }
            this.f1151e.a((ViewGroup) this);
            this.f1148b.clear();
            h();
            this.f1152f = 0;
            scrollTo(0, 0);
        }
        q qVar3 = this.f1151e;
        this.f1151e = qVar;
        this.f1147a = 0;
        if (this.f1151e != null) {
            if (this.m == null) {
                this.m = new l();
            }
            this.f1151e.a((DataSetObserver) this.m);
            this.w = false;
            boolean z = this.Q;
            this.Q = true;
            this.f1147a = this.f1151e.a();
            if (this.f1153g >= 0) {
                this.f1151e.a(this.f1154h, this.f1155i);
                a(this.f1153g, false, true);
                this.f1153g = -1;
                this.f1154h = null;
                this.f1155i = null;
            } else if (!z) {
                g();
            } else {
                requestLayout();
            }
        }
        List<i> list = this.W;
        if (list == null || list.isEmpty()) {
            return;
        }
        int size = this.W.size();
        for (int i3 = 0; i3 < size; i3++) {
            this.W.get(i3).a(this, qVar3, qVar);
        }
    }

    public void setCurrentItem(int i2) {
        this.w = false;
        a(i2, !this.Q, false);
    }

    public void setOffscreenPageLimit(int i2) {
        if (i2 < 1) {
            Log.w("ViewPager", "Requested offscreen page limit " + i2 + " too small; defaulting to 1");
            i2 = 1;
        }
        if (i2 != this.x) {
            this.x = i2;
            g();
        }
    }

    @Deprecated
    public void setOnPageChangeListener(j jVar) {
        this.U = jVar;
    }

    public void setPageMargin(int i2) {
        int i3 = this.n;
        this.n = i2;
        int width = getWidth();
        a(width, width, i2, i3);
        requestLayout();
    }

    public void setPageMarginDrawable(Drawable drawable) {
        this.o = drawable;
        if (drawable != null) {
            refreshDrawableState();
        }
        setWillNotDraw(drawable == null);
        invalidate();
    }

    public void setScrollState(int i2) {
        if (this.f0 == i2) {
            return;
        }
        this.f0 = i2;
        if (this.a0 != null) {
            b(i2 != 0);
        }
        c(i2);
    }

    @Override // android.view.View
    public boolean verifyDrawable(Drawable drawable) {
        return super.verifyDrawable(drawable) || drawable == this.o;
    }

    /* compiled from: ViewPager.java */
    /* loaded from: classes.dex */
    public static class g extends ViewGroup.LayoutParams {

        /* renamed from: a  reason: collision with root package name */
        public boolean f1164a;

        /* renamed from: b  reason: collision with root package name */
        public int f1165b;

        /* renamed from: c  reason: collision with root package name */
        public float f1166c;

        /* renamed from: d  reason: collision with root package name */
        public boolean f1167d;

        /* renamed from: e  reason: collision with root package name */
        public int f1168e;

        /* renamed from: f  reason: collision with root package name */
        public int f1169f;

        public g() {
            super(-1, -1);
            this.f1166c = 0.0f;
        }

        public g(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            this.f1166c = 0.0f;
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, x.g0);
            this.f1165b = obtainStyledAttributes.getInteger(0, 48);
            obtainStyledAttributes.recycle();
        }
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new g(getContext(), attributeSet);
    }

    public void a(int i2, boolean z, boolean z2) {
        a(i2, z, z2, 0);
    }

    public final void c(int i2) {
        j jVar = this.U;
        if (jVar != null) {
            jVar.a(i2);
        }
        List<j> list = this.T;
        if (list != null) {
            int size = list.size();
            for (int i3 = 0; i3 < size; i3++) {
                j jVar2 = this.T.get(i3);
                if (jVar2 != null) {
                    jVar2.a(i2);
                }
            }
        }
        j jVar3 = this.V;
        if (jVar3 != null) {
            jVar3.a(i2);
        }
    }

    public void a(int i2, boolean z, boolean z2, int i3) {
        q qVar = this.f1151e;
        if (qVar != null && qVar.a() > 0) {
            if (!z2 && this.f1152f == i2 && this.f1148b.size() != 0) {
                setScrollingCacheEnabled(false);
                return;
            }
            if (i2 < 0) {
                i2 = 0;
            } else if (i2 >= this.f1151e.a()) {
                i2 = this.f1151e.a() - 1;
            }
            int i4 = this.x;
            int i5 = this.f1152f;
            if (i2 > i5 + i4 || i2 < i5 - i4) {
                for (int i6 = 0; i6 < this.f1148b.size(); i6++) {
                    this.f1148b.get(i6).f1161c = true;
                }
            }
            boolean z3 = this.f1152f != i2;
            if (this.Q) {
                this.f1152f = i2;
                if (z3) {
                    b(i2);
                }
                requestLayout();
                return;
            }
            f(i2);
            a(i2, z, i3, z3);
            return;
        }
        setScrollingCacheEnabled(false);
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x0066  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void b(int r13, float r14, int r15) {
        /*
            r12 = this;
            int r0 = r12.S
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
            a.b.g.k.x$g r9 = (a.b.g.k.x.g) r9
            boolean r10 = r9.f1164a
            if (r10 != 0) goto L2e
            goto L6a
        L2e:
            int r9 = r9.f1165b
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
            r12.a(r13, r14, r15)
            a.b.g.k.x$k r13 = r12.a0
            if (r13 == 0) goto La1
            int r13 = r12.getScrollX()
            int r14 = r12.getChildCount()
        L7c:
            if (r1 >= r14) goto La1
            android.view.View r15 = r12.getChildAt(r1)
            android.view.ViewGroup$LayoutParams r0 = r15.getLayoutParams()
            a.b.g.k.x$g r0 = (a.b.g.k.x.g) r0
            boolean r0 = r0.f1164a
            if (r0 == 0) goto L8d
            goto L9e
        L8d:
            int r0 = r15.getLeft()
            int r0 = r0 - r13
            float r0 = (float) r0
            int r3 = r12.getClientWidth()
            float r3 = (float) r3
            float r0 = r0 / r3
            a.b.g.k.x$k r3 = r12.a0
            r3.a(r15, r0)
        L9e:
            int r1 = r1 + 1
            goto L7c
        La1:
            r12.R = r2
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: a.b.g.k.x.b(int, float, int):void");
    }

    public void setPageMarginDrawable(int i2) {
        setPageMarginDrawable(a.b.g.b.b.c(getContext(), i2));
    }

    /* compiled from: ViewPager.java */
    /* loaded from: classes.dex */
    public class h extends a.b.g.k.b {
        public h() {
        }

        @Override // a.b.g.k.b
        public void a(View view, a.b.g.k.e0.c cVar) {
            super.a(view, cVar);
            cVar.a((CharSequence) x.class.getName());
            cVar.e(b());
            if (x.this.canScrollHorizontally(1)) {
                cVar.a(4096);
            }
            if (x.this.canScrollHorizontally(-1)) {
                cVar.a(8192);
            }
        }

        @Override // a.b.g.k.b
        public void b(View view, AccessibilityEvent accessibilityEvent) {
            q qVar;
            super.b(view, accessibilityEvent);
            accessibilityEvent.setClassName(x.class.getName());
            accessibilityEvent.setScrollable(b());
            if (accessibilityEvent.getEventType() != 4096 || (qVar = x.this.f1151e) == null) {
                return;
            }
            accessibilityEvent.setItemCount(qVar.a());
            accessibilityEvent.setFromIndex(x.this.f1152f);
            accessibilityEvent.setToIndex(x.this.f1152f);
        }

        @Override // a.b.g.k.b
        public boolean a(View view, int i2, Bundle bundle) {
            if (super.a(view, i2, bundle)) {
                return true;
            }
            if (i2 != 4096) {
                if (i2 == 8192 && x.this.canScrollHorizontally(-1)) {
                    x xVar = x.this;
                    xVar.setCurrentItem(xVar.f1152f - 1);
                    return true;
                }
                return false;
            } else if (x.this.canScrollHorizontally(1)) {
                x xVar2 = x.this;
                xVar2.setCurrentItem(xVar2.f1152f + 1);
                return true;
            } else {
                return false;
            }
        }

        public final boolean b() {
            q qVar = x.this.f1151e;
            return qVar != null && qVar.a() > 1;
        }
    }

    public final void c(boolean z) {
        ViewParent parent = getParent();
        if (parent != null) {
            parent.requestDisallowInterceptTouchEvent(z);
        }
    }

    public final f c() {
        int i2;
        int clientWidth = getClientWidth();
        float scrollX = clientWidth > 0 ? getScrollX() / clientWidth : 0.0f;
        float f2 = clientWidth > 0 ? this.n / clientWidth : 0.0f;
        f fVar = null;
        int i3 = 0;
        boolean z = true;
        int i4 = -1;
        float f3 = 0.0f;
        float f4 = 0.0f;
        while (i3 < this.f1148b.size()) {
            f fVar2 = this.f1148b.get(i3);
            if (!z && fVar2.f1160b != (i2 = i4 + 1)) {
                fVar2 = this.f1149c;
                fVar2.f1163e = f3 + f4 + f2;
                fVar2.f1160b = i2;
                fVar2.f1162d = this.f1151e.a(fVar2.f1160b);
                i3--;
            }
            f3 = fVar2.f1163e;
            float f5 = fVar2.f1162d + f3 + f2;
            if (!z && scrollX < f3) {
                return fVar;
            }
            if (scrollX < f5 || i3 == this.f1148b.size() - 1) {
                return fVar2;
            }
            i4 = fVar2.f1160b;
            f4 = fVar2.f1162d;
            i3++;
            fVar = fVar2;
            z = false;
        }
        return fVar;
    }

    public x(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f1148b = new ArrayList<>();
        this.f1149c = new f();
        this.f1150d = new Rect();
        this.f1153g = -1;
        this.f1154h = null;
        this.f1155i = null;
        this.r = -3.4028235E38f;
        this.s = Float.MAX_VALUE;
        this.x = 1;
        this.H = -1;
        this.Q = true;
        this.e0 = new c();
        this.f0 = 0;
        d();
    }

    public boolean e() {
        int i2 = this.f1152f;
        if (i2 > 0) {
            a(i2 - 1, true);
            return true;
        }
        return false;
    }

    public f d(int i2) {
        for (int i3 = 0; i3 < this.f1148b.size(); i3++) {
            f fVar = this.f1148b.get(i3);
            if (fVar.f1160b == i2) {
                return fVar;
            }
        }
        return null;
    }

    public final void a(int i2, boolean z, int i3, boolean z2) {
        f d2 = d(i2);
        int clientWidth = d2 != null ? (int) (getClientWidth() * Math.max(this.r, Math.min(d2.f1163e, this.s))) : 0;
        if (z) {
            a(clientWidth, 0, i3);
            if (z2) {
                b(i2);
                return;
            }
            return;
        }
        if (z2) {
            b(i2);
        }
        a(false);
        scrollTo(clientWidth, 0);
        e(clientWidth);
    }

    public final void b(int i2) {
        j jVar = this.U;
        if (jVar != null) {
            jVar.b(i2);
        }
        List<j> list = this.T;
        if (list != null) {
            int size = list.size();
            for (int i3 = 0; i3 < size; i3++) {
                j jVar2 = this.T.get(i3);
                if (jVar2 != null) {
                    jVar2.b(i2);
                }
            }
        }
        j jVar3 = this.V;
        if (jVar3 != null) {
            jVar3.b(i2);
        }
    }

    public float a(float f2) {
        return (float) Math.sin((f2 - 0.5f) * 0.47123894f);
    }

    public void a(int i2, int i3, int i4) {
        int scrollX;
        int abs;
        if (getChildCount() == 0) {
            setScrollingCacheEnabled(false);
            return;
        }
        Scroller scroller = this.j;
        if ((scroller == null || scroller.isFinished()) ? false : true) {
            scrollX = this.k ? this.j.getCurrX() : this.j.getStartX();
            this.j.abortAnimation();
            setScrollingCacheEnabled(false);
        } else {
            scrollX = getScrollX();
        }
        int i5 = scrollX;
        int scrollY = getScrollY();
        int i6 = i2 - i5;
        int i7 = i3 - scrollY;
        if (i6 == 0 && i7 == 0) {
            a(false);
            g();
            setScrollState(0);
            return;
        }
        setScrollingCacheEnabled(true);
        setScrollState(2);
        int clientWidth = getClientWidth();
        int i8 = clientWidth / 2;
        float f2 = clientWidth;
        float f3 = i8;
        float a2 = f3 + (a(Math.min(1.0f, (Math.abs(i6) * 1.0f) / f2)) * f3);
        int abs2 = Math.abs(i4);
        if (abs2 > 0) {
            abs = Math.round(Math.abs(a2 / abs2) * 1000.0f) * 4;
        } else {
            abs = (int) (((Math.abs(i6) / ((f2 * this.f1151e.a(this.f1152f)) + this.n)) + 1.0f) * 100.0f);
        }
        int min = Math.min(abs, 600);
        this.k = false;
        this.j.startScroll(i5, scrollY, i6, i7, min);
        u.A(this);
    }

    public final void b(boolean z) {
        int childCount = getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            getChildAt(i2).setLayerType(z ? this.b0 : 0, null);
        }
    }

    public final boolean b(float f2) {
        boolean z;
        boolean z2;
        float f3 = this.D - f2;
        this.D = f2;
        float scrollX = getScrollX() + f3;
        float clientWidth = getClientWidth();
        float f4 = this.r * clientWidth;
        float f5 = this.s * clientWidth;
        boolean z3 = false;
        f fVar = this.f1148b.get(0);
        ArrayList<f> arrayList = this.f1148b;
        f fVar2 = arrayList.get(arrayList.size() - 1);
        if (fVar.f1160b != 0) {
            f4 = fVar.f1163e * clientWidth;
            z = false;
        } else {
            z = true;
        }
        if (fVar2.f1160b != this.f1151e.a() - 1) {
            f5 = fVar2.f1163e * clientWidth;
            z2 = false;
        } else {
            z2 = true;
        }
        if (scrollX < f4) {
            if (z) {
                this.O.onPull(Math.abs(f4 - scrollX) / clientWidth);
                z3 = true;
            }
            scrollX = f4;
        } else if (scrollX > f5) {
            if (z2) {
                this.P.onPull(Math.abs(scrollX - f5) / clientWidth);
                z3 = true;
            }
            scrollX = f5;
        }
        int i2 = (int) scrollX;
        this.D += scrollX - i2;
        scrollTo(i2, getScrollY());
        e(i2);
        return z3;
    }

    public f a(int i2, int i3) {
        f fVar = new f();
        fVar.f1160b = i2;
        fVar.f1159a = this.f1151e.a(this, i2);
        fVar.f1162d = this.f1151e.a(i2);
        if (i3 >= 0 && i3 < this.f1148b.size()) {
            this.f1148b.add(i3, fVar);
        } else {
            this.f1148b.add(fVar);
        }
        return fVar;
    }

    public final void b() {
        this.y = false;
        this.z = false;
        VelocityTracker velocityTracker = this.I;
        if (velocityTracker != null) {
            velocityTracker.recycle();
            this.I = null;
        }
    }

    public void a() {
        int a2 = this.f1151e.a();
        this.f1147a = a2;
        boolean z = this.f1148b.size() < (this.x * 2) + 1 && this.f1148b.size() < a2;
        int i2 = this.f1152f;
        int i3 = 0;
        boolean z2 = false;
        while (i3 < this.f1148b.size()) {
            f fVar = this.f1148b.get(i3);
            int a3 = this.f1151e.a(fVar.f1159a);
            if (a3 != -1) {
                if (a3 == -2) {
                    this.f1148b.remove(i3);
                    i3--;
                    if (!z2) {
                        this.f1151e.b(this);
                        z2 = true;
                    }
                    this.f1151e.a(this, fVar.f1160b, fVar.f1159a);
                    int i4 = this.f1152f;
                    if (i4 == fVar.f1160b) {
                        i2 = Math.max(0, Math.min(i4, a2 - 1));
                    }
                } else {
                    int i5 = fVar.f1160b;
                    if (i5 != a3) {
                        if (i5 == this.f1152f) {
                            i2 = a3;
                        }
                        fVar.f1160b = a3;
                    }
                }
                z = true;
            }
            i3++;
        }
        if (z2) {
            this.f1151e.a((ViewGroup) this);
        }
        Collections.sort(this.f1148b, h0);
        if (z) {
            int childCount = getChildCount();
            for (int i6 = 0; i6 < childCount; i6++) {
                g gVar = (g) getChildAt(i6).getLayoutParams();
                if (!gVar.f1164a) {
                    gVar.f1166c = 0.0f;
                }
            }
            a(i2, false, true);
            requestLayout();
        }
    }

    public boolean f() {
        q qVar = this.f1151e;
        if (qVar == null || this.f1152f >= qVar.a() - 1) {
            return false;
        }
        a(this.f1152f + 1, true);
        return true;
    }

    public final void a(f fVar, int i2, f fVar2) {
        int i3;
        int i4;
        f fVar3;
        f fVar4;
        int a2 = this.f1151e.a();
        int clientWidth = getClientWidth();
        float f2 = clientWidth > 0 ? this.n / clientWidth : 0.0f;
        if (fVar2 != null) {
            int i5 = fVar2.f1160b;
            int i6 = fVar.f1160b;
            if (i5 < i6) {
                int i7 = 0;
                float f3 = fVar2.f1163e + fVar2.f1162d + f2;
                while (true) {
                    i5++;
                    if (i5 > fVar.f1160b || i7 >= this.f1148b.size()) {
                        break;
                    }
                    f fVar5 = this.f1148b.get(i7);
                    while (true) {
                        fVar4 = fVar5;
                        if (i5 <= fVar4.f1160b || i7 >= this.f1148b.size() - 1) {
                            break;
                        }
                        i7++;
                        fVar5 = this.f1148b.get(i7);
                    }
                    while (i5 < fVar4.f1160b) {
                        f3 += this.f1151e.a(i5) + f2;
                        i5++;
                    }
                    fVar4.f1163e = f3;
                    f3 += fVar4.f1162d + f2;
                }
            } else if (i5 > i6) {
                int size = this.f1148b.size() - 1;
                float f4 = fVar2.f1163e;
                while (true) {
                    i5--;
                    if (i5 < fVar.f1160b || size < 0) {
                        break;
                    }
                    f fVar6 = this.f1148b.get(size);
                    while (true) {
                        fVar3 = fVar6;
                        if (i5 >= fVar3.f1160b || size <= 0) {
                            break;
                        }
                        size--;
                        fVar6 = this.f1148b.get(size);
                    }
                    while (i5 > fVar3.f1160b) {
                        f4 -= this.f1151e.a(i5) + f2;
                        i5--;
                    }
                    f4 -= fVar3.f1162d + f2;
                    fVar3.f1163e = f4;
                }
            }
        }
        int size2 = this.f1148b.size();
        float f5 = fVar.f1163e;
        int i8 = fVar.f1160b;
        int i9 = i8 - 1;
        this.r = i8 == 0 ? f5 : -3.4028235E38f;
        int i10 = a2 - 1;
        this.s = fVar.f1160b == i10 ? (fVar.f1163e + fVar.f1162d) - 1.0f : Float.MAX_VALUE;
        int i11 = i2 - 1;
        while (i11 >= 0) {
            f fVar7 = this.f1148b.get(i11);
            while (true) {
                i4 = fVar7.f1160b;
                if (i9 <= i4) {
                    break;
                }
                f5 -= this.f1151e.a(i9) + f2;
                i9--;
            }
            f5 -= fVar7.f1162d + f2;
            fVar7.f1163e = f5;
            if (i4 == 0) {
                this.r = f5;
            }
            i11--;
            i9--;
        }
        float f6 = fVar.f1163e + fVar.f1162d + f2;
        int i12 = fVar.f1160b + 1;
        int i13 = i2 + 1;
        while (i13 < size2) {
            f fVar8 = this.f1148b.get(i13);
            while (true) {
                i3 = fVar8.f1160b;
                if (i12 >= i3) {
                    break;
                }
                f6 += this.f1151e.a(i12) + f2;
                i12++;
            }
            if (i3 == i10) {
                this.s = (fVar8.f1162d + f6) - 1.0f;
            }
            fVar8.f1163e = f6;
            f6 += fVar8.f1162d + f2;
            i13++;
            i12++;
        }
    }

    public f a(View view) {
        while (true) {
            ViewParent parent = view.getParent();
            if (parent != this) {
                if (parent == null || !(parent instanceof View)) {
                    return null;
                }
                view = (View) parent;
            } else {
                return b(view);
            }
        }
    }

    public final void a(int i2, int i3, int i4, int i5) {
        if (i3 > 0 && !this.f1148b.isEmpty()) {
            if (!this.j.isFinished()) {
                this.j.setFinalX(getCurrentItem() * getClientWidth());
                return;
            } else {
                scrollTo((int) ((getScrollX() / (((i3 - getPaddingLeft()) - getPaddingRight()) + i5)) * (((i2 - getPaddingLeft()) - getPaddingRight()) + i4)), getScrollY());
                return;
            }
        }
        f d2 = d(this.f1152f);
        int min = (int) ((d2 != null ? Math.min(d2.f1163e, this.s) : 0.0f) * ((i2 - getPaddingLeft()) - getPaddingRight()));
        if (min != getScrollX()) {
            a(false);
            scrollTo(min, getScrollY());
        }
    }

    public final void a(int i2, float f2, int i3) {
        j jVar = this.U;
        if (jVar != null) {
            jVar.a(i2, f2, i3);
        }
        List<j> list = this.T;
        if (list != null) {
            int size = list.size();
            for (int i4 = 0; i4 < size; i4++) {
                j jVar2 = this.T.get(i4);
                if (jVar2 != null) {
                    jVar2.a(i2, f2, i3);
                }
            }
        }
        j jVar3 = this.V;
        if (jVar3 != null) {
            jVar3.a(i2, f2, i3);
        }
    }

    public final void a(boolean z) {
        boolean z2 = this.f0 == 2;
        if (z2) {
            setScrollingCacheEnabled(false);
            if (!this.j.isFinished()) {
                this.j.abortAnimation();
                int scrollX = getScrollX();
                int scrollY = getScrollY();
                int currX = this.j.getCurrX();
                int currY = this.j.getCurrY();
                if (scrollX != currX || scrollY != currY) {
                    scrollTo(currX, currY);
                    if (currX != scrollX) {
                        e(currX);
                    }
                }
            }
        }
        this.w = false;
        boolean z3 = z2;
        for (int i2 = 0; i2 < this.f1148b.size(); i2++) {
            f fVar = this.f1148b.get(i2);
            if (fVar.f1161c) {
                fVar.f1161c = false;
                z3 = true;
            }
        }
        if (z3) {
            if (z) {
                u.a(this, this.e0);
            } else {
                this.e0.run();
            }
        }
    }

    public final boolean a(float f2, float f3) {
        return (f2 < ((float) this.B) && f3 > 0.0f) || (f2 > ((float) (getWidth() - this.B)) && f3 < 0.0f);
    }

    public final int a(int i2, float f2, int i3, int i4) {
        if (Math.abs(i4) <= this.L || Math.abs(i3) <= this.J) {
            i2 += (int) (f2 + (i2 >= this.f1152f ? 0.4f : 0.6f));
        } else if (i3 <= 0) {
            i2++;
        }
        if (this.f1148b.size() > 0) {
            ArrayList<f> arrayList = this.f1148b;
            return Math.max(this.f1148b.get(0).f1160b, Math.min(i2, arrayList.get(arrayList.size() - 1).f1160b));
        }
        return i2;
    }

    public final void a(MotionEvent motionEvent) {
        int actionIndex = motionEvent.getActionIndex();
        if (motionEvent.getPointerId(actionIndex) == this.H) {
            int i2 = actionIndex == 0 ? 1 : 0;
            this.D = motionEvent.getX(i2);
            this.H = motionEvent.getPointerId(i2);
            VelocityTracker velocityTracker = this.I;
            if (velocityTracker != null) {
                velocityTracker.clear();
            }
        }
    }

    public boolean a(View view, boolean z, int i2, int i3, int i4) {
        int i5;
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            int scrollX = view.getScrollX();
            int scrollY = view.getScrollY();
            for (int childCount = viewGroup.getChildCount() - 1; childCount >= 0; childCount--) {
                View childAt = viewGroup.getChildAt(childCount);
                int i6 = i3 + scrollX;
                if (i6 >= childAt.getLeft() && i6 < childAt.getRight() && (i5 = i4 + scrollY) >= childAt.getTop() && i5 < childAt.getBottom() && a(childAt, true, i2, i6 - childAt.getLeft(), i5 - childAt.getTop())) {
                    return true;
                }
            }
        }
        return z && view.canScrollHorizontally(-i2);
    }

    public boolean a(KeyEvent keyEvent) {
        if (keyEvent.getAction() == 0) {
            int keyCode = keyEvent.getKeyCode();
            if (keyCode == 21) {
                if (keyEvent.hasModifiers(2)) {
                    return e();
                }
                return a(17);
            } else if (keyCode == 22) {
                if (keyEvent.hasModifiers(2)) {
                    return f();
                }
                return a(66);
            } else if (keyCode == 61) {
                if (keyEvent.hasNoModifiers()) {
                    return a(2);
                }
                if (keyEvent.hasModifiers(1)) {
                    return a(1);
                }
            }
        }
        return false;
    }

    public boolean a(int i2) {
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
        View findNextFocus = FocusFinder.getInstance().findNextFocus(this, view, i2);
        if (findNextFocus != null && findNextFocus != view) {
            if (i2 == 17) {
                int i3 = a(this.f1150d, findNextFocus).left;
                int i4 = a(this.f1150d, view).left;
                if (view != null && i3 >= i4) {
                    requestFocus = e();
                } else {
                    requestFocus = findNextFocus.requestFocus();
                }
            } else if (i2 == 66) {
                int i5 = a(this.f1150d, findNextFocus).left;
                int i6 = a(this.f1150d, view).left;
                if (view != null && i5 <= i6) {
                    requestFocus = f();
                } else {
                    requestFocus = findNextFocus.requestFocus();
                }
            }
            z2 = requestFocus;
        } else if (i2 == 17 || i2 == 1) {
            z2 = e();
        } else if (i2 == 66 || i2 == 2) {
            z2 = f();
        }
        if (z2) {
            playSoundEffect(SoundEffectConstants.getContantForFocusDirection(i2));
        }
        return z2;
    }

    public final Rect a(Rect rect, View view) {
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
