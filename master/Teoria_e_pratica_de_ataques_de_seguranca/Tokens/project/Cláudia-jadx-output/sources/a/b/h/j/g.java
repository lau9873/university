package a.b.h.j;

import a.b.h.b.j;
import a.b.h.j.j.k;
import a.b.h.j.j.l;
import a.b.h.k.k0;
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
/* compiled from: SupportMenuInflater.java */
/* loaded from: classes.dex */
public class g extends MenuInflater {

    /* renamed from: e  reason: collision with root package name */
    public static final Class<?>[] f1496e = {Context.class};

    /* renamed from: f  reason: collision with root package name */
    public static final Class<?>[] f1497f = f1496e;

    /* renamed from: a  reason: collision with root package name */
    public final Object[] f1498a;

    /* renamed from: b  reason: collision with root package name */
    public final Object[] f1499b;

    /* renamed from: c  reason: collision with root package name */
    public Context f1500c;

    /* renamed from: d  reason: collision with root package name */
    public Object f1501d;

    /* compiled from: SupportMenuInflater.java */
    /* loaded from: classes.dex */
    public static class a implements MenuItem.OnMenuItemClickListener {

        /* renamed from: c  reason: collision with root package name */
        public static final Class<?>[] f1502c = {MenuItem.class};

        /* renamed from: a  reason: collision with root package name */
        public Object f1503a;

        /* renamed from: b  reason: collision with root package name */
        public Method f1504b;

        public a(Object obj, String str) {
            this.f1503a = obj;
            Class<?> cls = obj.getClass();
            try {
                this.f1504b = cls.getMethod(str, f1502c);
            } catch (Exception e2) {
                InflateException inflateException = new InflateException("Couldn't resolve menu item onClick handler " + str + " in class " + cls.getName());
                inflateException.initCause(e2);
                throw inflateException;
            }
        }

        @Override // android.view.MenuItem.OnMenuItemClickListener
        public boolean onMenuItemClick(MenuItem menuItem) {
            try {
                if (this.f1504b.getReturnType() == Boolean.TYPE) {
                    return ((Boolean) this.f1504b.invoke(this.f1503a, menuItem)).booleanValue();
                }
                this.f1504b.invoke(this.f1503a, menuItem);
                return true;
            } catch (Exception e2) {
                throw new RuntimeException(e2);
            }
        }
    }

