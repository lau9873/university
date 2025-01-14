package p000a.p006b.p049h.p063k;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RadialGradient;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.drawable.Drawable;
import p000a.p006b.p049h.p052c.C0365b;
import p000a.p006b.p049h.p052c.C0366c;

/* renamed from: a.b.h.k.a1 */
/* loaded from: classes.dex */
public class RoundRectDrawableWithShadow extends Drawable {

    /* renamed from: q */
    public static final double f2516q = Math.cos(Math.toRadians(45.0d));

    /* renamed from: r */
    public static InterfaceC0439a f2517r;

    /* renamed from: a */
    public final int f2518a;

    /* renamed from: c */
    public Paint f2520c;

    /* renamed from: d */
    public Paint f2521d;

    /* renamed from: e */
    public final RectF f2522e;

    /* renamed from: f */
    public float f2523f;

    /* renamed from: g */
    public Path f2524g;

    /* renamed from: h */
    public float f2525h;

    /* renamed from: i */
    public float f2526i;

    /* renamed from: j */
    public float f2527j;

    /* renamed from: k */
    public ColorStateList f2528k;

    /* renamed from: m */
    public final int f2530m;

    /* renamed from: n */
    public final int f2531n;

    /* renamed from: l */
    public boolean f2529l = true;

    /* renamed from: o */
    public boolean f2532o = true;

    /* renamed from: p */
    public boolean f2533p = false;

    /* renamed from: b */
    public Paint f2519b = new Paint(5);

    /* compiled from: RoundRectDrawableWithShadow.java */
    /* renamed from: a.b.h.k.a1$a */
    /* loaded from: classes.dex */
    public interface InterfaceC0439a {
        /* renamed from: a */
        void mo8450a(Canvas canvas, RectF rectF, float f, Paint paint);
    }

    public RoundRectDrawableWithShadow(Resources resources, ColorStateList colorStateList, float f, float f2, float f3) {
        this.f2530m = resources.getColor(C0365b.cardview_shadow_start_color);
        this.f2531n = resources.getColor(C0365b.cardview_shadow_end_color);
        this.f2518a = resources.getDimensionPixelSize(C0366c.cardview_compat_inset_shadow);
        m8531a(colorStateList);
        this.f2520c = new Paint(5);
        this.f2520c.setStyle(Paint.Style.FILL);
        this.f2523f = (int) (f + 0.5f);
        this.f2522e = new RectF();
        this.f2521d = new Paint(this.f2520c);
        this.f2521d.setAntiAlias(false);
        m8533a(f2, f3);
    }

    /* renamed from: b */
    public static float m8525b(float f, float f2, boolean z) {
        return z ? (float) ((f * 1.5f) + ((1.0d - f2516q) * f2)) : f * 1.5f;
    }

    /* renamed from: a */
    public final void m8531a(ColorStateList colorStateList) {
        if (colorStateList == null) {
            colorStateList = ColorStateList.valueOf(0);
        }
        this.f2528k = colorStateList;
        this.f2519b.setColor(this.f2528k.getColorForState(getState(), this.f2528k.getDefaultColor()));
    }

    /* renamed from: c */
    public float m8522c() {
        return this.f2523f;
    }

    /* renamed from: d */
    public final int m8519d(float f) {
        int i = (int) (f + 0.5f);
        return i % 2 == 1 ? i - 1 : i;
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        if (this.f2529l) {
            m8529a(getBounds());
            this.f2529l = false;
        }
        canvas.translate(0.0f, this.f2527j / 2.0f);
        m8530a(canvas);
        canvas.translate(0.0f, (-this.f2527j) / 2.0f);
        f2517r.mo8450a(canvas, this.f2522e, this.f2523f, this.f2519b);
    }

    /* renamed from: e */
    public float m8518e() {
        float f = this.f2525h;
        return (Math.max(f, this.f2523f + this.f2518a + ((f * 1.5f) / 2.0f)) * 2.0f) + (((this.f2525h * 1.5f) + this.f2518a) * 2.0f);
    }

