package p000a.p006b.p008b.p009h;

import java.util.Arrays;
import p000a.p006b.p008b.p009h.SolverVariable;

/* renamed from: a.b.b.h.a */
/* loaded from: classes.dex */
public class ArrayLinkedVariables {

    /* renamed from: b */
    public final ArrayRow f154b;

    /* renamed from: c */
    public final Cache f155c;

    /* renamed from: f */
    public int[] f158f;

    /* renamed from: g */
    public int[] f159g;

    /* renamed from: h */
    public float[] f160h;

    /* renamed from: i */
    public int f161i;

    /* renamed from: j */
    public int f162j;

    /* renamed from: k */
    public boolean f163k;

    /* renamed from: a */
    public int f153a = 0;

    /* renamed from: d */
    public int f156d = 8;

    /* renamed from: e */
    public SolverVariable f157e = null;

    public ArrayLinkedVariables(ArrayRow arrayRow, Cache cache) {
        int i = this.f156d;
        this.f158f = new int[i];
        this.f159g = new int[i];
        this.f160h = new float[i];
        this.f161i = -1;
        this.f162j = -1;
        this.f163k = false;
        this.f154b = arrayRow;
        this.f155c = cache;
    }

    /* renamed from: a */
    public final void m11231a(SolverVariable solverVariable, float f) {
        if (f == 0.0f) {
            m11228a(solverVariable, true);
            return;
        }
        int i = this.f161i;
        if (i == -1) {
            this.f161i = 0;
            float[] fArr = this.f160h;
            int i2 = this.f161i;
            fArr[i2] = f;
            this.f158f[i2] = solverVariable.f220b;
            this.f159g[i2] = -1;
            solverVariable.f228j++;
            solverVariable.m11163a(this.f154b);
            this.f153a++;
            if (this.f163k) {
                return;
            }
            this.f162j++;
            int i3 = this.f162j;
            int[] iArr = this.f158f;
            if (i3 >= iArr.length) {
                this.f163k = true;
                this.f162j = iArr.length - 1;
                return;
            }
            return;
        }
        int i4 = -1;
        for (int i5 = 0; i != -1 && i5 < this.f153a; i5++) {
            int[] iArr2 = this.f158f;
            int i6 = iArr2[i];
            int i7 = solverVariable.f220b;
            if (i6 == i7) {
                this.f160h[i] = f;
                return;
            }
            if (iArr2[i] < i7) {
                i4 = i;
            }
            i = this.f159g[i];
        }
        int i8 = this.f162j;
        int i9 = i8 + 1;
        if (this.f163k) {
            int[] iArr3 = this.f158f;
            if (iArr3[i8] != -1) {
                i8 = iArr3.length;
            }
        } else {
            i8 = i9;
        }
        int[] iArr4 = this.f158f;
        if (i8 >= iArr4.length && this.f153a < iArr4.length) {
            int i10 = 0;
            while (true) {
                int[] iArr5 = this.f158f;
                if (i10 >= iArr5.length) {
                    break;
                } else if (iArr5[i10] == -1) {
                    i8 = i10;
                    break;
                } else {
                    i10++;
                }
            }
        }
        int[] iArr6 = this.f158f;
        if (i8 >= iArr6.length) {
            i8 = iArr6.length;
            this.f156d *= 2;
            this.f163k = false;
            this.f162j = i8 - 1;
            this.f160h = Arrays.copyOf(this.f160h, this.f156d);
            this.f158f = Arrays.copyOf(this.f158f, this.f156d);
            this.f159g = Arrays.copyOf(this.f159g, this.f156d);
        }
        this.f158f[i8] = solverVariable.f220b;
        this.f160h[i8] = f;
        if (i4 != -1) {
            int[] iArr7 = this.f159g;
            iArr7[i8] = iArr7[i4];
            iArr7[i4] = i8;
        } else {
            this.f159g[i8] = this.f161i;
            this.f161i = i8;
        }
        solverVariable.f228j++;
        solverVariable.m11163a(this.f154b);
        this.f153a++;
        if (!this.f163k) {
            this.f162j++;
        }
        if (this.f153a >= this.f158f.length) {
            this.f163k = true;
        }
        int i11 = this.f162j;
        int[] iArr8 = this.f158f;
        if (i11 >= iArr8.length) {
            this.f163k = true;
            this.f162j = iArr8.length - 1;
        }
    }

    /* renamed from: b */
    public void m11226b() {
        int i = this.f161i;
        for (int i2 = 0; i != -1 && i2 < this.f153a; i2++) {
            float[] fArr = this.f160h;
            fArr[i] = fArr[i] * (-1.0f);
            i = this.f159g[i];
        }
    }

