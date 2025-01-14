package android.support.v7.widget;

import a.b.h.k.c1;
import a.b.h.k.w0;
import android.content.Context;
import android.os.Parcel;
import android.os.Parcelable;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;
import java.util.List;
/* loaded from: classes.dex */
public class LinearLayoutManager extends RecyclerView.o implements a.b.h.k.v1.a, RecyclerView.z.a {
    public int A;
    public int B;
    public boolean C;
    public d D;
    public final a E;
    public final b F;
    public int G;
    public int s;
    public c t;
    public w0 u;
    public boolean v;
    public boolean w;
    public boolean x;
    public boolean y;
    public boolean z;

    /* loaded from: classes.dex */
    public static class b {

        /* renamed from: a  reason: collision with root package name */
        public int f2536a;

        /* renamed from: b  reason: collision with root package name */
        public boolean f2537b;

        /* renamed from: c  reason: collision with root package name */
        public boolean f2538c;

        /* renamed from: d  reason: collision with root package name */
        public boolean f2539d;

        public void a() {
            this.f2536a = 0;
            this.f2537b = false;
            this.f2538c = false;
            this.f2539d = false;
        }
    }

    /* loaded from: classes.dex */
    public static class c {

        /* renamed from: b  reason: collision with root package name */
        public int f2541b;

        /* renamed from: c  reason: collision with root package name */
        public int f2542c;

        /* renamed from: d  reason: collision with root package name */
        public int f2543d;

        /* renamed from: e  reason: collision with root package name */
        public int f2544e;

        /* renamed from: f  reason: collision with root package name */
        public int f2545f;

        /* renamed from: g  reason: collision with root package name */
        public int f2546g;

        /* renamed from: i  reason: collision with root package name */
        public boolean f2548i;
        public int j;
        public boolean l;

        /* renamed from: a  reason: collision with root package name */
        public boolean f2540a = true;

        /* renamed from: h  reason: collision with root package name */
        public int f2547h = 0;
        public List<RecyclerView.d0> k = null;

        public boolean a(RecyclerView.a0 a0Var) {
            int i2 = this.f2543d;
            return i2 >= 0 && i2 < a0Var.a();
        }

        public final View b() {
            int size = this.k.size();
            for (int i2 = 0; i2 < size; i2++) {
                View view = this.k.get(i2).f2580a;
                RecyclerView.p pVar = (RecyclerView.p) view.getLayoutParams();
                if (!pVar.c() && this.f2543d == pVar.a()) {
                    a(view);
                    return view;
                }
            }
            return null;
        }

        public View a(RecyclerView.v vVar) {
            if (this.k != null) {
                return b();
            }
            View d2 = vVar.d(this.f2543d);
            this.f2543d += this.f2544e;
            return d2;
        }

        public void a() {
            a((View) null);
        }

        public void a(View view) {
            View b2 = b(view);
            if (b2 == null) {
                this.f2543d = -1;
            } else {
                this.f2543d = ((RecyclerView.p) b2.getLayoutParams()).a();
            }
        }

        public View b(View view) {
            int a2;
            int size = this.k.size();
            View view2 = null;
            int i2 = Integer.MAX_VALUE;
            for (int i3 = 0; i3 < size; i3++) {
                View view3 = this.k.get(i3).f2580a;
                RecyclerView.p pVar = (RecyclerView.p) view3.getLayoutParams();
                if (view3 != view && !pVar.c() && (a2 = (pVar.a() - this.f2543d) * this.f2544e) >= 0 && a2 < i2) {
                    view2 = view3;
                    if (a2 == 0) {
                        break;
                    }
                    i2 = a2;
                }
            }
            return view2;
        }
    }

    /* loaded from: classes.dex */
    public static class d implements Parcelable {
        public static final Parcelable.Creator<d> CREATOR = new a();

        /* renamed from: a  reason: collision with root package name */
        public int f2549a;

        /* renamed from: b  reason: collision with root package name */
        public int f2550b;

        /* renamed from: c  reason: collision with root package name */
        public boolean f2551c;

        /* loaded from: classes.dex */
        public static class a implements Parcelable.Creator<d> {
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public d createFromParcel(Parcel parcel) {
                return new d(parcel);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public d[] newArray(int i2) {
                return new d[i2];
            }
        }

        public d() {
        }

        public boolean a() {
            return this.f2549a >= 0;
        }

        public void b() {
            this.f2549a = -1;
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i2) {
            parcel.writeInt(this.f2549a);
            parcel.writeInt(this.f2550b);
            parcel.writeInt(this.f2551c ? 1 : 0);
        }

        public d(Parcel parcel) {
            this.f2549a = parcel.readInt();
            this.f2550b = parcel.readInt();
            this.f2551c = parcel.readInt() == 1;
        }

        public d(d dVar) {
            this.f2549a = dVar.f2549a;
            this.f2550b = dVar.f2550b;
            this.f2551c = dVar.f2551c;
        }
    }

    public LinearLayoutManager(Context context) {
        this(context, 1, false);
    }

