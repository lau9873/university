package android.support.design.widget;

import a.b.d.k;
import a.b.g.k.u;
import a.b.g.l.s;
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
/* loaded from: classes.dex */
public class BottomSheetBehavior<V extends View> extends CoordinatorLayout.c<V> {

    /* renamed from: a  reason: collision with root package name */
    public boolean f2157a;

    /* renamed from: b  reason: collision with root package name */
    public float f2158b;

    /* renamed from: c  reason: collision with root package name */
    public int f2159c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f2160d;

    /* renamed from: e  reason: collision with root package name */
    public int f2161e;

    /* renamed from: f  reason: collision with root package name */
    public int f2162f;

    /* renamed from: g  reason: collision with root package name */
    public int f2163g;

    /* renamed from: h  reason: collision with root package name */
    public int f2164h;

    /* renamed from: i  reason: collision with root package name */
    public int f2165i;
    public boolean j;
    public boolean k;
    public int l;
    public s m;
    public boolean n;
    public int o;
    public boolean p;
    public int q;
    public WeakReference<V> r;
    public WeakReference<View> s;
    public b t;
    public VelocityTracker u;
    public int v;
    public int w;
    public boolean x;
    public Map<View, Integer> y;
    public final s.c z;

    /* loaded from: classes.dex */
    public class a extends s.c {
        public a() {
        }

        @Override // a.b.g.l.s.c
        public void a(View view, int i2, int i3, int i4, int i5) {
            BottomSheetBehavior.this.a(i3);
        }

        @Override // a.b.g.l.s.c
        public boolean b(View view, int i2) {
            WeakReference<V> weakReference;
            View view2;
            BottomSheetBehavior bottomSheetBehavior = BottomSheetBehavior.this;
            int i3 = bottomSheetBehavior.l;
            if (i3 == 1 || bottomSheetBehavior.x) {
                return false;
            }
            return ((i3 == 3 && bottomSheetBehavior.v == i2 && (view2 = bottomSheetBehavior.s.get()) != null && view2.canScrollVertically(-1)) || (weakReference = BottomSheetBehavior.this.r) == null || weakReference.get() != view) ? false : true;
        }

        @Override // a.b.g.l.s.c
        public void c(int i2) {
            if (i2 == 1) {
                BottomSheetBehavior.this.c(1);
            }
        }

        @Override // a.b.g.l.s.c
        public void a(View view, float f2, float f3) {
            int i2;
            int i3;
            int i4;
            int i5 = 4;
            if (f3 < 0.0f) {
                if (BottomSheetBehavior.this.f2157a) {
                    i4 = BottomSheetBehavior.this.f2163g;
                    i5 = 3;
                } else {
                    int top = view.getTop();
                    int i6 = BottomSheetBehavior.this.f2164h;
                    if (top > i6) {
                        i4 = i6;
                        i5 = 6;
                    }
                    i4 = 0;
                    i5 = 3;
                }
            } else {
                BottomSheetBehavior bottomSheetBehavior = BottomSheetBehavior.this;
                if (bottomSheetBehavior.j && bottomSheetBehavior.a(view, f3) && (view.getTop() > BottomSheetBehavior.this.f2165i || Math.abs(f2) < Math.abs(f3))) {
                    i4 = BottomSheetBehavior.this.q;
                    i5 = 5;
                } else if (f3 != 0.0f && Math.abs(f2) <= Math.abs(f3)) {
                    i4 = BottomSheetBehavior.this.f2165i;
                } else {
                    int top2 = view.getTop();
                    if (BottomSheetBehavior.this.f2157a) {
                        if (Math.abs(top2 - BottomSheetBehavior.this.f2163g) < Math.abs(top2 - BottomSheetBehavior.this.f2165i)) {
                            i4 = BottomSheetBehavior.this.f2163g;
                            i5 = 3;
                        } else {
                            i2 = BottomSheetBehavior.this.f2165i;
                        }
                    } else {
                        BottomSheetBehavior bottomSheetBehavior2 = BottomSheetBehavior.this;
                        int i7 = bottomSheetBehavior2.f2164h;
                        if (top2 < i7) {
                            if (top2 >= Math.abs(top2 - bottomSheetBehavior2.f2165i)) {
                                i3 = BottomSheetBehavior.this.f2164h;
                            }
                            i4 = 0;
                            i5 = 3;
                        } else if (Math.abs(top2 - i7) < Math.abs(top2 - BottomSheetBehavior.this.f2165i)) {
                            i3 = BottomSheetBehavior.this.f2164h;
                        } else {
                            i2 = BottomSheetBehavior.this.f2165i;
                        }
                        i4 = i3;
                        i5 = 6;
                    }
                    i4 = i2;
                }
            }
            if (BottomSheetBehavior.this.m.d(view.getLeft(), i4)) {
                BottomSheetBehavior.this.c(2);
                u.a(view, new d(view, i5));
                return;
            }
            BottomSheetBehavior.this.c(i5);
        }

