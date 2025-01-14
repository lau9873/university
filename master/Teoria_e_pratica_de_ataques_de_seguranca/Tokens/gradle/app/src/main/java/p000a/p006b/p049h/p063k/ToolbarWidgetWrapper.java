package p000a.p006b.p049h.p063k;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.p067v7.widget.Toolbar;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.Window;
import p000a.p006b.p030g.p045k.ViewCompat;
import p000a.p006b.p030g.p045k.ViewPropertyAnimatorCompat;
import p000a.p006b.p030g.p045k.ViewPropertyAnimatorListenerAdapter;
import p000a.p006b.p049h.p051b.C0354a;
import p000a.p006b.p049h.p051b.C0358e;
import p000a.p006b.p049h.p051b.C0359f;
import p000a.p006b.p049h.p051b.C0361h;
import p000a.p006b.p049h.p051b.C0363j;
import p000a.p006b.p049h.p053d.p054a.AppCompatResources;
import p000a.p006b.p049h.p061j.p062j.ActionMenuItem;
import p000a.p006b.p049h.p061j.p062j.MenuBuilder;
import p000a.p006b.p049h.p061j.p062j.MenuPresenter;

/* renamed from: a.b.h.k.m1 */
/* loaded from: classes.dex */
public class ToolbarWidgetWrapper implements DecorToolbar {

    /* renamed from: a */
    public Toolbar f2792a;

    /* renamed from: b */
    public int f2793b;

    /* renamed from: c */
    public View f2794c;

    /* renamed from: d */
    public View f2795d;

    /* renamed from: e */
    public Drawable f2796e;

    /* renamed from: f */
    public Drawable f2797f;

    /* renamed from: g */
    public Drawable f2798g;

    /* renamed from: h */
    public boolean f2799h;

    /* renamed from: i */
    public CharSequence f2800i;

    /* renamed from: j */
    public CharSequence f2801j;

    /* renamed from: k */
    public CharSequence f2802k;

    /* renamed from: l */
    public Window.Callback f2803l;

    /* renamed from: m */
    public boolean f2804m;

    /* renamed from: n */
    public ActionMenuPresenter f2805n;

    /* renamed from: o */
    public int f2806o;

    /* renamed from: p */
    public int f2807p;

    /* renamed from: q */
    public Drawable f2808q;

    /* compiled from: ToolbarWidgetWrapper.java */
    /* renamed from: a.b.h.k.m1$a */
    /* loaded from: classes.dex */
    public class View$OnClickListenerC0482a implements View.OnClickListener {

        /* renamed from: a */
        public final ActionMenuItem f2809a;

        public View$OnClickListenerC0482a() {
            this.f2809a = new ActionMenuItem(ToolbarWidgetWrapper.this.f2792a.getContext(), 0, 16908332, 0, 0, ToolbarWidgetWrapper.this.f2800i);
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            ToolbarWidgetWrapper toolbarWidgetWrapper = ToolbarWidgetWrapper.this;
            Window.Callback callback = toolbarWidgetWrapper.f2803l;
            if (callback == null || !toolbarWidgetWrapper.f2804m) {
                return;
            }
            callback.onMenuItemSelected(0, this.f2809a);
        }
    }

    /* compiled from: ToolbarWidgetWrapper.java */
    /* renamed from: a.b.h.k.m1$b */
    /* loaded from: classes.dex */
    public class C0483b extends ViewPropertyAnimatorListenerAdapter {

        /* renamed from: a */
        public boolean f2811a = false;

        /* renamed from: b */
        public final /* synthetic */ int f2812b;

        public C0483b(int i) {
            this.f2812b = i;
        }

        @Override // p000a.p006b.p030g.p045k.ViewPropertyAnimatorListenerAdapter, p000a.p006b.p030g.p045k.ViewPropertyAnimatorListener
        /* renamed from: a */
        public void mo8185a(View view) {
            this.f2811a = true;
        }

