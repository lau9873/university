package a.b.b.h;

import a.b.b.h.i;
import java.util.Arrays;
/* compiled from: ArrayLinkedVariables.java */
/* loaded from: classes.dex */
public class a {

    /* renamed from: b  reason: collision with root package name */
    public final b f77b;

    /* renamed from: c  reason: collision with root package name */
    public final c f78c;

    /* renamed from: f  reason: collision with root package name */
    public int[] f81f;

    /* renamed from: g  reason: collision with root package name */
    public int[] f82g;

    /* renamed from: h  reason: collision with root package name */
    public float[] f83h;

    /* renamed from: i  reason: collision with root package name */
    public int f84i;
    public int j;
    public boolean k;

    /* renamed from: a  reason: collision with root package name */
    public int f76a = 0;

    /* renamed from: d  reason: collision with root package name */
    public int f79d = 8;

    /* renamed from: e  reason: collision with root package name */
    public i f80e = null;

    public a(b bVar, c cVar) {
        int i2 = this.f79d;
        this.f81f = new int[i2];
        this.f82g = new int[i2];
        this.f83h = new float[i2];
        this.f84i = -1;
        this.j = -1;
        this.k = false;
        this.f77b = bVar;
        this.f78c = cVar;
    }

    public final void a(i iVar, float f2) {
        if (f2 == 0.0f) {
            a(iVar, true);
            return;
        }
        int i2 = this.f84i;
        if (i2 == -1) {
            this.f84i = 0;
            float[] fArr = this.f83h;
            int i3 = this.f84i;
            fArr[i3] = f2;
            this.f81f[i3] = iVar.f114b;
            this.f82g[i3] = -1;
            iVar.j++;
            iVar.a(this.f77b);
            this.f76a++;
            if (this.k) {
                return;
            }
            this.j++;
            int i4 = this.j;
            int[] iArr = this.f81f;
            if (i4 >= iArr.length) {
                this.k = true;
                this.j = iArr.length - 1;
                return;
            }
            return;
        }
        int i5 = -1;
        for (int i6 = 0; i2 != -1 && i6 < this.f76a; i6++) {
            int[] iArr2 = this.f81f;
            int i7 = iArr2[i2];
            int i8 = iVar.f114b;
            if (i7 == i8) {
                this.f83h[i2] = f2;
                return;
            }
            if (iArr2[i2] < i8) {
                i5 = i2;
            }
            i2 = this.f82g[i2];
        }
        int i9 = this.j;
        int i10 = i9 + 1;
        if (this.k) {
            int[] iArr3 = this.f81f;
            if (iArr3[i9] != -1) {
                i9 = iArr3.length;
            }
        } else {
            i9 = i10;
        }
        int[] iArr4 = this.f81f;
        if (i9 >= iArr4.length && this.f76a < iArr4.length) {
            int i11 = 0;
            while (true) {
                int[] iArr5 = this.f81f;
                if (i11 >= iArr5.length) {
                    break;
                } else if (iArr5[i11] == -1) {
                    i9 = i11;
                    break;
                } else {
                    i11++;
                }
            }
        }
        int[] iArr6 = this.f81f;
        if (i9 >= iArr6.length) {
            i9 = iArr6.length;
            this.f79d *= 2;
            this.k = false;
            this.j = i9 - 1;
            this.f83h = Arrays.copyOf(this.f83h, this.f79d);
            this.f81f = Arrays.copyOf(this.f81f, this.f79d);
            this.f82g = Arrays.copyOf(this.f82g, this.f79d);
        }
        this.f81f[i9] = iVar.f114b;
        this.f83h[i9] = f2;
        if (i5 != -1) {
            int[] iArr7 = this.f82g;
            iArr7[i9] = iArr7[i5];
            iArr7[i5] = i9;
        } else {
            this.f82g[i9] = this.f84i;
            this.f84i = i9;
        }
        iVar.j++;
        iVar.a(this.f77b);
        this.f76a++;
        if (!this.k) {
            this.j++;
        }
        if (this.f76a >= this.f81f.length) {
            this.k = true;
        }
        int i12 = this.j;
        int[] iArr8 = this.f81f;
        if (i12 >= iArr8.length) {
            this.k = true;
            this.j = iArr8.length - 1;
        }
    }

    public void b() {
        int i2 = this.f84i;
        for (int i3 = 0; i2 != -1 && i3 < this.f76a; i3++) {
            float[] fArr = this.f83h;
            fArr[i2] = fArr[i2] * (-1.0f);
            i2 = this.f82g[i2];
        }
    }

