package p000a.p006b.p049h.p061j.p062j;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.Log;
import android.view.ContextMenu;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewDebug;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import p000a.p006b.p030g.p034c.p035j.DrawableCompat;
import p000a.p006b.p030g.p036d.p037a.SupportMenuItem;
import p000a.p006b.p030g.p045k.ActionProvider;
import p000a.p006b.p049h.p051b.C0361h;
import p000a.p006b.p049h.p053d.p054a.AppCompatResources;
import p000a.p006b.p049h.p061j.p062j.MenuView;

/* renamed from: a.b.h.j.j.k */
/* loaded from: classes.dex */
public final class MenuItemImpl implements SupportMenuItem {

    /* renamed from: A */
    public View f2415A;

    /* renamed from: B */
    public ActionProvider f2416B;

    /* renamed from: C */
    public MenuItem.OnActionExpandListener f2417C;

    /* renamed from: E */
    public ContextMenu.ContextMenuInfo f2419E;

    /* renamed from: a */
    public final int f2420a;

    /* renamed from: b */
    public final int f2421b;

    /* renamed from: c */
    public final int f2422c;

    /* renamed from: d */
    public final int f2423d;

    /* renamed from: e */
    public CharSequence f2424e;

    /* renamed from: f */
    public CharSequence f2425f;

    /* renamed from: g */
    public Intent f2426g;

    /* renamed from: h */
    public char f2427h;

    /* renamed from: j */
    public char f2429j;

    /* renamed from: l */
    public Drawable f2431l;

    /* renamed from: n */
    public MenuBuilder f2433n;

    /* renamed from: o */
    public SubMenuBuilder f2434o;

    /* renamed from: p */
    public Runnable f2435p;

    /* renamed from: q */
    public MenuItem.OnMenuItemClickListener f2436q;

    /* renamed from: r */
    public CharSequence f2437r;

    /* renamed from: s */
    public CharSequence f2438s;

    /* renamed from: z */
    public int f2445z;

    /* renamed from: i */
    public int f2428i = 4096;

    /* renamed from: k */
    public int f2430k = 4096;

    /* renamed from: m */
    public int f2432m = 0;

    /* renamed from: t */
    public ColorStateList f2439t = null;

    /* renamed from: u */
    public PorterDuff.Mode f2440u = null;

    /* renamed from: v */
    public boolean f2441v = false;

    /* renamed from: w */
    public boolean f2442w = false;

    /* renamed from: x */
    public boolean f2443x = false;

    /* renamed from: y */
    public int f2444y = 16;

    /* renamed from: D */
    public boolean f2418D = false;

    /* compiled from: MenuItemImpl.java */
    /* renamed from: a.b.h.j.j.k$a */
    /* loaded from: classes.dex */
    public class C0427a implements ActionProvider.InterfaceC0280b {
        public C0427a() {
        }

        @Override // p000a.p006b.p030g.p045k.ActionProvider.InterfaceC0280b
        public void onActionProviderVisibilityChanged(boolean z) {
            MenuItemImpl menuItemImpl = MenuItemImpl.this;
            menuItemImpl.f2433n.m8668d(menuItemImpl);
        }
    }

    public MenuItemImpl(MenuBuilder menuBuilder, int i, int i2, int i3, int i4, CharSequence charSequence, int i5) {
        this.f2445z = 0;
        this.f2433n = menuBuilder;
        this.f2420a = i2;
        this.f2421b = i;
        this.f2422c = i3;
        this.f2423d = i4;
        this.f2424e = charSequence;
        this.f2445z = i5;
    }

    /* renamed from: a */
    public static void m8641a(StringBuilder sb, int i, int i2, String str) {
        if ((i & i2) == i2) {
            sb.append(str);
        }
    }

    /* renamed from: b */
    public void m8638b(boolean z) {
        int i = this.f2444y;
        this.f2444y = (z ? 2 : 0) | (i & (-3));
        if (i != this.f2444y) {
            this.f2433n.m8670c(false);
        }
    }

    /* renamed from: c */
    public int m8637c() {
        return this.f2423d;
    }

