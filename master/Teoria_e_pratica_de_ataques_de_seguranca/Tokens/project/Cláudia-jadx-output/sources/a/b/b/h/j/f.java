package a.b.b.h.j;

import a.b.b.h.j.e;
import java.util.ArrayList;
/* compiled from: ConstraintWidget.java */
/* loaded from: classes.dex */
public class f {
    public static float j0 = 0.5f;
    public b[] C;
    public f D;
    public int E;
    public int F;
    public float G;
    public int H;
    public int I;
    public int J;
    public int K;
    public int L;
    public int M;
    public int N;
    public int O;
    public int P;
    public int Q;
    public int R;
    public int S;
    public int T;
    public int U;
    public float V;
    public float W;
    public Object X;
    public int Y;
    public String Z;
    public String a0;
    public boolean b0;

    /* renamed from: c  reason: collision with root package name */
    public n f165c;
    public boolean c0;

    /* renamed from: d  reason: collision with root package name */
    public n f166d;
    public boolean d0;
    public int e0;
    public int f0;
    public float[] g0;
    public f[] h0;
    public f[] i0;

    /* renamed from: a  reason: collision with root package name */
    public int f163a = -1;

    /* renamed from: b  reason: collision with root package name */
    public int f164b = -1;

    /* renamed from: e  reason: collision with root package name */
    public int f167e = 0;

    /* renamed from: f  reason: collision with root package name */
    public int f168f = 0;

    /* renamed from: g  reason: collision with root package name */
    public int[] f169g = new int[2];

    /* renamed from: h  reason: collision with root package name */
    public int f170h = 0;

    /* renamed from: i  reason: collision with root package name */
    public int f171i = 0;
    public float j = 1.0f;
    public int k = 0;
    public int l = 0;
    public float m = 1.0f;
    public int n = -1;
    public float o = 1.0f;
    public h p = null;
    public int[] q = {Integer.MAX_VALUE, Integer.MAX_VALUE};
    public float r = 0.0f;
    public e s = new e(this, e.d.LEFT);
    public e t = new e(this, e.d.TOP);
    public e u = new e(this, e.d.RIGHT);
    public e v = new e(this, e.d.BOTTOM);
    public e w = new e(this, e.d.BASELINE);
    public e x = new e(this, e.d.CENTER_X);
    public e y = new e(this, e.d.CENTER_Y);
    public e z = new e(this, e.d.CENTER);
    public e[] A = {this.s, this.u, this.t, this.v, this.w, this.z};
    public ArrayList<e> B = new ArrayList<>();

