package a.b.b.h;

import a.b.b.h.i;
import a.b.b.h.j.e;
import java.util.Arrays;
import java.util.HashMap;
/* compiled from: LinearSystem.java */
/* loaded from: classes.dex */
public class e {
    public static int p = 1000;
    public static f q;

    /* renamed from: c  reason: collision with root package name */
    public a f95c;

    /* renamed from: e  reason: collision with root package name */
    public int f97e;

    /* renamed from: f  reason: collision with root package name */
    public b[] f98f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f99g;

    /* renamed from: h  reason: collision with root package name */
    public boolean[] f100h;

    /* renamed from: i  reason: collision with root package name */
    public int f101i;
    public int j;
    public int k;
    public final c l;
    public i[] m;
    public int n;
    public final a o;

    /* renamed from: a  reason: collision with root package name */
    public int f93a = 0;

    /* renamed from: b  reason: collision with root package name */
    public HashMap<String, i> f94b = null;

    /* renamed from: d  reason: collision with root package name */
    public int f96d = 32;

    /* compiled from: LinearSystem.java */
    /* loaded from: classes.dex */
    public interface a {
        i a(e eVar, boolean[] zArr);

        void a(a aVar);

        void a(i iVar);

        void clear();

        i getKey();
    }

    public e() {
        int i2 = this.f96d;
        this.f97e = i2;
        this.f98f = null;
        this.f99g = false;
        this.f100h = new boolean[i2];
        this.f101i = 1;
        this.j = 0;
        this.k = i2;
        this.m = new i[p];
        this.n = 0;
        b[] bVarArr = new b[i2];
        this.f98f = new b[i2];
        h();
        this.l = new c();
        this.f95c = new d(this.l);
        this.o = new b(this.l);
    }

    public static f j() {
        return q;
    }

    public i a(Object obj) {
        i iVar = null;
        if (obj == null) {
            return null;
        }
        if (this.f101i + 1 >= this.f97e) {
            f();
        }
        if (obj instanceof a.b.b.h.j.e) {
            a.b.b.h.j.e eVar = (a.b.b.h.j.e) obj;
            iVar = eVar.e();
            if (iVar == null) {
                eVar.a(this.l);
                iVar = eVar.e();
            }
            int i2 = iVar.f114b;
            if (i2 == -1 || i2 > this.f93a || this.l.f92c[i2] == null) {
                if (iVar.f114b != -1) {
                    iVar.a();
                }
                this.f93a++;
                this.f101i++;
                int i3 = this.f93a;
                iVar.f114b = i3;
                iVar.f119g = i.a.UNRESTRICTED;
                this.l.f92c[i3] = iVar;
            }
        }
        return iVar;
    }

    public i b() {
        f fVar = q;
        if (fVar != null) {
            fVar.n++;
        }
        if (this.f101i + 1 >= this.f97e) {
            f();
        }
        i a2 = a(i.a.SLACK, (String) null);
        this.f93a++;
        this.f101i++;
        int i2 = this.f93a;
        a2.f114b = i2;
        this.l.f92c[i2] = a2;
        return a2;
    }

    public b c() {
        b a2 = this.l.f90a.a();
        if (a2 == null) {
            a2 = new b(this.l);
        } else {
            a2.d();
        }
        i.b();
        return a2;
    }

    public i d() {
        f fVar = q;
        if (fVar != null) {
            fVar.m++;
        }
        if (this.f101i + 1 >= this.f97e) {
            f();
        }
        i a2 = a(i.a.SLACK, (String) null);
        this.f93a++;
        this.f101i++;
        int i2 = this.f93a;
        a2.f114b = i2;
        this.l.f92c[i2] = a2;
        return a2;
    }

    public c e() {
        return this.l;
    }

    public final void f() {
        this.f96d *= 2;
        this.f98f = (b[]) Arrays.copyOf(this.f98f, this.f96d);
        c cVar = this.l;
        cVar.f92c = (i[]) Arrays.copyOf(cVar.f92c, this.f96d);
        int i2 = this.f96d;
        this.f100h = new boolean[i2];
        this.f97e = i2;
        this.k = i2;
        f fVar = q;
        if (fVar != null) {
            fVar.f105d++;
            fVar.o = Math.max(fVar.o, i2);
            f fVar2 = q;
            fVar2.A = fVar2.o;
        }
    }

