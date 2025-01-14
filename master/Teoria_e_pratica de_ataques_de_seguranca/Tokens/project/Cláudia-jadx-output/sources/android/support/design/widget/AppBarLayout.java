package android.support.design.widget;

import a.b.d.q.g;
import a.b.d.x.i;
import a.b.d.x.j;
import a.b.d.x.s;
import a.b.g.k.d0;
import a.b.g.k.k;
import a.b.g.k.p;
import a.b.g.k.u;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;
import android.support.design.widget.CoordinatorLayout;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.view.animation.Interpolator;
import android.widget.LinearLayout;
import java.lang.ref.WeakReference;
import java.util.List;
@CoordinatorLayout.d(Behavior.class)
/* loaded from: classes.dex */
public class AppBarLayout extends LinearLayout {

    /* renamed from: a  reason: collision with root package name */
    public int f2102a;

    /* renamed from: b  reason: collision with root package name */
    public int f2103b;

    /* renamed from: c  reason: collision with root package name */
    public int f2104c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f2105d;

    /* renamed from: e  reason: collision with root package name */
    public int f2106e;

    /* renamed from: f  reason: collision with root package name */
    public d0 f2107f;

    /* renamed from: g  reason: collision with root package name */
    public List<b> f2108g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f2109h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f2110i;
    public boolean j;
    public boolean k;
    public int[] m;

    /* loaded from: classes.dex */
    public static class BaseBehavior<T extends AppBarLayout> extends i<T> {
        public int k;
        public int l;
        public ValueAnimator m;
        public int n;
        public boolean o;
        public float p;
        public WeakReference<View> q;
        public b r;

        /* loaded from: classes.dex */
        public class a implements ValueAnimator.AnimatorUpdateListener {

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ CoordinatorLayout f2111a;

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ AppBarLayout f2112b;

            public a(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout) {
                this.f2111a = coordinatorLayout;
                this.f2112b = appBarLayout;
            }

            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                BaseBehavior.this.c(this.f2111a, (CoordinatorLayout) this.f2112b, ((Integer) valueAnimator.getAnimatedValue()).intValue());
            }
        }

        /* loaded from: classes.dex */
        public static abstract class b<T extends AppBarLayout> {
            public abstract boolean a(T t);
        }

        public BaseBehavior() {
            this.n = -1;
        }

