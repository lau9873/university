package p000a.p006b.p049h.p061j;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.graphics.PorterDuff;
import android.util.AttributeSet;
import android.util.Log;
import android.util.Xml;
import android.view.InflateException;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import org.xmlpull.v1.XmlPullParserException;
import p000a.p006b.p030g.p036d.p037a.SupportMenu;
import p000a.p006b.p030g.p045k.ActionProvider;
import p000a.p006b.p030g.p045k.MenuItemCompat;
import p000a.p006b.p049h.p051b.C0363j;
import p000a.p006b.p049h.p061j.p062j.MenuItemImpl;
import p000a.p006b.p049h.p061j.p062j.MenuItemWrapperICS;
import p000a.p006b.p049h.p063k.C0475k0;

/* renamed from: a.b.h.j.g */
/* loaded from: classes.dex */
public class SupportMenuInflater extends MenuInflater {

    /* renamed from: e */
    public static final Class<?>[] f2246e = {Context.class};

    /* renamed from: f */
    public static final Class<?>[] f2247f = f2246e;

    /* renamed from: a */
    public final Object[] f2248a;

    /* renamed from: b */
    public final Object[] f2249b;

    /* renamed from: c */
    public Context f2250c;

    /* renamed from: d */
    public Object f2251d;

    /* compiled from: SupportMenuInflater.java */
    /* renamed from: a.b.h.j.g$a */
    /* loaded from: classes.dex */
    public static class MenuItem$OnMenuItemClickListenerC0416a implements MenuItem.OnMenuItemClickListener {

        /* renamed from: c */
        public static final Class<?>[] f2252c = {MenuItem.class};

        /* renamed from: a */
        public Object f2253a;

        /* renamed from: b */
        public Method f2254b;

        public MenuItem$OnMenuItemClickListenerC0416a(Object obj, String str) {
            this.f2253a = obj;
            Class<?> cls = obj.getClass();
            try {
                this.f2254b = cls.getMethod(str, f2252c);
            } catch (Exception e) {
                InflateException inflateException = new InflateException("Couldn't resolve menu item onClick handler " + str + " in class " + cls.getName());
                inflateException.initCause(e);
                throw inflateException;
            }
        }

