package p000a.p006b.p049h.p063k;

import android.support.p067v7.widget.RecyclerView;
import java.util.ArrayList;
import java.util.List;
import p000a.p006b.p030g.p044j.C0274k;
import p000a.p006b.p030g.p044j.InterfaceC0273j;
import p000a.p006b.p049h.p063k.OpReorderer;

/* renamed from: a.b.h.k.d */
/* loaded from: classes.dex */
public class AdapterHelper implements OpReorderer.InterfaceC0506a {

    /* renamed from: a */
    public InterfaceC0273j<C0451b> f2573a;

    /* renamed from: b */
    public final ArrayList<C0451b> f2574b;

    /* renamed from: c */
    public final ArrayList<C0451b> f2575c;

    /* renamed from: d */
    public final InterfaceC0450a f2576d;

    /* renamed from: e */
    public Runnable f2577e;

    /* renamed from: f */
    public final boolean f2578f;

    /* renamed from: g */
    public final OpReorderer f2579g;

    /* renamed from: h */
    public int f2580h;

    /* compiled from: AdapterHelper.java */
    /* renamed from: a.b.h.k.d$a */
    /* loaded from: classes.dex */
    public interface InterfaceC0450a {
        /* renamed from: a */
        RecyclerView.AbstractC0708d0 mo6777a(int i);

        /* renamed from: a */
        void mo6776a(int i, int i2);

        /* renamed from: a */
        void mo6775a(int i, int i2, Object obj);

        /* renamed from: a */
        void mo6774a(C0451b c0451b);

        /* renamed from: b */
        void mo6773b(int i, int i2);

        /* renamed from: b */
        void mo6772b(C0451b c0451b);

        /* renamed from: c */
        void mo6771c(int i, int i2);

        /* renamed from: d */
        void mo6769d(int i, int i2);
    }

    /* compiled from: AdapterHelper.java */
    /* renamed from: a.b.h.k.d$b */
    /* loaded from: classes.dex */
    public static class C0451b {

        /* renamed from: a */
        public int f2581a;

        /* renamed from: b */
        public int f2582b;

        /* renamed from: c */
        public Object f2583c;

        /* renamed from: d */
        public int f2584d;

        public C0451b(int i, int i2, int i3, Object obj) {
            this.f2581a = i;
            this.f2582b = i2;
            this.f2584d = i3;
            this.f2583c = obj;
        }

        /* renamed from: a */
        public String m8454a() {
            int i = this.f2581a;
            return i != 1 ? i != 2 ? i != 4 ? i != 8 ? "??" : "mv" : "up" : "rm" : "add";
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || C0451b.class != obj.getClass()) {
                return false;
            }
            C0451b c0451b = (C0451b) obj;
            int i = this.f2581a;
            if (i != c0451b.f2581a) {
                return false;
            }
            if (i == 8 && Math.abs(this.f2584d - this.f2582b) == 1 && this.f2584d == c0451b.f2582b && this.f2582b == c0451b.f2584d) {
                return true;
            }
            if (this.f2584d == c0451b.f2584d && this.f2582b == c0451b.f2582b) {
                Object obj2 = this.f2583c;
                if (obj2 != null) {
                    if (!obj2.equals(c0451b.f2583c)) {
                        return false;
                    }
                } else if (c0451b.f2583c != null) {
                    return false;
                }
                return true;
            }
            return false;
        }

        public int hashCode() {
            return (((this.f2581a * 31) + this.f2582b) * 31) + this.f2584d;
        }

