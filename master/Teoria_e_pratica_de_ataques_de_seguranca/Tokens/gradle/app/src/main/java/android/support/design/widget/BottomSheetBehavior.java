package android.support.design.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;
import android.support.design.widget.CoordinatorLayout;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;
import p000a.p006b.p012d.C0042d;
import p000a.p006b.p012d.C0049k;
import p000a.p006b.p030g.p038e.C0222a;
import p000a.p006b.p030g.p045k.AbsSavedState;
import p000a.p006b.p030g.p045k.ViewCompat;
import p000a.p006b.p030g.p048l.ViewDragHelper;

/* loaded from: classes.dex */
public class BottomSheetBehavior<V extends View> extends CoordinatorLayout.AbstractC0575c<V> {

    /* renamed from: a */
    public boolean f3267a;

    /* renamed from: b */
    public float f3268b;

    /* renamed from: c */
    public int f3269c;

    /* renamed from: d */
    public boolean f3270d;

    /* renamed from: e */
    public int f3271e;

    /* renamed from: f */
    public int f3272f;

    /* renamed from: g */
    public int f3273g;

    /* renamed from: h */
    public int f3274h;

    /* renamed from: i */
    public int f3275i;

    /* renamed from: j */
    public boolean f3276j;

    /* renamed from: k */
    public boolean f3277k;

    /* renamed from: l */
    public int f3278l;

    /* renamed from: m */
    public ViewDragHelper f3279m;

    /* renamed from: n */
    public boolean f3280n;

    /* renamed from: o */
    public int f3281o;

    /* renamed from: p */
    public boolean f3282p;

    /* renamed from: q */
    public int f3283q;

    /* renamed from: r */
    public WeakReference<V> f3284r;

    /* renamed from: s */
    public WeakReference<View> f3285s;

    /* renamed from: t */
    public AbstractC0568b f3286t;

    /* renamed from: u */
    public VelocityTracker f3287u;

    /* renamed from: v */
    public int f3288v;

    /* renamed from: w */
    public int f3289w;

    /* renamed from: x */
    public boolean f3290x;

    /* renamed from: y */
    public Map<View, Integer> f3291y;

    /* renamed from: z */
    public final ViewDragHelper.AbstractC0320c f3292z;

    /* renamed from: android.support.design.widget.BottomSheetBehavior$a */
    /* loaded from: classes.dex */
    public class C0567a extends ViewDragHelper.AbstractC0320c {
        public C0567a() {
        }

        @Override // p000a.p006b.p030g.p048l.ViewDragHelper.AbstractC0320c
        /* renamed from: a */
        public void mo7596a(View view, int i, int i2, int i3, int i4) {
            BottomSheetBehavior.this.m7771a(i2);
        }

        @Override // p000a.p006b.p030g.p048l.ViewDragHelper.AbstractC0320c
        /* renamed from: b */
        public boolean mo7595b(View view, int i) {
            WeakReference<V> weakReference;
            View view2;
            BottomSheetBehavior bottomSheetBehavior = BottomSheetBehavior.this;
            int i2 = bottomSheetBehavior.f3278l;
            if (i2 == 1 || bottomSheetBehavior.f3290x) {
                return false;
            }
            return ((i2 == 3 && bottomSheetBehavior.f3288v == i && (view2 = bottomSheetBehavior.f3285s.get()) != null && view2.canScrollVertically(-1)) || (weakReference = BottomSheetBehavior.this.f3284r) == null || weakReference.get() != view) ? false : true;
        }

        @Override // p000a.p006b.p030g.p048l.ViewDragHelper.AbstractC0320c
        /* renamed from: c */
        public void mo7593c(int i) {
            if (i == 1) {
                BottomSheetBehavior.this.m7761c(1);
            }
        }

