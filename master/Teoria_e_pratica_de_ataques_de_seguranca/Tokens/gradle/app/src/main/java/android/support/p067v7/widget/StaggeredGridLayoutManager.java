package android.support.p067v7.widget;

import android.content.Context;
import android.graphics.Rect;
import android.os.Parcel;
import android.os.Parcelable;
import android.support.p067v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.BitSet;
import java.util.List;
import p000a.p006b.p030g.p045k.p046e0.AccessibilityNodeInfoCompat;
import p000a.p006b.p049h.p063k.LayoutState;
import p000a.p006b.p049h.p063k.OrientationHelper;
import p000a.p006b.p049h.p063k.ScrollbarHelper;

/* renamed from: android.support.v7.widget.StaggeredGridLayoutManager */
/* loaded from: classes.dex */
public class StaggeredGridLayoutManager extends RecyclerView.AbstractC0722o implements RecyclerView.AbstractC0739z.InterfaceC0740a {

    /* renamed from: B */
    public BitSet f4366B;

    /* renamed from: G */
    public boolean f4371G;

    /* renamed from: H */
    public boolean f4372H;

    /* renamed from: I */
    public C0765e f4373I;

    /* renamed from: J */
    public int f4374J;

    /* renamed from: O */
    public int[] f4379O;

    /* renamed from: t */
    public C0767f[] f4382t;

    /* renamed from: u */
    public OrientationHelper f4383u;

    /* renamed from: v */
    public OrientationHelper f4384v;

    /* renamed from: w */
    public int f4385w;

    /* renamed from: x */
    public int f4386x;

    /* renamed from: y */
    public final LayoutState f4387y;

    /* renamed from: s */
    public int f4381s = -1;

    /* renamed from: z */
    public boolean f4388z = false;

    /* renamed from: A */
    public boolean f4365A = false;

    /* renamed from: C */
    public int f4367C = -1;

    /* renamed from: D */
    public int f4368D = Integer.MIN_VALUE;

    /* renamed from: E */
    public C0762d f4369E = new C0762d();

    /* renamed from: F */
    public int f4370F = 2;

    /* renamed from: K */
    public final Rect f4375K = new Rect();

    /* renamed from: L */
    public final C0760b f4376L = new C0760b();

    /* renamed from: M */
    public boolean f4377M = false;

    /* renamed from: N */
    public boolean f4378N = true;

    /* renamed from: P */
    public final Runnable f4380P = new RunnableC0759a();

