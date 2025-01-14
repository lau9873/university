package p000a.p006b.p049h.p063k;

import android.support.p067v7.widget.RecyclerView;
import android.view.View;

/* renamed from: a.b.h.k.e1 */
/* loaded from: classes.dex */
public abstract class SimpleItemAnimator extends RecyclerView.AbstractC0716l {

    /* renamed from: g */
    public boolean f2609g = true;

    @Override // android.support.p067v7.widget.RecyclerView.AbstractC0716l
    /* renamed from: a */
    public boolean mo6732a(RecyclerView.AbstractC0708d0 abstractC0708d0) {
        return !this.f2609g || abstractC0708d0.m6799p();
    }

    /* renamed from: a */
    public abstract boolean mo8331a(RecyclerView.AbstractC0708d0 abstractC0708d0, int i, int i2, int i3, int i4);

    /* renamed from: a */
    public abstract boolean mo8330a(RecyclerView.AbstractC0708d0 abstractC0708d0, RecyclerView.AbstractC0708d0 abstractC0708d02, int i, int i2, int i3, int i4);

    @Override // android.support.p067v7.widget.RecyclerView.AbstractC0716l
    /* renamed from: b */
    public boolean mo1049b(RecyclerView.AbstractC0708d0 abstractC0708d0, RecyclerView.AbstractC0716l.C0719c c0719c, RecyclerView.AbstractC0716l.C0719c c0719c2) {
        int i = c0719c.f4241a;
        int i2 = c0719c.f4242b;
        View view = abstractC0708d0.f4213a;
        int left = c0719c2 == null ? view.getLeft() : c0719c2.f4241a;
        int top = c0719c2 == null ? view.getTop() : c0719c2.f4242b;
        if (!abstractC0708d0.m6797r() && (i != left || i2 != top)) {
            view.layout(left, top, view.getWidth() + left, view.getHeight() + top);
            return mo8331a(abstractC0708d0, i, i2, left, top);
        }
        return mo8324i(abstractC0708d0);
    }

    /* renamed from: c */
    public void m8438c(RecyclerView.AbstractC0708d0 abstractC0708d0, boolean z) {
    }

    @Override // android.support.p067v7.widget.RecyclerView.AbstractC0716l
    /* renamed from: c */
    public boolean mo1048c(RecyclerView.AbstractC0708d0 abstractC0708d0, RecyclerView.AbstractC0716l.C0719c c0719c, RecyclerView.AbstractC0716l.C0719c c0719c2) {
        if (c0719c.f4241a == c0719c2.f4241a && c0719c.f4242b == c0719c2.f4242b) {
            m8434l(abstractC0708d0);
            return false;
        }
        return mo8331a(abstractC0708d0, c0719c.f4241a, c0719c.f4242b, c0719c2.f4241a, c0719c2.f4242b);
    }

    /* renamed from: d */
    public void m8437d(RecyclerView.AbstractC0708d0 abstractC0708d0, boolean z) {
    }

    /* renamed from: h */
    public abstract boolean mo8325h(RecyclerView.AbstractC0708d0 abstractC0708d0);

    /* renamed from: i */
    public abstract boolean mo8324i(RecyclerView.AbstractC0708d0 abstractC0708d0);

    /* renamed from: j */
    public final void m8436j(RecyclerView.AbstractC0708d0 abstractC0708d0) {
        m8430p(abstractC0708d0);
        m6729b(abstractC0708d0);
    }

    /* renamed from: k */
    public final void m8435k(RecyclerView.AbstractC0708d0 abstractC0708d0) {
        m8429q(abstractC0708d0);
    }

    /* renamed from: l */
    public final void m8434l(RecyclerView.AbstractC0708d0 abstractC0708d0) {
        m8428r(abstractC0708d0);
        m6729b(abstractC0708d0);
    }

    /* renamed from: m */
    public final void m8433m(RecyclerView.AbstractC0708d0 abstractC0708d0) {
        m8427s(abstractC0708d0);
    }

    /* renamed from: n */
    public final void m8432n(RecyclerView.AbstractC0708d0 abstractC0708d0) {
        m8426t(abstractC0708d0);
        m6729b(abstractC0708d0);
    }

    /* renamed from: o */
    public final void m8431o(RecyclerView.AbstractC0708d0 abstractC0708d0) {
        m8425u(abstractC0708d0);
    }

    /* renamed from: p */
    public void m8430p(RecyclerView.AbstractC0708d0 abstractC0708d0) {
    }

    /* renamed from: q */
    public void m8429q(RecyclerView.AbstractC0708d0 abstractC0708d0) {
    }

    /* renamed from: r */
    public void m8428r(RecyclerView.AbstractC0708d0 abstractC0708d0) {
    }

    /* renamed from: s */
    public void m8427s(RecyclerView.AbstractC0708d0 abstractC0708d0) {
    }

    /* renamed from: t */
    public void m8426t(RecyclerView.AbstractC0708d0 abstractC0708d0) {
    }

    /* renamed from: u */
    public void m8425u(RecyclerView.AbstractC0708d0 abstractC0708d0) {
    }

    @Override // android.support.p067v7.widget.RecyclerView.AbstractC0716l
    /* renamed from: a */
    public boolean mo1051a(RecyclerView.AbstractC0708d0 abstractC0708d0, RecyclerView.AbstractC0716l.C0719c c0719c, RecyclerView.AbstractC0716l.C0719c c0719c2) {
        if (c0719c != null && (c0719c.f4241a != c0719c2.f4241a || c0719c.f4242b != c0719c2.f4242b)) {
            return mo8331a(abstractC0708d0, c0719c.f4241a, c0719c.f4242b, c0719c2.f4241a, c0719c2.f4242b);
        }
        return mo8325h(abstractC0708d0);
    }

    @Override // android.support.p067v7.widget.RecyclerView.AbstractC0716l
    /* renamed from: a */
    public boolean mo1052a(RecyclerView.AbstractC0708d0 abstractC0708d0, RecyclerView.AbstractC0708d0 abstractC0708d02, RecyclerView.AbstractC0716l.C0719c c0719c, RecyclerView.AbstractC0716l.C0719c c0719c2) {
        int i;
        int i2;
        int i3 = c0719c.f4241a;
        int i4 = c0719c.f4242b;
        if (abstractC0708d02.m6789z()) {
            int i5 = c0719c.f4241a;
            i2 = c0719c.f4242b;
            i = i5;
        } else {
            i = c0719c2.f4241a;
            i2 = c0719c2.f4242b;
        }
        return mo8330a(abstractC0708d0, abstractC0708d02, i3, i4, i, i2);
    }

    /* renamed from: b */
    public final void m8439b(RecyclerView.AbstractC0708d0 abstractC0708d0, boolean z) {
        m8437d(abstractC0708d0, z);
    }

    /* renamed from: a */
    public final void m8440a(RecyclerView.AbstractC0708d0 abstractC0708d0, boolean z) {
        m8438c(abstractC0708d0, z);
        m6729b(abstractC0708d0);
    }
}
