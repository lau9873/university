package a.b.h.a;

import a.b.g.k.u;
import a.b.h.a.a;
import a.b.h.j.j.h;
import a.b.h.j.j.p;
import a.b.h.k.i0;
import a.b.h.k.m1;
import android.content.Context;
import android.content.res.Configuration;
import android.support.v7.widget.Toolbar;
import android.view.KeyCharacterMap;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import java.util.ArrayList;
/* compiled from: ToolbarActionBar.java */
/* loaded from: classes.dex */
public class j extends a.b.h.a.a {

    /* renamed from: a  reason: collision with root package name */
    public i0 f1325a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f1326b;

    /* renamed from: c  reason: collision with root package name */
    public Window.Callback f1327c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f1328d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f1329e;

    /* renamed from: f  reason: collision with root package name */
    public ArrayList<a.b> f1330f = new ArrayList<>();

    /* renamed from: g  reason: collision with root package name */
    public final Runnable f1331g = new a();

    /* renamed from: h  reason: collision with root package name */
    public final Toolbar.f f1332h = new b();

    /* compiled from: ToolbarActionBar.java */
    /* loaded from: classes.dex */
    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            j.this.n();
        }
    }

    /* compiled from: ToolbarActionBar.java */
    /* loaded from: classes.dex */
    public class b implements Toolbar.f {
        public b() {
        }

        @Override // android.support.v7.widget.Toolbar.f
        public boolean onMenuItemClick(MenuItem menuItem) {
            return j.this.f1327c.onMenuItemSelected(0, menuItem);
        }
    }

    /* compiled from: ToolbarActionBar.java */
    /* loaded from: classes.dex */
    public final class d implements h.a {
        public d() {
        }

        @Override // a.b.h.j.j.h.a
        public void a(a.b.h.j.j.h hVar) {
            j jVar = j.this;
            if (jVar.f1327c != null) {
                if (jVar.f1325a.a()) {
                    j.this.f1327c.onPanelClosed(108, hVar);
                } else if (j.this.f1327c.onPreparePanel(0, null, hVar)) {
                    j.this.f1327c.onMenuOpened(108, hVar);
                }
            }
        }

        @Override // a.b.h.j.j.h.a
        public boolean a(a.b.h.j.j.h hVar, MenuItem menuItem) {
            return false;
        }
    }

    /* compiled from: ToolbarActionBar.java */
    /* loaded from: classes.dex */
    public class e extends a.b.h.j.i {
        public e(Window.Callback callback) {
            super(callback);
        }

        @Override // a.b.h.j.i, android.view.Window.Callback
        public View onCreatePanelView(int i2) {
            if (i2 == 0) {
                return new View(j.this.f1325a.i());
            }
            return super.onCreatePanelView(i2);
        }

        @Override // a.b.h.j.i, android.view.Window.Callback
        public boolean onPreparePanel(int i2, View view, Menu menu) {
            boolean onPreparePanel = super.onPreparePanel(i2, view, menu);
            if (onPreparePanel) {
                j jVar = j.this;
                if (!jVar.f1326b) {
                    jVar.f1325a.b();
                    j.this.f1326b = true;
                }
            }
            return onPreparePanel;
        }
    }

    public j(Toolbar toolbar, CharSequence charSequence, Window.Callback callback) {
        this.f1325a = new m1(toolbar, false);
        this.f1327c = new e(callback);
        this.f1325a.setWindowCallback(this.f1327c);
        toolbar.setOnMenuItemClickListener(this.f1332h);
        this.f1325a.setWindowTitle(charSequence);
    }

    @Override // a.b.h.a.a
    public void a(Configuration configuration) {
        super.a(configuration);
    }

    @Override // a.b.h.a.a
    public void b(boolean z) {
        if (z == this.f1329e) {
            return;
        }
        this.f1329e = z;
        int size = this.f1330f.size();
        for (int i2 = 0; i2 < size; i2++) {
            this.f1330f.get(i2).a(z);
        }
    }

    @Override // a.b.h.a.a
    public void c(boolean z) {
    }

    @Override // a.b.h.a.a
    public void d(boolean z) {
        a(z ? 8 : 0, 8);
    }

    @Override // a.b.h.a.a
    public void e(boolean z) {
    }

    @Override // a.b.h.a.a
    public boolean e() {
        return this.f1325a.d();
    }

    @Override // a.b.h.a.a
    public boolean f() {
        if (this.f1325a.j()) {
            this.f1325a.collapseActionView();
            return true;
        }
        return false;
    }

    @Override // a.b.h.a.a
    public int g() {
        return this.f1325a.k();
    }

    @Override // a.b.h.a.a
    public Context h() {
        return this.f1325a.i();
    }

    @Override // a.b.h.a.a
    public boolean i() {
        this.f1325a.h().removeCallbacks(this.f1331g);
        u.a(this.f1325a.h(), this.f1331g);
        return true;
    }

    @Override // a.b.h.a.a
    public void j() {
        this.f1325a.h().removeCallbacks(this.f1331g);
    }

    @Override // a.b.h.a.a
    public boolean k() {
        return this.f1325a.e();
    }

    public final Menu l() {
        if (!this.f1328d) {
            this.f1325a.a(new c(), new d());
            this.f1328d = true;
        }
        return this.f1325a.l();
    }

    public Window.Callback m() {
        return this.f1327c;
    }

    public void n() {
        Menu l = l();
        a.b.h.j.j.h hVar = l instanceof a.b.h.j.j.h ? (a.b.h.j.j.h) l : null;
        if (hVar != null) {
            hVar.s();
        }
        try {
            l.clear();
            if (!this.f1327c.onCreatePanelMenu(0, l) || !this.f1327c.onPreparePanel(0, null, l)) {
                l.clear();
            }
        } finally {
            if (hVar != null) {
                hVar.r();
            }
        }
    }

    /* compiled from: ToolbarActionBar.java */
    /* loaded from: classes.dex */
    public final class c implements p.a {

        /* renamed from: a  reason: collision with root package name */
        public boolean f1335a;

        public c() {
        }

        @Override // a.b.h.j.j.p.a
        public boolean a(a.b.h.j.j.h hVar) {
            Window.Callback callback = j.this.f1327c;
            if (callback != null) {
                callback.onMenuOpened(108, hVar);
                return true;
            }
            return false;
        }

        @Override // a.b.h.j.j.p.a
        public void a(a.b.h.j.j.h hVar, boolean z) {
            if (this.f1335a) {
                return;
            }
            this.f1335a = true;
            j.this.f1325a.g();
            Window.Callback callback = j.this.f1327c;
            if (callback != null) {
                callback.onPanelClosed(108, hVar);
            }
            this.f1335a = false;
        }
    }

    @Override // a.b.h.a.a
    public void a(CharSequence charSequence) {
        this.f1325a.setWindowTitle(charSequence);
    }

    public void a(int i2, int i3) {
        this.f1325a.b((i2 & i3) | ((~i3) & this.f1325a.k()));
    }

    @Override // a.b.h.a.a
    public boolean a(KeyEvent keyEvent) {
        if (keyEvent.getAction() == 1) {
            k();
        }
        return true;
    }

    @Override // a.b.h.a.a
    public boolean a(int i2, KeyEvent keyEvent) {
        Menu l = l();
        if (l != null) {
            l.setQwertyMode(KeyCharacterMap.load(keyEvent != null ? keyEvent.getDeviceId() : -1).getKeyboardType() != 1);
            return l.performShortcut(i2, keyEvent, 0);
        }
        return false;
    }
}
