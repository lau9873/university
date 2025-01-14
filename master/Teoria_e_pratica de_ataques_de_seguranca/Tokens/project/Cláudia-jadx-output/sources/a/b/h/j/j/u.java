package a.b.h.j.j;

import a.b.h.j.j.p;
import a.b.h.k.u0;
import android.content.Context;
import android.content.res.Resources;
import android.os.Parcelable;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.AdapterView;
import android.widget.FrameLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.TextView;
/* compiled from: StandardMenuPopup.java */
/* loaded from: classes.dex */
public final class u extends n implements PopupWindow.OnDismissListener, AdapterView.OnItemClickListener, p, View.OnKeyListener {
    public static final int w = a.b.h.b.g.abc_popup_menu_item_layout;

    /* renamed from: b  reason: collision with root package name */
    public final Context f1622b;

    /* renamed from: c  reason: collision with root package name */
    public final h f1623c;

    /* renamed from: d  reason: collision with root package name */
    public final g f1624d;

    /* renamed from: e  reason: collision with root package name */
    public final boolean f1625e;

    /* renamed from: f  reason: collision with root package name */
    public final int f1626f;

    /* renamed from: g  reason: collision with root package name */
    public final int f1627g;

    /* renamed from: h  reason: collision with root package name */
    public final int f1628h;

    /* renamed from: i  reason: collision with root package name */
    public final u0 f1629i;
    public PopupWindow.OnDismissListener m;
    public View n;
    public View o;
    public p.a p;
    public ViewTreeObserver q;
    public boolean r;
    public boolean s;
    public int t;
    public boolean v;
    public final ViewTreeObserver.OnGlobalLayoutListener j = new a();
    public final View.OnAttachStateChangeListener k = new b();
    public int u = 0;

    /* compiled from: StandardMenuPopup.java */
    /* loaded from: classes.dex */
    public class a implements ViewTreeObserver.OnGlobalLayoutListener {
        public a() {
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            if (!u.this.f() || u.this.f1629i.l()) {
                return;
            }
            View view = u.this.o;
            if (view != null && view.isShown()) {
                u.this.f1629i.d();
            } else {
                u.this.dismiss();
            }
        }
    }