    @Override // android.support.v7.widget.RecyclerView.o
    public boolean A() {
        return (i() == 1073741824 || r() == 1073741824 || !s()) ? false : true;
    }

    @Override // android.support.v7.widget.RecyclerView.o
    public boolean C() {
        return this.D == null && this.v == this.y;
    }

    public c D() {
        return new c();
    }

    public void E() {
        if (this.t == null) {
            this.t = D();
        }
    }

    public int F() {
        View a2 = a(0, e(), false, true);
        if (a2 == null) {
            return -1;
        }
        return l(a2);
    }

    public int G() {
        View a2 = a(e() - 1, -1, false, true);
        if (a2 == null) {
            return -1;
        }
        return l(a2);
    }

    public final View H() {
        return c(this.x ? 0 : e() - 1);
    }

    public final View I() {
        return c(this.x ? e() - 1 : 0);
    }

    public int J() {
        return this.s;
    }

    public boolean K() {
        return j() == 1;
    }

    public boolean L() {
        return this.u.d() == 0 && this.u.a() == 0;
    }

    public final void M() {
        if (this.s != 1 && K()) {
            this.x = !this.w;
        } else {
            this.x = this.w;
        }
    }

    public void a(RecyclerView.v vVar, RecyclerView.a0 a0Var, a aVar, int i2) {
    }

    @Override // android.support.v7.widget.RecyclerView.o
    public void a(AccessibilityEvent accessibilityEvent) {
        super.a(accessibilityEvent);
        if (e() > 0) {
            accessibilityEvent.setFromIndex(F());
            accessibilityEvent.setToIndex(G());
        }
    }

    @Override // android.support.v7.widget.RecyclerView.o
    public void b(RecyclerView recyclerView, RecyclerView.v vVar) {
        super.b(recyclerView, vVar);
        if (this.C) {
            b(vVar);
            vVar.a();
        }
    }

    @Override // android.support.v7.widget.RecyclerView.o
    public RecyclerView.p c() {
        return new RecyclerView.p(-2, -2);
    }

    @Override // android.support.v7.widget.RecyclerView.o
    public int d(RecyclerView.a0 a0Var) {
        return h(a0Var);
    }

    @Override // android.support.v7.widget.RecyclerView.o
    public void e(RecyclerView.v vVar, RecyclerView.a0 a0Var) {
        int i2;
        int i3;
        int i4;
        int i5;
        int i6;
        int a2;
        int i7;
        View b2;
        int d2;
        int i8;
        int i9 = -1;
        if ((this.D != null || this.A != -1) && a0Var.a() == 0) {
            b(vVar);
            return;
        }
        d dVar = this.D;
        if (dVar != null && dVar.a()) {
            this.A = this.D.f2549a;
        }
        E();
        this.t.f2540a = false;
        M();
        View g2 = g();
        if (this.E.f2535e && this.A == -1 && this.D == null) {
            if (g2 != null && (this.u.d(g2) >= this.u.b() || this.u.a(g2) <= this.u.f())) {
                this.E.b(g2, l(g2));
            }
        } else {
            this.E.b();
            a aVar = this.E;
            aVar.f2534d = this.x ^ this.y;
            b(vVar, a0Var, aVar);
            this.E.f2535e = true;
        }
        int k = k(a0Var);
        if (this.t.j >= 0) {
            i2 = k;
            k = 0;
        } else {
            i2 = 0;
        }
        int f2 = k + this.u.f();
        int c2 = i2 + this.u.c();
        if (a0Var.d() && (i7 = this.A) != -1 && this.B != Integer.MIN_VALUE && (b2 = b(i7)) != null) {
            if (this.x) {
                i8 = this.u.b() - this.u.a(b2);
                d2 = this.B;
            } else {
                d2 = this.u.d(b2) - this.u.f();
                i8 = this.B;
            }
            int i10 = i8 - d2;
            if (i10 > 0) {
                f2 += i10;
            } else {
                c2 -= i10;
            }
        }
        if (!this.E.f2534d ? !this.x : this.x) {
            i9 = 1;
        }
        a(vVar, a0Var, this.E, i9);
        a(vVar);
        this.t.l = L();
        this.t.f2548i = a0Var.d();
        a aVar2 = this.E;
        if (aVar2.f2534d) {
            b(aVar2);
            c cVar = this.t;
            cVar.f2547h = f2;
            a(vVar, cVar, a0Var, false);
            c cVar2 = this.t;
            i4 = cVar2.f2541b;
            int i11 = cVar2.f2543d;
            int i12 = cVar2.f2542c;
            if (i12 > 0) {
                c2 += i12;
            }
            a(this.E);
            c cVar3 = this.t;
            cVar3.f2547h = c2;
            cVar3.f2543d += cVar3.f2544e;
            a(vVar, cVar3, a0Var, false);
            c cVar4 = this.t;
            i3 = cVar4.f2541b;
            int i13 = cVar4.f2542c;
            if (i13 > 0) {
                g(i11, i4);
                c cVar5 = this.t;
                cVar5.f2547h = i13;
                a(vVar, cVar5, a0Var, false);
                i4 = this.t.f2541b;
            }
        } else {
            a(aVar2);
            c cVar6 = this.t;
            cVar6.f2547h = c2;
            a(vVar, cVar6, a0Var, false);
            c cVar7 = this.t;
            i3 = cVar7.f2541b;
            int i14 = cVar7.f2543d;
            int i15 = cVar7.f2542c;
            if (i15 > 0) {
                f2 += i15;
            }
            b(this.E);
            c cVar8 = this.t;
            cVar8.f2547h = f2;
            cVar8.f2543d += cVar8.f2544e;
            a(vVar, cVar8, a0Var, false);
            c cVar9 = this.t;
            i4 = cVar9.f2541b;
            int i16 = cVar9.f2542c;
            if (i16 > 0) {
                f(i14, i3);
                c cVar10 = this.t;
                cVar10.f2547h = i16;
                a(vVar, cVar10, a0Var, false);
                i3 = this.t.f2541b;
            }
        }
        if (e() > 0) {
            if (this.x ^ this.y) {
                int a3 = a(i3, vVar, a0Var, true);
                i5 = i4 + a3;
                i6 = i3 + a3;
                a2 = b(i5, vVar, a0Var, false);
            } else {
                int b3 = b(i4, vVar, a0Var, true);
                i5 = i4 + b3;
                i6 = i3 + b3;
                a2 = a(i6, vVar, a0Var, false);
            }
            i4 = i5 + a2;
            i3 = i6 + a2;
        }
        b(vVar, a0Var, i4, i3);
        if (!a0Var.d()) {
            this.u.i();
        } else {
            this.E.b();
        }
        this.v = this.y;
    }

