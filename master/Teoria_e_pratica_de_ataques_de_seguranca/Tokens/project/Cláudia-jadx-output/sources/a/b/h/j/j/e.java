package a.b.h.j.j;

import a.b.h.j.j.p;
import a.b.h.k.t0;
import a.b.h.k.u0;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Rect;
import android.os.Build;
import android.os.Handler;
import android.os.Parcelable;
import android.os.SystemClock;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.AdapterView;
import android.widget.FrameLayout;
import android.widget.HeaderViewListAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.TextView;
import java.util.ArrayList;
import java.util.List;
/* compiled from: CascadingMenuPopup.java */
/* loaded from: classes.dex */
public final class e extends n implements p, View.OnKeyListener, PopupWindow.OnDismissListener {
    public static final int C = a.b.h.b.g.abc_cascading_menu_item_layout;
    public PopupWindow.OnDismissListener A;
    public boolean B;

    /* renamed from: b  reason: collision with root package name */
    public final Context f1546b;

    /* renamed from: c  reason: collision with root package name */
    public final int f1547c;

    /* renamed from: d  reason: collision with root package name */
    public final int f1548d;

    /* renamed from: e  reason: collision with root package name */
    public final int f1549e;

    /* renamed from: f  reason: collision with root package name */
    public final boolean f1550f;

    /* renamed from: g  reason: collision with root package name */
    public final Handler f1551g;
    public View p;
    public View q;
    public boolean s;
    public boolean t;
    public int u;
    public int v;
    public boolean x;
    public p.a y;
    public ViewTreeObserver z;

    /* renamed from: h  reason: collision with root package name */
    public final List<h> f1552h = new ArrayList();

    /* renamed from: i  reason: collision with root package name */
    public final List<d> f1553i = new ArrayList();
    public final ViewTreeObserver.OnGlobalLayoutListener j = new a();
    public final View.OnAttachStateChangeListener k = new b();
    public final t0 m = new c();
    public int n = 0;
    public int o = 0;
    public boolean w = false;
    public int r = j();

    /* compiled from: CascadingMenuPopup.java */
    /* loaded from: classes.dex */
    public class a implements ViewTreeObserver.OnGlobalLayoutListener {
        public a() {
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            if (!e.this.f() || e.this.f1553i.size() <= 0 || e.this.f1553i.get(0).f1561a.l()) {
                return;
            }
            View view = e.this.q;
            if (view != null && view.isShown()) {
                for (d dVar : e.this.f1553i) {
                    dVar.f1561a.d();
                }
                return;
            }
            e.this.dismiss();
        }
    }

