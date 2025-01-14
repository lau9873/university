package android.support.design.widget;

import a.b.g.j.j;
import a.b.g.j.l;
import a.b.g.k.d0;
import a.b.g.k.m;
import a.b.g.k.o;
import a.b.g.k.p;
import a.b.g.k.u;
import a.b.g.l.t;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.Region;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseArray;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.ViewTreeObserver;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/* loaded from: classes.dex */
public class CoordinatorLayout extends ViewGroup implements m {
    public static final String u;
    public static final Class<?>[] v;
    public static final ThreadLocal<Map<String, Constructor<c>>> w;
    public static final Comparator<View> x;
    public static final j<Rect> y;

    /* renamed from: a  reason: collision with root package name */
    public final List<View> f2174a;

    /* renamed from: b  reason: collision with root package name */
    public final a.b.g.l.h<View> f2175b;

    /* renamed from: c  reason: collision with root package name */
    public final List<View> f2176c;

    /* renamed from: d  reason: collision with root package name */
    public final List<View> f2177d;

    /* renamed from: e  reason: collision with root package name */
    public final int[] f2178e;

    /* renamed from: f  reason: collision with root package name */
    public Paint f2179f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f2180g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f2181h;

    /* renamed from: i  reason: collision with root package name */
    public int[] f2182i;
    public View j;
    public View k;
    public g m;
    public boolean n;
    public d0 o;
    public boolean p;
    public Drawable q;
    public ViewGroup.OnHierarchyChangeListener r;
    public p s;
    public final o t;

    /* loaded from: classes.dex */
    public class a implements p {
        public a() {
        }

        @Override // a.b.g.k.p
        public d0 a(View view, d0 d0Var) {
            return CoordinatorLayout.this.b(d0Var);
        }
    }

    /* loaded from: classes.dex */
    public interface b {
        c getBehavior();
    }

    /* loaded from: classes.dex */
    public static abstract class c<V extends View> {
        public c() {
        }

        public d0 a(CoordinatorLayout coordinatorLayout, V v, d0 d0Var) {
            return d0Var;
        }

        public void a() {
        }

        public void a(f fVar) {
        }

        public void a(CoordinatorLayout coordinatorLayout, V v, Parcelable parcelable) {
        }

        @Deprecated
        public void a(CoordinatorLayout coordinatorLayout, V v, View view, int i2, int i3, int i4, int i5) {
        }

        @Deprecated
        public void a(CoordinatorLayout coordinatorLayout, V v, View view, int i2, int i3, int[] iArr) {
        }

        @Deprecated
        public void a(CoordinatorLayout coordinatorLayout, V v, View view, View view2, int i2) {
        }

        public boolean a(CoordinatorLayout coordinatorLayout, V v) {
            return c(coordinatorLayout, v) > 0.0f;
        }

        public boolean a(CoordinatorLayout coordinatorLayout, V v, int i2) {
            return false;
        }

        public boolean a(CoordinatorLayout coordinatorLayout, V v, int i2, int i3, int i4, int i5) {
            return false;
        }

        public boolean a(CoordinatorLayout coordinatorLayout, V v, Rect rect) {
            return false;
        }

        public boolean a(CoordinatorLayout coordinatorLayout, V v, Rect rect, boolean z) {
            return false;
        }

        public boolean a(CoordinatorLayout coordinatorLayout, V v, MotionEvent motionEvent) {
            return false;
        }

        public boolean a(CoordinatorLayout coordinatorLayout, V v, View view) {
            return false;
        }

        public boolean a(CoordinatorLayout coordinatorLayout, V v, View view, float f2, float f3) {
            return false;
        }

        public boolean a(CoordinatorLayout coordinatorLayout, V v, View view, float f2, float f3, boolean z) {
            return false;
        }

        public int b(CoordinatorLayout coordinatorLayout, V v) {
            return -16777216;
        }

        public boolean b(CoordinatorLayout coordinatorLayout, V v, MotionEvent motionEvent) {
            return false;
        }

        public boolean b(CoordinatorLayout coordinatorLayout, V v, View view) {
            return false;
        }

        @Deprecated
        public boolean b(CoordinatorLayout coordinatorLayout, V v, View view, View view2, int i2) {
            return false;
        }

        public boolean b(CoordinatorLayout coordinatorLayout, V v, View view, View view2, int i2, int i3) {
            if (i3 == 0) {
                return b(coordinatorLayout, v, view, view2, i2);
            }
            return false;
        }

        public float c(CoordinatorLayout coordinatorLayout, V v) {
            return 0.0f;
        }

        public void c(CoordinatorLayout coordinatorLayout, V v, View view) {
        }

        public Parcelable d(CoordinatorLayout coordinatorLayout, V v) {
            return View.BaseSavedState.EMPTY_STATE;
        }

        @Deprecated
        public void d(CoordinatorLayout coordinatorLayout, V v, View view) {
        }

        public c(Context context, AttributeSet attributeSet) {
        }

        public void a(CoordinatorLayout coordinatorLayout, V v, View view, View view2, int i2, int i3) {
            if (i3 == 0) {
                a(coordinatorLayout, (CoordinatorLayout) v, view, view2, i2);
            }
        }

        public void a(CoordinatorLayout coordinatorLayout, V v, View view, int i2) {
            if (i2 == 0) {
                d(coordinatorLayout, v, view);
            }
        }

        public void a(CoordinatorLayout coordinatorLayout, V v, View view, int i2, int i3, int i4, int i5, int i6) {
            if (i6 == 0) {
                a(coordinatorLayout, (CoordinatorLayout) v, view, i2, i3, i4, i5);
            }
        }

        public void a(CoordinatorLayout coordinatorLayout, V v, View view, int i2, int i3, int[] iArr, int i4) {
            if (i4 == 0) {
                a(coordinatorLayout, (CoordinatorLayout) v, view, i2, i3, iArr);
            }
        }
    }

    @Retention(RetentionPolicy.RUNTIME)
    @Deprecated
    /* loaded from: classes.dex */
    public @interface d {
        Class<? extends c> value();
    }

    /* loaded from: classes.dex */
    public class e implements ViewGroup.OnHierarchyChangeListener {
        public e() {
        }

        @Override // android.view.ViewGroup.OnHierarchyChangeListener
        public void onChildViewAdded(View view, View view2) {
            ViewGroup.OnHierarchyChangeListener onHierarchyChangeListener = CoordinatorLayout.this.r;
            if (onHierarchyChangeListener != null) {
                onHierarchyChangeListener.onChildViewAdded(view, view2);
            }
        }

        @Override // android.view.ViewGroup.OnHierarchyChangeListener
        public void onChildViewRemoved(View view, View view2) {
            CoordinatorLayout.this.b(2);
            ViewGroup.OnHierarchyChangeListener onHierarchyChangeListener = CoordinatorLayout.this.r;
            if (onHierarchyChangeListener != null) {
                onHierarchyChangeListener.onChildViewRemoved(view, view2);
            }
        }
    }

    /* loaded from: classes.dex */
    public class g implements ViewTreeObserver.OnPreDrawListener {
        public g() {
        }

