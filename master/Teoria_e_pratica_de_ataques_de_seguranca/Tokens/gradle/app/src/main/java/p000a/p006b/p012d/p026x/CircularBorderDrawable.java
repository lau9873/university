package p000a.p006b.p012d.p026x;

import android.content.res.ColorStateList;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.drawable.Drawable;
import p000a.p006b.p030g.p034c.ColorUtils;

/* renamed from: a.b.d.x.a */
/* loaded from: classes.dex */
public class CircularBorderDrawable extends Drawable {

    /* renamed from: e */
    public float f557e;

    /* renamed from: f */
    public int f558f;

    /* renamed from: g */
    public int f559g;

    /* renamed from: h */
    public int f560h;

    /* renamed from: i */
    public int f561i;

    /* renamed from: j */
    public ColorStateList f562j;

    /* renamed from: k */
    public int f563k;

    /* renamed from: m */
    public float f565m;

    /* renamed from: b */
    public final Rect f554b = new Rect();

    /* renamed from: c */
    public final RectF f555c = new RectF();

    /* renamed from: d */
    public final C0063b f556d = new C0063b();

    /* renamed from: l */
    public boolean f564l = true;

    /* renamed from: a */
    public final Paint f553a = new Paint(1);

    /* compiled from: CircularBorderDrawable.java */
    /* renamed from: a.b.d.x.a$b */
    /* loaded from: classes.dex */
    public class C0063b extends Drawable.ConstantState {
        public C0063b() {
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public int getChangingConfigurations() {
            return 0;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public Drawable newDrawable() {
            return CircularBorderDrawable.this;
        }
    }

    public CircularBorderDrawable() {
        this.f553a.setStyle(Paint.Style.STROKE);
    }

    /* renamed from: a */
    public void m10849a(int i, int i2, int i3, int i4) {
        this.f558f = i;
        this.f559g = i2;
        this.f560h = i3;
        this.f561i = i4;
    }

    /* renamed from: b */
    public final void m10847b(float f) {
        if (f != this.f565m) {
            this.f565m = f;
            invalidateSelf();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        if (this.f564l) {
            this.f553a.setShader(m10851a());
            this.f564l = false;
        }
        float strokeWidth = this.f553a.getStrokeWidth() / 2.0f;
        RectF rectF = this.f555c;
        copyBounds(this.f554b);
        rectF.set(this.f554b);
        rectF.left += strokeWidth;
        rectF.top += strokeWidth;
        rectF.right -= strokeWidth;
        rectF.bottom -= strokeWidth;
        canvas.save();
        canvas.rotate(this.f565m, rectF.centerX(), rectF.centerY());
        canvas.drawOval(rectF, this.f553a);
        canvas.restore();
    }

    @Override // android.graphics.drawable.Drawable
    public Drawable.ConstantState getConstantState() {
        return this.f556d;
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return this.f557e > 0.0f ? -3 : -2;
    }

    @Override // android.graphics.drawable.Drawable
    public boolean getPadding(Rect rect) {
        int round = Math.round(this.f557e);
        rect.set(round, round, round, round);
        return true;
    }

    @Override // android.graphics.drawable.Drawable
    public boolean isStateful() {
        ColorStateList colorStateList = this.f562j;
        return (colorStateList != null && colorStateList.isStateful()) || super.isStateful();
    }

    @Override // android.graphics.drawable.Drawable
    public void onBoundsChange(Rect rect) {
        this.f564l = true;
    }

    @Override // android.graphics.drawable.Drawable
    public boolean onStateChange(int[] iArr) {
        int colorForState;
        ColorStateList colorStateList = this.f562j;
        if (colorStateList != null && (colorForState = colorStateList.getColorForState(iArr, this.f563k)) != this.f563k) {
            this.f564l = true;
            this.f563k = colorForState;
        }
        if (this.f564l) {
            invalidateSelf();
        }
        return this.f564l;
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i) {
        this.f553a.setAlpha(i);
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        this.f553a.setColorFilter(colorFilter);
        invalidateSelf();
    }

    /* renamed from: a */
    public void m10850a(float f) {
        if (this.f557e != f) {
            this.f557e = f;
            this.f553a.setStrokeWidth(f * 1.3333f);
            this.f564l = true;
            invalidateSelf();
        }
    }

    /* renamed from: a */
    public void m10848a(ColorStateList colorStateList) {
        if (colorStateList != null) {
            this.f563k = colorStateList.getColorForState(getState(), this.f563k);
        }
        this.f562j = colorStateList;
        this.f564l = true;
        invalidateSelf();
    }

    /* renamed from: a */
    public final Shader m10851a() {
        Rect rect = this.f554b;
        copyBounds(rect);
        float height = this.f557e / rect.height();
        return new LinearGradient(0.0f, rect.top, 0.0f, rect.bottom, new int[]{ColorUtils.m9926b(this.f558f, this.f563k), ColorUtils.m9926b(this.f559g, this.f563k), ColorUtils.m9926b(ColorUtils.m9925c(this.f559g, 0), this.f563k), ColorUtils.m9926b(ColorUtils.m9925c(this.f561i, 0), this.f563k), ColorUtils.m9926b(this.f561i, this.f563k), ColorUtils.m9926b(this.f560h, this.f563k)}, new float[]{0.0f, height, 0.5f, 0.5f, 1.0f - height, 1.0f}, Shader.TileMode.CLAMP);
    }
}
