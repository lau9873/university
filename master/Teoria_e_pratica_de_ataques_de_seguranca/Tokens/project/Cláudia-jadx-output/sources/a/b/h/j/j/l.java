package a.b.h.j.j;

import android.content.Context;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.util.Log;
import android.view.ActionProvider;
import android.view.CollapsibleActionView;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import android.widget.FrameLayout;
import java.lang.reflect.Method;
/* compiled from: MenuItemWrapperICS.java */
/* loaded from: classes.dex */
public class l extends a.b.h.j.j.c<a.b.g.d.a.b> implements MenuItem {

    /* renamed from: e  reason: collision with root package name */
    public Method f1604e;

    /* compiled from: MenuItemWrapperICS.java */
    /* loaded from: classes.dex */
    public class a extends a.b.g.k.c {

        /* renamed from: b  reason: collision with root package name */
        public final ActionProvider f1605b;

        public a(Context context, ActionProvider actionProvider) {
            super(context);
            this.f1605b = actionProvider;
        }

        @Override // a.b.g.k.c
        public boolean a() {
            return this.f1605b.hasSubMenu();
        }

        @Override // a.b.g.k.c
        public View c() {
            return this.f1605b.onCreateActionView();
        }

        @Override // a.b.g.k.c
        public boolean d() {
            return this.f1605b.onPerformDefaultAction();
        }

        @Override // a.b.g.k.c
        public void a(SubMenu subMenu) {
            this.f1605b.onPrepareSubMenu(l.this.a(subMenu));
        }
    }

    /* compiled from: MenuItemWrapperICS.java */
    /* loaded from: classes.dex */
    public static class b extends FrameLayout implements a.b.h.j.c {

        /* renamed from: a  reason: collision with root package name */
        public final CollapsibleActionView f1607a;

        public b(View view) {
            super(view.getContext());
            this.f1607a = (CollapsibleActionView) view;
            addView(view);
        }

        public View a() {
            return (View) this.f1607a;
        }

        @Override // a.b.h.j.c
        public void b() {
            this.f1607a.onActionViewExpanded();
        }

        @Override // a.b.h.j.c
        public void c() {
            this.f1607a.onActionViewCollapsed();
        }
    }

    /* compiled from: MenuItemWrapperICS.java */
    /* loaded from: classes.dex */
    public class c extends a.b.h.j.j.d<MenuItem.OnActionExpandListener> implements MenuItem.OnActionExpandListener {
        public c(MenuItem.OnActionExpandListener onActionExpandListener) {
            super(onActionExpandListener);
        }

        @Override // android.view.MenuItem.OnActionExpandListener
        public boolean onMenuItemActionCollapse(MenuItem menuItem) {
            return ((MenuItem.OnActionExpandListener) this.f1545a).onMenuItemActionCollapse(l.this.a(menuItem));
        }

        @Override // android.view.MenuItem.OnActionExpandListener
        public boolean onMenuItemActionExpand(MenuItem menuItem) {
            return ((MenuItem.OnActionExpandListener) this.f1545a).onMenuItemActionExpand(l.this.a(menuItem));
        }
    }

    /* compiled from: MenuItemWrapperICS.java */
    /* loaded from: classes.dex */
    public class d extends a.b.h.j.j.d<MenuItem.OnMenuItemClickListener> implements MenuItem.OnMenuItemClickListener {
        public d(MenuItem.OnMenuItemClickListener onMenuItemClickListener) {
            super(onMenuItemClickListener);
        }

        @Override // android.view.MenuItem.OnMenuItemClickListener
        public boolean onMenuItemClick(MenuItem menuItem) {
            return ((MenuItem.OnMenuItemClickListener) this.f1545a).onMenuItemClick(l.this.a(menuItem));
        }
    }

    public l(Context context, a.b.g.d.a.b bVar) {
        super(context, bVar);
    }

    public void a(boolean z) {
        try {
            if (this.f1604e == null) {
                this.f1604e = ((a.b.g.d.a.b) this.f1545a).getClass().getDeclaredMethod("setExclusiveCheckable", Boolean.TYPE);
            }
            this.f1604e.invoke(this.f1545a, Boolean.valueOf(z));
        } catch (Exception e2) {
            Log.w("MenuItemWrapper", "Error while calling setExclusiveCheckable", e2);
        }
    }

    @Override // android.view.MenuItem
    public boolean collapseActionView() {
        return ((a.b.g.d.a.b) this.f1545a).collapseActionView();
    }

