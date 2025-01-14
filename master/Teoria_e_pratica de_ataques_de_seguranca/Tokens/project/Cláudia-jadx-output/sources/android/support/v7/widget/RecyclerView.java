package android.support.v7.widget;

import a.b.g.k.e0.c;
import a.b.h.k.d;
import a.b.h.k.g0;
import a.b.h.k.j0;
import a.b.h.k.m0;
import a.b.h.k.p0;
import a.b.h.k.r1;
import a.b.h.k.s1;
import a.b.h.k.x0;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.database.Observable;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseArray;
import android.view.FocusFinder;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityManager;
import android.view.animation.Interpolator;
import android.widget.EdgeEffect;
import android.widget.OverScroller;
import java.lang.ref.WeakReference;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
/* loaded from: classes.dex */
public class RecyclerView extends ViewGroup implements a.b.g.k.s, a.b.g.k.j {
    public static final int[] A0 = {16843830};
    public static final int[] B0 = {16842987};
    public static final boolean C0;
    public static final boolean D0;
    public static final boolean E0;
    public static final boolean F0;
    public static final boolean G0;
    public static final boolean H0;
    public static final Class<?>[] I0;
    public static final Interpolator J0;
    public int A;
    public boolean B;
    public final AccessibilityManager C;
    public List<q> D;
    public boolean E;
    public boolean F;
    public int G;
    public int H;
    public k I;
    public EdgeEffect J;
    public EdgeEffect K;
    public EdgeEffect L;
    public EdgeEffect M;
    public l N;
    public int O;
    public int P;
    public VelocityTracker Q;
    public int R;
    public int S;
    public int T;
    public int U;
    public int V;
    public r W;

    /* renamed from: a  reason: collision with root package name */
    public final x f2552a;
    public final int a0;

    /* renamed from: b  reason: collision with root package name */
    public final v f2553b;
    public final int b0;

    /* renamed from: c  reason: collision with root package name */
    public y f2554c;
    public float c0;

    /* renamed from: d  reason: collision with root package name */
    public a.b.h.k.d f2555d;
    public float d0;

    /* renamed from: e  reason: collision with root package name */
    public g0 f2556e;
    public boolean e0;

    /* renamed from: f  reason: collision with root package name */
    public final s1 f2557f;
    public final c0 f0;

    /* renamed from: g  reason: collision with root package name */
    public boolean f2558g;
    public p0 g0;

    /* renamed from: h  reason: collision with root package name */
    public final Runnable f2559h;
    public p0.b h0;

    /* renamed from: i  reason: collision with root package name */
    public final Rect f2560i;
    public final a0 i0;
    public final Rect j;
    public t j0;
    public final RectF k;
    public List<t> k0;
    public boolean l0;
    public g m;
    public boolean m0;
    public o n;
    public l.b n0;
    public w o;
    public boolean o0;
    public final ArrayList<n> p;
    public x0 p0;
    public final ArrayList<s> q;
    public j q0;
    public s r;
    public final int[] r0;
    public boolean s;
    public a.b.g.k.l s0;
    public boolean t;
    public final int[] t0;
    public boolean u;
    public final int[] u0;
    public boolean v;
    public final int[] v0;
    public int w;
    public final int[] w0;
    public boolean x;
    public final List<d0> x0;
    public boolean y;
    public Runnable y0;
    public boolean z;
    public final s1.b z0;

