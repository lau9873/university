package a.b.d.x;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RadialGradient;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.drawable.Drawable;
/* compiled from: ShadowDrawableWrapper.java */
/* loaded from: classes.dex */
public class m extends a.b.h.e.a.c {
    public static final double r = Math.cos(Math.toRadians(45.0d));

    /* renamed from: b  reason: collision with root package name */
    public final Paint f375b;

    /* renamed from: c  reason: collision with root package name */
    public final Paint f376c;

    /* renamed from: d  reason: collision with root package name */
    public final RectF f377d;

    /* renamed from: e  reason: collision with root package name */
    public float f378e;

    /* renamed from: f  reason: collision with root package name */
    public Path f379f;

    /* renamed from: g  reason: collision with root package name */
    public float f380g;

    /* renamed from: h  reason: collision with root package name */
    public float f381h;

    /* renamed from: i  reason: collision with root package name */
    public float f382i;
    public boolean j;
    public final int k;
    public final int m;
    public final int n;
    public boolean o;
    public float p;
    public boolean q;

    public m(Context context, Drawable drawable, float f2, float f3, float f4) {
        super(drawable);
        this.j = true;
        this.o = true;
        this.q = false;
        this.k = a.b.g.b.b.a(context, a.b.d.c.design_fab_shadow_start_color);
        this.m = a.b.g.b.b.a(context, a.b.d.c.design_fab_shadow_mid_color);
        this.n = a.b.g.b.b.a(context, a.b.d.c.design_fab_shadow_end_color);
        this.f375b = new Paint(5);
        this.f375b.setStyle(Paint.Style.FILL);
        this.f378e = Math.round(f2);
        this.f377d = new RectF();
        this.f376c = new Paint(this.f375b);
        this.f376c.setAntiAlias(false);
        a(f3, f4);
    }

    public static int c(float f2) {
        int round = Math.round(f2);
        return round % 2 == 1 ? round - 1 : round;
    }

    public void a(boolean z) {
        this.o = z;
        invalidateSelf();
    }

    public void b(float f2) {
        a(f2, this.f380g);
    }