        @Override // p000a.p006b.p030g.p045k.ViewPropertyAnimatorListener
        /* renamed from: b */
        public void mo8184b(View view) {
            if (this.f2811a) {
                return;
            }
            ToolbarWidgetWrapper.this.f2792a.setVisibility(this.f2812b);
        }

        @Override // p000a.p006b.p030g.p045k.ViewPropertyAnimatorListenerAdapter, p000a.p006b.p030g.p045k.ViewPropertyAnimatorListener
        /* renamed from: c */
        public void mo8183c(View view) {
            ToolbarWidgetWrapper.this.f2792a.setVisibility(0);
        }
    }

    public ToolbarWidgetWrapper(Toolbar toolbar, boolean z) {
        this(toolbar, z, C0361h.abc_action_bar_up_description, C0358e.abc_ic_ab_back_material);
    }

    /* renamed from: a */
    public void m8217a(Drawable drawable) {
        this.f2797f = drawable;
        m8186s();
    }

    @Override // p000a.p006b.p049h.p063k.DecorToolbar
    /* renamed from: a */
    public void mo8213a(boolean z) {
    }

    /* renamed from: b */
    public void m8209b(CharSequence charSequence) {
        this.f2801j = charSequence;
        if ((this.f2793b & 8) != 0) {
            this.f2792a.setSubtitle(charSequence);
        }
    }

    /* renamed from: c */
    public void m8205c(CharSequence charSequence) {
        this.f2799h = true;
        m8202d(charSequence);
    }

    @Override // p000a.p006b.p049h.p063k.DecorToolbar
    public void collapseActionView() {
        this.f2792a.m6303c();
    }

    /* renamed from: d */
    public void m8203d(int i) {
        if (i == this.f2807p) {
            return;
        }
        this.f2807p = i;
        if (TextUtils.isEmpty(this.f2792a.getNavigationContentDescription())) {
            m8200e(this.f2807p);
        }
    }

    @Override // p000a.p006b.p049h.p063k.DecorToolbar
    /* renamed from: e */
    public boolean mo8201e() {
        return this.f2792a.m6285r();
    }

    @Override // p000a.p006b.p049h.p063k.DecorToolbar
    /* renamed from: f */
    public boolean mo8199f() {
        return this.f2792a.m6308b();
    }

    @Override // p000a.p006b.p049h.p063k.DecorToolbar
    /* renamed from: g */
    public void mo8198g() {
        this.f2792a.m6300d();
    }

    @Override // p000a.p006b.p049h.p063k.DecorToolbar
    public CharSequence getTitle() {
        return this.f2792a.getTitle();
    }

    @Override // p000a.p006b.p049h.p063k.DecorToolbar
    /* renamed from: h */
    public ViewGroup mo8197h() {
        return this.f2792a;
    }

    @Override // p000a.p006b.p049h.p063k.DecorToolbar
    /* renamed from: i */
    public Context mo8196i() {
        return this.f2792a.getContext();
    }

    @Override // p000a.p006b.p049h.p063k.DecorToolbar
    /* renamed from: j */
    public boolean mo8195j() {
        return this.f2792a.m6292k();
    }

    @Override // p000a.p006b.p049h.p063k.DecorToolbar
    /* renamed from: k */
    public int mo8194k() {
        return this.f2793b;
    }

    @Override // p000a.p006b.p049h.p063k.DecorToolbar
    /* renamed from: l */
    public Menu mo8193l() {
        return this.f2792a.getMenu();
    }

    @Override // p000a.p006b.p049h.p063k.DecorToolbar
    /* renamed from: m */
    public int mo8192m() {
        return this.f2806o;
    }

    @Override // p000a.p006b.p049h.p063k.DecorToolbar
    /* renamed from: n */
    public void mo8191n() {
        Log.i("ToolbarWidgetWrapper", "Progress display unsupported");
    }

