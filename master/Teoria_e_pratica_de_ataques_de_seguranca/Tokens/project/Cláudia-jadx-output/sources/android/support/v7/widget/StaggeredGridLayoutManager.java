package android.support.v7.widget;

import a.b.g.k.e0.c;
import a.b.h.k.c1;
import a.b.h.k.q0;
import a.b.h.k.w0;
import android.content.Context;
import android.graphics.Rect;
import android.os.Parcel;
import android.os.Parcelable;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.BitSet;
import java.util.List;
/* loaded from: classes.dex */
public class StaggeredGridLayoutManager extends RecyclerView.o implements RecyclerView.z.a {
    public BitSet B;
    public boolean G;
    public boolean H;
    public e I;
    public int J;
    public int[] O;
    public f[] t;
    public w0 u;
    public w0 v;
    public int w;
    public int x;
    public final q0 y;
    public int s = -1;
    public boolean z = false;
    public boolean A = false;
    public int C = -1;
    public int D = Integer.MIN_VALUE;
    public d E = new d();
    public int F = 2;
    public final Rect K = new Rect();
    public final b L = new b();
    public boolean M = false;
    public boolean N = true;
    public final Runnable P = new a();

    /* loaded from: classes.dex */
    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            StaggeredGridLayoutManager.this.F();
        }
    }

    /* loaded from: classes.dex */
    public static class c extends RecyclerView.p {

        /* renamed from: e  reason: collision with root package name */
        public f f2671e;

        /* renamed from: f  reason: collision with root package name */
        public boolean f2672f;

        public c(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }

        public final int e() {
            f fVar = this.f2671e;
            if (fVar == null) {
                return -1;
            }
            return fVar.f2692e;
        }

        public boolean f() {
            return this.f2672f;
        }

        public c(int i2, int i3) {
            super(i2, i3);
        }

        public c(ViewGroup.MarginLayoutParams marginLayoutParams) {
            super(marginLayoutParams);
        }

        public c(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
        }
    }

    /* loaded from: classes.dex */
    public static class e implements Parcelable {
        public static final Parcelable.Creator<e> CREATOR = new a();

        /* renamed from: a  reason: collision with root package name */
        public int f2679a;

        /* renamed from: b  reason: collision with root package name */
        public int f2680b;

        /* renamed from: c  reason: collision with root package name */
        public int f2681c;

        /* renamed from: d  reason: collision with root package name */
        public int[] f2682d;

        /* renamed from: e  reason: collision with root package name */
        public int f2683e;

        /* renamed from: f  reason: collision with root package name */
        public int[] f2684f;

        /* renamed from: g  reason: collision with root package name */
        public List<d.a> f2685g;

        /* renamed from: h  reason: collision with root package name */
        public boolean f2686h;

        /* renamed from: i  reason: collision with root package name */
        public boolean f2687i;
        public boolean j;

        /* loaded from: classes.dex */
        public static class a implements Parcelable.Creator<e> {
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public e createFromParcel(Parcel parcel) {
                return new e(parcel);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public e[] newArray(int i2) {
                return new e[i2];
            }
        }

        public e() {
        }

        public void a() {
            this.f2682d = null;
            this.f2681c = 0;
            this.f2679a = -1;
            this.f2680b = -1;
        }

        public void b() {
            this.f2682d = null;
            this.f2681c = 0;
            this.f2683e = 0;
            this.f2684f = null;
            this.f2685g = null;
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i2) {
            parcel.writeInt(this.f2679a);
            parcel.writeInt(this.f2680b);
            parcel.writeInt(this.f2681c);
            if (this.f2681c > 0) {
                parcel.writeIntArray(this.f2682d);
            }
            parcel.writeInt(this.f2683e);
            if (this.f2683e > 0) {
                parcel.writeIntArray(this.f2684f);
            }
            parcel.writeInt(this.f2686h ? 1 : 0);
            parcel.writeInt(this.f2687i ? 1 : 0);
            parcel.writeInt(this.j ? 1 : 0);
            parcel.writeList(this.f2685g);
        }

        public e(Parcel parcel) {
            this.f2679a = parcel.readInt();
            this.f2680b = parcel.readInt();
            this.f2681c = parcel.readInt();
            int i2 = this.f2681c;
            if (i2 > 0) {
                this.f2682d = new int[i2];
                parcel.readIntArray(this.f2682d);
            }
            this.f2683e = parcel.readInt();
            int i3 = this.f2683e;
            if (i3 > 0) {
                this.f2684f = new int[i3];
                parcel.readIntArray(this.f2684f);
            }
            this.f2686h = parcel.readInt() == 1;
            this.f2687i = parcel.readInt() == 1;
            this.j = parcel.readInt() == 1;
            this.f2685g = parcel.readArrayList(d.a.class.getClassLoader());
        }

        public e(e eVar) {
            this.f2681c = eVar.f2681c;
            this.f2679a = eVar.f2679a;
            this.f2680b = eVar.f2680b;
            this.f2682d = eVar.f2682d;
            this.f2683e = eVar.f2683e;
            this.f2684f = eVar.f2684f;
            this.f2686h = eVar.f2686h;
            this.f2687i = eVar.f2687i;
            this.j = eVar.j;
            this.f2685g = eVar.f2685g;
        }
    }

    /* loaded from: classes.dex */
    public class f {

        /* renamed from: a  reason: collision with root package name */
        public ArrayList<View> f2688a = new ArrayList<>();

        /* renamed from: b  reason: collision with root package name */
        public int f2689b = Integer.MIN_VALUE;

        /* renamed from: c  reason: collision with root package name */
        public int f2690c = Integer.MIN_VALUE;

        /* renamed from: d  reason: collision with root package name */
        public int f2691d = 0;

        /* renamed from: e  reason: collision with root package name */
        public final int f2692e;

        public f(int i2) {
            this.f2692e = i2;
        }

        public int a(int i2) {
            int i3 = this.f2690c;
            if (i3 != Integer.MIN_VALUE) {
                return i3;
            }
            if (this.f2688a.size() == 0) {
                return i2;
            }
            a();
            return this.f2690c;
        }

        public int b(int i2) {
            int i3 = this.f2689b;
            if (i3 != Integer.MIN_VALUE) {
                return i3;
            }
            if (this.f2688a.size() == 0) {
                return i2;
            }
            b();
            return this.f2689b;
        }

        public void c(View view) {
            c b2 = b(view);
            b2.f2671e = this;
            this.f2688a.add(0, view);
            this.f2689b = Integer.MIN_VALUE;
            if (this.f2688a.size() == 1) {
                this.f2690c = Integer.MIN_VALUE;
            }
            if (b2.c() || b2.b()) {
                this.f2691d += StaggeredGridLayoutManager.this.u.b(view);
            }
        }

        public void d(int i2) {
            this.f2689b = i2;
            this.f2690c = i2;
        }

        public int e() {
            if (StaggeredGridLayoutManager.this.z) {
                return a(0, this.f2688a.size(), true);
            }
            return a(this.f2688a.size() - 1, -1, true);
        }

        public int f() {
            return this.f2691d;
        }

        public int g() {
            int i2 = this.f2690c;
            if (i2 != Integer.MIN_VALUE) {
                return i2;
            }
            a();
            return this.f2690c;
        }

        public int h() {
            int i2 = this.f2689b;
            if (i2 != Integer.MIN_VALUE) {
                return i2;
            }
            b();
            return this.f2689b;
        }

        public void i() {
            this.f2689b = Integer.MIN_VALUE;
            this.f2690c = Integer.MIN_VALUE;
        }

        public void j() {
            int size = this.f2688a.size();
            View remove = this.f2688a.remove(size - 1);
            c b2 = b(remove);
            b2.f2671e = null;
            if (b2.c() || b2.b()) {
                this.f2691d -= StaggeredGridLayoutManager.this.u.b(remove);
            }
            if (size == 1) {
                this.f2689b = Integer.MIN_VALUE;
            }
            this.f2690c = Integer.MIN_VALUE;
        }

        public void k() {
            View remove = this.f2688a.remove(0);
            c b2 = b(remove);
            b2.f2671e = null;
            if (this.f2688a.size() == 0) {
                this.f2690c = Integer.MIN_VALUE;
            }
            if (b2.c() || b2.b()) {
                this.f2691d -= StaggeredGridLayoutManager.this.u.b(remove);
            }
            this.f2689b = Integer.MIN_VALUE;
        }

        public int d() {
            if (StaggeredGridLayoutManager.this.z) {
                return a(this.f2688a.size() - 1, -1, true);
            }
            return a(0, this.f2688a.size(), true);
        }

        public void a() {
            d.a c2;
            ArrayList<View> arrayList = this.f2688a;
            View view = arrayList.get(arrayList.size() - 1);
            c b2 = b(view);
            this.f2690c = StaggeredGridLayoutManager.this.u.a(view);
            if (b2.f2672f && (c2 = StaggeredGridLayoutManager.this.E.c(b2.a())) != null && c2.f2676b == 1) {
                this.f2690c += c2.a(this.f2692e);
            }
        }

        public void b() {
            d.a c2;
            View view = this.f2688a.get(0);
            c b2 = b(view);
            this.f2689b = StaggeredGridLayoutManager.this.u.d(view);
            if (b2.f2672f && (c2 = StaggeredGridLayoutManager.this.E.c(b2.a())) != null && c2.f2676b == -1) {
                this.f2689b -= c2.a(this.f2692e);
            }
        }

        public void c() {
            this.f2688a.clear();
            i();
            this.f2691d = 0;
        }

        public void c(int i2) {
            int i3 = this.f2689b;
            if (i3 != Integer.MIN_VALUE) {
                this.f2689b = i3 + i2;
            }
            int i4 = this.f2690c;
            if (i4 != Integer.MIN_VALUE) {
                this.f2690c = i4 + i2;
            }
        }

        public void a(View view) {
            c b2 = b(view);
            b2.f2671e = this;
            this.f2688a.add(view);
            this.f2690c = Integer.MIN_VALUE;
            if (this.f2688a.size() == 1) {
                this.f2689b = Integer.MIN_VALUE;
            }
            if (b2.c() || b2.b()) {
                this.f2691d += StaggeredGridLayoutManager.this.u.b(view);
            }
        }

        public c b(View view) {
            return (c) view.getLayoutParams();
        }

        public void a(boolean z, int i2) {
            int b2;
            if (z) {
                b2 = a(Integer.MIN_VALUE);
            } else {
                b2 = b(Integer.MIN_VALUE);
            }
            c();
            if (b2 == Integer.MIN_VALUE) {
                return;
            }
            if (!z || b2 >= StaggeredGridLayoutManager.this.u.b()) {
                if (z || b2 <= StaggeredGridLayoutManager.this.u.f()) {
                    if (i2 != Integer.MIN_VALUE) {
                        b2 += i2;
                    }
                    this.f2690c = b2;
                    this.f2689b = b2;
                }
            }
        }

        public int a(int i2, int i3, boolean z, boolean z2, boolean z3) {
            int f2 = StaggeredGridLayoutManager.this.u.f();
            int b2 = StaggeredGridLayoutManager.this.u.b();
            int i4 = i3 > i2 ? 1 : -1;
            while (i2 != i3) {
                View view = this.f2688a.get(i2);
                int d2 = StaggeredGridLayoutManager.this.u.d(view);
                int a2 = StaggeredGridLayoutManager.this.u.a(view);
                boolean z4 = false;
                boolean z5 = !z3 ? d2 >= b2 : d2 > b2;
                if (!z3 ? a2 > f2 : a2 >= f2) {
                    z4 = true;
                }
                if (z5 && z4) {
                    if (z && z2) {
                        if (d2 >= f2 && a2 <= b2) {
                            return StaggeredGridLayoutManager.this.l(view);
                        }
                    } else if (z2) {
                        return StaggeredGridLayoutManager.this.l(view);
                    } else {
                        if (d2 < f2 || a2 > b2) {
                            return StaggeredGridLayoutManager.this.l(view);
                        }
                    }
                }
                i2 += i4;
            }
            return -1;
        }

        public int a(int i2, int i3, boolean z) {
            return a(i2, i3, false, false, z);
        }

        public View a(int i2, int i3) {
            View view = null;
            if (i3 == -1) {
                int size = this.f2688a.size();
                int i4 = 0;
                while (i4 < size) {
                    View view2 = this.f2688a.get(i4);
                    StaggeredGridLayoutManager staggeredGridLayoutManager = StaggeredGridLayoutManager.this;
                    if (staggeredGridLayoutManager.z && staggeredGridLayoutManager.l(view2) <= i2) {
                        break;
                    }
                    StaggeredGridLayoutManager staggeredGridLayoutManager2 = StaggeredGridLayoutManager.this;
                    if ((!staggeredGridLayoutManager2.z && staggeredGridLayoutManager2.l(view2) >= i2) || !view2.hasFocusable()) {
                        break;
                    }
                    i4++;
                    view = view2;
                }
            } else {
                int size2 = this.f2688a.size() - 1;
                while (size2 >= 0) {
                    View view3 = this.f2688a.get(size2);
                    StaggeredGridLayoutManager staggeredGridLayoutManager3 = StaggeredGridLayoutManager.this;
                    if (staggeredGridLayoutManager3.z && staggeredGridLayoutManager3.l(view3) >= i2) {
                        break;
                    }
                    StaggeredGridLayoutManager staggeredGridLayoutManager4 = StaggeredGridLayoutManager.this;
                    if ((!staggeredGridLayoutManager4.z && staggeredGridLayoutManager4.l(view3) <= i2) || !view3.hasFocusable()) {
                        break;
                    }
                    size2--;
                    view = view3;
                }
            }
            return view;
        }
    }

    public StaggeredGridLayoutManager(Context context, AttributeSet attributeSet, int i2, int i3) {
        RecyclerView.o.d a2 = RecyclerView.o.a(context, attributeSet, i2, i3);
        u(a2.f2613a);
        v(a2.f2614b);
        c(a2.f2615c);
        this.y = new q0();
        G();
    }

    @Override // android.support.v7.widget.RecyclerView.o
    public boolean C() {
        return this.I == null;
    }

    public boolean D() {
        int a2 = this.t[0].a(Integer.MIN_VALUE);
        for (int i2 = 1; i2 < this.s; i2++) {
            if (this.t[i2].a(Integer.MIN_VALUE) != a2) {
                return false;
            }
        }
        return true;
    }

    public boolean E() {
        int b2 = this.t[0].b(Integer.MIN_VALUE);
        for (int i2 = 1; i2 < this.s; i2++) {
            if (this.t[i2].b(Integer.MIN_VALUE) != b2) {
                return false;
            }
        }
        return true;
    }

    public boolean F() {
        int I;
        int J;
        if (e() == 0 || this.F == 0 || !t()) {
            return false;
        }
        if (this.A) {
            I = J();
            J = I();
        } else {
            I = I();
            J = J();
        }
        if (I == 0 && K() != null) {
            this.E.a();
            z();
            y();
            return true;
        } else if (this.M) {
            int i2 = this.A ? -1 : 1;
            int i3 = J + 1;
            d.a a2 = this.E.a(I, i3, i2, true);
            if (a2 == null) {
                this.M = false;
                this.E.b(i3);
                return false;
            }
            d.a a3 = this.E.a(I, a2.f2675a, i2 * (-1), true);
            if (a3 == null) {
                this.E.b(a2.f2675a);
            } else {
                this.E.b(a3.f2675a + 1);
            }
            z();
            y();
            return true;
        } else {
            return false;
        }
    }

    public final void G() {
        this.u = w0.a(this, this.w);
        this.v = w0.a(this, 1 - this.w);
    }

    public int H() {
        View a2 = this.A ? a(true) : b(true);
        if (a2 == null) {
            return -1;
        }
        return l(a2);
    }

    public int I() {
        if (e() == 0) {
            return 0;
        }
        return l(c(0));
    }

    public int J() {
        int e2 = e();
        if (e2 == 0) {
            return 0;
        }
        return l(c(e2 - 1));
    }

    /* JADX WARN: Code restructure failed: missing block: B:31:0x0074, code lost:
        if (r10 == r11) goto L45;
     */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x0086, code lost:
        if (r10 == r11) goto L45;
     */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x0088, code lost:
        r10 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:38:0x008a, code lost:
        r10 = false;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public android.view.View K() {
        /*
            r12 = this;
            int r0 = r12.e()
            r1 = 1
            int r0 = r0 - r1
            java.util.BitSet r2 = new java.util.BitSet
            int r3 = r12.s
            r2.<init>(r3)
            int r3 = r12.s
            r4 = 0
            r2.set(r4, r3, r1)
            int r3 = r12.w
            r5 = -1
            if (r3 != r1) goto L20
            boolean r3 = r12.M()
            if (r3 == 0) goto L20
            r3 = 1
            goto L21
        L20:
            r3 = -1
        L21:
            boolean r6 = r12.A
            if (r6 == 0) goto L27
            r6 = -1
            goto L2b
        L27:
            int r0 = r0 + 1
            r6 = r0
            r0 = 0
        L2b:
            if (r0 >= r6) goto L2e
            r5 = 1
        L2e:
            if (r0 == r6) goto Lab
            android.view.View r7 = r12.c(r0)
            android.view.ViewGroup$LayoutParams r8 = r7.getLayoutParams()
            android.support.v7.widget.StaggeredGridLayoutManager$c r8 = (android.support.v7.widget.StaggeredGridLayoutManager.c) r8
            android.support.v7.widget.StaggeredGridLayoutManager$f r9 = r8.f2671e
            int r9 = r9.f2692e
            boolean r9 = r2.get(r9)
            if (r9 == 0) goto L54
            android.support.v7.widget.StaggeredGridLayoutManager$f r9 = r8.f2671e
            boolean r9 = r12.a(r9)
            if (r9 == 0) goto L4d
            return r7
        L4d:
            android.support.v7.widget.StaggeredGridLayoutManager$f r9 = r8.f2671e
            int r9 = r9.f2692e
            r2.clear(r9)
        L54:
            boolean r9 = r8.f2672f
            if (r9 == 0) goto L59
            goto La9
        L59:
            int r9 = r0 + r5
            if (r9 == r6) goto La9
            android.view.View r9 = r12.c(r9)
            boolean r10 = r12.A
            if (r10 == 0) goto L77
            a.b.h.k.w0 r10 = r12.u
            int r10 = r10.a(r7)
            a.b.h.k.w0 r11 = r12.u
            int r11 = r11.a(r9)
            if (r10 >= r11) goto L74
            return r7
        L74:
            if (r10 != r11) goto L8a
            goto L88
        L77:
            a.b.h.k.w0 r10 = r12.u
            int r10 = r10.d(r7)
            a.b.h.k.w0 r11 = r12.u
            int r11 = r11.d(r9)
            if (r10 <= r11) goto L86
            return r7
        L86:
            if (r10 != r11) goto L8a
        L88:
            r10 = 1
            goto L8b
        L8a:
            r10 = 0
        L8b:
            if (r10 == 0) goto La9
            android.view.ViewGroup$LayoutParams r9 = r9.getLayoutParams()
            android.support.v7.widget.StaggeredGridLayoutManager$c r9 = (android.support.v7.widget.StaggeredGridLayoutManager.c) r9
            android.support.v7.widget.StaggeredGridLayoutManager$f r8 = r8.f2671e
            int r8 = r8.f2692e
            android.support.v7.widget.StaggeredGridLayoutManager$f r9 = r9.f2671e
            int r9 = r9.f2692e
            int r8 = r8 - r9
            if (r8 >= 0) goto La0
            r8 = 1
            goto La1
        La0:
            r8 = 0
        La1:
            if (r3 >= 0) goto La5
            r9 = 1
            goto La6
        La5:
            r9 = 0
        La6:
            if (r8 == r9) goto La9
            return r7
        La9:
            int r0 = r0 + r5
            goto L2e
        Lab:
            r0 = 0
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v7.widget.StaggeredGridLayoutManager.K():android.view.View");
    }

    public void L() {
        this.E.a();
        y();
    }

    public boolean M() {
        return j() == 1;
    }

    public final void N() {
        if (this.v.d() == 1073741824) {
            return;
        }
        int e2 = e();
        float f2 = 0.0f;
        for (int i2 = 0; i2 < e2; i2++) {
            View c2 = c(i2);
            float b2 = this.v.b(c2);
            if (b2 >= f2) {
                if (((c) c2.getLayoutParams()).f()) {
                    b2 = (b2 * 1.0f) / this.s;
                }
                f2 = Math.max(f2, b2);
            }
        }
        int i3 = this.x;
        int round = Math.round(f2 * this.s);
        if (this.v.d() == Integer.MIN_VALUE) {
            round = Math.min(round, this.v.g());
        }
        w(round);
        if (this.x == i3) {
            return;
        }
        for (int i4 = 0; i4 < e2; i4++) {
            View c3 = c(i4);
            c cVar = (c) c3.getLayoutParams();
            if (!cVar.f2672f) {
                if (M() && this.w == 1) {
                    int i5 = this.s;
                    int i6 = cVar.f2671e.f2692e;
                    c3.offsetLeftAndRight(((-((i5 - 1) - i6)) * this.x) - ((-((i5 - 1) - i6)) * i3));
                } else {
                    int i7 = cVar.f2671e.f2692e;
                    int i8 = this.x * i7;
                    int i9 = i7 * i3;
                    if (this.w == 1) {
                        c3.offsetLeftAndRight(i8 - i9);
                    } else {
                        c3.offsetTopAndBottom(i8 - i9);
                    }
                }
            }
        }
    }

    public final void O() {
        if (this.w != 1 && M()) {
            this.A = !this.z;
        } else {
            this.A = this.z;
        }
    }

    public final boolean a(f fVar) {
        if (this.A) {
            if (fVar.g() < this.u.b()) {
                ArrayList<View> arrayList = fVar.f2688a;
                return !fVar.b(arrayList.get(arrayList.size() - 1)).f2672f;
            }
        } else if (fVar.h() > this.u.f()) {
            return !fVar.b(fVar.f2688a.get(0)).f2672f;
        }
        return false;
    }

    @Override // android.support.v7.widget.RecyclerView.o
    public void b(RecyclerView recyclerView, RecyclerView.v vVar) {
        super.b(recyclerView, vVar);
        a(this.P);
        for (int i2 = 0; i2 < this.s; i2++) {
            this.t[i2].c();
        }
        recyclerView.requestLayout();
    }

    public void c(boolean z) {
        a((String) null);
        e eVar = this.I;
        if (eVar != null && eVar.f2686h != z) {
            eVar.f2686h = z;
        }
        this.z = z;
        y();
    }

    @Override // android.support.v7.widget.RecyclerView.o
    public int d(RecyclerView.a0 a0Var) {
        return h(a0Var);
    }

    @Override // android.support.v7.widget.RecyclerView.o
    public void e(RecyclerView.v vVar, RecyclerView.a0 a0Var) {
        c(vVar, a0Var, true);
    }

    @Override // android.support.v7.widget.RecyclerView.o
    public void f(int i2) {
        if (i2 == 0) {
            F();
        }
    }

    @Override // android.support.v7.widget.RecyclerView.o
    public void g(RecyclerView.a0 a0Var) {
        super.g(a0Var);
        this.C = -1;
        this.D = Integer.MIN_VALUE;
        this.I = null;
        this.L.b();
    }

    public final int h(RecyclerView.a0 a0Var) {
        if (e() == 0) {
            return 0;
        }
        return c1.a(a0Var, this.u, b(!this.N), a(!this.N), this, this.N);
    }

    public final int i(RecyclerView.a0 a0Var) {
        if (e() == 0) {
            return 0;
        }
        return c1.a(a0Var, this.u, b(!this.N), a(!this.N), this, this.N, this.A);
    }

    public final int j(RecyclerView.a0 a0Var) {
        if (e() == 0) {
            return 0;
        }
        return c1.b(a0Var, this.u, b(!this.N), a(!this.N), this, this.N);
    }

    public final d.a k(int i2) {
        d.a aVar = new d.a();
        aVar.f2677c = new int[this.s];
        for (int i3 = 0; i3 < this.s; i3++) {
            aVar.f2677c[i3] = i2 - this.t[i3].a(i2);
        }
        return aVar;
    }

    public final d.a l(int i2) {
        d.a aVar = new d.a();
        aVar.f2677c = new int[this.s];
        for (int i3 = 0; i3 < this.s; i3++) {
            aVar.f2677c[i3] = this.t[i3].b(i2) - i2;
        }
        return aVar;
    }

    public final int m(int i2) {
        int e2 = e();
        for (int i3 = 0; i3 < e2; i3++) {
            int l = l(c(i3));
            if (l >= 0 && l < i2) {
                return l;
            }
        }
        return 0;
    }

    public final int n(int i2) {
        for (int e2 = e() - 1; e2 >= 0; e2--) {
            int l = l(c(e2));
            if (l >= 0 && l < i2) {
                return l;
            }
        }
        return 0;
    }

    public final int o(int i2) {
        int a2 = this.t[0].a(i2);
        for (int i3 = 1; i3 < this.s; i3++) {
            int a3 = this.t[i3].a(i2);
            if (a3 > a2) {
                a2 = a3;
            }
        }
        return a2;
    }

    public final void p(View view) {
        for (int i2 = this.s - 1; i2 >= 0; i2--) {
            this.t[i2].a(view);
        }
    }

    public final void q(View view) {
        for (int i2 = this.s - 1; i2 >= 0; i2--) {
            this.t[i2].c(view);
        }
    }

    public final int r(int i2) {
        int b2 = this.t[0].b(i2);
        for (int i3 = 1; i3 < this.s; i3++) {
            int b3 = this.t[i3].b(i2);
            if (b3 < b2) {
                b2 = b3;
            }
        }
        return b2;
    }

    public final boolean s(int i2) {
        if (this.w == 0) {
            return (i2 == -1) != this.A;
        }
        return ((i2 == -1) == this.A) == M();
    }

    public final void t(int i2) {
        q0 q0Var = this.y;
        q0Var.f1911e = i2;
        q0Var.f1910d = this.A != (i2 == -1) ? -1 : 1;
    }

    @Override // android.support.v7.widget.RecyclerView.o
    public boolean u() {
        return this.F != 0;
    }

    public void v(int i2) {
        a((String) null);
        if (i2 != this.s) {
            L();
            this.s = i2;
            this.B = new BitSet(this.s);
            this.t = new f[this.s];
            for (int i3 = 0; i3 < this.s; i3++) {
                this.t[i3] = new f(i3);
            }
            y();
        }
    }

    public void w(int i2) {
        this.x = i2 / this.s;
        this.J = View.MeasureSpec.makeMeasureSpec(i2, this.v.d());
    }

    @Override // android.support.v7.widget.RecyclerView.o
    public Parcelable x() {
        int b2;
        int f2;
        int[] iArr;
        e eVar = this.I;
        if (eVar != null) {
            return new e(eVar);
        }
        e eVar2 = new e();
        eVar2.f2686h = this.z;
        eVar2.f2687i = this.G;
        eVar2.j = this.H;
        d dVar = this.E;
        if (dVar != null && (iArr = dVar.f2673a) != null) {
            eVar2.f2684f = iArr;
            eVar2.f2683e = eVar2.f2684f.length;
            eVar2.f2685g = dVar.f2674b;
        } else {
            eVar2.f2683e = 0;
        }
        if (e() > 0) {
            eVar2.f2679a = this.G ? J() : I();
            eVar2.f2680b = H();
            int i2 = this.s;
            eVar2.f2681c = i2;
            eVar2.f2682d = new int[i2];
            for (int i3 = 0; i3 < this.s; i3++) {
                if (this.G) {
                    b2 = this.t[i3].a(Integer.MIN_VALUE);
                    if (b2 != Integer.MIN_VALUE) {
                        f2 = this.u.b();
                        b2 -= f2;
                        eVar2.f2682d[i3] = b2;
                    } else {
                        eVar2.f2682d[i3] = b2;
                    }
                } else {
                    b2 = this.t[i3].b(Integer.MIN_VALUE);
                    if (b2 != Integer.MIN_VALUE) {
                        f2 = this.u.f();
                        b2 -= f2;
                        eVar2.f2682d[i3] = b2;
                    } else {
                        eVar2.f2682d[i3] = b2;
                    }
                }
            }
        } else {
            eVar2.f2679a = -1;
            eVar2.f2680b = -1;
            eVar2.f2681c = 0;
        }
        return eVar2;
    }

    /* loaded from: classes.dex */
    public static class d {

        /* renamed from: a  reason: collision with root package name */
        public int[] f2673a;

        /* renamed from: b  reason: collision with root package name */
        public List<a> f2674b;

        public void a(int i2, f fVar) {
            a(i2);
            this.f2673a[i2] = fVar.f2692e;
        }

        public int b(int i2) {
            List<a> list = this.f2674b;
            if (list != null) {
                for (int size = list.size() - 1; size >= 0; size--) {
                    if (this.f2674b.get(size).f2675a >= i2) {
                        this.f2674b.remove(size);
                    }
                }
            }
            return e(i2);
        }

        public final void c(int i2, int i3) {
            List<a> list = this.f2674b;
            if (list == null) {
                return;
            }
            for (int size = list.size() - 1; size >= 0; size--) {
                a aVar = this.f2674b.get(size);
                int i4 = aVar.f2675a;
                if (i4 >= i2) {
                    aVar.f2675a = i4 + i3;
                }
            }
        }

        public int d(int i2) {
            int[] iArr = this.f2673a;
            if (iArr == null || i2 >= iArr.length) {
                return -1;
            }
            return iArr[i2];
        }

        public int e(int i2) {
            int[] iArr = this.f2673a;
            if (iArr != null && i2 < iArr.length) {
                int f2 = f(i2);
                if (f2 == -1) {
                    int[] iArr2 = this.f2673a;
                    Arrays.fill(iArr2, i2, iArr2.length, -1);
                    return this.f2673a.length;
                }
                int i3 = f2 + 1;
                Arrays.fill(this.f2673a, i2, i3, -1);
                return i3;
            }
            return -1;
        }

        public final int f(int i2) {
            if (this.f2674b == null) {
                return -1;
            }
            a c2 = c(i2);
            if (c2 != null) {
                this.f2674b.remove(c2);
            }
            int size = this.f2674b.size();
            int i3 = 0;
            while (true) {
                if (i3 >= size) {
                    i3 = -1;
                    break;
                } else if (this.f2674b.get(i3).f2675a >= i2) {
                    break;
                } else {
                    i3++;
                }
            }
            if (i3 != -1) {
                this.f2674b.remove(i3);
                return this.f2674b.get(i3).f2675a;
            }
            return -1;
        }

        public int g(int i2) {
            int length = this.f2673a.length;
            while (length <= i2) {
                length *= 2;
            }
            return length;
        }

        public void a(int i2) {
            int[] iArr = this.f2673a;
            if (iArr == null) {
                this.f2673a = new int[Math.max(i2, 10) + 1];
                Arrays.fill(this.f2673a, -1);
            } else if (i2 >= iArr.length) {
                this.f2673a = new int[g(i2)];
                System.arraycopy(iArr, 0, this.f2673a, 0, iArr.length);
                int[] iArr2 = this.f2673a;
                Arrays.fill(iArr2, iArr.length, iArr2.length, -1);
            }
        }

        public final void d(int i2, int i3) {
            List<a> list = this.f2674b;
            if (list == null) {
                return;
            }
            int i4 = i2 + i3;
            for (int size = list.size() - 1; size >= 0; size--) {
                a aVar = this.f2674b.get(size);
                int i5 = aVar.f2675a;
                if (i5 >= i2) {
                    if (i5 < i4) {
                        this.f2674b.remove(size);
                    } else {
                        aVar.f2675a = i5 - i3;
                    }
                }
            }
        }

        public a c(int i2) {
            List<a> list = this.f2674b;
            if (list == null) {
                return null;
            }
            for (int size = list.size() - 1; size >= 0; size--) {
                a aVar = this.f2674b.get(size);
                if (aVar.f2675a == i2) {
                    return aVar;
                }
            }
            return null;
        }

        /* loaded from: classes.dex */
        public static class a implements Parcelable {
            public static final Parcelable.Creator<a> CREATOR = new C0050a();

            /* renamed from: a  reason: collision with root package name */
            public int f2675a;

            /* renamed from: b  reason: collision with root package name */
            public int f2676b;

            /* renamed from: c  reason: collision with root package name */
            public int[] f2677c;

            /* renamed from: d  reason: collision with root package name */
            public boolean f2678d;

            /* renamed from: android.support.v7.widget.StaggeredGridLayoutManager$d$a$a  reason: collision with other inner class name */
            /* loaded from: classes.dex */
            public static class C0050a implements Parcelable.Creator<a> {
                /* JADX WARN: Can't rename method to resolve collision */
                @Override // android.os.Parcelable.Creator
                public a createFromParcel(Parcel parcel) {
                    return new a(parcel);
                }

                /* JADX WARN: Can't rename method to resolve collision */
                @Override // android.os.Parcelable.Creator
                public a[] newArray(int i2) {
                    return new a[i2];
                }
            }

            public a(Parcel parcel) {
                this.f2675a = parcel.readInt();
                this.f2676b = parcel.readInt();
                this.f2678d = parcel.readInt() == 1;
                int readInt = parcel.readInt();
                if (readInt > 0) {
                    this.f2677c = new int[readInt];
                    parcel.readIntArray(this.f2677c);
                }
            }

            public int a(int i2) {
                int[] iArr = this.f2677c;
                if (iArr == null) {
                    return 0;
                }
                return iArr[i2];
            }

            @Override // android.os.Parcelable
            public int describeContents() {
                return 0;
            }

            public String toString() {
                return "FullSpanItem{mPosition=" + this.f2675a + ", mGapDir=" + this.f2676b + ", mHasUnwantedGapAfter=" + this.f2678d + ", mGapPerSpan=" + Arrays.toString(this.f2677c) + '}';
            }

            @Override // android.os.Parcelable
            public void writeToParcel(Parcel parcel, int i2) {
                parcel.writeInt(this.f2675a);
                parcel.writeInt(this.f2676b);
                parcel.writeInt(this.f2678d ? 1 : 0);
                int[] iArr = this.f2677c;
                if (iArr != null && iArr.length > 0) {
                    parcel.writeInt(iArr.length);
                    parcel.writeIntArray(this.f2677c);
                    return;
                }
                parcel.writeInt(0);
            }

            public a() {
            }
        }

        public void b(int i2, int i3) {
            int[] iArr = this.f2673a;
            if (iArr == null || i2 >= iArr.length) {
                return;
            }
            int i4 = i2 + i3;
            a(i4);
            int[] iArr2 = this.f2673a;
            System.arraycopy(iArr2, i4, iArr2, i2, (iArr2.length - i2) - i3);
            int[] iArr3 = this.f2673a;
            Arrays.fill(iArr3, iArr3.length - i3, iArr3.length, -1);
            d(i2, i3);
        }

        public void a() {
            int[] iArr = this.f2673a;
            if (iArr != null) {
                Arrays.fill(iArr, -1);
            }
            this.f2674b = null;
        }

        public void a(int i2, int i3) {
            int[] iArr = this.f2673a;
            if (iArr == null || i2 >= iArr.length) {
                return;
            }
            int i4 = i2 + i3;
            a(i4);
            int[] iArr2 = this.f2673a;
            System.arraycopy(iArr2, i2, iArr2, i4, (iArr2.length - i2) - i3);
            Arrays.fill(this.f2673a, i2, i4, -1);
            c(i2, i3);
        }

        public void a(a aVar) {
            if (this.f2674b == null) {
                this.f2674b = new ArrayList();
            }
            int size = this.f2674b.size();
            for (int i2 = 0; i2 < size; i2++) {
                a aVar2 = this.f2674b.get(i2);
                if (aVar2.f2675a == aVar.f2675a) {
                    this.f2674b.remove(i2);
                }
                if (aVar2.f2675a >= aVar.f2675a) {
                    this.f2674b.add(i2, aVar);
                    return;
                }
            }
            this.f2674b.add(aVar);
        }

        public a a(int i2, int i3, int i4, boolean z) {
            List<a> list = this.f2674b;
            if (list == null) {
                return null;
            }
            int size = list.size();
            for (int i5 = 0; i5 < size; i5++) {
                a aVar = this.f2674b.get(i5);
                int i6 = aVar.f2675a;
                if (i6 >= i3) {
                    return null;
                }
                if (i6 >= i2 && (i4 == 0 || aVar.f2676b == i4 || (z && aVar.f2678d))) {
                    return aVar;
                }
            }
            return null;
        }
    }

    public final int d(int i2, int i3, int i4) {
        if (i3 == 0 && i4 == 0) {
            return i2;
        }
        int mode = View.MeasureSpec.getMode(i2);
        return (mode == Integer.MIN_VALUE || mode == 1073741824) ? View.MeasureSpec.makeMeasureSpec(Math.max(0, (View.MeasureSpec.getSize(i2) - i3) - i4), mode) : i2;
    }

    @Override // android.support.v7.widget.RecyclerView.o
    public int e(RecyclerView.a0 a0Var) {
        return i(a0Var);
    }

    @Override // android.support.v7.widget.RecyclerView.o
    public int f(RecyclerView.a0 a0Var) {
        return j(a0Var);
    }

    public void u(int i2) {
        if (i2 != 0 && i2 != 1) {
            throw new IllegalArgumentException("invalid orientation.");
        }
        a((String) null);
        if (i2 == this.w) {
            return;
        }
        this.w = i2;
        w0 w0Var = this.u;
        this.u = this.v;
        this.v = w0Var;
        y();
    }

    @Override // android.support.v7.widget.RecyclerView.o
    public void e(int i2) {
        super.e(i2);
        for (int i3 = 0; i3 < this.s; i3++) {
            this.t[i3].c(i2);
        }
    }

    public final int p(int i2) {
        int b2 = this.t[0].b(i2);
        for (int i3 = 1; i3 < this.s; i3++) {
            int b3 = this.t[i3].b(i2);
            if (b3 > b2) {
                b2 = b3;
            }
        }
        return b2;
    }

    public final int q(int i2) {
        int a2 = this.t[0].a(i2);
        for (int i3 = 1; i3 < this.s; i3++) {
            int a3 = this.t[i3].a(i2);
            if (a3 < a2) {
                a2 = a3;
            }
        }
        return a2;
    }

    /* loaded from: classes.dex */
    public class b {

        /* renamed from: a  reason: collision with root package name */
        public int f2664a;

        /* renamed from: b  reason: collision with root package name */
        public int f2665b;

        /* renamed from: c  reason: collision with root package name */
        public boolean f2666c;

        /* renamed from: d  reason: collision with root package name */
        public boolean f2667d;

        /* renamed from: e  reason: collision with root package name */
        public boolean f2668e;

        /* renamed from: f  reason: collision with root package name */
        public int[] f2669f;

        public b() {
            b();
        }

        public void a(f[] fVarArr) {
            int length = fVarArr.length;
            int[] iArr = this.f2669f;
            if (iArr == null || iArr.length < length) {
                this.f2669f = new int[StaggeredGridLayoutManager.this.t.length];
            }
            for (int i2 = 0; i2 < length; i2++) {
                this.f2669f[i2] = fVarArr[i2].b(Integer.MIN_VALUE);
            }
        }

        public void b() {
            this.f2664a = -1;
            this.f2665b = Integer.MIN_VALUE;
            this.f2666c = false;
            this.f2667d = false;
            this.f2668e = false;
            int[] iArr = this.f2669f;
            if (iArr != null) {
                Arrays.fill(iArr, -1);
            }
        }

        public void a() {
            this.f2665b = this.f2666c ? StaggeredGridLayoutManager.this.u.b() : StaggeredGridLayoutManager.this.u.f();
        }

        public void a(int i2) {
            if (this.f2666c) {
                this.f2665b = StaggeredGridLayoutManager.this.u.b() - i2;
            } else {
                this.f2665b = StaggeredGridLayoutManager.this.u.f() + i2;
            }
        }
    }

    @Override // android.support.v7.widget.RecyclerView.o
    public void d(int i2) {
        super.d(i2);
        for (int i3 = 0; i3 < this.s; i3++) {
            this.t[i3].c(i2);
        }
    }

    public boolean b(RecyclerView.a0 a0Var, b bVar) {
        int i2;
        int f2;
        if (!a0Var.d() && (i2 = this.C) != -1) {
            if (i2 >= 0 && i2 < a0Var.a()) {
                e eVar = this.I;
                if (eVar != null && eVar.f2679a != -1 && eVar.f2681c >= 1) {
                    bVar.f2665b = Integer.MIN_VALUE;
                    bVar.f2664a = this.C;
                } else {
                    View b2 = b(this.C);
                    if (b2 != null) {
                        bVar.f2664a = this.A ? J() : I();
                        if (this.D != Integer.MIN_VALUE) {
                            if (bVar.f2666c) {
                                bVar.f2665b = (this.u.b() - this.D) - this.u.a(b2);
                            } else {
                                bVar.f2665b = (this.u.f() + this.D) - this.u.d(b2);
                            }
                            return true;
                        } else if (this.u.b(b2) > this.u.g()) {
                            if (bVar.f2666c) {
                                f2 = this.u.b();
                            } else {
                                f2 = this.u.f();
                            }
                            bVar.f2665b = f2;
                            return true;
                        } else {
                            int d2 = this.u.d(b2) - this.u.f();
                            if (d2 < 0) {
                                bVar.f2665b = -d2;
                                return true;
                            }
                            int b3 = this.u.b() - this.u.a(b2);
                            if (b3 < 0) {
                                bVar.f2665b = b3;
                                return true;
                            }
                            bVar.f2665b = Integer.MIN_VALUE;
                        }
                    } else {
                        bVar.f2664a = this.C;
                        int i3 = this.D;
                        if (i3 == Integer.MIN_VALUE) {
                            bVar.f2666c = i(bVar.f2664a) == 1;
                            bVar.a();
                        } else {
                            bVar.a(i3);
                        }
                        bVar.f2667d = true;
                    }
                }
                return true;
            }
            this.C = -1;
            this.D = Integer.MIN_VALUE;
        }
        return false;
    }

    /* JADX WARN: Code restructure failed: missing block: B:87:0x0157, code lost:
        if (F() != false) goto L83;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void c(android.support.v7.widget.RecyclerView.v r9, android.support.v7.widget.RecyclerView.a0 r10, boolean r11) {
        /*
            Method dump skipped, instructions count: 379
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v7.widget.StaggeredGridLayoutManager.c(android.support.v7.widget.RecyclerView$v, android.support.v7.widget.RecyclerView$a0, boolean):void");
    }

    public final void e(int i2, int i3) {
        for (int i4 = 0; i4 < this.s; i4++) {
            if (!this.t[i4].f2688a.isEmpty()) {
                a(this.t[i4], i2, i3);
            }
        }
    }

    @Override // android.support.v7.widget.RecyclerView.o
    public void h(int i2) {
        e eVar = this.I;
        if (eVar != null && eVar.f2679a != i2) {
            eVar.a();
        }
        this.C = i2;
        this.D = Integer.MIN_VALUE;
        y();
    }

    public final int i(int i2) {
        if (e() == 0) {
            return this.A ? 1 : -1;
        }
        return (i2 < I()) != this.A ? -1 : 1;
    }

    public final int j(int i2) {
        return i2 != 1 ? i2 != 2 ? i2 != 17 ? i2 != 33 ? i2 != 66 ? (i2 == 130 && this.w == 1) ? 1 : Integer.MIN_VALUE : this.w == 0 ? 1 : Integer.MIN_VALUE : this.w == 1 ? -1 : Integer.MIN_VALUE : this.w == 0 ? -1 : Integer.MIN_VALUE : (this.w != 1 && M()) ? -1 : 1 : (this.w != 1 && M()) ? 1 : -1;
    }

    @Override // android.support.v7.widget.RecyclerView.o
    public void d(RecyclerView recyclerView) {
        this.E.a();
        y();
    }

    @Override // android.support.v7.widget.RecyclerView.o
    public void a(String str) {
        if (this.I == null) {
            super.a(str);
        }
    }

    @Override // android.support.v7.widget.RecyclerView.o
    public void a(Rect rect, int i2, int i3) {
        int a2;
        int a3;
        int n = n() + o();
        int p = p() + m();
        if (this.w == 1) {
            a3 = RecyclerView.o.a(i3, rect.height() + p, k());
            a2 = RecyclerView.o.a(i2, (this.x * this.s) + n, l());
        } else {
            a2 = RecyclerView.o.a(i2, rect.width() + n, l());
            a3 = RecyclerView.o.a(i3, (this.x * this.s) + p, k());
        }
        c(a2, a3);
    }

    public final void a(b bVar) {
        int f2;
        e eVar = this.I;
        int i2 = eVar.f2681c;
        if (i2 > 0) {
            if (i2 == this.s) {
                for (int i3 = 0; i3 < this.s; i3++) {
                    this.t[i3].c();
                    e eVar2 = this.I;
                    int i4 = eVar2.f2682d[i3];
                    if (i4 != Integer.MIN_VALUE) {
                        if (eVar2.f2687i) {
                            f2 = this.u.b();
                        } else {
                            f2 = this.u.f();
                        }
                        i4 += f2;
                    }
                    this.t[i3].d(i4);
                }
            } else {
                eVar.b();
                e eVar3 = this.I;
                eVar3.f2679a = eVar3.f2680b;
            }
        }
        e eVar4 = this.I;
        this.H = eVar4.j;
        c(eVar4.f2686h);
        O();
        e eVar5 = this.I;
        int i5 = eVar5.f2679a;
        if (i5 != -1) {
            this.C = i5;
            bVar.f2666c = eVar5.f2687i;
        } else {
            bVar.f2666c = this.A;
        }
        e eVar6 = this.I;
        if (eVar6.f2683e > 1) {
            d dVar = this.E;
            dVar.f2673a = eVar6.f2684f;
            dVar.f2674b = eVar6.f2685g;
        }
    }

    @Override // android.support.v7.widget.RecyclerView.o
    public int b(RecyclerView.a0 a0Var) {
        return i(a0Var);
    }

    @Override // android.support.v7.widget.RecyclerView.o
    public int b(RecyclerView.v vVar, RecyclerView.a0 a0Var) {
        if (this.w == 0) {
            return this.s;
        }
        return super.b(vVar, a0Var);
    }

    public View b(boolean z) {
        int f2 = this.u.f();
        int b2 = this.u.b();
        int e2 = e();
        View view = null;
        for (int i2 = 0; i2 < e2; i2++) {
            View c2 = c(i2);
            int d2 = this.u.d(c2);
            if (this.u.a(c2) > f2 && d2 < b2) {
                if (d2 >= f2 || !z) {
                    return c2;
                }
                if (view == null) {
                    view = c2;
                }
            }
        }
        return view;
    }

    public final boolean a(RecyclerView.a0 a0Var, b bVar) {
        int m;
        if (this.G) {
            m = n(a0Var.a());
        } else {
            m = m(a0Var.a());
        }
        bVar.f2664a = m;
        bVar.f2665b = Integer.MIN_VALUE;
        return true;
    }

    @Override // android.support.v7.widget.RecyclerView.o
    public int a(RecyclerView.a0 a0Var) {
        return h(a0Var);
    }

    public final void b(RecyclerView.v vVar, RecyclerView.a0 a0Var, boolean z) {
        int f2;
        int r = r(Integer.MAX_VALUE);
        if (r != Integer.MAX_VALUE && (f2 = r - this.u.f()) > 0) {
            int c2 = f2 - c(f2, vVar, a0Var);
            if (!z || c2 <= 0) {
                return;
            }
            this.u.a(-c2);
        }
    }

    public final void a(View view, c cVar, boolean z) {
        if (cVar.f2672f) {
            if (this.w == 1) {
                a(view, this.J, RecyclerView.o.a(h(), i(), p() + m(), ((ViewGroup.MarginLayoutParams) cVar).height, true), z);
            } else {
                a(view, RecyclerView.o.a(q(), r(), n() + o(), ((ViewGroup.MarginLayoutParams) cVar).width, true), this.J, z);
            }
        } else if (this.w == 1) {
            a(view, RecyclerView.o.a(this.x, r(), 0, ((ViewGroup.MarginLayoutParams) cVar).width, false), RecyclerView.o.a(h(), i(), p() + m(), ((ViewGroup.MarginLayoutParams) cVar).height, true), z);
        } else {
            a(view, RecyclerView.o.a(q(), r(), n() + o(), ((ViewGroup.MarginLayoutParams) cVar).width, true), RecyclerView.o.a(this.x, i(), 0, ((ViewGroup.MarginLayoutParams) cVar).height, false), z);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x0036  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x004d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void b(int r5, android.support.v7.widget.RecyclerView.a0 r6) {
        /*
            r4 = this;
            a.b.h.k.q0 r0 = r4.y
            r1 = 0
            r0.f1908b = r1
            r0.f1909c = r5
            boolean r0 = r4.w()
            r2 = 1
            if (r0 == 0) goto L2e
            int r6 = r6.b()
            r0 = -1
            if (r6 == r0) goto L2e
            boolean r0 = r4.A
            if (r6 >= r5) goto L1b
            r5 = 1
            goto L1c
        L1b:
            r5 = 0
        L1c:
            if (r0 != r5) goto L25
            a.b.h.k.w0 r5 = r4.u
            int r5 = r5.g()
            goto L2f
        L25:
            a.b.h.k.w0 r5 = r4.u
            int r5 = r5.g()
            r6 = r5
            r5 = 0
            goto L30
        L2e:
            r5 = 0
        L2f:
            r6 = 0
        L30:
            boolean r0 = r4.f()
            if (r0 == 0) goto L4d
            a.b.h.k.q0 r0 = r4.y
            a.b.h.k.w0 r3 = r4.u
            int r3 = r3.f()
            int r3 = r3 - r6
            r0.f1912f = r3
            a.b.h.k.q0 r6 = r4.y
            a.b.h.k.w0 r0 = r4.u
            int r0 = r0.b()
            int r0 = r0 + r5
            r6.f1913g = r0
            goto L5d
        L4d:
            a.b.h.k.q0 r0 = r4.y
            a.b.h.k.w0 r3 = r4.u
            int r3 = r3.a()
            int r3 = r3 + r5
            r0.f1913g = r3
            a.b.h.k.q0 r5 = r4.y
            int r6 = -r6
            r5.f1912f = r6
        L5d:
            a.b.h.k.q0 r5 = r4.y
            r5.f1914h = r1
            r5.f1907a = r2
            a.b.h.k.w0 r6 = r4.u
            int r6 = r6.d()
            if (r6 != 0) goto L74
            a.b.h.k.w0 r6 = r4.u
            int r6 = r6.a()
            if (r6 != 0) goto L74
            r1 = 1
        L74:
            r5.f1915i = r1
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v7.widget.StaggeredGridLayoutManager.b(int, android.support.v7.widget.RecyclerView$a0):void");
    }

    @Override // android.support.v7.widget.RecyclerView.o
    public void b(RecyclerView recyclerView, int i2, int i3) {
        c(i2, i3, 1);
    }

    public final void b(RecyclerView.v vVar, int i2) {
        while (e() > 0) {
            View c2 = c(0);
            if (this.u.a(c2) > i2 || this.u.e(c2) > i2) {
                return;
            }
            c cVar = (c) c2.getLayoutParams();
            if (cVar.f2672f) {
                for (int i3 = 0; i3 < this.s; i3++) {
                    if (this.t[i3].f2688a.size() == 1) {
                        return;
                    }
                }
                for (int i4 = 0; i4 < this.s; i4++) {
                    this.t[i4].k();
                }
            } else if (cVar.f2671e.f2688a.size() == 1) {
                return;
            } else {
                cVar.f2671e.k();
            }
            a(c2, vVar);
        }
    }

    public void c(RecyclerView.a0 a0Var, b bVar) {
        if (b(a0Var, bVar) || a(a0Var, bVar)) {
            return;
        }
        bVar.a();
        bVar.f2664a = 0;
    }

    @Override // android.support.v7.widget.RecyclerView.o
    public int c(RecyclerView.a0 a0Var) {
        return j(a0Var);
    }

    @Override // android.support.v7.widget.RecyclerView.o
    public void c(RecyclerView recyclerView, int i2, int i3) {
        c(i2, i3, 2);
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0027  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x003e  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0045 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0046  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void c(int r7, int r8, int r9) {
        /*
            r6 = this;
            boolean r0 = r6.A
            if (r0 == 0) goto L9
            int r0 = r6.J()
            goto Ld
        L9:
            int r0 = r6.I()
        Ld:
            r1 = 8
            if (r9 != r1) goto L1b
            if (r7 >= r8) goto L16
            int r2 = r8 + 1
            goto L1d
        L16:
            int r2 = r7 + 1
            r3 = r2
            r2 = r8
            goto L1f
        L1b:
            int r2 = r7 + r8
        L1d:
            r3 = r2
            r2 = r7
        L1f:
            android.support.v7.widget.StaggeredGridLayoutManager$d r4 = r6.E
            r4.e(r2)
            r4 = 1
            if (r9 == r4) goto L3e
            r5 = 2
            if (r9 == r5) goto L38
            if (r9 == r1) goto L2d
            goto L43
        L2d:
            android.support.v7.widget.StaggeredGridLayoutManager$d r9 = r6.E
            r9.b(r7, r4)
            android.support.v7.widget.StaggeredGridLayoutManager$d r7 = r6.E
            r7.a(r8, r4)
            goto L43
        L38:
            android.support.v7.widget.StaggeredGridLayoutManager$d r9 = r6.E
            r9.b(r7, r8)
            goto L43
        L3e:
            android.support.v7.widget.StaggeredGridLayoutManager$d r9 = r6.E
            r9.a(r7, r8)
        L43:
            if (r3 > r0) goto L46
            return
        L46:
            boolean r7 = r6.A
            if (r7 == 0) goto L4f
            int r7 = r6.I()
            goto L53
        L4f:
            int r7 = r6.J()
        L53:
            if (r2 > r7) goto L58
            r6.y()
        L58:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v7.widget.StaggeredGridLayoutManager.c(int, int, int):void");
    }

    public final void a(View view, int i2, int i3, boolean z) {
        boolean a2;
        a(view, this.K);
        c cVar = (c) view.getLayoutParams();
        int i4 = ((ViewGroup.MarginLayoutParams) cVar).leftMargin;
        Rect rect = this.K;
        int d2 = d(i2, i4 + rect.left, ((ViewGroup.MarginLayoutParams) cVar).rightMargin + rect.right);
        int i5 = ((ViewGroup.MarginLayoutParams) cVar).topMargin;
        Rect rect2 = this.K;
        int d3 = d(i3, i5 + rect2.top, ((ViewGroup.MarginLayoutParams) cVar).bottomMargin + rect2.bottom);
        if (z) {
            a2 = b(view, d2, d3, cVar);
        } else {
            a2 = a(view, d2, d3, cVar);
        }
        if (a2) {
            view.measure(d2, d3);
        }
    }

    @Override // android.support.v7.widget.RecyclerView.o
    public boolean b() {
        return this.w == 1;
    }

    @Override // android.support.v7.widget.RecyclerView.o
    public int b(int i2, RecyclerView.v vVar, RecyclerView.a0 a0Var) {
        return c(i2, vVar, a0Var);
    }

    public int c(int i2, RecyclerView.v vVar, RecyclerView.a0 a0Var) {
        if (e() == 0 || i2 == 0) {
            return 0;
        }
        a(i2, a0Var);
        int a2 = a(vVar, this.y, a0Var);
        if (this.y.f1908b >= a2) {
            i2 = i2 < 0 ? -a2 : a2;
        }
        this.u.a(-i2);
        this.G = this.A;
        q0 q0Var = this.y;
        q0Var.f1908b = 0;
        a(vVar, q0Var);
        return i2;
    }

    @Override // android.support.v7.widget.RecyclerView.o
    public void a(Parcelable parcelable) {
        if (parcelable instanceof e) {
            this.I = (e) parcelable;
            y();
        }
    }

    @Override // android.support.v7.widget.RecyclerView.o
    public void a(RecyclerView.v vVar, RecyclerView.a0 a0Var, View view, a.b.g.k.e0.c cVar) {
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (!(layoutParams instanceof c)) {
            super.a(view, cVar);
            return;
        }
        c cVar2 = (c) layoutParams;
        if (this.w == 0) {
            cVar.b(c.b.a(cVar2.e(), cVar2.f2672f ? this.s : 1, -1, -1, cVar2.f2672f, false));
        } else {
            cVar.b(c.b.a(-1, -1, cVar2.e(), cVar2.f2672f ? this.s : 1, cVar2.f2672f, false));
        }
    }

    @Override // android.support.v7.widget.RecyclerView.o
    public RecyclerView.p c() {
        if (this.w == 0) {
            return new c(-2, -1);
        }
        return new c(-1, -2);
    }

    @Override // android.support.v7.widget.RecyclerView.o
    public void a(AccessibilityEvent accessibilityEvent) {
        super.a(accessibilityEvent);
        if (e() > 0) {
            View b2 = b(false);
            View a2 = a(false);
            if (b2 == null || a2 == null) {
                return;
            }
            int l = l(b2);
            int l2 = l(a2);
            if (l < l2) {
                accessibilityEvent.setFromIndex(l);
                accessibilityEvent.setToIndex(l2);
                return;
            }
            accessibilityEvent.setFromIndex(l2);
            accessibilityEvent.setToIndex(l);
        }
    }

    @Override // android.support.v7.widget.RecyclerView.o
    public int a(RecyclerView.v vVar, RecyclerView.a0 a0Var) {
        if (this.w == 1) {
            return this.s;
        }
        return super.a(vVar, a0Var);
    }

    public View a(boolean z) {
        int f2 = this.u.f();
        int b2 = this.u.b();
        View view = null;
        for (int e2 = e() - 1; e2 >= 0; e2--) {
            View c2 = c(e2);
            int d2 = this.u.d(c2);
            int a2 = this.u.a(c2);
            if (a2 > f2 && d2 < b2) {
                if (a2 <= b2 || !z) {
                    return c2;
                }
                if (view == null) {
                    view = c2;
                }
            }
        }
        return view;
    }

    public final void a(RecyclerView.v vVar, RecyclerView.a0 a0Var, boolean z) {
        int b2;
        int o = o(Integer.MIN_VALUE);
        if (o != Integer.MIN_VALUE && (b2 = this.u.b() - o) > 0) {
            int i2 = b2 - (-c(-b2, vVar, a0Var));
            if (!z || i2 <= 0) {
                return;
            }
            this.u.a(i2);
        }
    }

    @Override // android.support.v7.widget.RecyclerView.o
    public void a(RecyclerView recyclerView, int i2, int i3, int i4) {
        c(i2, i3, 8);
    }

    @Override // android.support.v7.widget.RecyclerView.o
    public void a(RecyclerView recyclerView, int i2, int i3, Object obj) {
        c(i2, i3, 4);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r9v0 */
    /* JADX WARN: Type inference failed for: r9v1, types: [boolean, int] */
    /* JADX WARN: Type inference failed for: r9v6 */
    public final int a(RecyclerView.v vVar, q0 q0Var, RecyclerView.a0 a0Var) {
        int i2;
        int i3;
        int f2;
        int o;
        f fVar;
        int b2;
        int i4;
        int i5;
        int b3;
        boolean E;
        ?? r9 = 0;
        this.B.set(0, this.s, true);
        if (this.y.f1915i) {
            i3 = q0Var.f1911e == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
        } else {
            if (q0Var.f1911e == 1) {
                i2 = q0Var.f1913g + q0Var.f1908b;
            } else {
                i2 = q0Var.f1912f - q0Var.f1908b;
            }
            i3 = i2;
        }
        e(q0Var.f1911e, i3);
        if (this.A) {
            f2 = this.u.b();
        } else {
            f2 = this.u.f();
        }
        int i6 = f2;
        boolean z = false;
        while (q0Var.a(a0Var) && (this.y.f1915i || !this.B.isEmpty())) {
            View a2 = q0Var.a(vVar);
            c cVar = (c) a2.getLayoutParams();
            int a3 = cVar.a();
            int d2 = this.E.d(a3);
            boolean z2 = d2 == -1;
            if (z2) {
                fVar = cVar.f2672f ? this.t[r9] : a(q0Var);
                this.E.a(a3, fVar);
            } else {
                fVar = this.t[d2];
            }
            f fVar2 = fVar;
            cVar.f2671e = fVar2;
            if (q0Var.f1911e == 1) {
                b(a2);
            } else {
                b(a2, (int) r9);
            }
            a(a2, cVar, (boolean) r9);
            if (q0Var.f1911e == 1) {
                int o2 = cVar.f2672f ? o(i6) : fVar2.a(i6);
                int b4 = this.u.b(a2) + o2;
                if (z2 && cVar.f2672f) {
                    d.a k = k(o2);
                    k.f2676b = -1;
                    k.f2675a = a3;
                    this.E.a(k);
                }
                i4 = b4;
                b2 = o2;
            } else {
                int r = cVar.f2672f ? r(i6) : fVar2.b(i6);
                b2 = r - this.u.b(a2);
                if (z2 && cVar.f2672f) {
                    d.a l = l(r);
                    l.f2676b = 1;
                    l.f2675a = a3;
                    this.E.a(l);
                }
                i4 = r;
            }
            if (cVar.f2672f && q0Var.f1910d == -1) {
                if (z2) {
                    this.M = true;
                } else {
                    if (q0Var.f1911e == 1) {
                        E = D();
                    } else {
                        E = E();
                    }
                    if (!E) {
                        d.a c2 = this.E.c(a3);
                        if (c2 != null) {
                            c2.f2678d = true;
                        }
                        this.M = true;
                    }
                }
            }
            a(a2, cVar, q0Var);
            if (M() && this.w == 1) {
                int b5 = cVar.f2672f ? this.v.b() : this.v.b() - (((this.s - 1) - fVar2.f2692e) * this.x);
                b3 = b5;
                i5 = b5 - this.v.b(a2);
            } else {
                int f3 = cVar.f2672f ? this.v.f() : (fVar2.f2692e * this.x) + this.v.f();
                i5 = f3;
                b3 = this.v.b(a2) + f3;
            }
            if (this.w == 1) {
                a(a2, i5, b2, b3, i4);
            } else {
                a(a2, b2, i5, i4, b3);
            }
            if (cVar.f2672f) {
                e(this.y.f1911e, i3);
            } else {
                a(fVar2, this.y.f1911e, i3);
            }
            a(vVar, this.y);
            if (this.y.f1914h && a2.hasFocusable()) {
                if (cVar.f2672f) {
                    this.B.clear();
                } else {
                    this.B.set(fVar2.f2692e, false);
                    z = true;
                    r9 = 0;
                }
            }
            z = true;
            r9 = 0;
        }
        if (!z) {
            a(vVar, this.y);
        }
        if (this.y.f1911e == -1) {
            o = this.u.f() - r(this.u.f());
        } else {
            o = o(this.u.b()) - this.u.b();
        }
        if (o > 0) {
            return Math.min(q0Var.f1908b, o);
        }
        return 0;
    }

    public final void a(View view, c cVar, q0 q0Var) {
        if (q0Var.f1911e == 1) {
            if (cVar.f2672f) {
                p(view);
            } else {
                cVar.f2671e.a(view);
            }
        } else if (cVar.f2672f) {
            q(view);
        } else {
            cVar.f2671e.c(view);
        }
    }

    public final void a(RecyclerView.v vVar, q0 q0Var) {
        int min;
        int min2;
        if (!q0Var.f1907a || q0Var.f1915i) {
            return;
        }
        if (q0Var.f1908b == 0) {
            if (q0Var.f1911e == -1) {
                a(vVar, q0Var.f1913g);
            } else {
                b(vVar, q0Var.f1912f);
            }
        } else if (q0Var.f1911e == -1) {
            int i2 = q0Var.f1912f;
            int p = i2 - p(i2);
            if (p < 0) {
                min2 = q0Var.f1913g;
            } else {
                min2 = q0Var.f1913g - Math.min(p, q0Var.f1908b);
            }
            a(vVar, min2);
        } else {
            int q = q(q0Var.f1913g) - q0Var.f1913g;
            if (q < 0) {
                min = q0Var.f1912f;
            } else {
                min = Math.min(q, q0Var.f1908b) + q0Var.f1912f;
            }
            b(vVar, min);
        }
    }

    public final void a(f fVar, int i2, int i3) {
        int f2 = fVar.f();
        if (i2 == -1) {
            if (fVar.h() + f2 <= i3) {
                this.B.set(fVar.f2692e, false);
            }
        } else if (fVar.g() - f2 >= i3) {
            this.B.set(fVar.f2692e, false);
        }
    }

    public final void a(RecyclerView.v vVar, int i2) {
        for (int e2 = e() - 1; e2 >= 0; e2--) {
            View c2 = c(e2);
            if (this.u.d(c2) < i2 || this.u.f(c2) < i2) {
                return;
            }
            c cVar = (c) c2.getLayoutParams();
            if (cVar.f2672f) {
                for (int i3 = 0; i3 < this.s; i3++) {
                    if (this.t[i3].f2688a.size() == 1) {
                        return;
                    }
                }
                for (int i4 = 0; i4 < this.s; i4++) {
                    this.t[i4].j();
                }
            } else if (cVar.f2671e.f2688a.size() == 1) {
                return;
            } else {
                cVar.f2671e.j();
            }
            a(c2, vVar);
        }
    }

    public final f a(q0 q0Var) {
        int i2;
        int i3;
        int i4 = -1;
        if (s(q0Var.f1911e)) {
            i2 = this.s - 1;
            i3 = -1;
        } else {
            i2 = 0;
            i4 = this.s;
            i3 = 1;
        }
        f fVar = null;
        if (q0Var.f1911e == 1) {
            int i5 = Integer.MAX_VALUE;
            int f2 = this.u.f();
            while (i2 != i4) {
                f fVar2 = this.t[i2];
                int a2 = fVar2.a(f2);
                if (a2 < i5) {
                    fVar = fVar2;
                    i5 = a2;
                }
                i2 += i3;
            }
            return fVar;
        }
        int i6 = Integer.MIN_VALUE;
        int b2 = this.u.b();
        while (i2 != i4) {
            f fVar3 = this.t[i2];
            int b3 = fVar3.b(b2);
            if (b3 > i6) {
                fVar = fVar3;
                i6 = b3;
            }
            i2 += i3;
        }
        return fVar;
    }

    @Override // android.support.v7.widget.RecyclerView.o
    public boolean a() {
        return this.w == 0;
    }

    @Override // android.support.v7.widget.RecyclerView.o
    public int a(int i2, RecyclerView.v vVar, RecyclerView.a0 a0Var) {
        return c(i2, vVar, a0Var);
    }

    @Override // android.support.v7.widget.RecyclerView.o
    public void a(int i2, int i3, RecyclerView.a0 a0Var, RecyclerView.o.c cVar) {
        int a2;
        int i4;
        if (this.w != 0) {
            i2 = i3;
        }
        if (e() == 0 || i2 == 0) {
            return;
        }
        a(i2, a0Var);
        int[] iArr = this.O;
        if (iArr == null || iArr.length < this.s) {
            this.O = new int[this.s];
        }
        int i5 = 0;
        for (int i6 = 0; i6 < this.s; i6++) {
            q0 q0Var = this.y;
            if (q0Var.f1910d == -1) {
                a2 = q0Var.f1912f;
                i4 = this.t[i6].b(a2);
            } else {
                a2 = this.t[i6].a(q0Var.f1913g);
                i4 = this.y.f1913g;
            }
            int i7 = a2 - i4;
            if (i7 >= 0) {
                this.O[i5] = i7;
                i5++;
            }
        }
        Arrays.sort(this.O, 0, i5);
        for (int i8 = 0; i8 < i5 && this.y.a(a0Var); i8++) {
            cVar.a(this.y.f1909c, this.O[i8]);
            q0 q0Var2 = this.y;
            q0Var2.f1909c += q0Var2.f1910d;
        }
    }

    public void a(int i2, RecyclerView.a0 a0Var) {
        int I;
        int i3;
        if (i2 > 0) {
            I = J();
            i3 = 1;
        } else {
            I = I();
            i3 = -1;
        }
        this.y.f1907a = true;
        b(I, a0Var);
        t(i3);
        q0 q0Var = this.y;
        q0Var.f1909c = I + q0Var.f1910d;
        q0Var.f1908b = Math.abs(i2);
    }

    @Override // android.support.v7.widget.RecyclerView.o
    public RecyclerView.p a(Context context, AttributeSet attributeSet) {
        return new c(context, attributeSet);
    }

    @Override // android.support.v7.widget.RecyclerView.o
    public RecyclerView.p a(ViewGroup.LayoutParams layoutParams) {
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            return new c((ViewGroup.MarginLayoutParams) layoutParams);
        }
        return new c(layoutParams);
    }

    @Override // android.support.v7.widget.RecyclerView.o
    public boolean a(RecyclerView.p pVar) {
        return pVar instanceof c;
    }

    @Override // android.support.v7.widget.RecyclerView.o
    public View a(View view, int i2, RecyclerView.v vVar, RecyclerView.a0 a0Var) {
        View c2;
        int I;
        int e2;
        int e3;
        int e4;
        View a2;
        if (e() == 0 || (c2 = c(view)) == null) {
            return null;
        }
        O();
        int j = j(i2);
        if (j == Integer.MIN_VALUE) {
            return null;
        }
        c cVar = (c) c2.getLayoutParams();
        boolean z = cVar.f2672f;
        f fVar = cVar.f2671e;
        if (j == 1) {
            I = J();
        } else {
            I = I();
        }
        b(I, a0Var);
        t(j);
        q0 q0Var = this.y;
        q0Var.f1909c = q0Var.f1910d + I;
        q0Var.f1908b = (int) (this.u.g() * 0.33333334f);
        q0 q0Var2 = this.y;
        q0Var2.f1914h = true;
        q0Var2.f1907a = false;
        a(vVar, q0Var2, a0Var);
        this.G = this.A;
        if (z || (a2 = fVar.a(I, j)) == null || a2 == c2) {
            if (s(j)) {
                for (int i3 = this.s - 1; i3 >= 0; i3--) {
                    View a3 = this.t[i3].a(I, j);
                    if (a3 != null && a3 != c2) {
                        return a3;
                    }
                }
            } else {
                for (int i4 = 0; i4 < this.s; i4++) {
                    View a4 = this.t[i4].a(I, j);
                    if (a4 != null && a4 != c2) {
                        return a4;
                    }
                }
            }
            boolean z2 = (this.z ^ true) == (j == -1);
            if (!z) {
                if (z2) {
                    e4 = fVar.d();
                } else {
                    e4 = fVar.e();
                }
                View b2 = b(e4);
                if (b2 != null && b2 != c2) {
                    return b2;
                }
            }
            if (s(j)) {
                for (int i5 = this.s - 1; i5 >= 0; i5--) {
                    if (i5 != fVar.f2692e) {
                        if (z2) {
                            e3 = this.t[i5].d();
                        } else {
                            e3 = this.t[i5].e();
                        }
                        View b3 = b(e3);
                        if (b3 != null && b3 != c2) {
                            return b3;
                        }
                    }
                }
            } else {
                for (int i6 = 0; i6 < this.s; i6++) {
                    if (z2) {
                        e2 = this.t[i6].d();
                    } else {
                        e2 = this.t[i6].e();
                    }
                    View b4 = b(e2);
                    if (b4 != null && b4 != c2) {
                        return b4;
                    }
                }
            }
            return null;
        }
        return a2;
    }
}
