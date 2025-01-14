package p000a.p006b.p049h.p050a;

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
import android.support.p067v7.app.AppCompatViewInflater;
import android.support.p067v7.widget.ActionBarContextView;
import android.support.p067v7.widget.ContentFrameLayout;
import android.support.p067v7.widget.Toolbar;
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
import com.j256.ormlite.logger.Logger;
import java.lang.Thread;
import java.util.List;
import org.xmlpull.v1.XmlPullParser;
import p000a.p006b.p030g.p031a.NavUtils;
import p000a.p006b.p030g.p045k.KeyEventDispatcher;
import p000a.p006b.p030g.p045k.LayoutInflaterCompat;
import p000a.p006b.p030g.p045k.OnApplyWindowInsetsListener;
import p000a.p006b.p030g.p045k.ViewCompat;
import p000a.p006b.p030g.p045k.ViewPropertyAnimatorCompat;
import p000a.p006b.p030g.p045k.ViewPropertyAnimatorListener;
import p000a.p006b.p030g.p045k.ViewPropertyAnimatorListenerAdapter;
import p000a.p006b.p030g.p045k.WindowInsetsCompat;
import p000a.p006b.p049h.p051b.C0354a;
import p000a.p006b.p049h.p051b.C0356c;
import p000a.p006b.p049h.p051b.C0359f;
import p000a.p006b.p049h.p051b.C0360g;
import p000a.p006b.p049h.p051b.C0362i;
import p000a.p006b.p049h.p051b.C0363j;
import p000a.p006b.p049h.p053d.p054a.AppCompatResources;
import p000a.p006b.p049h.p061j.ActionMode;
import p000a.p006b.p049h.p061j.ContextThemeWrapper;
import p000a.p006b.p049h.p061j.SupportActionModeWrapper;
import p000a.p006b.p049h.p061j.SupportMenuInflater;
import p000a.p006b.p049h.p061j.WindowCallbackWrapper;
import p000a.p006b.p049h.p061j.p062j.ListMenuPresenter;
import p000a.p006b.p049h.p061j.p062j.MenuBuilder;
import p000a.p006b.p049h.p061j.p062j.MenuPresenter;
import p000a.p006b.p049h.p061j.p062j.MenuView;
import p000a.p006b.p049h.p063k.AppCompatDrawableManager;
import p000a.p006b.p049h.p063k.C0504t1;
import p000a.p006b.p049h.p063k.DecorContentParent;
import p000a.p006b.p049h.p063k.FitWindowsViewGroup;
import p000a.p006b.p049h.p063k.TintTypedArray;
import p000a.p006b.p049h.p063k.VectorEnabledTintResources;

/* renamed from: a.b.h.a.g */
/* loaded from: classes.dex */
public class AppCompatDelegateImpl extends AppCompatDelegate implements MenuBuilder.InterfaceC0425a, LayoutInflater.Factory2 {

    /* renamed from: T */
    public static final boolean f1880T;

    /* renamed from: U */
    public static final int[] f1881U;

    /* renamed from: V */
    public static boolean f1882V;

    /* renamed from: A */
    public boolean f1883A;

    /* renamed from: B */
    public boolean f1884B;

    /* renamed from: C */
    public boolean f1885C;

    /* renamed from: D */
    public boolean f1886D;

    /* renamed from: E */
    public boolean f1887E;

    /* renamed from: F */
    public C0341m[] f1888F;

    /* renamed from: G */
    public C0341m f1889G;

    /* renamed from: H */
    public boolean f1890H;

    /* renamed from: I */
    public boolean f1891I;

    /* renamed from: K */
    public boolean f1893K;

    /* renamed from: L */
    public C0338k f1894L;

    /* renamed from: M */
    public boolean f1895M;

    /* renamed from: N */
    public int f1896N;

    /* renamed from: P */
    public boolean f1898P;

    /* renamed from: Q */
    public Rect f1899Q;

    /* renamed from: R */
    public Rect f1900R;

    /* renamed from: S */
    public AppCompatViewInflater f1901S;

    /* renamed from: b */
    public final Context f1902b;

    /* renamed from: c */
    public final Window f1903c;

    /* renamed from: d */
    public final Window.Callback f1904d;

    /* renamed from: e */
    public final Window.Callback f1905e;

    /* renamed from: f */
    public final AppCompatCallback f1906f;

    /* renamed from: g */
    public ActionBar f1907g;

    /* renamed from: h */
    public MenuInflater f1908h;

    /* renamed from: i */
    public CharSequence f1909i;

    /* renamed from: j */
    public DecorContentParent f1910j;

    /* renamed from: k */
    public C0334h f1911k;

    /* renamed from: m */
    public C0342n f1912m;

    /* renamed from: n */
    public ActionMode f1913n;

    /* renamed from: o */
    public ActionBarContextView f1914o;

    /* renamed from: p */
    public PopupWindow f1915p;

    /* renamed from: q */
    public Runnable f1916q;

    /* renamed from: t */
    public boolean f1919t;

    /* renamed from: u */
    public ViewGroup f1920u;

    /* renamed from: v */
    public TextView f1921v;

    /* renamed from: w */
    public View f1922w;

    /* renamed from: x */
    public boolean f1923x;

    /* renamed from: y */
    public boolean f1924y;

    /* renamed from: z */
    public boolean f1925z;

    /* renamed from: r */
    public ViewPropertyAnimatorCompat f1917r = null;

    /* renamed from: s */
    public boolean f1918s = true;

    /* renamed from: J */
    public int f1892J = -100;

    /* renamed from: O */
    public final Runnable f1897O = new RunnableC0327b();

    /* compiled from: AppCompatDelegateImpl.java */
    /* renamed from: a.b.h.a.g$a */
    /* loaded from: classes.dex */
    public static class C0326a implements Thread.UncaughtExceptionHandler {

        /* renamed from: a */
        public final /* synthetic */ Thread.UncaughtExceptionHandler f1926a;

        public C0326a(Thread.UncaughtExceptionHandler uncaughtExceptionHandler) {
            this.f1926a = uncaughtExceptionHandler;
        }

        /* renamed from: a */
        public final boolean m9043a(Throwable th) {
            String message;
            if (!(th instanceof Resources.NotFoundException) || (message = th.getMessage()) == null) {
                return false;
            }
            return message.contains("drawable") || message.contains("Drawable");
        }

        @Override // java.lang.Thread.UncaughtExceptionHandler
        public void uncaughtException(Thread thread, Throwable th) {
            if (m9043a(th)) {
                Resources.NotFoundException notFoundException = new Resources.NotFoundException(th.getMessage() + ". If the resource you are trying to use is a vector resource, you may be referencing it in an unsupported way. See AppCompatDelegate.setCompatVectorFromResourcesEnabled() for more info.");
                notFoundException.initCause(th.getCause());
                notFoundException.setStackTrace(th.getStackTrace());
                this.f1926a.uncaughtException(thread, notFoundException);
                return;
            }
            this.f1926a.uncaughtException(thread, th);
        }
    }

