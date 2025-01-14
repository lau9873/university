package a.b.d.q;

import a.b.h.j.j.k;
import android.content.Context;
import android.view.MenuItem;
import android.view.SubMenu;
/* compiled from: BottomNavigationMenu.java */
/* loaded from: classes.dex */
public final class b extends a.b.h.j.j.h {
    public b(Context context) {
        super(context);
    }

    @Override // a.b.h.j.j.h
    public MenuItem a(int i2, int i3, int i4, CharSequence charSequence) {
        if (size() + 1 <= 5) {
            s();
            MenuItem a2 = super.a(i2, i3, i4, charSequence);
            if (a2 instanceof k) {
                ((k) a2).c(true);
            }
            r();
            return a2;
        }
        throw new IllegalArgumentException("Maximum number of items supported by BottomNavigationView is 5. Limit can be checked with BottomNavigationView#getMaxItemCount()");
    }

    @Override // a.b.h.j.j.h, android.view.Menu
    public SubMenu addSubMenu(int i2, int i3, int i4, CharSequence charSequence) {
        throw new UnsupportedOperationException("BottomNavigationView does not support submenus");
    }
}