    public final void f(int i2, int i3) {
        this.t.f2542c = this.u.b() - i3;
        this.t.f2544e = this.x ? -1 : 1;
        c cVar = this.t;
        cVar.f2543d = i2;
        cVar.f2545f = 1;
        cVar.f2541b = i3;
        cVar.f2546g = Integer.MIN_VALUE;
    }

    @Override // android.support.v7.widget.RecyclerView.o
    public void g(RecyclerView.a0 a0Var) {
        super.g(a0Var);
        this.D = null;
        this.A = -1;
        this.B = Integer.MIN_VALUE;
        this.E.b();
    }

    @Override // android.support.v7.widget.RecyclerView.o
    public void h(int i2) {
        this.A = i2;
        this.B = Integer.MIN_VALUE;
        d dVar = this.D;
        if (dVar != null) {
            dVar.b();
        }
        y();
    }

    public final int i(RecyclerView.a0 a0Var) {
        if (e() == 0) {
            return 0;
        }
        E();
        return c1.a(a0Var, this.u, b(!this.z, true), a(!this.z, true), this, this.z, this.x);
    }

    public void j(int i2) {
        if (i2 != 0 && i2 != 1) {
            throw new IllegalArgumentException("invalid orientation:" + i2);
        }
        a((String) null);
        if (i2 != this.s || this.u == null) {
            this.u = w0.a(this, i2);
            this.E.f2531a = this.u;
            this.s = i2;
            y();
        }
    }

    public int k(RecyclerView.a0 a0Var) {
        if (a0Var.c()) {
            return this.u.g();
        }
        return 0;
    }

    public final View l(RecyclerView.v vVar, RecyclerView.a0 a0Var) {
        return this.x ? g(vVar, a0Var) : i(vVar, a0Var);
    }

    public final View m(RecyclerView.v vVar, RecyclerView.a0 a0Var) {
        return this.x ? i(vVar, a0Var) : g(vVar, a0Var);
    }

    @Override // android.support.v7.widget.RecyclerView.o
    public boolean u() {
        return true;
    }

    @Override // android.support.v7.widget.RecyclerView.o
    public Parcelable x() {
        d dVar = this.D;
        if (dVar != null) {
            return new d(dVar);
        }
        d dVar2 = new d();
        if (e() > 0) {
            E();
            boolean z = this.v ^ this.x;
            dVar2.f2551c = z;
            if (z) {
                View H = H();
                dVar2.f2550b = this.u.b() - this.u.a(H);
                dVar2.f2549a = l(H);
            } else {
                View I = I();
                dVar2.f2549a = l(I);
                dVar2.f2550b = this.u.d(I) - this.u.f();
            }
        } else {
            dVar2.b();
        }
        return dVar2;
    }

    public LinearLayoutManager(Context context, int i2, boolean z) {
        this.s = 1;
        this.w = false;
        this.x = false;
        this.y = false;
        this.z = true;
        this.A = -1;
        this.B = Integer.MIN_VALUE;
        this.D = null;
        this.E = new a();
        this.F = new b();
        this.G = 2;
        j(i2);
        a(z);
    }

    @Override // android.support.v7.widget.RecyclerView.o
    public int c(RecyclerView.a0 a0Var) {
        return j(a0Var);
    }

    /* loaded from: classes.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public w0 f2531a;

        /* renamed from: b  reason: collision with root package name */
        public int f2532b;

