package android.support.p067v7.widget;

import android.content.Context;
import android.os.Parcel;
import android.os.Parcelable;
import android.support.p067v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;
import java.util.List;
import p000a.p006b.p049h.p063k.OrientationHelper;
import p000a.p006b.p049h.p063k.ScrollbarHelper;
import p000a.p006b.p049h.p063k.p064v1.ItemTouchHelper;

/* renamed from: android.support.v7.widget.LinearLayoutManager */
/* loaded from: classes.dex */
public class LinearLayoutManager extends RecyclerView.AbstractC0722o implements ItemTouchHelper, RecyclerView.AbstractC0739z.InterfaceC0740a {

    /* renamed from: A */
    public int f4062A;

    /* renamed from: B */
    public int f4063B;

    /* renamed from: C */
    public boolean f4064C;

    /* renamed from: D */
    public C0699d f4065D;

    /* renamed from: E */
    public final C0696a f4066E;

    /* renamed from: F */
    public final C0697b f4067F;

    /* renamed from: G */
    public int f4068G;

    /* renamed from: s */
    public int f4069s;

    /* renamed from: t */
    public C0698c f4070t;

    /* renamed from: u */
    public OrientationHelper f4071u;

    /* renamed from: v */
    public boolean f4072v;

    /* renamed from: w */
    public boolean f4073w;

    /* renamed from: x */
    public boolean f4074x;

    /* renamed from: y */
    public boolean f4075y;

    /* renamed from: z */
    public boolean f4076z;

    /* renamed from: android.support.v7.widget.LinearLayoutManager$b */
    /* loaded from: classes.dex */
    public static class C0697b {

        /* renamed from: a */
        public int f4082a;

        /* renamed from: b */
        public boolean f4083b;

        /* renamed from: c */
        public boolean f4084c;

        /* renamed from: d */
        public boolean f4085d;

        /* renamed from: a */
        public void m6978a() {
            this.f4082a = 0;
            this.f4083b = false;
            this.f4084c = false;
            this.f4085d = false;
        }
    }

    /* renamed from: android.support.v7.widget.LinearLayoutManager$c */
    /* loaded from: classes.dex */
    public static class C0698c {

        /* renamed from: b */
        public int f4087b;

        /* renamed from: c */
        public int f4088c;

        /* renamed from: d */
        public int f4089d;

        /* renamed from: e */
        public int f4090e;

        /* renamed from: f */
        public int f4091f;

        /* renamed from: g */
        public int f4092g;

        /* renamed from: i */
        public boolean f4094i;

        /* renamed from: j */
        public int f4095j;

        /* renamed from: l */
        public boolean f4097l;

        /* renamed from: a */
        public boolean f4086a = true;

        /* renamed from: h */
        public int f4093h = 0;

        /* renamed from: k */
        public List<RecyclerView.AbstractC0708d0> f4096k = null;

        /* renamed from: a */
        public boolean m6976a(RecyclerView.C0702a0 c0702a0) {
            int i = this.f4089d;
            return i >= 0 && i < c0702a0.m6846a();
        }

        /* renamed from: b */
        public final View m6973b() {
            int size = this.f4096k.size();
            for (int i = 0; i < size; i++) {
                View view = this.f4096k.get(i).f4213a;
                RecyclerView.C0727p c0727p = (RecyclerView.C0727p) view.getLayoutParams();
                if (!c0727p.m6602c() && this.f4089d == c0727p.m6604a()) {
                    m6974a(view);
                    return view;
                }
            }
            return null;
        }

        /* renamed from: a */
        public View m6975a(RecyclerView.C0734v c0734v) {
            if (this.f4096k != null) {
                return m6973b();
            }
            View m6555d = c0734v.m6555d(this.f4089d);
            this.f4089d += this.f4090e;
            return m6555d;
        }

        /* renamed from: a */
        public void m6977a() {
            m6974a((View) null);
        }

        /* renamed from: a */
        public void m6974a(View view) {
            View m6972b = m6972b(view);
            if (m6972b == null) {
                this.f4089d = -1;
            } else {
                this.f4089d = ((RecyclerView.C0727p) m6972b.getLayoutParams()).m6604a();
            }
        }

        /* renamed from: b */
        public View m6972b(View view) {
            int m6604a;
            int size = this.f4096k.size();
            View view2 = null;
            int i = Integer.MAX_VALUE;
            for (int i2 = 0; i2 < size; i2++) {
                View view3 = this.f4096k.get(i2).f4213a;
                RecyclerView.C0727p c0727p = (RecyclerView.C0727p) view3.getLayoutParams();
                if (view3 != view && !c0727p.m6602c() && (m6604a = (c0727p.m6604a() - this.f4089d) * this.f4090e) >= 0 && m6604a < i) {
                    view2 = view3;
                    if (m6604a == 0) {
                        break;
                    }
                    i = m6604a;
                }
            }
            return view2;
        }
    }

    /* renamed from: android.support.v7.widget.LinearLayoutManager$d */
    /* loaded from: classes.dex */
    public static class C0699d implements Parcelable {
        public static final Parcelable.Creator<C0699d> CREATOR = new C0700a();

        /* renamed from: a */
        public int f4098a;

        /* renamed from: b */
        public int f4099b;

        /* renamed from: c */
        public boolean f4100c;

        /* renamed from: android.support.v7.widget.LinearLayoutManager$d$a */
        /* loaded from: classes.dex */
        public static class C0700a implements Parcelable.Creator<C0699d> {
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public C0699d createFromParcel(Parcel parcel) {
                return new C0699d(parcel);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public C0699d[] newArray(int i) {
                return new C0699d[i];
            }
        }

        public C0699d() {
        }

        /* renamed from: a */
        public boolean m6971a() {
            return this.f4098a >= 0;
        }

        /* renamed from: b */
        public void m6970b() {
            this.f4098a = -1;
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeInt(this.f4098a);
            parcel.writeInt(this.f4099b);
            parcel.writeInt(this.f4100c ? 1 : 0);
        }

        public C0699d(Parcel parcel) {
            this.f4098a = parcel.readInt();
            this.f4099b = parcel.readInt();
            this.f4100c = parcel.readInt() == 1;
        }

        public C0699d(C0699d c0699d) {
            this.f4098a = c0699d.f4098a;
            this.f4099b = c0699d.f4099b;
            this.f4100c = c0699d.f4100c;
        }
    }

    public LinearLayoutManager(Context context) {
        this(context, 1, false);
    }

    @Override // android.support.p067v7.widget.RecyclerView.AbstractC0722o
    /* renamed from: A */
    public boolean mo6709A() {
        return (m6633i() == 1073741824 || m6617r() == 1073741824 || !m6616s()) ? false : true;
    }

