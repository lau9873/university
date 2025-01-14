package p000a.p006b.p012d.p026x;

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
import p000a.p006b.p012d.C0041c;
import p000a.p006b.p030g.p032b.ContextCompat;
import p000a.p006b.p049h.p055e.p056a.DrawableWrapper;

/* renamed from: a.b.d.x.m */
/* loaded from: classes.dex */
public class ShadowDrawableWrapper extends DrawableWrapper {

    /* renamed from: r */
    public static final double f709r = Math.cos(Math.toRadians(45.0d));

    /* renamed from: b */
    public final Paint f710b;

    /* renamed from: c */
    public final Paint f711c;

    /* renamed from: d */
    public final RectF f712d;

    /* renamed from: e */
    public float f713e;

    /* renamed from: f */
    public Path f714f;

    /* renamed from: g */
    public float f715g;

    /* renamed from: h */
    public float f716h;

    /* renamed from: i */
    public float f717i;

    /* renamed from: j */
    public boolean f718j;

    /* renamed from: k */
    public final int f719k;

    /* renamed from: m */
    public final int f720m;

    /* renamed from: n */
    public final int f721n;

    /* renamed from: o */
    public boolean f722o;

    /* renamed from: p */
    public float f723p;

    /* renamed from: q */
    public boolean f724q;

    public ShadowDrawableWrapper(Context context, Drawable drawable, float f, float f2, float f3) {
        super(drawable);
        this.f718j = true;
        this.f722o = true;
        this.f724q = false;
        this.f719k = ContextCompat.m10022a(context, C0041c.design_fab_shadow_start_color);
        this.f720m = ContextCompat.m10022a(context, C0041c.design_fab_shadow_mid_color);
        this.f721n = ContextCompat.m10022a(context, C0041c.design_fab_shadow_end_color);
        this.f710b = new Paint(5);
        this.f710b.setStyle(Paint.Style.FILL);
        this.f713e = Math.round(f);
        this.f712d = new RectF();
        this.f711c = new Paint(this.f710b);
        this.f711c.setAntiAlias(false);
        m10689a(f2, f3);
    }

    /* renamed from: c */
    public static int m10680c(float f) {
        int round = Math.round(f);
        return round % 2 == 1 ? round - 1 : round;
    }

    /* renamed from: a */
    public void m10685a(boolean z) {
        this.f722o = z;
        invalidateSelf();
    }

    /* renamed from: b */
    public void m10683b(float f) {
        m10689a(f, this.f715g);
    }

