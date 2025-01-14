package p000a.p006b.p049h.p061j.p062j;

import android.content.Context;
import android.graphics.Rect;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.FrameLayout;
import android.widget.HeaderViewListAdapter;
import android.widget.ListAdapter;
import android.widget.PopupWindow;

/* renamed from: a.b.h.j.j.n */
/* loaded from: classes.dex */
public abstract class MenuPopup implements ShowableListMenu, MenuPresenter, AdapterView.OnItemClickListener {

    /* renamed from: a */
    public Rect f2454a;

    /* renamed from: b */
    public static boolean m8608b(MenuBuilder menuBuilder) {
        int size = menuBuilder.size();
        for (int i = 0; i < size; i++) {
            MenuItem item = menuBuilder.getItem(i);
            if (item.isVisible() && item.getIcon() != null) {
                return true;
            }
        }
        return false;
    }

    @Override // p000a.p006b.p049h.p061j.p062j.MenuPresenter
    /* renamed from: a */
    public int mo6284a() {
        return 0;
    }

    /* renamed from: a */
    public abstract void mo8589a(int i);

    /* renamed from: a */
    public abstract void mo8588a(MenuBuilder menuBuilder);

    @Override // p000a.p006b.p049h.p061j.p062j.MenuPresenter
    /* renamed from: a */
    public void mo6280a(Context context, MenuBuilder menuBuilder) {
    }

    /* renamed from: a */
    public void m8611a(Rect rect) {
        this.f2454a = rect;
    }

    /* renamed from: a */
    public abstract void mo8586a(View view);

    /* renamed from: a */
    public abstract void mo8585a(PopupWindow.OnDismissListener onDismissListener);

    @Override // p000a.p006b.p049h.p061j.p062j.MenuPresenter
    /* renamed from: a */
    public boolean mo6283a(MenuBuilder menuBuilder, MenuItemImpl menuItemImpl) {
        return false;
    }

    /* renamed from: b */
    public abstract void mo8584b(int i);

    /* renamed from: b */
    public abstract void mo8583b(boolean z);

    @Override // p000a.p006b.p049h.p061j.p062j.MenuPresenter
    /* renamed from: b */
    public boolean mo6276b(MenuBuilder menuBuilder, MenuItemImpl menuItemImpl) {
        return false;
    }

    /* renamed from: c */
    public abstract void mo8582c(int i);

    /* renamed from: c */
    public abstract void mo8581c(boolean z);

    /* renamed from: g */
    public boolean mo8607g() {
        return true;
    }

    /* renamed from: h */
    public Rect m8606h() {
        return this.f2454a;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        ListAdapter listAdapter = (ListAdapter) adapterView.getAdapter();
        m8610a(listAdapter).f2378a.m8685a((MenuItem) listAdapter.getItem(i), this, mo8607g() ? 0 : 4);
    }

    /* renamed from: a */
    public static int m8609a(ListAdapter listAdapter, ViewGroup viewGroup, Context context, int i) {
        int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, 0);
        int makeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(0, 0);
        int count = listAdapter.getCount();
        ViewGroup viewGroup2 = viewGroup;
        View view = null;
        int i2 = 0;
        int i3 = 0;
        for (int i4 = 0; i4 < count; i4++) {
            int itemViewType = listAdapter.getItemViewType(i4);
            if (itemViewType != i3) {
                view = null;
                i3 = itemViewType;
            }
            if (viewGroup2 == null) {
                viewGroup2 = new FrameLayout(context);
            }
            view = listAdapter.getView(i4, view, viewGroup2);
            view.measure(makeMeasureSpec, makeMeasureSpec2);
            int measuredWidth = view.getMeasuredWidth();
            if (measuredWidth >= i) {
                return i;
            }
            if (measuredWidth > i2) {
                i2 = measuredWidth;
            }
        }
        return i2;
    }

    /* renamed from: a */
    public static MenuAdapter m8610a(ListAdapter listAdapter) {
        if (listAdapter instanceof HeaderViewListAdapter) {
            return (MenuAdapter) ((HeaderViewListAdapter) listAdapter).getWrappedAdapter();
        }
        return (MenuAdapter) listAdapter;
    }
}
