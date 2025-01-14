package p000a.p006b.p008b.p009h;

import java.util.Arrays;

/* renamed from: a.b.b.h.i */
/* loaded from: classes.dex */
public class SolverVariable {

    /* renamed from: k */
    public static int f218k = 1;

    /* renamed from: a */
    public String f219a;

    /* renamed from: e */
    public float f223e;

    /* renamed from: g */
    public EnumC0026a f225g;

    /* renamed from: b */
    public int f220b = -1;

    /* renamed from: c */
    public int f221c = -1;

    /* renamed from: d */
    public int f222d = 0;

    /* renamed from: f */
    public float[] f224f = new float[7];

    /* renamed from: h */
    public ArrayRow[] f226h = new ArrayRow[8];

    /* renamed from: i */
    public int f227i = 0;

    /* renamed from: j */
    public int f228j = 0;

    /* compiled from: SolverVariable.java */
    /* renamed from: a.b.b.h.i$a */
    /* loaded from: classes.dex */
    public enum EnumC0026a {
        UNRESTRICTED,
        CONSTANT,
        SLACK,
        ERROR,
        UNKNOWN
    }

    public SolverVariable(EnumC0026a enumC0026a, String str) {
        this.f225g = enumC0026a;
    }

    /* renamed from: b */
    public static void m11161b() {
        f218k++;
    }

    /* renamed from: a */
    public final void m11163a(ArrayRow arrayRow) {
        int i = 0;
        while (true) {
            int i2 = this.f227i;
            if (i < i2) {
                if (this.f226h[i] == arrayRow) {
                    return;
                }
                i++;
            } else {
                ArrayRow[] arrayRowArr = this.f226h;
                if (i2 >= arrayRowArr.length) {
                    this.f226h = (ArrayRow[]) Arrays.copyOf(arrayRowArr, arrayRowArr.length * 2);
                }
                ArrayRow[] arrayRowArr2 = this.f226h;
                int i3 = this.f227i;
                arrayRowArr2[i3] = arrayRow;
                this.f227i = i3 + 1;
                return;
            }
        }
    }

    /* renamed from: c */
    public final void m11159c(ArrayRow arrayRow) {
        int i = this.f227i;
        for (int i2 = 0; i2 < i; i2++) {
            ArrayRow[] arrayRowArr = this.f226h;
            arrayRowArr[i2].f167d.m11235a(arrayRowArr[i2], arrayRow, false);
        }
        this.f227i = 0;
    }

    public String toString() {
        return "" + this.f219a;
    }

    /* renamed from: b */
    public final void m11160b(ArrayRow arrayRow) {
        int i = this.f227i;
        for (int i2 = 0; i2 < i; i2++) {
            if (this.f226h[i2] == arrayRow) {
                for (int i3 = 0; i3 < (i - i2) - 1; i3++) {
                    ArrayRow[] arrayRowArr = this.f226h;
                    int i4 = i2 + i3;
                    arrayRowArr[i4] = arrayRowArr[i4 + 1];
                }
                this.f227i--;
                return;
            }
        }
    }

    /* renamed from: a */
    public void m11164a() {
        this.f219a = null;
        this.f225g = EnumC0026a.UNKNOWN;
        this.f222d = 0;
        this.f220b = -1;
        this.f221c = -1;
        this.f223e = 0.0f;
        this.f227i = 0;
        this.f228j = 0;
    }

    /* renamed from: a */
    public void m11162a(EnumC0026a enumC0026a, String str) {
        this.f225g = enumC0026a;
    }
}
