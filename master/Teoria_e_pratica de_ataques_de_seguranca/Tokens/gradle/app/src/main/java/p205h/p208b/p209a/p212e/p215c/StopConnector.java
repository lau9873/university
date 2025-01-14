package p205h.p208b.p209a.p212e.p215c;

import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.DisplayMetrics;
import android.util.TypedValue;

/* renamed from: h.b.a.e.c.d */
/* loaded from: classes.dex */
public class StopConnector extends DrawableBase {

    /* renamed from: a */
    public final Paint f9747a = new Paint(1);

    /* renamed from: b */
    public final float f9748b;

    /* renamed from: c */
    public final boolean f9749c;

    /* renamed from: d */
    public boolean f9750d;

    public StopConnector(Resources resources, boolean z, boolean z2) {
        this.f9749c = z;
        this.f9750d = z2;
        DisplayMetrics displayMetrics = resources.getDisplayMetrics();
        this.f9747a.setStrokeWidth(TypedValue.applyDimension(1, 1.25f, displayMetrics));
        this.f9748b = TypedValue.applyDimension(1, z ? 8.0f : 4.0f, displayMetrics);
    }

    /* renamed from: a */
    public void m1206a(boolean z) {
        if (z != this.f9750d) {
            this.f9750d = z;
            invalidateSelf();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        Paint paint = this.f9747a;
        Rect bounds = getBounds();
        int width = bounds.width();
        int height = bounds.height();
        int i = width / 2;
        int i2 = height / 2;
        float f = this.f9748b;
        float strokeWidth = paint.getStrokeWidth();
        paint.setStyle(Paint.Style.STROKE);
        paint.setColor(973078528);
        if (this.f9749c) {
            canvas.drawCircle(i, i2, f * 2.0f, paint);
        } else {
            float f2 = i;
            canvas.drawLine(f2, 0.0f, f2, i2 - f, paint);
        }
        if (this.f9750d) {
            float f3 = i;
            canvas.drawLine(f3, i2 + f, f3, height, paint);
        }
        float f4 = i;
        float f5 = i2;
        canvas.drawCircle(f4, f5, f - (strokeWidth / 2.0f), paint);
        paint.setStyle(Paint.Style.FILL);
        paint.setColor(436207616);
        canvas.drawCircle(f4, f5, f - strokeWidth, paint);
    }
}
