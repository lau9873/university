package p000a.p006b.p049h.p060i;

import android.support.p067v7.widget.RecyclerView;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/* renamed from: a.b.h.i.c */
/* loaded from: classes.dex */
public class DiffUtil {

    /* renamed from: a */
    public static final Comparator<C0413f> f2206a = new C0408a();

    /* compiled from: DiffUtil.java */
    /* renamed from: a.b.h.i.c$a */
    /* loaded from: classes.dex */
    public static class C0408a implements Comparator<C0413f> {
        @Override // java.util.Comparator
        /* renamed from: a */
        public int compare(C0413f c0413f, C0413f c0413f2) {
            int i = c0413f.f2221a - c0413f2.f2221a;
            return i == 0 ? c0413f.f2222b - c0413f2.f2222b : i;
        }
    }

    /* compiled from: DiffUtil.java */
    /* renamed from: a.b.h.i.c$b */
    /* loaded from: classes.dex */
    public static abstract class AbstractC0409b {
        /* renamed from: a */
        public abstract int mo8801a();

        /* renamed from: a */
        public abstract boolean mo8800a(int i, int i2);

        /* renamed from: b */
        public abstract int mo8799b();

        /* renamed from: b */
        public abstract boolean mo8798b(int i, int i2);

        /* renamed from: c */
        public Object m8797c(int i, int i2) {
            return null;
        }
    }

    /* compiled from: DiffUtil.java */
    /* renamed from: a.b.h.i.c$d */
    /* loaded from: classes.dex */
    public static class C0411d {

        /* renamed from: a */
        public int f2214a;

        /* renamed from: b */
        public int f2215b;

        /* renamed from: c */
        public boolean f2216c;

        public C0411d(int i, int i2, boolean z) {
            this.f2214a = i;
            this.f2215b = i2;
            this.f2216c = z;
        }
    }

    /* compiled from: DiffUtil.java */
    /* renamed from: a.b.h.i.c$e */
    /* loaded from: classes.dex */
    public static class C0412e {

        /* renamed from: a */
        public int f2217a;

        /* renamed from: b */
        public int f2218b;

        /* renamed from: c */
        public int f2219c;

        /* renamed from: d */
        public int f2220d;

        public C0412e() {
        }

        public C0412e(int i, int i2, int i3, int i4) {
            this.f2217a = i;
            this.f2218b = i2;
            this.f2219c = i3;
            this.f2220d = i4;
        }
    }

    /* compiled from: DiffUtil.java */
    /* renamed from: a.b.h.i.c$f */
    /* loaded from: classes.dex */
    public static class C0413f {

        /* renamed from: a */
        public int f2221a;

        /* renamed from: b */
        public int f2222b;

        /* renamed from: c */
        public int f2223c;

        /* renamed from: d */
        public boolean f2224d;

        /* renamed from: e */
        public boolean f2225e;
    }

    /* renamed from: a */
    public static C0410c m8805a(AbstractC0409b abstractC0409b) {
        return m8803a(abstractC0409b, true);
    }

