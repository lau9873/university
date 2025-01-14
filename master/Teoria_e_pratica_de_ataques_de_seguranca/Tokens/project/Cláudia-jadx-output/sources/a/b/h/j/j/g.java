package a.b.h.j.j;

import a.b.h.j.j.q;
import android.support.v7.view.menu.ListMenuItemView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import java.util.ArrayList;
/* compiled from: MenuAdapter.java */
/* loaded from: classes.dex */
public class g extends BaseAdapter {

    /* renamed from: a  reason: collision with root package name */
    public h f1575a;

    /* renamed from: b  reason: collision with root package name */
    public int f1576b = -1;

    /* renamed from: c  reason: collision with root package name */
    public boolean f1577c;

    /* renamed from: d  reason: collision with root package name */
    public final boolean f1578d;

    /* renamed from: e  reason: collision with root package name */
    public final LayoutInflater f1579e;

    /* renamed from: f  reason: collision with root package name */
    public final int f1580f;

    public g(h hVar, LayoutInflater layoutInflater, boolean z, int i2) {
        this.f1578d = z;
        this.f1579e = layoutInflater;
        this.f1575a = hVar;
        this.f1580f = i2;
        a();
    }

    public void a(boolean z) {
        this.f1577c = z;
    }

    public h b() {
        return this.f1575a;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        ArrayList<k> j = this.f1578d ? this.f1575a.j() : this.f1575a.n();
        if (this.f1576b < 0) {
            return j.size();
        }
        return j.size() - 1;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i2) {
        return i2;
    }

    @Override // android.widget.Adapter
    public View getView(int i2, View view, ViewGroup viewGroup) {
        if (view == null) {
            view = this.f1579e.inflate(this.f1580f, viewGroup, false);
        }
        int groupId = getItem(i2).getGroupId();
        int i3 = i2 - 1;
        ListMenuItemView listMenuItemView = (ListMenuItemView) view;
        listMenuItemView.setGroupDividerEnabled(this.f1575a.o() && groupId != (i3 >= 0 ? getItem(i3).getGroupId() : groupId));
        q.a aVar = (q.a) view;
        if (this.f1577c) {
            listMenuItemView.setForceShowIcon(true);
        }
        aVar.a(getItem(i2), 0);
        return view;
    }

    @Override // android.widget.BaseAdapter
    public void notifyDataSetChanged() {
        a();
        super.notifyDataSetChanged();
    }

    public void a() {
        k f2 = this.f1575a.f();
        if (f2 != null) {
            ArrayList<k> j = this.f1575a.j();
            int size = j.size();
            for (int i2 = 0; i2 < size; i2++) {
                if (j.get(i2) == f2) {
                    this.f1576b = i2;
                    return;
                }
            }
        }
        this.f1576b = -1;
    }

    @Override // android.widget.Adapter
    public k getItem(int i2) {
        ArrayList<k> j = this.f1578d ? this.f1575a.j() : this.f1575a.n();
        int i3 = this.f1576b;
        if (i3 >= 0 && i2 >= i3) {
            i2++;
        }
        return j.get(i2);
    }
}