    @Override // android.support.p067v7.widget.RecyclerView.AbstractC0722o
    /* renamed from: C */
    public boolean mo6478C() {
        return this.f4065D == null && this.f4072v == this.f4075y;
    }

    /* renamed from: D */
    public C0698c m7034D() {
        return new C0698c();
    }

    /* renamed from: E */
    public void m7033E() {
        if (this.f4070t == null) {
            this.f4070t = m7034D();
        }
    }

    /* renamed from: F */
    public int m7032F() {
        View m7023a = m7023a(0, m6644e(), false, true);
        if (m7023a == null) {
            return -1;
        }
        return m6626l(m7023a);
    }

    /* renamed from: G */
    public int m7031G() {
        View m7023a = m7023a(m6644e() - 1, -1, false, true);
        if (m7023a == null) {
            return -1;
        }
        return m6626l(m7023a);
    }

    /* renamed from: H */
    public final View m7030H() {
        return m6657c(this.f4074x ? 0 : m6644e() - 1);
    }

    /* renamed from: I */
    public final View m7029I() {
        return m6657c(this.f4074x ? m6644e() - 1 : 0);
    }

    /* renamed from: J */
    public int m7028J() {
        return this.f4069s;
    }

    /* renamed from: K */
    public boolean m7027K() {
        return m6631j() == 1;
    }

    /* renamed from: L */
    public boolean m7026L() {
        return this.f4071u.mo8010d() == 0 && this.f4071u.mo8017a() == 0;
    }

    /* renamed from: M */
    public final void m7025M() {
        if (this.f4069s != 1 && m7027K()) {
            this.f4074x = !this.f4073w;
        } else {
            this.f4074x = this.f4073w;
        }
    }

    /* renamed from: a */
    public void mo7012a(RecyclerView.C0734v c0734v, RecyclerView.C0702a0 c0702a0, C0696a c0696a, int i) {
    }

    @Override // android.support.p067v7.widget.RecyclerView.AbstractC0722o
    /* renamed from: a */
    public void mo6438a(AccessibilityEvent accessibilityEvent) {
        super.mo6438a(accessibilityEvent);
        if (m6644e() > 0) {
            accessibilityEvent.setFromIndex(m7032F());
            accessibilityEvent.setToIndex(m7031G());
        }
    }

    @Override // android.support.p067v7.widget.RecyclerView.AbstractC0722o
    /* renamed from: b */
    public void mo6426b(RecyclerView recyclerView, RecyclerView.C0734v c0734v) {
        super.mo6426b(recyclerView, c0734v);
        if (this.f4064C) {
            m6664b(c0734v);
            c0734v.m6582a();
        }
    }

    @Override // android.support.p067v7.widget.RecyclerView.AbstractC0722o
    /* renamed from: c */
    public RecyclerView.C0727p mo6424c() {
        return new RecyclerView.C0727p(-2, -2);
    }

    @Override // android.support.p067v7.widget.RecyclerView.AbstractC0722o
    /* renamed from: d */
    public int mo6414d(RecyclerView.C0702a0 c0702a0) {
        return m6995h(c0702a0);
    }

    @Override // android.support.p067v7.widget.RecyclerView.AbstractC0722o
    /* renamed from: e */
    public void mo6409e(RecyclerView.C0734v c0734v, RecyclerView.C0702a0 c0702a0) {
        int i;
        int i2;
        int i3;
        int i4;
        int i5;
        int m7022a;
        int i6;
        View mo6667b;
        int mo8009d;
        int i7;
        int i8 = -1;
        if ((this.f4065D != null || this.f4062A != -1) && c0702a0.m6846a() == 0) {
            m6664b(c0734v);
            return;
        }
        C0699d c0699d = this.f4065D;
        if (c0699d != null && c0699d.m6971a()) {
            this.f4062A = this.f4065D.f4098a;
        }
        m7033E();
        this.f4070t.f4086a = false;
        m7025M();
        View m6638g = m6638g();
        if (this.f4066E.f4081e && this.f4062A == -1 && this.f4065D == null) {
            if (m6638g != null && (this.f4071u.mo8009d(m6638g) >= this.f4071u.mo8014b() || this.f4071u.mo8015a(m6638g) <= this.f4071u.mo8006f())) {
                this.f4066E.m6979b(m6638g, m6626l(m6638g));
            }
        } else {
            this.f4066E.m6980b();
            C0696a c0696a = this.f4066E;
            c0696a.f4080d = this.f4074x ^ this.f4075y;
            m7004b(c0734v, c0702a0, c0696a);
            this.f4066E.f4081e = true;
        }
        int m6987k = m6987k(c0702a0);
        if (this.f4070t.f4095j >= 0) {
            i = m6987k;
            m6987k = 0;
        } else {
            i = 0;
        }
        int mo8006f = m6987k + this.f4071u.mo8006f();
        int mo8012c = i + this.f4071u.mo8012c();
        if (c0702a0.m6841d() && (i6 = this.f4062A) != -1 && this.f4063B != Integer.MIN_VALUE && (mo6667b = mo6667b(i6)) != null) {
            if (this.f4074x) {
                i7 = this.f4071u.mo8014b() - this.f4071u.mo8015a(mo6667b);
                mo8009d = this.f4063B;
            } else {
                mo8009d = this.f4071u.mo8009d(mo6667b) - this.f4071u.mo8006f();
                i7 = this.f4063B;
            }
            int i9 = i7 - mo8009d;
            if (i9 > 0) {
                mo8006f += i9;
            } else {
                mo8012c -= i9;
            }
        }
        if (!this.f4066E.f4080d ? !this.f4074x : this.f4074x) {
            i8 = 1;
        }
        mo7012a(c0734v, c0702a0, this.f4066E, i8);
        m6696a(c0734v);
        this.f4070t.f4097l = m7026L();
        this.f4070t.f4094i = c0702a0.m6841d();
        C0696a c0696a2 = this.f4066E;
        if (c0696a2.f4080d) {
            m7007b(c0696a2);
            C0698c c0698c = this.f4070t;
            c0698c.f4093h = mo8006f;
            m7015a(c0734v, c0698c, c0702a0, false);
            C0698c c0698c2 = this.f4070t;
            i3 = c0698c2.f4087b;
            int i10 = c0698c2.f4089d;
            int i11 = c0698c2.f4088c;
            if (i11 > 0) {
                mo8012c += i11;
            }
            m7021a(this.f4066E);
            C0698c c0698c3 = this.f4070t;
            c0698c3.f4093h = mo8012c;
            c0698c3.f4089d += c0698c3.f4090e;
            m7015a(c0734v, c0698c3, c0702a0, false);
            C0698c c0698c4 = this.f4070t;
            i2 = c0698c4.f4087b;
            int i12 = c0698c4.f4088c;
            if (i12 > 0) {
                m6997g(i10, i3);
                C0698c c0698c5 = this.f4070t;
                c0698c5.f4093h = i12;
                m7015a(c0734v, c0698c5, c0702a0, false);
                i3 = this.f4070t.f4087b;
            }
        } else {
            m7021a(c0696a2);
            C0698c c0698c6 = this.f4070t;
            c0698c6.f4093h = mo8012c;
            m7015a(c0734v, c0698c6, c0702a0, false);
            C0698c c0698c7 = this.f4070t;
            i2 = c0698c7.f4087b;
            int i13 = c0698c7.f4089d;
            int i14 = c0698c7.f4088c;
            if (i14 > 0) {
                mo8006f += i14;
            }
            m7007b(this.f4066E);
            C0698c c0698c8 = this.f4070t;
            c0698c8.f4093h = mo8006f;
            c0698c8.f4089d += c0698c8.f4090e;
            m7015a(c0734v, c0698c8, c0702a0, false);
            C0698c c0698c9 = this.f4070t;
            i3 = c0698c9.f4087b;
            int i15 = c0698c9.f4088c;
            if (i15 > 0) {
                m6999f(i13, i2);
                C0698c c0698c10 = this.f4070t;
                c0698c10.f4093h = i15;
                m7015a(c0734v, c0698c10, c0702a0, false);
                i2 = this.f4070t.f4087b;
            }
        }
        if (m6644e() > 0) {
            if (this.f4074x ^ this.f4075y) {
                int m7022a2 = m7022a(i2, c0734v, c0702a0, true);
                i4 = i3 + m7022a2;
                i5 = i2 + m7022a2;
                m7022a = m7008b(i4, c0734v, c0702a0, false);
            } else {
                int m7008b = m7008b(i3, c0734v, c0702a0, true);
                i4 = i3 + m7008b;
                i5 = i2 + m7008b;
                m7022a = m7022a(i5, c0734v, c0702a0, false);
            }
            i3 = i4 + m7022a;
            i2 = i5 + m7022a;
        }
        m7005b(c0734v, c0702a0, i3, i2);
        if (!c0702a0.m6841d()) {
            this.f4071u.m8018i();
        } else {
            this.f4066E.m6980b();
        }
        this.f4072v = this.f4075y;
    }

