package p000a.p006b.p008b.p009h.p010j;

import java.util.ArrayList;
import p000a.p006b.p008b.p009h.Cache;
import p000a.p006b.p008b.p009h.LinearSystem;
import p000a.p006b.p008b.p009h.p010j.ConstraintAnchor;

/* renamed from: a.b.b.h.j.f */
/* loaded from: classes.dex */
public class ConstraintWidget {

    /* renamed from: j0 */
    public static float f282j0 = 0.5f;

    /* renamed from: C */
    public EnumC0033b[] f285C;

    /* renamed from: D */
    public ConstraintWidget f286D;

    /* renamed from: E */
    public int f287E;

    /* renamed from: F */
    public int f288F;

    /* renamed from: G */
    public float f289G;

    /* renamed from: H */
    public int f290H;

    /* renamed from: I */
    public int f291I;

    /* renamed from: J */
    public int f292J;

    /* renamed from: K */
    public int f293K;

    /* renamed from: L */
    public int f294L;

    /* renamed from: M */
    public int f295M;

    /* renamed from: N */
    public int f296N;

    /* renamed from: O */
    public int f297O;

    /* renamed from: P */
    public int f298P;

    /* renamed from: Q */
    public int f299Q;

    /* renamed from: R */
    public int f300R;

    /* renamed from: S */
    public int f301S;

    /* renamed from: T */
    public int f302T;

    /* renamed from: U */
    public int f303U;

    /* renamed from: V */
    public float f304V;

    /* renamed from: W */
    public float f305W;

    /* renamed from: X */
    public Object f306X;

    /* renamed from: Y */
    public int f307Y;

    /* renamed from: Z */
    public String f308Z;

    /* renamed from: a0 */
    public String f310a0;

    /* renamed from: b0 */
    public boolean f312b0;

    /* renamed from: c */
    public ResolutionDimension f313c;

    /* renamed from: c0 */
    public boolean f314c0;

    /* renamed from: d */
    public ResolutionDimension f315d;

    /* renamed from: d0 */
    public boolean f316d0;

    /* renamed from: e0 */
    public int f318e0;

    /* renamed from: f0 */
    public int f320f0;

    /* renamed from: g0 */
    public float[] f322g0;

    /* renamed from: h0 */
    public ConstraintWidget[] f324h0;

    /* renamed from: i0 */
    public ConstraintWidget[] f326i0;

    /* renamed from: a */
    public int f309a = -1;

    /* renamed from: b */
    public int f311b = -1;

    /* renamed from: e */
    public int f317e = 0;

    /* renamed from: f */
    public int f319f = 0;

    /* renamed from: g */
    public int[] f321g = new int[2];

    /* renamed from: h */
    public int f323h = 0;

    /* renamed from: i */
    public int f325i = 0;

    /* renamed from: j */
    public float f327j = 1.0f;

    /* renamed from: k */
    public int f328k = 0;

    /* renamed from: l */
    public int f329l = 0;

    /* renamed from: m */
    public float f330m = 1.0f;

    /* renamed from: n */
    public int f331n = -1;

    /* renamed from: o */
    public float f332o = 1.0f;

    /* renamed from: p */
    public ConstraintWidgetGroup f333p = null;

    /* renamed from: q */
    public int[] f334q = {Integer.MAX_VALUE, Integer.MAX_VALUE};

    /* renamed from: r */
    public float f335r = 0.0f;

    /* renamed from: s */
    public ConstraintAnchor f336s = new ConstraintAnchor(this, ConstraintAnchor.EnumC0031d.LEFT);

    /* renamed from: t */
    public ConstraintAnchor f337t = new ConstraintAnchor(this, ConstraintAnchor.EnumC0031d.TOP);

    /* renamed from: u */
    public ConstraintAnchor f338u = new ConstraintAnchor(this, ConstraintAnchor.EnumC0031d.RIGHT);

    /* renamed from: v */
    public ConstraintAnchor f339v = new ConstraintAnchor(this, ConstraintAnchor.EnumC0031d.BOTTOM);

    /* renamed from: w */
    public ConstraintAnchor f340w = new ConstraintAnchor(this, ConstraintAnchor.EnumC0031d.BASELINE);

    /* renamed from: x */
    public ConstraintAnchor f341x = new ConstraintAnchor(this, ConstraintAnchor.EnumC0031d.CENTER_X);

