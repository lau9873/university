package p000a.p006b.p049h.p061j.p062j;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.SparseArray;
import android.view.ContextMenu;
import android.view.KeyCharacterMap;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import android.view.ViewConfiguration;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import p000a.p006b.p030g.p032b.ContextCompat;
import p000a.p006b.p030g.p036d.p037a.SupportMenu;
import p000a.p006b.p030g.p045k.ActionProvider;
import p000a.p006b.p030g.p045k.ViewConfigurationCompat;

/* renamed from: a.b.h.j.j.h */
/* loaded from: classes.dex */
public class MenuBuilder implements SupportMenu {

    /* renamed from: A */
    public static final int[] f2384A = {1, 4, 5, 3, 2, 0};

    /* renamed from: a */
    public final Context f2385a;

    /* renamed from: b */
    public final Resources f2386b;

    /* renamed from: c */
    public boolean f2387c;

    /* renamed from: d */
    public boolean f2388d;

    /* renamed from: e */
    public InterfaceC0425a f2389e;

    /* renamed from: m */
    public ContextMenu.ContextMenuInfo f2397m;

    /* renamed from: n */
    public CharSequence f2398n;

    /* renamed from: o */
    public Drawable f2399o;

    /* renamed from: p */
    public View f2400p;

    /* renamed from: x */
    public MenuItemImpl f2408x;

    /* renamed from: z */
    public boolean f2410z;

    /* renamed from: l */
    public int f2396l = 0;

    /* renamed from: q */
    public boolean f2401q = false;

    /* renamed from: r */
    public boolean f2402r = false;

    /* renamed from: s */
    public boolean f2403s = false;

    /* renamed from: t */
    public boolean f2404t = false;

    /* renamed from: u */
    public boolean f2405u = false;

    /* renamed from: v */
    public ArrayList<MenuItemImpl> f2406v = new ArrayList<>();

    /* renamed from: w */
    public CopyOnWriteArrayList<WeakReference<MenuPresenter>> f2407w = new CopyOnWriteArrayList<>();

    /* renamed from: y */
    public boolean f2409y = false;

    /* renamed from: f */
    public ArrayList<MenuItemImpl> f2390f = new ArrayList<>();

    /* renamed from: g */
    public ArrayList<MenuItemImpl> f2391g = new ArrayList<>();

    /* renamed from: h */
    public boolean f2392h = true;

    /* renamed from: i */
    public ArrayList<MenuItemImpl> f2393i = new ArrayList<>();

    /* renamed from: j */
    public ArrayList<MenuItemImpl> f2394j = new ArrayList<>();

    /* renamed from: k */
    public boolean f2395k = true;

    /* compiled from: MenuBuilder.java */
    /* renamed from: a.b.h.j.j.h$a */
    /* loaded from: classes.dex */
    public interface InterfaceC0425a {
        /* renamed from: a */
        void mo7078a(MenuBuilder menuBuilder);

        /* renamed from: a */
        boolean mo7077a(MenuBuilder menuBuilder, MenuItem menuItem);
    }

    /* compiled from: MenuBuilder.java */
    /* renamed from: a.b.h.j.j.h$b */
    /* loaded from: classes.dex */
    public interface InterfaceC0426b {
        /* renamed from: a */
        boolean mo7095a(MenuItemImpl menuItemImpl);
    }

    public MenuBuilder(Context context) {
        this.f2385a = context;
        this.f2386b = context.getResources();
        m8662e(true);
    }

    /* renamed from: a */
    public void m8692a(MenuPresenter menuPresenter) {
        m8691a(menuPresenter, this.f2385a);
    }

    @Override // android.view.Menu
    public MenuItem add(CharSequence charSequence) {
        return mo8696a(0, 0, 0, charSequence);
    }

