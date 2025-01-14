package h.b.a.e.c;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import h.b.a.d.k;
import h.b.a.d.l;
import h.b.a.d.p;
/* compiled from: LineDrawable.java */
/* loaded from: classes.dex */
public class c extends a {

    /* renamed from: a  reason: collision with root package name */
    public final Paint f7089a = new Paint(1);

    /* renamed from: b  reason: collision with root package name */
    public l f7090b;

    /* renamed from: c  reason: collision with root package name */
    public k f7091c;

    public void a(k kVar) {
        if (kVar == null) {
            this.f7090b = null;
            this.f7091c = null;
            return;
        }
        p b2 = kVar.b();
        if (b2 != null) {
            this.f7090b = b2.e();
        }
        this.f7091c = kVar;
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        k kVar;
        l lVar = this.f7090b;
        if (lVar == null || (kVar = this.f7091c) == null) {
            return;
        }
        Rect bounds = getBounds();
        int width = bounds.width();
        int height = bounds.height();
        this.f7089a.setColor(lVar.b(kVar));
        float f2 = height;
        float f3 = 0.04f * f2;
        this.f7089a.setStrokeWidth(f3);
        this.f7089a.setStyle(Paint.Style.FILL);
        int c2 = lVar.c(kVar);
        if (c2 == 0) {
            c2 = 704643072;
        }
        if (lVar.a(kVar) == 2) {
            float f4 = width / 2;
            float f5 = height / 2;
            float min = Math.min(width, height) / 2;
            canvas.drawCircle(f4, f5, min, this.f7089a);
            this.f7089a.setStyle(Paint.Style.STROKE);
            this.f7089a.setColor(c2);
            canvas.drawCircle(f4, f5, min - (f3 / 2.0f), this.f7089a);
            return;
        }
        RectF rectF = new RectF(0.0f, 0.0f, width, f2);
        float f6 = f2 * 0.06f;
        canvas.drawRoundRect(rectF, f6, f6, this.f7089a);
        this.f7089a.setStyle(Paint.Style.STROKE);
        this.f7089a.setColor(c2);
        float f7 = f3 / 2.0f;
        rectF.inset(f7, f7);
        canvas.drawRoundRect(rectF, f6, f6, this.f7089a);
    }

    public void a(l lVar, k kVar) {
        this.f7090b = lVar;
        this.f7091c = kVar;
    }
}
