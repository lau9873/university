package a.b.h.a;

import a.b.g.a.h0;
import a.b.g.a.w;
import a.b.h.j.b;
import a.b.h.k.q1;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
/* compiled from: AppCompatActivity.java */
/* loaded from: classes.dex */
public class d extends a.b.g.a.g implements e, h0.a, b {
    public f n;
    public int o = 0;
    public Resources p;

    @Override // a.b.h.a.e
    public a.b.h.j.b a(b.a aVar) {
        return null;
    }

    @Override // a.b.h.a.e
    public void a(a.b.h.j.b bVar) {
    }

    public void a(Toolbar toolbar) {
        k().a(toolbar);
    }

    @Override // android.app.Activity
    public void addContentView(View view, ViewGroup.LayoutParams layoutParams) {
        k().a(view, layoutParams);
    }

    public void b(h0 h0Var) {
    }

    @Override // a.b.h.a.e
    public void b(a.b.h.j.b bVar) {
    }

    public boolean b(Intent intent) {
        return w.b(this, intent);
    }

    @Override // android.app.Activity
    public void closeOptionsMenu() {
        a l = l();
        if (getWindow().hasFeature(0)) {
            if (l == null || !l.e()) {
                super.closeOptionsMenu();
            }
        }
    }

    @Override // a.b.g.a.g0, android.app.Activity, android.view.Window.Callback
    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        int keyCode = keyEvent.getKeyCode();
        a l = l();
        if (keyCode == 82 && l != null && l.a(keyEvent)) {
            return true;
        }
        return super.dispatchKeyEvent(keyEvent);
    }

    @Override // a.b.g.a.h0.a
    public Intent e() {
        return w.a(this);
    }

    @Override // android.app.Activity
    public <T extends View> T findViewById(int i2) {
        return (T) k().a(i2);
    }

    @Override // android.app.Activity
    public MenuInflater getMenuInflater() {
        return k().b();
    }

    @Override // android.view.ContextThemeWrapper, android.content.ContextWrapper, android.content.Context
    public Resources getResources() {
        if (this.p == null && q1.b()) {
            this.p = new q1(this, super.getResources());
        }
        Resources resources = this.p;
        return resources == null ? super.getResources() : resources;
    }

    @Override // android.app.Activity
    public void invalidateOptionsMenu() {
        k().e();
    }

    @Override // a.b.g.a.g
    public void j() {
        k().e();
    }

    public f k() {
        if (this.n == null) {
            this.n = f.a(this, this);
        }
        return this.n;
    }

    public a l() {
        return k().c();
    }

    @Deprecated
    public void m() {
    }

    public boolean n() {
        Intent e2 = e();
        if (e2 != null) {
            if (b(e2)) {
                h0 a2 = h0.a((Context) this);
                a(a2);
                b(a2);
                a2.a();
                try {
                    a.b.g.a.a.a((Activity) this);
                    return true;
                } catch (IllegalStateException unused) {
                    finish();
                    return true;
                }
            }
            a(e2);
            return true;
        }
        return false;
    }

    @Override // a.b.g.a.g, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        k().a(configuration);
        if (this.p != null) {
            this.p.updateConfiguration(configuration, super.getResources().getDisplayMetrics());
        }
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public void onContentChanged() {
        m();
    }

    @Override // a.b.g.a.g, a.b.g.a.g0, android.app.Activity
    public void onCreate(Bundle bundle) {
        int i2;
        f k = k();
        k.d();
        k.a(bundle);
        if (k.a() && (i2 = this.o) != 0) {
            if (Build.VERSION.SDK_INT >= 23) {
                onApplyThemeResource(getTheme(), this.o, false);
            } else {
                setTheme(i2);
            }
        }
        super.onCreate(bundle);
    }

    @Override // a.b.g.a.g, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        k().f();
    }

    @Override // android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i2, KeyEvent keyEvent) {
        if (a(i2, keyEvent)) {
            return true;
        }
        return super.onKeyDown(i2, keyEvent);
    }

    @Override // a.b.g.a.g, android.app.Activity, android.view.Window.Callback
    public final boolean onMenuItemSelected(int i2, MenuItem menuItem) {
        if (super.onMenuItemSelected(i2, menuItem)) {
            return true;
        }
        a l = l();
        if (menuItem.getItemId() != 16908332 || l == null || (l.g() & 4) == 0) {
            return false;
        }
        return n();
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean onMenuOpened(int i2, Menu menu) {
        return super.onMenuOpened(i2, menu);
    }

    @Override // a.b.g.a.g, android.app.Activity, android.view.Window.Callback
    public void onPanelClosed(int i2, Menu menu) {
        super.onPanelClosed(i2, menu);
    }

    @Override // android.app.Activity
    public void onPostCreate(Bundle bundle) {
        super.onPostCreate(bundle);
        k().b(bundle);
    }

    @Override // a.b.g.a.g, android.app.Activity
    public void onPostResume() {
        super.onPostResume();
        k().g();
    }

    @Override // a.b.g.a.g, a.b.g.a.g0, android.app.Activity
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        k().c(bundle);
    }

    @Override // a.b.g.a.g, android.app.Activity
    public void onStart() {
        super.onStart();
        k().h();
    }

    @Override // a.b.g.a.g, android.app.Activity
    public void onStop() {
        super.onStop();
        k().i();
    }

    @Override // android.app.Activity
    public void onTitleChanged(CharSequence charSequence, int i2) {
        super.onTitleChanged(charSequence, i2);
        k().a(charSequence);
    }

    @Override // android.app.Activity
    public void openOptionsMenu() {
        a l = l();
        if (getWindow().hasFeature(0)) {
            if (l == null || !l.k()) {
                super.openOptionsMenu();
            }
        }
    }

    @Override // android.app.Activity
    public void setContentView(int i2) {
        k().c(i2);
    }

    @Override // android.app.Activity, android.view.ContextThemeWrapper, android.content.ContextWrapper, android.content.Context
    public void setTheme(int i2) {
        super.setTheme(i2);
        this.o = i2;
    }

    public void a(h0 h0Var) {
        h0Var.a((Activity) this);
    }

    @Override // android.app.Activity
    public void setContentView(View view) {
        k().a(view);
    }

    public void a(Intent intent) {
        w.a(this, intent);
    }

    @Override // android.app.Activity
    public void setContentView(View view, ViewGroup.LayoutParams layoutParams) {
        k().b(view, layoutParams);
    }

    public final boolean a(int i2, KeyEvent keyEvent) {
        Window window;
        return (Build.VERSION.SDK_INT >= 26 || keyEvent.isCtrlPressed() || KeyEvent.metaStateHasNoModifiers(keyEvent.getMetaState()) || keyEvent.getRepeatCount() != 0 || KeyEvent.isModifierKey(keyEvent.getKeyCode()) || (window = getWindow()) == null || window.getDecorView() == null || !window.getDecorView().dispatchKeyShortcutEvent(keyEvent)) ? false : true;
    }
}