    @Override // android.view.Menu
    public int addIntentOptions(int i, int i2, int i3, ComponentName componentName, Intent[] intentArr, Intent intent, int i4, MenuItem[] menuItemArr) {
        int i5;
        PackageManager packageManager = this.f2385a.getPackageManager();
        List<ResolveInfo> queryIntentActivityOptions = packageManager.queryIntentActivityOptions(componentName, intentArr, intent, 0);
        int size = queryIntentActivityOptions != null ? queryIntentActivityOptions.size() : 0;
        if ((i4 & 1) == 0) {
            removeGroup(i);
        }
        for (int i6 = 0; i6 < size; i6++) {
            ResolveInfo resolveInfo = queryIntentActivityOptions.get(i6);
            int i7 = resolveInfo.specificIndex;
            Intent intent2 = new Intent(i7 < 0 ? intent : intentArr[i7]);
            intent2.setComponent(new ComponentName(resolveInfo.activityInfo.applicationInfo.packageName, resolveInfo.activityInfo.name));
            MenuItem intent3 = add(i, i2, i3, resolveInfo.loadLabel(packageManager)).setIcon(resolveInfo.loadIcon(packageManager)).setIntent(intent2);
            if (menuItemArr != null && (i5 = resolveInfo.specificIndex) >= 0) {
                menuItemArr[i5] = intent3;
            }
        }
        return size;
    }

    @Override // android.view.Menu
    public SubMenu addSubMenu(CharSequence charSequence) {
        return addSubMenu(0, 0, 0, charSequence);
    }

    /* renamed from: b */
    public void m8677b(MenuPresenter menuPresenter) {
        Iterator<WeakReference<MenuPresenter>> it = this.f2407w.iterator();
        while (it.hasNext()) {
            WeakReference<MenuPresenter> next = it.next();
            MenuPresenter menuPresenter2 = next.get();
            if (menuPresenter2 == null || menuPresenter2 == menuPresenter) {
                this.f2407w.remove(next);
            }
        }
    }

    /* renamed from: c */
    public MenuBuilder m8673c(int i) {
        this.f2396l = i;
        return this;
    }

    @Override // android.view.Menu
    public void clear() {
        MenuItemImpl menuItemImpl = this.f2408x;
        if (menuItemImpl != null) {
            mo8577a(menuItemImpl);
        }
        this.f2390f.clear();
        m8670c(true);
    }

    public void clearHeader() {
        this.f2399o = null;
        this.f2398n = null;
        this.f2400p = null;
        m8670c(false);
    }

    @Override // android.view.Menu
    public void close() {
        m8680a(true);
    }

    /* renamed from: d */
    public String mo8575d() {
        return "android:menu:actionviewstates";
    }

    /* renamed from: d */
    public void m8667d(Bundle bundle) {
        m8688a(bundle);
    }

    /* renamed from: e */
    public void m8663e(Bundle bundle) {
        int size = size();
        SparseArray<? extends Parcelable> sparseArray = null;
        for (int i = 0; i < size; i++) {
            MenuItem item = getItem(i);
            View actionView = item.getActionView();
            if (actionView != null && actionView.getId() != -1) {
                if (sparseArray == null) {
                    sparseArray = new SparseArray<>();
                }
                actionView.saveHierarchyState(sparseArray);
                if (item.isActionViewExpanded()) {
                    bundle.putInt("android:menu:expandedactionview", item.getItemId());
                }
            }
            if (item.hasSubMenu()) {
                ((SubMenuBuilder) item.getSubMenu()).m8663e(bundle);
            }
        }
        if (sparseArray != null) {
            bundle.putSparseParcelableArray(mo8575d(), sparseArray);
        }
    }

    /* renamed from: f */
    public void m8659f(Bundle bundle) {
        m8676b(bundle);
    }

    @Override // android.view.Menu
    public MenuItem findItem(int i) {
        MenuItem findItem;
        int size = size();
        for (int i2 = 0; i2 < size; i2++) {
            MenuItemImpl menuItemImpl = this.f2390f.get(i2);
            if (menuItemImpl.getItemId() == i) {
                return menuItemImpl;
            }
            if (menuItemImpl.hasSubMenu() && (findItem = menuItemImpl.getSubMenu().findItem(i)) != null) {
                return findItem;
            }
        }
        return null;
    }

    /* renamed from: g */
    public Drawable m8658g() {
        return this.f2399o;
    }

