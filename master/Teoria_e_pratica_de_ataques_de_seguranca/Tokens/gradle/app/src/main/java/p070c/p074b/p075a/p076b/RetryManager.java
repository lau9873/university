package p070c.p074b.p075a.p076b;

import p136d.p137a.p138a.p139a.p140m.p143c.p144n.RetryState;

/* renamed from: c.b.a.b.q */
/* loaded from: classes.dex */
public class RetryManager {

    /* renamed from: a */
    public long f4706a;

    /* renamed from: b */
    public RetryState f4707b;

    public RetryManager(RetryState retryState) {
        if (retryState != null) {
            this.f4707b = retryState;
            return;
        }
        throw new NullPointerException("retryState must not be null");
    }

    /* renamed from: a */
    public boolean m6032a(long j) {
        return j - this.f4706a >= this.f4707b.m3960a() * 1000000;
    }

    /* renamed from: b */
    public void m6031b(long j) {
        this.f4706a = j;
        this.f4707b = this.f4707b.m3958c();
    }

    /* renamed from: a */
    public void m6033a() {
        this.f4706a = 0L;
        this.f4707b = this.f4707b.m3959b();
    }
}