    @Override // p000a.p006b.p030g.p036d.p037a.SupportMenuItem, android.view.MenuItem
    public boolean collapseActionView() {
        if ((this.f2445z & 8) == 0) {
            return false;
        }
        if (this.f2415A == null) {
            return true;
        }
        MenuItem.OnActionExpandListener onActionExpandListener = this.f2417C;
        if (onActionExpandListener == null || onActionExpandListener.onMenuItemActionCollapse(this)) {
            return this.f2433n.mo8577a(this);
        }
        return false;
    }

    /* renamed from: d */
    public char m8635d() {
        return this.f2433n.mo8572p() ? this.f2429j : this.f2427h;
    }

    /* renamed from: e */
    public String m8633e() {
        char m8635d = m8635d();
        if (m8635d == 0) {
            return "";
        }
        Resources resources = this.f2433n.m8665e().getResources();
        StringBuilder sb = new StringBuilder();
        if (ViewConfiguration.get(this.f2433n.m8665e()).hasPermanentMenuKey()) {
            sb.append(resources.getString(C0361h.abc_prepend_shortcut_label));
        }
        int i = this.f2433n.mo8572p() ? this.f2430k : this.f2428i;
        m8641a(sb, i, 65536, resources.getString(C0361h.abc_menu_meta_shortcut_label));
        m8641a(sb, i, 4096, resources.getString(C0361h.abc_menu_ctrl_shortcut_label));
        m8641a(sb, i, 2, resources.getString(C0361h.abc_menu_alt_shortcut_label));
        m8641a(sb, i, 1, resources.getString(C0361h.abc_menu_shift_shortcut_label));
        m8641a(sb, i, 4, resources.getString(C0361h.abc_menu_sym_shortcut_label));
        m8641a(sb, i, 8, resources.getString(C0361h.abc_menu_function_shortcut_label));
        if (m8635d == '\b') {
            sb.append(resources.getString(C0361h.abc_menu_delete_shortcut_label));
        } else if (m8635d == '\n') {
            sb.append(resources.getString(C0361h.abc_menu_enter_shortcut_label));
        } else if (m8635d != ' ') {
            sb.append(m8635d);
        } else {
            sb.append(resources.getString(C0361h.abc_menu_space_shortcut_label));
        }
        return sb.toString();
    }

    @Override // p000a.p006b.p030g.p036d.p037a.SupportMenuItem, android.view.MenuItem
    public boolean expandActionView() {
        if (m8631f()) {
            MenuItem.OnActionExpandListener onActionExpandListener = this.f2417C;
            if (onActionExpandListener == null || onActionExpandListener.onMenuItemActionExpand(this)) {
                return this.f2433n.mo8576b(this);
            }
            return false;
        }
        return false;
    }

    /* renamed from: f */
    public boolean m8631f() {
        ActionProvider actionProvider;
        if ((this.f2445z & 8) != 0) {
            if (this.f2415A == null && (actionProvider = this.f2416B) != null) {
                this.f2415A = actionProvider.mo8614a(this);
            }
            return this.f2415A != null;
        }
        return false;
    }

    /* renamed from: g */
    public boolean m8630g() {
        MenuItem.OnMenuItemClickListener onMenuItemClickListener = this.f2436q;
        if (onMenuItemClickListener == null || !onMenuItemClickListener.onMenuItemClick(this)) {
            MenuBuilder menuBuilder = this.f2433n;
            if (menuBuilder.mo8578a(menuBuilder, this)) {
                return true;
            }
            Runnable runnable = this.f2435p;
            if (runnable != null) {
                runnable.run();
                return true;
            }
            if (this.f2426g != null) {
                try {
                    this.f2433n.m8665e().startActivity(this.f2426g);
                    return true;
                } catch (ActivityNotFoundException e) {
                    Log.e("MenuItemImpl", "Can't find activity to handle intent; ignoring", e);
                }
            }
            ActionProvider actionProvider = this.f2416B;
            return actionProvider != null && actionProvider.mo8618d();
        }
        return true;
    }

