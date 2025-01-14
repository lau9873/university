package android.support.p067v7.widget;

import android.content.Context;
import android.graphics.Rect;
import android.support.p067v7.widget.LinearLayoutManager;
import android.support.p067v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseIntArray;
import android.view.View;
import android.view.ViewGroup;
import p000a.p006b.p030g.p045k.p046e0.AccessibilityNodeInfoCompat;

/* renamed from: android.support.v7.widget.GridLayoutManager */
/* loaded from: classes.dex */
public class GridLayoutManager extends LinearLayoutManager {

    /* renamed from: H */
    public boolean f4050H;

    /* renamed from: I */
    public int f4051I;

    /* renamed from: J */
    public int[] f4052J;

    /* renamed from: K */
    public View[] f4053K;

    /* renamed from: L */
    public final SparseIntArray f4054L;

    /* renamed from: M */
    public final SparseIntArray f4055M;

    /* renamed from: N */
    public AbstractC0695c f4056N;

    /* renamed from: O */
    public final Rect f4057O;

    /* renamed from: android.support.v7.widget.GridLayoutManager$a */
    /* loaded from: classes.dex */
    public static final class C0693a extends AbstractC0695c {
        @Override // android.support.p067v7.widget.GridLayoutManager.AbstractC0695c
        /* renamed from: a */
        public int mo7038a(int i) {
            return 1;
        }

        @Override // android.support.p067v7.widget.GridLayoutManager.AbstractC0695c
        /* renamed from: c */
        public int mo7035c(int i, int i2) {
            return i % i2;
        }
    }

    /* renamed from: android.support.v7.widget.GridLayoutManager$c */
    /* loaded from: classes.dex */
    public static abstract class AbstractC0695c {

        /* renamed from: a */
        public final SparseIntArray f4060a = new SparseIntArray();

        /* renamed from: b */
        public boolean f4061b = false;

        /* renamed from: a */
        public abstract int mo7038a(int i);

        /* renamed from: a */
        public void m7039a() {
            this.f4060a.clear();
        }

        /* renamed from: b */
        public int m7036b(int i, int i2) {
            int mo7038a = mo7038a(i);
            int i3 = 0;
            int i4 = 0;
            for (int i5 = 0; i5 < i; i5++) {
                int mo7038a2 = mo7038a(i5);
                i3 += mo7038a2;
                if (i3 == i2) {
                    i4++;
                    i3 = 0;
                } else if (i3 > i2) {
                    i4++;
                    i3 = mo7038a2;
                }
            }
            return i3 + mo7038a > i2 ? i4 + 1 : i4;
        }

        /* renamed from: c */
        public abstract int mo7035c(int i, int i2);

        /* renamed from: a */
        public int m7037a(int i, int i2) {
            if (!this.f4061b) {
                return mo7035c(i, i2);
            }
            int i3 = this.f4060a.get(i, -1);
            if (i3 != -1) {
                return i3;
            }
            int mo7035c = mo7035c(i, i2);
            this.f4060a.put(i, mo7035c);
            return mo7035c;
        }
    }

    public GridLayoutManager(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        this.f4050H = false;
        this.f4051I = -1;
        this.f4054L = new SparseIntArray();
        this.f4055M = new SparseIntArray();
        this.f4056N = new C0693a();
        this.f4057O = new Rect();
        m7042l(RecyclerView.AbstractC0722o.m6698a(context, attributeSet, i, i2).f4265b);
    }

    @Override // android.support.p067v7.widget.LinearLayoutManager, android.support.p067v7.widget.RecyclerView.AbstractC0722o
    /* renamed from: C */
    public boolean mo6478C() {
        return this.f4065D == null && !this.f4050H;
    }

    /* renamed from: N */
    public final void m7057N() {
        int m6644e = m6644e();
        for (int i = 0; i < m6644e; i++) {
            C0694b c0694b = (C0694b) m6657c(i).getLayoutParams();
            int m6604a = c0694b.m6604a();
            this.f4054L.put(m6604a, c0694b.m7040f());
            this.f4055M.put(m6604a, c0694b.m7041e());
        }
    }