    public String toString() {
        int i = this.f161i;
        String str = "";
        for (int i2 = 0; i != -1 && i2 < this.f153a; i2++) {
            str = ((str + " -> ") + this.f160h[i] + " : ") + this.f155c.f171c[this.f158f[i]];
            i = this.f159g[i];
        }
        return str;
    }

    /* renamed from: b */
    public final float m11225b(int i) {
        int i2 = this.f161i;
        for (int i3 = 0; i2 != -1 && i3 < this.f153a; i3++) {
            if (i3 == i) {
                return this.f160h[i2];
            }
            i2 = this.f159g[i2];
        }
        return 0.0f;
    }

    /* renamed from: b */
    public final float m11224b(SolverVariable solverVariable) {
        int i = this.f161i;
        for (int i2 = 0; i != -1 && i2 < this.f153a; i2++) {
            if (this.f158f[i] == solverVariable.f220b) {
                return this.f160h[i];
            }
            i = this.f159g[i];
        }
        return 0.0f;
    }

    /* renamed from: a */
    public final void m11230a(SolverVariable solverVariable, float f, boolean z) {
        if (f == 0.0f) {
            return;
        }
        int i = this.f161i;
        if (i == -1) {
            this.f161i = 0;
            float[] fArr = this.f160h;
            int i2 = this.f161i;
            fArr[i2] = f;
            this.f158f[i2] = solverVariable.f220b;
            this.f159g[i2] = -1;
            solverVariable.f228j++;
            solverVariable.m11163a(this.f154b);
            this.f153a++;
            if (this.f163k) {
                return;
            }
            this.f162j++;
            int i3 = this.f162j;
            int[] iArr = this.f158f;
            if (i3 >= iArr.length) {
                this.f163k = true;
                this.f162j = iArr.length - 1;
                return;
            }
            return;
        }
        int i4 = -1;
        for (int i5 = 0; i != -1 && i5 < this.f153a; i5++) {
            int[] iArr2 = this.f158f;
            int i6 = iArr2[i];
            int i7 = solverVariable.f220b;
            if (i6 == i7) {
                float[] fArr2 = this.f160h;
                fArr2[i] = fArr2[i] + f;
                if (fArr2[i] == 0.0f) {
                    if (i == this.f161i) {
                        this.f161i = this.f159g[i];
                    } else {
                        int[] iArr3 = this.f159g;
                        iArr3[i4] = iArr3[i];
                    }
                    if (z) {
                        solverVariable.m11160b(this.f154b);
                    }
                    if (this.f163k) {
                        this.f162j = i;
                    }
                    solverVariable.f228j--;
                    this.f153a--;
                    return;
                }
                return;
            }
            if (iArr2[i] < i7) {
                i4 = i;
            }
            i = this.f159g[i];
        }
        int i8 = this.f162j;
        int i9 = i8 + 1;
        if (this.f163k) {
            int[] iArr4 = this.f158f;
            if (iArr4[i8] != -1) {
                i8 = iArr4.length;
            }
        } else {
            i8 = i9;
        }
        int[] iArr5 = this.f158f;
        if (i8 >= iArr5.length && this.f153a < iArr5.length) {
            int i10 = 0;
            while (true) {
                int[] iArr6 = this.f158f;
                if (i10 >= iArr6.length) {
                    break;
                } else if (iArr6[i10] == -1) {
                    i8 = i10;
                    break;
                } else {
                    i10++;
                }
            }
        }
        int[] iArr7 = this.f158f;
        if (i8 >= iArr7.length) {
            i8 = iArr7.length;
            this.f156d *= 2;
            this.f163k = false;
            this.f162j = i8 - 1;
            this.f160h = Arrays.copyOf(this.f160h, this.f156d);
            this.f158f = Arrays.copyOf(this.f158f, this.f156d);
            this.f159g = Arrays.copyOf(this.f159g, this.f156d);
        }
        this.f158f[i8] = solverVariable.f220b;
        this.f160h[i8] = f;
        if (i4 != -1) {
            int[] iArr8 = this.f159g;
            iArr8[i8] = iArr8[i4];
            iArr8[i4] = i8;
        } else {
            this.f159g[i8] = this.f161i;
            this.f161i = i8;
        }
        solverVariable.f228j++;
        solverVariable.m11163a(this.f154b);
        this.f153a++;
        if (!this.f163k) {
            this.f162j++;
        }
        int i11 = this.f162j;
        int[] iArr9 = this.f158f;
        if (i11 >= iArr9.length) {
            this.f163k = true;
            this.f162j = iArr9.length - 1;
        }
    }

