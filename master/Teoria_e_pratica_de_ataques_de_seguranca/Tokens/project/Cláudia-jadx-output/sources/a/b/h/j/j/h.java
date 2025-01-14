package a.b.h.j.j;

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
/* compiled from: MenuBuilder.java */
/* loaded from: classes.dex */
public class h implements a.b.g.d.a.a {
    public static final int[] A = {1, 4, 5, 3, 2, 0};

    /* renamed from: a  reason: collision with root package name */
    public final Context f1581a;

    /* renamed from: b  reason: collision with root package name */
    public final Resources f1582b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f1583c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f1584d;

    /* renamed from: e  reason: collision with root package name */
    public a f1585e;
    public ContextMenu.ContextMenuInfo m;
    public CharSequence n;
    public Drawable o;
    public View p;
    public k x;
    public boolean z;
    public int l = 0;
    public boolean q = false;
    public boolean r = false;
    public boolean s = false;
    public boolean t = false;
    public boolean u = false;
    public ArrayList<k> v = new ArrayList<>();
    public CopyOnWriteArrayList<WeakReference<p>> w = new CopyOnWriteArrayList<>();
    public boolean y = false;

    /* renamed from: f  reason: collision with root package name */
    public ArrayList<k> f1586f = new ArrayList<>();

    /* renamed from: g  reason: collision with root package name */
    public ArrayList<k> f1587g = new ArrayList<>();

    /* renamed from: h  reason: collision with root package name */
    public boolean f1588h = true;

    /* renamed from: i  reason: collision with root package name */
    public ArrayList<k> f1589i = new ArrayList<>();
    public ArrayList<k> j = new ArrayList<>();
    public boolean k = true;

    /* compiled from: MenuBuilder.java */
    /* loaded from: classes.dex */
    public interface a {
        void a(h hVar);

        boolean a(h hVar, MenuItem menuItem);
    }

    /* compiled from: MenuBuilder.java */
    /* loaded from: classes.dex */
    public interface b {
        boolean a(k kVar);
    }

    public h(Context context) {
        this.f1581a = context;
        this.f1582b = context.getResources();
        e(true);
    }

    public void a(p pVar) {
        a(pVar, this.f1581a);
    }

    @Override // android.view.Menu
    public MenuItem add(CharSequence charSequence) {
        return a(0, 0, 0, charSequence);
    }

    @Override // android.view.Menu
    public int addIntentOptions(int i2, int i3, int i4, ComponentName componentName, Intent[] intentArr, Intent intent, int i5, MenuItem[] menuItemArr) {
        int i6;
        PackageManager packageManager = this.f1581a.getPackageManager();
        List<ResolveInfo> queryIntentActivityOptions = packageManager.queryIntentActivityOptions(componentName, intentArr, intent, 0);
        int size = queryIntentActivityOptions != null ? queryIntentActivityOptions.size() : 0;
        if ((i5 & 1) == 0) {
            removeGroup(i2);
        }
        for (int i7 = 0; i7 < size; i7++) {
            ResolveInfo resolveInfo = queryIntentActivityOptions.get(i7);
            int i8 = resolveInfo.specificIndex;
            Intent intent2 = new Intent(i8 < 0 ? intent : intentArr[i8]);
            intent2.setComponent(new ComponentName(resolveInfo.activityInfo.applicationInfo.packageName, resolveInfo.activityInfo.name));
            MenuItem intent3 = add(i2, i3, i4, resolveInfo.loadLabel(packageManager)).setIcon(resolveInfo.loadIcon(packageManager)).setIntent(intent2);
            if (menuItemArr != null && (i6 = resolveInfo.specificIndex) >= 0) {
                menuItemArr[i6] = intent3;
            }
        }
        return size;
    }

    @Override // android.view.Menu
    public SubMenu addSubMenu(CharSequence charSequence) {
        return addSubMenu(0, 0, 0, charSequence);
    }

    public void b(p pVar) {
        Iterator<WeakReference<p>> it = this.w.iterator();
        while (it.hasNext()) {
            WeakReference<p> next = it.next();
            p pVar2 = next.get();
            if (pVar2 == null || pVar2 == pVar) {
                this.w.remove(next);
            }
        }
    }