    /* renamed from: O */
    public final void m7056O() {
        this.f4054L.clear();
        this.f4055M.clear();
    }

    /* renamed from: P */
    public final void m7055P() {
        View[] viewArr = this.f4053K;
        if (viewArr == null || viewArr.length != this.f4051I) {
            this.f4053K = new View[this.f4051I];
        }
    }

    /* renamed from: Q */
    public final void m7054Q() {
        int m6635h;
        int m6619p;
        if (m7028J() == 1) {
            m6635h = m6618q() - m6621o();
            m6619p = m6623n();
        } else {
            m6635h = m6635h() - m6625m();
            m6619p = m6619p();
        }
        m7043k(m6635h - m6619p);
    }

    @Override // android.support.p067v7.widget.RecyclerView.AbstractC0722o
    /* renamed from: a */
    public int mo6451a(RecyclerView.C0734v c0734v, RecyclerView.C0702a0 c0702a0) {
        if (this.f4069s == 1) {
            return this.f4051I;
        }
        if (c0702a0.m6846a() < 1) {
            return 0;
        }
        return m7052a(c0734v, c0702a0, c0702a0.m6846a() - 1) + 1;
    }

    @Override // android.support.p067v7.widget.LinearLayoutManager
    /* renamed from: b */
    public void mo7003b(boolean z) {
        if (!z) {
            super.mo7003b(false);
            return;
        }
        throw new UnsupportedOperationException("GridLayoutManager does not support stack from end. Consider using reverse layout");
    }

    @Override // android.support.p067v7.widget.RecyclerView.AbstractC0722o
    /* renamed from: c */
    public void mo6418c(RecyclerView recyclerView, int i, int i2) {
        this.f4056N.m7039a();
    }

    @Override // android.support.p067v7.widget.RecyclerView.AbstractC0722o
    /* renamed from: d */
    public void mo6413d(RecyclerView recyclerView) {
        this.f4056N.m7039a();
    }

    @Override // android.support.p067v7.widget.LinearLayoutManager, android.support.p067v7.widget.RecyclerView.AbstractC0722o
    /* renamed from: e */
    public void mo6409e(RecyclerView.C0734v c0734v, RecyclerView.C0702a0 c0702a0) {
        if (c0702a0.m6841d()) {
            m7057N();
        }
        super.mo6409e(c0734v, c0702a0);
        m7056O();
    }

    @Override // android.support.p067v7.widget.LinearLayoutManager, android.support.p067v7.widget.RecyclerView.AbstractC0722o
    /* renamed from: g */
    public void mo6406g(RecyclerView.C0702a0 c0702a0) {
        super.mo6406g(c0702a0);
        this.f4050H = false;
    }

    /* renamed from: h */
    public int m7044h(int i, int i2) {
        if (this.f4069s == 1 && m7027K()) {
            int[] iArr = this.f4052J;
            int i3 = this.f4051I;
            return iArr[i3 - i] - iArr[(i3 - i) - i2];
        }
        int[] iArr2 = this.f4052J;
        return iArr2[i2 + i] - iArr2[i];
    }

    /* renamed from: k */
    public final void m7043k(int i) {
        this.f4052J = m7049a(this.f4052J, this.f4051I, i);
    }

    /* renamed from: l */
    public void m7042l(int i) {
        if (i == this.f4051I) {
            return;
        }
        this.f4050H = true;
        if (i >= 1) {
            this.f4051I = i;
            this.f4056N.m7039a();
            m6612y();
            return;
        }
        throw new IllegalArgumentException("Span count should be at least 1. Provided " + i);
    }

    @Override // android.support.p067v7.widget.LinearLayoutManager, android.support.p067v7.widget.RecyclerView.AbstractC0722o
    /* renamed from: c */
    public RecyclerView.C0727p mo6424c() {
        if (this.f4069s == 0) {
            return new C0694b(-2, -1);
        }
        return new C0694b(-1, -2);
    }

    /* renamed from: android.support.v7.widget.GridLayoutManager$b */
    /* loaded from: classes.dex */
    public static class C0694b extends RecyclerView.C0727p {

        /* renamed from: e */
        public int f4058e;

