package p192f;

import java.io.InterruptedIOException;
import java.util.concurrent.TimeUnit;

/* renamed from: f.s */
/* loaded from: classes.dex */
public class Timeout {

    /* renamed from: d */
    public static final Timeout f8493d = new C1827a();

    /* renamed from: a */
    public boolean f8494a;

    /* renamed from: b */
    public long f8495b;

    /* renamed from: c */
    public long f8496c;

    /* compiled from: Timeout.java */
    /* renamed from: f.s$a */
    /* loaded from: classes.dex */
    public class C1827a extends Timeout {
        @Override // p192f.Timeout
        /* renamed from: a */
        public Timeout mo2522a(long j) {
            return this;
        }

        @Override // p192f.Timeout
        /* renamed from: a */
        public Timeout mo2521a(long j, TimeUnit timeUnit) {
            return this;
        }

        @Override // p192f.Timeout
        /* renamed from: e */
        public void mo2520e() {
        }
    }

    /* renamed from: a */
    public Timeout mo2521a(long j, TimeUnit timeUnit) {
        if (j >= 0) {
            if (timeUnit != null) {
                this.f8496c = timeUnit.toNanos(j);
                return this;
            }
            throw new IllegalArgumentException("unit == null");
        }
        throw new IllegalArgumentException("timeout < 0: " + j);
    }

    /* renamed from: b */
    public Timeout mo2526b() {
        this.f8496c = 0L;
        return this;
    }

    /* renamed from: c */
    public long mo2525c() {
        if (this.f8494a) {
            return this.f8495b;
        }
        throw new IllegalStateException("No deadline");
    }

    /* renamed from: d */
    public boolean mo2524d() {
        return this.f8494a;
    }

    /* renamed from: e */
    public void mo2520e() {
        if (!Thread.interrupted()) {
            if (this.f8494a && this.f8495b - System.nanoTime() <= 0) {
                throw new InterruptedIOException("deadline reached");
            }
            return;
        }
        throw new InterruptedIOException("thread interrupted");
    }

    /* renamed from: f */
    public long m2523f() {
        return this.f8496c;
    }

    /* renamed from: a */
    public Timeout mo2522a(long j) {
        this.f8494a = true;
        this.f8495b = j;
        return this;
    }

    /* renamed from: a */
    public Timeout mo2527a() {
        this.f8494a = false;
        return this;
    }
}
