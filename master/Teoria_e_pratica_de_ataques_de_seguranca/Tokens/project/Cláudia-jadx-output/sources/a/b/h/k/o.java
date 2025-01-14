package a.b.h.k;

import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.RippleDrawable;
import android.os.Build;
import android.util.AttributeSet;
import android.widget.ImageView;
/* compiled from: AppCompatImageHelper.java */
/* loaded from: classes.dex */
public class o {

    /* renamed from: a  reason: collision with root package name */
    public final ImageView f1854a;

    /* renamed from: b  reason: collision with root package name */
    public j1 f1855b;

    /* renamed from: c  reason: collision with root package name */
    public j1 f1856c;

    /* renamed from: d  reason: collision with root package name */
    public j1 f1857d;

    public o(ImageView imageView) {
        this.f1854a = imageView;
    }

    public void a(AttributeSet attributeSet, int i2) {
        int g2;
        l1 a2 = l1.a(this.f1854a.getContext(), attributeSet, a.b.h.b.j.AppCompatImageView, i2, 0);
        try {
            Drawable drawable = this.f1854a.getDrawable();
            if (drawable == null && (g2 = a2.g(a.b.h.b.j.AppCompatImageView_srcCompat, -1)) != -1 && (drawable = a.b.h.d.a.a.c(this.f1854a.getContext(), g2)) != null) {
                this.f1854a.setImageDrawable(drawable);
            }
            if (drawable != null) {
                k0.b(drawable);
            }
            if (a2.g(a.b.h.b.j.AppCompatImageView_tint)) {
                a.b.g.l.j.a(this.f1854a, a2.a(a.b.h.b.j.AppCompatImageView_tint));
            }
            if (a2.g(a.b.h.b.j.AppCompatImageView_tintMode)) {
                a.b.g.l.j.a(this.f1854a, k0.a(a2.d(a.b.h.b.j.AppCompatImageView_tintMode, -1), null));
            }
        } finally {
            a2.a();
        }
    }

    public ColorStateList b() {
        j1 j1Var = this.f1856c;
        if (j1Var != null) {
            return j1Var.f1792a;
        }
        return null;
    }

    public PorterDuff.Mode c() {
        j1 j1Var = this.f1856c;
        if (j1Var != null) {
            return j1Var.f1793b;
        }
        return null;
    }

    public boolean d() {
        return Build.VERSION.SDK_INT < 21 || !(this.f1854a.getBackground() instanceof RippleDrawable);
    }

    public final boolean e() {
        int i2 = Build.VERSION.SDK_INT;
        return i2 > 21 ? this.f1855b != null : i2 == 21;
    }

    public void a(int i2) {
        if (i2 != 0) {
            Drawable c2 = a.b.h.d.a.a.c(this.f1854a.getContext(), i2);
            if (c2 != null) {
                k0.b(c2);
            }
            this.f1854a.setImageDrawable(c2);
        } else {
            this.f1854a.setImageDrawable(null);
        }
        a();
    }

    public void a(ColorStateList colorStateList) {
        if (this.f1856c == null) {
            this.f1856c = new j1();
        }
        j1 j1Var = this.f1856c;
        j1Var.f1792a = colorStateList;
        j1Var.f1795d = true;
        a();
    }

    public void a(PorterDuff.Mode mode) {
        if (this.f1856c == null) {
            this.f1856c = new j1();
        }
        j1 j1Var = this.f1856c;
        j1Var.f1793b = mode;
        j1Var.f1794c = true;
        a();
    }

    public void a() {
        Drawable drawable = this.f1854a.getDrawable();
        if (drawable != null) {
            k0.b(drawable);
        }
        if (drawable != null) {
            if (e() && a(drawable)) {
                return;
            }
            j1 j1Var = this.f1856c;
            if (j1Var != null) {
                k.a(drawable, j1Var, this.f1854a.getDrawableState());
                return;
            }
            j1 j1Var2 = this.f1855b;
            if (j1Var2 != null) {
                k.a(drawable, j1Var2, this.f1854a.getDrawableState());
            }
        }
    }

    public final boolean a(Drawable drawable) {
        if (this.f1857d == null) {
            this.f1857d = new j1();
        }
        j1 j1Var = this.f1857d;
        j1Var.a();
        ColorStateList a2 = a.b.g.l.j.a(this.f1854a);
        if (a2 != null) {
            j1Var.f1795d = true;
            j1Var.f1792a = a2;
        }
        PorterDuff.Mode b2 = a.b.g.l.j.b(this.f1854a);
        if (b2 != null) {
            j1Var.f1794c = true;
            j1Var.f1793b = b2;
        }
        if (j1Var.f1795d || j1Var.f1794c) {
            k.a(drawable, j1Var, this.f1854a.getDrawableState());
            return true;
        }
        return false;
    }
}