    /* loaded from: classes.dex */
    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            RecyclerView recyclerView = RecyclerView.this;
            if (!recyclerView.v || recyclerView.isLayoutRequested()) {
                return;
            }
            RecyclerView recyclerView2 = RecyclerView.this;
            if (!recyclerView2.s) {
                recyclerView2.requestLayout();
            } else if (recyclerView2.y) {
                recyclerView2.x = true;
            } else {
                recyclerView2.c();
            }
        }
    }

    /* loaded from: classes.dex */
    public class b implements Runnable {
        public b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            l lVar = RecyclerView.this.N;
            if (lVar != null) {
                lVar.i();
            }
            RecyclerView.this.o0 = false;
        }
    }

    /* loaded from: classes.dex */
    public static abstract class b0 {
        public abstract View a(v vVar, int i2, int i3);
    }

    /* loaded from: classes.dex */
    public static class c implements Interpolator {
        @Override // android.animation.TimeInterpolator
        public float getInterpolation(float f2) {
            float f3 = f2 - 1.0f;
            return (f3 * f3 * f3 * f3 * f3) + 1.0f;
        }
    }

    /* loaded from: classes.dex */
    public class e implements g0.b {
        public e() {
        }

        @Override // a.b.h.k.g0.b
        public int a() {
            return RecyclerView.this.getChildCount();
        }

        @Override // a.b.h.k.g0.b
        public void b() {
            int a2 = a();
            for (int i2 = 0; i2 < a2; i2++) {
                View a3 = a(i2);
                RecyclerView.this.b(a3);
                a3.clearAnimation();
            }
            RecyclerView.this.removeAllViews();
        }

        @Override // a.b.h.k.g0.b
        public void c(int i2) {
            View childAt = RecyclerView.this.getChildAt(i2);
            if (childAt != null) {
                RecyclerView.this.b(childAt);
                childAt.clearAnimation();
            }
            RecyclerView.this.removeViewAt(i2);
        }

        @Override // a.b.h.k.g0.b
        public int d(View view) {
            return RecyclerView.this.indexOfChild(view);
        }

        @Override // a.b.h.k.g0.b
        public void a(View view, int i2) {
            RecyclerView.this.addView(view, i2);
            RecyclerView.this.a(view);
        }

        @Override // a.b.h.k.g0.b
        public View a(int i2) {
            return RecyclerView.this.getChildAt(i2);
        }

        @Override // a.b.h.k.g0.b
        public void a(View view, int i2, ViewGroup.LayoutParams layoutParams) {
            d0 m = RecyclerView.m(view);
            if (m != null) {
                if (!m.t() && !m.z()) {
                    throw new IllegalArgumentException("Called attach on a child which is not detached: " + m + RecyclerView.this.n());
                }
                m.e();
            }
            RecyclerView.this.attachViewToParent(view, i2, layoutParams);
        }

        @Override // a.b.h.k.g0.b
        public void c(View view) {
            d0 m = RecyclerView.m(view);
            if (m != null) {
                m.b(RecyclerView.this);
            }
        }

        @Override // a.b.h.k.g0.b
        public d0 b(View view) {
            return RecyclerView.m(view);
        }

        @Override // a.b.h.k.g0.b
        public void b(int i2) {
            d0 m;
            View a2 = a(i2);
            if (a2 != null && (m = RecyclerView.m(a2)) != null) {
                if (m.t() && !m.z()) {
                    throw new IllegalArgumentException("called detach on an already detached child " + m + RecyclerView.this.n());
                }
                m.a(256);
            }
            RecyclerView.this.detachViewFromParent(i2);
        }

        @Override // a.b.h.k.g0.b
        public void a(View view) {
            d0 m = RecyclerView.m(view);
            if (m != null) {
                m.a(RecyclerView.this);
            }
        }
    }

    /* loaded from: classes.dex */
    public static abstract class g<VH extends d0> {

        /* renamed from: a  reason: collision with root package name */
        public final h f2591a = new h();

        /* renamed from: b  reason: collision with root package name */
        public boolean f2592b = false;

        public abstract int a();

        public void a(VH vh, int i2, List<Object> list) {
            b((g<VH>) vh, i2);
        }

        public void a(RecyclerView recyclerView) {
        }

        public boolean a(VH vh) {
            return false;
        }

        public long b(int i2) {
            return -1L;
        }

        public abstract VH b(ViewGroup viewGroup, int i2);

        public void b(VH vh) {
        }

        public abstract void b(VH vh, int i2);

        public void b(RecyclerView recyclerView) {
        }

        public final boolean b() {
            return this.f2591a.a();
        }

        public int c(int i2) {
            return 0;
        }

        public void c(VH vh) {
        }

        public final boolean c() {
            return this.f2592b;
        }

        public final void d() {
            this.f2591a.b();
        }

        public void d(VH vh) {
        }

        public final void e(int i2) {
            this.f2591a.c(i2, 1);
        }

        public final void f(int i2) {
            this.f2591a.d(i2, 1);
        }

        public final VH a(ViewGroup viewGroup, int i2) {
            try {
                a.b.g.g.h.a("RV CreateView");
                VH b2 = b(viewGroup, i2);
                if (b2.f2580a.getParent() == null) {
                    b2.f2585f = i2;
                    return b2;
                }
                throw new IllegalStateException("ViewHolder views must not be attached when created. Ensure that you are not passing 'true' to the attachToRoot parameter of LayoutInflater.inflate(..., boolean attachToRoot)");
            } finally {
                a.b.g.g.h.a();
            }
        }

        public void b(i iVar) {
            this.f2591a.unregisterObserver(iVar);
        }

        public final void c(int i2, int i3) {
            this.f2591a.d(i2, i3);
        }

        public final void d(int i2) {
            this.f2591a.b(i2, 1);
        }

        public final void b(int i2, int i3) {
            this.f2591a.c(i2, i3);
        }

        public final void a(VH vh, int i2) {
            vh.f2582c = i2;
            if (c()) {
                vh.f2584e = b(i2);
            }
            vh.a(1, 519);
            a.b.g.g.h.a("RV OnBindView");
            a((g<VH>) vh, i2, vh.m());
            vh.c();
            ViewGroup.LayoutParams layoutParams = vh.f2580a.getLayoutParams();
            if (layoutParams instanceof p) {
                ((p) layoutParams).f2619c = true;
            }
            a.b.g.g.h.a();
        }

        public void a(boolean z) {
            if (!b()) {
                this.f2592b = z;
                return;
            }
            throw new IllegalStateException("Cannot change whether this adapter has stable IDs while the adapter has registered observers.");
        }

        public void a(i iVar) {
            this.f2591a.registerObserver(iVar);
        }

        public final void a(int i2, Object obj) {
            this.f2591a.a(i2, 1, obj);
        }

        public final void a(int i2, int i3, Object obj) {
            this.f2591a.a(i2, i3, obj);
        }

        public final void a(int i2, int i3) {
            this.f2591a.a(i2, i3);
        }
    }

    /* loaded from: classes.dex */
    public static class h extends Observable<i> {
        public boolean a() {
            return !((Observable) this).mObservers.isEmpty();
        }

        public void b() {
            for (int size = ((Observable) this).mObservers.size() - 1; size >= 0; size--) {
                ((i) ((Observable) this).mObservers.get(size)).a();
            }
        }

        public void c(int i2, int i3) {
            for (int size = ((Observable) this).mObservers.size() - 1; size >= 0; size--) {
                ((i) ((Observable) this).mObservers.get(size)).b(i2, i3);
            }
        }

        public void d(int i2, int i3) {
            for (int size = ((Observable) this).mObservers.size() - 1; size >= 0; size--) {
                ((i) ((Observable) this).mObservers.get(size)).c(i2, i3);
            }
        }

        public void a(int i2, int i3, Object obj) {
            for (int size = ((Observable) this).mObservers.size() - 1; size >= 0; size--) {
                ((i) ((Observable) this).mObservers.get(size)).a(i2, i3, obj);
            }
        }

        public void b(int i2, int i3) {
            a(i2, i3, null);
        }

        public void a(int i2, int i3) {
            for (int size = ((Observable) this).mObservers.size() - 1; size >= 0; size--) {
                ((i) ((Observable) this).mObservers.get(size)).a(i2, i3, 1);
            }
        }
    }

    /* loaded from: classes.dex */
    public static abstract class i {
        public void a() {
        }

        public void a(int i2, int i3) {
        }

        public void a(int i2, int i3, int i4) {
        }

        public void a(int i2, int i3, Object obj) {
            a(i2, i3);
        }

        public void b(int i2, int i3) {
        }

        public void c(int i2, int i3) {
        }
    }

    /* loaded from: classes.dex */
    public interface j {
        int a(int i2, int i3);
    }

    /* loaded from: classes.dex */
    public static class k {
        public EdgeEffect a(RecyclerView recyclerView, int i2) {
            return new EdgeEffect(recyclerView.getContext());
        }
    }

    /* loaded from: classes.dex */
    public static abstract class l {

        /* renamed from: a  reason: collision with root package name */
        public b f2593a = null;

        /* renamed from: b  reason: collision with root package name */
        public ArrayList<a> f2594b = new ArrayList<>();

        /* renamed from: c  reason: collision with root package name */
        public long f2595c = 120;

        /* renamed from: d  reason: collision with root package name */
        public long f2596d = 120;

        /* renamed from: e  reason: collision with root package name */
        public long f2597e = 250;

        /* renamed from: f  reason: collision with root package name */
        public long f2598f = 250;

        /* loaded from: classes.dex */
        public interface a {
            void a();
        }

        /* loaded from: classes.dex */
        public interface b {
            void a(d0 d0Var);
        }

        /* loaded from: classes.dex */
        public static class c {

            /* renamed from: a  reason: collision with root package name */
            public int f2599a;

            /* renamed from: b  reason: collision with root package name */
            public int f2600b;

            public c a(d0 d0Var) {
                a(d0Var, 0);
                return this;
            }

            public c a(d0 d0Var, int i2) {
                View view = d0Var.f2580a;
                this.f2599a = view.getLeft();
                this.f2600b = view.getTop();
                view.getRight();
                view.getBottom();
                return this;
            }
        }

        public static int g(d0 d0Var) {
            int i2 = d0Var.j & 14;
            if (d0Var.p()) {
                return 4;
            }
            if ((i2 & 4) == 0) {
                int l = d0Var.l();
                int h2 = d0Var.h();
                return (l == -1 || h2 == -1 || l == h2) ? i2 : i2 | 2048;
            }
            return i2;
        }

        public void a(b bVar) {
            this.f2593a = bVar;
        }

        public boolean a(d0 d0Var) {
            return true;
        }

        public abstract boolean a(d0 d0Var, d0 d0Var2, c cVar, c cVar2);

        public abstract boolean a(d0 d0Var, c cVar, c cVar2);

        public abstract void b();

        public final void b(d0 d0Var) {
            e(d0Var);
            b bVar = this.f2593a;
            if (bVar != null) {
                bVar.a(d0Var);
            }
        }

        public abstract boolean b(d0 d0Var, c cVar, c cVar2);

        public long c() {
            return this.f2595c;
        }

        public abstract boolean c(d0 d0Var, c cVar, c cVar2);

        public long d() {
            return this.f2598f;
        }

        public abstract void d(d0 d0Var);

        public long e() {
            return this.f2597e;
        }

        public void e(d0 d0Var) {
        }

        public long f() {
            return this.f2596d;
        }

        public void f(d0 d0Var) {
        }

        public abstract boolean g();

        public c h() {
            return new c();
        }

        public abstract void i();

        public c a(a0 a0Var, d0 d0Var, int i2, List<Object> list) {
            c h2 = h();
            h2.a(d0Var);
            return h2;
        }

        public final void c(d0 d0Var) {
            f(d0Var);
        }

        public c a(a0 a0Var, d0 d0Var) {
            c h2 = h();
            h2.a(d0Var);
            return h2;
        }

        public boolean a(d0 d0Var, List<Object> list) {
            return a(d0Var);
        }

        public final void a() {
            int size = this.f2594b.size();
            for (int i2 = 0; i2 < size; i2++) {
                this.f2594b.get(i2).a();
            }
            this.f2594b.clear();
        }
    }

    /* loaded from: classes.dex */
    public class m implements l.b {
        public m() {
        }

        @Override // android.support.v7.widget.RecyclerView.l.b
        public void a(d0 d0Var) {
            d0Var.a(true);
            if (d0Var.f2587h != null && d0Var.f2588i == null) {
                d0Var.f2587h = null;
            }
            d0Var.f2588i = null;
            if (d0Var.y() || RecyclerView.this.k(d0Var.f2580a) || !d0Var.t()) {
                return;
            }
            RecyclerView.this.removeDetachedView(d0Var.f2580a, false);
        }
    }

    /* loaded from: classes.dex */
    public static abstract class n {
        @Deprecated
        public void a(Canvas canvas, RecyclerView recyclerView) {
        }

        public void a(Canvas canvas, RecyclerView recyclerView, a0 a0Var) {
            a(canvas, recyclerView);
        }

        @Deprecated
        public void b(Canvas canvas, RecyclerView recyclerView) {
        }

        public void b(Canvas canvas, RecyclerView recyclerView, a0 a0Var) {
            b(canvas, recyclerView);
        }

        @Deprecated
        public void a(Rect rect, int i2, RecyclerView recyclerView) {
            rect.set(0, 0, 0, 0);
        }

        public void a(Rect rect, View view, RecyclerView recyclerView, a0 a0Var) {
            a(rect, ((p) view.getLayoutParams()).a(), recyclerView);
        }
    }

    /* loaded from: classes.dex */
    public static abstract class o {

        /* renamed from: a  reason: collision with root package name */
        public g0 f2602a;

        /* renamed from: b  reason: collision with root package name */
        public RecyclerView f2603b;

        /* renamed from: g  reason: collision with root package name */
        public z f2608g;
        public int m;
        public boolean n;
        public int o;
        public int p;
        public int q;
        public int r;

        /* renamed from: c  reason: collision with root package name */
        public final r1.b f2604c = new a();

        /* renamed from: d  reason: collision with root package name */
        public final r1.b f2605d = new b();

        /* renamed from: e  reason: collision with root package name */
        public r1 f2606e = new r1(this.f2604c);

        /* renamed from: f  reason: collision with root package name */
        public r1 f2607f = new r1(this.f2605d);

        /* renamed from: h  reason: collision with root package name */
        public boolean f2609h = false;

        /* renamed from: i  reason: collision with root package name */
        public boolean f2610i = false;
        public boolean j = false;
        public boolean k = true;
        public boolean l = true;

        /* loaded from: classes.dex */
        public class a implements r1.b {
            public a() {
            }

            @Override // a.b.h.k.r1.b
            public View a(int i2) {
                return o.this.c(i2);
            }

            @Override // a.b.h.k.r1.b
            public int b() {
                return o.this.n();
            }

            @Override // a.b.h.k.r1.b
            public int a() {
                return o.this.q() - o.this.o();
            }

            @Override // a.b.h.k.r1.b
            public int b(View view) {
                return o.this.i(view) + ((ViewGroup.MarginLayoutParams) ((p) view.getLayoutParams())).rightMargin;
            }

            @Override // a.b.h.k.r1.b
            public int a(View view) {
                return o.this.f(view) - ((ViewGroup.MarginLayoutParams) ((p) view.getLayoutParams())).leftMargin;
            }
        }

        /* loaded from: classes.dex */
        public class b implements r1.b {
            public b() {
            }

            @Override // a.b.h.k.r1.b
            public View a(int i2) {
                return o.this.c(i2);
            }

            @Override // a.b.h.k.r1.b
            public int b() {
                return o.this.p();
            }

            @Override // a.b.h.k.r1.b
            public int a() {
                return o.this.h() - o.this.m();
            }

            @Override // a.b.h.k.r1.b
            public int b(View view) {
                return o.this.e(view) + ((ViewGroup.MarginLayoutParams) ((p) view.getLayoutParams())).bottomMargin;
            }

            @Override // a.b.h.k.r1.b
            public int a(View view) {
                return o.this.j(view) - ((ViewGroup.MarginLayoutParams) ((p) view.getLayoutParams())).topMargin;
            }
        }

        /* loaded from: classes.dex */
        public interface c {
            void a(int i2, int i3);
        }

        /* loaded from: classes.dex */
        public static class d {

            /* renamed from: a  reason: collision with root package name */
            public int f2613a;

            /* renamed from: b  reason: collision with root package name */
            public int f2614b;

            /* renamed from: c  reason: collision with root package name */
            public boolean f2615c;

            /* renamed from: d  reason: collision with root package name */
            public boolean f2616d;
        }

        public boolean A() {
            return false;
        }

        public void B() {
            z zVar = this.f2608g;
            if (zVar != null) {
                zVar.d();
            }
        }

        public boolean C() {
            return false;
        }

        public int a(int i2, v vVar, a0 a0Var) {
            return 0;
        }

        public int a(a0 a0Var) {
            return 0;
        }

        public View a(View view, int i2, v vVar, a0 a0Var) {
            return null;
        }

        public void a(int i2, int i3, a0 a0Var, c cVar) {
        }

        public void a(int i2, c cVar) {
        }

        public void a(Rect rect, int i2, int i3) {
            c(a(i2, rect.width() + n() + o(), l()), a(i3, rect.height() + p() + m(), k()));
        }

        public void a(Parcelable parcelable) {
        }

        public void a(g gVar, g gVar2) {
        }

        public void a(RecyclerView recyclerView, int i2, int i3, int i4) {
        }

        public boolean a() {
            return false;
        }

        public boolean a(p pVar) {
            return pVar != null;
        }

        public boolean a(v vVar, a0 a0Var, View view, int i2, Bundle bundle) {
            return false;
        }

        public boolean a(RecyclerView recyclerView, ArrayList<View> arrayList, int i2, int i3) {
            return false;
        }

        public int b(int i2, v vVar, a0 a0Var) {
            return 0;
        }

        public int b(a0 a0Var) {
            return 0;
        }

        public void b(int i2, int i3) {
            this.q = View.MeasureSpec.getSize(i2);
            this.o = View.MeasureSpec.getMode(i2);
            if (this.o == 0 && !RecyclerView.D0) {
                this.q = 0;
            }
            this.r = View.MeasureSpec.getSize(i3);
            this.p = View.MeasureSpec.getMode(i3);
            if (this.p != 0 || RecyclerView.D0) {
                return;
            }
            this.r = 0;
        }

        public void b(RecyclerView recyclerView) {
        }

        public void b(RecyclerView recyclerView, int i2, int i3) {
        }

        public boolean b() {
            return false;
        }

        public int c(a0 a0Var) {
            return 0;
        }

        public int c(v vVar, a0 a0Var) {
            return 0;
        }

        public abstract p c();

        public View c(View view) {
            View c2;
            RecyclerView recyclerView = this.f2603b;
            if (recyclerView == null || (c2 = recyclerView.c(view)) == null || this.f2602a.d(c2)) {
                return null;
            }
            return c2;
        }

        @Deprecated
        public void c(RecyclerView recyclerView) {
        }

        public void c(RecyclerView recyclerView, int i2, int i3) {
        }

        public int d() {
            return -1;
        }

        public int d(a0 a0Var) {
            return 0;
        }

        public View d(View view, int i2) {
            return null;
        }

        public void d(int i2, int i3) {
            int e2 = e();
            if (e2 == 0) {
                this.f2603b.c(i2, i3);
                return;
            }
            int i4 = Integer.MAX_VALUE;
            int i5 = Integer.MAX_VALUE;
            int i6 = Integer.MIN_VALUE;
            int i7 = Integer.MIN_VALUE;
            for (int i8 = 0; i8 < e2; i8++) {
                View c2 = c(i8);
                Rect rect = this.f2603b.f2560i;
                b(c2, rect);
                int i9 = rect.left;
                if (i9 < i4) {
                    i4 = i9;
                }
                int i10 = rect.right;
                if (i10 > i6) {
                    i6 = i10;
                }
                int i11 = rect.top;
                if (i11 < i5) {
                    i5 = i11;
                }
                int i12 = rect.bottom;
                if (i12 > i7) {
                    i7 = i12;
                }
            }
            this.f2603b.f2560i.set(i4, i5, i6, i7);
            a(this.f2603b.f2560i, i2, i3);
        }

        public void d(RecyclerView recyclerView) {
        }

        public void d(RecyclerView recyclerView, int i2, int i3) {
        }

        public boolean d(v vVar, a0 a0Var) {
            return false;
        }

        public int e(a0 a0Var) {
            return 0;
        }

        public void e(v vVar, a0 a0Var) {
            Log.e("RecyclerView", "You must override onLayoutChildren(Recycler recycler, State state) ");
        }

        public int f(a0 a0Var) {
            return 0;
        }

        public void f(int i2) {
        }

        public void f(RecyclerView recyclerView) {
            if (recyclerView == null) {
                this.f2603b = null;
                this.f2602a = null;
                this.q = 0;
                this.r = 0;
            } else {
                this.f2603b = recyclerView;
                this.f2602a = recyclerView.f2556e;
                this.q = recyclerView.getWidth();
                this.r = recyclerView.getHeight();
            }
            this.o = 1073741824;
            this.p = 1073741824;
        }

        public void g(int i2) {
            if (c(i2) != null) {
                this.f2602a.f(i2);
            }
        }

        public void g(a0 a0Var) {
        }

        public int h() {
            return this.r;
        }

        public void h(int i2) {
        }

        public int i() {
            return this.p;
        }

        public int j() {
            return a.b.g.k.u.k(this.f2603b);
        }

        public int k(View view) {
            return ((p) view.getLayoutParams()).f2618b.left;
        }

        public int l(View view) {
            return ((p) view.getLayoutParams()).a();
        }

        public int m() {
            RecyclerView recyclerView = this.f2603b;
            if (recyclerView != null) {
                return recyclerView.getPaddingBottom();
            }
            return 0;
        }

        public int n() {
            RecyclerView recyclerView = this.f2603b;
            if (recyclerView != null) {
                return recyclerView.getPaddingLeft();
            }
            return 0;
        }

        public void o(View view) {
            this.f2602a.e(view);
        }

        public int p() {
            RecyclerView recyclerView = this.f2603b;
            if (recyclerView != null) {
                return recyclerView.getPaddingTop();
            }
            return 0;
        }

        public int q() {
            return this.q;
        }

        public int r() {
            return this.o;
        }

        public boolean s() {
            int e2 = e();
            for (int i2 = 0; i2 < e2; i2++) {
                ViewGroup.LayoutParams layoutParams = c(i2).getLayoutParams();
                if (layoutParams.width < 0 && layoutParams.height < 0) {
                    return true;
                }
            }
            return false;
        }

        public boolean t() {
            return this.f2610i;
        }

        public boolean u() {
            return this.j;
        }

        public final boolean v() {
            return this.l;
        }

        public boolean w() {
            z zVar = this.f2608g;
            return zVar != null && zVar.c();
        }

        public Parcelable x() {
            return null;
        }

        public void y() {
            RecyclerView recyclerView = this.f2603b;
            if (recyclerView != null) {
                recyclerView.requestLayout();
            }
        }

        public void z() {
            this.f2609h = true;
        }

        public int e() {
            g0 g0Var = this.f2602a;
            if (g0Var != null) {
                return g0Var.a();
            }
            return 0;
        }

        public int h(View view) {
            Rect rect = ((p) view.getLayoutParams()).f2618b;
            return view.getMeasuredWidth() + rect.left + rect.right;
        }

        public int i(View view) {
            return view.getRight() + m(view);
        }

        public int j(View view) {
            return view.getTop() - n(view);
        }

        public int k() {
            return a.b.g.k.u.l(this.f2603b);
        }

        public int l() {
            return a.b.g.k.u.m(this.f2603b);
        }

        public int m(View view) {
            return ((p) view.getLayoutParams()).f2618b.right;
        }

        public int n(View view) {
            return ((p) view.getLayoutParams()).f2618b.top;
        }

        public int o() {
            RecyclerView recyclerView = this.f2603b;
            if (recyclerView != null) {
                return recyclerView.getPaddingRight();
            }
            return 0;
        }

        public void e(int i2) {
            RecyclerView recyclerView = this.f2603b;
            if (recyclerView != null) {
                recyclerView.f(i2);
            }
        }

        public View g() {
            View focusedChild;
            RecyclerView recyclerView = this.f2603b;
            if (recyclerView == null || (focusedChild = recyclerView.getFocusedChild()) == null || this.f2602a.d(focusedChild)) {
                return null;
            }
            return focusedChild;
        }

        public void c(View view, int i2) {
            a(view, i2, (p) view.getLayoutParams());
        }

        public View c(int i2) {
            g0 g0Var = this.f2602a;
            if (g0Var != null) {
                return g0Var.c(i2);
            }
            return null;
        }

        public int e(View view) {
            return view.getBottom() + d(view);
        }

        public static int a(int i2, int i3, int i4) {
            int mode = View.MeasureSpec.getMode(i2);
            int size = View.MeasureSpec.getSize(i2);
            if (mode != Integer.MIN_VALUE) {
                return mode != 1073741824 ? Math.max(i3, i4) : size;
            }
            return Math.min(size, Math.max(i3, i4));
        }

        public void c(v vVar) {
            int e2 = vVar.e();
            for (int i2 = e2 - 1; i2 >= 0; i2--) {
                View c2 = vVar.c(i2);
                d0 m = RecyclerView.m(c2);
                if (!m.z()) {
                    m.a(false);
                    if (m.t()) {
                        this.f2603b.removeDetachedView(c2, false);
                    }
                    l lVar = this.f2603b.N;
                    if (lVar != null) {
                        lVar.d(m);
                    }
                    m.a(true);
                    vVar.a(c2);
                }
            }
            vVar.c();
            if (e2 > 0) {
                this.f2603b.invalidate();
            }
        }

        public void e(RecyclerView recyclerView) {
            b(View.MeasureSpec.makeMeasureSpec(recyclerView.getWidth(), 1073741824), View.MeasureSpec.makeMeasureSpec(recyclerView.getHeight(), 1073741824));
        }

        public int g(View view) {
            Rect rect = ((p) view.getLayoutParams()).f2618b;
            return view.getMeasuredHeight() + rect.top + rect.bottom;
        }

        public void b(RecyclerView recyclerView, v vVar) {
            c(recyclerView);
        }

        public void a(String str) {
            RecyclerView recyclerView = this.f2603b;
            if (recyclerView != null) {
                recyclerView.a(str);
            }
        }

        public void b(View view) {
            b(view, -1);
        }

        public void b(View view, int i2) {
            a(view, i2, false);
        }

        public boolean f() {
            RecyclerView recyclerView = this.f2603b;
            return recyclerView != null && recyclerView.f2558g;
        }

        public void a(RecyclerView recyclerView) {
            this.f2610i = true;
            b(recyclerView);
        }

        public View b(int i2) {
            int e2 = e();
            for (int i3 = 0; i3 < e2; i3++) {
                View c2 = c(i3);
                d0 m = RecyclerView.m(c2);
                if (m != null && m.k() == i2 && !m.z() && (this.f2603b.i0.d() || !m.r())) {
                    return c2;
                }
            }
            return null;
        }

        public void d(int i2) {
            RecyclerView recyclerView = this.f2603b;
            if (recyclerView != null) {
                recyclerView.e(i2);
            }
        }

        public int f(View view) {
            return view.getLeft() - k(view);
        }

        public void a(RecyclerView recyclerView, v vVar) {
            this.f2610i = false;
            b(recyclerView, vVar);
        }

        public int d(View view) {
            return ((p) view.getLayoutParams()).f2618b.bottom;
        }

        public boolean a(Runnable runnable) {
            RecyclerView recyclerView = this.f2603b;
            if (recyclerView != null) {
                return recyclerView.removeCallbacks(runnable);
            }
            return false;
        }

        public boolean b(View view, int i2, int i3, p pVar) {
            return (this.k && b(view.getMeasuredWidth(), i2, ((ViewGroup.MarginLayoutParams) pVar).width) && b(view.getMeasuredHeight(), i3, ((ViewGroup.MarginLayoutParams) pVar).height)) ? false : true;
        }

        public p a(ViewGroup.LayoutParams layoutParams) {
            if (layoutParams instanceof p) {
                return new p((p) layoutParams);
            }
            if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                return new p((ViewGroup.MarginLayoutParams) layoutParams);
            }
            return new p(layoutParams);
        }

        public void c(int i2, int i3) {
            this.f2603b.setMeasuredDimension(i2, i3);
        }

        public static boolean b(int i2, int i3, int i4) {
            int mode = View.MeasureSpec.getMode(i3);
            int size = View.MeasureSpec.getSize(i3);
            if (i4 <= 0 || i2 == i4) {
                if (mode == Integer.MIN_VALUE) {
                    return size >= i2;
                } else if (mode != 0) {
                    return mode == 1073741824 && size == i2;
                } else {
                    return true;
                }
            }
            return false;
        }

        public void b(View view, Rect rect) {
            RecyclerView.a(view, rect);
        }

        public p a(Context context, AttributeSet attributeSet) {
            return new p(context, attributeSet);
        }

        public boolean b(RecyclerView recyclerView, View view, Rect rect, boolean z) {
            return a(recyclerView, view, rect, z, false);
        }

        public void a(View view) {
            a(view, -1);
        }

        public void b(v vVar) {
            for (int e2 = e() - 1; e2 >= 0; e2--) {
                if (!RecyclerView.m(c(e2)).z()) {
                    a(e2, vVar);
                }
            }
        }

        public void a(View view, int i2) {
            a(view, i2, true);
        }

        public final void a(View view, int i2, boolean z) {
            d0 m = RecyclerView.m(view);
            if (!z && !m.r()) {
                this.f2603b.f2557f.g(m);
            } else {
                this.f2603b.f2557f.a(m);
            }
            p pVar = (p) view.getLayoutParams();
            if (!m.B() && !m.s()) {
                if (view.getParent() == this.f2603b) {
                    int c2 = this.f2602a.c(view);
                    if (i2 == -1) {
                        i2 = this.f2602a.a();
                    }
                    if (c2 == -1) {
                        throw new IllegalStateException("Added View has RecyclerView as parent but view is not a real child. Unfiltered index:" + this.f2603b.indexOfChild(view) + this.f2603b.n());
                    } else if (c2 != i2) {
                        this.f2603b.n.a(c2, i2);
                    }
                } else {
                    this.f2602a.a(view, i2, false);
                    pVar.f2619c = true;
                    z zVar = this.f2608g;
                    if (zVar != null && zVar.c()) {
                        this.f2608g.a(view);
                    }
                }
            } else {
                if (m.s()) {
                    m.A();
                } else {
                    m.d();
                }
                this.f2602a.a(view, i2, view.getLayoutParams(), false);
            }
            if (pVar.f2620d) {
                m.f2580a.invalidate();
                pVar.f2620d = false;
            }
        }

        public int b(v vVar, a0 a0Var) {
            RecyclerView recyclerView = this.f2603b;
            if (recyclerView == null || recyclerView.m == null || !b()) {
                return 1;
            }
            return this.f2603b.m.a();
        }

        public void a(int i2) {
            a(i2, c(i2));
        }

        public final void a(int i2, View view) {
            this.f2602a.a(i2);
        }

        public void a(View view, int i2, p pVar) {
            d0 m = RecyclerView.m(view);
            if (m.r()) {
                this.f2603b.f2557f.a(m);
            } else {
                this.f2603b.f2557f.g(m);
            }
            this.f2602a.a(view, i2, pVar, m.r());
        }

        public void a(int i2, int i3) {
            View c2 = c(i2);
            if (c2 != null) {
                a(i2);
                c(c2, i3);
                return;
            }
            throw new IllegalArgumentException("Cannot move a child from non-existing index:" + i2 + this.f2603b.toString());
        }

        public void a(View view, v vVar) {
            o(view);
            vVar.b(view);
        }

        public void a(int i2, v vVar) {
            View c2 = c(i2);
            g(i2);
            vVar.b(c2);
        }

        public void a(v vVar) {
            for (int e2 = e() - 1; e2 >= 0; e2--) {
                a(vVar, e2, c(e2));
            }
        }

        public final void a(v vVar, int i2, View view) {
            d0 m = RecyclerView.m(view);
            if (m.z()) {
                return;
            }
            if (m.p() && !m.r() && !this.f2603b.m.c()) {
                g(i2);
                vVar.d(m);
                return;
            }
            a(i2);
            vVar.c(view);
            this.f2603b.f2557f.d(m);
        }

        public boolean a(View view, int i2, int i3, p pVar) {
            return (!view.isLayoutRequested() && this.k && b(view.getWidth(), i2, ((ViewGroup.MarginLayoutParams) pVar).width) && b(view.getHeight(), i3, ((ViewGroup.MarginLayoutParams) pVar).height)) ? false : true;
        }

        public void a(View view, int i2, int i3) {
            p pVar = (p) view.getLayoutParams();
            Rect h2 = this.f2603b.h(view);
            int i4 = i2 + h2.left + h2.right;
            int i5 = i3 + h2.top + h2.bottom;
            int a2 = a(q(), r(), n() + o() + ((ViewGroup.MarginLayoutParams) pVar).leftMargin + ((ViewGroup.MarginLayoutParams) pVar).rightMargin + i4, ((ViewGroup.MarginLayoutParams) pVar).width, a());
            int a3 = a(h(), i(), p() + m() + ((ViewGroup.MarginLayoutParams) pVar).topMargin + ((ViewGroup.MarginLayoutParams) pVar).bottomMargin + i5, ((ViewGroup.MarginLayoutParams) pVar).height, b());
            if (a(view, a2, a3, pVar)) {
                view.measure(a2, a3);
            }
        }

        public static int a(int i2, int i3, int i4, int i5, boolean z) {
            int i6;
            int i7 = i2 - i4;
            int i8 = 0;
            int max = Math.max(0, i7);
            if (z) {
                if (i5 < 0) {
                    if (i5 == -1) {
                        if (i3 == Integer.MIN_VALUE || (i3 != 0 && i3 == 1073741824)) {
                            i6 = max;
                        } else {
                            i3 = 0;
                            i6 = 0;
                        }
                        i8 = i3;
                        max = i6;
                    }
                    max = 0;
                }
                max = i5;
                i8 = 1073741824;
            } else {
                if (i5 < 0) {
                    if (i5 == -1) {
                        i8 = i3;
                    } else {
                        if (i5 == -2) {
                            if (i3 == Integer.MIN_VALUE || i3 == 1073741824) {
                                i8 = Integer.MIN_VALUE;
                            }
                        }
                        max = 0;
                    }
                }
                max = i5;
                i8 = 1073741824;
            }
            return View.MeasureSpec.makeMeasureSpec(max, i8);
        }

        public void a(View view, int i2, int i3, int i4, int i5) {
            p pVar = (p) view.getLayoutParams();
            Rect rect = pVar.f2618b;
            view.layout(i2 + rect.left + ((ViewGroup.MarginLayoutParams) pVar).leftMargin, i3 + rect.top + ((ViewGroup.MarginLayoutParams) pVar).topMargin, (i4 - rect.right) - ((ViewGroup.MarginLayoutParams) pVar).rightMargin, (i5 - rect.bottom) - ((ViewGroup.MarginLayoutParams) pVar).bottomMargin);
        }

        public void a(View view, boolean z, Rect rect) {
            Matrix matrix;
            if (z) {
                Rect rect2 = ((p) view.getLayoutParams()).f2618b;
                rect.set(-rect2.left, -rect2.top, view.getWidth() + rect2.right, view.getHeight() + rect2.bottom);
            } else {
                rect.set(0, 0, view.getWidth(), view.getHeight());
            }
            if (this.f2603b != null && (matrix = view.getMatrix()) != null && !matrix.isIdentity()) {
                RectF rectF = this.f2603b.k;
                rectF.set(rect);
                matrix.mapRect(rectF);
                rect.set((int) Math.floor(rectF.left), (int) Math.floor(rectF.top), (int) Math.ceil(rectF.right), (int) Math.ceil(rectF.bottom));
            }
            rect.offset(view.getLeft(), view.getTop());
        }

        public void a(View view, Rect rect) {
            RecyclerView recyclerView = this.f2603b;
            if (recyclerView == null) {
                rect.set(0, 0, 0, 0);
            } else {
                rect.set(recyclerView.h(view));
            }
        }

        public final int[] a(RecyclerView recyclerView, View view, Rect rect, boolean z) {
            int[] iArr = new int[2];
            int n = n();
            int p = p();
            int q = q() - o();
            int h2 = h() - m();
            int left = (view.getLeft() + rect.left) - view.getScrollX();
            int top = (view.getTop() + rect.top) - view.getScrollY();
            int width = rect.width() + left;
            int height = rect.height() + top;
            int i2 = left - n;
            int min = Math.min(0, i2);
            int i3 = top - p;
            int min2 = Math.min(0, i3);
            int i4 = width - q;
            int max = Math.max(0, i4);
            int max2 = Math.max(0, height - h2);
            if (j() != 1) {
                if (min == 0) {
                    min = Math.min(i2, max);
                }
                max = min;
            } else if (max == 0) {
                max = Math.max(min, i4);
            }
            if (min2 == 0) {
                min2 = Math.min(i3, max2);
            }
            iArr[0] = max;
            iArr[1] = min2;
            return iArr;
        }

        public boolean a(RecyclerView recyclerView, View view, Rect rect, boolean z, boolean z2) {
            int[] a2 = a(recyclerView, view, rect, z);
            int i2 = a2[0];
            int i3 = a2[1];
            if ((!z2 || a(recyclerView, i2, i3)) && !(i2 == 0 && i3 == 0)) {
                if (z) {
                    recyclerView.scrollBy(i2, i3);
                } else {
                    recyclerView.j(i2, i3);
                }
                return true;
            }
            return false;
        }

        public boolean a(View view, boolean z, boolean z2) {
            boolean z3 = this.f2606e.a(view, 24579) && this.f2607f.a(view, 24579);
            return z ? z3 : !z3;
        }

        public final boolean a(RecyclerView recyclerView, int i2, int i3) {
            View focusedChild = recyclerView.getFocusedChild();
            if (focusedChild == null) {
                return false;
            }
            int n = n();
            int p = p();
            int q = q() - o();
            int h2 = h() - m();
            Rect rect = this.f2603b.f2560i;
            b(focusedChild, rect);
            return rect.left - i2 < q && rect.right - i2 > n && rect.top - i3 < h2 && rect.bottom - i3 > p;
        }

        @Deprecated
        public boolean a(RecyclerView recyclerView, View view, View view2) {
            return w() || recyclerView.x();
        }

        public boolean a(RecyclerView recyclerView, a0 a0Var, View view, View view2) {
            return a(recyclerView, view, view2);
        }

        public void a(RecyclerView recyclerView, int i2, int i3, Object obj) {
            d(recyclerView, i2, i3);
        }

        public void a(v vVar, a0 a0Var, int i2, int i3) {
            this.f2603b.c(i2, i3);
        }

        public void a(a.b.g.k.e0.c cVar) {
            RecyclerView recyclerView = this.f2603b;
            a(recyclerView.f2553b, recyclerView.i0, cVar);
        }

        public void a(v vVar, a0 a0Var, a.b.g.k.e0.c cVar) {
            if (this.f2603b.canScrollVertically(-1) || this.f2603b.canScrollHorizontally(-1)) {
                cVar.a(8192);
                cVar.e(true);
            }
            if (this.f2603b.canScrollVertically(1) || this.f2603b.canScrollHorizontally(1)) {
                cVar.a(4096);
                cVar.e(true);
            }
            cVar.a(c.a.a(b(vVar, a0Var), a(vVar, a0Var), d(vVar, a0Var), c(vVar, a0Var)));
        }

        public void a(AccessibilityEvent accessibilityEvent) {
            RecyclerView recyclerView = this.f2603b;
            a(recyclerView.f2553b, recyclerView.i0, accessibilityEvent);
        }

        public void a(v vVar, a0 a0Var, AccessibilityEvent accessibilityEvent) {
            RecyclerView recyclerView = this.f2603b;
            if (recyclerView == null || accessibilityEvent == null) {
                return;
            }
            boolean z = true;
            if (!recyclerView.canScrollVertically(1) && !this.f2603b.canScrollVertically(-1) && !this.f2603b.canScrollHorizontally(-1) && !this.f2603b.canScrollHorizontally(1)) {
                z = false;
            }
            accessibilityEvent.setScrollable(z);
            g gVar = this.f2603b.m;
            if (gVar != null) {
                accessibilityEvent.setItemCount(gVar.a());
            }
        }

        public void a(View view, a.b.g.k.e0.c cVar) {
            d0 m = RecyclerView.m(view);
            if (m == null || m.r() || this.f2602a.d(m.f2580a)) {
                return;
            }
            RecyclerView recyclerView = this.f2603b;
            a(recyclerView.f2553b, recyclerView.i0, view, cVar);
        }

        public void a(v vVar, a0 a0Var, View view, a.b.g.k.e0.c cVar) {
            cVar.b(c.b.a(b() ? l(view) : 0, 1, a() ? l(view) : 0, 1, false, false));
        }

        public int a(v vVar, a0 a0Var) {
            RecyclerView recyclerView = this.f2603b;
            if (recyclerView == null || recyclerView.m == null || !a()) {
                return 1;
            }
            return this.f2603b.m.a();
        }

        public boolean a(int i2, Bundle bundle) {
            RecyclerView recyclerView = this.f2603b;
            return a(recyclerView.f2553b, recyclerView.i0, i2, bundle);
        }

        /* JADX WARN: Removed duplicated region for block: B:26:0x0070 A[ADDED_TO_REGION] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public boolean a(android.support.v7.widget.RecyclerView.v r2, android.support.v7.widget.RecyclerView.a0 r3, int r4, android.os.Bundle r5) {
            /*
                r1 = this;
                android.support.v7.widget.RecyclerView r2 = r1.f2603b
                r3 = 0
                if (r2 != 0) goto L6
                return r3
            L6:
                r5 = 4096(0x1000, float:5.74E-42)
                r0 = 1
                if (r4 == r5) goto L42
                r5 = 8192(0x2000, float:1.148E-41)
                if (r4 == r5) goto L12
                r2 = 0
            L10:
                r4 = 0
                goto L6e
            L12:
                r4 = -1
                boolean r2 = r2.canScrollVertically(r4)
                if (r2 == 0) goto L29
                int r2 = r1.h()
                int r5 = r1.p()
                int r2 = r2 - r5
                int r5 = r1.m()
                int r2 = r2 - r5
                int r2 = -r2
                goto L2a
            L29:
                r2 = 0
            L2a:
                android.support.v7.widget.RecyclerView r5 = r1.f2603b
                boolean r4 = r5.canScrollHorizontally(r4)
                if (r4 == 0) goto L10
                int r4 = r1.q()
                int r5 = r1.n()
                int r4 = r4 - r5
                int r5 = r1.o()
                int r4 = r4 - r5
                int r4 = -r4
                goto L6e
            L42:
                boolean r2 = r2.canScrollVertically(r0)
                if (r2 == 0) goto L57
                int r2 = r1.h()
                int r4 = r1.p()
                int r2 = r2 - r4
                int r4 = r1.m()
                int r2 = r2 - r4
                goto L58
            L57:
                r2 = 0
            L58:
                android.support.v7.widget.RecyclerView r4 = r1.f2603b
                boolean r4 = r4.canScrollHorizontally(r0)
                if (r4 == 0) goto L10
                int r4 = r1.q()
                int r5 = r1.n()
                int r4 = r4 - r5
                int r5 = r1.o()
                int r4 = r4 - r5
            L6e:
                if (r2 != 0) goto L73
                if (r4 != 0) goto L73
                return r3
            L73:
                android.support.v7.widget.RecyclerView r3 = r1.f2603b
                r3.j(r4, r2)
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: android.support.v7.widget.RecyclerView.o.a(android.support.v7.widget.RecyclerView$v, android.support.v7.widget.RecyclerView$a0, int, android.os.Bundle):boolean");
        }

        public boolean a(View view, int i2, Bundle bundle) {
            RecyclerView recyclerView = this.f2603b;
            return a(recyclerView.f2553b, recyclerView.i0, view, i2, bundle);
        }

        public static d a(Context context, AttributeSet attributeSet, int i2, int i3) {
            d dVar = new d();
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, a.b.h.g.b.RecyclerView, i2, i3);
            dVar.f2613a = obtainStyledAttributes.getInt(a.b.h.g.b.RecyclerView_android_orientation, 1);
            dVar.f2614b = obtainStyledAttributes.getInt(a.b.h.g.b.RecyclerView_spanCount, 1);
            dVar.f2615c = obtainStyledAttributes.getBoolean(a.b.h.g.b.RecyclerView_reverseLayout, false);
            dVar.f2616d = obtainStyledAttributes.getBoolean(a.b.h.g.b.RecyclerView_stackFromEnd, false);
            obtainStyledAttributes.recycle();
            return dVar;
        }
    }

    /* loaded from: classes.dex */
    public interface q {
        void a(View view);

        void b(View view);
    }

    /* loaded from: classes.dex */
    public static abstract class r {
        public abstract boolean a(int i2, int i3);
    }

    /* loaded from: classes.dex */
    public interface s {
        void a(RecyclerView recyclerView, MotionEvent motionEvent);

        void a(boolean z);

        boolean b(RecyclerView recyclerView, MotionEvent motionEvent);
    }

    /* loaded from: classes.dex */
    public static abstract class t {
        public void a(RecyclerView recyclerView, int i2) {
        }

        public void a(RecyclerView recyclerView, int i2, int i3) {
        }
    }

    /* loaded from: classes.dex */
    public final class v {

        /* renamed from: a  reason: collision with root package name */
        public final ArrayList<d0> f2627a = new ArrayList<>();

        /* renamed from: b  reason: collision with root package name */
        public ArrayList<d0> f2628b = null;

        /* renamed from: c  reason: collision with root package name */
        public final ArrayList<d0> f2629c = new ArrayList<>();

        /* renamed from: d  reason: collision with root package name */
        public final List<d0> f2630d = Collections.unmodifiableList(this.f2627a);

        /* renamed from: e  reason: collision with root package name */
        public int f2631e = 2;

        /* renamed from: f  reason: collision with root package name */
        public int f2632f = 2;

        /* renamed from: g  reason: collision with root package name */
        public u f2633g;

        /* renamed from: h  reason: collision with root package name */
        public b0 f2634h;

        public v() {
        }

        public void a() {
            this.f2627a.clear();
            i();
        }

        public View b(int i2, boolean z) {
            return a(i2, z, Long.MAX_VALUE).f2580a;
        }

        public final void c(d0 d0Var) {
            View view = d0Var.f2580a;
            if (view instanceof ViewGroup) {
                a((ViewGroup) view, false);
            }
        }

        public View d(int i2) {
            return b(i2, false);
        }

        public void e(int i2) {
            a(this.f2629c.get(i2), true);
            this.f2629c.remove(i2);
        }

        public void f(int i2) {
            this.f2631e = i2;
            j();
        }

        public void g() {
            int size = this.f2629c.size();
            for (int i2 = 0; i2 < size; i2++) {
                p pVar = (p) this.f2629c.get(i2).f2580a.getLayoutParams();
                if (pVar != null) {
                    pVar.f2619c = true;
                }
            }
        }

        public void h() {
            int size = this.f2629c.size();
            for (int i2 = 0; i2 < size; i2++) {
                d0 d0Var = this.f2629c.get(i2);
                if (d0Var != null) {
                    d0Var.a(6);
                    d0Var.a((Object) null);
                }
            }
            g gVar = RecyclerView.this.m;
            if (gVar == null || !gVar.c()) {
                i();
            }
        }

        public void i() {
            for (int size = this.f2629c.size() - 1; size >= 0; size--) {
                e(size);
            }
            this.f2629c.clear();
            if (RecyclerView.F0) {
                RecyclerView.this.h0.a();
            }
        }

        public void j() {
            o oVar = RecyclerView.this.n;
            this.f2632f = this.f2631e + (oVar != null ? oVar.m : 0);
            for (int size = this.f2629c.size() - 1; size >= 0 && this.f2629c.size() > this.f2632f; size--) {
                e(size);
            }
        }

        public void b(View view) {
            d0 m = RecyclerView.m(view);
            if (m.t()) {
                RecyclerView.this.removeDetachedView(view, false);
            }
            if (m.s()) {
                m.A();
            } else if (m.B()) {
                m.d();
            }
            d(m);
        }

        public void d(d0 d0Var) {
            boolean z;
            if (!d0Var.s() && d0Var.f2580a.getParent() == null) {
                if (!d0Var.t()) {
                    if (!d0Var.z()) {
                        boolean g2 = d0Var.g();
                        g gVar = RecyclerView.this.m;
                        if ((gVar != null && g2 && gVar.a((g) d0Var)) || d0Var.q()) {
                            if (this.f2632f <= 0 || d0Var.b(526)) {
                                z = false;
                            } else {
                                int size = this.f2629c.size();
                                if (size >= this.f2632f && size > 0) {
                                    e(0);
                                    size--;
                                }
                                if (RecyclerView.F0 && size > 0 && !RecyclerView.this.h0.a(d0Var.f2582c)) {
                                    int i2 = size - 1;
                                    while (i2 >= 0) {
                                        if (!RecyclerView.this.h0.a(this.f2629c.get(i2).f2582c)) {
                                            break;
                                        }
                                        i2--;
                                    }
                                    size = i2 + 1;
                                }
                                this.f2629c.add(size, d0Var);
                                z = true;
                            }
                            if (!z) {
                                a(d0Var, true);
                                r1 = true;
                            }
                        } else {
                            z = false;
                        }
                        RecyclerView.this.f2557f.h(d0Var);
                        if (z || r1 || !g2) {
                            return;
                        }
                        d0Var.s = null;
                        return;
                    }
                    throw new IllegalArgumentException("Trying to recycle an ignored view holder. You should first call stopIgnoringView(view) before calling recycle." + RecyclerView.this.n());
                }
                throw new IllegalArgumentException("Tmp detached view should be removed from RecyclerView before it can be recycled: " + d0Var + RecyclerView.this.n());
            }
            StringBuilder sb = new StringBuilder();
            sb.append("Scrapped or attached views may not be recycled. isScrap:");
            sb.append(d0Var.s());
            sb.append(" isAttached:");
            sb.append(d0Var.f2580a.getParent() != null);
            sb.append(RecyclerView.this.n());
            throw new IllegalArgumentException(sb.toString());
        }

        public final boolean a(d0 d0Var, int i2, int i3, long j) {
            d0Var.s = RecyclerView.this;
            int j2 = d0Var.j();
            long nanoTime = RecyclerView.this.getNanoTime();
            if (j == Long.MAX_VALUE || this.f2633g.a(j2, nanoTime, j)) {
                RecyclerView.this.m.a((g) d0Var, i2);
                this.f2633g.a(d0Var.j(), RecyclerView.this.getNanoTime() - nanoTime);
                a(d0Var);
                if (RecyclerView.this.i0.d()) {
                    d0Var.f2586g = i3;
                    return true;
                }
                return true;
            }
            return false;
        }

        public void c(View view) {
            d0 m = RecyclerView.m(view);
            if (!m.b(12) && m.u() && !RecyclerView.this.b(m)) {
                if (this.f2628b == null) {
                    this.f2628b = new ArrayList<>();
                }
                m.a(this, true);
                this.f2628b.add(m);
            } else if (m.p() && !m.r() && !RecyclerView.this.m.c()) {
                throw new IllegalArgumentException("Called scrap view with an invalid view. Invalid views cannot be reused from scrap, they should rebound from recycler pool." + RecyclerView.this.n());
            } else {
                m.a(this, false);
                this.f2627a.add(m);
            }
        }

        public List<d0> f() {
            return this.f2630d;
        }

        public void e(d0 d0Var) {
            if (d0Var.p) {
                this.f2628b.remove(d0Var);
            } else {
                this.f2627a.remove(d0Var);
            }
            d0Var.o = null;
            d0Var.p = false;
            d0Var.d();
        }

        public boolean f(d0 d0Var) {
            if (d0Var.r()) {
                return RecyclerView.this.i0.d();
            }
            int i2 = d0Var.f2582c;
            if (i2 >= 0 && i2 < RecyclerView.this.m.a()) {
                if (RecyclerView.this.i0.d() || RecyclerView.this.m.c(d0Var.f2582c) == d0Var.j()) {
                    return !RecyclerView.this.m.c() || d0Var.i() == RecyclerView.this.m.b(d0Var.f2582c);
                }
                return false;
            }
            throw new IndexOutOfBoundsException("Inconsistency detected. Invalid view holder adapter position" + d0Var + RecyclerView.this.n());
        }

        public d0 b(int i2) {
            int size;
            int c2;
            ArrayList<d0> arrayList = this.f2628b;
            if (arrayList != null && (size = arrayList.size()) != 0) {
                for (int i3 = 0; i3 < size; i3++) {
                    d0 d0Var = this.f2628b.get(i3);
                    if (!d0Var.B() && d0Var.k() == i2) {
                        d0Var.a(32);
                        return d0Var;
                    }
                }
                if (RecyclerView.this.m.c() && (c2 = RecyclerView.this.f2555d.c(i2)) > 0 && c2 < RecyclerView.this.m.a()) {
                    long b2 = RecyclerView.this.m.b(c2);
                    for (int i4 = 0; i4 < size; i4++) {
                        d0 d0Var2 = this.f2628b.get(i4);
                        if (!d0Var2.B() && d0Var2.i() == b2) {
                            d0Var2.a(32);
                            return d0Var2;
                        }
                    }
                }
            }
            return null;
        }

        public int e() {
            return this.f2627a.size();
        }

        public int a(int i2) {
            if (i2 >= 0 && i2 < RecyclerView.this.i0.a()) {
                return !RecyclerView.this.i0.d() ? i2 : RecyclerView.this.f2555d.c(i2);
            }
            throw new IndexOutOfBoundsException("invalid position " + i2 + ". State item count is " + RecyclerView.this.i0.a() + RecyclerView.this.n());
        }

        public View c(int i2) {
            return this.f2627a.get(i2).f2580a;
        }

        public void c() {
            this.f2627a.clear();
            ArrayList<d0> arrayList = this.f2628b;
            if (arrayList != null) {
                arrayList.clear();
            }
        }

        /* JADX WARN: Removed duplicated region for block: B:105:0x022c A[ADDED_TO_REGION] */
        /* JADX WARN: Removed duplicated region for block: B:18:0x0037  */
        /* JADX WARN: Removed duplicated region for block: B:27:0x005c  */
        /* JADX WARN: Removed duplicated region for block: B:29:0x005f  */
        /* JADX WARN: Removed duplicated region for block: B:75:0x0189  */
        /* JADX WARN: Removed duplicated region for block: B:81:0x01a6  */
        /* JADX WARN: Removed duplicated region for block: B:84:0x01c9  */
        /* JADX WARN: Removed duplicated region for block: B:89:0x01d8  */
        /* JADX WARN: Removed duplicated region for block: B:98:0x0202  */
        /* JADX WARN: Removed duplicated region for block: B:99:0x0210  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public android.support.v7.widget.RecyclerView.d0 a(int r17, boolean r18, long r19) {
            /*
                Method dump skipped, instructions count: 619
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: android.support.v7.widget.RecyclerView.v.a(int, boolean, long):android.support.v7.widget.RecyclerView$d0");
        }

        public void c(int i2, int i3) {
            int i4;
            int i5 = i3 + i2;
            for (int size = this.f2629c.size() - 1; size >= 0; size--) {
                d0 d0Var = this.f2629c.get(size);
                if (d0Var != null && (i4 = d0Var.f2582c) >= i2 && i4 < i5) {
                    d0Var.a(2);
                    e(size);
                }
            }
        }

        public void b(d0 d0Var) {
            w wVar = RecyclerView.this.o;
            if (wVar != null) {
                wVar.a(d0Var);
            }
            g gVar = RecyclerView.this.m;
            if (gVar != null) {
                gVar.d((g) d0Var);
            }
            RecyclerView recyclerView = RecyclerView.this;
            if (recyclerView.i0 != null) {
                recyclerView.f2557f.h(d0Var);
            }
        }

        public void b(int i2, int i3) {
            int i4;
            int i5;
            int i6;
            int i7;
            if (i2 < i3) {
                i5 = i2;
                i4 = i3;
                i6 = -1;
            } else {
                i4 = i2;
                i5 = i3;
                i6 = 1;
            }
            int size = this.f2629c.size();
            for (int i8 = 0; i8 < size; i8++) {
                d0 d0Var = this.f2629c.get(i8);
                if (d0Var != null && (i7 = d0Var.f2582c) >= i5 && i7 <= i4) {
                    if (i7 == i2) {
                        d0Var.a(i3 - i2, false);
                    } else {
                        d0Var.a(i6, false);
                    }
                }
            }
        }

        public u d() {
            if (this.f2633g == null) {
                this.f2633g = new u();
            }
            return this.f2633g;
        }

        public void b() {
            int size = this.f2629c.size();
            for (int i2 = 0; i2 < size; i2++) {
                this.f2629c.get(i2).b();
            }
            int size2 = this.f2627a.size();
            for (int i3 = 0; i3 < size2; i3++) {
                this.f2627a.get(i3).b();
            }
            ArrayList<d0> arrayList = this.f2628b;
            if (arrayList != null) {
                int size3 = arrayList.size();
                for (int i4 = 0; i4 < size3; i4++) {
                    this.f2628b.get(i4).b();
                }
            }
        }

        public final void a(d0 d0Var) {
            if (RecyclerView.this.w()) {
                View view = d0Var.f2580a;
                if (a.b.g.k.u.i(view) == 0) {
                    a.b.g.k.u.f(view, 1);
                }
                if (a.b.g.k.u.s(view)) {
                    return;
                }
                d0Var.a(16384);
                a.b.g.k.u.a(view, RecyclerView.this.p0.b());
            }
        }

        public final void a(ViewGroup viewGroup, boolean z) {
            for (int childCount = viewGroup.getChildCount() - 1; childCount >= 0; childCount--) {
                View childAt = viewGroup.getChildAt(childCount);
                if (childAt instanceof ViewGroup) {
                    a((ViewGroup) childAt, true);
                }
            }
            if (z) {
                if (viewGroup.getVisibility() == 4) {
                    viewGroup.setVisibility(0);
                    viewGroup.setVisibility(4);
                    return;
                }
                int visibility = viewGroup.getVisibility();
                viewGroup.setVisibility(4);
                viewGroup.setVisibility(visibility);
            }
        }

        public void a(d0 d0Var, boolean z) {
            RecyclerView.e(d0Var);
            if (d0Var.b(16384)) {
                d0Var.a(0, 16384);
                a.b.g.k.u.a(d0Var.f2580a, (a.b.g.k.b) null);
            }
            if (z) {
                b(d0Var);
            }
            d0Var.s = null;
            d().a(d0Var);
        }

        public void a(View view) {
            d0 m = RecyclerView.m(view);
            m.o = null;
            m.p = false;
            m.d();
            d(m);
        }

        public d0 a(int i2, boolean z) {
            View b2;
            int size = this.f2627a.size();
            for (int i3 = 0; i3 < size; i3++) {
                d0 d0Var = this.f2627a.get(i3);
                if (!d0Var.B() && d0Var.k() == i2 && !d0Var.p() && (RecyclerView.this.i0.f2569h || !d0Var.r())) {
                    d0Var.a(32);
                    return d0Var;
                }
            }
            if (!z && (b2 = RecyclerView.this.f2556e.b(i2)) != null) {
                d0 m = RecyclerView.m(b2);
                RecyclerView.this.f2556e.g(b2);
                int c2 = RecyclerView.this.f2556e.c(b2);
                if (c2 != -1) {
                    RecyclerView.this.f2556e.a(c2);
                    c(b2);
                    m.a(8224);
                    return m;
                }
                throw new IllegalStateException("layout index should not be -1 after unhiding a view:" + m + RecyclerView.this.n());
            }
            int size2 = this.f2629c.size();
            for (int i4 = 0; i4 < size2; i4++) {
                d0 d0Var2 = this.f2629c.get(i4);
                if (!d0Var2.p() && d0Var2.k() == i2) {
                    if (!z) {
                        this.f2629c.remove(i4);
                    }
                    return d0Var2;
                }
            }
            return null;
        }

        public d0 a(long j, int i2, boolean z) {
            for (int size = this.f2627a.size() - 1; size >= 0; size--) {
                d0 d0Var = this.f2627a.get(size);
                if (d0Var.i() == j && !d0Var.B()) {
                    if (i2 == d0Var.j()) {
                        d0Var.a(32);
                        if (d0Var.r() && !RecyclerView.this.i0.d()) {
                            d0Var.a(2, 14);
                        }
                        return d0Var;
                    } else if (!z) {
                        this.f2627a.remove(size);
                        RecyclerView.this.removeDetachedView(d0Var.f2580a, false);
                        a(d0Var.f2580a);
                    }
                }
            }
            int size2 = this.f2629c.size();
            while (true) {
                size2--;
                if (size2 < 0) {
                    return null;
                }
                d0 d0Var2 = this.f2629c.get(size2);
                if (d0Var2.i() == j) {
                    if (i2 == d0Var2.j()) {
                        if (!z) {
                            this.f2629c.remove(size2);
                        }
                        return d0Var2;
                    } else if (!z) {
                        e(size2);
                        return null;
                    }
                }
            }
        }

        public void a(g gVar, g gVar2, boolean z) {
            a();
            d().a(gVar, gVar2, z);
        }

        public void a(int i2, int i3) {
            int size = this.f2629c.size();
            for (int i4 = 0; i4 < size; i4++) {
                d0 d0Var = this.f2629c.get(i4);
                if (d0Var != null && d0Var.f2582c >= i2) {
                    d0Var.a(i3, true);
                }
            }
        }

        public void a(int i2, int i3, boolean z) {
            int i4 = i2 + i3;
            for (int size = this.f2629c.size() - 1; size >= 0; size--) {
                d0 d0Var = this.f2629c.get(size);
                if (d0Var != null) {
                    int i5 = d0Var.f2582c;
                    if (i5 >= i4) {
                        d0Var.a(-i3, z);
                    } else if (i5 >= i2) {
                        d0Var.a(8);
                        e(size);
                    }
                }
            }
        }

        public void a(b0 b0Var) {
            this.f2634h = b0Var;
        }

        public void a(u uVar) {
            u uVar2 = this.f2633g;
            if (uVar2 != null) {
                uVar2.c();
            }
            this.f2633g = uVar;
            if (this.f2633g == null || RecyclerView.this.getAdapter() == null) {
                return;
            }
            this.f2633g.a();
        }
    }

    /* loaded from: classes.dex */
    public interface w {
        void a(d0 d0Var);
    }

    /* loaded from: classes.dex */
    public static abstract class z {

        /* loaded from: classes.dex */
        public interface a {
        }

        public abstract int a();

        public abstract void a(int i2);

        public abstract void a(int i2, int i3);

        public abstract void a(View view);

        public abstract boolean b();

        public abstract boolean c();

        public final void d() {
            throw null;
        }
    }

    static {
        int i2 = Build.VERSION.SDK_INT;
        C0 = i2 == 18 || i2 == 19 || i2 == 20;
        D0 = Build.VERSION.SDK_INT >= 23;
        E0 = Build.VERSION.SDK_INT >= 16;
        F0 = Build.VERSION.SDK_INT >= 21;
        G0 = Build.VERSION.SDK_INT <= 15;
        H0 = Build.VERSION.SDK_INT <= 15;
        Class<?> cls = Integer.TYPE;
        I0 = new Class[]{Context.class, AttributeSet.class, cls, cls};
        J0 = new c();
    }

    public RecyclerView(Context context) {
        this(context, null);
    }

    private a.b.g.k.l getScrollingChildHelper() {
        if (this.s0 == null) {
            this.s0 = new a.b.g.k.l(this);
        }
        return this.s0;
    }

    public void A() {
        this.G++;
    }

    public void B() {
        a(true);
    }

    public void C() {
        if (this.o0 || !this.s) {
            return;
        }
        a.b.g.k.u.a(this, this.y0);
        this.o0 = true;
    }

    public final boolean D() {
        return this.N != null && this.n.C();
    }

    public final void E() {
        if (this.E) {
            this.f2555d.f();
            if (this.F) {
                this.n.d(this);
            }
        }
        if (D()) {
            this.f2555d.e();
        } else {
            this.f2555d.b();
        }
        boolean z2 = false;
        boolean z3 = this.l0 || this.m0;
        this.i0.k = this.v && this.N != null && (this.E || z3 || this.n.f2609h) && (!this.E || this.m.c());
        a0 a0Var = this.i0;
        if (a0Var.k && z3 && !this.E && D()) {
            z2 = true;
        }
        a0Var.l = z2;
    }

    public final void F() {
        View view;
        if (!this.e0 || this.m == null || !hasFocus() || getDescendantFocusability() == 393216) {
            return;
        }
        if (getDescendantFocusability() == 131072 && isFocused()) {
            return;
        }
        if (!isFocused()) {
            View focusedChild = getFocusedChild();
            if (H0 && (focusedChild.getParent() == null || !focusedChild.hasFocus())) {
                if (this.f2556e.a() == 0) {
                    requestFocus();
                    return;
                }
            } else if (!this.f2556e.d(focusedChild)) {
                return;
            }
        }
        View view2 = null;
        d0 a2 = (this.i0.n == -1 || !this.m.c()) ? null : a(this.i0.n);
        if (a2 != null && !this.f2556e.d(a2.f2580a) && a2.f2580a.hasFocusable()) {
            view2 = a2.f2580a;
        } else if (this.f2556e.a() > 0) {
            view2 = o();
        }
        if (view2 != null) {
            int i2 = this.i0.o;
            if (i2 == -1 || (view = view2.findViewById(i2)) == null || !view.isFocusable()) {
                view = view2;
            }
            view.requestFocus();
        }
    }

    public final void G() {
        boolean z2;
        EdgeEffect edgeEffect = this.J;
        if (edgeEffect != null) {
            edgeEffect.onRelease();
            z2 = this.J.isFinished();
        } else {
            z2 = false;
        }
        EdgeEffect edgeEffect2 = this.K;
        if (edgeEffect2 != null) {
            edgeEffect2.onRelease();
            z2 |= this.K.isFinished();
        }
        EdgeEffect edgeEffect3 = this.L;
        if (edgeEffect3 != null) {
            edgeEffect3.onRelease();
            z2 |= this.L.isFinished();
        }
        EdgeEffect edgeEffect4 = this.M;
        if (edgeEffect4 != null) {
            edgeEffect4.onRelease();
            z2 |= this.M.isFinished();
        }
        if (z2) {
            a.b.g.k.u.A(this);
        }
    }

    public void H() {
        l lVar = this.N;
        if (lVar != null) {
            lVar.b();
        }
        o oVar = this.n;
        if (oVar != null) {
            oVar.b(this.f2553b);
            this.n.c(this.f2553b);
        }
        this.f2553b.a();
    }

    public void I() {
        d0 d0Var;
        int a2 = this.f2556e.a();
        for (int i2 = 0; i2 < a2; i2++) {
            View c2 = this.f2556e.c(i2);
            d0 f2 = f(c2);
            if (f2 != null && (d0Var = f2.f2588i) != null) {
                View view = d0Var.f2580a;
                int left = c2.getLeft();
                int top = c2.getTop();
                if (left != view.getLeft() || top != view.getTop()) {
                    view.layout(left, top, view.getWidth() + left, view.getHeight() + top);
                }
            }
        }
    }

    public final void J() {
        a0 a0Var = this.i0;
        a0Var.n = -1L;
        a0Var.m = -1;
        a0Var.o = -1;
    }

    public final void K() {
        VelocityTracker velocityTracker = this.Q;
        if (velocityTracker != null) {
            velocityTracker.clear();
        }
        a(0);
        G();
    }

    public final void L() {
        int h2;
        View focusedChild = (this.e0 && hasFocus() && this.m != null) ? getFocusedChild() : null;
        d0 d2 = focusedChild != null ? d(focusedChild) : null;
        if (d2 == null) {
            J();
            return;
        }
        this.i0.n = this.m.c() ? d2.i() : -1L;
        a0 a0Var = this.i0;
        if (this.E) {
            h2 = -1;
        } else {
            h2 = d2.r() ? d2.f2583d : d2.h();
        }
        a0Var.m = h2;
        this.i0.o = g(d2.f2580a);
    }

    public void M() {
        int b2 = this.f2556e.b();
        for (int i2 = 0; i2 < b2; i2++) {
            d0 m2 = m(this.f2556e.e(i2));
            if (!m2.z()) {
                m2.x();
            }
        }
    }

    public void N() {
        this.w++;
        if (this.w != 1 || this.y) {
            return;
        }
        this.x = false;
    }

    public void O() {
        setScrollState(0);
        P();
    }

    public final void P() {
        this.f0.d();
        o oVar = this.n;
        if (oVar != null) {
            oVar.B();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void addFocusables(ArrayList<View> arrayList, int i2, int i3) {
        o oVar = this.n;
        if (oVar == null || !oVar.a(this, arrayList, i2, i3)) {
            super.addFocusables(arrayList, i2, i3);
        }
    }

    public void b(n nVar) {
        o oVar = this.n;
        if (oVar != null) {
            oVar.a("Cannot remove item decoration during a scroll  or layout");
        }
        this.p.remove(nVar);
        if (this.p.isEmpty()) {
            setWillNotDraw(getOverScrollMode() == 2);
        }
        y();
        requestLayout();
    }

    public void c() {
        if (this.v && !this.E) {
            if (this.f2555d.c()) {
                if (this.f2555d.d(4) && !this.f2555d.d(11)) {
                    a.b.g.g.h.a("RV PartialInvalidate");
                    N();
                    A();
                    this.f2555d.e();
                    if (!this.x) {
                        if (q()) {
                            e();
                        } else {
                            this.f2555d.a();
                        }
                    }
                    c(true);
                    B();
                    a.b.g.g.h.a();
                    return;
                } else if (this.f2555d.c()) {
                    a.b.g.g.h.a("RV FullInvalidate");
                    e();
                    a.b.g.g.h.a();
                    return;
                } else {
                    return;
                }
            }
            return;
        }
        a.b.g.g.h.a("RV FullInvalidate");
        e();
        a.b.g.g.h.a();
    }

    @Override // android.view.ViewGroup
    public boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return (layoutParams instanceof p) && this.n.a((p) layoutParams);
    }

    @Override // android.view.View
    public int computeHorizontalScrollExtent() {
        o oVar = this.n;
        if (oVar != null && oVar.a()) {
            return this.n.a(this.i0);
        }
        return 0;
    }

    @Override // android.view.View
    public int computeHorizontalScrollOffset() {
        o oVar = this.n;
        if (oVar != null && oVar.a()) {
            return this.n.b(this.i0);
        }
        return 0;
    }

    @Override // android.view.View
    public int computeHorizontalScrollRange() {
        o oVar = this.n;
        if (oVar != null && oVar.a()) {
            return this.n.c(this.i0);
        }
        return 0;
    }

    @Override // android.view.View
    public int computeVerticalScrollExtent() {
        o oVar = this.n;
        if (oVar != null && oVar.b()) {
            return this.n.d(this.i0);
        }
        return 0;
    }

    @Override // android.view.View
    public int computeVerticalScrollOffset() {
        o oVar = this.n;
        if (oVar != null && oVar.b()) {
            return this.n.e(this.i0);
        }
        return 0;
    }

    @Override // android.view.View
    public int computeVerticalScrollRange() {
        o oVar = this.n;
        if (oVar != null && oVar.b()) {
            return this.n.f(this.i0);
        }
        return 0;
    }

    public final void d() {
        int i2 = this.A;
        this.A = 0;
        if (i2 == 0 || !w()) {
            return;
        }
        AccessibilityEvent obtain = AccessibilityEvent.obtain();
        obtain.setEventType(2048);
        a.b.g.k.e0.a.a(obtain, i2);
        sendAccessibilityEventUnchecked(obtain);
    }

    @Override // android.view.View
    public boolean dispatchNestedFling(float f2, float f3, boolean z2) {
        return getScrollingChildHelper().a(f2, f3, z2);
    }

    @Override // android.view.View
    public boolean dispatchNestedPreFling(float f2, float f3) {
        return getScrollingChildHelper().a(f2, f3);
    }

    @Override // android.view.View
    public boolean dispatchNestedPreScroll(int i2, int i3, int[] iArr, int[] iArr2) {
        return getScrollingChildHelper().a(i2, i3, iArr, iArr2);
    }

    @Override // android.view.View
    public boolean dispatchNestedScroll(int i2, int i3, int i4, int i5, int[] iArr) {
        return getScrollingChildHelper().a(i2, i3, i4, i5, iArr);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void dispatchRestoreInstanceState(SparseArray<Parcelable> sparseArray) {
        dispatchThawSelfOnly(sparseArray);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void dispatchSaveInstanceState(SparseArray<Parcelable> sparseArray) {
        dispatchFreezeSelfOnly(sparseArray);
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        boolean z2;
        boolean z3;
        super.draw(canvas);
        int size = this.p.size();
        boolean z4 = false;
        for (int i2 = 0; i2 < size; i2++) {
            this.p.get(i2).b(canvas, this, this.i0);
        }
        EdgeEffect edgeEffect = this.J;
        if (edgeEffect == null || edgeEffect.isFinished()) {
            z2 = false;
        } else {
            int save = canvas.save();
            int paddingBottom = this.f2558g ? getPaddingBottom() : 0;
            canvas.rotate(270.0f);
            canvas.translate((-getHeight()) + paddingBottom, 0.0f);
            EdgeEffect edgeEffect2 = this.J;
            z2 = edgeEffect2 != null && edgeEffect2.draw(canvas);
            canvas.restoreToCount(save);
        }
        EdgeEffect edgeEffect3 = this.K;
        if (edgeEffect3 != null && !edgeEffect3.isFinished()) {
            int save2 = canvas.save();
            if (this.f2558g) {
                canvas.translate(getPaddingLeft(), getPaddingTop());
            }
            EdgeEffect edgeEffect4 = this.K;
            z2 |= edgeEffect4 != null && edgeEffect4.draw(canvas);
            canvas.restoreToCount(save2);
        }
        EdgeEffect edgeEffect5 = this.L;
        if (edgeEffect5 != null && !edgeEffect5.isFinished()) {
            int save3 = canvas.save();
            int width = getWidth();
            int paddingTop = this.f2558g ? getPaddingTop() : 0;
            canvas.rotate(90.0f);
            canvas.translate(-paddingTop, -width);
            EdgeEffect edgeEffect6 = this.L;
            z2 |= edgeEffect6 != null && edgeEffect6.draw(canvas);
            canvas.restoreToCount(save3);
        }
        EdgeEffect edgeEffect7 = this.M;
        if (edgeEffect7 == null || edgeEffect7.isFinished()) {
            z3 = z2;
        } else {
            int save4 = canvas.save();
            canvas.rotate(180.0f);
            if (this.f2558g) {
                canvas.translate((-getWidth()) + getPaddingRight(), (-getHeight()) + getPaddingBottom());
            } else {
                canvas.translate(-getWidth(), -getHeight());
            }
            EdgeEffect edgeEffect8 = this.M;
            if (edgeEffect8 != null && edgeEffect8.draw(canvas)) {
                z4 = true;
            }
            z3 = z4 | z2;
            canvas.restoreToCount(save4);
        }
        if (!z3 && this.N != null && this.p.size() > 0 && this.N.g()) {
            z3 = true;
        }
        if (z3) {
            a.b.g.k.u.A(this);
        }
    }

    @Override // android.view.ViewGroup
    public boolean drawChild(Canvas canvas, View view, long j2) {
        return super.drawChild(canvas, view, j2);
    }

    public void e() {
        if (this.m == null) {
            Log.e("RecyclerView", "No adapter attached; skipping layout");
        } else if (this.n == null) {
            Log.e("RecyclerView", "No layout manager attached; skipping layout");
        } else {
            a0 a0Var = this.i0;
            a0Var.j = false;
            if (a0Var.f2566e == 1) {
                f();
                this.n.e(this);
                g();
            } else if (!this.f2555d.d() && this.n.q() == getWidth() && this.n.h() == getHeight()) {
                this.n.e(this);
            } else {
                this.n.e(this);
                g();
            }
            h();
        }
    }

    public boolean f(int i2, int i3) {
        o oVar = this.n;
        if (oVar == null) {
            Log.e("RecyclerView", "Cannot fling without a LayoutManager set. Call setLayoutManager with a non-null argument.");
            return false;
        } else if (this.y) {
            return false;
        } else {
            boolean a2 = oVar.a();
            boolean b2 = this.n.b();
            i2 = (!a2 || Math.abs(i2) < this.a0) ? 0 : 0;
            i3 = (!b2 || Math.abs(i3) < this.a0) ? 0 : 0;
            if (i2 == 0 && i3 == 0) {
                return false;
            }
            float f2 = i2;
            float f3 = i3;
            if (!dispatchNestedPreFling(f2, f3)) {
                boolean z2 = a2 || b2;
                dispatchNestedFling(f2, f3, z2);
                r rVar = this.W;
                if (rVar != null && rVar.a(i2, i3)) {
                    return true;
                }
                if (z2) {
                    int i4 = a2 ? 1 : 0;
                    if (b2) {
                        i4 |= 2;
                    }
                    k(i4, 1);
                    int i5 = this.b0;
                    int max = Math.max(-i5, Math.min(i2, i5));
                    int i6 = this.b0;
                    this.f0.a(max, Math.max(-i6, Math.min(i3, i6)));
                    return true;
                }
            }
            return false;
        }
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public View focusSearch(View view, int i2) {
        View view2;
        boolean z2;
        View d2 = this.n.d(view, i2);
        if (d2 != null) {
            return d2;
        }
        boolean z3 = (this.m == null || this.n == null || x() || this.y) ? false : true;
        FocusFinder focusFinder = FocusFinder.getInstance();
        if (z3 && (i2 == 2 || i2 == 1)) {
            if (this.n.b()) {
                int i3 = i2 == 2 ? 130 : 33;
                z2 = focusFinder.findNextFocus(this, view, i3) == null;
                if (G0) {
                    i2 = i3;
                }
            } else {
                z2 = false;
            }
            if (!z2 && this.n.a()) {
                int i4 = (this.n.j() == 1) ^ (i2 == 2) ? 66 : 17;
                z2 = focusFinder.findNextFocus(this, view, i4) == null;
                if (G0) {
                    i2 = i4;
                }
            }
            if (z2) {
                c();
                if (c(view) == null) {
                    return null;
                }
                N();
                this.n.a(view, i2, this.f2553b, this.i0);
                c(false);
            }
            view2 = focusFinder.findNextFocus(this, view, i2);
        } else {
            View findNextFocus = focusFinder.findNextFocus(this, view, i2);
            if (findNextFocus == null && z3) {
                c();
                if (c(view) == null) {
                    return null;
                }
                N();
                view2 = this.n.a(view, i2, this.f2553b, this.i0);
                c(false);
            } else {
                view2 = findNextFocus;
            }
        }
        if (view2 == null || view2.hasFocusable()) {
            return a(view, view2, i2) ? view2 : super.focusSearch(view, i2);
        } else if (getFocusedChild() == null) {
            return super.focusSearch(view, i2);
        } else {
            a(view2, (View) null);
            return view;
        }
    }

    public final int g(View view) {
        int id = view.getId();
        while (!view.isFocused() && (view instanceof ViewGroup) && view.hasFocus()) {
            view = ((ViewGroup) view).getFocusedChild();
            if (view.getId() != -1) {
                id = view.getId();
            }
        }
        return id;
    }

    public void g(int i2) {
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateDefaultLayoutParams() {
        o oVar = this.n;
        if (oVar != null) {
            return oVar.c();
        }
        throw new IllegalStateException("RecyclerView has no LayoutManager" + n());
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        o oVar = this.n;
        if (oVar != null) {
            return oVar.a(getContext(), attributeSet);
        }
        throw new IllegalStateException("RecyclerView has no LayoutManager" + n());
    }

    public g getAdapter() {
        return this.m;
    }

    @Override // android.view.View
    public int getBaseline() {
        o oVar = this.n;
        if (oVar != null) {
            return oVar.d();
        }
        return super.getBaseline();
    }

    @Override // android.view.ViewGroup
    public int getChildDrawingOrder(int i2, int i3) {
        j jVar = this.q0;
        if (jVar == null) {
            return super.getChildDrawingOrder(i2, i3);
        }
        return jVar.a(i2, i3);
    }

    @Override // android.view.ViewGroup
    public boolean getClipToPadding() {
        return this.f2558g;
    }

    public x0 getCompatAccessibilityDelegate() {
        return this.p0;
    }

    public k getEdgeEffectFactory() {
        return this.I;
    }

    public l getItemAnimator() {
        return this.N;
    }

    public int getItemDecorationCount() {
        return this.p.size();
    }

    public o getLayoutManager() {
        return this.n;
    }

    public int getMaxFlingVelocity() {
        return this.b0;
    }

    public int getMinFlingVelocity() {
        return this.a0;
    }

    public long getNanoTime() {
        if (F0) {
            return System.nanoTime();
        }
        return 0L;
    }

    public r getOnFlingListener() {
        return this.W;
    }

    public boolean getPreserveFocusAfterLayout() {
        return this.e0;
    }

    public u getRecycledViewPool() {
        return this.f2553b.d();
    }

    public int getScrollState() {
        return this.O;
    }

    public void h(int i2) {
        if (this.y) {
            return;
        }
        O();
        o oVar = this.n;
        if (oVar == null) {
            Log.e("RecyclerView", "Cannot scroll to position a LayoutManager set. Call setLayoutManager with a non-null argument.");
            return;
        }
        oVar.h(i2);
        awakenScrollBars();
    }

    @Override // android.view.View
    public boolean hasNestedScrollingParent() {
        return getScrollingChildHelper().a();
    }

    public void i() {
        int i2;
        for (int size = this.x0.size() - 1; size >= 0; size--) {
            d0 d0Var = this.x0.get(size);
            if (d0Var.f2580a.getParent() == this && !d0Var.z() && (i2 = d0Var.r) != -1) {
                a.b.g.k.u.f(d0Var.f2580a, i2);
                d0Var.r = -1;
            }
        }
        this.x0.clear();
    }

    public void i(int i2, int i3) {
    }

    public void i(View view) {
    }

    @Override // android.view.View
    public boolean isAttachedToWindow() {
        return this.s;
    }

    @Override // android.view.View, a.b.g.k.k
    public boolean isNestedScrollingEnabled() {
        return getScrollingChildHelper().b();
    }

    public void j(int i2, int i3) {
        a(i2, i3, (Interpolator) null);
    }

    public void j(View view) {
    }

    public boolean k(View view) {
        N();
        boolean f2 = this.f2556e.f(view);
        if (f2) {
            d0 m2 = m(view);
            this.f2553b.e(m2);
            this.f2553b.d(m2);
        }
        c(!f2);
        return f2;
    }

    public void l() {
        if (this.L != null) {
            return;
        }
        this.L = this.I.a(this, 2);
        if (this.f2558g) {
            this.L.setSize((getMeasuredHeight() - getPaddingTop()) - getPaddingBottom(), (getMeasuredWidth() - getPaddingLeft()) - getPaddingRight());
        } else {
            this.L.setSize(getMeasuredHeight(), getMeasuredWidth());
        }
    }

    public void m() {
        if (this.K != null) {
            return;
        }
        this.K = this.I.a(this, 1);
        if (this.f2558g) {
            this.K.setSize((getMeasuredWidth() - getPaddingLeft()) - getPaddingRight(), (getMeasuredHeight() - getPaddingTop()) - getPaddingBottom());
        } else {
            this.K.setSize(getMeasuredWidth(), getMeasuredHeight());
        }
    }

    public String n() {
        return " " + super.toString() + ", adapter:" + this.m + ", layout:" + this.n + ", context:" + getContext();
    }

    public final View o() {
        d0 c2;
        int i2 = this.i0.m;
        if (i2 == -1) {
            i2 = 0;
        }
        int a2 = this.i0.a();
        for (int i3 = i2; i3 < a2; i3++) {
            d0 c3 = c(i3);
            if (c3 == null) {
                break;
            } else if (c3.f2580a.hasFocusable()) {
                return c3.f2580a;
            }
        }
        int min = Math.min(a2, i2);
        while (true) {
            min--;
            if (min < 0 || (c2 = c(min)) == null) {
                return null;
            }
            if (c2.f2580a.hasFocusable()) {
                return c2.f2580a;
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:19:0x004f, code lost:
        if (r0 >= 30.0f) goto L17;
     */
    @Override // android.view.ViewGroup, android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void onAttachedToWindow() {
        /*
            r4 = this;
            super.onAttachedToWindow()
            r0 = 0
            r4.G = r0
            r1 = 1
            r4.s = r1
            boolean r2 = r4.v
            if (r2 == 0) goto L14
            boolean r2 = r4.isLayoutRequested()
            if (r2 != 0) goto L14
            goto L15
        L14:
            r1 = 0
        L15:
            r4.v = r1
            android.support.v7.widget.RecyclerView$o r1 = r4.n
            if (r1 == 0) goto L1e
            r1.a(r4)
        L1e:
            r4.o0 = r0
            boolean r0 = android.support.v7.widget.RecyclerView.F0
            if (r0 == 0) goto L67
            java.lang.ThreadLocal<a.b.h.k.p0> r0 = a.b.h.k.p0.f1882e
            java.lang.Object r0 = r0.get()
            a.b.h.k.p0 r0 = (a.b.h.k.p0) r0
            r4.g0 = r0
            a.b.h.k.p0 r0 = r4.g0
            if (r0 != 0) goto L62
            a.b.h.k.p0 r0 = new a.b.h.k.p0
            r0.<init>()
            r4.g0 = r0
            android.view.Display r0 = a.b.g.k.u.f(r4)
            r1 = 1114636288(0x42700000, float:60.0)
            boolean r2 = r4.isInEditMode()
            if (r2 != 0) goto L52
            if (r0 == 0) goto L52
            float r0 = r0.getRefreshRate()
            r2 = 1106247680(0x41f00000, float:30.0)
            int r2 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r2 < 0) goto L52
            goto L54
        L52:
            r0 = 1114636288(0x42700000, float:60.0)
        L54:
            a.b.h.k.p0 r1 = r4.g0
            r2 = 1315859240(0x4e6e6b28, float:1.0E9)
            float r2 = r2 / r0
            long r2 = (long) r2
            r1.f1886c = r2
            java.lang.ThreadLocal<a.b.h.k.p0> r0 = a.b.h.k.p0.f1882e
            r0.set(r1)
        L62:
            a.b.h.k.p0 r0 = r4.g0
            r0.a(r4)
        L67:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v7.widget.RecyclerView.onAttachedToWindow():void");
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        p0 p0Var;
        super.onDetachedFromWindow();
        l lVar = this.N;
        if (lVar != null) {
            lVar.b();
        }
        O();
        this.s = false;
        o oVar = this.n;
        if (oVar != null) {
            oVar.a(this, this.f2553b);
        }
        this.x0.clear();
        removeCallbacks(this.y0);
        this.f2557f.b();
        if (!F0 || (p0Var = this.g0) == null) {
            return;
        }
        p0Var.b(this);
        this.g0 = null;
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int size = this.p.size();
        for (int i2 = 0; i2 < size; i2++) {
            this.p.get(i2).a(canvas, this, this.i0);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:31:0x0066  */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean onGenericMotionEvent(android.view.MotionEvent r6) {
        /*
            r5 = this;
            android.support.v7.widget.RecyclerView$o r0 = r5.n
            r1 = 0
            if (r0 != 0) goto L6
            return r1
        L6:
            boolean r0 = r5.y
            if (r0 == 0) goto Lb
            return r1
        Lb:
            int r0 = r6.getAction()
            r2 = 8
            if (r0 != r2) goto L77
            int r0 = r6.getSource()
            r0 = r0 & 2
            r2 = 0
            if (r0 == 0) goto L3c
            android.support.v7.widget.RecyclerView$o r0 = r5.n
            boolean r0 = r0.b()
            if (r0 == 0) goto L2c
            r0 = 9
            float r0 = r6.getAxisValue(r0)
            float r0 = -r0
            goto L2d
        L2c:
            r0 = 0
        L2d:
            android.support.v7.widget.RecyclerView$o r3 = r5.n
            boolean r3 = r3.a()
            if (r3 == 0) goto L61
            r3 = 10
            float r3 = r6.getAxisValue(r3)
            goto L62
        L3c:
            int r0 = r6.getSource()
            r3 = 4194304(0x400000, float:5.877472E-39)
            r0 = r0 & r3
            if (r0 == 0) goto L60
            r0 = 26
            float r0 = r6.getAxisValue(r0)
            android.support.v7.widget.RecyclerView$o r3 = r5.n
            boolean r3 = r3.b()
            if (r3 == 0) goto L55
            float r0 = -r0
            goto L61
        L55:
            android.support.v7.widget.RecyclerView$o r3 = r5.n
            boolean r3 = r3.a()
            if (r3 == 0) goto L60
            r3 = r0
            r0 = 0
            goto L62
        L60:
            r0 = 0
        L61:
            r3 = 0
        L62:
            int r4 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r4 != 0) goto L6a
            int r2 = (r3 > r2 ? 1 : (r3 == r2 ? 0 : -1))
            if (r2 == 0) goto L77
        L6a:
            float r2 = r5.c0
            float r3 = r3 * r2
            int r2 = (int) r3
            float r3 = r5.d0
            float r0 = r0 * r3
            int r0 = (int) r0
            r5.a(r2, r0, r6)
        L77:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v7.widget.RecyclerView.onGenericMotionEvent(android.view.MotionEvent):boolean");
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        boolean z2;
        if (this.y) {
            return false;
        }
        if (b(motionEvent)) {
            a();
            return true;
        }
        o oVar = this.n;
        if (oVar == null) {
            return false;
        }
        boolean a2 = oVar.a();
        boolean b2 = this.n.b();
        if (this.Q == null) {
            this.Q = VelocityTracker.obtain();
        }
        this.Q.addMovement(motionEvent);
        int actionMasked = motionEvent.getActionMasked();
        int actionIndex = motionEvent.getActionIndex();
        if (actionMasked == 0) {
            if (this.z) {
                this.z = false;
            }
            this.P = motionEvent.getPointerId(0);
            int x2 = (int) (motionEvent.getX() + 0.5f);
            this.T = x2;
            this.R = x2;
            int y2 = (int) (motionEvent.getY() + 0.5f);
            this.U = y2;
            this.S = y2;
            if (this.O == 2) {
                getParent().requestDisallowInterceptTouchEvent(true);
                setScrollState(1);
            }
            int[] iArr = this.v0;
            iArr[1] = 0;
            iArr[0] = 0;
            int i2 = a2 ? 1 : 0;
            if (b2) {
                i2 |= 2;
            }
            k(i2, 0);
        } else if (actionMasked == 1) {
            this.Q.clear();
            a(0);
        } else if (actionMasked == 2) {
            int findPointerIndex = motionEvent.findPointerIndex(this.P);
            if (findPointerIndex < 0) {
                Log.e("RecyclerView", "Error processing scroll; pointer index for id " + this.P + " not found. Did any MotionEvents get skipped?");
                return false;
            }
            int x3 = (int) (motionEvent.getX(findPointerIndex) + 0.5f);
            int y3 = (int) (motionEvent.getY(findPointerIndex) + 0.5f);
            if (this.O != 1) {
                int i3 = x3 - this.R;
                int i4 = y3 - this.S;
                if (!a2 || Math.abs(i3) <= this.V) {
                    z2 = false;
                } else {
                    this.T = x3;
                    z2 = true;
                }
                if (b2 && Math.abs(i4) > this.V) {
                    this.U = y3;
                    z2 = true;
                }
                if (z2) {
                    setScrollState(1);
                }
            }
        } else if (actionMasked == 3) {
            a();
        } else if (actionMasked == 5) {
            this.P = motionEvent.getPointerId(actionIndex);
            int x4 = (int) (motionEvent.getX(actionIndex) + 0.5f);
            this.T = x4;
            this.R = x4;
            int y4 = (int) (motionEvent.getY(actionIndex) + 0.5f);
            this.U = y4;
            this.S = y4;
        } else if (actionMasked == 6) {
            c(motionEvent);
        }
        return this.O == 1;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onLayout(boolean z2, int i2, int i3, int i4, int i5) {
        a.b.g.g.h.a("RV OnLayout");
        e();
        a.b.g.g.h.a();
        this.v = true;
    }

    @Override // android.view.View
    public void onMeasure(int i2, int i3) {
        o oVar = this.n;
        if (oVar == null) {
            c(i2, i3);
            return;
        }
        boolean z2 = false;
        if (oVar.u()) {
            int mode = View.MeasureSpec.getMode(i2);
            int mode2 = View.MeasureSpec.getMode(i3);
            this.n.a(this.f2553b, this.i0, i2, i3);
            if (mode == 1073741824 && mode2 == 1073741824) {
                z2 = true;
            }
            if (z2 || this.m == null) {
                return;
            }
            if (this.i0.f2566e == 1) {
                f();
            }
            this.n.b(i2, i3);
            this.i0.j = true;
            g();
            this.n.d(i2, i3);
            if (this.n.A()) {
                this.n.b(View.MeasureSpec.makeMeasureSpec(getMeasuredWidth(), 1073741824), View.MeasureSpec.makeMeasureSpec(getMeasuredHeight(), 1073741824));
                this.i0.j = true;
                g();
                this.n.d(i2, i3);
            }
        } else if (this.t) {
            this.n.a(this.f2553b, this.i0, i2, i3);
        } else {
            if (this.B) {
                N();
                A();
                E();
                B();
                a0 a0Var = this.i0;
                if (a0Var.l) {
                    a0Var.f2569h = true;
                } else {
                    this.f2555d.b();
                    this.i0.f2569h = false;
                }
                this.B = false;
                c(false);
            } else if (this.i0.l) {
                setMeasuredDimension(getMeasuredWidth(), getMeasuredHeight());
                return;
            }
            g gVar = this.m;
            if (gVar != null) {
                this.i0.f2567f = gVar.a();
            } else {
                this.i0.f2567f = 0;
            }
            N();
            this.n.a(this.f2553b, this.i0, i2, i3);
            c(false);
            this.i0.f2569h = false;
        }
    }

    @Override // android.view.ViewGroup
    public boolean onRequestFocusInDescendants(int i2, Rect rect) {
        if (x()) {
            return false;
        }
        return super.onRequestFocusInDescendants(i2, rect);
    }

    @Override // android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        Parcelable parcelable2;
        if (!(parcelable instanceof y)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        this.f2554c = (y) parcelable;
        super.onRestoreInstanceState(this.f2554c.a());
        o oVar = this.n;
        if (oVar == null || (parcelable2 = this.f2554c.f2637c) == null) {
            return;
        }
        oVar.a(parcelable2);
    }

    @Override // android.view.View
    public Parcelable onSaveInstanceState() {
        y yVar = new y(super.onSaveInstanceState());
        y yVar2 = this.f2554c;
        if (yVar2 != null) {
            yVar.a(yVar2);
        } else {
            o oVar = this.n;
            if (oVar != null) {
                yVar.f2637c = oVar.x();
            } else {
                yVar.f2637c = null;
            }
        }
        return yVar;
    }

    @Override // android.view.View
    public void onSizeChanged(int i2, int i3, int i4, int i5) {
        super.onSizeChanged(i2, i3, i4, i5);
        if (i2 == i4 && i3 == i5) {
            return;
        }
        u();
    }

    /* JADX WARN: Removed duplicated region for block: B:53:0x010c  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x011c  */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean onTouchEvent(android.view.MotionEvent r15) {
        /*
            Method dump skipped, instructions count: 456
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v7.widget.RecyclerView.onTouchEvent(android.view.MotionEvent):boolean");
    }

    public boolean p() {
        return !this.v || this.E || this.f2555d.c();
    }

    public final boolean q() {
        int a2 = this.f2556e.a();
        for (int i2 = 0; i2 < a2; i2++) {
            d0 m2 = m(this.f2556e.c(i2));
            if (m2 != null && !m2.z() && m2.u()) {
                return true;
            }
        }
        return false;
    }

    public void r() {
        this.f2555d = new a.b.h.k.d(new f());
    }

    @Override // android.view.ViewGroup
    public void removeDetachedView(View view, boolean z2) {
        d0 m2 = m(view);
        if (m2 != null) {
            if (m2.t()) {
                m2.e();
            } else if (!m2.z()) {
                throw new IllegalArgumentException("Called removeDetachedView with a view which is not flagged as tmp detached." + m2 + n());
            }
        }
        view.clearAnimation();
        b(view);
        super.removeDetachedView(view, z2);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void requestChildFocus(View view, View view2) {
        if (!this.n.a(this, this.i0, view, view2) && view2 != null) {
            a(view, view2);
        }
        super.requestChildFocus(view, view2);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public boolean requestChildRectangleOnScreen(View view, Rect rect, boolean z2) {
        return this.n.b(this, view, rect, z2);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void requestDisallowInterceptTouchEvent(boolean z2) {
        int size = this.q.size();
        for (int i2 = 0; i2 < size; i2++) {
            this.q.get(i2).a(z2);
        }
        super.requestDisallowInterceptTouchEvent(z2);
    }

    @Override // android.view.View, android.view.ViewParent
    public void requestLayout() {
        if (this.w == 0 && !this.y) {
            super.requestLayout();
        } else {
            this.x = true;
        }
    }

    @SuppressLint({"InlinedApi"})
    public final void s() {
        if (a.b.g.k.u.j(this) == 0) {
            a.b.g.k.u.g(this, 8);
        }
    }

    @Override // android.view.View
    public void scrollBy(int i2, int i3) {
        o oVar = this.n;
        if (oVar == null) {
            Log.e("RecyclerView", "Cannot scroll without a LayoutManager set. Call setLayoutManager with a non-null argument.");
        } else if (this.y) {
        } else {
            boolean a2 = oVar.a();
            boolean b2 = this.n.b();
            if (a2 || b2) {
                if (!a2) {
                    i2 = 0;
                }
                if (!b2) {
                    i3 = 0;
                }
                a(i2, i3, (MotionEvent) null);
            }
        }
    }

    @Override // android.view.View
    public void scrollTo(int i2, int i3) {
        Log.w("RecyclerView", "RecyclerView does not support scrolling to an absolute position. Use scrollToPosition instead");
    }

    @Override // android.view.View, android.view.accessibility.AccessibilityEventSource
    public void sendAccessibilityEventUnchecked(AccessibilityEvent accessibilityEvent) {
        if (a(accessibilityEvent)) {
            return;
        }
        super.sendAccessibilityEventUnchecked(accessibilityEvent);
    }

    public void setAccessibilityDelegateCompat(x0 x0Var) {
        this.p0 = x0Var;
        a.b.g.k.u.a(this, this.p0);
    }

    public void setAdapter(g gVar) {
        setLayoutFrozen(false);
        a(gVar, false, true);
        b(false);
        requestLayout();
    }

    public void setChildDrawingOrderCallback(j jVar) {
        if (jVar == this.q0) {
            return;
        }
        this.q0 = jVar;
        setChildrenDrawingOrderEnabled(this.q0 != null);
    }

    @Override // android.view.ViewGroup
    public void setClipToPadding(boolean z2) {
        if (z2 != this.f2558g) {
            u();
        }
        this.f2558g = z2;
        super.setClipToPadding(z2);
        if (this.v) {
            requestLayout();
        }
    }

    public void setEdgeEffectFactory(k kVar) {
        a.b.g.j.m.a(kVar);
        this.I = kVar;
        u();
    }

    public void setHasFixedSize(boolean z2) {
        this.t = z2;
    }

    public void setItemAnimator(l lVar) {
        l lVar2 = this.N;
        if (lVar2 != null) {
            lVar2.b();
            this.N.a((l.b) null);
        }
        this.N = lVar;
        l lVar3 = this.N;
        if (lVar3 != null) {
            lVar3.a(this.n0);
        }
    }

    public void setItemViewCacheSize(int i2) {
        this.f2553b.f(i2);
    }

    public void setLayoutFrozen(boolean z2) {
        if (z2 != this.y) {
            a("Do not setLayoutFrozen in layout or scroll");
            if (!z2) {
                this.y = false;
                if (this.x && this.n != null && this.m != null) {
                    requestLayout();
                }
                this.x = false;
                return;
            }
            long uptimeMillis = SystemClock.uptimeMillis();
            onTouchEvent(MotionEvent.obtain(uptimeMillis, uptimeMillis, 3, 0.0f, 0.0f, 0));
            this.y = true;
            this.z = true;
            O();
        }
    }

    public void setLayoutManager(o oVar) {
        if (oVar == this.n) {
            return;
        }
        O();
        if (this.n != null) {
            l lVar = this.N;
            if (lVar != null) {
                lVar.b();
            }
            this.n.b(this.f2553b);
            this.n.c(this.f2553b);
            this.f2553b.a();
            if (this.s) {
                this.n.a(this, this.f2553b);
            }
            this.n.f((RecyclerView) null);
            this.n = null;
        } else {
            this.f2553b.a();
        }
        this.f2556e.c();
        this.n = oVar;
        if (oVar != null) {
            if (oVar.f2603b == null) {
                this.n.f(this);
                if (this.s) {
                    this.n.a(this);
                }
            } else {
                throw new IllegalArgumentException("LayoutManager " + oVar + " is already attached to a RecyclerView:" + oVar.f2603b.n());
            }
        }
        this.f2553b.j();
        requestLayout();
    }

    @Override // android.view.View
    public void setNestedScrollingEnabled(boolean z2) {
        getScrollingChildHelper().a(z2);
    }

    public void setOnFlingListener(r rVar) {
        this.W = rVar;
    }

    @Deprecated
    public void setOnScrollListener(t tVar) {
        this.j0 = tVar;
    }

    public void setPreserveFocusAfterLayout(boolean z2) {
        this.e0 = z2;
    }

    public void setRecycledViewPool(u uVar) {
        this.f2553b.a(uVar);
    }

    public void setRecyclerListener(w wVar) {
        this.o = wVar;
    }

    public void setScrollState(int i2) {
        if (i2 == this.O) {
            return;
        }
        this.O = i2;
        if (i2 != 2) {
            P();
        }
        b(i2);
    }

    public void setScrollingTouchSlop(int i2) {
        ViewConfiguration viewConfiguration = ViewConfiguration.get(getContext());
        if (i2 != 0) {
            if (i2 != 1) {
                Log.w("RecyclerView", "setScrollingTouchSlop(): bad argument constant " + i2 + "; using default value");
            } else {
                this.V = viewConfiguration.getScaledPagingTouchSlop();
                return;
            }
        }
        this.V = viewConfiguration.getScaledTouchSlop();
    }

    public void setViewCacheExtension(b0 b0Var) {
        this.f2553b.a(b0Var);
    }

    @Override // android.view.View
    public boolean startNestedScroll(int i2) {
        return getScrollingChildHelper().c(i2);
    }

    @Override // android.view.View, a.b.g.k.k
    public void stopNestedScroll() {
        getScrollingChildHelper().c();
    }

    public final void t() {
        this.f2556e = new g0(new e());
    }

    public void u() {
        this.M = null;
        this.K = null;
        this.L = null;
        this.J = null;
    }

    public void v() {
        if (this.p.size() == 0) {
            return;
        }
        o oVar = this.n;
        if (oVar != null) {
            oVar.a("Cannot invalidate item decorations during a scroll or layout");
        }
        y();
        requestLayout();
    }

    public boolean w() {
        AccessibilityManager accessibilityManager = this.C;
        return accessibilityManager != null && accessibilityManager.isEnabled();
    }

    public boolean x() {
        return this.G > 0;
    }

    public void y() {
        int b2 = this.f2556e.b();
        for (int i2 = 0; i2 < b2; i2++) {
            ((p) this.f2556e.e(i2).getLayoutParams()).f2619c = true;
        }
        this.f2553b.g();
    }

    public void z() {
        int b2 = this.f2556e.b();
        for (int i2 = 0; i2 < b2; i2++) {
            d0 m2 = m(this.f2556e.e(i2));
            if (m2 != null && !m2.z()) {
                m2.a(6);
            }
        }
        y();
        this.f2553b.h();
    }

    /* loaded from: classes.dex */
    public class c0 implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        public int f2572a;

        /* renamed from: b  reason: collision with root package name */
        public int f2573b;

        /* renamed from: c  reason: collision with root package name */
        public OverScroller f2574c;

        /* renamed from: d  reason: collision with root package name */
        public Interpolator f2575d = RecyclerView.J0;

        /* renamed from: e  reason: collision with root package name */
        public boolean f2576e = false;

        /* renamed from: f  reason: collision with root package name */
        public boolean f2577f = false;

        public c0() {
            this.f2574c = new OverScroller(RecyclerView.this.getContext(), RecyclerView.J0);
        }

        public final void a() {
            this.f2577f = false;
            this.f2576e = true;
        }

        public final void b() {
            this.f2576e = false;
            if (this.f2577f) {
                c();
            }
        }

        public void c() {
            if (this.f2576e) {
                this.f2577f = true;
                return;
            }
            RecyclerView.this.removeCallbacks(this);
            a.b.g.k.u.a(RecyclerView.this, this);
        }

        public void d() {
            RecyclerView.this.removeCallbacks(this);
            this.f2574c.abortAnimation();
        }

        /* JADX WARN: Code restructure failed: missing block: B:47:0x00eb, code lost:
            if (r8 > 0) goto L43;
         */
        /* JADX WARN: Removed duplicated region for block: B:45:0x00e7  */
        /* JADX WARN: Removed duplicated region for block: B:52:0x00f7  */
        /* JADX WARN: Removed duplicated region for block: B:54:0x00fe A[ADDED_TO_REGION] */
        @Override // java.lang.Runnable
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public void run() {
            /*
                Method dump skipped, instructions count: 418
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: android.support.v7.widget.RecyclerView.c0.run():void");
        }

        public void a(int i2, int i3) {
            RecyclerView.this.setScrollState(2);
            this.f2573b = 0;
            this.f2572a = 0;
            this.f2574c.fling(0, 0, i2, i3, Integer.MIN_VALUE, Integer.MAX_VALUE, Integer.MIN_VALUE, Integer.MAX_VALUE);
            c();
        }

        public final float a(float f2) {
            return (float) Math.sin((f2 - 0.5f) * 0.47123894f);
        }

        public final int a(int i2, int i3, int i4, int i5) {
            int i6;
            int abs = Math.abs(i2);
            int abs2 = Math.abs(i3);
            boolean z = abs > abs2;
            int sqrt = (int) Math.sqrt((i4 * i4) + (i5 * i5));
            int sqrt2 = (int) Math.sqrt((i2 * i2) + (i3 * i3));
            RecyclerView recyclerView = RecyclerView.this;
            int width = z ? recyclerView.getWidth() : recyclerView.getHeight();
            int i7 = width / 2;
            float f2 = width;
            float f3 = i7;
            float a2 = f3 + (a(Math.min(1.0f, (sqrt2 * 1.0f) / f2)) * f3);
            if (sqrt > 0) {
                i6 = Math.round(Math.abs(a2 / sqrt) * 1000.0f) * 4;
            } else {
                if (!z) {
                    abs = abs2;
                }
                i6 = (int) (((abs / f2) + 1.0f) * 300.0f);
            }
            return Math.min(i6, 2000);
        }

        public void a(int i2, int i3, Interpolator interpolator) {
            int a2 = a(i2, i3, 0, 0);
            if (interpolator == null) {
                interpolator = RecyclerView.J0;
            }
            a(i2, i3, a2, interpolator);
        }

        public void a(int i2, int i3, int i4, Interpolator interpolator) {
            if (this.f2575d != interpolator) {
                this.f2575d = interpolator;
                this.f2574c = new OverScroller(RecyclerView.this.getContext(), interpolator);
            }
            RecyclerView.this.setScrollState(2);
            this.f2573b = 0;
            this.f2572a = 0;
            this.f2574c.startScroll(0, 0, i2, i3, i4);
            if (Build.VERSION.SDK_INT < 23) {
                this.f2574c.computeScrollOffset();
            }
            c();
        }
    }

    /* loaded from: classes.dex */
    public static abstract class d0 {
        public static final List<Object> t = Collections.emptyList();

        /* renamed from: a  reason: collision with root package name */
        public final View f2580a;

        /* renamed from: b  reason: collision with root package name */
        public WeakReference<RecyclerView> f2581b;
        public int j;
        public RecyclerView s;

        /* renamed from: c  reason: collision with root package name */
        public int f2582c = -1;

        /* renamed from: d  reason: collision with root package name */
        public int f2583d = -1;

        /* renamed from: e  reason: collision with root package name */
        public long f2584e = -1;

        /* renamed from: f  reason: collision with root package name */
        public int f2585f = -1;

        /* renamed from: g  reason: collision with root package name */
        public int f2586g = -1;

        /* renamed from: h  reason: collision with root package name */
        public d0 f2587h = null;

        /* renamed from: i  reason: collision with root package name */
        public d0 f2588i = null;
        public List<Object> k = null;
        public List<Object> m = null;
        public int n = 0;
        public v o = null;
        public boolean p = false;
        public int q = 0;
        public int r = -1;

        public d0(View view) {
            if (view != null) {
                this.f2580a = view;
                return;
            }
            throw new IllegalArgumentException("itemView may not be null");
        }

        public void A() {
            this.o.e(this);
        }

        public boolean B() {
            return (this.j & 32) != 0;
        }

        public void a(int i2, int i3, boolean z) {
            a(8);
            a(i3, z);
            this.f2582c = i2;
        }

        public void b() {
            this.f2583d = -1;
            this.f2586g = -1;
        }

        public void c() {
            List<Object> list = this.k;
            if (list != null) {
                list.clear();
            }
            this.j &= -1025;
        }

        public void d() {
            this.j &= -33;
        }

        public void e() {
            this.j &= -257;
        }

        public final void f() {
            if (this.k == null) {
                this.k = new ArrayList();
                this.m = Collections.unmodifiableList(this.k);
            }
        }

        public boolean g() {
            return (this.j & 16) == 0 && a.b.g.k.u.v(this.f2580a);
        }

        public final int h() {
            RecyclerView recyclerView = this.s;
            if (recyclerView == null) {
                return -1;
            }
            return recyclerView.c(this);
        }

        public final long i() {
            return this.f2584e;
        }

        public final int j() {
            return this.f2585f;
        }

        public final int k() {
            int i2 = this.f2586g;
            return i2 == -1 ? this.f2582c : i2;
        }

        public final int l() {
            return this.f2583d;
        }

        public List<Object> m() {
            if ((this.j & 1024) == 0) {
                List<Object> list = this.k;
                if (list != null && list.size() != 0) {
                    return this.m;
                }
                return t;
            }
            return t;
        }

        public boolean n() {
            return (this.j & 512) != 0 || p();
        }

        public boolean o() {
            return (this.j & 1) != 0;
        }

        public boolean p() {
            return (this.j & 4) != 0;
        }

        public final boolean q() {
            return (this.j & 16) == 0 && !a.b.g.k.u.v(this.f2580a);
        }

        public boolean r() {
            return (this.j & 8) != 0;
        }

        public boolean s() {
            return this.o != null;
        }

        public boolean t() {
            return (this.j & 256) != 0;
        }

        public String toString() {
            StringBuilder sb = new StringBuilder("ViewHolder{" + Integer.toHexString(hashCode()) + " position=" + this.f2582c + " id=" + this.f2584e + ", oldPos=" + this.f2583d + ", pLpos:" + this.f2586g);
            if (s()) {
                sb.append(" scrap ");
                sb.append(this.p ? "[changeScrap]" : "[attachedScrap]");
            }
            if (p()) {
                sb.append(" invalid");
            }
            if (!o()) {
                sb.append(" unbound");
            }
            if (v()) {
                sb.append(" update");
            }
            if (r()) {
                sb.append(" removed");
            }
            if (z()) {
                sb.append(" ignored");
            }
            if (t()) {
                sb.append(" tmpDetached");
            }
            if (!q()) {
                sb.append(" not recyclable(" + this.n + ")");
            }
            if (n()) {
                sb.append(" undefined adapter position");
            }
            if (this.f2580a.getParent() == null) {
                sb.append(" no parent");
            }
            sb.append("}");
            return sb.toString();
        }

        public boolean u() {
            return (this.j & 2) != 0;
        }

        public boolean v() {
            return (this.j & 2) != 0;
        }

        public void w() {
            this.j = 0;
            this.f2582c = -1;
            this.f2583d = -1;
            this.f2584e = -1L;
            this.f2586g = -1;
            this.n = 0;
            this.f2587h = null;
            this.f2588i = null;
            c();
            this.q = 0;
            this.r = -1;
            RecyclerView.e(this);
        }

        public void x() {
            if (this.f2583d == -1) {
                this.f2583d = this.f2582c;
            }
        }

        public boolean y() {
            return (this.j & 16) != 0;
        }

        public boolean z() {
            return (this.j & 128) != 0;
        }

        public boolean b(int i2) {
            return (i2 & this.j) != 0;
        }

        public void a(int i2, boolean z) {
            if (this.f2583d == -1) {
                this.f2583d = this.f2582c;
            }
            if (this.f2586g == -1) {
                this.f2586g = this.f2582c;
            }
            if (z) {
                this.f2586g += i2;
            }
            this.f2582c += i2;
            if (this.f2580a.getLayoutParams() != null) {
                ((p) this.f2580a.getLayoutParams()).f2619c = true;
            }
        }

        public void b(RecyclerView recyclerView) {
            recyclerView.a(this, this.q);
            this.q = 0;
        }

        public void a(v vVar, boolean z) {
            this.o = vVar;
            this.p = z;
        }

        public void a(int i2, int i3) {
            this.j = (i2 & i3) | (this.j & (~i3));
        }

        public void a(int i2) {
            this.j = i2 | this.j;
        }

        public void a(Object obj) {
            if (obj == null) {
                a(1024);
            } else if ((1024 & this.j) == 0) {
                f();
                this.k.add(obj);
            }
        }

        public void a(RecyclerView recyclerView) {
            int i2 = this.r;
            if (i2 != -1) {
                this.q = i2;
            } else {
                this.q = a.b.g.k.u.i(this.f2580a);
            }
            recyclerView.a(this, 4);
        }

        public final void a(boolean z) {
            int i2 = this.n;
            this.n = z ? i2 - 1 : i2 + 1;
            int i3 = this.n;
            if (i3 < 0) {
                this.n = 0;
                Log.e("View", "isRecyclable decremented below 0: unmatched pair of setIsRecyable() calls for " + this);
            } else if (!z && i3 == 1) {
                this.j |= 16;
            } else if (z && this.n == 0) {
                this.j &= -17;
            }
        }
    }

    /* loaded from: classes.dex */
    public class f implements d.a {
        public f() {
        }

        @Override // a.b.h.k.d.a
        public d0 a(int i2) {
            d0 a2 = RecyclerView.this.a(i2, true);
            if (a2 == null || RecyclerView.this.f2556e.d(a2.f2580a)) {
                return null;
            }
            return a2;
        }

        @Override // a.b.h.k.d.a
        public void b(int i2, int i3) {
            RecyclerView.this.a(i2, i3, false);
            RecyclerView.this.l0 = true;
        }

        public void c(d.b bVar) {
            int i2 = bVar.f1684a;
            if (i2 == 1) {
                RecyclerView recyclerView = RecyclerView.this;
                recyclerView.n.b(recyclerView, bVar.f1685b, bVar.f1687d);
            } else if (i2 == 2) {
                RecyclerView recyclerView2 = RecyclerView.this;
                recyclerView2.n.c(recyclerView2, bVar.f1685b, bVar.f1687d);
            } else if (i2 == 4) {
                RecyclerView recyclerView3 = RecyclerView.this;
                recyclerView3.n.a(recyclerView3, bVar.f1685b, bVar.f1687d, bVar.f1686c);
            } else if (i2 != 8) {
            } else {
                RecyclerView recyclerView4 = RecyclerView.this;
                recyclerView4.n.a(recyclerView4, bVar.f1685b, bVar.f1687d, 1);
            }
        }

        @Override // a.b.h.k.d.a
        public void d(int i2, int i3) {
            RecyclerView.this.a(i2, i3, true);
            RecyclerView recyclerView = RecyclerView.this;
            recyclerView.l0 = true;
            recyclerView.i0.f2565d += i3;
        }

        @Override // a.b.h.k.d.a
        public void a(int i2, int i3, Object obj) {
            RecyclerView.this.a(i2, i3, obj);
            RecyclerView.this.m0 = true;
        }

        @Override // a.b.h.k.d.a
        public void b(d.b bVar) {
            c(bVar);
        }

        @Override // a.b.h.k.d.a
        public void a(d.b bVar) {
            c(bVar);
        }

        @Override // a.b.h.k.d.a
        public void a(int i2, int i3) {
            RecyclerView.this.h(i2, i3);
            RecyclerView.this.l0 = true;
        }

        @Override // a.b.h.k.d.a
        public void c(int i2, int i3) {
            RecyclerView.this.g(i2, i3);
            RecyclerView.this.l0 = true;
        }
    }

    public RecyclerView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public void j() {
        if (this.M != null) {
            return;
        }
        this.M = this.I.a(this, 3);
        if (this.f2558g) {
            this.M.setSize((getMeasuredWidth() - getPaddingLeft()) - getPaddingRight(), (getMeasuredHeight() - getPaddingTop()) - getPaddingBottom());
        } else {
            this.M.setSize(getMeasuredWidth(), getMeasuredHeight());
        }
    }

    /* loaded from: classes.dex */
    public static class u {

        /* renamed from: a  reason: collision with root package name */
        public SparseArray<a> f2621a = new SparseArray<>();

        /* renamed from: b  reason: collision with root package name */
        public int f2622b = 0;

        /* loaded from: classes.dex */
        public static class a {

            /* renamed from: a  reason: collision with root package name */
            public final ArrayList<d0> f2623a = new ArrayList<>();

            /* renamed from: b  reason: collision with root package name */
            public int f2624b = 5;

            /* renamed from: c  reason: collision with root package name */
            public long f2625c = 0;

            /* renamed from: d  reason: collision with root package name */
            public long f2626d = 0;
        }

        public d0 a(int i2) {
            a aVar = this.f2621a.get(i2);
            if (aVar == null || aVar.f2623a.isEmpty()) {
                return null;
            }
            ArrayList<d0> arrayList = aVar.f2623a;
            return arrayList.remove(arrayList.size() - 1);
        }

        public void b() {
            for (int i2 = 0; i2 < this.f2621a.size(); i2++) {
                this.f2621a.valueAt(i2).f2623a.clear();
            }
        }

        public void c() {
            this.f2622b--;
        }

        public void b(int i2, long j) {
            a b2 = b(i2);
            b2.f2625c = a(b2.f2625c, j);
        }

        public void a(d0 d0Var) {
            int j = d0Var.j();
            ArrayList<d0> arrayList = b(j).f2623a;
            if (this.f2621a.get(j).f2624b <= arrayList.size()) {
                return;
            }
            d0Var.w();
            arrayList.add(d0Var);
        }

        public boolean b(int i2, long j, long j2) {
            long j3 = b(i2).f2625c;
            return j3 == 0 || j + j3 < j2;
        }

        public final a b(int i2) {
            a aVar = this.f2621a.get(i2);
            if (aVar == null) {
                a aVar2 = new a();
                this.f2621a.put(i2, aVar2);
                return aVar2;
            }
            return aVar;
        }

        public long a(long j, long j2) {
            return j == 0 ? j2 : ((j / 4) * 3) + (j2 / 4);
        }

        public void a(int i2, long j) {
            a b2 = b(i2);
            b2.f2626d = a(b2.f2626d, j);
        }

        public boolean a(int i2, long j, long j2) {
            long j3 = b(i2).f2626d;
            return j3 == 0 || j + j3 < j2;
        }

        public void a() {
            this.f2622b++;
        }

        public void a(g gVar, g gVar2, boolean z) {
            if (gVar != null) {
                c();
            }
            if (!z && this.f2622b == 0) {
                b();
            }
            if (gVar2 != null) {
                a();
            }
        }
    }

    /* loaded from: classes.dex */
    public class x extends i {
        public x() {
        }

        @Override // android.support.v7.widget.RecyclerView.i
        public void a() {
            RecyclerView.this.a((String) null);
            RecyclerView recyclerView = RecyclerView.this;
            recyclerView.i0.f2568g = true;
            recyclerView.b(true);
            if (RecyclerView.this.f2555d.c()) {
                return;
            }
            RecyclerView.this.requestLayout();
        }

        @Override // android.support.v7.widget.RecyclerView.i
        public void b(int i2, int i3) {
            RecyclerView.this.a((String) null);
            if (RecyclerView.this.f2555d.b(i2, i3)) {
                b();
            }
        }

        @Override // android.support.v7.widget.RecyclerView.i
        public void c(int i2, int i3) {
            RecyclerView.this.a((String) null);
            if (RecyclerView.this.f2555d.c(i2, i3)) {
                b();
            }
        }

        public void b() {
            if (RecyclerView.E0) {
                RecyclerView recyclerView = RecyclerView.this;
                if (recyclerView.t && recyclerView.s) {
                    a.b.g.k.u.a(recyclerView, recyclerView.f2559h);
                    return;
                }
            }
            RecyclerView recyclerView2 = RecyclerView.this;
            recyclerView2.B = true;
            recyclerView2.requestLayout();
        }

        @Override // android.support.v7.widget.RecyclerView.i
        public void a(int i2, int i3, Object obj) {
            RecyclerView.this.a((String) null);
            if (RecyclerView.this.f2555d.a(i2, i3, obj)) {
                b();
            }
        }

        @Override // android.support.v7.widget.RecyclerView.i
        public void a(int i2, int i3, int i4) {
            RecyclerView.this.a((String) null);
            if (RecyclerView.this.f2555d.a(i2, i3, i4)) {
                b();
            }
        }
    }

    public RecyclerView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.f2552a = new x();
        this.f2553b = new v();
        this.f2557f = new s1();
        this.f2559h = new a();
        this.f2560i = new Rect();
        this.j = new Rect();
        this.k = new RectF();
        this.p = new ArrayList<>();
        this.q = new ArrayList<>();
        this.w = 0;
        this.E = false;
        this.F = false;
        this.G = 0;
        this.H = 0;
        this.I = new k();
        this.N = new j0();
        this.O = 0;
        this.P = -1;
        this.c0 = Float.MIN_VALUE;
        this.d0 = Float.MIN_VALUE;
        boolean z2 = true;
        this.e0 = true;
        this.f0 = new c0();
        this.h0 = F0 ? new p0.b() : null;
        this.i0 = new a0();
        this.l0 = false;
        this.m0 = false;
        this.n0 = new m();
        this.o0 = false;
        this.r0 = new int[2];
        this.t0 = new int[2];
        this.u0 = new int[2];
        this.v0 = new int[2];
        this.w0 = new int[2];
        this.x0 = new ArrayList();
        this.y0 = new b();
        this.z0 = new d();
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, B0, i2, 0);
            this.f2558g = obtainStyledAttributes.getBoolean(0, true);
            obtainStyledAttributes.recycle();
        } else {
            this.f2558g = true;
        }
        setScrollContainer(true);
        setFocusableInTouchMode(true);
        ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
        this.V = viewConfiguration.getScaledTouchSlop();
        this.c0 = a.b.g.k.v.b(viewConfiguration, context);
        this.d0 = a.b.g.k.v.c(viewConfiguration, context);
        this.a0 = viewConfiguration.getScaledMinimumFlingVelocity();
        this.b0 = viewConfiguration.getScaledMaximumFlingVelocity();
        setWillNotDraw(getOverScrollMode() == 2);
        this.N.a(this.n0);
        r();
        t();
        s();
        if (a.b.g.k.u.i(this) == 0) {
            a.b.g.k.u.f(this, 1);
        }
        this.C = (AccessibilityManager) getContext().getSystemService("accessibility");
        setAccessibilityDelegateCompat(new x0(this));
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes2 = context.obtainStyledAttributes(attributeSet, a.b.h.g.b.RecyclerView, i2, 0);
            String string = obtainStyledAttributes2.getString(a.b.h.g.b.RecyclerView_layoutManager);
            if (obtainStyledAttributes2.getInt(a.b.h.g.b.RecyclerView_android_descendantFocusability, -1) == -1) {
                setDescendantFocusability(262144);
            }
            this.u = obtainStyledAttributes2.getBoolean(a.b.h.g.b.RecyclerView_fastScrollEnabled, false);
            if (this.u) {
                a((StateListDrawable) obtainStyledAttributes2.getDrawable(a.b.h.g.b.RecyclerView_fastScrollVerticalThumbDrawable), obtainStyledAttributes2.getDrawable(a.b.h.g.b.RecyclerView_fastScrollVerticalTrackDrawable), (StateListDrawable) obtainStyledAttributes2.getDrawable(a.b.h.g.b.RecyclerView_fastScrollHorizontalThumbDrawable), obtainStyledAttributes2.getDrawable(a.b.h.g.b.RecyclerView_fastScrollHorizontalTrackDrawable));
            }
            obtainStyledAttributes2.recycle();
            a(context, string, attributeSet, i2, 0);
            if (Build.VERSION.SDK_INT >= 21) {
                TypedArray obtainStyledAttributes3 = context.obtainStyledAttributes(attributeSet, A0, i2, 0);
                boolean z3 = obtainStyledAttributes3.getBoolean(0, true);
                obtainStyledAttributes3.recycle();
                z2 = z3;
            }
        } else {
            setDescendantFocusability(262144);
        }
        setNestedScrollingEnabled(z2);
    }

    /* loaded from: classes.dex */
    public static class a0 {

        /* renamed from: b  reason: collision with root package name */
        public SparseArray<Object> f2563b;
        public int m;
        public long n;
        public int o;
        public int p;
        public int q;

        /* renamed from: a  reason: collision with root package name */
        public int f2562a = -1;

        /* renamed from: c  reason: collision with root package name */
        public int f2564c = 0;

        /* renamed from: d  reason: collision with root package name */
        public int f2565d = 0;

        /* renamed from: e  reason: collision with root package name */
        public int f2566e = 1;

        /* renamed from: f  reason: collision with root package name */
        public int f2567f = 0;

        /* renamed from: g  reason: collision with root package name */
        public boolean f2568g = false;

        /* renamed from: h  reason: collision with root package name */
        public boolean f2569h = false;

        /* renamed from: i  reason: collision with root package name */
        public boolean f2570i = false;
        public boolean j = false;
        public boolean k = false;
        public boolean l = false;

        public void a(int i2) {
            if ((this.f2566e & i2) != 0) {
                return;
            }
            throw new IllegalStateException("Layout state should be one of " + Integer.toBinaryString(i2) + " but it is " + Integer.toBinaryString(this.f2566e));
        }

        public int b() {
            return this.f2562a;
        }

        public boolean c() {
            return this.f2562a != -1;
        }

        public boolean d() {
            return this.f2569h;
        }

        public boolean e() {
            return this.l;
        }

        public String toString() {
            return "State{mTargetPosition=" + this.f2562a + ", mData=" + this.f2563b + ", mItemCount=" + this.f2567f + ", mIsMeasuring=" + this.j + ", mPreviousLayoutItemCount=" + this.f2564c + ", mDeletedInvisibleItemCountSincePreviousLayout=" + this.f2565d + ", mStructureChanged=" + this.f2568g + ", mInPreLayout=" + this.f2569h + ", mRunSimpleAnimations=" + this.k + ", mRunPredictiveAnimations=" + this.l + '}';
        }

        public void a(g gVar) {
            this.f2566e = 1;
            this.f2567f = gVar.a();
            this.f2569h = false;
            this.f2570i = false;
            this.j = false;
        }

        public int a() {
            return this.f2569h ? this.f2564c - this.f2565d : this.f2567f;
        }
    }

    /* loaded from: classes.dex */
    public static class p extends ViewGroup.MarginLayoutParams {

        /* renamed from: a  reason: collision with root package name */
        public d0 f2617a;

        /* renamed from: b  reason: collision with root package name */
        public final Rect f2618b;

        /* renamed from: c  reason: collision with root package name */
        public boolean f2619c;

        /* renamed from: d  reason: collision with root package name */
        public boolean f2620d;

        public p(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            this.f2618b = new Rect();
            this.f2619c = true;
            this.f2620d = false;
        }

        public int a() {
            return this.f2617a.k();
        }

        public boolean b() {
            return this.f2617a.u();
        }

        public boolean c() {
            return this.f2617a.r();
        }

        public boolean d() {
            return this.f2617a.p();
        }

        public p(int i2, int i3) {
            super(i2, i3);
            this.f2618b = new Rect();
            this.f2619c = true;
            this.f2620d = false;
        }

        public p(ViewGroup.MarginLayoutParams marginLayoutParams) {
            super(marginLayoutParams);
            this.f2618b = new Rect();
            this.f2619c = true;
            this.f2620d = false;
        }

        public p(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
            this.f2618b = new Rect();
            this.f2619c = true;
            this.f2620d = false;
        }

        public p(p pVar) {
            super((ViewGroup.LayoutParams) pVar);
            this.f2618b = new Rect();
            this.f2619c = true;
            this.f2620d = false;
        }
    }

    /* loaded from: classes.dex */
    public static class y extends a.b.g.k.a {
        public static final Parcelable.Creator<y> CREATOR = new a();

        /* renamed from: c  reason: collision with root package name */
        public Parcelable f2637c;

        /* loaded from: classes.dex */
        public static class a implements Parcelable.ClassLoaderCreator<y> {
            @Override // android.os.Parcelable.Creator
            public y[] newArray(int i2) {
                return new y[i2];
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.ClassLoaderCreator
            public y createFromParcel(Parcel parcel, ClassLoader classLoader) {
                return new y(parcel, classLoader);
            }

            @Override // android.os.Parcelable.Creator
            public y createFromParcel(Parcel parcel) {
                return new y(parcel, null);
            }
        }

        public y(Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            this.f2637c = parcel.readParcelable(classLoader == null ? o.class.getClassLoader() : classLoader);
        }

        public void a(y yVar) {
            this.f2637c = yVar.f2637c;
        }

        @Override // a.b.g.k.a, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i2) {
            super.writeToParcel(parcel, i2);
            parcel.writeParcelable(this.f2637c, 0);
        }

        public y(Parcelable parcelable) {
            super(parcelable);
        }
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        o oVar = this.n;
        if (oVar != null) {
            return oVar.a(layoutParams);
        }
        throw new IllegalStateException("RecyclerView has no LayoutManager" + n());
    }

    public final void a(Context context, String str, AttributeSet attributeSet, int i2, int i3) {
        ClassLoader classLoader;
        Constructor constructor;
        if (str != null) {
            String trim = str.trim();
            if (trim.isEmpty()) {
                return;
            }
            String a2 = a(context, trim);
            try {
                if (isInEditMode()) {
                    classLoader = getClass().getClassLoader();
                } else {
                    classLoader = context.getClassLoader();
                }
                Class<? extends U> asSubclass = classLoader.loadClass(a2).asSubclass(o.class);
                Object[] objArr = null;
                try {
                    constructor = asSubclass.getConstructor(I0);
                    objArr = new Object[]{context, attributeSet, Integer.valueOf(i2), Integer.valueOf(i3)};
                } catch (NoSuchMethodException e2) {
                    try {
                        constructor = asSubclass.getConstructor(new Class[0]);
                    } catch (NoSuchMethodException e3) {
                        e3.initCause(e2);
                        throw new IllegalStateException(attributeSet.getPositionDescription() + ": Error creating LayoutManager " + a2, e3);
                    }
                }
                constructor.setAccessible(true);
                setLayoutManager((o) constructor.newInstance(objArr));
            } catch (ClassCastException e4) {
                throw new IllegalStateException(attributeSet.getPositionDescription() + ": Class is not a LayoutManager " + a2, e4);
            } catch (ClassNotFoundException e5) {
                throw new IllegalStateException(attributeSet.getPositionDescription() + ": Unable to find LayoutManager " + a2, e5);
            } catch (IllegalAccessException e6) {
                throw new IllegalStateException(attributeSet.getPositionDescription() + ": Cannot access non-public constructor " + a2, e6);
            } catch (InstantiationException e7) {
                throw new IllegalStateException(attributeSet.getPositionDescription() + ": Could not instantiate the LayoutManager: " + a2, e7);
            } catch (InvocationTargetException e8) {
                throw new IllegalStateException(attributeSet.getPositionDescription() + ": Could not instantiate the LayoutManager: " + a2, e8);
            }
        }
    }

    /* loaded from: classes.dex */
    public class d implements s1.b {
        public d() {
        }

        @Override // a.b.h.k.s1.b
        public void a(d0 d0Var, l.c cVar, l.c cVar2) {
            d0Var.a(false);
            RecyclerView recyclerView = RecyclerView.this;
            if (recyclerView.E) {
                if (recyclerView.N.a(d0Var, d0Var, cVar, cVar2)) {
                    RecyclerView.this.C();
                }
            } else if (recyclerView.N.c(d0Var, cVar, cVar2)) {
                RecyclerView.this.C();
            }
        }

        @Override // a.b.h.k.s1.b
        public void b(d0 d0Var, l.c cVar, l.c cVar2) {
            RecyclerView.this.f2553b.e(d0Var);
            RecyclerView.this.b(d0Var, cVar, cVar2);
        }

        @Override // a.b.h.k.s1.b
        public void c(d0 d0Var, l.c cVar, l.c cVar2) {
            RecyclerView.this.a(d0Var, cVar, cVar2);
        }

        @Override // a.b.h.k.s1.b
        public void a(d0 d0Var) {
            RecyclerView recyclerView = RecyclerView.this;
            recyclerView.n.a(d0Var.f2580a, recyclerView.f2553b);
        }
    }

    public final void g() {
        N();
        A();
        this.i0.a(6);
        this.f2555d.b();
        this.i0.f2567f = this.m.a();
        a0 a0Var = this.i0;
        a0Var.f2565d = 0;
        a0Var.f2569h = false;
        this.n.e(this.f2553b, a0Var);
        a0 a0Var2 = this.i0;
        a0Var2.f2568g = false;
        this.f2554c = null;
        a0Var2.k = a0Var2.k && this.N != null;
        this.i0.f2566e = 4;
        B();
        c(false);
    }

    public final void h() {
        this.i0.a(4);
        N();
        A();
        a0 a0Var = this.i0;
        a0Var.f2566e = 1;
        if (a0Var.k) {
            for (int a2 = this.f2556e.a() - 1; a2 >= 0; a2--) {
                d0 m2 = m(this.f2556e.c(a2));
                if (!m2.z()) {
                    long d2 = d(m2);
                    l.c a3 = this.N.a(this.i0, m2);
                    d0 a4 = this.f2557f.a(d2);
                    if (a4 != null && !a4.z()) {
                        boolean b2 = this.f2557f.b(a4);
                        boolean b3 = this.f2557f.b(m2);
                        if (b2 && a4 == m2) {
                            this.f2557f.b(m2, a3);
                        } else {
                            l.c f2 = this.f2557f.f(a4);
                            this.f2557f.b(m2, a3);
                            l.c e2 = this.f2557f.e(m2);
                            if (f2 == null) {
                                a(d2, m2, a4);
                            } else {
                                a(a4, m2, f2, e2, b2, b3);
                            }
                        }
                    } else {
                        this.f2557f.b(m2, a3);
                    }
                }
            }
            this.f2557f.a(this.z0);
        }
        this.n.c(this.f2553b);
        a0 a0Var2 = this.i0;
        a0Var2.f2564c = a0Var2.f2567f;
        this.E = false;
        this.F = false;
        a0Var2.k = false;
        a0Var2.l = false;
        this.n.f2609h = false;
        ArrayList<d0> arrayList = this.f2553b.f2628b;
        if (arrayList != null) {
            arrayList.clear();
        }
        o oVar = this.n;
        if (oVar.n) {
            oVar.m = 0;
            oVar.n = false;
            this.f2553b.j();
        }
        this.n.g(this.i0);
        B();
        c(false);
        this.f2557f.a();
        int[] iArr = this.r0;
        if (d(iArr[0], iArr[1])) {
            e(0, 0);
        }
        F();
        J();
    }

    public void k() {
        if (this.J != null) {
            return;
        }
        this.J = this.I.a(this, 0);
        if (this.f2558g) {
            this.J.setSize((getMeasuredHeight() - getPaddingTop()) - getPaddingBottom(), (getMeasuredWidth() - getPaddingLeft()) - getPaddingRight());
        } else {
            this.J.setSize(getMeasuredHeight(), getMeasuredWidth());
        }
    }

    public static RecyclerView l(View view) {
        if (view instanceof ViewGroup) {
            if (view instanceof RecyclerView) {
                return (RecyclerView) view;
            }
            ViewGroup viewGroup = (ViewGroup) view;
            int childCount = viewGroup.getChildCount();
            for (int i2 = 0; i2 < childCount; i2++) {
                RecyclerView l2 = l(viewGroup.getChildAt(i2));
                if (l2 != null) {
                    return l2;
                }
            }
            return null;
        }
        return null;
    }

    public static d0 m(View view) {
        if (view == null) {
            return null;
        }
        return ((p) view.getLayoutParams()).f2617a;
    }

    public void b(t tVar) {
        List<t> list = this.k0;
        if (list != null) {
            list.remove(tVar);
        }
    }

    public final boolean d(int i2, int i3) {
        a(this.r0);
        int[] iArr = this.r0;
        return (iArr[0] == i2 && iArr[1] == i3) ? false : true;
    }

    public void b(int i2, int i3) {
        boolean z2;
        EdgeEffect edgeEffect = this.J;
        if (edgeEffect == null || edgeEffect.isFinished() || i2 <= 0) {
            z2 = false;
        } else {
            this.J.onRelease();
            z2 = this.J.isFinished();
        }
        EdgeEffect edgeEffect2 = this.L;
        if (edgeEffect2 != null && !edgeEffect2.isFinished() && i2 < 0) {
            this.L.onRelease();
            z2 |= this.L.isFinished();
        }
        EdgeEffect edgeEffect3 = this.K;
        if (edgeEffect3 != null && !edgeEffect3.isFinished() && i3 > 0) {
            this.K.onRelease();
            z2 |= this.K.isFinished();
        }
        EdgeEffect edgeEffect4 = this.M;
        if (edgeEffect4 != null && !edgeEffect4.isFinished() && i3 < 0) {
            this.M.onRelease();
            z2 |= this.M.isFinished();
        }
        if (z2) {
            a.b.g.k.u.A(this);
        }
    }

    public long d(d0 d0Var) {
        return this.m.c() ? d0Var.i() : d0Var.f2582c;
    }

    public d0 d(View view) {
        View c2 = c(view);
        if (c2 == null) {
            return null;
        }
        return f(c2);
    }

    public boolean d(int i2) {
        return getScrollingChildHelper().b(i2);
    }

    public boolean k(int i2, int i3) {
        return getScrollingChildHelper().a(i2, i3);
    }

    public final void f() {
        boolean z2 = true;
        this.i0.a(1);
        a(this.i0);
        this.i0.j = false;
        N();
        this.f2557f.a();
        A();
        E();
        L();
        a0 a0Var = this.i0;
        a0Var.f2570i = (a0Var.k && this.m0) ? false : false;
        this.m0 = false;
        this.l0 = false;
        a0 a0Var2 = this.i0;
        a0Var2.f2569h = a0Var2.l;
        a0Var2.f2567f = this.m.a();
        a(this.r0);
        if (this.i0.k) {
            int a2 = this.f2556e.a();
            for (int i2 = 0; i2 < a2; i2++) {
                d0 m2 = m(this.f2556e.c(i2));
                if (!m2.z() && (!m2.p() || this.m.c())) {
                    this.f2557f.c(m2, this.N.a(this.i0, m2, l.g(m2), m2.m()));
                    if (this.i0.f2570i && m2.u() && !m2.r() && !m2.z() && !m2.p()) {
                        this.f2557f.a(d(m2), m2);
                    }
                }
            }
        }
        if (this.i0.l) {
            M();
            a0 a0Var3 = this.i0;
            boolean z3 = a0Var3.f2568g;
            a0Var3.f2568g = false;
            this.n.e(this.f2553b, a0Var3);
            this.i0.f2568g = z3;
            for (int i3 = 0; i3 < this.f2556e.a(); i3++) {
                d0 m3 = m(this.f2556e.c(i3));
                if (!m3.z() && !this.f2557f.c(m3)) {
                    int g2 = l.g(m3);
                    boolean b2 = m3.b(8192);
                    if (!b2) {
                        g2 |= 4096;
                    }
                    l.c a3 = this.N.a(this.i0, m3, g2, m3.m());
                    if (b2) {
                        a(m3, a3);
                    } else {
                        this.f2557f.a(m3, a3);
                    }
                }
            }
            b();
        } else {
            b();
        }
        B();
        c(false);
        this.i0.f2566e = 2;
    }

    public int e(View view) {
        d0 m2 = m(view);
        if (m2 != null) {
            return m2.h();
        }
        return -1;
    }

    public void e(int i2) {
        int a2 = this.f2556e.a();
        for (int i3 = 0; i3 < a2; i3++) {
            this.f2556e.c(i3).offsetLeftAndRight(i2);
        }
    }

    public void e(int i2, int i3) {
        this.H++;
        int scrollX = getScrollX();
        int scrollY = getScrollY();
        onScrollChanged(scrollX, scrollY, scrollX, scrollY);
        i(i2, i3);
        t tVar = this.j0;
        if (tVar != null) {
            tVar.a(this, i2, i3);
        }
        List<t> list = this.k0;
        if (list != null) {
            for (int size = list.size() - 1; size >= 0; size--) {
                this.k0.get(size).a(this, i2, i3);
            }
        }
        this.H--;
    }

    public void g(int i2, int i3) {
        int b2 = this.f2556e.b();
        for (int i4 = 0; i4 < b2; i4++) {
            d0 m2 = m(this.f2556e.e(i4));
            if (m2 != null && !m2.z() && m2.f2582c >= i2) {
                m2.a(i3, false);
                this.i0.f2568g = true;
            }
        }
        this.f2553b.a(i2, i3);
        requestLayout();
    }

    public void b(s sVar) {
        this.q.remove(sVar);
        if (this.r == sVar) {
            this.r = null;
        }
    }

    public void c(boolean z2) {
        if (this.w < 1) {
            this.w = 1;
        }
        if (!z2 && !this.y) {
            this.x = false;
        }
        if (this.w == 1) {
            if (z2 && this.x && !this.y && this.n != null && this.m != null) {
                e();
            }
            if (!this.y) {
                this.x = false;
            }
        }
        this.w--;
    }

    public final String a(Context context, String str) {
        if (str.charAt(0) == '.') {
            return context.getPackageName() + str;
        } else if (str.contains(".")) {
            return str;
        } else {
            return RecyclerView.class.getPackage().getName() + '.' + str;
        }
    }

    public final boolean b(MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (action == 3 || action == 0) {
            this.r = null;
        }
        int size = this.q.size();
        for (int i2 = 0; i2 < size; i2++) {
            s sVar = this.q.get(i2);
            if (sVar.b(this, motionEvent) && action != 3) {
                this.r = sVar;
                return true;
            }
        }
        return false;
    }

    public final void a(g gVar, boolean z2, boolean z3) {
        g gVar2 = this.m;
        if (gVar2 != null) {
            gVar2.b(this.f2552a);
            this.m.b(this);
        }
        if (!z2 || z3) {
            H();
        }
        this.f2555d.f();
        g gVar3 = this.m;
        this.m = gVar;
        if (gVar != null) {
            gVar.a(this.f2552a);
            gVar.a(this);
        }
        o oVar = this.n;
        if (oVar != null) {
            oVar.a(gVar3, this.m);
        }
        this.f2553b.a(gVar3, this.m, z2);
        this.i0.f2568g = true;
    }

    public static void e(d0 d0Var) {
        WeakReference<RecyclerView> weakReference = d0Var.f2581b;
        if (weakReference != null) {
            RecyclerView recyclerView = weakReference.get();
            while (recyclerView != null) {
                if (recyclerView == d0Var.f2580a) {
                    return;
                }
                ViewParent parent = recyclerView.getParent();
                recyclerView = parent instanceof View ? (View) parent : null;
            }
            d0Var.f2581b = null;
        }
    }

    public void b(d0 d0Var, l.c cVar, l.c cVar2) {
        a(d0Var);
        d0Var.a(false);
        if (this.N.b(d0Var, cVar, cVar2)) {
            C();
        }
    }

    public final void c(MotionEvent motionEvent) {
        int actionIndex = motionEvent.getActionIndex();
        if (motionEvent.getPointerId(actionIndex) == this.P) {
            int i2 = actionIndex == 0 ? 1 : 0;
            this.P = motionEvent.getPointerId(i2);
            int x2 = (int) (motionEvent.getX(i2) + 0.5f);
            this.T = x2;
            this.R = x2;
            int y2 = (int) (motionEvent.getY(i2) + 0.5f);
            this.U = y2;
            this.S = y2;
        }
    }

    public void b() {
        int b2 = this.f2556e.b();
        for (int i2 = 0; i2 < b2; i2++) {
            d0 m2 = m(this.f2556e.e(i2));
            if (!m2.z()) {
                m2.b();
            }
        }
        this.f2553b.b();
    }

    public void c(int i2, int i3) {
        setMeasuredDimension(o.a(i2, getPaddingLeft() + getPaddingRight(), a.b.g.k.u.m(this)), o.a(i3, getPaddingTop() + getPaddingBottom(), a.b.g.k.u.l(this)));
    }

    public boolean b(d0 d0Var) {
        l lVar = this.N;
        return lVar == null || lVar.a(d0Var, d0Var.m());
    }

    public final void a(d0 d0Var) {
        View view = d0Var.f2580a;
        boolean z2 = view.getParent() == this;
        this.f2553b.e(f(view));
        if (d0Var.t()) {
            this.f2556e.a(view, -1, view.getLayoutParams(), true);
        } else if (!z2) {
            this.f2556e.a(view, true);
        } else {
            this.f2556e.a(view);
        }
    }

    public void b(boolean z2) {
        this.F = z2 | this.F;
        this.E = true;
        z();
    }

    /* JADX WARN: Code restructure failed: missing block: B:15:?, code lost:
        return r3;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public android.view.View c(android.view.View r3) {
        /*
            r2 = this;
            android.view.ViewParent r0 = r3.getParent()
        L4:
            if (r0 == 0) goto L14
            if (r0 == r2) goto L14
            boolean r1 = r0 instanceof android.view.View
            if (r1 == 0) goto L14
            r3 = r0
            android.view.View r3 = (android.view.View) r3
            android.view.ViewParent r0 = r3.getParent()
            goto L4
        L14:
            if (r0 != r2) goto L17
            goto L18
        L17:
            r3 = 0
        L18:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v7.widget.RecyclerView.c(android.view.View):android.view.View");
    }

    public void b(int i2) {
        o oVar = this.n;
        if (oVar != null) {
            oVar.f(i2);
        }
        g(i2);
        t tVar = this.j0;
        if (tVar != null) {
            tVar.a(this, i2);
        }
        List<t> list = this.k0;
        if (list != null) {
            for (int size = list.size() - 1; size >= 0; size--) {
                this.k0.get(size).a(this, i2);
            }
        }
    }

    public void a(n nVar, int i2) {
        o oVar = this.n;
        if (oVar != null) {
            oVar.a("Cannot add item decoration during a scroll  or layout");
        }
        if (this.p.isEmpty()) {
            setWillNotDraw(false);
        }
        if (i2 < 0) {
            this.p.add(nVar);
        } else {
            this.p.add(i2, nVar);
        }
        y();
        requestLayout();
    }

    public d0 c(int i2) {
        d0 d0Var = null;
        if (this.E) {
            return null;
        }
        int b2 = this.f2556e.b();
        for (int i3 = 0; i3 < b2; i3++) {
            d0 m2 = m(this.f2556e.e(i3));
            if (m2 != null && !m2.r() && c(m2) == i2) {
                if (!this.f2556e.d(m2.f2580a)) {
                    return m2;
                }
                d0Var = m2;
            }
        }
        return d0Var;
    }

    public void h(int i2, int i3) {
        int i4;
        int i5;
        int i6;
        int i7;
        int b2 = this.f2556e.b();
        if (i2 < i3) {
            i5 = i2;
            i4 = i3;
            i6 = -1;
        } else {
            i4 = i2;
            i5 = i3;
            i6 = 1;
        }
        for (int i8 = 0; i8 < b2; i8++) {
            d0 m2 = m(this.f2556e.e(i8));
            if (m2 != null && (i7 = m2.f2582c) >= i5 && i7 <= i4) {
                if (i7 == i2) {
                    m2.a(i3 - i2, false);
                } else {
                    m2.a(i6, false);
                }
                this.i0.f2568g = true;
            }
        }
        this.f2553b.b(i2, i3);
        requestLayout();
    }

    public void b(View view) {
        d0 m2 = m(view);
        j(view);
        g gVar = this.m;
        if (gVar != null && m2 != null) {
            gVar.c((g) m2);
        }
        List<q> list = this.D;
        if (list != null) {
            for (int size = list.size() - 1; size >= 0; size--) {
                this.D.get(size).b(view);
            }
        }
    }

    public int c(d0 d0Var) {
        if (d0Var.b(524) || !d0Var.o()) {
            return -1;
        }
        return this.f2555d.a(d0Var.f2582c);
    }

    public void a(n nVar) {
        a(nVar, -1);
    }

    public void a(t tVar) {
        if (this.k0 == null) {
            this.k0 = new ArrayList();
        }
        this.k0.add(tVar);
    }

    public Rect h(View view) {
        p pVar = (p) view.getLayoutParams();
        if (!pVar.f2619c) {
            return pVar.f2618b;
        }
        if (this.i0.d() && (pVar.b() || pVar.d())) {
            return pVar.f2618b;
        }
        Rect rect = pVar.f2618b;
        rect.set(0, 0, 0, 0);
        int size = this.p.size();
        for (int i2 = 0; i2 < size; i2++) {
            this.f2560i.set(0, 0, 0, 0);
            this.p.get(i2).a(this.f2560i, view, this, this.i0);
            int i3 = rect.left;
            Rect rect2 = this.f2560i;
            rect.left = i3 + rect2.left;
            rect.top += rect2.top;
            rect.right += rect2.right;
            rect.bottom += rect2.bottom;
        }
        pVar.f2619c = false;
        return rect;
    }

    public void a(int i2, int i3, int[] iArr) {
        N();
        A();
        a.b.g.g.h.a("RV Scroll");
        a(this.i0);
        int a2 = i2 != 0 ? this.n.a(i2, this.f2553b, this.i0) : 0;
        int b2 = i3 != 0 ? this.n.b(i3, this.f2553b, this.i0) : 0;
        a.b.g.g.h.a();
        I();
        B();
        c(false);
        if (iArr != null) {
            iArr[0] = a2;
            iArr[1] = b2;
        }
    }

    public d0 f(View view) {
        ViewParent parent = view.getParent();
        if (parent != null && parent != this) {
            throw new IllegalArgumentException("View " + view + " is not a direct child of " + this);
        }
        return m(view);
    }

    public void f(int i2) {
        int a2 = this.f2556e.a();
        for (int i3 = 0; i3 < a2; i3++) {
            this.f2556e.c(i3).offsetTopAndBottom(i2);
        }
    }

    public boolean a(int i2, int i3, MotionEvent motionEvent) {
        int i4;
        int i5;
        int i6;
        int i7;
        c();
        if (this.m != null) {
            a(i2, i3, this.w0);
            int[] iArr = this.w0;
            int i8 = iArr[0];
            int i9 = iArr[1];
            i4 = i9;
            i7 = i8;
            i5 = i2 - i8;
            i6 = i3 - i9;
        } else {
            i4 = 0;
            i5 = 0;
            i6 = 0;
            i7 = 0;
        }
        if (!this.p.isEmpty()) {
            invalidate();
        }
        int i10 = i4;
        if (a(i7, i4, i5, i6, this.t0, 0)) {
            int i11 = this.T;
            int[] iArr2 = this.t0;
            this.T = i11 - iArr2[0];
            this.U -= iArr2[1];
            if (motionEvent != null) {
                motionEvent.offsetLocation(iArr2[0], iArr2[1]);
            }
            int[] iArr3 = this.v0;
            int i12 = iArr3[0];
            int[] iArr4 = this.t0;
            iArr3[0] = i12 + iArr4[0];
            iArr3[1] = iArr3[1] + iArr4[1];
        } else if (getOverScrollMode() != 2) {
            if (motionEvent != null && !a.b.g.k.i.a(motionEvent, 8194)) {
                a(motionEvent.getX(), i5, motionEvent.getY(), i6);
            }
            b(i2, i3);
        }
        if (i7 != 0 || i10 != 0) {
            e(i7, i10);
        }
        if (!awakenScrollBars()) {
            invalidate();
        }
        return (i7 == 0 && i10 == 0) ? false : true;
    }

    public void a(int i2, int i3, Interpolator interpolator) {
        o oVar = this.n;
        if (oVar == null) {
            Log.e("RecyclerView", "Cannot smooth scroll without a LayoutManager set. Call setLayoutManager with a non-null argument.");
        } else if (this.y) {
        } else {
            if (!oVar.a()) {
                i2 = 0;
            }
            if (!this.n.b()) {
                i3 = 0;
            }
            if (i2 == 0 && i3 == 0) {
                return;
            }
            this.f0.a(i2, i3, interpolator);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0040  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0056  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void a(float r7, float r8, float r9, float r10) {
        /*
            r6 = this;
            r0 = 1065353216(0x3f800000, float:1.0)
            r1 = 1
            r2 = 0
            int r3 = (r8 > r2 ? 1 : (r8 == r2 ? 0 : -1))
            if (r3 >= 0) goto L21
            r6.k()
            android.widget.EdgeEffect r3 = r6.J
            float r4 = -r8
            int r5 = r6.getWidth()
            float r5 = (float) r5
            float r4 = r4 / r5
            int r5 = r6.getHeight()
            float r5 = (float) r5
            float r9 = r9 / r5
            float r9 = r0 - r9
            a.b.g.l.i.a(r3, r4, r9)
        L1f:
            r9 = 1
            goto L3c
        L21:
            int r3 = (r8 > r2 ? 1 : (r8 == r2 ? 0 : -1))
            if (r3 <= 0) goto L3b
            r6.l()
            android.widget.EdgeEffect r3 = r6.L
            int r4 = r6.getWidth()
            float r4 = (float) r4
            float r4 = r8 / r4
            int r5 = r6.getHeight()
            float r5 = (float) r5
            float r9 = r9 / r5
            a.b.g.l.i.a(r3, r4, r9)
            goto L1f
        L3b:
            r9 = 0
        L3c:
            int r3 = (r10 > r2 ? 1 : (r10 == r2 ? 0 : -1))
            if (r3 >= 0) goto L56
            r6.m()
            android.widget.EdgeEffect r9 = r6.K
            float r0 = -r10
            int r3 = r6.getHeight()
            float r3 = (float) r3
            float r0 = r0 / r3
            int r3 = r6.getWidth()
            float r3 = (float) r3
            float r7 = r7 / r3
            a.b.g.l.i.a(r9, r0, r7)
            goto L72
        L56:
            int r3 = (r10 > r2 ? 1 : (r10 == r2 ? 0 : -1))
            if (r3 <= 0) goto L71
            r6.j()
            android.widget.EdgeEffect r9 = r6.M
            int r3 = r6.getHeight()
            float r3 = (float) r3
            float r3 = r10 / r3
            int r4 = r6.getWidth()
            float r4 = (float) r4
            float r7 = r7 / r4
            float r0 = r0 - r7
            a.b.g.l.i.a(r9, r3, r0)
            goto L72
        L71:
            r1 = r9
        L72:
            if (r1 != 0) goto L7c
            int r7 = (r8 > r2 ? 1 : (r8 == r2 ? 0 : -1))
            if (r7 != 0) goto L7c
            int r7 = (r10 > r2 ? 1 : (r10 == r2 ? 0 : -1))
            if (r7 == 0) goto L7f
        L7c:
            a.b.g.k.u.A(r6)
        L7f:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v7.widget.RecyclerView.a(float, float, float, float):void");
    }

    public void a(int i2, int i3) {
        if (i2 < 0) {
            k();
            this.J.onAbsorb(-i2);
        } else if (i2 > 0) {
            l();
            this.L.onAbsorb(i2);
        }
        if (i3 < 0) {
            m();
            this.K.onAbsorb(-i3);
        } else if (i3 > 0) {
            j();
            this.M.onAbsorb(i3);
        }
        if (i2 == 0 && i3 == 0) {
            return;
        }
        a.b.g.k.u.A(this);
    }

    public final boolean a(View view, View view2, int i2) {
        int i3;
        if (view2 == null || view2 == this || c(view2) == null) {
            return false;
        }
        if (view == null || c(view) == null) {
            return true;
        }
        this.f2560i.set(0, 0, view.getWidth(), view.getHeight());
        this.j.set(0, 0, view2.getWidth(), view2.getHeight());
        offsetDescendantRectToMyCoords(view, this.f2560i);
        offsetDescendantRectToMyCoords(view2, this.j);
        char c2 = 65535;
        int i4 = this.n.j() == 1 ? -1 : 1;
        Rect rect = this.f2560i;
        int i5 = rect.left;
        int i6 = this.j.left;
        if ((i5 < i6 || rect.right <= i6) && this.f2560i.right < this.j.right) {
            i3 = 1;
        } else {
            Rect rect2 = this.f2560i;
            int i7 = rect2.right;
            int i8 = this.j.right;
            i3 = ((i7 > i8 || rect2.left >= i8) && this.f2560i.left > this.j.left) ? -1 : 0;
        }
        Rect rect3 = this.f2560i;
        int i9 = rect3.top;
        int i10 = this.j.top;
        if ((i9 < i10 || rect3.bottom <= i10) && this.f2560i.bottom < this.j.bottom) {
            c2 = 1;
        } else {
            Rect rect4 = this.f2560i;
            int i11 = rect4.bottom;
            int i12 = this.j.bottom;
            if ((i11 <= i12 && rect4.top < i12) || this.f2560i.top <= this.j.top) {
                c2 = 0;
            }
        }
        if (i2 == 1) {
            return c2 < 0 || (c2 == 0 && i3 * i4 <= 0);
        } else if (i2 == 2) {
            return c2 > 0 || (c2 == 0 && i3 * i4 >= 0);
        } else if (i2 == 17) {
            return i3 < 0;
        } else if (i2 == 33) {
            return c2 < 0;
        } else if (i2 == 66) {
            return i3 > 0;
        } else if (i2 == 130) {
            return c2 > 0;
        } else {
            throw new IllegalArgumentException("Invalid direction: " + i2 + n());
        }
    }

    public final void a(View view, View view2) {
        View view3 = view2 != null ? view2 : view;
        this.f2560i.set(0, 0, view3.getWidth(), view3.getHeight());
        ViewGroup.LayoutParams layoutParams = view3.getLayoutParams();
        if (layoutParams instanceof p) {
            p pVar = (p) layoutParams;
            if (!pVar.f2619c) {
                Rect rect = pVar.f2618b;
                Rect rect2 = this.f2560i;
                rect2.left -= rect.left;
                rect2.right += rect.right;
                rect2.top -= rect.top;
                rect2.bottom += rect.bottom;
            }
        }
        if (view2 != null) {
            offsetDescendantRectToMyCoords(view2, this.f2560i);
            offsetRectIntoDescendantCoords(view, this.f2560i);
        }
        this.n.a(this, view, this.f2560i, !this.v, view2 == null);
    }

    public void a(String str) {
        if (x()) {
            if (str == null) {
                throw new IllegalStateException("Cannot call this method while RecyclerView is computing a layout or scrolling" + n());
            }
            throw new IllegalStateException(str);
        } else if (this.H > 0) {
            Log.w("RecyclerView", "Cannot call this method in a scroll callback. Scroll callbacks mightbe run during a measure & layout pass where you cannot change theRecyclerView data. Any method call that might change the structureof the RecyclerView or the adapter contents should be postponed tothe next frame.", new IllegalStateException("" + n()));
        }
    }

    public void a(s sVar) {
        this.q.add(sVar);
    }

    public final boolean a(MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        s sVar = this.r;
        if (sVar != null) {
            if (action == 0) {
                this.r = null;
            } else {
                sVar.a(this, motionEvent);
                if (action == 3 || action == 1) {
                    this.r = null;
                }
                return true;
            }
        }
        if (action != 0) {
            int size = this.q.size();
            for (int i2 = 0; i2 < size; i2++) {
                s sVar2 = this.q.get(i2);
                if (sVar2.b(this, motionEvent)) {
                    this.r = sVar2;
                    return true;
                }
            }
        }
        return false;
    }

    public final void a() {
        K();
        setScrollState(0);
    }

    public void a(boolean z2) {
        this.G--;
        if (this.G < 1) {
            this.G = 0;
            if (z2) {
                d();
                i();
            }
        }
    }

    public boolean a(AccessibilityEvent accessibilityEvent) {
        if (x()) {
            int a2 = accessibilityEvent != null ? a.b.g.k.e0.a.a(accessibilityEvent) : 0;
            if (a2 == 0) {
                a2 = 0;
            }
            this.A = a2 | this.A;
            return true;
        }
        return false;
    }

    public final void a(a0 a0Var) {
        if (getScrollState() == 2) {
            OverScroller overScroller = this.f0.f2574c;
            a0Var.p = overScroller.getFinalX() - overScroller.getCurrX();
            a0Var.q = overScroller.getFinalY() - overScroller.getCurrY();
            return;
        }
        a0Var.p = 0;
        a0Var.q = 0;
    }

    public final void a(long j2, d0 d0Var, d0 d0Var2) {
        int a2 = this.f2556e.a();
        for (int i2 = 0; i2 < a2; i2++) {
            d0 m2 = m(this.f2556e.c(i2));
            if (m2 != d0Var && d(m2) == j2) {
                g gVar = this.m;
                if (gVar != null && gVar.c()) {
                    throw new IllegalStateException("Two different ViewHolders have the same stable ID. Stable IDs in your adapter MUST BE unique and SHOULD NOT change.\n ViewHolder 1:" + m2 + " \n View Holder 2:" + d0Var + n());
                }
                throw new IllegalStateException("Two different ViewHolders have the same change ID. This might happen due to inconsistent Adapter update events or if the LayoutManager lays out the same View multiple times.\n ViewHolder 1:" + m2 + " \n View Holder 2:" + d0Var + n());
            }
        }
        Log.e("RecyclerView", "Problem while matching changed view holders with the newones. The pre-layout information for the change holder " + d0Var2 + " cannot be found but it is necessary for " + d0Var + n());
    }

    public void a(d0 d0Var, l.c cVar) {
        d0Var.a(0, 8192);
        if (this.i0.f2570i && d0Var.u() && !d0Var.r() && !d0Var.z()) {
            this.f2557f.a(d(d0Var), d0Var);
        }
        this.f2557f.c(d0Var, cVar);
    }

    public final void a(int[] iArr) {
        int a2 = this.f2556e.a();
        if (a2 == 0) {
            iArr[0] = -1;
            iArr[1] = -1;
            return;
        }
        int i2 = Integer.MAX_VALUE;
        int i3 = Integer.MIN_VALUE;
        for (int i4 = 0; i4 < a2; i4++) {
            d0 m2 = m(this.f2556e.c(i4));
            if (!m2.z()) {
                int k2 = m2.k();
                if (k2 < i2) {
                    i2 = k2;
                }
                if (k2 > i3) {
                    i3 = k2;
                }
            }
        }
        iArr[0] = i2;
        iArr[1] = i3;
    }

    public void a(d0 d0Var, l.c cVar, l.c cVar2) {
        d0Var.a(false);
        if (this.N.a(d0Var, cVar, cVar2)) {
            C();
        }
    }

    public final void a(d0 d0Var, d0 d0Var2, l.c cVar, l.c cVar2, boolean z2, boolean z3) {
        d0Var.a(false);
        if (z2) {
            a(d0Var);
        }
        if (d0Var != d0Var2) {
            if (z3) {
                a(d0Var2);
            }
            d0Var.f2587h = d0Var2;
            a(d0Var);
            this.f2553b.e(d0Var);
            d0Var2.a(false);
            d0Var2.f2588i = d0Var;
        }
        if (this.N.a(d0Var, d0Var2, cVar, cVar2)) {
            C();
        }
    }

    public void a(int i2, int i3, boolean z2) {
        int i4 = i2 + i3;
        int b2 = this.f2556e.b();
        for (int i5 = 0; i5 < b2; i5++) {
            d0 m2 = m(this.f2556e.e(i5));
            if (m2 != null && !m2.z()) {
                int i6 = m2.f2582c;
                if (i6 >= i4) {
                    m2.a(-i3, z2);
                    this.i0.f2568g = true;
                } else if (i6 >= i2) {
                    m2.a(i2 - 1, -i3, z2);
                    this.i0.f2568g = true;
                }
            }
        }
        this.f2553b.a(i2, i3, z2);
        requestLayout();
    }

    public void a(int i2, int i3, Object obj) {
        int i4;
        int b2 = this.f2556e.b();
        int i5 = i2 + i3;
        for (int i6 = 0; i6 < b2; i6++) {
            View e2 = this.f2556e.e(i6);
            d0 m2 = m(e2);
            if (m2 != null && !m2.z() && (i4 = m2.f2582c) >= i2 && i4 < i5) {
                m2.a(2);
                m2.a(obj);
                ((p) e2.getLayoutParams()).f2619c = true;
            }
        }
        this.f2553b.c(i2, i3);
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x0034  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0036 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public android.support.v7.widget.RecyclerView.d0 a(int r6, boolean r7) {
        /*
            r5 = this;
            a.b.h.k.g0 r0 = r5.f2556e
            int r0 = r0.b()
            r1 = 0
            r2 = 0
        L8:
            if (r2 >= r0) goto L3a
            a.b.h.k.g0 r3 = r5.f2556e
            android.view.View r3 = r3.e(r2)
            android.support.v7.widget.RecyclerView$d0 r3 = m(r3)
            if (r3 == 0) goto L37
            boolean r4 = r3.r()
            if (r4 != 0) goto L37
            if (r7 == 0) goto L23
            int r4 = r3.f2582c
            if (r4 == r6) goto L2a
            goto L37
        L23:
            int r4 = r3.k()
            if (r4 == r6) goto L2a
            goto L37
        L2a:
            a.b.h.k.g0 r1 = r5.f2556e
            android.view.View r4 = r3.f2580a
            boolean r1 = r1.d(r4)
            if (r1 == 0) goto L36
            r1 = r3
            goto L37
        L36:
            return r3
        L37:
            int r2 = r2 + 1
            goto L8
        L3a:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v7.widget.RecyclerView.a(int, boolean):android.support.v7.widget.RecyclerView$d0");
    }

    public d0 a(long j2) {
        g gVar = this.m;
        d0 d0Var = null;
        if (gVar != null && gVar.c()) {
            int b2 = this.f2556e.b();
            for (int i2 = 0; i2 < b2; i2++) {
                d0 m2 = m(this.f2556e.e(i2));
                if (m2 != null && !m2.r() && m2.i() == j2) {
                    if (!this.f2556e.d(m2.f2580a)) {
                        return m2;
                    }
                    d0Var = m2;
                }
            }
        }
        return d0Var;
    }

    public static void a(View view, Rect rect) {
        p pVar = (p) view.getLayoutParams();
        Rect rect2 = pVar.f2618b;
        rect.set((view.getLeft() - rect2.left) - ((ViewGroup.MarginLayoutParams) pVar).leftMargin, (view.getTop() - rect2.top) - ((ViewGroup.MarginLayoutParams) pVar).topMargin, view.getRight() + rect2.right + ((ViewGroup.MarginLayoutParams) pVar).rightMargin, view.getBottom() + rect2.bottom + ((ViewGroup.MarginLayoutParams) pVar).bottomMargin);
    }

    public void a(View view) {
        d0 m2 = m(view);
        i(view);
        g gVar = this.m;
        if (gVar != null && m2 != null) {
            gVar.b((g) m2);
        }
        List<q> list = this.D;
        if (list != null) {
            for (int size = list.size() - 1; size >= 0; size--) {
                this.D.get(size).a(view);
            }
        }
    }

    public boolean a(d0 d0Var, int i2) {
        if (x()) {
            d0Var.r = i2;
            this.x0.add(d0Var);
            return false;
        }
        a.b.g.k.u.f(d0Var.f2580a, i2);
        return true;
    }

    public void a(StateListDrawable stateListDrawable, Drawable drawable, StateListDrawable stateListDrawable2, Drawable drawable2) {
        if (stateListDrawable != null && drawable != null && stateListDrawable2 != null && drawable2 != null) {
            Resources resources = getContext().getResources();
            new m0(this, stateListDrawable, drawable, stateListDrawable2, drawable2, resources.getDimensionPixelSize(a.b.h.g.a.fastscroll_default_thickness), resources.getDimensionPixelSize(a.b.h.g.a.fastscroll_minimum_range), resources.getDimensionPixelOffset(a.b.h.g.a.fastscroll_margin));
            return;
        }
        throw new IllegalArgumentException("Trying to set fast scroller without both required drawables." + n());
    }

    @Override // a.b.g.k.j
    public void a(int i2) {
        getScrollingChildHelper().d(i2);
    }

    public boolean a(int i2, int i3, int i4, int i5, int[] iArr, int i6) {
        return getScrollingChildHelper().a(i2, i3, i4, i5, iArr, i6);
    }

    public boolean a(int i2, int i3, int[] iArr, int[] iArr2, int i4) {
        return getScrollingChildHelper().a(i2, i3, iArr, iArr2, i4);
    }
}
