package p000a.p006b.p008b.p009h;

import java.util.Arrays;
import java.util.HashMap;
import p000a.p006b.p008b.p009h.SolverVariable;
import p000a.p006b.p008b.p009h.p010j.ConstraintAnchor;
import p000a.p006b.p008b.p009h.p010j.ConstraintWidget;

/* renamed from: a.b.b.h.e */
/* loaded from: classes.dex */
public class LinearSystem {

    /* renamed from: p */
    public static int f172p = 1000;

    /* renamed from: q */
    public static Metrics f173q;

    /* renamed from: c */
    public InterfaceC0024a f176c;

    /* renamed from: e */
    public int f178e;

    /* renamed from: f */
    public ArrayRow[] f179f;

    /* renamed from: g */
    public boolean f180g;

    /* renamed from: h */
    public boolean[] f181h;

    /* renamed from: i */
    public int f182i;

    /* renamed from: j */
    public int f183j;

    /* renamed from: k */
    public int f184k;

    /* renamed from: l */
    public final Cache f185l;

    /* renamed from: m */
    public SolverVariable[] f186m;

    /* renamed from: n */
    public int f187n;

    /* renamed from: o */
    public final InterfaceC0024a f188o;

    /* renamed from: a */
    public int f174a = 0;

    /* renamed from: b */
    public HashMap<String, SolverVariable> f175b = null;

    /* renamed from: d */
    public int f177d = 32;

    /* compiled from: LinearSystem.java */
    /* renamed from: a.b.b.h.e$a */
    /* loaded from: classes.dex */
    public interface InterfaceC0024a {
        /* renamed from: a */
        SolverVariable mo11169a(LinearSystem linearSystem, boolean[] zArr);

        /* renamed from: a */
        void mo11170a(InterfaceC0024a interfaceC0024a);

        /* renamed from: a */
        void mo11168a(SolverVariable solverVariable);

        void clear();

        SolverVariable getKey();
    }

    public LinearSystem() {
        int i = this.f177d;
        this.f178e = i;
        this.f179f = null;
        this.f180g = false;
        this.f181h = new boolean[i];
        this.f182i = 1;
        this.f183j = 0;
        this.f184k = i;
        this.f186m = new SolverVariable[f172p];
        this.f187n = 0;
        ArrayRow[] arrayRowArr = new ArrayRow[i];
        this.f179f = new ArrayRow[i];
        m11173h();
        this.f185l = new Cache();
        this.f176c = new GoalRow(this.f185l);
        this.f188o = new ArrayRow(this.f185l);
    }

    /* renamed from: j */
    public static Metrics m11171j() {
        return f173q;
    }

    /* renamed from: a */
    public SolverVariable m11188a(Object obj) {
        SolverVariable solverVariable = null;
        if (obj == null) {
            return null;
        }
        if (this.f182i + 1 >= this.f178e) {
            m11175f();
        }
        if (obj instanceof ConstraintAnchor) {
            ConstraintAnchor constraintAnchor = (ConstraintAnchor) obj;
            solverVariable = constraintAnchor.m11131e();
            if (solverVariable == null) {
                constraintAnchor.m11138a(this.f185l);
                solverVariable = constraintAnchor.m11131e();
            }
            int i = solverVariable.f220b;
            if (i == -1 || i > this.f174a || this.f185l.f171c[i] == null) {
                if (solverVariable.f220b != -1) {
                    solverVariable.m11164a();
                }
                this.f174a++;
                this.f182i++;
                int i2 = this.f174a;
                solverVariable.f220b = i2;
                solverVariable.f225g = SolverVariable.EnumC0026a.UNRESTRICTED;
                this.f185l.f171c[i2] = solverVariable;
            }
        }
        return solverVariable;
    }

    /* renamed from: b */
    public SolverVariable m11187b() {
        Metrics metrics = f173q;
        if (metrics != null) {
            metrics.f203n++;
        }
        if (this.f182i + 1 >= this.f178e) {
            m11175f();
        }
        SolverVariable m11195a = m11195a(SolverVariable.EnumC0026a.SLACK, (String) null);
        this.f174a++;
        this.f182i++;
        int i = this.f174a;
        m11195a.f220b = i;
        this.f185l.f171c[i] = m11195a;
        return m11195a;
    }