    public g(Context context) {
        super(context);
        this.f1500c = context;
        this.f1498a = new Object[]{context};
        this.f1499b = this.f1498a;
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
        r0.d();
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x006d, code lost:
        if (r6.equals("item") == false) goto L38;
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x0073, code lost:
        if (r0.c() != false) goto L37;
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x0075, code lost:
        r6 = r0.A;
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x0077, code lost:
        if (r6 == null) goto L35;
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x007d, code lost:
        if (r6.a() == false) goto L35;
     */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x007f, code lost:
        r0.b();
     */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x0083, code lost:
        r0.a();
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
        r0.a(r14);
     */
    /* JADX WARN: Code restructure failed: missing block: B:47:0x00a4, code lost:
        if (r6.equals("item") == false) goto L53;
     */
    /* JADX WARN: Code restructure failed: missing block: B:48:0x00a6, code lost:
        r0.b(r14);
     */
    /* JADX WARN: Code restructure failed: missing block: B:50:0x00ae, code lost:
        if (r6.equals("menu") == false) goto L57;
     */
    /* JADX WARN: Code restructure failed: missing block: B:51:0x00b0, code lost:
        a(r13, r14, r0.b());
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
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void a(org.xmlpull.v1.XmlPullParser r13, android.util.AttributeSet r14, android.view.Menu r15) {
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
            r0.d()
            goto Lba
        L69:
            boolean r9 = r6.equals(r9)
            if (r9 == 0) goto L87
            boolean r6 = r0.c()
            if (r6 != 0) goto Lba
            a.b.g.k.c r6 = r0.A
            if (r6 == 0) goto L83
            boolean r6 = r6.a()
            if (r6 == 0) goto L83
            r0.b()
            goto Lba
        L83:
            r0.a()
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
            r0.a(r14)
            goto Lba
        La0:
            boolean r9 = r6.equals(r9)
            if (r9 == 0) goto Laa
            r0.b(r14)
            goto Lba
        Laa:
            boolean r9 = r6.equals(r2)
            if (r9 == 0) goto Lb8
            android.view.SubMenu r6 = r0.b()
            r12.a(r13, r14, r6)
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
        throw new UnsupportedOperationException("Method not decompiled: a.b.h.j.g.a(org.xmlpull.v1.XmlPullParser, android.util.AttributeSet, android.view.Menu):void");
    }

    @Override // android.view.MenuInflater
    public void inflate(int i2, Menu menu) {
        if (!(menu instanceof a.b.g.d.a.a)) {
            super.inflate(i2, menu);
            return;
        }
        XmlResourceParser xmlResourceParser = null;
        try {
            try {
                try {
                    xmlResourceParser = this.f1500c.getResources().getLayout(i2);
                    a(xmlResourceParser, Xml.asAttributeSet(xmlResourceParser), menu);
                } catch (XmlPullParserException e2) {
                    throw new InflateException("Error inflating menu XML", e2);
                }
            } catch (IOException e3) {
                throw new InflateException("Error inflating menu XML", e3);
            }
        } finally {
            if (xmlResourceParser != null) {
                xmlResourceParser.close();
            }
        }
    }

    /* compiled from: SupportMenuInflater.java */
    /* loaded from: classes.dex */
    public class b {
        public a.b.g.k.c A;
        public CharSequence B;
        public CharSequence C;
        public ColorStateList D = null;
        public PorterDuff.Mode E = null;

        /* renamed from: a  reason: collision with root package name */
        public Menu f1505a;

        /* renamed from: b  reason: collision with root package name */
        public int f1506b;

        /* renamed from: c  reason: collision with root package name */
        public int f1507c;

        /* renamed from: d  reason: collision with root package name */
        public int f1508d;

        /* renamed from: e  reason: collision with root package name */
        public int f1509e;

        /* renamed from: f  reason: collision with root package name */
        public boolean f1510f;

        /* renamed from: g  reason: collision with root package name */
        public boolean f1511g;

        /* renamed from: h  reason: collision with root package name */
        public boolean f1512h;

        /* renamed from: i  reason: collision with root package name */
        public int f1513i;
        public int j;
        public CharSequence k;
        public CharSequence l;
        public int m;
        public char n;
        public int o;
        public char p;
        public int q;
        public int r;
        public boolean s;
        public boolean t;
        public boolean u;
        public int v;
        public int w;
        public String x;
        public String y;
        public String z;

        public b(Menu menu) {
            this.f1505a = menu;
            d();
        }

        public void a(AttributeSet attributeSet) {
            TypedArray obtainStyledAttributes = g.this.f1500c.obtainStyledAttributes(attributeSet, j.MenuGroup);
            this.f1506b = obtainStyledAttributes.getResourceId(j.MenuGroup_android_id, 0);
            this.f1507c = obtainStyledAttributes.getInt(j.MenuGroup_android_menuCategory, 0);
            this.f1508d = obtainStyledAttributes.getInt(j.MenuGroup_android_orderInCategory, 0);
            this.f1509e = obtainStyledAttributes.getInt(j.MenuGroup_android_checkableBehavior, 0);
            this.f1510f = obtainStyledAttributes.getBoolean(j.MenuGroup_android_visible, true);
            this.f1511g = obtainStyledAttributes.getBoolean(j.MenuGroup_android_enabled, true);
            obtainStyledAttributes.recycle();
        }

        public void b(AttributeSet attributeSet) {
            TypedArray obtainStyledAttributes = g.this.f1500c.obtainStyledAttributes(attributeSet, j.MenuItem);
            this.f1513i = obtainStyledAttributes.getResourceId(j.MenuItem_android_id, 0);
            this.j = (obtainStyledAttributes.getInt(j.MenuItem_android_menuCategory, this.f1507c) & (-65536)) | (obtainStyledAttributes.getInt(j.MenuItem_android_orderInCategory, this.f1508d) & 65535);
            this.k = obtainStyledAttributes.getText(j.MenuItem_android_title);
            this.l = obtainStyledAttributes.getText(j.MenuItem_android_titleCondensed);
            this.m = obtainStyledAttributes.getResourceId(j.MenuItem_android_icon, 0);
            this.n = a(obtainStyledAttributes.getString(j.MenuItem_android_alphabeticShortcut));
            this.o = obtainStyledAttributes.getInt(j.MenuItem_alphabeticModifiers, 4096);
            this.p = a(obtainStyledAttributes.getString(j.MenuItem_android_numericShortcut));
            this.q = obtainStyledAttributes.getInt(j.MenuItem_numericModifiers, 4096);
            if (obtainStyledAttributes.hasValue(j.MenuItem_android_checkable)) {
                this.r = obtainStyledAttributes.getBoolean(j.MenuItem_android_checkable, false) ? 1 : 0;
            } else {
                this.r = this.f1509e;
            }
            this.s = obtainStyledAttributes.getBoolean(j.MenuItem_android_checked, false);
            this.t = obtainStyledAttributes.getBoolean(j.MenuItem_android_visible, this.f1510f);
            this.u = obtainStyledAttributes.getBoolean(j.MenuItem_android_enabled, this.f1511g);
            this.v = obtainStyledAttributes.getInt(j.MenuItem_showAsAction, -1);
            this.z = obtainStyledAttributes.getString(j.MenuItem_android_onClick);
            this.w = obtainStyledAttributes.getResourceId(j.MenuItem_actionLayout, 0);
            this.x = obtainStyledAttributes.getString(j.MenuItem_actionViewClass);
            this.y = obtainStyledAttributes.getString(j.MenuItem_actionProviderClass);
            boolean z = this.y != null;
            if (z && this.w == 0 && this.x == null) {
                this.A = (a.b.g.k.c) a(this.y, g.f1497f, g.this.f1499b);
            } else {
                if (z) {
                    Log.w("SupportMenuInflater", "Ignoring attribute 'actionProviderClass'. Action view already specified.");
                }
                this.A = null;
            }
            this.B = obtainStyledAttributes.getText(j.MenuItem_contentDescription);
            this.C = obtainStyledAttributes.getText(j.MenuItem_tooltipText);
            if (obtainStyledAttributes.hasValue(j.MenuItem_iconTintMode)) {
                this.E = k0.a(obtainStyledAttributes.getInt(j.MenuItem_iconTintMode, -1), this.E);
            } else {
                this.E = null;
            }
            if (obtainStyledAttributes.hasValue(j.MenuItem_iconTint)) {
                this.D = obtainStyledAttributes.getColorStateList(j.MenuItem_iconTint);
            } else {
                this.D = null;
            }
            obtainStyledAttributes.recycle();
            this.f1512h = false;
        }

        public boolean c() {
            return this.f1512h;
        }

        public void d() {
            this.f1506b = 0;
            this.f1507c = 0;
            this.f1508d = 0;
            this.f1509e = 0;
            this.f1510f = true;
            this.f1511g = true;
        }

        public final char a(String str) {
            if (str == null) {
                return (char) 0;
            }
            return str.charAt(0);
        }

        public final void a(MenuItem menuItem) {
            boolean z = false;
            menuItem.setChecked(this.s).setVisible(this.t).setEnabled(this.u).setCheckable(this.r >= 1).setTitleCondensed(this.l).setIcon(this.m);
            int i2 = this.v;
            if (i2 >= 0) {
                menuItem.setShowAsAction(i2);
            }
            if (this.z != null) {
                if (!g.this.f1500c.isRestricted()) {
                    menuItem.setOnMenuItemClickListener(new a(g.this.a(), this.z));
                } else {
                    throw new IllegalStateException("The android:onClick attribute cannot be used within a restricted context");
                }
            }
            boolean z2 = menuItem instanceof k;
            if (z2) {
                k kVar = (k) menuItem;
            }
            if (this.r >= 2) {
                if (z2) {
                    ((k) menuItem).c(true);
                } else if (menuItem instanceof l) {
                    ((l) menuItem).a(true);
                }
            }
            String str = this.x;
            if (str != null) {
                menuItem.setActionView((View) a(str, g.f1496e, g.this.f1498a));
                z = true;
            }
            int i3 = this.w;
            if (i3 > 0) {
                if (!z) {
                    menuItem.setActionView(i3);
                } else {
                    Log.w("SupportMenuInflater", "Ignoring attribute 'itemActionViewLayout'. Action view already specified.");
                }
            }
            a.b.g.k.c cVar = this.A;
            if (cVar != null) {
                a.b.g.k.h.a(menuItem, cVar);
            }
            a.b.g.k.h.a(menuItem, this.B);
            a.b.g.k.h.b(menuItem, this.C);
            a.b.g.k.h.a(menuItem, this.n, this.o);
            a.b.g.k.h.b(menuItem, this.p, this.q);
            PorterDuff.Mode mode = this.E;
            if (mode != null) {
                a.b.g.k.h.a(menuItem, mode);
            }
            ColorStateList colorStateList = this.D;
            if (colorStateList != null) {
                a.b.g.k.h.a(menuItem, colorStateList);
            }
        }

        public SubMenu b() {
            this.f1512h = true;
            SubMenu addSubMenu = this.f1505a.addSubMenu(this.f1506b, this.f1513i, this.j, this.k);
            a(addSubMenu.getItem());
            return addSubMenu;
        }

        public void a() {
            this.f1512h = true;
            a(this.f1505a.add(this.f1506b, this.f1513i, this.j, this.k));
        }

        public final <T> T a(String str, Class<?>[] clsArr, Object[] objArr) {
            try {
                Constructor<?> constructor = g.this.f1500c.getClassLoader().loadClass(str).getConstructor(clsArr);
                constructor.setAccessible(true);
                return (T) constructor.newInstance(objArr);
            } catch (Exception e2) {
                Log.w("SupportMenuInflater", "Cannot instantiate class: " + str, e2);
                return null;
            }
        }
    }

    public Object a() {
        if (this.f1501d == null) {
            this.f1501d = a(this.f1500c);
        }
        return this.f1501d;
    }

    public final Object a(Object obj) {
        return (!(obj instanceof Activity) && (obj instanceof ContextWrapper)) ? a(((ContextWrapper) obj).getBaseContext()) : obj;
    }
}