    /* renamed from: f */
    public float m8517f() {
        float f = this.f2525h;
        return (Math.max(f, this.f2523f + this.f2518a + (f / 2.0f)) * 2.0f) + ((this.f2525h + this.f2518a) * 2.0f);
    }

    /* renamed from: g */
    public float m8516g() {
        return this.f2527j;
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -3;
    }

    @Override // android.graphics.drawable.Drawable
    public boolean getPadding(Rect rect) {
        int ceil = (int) Math.ceil(m8525b(this.f2525h, this.f2523f, this.f2532o));
        int ceil2 = (int) Math.ceil(m8532a(this.f2525h, this.f2523f, this.f2532o));
        rect.set(ceil2, ceil, ceil2, ceil);
        return true;
    }

    @Override // android.graphics.drawable.Drawable
    public boolean isStateful() {
        ColorStateList colorStateList = this.f2528k;
        return (colorStateList != null && colorStateList.isStateful()) || super.isStateful();
    }

    @Override // android.graphics.drawable.Drawable
    public void onBoundsChange(Rect rect) {
        super.onBoundsChange(rect);
        this.f2529l = true;
    }

    @Override // android.graphics.drawable.Drawable
    public boolean onStateChange(int[] iArr) {
        ColorStateList colorStateList = this.f2528k;
        int colorForState = colorStateList.getColorForState(iArr, colorStateList.getDefaultColor());
        if (this.f2519b.getColor() == colorForState) {
            return false;
        }
        this.f2519b.setColor(colorForState);
        this.f2529l = true;
        invalidateSelf();
        return true;
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i) {
        this.f2519b.setAlpha(i);
        this.f2520c.setAlpha(i);
        this.f2521d.setAlpha(i);
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        this.f2519b.setColorFilter(colorFilter);
    }

    /* renamed from: b */
    public void m8523b(Rect rect) {
        getPadding(rect);
    }

    /* renamed from: c */
    public void m8521c(float f) {
        m8533a(f, this.f2525h);
    }

    /* renamed from: d */
    public float m8520d() {
        return this.f2525h;
    }

    /* renamed from: a */
    public void m8528a(boolean z) {
        this.f2532o = z;
        invalidateSelf();
    }

    /* renamed from: b */
    public void m8526b(float f) {
        m8533a(this.f2527j, f);
    }

    /* renamed from: b */
    public void m8524b(ColorStateList colorStateList) {
        m8531a(colorStateList);
        invalidateSelf();
    }

    /* renamed from: a */
    public final void m8533a(float f, float f2) {
        if (f < 0.0f) {
            throw new IllegalArgumentException("Invalid shadow size " + f + ". Must be >= 0");
        } else if (f2 >= 0.0f) {
            float m8519d = m8519d(f);
            float m8519d2 = m8519d(f2);
            if (m8519d > m8519d2) {
                if (!this.f2533p) {
                    this.f2533p = true;
                }
                m8519d = m8519d2;
            }
            if (this.f2527j == m8519d && this.f2525h == m8519d2) {
                return;
            }
            this.f2527j = m8519d;
            this.f2525h = m8519d2;
            this.f2526i = (int) ((m8519d * 1.5f) + this.f2518a + 0.5f);
            this.f2529l = true;
            invalidateSelf();
        } else {
            throw new IllegalArgumentException("Invalid max shadow size " + f2 + ". Must be >= 0");
        }
    }

    /* renamed from: b */
    public ColorStateList m8527b() {
        return this.f2528k;
    }

    /* renamed from: a */
    public static float m8532a(float f, float f2, boolean z) {
        return z ? (float) (f + ((1.0d - f2516q) * f2)) : f;
    }

    /* renamed from: a */
    public void m8534a(float f) {
        if (f >= 0.0f) {
            float f2 = (int) (f + 0.5f);
            if (this.f2523f == f2) {
                return;
            }
            this.f2523f = f2;
            this.f2529l = true;
            invalidateSelf();
            return;
        }
        throw new IllegalArgumentException("Invalid radius " + f + ". Must be >= 0");
    }