    @Override // android.view.MenuItem
    public android.view.ActionProvider getActionProvider() {
        throw new UnsupportedOperationException("This is not supported, use MenuItemCompat.getActionProvider()");
    }

    @Override // p000a.p006b.p030g.p036d.p037a.SupportMenuItem, android.view.MenuItem
    public View getActionView() {
        View view = this.f2415A;
        if (view != null) {
            return view;
        }
        ActionProvider actionProvider = this.f2416B;
        if (actionProvider != null) {
            this.f2415A = actionProvider.mo8614a(this);
            return this.f2415A;
        }
        return null;
    }

    @Override // p000a.p006b.p030g.p036d.p037a.SupportMenuItem, android.view.MenuItem
    public int getAlphabeticModifiers() {
        return this.f2430k;
    }

    @Override // android.view.MenuItem
    public char getAlphabeticShortcut() {
        return this.f2429j;
    }

    @Override // p000a.p006b.p030g.p036d.p037a.SupportMenuItem, android.view.MenuItem
    public CharSequence getContentDescription() {
        return this.f2437r;
    }

    @Override // android.view.MenuItem
    public int getGroupId() {
        return this.f2421b;
    }

    @Override // android.view.MenuItem
    public Drawable getIcon() {
        Drawable drawable = this.f2431l;
        if (drawable != null) {
            return m8643a(drawable);
        }
        if (this.f2432m != 0) {
            Drawable m8967c = AppCompatResources.m8967c(this.f2433n.m8665e(), this.f2432m);
            this.f2432m = 0;
            this.f2431l = m8967c;
            return m8643a(m8967c);
        }
        return null;
    }

    @Override // p000a.p006b.p030g.p036d.p037a.SupportMenuItem, android.view.MenuItem
    public ColorStateList getIconTintList() {
        return this.f2439t;
    }

    @Override // p000a.p006b.p030g.p036d.p037a.SupportMenuItem, android.view.MenuItem
    public PorterDuff.Mode getIconTintMode() {
        return this.f2440u;
    }

    @Override // android.view.MenuItem
    public Intent getIntent() {
        return this.f2426g;
    }

    @Override // android.view.MenuItem
    @ViewDebug.CapturedViewProperty
    public int getItemId() {
        return this.f2420a;
    }

    @Override // android.view.MenuItem
    public ContextMenu.ContextMenuInfo getMenuInfo() {
        return this.f2419E;
    }

    @Override // p000a.p006b.p030g.p036d.p037a.SupportMenuItem, android.view.MenuItem
    public int getNumericModifiers() {
        return this.f2428i;
    }

    @Override // android.view.MenuItem
    public char getNumericShortcut() {
        return this.f2427h;
    }

    @Override // android.view.MenuItem
    public int getOrder() {
        return this.f2422c;
    }

    @Override // android.view.MenuItem
    public SubMenu getSubMenu() {
        return this.f2434o;
    }

    @Override // android.view.MenuItem
    @ViewDebug.CapturedViewProperty
    public CharSequence getTitle() {
        return this.f2424e;
    }

    @Override // android.view.MenuItem
    public CharSequence getTitleCondensed() {
        CharSequence charSequence = this.f2425f;
        if (charSequence == null) {
            charSequence = this.f2424e;
        }
        return (Build.VERSION.SDK_INT >= 18 || charSequence == null || (charSequence instanceof String)) ? charSequence : charSequence.toString();
    }

    @Override // p000a.p006b.p030g.p036d.p037a.SupportMenuItem, android.view.MenuItem
    public CharSequence getTooltipText() {
        return this.f2438s;
    }

    /* renamed from: h */
    public boolean m8629h() {
        return (this.f2444y & 32) == 32;
    }

    @Override // android.view.MenuItem
    public boolean hasSubMenu() {
        return this.f2434o != null;
    }

    /* renamed from: i */
    public boolean m8628i() {
        return (this.f2444y & 4) != 0;
    }

    @Override // p000a.p006b.p030g.p036d.p037a.SupportMenuItem, android.view.MenuItem
    public boolean isActionViewExpanded() {
        return this.f2418D;
    }

