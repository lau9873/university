package a.b.h.k;

import a.b.h.k.a1;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
/* compiled from: CardViewBaseImpl.java */
/* loaded from: classes.dex */
public class d0 implements f0 {

    /* renamed from: a  reason: collision with root package name */
    public final RectF f1688a = new RectF();

    /* compiled from: CardViewBaseImpl.java */
    /* loaded from: classes.dex */
    public class a implements a1.a {
        public a() {
        }

        @Override // a.b.h.k.a1.a
        public void a(Canvas canvas, RectF rectF, float f2, Paint paint) {
            float f3 = 2.0f * f2;
            float width = (rectF.width() - f3) - 1.0f;
            float height = (rectF.height() - f3) - 1.0f;
            if (f2 >= 1.0f) {
                float f4 = f2 + 0.5f;
                float f5 = -f4;
                d0.this.f1688a.set(f5, f5, f4, f4);
                int save = canvas.save();
                canvas.translate(rectF.left + f4, rectF.top + f4);
                canvas.drawArc(d0.this.f1688a, 180.0f, 90.0f, true, paint);
                canvas.translate(width, 0.0f);
                canvas.rotate(90.0f);
                canvas.drawArc(d0.this.f1688a, 180.0f, 90.0f, true, paint);
                canvas.translate(height, 0.0f);
                canvas.rotate(90.0f);
                canvas.drawArc(d0.this.f1688a, 180.0f, 90.0f, true, paint);
                canvas.translate(width, 0.0f);
                canvas.rotate(90.0f);
                canvas.drawArc(d0.this.f1688a, 180.0f, 90.0f, true, paint);
                canvas.restoreToCount(save);
                float f6 = rectF.top;
                canvas.drawRect((rectF.left + f4) - 1.0f, f6, (rectF.right - f4) + 1.0f, f6 + f4, paint);
                float f7 = rectF.bottom;
                canvas.drawRect((rectF.left + f4) - 1.0f, f7 - f4, (rectF.right - f4) + 1.0f, f7, paint);
            }
            canvas.drawRect(rectF.left, rectF.top + f2, rectF.right, rectF.bottom - f2, paint);
        }
    }

    @Override // a.b.h.k.f0
    public void a() {
        a1.r = new a();
    }

    @Override // a.b.h.k.f0
    public void b(e0 e0Var, float f2) {
        i(e0Var).b(f2);
        j(e0Var);
    }

    @Override // a.b.h.k.f0
    public void c(e0 e0Var) {
    }

    @Override // a.b.h.k.f0
    public void c(e0 e0Var, float f2) {
        i(e0Var).a(f2);
        j(e0Var);
    }

    @Override // a.b.h.k.f0
    public void d(e0 e0Var) {
        i(e0Var).a(e0Var.b());
        j(e0Var);
    }

    @Override // a.b.h.k.f0
    public float e(e0 e0Var) {
        return i(e0Var).d();
    }

    @Override // a.b.h.k.f0
    public float f(e0 e0Var) {
        return i(e0Var).g();
    }

    @Override // a.b.h.k.f0
    public ColorStateList g(e0 e0Var) {
        return i(e0Var).b();
    }

    @Override // a.b.h.k.f0
    public float h(e0 e0Var) {
        return i(e0Var).c();
    }

    public final a1 i(e0 e0Var) {
        return (a1) e0Var.d();
    }

    public void j(e0 e0Var) {
        Rect rect = new Rect();
        i(e0Var).b(rect);
        e0Var.a((int) Math.ceil(b(e0Var)), (int) Math.ceil(a(e0Var)));
        e0Var.a(rect.left, rect.top, rect.right, rect.bottom);
    }

    @Override // a.b.h.k.f0
    public void a(e0 e0Var, Context context, ColorStateList colorStateList, float f2, float f3, float f4) {
        a1 a2 = a(context, colorStateList, f2, f3, f4);
        a2.a(e0Var.b());
        e0Var.a(a2);
        j(e0Var);
    }

    @Override // a.b.h.k.f0
    public float b(e0 e0Var) {
        return i(e0Var).f();
    }

    public final a1 a(Context context, ColorStateList colorStateList, float f2, float f3, float f4) {
        return new a1(context.getResources(), colorStateList, f2, f3, f4);
    }

    @Override // a.b.h.k.f0
    public void a(e0 e0Var, ColorStateList colorStateList) {
        i(e0Var).b(colorStateList);
    }

    @Override // a.b.h.k.f0
    public void a(e0 e0Var, float f2) {
        i(e0Var).c(f2);
    }

    @Override // a.b.h.k.f0
    public float a(e0 e0Var) {
        return i(e0Var).e();
    }
}