        /* renamed from: f */
        public int f4059f;

        public C0694b(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            this.f4058e = -1;
            this.f4059f = 0;
        }

        /* renamed from: e */
        public int m7041e() {
            return this.f4058e;
        }

        /* renamed from: f */
        public int m7040f() {
            return this.f4059f;
        }

        public C0694b(int i, int i2) {
            super(i, i2);
            this.f4058e = -1;
            this.f4059f = 0;
        }

        public C0694b(ViewGroup.MarginLayoutParams marginLayoutParams) {
            super(marginLayoutParams);
            this.f4058e = -1;
            this.f4059f = 0;
        }

        public C0694b(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
            this.f4058e = -1;
            this.f4059f = 0;
        }
    }

    @Override // android.support.p067v7.widget.RecyclerView.AbstractC0722o
    /* renamed from: b */
    public int mo6429b(RecyclerView.C0734v c0734v, RecyclerView.C0702a0 c0702a0) {
        if (this.f4069s == 0) {
            return this.f4051I;
        }
        if (c0702a0.m6846a() < 1) {
            return 0;
        }
        return m7052a(c0734v, c0702a0, c0702a0.m6846a() - 1) + 1;
    }

    @Override // android.support.p067v7.widget.RecyclerView.AbstractC0722o
    /* renamed from: a */
    public void mo6450a(RecyclerView.C0734v c0734v, RecyclerView.C0702a0 c0702a0, View view, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (!(layoutParams instanceof C0694b)) {
            super.m6673a(view, accessibilityNodeInfoCompat);
            return;
        }
        C0694b c0694b = (C0694b) layoutParams;
        int m7052a = m7052a(c0734v, c0702a0, c0694b.m6604a());
        if (this.f4069s == 0) {
            accessibilityNodeInfoCompat.m9547b(AccessibilityNodeInfoCompat.C0285b.m9520a(c0694b.m7041e(), c0694b.m7040f(), m7052a, 1, this.f4051I > 1 && c0694b.m7040f() == this.f4051I, false));
        } else {
            accessibilityNodeInfoCompat.m9547b(AccessibilityNodeInfoCompat.C0285b.m9520a(m7052a, 1, c0694b.m7041e(), c0694b.m7040f(), this.f4051I > 1 && c0694b.m7040f() == this.f4051I, false));
        }
    }

    /* renamed from: c */
    public final int m7045c(RecyclerView.C0734v c0734v, RecyclerView.C0702a0 c0702a0, int i) {
        if (!c0702a0.m6841d()) {
            return this.f4056N.mo7038a(i);
        }
        int i2 = this.f4054L.get(i, -1);
        if (i2 != -1) {
            return i2;
        }
        int m6581a = c0734v.m6581a(i);
        if (m6581a == -1) {
            Log.w("GridLayoutManager", "Cannot find span size for pre layout position. It is not cached, not in the adapter. Pos:" + i);
            return 1;
        }
        return this.f4056N.mo7038a(m6581a);
    }

    @Override // android.support.p067v7.widget.RecyclerView.AbstractC0722o
    /* renamed from: b */
    public void mo6427b(RecyclerView recyclerView, int i, int i2) {
        this.f4056N.m7039a();
    }

    @Override // android.support.p067v7.widget.LinearLayoutManager, android.support.p067v7.widget.RecyclerView.AbstractC0722o
    /* renamed from: b */
    public int mo6433b(int i, RecyclerView.C0734v c0734v, RecyclerView.C0702a0 c0702a0) {
        m7054Q();
        m7055P();
        return super.mo6433b(i, c0734v, c0702a0);
    }

    /* renamed from: b */
    public final void m7047b(RecyclerView.C0734v c0734v, RecyclerView.C0702a0 c0702a0, LinearLayoutManager.C0696a c0696a, int i) {
        boolean z = i == 1;
        int m7048b = m7048b(c0734v, c0702a0, c0696a.f4078b);
        if (z) {
            while (m7048b > 0) {
                int i2 = c0696a.f4078b;
                if (i2 <= 0) {
                    return;
                }
                c0696a.f4078b = i2 - 1;
                m7048b = m7048b(c0734v, c0702a0, c0696a.f4078b);
            }
            return;
        }
        int m6846a = c0702a0.m6846a() - 1;
        int i3 = c0696a.f4078b;
        while (i3 < m6846a) {
            int i4 = i3 + 1;
            int m7048b2 = m7048b(c0734v, c0702a0, i4);
            if (m7048b2 <= m7048b) {
                break;
            }
            i3 = i4;
            m7048b = m7048b2;
        }
        c0696a.f4078b = i3;
    }

