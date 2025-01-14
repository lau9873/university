package a.b.b.h;

import a.b.b.h.e;
import a.b.b.h.i;
/* compiled from: ArrayRow.java */
/* loaded from: classes.dex */
public class b implements e.a {

    /* renamed from: c  reason: collision with root package name */
    public boolean f87c;

    /* renamed from: d  reason: collision with root package name */
    public final a f88d;

    /* renamed from: a  reason: collision with root package name */
    public i f85a = null;

    /* renamed from: b  reason: collision with root package name */
    public float f86b = 0.0f;

    /* renamed from: e  reason: collision with root package name */
    public boolean f89e = false;

    public b(c cVar) {
        this.f88d = new a(this, cVar);
    }

    public b a(i iVar, i iVar2, int i2) {
        boolean z = false;
        if (i2 != 0) {
            if (i2 < 0) {
                i2 *= -1;
                z = true;
            }
            this.f86b = i2;
        }
        if (!z) {
            this.f88d.a(iVar, -1.0f);
            this.f88d.a(iVar2, 1.0f);
        } else {
            this.f88d.a(iVar, 1.0f);
            this.f88d.a(iVar2, -1.0f);
        }
        return this;
    }

    public boolean b() {
        i iVar = this.f85a;
        return iVar != null && (iVar.f119g == i.a.UNRESTRICTED || this.f86b >= 0.0f);
    }

    public b c(i iVar, int i2) {
        if (i2 < 0) {
            this.f86b = i2 * (-1);
            this.f88d.a(iVar, 1.0f);
        } else {
            this.f86b = i2;
            this.f88d.a(iVar, -1.0f);
        }
        return this;
    }

    @Override // a.b.b.h.e.a
    public void clear() {
        this.f88d.a();
        this.f85a = null;
        this.f86b = 0.0f;
    }

    public void d() {
        this.f85a = null;
        this.f88d.a();
        this.f86b = 0.0f;
        this.f89e = false;
    }

