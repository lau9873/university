package p000a.p006b.p030g.p043i;

import java.util.Locale;

/* renamed from: a.b.g.i.d */
/* loaded from: classes.dex */
public final class TextDirectionHeuristicsCompat {

    /* renamed from: a */
    public static final TextDirectionHeuristicCompat f1539a;

    /* renamed from: b */
    public static final TextDirectionHeuristicCompat f1540b;

    /* compiled from: TextDirectionHeuristicsCompat.java */
    /* renamed from: a.b.g.i.d$a */
    /* loaded from: classes.dex */
    public static class C0260a implements InterfaceC0262c {

        /* renamed from: b */
        public static final C0260a f1541b = new C0260a(true);

        /* renamed from: a */
        public final boolean f1542a;

        static {
            new C0260a(false);
        }

        public C0260a(boolean z) {
            this.f1542a = z;
        }

        @Override // p000a.p006b.p030g.p043i.TextDirectionHeuristicsCompat.InterfaceC0262c
        /* renamed from: a */
        public int mo9689a(CharSequence charSequence, int i, int i2) {
            int i3 = i2 + i;
            boolean z = false;
            while (i < i3) {
                int m9691a = TextDirectionHeuristicsCompat.m9691a(Character.getDirectionality(charSequence.charAt(i)));
                if (m9691a != 0) {
                    if (m9691a != 1) {
                        continue;
                        i++;
                    } else if (!this.f1542a) {
                        return 1;
                    }
                } else if (this.f1542a) {
                    return 0;
                }
                z = true;
                i++;
            }
            if (z) {
                return this.f1542a ? 1 : 0;
            }
            return 2;
        }
    }

    /* compiled from: TextDirectionHeuristicsCompat.java */
    /* renamed from: a.b.g.i.d$b */
    /* loaded from: classes.dex */
    public static class C0261b implements InterfaceC0262c {

        /* renamed from: a */
        public static final C0261b f1543a = new C0261b();

        @Override // p000a.p006b.p030g.p043i.TextDirectionHeuristicsCompat.InterfaceC0262c
        /* renamed from: a */
        public int mo9689a(CharSequence charSequence, int i, int i2) {
            int i3 = i2 + i;
            int i4 = 2;
            while (i < i3 && i4 == 2) {
                i4 = TextDirectionHeuristicsCompat.m9690b(Character.getDirectionality(charSequence.charAt(i)));
                i++;
            }
            return i4;
        }
    }

    /* compiled from: TextDirectionHeuristicsCompat.java */
    /* renamed from: a.b.g.i.d$c */
    /* loaded from: classes.dex */
    public interface InterfaceC0262c {
        /* renamed from: a */
        int mo9689a(CharSequence charSequence, int i, int i2);
    }

    /* compiled from: TextDirectionHeuristicsCompat.java */
    /* renamed from: a.b.g.i.d$d */
    /* loaded from: classes.dex */
    public static abstract class AbstractC0263d implements TextDirectionHeuristicCompat {

        /* renamed from: a */
        public final InterfaceC0262c f1544a;

        public AbstractC0263d(InterfaceC0262c interfaceC0262c) {
            this.f1544a = interfaceC0262c;
        }

        /* renamed from: a */
        public abstract boolean mo9686a();

        @Override // p000a.p006b.p030g.p043i.TextDirectionHeuristicCompat
        /* renamed from: a */
        public boolean mo9688a(CharSequence charSequence, int i, int i2) {
            if (charSequence != null && i >= 0 && i2 >= 0 && charSequence.length() - i2 >= i) {
                if (this.f1544a == null) {
                    return mo9686a();
                }
                return m9687b(charSequence, i, i2);
            }
            throw new IllegalArgumentException();
        }

        /* renamed from: b */
        public final boolean m9687b(CharSequence charSequence, int i, int i2) {
            int mo9689a = this.f1544a.mo9689a(charSequence, i, i2);
            if (mo9689a != 0) {
                if (mo9689a != 1) {
                    return mo9686a();
                }
                return false;
            }
            return true;
        }
    }

    /* compiled from: TextDirectionHeuristicsCompat.java */
    /* renamed from: a.b.g.i.d$e */
    /* loaded from: classes.dex */
    public static class C0264e extends AbstractC0263d {

        /* renamed from: b */
        public final boolean f1545b;

        public C0264e(InterfaceC0262c interfaceC0262c, boolean z) {
            super(interfaceC0262c);
            this.f1545b = z;
        }

        @Override // p000a.p006b.p030g.p043i.TextDirectionHeuristicsCompat.AbstractC0263d
        /* renamed from: a */
        public boolean mo9686a() {
            return this.f1545b;
        }
    }

    /* compiled from: TextDirectionHeuristicsCompat.java */
    /* renamed from: a.b.g.i.d$f */
    /* loaded from: classes.dex */
    public static class C0265f extends AbstractC0263d {

        /* renamed from: b */
        public static final C0265f f1546b = new C0265f();

        public C0265f() {
            super(null);
        }

        @Override // p000a.p006b.p030g.p043i.TextDirectionHeuristicsCompat.AbstractC0263d
        /* renamed from: a */
        public boolean mo9686a() {
            return TextUtilsCompat.m9684b(Locale.getDefault()) == 1;
        }
    }

    static {
        new C0264e(null, false);
        new C0264e(null, true);
        f1539a = new C0264e(C0261b.f1543a, false);
        f1540b = new C0264e(C0261b.f1543a, true);
        new C0264e(C0260a.f1541b, false);
        C0265f c0265f = C0265f.f1546b;
    }

    /* renamed from: a */
    public static int m9691a(int i) {
        if (i != 0) {
            return (i == 1 || i == 2) ? 0 : 2;
        }
        return 1;
    }

    /* renamed from: b */
    public static int m9690b(int i) {
        if (i != 0) {
            if (i == 1 || i == 2) {
                return 0;
            }
            switch (i) {
                case 14:
                case 15:
                    break;
                case 16:
                case 17:
                    return 0;
                default:
                    return 2;
            }
        }
        return 1;
    }
}
