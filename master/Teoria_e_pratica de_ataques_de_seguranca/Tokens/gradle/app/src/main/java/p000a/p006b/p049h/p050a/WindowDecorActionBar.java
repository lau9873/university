package p000a.p006b.p049h.p050a;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.support.p067v7.widget.ActionBarContainer;
import android.support.p067v7.widget.ActionBarContextView;
import android.support.p067v7.widget.ActionBarOverlayLayout;
import android.support.p067v7.widget.Toolbar;
import android.util.TypedValue;
import android.view.ContextThemeWrapper;
import android.view.KeyCharacterMap;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import p000a.p006b.p030g.p045k.ViewCompat;
import p000a.p006b.p030g.p045k.ViewPropertyAnimatorCompat;
import p000a.p006b.p030g.p045k.ViewPropertyAnimatorListener;
import p000a.p006b.p030g.p045k.ViewPropertyAnimatorListenerAdapter;
import p000a.p006b.p030g.p045k.ViewPropertyAnimatorUpdateListener;
import p000a.p006b.p049h.p050a.ActionBar;
import p000a.p006b.p049h.p051b.C0354a;
import p000a.p006b.p049h.p051b.C0359f;
import p000a.p006b.p049h.p051b.C0363j;
import p000a.p006b.p049h.p061j.ActionBarPolicy;
import p000a.p006b.p049h.p061j.ActionMode;
import p000a.p006b.p049h.p061j.SupportMenuInflater;
import p000a.p006b.p049h.p061j.ViewPropertyAnimatorCompatSet;
import p000a.p006b.p049h.p061j.p062j.MenuBuilder;
import p000a.p006b.p049h.p063k.DecorToolbar;
import p000a.p006b.p049h.p063k.ScrollingTabContainerView;

/* renamed from: a.b.h.a.m */
/* loaded from: classes.dex */
public class WindowDecorActionBar extends ActionBar implements ActionBarOverlayLayout.InterfaceC0684d {

    /* renamed from: B */
    public static final Interpolator f2005B = new AccelerateInterpolator();

    /* renamed from: C */
    public static final Interpolator f2006C = new DecelerateInterpolator();

    /* renamed from: A */
    public final ViewPropertyAnimatorUpdateListener f2007A;

    /* renamed from: a */
    public Context f2008a;

    /* renamed from: b */
    public Context f2009b;

    /* renamed from: c */
    public ActionBarOverlayLayout f2010c;

    /* renamed from: d */
    public ActionBarContainer f2011d;

    /* renamed from: e */
    public DecorToolbar f2012e;

    /* renamed from: f */
    public ActionBarContextView f2013f;

    /* renamed from: g */
    public View f2014g;

    /* renamed from: h */
    public ScrollingTabContainerView f2015h;

    /* renamed from: i */
    public boolean f2016i;

    /* renamed from: j */
    public C0353d f2017j;

    /* renamed from: k */
    public ActionMode f2018k;

    /* renamed from: l */
    public ActionMode.InterfaceC0414a f2019l;

    /* renamed from: m */
    public boolean f2020m;

    /* renamed from: n */
    public ArrayList<ActionBar.InterfaceC0323b> f2021n;

    /* renamed from: o */
    public boolean f2022o;

    /* renamed from: p */
    public int f2023p;

    /* renamed from: q */
    public boolean f2024q;

    /* renamed from: r */
    public boolean f2025r;

    /* renamed from: s */
    public boolean f2026s;

    /* renamed from: t */
    public boolean f2027t;

    /* renamed from: u */
    public boolean f2028u;

    /* renamed from: v */
    public ViewPropertyAnimatorCompatSet f2029v;

    /* renamed from: w */
    public boolean f2030w;

    /* renamed from: x */
    public boolean f2031x;

    /* renamed from: y */
    public final ViewPropertyAnimatorListener f2032y;

    /* renamed from: z */
    public final ViewPropertyAnimatorListener f2033z;

    /* compiled from: WindowDecorActionBar.java */
    /* renamed from: a.b.h.a.m$a */
    /* loaded from: classes.dex */
    public class C0350a extends ViewPropertyAnimatorListenerAdapter {
        public C0350a() {
        }

