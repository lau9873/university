package a.b.h.j.j;

import a.b.g.k.c;
import a.b.h.j.j.q;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.Log;
import android.view.ActionProvider;
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
/* compiled from: MenuItemImpl.java */
/* loaded from: classes.dex */
public final class k implements a.b.g.d.a.b {
    public View A;
    public a.b.g.k.c B;
    public MenuItem.OnActionExpandListener C;
    public ContextMenu.ContextMenuInfo E;

    /* renamed from: a  reason: collision with root package name */
    public final int f1594a;

    /* renamed from: b  reason: collision with root package name */
    public final int f1595b;

    /* renamed from: c  reason: collision with root package name */
    public final int f1596c;

    /* renamed from: d  reason: collision with root package name */
    public final int f1597d;

    /* renamed from: e  reason: collision with root package name */
    public CharSequence f1598e;

    /* renamed from: f  reason: collision with root package name */
    public CharSequence f1599f;

    /* renamed from: g  reason: collision with root package name */
    public Intent f1600g;

    /* renamed from: h  reason: collision with root package name */
    public char f1601h;
    public char j;
    public Drawable l;
    public h n;
    public v o;
    public Runnable p;
    public MenuItem.OnMenuItemClickListener q;
    public CharSequence r;
    public CharSequence s;
    public int z;

    /* renamed from: i  reason: collision with root package name */
    public int f1602i = 4096;
    public int k = 4096;
    public int m = 0;
    public ColorStateList t = null;
    public PorterDuff.Mode u = null;
    public boolean v = false;
    public boolean w = false;
    public boolean x = false;
    public int y = 16;
    public boolean D = false;

    /* compiled from: MenuItemImpl.java */
    /* loaded from: classes.dex */
    public class a implements c.b {
        public a() {
        }

        @Override // a.b.g.k.c.b
        public void onActionProviderVisibilityChanged(boolean z) {
            k kVar = k.this;
            kVar.n.d(kVar);
        }
    }

    public k(h hVar, int i2, int i3, int i4, int i5, CharSequence charSequence, int i6) {
        this.z = 0;
        this.n = hVar;
        this.f1594a = i3;
        this.f1595b = i2;
        this.f1596c = i4;
        this.f1597d = i5;
        this.f1598e = charSequence;
        this.z = i6;
    }

    public static void a(StringBuilder sb, int i2, int i3, String str) {
        if ((i2 & i3) == i3) {
            sb.append(str);
        }
    }

    public void b(boolean z) {
        int i2 = this.y;
        this.y = (z ? 2 : 0) | (i2 & (-3));
        if (i2 != this.y) {
            this.n.c(false);
        }
    }

    public int c() {
        return this.f1597d;
    }

    @Override // a.b.g.d.a.b, android.view.MenuItem
    public boolean collapseActionView() {
        if ((this.z & 8) == 0) {
            return false;
        }
        if (this.A == null) {
            return true;
        }
        MenuItem.OnActionExpandListener onActionExpandListener = this.C;
        if (onActionExpandListener == null || onActionExpandListener.onMenuItemActionCollapse(this)) {
            return this.n.a(this);
        }
        return false;
    }

    public char d() {
        return this.n.p() ? this.j : this.f1601h;
    }

