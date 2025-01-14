package a.b.h.j.j;

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
/* compiled from: MenuPopup.java */
/* loaded from: classes.dex */
public abstract class n implements t, p, AdapterView.OnItemClickListener {

    /* renamed from: a  reason: collision with root package name */
    public Rect f1611a;

    public static boolean b(h hVar) {
        int size = hVar.size();
        for (int i2 = 0; i2 < size; i2++) {
            MenuItem item = hVar.getItem(i2);
            if (item.isVisible() && item.getIcon() != null) {
                return true;
            }
        }
        return false;
    }

    @Override // a.b.h.j.j.p
    public int a() {
        return 0;
    }

    public abstract void a(int i2);

    public abstract void a(h hVar);

    @Override // a.b.h.j.j.p
    public void a(Context context, h hVar) {
    }

    public void a(Rect rect) {
        this.f1611a = rect;
    }

    public abstract void a(View view);

    public abstract void a(PopupWindow.OnDismissListener onDismissListener);

    @Override // a.b.h.j.j.p
    public boolean a(h hVar, k kVar) {
        return false;
    }

    public abstract void b(int i2);

    public abstract void b(boolean z);

    @Override // a.b.h.j.j.p
    public boolean b(h hVar, k kVar) {
        return false;
    }

    public abstract void c(int i2);

    public abstract void c(boolean z);

    public boolean g() {
        return true;
    }

    public Rect h() {
        return this.f1611a;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i2, long j) {
        ListAdapter listAdapter = (ListAdapter) adapterView.getAdapter();
        a(listAdapter).f1575a.a((MenuItem) listAdapter.getItem(i2), this, g() ? 0 : 4);
    }

    public static int a(ListAdapter listAdapter, ViewGroup viewGroup, Context context, int i2) {
        int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, 0);
        int makeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(0, 0);
        int count = listAdapter.getCount();
        ViewGroup viewGroup2 = viewGroup;
        View view = null;
        int i3 = 0;
        int i4 = 0;
        for (int i5 = 0; i5 < count; i5++) {
            int itemViewType = listAdapter.getItemViewType(i5);
            if (itemViewType != i4) {
                view = null;
                i4 = itemViewType;
            }
            if (viewGroup2 == null) {
                viewGroup2 = new FrameLayout(context);
            }
            view = listAdapter.getView(i5, view, viewGroup2);
            view.measure(makeMeasureSpec, makeMeasureSpec2);
            int measuredWidth = view.getMeasuredWidth();
            if (measuredWidth >= i2) {
                return i2;
            }
            if (measuredWidth > i3) {
                i3 = measuredWidth;
            }
        }
        return i3;
    }

    public static g a(ListAdapter listAdapter) {
        if (listAdapter instanceof HeaderViewListAdapter) {
            return (g) ((HeaderViewListAdapter) listAdapter).getWrappedAdapter();
        }
        return (g) listAdapter;
    }
}