        /* renamed from: c  reason: collision with root package name */
        public int f2533c;

        /* renamed from: d  reason: collision with root package name */
        public boolean f2534d;

        /* renamed from: e  reason: collision with root package name */
        public boolean f2535e;

        public a() {
            b();
        }

        public void a() {
            int f2;
            if (this.f2534d) {
                f2 = this.f2531a.b();
            } else {
                f2 = this.f2531a.f();
            }
            this.f2533c = f2;
        }

        public void b() {
            this.f2532b = -1;
            this.f2533c = Integer.MIN_VALUE;
            this.f2534d = false;
            this.f2535e = false;
        }

        public String toString() {
            return "AnchorInfo{mPosition=" + this.f2532b + ", mCoordinate=" + this.f2533c + ", mLayoutFromEnd=" + this.f2534d + ", mValid=" + this.f2535e + '}';
        }

        public boolean a(View view, RecyclerView.a0 a0Var) {
            RecyclerView.p pVar = (RecyclerView.p) view.getLayoutParams();
            return !pVar.c() && pVar.a() >= 0 && pVar.a() < a0Var.a();
        }

        public void b(View view, int i2) {
            int h2 = this.f2531a.h();
            if (h2 >= 0) {
                a(view, i2);
                return;
            }
            this.f2532b = i2;
            if (this.f2534d) {
                int b2 = (this.f2531a.b() - h2) - this.f2531a.a(view);
                this.f2533c = this.f2531a.b() - b2;
                if (b2 > 0) {
                    int b3 = this.f2533c - this.f2531a.b(view);
                    int f2 = this.f2531a.f();
                    int min = b3 - (f2 + Math.min(this.f2531a.d(view) - f2, 0));
                    if (min < 0) {
                        this.f2533c += Math.min(b2, -min);
                        return;
                    }
                    return;
                }
                return;
            }
            int d2 = this.f2531a.d(view);
            int f3 = d2 - this.f2531a.f();
            this.f2533c = d2;
            if (f3 > 0) {
                int b4 = (this.f2531a.b() - Math.min(0, (this.f2531a.b() - h2) - this.f2531a.a(view))) - (d2 + this.f2531a.b(view));
                if (b4 < 0) {
                    this.f2533c -= Math.min(f3, -b4);
                }
            }
        }

        public void a(View view, int i2) {
            if (this.f2534d) {
                this.f2533c = this.f2531a.a(view) + this.f2531a.h();
            } else {
                this.f2533c = this.f2531a.d(view);
            }
            this.f2532b = i2;
        }
    }

    public int c(int i2, RecyclerView.v vVar, RecyclerView.a0 a0Var) {
        if (e() == 0 || i2 == 0) {
            return 0;
        }
        this.t.f2540a = true;
        E();
        int i3 = i2 > 0 ? 1 : -1;
        int abs = Math.abs(i2);
        a(i3, abs, true, a0Var);
        c cVar = this.t;
        int a2 = cVar.f2546g + a(vVar, cVar, a0Var, false);
        if (a2 < 0) {
            return 0;
        }
        if (abs > a2) {
            i2 = i3 * a2;
        }
        this.u.a(-i2);
        this.t.j = i2;
        return i2;
    }

    public final View k(RecyclerView.v vVar, RecyclerView.a0 a0Var) {
        return this.x ? h(vVar, a0Var) : f(vVar, a0Var);
    }

    @Override // android.support.v7.widget.RecyclerView.o
    public void a(Parcelable parcelable) {
        if (parcelable instanceof d) {
            this.D = (d) parcelable;
            y();
        }
    }

    @Override // android.support.v7.widget.RecyclerView.o
    public boolean b() {
        return this.s == 1;
    }

    public void b(boolean z) {
        a((String) null);
        if (this.y == z) {
            return;
        }
        this.y = z;
        y();
    }

    public final void g(int i2, int i3) {
        this.t.f2542c = i3 - this.u.f();
        c cVar = this.t;
        cVar.f2543d = i2;
        cVar.f2544e = this.x ? 1 : -1;
        c cVar2 = this.t;
        cVar2.f2545f = -1;
        cVar2.f2541b = i3;
        cVar2.f2546g = Integer.MIN_VALUE;
    }

    public final int h(RecyclerView.a0 a0Var) {
        if (e() == 0) {
            return 0;
        }
        E();
        return c1.a(a0Var, this.u, b(!this.z, true), a(!this.z, true), this, this.z);
    }

    @Override // android.support.v7.widget.RecyclerView.o
    public int f(RecyclerView.a0 a0Var) {
        return j(a0Var);
    }

    public int i(int i2) {
        return i2 != 1 ? i2 != 2 ? i2 != 17 ? i2 != 33 ? i2 != 66 ? (i2 == 130 && this.s == 1) ? 1 : Integer.MIN_VALUE : this.s == 0 ? 1 : Integer.MIN_VALUE : this.s == 1 ? -1 : Integer.MIN_VALUE : this.s == 0 ? -1 : Integer.MIN_VALUE : (this.s != 1 && K()) ? -1 : 1 : (this.s != 1 && K()) ? 1 : -1;
    }