    public String e() {
        char d2 = d();
        if (d2 == 0) {
            return "";
        }
        Resources resources = this.n.e().getResources();
        StringBuilder sb = new StringBuilder();
        if (ViewConfiguration.get(this.n.e()).hasPermanentMenuKey()) {
            sb.append(resources.getString(a.b.h.b.h.abc_prepend_shortcut_label));
        }
        int i2 = this.n.p() ? this.k : this.f1602i;
        a(sb, i2, 65536, resources.getString(a.b.h.b.h.abc_menu_meta_shortcut_label));
        a(sb, i2, 4096, resources.getString(a.b.h.b.h.abc_menu_ctrl_shortcut_label));
        a(sb, i2, 2, resources.getString(a.b.h.b.h.abc_menu_alt_shortcut_label));
        a(sb, i2, 1, resources.getString(a.b.h.b.h.abc_menu_shift_shortcut_label));
        a(sb, i2, 4, resources.getString(a.b.h.b.h.abc_menu_sym_shortcut_label));
        a(sb, i2, 8, resources.getString(a.b.h.b.h.abc_menu_function_shortcut_label));
        if (d2 == '\b') {
            sb.append(resources.getString(a.b.h.b.h.abc_menu_delete_shortcut_label));
        } else if (d2 == '\n') {
            sb.append(resources.getString(a.b.h.b.h.abc_menu_enter_shortcut_label));
        } else if (d2 != ' ') {
            sb.append(d2);
        } else {
            sb.append(resources.getString(a.b.h.b.h.abc_menu_space_shortcut_label));
        }
        return sb.toString();
    }

    @Override // a.b.g.d.a.b, android.view.MenuItem
    public boolean expandActionView() {
        if (f()) {
            MenuItem.OnActionExpandListener onActionExpandListener = this.C;
            if (onActionExpandListener == null || onActionExpandListener.onMenuItemActionExpand(this)) {
                return this.n.b(this);
            }
            return false;
        }
        return false;
    }

    public boolean f() {
        a.b.g.k.c cVar;
        if ((this.z & 8) != 0) {
            if (this.A == null && (cVar = this.B) != null) {
                this.A = cVar.a(this);
            }
            return this.A != null;
        }
        return false;
    }

    public boolean g() {
        MenuItem.OnMenuItemClickListener onMenuItemClickListener = this.q;
        if (onMenuItemClickListener == null || !onMenuItemClickListener.onMenuItemClick(this)) {
            h hVar = this.n;
            if (hVar.a(hVar, this)) {
                return true;
            }
            Runnable runnable = this.p;
            if (runnable != null) {
                runnable.run();
                return true;
            }
            if (this.f1600g != null) {
                try {
                    this.n.e().startActivity(this.f1600g);
                    return true;
                } catch (ActivityNotFoundException e2) {
                    Log.e("MenuItemImpl", "Can't find activity to handle intent; ignoring", e2);
                }
            }
            a.b.g.k.c cVar = this.B;
            return cVar != null && cVar.d();
        }
        return true;
    }

    @Override // android.view.MenuItem
    public ActionProvider getActionProvider() {
        throw new UnsupportedOperationException("This is not supported, use MenuItemCompat.getActionProvider()");
    }

    @Override // a.b.g.d.a.b, android.view.MenuItem
    public View getActionView() {
        View view = this.A;
        if (view != null) {
            return view;
        }
        a.b.g.k.c cVar = this.B;
        if (cVar != null) {
            this.A = cVar.a(this);
            return this.A;
        }
        return null;
    }

    @Override // a.b.g.d.a.b, android.view.MenuItem
    public int getAlphabeticModifiers() {
        return this.k;
    }

    @Override // android.view.MenuItem
    public char getAlphabeticShortcut() {
        return this.j;
    }

    @Override // a.b.g.d.a.b, android.view.MenuItem
    public CharSequence getContentDescription() {
        return this.r;
    }

    @Override // android.view.MenuItem
    public int getGroupId() {
        return this.f1595b;
    }

    @Override // android.view.MenuItem
    public Drawable getIcon() {
        Drawable drawable = this.l;
        if (drawable != null) {
            return a(drawable);
        }
        if (this.m != 0) {
            Drawable c2 = a.b.h.d.a.a.c(this.n.e(), this.m);
            this.m = 0;
            this.l = c2;
            return a(c2);
        }
        return null;
    }

    @Override // a.b.g.d.a.b, android.view.MenuItem
    public ColorStateList getIconTintList() {
        return this.t;
    }

    @Override // a.b.g.d.a.b, android.view.MenuItem
    public PorterDuff.Mode getIconTintMode() {
        return this.u;
    }

