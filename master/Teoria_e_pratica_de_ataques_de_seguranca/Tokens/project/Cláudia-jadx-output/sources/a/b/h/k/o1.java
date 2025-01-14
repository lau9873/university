package a.b.h.k;

import android.text.TextUtils;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.accessibility.AccessibilityManager;
/* compiled from: TooltipCompatHandler.java */
/* loaded from: classes.dex */
public class o1 implements View.OnLongClickListener, View.OnHoverListener, View.OnAttachStateChangeListener {
    public static o1 j;
    public static o1 k;

    /* renamed from: a  reason: collision with root package name */
    public final View f1869a;

    /* renamed from: b  reason: collision with root package name */
    public final CharSequence f1870b;

    /* renamed from: c  reason: collision with root package name */
    public final int f1871c;

    /* renamed from: d  reason: collision with root package name */
    public final Runnable f1872d = new a();

    /* renamed from: e  reason: collision with root package name */
    public final Runnable f1873e = new b();

    /* renamed from: f  reason: collision with root package name */
    public int f1874f;

    /* renamed from: g  reason: collision with root package name */
    public int f1875g;

    /* renamed from: h  reason: collision with root package name */
    public p1 f1876h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f1877i;

    /* compiled from: TooltipCompatHandler.java */
    /* loaded from: classes.dex */
    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            o1.this.a(false);
        }
    }

    /* compiled from: TooltipCompatHandler.java */
    /* loaded from: classes.dex */
    public class b implements Runnable {
        public b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            o1.this.c();
        }
    }

    public o1(View view, CharSequence charSequence) {
        this.f1869a = view;
        this.f1870b = charSequence;
        this.f1871c = a.b.g.k.v.a(ViewConfiguration.get(this.f1869a.getContext()));
        b();
        this.f1869a.setOnLongClickListener(this);
        this.f1869a.setOnHoverListener(this);
    }

    public static void a(View view, CharSequence charSequence) {
        o1 o1Var = j;
        if (o1Var != null && o1Var.f1869a == view) {
            a((o1) null);
        }
        if (TextUtils.isEmpty(charSequence)) {
            o1 o1Var2 = k;
            if (o1Var2 != null && o1Var2.f1869a == view) {
                o1Var2.c();
            }
            view.setOnLongClickListener(null);
            view.setLongClickable(false);
            view.setOnHoverListener(null);
            return;
        }
        new o1(view, charSequence);
    }

    public final void b() {
        this.f1874f = Integer.MAX_VALUE;
        this.f1875g = Integer.MAX_VALUE;
    }

    public void c() {
        if (k == this) {
            k = null;
            p1 p1Var = this.f1876h;
            if (p1Var != null) {
                p1Var.a();
                this.f1876h = null;
                b();
                this.f1869a.removeOnAttachStateChangeListener(this);
            } else {
                Log.e("TooltipCompatHandler", "sActiveHandler.mPopup == null");
            }
        }
        if (j == this) {
            a((o1) null);
        }
        this.f1869a.removeCallbacks(this.f1873e);
    }

    public final void d() {
        this.f1869a.postDelayed(this.f1872d, ViewConfiguration.getLongPressTimeout());
    }

    @Override // android.view.View.OnHoverListener
    public boolean onHover(View view, MotionEvent motionEvent) {
        if (this.f1876h == null || !this.f1877i) {
            AccessibilityManager accessibilityManager = (AccessibilityManager) this.f1869a.getContext().getSystemService("accessibility");
            if (accessibilityManager.isEnabled() && accessibilityManager.isTouchExplorationEnabled()) {
                return false;
            }
            int action = motionEvent.getAction();
            if (action != 7) {
                if (action == 10) {
                    b();
                    c();
                }
            } else if (this.f1869a.isEnabled() && this.f1876h == null && a(motionEvent)) {
                a(this);
            }
            return false;
        }
        return false;
    }

    @Override // android.view.View.OnLongClickListener
    public boolean onLongClick(View view) {
        this.f1874f = view.getWidth() / 2;
        this.f1875g = view.getHeight() / 2;
        a(true);
        return true;
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public void onViewAttachedToWindow(View view) {
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public void onViewDetachedFromWindow(View view) {
        c();
    }

    public void a(boolean z) {
        long j2;
        int longPressTimeout;
        long j3;
        if (a.b.g.k.u.w(this.f1869a)) {
            a((o1) null);
            o1 o1Var = k;
            if (o1Var != null) {
                o1Var.c();
            }
            k = this;
            this.f1877i = z;
            this.f1876h = new p1(this.f1869a.getContext());
            this.f1876h.a(this.f1869a, this.f1874f, this.f1875g, this.f1877i, this.f1870b);
            this.f1869a.addOnAttachStateChangeListener(this);
            if (this.f1877i) {
                j3 = 2500;
            } else {
                if ((a.b.g.k.u.q(this.f1869a) & 1) == 1) {
                    j2 = 3000;
                    longPressTimeout = ViewConfiguration.getLongPressTimeout();
                } else {
                    j2 = 15000;
                    longPressTimeout = ViewConfiguration.getLongPressTimeout();
                }
                j3 = j2 - longPressTimeout;
            }
            this.f1869a.removeCallbacks(this.f1873e);
            this.f1869a.postDelayed(this.f1873e, j3);
        }
    }

    public static void a(o1 o1Var) {
        o1 o1Var2 = j;
        if (o1Var2 != null) {
            o1Var2.a();
        }
        j = o1Var;
        o1 o1Var3 = j;
        if (o1Var3 != null) {
            o1Var3.d();
        }
    }

    public final void a() {
        this.f1869a.removeCallbacks(this.f1872d);
    }

    public final boolean a(MotionEvent motionEvent) {
        int x = (int) motionEvent.getX();
        int y = (int) motionEvent.getY();
        if (Math.abs(x - this.f1874f) > this.f1871c || Math.abs(y - this.f1875g) > this.f1871c) {
            this.f1874f = x;
            this.f1875g = y;
            return true;
        }
        return false;
    }
}
