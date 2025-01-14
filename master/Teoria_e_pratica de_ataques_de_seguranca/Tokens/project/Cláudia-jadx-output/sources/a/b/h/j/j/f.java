package a.b.h.j.j;

import a.b.h.j.j.p;
import a.b.h.j.j.q;
import android.content.Context;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcelable;
import android.support.v7.view.menu.ExpandedMenuView;
import android.util.SparseArray;
import android.view.ContextThemeWrapper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ListAdapter;
import java.util.ArrayList;
/* compiled from: ListMenuPresenter.java */
/* loaded from: classes.dex */
public class f implements p, AdapterView.OnItemClickListener {

    /* renamed from: a  reason: collision with root package name */
    public Context f1564a;

    /* renamed from: b  reason: collision with root package name */
    public LayoutInflater f1565b;

    /* renamed from: c  reason: collision with root package name */
    public h f1566c;

    /* renamed from: d  reason: collision with root package name */
    public ExpandedMenuView f1567d;

    /* renamed from: e  reason: collision with root package name */
    public int f1568e;

    /* renamed from: f  reason: collision with root package name */
    public int f1569f;

    /* renamed from: g  reason: collision with root package name */
    public int f1570g;

    /* renamed from: h  reason: collision with root package name */
    public p.a f1571h;

    /* renamed from: i  reason: collision with root package name */
    public a f1572i;
    public int j;

    /* compiled from: ListMenuPresenter.java */
    /* loaded from: classes.dex */
    public class a extends BaseAdapter {

        /* renamed from: a  reason: collision with root package name */
        public int f1573a = -1;

        public a() {
            a();
        }

        public void a() {
            k f2 = f.this.f1566c.f();
            if (f2 != null) {
                ArrayList<k> j = f.this.f1566c.j();
                int size = j.size();
                for (int i2 = 0; i2 < size; i2++) {
                    if (j.get(i2) == f2) {
                        this.f1573a = i2;
                        return;
                    }
                }
            }
            this.f1573a = -1;
        }

        @Override // android.widget.Adapter
        public int getCount() {
            int size = f.this.f1566c.j().size() - f.this.f1568e;
            return this.f1573a < 0 ? size : size - 1;
        }

        @Override // android.widget.Adapter
        public long getItemId(int i2) {
            return i2;
        }

        @Override // android.widget.Adapter
        public View getView(int i2, View view, ViewGroup viewGroup) {
            if (view == null) {
                f fVar = f.this;
                view = fVar.f1565b.inflate(fVar.f1570g, viewGroup, false);
            }
            ((q.a) view).a(getItem(i2), 0);
            return view;
        }

        @Override // android.widget.BaseAdapter
        public void notifyDataSetChanged() {
            a();
            super.notifyDataSetChanged();
        }

        @Override // android.widget.Adapter
        public k getItem(int i2) {
            ArrayList<k> j = f.this.f1566c.j();
            int i3 = i2 + f.this.f1568e;
            int i4 = this.f1573a;
            if (i4 >= 0 && i3 >= i4) {
                i3++;
            }
            return j.get(i3);
        }
    }

    public f(Context context, int i2) {
        this(i2, 0);
        this.f1564a = context;
        this.f1565b = LayoutInflater.from(this.f1564a);
    }

    @Override // a.b.h.j.j.p
    public void a(Context context, h hVar) {
        int i2 = this.f1569f;
        if (i2 != 0) {
            this.f1564a = new ContextThemeWrapper(context, i2);
            this.f1565b = LayoutInflater.from(this.f1564a);
        } else if (this.f1564a != null) {
            this.f1564a = context;
            if (this.f1565b == null) {
                this.f1565b = LayoutInflater.from(this.f1564a);
            }
        }
        this.f1566c = hVar;
        a aVar = this.f1572i;
        if (aVar != null) {
            aVar.notifyDataSetChanged();
        }
    }

    @Override // a.b.h.j.j.p
    public boolean a(h hVar, k kVar) {
        return false;
    }

    public void b(Bundle bundle) {
        SparseArray<Parcelable> sparseArray = new SparseArray<>();
        ExpandedMenuView expandedMenuView = this.f1567d;
        if (expandedMenuView != null) {
            expandedMenuView.saveHierarchyState(sparseArray);
        }
        bundle.putSparseParcelableArray("android:menu:list", sparseArray);
    }

    @Override // a.b.h.j.j.p
    public boolean b() {
        return false;
    }

    @Override // a.b.h.j.j.p
    public boolean b(h hVar, k kVar) {
        return false;
    }

    @Override // a.b.h.j.j.p
    public Parcelable c() {
        if (this.f1567d == null) {
            return null;
        }
        Bundle bundle = new Bundle();
        b(bundle);
        return bundle;
    }

    public ListAdapter d() {
        if (this.f1572i == null) {
            this.f1572i = new a();
        }
        return this.f1572i;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i2, long j) {
        this.f1566c.a(this.f1572i.getItem(i2), this, 0);
    }

    public f(int i2, int i3) {
        this.f1570g = i2;
        this.f1569f = i3;
    }

    public q a(ViewGroup viewGroup) {
        if (this.f1567d == null) {
            this.f1567d = (ExpandedMenuView) this.f1565b.inflate(a.b.h.b.g.abc_expanded_menu_layout, viewGroup, false);
            if (this.f1572i == null) {
                this.f1572i = new a();
            }
            this.f1567d.setAdapter((ListAdapter) this.f1572i);
            this.f1567d.setOnItemClickListener(this);
        }
        return this.f1567d;
    }

    @Override // a.b.h.j.j.p
    public void a(boolean z) {
        a aVar = this.f1572i;
        if (aVar != null) {
            aVar.notifyDataSetChanged();
        }
    }

    @Override // a.b.h.j.j.p
    public void a(p.a aVar) {
        this.f1571h = aVar;
    }

    @Override // a.b.h.j.j.p
    public boolean a(v vVar) {
        if (vVar.hasVisibleItems()) {
            new i(vVar).a((IBinder) null);
            p.a aVar = this.f1571h;
            if (aVar != null) {
                aVar.a(vVar);
                return true;
            }
            return true;
        }
        return false;
    }

    @Override // a.b.h.j.j.p
    public void a(h hVar, boolean z) {
        p.a aVar = this.f1571h;
        if (aVar != null) {
            aVar.a(hVar, z);
        }
    }

    public void a(Bundle bundle) {
        SparseArray<Parcelable> sparseParcelableArray = bundle.getSparseParcelableArray("android:menu:list");
        if (sparseParcelableArray != null) {
            this.f1567d.restoreHierarchyState(sparseParcelableArray);
        }
    }

    @Override // a.b.h.j.j.p
    public int a() {
        return this.j;
    }

    @Override // a.b.h.j.j.p
    public void a(Parcelable parcelable) {
        a((Bundle) parcelable);
    }
}