    /* compiled from: AppCompatDelegateImpl.java */
    /* renamed from: a.b.h.a.g$b */
    /* loaded from: classes.dex */
    public class RunnableC0327b implements Runnable {
        public RunnableC0327b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            AppCompatDelegateImpl appCompatDelegateImpl = AppCompatDelegateImpl.this;
            if ((appCompatDelegateImpl.f1896N & 1) != 0) {
                appCompatDelegateImpl.m9072e(0);
            }
            AppCompatDelegateImpl appCompatDelegateImpl2 = AppCompatDelegateImpl.this;
            if ((appCompatDelegateImpl2.f1896N & 4096) != 0) {
                appCompatDelegateImpl2.m9072e(108);
            }
            AppCompatDelegateImpl appCompatDelegateImpl3 = AppCompatDelegateImpl.this;
            appCompatDelegateImpl3.f1895M = false;
            appCompatDelegateImpl3.f1896N = 0;
        }
    }

    /* compiled from: AppCompatDelegateImpl.java */
    /* renamed from: a.b.h.a.g$c */
    /* loaded from: classes.dex */
    public class C0328c implements OnApplyWindowInsetsListener {
        public C0328c() {
        }

        @Override // p000a.p006b.p030g.p045k.OnApplyWindowInsetsListener
        /* renamed from: a */
        public WindowInsetsCompat mo7712a(View view, WindowInsetsCompat windowInsetsCompat) {
            int m9571d = windowInsetsCompat.m9571d();
            int m9058l = AppCompatDelegateImpl.this.m9058l(m9571d);
            if (m9571d != m9058l) {
                windowInsetsCompat = windowInsetsCompat.m9576a(windowInsetsCompat.m9573b(), m9058l, windowInsetsCompat.m9572c(), windowInsetsCompat.m9577a());
            }
            return ViewCompat.m9439b(view, windowInsetsCompat);
        }
    }

    /* compiled from: AppCompatDelegateImpl.java */
    /* renamed from: a.b.h.a.g$d */
    /* loaded from: classes.dex */
    public class C0329d implements FitWindowsViewGroup.InterfaceC0484a {
        public C0329d() {
        }

        @Override // p000a.p006b.p049h.p063k.FitWindowsViewGroup.InterfaceC0484a
        /* renamed from: a */
        public void mo8182a(Rect rect) {
            rect.top = AppCompatDelegateImpl.this.m9058l(rect.top);
        }
    }

    /* compiled from: AppCompatDelegateImpl.java */
    /* renamed from: a.b.h.a.g$e */
    /* loaded from: classes.dex */
    public class C0330e implements ContentFrameLayout.InterfaceC0692a {
        public C0330e() {
        }

        @Override // android.support.p067v7.widget.ContentFrameLayout.InterfaceC0692a
        /* renamed from: a */
        public void mo7058a() {
        }

        @Override // android.support.p067v7.widget.ContentFrameLayout.InterfaceC0692a
        public void onDetachedFromWindow() {
            AppCompatDelegateImpl.this.m9057m();
        }
    }

    /* compiled from: AppCompatDelegateImpl.java */
    /* renamed from: a.b.h.a.g$f */
    /* loaded from: classes.dex */
    public class RunnableC0331f implements Runnable {

        /* compiled from: AppCompatDelegateImpl.java */
        /* renamed from: a.b.h.a.g$f$a */
        /* loaded from: classes.dex */
        public class C0332a extends ViewPropertyAnimatorListenerAdapter {
            public C0332a() {
            }

            @Override // p000a.p006b.p030g.p045k.ViewPropertyAnimatorListener
            /* renamed from: b */
            public void mo8184b(View view) {
                AppCompatDelegateImpl.this.f1914o.setAlpha(1.0f);
                AppCompatDelegateImpl.this.f1917r.m9334a((ViewPropertyAnimatorListener) null);
                AppCompatDelegateImpl.this.f1917r = null;
            }

            @Override // p000a.p006b.p030g.p045k.ViewPropertyAnimatorListenerAdapter, p000a.p006b.p030g.p045k.ViewPropertyAnimatorListener
            /* renamed from: c */
            public void mo8183c(View view) {
                AppCompatDelegateImpl.this.f1914o.setVisibility(0);
            }
        }

        public RunnableC0331f() {
        }

        @Override // java.lang.Runnable
        public void run() {
            AppCompatDelegateImpl appCompatDelegateImpl = AppCompatDelegateImpl.this;
            appCompatDelegateImpl.f1915p.showAtLocation(appCompatDelegateImpl.f1914o, 55, 0, 0);
            AppCompatDelegateImpl.this.m9056n();
            if (AppCompatDelegateImpl.this.m9045y()) {
                AppCompatDelegateImpl.this.f1914o.setAlpha(0.0f);
                AppCompatDelegateImpl appCompatDelegateImpl2 = AppCompatDelegateImpl.this;
                ViewPropertyAnimatorCompat m9459a = ViewCompat.m9459a(appCompatDelegateImpl2.f1914o);
                m9459a.m9336a(1.0f);
                appCompatDelegateImpl2.f1917r = m9459a;
                AppCompatDelegateImpl.this.f1917r.m9334a(new C0332a());
                return;
            }
            AppCompatDelegateImpl.this.f1914o.setAlpha(1.0f);
            AppCompatDelegateImpl.this.f1914o.setVisibility(0);
        }
    }

    /* compiled from: AppCompatDelegateImpl.java */
    /* renamed from: a.b.h.a.g$g */
    /* loaded from: classes.dex */
    public class C0333g extends ViewPropertyAnimatorListenerAdapter {
        public C0333g() {
        }

        @Override // p000a.p006b.p030g.p045k.ViewPropertyAnimatorListener
        /* renamed from: b */
        public void mo8184b(View view) {
            AppCompatDelegateImpl.this.f1914o.setAlpha(1.0f);
            AppCompatDelegateImpl.this.f1917r.m9334a((ViewPropertyAnimatorListener) null);
            AppCompatDelegateImpl.this.f1917r = null;
        }

        @Override // p000a.p006b.p030g.p045k.ViewPropertyAnimatorListenerAdapter, p000a.p006b.p030g.p045k.ViewPropertyAnimatorListener
        /* renamed from: c */
        public void mo8183c(View view) {
            AppCompatDelegateImpl.this.f1914o.setVisibility(0);
            AppCompatDelegateImpl.this.f1914o.sendAccessibilityEvent(32);
            if (AppCompatDelegateImpl.this.f1914o.getParent() instanceof View) {
                ViewCompat.m9463B((View) AppCompatDelegateImpl.this.f1914o.getParent());
            }
        }
    }

    /* compiled from: AppCompatDelegateImpl.java */
    /* renamed from: a.b.h.a.g$i */
    /* loaded from: classes.dex */
    public class C0335i implements ActionMode.InterfaceC0414a {

        /* renamed from: a */
        public ActionMode.InterfaceC0414a f1935a;

        /* compiled from: AppCompatDelegateImpl.java */
        /* renamed from: a.b.h.a.g$i$a */
        /* loaded from: classes.dex */
        public class C0336a extends ViewPropertyAnimatorListenerAdapter {
            public C0336a() {
            }

            @Override // p000a.p006b.p030g.p045k.ViewPropertyAnimatorListener
            /* renamed from: b */
            public void mo8184b(View view) {
                AppCompatDelegateImpl.this.f1914o.setVisibility(8);
                AppCompatDelegateImpl appCompatDelegateImpl = AppCompatDelegateImpl.this;
                PopupWindow popupWindow = appCompatDelegateImpl.f1915p;
                if (popupWindow != null) {
                    popupWindow.dismiss();
                } else if (appCompatDelegateImpl.f1914o.getParent() instanceof View) {
                    ViewCompat.m9463B((View) AppCompatDelegateImpl.this.f1914o.getParent());
                }
                AppCompatDelegateImpl.this.f1914o.removeAllViews();
                AppCompatDelegateImpl.this.f1917r.m9334a((ViewPropertyAnimatorListener) null);
                AppCompatDelegateImpl.this.f1917r = null;
            }
        }

        public C0335i(ActionMode.InterfaceC0414a interfaceC0414a) {
            this.f1935a = interfaceC0414a;
        }

        @Override // p000a.p006b.p049h.p061j.ActionMode.InterfaceC0414a
        /* renamed from: a */
        public boolean mo8752a(ActionMode actionMode, Menu menu) {
            return this.f1935a.mo8752a(actionMode, menu);
        }

        @Override // p000a.p006b.p049h.p061j.ActionMode.InterfaceC0414a
        /* renamed from: b */
        public boolean mo8748b(ActionMode actionMode, Menu menu) {
            return this.f1935a.mo8748b(actionMode, menu);
        }

        @Override // p000a.p006b.p049h.p061j.ActionMode.InterfaceC0414a
        /* renamed from: a */
        public boolean mo8751a(ActionMode actionMode, MenuItem menuItem) {
            return this.f1935a.mo8751a(actionMode, menuItem);
        }

        @Override // p000a.p006b.p049h.p061j.ActionMode.InterfaceC0414a
        /* renamed from: a */
        public void mo8753a(ActionMode actionMode) {
            this.f1935a.mo8753a(actionMode);
            AppCompatDelegateImpl appCompatDelegateImpl = AppCompatDelegateImpl.this;
            if (appCompatDelegateImpl.f1915p != null) {
                appCompatDelegateImpl.f1903c.getDecorView().removeCallbacks(AppCompatDelegateImpl.this.f1916q);
            }
            AppCompatDelegateImpl appCompatDelegateImpl2 = AppCompatDelegateImpl.this;
            if (appCompatDelegateImpl2.f1914o != null) {
                appCompatDelegateImpl2.m9056n();
                AppCompatDelegateImpl appCompatDelegateImpl3 = AppCompatDelegateImpl.this;
                ViewPropertyAnimatorCompat m9459a = ViewCompat.m9459a(appCompatDelegateImpl3.f1914o);
                m9459a.m9336a(0.0f);
                appCompatDelegateImpl3.f1917r = m9459a;
                AppCompatDelegateImpl.this.f1917r.m9334a(new C0336a());
            }
            AppCompatDelegateImpl appCompatDelegateImpl4 = AppCompatDelegateImpl.this;
            AppCompatCallback appCompatCallback = appCompatDelegateImpl4.f1906f;
            if (appCompatCallback != null) {
                appCompatCallback.mo9029a(appCompatDelegateImpl4.f1913n);
            }
            AppCompatDelegateImpl.this.f1913n = null;
        }
    }

    /* compiled from: AppCompatDelegateImpl.java */
    /* renamed from: a.b.h.a.g$k */
    /* loaded from: classes.dex */
    public final class C0338k {

        /* renamed from: a */
        public TwilightManager f1939a;

        /* renamed from: b */
        public boolean f1940b;

        /* renamed from: c */
        public BroadcastReceiver f1941c;

        /* renamed from: d */
        public IntentFilter f1942d;

        /* compiled from: AppCompatDelegateImpl.java */
        /* renamed from: a.b.h.a.g$k$a */
        /* loaded from: classes.dex */
        public class C0339a extends BroadcastReceiver {
            public C0339a() {
            }

            @Override // android.content.BroadcastReceiver
            public void onReceive(Context context, Intent intent) {
                C0338k.this.m9040b();
            }
        }

        public C0338k(TwilightManager twilightManager) {
            this.f1939a = twilightManager;
            this.f1940b = twilightManager.m9004b();
        }

        /* renamed from: a */
        public void m9041a() {
            BroadcastReceiver broadcastReceiver = this.f1941c;
            if (broadcastReceiver != null) {
                AppCompatDelegateImpl.this.f1902b.unregisterReceiver(broadcastReceiver);
                this.f1941c = null;
            }
        }

        /* renamed from: b */
        public void m9040b() {
            boolean m9004b = this.f1939a.m9004b();
            if (m9004b != this.f1940b) {
                this.f1940b = m9004b;
                AppCompatDelegateImpl.this.mo9112a();
            }
        }

        /* renamed from: c */
        public int m9039c() {
            this.f1940b = this.f1939a.m9004b();
            return this.f1940b ? 2 : 1;
        }

        /* renamed from: d */
        public void m9038d() {
            m9041a();
            if (this.f1941c == null) {
                this.f1941c = new C0339a();
            }
            if (this.f1942d == null) {
                this.f1942d = new IntentFilter();
                this.f1942d.addAction("android.intent.action.TIME_SET");
                this.f1942d.addAction("android.intent.action.TIMEZONE_CHANGED");
                this.f1942d.addAction("android.intent.action.TIME_TICK");
            }
            AppCompatDelegateImpl.this.f1902b.registerReceiver(this.f1941c, this.f1942d);
        }
    }

    /* compiled from: AppCompatDelegateImpl.java */
    /* renamed from: a.b.h.a.g$l */
    /* loaded from: classes.dex */
    public class C0340l extends ContentFrameLayout {
        public C0340l(Context context) {
            super(context);
        }

        /* renamed from: a */
        public final boolean m9037a(int i, int i2) {
            return i < -5 || i2 < -5 || i > getWidth() + 5 || i2 > getHeight() + 5;
        }

        @Override // android.view.ViewGroup, android.view.View
        public boolean dispatchKeyEvent(KeyEvent keyEvent) {
            return AppCompatDelegateImpl.this.m9098a(keyEvent) || super.dispatchKeyEvent(keyEvent);
        }

        @Override // android.view.ViewGroup
        public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
            if (motionEvent.getAction() == 0 && m9037a((int) motionEvent.getX(), (int) motionEvent.getY())) {
                AppCompatDelegateImpl.this.m9075d(0);
                return true;
            }
            return super.onInterceptTouchEvent(motionEvent);
        }

        @Override // android.view.View
        public void setBackgroundResource(int i) {
            setBackgroundDrawable(AppCompatResources.m8967c(getContext(), i));
        }
    }

    static {
        f1880T = Build.VERSION.SDK_INT < 21;
        f1881U = new int[]{16842836};
        if (!f1880T || f1882V) {
            return;
        }
        Thread.setDefaultUncaughtExceptionHandler(new C0326a(Thread.getDefaultUncaughtExceptionHandler()));
        f1882V = true;
    }

    public AppCompatDelegateImpl(Context context, Window window, AppCompatCallback appCompatCallback) {
        this.f1902b = context;
        this.f1903c = window;
        this.f1906f = appCompatCallback;
        this.f1904d = this.f1903c.getCallback();
        Window.Callback callback = this.f1904d;
        if (!(callback instanceof C0337j)) {
            this.f1905e = new C0337j(callback);
            this.f1903c.setCallback(this.f1905e);
            TintTypedArray m8258a = TintTypedArray.m8258a(context, (AttributeSet) null, f1881U);
            Drawable m8253c = m8258a.m8253c(0);
            if (m8253c != null) {
                this.f1903c.setBackgroundDrawable(m8253c);
            }
            m8258a.m8265a();
            return;
        }
        throw new IllegalStateException("AppCompat has already installed itself into the Window");
    }

    /* renamed from: A */
    public final void m9113A() {
        if (this.f1919t) {
            throw new AndroidRuntimeException("Window feature must be requested before adding content");
        }
    }

    @Override // p000a.p006b.p049h.p050a.AppCompatDelegate
    /* renamed from: a */
    public void mo9100a(Bundle bundle) {
        Window.Callback callback = this.f1904d;
        if (callback instanceof Activity) {
            String str = null;
            try {
                str = NavUtils.m10072b((Activity) callback);
            } catch (IllegalArgumentException unused) {
            }
            if (str != null) {
                ActionBar m9046x = m9046x();
                if (m9046x == null) {
                    this.f1898P = true;
                } else {
                    m9046x.mo8992c(true);
                }
            }
        }
        if (bundle == null || this.f1892J != -100) {
            return;
        }
        this.f1892J = bundle.getInt("appcompat:local_night_mode", -100);
    }

    /* renamed from: a */
    public void m9093a(ViewGroup viewGroup) {
    }

    @Override // p000a.p006b.p049h.p050a.AppCompatDelegate
    /* renamed from: b */
    public void mo9083b(Bundle bundle) {
        m9054p();
    }

    @Override // p000a.p006b.p049h.p050a.AppCompatDelegate
    /* renamed from: c */
    public ActionBar mo9081c() {
        m9049u();
        return this.f1907g;
    }

    /* renamed from: d */
    public boolean m9074d(int i, KeyEvent keyEvent) {
        if (i == 4) {
            boolean z = this.f1890H;
            this.f1890H = false;
            C0341m m9108a = m9108a(0, false);
            if (m9108a != null && m9108a.f1960o) {
                if (!z) {
                    m9104a(m9108a, true);
                }
                return true;
            } else if (m9047w()) {
                return true;
            }
        } else if (i == 82) {
            m9071e(0, keyEvent);
            return true;
        }
        return false;
    }

    @Override // p000a.p006b.p049h.p050a.AppCompatDelegate
    /* renamed from: e */
    public void mo9073e() {
        ActionBar mo9081c = mo9081c();
        if (mo9081c == null || !mo9081c.mo9016i()) {
            m9069f(0);
        }
    }

    @Override // p000a.p006b.p049h.p050a.AppCompatDelegate
    /* renamed from: f */
    public void mo9070f() {
        if (this.f1895M) {
            this.f1903c.getDecorView().removeCallbacks(this.f1897O);
        }
        this.f1891I = true;
        ActionBar actionBar = this.f1907g;
        if (actionBar != null) {
            actionBar.mo9015j();
        }
        C0338k c0338k = this.f1894L;
        if (c0338k != null) {
            c0338k.m9041a();
        }
    }

    @Override // p000a.p006b.p049h.p050a.AppCompatDelegate
    /* renamed from: g */
    public void mo9068g() {
        ActionBar mo9081c = mo9081c();
        if (mo9081c != null) {
            mo9081c.mo8990e(true);
        }
    }

    @Override // p000a.p006b.p049h.p050a.AppCompatDelegate
    /* renamed from: h */
    public void mo9066h() {
        mo9112a();
    }

    @Override // p000a.p006b.p049h.p050a.AppCompatDelegate
    /* renamed from: i */
    public void mo9064i() {
        ActionBar mo9081c = mo9081c();
        if (mo9081c != null) {
            mo9081c.mo8990e(false);
        }
        C0338k c0338k = this.f1894L;
        if (c0338k != null) {
            c0338k.m9041a();
        }
    }

    /* renamed from: j */
    public final int m9062j(int i) {
        if (i == 8) {
            Log.i("AppCompatDelegate", "You should now use the AppCompatDelegate.FEATURE_SUPPORT_ACTION_BAR id when requesting this feature.");
            return 108;
        } else if (i == 9) {
            Log.i("AppCompatDelegate", "You should now use the AppCompatDelegate.FEATURE_SUPPORT_ACTION_BAR_OVERLAY id when requesting this feature.");
            return 109;
        } else {
            return i;
        }
    }

    /* renamed from: k */
    public final void m9061k() {
        ContentFrameLayout contentFrameLayout = (ContentFrameLayout) this.f1920u.findViewById(16908290);
        View decorView = this.f1903c.getDecorView();
        contentFrameLayout.m7060a(decorView.getPaddingLeft(), decorView.getPaddingTop(), decorView.getPaddingRight(), decorView.getPaddingBottom());
        TypedArray obtainStyledAttributes = this.f1902b.obtainStyledAttributes(C0363j.AppCompatTheme);
        obtainStyledAttributes.getValue(C0363j.AppCompatTheme_windowMinWidthMajor, contentFrameLayout.getMinWidthMajor());
        obtainStyledAttributes.getValue(C0363j.AppCompatTheme_windowMinWidthMinor, contentFrameLayout.getMinWidthMinor());
        if (obtainStyledAttributes.hasValue(C0363j.AppCompatTheme_windowFixedWidthMajor)) {
            obtainStyledAttributes.getValue(C0363j.AppCompatTheme_windowFixedWidthMajor, contentFrameLayout.getFixedWidthMajor());
        }
        if (obtainStyledAttributes.hasValue(C0363j.AppCompatTheme_windowFixedWidthMinor)) {
            obtainStyledAttributes.getValue(C0363j.AppCompatTheme_windowFixedWidthMinor, contentFrameLayout.getFixedWidthMinor());
        }
        if (obtainStyledAttributes.hasValue(C0363j.AppCompatTheme_windowFixedHeightMajor)) {
            obtainStyledAttributes.getValue(C0363j.AppCompatTheme_windowFixedHeightMajor, contentFrameLayout.getFixedHeightMajor());
        }
        if (obtainStyledAttributes.hasValue(C0363j.AppCompatTheme_windowFixedHeightMinor)) {
            obtainStyledAttributes.getValue(C0363j.AppCompatTheme_windowFixedHeightMinor, contentFrameLayout.getFixedHeightMinor());
        }
        obtainStyledAttributes.recycle();
        contentFrameLayout.requestLayout();
    }

    /* renamed from: l */
    public final ViewGroup m9059l() {
        ViewGroup viewGroup;
        Context context;
        TypedArray obtainStyledAttributes = this.f1902b.obtainStyledAttributes(C0363j.AppCompatTheme);
        if (obtainStyledAttributes.hasValue(C0363j.AppCompatTheme_windowActionBar)) {
            if (obtainStyledAttributes.getBoolean(C0363j.AppCompatTheme_windowNoTitle, false)) {
                mo9089b(1);
            } else if (obtainStyledAttributes.getBoolean(C0363j.AppCompatTheme_windowActionBar, false)) {
                mo9089b(108);
            }
            if (obtainStyledAttributes.getBoolean(C0363j.AppCompatTheme_windowActionBarOverlay, false)) {
                mo9089b(109);
            }
            if (obtainStyledAttributes.getBoolean(C0363j.AppCompatTheme_windowActionModeOverlay, false)) {
                mo9089b(10);
            }
            this.f1885C = obtainStyledAttributes.getBoolean(C0363j.AppCompatTheme_android_windowIsFloating, false);
            obtainStyledAttributes.recycle();
            this.f1903c.getDecorView();
            LayoutInflater from = LayoutInflater.from(this.f1902b);
            if (!this.f1886D) {
                if (this.f1885C) {
                    viewGroup = (ViewGroup) from.inflate(C0360g.abc_dialog_title_material, (ViewGroup) null);
                    this.f1883A = false;
                    this.f1925z = false;
                } else if (this.f1925z) {
                    TypedValue typedValue = new TypedValue();
                    this.f1902b.getTheme().resolveAttribute(C0354a.actionBarTheme, typedValue, true);
                    int i = typedValue.resourceId;
                    if (i != 0) {
                        context = new ContextThemeWrapper(this.f1902b, i);
                    } else {
                        context = this.f1902b;
                    }
                    viewGroup = (ViewGroup) LayoutInflater.from(context).inflate(C0360g.abc_screen_toolbar, (ViewGroup) null);
                    this.f1910j = (DecorContentParent) viewGroup.findViewById(C0359f.decor_content_parent);
                    this.f1910j.setWindowCallback(m9050t());
                    if (this.f1883A) {
                        this.f1910j.mo7120a(109);
                    }
                    if (this.f1923x) {
                        this.f1910j.mo7120a(2);
                    }
                    if (this.f1924y) {
                        this.f1910j.mo7120a(5);
                    }
                } else {
                    viewGroup = null;
                }
            } else {
                if (this.f1884B) {
                    viewGroup = (ViewGroup) from.inflate(C0360g.abc_screen_simple_overlay_action_mode, (ViewGroup) null);
                } else {
                    viewGroup = (ViewGroup) from.inflate(C0360g.abc_screen_simple, (ViewGroup) null);
                }
                if (Build.VERSION.SDK_INT >= 21) {
                    ViewCompat.m9452a(viewGroup, new C0328c());
                } else {
                    ((FitWindowsViewGroup) viewGroup).setOnFitSystemWindowsListener(new C0329d());
                }
            }
            if (viewGroup != null) {
                if (this.f1910j == null) {
                    this.f1921v = (TextView) viewGroup.findViewById(C0359f.title);
                }
                C0504t1.m8045b(viewGroup);
                ContentFrameLayout contentFrameLayout = (ContentFrameLayout) viewGroup.findViewById(C0359f.action_bar_activity_content);
                ViewGroup viewGroup2 = (ViewGroup) this.f1903c.findViewById(16908290);
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
                this.f1903c.setContentView(viewGroup);
                contentFrameLayout.setAttachListener(new C0330e());
                return viewGroup;
            }
            throw new IllegalArgumentException("AppCompat does not support the current theme features: { windowActionBar: " + this.f1925z + ", windowActionBarOverlay: " + this.f1883A + ", android:windowIsFloating: " + this.f1885C + ", windowActionModeOverlay: " + this.f1884B + ", windowNoTitle: " + this.f1886D + " }");
        }
        obtainStyledAttributes.recycle();
        throw new IllegalStateException("You need to use a Theme.AppCompat theme (or descendant) with this activity.");
    }

    /* renamed from: m */
    public void m9057m() {
        MenuBuilder menuBuilder;
        DecorContentParent decorContentParent = this.f1910j;
        if (decorContentParent != null) {
            decorContentParent.mo7110g();
        }
        if (this.f1915p != null) {
            this.f1903c.getDecorView().removeCallbacks(this.f1916q);
            if (this.f1915p.isShowing()) {
                try {
                    this.f1915p.dismiss();
                } catch (IllegalArgumentException unused) {
                }
            }
            this.f1915p = null;
        }
        m9056n();
        C0341m m9108a = m9108a(0, false);
        if (m9108a == null || (menuBuilder = m9108a.f1955j) == null) {
            return;
        }
        menuBuilder.close();
    }

    /* renamed from: n */
    public void m9056n() {
        ViewPropertyAnimatorCompat viewPropertyAnimatorCompat = this.f1917r;
        if (viewPropertyAnimatorCompat != null) {
            viewPropertyAnimatorCompat.m9337a();
        }
    }

    /* renamed from: o */
    public final void m9055o() {
        if (this.f1894L == null) {
            this.f1894L = new C0338k(TwilightManager.m9007a(this.f1902b));
        }
    }

    @Override // android.view.LayoutInflater.Factory2
    public final View onCreateView(View view, String str, Context context, AttributeSet attributeSet) {
        return m9094a(view, str, context, attributeSet);
    }

    /* renamed from: p */
    public final void m9054p() {
        if (this.f1919t) {
            return;
        }
        this.f1920u = m9059l();
        CharSequence m9051s = m9051s();
        if (!TextUtils.isEmpty(m9051s)) {
            DecorContentParent decorContentParent = this.f1910j;
            if (decorContentParent != null) {
                decorContentParent.setWindowTitle(m9051s);
            } else if (m9046x() != null) {
                m9046x().mo8996a(m9051s);
            } else {
                TextView textView = this.f1921v;
                if (textView != null) {
                    textView.setText(m9051s);
                }
            }
        }
        m9061k();
        m9093a(this.f1920u);
        this.f1919t = true;
        C0341m m9108a = m9108a(0, false);
        if (this.f1891I) {
            return;
        }
        if (m9108a == null || m9108a.f1955j == null) {
            m9069f(108);
        }
    }

    /* renamed from: q */
    public final Context m9053q() {
        ActionBar mo9081c = mo9081c();
        Context mo8985h = mo9081c != null ? mo9081c.mo8985h() : null;
        return mo8985h == null ? this.f1902b : mo8985h;
    }

    /* renamed from: r */
    public final int m9052r() {
        int i = this.f1892J;
        return i != -100 ? i : AppCompatDelegate.m9114j();
    }

    /* renamed from: s */
    public final CharSequence m9051s() {
        Window.Callback callback = this.f1904d;
        if (callback instanceof Activity) {
            return ((Activity) callback).getTitle();
        }
        return this.f1909i;
    }

    /* renamed from: t */
    public final Window.Callback m9050t() {
        return this.f1903c.getCallback();
    }

    /* renamed from: u */
    public final void m9049u() {
        m9054p();
        if (this.f1925z && this.f1907g == null) {
            Window.Callback callback = this.f1904d;
            if (callback instanceof Activity) {
                this.f1907g = new WindowDecorActionBar((Activity) callback, this.f1883A);
            } else if (callback instanceof Dialog) {
                this.f1907g = new WindowDecorActionBar((Dialog) callback);
            }
            ActionBar actionBar = this.f1907g;
            if (actionBar != null) {
                actionBar.mo8992c(this.f1898P);
            }
        }
    }

    /* renamed from: v */
    public boolean m9048v() {
        return this.f1918s;
    }

    /* renamed from: w */
    public boolean m9047w() {
        ActionMode actionMode = this.f1913n;
        if (actionMode != null) {
            actionMode.mo8767a();
            return true;
        }
        ActionBar mo9081c = mo9081c();
        return mo9081c != null && mo9081c.mo8989f();
    }

    /* renamed from: x */
    public final ActionBar m9046x() {
        return this.f1907g;
    }

    /* renamed from: y */
    public final boolean m9045y() {
        ViewGroup viewGroup;
        return this.f1919t && (viewGroup = this.f1920u) != null && ViewCompat.m9409x(viewGroup);
    }

    /* renamed from: z */
    public final boolean m9044z() {
        if (this.f1893K) {
            Context context = this.f1902b;
            if (context instanceof Activity) {
                try {
                    return (context.getPackageManager().getActivityInfo(new ComponentName(this.f1902b, this.f1902b.getClass()), 0).configChanges & 512) == 0;
                } catch (PackageManager.NameNotFoundException e) {
                    Log.d("AppCompatDelegate", "Exception while getting ActivityInfo", e);
                    return true;
                }
            }
        }
        return false;
    }

    /* compiled from: AppCompatDelegateImpl.java */
    /* renamed from: a.b.h.a.g$h */
    /* loaded from: classes.dex */
    public final class C0334h implements MenuPresenter.InterfaceC0434a {
        public C0334h() {
        }

        @Override // p000a.p006b.p049h.p061j.p062j.MenuPresenter.InterfaceC0434a
        /* renamed from: a */
        public boolean mo7080a(MenuBuilder menuBuilder) {
            Window.Callback m9050t = AppCompatDelegateImpl.this.m9050t();
            if (m9050t != null) {
                m9050t.onMenuOpened(108, menuBuilder);
                return true;
            }
            return true;
        }

        @Override // p000a.p006b.p049h.p061j.p062j.MenuPresenter.InterfaceC0434a
        /* renamed from: a */
        public void mo7079a(MenuBuilder menuBuilder, boolean z) {
            AppCompatDelegateImpl.this.m9084b(menuBuilder);
        }
    }

    @Override // p000a.p006b.p049h.p050a.AppCompatDelegate
    /* renamed from: b */
    public MenuInflater mo9090b() {
        if (this.f1908h == null) {
            m9049u();
            ActionBar actionBar = this.f1907g;
            this.f1908h = new SupportMenuInflater(actionBar != null ? actionBar.mo8985h() : this.f1902b);
        }
        return this.f1908h;
    }

    /* renamed from: h */
    public void m9065h(int i) {
        ActionBar mo9081c;
        if (i != 108 || (mo9081c = mo9081c()) == null) {
            return;
        }
        mo9081c.mo8993b(true);
    }

    @Override // android.view.LayoutInflater.Factory
    public View onCreateView(String str, Context context, AttributeSet attributeSet) {
        return onCreateView(null, str, context, attributeSet);
    }

    /* compiled from: AppCompatDelegateImpl.java */
    /* renamed from: a.b.h.a.g$m */
    /* loaded from: classes.dex */
    public static final class C0341m {

        /* renamed from: a */
        public int f1946a;

        /* renamed from: b */
        public int f1947b;

        /* renamed from: c */
        public int f1948c;

        /* renamed from: d */
        public int f1949d;

        /* renamed from: e */
        public int f1950e;

        /* renamed from: f */
        public int f1951f;

        /* renamed from: g */
        public ViewGroup f1952g;

        /* renamed from: h */
        public View f1953h;

        /* renamed from: i */
        public View f1954i;

        /* renamed from: j */
        public MenuBuilder f1955j;

        /* renamed from: k */
        public ListMenuPresenter f1956k;

        /* renamed from: l */
        public Context f1957l;

        /* renamed from: m */
        public boolean f1958m;

        /* renamed from: n */
        public boolean f1959n;

        /* renamed from: o */
        public boolean f1960o;

        /* renamed from: p */
        public boolean f1961p;

        /* renamed from: q */
        public boolean f1962q = false;

        /* renamed from: r */
        public boolean f1963r;

        /* renamed from: s */
        public Bundle f1964s;

        public C0341m(int i) {
            this.f1946a = i;
        }

        /* renamed from: a */
        public boolean m9036a() {
            if (this.f1953h == null) {
                return false;
            }
            return this.f1954i != null || this.f1956k.m8705d().getCount() > 0;
        }

        /* renamed from: a */
        public void m9033a(Context context) {
            TypedValue typedValue = new TypedValue();
            Resources.Theme newTheme = context.getResources().newTheme();
            newTheme.setTo(context.getTheme());
            newTheme.resolveAttribute(C0354a.actionBarPopupTheme, typedValue, true);
            int i = typedValue.resourceId;
            if (i != 0) {
                newTheme.applyStyle(i, true);
            }
            newTheme.resolveAttribute(C0354a.panelMenuListTheme, typedValue, true);
            int i2 = typedValue.resourceId;
            if (i2 != 0) {
                newTheme.applyStyle(i2, true);
            } else {
                newTheme.applyStyle(C0362i.Theme_AppCompat_CompactMenu, true);
            }
            ContextThemeWrapper contextThemeWrapper = new ContextThemeWrapper(context, 0);
            contextThemeWrapper.getTheme().setTo(newTheme);
            this.f1957l = contextThemeWrapper;
            TypedArray obtainStyledAttributes = contextThemeWrapper.obtainStyledAttributes(C0363j.AppCompatTheme);
            this.f1947b = obtainStyledAttributes.getResourceId(C0363j.AppCompatTheme_panelBackground, 0);
            this.f1951f = obtainStyledAttributes.getResourceId(C0363j.AppCompatTheme_android_windowAnimationStyle, 0);
            obtainStyledAttributes.recycle();
        }

        /* renamed from: a */
        public void m9035a(MenuBuilder menuBuilder) {
            ListMenuPresenter listMenuPresenter;
            MenuBuilder menuBuilder2 = this.f1955j;
            if (menuBuilder == menuBuilder2) {
                return;
            }
            if (menuBuilder2 != null) {
                menuBuilder2.m8677b(this.f1956k);
            }
            this.f1955j = menuBuilder;
            if (menuBuilder == null || (listMenuPresenter = this.f1956k) == null) {
                return;
            }
            menuBuilder.m8692a(listMenuPresenter);
        }

        /* renamed from: a */
        public MenuView m9034a(MenuPresenter.InterfaceC0434a interfaceC0434a) {
            if (this.f1955j == null) {
                return null;
            }
            if (this.f1956k == null) {
                this.f1956k = new ListMenuPresenter(this.f1957l, C0360g.abc_list_menu_item_layout);
                this.f1956k.mo8587a(interfaceC0434a);
                this.f1955j.m8692a(this.f1956k);
            }
            return this.f1956k.m8707a(this.f1952g);
        }
    }

    @Override // p000a.p006b.p049h.p050a.AppCompatDelegate
    /* renamed from: c */
    public void mo9080c(int i) {
        m9054p();
        ViewGroup viewGroup = (ViewGroup) this.f1920u.findViewById(16908290);
        viewGroup.removeAllViews();
        LayoutInflater.from(this.f1902b).inflate(i, viewGroup);
        this.f1904d.onContentChanged();
    }

    /* renamed from: g */
    public int m9067g(int i) {
        if (i != -100) {
            if (i != 0) {
                return i;
            }
            if (Build.VERSION.SDK_INT < 23 || ((UiModeManager) this.f1902b.getSystemService(UiModeManager.class)).getNightMode() != 0) {
                m9055o();
                return this.f1894L.m9039c();
            }
            return -1;
        }
        return -1;
    }

    /* compiled from: AppCompatDelegateImpl.java */
    /* renamed from: a.b.h.a.g$j */
    /* loaded from: classes.dex */
    public class C0337j extends WindowCallbackWrapper {
        public C0337j(Window.Callback callback) {
            super(callback);
        }

        /* renamed from: a */
        public final android.view.ActionMode m9042a(ActionMode.Callback callback) {
            SupportActionModeWrapper.C0415a c0415a = new SupportActionModeWrapper.C0415a(AppCompatDelegateImpl.this.f1902b, callback);
            p000a.p006b.p049h.p061j.ActionMode m9103a = AppCompatDelegateImpl.this.m9103a(c0415a);
            if (m9103a != null) {
                return c0415a.m8749b(m9103a);
            }
            return null;
        }

        @Override // p000a.p006b.p049h.p061j.WindowCallbackWrapper, android.view.Window.Callback
        public boolean dispatchKeyEvent(KeyEvent keyEvent) {
            return AppCompatDelegateImpl.this.m9098a(keyEvent) || super.dispatchKeyEvent(keyEvent);
        }

        @Override // p000a.p006b.p049h.p061j.WindowCallbackWrapper, android.view.Window.Callback
        public boolean dispatchKeyShortcutEvent(KeyEvent keyEvent) {
            return super.dispatchKeyShortcutEvent(keyEvent) || AppCompatDelegateImpl.this.m9079c(keyEvent.getKeyCode(), keyEvent);
        }

        @Override // p000a.p006b.p049h.p061j.WindowCallbackWrapper, android.view.Window.Callback
        public void onContentChanged() {
        }

        @Override // p000a.p006b.p049h.p061j.WindowCallbackWrapper, android.view.Window.Callback
        public boolean onCreatePanelMenu(int i, Menu menu) {
            if (i != 0 || (menu instanceof MenuBuilder)) {
                return super.onCreatePanelMenu(i, menu);
            }
            return false;
        }

        @Override // p000a.p006b.p049h.p061j.WindowCallbackWrapper, android.view.Window.Callback
        public boolean onMenuOpened(int i, Menu menu) {
            super.onMenuOpened(i, menu);
            AppCompatDelegateImpl.this.m9065h(i);
            return true;
        }

        @Override // p000a.p006b.p049h.p061j.WindowCallbackWrapper, android.view.Window.Callback
        public void onPanelClosed(int i, Menu menu) {
            super.onPanelClosed(i, menu);
            AppCompatDelegateImpl.this.m9063i(i);
        }

        @Override // p000a.p006b.p049h.p061j.WindowCallbackWrapper, android.view.Window.Callback
        public boolean onPreparePanel(int i, View view, Menu menu) {
            MenuBuilder menuBuilder = menu instanceof MenuBuilder ? (MenuBuilder) menu : null;
            if (i == 0 && menuBuilder == null) {
                return false;
            }
            if (menuBuilder != null) {
                menuBuilder.m8666d(true);
            }
            boolean onPreparePanel = super.onPreparePanel(i, view, menu);
            if (menuBuilder != null) {
                menuBuilder.m8666d(false);
            }
            return onPreparePanel;
        }

        @Override // p000a.p006b.p049h.p061j.WindowCallbackWrapper, android.view.Window.Callback
        public void onProvideKeyboardShortcuts(List<KeyboardShortcutGroup> list, Menu menu, int i) {
            MenuBuilder menuBuilder;
            C0341m m9108a = AppCompatDelegateImpl.this.m9108a(0, true);
            if (m9108a != null && (menuBuilder = m9108a.f1955j) != null) {
                super.onProvideKeyboardShortcuts(list, menuBuilder, i);
            } else {
                super.onProvideKeyboardShortcuts(list, menu, i);
            }
        }

        @Override // p000a.p006b.p049h.p061j.WindowCallbackWrapper, android.view.Window.Callback
        public android.view.ActionMode onWindowStartingActionMode(ActionMode.Callback callback) {
            if (Build.VERSION.SDK_INT >= 23) {
                return null;
            }
            if (AppCompatDelegateImpl.this.m9048v()) {
                return m9042a(callback);
            }
            return super.onWindowStartingActionMode(callback);
        }

        @Override // p000a.p006b.p049h.p061j.WindowCallbackWrapper, android.view.Window.Callback
        public android.view.ActionMode onWindowStartingActionMode(ActionMode.Callback callback, int i) {
            if (AppCompatDelegateImpl.this.m9048v() && i == 0) {
                return m9042a(callback);
            }
            return super.onWindowStartingActionMode(callback, i);
        }
    }

    /* renamed from: e */
    public final boolean m9071e(int i, KeyEvent keyEvent) {
        boolean z;
        boolean z2;
        DecorContentParent decorContentParent;
        if (this.f1913n != null) {
            return false;
        }
        C0341m m9108a = m9108a(i, true);
        if (i == 0 && (decorContentParent = this.f1910j) != null && decorContentParent.mo7111f() && !ViewConfiguration.get(this.f1902b).hasPermanentMenuKey()) {
            if (!this.f1910j.mo7122a()) {
                if (!this.f1891I && m9086b(m9108a, keyEvent)) {
                    z = this.f1910j.mo7112e();
                }
                z = false;
            } else {
                z = this.f1910j.mo7113d();
            }
        } else if (!m9108a.f1960o && !m9108a.f1959n) {
            if (m9108a.f1958m) {
                if (m9108a.f1963r) {
                    m9108a.f1958m = false;
                    z2 = m9086b(m9108a, keyEvent);
                } else {
                    z2 = true;
                }
                if (z2) {
                    m9105a(m9108a, keyEvent);
                    z = true;
                }
            }
            z = false;
        } else {
            z = m9108a.f1960o;
            m9104a(m9108a, true);
        }
        if (z) {
            AudioManager audioManager = (AudioManager) this.f1902b.getSystemService("audio");
            if (audioManager != null) {
                audioManager.playSoundEffect(0);
            } else {
                Log.w("AppCompatDelegate", "Couldn't get audio manager");
            }
        }
        return z;
    }

    /* compiled from: AppCompatDelegateImpl.java */
    /* renamed from: a.b.h.a.g$n */
    /* loaded from: classes.dex */
    public final class C0342n implements MenuPresenter.InterfaceC0434a {
        public C0342n() {
        }

        @Override // p000a.p006b.p049h.p061j.p062j.MenuPresenter.InterfaceC0434a
        /* renamed from: a */
        public void mo7079a(MenuBuilder menuBuilder, boolean z) {
            MenuBuilder mo8574m = menuBuilder.mo8574m();
            boolean z2 = mo8574m != menuBuilder;
            AppCompatDelegateImpl appCompatDelegateImpl = AppCompatDelegateImpl.this;
            if (z2) {
                menuBuilder = mo8574m;
            }
            C0341m m9097a = appCompatDelegateImpl.m9097a((Menu) menuBuilder);
            if (m9097a != null) {
                if (z2) {
                    AppCompatDelegateImpl.this.m9110a(m9097a.f1946a, m9097a, mo8574m);
                    AppCompatDelegateImpl.this.m9104a(m9097a, true);
                    return;
                }
                AppCompatDelegateImpl.this.m9104a(m9097a, z);
            }
        }

        @Override // p000a.p006b.p049h.p061j.p062j.MenuPresenter.InterfaceC0434a
        /* renamed from: a */
        public boolean mo7080a(MenuBuilder menuBuilder) {
            Window.Callback m9050t;
            if (menuBuilder == null) {
                AppCompatDelegateImpl appCompatDelegateImpl = AppCompatDelegateImpl.this;
                if (!appCompatDelegateImpl.f1925z || (m9050t = appCompatDelegateImpl.m9050t()) == null || AppCompatDelegateImpl.this.f1891I) {
                    return true;
                }
                m9050t.onMenuOpened(108, menuBuilder);
                return true;
            }
            return true;
        }
    }

    /* renamed from: i */
    public void m9063i(int i) {
        if (i == 108) {
            ActionBar mo9081c = mo9081c();
            if (mo9081c != null) {
                mo9081c.mo8993b(false);
            }
        } else if (i == 0) {
            C0341m m9108a = m9108a(i, true);
            if (m9108a.f1960o) {
                m9104a(m9108a, false);
            }
        }
    }

    @Override // p000a.p006b.p049h.p050a.AppCompatDelegate
    /* renamed from: b */
    public void mo9082b(View view, ViewGroup.LayoutParams layoutParams) {
        m9054p();
        ViewGroup viewGroup = (ViewGroup) this.f1920u.findViewById(16908290);
        viewGroup.removeAllViews();
        viewGroup.addView(view, layoutParams);
        this.f1904d.onContentChanged();
    }

    @Override // p000a.p006b.p049h.p050a.AppCompatDelegate
    /* renamed from: a */
    public void mo9099a(Toolbar toolbar) {
        if (this.f1904d instanceof Activity) {
            ActionBar mo9081c = mo9081c();
            if (!(mo9081c instanceof WindowDecorActionBar)) {
                this.f1908h = null;
                if (mo9081c != null) {
                    mo9081c.mo9015j();
                }
                if (toolbar != null) {
                    ToolbarActionBar toolbarActionBar = new ToolbarActionBar(toolbar, ((Activity) this.f1904d).getTitle(), this.f1905e);
                    this.f1907g = toolbarActionBar;
                    this.f1903c.setCallback(toolbarActionBar.m9012m());
                } else {
                    this.f1907g = null;
                    this.f1903c.setCallback(this.f1905e);
                }
                mo9073e();
                return;
            }
            throw new IllegalStateException("This Activity already has an action bar supplied by the window decor. Do not request Window.FEATURE_SUPPORT_ACTION_BAR and set windowActionBar to false in your theme to use a Toolbar instead.");
        }
    }

    @Override // p000a.p006b.p049h.p050a.AppCompatDelegate
    /* renamed from: c */
    public void mo9077c(Bundle bundle) {
        int i = this.f1892J;
        if (i != -100) {
            bundle.putInt("appcompat:local_night_mode", i);
        }
    }

    @Override // p000a.p006b.p049h.p050a.AppCompatDelegate
    /* renamed from: d */
    public void mo9076d() {
        LayoutInflater from = LayoutInflater.from(this.f1902b);
        if (from.getFactory() == null) {
            LayoutInflaterCompat.m9511b(from, this);
        } else if (from.getFactory2() instanceof AppCompatDelegateImpl) {
        } else {
            Log.i("AppCompatDelegate", "The Activity's LayoutInflater already has a Factory installed so we can not install AppCompat's");
        }
    }

    /* renamed from: f */
    public final void m9069f(int i) {
        this.f1896N = (1 << i) | this.f1896N;
        if (this.f1895M) {
            return;
        }
        ViewCompat.m9445a(this.f1903c.getDecorView(), this.f1897O);
        this.f1895M = true;
    }

    /* renamed from: c */
    public boolean m9079c(int i, KeyEvent keyEvent) {
        ActionBar mo9081c = mo9081c();
        if (mo9081c == null || !mo9081c.mo9000a(i, keyEvent)) {
            C0341m c0341m = this.f1889G;
            if (c0341m != null && m9106a(c0341m, keyEvent.getKeyCode(), keyEvent, 1)) {
                C0341m c0341m2 = this.f1889G;
                if (c0341m2 != null) {
                    c0341m2.f1959n = true;
                }
                return true;
            }
            if (this.f1889G == null) {
                C0341m m9108a = m9108a(0, true);
                m9086b(m9108a, keyEvent);
                boolean m9106a = m9106a(m9108a, keyEvent.getKeyCode(), keyEvent, 1);
                m9108a.f1958m = false;
                if (m9106a) {
                    return true;
                }
            }
            return false;
        }
        return true;
    }

    @Override // p000a.p006b.p049h.p050a.AppCompatDelegate
    /* renamed from: b */
    public boolean mo9089b(int i) {
        int m9062j = m9062j(i);
        if (this.f1886D && m9062j == 108) {
            return false;
        }
        if (this.f1925z && m9062j == 1) {
            this.f1925z = false;
        }
        if (m9062j == 1) {
            m9113A();
            this.f1886D = true;
            return true;
        } else if (m9062j == 2) {
            m9113A();
            this.f1923x = true;
            return true;
        } else if (m9062j == 5) {
            m9113A();
            this.f1924y = true;
            return true;
        } else if (m9062j == 10) {
            m9113A();
            this.f1884B = true;
            return true;
        } else if (m9062j == 108) {
            m9113A();
            this.f1925z = true;
            return true;
        } else if (m9062j != 109) {
            return this.f1903c.requestFeature(m9062j);
        } else {
            m9113A();
            this.f1883A = true;
            return true;
        }
    }

    /* renamed from: d */
    public void m9075d(int i) {
        m9104a(m9108a(i, true), true);
    }

    @Override // p000a.p006b.p049h.p050a.AppCompatDelegate
    /* renamed from: a */
    public <T extends View> T mo9111a(int i) {
        m9054p();
        return (T) this.f1903c.findViewById(i);
    }

    /* renamed from: c */
    public final boolean m9078c(C0341m c0341m) {
        Context context = this.f1902b;
        int i = c0341m.f1946a;
        if ((i == 0 || i == 108) && this.f1910j != null) {
            TypedValue typedValue = new TypedValue();
            Resources.Theme theme = context.getTheme();
            theme.resolveAttribute(C0354a.actionBarTheme, typedValue, true);
            Resources.Theme theme2 = null;
            if (typedValue.resourceId != 0) {
                theme2 = context.getResources().newTheme();
                theme2.setTo(theme);
                theme2.applyStyle(typedValue.resourceId, true);
                theme2.resolveAttribute(C0354a.actionBarWidgetTheme, typedValue, true);
            } else {
                theme.resolveAttribute(C0354a.actionBarWidgetTheme, typedValue, true);
            }
            if (typedValue.resourceId != 0) {
                if (theme2 == null) {
                    theme2 = context.getResources().newTheme();
                    theme2.setTo(theme);
                }
                theme2.applyStyle(typedValue.resourceId, true);
            }
            if (theme2 != null) {
                ContextThemeWrapper contextThemeWrapper = new ContextThemeWrapper(context, 0);
                contextThemeWrapper.getTheme().setTo(theme2);
                context = contextThemeWrapper;
            }
        }
        MenuBuilder menuBuilder = new MenuBuilder(context);
        menuBuilder.mo8579a(this);
        c0341m.m9035a(menuBuilder);
        return true;
    }

    @Override // p000a.p006b.p049h.p050a.AppCompatDelegate
    /* renamed from: a */
    public void mo9101a(Configuration configuration) {
        ActionBar mo9081c;
        if (this.f1925z && this.f1919t && (mo9081c = mo9081c()) != null) {
            mo9081c.mo8998a(configuration);
        }
        AppCompatDrawableManager.m8318a().m8290f(this.f1902b);
        mo9112a();
    }

    /* renamed from: e */
    public void m9072e(int i) {
        C0341m m9108a;
        C0341m m9108a2 = m9108a(i, true);
        if (m9108a2.f1955j != null) {
            Bundle bundle = new Bundle();
            m9108a2.f1955j.m8663e(bundle);
            if (bundle.size() > 0) {
                m9108a2.f1964s = bundle;
            }
            m9108a2.f1955j.m8650s();
            m9108a2.f1955j.clear();
        }
        m9108a2.f1963r = true;
        m9108a2.f1962q = true;
        if ((i != 108 && i != 0) || this.f1910j == null || (m9108a = m9108a(0, false)) == null) {
            return;
        }
        m9108a.f1958m = false;
        m9086b(m9108a, (KeyEvent) null);
    }

    @Override // p000a.p006b.p049h.p050a.AppCompatDelegate
    /* renamed from: a */
    public void mo9096a(View view) {
        m9054p();
        ViewGroup viewGroup = (ViewGroup) this.f1920u.findViewById(16908290);
        viewGroup.removeAllViews();
        viewGroup.addView(view);
        this.f1904d.onContentChanged();
    }

    /* renamed from: k */
    public final boolean m9060k(int i) {
        Resources resources = this.f1902b.getResources();
        Configuration configuration = resources.getConfiguration();
        int i2 = configuration.uiMode & 48;
        int i3 = i == 2 ? 32 : 16;
        if (i2 != i3) {
            if (m9044z()) {
                ((Activity) this.f1902b).recreate();
                return true;
            }
            Configuration configuration2 = new Configuration(configuration);
            DisplayMetrics displayMetrics = resources.getDisplayMetrics();
            configuration2.uiMode = i3 | (configuration2.uiMode & (-49));
            resources.updateConfiguration(configuration2, displayMetrics);
            if (Build.VERSION.SDK_INT < 26) {
                ResourcesFlusher.m9024a(resources);
                return true;
            }
            return true;
        }
        return false;
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x0025  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0029  */
    /* renamed from: b */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public p000a.p006b.p049h.p061j.ActionMode m9085b(p000a.p006b.p049h.p061j.ActionMode.InterfaceC0414a r8) {
        /*
            Method dump skipped, instructions count: 371
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: p000a.p006b.p049h.p050a.AppCompatDelegateImpl.m9085b(a.b.h.j.b$a):a.b.h.j.b");
    }

    @Override // p000a.p006b.p049h.p050a.AppCompatDelegate
    /* renamed from: a */
    public void mo9095a(View view, ViewGroup.LayoutParams layoutParams) {
        m9054p();
        ((ViewGroup) this.f1920u.findViewById(16908290)).addView(view, layoutParams);
        this.f1904d.onContentChanged();
    }

    @Override // p000a.p006b.p049h.p050a.AppCompatDelegate
    /* renamed from: a */
    public final void mo9091a(CharSequence charSequence) {
        this.f1909i = charSequence;
        DecorContentParent decorContentParent = this.f1910j;
        if (decorContentParent != null) {
            decorContentParent.setWindowTitle(charSequence);
        } else if (m9046x() != null) {
            m9046x().mo8996a(charSequence);
        } else {
            TextView textView = this.f1921v;
            if (textView != null) {
                textView.setText(charSequence);
            }
        }
    }

    @Override // p000a.p006b.p049h.p061j.p062j.MenuBuilder.InterfaceC0425a
    /* renamed from: a */
    public boolean mo7077a(MenuBuilder menuBuilder, MenuItem menuItem) {
        C0341m m9097a;
        Window.Callback m9050t = m9050t();
        if (m9050t == null || this.f1891I || (m9097a = m9097a((Menu) menuBuilder.mo8574m())) == null) {
            return false;
        }
        return m9050t.onMenuItemSelected(m9097a.f1946a, menuItem);
    }

    @Override // p000a.p006b.p049h.p061j.p062j.MenuBuilder.InterfaceC0425a
    /* renamed from: a */
    public void mo7078a(MenuBuilder menuBuilder) {
        m9102a(menuBuilder, true);
    }

    /* renamed from: a */
    public p000a.p006b.p049h.p061j.ActionMode m9103a(ActionMode.InterfaceC0414a interfaceC0414a) {
        AppCompatCallback appCompatCallback;
        if (interfaceC0414a != null) {
            p000a.p006b.p049h.p061j.ActionMode actionMode = this.f1913n;
            if (actionMode != null) {
                actionMode.mo8767a();
            }
            C0335i c0335i = new C0335i(interfaceC0414a);
            ActionBar mo9081c = mo9081c();
            if (mo9081c != null) {
                this.f1913n = mo9081c.mo8999a(c0335i);
                p000a.p006b.p049h.p061j.ActionMode actionMode2 = this.f1913n;
                if (actionMode2 != null && (appCompatCallback = this.f1906f) != null) {
                    appCompatCallback.mo9026b(actionMode2);
                }
            }
            if (this.f1913n == null) {
                this.f1913n = m9085b(c0335i);
            }
            return this.f1913n;
        }
        throw new IllegalArgumentException("ActionMode callback can not be null.");
    }

    /* renamed from: a */
    public boolean m9098a(KeyEvent keyEvent) {
        View decorView;
        Window.Callback callback = this.f1904d;
        if (((callback instanceof KeyEventDispatcher.InterfaceC0281a) || (callback instanceof AppCompatDialog)) && (decorView = this.f1903c.getDecorView()) != null && KeyEventDispatcher.m9564a(decorView, keyEvent)) {
            return true;
        }
        if (keyEvent.getKeyCode() == 82 && this.f1904d.dispatchKeyEvent(keyEvent)) {
            return true;
        }
        int keyCode = keyEvent.getKeyCode();
        return keyEvent.getAction() == 0 ? m9109a(keyCode, keyEvent) : m9074d(keyCode, keyEvent);
    }

    /* renamed from: l */
    public int m9058l(int i) {
        boolean z;
        boolean z2;
        ActionBarContextView actionBarContextView = this.f1914o;
        if (actionBarContextView == null || !(actionBarContextView.getLayoutParams() instanceof ViewGroup.MarginLayoutParams)) {
            z = false;
        } else {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.f1914o.getLayoutParams();
            if (this.f1914o.isShown()) {
                if (this.f1899Q == null) {
                    this.f1899Q = new Rect();
                    this.f1900R = new Rect();
                }
                Rect rect = this.f1899Q;
                Rect rect2 = this.f1900R;
                rect.set(0, i, 0, 0);
                C0504t1.m8046a(this.f1920u, rect, rect2);
                if (marginLayoutParams.topMargin != (rect2.top == 0 ? i : 0)) {
                    marginLayoutParams.topMargin = i;
                    View view = this.f1922w;
                    if (view == null) {
                        this.f1922w = new View(this.f1902b);
                        this.f1922w.setBackgroundColor(this.f1902b.getResources().getColor(C0356c.abc_input_method_navigation_guard));
                        this.f1920u.addView(this.f1922w, -1, new ViewGroup.LayoutParams(-1, i));
                    } else {
                        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
                        if (layoutParams.height != i) {
                            layoutParams.height = i;
                            this.f1922w.setLayoutParams(layoutParams);
                        }
                    }
                    z2 = true;
                } else {
                    z2 = false;
                }
                z = this.f1922w != null;
                if (!this.f1884B && z) {
                    i = 0;
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
                this.f1914o.setLayoutParams(marginLayoutParams);
            }
        }
        View view2 = this.f1922w;
        if (view2 != null) {
            view2.setVisibility(z ? 0 : 8);
        }
        return i;
    }

    /* renamed from: a */
    public boolean m9109a(int i, KeyEvent keyEvent) {
        if (i == 4) {
            this.f1890H = (keyEvent.getFlags() & Logger.DEFAULT_FULL_MESSAGE_LENGTH) != 0;
        } else if (i == 82) {
            m9088b(0, keyEvent);
            return true;
        }
        return false;
    }

    /* renamed from: a */
    public View m9094a(View view, String str, Context context, AttributeSet attributeSet) {
        boolean z;
        boolean z2 = false;
        if (this.f1901S == null) {
            String string = this.f1902b.obtainStyledAttributes(C0363j.AppCompatTheme).getString(C0363j.AppCompatTheme_viewInflaterClass);
            if (string != null && !AppCompatViewInflater.class.getName().equals(string)) {
                try {
                    this.f1901S = (AppCompatViewInflater) Class.forName(string).getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
                } catch (Throwable th) {
                    Log.i("AppCompatDelegate", "Failed to instantiate custom view inflater " + string + ". Falling back to default.", th);
                    this.f1901S = new AppCompatViewInflater();
                }
            } else {
                this.f1901S = new AppCompatViewInflater();
            }
        }
        if (f1880T) {
            if (attributeSet instanceof XmlPullParser) {
                if (((XmlPullParser) attributeSet).getDepth() > 1) {
                    z2 = true;
                }
            } else {
                z2 = m9092a((ViewParent) view);
            }
            z = z2;
        } else {
            z = false;
        }
        return this.f1901S.createView(view, str, context, attributeSet, z, f1880T, true, VectorEnabledTintResources.m8129b());
    }

    /* renamed from: b */
    public final boolean m9087b(C0341m c0341m) {
        c0341m.m9033a(m9053q());
        c0341m.f1952g = new C0340l(c0341m.f1957l);
        c0341m.f1948c = 81;
        return true;
    }

    /* renamed from: a */
    public final boolean m9092a(ViewParent viewParent) {
        if (viewParent == null) {
            return false;
        }
        View decorView = this.f1903c.getDecorView();
        while (viewParent != null) {
            if (viewParent == decorView || !(viewParent instanceof View) || ViewCompat.m9410w((View) viewParent)) {
                return false;
            }
            viewParent = viewParent.getParent();
        }
        return true;
    }

    /* renamed from: b */
    public final boolean m9086b(C0341m c0341m, KeyEvent keyEvent) {
        DecorContentParent decorContentParent;
        DecorContentParent decorContentParent2;
        DecorContentParent decorContentParent3;
        if (this.f1891I) {
            return false;
        }
        if (c0341m.f1958m) {
            return true;
        }
        C0341m c0341m2 = this.f1889G;
        if (c0341m2 != null && c0341m2 != c0341m) {
            m9104a(c0341m2, false);
        }
        Window.Callback m9050t = m9050t();
        if (m9050t != null) {
            c0341m.f1954i = m9050t.onCreatePanelView(c0341m.f1946a);
        }
        int i = c0341m.f1946a;
        boolean z = i == 0 || i == 108;
        if (z && (decorContentParent3 = this.f1910j) != null) {
            decorContentParent3.mo7115b();
        }
        if (c0341m.f1954i == null && (!z || !(m9046x() instanceof ToolbarActionBar))) {
            if (c0341m.f1955j == null || c0341m.f1963r) {
                if (c0341m.f1955j == null && (!m9078c(c0341m) || c0341m.f1955j == null)) {
                    return false;
                }
                if (z && this.f1910j != null) {
                    if (this.f1911k == null) {
                        this.f1911k = new C0334h();
                    }
                    this.f1910j.mo7118a(c0341m.f1955j, this.f1911k);
                }
                c0341m.f1955j.m8650s();
                if (!m9050t.onCreatePanelMenu(c0341m.f1946a, c0341m.f1955j)) {
                    c0341m.m9035a((MenuBuilder) null);
                    if (z && (decorContentParent = this.f1910j) != null) {
                        decorContentParent.mo7118a(null, this.f1911k);
                    }
                    return false;
                }
                c0341m.f1963r = false;
            }
            c0341m.f1955j.m8650s();
            Bundle bundle = c0341m.f1964s;
            if (bundle != null) {
                c0341m.f1955j.m8671c(bundle);
                c0341m.f1964s = null;
            }
            if (!m9050t.onPreparePanel(0, c0341m.f1954i, c0341m.f1955j)) {
                if (z && (decorContentParent2 = this.f1910j) != null) {
                    decorContentParent2.mo7118a(null, this.f1911k);
                }
                c0341m.f1955j.m8651r();
                return false;
            }
            c0341m.f1961p = KeyCharacterMap.load(keyEvent != null ? keyEvent.getDeviceId() : -1).getKeyboardType() != 1;
            c0341m.f1955j.setQwertyMode(c0341m.f1961p);
            c0341m.f1955j.m8651r();
        }
        c0341m.f1958m = true;
        c0341m.f1959n = false;
        this.f1889G = c0341m;
        return true;
    }

    /* renamed from: a */
    public final void m9105a(C0341m c0341m, KeyEvent keyEvent) {
        int i;
        ViewGroup.LayoutParams layoutParams;
        if (c0341m.f1960o || this.f1891I) {
            return;
        }
        if (c0341m.f1946a == 0) {
            if ((this.f1902b.getResources().getConfiguration().screenLayout & 15) == 4) {
                return;
            }
        }
        Window.Callback m9050t = m9050t();
        if (m9050t != null && !m9050t.onMenuOpened(c0341m.f1946a, c0341m.f1955j)) {
            m9104a(c0341m, true);
            return;
        }
        WindowManager windowManager = (WindowManager) this.f1902b.getSystemService("window");
        if (windowManager != null && m9086b(c0341m, keyEvent)) {
            if (c0341m.f1952g != null && !c0341m.f1962q) {
                View view = c0341m.f1954i;
                if (view != null && (layoutParams = view.getLayoutParams()) != null && layoutParams.width == -1) {
                    i = -1;
                    c0341m.f1959n = false;
                    WindowManager.LayoutParams layoutParams2 = new WindowManager.LayoutParams(i, -2, c0341m.f1949d, c0341m.f1950e, 1002, 8519680, -3);
                    layoutParams2.gravity = c0341m.f1948c;
                    layoutParams2.windowAnimations = c0341m.f1951f;
                    windowManager.addView(c0341m.f1952g, layoutParams2);
                    c0341m.f1960o = true;
                }
            } else {
                ViewGroup viewGroup = c0341m.f1952g;
                if (viewGroup == null) {
                    if (!m9087b(c0341m) || c0341m.f1952g == null) {
                        return;
                    }
                } else if (c0341m.f1962q && viewGroup.getChildCount() > 0) {
                    c0341m.f1952g.removeAllViews();
                }
                if (!m9107a(c0341m) || !c0341m.m9036a()) {
                    return;
                }
                ViewGroup.LayoutParams layoutParams3 = c0341m.f1953h.getLayoutParams();
                if (layoutParams3 == null) {
                    layoutParams3 = new ViewGroup.LayoutParams(-2, -2);
                }
                c0341m.f1952g.setBackgroundResource(c0341m.f1947b);
                ViewParent parent = c0341m.f1953h.getParent();
                if (parent != null && (parent instanceof ViewGroup)) {
                    ((ViewGroup) parent).removeView(c0341m.f1953h);
                }
                c0341m.f1952g.addView(c0341m.f1953h, layoutParams3);
                if (!c0341m.f1953h.hasFocus()) {
                    c0341m.f1953h.requestFocus();
                }
            }
            i = -2;
            c0341m.f1959n = false;
            WindowManager.LayoutParams layoutParams22 = new WindowManager.LayoutParams(i, -2, c0341m.f1949d, c0341m.f1950e, 1002, 8519680, -3);
            layoutParams22.gravity = c0341m.f1948c;
            layoutParams22.windowAnimations = c0341m.f1951f;
            windowManager.addView(c0341m.f1952g, layoutParams22);
            c0341m.f1960o = true;
        }
    }

    /* renamed from: a */
    public final void m9102a(MenuBuilder menuBuilder, boolean z) {
        DecorContentParent decorContentParent = this.f1910j;
        if (decorContentParent != null && decorContentParent.mo7111f() && (!ViewConfiguration.get(this.f1902b).hasPermanentMenuKey() || this.f1910j.mo7114c())) {
            Window.Callback m9050t = m9050t();
            if (this.f1910j.mo7122a() && z) {
                this.f1910j.mo7113d();
                if (this.f1891I) {
                    return;
                }
                m9050t.onPanelClosed(108, m9108a(0, true).f1955j);
                return;
            } else if (m9050t == null || this.f1891I) {
                return;
            } else {
                if (this.f1895M && (this.f1896N & 1) != 0) {
                    this.f1903c.getDecorView().removeCallbacks(this.f1897O);
                    this.f1897O.run();
                }
                C0341m m9108a = m9108a(0, true);
                MenuBuilder menuBuilder2 = m9108a.f1955j;
                if (menuBuilder2 == null || m9108a.f1963r || !m9050t.onPreparePanel(0, m9108a.f1954i, menuBuilder2)) {
                    return;
                }
                m9050t.onMenuOpened(108, m9108a.f1955j);
                this.f1910j.mo7112e();
                return;
            }
        }
        C0341m m9108a2 = m9108a(0, true);
        m9108a2.f1962q = true;
        m9104a(m9108a2, false);
        m9105a(m9108a2, (KeyEvent) null);
    }

    /* renamed from: b */
    public void m9084b(MenuBuilder menuBuilder) {
        if (this.f1887E) {
            return;
        }
        this.f1887E = true;
        this.f1910j.mo7110g();
        Window.Callback m9050t = m9050t();
        if (m9050t != null && !this.f1891I) {
            m9050t.onPanelClosed(108, menuBuilder);
        }
        this.f1887E = false;
    }

    /* renamed from: b */
    public final boolean m9088b(int i, KeyEvent keyEvent) {
        if (keyEvent.getRepeatCount() == 0) {
            C0341m m9108a = m9108a(i, true);
            if (m9108a.f1960o) {
                return false;
            }
            return m9086b(m9108a, keyEvent);
        }
        return false;
    }

    /* renamed from: a */
    public final boolean m9107a(C0341m c0341m) {
        View view = c0341m.f1954i;
        if (view != null) {
            c0341m.f1953h = view;
            return true;
        } else if (c0341m.f1955j == null) {
            return false;
        } else {
            if (this.f1912m == null) {
                this.f1912m = new C0342n();
            }
            c0341m.f1953h = (View) c0341m.m9034a(this.f1912m);
            return c0341m.f1953h != null;
        }
    }

    /* renamed from: a */
    public void m9104a(C0341m c0341m, boolean z) {
        ViewGroup viewGroup;
        DecorContentParent decorContentParent;
        if (z && c0341m.f1946a == 0 && (decorContentParent = this.f1910j) != null && decorContentParent.mo7122a()) {
            m9084b(c0341m.f1955j);
            return;
        }
        WindowManager windowManager = (WindowManager) this.f1902b.getSystemService("window");
        if (windowManager != null && c0341m.f1960o && (viewGroup = c0341m.f1952g) != null) {
            windowManager.removeView(viewGroup);
            if (z) {
                m9110a(c0341m.f1946a, c0341m, null);
            }
        }
        c0341m.f1958m = false;
        c0341m.f1959n = false;
        c0341m.f1960o = false;
        c0341m.f1953h = null;
        c0341m.f1962q = true;
        if (this.f1889G == c0341m) {
            this.f1889G = null;
        }
    }

    /* renamed from: a */
    public void m9110a(int i, C0341m c0341m, Menu menu) {
        if (menu == null) {
            if (c0341m == null && i >= 0) {
                C0341m[] c0341mArr = this.f1888F;
                if (i < c0341mArr.length) {
                    c0341m = c0341mArr[i];
                }
            }
            if (c0341m != null) {
                menu = c0341m.f1955j;
            }
        }
        if ((c0341m == null || c0341m.f1960o) && !this.f1891I) {
            this.f1904d.onPanelClosed(i, menu);
        }
    }

    /* renamed from: a */
    public C0341m m9097a(Menu menu) {
        C0341m[] c0341mArr = this.f1888F;
        int length = c0341mArr != null ? c0341mArr.length : 0;
        for (int i = 0; i < length; i++) {
            C0341m c0341m = c0341mArr[i];
            if (c0341m != null && c0341m.f1955j == menu) {
                return c0341m;
            }
        }
        return null;
    }

    /* renamed from: a */
    public C0341m m9108a(int i, boolean z) {
        C0341m[] c0341mArr = this.f1888F;
        if (c0341mArr == null || c0341mArr.length <= i) {
            C0341m[] c0341mArr2 = new C0341m[i + 1];
            if (c0341mArr != null) {
                System.arraycopy(c0341mArr, 0, c0341mArr2, 0, c0341mArr.length);
            }
            this.f1888F = c0341mArr2;
            c0341mArr = c0341mArr2;
        }
        C0341m c0341m = c0341mArr[i];
        if (c0341m == null) {
            C0341m c0341m2 = new C0341m(i);
            c0341mArr[i] = c0341m2;
            return c0341m2;
        }
        return c0341m;
    }

    /* renamed from: a */
    public final boolean m9106a(C0341m c0341m, int i, KeyEvent keyEvent, int i2) {
        MenuBuilder menuBuilder;
        boolean z = false;
        if (keyEvent.isSystem()) {
            return false;
        }
        if ((c0341m.f1958m || m9086b(c0341m, keyEvent)) && (menuBuilder = c0341m.f1955j) != null) {
            z = menuBuilder.performShortcut(i, keyEvent, i2);
        }
        if (z && (i2 & 1) == 0 && this.f1910j == null) {
            m9104a(c0341m, true);
        }
        return z;
    }

    @Override // p000a.p006b.p049h.p050a.AppCompatDelegate
    /* renamed from: a */
    public boolean mo9112a() {
        int m9052r = m9052r();
        int m9067g = m9067g(m9052r);
        boolean m9060k = m9067g != -1 ? m9060k(m9067g) : false;
        if (m9052r == 0) {
            m9055o();
            this.f1894L.m9038d();
        }
        this.f1893K = true;
        return m9060k;
    }
}