    /* renamed from: f */
    public final void m6999f(int i, int i2) {
        this.f4070t.f4088c = this.f4071u.mo8014b() - i2;
        this.f4070t.f4090e = this.f4074x ? -1 : 1;
        C0698c c0698c = this.f4070t;
        c0698c.f4089d = i;
        c0698c.f4091f = 1;
        c0698c.f4087b = i2;
        c0698c.f4092g = Integer.MIN_VALUE;
    }

    @Override // android.support.p067v7.widget.RecyclerView.AbstractC0722o
    /* renamed from: g */
    public void mo6406g(RecyclerView.C0702a0 c0702a0) {
        super.mo6406g(c0702a0);
        this.f4065D = null;
        this.f4062A = -1;
        this.f4063B = Integer.MIN_VALUE;
        this.f4066E.m6980b();
    }

    @Override // android.support.p067v7.widget.RecyclerView.AbstractC0722o
    /* renamed from: h */
    public void mo6405h(int i) {
        this.f4062A = i;
        this.f4063B = Integer.MIN_VALUE;
        C0699d c0699d = this.f4065D;
        if (c0699d != null) {
            c0699d.m6970b();
        }
        m6612y();
    }

    /* renamed from: i */
    public final int m6992i(RecyclerView.C0702a0 c0702a0) {
        if (m6644e() == 0) {
            return 0;
        }
        m7033E();
        return ScrollbarHelper.m8480a(c0702a0, this.f4071u, m7002b(!this.f4076z, true), m7009a(!this.f4076z, true), this, this.f4076z, this.f4074x);
    }

    /* renamed from: j */
    public void m6990j(int i) {
        if (i != 0 && i != 1) {
            throw new IllegalArgumentException("invalid orientation:" + i);
        }
        mo6437a((String) null);
        if (i != this.f4069s || this.f4071u == null) {
            this.f4071u = OrientationHelper.m8021a(this, i);
            this.f4066E.f4077a = this.f4071u;
            this.f4069s = i;
            m6612y();
        }
    }

    /* renamed from: k */
    public int m6987k(RecyclerView.C0702a0 c0702a0) {
        if (c0702a0.m6842c()) {
            return this.f4071u.mo8004g();
        }
        return 0;
    }

    /* renamed from: l */
    public final View m6985l(RecyclerView.C0734v c0734v, RecyclerView.C0702a0 c0702a0) {
        return this.f4074x ? m6996g(c0734v, c0702a0) : m6991i(c0734v, c0702a0);
    }

    /* renamed from: m */
    public final View m6984m(RecyclerView.C0734v c0734v, RecyclerView.C0702a0 c0702a0) {
        return this.f4074x ? m6991i(c0734v, c0702a0) : m6996g(c0734v, c0702a0);
    }

    @Override // android.support.p067v7.widget.RecyclerView.AbstractC0722o
    /* renamed from: u */
    public boolean mo6387u() {
        return true;
    }

    @Override // android.support.p067v7.widget.RecyclerView.AbstractC0722o
    /* renamed from: x */
    public Parcelable mo6383x() {
        C0699d c0699d = this.f4065D;
        if (c0699d != null) {
            return new C0699d(c0699d);
        }
        C0699d c0699d2 = new C0699d();
        if (m6644e() > 0) {
            m7033E();
            boolean z = this.f4072v ^ this.f4074x;
            c0699d2.f4100c = z;
            if (z) {
                View m7030H = m7030H();
                c0699d2.f4099b = this.f4071u.mo8014b() - this.f4071u.mo8015a(m7030H);
                c0699d2.f4098a = m6626l(m7030H);
            } else {
                View m7029I = m7029I();
                c0699d2.f4098a = m6626l(m7029I);
                c0699d2.f4099b = this.f4071u.mo8009d(m7029I) - this.f4071u.mo8006f();
            }
        } else {
            c0699d2.m6970b();
        }
        return c0699d2;
    }

