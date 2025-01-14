package a.b.b.h.j;

import a.b.b.h.j.f;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* compiled from: Analyzer.java */
/* loaded from: classes.dex */
public class a {
    public static void a(g gVar) {
        if ((gVar.N() & 32) != 32) {
            b(gVar);
            return;
        }
        gVar.D0 = true;
        gVar.x0 = false;
        gVar.y0 = false;
        gVar.z0 = false;
        ArrayList<f> arrayList = gVar.k0;
        List<h> list = gVar.w0;
        boolean z = gVar.k() == f.b.WRAP_CONTENT;
        boolean z2 = gVar.r() == f.b.WRAP_CONTENT;
        boolean z3 = z || z2;
        list.clear();
        for (f fVar : arrayList) {
            fVar.p = null;
            fVar.d0 = false;
            fVar.G();
        }
        for (f fVar2 : arrayList) {
            if (fVar2.p == null && !a(fVar2, list, z3)) {
                b(gVar);
                gVar.D0 = false;
                return;
            }
        }
        int i2 = 0;
        int i3 = 0;
        for (h hVar : list) {
            i2 = Math.max(i2, a(hVar, 0));
            i3 = Math.max(i3, a(hVar, 1));
        }
        if (z) {
            gVar.a(f.b.FIXED);
            gVar.p(i2);
            gVar.x0 = true;
            gVar.y0 = true;
            gVar.A0 = i2;
        }
        if (z2) {
            gVar.b(f.b.FIXED);
            gVar.h(i3);
            gVar.x0 = true;
            gVar.z0 = true;
            gVar.B0 = i3;
        }
        a(list, 0, gVar.t());
        a(list, 1, gVar.j());
    }

    public static void b(g gVar) {
        gVar.w0.clear();
        gVar.w0.add(0, new h(gVar.k0));
    }

    public static boolean a(f fVar, List<h> list, boolean z) {
        h hVar = new h(new ArrayList(), true);
        list.add(hVar);
        return a(fVar, hVar, list, z);
    }

