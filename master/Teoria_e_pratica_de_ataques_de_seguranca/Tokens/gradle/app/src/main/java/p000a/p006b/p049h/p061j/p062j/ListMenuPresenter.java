package p000a.p006b.p049h.p061j.p062j;

import android.content.Context;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcelable;
import android.support.p067v7.view.menu.ExpandedMenuView;
import android.util.SparseArray;
import android.view.ContextThemeWrapper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ListAdapter;
import java.util.ArrayList;
import p000a.p006b.p049h.p051b.C0360g;
import p000a.p006b.p049h.p061j.p062j.MenuPresenter;
import p000a.p006b.p049h.p061j.p062j.MenuView;

/* renamed from: a.b.h.j.j.f */
/* loaded from: classes.dex */
public class ListMenuPresenter implements MenuPresenter, AdapterView.OnItemClickListener {

    /* renamed from: a */
    public Context f2366a;

    /* renamed from: b */
    public LayoutInflater f2367b;

    /* renamed from: c */
    public MenuBuilder f2368c;

    /* renamed from: d */
    public ExpandedMenuView f2369d;

    /* renamed from: e */
    public int f2370e;

    /* renamed from: f */
    public int f2371f;

    /* renamed from: g */
    public int f2372g;

    /* renamed from: h */
    public MenuPresenter.InterfaceC0434a f2373h;

    /* renamed from: i */
    public C0424a f2374i;

    /* renamed from: j */
    public int f2375j;

    /* compiled from: ListMenuPresenter.java */
    /* renamed from: a.b.h.j.j.f$a */
    /* loaded from: classes.dex */
    public class C0424a extends BaseAdapter {

        /* renamed from: a */
        public int f2376a = -1;

        public C0424a() {
            m8704a();
        }

        /* renamed from: a */
        public void m8704a() {
            MenuItemImpl m8661f = ListMenuPresenter.this.f2368c.m8661f();
            if (m8661f != null) {
                ArrayList<MenuItemImpl> m8655j = ListMenuPresenter.this.f2368c.m8655j();
                int size = m8655j.size();
                for (int i = 0; i < size; i++) {
                    if (m8655j.get(i) == m8661f) {
                        this.f2376a = i;
                        return;
                    }
                }
            }
            this.f2376a = -1;
        }

        @Override // android.widget.Adapter
        public int getCount() {
            int size = ListMenuPresenter.this.f2368c.m8655j().size() - ListMenuPresenter.this.f2370e;
            return this.f2376a < 0 ? size : size - 1;
        }

        @Override // android.widget.Adapter
        public long getItemId(int i) {
            return i;
        }

        @Override // android.widget.Adapter
        public View getView(int i, View view, ViewGroup viewGroup) {
            if (view == null) {
                ListMenuPresenter listMenuPresenter = ListMenuPresenter.this;
                view = listMenuPresenter.f2367b.inflate(listMenuPresenter.f2372g, viewGroup, false);
            }
            ((MenuView.InterfaceC0435a) view).mo7137a(getItem(i), 0);
            return view;
        }

        @Override // android.widget.BaseAdapter
        public void notifyDataSetChanged() {
            m8704a();
            super.notifyDataSetChanged();
        }

        @Override // android.widget.Adapter
        public MenuItemImpl getItem(int i) {
            ArrayList<MenuItemImpl> m8655j = ListMenuPresenter.this.f2368c.m8655j();
            int i2 = i + ListMenuPresenter.this.f2370e;
            int i3 = this.f2376a;
            if (i3 >= 0 && i2 >= i3) {
                i2++;
            }
            return m8655j.get(i2);
        }
    }

    public ListMenuPresenter(Context context, int i) {
        this(i, 0);
        this.f2366a = context;
        this.f2367b = LayoutInflater.from(this.f2366a);
    }

    @Override // p000a.p006b.p049h.p061j.p062j.MenuPresenter
    /* renamed from: a */
    public void mo6280a(Context context, MenuBuilder menuBuilder) {
        int i = this.f2371f;
        if (i != 0) {
            this.f2366a = new ContextThemeWrapper(context, i);
            this.f2367b = LayoutInflater.from(this.f2366a);
        } else if (this.f2366a != null) {
            this.f2366a = context;
            if (this.f2367b == null) {
                this.f2367b = LayoutInflater.from(this.f2366a);
            }
        }
        this.f2368c = menuBuilder;
        C0424a c0424a = this.f2374i;
        if (c0424a != null) {
            c0424a.notifyDataSetChanged();
        }
    }

