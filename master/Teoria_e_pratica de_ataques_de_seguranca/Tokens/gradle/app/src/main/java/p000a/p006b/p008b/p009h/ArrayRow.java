package p000a.p006b.p008b.p009h;

import p000a.p006b.p008b.p009h.LinearSystem;
import p000a.p006b.p008b.p009h.SolverVariable;

/* renamed from: a.b.b.h.b */
/* loaded from: classes.dex */
public class ArrayRow implements LinearSystem.InterfaceC0024a {

    /* renamed from: c */
    public boolean f166c;

    /* renamed from: d */
    public final ArrayLinkedVariables f167d;

    /* renamed from: a */
    public SolverVariable f164a = null;

    /* renamed from: b */
    public float f165b = 0.0f;

    /* renamed from: e */
    public boolean f168e = false;

    public ArrayRow(Cache cache) {
        this.f167d = new ArrayLinkedVariables(this, cache);
    }

    /* renamed from: a */
    public ArrayRow m11218a(SolverVariable solverVariable, SolverVariable solverVariable2, int i) {
        boolean z = false;
        if (i != 0) {
            if (i < 0) {
                i *= -1;
                z = true;
            }
            this.f165b = i;
        }
        if (!z) {
            this.f167d.m11231a(solverVariable, -1.0f);
            this.f167d.m11231a(solverVariable2, 1.0f);
        } else {
            this.f167d.m11231a(solverVariable, 1.0f);
            this.f167d.m11231a(solverVariable2, -1.0f);
        }
        return this;
    }

    /* renamed from: b */
    public boolean m11213b() {
        SolverVariable solverVariable = this.f164a;
        return solverVariable != null && (solverVariable.f225g == SolverVariable.EnumC0026a.UNRESTRICTED || this.f165b >= 0.0f);
    }

    /* renamed from: c */
    public ArrayRow m11206c(SolverVariable solverVariable, int i) {
        if (i < 0) {
            this.f165b = i * (-1);
            this.f167d.m11231a(solverVariable, 1.0f);
        } else {
            this.f165b = i;
            this.f167d.m11231a(solverVariable, -1.0f);
        }
        return this;
    }

    @Override // p000a.p006b.p008b.p009h.LinearSystem.InterfaceC0024a
    public void clear() {
        this.f167d.m11238a();
        this.f164a = null;
        this.f165b = 0.0f;
    }

    /* renamed from: d */
    public void m11205d() {
        this.f164a = null;
        this.f167d.m11238a();
        this.f165b = 0.0f;
        this.f168e = false;
    }

