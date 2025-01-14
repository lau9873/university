package p000a.p006b.p030g.p034c.p035j;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.Region;
import android.graphics.drawable.Drawable;

/* renamed from: a.b.g.c.j.g */
/* loaded from: classes.dex */
public class WrappedDrawableApi14 extends Drawable implements Drawable.Callback, WrappedDrawable, TintAwareDrawable {

    /* renamed from: g */
    public static final PorterDuff.Mode f1443g = PorterDuff.Mode.SRC_IN;

    /* renamed from: a */
    public int f1444a;

    /* renamed from: b */
    public PorterDuff.Mode f1445b;

    /* renamed from: c */
    public boolean f1446c;

    /* renamed from: d */
    public AbstractC0219a f1447d;

    /* renamed from: e */
    public boolean f1448e;

    /* renamed from: f */
    public Drawable f1449f;

    /* compiled from: WrappedDrawableApi14.java */
    /* renamed from: a.b.g.c.j.g$a */
    /* loaded from: classes.dex */
    public static abstract class AbstractC0219a extends Drawable.ConstantState {

        /* renamed from: a */
        public int f1450a;

        /* renamed from: b */
        public Drawable.ConstantState f1451b;

        /* renamed from: c */
        public ColorStateList f1452c;

        /* renamed from: d */
        public PorterDuff.Mode f1453d;

        public AbstractC0219a(AbstractC0219a abstractC0219a, Resources resources) {
            this.f1452c = null;
            this.f1453d = WrappedDrawableApi14.f1443g;
            if (abstractC0219a != null) {
                this.f1450a = abstractC0219a.f1450a;
                this.f1451b = abstractC0219a.f1451b;
                this.f1452c = abstractC0219a.f1452c;
                this.f1453d = abstractC0219a.f1453d;
            }
        }

