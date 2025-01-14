package a.b.h.j.j;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.SubMenu;
/* compiled from: MenuWrapperICS.java */
/* loaded from: classes.dex */
public class s extends c<a.b.g.d.a.a> implements Menu {
    public s(Context context, a.b.g.d.a.a aVar) {
        super(context, aVar);
    }

    @Override // android.view.Menu
    public MenuItem add(CharSequence charSequence) {
        return a(((a.b.g.d.a.a) this.f1545a).add(charSequence));
    }

    @Override // android.view.Menu
    public int addIntentOptions(int i2, int i3, int i4, ComponentName componentName, Intent[] intentArr, Intent intent, int i5, MenuItem[] menuItemArr) {
        MenuItem[] menuItemArr2 = menuItemArr != null ? new MenuItem[menuItemArr.length] : null;
        int addIntentOptions = ((a.b.g.d.a.a) this.f1545a).addIntentOptions(i2, i3, i4, componentName, intentArr, intent, i5, menuItemArr2);
        if (menuItemArr2 != null) {
            int length = menuItemArr2.length;
            for (int i6 = 0; i6 < length; i6++) {
                menuItemArr[i6] = a(menuItemArr2[i6]);
            }
        }
        return addIntentOptions;
    }

    @Override // android.view.Menu
    public SubMenu addSubMenu(CharSequence charSequence) {
        return a(((a.b.g.d.a.a) this.f1545a).addSubMenu(charSequence));
    }

    @Override // android.view.Menu
    public void clear() {
        b();
        ((a.b.g.d.a.a) this.f1545a).clear();
    }

    @Override // android.view.Menu
    public void close() {
        ((a.b.g.d.a.a) this.f1545a).close();
    }

    @Override // android.view.Menu
    public MenuItem findItem(int i2) {
        return a(((a.b.g.d.a.a) this.f1545a).findItem(i2));
    }

    @Override // android.view.Menu
    public MenuItem getItem(int i2) {
        return a(((a.b.g.d.a.a) this.f1545a).getItem(i2));
    }

    @Override // android.view.Menu
    public boolean hasVisibleItems() {
        return ((a.b.g.d.a.a) this.f1545a).hasVisibleItems();
    }

    @Override // android.view.Menu
    public boolean isShortcutKey(int i2, KeyEvent keyEvent) {
        return ((a.b.g.d.a.a) this.f1545a).isShortcutKey(i2, keyEvent);
    }

    @Override // android.view.Menu
    public boolean performIdentifierAction(int i2, int i3) {
        return ((a.b.g.d.a.a) this.f1545a).performIdentifierAction(i2, i3);
    }

    @Override // android.view.Menu
    public boolean performShortcut(int i2, KeyEvent keyEvent, int i3) {
        return ((a.b.g.d.a.a) this.f1545a).performShortcut(i2, keyEvent, i3);
    }

    @Override // android.view.Menu
    public void removeGroup(int i2) {
        a(i2);
        ((a.b.g.d.a.a) this.f1545a).removeGroup(i2);
    }

    @Override // android.view.Menu
    public void removeItem(int i2) {
        b(i2);
        ((a.b.g.d.a.a) this.f1545a).removeItem(i2);
    }

    @Override // android.view.Menu
    public void setGroupCheckable(int i2, boolean z, boolean z2) {
        ((a.b.g.d.a.a) this.f1545a).setGroupCheckable(i2, z, z2);
    }

    @Override // android.view.Menu
    public void setGroupEnabled(int i2, boolean z) {
        ((a.b.g.d.a.a) this.f1545a).setGroupEnabled(i2, z);
    }

    @Override // android.view.Menu
    public void setGroupVisible(int i2, boolean z) {
        ((a.b.g.d.a.a) this.f1545a).setGroupVisible(i2, z);
    }

    @Override // android.view.Menu
    public void setQwertyMode(boolean z) {
        ((a.b.g.d.a.a) this.f1545a).setQwertyMode(z);
    }

    @Override // android.view.Menu
    public int size() {
        return ((a.b.g.d.a.a) this.f1545a).size();
    }

    @Override // android.view.Menu
    public MenuItem add(int i2) {
        return a(((a.b.g.d.a.a) this.f1545a).add(i2));
    }

    @Override // android.view.Menu
    public SubMenu addSubMenu(int i2) {
        return a(((a.b.g.d.a.a) this.f1545a).addSubMenu(i2));
    }

    @Override // android.view.Menu
    public MenuItem add(int i2, int i3, int i4, CharSequence charSequence) {
        return a(((a.b.g.d.a.a) this.f1545a).add(i2, i3, i4, charSequence));
    }

    @Override // android.view.Menu
    public SubMenu addSubMenu(int i2, int i3, int i4, CharSequence charSequence) {
        return a(((a.b.g.d.a.a) this.f1545a).addSubMenu(i2, i3, i4, charSequence));
    }

    @Override // android.view.Menu
    public MenuItem add(int i2, int i3, int i4, int i5) {
        return a(((a.b.g.d.a.a) this.f1545a).add(i2, i3, i4, i5));
    }

    @Override // android.view.Menu
    public SubMenu addSubMenu(int i2, int i3, int i4, int i5) {
        return a(((a.b.g.d.a.a) this.f1545a).addSubMenu(i2, i3, i4, i5));
    }
}
