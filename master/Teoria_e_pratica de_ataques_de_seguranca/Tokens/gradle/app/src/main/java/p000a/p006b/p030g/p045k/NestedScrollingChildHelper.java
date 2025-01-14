package p000a.p006b.p030g.p045k;

import android.view.View;
import android.view.ViewParent;

/* renamed from: a.b.g.k.l */
/* loaded from: classes.dex */
public class NestedScrollingChildHelper {

    /* renamed from: a */
    public ViewParent f1636a;

    /* renamed from: b */
    public ViewParent f1637b;

    /* renamed from: c */
    public final View f1638c;

    /* renamed from: d */
    public boolean f1639d;

    /* renamed from: e */
    public int[] f1640e;

    public NestedScrollingChildHelper(View view) {
        this.f1638c = view;
    }

    /* renamed from: a */
    public void m9488a(boolean z) {
        if (this.f1639d) {
            ViewCompat.m9462C(this.f1638c);
        }
        this.f1639d = z;
    }

    /* renamed from: b */
    public boolean m9487b() {
        return this.f1639d;
    }

    /* renamed from: c */
    public boolean m9484c(int i) {
        return m9494a(i, 0);
    }

    /* renamed from: d */
    public void m9483d(int i) {
        ViewParent m9495a = m9495a(i);
        if (m9495a != null) {
            ViewParentCompat.m9342a(m9495a, this.f1638c, i);
            m9489a(i, (ViewParent) null);
        }
    }

    /* renamed from: b */
    public boolean m9486b(int i) {
        return m9495a(i) != null;
    }

    /* renamed from: c */
    public void m9485c() {
        m9483d(0);
    }

    /* renamed from: a */
    public boolean m9498a() {
        return m9486b(0);
    }

    /* renamed from: a */
    public boolean m9494a(int i, int i2) {
        if (m9486b(i2)) {
            return true;
        }
        if (m9487b()) {
            View view = this.f1638c;
            for (ViewParent parent = this.f1638c.getParent(); parent != null; parent = parent.getParent()) {
                if (ViewParentCompat.m9338b(parent, view, this.f1638c, i, i2)) {
                    m9489a(i2, parent);
                    ViewParentCompat.m9339a(parent, view, this.f1638c, i, i2);
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

    /* renamed from: a */
    public boolean m9493a(int i, int i2, int i3, int i4, int[] iArr) {
        return m9492a(i, i2, i3, i4, iArr, 0);
    }

    /* renamed from: a */
    public boolean m9492a(int i, int i2, int i3, int i4, int[] iArr, int i5) {
        ViewParent m9495a;
        int i6;
        int i7;
        if (!m9487b() || (m9495a = m9495a(i5)) == null) {
            return false;
        }
        if (i == 0 && i2 == 0 && i3 == 0 && i4 == 0) {
            if (iArr != null) {
                iArr[0] = 0;
                iArr[1] = 0;
            }
            return false;
        }
        if (iArr != null) {
            this.f1638c.getLocationInWindow(iArr);
            i6 = iArr[0];
            i7 = iArr[1];
        } else {
            i6 = 0;
            i7 = 0;
        }
        ViewParentCompat.m9341a(m9495a, this.f1638c, i, i2, i3, i4, i5);
        if (iArr != null) {
            this.f1638c.getLocationInWindow(iArr);
            iArr[0] = iArr[0] - i6;
            iArr[1] = iArr[1] - i7;
        }
        return true;
    }

    /* renamed from: a */
    public boolean m9491a(int i, int i2, int[] iArr, int[] iArr2) {
        return m9490a(i, i2, iArr, iArr2, 0);
    }

    /* renamed from: a */
    public boolean m9490a(int i, int i2, int[] iArr, int[] iArr2, int i3) {
        ViewParent m9495a;
        int i4;
        int i5;
        if (!m9487b() || (m9495a = m9495a(i3)) == null) {
            return false;
        }
        if (i == 0 && i2 == 0) {
            if (iArr2 != null) {
                iArr2[0] = 0;
                iArr2[1] = 0;
            }
            return false;
        }
        if (iArr2 != null) {
            this.f1638c.getLocationInWindow(iArr2);
            i4 = iArr2[0];
            i5 = iArr2[1];
        } else {
            i4 = 0;
            i5 = 0;
        }
        if (iArr == null) {
            if (this.f1640e == null) {
                this.f1640e = new int[2];
            }
            iArr = this.f1640e;
        }
        iArr[0] = 0;
        iArr[1] = 0;
        ViewParentCompat.m9340a(m9495a, this.f1638c, i, i2, iArr, i3);
        if (iArr2 != null) {
            this.f1638c.getLocationInWindow(iArr2);
            iArr2[0] = iArr2[0] - i4;
            iArr2[1] = iArr2[1] - i5;
        }
        return (iArr[0] == 0 && iArr[1] == 0) ? false : true;
    }

    /* renamed from: a */
    public boolean m9496a(float f, float f2, boolean z) {
        ViewParent m9495a;
        if (!m9487b() || (m9495a = m9495a(0)) == null) {
            return false;
        }
        return ViewParentCompat.m9343a(m9495a, this.f1638c, f, f2, z);
    }

    /* renamed from: a */
    public boolean m9497a(float f, float f2) {
        ViewParent m9495a;
        if (!m9487b() || (m9495a = m9495a(0)) == null) {
            return false;
        }
        return ViewParentCompat.m9344a(m9495a, this.f1638c, f, f2);
    }

    /* renamed from: a */
    public final ViewParent m9495a(int i) {
        if (i != 0) {
            if (i != 1) {
                return null;
            }
            return this.f1637b;
        }
        return this.f1636a;
    }

    /* renamed from: a */
    public final void m9489a(int i, ViewParent viewParent) {
        if (i == 0) {
            this.f1636a = viewParent;
        } else if (i != 1) {
        } else {
            this.f1637b = viewParent;
        }
    }
}
