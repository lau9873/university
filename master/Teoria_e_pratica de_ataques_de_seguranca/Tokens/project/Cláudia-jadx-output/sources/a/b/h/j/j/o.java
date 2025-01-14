package a.b.h.j.j;

import a.b.h.j.j.p;
import android.content.Context;
import android.graphics.Point;
import android.graphics.Rect;
import android.os.Build;
import android.view.Display;
import android.view.View;
import android.view.WindowManager;
import android.widget.PopupWindow;
/* compiled from: MenuPopupHelper.java */
/* loaded from: classes.dex */
public class o implements j {

    /* renamed from: a  reason: collision with root package name */
    public final Context f1612a;

    /* renamed from: b  reason: collision with root package name */
    public final h f1613b;

    /* renamed from: c  reason: collision with root package name */
    public final boolean f1614c;

    /* renamed from: d  reason: collision with root package name */
    public final int f1615d;

    /* renamed from: e  reason: collision with root package name */
    public final int f1616e;

    /* renamed from: f  reason: collision with root package name */
    public View f1617f;

    /* renamed from: g  reason: collision with root package name */
    public int f1618g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f1619h;

    /* renamed from: i  reason: collision with root package name */
    public p.a f1620i;
    public n j;
    public PopupWindow.OnDismissListener k;
    public final PopupWindow.OnDismissListener l;

    /* compiled from: MenuPopupHelper.java */
    /* loaded from: classes.dex */
    public class a implements PopupWindow.OnDismissListener {
        public a() {
        }

        @Override // android.widget.PopupWindow.OnDismissListener
        public void onDismiss() {
            o.this.e();
        }
    }

    public o(Context context, h hVar, View view, boolean z, int i2) {
        this(context, hVar, view, z, i2, 0);
    }

    public void a(PopupWindow.OnDismissListener onDismissListener) {
        this.k = onDismissListener;
    }

    public void b() {
        if (d()) {
            this.j.dismiss();
        }
    }

    public n c() {
        if (this.j == null) {
            this.j = a();
        }
        return this.j;
    }

    public boolean d() {
        n nVar = this.j;
        return nVar != null && nVar.f();
    }

    public void e() {
        this.j = null;
        PopupWindow.OnDismissListener onDismissListener = this.k;
        if (onDismissListener != null) {
            onDismissListener.onDismiss();
        }
    }

    public void f() {
        if (!g()) {
            throw new IllegalStateException("MenuPopupHelper cannot be used without an anchor");
        }
    }

    public boolean g() {
        if (d()) {
            return true;
        }
        if (this.f1617f == null) {
            return false;
        }
        a(0, 0, false, false);
        return true;
    }

    public o(Context context, h hVar, View view, boolean z, int i2, int i3) {
        this.f1618g = 8388611;
        this.l = new a();
        this.f1612a = context;
        this.f1613b = hVar;
        this.f1617f = view;
        this.f1614c = z;
        this.f1615d = i2;
        this.f1616e = i3;
    }

    public void a(View view) {
        this.f1617f = view;
    }

    public void a(boolean z) {
        this.f1619h = z;
        n nVar = this.j;
        if (nVar != null) {
            nVar.b(z);
        }
    }

    public void a(int i2) {
        this.f1618g = i2;
    }

    public boolean a(int i2, int i3) {
        if (d()) {
            return true;
        }
        if (this.f1617f == null) {
            return false;
        }
        a(i2, i3, true, true);
        return true;
    }

    public final n a() {
        n uVar;
        Display defaultDisplay = ((WindowManager) this.f1612a.getSystemService("window")).getDefaultDisplay();
        Point point = new Point();
        if (Build.VERSION.SDK_INT >= 17) {
            defaultDisplay.getRealSize(point);
        } else {
            defaultDisplay.getSize(point);
        }
        if (Math.min(point.x, point.y) >= this.f1612a.getResources().getDimensionPixelSize(a.b.h.b.d.abc_cascading_menus_min_smallest_width)) {
            uVar = new e(this.f1612a, this.f1617f, this.f1615d, this.f1616e, this.f1614c);
        } else {
            uVar = new u(this.f1612a, this.f1613b, this.f1617f, this.f1615d, this.f1616e, this.f1614c);
        }
        uVar.a(this.f1613b);
        uVar.a(this.l);
        uVar.a(this.f1617f);
        uVar.a(this.f1620i);
        uVar.b(this.f1619h);
        uVar.a(this.f1618g);
        return uVar;
    }

    public final void a(int i2, int i3, boolean z, boolean z2) {
        n c2 = c();
        c2.c(z2);
        if (z) {
            if ((a.b.g.k.d.a(this.f1618g, a.b.g.k.u.k(this.f1617f)) & 7) == 5) {
                i2 -= this.f1617f.getWidth();
            }
            c2.b(i2);
            c2.c(i3);
            int i4 = (int) ((this.f1612a.getResources().getDisplayMetrics().density * 48.0f) / 2.0f);
            c2.a(new Rect(i2 - i4, i3 - i4, i2 + i4, i3 + i4));
        }
        c2.d();
    }

    public void a(p.a aVar) {
        this.f1620i = aVar;
        n nVar = this.j;
        if (nVar != null) {
            nVar.a(aVar);
        }
    }
}
