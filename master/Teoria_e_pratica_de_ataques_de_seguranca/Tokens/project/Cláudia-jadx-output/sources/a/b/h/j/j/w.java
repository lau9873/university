package a.b.h.j.j;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
/* compiled from: SubMenuWrapperICS.java */
/* loaded from: classes.dex */
public class w extends s implements SubMenu {
    public w(Context context, a.b.g.d.a.c cVar) {
        super(context, cVar);
    }

    public a.b.g.d.a.c c() {
        return (a.b.g.d.a.c) this.f1545a;
    }

    @Override // android.view.SubMenu
    public void clearHeader() {
        c().clearHeader();
    }

    @Override // android.view.SubMenu
    public MenuItem getItem() {
        return a(c().getItem());
    }

    @Override // android.view.SubMenu
    public SubMenu setHeaderIcon(int i2) {
        c().setHeaderIcon(i2);
        return this;
    }

    @Override // android.view.SubMenu
    public SubMenu setHeaderTitle(int i2) {
        c().setHeaderTitle(i2);
        return this;
    }

    @Override // android.view.SubMenu
    public SubMenu setHeaderView(View view) {
        c().setHeaderView(view);
        return this;
    }

    @Override // android.view.SubMenu
    public SubMenu setIcon(int i2) {
        c().setIcon(i2);
        return this;
    }

    @Override // android.view.SubMenu
    public SubMenu setHeaderIcon(Drawable drawable) {
        c().setHeaderIcon(drawable);
        return this;
    }

    @Override // android.view.SubMenu
    public SubMenu setHeaderTitle(CharSequence charSequence) {
        c().setHeaderTitle(charSequence);
        return this;
    }

    @Override // android.view.SubMenu
    public SubMenu setIcon(Drawable drawable) {
        c().setIcon(drawable);
        return this;
    }
}