    @Override // p000a.p006b.p049h.p055e.p056a.DrawableWrapper, android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        if (this.f718j) {
            m10686a(getBounds());
            this.f718j = false;
        }
        m10687a(canvas);
        super.draw(canvas);
    }

    @Override // p000a.p006b.p049h.p055e.p056a.DrawableWrapper, android.graphics.drawable.Drawable
    public int getOpacity() {
        return -3;
    }

    @Override // p000a.p006b.p049h.p055e.p056a.DrawableWrapper, android.graphics.drawable.Drawable
    public boolean getPadding(Rect rect) {
        int ceil = (int) Math.ceil(m10682b(this.f715g, this.f713e, this.f722o));
        int ceil2 = (int) Math.ceil(m10688a(this.f715g, this.f713e, this.f722o));
        rect.set(ceil2, ceil, ceil2, ceil);
        return true;
    }

    @Override // p000a.p006b.p049h.p055e.p056a.DrawableWrapper, android.graphics.drawable.Drawable
    public void onBoundsChange(Rect rect) {
        this.f718j = true;
    }

    @Override // p000a.p006b.p049h.p055e.p056a.DrawableWrapper, android.graphics.drawable.Drawable
    public void setAlpha(int i) {
        super.setAlpha(i);
        this.f710b.setAlpha(i);
        this.f711c.setAlpha(i);
    }

    /* renamed from: b */
    public static float m10682b(float f, float f2, boolean z) {
        return z ? (float) ((f * 1.5f) + ((1.0d - f709r) * f2)) : f * 1.5f;
    }

    /* renamed from: a */
    public void m10689a(float f, float f2) {
        if (f >= 0.0f && f2 >= 0.0f) {
            float m10680c = m10680c(f);
            float m10680c2 = m10680c(f2);
            if (m10680c > m10680c2) {
                if (!this.f724q) {
                    this.f724q = true;
                }
                m10680c = m10680c2;
            }
            if (this.f717i == m10680c && this.f715g == m10680c2) {
                return;
            }
            this.f717i = m10680c;
            this.f715g = m10680c2;
            this.f716h = Math.round(m10680c * 1.5f);
            this.f718j = true;
            invalidateSelf();
            return;
        }
        throw new IllegalArgumentException("invalid shadow size");
    }

    /* renamed from: b */
    public final void m10684b() {
        float f = this.f713e;
        RectF rectF = new RectF(-f, -f, f, f);
        RectF rectF2 = new RectF(rectF);
        float f2 = this.f716h;
        rectF2.inset(-f2, -f2);
        Path path = this.f714f;
        if (path == null) {
            this.f714f = new Path();
        } else {
            path.reset();
        }
        this.f714f.setFillType(Path.FillType.EVEN_ODD);
        this.f714f.moveTo(-this.f713e, 0.0f);
        this.f714f.rLineTo(-this.f716h, 0.0f);
        this.f714f.arcTo(rectF2, 180.0f, 90.0f, false);
        this.f714f.arcTo(rectF, 270.0f, -90.0f, false);
        this.f714f.close();
        float f3 = -rectF2.top;
        if (f3 > 0.0f) {
            float f4 = this.f713e / f3;
            this.f710b.setShader(new RadialGradient(0.0f, 0.0f, f3, new int[]{0, this.f719k, this.f720m, this.f721n}, new float[]{0.0f, f4, ((1.0f - f4) / 2.0f) + f4, 1.0f}, Shader.TileMode.CLAMP));
        }
        this.f711c.setShader(new LinearGradient(0.0f, rectF.top, 0.0f, rectF2.top, new int[]{this.f719k, this.f720m, this.f721n}, new float[]{0.0f, 0.5f, 1.0f}, Shader.TileMode.CLAMP));
        this.f711c.setAntiAlias(false);
    }

    /* renamed from: c */
    public float m10681c() {
        return this.f717i;
    }

    /* renamed from: a */
    public static float m10688a(float f, float f2, boolean z) {
        return z ? (float) (f + ((1.0d - f709r) * f2)) : f;
    }

    /* renamed from: a */
    public final void m10690a(float f) {
        if (this.f723p != f) {
            this.f723p = f;
            invalidateSelf();
        }
    }

    /* renamed from: a */
    public final void m10687a(Canvas canvas) {
        int i;
        float f;
        int i2;
        float f2;
        float f3;
        float f4;
        int save = canvas.save();
        canvas.rotate(this.f723p, this.f712d.centerX(), this.f712d.centerY());
        float f5 = this.f713e;
        float f6 = (-f5) - this.f716h;
        float f7 = f5 * 2.0f;
        boolean z = this.f712d.width() - f7 > 0.0f;
        boolean z2 = this.f712d.height() - f7 > 0.0f;
        float f8 = this.f717i;
        float f9 = f5 / ((f8 - (0.5f * f8)) + f5);
        float f10 = f5 / ((f8 - (0.25f * f8)) + f5);
        float f11 = f5 / ((f8 - (f8 * 1.0f)) + f5);
        int save2 = canvas.save();
        RectF rectF = this.f712d;
        canvas.translate(rectF.left + f5, rectF.top + f5);
        canvas.scale(f9, f10);
        canvas.drawPath(this.f714f, this.f710b);
        if (z) {
            canvas.scale(1.0f / f9, 1.0f);
            i = save2;
            f = f11;
            i2 = save;
            f2 = f10;
            canvas.drawRect(0.0f, f6, this.f712d.width() - f7, -this.f713e, this.f711c);
        } else {
            i = save2;
            f = f11;
            i2 = save;
            f2 = f10;
        }
        canvas.restoreToCount(i);
        int save3 = canvas.save();
        RectF rectF2 = this.f712d;
        canvas.translate(rectF2.right - f5, rectF2.bottom - f5);
        float f12 = f;
        canvas.scale(f9, f12);
        canvas.rotate(180.0f);
        canvas.drawPath(this.f714f, this.f710b);
        if (z) {
            canvas.scale(1.0f / f9, 1.0f);
            f3 = f2;
            f4 = f12;
            canvas.drawRect(0.0f, f6, this.f712d.width() - f7, (-this.f713e) + this.f716h, this.f711c);
        } else {
            f3 = f2;
            f4 = f12;
        }
        canvas.restoreToCount(save3);
        int save4 = canvas.save();
        RectF rectF3 = this.f712d;
        canvas.translate(rectF3.left + f5, rectF3.bottom - f5);
        canvas.scale(f9, f4);
        canvas.rotate(270.0f);
        canvas.drawPath(this.f714f, this.f710b);
        if (z2) {
            canvas.scale(1.0f / f4, 1.0f);
            canvas.drawRect(0.0f, f6, this.f712d.height() - f7, -this.f713e, this.f711c);
        }
        canvas.restoreToCount(save4);
        int save5 = canvas.save();
        RectF rectF4 = this.f712d;
        canvas.translate(rectF4.right - f5, rectF4.top + f5);
        float f13 = f3;
        canvas.scale(f9, f13);
        canvas.rotate(90.0f);
        canvas.drawPath(this.f714f, this.f710b);
        if (z2) {
            canvas.scale(1.0f / f13, 1.0f);
            canvas.drawRect(0.0f, f6, this.f712d.height() - f7, -this.f713e, this.f711c);
        }
        canvas.restoreToCount(save5);
        canvas.restoreToCount(i2);
    }

    /* renamed from: a */
    public final void m10686a(Rect rect) {
        float f = this.f715g;
        float f2 = 1.5f * f;
        this.f712d.set(rect.left + f, rect.top + f2, rect.right - f, rect.bottom - f2);
        Drawable m8910a = m8910a();
        RectF rectF = this.f712d;
        m8910a.setBounds((int) rectF.left, (int) rectF.top, (int) rectF.right, (int) rectF.bottom);
        m10684b();
    }
}