    @Override // android.view.Menu
    public MenuItem getItem(int i) {
        return this.f2390f.get(i);
    }

    /* renamed from: h */
    public CharSequence m8657h() {
        return this.f2398n;
    }

    @Override // android.view.Menu
    public boolean hasVisibleItems() {
        if (this.f2410z) {
            return true;
        }
        int size = size();
        for (int i = 0; i < size; i++) {
            if (this.f2390f.get(i).isVisible()) {
                return true;
            }
        }
        return false;
    }

    /* renamed from: i */
    public View m8656i() {
        return this.f2400p;
    }

    @Override // android.view.Menu
    public boolean isShortcutKey(int i, KeyEvent keyEvent) {
        return m8695a(i, keyEvent) != null;
    }

    /* renamed from: j */
    public ArrayList<MenuItemImpl> m8655j() {
        m8679b();
        return this.f2394j;
    }

    /* renamed from: k */
    public boolean m8654k() {
        return this.f2404t;
    }

    /* renamed from: l */
    public Resources m8653l() {
        return this.f2386b;
    }

    /* renamed from: m */
    public MenuBuilder mo8574m() {
        return this;
    }

    /* renamed from: n */
    public ArrayList<MenuItemImpl> m8652n() {
        if (this.f2392h) {
            this.f2391g.clear();
            int size = this.f2390f.size();
            for (int i = 0; i < size; i++) {
                MenuItemImpl menuItemImpl = this.f2390f.get(i);
                if (menuItemImpl.isVisible()) {
                    this.f2391g.add(menuItemImpl);
                }
            }
            this.f2392h = false;
            this.f2395k = true;
            return this.f2391g;
        }
        return this.f2391g;
    }

    /* renamed from: o */
    public boolean mo8573o() {
        return this.f2409y;
    }

    /* renamed from: p */
    public boolean mo8572p() {
        return this.f2387c;
    }

    @Override // android.view.Menu
    public boolean performIdentifierAction(int i, int i2) {
        return m8686a(findItem(i), i2);
    }

    @Override // android.view.Menu
    public boolean performShortcut(int i, KeyEvent keyEvent, int i2) {
        MenuItemImpl m8695a = m8695a(i, keyEvent);
        boolean m8686a = m8695a != null ? m8686a(m8695a, i2) : false;
        if ((i2 & 2) != 0) {
            m8680a(true);
        }
        return m8686a;
    }

    /* renamed from: q */
    public boolean mo8571q() {
        return this.f2388d;
    }

    /* renamed from: r */
    public void m8651r() {
        this.f2401q = false;
        if (this.f2402r) {
            this.f2402r = false;
            m8670c(this.f2403s);
        }
    }

    @Override // android.view.Menu
    public void removeGroup(int i) {
        int m8699a = m8699a(i);
        if (m8699a >= 0) {
            int size = this.f2390f.size() - m8699a;
            int i2 = 0;
            while (true) {
                int i3 = i2 + 1;
                if (i2 >= size || this.f2390f.get(m8699a).getGroupId() != i) {
                    break;
                }
                m8693a(m8699a, false);
                i2 = i3;
            }
            m8670c(true);
        }
    }

    @Override // android.view.Menu
    public void removeItem(int i) {
        m8693a(m8678b(i), true);
    }

    /* renamed from: s */
    public void m8650s() {
        if (this.f2401q) {
            return;
        }
        this.f2401q = true;
        this.f2402r = false;
        this.f2403s = false;
    }

    @Override // android.view.Menu
    public void setGroupCheckable(int i, boolean z, boolean z2) {
        int size = this.f2390f.size();
        for (int i2 = 0; i2 < size; i2++) {
            MenuItemImpl menuItemImpl = this.f2390f.get(i2);
            if (menuItemImpl.getGroupId() == i) {
                menuItemImpl.m8636c(z2);
                menuItemImpl.setCheckable(z);
            }
        }
    }

    @Override // android.view.Menu
    public void setGroupDividerEnabled(boolean z) {
        this.f2409y = z;
    }

