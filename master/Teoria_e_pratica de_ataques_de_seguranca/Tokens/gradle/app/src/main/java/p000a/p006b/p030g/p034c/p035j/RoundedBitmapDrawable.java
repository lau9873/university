package p000a.p006b.p030g.p034c.p035j;

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

/* renamed from: a.b.g.c.j.c */
/* loaded from: classes.dex */
public abstract class RoundedBitmapDrawable extends Drawable {

    /* renamed from: a */
    public final Bitmap f1430a;

    /* renamed from: b */
    public int f1431b;

    /* renamed from: e */
    public final BitmapShader f1434e;

    /* renamed from: g */
    public float f1436g;

    /* renamed from: k */
    public boolean f1440k;

    /* renamed from: l */
    public int f1441l;

    /* renamed from: m */
    public int f1442m;

    /* renamed from: c */
    public int f1432c = 119;

    /* renamed from: d */
    public final Paint f1433d = new Paint(3);

    /* renamed from: f */
    public final Matrix f1435f = new Matrix();

    /* renamed from: h */
    public final Rect f1437h = new Rect();

    /* renamed from: i */
    public final RectF f1438i = new RectF();

    /* renamed from: j */
    public boolean f1439j = true;

    public RoundedBitmapDrawable(Resources resources, Bitmap bitmap) {
        this.f1431b = 160;
        if (resources != null) {
            this.f1431b = resources.getDisplayMetrics().densityDpi;
        }
        this.f1430a = bitmap;
        if (this.f1430a != null) {
            m9847a();
            Bitmap bitmap2 = this.f1430a;
            Shader.TileMode tileMode = Shader.TileMode.CLAMP;
            this.f1434e = new BitmapShader(bitmap2, tileMode, tileMode);
            return;
        }
        this.f1442m = -1;
        this.f1441l = -1;
        this.f1434e = null;
    }

    /* renamed from: b */
    public static boolean m9844b(float f) {
        return f > 0.05f;
    }

    /* renamed from: a */
    public final void m9847a() {
        this.f1441l = this.f1430a.getScaledWidth(this.f1431b);
        this.f1442m = this.f1430a.getScaledHeight(this.f1431b);
    }

    /* renamed from: a */
    public abstract void mo9840a(int i, int i2, int i3, Rect rect, Rect rect2);

    /* renamed from: b */
    public float m9845b() {
        return this.f1436g;
    }

    /* renamed from: c */
    public final void m9843c() {
        this.f1436g = Math.min(this.f1442m, this.f1441l) / 2;
    }

    /* renamed from: d */
    public void m9842d() {
        if (this.f1439j) {
            if (this.f1440k) {
                int min = Math.min(this.f1441l, this.f1442m);
                mo9840a(this.f1432c, min, min, getBounds(), this.f1437h);
                int min2 = Math.min(this.f1437h.width(), this.f1437h.height());
                this.f1437h.inset(Math.max(0, (this.f1437h.width() - min2) / 2), Math.max(0, (this.f1437h.height() - min2) / 2));
                this.f1436g = min2 * 0.5f;
            } else {
                mo9840a(this.f1432c, this.f1441l, this.f1442m, getBounds(), this.f1437h);
            }
            this.f1438i.set(this.f1437h);
            if (this.f1434e != null) {
                Matrix matrix = this.f1435f;
                RectF rectF = this.f1438i;
                matrix.setTranslate(rectF.left, rectF.top);
                this.f1435f.preScale(this.f1438i.width() / this.f1430a.getWidth(), this.f1438i.height() / this.f1430a.getHeight());
                this.f1434e.setLocalMatrix(this.f1435f);
                this.f1433d.setShader(this.f1434e);
            }
            this.f1439j = false;
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        Bitmap bitmap = this.f1430a;
        if (bitmap == null) {
            return;
        }
        m9842d();
        if (this.f1433d.getShader() == null) {
            canvas.drawBitmap(bitmap, (Rect) null, this.f1437h, this.f1433d);
            return;
        }
        RectF rectF = this.f1438i;
        float f = this.f1436g;
        canvas.drawRoundRect(rectF, f, f, this.f1433d);
    }

    @Override // android.graphics.drawable.Drawable
    public int getAlpha() {
        return this.f1433d.getAlpha();
    }

    @Override // android.graphics.drawable.Drawable
    public ColorFilter getColorFilter() {
        return this.f1433d.getColorFilter();
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        return this.f1442m;
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        return this.f1441l;
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        Bitmap bitmap;
        return (this.f1432c != 119 || this.f1440k || (bitmap = this.f1430a) == null || bitmap.hasAlpha() || this.f1433d.getAlpha() < 255 || m9844b(this.f1436g)) ? -3 : -1;
    }

    @Override // android.graphics.drawable.Drawable
    public void onBoundsChange(Rect rect) {
        super.onBoundsChange(rect);
        if (this.f1440k) {
            m9843c();
        }
        this.f1439j = true;
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i) {
        if (i != this.f1433d.getAlpha()) {
            this.f1433d.setAlpha(i);
            invalidateSelf();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        this.f1433d.setColorFilter(colorFilter);
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public void setDither(boolean z) {
        this.f1433d.setDither(z);
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public void setFilterBitmap(boolean z) {
        this.f1433d.setFilterBitmap(z);
        invalidateSelf();
    }

    /* renamed from: a */
    public void m9846a(float f) {
        if (this.f1436g == f) {
            return;
        }
        this.f1440k = false;
        if (m9844b(f)) {
            this.f1433d.setShader(this.f1434e);
        } else {
            this.f1433d.setShader(null);
        }
        this.f1436g = f;
        invalidateSelf();
    }
}
