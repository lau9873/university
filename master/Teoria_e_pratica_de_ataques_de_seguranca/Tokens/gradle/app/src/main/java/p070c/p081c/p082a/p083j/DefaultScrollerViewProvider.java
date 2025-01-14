package p070c.p081c.p082a.p083j;

import android.graphics.drawable.InsetDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import p000a.p006b.p030g.p032b.ContextCompat;
import p070c.p081c.p082a.C0884c;
import p070c.p081c.p082a.C0885d;
import p070c.p081c.p082a.C0886e;
import p070c.p081c.p082a.C0889i;
import p070c.p081c.p082a.p083j.VisibilityAnimationManager;

/* renamed from: c.c.a.j.b */
/* loaded from: classes.dex */
public class DefaultScrollerViewProvider extends ScrollerViewProvider {

    /* renamed from: d */
    public View f5026d;

    /* renamed from: e */
    public View f5027e;

    @Override // p070c.p081c.p082a.p083j.ScrollerViewProvider
    /* renamed from: a */
    public View mo5678a(ViewGroup viewGroup) {
        this.f5026d = LayoutInflater.from(m5674c()).inflate(C0886e.fastscroll__default_bubble, viewGroup, false);
        return this.f5026d;
    }

    @Override // p070c.p081c.p082a.p083j.ScrollerViewProvider
    /* renamed from: b */
    public View mo5675b(ViewGroup viewGroup) {
        this.f5027e = new View(m5674c());
        int dimensionPixelSize = m5672e().m4393e() ? 0 : m5674c().getResources().getDimensionPixelSize(C0884c.fastscroll__handle_inset);
        int dimensionPixelSize2 = !m5672e().m4393e() ? 0 : m5674c().getResources().getDimensionPixelSize(C0884c.fastscroll__handle_inset);
        C0889i.m5681a(this.f5027e, new InsetDrawable(ContextCompat.m10016c(m5674c(), C0885d.fastscroll__default_handle), dimensionPixelSize2, dimensionPixelSize, dimensionPixelSize2, dimensionPixelSize));
        this.f5027e.setLayoutParams(new ViewGroup.LayoutParams(m5674c().getResources().getDimensionPixelSize(m5672e().m4393e() ? C0884c.fastscroll__handle_clickable_width : C0884c.fastscroll__handle_height), m5674c().getResources().getDimensionPixelSize(m5672e().m4393e() ? C0884c.fastscroll__handle_height : C0884c.fastscroll__handle_clickable_width)));
        return this.f5027e;
    }

    @Override // p070c.p081c.p082a.p083j.ScrollerViewProvider
    /* renamed from: j */
    public ViewBehavior mo5667j() {
        VisibilityAnimationManager.C0892c c0892c = new VisibilityAnimationManager.C0892c(this.f5026d);
        c0892c.m5657a(1.0f);
        c0892c.m5656b(1.0f);
        return new DefaultBubbleBehavior(c0892c.mo5655a());
    }

    @Override // p070c.p081c.p082a.p083j.ScrollerViewProvider
    /* renamed from: k */
    public TextView mo5666k() {
        return (TextView) this.f5026d;
    }

    @Override // p070c.p081c.p082a.p083j.ScrollerViewProvider
    /* renamed from: l */
    public ViewBehavior mo5665l() {
        return null;
    }

    @Override // p070c.p081c.p082a.p083j.ScrollerViewProvider
    /* renamed from: b */
    public int mo5676b() {
        float width;
        int width2;
        if (m5672e().m4393e()) {
            width = this.f5027e.getHeight() / 2.0f;
            width2 = this.f5026d.getHeight();
        } else {
            width = this.f5027e.getWidth() / 2.0f;
            width2 = this.f5026d.getWidth();
        }
        return (int) (width - width2);
    }
}