    @Override // android.support.v7.widget.RecyclerView.o
    public boolean a() {
        return this.s == 0;
    }

    public final View f(RecyclerView.v vVar, RecyclerView.a0 a0Var) {
        return e(0, e());
    }

    public final int j(RecyclerView.a0 a0Var) {
        if (e() == 0) {
            return 0;
        }
        E();
        return c1.b(a0Var, this.u, b(!this.z, true), a(!this.z, true), this, this.z);
    }

    public void a(boolean z) {
        a((String) null);
        if (z == this.w) {
            return;
        }
        this.w = z;
        y();
    }

    @Override // android.support.v7.widget.RecyclerView.o
    public View b(int i2) {
        int e2 = e();
        if (e2 == 0) {
            return null;
        }
        int l = i2 - l(c(0));
        if (l >= 0 && l < e2) {
            View c2 = c(l);
            if (l(c2) == i2) {
                return c2;
            }
        }
        return super.b(i2);
    }

    public final View g(RecyclerView.v vVar, RecyclerView.a0 a0Var) {
        return a(vVar, a0Var, 0, e(), a0Var.a());
    }

    public final View h(RecyclerView.v vVar, RecyclerView.a0 a0Var) {
        return e(e() - 1, -1);
    }

    public final boolean a(RecyclerView.v vVar, RecyclerView.a0 a0Var, a aVar) {
        View m;
        int f2;
        boolean z = false;
        if (e() == 0) {
            return false;
        }
        View g2 = g();
        if (g2 != null && aVar.a(g2, a0Var)) {
            aVar.b(g2, l(g2));
            return true;
        } else if (this.v != this.y) {
            return false;
        } else {
            if (aVar.f2534d) {
                m = l(vVar, a0Var);
            } else {
                m = m(vVar, a0Var);
            }
            if (m != null) {
                aVar.a(m, l(m));
                if (!a0Var.d() && C()) {
                    if ((this.u.d(m) >= this.u.b() || this.u.a(m) < this.u.f()) ? true : true) {
                        if (aVar.f2534d) {
                            f2 = this.u.b();
                        } else {
                            f2 = this.u.f();
                        }
                        aVar.f2533c = f2;
                    }
                }
                return true;
            }
            return false;
        }
    }

    public final View j(RecyclerView.v vVar, RecyclerView.a0 a0Var) {
        return this.x ? f(vVar, a0Var) : h(vVar, a0Var);
    }

    public final void b(RecyclerView.v vVar, RecyclerView.a0 a0Var, int i2, int i3) {
        if (!a0Var.e() || e() == 0 || a0Var.d() || !C()) {
            return;
        }
        List<RecyclerView.d0> f2 = vVar.f();
        int size = f2.size();
        int l = l(c(0));
        int i4 = 0;
        int i5 = 0;
        for (int i6 = 0; i6 < size; i6++) {
            RecyclerView.d0 d0Var = f2.get(i6);
            if (!d0Var.r()) {
                if (((d0Var.k() < l) != this.x ? (char) 65535 : (char) 1) == 65535) {
                    i4 += this.u.b(d0Var.f2580a);
                } else {
                    i5 += this.u.b(d0Var.f2580a);
                }
            }
        }
        this.t.k = f2;
        if (i4 > 0) {
            g(l(I()), i2);
            c cVar = this.t;
            cVar.f2547h = i4;
            cVar.f2542c = 0;
            cVar.a();
            a(vVar, this.t, a0Var, false);
        }
        if (i5 > 0) {
            f(l(H()), i3);
            c cVar2 = this.t;
            cVar2.f2547h = i5;
            cVar2.f2542c = 0;
            cVar2.a();
            a(vVar, this.t, a0Var, false);
        }
        this.t.k = null;
    }

    public final View i(RecyclerView.v vVar, RecyclerView.a0 a0Var) {
        return a(vVar, a0Var, e() - 1, -1, a0Var.a());
    }

    public LinearLayoutManager(Context context, AttributeSet attributeSet, int i2, int i3) {
        this.s = 1;
        this.w = false;
        this.x = false;
        this.y = false;
        this.z = true;
        this.A = -1;
        this.B = Integer.MIN_VALUE;
        this.D = null;
        this.E = new a();
        this.F = new b();
        this.G = 2;
        RecyclerView.o.d a2 = RecyclerView.o.a(context, attributeSet, i2, i3);
        j(a2.f2613a);
        a(a2.f2615c);
        b(a2.f2616d);
    }

