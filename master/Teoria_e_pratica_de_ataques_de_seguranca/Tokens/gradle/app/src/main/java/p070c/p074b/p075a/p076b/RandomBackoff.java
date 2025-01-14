package p070c.p074b.p075a.p076b;

import java.util.Random;
import p136d.p137a.p138a.p139a.p140m.p143c.p144n.Backoff;

/* renamed from: c.b.a.b.p */
/* loaded from: classes.dex */
public class RandomBackoff implements Backoff {

    /* renamed from: a */
    public final Backoff f4703a;

    /* renamed from: b */
    public final Random f4704b;

    /* renamed from: c */
    public final double f4705c;

    public RandomBackoff(Backoff backoff, double d) {
        this(backoff, d, new Random());
    }

    @Override // p136d.p137a.p138a.p139a.p140m.p143c.p144n.Backoff
    /* renamed from: a */
    public long mo3961a(int i) {
        return (long) (m6034a() * this.f4703a.mo3961a(i));
    }

    public RandomBackoff(Backoff backoff, double d, Random random) {
        if (d < 0.0d || d > 1.0d) {
            throw new IllegalArgumentException("jitterPercent must be between 0.0 and 1.0");
        }
        if (backoff == null) {
            throw new NullPointerException("backoff must not be null");
        }
        if (random != null) {
            this.f4703a = backoff;
            this.f4705c = d;
            this.f4704b = random;
            return;
        }
        throw new NullPointerException("random must not be null");
    }

    /* renamed from: a */
    public double m6034a() {
        double d = this.f4705c;
        double d2 = 1.0d - d;
        return d2 + (((d + 1.0d) - d2) * this.f4704b.nextDouble());
    }
}