    /* renamed from: android.support.v7.widget.StaggeredGridLayoutManager$a */
    /* loaded from: classes.dex */
    public class RunnableC0759a implements Runnable {
        public RunnableC0759a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            StaggeredGridLayoutManager.this.m6475F();
        }
    }

    /* renamed from: android.support.v7.widget.StaggeredGridLayoutManager$c */
    /* loaded from: classes.dex */
    public static class C0761c extends RecyclerView.C0727p {

        /* renamed from: e */
        public C0767f f4397e;

        /* renamed from: f */
        public boolean f4398f;

        public C0761c(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }

        /* renamed from: e */
        public final int m6378e() {
            C0767f c0767f = this.f4397e;
            if (c0767f == null) {
                return -1;
            }
            return c0767f.f4419e;
        }

        /* renamed from: f */
        public boolean m6377f() {
            return this.f4398f;
        }

        public C0761c(int i, int i2) {
            super(i, i2);
        }

        public C0761c(ViewGroup.MarginLayoutParams marginLayoutParams) {
            super(marginLayoutParams);
        }

        public C0761c(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
        }
    }

    /* renamed from: android.support.v7.widget.StaggeredGridLayoutManager$e */
    /* loaded from: classes.dex */
    public static class C0765e implements Parcelable {
        public static final Parcelable.Creator<C0765e> CREATOR = new C0766a();

        /* renamed from: a */
        public int f4405a;

        /* renamed from: b */
        public int f4406b;

        /* renamed from: c */
        public int f4407c;

        /* renamed from: d */
        public int[] f4408d;

        /* renamed from: e */
        public int f4409e;

        /* renamed from: f */
        public int[] f4410f;

        /* renamed from: g */
        public List<C0762d.C0763a> f4411g;

        /* renamed from: h */
        public boolean f4412h;

        /* renamed from: i */
        public boolean f4413i;

        /* renamed from: j */
        public boolean f4414j;

        /* renamed from: android.support.v7.widget.StaggeredGridLayoutManager$e$a */
        /* loaded from: classes.dex */
        public static class C0766a implements Parcelable.Creator<C0765e> {
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public C0765e createFromParcel(Parcel parcel) {
                return new C0765e(parcel);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public C0765e[] newArray(int i) {
                return new C0765e[i];
            }
        }

        public C0765e() {
        }

        /* renamed from: a */
        public void m6360a() {
            this.f4408d = null;
            this.f4407c = 0;
            this.f4405a = -1;
            this.f4406b = -1;
        }

        /* renamed from: b */
        public void m6359b() {
            this.f4408d = null;
            this.f4407c = 0;
            this.f4409e = 0;
            this.f4410f = null;
            this.f4411g = null;
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeInt(this.f4405a);
            parcel.writeInt(this.f4406b);
            parcel.writeInt(this.f4407c);
            if (this.f4407c > 0) {
                parcel.writeIntArray(this.f4408d);
            }
            parcel.writeInt(this.f4409e);
            if (this.f4409e > 0) {
                parcel.writeIntArray(this.f4410f);
            }
            parcel.writeInt(this.f4412h ? 1 : 0);
            parcel.writeInt(this.f4413i ? 1 : 0);
            parcel.writeInt(this.f4414j ? 1 : 0);
            parcel.writeList(this.f4411g);
        }

        public C0765e(Parcel parcel) {
            this.f4405a = parcel.readInt();
            this.f4406b = parcel.readInt();
            this.f4407c = parcel.readInt();
            int i = this.f4407c;
            if (i > 0) {
                this.f4408d = new int[i];
                parcel.readIntArray(this.f4408d);
            }
            this.f4409e = parcel.readInt();
            int i2 = this.f4409e;
            if (i2 > 0) {
                this.f4410f = new int[i2];
                parcel.readIntArray(this.f4410f);
            }
            this.f4412h = parcel.readInt() == 1;
            this.f4413i = parcel.readInt() == 1;
            this.f4414j = parcel.readInt() == 1;
            this.f4411g = parcel.readArrayList(C0762d.C0763a.class.getClassLoader());
        }

        public C0765e(C0765e c0765e) {
            this.f4407c = c0765e.f4407c;
            this.f4405a = c0765e.f4405a;
            this.f4406b = c0765e.f4406b;
            this.f4408d = c0765e.f4408d;
            this.f4409e = c0765e.f4409e;
            this.f4410f = c0765e.f4410f;
            this.f4412h = c0765e.f4412h;
            this.f4413i = c0765e.f4413i;
            this.f4414j = c0765e.f4414j;
            this.f4411g = c0765e.f4411g;
        }
    }

    /* renamed from: android.support.v7.widget.StaggeredGridLayoutManager$f */
    /* loaded from: classes.dex */
    public class C0767f {

        /* renamed from: a */
        public ArrayList<View> f4415a = new ArrayList<>();

        /* renamed from: b */
        public int f4416b = Integer.MIN_VALUE;

        /* renamed from: c */
        public int f4417c = Integer.MIN_VALUE;

        /* renamed from: d */
        public int f4418d = 0;

        /* renamed from: e */
        public final int f4419e;

        public C0767f(int i) {
            this.f4419e = i;
        }

        /* renamed from: a */
        public int m6357a(int i) {
            int i2 = this.f4417c;
            if (i2 != Integer.MIN_VALUE) {
                return i2;
            }
            if (this.f4415a.size() == 0) {
                return i;
            }
            m6358a();
            return this.f4417c;
        }

        /* renamed from: b */
        public int m6350b(int i) {
            int i2 = this.f4416b;
            if (i2 != Integer.MIN_VALUE) {
                return i2;
            }
            if (this.f4415a.size() == 0) {
                return i;
            }
            m6351b();
            return this.f4416b;
        }

        /* renamed from: c */
        public void m6346c(View view) {
            C0761c m6349b = m6349b(view);
            m6349b.f4397e = this;
            this.f4415a.add(0, view);
            this.f4416b = Integer.MIN_VALUE;
            if (this.f4415a.size() == 1) {
                this.f4417c = Integer.MIN_VALUE;
            }
            if (m6349b.m6602c() || m6349b.m6603b()) {
                this.f4418d += StaggeredGridLayoutManager.this.f4383u.mo8013b(view);
            }
        }

        /* renamed from: d */
        public void m6344d(int i) {
            this.f4416b = i;
            this.f4417c = i;
        }

        /* renamed from: e */
        public int m6343e() {
            if (StaggeredGridLayoutManager.this.f4388z) {
                return m6355a(0, this.f4415a.size(), true);
            }
            return m6355a(this.f4415a.size() - 1, -1, true);
        }

        /* renamed from: f */
        public int m6342f() {
            return this.f4418d;
        }

        /* renamed from: g */
        public int m6341g() {
            int i = this.f4417c;
            if (i != Integer.MIN_VALUE) {
                return i;
            }
            m6358a();
            return this.f4417c;
        }

        /* renamed from: h */
        public int m6340h() {
            int i = this.f4416b;
            if (i != Integer.MIN_VALUE) {
                return i;
            }
            m6351b();
            return this.f4416b;
        }

        /* renamed from: i */
        public void m6339i() {
            this.f4416b = Integer.MIN_VALUE;
            this.f4417c = Integer.MIN_VALUE;
        }

        /* renamed from: j */
        public void m6338j() {
            int size = this.f4415a.size();
            View remove = this.f4415a.remove(size - 1);
            C0761c m6349b = m6349b(remove);
            m6349b.f4397e = null;
            if (m6349b.m6602c() || m6349b.m6603b()) {
                this.f4418d -= StaggeredGridLayoutManager.this.f4383u.mo8013b(remove);
            }
            if (size == 1) {
                this.f4416b = Integer.MIN_VALUE;
            }
            this.f4417c = Integer.MIN_VALUE;
        }

        /* renamed from: k */
        public void m6337k() {
            View remove = this.f4415a.remove(0);
            C0761c m6349b = m6349b(remove);
            m6349b.f4397e = null;
            if (this.f4415a.size() == 0) {
                this.f4417c = Integer.MIN_VALUE;
            }
            if (m6349b.m6602c() || m6349b.m6603b()) {
                this.f4418d -= StaggeredGridLayoutManager.this.f4383u.mo8013b(remove);
            }
            this.f4416b = Integer.MIN_VALUE;
        }

        /* renamed from: d */
        public int m6345d() {
            if (StaggeredGridLayoutManager.this.f4388z) {
                return m6355a(this.f4415a.size() - 1, -1, true);
            }
            return m6355a(0, this.f4415a.size(), true);
        }

        /* renamed from: a */
        public void m6358a() {
            C0762d.C0763a m6368c;
            ArrayList<View> arrayList = this.f4415a;
            View view = arrayList.get(arrayList.size() - 1);
            C0761c m6349b = m6349b(view);
            this.f4417c = StaggeredGridLayoutManager.this.f4383u.mo8015a(view);
            if (m6349b.f4398f && (m6368c = StaggeredGridLayoutManager.this.f4369E.m6368c(m6349b.m6604a())) != null && m6368c.f4402b == 1) {
                this.f4417c += m6368c.m6361a(this.f4419e);
            }
        }

        /* renamed from: b */
        public void m6351b() {
            C0762d.C0763a m6368c;
            View view = this.f4415a.get(0);
            C0761c m6349b = m6349b(view);
            this.f4416b = StaggeredGridLayoutManager.this.f4383u.mo8009d(view);
            if (m6349b.f4398f && (m6368c = StaggeredGridLayoutManager.this.f4369E.m6368c(m6349b.m6604a())) != null && m6368c.f4402b == -1) {
                this.f4416b -= m6368c.m6361a(this.f4419e);
            }
        }

        /* renamed from: c */
        public void m6348c() {
            this.f4415a.clear();
            m6339i();
            this.f4418d = 0;
        }

        /* renamed from: c */
        public void m6347c(int i) {
            int i2 = this.f4416b;
            if (i2 != Integer.MIN_VALUE) {
                this.f4416b = i2 + i;
            }
            int i3 = this.f4417c;
            if (i3 != Integer.MIN_VALUE) {
                this.f4417c = i3 + i;
            }
        }

        /* renamed from: a */
        public void m6353a(View view) {
            C0761c m6349b = m6349b(view);
            m6349b.f4397e = this;
            this.f4415a.add(view);
            this.f4417c = Integer.MIN_VALUE;
            if (this.f4415a.size() == 1) {
                this.f4416b = Integer.MIN_VALUE;
            }
            if (m6349b.m6602c() || m6349b.m6603b()) {
                this.f4418d += StaggeredGridLayoutManager.this.f4383u.mo8013b(view);
            }
        }

        /* renamed from: b */
        public C0761c m6349b(View view) {
            return (C0761c) view.getLayoutParams();
        }

        /* renamed from: a */
        public void m6352a(boolean z, int i) {
            int m6350b;
            if (z) {
                m6350b = m6357a(Integer.MIN_VALUE);
            } else {
                m6350b = m6350b(Integer.MIN_VALUE);
            }
            m6348c();
            if (m6350b == Integer.MIN_VALUE) {
                return;
            }
            if (!z || m6350b >= StaggeredGridLayoutManager.this.f4383u.mo8014b()) {
                if (z || m6350b <= StaggeredGridLayoutManager.this.f4383u.mo8006f()) {
                    if (i != Integer.MIN_VALUE) {
                        m6350b += i;
                    }
                    this.f4417c = m6350b;
                    this.f4416b = m6350b;
                }
            }
        }

        /* renamed from: a */
        public int m6354a(int i, int i2, boolean z, boolean z2, boolean z3) {
            int mo8006f = StaggeredGridLayoutManager.this.f4383u.mo8006f();
            int mo8014b = StaggeredGridLayoutManager.this.f4383u.mo8014b();
            int i3 = i2 > i ? 1 : -1;
            while (i != i2) {
                View view = this.f4415a.get(i);
                int mo8009d = StaggeredGridLayoutManager.this.f4383u.mo8009d(view);
                int mo8015a = StaggeredGridLayoutManager.this.f4383u.mo8015a(view);
                boolean z4 = false;
                boolean z5 = !z3 ? mo8009d >= mo8014b : mo8009d > mo8014b;
                if (!z3 ? mo8015a > mo8006f : mo8015a >= mo8006f) {
                    z4 = true;
                }
                if (z5 && z4) {
                    if (z && z2) {
                        if (mo8009d >= mo8006f && mo8015a <= mo8014b) {
                            return StaggeredGridLayoutManager.this.m6626l(view);
                        }
                    } else if (z2) {
                        return StaggeredGridLayoutManager.this.m6626l(view);
                    } else {
                        if (mo8009d < mo8006f || mo8015a > mo8014b) {
                            return StaggeredGridLayoutManager.this.m6626l(view);
                        }
                    }
                }
                i += i3;
            }
            return -1;
        }

        /* renamed from: a */
        public int m6355a(int i, int i2, boolean z) {
            return m6354a(i, i2, false, false, z);
        }

        /* renamed from: a */
        public View m6356a(int i, int i2) {
            View view = null;
            if (i2 == -1) {
                int size = this.f4415a.size();
                int i3 = 0;
                while (i3 < size) {
                    View view2 = this.f4415a.get(i3);
                    StaggeredGridLayoutManager staggeredGridLayoutManager = StaggeredGridLayoutManager.this;
                    if (staggeredGridLayoutManager.f4388z && staggeredGridLayoutManager.m6626l(view2) <= i) {
                        break;
                    }
                    StaggeredGridLayoutManager staggeredGridLayoutManager2 = StaggeredGridLayoutManager.this;
                    if ((!staggeredGridLayoutManager2.f4388z && staggeredGridLayoutManager2.m6626l(view2) >= i) || !view2.hasFocusable()) {
                        break;
                    }
                    i3++;
                    view = view2;
                }
            } else {
                int size2 = this.f4415a.size() - 1;
                while (size2 >= 0) {
                    View view3 = this.f4415a.get(size2);
                    StaggeredGridLayoutManager staggeredGridLayoutManager3 = StaggeredGridLayoutManager.this;
                    if (staggeredGridLayoutManager3.f4388z && staggeredGridLayoutManager3.m6626l(view3) >= i) {
                        break;
                    }
                    StaggeredGridLayoutManager staggeredGridLayoutManager4 = StaggeredGridLayoutManager.this;
                    if ((!staggeredGridLayoutManager4.f4388z && staggeredGridLayoutManager4.m6626l(view3) <= i) || !view3.hasFocusable()) {
                        break;
                    }
                    size2--;
                    view = view3;
                }
            }
            return view;
        }
    }

    public StaggeredGridLayoutManager(Context context, AttributeSet attributeSet, int i, int i2) {
        RecyclerView.AbstractC0722o.C0726d m6698a = RecyclerView.AbstractC0722o.m6698a(context, attributeSet, i, i2);
        m6386u(m6698a.f4264a);
        m6385v(m6698a.f4265b);
        m6417c(m6698a.f4266c);
        this.f4387y = new LayoutState();
        m6474G();
    }

    @Override // android.support.p067v7.widget.RecyclerView.AbstractC0722o
    /* renamed from: C */
    public boolean mo6478C() {
        return this.f4373I == null;
    }

    /* renamed from: D */
    public boolean m6477D() {
        int m6357a = this.f4382t[0].m6357a(Integer.MIN_VALUE);
        for (int i = 1; i < this.f4381s; i++) {
            if (this.f4382t[i].m6357a(Integer.MIN_VALUE) != m6357a) {
                return false;
            }
        }
        return true;
    }

    /* renamed from: E */
    public boolean m6476E() {
        int m6350b = this.f4382t[0].m6350b(Integer.MIN_VALUE);
        for (int i = 1; i < this.f4381s; i++) {
            if (this.f4382t[i].m6350b(Integer.MIN_VALUE) != m6350b) {
                return false;
            }
        }
        return true;
    }

    /* renamed from: F */
    public boolean m6475F() {
        int m6472I;
        int m6471J;
        if (m6644e() == 0 || this.f4370F == 0 || !m6615t()) {
            return false;
        }
        if (this.f4365A) {
            m6472I = m6471J();
            m6471J = m6472I();
        } else {
            m6472I = m6472I();
            m6471J = m6471J();
        }
        if (m6472I == 0 && m6470K() != null) {
            this.f4369E.m6376a();
            m6611z();
            m6612y();
            return true;
        } else if (this.f4377M) {
            int i = this.f4365A ? -1 : 1;
            int i2 = m6471J + 1;
            C0762d.C0763a m6373a = this.f4369E.m6373a(m6472I, i2, i, true);
            if (m6373a == null) {
                this.f4377M = false;
                this.f4369E.m6370b(i2);
                return false;
            }
            C0762d.C0763a m6373a2 = this.f4369E.m6373a(m6472I, m6373a.f4401a, i * (-1), true);
            if (m6373a2 == null) {
                this.f4369E.m6370b(m6373a.f4401a);
            } else {
                this.f4369E.m6370b(m6373a2.f4401a + 1);
            }
            m6611z();
            m6612y();
            return true;
        } else {
            return false;
        }
    }

    /* renamed from: G */
    public final void m6474G() {
        this.f4383u = OrientationHelper.m8021a(this, this.f4385w);
        this.f4384v = OrientationHelper.m8021a(this, 1 - this.f4385w);
    }

    /* renamed from: H */
    public int m6473H() {
        View m6436a = this.f4365A ? m6436a(true) : m6425b(true);
        if (m6436a == null) {
            return -1;
        }
        return m6626l(m6436a);
    }

    /* renamed from: I */
    public int m6472I() {
        if (m6644e() == 0) {
            return 0;
        }
        return m6626l(m6657c(0));
    }

    /* renamed from: J */
    public int m6471J() {
        int m6644e = m6644e();
        if (m6644e == 0) {
            return 0;
        }
        return m6626l(m6657c(m6644e - 1));
    }

    /* JADX WARN: Code restructure failed: missing block: B:31:0x0074, code lost:
        if (r10 == r11) goto L45;
     */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x0086, code lost:
        if (r10 == r11) goto L45;
     */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x0088, code lost:
        r10 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:38:0x008a, code lost:
        r10 = false;
     */
    /* renamed from: K */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public android.view.View m6470K() {
        /*
            r12 = this;
            int r0 = r12.m6644e()
            r1 = 1
            int r0 = r0 - r1
            java.util.BitSet r2 = new java.util.BitSet
            int r3 = r12.f4381s
            r2.<init>(r3)
            int r3 = r12.f4381s
            r4 = 0
            r2.set(r4, r3, r1)
            int r3 = r12.f4385w
            r5 = -1
            if (r3 != r1) goto L20
            boolean r3 = r12.m6468M()
            if (r3 == 0) goto L20
            r3 = 1
            goto L21
        L20:
            r3 = -1
        L21:
            boolean r6 = r12.f4365A
            if (r6 == 0) goto L27
            r6 = -1
            goto L2b
        L27:
            int r0 = r0 + 1
            r6 = r0
            r0 = 0
        L2b:
            if (r0 >= r6) goto L2e
            r5 = 1
        L2e:
            if (r0 == r6) goto Lab
            android.view.View r7 = r12.m6657c(r0)
            android.view.ViewGroup$LayoutParams r8 = r7.getLayoutParams()
            android.support.v7.widget.StaggeredGridLayoutManager$c r8 = (android.support.p067v7.widget.StaggeredGridLayoutManager.C0761c) r8
            android.support.v7.widget.StaggeredGridLayoutManager$f r9 = r8.f4397e
            int r9 = r9.f4419e
            boolean r9 = r2.get(r9)
            if (r9 == 0) goto L54
            android.support.v7.widget.StaggeredGridLayoutManager$f r9 = r8.f4397e
            boolean r9 = r12.m6445a(r9)
            if (r9 == 0) goto L4d
            return r7
        L4d:
            android.support.v7.widget.StaggeredGridLayoutManager$f r9 = r8.f4397e
            int r9 = r9.f4419e
            r2.clear(r9)
        L54:
            boolean r9 = r8.f4398f
            if (r9 == 0) goto L59
            goto La9
        L59:
            int r9 = r0 + r5
            if (r9 == r6) goto La9
            android.view.View r9 = r12.m6657c(r9)
            boolean r10 = r12.f4365A
            if (r10 == 0) goto L77
            a.b.h.k.w0 r10 = r12.f4383u
            int r10 = r10.mo8015a(r7)
            a.b.h.k.w0 r11 = r12.f4383u
            int r11 = r11.mo8015a(r9)
            if (r10 >= r11) goto L74
            return r7
        L74:
            if (r10 != r11) goto L8a
            goto L88
        L77:
            a.b.h.k.w0 r10 = r12.f4383u
            int r10 = r10.mo8009d(r7)
            a.b.h.k.w0 r11 = r12.f4383u
            int r11 = r11.mo8009d(r9)
            if (r10 <= r11) goto L86
            return r7
        L86:
            if (r10 != r11) goto L8a
        L88:
            r10 = 1
            goto L8b
        L8a:
            r10 = 0
        L8b:
            if (r10 == 0) goto La9
            android.view.ViewGroup$LayoutParams r9 = r9.getLayoutParams()
            android.support.v7.widget.StaggeredGridLayoutManager$c r9 = (android.support.p067v7.widget.StaggeredGridLayoutManager.C0761c) r9
            android.support.v7.widget.StaggeredGridLayoutManager$f r8 = r8.f4397e
            int r8 = r8.f4419e
            android.support.v7.widget.StaggeredGridLayoutManager$f r9 = r9.f4397e
            int r9 = r9.f4419e
            int r8 = r8 - r9
            if (r8 >= 0) goto La0
            r8 = 1
            goto La1
        La0:
            r8 = 0
        La1:
            if (r3 >= 0) goto La5
            r9 = 1
            goto La6
        La5:
            r9 = 0
        La6:
            if (r8 == r9) goto La9
            return r7
        La9:
            int r0 = r0 + r5
            goto L2e
        Lab:
            r0 = 0
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.p067v7.widget.StaggeredGridLayoutManager.m6470K():android.view.View");
    }

    /* renamed from: L */
    public void m6469L() {
        this.f4369E.m6376a();
        m6612y();
    }

    /* renamed from: M */
    public boolean m6468M() {
        return m6631j() == 1;
    }

    /* renamed from: N */
    public final void m6467N() {
        if (this.f4384v.mo8010d() == 1073741824) {
            return;
        }
        int m6644e = m6644e();
        float f = 0.0f;
        for (int i = 0; i < m6644e; i++) {
            View m6657c = m6657c(i);
            float mo8013b = this.f4384v.mo8013b(m6657c);
            if (mo8013b >= f) {
                if (((C0761c) m6657c.getLayoutParams()).m6377f()) {
                    mo8013b = (mo8013b * 1.0f) / this.f4381s;
                }
                f = Math.max(f, mo8013b);
            }
        }
        int i2 = this.f4386x;
        int round = Math.round(f * this.f4381s);
        if (this.f4384v.mo8010d() == Integer.MIN_VALUE) {
            round = Math.min(round, this.f4384v.mo8004g());
        }
        m6384w(round);
        if (this.f4386x == i2) {
            return;
        }
        for (int i3 = 0; i3 < m6644e; i3++) {
            View m6657c2 = m6657c(i3);
            C0761c c0761c = (C0761c) m6657c2.getLayoutParams();
            if (!c0761c.f4398f) {
                if (m6468M() && this.f4385w == 1) {
                    int i4 = this.f4381s;
                    int i5 = c0761c.f4397e.f4419e;
                    m6657c2.offsetLeftAndRight(((-((i4 - 1) - i5)) * this.f4386x) - ((-((i4 - 1) - i5)) * i2));
                } else {
                    int i6 = c0761c.f4397e.f4419e;
                    int i7 = this.f4386x * i6;
                    int i8 = i6 * i2;
                    if (this.f4385w == 1) {
                        m6657c2.offsetLeftAndRight(i7 - i8);
                    } else {
                        m6657c2.offsetTopAndBottom(i7 - i8);
                    }
                }
            }
        }
    }

    /* renamed from: O */
    public final void m6466O() {
        if (this.f4385w != 1 && m6468M()) {
            this.f4365A = !this.f4388z;
        } else {
            this.f4365A = this.f4388z;
        }
    }

    /* renamed from: a */
    public final boolean m6445a(C0767f c0767f) {
        if (this.f4365A) {
            if (c0767f.m6341g() < this.f4383u.mo8014b()) {
                ArrayList<View> arrayList = c0767f.f4415a;
                return !c0767f.m6349b(arrayList.get(arrayList.size() - 1)).f4398f;
            }
        } else if (c0767f.m6340h() > this.f4383u.mo8006f()) {
            return !c0767f.m6349b(c0767f.f4415a.get(0)).f4398f;
        }
        return false;
    }

    @Override // android.support.p067v7.widget.RecyclerView.AbstractC0722o
    /* renamed from: b */
    public void mo6426b(RecyclerView recyclerView, RecyclerView.C0734v c0734v) {
        super.mo6426b(recyclerView, c0734v);
        m6668a(this.f4380P);
        for (int i = 0; i < this.f4381s; i++) {
            this.f4382t[i].m6348c();
        }
        recyclerView.requestLayout();
    }

    /* renamed from: c */
    public void m6417c(boolean z) {
        mo6437a((String) null);
        C0765e c0765e = this.f4373I;
        if (c0765e != null && c0765e.f4412h != z) {
            c0765e.f4412h = z;
        }
        this.f4388z = z;
        m6612y();
    }

    @Override // android.support.p067v7.widget.RecyclerView.AbstractC0722o
    /* renamed from: d */
    public int mo6414d(RecyclerView.C0702a0 c0702a0) {
        return m6404h(c0702a0);
    }

    @Override // android.support.p067v7.widget.RecyclerView.AbstractC0722o
    /* renamed from: e */
    public void mo6409e(RecyclerView.C0734v c0734v, RecyclerView.C0702a0 c0702a0) {
        m6419c(c0734v, c0702a0, true);
    }

    @Override // android.support.p067v7.widget.RecyclerView.AbstractC0722o
    /* renamed from: f */
    public void mo6408f(int i) {
        if (i == 0) {
            m6475F();
        }
    }

    @Override // android.support.p067v7.widget.RecyclerView.AbstractC0722o
    /* renamed from: g */
    public void mo6406g(RecyclerView.C0702a0 c0702a0) {
        super.mo6406g(c0702a0);
        this.f4367C = -1;
        this.f4368D = Integer.MIN_VALUE;
        this.f4373I = null;
        this.f4376L.m6379b();
    }

    /* renamed from: h */
    public final int m6404h(RecyclerView.C0702a0 c0702a0) {
        if (m6644e() == 0) {
            return 0;
        }
        return ScrollbarHelper.m8481a(c0702a0, this.f4383u, m6425b(!this.f4378N), m6436a(!this.f4378N), this, this.f4378N);
    }

    /* renamed from: i */
    public final int m6402i(RecyclerView.C0702a0 c0702a0) {
        if (m6644e() == 0) {
            return 0;
        }
        return ScrollbarHelper.m8480a(c0702a0, this.f4383u, m6425b(!this.f4378N), m6436a(!this.f4378N), this, this.f4378N, this.f4365A);
    }

    /* renamed from: j */
    public final int m6400j(RecyclerView.C0702a0 c0702a0) {
        if (m6644e() == 0) {
            return 0;
        }
        return ScrollbarHelper.m8479b(c0702a0, this.f4383u, m6425b(!this.f4378N), m6436a(!this.f4378N), this, this.f4378N);
    }

    /* renamed from: k */
    public final C0762d.C0763a m6399k(int i) {
        C0762d.C0763a c0763a = new C0762d.C0763a();
        c0763a.f4403c = new int[this.f4381s];
        for (int i2 = 0; i2 < this.f4381s; i2++) {
            c0763a.f4403c[i2] = i - this.f4382t[i2].m6357a(i);
        }
        return c0763a;
    }

    /* renamed from: l */
    public final C0762d.C0763a m6398l(int i) {
        C0762d.C0763a c0763a = new C0762d.C0763a();
        c0763a.f4403c = new int[this.f4381s];
        for (int i2 = 0; i2 < this.f4381s; i2++) {
            c0763a.f4403c[i2] = this.f4382t[i2].m6350b(i) - i;
        }
        return c0763a;
    }

    /* renamed from: m */
    public final int m6397m(int i) {
        int m6644e = m6644e();
        for (int i2 = 0; i2 < m6644e; i2++) {
            int m6626l = m6626l(m6657c(i2));
            if (m6626l >= 0 && m6626l < i) {
                return m6626l;
            }
        }
        return 0;
    }

    /* renamed from: n */
    public final int m6396n(int i) {
        for (int m6644e = m6644e() - 1; m6644e >= 0; m6644e--) {
            int m6626l = m6626l(m6657c(m6644e));
            if (m6626l >= 0 && m6626l < i) {
                return m6626l;
            }
        }
        return 0;
    }

    /* renamed from: o */
    public final int m6395o(int i) {
        int m6357a = this.f4382t[0].m6357a(i);
        for (int i2 = 1; i2 < this.f4381s; i2++) {
            int m6357a2 = this.f4382t[i2].m6357a(i);
            if (m6357a2 > m6357a) {
                m6357a = m6357a2;
            }
        }
        return m6357a;
    }

    /* renamed from: p */
    public final void m6393p(View view) {
        for (int i = this.f4381s - 1; i >= 0; i--) {
            this.f4382t[i].m6353a(view);
        }
    }

    /* renamed from: q */
    public final void m6391q(View view) {
        for (int i = this.f4381s - 1; i >= 0; i--) {
            this.f4382t[i].m6346c(view);
        }
    }

    /* renamed from: r */
    public final int m6390r(int i) {
        int m6350b = this.f4382t[0].m6350b(i);
        for (int i2 = 1; i2 < this.f4381s; i2++) {
            int m6350b2 = this.f4382t[i2].m6350b(i);
            if (m6350b2 < m6350b) {
                m6350b = m6350b2;
            }
        }
        return m6350b;
    }

    /* renamed from: s */
    public final boolean m6389s(int i) {
        if (this.f4385w == 0) {
            return (i == -1) != this.f4365A;
        }
        return ((i == -1) == this.f4365A) == m6468M();
    }

    /* renamed from: t */
    public final void m6388t(int i) {
        LayoutState layoutState = this.f4387y;
        layoutState.f2875e = i;
        layoutState.f2874d = this.f4365A != (i == -1) ? -1 : 1;
    }

    @Override // android.support.p067v7.widget.RecyclerView.AbstractC0722o
    /* renamed from: u */
    public boolean mo6387u() {
        return this.f4370F != 0;
    }

    /* renamed from: v */
    public void m6385v(int i) {
        mo6437a((String) null);
        if (i != this.f4381s) {
            m6469L();
            this.f4381s = i;
            this.f4366B = new BitSet(this.f4381s);
            this.f4382t = new C0767f[this.f4381s];
            for (int i2 = 0; i2 < this.f4381s; i2++) {
                this.f4382t[i2] = new C0767f(i2);
            }
            m6612y();
        }
    }

    /* renamed from: w */
    public void m6384w(int i) {
        this.f4386x = i / this.f4381s;
        this.f4374J = View.MeasureSpec.makeMeasureSpec(i, this.f4384v.mo8010d());
    }

    @Override // android.support.p067v7.widget.RecyclerView.AbstractC0722o
    /* renamed from: x */
    public Parcelable mo6383x() {
        int m6350b;
        int mo8006f;
        int[] iArr;
        C0765e c0765e = this.f4373I;
        if (c0765e != null) {
            return new C0765e(c0765e);
        }
        C0765e c0765e2 = new C0765e();
        c0765e2.f4412h = this.f4388z;
        c0765e2.f4413i = this.f4371G;
        c0765e2.f4414j = this.f4372H;
        C0762d c0762d = this.f4369E;
        if (c0762d != null && (iArr = c0762d.f4399a) != null) {
            c0765e2.f4410f = iArr;
            c0765e2.f4409e = c0765e2.f4410f.length;
            c0765e2.f4411g = c0762d.f4400b;
        } else {
            c0765e2.f4409e = 0;
        }
        if (m6644e() > 0) {
            c0765e2.f4405a = this.f4371G ? m6471J() : m6472I();
            c0765e2.f4406b = m6473H();
            int i = this.f4381s;
            c0765e2.f4407c = i;
            c0765e2.f4408d = new int[i];
            for (int i2 = 0; i2 < this.f4381s; i2++) {
                if (this.f4371G) {
                    m6350b = this.f4382t[i2].m6357a(Integer.MIN_VALUE);
                    if (m6350b != Integer.MIN_VALUE) {
                        mo8006f = this.f4383u.mo8014b();
                        m6350b -= mo8006f;
                        c0765e2.f4408d[i2] = m6350b;
                    } else {
                        c0765e2.f4408d[i2] = m6350b;
                    }
                } else {
                    m6350b = this.f4382t[i2].m6350b(Integer.MIN_VALUE);
                    if (m6350b != Integer.MIN_VALUE) {
                        mo8006f = this.f4383u.mo8006f();
                        m6350b -= mo8006f;
                        c0765e2.f4408d[i2] = m6350b;
                    } else {
                        c0765e2.f4408d[i2] = m6350b;
                    }
                }
            }
        } else {
            c0765e2.f4405a = -1;
            c0765e2.f4406b = -1;
            c0765e2.f4407c = 0;
        }
        return c0765e2;
    }

    /* renamed from: android.support.v7.widget.StaggeredGridLayoutManager$d */
    /* loaded from: classes.dex */
    public static class C0762d {

        /* renamed from: a */
        public int[] f4399a;

        /* renamed from: b */
        public List<C0763a> f4400b;

        /* renamed from: a */
        public void m6372a(int i, C0767f c0767f) {
            m6375a(i);
            this.f4399a[i] = c0767f.f4419e;
        }

        /* renamed from: b */
        public int m6370b(int i) {
            List<C0763a> list = this.f4400b;
            if (list != null) {
                for (int size = list.size() - 1; size >= 0; size--) {
                    if (this.f4400b.get(size).f4401a >= i) {
                        this.f4400b.remove(size);
                    }
                }
            }
            return m6364e(i);
        }

        /* renamed from: c */
        public final void m6367c(int i, int i2) {
            List<C0763a> list = this.f4400b;
            if (list == null) {
                return;
            }
            for (int size = list.size() - 1; size >= 0; size--) {
                C0763a c0763a = this.f4400b.get(size);
                int i3 = c0763a.f4401a;
                if (i3 >= i) {
                    c0763a.f4401a = i3 + i2;
                }
            }
        }

        /* renamed from: d */
        public int m6366d(int i) {
            int[] iArr = this.f4399a;
            if (iArr == null || i >= iArr.length) {
                return -1;
            }
            return iArr[i];
        }

        /* renamed from: e */
        public int m6364e(int i) {
            int[] iArr = this.f4399a;
            if (iArr != null && i < iArr.length) {
                int m6363f = m6363f(i);
                if (m6363f == -1) {
                    int[] iArr2 = this.f4399a;
                    Arrays.fill(iArr2, i, iArr2.length, -1);
                    return this.f4399a.length;
                }
                int i2 = m6363f + 1;
                Arrays.fill(this.f4399a, i, i2, -1);
                return i2;
            }
            return -1;
        }

        /* renamed from: f */
        public final int m6363f(int i) {
            if (this.f4400b == null) {
                return -1;
            }
            C0763a m6368c = m6368c(i);
            if (m6368c != null) {
                this.f4400b.remove(m6368c);
            }
            int size = this.f4400b.size();
            int i2 = 0;
            while (true) {
                if (i2 >= size) {
                    i2 = -1;
                    break;
                } else if (this.f4400b.get(i2).f4401a >= i) {
                    break;
                } else {
                    i2++;
                }
            }
            if (i2 != -1) {
                this.f4400b.remove(i2);
                return this.f4400b.get(i2).f4401a;
            }
            return -1;
        }

        /* renamed from: g */
        public int m6362g(int i) {
            int length = this.f4399a.length;
            while (length <= i) {
                length *= 2;
            }
            return length;
        }

        /* renamed from: a */
        public void m6375a(int i) {
            int[] iArr = this.f4399a;
            if (iArr == null) {
                this.f4399a = new int[Math.max(i, 10) + 1];
                Arrays.fill(this.f4399a, -1);
            } else if (i >= iArr.length) {
                this.f4399a = new int[m6362g(i)];
                System.arraycopy(iArr, 0, this.f4399a, 0, iArr.length);
                int[] iArr2 = this.f4399a;
                Arrays.fill(iArr2, iArr.length, iArr2.length, -1);
            }
        }

        /* renamed from: d */
        public final void m6365d(int i, int i2) {
            List<C0763a> list = this.f4400b;
            if (list == null) {
                return;
            }
            int i3 = i + i2;
            for (int size = list.size() - 1; size >= 0; size--) {
                C0763a c0763a = this.f4400b.get(size);
                int i4 = c0763a.f4401a;
                if (i4 >= i) {
                    if (i4 < i3) {
                        this.f4400b.remove(size);
                    } else {
                        c0763a.f4401a = i4 - i2;
                    }
                }
            }
        }

        /* renamed from: c */
        public C0763a m6368c(int i) {
            List<C0763a> list = this.f4400b;
            if (list == null) {
                return null;
            }
            for (int size = list.size() - 1; size >= 0; size--) {
                C0763a c0763a = this.f4400b.get(size);
                if (c0763a.f4401a == i) {
                    return c0763a;
                }
            }
            return null;
        }

        /* renamed from: android.support.v7.widget.StaggeredGridLayoutManager$d$a */
        /* loaded from: classes.dex */
        public static class C0763a implements Parcelable {
            public static final Parcelable.Creator<C0763a> CREATOR = new C0764a();

            /* renamed from: a */
            public int f4401a;

            /* renamed from: b */
            public int f4402b;

            /* renamed from: c */
            public int[] f4403c;

            /* renamed from: d */
            public boolean f4404d;

            /* renamed from: android.support.v7.widget.StaggeredGridLayoutManager$d$a$a */
            /* loaded from: classes.dex */
            public static class C0764a implements Parcelable.Creator<C0763a> {
                /* JADX WARN: Can't rename method to resolve collision */
                @Override // android.os.Parcelable.Creator
                public C0763a createFromParcel(Parcel parcel) {
                    return new C0763a(parcel);
                }

                /* JADX WARN: Can't rename method to resolve collision */
                @Override // android.os.Parcelable.Creator
                public C0763a[] newArray(int i) {
                    return new C0763a[i];
                }
            }

            public C0763a(Parcel parcel) {
                this.f4401a = parcel.readInt();
                this.f4402b = parcel.readInt();
                this.f4404d = parcel.readInt() == 1;
                int readInt = parcel.readInt();
                if (readInt > 0) {
                    this.f4403c = new int[readInt];
                    parcel.readIntArray(this.f4403c);
                }
            }

            /* renamed from: a */
            public int m6361a(int i) {
                int[] iArr = this.f4403c;
                if (iArr == null) {
                    return 0;
                }
                return iArr[i];
            }

            @Override // android.os.Parcelable
            public int describeContents() {
                return 0;
            }

            public String toString() {
                return "FullSpanItem{mPosition=" + this.f4401a + ", mGapDir=" + this.f4402b + ", mHasUnwantedGapAfter=" + this.f4404d + ", mGapPerSpan=" + Arrays.toString(this.f4403c) + '}';
            }

            @Override // android.os.Parcelable
            public void writeToParcel(Parcel parcel, int i) {
                parcel.writeInt(this.f4401a);
                parcel.writeInt(this.f4402b);
                parcel.writeInt(this.f4404d ? 1 : 0);
                int[] iArr = this.f4403c;
                if (iArr != null && iArr.length > 0) {
                    parcel.writeInt(iArr.length);
                    parcel.writeIntArray(this.f4403c);
                    return;
                }
                parcel.writeInt(0);
            }

            public C0763a() {
            }
        }

        /* renamed from: b */
        public void m6369b(int i, int i2) {
            int[] iArr = this.f4399a;
            if (iArr == null || i >= iArr.length) {
                return;
            }
            int i3 = i + i2;
            m6375a(i3);
            int[] iArr2 = this.f4399a;
            System.arraycopy(iArr2, i3, iArr2, i, (iArr2.length - i) - i2);
            int[] iArr3 = this.f4399a;
            Arrays.fill(iArr3, iArr3.length - i2, iArr3.length, -1);
            m6365d(i, i2);
        }

        /* renamed from: a */
        public void m6376a() {
            int[] iArr = this.f4399a;
            if (iArr != null) {
                Arrays.fill(iArr, -1);
            }
            this.f4400b = null;
        }

        /* renamed from: a */
        public void m6374a(int i, int i2) {
            int[] iArr = this.f4399a;
            if (iArr == null || i >= iArr.length) {
                return;
            }
            int i3 = i + i2;
            m6375a(i3);
            int[] iArr2 = this.f4399a;
            System.arraycopy(iArr2, i, iArr2, i3, (iArr2.length - i) - i2);
            Arrays.fill(this.f4399a, i, i3, -1);
            m6367c(i, i2);
        }

        /* renamed from: a */
        public void m6371a(C0763a c0763a) {
            if (this.f4400b == null) {
                this.f4400b = new ArrayList();
            }
            int size = this.f4400b.size();
            for (int i = 0; i < size; i++) {
                C0763a c0763a2 = this.f4400b.get(i);
                if (c0763a2.f4401a == c0763a.f4401a) {
                    this.f4400b.remove(i);
                }
                if (c0763a2.f4401a >= c0763a.f4401a) {
                    this.f4400b.add(i, c0763a);
                    return;
                }
            }
            this.f4400b.add(c0763a);
        }

        /* renamed from: a */
        public C0763a m6373a(int i, int i2, int i3, boolean z) {
            List<C0763a> list = this.f4400b;
            if (list == null) {
                return null;
            }
            int size = list.size();
            for (int i4 = 0; i4 < size; i4++) {
                C0763a c0763a = this.f4400b.get(i4);
                int i5 = c0763a.f4401a;
                if (i5 >= i2) {
                    return null;
                }
                if (i5 >= i && (i3 == 0 || c0763a.f4402b == i3 || (z && c0763a.f4404d))) {
                    return c0763a;
                }
            }
            return null;
        }
    }

    /* renamed from: d */
    public final int m6415d(int i, int i2, int i3) {
        if (i2 == 0 && i3 == 0) {
            return i;
        }
        int mode = View.MeasureSpec.getMode(i);
        return (mode == Integer.MIN_VALUE || mode == 1073741824) ? View.MeasureSpec.makeMeasureSpec(Math.max(0, (View.MeasureSpec.getSize(i) - i2) - i3), mode) : i;
    }

    @Override // android.support.p067v7.widget.RecyclerView.AbstractC0722o
    /* renamed from: e */
    public int mo6410e(RecyclerView.C0702a0 c0702a0) {
        return m6402i(c0702a0);
    }

    @Override // android.support.p067v7.widget.RecyclerView.AbstractC0722o
    /* renamed from: f */
    public int mo6407f(RecyclerView.C0702a0 c0702a0) {
        return m6400j(c0702a0);
    }

    /* renamed from: u */
    public void m6386u(int i) {
        if (i != 0 && i != 1) {
            throw new IllegalArgumentException("invalid orientation.");
        }
        mo6437a((String) null);
        if (i == this.f4385w) {
            return;
        }
        this.f4385w = i;
        OrientationHelper orientationHelper = this.f4383u;
        this.f4383u = this.f4384v;
        this.f4384v = orientationHelper;
        m6612y();
    }

    @Override // android.support.p067v7.widget.RecyclerView.AbstractC0722o
    /* renamed from: e */
    public void mo6412e(int i) {
        super.mo6412e(i);
        for (int i2 = 0; i2 < this.f4381s; i2++) {
            this.f4382t[i2].m6347c(i);
        }
    }

    /* renamed from: p */
    public final int m6394p(int i) {
        int m6350b = this.f4382t[0].m6350b(i);
        for (int i2 = 1; i2 < this.f4381s; i2++) {
            int m6350b2 = this.f4382t[i2].m6350b(i);
            if (m6350b2 > m6350b) {
                m6350b = m6350b2;
            }
        }
        return m6350b;
    }

    /* renamed from: q */
    public final int m6392q(int i) {
        int m6357a = this.f4382t[0].m6357a(i);
        for (int i2 = 1; i2 < this.f4381s; i2++) {
            int m6357a2 = this.f4382t[i2].m6357a(i);
            if (m6357a2 < m6357a) {
                m6357a = m6357a2;
            }
        }
        return m6357a;
    }

    /* renamed from: android.support.v7.widget.StaggeredGridLayoutManager$b */
    /* loaded from: classes.dex */
    public class C0760b {

        /* renamed from: a */
        public int f4390a;

        /* renamed from: b */
        public int f4391b;

        /* renamed from: c */
        public boolean f4392c;

        /* renamed from: d */
        public boolean f4393d;

        /* renamed from: e */
        public boolean f4394e;

        /* renamed from: f */
        public int[] f4395f;

        public C0760b() {
            m6379b();
        }

        /* renamed from: a */
        public void m6380a(C0767f[] c0767fArr) {
            int length = c0767fArr.length;
            int[] iArr = this.f4395f;
            if (iArr == null || iArr.length < length) {
                this.f4395f = new int[StaggeredGridLayoutManager.this.f4382t.length];
            }
            for (int i = 0; i < length; i++) {
                this.f4395f[i] = c0767fArr[i].m6350b(Integer.MIN_VALUE);
            }
        }

        /* renamed from: b */
        public void m6379b() {
            this.f4390a = -1;
            this.f4391b = Integer.MIN_VALUE;
            this.f4392c = false;
            this.f4393d = false;
            this.f4394e = false;
            int[] iArr = this.f4395f;
            if (iArr != null) {
                Arrays.fill(iArr, -1);
            }
        }

        /* renamed from: a */
        public void m6382a() {
            this.f4391b = this.f4392c ? StaggeredGridLayoutManager.this.f4383u.mo8014b() : StaggeredGridLayoutManager.this.f4383u.mo8006f();
        }

        /* renamed from: a */
        public void m6381a(int i) {
            if (this.f4392c) {
                this.f4391b = StaggeredGridLayoutManager.this.f4383u.mo8014b() - i;
            } else {
                this.f4391b = StaggeredGridLayoutManager.this.f4383u.mo8006f() + i;
            }
        }
    }

    @Override // android.support.p067v7.widget.RecyclerView.AbstractC0722o
    /* renamed from: d */
    public void mo6416d(int i) {
        super.mo6416d(i);
        for (int i2 = 0; i2 < this.f4381s; i2++) {
            this.f4382t[i2].m6347c(i);
        }
    }

    /* renamed from: b */
    public boolean m6431b(RecyclerView.C0702a0 c0702a0, C0760b c0760b) {
        int i;
        int mo8006f;
        if (!c0702a0.m6841d() && (i = this.f4367C) != -1) {
            if (i >= 0 && i < c0702a0.m6846a()) {
                C0765e c0765e = this.f4373I;
                if (c0765e != null && c0765e.f4405a != -1 && c0765e.f4407c >= 1) {
                    c0760b.f4391b = Integer.MIN_VALUE;
                    c0760b.f4390a = this.f4367C;
                } else {
                    View mo6667b = mo6667b(this.f4367C);
                    if (mo6667b != null) {
                        c0760b.f4390a = this.f4365A ? m6471J() : m6472I();
                        if (this.f4368D != Integer.MIN_VALUE) {
                            if (c0760b.f4392c) {
                                c0760b.f4391b = (this.f4383u.mo8014b() - this.f4368D) - this.f4383u.mo8015a(mo6667b);
                            } else {
                                c0760b.f4391b = (this.f4383u.mo8006f() + this.f4368D) - this.f4383u.mo8009d(mo6667b);
                            }
                            return true;
                        } else if (this.f4383u.mo8013b(mo6667b) > this.f4383u.mo8004g()) {
                            if (c0760b.f4392c) {
                                mo8006f = this.f4383u.mo8014b();
                            } else {
                                mo8006f = this.f4383u.mo8006f();
                            }
                            c0760b.f4391b = mo8006f;
                            return true;
                        } else {
                            int mo8009d = this.f4383u.mo8009d(mo6667b) - this.f4383u.mo8006f();
                            if (mo8009d < 0) {
                                c0760b.f4391b = -mo8009d;
                                return true;
                            }
                            int mo8014b = this.f4383u.mo8014b() - this.f4383u.mo8015a(mo6667b);
                            if (mo8014b < 0) {
                                c0760b.f4391b = mo8014b;
                                return true;
                            }
                            c0760b.f4391b = Integer.MIN_VALUE;
                        }
                    } else {
                        c0760b.f4390a = this.f4367C;
                        int i2 = this.f4368D;
                        if (i2 == Integer.MIN_VALUE) {
                            c0760b.f4392c = m6403i(c0760b.f4390a) == 1;
                            c0760b.m6382a();
                        } else {
                            c0760b.m6381a(i2);
                        }
                        c0760b.f4393d = true;
                    }
                }
                return true;
            }
            this.f4367C = -1;
            this.f4368D = Integer.MIN_VALUE;
        }
        return false;
    }

    /* JADX WARN: Code restructure failed: missing block: B:87:0x0157, code lost:
        if (m6475F() != false) goto L83;
     */
    /* renamed from: c */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void m6419c(android.support.p067v7.widget.RecyclerView.C0734v r9, android.support.p067v7.widget.RecyclerView.C0702a0 r10, boolean r11) {
        /*
            Method dump skipped, instructions count: 379
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.p067v7.widget.StaggeredGridLayoutManager.m6419c(android.support.v7.widget.RecyclerView$v, android.support.v7.widget.RecyclerView$a0, boolean):void");
    }

    /* renamed from: e */
    public final void m6411e(int i, int i2) {
        for (int i3 = 0; i3 < this.f4381s; i3++) {
            if (!this.f4382t[i3].f4415a.isEmpty()) {
                m6444a(this.f4382t[i3], i, i2);
            }
        }
    }

    @Override // android.support.p067v7.widget.RecyclerView.AbstractC0722o
    /* renamed from: h */
    public void mo6405h(int i) {
        C0765e c0765e = this.f4373I;
        if (c0765e != null && c0765e.f4405a != i) {
            c0765e.m6360a();
        }
        this.f4367C = i;
        this.f4368D = Integer.MIN_VALUE;
        m6612y();
    }

    /* renamed from: i */
    public final int m6403i(int i) {
        if (m6644e() == 0) {
            return this.f4365A ? 1 : -1;
        }
        return (i < m6472I()) != this.f4365A ? -1 : 1;
    }

    /* renamed from: j */
    public final int m6401j(int i) {
        return i != 1 ? i != 2 ? i != 17 ? i != 33 ? i != 66 ? (i == 130 && this.f4385w == 1) ? 1 : Integer.MIN_VALUE : this.f4385w == 0 ? 1 : Integer.MIN_VALUE : this.f4385w == 1 ? -1 : Integer.MIN_VALUE : this.f4385w == 0 ? -1 : Integer.MIN_VALUE : (this.f4385w != 1 && m6468M()) ? -1 : 1 : (this.f4385w != 1 && m6468M()) ? 1 : -1;
    }

    @Override // android.support.p067v7.widget.RecyclerView.AbstractC0722o
    /* renamed from: d */
    public void mo6413d(RecyclerView recyclerView) {
        this.f4369E.m6376a();
        m6612y();
    }

    @Override // android.support.p067v7.widget.RecyclerView.AbstractC0722o
    /* renamed from: a */
    public void mo6437a(String str) {
        if (this.f4373I == null) {
            super.mo6437a(str);
        }
    }

    @Override // android.support.p067v7.widget.RecyclerView.AbstractC0722o
    /* renamed from: a */
    public void mo6459a(Rect rect, int i, int i2) {
        int m6705a;
        int m6705a2;
        int m6623n = m6623n() + m6621o();
        int m6619p = m6619p() + m6625m();
        if (this.f4385w == 1) {
            m6705a2 = RecyclerView.AbstractC0722o.m6705a(i2, rect.height() + m6619p, m6629k());
            m6705a = RecyclerView.AbstractC0722o.m6705a(i, (this.f4386x * this.f4381s) + m6623n, m6627l());
        } else {
            m6705a = RecyclerView.AbstractC0722o.m6705a(i, rect.width() + m6623n, m6627l());
            m6705a2 = RecyclerView.AbstractC0722o.m6705a(i2, (this.f4386x * this.f4381s) + m6619p, m6629k());
        }
        m6656c(m6705a, m6705a2);
    }

    /* renamed from: a */
    public final void m6446a(C0760b c0760b) {
        int mo8006f;
        C0765e c0765e = this.f4373I;
        int i = c0765e.f4407c;
        if (i > 0) {
            if (i == this.f4381s) {
                for (int i2 = 0; i2 < this.f4381s; i2++) {
                    this.f4382t[i2].m6348c();
                    C0765e c0765e2 = this.f4373I;
                    int i3 = c0765e2.f4408d[i2];
                    if (i3 != Integer.MIN_VALUE) {
                        if (c0765e2.f4413i) {
                            mo8006f = this.f4383u.mo8014b();
                        } else {
                            mo8006f = this.f4383u.mo8006f();
                        }
                        i3 += mo8006f;
                    }
                    this.f4382t[i2].m6344d(i3);
                }
            } else {
                c0765e.m6359b();
                C0765e c0765e3 = this.f4373I;
                c0765e3.f4405a = c0765e3.f4406b;
            }
        }
        C0765e c0765e4 = this.f4373I;
        this.f4372H = c0765e4.f4414j;
        m6417c(c0765e4.f4412h);
        m6466O();
        C0765e c0765e5 = this.f4373I;
        int i4 = c0765e5.f4405a;
        if (i4 != -1) {
            this.f4367C = i4;
            c0760b.f4392c = c0765e5.f4413i;
        } else {
            c0760b.f4392c = this.f4365A;
        }
        C0765e c0765e6 = this.f4373I;
        if (c0765e6.f4409e > 1) {
            C0762d c0762d = this.f4369E;
            c0762d.f4399a = c0765e6.f4410f;
            c0762d.f4400b = c0765e6.f4411g;
        }
    }

    @Override // android.support.p067v7.widget.RecyclerView.AbstractC0722o
    /* renamed from: b */
    public int mo6432b(RecyclerView.C0702a0 c0702a0) {
        return m6402i(c0702a0);
    }

    @Override // android.support.p067v7.widget.RecyclerView.AbstractC0722o
    /* renamed from: b */
    public int mo6429b(RecyclerView.C0734v c0734v, RecyclerView.C0702a0 c0702a0) {
        if (this.f4385w == 0) {
            return this.f4381s;
        }
        return super.mo6429b(c0734v, c0702a0);
    }

    /* renamed from: b */
    public View m6425b(boolean z) {
        int mo8006f = this.f4383u.mo8006f();
        int mo8014b = this.f4383u.mo8014b();
        int m6644e = m6644e();
        View view = null;
        for (int i = 0; i < m6644e; i++) {
            View m6657c = m6657c(i);
            int mo8009d = this.f4383u.mo8009d(m6657c);
            if (this.f4383u.mo8015a(m6657c) > mo8006f && mo8009d < mo8014b) {
                if (mo8009d >= mo8006f || !z) {
                    return m6657c;
                }
                if (view == null) {
                    view = m6657c;
                }
            }
        }
        return view;
    }

    /* renamed from: a */
    public final boolean m6456a(RecyclerView.C0702a0 c0702a0, C0760b c0760b) {
        int m6397m;
        if (this.f4371G) {
            m6397m = m6396n(c0702a0.m6846a());
        } else {
            m6397m = m6397m(c0702a0.m6846a());
        }
        c0760b.f4390a = m6397m;
        c0760b.f4391b = Integer.MIN_VALUE;
        return true;
    }

    @Override // android.support.p067v7.widget.RecyclerView.AbstractC0722o
    /* renamed from: a */
    public int mo6457a(RecyclerView.C0702a0 c0702a0) {
        return m6404h(c0702a0);
    }

    /* renamed from: b */
    public final void m6428b(RecyclerView.C0734v c0734v, RecyclerView.C0702a0 c0702a0, boolean z) {
        int mo8006f;
        int m6390r = m6390r(Integer.MAX_VALUE);
        if (m6390r != Integer.MAX_VALUE && (mo8006f = m6390r - this.f4383u.mo8006f()) > 0) {
            int m6422c = mo8006f - m6422c(mo8006f, c0734v, c0702a0);
            if (!z || m6422c <= 0) {
                return;
            }
            this.f4383u.mo8016a(-m6422c);
        }
    }

    /* renamed from: a */
    public final void m6440a(View view, C0761c c0761c, boolean z) {
        if (c0761c.f4398f) {
            if (this.f4385w == 1) {
                m6443a(view, this.f4374J, RecyclerView.AbstractC0722o.m6704a(m6635h(), m6633i(), m6619p() + m6625m(), ((ViewGroup.MarginLayoutParams) c0761c).height, true), z);
            } else {
                m6443a(view, RecyclerView.AbstractC0722o.m6704a(m6618q(), m6617r(), m6623n() + m6621o(), ((ViewGroup.MarginLayoutParams) c0761c).width, true), this.f4374J, z);
            }
        } else if (this.f4385w == 1) {
            m6443a(view, RecyclerView.AbstractC0722o.m6704a(this.f4386x, m6617r(), 0, ((ViewGroup.MarginLayoutParams) c0761c).width, false), RecyclerView.AbstractC0722o.m6704a(m6635h(), m6633i(), m6619p() + m6625m(), ((ViewGroup.MarginLayoutParams) c0761c).height, true), z);
        } else {
            m6443a(view, RecyclerView.AbstractC0722o.m6704a(m6618q(), m6617r(), m6623n() + m6621o(), ((ViewGroup.MarginLayoutParams) c0761c).width, true), RecyclerView.AbstractC0722o.m6704a(this.f4386x, m6633i(), 0, ((ViewGroup.MarginLayoutParams) c0761c).height, false), z);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x0036  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x004d  */
    /* renamed from: b */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void m6434b(int r5, android.support.p067v7.widget.RecyclerView.C0702a0 r6) {
        /*
            r4 = this;
            a.b.h.k.q0 r0 = r4.f4387y
            r1 = 0
            r0.f2872b = r1
            r0.f2873c = r5
            boolean r0 = r4.m6613w()
            r2 = 1
            if (r0 == 0) goto L2e
            int r6 = r6.m6843b()
            r0 = -1
            if (r6 == r0) goto L2e
            boolean r0 = r4.f4365A
            if (r6 >= r5) goto L1b
            r5 = 1
            goto L1c
        L1b:
            r5 = 0
        L1c:
            if (r0 != r5) goto L25
            a.b.h.k.w0 r5 = r4.f4383u
            int r5 = r5.mo8004g()
            goto L2f
        L25:
            a.b.h.k.w0 r5 = r4.f4383u
            int r5 = r5.mo8004g()
            r6 = r5
            r5 = 0
            goto L30
        L2e:
            r5 = 0
        L2f:
            r6 = 0
        L30:
            boolean r0 = r4.m6641f()
            if (r0 == 0) goto L4d
            a.b.h.k.q0 r0 = r4.f4387y
            a.b.h.k.w0 r3 = r4.f4383u
            int r3 = r3.mo8006f()
            int r3 = r3 - r6
            r0.f2876f = r3
            a.b.h.k.q0 r6 = r4.f4387y
            a.b.h.k.w0 r0 = r4.f4383u
            int r0 = r0.mo8014b()
            int r0 = r0 + r5
            r6.f2877g = r0
            goto L5d
        L4d:
            a.b.h.k.q0 r0 = r4.f4387y
            a.b.h.k.w0 r3 = r4.f4383u
            int r3 = r3.mo8017a()
            int r3 = r3 + r5
            r0.f2877g = r3
            a.b.h.k.q0 r5 = r4.f4387y
            int r6 = -r6
            r5.f2876f = r6
        L5d:
            a.b.h.k.q0 r5 = r4.f4387y
            r5.f2878h = r1
            r5.f2871a = r2
            a.b.h.k.w0 r6 = r4.f4383u
            int r6 = r6.mo8010d()
            if (r6 != 0) goto L74
            a.b.h.k.w0 r6 = r4.f4383u
            int r6 = r6.mo8017a()
            if (r6 != 0) goto L74
            r1 = 1
        L74:
            r5.f2879i = r1
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.p067v7.widget.StaggeredGridLayoutManager.m6434b(int, android.support.v7.widget.RecyclerView$a0):void");
    }

    @Override // android.support.p067v7.widget.RecyclerView.AbstractC0722o
    /* renamed from: b */
    public void mo6427b(RecyclerView recyclerView, int i, int i2) {
        m6423c(i, i2, 1);
    }

    /* renamed from: b */
    public final void m6430b(RecyclerView.C0734v c0734v, int i) {
        while (m6644e() > 0) {
            View m6657c = m6657c(0);
            if (this.f4383u.mo8015a(m6657c) > i || this.f4383u.mo8007e(m6657c) > i) {
                return;
            }
            C0761c c0761c = (C0761c) m6657c.getLayoutParams();
            if (c0761c.f4398f) {
                for (int i2 = 0; i2 < this.f4381s; i2++) {
                    if (this.f4382t[i2].f4415a.size() == 1) {
                        return;
                    }
                }
                for (int i3 = 0; i3 < this.f4381s; i3++) {
                    this.f4382t[i3].m6337k();
                }
            } else if (c0761c.f4397e.f4415a.size() == 1) {
                return;
            } else {
                c0761c.f4397e.m6337k();
            }
            m6671a(m6657c, c0734v);
        }
    }

    /* renamed from: c */
    public void m6420c(RecyclerView.C0702a0 c0702a0, C0760b c0760b) {
        if (m6431b(c0702a0, c0760b) || m6456a(c0702a0, c0760b)) {
            return;
        }
        c0760b.m6382a();
        c0760b.f4390a = 0;
    }

    @Override // android.support.p067v7.widget.RecyclerView.AbstractC0722o
    /* renamed from: c */
    public int mo6421c(RecyclerView.C0702a0 c0702a0) {
        return m6400j(c0702a0);
    }

    @Override // android.support.p067v7.widget.RecyclerView.AbstractC0722o
    /* renamed from: c */
    public void mo6418c(RecyclerView recyclerView, int i, int i2) {
        m6423c(i, i2, 2);
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0027  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x003e  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0045 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0046  */
    /* renamed from: c */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void m6423c(int r7, int r8, int r9) {
        /*
            r6 = this;
            boolean r0 = r6.f4365A
            if (r0 == 0) goto L9
            int r0 = r6.m6471J()
            goto Ld
        L9:
            int r0 = r6.m6472I()
        Ld:
            r1 = 8
            if (r9 != r1) goto L1b
            if (r7 >= r8) goto L16
            int r2 = r8 + 1
            goto L1d
        L16:
            int r2 = r7 + 1
            r3 = r2
            r2 = r8
            goto L1f
        L1b:
            int r2 = r7 + r8
        L1d:
            r3 = r2
            r2 = r7
        L1f:
            android.support.v7.widget.StaggeredGridLayoutManager$d r4 = r6.f4369E
            r4.m6364e(r2)
            r4 = 1
            if (r9 == r4) goto L3e
            r5 = 2
            if (r9 == r5) goto L38
            if (r9 == r1) goto L2d
            goto L43
        L2d:
            android.support.v7.widget.StaggeredGridLayoutManager$d r9 = r6.f4369E
            r9.m6369b(r7, r4)
            android.support.v7.widget.StaggeredGridLayoutManager$d r7 = r6.f4369E
            r7.m6374a(r8, r4)
            goto L43
        L38:
            android.support.v7.widget.StaggeredGridLayoutManager$d r9 = r6.f4369E
            r9.m6369b(r7, r8)
            goto L43
        L3e:
            android.support.v7.widget.StaggeredGridLayoutManager$d r9 = r6.f4369E
            r9.m6374a(r7, r8)
        L43:
            if (r3 > r0) goto L46
            return
        L46:
            boolean r7 = r6.f4365A
            if (r7 == 0) goto L4f
            int r7 = r6.m6472I()
            goto L53
        L4f:
            int r7 = r6.m6471J()
        L53:
            if (r2 > r7) goto L58
            r6.m6612y()
        L58:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.p067v7.widget.StaggeredGridLayoutManager.m6423c(int, int, int):void");
    }

    /* renamed from: a */
    public final void m6443a(View view, int i, int i2, boolean z) {
        boolean m6677a;
        m6672a(view, this.f4375K);
        C0761c c0761c = (C0761c) view.getLayoutParams();
        int i3 = ((ViewGroup.MarginLayoutParams) c0761c).leftMargin;
        Rect rect = this.f4375K;
        int m6415d = m6415d(i, i3 + rect.left, ((ViewGroup.MarginLayoutParams) c0761c).rightMargin + rect.right);
        int i4 = ((ViewGroup.MarginLayoutParams) c0761c).topMargin;
        Rect rect2 = this.f4375K;
        int m6415d2 = m6415d(i2, i4 + rect2.top, ((ViewGroup.MarginLayoutParams) c0761c).bottomMargin + rect2.bottom);
        if (z) {
            m6677a = m6659b(view, m6415d, m6415d2, c0761c);
        } else {
            m6677a = m6677a(view, m6415d, m6415d2, c0761c);
        }
        if (m6677a) {
            view.measure(m6415d, m6415d2);
        }
    }

    @Override // android.support.p067v7.widget.RecyclerView.AbstractC0722o
    /* renamed from: b */
    public boolean mo6435b() {
        return this.f4385w == 1;
    }

    @Override // android.support.p067v7.widget.RecyclerView.AbstractC0722o
    /* renamed from: b */
    public int mo6433b(int i, RecyclerView.C0734v c0734v, RecyclerView.C0702a0 c0702a0) {
        return m6422c(i, c0734v, c0702a0);
    }

    /* renamed from: c */
    public int m6422c(int i, RecyclerView.C0734v c0734v, RecyclerView.C0702a0 c0702a0) {
        if (m6644e() == 0 || i == 0) {
            return 0;
        }
        m6463a(i, c0702a0);
        int m6452a = m6452a(c0734v, this.f4387y, c0702a0);
        if (this.f4387y.f2872b >= m6452a) {
            i = i < 0 ? -m6452a : m6452a;
        }
        this.f4383u.mo8016a(-i);
        this.f4371G = this.f4365A;
        LayoutState layoutState = this.f4387y;
        layoutState.f2872b = 0;
        m6453a(c0734v, layoutState);
        return i;
    }

    @Override // android.support.p067v7.widget.RecyclerView.AbstractC0722o
    /* renamed from: a */
    public void mo6458a(Parcelable parcelable) {
        if (parcelable instanceof C0765e) {
            this.f4373I = (C0765e) parcelable;
            m6612y();
        }
    }

    @Override // android.support.p067v7.widget.RecyclerView.AbstractC0722o
    /* renamed from: a */
    public void mo6450a(RecyclerView.C0734v c0734v, RecyclerView.C0702a0 c0702a0, View view, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (!(layoutParams instanceof C0761c)) {
            super.m6673a(view, accessibilityNodeInfoCompat);
            return;
        }
        C0761c c0761c = (C0761c) layoutParams;
        if (this.f4385w == 0) {
            accessibilityNodeInfoCompat.m9547b(AccessibilityNodeInfoCompat.C0285b.m9520a(c0761c.m6378e(), c0761c.f4398f ? this.f4381s : 1, -1, -1, c0761c.f4398f, false));
        } else {
            accessibilityNodeInfoCompat.m9547b(AccessibilityNodeInfoCompat.C0285b.m9520a(-1, -1, c0761c.m6378e(), c0761c.f4398f ? this.f4381s : 1, c0761c.f4398f, false));
        }
    }

    @Override // android.support.p067v7.widget.RecyclerView.AbstractC0722o
    /* renamed from: c */
    public RecyclerView.C0727p mo6424c() {
        if (this.f4385w == 0) {
            return new C0761c(-2, -1);
        }
        return new C0761c(-1, -2);
    }

    @Override // android.support.p067v7.widget.RecyclerView.AbstractC0722o
    /* renamed from: a */
    public void mo6438a(AccessibilityEvent accessibilityEvent) {
        super.mo6438a(accessibilityEvent);
        if (m6644e() > 0) {
            View m6425b = m6425b(false);
            View m6436a = m6436a(false);
            if (m6425b == null || m6436a == null) {
                return;
            }
            int m6626l = m6626l(m6425b);
            int m6626l2 = m6626l(m6436a);
            if (m6626l < m6626l2) {
                accessibilityEvent.setFromIndex(m6626l);
                accessibilityEvent.setToIndex(m6626l2);
                return;
            }
            accessibilityEvent.setFromIndex(m6626l2);
            accessibilityEvent.setToIndex(m6626l);
        }
    }

    @Override // android.support.p067v7.widget.RecyclerView.AbstractC0722o
    /* renamed from: a */
    public int mo6451a(RecyclerView.C0734v c0734v, RecyclerView.C0702a0 c0702a0) {
        if (this.f4385w == 1) {
            return this.f4381s;
        }
        return super.mo6451a(c0734v, c0702a0);
    }

    /* renamed from: a */
    public View m6436a(boolean z) {
        int mo8006f = this.f4383u.mo8006f();
        int mo8014b = this.f4383u.mo8014b();
        View view = null;
        for (int m6644e = m6644e() - 1; m6644e >= 0; m6644e--) {
            View m6657c = m6657c(m6644e);
            int mo8009d = this.f4383u.mo8009d(m6657c);
            int mo8015a = this.f4383u.mo8015a(m6657c);
            if (mo8015a > mo8006f && mo8009d < mo8014b) {
                if (mo8015a <= mo8014b || !z) {
                    return m6657c;
                }
                if (view == null) {
                    view = m6657c;
                }
            }
        }
        return view;
    }

    /* renamed from: a */
    public final void m6449a(RecyclerView.C0734v c0734v, RecyclerView.C0702a0 c0702a0, boolean z) {
        int mo8014b;
        int m6395o = m6395o(Integer.MIN_VALUE);
        if (m6395o != Integer.MIN_VALUE && (mo8014b = this.f4383u.mo8014b() - m6395o) > 0) {
            int i = mo8014b - (-m6422c(-mo8014b, c0734v, c0702a0));
            if (!z || i <= 0) {
                return;
            }
            this.f4383u.mo8016a(i);
        }
    }

    @Override // android.support.p067v7.widget.RecyclerView.AbstractC0722o
    /* renamed from: a */
    public void mo6448a(RecyclerView recyclerView, int i, int i2, int i3) {
        m6423c(i, i2, 8);
    }

    @Override // android.support.p067v7.widget.RecyclerView.AbstractC0722o
    /* renamed from: a */
    public void mo6447a(RecyclerView recyclerView, int i, int i2, Object obj) {
        m6423c(i, i2, 4);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r9v0 */
    /* JADX WARN: Type inference failed for: r9v1, types: [boolean, int] */
    /* JADX WARN: Type inference failed for: r9v6 */
    /* renamed from: a */
    public final int m6452a(RecyclerView.C0734v c0734v, LayoutState layoutState, RecyclerView.C0702a0 c0702a0) {
        int i;
        int i2;
        int mo8006f;
        int m6395o;
        C0767f c0767f;
        int mo8013b;
        int i3;
        int i4;
        int mo8013b2;
        boolean m6476E;
        ?? r9 = 0;
        this.f4366B.set(0, this.f4381s, true);
        if (this.f4387y.f2879i) {
            i2 = layoutState.f2875e == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
        } else {
            if (layoutState.f2875e == 1) {
                i = layoutState.f2877g + layoutState.f2872b;
            } else {
                i = layoutState.f2876f - layoutState.f2872b;
            }
            i2 = i;
        }
        m6411e(layoutState.f2875e, i2);
        if (this.f4365A) {
            mo8006f = this.f4383u.mo8014b();
        } else {
            mo8006f = this.f4383u.mo8006f();
        }
        int i5 = mo8006f;
        boolean z = false;
        while (layoutState.m8133a(c0702a0) && (this.f4387y.f2879i || !this.f4366B.isEmpty())) {
            View m8132a = layoutState.m8132a(c0734v);
            C0761c c0761c = (C0761c) m8132a.getLayoutParams();
            int m6604a = c0761c.m6604a();
            int m6366d = this.f4369E.m6366d(m6604a);
            boolean z2 = m6366d == -1;
            if (z2) {
                c0767f = c0761c.f4398f ? this.f4382t[r9] : m6461a(layoutState);
                this.f4369E.m6372a(m6604a, c0767f);
            } else {
                c0767f = this.f4382t[m6366d];
            }
            C0767f c0767f2 = c0767f;
            c0761c.f4397e = c0767f2;
            if (layoutState.f2875e == 1) {
                m6661b(m8132a);
            } else {
                m6660b(m8132a, (int) r9);
            }
            m6440a(m8132a, c0761c, (boolean) r9);
            if (layoutState.f2875e == 1) {
                int m6395o2 = c0761c.f4398f ? m6395o(i5) : c0767f2.m6357a(i5);
                int mo8013b3 = this.f4383u.mo8013b(m8132a) + m6395o2;
                if (z2 && c0761c.f4398f) {
                    C0762d.C0763a m6399k = m6399k(m6395o2);
                    m6399k.f4402b = -1;
                    m6399k.f4401a = m6604a;
                    this.f4369E.m6371a(m6399k);
                }
                i3 = mo8013b3;
                mo8013b = m6395o2;
            } else {
                int m6390r = c0761c.f4398f ? m6390r(i5) : c0767f2.m6350b(i5);
                mo8013b = m6390r - this.f4383u.mo8013b(m8132a);
                if (z2 && c0761c.f4398f) {
                    C0762d.C0763a m6398l = m6398l(m6390r);
                    m6398l.f4402b = 1;
                    m6398l.f4401a = m6604a;
                    this.f4369E.m6371a(m6398l);
                }
                i3 = m6390r;
            }
            if (c0761c.f4398f && layoutState.f2874d == -1) {
                if (z2) {
                    this.f4377M = true;
                } else {
                    if (layoutState.f2875e == 1) {
                        m6476E = m6477D();
                    } else {
                        m6476E = m6476E();
                    }
                    if (!m6476E) {
                        C0762d.C0763a m6368c = this.f4369E.m6368c(m6604a);
                        if (m6368c != null) {
                            m6368c.f4404d = true;
                        }
                        this.f4377M = true;
                    }
                }
            }
            m6441a(m8132a, c0761c, layoutState);
            if (m6468M() && this.f4385w == 1) {
                int mo8014b = c0761c.f4398f ? this.f4384v.mo8014b() : this.f4384v.mo8014b() - (((this.f4381s - 1) - c0767f2.f4419e) * this.f4386x);
                mo8013b2 = mo8014b;
                i4 = mo8014b - this.f4384v.mo8013b(m8132a);
            } else {
                int mo8006f2 = c0761c.f4398f ? this.f4384v.mo8006f() : (c0767f2.f4419e * this.f4386x) + this.f4384v.mo8006f();
                i4 = mo8006f2;
                mo8013b2 = this.f4384v.mo8013b(m8132a) + mo8006f2;
            }
            if (this.f4385w == 1) {
                m6678a(m8132a, i4, mo8013b, mo8013b2, i3);
            } else {
                m6678a(m8132a, mo8013b, i4, i3, mo8013b2);
            }
            if (c0761c.f4398f) {
                m6411e(this.f4387y.f2875e, i2);
            } else {
                m6444a(c0767f2, this.f4387y.f2875e, i2);
            }
            m6453a(c0734v, this.f4387y);
            if (this.f4387y.f2878h && m8132a.hasFocusable()) {
                if (c0761c.f4398f) {
                    this.f4366B.clear();
                } else {
                    this.f4366B.set(c0767f2.f4419e, false);
                    z = true;
                    r9 = 0;
                }
            }
            z = true;
            r9 = 0;
        }
        if (!z) {
            m6453a(c0734v, this.f4387y);
        }
        if (this.f4387y.f2875e == -1) {
            m6395o = this.f4383u.mo8006f() - m6390r(this.f4383u.mo8006f());
        } else {
            m6395o = m6395o(this.f4383u.mo8014b()) - this.f4383u.mo8014b();
        }
        if (m6395o > 0) {
            return Math.min(layoutState.f2872b, m6395o);
        }
        return 0;
    }

    /* renamed from: a */
    public final void m6441a(View view, C0761c c0761c, LayoutState layoutState) {
        if (layoutState.f2875e == 1) {
            if (c0761c.f4398f) {
                m6393p(view);
            } else {
                c0761c.f4397e.m6353a(view);
            }
        } else if (c0761c.f4398f) {
            m6391q(view);
        } else {
            c0761c.f4397e.m6346c(view);
        }
    }

    /* renamed from: a */
    public final void m6453a(RecyclerView.C0734v c0734v, LayoutState layoutState) {
        int min;
        int min2;
        if (!layoutState.f2871a || layoutState.f2879i) {
            return;
        }
        if (layoutState.f2872b == 0) {
            if (layoutState.f2875e == -1) {
                m6454a(c0734v, layoutState.f2877g);
            } else {
                m6430b(c0734v, layoutState.f2876f);
            }
        } else if (layoutState.f2875e == -1) {
            int i = layoutState.f2876f;
            int m6394p = i - m6394p(i);
            if (m6394p < 0) {
                min2 = layoutState.f2877g;
            } else {
                min2 = layoutState.f2877g - Math.min(m6394p, layoutState.f2872b);
            }
            m6454a(c0734v, min2);
        } else {
            int m6392q = m6392q(layoutState.f2877g) - layoutState.f2877g;
            if (m6392q < 0) {
                min = layoutState.f2876f;
            } else {
                min = Math.min(m6392q, layoutState.f2872b) + layoutState.f2876f;
            }
            m6430b(c0734v, min);
        }
    }

    /* renamed from: a */
    public final void m6444a(C0767f c0767f, int i, int i2) {
        int m6342f = c0767f.m6342f();
        if (i == -1) {
            if (c0767f.m6340h() + m6342f <= i2) {
                this.f4366B.set(c0767f.f4419e, false);
            }
        } else if (c0767f.m6341g() - m6342f >= i2) {
            this.f4366B.set(c0767f.f4419e, false);
        }
    }

    /* renamed from: a */
    public final void m6454a(RecyclerView.C0734v c0734v, int i) {
        for (int m6644e = m6644e() - 1; m6644e >= 0; m6644e--) {
            View m6657c = m6657c(m6644e);
            if (this.f4383u.mo8009d(m6657c) < i || this.f4383u.mo8005f(m6657c) < i) {
                return;
            }
            C0761c c0761c = (C0761c) m6657c.getLayoutParams();
            if (c0761c.f4398f) {
                for (int i2 = 0; i2 < this.f4381s; i2++) {
                    if (this.f4382t[i2].f4415a.size() == 1) {
                        return;
                    }
                }
                for (int i3 = 0; i3 < this.f4381s; i3++) {
                    this.f4382t[i3].m6338j();
                }
            } else if (c0761c.f4397e.f4415a.size() == 1) {
                return;
            } else {
                c0761c.f4397e.m6338j();
            }
            m6671a(m6657c, c0734v);
        }
    }

    /* renamed from: a */
    public final C0767f m6461a(LayoutState layoutState) {
        int i;
        int i2;
        int i3 = -1;
        if (m6389s(layoutState.f2875e)) {
            i = this.f4381s - 1;
            i2 = -1;
        } else {
            i = 0;
            i3 = this.f4381s;
            i2 = 1;
        }
        C0767f c0767f = null;
        if (layoutState.f2875e == 1) {
            int i4 = Integer.MAX_VALUE;
            int mo8006f = this.f4383u.mo8006f();
            while (i != i3) {
                C0767f c0767f2 = this.f4382t[i];
                int m6357a = c0767f2.m6357a(mo8006f);
                if (m6357a < i4) {
                    c0767f = c0767f2;
                    i4 = m6357a;
                }
                i += i2;
            }
            return c0767f;
        }
        int i5 = Integer.MIN_VALUE;
        int mo8014b = this.f4383u.mo8014b();
        while (i != i3) {
            C0767f c0767f3 = this.f4382t[i];
            int m6350b = c0767f3.m6350b(mo8014b);
            if (m6350b > i5) {
                c0767f = c0767f3;
                i5 = m6350b;
            }
            i += i2;
        }
        return c0767f;
    }

    @Override // android.support.p067v7.widget.RecyclerView.AbstractC0722o
    /* renamed from: a */
    public boolean mo6465a() {
        return this.f4385w == 0;
    }

    @Override // android.support.p067v7.widget.RecyclerView.AbstractC0722o
    /* renamed from: a */
    public int mo6462a(int i, RecyclerView.C0734v c0734v, RecyclerView.C0702a0 c0702a0) {
        return m6422c(i, c0734v, c0702a0);
    }

    @Override // android.support.p067v7.widget.RecyclerView.AbstractC0722o
    /* renamed from: a */
    public void mo6464a(int i, int i2, RecyclerView.C0702a0 c0702a0, RecyclerView.AbstractC0722o.InterfaceC0725c interfaceC0725c) {
        int m6357a;
        int i3;
        if (this.f4385w != 0) {
            i = i2;
        }
        if (m6644e() == 0 || i == 0) {
            return;
        }
        m6463a(i, c0702a0);
        int[] iArr = this.f4379O;
        if (iArr == null || iArr.length < this.f4381s) {
            this.f4379O = new int[this.f4381s];
        }
        int i4 = 0;
        for (int i5 = 0; i5 < this.f4381s; i5++) {
            LayoutState layoutState = this.f4387y;
            if (layoutState.f2874d == -1) {
                m6357a = layoutState.f2876f;
                i3 = this.f4382t[i5].m6350b(m6357a);
            } else {
                m6357a = this.f4382t[i5].m6357a(layoutState.f2877g);
                i3 = this.f4387y.f2877g;
            }
            int i6 = m6357a - i3;
            if (i6 >= 0) {
                this.f4379O[i4] = i6;
                i4++;
            }
        }
        Arrays.sort(this.f4379O, 0, i4);
        for (int i7 = 0; i7 < i4 && this.f4387y.m8133a(c0702a0); i7++) {
            interfaceC0725c.mo6605a(this.f4387y.f2873c, this.f4379O[i7]);
            LayoutState layoutState2 = this.f4387y;
            layoutState2.f2873c += layoutState2.f2874d;
        }
    }

    /* renamed from: a */
    public void m6463a(int i, RecyclerView.C0702a0 c0702a0) {
        int m6472I;
        int i2;
        if (i > 0) {
            m6472I = m6471J();
            i2 = 1;
        } else {
            m6472I = m6472I();
            i2 = -1;
        }
        this.f4387y.f2871a = true;
        m6434b(m6472I, c0702a0);
        m6388t(i2);
        LayoutState layoutState = this.f4387y;
        layoutState.f2873c = m6472I + layoutState.f2874d;
        layoutState.f2872b = Math.abs(i);
    }

    @Override // android.support.p067v7.widget.RecyclerView.AbstractC0722o
    /* renamed from: a */
    public RecyclerView.C0727p mo6460a(Context context, AttributeSet attributeSet) {
        return new C0761c(context, attributeSet);
    }

    @Override // android.support.p067v7.widget.RecyclerView.AbstractC0722o
    /* renamed from: a */
    public RecyclerView.C0727p mo6439a(ViewGroup.LayoutParams layoutParams) {
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            return new C0761c((ViewGroup.MarginLayoutParams) layoutParams);
        }
        return new C0761c(layoutParams);
    }

    @Override // android.support.p067v7.widget.RecyclerView.AbstractC0722o
    /* renamed from: a */
    public boolean mo6455a(RecyclerView.C0727p c0727p) {
        return c0727p instanceof C0761c;
    }

    @Override // android.support.p067v7.widget.RecyclerView.AbstractC0722o
    /* renamed from: a */
    public View mo6442a(View view, int i, RecyclerView.C0734v c0734v, RecyclerView.C0702a0 c0702a0) {
        View m6652c;
        int m6472I;
        int m6343e;
        int m6343e2;
        int m6343e3;
        View m6356a;
        if (m6644e() == 0 || (m6652c = m6652c(view)) == null) {
            return null;
        }
        m6466O();
        int m6401j = m6401j(i);
        if (m6401j == Integer.MIN_VALUE) {
            return null;
        }
        C0761c c0761c = (C0761c) m6652c.getLayoutParams();
        boolean z = c0761c.f4398f;
        C0767f c0767f = c0761c.f4397e;
        if (m6401j == 1) {
            m6472I = m6471J();
        } else {
            m6472I = m6472I();
        }
        m6434b(m6472I, c0702a0);
        m6388t(m6401j);
        LayoutState layoutState = this.f4387y;
        layoutState.f2873c = layoutState.f2874d + m6472I;
        layoutState.f2872b = (int) (this.f4383u.mo8004g() * 0.33333334f);
        LayoutState layoutState2 = this.f4387y;
        layoutState2.f2878h = true;
        layoutState2.f2871a = false;
        m6452a(c0734v, layoutState2, c0702a0);
        this.f4371G = this.f4365A;
        if (z || (m6356a = c0767f.m6356a(m6472I, m6401j)) == null || m6356a == m6652c) {
            if (m6389s(m6401j)) {
                for (int i2 = this.f4381s - 1; i2 >= 0; i2--) {
                    View m6356a2 = this.f4382t[i2].m6356a(m6472I, m6401j);
                    if (m6356a2 != null && m6356a2 != m6652c) {
                        return m6356a2;
                    }
                }
            } else {
                for (int i3 = 0; i3 < this.f4381s; i3++) {
                    View m6356a3 = this.f4382t[i3].m6356a(m6472I, m6401j);
                    if (m6356a3 != null && m6356a3 != m6652c) {
                        return m6356a3;
                    }
                }
            }
            boolean z2 = (this.f4388z ^ true) == (m6401j == -1);
            if (!z) {
                if (z2) {
                    m6343e3 = c0767f.m6345d();
                } else {
                    m6343e3 = c0767f.m6343e();
                }
                View mo6667b = mo6667b(m6343e3);
                if (mo6667b != null && mo6667b != m6652c) {
                    return mo6667b;
                }
            }
            if (m6389s(m6401j)) {
                for (int i4 = this.f4381s - 1; i4 >= 0; i4--) {
                    if (i4 != c0767f.f4419e) {
                        if (z2) {
                            m6343e2 = this.f4382t[i4].m6345d();
                        } else {
                            m6343e2 = this.f4382t[i4].m6343e();
                        }
                        View mo6667b2 = mo6667b(m6343e2);
                        if (mo6667b2 != null && mo6667b2 != m6652c) {
                            return mo6667b2;
                        }
                    }
                }
            } else {
                for (int i5 = 0; i5 < this.f4381s; i5++) {
                    if (z2) {
                        m6343e = this.f4382t[i5].m6345d();
                    } else {
                        m6343e = this.f4382t[i5].m6343e();
                    }
                    View mo6667b3 = mo6667b(m6343e);
                    if (mo6667b3 != null && mo6667b3 != m6652c) {
                        return mo6667b3;
                    }
                }
            }
            return null;
        }
        return m6356a;
    }
}