    public h c(int i2) {
        this.l = i2;
        return this;
    }

    @Override // android.view.Menu
    public void clear() {
        k kVar = this.x;
        if (kVar != null) {
            a(kVar);
        }
        this.f1586f.clear();
        c(true);
    }

    public void clearHeader() {
        this.o = null;
        this.n = null;
        this.p = null;
        c(false);
    }

    @Override // android.view.Menu
    public void close() {
        a(true);
    }

    public String d() {
        return "android:menu:actionviewstates";
    }

    public void d(Bundle bundle) {
        a(bundle);
    }

    public void e(Bundle bundle) {
        int size = size();
        SparseArray<? extends Parcelable> sparseArray = null;
        for (int i2 = 0; i2 < size; i2++) {
            MenuItem item = getItem(i2);
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
                ((v) item.getSubMenu()).e(bundle);
            }
        }
        if (sparseArray != null) {
            bundle.putSparseParcelableArray(d(), sparseArray);
        }
    }

    public void f(Bundle bundle) {
        b(bundle);
    }

    @Override // android.view.Menu
    public MenuItem findItem(int i2) {
        MenuItem findItem;
        int size = size();
        for (int i3 = 0; i3 < size; i3++) {
            k kVar = this.f1586f.get(i3);
            if (kVar.getItemId() == i2) {
                return kVar;
            }
            if (kVar.hasSubMenu() && (findItem = kVar.getSubMenu().findItem(i2)) != null) {
                return findItem;
            }
        }
        return null;
    }

    public Drawable g() {
        return this.o;
    }

    @Override // android.view.Menu
    public MenuItem getItem(int i2) {
        return this.f1586f.get(i2);
    }

    public CharSequence h() {
        return this.n;
    }

    @Override // android.view.Menu
    public boolean hasVisibleItems() {
        if (this.z) {
            return true;
        }
        int size = size();
        for (int i2 = 0; i2 < size; i2++) {
            if (this.f1586f.get(i2).isVisible()) {
                return true;
            }
        }
        return false;
    }

    public View i() {
        return this.p;
    }

    @Override // android.view.Menu
    public boolean isShortcutKey(int i2, KeyEvent keyEvent) {
        return a(i2, keyEvent) != null;
    }

    public ArrayList<k> j() {
        b();
        return this.j;
    }

    public boolean k() {
        return this.t;
    }

    public Resources l() {
        return this.f1582b;
    }

    public h m() {
        return this;
    }

    public ArrayList<k> n() {
        if (this.f1588h) {
            this.f1587g.clear();
            int size = this.f1586f.size();
            for (int i2 = 0; i2 < size; i2++) {
                k kVar = this.f1586f.get(i2);
                if (kVar.isVisible()) {
                    this.f1587g.add(kVar);
                }
            }
            this.f1588h = false;
            this.k = true;
            return this.f1587g;
        }
        return this.f1587g;
    }

    public boolean o() {
        return this.y;
    }

    public boolean p() {
        return this.f1583c;
    }

    @Override // android.view.Menu
    public boolean performIdentifierAction(int i2, int i3) {
        return a(findItem(i2), i3);
    }

    @Override // android.view.Menu
    public boolean performShortcut(int i2, KeyEvent keyEvent, int i3) {
        k a2 = a(i2, keyEvent);
        boolean a3 = a2 != null ? a(a2, i3) : false;
        if ((i3 & 2) != 0) {
            a(true);
        }
        return a3;
    }

    public boolean q() {
        return this.f1584d;
    }

    public void r() {
        this.q = false;
        if (this.r) {
            this.r = false;
            c(this.s);
        }
    }

    @Override // android.view.Menu
    public void removeGroup(int i2) {
        int a2 = a(i2);
        if (a2 >= 0) {
            int size = this.f1586f.size() - a2;
            int i3 = 0;
            while (true) {
                int i4 = i3 + 1;
                if (i3 >= size || this.f1586f.get(a2).getGroupId() != i2) {
                    break;
                }
                a(a2, false);
                i3 = i4;
            }
            c(true);
        }
    }

    @Override // android.view.Menu
    public void removeItem(int i2) {
        a(b(i2), true);
    }

    public void s() {
        if (this.q) {
            return;
        }
        this.q = true;
        this.r = false;
        this.s = false;
    }

    @Override // android.view.Menu
    public void setGroupCheckable(int i2, boolean z, boolean z2) {
        int size = this.f1586f.size();
        for (int i3 = 0; i3 < size; i3++) {
            k kVar = this.f1586f.get(i3);
            if (kVar.getGroupId() == i2) {
                kVar.c(z2);
                kVar.setCheckable(z);
            }
        }
    }

    @Override // android.view.Menu
    public void setGroupDividerEnabled(boolean z) {
        this.y = z;
    }

    @Override // android.view.Menu
    public void setGroupEnabled(int i2, boolean z) {
        int size = this.f1586f.size();
        for (int i3 = 0; i3 < size; i3++) {
            k kVar = this.f1586f.get(i3);
            if (kVar.getGroupId() == i2) {
                kVar.setEnabled(z);
            }
        }
    }

    @Override // android.view.Menu
    public void setGroupVisible(int i2, boolean z) {
        int size = this.f1586f.size();
        boolean z2 = false;
        for (int i3 = 0; i3 < size; i3++) {
            k kVar = this.f1586f.get(i3);
            if (kVar.getGroupId() == i2 && kVar.e(z)) {
                z2 = true;
            }
        }
        if (z2) {
            c(true);
        }
    }

    @Override // android.view.Menu
    public void setQwertyMode(boolean z) {
        this.f1583c = z;
        c(false);
    }

    @Override // android.view.Menu
    public int size() {
        return this.f1586f.size();
    }

    public static int f(int i2) {
        int i3 = ((-65536) & i2) >> 16;
        if (i3 >= 0) {
            int[] iArr = A;
            if (i3 < iArr.length) {
                return (i2 & 65535) | (iArr[i3] << 16);
            }
        }
        throw new IllegalArgumentException("order does not contain a valid category.");
    }

    public void a(p pVar, Context context) {
        this.w.add(new WeakReference<>(pVar));
        pVar.a(context, this);
        this.k = true;
    }

    @Override // android.view.Menu
    public MenuItem add(int i2) {
        return a(0, 0, 0, this.f1582b.getString(i2));
    }

    @Override // android.view.Menu
    public SubMenu addSubMenu(int i2) {
        return addSubMenu(0, 0, 0, this.f1582b.getString(i2));
    }

    public void c(Bundle bundle) {
        MenuItem findItem;
        if (bundle == null) {
            return;
        }
        SparseArray<Parcelable> sparseParcelableArray = bundle.getSparseParcelableArray(d());
        int size = size();
        for (int i2 = 0; i2 < size; i2++) {
            MenuItem item = getItem(i2);
            View actionView = item.getActionView();
            if (actionView != null && actionView.getId() != -1) {
                actionView.restoreHierarchyState(sparseParcelableArray);
            }
            if (item.hasSubMenu()) {
                ((v) item.getSubMenu()).c(bundle);
            }
        }
        int i3 = bundle.getInt("android:menu:expandedactionview");
        if (i3 <= 0 || (findItem = findItem(i3)) == null) {
            return;
        }
        findItem.expandActionView();
    }

    public void d(k kVar) {
        this.f1588h = true;
        c(true);
    }

    @Override // android.view.Menu
    public MenuItem add(int i2, int i3, int i4, CharSequence charSequence) {
        return a(i2, i3, i4, charSequence);
    }

    @Override // android.view.Menu
    public SubMenu addSubMenu(int i2, int i3, int i4, CharSequence charSequence) {
        k kVar = (k) a(i2, i3, i4, charSequence);
        v vVar = new v(this.f1581a, this, kVar);
        kVar.a(vVar);
        return vVar;
    }

    @Override // android.view.Menu
    public MenuItem add(int i2, int i3, int i4, int i5) {
        return a(i2, i3, i4, this.f1582b.getString(i5));
    }

    public final void b(boolean z) {
        if (this.w.isEmpty()) {
            return;
        }
        s();
        Iterator<WeakReference<p>> it = this.w.iterator();
        while (it.hasNext()) {
            WeakReference<p> next = it.next();
            p pVar = next.get();
            if (pVar == null) {
                this.w.remove(next);
            } else {
                pVar.a(z);
            }
        }
        r();
    }

    public h d(int i2) {
        a(0, null, i2, null, null);
        return this;
    }

    public final boolean a(v vVar, p pVar) {
        if (this.w.isEmpty()) {
            return false;
        }
        boolean a2 = pVar != null ? pVar.a(vVar) : false;
        Iterator<WeakReference<p>> it = this.w.iterator();
        while (it.hasNext()) {
            WeakReference<p> next = it.next();
            p pVar2 = next.get();
            if (pVar2 == null) {
                this.w.remove(next);
            } else if (!a2) {
                a2 = pVar2.a(vVar);
            }
        }
        return a2;
    }

    public void d(boolean z) {
        this.z = z;
    }

    public k f() {
        return this.x;
    }

    @Override // android.view.Menu
    public SubMenu addSubMenu(int i2, int i3, int i4, int i5) {
        return addSubMenu(i2, i3, i4, this.f1582b.getString(i5));
    }

    public final void a(Bundle bundle) {
        Parcelable parcelable;
        SparseArray sparseParcelableArray = bundle.getSparseParcelableArray("android:menu:presenters");
        if (sparseParcelableArray == null || this.w.isEmpty()) {
            return;
        }
        Iterator<WeakReference<p>> it = this.w.iterator();
        while (it.hasNext()) {
            WeakReference<p> next = it.next();
            p pVar = next.get();
            if (pVar == null) {
                this.w.remove(next);
            } else {
                int a2 = pVar.a();
                if (a2 > 0 && (parcelable = (Parcelable) sparseParcelableArray.get(a2)) != null) {
                    pVar.a(parcelable);
                }
            }
        }
    }

    public final void b(Bundle bundle) {
        Parcelable c2;
        if (this.w.isEmpty()) {
            return;
        }
        SparseArray<? extends Parcelable> sparseArray = new SparseArray<>();
        Iterator<WeakReference<p>> it = this.w.iterator();
        while (it.hasNext()) {
            WeakReference<p> next = it.next();
            p pVar = next.get();
            if (pVar == null) {
                this.w.remove(next);
            } else {
                int a2 = pVar.a();
                if (a2 > 0 && (c2 = pVar.c()) != null) {
                    sparseArray.put(a2, c2);
                }
            }
        }
        bundle.putSparseParcelableArray("android:menu:presenters", sparseArray);
    }

    public final void e(boolean z) {
        boolean z2 = true;
        this.f1584d = (z && this.f1582b.getConfiguration().keyboard != 1 && a.b.g.k.v.d(ViewConfiguration.get(this.f1581a), this.f1581a)) ? false : false;
    }

    public void c(boolean z) {
        if (!this.q) {
            if (z) {
                this.f1588h = true;
                this.k = true;
            }
            b(z);
            return;
        }
        this.r = true;
        if (z) {
            this.s = true;
        }
    }

    public Context e() {
        return this.f1581a;
    }

    public h e(int i2) {
        a(i2, null, 0, null, null);
        return this;
    }

    public void a(a aVar) {
        this.f1585e = aVar;
    }

    public MenuItem a(int i2, int i3, int i4, CharSequence charSequence) {
        int f2 = f(i4);
        k a2 = a(i2, i3, i4, f2, charSequence, this.l);
        ContextMenu.ContextMenuInfo contextMenuInfo = this.m;
        if (contextMenuInfo != null) {
            a2.a(contextMenuInfo);
        }
        ArrayList<k> arrayList = this.f1586f;
        arrayList.add(a(arrayList, f2), a2);
        c(true);
        return a2;
    }

    public int b(int i2) {
        int size = size();
        for (int i3 = 0; i3 < size; i3++) {
            if (this.f1586f.get(i3).getItemId() == i2) {
                return i3;
            }
        }
        return -1;
    }

    public void c(k kVar) {
        this.k = true;
        c(true);
    }

    public void b() {
        ArrayList<k> n = n();
        if (this.k) {
            Iterator<WeakReference<p>> it = this.w.iterator();
            boolean z = false;
            while (it.hasNext()) {
                WeakReference<p> next = it.next();
                p pVar = next.get();
                if (pVar == null) {
                    this.w.remove(next);
                } else {
                    z |= pVar.b();
                }
            }
            if (z) {
                this.f1589i.clear();
                this.j.clear();
                int size = n.size();
                for (int i2 = 0; i2 < size; i2++) {
                    k kVar = n.get(i2);
                    if (kVar.h()) {
                        this.f1589i.add(kVar);
                    } else {
                        this.j.add(kVar);
                    }
                }
            } else {
                this.f1589i.clear();
                this.j.clear();
                this.j.addAll(n());
            }
            this.k = false;
        }
    }

    public ArrayList<k> c() {
        b();
        return this.f1589i;
    }

    public final k a(int i2, int i3, int i4, int i5, CharSequence charSequence, int i6) {
        return new k(this, i2, i3, i4, i5, charSequence, i6);
    }

    public final void a(int i2, boolean z) {
        if (i2 < 0 || i2 >= this.f1586f.size()) {
            return;
        }
        this.f1586f.remove(i2);
        if (z) {
            c(true);
        }
    }

    public void a(MenuItem menuItem) {
        int groupId = menuItem.getGroupId();
        int size = this.f1586f.size();
        s();
        for (int i2 = 0; i2 < size; i2++) {
            k kVar = this.f1586f.get(i2);
            if (kVar.getGroupId() == groupId && kVar.i() && kVar.isCheckable()) {
                kVar.b(kVar == menuItem);
            }
        }
        r();
    }

    public int a(int i2) {
        return a(i2, 0);
    }

    public int a(int i2, int i3) {
        int size = size();
        if (i3 < 0) {
            i3 = 0;
        }
        while (i3 < size) {
            if (this.f1586f.get(i3).getGroupId() == i2) {
                return i3;
            }
            i3++;
        }
        return -1;
    }

    public boolean b(k kVar) {
        boolean z = false;
        if (this.w.isEmpty()) {
            return false;
        }
        s();
        Iterator<WeakReference<p>> it = this.w.iterator();
        while (it.hasNext()) {
            WeakReference<p> next = it.next();
            p pVar = next.get();
            if (pVar == null) {
                this.w.remove(next);
            } else {
                z = pVar.a(this, kVar);
                if (z) {
                    break;
                }
            }
        }
        r();
        if (z) {
            this.x = kVar;
        }
        return z;
    }

    public boolean a(h hVar, MenuItem menuItem) {
        a aVar = this.f1585e;
        return aVar != null && aVar.a(hVar, menuItem);
    }

    public void a() {
        a aVar = this.f1585e;
        if (aVar != null) {
            aVar.a(this);
        }
    }

    public static int a(ArrayList<k> arrayList, int i2) {
        for (int size = arrayList.size() - 1; size >= 0; size--) {
            if (arrayList.get(size).c() <= i2) {
                return size + 1;
            }
        }
        return 0;
    }

    public void a(List<k> list, int i2, KeyEvent keyEvent) {
        boolean p = p();
        int modifiers = keyEvent.getModifiers();
        KeyCharacterMap.KeyData keyData = new KeyCharacterMap.KeyData();
        if (keyEvent.getKeyData(keyData) || i2 == 67) {
            int size = this.f1586f.size();
            for (int i3 = 0; i3 < size; i3++) {
                k kVar = this.f1586f.get(i3);
                if (kVar.hasSubMenu()) {
                    ((h) kVar.getSubMenu()).a(list, i2, keyEvent);
                }
                char alphabeticShortcut = p ? kVar.getAlphabeticShortcut() : kVar.getNumericShortcut();
                if (((modifiers & 69647) == ((p ? kVar.getAlphabeticModifiers() : kVar.getNumericModifiers()) & 69647)) && alphabeticShortcut != 0) {
                    char[] cArr = keyData.meta;
                    if ((alphabeticShortcut == cArr[0] || alphabeticShortcut == cArr[2] || (p && alphabeticShortcut == '\b' && i2 == 67)) && kVar.isEnabled()) {
                        list.add(kVar);
                    }
                }
            }
        }
    }

    public k a(int i2, KeyEvent keyEvent) {
        char numericShortcut;
        ArrayList<k> arrayList = this.v;
        arrayList.clear();
        a(arrayList, i2, keyEvent);
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
        boolean p = p();
        for (int i3 = 0; i3 < size; i3++) {
            k kVar = arrayList.get(i3);
            if (p) {
                numericShortcut = kVar.getAlphabeticShortcut();
            } else {
                numericShortcut = kVar.getNumericShortcut();
            }
            if ((numericShortcut == keyData.meta[0] && (metaState & 2) == 0) || ((numericShortcut == keyData.meta[2] && (metaState & 2) != 0) || (p && numericShortcut == '\b' && i2 == 67))) {
                return kVar;
            }
        }
        return null;
    }

    public boolean a(MenuItem menuItem, int i2) {
        return a(menuItem, (p) null, i2);
    }

    public boolean a(MenuItem menuItem, p pVar, int i2) {
        k kVar = (k) menuItem;
        if (kVar == null || !kVar.isEnabled()) {
            return false;
        }
        boolean g2 = kVar.g();
        a.b.g.k.c a2 = kVar.a();
        boolean z = a2 != null && a2.a();
        if (kVar.f()) {
            g2 |= kVar.expandActionView();
            if (g2) {
                a(true);
            }
        } else if (kVar.hasSubMenu() || z) {
            if ((i2 & 4) == 0) {
                a(false);
            }
            if (!kVar.hasSubMenu()) {
                kVar.a(new v(e(), this, kVar));
            }
            v vVar = (v) kVar.getSubMenu();
            if (z) {
                a2.a(vVar);
            }
            g2 |= a(vVar, pVar);
            if (!g2) {
                a(true);
            }
        } else if ((i2 & 1) == 0) {
            a(true);
        }
        return g2;
    }

    public final void a(boolean z) {
        if (this.u) {
            return;
        }
        this.u = true;
        Iterator<WeakReference<p>> it = this.w.iterator();
        while (it.hasNext()) {
            WeakReference<p> next = it.next();
            p pVar = next.get();
            if (pVar == null) {
                this.w.remove(next);
            } else {
                pVar.a(this, z);
            }
        }
        this.u = false;
    }

    public final void a(int i2, CharSequence charSequence, int i3, Drawable drawable, View view) {
        Resources l = l();
        if (view != null) {
            this.p = view;
            this.n = null;
            this.o = null;
        } else {
            if (i2 > 0) {
                this.n = l.getText(i2);
            } else if (charSequence != null) {
                this.n = charSequence;
            }
            if (i3 > 0) {
                this.o = a.b.g.b.b.c(e(), i3);
            } else if (drawable != null) {
                this.o = drawable;
            }
            this.p = null;
        }
        c(false);
    }

    public h a(CharSequence charSequence) {
        a(0, charSequence, 0, null, null);
        return this;
    }

    public h a(Drawable drawable) {
        a(0, null, 0, drawable, null);
        return this;
    }

    public h a(View view) {
        a(0, null, 0, null, view);
        return this;
    }

    public boolean a(k kVar) {
        boolean z = false;
        if (!this.w.isEmpty() && this.x == kVar) {
            s();
            Iterator<WeakReference<p>> it = this.w.iterator();
            while (it.hasNext()) {
                WeakReference<p> next = it.next();
                p pVar = next.get();
                if (pVar == null) {
                    this.w.remove(next);
                } else {
                    z = pVar.b(this, kVar);
                    if (z) {
                        break;
                    }
                }
            }
            r();
            if (z) {
                this.x = null;
            }
        }
        return z;
    }
}
