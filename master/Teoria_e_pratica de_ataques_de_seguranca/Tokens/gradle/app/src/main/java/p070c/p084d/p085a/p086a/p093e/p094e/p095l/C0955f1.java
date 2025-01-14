package p070c.p084d.p085a.p086a.p093e.p094e.p095l;

/* renamed from: c.d.a.a.e.e.l.f1 */
/* loaded from: classes.dex */
public final class C0955f1<L> {

    /* renamed from: a */
    public final L f5174a;

    /* renamed from: b */
    public final String f5175b;

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof C0955f1) {
            C0955f1 c0955f1 = (C0955f1) obj;
            return this.f5174a == c0955f1.f5174a && this.f5175b.equals(c0955f1.f5175b);
        }
        return false;
    }

    public final int hashCode() {
        return (System.identityHashCode(this.f5174a) * 31) + this.f5175b.hashCode();
    }
}
