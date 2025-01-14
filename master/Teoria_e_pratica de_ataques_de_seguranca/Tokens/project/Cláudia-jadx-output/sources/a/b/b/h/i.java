package a.b.b.h;

import java.util.Arrays;
/* compiled from: SolverVariable.java */
/* loaded from: classes.dex */
public class i {
    public static int k = 1;

    /* renamed from: a  reason: collision with root package name */
    public String f113a;

    /* renamed from: e  reason: collision with root package name */
    public float f117e;

    /* renamed from: g  reason: collision with root package name */
    public a f119g;

    /* renamed from: b  reason: collision with root package name */
    public int f114b = -1;

    /* renamed from: c  reason: collision with root package name */
    public int f115c = -1;

    /* renamed from: d  reason: collision with root package name */
    public int f116d = 0;

    /* renamed from: f  reason: collision with root package name */
    public float[] f118f = new float[7];

    /* renamed from: h  reason: collision with root package name */
    public b[] f120h = new b[8];

    /* renamed from: i  reason: collision with root package name */
    public int f121i = 0;
    public int j = 0;

    /* compiled from: SolverVariable.java */
    /* loaded from: classes.dex */
    public enum a {
        UNRESTRICTED,
        CONSTANT,
        SLACK,
        ERROR,
        UNKNOWN
    }

    public i(a aVar, String str) {
        this.f119g = aVar;
    }

    public static void b() {
        k++;
    }

    public final void a(b bVar) {
        int i2 = 0;
        while (true) {
            int i3 = this.f121i;
            if (i2 < i3) {
                if (this.f120h[i2] == bVar) {
                    return;
                }
                i2++;
            } else {
                b[] bVarArr = this.f120h;
                if (i3 >= bVarArr.length) {
                    this.f120h = (b[]) Arrays.copyOf(bVarArr, bVarArr.length * 2);
                }
                b[] bVarArr2 = this.f120h;
                int i4 = this.f121i;
                bVarArr2[i4] = bVar;
                this.f121i = i4 + 1;
                return;
            }
        }
    }

    public final void c(b bVar) {
        int i2 = this.f121i;
        for (int i3 = 0; i3 < i2; i3++) {
            b[] bVarArr = this.f120h;
            bVarArr[i3].f88d.a(bVarArr[i3], bVar, false);
        }
        this.f121i = 0;
    }

    public String toString() {
        return "" + this.f113a;
    }

    public final void b(b bVar) {
        int i2 = this.f121i;
        for (int i3 = 0; i3 < i2; i3++) {
            if (this.f120h[i3] == bVar) {
                for (int i4 = 0; i4 < (i2 - i3) - 1; i4++) {
                    b[] bVarArr = this.f120h;
                    int i5 = i3 + i4;
                    bVarArr[i5] = bVarArr[i5 + 1];
                }
                this.f121i--;
                return;
            }
        }
    }

    public void a() {
        this.f113a = null;
        this.f119g = a.UNKNOWN;
        this.f116d = 0;
        this.f114b = -1;
        this.f115c = -1;
        this.f117e = 0.0f;
        this.f121i = 0;
        this.j = 0;
    }

    public void a(a aVar, String str) {
        this.f119g = aVar;
    }
}
