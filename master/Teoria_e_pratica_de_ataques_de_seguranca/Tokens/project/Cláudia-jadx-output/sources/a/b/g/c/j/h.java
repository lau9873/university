package a.b.g.c.j;

import a.b.g.c.j.g;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Outline;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.DrawableContainer;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.InsetDrawable;
import android.graphics.drawable.RippleDrawable;
import android.os.Build;
import android.util.Log;
import java.lang.reflect.Method;
/* compiled from: WrappedDrawableApi21.java */
/* loaded from: classes.dex */
public class h extends g {

    /* renamed from: h  reason: collision with root package name */
    public static Method f944h;

    /* compiled from: WrappedDrawableApi21.java */
    /* loaded from: classes.dex */
    public static class a extends g.a {
        public a(g.a aVar, Resources resources) {
            super(aVar, resources);
        }

        @Override // a.b.g.c.j.g.a, android.graphics.drawable.Drawable.ConstantState
        public Drawable newDrawable(Resources resources) {
            return new h(this, resources);
        }
    }

    public h(Drawable drawable) {
        super(drawable);
        d();
    }

    @Override // a.b.g.c.j.g
    public boolean b() {
        if (Build.VERSION.SDK_INT == 21) {
            Drawable drawable = this.f939f;
            return (drawable instanceof GradientDrawable) || (drawable instanceof DrawableContainer) || (drawable instanceof InsetDrawable) || (drawable instanceof RippleDrawable);
        }
        return false;
    }

    @Override // a.b.g.c.j.g
    public g.a c() {
        return new a(this.f937d, null);
    }

    public final void d() {
        if (f944h == null) {
            try {
                f944h = Drawable.class.getDeclaredMethod("isProjected", new Class[0]);
            } catch (Exception e2) {
                Log.w("WrappedDrawableApi21", "Failed to retrieve Drawable#isProjected() method", e2);
            }
        }
    }

    @Override // android.graphics.drawable.Drawable
    public Rect getDirtyBounds() {
        return this.f939f.getDirtyBounds();
    }

    @Override // android.graphics.drawable.Drawable
    public void getOutline(Outline outline) {
        this.f939f.getOutline(outline);
    }

    @Override // android.graphics.drawable.Drawable
    public boolean isProjected() {
        Method method;
        Drawable drawable = this.f939f;
        if (drawable != null && (method = f944h) != null) {
            try {
                return ((Boolean) method.invoke(drawable, new Object[0])).booleanValue();
            } catch (Exception e2) {
                Log.w("WrappedDrawableApi21", "Error calling Drawable#isProjected() method", e2);
            }
        }
        return false;
    }

    @Override // android.graphics.drawable.Drawable
    public void setHotspot(float f2, float f3) {
        this.f939f.setHotspot(f2, f3);
    }

    @Override // android.graphics.drawable.Drawable
    public void setHotspotBounds(int i2, int i3, int i4, int i5) {
        this.f939f.setHotspotBounds(i2, i3, i4, i5);
    }

    @Override // a.b.g.c.j.g, android.graphics.drawable.Drawable
    public boolean setState(int[] iArr) {
        if (super.setState(iArr)) {
            invalidateSelf();
            return true;
        }
        return false;
    }

    @Override // a.b.g.c.j.g, android.graphics.drawable.Drawable, a.b.g.c.j.e
    public void setTint(int i2) {
        if (b()) {
            super.setTint(i2);
        } else {
            this.f939f.setTint(i2);
        }
    }

    @Override // a.b.g.c.j.g, android.graphics.drawable.Drawable, a.b.g.c.j.e
    public void setTintList(ColorStateList colorStateList) {
        if (b()) {
            super.setTintList(colorStateList);
        } else {
            this.f939f.setTintList(colorStateList);
        }
    }

    @Override // a.b.g.c.j.g, android.graphics.drawable.Drawable, a.b.g.c.j.e
    public void setTintMode(PorterDuff.Mode mode) {
        if (b()) {
            super.setTintMode(mode);
        } else {
            this.f939f.setTintMode(mode);
        }
    }

    public h(g.a aVar, Resources resources) {
        super(aVar, resources);
        d();
    }
}
