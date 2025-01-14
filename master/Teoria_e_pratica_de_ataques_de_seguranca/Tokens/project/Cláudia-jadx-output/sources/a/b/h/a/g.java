package a.b.h.a;

import a.b.g.a.w;
import a.b.g.k.a0;
import a.b.g.k.b0;
import a.b.g.k.d0;
import a.b.g.k.e;
import a.b.g.k.p;
import a.b.g.k.u;
import a.b.g.k.z;
import a.b.h.j.b;
import a.b.h.j.f;
import a.b.h.j.j.h;
import a.b.h.j.j.p;
import a.b.h.j.j.q;
import a.b.h.k.h0;
import a.b.h.k.l1;
import a.b.h.k.n0;
import a.b.h.k.q1;
import a.b.h.k.t1;
import android.app.Activity;
import android.app.Dialog;
import android.app.UiModeManager;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.PackageManager;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.media.AudioManager;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatViewInflater;
import android.support.v7.widget.ActionBarContextView;
import android.support.v7.widget.ContentFrameLayout;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.util.AndroidRuntimeException;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.Log;
import android.util.TypedValue;
import android.view.ActionMode;
import android.view.KeyCharacterMap;
import android.view.KeyEvent;
import android.view.KeyboardShortcutGroup;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.Window;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.PopupWindow;
import android.widget.TextView;
import java.lang.Thread;
import java.util.List;
import org.xmlpull.v1.XmlPullParser;
/* compiled from: AppCompatDelegateImpl.java */
/* loaded from: classes.dex */
public class g extends a.b.h.a.f implements h.a, LayoutInflater.Factory2 {
    public static final boolean T;
    public static final int[] U;
    public static boolean V;
    public boolean A;
    public boolean B;
    public boolean C;
    public boolean D;
    public boolean E;
    public m[] F;
    public m G;
    public boolean H;
    public boolean I;
    public boolean K;
    public k L;
    public boolean M;
    public int N;
    public boolean P;
    public Rect Q;
    public Rect R;
    public AppCompatViewInflater S;

    /* renamed from: b  reason: collision with root package name */
    public final Context f1276b;

    /* renamed from: c  reason: collision with root package name */
    public final Window f1277c;

    /* renamed from: d  reason: collision with root package name */
    public final Window.Callback f1278d;

    /* renamed from: e  reason: collision with root package name */
    public final Window.Callback f1279e;

    /* renamed from: f  reason: collision with root package name */
    public final a.b.h.a.e f1280f;

    /* renamed from: g  reason: collision with root package name */
    public a.b.h.a.a f1281g;

    /* renamed from: h  reason: collision with root package name */
    public MenuInflater f1282h;

    /* renamed from: i  reason: collision with root package name */
    public CharSequence f1283i;
    public h0 j;
    public h k;
    public n m;
    public a.b.h.j.b n;
    public ActionBarContextView o;
    public PopupWindow p;
    public Runnable q;
    public boolean t;
    public ViewGroup u;
    public TextView v;
    public View w;
    public boolean x;
    public boolean y;
    public boolean z;
    public z r = null;
    public boolean s = true;
    public int J = -100;
    public final Runnable O = new b();

    /* compiled from: AppCompatDelegateImpl.java */
    /* loaded from: classes.dex */
    public static class a implements Thread.UncaughtExceptionHandler {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ Thread.UncaughtExceptionHandler f1284a;

        public a(Thread.UncaughtExceptionHandler uncaughtExceptionHandler) {
            this.f1284a = uncaughtExceptionHandler;
        }

        public final boolean a(Throwable th) {
            String message;
            if (!(th instanceof Resources.NotFoundException) || (message = th.getMessage()) == null) {
                return false;
            }
            return message.contains("drawable") || message.contains("Drawable");
        }

        @Override // java.lang.Thread.UncaughtExceptionHandler
        public void uncaughtException(Thread thread, Throwable th) {
            if (a(th)) {
                Resources.NotFoundException notFoundException = new Resources.NotFoundException(th.getMessage() + ". If the resource you are trying to use is a vector resource, you may be referencing it in an unsupported way. See AppCompatDelegate.setCompatVectorFromResourcesEnabled() for more info.");
                notFoundException.initCause(th.getCause());
                notFoundException.setStackTrace(th.getStackTrace());
                this.f1284a.uncaughtException(thread, notFoundException);
                return;
            }
            this.f1284a.uncaughtException(thread, th);
        }
    }

