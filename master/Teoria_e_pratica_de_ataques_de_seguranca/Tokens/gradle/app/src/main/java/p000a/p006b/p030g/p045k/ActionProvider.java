package p000a.p006b.p030g.p045k;

import android.content.Context;
import android.util.Log;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;

/* renamed from: a.b.g.k.c */
/* loaded from: classes.dex */
public abstract class ActionProvider {

    /* renamed from: a */
    public InterfaceC0280b f1616a;

    /* compiled from: ActionProvider.java */
    /* renamed from: a.b.g.k.c$a */
    /* loaded from: classes.dex */
    public interface InterfaceC0279a {
    }

    /* compiled from: ActionProvider.java */
    /* renamed from: a.b.g.k.c$b */
    /* loaded from: classes.dex */
    public interface InterfaceC0280b {
        void onActionProviderVisibilityChanged(boolean z);
    }

    public ActionProvider(Context context) {
    }

    /* renamed from: a */
    public View mo8614a(MenuItem menuItem) {
        return mo8619c();
    }

    /* renamed from: a */
    public void m9581a(InterfaceC0279a interfaceC0279a) {
    }

    /* renamed from: a */
    public void mo8620a(SubMenu subMenu) {
    }

    /* renamed from: a */
    public boolean mo8621a() {
        return false;
    }

    /* renamed from: b */
    public boolean mo8613b() {
        return true;
    }

    /* renamed from: c */
    public abstract View mo8619c();

    /* renamed from: d */
    public boolean mo8618d() {
        return false;
    }

    /* renamed from: e */
    public boolean mo8612e() {
        return false;
    }

    /* renamed from: f */
    public void m9580f() {
        this.f1616a = null;
    }

    /* renamed from: a */
    public void mo8615a(InterfaceC0280b interfaceC0280b) {
        if (this.f1616a != null && interfaceC0280b != null) {
            Log.w("ActionProvider(support)", "setVisibilityListener: Setting a new ActionProvider.VisibilityListener when one is already set. Are you reusing this " + getClass().getSimpleName() + " instance while it is still in use somewhere else?");
        }
        this.f1616a = interfaceC0280b;
    }
}
