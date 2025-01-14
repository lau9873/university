package a.b.h.j.j;

import a.b.h.j.j.h;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.Menu;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
/* compiled from: SubMenuBuilder.java */
/* loaded from: classes.dex */
public class v extends h implements SubMenu {
    public h B;
    public k C;

    public v(Context context, h hVar, k kVar) {
        super(context);
        this.B = hVar;
        this.C = kVar;
    }

    @Override // a.b.h.j.j.h
    public void a(h.a aVar) {
        this.B.a(aVar);
    }

    @Override // a.b.h.j.j.h
    public boolean b(k kVar) {
        return this.B.b(kVar);
    }

    @Override // a.b.h.j.j.h
    public String d() {
        k kVar = this.C;
        int itemId = kVar != null ? kVar.getItemId() : 0;
        if (itemId == 0) {
            return null;
        }
        return super.d() + ":" + itemId;
    }

    @Override // android.view.SubMenu
    public MenuItem getItem() {
        return this.C;
    }

    @Override // a.b.h.j.j.h
    public h m() {
        return this.B.m();
    }

    @Override // a.b.h.j.j.h
    public boolean o() {
        return this.B.o();
    }

    @Override // a.b.h.j.j.h
    public boolean p() {
        return this.B.p();
    }

    @Override // a.b.h.j.j.h
    public boolean q() {
        return this.B.q();
    }

    @Override // a.b.h.j.j.h, android.view.Menu
    public void setGroupDividerEnabled(boolean z) {
        this.B.setGroupDividerEnabled(z);
    }

    @Override // android.view.SubMenu
    public SubMenu setHeaderIcon(Drawable drawable) {
        super.a(drawable);
        return this;
    }

    @Override // android.view.SubMenu
    public SubMenu setHeaderTitle(CharSequence charSequence) {
        super.a(charSequence);
        return this;
    }

    @Override // android.view.SubMenu
    public SubMenu setHeaderView(View view) {
        super.a(view);
        return this;
    }

    @Override // android.view.SubMenu
    public SubMenu setIcon(Drawable drawable) {
        this.C.setIcon(drawable);
        return this;
    }

    @Override // a.b.h.j.j.h, android.view.Menu
    public void setQwertyMode(boolean z) {
        this.B.setQwertyMode(z);
    }

    public Menu t() {
        return this.B;
    }

    @Override // a.b.h.j.j.h
    public boolean a(h hVar, MenuItem menuItem) {
        return super.a(hVar, menuItem) || this.B.a(hVar, menuItem);
    }

    @Override // android.view.SubMenu
    public SubMenu setHeaderIcon(int i2) {
        super.d(i2);
        return this;
    }

    @Override // android.view.SubMenu
    public SubMenu setHeaderTitle(int i2) {
        super.e(i2);
        return this;
    }

    @Override // android.view.SubMenu
    public SubMenu setIcon(int i2) {
        this.C.setIcon(i2);
        return this;
    }

    @Override // a.b.h.j.j.h
    public boolean a(k kVar) {
        return this.B.a(kVar);
    }
}