    /* compiled from: ConstraintWidget.java */
    /* loaded from: classes.dex */
    public static /* synthetic */ class a {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f172a;

        /* renamed from: b  reason: collision with root package name */
        public static final /* synthetic */ int[] f173b = new int[b.values().length];

        static {
            try {
                f173b[b.FIXED.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f173b[b.WRAP_CONTENT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f173b[b.MATCH_PARENT.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f173b[b.MATCH_CONSTRAINT.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            f172a = new int[e.d.values().length];
            try {
                f172a[e.d.LEFT.ordinal()] = 1;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f172a[e.d.TOP.ordinal()] = 2;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f172a[e.d.RIGHT.ordinal()] = 3;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                f172a[e.d.BOTTOM.ordinal()] = 4;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                f172a[e.d.BASELINE.ordinal()] = 5;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                f172a[e.d.CENTER.ordinal()] = 6;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                f172a[e.d.CENTER_X.ordinal()] = 7;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                f172a[e.d.CENTER_Y.ordinal()] = 8;
            } catch (NoSuchFieldError unused12) {
            }
            try {
                f172a[e.d.NONE.ordinal()] = 9;
            } catch (NoSuchFieldError unused13) {
            }
        }
    }

    /* compiled from: ConstraintWidget.java */
    /* loaded from: classes.dex */
    public enum b {
        FIXED,
        WRAP_CONTENT,
        MATCH_CONSTRAINT,
        MATCH_PARENT
    }

    public f() {
        b bVar = b.FIXED;
        this.C = new b[]{bVar, bVar};
        this.D = null;
        this.E = 0;
        this.F = 0;
        this.G = 0.0f;
        this.H = -1;
        this.I = 0;
        this.J = 0;
        this.K = 0;
        this.L = 0;
        this.M = 0;
        this.N = 0;
        this.O = 0;
        this.P = 0;
        this.Q = 0;
        float f2 = j0;
        this.V = f2;
        this.W = f2;
        this.Y = 0;
        this.Z = null;
        this.a0 = null;
        this.b0 = false;
        this.c0 = false;
        this.d0 = false;
        this.e0 = 0;
        this.f0 = 0;
        this.g0 = new float[]{-1.0f, -1.0f};
        this.h0 = new f[]{null, null};
        this.i0 = new f[]{null, null};
        a();
    }

    public boolean A() {
        e eVar = this.s;
        e eVar2 = eVar.f140d;
        if (eVar2 == null || eVar2.f140d != eVar) {
            e eVar3 = this.u;
            e eVar4 = eVar3.f140d;
            return eVar4 != null && eVar4.f140d == eVar3;
        }
        return true;
    }

    public boolean B() {
        e eVar = this.t;
        e eVar2 = eVar.f140d;
        if (eVar2 == null || eVar2.f140d != eVar) {
            e eVar3 = this.v;
            e eVar4 = eVar3.f140d;
            return eVar4 != null && eVar4.f140d == eVar3;
        }
        return true;
    }

    public boolean C() {
        return this.f168f == 0 && this.G == 0.0f && this.k == 0 && this.l == 0 && this.C[1] == b.MATCH_CONSTRAINT;
    }

    public boolean D() {
        return this.f167e == 0 && this.G == 0.0f && this.f170h == 0 && this.f171i == 0 && this.C[0] == b.MATCH_CONSTRAINT;
    }

    public void E() {
        this.s.j();
        this.t.j();
        this.u.j();
        this.v.j();
        this.w.j();
        this.x.j();
        this.y.j();
        this.z.j();
        this.D = null;
        this.r = 0.0f;
        this.E = 0;
        this.F = 0;
        this.G = 0.0f;
        this.H = -1;
        this.I = 0;
        this.J = 0;
        this.M = 0;
        this.N = 0;
        this.O = 0;
        this.P = 0;
        this.Q = 0;
        this.R = 0;
        this.S = 0;
        this.T = 0;
        this.U = 0;
        float f2 = j0;
        this.V = f2;
        this.W = f2;
        b[] bVarArr = this.C;
        b bVar = b.FIXED;
        bVarArr[0] = bVar;
        bVarArr[1] = bVar;
        this.X = null;
        this.Y = 0;
        this.a0 = null;
        this.e0 = 0;
        this.f0 = 0;
        float[] fArr = this.g0;
        fArr[0] = -1.0f;
        fArr[1] = -1.0f;
        this.f163a = -1;
        this.f164b = -1;
        int[] iArr = this.q;
        iArr[0] = Integer.MAX_VALUE;
        iArr[1] = Integer.MAX_VALUE;
        this.f167e = 0;
        this.f168f = 0;
        this.j = 1.0f;
        this.m = 1.0f;
        this.f171i = Integer.MAX_VALUE;
        this.l = Integer.MAX_VALUE;
        this.f170h = 0;
        this.k = 0;
        this.n = -1;
        this.o = 1.0f;
        n nVar = this.f165c;
        if (nVar != null) {
            nVar.d();
        }
        n nVar2 = this.f166d;
        if (nVar2 != null) {
            nVar2.d();
        }
        this.p = null;
        this.b0 = false;
        this.c0 = false;
        this.d0 = false;
    }

    public void F() {
        f l = l();
        if (l != null && (l instanceof g) && ((g) l()).O()) {
            return;
        }
        int size = this.B.size();
        for (int i2 = 0; i2 < size; i2++) {
            this.B.get(i2).j();
        }
    }

    public void G() {
        for (int i2 = 0; i2 < 6; i2++) {
            this.A[i2].d().d();
        }
    }

    public void H() {
    }

    public void I() {
        int i2 = this.I;
        int i3 = this.J;
        this.M = i2;
        this.N = i3;
    }

    public void J() {
        for (int i2 = 0; i2 < 6; i2++) {
            this.A[i2].d().g();
        }
    }

    public void a(int i2) {
        k.a(i2, this);
    }

    public void a(boolean z) {
    }

    public void b(a.b.b.h.e eVar) {
        eVar.a(this.s);
        eVar.a(this.t);
        eVar.a(this.u);
        eVar.a(this.v);
        if (this.Q > 0) {
            eVar.a(this.w);
        }
    }

    public void b(boolean z) {
    }

    public ArrayList<e> c() {
        return this.B;
    }

    public int d(int i2) {
        if (i2 == 0) {
            return t();
        }
        if (i2 == 1) {
            return j();
        }
        return 0;
    }

    public int e() {
        return x() + this.F;
    }

    public Object f() {
        return this.X;
    }

    public String g() {
        return this.Z;
    }

    public int h() {
        return this.M + this.O;
    }

    public int i() {
        return this.N + this.P;
    }

    public void j(int i2) {
        this.q[1] = i2;
    }

    public void k(int i2) {
        this.q[0] = i2;
    }

    public f l() {
        return this.D;
    }

    public n m() {
        if (this.f166d == null) {
            this.f166d = new n();
        }
        return this.f166d;
    }

    public n n() {
        if (this.f165c == null) {
            this.f165c = new n();
        }
        return this.f165c;
    }

    public void o(int i2) {
        this.Y = i2;
    }

    public int p() {
        return this.I + this.O;
    }

    public int q() {
        return this.J + this.P;
    }

    public void r(int i2) {
        this.T = i2;
    }

    public int s() {
        return this.Y;
    }

    public int t() {
        if (this.Y == 8) {
            return 0;
        }
        return this.E;
    }

    public String toString() {
        String str;
        StringBuilder sb = new StringBuilder();
        String str2 = "";
        if (this.a0 != null) {
            str = "type: " + this.a0 + " ";
        } else {
            str = "";
        }
        sb.append(str);
        if (this.Z != null) {
            str2 = "id: " + this.Z + " ";
        }
        sb.append(str2);
        sb.append("(");
        sb.append(this.I);
        sb.append(", ");
        sb.append(this.J);
        sb.append(") - (");
        sb.append(this.E);
        sb.append(" x ");
        sb.append(this.F);
        sb.append(") wrap: (");
        sb.append(this.T);
        sb.append(" x ");
        sb.append(this.U);
        sb.append(")");
        return sb.toString();
    }

    public int u() {
        return this.U;
    }

    public int v() {
        return this.T;
    }

    public int w() {
        return this.I;
    }

    public int x() {
        return this.J;
    }

    public boolean y() {
        return this.Q > 0;
    }

    public boolean z() {
        return this.s.d().f199b == 1 && this.u.d().f199b == 1 && this.t.d().f199b == 1 && this.v.d().f199b == 1;
    }

    public void a(a.b.b.h.c cVar) {
        this.s.a(cVar);
        this.t.a(cVar);
        this.u.a(cVar);
        this.v.a(cVar);
        this.w.a(cVar);
        this.z.a(cVar);
        this.x.a(cVar);
        this.y.a(cVar);
    }

    public void c(int i2, int i3) {
        this.I = i2;
        this.J = i3;
    }

    public void e(int i2, int i3) {
        this.J = i2;
        this.F = i3 - i2;
        int i4 = this.F;
        int i5 = this.S;
        if (i4 < i5) {
            this.F = i5;
        }
    }

    public final boolean f(int i2) {
        int i3 = i2 * 2;
        e[] eVarArr = this.A;
        if (eVarArr[i3].f140d != null && eVarArr[i3].f140d.f140d != eVarArr[i3]) {
            int i4 = i3 + 1;
            if (eVarArr[i4].f140d != null && eVarArr[i4].f140d.f140d == eVarArr[i4]) {
                return true;
            }
        }
        return false;
    }

    public void g(int i2) {
        this.Q = i2;
    }

    public void h(int i2) {
        this.F = i2;
        int i3 = this.F;
        int i4 = this.S;
        if (i3 < i4) {
            this.F = i4;
        }
    }

    public void i(int i2) {
        this.e0 = i2;
    }

    public int j() {
        if (this.Y == 8) {
            return 0;
        }
        return this.F;
    }

    public b k() {
        return this.C[0];
    }

    public void l(int i2) {
        if (i2 < 0) {
            this.S = 0;
        } else {
            this.S = i2;
        }
    }

    public int o() {
        return w() + this.E;
    }

    public void p(int i2) {
        this.E = i2;
        int i3 = this.E;
        int i4 = this.R;
        if (i3 < i4) {
            this.E = i4;
        }
    }

    public void q(int i2) {
        this.U = i2;
    }

    public b r() {
        return this.C[1];
    }

    public void s(int i2) {
        this.I = i2;
    }

    public int d() {
        return this.Q;
    }

    public void t(int i2) {
        this.J = i2;
    }

    public void c(float f2) {
        this.W = f2;
    }

    public void d(int i2, int i3) {
        if (i3 == 0) {
            this.K = i2;
        } else if (i3 == 1) {
            this.L = i2;
        }
    }

    public void m(int i2) {
        if (i2 < 0) {
            this.R = 0;
        } else {
            this.R = i2;
        }
    }

    public void n(int i2) {
        this.f0 = i2;
    }

    public b c(int i2) {
        if (i2 == 0) {
            return k();
        }
        if (i2 == 1) {
            return r();
        }
        return null;
    }

    public void d(float f2) {
        this.g0[1] = f2;
    }

    public int e(int i2) {
        if (i2 == 0) {
            return this.K;
        }
        if (i2 == 1) {
            return this.L;
        }
        return 0;
    }

    public float b(int i2) {
        if (i2 == 0) {
            return this.V;
        }
        if (i2 == 1) {
            return this.W;
        }
        return -1.0f;
    }

    public void c(a.b.b.h.e eVar) {
        int b2 = eVar.b(this.s);
        int b3 = eVar.b(this.t);
        int b4 = eVar.b(this.u);
        int b5 = eVar.b(this.v);
        int i2 = b5 - b3;
        if (b4 - b2 < 0 || i2 < 0 || b2 == Integer.MIN_VALUE || b2 == Integer.MAX_VALUE || b3 == Integer.MIN_VALUE || b3 == Integer.MAX_VALUE || b4 == Integer.MIN_VALUE || b4 == Integer.MAX_VALUE || b5 == Integer.MIN_VALUE || b5 == Integer.MAX_VALUE) {
            b5 = 0;
            b2 = 0;
            b3 = 0;
            b4 = 0;
        }
        a(b2, b3, b4, b5);
    }

    public void b(int i2, int i3) {
        this.O = i2;
        this.P = i3;
    }

    public final void a() {
        this.B.add(this.s);
        this.B.add(this.t);
        this.B.add(this.u);
        this.B.add(this.v);
        this.B.add(this.x);
        this.B.add(this.y);
        this.B.add(this.z);
        this.B.add(this.w);
    }

    public void b(int i2, int i3, int i4, float f2) {
        this.f168f = i2;
        this.k = i3;
        this.l = i4;
        this.m = f2;
        if (f2 >= 1.0f || this.f168f != 0) {
            return;
        }
        this.f168f = 2;
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:38:0x0084 -> B:39:0x0085). Please submit an issue!!! */
    public void b(String str) {
        float f2;
        int i2 = 0;
        if (str != null && str.length() != 0) {
            int i3 = -1;
            int length = str.length();
            int indexOf = str.indexOf(44);
            int i4 = 0;
            if (indexOf > 0 && indexOf < length - 1) {
                String substring = str.substring(0, indexOf);
                if (substring.equalsIgnoreCase("W")) {
                    i3 = 0;
                } else if (substring.equalsIgnoreCase("H")) {
                    i3 = 1;
                }
                i4 = indexOf + 1;
            }
            int indexOf2 = str.indexOf(58);
            if (indexOf2 >= 0 && indexOf2 < length - 1) {
                String substring2 = str.substring(i4, indexOf2);
                String substring3 = str.substring(indexOf2 + 1);
                if (substring2.length() > 0 && substring3.length() > 0) {
                    float parseFloat = Float.parseFloat(substring2);
                    float parseFloat2 = Float.parseFloat(substring3);
                    if (parseFloat > 0.0f && parseFloat2 > 0.0f) {
                        if (i3 == 1) {
                            f2 = Math.abs(parseFloat2 / parseFloat);
                        } else {
                            f2 = Math.abs(parseFloat / parseFloat2);
                        }
                    }
                }
                f2 = 0.0f;
            } else {
                String substring4 = str.substring(i4);
                if (substring4.length() > 0) {
                    f2 = Float.parseFloat(substring4);
                }
                f2 = 0.0f;
            }
            i2 = (f2 > i2 ? 1 : (f2 == i2 ? 0 : -1));
            if (i2 > 0) {
                this.G = f2;
                this.H = i3;
                return;
            }
            return;
        }
        this.G = 0.0f;
    }

    public void a(f fVar) {
        this.D = fVar;
    }

    public void a(f fVar, float f2, int i2) {
        e.d dVar = e.d.CENTER;
        a(dVar, fVar, dVar, i2, 0);
        this.r = f2;
    }

    public void a(String str) {
        this.Z = str;
    }

    public void a(int i2, int i3, int i4, float f2) {
        this.f167e = i2;
        this.f170h = i3;
        this.f171i = i4;
        this.j = f2;
        if (f2 >= 1.0f || this.f167e != 0) {
            return;
        }
        this.f167e = 2;
    }

    public void a(float f2) {
        this.V = f2;
    }

    public void a(int i2, int i3, int i4, int i5) {
        int i6;
        int i7;
        int i8 = i4 - i2;
        int i9 = i5 - i3;
        this.I = i2;
        this.J = i3;
        if (this.Y == 8) {
            this.E = 0;
            this.F = 0;
            return;
        }
        if (this.C[0] != b.FIXED || i8 >= (i6 = this.E)) {
            i6 = i8;
        }
        if (this.C[1] != b.FIXED || i9 >= (i7 = this.F)) {
            i7 = i9;
        }
        this.E = i6;
        this.F = i7;
        int i10 = this.F;
        int i11 = this.S;
        if (i10 < i11) {
            this.F = i11;
        }
        int i12 = this.E;
        int i13 = this.R;
        if (i12 < i13) {
            this.E = i13;
        }
        this.c0 = true;
    }

    public void b(float f2) {
        this.g0[0] = f2;
    }

    public boolean b() {
        return this.Y != 8;
    }

    public void b(b bVar) {
        this.C[1] = bVar;
        if (bVar == b.WRAP_CONTENT) {
            h(this.U);
        }
    }

    public void a(int i2, int i3, int i4) {
        if (i4 == 0) {
            a(i2, i3);
        } else if (i4 == 1) {
            e(i2, i3);
        }
        this.c0 = true;
    }

    public void a(int i2, int i3) {
        this.I = i2;
        this.E = i3 - i2;
        int i4 = this.E;
        int i5 = this.R;
        if (i4 < i5) {
            this.E = i5;
        }
    }

    public void a(Object obj) {
        this.X = obj;
    }

    public void a(e.d dVar, f fVar, e.d dVar2, int i2, int i3) {
        a(dVar).a(fVar.a(dVar2), i2, i3, e.c.STRONG, 0, true);
    }

    public e a(e.d dVar) {
        switch (a.f172a[dVar.ordinal()]) {
            case 1:
                return this.s;
            case 2:
                return this.t;
            case 3:
                return this.u;
            case 4:
                return this.v;
            case 5:
                return this.w;
            case 6:
                return this.z;
            case 7:
                return this.x;
            case 8:
                return this.y;
            case 9:
                return null;
            default:
                throw new AssertionError(dVar.name());
        }
    }

    public void a(b bVar) {
        this.C[0] = bVar;
        if (bVar == b.WRAP_CONTENT) {
            p(this.T);
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
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void a(a.b.b.h.e r39) {
        /*
            Method dump skipped, instructions count: 844
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: a.b.b.h.j.f.a(a.b.b.h.e):void");
    }

    public void a(boolean z, boolean z2, boolean z3, boolean z4) {
        if (this.n == -1) {
            if (z3 && !z4) {
                this.n = 0;
            } else if (!z3 && z4) {
                this.n = 1;
                if (this.H == -1) {
                    this.o = 1.0f / this.o;
                }
            }
        }
        if (this.n == 0 && (!this.t.i() || !this.v.i())) {
            this.n = 1;
        } else if (this.n == 1 && (!this.s.i() || !this.u.i())) {
            this.n = 0;
        }
        if (this.n == -1 && (!this.t.i() || !this.v.i() || !this.s.i() || !this.u.i())) {
            if (this.t.i() && this.v.i()) {
                this.n = 0;
            } else if (this.s.i() && this.u.i()) {
                this.o = 1.0f / this.o;
                this.n = 1;
            }
        }
        if (this.n == -1) {
            if (z && !z2) {
                this.n = 0;
            } else if (!z && z2) {
                this.o = 1.0f / this.o;
                this.n = 1;
            }
        }
        if (this.n == -1) {
            if (this.f170h > 0 && this.k == 0) {
                this.n = 0;
            } else if (this.f170h == 0 && this.k > 0) {
                this.o = 1.0f / this.o;
                this.n = 1;
            }
        }
        if (this.n == -1 && z && z2) {
            this.o = 1.0f / this.o;
            this.n = 1;
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
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void a(a.b.b.h.e r26, boolean r27, a.b.b.h.i r28, a.b.b.h.i r29, a.b.b.h.j.f.b r30, boolean r31, a.b.b.h.j.e r32, a.b.b.h.j.e r33, int r34, int r35, int r36, int r37, float r38, boolean r39, boolean r40, int r41, int r42, int r43, float r44, boolean r45) {
        /*
            Method dump skipped, instructions count: 827
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: a.b.b.h.j.f.a(a.b.b.h.e, boolean, a.b.b.h.i, a.b.b.h.i, a.b.b.h.j.f$b, boolean, a.b.b.h.j.e, a.b.b.h.j.e, int, int, int, int, float, boolean, boolean, int, int, int, float, boolean):void");
    }
}
