package a.b.g.c.j;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.drawable.Drawable;
/* compiled from: RoundedBitmapDrawable.java */
/* loaded from: classes.dex */
public abstract class c extends Drawable {

    /* renamed from: a  reason: collision with root package name */
    public final Bitmap f924a;

    /* renamed from: b  reason: collision with root package name */
    public int f925b;

    /* renamed from: e  reason: collision with root package name */
    public final BitmapShader f928e;

    /* renamed from: g  reason: collision with root package name */
    public float f930g;
    public boolean k;
    public int l;
    public int m;

    /* renamed from: c  reason: collision with root package name */
    public int f926c = 119;

    /* renamed from: d  reason: collision with root package name */
    public final Paint f927d = new Paint(3);

    /* renamed from: f  reason: collision with root package name */
    public final Matrix f929f = new Matrix();

    /* renamed from: h  reason: collision with root package name */
    public final Rect f931h = new Rect();

    /* renamed from: i  reason: collision with root package name */
    public final RectF f932i = new RectF();
    public boolean j = true;

    public c(Resources resources, Bitmap bitmap) {
        this.f925b = 160;
        if (resources != null) {
            this.f925b = resources.getDisplayMetrics().densityDpi;
        }
        this.f924a = bitmap;
        if (this.f924a != null) {
            a();
            Bitmap bitmap2 = this.f924a;
            Shader.TileMode tileMode = Shader.TileMode.CLAMP;
            this.f928e = new BitmapShader(bitmap2, tileMode, tileMode);
            return;
        }
        this.m = -1;
        this.l = -1;
        this.f928e = null;
    }

    public static boolean b(float f2) {
        return f2 > 0.05f;
    }

    public final void a() {
        this.l = this.f924a.getScaledWidth(this.f925b);
        this.m = this.f924a.getScaledHeight(this.f925b);
    }

    public abstract void a(int i2, int i3, int i4, Rect rect, Rect rect2);

    public float b() {
        return this.f930g;
    }

    public final void c() {
        this.f930g = Math.min(this.m, this.l) / 2;
    }

    public void d() {
        if (this.j) {
            if (this.k) {
                int min = Math.min(this.l, this.m);
                a(this.f926c, min, min, getBounds(), this.f931h);
                int min2 = Math.min(this.f931h.width(), this.f931h.height());
                this.f931h.inset(Math.max(0, (this.f931h.width() - min2) / 2), Math.max(0, (this.f931h.height() - min2) / 2));
                this.f930g = min2 * 0.5f;
            } else {
                a(this.f926c, this.l, this.m, getBounds(), this.f931h);
            }
            this.f932i.set(this.f931h);
            if (this.f928e != null) {
                Matrix matrix = this.f929f;
                RectF rectF = this.f932i;
                matrix.setTranslate(rectF.left, rectF.top);
                this.f929f.preScale(this.f932i.width() / this.f924a.getWidth(), this.f932i.height() / this.f924a.getHeight());
                this.f928e.setLocalMatrix(this.f929f);
                this.f927d.setShader(this.f928e);
            }
            this.j = false;
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        Bitmap bitmap = this.f924a;
        if (bitmap == null) {
            return;
        }
        d();
        if (this.f927d.getShader() == null) {
            canvas.drawBitmap(bitmap, (Rect) null, this.f931h, this.f927d);
            return;
        }
        RectF rectF = this.f932i;
        float f2 = this.f930g;
        canvas.drawRoundRect(rectF, f2, f2, this.f927d);
    }

    @Override // android.graphics.drawable.Drawable
    public int getAlpha() {
        return this.f927d.getAlpha();
    }

    @Override // android.graphics.drawable.Drawable
    public ColorFilter getColorFilter() {
        return this.f927d.getColorFilter();
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        return this.m;
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        return this.l;
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        Bitmap bitmap;
        return (this.f926c != 119 || this.k || (bitmap = this.f924a) == null || bitmap.hasAlpha() || this.f927d.getAlpha() < 255 || b(this.f930g)) ? -3 : -1;
    }

    @Override // android.graphics.drawable.Drawable
    public void onBoundsChange(Rect rect) {
        super.onBoundsChange(rect);
        if (this.k) {
            c();
        }
        this.j = true;
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i2) {
        if (i2 != this.f927d.getAlpha()) {
            this.f927d.setAlpha(i2);
            invalidateSelf();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        this.f927d.setColorFilter(colorFilter);
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public void setDither(boolean z) {
        this.f927d.setDither(z);
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public void setFilterBitmap(boolean z) {
        this.f927d.setFilterBitmap(z);
        invalidateSelf();
    }

    public void a(float f2) {
        if (this.f930g == f2) {
            return;
        }
        this.k = false;
        if (b(f2)) {
            this.f927d.setShader(this.f928e);
        } else {
            this.f927d.setShader(null);
        }
        this.f930g = f2;
        invalidateSelf();
    }
}
