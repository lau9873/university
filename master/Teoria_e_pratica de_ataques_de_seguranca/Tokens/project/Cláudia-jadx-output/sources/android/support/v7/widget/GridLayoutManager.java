package android.support.v7.widget;

import a.b.g.k.e0.c;
import android.content.Context;
import android.graphics.Rect;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseIntArray;
import android.view.View;
import android.view.ViewGroup;
/* loaded from: classes.dex */
public class GridLayoutManager extends LinearLayoutManager {
    public boolean H;
    public int I;
    public int[] J;
    public View[] K;
    public final SparseIntArray L;
    public final SparseIntArray M;
    public c N;
    public final Rect O;

    /* loaded from: classes.dex */
    public static final class a extends c {
        @Override // android.support.v7.widget.GridLayoutManager.c
        public int a(int i2) {
            return 1;
        }

        @Override // android.support.v7.widget.GridLayoutManager.c
        public int c(int i2, int i3) {
            return i2 % i3;
        }
    }

    /* loaded from: classes.dex */
    public static abstract class c {

        /* renamed from: a  reason: collision with root package name */
        public final SparseIntArray f2529a = new SparseIntArray();

        /* renamed from: b  reason: collision with root package name */
        public boolean f2530b = false;

        public abstract int a(int i2);

        public void a() {
            this.f2529a.clear();
        }

        public int b(int i2, int i3) {
            int a2 = a(i2);
            int i4 = 0;
            int i5 = 0;
            for (int i6 = 0; i6 < i2; i6++) {
                int a3 = a(i6);
                i4 += a3;
                if (i4 == i3) {
                    i5++;
                    i4 = 0;
                } else if (i4 > i3) {
                    i5++;
                    i4 = a3;
                }
            }
            return i4 + a2 > i3 ? i5 + 1 : i5;
        }

        public abstract int c(int i2, int i3);

        public int a(int i2, int i3) {
            if (!this.f2530b) {
                return c(i2, i3);
            }
            int i4 = this.f2529a.get(i2, -1);
            if (i4 != -1) {
                return i4;
            }
            int c2 = c(i2, i3);
            this.f2529a.put(i2, c2);
            return c2;
        }
    }

    public GridLayoutManager(Context context, AttributeSet attributeSet, int i2, int i3) {
        super(context, attributeSet, i2, i3);
        this.H = false;
        this.I = -1;
        this.L = new SparseIntArray();
        this.M = new SparseIntArray();
        this.N = new a();
        this.O = new Rect();
        l(RecyclerView.o.a(context, attributeSet, i2, i3).f2614b);
    }

    @Override // android.support.v7.widget.LinearLayoutManager, android.support.v7.widget.RecyclerView.o
    public boolean C() {
        return this.D == null && !this.H;
    }

    public final void N() {
        int e2 = e();
        for (int i2 = 0; i2 < e2; i2++) {
            b bVar = (b) c(i2).getLayoutParams();
            int a2 = bVar.a();
            this.L.put(a2, bVar.f());
            this.M.put(a2, bVar.e());
        }
    }

    public final void O() {
        this.L.clear();
        this.M.clear();
    }

    public final void P() {
        View[] viewArr = this.K;
        if (viewArr == null || viewArr.length != this.I) {
            this.K = new View[this.I];
        }
    }

    public final void Q() {
        int h2;
        int p;
        if (J() == 1) {
            h2 = q() - o();
            p = n();
        } else {
            h2 = h() - m();
            p = p();
        }
        k(h2 - p);
    }

    @Override // android.support.v7.widget.RecyclerView.o
    public int a(RecyclerView.v vVar, RecyclerView.a0 a0Var) {
        if (this.s == 1) {
            return this.I;
        }
        if (a0Var.a() < 1) {
            return 0;
        }
        return a(vVar, a0Var, a0Var.a() - 1) + 1;
    }

    @Override // android.support.v7.widget.LinearLayoutManager
    public void b(boolean z) {
        if (!z) {
            super.b(false);
            return;
        }
        throw new UnsupportedOperationException("GridLayoutManager does not support stack from end. Consider using reverse layout");
    }

    @Override // android.support.v7.widget.RecyclerView.o
    public void c(RecyclerView recyclerView, int i2, int i3) {
        this.N.a();
    }

    @Override // android.support.v7.widget.RecyclerView.o
    public void d(RecyclerView recyclerView) {
        this.N.a();
    }

    @Override // android.support.v7.widget.LinearLayoutManager, android.support.v7.widget.RecyclerView.o
    public void e(RecyclerView.v vVar, RecyclerView.a0 a0Var) {
        if (a0Var.d()) {
            N();
        }
        super.e(vVar, a0Var);
        O();
    }

