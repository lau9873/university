package d.c.f0.i;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
/* compiled from: SubscriptionArbiter.java */
/* loaded from: classes.dex */
public class f extends AtomicInteger implements g.b.d {

    /* renamed from: a  reason: collision with root package name */
    public g.b.d f5358a;

    /* renamed from: b  reason: collision with root package name */
    public long f5359b;

    /* renamed from: c  reason: collision with root package name */
    public final AtomicReference<g.b.d> f5360c = new AtomicReference<>();

    /* renamed from: d  reason: collision with root package name */
    public final AtomicLong f5361d = new AtomicLong();

    /* renamed from: e  reason: collision with root package name */
    public final AtomicLong f5362e = new AtomicLong();

    /* renamed from: f  reason: collision with root package name */
    public volatile boolean f5363f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f5364g;

    @Override // g.b.d
    public final void a(long j) {
        if (!g.c(j) || this.f5364g) {
            return;
        }
        if (get() == 0 && compareAndSet(0, 1)) {
            long j2 = this.f5359b;
            if (j2 != Long.MAX_VALUE) {
                long a2 = d.c.f0.j.c.a(j2, j);
                this.f5359b = a2;
                if (a2 == Long.MAX_VALUE) {
                    this.f5364g = true;
                }
            }
            g.b.d dVar = this.f5358a;
            if (decrementAndGet() != 0) {
                c();
            }
            if (dVar != null) {
                dVar.a(j);
                return;
            }
            return;
        }
        d.c.f0.j.c.a(this.f5361d, j);
        b();
    }

    public final void b(g.b.d dVar) {
        if (this.f5363f) {
            dVar.cancel();
            return;
        }
        d.c.f0.b.b.a(dVar, "s is null");
        if (get() == 0 && compareAndSet(0, 1)) {
            g.b.d dVar2 = this.f5358a;
            if (dVar2 != null) {
                dVar2.cancel();
            }
            this.f5358a = dVar;
            long j = this.f5359b;
            if (decrementAndGet() != 0) {
                c();
            }
            if (j != 0) {
                dVar.a(j);
                return;
            }
            return;
        }
        g.b.d andSet = this.f5360c.getAndSet(dVar);
        if (andSet != null) {
            andSet.cancel();
        }
        b();
    }

    public final void c() {
        g.b.d dVar = null;
        long j = 0;
        int i2 = 1;
        do {
            g.b.d dVar2 = this.f5360c.get();
            if (dVar2 != null) {
                dVar2 = this.f5360c.getAndSet(null);
            }
            long j2 = this.f5361d.get();
            if (j2 != 0) {
                j2 = this.f5361d.getAndSet(0L);
            }
            long j3 = this.f5362e.get();
            if (j3 != 0) {
                j3 = this.f5362e.getAndSet(0L);
            }
            g.b.d dVar3 = this.f5358a;
            if (this.f5363f) {
                if (dVar3 != null) {
                    dVar3.cancel();
                    this.f5358a = null;
                }
                if (dVar2 != null) {
                    dVar2.cancel();
                }
            } else {
                long j4 = this.f5359b;
                if (j4 != Long.MAX_VALUE) {
                    j4 = d.c.f0.j.c.a(j4, j2);
                    if (j4 != Long.MAX_VALUE) {
                        long j5 = j4 - j3;
                        if (j5 < 0) {
                            g.b(j5);
                            j5 = 0;
                        }
                        j4 = j5;
                    }
                    this.f5359b = j4;
                }
                if (dVar2 != null) {
                    if (dVar3 != null) {
                        dVar3.cancel();
                    }
                    this.f5358a = dVar2;
                    if (j4 != 0) {
                        j = d.c.f0.j.c.a(j, j4);
                        dVar = dVar2;
                    }
                } else if (dVar3 != null && j2 != 0) {
                    j = d.c.f0.j.c.a(j, j2);
                    dVar = dVar3;
                }
            }
            i2 = addAndGet(-i2);
        } while (i2 != 0);
        if (j != 0) {
            dVar.a(j);
        }
    }

    public void cancel() {
        if (this.f5363f) {
            return;
        }
        this.f5363f = true;
        b();
    }

    public final boolean d() {
        return this.f5363f;
    }

    public final boolean e() {
        return this.f5364g;
    }

    public final void b(long j) {
        if (this.f5364g) {
            return;
        }
        if (get() == 0 && compareAndSet(0, 1)) {
            long j2 = this.f5359b;
            if (j2 != Long.MAX_VALUE) {
                long j3 = j2 - j;
                long j4 = 0;
                if (j3 < 0) {
                    g.b(j3);
                } else {
                    j4 = j3;
                }
                this.f5359b = j4;
            }
            if (decrementAndGet() == 0) {
                return;
            }
            c();
            return;
        }
        d.c.f0.j.c.a(this.f5362e, j);
        b();
    }

    public final void b() {
        if (getAndIncrement() != 0) {
            return;
        }
        c();
    }
}
