package a.b.g.c.j;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.Region;
import android.graphics.drawable.Drawable;
/* compiled from: WrappedDrawableApi14.java */
/* loaded from: classes.dex */
public class g extends Drawable implements Drawable.Callback, f, e {

    /* renamed from: g  reason: collision with root package name */
    public static final PorterDuff.Mode f933g = PorterDuff.Mode.SRC_IN;

    /* renamed from: a  reason: collision with root package name */
    public int f934a;

    /* renamed from: b  reason: collision with root package name */
    public PorterDuff.Mode f935b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f936c;

    /* renamed from: d  reason: collision with root package name */
    public a f937d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f938e;

    /* renamed from: f  reason: collision with root package name */
    public Drawable f939f;

    /* compiled from: WrappedDrawableApi14.java */
    /* loaded from: classes.dex */
    public static abstract class a extends Drawable.ConstantState {

        /* renamed from: a  reason: collision with root package name */
        public int f940a;

        /* renamed from: b  reason: collision with root package name */
        public Drawable.ConstantState f941b;

        /* renamed from: c  reason: collision with root package name */
        public ColorStateList f942c;

        /* renamed from: d  reason: collision with root package name */
        public PorterDuff.Mode f943d;

        public a(a aVar, Resources resources) {
            this.f942c = null;
            this.f943d = g.f933g;
            if (aVar != null) {
                this.f940a = aVar.f940a;
                this.f941b = aVar.f941b;
                this.f942c = aVar.f942c;
                this.f943d = aVar.f943d;
            }
        }

