package p000a.p006b.p049h.p050a;

import android.content.Context;
import android.content.res.Configuration;
import android.support.p067v7.widget.Toolbar;
import android.view.KeyCharacterMap;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import java.util.ArrayList;
import p000a.p006b.p030g.p045k.ViewCompat;
import p000a.p006b.p049h.p050a.ActionBar;
import p000a.p006b.p049h.p061j.WindowCallbackWrapper;
import p000a.p006b.p049h.p061j.p062j.MenuBuilder;
import p000a.p006b.p049h.p061j.p062j.MenuPresenter;
import p000a.p006b.p049h.p063k.DecorToolbar;
import p000a.p006b.p049h.p063k.ToolbarWidgetWrapper;

/* renamed from: a.b.h.a.j */
/* loaded from: classes.dex */
public class ToolbarActionBar extends ActionBar {

    /* renamed from: a */
    public DecorToolbar f1977a;

    /* renamed from: b */
    public boolean f1978b;

    /* renamed from: c */
    public Window.Callback f1979c;

    /* renamed from: d */
    public boolean f1980d;

    /* renamed from: e */
    public boolean f1981e;

    /* renamed from: f */
    public ArrayList<ActionBar.InterfaceC0323b> f1982f = new ArrayList<>();

    /* renamed from: g */
    public final Runnable f1983g = new RunnableC0344a();

    /* renamed from: h */
    public final Toolbar.InterfaceC0774f f1984h = new C0345b();

