package p000a.p006b.p049h.p061j;

import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;

/* renamed from: a.b.h.j.b */
/* loaded from: classes.dex */
public abstract class ActionMode {

    /* renamed from: a */
    public Object f2227a;

    /* renamed from: b */
    public boolean f2228b;

    /* compiled from: ActionMode.java */
    /* renamed from: a.b.h.j.b$a */
    /* loaded from: classes.dex */
    public interface InterfaceC0414a {
        /* renamed from: a */
        void mo8753a(ActionMode actionMode);

        /* renamed from: a */
        boolean mo8752a(ActionMode actionMode, Menu menu);

        /* renamed from: a */
        boolean mo8751a(ActionMode actionMode, MenuItem menuItem);

        /* renamed from: b */
        boolean mo8748b(ActionMode actionMode, Menu menu);
    }

    /* renamed from: a */
    public abstract void mo8767a();

    /* renamed from: a */
    public abstract void mo8766a(int i);

    /* renamed from: a */
    public abstract void mo8765a(View view);

    /* renamed from: a */
    public abstract void mo8764a(CharSequence charSequence);

    /* renamed from: a */
    public void m8774a(Object obj) {
        this.f2227a = obj;
    }

    /* renamed from: b */
    public abstract View mo8762b();

    /* renamed from: b */
    public abstract void mo8761b(int i);

    /* renamed from: b */
    public abstract void mo8760b(CharSequence charSequence);

    /* renamed from: c */
    public abstract Menu mo8759c();

    /* renamed from: d */
    public abstract MenuInflater mo8758d();

    /* renamed from: e */
    public abstract CharSequence mo8757e();

    /* renamed from: f */
    public Object m8773f() {
        return this.f2227a;
    }

    /* renamed from: g */
    public abstract CharSequence mo8756g();

    /* renamed from: h */
    public boolean m8772h() {
        return this.f2228b;
    }

    /* renamed from: i */
    public abstract void mo8755i();

    /* renamed from: j */
    public abstract boolean mo8754j();

    /* renamed from: a */
    public void mo8763a(boolean z) {
        this.f2228b = z;
    }
}