    /* renamed from: a */
    public static C0410c m8803a(AbstractC0409b abstractC0409b, boolean z) {
        int mo8799b = abstractC0409b.mo8799b();
        int mo8801a = abstractC0409b.mo8801a();
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        arrayList2.add(new C0412e(0, mo8799b, 0, mo8801a));
        int abs = Math.abs(mo8799b - mo8801a) + mo8799b + mo8801a;
        int i = abs * 2;
        int[] iArr = new int[i];
        int[] iArr2 = new int[i];
        ArrayList arrayList3 = new ArrayList();
        while (!arrayList2.isEmpty()) {
            C0412e c0412e = (C0412e) arrayList2.remove(arrayList2.size() - 1);
            C0413f m8804a = m8804a(abstractC0409b, c0412e.f2217a, c0412e.f2218b, c0412e.f2219c, c0412e.f2220d, iArr, iArr2, abs);
            if (m8804a != null) {
                if (m8804a.f2223c > 0) {
                    arrayList.add(m8804a);
                }
                m8804a.f2221a += c0412e.f2217a;
                m8804a.f2222b += c0412e.f2219c;
                C0412e c0412e2 = arrayList3.isEmpty() ? new C0412e() : (C0412e) arrayList3.remove(arrayList3.size() - 1);
                c0412e2.f2217a = c0412e.f2217a;
                c0412e2.f2219c = c0412e.f2219c;
                if (m8804a.f2225e) {
                    c0412e2.f2218b = m8804a.f2221a;
                    c0412e2.f2220d = m8804a.f2222b;
                } else if (m8804a.f2224d) {
                    c0412e2.f2218b = m8804a.f2221a - 1;
                    c0412e2.f2220d = m8804a.f2222b;
                } else {
                    c0412e2.f2218b = m8804a.f2221a;
                    c0412e2.f2220d = m8804a.f2222b - 1;
                }
                arrayList2.add(c0412e2);
                if (m8804a.f2225e) {
                    if (m8804a.f2224d) {
                        int i2 = m8804a.f2221a;
                        int i3 = m8804a.f2223c;
                        c0412e.f2217a = i2 + i3 + 1;
                        c0412e.f2219c = m8804a.f2222b + i3;
                    } else {
                        int i4 = m8804a.f2221a;
                        int i5 = m8804a.f2223c;
                        c0412e.f2217a = i4 + i5;
                        c0412e.f2219c = m8804a.f2222b + i5 + 1;
                    }
                } else {
                    int i6 = m8804a.f2221a;
                    int i7 = m8804a.f2223c;
                    c0412e.f2217a = i6 + i7;
                    c0412e.f2219c = m8804a.f2222b + i7;
                }
                arrayList2.add(c0412e);
            } else {
                arrayList3.add(c0412e);
            }
        }
        Collections.sort(arrayList, f2206a);
        return new C0410c(abstractC0409b, arrayList, iArr, iArr2, z);
    }

    /* compiled from: DiffUtil.java */
    /* renamed from: a.b.h.i.c$c */
    /* loaded from: classes.dex */
    public static class C0410c {

        /* renamed from: a */
        public final List<C0413f> f2207a;

        /* renamed from: b */
        public final int[] f2208b;

        /* renamed from: c */
        public final int[] f2209c;

        /* renamed from: d */
        public final AbstractC0409b f2210d;

        /* renamed from: e */
        public final int f2211e;

        /* renamed from: f */
        public final int f2212f;

        /* renamed from: g */
        public final boolean f2213g;

        public C0410c(AbstractC0409b abstractC0409b, List<C0413f> list, int[] iArr, int[] iArr2, boolean z) {
            this.f2207a = list;
            this.f2208b = iArr;
            this.f2209c = iArr2;
            Arrays.fill(this.f2208b, 0);
            Arrays.fill(this.f2209c, 0);
            this.f2210d = abstractC0409b;
            this.f2211e = abstractC0409b.mo8799b();
            this.f2212f = abstractC0409b.mo8801a();
            this.f2213g = z;
            m8796a();
            m8789b();
        }

        /* renamed from: a */
        public final void m8796a() {
            C0413f c0413f = this.f2207a.isEmpty() ? null : this.f2207a.get(0);
            if (c0413f != null && c0413f.f2221a == 0 && c0413f.f2222b == 0) {
                return;
            }
            C0413f c0413f2 = new C0413f();
            c0413f2.f2221a = 0;
            c0413f2.f2222b = 0;
            c0413f2.f2224d = false;
            c0413f2.f2223c = 0;
            c0413f2.f2225e = false;
            this.f2207a.add(0, c0413f2);
        }

