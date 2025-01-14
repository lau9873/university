package p192f;

import java.util.concurrent.TimeUnit;

/* renamed from: f.h */
/* loaded from: classes.dex */
public class ForwardingTimeout extends Timeout {

    /* renamed from: e */
    public Timeout f8459e;

    public ForwardingTimeout(Timeout timeout) {
        if (timeout != null) {
            this.f8459e = timeout;
            return;
        }
        throw new IllegalArgumentException("delegate == null");
    }

    /* renamed from: a */
    public final ForwardingTimeout m2595a(Timeout timeout) {
        if (timeout != null) {
            this.f8459e = timeout;
            return this;
        }
        throw new IllegalArgumentException("delegate == null");
    }

    @Override // p192f.Timeout
    /* renamed from: b */
    public Timeout mo2526b() {
        return this.f8459e.mo2526b();
    }

    @Override // p192f.Timeout
    /* renamed from: c */
    public long mo2525c() {
        return this.f8459e.mo2525c();
    }

    @Override // p192f.Timeout
    /* renamed from: d */
    public boolean mo2524d() {
        return this.f8459e.mo2524d();
    }

    @Override // p192f.Timeout
    /* renamed from: e */
    public void mo2520e() {
        this.f8459e.mo2520e();
    }

    /* renamed from: g */
    public final Timeout m2594g() {
        return this.f8459e;
    }

    @Override // p192f.Timeout
    /* renamed from: a */
    public Timeout mo2521a(long j, TimeUnit timeUnit) {
        return this.f8459e.mo2521a(j, timeUnit);
    }

    @Override // p192f.Timeout
    /* renamed from: a */
    public Timeout mo2522a(long j) {
        return this.f8459e.mo2522a(j);
    }

    @Override // p192f.Timeout
    /* renamed from: a */
    public Timeout mo2527a() {
        return this.f8459e.mo2527a();
    }
}