    @Override // p000a.p006b.p049h.p063k.DecorToolbar
    /* renamed from: o */
    public void mo8190o() {
        Log.i("ToolbarWidgetWrapper", "Progress display unsupported");
    }

    /* renamed from: p */
    public final int m8189p() {
        if (this.f2792a.getNavigationIcon() != null) {
            this.f2808q = this.f2792a.getNavigationIcon();
            return 15;
        }
        return 11;
    }

    /* renamed from: q */
    public final void m8188q() {
        if ((this.f2793b & 4) != 0) {
            if (TextUtils.isEmpty(this.f2802k)) {
                this.f2792a.setNavigationContentDescription(this.f2807p);
            } else {
                this.f2792a.setNavigationContentDescription(this.f2802k);
            }
        }
    }

    /* renamed from: r */
    public final void m8187r() {
        if ((this.f2793b & 4) != 0) {
            Toolbar toolbar = this.f2792a;
            Drawable drawable = this.f2798g;
            if (drawable == null) {
                drawable = this.f2808q;
            }
            toolbar.setNavigationIcon(drawable);
            return;
        }
        this.f2792a.setNavigationIcon((Drawable) null);
    }

    /* renamed from: s */
    public final void m8186s() {
        Drawable drawable;
        int i = this.f2793b;
        if ((i & 2) == 0) {
            drawable = null;
        } else if ((i & 1) != 0) {
            drawable = this.f2797f;
            if (drawable == null) {
                drawable = this.f2796e;
            }
        } else {
            drawable = this.f2796e;
        }
        this.f2792a.setLogo(drawable);
    }

    @Override // p000a.p006b.p049h.p063k.DecorToolbar
    public void setIcon(int i) {
        setIcon(i != 0 ? AppCompatResources.m8967c(mo8196i(), i) : null);
    }

    @Override // p000a.p006b.p049h.p063k.DecorToolbar
    public void setWindowCallback(Window.Callback callback) {
        this.f2803l = callback;
    }

    @Override // p000a.p006b.p049h.p063k.DecorToolbar
    public void setWindowTitle(CharSequence charSequence) {
        if (this.f2799h) {
            return;
        }
        m8202d(charSequence);
    }