    @Override // android.support.v7.widget.LinearLayoutManager, android.support.v7.widget.RecyclerView.o
    public void g(RecyclerView.a0 a0Var) {
        super.g(a0Var);
        this.H = false;
    }

    public int h(int i2, int i3) {
        if (this.s == 1 && K()) {
            int[] iArr = this.J;
            int i4 = this.I;
            return iArr[i4 - i2] - iArr[(i4 - i2) - i3];
        }
        int[] iArr2 = this.J;
        return iArr2[i3 + i2] - iArr2[i2];
    }

    public final void k(int i2) {
        this.J = a(this.J, this.I, i2);
    }

    public void l(int i2) {
        if (i2 == this.I) {
            return;
        }
        this.H = true;
        if (i2 >= 1) {
            this.I = i2;
            this.N.a();
            y();
            return;
        }
        throw new IllegalArgumentException("Span count should be at least 1. Provided " + i2);
    }

    @Override // android.support.v7.widget.LinearLayoutManager, android.support.v7.widget.RecyclerView.o
    public RecyclerView.p c() {
        if (this.s == 0) {
            return new b(-2, -1);
        }
        return new b(-1, -2);
    }

    /* loaded from: classes.dex */
    public static class b extends RecyclerView.p {

        /* renamed from: e  reason: collision with root package name */
        public int f2527e;

        /* renamed from: f  reason: collision with root package name */
        public int f2528f;

        public b(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            this.f2527e = -1;
            this.f2528f = 0;
        }

        public int e() {
            return this.f2527e;
        }

        public int f() {
            return this.f2528f;
        }

        public b(int i2, int i3) {
            super(i2, i3);
            this.f2527e = -1;
            this.f2528f = 0;
        }

        public b(ViewGroup.MarginLayoutParams marginLayoutParams) {
            super(marginLayoutParams);
            this.f2527e = -1;
            this.f2528f = 0;
        }

        public b(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
            this.f2527e = -1;
            this.f2528f = 0;
        }
    }

    @Override // android.support.v7.widget.RecyclerView.o
    public int b(RecyclerView.v vVar, RecyclerView.a0 a0Var) {
        if (this.s == 0) {
            return this.I;
        }
        if (a0Var.a() < 1) {
            return 0;
        }
        return a(vVar, a0Var, a0Var.a() - 1) + 1;
    }

    @Override // android.support.v7.widget.RecyclerView.o
    public void a(RecyclerView.v vVar, RecyclerView.a0 a0Var, View view, a.b.g.k.e0.c cVar) {
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (!(layoutParams instanceof b)) {
            super.a(view, cVar);
            return;
        }
        b bVar = (b) layoutParams;
        int a2 = a(vVar, a0Var, bVar.a());
        if (this.s == 0) {
            cVar.b(c.b.a(bVar.e(), bVar.f(), a2, 1, this.I > 1 && bVar.f() == this.I, false));
        } else {
            cVar.b(c.b.a(a2, 1, bVar.e(), bVar.f(), this.I > 1 && bVar.f() == this.I, false));
        }
    }

    public final int c(RecyclerView.v vVar, RecyclerView.a0 a0Var, int i2) {
        if (!a0Var.d()) {
            return this.N.a(i2);
        }
        int i3 = this.L.get(i2, -1);
        if (i3 != -1) {
            return i3;
        }
        int a2 = vVar.a(i2);
        if (a2 == -1) {
            Log.w("GridLayoutManager", "Cannot find span size for pre layout position. It is not cached, not in the adapter. Pos:" + i2);
            return 1;
        }
        return this.N.a(a2);
    }

    @Override // android.support.v7.widget.RecyclerView.o
    public void b(RecyclerView recyclerView, int i2, int i3) {
        this.N.a();
    }

    @Override // android.support.v7.widget.LinearLayoutManager, android.support.v7.widget.RecyclerView.o
    public int b(int i2, RecyclerView.v vVar, RecyclerView.a0 a0Var) {
        Q();
        P();
        return super.b(i2, vVar, a0Var);
    }

    public final void b(RecyclerView.v vVar, RecyclerView.a0 a0Var, LinearLayoutManager.a aVar, int i2) {
        boolean z = i2 == 1;
        int b2 = b(vVar, a0Var, aVar.f2532b);
        if (z) {
            while (b2 > 0) {
                int i3 = aVar.f2532b;
                if (i3 <= 0) {
                    return;
                }
                aVar.f2532b = i3 - 1;
                b2 = b(vVar, a0Var, aVar.f2532b);
            }
            return;
        }
        int a2 = a0Var.a() - 1;
        int i4 = aVar.f2532b;
        while (i4 < a2) {
            int i5 = i4 + 1;
            int b3 = b(vVar, a0Var, i5);
            if (b3 <= b2) {
                break;
            }
            i4 = i5;
            b2 = b3;
        }
        aVar.f2532b = i4;
    }