        public boolean a() {
            return this.f941b != null;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public int getChangingConfigurations() {
            int i2 = this.f940a;
            Drawable.ConstantState constantState = this.f941b;
            return i2 | (constantState != null ? constantState.getChangingConfigurations() : 0);
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public Drawable newDrawable() {
            return newDrawable(null);
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public abstract Drawable newDrawable(Resources resources);
    }

    /* compiled from: WrappedDrawableApi14.java */
    /* loaded from: classes.dex */
    public static class b extends a {
        public b(a aVar, Resources resources) {
            super(aVar, resources);
        }

        @Override // a.b.g.c.j.g.a, android.graphics.drawable.Drawable.ConstantState
        public Drawable newDrawable(Resources resources) {
            return new g(this, resources);
        }
    }

    public g(a aVar, Resources resources) {
        this.f937d = aVar;
        a(resources);
    }

    public final void a(Resources resources) {
        Drawable.ConstantState constantState;
        a aVar = this.f937d;
        if (aVar == null || (constantState = aVar.f941b) == null) {
            return;
        }
        a(constantState.newDrawable(resources));
    }

    public boolean b() {
        return true;
    }

    public a c() {
        return new b(this.f937d, null);
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        this.f939f.draw(canvas);
    }

    @Override // android.graphics.drawable.Drawable
    public int getChangingConfigurations() {
        int changingConfigurations = super.getChangingConfigurations();
        a aVar = this.f937d;
        return changingConfigurations | (aVar != null ? aVar.getChangingConfigurations() : 0) | this.f939f.getChangingConfigurations();
    }

    @Override // android.graphics.drawable.Drawable
    public Drawable.ConstantState getConstantState() {
        a aVar = this.f937d;
        if (aVar == null || !aVar.a()) {
            return null;
        }
        this.f937d.f940a = getChangingConfigurations();
        return this.f937d;
    }

    @Override // android.graphics.drawable.Drawable
    public Drawable getCurrent() {
        return this.f939f.getCurrent();
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        return this.f939f.getIntrinsicHeight();
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        return this.f939f.getIntrinsicWidth();
    }

    @Override // android.graphics.drawable.Drawable
    public int getMinimumHeight() {
        return this.f939f.getMinimumHeight();
    }

    @Override // android.graphics.drawable.Drawable
    public int getMinimumWidth() {
        return this.f939f.getMinimumWidth();
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return this.f939f.getOpacity();
    }

    @Override // android.graphics.drawable.Drawable
    public boolean getPadding(Rect rect) {
        return this.f939f.getPadding(rect);
    }

    @Override // android.graphics.drawable.Drawable
    public int[] getState() {
        return this.f939f.getState();
    }

    @Override // android.graphics.drawable.Drawable
    public Region getTransparentRegion() {
        return this.f939f.getTransparentRegion();
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public void invalidateDrawable(Drawable drawable) {
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public boolean isAutoMirrored() {
        return this.f939f.isAutoMirrored();
    }

    @Override // android.graphics.drawable.Drawable
    public boolean isStateful() {
        a aVar;
        ColorStateList colorStateList = (!b() || (aVar = this.f937d) == null) ? null : aVar.f942c;
        return (colorStateList != null && colorStateList.isStateful()) || this.f939f.isStateful();
    }

    @Override // android.graphics.drawable.Drawable
    public void jumpToCurrentState() {
        this.f939f.jumpToCurrentState();
    }

    @Override // android.graphics.drawable.Drawable
    public Drawable mutate() {
        if (!this.f938e && super.mutate() == this) {
            this.f937d = c();
            Drawable drawable = this.f939f;
            if (drawable != null) {
                drawable.mutate();
            }
            a aVar = this.f937d;
            if (aVar != null) {
                Drawable drawable2 = this.f939f;
                aVar.f941b = drawable2 != null ? drawable2.getConstantState() : null;
            }
            this.f938e = true;
        }
        return this;
    }

    @Override // android.graphics.drawable.Drawable
    public void onBoundsChange(Rect rect) {
        Drawable drawable = this.f939f;
        if (drawable != null) {
            drawable.setBounds(rect);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public boolean onLevelChange(int i2) {
        return this.f939f.setLevel(i2);
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public void scheduleDrawable(Drawable drawable, Runnable runnable, long j) {
        scheduleSelf(runnable, j);
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i2) {
        this.f939f.setAlpha(i2);
    }

    @Override // android.graphics.drawable.Drawable
    public void setAutoMirrored(boolean z) {
        this.f939f.setAutoMirrored(z);
    }

    @Override // android.graphics.drawable.Drawable
    public void setChangingConfigurations(int i2) {
        this.f939f.setChangingConfigurations(i2);
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        this.f939f.setColorFilter(colorFilter);
    }

    @Override // android.graphics.drawable.Drawable
    public void setDither(boolean z) {
        this.f939f.setDither(z);
    }

    @Override // android.graphics.drawable.Drawable
    public void setFilterBitmap(boolean z) {
        this.f939f.setFilterBitmap(z);
    }

    @Override // android.graphics.drawable.Drawable
    public boolean setState(int[] iArr) {
        return a(iArr) || this.f939f.setState(iArr);
    }

    @Override // android.graphics.drawable.Drawable, a.b.g.c.j.e
    public void setTint(int i2) {
        setTintList(ColorStateList.valueOf(i2));
    }

    @Override // android.graphics.drawable.Drawable, a.b.g.c.j.e
    public void setTintList(ColorStateList colorStateList) {
        this.f937d.f942c = colorStateList;
        a(getState());
    }

    @Override // android.graphics.drawable.Drawable, a.b.g.c.j.e
    public void setTintMode(PorterDuff.Mode mode) {
        this.f937d.f943d = mode;
        a(getState());
    }

    @Override // android.graphics.drawable.Drawable
    public boolean setVisible(boolean z, boolean z2) {
        return super.setVisible(z, z2) || this.f939f.setVisible(z, z2);
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public void unscheduleDrawable(Drawable drawable, Runnable runnable) {
        unscheduleSelf(runnable);
    }

    public final boolean a(int[] iArr) {
        if (b()) {
            a aVar = this.f937d;
            ColorStateList colorStateList = aVar.f942c;
            PorterDuff.Mode mode = aVar.f943d;
            if (colorStateList != null && mode != null) {
                int colorForState = colorStateList.getColorForState(iArr, colorStateList.getDefaultColor());
                if (!this.f936c || colorForState != this.f934a || mode != this.f935b) {
                    setColorFilter(colorForState, mode);
                    this.f934a = colorForState;
                    this.f935b = mode;
                    this.f936c = true;
                    return true;
                }
            } else {
                this.f936c = false;
                clearColorFilter();
            }
            return false;
        }
        return false;
    }

    public g(Drawable drawable) {
        this.f937d = c();
        a(drawable);
    }

    @Override // a.b.g.c.j.f
    public final Drawable a() {
        return this.f939f;
    }

    @Override // a.b.g.c.j.f
    public final void a(Drawable drawable) {
        Drawable drawable2 = this.f939f;
        if (drawable2 != null) {
            drawable2.setCallback(null);
        }
        this.f939f = drawable;
        if (drawable != null) {
            drawable.setCallback(this);
            setVisible(drawable.isVisible(), true);
            setState(drawable.getState());
            setLevel(drawable.getLevel());
            setBounds(drawable.getBounds());
            a aVar = this.f937d;
            if (aVar != null) {
                aVar.f941b = drawable.getConstantState();
            }
        }
        invalidateSelf();
    }
}
