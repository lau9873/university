package p136d.p137a.p138a.p139a.p140m.p143c.p144n;

/* renamed from: d.a.a.a.m.c.n.e */
/* loaded from: classes.dex */
public class RetryState {

    /* renamed from: a */
    public final int f6558a;

    /* renamed from: b */
    public final Backoff f6559b;

    /* renamed from: c */
    public final InterfaceC1517d f6560c;

    public RetryState(Backoff backoff, InterfaceC1517d interfaceC1517d) {
        this(0, backoff, interfaceC1517d);
    }

    /* renamed from: a */
    public long m3960a() {
        return this.f6559b.mo3961a(this.f6558a);
    }

    /* renamed from: b */
    public RetryState m3959b() {
        return new RetryState(this.f6559b, this.f6560c);
    }

    /* renamed from: c */
    public RetryState m3958c() {
        return new RetryState(this.f6558a + 1, this.f6559b, this.f6560c);
    }

    public RetryState(int i, Backoff backoff, InterfaceC1517d interfaceC1517d) {
        this.f6558a = i;
        this.f6559b = backoff;
        this.f6560c = interfaceC1517d;
    }
}
