package a.b.b.h.j;

import a.b.b.h.j.f;
import java.util.ArrayList;
/* compiled from: Barrier.java */
/* loaded from: classes.dex */
public class b extends j {
    public int m0 = 0;
    public ArrayList<m> n0 = new ArrayList<>(4);
    public boolean o0 = true;

    @Override // a.b.b.h.j.f
    public void G() {
        super.G();
        this.n0.clear();
    }

    @Override // a.b.b.h.j.f
    public void H() {
        m d2;
        float f2;
        m mVar;
        int i2 = this.m0;
        float f3 = Float.MAX_VALUE;
        if (i2 != 0) {
            if (i2 == 1) {
                d2 = this.u.d();
            } else if (i2 == 2) {
                d2 = this.t.d();
            } else if (i2 != 3) {
                return;
            } else {
                d2 = this.v.d();
            }
            f3 = 0.0f;
        } else {
            d2 = this.s.d();
        }
        int size = this.n0.size();
        m mVar2 = null;
        for (int i3 = 0; i3 < size; i3++) {
            m mVar3 = this.n0.get(i3);
            if (mVar3.f199b != 1) {
                return;
            }
            int i4 = this.m0;
            if (i4 != 0 && i4 != 2) {
                f2 = mVar3.f194g;
                if (f2 > f3) {
                    mVar = mVar3.f193f;
                    mVar2 = mVar;
                    f3 = f2;
                }
            } else {
                f2 = mVar3.f194g;
                if (f2 < f3) {
                    mVar = mVar3.f193f;
                    mVar2 = mVar;
                    f3 = f2;
                }
            }
        }
        if (a.b.b.h.e.j() != null) {
            a.b.b.h.e.j().y++;
        }
        d2.f193f = mVar2;
        d2.f194g = f3;
        d2.a();
        int i5 = this.m0;
        if (i5 == 0) {
            this.u.d().a(mVar2, f3);
        } else if (i5 == 1) {
            this.s.d().a(mVar2, f3);
        } else if (i5 == 2) {
            this.v.d().a(mVar2, f3);
        } else if (i5 == 3) {
            this.t.d().a(mVar2, f3);
        }
    }

    @Override // a.b.b.h.j.f
    public void a(int i2) {
        m d2;
        m d3;
        f fVar = this.D;
        if (fVar != null && ((g) fVar).u(2)) {
            int i3 = this.m0;
            if (i3 == 0) {
                d2 = this.s.d();
            } else if (i3 == 1) {
                d2 = this.u.d();
            } else if (i3 == 2) {
                d2 = this.t.d();
            } else if (i3 != 3) {
                return;
            } else {
                d2 = this.v.d();
            }
            d2.b(5);
            int i4 = this.m0;
            if (i4 != 0 && i4 != 1) {
                this.s.d().a((m) null, 0.0f);
                this.u.d().a((m) null, 0.0f);
            } else {
                this.t.d().a((m) null, 0.0f);
                this.v.d().a((m) null, 0.0f);
            }
            this.n0.clear();
            for (int i5 = 0; i5 < this.l0; i5++) {
                f fVar2 = this.k0[i5];
                if (this.o0 || fVar2.b()) {
                    int i6 = this.m0;
                    if (i6 == 0) {
                        d3 = fVar2.s.d();
                    } else if (i6 == 1) {
                        d3 = fVar2.u.d();
                    } else if (i6 != 2) {
                        d3 = i6 != 3 ? null : fVar2.v.d();
                    } else {
                        d3 = fVar2.t.d();
                    }
                    if (d3 != null) {
                        this.n0.add(d3);
                        d3.a(d2);
                    }
                }
            }
        }
    }

    @Override // a.b.b.h.j.f
    public boolean b() {
        return true;
    }

    public void c(boolean z) {
        this.o0 = z;
    }

    public void u(int i2) {
        this.m0 = i2;
    }

    @Override // a.b.b.h.j.f
    public void a(a.b.b.h.e eVar) {
        Object[] objArr;
        boolean z;
        int i2;
        int i3;
        e[] eVarArr = this.A;
        eVarArr[0] = this.s;
        eVarArr[2] = this.t;
        eVarArr[1] = this.u;
        eVarArr[3] = this.v;
        int i4 = 0;
        while (true) {
            objArr = this.A;
            if (i4 >= objArr.length) {
                break;
            }
            objArr[i4].f145i = eVar.a(objArr[i4]);
            i4++;
        }
        int i5 = this.m0;
        if (i5 < 0 || i5 >= 4) {
            return;
        }
        e eVar2 = objArr[i5];
        for (int i6 = 0; i6 < this.l0; i6++) {
            f fVar = this.k0[i6];
            if ((this.o0 || fVar.b()) && ((((i2 = this.m0) == 0 || i2 == 1) && fVar.k() == f.b.MATCH_CONSTRAINT) || (((i3 = this.m0) == 2 || i3 == 3) && fVar.r() == f.b.MATCH_CONSTRAINT))) {
                z = true;
                break;
            }
        }
        z = false;
        int i7 = this.m0;
        if (i7 == 0 || i7 == 1 ? l().k() == f.b.WRAP_CONTENT : l().r() == f.b.WRAP_CONTENT) {
            z = false;
        }
        for (int i8 = 0; i8 < this.l0; i8++) {
            f fVar2 = this.k0[i8];
            if (this.o0 || fVar2.b()) {
                a.b.b.h.i a2 = eVar.a(fVar2.A[this.m0]);
                e[] eVarArr2 = fVar2.A;
                int i9 = this.m0;
                eVarArr2[i9].f145i = a2;
                if (i9 != 0 && i9 != 2) {
                    eVar.a(eVar2.f145i, a2, z);
                } else {
                    eVar.b(eVar2.f145i, a2, z);
                }
            }
        }
        int i10 = this.m0;
        if (i10 == 0) {
            eVar.a(this.u.f145i, this.s.f145i, 0, 6);
            if (z) {
                return;
            }
            eVar.a(this.s.f145i, this.D.u.f145i, 0, 5);
        } else if (i10 == 1) {
            eVar.a(this.s.f145i, this.u.f145i, 0, 6);
            if (z) {
                return;
            }
            eVar.a(this.s.f145i, this.D.s.f145i, 0, 5);
        } else if (i10 == 2) {
            eVar.a(this.v.f145i, this.t.f145i, 0, 6);
            if (z) {
                return;
            }
            eVar.a(this.t.f145i, this.D.v.f145i, 0, 5);
        } else if (i10 == 3) {
            eVar.a(this.t.f145i, this.v.f145i, 0, 6);
            if (z) {
                return;
            }
            eVar.a(this.t.f145i, this.D.t.f145i, 0, 5);
        }
    }
}