    public LinearLayoutManager(Context context, int i, boolean z) {
        this.f4069s = 1;
        this.f4073w = false;
        this.f4074x = false;
        this.f4075y = false;
        this.f4076z = true;
        this.f4062A = -1;
        this.f4063B = Integer.MIN_VALUE;
        this.f4065D = null;
        this.f4066E = new C0696a();
        this.f4067F = new C0697b();
        this.f4068G = 2;
        m6990j(i);
        m7010a(z);
    }

    @Override // android.support.p067v7.widget.RecyclerView.AbstractC0722o
    /* renamed from: c */
    public int mo6421c(RecyclerView.C0702a0 c0702a0) {
        return m6989j(c0702a0);
    }

    /* renamed from: android.support.v7.widget.LinearLayoutManager$a */
    /* loaded from: classes.dex */
    public static class C0696a {

        /* renamed from: a */
        public OrientationHelper f4077a;

        /* renamed from: b */
        public int f4078b;

        /* renamed from: c */
        public int f4079c;

        /* renamed from: d */
        public boolean f4080d;

        /* renamed from: e */
        public boolean f4081e;

        public C0696a() {
            m6980b();
        }

        /* renamed from: a */
        public void m6983a() {
            int mo8006f;
            if (this.f4080d) {
                mo8006f = this.f4077a.mo8014b();
            } else {
                mo8006f = this.f4077a.mo8006f();
            }
            this.f4079c = mo8006f;
        }

        /* renamed from: b */
        public void m6980b() {
            this.f4078b = -1;
            this.f4079c = Integer.MIN_VALUE;
            this.f4080d = false;
            this.f4081e = false;
        }

        public String toString() {
            return "AnchorInfo{mPosition=" + this.f4078b + ", mCoordinate=" + this.f4079c + ", mLayoutFromEnd=" + this.f4080d + ", mValid=" + this.f4081e + '}';
        }

        /* renamed from: a */
        public boolean m6981a(View view, RecyclerView.C0702a0 c0702a0) {
            RecyclerView.C0727p c0727p = (RecyclerView.C0727p) view.getLayoutParams();
            return !c0727p.m6602c() && c0727p.m6604a() >= 0 && c0727p.m6604a() < c0702a0.m6846a();
        }

        /* renamed from: b */
        public void m6979b(View view, int i) {
            int m8019h = this.f4077a.m8019h();
            if (m8019h >= 0) {
                m6982a(view, i);
                return;
            }
            this.f4078b = i;
            if (this.f4080d) {
                int mo8014b = (this.f4077a.mo8014b() - m8019h) - this.f4077a.mo8015a(view);
                this.f4079c = this.f4077a.mo8014b() - mo8014b;
                if (mo8014b > 0) {
                    int mo8013b = this.f4079c - this.f4077a.mo8013b(view);
                    int mo8006f = this.f4077a.mo8006f();
                    int min = mo8013b - (mo8006f + Math.min(this.f4077a.mo8009d(view) - mo8006f, 0));
                    if (min < 0) {
                        this.f4079c += Math.min(mo8014b, -min);
                        return;
                    }
                    return;
                }
                return;
            }
            int mo8009d = this.f4077a.mo8009d(view);
            int mo8006f2 = mo8009d - this.f4077a.mo8006f();
            this.f4079c = mo8009d;
            if (mo8006f2 > 0) {
                int mo8014b2 = (this.f4077a.mo8014b() - Math.min(0, (this.f4077a.mo8014b() - m8019h) - this.f4077a.mo8015a(view))) - (mo8009d + this.f4077a.mo8013b(view));
                if (mo8014b2 < 0) {
                    this.f4079c -= Math.min(mo8006f2, -mo8014b2);
                }
            }
        }

        /* renamed from: a */
        public void m6982a(View view, int i) {
            if (this.f4080d) {
                this.f4079c = this.f4077a.mo8015a(view) + this.f4077a.m8019h();
            } else {
                this.f4079c = this.f4077a.mo8009d(view);
            }
            this.f4078b = i;
        }
    }

    /* renamed from: c */
    public int m7001c(int i, RecyclerView.C0734v c0734v, RecyclerView.C0702a0 c0702a0) {
        if (m6644e() == 0 || i == 0) {
            return 0;
        }
        this.f4070t.f4086a = true;
        m7033E();
        int i2 = i > 0 ? 1 : -1;
        int abs = Math.abs(i);
        m7024a(i2, abs, true, c0702a0);
        C0698c c0698c = this.f4070t;
        int m7015a = c0698c.f4092g + m7015a(c0734v, c0698c, c0702a0, false);
        if (m7015a < 0) {
            return 0;
        }
        if (abs > m7015a) {
            i = i2 * m7015a;
        }
        this.f4071u.mo8016a(-i);
        this.f4070t.f4095j = i;
        return i;
    }

    /* renamed from: k */
    public final View m6986k(RecyclerView.C0734v c0734v, RecyclerView.C0702a0 c0702a0) {
        return this.f4074x ? m6994h(c0734v, c0702a0) : m6998f(c0734v, c0702a0);
    }

    @Override // android.support.p067v7.widget.RecyclerView.AbstractC0722o
    /* renamed from: a */
    public void mo6458a(Parcelable parcelable) {
        if (parcelable instanceof C0699d) {
            this.f4065D = (C0699d) parcelable;
            m6612y();
        }
    }

    @Override // android.support.p067v7.widget.RecyclerView.AbstractC0722o
    /* renamed from: b */
    public boolean mo6435b() {
        return this.f4069s == 1;
    }

    /* renamed from: b */
    public void mo7003b(boolean z) {
        mo6437a((String) null);
        if (this.f4075y == z) {
            return;
        }
        this.f4075y = z;
        m6612y();
    }

    /* renamed from: g */
    public final void m6997g(int i, int i2) {
        this.f4070t.f4088c = i2 - this.f4071u.mo8006f();
        C0698c c0698c = this.f4070t;
        c0698c.f4089d = i;
        c0698c.f4090e = this.f4074x ? 1 : -1;
        C0698c c0698c2 = this.f4070t;
        c0698c2.f4091f = -1;
        c0698c2.f4087b = i2;
        c0698c2.f4092g = Integer.MIN_VALUE;
    }

    /* renamed from: h */
    public final int m6995h(RecyclerView.C0702a0 c0702a0) {
        if (m6644e() == 0) {
            return 0;
        }
        m7033E();
        return ScrollbarHelper.m8481a(c0702a0, this.f4071u, m7002b(!this.f4076z, true), m7009a(!this.f4076z, true), this, this.f4076z);
    }

    @Override // android.support.p067v7.widget.RecyclerView.AbstractC0722o
    /* renamed from: f */
    public int mo6407f(RecyclerView.C0702a0 c0702a0) {
        return m6989j(c0702a0);
    }