        @Override // android.view.MenuItem.OnMenuItemClickListener
        public boolean onMenuItemClick(MenuItem menuItem) {
            try {
                if (this.f2254b.getReturnType() == Boolean.TYPE) {
                    return ((Boolean) this.f2254b.invoke(this.f2253a, menuItem)).booleanValue();
                }
                this.f2254b.invoke(this.f2253a, menuItem);
                return true;
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
    }

    public SupportMenuInflater(Context context) {
        super(context);
        this.f2250c = context;
        this.f2248a = new Object[]{context};
        this.f2249b = this.f2248a;
    }

    /* JADX WARN: Code restructure failed: missing block: B:12:0x003b, code lost:
        r6 = r15;
        r8 = null;
        r15 = false;
        r7 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:13:0x0041, code lost:
        if (r15 != false) goto L64;
     */
    /* JADX WARN: Code restructure failed: missing block: B:14:0x0043, code lost:
        if (r6 == 1) goto L60;
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x0049, code lost:
        if (r6 == 2) goto L44;
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x004c, code lost:
        if (r6 == 3) goto L14;
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x0050, code lost:
        r6 = r13.getName();
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x0054, code lost:
        if (r7 == false) goto L21;
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x005a, code lost:
        if (r6.equals(r8) == false) goto L21;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x005c, code lost:
        r8 = null;
        r7 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x0063, code lost:
        if (r6.equals("group") == false) goto L25;
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x0065, code lost:
        r0.m8736d();
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x006d, code lost:
        if (r6.equals("item") == false) goto L38;
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x0073, code lost:
        if (r0.m8737c() != false) goto L37;
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x0075, code lost:
        r6 = r0.f2255A;
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x0077, code lost:
        if (r6 == null) goto L35;
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x007d, code lost:
        if (r6.mo8621a() == false) goto L35;
     */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x007f, code lost:
        r0.m8739b();
     */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x0083, code lost:
        r0.m8744a();
     */
    /* JADX WARN: Code restructure failed: missing block: B:39:0x008b, code lost:
        if (r6.equals("menu") == false) goto L42;
     */
    /* JADX WARN: Code restructure failed: missing block: B:40:0x008d, code lost:
        r15 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:41:0x008f, code lost:
        if (r7 == false) goto L45;
     */
    /* JADX WARN: Code restructure failed: missing block: B:43:0x0092, code lost:
        r6 = r13.getName();
     */
    /* JADX WARN: Code restructure failed: missing block: B:44:0x009a, code lost:
        if (r6.equals("group") == false) goto L49;
     */
    /* JADX WARN: Code restructure failed: missing block: B:45:0x009c, code lost:
        r0.m8743a(r14);
     */
    /* JADX WARN: Code restructure failed: missing block: B:47:0x00a4, code lost:
        if (r6.equals("item") == false) goto L53;
     */
    /* JADX WARN: Code restructure failed: missing block: B:48:0x00a6, code lost:
        r0.m8738b(r14);
     */
    /* JADX WARN: Code restructure failed: missing block: B:50:0x00ae, code lost:
        if (r6.equals("menu") == false) goto L57;
     */
    /* JADX WARN: Code restructure failed: missing block: B:51:0x00b0, code lost:
        m8745a(r13, r14, r0.m8739b());
     */
    /* JADX WARN: Code restructure failed: missing block: B:52:0x00b8, code lost:
        r8 = r6;
        r7 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:53:0x00ba, code lost:
        r6 = r13.next();
     */
    /* JADX WARN: Code restructure failed: missing block: B:55:0x00c6, code lost:
        throw new java.lang.RuntimeException("Unexpected end of document");
     */
    /* JADX WARN: Code restructure failed: missing block: B:56:0x00c7, code lost:
        return;
     */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void m8745a(org.xmlpull.v1.XmlPullParser r13, android.util.AttributeSet r14, android.view.Menu r15) {
        /*
            r12 = this;
            a.b.h.j.g$b r0 = new a.b.h.j.g$b
            r0.<init>(r15)
            int r15 = r13.getEventType()
        L9:
            r1 = 2
            java.lang.String r2 = "menu"
            r3 = 1
            if (r15 != r1) goto L35
            java.lang.String r15 = r13.getName()
            boolean r4 = r15.equals(r2)
            if (r4 == 0) goto L1e
            int r15 = r13.next()
            goto L3b
        L1e:
            java.lang.RuntimeException r13 = new java.lang.RuntimeException
            java.lang.StringBuilder r14 = new java.lang.StringBuilder
            r14.<init>()
            java.lang.String r0 = "Expecting menu, got "
            r14.append(r0)
            r14.append(r15)
            java.lang.String r14 = r14.toString()
            r13.<init>(r14)
            throw r13
        L35:
            int r15 = r13.next()
            if (r15 != r3) goto L9
        L3b:
            r4 = 0
            r5 = 0
            r6 = r15
            r8 = r4
            r15 = 0
            r7 = 0
        L41:
            if (r15 != 0) goto Lc7
            if (r6 == r3) goto Lbf
            java.lang.String r9 = "item"
            java.lang.String r10 = "group"
            if (r6 == r1) goto L8f
            r11 = 3
            if (r6 == r11) goto L50
            goto Lba
        L50:
            java.lang.String r6 = r13.getName()
            if (r7 == 0) goto L5f
            boolean r11 = r6.equals(r8)
            if (r11 == 0) goto L5f
            r8 = r4
            r7 = 0
            goto Lba
        L5f:
            boolean r10 = r6.equals(r10)
            if (r10 == 0) goto L69
            r0.m8736d()
            goto Lba
        L69:
            boolean r9 = r6.equals(r9)
            if (r9 == 0) goto L87
            boolean r6 = r0.m8737c()
            if (r6 != 0) goto Lba
            a.b.g.k.c r6 = r0.f2255A
            if (r6 == 0) goto L83
            boolean r6 = r6.mo8621a()
            if (r6 == 0) goto L83
            r0.m8739b()
            goto Lba
        L83:
            r0.m8744a()
            goto Lba
        L87:
            boolean r6 = r6.equals(r2)
            if (r6 == 0) goto Lba
            r15 = 1
            goto Lba
        L8f:
            if (r7 == 0) goto L92
            goto Lba
        L92:
            java.lang.String r6 = r13.getName()
            boolean r10 = r6.equals(r10)
            if (r10 == 0) goto La0
            r0.m8743a(r14)
            goto Lba
        La0:
            boolean r9 = r6.equals(r9)
            if (r9 == 0) goto Laa
            r0.m8738b(r14)
            goto Lba
        Laa:
            boolean r9 = r6.equals(r2)
            if (r9 == 0) goto Lb8
            android.view.SubMenu r6 = r0.m8739b()
            r12.m8745a(r13, r14, r6)
            goto Lba
        Lb8:
            r8 = r6
            r7 = 1
        Lba:
            int r6 = r13.next()
            goto L41
        Lbf:
            java.lang.RuntimeException r13 = new java.lang.RuntimeException
            java.lang.String r14 = "Unexpected end of document"
            r13.<init>(r14)
            throw r13
        Lc7:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: p000a.p006b.p049h.p061j.SupportMenuInflater.m8745a(org.xmlpull.v1.XmlPullParser, android.util.AttributeSet, android.view.Menu):void");
    }

    @Override // android.view.MenuInflater
    public void inflate(int i, Menu menu) {
        if (!(menu instanceof SupportMenu)) {
            super.inflate(i, menu);
            return;
        }
        XmlResourceParser xmlResourceParser = null;
        try {
            try {
                try {
                    xmlResourceParser = this.f2250c.getResources().getLayout(i);
                    m8745a(xmlResourceParser, Xml.asAttributeSet(xmlResourceParser), menu);
                } catch (IOException e) {
                    throw new InflateException("Error inflating menu XML", e);
                }
            } catch (XmlPullParserException e2) {
                throw new InflateException("Error inflating menu XML", e2);
            }
        } finally {
            if (xmlResourceParser != null) {
                xmlResourceParser.close();
            }
        }
    }

    /* compiled from: SupportMenuInflater.java */
    /* renamed from: a.b.h.j.g$b */
    /* loaded from: classes.dex */
    public class C0417b {

        /* renamed from: A */
        public ActionProvider f2255A;

        /* renamed from: B */
        public CharSequence f2256B;

        /* renamed from: C */
        public CharSequence f2257C;

        /* renamed from: D */
        public ColorStateList f2258D = null;

        /* renamed from: E */
        public PorterDuff.Mode f2259E = null;

        /* renamed from: a */
        public Menu f2261a;

        /* renamed from: b */
        public int f2262b;

        /* renamed from: c */
        public int f2263c;

        /* renamed from: d */
        public int f2264d;

        /* renamed from: e */
        public int f2265e;

        /* renamed from: f */
        public boolean f2266f;

        /* renamed from: g */
        public boolean f2267g;

        /* renamed from: h */
        public boolean f2268h;

        /* renamed from: i */
        public int f2269i;

        /* renamed from: j */
        public int f2270j;

        /* renamed from: k */
        public CharSequence f2271k;

        /* renamed from: l */
        public CharSequence f2272l;

        /* renamed from: m */
        public int f2273m;

        /* renamed from: n */
        public char f2274n;

        /* renamed from: o */
        public int f2275o;

        /* renamed from: p */
        public char f2276p;

        /* renamed from: q */
        public int f2277q;

        /* renamed from: r */
        public int f2278r;

        /* renamed from: s */
        public boolean f2279s;

        /* renamed from: t */
        public boolean f2280t;

        /* renamed from: u */
        public boolean f2281u;

        /* renamed from: v */
        public int f2282v;

        /* renamed from: w */
        public int f2283w;

        /* renamed from: x */
        public String f2284x;

        /* renamed from: y */
        public String f2285y;

        /* renamed from: z */
        public String f2286z;

        public C0417b(Menu menu) {
            this.f2261a = menu;
            m8736d();
        }

        /* renamed from: a */
        public void m8743a(AttributeSet attributeSet) {
            TypedArray obtainStyledAttributes = SupportMenuInflater.this.f2250c.obtainStyledAttributes(attributeSet, C0363j.MenuGroup);
            this.f2262b = obtainStyledAttributes.getResourceId(C0363j.MenuGroup_android_id, 0);
            this.f2263c = obtainStyledAttributes.getInt(C0363j.MenuGroup_android_menuCategory, 0);
            this.f2264d = obtainStyledAttributes.getInt(C0363j.MenuGroup_android_orderInCategory, 0);
            this.f2265e = obtainStyledAttributes.getInt(C0363j.MenuGroup_android_checkableBehavior, 0);
            this.f2266f = obtainStyledAttributes.getBoolean(C0363j.MenuGroup_android_visible, true);
            this.f2267g = obtainStyledAttributes.getBoolean(C0363j.MenuGroup_android_enabled, true);
            obtainStyledAttributes.recycle();
        }

        /* renamed from: b */
        public void m8738b(AttributeSet attributeSet) {
            TypedArray obtainStyledAttributes = SupportMenuInflater.this.f2250c.obtainStyledAttributes(attributeSet, C0363j.MenuItem);
            this.f2269i = obtainStyledAttributes.getResourceId(C0363j.MenuItem_android_id, 0);
            this.f2270j = (obtainStyledAttributes.getInt(C0363j.MenuItem_android_menuCategory, this.f2263c) & (-65536)) | (obtainStyledAttributes.getInt(C0363j.MenuItem_android_orderInCategory, this.f2264d) & 65535);
            this.f2271k = obtainStyledAttributes.getText(C0363j.MenuItem_android_title);
            this.f2272l = obtainStyledAttributes.getText(C0363j.MenuItem_android_titleCondensed);
            this.f2273m = obtainStyledAttributes.getResourceId(C0363j.MenuItem_android_icon, 0);
            this.f2274n = m8741a(obtainStyledAttributes.getString(C0363j.MenuItem_android_alphabeticShortcut));
            this.f2275o = obtainStyledAttributes.getInt(C0363j.MenuItem_alphabeticModifiers, 4096);
            this.f2276p = m8741a(obtainStyledAttributes.getString(C0363j.MenuItem_android_numericShortcut));
            this.f2277q = obtainStyledAttributes.getInt(C0363j.MenuItem_numericModifiers, 4096);
            if (obtainStyledAttributes.hasValue(C0363j.MenuItem_android_checkable)) {
                this.f2278r = obtainStyledAttributes.getBoolean(C0363j.MenuItem_android_checkable, false) ? 1 : 0;
            } else {
                this.f2278r = this.f2265e;
            }
            this.f2279s = obtainStyledAttributes.getBoolean(C0363j.MenuItem_android_checked, false);
            this.f2280t = obtainStyledAttributes.getBoolean(C0363j.MenuItem_android_visible, this.f2266f);
            this.f2281u = obtainStyledAttributes.getBoolean(C0363j.MenuItem_android_enabled, this.f2267g);
            this.f2282v = obtainStyledAttributes.getInt(C0363j.MenuItem_showAsAction, -1);
            this.f2286z = obtainStyledAttributes.getString(C0363j.MenuItem_android_onClick);
            this.f2283w = obtainStyledAttributes.getResourceId(C0363j.MenuItem_actionLayout, 0);
            this.f2284x = obtainStyledAttributes.getString(C0363j.MenuItem_actionViewClass);
            this.f2285y = obtainStyledAttributes.getString(C0363j.MenuItem_actionProviderClass);
            boolean z = this.f2285y != null;
            if (z && this.f2283w == 0 && this.f2284x == null) {
                this.f2255A = (ActionProvider) m8740a(this.f2285y, SupportMenuInflater.f2247f, SupportMenuInflater.this.f2249b);
            } else {
                if (z) {
                    Log.w("SupportMenuInflater", "Ignoring attribute 'actionProviderClass'. Action view already specified.");
                }
                this.f2255A = null;
            }
            this.f2256B = obtainStyledAttributes.getText(C0363j.MenuItem_contentDescription);
            this.f2257C = obtainStyledAttributes.getText(C0363j.MenuItem_tooltipText);
            if (obtainStyledAttributes.hasValue(C0363j.MenuItem_iconTintMode)) {
                this.f2259E = C0475k0.m8284a(obtainStyledAttributes.getInt(C0363j.MenuItem_iconTintMode, -1), this.f2259E);
            } else {
                this.f2259E = null;
            }
            if (obtainStyledAttributes.hasValue(C0363j.MenuItem_iconTint)) {
                this.f2258D = obtainStyledAttributes.getColorStateList(C0363j.MenuItem_iconTint);
            } else {
                this.f2258D = null;
            }
            obtainStyledAttributes.recycle();
            this.f2268h = false;
        }

        /* renamed from: c */
        public boolean m8737c() {
            return this.f2268h;
        }

        /* renamed from: d */
        public void m8736d() {
            this.f2262b = 0;
            this.f2263c = 0;
            this.f2264d = 0;
            this.f2265e = 0;
            this.f2266f = true;
            this.f2267g = true;
        }

        /* renamed from: a */
        public final char m8741a(String str) {
            if (str == null) {
                return (char) 0;
            }
            return str.charAt(0);
        }

        /* renamed from: a */
        public final void m8742a(MenuItem menuItem) {
            boolean z = false;
            menuItem.setChecked(this.f2279s).setVisible(this.f2280t).setEnabled(this.f2281u).setCheckable(this.f2278r >= 1).setTitleCondensed(this.f2272l).setIcon(this.f2273m);
            int i = this.f2282v;
            if (i >= 0) {
                menuItem.setShowAsAction(i);
            }
            if (this.f2286z != null) {
                if (!SupportMenuInflater.this.f2250c.isRestricted()) {
                    menuItem.setOnMenuItemClickListener(new MenuItem$OnMenuItemClickListenerC0416a(SupportMenuInflater.this.m8747a(), this.f2286z));
                } else {
                    throw new IllegalStateException("The android:onClick attribute cannot be used within a restricted context");
                }
            }
            boolean z2 = menuItem instanceof MenuItemImpl;
            if (z2) {
                MenuItemImpl menuItemImpl = (MenuItemImpl) menuItem;
            }
            if (this.f2278r >= 2) {
                if (z2) {
                    ((MenuItemImpl) menuItem).m8636c(true);
                } else if (menuItem instanceof MenuItemWrapperICS) {
                    ((MenuItemWrapperICS) menuItem).m8622a(true);
                }
            }
            String str = this.f2284x;
            if (str != null) {
                menuItem.setActionView((View) m8740a(str, SupportMenuInflater.f2246e, SupportMenuInflater.this.f2248a));
                z = true;
            }
            int i2 = this.f2283w;
            if (i2 > 0) {
                if (!z) {
                    menuItem.setActionView(i2);
                } else {
                    Log.w("SupportMenuInflater", "Ignoring attribute 'itemActionViewLayout'. Action view already specified.");
                }
            }
            ActionProvider actionProvider = this.f2255A;
            if (actionProvider != null) {
                MenuItemCompat.m9505a(menuItem, actionProvider);
            }
            MenuItemCompat.m9502a(menuItem, this.f2256B);
            MenuItemCompat.m9500b(menuItem, this.f2257C);
            MenuItemCompat.m9506a(menuItem, this.f2274n, this.f2275o);
            MenuItemCompat.m9501b(menuItem, this.f2276p, this.f2277q);
            PorterDuff.Mode mode = this.f2259E;
            if (mode != null) {
                MenuItemCompat.m9503a(menuItem, mode);
            }
            ColorStateList colorStateList = this.f2258D;
            if (colorStateList != null) {
                MenuItemCompat.m9504a(menuItem, colorStateList);
            }
        }

        /* renamed from: b */
        public SubMenu m8739b() {
            this.f2268h = true;
            SubMenu addSubMenu = this.f2261a.addSubMenu(this.f2262b, this.f2269i, this.f2270j, this.f2271k);
            m8742a(addSubMenu.getItem());
            return addSubMenu;
        }

        /* renamed from: a */
        public void m8744a() {
            this.f2268h = true;
            m8742a(this.f2261a.add(this.f2262b, this.f2269i, this.f2270j, this.f2271k));
        }

        /* renamed from: a */
        public final <T> T m8740a(String str, Class<?>[] clsArr, Object[] objArr) {
            try {
                Constructor<?> constructor = SupportMenuInflater.this.f2250c.getClassLoader().loadClass(str).getConstructor(clsArr);
                constructor.setAccessible(true);
                return (T) constructor.newInstance(objArr);
            } catch (Exception e) {
                Log.w("SupportMenuInflater", "Cannot instantiate class: " + str, e);
                return null;
            }
        }
    }

    /* renamed from: a */
    public Object m8747a() {
        if (this.f2251d == null) {
            this.f2251d = m8746a(this.f2250c);
        }
        return this.f2251d;
    }

    /* renamed from: a */
    public final Object m8746a(Object obj) {
        return (!(obj instanceof Activity) && (obj instanceof ContextWrapper)) ? m8746a(((ContextWrapper) obj).getBaseContext()) : obj;
    }
}