    /* renamed from: a */
    public final float m11228a(SolverVariable solverVariable, boolean z) {
        if (this.f157e == solverVariable) {
            this.f157e = null;
        }
        int i = this.f161i;
        if (i == -1) {
            return 0.0f;
        }
        int i2 = 0;
        int i3 = -1;
        while (i != -1 && i2 < this.f153a) {
            if (this.f158f[i] == solverVariable.f220b) {
                if (i == this.f161i) {
                    this.f161i = this.f159g[i];
                } else {
                    int[] iArr = this.f159g;
                    iArr[i3] = iArr[i];
                }
                if (z) {
                    solverVariable.m11160b(this.f154b);
                }
                solverVariable.f228j--;
                this.f153a--;
                this.f158f[i] = -1;
                if (this.f163k) {
                    this.f162j = i;
                }
                return this.f160h[i];
            }
            i2++;
            i3 = i;
            i = this.f159g[i];
        }
        return 0.0f;
    }

    /* renamed from: a */
    public final void m11238a() {
        int i = this.f161i;
        for (int i2 = 0; i != -1 && i2 < this.f153a; i2++) {
            SolverVariable solverVariable = this.f155c.f171c[this.f158f[i]];
            if (solverVariable != null) {
                solverVariable.m11160b(this.f154b);
            }
            i = this.f159g[i];
        }
        this.f161i = -1;
        this.f162j = -1;
        this.f163k = false;
        this.f153a = 0;
    }

    /* renamed from: a */
    public final boolean m11232a(SolverVariable solverVariable) {
        int i = this.f161i;
        if (i == -1) {
            return false;
        }
        for (int i2 = 0; i != -1 && i2 < this.f153a; i2++) {
            if (this.f158f[i] == solverVariable.f220b) {
                return true;
            }
            i = this.f159g[i];
        }
        return false;
    }

    /* renamed from: a */
    public void m11237a(float f) {
        int i = this.f161i;
        for (int i2 = 0; i != -1 && i2 < this.f153a; i2++) {
            float[] fArr = this.f160h;
            fArr[i] = fArr[i] / f;
            i = this.f159g[i];
        }
    }