    public final boolean a(RecyclerView.a0 a0Var, a aVar) {
        int i2;
        int d2;
        if (!a0Var.d() && (i2 = this.A) != -1) {
            if (i2 >= 0 && i2 < a0Var.a()) {
                aVar.f2532b = this.A;
                d dVar = this.D;
                if (dVar != null && dVar.a()) {
                    aVar.f2534d = this.D.f2551c;
                    if (aVar.f2534d) {
                        aVar.f2533c = this.u.b() - this.D.f2550b;
                    } else {
                        aVar.f2533c = this.u.f() + this.D.f2550b;
                    }
                    return true;
                } else if (this.B == Integer.MIN_VALUE) {
                    View b2 = b(this.A);
                    if (b2 != null) {
                        if (this.u.b(b2) > this.u.g()) {
                            aVar.a();
                            return true;
                        } else if (this.u.d(b2) - this.u.f() < 0) {
                            aVar.f2533c = this.u.f();
                            aVar.f2534d = false;
                            return true;
                        } else if (this.u.b() - this.u.a(b2) < 0) {
                            aVar.f2533c = this.u.b();
                            aVar.f2534d = true;
                            return true;
                        } else {
                            if (aVar.f2534d) {
                                d2 = this.u.a(b2) + this.u.h();
                            } else {
                                d2 = this.u.d(b2);
                            }
                            aVar.f2533c = d2;
                        }
                    } else {
                        if (e() > 0) {
                            aVar.f2534d = (this.A < l(c(0))) == this.x;
                        }
                        aVar.a();
                    }
                    return true;
                } else {
                    boolean z = this.x;
                    aVar.f2534d = z;
                    if (z) {
                        aVar.f2533c = this.u.b() - this.B;
                    } else {
                        aVar.f2533c = this.u.f() + this.B;
                    }
                    return true;
                }
            }
            this.A = -1;
            this.B = Integer.MIN_VALUE;
        }
        return false;
    }

    public final void b(RecyclerView.v vVar, RecyclerView.a0 a0Var, a aVar) {
        if (a(a0Var, aVar) || a(vVar, a0Var, aVar)) {
            return;
        }
        aVar.a();
        aVar.f2532b = this.y ? a0Var.a() - 1 : 0;
    }

    public final int b(int i2, RecyclerView.v vVar, RecyclerView.a0 a0Var, boolean z) {
        int f2;
        int f3 = i2 - this.u.f();
        if (f3 > 0) {
            int i3 = -c(f3, vVar, a0Var);
            int i4 = i2 + i3;
            if (!z || (f2 = i4 - this.u.f()) <= 0) {
                return i3;
            }
            this.u.a(-f2);
            return i3 - f2;
        }
        return 0;
    }

    public final void b(a aVar) {
        g(aVar.f2532b, aVar.f2533c);
    }

    @Override // android.support.v7.widget.RecyclerView.o
    public int b(int i2, RecyclerView.v vVar, RecyclerView.a0 a0Var) {
        if (this.s == 0) {
            return 0;
        }
        return c(i2, vVar, a0Var);
    }

    @Override // android.support.v7.widget.RecyclerView.o
    public int b(RecyclerView.a0 a0Var) {
        return i(a0Var);
    }

    public final void b(RecyclerView.v vVar, int i2) {
        if (i2 < 0) {
            return;
        }
        int e2 = e();
        if (!this.x) {
            for (int i3 = 0; i3 < e2; i3++) {
                View c2 = c(i3);
                if (this.u.a(c2) > i2 || this.u.e(c2) > i2) {
                    a(vVar, 0, i3);
                    return;
                }
            }
            return;
        }
        int i4 = e2 - 1;
        for (int i5 = i4; i5 >= 0; i5--) {
            View c3 = c(i5);
            if (this.u.a(c3) > i2 || this.u.e(c3) > i2) {
                a(vVar, i4, i5);
                return;
            }
        }
    }

    public final View b(boolean z, boolean z2) {
        if (this.x) {
            return a(e() - 1, -1, z, z2);
        }
        return a(0, e(), z, z2);
    }

    public final int a(int i2, RecyclerView.v vVar, RecyclerView.a0 a0Var, boolean z) {
        int b2;
        int b3 = this.u.b() - i2;
        if (b3 > 0) {
            int i3 = -c(-b3, vVar, a0Var);
            int i4 = i2 + i3;
            if (!z || (b2 = this.u.b() - i4) <= 0) {
                return i3;
            }
            this.u.a(b2);
            return b2 + i3;
        }
        return 0;
    }

    public final void a(a aVar) {
        f(aVar.f2532b, aVar.f2533c);
    }

    @Override // android.support.v7.widget.RecyclerView.o
    public int a(int i2, RecyclerView.v vVar, RecyclerView.a0 a0Var) {
        if (this.s == 1) {
            return 0;
        }
        return c(i2, vVar, a0Var);
    }

    @Override // android.support.v7.widget.RecyclerView.o
    public int a(RecyclerView.a0 a0Var) {
        return h(a0Var);
    }

