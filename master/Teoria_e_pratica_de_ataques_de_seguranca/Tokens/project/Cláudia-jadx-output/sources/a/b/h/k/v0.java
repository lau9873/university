package a.b.h.k;

import a.b.h.k.d;
import java.util.List;
/* compiled from: OpReorderer.java */
/* loaded from: classes.dex */
public class v0 {

    /* renamed from: a  reason: collision with root package name */
    public final a f1968a;

    /* compiled from: OpReorderer.java */
    /* loaded from: classes.dex */
    public interface a {
        d.b a(int i2, int i3, int i4, Object obj);

        void a(d.b bVar);
    }

    public v0(a aVar) {
        this.f1968a = aVar;
    }

    public final void a(List<d.b> list, int i2, int i3) {
        d.b bVar = list.get(i2);
        d.b bVar2 = list.get(i3);
        int i4 = bVar2.f1684a;
        if (i4 == 1) {
            a(list, i2, bVar, i3, bVar2);
        } else if (i4 == 2) {
            b(list, i2, bVar, i3, bVar2);
        } else if (i4 != 4) {
        } else {
            c(list, i2, bVar, i3, bVar2);
        }
    }

    public void b(List<d.b> list) {
        while (true) {
            int a2 = a(list);
            if (a2 == -1) {
                return;
            }
            a(list, a2, a2 + 1);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x0027  */
    /* JADX WARN: Removed duplicated region for block: B:12:0x002b  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0048  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x004c  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0056  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x005b  */
    /* JADX WARN: Removed duplicated region for block: B:24:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void c(java.util.List<a.b.h.k.d.b> r9, int r10, a.b.h.k.d.b r11, int r12, a.b.h.k.d.b r13) {
        /*
            r8 = this;
            int r0 = r11.f1687d
            int r1 = r13.f1685b
            r2 = 4
            r3 = 0
            r4 = 1
            if (r0 >= r1) goto Ld
            int r1 = r1 - r4
            r13.f1685b = r1
            goto L20
        Ld:
            int r5 = r13.f1687d
            int r1 = r1 + r5
            if (r0 >= r1) goto L20
            int r5 = r5 - r4
            r13.f1687d = r5
            a.b.h.k.v0$a r0 = r8.f1968a
            int r1 = r11.f1685b
            java.lang.Object r5 = r13.f1686c
            a.b.h.k.d$b r0 = r0.a(r2, r1, r4, r5)
            goto L21
        L20:
            r0 = r3
        L21:
            int r1 = r11.f1685b
            int r5 = r13.f1685b
            if (r1 > r5) goto L2b
            int r5 = r5 + r4
            r13.f1685b = r5
            goto L41
        L2b:
            int r6 = r13.f1687d
            int r7 = r5 + r6
            if (r1 >= r7) goto L41
            int r5 = r5 + r6
            int r5 = r5 - r1
            a.b.h.k.v0$a r3 = r8.f1968a
            int r1 = r1 + r4
            java.lang.Object r4 = r13.f1686c
            a.b.h.k.d$b r3 = r3.a(r2, r1, r5, r4)
            int r1 = r13.f1687d
            int r1 = r1 - r5
            r13.f1687d = r1
        L41:
            r9.set(r12, r11)
            int r11 = r13.f1687d
            if (r11 <= 0) goto L4c
            r9.set(r10, r13)
            goto L54
        L4c:
            r9.remove(r10)
            a.b.h.k.v0$a r11 = r8.f1968a
            r11.a(r13)
        L54:
            if (r0 == 0) goto L59
            r9.add(r10, r0)
        L59:
            if (r3 == 0) goto L5e
            r9.add(r10, r3)
        L5e:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: a.b.h.k.v0.c(java.util.List, int, a.b.h.k.d$b, int, a.b.h.k.d$b):void");
    }

    public void b(List<d.b> list, int i2, d.b bVar, int i3, d.b bVar2) {
        boolean z;
        int i4 = bVar.f1685b;
        int i5 = bVar.f1687d;
        boolean z2 = false;
        if (i4 < i5) {
            if (bVar2.f1685b == i4 && bVar2.f1687d == i5 - i4) {
                z = false;
                z2 = true;
            } else {
                z = false;
            }
        } else if (bVar2.f1685b == i5 + 1 && bVar2.f1687d == i4 - i5) {
            z = true;
            z2 = true;
        } else {
            z = true;
        }
        int i6 = bVar.f1687d;
        int i7 = bVar2.f1685b;
        if (i6 < i7) {
            bVar2.f1685b = i7 - 1;
        } else {
            int i8 = bVar2.f1687d;
            if (i6 < i7 + i8) {
                bVar2.f1687d = i8 - 1;
                bVar.f1684a = 2;
                bVar.f1687d = 1;
                if (bVar2.f1687d == 0) {
                    list.remove(i3);
                    this.f1968a.a(bVar2);
                    return;
                }
                return;
            }
        }
        int i9 = bVar.f1685b;
        int i10 = bVar2.f1685b;
        d.b bVar3 = null;
        if (i9 <= i10) {
            bVar2.f1685b = i10 + 1;
        } else {
            int i11 = bVar2.f1687d;
            if (i9 < i10 + i11) {
                bVar3 = this.f1968a.a(2, i9 + 1, (i10 + i11) - i9, null);
                bVar2.f1687d = bVar.f1685b - bVar2.f1685b;
            }
        }
        if (z2) {
            list.set(i2, bVar2);
            list.remove(i3);
            this.f1968a.a(bVar);
            return;
        }
        if (z) {
            if (bVar3 != null) {
                int i12 = bVar.f1685b;
                if (i12 > bVar3.f1685b) {
                    bVar.f1685b = i12 - bVar3.f1687d;
                }
                int i13 = bVar.f1687d;
                if (i13 > bVar3.f1685b) {
                    bVar.f1687d = i13 - bVar3.f1687d;
                }
            }
            int i14 = bVar.f1685b;
            if (i14 > bVar2.f1685b) {
                bVar.f1685b = i14 - bVar2.f1687d;
            }
            int i15 = bVar.f1687d;
            if (i15 > bVar2.f1685b) {
                bVar.f1687d = i15 - bVar2.f1687d;
            }
        } else {
            if (bVar3 != null) {
                int i16 = bVar.f1685b;
                if (i16 >= bVar3.f1685b) {
                    bVar.f1685b = i16 - bVar3.f1687d;
                }
                int i17 = bVar.f1687d;
                if (i17 >= bVar3.f1685b) {
                    bVar.f1687d = i17 - bVar3.f1687d;
                }
            }
            int i18 = bVar.f1685b;
            if (i18 >= bVar2.f1685b) {
                bVar.f1685b = i18 - bVar2.f1687d;
            }
            int i19 = bVar.f1687d;
            if (i19 >= bVar2.f1685b) {
                bVar.f1687d = i19 - bVar2.f1687d;
            }
        }
        list.set(i2, bVar2);
        if (bVar.f1685b != bVar.f1687d) {
            list.set(i3, bVar);
        } else {
            list.remove(i3);
        }
        if (bVar3 != null) {
            list.add(i2, bVar3);
        }
    }

    public final void a(List<d.b> list, int i2, d.b bVar, int i3, d.b bVar2) {
        int i4 = bVar.f1687d < bVar2.f1685b ? -1 : 0;
        if (bVar.f1685b < bVar2.f1685b) {
            i4++;
        }
        int i5 = bVar2.f1685b;
        int i6 = bVar.f1685b;
        if (i5 <= i6) {
            bVar.f1685b = i6 + bVar2.f1687d;
        }
        int i7 = bVar2.f1685b;
        int i8 = bVar.f1687d;
        if (i7 <= i8) {
            bVar.f1687d = i8 + bVar2.f1687d;
        }
        bVar2.f1685b += i4;
        list.set(i2, bVar2);
        list.set(i3, bVar);
    }

    public final int a(List<d.b> list) {
        boolean z = false;
        for (int size = list.size() - 1; size >= 0; size--) {
            if (list.get(size).f1684a != 8) {
                z = true;
            } else if (z) {
                return size;
            }
        }
        return -1;
    }
}
