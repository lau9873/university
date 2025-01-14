package a.b.h.k;

import a.b.h.k.v0;
import android.support.v7.widget.RecyclerView;
import java.util.ArrayList;
import java.util.List;
/* compiled from: AdapterHelper.java */
/* loaded from: classes.dex */
public class d implements v0.a {

    /* renamed from: a  reason: collision with root package name */
    public a.b.g.j.j<b> f1676a;

    /* renamed from: b  reason: collision with root package name */
    public final ArrayList<b> f1677b;

    /* renamed from: c  reason: collision with root package name */
    public final ArrayList<b> f1678c;

    /* renamed from: d  reason: collision with root package name */
    public final a f1679d;

    /* renamed from: e  reason: collision with root package name */
    public Runnable f1680e;

    /* renamed from: f  reason: collision with root package name */
    public final boolean f1681f;

    /* renamed from: g  reason: collision with root package name */
    public final v0 f1682g;

    /* renamed from: h  reason: collision with root package name */
    public int f1683h;

    /* compiled from: AdapterHelper.java */
    /* loaded from: classes.dex */
    public interface a {
        RecyclerView.d0 a(int i2);

        void a(int i2, int i3);

        void a(int i2, int i3, Object obj);

        void a(b bVar);

        void b(int i2, int i3);

        void b(b bVar);

        void c(int i2, int i3);

        void d(int i2, int i3);
    }

    /* compiled from: AdapterHelper.java */
    /* loaded from: classes.dex */
    public static class b {

        /* renamed from: a  reason: collision with root package name */
        public int f1684a;

        /* renamed from: b  reason: collision with root package name */
        public int f1685b;

        /* renamed from: c  reason: collision with root package name */
        public Object f1686c;

        /* renamed from: d  reason: collision with root package name */
        public int f1687d;

        public b(int i2, int i3, int i4, Object obj) {
            this.f1684a = i2;
            this.f1685b = i3;
            this.f1687d = i4;
            this.f1686c = obj;
        }

        public String a() {
            int i2 = this.f1684a;
            return i2 != 1 ? i2 != 2 ? i2 != 4 ? i2 != 8 ? "??" : "mv" : "up" : "rm" : "add";
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || b.class != obj.getClass()) {
                return false;
            }
            b bVar = (b) obj;
            int i2 = this.f1684a;
            if (i2 != bVar.f1684a) {
                return false;
            }
            if (i2 == 8 && Math.abs(this.f1687d - this.f1685b) == 1 && this.f1687d == bVar.f1685b && this.f1685b == bVar.f1687d) {
                return true;
            }
            if (this.f1687d == bVar.f1687d && this.f1685b == bVar.f1685b) {
                Object obj2 = this.f1686c;
                if (obj2 != null) {
                    if (!obj2.equals(bVar.f1686c)) {
                        return false;
                    }
                } else if (bVar.f1686c != null) {
                    return false;
                }
                return true;
            }
            return false;
        }

        public int hashCode() {
            return (((this.f1684a * 31) + this.f1685b) * 31) + this.f1687d;
        }

