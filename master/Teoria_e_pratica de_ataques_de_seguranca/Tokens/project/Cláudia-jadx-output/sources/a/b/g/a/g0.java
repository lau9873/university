package a.b.g.a;

import a.a.b.c;
import a.b.g.k.e;
import android.app.Activity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
/* compiled from: ComponentActivity.java */
/* loaded from: classes.dex */
public class g0 extends Activity implements a.a.b.e, e.a {

    /* renamed from: a  reason: collision with root package name */
    public a.a.b.f f682a;

    public g0() {
        new a.b.g.j.n();
        this.f682a = new a.a.b.f(this);
    }

    public a.a.b.c a() {
        return this.f682a;
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        View decorView = getWindow().getDecorView();
        if (decorView == null || !a.b.g.k.e.a(decorView, keyEvent)) {
            return a.b.g.k.e.a(this, decorView, this, keyEvent);
        }
        return true;
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean dispatchKeyShortcutEvent(KeyEvent keyEvent) {
        View decorView = getWindow().getDecorView();
        if (decorView == null || !a.b.g.k.e.a(decorView, keyEvent)) {
            return super.dispatchKeyShortcutEvent(keyEvent);
        }
        return true;
    }

    @Override // android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        a.a.b.m.a(this);
    }

    @Override // android.app.Activity
    public void onSaveInstanceState(Bundle bundle) {
        this.f682a.a(c.b.CREATED);
        super.onSaveInstanceState(bundle);
    }

    @Override // a.b.g.k.e.a
    public boolean a(KeyEvent keyEvent) {
        return super.dispatchKeyEvent(keyEvent);
    }
}
