package c.b.a.b;
/* compiled from: RetryManager.java */
/* loaded from: classes.dex */
public class q {

    /* renamed from: a  reason: collision with root package name */
    public long f2901a;

    /* renamed from: b  reason: collision with root package name */
    public d.a.a.a.m.c.n.e f2902b;

    public q(d.a.a.a.m.c.n.e eVar) {
        if (eVar != null) {
            this.f2902b = eVar;
            return;
        }
        throw new NullPointerException("retryState must not be null");
    }

    public boolean a(long j) {
        return j - this.f2901a >= this.f2902b.a() * 1000000;
    }

    public void b(long j) {
        this.f2901a = j;
        this.f2902b = this.f2902b.c();
    }

    public void a() {
        this.f2901a = 0L;
        this.f2902b = this.f2902b.b();
    }
}
