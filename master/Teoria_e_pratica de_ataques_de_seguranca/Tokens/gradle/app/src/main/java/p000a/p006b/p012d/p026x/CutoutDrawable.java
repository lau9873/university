package p000a.p006b.p012d.p026x;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.os.Build;
import android.view.View;

/* renamed from: a.b.d.x.d */
/* loaded from: classes.dex */
public class CutoutDrawable extends GradientDrawable {

    /* renamed from: a */
    public final Paint f614a = new Paint(1);

    /* renamed from: b */
    public final RectF f615b;

    /* renamed from: c */
    public int f616c;

    public CutoutDrawable() {
        m10799c();
        this.f615b = new RectF();
    }

    /* renamed from: a */
    public boolean m10806a() {
        return !this.f615b.isEmpty();
    }

    /* renamed from: b */
    public void m10801b() {
        m10805a(0.0f, 0.0f, 0.0f, 0.0f);
    }

    /* renamed from: c */
    public final void m10799c() {
        this.f614a.setStyle(Paint.Style.FILL_AND_STROKE);
        this.f614a.setColor(-1);
        this.f614a.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_OUT));
    }

    @Override // android.graphics.drawable.GradientDrawable, android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        m10800b(canvas);
        super.draw(canvas);
        canvas.drawRect(this.f615b, this.f614a);
        m10804a(canvas);
    }

    /* renamed from: a */
    public void m10805a(float f, float f2, float f3, float f4) {
        RectF rectF = this.f615b;
        if (f == rectF.left && f2 == rectF.top && f3 == rectF.right && f4 == rectF.bottom) {
            return;
        }
        this.f615b.set(f, f2, f3, f4);
        invalidateSelf();
    }

    /* renamed from: b */
    public final void m10800b(Canvas canvas) {
        Drawable.Callback callback = getCallback();
        if (m10802a(callback)) {
            ((View) callback).setLayerType(2, null);
        } else {
            m10798c(canvas);
        }
    }

    /* renamed from: c */
    public final void m10798c(Canvas canvas) {
        if (Build.VERSION.SDK_INT >= 21) {
            this.f616c = canvas.saveLayer(0.0f, 0.0f, canvas.getWidth(), canvas.getHeight(), null);
        } else {
            this.f616c = canvas.saveLayer(0.0f, 0.0f, canvas.getWidth(), canvas.getHeight(), null, 31);
        }
    }

    /* renamed from: a */
    public void m10803a(RectF rectF) {
        m10805a(rectF.left, rectF.top, rectF.right, rectF.bottom);
    }

    /* renamed from: a */
    public final void m10804a(Canvas canvas) {
        if (m10802a(getCallback())) {
            return;
        }
        canvas.restoreToCount(this.f616c);
    }

    /* renamed from: a */
    public final boolean m10802a(Drawable.Callback callback) {
        return callback instanceof View;
    }
}