    /* JADX WARN: Removed duplicated region for block: B:29:0x00be  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x00ce  */
    /* renamed from: e */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.String m11203e() {
        /*
            Method dump skipped, instructions count: 254
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: p000a.p006b.p008b.p009h.ArrayRow.m11203e():java.lang.String");
    }

    @Override // p000a.p006b.p008b.p009h.LinearSystem.InterfaceC0024a
    public SolverVariable getKey() {
        return this.f164a;
    }

    public String toString() {
        return m11203e();
    }

    /* renamed from: b */
    public boolean m11212b(SolverVariable solverVariable) {
        return this.f167d.m11232a(solverVariable);
    }

    /* renamed from: b */
    public ArrayRow m11211b(SolverVariable solverVariable, int i) {
        this.f164a = solverVariable;
        float f = i;
        solverVariable.f223e = f;
        this.f165b = f;
        this.f168e = true;
        return this;
    }

    /* renamed from: c */
    public SolverVariable m11207c(SolverVariable solverVariable) {
        return this.f167d.m11227a((boolean[]) null, solverVariable);
    }

    /* renamed from: d */
    public void m11204d(SolverVariable solverVariable) {
        SolverVariable solverVariable2 = this.f164a;
        if (solverVariable2 != null) {
            this.f167d.m11231a(solverVariable2, -1.0f);
            this.f164a = null;
        }
        float m11228a = this.f167d.m11228a(solverVariable, true) * (-1.0f);
        this.f164a = solverVariable;
        if (m11228a == 1.0f) {
            return;
        }
        this.f165b /= m11228a;
        this.f167d.m11237a(m11228a);
    }

    /* renamed from: a */
    public ArrayRow m11219a(SolverVariable solverVariable, int i) {
        this.f167d.m11231a(solverVariable, i);
        return this;
    }

    /* renamed from: c */
    public boolean m11208c() {
        return this.f164a == null && this.f165b == 0.0f && this.f167d.f153a == 0;
    }

    /* renamed from: a */
    public ArrayRow m11215a(SolverVariable solverVariable, SolverVariable solverVariable2, SolverVariable solverVariable3, int i) {
        boolean z = false;
        if (i != 0) {
            if (i < 0) {
                i *= -1;
                z = true;
            }
            this.f165b = i;
        }
        if (!z) {
            this.f167d.m11231a(solverVariable, -1.0f);
            this.f167d.m11231a(solverVariable2, 1.0f);
            this.f167d.m11231a(solverVariable3, 1.0f);
        } else {
            this.f167d.m11231a(solverVariable, 1.0f);
            this.f167d.m11231a(solverVariable2, -1.0f);
            this.f167d.m11231a(solverVariable3, -1.0f);
        }
        return this;
    }

    /* renamed from: b */
    public ArrayRow m11210b(SolverVariable solverVariable, SolverVariable solverVariable2, SolverVariable solverVariable3, int i) {
        boolean z = false;
        if (i != 0) {
            if (i < 0) {
                i *= -1;
                z = true;
            }
            this.f165b = i;
        }
        if (!z) {
            this.f167d.m11231a(solverVariable, -1.0f);
            this.f167d.m11231a(solverVariable2, 1.0f);
            this.f167d.m11231a(solverVariable3, -1.0f);
        } else {
            this.f167d.m11231a(solverVariable, 1.0f);
            this.f167d.m11231a(solverVariable2, -1.0f);
            this.f167d.m11231a(solverVariable3, 1.0f);
        }
        return this;
    }

    /* renamed from: a */
    public ArrayRow m11222a(float f, float f2, float f3, SolverVariable solverVariable, SolverVariable solverVariable2, SolverVariable solverVariable3, SolverVariable solverVariable4) {
        this.f165b = 0.0f;
        if (f2 == 0.0f || f == f3) {
            this.f167d.m11231a(solverVariable, 1.0f);
            this.f167d.m11231a(solverVariable2, -1.0f);
            this.f167d.m11231a(solverVariable4, 1.0f);
            this.f167d.m11231a(solverVariable3, -1.0f);
        } else if (f == 0.0f) {
            this.f167d.m11231a(solverVariable, 1.0f);
            this.f167d.m11231a(solverVariable2, -1.0f);
        } else if (f3 == 0.0f) {
            this.f167d.m11231a(solverVariable3, 1.0f);
            this.f167d.m11231a(solverVariable4, -1.0f);
        } else {
            float f4 = (f / f2) / (f3 / f2);
            this.f167d.m11231a(solverVariable, 1.0f);
            this.f167d.m11231a(solverVariable2, -1.0f);
            this.f167d.m11231a(solverVariable4, f4);
            this.f167d.m11231a(solverVariable3, -f4);
        }
        return this;
    }

    /* renamed from: b */
    public ArrayRow m11209b(SolverVariable solverVariable, SolverVariable solverVariable2, SolverVariable solverVariable3, SolverVariable solverVariable4, float f) {
        this.f167d.m11231a(solverVariable3, 0.5f);
        this.f167d.m11231a(solverVariable4, 0.5f);
        this.f167d.m11231a(solverVariable, -0.5f);
        this.f167d.m11231a(solverVariable2, -0.5f);
        this.f165b = -f;
        return this;
    }

    /* renamed from: a */
    public ArrayRow m11217a(SolverVariable solverVariable, SolverVariable solverVariable2, int i, float f, SolverVariable solverVariable3, SolverVariable solverVariable4, int i2) {
        if (solverVariable2 == solverVariable3) {
            this.f167d.m11231a(solverVariable, 1.0f);
            this.f167d.m11231a(solverVariable4, 1.0f);
            this.f167d.m11231a(solverVariable2, -2.0f);
            return this;
        }
        if (f == 0.5f) {
            this.f167d.m11231a(solverVariable, 1.0f);
            this.f167d.m11231a(solverVariable2, -1.0f);
            this.f167d.m11231a(solverVariable3, -1.0f);
            this.f167d.m11231a(solverVariable4, 1.0f);
            if (i > 0 || i2 > 0) {
                this.f165b = (-i) + i2;
            }
        } else if (f <= 0.0f) {
            this.f167d.m11231a(solverVariable, -1.0f);
            this.f167d.m11231a(solverVariable2, 1.0f);
            this.f165b = i;
        } else if (f >= 1.0f) {
            this.f167d.m11231a(solverVariable3, -1.0f);
            this.f167d.m11231a(solverVariable4, 1.0f);
            this.f165b = i2;
        } else {
            float f2 = 1.0f - f;
            this.f167d.m11231a(solverVariable, f2 * 1.0f);
            this.f167d.m11231a(solverVariable2, f2 * (-1.0f));
            this.f167d.m11231a(solverVariable3, (-1.0f) * f);
            this.f167d.m11231a(solverVariable4, 1.0f * f);
            if (i > 0 || i2 > 0) {
                this.f165b = ((-i) * f2) + (i2 * f);
            }
        }
        return this;
    }

    /* renamed from: a */
    public ArrayRow m11220a(LinearSystem linearSystem, int i) {
        this.f167d.m11231a(linearSystem.m11201a(i, "ep"), 1.0f);
        this.f167d.m11231a(linearSystem.m11201a(i, "em"), -1.0f);
        return this;
    }

    /* renamed from: a */
    public ArrayRow m11216a(SolverVariable solverVariable, SolverVariable solverVariable2, SolverVariable solverVariable3, float f) {
        this.f167d.m11231a(solverVariable, -1.0f);
        this.f167d.m11231a(solverVariable2, 1.0f - f);
        this.f167d.m11231a(solverVariable3, f);
        return this;
    }

    /* renamed from: a */
    public ArrayRow m11214a(SolverVariable solverVariable, SolverVariable solverVariable2, SolverVariable solverVariable3, SolverVariable solverVariable4, float f) {
        this.f167d.m11231a(solverVariable, -1.0f);
        this.f167d.m11231a(solverVariable2, 1.0f);
        this.f167d.m11231a(solverVariable3, f);
        this.f167d.m11231a(solverVariable4, -f);
        return this;
    }

    /* renamed from: a */
    public void m11223a() {
        float f = this.f165b;
        if (f < 0.0f) {
            this.f165b = f * (-1.0f);
            this.f167d.m11226b();
        }
    }

    /* renamed from: a */
    public boolean m11221a(LinearSystem linearSystem) {
        boolean z;
        SolverVariable m11233a = this.f167d.m11233a(linearSystem);
        if (m11233a == null) {
            z = true;
        } else {
            m11204d(m11233a);
            z = false;
        }
        if (this.f167d.f153a == 0) {
            this.f168e = true;
        }
        return z;
    }

    @Override // p000a.p006b.p008b.p009h.LinearSystem.InterfaceC0024a
    /* renamed from: a */
    public SolverVariable mo11169a(LinearSystem linearSystem, boolean[] zArr) {
        return this.f167d.m11227a(zArr, (SolverVariable) null);
    }

    @Override // p000a.p006b.p008b.p009h.LinearSystem.InterfaceC0024a
    /* renamed from: a */
    public void mo11170a(LinearSystem.InterfaceC0024a interfaceC0024a) {
        if (!(interfaceC0024a instanceof ArrayRow)) {
            return;
        }
        ArrayRow arrayRow = (ArrayRow) interfaceC0024a;
        this.f164a = null;
        this.f167d.m11238a();
        int i = 0;
        while (true) {
            ArrayLinkedVariables arrayLinkedVariables = arrayRow.f167d;
            if (i >= arrayLinkedVariables.f153a) {
                return;
            }
            this.f167d.m11230a(arrayLinkedVariables.m11236a(i), arrayRow.f167d.m11225b(i), true);
            i++;
        }
    }

    @Override // p000a.p006b.p008b.p009h.LinearSystem.InterfaceC0024a
    /* renamed from: a */
    public void mo11168a(SolverVariable solverVariable) {
        int i = solverVariable.f222d;
        float f = 1.0f;
        if (i != 1) {
            if (i == 2) {
                f = 1000.0f;
            } else if (i == 3) {
                f = 1000000.0f;
            } else if (i == 4) {
                f = 1.0E9f;
            } else if (i == 5) {
                f = 1.0E12f;
            }
        }
        this.f167d.m11231a(solverVariable, f);
    }
}
