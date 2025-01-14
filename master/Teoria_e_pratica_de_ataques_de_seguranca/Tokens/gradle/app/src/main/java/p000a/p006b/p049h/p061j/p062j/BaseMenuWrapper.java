package p000a.p006b.p049h.p061j.p062j;

import android.content.Context;
import android.view.MenuItem;
import android.view.SubMenu;
import java.util.Iterator;
import java.util.Map;
import p000a.p006b.p030g.p036d.p037a.SupportMenuItem;
import p000a.p006b.p030g.p036d.p037a.SupportSubMenu;
import p000a.p006b.p030g.p044j.ArrayMap;

/* renamed from: a.b.h.j.j.c */
/* loaded from: classes.dex */
public abstract class BaseMenuWrapper<T> extends BaseWrapper<T> {

    /* renamed from: b */
    public final Context f2325b;

    /* renamed from: c */
    public Map<SupportMenuItem, MenuItem> f2326c;

    /* renamed from: d */
    public Map<SupportSubMenu, SubMenu> f2327d;

    public BaseMenuWrapper(Context context, T t) {
        super(t);
        this.f2325b = context;
    }

    /* renamed from: a */
    public final MenuItem m8720a(MenuItem menuItem) {
        if (menuItem instanceof SupportMenuItem) {
            SupportMenuItem supportMenuItem = (SupportMenuItem) menuItem;
            if (this.f2326c == null) {
                this.f2326c = new ArrayMap();
            }
            MenuItem menuItem2 = this.f2326c.get(menuItem);
            if (menuItem2 == null) {
                MenuItem m8591a = MenuWrapperFactory.m8591a(this.f2325b, supportMenuItem);
                this.f2326c.put(supportMenuItem, m8591a);
                return m8591a;
            }
            return menuItem2;
        }
        return menuItem;
    }

    /* renamed from: b */
    public final void m8718b() {
        Map<SupportMenuItem, MenuItem> map = this.f2326c;
        if (map != null) {
            map.clear();
        }
        Map<SupportSubMenu, SubMenu> map2 = this.f2327d;
        if (map2 != null) {
            map2.clear();
        }
    }

    /* renamed from: b */
    public final void m8717b(int i) {
        Map<SupportMenuItem, MenuItem> map = this.f2326c;
        if (map == null) {
            return;
        }
        Iterator<SupportMenuItem> it = map.keySet().iterator();
        while (it.hasNext()) {
            if (i == it.next().getItemId()) {
                it.remove();
                return;
            }
        }
    }

    /* renamed from: a */
    public final SubMenu m8719a(SubMenu subMenu) {
        if (subMenu instanceof SupportSubMenu) {
            SupportSubMenu supportSubMenu = (SupportSubMenu) subMenu;
            if (this.f2327d == null) {
                this.f2327d = new ArrayMap();
            }
            SubMenu subMenu2 = this.f2327d.get(supportSubMenu);
            if (subMenu2 == null) {
                SubMenu m8590a = MenuWrapperFactory.m8590a(this.f2325b, supportSubMenu);
                this.f2327d.put(supportSubMenu, m8590a);
                return m8590a;
            }
            return subMenu2;
        }
        return subMenu;
    }

    /* renamed from: a */
    public final void m8721a(int i) {
        Map<SupportMenuItem, MenuItem> map = this.f2326c;
        if (map == null) {
            return;
        }
        Iterator<SupportMenuItem> it = map.keySet().iterator();
        while (it.hasNext()) {
            if (i == it.next().getGroupId()) {
                it.remove();
            }
        }
    }
}