        public static boolean a(int i2, int i3) {
            return (i2 & i3) == i3;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // a.b.d.x.i
        public /* bridge */ /* synthetic */ int b(View view) {
            return b((BaseBehavior<T>) ((AppBarLayout) view));
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // a.b.d.x.i
        public /* bridge */ /* synthetic */ int c(View view) {
            return c((BaseBehavior<T>) ((AppBarLayout) view));
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // android.support.design.widget.CoordinatorLayout.c
        public /* bridge */ /* synthetic */ Parcelable d(CoordinatorLayout coordinatorLayout, View view) {
            return b(coordinatorLayout, (CoordinatorLayout) ((AppBarLayout) view));
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // a.b.d.x.i
        public /* bridge */ /* synthetic */ void e(CoordinatorLayout coordinatorLayout, View view) {
            a(coordinatorLayout, (CoordinatorLayout) ((AppBarLayout) view));
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // a.b.d.x.i
        public /* bridge */ /* synthetic */ boolean a(View view) {
            return a((BaseBehavior<T>) ((AppBarLayout) view));
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // android.support.design.widget.CoordinatorLayout.c
        public /* bridge */ /* synthetic */ boolean b(CoordinatorLayout coordinatorLayout, View view, View view2, View view3, int i2, int i3) {
            return a(coordinatorLayout, (CoordinatorLayout) ((AppBarLayout) view), view2, view3, i2, i3);
        }

        public int c(T t) {
            return t.getTotalScrollRange();
        }

        public final void d(CoordinatorLayout coordinatorLayout, T t) {
            int d2 = d();
            int a2 = a((BaseBehavior<T>) t, d2);
            if (a2 >= 0) {
                View childAt = t.getChildAt(a2);
                c cVar = (c) childAt.getLayoutParams();
                int a3 = cVar.a();
                if ((a3 & 17) == 17) {
                    int i2 = -childAt.getTop();
                    int i3 = -childAt.getBottom();
                    if (a2 == t.getChildCount() - 1) {
                        i3 += t.getTopInset();
                    }
                    if (a(a3, 2)) {
                        i3 += u.l(childAt);
                    } else if (a(a3, 5)) {
                        int l = u.l(childAt) + i3;
                        if (d2 < l) {
                            i2 = l;
                        } else {
                            i3 = l;
                        }
                    }
                    if (a(a3, 32)) {
                        i2 += ((LinearLayout.LayoutParams) cVar).topMargin;
                        i3 -= ((LinearLayout.LayoutParams) cVar).bottomMargin;
                    }
                    if (d2 < (i3 + i2) / 2) {
                        i2 = i3;
                    }
                    a(coordinatorLayout, (CoordinatorLayout) t, a.b.g.e.a.a(i2, -t.getTotalScrollRange(), 0), 0.0f);
                }
            }
        }

        public BaseBehavior(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            this.n = -1;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // a.b.d.x.q, android.support.design.widget.CoordinatorLayout.c
        public /* bridge */ /* synthetic */ boolean a(CoordinatorLayout coordinatorLayout, View view, int i2) {
            return a(coordinatorLayout, (CoordinatorLayout) ((AppBarLayout) view), i2);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // a.b.d.x.i
        public /* bridge */ /* synthetic */ int b(CoordinatorLayout coordinatorLayout, View view, int i2, int i3, int i4) {
            return a(coordinatorLayout, (CoordinatorLayout) ((AppBarLayout) view), i2, i3, i4);
        }

        public final boolean c(CoordinatorLayout coordinatorLayout, T t) {
            List<View> c2 = coordinatorLayout.c(t);
            int size = c2.size();
            for (int i2 = 0; i2 < size; i2++) {
                CoordinatorLayout.c d2 = ((CoordinatorLayout.f) c2.get(i2).getLayoutParams()).d();
                if (d2 instanceof ScrollingViewBehavior) {
                    return ((ScrollingViewBehavior) d2).c() != 0;
                }
            }
            return false;
        }

        /* loaded from: classes.dex */
        public static class c extends a.b.g.k.a {
            public static final Parcelable.Creator<c> CREATOR = new a();

            /* renamed from: c  reason: collision with root package name */
            public int f2114c;

            /* renamed from: d  reason: collision with root package name */
            public float f2115d;

            /* renamed from: e  reason: collision with root package name */
            public boolean f2116e;

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
                    return new c(parcel, null);
                }
            }

            public c(Parcel parcel, ClassLoader classLoader) {
                super(parcel, classLoader);
                this.f2114c = parcel.readInt();
                this.f2115d = parcel.readFloat();
                this.f2116e = parcel.readByte() != 0;
            }

            @Override // a.b.g.k.a, android.os.Parcelable
            public void writeToParcel(Parcel parcel, int i2) {
                super.writeToParcel(parcel, i2);
                parcel.writeInt(this.f2114c);
                parcel.writeFloat(this.f2115d);
                parcel.writeByte(this.f2116e ? (byte) 1 : (byte) 0);
            }

            public c(Parcelable parcelable) {
                super(parcelable);
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // android.support.design.widget.CoordinatorLayout.c
        public /* bridge */ /* synthetic */ boolean a(CoordinatorLayout coordinatorLayout, View view, int i2, int i3, int i4, int i5) {
            return a(coordinatorLayout, (CoordinatorLayout) ((AppBarLayout) view), i2, i3, i4, i5);
        }

        public int b(T t) {
            return -t.getDownNestedScrollRange();
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // android.support.design.widget.CoordinatorLayout.c
        public /* bridge */ /* synthetic */ void a(CoordinatorLayout coordinatorLayout, View view, View view2, int i2, int i3, int[] iArr, int i4) {
            a(coordinatorLayout, (CoordinatorLayout) ((AppBarLayout) view), view2, i2, i3, iArr, i4);
        }

        public final int b(T t, int i2) {
            int abs = Math.abs(i2);
            int childCount = t.getChildCount();
            int i3 = 0;
            int i4 = 0;
            while (true) {
                if (i4 >= childCount) {
                    break;
                }
                View childAt = t.getChildAt(i4);
                c cVar = (c) childAt.getLayoutParams();
                Interpolator b2 = cVar.b();
                if (abs < childAt.getTop() || abs > childAt.getBottom()) {
                    i4++;
                } else if (b2 != null) {
                    int a2 = cVar.a();
                    if ((a2 & 1) != 0) {
                        i3 = 0 + childAt.getHeight() + ((LinearLayout.LayoutParams) cVar).topMargin + ((LinearLayout.LayoutParams) cVar).bottomMargin;
                        if ((a2 & 2) != 0) {
                            i3 -= u.l(childAt);
                        }
                    }
                    if (u.h(childAt)) {
                        i3 -= t.getTopInset();
                    }
                    if (i3 > 0) {
                        float f2 = i3;
                        return Integer.signum(i2) * (childAt.getTop() + Math.round(f2 * b2.getInterpolation((abs - childAt.getTop()) / f2)));
                    }
                }
            }
            return i2;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // android.support.design.widget.CoordinatorLayout.c
        public /* bridge */ /* synthetic */ void a(CoordinatorLayout coordinatorLayout, View view, View view2, int i2, int i3, int i4, int i5, int i6) {
            a(coordinatorLayout, (CoordinatorLayout) ((AppBarLayout) view), view2, i2, i3, i4, i5, i6);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // android.support.design.widget.CoordinatorLayout.c
        public /* bridge */ /* synthetic */ void a(CoordinatorLayout coordinatorLayout, View view, Parcelable parcelable) {
            a(coordinatorLayout, (CoordinatorLayout) ((AppBarLayout) view), parcelable);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // android.support.design.widget.CoordinatorLayout.c
        public /* bridge */ /* synthetic */ void a(CoordinatorLayout coordinatorLayout, View view, View view2, int i2) {
            a(coordinatorLayout, (CoordinatorLayout) ((AppBarLayout) view), view2, i2);
        }

        public boolean a(CoordinatorLayout coordinatorLayout, T t, View view, View view2, int i2, int i3) {
            ValueAnimator valueAnimator;
            boolean z = (i2 & 2) != 0 && (t.e() || a(coordinatorLayout, (CoordinatorLayout) t, view));
            if (z && (valueAnimator = this.m) != null) {
                valueAnimator.cancel();
            }
            this.q = null;
            this.l = i3;
            return z;
        }

        public static View c(AppBarLayout appBarLayout, int i2) {
            int abs = Math.abs(i2);
            int childCount = appBarLayout.getChildCount();
            for (int i3 = 0; i3 < childCount; i3++) {
                View childAt = appBarLayout.getChildAt(i3);
                if (abs >= childAt.getTop() && abs <= childAt.getBottom()) {
                    return childAt;
                }
            }
            return null;
        }

        public final boolean a(CoordinatorLayout coordinatorLayout, T t, View view) {
            return t.c() && coordinatorLayout.getHeight() - view.getHeight() <= t.getHeight();
        }

        public void a(CoordinatorLayout coordinatorLayout, T t, View view, int i2, int i3, int[] iArr, int i4) {
            int i5;
            int i6;
            if (i3 != 0) {
                if (i3 < 0) {
                    int i7 = -t.getTotalScrollRange();
                    i5 = i7;
                    i6 = t.getDownNestedPreScrollRange() + i7;
                } else {
                    i5 = -t.getUpNestedPreScrollRange();
                    i6 = 0;
                }
                if (i5 != i6) {
                    iArr[1] = a(coordinatorLayout, (CoordinatorLayout) t, i3, i5, i6);
                    a(i3, (int) t, view, i4);
                }
            }
        }

        public Parcelable b(CoordinatorLayout coordinatorLayout, T t) {
            Parcelable d2 = super.d(coordinatorLayout, (CoordinatorLayout) t);
            int b2 = b();
            int childCount = t.getChildCount();
            for (int i2 = 0; i2 < childCount; i2++) {
                View childAt = t.getChildAt(i2);
                int bottom = childAt.getBottom() + b2;
                if (childAt.getTop() + b2 <= 0 && bottom >= 0) {
                    c cVar = new c(d2);
                    cVar.f2114c = i2;
                    cVar.f2116e = bottom == u.l(childAt) + t.getTopInset();
                    cVar.f2115d = bottom / childAt.getHeight();
                    return cVar;
                }
            }
            return d2;
        }

        public void a(CoordinatorLayout coordinatorLayout, T t, View view, int i2, int i3, int i4, int i5, int i6) {
            if (i5 < 0) {
                a(coordinatorLayout, (CoordinatorLayout) t, i5, -t.getDownNestedScrollRange(), 0);
                a(i5, (int) t, view, i6);
            }
            if (t.e()) {
                t.b(view.getScrollY() > 0);
            }
        }

        @Override // a.b.d.x.i
        public int d() {
            return b() + this.k;
        }

        public final void a(int i2, T t, View view, int i3) {
            if (i3 == 1) {
                int d2 = d();
                if ((i2 >= 0 || d2 != 0) && (i2 <= 0 || d2 != (-t.getDownNestedScrollRange()))) {
                    return;
                }
                u.h(view, 1);
            }
        }

        public void a(CoordinatorLayout coordinatorLayout, T t, View view, int i2) {
            if (this.l == 0 || i2 == 1) {
                d(coordinatorLayout, (CoordinatorLayout) t);
            }
            this.q = new WeakReference<>(view);
        }

        public final void a(CoordinatorLayout coordinatorLayout, T t, int i2, float f2) {
            int height;
            int abs = Math.abs(d() - i2);
            float abs2 = Math.abs(f2);
            if (abs2 > 0.0f) {
                height = Math.round((abs / abs2) * 1000.0f) * 3;
            } else {
                height = (int) (((abs / t.getHeight()) + 1.0f) * 150.0f);
            }
            a(coordinatorLayout, (CoordinatorLayout) t, i2, height);
        }

        public final void a(CoordinatorLayout coordinatorLayout, T t, int i2, int i3) {
            int d2 = d();
            if (d2 == i2) {
                ValueAnimator valueAnimator = this.m;
                if (valueAnimator == null || !valueAnimator.isRunning()) {
                    return;
                }
                this.m.cancel();
                return;
            }
            ValueAnimator valueAnimator2 = this.m;
            if (valueAnimator2 == null) {
                this.m = new ValueAnimator();
                this.m.setInterpolator(a.b.d.l.a.f214e);
                this.m.addUpdateListener(new a(coordinatorLayout, t));
            } else {
                valueAnimator2.cancel();
            }
            this.m.setDuration(Math.min(i3, 600));
            this.m.setIntValues(d2, i2);
            this.m.start();
        }

        public final int a(T t, int i2) {
            int childCount = t.getChildCount();
            for (int i3 = 0; i3 < childCount; i3++) {
                View childAt = t.getChildAt(i3);
                int top = childAt.getTop();
                int bottom = childAt.getBottom();
                c cVar = (c) childAt.getLayoutParams();
                if (a(cVar.a(), 32)) {
                    top -= ((LinearLayout.LayoutParams) cVar).topMargin;
                    bottom += ((LinearLayout.LayoutParams) cVar).bottomMargin;
                }
                int i4 = -i2;
                if (top <= i4 && bottom >= i4) {
                    return i3;
                }
            }
            return -1;
        }

        public boolean a(CoordinatorLayout coordinatorLayout, T t, int i2, int i3, int i4, int i5) {
            if (((ViewGroup.MarginLayoutParams) ((CoordinatorLayout.f) t.getLayoutParams())).height == -2) {
                coordinatorLayout.a(t, i2, i3, View.MeasureSpec.makeMeasureSpec(0, 0), i5);
                return true;
            }
            return super.a(coordinatorLayout, (CoordinatorLayout) t, i2, i3, i4, i5);
        }

        public boolean a(CoordinatorLayout coordinatorLayout, T t, int i2) {
            int round;
            boolean a2 = super.a(coordinatorLayout, (CoordinatorLayout) t, i2);
            int pendingAction = t.getPendingAction();
            int i3 = this.n;
            if (i3 >= 0 && (pendingAction & 8) == 0) {
                View childAt = t.getChildAt(i3);
                int i4 = -childAt.getBottom();
                if (this.o) {
                    round = u.l(childAt) + t.getTopInset();
                } else {
                    round = Math.round(childAt.getHeight() * this.p);
                }
                c(coordinatorLayout, (CoordinatorLayout) t, i4 + round);
            } else if (pendingAction != 0) {
                boolean z = (pendingAction & 4) != 0;
                if ((pendingAction & 2) != 0) {
                    int i5 = -t.getUpNestedPreScrollRange();
                    if (z) {
                        a(coordinatorLayout, (CoordinatorLayout) t, i5, 0.0f);
                    } else {
                        c(coordinatorLayout, (CoordinatorLayout) t, i5);
                    }
                } else if ((pendingAction & 1) != 0) {
                    if (z) {
                        a(coordinatorLayout, (CoordinatorLayout) t, 0, 0.0f);
                    } else {
                        c(coordinatorLayout, (CoordinatorLayout) t, 0);
                    }
                }
            }
            t.f();
            this.n = -1;
            a(a.b.g.e.a.a(b(), -t.getTotalScrollRange(), 0));
            a(coordinatorLayout, (CoordinatorLayout) t, b(), 0, true);
            t.a(b());
            return a2;
        }

        public boolean a(T t) {
            b bVar = this.r;
            if (bVar != null) {
                return bVar.a(t);
            }
            WeakReference<View> weakReference = this.q;
            if (weakReference != null) {
                View view = weakReference.get();
                return (view == null || !view.isShown() || view.canScrollVertically(-1)) ? false : true;
            }
            return true;
        }

        public void a(CoordinatorLayout coordinatorLayout, T t) {
            d(coordinatorLayout, (CoordinatorLayout) t);
        }

        public int a(CoordinatorLayout coordinatorLayout, T t, int i2, int i3, int i4) {
            int d2 = d();
            int i5 = 0;
            if (i3 != 0 && d2 >= i3 && d2 <= i4) {
                int a2 = a.b.g.e.a.a(i2, i3, i4);
                if (d2 != a2) {
                    int b2 = t.a() ? b((BaseBehavior<T>) t, a2) : a2;
                    boolean a3 = a(b2);
                    i5 = d2 - a2;
                    this.k = a2 - b2;
                    if (!a3 && t.a()) {
                        coordinatorLayout.a(t);
                    }
                    t.a(b());
                    a(coordinatorLayout, (CoordinatorLayout) t, a2, a2 < d2 ? -1 : 1, false);
                }
            } else {
                this.k = 0;
            }
            return i5;
        }

        /* JADX WARN: Removed duplicated region for block: B:25:0x0054  */
        /* JADX WARN: Removed duplicated region for block: B:26:0x0056  */
        /* JADX WARN: Removed duplicated region for block: B:29:0x0061  */
        /* JADX WARN: Removed duplicated region for block: B:36:? A[RETURN, SYNTHETIC] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final void a(android.support.design.widget.CoordinatorLayout r6, T r7, int r8, int r9, boolean r10) {
            /*
                r5 = this;
                android.view.View r0 = c(r7, r8)
                if (r0 == 0) goto L6e
                android.view.ViewGroup$LayoutParams r1 = r0.getLayoutParams()
                android.support.design.widget.AppBarLayout$c r1 = (android.support.design.widget.AppBarLayout.c) r1
                int r1 = r1.a()
                r2 = r1 & 1
                r3 = 1
                r4 = 0
                if (r2 == 0) goto L41
                int r2 = a.b.g.k.u.l(r0)
                if (r9 <= 0) goto L2f
                r9 = r1 & 12
                if (r9 == 0) goto L2f
                int r8 = -r8
                int r9 = r0.getBottom()
                int r9 = r9 - r2
                int r0 = r7.getTopInset()
                int r9 = r9 - r0
                if (r8 < r9) goto L41
            L2d:
                r8 = 1
                goto L42
            L2f:
                r9 = r1 & 2
                if (r9 == 0) goto L41
                int r8 = -r8
                int r9 = r0.getBottom()
                int r9 = r9 - r2
                int r0 = r7.getTopInset()
                int r9 = r9 - r0
                if (r8 < r9) goto L41
                goto L2d
            L41:
                r8 = 0
            L42:
                boolean r9 = r7.e()
                if (r9 == 0) goto L57
                android.view.View r9 = r5.a(r6)
                if (r9 == 0) goto L57
                int r8 = r9.getScrollY()
                if (r8 <= 0) goto L56
                r8 = 1
                goto L57
            L56:
                r8 = 0
            L57:
                boolean r8 = r7.b(r8)
                int r9 = android.os.Build.VERSION.SDK_INT
                r0 = 11
                if (r9 < r0) goto L6e
                if (r10 != 0) goto L6b
                if (r8 == 0) goto L6e
                boolean r6 = r5.c(r6, r7)
                if (r6 == 0) goto L6e
            L6b:
                r7.jumpDrawablesToCurrentState()
            L6e:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: android.support.design.widget.AppBarLayout.BaseBehavior.a(android.support.design.widget.CoordinatorLayout, android.support.design.widget.AppBarLayout, int, int, boolean):void");
        }

        public final View a(CoordinatorLayout coordinatorLayout) {
            int childCount = coordinatorLayout.getChildCount();
            for (int i2 = 0; i2 < childCount; i2++) {
                View childAt = coordinatorLayout.getChildAt(i2);
                if (childAt instanceof k) {
                    return childAt;
                }
            }
            return null;
        }

        public void a(CoordinatorLayout coordinatorLayout, T t, Parcelable parcelable) {
            if (parcelable instanceof c) {
                c cVar = (c) parcelable;
                super.a(coordinatorLayout, (CoordinatorLayout) t, cVar.a());
                this.n = cVar.f2114c;
                this.p = cVar.f2115d;
                this.o = cVar.f2116e;
                return;
            }
            super.a(coordinatorLayout, (CoordinatorLayout) t, parcelable);
            this.n = -1;
        }
    }

    /* loaded from: classes.dex */
    public static class Behavior extends BaseBehavior<AppBarLayout> {
        public Behavior() {
        }

        public Behavior(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }
    }

    /* loaded from: classes.dex */
    public static class ScrollingViewBehavior extends j {
        public ScrollingViewBehavior() {
        }

        @Override // a.b.d.x.j
        public /* bridge */ /* synthetic */ View a(List list) {
            return a((List<View>) list);
        }

        @Override // android.support.design.widget.CoordinatorLayout.c
        public boolean b(CoordinatorLayout coordinatorLayout, View view, View view2) {
            a(view, view2);
            b(view, view2);
            return false;
        }

        @Override // a.b.d.x.j
        public int c(View view) {
            if (view instanceof AppBarLayout) {
                return ((AppBarLayout) view).getTotalScrollRange();
            }
            return super.c(view);
        }

        public ScrollingViewBehavior(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, a.b.d.k.ScrollingViewBehavior_Layout);
            b(obtainStyledAttributes.getDimensionPixelSize(a.b.d.k.ScrollingViewBehavior_Layout_behavior_overlapTop, 0));
            obtainStyledAttributes.recycle();
        }

        @Override // android.support.design.widget.CoordinatorLayout.c
        public boolean a(CoordinatorLayout coordinatorLayout, View view, View view2) {
            return view2 instanceof AppBarLayout;
        }

        @Override // android.support.design.widget.CoordinatorLayout.c
        public boolean a(CoordinatorLayout coordinatorLayout, View view, Rect rect, boolean z) {
            AppBarLayout a2 = a(coordinatorLayout.b(view));
            if (a2 != null) {
                rect.offset(view.getLeft(), view.getTop());
                Rect rect2 = this.f357d;
                rect2.set(0, 0, coordinatorLayout.getWidth(), coordinatorLayout.getHeight());
                if (!rect2.contains(rect)) {
                    a2.a(false, !z);
                    return true;
                }
            }
            return false;
        }

        @Override // a.b.d.x.j
        public float b(View view) {
            int i2;
            if (view instanceof AppBarLayout) {
                AppBarLayout appBarLayout = (AppBarLayout) view;
                int totalScrollRange = appBarLayout.getTotalScrollRange();
                int downNestedPreScrollRange = appBarLayout.getDownNestedPreScrollRange();
                int a2 = a(appBarLayout);
                if ((downNestedPreScrollRange == 0 || totalScrollRange + a2 > downNestedPreScrollRange) && (i2 = totalScrollRange - downNestedPreScrollRange) != 0) {
                    return (a2 / i2) + 1.0f;
                }
            }
            return 0.0f;
        }

        public final void b(View view, View view2) {
            if (view2 instanceof AppBarLayout) {
                AppBarLayout appBarLayout = (AppBarLayout) view2;
                if (appBarLayout.e()) {
                    appBarLayout.b(view.getScrollY() > 0);
                }
            }
        }

        public final void a(View view, View view2) {
            CoordinatorLayout.c d2 = ((CoordinatorLayout.f) view2.getLayoutParams()).d();
            if (d2 instanceof BaseBehavior) {
                u.d(view, (((view2.getBottom() - view.getTop()) + ((BaseBehavior) d2).k) + d()) - a(view2));
            }
        }

        public static int a(AppBarLayout appBarLayout) {
            CoordinatorLayout.c d2 = ((CoordinatorLayout.f) appBarLayout.getLayoutParams()).d();
            if (d2 instanceof BaseBehavior) {
                return ((BaseBehavior) d2).d();
            }
            return 0;
        }

        @Override // a.b.d.x.j
        public AppBarLayout a(List<View> list) {
            int size = list.size();
            for (int i2 = 0; i2 < size; i2++) {
                View view = list.get(i2);
                if (view instanceof AppBarLayout) {
                    return (AppBarLayout) view;
                }
            }
            return null;
        }
    }

    /* loaded from: classes.dex */
    public class a implements p {
        public a() {
        }

        @Override // a.b.g.k.p
        public d0 a(View view, d0 d0Var) {
            return AppBarLayout.this.a(d0Var);
        }
    }

    /* loaded from: classes.dex */
    public interface b<T extends AppBarLayout> {
        void a(T t, int i2);
    }

    public AppBarLayout(Context context) {
        this(context, null);
    }

    public void a(boolean z, boolean z2) {
        a(z, z2, true);
    }

    public final boolean b() {
        int childCount = getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            if (((c) getChildAt(i2).getLayoutParams()).c()) {
                return true;
            }
        }
        return false;
    }

    public boolean c() {
        return getTotalScrollRange() != 0;
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup
    public boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof c;
    }

    public final void d() {
        this.f2102a = -1;
        this.f2103b = -1;
        this.f2104c = -1;
    }

    public boolean e() {
        return this.k;
    }

    public void f() {
        this.f2106e = 0;
    }

    public int getDownNestedPreScrollRange() {
        int topInset;
        int i2 = this.f2103b;
        if (i2 != -1) {
            return i2;
        }
        int i3 = 0;
        for (int childCount = getChildCount() - 1; childCount >= 0; childCount--) {
            View childAt = getChildAt(childCount);
            c cVar = (c) childAt.getLayoutParams();
            int measuredHeight = childAt.getMeasuredHeight();
            int i4 = cVar.f2118a;
            if ((i4 & 5) == 5) {
                int i5 = i3 + ((LinearLayout.LayoutParams) cVar).topMargin + ((LinearLayout.LayoutParams) cVar).bottomMargin;
                if ((i4 & 8) != 0) {
                    i3 = i5 + u.l(childAt);
                } else {
                    if ((i4 & 2) != 0) {
                        topInset = u.l(childAt);
                    } else {
                        topInset = getTopInset();
                    }
                    i3 = i5 + (measuredHeight - topInset);
                }
            } else if (i3 > 0) {
                break;
            }
        }
        int max = Math.max(0, i3);
        this.f2103b = max;
        return max;
    }

    public int getDownNestedScrollRange() {
        int i2 = this.f2104c;
        if (i2 != -1) {
            return i2;
        }
        int childCount = getChildCount();
        int i3 = 0;
        int i4 = 0;
        while (true) {
            if (i3 >= childCount) {
                break;
            }
            View childAt = getChildAt(i3);
            c cVar = (c) childAt.getLayoutParams();
            int measuredHeight = childAt.getMeasuredHeight() + ((LinearLayout.LayoutParams) cVar).topMargin + ((LinearLayout.LayoutParams) cVar).bottomMargin;
            int i5 = cVar.f2118a;
            if ((i5 & 1) == 0) {
                break;
            }
            i4 += measuredHeight;
            if ((i5 & 2) != 0) {
                i4 -= u.l(childAt) + getTopInset();
                break;
            }
            i3++;
        }
        int max = Math.max(0, i4);
        this.f2104c = max;
        return max;
    }

    public final int getMinimumHeightForVisibleOverlappingContent() {
        int topInset = getTopInset();
        int l = u.l(this);
        if (l == 0) {
            int childCount = getChildCount();
            l = childCount >= 1 ? u.l(getChildAt(childCount - 1)) : 0;
            if (l == 0) {
                return getHeight() / 3;
            }
        }
        return (l * 2) + topInset;
    }

    public int getPendingAction() {
        return this.f2106e;
    }

    @Deprecated
    public float getTargetElevation() {
        return 0.0f;
    }

    public final int getTopInset() {
        d0 d0Var = this.f2107f;
        if (d0Var != null) {
            return d0Var.d();
        }
        return 0;
    }

    public final int getTotalScrollRange() {
        int i2 = this.f2102a;
        if (i2 != -1) {
            return i2;
        }
        int childCount = getChildCount();
        int i3 = 0;
        int i4 = 0;
        while (true) {
            if (i3 >= childCount) {
                break;
            }
            View childAt = getChildAt(i3);
            c cVar = (c) childAt.getLayoutParams();
            int measuredHeight = childAt.getMeasuredHeight();
            int i5 = cVar.f2118a;
            if ((i5 & 1) == 0) {
                break;
            }
            i4 += measuredHeight + ((LinearLayout.LayoutParams) cVar).topMargin + ((LinearLayout.LayoutParams) cVar).bottomMargin;
            if ((i5 & 2) != 0) {
                i4 -= u.l(childAt);
                break;
            }
            i3++;
        }
        int max = Math.max(0, i4 - getTopInset());
        this.f2102a = max;
        return max;
    }

    public int getUpNestedPreScrollRange() {
        return getTotalScrollRange();
    }

    @Override // android.view.ViewGroup, android.view.View
    public int[] onCreateDrawableState(int i2) {
        if (this.m == null) {
            this.m = new int[4];
        }
        int[] iArr = this.m;
        int[] onCreateDrawableState = super.onCreateDrawableState(i2 + iArr.length);
        iArr[0] = this.f2110i ? a.b.d.b.state_liftable : -a.b.d.b.state_liftable;
        iArr[1] = (this.f2110i && this.j) ? a.b.d.b.state_lifted : -a.b.d.b.state_lifted;
        iArr[2] = this.f2110i ? a.b.d.b.state_collapsible : -a.b.d.b.state_collapsible;
        iArr[3] = (this.f2110i && this.j) ? a.b.d.b.state_collapsed : -a.b.d.b.state_collapsed;
        return LinearLayout.mergeDrawableStates(onCreateDrawableState, iArr);
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        super.onLayout(z, i2, i3, i4, i5);
        d();
        boolean z2 = false;
        this.f2105d = false;
        int childCount = getChildCount();
        int i6 = 0;
        while (true) {
            if (i6 >= childCount) {
                break;
            } else if (((c) getChildAt(i6).getLayoutParams()).b() != null) {
                this.f2105d = true;
                break;
            } else {
                i6++;
            }
        }
        if (this.f2109h) {
            return;
        }
        a((this.k || b()) ? true : true);
    }

    @Override // android.widget.LinearLayout, android.view.View
    public void onMeasure(int i2, int i3) {
        super.onMeasure(i2, i3);
        d();
    }

    public void setExpanded(boolean z) {
        a(z, u.x(this));
    }

    public void setLiftOnScroll(boolean z) {
        this.k = z;
    }

    @Override // android.widget.LinearLayout
    public void setOrientation(int i2) {
        if (i2 == 1) {
            super.setOrientation(i2);
            return;
        }
        throw new IllegalArgumentException("AppBarLayout is always vertical and does not support horizontal orientation");
    }

    @Deprecated
    public void setTargetElevation(float f2) {
        if (Build.VERSION.SDK_INT >= 21) {
            s.a(this, f2);
        }
    }

    public AppBarLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f2102a = -1;
        this.f2103b = -1;
        this.f2104c = -1;
        this.f2106e = 0;
        setOrientation(1);
        if (Build.VERSION.SDK_INT >= 21) {
            s.a(this);
            s.a(this, attributeSet, 0, a.b.d.j.Widget_Design_AppBarLayout);
        }
        TypedArray c2 = g.c(context, attributeSet, a.b.d.k.AppBarLayout, 0, a.b.d.j.Widget_Design_AppBarLayout, new int[0]);
        u.a(this, c2.getDrawable(a.b.d.k.AppBarLayout_android_background));
        if (c2.hasValue(a.b.d.k.AppBarLayout_expanded)) {
            a(c2.getBoolean(a.b.d.k.AppBarLayout_expanded, false), false, false);
        }
        if (Build.VERSION.SDK_INT >= 21 && c2.hasValue(a.b.d.k.AppBarLayout_elevation)) {
            s.a(this, c2.getDimensionPixelSize(a.b.d.k.AppBarLayout_elevation, 0));
        }
        if (Build.VERSION.SDK_INT >= 26) {
            if (c2.hasValue(a.b.d.k.AppBarLayout_android_keyboardNavigationCluster)) {
                setKeyboardNavigationCluster(c2.getBoolean(a.b.d.k.AppBarLayout_android_keyboardNavigationCluster, false));
            }
            if (c2.hasValue(a.b.d.k.AppBarLayout_android_touchscreenBlocksFocus)) {
                setTouchscreenBlocksFocus(c2.getBoolean(a.b.d.k.AppBarLayout_android_touchscreenBlocksFocus, false));
            }
        }
        this.k = c2.getBoolean(a.b.d.k.AppBarLayout_liftOnScroll, false);
        c2.recycle();
        u.a(this, new a());
    }

    public final void a(boolean z, boolean z2, boolean z3) {
        this.f2106e = (z ? 1 : 2) | (z2 ? 4 : 0) | (z3 ? 8 : 0);
        requestLayout();
    }

    public boolean b(boolean z) {
        if (this.j != z) {
            this.j = z;
            refreshDrawableState();
            return true;
        }
        return false;
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup
    public c generateDefaultLayoutParams() {
        return new c(-1, -2);
    }

    public boolean a() {
        return this.f2105d;
    }

    public void a(int i2) {
        List<b> list = this.f2108g;
        if (list != null) {
            int size = list.size();
            for (int i3 = 0; i3 < size; i3++) {
                b bVar = this.f2108g.get(i3);
                if (bVar != null) {
                    bVar.a(this, i2);
                }
            }
        }
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup
    public c generateLayoutParams(AttributeSet attributeSet) {
        return new c(getContext(), attributeSet);
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup
    public c generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        if (Build.VERSION.SDK_INT >= 19 && (layoutParams instanceof LinearLayout.LayoutParams)) {
            return new c((LinearLayout.LayoutParams) layoutParams);
        }
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            return new c((ViewGroup.MarginLayoutParams) layoutParams);
        }
        return new c(layoutParams);
    }

    /* loaded from: classes.dex */
    public static class c extends LinearLayout.LayoutParams {

        /* renamed from: a  reason: collision with root package name */
        public int f2118a;

        /* renamed from: b  reason: collision with root package name */
        public Interpolator f2119b;

        public c(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            this.f2118a = 1;
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, a.b.d.k.AppBarLayout_Layout);
            this.f2118a = obtainStyledAttributes.getInt(a.b.d.k.AppBarLayout_Layout_layout_scrollFlags, 0);
            if (obtainStyledAttributes.hasValue(a.b.d.k.AppBarLayout_Layout_layout_scrollInterpolator)) {
                this.f2119b = AnimationUtils.loadInterpolator(context, obtainStyledAttributes.getResourceId(a.b.d.k.AppBarLayout_Layout_layout_scrollInterpolator, 0));
            }
            obtainStyledAttributes.recycle();
        }

        public int a() {
            return this.f2118a;
        }

        public Interpolator b() {
            return this.f2119b;
        }

        public boolean c() {
            int i2 = this.f2118a;
            return (i2 & 1) == 1 && (i2 & 10) != 0;
        }

        public c(int i2, int i3) {
            super(i2, i3);
            this.f2118a = 1;
        }

        public c(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
            this.f2118a = 1;
        }

        public c(ViewGroup.MarginLayoutParams marginLayoutParams) {
            super(marginLayoutParams);
            this.f2118a = 1;
        }

        public c(LinearLayout.LayoutParams layoutParams) {
            super(layoutParams);
            this.f2118a = 1;
        }
    }

    public final boolean a(boolean z) {
        if (this.f2110i != z) {
            this.f2110i = z;
            refreshDrawableState();
            return true;
        }
        return false;
    }

    public d0 a(d0 d0Var) {
        d0 d0Var2 = u.h(this) ? d0Var : null;
        if (!a.b.g.j.i.a(this.f2107f, d0Var2)) {
            this.f2107f = d0Var2;
            d();
        }
        return d0Var;
    }
}