    /* renamed from: c */
    public ArrayRow m11181c() {
        ArrayRow mo11167a = this.f185l.f169a.mo11167a();
        if (mo11167a == null) {
            mo11167a = new ArrayRow(this.f185l);
        } else {
            mo11167a.m11205d();
        }
        SolverVariable.m11161b();
        return mo11167a;
    }

    /* renamed from: d */
    public SolverVariable m11178d() {
        Metrics metrics = f173q;
        if (metrics != null) {
            metrics.f202m++;
        }
        if (this.f182i + 1 >= this.f178e) {
            m11175f();
        }
        SolverVariable m11195a = m11195a(SolverVariable.EnumC0026a.SLACK, (String) null);
        this.f174a++;
        this.f182i++;
        int i = this.f174a;
        m11195a.f220b = i;
        this.f185l.f171c[i] = m11195a;
        return m11195a;
    }

    /* renamed from: e */
    public Cache m11176e() {
        return this.f185l;
    }

    /* renamed from: f */
    public final void m11175f() {
        this.f177d *= 2;
        this.f179f = (ArrayRow[]) Arrays.copyOf(this.f179f, this.f177d);
        Cache cache = this.f185l;
        cache.f171c = (SolverVariable[]) Arrays.copyOf(cache.f171c, this.f177d);
        int i = this.f177d;
        this.f181h = new boolean[i];
        this.f178e = i;
        this.f184k = i;
        Metrics metrics = f173q;
        if (metrics != null) {
            metrics.f193d++;
            metrics.f204o = Math.max(metrics.f204o, i);
            Metrics metrics2 = f173q;
            metrics2.f189A = metrics2.f204o;
        }
    }

    /* renamed from: g */
    public void m11174g() {
        Metrics metrics = f173q;
        if (metrics != null) {
            metrics.f194e++;
        }
        if (this.f180g) {
            Metrics metrics2 = f173q;
            if (metrics2 != null) {
                metrics2.f206q++;
            }
            boolean z = false;
            int i = 0;
            while (true) {
                if (i >= this.f183j) {
                    z = true;
                    break;
                } else if (!this.f179f[i].f168e) {
                    break;
                } else {
                    i++;
                }
            }
            if (!z) {
                m11185b(this.f176c);
                return;
            }
            Metrics metrics3 = f173q;
            if (metrics3 != null) {
                metrics3.f205p++;
            }
            m11202a();
            return;
        }
        m11185b(this.f176c);
    }

    /* renamed from: h */
    public final void m11173h() {
        int i = 0;
        while (true) {
            ArrayRow[] arrayRowArr = this.f179f;
            if (i >= arrayRowArr.length) {
                return;
            }
            ArrayRow arrayRow = arrayRowArr[i];
            if (arrayRow != null) {
                this.f185l.f169a.mo11166a(arrayRow);
            }
            this.f179f[i] = null;
            i++;
        }
    }

    /* renamed from: i */
    public void m11172i() {
        Cache cache;
        int i = 0;
        while (true) {
            cache = this.f185l;
            SolverVariable[] solverVariableArr = cache.f171c;
            if (i >= solverVariableArr.length) {
                break;
            }
            SolverVariable solverVariable = solverVariableArr[i];
            if (solverVariable != null) {
                solverVariable.m11164a();
            }
            i++;
        }
        cache.f170b.mo11165a(this.f186m, this.f187n);
        this.f187n = 0;
        Arrays.fill(this.f185l.f171c, (Object) null);
        HashMap<String, SolverVariable> hashMap = this.f175b;
        if (hashMap != null) {
            hashMap.clear();
        }
        this.f174a = 0;
        this.f176c.clear();
        this.f182i = 1;
        for (int i2 = 0; i2 < this.f183j; i2++) {
            this.f179f[i2].f166c = false;
        }
        m11173h();
        this.f183j = 0;
    }

