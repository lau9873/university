package p000a.p006b.p049h.p061j.p062j;

import android.content.Context;
import android.view.ActionProvider;
import android.view.MenuItem;
import android.view.View;
import p000a.p006b.p030g.p036d.p037a.SupportMenuItem;
import p000a.p006b.p030g.p045k.ActionProvider;
import p000a.p006b.p049h.p061j.p062j.MenuItemWrapperICS;

/* renamed from: a.b.h.j.j.m */
/* loaded from: classes.dex */
public class MenuItemWrapperJB extends MenuItemWrapperICS {

    /* compiled from: MenuItemWrapperJB.java */
    /* renamed from: a.b.h.j.j.m$a */
    /* loaded from: classes.dex */
    public class ActionProvider$VisibilityListenerC0432a extends MenuItemWrapperICS.C0428a implements ActionProvider.VisibilityListener {

        /* renamed from: d */
        public ActionProvider.InterfaceC0280b f2453d;

        public ActionProvider$VisibilityListenerC0432a(MenuItemWrapperJB menuItemWrapperJB, Context context, android.view.ActionProvider actionProvider) {
            super(context, actionProvider);
        }

        @Override // p000a.p006b.p030g.p045k.ActionProvider
        /* renamed from: a */
        public View mo8614a(MenuItem menuItem) {
            return this.f2448b.onCreateActionView(menuItem);
        }

        @Override // p000a.p006b.p030g.p045k.ActionProvider
        /* renamed from: b */
        public boolean mo8613b() {
            return this.f2448b.isVisible();
        }

        @Override // p000a.p006b.p030g.p045k.ActionProvider
        /* renamed from: e */
        public boolean mo8612e() {
            return this.f2448b.overridesItemVisibility();
        }

        @Override // android.view.ActionProvider.VisibilityListener
        public void onActionProviderVisibilityChanged(boolean z) {
            ActionProvider.InterfaceC0280b interfaceC0280b = this.f2453d;
            if (interfaceC0280b != null) {
                interfaceC0280b.onActionProviderVisibilityChanged(z);
            }
        }

        @Override // p000a.p006b.p030g.p045k.ActionProvider
        /* renamed from: a */
        public void mo8615a(ActionProvider.InterfaceC0280b interfaceC0280b) {
            this.f2453d = interfaceC0280b;
            this.f2448b.setVisibilityListener(interfaceC0280b != null ? this : null);
        }
    }

    public MenuItemWrapperJB(Context context, SupportMenuItem supportMenuItem) {
        super(context, supportMenuItem);
    }

    @Override // p000a.p006b.p049h.p061j.p062j.MenuItemWrapperICS
    /* renamed from: a */
    public MenuItemWrapperICS.C0428a mo8616a(android.view.ActionProvider actionProvider) {
        return new ActionProvider$VisibilityListenerC0432a(this, this.f2325b, actionProvider);
    }
}
