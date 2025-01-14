package d.c.f0.h;

import d.c.f0.i.g;
import d.c.f0.j.b;
import d.c.k;
import g.b.c;
import g.b.d;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
/* compiled from: StrictSubscriber.java */
/* loaded from: classes.dex */
public class a<T> extends AtomicInteger implements k<T>, d {

    /* renamed from: a  reason: collision with root package name */
    public final c<? super T> f5346a;

    /* renamed from: b  reason: collision with root package name */
    public final b f5347b = new b();

    /* renamed from: c  reason: collision with root package name */
    public final AtomicLong f5348c = new AtomicLong();

    /* renamed from: d  reason: collision with root package name */
    public final AtomicReference<d> f5349d = new AtomicReference<>();

    /* renamed from: e  reason: collision with root package name */
    public final AtomicBoolean f5350e = new AtomicBoolean();

    /* renamed from: f  reason: collision with root package name */
    public volatile boolean f5351f;

    public a(c<? super T> cVar) {
        this.f5346a = cVar;
    }

    @Override // g.b.d
    public void a(long j) {
        if (j <= 0) {
            cancel();
            a((Throwable) new IllegalArgumentException("§3.9 violated: positive request amount required but it was " + j));
            return;
        }
        g.a(this.f5349d, this.f5348c, j);
    }

    @Override // g.b.d
    public void cancel() {
        if (this.f5351f) {
            return;
        }
        g.a(this.f5349d);
    }

    @Override // g.b.c
    public void a(d dVar) {
        if (this.f5350e.compareAndSet(false, true)) {
            this.f5346a.a((d) this);
            g.a(this.f5349d, this.f5348c, dVar);
            return;
        }
        dVar.cancel();
        cancel();
        a((Throwable) new IllegalStateException("§2.12 violated: onSubscribe must be called at most once"));
    }

    @Override // g.b.c
    public void a(T t) {
        d.c.f0.j.g.a(this.f5346a, t, this, this.f5347b);
    }

    @Override // g.b.c
    public void a(Throwable th) {
        this.f5351f = true;
        d.c.f0.j.g.a((c<?>) this.f5346a, th, (AtomicInteger) this, this.f5347b);
    }

    @Override // g.b.c
    public void a() {
        this.f5351f = true;
        d.c.f0.j.g.a(this.f5346a, this, this.f5347b);
    }
}
