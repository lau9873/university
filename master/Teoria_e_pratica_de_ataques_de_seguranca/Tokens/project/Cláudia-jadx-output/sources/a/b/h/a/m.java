package a.b.h.a;

import a.b.g.k.a0;
import a.b.g.k.b0;
import a.b.g.k.c0;
import a.b.g.k.u;
import a.b.g.k.z;
import a.b.h.a.a;
import a.b.h.j.b;
import a.b.h.j.j.h;
import a.b.h.k.d1;
import a.b.h.k.i0;
import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.support.v7.widget.ActionBarContainer;
import android.support.v7.widget.ActionBarContextView;
import android.support.v7.widget.ActionBarOverlayLayout;
import android.support.v7.widget.Toolbar;
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
/* compiled from: WindowDecorActionBar.java */
/* loaded from: classes.dex */
public class m extends a.b.h.a.a implements ActionBarOverlayLayout.d {
    public static final Interpolator B = new AccelerateInterpolator();
    public static final Interpolator C = new DecelerateInterpolator();
    public final c0 A;

    /* renamed from: a  reason: collision with root package name */
    public Context f1353a;

    /* renamed from: b  reason: collision with root package name */
    public Context f1354b;

    /* renamed from: c  reason: collision with root package name */
    public ActionBarOverlayLayout f1355c;

    /* renamed from: d  reason: collision with root package name */
    public ActionBarContainer f1356d;

    /* renamed from: e  reason: collision with root package name */
    public i0 f1357e;

    /* renamed from: f  reason: collision with root package name */
    public ActionBarContextView f1358f;

    /* renamed from: g  reason: collision with root package name */
    public View f1359g;

    /* renamed from: h  reason: collision with root package name */
    public d1 f1360h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f1361i;
    public d j;
    public a.b.h.j.b k;
    public b.a l;
    public boolean m;
    public ArrayList<a.b> n;
    public boolean o;
    public int p;
    public boolean q;
    public boolean r;
    public boolean s;
    public boolean t;
    public boolean u;
    public a.b.h.j.h v;
    public boolean w;
    public boolean x;
    public final a0 y;
    public final a0 z;

    /* compiled from: WindowDecorActionBar.java */
    /* loaded from: classes.dex */
    public class a extends b0 {
        public a() {
        }

        @Override // a.b.g.k.a0
        public void b(View view) {
            View view2;
            m mVar = m.this;
            if (mVar.q && (view2 = mVar.f1359g) != null) {
                view2.setTranslationY(0.0f);
                m.this.f1356d.setTranslationY(0.0f);
            }
            m.this.f1356d.setVisibility(8);
            m.this.f1356d.setTransitioning(false);
            m mVar2 = m.this;
            mVar2.v = null;
            mVar2.l();
            ActionBarOverlayLayout actionBarOverlayLayout = m.this.f1355c;
            if (actionBarOverlayLayout != null) {
                u.B(actionBarOverlayLayout);
            }
        }
    }

    /* compiled from: WindowDecorActionBar.java */
    /* loaded from: classes.dex */
    public class b extends b0 {
        public b() {
        }

        @Override // a.b.g.k.a0
        public void b(View view) {
            m mVar = m.this;
            mVar.v = null;
            mVar.f1356d.requestLayout();
        }
    }

    /* compiled from: WindowDecorActionBar.java */
    /* loaded from: classes.dex */
    public class c implements c0 {
        public c() {
        }

        @Override // a.b.g.k.c0
        public void a(View view) {
            ((View) m.this.f1356d.getParent()).invalidate();
        }
    }

    /* compiled from: WindowDecorActionBar.java */
    /* loaded from: classes.dex */
    public class d extends a.b.h.j.b implements h.a {

        /* renamed from: c  reason: collision with root package name */
        public final Context f1365c;

        /* renamed from: d  reason: collision with root package name */
        public final a.b.h.j.j.h f1366d;

        /* renamed from: e  reason: collision with root package name */
        public b.a f1367e;

        /* renamed from: f  reason: collision with root package name */
        public WeakReference<View> f1368f;

