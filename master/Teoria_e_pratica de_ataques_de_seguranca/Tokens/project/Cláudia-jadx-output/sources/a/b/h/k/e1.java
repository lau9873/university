package a.b.h.k;

import android.support.v7.widget.RecyclerView;
import android.view.View;
/* compiled from: SimpleItemAnimator.java */
/* loaded from: classes.dex */
public abstract class e1 extends RecyclerView.l {

    /* renamed from: g  reason: collision with root package name */
    public boolean f1712g = true;

    @Override // android.support.v7.widget.RecyclerView.l
    public boolean a(RecyclerView.d0 d0Var) {
        return !this.f1712g || d0Var.p();
    }

    public abstract boolean a(RecyclerView.d0 d0Var, int i2, int i3, int i4, int i5);

    public abstract boolean a(RecyclerView.d0 d0Var, RecyclerView.d0 d0Var2, int i2, int i3, int i4, int i5);

    @Override // android.support.v7.widget.RecyclerView.l
    public boolean b(RecyclerView.d0 d0Var, RecyclerView.l.c cVar, RecyclerView.l.c cVar2) {
        int i2 = cVar.f2599a;
        int i3 = cVar.f2600b;
        View view = d0Var.f2580a;
        int left = cVar2 == null ? view.getLeft() : cVar2.f2599a;
        int top = cVar2 == null ? view.getTop() : cVar2.f2600b;
        if (!d0Var.r() && (i2 != left || i3 != top)) {
            view.layout(left, top, view.getWidth() + left, view.getHeight() + top);
            return a(d0Var, i2, i3, left, top);
        }
        return i(d0Var);
    }

    public void c(RecyclerView.d0 d0Var, boolean z) {
    }

    @Override // android.support.v7.widget.RecyclerView.l
    public boolean c(RecyclerView.d0 d0Var, RecyclerView.l.c cVar, RecyclerView.l.c cVar2) {
        if (cVar.f2599a == cVar2.f2599a && cVar.f2600b == cVar2.f2600b) {
            l(d0Var);
            return false;
        }
        return a(d0Var, cVar.f2599a, cVar.f2600b, cVar2.f2599a, cVar2.f2600b);
    }

    public void d(RecyclerView.d0 d0Var, boolean z) {
    }

    public abstract boolean h(RecyclerView.d0 d0Var);

    public abstract boolean i(RecyclerView.d0 d0Var);

    public final void j(RecyclerView.d0 d0Var) {
        p(d0Var);
        b(d0Var);
    }

    public final void k(RecyclerView.d0 d0Var) {
        q(d0Var);
    }

    public final void l(RecyclerView.d0 d0Var) {
        r(d0Var);
        b(d0Var);
    }

    public final void m(RecyclerView.d0 d0Var) {
        s(d0Var);
    }

    public final void n(RecyclerView.d0 d0Var) {
        t(d0Var);
        b(d0Var);
    }

    public final void o(RecyclerView.d0 d0Var) {
        u(d0Var);
    }

    public void p(RecyclerView.d0 d0Var) {
    }

    public void q(RecyclerView.d0 d0Var) {
    }

    public void r(RecyclerView.d0 d0Var) {
    }

    public void s(RecyclerView.d0 d0Var) {
    }

    public void t(RecyclerView.d0 d0Var) {
    }

    public void u(RecyclerView.d0 d0Var) {
    }

    @Override // android.support.v7.widget.RecyclerView.l
    public boolean a(RecyclerView.d0 d0Var, RecyclerView.l.c cVar, RecyclerView.l.c cVar2) {
        if (cVar != null && (cVar.f2599a != cVar2.f2599a || cVar.f2600b != cVar2.f2600b)) {
            return a(d0Var, cVar.f2599a, cVar.f2600b, cVar2.f2599a, cVar2.f2600b);
        }
        return h(d0Var);
    }

    @Override // android.support.v7.widget.RecyclerView.l
    public boolean a(RecyclerView.d0 d0Var, RecyclerView.d0 d0Var2, RecyclerView.l.c cVar, RecyclerView.l.c cVar2) {
        int i2;
        int i3;
        int i4 = cVar.f2599a;
        int i5 = cVar.f2600b;
        if (d0Var2.z()) {
            int i6 = cVar.f2599a;
            i3 = cVar.f2600b;
            i2 = i6;
        } else {
            i2 = cVar2.f2599a;
            i3 = cVar2.f2600b;
        }
        return a(d0Var, d0Var2, i4, i5, i2, i3);
    }

    public final void b(RecyclerView.d0 d0Var, boolean z) {
        d(d0Var, z);
    }

    public final void a(RecyclerView.d0 d0Var, boolean z) {
        c(d0Var, z);
        b(d0Var);
    }
}
