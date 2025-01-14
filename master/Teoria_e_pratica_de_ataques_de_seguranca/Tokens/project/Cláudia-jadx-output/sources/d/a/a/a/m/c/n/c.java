package d.a.a.a.m.c.n;
/* compiled from: ExponentialBackoff.java */
/* loaded from: classes.dex */
public class c implements a {

    /* renamed from: a  reason: collision with root package name */
    public final long f4352a;

    /* renamed from: b  reason: collision with root package name */
    public final int f4353b;

    public c(long j, int i2) {
        this.f4352a = j;
        this.f4353b = i2;
    }

    @Override // d.a.a.a.m.c.n.a
    public long a(int i2) {
        return (long) (this.f4352a * Math.pow(this.f4353b, i2));
    }
}