    /* renamed from: c */
    public final void m11180c(ArrayRow arrayRow) {
        ArrayRow[] arrayRowArr = this.f179f;
        int i = this.f183j;
        if (arrayRowArr[i] != null) {
            this.f185l.f169a.mo11166a(arrayRowArr[i]);
        }
        ArrayRow[] arrayRowArr2 = this.f179f;
        int i2 = this.f183j;
        arrayRowArr2[i2] = arrayRow;
        SolverVariable solverVariable = arrayRow.f164a;
        solverVariable.f221c = i2;
        this.f183j = i2 + 1;
        solverVariable.m11159c(arrayRow);
    }

    /* renamed from: b */
    public final void m11186b(ArrayRow arrayRow) {
        arrayRow.m11220a(this, 0);
    }

    /* renamed from: d */
    public final void m11177d(ArrayRow arrayRow) {
        if (this.f183j > 0) {
            arrayRow.f167d.m11234a(arrayRow, this.f179f);
            if (arrayRow.f167d.f153a == 0) {
                arrayRow.f168e = true;
            }
        }
    }

    /* renamed from: b */
    public int m11182b(Object obj) {
        SolverVariable m11131e = ((ConstraintAnchor) obj).m11131e();
        if (m11131e != null) {
            return (int) (m11131e.f223e + 0.5f);
        }
        return 0;
    }

    /* renamed from: c */
    public void m11179c(SolverVariable solverVariable, SolverVariable solverVariable2, int i, int i2) {
        ArrayRow m11181c = m11181c();
        SolverVariable m11178d = m11178d();
        m11178d.f222d = 0;
        m11181c.m11210b(solverVariable, solverVariable2, m11178d, i);
        if (i2 != 6) {
            m11199a(m11181c, (int) (m11181c.f167d.m11224b(m11178d) * (-1.0f)), i2);
        }
        m11200a(m11181c);
    }

    /* renamed from: b */
    public void m11185b(InterfaceC0024a interfaceC0024a) {
        Metrics metrics = f173q;
        if (metrics != null) {
            metrics.f208s++;
            metrics.f209t = Math.max(metrics.f209t, this.f182i);
            Metrics metrics2 = f173q;
            metrics2.f210u = Math.max(metrics2.f210u, this.f183j);
        }
        m11177d((ArrayRow) interfaceC0024a);
        m11198a(interfaceC0024a);
        m11197a(interfaceC0024a, false);
        m11202a();
    }

    /* renamed from: a */
    public void m11199a(ArrayRow arrayRow, int i, int i2) {
        arrayRow.m11219a(m11201a(i2, (String) null), i);
    }

    /* renamed from: a */
    public SolverVariable m11201a(int i, String str) {
        Metrics metrics = f173q;
        if (metrics != null) {
            metrics.f201l++;
        }
        if (this.f182i + 1 >= this.f178e) {
            m11175f();
        }
        SolverVariable m11195a = m11195a(SolverVariable.EnumC0026a.ERROR, str);
        this.f174a++;
        this.f182i++;
        int i2 = this.f174a;
        m11195a.f220b = i2;
        m11195a.f222d = i;
        this.f185l.f171c[i2] = m11195a;
        this.f176c.mo11168a(m11195a);
        return m11195a;
    }

    /* renamed from: b */
    public void m11184b(SolverVariable solverVariable, SolverVariable solverVariable2, int i, int i2) {
        ArrayRow m11181c = m11181c();
        SolverVariable m11178d = m11178d();
        m11178d.f222d = 0;
        m11181c.m11215a(solverVariable, solverVariable2, m11178d, i);
        if (i2 != 6) {
            m11199a(m11181c, (int) (m11181c.f167d.m11224b(m11178d) * (-1.0f)), i2);
        }
        m11200a(m11181c);
    }

    /* renamed from: a */
    public final SolverVariable m11195a(SolverVariable.EnumC0026a enumC0026a, String str) {
        SolverVariable mo11167a = this.f185l.f170b.mo11167a();
        if (mo11167a == null) {
            mo11167a = new SolverVariable(enumC0026a, str);
            mo11167a.m11162a(enumC0026a, str);
        } else {
            mo11167a.m11164a();
            mo11167a.m11162a(enumC0026a, str);
        }
        int i = this.f187n;
        int i2 = f172p;
        if (i >= i2) {
            f172p = i2 * 2;
            this.f186m = (SolverVariable[]) Arrays.copyOf(this.f186m, f172p);
        }
        SolverVariable[] solverVariableArr = this.f186m;
        int i3 = this.f187n;
        this.f187n = i3 + 1;
        solverVariableArr[i3] = mo11167a;
        return mo11167a;
    }