    /* compiled from: AppCompatDelegateImpl.java */
    /* loaded from: classes.dex */
    public class b implements Runnable {
        public b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            g gVar = g.this;
            if ((gVar.N & 1) != 0) {
                gVar.e(0);
            }
            g gVar2 = g.this;
            if ((gVar2.N & 4096) != 0) {
                gVar2.e(108);
            }
            g gVar3 = g.this;
            gVar3.M = false;
            gVar3.N = 0;
        }
    }

    /* compiled from: AppCompatDelegateImpl.java */
    /* loaded from: classes.dex */
    public class c implements p {
        public c() {
        }

        @Override // a.b.g.k.p
        public d0 a(View view, d0 d0Var) {
            int d2 = d0Var.d();
            int l = g.this.l(d2);
            if (d2 != l) {
                d0Var = d0Var.a(d0Var.b(), l, d0Var.c(), d0Var.a());
            }
            return u.b(view, d0Var);
        }
    }

    /* compiled from: AppCompatDelegateImpl.java */
    /* loaded from: classes.dex */
    public class d implements n0.a {
        public d() {
        }

        @Override // a.b.h.k.n0.a
        public void a(Rect rect) {
            rect.top = g.this.l(rect.top);
        }
    }

    /* compiled from: AppCompatDelegateImpl.java */
    /* loaded from: classes.dex */
    public class e implements ContentFrameLayout.a {
        public e() {
        }

        @Override // android.support.v7.widget.ContentFrameLayout.a
        public void a() {
        }

        @Override // android.support.v7.widget.ContentFrameLayout.a
        public void onDetachedFromWindow() {
            g.this.m();
        }
    }

    /* compiled from: AppCompatDelegateImpl.java */
    /* loaded from: classes.dex */
    public class f implements Runnable {

        /* compiled from: AppCompatDelegateImpl.java */
        /* loaded from: classes.dex */
        public class a extends b0 {
            public a() {
            }

            @Override // a.b.g.k.a0
            public void b(View view) {
                g.this.o.setAlpha(1.0f);
                g.this.r.a((a0) null);
                g.this.r = null;
            }

            @Override // a.b.g.k.b0, a.b.g.k.a0
            public void c(View view) {
                g.this.o.setVisibility(0);
            }
        }

        public f() {
        }

        @Override // java.lang.Runnable
        public void run() {
            g gVar = g.this;
            gVar.p.showAtLocation(gVar.o, 55, 0, 0);
            g.this.n();
            if (g.this.y()) {
                g.this.o.setAlpha(0.0f);
                g gVar2 = g.this;
                z a2 = u.a(gVar2.o);
                a2.a(1.0f);
                gVar2.r = a2;
                g.this.r.a(new a());
                return;
            }
            g.this.o.setAlpha(1.0f);
            g.this.o.setVisibility(0);
        }
    }

    /* compiled from: AppCompatDelegateImpl.java */
    /* renamed from: a.b.h.a.g$g  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0036g extends b0 {
        public C0036g() {
        }

        @Override // a.b.g.k.a0
        public void b(View view) {
            g.this.o.setAlpha(1.0f);
            g.this.r.a((a0) null);
            g.this.r = null;
        }

        @Override // a.b.g.k.b0, a.b.g.k.a0
        public void c(View view) {
            g.this.o.setVisibility(0);
            g.this.o.sendAccessibilityEvent(32);
            if (g.this.o.getParent() instanceof View) {
                u.B((View) g.this.o.getParent());
            }
        }
    }

    /* compiled from: AppCompatDelegateImpl.java */
    /* loaded from: classes.dex */
    public class i implements b.a {

        /* renamed from: a  reason: collision with root package name */
        public b.a f1293a;

        /* compiled from: AppCompatDelegateImpl.java */
        /* loaded from: classes.dex */
        public class a extends b0 {
            public a() {
            }

            @Override // a.b.g.k.a0
            public void b(View view) {
                g.this.o.setVisibility(8);
                g gVar = g.this;
                PopupWindow popupWindow = gVar.p;
                if (popupWindow != null) {
                    popupWindow.dismiss();
                } else if (gVar.o.getParent() instanceof View) {
                    u.B((View) g.this.o.getParent());
                }
                g.this.o.removeAllViews();
                g.this.r.a((a0) null);
                g.this.r = null;
            }
        }

        public i(b.a aVar) {
            this.f1293a = aVar;
        }

        @Override // a.b.h.j.b.a
        public boolean a(a.b.h.j.b bVar, Menu menu) {
            return this.f1293a.a(bVar, menu);
        }

        @Override // a.b.h.j.b.a
        public boolean b(a.b.h.j.b bVar, Menu menu) {
            return this.f1293a.b(bVar, menu);
        }

        @Override // a.b.h.j.b.a
        public boolean a(a.b.h.j.b bVar, MenuItem menuItem) {
            return this.f1293a.a(bVar, menuItem);
        }

        @Override // a.b.h.j.b.a
        public void a(a.b.h.j.b bVar) {
            this.f1293a.a(bVar);
            g gVar = g.this;
            if (gVar.p != null) {
                gVar.f1277c.getDecorView().removeCallbacks(g.this.q);
            }
            g gVar2 = g.this;
            if (gVar2.o != null) {
                gVar2.n();
                g gVar3 = g.this;
                z a2 = u.a(gVar3.o);
                a2.a(0.0f);
                gVar3.r = a2;
                g.this.r.a(new a());
            }
            g gVar4 = g.this;
            a.b.h.a.e eVar = gVar4.f1280f;
            if (eVar != null) {
                eVar.a(gVar4.n);
            }
            g.this.n = null;
        }
    }

    /* compiled from: AppCompatDelegateImpl.java */
    /* loaded from: classes.dex */
    public final class k {

        /* renamed from: a  reason: collision with root package name */
        public a.b.h.a.l f1297a;

        /* renamed from: b  reason: collision with root package name */
        public boolean f1298b;

        /* renamed from: c  reason: collision with root package name */
        public BroadcastReceiver f1299c;

        /* renamed from: d  reason: collision with root package name */
        public IntentFilter f1300d;

        /* compiled from: AppCompatDelegateImpl.java */
        /* loaded from: classes.dex */
        public class a extends BroadcastReceiver {
            public a() {
            }

            @Override // android.content.BroadcastReceiver
            public void onReceive(Context context, Intent intent) {
                k.this.b();
            }
        }

        public k(a.b.h.a.l lVar) {
            this.f1297a = lVar;
            this.f1298b = lVar.b();
        }

        public void a() {
            BroadcastReceiver broadcastReceiver = this.f1299c;
            if (broadcastReceiver != null) {
                g.this.f1276b.unregisterReceiver(broadcastReceiver);
                this.f1299c = null;
            }
        }

        public void b() {
            boolean b2 = this.f1297a.b();
            if (b2 != this.f1298b) {
                this.f1298b = b2;
                g.this.a();
            }
        }

        public int c() {
            this.f1298b = this.f1297a.b();
            return this.f1298b ? 2 : 1;
        }

        public void d() {
            a();
            if (this.f1299c == null) {
                this.f1299c = new a();
            }
            if (this.f1300d == null) {
                this.f1300d = new IntentFilter();
                this.f1300d.addAction("android.intent.action.TIME_SET");
                this.f1300d.addAction("android.intent.action.TIMEZONE_CHANGED");
                this.f1300d.addAction("android.intent.action.TIME_TICK");
            }
            g.this.f1276b.registerReceiver(this.f1299c, this.f1300d);
        }
    }

    /* compiled from: AppCompatDelegateImpl.java */
    /* loaded from: classes.dex */
    public class l extends ContentFrameLayout {
        public l(Context context) {
            super(context);
        }

        public final boolean a(int i2, int i3) {
            return i2 < -5 || i3 < -5 || i2 > getWidth() + 5 || i3 > getHeight() + 5;
        }

        @Override // android.view.ViewGroup, android.view.View
        public boolean dispatchKeyEvent(KeyEvent keyEvent) {
            return g.this.a(keyEvent) || super.dispatchKeyEvent(keyEvent);
        }

        @Override // android.view.ViewGroup
        public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
            if (motionEvent.getAction() == 0 && a((int) motionEvent.getX(), (int) motionEvent.getY())) {
                g.this.d(0);
                return true;
            }
            return super.onInterceptTouchEvent(motionEvent);
        }

        @Override // android.view.View
        public void setBackgroundResource(int i2) {
            setBackgroundDrawable(a.b.h.d.a.a.c(getContext(), i2));
        }
    }

    static {
        T = Build.VERSION.SDK_INT < 21;
        U = new int[]{16842836};
        if (!T || V) {
            return;
        }
        Thread.setDefaultUncaughtExceptionHandler(new a(Thread.getDefaultUncaughtExceptionHandler()));
        V = true;
    }

    public g(Context context, Window window, a.b.h.a.e eVar) {
        this.f1276b = context;
        this.f1277c = window;
        this.f1280f = eVar;
        this.f1278d = this.f1277c.getCallback();
        Window.Callback callback = this.f1278d;
        if (!(callback instanceof j)) {
            this.f1279e = new j(callback);
            this.f1277c.setCallback(this.f1279e);
            l1 a2 = l1.a(context, (AttributeSet) null, U);
            Drawable c2 = a2.c(0);
            if (c2 != null) {
                this.f1277c.setBackgroundDrawable(c2);
            }
            a2.a();
            return;
        }
        throw new IllegalStateException("AppCompat has already installed itself into the Window");
    }

    public final void A() {
        if (this.t) {
            throw new AndroidRuntimeException("Window feature must be requested before adding content");
        }
    }

    @Override // a.b.h.a.f
    public void a(Bundle bundle) {
        Window.Callback callback = this.f1278d;
        if (callback instanceof Activity) {
            String str = null;
            try {
                str = w.b((Activity) callback);
            } catch (IllegalArgumentException unused) {
            }
            if (str != null) {
                a.b.h.a.a x = x();
                if (x == null) {
                    this.P = true;
                } else {
                    x.c(true);
                }
            }
        }
        if (bundle == null || this.J != -100) {
            return;
        }
        this.J = bundle.getInt("appcompat:local_night_mode", -100);
    }

    public void a(ViewGroup viewGroup) {
    }

    @Override // a.b.h.a.f
    public void b(Bundle bundle) {
        p();
    }

    @Override // a.b.h.a.f
    public a.b.h.a.a c() {
        u();
        return this.f1281g;
    }

    public boolean d(int i2, KeyEvent keyEvent) {
        if (i2 == 4) {
            boolean z = this.H;
            this.H = false;
            m a2 = a(0, false);
            if (a2 != null && a2.o) {
                if (!z) {
                    a(a2, true);
                }
                return true;
            } else if (w()) {
                return true;
            }
        } else if (i2 == 82) {
            e(0, keyEvent);
            return true;
        }
        return false;
    }

    @Override // a.b.h.a.f
    public void e() {
        a.b.h.a.a c2 = c();
        if (c2 == null || !c2.i()) {
            f(0);
        }
    }

    @Override // a.b.h.a.f
    public void f() {
        if (this.M) {
            this.f1277c.getDecorView().removeCallbacks(this.O);
        }
        this.I = true;
        a.b.h.a.a aVar = this.f1281g;
        if (aVar != null) {
            aVar.j();
        }
        k kVar = this.L;
        if (kVar != null) {
            kVar.a();
        }
    }

    @Override // a.b.h.a.f
    public void g() {
        a.b.h.a.a c2 = c();
        if (c2 != null) {
            c2.e(true);
        }
    }

    @Override // a.b.h.a.f
    public void h() {
        a();
    }

    @Override // a.b.h.a.f
    public void i() {
        a.b.h.a.a c2 = c();
        if (c2 != null) {
            c2.e(false);
        }
        k kVar = this.L;
        if (kVar != null) {
            kVar.a();
        }
    }

    public final int j(int i2) {
        if (i2 == 8) {
            Log.i("AppCompatDelegate", "You should now use the AppCompatDelegate.FEATURE_SUPPORT_ACTION_BAR id when requesting this feature.");
            return 108;
        } else if (i2 == 9) {
            Log.i("AppCompatDelegate", "You should now use the AppCompatDelegate.FEATURE_SUPPORT_ACTION_BAR_OVERLAY id when requesting this feature.");
            return 109;
        } else {
            return i2;
        }
    }

    public final void k() {
        ContentFrameLayout contentFrameLayout = (ContentFrameLayout) this.u.findViewById(16908290);
        View decorView = this.f1277c.getDecorView();
        contentFrameLayout.a(decorView.getPaddingLeft(), decorView.getPaddingTop(), decorView.getPaddingRight(), decorView.getPaddingBottom());
        TypedArray obtainStyledAttributes = this.f1276b.obtainStyledAttributes(a.b.h.b.j.AppCompatTheme);
        obtainStyledAttributes.getValue(a.b.h.b.j.AppCompatTheme_windowMinWidthMajor, contentFrameLayout.getMinWidthMajor());
        obtainStyledAttributes.getValue(a.b.h.b.j.AppCompatTheme_windowMinWidthMinor, contentFrameLayout.getMinWidthMinor());
        if (obtainStyledAttributes.hasValue(a.b.h.b.j.AppCompatTheme_windowFixedWidthMajor)) {
            obtainStyledAttributes.getValue(a.b.h.b.j.AppCompatTheme_windowFixedWidthMajor, contentFrameLayout.getFixedWidthMajor());
        }
        if (obtainStyledAttributes.hasValue(a.b.h.b.j.AppCompatTheme_windowFixedWidthMinor)) {
            obtainStyledAttributes.getValue(a.b.h.b.j.AppCompatTheme_windowFixedWidthMinor, contentFrameLayout.getFixedWidthMinor());
        }
        if (obtainStyledAttributes.hasValue(a.b.h.b.j.AppCompatTheme_windowFixedHeightMajor)) {
            obtainStyledAttributes.getValue(a.b.h.b.j.AppCompatTheme_windowFixedHeightMajor, contentFrameLayout.getFixedHeightMajor());
        }
        if (obtainStyledAttributes.hasValue(a.b.h.b.j.AppCompatTheme_windowFixedHeightMinor)) {
            obtainStyledAttributes.getValue(a.b.h.b.j.AppCompatTheme_windowFixedHeightMinor, contentFrameLayout.getFixedHeightMinor());
        }
        obtainStyledAttributes.recycle();
        contentFrameLayout.requestLayout();
    }

    public final ViewGroup l() {
        ViewGroup viewGroup;
        Context context;
        TypedArray obtainStyledAttributes = this.f1276b.obtainStyledAttributes(a.b.h.b.j.AppCompatTheme);
        if (obtainStyledAttributes.hasValue(a.b.h.b.j.AppCompatTheme_windowActionBar)) {
            if (obtainStyledAttributes.getBoolean(a.b.h.b.j.AppCompatTheme_windowNoTitle, false)) {
                b(1);
            } else if (obtainStyledAttributes.getBoolean(a.b.h.b.j.AppCompatTheme_windowActionBar, false)) {
                b(108);
            }
            if (obtainStyledAttributes.getBoolean(a.b.h.b.j.AppCompatTheme_windowActionBarOverlay, false)) {
                b(109);
            }
            if (obtainStyledAttributes.getBoolean(a.b.h.b.j.AppCompatTheme_windowActionModeOverlay, false)) {
                b(10);
            }
            this.C = obtainStyledAttributes.getBoolean(a.b.h.b.j.AppCompatTheme_android_windowIsFloating, false);
            obtainStyledAttributes.recycle();
            this.f1277c.getDecorView();
            LayoutInflater from = LayoutInflater.from(this.f1276b);
            if (!this.D) {
                if (this.C) {
                    viewGroup = (ViewGroup) from.inflate(a.b.h.b.g.abc_dialog_title_material, (ViewGroup) null);
                    this.A = false;
                    this.z = false;
                } else if (this.z) {
                    TypedValue typedValue = new TypedValue();
                    this.f1276b.getTheme().resolveAttribute(a.b.h.b.a.actionBarTheme, typedValue, true);
                    int i2 = typedValue.resourceId;
                    if (i2 != 0) {
                        context = new a.b.h.j.d(this.f1276b, i2);
                    } else {
                        context = this.f1276b;
                    }
                    viewGroup = (ViewGroup) LayoutInflater.from(context).inflate(a.b.h.b.g.abc_screen_toolbar, (ViewGroup) null);
                    this.j = (h0) viewGroup.findViewById(a.b.h.b.f.decor_content_parent);
                    this.j.setWindowCallback(t());
                    if (this.A) {
                        this.j.a(109);
                    }
                    if (this.x) {
                        this.j.a(2);
                    }
                    if (this.y) {
                        this.j.a(5);
                    }
                } else {
                    viewGroup = null;
                }
            } else {
                if (this.B) {
                    viewGroup = (ViewGroup) from.inflate(a.b.h.b.g.abc_screen_simple_overlay_action_mode, (ViewGroup) null);
                } else {
                    viewGroup = (ViewGroup) from.inflate(a.b.h.b.g.abc_screen_simple, (ViewGroup) null);
                }
                if (Build.VERSION.SDK_INT >= 21) {
                    u.a(viewGroup, new c());
                } else {
                    ((n0) viewGroup).setOnFitSystemWindowsListener(new d());
                }
            }
            if (viewGroup != null) {
                if (this.j == null) {
                    this.v = (TextView) viewGroup.findViewById(a.b.h.b.f.title);
                }
                t1.b(viewGroup);
                ContentFrameLayout contentFrameLayout = (ContentFrameLayout) viewGroup.findViewById(a.b.h.b.f.action_bar_activity_content);
                ViewGroup viewGroup2 = (ViewGroup) this.f1277c.findViewById(16908290);
                if (viewGroup2 != null) {
                    while (viewGroup2.getChildCount() > 0) {
                        View childAt = viewGroup2.getChildAt(0);
                        viewGroup2.removeViewAt(0);
                        contentFrameLayout.addView(childAt);
                    }
                    viewGroup2.setId(-1);
                    contentFrameLayout.setId(16908290);
                    if (viewGroup2 instanceof FrameLayout) {
                        ((FrameLayout) viewGroup2).setForeground(null);
                    }
                }
                this.f1277c.setContentView(viewGroup);
                contentFrameLayout.setAttachListener(new e());
                return viewGroup;
            }
            throw new IllegalArgumentException("AppCompat does not support the current theme features: { windowActionBar: " + this.z + ", windowActionBarOverlay: " + this.A + ", android:windowIsFloating: " + this.C + ", windowActionModeOverlay: " + this.B + ", windowNoTitle: " + this.D + " }");
        }
        obtainStyledAttributes.recycle();
        throw new IllegalStateException("You need to use a Theme.AppCompat theme (or descendant) with this activity.");
    }

    public void m() {
        a.b.h.j.j.h hVar;
        h0 h0Var = this.j;
        if (h0Var != null) {
            h0Var.g();
        }
        if (this.p != null) {
            this.f1277c.getDecorView().removeCallbacks(this.q);
            if (this.p.isShowing()) {
                try {
                    this.p.dismiss();
                } catch (IllegalArgumentException unused) {
                }
            }
            this.p = null;
        }
        n();
        m a2 = a(0, false);
        if (a2 == null || (hVar = a2.j) == null) {
            return;
        }
        hVar.close();
    }

    public void n() {
        z zVar = this.r;
        if (zVar != null) {
            zVar.a();
        }
    }

    public final void o() {
        if (this.L == null) {
            this.L = new k(a.b.h.a.l.a(this.f1276b));
        }
    }

    @Override // android.view.LayoutInflater.Factory2
    public final View onCreateView(View view, String str, Context context, AttributeSet attributeSet) {
        return a(view, str, context, attributeSet);
    }

    public final void p() {
        if (this.t) {
            return;
        }
        this.u = l();
        CharSequence s = s();
        if (!TextUtils.isEmpty(s)) {
            h0 h0Var = this.j;
            if (h0Var != null) {
                h0Var.setWindowTitle(s);
            } else if (x() != null) {
                x().a(s);
            } else {
                TextView textView = this.v;
                if (textView != null) {
                    textView.setText(s);
                }
            }
        }
        k();
        a(this.u);
        this.t = true;
        m a2 = a(0, false);
        if (this.I) {
            return;
        }
        if (a2 == null || a2.j == null) {
            f(108);
        }
    }

    public final Context q() {
        a.b.h.a.a c2 = c();
        Context h2 = c2 != null ? c2.h() : null;
        return h2 == null ? this.f1276b : h2;
    }

    public final int r() {
        int i2 = this.J;
        return i2 != -100 ? i2 : a.b.h.a.f.j();
    }

    public final CharSequence s() {
        Window.Callback callback = this.f1278d;
        if (callback instanceof Activity) {
            return ((Activity) callback).getTitle();
        }
        return this.f1283i;
    }

    public final Window.Callback t() {
        return this.f1277c.getCallback();
    }

    public final void u() {
        p();
        if (this.z && this.f1281g == null) {
            Window.Callback callback = this.f1278d;
            if (callback instanceof Activity) {
                this.f1281g = new a.b.h.a.m((Activity) callback, this.A);
            } else if (callback instanceof Dialog) {
                this.f1281g = new a.b.h.a.m((Dialog) callback);
            }
            a.b.h.a.a aVar = this.f1281g;
            if (aVar != null) {
                aVar.c(this.P);
            }
        }
    }

    public boolean v() {
        return this.s;
    }

    public boolean w() {
        a.b.h.j.b bVar = this.n;
        if (bVar != null) {
            bVar.a();
            return true;
        }
        a.b.h.a.a c2 = c();
        return c2 != null && c2.f();
    }

    public final a.b.h.a.a x() {
        return this.f1281g;
    }

    public final boolean y() {
        ViewGroup viewGroup;
        return this.t && (viewGroup = this.u) != null && u.x(viewGroup);
    }

    public final boolean z() {
        if (this.K) {
            Context context = this.f1276b;
            if (context instanceof Activity) {
                try {
                    return (context.getPackageManager().getActivityInfo(new ComponentName(this.f1276b, this.f1276b.getClass()), 0).configChanges & 512) == 0;
                } catch (PackageManager.NameNotFoundException e2) {
                    Log.d("AppCompatDelegate", "Exception while getting ActivityInfo", e2);
                    return true;
                }
            }
        }
        return false;
    }

    /* compiled from: AppCompatDelegateImpl.java */
    /* loaded from: classes.dex */
    public final class h implements p.a {
        public h() {
        }

        @Override // a.b.h.j.j.p.a
        public boolean a(a.b.h.j.j.h hVar) {
            Window.Callback t = g.this.t();
            if (t != null) {
                t.onMenuOpened(108, hVar);
                return true;
            }
            return true;
        }

        @Override // a.b.h.j.j.p.a
        public void a(a.b.h.j.j.h hVar, boolean z) {
            g.this.b(hVar);
        }
    }

    @Override // a.b.h.a.f
    public MenuInflater b() {
        if (this.f1282h == null) {
            u();
            a.b.h.a.a aVar = this.f1281g;
            this.f1282h = new a.b.h.j.g(aVar != null ? aVar.h() : this.f1276b);
        }
        return this.f1282h;
    }

    public void h(int i2) {
        a.b.h.a.a c2;
        if (i2 != 108 || (c2 = c()) == null) {
            return;
        }
        c2.b(true);
    }

    @Override // android.view.LayoutInflater.Factory
    public View onCreateView(String str, Context context, AttributeSet attributeSet) {
        return onCreateView(null, str, context, attributeSet);
    }

    /* compiled from: AppCompatDelegateImpl.java */
    /* loaded from: classes.dex */
    public static final class m {

        /* renamed from: a  reason: collision with root package name */
        public int f1304a;

        /* renamed from: b  reason: collision with root package name */
        public int f1305b;

        /* renamed from: c  reason: collision with root package name */
        public int f1306c;

        /* renamed from: d  reason: collision with root package name */
        public int f1307d;

        /* renamed from: e  reason: collision with root package name */
        public int f1308e;

        /* renamed from: f  reason: collision with root package name */
        public int f1309f;

        /* renamed from: g  reason: collision with root package name */
        public ViewGroup f1310g;

        /* renamed from: h  reason: collision with root package name */
        public View f1311h;

        /* renamed from: i  reason: collision with root package name */
        public View f1312i;
        public a.b.h.j.j.h j;
        public a.b.h.j.j.f k;
        public Context l;
        public boolean m;
        public boolean n;
        public boolean o;
        public boolean p;
        public boolean q = false;
        public boolean r;
        public Bundle s;

        public m(int i2) {
            this.f1304a = i2;
        }

        public boolean a() {
            if (this.f1311h == null) {
                return false;
            }
            return this.f1312i != null || this.k.d().getCount() > 0;
        }

        public void a(Context context) {
            TypedValue typedValue = new TypedValue();
            Resources.Theme newTheme = context.getResources().newTheme();
            newTheme.setTo(context.getTheme());
            newTheme.resolveAttribute(a.b.h.b.a.actionBarPopupTheme, typedValue, true);
            int i2 = typedValue.resourceId;
            if (i2 != 0) {
                newTheme.applyStyle(i2, true);
            }
            newTheme.resolveAttribute(a.b.h.b.a.panelMenuListTheme, typedValue, true);
            int i3 = typedValue.resourceId;
            if (i3 != 0) {
                newTheme.applyStyle(i3, true);
            } else {
                newTheme.applyStyle(a.b.h.b.i.Theme_AppCompat_CompactMenu, true);
            }
            a.b.h.j.d dVar = new a.b.h.j.d(context, 0);
            dVar.getTheme().setTo(newTheme);
            this.l = dVar;
            TypedArray obtainStyledAttributes = dVar.obtainStyledAttributes(a.b.h.b.j.AppCompatTheme);
            this.f1305b = obtainStyledAttributes.getResourceId(a.b.h.b.j.AppCompatTheme_panelBackground, 0);
            this.f1309f = obtainStyledAttributes.getResourceId(a.b.h.b.j.AppCompatTheme_android_windowAnimationStyle, 0);
            obtainStyledAttributes.recycle();
        }

        public void a(a.b.h.j.j.h hVar) {
            a.b.h.j.j.f fVar;
            a.b.h.j.j.h hVar2 = this.j;
            if (hVar == hVar2) {
                return;
            }
            if (hVar2 != null) {
                hVar2.b(this.k);
            }
            this.j = hVar;
            if (hVar == null || (fVar = this.k) == null) {
                return;
            }
            hVar.a(fVar);
        }

        public q a(p.a aVar) {
            if (this.j == null) {
                return null;
            }
            if (this.k == null) {
                this.k = new a.b.h.j.j.f(this.l, a.b.h.b.g.abc_list_menu_item_layout);
                this.k.a(aVar);
                this.j.a(this.k);
            }
            return this.k.a(this.f1310g);
        }
    }

    @Override // a.b.h.a.f
    public void c(int i2) {
        p();
        ViewGroup viewGroup = (ViewGroup) this.u.findViewById(16908290);
        viewGroup.removeAllViews();
        LayoutInflater.from(this.f1276b).inflate(i2, viewGroup);
        this.f1278d.onContentChanged();
    }

    public int g(int i2) {
        if (i2 != -100) {
            if (i2 != 0) {
                return i2;
            }
            if (Build.VERSION.SDK_INT < 23 || ((UiModeManager) this.f1276b.getSystemService(UiModeManager.class)).getNightMode() != 0) {
                o();
                return this.L.c();
            }
            return -1;
        }
        return -1;
    }

    /* compiled from: AppCompatDelegateImpl.java */
    /* loaded from: classes.dex */
    public class j extends a.b.h.j.i {
        public j(Window.Callback callback) {
            super(callback);
        }

        public final ActionMode a(ActionMode.Callback callback) {
            f.a aVar = new f.a(g.this.f1276b, callback);
            a.b.h.j.b a2 = g.this.a(aVar);
            if (a2 != null) {
                return aVar.b(a2);
            }
            return null;
        }

        @Override // a.b.h.j.i, android.view.Window.Callback
        public boolean dispatchKeyEvent(KeyEvent keyEvent) {
            return g.this.a(keyEvent) || super.dispatchKeyEvent(keyEvent);
        }

        @Override // a.b.h.j.i, android.view.Window.Callback
        public boolean dispatchKeyShortcutEvent(KeyEvent keyEvent) {
            return super.dispatchKeyShortcutEvent(keyEvent) || g.this.c(keyEvent.getKeyCode(), keyEvent);
        }

        @Override // a.b.h.j.i, android.view.Window.Callback
        public void onContentChanged() {
        }

        @Override // a.b.h.j.i, android.view.Window.Callback
        public boolean onCreatePanelMenu(int i2, Menu menu) {
            if (i2 != 0 || (menu instanceof a.b.h.j.j.h)) {
                return super.onCreatePanelMenu(i2, menu);
            }
            return false;
        }

        @Override // a.b.h.j.i, android.view.Window.Callback
        public boolean onMenuOpened(int i2, Menu menu) {
            super.onMenuOpened(i2, menu);
            g.this.h(i2);
            return true;
        }

        @Override // a.b.h.j.i, android.view.Window.Callback
        public void onPanelClosed(int i2, Menu menu) {
            super.onPanelClosed(i2, menu);
            g.this.i(i2);
        }

        @Override // a.b.h.j.i, android.view.Window.Callback
        public boolean onPreparePanel(int i2, View view, Menu menu) {
            a.b.h.j.j.h hVar = menu instanceof a.b.h.j.j.h ? (a.b.h.j.j.h) menu : null;
            if (i2 == 0 && hVar == null) {
                return false;
            }
            if (hVar != null) {
                hVar.d(true);
            }
            boolean onPreparePanel = super.onPreparePanel(i2, view, menu);
            if (hVar != null) {
                hVar.d(false);
            }
            return onPreparePanel;
        }

        @Override // a.b.h.j.i, android.view.Window.Callback
        public void onProvideKeyboardShortcuts(List<KeyboardShortcutGroup> list, Menu menu, int i2) {
            a.b.h.j.j.h hVar;
            m a2 = g.this.a(0, true);
            if (a2 != null && (hVar = a2.j) != null) {
                super.onProvideKeyboardShortcuts(list, hVar, i2);
            } else {
                super.onProvideKeyboardShortcuts(list, menu, i2);
            }
        }

        @Override // a.b.h.j.i, android.view.Window.Callback
        public ActionMode onWindowStartingActionMode(ActionMode.Callback callback) {
            if (Build.VERSION.SDK_INT >= 23) {
                return null;
            }
            if (g.this.v()) {
                return a(callback);
            }
            return super.onWindowStartingActionMode(callback);
        }

        @Override // a.b.h.j.i, android.view.Window.Callback
        public ActionMode onWindowStartingActionMode(ActionMode.Callback callback, int i2) {
            if (g.this.v() && i2 == 0) {
                return a(callback);
            }
            return super.onWindowStartingActionMode(callback, i2);
        }
    }

    public final boolean e(int i2, KeyEvent keyEvent) {
        boolean z;
        boolean z2;
        h0 h0Var;
        if (this.n != null) {
            return false;
        }
        m a2 = a(i2, true);
        if (i2 == 0 && (h0Var = this.j) != null && h0Var.f() && !ViewConfiguration.get(this.f1276b).hasPermanentMenuKey()) {
            if (!this.j.a()) {
                if (!this.I && b(a2, keyEvent)) {
                    z = this.j.e();
                }
                z = false;
            } else {
                z = this.j.d();
            }
        } else if (!a2.o && !a2.n) {
            if (a2.m) {
                if (a2.r) {
                    a2.m = false;
                    z2 = b(a2, keyEvent);
                } else {
                    z2 = true;
                }
                if (z2) {
                    a(a2, keyEvent);
                    z = true;
                }
            }
            z = false;
        } else {
            z = a2.o;
            a(a2, true);
        }
        if (z) {
            AudioManager audioManager = (AudioManager) this.f1276b.getSystemService("audio");
            if (audioManager != null) {
                audioManager.playSoundEffect(0);
            } else {
                Log.w("AppCompatDelegate", "Couldn't get audio manager");
            }
        }
        return z;
    }

    /* compiled from: AppCompatDelegateImpl.java */
    /* loaded from: classes.dex */
    public final class n implements p.a {
        public n() {
        }

        @Override // a.b.h.j.j.p.a
        public void a(a.b.h.j.j.h hVar, boolean z) {
            a.b.h.j.j.h m = hVar.m();
            boolean z2 = m != hVar;
            g gVar = g.this;
            if (z2) {
                hVar = m;
            }
            m a2 = gVar.a((Menu) hVar);
            if (a2 != null) {
                if (z2) {
                    g.this.a(a2.f1304a, a2, m);
                    g.this.a(a2, true);
                    return;
                }
                g.this.a(a2, z);
            }
        }

        @Override // a.b.h.j.j.p.a
        public boolean a(a.b.h.j.j.h hVar) {
            Window.Callback t;
            if (hVar == null) {
                g gVar = g.this;
                if (!gVar.z || (t = gVar.t()) == null || g.this.I) {
                    return true;
                }
                t.onMenuOpened(108, hVar);
                return true;
            }
            return true;
        }
    }

    public void i(int i2) {
        if (i2 == 108) {
            a.b.h.a.a c2 = c();
            if (c2 != null) {
                c2.b(false);
            }
        } else if (i2 == 0) {
            m a2 = a(i2, true);
            if (a2.o) {
                a(a2, false);
            }
        }
    }

    @Override // a.b.h.a.f
    public void b(View view, ViewGroup.LayoutParams layoutParams) {
        p();
        ViewGroup viewGroup = (ViewGroup) this.u.findViewById(16908290);
        viewGroup.removeAllViews();
        viewGroup.addView(view, layoutParams);
        this.f1278d.onContentChanged();
    }

    @Override // a.b.h.a.f
    public void a(Toolbar toolbar) {
        if (this.f1278d instanceof Activity) {
            a.b.h.a.a c2 = c();
            if (!(c2 instanceof a.b.h.a.m)) {
                this.f1282h = null;
                if (c2 != null) {
                    c2.j();
                }
                if (toolbar != null) {
                    a.b.h.a.j jVar = new a.b.h.a.j(toolbar, ((Activity) this.f1278d).getTitle(), this.f1279e);
                    this.f1281g = jVar;
                    this.f1277c.setCallback(jVar.m());
                } else {
                    this.f1281g = null;
                    this.f1277c.setCallback(this.f1279e);
                }
                e();
                return;
            }
            throw new IllegalStateException("This Activity already has an action bar supplied by the window decor. Do not request Window.FEATURE_SUPPORT_ACTION_BAR and set windowActionBar to false in your theme to use a Toolbar instead.");
        }
    }

    @Override // a.b.h.a.f
    public void c(Bundle bundle) {
        int i2 = this.J;
        if (i2 != -100) {
            bundle.putInt("appcompat:local_night_mode", i2);
        }
    }

    @Override // a.b.h.a.f
    public void d() {
        LayoutInflater from = LayoutInflater.from(this.f1276b);
        if (from.getFactory() == null) {
            a.b.g.k.f.b(from, this);
        } else if (from.getFactory2() instanceof g) {
        } else {
            Log.i("AppCompatDelegate", "The Activity's LayoutInflater already has a Factory installed so we can not install AppCompat's");
        }
    }

    public final void f(int i2) {
        this.N = (1 << i2) | this.N;
        if (this.M) {
            return;
        }
        u.a(this.f1277c.getDecorView(), this.O);
        this.M = true;
    }

    public boolean c(int i2, KeyEvent keyEvent) {
        a.b.h.a.a c2 = c();
        if (c2 == null || !c2.a(i2, keyEvent)) {
            m mVar = this.G;
            if (mVar != null && a(mVar, keyEvent.getKeyCode(), keyEvent, 1)) {
                m mVar2 = this.G;
                if (mVar2 != null) {
                    mVar2.n = true;
                }
                return true;
            }
            if (this.G == null) {
                m a2 = a(0, true);
                b(a2, keyEvent);
                boolean a3 = a(a2, keyEvent.getKeyCode(), keyEvent, 1);
                a2.m = false;
                if (a3) {
                    return true;
                }
            }
            return false;
        }
        return true;
    }

    @Override // a.b.h.a.f
    public boolean b(int i2) {
        int j2 = j(i2);
        if (this.D && j2 == 108) {
            return false;
        }
        if (this.z && j2 == 1) {
            this.z = false;
        }
        if (j2 == 1) {
            A();
            this.D = true;
            return true;
        } else if (j2 == 2) {
            A();
            this.x = true;
            return true;
        } else if (j2 == 5) {
            A();
            this.y = true;
            return true;
        } else if (j2 == 10) {
            A();
            this.B = true;
            return true;
        } else if (j2 == 108) {
            A();
            this.z = true;
            return true;
        } else if (j2 != 109) {
            return this.f1277c.requestFeature(j2);
        } else {
            A();
            this.A = true;
            return true;
        }
    }

    public void d(int i2) {
        a(a(i2, true), true);
    }

    @Override // a.b.h.a.f
    public <T extends View> T a(int i2) {
        p();
        return (T) this.f1277c.findViewById(i2);
    }

    public final boolean c(m mVar) {
        Context context = this.f1276b;
        int i2 = mVar.f1304a;
        if ((i2 == 0 || i2 == 108) && this.j != null) {
            TypedValue typedValue = new TypedValue();
            Resources.Theme theme = context.getTheme();
            theme.resolveAttribute(a.b.h.b.a.actionBarTheme, typedValue, true);
            Resources.Theme theme2 = null;
            if (typedValue.resourceId != 0) {
                theme2 = context.getResources().newTheme();
                theme2.setTo(theme);
                theme2.applyStyle(typedValue.resourceId, true);
                theme2.resolveAttribute(a.b.h.b.a.actionBarWidgetTheme, typedValue, true);
            } else {
                theme.resolveAttribute(a.b.h.b.a.actionBarWidgetTheme, typedValue, true);
            }
            if (typedValue.resourceId != 0) {
                if (theme2 == null) {
                    theme2 = context.getResources().newTheme();
                    theme2.setTo(theme);
                }
                theme2.applyStyle(typedValue.resourceId, true);
            }
            if (theme2 != null) {
                a.b.h.j.d dVar = new a.b.h.j.d(context, 0);
                dVar.getTheme().setTo(theme2);
                context = dVar;
            }
        }
        a.b.h.j.j.h hVar = new a.b.h.j.j.h(context);
        hVar.a(this);
        mVar.a(hVar);
        return true;
    }

    @Override // a.b.h.a.f
    public void a(Configuration configuration) {
        a.b.h.a.a c2;
        if (this.z && this.t && (c2 = c()) != null) {
            c2.a(configuration);
        }
        a.b.h.k.k.a().f(this.f1276b);
        a();
    }

    public void e(int i2) {
        m a2;
        m a3 = a(i2, true);
        if (a3.j != null) {
            Bundle bundle = new Bundle();
            a3.j.e(bundle);
            if (bundle.size() > 0) {
                a3.s = bundle;
            }
            a3.j.s();
            a3.j.clear();
        }
        a3.r = true;
        a3.q = true;
        if ((i2 != 108 && i2 != 0) || this.j == null || (a2 = a(0, false)) == null) {
            return;
        }
        a2.m = false;
        b(a2, (KeyEvent) null);
    }

    @Override // a.b.h.a.f
    public void a(View view) {
        p();
        ViewGroup viewGroup = (ViewGroup) this.u.findViewById(16908290);
        viewGroup.removeAllViews();
        viewGroup.addView(view);
        this.f1278d.onContentChanged();
    }

    public final boolean k(int i2) {
        Resources resources = this.f1276b.getResources();
        Configuration configuration = resources.getConfiguration();
        int i3 = configuration.uiMode & 48;
        int i4 = i2 == 2 ? 32 : 16;
        if (i3 != i4) {
            if (z()) {
                ((Activity) this.f1276b).recreate();
                return true;
            }
            Configuration configuration2 = new Configuration(configuration);
            DisplayMetrics displayMetrics = resources.getDisplayMetrics();
            configuration2.uiMode = i4 | (configuration2.uiMode & (-49));
            resources.updateConfiguration(configuration2, displayMetrics);
            if (Build.VERSION.SDK_INT < 26) {
                a.b.h.a.i.a(resources);
                return true;
            }
            return true;
        }
        return false;
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x0025  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0029  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public a.b.h.j.b b(a.b.h.j.b.a r8) {
        /*
            Method dump skipped, instructions count: 371
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: a.b.h.a.g.b(a.b.h.j.b$a):a.b.h.j.b");
    }

    @Override // a.b.h.a.f
    public void a(View view, ViewGroup.LayoutParams layoutParams) {
        p();
        ((ViewGroup) this.u.findViewById(16908290)).addView(view, layoutParams);
        this.f1278d.onContentChanged();
    }

    @Override // a.b.h.a.f
    public final void a(CharSequence charSequence) {
        this.f1283i = charSequence;
        h0 h0Var = this.j;
        if (h0Var != null) {
            h0Var.setWindowTitle(charSequence);
        } else if (x() != null) {
            x().a(charSequence);
        } else {
            TextView textView = this.v;
            if (textView != null) {
                textView.setText(charSequence);
            }
        }
    }

    @Override // a.b.h.j.j.h.a
    public boolean a(a.b.h.j.j.h hVar, MenuItem menuItem) {
        m a2;
        Window.Callback t = t();
        if (t == null || this.I || (a2 = a((Menu) hVar.m())) == null) {
            return false;
        }
        return t.onMenuItemSelected(a2.f1304a, menuItem);
    }

    @Override // a.b.h.j.j.h.a
    public void a(a.b.h.j.j.h hVar) {
        a(hVar, true);
    }

    public a.b.h.j.b a(b.a aVar) {
        a.b.h.a.e eVar;
        if (aVar != null) {
            a.b.h.j.b bVar = this.n;
            if (bVar != null) {
                bVar.a();
            }
            i iVar = new i(aVar);
            a.b.h.a.a c2 = c();
            if (c2 != null) {
                this.n = c2.a(iVar);
                a.b.h.j.b bVar2 = this.n;
                if (bVar2 != null && (eVar = this.f1280f) != null) {
                    eVar.b(bVar2);
                }
            }
            if (this.n == null) {
                this.n = b(iVar);
            }
            return this.n;
        }
        throw new IllegalArgumentException("ActionMode callback can not be null.");
    }

    public boolean a(KeyEvent keyEvent) {
        View decorView;
        Window.Callback callback = this.f1278d;
        if (((callback instanceof e.a) || (callback instanceof a.b.h.a.h)) && (decorView = this.f1277c.getDecorView()) != null && a.b.g.k.e.a(decorView, keyEvent)) {
            return true;
        }
        if (keyEvent.getKeyCode() == 82 && this.f1278d.dispatchKeyEvent(keyEvent)) {
            return true;
        }
        int keyCode = keyEvent.getKeyCode();
        return keyEvent.getAction() == 0 ? a(keyCode, keyEvent) : d(keyCode, keyEvent);
    }

    public int l(int i2) {
        boolean z;
        boolean z2;
        ActionBarContextView actionBarContextView = this.o;
        if (actionBarContextView == null || !(actionBarContextView.getLayoutParams() instanceof ViewGroup.MarginLayoutParams)) {
            z = false;
        } else {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.o.getLayoutParams();
            if (this.o.isShown()) {
                if (this.Q == null) {
                    this.Q = new Rect();
                    this.R = new Rect();
                }
                Rect rect = this.Q;
                Rect rect2 = this.R;
                rect.set(0, i2, 0, 0);
                t1.a(this.u, rect, rect2);
                if (marginLayoutParams.topMargin != (rect2.top == 0 ? i2 : 0)) {
                    marginLayoutParams.topMargin = i2;
                    View view = this.w;
                    if (view == null) {
                        this.w = new View(this.f1276b);
                        this.w.setBackgroundColor(this.f1276b.getResources().getColor(a.b.h.b.c.abc_input_method_navigation_guard));
                        this.u.addView(this.w, -1, new ViewGroup.LayoutParams(-1, i2));
                    } else {
                        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
                        if (layoutParams.height != i2) {
                            layoutParams.height = i2;
                            this.w.setLayoutParams(layoutParams);
                        }
                    }
                    z2 = true;
                } else {
                    z2 = false;
                }
                z = this.w != null;
                if (!this.B && z) {
                    i2 = 0;
                }
            } else {
                if (marginLayoutParams.topMargin != 0) {
                    marginLayoutParams.topMargin = 0;
                    z2 = true;
                } else {
                    z2 = false;
                }
                z = false;
            }
            if (z2) {
                this.o.setLayoutParams(marginLayoutParams);
            }
        }
        View view2 = this.w;
        if (view2 != null) {
            view2.setVisibility(z ? 0 : 8);
        }
        return i2;
    }

    public boolean a(int i2, KeyEvent keyEvent) {
        if (i2 == 4) {
            this.H = (keyEvent.getFlags() & 128) != 0;
        } else if (i2 == 82) {
            b(0, keyEvent);
            return true;
        }
        return false;
    }

    public View a(View view, String str, Context context, AttributeSet attributeSet) {
        boolean z;
        boolean z2 = false;
        if (this.S == null) {
            String string = this.f1276b.obtainStyledAttributes(a.b.h.b.j.AppCompatTheme).getString(a.b.h.b.j.AppCompatTheme_viewInflaterClass);
            if (string != null && !AppCompatViewInflater.class.getName().equals(string)) {
                try {
                    this.S = (AppCompatViewInflater) Class.forName(string).getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
                } catch (Throwable th) {
                    Log.i("AppCompatDelegate", "Failed to instantiate custom view inflater " + string + ". Falling back to default.", th);
                    this.S = new AppCompatViewInflater();
                }
            } else {
                this.S = new AppCompatViewInflater();
            }
        }
        if (T) {
            if (attributeSet instanceof XmlPullParser) {
                if (((XmlPullParser) attributeSet).getDepth() > 1) {
                    z2 = true;
                }
            } else {
                z2 = a((ViewParent) view);
            }
            z = z2;
        } else {
            z = false;
        }
        return this.S.createView(view, str, context, attributeSet, z, T, true, q1.b());
    }

    public final boolean b(m mVar) {
        mVar.a(q());
        mVar.f1310g = new l(mVar.l);
        mVar.f1306c = 81;
        return true;
    }

    public final boolean a(ViewParent viewParent) {
        if (viewParent == null) {
            return false;
        }
        View decorView = this.f1277c.getDecorView();
        while (viewParent != null) {
            if (viewParent == decorView || !(viewParent instanceof View) || u.w((View) viewParent)) {
                return false;
            }
            viewParent = viewParent.getParent();
        }
        return true;
    }

    public final boolean b(m mVar, KeyEvent keyEvent) {
        h0 h0Var;
        h0 h0Var2;
        h0 h0Var3;
        if (this.I) {
            return false;
        }
        if (mVar.m) {
            return true;
        }
        m mVar2 = this.G;
        if (mVar2 != null && mVar2 != mVar) {
            a(mVar2, false);
        }
        Window.Callback t = t();
        if (t != null) {
            mVar.f1312i = t.onCreatePanelView(mVar.f1304a);
        }
        int i2 = mVar.f1304a;
        boolean z = i2 == 0 || i2 == 108;
        if (z && (h0Var3 = this.j) != null) {
            h0Var3.b();
        }
        if (mVar.f1312i == null && (!z || !(x() instanceof a.b.h.a.j))) {
            if (mVar.j == null || mVar.r) {
                if (mVar.j == null && (!c(mVar) || mVar.j == null)) {
                    return false;
                }
                if (z && this.j != null) {
                    if (this.k == null) {
                        this.k = new h();
                    }
                    this.j.a(mVar.j, this.k);
                }
                mVar.j.s();
                if (!t.onCreatePanelMenu(mVar.f1304a, mVar.j)) {
                    mVar.a((a.b.h.j.j.h) null);
                    if (z && (h0Var = this.j) != null) {
                        h0Var.a(null, this.k);
                    }
                    return false;
                }
                mVar.r = false;
            }
            mVar.j.s();
            Bundle bundle = mVar.s;
            if (bundle != null) {
                mVar.j.c(bundle);
                mVar.s = null;
            }
            if (!t.onPreparePanel(0, mVar.f1312i, mVar.j)) {
                if (z && (h0Var2 = this.j) != null) {
                    h0Var2.a(null, this.k);
                }
                mVar.j.r();
                return false;
            }
            mVar.p = KeyCharacterMap.load(keyEvent != null ? keyEvent.getDeviceId() : -1).getKeyboardType() != 1;
            mVar.j.setQwertyMode(mVar.p);
            mVar.j.r();
        }
        mVar.m = true;
        mVar.n = false;
        this.G = mVar;
        return true;
    }

    public final void a(m mVar, KeyEvent keyEvent) {
        int i2;
        ViewGroup.LayoutParams layoutParams;
        if (mVar.o || this.I) {
            return;
        }
        if (mVar.f1304a == 0) {
            if ((this.f1276b.getResources().getConfiguration().screenLayout & 15) == 4) {
                return;
            }
        }
        Window.Callback t = t();
        if (t != null && !t.onMenuOpened(mVar.f1304a, mVar.j)) {
            a(mVar, true);
            return;
        }
        WindowManager windowManager = (WindowManager) this.f1276b.getSystemService("window");
        if (windowManager != null && b(mVar, keyEvent)) {
            if (mVar.f1310g != null && !mVar.q) {
                View view = mVar.f1312i;
                if (view != null && (layoutParams = view.getLayoutParams()) != null && layoutParams.width == -1) {
                    i2 = -1;
                    mVar.n = false;
                    WindowManager.LayoutParams layoutParams2 = new WindowManager.LayoutParams(i2, -2, mVar.f1307d, mVar.f1308e, 1002, 8519680, -3);
                    layoutParams2.gravity = mVar.f1306c;
                    layoutParams2.windowAnimations = mVar.f1309f;
                    windowManager.addView(mVar.f1310g, layoutParams2);
                    mVar.o = true;
                }
            } else {
                ViewGroup viewGroup = mVar.f1310g;
                if (viewGroup == null) {
                    if (!b(mVar) || mVar.f1310g == null) {
                        return;
                    }
                } else if (mVar.q && viewGroup.getChildCount() > 0) {
                    mVar.f1310g.removeAllViews();
                }
                if (!a(mVar) || !mVar.a()) {
                    return;
                }
                ViewGroup.LayoutParams layoutParams3 = mVar.f1311h.getLayoutParams();
                if (layoutParams3 == null) {
                    layoutParams3 = new ViewGroup.LayoutParams(-2, -2);
                }
                mVar.f1310g.setBackgroundResource(mVar.f1305b);
                ViewParent parent = mVar.f1311h.getParent();
                if (parent != null && (parent instanceof ViewGroup)) {
                    ((ViewGroup) parent).removeView(mVar.f1311h);
                }
                mVar.f1310g.addView(mVar.f1311h, layoutParams3);
                if (!mVar.f1311h.hasFocus()) {
                    mVar.f1311h.requestFocus();
                }
            }
            i2 = -2;
            mVar.n = false;
            WindowManager.LayoutParams layoutParams22 = new WindowManager.LayoutParams(i2, -2, mVar.f1307d, mVar.f1308e, 1002, 8519680, -3);
            layoutParams22.gravity = mVar.f1306c;
            layoutParams22.windowAnimations = mVar.f1309f;
            windowManager.addView(mVar.f1310g, layoutParams22);
            mVar.o = true;
        }
    }

    public final void a(a.b.h.j.j.h hVar, boolean z) {
        h0 h0Var = this.j;
        if (h0Var != null && h0Var.f() && (!ViewConfiguration.get(this.f1276b).hasPermanentMenuKey() || this.j.c())) {
            Window.Callback t = t();
            if (this.j.a() && z) {
                this.j.d();
                if (this.I) {
                    return;
                }
                t.onPanelClosed(108, a(0, true).j);
                return;
            } else if (t == null || this.I) {
                return;
            } else {
                if (this.M && (this.N & 1) != 0) {
                    this.f1277c.getDecorView().removeCallbacks(this.O);
                    this.O.run();
                }
                m a2 = a(0, true);
                a.b.h.j.j.h hVar2 = a2.j;
                if (hVar2 == null || a2.r || !t.onPreparePanel(0, a2.f1312i, hVar2)) {
                    return;
                }
                t.onMenuOpened(108, a2.j);
                this.j.e();
                return;
            }
        }
        m a3 = a(0, true);
        a3.q = true;
        a(a3, false);
        a(a3, (KeyEvent) null);
    }

    public void b(a.b.h.j.j.h hVar) {
        if (this.E) {
            return;
        }
        this.E = true;
        this.j.g();
        Window.Callback t = t();
        if (t != null && !this.I) {
            t.onPanelClosed(108, hVar);
        }
        this.E = false;
    }

    public final boolean b(int i2, KeyEvent keyEvent) {
        if (keyEvent.getRepeatCount() == 0) {
            m a2 = a(i2, true);
            if (a2.o) {
                return false;
            }
            return b(a2, keyEvent);
        }
        return false;
    }

    public final boolean a(m mVar) {
        View view = mVar.f1312i;
        if (view != null) {
            mVar.f1311h = view;
            return true;
        } else if (mVar.j == null) {
            return false;
        } else {
            if (this.m == null) {
                this.m = new n();
            }
            mVar.f1311h = (View) mVar.a(this.m);
            return mVar.f1311h != null;
        }
    }

    public void a(m mVar, boolean z) {
        ViewGroup viewGroup;
        h0 h0Var;
        if (z && mVar.f1304a == 0 && (h0Var = this.j) != null && h0Var.a()) {
            b(mVar.j);
            return;
        }
        WindowManager windowManager = (WindowManager) this.f1276b.getSystemService("window");
        if (windowManager != null && mVar.o && (viewGroup = mVar.f1310g) != null) {
            windowManager.removeView(viewGroup);
            if (z) {
                a(mVar.f1304a, mVar, null);
            }
        }
        mVar.m = false;
        mVar.n = false;
        mVar.o = false;
        mVar.f1311h = null;
        mVar.q = true;
        if (this.G == mVar) {
            this.G = null;
        }
    }

    public void a(int i2, m mVar, Menu menu) {
        if (menu == null) {
            if (mVar == null && i2 >= 0) {
                m[] mVarArr = this.F;
                if (i2 < mVarArr.length) {
                    mVar = mVarArr[i2];
                }
            }
            if (mVar != null) {
                menu = mVar.j;
            }
        }
        if ((mVar == null || mVar.o) && !this.I) {
            this.f1278d.onPanelClosed(i2, menu);
        }
    }

    public m a(Menu menu) {
        m[] mVarArr = this.F;
        int length = mVarArr != null ? mVarArr.length : 0;
        for (int i2 = 0; i2 < length; i2++) {
            m mVar = mVarArr[i2];
            if (mVar != null && mVar.j == menu) {
                return mVar;
            }
        }
        return null;
    }

    public m a(int i2, boolean z) {
        m[] mVarArr = this.F;
        if (mVarArr == null || mVarArr.length <= i2) {
            m[] mVarArr2 = new m[i2 + 1];
            if (mVarArr != null) {
                System.arraycopy(mVarArr, 0, mVarArr2, 0, mVarArr.length);
            }
            this.F = mVarArr2;
            mVarArr = mVarArr2;
        }
        m mVar = mVarArr[i2];
        if (mVar == null) {
            m mVar2 = new m(i2);
            mVarArr[i2] = mVar2;
            return mVar2;
        }
        return mVar;
    }

    public final boolean a(m mVar, int i2, KeyEvent keyEvent, int i3) {
        a.b.h.j.j.h hVar;
        boolean z = false;
        if (keyEvent.isSystem()) {
            return false;
        }
        if ((mVar.m || b(mVar, keyEvent)) && (hVar = mVar.j) != null) {
            z = hVar.performShortcut(i2, keyEvent, i3);
        }
        if (z && (i3 & 1) == 0 && this.j == null) {
            a(mVar, true);
        }
        return z;
    }

    @Override // a.b.h.a.f
    public boolean a() {
        int r = r();
        int g2 = g(r);
        boolean k2 = g2 != -1 ? k(g2) : false;
        if (r == 0) {
            o();
            this.L.d();
        }
        this.K = true;
        return k2;
    }
}