        public d(Context context, b.a aVar) {
            this.f1365c = context;
            this.f1367e = aVar;
            a.b.h.j.j.h hVar = new a.b.h.j.j.h(context);
            hVar.c(1);
            this.f1366d = hVar;
            this.f1366d.a(this);
        }

        @Override // a.b.h.j.b
        public void a() {
            m mVar = m.this;
            if (mVar.j != this) {
                return;
            }
            if (!m.a(mVar.r, mVar.s, false)) {
                m mVar2 = m.this;
                mVar2.k = this;
                mVar2.l = this.f1367e;
            } else {
                this.f1367e.a(this);
            }
            this.f1367e = null;
            m.this.f(false);
            m.this.f1358f.a();
            m.this.f1357e.h().sendAccessibilityEvent(32);
            m mVar3 = m.this;
            mVar3.f1355c.setHideOnContentScrollEnabled(mVar3.x);
            m.this.j = null;
        }

        @Override // a.b.h.j.b
        public void b(CharSequence charSequence) {
            m.this.f1358f.setTitle(charSequence);
        }

        @Override // a.b.h.j.b
        public Menu c() {
            return this.f1366d;
        }

        @Override // a.b.h.j.b
        public MenuInflater d() {
            return new a.b.h.j.g(this.f1365c);
        }

        @Override // a.b.h.j.b
        public CharSequence e() {
            return m.this.f1358f.getSubtitle();
        }

        @Override // a.b.h.j.b
        public CharSequence g() {
            return m.this.f1358f.getTitle();
        }

        @Override // a.b.h.j.b
        public void i() {
            if (m.this.j != this) {
                return;
            }
            this.f1366d.s();
            try {
                this.f1367e.b(this, this.f1366d);
            } finally {
                this.f1366d.r();
            }
        }

        @Override // a.b.h.j.b
        public boolean j() {
            return m.this.f1358f.c();
        }

        public boolean k() {
            this.f1366d.s();
            try {
                return this.f1367e.a(this, this.f1366d);
            } finally {
                this.f1366d.r();
            }
        }

        @Override // a.b.h.j.b
        public void b(int i2) {
            b(m.this.f1353a.getResources().getString(i2));
        }

        @Override // a.b.h.j.b
        public View b() {
            WeakReference<View> weakReference = this.f1368f;
            if (weakReference != null) {
                return weakReference.get();
            }
            return null;
        }

        @Override // a.b.h.j.b
        public void a(View view) {
            m.this.f1358f.setCustomView(view);
            this.f1368f = new WeakReference<>(view);
        }

        @Override // a.b.h.j.b
        public void a(CharSequence charSequence) {
            m.this.f1358f.setSubtitle(charSequence);
        }

        @Override // a.b.h.j.b
        public void a(int i2) {
            a((CharSequence) m.this.f1353a.getResources().getString(i2));
        }

        @Override // a.b.h.j.b
        public void a(boolean z) {
            super.a(z);
            m.this.f1358f.setTitleOptional(z);
        }

        @Override // a.b.h.j.j.h.a
        public boolean a(a.b.h.j.j.h hVar, MenuItem menuItem) {
            b.a aVar = this.f1367e;
            if (aVar != null) {
                return aVar.a(this, menuItem);
            }
            return false;
        }

        @Override // a.b.h.j.j.h.a
        public void a(a.b.h.j.j.h hVar) {
            if (this.f1367e == null) {
                return;
            }
            i();
            m.this.f1358f.e();
        }
    }

    public m(Activity activity, boolean z) {
        new ArrayList();
        this.n = new ArrayList<>();
        this.p = 0;
        this.q = true;
        this.u = true;
        this.y = new a();
        this.z = new b();
        this.A = new c();
        View decorView = activity.getWindow().getDecorView();
        b(decorView);
        if (z) {
            return;
        }
        this.f1359g = decorView.findViewById(16908290);
    }

    public static boolean a(boolean z, boolean z2, boolean z3) {
        if (z3) {
            return true;
        }
        return (z || z2) ? false : true;
    }

