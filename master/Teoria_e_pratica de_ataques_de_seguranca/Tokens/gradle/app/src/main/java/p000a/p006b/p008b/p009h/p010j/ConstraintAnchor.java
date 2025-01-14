package p000a.p006b.p008b.p009h.p010j;

import p000a.p006b.p008b.p009h.Cache;
import p000a.p006b.p008b.p009h.SolverVariable;

/* renamed from: a.b.b.h.j.e */
/* loaded from: classes.dex */
public class ConstraintAnchor {

    /* renamed from: b */
    public final ConstraintWidget f256b;

    /* renamed from: c */
    public final EnumC0031d f257c;

    /* renamed from: d */
    public ConstraintAnchor f258d;

    /* renamed from: h */
    public int f262h;

    /* renamed from: i */
    public SolverVariable f263i;

    /* renamed from: a */
    public ResolutionAnchor f255a = new ResolutionAnchor(this);

    /* renamed from: e */
    public int f259e = 0;

    /* renamed from: f */
    public int f260f = -1;

    /* renamed from: g */
    public EnumC0030c f261g = EnumC0030c.NONE;

    /* compiled from: ConstraintAnchor.java */
    /* renamed from: a.b.b.h.j.e$a */
    /* loaded from: classes.dex */
    public static /* synthetic */ class C0028a {

        /* renamed from: a */
        public static final /* synthetic */ int[] f264a = new int[EnumC0031d.values().length];

        static {
            try {
                f264a[EnumC0031d.CENTER.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f264a[EnumC0031d.LEFT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f264a[EnumC0031d.RIGHT.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f264a[EnumC0031d.TOP.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f264a[EnumC0031d.BOTTOM.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f264a[EnumC0031d.BASELINE.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f264a[EnumC0031d.CENTER_X.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                f264a[EnumC0031d.CENTER_Y.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                f264a[EnumC0031d.NONE.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
        }
    }

    /* compiled from: ConstraintAnchor.java */
    /* renamed from: a.b.b.h.j.e$b */
    /* loaded from: classes.dex */
    public enum EnumC0029b {
        RELAXED,
        STRICT
    }

    /* compiled from: ConstraintAnchor.java */
    /* renamed from: a.b.b.h.j.e$c */
    /* loaded from: classes.dex */
    public enum EnumC0030c {
        NONE,
        STRONG,
        WEAK
    }

    /* compiled from: ConstraintAnchor.java */
    /* renamed from: a.b.b.h.j.e$d */
    /* loaded from: classes.dex */
    public enum EnumC0031d {
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

    public ConstraintAnchor(ConstraintWidget constraintWidget, EnumC0031d enumC0031d) {
        EnumC0029b enumC0029b = EnumC0029b.RELAXED;
        this.f262h = 0;
        this.f256b = constraintWidget;
        this.f257c = enumC0031d;
    }

    /* renamed from: a */
    public void m11138a(Cache cache) {
        SolverVariable solverVariable = this.f263i;
        if (solverVariable == null) {
            this.f263i = new SolverVariable(SolverVariable.EnumC0026a.UNRESTRICTED, null);
        } else {
            solverVariable.m11164a();
        }
    }

    /* renamed from: b */
    public int m11134b() {
        ConstraintAnchor constraintAnchor;
        if (this.f256b.m11059s() == 8) {
            return 0;
        }
        if (this.f260f > -1 && (constraintAnchor = this.f258d) != null && constraintAnchor.f256b.m11059s() == 8) {
            return this.f260f;
        }
        return this.f259e;
    }

    /* renamed from: c */
    public ConstraintWidget m11133c() {
        return this.f256b;
    }

    /* renamed from: d */
    public ResolutionAnchor m11132d() {
        return this.f255a;
    }

    /* renamed from: e */
    public SolverVariable m11131e() {
        return this.f263i;
    }

    /* renamed from: f */
    public EnumC0030c m11130f() {
        return this.f261g;
    }

    /* renamed from: g */
    public ConstraintAnchor m11129g() {
        return this.f258d;
    }

    /* renamed from: h */
    public EnumC0031d m11128h() {
        return this.f257c;
    }

    /* renamed from: i */
    public boolean m11127i() {
        return this.f258d != null;
    }

    /* renamed from: j */
    public void m11126j() {
        this.f258d = null;
        this.f259e = 0;
        this.f260f = -1;
        this.f261g = EnumC0030c.STRONG;
        this.f262h = 0;
        EnumC0029b enumC0029b = EnumC0029b.RELAXED;
        this.f255a.mo10988d();
    }

    public String toString() {
        return this.f256b.m11083g() + ":" + this.f257c.toString();
    }

    /* renamed from: a */
    public int m11139a() {
        return this.f262h;
    }

    /* renamed from: a */
    public boolean m11135a(ConstraintAnchor constraintAnchor, int i, EnumC0030c enumC0030c, int i2) {
        return m11136a(constraintAnchor, i, -1, enumC0030c, i2, false);
    }

    /* renamed from: a */
    public boolean m11136a(ConstraintAnchor constraintAnchor, int i, int i2, EnumC0030c enumC0030c, int i3, boolean z) {
        if (constraintAnchor == null) {
            this.f258d = null;
            this.f259e = 0;
            this.f260f = -1;
            this.f261g = EnumC0030c.NONE;
            this.f262h = 2;
            return true;
        } else if (z || m11137a(constraintAnchor)) {
            this.f258d = constraintAnchor;
            if (i > 0) {
                this.f259e = i;
            } else {
                this.f259e = 0;
            }
            this.f260f = i2;
            this.f261g = enumC0030c;
            this.f262h = i3;
            return true;
        } else {
            return false;
        }
    }

    /* renamed from: a */
    public boolean m11137a(ConstraintAnchor constraintAnchor) {
        if (constraintAnchor == null) {
            return false;
        }
        EnumC0031d m11128h = constraintAnchor.m11128h();
        EnumC0031d enumC0031d = this.f257c;
        if (m11128h == enumC0031d) {
            return enumC0031d != EnumC0031d.BASELINE || (constraintAnchor.m11133c().m11051y() && m11133c().m11051y());
        }
        switch (C0028a.f264a[enumC0031d.ordinal()]) {
            case 1:
                return (m11128h == EnumC0031d.BASELINE || m11128h == EnumC0031d.CENTER_X || m11128h == EnumC0031d.CENTER_Y) ? false : true;
            case 2:
            case 3:
                boolean z = m11128h == EnumC0031d.LEFT || m11128h == EnumC0031d.RIGHT;
                return constraintAnchor.m11133c() instanceof Guideline ? z || m11128h == EnumC0031d.CENTER_X : z;
            case 4:
            case 5:
                boolean z2 = m11128h == EnumC0031d.TOP || m11128h == EnumC0031d.BOTTOM;
                return constraintAnchor.m11133c() instanceof Guideline ? z2 || m11128h == EnumC0031d.CENTER_Y : z2;
            case 6:
            case 7:
            case 8:
            case 9:
                return false;
            default:
                throw new AssertionError(this.f257c.name());
        }
    }
}