    /* renamed from: i */
    public int m6993i(int i) {
        return i != 1 ? i != 2 ? i != 17 ? i != 33 ? i != 66 ? (i == 130 && this.f4069s == 1) ? 1 : Integer.MIN_VALUE : this.f4069s == 0 ? 1 : Integer.MIN_VALUE : this.f4069s == 1 ? -1 : Integer.MIN_VALUE : this.f4069s == 0 ? -1 : Integer.MIN_VALUE : (this.f4069s != 1 && m7027K()) ? -1 : 1 : (this.f4069s != 1 && m7027K()) ? 1 : -1;
    }

    @Override // android.support.p067v7.widget.RecyclerView.AbstractC0722o
    /* renamed from: a */
    public boolean mo6465a() {
        return this.f4069s == 0;
    }

    /* renamed from: f */
    public final View m6998f(RecyclerView.C0734v c0734v, RecyclerView.C0702a0 c0702a0) {
        return m7000e(0, m6644e());
    }

    /* renamed from: j */
    public final int m6989j(RecyclerView.C0702a0 c0702a0) {
        if (m6644e() == 0) {
            return 0;
        }
        m7033E();
        return ScrollbarHelper.m8479b(c0702a0, this.f4071u, m7002b(!this.f4076z, true), m7009a(!this.f4076z, true), this, this.f4076z);
    }

    /* renamed from: a */
    public void m7010a(boolean z) {
        mo6437a((String) null);
        if (z == this.f4073w) {
            return;
        }
        this.f4073w = z;
        m6612y();
    }

    @Override // android.support.p067v7.widget.RecyclerView.AbstractC0722o
    /* renamed from: b */
    public View mo6667b(int i) {
        int m6644e = m6644e();
        if (m6644e == 0) {
            return null;
        }
        int m6626l = i - m6626l(m6657c(0));
        if (m6626l >= 0 && m6626l < m6644e) {
            View m6657c = m6657c(m6626l);
            if (m6626l(m6657c) == i) {
                return m6657c;
            }
        }
        return super.mo6667b(i);
    }

    /* renamed from: g */
    public final View m6996g(RecyclerView.C0734v c0734v, RecyclerView.C0702a0 c0702a0) {
        return mo7014a(c0734v, c0702a0, 0, m6644e(), c0702a0.m6846a());
    }

    /* renamed from: h */
    public final View m6994h(RecyclerView.C0734v c0734v, RecyclerView.C0702a0 c0702a0) {
        return m7000e(m6644e() - 1, -1);
    }

    /* renamed from: a */
    public final boolean m7013a(RecyclerView.C0734v c0734v, RecyclerView.C0702a0 c0702a0, C0696a c0696a) {
        View m6984m;
        int mo8006f;
        boolean z = false;
        if (m6644e() == 0) {
            return false;
        }
        View m6638g = m6638g();
        if (m6638g != null && c0696a.m6981a(m6638g, c0702a0)) {
            c0696a.m6979b(m6638g, m6626l(m6638g));
            return true;
        } else if (this.f4072v != this.f4075y) {
            return false;
        } else {
            if (c0696a.f4080d) {
                m6984m = m6985l(c0734v, c0702a0);
            } else {
                m6984m = m6984m(c0734v, c0702a0);
            }
            if (m6984m != null) {
                c0696a.m6982a(m6984m, m6626l(m6984m));
                if (!c0702a0.m6841d() && mo6478C()) {
                    if ((this.f4071u.mo8009d(m6984m) >= this.f4071u.mo8014b() || this.f4071u.mo8015a(m6984m) < this.f4071u.mo8006f()) ? true : true) {
                        if (c0696a.f4080d) {
                            mo8006f = this.f4071u.mo8014b();
                        } else {
                            mo8006f = this.f4071u.mo8006f();
                        }
                        c0696a.f4079c = mo8006f;
                    }
                }
                return true;
            }
            return false;
        }
    }

    /* renamed from: j */
    public final View m6988j(RecyclerView.C0734v c0734v, RecyclerView.C0702a0 c0702a0) {
        return this.f4074x ? m6998f(c0734v, c0702a0) : m6994h(c0734v, c0702a0);
    }

    /* renamed from: b */
    public final void m7005b(RecyclerView.C0734v c0734v, RecyclerView.C0702a0 c0702a0, int i, int i2) {
        if (!c0702a0.m6840e() || m6644e() == 0 || c0702a0.m6841d() || !mo6478C()) {
            return;
        }
        List<RecyclerView.AbstractC0708d0> m6550f = c0734v.m6550f();
        int size = m6550f.size();
        int m6626l = m6626l(m6657c(0));
        int i3 = 0;
        int i4 = 0;
        for (int i5 = 0; i5 < size; i5++) {
            RecyclerView.AbstractC0708d0 abstractC0708d0 = m6550f.get(i5);
            if (!abstractC0708d0.m6797r()) {
                if (((abstractC0708d0.m6804k() < m6626l) != this.f4074x ? (char) 65535 : (char) 1) == 65535) {
                    i3 += this.f4071u.mo8013b(abstractC0708d0.f4213a);
                } else {
                    i4 += this.f4071u.mo8013b(abstractC0708d0.f4213a);
                }
            }
        }
        this.f4070t.f4096k = m6550f;
        if (i3 > 0) {
            m6997g(m6626l(m7029I()), i);
            C0698c c0698c = this.f4070t;
            c0698c.f4093h = i3;
            c0698c.f4088c = 0;
            c0698c.m6977a();
            m7015a(c0734v, this.f4070t, c0702a0, false);
        }
        if (i4 > 0) {
            m6999f(m6626l(m7030H()), i2);
            C0698c c0698c2 = this.f4070t;
            c0698c2.f4093h = i4;
            c0698c2.f4088c = 0;
            c0698c2.m6977a();
            m7015a(c0734v, this.f4070t, c0702a0, false);
        }
        this.f4070t.f4096k = null;
    }

    /* renamed from: i */
    public final View m6991i(RecyclerView.C0734v c0734v, RecyclerView.C0702a0 c0702a0) {
        return mo7014a(c0734v, c0702a0, m6644e() - 1, -1, c0702a0.m6846a());
    }

    public LinearLayoutManager(Context context, AttributeSet attributeSet, int i, int i2) {
        this.f4069s = 1;
        this.f4073w = false;
        this.f4074x = false;
        this.f4075y = false;
        this.f4076z = true;
        this.f4062A = -1;
        this.f4063B = Integer.MIN_VALUE;
        this.f4065D = null;
        this.f4066E = new C0696a();
        this.f4067F = new C0697b();
        this.f4068G = 2;
        RecyclerView.AbstractC0722o.C0726d m6698a = RecyclerView.AbstractC0722o.m6698a(context, attributeSet, i, i2);
        m6990j(m6698a.f4264a);
        m7010a(m6698a.f4266c);
        mo7003b(m6698a.f4267d);
    }

