package p000a.p006b.p049h.p063k;

import java.util.List;
import p000a.p006b.p049h.p063k.AdapterHelper;

/* renamed from: a.b.h.k.v0 */
/* loaded from: classes.dex */
public class OpReorderer {

    /* renamed from: a */
    public final InterfaceC0506a f2969a;

    /* compiled from: OpReorderer.java */
    /* renamed from: a.b.h.k.v0$a */
    /* loaded from: classes.dex */
    public interface InterfaceC0506a {
        /* renamed from: a */
        AdapterHelper.C0451b mo8030a(int i, int i2, int i3, Object obj);

        /* renamed from: a */
        void mo8029a(AdapterHelper.C0451b c0451b);
    }

    public OpReorderer(InterfaceC0506a interfaceC0506a) {
        this.f2969a = interfaceC0506a;
    }

    /* renamed from: a */
    public final void m8035a(List<AdapterHelper.C0451b> list, int i, int i2) {
        AdapterHelper.C0451b c0451b = list.get(i);
        AdapterHelper.C0451b c0451b2 = list.get(i2);
        int i3 = c0451b2.f2581a;
        if (i3 == 1) {
            m8034a(list, i, c0451b, i2, c0451b2);
        } else if (i3 == 2) {
            m8032b(list, i, c0451b, i2, c0451b2);
        } else if (i3 != 4) {
        } else {
            m8031c(list, i, c0451b, i2, c0451b2);
        }
    }