        @Override // p000a.p006b.p030g.p045k.ViewPropertyAnimatorListener
        /* renamed from: b */
        public void mo8184b(View view) {
            View view2;
            WindowDecorActionBar windowDecorActionBar = WindowDecorActionBar.this;
            if (windowDecorActionBar.f2024q && (view2 = windowDecorActionBar.f2014g) != null) {
                view2.setTranslationY(0.0f);
                WindowDecorActionBar.this.f2011d.setTranslationY(0.0f);
            }
            WindowDecorActionBar.this.f2011d.setVisibility(8);
            WindowDecorActionBar.this.f2011d.setTransitioning(false);
            WindowDecorActionBar windowDecorActionBar2 = WindowDecorActionBar.this;
            windowDecorActionBar2.f2029v = null;
            windowDecorActionBar2.m8980l();
            ActionBarOverlayLayout actionBarOverlayLayout = WindowDecorActionBar.this.f2010c;
            if (actionBarOverlayLayout != null) {
                ViewCompat.m9463B(actionBarOverlayLayout);
            }
        }
    }

    /* compiled from: WindowDecorActionBar.java */
    /* renamed from: a.b.h.a.m$b */
    /* loaded from: classes.dex */
    public class C0351b extends ViewPropertyAnimatorListenerAdapter {
        public C0351b() {
        }

        @Override // p000a.p006b.p030g.p045k.ViewPropertyAnimatorListener
        /* renamed from: b */
        public void mo8184b(View view) {
            WindowDecorActionBar windowDecorActionBar = WindowDecorActionBar.this;
            windowDecorActionBar.f2029v = null;
            windowDecorActionBar.f2011d.requestLayout();
        }
    }

    /* compiled from: WindowDecorActionBar.java */
    /* renamed from: a.b.h.a.m$c */
    /* loaded from: classes.dex */
    public class C0352c implements ViewPropertyAnimatorUpdateListener {
        public C0352c() {
        }

        @Override // p000a.p006b.p030g.p045k.ViewPropertyAnimatorUpdateListener
        /* renamed from: a */
        public void mo8973a(View view) {
            ((View) WindowDecorActionBar.this.f2011d.getParent()).invalidate();
        }
    }

    /* compiled from: WindowDecorActionBar.java */
    /* renamed from: a.b.h.a.m$d */
    /* loaded from: classes.dex */
    public class C0353d extends ActionMode implements MenuBuilder.InterfaceC0425a {

        /* renamed from: c */
        public final Context f2037c;

        /* renamed from: d */
        public final MenuBuilder f2038d;

        /* renamed from: e */
        public ActionMode.InterfaceC0414a f2039e;

        /* renamed from: f */
        public WeakReference<View> f2040f;

        public C0353d(Context context, ActionMode.InterfaceC0414a interfaceC0414a) {
            this.f2037c = context;
            this.f2039e = interfaceC0414a;
            MenuBuilder menuBuilder = new MenuBuilder(context);
            menuBuilder.m8673c(1);
            this.f2038d = menuBuilder;
            this.f2038d.mo8579a(this);
        }

        @Override // p000a.p006b.p049h.p061j.ActionMode
        /* renamed from: a */
        public void mo8767a() {
            WindowDecorActionBar windowDecorActionBar = WindowDecorActionBar.this;
            if (windowDecorActionBar.f2017j != this) {
                return;
            }
            if (!WindowDecorActionBar.m8995a(windowDecorActionBar.f2025r, windowDecorActionBar.f2026s, false)) {
                WindowDecorActionBar windowDecorActionBar2 = WindowDecorActionBar.this;
                windowDecorActionBar2.f2018k = this;
                windowDecorActionBar2.f2019l = this.f2039e;
            } else {
                this.f2039e.mo8753a(this);
            }
            this.f2039e = null;
            WindowDecorActionBar.this.m8988f(false);
            WindowDecorActionBar.this.f2013f.m7128a();
            WindowDecorActionBar.this.f2012e.mo8197h().sendAccessibilityEvent(32);
            WindowDecorActionBar windowDecorActionBar3 = WindowDecorActionBar.this;
            windowDecorActionBar3.f2010c.setHideOnContentScrollEnabled(windowDecorActionBar3.f2031x);
            WindowDecorActionBar.this.f2017j = null;
        }

        @Override // p000a.p006b.p049h.p061j.ActionMode
        /* renamed from: b */
        public void mo8760b(CharSequence charSequence) {
            WindowDecorActionBar.this.f2013f.setTitle(charSequence);
        }

