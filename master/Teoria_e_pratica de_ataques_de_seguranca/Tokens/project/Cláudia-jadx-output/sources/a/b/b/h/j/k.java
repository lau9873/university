package a.b.b.h.j;

import a.b.b.h.j.f;
/* compiled from: Optimizer.java */
/* loaded from: classes.dex */
public class k {

    /* renamed from: a  reason: collision with root package name */
    public static boolean[] f189a = new boolean[3];

    public static void a(g gVar, a.b.b.h.e eVar, f fVar) {
        if (gVar.C[0] != f.b.WRAP_CONTENT && fVar.C[0] == f.b.MATCH_PARENT) {
            int i2 = fVar.s.f141e;
            int t = gVar.t() - fVar.u.f141e;
            e eVar2 = fVar.s;
            eVar2.f145i = eVar.a(eVar2);
            e eVar3 = fVar.u;
            eVar3.f145i = eVar.a(eVar3);
            eVar.a(fVar.s.f145i, i2);
            eVar.a(fVar.u.f145i, t);
            fVar.f163a = 2;
            fVar.a(i2, t);
        }
        if (gVar.C[1] == f.b.WRAP_CONTENT || fVar.C[1] != f.b.MATCH_PARENT) {
            return;
        }
        int i3 = fVar.t.f141e;
        int j = gVar.j() - fVar.v.f141e;
        e eVar4 = fVar.t;
        eVar4.f145i = eVar.a(eVar4);
        e eVar5 = fVar.v;
        eVar5.f145i = eVar.a(eVar5);
        eVar.a(fVar.t.f145i, i3);
        eVar.a(fVar.v.f145i, j);
        if (fVar.Q > 0 || fVar.s() == 8) {
            e eVar6 = fVar.w;
            eVar6.f145i = eVar.a(eVar6);
            eVar.a(fVar.w.f145i, fVar.Q + i3);
        }
        fVar.f164b = 2;
        fVar.e(i3, j);
    }

    public static boolean a(f fVar, int i2) {
        f.b[] bVarArr = fVar.C;
        if (bVarArr[i2] != f.b.MATCH_CONSTRAINT) {
            return false;
        }
        if (fVar.G != 0.0f) {
            if (bVarArr[i2 != 0 ? (char) 0 : (char) 1] == f.b.MATCH_CONSTRAINT) {
            }
            return false;
        }
        if (i2 == 0) {
            if (fVar.f167e != 0 || fVar.f170h != 0 || fVar.f171i != 0) {
                return false;
            }
        } else if (fVar.f168f != 0 || fVar.k != 0 || fVar.l != 0) {
            return false;
        }
        return true;
    }