    /* renamed from: b */
    public void m11183b(SolverVariable solverVariable, SolverVariable solverVariable2, boolean z) {
        ArrayRow m11181c = m11181c();
        SolverVariable m11178d = m11178d();
        m11178d.f222d = 0;
        m11181c.m11210b(solverVariable, solverVariable2, m11178d, 0);
        if (z) {
            m11199a(m11181c, (int) (m11181c.f167d.m11224b(m11178d) * (-1.0f)), 1);
        }
        m11200a(m11181c);
    }

    /* renamed from: a */
    public void m11200a(ArrayRow arrayRow) {
        SolverVariable m11207c;
        if (arrayRow == null) {
            return;
        }
        Metrics metrics = f173q;
        if (metrics != null) {
            metrics.f195f++;
            if (arrayRow.f168e) {
                metrics.f196g++;
            }
        }
        if (this.f183j + 1 >= this.f184k || this.f182i + 1 >= this.f178e) {
            m11175f();
        }
        boolean z = false;
        if (!arrayRow.f168e) {
            m11177d(arrayRow);
            if (arrayRow.m11208c()) {
                return;
            }
            arrayRow.m11223a();
            if (arrayRow.m11221a(this)) {
                SolverVariable m11187b = m11187b();
                arrayRow.f164a = m11187b;
                m11180c(arrayRow);
                this.f188o.mo11170a(arrayRow);
                m11197a(this.f188o, true);
                if (m11187b.f221c == -1) {
                    if (arrayRow.f164a == m11187b && (m11207c = arrayRow.m11207c(m11187b)) != null) {
                        Metrics metrics2 = f173q;
                        if (metrics2 != null) {
                            metrics2.f199j++;
                        }
                        arrayRow.m11204d(m11207c);
                    }
                    if (!arrayRow.f168e) {
                        arrayRow.f164a.m11159c(arrayRow);
                    }
                    this.f183j--;
                }
                z = true;
            }
            if (!arrayRow.m11213b()) {
                return;
            }
        }
        if (z) {
            return;
        }
        m11180c(arrayRow);
    }

    /* renamed from: a */
    public final int m11197a(InterfaceC0024a interfaceC0024a, boolean z) {
        Metrics metrics = f173q;
        if (metrics != null) {
            metrics.f197h++;
        }
        for (int i = 0; i < this.f182i; i++) {
            this.f181h[i] = false;
        }
        boolean z2 = false;
        int i2 = 0;
        while (!z2) {
            Metrics metrics2 = f173q;
            if (metrics2 != null) {
                metrics2.f198i++;
            }
            i2++;
            if (i2 >= this.f182i * 2) {
                return i2;
            }
            if (interfaceC0024a.getKey() != null) {
                this.f181h[interfaceC0024a.getKey().f220b] = true;
            }
            SolverVariable mo11169a = interfaceC0024a.mo11169a(this, this.f181h);
            if (mo11169a != null) {
                boolean[] zArr = this.f181h;
                int i3 = mo11169a.f220b;
                if (zArr[i3]) {
                    return i2;
                }
                zArr[i3] = true;
            }
            if (mo11169a != null) {
                int i4 = -1;
                float f = Float.MAX_VALUE;
                for (int i5 = 0; i5 < this.f183j; i5++) {
                    ArrayRow arrayRow = this.f179f[i5];
                    if (arrayRow.f164a.f225g != SolverVariable.EnumC0026a.UNRESTRICTED && !arrayRow.f168e && arrayRow.m11212b(mo11169a)) {
                        float m11224b = arrayRow.f167d.m11224b(mo11169a);
                        if (m11224b < 0.0f) {
                            float f2 = (-arrayRow.f165b) / m11224b;
                            if (f2 < f) {
                                i4 = i5;
                                f = f2;
                            }
                        }
                    }
                }
                if (i4 > -1) {
                    ArrayRow arrayRow2 = this.f179f[i4];
                    arrayRow2.f164a.f221c = -1;
                    Metrics metrics3 = f173q;
                    if (metrics3 != null) {
                        metrics3.f199j++;
                    }
                    arrayRow2.m11204d(mo11169a);
                    SolverVariable solverVariable = arrayRow2.f164a;
                    solverVariable.f221c = i4;
                    solverVariable.m11159c(arrayRow2);
                }
            }
            z2 = true;
        }
        return i2;
    }

