package p000a.p006b.p049h.p061j.p062j;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.SubMenu;
import p000a.p006b.p030g.p036d.p037a.SupportMenu;

/* renamed from: a.b.h.j.j.s */
/* loaded from: classes.dex */
public class MenuWrapperICS extends BaseMenuWrapper<SupportMenu> implements Menu {
    public MenuWrapperICS(Context context, SupportMenu supportMenu) {
        super(context, supportMenu);
    }

    @Override // android.view.Menu
    public MenuItem add(CharSequence charSequence) {
        return m8720a(((SupportMenu) this.f2328a).add(charSequence));
    }

    @Override // android.view.Menu
    public int addIntentOptions(int i, int i2, int i3, ComponentName componentName, Intent[] intentArr, Intent intent, int i4, MenuItem[] menuItemArr) {
        MenuItem[] menuItemArr2 = menuItemArr != null ? new MenuItem[menuItemArr.length] : null;
        int addIntentOptions = ((SupportMenu) this.f2328a).addIntentOptions(i, i2, i3, componentName, intentArr, intent, i4, menuItemArr2);
        if (menuItemArr2 != null) {
            int length = menuItemArr2.length;
            for (int i5 = 0; i5 < length; i5++) {
                menuItemArr[i5] = m8720a(menuItemArr2[i5]);
            }
        }
        return addIntentOptions;
    }

    @Override // android.view.Menu
    public SubMenu addSubMenu(CharSequence charSequence) {
        return m8719a(((SupportMenu) this.f2328a).addSubMenu(charSequence));
    }

    @Override // android.view.Menu
    public void clear() {
        m8718b();
        ((SupportMenu) this.f2328a).clear();
    }

    @Override // android.view.Menu
    public void close() {
        ((SupportMenu) this.f2328a).close();
    }

    @Override // android.view.Menu
    public MenuItem findItem(int i) {
        return m8720a(((SupportMenu) this.f2328a).findItem(i));
    }

    @Override // android.view.Menu
    public MenuItem getItem(int i) {
        return m8720a(((SupportMenu) this.f2328a).getItem(i));
    }

    @Override // android.view.Menu
    public boolean hasVisibleItems() {
        return ((SupportMenu) this.f2328a).hasVisibleItems();
    }

    @Override // android.view.Menu
    public boolean isShortcutKey(int i, KeyEvent keyEvent) {
        return ((SupportMenu) this.f2328a).isShortcutKey(i, keyEvent);
    }

    @Override // android.view.Menu
    public boolean performIdentifierAction(int i, int i2) {
        return ((SupportMenu) this.f2328a).performIdentifierAction(i, i2);
    }

    @Override // android.view.Menu
    public boolean performShortcut(int i, KeyEvent keyEvent, int i2) {
        return ((SupportMenu) this.f2328a).performShortcut(i, keyEvent, i2);
    }

    @Override // android.view.Menu
    public void removeGroup(int i) {
        m8721a(i);
        ((SupportMenu) this.f2328a).removeGroup(i);
    }

    @Override // android.view.Menu
    public void removeItem(int i) {
        m8717b(i);
        ((SupportMenu) this.f2328a).removeItem(i);
    }

    @Override // android.view.Menu
    public void setGroupCheckable(int i, boolean z, boolean z2) {
        ((SupportMenu) this.f2328a).setGroupCheckable(i, z, z2);
    }

    @Override // android.view.Menu
    public void setGroupEnabled(int i, boolean z) {
        ((SupportMenu) this.f2328a).setGroupEnabled(i, z);
    }

    @Override // android.view.Menu
    public void setGroupVisible(int i, boolean z) {
        ((SupportMenu) this.f2328a).setGroupVisible(i, z);
    }

    @Override // android.view.Menu
    public void setQwertyMode(boolean z) {
        ((SupportMenu) this.f2328a).setQwertyMode(z);
    }

    @Override // android.view.Menu
    public int size() {
        return ((SupportMenu) this.f2328a).size();
    }

    @Override // android.view.Menu
    public MenuItem add(int i) {
        return m8720a(((SupportMenu) this.f2328a).add(i));
    }

    @Override // android.view.Menu
    public SubMenu addSubMenu(int i) {
        return m8719a(((SupportMenu) this.f2328a).addSubMenu(i));
    }

    @Override // android.view.Menu
    public MenuItem add(int i, int i2, int i3, CharSequence charSequence) {
        return m8720a(((SupportMenu) this.f2328a).add(i, i2, i3, charSequence));
    }

    @Override // android.view.Menu
    public SubMenu addSubMenu(int i, int i2, int i3, CharSequence charSequence) {
        return m8719a(((SupportMenu) this.f2328a).addSubMenu(i, i2, i3, charSequence));
    }

    @Override // android.view.Menu
    public MenuItem add(int i, int i2, int i3, int i4) {
        return m8720a(((SupportMenu) this.f2328a).add(i, i2, i3, i4));
    }

    @Override // android.view.Menu
    public SubMenu addSubMenu(int i, int i2, int i3, int i4) {
        return m8719a(((SupportMenu) this.f2328a).addSubMenu(i, i2, i3, i4));
    }
}