    @Override // android.view.MenuItem
    public boolean expandActionView() {
        return ((a.b.g.d.a.b) this.f1545a).expandActionView();
    }

    @Override // android.view.MenuItem
    public ActionProvider getActionProvider() {
        a.b.g.k.c a2 = ((a.b.g.d.a.b) this.f1545a).a();
        if (a2 instanceof a) {
            return ((a) a2).f1605b;
        }
        return null;
    }

    @Override // android.view.MenuItem
    public View getActionView() {
        View actionView = ((a.b.g.d.a.b) this.f1545a).getActionView();
        return actionView instanceof b ? ((b) actionView).a() : actionView;
    }

    @Override // android.view.MenuItem
    public int getAlphabeticModifiers() {
        return ((a.b.g.d.a.b) this.f1545a).getAlphabeticModifiers();
    }

    @Override // android.view.MenuItem
    public char getAlphabeticShortcut() {
        return ((a.b.g.d.a.b) this.f1545a).getAlphabeticShortcut();
    }

    @Override // android.view.MenuItem
    public CharSequence getContentDescription() {
        return ((a.b.g.d.a.b) this.f1545a).getContentDescription();
    }

    @Override // android.view.MenuItem
    public int getGroupId() {
        return ((a.b.g.d.a.b) this.f1545a).getGroupId();
    }

    @Override // android.view.MenuItem
    public Drawable getIcon() {
        return ((a.b.g.d.a.b) this.f1545a).getIcon();
    }

    @Override // android.view.MenuItem
    public ColorStateList getIconTintList() {
        return ((a.b.g.d.a.b) this.f1545a).getIconTintList();
    }

    @Override // android.view.MenuItem
    public PorterDuff.Mode getIconTintMode() {
        return ((a.b.g.d.a.b) this.f1545a).getIconTintMode();
    }

    @Override // android.view.MenuItem
    public Intent getIntent() {
        return ((a.b.g.d.a.b) this.f1545a).getIntent();
    }

    @Override // android.view.MenuItem
    public int getItemId() {
        return ((a.b.g.d.a.b) this.f1545a).getItemId();
    }

    @Override // android.view.MenuItem
    public ContextMenu.ContextMenuInfo getMenuInfo() {
        return ((a.b.g.d.a.b) this.f1545a).getMenuInfo();
    }

    @Override // android.view.MenuItem
    public int getNumericModifiers() {
        return ((a.b.g.d.a.b) this.f1545a).getNumericModifiers();
    }

    @Override // android.view.MenuItem
    public char getNumericShortcut() {
        return ((a.b.g.d.a.b) this.f1545a).getNumericShortcut();
    }

    @Override // android.view.MenuItem
    public int getOrder() {
        return ((a.b.g.d.a.b) this.f1545a).getOrder();
    }

    @Override // android.view.MenuItem
    public SubMenu getSubMenu() {
        return a(((a.b.g.d.a.b) this.f1545a).getSubMenu());
    }

    @Override // android.view.MenuItem
    public CharSequence getTitle() {
        return ((a.b.g.d.a.b) this.f1545a).getTitle();
    }

    @Override // android.view.MenuItem
    public CharSequence getTitleCondensed() {
        return ((a.b.g.d.a.b) this.f1545a).getTitleCondensed();
    }

    @Override // android.view.MenuItem
    public CharSequence getTooltipText() {
        return ((a.b.g.d.a.b) this.f1545a).getTooltipText();
    }

    @Override // android.view.MenuItem
    public boolean hasSubMenu() {
        return ((a.b.g.d.a.b) this.f1545a).hasSubMenu();
    }

    @Override // android.view.MenuItem
    public boolean isActionViewExpanded() {
        return ((a.b.g.d.a.b) this.f1545a).isActionViewExpanded();
    }

    @Override // android.view.MenuItem
    public boolean isCheckable() {
        return ((a.b.g.d.a.b) this.f1545a).isCheckable();
    }

    @Override // android.view.MenuItem
    public boolean isChecked() {
        return ((a.b.g.d.a.b) this.f1545a).isChecked();
    }

    @Override // android.view.MenuItem
    public boolean isEnabled() {
        return ((a.b.g.d.a.b) this.f1545a).isEnabled();
    }

    @Override // android.view.MenuItem
    public boolean isVisible() {
        return ((a.b.g.d.a.b) this.f1545a).isVisible();
    }

