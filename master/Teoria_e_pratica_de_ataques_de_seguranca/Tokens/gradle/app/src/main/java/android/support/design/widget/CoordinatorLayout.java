package android.support.design.widget;

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
import p000a.p006b.p011c.C0036a;
import p000a.p006b.p011c.C0037b;
import p000a.p006b.p011c.C0038c;
import p000a.p006b.p030g.p032b.ContextCompat;
import p000a.p006b.p030g.p034c.p035j.DrawableCompat;
import p000a.p006b.p030g.p044j.C0275l;
import p000a.p006b.p030g.p044j.InterfaceC0273j;
import p000a.p006b.p030g.p044j.ObjectsCompat;
import p000a.p006b.p030g.p045k.AbsSavedState;
import p000a.p006b.p030g.p045k.GravityCompat;
import p000a.p006b.p030g.p045k.NestedScrollingParent2;
import p000a.p006b.p030g.p045k.NestedScrollingParentHelper;
import p000a.p006b.p030g.p045k.OnApplyWindowInsetsListener;
import p000a.p006b.p030g.p045k.ViewCompat;
import p000a.p006b.p030g.p045k.WindowInsetsCompat;
import p000a.p006b.p030g.p048l.C0321t;
import p000a.p006b.p030g.p048l.DirectedAcyclicGraph;

/* loaded from: classes.dex */
public class CoordinatorLayout extends ViewGroup implements NestedScrollingParent2 {

    /* renamed from: u */
    public static final String f3301u;

    /* renamed from: v */
    public static final Class<?>[] f3302v;

    /* renamed from: w */
    public static final ThreadLocal<Map<String, Constructor<AbstractC0575c>>> f3303w;

    /* renamed from: x */
    public static final Comparator<View> f3304x;

    /* renamed from: y */
    public static final InterfaceC0273j<Rect> f3305y;

    /* renamed from: a */
    public final List<View> f3306a;

    /* renamed from: b */
    public final DirectedAcyclicGraph<View> f3307b;

    /* renamed from: c */
    public final List<View> f3308c;

    /* renamed from: d */
    public final List<View> f3309d;

    /* renamed from: e */
    public final int[] f3310e;

    /* renamed from: f */
    public Paint f3311f;

    /* renamed from: g */
    public boolean f3312g;

    /* renamed from: h */
    public boolean f3313h;

    /* renamed from: i */
    public int[] f3314i;

    /* renamed from: j */
    public View f3315j;

    /* renamed from: k */
    public View f3316k;

    /* renamed from: m */
    public ViewTreeObserver$OnPreDrawListenerC0579g f3317m;

    /* renamed from: n */
    public boolean f3318n;

    /* renamed from: o */
    public WindowInsetsCompat f3319o;

    /* renamed from: p */
    public boolean f3320p;

    /* renamed from: q */
    public Drawable f3321q;

    /* renamed from: r */
    public ViewGroup.OnHierarchyChangeListener f3322r;

    /* renamed from: s */
    public OnApplyWindowInsetsListener f3323s;

    /* renamed from: t */
    public final NestedScrollingParentHelper f3324t;

    /* renamed from: android.support.design.widget.CoordinatorLayout$a */
    /* loaded from: classes.dex */
    public class C0573a implements OnApplyWindowInsetsListener {
        public C0573a() {
        }

        @Override // p000a.p006b.p030g.p045k.OnApplyWindowInsetsListener
        /* renamed from: a */
        public WindowInsetsCompat mo7712a(View view, WindowInsetsCompat windowInsetsCompat) {
            return CoordinatorLayout.this.m7732b(windowInsetsCompat);
        }
    }

    /* renamed from: android.support.design.widget.CoordinatorLayout$b */
    /* loaded from: classes.dex */
    public interface InterfaceC0574b {
        AbstractC0575c getBehavior();
    }

    /* renamed from: android.support.design.widget.CoordinatorLayout$c */
    /* loaded from: classes.dex */
    public static abstract class AbstractC0575c<V extends View> {
        public AbstractC0575c() {
        }

        /* renamed from: a */
        public WindowInsetsCompat m7708a(CoordinatorLayout coordinatorLayout, V v, WindowInsetsCompat windowInsetsCompat) {
            return windowInsetsCompat;
        }

        /* renamed from: a */
        public void m7711a() {
        }

        /* renamed from: a */
        public void mo7649a(C0578f c0578f) {
        }

        /* renamed from: a */
        public void mo7706a(CoordinatorLayout coordinatorLayout, V v, Parcelable parcelable) {
        }

        @Deprecated
        /* renamed from: a */
        public void mo7701a(CoordinatorLayout coordinatorLayout, V v, View view, int i, int i2, int i3, int i4) {
        }

        @Deprecated
        /* renamed from: a */
        public void m7699a(CoordinatorLayout coordinatorLayout, V v, View view, int i, int i2, int[] iArr) {
        }

        @Deprecated
        /* renamed from: a */
        public void m7697a(CoordinatorLayout coordinatorLayout, V v, View view, View view2, int i) {
        }

        /* renamed from: a */
        public boolean m7710a(CoordinatorLayout coordinatorLayout, V v) {
            return m7692c(coordinatorLayout, v) > 0.0f;
        }

        /* renamed from: a */
        public boolean mo7643a(CoordinatorLayout coordinatorLayout, V v, int i) {
            return false;
        }

        /* renamed from: a */
        public boolean mo7709a(CoordinatorLayout coordinatorLayout, V v, int i, int i2, int i3, int i4) {
            return false;
        }

        /* renamed from: a */
        public boolean mo7642a(CoordinatorLayout coordinatorLayout, V v, Rect rect) {
            return false;
        }

        /* renamed from: a */
        public boolean mo7707a(CoordinatorLayout coordinatorLayout, V v, Rect rect, boolean z) {
            return false;
        }

        /* renamed from: a */
        public boolean mo7608a(CoordinatorLayout coordinatorLayout, V v, MotionEvent motionEvent) {
            return false;
        }

        /* renamed from: a */
        public boolean mo7705a(CoordinatorLayout coordinatorLayout, V v, View view) {
            return false;
        }

        /* renamed from: a */
        public boolean mo7704a(CoordinatorLayout coordinatorLayout, V v, View view, float f, float f2) {
            return false;
        }

        /* renamed from: a */
        public boolean m7703a(CoordinatorLayout coordinatorLayout, V v, View view, float f, float f2, boolean z) {
            return false;
        }

        /* renamed from: b */
        public int m7695b(CoordinatorLayout coordinatorLayout, V v) {
            return -16777216;
        }

        /* renamed from: b */
        public boolean mo7602b(CoordinatorLayout coordinatorLayout, V v, MotionEvent motionEvent) {
            return false;
        }

        /* renamed from: b */
        public boolean mo7639b(CoordinatorLayout coordinatorLayout, V v, View view) {
            return false;
        }

        @Deprecated
        /* renamed from: b */
        public boolean mo7694b(CoordinatorLayout coordinatorLayout, V v, View view, View view2, int i) {
            return false;
        }

        /* renamed from: b */
        public boolean mo7693b(CoordinatorLayout coordinatorLayout, V v, View view, View view2, int i, int i2) {
            if (i2 == 0) {
                return mo7694b(coordinatorLayout, v, view, view2, i);
            }
            return false;
        }

        /* renamed from: c */
        public float m7692c(CoordinatorLayout coordinatorLayout, V v) {
            return 0.0f;
        }

        /* renamed from: c */
        public void m7691c(CoordinatorLayout coordinatorLayout, V v, View view) {
        }

        /* renamed from: d */
        public Parcelable mo7690d(CoordinatorLayout coordinatorLayout, V v) {
            return View.BaseSavedState.EMPTY_STATE;
        }

        @Deprecated
        /* renamed from: d */
        public void m7689d(CoordinatorLayout coordinatorLayout, V v, View view) {
        }

        public AbstractC0575c(Context context, AttributeSet attributeSet) {
        }

        /* renamed from: a */
        public void m7696a(CoordinatorLayout coordinatorLayout, V v, View view, View view2, int i, int i2) {
            if (i2 == 0) {
                m7697a(coordinatorLayout, (CoordinatorLayout) v, view, view2, i);
            }
        }

        /* renamed from: a */
        public void mo7702a(CoordinatorLayout coordinatorLayout, V v, View view, int i) {
            if (i == 0) {
                m7689d(coordinatorLayout, v, view);
            }
        }

