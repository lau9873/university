package p000a.p006b.p049h.p050a;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Build;
import android.os.Bundle;
import android.support.p067v7.widget.Toolbar;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import p000a.p006b.p030g.p031a.ActivityCompat;
import p000a.p006b.p030g.p031a.FragmentActivity;
import p000a.p006b.p030g.p031a.NavUtils;
import p000a.p006b.p030g.p031a.TaskStackBuilder;
import p000a.p006b.p049h.p061j.ActionMode;
import p000a.p006b.p049h.p063k.VectorEnabledTintResources;

/* renamed from: a.b.h.a.d */
/* loaded from: classes.dex */
public class AppCompatActivity extends FragmentActivity implements AppCompatCallback, TaskStackBuilder.InterfaceC0148a, ActionBarDrawerToggle {

    /* renamed from: n */
    public AppCompatDelegate f1876n;

    /* renamed from: o */
    public int f1877o = 0;

    /* renamed from: p */
    public Resources f1878p;

    @Override // p000a.p006b.p049h.p050a.AppCompatCallback
    /* renamed from: a */
    public ActionMode mo9030a(ActionMode.InterfaceC0414a interfaceC0414a) {
        return null;
    }

    @Override // p000a.p006b.p049h.p050a.AppCompatCallback
    /* renamed from: a */
    public void mo9029a(ActionMode actionMode) {
    }

    /* renamed from: a */
    public void m9125a(Toolbar toolbar) {
        m9120k().mo9099a(toolbar);
    }

    @Override // android.app.Activity
    public void addContentView(View view, ViewGroup.LayoutParams layoutParams) {
        m9120k().mo9095a(view, layoutParams);
    }

    /* renamed from: b */
    public void m9124b(TaskStackBuilder taskStackBuilder) {
    }

    @Override // p000a.p006b.p049h.p050a.AppCompatCallback
    /* renamed from: b */
    public void mo9026b(ActionMode actionMode) {
    }

    /* renamed from: b */
    public boolean m9123b(Intent intent) {
        return NavUtils.m10071b(this, intent);
    }

    @Override // android.app.Activity
    public void closeOptionsMenu() {
        ActionBar m9119l = m9119l();
        if (getWindow().hasFeature(0)) {
            if (m9119l == null || !m9119l.mo9017e()) {
                super.closeOptionsMenu();
            }
        }
    }

