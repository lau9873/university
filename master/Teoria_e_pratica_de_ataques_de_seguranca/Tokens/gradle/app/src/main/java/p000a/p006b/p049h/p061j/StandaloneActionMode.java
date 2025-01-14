package p000a.p006b.p049h.p061j;

import android.content.Context;
import android.support.p067v7.widget.ActionBarContextView;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import java.lang.ref.WeakReference;
import p000a.p006b.p049h.p061j.ActionMode;
import p000a.p006b.p049h.p061j.p062j.MenuBuilder;

/* renamed from: a.b.h.j.e */
/* loaded from: classes.dex */
public class StandaloneActionMode extends ActionMode implements MenuBuilder.InterfaceC0425a {

    /* renamed from: c */
    public Context f2234c;

    /* renamed from: d */
    public ActionBarContextView f2235d;

    /* renamed from: e */
    public ActionMode.InterfaceC0414a f2236e;

    /* renamed from: f */
    public WeakReference<View> f2237f;

    /* renamed from: g */
    public boolean f2238g;

    /* renamed from: h */
    public MenuBuilder f2239h;

    public StandaloneActionMode(Context context, ActionBarContextView actionBarContextView, ActionMode.InterfaceC0414a interfaceC0414a, boolean z) {
        this.f2234c = context;
        this.f2235d = actionBarContextView;
        this.f2236e = interfaceC0414a;
        MenuBuilder menuBuilder = new MenuBuilder(actionBarContextView.getContext());
        menuBuilder.m8673c(1);
        this.f2239h = menuBuilder;
        this.f2239h.mo8579a(this);
    }

    @Override // p000a.p006b.p049h.p061j.ActionMode
    /* renamed from: a */
    public void mo8764a(CharSequence charSequence) {
        this.f2235d.setSubtitle(charSequence);
    }

    @Override // p000a.p006b.p049h.p061j.ActionMode
    /* renamed from: b */
    public void mo8760b(CharSequence charSequence) {
        this.f2235d.setTitle(charSequence);
    }

    @Override // p000a.p006b.p049h.p061j.ActionMode
    /* renamed from: c */
    public Menu mo8759c() {
        return this.f2239h;
    }

    @Override // p000a.p006b.p049h.p061j.ActionMode
    /* renamed from: d */
    public MenuInflater mo8758d() {
        return new SupportMenuInflater(this.f2235d.getContext());
    }

    @Override // p000a.p006b.p049h.p061j.ActionMode
    /* renamed from: e */
    public CharSequence mo8757e() {
        return this.f2235d.getSubtitle();
    }

    @Override // p000a.p006b.p049h.p061j.ActionMode
    /* renamed from: g */
    public CharSequence mo8756g() {
        return this.f2235d.getTitle();
    }

    @Override // p000a.p006b.p049h.p061j.ActionMode
    /* renamed from: i */
    public void mo8755i() {
        this.f2236e.mo8748b(this, this.f2239h);
    }

    @Override // p000a.p006b.p049h.p061j.ActionMode
    /* renamed from: j */
    public boolean mo8754j() {
        return this.f2235d.m7125c();
    }

    @Override // p000a.p006b.p049h.p061j.ActionMode
    /* renamed from: a */
    public void mo8766a(int i) {
        mo8764a((CharSequence) this.f2234c.getString(i));
    }

    @Override // p000a.p006b.p049h.p061j.ActionMode
    /* renamed from: b */
    public void mo8761b(int i) {
        mo8760b(this.f2234c.getString(i));
    }

    @Override // p000a.p006b.p049h.p061j.ActionMode
    /* renamed from: a */
    public void mo8763a(boolean z) {
        super.mo8763a(z);
        this.f2235d.setTitleOptional(z);
    }

    @Override // p000a.p006b.p049h.p061j.ActionMode
    /* renamed from: b */
    public View mo8762b() {
        WeakReference<View> weakReference = this.f2237f;
        if (weakReference != null) {
            return weakReference.get();
        }
        return null;
    }

    @Override // p000a.p006b.p049h.p061j.ActionMode
    /* renamed from: a */
    public void mo8765a(View view) {
        this.f2235d.setCustomView(view);
        this.f2237f = view != null ? new WeakReference<>(view) : null;
    }

    @Override // p000a.p006b.p049h.p061j.ActionMode
    /* renamed from: a */
    public void mo8767a() {
        if (this.f2238g) {
            return;
        }
        this.f2238g = true;
        this.f2235d.sendAccessibilityEvent(32);
        this.f2236e.mo8753a(this);
    }

    @Override // p000a.p006b.p049h.p061j.p062j.MenuBuilder.InterfaceC0425a
    /* renamed from: a */
    public boolean mo7077a(MenuBuilder menuBuilder, MenuItem menuItem) {
        return this.f2236e.mo8751a(this, menuItem);
    }

    @Override // p000a.p006b.p049h.p061j.p062j.MenuBuilder.InterfaceC0425a
    /* renamed from: a */
    public void mo7078a(MenuBuilder menuBuilder) {
        mo8755i();
        this.f2235d.m7123e();
    }
}
