package p000a.p006b.p030g.p034c.p035j;

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
import p000a.p006b.p030g.p034c.p035j.WrappedDrawableApi14;

/* renamed from: a.b.g.c.j.h */
/* loaded from: classes.dex */
public class WrappedDrawableApi21 extends WrappedDrawableApi14 {

    /* renamed from: h */
    public static Method f1454h;

    /* compiled from: WrappedDrawableApi21.java */
    /* renamed from: a.b.g.c.j.h$a */
    /* loaded from: classes.dex */
    public static class C0221a extends WrappedDrawableApi14.AbstractC0219a {
        public C0221a(WrappedDrawableApi14.AbstractC0219a abstractC0219a, Resources resources) {
            super(abstractC0219a, resources);
        }

        @Override // p000a.p006b.p030g.p034c.p035j.WrappedDrawableApi14.AbstractC0219a, android.graphics.drawable.Drawable.ConstantState
        public Drawable newDrawable(Resources resources) {
            return new WrappedDrawableApi21(this, resources);
        }
    }

    public WrappedDrawableApi21(Drawable drawable) {
        super(drawable);
        m9832d();
    }

    @Override // p000a.p006b.p030g.p034c.p035j.WrappedDrawableApi14
    /* renamed from: b */
    public boolean mo9834b() {
        if (Build.VERSION.SDK_INT == 21) {
            Drawable drawable = this.f1449f;
            return (drawable instanceof GradientDrawable) || (drawable instanceof DrawableContainer) || (drawable instanceof InsetDrawable) || (drawable instanceof RippleDrawable);
        }
        return false;
    }

    @Override // p000a.p006b.p030g.p034c.p035j.WrappedDrawableApi14
    /* renamed from: c */
    public WrappedDrawableApi14.AbstractC0219a mo9833c() {
        return new C0221a(this.f1447d, null);
    }

    /* renamed from: d */
    public final void m9832d() {
        if (f1454h == null) {
            try {
                f1454h = Drawable.class.getDeclaredMethod("isProjected", new Class[0]);
            } catch (Exception e) {
                Log.w("WrappedDrawableApi21", "Failed to retrieve Drawable#isProjected() method", e);
            }
        }
    }

    @Override // android.graphics.drawable.Drawable
    public Rect getDirtyBounds() {
        return this.f1449f.getDirtyBounds();
    }

    @Override // android.graphics.drawable.Drawable
    public void getOutline(Outline outline) {
        this.f1449f.getOutline(outline);
    }

    @Override // android.graphics.drawable.Drawable
    public boolean isProjected() {
        Method method;
        Drawable drawable = this.f1449f;
        if (drawable != null && (method = f1454h) != null) {
            try {
                return ((Boolean) method.invoke(drawable, new Object[0])).booleanValue();
            } catch (Exception e) {
                Log.w("WrappedDrawableApi21", "Error calling Drawable#isProjected() method", e);
            }
        }
        return false;
    }

    @Override // android.graphics.drawable.Drawable
    public void setHotspot(float f, float f2) {
        this.f1449f.setHotspot(f, f2);
    }

    @Override // android.graphics.drawable.Drawable
    public void setHotspotBounds(int i, int i2, int i3, int i4) {
        this.f1449f.setHotspotBounds(i, i2, i3, i4);
    }

    @Override // p000a.p006b.p030g.p034c.p035j.WrappedDrawableApi14, android.graphics.drawable.Drawable
    public boolean setState(int[] iArr) {
        if (super.setState(iArr)) {
            invalidateSelf();
            return true;
        }
        return false;
    }

    @Override // p000a.p006b.p030g.p034c.p035j.WrappedDrawableApi14, android.graphics.drawable.Drawable, p000a.p006b.p030g.p034c.p035j.TintAwareDrawable
    public void setTint(int i) {
        if (mo9834b()) {
            super.setTint(i);
        } else {
            this.f1449f.setTint(i);
        }
    }

    @Override // p000a.p006b.p030g.p034c.p035j.WrappedDrawableApi14, android.graphics.drawable.Drawable, p000a.p006b.p030g.p034c.p035j.TintAwareDrawable
    public void setTintList(ColorStateList colorStateList) {
        if (mo9834b()) {
            super.setTintList(colorStateList);
        } else {
            this.f1449f.setTintList(colorStateList);
        }
    }

    @Override // p000a.p006b.p030g.p034c.p035j.WrappedDrawableApi14, android.graphics.drawable.Drawable, p000a.p006b.p030g.p034c.p035j.TintAwareDrawable
    public void setTintMode(PorterDuff.Mode mode) {
        if (mo9834b()) {
            super.setTintMode(mode);
        } else {
            this.f1449f.setTintMode(mode);
        }
    }

    public WrappedDrawableApi21(WrappedDrawableApi14.AbstractC0219a abstractC0219a, Resources resources) {
        super(abstractC0219a, resources);
        m9832d();
    }
}