        public String toString() {
            return Integer.toHexString(System.identityHashCode(this)) + "[" + a() + ",s:" + this.f1685b + "c:" + this.f1687d + ",p:" + this.f1686c + "]";
        }
    }

    public d(a aVar) {
        this(aVar, false);
    }

    public void a() {
        int size = this.f1678c.size();
        for (int i2 = 0; i2 < size; i2++) {
            this.f1679d.b(this.f1678c.get(i2));
        }
        a(this.f1678c);
        this.f1683h = 0;
    }

    public final boolean b(int i2) {
        int size = this.f1678c.size();
        for (int i3 = 0; i3 < size; i3++) {
            b bVar = this.f1678c.get(i3);
            int i4 = bVar.f1684a;
            if (i4 == 8) {
                if (a(bVar.f1687d, i3 + 1) == i2) {
                    return true;
                }
            } else if (i4 == 1) {
                int i5 = bVar.f1685b;
                int i6 = bVar.f1687d + i5;
                while (i5 < i6) {
                    if (a(i5, i3 + 1) == i2) {
                        return true;
                    }
                    i5++;
                }
                continue;
            } else {
                continue;
            }
        }
        return false;
    }

    public final void c(b bVar) {
        g(bVar);
    }

    public final void d(b bVar) {
        boolean z;
        char c2;
        int i2 = bVar.f1685b;
        int i3 = bVar.f1687d + i2;
        int i4 = 0;
        char c3 = 65535;
        int i5 = i2;
        while (i5 < i3) {
            if (this.f1679d.a(i5) != null || b(i5)) {
                if (c3 == 0) {
                    f(a(2, i2, i4, null));
                    z = true;
                } else {
                    z = false;
                }
                c2 = 1;
            } else {
                if (c3 == 1) {
                    g(a(2, i2, i4, null));
                    z = true;
                } else {
                    z = false;
                }
                c2 = 0;
            }
            if (z) {
                i5 -= i4;
                i3 -= i4;
                i4 = 1;
            } else {
                i4++;
            }
            i5++;
            c3 = c2;
        }
        if (i4 != bVar.f1687d) {
            a(bVar);
            bVar = a(2, i2, i4, null);
        }
        if (c3 == 0) {
            f(bVar);
        } else {
            g(bVar);
        }
    }

    public void e() {
        this.f1682g.b(this.f1677b);
        int size = this.f1677b.size();
        for (int i2 = 0; i2 < size; i2++) {
            b bVar = this.f1677b.get(i2);
            int i3 = bVar.f1684a;
            if (i3 == 1) {
                b(bVar);
            } else if (i3 == 2) {
                d(bVar);
            } else if (i3 == 4) {
                e(bVar);
            } else if (i3 == 8) {
                c(bVar);
            }
            Runnable runnable = this.f1680e;
            if (runnable != null) {
                runnable.run();
            }
        }
        this.f1677b.clear();
    }

    public void f() {
        a(this.f1677b);
        a(this.f1678c);
        this.f1683h = 0;
    }

    public final void g(b bVar) {
        this.f1678c.add(bVar);
        int i2 = bVar.f1684a;
        if (i2 == 1) {
            this.f1679d.c(bVar.f1685b, bVar.f1687d);
        } else if (i2 == 2) {
            this.f1679d.b(bVar.f1685b, bVar.f1687d);
        } else if (i2 == 4) {
            this.f1679d.a(bVar.f1685b, bVar.f1687d, bVar.f1686c);
        } else if (i2 == 8) {
            this.f1679d.a(bVar.f1685b, bVar.f1687d);
        } else {
            throw new IllegalArgumentException("Unknown update op type for " + bVar);
        }
    }

    public d(a aVar, boolean z) {
        this.f1676a = new a.b.g.j.k(30);
        this.f1677b = new ArrayList<>();
        this.f1678c = new ArrayList<>();
        this.f1683h = 0;
        this.f1679d = aVar;
        this.f1681f = z;
        this.f1682g = new v0(this);
    }

    public boolean c() {
        return this.f1677b.size() > 0;
    }

    public int c(int i2) {
        return a(i2, 0);
    }

    public boolean c(int i2, int i3) {
        if (i3 < 1) {
            return false;
        }
        this.f1677b.add(a(2, i2, i3, null));
        this.f1683h |= 2;
        return this.f1677b.size() == 1;
    }

    public final void f(b bVar) {
        int i2;
        int i3 = bVar.f1684a;
        if (i3 != 1 && i3 != 8) {
            int d2 = d(bVar.f1685b, i3);
            int i4 = bVar.f1685b;
            int i5 = bVar.f1684a;
            if (i5 == 2) {
                i2 = 0;
            } else if (i5 != 4) {
                throw new IllegalArgumentException("op should be remove or update." + bVar);
            } else {
                i2 = 1;
            }
            int i6 = d2;
            int i7 = i4;
            int i8 = 1;
            for (int i9 = 1; i9 < bVar.f1687d; i9++) {
                int d3 = d(bVar.f1685b + (i2 * i9), bVar.f1684a);
                int i10 = bVar.f1684a;
                if (i10 == 2 ? d3 == i6 : i10 == 4 && d3 == i6 + 1) {
                    i8++;
                } else {
                    b a2 = a(bVar.f1684a, i6, i8, bVar.f1686c);
                    a(a2, i7);
                    a(a2);
                    if (bVar.f1684a == 4) {
                        i7 += i8;
                    }
                    i6 = d3;
                    i8 = 1;
                }
            }
            Object obj = bVar.f1686c;
            a(bVar);
            if (i8 > 0) {
                b a3 = a(bVar.f1684a, i6, i8, obj);
                a(a3, i7);
                a(a3);
                return;
            }
            return;
        }
        throw new IllegalArgumentException("should not dispatch add or move for pre layout");
    }

    public void a(b bVar, int i2) {
        this.f1679d.a(bVar);
        int i3 = bVar.f1684a;
        if (i3 == 2) {
            this.f1679d.d(i2, bVar.f1687d);
        } else if (i3 == 4) {
            this.f1679d.a(i2, bVar.f1687d, bVar.f1686c);
        } else {
            throw new IllegalArgumentException("only remove and update ops can be dispatched in first pass");
        }
    }

    public final void b(b bVar) {
        g(bVar);
    }

    public boolean b(int i2, int i3) {
        if (i3 < 1) {
            return false;
        }
        this.f1677b.add(a(1, i2, i3, null));
        this.f1683h |= 1;
        return this.f1677b.size() == 1;
    }

    public int a(int i2, int i3) {
        int size = this.f1678c.size();
        while (i3 < size) {
            b bVar = this.f1678c.get(i3);
            int i4 = bVar.f1684a;
            if (i4 == 8) {
                int i5 = bVar.f1685b;
                if (i5 == i2) {
                    i2 = bVar.f1687d;
                } else {
                    if (i5 < i2) {
                        i2--;
                    }
                    if (bVar.f1687d <= i2) {
                        i2++;
                    }
                }
            } else {
                int i6 = bVar.f1685b;
                if (i6 > i2) {
                    continue;
                } else if (i4 == 2) {
                    int i7 = bVar.f1687d;
                    if (i2 < i6 + i7) {
                        return -1;
                    }
                    i2 -= i7;
                } else if (i4 == 1) {
                    i2 += bVar.f1687d;
                }
            }
            i3++;
        }
        return i2;
    }

    public void b() {
        a();
        int size = this.f1677b.size();
        for (int i2 = 0; i2 < size; i2++) {
            b bVar = this.f1677b.get(i2);
            int i3 = bVar.f1684a;
            if (i3 == 1) {
                this.f1679d.b(bVar);
                this.f1679d.c(bVar.f1685b, bVar.f1687d);
            } else if (i3 == 2) {
                this.f1679d.b(bVar);
                this.f1679d.d(bVar.f1685b, bVar.f1687d);
            } else if (i3 == 4) {
                this.f1679d.b(bVar);
                this.f1679d.a(bVar.f1685b, bVar.f1687d, bVar.f1686c);
            } else if (i3 == 8) {
                this.f1679d.b(bVar);
                this.f1679d.a(bVar.f1685b, bVar.f1687d);
            }
            Runnable runnable = this.f1680e;
            if (runnable != null) {
                runnable.run();
            }
        }
        a(this.f1677b);
        this.f1683h = 0;
    }

    public final void e(b bVar) {
        int i2 = bVar.f1685b;
        int i3 = bVar.f1687d + i2;
        int i4 = i2;
        int i5 = 0;
        char c2 = 65535;
        while (i2 < i3) {
            if (this.f1679d.a(i2) != null || b(i2)) {
                if (c2 == 0) {
                    f(a(4, i4, i5, bVar.f1686c));
                    i4 = i2;
                    i5 = 0;
                }
                c2 = 1;
            } else {
                if (c2 == 1) {
                    g(a(4, i4, i5, bVar.f1686c));
                    i4 = i2;
                    i5 = 0;
                }
                c2 = 0;
            }
            i5++;
            i2++;
        }
        if (i5 != bVar.f1687d) {
            Object obj = bVar.f1686c;
            a(bVar);
            bVar = a(4, i4, i5, obj);
        }
        if (c2 == 0) {
            f(bVar);
        } else {
            g(bVar);
        }
    }

    public final int d(int i2, int i3) {
        for (int size = this.f1678c.size() - 1; size >= 0; size--) {
            b bVar = this.f1678c.get(size);
            int i4 = bVar.f1684a;
            if (i4 == 8) {
                int i5 = bVar.f1685b;
                int i6 = bVar.f1687d;
                if (i5 >= i6) {
                    i6 = i5;
                    i5 = i6;
                }
                if (i2 >= i5 && i2 <= i6) {
                    int i7 = bVar.f1685b;
                    if (i5 == i7) {
                        if (i3 == 1) {
                            bVar.f1687d++;
                        } else if (i3 == 2) {
                            bVar.f1687d--;
                        }
                        i2++;
                    } else {
                        if (i3 == 1) {
                            bVar.f1685b = i7 + 1;
                        } else if (i3 == 2) {
                            bVar.f1685b = i7 - 1;
                        }
                        i2--;
                    }
                } else {
                    int i8 = bVar.f1685b;
                    if (i2 < i8) {
                        if (i3 == 1) {
                            bVar.f1685b = i8 + 1;
                            bVar.f1687d++;
                        } else if (i3 == 2) {
                            bVar.f1685b = i8 - 1;
                            bVar.f1687d--;
                        }
                    }
                }
            } else {
                int i9 = bVar.f1685b;
                if (i9 <= i2) {
                    if (i4 == 1) {
                        i2 -= bVar.f1687d;
                    } else if (i4 == 2) {
                        i2 += bVar.f1687d;
                    }
                } else if (i3 == 1) {
                    bVar.f1685b = i9 + 1;
                } else if (i3 == 2) {
                    bVar.f1685b = i9 - 1;
                }
            }
        }
        for (int size2 = this.f1678c.size() - 1; size2 >= 0; size2--) {
            b bVar2 = this.f1678c.get(size2);
            if (bVar2.f1684a == 8) {
                int i10 = bVar2.f1687d;
                if (i10 == bVar2.f1685b || i10 < 0) {
                    this.f1678c.remove(size2);
                    a(bVar2);
                }
            } else if (bVar2.f1687d <= 0) {
                this.f1678c.remove(size2);
                a(bVar2);
            }
        }
        return i2;
    }

    public boolean a(int i2, int i3, Object obj) {
        if (i3 < 1) {
            return false;
        }
        this.f1677b.add(a(4, i2, i3, obj));
        this.f1683h |= 4;
        return this.f1677b.size() == 1;
    }

    public boolean a(int i2, int i3, int i4) {
        if (i2 == i3) {
            return false;
        }
        if (i4 == 1) {
            this.f1677b.add(a(8, i2, i3, null));
            this.f1683h |= 8;
            return this.f1677b.size() == 1;
        }
        throw new IllegalArgumentException("Moving more than 1 item is not supported yet");
    }

    public int a(int i2) {
        int size = this.f1677b.size();
        for (int i3 = 0; i3 < size; i3++) {
            b bVar = this.f1677b.get(i3);
            int i4 = bVar.f1684a;
            if (i4 != 1) {
                if (i4 == 2) {
                    int i5 = bVar.f1685b;
                    if (i5 <= i2) {
                        int i6 = bVar.f1687d;
                        if (i5 + i6 > i2) {
                            return -1;
                        }
                        i2 -= i6;
                    } else {
                        continue;
                    }
                } else if (i4 == 8) {
                    int i7 = bVar.f1685b;
                    if (i7 == i2) {
                        i2 = bVar.f1687d;
                    } else {
                        if (i7 < i2) {
                            i2--;
                        }
                        if (bVar.f1687d <= i2) {
                            i2++;
                        }
                    }
                }
            } else if (bVar.f1685b <= i2) {
                i2 += bVar.f1687d;
            }
        }
        return i2;
    }

    @Override // a.b.h.k.v0.a
    public b a(int i2, int i3, int i4, Object obj) {
        b a2 = this.f1676a.a();
        if (a2 == null) {
            return new b(i2, i3, i4, obj);
        }
        a2.f1684a = i2;
        a2.f1685b = i3;
        a2.f1687d = i4;
        a2.f1686c = obj;
        return a2;
    }

    @Override // a.b.h.k.v0.a
    public void a(b bVar) {
        if (this.f1681f) {
            return;
        }
        bVar.f1686c = null;
        this.f1676a.a(bVar);
    }

    public boolean d(int i2) {
        return (i2 & this.f1683h) != 0;
    }

    public boolean d() {
        return (this.f1678c.isEmpty() || this.f1677b.isEmpty()) ? false : true;
    }

    public void a(List<b> list) {
        int size = list.size();
        for (int i2 = 0; i2 < size; i2++) {
            a(list.get(i2));
        }
        list.clear();
    }
}
