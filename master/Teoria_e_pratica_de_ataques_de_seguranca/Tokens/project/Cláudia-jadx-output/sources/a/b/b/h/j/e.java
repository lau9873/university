package a.b.b.h.j;

import a.b.b.h.i;
/* compiled from: ConstraintAnchor.java */
/* loaded from: classes.dex */
public class e {

    /* renamed from: b  reason: collision with root package name */
    public final f f138b;

    /* renamed from: c  reason: collision with root package name */
    public final d f139c;

    /* renamed from: d  reason: collision with root package name */
    public e f140d;

    /* renamed from: h  reason: collision with root package name */
    public int f144h;

    /* renamed from: i  reason: collision with root package name */
    public a.b.b.h.i f145i;

    /* renamed from: a  reason: collision with root package name */
    public m f137a = new m(this);

    /* renamed from: e  reason: collision with root package name */
    public int f141e = 0;

    /* renamed from: f  reason: collision with root package name */
    public int f142f = -1;

    /* renamed from: g  reason: collision with root package name */
    public c f143g = c.NONE;

    /* compiled from: ConstraintAnchor.java */
    /* loaded from: classes.dex */
    public static /* synthetic */ class a {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f146a = new int[d.values().length];

        static {
            try {
                f146a[d.CENTER.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f146a[d.LEFT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f146a[d.RIGHT.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f146a[d.TOP.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f146a[d.BOTTOM.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f146a[d.BASELINE.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f146a[d.CENTER_X.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                f146a[d.CENTER_Y.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                f146a[d.NONE.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
        }
    }

    /* compiled from: ConstraintAnchor.java */
    /* loaded from: classes.dex */
    public enum b {
        RELAXED,
        STRICT
    }

    /* compiled from: ConstraintAnchor.java */
    /* loaded from: classes.dex */
    public enum c {
        NONE,
        STRONG,
        WEAK
    }

    /* compiled from: ConstraintAnchor.java */
    /* loaded from: classes.dex */
    public enum d {
        NONE,
        LEFT,
        TOP,
        RIGHT,
        BOTTOM,
        BASELINE,
        CENTER,
        CENTER_X,
        CENTER_Y
    }

    public e(f fVar, d dVar) {
        b bVar = b.RELAXED;
        this.f144h = 0;
        this.f138b = fVar;
        this.f139c = dVar;
    }

    public void a(a.b.b.h.c cVar) {
        a.b.b.h.i iVar = this.f145i;
        if (iVar == null) {
            this.f145i = new a.b.b.h.i(i.a.UNRESTRICTED, null);
        } else {
            iVar.a();
        }
    }

    public int b() {
        e eVar;
        if (this.f138b.s() == 8) {
            return 0;
        }
        if (this.f142f > -1 && (eVar = this.f140d) != null && eVar.f138b.s() == 8) {
            return this.f142f;
        }
        return this.f141e;
    }

    public f c() {
        return this.f138b;
    }

    public m d() {
        return this.f137a;
    }

    public a.b.b.h.i e() {
        return this.f145i;
    }

    public c f() {
        return this.f143g;
    }

    public e g() {
        return this.f140d;
    }

    public d h() {
        return this.f139c;
    }

    public boolean i() {
        return this.f140d != null;
    }

    public void j() {
        this.f140d = null;
        this.f141e = 0;
        this.f142f = -1;
        this.f143g = c.STRONG;
        this.f144h = 0;
        b bVar = b.RELAXED;
        this.f137a.d();
    }

    public String toString() {
        return this.f138b.g() + ":" + this.f139c.toString();
    }

    public int a() {
        return this.f144h;
    }

    public boolean a(e eVar, int i2, c cVar, int i3) {
        return a(eVar, i2, -1, cVar, i3, false);
    }

    public boolean a(e eVar, int i2, int i3, c cVar, int i4, boolean z) {
        if (eVar == null) {
            this.f140d = null;
            this.f141e = 0;
            this.f142f = -1;
            this.f143g = c.NONE;
            this.f144h = 2;
            return true;
        } else if (z || a(eVar)) {
            this.f140d = eVar;
            if (i2 > 0) {
                this.f141e = i2;
            } else {
                this.f141e = 0;
            }
            this.f142f = i3;
            this.f143g = cVar;
            this.f144h = i4;
            return true;
        } else {
            return false;
        }
    }

    public boolean a(e eVar) {
        if (eVar == null) {
            return false;
        }
        d h2 = eVar.h();
        d dVar = this.f139c;
        if (h2 == dVar) {
            return dVar != d.BASELINE || (eVar.c().y() && c().y());
        }
        switch (a.f146a[dVar.ordinal()]) {
            case 1:
                return (h2 == d.BASELINE || h2 == d.CENTER_X || h2 == d.CENTER_Y) ? false : true;
            case 2:
            case 3:
                boolean z = h2 == d.LEFT || h2 == d.RIGHT;
                return eVar.c() instanceof i ? z || h2 == d.CENTER_X : z;
            case 4:
            case 5:
                boolean z2 = h2 == d.TOP || h2 == d.BOTTOM;
                return eVar.c() instanceof i ? z2 || h2 == d.CENTER_Y : z2;
            case 6:
            case 7:
            case 8:
            case 9:
                return false;
            default:
                throw new AssertionError(this.f139c.name());
        }
    }
}