    public String toString() {
        int i2 = this.f84i;
        String str = "";
        for (int i3 = 0; i2 != -1 && i3 < this.f76a; i3++) {
            str = ((str + " -> ") + this.f83h[i2] + " : ") + this.f78c.f92c[this.f81f[i2]];
            i2 = this.f82g[i2];
        }
        return str;
    }

    public final float b(int i2) {
        int i3 = this.f84i;
        for (int i4 = 0; i3 != -1 && i4 < this.f76a; i4++) {
            if (i4 == i2) {
                return this.f83h[i3];
            }
            i3 = this.f82g[i3];
        }
        return 0.0f;
    }

    public final float b(i iVar) {
        int i2 = this.f84i;
        for (int i3 = 0; i2 != -1 && i3 < this.f76a; i3++) {
            if (this.f81f[i2] == iVar.f114b) {
                return this.f83h[i2];
            }
            i2 = this.f82g[i2];
        }
        return 0.0f;
    }

    public final void a(i iVar, float f2, boolean z) {
        if (f2 == 0.0f) {
            return;
        }
        int i2 = this.f84i;
        if (i2 == -1) {
            this.f84i = 0;
            float[] fArr = this.f83h;
            int i3 = this.f84i;
            fArr[i3] = f2;
            this.f81f[i3] = iVar.f114b;
            this.f82g[i3] = -1;
            iVar.j++;
            iVar.a(this.f77b);
            this.f76a++;
            if (this.k) {
                return;
            }
            this.j++;
            int i4 = this.j;
            int[] iArr = this.f81f;
            if (i4 >= iArr.length) {
                this.k = true;
                this.j = iArr.length - 1;
                return;
            }
            return;
        }
        int i5 = -1;
        for (int i6 = 0; i2 != -1 && i6 < this.f76a; i6++) {
            int[] iArr2 = this.f81f;
            int i7 = iArr2[i2];
            int i8 = iVar.f114b;
            if (i7 == i8) {
                float[] fArr2 = this.f83h;
                fArr2[i2] = fArr2[i2] + f2;
                if (fArr2[i2] == 0.0f) {
                    if (i2 == this.f84i) {
                        this.f84i = this.f82g[i2];
                    } else {
                        int[] iArr3 = this.f82g;
                        iArr3[i5] = iArr3[i2];
                    }
                    if (z) {
                        iVar.b(this.f77b);
                    }
                    if (this.k) {
                        this.j = i2;
                    }
                    iVar.j--;
                    this.f76a--;
                    return;
                }
                return;
            }
            if (iArr2[i2] < i8) {
                i5 = i2;
            }
            i2 = this.f82g[i2];
        }
        int i9 = this.j;
        int i10 = i9 + 1;
        if (this.k) {
            int[] iArr4 = this.f81f;
            if (iArr4[i9] != -1) {
                i9 = iArr4.length;
            }
        } else {
            i9 = i10;
        }
        int[] iArr5 = this.f81f;
        if (i9 >= iArr5.length && this.f76a < iArr5.length) {
            int i11 = 0;
            while (true) {
                int[] iArr6 = this.f81f;
                if (i11 >= iArr6.length) {
                    break;
                } else if (iArr6[i11] == -1) {
                    i9 = i11;
                    break;
                } else {
                    i11++;
                }
            }
        }
        int[] iArr7 = this.f81f;
        if (i9 >= iArr7.length) {
            i9 = iArr7.length;
            this.f79d *= 2;
            this.k = false;
            this.j = i9 - 1;
            this.f83h = Arrays.copyOf(this.f83h, this.f79d);
            this.f81f = Arrays.copyOf(this.f81f, this.f79d);
            this.f82g = Arrays.copyOf(this.f82g, this.f79d);
        }
        this.f81f[i9] = iVar.f114b;
        this.f83h[i9] = f2;
        if (i5 != -1) {
            int[] iArr8 = this.f82g;
            iArr8[i9] = iArr8[i5];
            iArr8[i5] = i9;
        } else {
            this.f82g[i9] = this.f84i;
            this.f84i = i9;
        }
        iVar.j++;
        iVar.a(this.f77b);
        this.f76a++;
        if (!this.k) {
            this.j++;
        }
        int i12 = this.j;
        int[] iArr9 = this.f81f;
        if (i12 >= iArr9.length) {
            this.k = true;
            this.j = iArr9.length - 1;
        }
    }

