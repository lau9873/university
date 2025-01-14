package a.b.h.k;

import a.b.h.j.j.h;
import a.b.h.j.j.p;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.Window;
/* compiled from: ToolbarWidgetWrapper.java */
/* loaded from: classes.dex */
public class m1 implements i0 {

    /* renamed from: a  reason: collision with root package name */
    public Toolbar f1838a;

    /* renamed from: b  reason: collision with root package name */
    public int f1839b;

    /* renamed from: c  reason: collision with root package name */
    public View f1840c;

    /* renamed from: d  reason: collision with root package name */
    public View f1841d;

    /* renamed from: e  reason: collision with root package name */
    public Drawable f1842e;

    /* renamed from: f  reason: collision with root package name */
    public Drawable f1843f;

    /* renamed from: g  reason: collision with root package name */
    public Drawable f1844g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f1845h;

    /* renamed from: i  reason: collision with root package name */
    public CharSequence f1846i;
    public CharSequence j;
    public CharSequence k;
    public Window.Callback l;
    public boolean m;
    public c n;
    public int o;
    public int p;
    public Drawable q;

    /* compiled from: ToolbarWidgetWrapper.java */
    /* loaded from: classes.dex */
    public class a implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        public final a.b.h.j.j.a f1847a;

        public a() {
            this.f1847a = new a.b.h.j.j.a(m1.this.f1838a.getContext(), 0, 16908332, 0, 0, m1.this.f1846i);
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            m1 m1Var = m1.this;
            Window.Callback callback = m1Var.l;
            if (callback == null || !m1Var.m) {
                return;
            }
            callback.onMenuItemSelected(0, this.f1847a);
        }
    }

    /* compiled from: ToolbarWidgetWrapper.java */
    /* loaded from: classes.dex */
    public class b extends a.b.g.k.b0 {

        /* renamed from: a  reason: collision with root package name */
        public boolean f1849a = false;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ int f1850b;

        public b(int i2) {
            this.f1850b = i2;
        }

        @Override // a.b.g.k.b0, a.b.g.k.a0
        public void a(View view) {
            this.f1849a = true;
        }

        @Override // a.b.g.k.a0
        public void b(View view) {
            if (this.f1849a) {
                return;
            }
            m1.this.f1838a.setVisibility(this.f1850b);
        }

        @Override // a.b.g.k.b0, a.b.g.k.a0
        public void c(View view) {
            m1.this.f1838a.setVisibility(0);
        }
    }

    public m1(Toolbar toolbar, boolean z) {
        this(toolbar, z, a.b.h.b.h.abc_action_bar_up_description, a.b.h.b.e.abc_ic_ab_back_material);
    }

    public void a(Drawable drawable) {
        this.f1843f = drawable;
        s();
    }

    @Override // a.b.h.k.i0
    public void a(boolean z) {
    }

    public void b(CharSequence charSequence) {
        this.j = charSequence;
        if ((this.f1839b & 8) != 0) {
            this.f1838a.setSubtitle(charSequence);
        }
    }

    public void c(CharSequence charSequence) {
        this.f1845h = true;
        d(charSequence);
    }

    @Override // a.b.h.k.i0
    public void collapseActionView() {
        this.f1838a.c();
    }

    public void d(int i2) {
        if (i2 == this.p) {
            return;
        }
        this.p = i2;
        if (TextUtils.isEmpty(this.f1838a.getNavigationContentDescription())) {
            e(this.p);
        }
    }

    @Override // a.b.h.k.i0
    public boolean e() {
        return this.f1838a.r();
    }

    @Override // a.b.h.k.i0
    public boolean f() {
        return this.f1838a.b();
    }

    @Override // a.b.h.k.i0
    public void g() {
        this.f1838a.d();
    }

    @Override // a.b.h.k.i0
    public CharSequence getTitle() {
        return this.f1838a.getTitle();
    }

    @Override // a.b.h.k.i0
    public ViewGroup h() {
        return this.f1838a;
    }

    @Override // a.b.h.k.i0
    public Context i() {
        return this.f1838a.getContext();
    }

    @Override // a.b.h.k.i0
    public boolean j() {
        return this.f1838a.k();
    }

    @Override // a.b.h.k.i0
    public int k() {
        return this.f1839b;
    }

    @Override // a.b.h.k.i0
    public Menu l() {
        return this.f1838a.getMenu();
    }

    @Override // a.b.h.k.i0
    public int m() {
        return this.o;
    }

    @Override // a.b.h.k.i0
    public void n() {
        Log.i("ToolbarWidgetWrapper", "Progress display unsupported");
    }

    @Override // a.b.h.k.i0
    public void o() {
        Log.i("ToolbarWidgetWrapper", "Progress display unsupported");
    }

    public final int p() {
        if (this.f1838a.getNavigationIcon() != null) {
            this.q = this.f1838a.getNavigationIcon();
            return 15;
        }
        return 11;
    }

    public final void q() {
        if ((this.f1839b & 4) != 0) {
            if (TextUtils.isEmpty(this.k)) {
                this.f1838a.setNavigationContentDescription(this.p);
            } else {
                this.f1838a.setNavigationContentDescription(this.k);
            }
        }
    }

    public final void r() {
        if ((this.f1839b & 4) != 0) {
            Toolbar toolbar = this.f1838a;
            Drawable drawable = this.f1844g;
            if (drawable == null) {
                drawable = this.q;
            }
            toolbar.setNavigationIcon(drawable);
            return;
        }
        this.f1838a.setNavigationIcon((Drawable) null);
    }

    public final void s() {
        Drawable drawable;
        int i2 = this.f1839b;
        if ((i2 & 2) == 0) {
            drawable = null;
        } else if ((i2 & 1) != 0) {
            drawable = this.f1843f;
            if (drawable == null) {
                drawable = this.f1842e;
            }
        } else {
            drawable = this.f1842e;
        }
        this.f1838a.setLogo(drawable);
    }

    @Override // a.b.h.k.i0
    public void setIcon(int i2) {
        setIcon(i2 != 0 ? a.b.h.d.a.a.c(i(), i2) : null);
    }

    @Override // a.b.h.k.i0
    public void setWindowCallback(Window.Callback callback) {
        this.l = callback;
    }

    @Override // a.b.h.k.i0
    public void setWindowTitle(CharSequence charSequence) {
        if (this.f1845h) {
            return;
        }
        d(charSequence);
    }

    public m1(Toolbar toolbar, boolean z, int i2, int i3) {
        Drawable drawable;
        this.o = 0;
        this.p = 0;
        this.f1838a = toolbar;
        this.f1846i = toolbar.getTitle();
        this.j = toolbar.getSubtitle();
        this.f1845h = this.f1846i != null;
        this.f1844g = toolbar.getNavigationIcon();
        l1 a2 = l1.a(toolbar.getContext(), null, a.b.h.b.j.ActionBar, a.b.h.b.a.actionBarStyle, 0);
        this.q = a2.b(a.b.h.b.j.ActionBar_homeAsUpIndicator);
        if (z) {
            CharSequence e2 = a2.e(a.b.h.b.j.ActionBar_title);
            if (!TextUtils.isEmpty(e2)) {
                c(e2);
            }
            CharSequence e3 = a2.e(a.b.h.b.j.ActionBar_subtitle);
            if (!TextUtils.isEmpty(e3)) {
                b(e3);
            }
            Drawable b2 = a2.b(a.b.h.b.j.ActionBar_logo);
            if (b2 != null) {
                a(b2);
            }
            Drawable b3 = a2.b(a.b.h.b.j.ActionBar_icon);
            if (b3 != null) {
                setIcon(b3);
            }
            if (this.f1844g == null && (drawable = this.q) != null) {
                b(drawable);
            }
            b(a2.d(a.b.h.b.j.ActionBar_displayOptions, 0));
            int g2 = a2.g(a.b.h.b.j.ActionBar_customNavigationLayout, 0);
            if (g2 != 0) {
                a(LayoutInflater.from(this.f1838a.getContext()).inflate(g2, (ViewGroup) this.f1838a, false));
                b(this.f1839b | 16);
            }
            int f2 = a2.f(a.b.h.b.j.ActionBar_height, 0);
            if (f2 > 0) {
                ViewGroup.LayoutParams layoutParams = this.f1838a.getLayoutParams();
                layoutParams.height = f2;
                this.f1838a.setLayoutParams(layoutParams);
            }
            int b4 = a2.b(a.b.h.b.j.ActionBar_contentInsetStart, -1);
            int b5 = a2.b(a.b.h.b.j.ActionBar_contentInsetEnd, -1);
            if (b4 >= 0 || b5 >= 0) {
                this.f1838a.a(Math.max(b4, 0), Math.max(b5, 0));
            }
            int g3 = a2.g(a.b.h.b.j.ActionBar_titleTextStyle, 0);
            if (g3 != 0) {
                Toolbar toolbar2 = this.f1838a;
                toolbar2.b(toolbar2.getContext(), g3);
            }
            int g4 = a2.g(a.b.h.b.j.ActionBar_subtitleTextStyle, 0);
            if (g4 != 0) {
                Toolbar toolbar3 = this.f1838a;
                toolbar3.a(toolbar3.getContext(), g4);
            }
            int g5 = a2.g(a.b.h.b.j.ActionBar_popupTheme, 0);
            if (g5 != 0) {
                this.f1838a.setPopupTheme(g5);
            }
        } else {
            this.f1839b = p();
        }
        a2.a();
        d(i2);
        this.k = this.f1838a.getNavigationContentDescription();
        this.f1838a.setNavigationOnClickListener(new a());
    }

    public void e(int i2) {
        a(i2 == 0 ? null : i().getString(i2));
    }

    @Override // a.b.h.k.i0
    public void setIcon(Drawable drawable) {
        this.f1842e = drawable;
        s();
    }

    @Override // a.b.h.k.i0
    public boolean a() {
        return this.f1838a.n();
    }

    @Override // a.b.h.k.i0
    public void c(int i2) {
        a(i2 != 0 ? a.b.h.d.a.a.c(i(), i2) : null);
    }

    @Override // a.b.h.k.i0
    public void a(Menu menu, p.a aVar) {
        if (this.n == null) {
            this.n = new c(this.f1838a.getContext());
            this.n.a(a.b.h.b.f.action_menu_presenter);
        }
        this.n.a(aVar);
        this.f1838a.a((a.b.h.j.j.h) menu, this.n);
    }

    @Override // a.b.h.k.i0
    public void b() {
        this.m = true;
    }

    @Override // a.b.h.k.i0
    public boolean c() {
        return this.f1838a.m();
    }

    @Override // a.b.h.k.i0
    public void b(int i2) {
        View view;
        int i3 = this.f1839b ^ i2;
        this.f1839b = i2;
        if (i3 != 0) {
            if ((i3 & 4) != 0) {
                if ((i2 & 4) != 0) {
                    q();
                }
                r();
            }
            if ((i3 & 3) != 0) {
                s();
            }
            if ((i3 & 8) != 0) {
                if ((i2 & 8) != 0) {
                    this.f1838a.setTitle(this.f1846i);
                    this.f1838a.setSubtitle(this.j);
                } else {
                    this.f1838a.setTitle((CharSequence) null);
                    this.f1838a.setSubtitle((CharSequence) null);
                }
            }
            if ((i3 & 16) == 0 || (view = this.f1841d) == null) {
                return;
            }
            if ((i2 & 16) != 0) {
                this.f1838a.addView(view);
            } else {
                this.f1838a.removeView(view);
            }
        }
    }

    public final void d(CharSequence charSequence) {
        this.f1846i = charSequence;
        if ((this.f1839b & 8) != 0) {
            this.f1838a.setTitle(charSequence);
        }
    }

    @Override // a.b.h.k.i0
    public boolean d() {
        return this.f1838a.l();
    }

    @Override // a.b.h.k.i0
    public void a(d1 d1Var) {
        View view = this.f1840c;
        if (view != null) {
            ViewParent parent = view.getParent();
            Toolbar toolbar = this.f1838a;
            if (parent == toolbar) {
                toolbar.removeView(this.f1840c);
            }
        }
        this.f1840c = d1Var;
        if (d1Var == null || this.o != 2) {
            return;
        }
        this.f1838a.addView(this.f1840c, 0);
        Toolbar.e eVar = (Toolbar.e) this.f1840c.getLayoutParams();
        ((ViewGroup.MarginLayoutParams) eVar).width = -2;
        ((ViewGroup.MarginLayoutParams) eVar).height = -2;
        eVar.f1271a = 8388691;
        d1Var.setAllowCollapse(true);
    }

    @Override // a.b.h.k.i0
    public void b(boolean z) {
        this.f1838a.setCollapsible(z);
    }

    public void b(Drawable drawable) {
        this.f1844g = drawable;
        r();
    }

    public void a(View view) {
        View view2 = this.f1841d;
        if (view2 != null && (this.f1839b & 16) != 0) {
            this.f1838a.removeView(view2);
        }
        this.f1841d = view;
        if (view == null || (this.f1839b & 16) == 0) {
            return;
        }
        this.f1838a.addView(this.f1841d);
    }

    @Override // a.b.h.k.i0
    public a.b.g.k.z a(int i2, long j) {
        a.b.g.k.z a2 = a.b.g.k.u.a(this.f1838a);
        a2.a(i2 == 0 ? 1.0f : 0.0f);
        a2.a(j);
        a2.a(new b(i2));
        return a2;
    }

    public void a(CharSequence charSequence) {
        this.k = charSequence;
        q();
    }

    @Override // a.b.h.k.i0
    public void a(int i2) {
        this.f1838a.setVisibility(i2);
    }

    @Override // a.b.h.k.i0
    public void a(p.a aVar, h.a aVar2) {
        this.f1838a.a(aVar, aVar2);
    }
}