    /* renamed from: a */
    public final void m8530a(Canvas canvas) {
        float f = this.f2523f;
        float f2 = (-f) - this.f2526i;
        float f3 = f + this.f2518a + (this.f2527j / 2.0f);
        float f4 = f3 * 2.0f;
        boolean z = this.f2522e.width() - f4 > 0.0f;
        boolean z2 = this.f2522e.height() - f4 > 0.0f;
        int save = canvas.save();
        RectF rectF = this.f2522e;
        canvas.translate(rectF.left + f3, rectF.top + f3);
        canvas.drawPath(this.f2524g, this.f2520c);
        if (z) {
            canvas.drawRect(0.0f, f2, this.f2522e.width() - f4, -this.f2523f, this.f2521d);
        }
        canvas.restoreToCount(save);
        int save2 = canvas.save();
        RectF rectF2 = this.f2522e;
        canvas.translate(rectF2.right - f3, rectF2.bottom - f3);
        canvas.rotate(180.0f);
        canvas.drawPath(this.f2524g, this.f2520c);
        if (z) {
            canvas.drawRect(0.0f, f2, this.f2522e.width() - f4, (-this.f2523f) + this.f2526i, this.f2521d);
        }
        canvas.restoreToCount(save2);
        int save3 = canvas.save();
        RectF rectF3 = this.f2522e;
        canvas.translate(rectF3.left + f3, rectF3.bottom - f3);
        canvas.rotate(270.0f);
        canvas.drawPath(this.f2524g, this.f2520c);
        if (z2) {
            canvas.drawRect(0.0f, f2, this.f2522e.height() - f4, -this.f2523f, this.f2521d);
        }
        canvas.restoreToCount(save3);
        int save4 = canvas.save();
        RectF rectF4 = this.f2522e;
        canvas.translate(rectF4.right - f3, rectF4.top + f3);
        canvas.rotate(90.0f);
        canvas.drawPath(this.f2524g, this.f2520c);
        if (z2) {
            canvas.drawRect(0.0f, f2, this.f2522e.height() - f4, -this.f2523f, this.f2521d);
        }
        canvas.restoreToCount(save4);
    }

    /* renamed from: a */
    public final void m8535a() {
        float f = this.f2523f;
        RectF rectF = new RectF(-f, -f, f, f);
        RectF rectF2 = new RectF(rectF);
        float f2 = this.f2526i;
        rectF2.inset(-f2, -f2);
        Path path = this.f2524g;
        if (path == null) {
            this.f2524g = new Path();
        } else {
            path.reset();
        }
        this.f2524g.setFillType(Path.FillType.EVEN_ODD);
        this.f2524g.moveTo(-this.f2523f, 0.0f);
        this.f2524g.rLineTo(-this.f2526i, 0.0f);
        this.f2524g.arcTo(rectF2, 180.0f, 90.0f, false);
        this.f2524g.arcTo(rectF, 270.0f, -90.0f, false);
        this.f2524g.close();
        float f3 = this.f2523f;
        float f4 = this.f2526i;
        Paint paint = this.f2520c;
        float f5 = f3 + f4;
        int i = this.f2530m;
        paint.setShader(new RadialGradient(0.0f, 0.0f, f5, new int[]{i, i, this.f2531n}, new float[]{0.0f, f3 / (f3 + f4), 1.0f}, Shader.TileMode.CLAMP));
        Paint paint2 = this.f2521d;
        float f6 = this.f2523f;
        float f7 = this.f2526i;
        int i2 = this.f2530m;
        paint2.setShader(new LinearGradient(0.0f, (-f6) + f7, 0.0f, (-f6) - f7, new int[]{i2, i2, this.f2531n}, new float[]{0.0f, 0.5f, 1.0f}, Shader.TileMode.CLAMP));
        this.f2521d.setAntiAlias(false);
    }

    /* renamed from: a */
    public final void m8529a(Rect rect) {
        float f = this.f2525h;
        float f2 = 1.5f * f;
        this.f2522e.set(rect.left + f, rect.top + f2, rect.right - f, rect.bottom - f2);
        m8535a();
    }
}