    @Override // android.view.Menu
    public void setGroupEnabled(int i, boolean z) {
        int size = this.f2390f.size();
        for (int i2 = 0; i2 < size; i2++) {
            MenuItemImpl menuItemImpl = this.f2390f.get(i2);
            if (menuItemImpl.getGroupId() == i) {
                menuItemImpl.setEnabled(z);
            }
        }
    }

    @Override // android.view.Menu
    public void setGroupVisible(int i, boolean z) {
        int size = this.f2390f.size();
        boolean z2 = false;
        for (int i2 = 0; i2 < size; i2++) {
            MenuItemImpl menuItemImpl = this.f2390f.get(i2);
            if (menuItemImpl.getGroupId() == i && menuItemImpl.m8632e(z)) {
                z2 = true;
            }
        }
        if (z2) {
            m8670c(true);
        }
    }

    @Override // android.view.Menu
    public void setQwertyMode(boolean z) {
        this.f2387c = z;
        m8670c(false);
    }

    @Override // android.view.Menu
    public int size() {
        return this.f2390f.size();
    }

    /* renamed from: f */
    public static int m8660f(int i) {
        int i2 = ((-65536) & i) >> 16;
        if (i2 >= 0) {
            int[] iArr = f2384A;
            if (i2 < iArr.length) {
                return (i & 65535) | (iArr[i2] << 16);
            }
        }
        throw new IllegalArgumentException("order does not contain a valid category.");
    }

    /* renamed from: a */
    public void m8691a(MenuPresenter menuPresenter, Context context) {
        this.f2407w.add(new WeakReference<>(menuPresenter));
        menuPresenter.mo6280a(context, this);
        this.f2395k = true;
    }

    @Override // android.view.Menu
    public MenuItem add(int i) {
        return mo8696a(0, 0, 0, this.f2386b.getString(i));
    }

    @Override // android.view.Menu
    public SubMenu addSubMenu(int i) {
        return addSubMenu(0, 0, 0, this.f2386b.getString(i));
    }

    /* renamed from: c */
    public void m8671c(Bundle bundle) {
        MenuItem findItem;
        if (bundle == null) {
            return;
        }
        SparseArray<Parcelable> sparseParcelableArray = bundle.getSparseParcelableArray(mo8575d());
        int size = size();
        for (int i = 0; i < size; i++) {
            MenuItem item = getItem(i);
            View actionView = item.getActionView();
            if (actionView != null && actionView.getId() != -1) {
                actionView.restoreHierarchyState(sparseParcelableArray);
            }
            if (item.hasSubMenu()) {
                ((SubMenuBuilder) item.getSubMenu()).m8671c(bundle);
            }
        }
        int i2 = bundle.getInt("android:menu:expandedactionview");
        if (i2 <= 0 || (findItem = findItem(i2)) == null) {
            return;
        }
        findItem.expandActionView();
    }

    /* renamed from: d */
    public void m8668d(MenuItemImpl menuItemImpl) {
        this.f2392h = true;
        m8670c(true);
    }

    @Override // android.view.Menu
    public MenuItem add(int i, int i2, int i3, CharSequence charSequence) {
        return mo8696a(i, i2, i3, charSequence);
    }

    @Override // android.view.Menu
    public SubMenu addSubMenu(int i, int i2, int i3, CharSequence charSequence) {
        MenuItemImpl menuItemImpl = (MenuItemImpl) mo8696a(i, i2, i3, charSequence);
        SubMenuBuilder subMenuBuilder = new SubMenuBuilder(this.f2385a, this, menuItemImpl);
        menuItemImpl.m8644a(subMenuBuilder);
        return subMenuBuilder;
    }

    @Override // android.view.Menu
    public MenuItem add(int i, int i2, int i3, int i4) {
        return mo8696a(i, i2, i3, this.f2386b.getString(i4));
    }

    /* renamed from: b */
    public final void m8675b(boolean z) {
        if (this.f2407w.isEmpty()) {
            return;
        }
        m8650s();
        Iterator<WeakReference<MenuPresenter>> it = this.f2407w.iterator();
        while (it.hasNext()) {
            WeakReference<MenuPresenter> next = it.next();
            MenuPresenter menuPresenter = next.get();
            if (menuPresenter == null) {
                this.f2407w.remove(next);
            } else {
                menuPresenter.mo6278a(z);
            }
        }
        m8651r();
    }

