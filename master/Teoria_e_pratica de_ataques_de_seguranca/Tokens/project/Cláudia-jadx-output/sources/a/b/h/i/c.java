package a.b.h.i;

import android.support.v7.widget.RecyclerView;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
/* compiled from: DiffUtil.java */
/* loaded from: classes.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    public static final Comparator<f> f1456a = new a();

    /* compiled from: DiffUtil.java */
    /* loaded from: classes.dex */
    public static class a implements Comparator<f> {
        @Override // java.util.Comparator
        /* renamed from: a */
        public int compare(f fVar, f fVar2) {
            int i2 = fVar.f1471a - fVar2.f1471a;
            return i2 == 0 ? fVar.f1472b - fVar2.f1472b : i2;
        }
    }

    /* compiled from: DiffUtil.java */
    /* loaded from: classes.dex */
    public static abstract class b {
        public abstract int a();

        public abstract boolean a(int i2, int i3);

        public abstract int b();

        public abstract boolean b(int i2, int i3);

        public Object c(int i2, int i3) {
            return null;
        }
    }

    /* compiled from: DiffUtil.java */
    /* loaded from: classes.dex */
    public static class d {

        /* renamed from: a  reason: collision with root package name */
        public int f1464a;

        /* renamed from: b  reason: collision with root package name */
        public int f1465b;

        /* renamed from: c  reason: collision with root package name */
        public boolean f1466c;

        public d(int i2, int i3, boolean z) {
            this.f1464a = i2;
            this.f1465b = i3;
            this.f1466c = z;
        }
    }

    /* compiled from: DiffUtil.java */
    /* loaded from: classes.dex */
    public static class e {

        /* renamed from: a  reason: collision with root package name */
        public int f1467a;

        /* renamed from: b  reason: collision with root package name */
        public int f1468b;

        /* renamed from: c  reason: collision with root package name */
        public int f1469c;

        /* renamed from: d  reason: collision with root package name */
        public int f1470d;

        public e() {
        }

        public e(int i2, int i3, int i4, int i5) {
            this.f1467a = i2;
            this.f1468b = i3;
            this.f1469c = i4;
            this.f1470d = i5;
        }
    }

    /* compiled from: DiffUtil.java */
    /* loaded from: classes.dex */
    public static class f {

        /* renamed from: a  reason: collision with root package name */
        public int f1471a;

        /* renamed from: b  reason: collision with root package name */
        public int f1472b;

        /* renamed from: c  reason: collision with root package name */
        public int f1473c;

        /* renamed from: d  reason: collision with root package name */
        public boolean f1474d;

        /* renamed from: e  reason: collision with root package name */
        public boolean f1475e;
    }

    public static C0041c a(b bVar) {
        return a(bVar, true);
    }

    public static C0041c a(b bVar, boolean z) {
        int b2 = bVar.b();
        int a2 = bVar.a();
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        arrayList2.add(new e(0, b2, 0, a2));
        int abs = Math.abs(b2 - a2) + b2 + a2;
        int i2 = abs * 2;
        int[] iArr = new int[i2];
        int[] iArr2 = new int[i2];
        ArrayList arrayList3 = new ArrayList();
        while (!arrayList2.isEmpty()) {
            e eVar = (e) arrayList2.remove(arrayList2.size() - 1);
            f a3 = a(bVar, eVar.f1467a, eVar.f1468b, eVar.f1469c, eVar.f1470d, iArr, iArr2, abs);
            if (a3 != null) {
                if (a3.f1473c > 0) {
                    arrayList.add(a3);
                }
                a3.f1471a += eVar.f1467a;
                a3.f1472b += eVar.f1469c;
                e eVar2 = arrayList3.isEmpty() ? new e() : (e) arrayList3.remove(arrayList3.size() - 1);
                eVar2.f1467a = eVar.f1467a;
                eVar2.f1469c = eVar.f1469c;
                if (a3.f1475e) {
                    eVar2.f1468b = a3.f1471a;
                    eVar2.f1470d = a3.f1472b;
                } else if (a3.f1474d) {
                    eVar2.f1468b = a3.f1471a - 1;
                    eVar2.f1470d = a3.f1472b;
                } else {
                    eVar2.f1468b = a3.f1471a;
                    eVar2.f1470d = a3.f1472b - 1;
                }
                arrayList2.add(eVar2);
                if (a3.f1475e) {
                    if (a3.f1474d) {
                        int i3 = a3.f1471a;
                        int i4 = a3.f1473c;
                        eVar.f1467a = i3 + i4 + 1;
                        eVar.f1469c = a3.f1472b + i4;
                    } else {
                        int i5 = a3.f1471a;
                        int i6 = a3.f1473c;
                        eVar.f1467a = i5 + i6;
                        eVar.f1469c = a3.f1472b + i6 + 1;
                    }
                } else {
                    int i7 = a3.f1471a;
                    int i8 = a3.f1473c;
                    eVar.f1467a = i7 + i8;
                    eVar.f1469c = a3.f1472b + i8;
                }
                arrayList2.add(eVar);
            } else {
                arrayList3.add(eVar);
            }
        }
        Collections.sort(arrayList, f1456a);
        return new C0041c(bVar, arrayList, iArr, iArr2, z);
    }

    /* compiled from: DiffUtil.java */
    /* renamed from: a.b.h.i.c$c  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0041c {

        /* renamed from: a  reason: collision with root package name */
        public final List<f> f1457a;

        /* renamed from: b  reason: collision with root package name */
        public final int[] f1458b;

        /* renamed from: c  reason: collision with root package name */
        public final int[] f1459c;

        /* renamed from: d  reason: collision with root package name */
        public final b f1460d;

        /* renamed from: e  reason: collision with root package name */
        public final int f1461e;

        /* renamed from: f  reason: collision with root package name */
        public final int f1462f;

        /* renamed from: g  reason: collision with root package name */
        public final boolean f1463g;

        public C0041c(b bVar, List<f> list, int[] iArr, int[] iArr2, boolean z) {
            this.f1457a = list;
            this.f1458b = iArr;
            this.f1459c = iArr2;
            Arrays.fill(this.f1458b, 0);
            Arrays.fill(this.f1459c, 0);
            this.f1460d = bVar;
            this.f1461e = bVar.b();
            this.f1462f = bVar.a();
            this.f1463g = z;
            a();
            b();
        }

        public final void a() {
            f fVar = this.f1457a.isEmpty() ? null : this.f1457a.get(0);
            if (fVar != null && fVar.f1471a == 0 && fVar.f1472b == 0) {
                return;
            }
            f fVar2 = new f();
            fVar2.f1471a = 0;
            fVar2.f1472b = 0;
            fVar2.f1474d = false;
            fVar2.f1473c = 0;
            fVar2.f1475e = false;
            this.f1457a.add(0, fVar2);
        }

        public final void b() {
            int i2 = this.f1461e;
            int i3 = this.f1462f;
            for (int size = this.f1457a.size() - 1; size >= 0; size--) {
                f fVar = this.f1457a.get(size);
                int i4 = fVar.f1471a;
                int i5 = fVar.f1473c;
                int i6 = i4 + i5;
                int i7 = fVar.f1472b + i5;
                if (this.f1463g) {
                    while (i2 > i6) {
                        a(i2, i3, size);
                        i2--;
                    }
                    while (i3 > i7) {
                        b(i2, i3, size);
                        i3--;
                    }
                }
                for (int i8 = 0; i8 < fVar.f1473c; i8++) {
                    int i9 = fVar.f1471a + i8;
                    int i10 = fVar.f1472b + i8;
                    int i11 = this.f1460d.a(i9, i10) ? 1 : 2;
                    this.f1458b[i9] = (i10 << 5) | i11;
                    this.f1459c[i10] = (i9 << 5) | i11;
                }
                i2 = fVar.f1471a;
                i3 = fVar.f1472b;
            }
        }

        public final void a(int i2, int i3, int i4) {
            if (this.f1458b[i2 - 1] != 0) {
                return;
            }
            a(i2, i3, i4, false);
        }

        public final boolean a(int i2, int i3, int i4, boolean z) {
            int i5;
            int i6;
            int i7;
            if (z) {
                i3--;
                i5 = i2;
                i6 = i3;
            } else {
                i5 = i2 - 1;
                i6 = i5;
            }
            while (i4 >= 0) {
                f fVar = this.f1457a.get(i4);
                int i8 = fVar.f1471a;
                int i9 = fVar.f1473c;
                int i10 = i8 + i9;
                int i11 = fVar.f1472b + i9;
                if (z) {
                    for (int i12 = i5 - 1; i12 >= i10; i12--) {
                        if (this.f1460d.b(i12, i6)) {
                            i7 = this.f1460d.a(i12, i6) ? 8 : 4;
                            this.f1459c[i6] = (i12 << 5) | 16;
                            this.f1458b[i12] = (i6 << 5) | i7;
                            return true;
                        }
                    }
                    continue;
                } else {
                    for (int i13 = i3 - 1; i13 >= i11; i13--) {
                        if (this.f1460d.b(i6, i13)) {
                            i7 = this.f1460d.a(i6, i13) ? 8 : 4;
                            int i14 = i2 - 1;
                            this.f1458b[i14] = (i13 << 5) | 16;
                            this.f1459c[i13] = (i14 << 5) | i7;
                            return true;
                        }
                    }
                    continue;
                }
                i5 = fVar.f1471a;
                i3 = fVar.f1472b;
                i4--;
            }
            return false;
        }

        public final void b(int i2, int i3, int i4) {
            if (this.f1459c[i3 - 1] != 0) {
                return;
            }
            a(i2, i3, i4, true);
        }

        public final void b(List<d> list, a.b.h.i.d dVar, int i2, int i3, int i4) {
            if (!this.f1463g) {
                dVar.a(i2, i3);
                return;
            }
            for (int i5 = i3 - 1; i5 >= 0; i5--) {
                int i6 = i4 + i5;
                int i7 = this.f1458b[i6] & 31;
                if (i7 == 0) {
                    dVar.a(i2 + i5, 1);
                    for (d dVar2 : list) {
                        dVar2.f1465b--;
                    }
                } else if (i7 == 4 || i7 == 8) {
                    int i8 = this.f1458b[i6] >> 5;
                    d a2 = a(list, i8, false);
                    dVar.b(i2 + i5, a2.f1465b - 1);
                    if (i7 == 4) {
                        dVar.a(a2.f1465b - 1, 1, this.f1460d.c(i6, i8));
                    }
                } else if (i7 == 16) {
                    list.add(new d(i6, i2 + i5, true));
                } else {
                    throw new IllegalStateException("unknown flag for pos " + i6 + " " + Long.toBinaryString(i7));
                }
            }
        }

        public void a(RecyclerView.g gVar) {
            a(new a.b.h.i.a(gVar));
        }

        public void a(a.b.h.i.d dVar) {
            a.b.h.i.b bVar;
            if (dVar instanceof a.b.h.i.b) {
                bVar = (a.b.h.i.b) dVar;
            } else {
                bVar = new a.b.h.i.b(dVar);
            }
            ArrayList arrayList = new ArrayList();
            int i2 = this.f1461e;
            int i3 = this.f1462f;
            for (int size = this.f1457a.size() - 1; size >= 0; size--) {
                f fVar = this.f1457a.get(size);
                int i4 = fVar.f1473c;
                int i5 = fVar.f1471a + i4;
                int i6 = fVar.f1472b + i4;
                if (i5 < i2) {
                    b(arrayList, bVar, i5, i2 - i5, i5);
                }
                if (i6 < i3) {
                    a(arrayList, bVar, i5, i3 - i6, i6);
                }
                for (int i7 = i4 - 1; i7 >= 0; i7--) {
                    int[] iArr = this.f1458b;
                    int i8 = fVar.f1471a;
                    if ((iArr[i8 + i7] & 31) == 2) {
                        bVar.a(i8 + i7, 1, this.f1460d.c(i8 + i7, fVar.f1472b + i7));
                    }
                }
                i2 = fVar.f1471a;
                i3 = fVar.f1472b;
            }
            bVar.a();
        }

        public static d a(List<d> list, int i2, boolean z) {
            int size = list.size() - 1;
            while (size >= 0) {
                d dVar = list.get(size);
                if (dVar.f1464a == i2 && dVar.f1466c == z) {
                    list.remove(size);
                    while (size < list.size()) {
                        list.get(size).f1465b += z ? 1 : -1;
                        size++;
                    }
                    return dVar;
                }
                size--;
            }
            return null;
        }

        public final void a(List<d> list, a.b.h.i.d dVar, int i2, int i3, int i4) {
            if (!this.f1463g) {
                dVar.c(i2, i3);
                return;
            }
            for (int i5 = i3 - 1; i5 >= 0; i5--) {
                int i6 = i4 + i5;
                int i7 = this.f1459c[i6] & 31;
                if (i7 == 0) {
                    dVar.c(i2, 1);
                    for (d dVar2 : list) {
                        dVar2.f1465b++;
                    }
                } else if (i7 == 4 || i7 == 8) {
                    int i8 = this.f1459c[i6] >> 5;
                    dVar.b(a(list, i8, true).f1465b, i2);
                    if (i7 == 4) {
                        dVar.a(i2, 1, this.f1460d.c(i8, i6));
                    }
                } else if (i7 == 16) {
                    list.add(new d(i6, i2, false));
                } else {
                    throw new IllegalStateException("unknown flag for pos " + i6 + " " + Long.toBinaryString(i7));
                }
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:17:0x0042, code lost:
        if (r24[r13 - 1] < r24[r13 + r5]) goto L42;
     */
    /* JADX WARN: Code restructure failed: missing block: B:45:0x00ba, code lost:
        if (r25[r13 - 1] < r25[r13 + 1]) goto L77;
     */
    /* JADX WARN: Removed duplicated region for block: B:56:0x00e3 A[LOOP:4: B:52:0x00cf->B:56:0x00e3, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:88:0x00ee A[EDGE_INSN: B:88:0x00ee->B:58:0x00ee ?: BREAK  , SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static a.b.h.i.c.f a(a.b.h.i.c.b r19, int r20, int r21, int r22, int r23, int[] r24, int[] r25, int r26) {
        /*
            Method dump skipped, instructions count: 309
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: a.b.h.i.c.a(a.b.h.i.c$b, int, int, int, int, int[], int[], int):a.b.h.i.c$f");
    }
}