    @Override // android.support.p067v7.widget.RecyclerView.AbstractC0722o
    /* renamed from: a */
    public void mo6447a(RecyclerView recyclerView, int i, int i2, Object obj) {
        this.f4056N.m7039a();
    }

    @Override // android.support.p067v7.widget.RecyclerView.AbstractC0722o
    /* renamed from: a */
    public void mo6448a(RecyclerView recyclerView, int i, int i2, int i3) {
        this.f4056N.m7039a();
    }

    @Override // android.support.p067v7.widget.RecyclerView.AbstractC0722o
    /* renamed from: a */
    public RecyclerView.C0727p mo6460a(Context context, AttributeSet attributeSet) {
        return new C0694b(context, attributeSet);
    }

    /* renamed from: b */
    public final int m7048b(RecyclerView.C0734v c0734v, RecyclerView.C0702a0 c0702a0, int i) {
        if (!c0702a0.m6841d()) {
            return this.f4056N.m7037a(i, this.f4051I);
        }
        int i2 = this.f4055M.get(i, -1);
        if (i2 != -1) {
            return i2;
        }
        int m6581a = c0734v.m6581a(i);
        if (m6581a == -1) {
            Log.w("GridLayoutManager", "Cannot find span size for pre layout position. It is not cached, not in the adapter. Pos:" + i);
            return 0;
        }
        return this.f4056N.m7037a(m6581a, this.f4051I);
    }

