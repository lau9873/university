package p000a.p006b.p049h.p061j.p062j;

import android.content.Context;
import android.graphics.Point;
import android.graphics.Rect;
import android.os.Build;
import android.view.Display;
import android.view.View;
import android.view.WindowManager;
import android.widget.PopupWindow;
import p000a.p006b.p030g.p045k.GravityCompat;
import p000a.p006b.p030g.p045k.ViewCompat;
import p000a.p006b.p049h.p051b.C0357d;
import p000a.p006b.p049h.p061j.p062j.MenuPresenter;

/* renamed from: a.b.h.j.j.o */
/* loaded from: classes.dex */
public class MenuPopupHelper implements MenuHelper {

    /* renamed from: a */
    public final Context f2455a;

    /* renamed from: b */
    public final MenuBuilder f2456b;

    /* renamed from: c */
    public final boolean f2457c;

    /* renamed from: d */
    public final int f2458d;

    /* renamed from: e */
    public final int f2459e;

    /* renamed from: f */
    public View f2460f;

    /* renamed from: g */
    public int f2461g;

    /* renamed from: h */
    public boolean f2462h;

    /* renamed from: i */
    public MenuPresenter.InterfaceC0434a f2463i;

    /* renamed from: j */
    public MenuPopup f2464j;

    /* renamed from: k */
    public PopupWindow.OnDismissListener f2465k;

    /* renamed from: l */
    public final PopupWindow.OnDismissListener f2466l;

    /* compiled from: MenuPopupHelper.java */
    /* renamed from: a.b.h.j.j.o$a */
    /* loaded from: classes.dex */
    public class C0433a implements PopupWindow.OnDismissListener {
        public C0433a() {
        }

        @Override // android.widget.PopupWindow.OnDismissListener
        public void onDismiss() {
            MenuPopupHelper.this.mo8484e();
        }
    }

    public MenuPopupHelper(Context context, MenuBuilder menuBuilder, View view, boolean z, int i) {
        this(context, menuBuilder, view, z, i, 0);
    }

    /* renamed from: a */
    public void m8599a(PopupWindow.OnDismissListener onDismissListener) {
        this.f2465k = onDismissListener;
    }

    /* renamed from: b */
    public void m8597b() {
        if (m8595d()) {
            this.f2464j.dismiss();
        }
    }

    /* renamed from: c */
    public MenuPopup m8596c() {
        if (this.f2464j == null) {
            this.f2464j = m8605a();
        }
        return this.f2464j;
    }

    /* renamed from: d */
    public boolean m8595d() {
        MenuPopup menuPopup = this.f2464j;
        return menuPopup != null && menuPopup.mo8079f();
    }

    /* renamed from: e */
    public void mo8484e() {
        this.f2464j = null;
        PopupWindow.OnDismissListener onDismissListener = this.f2465k;
        if (onDismissListener != null) {
            onDismissListener.onDismiss();
        }
    }

    /* renamed from: f */
    public void m8594f() {
        if (!m8593g()) {
            throw new IllegalStateException("MenuPopupHelper cannot be used without an anchor");
        }
    }

    /* renamed from: g */
    public boolean m8593g() {
        if (m8595d()) {
            return true;
        }
        if (this.f2460f == null) {
            return false;
        }
        m8602a(0, 0, false, false);
        return true;
    }

    public MenuPopupHelper(Context context, MenuBuilder menuBuilder, View view, boolean z, int i, int i2) {
        this.f2461g = 8388611;
        this.f2466l = new C0433a();
        this.f2455a = context;
        this.f2456b = menuBuilder;
        this.f2460f = view;
        this.f2457c = z;
        this.f2458d = i;
        this.f2459e = i2;
    }

    /* renamed from: a */
    public void m8600a(View view) {
        this.f2460f = view;
    }

    /* renamed from: a */
    public void m8598a(boolean z) {
        this.f2462h = z;
        MenuPopup menuPopup = this.f2464j;
        if (menuPopup != null) {
            menuPopup.mo8583b(z);
        }
    }

    /* renamed from: a */
    public void m8604a(int i) {
        this.f2461g = i;
    }

    /* renamed from: a */
    public boolean m8603a(int i, int i2) {
        if (m8595d()) {
            return true;
        }
        if (this.f2460f == null) {
            return false;
        }
        m8602a(i, i2, true, true);
        return true;
    }

    /* renamed from: a */
    public final MenuPopup m8605a() {
        MenuPopup standardMenuPopup;
        Display defaultDisplay = ((WindowManager) this.f2455a.getSystemService("window")).getDefaultDisplay();
        Point point = new Point();
        if (Build.VERSION.SDK_INT >= 17) {
            defaultDisplay.getRealSize(point);
        } else {
            defaultDisplay.getSize(point);
        }
        if (Math.min(point.x, point.y) >= this.f2455a.getResources().getDimensionPixelSize(C0357d.abc_cascading_menus_min_smallest_width)) {
            standardMenuPopup = new CascadingMenuPopup(this.f2455a, this.f2460f, this.f2458d, this.f2459e, this.f2457c);
        } else {
            standardMenuPopup = new StandardMenuPopup(this.f2455a, this.f2456b, this.f2460f, this.f2458d, this.f2459e, this.f2457c);
        }
        standardMenuPopup.mo8588a(this.f2456b);
        standardMenuPopup.mo8585a(this.f2466l);
        standardMenuPopup.mo8586a(this.f2460f);
        standardMenuPopup.mo8587a(this.f2463i);
        standardMenuPopup.mo8583b(this.f2462h);
        standardMenuPopup.mo8589a(this.f2461g);
        return standardMenuPopup;
    }

    /* renamed from: a */
    public final void m8602a(int i, int i2, boolean z, boolean z2) {
        MenuPopup m8596c = m8596c();
        m8596c.mo8581c(z2);
        if (z) {
            if ((GravityCompat.m9579a(this.f2461g, ViewCompat.m9422k(this.f2460f)) & 7) == 5) {
                i -= this.f2460f.getWidth();
            }
            m8596c.mo8584b(i);
            m8596c.mo8582c(i2);
            int i3 = (int) ((this.f2455a.getResources().getDisplayMetrics().density * 48.0f) / 2.0f);
            m8596c.m8611a(new Rect(i - i3, i2 - i3, i + i3, i2 + i3));
        }
        m8596c.mo7998d();
    }

    /* renamed from: a */
    public void m8601a(MenuPresenter.InterfaceC0434a interfaceC0434a) {
        this.f2463i = interfaceC0434a;
        MenuPopup menuPopup = this.f2464j;
        if (menuPopup != null) {
            menuPopup.mo8587a(interfaceC0434a);
        }
    }
}
