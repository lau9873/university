package a.b.h.k;

import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.AttributeSet;
import android.view.View;
/* compiled from: AppCompatBackgroundHelper.java */
/* loaded from: classes.dex */
public class f {

    /* renamed from: a  reason: collision with root package name */
    public final View f1713a;

    /* renamed from: d  reason: collision with root package name */
    public j1 f1716d;

    /* renamed from: e  reason: collision with root package name */
    public j1 f1717e;

    /* renamed from: f  reason: collision with root package name */
    public j1 f1718f;

    /* renamed from: c  reason: collision with root package name */
    public int f1715c = -1;

    /* renamed from: b  reason: collision with root package name */
    public final k f1714b = k.a();

    public f(View view) {
        this.f1713a = view;
    }

    public void a(AttributeSet attributeSet, int i2) {
        l1 a2 = l1.a(this.f1713a.getContext(), attributeSet, a.b.h.b.j.ViewBackgroundHelper, i2, 0);
        try {
            if (a2.g(a.b.h.b.j.ViewBackgroundHelper_android_background)) {
                this.f1715c = a2.g(a.b.h.b.j.ViewBackgroundHelper_android_background, -1);
                ColorStateList d2 = this.f1714b.d(this.f1713a.getContext(), this.f1715c);
                if (d2 != null) {
                    a(d2);
                }
            }
            if (a2.g(a.b.h.b.j.ViewBackgroundHelper_backgroundTint)) {
                a.b.g.k.u.a(this.f1713a, a2.a(a.b.h.b.j.ViewBackgroundHelper_backgroundTint));
            }
            if (a2.g(a.b.h.b.j.ViewBackgroundHelper_backgroundTintMode)) {
                a.b.g.k.u.a(this.f1713a, k0.a(a2.d(a.b.h.b.j.ViewBackgroundHelper_backgroundTintMode, -1), null));
            }
        } finally {
            a2.a();
        }
    }

    public void b(Drawable drawable) {
        this.f1715c = -1;
        a((ColorStateList) null);
        a();
    }

    public PorterDuff.Mode c() {
        j1 j1Var = this.f1717e;
        if (j1Var != null) {
            return j1Var.f1793b;
        }
        return null;
    }

    public final boolean d() {
        int i2 = Build.VERSION.SDK_INT;
        return i2 > 21 ? this.f1716d != null : i2 == 21;
    }

    public void b(ColorStateList colorStateList) {
        if (this.f1717e == null) {
            this.f1717e = new j1();
        }
        j1 j1Var = this.f1717e;
        j1Var.f1792a = colorStateList;
        j1Var.f1795d = true;
        a();
    }

    public ColorStateList b() {
        j1 j1Var = this.f1717e;
        if (j1Var != null) {
            return j1Var.f1792a;
        }
        return null;
    }

    public void a(int i2) {
        this.f1715c = i2;
        k kVar = this.f1714b;
        a(kVar != null ? kVar.d(this.f1713a.getContext(), i2) : null);
        a();
    }

    public void a(PorterDuff.Mode mode) {
        if (this.f1717e == null) {
            this.f1717e = new j1();
        }
        j1 j1Var = this.f1717e;
        j1Var.f1793b = mode;
        j1Var.f1794c = true;
        a();
    }

    public void a() {
        Drawable background = this.f1713a.getBackground();
        if (background != null) {
            if (d() && a(background)) {
                return;
            }
            j1 j1Var = this.f1717e;
            if (j1Var != null) {
                k.a(background, j1Var, this.f1713a.getDrawableState());
                return;
            }
            j1 j1Var2 = this.f1716d;
            if (j1Var2 != null) {
                k.a(background, j1Var2, this.f1713a.getDrawableState());
            }
        }
    }

    public void a(ColorStateList colorStateList) {
        if (colorStateList != null) {
            if (this.f1716d == null) {
                this.f1716d = new j1();
            }
            j1 j1Var = this.f1716d;
            j1Var.f1792a = colorStateList;
            j1Var.f1795d = true;
        } else {
            this.f1716d = null;
        }
        a();
    }

    public final boolean a(Drawable drawable) {
        if (this.f1718f == null) {
            this.f1718f = new j1();
        }
        j1 j1Var = this.f1718f;
        j1Var.a();
        ColorStateList c2 = a.b.g.k.u.c(this.f1713a);
        if (c2 != null) {
            j1Var.f1795d = true;
            j1Var.f1792a = c2;
        }
        PorterDuff.Mode d2 = a.b.g.k.u.d(this.f1713a);
        if (d2 != null) {
            j1Var.f1794c = true;
            j1Var.f1793b = d2;
        }
        if (j1Var.f1795d || j1Var.f1794c) {
            k.a(drawable, j1Var, this.f1713a.getDrawableState());
            return true;
        }
        return false;
    }
}