        @Override // android.view.ViewTreeObserver.OnPreDrawListener
        public boolean onPreDraw() {
            CoordinatorLayout.this.b(0);
            return true;
        }
    }

    /* loaded from: classes.dex */
    public static class i implements Comparator<View> {
        @Override // java.util.Comparator
        /* renamed from: a */
        public int compare(View view, View view2) {
            float r = u.r(view);
            float r2 = u.r(view2);
            if (r > r2) {
                return -1;
            }
            return r < r2 ? 1 : 0;
        }
    }

    static {
        Package r0 = CoordinatorLayout.class.getPackage();
        u = r0 != null ? r0.getName() : null;
        if (Build.VERSION.SDK_INT >= 21) {
            x = new i();
        } else {
            x = null;
        }
        v = new Class[]{Context.class, AttributeSet.class};
        w = new ThreadLocal<>();
        y = new l(12);
    }

    public CoordinatorLayout(Context context) {
        this(context, null);
    }

    public static int a(int i2, int i3, int i4) {
        return i2 < i3 ? i3 : i2 > i4 ? i4 : i2;
    }

    public static void a(Rect rect) {
        rect.setEmpty();
        y.a(rect);
    }

    public static int c(int i2) {
        if (i2 == 0) {
            return 17;
        }
        return i2;
    }

    public static int d(int i2) {
        if ((i2 & 7) == 0) {
            i2 |= 8388611;
        }
        return (i2 & 112) == 0 ? i2 | 48 : i2;
    }

    public static int e(int i2) {
        if (i2 == 0) {
            return 8388661;
        }
        return i2;
    }

    public static Rect f() {
        Rect a2 = y.a();
        return a2 == null ? new Rect() : a2;
    }

    public final d0 b(d0 d0Var) {
        if (a.b.g.j.i.a(this.o, d0Var)) {
            return d0Var;
        }
        this.o = d0Var;
        boolean z = true;
        this.p = d0Var != null && d0Var.d() > 0;
        setWillNotDraw((this.p || getBackground() != null) ? false : false);
        d0 a2 = a(d0Var);
        requestLayout();
        return a2;
    }