        @Override // p000a.p006b.p030g.p048l.ViewDragHelper.AbstractC0320c
        /* renamed from: a */
        public void mo7599a(View view, float f, float f2) {
            int i;
            int i2;
            int i3;
            int i4 = 4;
            if (f2 < 0.0f) {
                if (BottomSheetBehavior.this.f3267a) {
                    i3 = BottomSheetBehavior.this.f3273g;
                    i4 = 3;
                } else {
                    int top = view.getTop();
                    int i5 = BottomSheetBehavior.this.f3274h;
                    if (top > i5) {
                        i3 = i5;
                        i4 = 6;
                    }
                    i3 = 0;
                    i4 = 3;
                }
            } else {
                BottomSheetBehavior bottomSheetBehavior = BottomSheetBehavior.this;
                if (bottomSheetBehavior.f3276j && bottomSheetBehavior.m7768a(view, f2) && (view.getTop() > BottomSheetBehavior.this.f3275i || Math.abs(f) < Math.abs(f2))) {
                    i3 = BottomSheetBehavior.this.f3283q;
                    i4 = 5;
                } else if (f2 != 0.0f && Math.abs(f) <= Math.abs(f2)) {
                    i3 = BottomSheetBehavior.this.f3275i;
                } else {
                    int top2 = view.getTop();
                    if (BottomSheetBehavior.this.f3267a) {
                        if (Math.abs(top2 - BottomSheetBehavior.this.f3273g) < Math.abs(top2 - BottomSheetBehavior.this.f3275i)) {
                            i3 = BottomSheetBehavior.this.f3273g;
                            i4 = 3;
                        } else {
                            i = BottomSheetBehavior.this.f3275i;
                        }
                    } else {
                        BottomSheetBehavior bottomSheetBehavior2 = BottomSheetBehavior.this;
                        int i6 = bottomSheetBehavior2.f3274h;
                        if (top2 < i6) {
                            if (top2 >= Math.abs(top2 - bottomSheetBehavior2.f3275i)) {
                                i2 = BottomSheetBehavior.this.f3274h;
                            }
                            i3 = 0;
                            i4 = 3;
                        } else if (Math.abs(top2 - i6) < Math.abs(top2 - BottomSheetBehavior.this.f3275i)) {
                            i2 = BottomSheetBehavior.this.f3274h;
                        } else {
                            i = BottomSheetBehavior.this.f3275i;
                        }
                        i3 = i2;
                        i4 = 6;
                    }
                    i3 = i;
                }
            }
            if (BottomSheetBehavior.this.f3279m.m9164d(view.getLeft(), i3)) {
                BottomSheetBehavior.this.m7761c(2);
                ViewCompat.m9445a(view, new RunnableC0571d(view, i4));
                return;
            }
            BottomSheetBehavior.this.m7761c(i4);
        }

        @Override // p000a.p006b.p030g.p048l.ViewDragHelper.AbstractC0320c
        /* renamed from: b */
        public int mo7594b(View view, int i, int i2) {
            int m7762c = BottomSheetBehavior.this.m7762c();
            BottomSheetBehavior bottomSheetBehavior = BottomSheetBehavior.this;
            return C0222a.m9830a(i, m7762c, bottomSheetBehavior.f3276j ? bottomSheetBehavior.f3283q : bottomSheetBehavior.f3275i);
        }

        @Override // p000a.p006b.p030g.p048l.ViewDragHelper.AbstractC0320c
        /* renamed from: b */
        public int mo7756b(View view) {
            BottomSheetBehavior bottomSheetBehavior = BottomSheetBehavior.this;
            if (bottomSheetBehavior.f3276j) {
                return bottomSheetBehavior.f3283q;
            }
            return bottomSheetBehavior.f3275i;
        }

        @Override // p000a.p006b.p030g.p048l.ViewDragHelper.AbstractC0320c
        /* renamed from: a */
        public int mo7597a(View view, int i, int i2) {
            return view.getLeft();
        }
    }

    /* renamed from: android.support.design.widget.BottomSheetBehavior$b */
    /* loaded from: classes.dex */
    public static abstract class AbstractC0568b {
        /* renamed from: a */
        public abstract void m7755a(View view, float f);

        /* renamed from: a */
        public abstract void m7754a(View view, int i);
    }

    /* renamed from: android.support.design.widget.BottomSheetBehavior$d */
    /* loaded from: classes.dex */
    public class RunnableC0571d implements Runnable {

        /* renamed from: a */
        public final View f3295a;

        /* renamed from: b */
        public final int f3296b;

        public RunnableC0571d(View view, int i) {
            this.f3295a = view;
            this.f3296b = i;
        }

        @Override // java.lang.Runnable
        public void run() {
            ViewDragHelper viewDragHelper = BottomSheetBehavior.this.f3279m;
            if (viewDragHelper != null && viewDragHelper.m9180a(true)) {
                ViewCompat.m9445a(this.f3295a, this);
            } else {
                BottomSheetBehavior.this.m7761c(this.f3296b);
            }
        }
    }

