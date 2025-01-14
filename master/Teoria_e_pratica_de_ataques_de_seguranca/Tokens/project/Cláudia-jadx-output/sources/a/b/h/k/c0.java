package a.b.h.k;

import android.content.Context;
import android.content.res.ColorStateList;
import android.view.View;
/* compiled from: CardViewApi21Impl.java */
/* loaded from: classes.dex */
public class c0 implements f0 {
    @Override // a.b.h.k.f0
    public void a() {
    }

    @Override // a.b.h.k.f0
    public void a(e0 e0Var, Context context, ColorStateList colorStateList, float f2, float f3, float f4) {
        e0Var.a(new z0(colorStateList, f2));
        View a2 = e0Var.a();
        a2.setClipToOutline(true);
        a2.setElevation(f3);
        b(e0Var, f4);
    }

    @Override // a.b.h.k.f0
    public void b(e0 e0Var, float f2) {
        i(e0Var).a(f2, e0Var.c(), e0Var.b());
        j(e0Var);
    }

    @Override // a.b.h.k.f0
    public void c(e0 e0Var, float f2) {
        i(e0Var).a(f2);
    }

    @Override // a.b.h.k.f0
    public void d(e0 e0Var) {
        b(e0Var, e(e0Var));
    }

    @Override // a.b.h.k.f0
    public float e(e0 e0Var) {
        return i(e0Var).b();
    }

    @Override // a.b.h.k.f0
    public float f(e0 e0Var) {
        return e0Var.a().getElevation();
    }

    @Override // a.b.h.k.f0
    public ColorStateList g(e0 e0Var) {
        return i(e0Var).a();
    }

    @Override // a.b.h.k.f0
    public float h(e0 e0Var) {
        return i(e0Var).c();
    }

    public final z0 i(e0 e0Var) {
        return (z0) e0Var.d();
    }

    public void j(e0 e0Var) {
        if (!e0Var.c()) {
            e0Var.a(0, 0, 0, 0);
            return;
        }
        float e2 = e(e0Var);
        float h2 = h(e0Var);
        int ceil = (int) Math.ceil(a1.a(e2, h2, e0Var.b()));
        int ceil2 = (int) Math.ceil(a1.b(e2, h2, e0Var.b()));
        e0Var.a(ceil, ceil2, ceil, ceil2);
    }

    @Override // a.b.h.k.f0
    public void c(e0 e0Var) {
        b(e0Var, e(e0Var));
    }

    @Override // a.b.h.k.f0
    public float b(e0 e0Var) {
        return h(e0Var) * 2.0f;
    }

    @Override // a.b.h.k.f0
    public float a(e0 e0Var) {
        return h(e0Var) * 2.0f;
    }

    @Override // a.b.h.k.f0
    public void a(e0 e0Var, float f2) {
        e0Var.a().setElevation(f2);
    }

    @Override // a.b.h.k.f0
    public void a(e0 e0Var, ColorStateList colorStateList) {
        i(e0Var).b(colorStateList);
    }
}