    public final float a(i iVar, boolean z) {
        if (this.f80e == iVar) {
            this.f80e = null;
        }
        int i2 = this.f84i;
        if (i2 == -1) {
            return 0.0f;
        }
        int i3 = 0;
        int i4 = -1;
        while (i2 != -1 && i3 < this.f76a) {
            if (this.f81f[i2] == iVar.f114b) {
                if (i2 == this.f84i) {
                    this.f84i = this.f82g[i2];
                } else {
                    int[] iArr = this.f82g;
                    iArr[i4] = iArr[i2];
                }
                if (z) {
                    iVar.b(this.f77b);
                }
                iVar.j--;
                this.f76a--;
                this.f81f[i2] = -1;
                if (this.k) {
                    this.j = i2;
                }
                return this.f83h[i2];
            }
            i3++;
            i4 = i2;
            i2 = this.f82g[i2];
        }
        return 0.0f;
    }

    public final void a() {
        int i2 = this.f84i;
        for (int i3 = 0; i2 != -1 && i3 < this.f76a; i3++) {
            i iVar = this.f78c.f92c[this.f81f[i2]];
            if (iVar != null) {
                iVar.b(this.f77b);
            }
            i2 = this.f82g[i2];
        }
        this.f84i = -1;
        this.j = -1;
        this.k = false;
        this.f76a = 0;
    }

    public final boolean a(i iVar) {
        int i2 = this.f84i;
        if (i2 == -1) {
            return false;
        }
        for (int i3 = 0; i2 != -1 && i3 < this.f76a; i3++) {
            if (this.f81f[i2] == iVar.f114b) {
                return true;
            }
            i2 = this.f82g[i2];
        }
        return false;
    }

    public void a(float f2) {
        int i2 = this.f84i;
        for (int i3 = 0; i2 != -1 && i3 < this.f76a; i3++) {
            float[] fArr = this.f83h;
            fArr[i2] = fArr[i2] / f2;
            i2 = this.f82g[i2];
        }
    }

