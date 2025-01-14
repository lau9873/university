package c.c.a.j;

import android.graphics.drawable.InsetDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import c.c.a.i;
import c.c.a.j.e;
/* compiled from: DefaultScrollerViewProvider.java */
/* loaded from: classes.dex */
public class b extends c {

    /* renamed from: d  reason: collision with root package name */
    public View f3188d;

    /* renamed from: e  reason: collision with root package name */
    public View f3189e;

    @Override // c.c.a.j.c
    public View a(ViewGroup viewGroup) {
        this.f3188d = LayoutInflater.from(c()).inflate(c.c.a.e.fastscroll__default_bubble, viewGroup, false);
        return this.f3188d;
    }

    @Override // c.c.a.j.c
    public View b(ViewGroup viewGroup) {
        this.f3189e = new View(c());
        int dimensionPixelSize = e().e() ? 0 : c().getResources().getDimensionPixelSize(c.c.a.c.fastscroll__handle_inset);
        int dimensionPixelSize2 = !e().e() ? 0 : c().getResources().getDimensionPixelSize(c.c.a.c.fastscroll__handle_inset);
        i.a(this.f3189e, new InsetDrawable(a.b.g.b.b.c(c(), c.c.a.d.fastscroll__default_handle), dimensionPixelSize2, dimensionPixelSize, dimensionPixelSize2, dimensionPixelSize));
        this.f3189e.setLayoutParams(new ViewGroup.LayoutParams(c().getResources().getDimensionPixelSize(e().e() ? c.c.a.c.fastscroll__handle_clickable_width : c.c.a.c.fastscroll__handle_height), c().getResources().getDimensionPixelSize(e().e() ? c.c.a.c.fastscroll__handle_height : c.c.a.c.fastscroll__handle_clickable_width)));
        return this.f3189e;
    }

    @Override // c.c.a.j.c
    public d j() {
        e.c cVar = new e.c(this.f3188d);
        cVar.a(1.0f);
        cVar.b(1.0f);
        return new a(cVar.a());
    }

    @Override // c.c.a.j.c
    public TextView k() {
        return (TextView) this.f3188d;
    }

    @Override // c.c.a.j.c
    public d l() {
        return null;
    }

    @Override // c.c.a.j.c
    public int b() {
        float width;
        int width2;
        if (e().e()) {
            width = this.f3189e.getHeight() / 2.0f;
            width2 = this.f3188d.getHeight();
        } else {
            width = this.f3189e.getWidth() / 2.0f;
            width2 = this.f3188d.getWidth();
        }
        return (int) (width - width2);
    }
}