        /* renamed from: a */
        public void mo7700a(CoordinatorLayout coordinatorLayout, V v, View view, int i, int i2, int i3, int i4, int i5) {
            if (i5 == 0) {
                mo7701a(coordinatorLayout, (CoordinatorLayout) v, view, i, i2, i3, i4);
            }
        }

        /* renamed from: a */
        public void mo7698a(CoordinatorLayout coordinatorLayout, V v, View view, int i, int i2, int[] iArr, int i3) {
            if (i3 == 0) {
                m7699a(coordinatorLayout, (CoordinatorLayout) v, view, i, i2, iArr);
            }
        }
    }

    @Retention(RetentionPolicy.RUNTIME)
    @Deprecated
    /* renamed from: android.support.design.widget.CoordinatorLayout$d */
    /* loaded from: classes.dex */
    public @interface InterfaceC0576d {
        Class<? extends AbstractC0575c> value();
    }

    /* renamed from: android.support.design.widget.CoordinatorLayout$e */
    /* loaded from: classes.dex */
    public class ViewGroup$OnHierarchyChangeListenerC0577e implements ViewGroup.OnHierarchyChangeListener {
        public ViewGroup$OnHierarchyChangeListenerC0577e() {
        }

        @Override // android.view.ViewGroup.OnHierarchyChangeListener
        public void onChildViewAdded(View view, View view2) {
            ViewGroup.OnHierarchyChangeListener onHierarchyChangeListener = CoordinatorLayout.this.f3322r;
            if (onHierarchyChangeListener != null) {
                onHierarchyChangeListener.onChildViewAdded(view, view2);
            }
        }

        @Override // android.view.ViewGroup.OnHierarchyChangeListener
        public void onChildViewRemoved(View view, View view2) {
            CoordinatorLayout.this.m7733b(2);
            ViewGroup.OnHierarchyChangeListener onHierarchyChangeListener = CoordinatorLayout.this.f3322r;
            if (onHierarchyChangeListener != null) {
                onHierarchyChangeListener.onChildViewRemoved(view, view2);
            }
        }
    }

    /* renamed from: android.support.design.widget.CoordinatorLayout$g */
    /* loaded from: classes.dex */
    public class ViewTreeObserver$OnPreDrawListenerC0579g implements ViewTreeObserver.OnPreDrawListener {
        public ViewTreeObserver$OnPreDrawListenerC0579g() {
        }

        @Override // android.view.ViewTreeObserver.OnPreDrawListener
        public boolean onPreDraw() {
            CoordinatorLayout.this.m7733b(0);
            return true;
        }
    }

    /* renamed from: android.support.design.widget.CoordinatorLayout$i */
    /* loaded from: classes.dex */
    public static class C0582i implements Comparator<View> {
        @Override // java.util.Comparator
        /* renamed from: a */
        public int compare(View view, View view2) {
            float m9415r = ViewCompat.m9415r(view);
            float m9415r2 = ViewCompat.m9415r(view2);
            if (m9415r > m9415r2) {
                return -1;
            }
            return m9415r < m9415r2 ? 1 : 0;
        }
    }

    static {
        Package r0 = CoordinatorLayout.class.getPackage();
        f3301u = r0 != null ? r0.getName() : null;
        if (Build.VERSION.SDK_INT >= 21) {
            f3304x = new C0582i();
        } else {
            f3304x = null;
        }
        f3302v = new Class[]{Context.class, AttributeSet.class};
        f3303w = new ThreadLocal<>();
        f3305y = new C0275l(12);
    }

    public CoordinatorLayout(Context context) {
        this(context, null);
    }

    /* renamed from: a */
    public static int m7751a(int i, int i2, int i3) {
        return i < i2 ? i2 : i > i3 ? i3 : i;
    }

    /* renamed from: a */
    public static void m7748a(Rect rect) {
        rect.setEmpty();
        f3305y.mo9623a(rect);
    }

    /* renamed from: c */
    public static int m7726c(int i) {
        if (i == 0) {
            return 17;
        }
        return i;
    }

    /* renamed from: d */
    public static int m7721d(int i) {
        if ((i & 7) == 0) {
            i |= 8388611;
        }
        return (i & 112) == 0 ? i | 48 : i;
    }

    /* renamed from: e */
    public static int m7717e(int i) {
        if (i == 0) {
            return 8388661;
        }
        return i;
    }

    /* renamed from: f */
    public static Rect m7714f() {
        Rect mo9624a = f3305y.mo9624a();
        return mo9624a == null ? new Rect() : mo9624a;
    }

    /* renamed from: b */
    public final WindowInsetsCompat m7732b(WindowInsetsCompat windowInsetsCompat) {
        if (ObjectsCompat.m9627a(this.f3319o, windowInsetsCompat)) {
            return windowInsetsCompat;
        }
        this.f3319o = windowInsetsCompat;
        boolean z = true;
        this.f3320p = windowInsetsCompat != null && windowInsetsCompat.m9571d() > 0;
        setWillNotDraw((this.f3320p || getBackground() != null) ? false : false);
        WindowInsetsCompat m7750a = m7750a(windowInsetsCompat);
        requestLayout();
        return m7750a;
    }

