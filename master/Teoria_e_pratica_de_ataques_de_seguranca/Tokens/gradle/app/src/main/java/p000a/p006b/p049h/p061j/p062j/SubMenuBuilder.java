package p000a.p006b.p049h.p061j.p062j;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.Menu;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import p000a.p006b.p049h.p061j.p062j.MenuBuilder;

/* renamed from: a.b.h.j.j.v */
/* loaded from: classes.dex */
public class SubMenuBuilder extends MenuBuilder implements SubMenu {

    /* renamed from: B */
    public MenuBuilder f2491B;

    /* renamed from: C */
    public MenuItemImpl f2492C;

    public SubMenuBuilder(Context context, MenuBuilder menuBuilder, MenuItemImpl menuItemImpl) {
        super(context);
        this.f2491B = menuBuilder;
        this.f2492C = menuItemImpl;
    }

    @Override // p000a.p006b.p049h.p061j.p062j.MenuBuilder
    /* renamed from: a */
    public void mo8579a(MenuBuilder.InterfaceC0425a interfaceC0425a) {
        this.f2491B.mo8579a(interfaceC0425a);
    }

    @Override // p000a.p006b.p049h.p061j.p062j.MenuBuilder
    /* renamed from: b */
    public boolean mo8576b(MenuItemImpl menuItemImpl) {
        return this.f2491B.mo8576b(menuItemImpl);
    }

    @Override // p000a.p006b.p049h.p061j.p062j.MenuBuilder
    /* renamed from: d */
    public String mo8575d() {
        MenuItemImpl menuItemImpl = this.f2492C;
        int itemId = menuItemImpl != null ? menuItemImpl.getItemId() : 0;
        if (itemId == 0) {
            return null;
        }
        return super.mo8575d() + ":" + itemId;
    }

    @Override // android.view.SubMenu
    public MenuItem getItem() {
        return this.f2492C;
    }

    @Override // p000a.p006b.p049h.p061j.p062j.MenuBuilder
    /* renamed from: m */
    public MenuBuilder mo8574m() {
        return this.f2491B.mo8574m();
    }

    @Override // p000a.p006b.p049h.p061j.p062j.MenuBuilder
    /* renamed from: o */
    public boolean mo8573o() {
        return this.f2491B.mo8573o();
    }

    @Override // p000a.p006b.p049h.p061j.p062j.MenuBuilder
    /* renamed from: p */
    public boolean mo8572p() {
        return this.f2491B.mo8572p();
    }

    @Override // p000a.p006b.p049h.p061j.p062j.MenuBuilder
    /* renamed from: q */
    public boolean mo8571q() {
        return this.f2491B.mo8571q();
    }

    @Override // p000a.p006b.p049h.p061j.p062j.MenuBuilder, android.view.Menu
    public void setGroupDividerEnabled(boolean z) {
        this.f2491B.setGroupDividerEnabled(z);
    }

    @Override // android.view.SubMenu
    public SubMenu setHeaderIcon(Drawable drawable) {
        super.m8689a(drawable);
        return this;
    }

    @Override // android.view.SubMenu
    public SubMenu setHeaderTitle(CharSequence charSequence) {
        super.m8683a(charSequence);
        return this;
    }

    @Override // android.view.SubMenu
    public SubMenu setHeaderView(View view) {
        super.m8684a(view);
        return this;
    }

    @Override // android.view.SubMenu
    public SubMenu setIcon(Drawable drawable) {
        this.f2492C.setIcon(drawable);
        return this;
    }

    @Override // p000a.p006b.p049h.p061j.p062j.MenuBuilder, android.view.Menu
    public void setQwertyMode(boolean z) {
        this.f2491B.setQwertyMode(z);
    }

    /* renamed from: t */
    public Menu m8570t() {
        return this.f2491B;
    }

    @Override // p000a.p006b.p049h.p061j.p062j.MenuBuilder
    /* renamed from: a */
    public boolean mo8578a(MenuBuilder menuBuilder, MenuItem menuItem) {
        return super.mo8578a(menuBuilder, menuItem) || this.f2491B.mo8578a(menuBuilder, menuItem);
    }

    @Override // android.view.SubMenu
    public SubMenu setHeaderIcon(int i) {
        super.m8669d(i);
        return this;
    }

    @Override // android.view.SubMenu
    public SubMenu setHeaderTitle(int i) {
        super.m8664e(i);
        return this;
    }

    @Override // android.view.SubMenu
    public SubMenu setIcon(int i) {
        this.f2492C.setIcon(i);
        return this;
    }

    @Override // p000a.p006b.p049h.p061j.p062j.MenuBuilder
    /* renamed from: a */
    public boolean mo8577a(MenuItemImpl menuItemImpl) {
        return this.f2491B.mo8577a(menuItemImpl);
    }
}