        @Override // p000a.p006b.p049h.p061j.ActionMode
        /* renamed from: c */
        public Menu mo8759c() {
            return this.f2038d;
        }

        @Override // p000a.p006b.p049h.p061j.ActionMode
        /* renamed from: d */
        public MenuInflater mo8758d() {
            return new SupportMenuInflater(this.f2037c);
        }

        @Override // p000a.p006b.p049h.p061j.ActionMode
        /* renamed from: e */
        public CharSequence mo8757e() {
            return WindowDecorActionBar.this.f2013f.getSubtitle();
        }

        @Override // p000a.p006b.p049h.p061j.ActionMode
        /* renamed from: g */
        public CharSequence mo8756g() {
            return WindowDecorActionBar.this.f2013f.getTitle();
        }

        @Override // p000a.p006b.p049h.p061j.ActionMode
        /* renamed from: i */
        public void mo8755i() {
            if (WindowDecorActionBar.this.f2017j != this) {
                return;
            }
            this.f2038d.m8650s();
            try {
                this.f2039e.mo8748b(this, this.f2038d);
            } finally {
                this.f2038d.m8651r();
            }
        }

        @Override // p000a.p006b.p049h.p061j.ActionMode
        /* renamed from: j */
        public boolean mo8754j() {
            return WindowDecorActionBar.this.f2013f.m7125c();
        }

        /* renamed from: k */
        public boolean m8972k() {
            this.f2038d.m8650s();
            try {
                return this.f2039e.mo8752a(this, this.f2038d);
            } finally {
                this.f2038d.m8651r();
            }
        }

        @Override // p000a.p006b.p049h.p061j.ActionMode
        /* renamed from: b */
        public void mo8761b(int i) {
            mo8760b(WindowDecorActionBar.this.f2008a.getResources().getString(i));
        }

        @Override // p000a.p006b.p049h.p061j.ActionMode
        /* renamed from: b */
        public View mo8762b() {
            WeakReference<View> weakReference = this.f2040f;
            if (weakReference != null) {
                return weakReference.get();
            }
            return null;
        }

        @Override // p000a.p006b.p049h.p061j.ActionMode
        /* renamed from: a */
        public void mo8765a(View view) {
            WindowDecorActionBar.this.f2013f.setCustomView(view);
            this.f2040f = new WeakReference<>(view);
        }

        @Override // p000a.p006b.p049h.p061j.ActionMode
        /* renamed from: a */
        public void mo8764a(CharSequence charSequence) {
            WindowDecorActionBar.this.f2013f.setSubtitle(charSequence);
        }

        @Override // p000a.p006b.p049h.p061j.ActionMode
        /* renamed from: a */
        public void mo8766a(int i) {
            mo8764a((CharSequence) WindowDecorActionBar.this.f2008a.getResources().getString(i));
        }

        @Override // p000a.p006b.p049h.p061j.ActionMode
        /* renamed from: a */
        public void mo8763a(boolean z) {
            super.mo8763a(z);
            WindowDecorActionBar.this.f2013f.setTitleOptional(z);
        }

        @Override // p000a.p006b.p049h.p061j.p062j.MenuBuilder.InterfaceC0425a
        /* renamed from: a */
        public boolean mo7077a(MenuBuilder menuBuilder, MenuItem menuItem) {
            ActionMode.InterfaceC0414a interfaceC0414a = this.f2039e;
            if (interfaceC0414a != null) {
                return interfaceC0414a.mo8751a(this, menuItem);
            }
            return false;
        }

        @Override // p000a.p006b.p049h.p061j.p062j.MenuBuilder.InterfaceC0425a
        /* renamed from: a */
        public void mo7078a(MenuBuilder menuBuilder) {
            if (this.f2039e == null) {
                return;
            }
            mo8755i();
            WindowDecorActionBar.this.f2013f.m7123e();
        }
    }

    public WindowDecorActionBar(Activity activity, boolean z) {
        new ArrayList();
        this.f2021n = new ArrayList<>();
        this.f2023p = 0;
        this.f2024q = true;
        this.f2028u = true;
        this.f2032y = new C0350a();
        this.f2033z = new C0351b();
        this.f2007A = new C0352c();
        View decorView = activity.getWindow().getDecorView();
        m8994b(decorView);
        if (z) {
            return;
        }
        this.f2014g = decorView.findViewById(16908290);
    }

