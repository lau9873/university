package p000a.p006b.p030g.p045k;

import android.os.Build;
import android.view.WindowInsets;

/* renamed from: a.b.g.k.d0 */
/* loaded from: classes.dex */
public class WindowInsetsCompat {

    /* renamed from: a */
    public final Object f1617a;

    public WindowInsetsCompat(Object obj) {
        this.f1617a = obj;
    }

    /* renamed from: a */
    public int m9577a() {
        if (Build.VERSION.SDK_INT >= 20) {
            return ((WindowInsets) this.f1617a).getSystemWindowInsetBottom();
        }
        return 0;
    }

    /* renamed from: b */
    public int m9573b() {
        if (Build.VERSION.SDK_INT >= 20) {
            return ((WindowInsets) this.f1617a).getSystemWindowInsetLeft();
        }
        return 0;
    }

    /* renamed from: c */
    public int m9572c() {
        if (Build.VERSION.SDK_INT >= 20) {
            return ((WindowInsets) this.f1617a).getSystemWindowInsetRight();
        }
        return 0;
    }

    /* renamed from: d */
    public int m9571d() {
        if (Build.VERSION.SDK_INT >= 20) {
            return ((WindowInsets) this.f1617a).getSystemWindowInsetTop();
        }
        return 0;
    }

    /* renamed from: e */
    public boolean m9570e() {
        if (Build.VERSION.SDK_INT >= 21) {
            return ((WindowInsets) this.f1617a).isConsumed();
        }
        return false;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || WindowInsetsCompat.class != obj.getClass()) {
            return false;
        }
        Object obj2 = this.f1617a;
        Object obj3 = ((WindowInsetsCompat) obj).f1617a;
        return obj2 == null ? obj3 == null : obj2.equals(obj3);
    }

    public int hashCode() {
        Object obj = this.f1617a;
        if (obj == null) {
            return 0;
        }
        return obj.hashCode();
    }

    /* renamed from: a */
    public WindowInsetsCompat m9576a(int i, int i2, int i3, int i4) {
        if (Build.VERSION.SDK_INT >= 20) {
            return new WindowInsetsCompat(((WindowInsets) this.f1617a).replaceSystemWindowInsets(i, i2, i3, i4));
        }
        return null;
    }

    /* renamed from: a */
    public static WindowInsetsCompat m9574a(Object obj) {
        if (obj == null) {
            return null;
        }
        return new WindowInsetsCompat(obj);
    }

    /* renamed from: a */
    public static Object m9575a(WindowInsetsCompat windowInsetsCompat) {
        if (windowInsetsCompat == null) {
            return null;
        }
        return windowInsetsCompat.f1617a;
    }
}