    /* renamed from: d */
    public MenuBuilder m8669d(int i) {
        m8694a(0, null, i, null, null);
        return this;
    }

    /* renamed from: a */
    public final boolean m8690a(SubMenuBuilder subMenuBuilder, MenuPresenter menuPresenter) {
        if (this.f2407w.isEmpty()) {
            return false;
        }
        boolean mo6281a = menuPresenter != null ? menuPresenter.mo6281a(subMenuBuilder) : false;
        Iterator<WeakReference<MenuPresenter>> it = this.f2407w.iterator();
        while (it.hasNext()) {
            WeakReference<MenuPresenter> next = it.next();
            MenuPresenter menuPresenter2 = next.get();
            if (menuPresenter2 == null) {
                this.f2407w.remove(next);
            } else if (!mo6281a) {
                mo6281a = menuPresenter2.mo6281a(subMenuBuilder);
            }
        }
        return mo6281a;
    }

    /* renamed from: d */
    public void m8666d(boolean z) {
        this.f2410z = z;
    }

    /* renamed from: f */
    public MenuItemImpl m8661f() {
        return this.f2408x;
    }

    @Override // android.view.Menu
    public SubMenu addSubMenu(int i, int i2, int i3, int i4) {
        return addSubMenu(i, i2, i3, this.f2386b.getString(i4));
    }

    /* renamed from: a */
    public final void m8688a(Bundle bundle) {
        Parcelable parcelable;
        SparseArray sparseParcelableArray = bundle.getSparseParcelableArray("android:menu:presenters");
        if (sparseParcelableArray == null || this.f2407w.isEmpty()) {
            return;
        }
        Iterator<WeakReference<MenuPresenter>> it = this.f2407w.iterator();
        while (it.hasNext()) {
            WeakReference<MenuPresenter> next = it.next();
            MenuPresenter menuPresenter = next.get();
            if (menuPresenter == null) {
                this.f2407w.remove(next);
            } else {
                int mo6284a = menuPresenter.mo6284a();
                if (mo6284a > 0 && (parcelable = (Parcelable) sparseParcelableArray.get(mo6284a)) != null) {
                    menuPresenter.mo6279a(parcelable);
                }
            }
        }
    }

    /* renamed from: b */
    public final void m8676b(Bundle bundle) {
        Parcelable mo6275c;
        if (this.f2407w.isEmpty()) {
            return;
        }
        SparseArray<? extends Parcelable> sparseArray = new SparseArray<>();
        Iterator<WeakReference<MenuPresenter>> it = this.f2407w.iterator();
        while (it.hasNext()) {
            WeakReference<MenuPresenter> next = it.next();
            MenuPresenter menuPresenter = next.get();
            if (menuPresenter == null) {
                this.f2407w.remove(next);
            } else {
                int mo6284a = menuPresenter.mo6284a();
                if (mo6284a > 0 && (mo6275c = menuPresenter.mo6275c()) != null) {
                    sparseArray.put(mo6284a, mo6275c);
                }
            }
        }
        bundle.putSparseParcelableArray("android:menu:presenters", sparseArray);
    }

    /* renamed from: e */
    public final void m8662e(boolean z) {
        boolean z2 = true;
        this.f2388d = (z && this.f2386b.getConfiguration().keyboard != 1 && ViewConfigurationCompat.m9394d(ViewConfiguration.get(this.f2385a), this.f2385a)) ? false : false;
    }

    /* renamed from: c */
    public void m8670c(boolean z) {
        if (!this.f2401q) {
            if (z) {
                this.f2392h = true;
                this.f2395k = true;
            }
            m8675b(z);
            return;
        }
        this.f2402r = true;
        if (z) {
            this.f2403s = true;
        }
    }

    /* renamed from: e */
    public Context m8665e() {
        return this.f2385a;
    }