    /* compiled from: StandardMenuPopup.java */
    /* loaded from: classes.dex */
    public class b implements View.OnAttachStateChangeListener {
        public b() {
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewAttachedToWindow(View view) {
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewDetachedFromWindow(View view) {
            ViewTreeObserver viewTreeObserver = u.this.q;
            if (viewTreeObserver != null) {
                if (!viewTreeObserver.isAlive()) {
                    u.this.q = view.getViewTreeObserver();
                }
                u uVar = u.this;
                uVar.q.removeGlobalOnLayoutListener(uVar.j);
            }
            view.removeOnAttachStateChangeListener(this);
        }
    }

    public u(Context context, h hVar, View view, int i2, int i3, boolean z) {
        this.f1622b = context;
        this.f1623c = hVar;
        this.f1625e = z;
        this.f1624d = new g(hVar, LayoutInflater.from(context), this.f1625e, w);
        this.f1627g = i2;
        this.f1628h = i3;
        Resources resources = context.getResources();
        this.f1626f = Math.max(resources.getDisplayMetrics().widthPixels / 2, resources.getDimensionPixelSize(a.b.h.b.d.abc_config_prefDialogWidth));
        this.n = view;
        this.f1629i = new u0(this.f1622b, null, this.f1627g, this.f1628h);
        hVar.a(this, context);
    }

    @Override // a.b.h.j.j.n
    public void a(int i2) {
        this.u = i2;
    }

    @Override // a.b.h.j.j.n
    public void a(h hVar) {
    }

    @Override // a.b.h.j.j.p
    public void a(Parcelable parcelable) {
    }

    @Override // a.b.h.j.j.n
    public void b(boolean z) {
        this.f1624d.a(z);
    }

    @Override // a.b.h.j.j.p
    public boolean b() {
        return false;
    }

    @Override // a.b.h.j.j.p
    public Parcelable c() {
        return null;
    }

    @Override // a.b.h.j.j.n
    public void c(int i2) {
        this.f1629i.h(i2);
    }

    @Override // a.b.h.j.j.t
    public void d() {
        if (!i()) {
            throw new IllegalStateException("StandardMenuPopup cannot be used without an anchor");
        }
    }

    @Override // a.b.h.j.j.t
    public void dismiss() {
        if (f()) {
            this.f1629i.dismiss();
        }
    }

    @Override // a.b.h.j.j.t
    public ListView e() {
        return this.f1629i.e();
    }

    @Override // a.b.h.j.j.t
    public boolean f() {
        return !this.r && this.f1629i.f();
    }

    public final boolean i() {
        View view;
        if (f()) {
            return true;
        }
        if (this.r || (view = this.n) == null) {
            return false;
        }
        this.o = view;
        this.f1629i.a((PopupWindow.OnDismissListener) this);
        this.f1629i.a((AdapterView.OnItemClickListener) this);
        this.f1629i.a(true);
        View view2 = this.o;
        boolean z = this.q == null;
        this.q = view2.getViewTreeObserver();
        if (z) {
            this.q.addOnGlobalLayoutListener(this.j);
        }
        view2.addOnAttachStateChangeListener(this.k);
        this.f1629i.a(view2);
        this.f1629i.c(this.u);
        if (!this.s) {
            this.t = n.a(this.f1624d, null, this.f1622b, this.f1626f);
            this.s = true;
        }
        this.f1629i.b(this.t);
        this.f1629i.e(2);
        this.f1629i.a(h());
        this.f1629i.d();
        ListView e2 = this.f1629i.e();
        e2.setOnKeyListener(this);
        if (this.v && this.f1623c.h() != null) {
            FrameLayout frameLayout = (FrameLayout) LayoutInflater.from(this.f1622b).inflate(a.b.h.b.g.abc_popup_menu_header_item_layout, (ViewGroup) e2, false);
            TextView textView = (TextView) frameLayout.findViewById(16908310);
            if (textView != null) {
                textView.setText(this.f1623c.h());
            }
            frameLayout.setEnabled(false);
            e2.addHeaderView(frameLayout, null, false);
        }
        this.f1629i.a((ListAdapter) this.f1624d);
        this.f1629i.d();
        return true;
    }

    @Override // android.widget.PopupWindow.OnDismissListener
    public void onDismiss() {
        this.r = true;
        this.f1623c.close();
        ViewTreeObserver viewTreeObserver = this.q;
        if (viewTreeObserver != null) {
            if (!viewTreeObserver.isAlive()) {
                this.q = this.o.getViewTreeObserver();
            }
            this.q.removeGlobalOnLayoutListener(this.j);
            this.q = null;
        }
        this.o.removeOnAttachStateChangeListener(this.k);
        PopupWindow.OnDismissListener onDismissListener = this.m;
        if (onDismissListener != null) {
            onDismissListener.onDismiss();
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

    @Override // a.b.h.j.j.p
    public void a(boolean z) {
        this.s = false;
        g gVar = this.f1624d;
        if (gVar != null) {
            gVar.notifyDataSetChanged();
        }
    }

    @Override // a.b.h.j.j.n
    public void b(int i2) {
        this.f1629i.d(i2);
    }

    @Override // a.b.h.j.j.n
    public void c(boolean z) {
        this.v = z;
    }

    @Override // a.b.h.j.j.p
    public void a(p.a aVar) {
        this.p = aVar;
    }

    @Override // a.b.h.j.j.p
    public boolean a(v vVar) {
        if (vVar.hasVisibleItems()) {
            o oVar = new o(this.f1622b, vVar, this.o, this.f1625e, this.f1627g, this.f1628h);
            oVar.a(this.p);
            oVar.a(n.b(vVar));
            oVar.a(this.m);
            this.m = null;
            this.f1623c.a(false);
            int h2 = this.f1629i.h();
            int i2 = this.f1629i.i();
            if ((Gravity.getAbsoluteGravity(this.u, a.b.g.k.u.k(this.n)) & 7) == 5) {
                h2 += this.n.getWidth();
            }
            if (oVar.a(h2, i2)) {
                p.a aVar = this.p;
                if (aVar != null) {
                    aVar.a(vVar);
                    return true;
                }
                return true;
            }
        }
        return false;
    }

    @Override // a.b.h.j.j.p
    public void a(h hVar, boolean z) {
        if (hVar != this.f1623c) {
            return;
        }
        dismiss();
        p.a aVar = this.p;
        if (aVar != null) {
            aVar.a(hVar, z);
        }
    }

    @Override // a.b.h.j.j.n
    public void a(View view) {
        this.n = view;
    }

    @Override // a.b.h.j.j.n
    public void a(PopupWindow.OnDismissListener onDismissListener) {
        this.m = onDismissListener;
    }
}