        /* renamed from: a */
        public boolean m9835a() {
            return this.f1451b != null;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public int getChangingConfigurations() {
            int i = this.f1450a;
            Drawable.ConstantState constantState = this.f1451b;
            return i | (constantState != null ? constantState.getChangingConfigurations() : 0);
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public Drawable newDrawable() {
            return newDrawable(null);
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public abstract Drawable newDrawable(Resources resources);
    }

    /* compiled from: WrappedDrawableApi14.java */
    /* renamed from: a.b.g.c.j.g$b */
    /* loaded from: classes.dex */
    public static class C0220b extends AbstractC0219a {
        public C0220b(AbstractC0219a abstractC0219a, Resources resources) {
            super(abstractC0219a, resources);
        }

        @Override // p000a.p006b.p030g.p034c.p035j.WrappedDrawableApi14.AbstractC0219a, android.graphics.drawable.Drawable.ConstantState
        public Drawable newDrawable(Resources resources) {
            return new WrappedDrawableApi14(this, resources);
        }
    }

    public WrappedDrawableApi14(AbstractC0219a abstractC0219a, Resources resources) {
        this.f1447d = abstractC0219a;
        m9838a(resources);
    }

    /* renamed from: a */
    public final void m9838a(Resources resources) {
        Drawable.ConstantState constantState;
        AbstractC0219a abstractC0219a = this.f1447d;
        if (abstractC0219a == null || (constantState = abstractC0219a.f1451b) == null) {
            return;
        }
        mo9837a(constantState.newDrawable(resources));
    }

    /* renamed from: b */
    public boolean mo9834b() {
        return true;
    }

    /* renamed from: c */
    public AbstractC0219a mo9833c() {
        return new C0220b(this.f1447d, null);
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        this.f1449f.draw(canvas);
    }

    @Override // android.graphics.drawable.Drawable
    public int getChangingConfigurations() {
        int changingConfigurations = super.getChangingConfigurations();
        AbstractC0219a abstractC0219a = this.f1447d;
        return changingConfigurations | (abstractC0219a != null ? abstractC0219a.getChangingConfigurations() : 0) | this.f1449f.getChangingConfigurations();
    }

    @Override // android.graphics.drawable.Drawable
    public Drawable.ConstantState getConstantState() {
        AbstractC0219a abstractC0219a = this.f1447d;
        if (abstractC0219a == null || !abstractC0219a.m9835a()) {
            return null;
        }
        this.f1447d.f1450a = getChangingConfigurations();
        return this.f1447d;
    }

    @Override // android.graphics.drawable.Drawable
    public Drawable getCurrent() {
        return this.f1449f.getCurrent();
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        return this.f1449f.getIntrinsicHeight();
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        return this.f1449f.getIntrinsicWidth();
    }

    @Override // android.graphics.drawable.Drawable
    public int getMinimumHeight() {
        return this.f1449f.getMinimumHeight();
    }

    @Override // android.graphics.drawable.Drawable
    public int getMinimumWidth() {
        return this.f1449f.getMinimumWidth();
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return this.f1449f.getOpacity();
    }

    @Override // android.graphics.drawable.Drawable
    public boolean getPadding(Rect rect) {
        return this.f1449f.getPadding(rect);
    }

    @Override // android.graphics.drawable.Drawable
    public int[] getState() {
        return this.f1449f.getState();
    }

    @Override // android.graphics.drawable.Drawable
    public Region getTransparentRegion() {
        return this.f1449f.getTransparentRegion();
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public void invalidateDrawable(Drawable drawable) {
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public boolean isAutoMirrored() {
        return this.f1449f.isAutoMirrored();
    }

    @Override // android.graphics.drawable.Drawable
    public boolean isStateful() {
        AbstractC0219a abstractC0219a;
        ColorStateList colorStateList = (!mo9834b() || (abstractC0219a = this.f1447d) == null) ? null : abstractC0219a.f1452c;
        return (colorStateList != null && colorStateList.isStateful()) || this.f1449f.isStateful();
    }

    @Override // android.graphics.drawable.Drawable
    public void jumpToCurrentState() {
        this.f1449f.jumpToCurrentState();
    }

    @Override // android.graphics.drawable.Drawable
    public Drawable mutate() {
        if (!this.f1448e && super.mutate() == this) {
            this.f1447d = mo9833c();
            Drawable drawable = this.f1449f;
            if (drawable != null) {
                drawable.mutate();
            }
            AbstractC0219a abstractC0219a = this.f1447d;
            if (abstractC0219a != null) {
                Drawable drawable2 = this.f1449f;
                abstractC0219a.f1451b = drawable2 != null ? drawable2.getConstantState() : null;
            }
            this.f1448e = true;
        }
        return this;
    }

    @Override // android.graphics.drawable.Drawable
    public void onBoundsChange(Rect rect) {
        Drawable drawable = this.f1449f;
        if (drawable != null) {
            drawable.setBounds(rect);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public boolean onLevelChange(int i) {
        return this.f1449f.setLevel(i);
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public void scheduleDrawable(Drawable drawable, Runnable runnable, long j) {
        scheduleSelf(runnable, j);
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i) {
        this.f1449f.setAlpha(i);
    }

    @Override // android.graphics.drawable.Drawable
    public void setAutoMirrored(boolean z) {
        this.f1449f.setAutoMirrored(z);
    }

    @Override // android.graphics.drawable.Drawable
    public void setChangingConfigurations(int i) {
        this.f1449f.setChangingConfigurations(i);
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        this.f1449f.setColorFilter(colorFilter);
    }

    @Override // android.graphics.drawable.Drawable
    public void setDither(boolean z) {
        this.f1449f.setDither(z);
    }

    @Override // android.graphics.drawable.Drawable
    public void setFilterBitmap(boolean z) {
        this.f1449f.setFilterBitmap(z);
    }

    @Override // android.graphics.drawable.Drawable
    public boolean setState(int[] iArr) {
        return m9836a(iArr) || this.f1449f.setState(iArr);
    }

    @Override // android.graphics.drawable.Drawable, p000a.p006b.p030g.p034c.p035j.TintAwareDrawable
    public void setTint(int i) {
        setTintList(ColorStateList.valueOf(i));
    }

    @Override // android.graphics.drawable.Drawable, p000a.p006b.p030g.p034c.p035j.TintAwareDrawable
    public void setTintList(ColorStateList colorStateList) {
        this.f1447d.f1452c = colorStateList;
        m9836a(getState());
    }

    @Override // android.graphics.drawable.Drawable, p000a.p006b.p030g.p034c.p035j.TintAwareDrawable
    public void setTintMode(PorterDuff.Mode mode) {
        this.f1447d.f1453d = mode;
        m9836a(getState());
    }

    @Override // android.graphics.drawable.Drawable
    public boolean setVisible(boolean z, boolean z2) {
        return super.setVisible(z, z2) || this.f1449f.setVisible(z, z2);
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public void unscheduleDrawable(Drawable drawable, Runnable runnable) {
        unscheduleSelf(runnable);
    }

    /* renamed from: a */
    public final boolean m9836a(int[] iArr) {
        if (mo9834b()) {
            AbstractC0219a abstractC0219a = this.f1447d;
            ColorStateList colorStateList = abstractC0219a.f1452c;
            PorterDuff.Mode mode = abstractC0219a.f1453d;
            if (colorStateList != null && mode != null) {
                int colorForState = colorStateList.getColorForState(iArr, colorStateList.getDefaultColor());
                if (!this.f1446c || colorForState != this.f1444a || mode != this.f1445b) {
                    setColorFilter(colorForState, mode);
                    this.f1444a = colorForState;
                    this.f1445b = mode;
                    this.f1446c = true;
                    return true;
                }
            } else {
                this.f1446c = false;
                clearColorFilter();
            }
            return false;
        }
        return false;
    }

    public WrappedDrawableApi14(Drawable drawable) {
        this.f1447d = mo9833c();
        mo9837a(drawable);
    }

    @Override // p000a.p006b.p030g.p034c.p035j.WrappedDrawable
    /* renamed from: a */
    public final Drawable mo9839a() {
        return this.f1449f;
    }

    @Override // p000a.p006b.p030g.p034c.p035j.WrappedDrawable
    /* renamed from: a */
    public final void mo9837a(Drawable drawable) {
        Drawable drawable2 = this.f1449f;
        if (drawable2 != null) {
            drawable2.setCallback(null);
        }
        this.f1449f = drawable;
        if (drawable != null) {
            drawable.setCallback(this);
            setVisible(drawable.isVisible(), true);
            setState(drawable.getState());
            setLevel(drawable.getLevel());
            setBounds(drawable.getBounds());
            AbstractC0219a abstractC0219a = this.f1447d;
            if (abstractC0219a != null) {
                abstractC0219a.f1451b = drawable.getConstantState();
            }
        }
        invalidateSelf();
    }
}