    /* renamed from: a */
    public final boolean m7020a(RecyclerView.C0702a0 c0702a0, C0696a c0696a) {
        int i;
        int mo8009d;
        if (!c0702a0.m6841d() && (i = this.f4062A) != -1) {
            if (i >= 0 && i < c0702a0.m6846a()) {
                c0696a.f4078b = this.f4062A;
                C0699d c0699d = this.f4065D;
                if (c0699d != null && c0699d.m6971a()) {
                    c0696a.f4080d = this.f4065D.f4100c;
                    if (c0696a.f4080d) {
                        c0696a.f4079c = this.f4071u.mo8014b() - this.f4065D.f4099b;
                    } else {
                        c0696a.f4079c = this.f4071u.mo8006f() + this.f4065D.f4099b;
                    }
                    return true;
                } else if (this.f4063B == Integer.MIN_VALUE) {
                    View mo6667b = mo6667b(this.f4062A);
                    if (mo6667b != null) {
                        if (this.f4071u.mo8013b(mo6667b) > this.f4071u.mo8004g()) {
                            c0696a.m6983a();
                            return true;
                        } else if (this.f4071u.mo8009d(mo6667b) - this.f4071u.mo8006f() < 0) {
                            c0696a.f4079c = this.f4071u.mo8006f();
                            c0696a.f4080d = false;
                            return true;
                        } else if (this.f4071u.mo8014b() - this.f4071u.mo8015a(mo6667b) < 0) {
                            c0696a.f4079c = this.f4071u.mo8014b();
                            c0696a.f4080d = true;
                            return true;
                        } else {
                            if (c0696a.f4080d) {
                                mo8009d = this.f4071u.mo8015a(mo6667b) + this.f4071u.m8019h();
                            } else {
                                mo8009d = this.f4071u.mo8009d(mo6667b);
                            }
                            c0696a.f4079c = mo8009d;
                        }
                    } else {
                        if (m6644e() > 0) {
                            c0696a.f4080d = (this.f4062A < m6626l(m6657c(0))) == this.f4074x;
                        }
                        c0696a.m6983a();
                    }
                    return true;
                } else {
                    boolean z = this.f4074x;
                    c0696a.f4080d = z;
                    if (z) {
                        c0696a.f4079c = this.f4071u.mo8014b() - this.f4063B;
                    } else {
                        c0696a.f4079c = this.f4071u.mo8006f() + this.f4063B;
                    }
                    return true;
                }
            }
            this.f4062A = -1;
            this.f4063B = Integer.MIN_VALUE;
        }
        return false;
    }

    /* renamed from: b */
    public final void m7004b(RecyclerView.C0734v c0734v, RecyclerView.C0702a0 c0702a0, C0696a c0696a) {
        if (m7020a(c0702a0, c0696a) || m7013a(c0734v, c0702a0, c0696a)) {
            return;
        }
        c0696a.m6983a();
        c0696a.f4078b = this.f4075y ? c0702a0.m6846a() - 1 : 0;
    }

    /* renamed from: b */
    public final int m7008b(int i, RecyclerView.C0734v c0734v, RecyclerView.C0702a0 c0702a0, boolean z) {
        int mo8006f;
        int mo8006f2 = i - this.f4071u.mo8006f();
        if (mo8006f2 > 0) {
            int i2 = -m7001c(mo8006f2, c0734v, c0702a0);
            int i3 = i + i2;
            if (!z || (mo8006f = i3 - this.f4071u.mo8006f()) <= 0) {
                return i2;
            }
            this.f4071u.mo8016a(-mo8006f);
            return i2 - mo8006f;
        }
        return 0;
    }

    /* renamed from: b */
    public final void m7007b(C0696a c0696a) {
        m6997g(c0696a.f4078b, c0696a.f4079c);
    }

    @Override // android.support.p067v7.widget.RecyclerView.AbstractC0722o
    /* renamed from: b */
    public int mo6433b(int i, RecyclerView.C0734v c0734v, RecyclerView.C0702a0 c0702a0) {
        if (this.f4069s == 0) {
            return 0;
        }
        return m7001c(i, c0734v, c0702a0);
    }

    @Override // android.support.p067v7.widget.RecyclerView.AbstractC0722o
    /* renamed from: b */
    public int mo6432b(RecyclerView.C0702a0 c0702a0) {
        return m6992i(c0702a0);
    }

    /* renamed from: b */
    public final void m7006b(RecyclerView.C0734v c0734v, int i) {
        if (i < 0) {
            return;
        }
        int m6644e = m6644e();
        if (!this.f4074x) {
            for (int i2 = 0; i2 < m6644e; i2++) {
                View m6657c = m6657c(i2);
                if (this.f4071u.mo8015a(m6657c) > i || this.f4071u.mo8007e(m6657c) > i) {
                    m7017a(c0734v, 0, i2);
                    return;
                }
            }
            return;
        }
        int i3 = m6644e - 1;
        for (int i4 = i3; i4 >= 0; i4--) {
            View m6657c2 = m6657c(i4);
            if (this.f4071u.mo8015a(m6657c2) > i || this.f4071u.mo8007e(m6657c2) > i) {
                m7017a(c0734v, i3, i4);
                return;
            }
        }
    }

    /* renamed from: b */
    public final View m7002b(boolean z, boolean z2) {
        if (this.f4074x) {
            return m7023a(m6644e() - 1, -1, z, z2);
        }
        return m7023a(0, m6644e(), z, z2);
    }

    /* renamed from: a */
    public final int m7022a(int i, RecyclerView.C0734v c0734v, RecyclerView.C0702a0 c0702a0, boolean z) {
        int mo8014b;
        int mo8014b2 = this.f4071u.mo8014b() - i;
        if (mo8014b2 > 0) {
            int i2 = -m7001c(-mo8014b2, c0734v, c0702a0);
            int i3 = i + i2;
            if (!z || (mo8014b = this.f4071u.mo8014b() - i3) <= 0) {
                return i2;
            }
            this.f4071u.mo8016a(mo8014b);
            return mo8014b + i2;
        }
        return 0;
    }

    /* renamed from: a */
    public final void m7021a(C0696a c0696a) {
        m6999f(c0696a.f4078b, c0696a.f4079c);
    }

