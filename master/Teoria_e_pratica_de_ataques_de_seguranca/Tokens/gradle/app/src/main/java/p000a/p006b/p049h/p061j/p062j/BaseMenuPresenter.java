package p000a.p006b.p049h.p061j.p062j;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import java.util.ArrayList;
import p000a.p006b.p049h.p061j.p062j.MenuPresenter;
import p000a.p006b.p049h.p061j.p062j.MenuView;

/* renamed from: a.b.h.j.j.b */
/* loaded from: classes.dex */
public abstract class BaseMenuPresenter implements MenuPresenter {

    /* renamed from: a */
    public Context f2316a;

    /* renamed from: b */
    public Context f2317b;

    /* renamed from: c */
    public MenuBuilder f2318c;

    /* renamed from: d */
    public LayoutInflater f2319d;

    /* renamed from: e */
    public MenuPresenter.InterfaceC0434a f2320e;

    /* renamed from: f */
    public int f2321f;

    /* renamed from: g */
    public int f2322g;

    /* renamed from: h */
    public MenuView f2323h;

    /* renamed from: i */
    public int f2324i;

    public BaseMenuPresenter(Context context, int i, int i2) {
        this.f2316a = context;
        this.f2319d = LayoutInflater.from(context);
        this.f2321f = i;
        this.f2322g = i2;
    }

    /* renamed from: a */
    public abstract void mo8507a(MenuItemImpl menuItemImpl, MenuView.InterfaceC0435a interfaceC0435a);

    @Override // p000a.p006b.p049h.p061j.p062j.MenuPresenter
    /* renamed from: a */
    public void mo6280a(Context context, MenuBuilder menuBuilder) {
        this.f2317b = context;
        LayoutInflater.from(this.f2317b);
        this.f2318c = menuBuilder;
    }

    /* renamed from: a */
    public abstract boolean mo8508a(int i, MenuItemImpl menuItemImpl);

    @Override // p000a.p006b.p049h.p061j.p062j.MenuPresenter
    /* renamed from: a */
    public boolean mo6283a(MenuBuilder menuBuilder, MenuItemImpl menuItemImpl) {
        return false;
    }

    /* renamed from: b */
    public MenuView mo8498b(ViewGroup viewGroup) {
        if (this.f2323h == null) {
            this.f2323h = (MenuView) this.f2319d.inflate(this.f2321f, viewGroup, false);
            this.f2323h.mo7096a(this.f2318c);
            mo6278a(true);
        }
        return this.f2323h;
    }

    @Override // p000a.p006b.p049h.p061j.p062j.MenuPresenter
    /* renamed from: b */
    public boolean mo6276b(MenuBuilder menuBuilder, MenuItemImpl menuItemImpl) {
        return false;
    }

    /* renamed from: d */
    public MenuPresenter.InterfaceC0434a m8722d() {
        return this.f2320e;
    }

    @Override // p000a.p006b.p049h.p061j.p062j.MenuPresenter
    /* renamed from: a */
    public void mo6278a(boolean z) {
        ViewGroup viewGroup = (ViewGroup) this.f2323h;
        if (viewGroup == null) {
            return;
        }
        MenuBuilder menuBuilder = this.f2318c;
        int i = 0;
        if (menuBuilder != null) {
            menuBuilder.m8679b();
            ArrayList<MenuItemImpl> m8652n = this.f2318c.m8652n();
            int size = m8652n.size();
            int i2 = 0;
            for (int i3 = 0; i3 < size; i3++) {
                MenuItemImpl menuItemImpl = m8652n.get(i3);
                if (mo8508a(i2, menuItemImpl)) {
                    View childAt = viewGroup.getChildAt(i2);
                    MenuItemImpl itemData = childAt instanceof MenuView.InterfaceC0435a ? ((MenuView.InterfaceC0435a) childAt).getItemData() : null;
                    View mo8506a = mo8506a(menuItemImpl, childAt, viewGroup);
                    if (menuItemImpl != itemData) {
                        mo8506a.setPressed(false);
                        mo8506a.jumpDrawablesToCurrentState();
                    }
                    if (mo8506a != childAt) {
                        m8724a(mo8506a, i2);
                    }
                    i2++;
                }
            }
            i = i2;
        }
        while (i < viewGroup.getChildCount()) {
            if (!mo8500a(viewGroup, i)) {
                i++;
            }
        }
    }

    /* renamed from: a */
    public void m8724a(View view, int i) {
        ViewGroup viewGroup = (ViewGroup) view.getParent();
        if (viewGroup != null) {
            viewGroup.removeView(view);
        }
        ((ViewGroup) this.f2323h).addView(view, i);
    }

    /* renamed from: a */
    public boolean mo8500a(ViewGroup viewGroup, int i) {
        viewGroup.removeViewAt(i);
        return true;
    }

    @Override // p000a.p006b.p049h.p061j.p062j.MenuPresenter
    /* renamed from: a */
    public void mo8587a(MenuPresenter.InterfaceC0434a interfaceC0434a) {
        this.f2320e = interfaceC0434a;
    }

    /* renamed from: a */
    public MenuView.InterfaceC0435a m8723a(ViewGroup viewGroup) {
        return (MenuView.InterfaceC0435a) this.f2319d.inflate(this.f2322g, viewGroup, false);
    }

    /* renamed from: a */
    public View mo8506a(MenuItemImpl menuItemImpl, View view, ViewGroup viewGroup) {
        MenuView.InterfaceC0435a m8723a;
        if (view instanceof MenuView.InterfaceC0435a) {
            m8723a = (MenuView.InterfaceC0435a) view;
        } else {
            m8723a = m8723a(viewGroup);
        }
        mo8507a(menuItemImpl, m8723a);
        return (View) m8723a;
    }

    @Override // p000a.p006b.p049h.p061j.p062j.MenuPresenter
    /* renamed from: a */
    public void mo6282a(MenuBuilder menuBuilder, boolean z) {
        MenuPresenter.InterfaceC0434a interfaceC0434a = this.f2320e;
        if (interfaceC0434a != null) {
            interfaceC0434a.mo7079a(menuBuilder, z);
        }
    }

    @Override // p000a.p006b.p049h.p061j.p062j.MenuPresenter
    /* renamed from: a */
    public boolean mo6281a(SubMenuBuilder subMenuBuilder) {
        MenuPresenter.InterfaceC0434a interfaceC0434a = this.f2320e;
        if (interfaceC0434a != null) {
            return interfaceC0434a.mo7080a(subMenuBuilder);
        }
        return false;
    }

    @Override // p000a.p006b.p049h.p061j.p062j.MenuPresenter
    /* renamed from: a */
    public int mo6284a() {
        return this.f2324i;
    }

    /* renamed from: a */
    public void m8725a(int i) {
        this.f2324i = i;
    }
}
