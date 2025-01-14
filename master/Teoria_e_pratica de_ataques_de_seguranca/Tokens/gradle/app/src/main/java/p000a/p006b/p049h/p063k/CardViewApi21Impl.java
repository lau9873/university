package p000a.p006b.p049h.p063k;

import android.content.Context;
import android.content.res.ColorStateList;
import android.view.View;

/* renamed from: a.b.h.k.c0 */
/* loaded from: classes.dex */
public class CardViewApi21Impl implements CardViewImpl {
    @Override // p000a.p006b.p049h.p063k.CardViewImpl
    /* renamed from: a */
    public void mo8413a() {
    }

    @Override // p000a.p006b.p049h.p063k.CardViewImpl
    /* renamed from: a */
    public void mo8410a(CardViewDelegate cardViewDelegate, Context context, ColorStateList colorStateList, float f, float f2, float f3) {
        cardViewDelegate.mo7064a(new RoundRectDrawable(colorStateList, f));
        View mo7067a = cardViewDelegate.mo7067a();
        mo7067a.setClipToOutline(true);
        mo7067a.setElevation(f2);
        mo8407b(cardViewDelegate, f3);
    }

    @Override // p000a.p006b.p049h.p063k.CardViewImpl
    /* renamed from: b */
    public void mo8407b(CardViewDelegate cardViewDelegate, float f) {
        m8483i(cardViewDelegate).m7967a(f, cardViewDelegate.mo7062c(), cardViewDelegate.mo7063b());
        m8482j(cardViewDelegate);
    }

    @Override // p000a.p006b.p049h.p063k.CardViewImpl
    /* renamed from: c */
    public void mo8405c(CardViewDelegate cardViewDelegate, float f) {
        m8483i(cardViewDelegate).m7968a(f);
    }

    @Override // p000a.p006b.p049h.p063k.CardViewImpl
    /* renamed from: d */
    public void mo8404d(CardViewDelegate cardViewDelegate) {
        mo8407b(cardViewDelegate, mo8403e(cardViewDelegate));
    }

    @Override // p000a.p006b.p049h.p063k.CardViewImpl
    /* renamed from: e */
    public float mo8403e(CardViewDelegate cardViewDelegate) {
        return m8483i(cardViewDelegate).m7963b();
    }

    @Override // p000a.p006b.p049h.p063k.CardViewImpl
    /* renamed from: f */
    public float mo8402f(CardViewDelegate cardViewDelegate) {
        return cardViewDelegate.mo7067a().getElevation();
    }

    @Override // p000a.p006b.p049h.p063k.CardViewImpl
    /* renamed from: g */
    public ColorStateList mo8401g(CardViewDelegate cardViewDelegate) {
        return m8483i(cardViewDelegate).m7969a();
    }

    @Override // p000a.p006b.p049h.p063k.CardViewImpl
    /* renamed from: h */
    public float mo8400h(CardViewDelegate cardViewDelegate) {
        return m8483i(cardViewDelegate).m7961c();
    }

    /* renamed from: i */
    public final RoundRectDrawable m8483i(CardViewDelegate cardViewDelegate) {
        return (RoundRectDrawable) cardViewDelegate.mo7061d();
    }

    /* renamed from: j */
    public void m8482j(CardViewDelegate cardViewDelegate) {
        if (!cardViewDelegate.mo7062c()) {
            cardViewDelegate.mo7065a(0, 0, 0, 0);
            return;
        }
        float mo8403e = mo8403e(cardViewDelegate);
        float mo8400h = mo8400h(cardViewDelegate);
        int ceil = (int) Math.ceil(RoundRectDrawableWithShadow.m8532a(mo8403e, mo8400h, cardViewDelegate.mo7063b()));
        int ceil2 = (int) Math.ceil(RoundRectDrawableWithShadow.m8525b(mo8403e, mo8400h, cardViewDelegate.mo7063b()));
        cardViewDelegate.mo7065a(ceil, ceil2, ceil, ceil2);
    }

    @Override // p000a.p006b.p049h.p063k.CardViewImpl
    /* renamed from: c */
    public void mo8406c(CardViewDelegate cardViewDelegate) {
        mo8407b(cardViewDelegate, mo8403e(cardViewDelegate));
    }

    @Override // p000a.p006b.p049h.p063k.CardViewImpl
    /* renamed from: b */
    public float mo8408b(CardViewDelegate cardViewDelegate) {
        return mo8400h(cardViewDelegate) * 2.0f;
    }

    @Override // p000a.p006b.p049h.p063k.CardViewImpl
    /* renamed from: a */
    public float mo8412a(CardViewDelegate cardViewDelegate) {
        return mo8400h(cardViewDelegate) * 2.0f;
    }

    @Override // p000a.p006b.p049h.p063k.CardViewImpl
    /* renamed from: a */
    public void mo8411a(CardViewDelegate cardViewDelegate, float f) {
        cardViewDelegate.mo7067a().setElevation(f);
    }

    @Override // p000a.p006b.p049h.p063k.CardViewImpl
    /* renamed from: a */
    public void mo8409a(CardViewDelegate cardViewDelegate, ColorStateList colorStateList) {
        m8483i(cardViewDelegate).m7962b(colorStateList);
    }
}
