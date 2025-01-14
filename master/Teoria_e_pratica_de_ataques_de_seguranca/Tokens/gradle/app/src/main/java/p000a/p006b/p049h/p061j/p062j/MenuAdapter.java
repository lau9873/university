package p000a.p006b.p049h.p061j.p062j;

import android.support.p067v7.view.menu.ListMenuItemView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import java.util.ArrayList;
import p000a.p006b.p049h.p061j.p062j.MenuView;

/* renamed from: a.b.h.j.j.g */
/* loaded from: classes.dex */
public class MenuAdapter extends BaseAdapter {

    /* renamed from: a */
    public MenuBuilder f2378a;

    /* renamed from: b */
    public int f2379b = -1;

    /* renamed from: c */
    public boolean f2380c;

    /* renamed from: d */
    public final boolean f2381d;

    /* renamed from: e */
    public final LayoutInflater f2382e;

    /* renamed from: f */
    public final int f2383f;

    public MenuAdapter(MenuBuilder menuBuilder, LayoutInflater layoutInflater, boolean z, int i) {
        this.f2381d = z;
        this.f2382e = layoutInflater;
        this.f2378a = menuBuilder;
        this.f2383f = i;
        m8703a();
    }

    /* renamed from: a */
    public void m8702a(boolean z) {
        this.f2380c = z;
    }

    /* renamed from: b */
    public MenuBuilder m8701b() {
        return this.f2378a;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        ArrayList<MenuItemImpl> m8655j = this.f2381d ? this.f2378a.m8655j() : this.f2378a.m8652n();
        if (this.f2379b < 0) {
            return m8655j.size();
        }
        return m8655j.size() - 1;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        if (view == null) {
            view = this.f2382e.inflate(this.f2383f, viewGroup, false);
        }
        int groupId = getItem(i).getGroupId();
        int i2 = i - 1;
        ListMenuItemView listMenuItemView = (ListMenuItemView) view;
        listMenuItemView.setGroupDividerEnabled(this.f2378a.mo8573o() && groupId != (i2 >= 0 ? getItem(i2).getGroupId() : groupId));
        MenuView.InterfaceC0435a interfaceC0435a = (MenuView.InterfaceC0435a) view;
        if (this.f2380c) {
            listMenuItemView.setForceShowIcon(true);
        }
        interfaceC0435a.mo7137a(getItem(i), 0);
        return view;
    }

    @Override // android.widget.BaseAdapter
    public void notifyDataSetChanged() {
        m8703a();
        super.notifyDataSetChanged();
    }

    /* renamed from: a */
    public void m8703a() {
        MenuItemImpl m8661f = this.f2378a.m8661f();
        if (m8661f != null) {
            ArrayList<MenuItemImpl> m8655j = this.f2378a.m8655j();
            int size = m8655j.size();
            for (int i = 0; i < size; i++) {
                if (m8655j.get(i) == m8661f) {
                    this.f2379b = i;
                    return;
                }
            }
        }
        this.f2379b = -1;
    }

    @Override // android.widget.Adapter
    public MenuItemImpl getItem(int i) {
        ArrayList<MenuItemImpl> m8655j = this.f2381d ? this.f2378a.m8655j() : this.f2378a.m8652n();
        int i2 = this.f2379b;
        if (i2 >= 0 && i >= i2) {
            i++;
        }
        return m8655j.get(i);
    }
}
