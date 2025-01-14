package f;

import java.io.InterruptedIOException;
import java.util.concurrent.TimeUnit;
/* compiled from: Timeout.java */
/* loaded from: classes.dex */
public class s {

    /* renamed from: d  reason: collision with root package name */
    public static final s f6041d = new a();

    /* renamed from: a  reason: collision with root package name */
    public boolean f6042a;

    /* renamed from: b  reason: collision with root package name */
    public long f6043b;

    /* renamed from: c  reason: collision with root package name */
    public long f6044c;

    /* compiled from: Timeout.java */
    /* loaded from: classes.dex */
    public class a extends s {
        @Override // f.s
        public s a(long j) {
            return this;
        }

        @Override // f.s
        public s a(long j, TimeUnit timeUnit) {
            return this;
        }

        @Override // f.s
        public void e() {
        }
    }

    public s a(long j, TimeUnit timeUnit) {
        if (j >= 0) {
            if (timeUnit != null) {
                this.f6044c = timeUnit.toNanos(j);
                return this;
            }
            throw new IllegalArgumentException("unit == null");
        }
        throw new IllegalArgumentException("timeout < 0: " + j);
    }

    public s b() {
        this.f6044c = 0L;
        return this;
    }

    public long c() {
        if (this.f6042a) {
            return this.f6043b;
        }
        throw new IllegalStateException("No deadline");
    }

    public boolean d() {
        return this.f6042a;
    }

    public void e() {
        if (!Thread.interrupted()) {
            if (this.f6042a && this.f6043b - System.nanoTime() <= 0) {
                throw new InterruptedIOException("deadline reached");
            }
            return;
        }
        throw new InterruptedIOException("thread interrupted");
    }

    public long f() {
        return this.f6044c;
    }

    public s a(long j) {
        this.f6042a = true;
        this.f6043b = j;
        return this;
    }

    public s a() {
        this.f6042a = false;
        return this;
    }
}