    @Override // android.view.MenuItem
    public boolean isCheckable() {
        return (this.f2444y & 1) == 1;
    }

    @Override // android.view.MenuItem
    public boolean isChecked() {
        return (this.f2444y & 2) == 2;
    }

    @Override // android.view.MenuItem
    public boolean isEnabled() {
        return (this.f2444y & 16) != 0;
    }

    @Override // android.view.MenuItem
    public boolean isVisible() {
        ActionProvider actionProvider = this.f2416B;
        return (actionProvider == null || !actionProvider.mo8612e()) ? (this.f2444y & 8) == 0 : (this.f2444y & 8) == 0 && this.f2416B.mo8613b();
    }

    /* renamed from: j */
    public boolean m8627j() {
        return (this.f2445z & 1) == 1;
    }

    /* renamed from: k */
    public boolean m8626k() {
        return (this.f2445z & 2) == 2;
    }

    /* renamed from: l */
    public boolean m8625l() {
        return this.f2433n.m8654k();
    }

    /* renamed from: m */
    public boolean m8624m() {
        return this.f2433n.mo8571q() && m8635d() != 0;
    }

    /* renamed from: n */
    public boolean m8623n() {
        return (this.f2445z & 4) == 4;
    }

    @Override // android.view.MenuItem
    public MenuItem setActionProvider(android.view.ActionProvider actionProvider) {
        throw new UnsupportedOperationException("This is not supported, use MenuItemCompat.setActionProvider()");
    }