    public void g() {
        f fVar = q;
        if (fVar != null) {
            fVar.f106e++;
        }
        if (this.f99g) {
            f fVar2 = q;
            if (fVar2 != null) {
                fVar2.q++;
            }
            boolean z = false;
            int i2 = 0;
            while (true) {
                if (i2 >= this.j) {
                    z = true;
                    break;
                } else if (!this.f98f[i2].f89e) {
                    break;
                } else {
                    i2++;
                }
            }
            if (!z) {
                b(this.f95c);
                return;
            }
            f fVar3 = q;
            if (fVar3 != null) {
                fVar3.p++;
            }
            a();
            return;
        }
        b(this.f95c);
    }

    public final void h() {
        int i2 = 0;
        while (true) {
            b[] bVarArr = this.f98f;
            if (i2 >= bVarArr.length) {
                return;
            }
            b bVar = bVarArr[i2];
            if (bVar != null) {
                this.l.f90a.a(bVar);
            }
            this.f98f[i2] = null;
            i2++;
        }
    }

    public void i() {
        c cVar;
        int i2 = 0;
        while (true) {
            cVar = this.l;
            i[] iVarArr = cVar.f92c;
            if (i2 >= iVarArr.length) {
                break;
            }
            i iVar = iVarArr[i2];
            if (iVar != null) {
                iVar.a();
            }
            i2++;
        }
        cVar.f91b.a(this.m, this.n);
        this.n = 0;
        Arrays.fill(this.l.f92c, (Object) null);
        HashMap<String, i> hashMap = this.f94b;
        if (hashMap != null) {
            hashMap.clear();
        }
        this.f93a = 0;
        this.f95c.clear();
        this.f101i = 1;
        for (int i3 = 0; i3 < this.j; i3++) {
            this.f98f[i3].f87c = false;
        }
        h();
        this.j = 0;
    }

    public final void c(b bVar) {
        b[] bVarArr = this.f98f;
        int i2 = this.j;
        if (bVarArr[i2] != null) {
            this.l.f90a.a(bVarArr[i2]);
        }
        b[] bVarArr2 = this.f98f;
        int i3 = this.j;
        bVarArr2[i3] = bVar;
        i iVar = bVar.f85a;
        iVar.f115c = i3;
        this.j = i3 + 1;
        iVar.c(bVar);
    }

    public final void b(b bVar) {
        bVar.a(this, 0);
    }

    public final void d(b bVar) {
        if (this.j > 0) {
            bVar.f88d.a(bVar, this.f98f);
            if (bVar.f88d.f76a == 0) {
                bVar.f89e = true;
            }
        }
    }

    public int b(Object obj) {
        i e2 = ((a.b.b.h.j.e) obj).e();
        if (e2 != null) {
            return (int) (e2.f117e + 0.5f);
        }
        return 0;
    }

    public void c(i iVar, i iVar2, int i2, int i3) {
        b c2 = c();
        i d2 = d();
        d2.f116d = 0;
        c2.b(iVar, iVar2, d2, i2);
        if (i3 != 6) {
            a(c2, (int) (c2.f88d.b(d2) * (-1.0f)), i3);
        }
        a(c2);
    }

    public void b(a aVar) {
        f fVar = q;
        if (fVar != null) {
            fVar.s++;
            fVar.t = Math.max(fVar.t, this.f101i);
            f fVar2 = q;
            fVar2.u = Math.max(fVar2.u, this.j);
        }
        d((b) aVar);
        a(aVar);
        a(aVar, false);
        a();
    }

    public void a(b bVar, int i2, int i3) {
        bVar.a(a(i3, (String) null), i2);
    }

    public i a(int i2, String str) {
        f fVar = q;
        if (fVar != null) {
            fVar.l++;
        }
        if (this.f101i + 1 >= this.f97e) {
            f();
        }
        i a2 = a(i.a.ERROR, str);
        this.f93a++;
        this.f101i++;
        int i3 = this.f93a;
        a2.f114b = i3;
        a2.f116d = i2;
        this.l.f92c[i3] = a2;
        this.f95c.a(a2);
        return a2;
    }

    public void b(i iVar, i iVar2, int i2, int i3) {
        b c2 = c();
        i d2 = d();
        d2.f116d = 0;
        c2.a(iVar, iVar2, d2, i2);
        if (i3 != 6) {
            a(c2, (int) (c2.f88d.b(d2) * (-1.0f)), i3);
        }
        a(c2);
    }

    public final i a(i.a aVar, String str) {
        i a2 = this.l.f91b.a();
        if (a2 == null) {
            a2 = new i(aVar, str);
            a2.a(aVar, str);
        } else {
            a2.a();
            a2.a(aVar, str);
        }
        int i2 = this.n;
        int i3 = p;
        if (i2 >= i3) {
            p = i3 * 2;
            this.m = (i[]) Arrays.copyOf(this.m, p);
        }
        i[] iVarArr = this.m;
        int i4 = this.n;
        this.n = i4 + 1;
        iVarArr[i4] = a2;
        return a2;
    }

