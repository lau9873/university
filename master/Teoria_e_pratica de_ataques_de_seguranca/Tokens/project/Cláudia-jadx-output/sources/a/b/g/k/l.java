package a.b.g.k;

import android.view.View;
import android.view.ViewParent;
/* compiled from: NestedScrollingChildHelper.java */
/* loaded from: classes.dex */
public class l {

    /* renamed from: a  reason: collision with root package name */
    public ViewParent f1125a;

    /* renamed from: b  reason: collision with root package name */
    public ViewParent f1126b;

    /* renamed from: c  reason: collision with root package name */
    public final View f1127c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f1128d;

    /* renamed from: e  reason: collision with root package name */
    public int[] f1129e;

    public l(View view) {
        this.f1127c = view;
    }

    public void a(boolean z) {
        if (this.f1128d) {
            u.C(this.f1127c);
        }
        this.f1128d = z;
    }

    public boolean b() {
        return this.f1128d;
    }

    public boolean c(int i2) {
        return a(i2, 0);
    }

    public void d(int i2) {
        ViewParent a2 = a(i2);
        if (a2 != null) {
            y.a(a2, this.f1127c, i2);
            a(i2, (ViewParent) null);
        }
    }

    public boolean b(int i2) {
        return a(i2) != null;
    }

    public void c() {
        d(0);
    }

    public boolean a() {
        return b(0);
    }

    public boolean a(int i2, int i3) {
        if (b(i3)) {
            return true;
        }
        if (b()) {
            View view = this.f1127c;
            for (ViewParent parent = this.f1127c.getParent(); parent != null; parent = parent.getParent()) {
                if (y.b(parent, view, this.f1127c, i2, i3)) {
                    a(i3, parent);
                    y.a(parent, view, this.f1127c, i2, i3);
                    return true;
                }
                if (parent instanceof View) {
                    view = (View) parent;
                }
            }
            return false;
        }
        return false;
    }

    public boolean a(int i2, int i3, int i4, int i5, int[] iArr) {
        return a(i2, i3, i4, i5, iArr, 0);
    }

    public boolean a(int i2, int i3, int i4, int i5, int[] iArr, int i6) {
        ViewParent a2;
        int i7;
        int i8;
        if (!b() || (a2 = a(i6)) == null) {
            return false;
        }
        if (i2 == 0 && i3 == 0 && i4 == 0 && i5 == 0) {
            if (iArr != null) {
                iArr[0] = 0;
                iArr[1] = 0;
            }
            return false;
        }
        if (iArr != null) {
            this.f1127c.getLocationInWindow(iArr);
            i7 = iArr[0];
            i8 = iArr[1];
        } else {
            i7 = 0;
            i8 = 0;
        }
        y.a(a2, this.f1127c, i2, i3, i4, i5, i6);
        if (iArr != null) {
            this.f1127c.getLocationInWindow(iArr);
            iArr[0] = iArr[0] - i7;
            iArr[1] = iArr[1] - i8;
        }
        return true;
    }

    public boolean a(int i2, int i3, int[] iArr, int[] iArr2) {
        return a(i2, i3, iArr, iArr2, 0);
    }

    public boolean a(int i2, int i3, int[] iArr, int[] iArr2, int i4) {
        ViewParent a2;
        int i5;
        int i6;
        if (!b() || (a2 = a(i4)) == null) {
            return false;
        }
        if (i2 == 0 && i3 == 0) {
            if (iArr2 != null) {
                iArr2[0] = 0;
                iArr2[1] = 0;
            }
            return false;
        }
        if (iArr2 != null) {
            this.f1127c.getLocationInWindow(iArr2);
            i5 = iArr2[0];
            i6 = iArr2[1];
        } else {
            i5 = 0;
            i6 = 0;
        }
        if (iArr == null) {
            if (this.f1129e == null) {
                this.f1129e = new int[2];
            }
            iArr = this.f1129e;
        }
        iArr[0] = 0;
        iArr[1] = 0;
        y.a(a2, this.f1127c, i2, i3, iArr, i4);
        if (iArr2 != null) {
            this.f1127c.getLocationInWindow(iArr2);
            iArr2[0] = iArr2[0] - i5;
            iArr2[1] = iArr2[1] - i6;
        }
        return (iArr[0] == 0 && iArr[1] == 0) ? false : true;
    }

    public boolean a(float f2, float f3, boolean z) {
        ViewParent a2;
        if (!b() || (a2 = a(0)) == null) {
            return false;
        }
        return y.a(a2, this.f1127c, f2, f3, z);
    }

    public boolean a(float f2, float f3) {
        ViewParent a2;
        if (!b() || (a2 = a(0)) == null) {
            return false;
        }
        return y.a(a2, this.f1127c, f2, f3);
    }

    public final ViewParent a(int i2) {
        if (i2 != 0) {
            if (i2 != 1) {
                return null;
            }
            return this.f1126b;
        }
        return this.f1125a;
    }

    public final void a(int i2, ViewParent viewParent) {
        if (i2 == 0) {
            this.f1125a = viewParent;
        } else if (i2 != 1) {
        } else {
            this.f1126b = viewParent;
        }
    }
}