    /* renamed from: a */
    public static boolean m8995a(boolean z, boolean z2, boolean z3) {
        if (z3) {
            return true;
        }
        return (z || z2) ? false : true;
    }

    /* renamed from: a */
    public final DecorToolbar m8997a(View view) {
        if (view instanceof DecorToolbar) {
            return (DecorToolbar) view;
        }
        if (view instanceof Toolbar) {
            return ((Toolbar) view).getWrapper();
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Can't make a decor toolbar out of ");
        sb.append(view != null ? view.getClass().getSimpleName() : "null");
        throw new IllegalStateException(sb.toString());
    }

    /* renamed from: b */
    public final void m8994b(View view) {
        this.f2010c = (ActionBarOverlayLayout) view.findViewById(C0359f.decor_content_parent);
        ActionBarOverlayLayout actionBarOverlayLayout = this.f2010c;
        if (actionBarOverlayLayout != null) {
            actionBarOverlayLayout.setActionBarVisibilityCallback(this);
        }
        this.f2012e = m8997a(view.findViewById(C0359f.action_bar));
        this.f2013f = (ActionBarContextView) view.findViewById(C0359f.action_context_bar);
        this.f2011d = (ActionBarContainer) view.findViewById(C0359f.action_bar_container);
        DecorToolbar decorToolbar = this.f2012e;
        if (decorToolbar != null && this.f2013f != null && this.f2011d != null) {
            this.f2008a = decorToolbar.mo8196i();
            boolean z = (this.f2012e.mo8194k() & 4) != 0;
            if (z) {
                this.f2016i = true;
            }
            ActionBarPolicy m8781a = ActionBarPolicy.m8781a(this.f2008a);
            m8979l(m8781a.m8782a() || z);
            m8982j(m8781a.m8776f());
            TypedArray obtainStyledAttributes = this.f2008a.obtainStyledAttributes(null, C0363j.ActionBar, C0354a.actionBarStyle, 0);
            if (obtainStyledAttributes.getBoolean(C0363j.ActionBar_hideOnContentScroll, false)) {
                m8981k(true);
            }
            int dimensionPixelSize = obtainStyledAttributes.getDimensionPixelSize(C0363j.ActionBar_elevation, 0);
            if (dimensionPixelSize != 0) {
                m9002a(dimensionPixelSize);
            }
            obtainStyledAttributes.recycle();
            return;
        }
        throw new IllegalStateException(WindowDecorActionBar.class.getSimpleName() + " can only be used with a compatible window decor layout");
    }

    @Override // android.support.p067v7.widget.ActionBarOverlayLayout.InterfaceC0684d
    /* renamed from: c */
    public void mo7098c() {
    }

    @Override // p000a.p006b.p049h.p050a.ActionBar
    /* renamed from: c */
    public void mo8992c(boolean z) {
        if (this.f2016i) {
            return;
        }
        m8983i(z);
    }

    @Override // p000a.p006b.p049h.p050a.ActionBar
    /* renamed from: d */
    public void mo8991d(boolean z) {
        m9001a(z ? 8 : 0, 8);
    }

    @Override // p000a.p006b.p049h.p050a.ActionBar
    /* renamed from: e */
    public void mo8990e(boolean z) {
        ViewPropertyAnimatorCompatSet viewPropertyAnimatorCompatSet;
        this.f2030w = z;
        if (z || (viewPropertyAnimatorCompatSet = this.f2029v) == null) {
            return;
        }
        viewPropertyAnimatorCompatSet.m8735a();
    }

    /* renamed from: f */
    public void m8988f(boolean z) {
        ViewPropertyAnimatorCompat mo8220a;
        ViewPropertyAnimatorCompat m8567a;
        if (z) {
            m8974p();
        } else {
            m8976n();
        }
        if (!m8975o()) {
            if (z) {
                this.f2012e.mo8221a(4);
                this.f2013f.setVisibility(0);
                return;
            }
            this.f2012e.mo8221a(0);
            this.f2013f.setVisibility(8);
            return;
        }
        if (z) {
            m8567a = this.f2012e.mo8220a(4, 100L);
            mo8220a = this.f2013f.m8567a(0, 200L);
        } else {
            mo8220a = this.f2012e.mo8220a(0, 200L);
            m8567a = this.f2013f.m8567a(8, 100L);
        }
        ViewPropertyAnimatorCompatSet viewPropertyAnimatorCompatSet = new ViewPropertyAnimatorCompatSet();
        viewPropertyAnimatorCompatSet.m8731a(m8567a, mo8220a);
        viewPropertyAnimatorCompatSet.m8728c();
    }

    @Override // p000a.p006b.p049h.p050a.ActionBar
    /* renamed from: g */
    public int mo8987g() {
        return this.f2012e.mo8194k();
    }

    /* renamed from: h */
    public void m8984h(boolean z) {
        View view;
        View view2;
        int[] iArr;
        ViewPropertyAnimatorCompatSet viewPropertyAnimatorCompatSet = this.f2029v;
        if (viewPropertyAnimatorCompatSet != null) {
            viewPropertyAnimatorCompatSet.m8735a();
        }
        this.f2011d.setVisibility(0);
        if (this.f2023p == 0 && (this.f2030w || z)) {
            this.f2011d.setTranslationY(0.0f);
            float f = -this.f2011d.getHeight();
            if (z) {
                this.f2011d.getLocationInWindow(new int[]{0, 0});
                f -= iArr[1];
            }
            this.f2011d.setTranslationY(f);
            ViewPropertyAnimatorCompatSet viewPropertyAnimatorCompatSet2 = new ViewPropertyAnimatorCompatSet();
            ViewPropertyAnimatorCompat m9459a = ViewCompat.m9459a(this.f2011d);
            m9459a.m9329b(0.0f);
            m9459a.m9333a(this.f2007A);
            viewPropertyAnimatorCompatSet2.m8732a(m9459a);
            if (this.f2024q && (view2 = this.f2014g) != null) {
                view2.setTranslationY(f);
                ViewPropertyAnimatorCompat m9459a2 = ViewCompat.m9459a(this.f2014g);
                m9459a2.m9329b(0.0f);
                viewPropertyAnimatorCompatSet2.m8732a(m9459a2);
            }
            viewPropertyAnimatorCompatSet2.m8730a(f2006C);
            viewPropertyAnimatorCompatSet2.m8734a(250L);
            viewPropertyAnimatorCompatSet2.m8733a(this.f2033z);
            this.f2029v = viewPropertyAnimatorCompatSet2;
            viewPropertyAnimatorCompatSet2.m8728c();
        } else {
            this.f2011d.setAlpha(1.0f);
            this.f2011d.setTranslationY(0.0f);
            if (this.f2024q && (view = this.f2014g) != null) {
                view.setTranslationY(0.0f);
            }
            this.f2033z.mo8184b(null);
        }
        ActionBarOverlayLayout actionBarOverlayLayout = this.f2010c;
        if (actionBarOverlayLayout != null) {
            ViewCompat.m9463B(actionBarOverlayLayout);
        }
    }

    /* renamed from: i */
    public void m8983i(boolean z) {
        m9001a(z ? 4 : 0, 4);
    }

    /* renamed from: j */
    public final void m8982j(boolean z) {
        this.f2022o = z;
        if (!this.f2022o) {
            this.f2012e.mo8218a((ScrollingTabContainerView) null);
            this.f2011d.setTabContainer(this.f2015h);
        } else {
            this.f2011d.setTabContainer(null);
            this.f2012e.mo8218a(this.f2015h);
        }
        boolean z2 = true;
        boolean z3 = m8978m() == 2;
        ScrollingTabContainerView scrollingTabContainerView = this.f2015h;
        if (scrollingTabContainerView != null) {
            if (z3) {
                scrollingTabContainerView.setVisibility(0);
                ActionBarOverlayLayout actionBarOverlayLayout = this.f2010c;
                if (actionBarOverlayLayout != null) {
                    ViewCompat.m9463B(actionBarOverlayLayout);
                }
            } else {
                scrollingTabContainerView.setVisibility(8);
            }
        }
        this.f2012e.mo8208b(!this.f2022o && z3);
        this.f2010c.setHasNonEmbeddedTabs((this.f2022o || !z3) ? false : false);
    }

    /* renamed from: k */
    public void m8981k(boolean z) {
        if (z && !this.f2010c.m7107j()) {
            throw new IllegalStateException("Action bar must be in overlay mode (Window.FEATURE_OVERLAY_ACTION_BAR) to enable hide on content scroll");
        }
        this.f2031x = z;
        this.f2010c.setHideOnContentScrollEnabled(z);
    }

    /* renamed from: l */
    public void m8980l() {
        ActionMode.InterfaceC0414a interfaceC0414a = this.f2019l;
        if (interfaceC0414a != null) {
            interfaceC0414a.mo8753a(this.f2018k);
            this.f2018k = null;
            this.f2019l = null;
        }
    }

    /* renamed from: m */
    public int m8978m() {
        return this.f2012e.mo8192m();
    }

    /* renamed from: n */
    public final void m8976n() {
        if (this.f2027t) {
            this.f2027t = false;
            ActionBarOverlayLayout actionBarOverlayLayout = this.f2010c;
            if (actionBarOverlayLayout != null) {
                actionBarOverlayLayout.setShowingForActionMode(false);
            }
            m8977m(false);
        }
    }

    /* renamed from: o */
    public final boolean m8975o() {
        return ViewCompat.m9409x(this.f2011d);
    }

    /* renamed from: p */
    public final void m8974p() {
        if (this.f2027t) {
            return;
        }
        this.f2027t = true;
        ActionBarOverlayLayout actionBarOverlayLayout = this.f2010c;
        if (actionBarOverlayLayout != null) {
            actionBarOverlayLayout.setShowingForActionMode(true);
        }
        m8977m(false);
    }

    @Override // android.support.p067v7.widget.ActionBarOverlayLayout.InterfaceC0684d
    /* renamed from: d */
    public void mo7097d() {
        if (this.f2026s) {
            return;
        }
        this.f2026s = true;
        m8977m(true);
    }

    /* renamed from: g */
    public void m8986g(boolean z) {
        View view;
        int[] iArr;
        ViewPropertyAnimatorCompatSet viewPropertyAnimatorCompatSet = this.f2029v;
        if (viewPropertyAnimatorCompatSet != null) {
            viewPropertyAnimatorCompatSet.m8735a();
        }
        if (this.f2023p == 0 && (this.f2030w || z)) {
            this.f2011d.setAlpha(1.0f);
            this.f2011d.setTransitioning(true);
            ViewPropertyAnimatorCompatSet viewPropertyAnimatorCompatSet2 = new ViewPropertyAnimatorCompatSet();
            float f = -this.f2011d.getHeight();
            if (z) {
                this.f2011d.getLocationInWindow(new int[]{0, 0});
                f -= iArr[1];
            }
            ViewPropertyAnimatorCompat m9459a = ViewCompat.m9459a(this.f2011d);
            m9459a.m9329b(f);
            m9459a.m9333a(this.f2007A);
            viewPropertyAnimatorCompatSet2.m8732a(m9459a);
            if (this.f2024q && (view = this.f2014g) != null) {
                ViewPropertyAnimatorCompat m9459a2 = ViewCompat.m9459a(view);
                m9459a2.m9329b(f);
                viewPropertyAnimatorCompatSet2.m8732a(m9459a2);
            }
            viewPropertyAnimatorCompatSet2.m8730a(f2005B);
            viewPropertyAnimatorCompatSet2.m8734a(250L);
            viewPropertyAnimatorCompatSet2.m8733a(this.f2032y);
            this.f2029v = viewPropertyAnimatorCompatSet2;
            viewPropertyAnimatorCompatSet2.m8728c();
            return;
        }
        this.f2032y.mo8184b(null);
    }

    /* renamed from: m */
    public final void m8977m(boolean z) {
        if (m8995a(this.f2025r, this.f2026s, this.f2027t)) {
            if (this.f2028u) {
                return;
            }
            this.f2028u = true;
            m8984h(z);
        } else if (this.f2028u) {
            this.f2028u = false;
            m8986g(z);
        }
    }

    /* renamed from: l */
    public void m8979l(boolean z) {
        this.f2012e.mo8213a(z);
    }

    /* renamed from: a */
    public void m9002a(float f) {
        ViewCompat.m9458a(this.f2011d, f);
    }

    @Override // p000a.p006b.p049h.p050a.ActionBar
    /* renamed from: a */
    public void mo8998a(Configuration configuration) {
        m8982j(ActionBarPolicy.m8781a(this.f2008a).m8776f());
    }

    @Override // android.support.p067v7.widget.ActionBarOverlayLayout.InterfaceC0684d
    /* renamed from: a */
    public void mo7101a(int i) {
        this.f2023p = i;
    }

    @Override // p000a.p006b.p049h.p050a.ActionBar
    /* renamed from: a */
    public void mo8996a(CharSequence charSequence) {
        this.f2012e.setWindowTitle(charSequence);
    }

    /* renamed from: a */
    public void m9001a(int i, int i2) {
        int mo8194k = this.f2012e.mo8194k();
        if ((i2 & 4) != 0) {
            this.f2016i = true;
        }
        this.f2012e.mo8211b((i & i2) | ((~i2) & mo8194k));
    }

    public WindowDecorActionBar(Dialog dialog) {
        new ArrayList();
        this.f2021n = new ArrayList<>();
        this.f2023p = 0;
        this.f2024q = true;
        this.f2028u = true;
        this.f2032y = new C0350a();
        this.f2033z = new C0351b();
        this.f2007A = new C0352c();
        m8994b(dialog.getWindow().getDecorView());
    }

    @Override // p000a.p006b.p049h.p050a.ActionBar
    /* renamed from: a */
    public ActionMode mo8999a(ActionMode.InterfaceC0414a interfaceC0414a) {
        C0353d c0353d = this.f2017j;
        if (c0353d != null) {
            c0353d.mo8767a();
        }
        this.f2010c.setHideOnContentScrollEnabled(false);
        this.f2013f.m7124d();
        C0353d c0353d2 = new C0353d(this.f2013f.getContext(), interfaceC0414a);
        if (c0353d2.m8972k()) {
            this.f2017j = c0353d2;
            c0353d2.mo8755i();
            this.f2013f.m7127a(c0353d2);
            m8988f(true);
            this.f2013f.sendAccessibilityEvent(32);
            return c0353d2;
        }
        return null;
    }

    @Override // p000a.p006b.p049h.p050a.ActionBar
    /* renamed from: f */
    public boolean mo8989f() {
        DecorToolbar decorToolbar = this.f2012e;
        if (decorToolbar == null || !decorToolbar.mo8195j()) {
            return false;
        }
        this.f2012e.collapseActionView();
        return true;
    }

    @Override // p000a.p006b.p049h.p050a.ActionBar
    /* renamed from: b */
    public void mo8993b(boolean z) {
        if (z == this.f2020m) {
            return;
        }
        this.f2020m = z;
        int size = this.f2021n.size();
        for (int i = 0; i < size; i++) {
            this.f2021n.get(i).m9155a(z);
        }
    }

    @Override // android.support.p067v7.widget.ActionBarOverlayLayout.InterfaceC0684d
    /* renamed from: a */
    public void mo7100a(boolean z) {
        this.f2024q = z;
    }

    @Override // android.support.p067v7.widget.ActionBarOverlayLayout.InterfaceC0684d
    /* renamed from: b */
    public void mo7099b() {
        ViewPropertyAnimatorCompatSet viewPropertyAnimatorCompatSet = this.f2029v;
        if (viewPropertyAnimatorCompatSet != null) {
            viewPropertyAnimatorCompatSet.m8735a();
            this.f2029v = null;
        }
    }

    @Override // android.support.p067v7.widget.ActionBarOverlayLayout.InterfaceC0684d
    /* renamed from: a */
    public void mo7102a() {
        if (this.f2026s) {
            this.f2026s = false;
            m8977m(true);
        }
    }

    @Override // p000a.p006b.p049h.p050a.ActionBar
    /* renamed from: a */
    public boolean mo9000a(int i, KeyEvent keyEvent) {
        Menu mo8759c;
        C0353d c0353d = this.f2017j;
        if (c0353d == null || (mo8759c = c0353d.mo8759c()) == null) {
            return false;
        }
        mo8759c.setQwertyMode(KeyCharacterMap.load(keyEvent != null ? keyEvent.getDeviceId() : -1).getKeyboardType() != 1);
        return mo8759c.performShortcut(i, keyEvent, 0);
    }

    @Override // p000a.p006b.p049h.p050a.ActionBar
    /* renamed from: h */
    public Context mo8985h() {
        if (this.f2009b == null) {
            TypedValue typedValue = new TypedValue();
            this.f2008a.getTheme().resolveAttribute(C0354a.actionBarWidgetTheme, typedValue, true);
            int i = typedValue.resourceId;
            if (i != 0) {
                this.f2009b = new ContextThemeWrapper(this.f2008a, i);
            } else {
                this.f2009b = this.f2008a;
            }
        }
        return this.f2009b;
    }
}