    /* renamed from: a */
    public final boolean m11229a(SolverVariable solverVariable, LinearSystem linearSystem) {
        return solverVariable.f228j <= 1;
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x0046  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x008f A[SYNTHETIC] */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public p000a.p006b.p008b.p009h.SolverVariable m11233a(p000a.p006b.p008b.p009h.LinearSystem r15) {
        /*
            r14 = this;
            int r0 = r14.f161i
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
            int r9 = r14.f153a
            if (r2 >= r9) goto L97
            float[] r9 = r14.f160h
            r10 = r9[r0]
            r11 = 981668463(0x3a83126f, float:0.001)
            a.b.b.h.c r12 = r14.f155c
            a.b.b.h.i[] r12 = r12.f171c
            int[] r13 = r14.f158f
            r13 = r13[r0]
            r12 = r12[r13]
            int r13 = (r10 > r3 ? 1 : (r10 == r3 ? 0 : -1))
            if (r13 >= 0) goto L35
            r11 = -1165815185(0xffffffffba83126f, float:-0.001)
            int r11 = (r10 > r11 ? 1 : (r10 == r11 ? 0 : -1))
            if (r11 <= 0) goto L41
            r9[r0] = r3
            a.b.b.h.b r9 = r14.f154b
            r12.m11160b(r9)
            goto L40
        L35:
            int r11 = (r10 > r11 ? 1 : (r10 == r11 ? 0 : -1))
            if (r11 >= 0) goto L41
            r9[r0] = r3
            a.b.b.h.b r9 = r14.f154b
            r12.m11160b(r9)
        L40:
            r10 = 0
        L41:
            r9 = 1
            int r11 = (r10 > r3 ? 1 : (r10 == r3 ? 0 : -1))
            if (r11 == 0) goto L8f
            a.b.b.h.i$a r11 = r12.f225g
            a.b.b.h.i$a r13 = p000a.p006b.p008b.p009h.SolverVariable.EnumC0026a.UNRESTRICTED
            if (r11 != r13) goto L6b
            if (r4 != 0) goto L56
            boolean r4 = r14.m11229a(r12, r15)
        L52:
            r6 = r4
            r5 = r10
            r4 = r12
            goto L8f
        L56:
            int r11 = (r5 > r10 ? 1 : (r5 == r10 ? 0 : -1))
            if (r11 <= 0) goto L5f
            boolean r4 = r14.m11229a(r12, r15)
            goto L52
        L5f:
            if (r6 != 0) goto L8f
            boolean r11 = r14.m11229a(r12, r15)
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
            boolean r1 = r14.m11229a(r12, r15)
        L77:
            r8 = r1
            r7 = r10
            r1 = r12
            goto L8f
        L7b:
            int r11 = (r7 > r10 ? 1 : (r7 == r10 ? 0 : -1))
            if (r11 <= 0) goto L84
            boolean r1 = r14.m11229a(r12, r15)
            goto L77
        L84:
            if (r8 != 0) goto L8f
            boolean r11 = r14.m11229a(r12, r15)
            if (r11 == 0) goto L8f
            r7 = r10
            r1 = r12
            r8 = 1
        L8f:
            int[] r9 = r14.f159g
            r0 = r9[r0]
            int r2 = r2 + 1
            goto La
        L97:
            if (r4 == 0) goto L9a
            return r4
        L9a:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: p000a.p006b.p008b.p009h.ArrayLinkedVariables.m11233a(a.b.b.h.e):a.b.b.h.i");
    }

    /* renamed from: a */
    public final void m11235a(ArrayRow arrayRow, ArrayRow arrayRow2, boolean z) {
        int i = this.f161i;
        while (true) {
            for (int i2 = 0; i != -1 && i2 < this.f153a; i2++) {
                int i3 = this.f158f[i];
                SolverVariable solverVariable = arrayRow2.f164a;
                if (i3 == solverVariable.f220b) {
                    float f = this.f160h[i];
                    m11228a(solverVariable, z);
                    ArrayLinkedVariables arrayLinkedVariables = arrayRow2.f167d;
                    int i4 = arrayLinkedVariables.f161i;
                    for (int i5 = 0; i4 != -1 && i5 < arrayLinkedVariables.f153a; i5++) {
                        m11230a(this.f155c.f171c[arrayLinkedVariables.f158f[i4]], arrayLinkedVariables.f160h[i4] * f, z);
                        i4 = arrayLinkedVariables.f159g[i4];
                    }
                    arrayRow.f165b += arrayRow2.f165b * f;
                    if (z) {
                        arrayRow2.f164a.m11160b(arrayRow);
                    }
                    i = this.f161i;
                } else {
                    i = this.f159g[i];
                }
            }
            return;
        }
    }

    /* renamed from: a */
    public void m11234a(ArrayRow arrayRow, ArrayRow[] arrayRowArr) {
        int i = this.f161i;
        while (true) {
            for (int i2 = 0; i != -1 && i2 < this.f153a; i2++) {
                SolverVariable solverVariable = this.f155c.f171c[this.f158f[i]];
                if (solverVariable.f221c != -1) {
                    float f = this.f160h[i];
                    m11228a(solverVariable, true);
                    ArrayRow arrayRow2 = arrayRowArr[solverVariable.f221c];
                    if (!arrayRow2.f168e) {
                        ArrayLinkedVariables arrayLinkedVariables = arrayRow2.f167d;
                        int i3 = arrayLinkedVariables.f161i;
                        for (int i4 = 0; i3 != -1 && i4 < arrayLinkedVariables.f153a; i4++) {
                            m11230a(this.f155c.f171c[arrayLinkedVariables.f158f[i3]], arrayLinkedVariables.f160h[i3] * f, true);
                            i3 = arrayLinkedVariables.f159g[i3];
                        }
                    }
                    arrayRow.f165b += arrayRow2.f165b * f;
                    arrayRow2.f164a.m11160b(arrayRow);
                    i = this.f161i;
                } else {
                    i = this.f159g[i];
                }
            }
            return;
        }
    }

    /* renamed from: a */
    public SolverVariable m11227a(boolean[] zArr, SolverVariable solverVariable) {
        SolverVariable.EnumC0026a enumC0026a;
        int i = this.f161i;
        SolverVariable solverVariable2 = null;
        float f = 0.0f;
        for (int i2 = 0; i != -1 && i2 < this.f153a; i2++) {
            if (this.f160h[i] < 0.0f) {
                SolverVariable solverVariable3 = this.f155c.f171c[this.f158f[i]];
                if ((zArr == null || !zArr[solverVariable3.f220b]) && solverVariable3 != solverVariable && ((enumC0026a = solverVariable3.f225g) == SolverVariable.EnumC0026a.SLACK || enumC0026a == SolverVariable.EnumC0026a.ERROR)) {
                    float f2 = this.f160h[i];
                    if (f2 < f) {
                        solverVariable2 = solverVariable3;
                        f = f2;
                    }
                }
            }
            i = this.f159g[i];
        }
        return solverVariable2;
    }

    /* renamed from: a */
    public final SolverVariable m11236a(int i) {
        int i2 = this.f161i;
        for (int i3 = 0; i2 != -1 && i3 < this.f153a; i3++) {
            if (i3 == i) {
                return this.f155c.f171c[this.f158f[i2]];
            }
            i2 = this.f159g[i2];
        }
        return null;
    }
}
