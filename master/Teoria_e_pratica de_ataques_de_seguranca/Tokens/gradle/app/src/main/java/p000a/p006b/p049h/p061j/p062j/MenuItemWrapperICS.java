package p000a.p006b.p049h.p061j.p062j;

import android.content.Context;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.util.Log;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import android.widget.FrameLayout;
import java.lang.reflect.Method;
import p000a.p006b.p030g.p036d.p037a.SupportMenuItem;
import p000a.p006b.p030g.p045k.ActionProvider;
import p000a.p006b.p049h.p061j.CollapsibleActionView;

/* renamed from: a.b.h.j.j.l */
/* loaded from: classes.dex */
public class MenuItemWrapperICS extends BaseMenuWrapper<SupportMenuItem> implements MenuItem {

    /* renamed from: e */
    public Method f2447e;

    /* compiled from: MenuItemWrapperICS.java */
    /* renamed from: a.b.h.j.j.l$a */
    /* loaded from: classes.dex */
    public class C0428a extends ActionProvider {

        /* renamed from: b */
        public final android.view.ActionProvider f2448b;

        public C0428a(Context context, android.view.ActionProvider actionProvider) {
            super(context);
            this.f2448b = actionProvider;
        }

        @Override // p000a.p006b.p030g.p045k.ActionProvider
        /* renamed from: a */
        public boolean mo8621a() {
            return this.f2448b.hasSubMenu();
        }

        @Override // p000a.p006b.p030g.p045k.ActionProvider
        /* renamed from: c */
        public View mo8619c() {
            return this.f2448b.onCreateActionView();
        }

        @Override // p000a.p006b.p030g.p045k.ActionProvider
        /* renamed from: d */
        public boolean mo8618d() {
            return this.f2448b.onPerformDefaultAction();
        }

        @Override // p000a.p006b.p030g.p045k.ActionProvider
        /* renamed from: a */
        public void mo8620a(SubMenu subMenu) {
            this.f2448b.onPrepareSubMenu(MenuItemWrapperICS.this.m8719a(subMenu));
        }
    }

    /* compiled from: MenuItemWrapperICS.java */
    /* renamed from: a.b.h.j.j.l$b */
    /* loaded from: classes.dex */
    public static class C0429b extends FrameLayout implements CollapsibleActionView {

        /* renamed from: a */
        public final android.view.CollapsibleActionView f2450a;

        public C0429b(View view) {
            super(view.getContext());
            this.f2450a = (android.view.CollapsibleActionView) view;
            addView(view);
        }

        /* renamed from: a */
        public View m8617a() {
            return (View) this.f2450a;
        }

        @Override // p000a.p006b.p049h.p061j.CollapsibleActionView
        /* renamed from: b */
        public void mo6516b() {
            this.f2450a.onActionViewExpanded();
        }

        @Override // p000a.p006b.p049h.p061j.CollapsibleActionView
        /* renamed from: c */
        public void mo6511c() {
            this.f2450a.onActionViewCollapsed();
        }
    }

    /* compiled from: MenuItemWrapperICS.java */
    /* renamed from: a.b.h.j.j.l$c */
    /* loaded from: classes.dex */
    public class MenuItem$OnActionExpandListenerC0430c extends BaseWrapper<MenuItem.OnActionExpandListener> implements MenuItem.OnActionExpandListener {
        public MenuItem$OnActionExpandListenerC0430c(MenuItem.OnActionExpandListener onActionExpandListener) {
            super(onActionExpandListener);
        }

        @Override // android.view.MenuItem.OnActionExpandListener
        public boolean onMenuItemActionCollapse(MenuItem menuItem) {
            return ((MenuItem.OnActionExpandListener) this.f2328a).onMenuItemActionCollapse(MenuItemWrapperICS.this.m8720a(menuItem));
        }

        @Override // android.view.MenuItem.OnActionExpandListener
        public boolean onMenuItemActionExpand(MenuItem menuItem) {
            return ((MenuItem.OnActionExpandListener) this.f2328a).onMenuItemActionExpand(MenuItemWrapperICS.this.m8720a(menuItem));
        }
    }

    /* compiled from: MenuItemWrapperICS.java */
    /* renamed from: a.b.h.j.j.l$d */
    /* loaded from: classes.dex */
    public class MenuItem$OnMenuItemClickListenerC0431d extends BaseWrapper<MenuItem.OnMenuItemClickListener> implements MenuItem.OnMenuItemClickListener {
        public MenuItem$OnMenuItemClickListenerC0431d(MenuItem.OnMenuItemClickListener onMenuItemClickListener) {
            super(onMenuItemClickListener);
        }