    public BottomSheetBehavior() {
        this.f3267a = true;
        this.f3278l = 4;
        this.f3292z = new C0567a();
    }

    /* renamed from: c */
    public void m7760c(boolean z) {
        this.f3277k = z;
    }

    @Override // android.support.design.widget.CoordinatorLayout.AbstractC0575c
    /* renamed from: d */
    public Parcelable mo7690d(CoordinatorLayout coordinatorLayout, V v) {
        return new C0569c(super.mo7690d(coordinatorLayout, v), this.f3278l);
    }

    /* renamed from: e */
    public final void m7757e() {
        this.f3288v = -1;
        VelocityTracker velocityTracker = this.f3287u;
        if (velocityTracker != null) {
            velocityTracker.recycle();
            this.f3287u = null;
        }
    }

    /* renamed from: android.support.design.widget.BottomSheetBehavior$c */
    /* loaded from: classes.dex */
    public static class C0569c extends AbsSavedState {
        public static final Parcelable.Creator<C0569c> CREATOR = new C0570a();

        /* renamed from: c */
        public final int f3294c;

        /* renamed from: android.support.design.widget.BottomSheetBehavior$c$a */
        /* loaded from: classes.dex */
        public static class C0570a implements Parcelable.ClassLoaderCreator<C0569c> {
            @Override // android.os.Parcelable.Creator
            public C0569c[] newArray(int i) {
                return new C0569c[i];
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.ClassLoaderCreator
            public C0569c createFromParcel(Parcel parcel, ClassLoader classLoader) {
                return new C0569c(parcel, classLoader);
            }

            @Override // android.os.Parcelable.Creator
            public C0569c createFromParcel(Parcel parcel) {
                return new C0569c(parcel, (ClassLoader) null);
            }
        }

        public C0569c(Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            this.f3294c = parcel.readInt();
        }

        @Override // p000a.p006b.p030g.p045k.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeInt(this.f3294c);
        }

        public C0569c(Parcelable parcelable, int i) {
            super(parcelable);
            this.f3294c = i;
        }
    }

    @Override // android.support.design.widget.CoordinatorLayout.AbstractC0575c
    /* renamed from: a */
    public void mo7706a(CoordinatorLayout coordinatorLayout, V v, Parcelable parcelable) {
        C0569c c0569c = (C0569c) parcelable;
        super.mo7706a(coordinatorLayout, (CoordinatorLayout) v, c0569c.m9588a());
        int i = c0569c.f3294c;
        if (i != 1 && i != 2) {
            this.f3278l = i;
        } else {
            this.f3278l = 4;
        }
    }

    @Override // android.support.design.widget.CoordinatorLayout.AbstractC0575c
    /* renamed from: b */
    public boolean mo7602b(CoordinatorLayout coordinatorLayout, V v, MotionEvent motionEvent) {
        if (v.isShown()) {
            int actionMasked = motionEvent.getActionMasked();
            if (this.f3278l == 1 && actionMasked == 0) {
                return true;
            }
            ViewDragHelper viewDragHelper = this.f3279m;
            if (viewDragHelper != null) {
                viewDragHelper.m9187a(motionEvent);
            }
            if (actionMasked == 0) {
                m7757e();
            }
            if (this.f3287u == null) {
                this.f3287u = VelocityTracker.obtain();
            }
            this.f3287u.addMovement(motionEvent);
            if (actionMasked == 2 && !this.f3280n && Math.abs(this.f3289w - motionEvent.getY()) > this.f3279m.m9170c()) {
                this.f3279m.m9185a(v, motionEvent.getPointerId(motionEvent.getActionIndex()));
            }
            return !this.f3280n;
        }
        return false;
    }

    /* renamed from: c */
    public void m7761c(int i) {
        AbstractC0568b abstractC0568b;
        if (this.f3278l == i) {
            return;
        }
        this.f3278l = i;
        if (i == 6 || i == 3) {
            m7758d(true);
        } else if (i == 5 || i == 4) {
            m7758d(false);
        }
        V v = this.f3284r.get();
        if (v == null || (abstractC0568b = this.f3286t) == null) {
            return;
        }
        abstractC0568b.m7754a((View) v, i);
    }