    public final boolean a(i iVar, e eVar) {
        return iVar.j <= 1;
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x0046  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x008f A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public a.b.b.h.i a(a.b.b.h.e r15) {
        /*
            r14 = this;
            int r0 = r14.f84i
            r1 = 0
            r2 = 0
            r3 = 0
            r4 = r1
            r5 = 0
            r6 = 0
            r7 = 0
            r8 = 0
        La:
            r9 = -1
            if (r0 == r9) goto L97
            int r9 = r14.f76a
            if (r2 >= r9) goto L97
            float[] r9 = r14.f83h
            r10 = r9[r0]
            r11 = 981668463(0x3a83126f, float:0.001)
            a.b.b.h.c r12 = r14.f78c
            a.b.b.h.i[] r12 = r12.f92c
            int[] r13 = r14.f81f
            r13 = r13[r0]
            r12 = r12[r13]
            int r13 = (r10 > r3 ? 1 : (r10 == r3 ? 0 : -1))
            if (r13 >= 0) goto L35
            r11 = -1165815185(0xffffffffba83126f, float:-0.001)
            int r11 = (r10 > r11 ? 1 : (r10 == r11 ? 0 : -1))
            if (r11 <= 0) goto L41
            r9[r0] = r3
            a.b.b.h.b r9 = r14.f77b
            r12.b(r9)
            goto L40
        L35:
            int r11 = (r10 > r11 ? 1 : (r10 == r11 ? 0 : -1))
            if (r11 >= 0) goto L41
            r9[r0] = r3
            a.b.b.h.b r9 = r14.f77b
            r12.b(r9)
        L40:
            r10 = 0
        L41:
            r9 = 1
            int r11 = (r10 > r3 ? 1 : (r10 == r3 ? 0 : -1))
            if (r11 == 0) goto L8f
            a.b.b.h.i$a r11 = r12.f119g
            a.b.b.h.i$a r13 = a.b.b.h.i.a.UNRESTRICTED
            if (r11 != r13) goto L6b
            if (r4 != 0) goto L56
            boolean r4 = r14.a(r12, r15)
        L52:
            r6 = r4
            r5 = r10
            r4 = r12
            goto L8f
        L56:
            int r11 = (r5 > r10 ? 1 : (r5 == r10 ? 0 : -1))
            if (r11 <= 0) goto L5f
            boolean r4 = r14.a(r12, r15)
            goto L52
        L5f:
            if (r6 != 0) goto L8f
            boolean r11 = r14.a(r12, r15)
            if (r11 == 0) goto L8f
            r5 = r10
            r4 = r12
            r6 = 1
            goto L8f
        L6b:
            if (r4 != 0) goto L8f
            int r11 = (r10 > r3 ? 1 : (r10 == r3 ? 0 : -1))
            if (r11 >= 0) goto L8f
            if (r1 != 0) goto L7b
            boolean r1 = r14.a(r12, r15)
        L77:
            r8 = r1
            r7 = r10
            r1 = r12
            goto L8f
        L7b:
            int r11 = (r7 > r10 ? 1 : (r7 == r10 ? 0 : -1))
            if (r11 <= 0) goto L84
            boolean r1 = r14.a(r12, r15)
            goto L77
        L84:
            if (r8 != 0) goto L8f
            boolean r11 = r14.a(r12, r15)
            if (r11 == 0) goto L8f
            r7 = r10
            r1 = r12
            r8 = 1
        L8f:
            int[] r9 = r14.f82g
            r0 = r9[r0]
            int r2 = r2 + 1
            goto La
        L97:
            if (r4 == 0) goto L9a
            return r4
        L9a:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: a.b.b.h.a.a(a.b.b.h.e):a.b.b.h.i");
    }

    public final void a(b bVar, b bVar2, boolean z) {
        int i2 = this.f84i;
        while (true) {
            for (int i3 = 0; i2 != -1 && i3 < this.f76a; i3++) {
                int i4 = this.f81f[i2];
                i iVar = bVar2.f85a;
                if (i4 == iVar.f114b) {
                    float f2 = this.f83h[i2];
                    a(iVar, z);
                    a aVar = bVar2.f88d;
                    int i5 = aVar.f84i;
                    for (int i6 = 0; i5 != -1 && i6 < aVar.f76a; i6++) {
                        a(this.f78c.f92c[aVar.f81f[i5]], aVar.f83h[i5] * f2, z);
                        i5 = aVar.f82g[i5];
                    }
                    bVar.f86b += bVar2.f86b * f2;
                    if (z) {
                        bVar2.f85a.b(bVar);
                    }
                    i2 = this.f84i;
                } else {
                    i2 = this.f82g[i2];
                }
            }
            return;
        }
    }

    public void a(b bVar, b[] bVarArr) {
        int i2 = this.f84i;
        while (true) {
            for (int i3 = 0; i2 != -1 && i3 < this.f76a; i3++) {
                i iVar = this.f78c.f92c[this.f81f[i2]];
                if (iVar.f115c != -1) {
                    float f2 = this.f83h[i2];
                    a(iVar, true);
                    b bVar2 = bVarArr[iVar.f115c];
                    if (!bVar2.f89e) {
                        a aVar = bVar2.f88d;
                        int i4 = aVar.f84i;
                        for (int i5 = 0; i4 != -1 && i5 < aVar.f76a; i5++) {
                            a(this.f78c.f92c[aVar.f81f[i4]], aVar.f83h[i4] * f2, true);
                            i4 = aVar.f82g[i4];
                        }
                    }
                    bVar.f86b += bVar2.f86b * f2;
                    bVar2.f85a.b(bVar);
                    i2 = this.f84i;
                } else {
                    i2 = this.f82g[i2];
                }
            }
            return;
        }
    }

    public i a(boolean[] zArr, i iVar) {
        i.a aVar;
        int i2 = this.f84i;
        i iVar2 = null;
        float f2 = 0.0f;
        for (int i3 = 0; i2 != -1 && i3 < this.f76a; i3++) {
            if (this.f83h[i2] < 0.0f) {
                i iVar3 = this.f78c.f92c[this.f81f[i2]];
                if ((zArr == null || !zArr[iVar3.f114b]) && iVar3 != iVar && ((aVar = iVar3.f119g) == i.a.SLACK || aVar == i.a.ERROR)) {
                    float f3 = this.f83h[i2];
                    if (f3 < f2) {
                        iVar2 = iVar3;
                        f2 = f3;
                    }
                }
            }
            i2 = this.f82g[i2];
        }
        return iVar2;
    }

    public final i a(int i2) {
        int i3 = this.f84i;
        for (int i4 = 0; i3 != -1 && i4 < this.f76a; i4++) {
            if (i4 == i2) {
                return this.f78c.f92c[this.f81f[i3]];
            }
            i3 = this.f82g[i3];
        }
        return null;
    }
}