        @Override // android.view.MenuItem.OnMenuItemClickListener
        public boolean onMenuItemClick(MenuItem menuItem) {
            return ((MenuItem.OnMenuItemClickListener) this.f2328a).onMenuItemClick(MenuItemWrapperICS.this.m8720a(menuItem));
        }
    }

    public MenuItemWrapperICS(Context context, SupportMenuItem supportMenuItem) {
        super(context, supportMenuItem);
    }

    /* renamed from: a */
    public void m8622a(boolean z) {
        try {
            if (this.f2447e == null) {
                this.f2447e = ((SupportMenuItem) this.f2328a).getClass().getDeclaredMethod("setExclusiveCheckable", Boolean.TYPE);
            }
            this.f2447e.invoke(this.f2328a, Boolean.valueOf(z));
        } catch (Exception e) {
            Log.w("MenuItemWrapper", "Error while calling setExclusiveCheckable", e);
        }
    }

    @Override // android.view.MenuItem
    public boolean collapseActionView() {
        return ((SupportMenuItem) this.f2328a).collapseActionView();
    }

    @Override // android.view.MenuItem
    public boolean expandActionView() {
        return ((SupportMenuItem) this.f2328a).expandActionView();
    }

    @Override // android.view.MenuItem
    public android.view.ActionProvider getActionProvider() {
        ActionProvider mo8647a = ((SupportMenuItem) this.f2328a).mo8647a();
        if (mo8647a instanceof C0428a) {
            return ((C0428a) mo8647a).f2448b;
        }
        return null;
    }

    @Override // android.view.MenuItem
    public View getActionView() {
        View actionView = ((SupportMenuItem) this.f2328a).getActionView();
        return actionView instanceof C0429b ? ((C0429b) actionView).m8617a() : actionView;
    }

    @Override // android.view.MenuItem
    public int getAlphabeticModifiers() {
        return ((SupportMenuItem) this.f2328a).getAlphabeticModifiers();
    }

    @Override // android.view.MenuItem
    public char getAlphabeticShortcut() {
        return ((SupportMenuItem) this.f2328a).getAlphabeticShortcut();
    }

    @Override // android.view.MenuItem
    public CharSequence getContentDescription() {
        return ((SupportMenuItem) this.f2328a).getContentDescription();
    }

    @Override // android.view.MenuItem
    public int getGroupId() {
        return ((SupportMenuItem) this.f2328a).getGroupId();
    }

    @Override // android.view.MenuItem
    public Drawable getIcon() {
        return ((SupportMenuItem) this.f2328a).getIcon();
    }

    @Override // android.view.MenuItem
    public ColorStateList getIconTintList() {
        return ((SupportMenuItem) this.f2328a).getIconTintList();
    }

    @Override // android.view.MenuItem
    public PorterDuff.Mode getIconTintMode() {
        return ((SupportMenuItem) this.f2328a).getIconTintMode();
    }

    @Override // android.view.MenuItem
    public Intent getIntent() {
        return ((SupportMenuItem) this.f2328a).getIntent();
    }

    @Override // android.view.MenuItem
    public int getItemId() {
        return ((SupportMenuItem) this.f2328a).getItemId();
    }

    @Override // android.view.MenuItem
    public ContextMenu.ContextMenuInfo getMenuInfo() {
        return ((SupportMenuItem) this.f2328a).getMenuInfo();
    }

    @Override // android.view.MenuItem
    public int getNumericModifiers() {
        return ((SupportMenuItem) this.f2328a).getNumericModifiers();
    }

    @Override // android.view.MenuItem
    public char getNumericShortcut() {
        return ((SupportMenuItem) this.f2328a).getNumericShortcut();
    }

    @Override // android.view.MenuItem
    public int getOrder() {
        return ((SupportMenuItem) this.f2328a).getOrder();
    }

    @Override // android.view.MenuItem
    public SubMenu getSubMenu() {
        return m8719a(((SupportMenuItem) this.f2328a).getSubMenu());
    }

    @Override // android.view.MenuItem
    public CharSequence getTitle() {
        return ((SupportMenuItem) this.f2328a).getTitle();
    }

    @Override // android.view.MenuItem
    public CharSequence getTitleCondensed() {
        return ((SupportMenuItem) this.f2328a).getTitleCondensed();
    }

    @Override // android.view.MenuItem
    public CharSequence getTooltipText() {
        return ((SupportMenuItem) this.f2328a).getTooltipText();
    }

    @Override // android.view.MenuItem
    public boolean hasSubMenu() {
        return ((SupportMenuItem) this.f2328a).hasSubMenu();
    }

    @Override // android.view.MenuItem
    public boolean isActionViewExpanded() {
        return ((SupportMenuItem) this.f2328a).isActionViewExpanded();
    }

    @Override // android.view.MenuItem
    public boolean isCheckable() {
        return ((SupportMenuItem) this.f2328a).isCheckable();
    }