        @Override // a.b.g.l.s.c
        public int b(View view, int i2, int i3) {
            int c2 = BottomSheetBehavior.this.c();
            BottomSheetBehavior bottomSheetBehavior = BottomSheetBehavior.this;
            return a.b.g.e.a.a(i2, c2, bottomSheetBehavior.j ? bottomSheetBehavior.q : bottomSheetBehavior.f2165i);
        }

        @Override // a.b.g.l.s.c
        public int b(View view) {
            BottomSheetBehavior bottomSheetBehavior = BottomSheetBehavior.this;
            if (bottomSheetBehavior.j) {
                return bottomSheetBehavior.q;
            }
            return bottomSheetBehavior.f2165i;
        }

        @Override // a.b.g.l.s.c
        public int a(View view, int i2, int i3) {
            return view.getLeft();
        }
    }

    /* loaded from: classes.dex */
    public static abstract class b {
        public abstract void a(View view, float f2);

        public abstract void a(View view, int i2);
    }

    /* loaded from: classes.dex */
    public class d implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        public final View f2168a;

        /* renamed from: b  reason: collision with root package name */
        public final int f2169b;

        public d(View view, int i2) {
            this.f2168a = view;
            this.f2169b = i2;
        }

        @Override // java.lang.Runnable
        public void run() {
            s sVar = BottomSheetBehavior.this.m;
            if (sVar != null && sVar.a(true)) {
                u.a(this.f2168a, this);
            } else {
                BottomSheetBehavior.this.c(this.f2169b);
            }
        }
    }

    public BottomSheetBehavior() {
        this.f2157a = true;
        this.l = 4;
        this.z = new a();
    }

    public void c(boolean z) {
        this.k = z;
    }

    @Override // android.support.design.widget.CoordinatorLayout.c
    public Parcelable d(CoordinatorLayout coordinatorLayout, V v) {
        return new c(super.d(coordinatorLayout, v), this.l);
    }

    public final void e() {
        this.v = -1;
        VelocityTracker velocityTracker = this.u;
        if (velocityTracker != null) {
            velocityTracker.recycle();
            this.u = null;
        }
    }

    /* loaded from: classes.dex */
    public static class c extends a.b.g.k.a {
        public static final Parcelable.Creator<c> CREATOR = new a();

        /* renamed from: c  reason: collision with root package name */
        public final int f2167c;

        /* loaded from: classes.dex */
        public static class a implements Parcelable.ClassLoaderCreator<c> {
            @Override // android.os.Parcelable.Creator
            public c[] newArray(int i2) {
                return new c[i2];
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.ClassLoaderCreator
            public c createFromParcel(Parcel parcel, ClassLoader classLoader) {
                return new c(parcel, classLoader);
            }

            @Override // android.os.Parcelable.Creator
            public c createFromParcel(Parcel parcel) {
                return new c(parcel, (ClassLoader) null);
            }
        }

        public c(Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            this.f2167c = parcel.readInt();
        }

        @Override // a.b.g.k.a, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i2) {
            super.writeToParcel(parcel, i2);
            parcel.writeInt(this.f2167c);
        }

        public c(Parcelable parcelable, int i2) {
            super(parcelable);
            this.f2167c = i2;
        }
    }

    @Override // android.support.design.widget.CoordinatorLayout.c
    public void a(CoordinatorLayout coordinatorLayout, V v, Parcelable parcelable) {
        c cVar = (c) parcelable;
        super.a(coordinatorLayout, (CoordinatorLayout) v, cVar.a());
        int i2 = cVar.f2167c;
        if (i2 != 1 && i2 != 2) {
            this.l = i2;
        } else {
            this.l = 4;
        }
    }

    @Override // android.support.design.widget.CoordinatorLayout.c
    public boolean b(CoordinatorLayout coordinatorLayout, V v, MotionEvent motionEvent) {
        if (v.isShown()) {
            int actionMasked = motionEvent.getActionMasked();
            if (this.l == 1 && actionMasked == 0) {
                return true;
            }
            s sVar = this.m;
            if (sVar != null) {
                sVar.a(motionEvent);
            }
            if (actionMasked == 0) {
                e();
            }
            if (this.u == null) {
                this.u = VelocityTracker.obtain();
            }
            this.u.addMovement(motionEvent);
            if (actionMasked == 2 && !this.n && Math.abs(this.w - motionEvent.getY()) > this.m.c()) {
                this.m.a(v, motionEvent.getPointerId(motionEvent.getActionIndex()));
            }
            return !this.n;
        }
        return false;
    }

    public void c(int i2) {
        b bVar;
        if (this.l == i2) {
            return;
        }
        this.l = i2;
        if (i2 == 6 || i2 == 3) {
            d(true);
        } else if (i2 == 5 || i2 == 4) {
            d(false);
        }
        V v = this.r.get();
        if (v == null || (bVar = this.t) == null) {
            return;
        }
        bVar.a((View) v, i2);
    }

    public final float d() {
        VelocityTracker velocityTracker = this.u;
        if (velocityTracker == null) {
            return 0.0f;
        }
        velocityTracker.computeCurrentVelocity(1000, this.f2158b);
        return this.u.getYVelocity(this.v);
    }

    public BottomSheetBehavior(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        int i2;
        this.f2157a = true;
        this.l = 4;
        this.z = new a();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, k.BottomSheetBehavior_Layout);
        TypedValue peekValue = obtainStyledAttributes.peekValue(k.BottomSheetBehavior_Layout_behavior_peekHeight);
        if (peekValue != null && (i2 = peekValue.data) == -1) {
            b(i2);
        } else {
            b(obtainStyledAttributes.getDimensionPixelSize(k.BottomSheetBehavior_Layout_behavior_peekHeight, -1));
        }
        b(obtainStyledAttributes.getBoolean(k.BottomSheetBehavior_Layout_behavior_hideable, false));
        a(obtainStyledAttributes.getBoolean(k.BottomSheetBehavior_Layout_behavior_fitToContents, true));
        c(obtainStyledAttributes.getBoolean(k.BottomSheetBehavior_Layout_behavior_skipCollapsed, false));
        obtainStyledAttributes.recycle();
        this.f2158b = ViewConfiguration.get(context).getScaledMaximumFlingVelocity();
    }

    public final void d(boolean z) {
        WeakReference<V> weakReference = this.r;
        if (weakReference == null) {
            return;
        }
        ViewParent parent = weakReference.get().getParent();
        if (parent instanceof CoordinatorLayout) {
            CoordinatorLayout coordinatorLayout = (CoordinatorLayout) parent;
            int childCount = coordinatorLayout.getChildCount();
            if (Build.VERSION.SDK_INT >= 16 && z) {
                if (this.y != null) {
                    return;
                }
                this.y = new HashMap(childCount);
            }
            for (int i2 = 0; i2 < childCount; i2++) {
                View childAt = coordinatorLayout.getChildAt(i2);
                if (childAt != this.r.get()) {
                    if (!z) {
                        Map<View, Integer> map = this.y;
                        if (map != null && map.containsKey(childAt)) {
                            u.f(childAt, this.y.get(childAt).intValue());
                        }
                    } else {
                        if (Build.VERSION.SDK_INT >= 16) {
                            this.y.put(childAt, Integer.valueOf(childAt.getImportantForAccessibility()));
                        }
                        u.f(childAt, 4);
                    }
                }
            }
            if (z) {
                return;
            }
            this.y = null;
        }
    }

    @Override // android.support.design.widget.CoordinatorLayout.c
    public boolean a(CoordinatorLayout coordinatorLayout, V v, int i2) {
        if (u.h(coordinatorLayout) && !u.h(v)) {
            v.setFitsSystemWindows(true);
        }
        int top = v.getTop();
        coordinatorLayout.d(v, i2);
        this.q = coordinatorLayout.getHeight();
        if (this.f2160d) {
            if (this.f2161e == 0) {
                this.f2161e = coordinatorLayout.getResources().getDimensionPixelSize(a.b.d.d.design_bottom_sheet_peek_height_min);
            }
            this.f2162f = Math.max(this.f2161e, this.q - ((coordinatorLayout.getWidth() * 9) / 16));
        } else {
            this.f2162f = this.f2159c;
        }
        this.f2163g = Math.max(0, this.q - v.getHeight());
        this.f2164h = this.q / 2;
        b();
        int i3 = this.l;
        if (i3 == 3) {
            u.d(v, c());
        } else if (i3 == 6) {
            u.d(v, this.f2164h);
        } else if (this.j && i3 == 5) {
            u.d(v, this.q);
        } else {
            int i4 = this.l;
            if (i4 == 4) {
                u.d(v, this.f2165i);
            } else if (i4 == 1 || i4 == 2) {
                u.d(v, top - v.getTop());
            }
        }
        if (this.m == null) {
            this.m = s.a(coordinatorLayout, this.z);
        }
        this.r = new WeakReference<>(v);
        this.s = new WeakReference<>(a(v));
        return true;
    }

    public final int c() {
        if (this.f2157a) {
            return this.f2163g;
        }
        return 0;
    }

    @Override // android.support.design.widget.CoordinatorLayout.c
    public boolean b(CoordinatorLayout coordinatorLayout, V v, View view, View view2, int i2, int i3) {
        this.o = 0;
        this.p = false;
        return (i2 & 2) != 0;
    }

    public final void b(int i2) {
        WeakReference<V> weakReference;
        V v;
        boolean z = true;
        if (i2 == -1) {
            if (!this.f2160d) {
                this.f2160d = true;
            }
            z = false;
        } else {
            if (this.f2160d || this.f2159c != i2) {
                this.f2160d = false;
                this.f2159c = Math.max(0, i2);
                this.f2165i = this.q - i2;
            }
            z = false;
        }
        if (!z || this.l != 4 || (weakReference = this.r) == null || (v = weakReference.get()) == null) {
            return;
        }
        v.requestLayout();
    }

    public void b(boolean z) {
        this.j = z;
    }

    public final void b() {
        if (this.f2157a) {
            this.f2165i = Math.max(this.q - this.f2162f, this.f2163g);
        } else {
            this.f2165i = this.q - this.f2162f;
        }
    }

    @Override // android.support.design.widget.CoordinatorLayout.c
    public boolean a(CoordinatorLayout coordinatorLayout, V v, MotionEvent motionEvent) {
        s sVar;
        if (!v.isShown()) {
            this.n = true;
            return false;
        }
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 0) {
            e();
        }
        if (this.u == null) {
            this.u = VelocityTracker.obtain();
        }
        this.u.addMovement(motionEvent);
        if (actionMasked == 0) {
            int x = (int) motionEvent.getX();
            this.w = (int) motionEvent.getY();
            WeakReference<View> weakReference = this.s;
            View view = weakReference != null ? weakReference.get() : null;
            if (view != null && coordinatorLayout.a(view, x, this.w)) {
                this.v = motionEvent.getPointerId(motionEvent.getActionIndex());
                this.x = true;
            }
            this.n = this.v == -1 && !coordinatorLayout.a(v, x, this.w);
        } else if (actionMasked == 1 || actionMasked == 3) {
            this.x = false;
            this.v = -1;
            if (this.n) {
                this.n = false;
                return false;
            }
        }
        if (this.n || (sVar = this.m) == null || !sVar.c(motionEvent)) {
            WeakReference<View> weakReference2 = this.s;
            View view2 = weakReference2 != null ? weakReference2.get() : null;
            return (actionMasked != 2 || view2 == null || this.n || this.l == 1 || coordinatorLayout.a(view2, (int) motionEvent.getX(), (int) motionEvent.getY()) || this.m == null || Math.abs(((float) this.w) - motionEvent.getY()) <= ((float) this.m.c())) ? false : true;
        }
        return true;
    }

    @Override // android.support.design.widget.CoordinatorLayout.c
    public void a(CoordinatorLayout coordinatorLayout, V v, View view, int i2, int i3, int[] iArr, int i4) {
        if (i4 != 1 && view == this.s.get()) {
            int top = v.getTop();
            int i5 = top - i3;
            if (i3 > 0) {
                if (i5 < c()) {
                    iArr[1] = top - c();
                    u.d(v, -iArr[1]);
                    c(3);
                } else {
                    iArr[1] = i3;
                    u.d(v, -i3);
                    c(1);
                }
            } else if (i3 < 0 && !view.canScrollVertically(-1)) {
                int i6 = this.f2165i;
                if (i5 > i6 && !this.j) {
                    iArr[1] = top - i6;
                    u.d(v, -iArr[1]);
                    c(4);
                } else {
                    iArr[1] = i3;
                    u.d(v, -i3);
                    c(1);
                }
            }
            a(v.getTop());
            this.o = i3;
            this.p = true;
        }
    }

    @Override // android.support.design.widget.CoordinatorLayout.c
    public void a(CoordinatorLayout coordinatorLayout, V v, View view, int i2) {
        int i3;
        int i4 = 3;
        if (v.getTop() == c()) {
            c(3);
        } else if (view == this.s.get() && this.p) {
            if (this.o > 0) {
                i3 = c();
            } else if (this.j && a(v, d())) {
                i3 = this.q;
                i4 = 5;
            } else {
                if (this.o == 0) {
                    int top = v.getTop();
                    if (this.f2157a) {
                        if (Math.abs(top - this.f2163g) < Math.abs(top - this.f2165i)) {
                            i3 = this.f2163g;
                        } else {
                            i3 = this.f2165i;
                        }
                    } else {
                        int i5 = this.f2164h;
                        if (top < i5) {
                            if (top < Math.abs(top - this.f2165i)) {
                                i3 = 0;
                            } else {
                                i3 = this.f2164h;
                            }
                        } else if (Math.abs(top - i5) < Math.abs(top - this.f2165i)) {
                            i3 = this.f2164h;
                        } else {
                            i3 = this.f2165i;
                        }
                        i4 = 6;
                    }
                } else {
                    i3 = this.f2165i;
                }
                i4 = 4;
            }
            if (this.m.b(v, v.getLeft(), i3)) {
                c(2);
                u.a(v, new d(v, i4));
            } else {
                c(i4);
            }
            this.p = false;
        }
    }

    @Override // android.support.design.widget.CoordinatorLayout.c
    public boolean a(CoordinatorLayout coordinatorLayout, V v, View view, float f2, float f3) {
        return view == this.s.get() && (this.l != 3 || super.a(coordinatorLayout, (CoordinatorLayout) v, view, f2, f3));
    }

    public void a(boolean z) {
        if (this.f2157a == z) {
            return;
        }
        this.f2157a = z;
        if (this.r != null) {
            b();
        }
        c((this.f2157a && this.l == 6) ? 3 : this.l);
    }

    public boolean a(View view, float f2) {
        if (this.k) {
            return true;
        }
        return view.getTop() >= this.f2165i && Math.abs((((float) view.getTop()) + (f2 * 0.1f)) - ((float) this.f2165i)) / ((float) this.f2159c) > 0.5f;
    }

    public View a(View view) {
        if (u.y(view)) {
            return view;
        }
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            int childCount = viewGroup.getChildCount();
            for (int i2 = 0; i2 < childCount; i2++) {
                View a2 = a(viewGroup.getChildAt(i2));
                if (a2 != null) {
                    return a2;
                }
            }
            return null;
        }
        return null;
    }

    public void a(int i2) {
        b bVar;
        V v = this.r.get();
        if (v == null || (bVar = this.t) == null) {
            return;
        }
        int i3 = this.f2165i;
        if (i2 > i3) {
            bVar.a(v, (i3 - i2) / (this.q - i3));
        } else {
            bVar.a(v, (i3 - i2) / (i3 - c()));
        }
    }
}