    @Override // android.support.p067v7.widget.RecyclerView.AbstractC0722o
    /* renamed from: a */
    public int mo6462a(int i, RecyclerView.C0734v c0734v, RecyclerView.C0702a0 c0702a0) {
        if (this.f4069s == 1) {
            return 0;
        }
        return m7001c(i, c0734v, c0702a0);
    }

    @Override // android.support.p067v7.widget.RecyclerView.AbstractC0722o
    /* renamed from: a */
    public int mo6457a(RecyclerView.C0702a0 c0702a0) {
        return m6995h(c0702a0);
    }

    /* renamed from: a */
    public final void m7024a(int i, int i2, boolean z, RecyclerView.C0702a0 c0702a0) {
        int mo8006f;
        this.f4070t.f4097l = m7026L();
        this.f4070t.f4093h = m6987k(c0702a0);
        C0698c c0698c = this.f4070t;
        c0698c.f4091f = i;
        if (i == 1) {
            c0698c.f4093h += this.f4071u.mo8012c();
            View m7030H = m7030H();
            this.f4070t.f4090e = this.f4074x ? -1 : 1;
            C0698c c0698c2 = this.f4070t;
            int m6626l = m6626l(m7030H);
            C0698c c0698c3 = this.f4070t;
            c0698c2.f4089d = m6626l + c0698c3.f4090e;
            c0698c3.f4087b = this.f4071u.mo8015a(m7030H);
            mo8006f = this.f4071u.mo8015a(m7030H) - this.f4071u.mo8014b();
        } else {
            View m7029I = m7029I();
            this.f4070t.f4093h += this.f4071u.mo8006f();
            this.f4070t.f4090e = this.f4074x ? 1 : -1;
            C0698c c0698c4 = this.f4070t;
            int m6626l2 = m6626l(m7029I);
            C0698c c0698c5 = this.f4070t;
            c0698c4.f4089d = m6626l2 + c0698c5.f4090e;
            c0698c5.f4087b = this.f4071u.mo8009d(m7029I);
            mo8006f = (-this.f4071u.mo8009d(m7029I)) + this.f4071u.mo8006f();
        }
        C0698c c0698c6 = this.f4070t;
        c0698c6.f4088c = i2;
        if (z) {
            c0698c6.f4088c -= mo8006f;
        }
        this.f4070t.f4092g = mo8006f;
    }

    @Override // android.support.p067v7.widget.RecyclerView.AbstractC0722o
    /* renamed from: e */
    public int mo6410e(RecyclerView.C0702a0 c0702a0) {
        return m6992i(c0702a0);
    }

    /* renamed from: e */
    public View m7000e(int i, int i2) {
        int i3;
        int i4;
        m7033E();
        if ((i2 > i ? (char) 1 : i2 < i ? (char) 65535 : (char) 0) == 0) {
            return m6657c(i);
        }
        if (this.f4071u.mo8009d(m6657c(i)) < this.f4071u.mo8006f()) {
            i3 = 16644;
            i4 = 16388;
        } else {
            i3 = 4161;
            i4 = 4097;
        }
        if (this.f4069s == 0) {
            return this.f4248e.m8108a(i, i2, i3, i4);
        }
        return this.f4249f.m8108a(i, i2, i3, i4);
    }

    /* renamed from: a */
    public void mo7019a(RecyclerView.C0702a0 c0702a0, C0698c c0698c, RecyclerView.AbstractC0722o.InterfaceC0725c interfaceC0725c) {
        int i = c0698c.f4089d;
        if (i < 0 || i >= c0702a0.m6846a()) {
            return;
        }
        interfaceC0725c.mo6605a(i, Math.max(0, c0698c.f4092g));
    }

    @Override // android.support.p067v7.widget.RecyclerView.AbstractC0722o
    /* renamed from: a */
    public void mo6702a(int i, RecyclerView.AbstractC0722o.InterfaceC0725c interfaceC0725c) {
        boolean z;
        int i2;
        C0699d c0699d = this.f4065D;
        if (c0699d != null && c0699d.m6971a()) {
            C0699d c0699d2 = this.f4065D;
            z = c0699d2.f4100c;
            i2 = c0699d2.f4098a;
        } else {
            m7025M();
            z = this.f4074x;
            i2 = this.f4062A;
            if (i2 == -1) {
                i2 = z ? i - 1 : 0;
            }
        }
        int i3 = z ? -1 : 1;
        int i4 = i2;
        for (int i5 = 0; i5 < this.f4068G && i4 >= 0 && i4 < i; i5++) {
            interfaceC0725c.mo6605a(i4, 0);
            i4 += i3;
        }
    }

    @Override // android.support.p067v7.widget.RecyclerView.AbstractC0722o
    /* renamed from: a */
    public void mo6464a(int i, int i2, RecyclerView.C0702a0 c0702a0, RecyclerView.AbstractC0722o.InterfaceC0725c interfaceC0725c) {
        if (this.f4069s != 0) {
            i = i2;
        }
        if (m6644e() == 0 || i == 0) {
            return;
        }
        m7033E();
        m7024a(i > 0 ? 1 : -1, Math.abs(i), true, c0702a0);
        mo7019a(c0702a0, this.f4070t, interfaceC0725c);
    }

    @Override // android.support.p067v7.widget.RecyclerView.AbstractC0722o
    /* renamed from: a */
    public void mo6437a(String str) {
        if (this.f4065D == null) {
            super.mo6437a(str);
        }
    }

    /* renamed from: a */
    public final void m7017a(RecyclerView.C0734v c0734v, int i, int i2) {
        if (i == i2) {
            return;
        }
        if (i2 <= i) {
            while (i > i2) {
                m6701a(i, c0734v);
                i--;
            }
            return;
        }
        for (int i3 = i2 - 1; i3 >= i; i3--) {
            m6701a(i3, c0734v);
        }
    }

    /* renamed from: a */
    public final void m7018a(RecyclerView.C0734v c0734v, int i) {
        int m6644e = m6644e();
        if (i < 0) {
            return;
        }
        int mo8017a = this.f4071u.mo8017a() - i;
        if (this.f4074x) {
            for (int i2 = 0; i2 < m6644e; i2++) {
                View m6657c = m6657c(i2);
                if (this.f4071u.mo8009d(m6657c) < mo8017a || this.f4071u.mo8005f(m6657c) < mo8017a) {
                    m7017a(c0734v, 0, i2);
                    return;
                }
            }
            return;
        }
        int i3 = m6644e - 1;
        for (int i4 = i3; i4 >= 0; i4--) {
            View m6657c2 = m6657c(i4);
            if (this.f4071u.mo8009d(m6657c2) < mo8017a || this.f4071u.mo8005f(m6657c2) < mo8017a) {
                m7017a(c0734v, i3, i4);
                return;
            }
        }
    }