    public void b(i iVar, i iVar2, boolean z) {
        b c2 = c();
        i d2 = d();
        d2.f116d = 0;
        c2.b(iVar, iVar2, d2, 0);
        if (z) {
            a(c2, (int) (c2.f88d.b(d2) * (-1.0f)), 1);
        }
        a(c2);
    }

    public void a(b bVar) {
        i c2;
        if (bVar == null) {
            return;
        }
        f fVar = q;
        if (fVar != null) {
            fVar.f107f++;
            if (bVar.f89e) {
                fVar.f108g++;
            }
        }
        if (this.j + 1 >= this.k || this.f101i + 1 >= this.f97e) {
            f();
        }
        boolean z = false;
        if (!bVar.f89e) {
            d(bVar);
            if (bVar.c()) {
                return;
            }
            bVar.a();
            if (bVar.a(this)) {
                i b2 = b();
                bVar.f85a = b2;
                c(bVar);
                this.o.a(bVar);
                a(this.o, true);
                if (b2.f115c == -1) {
                    if (bVar.f85a == b2 && (c2 = bVar.c(b2)) != null) {
                        f fVar2 = q;
                        if (fVar2 != null) {
                            fVar2.j++;
                        }
                        bVar.d(c2);
                    }
                    if (!bVar.f89e) {
                        bVar.f85a.c(bVar);
                    }
                    this.j--;
                }
                z = true;
            }
            if (!bVar.b()) {
                return;
            }
        }
        if (z) {
            return;
        }
        c(bVar);
    }

    public final int a(a aVar, boolean z) {
        f fVar = q;
        if (fVar != null) {
            fVar.f109h++;
        }
        for (int i2 = 0; i2 < this.f101i; i2++) {
            this.f100h[i2] = false;
        }
        boolean z2 = false;
        int i3 = 0;
        while (!z2) {
            f fVar2 = q;
            if (fVar2 != null) {
                fVar2.f110i++;
            }
            i3++;
            if (i3 >= this.f101i * 2) {
                return i3;
            }
            if (aVar.getKey() != null) {
                this.f100h[aVar.getKey().f114b] = true;
            }
            i a2 = aVar.a(this, this.f100h);
            if (a2 != null) {
                boolean[] zArr = this.f100h;
                int i4 = a2.f114b;
                if (zArr[i4]) {
                    return i3;
                }
                zArr[i4] = true;
            }
            if (a2 != null) {
                int i5 = -1;
                float f2 = Float.MAX_VALUE;
                for (int i6 = 0; i6 < this.j; i6++) {
                    b bVar = this.f98f[i6];
                    if (bVar.f85a.f119g != i.a.UNRESTRICTED && !bVar.f89e && bVar.b(a2)) {
                        float b2 = bVar.f88d.b(a2);
                        if (b2 < 0.0f) {
                            float f3 = (-bVar.f86b) / b2;
                            if (f3 < f2) {
                                i5 = i6;
                                f2 = f3;
                            }
                        }
                    }
                }
                if (i5 > -1) {
                    b bVar2 = this.f98f[i5];
                    bVar2.f85a.f115c = -1;
                    f fVar3 = q;
                    if (fVar3 != null) {
                        fVar3.j++;
                    }
                    bVar2.d(a2);
                    i iVar = bVar2.f85a;
                    iVar.f115c = i5;
                    iVar.c(bVar2);
                }
            }
            z2 = true;
        }
        return i3;
    }

