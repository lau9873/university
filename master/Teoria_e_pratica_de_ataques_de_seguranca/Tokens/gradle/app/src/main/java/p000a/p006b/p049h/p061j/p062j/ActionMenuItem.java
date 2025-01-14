package p000a.p006b.p049h.p061j.p062j;

import android.content.Context;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.view.ContextMenu;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import p000a.p006b.p030g.p032b.ContextCompat;
import p000a.p006b.p030g.p034c.p035j.DrawableCompat;
import p000a.p006b.p030g.p036d.p037a.SupportMenuItem;
import p000a.p006b.p030g.p045k.ActionProvider;

/* renamed from: a.b.h.j.j.a */
/* loaded from: classes.dex */
public class ActionMenuItem implements SupportMenuItem {

    /* renamed from: a */
    public final int f2297a;

    /* renamed from: b */
    public final int f2298b;

    /* renamed from: c */
    public final int f2299c;

    /* renamed from: d */
    public CharSequence f2300d;

    /* renamed from: e */
    public CharSequence f2301e;

    /* renamed from: f */
    public Intent f2302f;

    /* renamed from: g */
    public char f2303g;

    /* renamed from: i */
    public char f2305i;

    /* renamed from: k */
    public Drawable f2307k;

    /* renamed from: l */
    public Context f2308l;

    /* renamed from: m */
    public CharSequence f2309m;

    /* renamed from: n */
    public CharSequence f2310n;

    /* renamed from: h */
    public int f2304h = 4096;

    /* renamed from: j */
    public int f2306j = 4096;

    /* renamed from: o */
    public ColorStateList f2311o = null;

    /* renamed from: p */
    public PorterDuff.Mode f2312p = null;

    /* renamed from: q */
    public boolean f2313q = false;

    /* renamed from: r */
    public boolean f2314r = false;

    /* renamed from: s */
    public int f2315s = 16;

    public ActionMenuItem(Context context, int i, int i2, int i3, int i4, CharSequence charSequence) {
        this.f2308l = context;
        this.f2297a = i2;
        this.f2298b = i;
        this.f2299c = i4;
        this.f2300d = charSequence;
    }

    @Override // p000a.p006b.p030g.p036d.p037a.SupportMenuItem
    /* renamed from: a */
    public SupportMenuItem mo8646a(ActionProvider actionProvider) {
        throw new UnsupportedOperationException();
    }

    @Override // p000a.p006b.p030g.p036d.p037a.SupportMenuItem
    /* renamed from: a */
    public ActionProvider mo8647a() {
        return null;
    }

    /* renamed from: b */
    public final void m8726b() {
        if (this.f2307k != null) {
            if (this.f2313q || this.f2314r) {
                this.f2307k = DrawableCompat.m9848i(this.f2307k);
                this.f2307k = this.f2307k.mutate();
                if (this.f2313q) {
                    DrawableCompat.m9861a(this.f2307k, this.f2311o);
                }
                if (this.f2314r) {
                    DrawableCompat.m9858a(this.f2307k, this.f2312p);
                }
            }
        }
    }

    @Override // p000a.p006b.p030g.p036d.p037a.SupportMenuItem, android.view.MenuItem
    public boolean collapseActionView() {
        return false;
    }

    @Override // p000a.p006b.p030g.p036d.p037a.SupportMenuItem, android.view.MenuItem
    public boolean expandActionView() {
        return false;
    }

    @Override // android.view.MenuItem
    public android.view.ActionProvider getActionProvider() {
        throw new UnsupportedOperationException();
    }

    @Override // p000a.p006b.p030g.p036d.p037a.SupportMenuItem, android.view.MenuItem
    public View getActionView() {
        return null;
    }

    @Override // p000a.p006b.p030g.p036d.p037a.SupportMenuItem, android.view.MenuItem
    public int getAlphabeticModifiers() {
        return this.f2306j;
    }

    @Override // android.view.MenuItem
    public char getAlphabeticShortcut() {
        return this.f2305i;
    }

    @Override // p000a.p006b.p030g.p036d.p037a.SupportMenuItem, android.view.MenuItem
    public CharSequence getContentDescription() {
        return this.f2309m;
    }

    @Override // android.view.MenuItem
    public int getGroupId() {
        return this.f2298b;
    }