    /* renamed from: e */
    public MenuBuilder m8664e(int i) {
        m8694a(i, null, 0, null, null);
        return this;
    }

    /* renamed from: a */
    public void mo8579a(InterfaceC0425a interfaceC0425a) {
        this.f2389e = interfaceC0425a;
    }

    /* renamed from: a */
    public MenuItem mo8696a(int i, int i2, int i3, CharSequence charSequence) {
        int m8660f = m8660f(i3);
        MenuItemImpl m8697a = m8697a(i, i2, i3, m8660f, charSequence, this.f2396l);
        ContextMenu.ContextMenuInfo contextMenuInfo = this.f2397m;
        if (contextMenuInfo != null) {
            m8697a.m8642a(contextMenuInfo);
        }
        ArrayList<MenuItemImpl> arrayList = this.f2390f;
        arrayList.add(m8682a(arrayList, m8660f), m8697a);
        m8670c(true);
        return m8697a;
    }

    /* renamed from: b */
    public int m8678b(int i) {
        int size = size();
        for (int i2 = 0; i2 < size; i2++) {
            if (this.f2390f.get(i2).getItemId() == i) {
                return i2;
            }
        }
        return -1;
    }

    /* renamed from: c */
    public void m8672c(MenuItemImpl menuItemImpl) {
        this.f2395k = true;
        m8670c(true);
    }

    /* renamed from: b */
    public void m8679b() {
        ArrayList<MenuItemImpl> m8652n = m8652n();
        if (this.f2395k) {
            Iterator<WeakReference<MenuPresenter>> it = this.f2407w.iterator();
            boolean z = false;
            while (it.hasNext()) {
                WeakReference<MenuPresenter> next = it.next();
                MenuPresenter menuPresenter = next.get();
                if (menuPresenter == null) {
                    this.f2407w.remove(next);
                } else {
                    z |= menuPresenter.mo6277b();
                }
            }
            if (z) {
                this.f2393i.clear();
                this.f2394j.clear();
                int size = m8652n.size();
                for (int i = 0; i < size; i++) {
                    MenuItemImpl menuItemImpl = m8652n.get(i);
                    if (menuItemImpl.m8629h()) {
                        this.f2393i.add(menuItemImpl);
                    } else {
                        this.f2394j.add(menuItemImpl);
                    }
                }
            } else {
                this.f2393i.clear();
                this.f2394j.clear();
                this.f2394j.addAll(m8652n());
            }
            this.f2395k = false;
        }
    }

    /* renamed from: c */
    public ArrayList<MenuItemImpl> m8674c() {
        m8679b();
        return this.f2393i;
    }

    /* renamed from: a */
    public final MenuItemImpl m8697a(int i, int i2, int i3, int i4, CharSequence charSequence, int i5) {
        return new MenuItemImpl(this, i, i2, i3, i4, charSequence, i5);
    }

    /* renamed from: a */
    public final void m8693a(int i, boolean z) {
        if (i < 0 || i >= this.f2390f.size()) {
            return;
        }
        this.f2390f.remove(i);
        if (z) {
            m8670c(true);
        }
    }

    /* renamed from: a */
    public void m8687a(MenuItem menuItem) {
        int groupId = menuItem.getGroupId();
        int size = this.f2390f.size();
        m8650s();
        for (int i = 0; i < size; i++) {
            MenuItemImpl menuItemImpl = this.f2390f.get(i);
            if (menuItemImpl.getGroupId() == groupId && menuItemImpl.m8628i() && menuItemImpl.isCheckable()) {
                menuItemImpl.m8638b(menuItemImpl == menuItem);
            }
        }
        m8651r();
    }

    /* renamed from: a */
    public int m8699a(int i) {
        return m8698a(i, 0);
    }

    /* renamed from: a */
    public int m8698a(int i, int i2) {
        int size = size();
        if (i2 < 0) {
            i2 = 0;
        }
        while (i2 < size) {
            if (this.f2390f.get(i2).getGroupId() == i) {
                return i2;
            }
            i2++;
        }
        return -1;
    }