    @Override // p000a.p006b.p049h.p061j.p062j.MenuPresenter
    /* renamed from: a */
    public boolean mo6283a(MenuBuilder menuBuilder, MenuItemImpl menuItemImpl) {
        return false;
    }

    /* renamed from: b */
    public void m8706b(Bundle bundle) {
        SparseArray<Parcelable> sparseArray = new SparseArray<>();
        ExpandedMenuView expandedMenuView = this.f2369d;
        if (expandedMenuView != null) {
            expandedMenuView.saveHierarchyState(sparseArray);
        }
        bundle.putSparseParcelableArray("android:menu:list", sparseArray);
    }

    @Override // p000a.p006b.p049h.p061j.p062j.MenuPresenter
    /* renamed from: b */
    public boolean mo6277b() {
        return false;
    }

    @Override // p000a.p006b.p049h.p061j.p062j.MenuPresenter
    /* renamed from: b */
    public boolean mo6276b(MenuBuilder menuBuilder, MenuItemImpl menuItemImpl) {
        return false;
    }

    @Override // p000a.p006b.p049h.p061j.p062j.MenuPresenter
    /* renamed from: c */
    public Parcelable mo6275c() {
        if (this.f2369d == null) {
            return null;
        }
        Bundle bundle = new Bundle();
        m8706b(bundle);
        return bundle;
    }

    /* renamed from: d */
    public ListAdapter m8705d() {
        if (this.f2374i == null) {
            this.f2374i = new C0424a();
        }
        return this.f2374i;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        this.f2368c.m8685a(this.f2374i.getItem(i), this, 0);
    }

    public ListMenuPresenter(int i, int i2) {
        this.f2372g = i;
        this.f2371f = i2;
    }

    /* renamed from: a */
    public MenuView m8707a(ViewGroup viewGroup) {
        if (this.f2369d == null) {
            this.f2369d = (ExpandedMenuView) this.f2367b.inflate(C0360g.abc_expanded_menu_layout, viewGroup, false);
            if (this.f2374i == null) {
                this.f2374i = new C0424a();
            }
            this.f2369d.setAdapter((ListAdapter) this.f2374i);
            this.f2369d.setOnItemClickListener(this);
        }
        return this.f2369d;
    }

    @Override // p000a.p006b.p049h.p061j.p062j.MenuPresenter
    /* renamed from: a */
    public void mo6278a(boolean z) {
        C0424a c0424a = this.f2374i;
        if (c0424a != null) {
            c0424a.notifyDataSetChanged();
        }
    }

    @Override // p000a.p006b.p049h.p061j.p062j.MenuPresenter
    /* renamed from: a */
    public void mo8587a(MenuPresenter.InterfaceC0434a interfaceC0434a) {
        this.f2373h = interfaceC0434a;
    }

    @Override // p000a.p006b.p049h.p061j.p062j.MenuPresenter
    /* renamed from: a */
    public boolean mo6281a(SubMenuBuilder subMenuBuilder) {
        if (subMenuBuilder.hasVisibleItems()) {
            new MenuDialogHelper(subMenuBuilder).m8648a((IBinder) null);
            MenuPresenter.InterfaceC0434a interfaceC0434a = this.f2373h;
            if (interfaceC0434a != null) {
                interfaceC0434a.mo7080a(subMenuBuilder);
                return true;
            }
            return true;
        }
        return false;
    }

    @Override // p000a.p006b.p049h.p061j.p062j.MenuPresenter
    /* renamed from: a */
    public void mo6282a(MenuBuilder menuBuilder, boolean z) {
        MenuPresenter.InterfaceC0434a interfaceC0434a = this.f2373h;
        if (interfaceC0434a != null) {
            interfaceC0434a.mo7079a(menuBuilder, z);
        }
    }

    /* renamed from: a */
    public void m8708a(Bundle bundle) {
        SparseArray<Parcelable> sparseParcelableArray = bundle.getSparseParcelableArray("android:menu:list");
        if (sparseParcelableArray != null) {
            this.f2369d.restoreHierarchyState(sparseParcelableArray);
        }
    }

    @Override // p000a.p006b.p049h.p061j.p062j.MenuPresenter
    /* renamed from: a */
    public int mo6284a() {
        return this.f2375j;
    }

    @Override // p000a.p006b.p049h.p061j.p062j.MenuPresenter
    /* renamed from: a */
    public void mo6279a(Parcelable parcelable) {
        m8708a((Bundle) parcelable);
    }
}