        /* renamed from: b */
        public final void m8789b() {
            int i = this.f2211e;
            int i2 = this.f2212f;
            for (int size = this.f2207a.size() - 1; size >= 0; size--) {
                C0413f c0413f = this.f2207a.get(size);
                int i3 = c0413f.f2221a;
                int i4 = c0413f.f2223c;
                int i5 = i3 + i4;
                int i6 = c0413f.f2222b + i4;
                if (this.f2213g) {
                    while (i > i5) {
                        m8795a(i, i2, size);
                        i--;
                    }
                    while (i2 > i6) {
                        m8788b(i, i2, size);
                        i2--;
                    }
                }
                for (int i7 = 0; i7 < c0413f.f2223c; i7++) {
                    int i8 = c0413f.f2221a + i7;
                    int i9 = c0413f.f2222b + i7;
                    int i10 = this.f2210d.mo8800a(i8, i9) ? 1 : 2;
                    this.f2208b[i8] = (i9 << 5) | i10;
                    this.f2209c[i9] = (i8 << 5) | i10;
                }
                i = c0413f.f2221a;
                i2 = c0413f.f2222b;
            }
        }

        /* renamed from: a */
        public final void m8795a(int i, int i2, int i3) {
            if (this.f2208b[i - 1] != 0) {
                return;
            }
            m8794a(i, i2, i3, false);
        }

        /* renamed from: a */
        public final boolean m8794a(int i, int i2, int i3, boolean z) {
            int i4;
            int i5;
            int i6;
            if (z) {
                i2--;
                i4 = i;
                i5 = i2;
            } else {
                i4 = i - 1;
                i5 = i4;
            }
            while (i3 >= 0) {
                C0413f c0413f = this.f2207a.get(i3);
                int i7 = c0413f.f2221a;
                int i8 = c0413f.f2223c;
                int i9 = i7 + i8;
                int i10 = c0413f.f2222b + i8;
                if (z) {
                    for (int i11 = i4 - 1; i11 >= i9; i11--) {
                        if (this.f2210d.mo8798b(i11, i5)) {
                            i6 = this.f2210d.mo8800a(i11, i5) ? 8 : 4;
                            this.f2209c[i5] = (i11 << 5) | 16;
                            this.f2208b[i11] = (i5 << 5) | i6;
                            return true;
                        }
                    }
                    continue;
                } else {
                    for (int i12 = i2 - 1; i12 >= i10; i12--) {
                        if (this.f2210d.mo8798b(i5, i12)) {
                            i6 = this.f2210d.mo8800a(i5, i12) ? 8 : 4;
                            int i13 = i - 1;
                            this.f2208b[i13] = (i12 << 5) | 16;
                            this.f2209c[i12] = (i13 << 5) | i6;
                            return true;
                        }
                    }
                    continue;
                }
                i4 = c0413f.f2221a;
                i2 = c0413f.f2222b;
                i3--;
            }
            return false;
        }

        /* renamed from: b */
        public final void m8788b(int i, int i2, int i3) {
            if (this.f2209c[i2 - 1] != 0) {
                return;
            }
            m8794a(i, i2, i3, true);
        }

        /* renamed from: b */
        public final void m8787b(List<C0411d> list, ListUpdateCallback listUpdateCallback, int i, int i2, int i3) {
            if (!this.f2213g) {
                listUpdateCallback.mo8786a(i, i2);
                return;
            }
            for (int i4 = i2 - 1; i4 >= 0; i4--) {
                int i5 = i3 + i4;
                int i6 = this.f2208b[i5] & 31;
                if (i6 == 0) {
                    listUpdateCallback.mo8786a(i + i4, 1);
                    for (C0411d c0411d : list) {
                        c0411d.f2215b--;
                    }
                } else if (i6 == 4 || i6 == 8) {
                    int i7 = this.f2208b[i5] >> 5;
                    C0411d m8791a = m8791a(list, i7, false);
                    listUpdateCallback.mo8784b(i + i4, m8791a.f2215b - 1);
                    if (i6 == 4) {
                        listUpdateCallback.mo8785a(m8791a.f2215b - 1, 1, this.f2210d.m8797c(i5, i7));
                    }
                } else if (i6 == 16) {
                    list.add(new C0411d(i5, i + i4, true));
                } else {
                    throw new IllegalStateException("unknown flag for pos " + i5 + " " + Long.toBinaryString(i6));
                }
            }
        }