    public ToolbarWidgetWrapper(Toolbar toolbar, boolean z, int i, int i2) {
        Drawable drawable;
        this.f2806o = 0;
        this.f2807p = 0;
        this.f2792a = toolbar;
        this.f2800i = toolbar.getTitle();
        this.f2801j = toolbar.getSubtitle();
        this.f2799h = this.f2800i != null;
        this.f2798g = toolbar.getNavigationIcon();
        TintTypedArray m8257a = TintTypedArray.m8257a(toolbar.getContext(), null, C0363j.ActionBar, C0354a.actionBarStyle, 0);
        this.f2808q = m8257a.m8256b(C0363j.ActionBar_homeAsUpIndicator);
        if (z) {
            CharSequence m8249e = m8257a.m8249e(C0363j.ActionBar_title);
            if (!TextUtils.isEmpty(m8249e)) {
                m8205c(m8249e);
            }
            CharSequence m8249e2 = m8257a.m8249e(C0363j.ActionBar_subtitle);
            if (!TextUtils.isEmpty(m8249e2)) {
                m8209b(m8249e2);
            }
            Drawable m8256b = m8257a.m8256b(C0363j.ActionBar_logo);
            if (m8256b != null) {
                m8217a(m8256b);
            }
            Drawable m8256b2 = m8257a.m8256b(C0363j.ActionBar_icon);
            if (m8256b2 != null) {
                setIcon(m8256b2);
            }
            if (this.f2798g == null && (drawable = this.f2808q) != null) {
                m8210b(drawable);
            }
            mo8211b(m8257a.m8250d(C0363j.ActionBar_displayOptions, 0));
            int m8244g = m8257a.m8244g(C0363j.ActionBar_customNavigationLayout, 0);
            if (m8244g != 0) {
                m8215a(LayoutInflater.from(this.f2792a.getContext()).inflate(m8244g, (ViewGroup) this.f2792a, false));
                mo8211b(this.f2793b | 16);
            }
            int m8246f = m8257a.m8246f(C0363j.ActionBar_height, 0);
            if (m8246f > 0) {
                ViewGroup.LayoutParams layoutParams = this.f2792a.getLayoutParams();
                layoutParams.height = m8246f;
                this.f2792a.setLayoutParams(layoutParams);
            }
            int m8254b = m8257a.m8254b(C0363j.ActionBar_contentInsetStart, -1);
            int m8254b2 = m8257a.m8254b(C0363j.ActionBar_contentInsetEnd, -1);
            if (m8254b >= 0 || m8254b2 >= 0) {
                this.f2792a.m6320a(Math.max(m8254b, 0), Math.max(m8254b2, 0));
            }
            int m8244g2 = m8257a.m8244g(C0363j.ActionBar_titleTextStyle, 0);
            if (m8244g2 != 0) {
                Toolbar toolbar2 = this.f2792a;
                toolbar2.m6306b(toolbar2.getContext(), m8244g2);
            }
            int m8244g3 = m8257a.m8244g(C0363j.ActionBar_subtitleTextStyle, 0);
            if (m8244g3 != 0) {
                Toolbar toolbar3 = this.f2792a;
                toolbar3.m6317a(toolbar3.getContext(), m8244g3);
            }
            int m8244g4 = m8257a.m8244g(C0363j.ActionBar_popupTheme, 0);
            if (m8244g4 != 0) {
                this.f2792a.setPopupTheme(m8244g4);
            }
        } else {
            this.f2793b = m8189p();
        }
        m8257a.m8265a();
        m8203d(i);
        this.f2802k = this.f2792a.getNavigationContentDescription();
        this.f2792a.setNavigationOnClickListener(new View$OnClickListenerC0482a());
    }

    /* renamed from: e */
    public void m8200e(int i) {
        m8214a(i == 0 ? null : mo8196i().getString(i));
    }

    @Override // p000a.p006b.p049h.p063k.DecorToolbar
    public void setIcon(Drawable drawable) {
        this.f2796e = drawable;
        m8186s();
    }

    @Override // p000a.p006b.p049h.p063k.DecorToolbar
    /* renamed from: a */
    public boolean mo8222a() {
        return this.f2792a.m6289n();
    }

    @Override // p000a.p006b.p049h.p063k.DecorToolbar
    /* renamed from: c */
    public void mo8206c(int i) {
        m8217a(i != 0 ? AppCompatResources.m8967c(mo8196i(), i) : null);
    }

    @Override // p000a.p006b.p049h.p063k.DecorToolbar
    /* renamed from: a */
    public void mo8216a(Menu menu, MenuPresenter.InterfaceC0434a interfaceC0434a) {
        if (this.f2805n == null) {
            this.f2805n = new ActionMenuPresenter(this.f2792a.getContext());
            this.f2805n.m8725a(C0359f.action_menu_presenter);
        }
        this.f2805n.mo8587a(interfaceC0434a);
        this.f2792a.m6319a((MenuBuilder) menu, this.f2805n);
    }

    @Override // p000a.p006b.p049h.p063k.DecorToolbar
    /* renamed from: b */
    public void mo8212b() {
        this.f2804m = true;
    }

    @Override // p000a.p006b.p049h.p063k.DecorToolbar
    /* renamed from: c */
    public boolean mo8207c() {
        return this.f2792a.m6290m();
    }