    public final void c() {
        this.f2174a.clear();
        this.f2175b.a();
        int childCount = getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = getChildAt(i2);
            f d2 = d(childAt);
            d2.a(this, childAt);
            this.f2175b.a((a.b.g.l.h<View>) childAt);
            for (int i3 = 0; i3 < childCount; i3++) {
                if (i3 != i2) {
                    View childAt2 = getChildAt(i3);
                    if (d2.a(this, childAt, childAt2)) {
                        if (!this.f2175b.b(childAt2)) {
                            this.f2175b.a((a.b.g.l.h<View>) childAt2);
                        }
                        this.f2175b.a(childAt2, childAt);
                    }
                }
            }
        }
        this.f2174a.addAll(this.f2175b.c());
        Collections.reverse(this.f2174a);
    }

    @Override // android.view.ViewGroup
    public boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return (layoutParams instanceof f) && super.checkLayoutParams(layoutParams);
    }

    public f d(View view) {
        f fVar = (f) view.getLayoutParams();
        if (!fVar.f2186b) {
            if (view instanceof b) {
                c behavior = ((b) view).getBehavior();
                if (behavior == null) {
                    Log.e("CoordinatorLayout", "Attached behavior class is null");
                }
                fVar.a(behavior);
                fVar.f2186b = true;
            } else {
                d dVar = null;
                for (Class<?> cls = view.getClass(); cls != null; cls = cls.getSuperclass()) {
                    dVar = (d) cls.getAnnotation(d.class);
                    if (dVar != null) {
                        break;
                    }
                }
                if (dVar != null) {
                    try {
                        fVar.a(dVar.value().getDeclaredConstructor(new Class[0]).newInstance(new Object[0]));
                    } catch (Exception e2) {
                        Log.e("CoordinatorLayout", "Default behavior class " + dVar.value().getName() + " could not be instantiated. Did you forget a default constructor?", e2);
                    }
                }
                fVar.f2186b = true;
            }
        }
        return fVar;
    }

    @Override // android.view.ViewGroup
    public boolean drawChild(Canvas canvas, View view, long j) {
        f fVar = (f) view.getLayoutParams();
        c cVar = fVar.f2185a;
        if (cVar != null) {
            float c2 = cVar.c(this, view);
            if (c2 > 0.0f) {
                if (this.f2179f == null) {
                    this.f2179f = new Paint();
                }
                this.f2179f.setColor(fVar.f2185a.b(this, view));
                this.f2179f.setAlpha(a(Math.round(c2 * 255.0f), 0, 255));
                int save = canvas.save();
                if (view.isOpaque()) {
                    canvas.clipRect(view.getLeft(), view.getTop(), view.getRight(), view.getBottom(), Region.Op.DIFFERENCE);
                }
                canvas.drawRect(getPaddingLeft(), getPaddingTop(), getWidth() - getPaddingRight(), getHeight() - getPaddingBottom(), this.f2179f);
                canvas.restoreToCount(save);
            }
        }
        return super.drawChild(canvas, view, j);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void drawableStateChanged() {
        super.drawableStateChanged();
        int[] drawableState = getDrawableState();
        Drawable drawable = this.q;
        boolean z = false;
        if (drawable != null && drawable.isStateful()) {
            z = false | drawable.setState(drawableState);
        }
        if (z) {
            invalidate();
        }
    }

    public final void e(View view, int i2) {
        f fVar = (f) view.getLayoutParams();
        int i3 = fVar.f2193i;
        if (i3 != i2) {
            u.c(view, i2 - i3);
            fVar.f2193i = i2;
        }
    }

    public final List<View> getDependencySortedChildren() {
        c();
        return Collections.unmodifiableList(this.f2174a);
    }

    public final d0 getLastWindowInsets() {
        return this.o;
    }

    @Override // android.view.ViewGroup
    public int getNestedScrollAxes() {
        return this.t.a();
    }

    public Drawable getStatusBarBackground() {
        return this.q;
    }

    @Override // android.view.View
    public int getSuggestedMinimumHeight() {
        return Math.max(super.getSuggestedMinimumHeight(), getPaddingTop() + getPaddingBottom());
    }

    @Override // android.view.View
    public int getSuggestedMinimumWidth() {
        return Math.max(super.getSuggestedMinimumWidth(), getPaddingLeft() + getPaddingRight());
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        a(false);
        if (this.n) {
            if (this.m == null) {
                this.m = new g();
            }
            getViewTreeObserver().addOnPreDrawListener(this.m);
        }
        if (this.o == null && u.h(this)) {
            u.B(this);
        }
        this.f2181h = true;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        a(false);
        if (this.n && this.m != null) {
            getViewTreeObserver().removeOnPreDrawListener(this.m);
        }
        View view = this.k;
        if (view != null) {
            onStopNestedScroll(view);
        }
        this.f2181h = false;
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (!this.p || this.q == null) {
            return;
        }
        d0 d0Var = this.o;
        int d2 = d0Var != null ? d0Var.d() : 0;
        if (d2 > 0) {
            this.q.setBounds(0, 0, getWidth(), d2);
            this.q.draw(canvas);
        }
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 0) {
            a(true);
        }
        boolean a2 = a(motionEvent, 0);
        if (actionMasked == 1 || actionMasked == 3) {
            a(true);
        }
        return a2;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        c d2;
        int k = u.k(this);
        int size = this.f2174a.size();
        for (int i6 = 0; i6 < size; i6++) {
            View view = this.f2174a.get(i6);
            if (view.getVisibility() != 8 && ((d2 = ((f) view.getLayoutParams()).d()) == null || !d2.a(this, (CoordinatorLayout) view, k))) {
                d(view, k);
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:43:0x0117, code lost:
        if (r0.a(r30, (android.support.design.widget.CoordinatorLayout) r20, r11, r21, r23, 0) == false) goto L33;
     */
    /* JADX WARN: Removed duplicated region for block: B:42:0x00f9  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x011a  */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void onMeasure(int r31, int r32) {
        /*
            Method dump skipped, instructions count: 388
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.design.widget.CoordinatorLayout.onMeasure(int, int):void");
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, a.b.g.k.n
    public boolean onNestedFling(View view, float f2, float f3, boolean z) {
        c d2;
        int childCount = getChildCount();
        boolean z2 = false;
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = getChildAt(i2);
            if (childAt.getVisibility() != 8) {
                f fVar = (f) childAt.getLayoutParams();
                if (fVar.a(0) && (d2 = fVar.d()) != null) {
                    z2 |= d2.a(this, (CoordinatorLayout) childAt, view, f2, f3, z);
                }
            }
        }
        if (z2) {
            b(1);
        }
        return z2;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, a.b.g.k.n
    public boolean onNestedPreFling(View view, float f2, float f3) {
        c d2;
        int childCount = getChildCount();
        boolean z = false;
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = getChildAt(i2);
            if (childAt.getVisibility() != 8) {
                f fVar = (f) childAt.getLayoutParams();
                if (fVar.a(0) && (d2 = fVar.d()) != null) {
                    z |= d2.a(this, (CoordinatorLayout) childAt, view, f2, f3);
                }
            }
        }
        return z;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, a.b.g.k.n
    public void onNestedPreScroll(View view, int i2, int i3, int[] iArr) {
        a(view, i2, i3, iArr, 0);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, a.b.g.k.n
    public void onNestedScroll(View view, int i2, int i3, int i4, int i5) {
        a(view, i2, i3, i4, i5, 0);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, a.b.g.k.n
    public void onNestedScrollAccepted(View view, View view2, int i2) {
        a(view, view2, i2, 0);
    }

    @Override // android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        Parcelable parcelable2;
        if (!(parcelable instanceof h)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        h hVar = (h) parcelable;
        super.onRestoreInstanceState(hVar.a());
        SparseArray<Parcelable> sparseArray = hVar.f2195c;
        int childCount = getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = getChildAt(i2);
            int id = childAt.getId();
            c d2 = d(childAt).d();
            if (id != -1 && d2 != null && (parcelable2 = sparseArray.get(id)) != null) {
                d2.a(this, (CoordinatorLayout) childAt, parcelable2);
            }
        }
    }

    @Override // android.view.View
    public Parcelable onSaveInstanceState() {
        Parcelable d2;
        h hVar = new h(super.onSaveInstanceState());
        SparseArray<Parcelable> sparseArray = new SparseArray<>();
        int childCount = getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = getChildAt(i2);
            int id = childAt.getId();
            c d3 = ((f) childAt.getLayoutParams()).d();
            if (id != -1 && d3 != null && (d2 = d3.d(this, childAt)) != null) {
                sparseArray.append(id, d2);
            }
        }
        hVar.f2195c = sparseArray;
        return hVar;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, a.b.g.k.n
    public boolean onStartNestedScroll(View view, View view2, int i2) {
        return b(view, view2, i2, 0);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, a.b.g.k.n
    public void onStopNestedScroll(View view) {
        a(view, 0);
    }

    /* JADX WARN: Code restructure failed: missing block: B:5:0x0012, code lost:
        if (r3 != false) goto L19;
     */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0031  */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0037  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x004c  */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean onTouchEvent(android.view.MotionEvent r18) {
        /*
            r17 = this;
            r0 = r17
            r1 = r18
            int r2 = r18.getActionMasked()
            android.view.View r3 = r0.j
            r4 = 1
            r5 = 0
            if (r3 != 0) goto L15
            boolean r3 = r0.a(r1, r4)
            if (r3 == 0) goto L2b
            goto L16
        L15:
            r3 = 0
        L16:
            android.view.View r6 = r0.j
            android.view.ViewGroup$LayoutParams r6 = r6.getLayoutParams()
            android.support.design.widget.CoordinatorLayout$f r6 = (android.support.design.widget.CoordinatorLayout.f) r6
            android.support.design.widget.CoordinatorLayout$c r6 = r6.d()
            if (r6 == 0) goto L2b
            android.view.View r7 = r0.j
            boolean r6 = r6.b(r0, r7, r1)
            goto L2c
        L2b:
            r6 = 0
        L2c:
            android.view.View r7 = r0.j
            r8 = 0
            if (r7 != 0) goto L37
            boolean r1 = super.onTouchEvent(r18)
            r6 = r6 | r1
            goto L4a
        L37:
            if (r3 == 0) goto L4a
            long r11 = android.os.SystemClock.uptimeMillis()
            r13 = 3
            r14 = 0
            r15 = 0
            r16 = 0
            r9 = r11
            android.view.MotionEvent r8 = android.view.MotionEvent.obtain(r9, r11, r13, r14, r15, r16)
            super.onTouchEvent(r8)
        L4a:
            if (r8 == 0) goto L4f
            r8.recycle()
        L4f:
            if (r2 == r4) goto L54
            r1 = 3
            if (r2 != r1) goto L57
        L54:
            r0.a(r5)
        L57:
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.design.widget.CoordinatorLayout.onTouchEvent(android.view.MotionEvent):boolean");
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public boolean requestChildRectangleOnScreen(View view, Rect rect, boolean z) {
        c d2 = ((f) view.getLayoutParams()).d();
        if (d2 == null || !d2.a(this, (CoordinatorLayout) view, rect, z)) {
            return super.requestChildRectangleOnScreen(view, rect, z);
        }
        return true;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void requestDisallowInterceptTouchEvent(boolean z) {
        super.requestDisallowInterceptTouchEvent(z);
        if (!z || this.f2180g) {
            return;
        }
        a(false);
        this.f2180g = true;
    }

    @Override // android.view.View
    public void setFitsSystemWindows(boolean z) {
        super.setFitsSystemWindows(z);
        e();
    }

    @Override // android.view.ViewGroup
    public void setOnHierarchyChangeListener(ViewGroup.OnHierarchyChangeListener onHierarchyChangeListener) {
        this.r = onHierarchyChangeListener;
    }

    public void setStatusBarBackground(Drawable drawable) {
        Drawable drawable2 = this.q;
        if (drawable2 != drawable) {
            if (drawable2 != null) {
                drawable2.setCallback(null);
            }
            this.q = drawable != null ? drawable.mutate() : null;
            Drawable drawable3 = this.q;
            if (drawable3 != null) {
                if (drawable3.isStateful()) {
                    this.q.setState(getDrawableState());
                }
                a.b.g.c.j.a.a(this.q, u.k(this));
                this.q.setVisible(getVisibility() == 0, false);
                this.q.setCallback(this);
            }
            u.A(this);
        }
    }

    public void setStatusBarBackgroundColor(int i2) {
        setStatusBarBackground(new ColorDrawable(i2));
    }

    public void setStatusBarBackgroundResource(int i2) {
        setStatusBarBackground(i2 != 0 ? a.b.g.b.b.c(getContext(), i2) : null);
    }

    @Override // android.view.View
    public void setVisibility(int i2) {
        super.setVisibility(i2);
        boolean z = i2 == 0;
        Drawable drawable = this.q;
        if (drawable == null || drawable.isVisible() == z) {
            return;
        }
        this.q.setVisible(z, false);
    }

    @Override // android.view.View
    public boolean verifyDrawable(Drawable drawable) {
        return super.verifyDrawable(drawable) || drawable == this.q;
    }

    public CoordinatorLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, a.b.c.a.coordinatorLayoutStyle);
    }

    @Override // android.view.ViewGroup
    public f generateDefaultLayoutParams() {
        return new f(-2, -2);
    }

    /* loaded from: classes.dex */
    public static class f extends ViewGroup.MarginLayoutParams {

        /* renamed from: a  reason: collision with root package name */
        public c f2185a;

        /* renamed from: b  reason: collision with root package name */
        public boolean f2186b;

        /* renamed from: c  reason: collision with root package name */
        public int f2187c;

        /* renamed from: d  reason: collision with root package name */
        public int f2188d;

        /* renamed from: e  reason: collision with root package name */
        public int f2189e;

        /* renamed from: f  reason: collision with root package name */
        public int f2190f;

        /* renamed from: g  reason: collision with root package name */
        public int f2191g;

        /* renamed from: h  reason: collision with root package name */
        public int f2192h;

        /* renamed from: i  reason: collision with root package name */
        public int f2193i;
        public int j;
        public View k;
        public View l;
        public boolean m;
        public boolean n;
        public boolean o;
        public boolean p;
        public final Rect q;

        public f(int i2, int i3) {
            super(i2, i3);
            this.f2186b = false;
            this.f2187c = 0;
            this.f2188d = 0;
            this.f2189e = -1;
            this.f2190f = -1;
            this.f2191g = 0;
            this.f2192h = 0;
            this.q = new Rect();
        }

        public void a(c cVar) {
            c cVar2 = this.f2185a;
            if (cVar2 != cVar) {
                if (cVar2 != null) {
                    cVar2.a();
                }
                this.f2185a = cVar;
                this.f2186b = true;
                if (cVar != null) {
                    cVar.a(this);
                }
            }
        }

        public boolean b() {
            if (this.f2185a == null) {
                this.m = false;
            }
            return this.m;
        }

        public int c() {
            return this.f2190f;
        }

        public c d() {
            return this.f2185a;
        }

        public boolean e() {
            return this.p;
        }

        public Rect f() {
            return this.q;
        }

        public void g() {
            this.p = false;
        }

        public void h() {
            this.m = false;
        }

        public boolean b(CoordinatorLayout coordinatorLayout, View view) {
            boolean z = this.m;
            if (z) {
                return true;
            }
            c cVar = this.f2185a;
            boolean a2 = (cVar != null ? cVar.a(coordinatorLayout, view) : false) | z;
            this.m = a2;
            return a2;
        }

        public void a(Rect rect) {
            this.q.set(rect);
        }

        public boolean a() {
            return this.k == null && this.f2190f != -1;
        }

        public void b(int i2) {
            a(i2, false);
        }

        public void a(int i2, boolean z) {
            if (i2 == 0) {
                this.n = z;
            } else if (i2 != 1) {
            } else {
                this.o = z;
            }
        }

        public final boolean b(View view, CoordinatorLayout coordinatorLayout) {
            if (this.k.getId() != this.f2190f) {
                return false;
            }
            View view2 = this.k;
            for (ViewParent parent = view2.getParent(); parent != coordinatorLayout; parent = parent.getParent()) {
                if (parent != null && parent != view) {
                    if (parent instanceof View) {
                        view2 = (View) parent;
                    }
                } else {
                    this.l = null;
                    this.k = null;
                    return false;
                }
            }
            this.l = view2;
            return true;
        }

        public f(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            this.f2186b = false;
            this.f2187c = 0;
            this.f2188d = 0;
            this.f2189e = -1;
            this.f2190f = -1;
            this.f2191g = 0;
            this.f2192h = 0;
            this.q = new Rect();
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, a.b.c.c.CoordinatorLayout_Layout);
            this.f2187c = obtainStyledAttributes.getInteger(a.b.c.c.CoordinatorLayout_Layout_android_layout_gravity, 0);
            this.f2190f = obtainStyledAttributes.getResourceId(a.b.c.c.CoordinatorLayout_Layout_layout_anchor, -1);
            this.f2188d = obtainStyledAttributes.getInteger(a.b.c.c.CoordinatorLayout_Layout_layout_anchorGravity, 0);
            this.f2189e = obtainStyledAttributes.getInteger(a.b.c.c.CoordinatorLayout_Layout_layout_keyline, -1);
            this.f2191g = obtainStyledAttributes.getInt(a.b.c.c.CoordinatorLayout_Layout_layout_insetEdge, 0);
            this.f2192h = obtainStyledAttributes.getInt(a.b.c.c.CoordinatorLayout_Layout_layout_dodgeInsetEdges, 0);
            this.f2186b = obtainStyledAttributes.hasValue(a.b.c.c.CoordinatorLayout_Layout_layout_behavior);
            if (this.f2186b) {
                this.f2185a = CoordinatorLayout.a(context, attributeSet, obtainStyledAttributes.getString(a.b.c.c.CoordinatorLayout_Layout_layout_behavior));
            }
            obtainStyledAttributes.recycle();
            c cVar = this.f2185a;
            if (cVar != null) {
                cVar.a(this);
            }
        }

        public boolean a(int i2) {
            if (i2 != 0) {
                if (i2 != 1) {
                    return false;
                }
                return this.o;
            }
            return this.n;
        }

        public void a(boolean z) {
            this.p = z;
        }

        public boolean a(CoordinatorLayout coordinatorLayout, View view, View view2) {
            c cVar;
            return view2 == this.l || a(view2, u.k(coordinatorLayout)) || ((cVar = this.f2185a) != null && cVar.a(coordinatorLayout, (CoordinatorLayout) view, view2));
        }

        public View a(CoordinatorLayout coordinatorLayout, View view) {
            if (this.f2190f == -1) {
                this.l = null;
                this.k = null;
                return null;
            }
            if (this.k == null || !b(view, coordinatorLayout)) {
                a(view, coordinatorLayout);
            }
            return this.k;
        }

        public final void a(View view, CoordinatorLayout coordinatorLayout) {
            this.k = coordinatorLayout.findViewById(this.f2190f);
            View view2 = this.k;
            if (view2 == null) {
                if (coordinatorLayout.isInEditMode()) {
                    this.l = null;
                    this.k = null;
                    return;
                }
                throw new IllegalStateException("Could not find CoordinatorLayout descendant view with id " + coordinatorLayout.getResources().getResourceName(this.f2190f) + " to anchor view " + view);
            } else if (view2 == coordinatorLayout) {
                if (coordinatorLayout.isInEditMode()) {
                    this.l = null;
                    this.k = null;
                    return;
                }
                throw new IllegalStateException("View can not be anchored to the the parent CoordinatorLayout");
            } else {
                for (ViewParent parent = view2.getParent(); parent != coordinatorLayout && parent != null; parent = parent.getParent()) {
                    if (parent == view) {
                        if (coordinatorLayout.isInEditMode()) {
                            this.l = null;
                            this.k = null;
                            return;
                        }
                        throw new IllegalStateException("Anchor must not be a descendant of the anchored view");
                    }
                    if (parent instanceof View) {
                        view2 = (View) parent;
                    }
                }
                this.l = view2;
            }
        }

        public f(f fVar) {
            super((ViewGroup.MarginLayoutParams) fVar);
            this.f2186b = false;
            this.f2187c = 0;
            this.f2188d = 0;
            this.f2189e = -1;
            this.f2190f = -1;
            this.f2191g = 0;
            this.f2192h = 0;
            this.q = new Rect();
        }

        public final boolean a(View view, int i2) {
            int a2 = a.b.g.k.d.a(((f) view.getLayoutParams()).f2191g, i2);
            return a2 != 0 && (a.b.g.k.d.a(this.f2192h, i2) & a2) == a2;
        }

        public f(ViewGroup.MarginLayoutParams marginLayoutParams) {
            super(marginLayoutParams);
            this.f2186b = false;
            this.f2187c = 0;
            this.f2188d = 0;
            this.f2189e = -1;
            this.f2190f = -1;
            this.f2191g = 0;
            this.f2192h = 0;
            this.q = new Rect();
        }

        public f(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
            this.f2186b = false;
            this.f2187c = 0;
            this.f2188d = 0;
            this.f2189e = -1;
            this.f2190f = -1;
            this.f2191g = 0;
            this.f2192h = 0;
            this.q = new Rect();
        }
    }

    public CoordinatorLayout(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        TypedArray obtainStyledAttributes;
        this.f2174a = new ArrayList();
        this.f2175b = new a.b.g.l.h<>();
        this.f2176c = new ArrayList();
        this.f2177d = new ArrayList();
        this.f2178e = new int[2];
        this.t = new o(this);
        if (i2 == 0) {
            obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, a.b.c.c.CoordinatorLayout, 0, a.b.c.b.Widget_Support_CoordinatorLayout);
        } else {
            obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, a.b.c.c.CoordinatorLayout, i2, 0);
        }
        int resourceId = obtainStyledAttributes.getResourceId(a.b.c.c.CoordinatorLayout_keylines, 0);
        if (resourceId != 0) {
            Resources resources = context.getResources();
            this.f2182i = resources.getIntArray(resourceId);
            float f2 = resources.getDisplayMetrics().density;
            int length = this.f2182i.length;
            for (int i3 = 0; i3 < length; i3++) {
                int[] iArr = this.f2182i;
                iArr[i3] = (int) (iArr[i3] * f2);
            }
        }
        this.q = obtainStyledAttributes.getDrawable(a.b.c.c.CoordinatorLayout_statusBarBackground);
        obtainStyledAttributes.recycle();
        e();
        super.setOnHierarchyChangeListener(new e());
    }

    public final void a(boolean z) {
        int childCount = getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = getChildAt(i2);
            c d2 = ((f) childAt.getLayoutParams()).d();
            if (d2 != null) {
                long uptimeMillis = SystemClock.uptimeMillis();
                MotionEvent obtain = MotionEvent.obtain(uptimeMillis, uptimeMillis, 3, 0.0f, 0.0f, 0);
                if (z) {
                    d2.a(this, (CoordinatorLayout) childAt, obtain);
                } else {
                    d2.b(this, (CoordinatorLayout) childAt, obtain);
                }
                obtain.recycle();
            }
        }
        for (int i3 = 0; i3 < childCount; i3++) {
            ((f) getChildAt(i3).getLayoutParams()).h();
        }
        this.j = null;
        this.f2180g = false;
    }

    public final void f(View view, int i2) {
        f fVar = (f) view.getLayoutParams();
        int i3 = fVar.j;
        if (i3 != i2) {
            u.d(view, i2 - i3);
            fVar.j = i2;
        }
    }

    @Override // android.view.ViewGroup
    public f generateLayoutParams(AttributeSet attributeSet) {
        return new f(getContext(), attributeSet);
    }

    @Override // android.view.ViewGroup
    public f generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        if (layoutParams instanceof f) {
            return new f((f) layoutParams);
        }
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            return new f((ViewGroup.MarginLayoutParams) layoutParams);
        }
        return new f(layoutParams);
    }

    public final boolean e(View view) {
        return this.f2175b.e(view);
    }

    public final void e() {
        if (Build.VERSION.SDK_INT < 21) {
            return;
        }
        if (u.h(this)) {
            if (this.s == null) {
                this.s = new a();
            }
            u.a(this, this.s);
            setSystemUiVisibility(1280);
            return;
        }
        u.a(this, (p) null);
    }

    /* loaded from: classes.dex */
    public static class h extends a.b.g.k.a {
        public static final Parcelable.Creator<h> CREATOR = new a();

        /* renamed from: c  reason: collision with root package name */
        public SparseArray<Parcelable> f2195c;

        /* loaded from: classes.dex */
        public static class a implements Parcelable.ClassLoaderCreator<h> {
            @Override // android.os.Parcelable.Creator
            public h[] newArray(int i2) {
                return new h[i2];
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.ClassLoaderCreator
            public h createFromParcel(Parcel parcel, ClassLoader classLoader) {
                return new h(parcel, classLoader);
            }

            @Override // android.os.Parcelable.Creator
            public h createFromParcel(Parcel parcel) {
                return new h(parcel, null);
            }
        }

        public h(Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            int readInt = parcel.readInt();
            int[] iArr = new int[readInt];
            parcel.readIntArray(iArr);
            Parcelable[] readParcelableArray = parcel.readParcelableArray(classLoader);
            this.f2195c = new SparseArray<>(readInt);
            for (int i2 = 0; i2 < readInt; i2++) {
                this.f2195c.append(iArr[i2], readParcelableArray[i2]);
            }
        }

        @Override // a.b.g.k.a, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i2) {
            super.writeToParcel(parcel, i2);
            SparseArray<Parcelable> sparseArray = this.f2195c;
            int size = sparseArray != null ? sparseArray.size() : 0;
            parcel.writeInt(size);
            int[] iArr = new int[size];
            Parcelable[] parcelableArr = new Parcelable[size];
            for (int i3 = 0; i3 < size; i3++) {
                iArr[i3] = this.f2195c.keyAt(i3);
                parcelableArr[i3] = this.f2195c.valueAt(i3);
            }
            parcel.writeIntArray(iArr);
            parcel.writeParcelableArray(parcelableArr, i2);
        }

        public h(Parcelable parcelable) {
            super(parcelable);
        }
    }

    public void b(View view, Rect rect) {
        rect.set(((f) view.getLayoutParams()).f());
    }

    public final void b(View view, int i2, int i3) {
        f fVar = (f) view.getLayoutParams();
        int a2 = a.b.g.k.d.a(e(fVar.f2187c), i3);
        int i4 = a2 & 7;
        int i5 = a2 & 112;
        int width = getWidth();
        int height = getHeight();
        int measuredWidth = view.getMeasuredWidth();
        int measuredHeight = view.getMeasuredHeight();
        if (i3 == 1) {
            i2 = width - i2;
        }
        int a3 = a(i2) - measuredWidth;
        int i6 = 0;
        if (i4 == 1) {
            a3 += measuredWidth / 2;
        } else if (i4 == 5) {
            a3 += measuredWidth;
        }
        if (i5 == 16) {
            i6 = 0 + (measuredHeight / 2);
        } else if (i5 == 80) {
            i6 = measuredHeight + 0;
        }
        int max = Math.max(getPaddingLeft() + ((ViewGroup.MarginLayoutParams) fVar).leftMargin, Math.min(a3, ((width - getPaddingRight()) - measuredWidth) - ((ViewGroup.MarginLayoutParams) fVar).rightMargin));
        int max2 = Math.max(getPaddingTop() + ((ViewGroup.MarginLayoutParams) fVar).topMargin, Math.min(i6, ((height - getPaddingBottom()) - measuredHeight) - ((ViewGroup.MarginLayoutParams) fVar).bottomMargin));
        view.layout(max, max2, measuredWidth + max, measuredHeight + max2);
    }

    public void c(View view, Rect rect) {
        ((f) view.getLayoutParams()).a(rect);
    }

    public void d(View view, int i2) {
        f fVar = (f) view.getLayoutParams();
        if (!fVar.a()) {
            View view2 = fVar.k;
            if (view2 != null) {
                a(view, view2, i2);
                return;
            }
            int i3 = fVar.f2189e;
            if (i3 >= 0) {
                b(view, i3, i2);
                return;
            } else {
                b(view, i2);
                return;
            }
        }
        throw new IllegalStateException("An anchor may not be changed after CoordinatorLayout measurement begins before layout is complete.");
    }

    public final void a(List<View> list) {
        list.clear();
        boolean isChildrenDrawingOrderEnabled = isChildrenDrawingOrderEnabled();
        int childCount = getChildCount();
        for (int i2 = childCount - 1; i2 >= 0; i2--) {
            list.add(getChildAt(isChildrenDrawingOrderEnabled ? getChildDrawingOrder(childCount, i2) : i2));
        }
        Comparator<View> comparator = x;
        if (comparator != null) {
            Collections.sort(list, comparator);
        }
    }

    public List<View> c(View view) {
        List c2 = this.f2175b.c(view);
        this.f2177d.clear();
        if (c2 != null) {
            this.f2177d.addAll(c2);
        }
        return this.f2177d;
    }

    public void c(View view, int i2) {
        c d2;
        f fVar = (f) view.getLayoutParams();
        if (fVar.k != null) {
            Rect f2 = f();
            Rect f3 = f();
            Rect f4 = f();
            a(fVar.k, f2);
            boolean z = false;
            a(view, false, f3);
            int measuredWidth = view.getMeasuredWidth();
            int measuredHeight = view.getMeasuredHeight();
            a(view, i2, f2, f4, fVar, measuredWidth, measuredHeight);
            z = (f4.left == f3.left && f4.top == f3.top) ? true : true;
            a(fVar, f4, measuredWidth, measuredHeight);
            int i3 = f4.left - f3.left;
            int i4 = f4.top - f3.top;
            if (i3 != 0) {
                u.c(view, i3);
            }
            if (i4 != 0) {
                u.d(view, i4);
            }
            if (z && (d2 = fVar.d()) != null) {
                d2.b(this, (CoordinatorLayout) view, fVar.k);
            }
            a(f2);
            a(f3);
            a(f4);
        }
    }

    public void d() {
        if (this.f2181h && this.m != null) {
            getViewTreeObserver().removeOnPreDrawListener(this.m);
        }
        this.n = false;
    }

    public final boolean a(MotionEvent motionEvent, int i2) {
        int actionMasked = motionEvent.getActionMasked();
        List<View> list = this.f2176c;
        a(list);
        int size = list.size();
        MotionEvent motionEvent2 = null;
        boolean z = false;
        boolean z2 = false;
        for (int i3 = 0; i3 < size; i3++) {
            View view = list.get(i3);
            f fVar = (f) view.getLayoutParams();
            c d2 = fVar.d();
            boolean z3 = true;
            if (!(z || z2) || actionMasked == 0) {
                if (!z && d2 != null) {
                    if (i2 == 0) {
                        z = d2.a(this, (CoordinatorLayout) view, motionEvent);
                    } else if (i2 == 1) {
                        z = d2.b(this, (CoordinatorLayout) view, motionEvent);
                    }
                    if (z) {
                        this.j = view;
                    }
                }
                boolean b2 = fVar.b();
                boolean b3 = fVar.b(this, view);
                z3 = (!b3 || b2) ? false : false;
                if (b3 && !z3) {
                    break;
                }
                z2 = z3;
            } else if (d2 != null) {
                if (motionEvent2 == null) {
                    long uptimeMillis = SystemClock.uptimeMillis();
                    motionEvent2 = MotionEvent.obtain(uptimeMillis, uptimeMillis, 3, 0.0f, 0.0f, 0);
                }
                if (i2 == 0) {
                    d2.a(this, (CoordinatorLayout) view, motionEvent2);
                } else if (i2 == 1) {
                    d2.b(this, (CoordinatorLayout) view, motionEvent2);
                }
            }
        }
        list.clear();
        return z;
    }

    public final void b(View view, int i2) {
        f fVar = (f) view.getLayoutParams();
        Rect f2 = f();
        f2.set(getPaddingLeft() + ((ViewGroup.MarginLayoutParams) fVar).leftMargin, getPaddingTop() + ((ViewGroup.MarginLayoutParams) fVar).topMargin, (getWidth() - getPaddingRight()) - ((ViewGroup.MarginLayoutParams) fVar).rightMargin, (getHeight() - getPaddingBottom()) - ((ViewGroup.MarginLayoutParams) fVar).bottomMargin);
        if (this.o != null && u.h(this) && !u.h(view)) {
            f2.left += this.o.b();
            f2.top += this.o.d();
            f2.right -= this.o.c();
            f2.bottom -= this.o.a();
        }
        Rect f3 = f();
        a.b.g.k.d.a(d(fVar.f2187c), view.getMeasuredWidth(), view.getMeasuredHeight(), f2, f3, i2);
        view.layout(f3.left, f3.top, f3.right, f3.bottom);
        a(f2);
        a(f3);
    }

    public final int a(int i2) {
        int[] iArr = this.f2182i;
        if (iArr == null) {
            Log.e("CoordinatorLayout", "No keylines defined for " + this + " - attempted index lookup " + i2);
            return 0;
        } else if (i2 >= 0 && i2 < iArr.length) {
            return iArr[i2];
        } else {
            Log.e("CoordinatorLayout", "Keyline index " + i2 + " out of range for " + this);
            return 0;
        }
    }

    public static c a(Context context, AttributeSet attributeSet, String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        if (str.startsWith(".")) {
            str = context.getPackageName() + str;
        } else if (str.indexOf(46) < 0 && !TextUtils.isEmpty(u)) {
            str = u + '.' + str;
        }
        try {
            Map<String, Constructor<c>> map = w.get();
            if (map == null) {
                map = new HashMap<>();
                w.set(map);
            }
            Constructor<c> constructor = map.get(str);
            if (constructor == null) {
                constructor = context.getClassLoader().loadClass(str).getConstructor(v);
                constructor.setAccessible(true);
                map.put(str, constructor);
            }
            return (c) constructor.newInstance(context, attributeSet);
        } catch (Exception e2) {
            throw new RuntimeException("Could not inflate Behavior subclass " + str, e2);
        }
    }

    public final void b(int i2) {
        boolean z;
        int k = u.k(this);
        int size = this.f2174a.size();
        Rect f2 = f();
        Rect f3 = f();
        Rect f4 = f();
        for (int i3 = 0; i3 < size; i3++) {
            View view = this.f2174a.get(i3);
            f fVar = (f) view.getLayoutParams();
            if (i2 != 0 || view.getVisibility() != 8) {
                for (int i4 = 0; i4 < i3; i4++) {
                    if (fVar.l == this.f2174a.get(i4)) {
                        c(view, k);
                    }
                }
                a(view, true, f3);
                if (fVar.f2191g != 0 && !f3.isEmpty()) {
                    int a2 = a.b.g.k.d.a(fVar.f2191g, k);
                    int i5 = a2 & 112;
                    if (i5 == 48) {
                        f2.top = Math.max(f2.top, f3.bottom);
                    } else if (i5 == 80) {
                        f2.bottom = Math.max(f2.bottom, getHeight() - f3.top);
                    }
                    int i6 = a2 & 7;
                    if (i6 == 3) {
                        f2.left = Math.max(f2.left, f3.right);
                    } else if (i6 == 5) {
                        f2.right = Math.max(f2.right, getWidth() - f3.left);
                    }
                }
                if (fVar.f2192h != 0 && view.getVisibility() == 0) {
                    a(view, f2, k);
                }
                if (i2 != 2) {
                    b(view, f4);
                    if (!f4.equals(f3)) {
                        c(view, f3);
                    }
                }
                for (int i7 = i3 + 1; i7 < size; i7++) {
                    View view2 = this.f2174a.get(i7);
                    f fVar2 = (f) view2.getLayoutParams();
                    c d2 = fVar2.d();
                    if (d2 != null && d2.a(this, (CoordinatorLayout) view2, view)) {
                        if (i2 == 0 && fVar2.e()) {
                            fVar2.g();
                        } else {
                            if (i2 != 2) {
                                z = d2.b(this, (CoordinatorLayout) view2, view);
                            } else {
                                d2.c(this, view2, view);
                                z = true;
                            }
                            if (i2 == 1) {
                                fVar2.a(z);
                            }
                        }
                    }
                }
            }
        }
        a(f2);
        a(f3);
        a(f4);
    }

    public void a(View view, Rect rect) {
        t.a(this, view, rect);
    }

    public void a(View view, int i2, int i3, int i4, int i5) {
        measureChildWithMargins(view, i2, i3, i4, i5);
    }

    public final d0 a(d0 d0Var) {
        c d2;
        if (d0Var.e()) {
            return d0Var;
        }
        int childCount = getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = getChildAt(i2);
            if (u.h(childAt) && (d2 = ((f) childAt.getLayoutParams()).d()) != null) {
                d0Var = d2.a(this, (CoordinatorLayout) childAt, d0Var);
                if (d0Var.e()) {
                    break;
                }
            }
        }
        return d0Var;
    }

    public void a(View view, boolean z, Rect rect) {
        if (view.isLayoutRequested() || view.getVisibility() == 8) {
            rect.setEmpty();
        } else if (z) {
            a(view, rect);
        } else {
            rect.set(view.getLeft(), view.getTop(), view.getRight(), view.getBottom());
        }
    }

    public final void a(View view, int i2, Rect rect, Rect rect2, f fVar, int i3, int i4) {
        int width;
        int height;
        int a2 = a.b.g.k.d.a(c(fVar.f2187c), i2);
        int a3 = a.b.g.k.d.a(d(fVar.f2188d), i2);
        int i5 = a2 & 7;
        int i6 = a2 & 112;
        int i7 = a3 & 7;
        int i8 = a3 & 112;
        if (i7 == 1) {
            width = rect.left + (rect.width() / 2);
        } else if (i7 != 5) {
            width = rect.left;
        } else {
            width = rect.right;
        }
        if (i8 == 16) {
            height = rect.top + (rect.height() / 2);
        } else if (i8 != 80) {
            height = rect.top;
        } else {
            height = rect.bottom;
        }
        if (i5 == 1) {
            width -= i3 / 2;
        } else if (i5 != 5) {
            width -= i3;
        }
        if (i6 == 16) {
            height -= i4 / 2;
        } else if (i6 != 80) {
            height -= i4;
        }
        rect2.set(width, height, i3 + width, i4 + height);
    }

    public List<View> b(View view) {
        List<View> d2 = this.f2175b.d(view);
        this.f2177d.clear();
        if (d2 != null) {
            this.f2177d.addAll(d2);
        }
        return this.f2177d;
    }

    public void b() {
        int childCount = getChildCount();
        boolean z = false;
        int i2 = 0;
        while (true) {
            if (i2 >= childCount) {
                break;
            } else if (e(getChildAt(i2))) {
                z = true;
                break;
            } else {
                i2++;
            }
        }
        if (z != this.n) {
            if (z) {
                a();
            } else {
                d();
            }
        }
    }

    public final void a(f fVar, Rect rect, int i2, int i3) {
        int width = getWidth();
        int height = getHeight();
        int max = Math.max(getPaddingLeft() + ((ViewGroup.MarginLayoutParams) fVar).leftMargin, Math.min(rect.left, ((width - getPaddingRight()) - i2) - ((ViewGroup.MarginLayoutParams) fVar).rightMargin));
        int max2 = Math.max(getPaddingTop() + ((ViewGroup.MarginLayoutParams) fVar).topMargin, Math.min(rect.top, ((height - getPaddingBottom()) - i3) - ((ViewGroup.MarginLayoutParams) fVar).bottomMargin));
        rect.set(max, max2, i2 + max, i3 + max2);
    }

    @Override // a.b.g.k.m
    public boolean b(View view, View view2, int i2, int i3) {
        int childCount = getChildCount();
        boolean z = false;
        for (int i4 = 0; i4 < childCount; i4++) {
            View childAt = getChildAt(i4);
            if (childAt.getVisibility() != 8) {
                f fVar = (f) childAt.getLayoutParams();
                c d2 = fVar.d();
                if (d2 != null) {
                    boolean b2 = d2.b(this, childAt, view, view2, i2, i3);
                    fVar.a(i3, b2);
                    z |= b2;
                } else {
                    fVar.a(i3, false);
                }
            }
        }
        return z;
    }

    public void a(View view, int i2, Rect rect, Rect rect2) {
        f fVar = (f) view.getLayoutParams();
        int measuredWidth = view.getMeasuredWidth();
        int measuredHeight = view.getMeasuredHeight();
        a(view, i2, rect, rect2, fVar, measuredWidth, measuredHeight);
        a(fVar, rect2, measuredWidth, measuredHeight);
    }

    public final void a(View view, View view2, int i2) {
        Rect f2 = f();
        Rect f3 = f();
        try {
            a(view2, f2);
            a(view, i2, f2, f3);
            view.layout(f3.left, f3.top, f3.right, f3.bottom);
        } finally {
            a(f2);
            a(f3);
        }
    }

    public final void a(View view, Rect rect, int i2) {
        boolean z;
        boolean z2;
        int width;
        int i3;
        int i4;
        int i5;
        int height;
        int i6;
        int i7;
        int i8;
        if (u.x(view) && view.getWidth() > 0 && view.getHeight() > 0) {
            f fVar = (f) view.getLayoutParams();
            c d2 = fVar.d();
            Rect f2 = f();
            Rect f3 = f();
            f3.set(view.getLeft(), view.getTop(), view.getRight(), view.getBottom());
            if (d2 != null && d2.a(this, (CoordinatorLayout) view, f2)) {
                if (!f3.contains(f2)) {
                    throw new IllegalArgumentException("Rect should be within the child's bounds. Rect:" + f2.toShortString() + " | Bounds:" + f3.toShortString());
                }
            } else {
                f2.set(f3);
            }
            a(f3);
            if (f2.isEmpty()) {
                a(f2);
                return;
            }
            int a2 = a.b.g.k.d.a(fVar.f2192h, i2);
            if ((a2 & 48) != 48 || (i7 = (f2.top - ((ViewGroup.MarginLayoutParams) fVar).topMargin) - fVar.j) >= (i8 = rect.top)) {
                z = false;
            } else {
                f(view, i8 - i7);
                z = true;
            }
            if ((a2 & 80) == 80 && (height = ((getHeight() - f2.bottom) - ((ViewGroup.MarginLayoutParams) fVar).bottomMargin) + fVar.j) < (i6 = rect.bottom)) {
                f(view, height - i6);
                z = true;
            }
            if (!z) {
                f(view, 0);
            }
            if ((a2 & 3) != 3 || (i4 = (f2.left - ((ViewGroup.MarginLayoutParams) fVar).leftMargin) - fVar.f2193i) >= (i5 = rect.left)) {
                z2 = false;
            } else {
                e(view, i5 - i4);
                z2 = true;
            }
            if ((a2 & 5) == 5 && (width = ((getWidth() - f2.right) - ((ViewGroup.MarginLayoutParams) fVar).rightMargin) + fVar.f2193i) < (i3 = rect.right)) {
                e(view, width - i3);
                z2 = true;
            }
            if (!z2) {
                e(view, 0);
            }
            a(f2);
        }
    }

    public void a(View view) {
        List c2 = this.f2175b.c(view);
        if (c2 == null || c2.isEmpty()) {
            return;
        }
        for (int i2 = 0; i2 < c2.size(); i2++) {
            View view2 = (View) c2.get(i2);
            c d2 = ((f) view2.getLayoutParams()).d();
            if (d2 != null) {
                d2.b(this, (CoordinatorLayout) view2, view);
            }
        }
    }

    public void a() {
        if (this.f2181h) {
            if (this.m == null) {
                this.m = new g();
            }
            getViewTreeObserver().addOnPreDrawListener(this.m);
        }
        this.n = true;
    }

    public boolean a(View view, int i2, int i3) {
        Rect f2 = f();
        a(view, f2);
        try {
            return f2.contains(i2, i3);
        } finally {
            a(f2);
        }
    }

    @Override // a.b.g.k.m
    public void a(View view, View view2, int i2, int i3) {
        c d2;
        this.t.a(view, view2, i2, i3);
        this.k = view2;
        int childCount = getChildCount();
        for (int i4 = 0; i4 < childCount; i4++) {
            View childAt = getChildAt(i4);
            f fVar = (f) childAt.getLayoutParams();
            if (fVar.a(i3) && (d2 = fVar.d()) != null) {
                d2.a(this, (CoordinatorLayout) childAt, view, view2, i2, i3);
            }
        }
    }

    @Override // a.b.g.k.m
    public void a(View view, int i2) {
        this.t.a(view, i2);
        int childCount = getChildCount();
        for (int i3 = 0; i3 < childCount; i3++) {
            View childAt = getChildAt(i3);
            f fVar = (f) childAt.getLayoutParams();
            if (fVar.a(i2)) {
                c d2 = fVar.d();
                if (d2 != null) {
                    d2.a(this, (CoordinatorLayout) childAt, view, i2);
                }
                fVar.b(i2);
                fVar.g();
            }
        }
        this.k = null;
    }

    @Override // a.b.g.k.m
    public void a(View view, int i2, int i3, int i4, int i5, int i6) {
        c d2;
        int childCount = getChildCount();
        boolean z = false;
        for (int i7 = 0; i7 < childCount; i7++) {
            View childAt = getChildAt(i7);
            if (childAt.getVisibility() != 8) {
                f fVar = (f) childAt.getLayoutParams();
                if (fVar.a(i6) && (d2 = fVar.d()) != null) {
                    d2.a(this, childAt, view, i2, i3, i4, i5, i6);
                    z = true;
                }
            }
        }
        if (z) {
            b(1);
        }
    }

    @Override // a.b.g.k.m
    public void a(View view, int i2, int i3, int[] iArr, int i4) {
        c d2;
        int childCount = getChildCount();
        boolean z = false;
        int i5 = 0;
        int i6 = 0;
        for (int i7 = 0; i7 < childCount; i7++) {
            View childAt = getChildAt(i7);
            if (childAt.getVisibility() != 8) {
                f fVar = (f) childAt.getLayoutParams();
                if (fVar.a(i4) && (d2 = fVar.d()) != null) {
                    int[] iArr2 = this.f2178e;
                    iArr2[1] = 0;
                    iArr2[0] = 0;
                    d2.a(this, (CoordinatorLayout) childAt, view, i2, i3, iArr2, i4);
                    int[] iArr3 = this.f2178e;
                    int max = i2 > 0 ? Math.max(i5, iArr3[0]) : Math.min(i5, iArr3[0]);
                    int[] iArr4 = this.f2178e;
                    i5 = max;
                    i6 = i3 > 0 ? Math.max(i6, iArr4[1]) : Math.min(i6, iArr4[1]);
                    z = true;
                }
            }
        }
        iArr[0] = i5;
        iArr[1] = i6;
        if (z) {
            b(1);
        }
    }
}
