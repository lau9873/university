package p205h.p208b.p209a.p212e.p215c;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import p205h.p208b.p209a.p210d.Line;
import p205h.p208b.p209a.p210d.LineFormatter;
import p205h.p208b.p209a.p210d.Operator;

/* renamed from: h.b.a.e.c.c */
/* loaded from: classes.dex */
public class LineDrawable extends DrawableBase {

    /* renamed from: a */
    public final Paint f9744a = new Paint(1);

    /* renamed from: b */
    public LineFormatter f9745b;

    /* renamed from: c */
    public Line f9746c;

    /* renamed from: a */
    public void m1208a(Line line) {
        if (line == null) {
            this.f9745b = null;
            this.f9746c = null;
            return;
        }
        Operator mo1312b = line.mo1312b();
        if (mo1312b != null) {
            this.f9745b = mo1312b.mo1287e();
        }
        this.f9746c = line;
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        Line line;
        LineFormatter lineFormatter = this.f9745b;
        if (lineFormatter == null || (line = this.f9746c) == null) {
            return;
        }
        Rect bounds = getBounds();
        int width = bounds.width();
        int height = bounds.height();
        this.f9744a.setColor(lineFormatter.mo1307b(line));
        float f = height;
        float f2 = 0.04f * f;
        this.f9744a.setStrokeWidth(f2);
        this.f9744a.setStyle(Paint.Style.FILL);
        int mo1306c = lineFormatter.mo1306c(line);
        if (mo1306c == 0) {
            mo1306c = 704643072;
        }
        if (lineFormatter.mo1308a(line) == 2) {
            float f3 = width / 2;
            float f4 = height / 2;
            float min = Math.min(width, height) / 2;
            canvas.drawCircle(f3, f4, min, this.f9744a);
            this.f9744a.setStyle(Paint.Style.STROKE);
            this.f9744a.setColor(mo1306c);
            canvas.drawCircle(f3, f4, min - (f2 / 2.0f), this.f9744a);
            return;
        }
        RectF rectF = new RectF(0.0f, 0.0f, width, f);
        float f5 = f * 0.06f;
        canvas.drawRoundRect(rectF, f5, f5, this.f9744a);
        this.f9744a.setStyle(Paint.Style.STROKE);
        this.f9744a.setColor(mo1306c);
        float f6 = f2 / 2.0f;
        rectF.inset(f6, f6);
        canvas.drawRoundRect(rectF, f5, f5, this.f9744a);
    }

    /* renamed from: a */
    public void m1207a(LineFormatter lineFormatter, Line line) {
        this.f9745b = lineFormatter;
        this.f9746c = line;
    }
}
