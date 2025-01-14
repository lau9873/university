package a.b.h.k;

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
/* compiled from: RoundRectDrawable.java */
/* loaded from: classes.dex */
public class z0 extends Drawable {

    /* renamed from: a  reason: collision with root package name */
    public float f2011a;

    /* renamed from: c  reason: collision with root package name */
    public final RectF f2013c;

    /* renamed from: d  reason: collision with root package name */
    public final Rect f2014d;

    /* renamed from: e  reason: collision with root package name */
    public float f2015e;

    /* renamed from: h  reason: collision with root package name */
    public ColorStateList f2018h;

    /* renamed from: i  reason: collision with root package name */
    public PorterDuffColorFilter f2019i;
    public ColorStateList j;

    /* renamed from: f  reason: collision with root package name */
    public boolean f2016f = false;

    /* renamed from: g  reason: collision with root package name */
    public boolean f2017g = true;
    public PorterDuff.Mode k = PorterDuff.Mode.SRC_IN;

    /* renamed from: b  reason: collision with root package name */
    public final Paint f2012b = new Paint(5);

    public z0(ColorStateList colorStateList, float f2) {
        this.f2011a = f2;
        a(colorStateList);
        this.f2013c = new RectF();
        this.f2014d = new Rect();
    }

    public final void a(ColorStateList colorStateList) {
        if (colorStateList == null) {
            colorStateList = ColorStateList.valueOf(0);
        }
        this.f2018h = colorStateList;
        this.f2012b.setColor(this.f2018h.getColorForState(getState(), this.f2018h.getDefaultColor()));
    }

    public float b() {
        return this.f2015e;
    }

    public float c() {
        return this.f2011a;
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        boolean z;
        Paint paint = this.f2012b;
        if (this.f2019i == null || paint.getColorFilter() != null) {
            z = false;
        } else {
            paint.setColorFilter(this.f2019i);
            z = true;
        }
        RectF rectF = this.f2013c;
        float f2 = this.f2011a;
        canvas.drawRoundRect(rectF, f2, f2, paint);
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
        outline.setRoundRect(this.f2014d, this.f2011a);
    }

    @Override // android.graphics.drawable.Drawable
    public boolean isStateful() {
        ColorStateList colorStateList;
        ColorStateList colorStateList2 = this.j;
        return (colorStateList2 != null && colorStateList2.isStateful()) || ((colorStateList = this.f2018h) != null && colorStateList.isStateful()) || super.isStateful();
    }

    @Override // android.graphics.drawable.Drawable
    public void onBoundsChange(Rect rect) {
        super.onBoundsChange(rect);
        a(rect);
    }

    @Override // android.graphics.drawable.Drawable
    public boolean onStateChange(int[] iArr) {
        PorterDuff.Mode mode;
        ColorStateList colorStateList = this.f2018h;
        int colorForState = colorStateList.getColorForState(iArr, colorStateList.getDefaultColor());
        boolean z = colorForState != this.f2012b.getColor();
        if (z) {
            this.f2012b.setColor(colorForState);
        }
        ColorStateList colorStateList2 = this.j;
        if (colorStateList2 == null || (mode = this.k) == null) {
            return z;
        }
        this.f2019i = a(colorStateList2, mode);
        return true;
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i2) {
        this.f2012b.setAlpha(i2);
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        this.f2012b.setColorFilter(colorFilter);
    }

    @Override // android.graphics.drawable.Drawable
    public void setTintList(ColorStateList colorStateList) {
        this.j = colorStateList;
        this.f2019i = a(this.j, this.k);
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public void setTintMode(PorterDuff.Mode mode) {
        this.k = mode;
        this.f2019i = a(this.j, this.k);
        invalidateSelf();
    }

    public void b(ColorStateList colorStateList) {
        a(colorStateList);
        invalidateSelf();
    }

    public void a(float f2, boolean z, boolean z2) {
        if (f2 == this.f2015e && this.f2016f == z && this.f2017g == z2) {
            return;
        }
        this.f2015e = f2;
        this.f2016f = z;
        this.f2017g = z2;
        a((Rect) null);
        invalidateSelf();
    }

    public final void a(Rect rect) {
        if (rect == null) {
            rect = getBounds();
        }
        this.f2013c.set(rect.left, rect.top, rect.right, rect.bottom);
        this.f2014d.set(rect);
        if (this.f2016f) {
            float b2 = a1.b(this.f2015e, this.f2011a, this.f2017g);
            this.f2014d.inset((int) Math.ceil(a1.a(this.f2015e, this.f2011a, this.f2017g)), (int) Math.ceil(b2));
            this.f2013c.set(this.f2014d);
        }
    }

    public void a(float f2) {
        if (f2 == this.f2011a) {
            return;
        }
        this.f2011a = f2;
        a((Rect) null);
        invalidateSelf();
    }

    public ColorStateList a() {
        return this.f2018h;
    }

    public final PorterDuffColorFilter a(ColorStateList colorStateList, PorterDuff.Mode mode) {
        if (colorStateList == null || mode == null) {
            return null;
        }
        return new PorterDuffColorFilter(colorStateList.getColorForState(getState(), 0), mode);
    }
}
