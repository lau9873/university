package h.b.a.e.c;

import android.graphics.Canvas;
import android.graphics.Paint;
/* compiled from: GroupSeparatorDrawable.java */
/* loaded from: classes.dex */
public class b extends a {

    /* renamed from: a  reason: collision with root package name */
    public final Paint f7087a = new Paint();

    /* renamed from: b  reason: collision with root package name */
    public boolean f7088b = false;

    public b(float f2) {
        this.f7087a.setStrokeWidth(f2);
        this.f7087a.setColor(436207616);
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        if (this.f7088b) {
            Paint paint = this.f7087a;
            int width = canvas.getWidth();
            float strokeWidth = paint.getStrokeWidth() / 2.0f;
            if (this.f7088b) {
                canvas.drawLine(0.0f, strokeWidth, width, strokeWidth, paint);
            }
        }
    }
}
