package p000a.p006b.p049h.p063k;

import android.content.res.ColorStateList;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Outline;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;

/* renamed from: a.b.h.k.z0 */
/* loaded from: classes.dex */
public class RoundRectDrawable extends Drawable {

    /* renamed from: a */
    public float f3020a;

    /* renamed from: c */
    public final RectF f3022c;

    /* renamed from: d */
    public final Rect f3023d;

    /* renamed from: e */
    public float f3024e;

    /* renamed from: h */
    public ColorStateList f3027h;

    /* renamed from: i */
    public PorterDuffColorFilter f3028i;

    /* renamed from: j */
    public ColorStateList f3029j;

    /* renamed from: f */
    public boolean f3025f = false;

    /* renamed from: g */
    public boolean f3026g = true;

    /* renamed from: k */
    public PorterDuff.Mode f3030k = PorterDuff.Mode.SRC_IN;

    /* renamed from: b */
    public final Paint f3021b = new Paint(5);

    public RoundRectDrawable(ColorStateList colorStateList, float f) {
        this.f3020a = f;
        m7966a(colorStateList);
        this.f3022c = new RectF();
        this.f3023d = new Rect();
    }

    /* renamed from: a */
    public final void m7966a(ColorStateList colorStateList) {
        if (colorStateList == null) {
            colorStateList = ColorStateList.valueOf(0);
        }
        this.f3027h = colorStateList;
        this.f3021b.setColor(this.f3027h.getColorForState(getState(), this.f3027h.getDefaultColor()));
    }

    /* renamed from: b */
    public float m7963b() {
        return this.f3024e;
    }

    /* renamed from: c */
    public float m7961c() {
        return this.f3020a;
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        boolean z;
        Paint paint = this.f3021b;
        if (this.f3028i == null || paint.getColorFilter() != null) {
            z = false;
        } else {
            paint.setColorFilter(this.f3028i);
            z = true;
        }
        RectF rectF = this.f3022c;
        float f = this.f3020a;
        canvas.drawRoundRect(rectF, f, f, paint);
        if (z) {
            paint.setColorFilter(null);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -3;
    }

    @Override // android.graphics.drawable.Drawable
    public void getOutline(Outline outline) {
        outline.setRoundRect(this.f3023d, this.f3020a);
    }

    @Override // android.graphics.drawable.Drawable
    public boolean isStateful() {
        ColorStateList colorStateList;
        ColorStateList colorStateList2 = this.f3029j;
        return (colorStateList2 != null && colorStateList2.isStateful()) || ((colorStateList = this.f3027h) != null && colorStateList.isStateful()) || super.isStateful();
    }

    @Override // android.graphics.drawable.Drawable
    public void onBoundsChange(Rect rect) {
        super.onBoundsChange(rect);
        m7964a(rect);
    }

    @Override // android.graphics.drawable.Drawable
    public boolean onStateChange(int[] iArr) {
        PorterDuff.Mode mode;
        ColorStateList colorStateList = this.f3027h;
        int colorForState = colorStateList.getColorForState(iArr, colorStateList.getDefaultColor());
        boolean z = colorForState != this.f3021b.getColor();
        if (z) {
            this.f3021b.setColor(colorForState);
        }
        ColorStateList colorStateList2 = this.f3029j;
        if (colorStateList2 == null || (mode = this.f3030k) == null) {
            return z;
        }
        this.f3028i = m7965a(colorStateList2, mode);
        return true;
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i) {
        this.f3021b.setAlpha(i);
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        this.f3021b.setColorFilter(colorFilter);
    }

    @Override // android.graphics.drawable.Drawable
    public void setTintList(ColorStateList colorStateList) {
        this.f3029j = colorStateList;
        this.f3028i = m7965a(this.f3029j, this.f3030k);
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public void setTintMode(PorterDuff.Mode mode) {
        this.f3030k = mode;
        this.f3028i = m7965a(this.f3029j, this.f3030k);
        invalidateSelf();
    }

    /* renamed from: b */
    public void m7962b(ColorStateList colorStateList) {
        m7966a(colorStateList);
        invalidateSelf();
    }

    /* renamed from: a */
    public void m7967a(float f, boolean z, boolean z2) {
        if (f == this.f3024e && this.f3025f == z && this.f3026g == z2) {
            return;
        }
        this.f3024e = f;
        this.f3025f = z;
        this.f3026g = z2;
        m7964a((Rect) null);
        invalidateSelf();
    }

    /* renamed from: a */
    public final void m7964a(Rect rect) {
        if (rect == null) {
            rect = getBounds();
        }
        this.f3022c.set(rect.left, rect.top, rect.right, rect.bottom);
        this.f3023d.set(rect);
        if (this.f3025f) {
            float m8525b = RoundRectDrawableWithShadow.m8525b(this.f3024e, this.f3020a, this.f3026g);
            this.f3023d.inset((int) Math.ceil(RoundRectDrawableWithShadow.m8532a(this.f3024e, this.f3020a, this.f3026g)), (int) Math.ceil(m8525b));
            this.f3022c.set(this.f3023d);
        }
    }

    /* renamed from: a */
    public void m7968a(float f) {
        if (f == this.f3020a) {
            return;
        }
        this.f3020a = f;
        m7964a((Rect) null);
        invalidateSelf();
    }

    /* renamed from: a */
    public ColorStateList m7969a() {
        return this.f3027h;
    }

    /* renamed from: a */
    public final PorterDuffColorFilter m7965a(ColorStateList colorStateList, PorterDuff.Mode mode) {
        if (colorStateList == null || mode == null) {
            return null;
        }
        return new PorterDuffColorFilter(colorStateList.getColorForState(getState(), 0), mode);
    }
}