    @Override // p000a.p006b.p030g.p036d.p037a.SupportMenuItem, android.view.MenuItem
    public /* bridge */ /* synthetic */ MenuItem setActionView(int i) {
        setActionView(i);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setAlphabeticShortcut(char c) {
        if (this.f2429j == c) {
            return this;
        }
        this.f2429j = Character.toLowerCase(c);
        this.f2433n.m8670c(false);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setCheckable(boolean z) {
        int i = this.f2444y;
        this.f2444y = (z ? 1 : 0) | (i & (-2));
        if (i != this.f2444y) {
            this.f2433n.m8670c(false);
        }
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setChecked(boolean z) {
        if ((this.f2444y & 4) != 0) {
            this.f2433n.m8687a((MenuItem) this);
        } else {
            m8638b(z);
        }
        return this;
    }

    @Override // p000a.p006b.p030g.p036d.p037a.SupportMenuItem, android.view.MenuItem
    public /* bridge */ /* synthetic */ MenuItem setContentDescription(CharSequence charSequence) {
        setContentDescription(charSequence);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setEnabled(boolean z) {
        if (z) {
            this.f2444y |= 16;
        } else {
            this.f2444y &= -17;
        }
        this.f2433n.m8670c(false);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setIcon(Drawable drawable) {
        this.f2432m = 0;
        this.f2431l = drawable;
        this.f2443x = true;
        this.f2433n.m8670c(false);
        return this;
    }

    @Override // p000a.p006b.p030g.p036d.p037a.SupportMenuItem, android.view.MenuItem
    public MenuItem setIconTintList(ColorStateList colorStateList) {
        this.f2439t = colorStateList;
        this.f2441v = true;
        this.f2443x = true;
        this.f2433n.m8670c(false);
        return this;
    }

    @Override // p000a.p006b.p030g.p036d.p037a.SupportMenuItem, android.view.MenuItem
    public MenuItem setIconTintMode(PorterDuff.Mode mode) {
        this.f2440u = mode;
        this.f2442w = true;
        this.f2443x = true;
        this.f2433n.m8670c(false);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setIntent(Intent intent) {
        this.f2426g = intent;
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setNumericShortcut(char c) {
        if (this.f2427h == c) {
            return this;
        }
        this.f2427h = c;
        this.f2433n.m8670c(false);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setOnActionExpandListener(MenuItem.OnActionExpandListener onActionExpandListener) {
        this.f2417C = onActionExpandListener;
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setOnMenuItemClickListener(MenuItem.OnMenuItemClickListener onMenuItemClickListener) {
        this.f2436q = onMenuItemClickListener;
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setShortcut(char c, char c2) {
        this.f2427h = c;
        this.f2429j = Character.toLowerCase(c2);
        this.f2433n.m8670c(false);
        return this;
    }

    @Override // p000a.p006b.p030g.p036d.p037a.SupportMenuItem, android.view.MenuItem
    public void setShowAsAction(int i) {
        int i2 = i & 3;
        if (i2 != 0 && i2 != 1 && i2 != 2) {
            throw new IllegalArgumentException("SHOW_AS_ACTION_ALWAYS, SHOW_AS_ACTION_IF_ROOM, and SHOW_AS_ACTION_NEVER are mutually exclusive.");
        }
        this.f2445z = i;
        this.f2433n.m8672c(this);
    }

    @Override // p000a.p006b.p030g.p036d.p037a.SupportMenuItem, android.view.MenuItem
    public /* bridge */ /* synthetic */ MenuItem setShowAsActionFlags(int i) {
        setShowAsActionFlags(i);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setTitle(CharSequence charSequence) {
        this.f2424e = charSequence;
        this.f2433n.m8670c(false);
        SubMenuBuilder subMenuBuilder = this.f2434o;
        if (subMenuBuilder != null) {
            subMenuBuilder.setHeaderTitle(charSequence);
        }
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setTitleCondensed(CharSequence charSequence) {
        this.f2425f = charSequence;
        this.f2433n.m8670c(false);
        return this;
    }

    @Override // p000a.p006b.p030g.p036d.p037a.SupportMenuItem, android.view.MenuItem
    public /* bridge */ /* synthetic */ MenuItem setTooltipText(CharSequence charSequence) {
        setTooltipText(charSequence);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setVisible(boolean z) {
        if (m8632e(z)) {
            this.f2433n.m8668d(this);
        }
        return this;
    }

    public String toString() {
        CharSequence charSequence = this.f2424e;
        if (charSequence != null) {
            return charSequence.toString();
        }
        return null;
    }

    /* renamed from: a */
    public void m8644a(SubMenuBuilder subMenuBuilder) {
        this.f2434o = subMenuBuilder;
        subMenuBuilder.setHeaderTitle(getTitle());
    }

    /* renamed from: c */
    public void m8636c(boolean z) {
        this.f2444y = (z ? 4 : 0) | (this.f2444y & (-5));
    }

    /* renamed from: d */
    public void m8634d(boolean z) {
        if (z) {
            this.f2444y |= 32;
        } else {
            this.f2444y &= -33;
        }
    }

    @Override // p000a.p006b.p030g.p036d.p037a.SupportMenuItem, android.view.MenuItem
    public /* bridge */ /* synthetic */ MenuItem setActionView(View view) {
        setActionView(view);
        return this;
    }

    @Override // p000a.p006b.p030g.p036d.p037a.SupportMenuItem, android.view.MenuItem
    public SupportMenuItem setContentDescription(CharSequence charSequence) {
        this.f2437r = charSequence;
        this.f2433n.m8670c(false);
        return this;
    }

    @Override // p000a.p006b.p030g.p036d.p037a.SupportMenuItem, android.view.MenuItem
    public SupportMenuItem setShowAsActionFlags(int i) {
        setShowAsAction(i);
        return this;
    }

    @Override // p000a.p006b.p030g.p036d.p037a.SupportMenuItem, android.view.MenuItem
    public SupportMenuItem setTooltipText(CharSequence charSequence) {
        this.f2438s = charSequence;
        this.f2433n.m8670c(false);
        return this;
    }

    @Override // p000a.p006b.p030g.p036d.p037a.SupportMenuItem, android.view.MenuItem
    public SupportMenuItem setActionView(View view) {
        int i;
        this.f2415A = view;
        this.f2416B = null;
        if (view != null && view.getId() == -1 && (i = this.f2420a) > 0) {
            view.setId(i);
        }
        this.f2433n.m8672c(this);
        return this;
    }

    /* renamed from: a */
    public CharSequence m8645a(MenuView.InterfaceC0435a interfaceC0435a) {
        if (interfaceC0435a != null && interfaceC0435a.mo7138a()) {
            return getTitleCondensed();
        }
        return getTitle();
    }

    @Override // p000a.p006b.p030g.p036d.p037a.SupportMenuItem, android.view.MenuItem
    public MenuItem setAlphabeticShortcut(char c, int i) {
        if (this.f2429j == c && this.f2430k == i) {
            return this;
        }
        this.f2429j = Character.toLowerCase(c);
        this.f2430k = KeyEvent.normalizeMetaState(i);
        this.f2433n.m8670c(false);
        return this;
    }

    @Override // p000a.p006b.p030g.p036d.p037a.SupportMenuItem, android.view.MenuItem
    public MenuItem setNumericShortcut(char c, int i) {
        if (this.f2427h == c && this.f2428i == i) {
            return this;
        }
        this.f2427h = c;
        this.f2428i = KeyEvent.normalizeMetaState(i);
        this.f2433n.m8670c(false);
        return this;
    }

    @Override // p000a.p006b.p030g.p036d.p037a.SupportMenuItem, android.view.MenuItem
    public MenuItem setShortcut(char c, char c2, int i, int i2) {
        this.f2427h = c;
        this.f2428i = KeyEvent.normalizeMetaState(i);
        this.f2429j = Character.toLowerCase(c2);
        this.f2430k = KeyEvent.normalizeMetaState(i2);
        this.f2433n.m8670c(false);
        return this;
    }

    /* renamed from: b */
    public void m8639b() {
        this.f2433n.m8672c(this);
    }

    @Override // android.view.MenuItem
    public MenuItem setIcon(int i) {
        this.f2431l = null;
        this.f2432m = i;
        this.f2443x = true;
        this.f2433n.m8670c(false);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setTitle(int i) {
        setTitle(this.f2433n.m8665e().getString(i));
        return this;
    }

    /* renamed from: a */
    public final Drawable m8643a(Drawable drawable) {
        if (drawable != null && this.f2443x && (this.f2441v || this.f2442w)) {
            drawable = DrawableCompat.m9848i(drawable).mutate();
            if (this.f2441v) {
                DrawableCompat.m9861a(drawable, this.f2439t);
            }
            if (this.f2442w) {
                DrawableCompat.m9858a(drawable, this.f2440u);
            }
            this.f2443x = false;
        }
        return drawable;
    }

    @Override // p000a.p006b.p030g.p036d.p037a.SupportMenuItem, android.view.MenuItem
    public SupportMenuItem setActionView(int i) {
        Context m8665e = this.f2433n.m8665e();
        setActionView(LayoutInflater.from(m8665e).inflate(i, (ViewGroup) new LinearLayout(m8665e), false));
        return this;
    }

    /* renamed from: a */
    public void m8642a(ContextMenu.ContextMenuInfo contextMenuInfo) {
        this.f2419E = contextMenuInfo;
    }

    @Override // p000a.p006b.p030g.p036d.p037a.SupportMenuItem
    /* renamed from: a */
    public ActionProvider mo8647a() {
        return this.f2416B;
    }

    @Override // p000a.p006b.p030g.p036d.p037a.SupportMenuItem
    /* renamed from: a */
    public SupportMenuItem mo8646a(ActionProvider actionProvider) {
        ActionProvider actionProvider2 = this.f2416B;
        if (actionProvider2 != null) {
            actionProvider2.m9580f();
        }
        this.f2415A = null;
        this.f2416B = actionProvider;
        this.f2433n.m8670c(true);
        ActionProvider actionProvider3 = this.f2416B;
        if (actionProvider3 != null) {
            actionProvider3.mo8615a(new C0427a());
        }
        return this;
    }

    /* renamed from: a */
    public void m8640a(boolean z) {
        this.f2418D = z;
        this.f2433n.m8670c(false);
    }

    /* renamed from: e */
    public boolean m8632e(boolean z) {
        int i = this.f2444y;
        this.f2444y = (z ? 0 : 8) | (i & (-9));
        return i != this.f2444y;
    }
}