    /* compiled from: ToolbarActionBar.java */
    /* renamed from: a.b.h.a.j$a */
    /* loaded from: classes.dex */
    public class RunnableC0344a implements Runnable {
        public RunnableC0344a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            ToolbarActionBar.this.m9011n();
        }
    }

    /* compiled from: ToolbarActionBar.java */
    /* renamed from: a.b.h.a.j$b */
    /* loaded from: classes.dex */
    public class C0345b implements Toolbar.InterfaceC0774f {
        public C0345b() {
        }

        @Override // android.support.p067v7.widget.Toolbar.InterfaceC0774f
        public boolean onMenuItemClick(MenuItem menuItem) {
            return ToolbarActionBar.this.f1979c.onMenuItemSelected(0, menuItem);
        }
    }

    /* compiled from: ToolbarActionBar.java */
    /* renamed from: a.b.h.a.j$d */
    /* loaded from: classes.dex */
    public final class C0347d implements MenuBuilder.InterfaceC0425a {
        public C0347d() {
        }

        @Override // p000a.p006b.p049h.p061j.p062j.MenuBuilder.InterfaceC0425a
        /* renamed from: a */
        public void mo7078a(MenuBuilder menuBuilder) {
            ToolbarActionBar toolbarActionBar = ToolbarActionBar.this;
            if (toolbarActionBar.f1979c != null) {
                if (toolbarActionBar.f1977a.mo8222a()) {
                    ToolbarActionBar.this.f1979c.onPanelClosed(108, menuBuilder);
                } else if (ToolbarActionBar.this.f1979c.onPreparePanel(0, null, menuBuilder)) {
                    ToolbarActionBar.this.f1979c.onMenuOpened(108, menuBuilder);
                }
            }
        }

        @Override // p000a.p006b.p049h.p061j.p062j.MenuBuilder.InterfaceC0425a
        /* renamed from: a */
        public boolean mo7077a(MenuBuilder menuBuilder, MenuItem menuItem) {
            return false;
        }
    }

    /* compiled from: ToolbarActionBar.java */
    /* renamed from: a.b.h.a.j$e */
    /* loaded from: classes.dex */
    public class C0348e extends WindowCallbackWrapper {
        public C0348e(Window.Callback callback) {
            super(callback);
        }

        @Override // p000a.p006b.p049h.p061j.WindowCallbackWrapper, android.view.Window.Callback
        public View onCreatePanelView(int i) {
            if (i == 0) {
                return new View(ToolbarActionBar.this.f1977a.mo8196i());
            }
            return super.onCreatePanelView(i);
        }

        @Override // p000a.p006b.p049h.p061j.WindowCallbackWrapper, android.view.Window.Callback
        public boolean onPreparePanel(int i, View view, Menu menu) {
            boolean onPreparePanel = super.onPreparePanel(i, view, menu);
            if (onPreparePanel) {
                ToolbarActionBar toolbarActionBar = ToolbarActionBar.this;
                if (!toolbarActionBar.f1978b) {
                    toolbarActionBar.f1977a.mo8212b();
                    ToolbarActionBar.this.f1978b = true;
                }
            }
            return onPreparePanel;
        }
    }

    public ToolbarActionBar(Toolbar toolbar, CharSequence charSequence, Window.Callback callback) {
        this.f1977a = new ToolbarWidgetWrapper(toolbar, false);
        this.f1979c = new C0348e(callback);
        this.f1977a.setWindowCallback(this.f1979c);
        toolbar.setOnMenuItemClickListener(this.f1984h);
        this.f1977a.setWindowTitle(charSequence);
    }

    @Override // p000a.p006b.p049h.p050a.ActionBar
    /* renamed from: a */
    public void mo8998a(Configuration configuration) {
        super.mo8998a(configuration);
    }

    @Override // p000a.p006b.p049h.p050a.ActionBar
    /* renamed from: b */
    public void mo8993b(boolean z) {
        if (z == this.f1981e) {
            return;
        }
        this.f1981e = z;
        int size = this.f1982f.size();
        for (int i = 0; i < size; i++) {
            this.f1982f.get(i).m9155a(z);
        }
    }

    @Override // p000a.p006b.p049h.p050a.ActionBar
    /* renamed from: c */
    public void mo8992c(boolean z) {
    }

    @Override // p000a.p006b.p049h.p050a.ActionBar
    /* renamed from: d */
    public void mo8991d(boolean z) {
        m9019a(z ? 8 : 0, 8);
    }

    @Override // p000a.p006b.p049h.p050a.ActionBar
    /* renamed from: e */
    public void mo8990e(boolean z) {
    }

    @Override // p000a.p006b.p049h.p050a.ActionBar
    /* renamed from: e */
    public boolean mo9017e() {
        return this.f1977a.mo8204d();
    }

    @Override // p000a.p006b.p049h.p050a.ActionBar
    /* renamed from: f */
    public boolean mo8989f() {
        if (this.f1977a.mo8195j()) {
            this.f1977a.collapseActionView();
            return true;
        }
        return false;
    }

    @Override // p000a.p006b.p049h.p050a.ActionBar
    /* renamed from: g */
    public int mo8987g() {
        return this.f1977a.mo8194k();
    }

    @Override // p000a.p006b.p049h.p050a.ActionBar
    /* renamed from: h */
    public Context mo8985h() {
        return this.f1977a.mo8196i();
    }

    @Override // p000a.p006b.p049h.p050a.ActionBar
    /* renamed from: i */
    public boolean mo9016i() {
        this.f1977a.mo8197h().removeCallbacks(this.f1983g);
        ViewCompat.m9445a(this.f1977a.mo8197h(), this.f1983g);
        return true;
    }

    @Override // p000a.p006b.p049h.p050a.ActionBar
    /* renamed from: j */
    public void mo9015j() {
        this.f1977a.mo8197h().removeCallbacks(this.f1983g);
    }

    @Override // p000a.p006b.p049h.p050a.ActionBar
    /* renamed from: k */
    public boolean mo9014k() {
        return this.f1977a.mo8201e();
    }

    /* renamed from: l */
    public final Menu m9013l() {
        if (!this.f1980d) {
            this.f1977a.mo8219a(new C0346c(), new C0347d());
            this.f1980d = true;
        }
        return this.f1977a.mo8193l();
    }

    /* renamed from: m */
    public Window.Callback m9012m() {
        return this.f1979c;
    }

    /* renamed from: n */
    public void m9011n() {
        Menu m9013l = m9013l();
        MenuBuilder menuBuilder = m9013l instanceof MenuBuilder ? (MenuBuilder) m9013l : null;
        if (menuBuilder != null) {
            menuBuilder.m8650s();
        }
        try {
            m9013l.clear();
            if (!this.f1979c.onCreatePanelMenu(0, m9013l) || !this.f1979c.onPreparePanel(0, null, m9013l)) {
                m9013l.clear();
            }
        } finally {
            if (menuBuilder != null) {
                menuBuilder.m8651r();
            }
        }
    }

    /* compiled from: ToolbarActionBar.java */
    /* renamed from: a.b.h.a.j$c */
    /* loaded from: classes.dex */
    public final class C0346c implements MenuPresenter.InterfaceC0434a {

        /* renamed from: a */
        public boolean f1987a;

        public C0346c() {
        }

        @Override // p000a.p006b.p049h.p061j.p062j.MenuPresenter.InterfaceC0434a
        /* renamed from: a */
        public boolean mo7080a(MenuBuilder menuBuilder) {
            Window.Callback callback = ToolbarActionBar.this.f1979c;
            if (callback != null) {
                callback.onMenuOpened(108, menuBuilder);
                return true;
            }
            return false;
        }

        @Override // p000a.p006b.p049h.p061j.p062j.MenuPresenter.InterfaceC0434a
        /* renamed from: a */
        public void mo7079a(MenuBuilder menuBuilder, boolean z) {
            if (this.f1987a) {
                return;
            }
            this.f1987a = true;
            ToolbarActionBar.this.f1977a.mo8198g();
            Window.Callback callback = ToolbarActionBar.this.f1979c;
            if (callback != null) {
                callback.onPanelClosed(108, menuBuilder);
            }
            this.f1987a = false;
        }
    }

    @Override // p000a.p006b.p049h.p050a.ActionBar
    /* renamed from: a */
    public void mo8996a(CharSequence charSequence) {
        this.f1977a.setWindowTitle(charSequence);
    }

    /* renamed from: a */
    public void m9019a(int i, int i2) {
        this.f1977a.mo8211b((i & i2) | ((~i2) & this.f1977a.mo8194k()));
    }

    @Override // p000a.p006b.p049h.p050a.ActionBar
    /* renamed from: a */
    public boolean mo9018a(KeyEvent keyEvent) {
        if (keyEvent.getAction() == 1) {
            mo9014k();
        }
        return true;
    }

    @Override // p000a.p006b.p049h.p050a.ActionBar
    /* renamed from: a */
    public boolean mo9000a(int i, KeyEvent keyEvent) {
        Menu m9013l = m9013l();
        if (m9013l != null) {
            m9013l.setQwertyMode(KeyCharacterMap.load(keyEvent != null ? keyEvent.getDeviceId() : -1).getKeyboardType() != 1);
            return m9013l.performShortcut(i, keyEvent, 0);
        }
        return false;
    }
}
