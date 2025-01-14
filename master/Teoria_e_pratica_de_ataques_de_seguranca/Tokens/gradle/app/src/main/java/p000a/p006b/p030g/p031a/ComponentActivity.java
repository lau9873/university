package p000a.p006b.p030g.p031a;

import android.app.Activity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import p000a.p001a.p005b.Lifecycle;
import p000a.p001a.p005b.LifecycleOwner;
import p000a.p001a.p005b.LifecycleRegistry;
import p000a.p001a.p005b.ReportFragment;
import p000a.p006b.p030g.p044j.SimpleArrayMap;
import p000a.p006b.p030g.p045k.KeyEventDispatcher;

/* renamed from: a.b.g.a.g0 */
/* loaded from: classes.dex */
public class ComponentActivity extends Activity implements LifecycleOwner, KeyEventDispatcher.InterfaceC0281a {

    /* renamed from: a */
    public LifecycleRegistry f1122a;

    public ComponentActivity() {
        new SimpleArrayMap();
        this.f1122a = new LifecycleRegistry(this);
    }

    /* renamed from: a */
    public Lifecycle mo7439a() {
        return this.f1122a;
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        View decorView = getWindow().getDecorView();
        if (decorView == null || !KeyEventDispatcher.m9564a(decorView, keyEvent)) {
            return KeyEventDispatcher.m9569a(this, decorView, this, keyEvent);
        }
        return true;
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean dispatchKeyShortcutEvent(KeyEvent keyEvent) {
        View decorView = getWindow().getDecorView();
        if (decorView == null || !KeyEventDispatcher.m9564a(decorView, keyEvent)) {
            return super.dispatchKeyShortcutEvent(keyEvent);
        }
        return true;
    }

    @Override // android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        ReportFragment.m11270a(this);
    }

    @Override // android.app.Activity
    public void onSaveInstanceState(Bundle bundle) {
        this.f1122a.m11296a(Lifecycle.EnumC0012b.CREATED);
        super.onSaveInstanceState(bundle);
    }

    @Override // p000a.p006b.p030g.p045k.KeyEventDispatcher.InterfaceC0281a
    /* renamed from: a */
    public boolean mo9025a(KeyEvent keyEvent) {
        return super.dispatchKeyEvent(keyEvent);
    }
}