    @Override // android.view.MenuItem
    public MenuItem setActionProvider(ActionProvider actionProvider) {
        ((a.b.g.d.a.b) this.f1545a).a(actionProvider != null ? a(actionProvider) : null);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setActionView(View view) {
        if (view instanceof CollapsibleActionView) {
            view = new b(view);
        }
        ((a.b.g.d.a.b) this.f1545a).setActionView(view);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setAlphabeticShortcut(char c2) {
        ((a.b.g.d.a.b) this.f1545a).setAlphabeticShortcut(c2);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setCheckable(boolean z) {
        ((a.b.g.d.a.b) this.f1545a).setCheckable(z);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setChecked(boolean z) {
        ((a.b.g.d.a.b) this.f1545a).setChecked(z);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setContentDescription(CharSequence charSequence) {
        ((a.b.g.d.a.b) this.f1545a).setContentDescription(charSequence);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setEnabled(boolean z) {
        ((a.b.g.d.a.b) this.f1545a).setEnabled(z);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setIcon(Drawable drawable) {
        ((a.b.g.d.a.b) this.f1545a).setIcon(drawable);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setIconTintList(ColorStateList colorStateList) {
        ((a.b.g.d.a.b) this.f1545a).setIconTintList(colorStateList);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setIconTintMode(PorterDuff.Mode mode) {
        ((a.b.g.d.a.b) this.f1545a).setIconTintMode(mode);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setIntent(Intent intent) {
        ((a.b.g.d.a.b) this.f1545a).setIntent(intent);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setNumericShortcut(char c2) {
        ((a.b.g.d.a.b) this.f1545a).setNumericShortcut(c2);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setOnActionExpandListener(MenuItem.OnActionExpandListener onActionExpandListener) {
        ((a.b.g.d.a.b) this.f1545a).setOnActionExpandListener(onActionExpandListener != null ? new c(onActionExpandListener) : null);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setOnMenuItemClickListener(MenuItem.OnMenuItemClickListener onMenuItemClickListener) {
        ((a.b.g.d.a.b) this.f1545a).setOnMenuItemClickListener(onMenuItemClickListener != null ? new d(onMenuItemClickListener) : null);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setShortcut(char c2, char c3) {
        ((a.b.g.d.a.b) this.f1545a).setShortcut(c2, c3);
        return this;
    }

    @Override // android.view.MenuItem
    public void setShowAsAction(int i2) {
        ((a.b.g.d.a.b) this.f1545a).setShowAsAction(i2);
    }

    @Override // android.view.MenuItem
    public MenuItem setShowAsActionFlags(int i2) {
        ((a.b.g.d.a.b) this.f1545a).setShowAsActionFlags(i2);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setTitle(CharSequence charSequence) {
        ((a.b.g.d.a.b) this.f1545a).setTitle(charSequence);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setTitleCondensed(CharSequence charSequence) {
        ((a.b.g.d.a.b) this.f1545a).setTitleCondensed(charSequence);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setTooltipText(CharSequence charSequence) {
        ((a.b.g.d.a.b) this.f1545a).setTooltipText(charSequence);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setVisible(boolean z) {
        return ((a.b.g.d.a.b) this.f1545a).setVisible(z);
    }

    @Override // android.view.MenuItem
    public MenuItem setAlphabeticShortcut(char c2, int i2) {
        ((a.b.g.d.a.b) this.f1545a).setAlphabeticShortcut(c2, i2);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setIcon(int i2) {
        ((a.b.g.d.a.b) this.f1545a).setIcon(i2);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setNumericShortcut(char c2, int i2) {
        ((a.b.g.d.a.b) this.f1545a).setNumericShortcut(c2, i2);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setShortcut(char c2, char c3, int i2, int i3) {
        ((a.b.g.d.a.b) this.f1545a).setShortcut(c2, c3, i2, i3);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setTitle(int i2) {
        ((a.b.g.d.a.b) this.f1545a).setTitle(i2);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setActionView(int i2) {
        ((a.b.g.d.a.b) this.f1545a).setActionView(i2);
        View actionView = ((a.b.g.d.a.b) this.f1545a).getActionView();
        if (actionView instanceof CollapsibleActionView) {
            ((a.b.g.d.a.b) this.f1545a).setActionView(new b(actionView));
        }
        return this;
    }

    public a a(ActionProvider actionProvider) {
        return new a(this.f1542b, actionProvider);
    }
}