        /* renamed from: a */
        public void m8792a(RecyclerView.AbstractC0711g abstractC0711g) {
            m8793a(new AdapterListUpdateCallback(abstractC0711g));
        }

        /* renamed from: a */
        public void m8793a(ListUpdateCallback listUpdateCallback) {
            BatchingListUpdateCallback batchingListUpdateCallback;
            if (listUpdateCallback instanceof BatchingListUpdateCallback) {
                batchingListUpdateCallback = (BatchingListUpdateCallback) listUpdateCallback;
            } else {
                batchingListUpdateCallback = new BatchingListUpdateCallback(listUpdateCallback);
            }
            ArrayList arrayList = new ArrayList();
            int i = this.f2211e;
            int i2 = this.f2212f;
            for (int size = this.f2207a.size() - 1; size >= 0; size--) {
                C0413f c0413f = this.f2207a.get(size);
                int i3 = c0413f.f2223c;
                int i4 = c0413f.f2221a + i3;
                int i5 = c0413f.f2222b + i3;
                if (i4 < i) {
                    m8787b(arrayList, batchingListUpdateCallback, i4, i - i4, i4);
                }
                if (i5 < i2) {
                    m8790a(arrayList, batchingListUpdateCallback, i4, i2 - i5, i5);
                }
                for (int i6 = i3 - 1; i6 >= 0; i6--) {
                    int[] iArr = this.f2208b;
                    int i7 = c0413f.f2221a;
                    if ((iArr[i7 + i6] & 31) == 2) {
                        batchingListUpdateCallback.mo8785a(i7 + i6, 1, this.f2210d.m8797c(i7 + i6, c0413f.f2222b + i6));
                    }
                }
                i = c0413f.f2221a;
                i2 = c0413f.f2222b;
            }
            batchingListUpdateCallback.m8806a();
        }

        /* renamed from: a */
        public static C0411d m8791a(List<C0411d> list, int i, boolean z) {
            int size = list.size() - 1;
            while (size >= 0) {
                C0411d c0411d = list.get(size);
                if (c0411d.f2214a == i && c0411d.f2216c == z) {
                    list.remove(size);
                    while (size < list.size()) {
                        list.get(size).f2215b += z ? 1 : -1;
                        size++;
                    }
                    return c0411d;
                }
                size--;
            }
            return null;
        }

        /* renamed from: a */
        public final void m8790a(List<C0411d> list, ListUpdateCallback listUpdateCallback, int i, int i2, int i3) {
            if (!this.f2213g) {
                listUpdateCallback.mo8783c(i, i2);
                return;
            }
            for (int i4 = i2 - 1; i4 >= 0; i4--) {
                int i5 = i3 + i4;
                int i6 = this.f2209c[i5] & 31;
                if (i6 == 0) {
                    listUpdateCallback.mo8783c(i, 1);
                    for (C0411d c0411d : list) {
                        c0411d.f2215b++;
                    }
                } else if (i6 == 4 || i6 == 8) {
                    int i7 = this.f2209c[i5] >> 5;
                    listUpdateCallback.mo8784b(m8791a(list, i7, true).f2215b, i);
                    if (i6 == 4) {
                        listUpdateCallback.mo8785a(i, 1, this.f2210d.m8797c(i7, i5));
                    }
                } else if (i6 == 16) {
                    list.add(new C0411d(i5, i, false));
                } else {
                    throw new IllegalStateException("unknown flag for pos " + i5 + " " + Long.toBinaryString(i6));
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
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static p000a.p006b.p049h.p060i.DiffUtil.C0413f m8804a(p000a.p006b.p049h.p060i.DiffUtil.AbstractC0409b r19, int r20, int r21, int r22, int r23, int[] r24, int[] r25, int r26) {
        /*
            Method dump skipped, instructions count: 309
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: p000a.p006b.p049h.p060i.DiffUtil.m8804a(a.b.h.i.c$b, int, int, int, int, int[], int[], int):a.b.h.i.c$f");
    }
}
