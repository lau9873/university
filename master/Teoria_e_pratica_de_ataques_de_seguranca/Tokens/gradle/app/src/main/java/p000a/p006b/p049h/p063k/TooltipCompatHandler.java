package p000a.p006b.p049h.p063k;

import android.text.TextUtils;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.accessibility.AccessibilityManager;
import p000a.p006b.p030g.p045k.ViewCompat;
import p000a.p006b.p030g.p045k.ViewConfigurationCompat;

/* renamed from: a.b.h.k.o1 */
/* loaded from: classes.dex */
public class TooltipCompatHandler implements View.OnLongClickListener, View.OnHoverListener, View.OnAttachStateChangeListener {

    /* renamed from: j */
    public static TooltipCompatHandler f2831j;

    /* renamed from: k */
    public static TooltipCompatHandler f2832k;

    /* renamed from: a */
    public final View f2833a;

    /* renamed from: b */
    public final CharSequence f2834b;

    /* renamed from: c */
    public final int f2835c;

    /* renamed from: d */
    public final Runnable f2836d = new RunnableC0487a();

    /* renamed from: e */
    public final Runnable f2837e = new RunnableC0488b();

    /* renamed from: f */
    public int f2838f;

    /* renamed from: g */
    public int f2839g;

    /* renamed from: h */
    public TooltipPopup f2840h;

    /* renamed from: i */
    public boolean f2841i;

    /* compiled from: TooltipCompatHandler.java */
    /* renamed from: a.b.h.k.o1$a */
    /* loaded from: classes.dex */
    public class RunnableC0487a implements Runnable {
        public RunnableC0487a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            TooltipCompatHandler.this.m8158a(false);
        }
    }

    /* compiled from: TooltipCompatHandler.java */
    /* renamed from: a.b.h.k.o1$b */
    /* loaded from: classes.dex */
    public class RunnableC0488b implements Runnable {
        public RunnableC0488b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            TooltipCompatHandler.this.m8156c();
        }
    }

    public TooltipCompatHandler(View view, CharSequence charSequence) {
        this.f2833a = view;
        this.f2834b = charSequence;
        this.f2835c = ViewConfigurationCompat.m9398a(ViewConfiguration.get(this.f2833a.getContext()));
        m8157b();
        this.f2833a.setOnLongClickListener(this);
        this.f2833a.setOnHoverListener(this);
    }

    /* renamed from: a */
    public static void m8159a(View view, CharSequence charSequence) {
        TooltipCompatHandler tooltipCompatHandler = f2831j;
        if (tooltipCompatHandler != null && tooltipCompatHandler.f2833a == view) {
            m8161a((TooltipCompatHandler) null);
        }
        if (TextUtils.isEmpty(charSequence)) {
            TooltipCompatHandler tooltipCompatHandler2 = f2832k;
            if (tooltipCompatHandler2 != null && tooltipCompatHandler2.f2833a == view) {
                tooltipCompatHandler2.m8156c();
            }
            view.setOnLongClickListener(null);
            view.setLongClickable(false);
            view.setOnHoverListener(null);
            return;
        }
        new TooltipCompatHandler(view, charSequence);
    }

    /* renamed from: b */
    public final void m8157b() {
        this.f2838f = Integer.MAX_VALUE;
        this.f2839g = Integer.MAX_VALUE;
    }

    /* renamed from: c */
    public void m8156c() {
        if (f2832k == this) {
            f2832k = null;
            TooltipPopup tooltipPopup = this.f2840h;
            if (tooltipPopup != null) {
                tooltipPopup.m8138a();
                this.f2840h = null;
                m8157b();
                this.f2833a.removeOnAttachStateChangeListener(this);
            } else {
                Log.e("TooltipCompatHandler", "sActiveHandler.mPopup == null");
            }
        }
        if (f2831j == this) {
            m8161a((TooltipCompatHandler) null);
        }
        this.f2833a.removeCallbacks(this.f2837e);
    }

    /* renamed from: d */
    public final void m8155d() {
        this.f2833a.postDelayed(this.f2836d, ViewConfiguration.getLongPressTimeout());
    }

    @Override // android.view.View.OnHoverListener
    public boolean onHover(View view, MotionEvent motionEvent) {
        if (this.f2840h == null || !this.f2841i) {
            AccessibilityManager accessibilityManager = (AccessibilityManager) this.f2833a.getContext().getSystemService("accessibility");
            if (accessibilityManager.isEnabled() && accessibilityManager.isTouchExplorationEnabled()) {
                return false;
            }
            int action = motionEvent.getAction();
            if (action != 7) {
                if (action == 10) {
                    m8157b();
                    m8156c();
                }
            } else if (this.f2833a.isEnabled() && this.f2840h == null && m8160a(motionEvent)) {
                m8161a(this);
            }
            return false;
        }
        return false;
    }

    @Override // android.view.View.OnLongClickListener
    public boolean onLongClick(View view) {
        this.f2838f = view.getWidth() / 2;
        this.f2839g = view.getHeight() / 2;
        m8158a(true);
        return true;
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public void onViewAttachedToWindow(View view) {
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public void onViewDetachedFromWindow(View view) {
        m8156c();
    }

    /* renamed from: a */
    public void m8158a(boolean z) {
        long j;
        int longPressTimeout;
        long j2;
        if (ViewCompat.m9410w(this.f2833a)) {
            m8161a((TooltipCompatHandler) null);
            TooltipCompatHandler tooltipCompatHandler = f2832k;
            if (tooltipCompatHandler != null) {
                tooltipCompatHandler.m8156c();
            }
            f2832k = this;
            this.f2841i = z;
            this.f2840h = new TooltipPopup(this.f2833a.getContext());
            this.f2840h.m8135a(this.f2833a, this.f2838f, this.f2839g, this.f2841i, this.f2834b);
            this.f2833a.addOnAttachStateChangeListener(this);
            if (this.f2841i) {
                j2 = 2500;
            } else {
                if ((ViewCompat.m9416q(this.f2833a) & 1) == 1) {
                    j = 3000;
                    longPressTimeout = ViewConfiguration.getLongPressTimeout();
                } else {
                    j = 15000;
                    longPressTimeout = ViewConfiguration.getLongPressTimeout();
                }
                j2 = j - longPressTimeout;
            }
            this.f2833a.removeCallbacks(this.f2837e);
            this.f2833a.postDelayed(this.f2837e, j2);
        }
    }

    /* renamed from: a */
    public static void m8161a(TooltipCompatHandler tooltipCompatHandler) {
        TooltipCompatHandler tooltipCompatHandler2 = f2831j;
        if (tooltipCompatHandler2 != null) {
            tooltipCompatHandler2.m8162a();
        }
        f2831j = tooltipCompatHandler;
        TooltipCompatHandler tooltipCompatHandler3 = f2831j;
        if (tooltipCompatHandler3 != null) {
            tooltipCompatHandler3.m8155d();
        }
    }

    /* renamed from: a */
    public final void m8162a() {
        this.f2833a.removeCallbacks(this.f2836d);
    }

    /* renamed from: a */
    public final boolean m8160a(MotionEvent motionEvent) {
        int x = (int) motionEvent.getX();
        int y = (int) motionEvent.getY();
        if (Math.abs(x - this.f2838f) > this.f2835c || Math.abs(y - this.f2839g) > this.f2835c) {
            this.f2838f = x;
            this.f2839g = y;
            return true;
        }
        return false;
    }
}