    /* renamed from: y */
    public ConstraintAnchor f342y = new ConstraintAnchor(this, ConstraintAnchor.EnumC0031d.CENTER_Y);

    /* renamed from: z */
    public ConstraintAnchor f343z = new ConstraintAnchor(this, ConstraintAnchor.EnumC0031d.CENTER);

    /* renamed from: A */
    public ConstraintAnchor[] f283A = {this.f336s, this.f338u, this.f337t, this.f339v, this.f340w, this.f343z};

    /* renamed from: B */
    public ArrayList<ConstraintAnchor> f284B = new ArrayList<>();

    /* compiled from: ConstraintWidget.java */
    /* renamed from: a.b.b.h.j.f$a */
    /* loaded from: classes.dex */
    public static /* synthetic */ class C0032a {

        /* renamed from: a */
        public static final /* synthetic */ int[] f344a;

        /* renamed from: b */
        public static final /* synthetic */ int[] f345b = new int[EnumC0033b.values().length];

        static {
            try {
                f345b[EnumC0033b.FIXED.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f345b[EnumC0033b.WRAP_CONTENT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f345b[EnumC0033b.MATCH_PARENT.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f345b[EnumC0033b.MATCH_CONSTRAINT.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            f344a = new int[ConstraintAnchor.EnumC0031d.values().length];
            try {
                f344a[ConstraintAnchor.EnumC0031d.LEFT.ordinal()] = 1;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f344a[ConstraintAnchor.EnumC0031d.TOP.ordinal()] = 2;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f344a[ConstraintAnchor.EnumC0031d.RIGHT.ordinal()] = 3;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                f344a[ConstraintAnchor.EnumC0031d.BOTTOM.ordinal()] = 4;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                f344a[ConstraintAnchor.EnumC0031d.BASELINE.ordinal()] = 5;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                f344a[ConstraintAnchor.EnumC0031d.CENTER.ordinal()] = 6;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                f344a[ConstraintAnchor.EnumC0031d.CENTER_X.ordinal()] = 7;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                f344a[ConstraintAnchor.EnumC0031d.CENTER_Y.ordinal()] = 8;
            } catch (NoSuchFieldError unused12) {
            }
            try {
                f344a[ConstraintAnchor.EnumC0031d.NONE.ordinal()] = 9;
            } catch (NoSuchFieldError unused13) {
            }
        }
    }

    /* compiled from: ConstraintWidget.java */
    /* renamed from: a.b.b.h.j.f$b */
    /* loaded from: classes.dex */
    public enum EnumC0033b {
        FIXED,
        WRAP_CONTENT,
        MATCH_CONSTRAINT,
        MATCH_PARENT
    }

    public ConstraintWidget() {
        EnumC0033b enumC0033b = EnumC0033b.FIXED;
        this.f285C = new EnumC0033b[]{enumC0033b, enumC0033b};
        this.f286D = null;
        this.f287E = 0;
        this.f288F = 0;
        this.f289G = 0.0f;
        this.f290H = -1;
        this.f291I = 0;
        this.f292J = 0;
        this.f293K = 0;
        this.f294L = 0;
        this.f295M = 0;
        this.f296N = 0;
        this.f297O = 0;
        this.f298P = 0;
        this.f299Q = 0;
        float f = f282j0;
        this.f304V = f;
        this.f305W = f;
        this.f307Y = 0;
        this.f308Z = null;
        this.f310a0 = null;
        this.f312b0 = false;
        this.f314c0 = false;
        this.f316d0 = false;
        this.f318e0 = 0;
        this.f320f0 = 0;
        this.f322g0 = new float[]{-1.0f, -1.0f};
        this.f324h0 = new ConstraintWidget[]{null, null};
        this.f326i0 = new ConstraintWidget[]{null, null};
        m11117a();
    }

    /* renamed from: A */
    public boolean m11125A() {
        ConstraintAnchor constraintAnchor = this.f336s;
        ConstraintAnchor constraintAnchor2 = constraintAnchor.f258d;
        if (constraintAnchor2 == null || constraintAnchor2.f258d != constraintAnchor) {
            ConstraintAnchor constraintAnchor3 = this.f338u;
            ConstraintAnchor constraintAnchor4 = constraintAnchor3.f258d;
            return constraintAnchor4 != null && constraintAnchor4.f258d == constraintAnchor3;
        }
        return true;
    }

    /* renamed from: B */
    public boolean m11124B() {
        ConstraintAnchor constraintAnchor = this.f337t;
        ConstraintAnchor constraintAnchor2 = constraintAnchor.f258d;
        if (constraintAnchor2 == null || constraintAnchor2.f258d != constraintAnchor) {
            ConstraintAnchor constraintAnchor3 = this.f339v;
            ConstraintAnchor constraintAnchor4 = constraintAnchor3.f258d;
            return constraintAnchor4 != null && constraintAnchor4.f258d == constraintAnchor3;
        }
        return true;
    }

    /* renamed from: C */
    public boolean m11123C() {
        return this.f319f == 0 && this.f289G == 0.0f && this.f328k == 0 && this.f329l == 0 && this.f285C[1] == EnumC0033b.MATCH_CONSTRAINT;
    }

    /* renamed from: D */
    public boolean m11122D() {
        return this.f317e == 0 && this.f289G == 0.0f && this.f323h == 0 && this.f325i == 0 && this.f285C[0] == EnumC0033b.MATCH_CONSTRAINT;
    }

    /* renamed from: E */
    public void mo10982E() {
        this.f336s.m11126j();
        this.f337t.m11126j();
        this.f338u.m11126j();
        this.f339v.m11126j();
        this.f340w.m11126j();
        this.f341x.m11126j();
        this.f342y.m11126j();
        this.f343z.m11126j();
        this.f286D = null;
        this.f335r = 0.0f;
        this.f287E = 0;
        this.f288F = 0;
        this.f289G = 0.0f;
        this.f290H = -1;
        this.f291I = 0;
        this.f292J = 0;
        this.f295M = 0;
        this.f296N = 0;
        this.f297O = 0;
        this.f298P = 0;
        this.f299Q = 0;
        this.f300R = 0;
        this.f301S = 0;
        this.f302T = 0;
        this.f303U = 0;
        float f = f282j0;
        this.f304V = f;
        this.f305W = f;
        EnumC0033b[] enumC0033bArr = this.f285C;
        EnumC0033b enumC0033b = EnumC0033b.FIXED;
        enumC0033bArr[0] = enumC0033b;
        enumC0033bArr[1] = enumC0033b;
        this.f306X = null;
        this.f307Y = 0;
        this.f310a0 = null;
        this.f318e0 = 0;
        this.f320f0 = 0;
        float[] fArr = this.f322g0;
        fArr[0] = -1.0f;
        fArr[1] = -1.0f;
        this.f309a = -1;
        this.f311b = -1;
        int[] iArr = this.f334q;
        iArr[0] = Integer.MAX_VALUE;
        iArr[1] = Integer.MAX_VALUE;
        this.f317e = 0;
        this.f319f = 0;
        this.f327j = 1.0f;
        this.f330m = 1.0f;
        this.f325i = Integer.MAX_VALUE;
        this.f329l = Integer.MAX_VALUE;
        this.f323h = 0;
        this.f328k = 0;
        this.f331n = -1;
        this.f332o = 1.0f;
        ResolutionDimension resolutionDimension = this.f313c;
        if (resolutionDimension != null) {
            resolutionDimension.mo10988d();
        }
        ResolutionDimension resolutionDimension2 = this.f315d;
        if (resolutionDimension2 != null) {
            resolutionDimension2.mo10988d();
        }
        this.f333p = null;
        this.f312b0 = false;
        this.f314c0 = false;
        this.f316d0 = false;
    }

    /* renamed from: F */
    public void m11121F() {
        ConstraintWidget m11073l = m11073l();
        if (m11073l != null && (m11073l instanceof ConstraintWidgetContainer) && ((ConstraintWidgetContainer) m11073l()).m11048O()) {
            return;
        }
        int size = this.f284B.size();
        for (int i = 0; i < size; i++) {
            this.f284B.get(i).m11126j();
        }
    }

    /* renamed from: G */
    public void mo11120G() {
        for (int i = 0; i < 6; i++) {
            this.f283A[i].m11132d().mo10988d();
        }
    }

    /* renamed from: H */
    public void mo11119H() {
    }

    /* renamed from: I */
    public void mo10981I() {
        int i = this.f291I;
        int i2 = this.f292J;
        this.f295M = i;
        this.f296N = i2;
    }

    /* renamed from: J */
    public void m11118J() {
        for (int i = 0; i < 6; i++) {
            this.f283A[i].m11132d().m10995g();
        }
    }

    /* renamed from: a */
    public void mo11022a(int i) {
        Optimizer.m11010a(i, this);
    }

    /* renamed from: a */
    public void m11104a(boolean z) {
    }

    /* renamed from: b */
    public void m11099b(LinearSystem linearSystem) {
        linearSystem.m11188a(this.f336s);
        linearSystem.m11188a(this.f337t);
        linearSystem.m11188a(this.f338u);
        linearSystem.m11188a(this.f339v);
        if (this.f299Q > 0) {
            linearSystem.m11188a(this.f340w);
        }
    }

    /* renamed from: b */
    public void m11096b(boolean z) {
    }

    /* renamed from: c */
    public ArrayList<ConstraintAnchor> mo11018c() {
        return this.f284B;
    }

    /* renamed from: d */
    public int m11090d(int i) {
        if (i == 0) {
            return m11057t();
        }
        if (i == 1) {
            return m11077j();
        }
        return 0;
    }

    /* renamed from: e */
    public int m11088e() {
        return m11052x() + this.f288F;
    }

    /* renamed from: f */
    public Object m11085f() {
        return this.f306X;
    }

    /* renamed from: g */
    public String m11083g() {
        return this.f308Z;
    }

    /* renamed from: h */
    public int m11081h() {
        return this.f295M + this.f297O;
    }

    /* renamed from: i */
    public int m11079i() {
        return this.f296N + this.f298P;
    }

    /* renamed from: j */
    public void m11076j(int i) {
        this.f334q[1] = i;
    }

    /* renamed from: k */
    public void m11074k(int i) {
        this.f334q[0] = i;
    }

    /* renamed from: l */
    public ConstraintWidget m11073l() {
        return this.f286D;
    }

    /* renamed from: m */
    public ResolutionDimension m11071m() {
        if (this.f315d == null) {
            this.f315d = new ResolutionDimension();
        }
        return this.f315d;
    }

    /* renamed from: n */
    public ResolutionDimension m11069n() {
        if (this.f313c == null) {
            this.f313c = new ResolutionDimension();
        }
        return this.f313c;
    }

    /* renamed from: o */
    public void m11066o(int i) {
        this.f307Y = i;
    }

    /* renamed from: p */
    public int m11065p() {
        return this.f291I + this.f297O;
    }

    /* renamed from: q */
    public int m11063q() {
        return this.f292J + this.f298P;
    }

    /* renamed from: r */
    public void m11060r(int i) {
        this.f302T = i;
    }

    /* renamed from: s */
    public int m11059s() {
        return this.f307Y;
    }

    /* renamed from: t */
    public int m11057t() {
        if (this.f307Y == 8) {
            return 0;
        }
        return this.f287E;
    }

    public String toString() {
        String str;
        StringBuilder sb = new StringBuilder();
        String str2 = "";
        if (this.f310a0 != null) {
            str = "type: " + this.f310a0 + " ";
        } else {
            str = "";
        }
        sb.append(str);
        if (this.f308Z != null) {
            str2 = "id: " + this.f308Z + " ";
        }
        sb.append(str2);
        sb.append("(");
        sb.append(this.f291I);
        sb.append(", ");
        sb.append(this.f292J);
        sb.append(") - (");
        sb.append(this.f287E);
        sb.append(" x ");
        sb.append(this.f288F);
        sb.append(") wrap: (");
        sb.append(this.f302T);
        sb.append(" x ");
        sb.append(this.f303U);
        sb.append(")");
        return sb.toString();
    }

    /* renamed from: u */
    public int m11055u() {
        return this.f303U;
    }

    /* renamed from: v */
    public int m11054v() {
        return this.f302T;
    }

    /* renamed from: w */
    public int m11053w() {
        return this.f291I;
    }

    /* renamed from: x */
    public int m11052x() {
        return this.f292J;
    }

    /* renamed from: y */
    public boolean m11051y() {
        return this.f299Q > 0;
    }

    /* renamed from: z */
    public boolean m11050z() {
        return this.f336s.m11132d().f406b == 1 && this.f338u.m11132d().f406b == 1 && this.f337t.m11132d().f406b == 1 && this.f339v.m11132d().f406b == 1;
    }

    /* renamed from: a */
    public void mo10977a(Cache cache) {
        this.f336s.m11138a(cache);
        this.f337t.m11138a(cache);
        this.f338u.m11138a(cache);
        this.f339v.m11138a(cache);
        this.f340w.m11138a(cache);
        this.f343z.m11138a(cache);
        this.f341x.m11138a(cache);
        this.f342y.m11138a(cache);
    }

    /* renamed from: c */
    public void m11093c(int i, int i2) {
        this.f291I = i;
        this.f292J = i2;
    }

    /* renamed from: e */
    public void m11086e(int i, int i2) {
        this.f292J = i;
        this.f288F = i2 - i;
        int i3 = this.f288F;
        int i4 = this.f301S;
        if (i3 < i4) {
            this.f288F = i4;
        }
    }

    /* renamed from: f */
    public final boolean m11084f(int i) {
        int i2 = i * 2;
        ConstraintAnchor[] constraintAnchorArr = this.f283A;
        if (constraintAnchorArr[i2].f258d != null && constraintAnchorArr[i2].f258d.f258d != constraintAnchorArr[i2]) {
            int i3 = i2 + 1;
            if (constraintAnchorArr[i3].f258d != null && constraintAnchorArr[i3].f258d.f258d == constraintAnchorArr[i3]) {
                return true;
            }
        }
        return false;
    }

    /* renamed from: g */
    public void m11082g(int i) {
        this.f299Q = i;
    }

    /* renamed from: h */
    public void m11080h(int i) {
        this.f288F = i;
        int i2 = this.f288F;
        int i3 = this.f301S;
        if (i2 < i3) {
            this.f288F = i3;
        }
    }

    /* renamed from: i */
    public void m11078i(int i) {
        this.f318e0 = i;
    }

    /* renamed from: j */
    public int m11077j() {
        if (this.f307Y == 8) {
            return 0;
        }
        return this.f288F;
    }

    /* renamed from: k */
    public EnumC0033b m11075k() {
        return this.f285C[0];
    }

    /* renamed from: l */
    public void m11072l(int i) {
        if (i < 0) {
            this.f301S = 0;
        } else {
            this.f301S = i;
        }
    }

    /* renamed from: o */
    public int m11067o() {
        return m11053w() + this.f287E;
    }

    /* renamed from: p */
    public void m11064p(int i) {
        this.f287E = i;
        int i2 = this.f287E;
        int i3 = this.f300R;
        if (i2 < i3) {
            this.f287E = i3;
        }
    }

    /* renamed from: q */
    public void m11062q(int i) {
        this.f303U = i;
    }

    /* renamed from: r */
    public EnumC0033b m11061r() {
        return this.f285C[1];
    }

    /* renamed from: s */
    public void m11058s(int i) {
        this.f291I = i;
    }

    /* renamed from: d */
    public int m11092d() {
        return this.f299Q;
    }

    /* renamed from: t */
    public void m11056t(int i) {
        this.f292J = i;
    }

    /* renamed from: c */
    public void m11095c(float f) {
        this.f305W = f;
    }

    /* renamed from: d */
    public void m11089d(int i, int i2) {
        if (i2 == 0) {
            this.f293K = i;
        } else if (i2 == 1) {
            this.f294L = i;
        }
    }

    /* renamed from: m */
    public void m11070m(int i) {
        if (i < 0) {
            this.f300R = 0;
        } else {
            this.f300R = i;
        }
    }

    /* renamed from: n */
    public void m11068n(int i) {
        this.f320f0 = i;
    }

    /* renamed from: c */
    public EnumC0033b m11094c(int i) {
        if (i == 0) {
            return m11075k();
        }
        if (i == 1) {
            return m11061r();
        }
        return null;
    }

    /* renamed from: d */
    public void m11091d(float f) {
        this.f322g0[1] = f;
    }

    /* renamed from: e */
    public int m11087e(int i) {
        if (i == 0) {
            return this.f293K;
        }
        if (i == 1) {
            return this.f294L;
        }
        return 0;
    }

    /* renamed from: b */
    public float m11101b(int i) {
        if (i == 0) {
            return this.f304V;
        }
        if (i == 1) {
            return this.f305W;
        }
        return -1.0f;
    }

    /* renamed from: c */
    public void mo11017c(LinearSystem linearSystem) {
        int m11182b = linearSystem.m11182b(this.f336s);
        int m11182b2 = linearSystem.m11182b(this.f337t);
        int m11182b3 = linearSystem.m11182b(this.f338u);
        int m11182b4 = linearSystem.m11182b(this.f339v);
        int i = m11182b4 - m11182b2;
        if (m11182b3 - m11182b < 0 || i < 0 || m11182b == Integer.MIN_VALUE || m11182b == Integer.MAX_VALUE || m11182b2 == Integer.MIN_VALUE || m11182b2 == Integer.MAX_VALUE || m11182b3 == Integer.MIN_VALUE || m11182b3 == Integer.MAX_VALUE || m11182b4 == Integer.MIN_VALUE || m11182b4 == Integer.MAX_VALUE) {
            m11182b4 = 0;
            m11182b = 0;
            m11182b2 = 0;
            m11182b3 = 0;
        }
        m11112a(m11182b, m11182b2, m11182b3, m11182b4);
    }

    /* renamed from: b */
    public void mo10976b(int i, int i2) {
        this.f297O = i;
        this.f298P = i2;
    }

    /* renamed from: a */
    public final void m11117a() {
        this.f284B.add(this.f336s);
        this.f284B.add(this.f337t);
        this.f284B.add(this.f338u);
        this.f284B.add(this.f339v);
        this.f284B.add(this.f341x);
        this.f284B.add(this.f342y);
        this.f284B.add(this.f343z);
        this.f284B.add(this.f340w);
    }

    /* renamed from: b */
    public void m11100b(int i, int i2, int i3, float f) {
        this.f319f = i;
        this.f328k = i2;
        this.f329l = i3;
        this.f330m = f;
        if (f >= 1.0f || this.f319f != 0) {
            return;
        }
        this.f319f = 2;
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:38:0x0084 -> B:39:0x0085). Please submit an issue!!! */
    /* renamed from: b */
    public void m11097b(String str) {
        float f;
        int i = 0;
        if (str != null && str.length() != 0) {
            int i2 = -1;
            int length = str.length();
            int indexOf = str.indexOf(44);
            int i3 = 0;
            if (indexOf > 0 && indexOf < length - 1) {
                String substring = str.substring(0, indexOf);
                if (substring.equalsIgnoreCase("W")) {
                    i2 = 0;
                } else if (substring.equalsIgnoreCase("H")) {
                    i2 = 1;
                }
                i3 = indexOf + 1;
            }
            int indexOf2 = str.indexOf(58);
            if (indexOf2 >= 0 && indexOf2 < length - 1) {
                String substring2 = str.substring(i3, indexOf2);
                String substring3 = str.substring(indexOf2 + 1);
                if (substring2.length() > 0 && substring3.length() > 0) {
                    float parseFloat = Float.parseFloat(substring2);
                    float parseFloat2 = Float.parseFloat(substring3);
                    if (parseFloat > 0.0f && parseFloat2 > 0.0f) {
                        if (i2 == 1) {
                            f = Math.abs(parseFloat2 / parseFloat);
                        } else {
                            f = Math.abs(parseFloat / parseFloat2);
                        }
                    }
                }
                f = 0.0f;
            } else {
                String substring4 = str.substring(i3);
                if (substring4.length() > 0) {
                    f = Float.parseFloat(substring4);
                }
                f = 0.0f;
            }
            i = (f > i ? 1 : (f == i ? 0 : -1));
            if (i > 0) {
                this.f289G = f;
                this.f290H = i2;
                return;
            }
            return;
        }
        this.f289G = 0.0f;
    }

    /* renamed from: a */
    public void m11108a(ConstraintWidget constraintWidget) {
        this.f286D = constraintWidget;
    }

    /* renamed from: a */
    public void m11107a(ConstraintWidget constraintWidget, float f, int i) {
        ConstraintAnchor.EnumC0031d enumC0031d = ConstraintAnchor.EnumC0031d.CENTER;
        m11110a(enumC0031d, constraintWidget, enumC0031d, i, 0);
        this.f335r = f;
    }

    /* renamed from: a */
    public void m11105a(String str) {
        this.f308Z = str;
    }

    /* renamed from: a */
    public void m11113a(int i, int i2, int i3, float f) {
        this.f317e = i;
        this.f323h = i2;
        this.f325i = i3;
        this.f327j = f;
        if (f >= 1.0f || this.f317e != 0) {
            return;
        }
        this.f317e = 2;
    }

    /* renamed from: a */
    public void m11116a(float f) {
        this.f304V = f;
    }

    /* renamed from: a */
    public void m11112a(int i, int i2, int i3, int i4) {
        int i5;
        int i6;
        int i7 = i3 - i;
        int i8 = i4 - i2;
        this.f291I = i;
        this.f292J = i2;
        if (this.f307Y == 8) {
            this.f287E = 0;
            this.f288F = 0;
            return;
        }
        if (this.f285C[0] != EnumC0033b.FIXED || i7 >= (i5 = this.f287E)) {
            i5 = i7;
        }
        if (this.f285C[1] != EnumC0033b.FIXED || i8 >= (i6 = this.f288F)) {
            i6 = i8;
        }
        this.f287E = i5;
        this.f288F = i6;
        int i9 = this.f288F;
        int i10 = this.f301S;
        if (i9 < i10) {
            this.f288F = i10;
        }
        int i11 = this.f287E;
        int i12 = this.f300R;
        if (i11 < i12) {
            this.f287E = i12;
        }
        this.f314c0 = true;
    }

    /* renamed from: b */
    public void m11102b(float f) {
        this.f322g0[0] = f;
    }

    /* renamed from: b */
    public boolean mo11019b() {
        return this.f307Y != 8;
    }

    /* renamed from: b */
    public void m11098b(EnumC0033b enumC0033b) {
        this.f285C[1] = enumC0033b;
        if (enumC0033b == EnumC0033b.WRAP_CONTENT) {
            m11080h(this.f303U);
        }
    }

    /* renamed from: a */
    public void m11114a(int i, int i2, int i3) {
        if (i3 == 0) {
            m11115a(i, i2);
        } else if (i3 == 1) {
            m11086e(i, i2);
        }
        this.f314c0 = true;
    }

    /* renamed from: a */
    public void m11115a(int i, int i2) {
        this.f291I = i;
        this.f287E = i2 - i;
        int i3 = this.f287E;
        int i4 = this.f300R;
        if (i3 < i4) {
            this.f287E = i4;
        }
    }

    /* renamed from: a */
    public void m11106a(Object obj) {
        this.f306X = obj;
    }

    /* renamed from: a */
    public void m11110a(ConstraintAnchor.EnumC0031d enumC0031d, ConstraintWidget constraintWidget, ConstraintAnchor.EnumC0031d enumC0031d2, int i, int i2) {
        mo11020a(enumC0031d).m11136a(constraintWidget.mo11020a(enumC0031d2), i, i2, ConstraintAnchor.EnumC0030c.STRONG, 0, true);
    }

    /* renamed from: a */
    public ConstraintAnchor mo11020a(ConstraintAnchor.EnumC0031d enumC0031d) {
        switch (C0032a.f344a[enumC0031d.ordinal()]) {
            case 1:
                return this.f336s;
            case 2:
                return this.f337t;
            case 3:
                return this.f338u;
            case 4:
                return this.f339v;
            case 5:
                return this.f340w;
            case 6:
                return this.f343z;
            case 7:
                return this.f341x;
            case 8:
                return this.f342y;
            case 9:
                return null;
            default:
                throw new AssertionError(enumC0031d.name());
        }
    }

    /* renamed from: a */
    public void m11109a(EnumC0033b enumC0033b) {
        this.f285C[0] = enumC0033b;
        if (enumC0033b == EnumC0033b.WRAP_CONTENT) {
            m11064p(this.f302T);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:102:0x01a1  */
    /* JADX WARN: Removed duplicated region for block: B:106:0x01ab A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:110:0x01b7  */
    /* JADX WARN: Removed duplicated region for block: B:116:0x01d0  */
    /* JADX WARN: Removed duplicated region for block: B:125:0x0237  */
    /* JADX WARN: Removed duplicated region for block: B:128:0x0248 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:129:0x0249  */
    /* JADX WARN: Removed duplicated region for block: B:155:0x02aa  */
    /* JADX WARN: Removed duplicated region for block: B:156:0x02b3  */
    /* JADX WARN: Removed duplicated region for block: B:159:0x02b9  */
    /* JADX WARN: Removed duplicated region for block: B:160:0x02c1  */
    /* JADX WARN: Removed duplicated region for block: B:163:0x02f8  */
    /* JADX WARN: Removed duplicated region for block: B:167:0x0321  */
    /* JADX WARN: Removed duplicated region for block: B:170:0x032b  */
    /* JADX WARN: Removed duplicated region for block: B:172:? A[RETURN, SYNTHETIC] */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void mo11021a(p000a.p006b.p008b.p009h.LinearSystem r39) {
        /*
            Method dump skipped, instructions count: 844
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: p000a.p006b.p008b.p009h.p010j.ConstraintWidget.mo11021a(a.b.b.h.e):void");
    }

    /* renamed from: a */
    public void m11103a(boolean z, boolean z2, boolean z3, boolean z4) {
        if (this.f331n == -1) {
            if (z3 && !z4) {
                this.f331n = 0;
            } else if (!z3 && z4) {
                this.f331n = 1;
                if (this.f290H == -1) {
                    this.f332o = 1.0f / this.f332o;
                }
            }
        }
        if (this.f331n == 0 && (!this.f337t.m11127i() || !this.f339v.m11127i())) {
            this.f331n = 1;
        } else if (this.f331n == 1 && (!this.f336s.m11127i() || !this.f338u.m11127i())) {
            this.f331n = 0;
        }
        if (this.f331n == -1 && (!this.f337t.m11127i() || !this.f339v.m11127i() || !this.f336s.m11127i() || !this.f338u.m11127i())) {
            if (this.f337t.m11127i() && this.f339v.m11127i()) {
                this.f331n = 0;
            } else if (this.f336s.m11127i() && this.f338u.m11127i()) {
                this.f332o = 1.0f / this.f332o;
                this.f331n = 1;
            }
        }
        if (this.f331n == -1) {
            if (z && !z2) {
                this.f331n = 0;
            } else if (!z && z2) {
                this.f332o = 1.0f / this.f332o;
                this.f331n = 1;
            }
        }
        if (this.f331n == -1) {
            if (this.f323h > 0 && this.f328k == 0) {
                this.f331n = 0;
            } else if (this.f323h == 0 && this.f328k > 0) {
                this.f332o = 1.0f / this.f332o;
                this.f331n = 1;
            }
        }
        if (this.f331n == -1 && z && z2) {
            this.f332o = 1.0f / this.f332o;
            this.f331n = 1;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:162:0x02a2  */
    /* JADX WARN: Removed duplicated region for block: B:169:0x02e5  */
    /* JADX WARN: Removed duplicated region for block: B:173:0x02f4  */
    /* JADX WARN: Removed duplicated region for block: B:175:0x02f8 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:179:0x0305 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:183:0x0313  */
    /* JADX WARN: Removed duplicated region for block: B:184:0x031c  */
    /* JADX WARN: Removed duplicated region for block: B:188:0x0323  */
    /* JADX WARN: Removed duplicated region for block: B:197:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:55:0x00dd  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x0107  */
    /* JADX WARN: Removed duplicated region for block: B:98:0x01d8 A[ADDED_TO_REGION] */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void m11111a(p000a.p006b.p008b.p009h.LinearSystem r26, boolean r27, p000a.p006b.p008b.p009h.SolverVariable r28, p000a.p006b.p008b.p009h.SolverVariable r29, p000a.p006b.p008b.p009h.p010j.ConstraintWidget.EnumC0033b r30, boolean r31, p000a.p006b.p008b.p009h.p010j.ConstraintAnchor r32, p000a.p006b.p008b.p009h.p010j.ConstraintAnchor r33, int r34, int r35, int r36, int r37, float r38, boolean r39, boolean r40, int r41, int r42, int r43, float r44, boolean r45) {
        /*
            Method dump skipped, instructions count: 827
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: p000a.p006b.p008b.p009h.p010j.ConstraintWidget.m11111a(a.b.b.h.e, boolean, a.b.b.h.i, a.b.b.h.i, a.b.b.h.j.f$b, boolean, a.b.b.h.j.e, a.b.b.h.j.e, int, int, int, int, float, boolean, boolean, int, int, int, float, boolean):void");
    }
}
