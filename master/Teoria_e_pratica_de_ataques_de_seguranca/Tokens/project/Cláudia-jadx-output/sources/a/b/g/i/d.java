package a.b.g.i;

import java.util.Locale;
/* compiled from: TextDirectionHeuristicsCompat.java */
/* loaded from: classes.dex */
public final class d {

    /* renamed from: a  reason: collision with root package name */
    public static final a.b.g.i.c f1029a;

    /* renamed from: b  reason: collision with root package name */
    public static final a.b.g.i.c f1030b;

    /* compiled from: TextDirectionHeuristicsCompat.java */
    /* loaded from: classes.dex */
    public static class a implements c {

        /* renamed from: b  reason: collision with root package name */
        public static final a f1031b = new a(true);

        /* renamed from: a  reason: collision with root package name */
        public final boolean f1032a;

        static {
            new a(false);
        }

        public a(boolean z) {
            this.f1032a = z;
        }

        @Override // a.b.g.i.d.c
        public int a(CharSequence charSequence, int i2, int i3) {
            int i4 = i3 + i2;
            boolean z = false;
            while (i2 < i4) {
                int a2 = d.a(Character.getDirectionality(charSequence.charAt(i2)));
                if (a2 != 0) {
                    if (a2 != 1) {
                        continue;
                        i2++;
                    } else if (!this.f1032a) {
                        return 1;
                    }
                } else if (this.f1032a) {
                    return 0;
                }
                z = true;
                i2++;
            }
            if (z) {
                return this.f1032a ? 1 : 0;
            }
            return 2;
        }
    }

    /* compiled from: TextDirectionHeuristicsCompat.java */
    /* loaded from: classes.dex */
    public static class b implements c {

        /* renamed from: a  reason: collision with root package name */
        public static final b f1033a = new b();

        @Override // a.b.g.i.d.c
        public int a(CharSequence charSequence, int i2, int i3) {
            int i4 = i3 + i2;
            int i5 = 2;
            while (i2 < i4 && i5 == 2) {
                i5 = d.b(Character.getDirectionality(charSequence.charAt(i2)));
                i2++;
            }
            return i5;
        }
    }

    /* compiled from: TextDirectionHeuristicsCompat.java */
    /* loaded from: classes.dex */
    public interface c {
        int a(CharSequence charSequence, int i2, int i3);
    }

    /* compiled from: TextDirectionHeuristicsCompat.java */
    /* renamed from: a.b.g.i.d$d  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static abstract class AbstractC0030d implements a.b.g.i.c {

        /* renamed from: a  reason: collision with root package name */
        public final c f1034a;

        public AbstractC0030d(c cVar) {
            this.f1034a = cVar;
        }

        public abstract boolean a();

        @Override // a.b.g.i.c
        public boolean a(CharSequence charSequence, int i2, int i3) {
            if (charSequence != null && i2 >= 0 && i3 >= 0 && charSequence.length() - i3 >= i2) {
                if (this.f1034a == null) {
                    return a();
                }
                return b(charSequence, i2, i3);
            }
            throw new IllegalArgumentException();
        }

        public final boolean b(CharSequence charSequence, int i2, int i3) {
            int a2 = this.f1034a.a(charSequence, i2, i3);
            if (a2 != 0) {
                if (a2 != 1) {
                    return a();
                }
                return false;
            }
            return true;
        }
    }

    /* compiled from: TextDirectionHeuristicsCompat.java */
    /* loaded from: classes.dex */
    public static class e extends AbstractC0030d {

        /* renamed from: b  reason: collision with root package name */
        public final boolean f1035b;

        public e(c cVar, boolean z) {
            super(cVar);
            this.f1035b = z;
        }

        @Override // a.b.g.i.d.AbstractC0030d
        public boolean a() {
            return this.f1035b;
        }
    }

    /* compiled from: TextDirectionHeuristicsCompat.java */
    /* loaded from: classes.dex */
    public static class f extends AbstractC0030d {

        /* renamed from: b  reason: collision with root package name */
        public static final f f1036b = new f();

        public f() {
            super(null);
        }

        @Override // a.b.g.i.d.AbstractC0030d
        public boolean a() {
            return a.b.g.i.e.b(Locale.getDefault()) == 1;
        }
    }

    static {
        new e(null, false);
        new e(null, true);
        f1029a = new e(b.f1033a, false);
        f1030b = new e(b.f1033a, true);
        new e(a.f1031b, false);
        f fVar = f.f1036b;
    }

    public static int a(int i2) {
        if (i2 != 0) {
            return (i2 == 1 || i2 == 2) ? 0 : 2;
        }
        return 1;
    }

    public static int b(int i2) {
        if (i2 != 0) {
            if (i2 == 1 || i2 == 2) {
                return 0;
            }
            switch (i2) {
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
