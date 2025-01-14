package a.b.h.j.j;

import android.content.Context;
import android.view.MenuItem;
import android.view.SubMenu;
import java.util.Iterator;
import java.util.Map;
/* compiled from: BaseMenuWrapper.java */
/* loaded from: classes.dex */
public abstract class c<T> extends d<T> {

    /* renamed from: b  reason: collision with root package name */
    public final Context f1542b;

    /* renamed from: c  reason: collision with root package name */
    public Map<a.b.g.d.a.b, MenuItem> f1543c;

    /* renamed from: d  reason: collision with root package name */
    public Map<a.b.g.d.a.c, SubMenu> f1544d;

    public c(Context context, T t) {
        super(t);
        this.f1542b = context;
    }

    public final MenuItem a(MenuItem menuItem) {
        if (menuItem instanceof a.b.g.d.a.b) {
            a.b.g.d.a.b bVar = (a.b.g.d.a.b) menuItem;
            if (this.f1543c == null) {
                this.f1543c = new a.b.g.j.a();
            }
            MenuItem menuItem2 = this.f1543c.get(menuItem);
            if (menuItem2 == null) {
                MenuItem a2 = r.a(this.f1542b, bVar);
                this.f1543c.put(bVar, a2);
                return a2;
            }
            return menuItem2;
        }
        return menuItem;
    }

    public final void b() {
        Map<a.b.g.d.a.b, MenuItem> map = this.f1543c;
        if (map != null) {
            map.clear();
        }
        Map<a.b.g.d.a.c, SubMenu> map2 = this.f1544d;
        if (map2 != null) {
            map2.clear();
        }
    }

    public final void b(int i2) {
        Map<a.b.g.d.a.b, MenuItem> map = this.f1543c;
        if (map == null) {
            return;
        }
        Iterator<a.b.g.d.a.b> it = map.keySet().iterator();
        while (it.hasNext()) {
            if (i2 == it.next().getItemId()) {
                it.remove();
                return;
            }
        }
    }

    public final SubMenu a(SubMenu subMenu) {
        if (subMenu instanceof a.b.g.d.a.c) {
            a.b.g.d.a.c cVar = (a.b.g.d.a.c) subMenu;
            if (this.f1544d == null) {
                this.f1544d = new a.b.g.j.a();
            }
            SubMenu subMenu2 = this.f1544d.get(cVar);
            if (subMenu2 == null) {
                SubMenu a2 = r.a(this.f1542b, cVar);
                this.f1544d.put(cVar, a2);
                return a2;
            }
            return subMenu2;
        }
        return subMenu;
    }

    public final void a(int i2) {
        Map<a.b.g.d.a.b, MenuItem> map = this.f1543c;
        if (map == null) {
            return;
        }
        Iterator<a.b.g.d.a.b> it = map.keySet().iterator();
        while (it.hasNext()) {
            if (i2 == it.next().getGroupId()) {
                it.remove();
            }
        }
    }
}
