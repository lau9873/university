package c.b.a.b;

import java.util.Random;
/* compiled from: RandomBackoff.java */
/* loaded from: classes.dex */
public class p implements d.a.a.a.m.c.n.a {

    /* renamed from: a  reason: collision with root package name */
    public final d.a.a.a.m.c.n.a f2898a;

    /* renamed from: b  reason: collision with root package name */
    public final Random f2899b;

    /* renamed from: c  reason: collision with root package name */
    public final double f2900c;

    public p(d.a.a.a.m.c.n.a aVar, double d2) {
        this(aVar, d2, new Random());
    }

    @Override // d.a.a.a.m.c.n.a
    public long a(int i2) {
        return (long) (a() * this.f2898a.a(i2));
    }

    public p(d.a.a.a.m.c.n.a aVar, double d2, Random random) {
        if (d2 < 0.0d || d2 > 1.0d) {
            throw new IllegalArgumentException("jitterPercent must be between 0.0 and 1.0");
        }
        if (aVar == null) {
            throw new NullPointerException("backoff must not be null");
        }
        if (random != null) {
            this.f2898a = aVar;
            this.f2900c = d2;
            this.f2899b = random;
            return;
        }
        throw new NullPointerException("random must not be null");
    }

    public double a() {
        double d2 = this.f2900c;
        double d3 = 1.0d - d2;
        return d3 + (((d2 + 1.0d) - d3) * this.f2899b.nextDouble());
    }
}