    /* renamed from: c */
    public final void m7727c() {
        this.f3306a.clear();
        this.f3307b.m9243a();
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = getChildAt(i);
            C0578f m7720d = m7720d(childAt);
            m7720d.m7683a(this, childAt);
            this.f3307b.m9242a((DirectedAcyclicGraph<View>) childAt);
            for (int i2 = 0; i2 < childCount; i2++) {
                if (i2 != i) {
                    View childAt2 = getChildAt(i2);
                    if (m7720d.m7682a(this, childAt, childAt2)) {
                        if (!this.f3307b.m9237b(childAt2)) {
                            this.f3307b.m9242a((DirectedAcyclicGraph<View>) childAt2);
                        }
                        this.f3307b.m9241a(childAt2, childAt);
                    }
                }
            }
        }
        this.f3306a.addAll(this.f3307b.m9236c());
        Collections.reverse(this.f3306a);
    }

    @Override // android.view.ViewGroup
    public boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return (layoutParams instanceof C0578f) && super.checkLayoutParams(layoutParams);
    }

    /* renamed from: d */
    public C0578f m7720d(View view) {
        C0578f c0578f = (C0578f) view.getLayoutParams();
        if (!c0578f.f3328b) {
            if (view instanceof InterfaceC0574b) {
                AbstractC0575c behavior = ((InterfaceC0574b) view).getBehavior();
                if (behavior == null) {
                    Log.e("CoordinatorLayout", "Attached behavior class is null");
                }
                c0578f.m7684a(behavior);
                c0578f.f3328b = true;
            } else {
                InterfaceC0576d interfaceC0576d = null;
                for (Class<?> cls = view.getClass(); cls != null; cls = cls.getSuperclass()) {
                    interfaceC0576d = (InterfaceC0576d) cls.getAnnotation(InterfaceC0576d.class);
                    if (interfaceC0576d != null) {
                        break;
                    }
                }
                if (interfaceC0576d != null) {
                    try {
                        c0578f.m7684a(interfaceC0576d.value().getDeclaredConstructor(new Class[0]).newInstance(new Object[0]));
                    } catch (Exception e) {
                        Log.e("CoordinatorLayout", "Default behavior class " + interfaceC0576d.value().getName() + " could not be instantiated. Did you forget a default constructor?", e);
                    }
                }
                c0578f.f3328b = true;
            }
        }
        return c0578f;
    }

    @Override // android.view.ViewGroup
    public boolean drawChild(Canvas canvas, View view, long j) {
        C0578f c0578f = (C0578f) view.getLayoutParams();
        AbstractC0575c abstractC0575c = c0578f.f3327a;
        if (abstractC0575c != null) {
            float m7692c = abstractC0575c.m7692c(this, view);
            if (m7692c > 0.0f) {
                if (this.f3311f == null) {
                    this.f3311f = new Paint();
                }
                this.f3311f.setColor(c0578f.f3327a.m7695b(this, view));
                this.f3311f.setAlpha(m7751a(Math.round(m7692c * 255.0f), 0, 255));
                int save = canvas.save();
                if (view.isOpaque()) {
                    canvas.clipRect(view.getLeft(), view.getTop(), view.getRight(), view.getBottom(), Region.Op.DIFFERENCE);
                }
                canvas.drawRect(getPaddingLeft(), getPaddingTop(), getWidth() - getPaddingRight(), getHeight() - getPaddingBottom(), this.f3311f);
                canvas.restoreToCount(save);
            }
        }
        return super.drawChild(canvas, view, j);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void drawableStateChanged() {
        super.drawableStateChanged();
        int[] drawableState = getDrawableState();
        Drawable drawable = this.f3321q;
        boolean z = false;
        if (drawable != null && drawable.isStateful()) {
            z = false | drawable.setState(drawableState);
        }
        if (z) {
            invalidate();
        }
    }

    /* renamed from: e */
    public final void m7715e(View view, int i) {
        C0578f c0578f = (C0578f) view.getLayoutParams();
        int i2 = c0578f.f3335i;
        if (i2 != i) {
            ViewCompat.m9435c(view, i - i2);
            c0578f.f3335i = i;
        }
    }

    public final List<View> getDependencySortedChildren() {
        m7727c();
        return Collections.unmodifiableList(this.f3306a);
    }

    public final WindowInsetsCompat getLastWindowInsets() {
        return this.f3319o;
    }

    @Override // android.view.ViewGroup
    public int getNestedScrollAxes() {
        return this.f3324t.m9482a();
    }

    public Drawable getStatusBarBackground() {
        return this.f3321q;
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
        m7735a(false);
        if (this.f3318n) {
            if (this.f3317m == null) {
                this.f3317m = new ViewTreeObserver$OnPreDrawListenerC0579g();
            }
            getViewTreeObserver().addOnPreDrawListener(this.f3317m);
        }
        if (this.f3319o == null && ViewCompat.m9426h(this)) {
            ViewCompat.m9463B(this);
        }
        this.f3313h = true;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        m7735a(false);
        if (this.f3318n && this.f3317m != null) {
            getViewTreeObserver().removeOnPreDrawListener(this.f3317m);
        }
        View view = this.f3316k;
        if (view != null) {
            onStopNestedScroll(view);
        }
        this.f3313h = false;
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (!this.f3320p || this.f3321q == null) {
            return;
        }
        WindowInsetsCompat windowInsetsCompat = this.f3319o;
        int m9571d = windowInsetsCompat != null ? windowInsetsCompat.m9571d() : 0;
        if (m9571d > 0) {
            this.f3321q.setBounds(0, 0, getWidth(), m9571d);
            this.f3321q.draw(canvas);
        }
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 0) {
            m7735a(true);
        }
        boolean m7746a = m7746a(motionEvent, 0);
        if (actionMasked == 1 || actionMasked == 3) {
            m7735a(true);
        }
        return m7746a;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        AbstractC0575c m7673d;
        int m9422k = ViewCompat.m9422k(this);
        int size = this.f3306a.size();
        for (int i5 = 0; i5 < size; i5++) {
            View view = this.f3306a.get(i5);
            if (view.getVisibility() != 8 && ((m7673d = ((C0578f) view.getLayoutParams()).m7673d()) == null || !m7673d.mo7643a(this, (CoordinatorLayout) view, m9422k))) {
                m7719d(view, m9422k);
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:43:0x0117, code lost:
        if (r0.mo7709a(r30, (android.support.design.widget.CoordinatorLayout) r20, r11, r21, r23, 0) == false) goto L33;
     */
    /* JADX WARN: Removed duplicated region for block: B:42:0x00f9  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x011a  */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void onMeasure(int r31, int r32) {
        /*
            Method dump skipped, instructions count: 388
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.design.widget.CoordinatorLayout.onMeasure(int, int):void");
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, p000a.p006b.p030g.p045k.NestedScrollingParent
    public boolean onNestedFling(View view, float f, float f2, boolean z) {
        AbstractC0575c m7673d;
        int childCount = getChildCount();
        boolean z2 = false;
        for (int i = 0; i < childCount; i++) {
            View childAt = getChildAt(i);
            if (childAt.getVisibility() != 8) {
                C0578f c0578f = (C0578f) childAt.getLayoutParams();
                if (c0578f.m7687a(0) && (m7673d = c0578f.m7673d()) != null) {
                    z2 |= m7673d.m7703a(this, (CoordinatorLayout) childAt, view, f, f2, z);
                }
            }
        }
        if (z2) {
            m7733b(1);
        }
        return z2;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, p000a.p006b.p030g.p045k.NestedScrollingParent
    public boolean onNestedPreFling(View view, float f, float f2) {
        AbstractC0575c m7673d;
        int childCount = getChildCount();
        boolean z = false;
        for (int i = 0; i < childCount; i++) {
            View childAt = getChildAt(i);
            if (childAt.getVisibility() != 8) {
                C0578f c0578f = (C0578f) childAt.getLayoutParams();
                if (c0578f.m7687a(0) && (m7673d = c0578f.m7673d()) != null) {
                    z |= m7673d.mo7704a(this, (CoordinatorLayout) childAt, view, f, f2);
                }
            }
        }
        return z;
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
    public void onRestoreInstanceState(Parcelable parcelable) {
        Parcelable parcelable2;
        if (!(parcelable instanceof C0580h)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        C0580h c0580h = (C0580h) parcelable;
        super.onRestoreInstanceState(c0580h.m9588a());
        SparseArray<Parcelable> sparseArray = c0580h.f3345c;
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = getChildAt(i);
            int id = childAt.getId();
            AbstractC0575c m7673d = m7720d(childAt).m7673d();
            if (id != -1 && m7673d != null && (parcelable2 = sparseArray.get(id)) != null) {
                m7673d.mo7706a(this, (CoordinatorLayout) childAt, parcelable2);
            }
        }
    }

    @Override // android.view.View
    public Parcelable onSaveInstanceState() {
        Parcelable mo7690d;
        C0580h c0580h = new C0580h(super.onSaveInstanceState());
        SparseArray<Parcelable> sparseArray = new SparseArray<>();
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = getChildAt(i);
            int id = childAt.getId();
            AbstractC0575c m7673d = ((C0578f) childAt.getLayoutParams()).m7673d();
            if (id != -1 && m7673d != null && (mo7690d = m7673d.mo7690d(this, childAt)) != null) {
                sparseArray.append(id, mo7690d);
            }
        }
        c0580h.f3345c = sparseArray;
        return c0580h;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, p000a.p006b.p030g.p045k.NestedScrollingParent
    public boolean onStartNestedScroll(View view, View view2, int i) {
        return mo7347b(view, view2, i, 0);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, p000a.p006b.p030g.p045k.NestedScrollingParent
    public void onStopNestedScroll(View view) {
        mo7359a(view, 0);
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
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean onTouchEvent(android.view.MotionEvent r18) {
        /*
            r17 = this;
            r0 = r17
            r1 = r18
            int r2 = r18.getActionMasked()
            android.view.View r3 = r0.f3315j
            r4 = 1
            r5 = 0
            if (r3 != 0) goto L15
            boolean r3 = r0.m7746a(r1, r4)
            if (r3 == 0) goto L2b
            goto L16
        L15:
            r3 = 0
        L16:
            android.view.View r6 = r0.f3315j
            android.view.ViewGroup$LayoutParams r6 = r6.getLayoutParams()
            android.support.design.widget.CoordinatorLayout$f r6 = (android.support.design.widget.CoordinatorLayout.C0578f) r6
            android.support.design.widget.CoordinatorLayout$c r6 = r6.m7673d()
            if (r6 == 0) goto L2b
            android.view.View r7 = r0.f3315j
            boolean r6 = r6.mo7602b(r0, r7, r1)
            goto L2c
        L2b:
            r6 = 0
        L2c:
            android.view.View r7 = r0.f3315j
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
            r0.m7735a(r5)
        L57:
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.design.widget.CoordinatorLayout.onTouchEvent(android.view.MotionEvent):boolean");
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public boolean requestChildRectangleOnScreen(View view, Rect rect, boolean z) {
        AbstractC0575c m7673d = ((C0578f) view.getLayoutParams()).m7673d();
        if (m7673d == null || !m7673d.mo7707a(this, (CoordinatorLayout) view, rect, z)) {
            return super.requestChildRectangleOnScreen(view, rect, z);
        }
        return true;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void requestDisallowInterceptTouchEvent(boolean z) {
        super.requestDisallowInterceptTouchEvent(z);
        if (!z || this.f3312g) {
            return;
        }
        m7735a(false);
        this.f3312g = true;
    }

    @Override // android.view.View
    public void setFitsSystemWindows(boolean z) {
        super.setFitsSystemWindows(z);
        m7718e();
    }

    @Override // android.view.ViewGroup
    public void setOnHierarchyChangeListener(ViewGroup.OnHierarchyChangeListener onHierarchyChangeListener) {
        this.f3322r = onHierarchyChangeListener;
    }

    public void setStatusBarBackground(Drawable drawable) {
        Drawable drawable2 = this.f3321q;
        if (drawable2 != drawable) {
            if (drawable2 != null) {
                drawable2.setCallback(null);
            }
            this.f3321q = drawable != null ? drawable.mutate() : null;
            Drawable drawable3 = this.f3321q;
            if (drawable3 != null) {
                if (drawable3.isStateful()) {
                    this.f3321q.setState(getDrawableState());
                }
                DrawableCompat.m9863a(this.f3321q, ViewCompat.m9422k(this));
                this.f3321q.setVisible(getVisibility() == 0, false);
                this.f3321q.setCallback(this);
            }
            ViewCompat.m9464A(this);
        }
    }

    public void setStatusBarBackgroundColor(int i) {
        setStatusBarBackground(new ColorDrawable(i));
    }

    public void setStatusBarBackgroundResource(int i) {
        setStatusBarBackground(i != 0 ? ContextCompat.m10016c(getContext(), i) : null);
    }

    @Override // android.view.View
    public void setVisibility(int i) {
        super.setVisibility(i);
        boolean z = i == 0;
        Drawable drawable = this.f3321q;
        if (drawable == null || drawable.isVisible() == z) {
            return;
        }
        this.f3321q.setVisible(z, false);
    }

    @Override // android.view.View
    public boolean verifyDrawable(Drawable drawable) {
        return super.verifyDrawable(drawable) || drawable == this.f3321q;
    }

    public CoordinatorLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, C0036a.coordinatorLayoutStyle);
    }

    @Override // android.view.ViewGroup
    public C0578f generateDefaultLayoutParams() {
        return new C0578f(-2, -2);
    }

    /* renamed from: android.support.design.widget.CoordinatorLayout$f */
    /* loaded from: classes.dex */
    public static class C0578f extends ViewGroup.MarginLayoutParams {

        /* renamed from: a */
        public AbstractC0575c f3327a;

        /* renamed from: b */
        public boolean f3328b;

        /* renamed from: c */
        public int f3329c;

        /* renamed from: d */
        public int f3330d;

        /* renamed from: e */
        public int f3331e;

        /* renamed from: f */
        public int f3332f;

        /* renamed from: g */
        public int f3333g;

        /* renamed from: h */
        public int f3334h;

        /* renamed from: i */
        public int f3335i;

        /* renamed from: j */
        public int f3336j;

        /* renamed from: k */
        public View f3337k;

        /* renamed from: l */
        public View f3338l;

        /* renamed from: m */
        public boolean f3339m;

        /* renamed from: n */
        public boolean f3340n;

        /* renamed from: o */
        public boolean f3341o;

        /* renamed from: p */
        public boolean f3342p;

        /* renamed from: q */
        public final Rect f3343q;

        public C0578f(int i, int i2) {
            super(i, i2);
            this.f3328b = false;
            this.f3329c = 0;
            this.f3330d = 0;
            this.f3331e = -1;
            this.f3332f = -1;
            this.f3333g = 0;
            this.f3334h = 0;
            this.f3343q = new Rect();
        }

        /* renamed from: a */
        public void m7684a(AbstractC0575c abstractC0575c) {
            AbstractC0575c abstractC0575c2 = this.f3327a;
            if (abstractC0575c2 != abstractC0575c) {
                if (abstractC0575c2 != null) {
                    abstractC0575c2.m7711a();
                }
                this.f3327a = abstractC0575c;
                this.f3328b = true;
                if (abstractC0575c != null) {
                    abstractC0575c.mo7649a(this);
                }
            }
        }

        /* renamed from: b */
        public boolean m7678b() {
            if (this.f3327a == null) {
                this.f3339m = false;
            }
            return this.f3339m;
        }

        /* renamed from: c */
        public int m7674c() {
            return this.f3332f;
        }

        /* renamed from: d */
        public AbstractC0575c m7673d() {
            return this.f3327a;
        }

        /* renamed from: e */
        public boolean m7672e() {
            return this.f3342p;
        }

        /* renamed from: f */
        public Rect m7671f() {
            return this.f3343q;
        }

        /* renamed from: g */
        public void m7670g() {
            this.f3342p = false;
        }

        /* renamed from: h */
        public void m7669h() {
            this.f3339m = false;
        }

        /* renamed from: b */
        public boolean m7676b(CoordinatorLayout coordinatorLayout, View view) {
            boolean z = this.f3339m;
            if (z) {
                return true;
            }
            AbstractC0575c abstractC0575c = this.f3327a;
            boolean m7710a = (abstractC0575c != null ? abstractC0575c.m7710a(coordinatorLayout, view) : false) | z;
            this.f3339m = m7710a;
            return m7710a;
        }

        /* renamed from: a */
        public void m7685a(Rect rect) {
            this.f3343q.set(rect);
        }

        /* renamed from: a */
        public boolean m7688a() {
            return this.f3337k == null && this.f3332f != -1;
        }

        /* renamed from: b */
        public void m7677b(int i) {
            m7686a(i, false);
        }

        /* renamed from: a */
        public void m7686a(int i, boolean z) {
            if (i == 0) {
                this.f3340n = z;
            } else if (i != 1) {
            } else {
                this.f3341o = z;
            }
        }

        /* renamed from: b */
        public final boolean m7675b(View view, CoordinatorLayout coordinatorLayout) {
            if (this.f3337k.getId() != this.f3332f) {
                return false;
            }
            View view2 = this.f3337k;
            for (ViewParent parent = view2.getParent(); parent != coordinatorLayout; parent = parent.getParent()) {
                if (parent != null && parent != view) {
                    if (parent instanceof View) {
                        view2 = (View) parent;
                    }
                } else {
                    this.f3338l = null;
                    this.f3337k = null;
                    return false;
                }
            }
            this.f3338l = view2;
            return true;
        }

        public C0578f(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            this.f3328b = false;
            this.f3329c = 0;
            this.f3330d = 0;
            this.f3331e = -1;
            this.f3332f = -1;
            this.f3333g = 0;
            this.f3334h = 0;
            this.f3343q = new Rect();
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C0038c.CoordinatorLayout_Layout);
            this.f3329c = obtainStyledAttributes.getInteger(C0038c.CoordinatorLayout_Layout_android_layout_gravity, 0);
            this.f3332f = obtainStyledAttributes.getResourceId(C0038c.CoordinatorLayout_Layout_layout_anchor, -1);
            this.f3330d = obtainStyledAttributes.getInteger(C0038c.CoordinatorLayout_Layout_layout_anchorGravity, 0);
            this.f3331e = obtainStyledAttributes.getInteger(C0038c.CoordinatorLayout_Layout_layout_keyline, -1);
            this.f3333g = obtainStyledAttributes.getInt(C0038c.CoordinatorLayout_Layout_layout_insetEdge, 0);
            this.f3334h = obtainStyledAttributes.getInt(C0038c.CoordinatorLayout_Layout_layout_dodgeInsetEdges, 0);
            this.f3328b = obtainStyledAttributes.hasValue(C0038c.CoordinatorLayout_Layout_layout_behavior);
            if (this.f3328b) {
                this.f3327a = CoordinatorLayout.m7749a(context, attributeSet, obtainStyledAttributes.getString(C0038c.CoordinatorLayout_Layout_layout_behavior));
            }
            obtainStyledAttributes.recycle();
            AbstractC0575c abstractC0575c = this.f3327a;
            if (abstractC0575c != null) {
                abstractC0575c.mo7649a(this);
            }
        }

        /* renamed from: a */
        public boolean m7687a(int i) {
            if (i != 0) {
                if (i != 1) {
                    return false;
                }
                return this.f3341o;
            }
            return this.f3340n;
        }

        /* renamed from: a */
        public void m7679a(boolean z) {
            this.f3342p = z;
        }

        /* renamed from: a */
        public boolean m7682a(CoordinatorLayout coordinatorLayout, View view, View view2) {
            AbstractC0575c abstractC0575c;
            return view2 == this.f3338l || m7681a(view2, ViewCompat.m9422k(coordinatorLayout)) || ((abstractC0575c = this.f3327a) != null && abstractC0575c.mo7705a(coordinatorLayout, (CoordinatorLayout) view, view2));
        }

        /* renamed from: a */
        public View m7683a(CoordinatorLayout coordinatorLayout, View view) {
            if (this.f3332f == -1) {
                this.f3338l = null;
                this.f3337k = null;
                return null;
            }
            if (this.f3337k == null || !m7675b(view, coordinatorLayout)) {
                m7680a(view, coordinatorLayout);
            }
            return this.f3337k;
        }

        /* renamed from: a */
        public final void m7680a(View view, CoordinatorLayout coordinatorLayout) {
            this.f3337k = coordinatorLayout.findViewById(this.f3332f);
            View view2 = this.f3337k;
            if (view2 == null) {
                if (coordinatorLayout.isInEditMode()) {
                    this.f3338l = null;
                    this.f3337k = null;
                    return;
                }
                throw new IllegalStateException("Could not find CoordinatorLayout descendant view with id " + coordinatorLayout.getResources().getResourceName(this.f3332f) + " to anchor view " + view);
            } else if (view2 == coordinatorLayout) {
                if (coordinatorLayout.isInEditMode()) {
                    this.f3338l = null;
                    this.f3337k = null;
                    return;
                }
                throw new IllegalStateException("View can not be anchored to the the parent CoordinatorLayout");
            } else {
                for (ViewParent parent = view2.getParent(); parent != coordinatorLayout && parent != null; parent = parent.getParent()) {
                    if (parent == view) {
                        if (coordinatorLayout.isInEditMode()) {
                            this.f3338l = null;
                            this.f3337k = null;
                            return;
                        }
                        throw new IllegalStateException("Anchor must not be a descendant of the anchored view");
                    }
                    if (parent instanceof View) {
                        view2 = (View) parent;
                    }
                }
                this.f3338l = view2;
            }
        }

        public C0578f(C0578f c0578f) {
            super((ViewGroup.MarginLayoutParams) c0578f);
            this.f3328b = false;
            this.f3329c = 0;
            this.f3330d = 0;
            this.f3331e = -1;
            this.f3332f = -1;
            this.f3333g = 0;
            this.f3334h = 0;
            this.f3343q = new Rect();
        }

        /* renamed from: a */
        public final boolean m7681a(View view, int i) {
            int m9579a = GravityCompat.m9579a(((C0578f) view.getLayoutParams()).f3333g, i);
            return m9579a != 0 && (GravityCompat.m9579a(this.f3334h, i) & m9579a) == m9579a;
        }

        public C0578f(ViewGroup.MarginLayoutParams marginLayoutParams) {
            super(marginLayoutParams);
            this.f3328b = false;
            this.f3329c = 0;
            this.f3330d = 0;
            this.f3331e = -1;
            this.f3332f = -1;
            this.f3333g = 0;
            this.f3334h = 0;
            this.f3343q = new Rect();
        }

        public C0578f(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
            this.f3328b = false;
            this.f3329c = 0;
            this.f3330d = 0;
            this.f3331e = -1;
            this.f3332f = -1;
            this.f3333g = 0;
            this.f3334h = 0;
            this.f3343q = new Rect();
        }
    }

    public CoordinatorLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        TypedArray obtainStyledAttributes;
        this.f3306a = new ArrayList();
        this.f3307b = new DirectedAcyclicGraph<>();
        this.f3308c = new ArrayList();
        this.f3309d = new ArrayList();
        this.f3310e = new int[2];
        this.f3324t = new NestedScrollingParentHelper(this);
        if (i == 0) {
            obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C0038c.CoordinatorLayout, 0, C0037b.Widget_Support_CoordinatorLayout);
        } else {
            obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C0038c.CoordinatorLayout, i, 0);
        }
        int resourceId = obtainStyledAttributes.getResourceId(C0038c.CoordinatorLayout_keylines, 0);
        if (resourceId != 0) {
            Resources resources = context.getResources();
            this.f3314i = resources.getIntArray(resourceId);
            float f = resources.getDisplayMetrics().density;
            int length = this.f3314i.length;
            for (int i2 = 0; i2 < length; i2++) {
                int[] iArr = this.f3314i;
                iArr[i2] = (int) (iArr[i2] * f);
            }
        }
        this.f3321q = obtainStyledAttributes.getDrawable(C0038c.CoordinatorLayout_statusBarBackground);
        obtainStyledAttributes.recycle();
        m7718e();
        super.setOnHierarchyChangeListener(new ViewGroup$OnHierarchyChangeListenerC0577e());
    }

    /* renamed from: a */
    public final void m7735a(boolean z) {
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = getChildAt(i);
            AbstractC0575c m7673d = ((C0578f) childAt.getLayoutParams()).m7673d();
            if (m7673d != null) {
                long uptimeMillis = SystemClock.uptimeMillis();
                MotionEvent obtain = MotionEvent.obtain(uptimeMillis, uptimeMillis, 3, 0.0f, 0.0f, 0);
                if (z) {
                    m7673d.mo7608a(this, (CoordinatorLayout) childAt, obtain);
                } else {
                    m7673d.mo7602b(this, (CoordinatorLayout) childAt, obtain);
                }
                obtain.recycle();
            }
        }
        for (int i2 = 0; i2 < childCount; i2++) {
            ((C0578f) getChildAt(i2).getLayoutParams()).m7669h();
        }
        this.f3315j = null;
        this.f3312g = false;
    }

    /* renamed from: f */
    public final void m7713f(View view, int i) {
        C0578f c0578f = (C0578f) view.getLayoutParams();
        int i2 = c0578f.f3336j;
        if (i2 != i) {
            ViewCompat.m9433d(view, i - i2);
            c0578f.f3336j = i;
        }
    }

    @Override // android.view.ViewGroup
    public C0578f generateLayoutParams(AttributeSet attributeSet) {
        return new C0578f(getContext(), attributeSet);
    }

    @Override // android.view.ViewGroup
    public C0578f generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        if (layoutParams instanceof C0578f) {
            return new C0578f((C0578f) layoutParams);
        }
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            return new C0578f((ViewGroup.MarginLayoutParams) layoutParams);
        }
        return new C0578f(layoutParams);
    }

    /* renamed from: e */
    public final boolean m7716e(View view) {
        return this.f3307b.m9233e(view);
    }

    /* renamed from: e */
    public final void m7718e() {
        if (Build.VERSION.SDK_INT < 21) {
            return;
        }
        if (ViewCompat.m9426h(this)) {
            if (this.f3323s == null) {
                this.f3323s = new C0573a();
            }
            ViewCompat.m9452a(this, this.f3323s);
            setSystemUiVisibility(1280);
            return;
        }
        ViewCompat.m9452a(this, (OnApplyWindowInsetsListener) null);
    }

    /* renamed from: android.support.design.widget.CoordinatorLayout$h */
    /* loaded from: classes.dex */
    public static class C0580h extends AbsSavedState {
        public static final Parcelable.Creator<C0580h> CREATOR = new C0581a();

        /* renamed from: c */
        public SparseArray<Parcelable> f3345c;

        /* renamed from: android.support.design.widget.CoordinatorLayout$h$a */
        /* loaded from: classes.dex */
        public static class C0581a implements Parcelable.ClassLoaderCreator<C0580h> {
            @Override // android.os.Parcelable.Creator
            public C0580h[] newArray(int i) {
                return new C0580h[i];
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.ClassLoaderCreator
            public C0580h createFromParcel(Parcel parcel, ClassLoader classLoader) {
                return new C0580h(parcel, classLoader);
            }

            @Override // android.os.Parcelable.Creator
            public C0580h createFromParcel(Parcel parcel) {
                return new C0580h(parcel, null);
            }
        }

        public C0580h(Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            int readInt = parcel.readInt();
            int[] iArr = new int[readInt];
            parcel.readIntArray(iArr);
            Parcelable[] readParcelableArray = parcel.readParcelableArray(classLoader);
            this.f3345c = new SparseArray<>(readInt);
            for (int i = 0; i < readInt; i++) {
                this.f3345c.append(iArr[i], readParcelableArray[i]);
            }
        }

        @Override // p000a.p006b.p030g.p045k.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            SparseArray<Parcelable> sparseArray = this.f3345c;
            int size = sparseArray != null ? sparseArray.size() : 0;
            parcel.writeInt(size);
            int[] iArr = new int[size];
            Parcelable[] parcelableArr = new Parcelable[size];
            for (int i2 = 0; i2 < size; i2++) {
                iArr[i2] = this.f3345c.keyAt(i2);
                parcelableArr[i2] = this.f3345c.valueAt(i2);
            }
            parcel.writeIntArray(iArr);
            parcel.writeParcelableArray(parcelableArr, i);
        }

        public C0580h(Parcelable parcelable) {
            super(parcelable);
        }
    }

    /* renamed from: b */
    public void m7728b(View view, Rect rect) {
        rect.set(((C0578f) view.getLayoutParams()).m7671f());
    }

    /* renamed from: b */
    public final void m7729b(View view, int i, int i2) {
        C0578f c0578f = (C0578f) view.getLayoutParams();
        int m9579a = GravityCompat.m9579a(m7717e(c0578f.f3329c), i2);
        int i3 = m9579a & 7;
        int i4 = m9579a & 112;
        int width = getWidth();
        int height = getHeight();
        int measuredWidth = view.getMeasuredWidth();
        int measuredHeight = view.getMeasuredHeight();
        if (i2 == 1) {
            i = width - i;
        }
        int m7752a = m7752a(i) - measuredWidth;
        int i5 = 0;
        if (i3 == 1) {
            m7752a += measuredWidth / 2;
        } else if (i3 == 5) {
            m7752a += measuredWidth;
        }
        if (i4 == 16) {
            i5 = 0 + (measuredHeight / 2);
        } else if (i4 == 80) {
            i5 = measuredHeight + 0;
        }
        int max = Math.max(getPaddingLeft() + ((ViewGroup.MarginLayoutParams) c0578f).leftMargin, Math.min(m7752a, ((width - getPaddingRight()) - measuredWidth) - ((ViewGroup.MarginLayoutParams) c0578f).rightMargin));
        int max2 = Math.max(getPaddingTop() + ((ViewGroup.MarginLayoutParams) c0578f).topMargin, Math.min(i5, ((height - getPaddingBottom()) - measuredHeight) - ((ViewGroup.MarginLayoutParams) c0578f).bottomMargin));
        view.layout(max, max2, measuredWidth + max, measuredHeight + max2);
    }

    /* renamed from: c */
    public void m7723c(View view, Rect rect) {
        ((C0578f) view.getLayoutParams()).m7685a(rect);
    }

    /* renamed from: d */
    public void m7719d(View view, int i) {
        C0578f c0578f = (C0578f) view.getLayoutParams();
        if (!c0578f.m7688a()) {
            View view2 = c0578f.f3337k;
            if (view2 != null) {
                m7738a(view, view2, i);
                return;
            }
            int i2 = c0578f.f3331e;
            if (i2 >= 0) {
                m7729b(view, i2, i);
                return;
            } else {
                m7730b(view, i);
                return;
            }
        }
        throw new IllegalStateException("An anchor may not be changed after CoordinatorLayout measurement begins before layout is complete.");
    }

    /* renamed from: a */
    public final void m7736a(List<View> list) {
        list.clear();
        boolean isChildrenDrawingOrderEnabled = isChildrenDrawingOrderEnabled();
        int childCount = getChildCount();
        for (int i = childCount - 1; i >= 0; i--) {
            list.add(getChildAt(isChildrenDrawingOrderEnabled ? getChildDrawingOrder(childCount, i) : i));
        }
        Comparator<View> comparator = f3304x;
        if (comparator != null) {
            Collections.sort(list, comparator);
        }
    }

    /* renamed from: c */
    public List<View> m7725c(View view) {
        List m9235c = this.f3307b.m9235c(view);
        this.f3309d.clear();
        if (m9235c != null) {
            this.f3309d.addAll(m9235c);
        }
        return this.f3309d;
    }

    /* renamed from: c */
    public void m7724c(View view, int i) {
        AbstractC0575c m7673d;
        C0578f c0578f = (C0578f) view.getLayoutParams();
        if (c0578f.f3337k != null) {
            Rect m7714f = m7714f();
            Rect m7714f2 = m7714f();
            Rect m7714f3 = m7714f();
            m7740a(c0578f.f3337k, m7714f);
            boolean z = false;
            m7737a(view, false, m7714f2);
            int measuredWidth = view.getMeasuredWidth();
            int measuredHeight = view.getMeasuredHeight();
            m7741a(view, i, m7714f, m7714f3, c0578f, measuredWidth, measuredHeight);
            z = (m7714f3.left == m7714f2.left && m7714f3.top == m7714f2.top) ? true : true;
            m7747a(c0578f, m7714f3, measuredWidth, measuredHeight);
            int i2 = m7714f3.left - m7714f2.left;
            int i3 = m7714f3.top - m7714f2.top;
            if (i2 != 0) {
                ViewCompat.m9435c(view, i2);
            }
            if (i3 != 0) {
                ViewCompat.m9433d(view, i3);
            }
            if (z && (m7673d = c0578f.m7673d()) != null) {
                m7673d.mo7639b(this, (CoordinatorLayout) view, c0578f.f3337k);
            }
            m7748a(m7714f);
            m7748a(m7714f2);
            m7748a(m7714f3);
        }
    }

    /* renamed from: d */
    public void m7722d() {
        if (this.f3313h && this.f3317m != null) {
            getViewTreeObserver().removeOnPreDrawListener(this.f3317m);
        }
        this.f3318n = false;
    }

    /* renamed from: a */
    public final boolean m7746a(MotionEvent motionEvent, int i) {
        int actionMasked = motionEvent.getActionMasked();
        List<View> list = this.f3308c;
        m7736a(list);
        int size = list.size();
        MotionEvent motionEvent2 = null;
        boolean z = false;
        boolean z2 = false;
        for (int i2 = 0; i2 < size; i2++) {
            View view = list.get(i2);
            C0578f c0578f = (C0578f) view.getLayoutParams();
            AbstractC0575c m7673d = c0578f.m7673d();
            boolean z3 = true;
            if (!(z || z2) || actionMasked == 0) {
                if (!z && m7673d != null) {
                    if (i == 0) {
                        z = m7673d.mo7608a(this, (CoordinatorLayout) view, motionEvent);
                    } else if (i == 1) {
                        z = m7673d.mo7602b(this, (CoordinatorLayout) view, motionEvent);
                    }
                    if (z) {
                        this.f3315j = view;
                    }
                }
                boolean m7678b = c0578f.m7678b();
                boolean m7676b = c0578f.m7676b(this, view);
                z3 = (!m7676b || m7678b) ? false : false;
                if (m7676b && !z3) {
                    break;
                }
                z2 = z3;
            } else if (m7673d != null) {
                if (motionEvent2 == null) {
                    long uptimeMillis = SystemClock.uptimeMillis();
                    motionEvent2 = MotionEvent.obtain(uptimeMillis, uptimeMillis, 3, 0.0f, 0.0f, 0);
                }
                if (i == 0) {
                    m7673d.mo7608a(this, (CoordinatorLayout) view, motionEvent2);
                } else if (i == 1) {
                    m7673d.mo7602b(this, (CoordinatorLayout) view, motionEvent2);
                }
            }
        }
        list.clear();
        return z;
    }

    /* renamed from: b */
    public final void m7730b(View view, int i) {
        C0578f c0578f = (C0578f) view.getLayoutParams();
        Rect m7714f = m7714f();
        m7714f.set(getPaddingLeft() + ((ViewGroup.MarginLayoutParams) c0578f).leftMargin, getPaddingTop() + ((ViewGroup.MarginLayoutParams) c0578f).topMargin, (getWidth() - getPaddingRight()) - ((ViewGroup.MarginLayoutParams) c0578f).rightMargin, (getHeight() - getPaddingBottom()) - ((ViewGroup.MarginLayoutParams) c0578f).bottomMargin);
        if (this.f3319o != null && ViewCompat.m9426h(this) && !ViewCompat.m9426h(view)) {
            m7714f.left += this.f3319o.m9573b();
            m7714f.top += this.f3319o.m9571d();
            m7714f.right -= this.f3319o.m9572c();
            m7714f.bottom -= this.f3319o.m9577a();
        }
        Rect m7714f2 = m7714f();
        GravityCompat.m9578a(m7721d(c0578f.f3329c), view.getMeasuredWidth(), view.getMeasuredHeight(), m7714f, m7714f2, i);
        view.layout(m7714f2.left, m7714f2.top, m7714f2.right, m7714f2.bottom);
        m7748a(m7714f);
        m7748a(m7714f2);
    }

    /* renamed from: a */
    public final int m7752a(int i) {
        int[] iArr = this.f3314i;
        if (iArr == null) {
            Log.e("CoordinatorLayout", "No keylines defined for " + this + " - attempted index lookup " + i);
            return 0;
        } else if (i >= 0 && i < iArr.length) {
            return iArr[i];
        } else {
            Log.e("CoordinatorLayout", "Keyline index " + i + " out of range for " + this);
            return 0;
        }
    }

    /* renamed from: a */
    public static AbstractC0575c m7749a(Context context, AttributeSet attributeSet, String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        if (str.startsWith(".")) {
            str = context.getPackageName() + str;
        } else if (str.indexOf(46) < 0 && !TextUtils.isEmpty(f3301u)) {
            str = f3301u + '.' + str;
        }
        try {
            Map<String, Constructor<AbstractC0575c>> map = f3303w.get();
            if (map == null) {
                map = new HashMap<>();
                f3303w.set(map);
            }
            Constructor<AbstractC0575c> constructor = map.get(str);
            if (constructor == null) {
                constructor = context.getClassLoader().loadClass(str).getConstructor(f3302v);
                constructor.setAccessible(true);
                map.put(str, constructor);
            }
            return (AbstractC0575c) constructor.newInstance(context, attributeSet);
        } catch (Exception e) {
            throw new RuntimeException("Could not inflate Behavior subclass " + str, e);
        }
    }

    /* renamed from: b */
    public final void m7733b(int i) {
        boolean z;
        int m9422k = ViewCompat.m9422k(this);
        int size = this.f3306a.size();
        Rect m7714f = m7714f();
        Rect m7714f2 = m7714f();
        Rect m7714f3 = m7714f();
        for (int i2 = 0; i2 < size; i2++) {
            View view = this.f3306a.get(i2);
            C0578f c0578f = (C0578f) view.getLayoutParams();
            if (i != 0 || view.getVisibility() != 8) {
                for (int i3 = 0; i3 < i2; i3++) {
                    if (c0578f.f3338l == this.f3306a.get(i3)) {
                        m7724c(view, m9422k);
                    }
                }
                m7737a(view, true, m7714f2);
                if (c0578f.f3333g != 0 && !m7714f2.isEmpty()) {
                    int m9579a = GravityCompat.m9579a(c0578f.f3333g, m9422k);
                    int i4 = m9579a & 112;
                    if (i4 == 48) {
                        m7714f.top = Math.max(m7714f.top, m7714f2.bottom);
                    } else if (i4 == 80) {
                        m7714f.bottom = Math.max(m7714f.bottom, getHeight() - m7714f2.top);
                    }
                    int i5 = m9579a & 7;
                    if (i5 == 3) {
                        m7714f.left = Math.max(m7714f.left, m7714f2.right);
                    } else if (i5 == 5) {
                        m7714f.right = Math.max(m7714f.right, getWidth() - m7714f2.left);
                    }
                }
                if (c0578f.f3334h != 0 && view.getVisibility() == 0) {
                    m7739a(view, m7714f, m9422k);
                }
                if (i != 2) {
                    m7728b(view, m7714f3);
                    if (!m7714f3.equals(m7714f2)) {
                        m7723c(view, m7714f2);
                    }
                }
                for (int i6 = i2 + 1; i6 < size; i6++) {
                    View view2 = this.f3306a.get(i6);
                    C0578f c0578f2 = (C0578f) view2.getLayoutParams();
                    AbstractC0575c m7673d = c0578f2.m7673d();
                    if (m7673d != null && m7673d.mo7705a(this, (CoordinatorLayout) view2, view)) {
                        if (i == 0 && c0578f2.m7672e()) {
                            c0578f2.m7670g();
                        } else {
                            if (i != 2) {
                                z = m7673d.mo7639b(this, (CoordinatorLayout) view2, view);
                            } else {
                                m7673d.m7691c(this, view2, view);
                                z = true;
                            }
                            if (i == 1) {
                                c0578f2.m7679a(z);
                            }
                        }
                    }
                }
            }
        }
        m7748a(m7714f);
        m7748a(m7714f2);
        m7748a(m7714f3);
    }

    /* renamed from: a */
    public void m7740a(View view, Rect rect) {
        C0321t.m9158a(this, view, rect);
    }

    /* renamed from: a */
    public void m7743a(View view, int i, int i2, int i3, int i4) {
        measureChildWithMargins(view, i, i2, i3, i4);
    }

    /* renamed from: a */
    public final WindowInsetsCompat m7750a(WindowInsetsCompat windowInsetsCompat) {
        AbstractC0575c m7673d;
        if (windowInsetsCompat.m9570e()) {
            return windowInsetsCompat;
        }
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = getChildAt(i);
            if (ViewCompat.m9426h(childAt) && (m7673d = ((C0578f) childAt.getLayoutParams()).m7673d()) != null) {
                windowInsetsCompat = m7673d.m7708a(this, (CoordinatorLayout) childAt, windowInsetsCompat);
                if (windowInsetsCompat.m9570e()) {
                    break;
                }
            }
        }
        return windowInsetsCompat;
    }

    /* renamed from: a */
    public void m7737a(View view, boolean z, Rect rect) {
        if (view.isLayoutRequested() || view.getVisibility() == 8) {
            rect.setEmpty();
        } else if (z) {
            m7740a(view, rect);
        } else {
            rect.set(view.getLeft(), view.getTop(), view.getRight(), view.getBottom());
        }
    }

    /* renamed from: a */
    public final void m7741a(View view, int i, Rect rect, Rect rect2, C0578f c0578f, int i2, int i3) {
        int width;
        int height;
        int m9579a = GravityCompat.m9579a(m7726c(c0578f.f3329c), i);
        int m9579a2 = GravityCompat.m9579a(m7721d(c0578f.f3330d), i);
        int i4 = m9579a & 7;
        int i5 = m9579a & 112;
        int i6 = m9579a2 & 7;
        int i7 = m9579a2 & 112;
        if (i6 == 1) {
            width = rect.left + (rect.width() / 2);
        } else if (i6 != 5) {
            width = rect.left;
        } else {
            width = rect.right;
        }
        if (i7 == 16) {
            height = rect.top + (rect.height() / 2);
        } else if (i7 != 80) {
            height = rect.top;
        } else {
            height = rect.bottom;
        }
        if (i4 == 1) {
            width -= i2 / 2;
        } else if (i4 != 5) {
            width -= i2;
        }
        if (i5 == 16) {
            height -= i3 / 2;
        } else if (i5 != 80) {
            height -= i3;
        }
        rect2.set(width, height, i2 + width, i3 + height);
    }

    /* renamed from: b */
    public List<View> m7731b(View view) {
        List<View> m9234d = this.f3307b.m9234d(view);
        this.f3309d.clear();
        if (m9234d != null) {
            this.f3309d.addAll(m9234d);
        }
        return this.f3309d;
    }

    /* renamed from: b */
    public void m7734b() {
        int childCount = getChildCount();
        boolean z = false;
        int i = 0;
        while (true) {
            if (i >= childCount) {
                break;
            } else if (m7716e(getChildAt(i))) {
                z = true;
                break;
            } else {
                i++;
            }
        }
        if (z != this.f3318n) {
            if (z) {
                m7753a();
            } else {
                m7722d();
            }
        }
    }

    /* renamed from: a */
    public final void m7747a(C0578f c0578f, Rect rect, int i, int i2) {
        int width = getWidth();
        int height = getHeight();
        int max = Math.max(getPaddingLeft() + ((ViewGroup.MarginLayoutParams) c0578f).leftMargin, Math.min(rect.left, ((width - getPaddingRight()) - i) - ((ViewGroup.MarginLayoutParams) c0578f).rightMargin));
        int max2 = Math.max(getPaddingTop() + ((ViewGroup.MarginLayoutParams) c0578f).topMargin, Math.min(rect.top, ((height - getPaddingBottom()) - i2) - ((ViewGroup.MarginLayoutParams) c0578f).bottomMargin));
        rect.set(max, max2, i + max, i2 + max2);
    }

    @Override // p000a.p006b.p030g.p045k.NestedScrollingParent2
    /* renamed from: b */
    public boolean mo7347b(View view, View view2, int i, int i2) {
        int childCount = getChildCount();
        boolean z = false;
        for (int i3 = 0; i3 < childCount; i3++) {
            View childAt = getChildAt(i3);
            if (childAt.getVisibility() != 8) {
                C0578f c0578f = (C0578f) childAt.getLayoutParams();
                AbstractC0575c m7673d = c0578f.m7673d();
                if (m7673d != null) {
                    boolean mo7693b = m7673d.mo7693b(this, childAt, view, view2, i, i2);
                    c0578f.m7686a(i2, mo7693b);
                    z |= mo7693b;
                } else {
                    c0578f.m7686a(i2, false);
                }
            }
        }
        return z;
    }

    /* renamed from: a */
    public void m7742a(View view, int i, Rect rect, Rect rect2) {
        C0578f c0578f = (C0578f) view.getLayoutParams();
        int measuredWidth = view.getMeasuredWidth();
        int measuredHeight = view.getMeasuredHeight();
        m7741a(view, i, rect, rect2, c0578f, measuredWidth, measuredHeight);
        m7747a(c0578f, rect2, measuredWidth, measuredHeight);
    }

    /* renamed from: a */
    public final void m7738a(View view, View view2, int i) {
        Rect m7714f = m7714f();
        Rect m7714f2 = m7714f();
        try {
            m7740a(view2, m7714f);
            m7742a(view, i, m7714f, m7714f2);
            view.layout(m7714f2.left, m7714f2.top, m7714f2.right, m7714f2.bottom);
        } finally {
            m7748a(m7714f);
            m7748a(m7714f2);
        }
    }

    /* renamed from: a */
    public final void m7739a(View view, Rect rect, int i) {
        boolean z;
        boolean z2;
        int width;
        int i2;
        int i3;
        int i4;
        int height;
        int i5;
        int i6;
        int i7;
        if (ViewCompat.m9409x(view) && view.getWidth() > 0 && view.getHeight() > 0) {
            C0578f c0578f = (C0578f) view.getLayoutParams();
            AbstractC0575c m7673d = c0578f.m7673d();
            Rect m7714f = m7714f();
            Rect m7714f2 = m7714f();
            m7714f2.set(view.getLeft(), view.getTop(), view.getRight(), view.getBottom());
            if (m7673d != null && m7673d.mo7642a(this, (CoordinatorLayout) view, m7714f)) {
                if (!m7714f2.contains(m7714f)) {
                    throw new IllegalArgumentException("Rect should be within the child's bounds. Rect:" + m7714f.toShortString() + " | Bounds:" + m7714f2.toShortString());
                }
            } else {
                m7714f.set(m7714f2);
            }
            m7748a(m7714f2);
            if (m7714f.isEmpty()) {
                m7748a(m7714f);
                return;
            }
            int m9579a = GravityCompat.m9579a(c0578f.f3334h, i);
            if ((m9579a & 48) != 48 || (i6 = (m7714f.top - ((ViewGroup.MarginLayoutParams) c0578f).topMargin) - c0578f.f3336j) >= (i7 = rect.top)) {
                z = false;
            } else {
                m7713f(view, i7 - i6);
                z = true;
            }
            if ((m9579a & 80) == 80 && (height = ((getHeight() - m7714f.bottom) - ((ViewGroup.MarginLayoutParams) c0578f).bottomMargin) + c0578f.f3336j) < (i5 = rect.bottom)) {
                m7713f(view, height - i5);
                z = true;
            }
            if (!z) {
                m7713f(view, 0);
            }
            if ((m9579a & 3) != 3 || (i3 = (m7714f.left - ((ViewGroup.MarginLayoutParams) c0578f).leftMargin) - c0578f.f3335i) >= (i4 = rect.left)) {
                z2 = false;
            } else {
                m7715e(view, i4 - i3);
                z2 = true;
            }
            if ((m9579a & 5) == 5 && (width = ((getWidth() - m7714f.right) - ((ViewGroup.MarginLayoutParams) c0578f).rightMargin) + c0578f.f3335i) < (i2 = rect.right)) {
                m7715e(view, width - i2);
                z2 = true;
            }
            if (!z2) {
                m7715e(view, 0);
            }
            m7748a(m7714f);
        }
    }

    /* renamed from: a */
    public void m7745a(View view) {
        List m9235c = this.f3307b.m9235c(view);
        if (m9235c == null || m9235c.isEmpty()) {
            return;
        }
        for (int i = 0; i < m9235c.size(); i++) {
            View view2 = (View) m9235c.get(i);
            AbstractC0575c m7673d = ((C0578f) view2.getLayoutParams()).m7673d();
            if (m7673d != null) {
                m7673d.mo7639b(this, (CoordinatorLayout) view2, view);
            }
        }
    }

    /* renamed from: a */
    public void m7753a() {
        if (this.f3313h) {
            if (this.f3317m == null) {
                this.f3317m = new ViewTreeObserver$OnPreDrawListenerC0579g();
            }
            getViewTreeObserver().addOnPreDrawListener(this.f3317m);
        }
        this.f3318n = true;
    }

    /* renamed from: a */
    public boolean m7744a(View view, int i, int i2) {
        Rect m7714f = m7714f();
        m7740a(view, m7714f);
        try {
            return m7714f.contains(i, i2);
        } finally {
            m7748a(m7714f);
        }
    }

    @Override // p000a.p006b.p030g.p045k.NestedScrollingParent2
    /* renamed from: a */
    public void mo7354a(View view, View view2, int i, int i2) {
        AbstractC0575c m7673d;
        this.f3324t.m9478a(view, view2, i, i2);
        this.f3316k = view2;
        int childCount = getChildCount();
        for (int i3 = 0; i3 < childCount; i3++) {
            View childAt = getChildAt(i3);
            C0578f c0578f = (C0578f) childAt.getLayoutParams();
            if (c0578f.m7687a(i2) && (m7673d = c0578f.m7673d()) != null) {
                m7673d.m7696a(this, (CoordinatorLayout) childAt, view, view2, i, i2);
            }
        }
    }

    @Override // p000a.p006b.p030g.p045k.NestedScrollingParent2
    /* renamed from: a */
    public void mo7359a(View view, int i) {
        this.f3324t.m9480a(view, i);
        int childCount = getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = getChildAt(i2);
            C0578f c0578f = (C0578f) childAt.getLayoutParams();
            if (c0578f.m7687a(i)) {
                AbstractC0575c m7673d = c0578f.m7673d();
                if (m7673d != null) {
                    m7673d.mo7702a(this, (CoordinatorLayout) childAt, view, i);
                }
                c0578f.m7677b(i);
                c0578f.m7670g();
            }
        }
        this.f3316k = null;
    }

    @Override // p000a.p006b.p030g.p045k.NestedScrollingParent2
    /* renamed from: a */
    public void mo7357a(View view, int i, int i2, int i3, int i4, int i5) {
        AbstractC0575c m7673d;
        int childCount = getChildCount();
        boolean z = false;
        for (int i6 = 0; i6 < childCount; i6++) {
            View childAt = getChildAt(i6);
            if (childAt.getVisibility() != 8) {
                C0578f c0578f = (C0578f) childAt.getLayoutParams();
                if (c0578f.m7687a(i5) && (m7673d = c0578f.m7673d()) != null) {
                    m7673d.mo7700a(this, childAt, view, i, i2, i3, i4, i5);
                    z = true;
                }
            }
        }
        if (z) {
            m7733b(1);
        }
    }

    @Override // p000a.p006b.p030g.p045k.NestedScrollingParent2
    /* renamed from: a */
    public void mo7356a(View view, int i, int i2, int[] iArr, int i3) {
        AbstractC0575c m7673d;
        int childCount = getChildCount();
        boolean z = false;
        int i4 = 0;
        int i5 = 0;
        for (int i6 = 0; i6 < childCount; i6++) {
            View childAt = getChildAt(i6);
            if (childAt.getVisibility() != 8) {
                C0578f c0578f = (C0578f) childAt.getLayoutParams();
                if (c0578f.m7687a(i3) && (m7673d = c0578f.m7673d()) != null) {
                    int[] iArr2 = this.f3310e;
                    iArr2[1] = 0;
                    iArr2[0] = 0;
                    m7673d.mo7698a(this, (CoordinatorLayout) childAt, view, i, i2, iArr2, i3);
                    int[] iArr3 = this.f3310e;
                    int max = i > 0 ? Math.max(i4, iArr3[0]) : Math.min(i4, iArr3[0]);
                    int[] iArr4 = this.f3310e;
                    i4 = max;
                    i5 = i2 > 0 ? Math.max(i5, iArr4[1]) : Math.min(i5, iArr4[1]);
                    z = true;
                }
            }
        }
        iArr[0] = i4;
        iArr[1] = i5;
        if (z) {
            m7733b(1);
        }
    }
}
