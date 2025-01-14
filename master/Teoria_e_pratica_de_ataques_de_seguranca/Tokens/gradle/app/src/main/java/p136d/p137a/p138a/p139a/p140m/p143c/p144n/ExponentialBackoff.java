package p136d.p137a.p138a.p139a.p140m.p143c.p144n;

/* renamed from: d.a.a.a.m.c.n.c */
/* loaded from: classes.dex */
public class ExponentialBackoff implements Backoff {

    /* renamed from: a */
    public final long f6556a;

    /* renamed from: b */
    public final int f6557b;

    public ExponentialBackoff(long j, int i) {
        this.f6556a = j;
        this.f6557b = i;
    }

    @Override // p136d.p137a.p138a.p139a.p140m.p143c.p144n.Backoff
    /* renamed from: a */
    public long mo3961a(int i) {
        return (long) (this.f6556a * Math.pow(this.f6557b, i));
    }
}