    /* renamed from: d */
    public final float m7759d() {
        VelocityTracker velocityTracker = this.f3287u;
        if (velocityTracker == null) {
            return 0.0f;
        }
        velocityTracker.computeCurrentVelocity(1000, this.f3268b);
        return this.f3287u.getYVelocity(this.f3288v);
    }

    public BottomSheetBehavior(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        int i;
        this.f3267a = true;
        this.f3278l = 4;
        this.f3292z = new C0567a();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C0049k.BottomSheetBehavior_Layout);
        TypedValue peekValue = obtainStyledAttributes.peekValue(C0049k.BottomSheetBehavior_Layout_behavior_peekHeight);
        if (peekValue != null && (i = peekValue.data) == -1) {
            m7765b(i);
        } else {
            m7765b(obtainStyledAttributes.getDimensionPixelSize(C0049k.BottomSheetBehavior_Layout_behavior_peekHeight, -1));
        }
        m7763b(obtainStyledAttributes.getBoolean(C0049k.BottomSheetBehavior_Layout_behavior_hideable, false));
        m7767a(obtainStyledAttributes.getBoolean(C0049k.BottomSheetBehavior_Layout_behavior_fitToContents, true));
        m7760c(obtainStyledAttributes.getBoolean(C0049k.BottomSheetBehavior_Layout_behavior_skipCollapsed, false));
        obtainStyledAttributes.recycle();
        this.f3268b = ViewConfiguration.get(context).getScaledMaximumFlingVelocity();
    }

    /* renamed from: d */
    public final void m7758d(boolean z) {
        WeakReference<V> weakReference = this.f3284r;
        if (weakReference == null) {
            return;
        }
        ViewParent parent = weakReference.get().getParent();
        if (parent instanceof CoordinatorLayout) {
            CoordinatorLayout coordinatorLayout = (CoordinatorLayout) parent;
            int childCount = coordinatorLayout.getChildCount();
            if (Build.VERSION.SDK_INT >= 16 && z) {
                if (this.f3291y != null) {
                    return;
                }
                this.f3291y = new HashMap(childCount);
            }
            for (int i = 0; i < childCount; i++) {
                View childAt = coordinatorLayout.getChildAt(i);
                if (childAt != this.f3284r.get()) {
                    if (!z) {
                        Map<View, Integer> map = this.f3291y;
                        if (map != null && map.containsKey(childAt)) {
                            ViewCompat.m9429f(childAt, this.f3291y.get(childAt).intValue());
                        }
                    } else {
                        if (Build.VERSION.SDK_INT >= 16) {
                            this.f3291y.put(childAt, Integer.valueOf(childAt.getImportantForAccessibility()));
                        }
                        ViewCompat.m9429f(childAt, 4);
                    }
                }
            }
            if (z) {
                return;
            }
            this.f3291y = null;
        }
    }

    @Override // android.support.design.widget.CoordinatorLayout.AbstractC0575c
    /* renamed from: a */
    public boolean mo7643a(CoordinatorLayout coordinatorLayout, V v, int i) {
        if (ViewCompat.m9426h(coordinatorLayout) && !ViewCompat.m9426h(v)) {
            v.setFitsSystemWindows(true);
        }
        int top = v.getTop();
        coordinatorLayout.m7719d(v, i);
        this.f3283q = coordinatorLayout.getHeight();
        if (this.f3270d) {
            if (this.f3271e == 0) {
                this.f3271e = coordinatorLayout.getResources().getDimensionPixelSize(C0042d.design_bottom_sheet_peek_height_min);
            }
            this.f3272f = Math.max(this.f3271e, this.f3283q - ((coordinatorLayout.getWidth() * 9) / 16));
        } else {
            this.f3272f = this.f3269c;
        }
        this.f3273g = Math.max(0, this.f3283q - v.getHeight());
        this.f3274h = this.f3283q / 2;
        m7766b();
        int i2 = this.f3278l;
        if (i2 == 3) {
            ViewCompat.m9433d(v, m7762c());
        } else if (i2 == 6) {
            ViewCompat.m9433d(v, this.f3274h);
        } else if (this.f3276j && i2 == 5) {
            ViewCompat.m9433d(v, this.f3283q);
        } else {
            int i3 = this.f3278l;
            if (i3 == 4) {
                ViewCompat.m9433d(v, this.f3275i);
            } else if (i3 == 1 || i3 == 2) {
                ViewCompat.m9433d(v, top - v.getTop());
            }
        }
        if (this.f3279m == null) {
            this.f3279m = ViewDragHelper.m9181a(coordinatorLayout, this.f3292z);
        }
        this.f3284r = new WeakReference<>(v);
        this.f3285s = new WeakReference<>(m7769a(v));
        return true;
    }

    /* renamed from: c */
    public final int m7762c() {
        if (this.f3267a) {
            return this.f3273g;
        }
        return 0;
    }

    @Override // android.support.design.widget.CoordinatorLayout.AbstractC0575c
    /* renamed from: b */
    public boolean mo7693b(CoordinatorLayout coordinatorLayout, V v, View view, View view2, int i, int i2) {
        this.f3281o = 0;
        this.f3282p = false;
        return (i & 2) != 0;
    }

    /* renamed from: b */
    public final void m7765b(int i) {
        WeakReference<V> weakReference;
        V v;
        boolean z = true;
        if (i == -1) {
            if (!this.f3270d) {
                this.f3270d = true;
            }
            z = false;
        } else {
            if (this.f3270d || this.f3269c != i) {
                this.f3270d = false;
                this.f3269c = Math.max(0, i);
                this.f3275i = this.f3283q - i;
            }
            z = false;
        }
        if (!z || this.f3278l != 4 || (weakReference = this.f3284r) == null || (v = weakReference.get()) == null) {
            return;
        }
        v.requestLayout();
    }

    /* renamed from: b */
    public void m7763b(boolean z) {
        this.f3276j = z;
    }

    /* renamed from: b */
    public final void m7766b() {
        if (this.f3267a) {
            this.f3275i = Math.max(this.f3283q - this.f3272f, this.f3273g);
        } else {
            this.f3275i = this.f3283q - this.f3272f;
        }
    }

    @Override // android.support.design.widget.CoordinatorLayout.AbstractC0575c
    /* renamed from: a */
    public boolean mo7608a(CoordinatorLayout coordinatorLayout, V v, MotionEvent motionEvent) {
        ViewDragHelper viewDragHelper;
        if (!v.isShown()) {
            this.f3280n = true;
            return false;
        }
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 0) {
            m7757e();
        }
        if (this.f3287u == null) {
            this.f3287u = VelocityTracker.obtain();
        }
        this.f3287u.addMovement(motionEvent);
        if (actionMasked == 0) {
            int x = (int) motionEvent.getX();
            this.f3289w = (int) motionEvent.getY();
            WeakReference<View> weakReference = this.f3285s;
            View view = weakReference != null ? weakReference.get() : null;
            if (view != null && coordinatorLayout.m7744a(view, x, this.f3289w)) {
                this.f3288v = motionEvent.getPointerId(motionEvent.getActionIndex());
                this.f3290x = true;
            }
            this.f3280n = this.f3288v == -1 && !coordinatorLayout.m7744a(v, x, this.f3289w);
        } else if (actionMasked == 1 || actionMasked == 3) {
            this.f3290x = false;
            this.f3288v = -1;
            if (this.f3280n) {
                this.f3280n = false;
                return false;
            }
        }
        if (this.f3280n || (viewDragHelper = this.f3279m) == null || !viewDragHelper.m9167c(motionEvent)) {
            WeakReference<View> weakReference2 = this.f3285s;
            View view2 = weakReference2 != null ? weakReference2.get() : null;
            return (actionMasked != 2 || view2 == null || this.f3280n || this.f3278l == 1 || coordinatorLayout.m7744a(view2, (int) motionEvent.getX(), (int) motionEvent.getY()) || this.f3279m == null || Math.abs(((float) this.f3289w) - motionEvent.getY()) <= ((float) this.f3279m.m9170c())) ? false : true;
        }
        return true;
    }

    @Override // android.support.design.widget.CoordinatorLayout.AbstractC0575c
    /* renamed from: a */
    public void mo7698a(CoordinatorLayout coordinatorLayout, V v, View view, int i, int i2, int[] iArr, int i3) {
        if (i3 != 1 && view == this.f3285s.get()) {
            int top = v.getTop();
            int i4 = top - i2;
            if (i2 > 0) {
                if (i4 < m7762c()) {
                    iArr[1] = top - m7762c();
                    ViewCompat.m9433d(v, -iArr[1]);
                    m7761c(3);
                } else {
                    iArr[1] = i2;
                    ViewCompat.m9433d(v, -i2);
                    m7761c(1);
                }
            } else if (i2 < 0 && !view.canScrollVertically(-1)) {
                int i5 = this.f3275i;
                if (i4 > i5 && !this.f3276j) {
                    iArr[1] = top - i5;
                    ViewCompat.m9433d(v, -iArr[1]);
                    m7761c(4);
                } else {
                    iArr[1] = i2;
                    ViewCompat.m9433d(v, -i2);
                    m7761c(1);
                }
            }
            m7771a(v.getTop());
            this.f3281o = i2;
            this.f3282p = true;
        }
    }

    @Override // android.support.design.widget.CoordinatorLayout.AbstractC0575c
    /* renamed from: a */
    public void mo7702a(CoordinatorLayout coordinatorLayout, V v, View view, int i) {
        int i2;
        int i3 = 3;
        if (v.getTop() == m7762c()) {
            m7761c(3);
        } else if (view == this.f3285s.get() && this.f3282p) {
            if (this.f3281o > 0) {
                i2 = m7762c();
            } else if (this.f3276j && m7768a(v, m7759d())) {
                i2 = this.f3283q;
                i3 = 5;
            } else {
                if (this.f3281o == 0) {
                    int top = v.getTop();
                    if (this.f3267a) {
                        if (Math.abs(top - this.f3273g) < Math.abs(top - this.f3275i)) {
                            i2 = this.f3273g;
                        } else {
                            i2 = this.f3275i;
                        }
                    } else {
                        int i4 = this.f3274h;
                        if (top < i4) {
                            if (top < Math.abs(top - this.f3275i)) {
                                i2 = 0;
                            } else {
                                i2 = this.f3274h;
                            }
                        } else if (Math.abs(top - i4) < Math.abs(top - this.f3275i)) {
                            i2 = this.f3274h;
                        } else {
                            i2 = this.f3275i;
                        }
                        i3 = 6;
                    }
                } else {
                    i2 = this.f3275i;
                }
                i3 = 4;
            }
            if (this.f3279m.m9171b(v, v.getLeft(), i2)) {
                m7761c(2);
                ViewCompat.m9445a(v, new RunnableC0571d(v, i3));
            } else {
                m7761c(i3);
            }
            this.f3282p = false;
        }
    }

    @Override // android.support.design.widget.CoordinatorLayout.AbstractC0575c
    /* renamed from: a */
    public boolean mo7704a(CoordinatorLayout coordinatorLayout, V v, View view, float f, float f2) {
        return view == this.f3285s.get() && (this.f3278l != 3 || super.mo7704a(coordinatorLayout, (CoordinatorLayout) v, view, f, f2));
    }

    /* renamed from: a */
    public void m7767a(boolean z) {
        if (this.f3267a == z) {
            return;
        }
        this.f3267a = z;
        if (this.f3284r != null) {
            m7766b();
        }
        m7761c((this.f3267a && this.f3278l == 6) ? 3 : this.f3278l);
    }

    /* renamed from: a */
    public boolean m7768a(View view, float f) {
        if (this.f3277k) {
            return true;
        }
        return view.getTop() >= this.f3275i && Math.abs((((float) view.getTop()) + (f * 0.1f)) - ((float) this.f3275i)) / ((float) this.f3269c) > 0.5f;
    }

    /* renamed from: a */
    public View m7769a(View view) {
        if (ViewCompat.m9408y(view)) {
            return view;
        }
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            int childCount = viewGroup.getChildCount();
            for (int i = 0; i < childCount; i++) {
                View m7769a = m7769a(viewGroup.getChildAt(i));
                if (m7769a != null) {
                    return m7769a;
                }
            }
            return null;
        }
        return null;
    }

    /* renamed from: a */
    public void m7771a(int i) {
        AbstractC0568b abstractC0568b;
        V v = this.f3284r.get();
        if (v == null || (abstractC0568b = this.f3286t) == null) {
            return;
        }
        int i2 = this.f3275i;
        if (i > i2) {
            abstractC0568b.m7755a(v, (i2 - i) / (this.f3283q - i2));
        } else {
            abstractC0568b.m7755a(v, (i2 - i) / (i2 - m7762c()));
        }
    }
}