    @Override // android.view.MenuItem
    public Intent getIntent() {
        return this.f1600g;
    }

    @Override // android.view.MenuItem
    @ViewDebug.CapturedViewProperty
    public int getItemId() {
        return this.f1594a;
    }

    @Override // android.view.MenuItem
    public ContextMenu.ContextMenuInfo getMenuInfo() {
        return this.E;
    }

    @Override // a.b.g.d.a.b, android.view.MenuItem
    public int getNumericModifiers() {
        return this.f1602i;
    }

    @Override // android.view.MenuItem
    public char getNumericShortcut() {
        return this.f1601h;
    }

    @Override // android.view.MenuItem
    public int getOrder() {
        return this.f1596c;
    }

    @Override // android.view.MenuItem
    public SubMenu getSubMenu() {
        return this.o;
    }

    @Override // android.view.MenuItem
    @ViewDebug.CapturedViewProperty
    public CharSequence getTitle() {
        return this.f1598e;
    }

    @Override // android.view.MenuItem
    public CharSequence getTitleCondensed() {
        CharSequence charSequence = this.f1599f;
        if (charSequence == null) {
            charSequence = this.f1598e;
        }
        return (Build.VERSION.SDK_INT >= 18 || charSequence == null || (charSequence instanceof String)) ? charSequence : charSequence.toString();
    }

    @Override // a.b.g.d.a.b, android.view.MenuItem
    public CharSequence getTooltipText() {
        return this.s;
    }

    public boolean h() {
        return (this.y & 32) == 32;
    }

    @Override // android.view.MenuItem
    public boolean hasSubMenu() {
        return this.o != null;
    }

    public boolean i() {
        return (this.y & 4) != 0;
    }

    @Override // a.b.g.d.a.b, android.view.MenuItem
    public boolean isActionViewExpanded() {
        return this.D;
    }

    @Override // android.view.MenuItem
    public boolean isCheckable() {
        return (this.y & 1) == 1;
    }

    @Override // android.view.MenuItem
    public boolean isChecked() {
        return (this.y & 2) == 2;
    }

    @Override // android.view.MenuItem
    public boolean isEnabled() {
        return (this.y & 16) != 0;
    }

    @Override // android.view.MenuItem
    public boolean isVisible() {
        a.b.g.k.c cVar = this.B;
        return (cVar == null || !cVar.e()) ? (this.y & 8) == 0 : (this.y & 8) == 0 && this.B.b();
    }

    public boolean j() {
        return (this.z & 1) == 1;
    }

    public boolean k() {
        return (this.z & 2) == 2;
    }

    public boolean l() {
        return this.n.k();
    }

    public boolean m() {
        return this.n.q() && d() != 0;
    }

    public boolean n() {
        return (this.z & 4) == 4;
    }

    @Override // android.view.MenuItem
    public MenuItem setActionProvider(ActionProvider actionProvider) {
        throw new UnsupportedOperationException("This is not supported, use MenuItemCompat.setActionProvider()");
    }