    /* renamed from: b */
    public boolean mo8576b(MenuItemImpl menuItemImpl) {
        boolean z = false;
        if (this.f2407w.isEmpty()) {
            return false;
        }
        m8650s();
        Iterator<WeakReference<MenuPresenter>> it = this.f2407w.iterator();
        while (it.hasNext()) {
            WeakReference<MenuPresenter> next = it.next();
            MenuPresenter menuPresenter = next.get();
            if (menuPresenter == null) {
                this.f2407w.remove(next);
            } else {
                z = menuPresenter.mo6283a(this, menuItemImpl);
                if (z) {
                    break;
                }
            }
        }
        m8651r();
        if (z) {
            this.f2408x = menuItemImpl;
        }
        return z;
    }

    /* renamed from: a */
    public boolean mo8578a(MenuBuilder menuBuilder, MenuItem menuItem) {
        InterfaceC0425a interfaceC0425a = this.f2389e;
        return interfaceC0425a != null && interfaceC0425a.mo7077a(menuBuilder, menuItem);
    }

    /* renamed from: a */
    public void m8700a() {
        InterfaceC0425a interfaceC0425a = this.f2389e;
        if (interfaceC0425a != null) {
            interfaceC0425a.mo7078a(this);
        }
    }

    /* renamed from: a */
    public static int m8682a(ArrayList<MenuItemImpl> arrayList, int i) {
        for (int size = arrayList.size() - 1; size >= 0; size--) {
            if (arrayList.get(size).m8637c() <= i) {
                return size + 1;
            }
        }
        return 0;
    }

    /* renamed from: a */
    public void m8681a(List<MenuItemImpl> list, int i, KeyEvent keyEvent) {
        boolean mo8572p = mo8572p();
        int modifiers = keyEvent.getModifiers();
        KeyCharacterMap.KeyData keyData = new KeyCharacterMap.KeyData();
        if (keyEvent.getKeyData(keyData) || i == 67) {
            int size = this.f2390f.size();
            for (int i2 = 0; i2 < size; i2++) {
                MenuItemImpl menuItemImpl = this.f2390f.get(i2);
                if (menuItemImpl.hasSubMenu()) {
                    ((MenuBuilder) menuItemImpl.getSubMenu()).m8681a(list, i, keyEvent);
                }
                char alphabeticShortcut = mo8572p ? menuItemImpl.getAlphabeticShortcut() : menuItemImpl.getNumericShortcut();
                if (((modifiers & 69647) == ((mo8572p ? menuItemImpl.getAlphabeticModifiers() : menuItemImpl.getNumericModifiers()) & 69647)) && alphabeticShortcut != 0) {
                    char[] cArr = keyData.meta;
                    if ((alphabeticShortcut == cArr[0] || alphabeticShortcut == cArr[2] || (mo8572p && alphabeticShortcut == '\b' && i == 67)) && menuItemImpl.isEnabled()) {
                        list.add(menuItemImpl);
                    }
                }
            }
        }
    }

    /* renamed from: a */
    public MenuItemImpl m8695a(int i, KeyEvent keyEvent) {
        char numericShortcut;
        ArrayList<MenuItemImpl> arrayList = this.f2406v;
        arrayList.clear();
        m8681a(arrayList, i, keyEvent);
        if (arrayList.isEmpty()) {
            return null;
        }
        int metaState = keyEvent.getMetaState();
        KeyCharacterMap.KeyData keyData = new KeyCharacterMap.KeyData();
        keyEvent.getKeyData(keyData);
        int size = arrayList.size();
        if (size == 1) {
            return arrayList.get(0);
        }
        boolean mo8572p = mo8572p();
        for (int i2 = 0; i2 < size; i2++) {
            MenuItemImpl menuItemImpl = arrayList.get(i2);
            if (mo8572p) {
                numericShortcut = menuItemImpl.getAlphabeticShortcut();
            } else {
                numericShortcut = menuItemImpl.getNumericShortcut();
            }
            if ((numericShortcut == keyData.meta[0] && (metaState & 2) == 0) || ((numericShortcut == keyData.meta[2] && (metaState & 2) != 0) || (mo8572p && numericShortcut == '\b' && i == 67))) {
                return menuItemImpl;
            }
        }
        return null;
    }