    @Override // p000a.p006b.p030g.p031a.ComponentActivity, android.app.Activity, android.view.Window.Callback
    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        int keyCode = keyEvent.getKeyCode();
        ActionBar m9119l = m9119l();
        if (keyCode == 82 && m9119l != null && m9119l.mo9018a(keyEvent)) {
            return true;
        }
        return super.dispatchKeyEvent(keyEvent);
    }

    @Override // p000a.p006b.p030g.p031a.TaskStackBuilder.InterfaceC0148a
    /* renamed from: e */
    public Intent mo9122e() {
        return NavUtils.m10075a(this);
    }

    @Override // android.app.Activity
    public <T extends View> T findViewById(int i) {
        return (T) m9120k().mo9111a(i);
    }

    @Override // android.app.Activity
    public MenuInflater getMenuInflater() {
        return m9120k().mo9090b();
    }

    @Override // android.view.ContextThemeWrapper, android.content.ContextWrapper, android.content.Context
    public Resources getResources() {
        if (this.f1878p == null && VectorEnabledTintResources.m8129b()) {
            this.f1878p = new VectorEnabledTintResources(this, super.getResources());
        }
        Resources resources = this.f1878p;
        return resources == null ? super.getResources() : resources;
    }

    @Override // android.app.Activity
    public void invalidateOptionsMenu() {
        m9120k().mo9073e();
    }

    @Override // p000a.p006b.p030g.p031a.FragmentActivity
    /* renamed from: j */
    public void mo9121j() {
        m9120k().mo9073e();
    }

    /* renamed from: k */
    public AppCompatDelegate m9120k() {
        if (this.f1876n == null) {
            this.f1876n = AppCompatDelegate.m9116a(this, this);
        }
        return this.f1876n;
    }

    /* renamed from: l */
    public ActionBar m9119l() {
        return m9120k().mo9081c();
    }

    @Deprecated
    /* renamed from: m */
    public void m9118m() {
    }

    /* renamed from: n */
    public boolean m9117n() {
        Intent mo9122e = mo9122e();
        if (mo9122e != null) {
            if (m9123b(mo9122e)) {
                TaskStackBuilder m10326a = TaskStackBuilder.m10326a((Context) this);
                m9127a(m10326a);
                m9124b(m10326a);
                m10326a.m10329a();
                try {
                    ActivityCompat.m10416a((Activity) this);
                    return true;
                } catch (IllegalStateException unused) {
                    finish();
                    return true;
                }
            }
            m9126a(mo9122e);
            return true;
        }
        return false;
    }

    @Override // p000a.p006b.p030g.p031a.FragmentActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        m9120k().mo9101a(configuration);
        if (this.f1878p != null) {
            this.f1878p.updateConfiguration(configuration, super.getResources().getDisplayMetrics());
        }
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public void onContentChanged() {
        m9118m();
    }

    @Override // p000a.p006b.p030g.p031a.FragmentActivity, p000a.p006b.p030g.p031a.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        int i;
        AppCompatDelegate m9120k = m9120k();
        m9120k.mo9076d();
        m9120k.mo9100a(bundle);
        if (m9120k.mo9112a() && (i = this.f1877o) != 0) {
            if (Build.VERSION.SDK_INT >= 23) {
                onApplyThemeResource(getTheme(), this.f1877o, false);
            } else {
                setTheme(i);
            }
        }
        super.onCreate(bundle);
    }

    @Override // p000a.p006b.p030g.p031a.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        m9120k().mo9070f();
    }

    @Override // android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (m9128a(i, keyEvent)) {
            return true;
        }
        return super.onKeyDown(i, keyEvent);
    }

    @Override // p000a.p006b.p030g.p031a.FragmentActivity, android.app.Activity, android.view.Window.Callback
    public final boolean onMenuItemSelected(int i, MenuItem menuItem) {
        if (super.onMenuItemSelected(i, menuItem)) {
            return true;
        }
        ActionBar m9119l = m9119l();
        if (menuItem.getItemId() != 16908332 || m9119l == null || (m9119l.mo8987g() & 4) == 0) {
            return false;
        }
        return m9117n();
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean onMenuOpened(int i, Menu menu) {
        return super.onMenuOpened(i, menu);
    }

    @Override // p000a.p006b.p030g.p031a.FragmentActivity, android.app.Activity, android.view.Window.Callback
    public void onPanelClosed(int i, Menu menu) {
        super.onPanelClosed(i, menu);
    }

    @Override // android.app.Activity
    public void onPostCreate(Bundle bundle) {
        super.onPostCreate(bundle);
        m9120k().mo9083b(bundle);
    }

    @Override // p000a.p006b.p030g.p031a.FragmentActivity, android.app.Activity
    public void onPostResume() {
        super.onPostResume();
        m9120k().mo9068g();
    }

    @Override // p000a.p006b.p030g.p031a.FragmentActivity, p000a.p006b.p030g.p031a.ComponentActivity, android.app.Activity
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        m9120k().mo9077c(bundle);
    }

    @Override // p000a.p006b.p030g.p031a.FragmentActivity, android.app.Activity
    public void onStart() {
        super.onStart();
        m9120k().mo9066h();
    }

    @Override // p000a.p006b.p030g.p031a.FragmentActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        m9120k().mo9064i();
    }

    @Override // android.app.Activity
    public void onTitleChanged(CharSequence charSequence, int i) {
        super.onTitleChanged(charSequence, i);
        m9120k().mo9091a(charSequence);
    }

    @Override // android.app.Activity
    public void openOptionsMenu() {
        ActionBar m9119l = m9119l();
        if (getWindow().hasFeature(0)) {
            if (m9119l == null || !m9119l.mo9014k()) {
                super.openOptionsMenu();
            }
        }
    }

    @Override // android.app.Activity
    public void setContentView(int i) {
        m9120k().mo9080c(i);
    }

    @Override // android.app.Activity, android.view.ContextThemeWrapper, android.content.ContextWrapper, android.content.Context
    public void setTheme(int i) {
        super.setTheme(i);
        this.f1877o = i;
    }

    /* renamed from: a */
    public void m9127a(TaskStackBuilder taskStackBuilder) {
        taskStackBuilder.m10328a((Activity) this);
    }

    @Override // android.app.Activity
    public void setContentView(View view) {
        m9120k().mo9096a(view);
    }

    /* renamed from: a */
    public void m9126a(Intent intent) {
        NavUtils.m10074a(this, intent);
    }

    @Override // android.app.Activity
    public void setContentView(View view, ViewGroup.LayoutParams layoutParams) {
        m9120k().mo9082b(view, layoutParams);
    }

    /* renamed from: a */
    public final boolean m9128a(int i, KeyEvent keyEvent) {
        Window window;
        return (Build.VERSION.SDK_INT >= 26 || keyEvent.isCtrlPressed() || KeyEvent.metaStateHasNoModifiers(keyEvent.getMetaState()) || keyEvent.getRepeatCount() != 0 || KeyEvent.isModifierKey(keyEvent.getKeyCode()) || (window = getWindow()) == null || window.getDecorView() == null || !window.getDecorView().dispatchKeyShortcutEvent(keyEvent)) ? false : true;
    }
}
