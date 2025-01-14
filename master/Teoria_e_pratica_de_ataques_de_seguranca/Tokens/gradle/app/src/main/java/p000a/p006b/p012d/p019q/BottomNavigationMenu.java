package p000a.p006b.p012d.p019q;

import android.content.Context;
import android.view.MenuItem;
import android.view.SubMenu;
import p000a.p006b.p049h.p061j.p062j.MenuBuilder;
import p000a.p006b.p049h.p061j.p062j.MenuItemImpl;

/* renamed from: a.b.d.q.b */
/* loaded from: classes.dex */
public final class BottomNavigationMenu extends MenuBuilder {
    public BottomNavigationMenu(Context context) {
        super(context);
    }

    @Override // p000a.p006b.p049h.p061j.p062j.MenuBuilder
    /* renamed from: a */
    public MenuItem mo8696a(int i, int i2, int i3, CharSequence charSequence) {
        if (size() + 1 <= 5) {
            m8650s();
            MenuItem mo8696a = super.mo8696a(i, i2, i3, charSequence);
            if (mo8696a instanceof MenuItemImpl) {
                ((MenuItemImpl) mo8696a).m8636c(true);
            }
            m8651r();
            return mo8696a;
        }
        throw new IllegalArgumentException("Maximum number of items supported by BottomNavigationView is 5. Limit can be checked with BottomNavigationView#getMaxItemCount()");
    }

    @Override // p000a.p006b.p049h.p061j.p062j.MenuBuilder, android.view.Menu
    public SubMenu addSubMenu(int i, int i2, int i3, CharSequence charSequence) {
        throw new UnsupportedOperationException("BottomNavigationView does not support submenus");
    }
}