    @Override // a.b.h.e.a.c, android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        if (this.j) {
            a(getBounds());
            this.j = false;
        }
        a(canvas);
        super.draw(canvas);
    }

    @Override // a.b.h.e.a.c, android.graphics.drawable.Drawable
    public int getOpacity() {
        return -3;
    }

    @Override // a.b.h.e.a.c, android.graphics.drawable.Drawable
    public boolean getPadding(Rect rect) {
        int ceil = (int) Math.ceil(b(this.f380g, this.f378e, this.o));
        int ceil2 = (int) Math.ceil(a(this.f380g, this.f378e, this.o));
        rect.set(ceil2, ceil, ceil2, ceil);
        return true;
    }

    @Override // a.b.h.e.a.c, android.graphics.drawable.Drawable
    public void onBoundsChange(Rect rect) {
        this.j = true;
    }

    @Override // a.b.h.e.a.c, android.graphics.drawable.Drawable
    public void setAlpha(int i2) {
        super.setAlpha(i2);
        this.f375b.setAlpha(i2);
        this.f376c.setAlpha(i2);
    }

    public static float b(float f2, float f3, boolean z) {
        return z ? (float) ((f2 * 1.5f) + ((1.0d - r) * f3)) : f2 * 1.5f;
    }

    public void a(float f2, float f3) {
        if (f2 >= 0.0f && f3 >= 0.0f) {
            float c2 = c(f2);
            float c3 = c(f3);
            if (c2 > c3) {
                if (!this.q) {
                    this.q = true;
                }
                c2 = c3;
            }
            if (this.f382i == c2 && this.f380g == c3) {
                return;
            }
            this.f382i = c2;
            this.f380g = c3;
            this.f381h = Math.round(c2 * 1.5f);
            this.j = true;
            invalidateSelf();
            return;
        }
        throw new IllegalArgumentException("invalid shadow size");
    }

    public final void b() {
        float f2 = this.f378e;
        RectF rectF = new RectF(-f2, -f2, f2, f2);
        RectF rectF2 = new RectF(rectF);
        float f3 = this.f381h;
        rectF2.inset(-f3, -f3);
        Path path = this.f379f;
        if (path == null) {
            this.f379f = new Path();
        } else {
            path.reset();
        }
        this.f379f.setFillType(Path.FillType.EVEN_ODD);
        this.f379f.moveTo(-this.f378e, 0.0f);
        this.f379f.rLineTo(-this.f381h, 0.0f);
        this.f379f.arcTo(rectF2, 180.0f, 90.0f, false);
        this.f379f.arcTo(rectF, 270.0f, -90.0f, false);
        this.f379f.close();
        float f4 = -rectF2.top;
        if (f4 > 0.0f) {
            float f5 = this.f378e / f4;
            this.f375b.setShader(new RadialGradient(0.0f, 0.0f, f4, new int[]{0, this.k, this.m, this.n}, new float[]{0.0f, f5, ((1.0f - f5) / 2.0f) + f5, 1.0f}, Shader.TileMode.CLAMP));
        }
        this.f376c.setShader(new LinearGradient(0.0f, rectF.top, 0.0f, rectF2.top, new int[]{this.k, this.m, this.n}, new float[]{0.0f, 0.5f, 1.0f}, Shader.TileMode.CLAMP));
        this.f376c.setAntiAlias(false);
    }

    public float c() {
        return this.f382i;
    }

    public static float a(float f2, float f3, boolean z) {
        return z ? (float) (f2 + ((1.0d - r) * f3)) : f2;
    }

    public final void a(float f2) {
        if (this.p != f2) {
            this.p = f2;
            invalidateSelf();
        }
    }

    public final void a(Canvas canvas) {
        int i2;
        float f2;
        int i3;
        float f3;
        float f4;
        float f5;
        int save = canvas.save();
        canvas.rotate(this.p, this.f377d.centerX(), this.f377d.centerY());
        float f6 = this.f378e;
        float f7 = (-f6) - this.f381h;
        float f8 = f6 * 2.0f;
        boolean z = this.f377d.width() - f8 > 0.0f;
        boolean z2 = this.f377d.height() - f8 > 0.0f;
        float f9 = this.f382i;
        float f10 = f6 / ((f9 - (0.5f * f9)) + f6);
        float f11 = f6 / ((f9 - (0.25f * f9)) + f6);
        float f12 = f6 / ((f9 - (f9 * 1.0f)) + f6);
        int save2 = canvas.save();
        RectF rectF = this.f377d;
        canvas.translate(rectF.left + f6, rectF.top + f6);
        canvas.scale(f10, f11);
        canvas.drawPath(this.f379f, this.f375b);
        if (z) {
            canvas.scale(1.0f / f10, 1.0f);
            i2 = save2;
            f2 = f12;
            i3 = save;
            f3 = f11;
            canvas.drawRect(0.0f, f7, this.f377d.width() - f8, -this.f378e, this.f376c);
        } else {
            i2 = save2;
            f2 = f12;
            i3 = save;
            f3 = f11;
        }
        canvas.restoreToCount(i2);
        int save3 = canvas.save();
        RectF rectF2 = this.f377d;
        canvas.translate(rectF2.right - f6, rectF2.bottom - f6);
        float f13 = f2;
        canvas.scale(f10, f13);
        canvas.rotate(180.0f);
        canvas.drawPath(this.f379f, this.f375b);
        if (z) {
            canvas.scale(1.0f / f10, 1.0f);
            f4 = f3;
            f5 = f13;
            canvas.drawRect(0.0f, f7, this.f377d.width() - f8, (-this.f378e) + this.f381h, this.f376c);
        } else {
            f4 = f3;
            f5 = f13;
        }
        canvas.restoreToCount(save3);
        int save4 = canvas.save();
        RectF rectF3 = this.f377d;
        canvas.translate(rectF3.left + f6, rectF3.bottom - f6);
        canvas.scale(f10, f5);
        canvas.rotate(270.0f);
        canvas.drawPath(this.f379f, this.f375b);
        if (z2) {
            canvas.scale(1.0f / f5, 1.0f);
            canvas.drawRect(0.0f, f7, this.f377d.height() - f8, -this.f378e, this.f376c);
        }
        canvas.restoreToCount(save4);
        int save5 = canvas.save();
        RectF rectF4 = this.f377d;
        canvas.translate(rectF4.right - f6, rectF4.top + f6);
        float f14 = f4;
        canvas.scale(f10, f14);
        canvas.rotate(90.0f);
        canvas.drawPath(this.f379f, this.f375b);
        if (z2) {
            canvas.scale(1.0f / f14, 1.0f);
            canvas.drawRect(0.0f, f7, this.f377d.height() - f8, -this.f378e, this.f376c);
        }
        canvas.restoreToCount(save5);
        canvas.restoreToCount(i3);
    }

    public final void a(Rect rect) {
        float f2 = this.f380g;
        float f3 = 1.5f * f2;
        this.f377d.set(rect.left + f2, rect.top + f3, rect.right - f2, rect.bottom - f3);
        Drawable a2 = a();
        RectF rectF = this.f377d;
        a2.setBounds((int) rectF.left, (int) rectF.top, (int) rectF.right, (int) rectF.bottom);
        b();
    }
}
