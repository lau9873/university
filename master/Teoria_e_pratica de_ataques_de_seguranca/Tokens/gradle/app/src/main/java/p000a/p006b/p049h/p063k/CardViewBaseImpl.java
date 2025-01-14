package p000a.p006b.p049h.p063k;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import p000a.p006b.p049h.p063k.RoundRectDrawableWithShadow;

/* renamed from: a.b.h.k.d0 */
/* loaded from: classes.dex */
public class CardViewBaseImpl implements CardViewImpl {

    /* renamed from: a */
    public final RectF f2585a = new RectF();

    /* compiled from: CardViewBaseImpl.java */
    /* renamed from: a.b.h.k.d0$a */
    /* loaded from: classes.dex */
    public class C0452a implements RoundRectDrawableWithShadow.InterfaceC0439a {
        public C0452a() {
        }

        @Override // p000a.p006b.p049h.p063k.RoundRectDrawableWithShadow.InterfaceC0439a
        /* renamed from: a */
        public void mo8450a(Canvas canvas, RectF rectF, float f, Paint paint) {
            float f2 = 2.0f * f;
            float width = (rectF.width() - f2) - 1.0f;
            float height = (rectF.height() - f2) - 1.0f;
            if (f >= 1.0f) {
                float f3 = f + 0.5f;
                float f4 = -f3;
                CardViewBaseImpl.this.f2585a.set(f4, f4, f3, f3);
                int save = canvas.save();
                canvas.translate(rectF.left + f3, rectF.top + f3);
                canvas.drawArc(CardViewBaseImpl.this.f2585a, 180.0f, 90.0f, true, paint);
                canvas.translate(width, 0.0f);
                canvas.rotate(90.0f);
                canvas.drawArc(CardViewBaseImpl.this.f2585a, 180.0f, 90.0f, true, paint);
                canvas.translate(height, 0.0f);
                canvas.rotate(90.0f);
                canvas.drawArc(CardViewBaseImpl.this.f2585a, 180.0f, 90.0f, true, paint);
                canvas.translate(width, 0.0f);
                canvas.rotate(90.0f);
                canvas.drawArc(CardViewBaseImpl.this.f2585a, 180.0f, 90.0f, true, paint);
                canvas.restoreToCount(save);
                float f5 = rectF.top;
                canvas.drawRect((rectF.left + f3) - 1.0f, f5, (rectF.right - f3) + 1.0f, f5 + f3, paint);
                float f6 = rectF.bottom;
                canvas.drawRect((rectF.left + f3) - 1.0f, f6 - f3, (rectF.right - f3) + 1.0f, f6, paint);
            }
            canvas.drawRect(rectF.left, rectF.top + f, rectF.right, rectF.bottom - f, paint);
        }
    }

    @Override // p000a.p006b.p049h.p063k.CardViewImpl
    /* renamed from: a */
    public void mo8413a() {
        RoundRectDrawableWithShadow.f2517r = new C0452a();
    }

    @Override // p000a.p006b.p049h.p063k.CardViewImpl
    /* renamed from: b */
    public void mo8407b(CardViewDelegate cardViewDelegate, float f) {
        m8452i(cardViewDelegate).m8526b(f);
        m8451j(cardViewDelegate);
    }

    @Override // p000a.p006b.p049h.p063k.CardViewImpl
    /* renamed from: c */
    public void mo8406c(CardViewDelegate cardViewDelegate) {
    }

    @Override // p000a.p006b.p049h.p063k.CardViewImpl
    /* renamed from: c */
    public void mo8405c(CardViewDelegate cardViewDelegate, float f) {
        m8452i(cardViewDelegate).m8534a(f);
        m8451j(cardViewDelegate);
    }

    @Override // p000a.p006b.p049h.p063k.CardViewImpl
    /* renamed from: d */
    public void mo8404d(CardViewDelegate cardViewDelegate) {
        m8452i(cardViewDelegate).m8528a(cardViewDelegate.mo7063b());
        m8451j(cardViewDelegate);
    }

    @Override // p000a.p006b.p049h.p063k.CardViewImpl
    /* renamed from: e */
    public float mo8403e(CardViewDelegate cardViewDelegate) {
        return m8452i(cardViewDelegate).m8520d();
    }

    @Override // p000a.p006b.p049h.p063k.CardViewImpl
    /* renamed from: f */
    public float mo8402f(CardViewDelegate cardViewDelegate) {
        return m8452i(cardViewDelegate).m8516g();
    }

    @Override // p000a.p006b.p049h.p063k.CardViewImpl
    /* renamed from: g */
    public ColorStateList mo8401g(CardViewDelegate cardViewDelegate) {
        return m8452i(cardViewDelegate).m8527b();
    }

    @Override // p000a.p006b.p049h.p063k.CardViewImpl
    /* renamed from: h */
    public float mo8400h(CardViewDelegate cardViewDelegate) {
        return m8452i(cardViewDelegate).m8522c();
    }

    /* renamed from: i */
    public final RoundRectDrawableWithShadow m8452i(CardViewDelegate cardViewDelegate) {
        return (RoundRectDrawableWithShadow) cardViewDelegate.mo7061d();
    }

    /* renamed from: j */
    public void m8451j(CardViewDelegate cardViewDelegate) {
        Rect rect = new Rect();
        m8452i(cardViewDelegate).m8523b(rect);
        cardViewDelegate.mo7066a((int) Math.ceil(mo8408b(cardViewDelegate)), (int) Math.ceil(mo8412a(cardViewDelegate)));
        cardViewDelegate.mo7065a(rect.left, rect.top, rect.right, rect.bottom);
    }

    @Override // p000a.p006b.p049h.p063k.CardViewImpl
    /* renamed from: a */
    public void mo8410a(CardViewDelegate cardViewDelegate, Context context, ColorStateList colorStateList, float f, float f2, float f3) {
        RoundRectDrawableWithShadow m8453a = m8453a(context, colorStateList, f, f2, f3);
        m8453a.m8528a(cardViewDelegate.mo7063b());
        cardViewDelegate.mo7064a(m8453a);
        m8451j(cardViewDelegate);
    }

    @Override // p000a.p006b.p049h.p063k.CardViewImpl
    /* renamed from: b */
    public float mo8408b(CardViewDelegate cardViewDelegate) {
        return m8452i(cardViewDelegate).m8517f();
    }

    /* renamed from: a */
    public final RoundRectDrawableWithShadow m8453a(Context context, ColorStateList colorStateList, float f, float f2, float f3) {
        return new RoundRectDrawableWithShadow(context.getResources(), colorStateList, f, f2, f3);
    }

    @Override // p000a.p006b.p049h.p063k.CardViewImpl
    /* renamed from: a */
    public void mo8409a(CardViewDelegate cardViewDelegate, ColorStateList colorStateList) {
        m8452i(cardViewDelegate).m8524b(colorStateList);
    }

    @Override // p000a.p006b.p049h.p063k.CardViewImpl
    /* renamed from: a */
    public void mo8411a(CardViewDelegate cardViewDelegate, float f) {
        m8452i(cardViewDelegate).m8521c(f);
    }

    @Override // p000a.p006b.p049h.p063k.CardViewImpl
    /* renamed from: a */
    public float mo8412a(CardViewDelegate cardViewDelegate) {
        return m8452i(cardViewDelegate).m8518e();
    }
}
