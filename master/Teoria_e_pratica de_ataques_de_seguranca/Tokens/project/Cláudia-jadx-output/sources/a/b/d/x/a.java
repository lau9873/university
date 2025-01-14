package a.b.d.x;

import android.content.res.ColorStateList;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.drawable.Drawable;
/* compiled from: CircularBorderDrawable.java */
/* loaded from: classes.dex */
public class a extends Drawable {

    /* renamed from: e  reason: collision with root package name */
    public float f302e;

    /* renamed from: f  reason: collision with root package name */
    public int f303f;

    /* renamed from: g  reason: collision with root package name */
    public int f304g;

    /* renamed from: h  reason: collision with root package name */
    public int f305h;

    /* renamed from: i  reason: collision with root package name */
    public int f306i;
    public ColorStateList j;
    public int k;
    public float m;

    /* renamed from: b  reason: collision with root package name */
    public final Rect f299b = new Rect();

    /* renamed from: c  reason: collision with root package name */
    public final RectF f300c = new RectF();

    /* renamed from: d  reason: collision with root package name */
    public final b f301d = new b();
    public boolean l = true;

    /* renamed from: a  reason: collision with root package name */
    public final Paint f298a = new Paint(1);

    /* compiled from: CircularBorderDrawable.java */
    /* loaded from: classes.dex */
    public class b extends Drawable.ConstantState {
        public b() {
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public int getChangingConfigurations() {
            return 0;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public Drawable newDrawable() {
            return a.this;
        }
    }

    public a() {
        this.f298a.setStyle(Paint.Style.STROKE);
    }

    public void a(int i2, int i3, int i4, int i5) {
        this.f303f = i2;
        this.f304g = i3;
        this.f305h = i4;
        this.f306i = i5;
    }

    public final void b(float f2) {
        if (f2 != this.m) {
            this.m = f2;
            invalidateSelf();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        if (this.l) {
            this.f298a.setShader(a());
            this.l = false;
        }
        float strokeWidth = this.f298a.getStrokeWidth() / 2.0f;
        RectF rectF = this.f300c;
        copyBounds(this.f299b);
        rectF.set(this.f299b);
        rectF.left += strokeWidth;
        rectF.top += strokeWidth;
        rectF.right -= strokeWidth;
        rectF.bottom -= strokeWidth;
        canvas.save();
        canvas.rotate(this.m, rectF.centerX(), rectF.centerY());
        canvas.drawOval(rectF, this.f298a);
        canvas.restore();
    }

    @Override // android.graphics.drawable.Drawable
    public Drawable.ConstantState getConstantState() {
        return this.f301d;
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return this.f302e > 0.0f ? -3 : -2;
    }

    @Override // android.graphics.drawable.Drawable
    public boolean getPadding(Rect rect) {
        int round = Math.round(this.f302e);
        rect.set(round, round, round, round);
        return true;
    }

    @Override // android.graphics.drawable.Drawable
    public boolean isStateful() {
        ColorStateList colorStateList = this.j;
        return (colorStateList != null && colorStateList.isStateful()) || super.isStateful();
    }

    @Override // android.graphics.drawable.Drawable
    public void onBoundsChange(Rect rect) {
        this.l = true;
    }

    @Override // android.graphics.drawable.Drawable
    public boolean onStateChange(int[] iArr) {
        int colorForState;
        ColorStateList colorStateList = this.j;
        if (colorStateList != null && (colorForState = colorStateList.getColorForState(iArr, this.k)) != this.k) {
            this.l = true;
            this.k = colorForState;
        }
        if (this.l) {
            invalidateSelf();
        }
        return this.l;
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i2) {
        this.f298a.setAlpha(i2);
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        this.f298a.setColorFilter(colorFilter);
        invalidateSelf();
    }

    public void a(float f2) {
        if (this.f302e != f2) {
            this.f302e = f2;
            this.f298a.setStrokeWidth(f2 * 1.3333f);
            this.l = true;
            invalidateSelf();
        }
    }

    public void a(ColorStateList colorStateList) {
        if (colorStateList != null) {
            this.k = colorStateList.getColorForState(getState(), this.k);
        }
        this.j = colorStateList;
        this.l = true;
        invalidateSelf();
    }

    public final Shader a() {
        Rect rect = this.f299b;
        copyBounds(rect);
        float height = this.f302e / rect.height();
        return new LinearGradient(0.0f, rect.top, 0.0f, rect.bottom, new int[]{a.b.g.c.a.b(this.f303f, this.k), a.b.g.c.a.b(this.f304g, this.k), a.b.g.c.a.b(a.b.g.c.a.c(this.f304g, 0), this.k), a.b.g.c.a.b(a.b.g.c.a.c(this.f306i, 0), this.k), a.b.g.c.a.b(this.f306i, this.k), a.b.g.c.a.b(this.f305h, this.k)}, new float[]{0.0f, height, 0.5f, 0.5f, 1.0f - height, 1.0f}, Shader.TileMode.CLAMP);
    }
}