    public final i0 a(View view) {
        if (view instanceof i0) {
            return (i0) view;
        }
        if (view instanceof Toolbar) {
            return ((Toolbar) view).getWrapper();
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Can't make a decor toolbar out of ");
        sb.append(view != null ? view.getClass().getSimpleName() : "null");
        throw new IllegalStateException(sb.toString());
    }

    public final void b(View view) {
        this.f1355c = (ActionBarOverlayLayout) view.findViewById(a.b.h.b.f.decor_content_parent);
        ActionBarOverlayLayout actionBarOverlayLayout = this.f1355c;
        if (actionBarOverlayLayout != null) {
            actionBarOverlayLayout.setActionBarVisibilityCallback(this);
        }
        this.f1357e = a(view.findViewById(a.b.h.b.f.action_bar));
        this.f1358f = (ActionBarContextView) view.findViewById(a.b.h.b.f.action_context_bar);
        this.f1356d = (ActionBarContainer) view.findViewById(a.b.h.b.f.action_bar_container);
        i0 i0Var = this.f1357e;
        if (i0Var != null && this.f1358f != null && this.f1356d != null) {
            this.f1353a = i0Var.i();
            boolean z = (this.f1357e.k() & 4) != 0;
            if (z) {
                this.f1361i = true;
            }
            a.b.h.j.a a2 = a.b.h.j.a.a(this.f1353a);
            l(a2.a() || z);
            j(a2.f());
            TypedArray obtainStyledAttributes = this.f1353a.obtainStyledAttributes(null, a.b.h.b.j.ActionBar, a.b.h.b.a.actionBarStyle, 0);
            if (obtainStyledAttributes.getBoolean(a.b.h.b.j.ActionBar_hideOnContentScroll, false)) {
                k(true);
            }
            int dimensionPixelSize = obtainStyledAttributes.getDimensionPixelSize(a.b.h.b.j.ActionBar_elevation, 0);
            if (dimensionPixelSize != 0) {
                a(dimensionPixelSize);
            }
            obtainStyledAttributes.recycle();
            return;
        }
        throw new IllegalStateException(m.class.getSimpleName() + " can only be used with a compatible window decor layout");
    }

    @Override // android.support.v7.widget.ActionBarOverlayLayout.d
    public void c() {
    }

    @Override // a.b.h.a.a
    public void c(boolean z) {
        if (this.f1361i) {
            return;
        }
        i(z);
    }

    @Override // a.b.h.a.a
    public void d(boolean z) {
        a(z ? 8 : 0, 8);
    }

    @Override // a.b.h.a.a
    public void e(boolean z) {
        a.b.h.j.h hVar;
        this.w = z;
        if (z || (hVar = this.v) == null) {
            return;
        }
        hVar.a();
    }

    public void f(boolean z) {
        z a2;
        z a3;
        if (z) {
            p();
        } else {
            n();
        }
        if (!o()) {
            if (z) {
                this.f1357e.a(4);
                this.f1358f.setVisibility(0);
                return;
            }
            this.f1357e.a(0);
            this.f1358f.setVisibility(8);
            return;
        }
        if (z) {
            a3 = this.f1357e.a(4, 100L);
            a2 = this.f1358f.a(0, 200L);
        } else {
            a2 = this.f1357e.a(0, 200L);
            a3 = this.f1358f.a(8, 100L);
        }
        a.b.h.j.h hVar = new a.b.h.j.h();
        hVar.a(a3, a2);
        hVar.c();
    }

    @Override // a.b.h.a.a
    public int g() {
        return this.f1357e.k();
    }

    public void h(boolean z) {
        View view;
        View view2;
        int[] iArr;
        a.b.h.j.h hVar = this.v;
        if (hVar != null) {
            hVar.a();
        }
        this.f1356d.setVisibility(0);
        if (this.p == 0 && (this.w || z)) {
            this.f1356d.setTranslationY(0.0f);
            float f2 = -this.f1356d.getHeight();
            if (z) {
                this.f1356d.getLocationInWindow(new int[]{0, 0});
                f2 -= iArr[1];
            }
            this.f1356d.setTranslationY(f2);
            a.b.h.j.h hVar2 = new a.b.h.j.h();
            z a2 = u.a(this.f1356d);
            a2.b(0.0f);
            a2.a(this.A);
            hVar2.a(a2);
            if (this.q && (view2 = this.f1359g) != null) {
                view2.setTranslationY(f2);
                z a3 = u.a(this.f1359g);
                a3.b(0.0f);
                hVar2.a(a3);
            }
            hVar2.a(C);
            hVar2.a(250L);
            hVar2.a(this.z);
            this.v = hVar2;
            hVar2.c();
        } else {
            this.f1356d.setAlpha(1.0f);
            this.f1356d.setTranslationY(0.0f);
            if (this.q && (view = this.f1359g) != null) {
                view.setTranslationY(0.0f);
            }
            this.z.b(null);
        }
        ActionBarOverlayLayout actionBarOverlayLayout = this.f1355c;
        if (actionBarOverlayLayout != null) {
            u.B(actionBarOverlayLayout);
        }
    }

    public void i(boolean z) {
        a(z ? 4 : 0, 4);
    }

    public final void j(boolean z) {
        this.o = z;
        if (!this.o) {
            this.f1357e.a((d1) null);
            this.f1356d.setTabContainer(this.f1360h);
        } else {
            this.f1356d.setTabContainer(null);
            this.f1357e.a(this.f1360h);
        }
        boolean z2 = true;
        boolean z3 = m() == 2;
        d1 d1Var = this.f1360h;
        if (d1Var != null) {
            if (z3) {
                d1Var.setVisibility(0);
                ActionBarOverlayLayout actionBarOverlayLayout = this.f1355c;
                if (actionBarOverlayLayout != null) {
                    u.B(actionBarOverlayLayout);
                }
            } else {
                d1Var.setVisibility(8);
            }
        }
        this.f1357e.b(!this.o && z3);
        this.f1355c.setHasNonEmbeddedTabs((this.o || !z3) ? false : false);
    }

    public void k(boolean z) {
        if (z && !this.f1355c.j()) {
            throw new IllegalStateException("Action bar must be in overlay mode (Window.FEATURE_OVERLAY_ACTION_BAR) to enable hide on content scroll");
        }
        this.x = z;
        this.f1355c.setHideOnContentScrollEnabled(z);
    }

    public void l() {
        b.a aVar = this.l;
        if (aVar != null) {
            aVar.a(this.k);
            this.k = null;
            this.l = null;
        }
    }

    public int m() {
        return this.f1357e.m();
    }

    public final void n() {
        if (this.t) {
            this.t = false;
            ActionBarOverlayLayout actionBarOverlayLayout = this.f1355c;
            if (actionBarOverlayLayout != null) {
                actionBarOverlayLayout.setShowingForActionMode(false);
            }
            m(false);
        }
    }

    public final boolean o() {
        return u.x(this.f1356d);
    }

    public final void p() {
        if (this.t) {
            return;
        }
        this.t = true;
        ActionBarOverlayLayout actionBarOverlayLayout = this.f1355c;
        if (actionBarOverlayLayout != null) {
            actionBarOverlayLayout.setShowingForActionMode(true);
        }
        m(false);
    }

    @Override // android.support.v7.widget.ActionBarOverlayLayout.d
    public void d() {
        if (this.s) {
            return;
        }
        this.s = true;
        m(true);
    }

    public void g(boolean z) {
        View view;
        int[] iArr;
        a.b.h.j.h hVar = this.v;
        if (hVar != null) {
            hVar.a();
        }
        if (this.p == 0 && (this.w || z)) {
            this.f1356d.setAlpha(1.0f);
            this.f1356d.setTransitioning(true);
            a.b.h.j.h hVar2 = new a.b.h.j.h();
            float f2 = -this.f1356d.getHeight();
            if (z) {
                this.f1356d.getLocationInWindow(new int[]{0, 0});
                f2 -= iArr[1];
            }
            z a2 = u.a(this.f1356d);
            a2.b(f2);
            a2.a(this.A);
            hVar2.a(a2);
            if (this.q && (view = this.f1359g) != null) {
                z a3 = u.a(view);
                a3.b(f2);
                hVar2.a(a3);
            }
            hVar2.a(B);
            hVar2.a(250L);
            hVar2.a(this.y);
            this.v = hVar2;
            hVar2.c();
            return;
        }
        this.y.b(null);
    }

    public final void m(boolean z) {
        if (a(this.r, this.s, this.t)) {
            if (this.u) {
                return;
            }
            this.u = true;
            h(z);
        } else if (this.u) {
            this.u = false;
            g(z);
        }
    }

    public void l(boolean z) {
        this.f1357e.a(z);
    }

    public void a(float f2) {
        u.a(this.f1356d, f2);
    }

    @Override // a.b.h.a.a
    public void a(Configuration configuration) {
        j(a.b.h.j.a.a(this.f1353a).f());
    }

    @Override // android.support.v7.widget.ActionBarOverlayLayout.d
    public void a(int i2) {
        this.p = i2;
    }

    @Override // a.b.h.a.a
    public void a(CharSequence charSequence) {
        this.f1357e.setWindowTitle(charSequence);
    }

    public void a(int i2, int i3) {
        int k = this.f1357e.k();
        if ((i3 & 4) != 0) {
            this.f1361i = true;
        }
        this.f1357e.b((i2 & i3) | ((~i3) & k));
    }

    public m(Dialog dialog) {
        new ArrayList();
        this.n = new ArrayList<>();
        this.p = 0;
        this.q = true;
        this.u = true;
        this.y = new a();
        this.z = new b();
        this.A = new c();
        b(dialog.getWindow().getDecorView());
    }

    @Override // a.b.h.a.a
    public a.b.h.j.b a(b.a aVar) {
        d dVar = this.j;
        if (dVar != null) {
            dVar.a();
        }
        this.f1355c.setHideOnContentScrollEnabled(false);
        this.f1358f.d();
        d dVar2 = new d(this.f1358f.getContext(), aVar);
        if (dVar2.k()) {
            this.j = dVar2;
            dVar2.i();
            this.f1358f.a(dVar2);
            f(true);
            this.f1358f.sendAccessibilityEvent(32);
            return dVar2;
        }
        return null;
    }

    @Override // a.b.h.a.a
    public boolean f() {
        i0 i0Var = this.f1357e;
        if (i0Var == null || !i0Var.j()) {
            return false;
        }
        this.f1357e.collapseActionView();
        return true;
    }

    @Override // a.b.h.a.a
    public void b(boolean z) {
        if (z == this.m) {
            return;
        }
        this.m = z;
        int size = this.n.size();
        for (int i2 = 0; i2 < size; i2++) {
            this.n.get(i2).a(z);
        }
    }

    @Override // android.support.v7.widget.ActionBarOverlayLayout.d
    public void a(boolean z) {
        this.q = z;
    }

    @Override // android.support.v7.widget.ActionBarOverlayLayout.d
    public void b() {
        a.b.h.j.h hVar = this.v;
        if (hVar != null) {
            hVar.a();
            this.v = null;
        }
    }

    @Override // android.support.v7.widget.ActionBarOverlayLayout.d
    public void a() {
        if (this.s) {
            this.s = false;
            m(true);
        }
    }

    @Override // a.b.h.a.a
    public boolean a(int i2, KeyEvent keyEvent) {
        Menu c2;
        d dVar = this.j;
        if (dVar == null || (c2 = dVar.c()) == null) {
            return false;
        }
        c2.setQwertyMode(KeyCharacterMap.load(keyEvent != null ? keyEvent.getDeviceId() : -1).getKeyboardType() != 1);
        return c2.performShortcut(i2, keyEvent, 0);
    }

    @Override // a.b.h.a.a
    public Context h() {
        if (this.f1354b == null) {
            TypedValue typedValue = new TypedValue();
            this.f1353a.getTheme().resolveAttribute(a.b.h.b.a.actionBarWidgetTheme, typedValue, true);
            int i2 = typedValue.resourceId;
            if (i2 != 0) {
                this.f1354b = new ContextThemeWrapper(this.f1353a, i2);
            } else {
                this.f1354b = this.f1353a;
            }
        }
        return this.f1354b;
    }
}
