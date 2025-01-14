package a.b.d.x;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.os.Build;
import android.view.View;
/* compiled from: CutoutDrawable.java */
/* loaded from: classes.dex */
public class d extends GradientDrawable {

    /* renamed from: a  reason: collision with root package name */
    public final Paint f317a = new Paint(1);

    /* renamed from: b  reason: collision with root package name */
    public final RectF f318b;

    /* renamed from: c  reason: collision with root package name */
    public int f319c;

    public d() {
        c();
        this.f318b = new RectF();
    }

    public boolean a() {
        return !this.f318b.isEmpty();
    }

    public void b() {
        a(0.0f, 0.0f, 0.0f, 0.0f);
    }

    public final void c() {
        this.f317a.setStyle(Paint.Style.FILL_AND_STROKE);
        this.f317a.setColor(-1);
        this.f317a.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_OUT));
    }

    @Override // android.graphics.drawable.GradientDrawable, android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        b(canvas);
        super.draw(canvas);
        canvas.drawRect(this.f318b, this.f317a);
        a(canvas);
    }

    public void a(float f2, float f3, float f4, float f5) {
        RectF rectF = this.f318b;
        if (f2 == rectF.left && f3 == rectF.top && f4 == rectF.right && f5 == rectF.bottom) {
            return;
        }
        this.f318b.set(f2, f3, f4, f5);
        invalidateSelf();
    }

    public final void b(Canvas canvas) {
        Drawable.Callback callback = getCallback();
        if (a(callback)) {
            ((View) callback).setLayerType(2, null);
        } else {
            c(canvas);
        }
    }

    public final void c(Canvas canvas) {
        if (Build.VERSION.SDK_INT >= 21) {
            this.f319c = canvas.saveLayer(0.0f, 0.0f, canvas.getWidth(), canvas.getHeight(), null);
        } else {
            this.f319c = canvas.saveLayer(0.0f, 0.0f, canvas.getWidth(), canvas.getHeight(), null, 31);
        }
    }

    public void a(RectF rectF) {
        a(rectF.left, rectF.top, rectF.right, rectF.bottom);
    }

    public final void a(Canvas canvas) {
        if (a(getCallback())) {
            return;
        }
        canvas.restoreToCount(this.f319c);
    }

    public final boolean a(Drawable.Callback callback) {
        return callback instanceof View;
    }
}