    public static void a(int i2, f fVar) {
        fVar.J();
        m d2 = fVar.s.d();
        m d3 = fVar.t.d();
        m d4 = fVar.u.d();
        m d5 = fVar.v.d();
        boolean z = (i2 & 8) == 8;
        boolean z2 = fVar.C[0] == f.b.MATCH_CONSTRAINT && a(fVar, 0);
        if (d2.f195h != 4 && d4.f195h != 4) {
            if (fVar.C[0] == f.b.FIXED || (z2 && fVar.s() == 8)) {
                if (fVar.s.f140d == null && fVar.u.f140d == null) {
                    d2.b(1);
                    d4.b(1);
                    if (z) {
                        d4.a(d2, 1, fVar.n());
                    } else {
                        d4.a(d2, fVar.t());
                    }
                } else if (fVar.s.f140d != null && fVar.u.f140d == null) {
                    d2.b(1);
                    d4.b(1);
                    if (z) {
                        d4.a(d2, 1, fVar.n());
                    } else {
                        d4.a(d2, fVar.t());
                    }
                } else if (fVar.s.f140d == null && fVar.u.f140d != null) {
                    d2.b(1);
                    d4.b(1);
                    d2.a(d4, -fVar.t());
                    if (z) {
                        d2.a(d4, -1, fVar.n());
                    } else {
                        d2.a(d4, -fVar.t());
                    }
                } else if (fVar.s.f140d != null && fVar.u.f140d != null) {
                    d2.b(2);
                    d4.b(2);
                    if (z) {
                        fVar.n().a(d2);
                        fVar.n().a(d4);
                        d2.b(d4, -1, fVar.n());
                        d4.b(d2, 1, fVar.n());
                    } else {
                        d2.b(d4, -fVar.t());
                        d4.b(d2, fVar.t());
                    }
                }
            } else if (z2) {
                int t = fVar.t();
                d2.b(1);
                d4.b(1);
                if (fVar.s.f140d == null && fVar.u.f140d == null) {
                    if (z) {
                        d4.a(d2, 1, fVar.n());
                    } else {
                        d4.a(d2, t);
                    }
                } else if (fVar.s.f140d == null || fVar.u.f140d != null) {
                    if (fVar.s.f140d != null || fVar.u.f140d == null) {
                        if (fVar.s.f140d != null && fVar.u.f140d != null) {
                            if (z) {
                                fVar.n().a(d2);
                                fVar.n().a(d4);
                            }
                            if (fVar.G == 0.0f) {
                                d2.b(3);
                                d4.b(3);
                                d2.b(d4, 0.0f);
                                d4.b(d2, 0.0f);
                            } else {
                                d2.b(2);
                                d4.b(2);
                                d2.b(d4, -t);
                                d4.b(d2, t);
                                fVar.p(t);
                            }
                        }
                    } else if (z) {
                        d2.a(d4, -1, fVar.n());
                    } else {
                        d2.a(d4, -t);
                    }
                } else if (z) {
                    d4.a(d2, 1, fVar.n());
                } else {
                    d4.a(d2, t);
                }
            }
        }
        boolean z3 = fVar.C[1] == f.b.MATCH_CONSTRAINT && a(fVar, 1);
        if (d3.f195h == 4 || d5.f195h == 4) {
            return;
        }
        if (fVar.C[1] != f.b.FIXED && (!z3 || fVar.s() != 8)) {
            if (z3) {
                int j = fVar.j();
                d3.b(1);
                d5.b(1);
                if (fVar.t.f140d == null && fVar.v.f140d == null) {
                    if (z) {
                        d5.a(d3, 1, fVar.m());
                    } else {
                        d5.a(d3, j);
                    }
                } else if (fVar.t.f140d != null && fVar.v.f140d == null) {
                    if (z) {
                        d5.a(d3, 1, fVar.m());
                    } else {
                        d5.a(d3, j);
                    }
                } else if (fVar.t.f140d == null && fVar.v.f140d != null) {
                    if (z) {
                        d3.a(d5, -1, fVar.m());
                    } else {
                        d3.a(d5, -j);
                    }
                } else if (fVar.t.f140d == null || fVar.v.f140d == null) {
                } else {
                    if (z) {
                        fVar.m().a(d3);
                        fVar.n().a(d5);
                    }
                    if (fVar.G == 0.0f) {
                        d3.b(3);
                        d5.b(3);
                        d3.b(d5, 0.0f);
                        d5.b(d3, 0.0f);
                        return;
                    }
                    d3.b(2);
                    d5.b(2);
                    d3.b(d5, -j);
                    d5.b(d3, j);
                    fVar.h(j);
                    if (fVar.Q > 0) {
                        fVar.w.d().a(1, d3, fVar.Q);
                    }
                }
            }
        } else if (fVar.t.f140d == null && fVar.v.f140d == null) {
            d3.b(1);
            d5.b(1);
            if (z) {
                d5.a(d3, 1, fVar.m());
            } else {
                d5.a(d3, fVar.j());
            }
            e eVar = fVar.w;
            if (eVar.f140d != null) {
                eVar.d().b(1);
                d3.a(1, fVar.w.d(), -fVar.Q);
            }
        } else if (fVar.t.f140d != null && fVar.v.f140d == null) {
            d3.b(1);
            d5.b(1);
            if (z) {
                d5.a(d3, 1, fVar.m());
            } else {
                d5.a(d3, fVar.j());
            }
            if (fVar.Q > 0) {
                fVar.w.d().a(1, d3, fVar.Q);
            }
        } else if (fVar.t.f140d == null && fVar.v.f140d != null) {
            d3.b(1);
            d5.b(1);
            if (z) {
                d3.a(d5, -1, fVar.m());
            } else {
                d3.a(d5, -fVar.j());
            }
            if (fVar.Q > 0) {
                fVar.w.d().a(1, d3, fVar.Q);
            }
        } else if (fVar.t.f140d == null || fVar.v.f140d == null) {
        } else {
            d3.b(2);
            d5.b(2);
            if (z) {
                d3.b(d5, -1, fVar.m());
                d5.b(d3, 1, fVar.m());
                fVar.m().a(d3);
                fVar.n().a(d5);
            } else {
                d3.b(d5, -fVar.j());
                d5.b(d3, fVar.j());
            }
            if (fVar.Q > 0) {
                fVar.w.d().a(1, d3, fVar.Q);
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:13:0x0032, code lost:
        if (r7.e0 == 2) goto L11;
     */
    /* JADX WARN: Code restructure failed: missing block: B:14:0x0034, code lost:
        r2 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x0036, code lost:
        r2 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x0048, code lost:
        if (r7.f0 == 2) goto L11;
     */
    /* JADX WARN: Removed duplicated region for block: B:136:0x01d6  */
    /* JADX WARN: Removed duplicated region for block: B:212:0x0109 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:220:0x0105 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static boolean a(a.b.b.h.j.g r24, a.b.b.h.e r25, int r26, int r27, a.b.b.h.j.d r28) {
        /*
            Method dump skipped, instructions count: 900
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: a.b.b.h.j.k.a(a.b.b.h.j.g, a.b.b.h.e, int, int, a.b.b.h.j.d):boolean");
    }

    public static void a(f fVar, int i2, int i3) {
        int i4 = i2 * 2;
        int i5 = i4 + 1;
        fVar.A[i4].d().f193f = fVar.l().s.d();
        fVar.A[i4].d().f194g = i3;
        fVar.A[i4].d().f199b = 1;
        fVar.A[i5].d().f193f = fVar.A[i4].d();
        fVar.A[i5].d().f194g = fVar.d(i2);
        fVar.A[i5].d().f199b = 1;
    }
}
