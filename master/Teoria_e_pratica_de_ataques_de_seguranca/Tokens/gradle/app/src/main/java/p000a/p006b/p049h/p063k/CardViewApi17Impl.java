package p000a.p006b.p049h.p063k;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import p000a.p006b.p049h.p063k.RoundRectDrawableWithShadow;

/* renamed from: a.b.h.k.b0 */
/* loaded from: classes.dex */
public class CardViewApi17Impl extends CardViewBaseImpl {

    /* compiled from: CardViewApi17Impl.java */
    /* renamed from: a.b.h.k.b0$a */
    /* loaded from: classes.dex */
    public class C0440a implements RoundRectDrawableWithShadow.InterfaceC0439a {
        public C0440a(CardViewApi17Impl cardViewApi17Impl) {
        }

        @Override // p000a.p006b.p049h.p063k.RoundRectDrawableWithShadow.InterfaceC0439a
        /* renamed from: a */
        public void mo8450a(Canvas canvas, RectF rectF, float f, Paint paint) {
            canvas.drawRoundRect(rectF, f, f, paint);
        }
    }

    @Override // p000a.p006b.p049h.p063k.CardViewBaseImpl, p000a.p006b.p049h.p063k.CardViewImpl
    /* renamed from: a */
    public void mo8413a() {
        RoundRectDrawableWithShadow.f2517r = new C0440a(this);
    }
}