    @Override // android.support.v7.widget.RecyclerView.o
    public void a(RecyclerView recyclerView, int i2, int i3, Object obj) {
        this.N.a();
    }

    @Override // android.support.v7.widget.RecyclerView.o
    public void a(RecyclerView recyclerView, int i2, int i3, int i4) {
        this.N.a();
    }

    @Override // android.support.v7.widget.RecyclerView.o
    public RecyclerView.p a(Context context, AttributeSet attributeSet) {
        return new b(context, attributeSet);
    }

    public final int b(RecyclerView.v vVar, RecyclerView.a0 a0Var, int i2) {
        if (!a0Var.d()) {
            return this.N.a(i2, this.I);
        }
        int i3 = this.M.get(i2, -1);
        if (i3 != -1) {
            return i3;
        }
        int a2 = vVar.a(i2);
        if (a2 == -1) {
            Log.w("GridLayoutManager", "Cannot find span size for pre layout position. It is not cached, not in the adapter. Pos:" + i2);
            return 0;
        }
        return this.N.a(a2, this.I);
    }

    @Override // android.support.v7.widget.RecyclerView.o
    public RecyclerView.p a(ViewGroup.LayoutParams layoutParams) {
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            return new b((ViewGroup.MarginLayoutParams) layoutParams);
        }
        return new b(layoutParams);
    }

    @Override // android.support.v7.widget.RecyclerView.o
    public boolean a(RecyclerView.p pVar) {
        return pVar instanceof b;
    }

    @Override // android.support.v7.widget.RecyclerView.o
    public void a(Rect rect, int i2, int i3) {
        int a2;
        int a3;
        if (this.J == null) {
            super.a(rect, i2, i3);
        }
        int n = n() + o();
        int p = p() + m();
        if (this.s == 1) {
            a3 = RecyclerView.o.a(i3, rect.height() + p, k());
            int[] iArr = this.J;
            a2 = RecyclerView.o.a(i2, iArr[iArr.length - 1] + n, l());
        } else {
            a2 = RecyclerView.o.a(i2, rect.width() + n, l());
            int[] iArr2 = this.J;
            a3 = RecyclerView.o.a(i3, iArr2[iArr2.length - 1] + p, k());
        }
        c(a2, a3);
    }

    public final void b(View view, int i2, boolean z) {
        int i3;
        int i4;
        b bVar = (b) view.getLayoutParams();
        Rect rect = bVar.f2618b;
        int i5 = rect.top + rect.bottom + ((ViewGroup.MarginLayoutParams) bVar).topMargin + ((ViewGroup.MarginLayoutParams) bVar).bottomMargin;
        int i6 = rect.left + rect.right + ((ViewGroup.MarginLayoutParams) bVar).leftMargin + ((ViewGroup.MarginLayoutParams) bVar).rightMargin;
        int h2 = h(bVar.f2527e, bVar.f2528f);
        if (this.s == 1) {
            i4 = RecyclerView.o.a(h2, i2, i6, ((ViewGroup.MarginLayoutParams) bVar).width, false);
            i3 = RecyclerView.o.a(this.u.g(), i(), i5, ((ViewGroup.MarginLayoutParams) bVar).height, true);
        } else {
            int a2 = RecyclerView.o.a(h2, i2, i5, ((ViewGroup.MarginLayoutParams) bVar).height, false);
            int a3 = RecyclerView.o.a(this.u.g(), r(), i6, ((ViewGroup.MarginLayoutParams) bVar).width, true);
            i3 = a2;
            i4 = a3;
        }
        a(view, i4, i3, z);
    }

    public static int[] a(int[] iArr, int i2, int i3) {
        int i4;
        if (iArr == null || iArr.length != i2 + 1 || iArr[iArr.length - 1] != i3) {
            iArr = new int[i2 + 1];
        }
        int i5 = 0;
        iArr[0] = 0;
        int i6 = i3 / i2;
        int i7 = i3 % i2;
        int i8 = 0;
        for (int i9 = 1; i9 <= i2; i9++) {
            i5 += i7;
            if (i5 <= 0 || i2 - i5 >= i7) {
                i4 = i6;
            } else {
                i4 = i6 + 1;
                i5 -= i2;
            }
            i8 += i4;
            iArr[i9] = i8;
        }
        return iArr;
    }

    @Override // android.support.v7.widget.LinearLayoutManager
    public void a(RecyclerView.v vVar, RecyclerView.a0 a0Var, LinearLayoutManager.a aVar, int i2) {
        super.a(vVar, a0Var, aVar, i2);
        Q();
        if (a0Var.a() > 0 && !a0Var.d()) {
            b(vVar, a0Var, aVar, i2);
        }
        P();
    }

    @Override // android.support.v7.widget.LinearLayoutManager, android.support.v7.widget.RecyclerView.o
    public int a(int i2, RecyclerView.v vVar, RecyclerView.a0 a0Var) {
        Q();
        P();
        return super.a(i2, vVar, a0Var);
    }

    @Override // android.support.v7.widget.LinearLayoutManager
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
            if (l >= 0 && l < i4 && b(vVar, a0Var, l) == 0) {
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

    public final int a(RecyclerView.v vVar, RecyclerView.a0 a0Var, int i2) {
        if (!a0Var.d()) {
            return this.N.b(i2, this.I);
        }
        int a2 = vVar.a(i2);
        if (a2 == -1) {
            Log.w("GridLayoutManager", "Cannot find span size for pre layout position. " + i2);
            return 0;
        }
        return this.N.b(a2, this.I);
    }

    @Override // android.support.v7.widget.LinearLayoutManager
    public void a(RecyclerView.a0 a0Var, LinearLayoutManager.c cVar, RecyclerView.o.c cVar2) {
        int i2 = this.I;
        for (int i3 = 0; i3 < this.I && cVar.a(a0Var) && i2 > 0; i3++) {
            int i4 = cVar.f2543d;
            cVar2.a(i4, Math.max(0, cVar.f2546g));
            i2 -= this.N.a(i4);
            cVar.f2543d += cVar.f2544e;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:37:0x00a1, code lost:
        r22.f2537b = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:38:0x00a3, code lost:
        return;
     */
    @Override // android.support.v7.widget.LinearLayoutManager
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void a(android.support.v7.widget.RecyclerView.v r19, android.support.v7.widget.RecyclerView.a0 r20, android.support.v7.widget.LinearLayoutManager.c r21, android.support.v7.widget.LinearLayoutManager.b r22) {
        /*
            Method dump skipped, instructions count: 574
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v7.widget.GridLayoutManager.a(android.support.v7.widget.RecyclerView$v, android.support.v7.widget.RecyclerView$a0, android.support.v7.widget.LinearLayoutManager$c, android.support.v7.widget.LinearLayoutManager$b):void");
    }

    public final void a(float f2, int i2) {
        k(Math.max(Math.round(f2 * this.I), i2));
    }

    public final void a(View view, int i2, int i3, boolean z) {
        boolean a2;
        RecyclerView.p pVar = (RecyclerView.p) view.getLayoutParams();
        if (z) {
            a2 = b(view, i2, i3, pVar);
        } else {
            a2 = a(view, i2, i3, pVar);
        }
        if (a2) {
            view.measure(i2, i3);
        }
    }

    public final void a(RecyclerView.v vVar, RecyclerView.a0 a0Var, int i2, int i3, boolean z) {
        int i4;
        int i5;
        int i6 = 0;
        int i7 = -1;
        if (z) {
            i7 = i2;
            i4 = 0;
            i5 = 1;
        } else {
            i4 = i2 - 1;
            i5 = -1;
        }
        while (i4 != i7) {
            View view = this.K[i4];
            b bVar = (b) view.getLayoutParams();
            bVar.f2528f = c(vVar, a0Var, l(view));
            bVar.f2527e = i6;
            i6 += bVar.f2528f;
            i4 += i5;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:59:0x00d7, code lost:
        if (r13 == (r2 > r8)) goto L65;
     */
    /* JADX WARN: Code restructure failed: missing block: B:71:0x00f7, code lost:
        if (r13 == (r2 > r10)) goto L51;
     */
    /* JADX WARN: Removed duplicated region for block: B:77:0x0105  */
    @Override // android.support.v7.widget.LinearLayoutManager, android.support.v7.widget.RecyclerView.o
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public android.view.View a(android.view.View r24, int r25, android.support.v7.widget.RecyclerView.v r26, android.support.v7.widget.RecyclerView.a0 r27) {
        /*
            Method dump skipped, instructions count: 335
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v7.widget.GridLayoutManager.a(android.view.View, int, android.support.v7.widget.RecyclerView$v, android.support.v7.widget.RecyclerView$a0):android.view.View");
    }
}