    @Override // android.support.p067v7.widget.RecyclerView.AbstractC0722o
    /* renamed from: a */
    public RecyclerView.C0727p mo6439a(ViewGroup.LayoutParams layoutParams) {
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            return new C0694b((ViewGroup.MarginLayoutParams) layoutParams);
        }
        return new C0694b(layoutParams);
    }

    @Override // android.support.p067v7.widget.RecyclerView.AbstractC0722o
    /* renamed from: a */
    public boolean mo6455a(RecyclerView.C0727p c0727p) {
        return c0727p instanceof C0694b;
    }

    @Override // android.support.p067v7.widget.RecyclerView.AbstractC0722o
    /* renamed from: a */
    public void mo6459a(Rect rect, int i, int i2) {
        int m6705a;
        int m6705a2;
        if (this.f4052J == null) {
            super.mo6459a(rect, i, i2);
        }
        int m6623n = m6623n() + m6621o();
        int m6619p = m6619p() + m6625m();
        if (this.f4069s == 1) {
            m6705a2 = RecyclerView.AbstractC0722o.m6705a(i2, rect.height() + m6619p, m6629k());
            int[] iArr = this.f4052J;
            m6705a = RecyclerView.AbstractC0722o.m6705a(i, iArr[iArr.length - 1] + m6623n, m6627l());
        } else {
            m6705a = RecyclerView.AbstractC0722o.m6705a(i, rect.width() + m6623n, m6627l());
            int[] iArr2 = this.f4052J;
            m6705a2 = RecyclerView.AbstractC0722o.m6705a(i2, iArr2[iArr2.length - 1] + m6619p, m6629k());
        }
        m6656c(m6705a, m6705a2);
    }

    /* renamed from: b */
    public final void m7046b(View view, int i, boolean z) {
        int i2;
        int i3;
        C0694b c0694b = (C0694b) view.getLayoutParams();
        Rect rect = c0694b.f4269b;
        int i4 = rect.top + rect.bottom + ((ViewGroup.MarginLayoutParams) c0694b).topMargin + ((ViewGroup.MarginLayoutParams) c0694b).bottomMargin;
        int i5 = rect.left + rect.right + ((ViewGroup.MarginLayoutParams) c0694b).leftMargin + ((ViewGroup.MarginLayoutParams) c0694b).rightMargin;
        int m7044h = m7044h(c0694b.f4058e, c0694b.f4059f);
        if (this.f4069s == 1) {
            i3 = RecyclerView.AbstractC0722o.m6704a(m7044h, i, i5, ((ViewGroup.MarginLayoutParams) c0694b).width, false);
            i2 = RecyclerView.AbstractC0722o.m6704a(this.f4071u.mo8004g(), m6633i(), i4, ((ViewGroup.MarginLayoutParams) c0694b).height, true);
        } else {
            int m6704a = RecyclerView.AbstractC0722o.m6704a(m7044h, i, i4, ((ViewGroup.MarginLayoutParams) c0694b).height, false);
            int m6704a2 = RecyclerView.AbstractC0722o.m6704a(this.f4071u.mo8004g(), m6617r(), i5, ((ViewGroup.MarginLayoutParams) c0694b).width, true);
            i2 = m6704a;
            i3 = m6704a2;
        }
        m7050a(view, i3, i2, z);
    }

    /* renamed from: a */
    public static int[] m7049a(int[] iArr, int i, int i2) {
        int i3;
        if (iArr == null || iArr.length != i + 1 || iArr[iArr.length - 1] != i2) {
            iArr = new int[i + 1];
        }
        int i4 = 0;
        iArr[0] = 0;
        int i5 = i2 / i;
        int i6 = i2 % i;
        int i7 = 0;
        for (int i8 = 1; i8 <= i; i8++) {
            i4 += i6;
            if (i4 <= 0 || i - i4 >= i6) {
                i3 = i5;
            } else {
                i3 = i5 + 1;
                i4 -= i;
            }
            i7 += i3;
            iArr[i8] = i7;
        }
        return iArr;
    }

    @Override // android.support.p067v7.widget.LinearLayoutManager
    /* renamed from: a */
    public void mo7012a(RecyclerView.C0734v c0734v, RecyclerView.C0702a0 c0702a0, LinearLayoutManager.C0696a c0696a, int i) {
        super.mo7012a(c0734v, c0702a0, c0696a, i);
        m7054Q();
        if (c0702a0.m6846a() > 0 && !c0702a0.m6841d()) {
            m7047b(c0734v, c0702a0, c0696a, i);
        }
        m7055P();
    }

    @Override // android.support.p067v7.widget.LinearLayoutManager, android.support.p067v7.widget.RecyclerView.AbstractC0722o
    /* renamed from: a */
    public int mo6462a(int i, RecyclerView.C0734v c0734v, RecyclerView.C0702a0 c0702a0) {
        m7054Q();
        m7055P();
        return super.mo6462a(i, c0734v, c0702a0);
    }

    @Override // android.support.p067v7.widget.LinearLayoutManager
    /* renamed from: a */
    public View mo7014a(RecyclerView.C0734v c0734v, RecyclerView.C0702a0 c0702a0, int i, int i2, int i3) {
        m7033E();
        int mo8006f = this.f4071u.mo8006f();
        int mo8014b = this.f4071u.mo8014b();
        int i4 = i2 > i ? 1 : -1;
        View view = null;
        View view2 = null;
        while (i != i2) {
            View m6657c = m6657c(i);
            int m6626l = m6626l(m6657c);
            if (m6626l >= 0 && m6626l < i3 && m7048b(c0734v, c0702a0, m6626l) == 0) {
                if (((RecyclerView.C0727p) m6657c.getLayoutParams()).m6602c()) {
                    if (view2 == null) {
                        view2 = m6657c;
                    }
                } else if (this.f4071u.mo8009d(m6657c) < mo8014b && this.f4071u.mo8015a(m6657c) >= mo8006f) {
                    return m6657c;
                } else {
                    if (view == null) {
                        view = m6657c;
                    }
                }
            }
            i += i4;
        }
        return view != null ? view : view2;
    }

    /* renamed from: a */
    public final int m7052a(RecyclerView.C0734v c0734v, RecyclerView.C0702a0 c0702a0, int i) {
        if (!c0702a0.m6841d()) {
            return this.f4056N.m7036b(i, this.f4051I);
        }
        int m6581a = c0734v.m6581a(i);
        if (m6581a == -1) {
            Log.w("GridLayoutManager", "Cannot find span size for pre layout position. " + i);
            return 0;
        }
        return this.f4056N.m7036b(m6581a, this.f4051I);
    }

    @Override // android.support.p067v7.widget.LinearLayoutManager
    /* renamed from: a */
    public void mo7019a(RecyclerView.C0702a0 c0702a0, LinearLayoutManager.C0698c c0698c, RecyclerView.AbstractC0722o.InterfaceC0725c interfaceC0725c) {
        int i = this.f4051I;
        for (int i2 = 0; i2 < this.f4051I && c0698c.m6976a(c0702a0) && i > 0; i2++) {
            int i3 = c0698c.f4089d;
            interfaceC0725c.mo6605a(i3, Math.max(0, c0698c.f4092g));
            i -= this.f4056N.mo7038a(i3);
            c0698c.f4089d += c0698c.f4090e;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:37:0x00a1, code lost:
        r22.f4083b = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:38:0x00a3, code lost:
        return;
     */
    @Override // android.support.p067v7.widget.LinearLayoutManager
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void mo7011a(android.support.p067v7.widget.RecyclerView.C0734v r19, android.support.p067v7.widget.RecyclerView.C0702a0 r20, android.support.p067v7.widget.LinearLayoutManager.C0698c r21, android.support.p067v7.widget.LinearLayoutManager.C0697b r22) {
        /*
            Method dump skipped, instructions count: 574
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.p067v7.widget.GridLayoutManager.mo7011a(android.support.v7.widget.RecyclerView$v, android.support.v7.widget.RecyclerView$a0, android.support.v7.widget.LinearLayoutManager$c, android.support.v7.widget.LinearLayoutManager$b):void");
    }

    /* renamed from: a */
    public final void m7053a(float f, int i) {
        m7043k(Math.max(Math.round(f * this.f4051I), i));
    }

    /* renamed from: a */
    public final void m7050a(View view, int i, int i2, boolean z) {
        boolean m6677a;
        RecyclerView.C0727p c0727p = (RecyclerView.C0727p) view.getLayoutParams();
        if (z) {
            m6677a = m6659b(view, i, i2, c0727p);
        } else {
            m6677a = m6677a(view, i, i2, c0727p);
        }
        if (m6677a) {
            view.measure(i, i2);
        }
    }

    /* renamed from: a */
    public final void m7051a(RecyclerView.C0734v c0734v, RecyclerView.C0702a0 c0702a0, int i, int i2, boolean z) {
        int i3;
        int i4;
        int i5 = 0;
        int i6 = -1;
        if (z) {
            i6 = i;
            i3 = 0;
            i4 = 1;
        } else {
            i3 = i - 1;
            i4 = -1;
        }
        while (i3 != i6) {
            View view = this.f4053K[i3];
            C0694b c0694b = (C0694b) view.getLayoutParams();
            c0694b.f4059f = m7045c(c0734v, c0702a0, m6626l(view));
            c0694b.f4058e = i5;
            i5 += c0694b.f4059f;
            i3 += i4;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:59:0x00d7, code lost:
        if (r13 == (r2 > r8)) goto L65;
     */
    /* JADX WARN: Code restructure failed: missing block: B:71:0x00f7, code lost:
        if (r13 == (r2 > r10)) goto L51;
     */
    /* JADX WARN: Removed duplicated region for block: B:77:0x0105  */
    @Override // android.support.p067v7.widget.LinearLayoutManager, android.support.p067v7.widget.RecyclerView.AbstractC0722o
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public android.view.View mo6442a(android.view.View r24, int r25, android.support.p067v7.widget.RecyclerView.C0734v r26, android.support.p067v7.widget.RecyclerView.C0702a0 r27) {
        /*
            Method dump skipped, instructions count: 335
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.p067v7.widget.GridLayoutManager.mo6442a(android.view.View, int, android.support.v7.widget.RecyclerView$v, android.support.v7.widget.RecyclerView$a0):android.view.View");
    }
}