    public final void a(int i2, int i3, boolean z, RecyclerView.a0 a0Var) {
        int f2;
        this.t.l = L();
        this.t.f2547h = k(a0Var);
        c cVar = this.t;
        cVar.f2545f = i2;
        if (i2 == 1) {
            cVar.f2547h += this.u.c();
            View H = H();
            this.t.f2544e = this.x ? -1 : 1;
            c cVar2 = this.t;
            int l = l(H);
            c cVar3 = this.t;
            cVar2.f2543d = l + cVar3.f2544e;
            cVar3.f2541b = this.u.a(H);
            f2 = this.u.a(H) - this.u.b();
        } else {
            View I = I();
            this.t.f2547h += this.u.f();
            this.t.f2544e = this.x ? 1 : -1;
            c cVar4 = this.t;
            int l2 = l(I);
            c cVar5 = this.t;
            cVar4.f2543d = l2 + cVar5.f2544e;
            cVar5.f2541b = this.u.d(I);
            f2 = (-this.u.d(I)) + this.u.f();
        }
        c cVar6 = this.t;
        cVar6.f2542c = i3;
        if (z) {
            cVar6.f2542c -= f2;
        }
        this.t.f2546g = f2;
    }

    @Override // android.support.v7.widget.RecyclerView.o
    public int e(RecyclerView.a0 a0Var) {
        return i(a0Var);
    }

    public View e(int i2, int i3) {
        int i4;
        int i5;
        E();
        if ((i3 > i2 ? (char) 1 : i3 < i2 ? (char) 65535 : (char) 0) == 0) {
            return c(i2);
        }
        if (this.u.d(c(i2)) < this.u.f()) {
            i4 = 16644;
            i5 = 16388;
        } else {
            i4 = 4161;
            i5 = 4097;
        }
        if (this.s == 0) {
            return this.f2606e.a(i2, i3, i4, i5);
        }
        return this.f2607f.a(i2, i3, i4, i5);
    }

    public void a(RecyclerView.a0 a0Var, c cVar, RecyclerView.o.c cVar2) {
        int i2 = cVar.f2543d;
        if (i2 < 0 || i2 >= a0Var.a()) {
            return;
        }
        cVar2.a(i2, Math.max(0, cVar.f2546g));
    }

    @Override // android.support.v7.widget.RecyclerView.o
    public void a(int i2, RecyclerView.o.c cVar) {
        boolean z;
        int i3;
        d dVar = this.D;
        if (dVar != null && dVar.a()) {
            d dVar2 = this.D;
            z = dVar2.f2551c;
            i3 = dVar2.f2549a;
        } else {
            M();
            z = this.x;
            i3 = this.A;
            if (i3 == -1) {
                i3 = z ? i2 - 1 : 0;
            }
        }
        int i4 = z ? -1 : 1;
        int i5 = i3;
        for (int i6 = 0; i6 < this.G && i5 >= 0 && i5 < i2; i6++) {
            cVar.a(i5, 0);
            i5 += i4;
        }
    }

    @Override // android.support.v7.widget.RecyclerView.o
    public void a(int i2, int i3, RecyclerView.a0 a0Var, RecyclerView.o.c cVar) {
        if (this.s != 0) {
            i2 = i3;
        }
        if (e() == 0 || i2 == 0) {
            return;
        }
        E();
        a(i2 > 0 ? 1 : -1, Math.abs(i2), true, a0Var);
        a(a0Var, this.t, cVar);
    }

    @Override // android.support.v7.widget.RecyclerView.o
    public void a(String str) {
        if (this.D == null) {
            super.a(str);
        }
    }

    public final void a(RecyclerView.v vVar, int i2, int i3) {
        if (i2 == i3) {
            return;
        }
        if (i3 <= i2) {
            while (i2 > i3) {
                a(i2, vVar);
                i2--;
            }
            return;
        }
        for (int i4 = i3 - 1; i4 >= i2; i4--) {
            a(i4, vVar);
        }
    }

    public final void a(RecyclerView.v vVar, int i2) {
        int e2 = e();
        if (i2 < 0) {
            return;
        }
        int a2 = this.u.a() - i2;
        if (this.x) {
            for (int i3 = 0; i3 < e2; i3++) {
                View c2 = c(i3);
                if (this.u.d(c2) < a2 || this.u.f(c2) < a2) {
                    a(vVar, 0, i3);
                    return;
                }
            }
            return;
        }
        int i4 = e2 - 1;
        for (int i5 = i4; i5 >= 0; i5--) {
            View c3 = c(i5);
            if (this.u.d(c3) < a2 || this.u.f(c3) < a2) {
                a(vVar, i4, i5);
                return;
            }
        }
    }

    public final void a(RecyclerView.v vVar, c cVar) {
        if (!cVar.f2540a || cVar.l) {
            return;
        }
        if (cVar.f2545f == -1) {
            a(vVar, cVar.f2546g);
        } else {
            b(vVar, cVar.f2546g);
        }
    }