    /* renamed from: a */
    public boolean m8686a(MenuItem menuItem, int i) {
        return m8685a(menuItem, (MenuPresenter) null, i);
    }

    /* renamed from: a */
    public boolean m8685a(MenuItem menuItem, MenuPresenter menuPresenter, int i) {
        MenuItemImpl menuItemImpl = (MenuItemImpl) menuItem;
        if (menuItemImpl == null || !menuItemImpl.isEnabled()) {
            return false;
        }
        boolean m8630g = menuItemImpl.m8630g();
        ActionProvider mo8647a = menuItemImpl.mo8647a();
        boolean z = mo8647a != null && mo8647a.mo8621a();
        if (menuItemImpl.m8631f()) {
            m8630g |= menuItemImpl.expandActionView();
            if (m8630g) {
                m8680a(true);
            }
        } else if (menuItemImpl.hasSubMenu() || z) {
            if ((i & 4) == 0) {
                m8680a(false);
            }
            if (!menuItemImpl.hasSubMenu()) {
                menuItemImpl.m8644a(new SubMenuBuilder(m8665e(), this, menuItemImpl));
            }
            SubMenuBuilder subMenuBuilder = (SubMenuBuilder) menuItemImpl.getSubMenu();
            if (z) {
                mo8647a.mo8620a(subMenuBuilder);
            }
            m8630g |= m8690a(subMenuBuilder, menuPresenter);
            if (!m8630g) {
                m8680a(true);
            }
        } else if ((i & 1) == 0) {
            m8680a(true);
        }
        return m8630g;
    }

    /* renamed from: a */
    public final void m8680a(boolean z) {
        if (this.f2405u) {
            return;
        }
        this.f2405u = true;
        Iterator<WeakReference<MenuPresenter>> it = this.f2407w.iterator();
        while (it.hasNext()) {
            WeakReference<MenuPresenter> next = it.next();
            MenuPresenter menuPresenter = next.get();
            if (menuPresenter == null) {
                this.f2407w.remove(next);
            } else {
                menuPresenter.mo6282a(this, z);
            }
        }
        this.f2405u = false;
    }

    /* renamed from: a */
    public final void m8694a(int i, CharSequence charSequence, int i2, Drawable drawable, View view) {
        Resources m8653l = m8653l();
        if (view != null) {
            this.f2400p = view;
            this.f2398n = null;
            this.f2399o = null;
        } else {
            if (i > 0) {
                this.f2398n = m8653l.getText(i);
            } else if (charSequence != null) {
                this.f2398n = charSequence;
            }
            if (i2 > 0) {
                this.f2399o = ContextCompat.m10016c(m8665e(), i2);
            } else if (drawable != null) {
                this.f2399o = drawable;
            }
            this.f2400p = null;
        }
        m8670c(false);
    }

    /* renamed from: a */
    public MenuBuilder m8683a(CharSequence charSequence) {
        m8694a(0, charSequence, 0, null, null);
        return this;
    }

    /* renamed from: a */
    public MenuBuilder m8689a(Drawable drawable) {
        m8694a(0, null, 0, drawable, null);
        return this;
    }

    /* renamed from: a */
    public MenuBuilder m8684a(View view) {
        m8694a(0, null, 0, null, view);
        return this;
    }

    /* renamed from: a */
    public boolean mo8577a(MenuItemImpl menuItemImpl) {
        boolean z = false;
        if (!this.f2407w.isEmpty() && this.f2408x == menuItemImpl) {
            m8650s();
            Iterator<WeakReference<MenuPresenter>> it = this.f2407w.iterator();
            while (it.hasNext()) {
                WeakReference<MenuPresenter> next = it.next();
                MenuPresenter menuPresenter = next.get();
                if (menuPresenter == null) {
                    this.f2407w.remove(next);
                } else {
                    z = menuPresenter.mo6276b(this, menuItemImpl);
                    if (z) {
                        break;
                    }
                }
            }
            m8651r();
            if (z) {
                this.f2408x = null;
            }
        }
        return z;
    }
}