    @Override // android.view.MenuItem
    public boolean isChecked() {
        return ((SupportMenuItem) this.f2328a).isChecked();
    }

    @Override // android.view.MenuItem
    public boolean isEnabled() {
        return ((SupportMenuItem) this.f2328a).isEnabled();
    }

    @Override // android.view.MenuItem
    public boolean isVisible() {
        return ((SupportMenuItem) this.f2328a).isVisible();
    }

    @Override // android.view.MenuItem
    public MenuItem setActionProvider(android.view.ActionProvider actionProvider) {
        ((SupportMenuItem) this.f2328a).mo8646a(actionProvider != null ? mo8616a(actionProvider) : null);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setActionView(View view) {
        if (view instanceof android.view.CollapsibleActionView) {
            view = new C0429b(view);
        }
        ((SupportMenuItem) this.f2328a).setActionView(view);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setAlphabeticShortcut(char c) {
        ((SupportMenuItem) this.f2328a).setAlphabeticShortcut(c);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setCheckable(boolean z) {
        ((SupportMenuItem) this.f2328a).setCheckable(z);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setChecked(boolean z) {
        ((SupportMenuItem) this.f2328a).setChecked(z);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setContentDescription(CharSequence charSequence) {
        ((SupportMenuItem) this.f2328a).setContentDescription(charSequence);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setEnabled(boolean z) {
        ((SupportMenuItem) this.f2328a).setEnabled(z);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setIcon(Drawable drawable) {
        ((SupportMenuItem) this.f2328a).setIcon(drawable);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setIconTintList(ColorStateList colorStateList) {
        ((SupportMenuItem) this.f2328a).setIconTintList(colorStateList);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setIconTintMode(PorterDuff.Mode mode) {
        ((SupportMenuItem) this.f2328a).setIconTintMode(mode);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setIntent(Intent intent) {
        ((SupportMenuItem) this.f2328a).setIntent(intent);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setNumericShortcut(char c) {
        ((SupportMenuItem) this.f2328a).setNumericShortcut(c);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setOnActionExpandListener(MenuItem.OnActionExpandListener onActionExpandListener) {
        ((SupportMenuItem) this.f2328a).setOnActionExpandListener(onActionExpandListener != null ? new MenuItem$OnActionExpandListenerC0430c(onActionExpandListener) : null);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setOnMenuItemClickListener(MenuItem.OnMenuItemClickListener onMenuItemClickListener) {
        ((SupportMenuItem) this.f2328a).setOnMenuItemClickListener(onMenuItemClickListener != null ? new MenuItem$OnMenuItemClickListenerC0431d(onMenuItemClickListener) : null);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setShortcut(char c, char c2) {
        ((SupportMenuItem) this.f2328a).setShortcut(c, c2);
        return this;
    }

    @Override // android.view.MenuItem
    public void setShowAsAction(int i) {
        ((SupportMenuItem) this.f2328a).setShowAsAction(i);
    }

    @Override // android.view.MenuItem
    public MenuItem setShowAsActionFlags(int i) {
        ((SupportMenuItem) this.f2328a).setShowAsActionFlags(i);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setTitle(CharSequence charSequence) {
        ((SupportMenuItem) this.f2328a).setTitle(charSequence);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setTitleCondensed(CharSequence charSequence) {
        ((SupportMenuItem) this.f2328a).setTitleCondensed(charSequence);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setTooltipText(CharSequence charSequence) {
        ((SupportMenuItem) this.f2328a).setTooltipText(charSequence);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setVisible(boolean z) {
        return ((SupportMenuItem) this.f2328a).setVisible(z);
    }

    @Override // android.view.MenuItem
    public MenuItem setAlphabeticShortcut(char c, int i) {
        ((SupportMenuItem) this.f2328a).setAlphabeticShortcut(c, i);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setIcon(int i) {
        ((SupportMenuItem) this.f2328a).setIcon(i);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setNumericShortcut(char c, int i) {
        ((SupportMenuItem) this.f2328a).setNumericShortcut(c, i);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setShortcut(char c, char c2, int i, int i2) {
        ((SupportMenuItem) this.f2328a).setShortcut(c, c2, i, i2);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setTitle(int i) {
        ((SupportMenuItem) this.f2328a).setTitle(i);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setActionView(int i) {
        ((SupportMenuItem) this.f2328a).setActionView(i);
        View actionView = ((SupportMenuItem) this.f2328a).getActionView();
        if (actionView instanceof android.view.CollapsibleActionView) {
            ((SupportMenuItem) this.f2328a).setActionView(new C0429b(actionView));
        }
        return this;
    }

    /* renamed from: a */
    public C0428a mo8616a(android.view.ActionProvider actionProvider) {
        return new C0428a(this.f2325b, actionProvider);
    }
}
