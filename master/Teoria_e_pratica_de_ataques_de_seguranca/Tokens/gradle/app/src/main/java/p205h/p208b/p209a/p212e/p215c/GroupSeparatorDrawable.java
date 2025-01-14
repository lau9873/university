package p205h.p208b.p209a.p212e.p215c;

import android.graphics.Canvas;
import android.graphics.Paint;

/* renamed from: h.b.a.e.c.b */
/* loaded from: classes.dex */
public class GroupSeparatorDrawable extends DrawableBase {

    /* renamed from: a */
    public final Paint f9742a = new Paint();

    /* renamed from: b */
    public boolean f9743b = false;

    public GroupSeparatorDrawable(float f) {
        this.f9742a.setStrokeWidth(f);
        this.f9742a.setColor(436207616);
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        if (this.f9743b) {
            Paint paint = this.f9742a;
            int width = canvas.getWidth();
            float strokeWidth = paint.getStrokeWidth() / 2.0f;
            if (this.f9743b) {
                canvas.drawLine(0.0f, strokeWidth, width, strokeWidth, paint);
            }
        }
    }
}