    /* renamed from: b */
    public void m8033b(List<AdapterHelper.C0451b> list) {
        while (true) {
            int m8036a = m8036a(list);
            if (m8036a == -1) {
                return;
            }
            m8035a(list, m8036a, m8036a + 1);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x0027  */
    /* JADX WARN: Removed duplicated region for block: B:12:0x002b  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0048  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x004c  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0056  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x005b  */
    /* JADX WARN: Removed duplicated region for block: B:24:? A[RETURN, SYNTHETIC] */
    /* renamed from: c */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void m8031c(java.util.List<p000a.p006b.p049h.p063k.AdapterHelper.C0451b> r9, int r10, p000a.p006b.p049h.p063k.AdapterHelper.C0451b r11, int r12, p000a.p006b.p049h.p063k.AdapterHelper.C0451b r13) {
        /*
            r8 = this;
            int r0 = r11.f2584d
            int r1 = r13.f2582b
            r2 = 4
            r3 = 0
            r4 = 1
            if (r0 >= r1) goto Ld
            int r1 = r1 - r4
            r13.f2582b = r1
            goto L20
        Ld:
            int r5 = r13.f2584d
            int r1 = r1 + r5
            if (r0 >= r1) goto L20
            int r5 = r5 - r4
            r13.f2584d = r5
            a.b.h.k.v0$a r0 = r8.f2969a
            int r1 = r11.f2582b
            java.lang.Object r5 = r13.f2583c
            a.b.h.k.d$b r0 = r0.mo8030a(r2, r1, r4, r5)
            goto L21
        L20:
            r0 = r3
        L21:
            int r1 = r11.f2582b
            int r5 = r13.f2582b
            if (r1 > r5) goto L2b
            int r5 = r5 + r4
            r13.f2582b = r5
            goto L41
        L2b:
            int r6 = r13.f2584d
            int r7 = r5 + r6
            if (r1 >= r7) goto L41
            int r5 = r5 + r6
            int r5 = r5 - r1
            a.b.h.k.v0$a r3 = r8.f2969a
            int r1 = r1 + r4
            java.lang.Object r4 = r13.f2583c
            a.b.h.k.d$b r3 = r3.mo8030a(r2, r1, r5, r4)
            int r1 = r13.f2584d
            int r1 = r1 - r5
            r13.f2584d = r1
        L41:
            r9.set(r12, r11)
            int r11 = r13.f2584d
            if (r11 <= 0) goto L4c
            r9.set(r10, r13)
            goto L54
        L4c:
            r9.remove(r10)
            a.b.h.k.v0$a r11 = r8.f2969a
            r11.mo8029a(r13)
        L54:
            if (r0 == 0) goto L59
            r9.add(r10, r0)
        L59:
            if (r3 == 0) goto L5e
            r9.add(r10, r3)
        L5e:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: p000a.p006b.p049h.p063k.OpReorderer.m8031c(java.util.List, int, a.b.h.k.d$b, int, a.b.h.k.d$b):void");
    }

    /* renamed from: b */
    public void m8032b(List<AdapterHelper.C0451b> list, int i, AdapterHelper.C0451b c0451b, int i2, AdapterHelper.C0451b c0451b2) {
        boolean z;
        int i3 = c0451b.f2582b;
        int i4 = c0451b.f2584d;
        boolean z2 = false;
        if (i3 < i4) {
            if (c0451b2.f2582b == i3 && c0451b2.f2584d == i4 - i3) {
                z = false;
                z2 = true;
            } else {
                z = false;
            }
        } else if (c0451b2.f2582b == i4 + 1 && c0451b2.f2584d == i3 - i4) {
            z = true;
            z2 = true;
        } else {
            z = true;
        }
        int i5 = c0451b.f2584d;
        int i6 = c0451b2.f2582b;
        if (i5 < i6) {
            c0451b2.f2582b = i6 - 1;
        } else {
            int i7 = c0451b2.f2584d;
            if (i5 < i6 + i7) {
                c0451b2.f2584d = i7 - 1;
                c0451b.f2581a = 2;
                c0451b.f2584d = 1;
                if (c0451b2.f2584d == 0) {
                    list.remove(i2);
                    this.f2969a.mo8029a(c0451b2);
                    return;
                }
                return;
            }
        }
        int i8 = c0451b.f2582b;
        int i9 = c0451b2.f2582b;
        AdapterHelper.C0451b c0451b3 = null;
        if (i8 <= i9) {
            c0451b2.f2582b = i9 + 1;
        } else {
            int i10 = c0451b2.f2584d;
            if (i8 < i9 + i10) {
                c0451b3 = this.f2969a.mo8030a(2, i8 + 1, (i9 + i10) - i8, null);
                c0451b2.f2584d = c0451b.f2582b - c0451b2.f2582b;
            }
        }
        if (z2) {
            list.set(i, c0451b2);
            list.remove(i2);
            this.f2969a.mo8029a(c0451b);
            return;
        }
        if (z) {
            if (c0451b3 != null) {
                int i11 = c0451b.f2582b;
                if (i11 > c0451b3.f2582b) {
                    c0451b.f2582b = i11 - c0451b3.f2584d;
                }
                int i12 = c0451b.f2584d;
                if (i12 > c0451b3.f2582b) {
                    c0451b.f2584d = i12 - c0451b3.f2584d;
                }
            }
            int i13 = c0451b.f2582b;
            if (i13 > c0451b2.f2582b) {
                c0451b.f2582b = i13 - c0451b2.f2584d;
            }
            int i14 = c0451b.f2584d;
            if (i14 > c0451b2.f2582b) {
                c0451b.f2584d = i14 - c0451b2.f2584d;
            }
        } else {
            if (c0451b3 != null) {
                int i15 = c0451b.f2582b;
                if (i15 >= c0451b3.f2582b) {
                    c0451b.f2582b = i15 - c0451b3.f2584d;
                }
                int i16 = c0451b.f2584d;
                if (i16 >= c0451b3.f2582b) {
                    c0451b.f2584d = i16 - c0451b3.f2584d;
                }
            }
            int i17 = c0451b.f2582b;
            if (i17 >= c0451b2.f2582b) {
                c0451b.f2582b = i17 - c0451b2.f2584d;
            }
            int i18 = c0451b.f2584d;
            if (i18 >= c0451b2.f2582b) {
                c0451b.f2584d = i18 - c0451b2.f2584d;
            }
        }
        list.set(i, c0451b2);
        if (c0451b.f2582b != c0451b.f2584d) {
            list.set(i2, c0451b);
        } else {
            list.remove(i2);
        }
        if (c0451b3 != null) {
            list.add(i, c0451b3);
        }
    }

    /* renamed from: a */
    public final void m8034a(List<AdapterHelper.C0451b> list, int i, AdapterHelper.C0451b c0451b, int i2, AdapterHelper.C0451b c0451b2) {
        int i3 = c0451b.f2584d < c0451b2.f2582b ? -1 : 0;
        if (c0451b.f2582b < c0451b2.f2582b) {
            i3++;
        }
        int i4 = c0451b2.f2582b;
        int i5 = c0451b.f2582b;
        if (i4 <= i5) {
            c0451b.f2582b = i5 + c0451b2.f2584d;
        }
        int i6 = c0451b2.f2582b;
        int i7 = c0451b.f2584d;
        if (i6 <= i7) {
            c0451b.f2584d = i7 + c0451b2.f2584d;
        }
        c0451b2.f2582b += i3;
        list.set(i, c0451b2);
        list.set(i2, c0451b);
    }

    /* renamed from: a */
    public final int m8036a(List<AdapterHelper.C0451b> list) {
        boolean z = false;
        for (int size = list.size() - 1; size >= 0; size--) {
            if (list.get(size).f2581a != 8) {
                z = true;
            } else if (z) {
                return size;
            }
        }
        return -1;
    }
}