    /* compiled from: CascadingMenuPopup.java */
    /* loaded from: classes.dex */
    public class b implements View.OnAttachStateChangeListener {
        public b() {
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewAttachedToWindow(View view) {
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewDetachedFromWindow(View view) {
            ViewTreeObserver viewTreeObserver = e.this.z;
            if (viewTreeObserver != null) {
                if (!viewTreeObserver.isAlive()) {
                    e.this.z = view.getViewTreeObserver();
                }
                e eVar = e.this;
                eVar.z.removeGlobalOnLayoutListener(eVar.j);
            }
            view.removeOnAttachStateChangeListener(this);
        }
    }

    /* compiled from: CascadingMenuPopup.java */
    /* loaded from: classes.dex */
    public class c implements t0 {

        /* compiled from: CascadingMenuPopup.java */
        /* loaded from: classes.dex */
        public class a implements Runnable {

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ d f1557a;

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ MenuItem f1558b;

            /* renamed from: c  reason: collision with root package name */
            public final /* synthetic */ h f1559c;

            public a(d dVar, MenuItem menuItem, h hVar) {
                this.f1557a = dVar;
                this.f1558b = menuItem;
                this.f1559c = hVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                d dVar = this.f1557a;
                if (dVar != null) {
                    e.this.B = true;
                    dVar.f1562b.a(false);
                    e.this.B = false;
                }
                if (this.f1558b.isEnabled() && this.f1558b.hasSubMenu()) {
                    this.f1559c.a(this.f1558b, 4);
                }
            }
        }

        public c() {
        }

        @Override // a.b.h.k.t0
        public void a(h hVar, MenuItem menuItem) {
            e.this.f1551g.removeCallbacksAndMessages(hVar);
        }

        @Override // a.b.h.k.t0
        public void b(h hVar, MenuItem menuItem) {
            e.this.f1551g.removeCallbacksAndMessages(null);
            int size = e.this.f1553i.size();
            int i2 = 0;
            while (true) {
                if (i2 >= size) {
                    i2 = -1;
                    break;
                } else if (hVar == e.this.f1553i.get(i2).f1562b) {
                    break;
                } else {
                    i2++;
                }
            }
            if (i2 == -1) {
                return;
            }
            int i3 = i2 + 1;
            e.this.f1551g.postAtTime(new a(i3 < e.this.f1553i.size() ? e.this.f1553i.get(i3) : null, menuItem, hVar), hVar, SystemClock.uptimeMillis() + 200);
        }
    }

    /* compiled from: CascadingMenuPopup.java */
    /* loaded from: classes.dex */
    public static class d {

        /* renamed from: a  reason: collision with root package name */
        public final u0 f1561a;

        /* renamed from: b  reason: collision with root package name */
        public final h f1562b;

        /* renamed from: c  reason: collision with root package name */
        public final int f1563c;

        public d(u0 u0Var, h hVar, int i2) {
            this.f1561a = u0Var;
            this.f1562b = hVar;
            this.f1563c = i2;
        }

        public ListView a() {
            return this.f1561a.e();
        }
    }

    public e(Context context, View view, int i2, int i3, boolean z) {
        this.f1546b = context;
        this.p = view;
        this.f1548d = i2;
        this.f1549e = i3;
        this.f1550f = z;
        Resources resources = context.getResources();
        this.f1547c = Math.max(resources.getDisplayMetrics().widthPixels / 2, resources.getDimensionPixelSize(a.b.h.b.d.abc_config_prefDialogWidth));
        this.f1551g = new Handler();
    }

    @Override // a.b.h.j.j.n
    public void a(h hVar) {
        hVar.a(this, this.f1546b);
        if (f()) {
            d(hVar);
        } else {
            this.f1552h.add(hVar);
        }
    }

    @Override // a.b.h.j.j.p
    public void a(Parcelable parcelable) {
    }

    @Override // a.b.h.j.j.n
    public void b(boolean z) {
        this.w = z;
    }

    @Override // a.b.h.j.j.p
    public boolean b() {
        return false;
    }

    public final int c(h hVar) {
        int size = this.f1553i.size();
        for (int i2 = 0; i2 < size; i2++) {
            if (hVar == this.f1553i.get(i2).f1562b) {
                return i2;
            }
        }
        return -1;
    }

    @Override // a.b.h.j.j.p
    public Parcelable c() {
        return null;
    }

    @Override // a.b.h.j.j.t
    public void d() {
        if (f()) {
            return;
        }
        for (h hVar : this.f1552h) {
            d(hVar);
        }
        this.f1552h.clear();
        this.q = this.p;
        if (this.q != null) {
            boolean z = this.z == null;
            this.z = this.q.getViewTreeObserver();
            if (z) {
                this.z.addOnGlobalLayoutListener(this.j);
            }
            this.q.addOnAttachStateChangeListener(this.k);
        }
    }

    @Override // a.b.h.j.j.t
    public void dismiss() {
        int size = this.f1553i.size();
        if (size > 0) {
            d[] dVarArr = (d[]) this.f1553i.toArray(new d[size]);
            for (int i2 = size - 1; i2 >= 0; i2--) {
                d dVar = dVarArr[i2];
                if (dVar.f1561a.f()) {
                    dVar.f1561a.dismiss();
                }
            }
        }
    }

    @Override // a.b.h.j.j.t
    public ListView e() {
        if (this.f1553i.isEmpty()) {
            return null;
        }
        List<d> list = this.f1553i;
        return list.get(list.size() - 1).a();
    }

    @Override // a.b.h.j.j.t
    public boolean f() {
        return this.f1553i.size() > 0 && this.f1553i.get(0).f1561a.f();
    }

    @Override // a.b.h.j.j.n
    public boolean g() {
        return false;
    }

    public final u0 i() {
        u0 u0Var = new u0(this.f1546b, null, this.f1548d, this.f1549e);
        u0Var.a(this.m);
        u0Var.a((AdapterView.OnItemClickListener) this);
        u0Var.a((PopupWindow.OnDismissListener) this);
        u0Var.a(this.p);
        u0Var.c(this.o);
        u0Var.a(true);
        u0Var.e(2);
        return u0Var;
    }

    public final int j() {
        return a.b.g.k.u.k(this.p) == 1 ? 0 : 1;
    }

    @Override // android.widget.PopupWindow.OnDismissListener
    public void onDismiss() {
        d dVar;
        int size = this.f1553i.size();
        int i2 = 0;
        while (true) {
            if (i2 >= size) {
                dVar = null;
                break;
            }
            dVar = this.f1553i.get(i2);
            if (!dVar.f1561a.f()) {
                break;
            }
            i2++;
        }
        if (dVar != null) {
            dVar.f1562b.a(false);
        }
    }

    @Override // android.view.View.OnKeyListener
    public boolean onKey(View view, int i2, KeyEvent keyEvent) {
        if (keyEvent.getAction() == 1 && i2 == 82) {
            dismiss();
            return true;
        }
        return false;
    }

    @Override // a.b.h.j.j.n
    public void b(int i2) {
        this.s = true;
        this.u = i2;
    }

    @Override // a.b.h.j.j.n
    public void c(int i2) {
        this.t = true;
        this.v = i2;
    }

    public final MenuItem a(h hVar, h hVar2) {
        int size = hVar.size();
        for (int i2 = 0; i2 < size; i2++) {
            MenuItem item = hVar.getItem(i2);
            if (item.hasSubMenu() && hVar2 == item.getSubMenu()) {
                return item;
            }
        }
        return null;
    }

    @Override // a.b.h.j.j.n
    public void c(boolean z) {
        this.x = z;
    }

    public final View a(d dVar, h hVar) {
        g gVar;
        int i2;
        int firstVisiblePosition;
        MenuItem a2 = a(dVar.f1562b, hVar);
        if (a2 == null) {
            return null;
        }
        ListView a3 = dVar.a();
        ListAdapter adapter = a3.getAdapter();
        int i3 = 0;
        if (adapter instanceof HeaderViewListAdapter) {
            HeaderViewListAdapter headerViewListAdapter = (HeaderViewListAdapter) adapter;
            i2 = headerViewListAdapter.getHeadersCount();
            gVar = (g) headerViewListAdapter.getWrappedAdapter();
        } else {
            gVar = (g) adapter;
            i2 = 0;
        }
        int count = gVar.getCount();
        while (true) {
            if (i3 >= count) {
                i3 = -1;
                break;
            } else if (a2 == gVar.getItem(i3)) {
                break;
            } else {
                i3++;
            }
        }
        if (i3 != -1 && (firstVisiblePosition = (i3 + i2) - a3.getFirstVisiblePosition()) >= 0 && firstVisiblePosition < a3.getChildCount()) {
            return a3.getChildAt(firstVisiblePosition);
        }
        return null;
    }

    public final int d(int i2) {
        List<d> list = this.f1553i;
        ListView a2 = list.get(list.size() - 1).a();
        int[] iArr = new int[2];
        a2.getLocationOnScreen(iArr);
        Rect rect = new Rect();
        this.q.getWindowVisibleDisplayFrame(rect);
        return this.r == 1 ? (iArr[0] + a2.getWidth()) + i2 > rect.right ? 0 : 1 : iArr[0] - i2 < 0 ? 1 : 0;
    }

    public final void d(h hVar) {
        d dVar;
        View view;
        int i2;
        int i3;
        int i4;
        LayoutInflater from = LayoutInflater.from(this.f1546b);
        g gVar = new g(hVar, from, this.f1550f, C);
        if (!f() && this.w) {
            gVar.a(true);
        } else if (f()) {
            gVar.a(n.b(hVar));
        }
        int a2 = n.a(gVar, null, this.f1546b, this.f1547c);
        u0 i5 = i();
        i5.a((ListAdapter) gVar);
        i5.b(a2);
        i5.c(this.o);
        if (this.f1553i.size() > 0) {
            List<d> list = this.f1553i;
            dVar = list.get(list.size() - 1);
            view = a(dVar, hVar);
        } else {
            dVar = null;
            view = null;
        }
        if (view != null) {
            i5.d(false);
            i5.a((Object) null);
            int d2 = d(a2);
            boolean z = d2 == 1;
            this.r = d2;
            if (Build.VERSION.SDK_INT >= 26) {
                i5.a(view);
                i3 = 0;
                i2 = 0;
            } else {
                int[] iArr = new int[2];
                this.p.getLocationOnScreen(iArr);
                int[] iArr2 = new int[2];
                view.getLocationOnScreen(iArr2);
                if ((this.o & 7) == 5) {
                    iArr[0] = iArr[0] + this.p.getWidth();
                    iArr2[0] = iArr2[0] + view.getWidth();
                }
                i2 = iArr2[0] - iArr[0];
                i3 = iArr2[1] - iArr[1];
            }
            if ((this.o & 5) == 5) {
                if (!z) {
                    a2 = view.getWidth();
                    i4 = i2 - a2;
                }
                i4 = i2 + a2;
            } else {
                if (z) {
                    a2 = view.getWidth();
                    i4 = i2 + a2;
                }
                i4 = i2 - a2;
            }
            i5.d(i4);
            i5.b(true);
            i5.h(i3);
        } else {
            if (this.s) {
                i5.d(this.u);
            }
            if (this.t) {
                i5.h(this.v);
            }
            i5.a(h());
        }
        this.f1553i.add(new d(i5, hVar, this.r));
        i5.d();
        ListView e2 = i5.e();
        e2.setOnKeyListener(this);
        if (dVar == null && this.x && hVar.h() != null) {
            FrameLayout frameLayout = (FrameLayout) from.inflate(a.b.h.b.g.abc_popup_menu_header_item_layout, (ViewGroup) e2, false);
            frameLayout.setEnabled(false);
            ((TextView) frameLayout.findViewById(16908310)).setText(hVar.h());
            e2.addHeaderView(frameLayout, null, false);
            i5.d();
        }
    }

    @Override // a.b.h.j.j.p
    public void a(boolean z) {
        for (d dVar : this.f1553i) {
            n.a(dVar.a().getAdapter()).notifyDataSetChanged();
        }
    }

    @Override // a.b.h.j.j.p
    public void a(p.a aVar) {
        this.y = aVar;
    }

    @Override // a.b.h.j.j.p
    public boolean a(v vVar) {
        for (d dVar : this.f1553i) {
            if (vVar == dVar.f1562b) {
                dVar.a().requestFocus();
                return true;
            }
        }
        if (vVar.hasVisibleItems()) {
            a((h) vVar);
            p.a aVar = this.y;
            if (aVar != null) {
                aVar.a(vVar);
            }
            return true;
        }
        return false;
    }

    @Override // a.b.h.j.j.p
    public void a(h hVar, boolean z) {
        int c2 = c(hVar);
        if (c2 < 0) {
            return;
        }
        int i2 = c2 + 1;
        if (i2 < this.f1553i.size()) {
            this.f1553i.get(i2).f1562b.a(false);
        }
        d remove = this.f1553i.remove(c2);
        remove.f1562b.b(this);
        if (this.B) {
            remove.f1561a.b((Object) null);
            remove.f1561a.a(0);
        }
        remove.f1561a.dismiss();
        int size = this.f1553i.size();
        if (size > 0) {
            this.r = this.f1553i.get(size - 1).f1563c;
        } else {
            this.r = j();
        }
        if (size != 0) {
            if (z) {
                this.f1553i.get(0).f1562b.a(false);
                return;
            }
            return;
        }
        dismiss();
        p.a aVar = this.y;
        if (aVar != null) {
            aVar.a(hVar, true);
        }
        ViewTreeObserver viewTreeObserver = this.z;
        if (viewTreeObserver != null) {
            if (viewTreeObserver.isAlive()) {
                this.z.removeGlobalOnLayoutListener(this.j);
            }
            this.z = null;
        }
        this.q.removeOnAttachStateChangeListener(this.k);
        this.A.onDismiss();
    }

    @Override // a.b.h.j.j.n
    public void a(int i2) {
        if (this.n != i2) {
            this.n = i2;
            this.o = a.b.g.k.d.a(i2, a.b.g.k.u.k(this.p));
        }
    }

    @Override // a.b.h.j.j.n
    public void a(View view) {
        if (this.p != view) {
            this.p = view;
            this.o = a.b.g.k.d.a(this.n, a.b.g.k.u.k(this.p));
        }
    }

    @Override // a.b.h.j.j.n
    public void a(PopupWindow.OnDismissListener onDismissListener) {
        this.A = onDismissListener;
    }
}