        public String toString() {
            return Integer.toHexString(System.identityHashCode(this)) + "[" + m8454a() + ",s:" + this.f2582b + "c:" + this.f2584d + ",p:" + this.f2583c + "]";
        }
    }

    public AdapterHelper(InterfaceC0450a interfaceC0450a) {
        this(interfaceC0450a, false);
    }

    /* renamed from: a */
    public void m8478a() {
        int size = this.f2575c.size();
        for (int i = 0; i < size; i++) {
            this.f2576d.mo6772b(this.f2575c.get(i));
        }
        m8472a(this.f2575c);
        this.f2580h = 0;
    }

    /* renamed from: b */
    public final boolean m8470b(int i) {
        int size = this.f2575c.size();
        for (int i2 = 0; i2 < size; i2++) {
            C0451b c0451b = this.f2575c.get(i2);
            int i3 = c0451b.f2581a;
            if (i3 == 8) {
                if (m8476a(c0451b.f2584d, i2 + 1) == i) {
                    return true;
                }
            } else if (i3 == 1) {
                int i4 = c0451b.f2582b;
                int i5 = c0451b.f2584d + i4;
                while (i4 < i5) {
                    if (m8476a(i4, i2 + 1) == i) {
                        return true;
                    }
                    i4++;
                }
                continue;
            } else {
                continue;
            }
        }
        return false;
    }

    /* renamed from: c */
    public final void m8464c(C0451b c0451b) {
        m8455g(c0451b);
    }

    /* renamed from: d */
    public final void m8460d(C0451b c0451b) {
        boolean z;
        char c;
        int i = c0451b.f2582b;
        int i2 = c0451b.f2584d + i;
        int i3 = 0;
        char c2 = 65535;
        int i4 = i;
        while (i4 < i2) {
            if (this.f2576d.mo6777a(i4) != null || m8470b(i4)) {
                if (c2 == 0) {
                    m8456f(mo8030a(2, i, i3, null));
                    z = true;
                } else {
                    z = false;
                }
                c = 1;
            } else {
                if (c2 == 1) {
                    m8455g(mo8030a(2, i, i3, null));
                    z = true;
                } else {
                    z = false;
                }
                c = 0;
            }
            if (z) {
                i4 -= i3;
                i2 -= i3;
                i3 = 1;
            } else {
                i3++;
            }
            i4++;
            c2 = c;
        }
        if (i3 != c0451b.f2584d) {
            mo8029a(c0451b);
            c0451b = mo8030a(2, i, i3, null);
        }
        if (c2 == 0) {
            m8456f(c0451b);
        } else {
            m8455g(c0451b);
        }
    }

    /* renamed from: e */
    public void m8459e() {
        this.f2579g.m8033b(this.f2574b);
        int size = this.f2574b.size();
        for (int i = 0; i < size; i++) {
            C0451b c0451b = this.f2574b.get(i);
            int i2 = c0451b.f2581a;
            if (i2 == 1) {
                m8468b(c0451b);
            } else if (i2 == 2) {
                m8460d(c0451b);
            } else if (i2 == 4) {
                m8458e(c0451b);
            } else if (i2 == 8) {
                m8464c(c0451b);
            }
            Runnable runnable = this.f2577e;
            if (runnable != null) {
                runnable.run();
            }
        }
        this.f2574b.clear();
    }

    /* renamed from: f */
    public void m8457f() {
        m8472a(this.f2574b);
        m8472a(this.f2575c);
        this.f2580h = 0;
    }

    /* renamed from: g */
    public final void m8455g(C0451b c0451b) {
        this.f2575c.add(c0451b);
        int i = c0451b.f2581a;
        if (i == 1) {
            this.f2576d.mo6771c(c0451b.f2582b, c0451b.f2584d);
        } else if (i == 2) {
            this.f2576d.mo6773b(c0451b.f2582b, c0451b.f2584d);
        } else if (i == 4) {
            this.f2576d.mo6775a(c0451b.f2582b, c0451b.f2584d, c0451b.f2583c);
        } else if (i == 8) {
            this.f2576d.mo6776a(c0451b.f2582b, c0451b.f2584d);
        } else {
            throw new IllegalArgumentException("Unknown update op type for " + c0451b);
        }
    }

    public AdapterHelper(InterfaceC0450a interfaceC0450a, boolean z) {
        this.f2573a = new C0274k(30);
        this.f2574b = new ArrayList<>();
        this.f2575c = new ArrayList<>();
        this.f2580h = 0;
        this.f2576d = interfaceC0450a;
        this.f2578f = z;
        this.f2579g = new OpReorderer(this);
    }

    /* renamed from: c */
    public boolean m8467c() {
        return this.f2574b.size() > 0;
    }

    /* renamed from: c */
    public int m8466c(int i) {
        return m8476a(i, 0);
    }

    /* renamed from: c */
    public boolean m8465c(int i, int i2) {
        if (i2 < 1) {
            return false;
        }
        this.f2574b.add(mo8030a(2, i, i2, null));
        this.f2580h |= 2;
        return this.f2574b.size() == 1;
    }

    /* renamed from: f */
    public final void m8456f(C0451b c0451b) {
        int i;
        int i2 = c0451b.f2581a;
        if (i2 != 1 && i2 != 8) {
            int m8461d = m8461d(c0451b.f2582b, i2);
            int i3 = c0451b.f2582b;
            int i4 = c0451b.f2581a;
            if (i4 == 2) {
                i = 0;
            } else if (i4 != 4) {
                throw new IllegalArgumentException("op should be remove or update." + c0451b);
            } else {
                i = 1;
            }
            int i5 = m8461d;
            int i6 = i3;
            int i7 = 1;
            for (int i8 = 1; i8 < c0451b.f2584d; i8++) {
                int m8461d2 = m8461d(c0451b.f2582b + (i * i8), c0451b.f2581a);
                int i9 = c0451b.f2581a;
                if (i9 == 2 ? m8461d2 == i5 : i9 == 4 && m8461d2 == i5 + 1) {
                    i7++;
                } else {
                    C0451b mo8030a = mo8030a(c0451b.f2581a, i5, i7, c0451b.f2583c);
                    m8473a(mo8030a, i6);
                    mo8029a(mo8030a);
                    if (c0451b.f2581a == 4) {
                        i6 += i7;
                    }
                    i5 = m8461d2;
                    i7 = 1;
                }
            }
            Object obj = c0451b.f2583c;
            mo8029a(c0451b);
            if (i7 > 0) {
                C0451b mo8030a2 = mo8030a(c0451b.f2581a, i5, i7, obj);
                m8473a(mo8030a2, i6);
                mo8029a(mo8030a2);
                return;
            }
            return;
        }
        throw new IllegalArgumentException("should not dispatch add or move for pre layout");
    }

    /* renamed from: a */
    public void m8473a(C0451b c0451b, int i) {
        this.f2576d.mo6774a(c0451b);
        int i2 = c0451b.f2581a;
        if (i2 == 2) {
            this.f2576d.mo6769d(i, c0451b.f2584d);
        } else if (i2 == 4) {
            this.f2576d.mo6775a(i, c0451b.f2584d, c0451b.f2583c);
        } else {
            throw new IllegalArgumentException("only remove and update ops can be dispatched in first pass");
        }
    }

    /* renamed from: b */
    public final void m8468b(C0451b c0451b) {
        m8455g(c0451b);
    }

    /* renamed from: b */
    public boolean m8469b(int i, int i2) {
        if (i2 < 1) {
            return false;
        }
        this.f2574b.add(mo8030a(1, i, i2, null));
        this.f2580h |= 1;
        return this.f2574b.size() == 1;
    }

    /* renamed from: a */
    public int m8476a(int i, int i2) {
        int size = this.f2575c.size();
        while (i2 < size) {
            C0451b c0451b = this.f2575c.get(i2);
            int i3 = c0451b.f2581a;
            if (i3 == 8) {
                int i4 = c0451b.f2582b;
                if (i4 == i) {
                    i = c0451b.f2584d;
                } else {
                    if (i4 < i) {
                        i--;
                    }
                    if (c0451b.f2584d <= i) {
                        i++;
                    }
                }
            } else {
                int i5 = c0451b.f2582b;
                if (i5 > i) {
                    continue;
                } else if (i3 == 2) {
                    int i6 = c0451b.f2584d;
                    if (i < i5 + i6) {
                        return -1;
                    }
                    i -= i6;
                } else if (i3 == 1) {
                    i += c0451b.f2584d;
                }
            }
            i2++;
        }
        return i;
    }

    /* renamed from: b */
    public void m8471b() {
        m8478a();
        int size = this.f2574b.size();
        for (int i = 0; i < size; i++) {
            C0451b c0451b = this.f2574b.get(i);
            int i2 = c0451b.f2581a;
            if (i2 == 1) {
                this.f2576d.mo6772b(c0451b);
                this.f2576d.mo6771c(c0451b.f2582b, c0451b.f2584d);
            } else if (i2 == 2) {
                this.f2576d.mo6772b(c0451b);
                this.f2576d.mo6769d(c0451b.f2582b, c0451b.f2584d);
            } else if (i2 == 4) {
                this.f2576d.mo6772b(c0451b);
                this.f2576d.mo6775a(c0451b.f2582b, c0451b.f2584d, c0451b.f2583c);
            } else if (i2 == 8) {
                this.f2576d.mo6772b(c0451b);
                this.f2576d.mo6776a(c0451b.f2582b, c0451b.f2584d);
            }
            Runnable runnable = this.f2577e;
            if (runnable != null) {
                runnable.run();
            }
        }
        m8472a(this.f2574b);
        this.f2580h = 0;
    }

    /* renamed from: e */
    public final void m8458e(C0451b c0451b) {
        int i = c0451b.f2582b;
        int i2 = c0451b.f2584d + i;
        int i3 = i;
        int i4 = 0;
        char c = 65535;
        while (i < i2) {
            if (this.f2576d.mo6777a(i) != null || m8470b(i)) {
                if (c == 0) {
                    m8456f(mo8030a(4, i3, i4, c0451b.f2583c));
                    i3 = i;
                    i4 = 0;
                }
                c = 1;
            } else {
                if (c == 1) {
                    m8455g(mo8030a(4, i3, i4, c0451b.f2583c));
                    i3 = i;
                    i4 = 0;
                }
                c = 0;
            }
            i4++;
            i++;
        }
        if (i4 != c0451b.f2584d) {
            Object obj = c0451b.f2583c;
            mo8029a(c0451b);
            c0451b = mo8030a(4, i3, i4, obj);
        }
        if (c == 0) {
            m8456f(c0451b);
        } else {
            m8455g(c0451b);
        }
    }

    /* renamed from: d */
    public final int m8461d(int i, int i2) {
        for (int size = this.f2575c.size() - 1; size >= 0; size--) {
            C0451b c0451b = this.f2575c.get(size);
            int i3 = c0451b.f2581a;
            if (i3 == 8) {
                int i4 = c0451b.f2582b;
                int i5 = c0451b.f2584d;
                if (i4 >= i5) {
                    i5 = i4;
                    i4 = i5;
                }
                if (i >= i4 && i <= i5) {
                    int i6 = c0451b.f2582b;
                    if (i4 == i6) {
                        if (i2 == 1) {
                            c0451b.f2584d++;
                        } else if (i2 == 2) {
                            c0451b.f2584d--;
                        }
                        i++;
                    } else {
                        if (i2 == 1) {
                            c0451b.f2582b = i6 + 1;
                        } else if (i2 == 2) {
                            c0451b.f2582b = i6 - 1;
                        }
                        i--;
                    }
                } else {
                    int i7 = c0451b.f2582b;
                    if (i < i7) {
                        if (i2 == 1) {
                            c0451b.f2582b = i7 + 1;
                            c0451b.f2584d++;
                        } else if (i2 == 2) {
                            c0451b.f2582b = i7 - 1;
                            c0451b.f2584d--;
                        }
                    }
                }
            } else {
                int i8 = c0451b.f2582b;
                if (i8 <= i) {
                    if (i3 == 1) {
                        i -= c0451b.f2584d;
                    } else if (i3 == 2) {
                        i += c0451b.f2584d;
                    }
                } else if (i2 == 1) {
                    c0451b.f2582b = i8 + 1;
                } else if (i2 == 2) {
                    c0451b.f2582b = i8 - 1;
                }
            }
        }
        for (int size2 = this.f2575c.size() - 1; size2 >= 0; size2--) {
            C0451b c0451b2 = this.f2575c.get(size2);
            if (c0451b2.f2581a == 8) {
                int i9 = c0451b2.f2584d;
                if (i9 == c0451b2.f2582b || i9 < 0) {
                    this.f2575c.remove(size2);
                    mo8029a(c0451b2);
                }
            } else if (c0451b2.f2584d <= 0) {
                this.f2575c.remove(size2);
                mo8029a(c0451b2);
            }
        }
        return i;
    }

    /* renamed from: a */
    public boolean m8474a(int i, int i2, Object obj) {
        if (i2 < 1) {
            return false;
        }
        this.f2574b.add(mo8030a(4, i, i2, obj));
        this.f2580h |= 4;
        return this.f2574b.size() == 1;
    }

    /* renamed from: a */
    public boolean m8475a(int i, int i2, int i3) {
        if (i == i2) {
            return false;
        }
        if (i3 == 1) {
            this.f2574b.add(mo8030a(8, i, i2, null));
            this.f2580h |= 8;
            return this.f2574b.size() == 1;
        }
        throw new IllegalArgumentException("Moving more than 1 item is not supported yet");
    }

    /* renamed from: a */
    public int m8477a(int i) {
        int size = this.f2574b.size();
        for (int i2 = 0; i2 < size; i2++) {
            C0451b c0451b = this.f2574b.get(i2);
            int i3 = c0451b.f2581a;
            if (i3 != 1) {
                if (i3 == 2) {
                    int i4 = c0451b.f2582b;
                    if (i4 <= i) {
                        int i5 = c0451b.f2584d;
                        if (i4 + i5 > i) {
                            return -1;
                        }
                        i -= i5;
                    } else {
                        continue;
                    }
                } else if (i3 == 8) {
                    int i6 = c0451b.f2582b;
                    if (i6 == i) {
                        i = c0451b.f2584d;
                    } else {
                        if (i6 < i) {
                            i--;
                        }
                        if (c0451b.f2584d <= i) {
                            i++;
                        }
                    }
                }
            } else if (c0451b.f2582b <= i) {
                i += c0451b.f2584d;
            }
        }
        return i;
    }

    @Override // p000a.p006b.p049h.p063k.OpReorderer.InterfaceC0506a
    /* renamed from: a */
    public C0451b mo8030a(int i, int i2, int i3, Object obj) {
        C0451b mo9624a = this.f2573a.mo9624a();
        if (mo9624a == null) {
            return new C0451b(i, i2, i3, obj);
        }
        mo9624a.f2581a = i;
        mo9624a.f2582b = i2;
        mo9624a.f2584d = i3;
        mo9624a.f2583c = obj;
        return mo9624a;
    }

    @Override // p000a.p006b.p049h.p063k.OpReorderer.InterfaceC0506a
    /* renamed from: a */
    public void mo8029a(C0451b c0451b) {
        if (this.f2578f) {
            return;
        }
        c0451b.f2583c = null;
        this.f2573a.mo9623a(c0451b);
    }

    /* renamed from: d */
    public boolean m8462d(int i) {
        return (i & this.f2580h) != 0;
    }

    /* renamed from: d */
    public boolean m8463d() {
        return (this.f2575c.isEmpty() || this.f2574b.isEmpty()) ? false : true;
    }

    /* renamed from: a */
    public void m8472a(List<C0451b> list) {
        int size = list.size();
        for (int i = 0; i < size; i++) {
            mo8029a(list.get(i));
        }
        list.clear();
    }
}