    /* renamed from: a */
    public final void m7016a(RecyclerView.C0734v c0734v, C0698c c0698c) {
        if (!c0698c.f4086a || c0698c.f4097l) {
            return;
        }
        if (c0698c.f4091f == -1) {
            m7018a(c0734v, c0698c.f4092g);
        } else {
            m7006b(c0734v, c0698c.f4092g);
        }
    }

    /* renamed from: a */
    public int m7015a(RecyclerView.C0734v c0734v, C0698c c0698c, RecyclerView.C0702a0 c0702a0, boolean z) {
        int i = c0698c.f4088c;
        int i2 = c0698c.f4092g;
        if (i2 != Integer.MIN_VALUE) {
            if (i < 0) {
                c0698c.f4092g = i2 + i;
            }
            m7016a(c0734v, c0698c);
        }
        int i3 = c0698c.f4088c + c0698c.f4093h;
        C0697b c0697b = this.f4067F;
        while (true) {
            if ((!c0698c.f4097l && i3 <= 0) || !c0698c.m6976a(c0702a0)) {
                break;
            }
            c0697b.m6978a();
            mo7011a(c0734v, c0702a0, c0698c, c0697b);
            if (!c0697b.f4083b) {
                c0698c.f4087b += c0697b.f4082a * c0698c.f4091f;
                if (!c0697b.f4084c || this.f4070t.f4096k != null || !c0702a0.m6841d()) {
                    int i4 = c0698c.f4088c;
                    int i5 = c0697b.f4082a;
                    c0698c.f4088c = i4 - i5;
                    i3 -= i5;
                }
                int i6 = c0698c.f4092g;
                if (i6 != Integer.MIN_VALUE) {
                    c0698c.f4092g = i6 + c0697b.f4082a;
                    int i7 = c0698c.f4088c;
                    if (i7 < 0) {
                        c0698c.f4092g += i7;
                    }
                    m7016a(c0734v, c0698c);
                }
                if (z && c0697b.f4085d) {
                    break;
                }
            } else {
                break;
            }
        }
        return i - c0698c.f4088c;
    }

    /* renamed from: a */
    public void mo7011a(RecyclerView.C0734v c0734v, RecyclerView.C0702a0 c0702a0, C0698c c0698c, C0697b c0697b) {
        int i;
        int i2;
        int i3;
        int i4;
        int mo8011c;
        View m6975a = c0698c.m6975a(c0734v);
        if (m6975a == null) {
            c0697b.f4083b = true;
            return;
        }
        RecyclerView.C0727p c0727p = (RecyclerView.C0727p) m6975a.getLayoutParams();
        if (c0698c.f4096k == null) {
            if (this.f4074x == (c0698c.f4091f == -1)) {
                m6661b(m6975a);
            } else {
                m6660b(m6975a, 0);
            }
        } else {
            if (this.f4074x == (c0698c.f4091f == -1)) {
                m6681a(m6975a);
            } else {
                m6680a(m6975a, 0);
            }
        }
        m6679a(m6975a, 0, 0);
        c0697b.f4082a = this.f4071u.mo8013b(m6975a);
        if (this.f4069s == 1) {
            if (m7027K()) {
                mo8011c = m6618q() - m6621o();
                i4 = mo8011c - this.f4071u.mo8011c(m6975a);
            } else {
                i4 = m6623n();
                mo8011c = this.f4071u.mo8011c(m6975a) + i4;
            }
            if (c0698c.f4091f == -1) {
                int i5 = c0698c.f4087b;
                i3 = i5;
                i2 = mo8011c;
                i = i5 - c0697b.f4082a;
            } else {
                int i6 = c0698c.f4087b;
                i = i6;
                i2 = mo8011c;
                i3 = c0697b.f4082a + i6;
            }
        } else {
            int m6619p = m6619p();
            int mo8011c2 = this.f4071u.mo8011c(m6975a) + m6619p;
            if (c0698c.f4091f == -1) {
                int i7 = c0698c.f4087b;
                i2 = i7;
                i = m6619p;
                i3 = mo8011c2;
                i4 = i7 - c0697b.f4082a;
            } else {
                int i8 = c0698c.f4087b;
                i = m6619p;
                i2 = c0697b.f4082a + i8;
                i3 = mo8011c2;
                i4 = i8;
            }
        }
        m6678a(m6975a, i4, i, i2, i3);
        if (c0727p.m6602c() || c0727p.m6603b()) {
            c0697b.f4084c = true;
        }
        c0697b.f4085d = m6975a.hasFocusable();
    }

    /* renamed from: a */
    public final View m7009a(boolean z, boolean z2) {
        if (this.f4074x) {
            return m7023a(0, m6644e(), z, z2);
        }
        return m7023a(m6644e() - 1, -1, z, z2);
    }

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
            if (m6626l >= 0 && m6626l < i3) {
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
    public View m7023a(int i, int i2, boolean z, boolean z2) {
        m7033E();
        int i3 = z ? 24579 : 320;
        int i4 = z2 ? 320 : 0;
        if (this.f4069s == 0) {
            return this.f4248e.m8108a(i, i2, i3, i4);
        }
        return this.f4249f.m8108a(i, i2, i3, i4);
    }

    @Override // android.support.p067v7.widget.RecyclerView.AbstractC0722o
    /* renamed from: a */
    public View mo6442a(View view, int i, RecyclerView.C0734v c0734v, RecyclerView.C0702a0 c0702a0) {
        int m6993i;
        View m6988j;
        View m7030H;
        m7025M();
        if (m6644e() == 0 || (m6993i = m6993i(i)) == Integer.MIN_VALUE) {
            return null;
        }
        m7033E();
        m7033E();
        m7024a(m6993i, (int) (this.f4071u.mo8004g() * 0.33333334f), false, c0702a0);
        C0698c c0698c = this.f4070t;
        c0698c.f4092g = Integer.MIN_VALUE;
        c0698c.f4086a = false;
        m7015a(c0734v, c0698c, c0702a0, true);
        if (m6993i == -1) {
            m6988j = m6986k(c0734v, c0702a0);
        } else {
            m6988j = m6988j(c0734v, c0702a0);
        }
        if (m6993i == -1) {
            m7030H = m7029I();
        } else {
            m7030H = m7030H();
        }
        if (m7030H.hasFocusable()) {
            if (m6988j == null) {
                return null;
            }
            return m7030H;
        }
        return m6988j;
    }
}