    /* JADX WARN: Code restructure failed: missing block: B:122:0x0181, code lost:
        if (r3.f138b == r4) goto L74;
     */
    /* JADX WARN: Code restructure failed: missing block: B:91:0x0128, code lost:
        if (r3.f138b == r4) goto L63;
     */
    /* JADX WARN: Removed duplicated region for block: B:117:0x0173  */
    /* JADX WARN: Removed duplicated region for block: B:134:0x01a0  */
    /* JADX WARN: Removed duplicated region for block: B:146:0x01c2  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static boolean a(a.b.b.h.j.f r8, a.b.b.h.j.h r9, java.util.List<a.b.b.h.j.h> r10, boolean r11) {
        /*
            Method dump skipped, instructions count: 560
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: a.b.b.h.j.a.a(a.b.b.h.j.f, a.b.b.h.j.h, java.util.List, boolean):boolean");
    }

    public static void a(g gVar, f fVar, h hVar) {
        hVar.f182d = false;
        gVar.D0 = false;
        fVar.b0 = false;
    }

    public static int a(h hVar, int i2) {
        int i3 = i2 * 2;
        List<f> a2 = hVar.a(i2);
        int size = a2.size();
        int i4 = 0;
        for (int i5 = 0; i5 < size; i5++) {
            f fVar = a2.get(i5);
            e[] eVarArr = fVar.A;
            int i6 = i3 + 1;
            i4 = Math.max(i4, a(fVar, i2, eVarArr[i6].f140d == null || !(eVarArr[i3].f140d == null || eVarArr[i6].f140d == null), 0));
        }
        hVar.f183e[i2] = i4;
        return i4;
    }

    public static int a(f fVar, int i2, boolean z, int i3) {
        int j;
        int d2;
        int i4;
        int i5;
        int i6;
        int i7;
        int t;
        int i8;
        int i9;
        int i10;
        int i11 = 0;
        if (fVar.b0) {
            boolean z2 = fVar.w.f140d != null && i2 == 1;
            if (z) {
                j = fVar.d();
                d2 = fVar.j() - fVar.d();
                i5 = i2 * 2;
                i4 = i5 + 1;
            } else {
                j = fVar.j() - fVar.d();
                d2 = fVar.d();
                i4 = i2 * 2;
                i5 = i4 + 1;
            }
            e[] eVarArr = fVar.A;
            if (eVarArr[i4].f140d == null || eVarArr[i5].f140d != null) {
                i6 = i4;
                i7 = 1;
            } else {
                i6 = i5;
                i5 = i4;
                i7 = -1;
            }
            int i12 = z2 ? i3 - j : i3;
            int b2 = (fVar.A[i5].b() * i7) + a(fVar, i2);
            int i13 = i12 + b2;
            int t2 = (i2 == 0 ? fVar.t() : fVar.j()) * i7;
            Iterator<o> it = fVar.A[i5].d().f198a.iterator();
            while (it.hasNext()) {
                i11 = Math.max(i11, a(((m) it.next()).f190c.f138b, i2, z, i13));
            }
            int i14 = 0;
            for (Iterator<o> it2 = fVar.A[i6].d().f198a.iterator(); it2.hasNext(); it2 = it2) {
                i14 = Math.max(i14, a(((m) it2.next()).f190c.f138b, i2, z, t2 + i13));
            }
            if (z2) {
                i11 -= j;
                t = i14 + d2;
            } else {
                t = i14 + ((i2 == 0 ? fVar.t() : fVar.j()) * i7);
            }
            int i15 = 1;
            if (i2 == 1) {
                Iterator<o> it3 = fVar.w.d().f198a.iterator();
                int i16 = 0;
                while (it3.hasNext()) {
                    Iterator<o> it4 = it3;
                    m mVar = (m) it3.next();
                    if (i7 == i15) {
                        i16 = Math.max(i16, a(mVar.f190c.f138b, i2, z, j + i13));
                        i10 = i6;
                    } else {
                        i10 = i6;
                        i16 = Math.max(i16, a(mVar.f190c.f138b, i2, z, (d2 * i7) + i13));
                    }
                    it3 = it4;
                    i6 = i10;
                    i15 = 1;
                }
                i8 = i6;
                int i17 = i16;
                i9 = (fVar.w.d().f198a.size() <= 0 || z2) ? i17 : i7 == 1 ? i17 + j : i17 - d2;
            } else {
                i8 = i6;
                i9 = 0;
            }
            int max = b2 + Math.max(i11, Math.max(t, i9));
            int i18 = i13 + t2;
            if (i7 != -1) {
                i13 = i18;
                i18 = i13;
            }
            if (z) {
                k.a(fVar, i2, i18);
                fVar.a(i18, i13, i2);
            } else {
                fVar.p.a(fVar, i2);
                fVar.d(i18, i2);
            }
            if (fVar.c(i2) == f.b.MATCH_CONSTRAINT && fVar.G != 0.0f) {
                fVar.p.a(fVar, i2);
            }
            e[] eVarArr2 = fVar.A;
            if (eVarArr2[i5].f140d != null && eVarArr2[i8].f140d != null) {
                f l = fVar.l();
                e[] eVarArr3 = fVar.A;
                if (eVarArr3[i5].f140d.f138b == l && eVarArr3[i8].f140d.f138b == l) {
                    fVar.p.a(fVar, i2);
                }
            }
            return max;
        }
        return 0;
    }

    public static void a(e eVar) {
        m d2 = eVar.d();
        e eVar2 = eVar.f140d;
        if (eVar2 == null || eVar2.f140d == eVar) {
            return;
        }
        eVar2.d().a(d2);
    }

    public static void a(List<h> list, int i2, int i3) {
        int size = list.size();
        for (int i4 = 0; i4 < size; i4++) {
            for (f fVar : list.get(i4).b(i2)) {
                if (fVar.b0) {
                    a(fVar, i2, i3);
                }
            }
        }
    }

    public static void a(f fVar, int i2, int i3) {
        int i4 = i2 * 2;
        e[] eVarArr = fVar.A;
        e eVar = eVarArr[i4];
        e eVar2 = eVarArr[i4 + 1];
        if ((eVar.f140d == null || eVar2.f140d == null) ? false : true) {
            k.a(fVar, i2, a(fVar, i2) + eVar.b());
        } else if (fVar.G != 0.0f && fVar.c(i2) == f.b.MATCH_CONSTRAINT) {
            int a2 = a(fVar);
            int i5 = (int) fVar.A[i4].d().f194g;
            eVar2.d().f193f = eVar.d();
            eVar2.d().f194g = a2;
            eVar2.d().f199b = 1;
            fVar.a(i5, i5 + a2, i2);
        } else {
            int e2 = i3 - fVar.e(i2);
            int d2 = e2 - fVar.d(i2);
            fVar.a(d2, e2, i2);
            k.a(fVar, i2, d2);
        }
    }

    public static int a(f fVar, int i2) {
        e eVar;
        int i3 = i2 * 2;
        e[] eVarArr = fVar.A;
        e eVar2 = eVarArr[i3];
        e eVar3 = eVarArr[i3 + 1];
        e eVar4 = eVar2.f140d;
        if (eVar4 != null) {
            f fVar2 = eVar4.f138b;
            f fVar3 = fVar.D;
            if (fVar2 == fVar3 && (eVar = eVar3.f140d) != null && eVar.f138b == fVar3) {
                return (int) ((((fVar3.d(i2) - eVar2.b()) - eVar3.b()) - fVar.d(i2)) * (i2 == 0 ? fVar.V : fVar.W));
            }
            return 0;
        }
        return 0;
    }

    public static int a(f fVar) {
        float t;
        float j;
        if (fVar.k() == f.b.MATCH_CONSTRAINT) {
            if (fVar.H == 0) {
                j = fVar.j() * fVar.G;
            } else {
                j = fVar.j() / fVar.G;
            }
            int i2 = (int) j;
            fVar.p(i2);
            return i2;
        } else if (fVar.r() == f.b.MATCH_CONSTRAINT) {
            if (fVar.H == 1) {
                t = fVar.t() * fVar.G;
            } else {
                t = fVar.t() / fVar.G;
            }
            int i3 = (int) t;
            fVar.h(i3);
            return i3;
        } else {
            return -1;
        }
    }
}