    public final int a(a aVar) {
        float f2;
        boolean z;
        int i2 = 0;
        while (true) {
            f2 = 0.0f;
            if (i2 >= this.j) {
                z = false;
                break;
            }
            b[] bVarArr = this.f98f;
            if (bVarArr[i2].f85a.f119g != i.a.UNRESTRICTED && bVarArr[i2].f86b < 0.0f) {
                z = true;
                break;
            }
            i2++;
        }
        if (z) {
            boolean z2 = false;
            int i3 = 0;
            while (!z2) {
                f fVar = q;
                if (fVar != null) {
                    fVar.k++;
                }
                i3++;
                int i4 = 0;
                int i5 = -1;
                int i6 = -1;
                float f3 = Float.MAX_VALUE;
                int i7 = 0;
                while (i4 < this.j) {
                    b bVar = this.f98f[i4];
                    if (bVar.f85a.f119g != i.a.UNRESTRICTED && !bVar.f89e && bVar.f86b < f2) {
                        int i8 = 1;
                        while (i8 < this.f101i) {
                            i iVar = this.l.f92c[i8];
                            float b2 = bVar.f88d.b(iVar);
                            if (b2 > f2) {
                                int i9 = i7;
                                float f4 = f3;
                                int i10 = i6;
                                int i11 = i5;
                                for (int i12 = 0; i12 < 7; i12++) {
                                    float f5 = iVar.f118f[i12] / b2;
                                    if ((f5 < f4 && i12 == i9) || i12 > i9) {
                                        i10 = i8;
                                        i11 = i4;
                                        f4 = f5;
                                        i9 = i12;
                                    }
                                }
                                i5 = i11;
                                i6 = i10;
                                f3 = f4;
                                i7 = i9;
                            }
                            i8++;
                            f2 = 0.0f;
                        }
                    }
                    i4++;
                    f2 = 0.0f;
                }
                if (i5 != -1) {
                    b bVar2 = this.f98f[i5];
                    bVar2.f85a.f115c = -1;
                    f fVar2 = q;
                    if (fVar2 != null) {
                        fVar2.j++;
                    }
                    bVar2.d(this.l.f92c[i6]);
                    i iVar2 = bVar2.f85a;
                    iVar2.f115c = i5;
                    iVar2.c(bVar2);
                } else {
                    z2 = true;
                }
                if (i3 > this.f101i / 2) {
                    z2 = true;
                }
                f2 = 0.0f;
            }
            return i3;
        }
        return 0;
    }

    public final void a() {
        for (int i2 = 0; i2 < this.j; i2++) {
            b bVar = this.f98f[i2];
            bVar.f85a.f117e = bVar.f86b;
        }
    }

    public void a(i iVar, i iVar2, boolean z) {
        b c2 = c();
        i d2 = d();
        d2.f116d = 0;
        c2.a(iVar, iVar2, d2, 0);
        if (z) {
            a(c2, (int) (c2.f88d.b(d2) * (-1.0f)), 1);
        }
        a(c2);
    }

    public void a(i iVar, i iVar2, int i2, float f2, i iVar3, i iVar4, int i3, int i4) {
        b c2 = c();
        c2.a(iVar, iVar2, i2, f2, iVar3, iVar4, i3);
        if (i4 != 6) {
            c2.a(this, i4);
        }
        a(c2);
    }

    public void a(i iVar, i iVar2, i iVar3, i iVar4, float f2, int i2) {
        b c2 = c();
        c2.a(iVar, iVar2, iVar3, iVar4, f2);
        if (i2 != 6) {
            c2.a(this, i2);
        }
        a(c2);
    }

    public b a(i iVar, i iVar2, int i2, int i3) {
        b c2 = c();
        c2.a(iVar, iVar2, i2);
        if (i3 != 6) {
            c2.a(this, i3);
        }
        a(c2);
        return c2;
    }

    public void a(i iVar, int i2) {
        int i3 = iVar.f115c;
        if (i3 != -1) {
            b bVar = this.f98f[i3];
            if (bVar.f89e) {
                bVar.f86b = i2;
                return;
            } else if (bVar.f88d.f76a == 0) {
                bVar.f89e = true;
                bVar.f86b = i2;
                return;
            } else {
                b c2 = c();
                c2.c(iVar, i2);
                a(c2);
                return;
            }
        }
        b c3 = c();
        c3.b(iVar, i2);
        a(c3);
    }

    public static b a(e eVar, i iVar, i iVar2, i iVar3, float f2, boolean z) {
        b c2 = eVar.c();
        if (z) {
            eVar.b(c2);
        }
        c2.a(iVar, iVar2, iVar3, f2);
        return c2;
    }

    public void a(a.b.b.h.j.f fVar, a.b.b.h.j.f fVar2, float f2, int i2) {
        i a2 = a(fVar.a(e.d.LEFT));
        i a3 = a(fVar.a(e.d.TOP));
        i a4 = a(fVar.a(e.d.RIGHT));
        i a5 = a(fVar.a(e.d.BOTTOM));
        i a6 = a(fVar2.a(e.d.LEFT));
        i a7 = a(fVar2.a(e.d.TOP));
        i a8 = a(fVar2.a(e.d.RIGHT));
        i a9 = a(fVar2.a(e.d.BOTTOM));
        b c2 = c();
        double d2 = f2;
        double d3 = i2;
        c2.b(a3, a5, a7, a9, (float) (Math.sin(d2) * d3));
        a(c2);
        b c3 = c();
        c3.b(a2, a4, a6, a8, (float) (Math.cos(d2) * d3));
        a(c3);
    }
}
