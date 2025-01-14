package c.d.a.a.e.e.l;
/* loaded from: classes.dex */
public final class f1<L> {

    /* renamed from: a  reason: collision with root package name */
    public final L f3294a;

    /* renamed from: b  reason: collision with root package name */
    public final String f3295b;

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof f1) {
            f1 f1Var = (f1) obj;
            return this.f3294a == f1Var.f3294a && this.f3295b.equals(f1Var.f3295b);
        }
        return false;
    }

    public final int hashCode() {
        return (System.identityHashCode(this.f3294a) * 31) + this.f3295b.hashCode();
    }
}