    @Override // p000a.p006b.p049h.p063k.DecorToolbar
    /* renamed from: b */
    public void mo8211b(int i) {
        View view;
        int i2 = this.f2793b ^ i;
        this.f2793b = i;
        if (i2 != 0) {
            if ((i2 & 4) != 0) {
                if ((i & 4) != 0) {
                    m8188q();
                }
                m8187r();
            }
            if ((i2 & 3) != 0) {
                m8186s();
            }
            if ((i2 & 8) != 0) {
                if ((i & 8) != 0) {
                    this.f2792a.setTitle(this.f2800i);
                    this.f2792a.setSubtitle(this.f2801j);
                } else {
                    this.f2792a.setTitle((CharSequence) null);
                    this.f2792a.setSubtitle((CharSequence) null);
                }
            }
            if ((i2 & 16) == 0 || (view = this.f2795d) == null) {
                return;
            }
            if ((i & 16) != 0) {
                this.f2792a.addView(view);
            } else {
                this.f2792a.removeView(view);
            }
        }
    }

    /* renamed from: d */
    public final void m8202d(CharSequence charSequence) {
        this.f2800i = charSequence;
        if ((this.f2793b & 8) != 0) {
            this.f2792a.setTitle(charSequence);
        }
    }

    @Override // p000a.p006b.p049h.p063k.DecorToolbar
    /* renamed from: d */
    public boolean mo8204d() {
        return this.f2792a.m6291l();
    }

    @Override // p000a.p006b.p049h.p063k.DecorToolbar
    /* renamed from: a */
    public void mo8218a(ScrollingTabContainerView scrollingTabContainerView) {
        View view = this.f2794c;
        if (view != null) {
            ViewParent parent = view.getParent();
            Toolbar toolbar = this.f2792a;
            if (parent == toolbar) {
                toolbar.removeView(this.f2794c);
            }
        }
        this.f2794c = scrollingTabContainerView;
        if (scrollingTabContainerView == null || this.f2806o != 2) {
            return;
        }
        this.f2792a.addView(this.f2794c, 0);
        Toolbar.C0773e c0773e = (Toolbar.C0773e) this.f2794c.getLayoutParams();
        ((ViewGroup.MarginLayoutParams) c0773e).width = -2;
        ((ViewGroup.MarginLayoutParams) c0773e).height = -2;
        c0773e.f1872a = 8388691;
        scrollingTabContainerView.setAllowCollapse(true);
    }

    @Override // p000a.p006b.p049h.p063k.DecorToolbar
    /* renamed from: b */
    public void mo8208b(boolean z) {
        this.f2792a.setCollapsible(z);
    }

    /* renamed from: b */
    public void m8210b(Drawable drawable) {
        this.f2798g = drawable;
        m8187r();
    }

    /* renamed from: a */
    public void m8215a(View view) {
        View view2 = this.f2795d;
        if (view2 != null && (this.f2793b & 16) != 0) {
            this.f2792a.removeView(view2);
        }
        this.f2795d = view;
        if (view == null || (this.f2793b & 16) == 0) {
            return;
        }
        this.f2792a.addView(this.f2795d);
    }

    @Override // p000a.p006b.p049h.p063k.DecorToolbar
    /* renamed from: a */
    public ViewPropertyAnimatorCompat mo8220a(int i, long j) {
        ViewPropertyAnimatorCompat m9459a = ViewCompat.m9459a(this.f2792a);
        m9459a.m9336a(i == 0 ? 1.0f : 0.0f);
        m9459a.m9335a(j);
        m9459a.m9334a(new C0483b(i));
        return m9459a;
    }

    /* renamed from: a */
    public void m8214a(CharSequence charSequence) {
        this.f2802k = charSequence;
        m8188q();
    }

    @Override // p000a.p006b.p049h.p063k.DecorToolbar
    /* renamed from: a */
    public void mo8221a(int i) {
        this.f2792a.setVisibility(i);
    }

    @Override // p000a.p006b.p049h.p063k.DecorToolbar
    /* renamed from: a */
    public void mo8219a(MenuPresenter.InterfaceC0434a interfaceC0434a, MenuBuilder.InterfaceC0425a interfaceC0425a) {
        this.f2792a.m6318a(interfaceC0434a, interfaceC0425a);
    }
}