    /* renamed from: a */
    public final int m11198a(InterfaceC0024a interfaceC0024a) {
        float f;
        boolean z;
        int i = 0;
        while (true) {
            f = 0.0f;
            if (i >= this.f183j) {
                z = false;
                break;
            }
            ArrayRow[] arrayRowArr = this.f179f;
            if (arrayRowArr[i].f164a.f225g != SolverVariable.EnumC0026a.UNRESTRICTED && arrayRowArr[i].f165b < 0.0f) {
                z = true;
                break;
            }
            i++;
        }
        if (z) {
            boolean z2 = false;
            int i2 = 0;
            while (!z2) {
                Metrics metrics = f173q;
                if (metrics != null) {
                    metrics.f200k++;
                }
                i2++;
                int i3 = 0;
                int i4 = -1;
                int i5 = -1;
                float f2 = Float.MAX_VALUE;
                int i6 = 0;
                while (i3 < this.f183j) {
                    ArrayRow arrayRow = this.f179f[i3];
                    if (arrayRow.f164a.f225g != SolverVariable.EnumC0026a.UNRESTRICTED && !arrayRow.f168e && arrayRow.f165b < f) {
                        int i7 = 1;
                        while (i7 < this.f182i) {
                            SolverVariable solverVariable = this.f185l.f171c[i7];
                            float m11224b = arrayRow.f167d.m11224b(solverVariable);
                            if (m11224b > f) {
                                int i8 = i6;
                                float f3 = f2;
                                int i9 = i5;
                                int i10 = i4;
                                for (int i11 = 0; i11 < 7; i11++) {
                                    float f4 = solverVariable.f224f[i11] / m11224b;
                                    if ((f4 < f3 && i11 == i8) || i11 > i8) {
                                        i9 = i7;
                                        i10 = i3;
                                        f3 = f4;
                                        i8 = i11;
                                    }
                                }
                                i4 = i10;
                                i5 = i9;
                                f2 = f3;
                                i6 = i8;
                            }
                            i7++;
                            f = 0.0f;
                        }
                    }
                    i3++;
                    f = 0.0f;
                }
                if (i4 != -1) {
                    ArrayRow arrayRow2 = this.f179f[i4];
                    arrayRow2.f164a.f221c = -1;
                    Metrics metrics2 = f173q;
                    if (metrics2 != null) {
                        metrics2.f199j++;
                    }
                    arrayRow2.m11204d(this.f185l.f171c[i5]);
                    SolverVariable solverVariable2 = arrayRow2.f164a;
                    solverVariable2.f221c = i4;
                    solverVariable2.m11159c(arrayRow2);
                } else {
                    z2 = true;
                }
                if (i2 > this.f182i / 2) {
                    z2 = true;
                }
                f = 0.0f;
            }
            return i2;
        }
        return 0;
    }

    /* renamed from: a */
    public final void m11202a() {
        for (int i = 0; i < this.f183j; i++) {
            ArrayRow arrayRow = this.f179f[i];
            arrayRow.f164a.f223e = arrayRow.f165b;
        }
    }

    /* renamed from: a */
    public void m11190a(SolverVariable solverVariable, SolverVariable solverVariable2, boolean z) {
        ArrayRow m11181c = m11181c();
        SolverVariable m11178d = m11178d();
        m11178d.f222d = 0;
        m11181c.m11215a(solverVariable, solverVariable2, m11178d, 0);
        if (z) {
            m11199a(m11181c, (int) (m11181c.f167d.m11224b(m11178d) * (-1.0f)), 1);
        }
        m11200a(m11181c);
    }