    /* JADX WARN: Removed duplicated region for block: B:29:0x00be  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x00ce  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.String e() {
        /*
            Method dump skipped, instructions count: 254
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: a.b.b.h.b.e():java.lang.String");
    }

    @Override // a.b.b.h.e.a
    public i getKey() {
        return this.f85a;
    }

    public String toString() {
        return e();
    }

    public boolean b(i iVar) {
        return this.f88d.a(iVar);
    }

    public b b(i iVar, int i2) {
        this.f85a = iVar;
        float f2 = i2;
        iVar.f117e = f2;
        this.f86b = f2;
        this.f89e = true;
        return this;
    }

    public i c(i iVar) {
        return this.f88d.a((boolean[]) null, iVar);
    }

    public void d(i iVar) {
        i iVar2 = this.f85a;
        if (iVar2 != null) {
            this.f88d.a(iVar2, -1.0f);
            this.f85a = null;
        }
        float a2 = this.f88d.a(iVar, true) * (-1.0f);
        this.f85a = iVar;
        if (a2 == 1.0f) {
            return;
        }
        this.f86b /= a2;
        this.f88d.a(a2);
    }

    public b a(i iVar, int i2) {
        this.f88d.a(iVar, i2);
        return this;
    }

    public boolean c() {
        return this.f85a == null && this.f86b == 0.0f && this.f88d.f76a == 0;
    }

    public b a(i iVar, i iVar2, i iVar3, int i2) {
        boolean z = false;
        if (i2 != 0) {
            if (i2 < 0) {
                i2 *= -1;
                z = true;
            }
            this.f86b = i2;
        }
        if (!z) {
            this.f88d.a(iVar, -1.0f);
            this.f88d.a(iVar2, 1.0f);
            this.f88d.a(iVar3, 1.0f);
        } else {
            this.f88d.a(iVar, 1.0f);
            this.f88d.a(iVar2, -1.0f);
            this.f88d.a(iVar3, -1.0f);
        }
        return this;
    }

    public b b(i iVar, i iVar2, i iVar3, int i2) {
        boolean z = false;
        if (i2 != 0) {
            if (i2 < 0) {
                i2 *= -1;
                z = true;
            }
            this.f86b = i2;
        }
        if (!z) {
            this.f88d.a(iVar, -1.0f);
            this.f88d.a(iVar2, 1.0f);
            this.f88d.a(iVar3, -1.0f);
        } else {
            this.f88d.a(iVar, 1.0f);
            this.f88d.a(iVar2, -1.0f);
            this.f88d.a(iVar3, 1.0f);
        }
        return this;
    }

    public b a(float f2, float f3, float f4, i iVar, i iVar2, i iVar3, i iVar4) {
        this.f86b = 0.0f;
        if (f3 == 0.0f || f2 == f4) {
            this.f88d.a(iVar, 1.0f);
            this.f88d.a(iVar2, -1.0f);
            this.f88d.a(iVar4, 1.0f);
            this.f88d.a(iVar3, -1.0f);
        } else if (f2 == 0.0f) {
            this.f88d.a(iVar, 1.0f);
            this.f88d.a(iVar2, -1.0f);
        } else if (f4 == 0.0f) {
            this.f88d.a(iVar3, 1.0f);
            this.f88d.a(iVar4, -1.0f);
        } else {
            float f5 = (f2 / f3) / (f4 / f3);
            this.f88d.a(iVar, 1.0f);
            this.f88d.a(iVar2, -1.0f);
            this.f88d.a(iVar4, f5);
            this.f88d.a(iVar3, -f5);
        }
        return this;
    }

    public b b(i iVar, i iVar2, i iVar3, i iVar4, float f2) {
        this.f88d.a(iVar3, 0.5f);
        this.f88d.a(iVar4, 0.5f);
        this.f88d.a(iVar, -0.5f);
        this.f88d.a(iVar2, -0.5f);
        this.f86b = -f2;
        return this;
    }

    public b a(i iVar, i iVar2, int i2, float f2, i iVar3, i iVar4, int i3) {
        if (iVar2 == iVar3) {
            this.f88d.a(iVar, 1.0f);
            this.f88d.a(iVar4, 1.0f);
            this.f88d.a(iVar2, -2.0f);
            return this;
        }
        if (f2 == 0.5f) {
            this.f88d.a(iVar, 1.0f);
            this.f88d.a(iVar2, -1.0f);
            this.f88d.a(iVar3, -1.0f);
            this.f88d.a(iVar4, 1.0f);
            if (i2 > 0 || i3 > 0) {
                this.f86b = (-i2) + i3;
            }
        } else if (f2 <= 0.0f) {
            this.f88d.a(iVar, -1.0f);
            this.f88d.a(iVar2, 1.0f);
            this.f86b = i2;
        } else if (f2 >= 1.0f) {
            this.f88d.a(iVar3, -1.0f);
            this.f88d.a(iVar4, 1.0f);
            this.f86b = i3;
        } else {
            float f3 = 1.0f - f2;
            this.f88d.a(iVar, f3 * 1.0f);
            this.f88d.a(iVar2, f3 * (-1.0f));
            this.f88d.a(iVar3, (-1.0f) * f2);
            this.f88d.a(iVar4, 1.0f * f2);
            if (i2 > 0 || i3 > 0) {
                this.f86b = ((-i2) * f3) + (i3 * f2);
            }
        }
        return this;
    }

    public b a(e eVar, int i2) {
        this.f88d.a(eVar.a(i2, "ep"), 1.0f);
        this.f88d.a(eVar.a(i2, "em"), -1.0f);
        return this;
    }

    public b a(i iVar, i iVar2, i iVar3, float f2) {
        this.f88d.a(iVar, -1.0f);
        this.f88d.a(iVar2, 1.0f - f2);
        this.f88d.a(iVar3, f2);
        return this;
    }

    public b a(i iVar, i iVar2, i iVar3, i iVar4, float f2) {
        this.f88d.a(iVar, -1.0f);
        this.f88d.a(iVar2, 1.0f);
        this.f88d.a(iVar3, f2);
        this.f88d.a(iVar4, -f2);
        return this;
    }

    public void a() {
        float f2 = this.f86b;
        if (f2 < 0.0f) {
            this.f86b = f2 * (-1.0f);
            this.f88d.b();
        }
    }

    public boolean a(e eVar) {
        boolean z;
        i a2 = this.f88d.a(eVar);
        if (a2 == null) {
            z = true;
        } else {
            d(a2);
            z = false;
        }
        if (this.f88d.f76a == 0) {
            this.f89e = true;
        }
        return z;
    }

    @Override // a.b.b.h.e.a
    public i a(e eVar, boolean[] zArr) {
        return this.f88d.a(zArr, (i) null);
    }

    @Override // a.b.b.h.e.a
    public void a(e.a aVar) {
        if (!(aVar instanceof b)) {
            return;
        }
        b bVar = (b) aVar;
        this.f85a = null;
        this.f88d.a();
        int i2 = 0;
        while (true) {
            a aVar2 = bVar.f88d;
            if (i2 >= aVar2.f76a) {
                return;
            }
            this.f88d.a(aVar2.a(i2), bVar.f88d.b(i2), true);
            i2++;
        }
    }

    @Override // a.b.b.h.e.a
    public void a(i iVar) {
        int i2 = iVar.f116d;
        float f2 = 1.0f;
        if (i2 != 1) {
            if (i2 == 2) {
                f2 = 1000.0f;
            } else if (i2 == 3) {
                f2 = 1000000.0f;
            } else if (i2 == 4) {
                f2 = 1.0E9f;
            } else if (i2 == 5) {
                f2 = 1.0E12f;
            }
        }
        this.f88d.a(iVar, f2);
    }
}