    @Override // a.b.g.d.a.b, android.view.MenuItem
    public /* bridge */ /* synthetic */ MenuItem setActionView(int i2) {
        setActionView(i2);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setAlphabeticShortcut(char c2) {
        if (this.j == c2) {
            return this;
        }
        this.j = Character.toLowerCase(c2);
        this.n.c(false);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setCheckable(boolean z) {
        int i2 = this.y;
        this.y = (z ? 1 : 0) | (i2 & (-2));
        if (i2 != this.y) {
            this.n.c(false);
        }
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setChecked(boolean z) {
        if ((this.y & 4) != 0) {
            this.n.a((MenuItem) this);
        } else {
            b(z);
        }
        return this;
    }

    @Override // a.b.g.d.a.b, android.view.MenuItem
    public /* bridge */ /* synthetic */ MenuItem setContentDescription(CharSequence charSequence) {
        setContentDescription(charSequence);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setEnabled(boolean z) {
        if (z) {
            this.y |= 16;
        } else {
            this.y &= -17;
        }
        this.n.c(false);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setIcon(Drawable drawable) {
        this.m = 0;
        this.l = drawable;
        this.x = true;
        this.n.c(false);
        return this;
    }

    @Override // a.b.g.d.a.b, android.view.MenuItem
    public MenuItem setIconTintList(ColorStateList colorStateList) {
        this.t = colorStateList;
        this.v = true;
        this.x = true;
        this.n.c(false);
        return this;
    }

    @Override // a.b.g.d.a.b, android.view.MenuItem
    public MenuItem setIconTintMode(PorterDuff.Mode mode) {
        this.u = mode;
        this.w = true;
        this.x = true;
        this.n.c(false);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setIntent(Intent intent) {
        this.f1600g = intent;
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setNumericShortcut(char c2) {
        if (this.f1601h == c2) {
            return this;
        }
        this.f1601h = c2;
        this.n.c(false);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setOnActionExpandListener(MenuItem.OnActionExpandListener onActionExpandListener) {
        this.C = onActionExpandListener;
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setOnMenuItemClickListener(MenuItem.OnMenuItemClickListener onMenuItemClickListener) {
        this.q = onMenuItemClickListener;
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setShortcut(char c2, char c3) {
        this.f1601h = c2;
        this.j = Character.toLowerCase(c3);
        this.n.c(false);
        return this;
    }

    @Override // a.b.g.d.a.b, android.view.MenuItem
    public void setShowAsAction(int i2) {
        int i3 = i2 & 3;
        if (i3 != 0 && i3 != 1 && i3 != 2) {
            throw new IllegalArgumentException("SHOW_AS_ACTION_ALWAYS, SHOW_AS_ACTION_IF_ROOM, and SHOW_AS_ACTION_NEVER are mutually exclusive.");
        }
        this.z = i2;
        this.n.c(this);
    }

    @Override // a.b.g.d.a.b, android.view.MenuItem
    public /* bridge */ /* synthetic */ MenuItem setShowAsActionFlags(int i2) {
        setShowAsActionFlags(i2);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setTitle(CharSequence charSequence) {
        this.f1598e = charSequence;
        this.n.c(false);
        v vVar = this.o;
        if (vVar != null) {
            vVar.setHeaderTitle(charSequence);
        }
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setTitleCondensed(CharSequence charSequence) {
        this.f1599f = charSequence;
        this.n.c(false);
        return this;
    }

    @Override // a.b.g.d.a.b, android.view.MenuItem
    public /* bridge */ /* synthetic */ MenuItem setTooltipText(CharSequence charSequence) {
        setTooltipText(charSequence);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setVisible(boolean z) {
        if (e(z)) {
            this.n.d(this);
        }
        return this;
    }

    public String toString() {
        CharSequence charSequence = this.f1598e;
        if (charSequence != null) {
            return charSequence.toString();
        }
        return null;
    }

    public void a(v vVar) {
        this.o = vVar;
        vVar.setHeaderTitle(getTitle());
    }

    public void c(boolean z) {
        this.y = (z ? 4 : 0) | (this.y & (-5));
    }

    public void d(boolean z) {
        if (z) {
            this.y |= 32;
        } else {
            this.y &= -33;
        }
    }

    @Override // a.b.g.d.a.b, android.view.MenuItem
    public /* bridge */ /* synthetic */ MenuItem setActionView(View view) {
        setActionView(view);
        return this;
    }

    @Override // a.b.g.d.a.b, android.view.MenuItem
    public a.b.g.d.a.b setContentDescription(CharSequence charSequence) {
        this.r = charSequence;
        this.n.c(false);
        return this;
    }

    @Override // a.b.g.d.a.b, android.view.MenuItem
    public a.b.g.d.a.b setShowAsActionFlags(int i2) {
        setShowAsAction(i2);
        return this;
    }

    @Override // a.b.g.d.a.b, android.view.MenuItem
    public a.b.g.d.a.b setTooltipText(CharSequence charSequence) {
        this.s = charSequence;
        this.n.c(false);
        return this;
    }

    @Override // a.b.g.d.a.b, android.view.MenuItem
    public a.b.g.d.a.b setActionView(View view) {
        int i2;
        this.A = view;
        this.B = null;
        if (view != null && view.getId() == -1 && (i2 = this.f1594a) > 0) {
            view.setId(i2);
        }
        this.n.c(this);
        return this;
    }

    public CharSequence a(q.a aVar) {
        if (aVar != null && aVar.a()) {
            return getTitleCondensed();
        }
        return getTitle();
    }

    @Override // a.b.g.d.a.b, android.view.MenuItem
    public MenuItem setAlphabeticShortcut(char c2, int i2) {
        if (this.j == c2 && this.k == i2) {
            return this;
        }
        this.j = Character.toLowerCase(c2);
        this.k = KeyEvent.normalizeMetaState(i2);
        this.n.c(false);
        return this;
    }

    @Override // a.b.g.d.a.b, android.view.MenuItem
    public MenuItem setNumericShortcut(char c2, int i2) {
        if (this.f1601h == c2 && this.f1602i == i2) {
            return this;
        }
        this.f1601h = c2;
        this.f1602i = KeyEvent.normalizeMetaState(i2);
        this.n.c(false);
        return this;
    }

    @Override // a.b.g.d.a.b, android.view.MenuItem
    public MenuItem setShortcut(char c2, char c3, int i2, int i3) {
        this.f1601h = c2;
        this.f1602i = KeyEvent.normalizeMetaState(i2);
        this.j = Character.toLowerCase(c3);
        this.k = KeyEvent.normalizeMetaState(i3);
        this.n.c(false);
        return this;
    }

    public void b() {
        this.n.c(this);
    }

    @Override // android.view.MenuItem
    public MenuItem setIcon(int i2) {
        this.l = null;
        this.m = i2;
        this.x = true;
        this.n.c(false);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setTitle(int i2) {
        setTitle(this.n.e().getString(i2));
        return this;
    }

    public final Drawable a(Drawable drawable) {
        if (drawable != null && this.x && (this.v || this.w)) {
            drawable = a.b.g.c.j.a.i(drawable).mutate();
            if (this.v) {
                a.b.g.c.j.a.a(drawable, this.t);
            }
            if (this.w) {
                a.b.g.c.j.a.a(drawable, this.u);
            }
            this.x = false;
        }
        return drawable;
    }

    @Override // a.b.g.d.a.b, android.view.MenuItem
    public a.b.g.d.a.b setActionView(int i2) {
        Context e2 = this.n.e();
        setActionView(LayoutInflater.from(e2).inflate(i2, (ViewGroup) new LinearLayout(e2), false));
        return this;
    }

    public void a(ContextMenu.ContextMenuInfo contextMenuInfo) {
        this.E = contextMenuInfo;
    }

    @Override // a.b.g.d.a.b
    public a.b.g.k.c a() {
        return this.B;
    }

    @Override // a.b.g.d.a.b
    public a.b.g.d.a.b a(a.b.g.k.c cVar) {
        a.b.g.k.c cVar2 = this.B;
        if (cVar2 != null) {
            cVar2.f();
        }
        this.A = null;
        this.B = cVar;
        this.n.c(true);
        a.b.g.k.c cVar3 = this.B;
        if (cVar3 != null) {
            cVar3.a(new a());
        }
        return this;
    }

    public void a(boolean z) {
        this.D = z;
        this.n.c(false);
    }

    public boolean e(boolean z) {
        int i2 = this.y;
        this.y = (z ? 0 : 8) | (i2 & (-9));
        return i2 != this.y;
    }
}
