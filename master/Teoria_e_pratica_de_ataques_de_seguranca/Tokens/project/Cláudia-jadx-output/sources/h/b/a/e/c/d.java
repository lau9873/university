package h.b.a.e.c;

import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.DisplayMetrics;
import android.util.TypedValue;
/* compiled from: StopConnector.java */
/* loaded from: classes.dex */
public class d extends a {

    /* renamed from: a  reason: collision with root package name */
    public final Paint f7092a = new Paint(1);

    /* renamed from: b  reason: collision with root package name */
    public final float f7093b;

    /* renamed from: c  reason: collision with root package name */
    public final boolean f7094c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f7095d;

    public d(Resources resources, boolean z, boolean z2) {
        this.f7094c = z;
        this.f7095d = z2;
        DisplayMetrics displayMetrics = resources.getDisplayMetrics();
        this.f7092a.setStrokeWidth(TypedValue.applyDimension(1, 1.25f, displayMetrics));
        this.f7093b = TypedValue.applyDimension(1, z ? 8.0f : 4.0f, displayMetrics);
    }

    public void a(boolean z) {
        if (z != this.f7095d) {
            this.f7095d = z;
            invalidateSelf();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        Paint paint = this.f7092a;
        Rect bounds = getBounds();
        int width = bounds.width();
        int height = bounds.height();
        int i2 = width / 2;
        int i3 = height / 2;
        float f2 = this.f7093b;
        float strokeWidth = paint.getStrokeWidth();
        paint.setStyle(Paint.Style.STROKE);
        paint.setColor(973078528);
        if (this.f7094c) {
            canvas.drawCircle(i2, i3, f2 * 2.0f, paint);
        } else {
            float f3 = i2;
            canvas.drawLine(f3, 0.0f, f3, i3 - f2, paint);
        }
        if (this.f7095d) {
            float f4 = i2;
            canvas.drawLine(f4, i3 + f2, f4, height, paint);
        }
        float f5 = i2;
        float f6 = i3;
        canvas.drawCircle(f5, f6, f2 - (strokeWidth / 2.0f), paint);
        paint.setStyle(Paint.Style.FILL);
        paint.setColor(436207616);
        canvas.drawCircle(f5, f6, f2 - strokeWidth, paint);
    }
}