    @Override // android.view.MenuItem
    public Drawable getIcon() {
        return this.f2307k;
    }

    @Override // p000a.p006b.p030g.p036d.p037a.SupportMenuItem, android.view.MenuItem
    public ColorStateList getIconTintList() {
        return this.f2311o;
    }

    @Override // p000a.p006b.p030g.p036d.p037a.SupportMenuItem, android.view.MenuItem
    public PorterDuff.Mode getIconTintMode() {
        return this.f2312p;
    }

    @Override // android.view.MenuItem
    public Intent getIntent() {
        return this.f2302f;
    }

    @Override // android.view.MenuItem
    public int getItemId() {
        return this.f2297a;
    }

    @Override // android.view.MenuItem
    public ContextMenu.ContextMenuInfo getMenuInfo() {
        return null;
    }

    @Override // p000a.p006b.p030g.p036d.p037a.SupportMenuItem, android.view.MenuItem
    public int getNumericModifiers() {
        return this.f2304h;
    }

    @Override // android.view.MenuItem
    public char getNumericShortcut() {
        return this.f2303g;
    }

    @Override // android.view.MenuItem
    public int getOrder() {
        return this.f2299c;
    }

    @Override // android.view.MenuItem
    public SubMenu getSubMenu() {
        return null;
    }

    @Override // android.view.MenuItem
    public CharSequence getTitle() {
        return this.f2300d;
    }

    @Override // android.view.MenuItem
    public CharSequence getTitleCondensed() {
        CharSequence charSequence = this.f2301e;
        return charSequence != null ? charSequence : this.f2300d;
    }

    @Override // p000a.p006b.p030g.p036d.p037a.SupportMenuItem, android.view.MenuItem
    public CharSequence getTooltipText() {
        return this.f2310n;
    }

    @Override // android.view.MenuItem
    public boolean hasSubMenu() {
        return false;
    }

    @Override // p000a.p006b.p030g.p036d.p037a.SupportMenuItem, android.view.MenuItem
    public boolean isActionViewExpanded() {
        return false;
    }

    @Override // android.view.MenuItem
    public boolean isCheckable() {
        return (this.f2315s & 1) != 0;
    }

    @Override // android.view.MenuItem
    public boolean isChecked() {
        return (this.f2315s & 2) != 0;
    }

    @Override // android.view.MenuItem
    public boolean isEnabled() {
        return (this.f2315s & 16) != 0;
    }

    @Override // android.view.MenuItem
    public boolean isVisible() {
        return (this.f2315s & 8) == 0;
    }

    @Override // android.view.MenuItem
    public MenuItem setActionProvider(android.view.ActionProvider actionProvider) {
        throw new UnsupportedOperationException();
    }

    @Override // p000a.p006b.p030g.p036d.p037a.SupportMenuItem, android.view.MenuItem
    public /* bridge */ /* synthetic */ MenuItem setActionView(int i) {
        setActionView(i);
        throw null;
    }