    /* renamed from: a */
    public void m11193a(SolverVariable solverVariable, SolverVariable solverVariable2, int i, float f, SolverVariable solverVariable3, SolverVariable solverVariable4, int i2, int i3) {
        ArrayRow m11181c = m11181c();
        m11181c.m11217a(solverVariable, solverVariable2, i, f, solverVariable3, solverVariable4, i2);
        if (i3 != 6) {
            m11181c.m11220a(this, i3);
        }
        m11200a(m11181c);
    }

    /* renamed from: a */
    public void m11191a(SolverVariable solverVariable, SolverVariable solverVariable2, SolverVariable solverVariable3, SolverVariable solverVariable4, float f, int i) {
        ArrayRow m11181c = m11181c();
        m11181c.m11214a(solverVariable, solverVariable2, solverVariable3, solverVariable4, f);
        if (i != 6) {
            m11181c.m11220a(this, i);
        }
        m11200a(m11181c);
    }

    /* renamed from: a */
    public ArrayRow m11192a(SolverVariable solverVariable, SolverVariable solverVariable2, int i, int i2) {
        ArrayRow m11181c = m11181c();
        m11181c.m11218a(solverVariable, solverVariable2, i);
        if (i2 != 6) {
            m11181c.m11220a(this, i2);
        }
        m11200a(m11181c);
        return m11181c;
    }

    /* renamed from: a */
    public void m11194a(SolverVariable solverVariable, int i) {
        int i2 = solverVariable.f221c;
        if (i2 != -1) {
            ArrayRow arrayRow = this.f179f[i2];
            if (arrayRow.f168e) {
                arrayRow.f165b = i;
                return;
            } else if (arrayRow.f167d.f153a == 0) {
                arrayRow.f168e = true;
                arrayRow.f165b = i;
                return;
            } else {
                ArrayRow m11181c = m11181c();
                m11181c.m11206c(solverVariable, i);
                m11200a(m11181c);
                return;
            }
        }
        ArrayRow m11181c2 = m11181c();
        m11181c2.m11211b(solverVariable, i);
        m11200a(m11181c2);
    }

    /* renamed from: a */
    public static ArrayRow m11196a(LinearSystem linearSystem, SolverVariable solverVariable, SolverVariable solverVariable2, SolverVariable solverVariable3, float f, boolean z) {
        ArrayRow m11181c = linearSystem.m11181c();
        if (z) {
            linearSystem.m11186b(m11181c);
        }
        m11181c.m11216a(solverVariable, solverVariable2, solverVariable3, f);
        return m11181c;
    }

    /* renamed from: a */
    public void m11189a(ConstraintWidget constraintWidget, ConstraintWidget constraintWidget2, float f, int i) {
        SolverVariable m11188a = m11188a(constraintWidget.mo11020a(ConstraintAnchor.EnumC0031d.LEFT));
        SolverVariable m11188a2 = m11188a(constraintWidget.mo11020a(ConstraintAnchor.EnumC0031d.TOP));
        SolverVariable m11188a3 = m11188a(constraintWidget.mo11020a(ConstraintAnchor.EnumC0031d.RIGHT));
        SolverVariable m11188a4 = m11188a(constraintWidget.mo11020a(ConstraintAnchor.EnumC0031d.BOTTOM));
        SolverVariable m11188a5 = m11188a(constraintWidget2.mo11020a(ConstraintAnchor.EnumC0031d.LEFT));
        SolverVariable m11188a6 = m11188a(constraintWidget2.mo11020a(ConstraintAnchor.EnumC0031d.TOP));
        SolverVariable m11188a7 = m11188a(constraintWidget2.mo11020a(ConstraintAnchor.EnumC0031d.RIGHT));
        SolverVariable m11188a8 = m11188a(constraintWidget2.mo11020a(ConstraintAnchor.EnumC0031d.BOTTOM));
        ArrayRow m11181c = m11181c();
        double d = f;
        double d2 = i;
        m11181c.m11209b(m11188a2, m11188a4, m11188a6, m11188a8, (float) (Math.sin(d) * d2));
        m11200a(m11181c);
        ArrayRow m11181c2 = m11181c();
        m11181c2.m11209b(m11188a, m11188a3, m11188a5, m11188a7, (float) (Math.cos(d) * d2));
        m11200a(m11181c2);
    }
}
