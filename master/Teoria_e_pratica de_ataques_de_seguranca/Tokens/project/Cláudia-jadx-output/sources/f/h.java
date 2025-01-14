package f;

import java.util.concurrent.TimeUnit;
/* compiled from: ForwardingTimeout.java */
/* loaded from: classes.dex */
public class h extends s {

    /* renamed from: e  reason: collision with root package name */
    public s f6008e;

    public h(s sVar) {
        if (sVar != null) {
            this.f6008e = sVar;
            return;
        }
        throw new IllegalArgumentException("delegate == null");
    }

    public final h a(s sVar) {
        if (sVar != null) {
            this.f6008e = sVar;
            return this;
        }
        throw new IllegalArgumentException("delegate == null");
    }

    @Override // f.s
    public s b() {
        return this.f6008e.b();
    }

    @Override // f.s
    public long c() {
        return this.f6008e.c();
    }

    @Override // f.s
    public boolean d() {
        return this.f6008e.d();
    }

    @Override // f.s
    public void e() {
        this.f6008e.e();
    }

    public final s g() {
        return this.f6008e;
    }

    @Override // f.s
    public s a(long j, TimeUnit timeUnit) {
        return this.f6008e.a(j, timeUnit);
    }

    @Override // f.s
    public s a(long j) {
        return this.f6008e.a(j);
    }

    @Override // f.s
    public s a() {
        return this.f6008e.a();
    }
}