    @Override // android.view.MenuItem
    public MenuItem setAlphabeticShortcut(char c) {
        this.f2305i = Character.toLowerCase(c);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setCheckable(boolean z) {
        this.f2315s = (z ? 1 : 0) | (this.f2315s & (-2));
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setChecked(boolean z) {
        this.f2315s = (z ? 2 : 0) | (this.f2315s & (-3));
        return this;
    }

    @Override // p000a.p006b.p030g.p036d.p037a.SupportMenuItem, android.view.MenuItem
    public /* bridge */ /* synthetic */ MenuItem setContentDescription(CharSequence charSequence) {
        setContentDescription(charSequence);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setEnabled(boolean z) {
        this.f2315s = (z ? 16 : 0) | (this.f2315s & (-17));
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setIcon(Drawable drawable) {
        this.f2307k = drawable;
        m8726b();
        return this;
    }

    @Override // p000a.p006b.p030g.p036d.p037a.SupportMenuItem, android.view.MenuItem
    public MenuItem setIconTintList(ColorStateList colorStateList) {
        this.f2311o = colorStateList;
        this.f2313q = true;
        m8726b();
        return this;
    }

    @Override // p000a.p006b.p030g.p036d.p037a.SupportMenuItem, android.view.MenuItem
    public MenuItem setIconTintMode(PorterDuff.Mode mode) {
        this.f2312p = mode;
        this.f2314r = true;
        m8726b();
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setIntent(Intent intent) {
        this.f2302f = intent;
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setNumericShortcut(char c) {
        this.f2303g = c;
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setOnActionExpandListener(MenuItem.OnActionExpandListener onActionExpandListener) {
        throw new UnsupportedOperationException();
    }

    @Override // android.view.MenuItem
    public MenuItem setOnMenuItemClickListener(MenuItem.OnMenuItemClickListener onMenuItemClickListener) {
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setShortcut(char c, char c2) {
        this.f2303g = c;
        this.f2305i = Character.toLowerCase(c2);
        return this;
    }

    @Override // p000a.p006b.p030g.p036d.p037a.SupportMenuItem, android.view.MenuItem
    public void setShowAsAction(int i) {
    }

    @Override // p000a.p006b.p030g.p036d.p037a.SupportMenuItem, android.view.MenuItem
    public /* bridge */ /* synthetic */ MenuItem setShowAsActionFlags(int i) {
        setShowAsActionFlags(i);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setTitle(CharSequence charSequence) {
        this.f2300d = charSequence;
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setTitleCondensed(CharSequence charSequence) {
        this.f2301e = charSequence;
        return this;
    }

    @Override // p000a.p006b.p030g.p036d.p037a.SupportMenuItem, android.view.MenuItem
    public /* bridge */ /* synthetic */ MenuItem setTooltipText(CharSequence charSequence) {
        setTooltipText(charSequence);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setVisible(boolean z) {
        this.f2315s = (this.f2315s & 8) | (z ? 0 : 8);
        return this;
    }

    @Override // p000a.p006b.p030g.p036d.p037a.SupportMenuItem, android.view.MenuItem
    public /* bridge */ /* synthetic */ MenuItem setActionView(View view) {
        setActionView(view);
        throw null;
    }

    @Override // p000a.p006b.p030g.p036d.p037a.SupportMenuItem, android.view.MenuItem
    public MenuItem setAlphabeticShortcut(char c, int i) {
        this.f2305i = Character.toLowerCase(c);
        this.f2306j = KeyEvent.normalizeMetaState(i);
        return this;
    }

    @Override // p000a.p006b.p030g.p036d.p037a.SupportMenuItem, android.view.MenuItem
    public SupportMenuItem setContentDescription(CharSequence charSequence) {
        this.f2309m = charSequence;
        return this;
    }

    @Override // p000a.p006b.p030g.p036d.p037a.SupportMenuItem, android.view.MenuItem
    public MenuItem setNumericShortcut(char c, int i) {
        this.f2303g = c;
        this.f2304h = KeyEvent.normalizeMetaState(i);
        return this;
    }

    @Override // p000a.p006b.p030g.p036d.p037a.SupportMenuItem, android.view.MenuItem
    public SupportMenuItem setShowAsActionFlags(int i) {
        setShowAsAction(i);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setTitle(int i) {
        this.f2300d = this.f2308l.getResources().getString(i);
        return this;
    }

    @Override // p000a.p006b.p030g.p036d.p037a.SupportMenuItem, android.view.MenuItem
    public SupportMenuItem setTooltipText(CharSequence charSequence) {
        this.f2310n = charSequence;
        return this;
    }

    @Override // p000a.p006b.p030g.p036d.p037a.SupportMenuItem, android.view.MenuItem
    public SupportMenuItem setActionView(View view) {
        throw new UnsupportedOperationException();
    }

    @Override // android.view.MenuItem
    public MenuItem setIcon(int i) {
        this.f2307k = ContextCompat.m10016c(this.f2308l, i);
        m8726b();
        return this;
    }

    @Override // p000a.p006b.p030g.p036d.p037a.SupportMenuItem, android.view.MenuItem
    public MenuItem setShortcut(char c, char c2, int i, int i2) {
        this.f2303g = c;
        this.f2304h = KeyEvent.normalizeMetaState(i);
        this.f2305i = Character.toLowerCase(c2);
        this.f2306j = KeyEvent.normalizeMetaState(i2);
        return this;
    }

    @Override // p000a.p006b.p030g.p036d.p037a.SupportMenuItem, android.view.MenuItem
    public SupportMenuItem setActionView(int i) {
        throw new UnsupportedOperationException();
    }
}