    public int a(RecyclerView.v vVar, c cVar, RecyclerView.a0 a0Var, boolean z) {
        int i2 = cVar.f2542c;
        int i3 = cVar.f2546g;
        if (i3 != Integer.MIN_VALUE) {
            if (i2 < 0) {
                cVar.f2546g = i3 + i2;
            }
            a(vVar, cVar);
        }
        int i4 = cVar.f2542c + cVar.f2547h;
        b bVar = this.F;
        while (true) {
            if ((!cVar.l && i4 <= 0) || !cVar.a(a0Var)) {
                break;
            }
            bVar.a();
            a(vVar, a0Var, cVar, bVar);
            if (!bVar.f2537b) {
                cVar.f2541b += bVar.f2536a * cVar.f2545f;
                if (!bVar.f2538c || this.t.k != null || !a0Var.d()) {
                    int i5 = cVar.f2542c;
                    int i6 = bVar.f2536a;
                    cVar.f2542c = i5 - i6;
                    i4 -= i6;
                }
                int i7 = cVar.f2546g;
                if (i7 != Integer.MIN_VALUE) {
                    cVar.f2546g = i7 + bVar.f2536a;
                    int i8 = cVar.f2542c;
                    if (i8 < 0) {
                        cVar.f2546g += i8;
                    }
                    a(vVar, cVar);
                }
                if (z && bVar.f2539d) {
                    break;
                }
            } else {
                break;
            }
        }
        return i2 - cVar.f2542c;
    }

    public void a(RecyclerView.v vVar, RecyclerView.a0 a0Var, c cVar, b bVar) {
        int i2;
        int i3;
        int i4;
        int i5;
        int c2;
        View a2 = cVar.a(vVar);
        if (a2 == null) {
            bVar.f2537b = true;
            return;
        }
        RecyclerView.p pVar = (RecyclerView.p) a2.getLayoutParams();
        if (cVar.k == null) {
            if (this.x == (cVar.f2545f == -1)) {
                b(a2);
            } else {
                b(a2, 0);
            }
        } else {
            if (this.x == (cVar.f2545f == -1)) {
                a(a2);
            } else {
                a(a2, 0);
            }
        }
        a(a2, 0, 0);
        bVar.f2536a = this.u.b(a2);
        if (this.s == 1) {
            if (K()) {
                c2 = q() - o();
                i5 = c2 - this.u.c(a2);
            } else {
                i5 = n();
                c2 = this.u.c(a2) + i5;
            }
            if (cVar.f2545f == -1) {
                int i6 = cVar.f2541b;
                i4 = i6;
                i3 = c2;
                i2 = i6 - bVar.f2536a;
            } else {
                int i7 = cVar.f2541b;
                i2 = i7;
                i3 = c2;
                i4 = bVar.f2536a + i7;
            }
        } else {
            int p = p();
            int c3 = this.u.c(a2) + p;
            if (cVar.f2545f == -1) {
                int i8 = cVar.f2541b;
                i3 = i8;
                i2 = p;
                i4 = c3;
                i5 = i8 - bVar.f2536a;
            } else {
                int i9 = cVar.f2541b;
                i2 = p;
                i3 = bVar.f2536a + i9;
                i4 = c3;
                i5 = i9;
            }
        }
        a(a2, i5, i2, i3, i4);
        if (pVar.c() || pVar.b()) {
            bVar.f2538c = true;
        }
        bVar.f2539d = a2.hasFocusable();
    }

    public final View a(boolean z, boolean z2) {
        if (this.x) {
            return a(0, e(), z, z2);
        }
        return a(e() - 1, -1, z, z2);
    }

    public View a(RecyclerView.v vVar, RecyclerView.a0 a0Var, int i2, int i3, int i4) {
        E();
        int f2 = this.u.f();
        int b2 = this.u.b();
        int i5 = i3 > i2 ? 1 : -1;
        View view = null;
        View view2 = null;
        while (i2 != i3) {
            View c2 = c(i2);
            int l = l(c2);
            if (l >= 0 && l < i4) {
                if (((RecyclerView.p) c2.getLayoutParams()).c()) {
                    if (view2 == null) {
                        view2 = c2;
                    }
                } else if (this.u.d(c2) < b2 && this.u.a(c2) >= f2) {
                    return c2;
                } else {
                    if (view == null) {
                        view = c2;
                    }
                }
            }
            i2 += i5;
        }
        return view != null ? view : view2;
    }

    public View a(int i2, int i3, boolean z, boolean z2) {
        E();
        int i4 = z ? 24579 : 320;
        int i5 = z2 ? 320 : 0;
        if (this.s == 0) {
            return this.f2606e.a(i2, i3, i4, i5);
        }
        return this.f2607f.a(i2, i3, i4, i5);
    }

    @Override // android.support.v7.widget.RecyclerView.o
    public View a(View view, int i2, RecyclerView.v vVar, RecyclerView.a0 a0Var) {
        int i3;
        View j;
        View H;
        M();
        if (e() == 0 || (i3 = i(i2)) == Integer.MIN_VALUE) {
            return null;
        }
        E();
        E();
        a(i3, (int) (this.u.g() * 0.33333334f), false, a0Var);
        c cVar = this.t;
        cVar.f2546g = Integer.MIN_VALUE;
        cVar.f2540a = false;
        a(vVar, cVar, a0Var, true);
        if (i3 == -1) {
            j = k(vVar, a0Var);
        } else {
            j = j(vVar, a0Var);
        }
        if (i3 == -1) {
            H = I();
        } else {
            H = H();
        }
        if (H.hasFocusable()) {
            if (j == null) {
                return null;
            }
            return H;
        }
        return j;
    }
}
