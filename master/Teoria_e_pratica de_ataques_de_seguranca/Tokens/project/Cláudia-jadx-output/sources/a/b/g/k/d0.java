package a.b.g.k;

import android.os.Build;
import android.view.WindowInsets;
/* compiled from: WindowInsetsCompat.java */
/* loaded from: classes.dex */
public class d0 {

    /* renamed from: a  reason: collision with root package name */
    public final Object f1106a;

    public d0(Object obj) {
        this.f1106a = obj;
    }

    public int a() {
        if (Build.VERSION.SDK_INT >= 20) {
            return ((WindowInsets) this.f1106a).getSystemWindowInsetBottom();
        }
        return 0;
    }

    public int b() {
        if (Build.VERSION.SDK_INT >= 20) {
            return ((WindowInsets) this.f1106a).getSystemWindowInsetLeft();
        }
        return 0;
    }

    public int c() {
        if (Build.VERSION.SDK_INT >= 20) {
            return ((WindowInsets) this.f1106a).getSystemWindowInsetRight();
        }
        return 0;
    }

    public int d() {
        if (Build.VERSION.SDK_INT >= 20) {
            return ((WindowInsets) this.f1106a).getSystemWindowInsetTop();
        }
        return 0;
    }

    public boolean e() {
        if (Build.VERSION.SDK_INT >= 21) {
            return ((WindowInsets) this.f1106a).isConsumed();
        }
        return false;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || d0.class != obj.getClass()) {
            return false;
        }
        Object obj2 = this.f1106a;
        Object obj3 = ((d0) obj).f1106a;
        return obj2 == null ? obj3 == null : obj2.equals(obj3);
    }

    public int hashCode() {
        Object obj = this.f1106a;
        if (obj == null) {
            return 0;
        }
        return obj.hashCode();
    }

    public d0 a(int i2, int i3, int i4, int i5) {
        if (Build.VERSION.SDK_INT >= 20) {
            return new d0(((WindowInsets) this.f1106a).replaceSystemWindowInsets(i2, i3, i4, i5));
        }
        return null;
    }

    public static d0 a(Object obj) {
        if (obj == null) {
            return null;
        }
        return new d0(obj);
    }

    public static Object a(d0 d0Var) {
        if (d0Var == null) {
            return null;
        }
        return d0Var.f1106a;
    }
}
