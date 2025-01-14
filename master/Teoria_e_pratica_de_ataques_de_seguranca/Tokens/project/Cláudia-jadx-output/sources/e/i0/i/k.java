package e.i0.i;

import java.util.concurrent.CountDownLatch;
/* compiled from: Ping.java */
/* loaded from: classes.dex */
public final class k {

    /* renamed from: a  reason: collision with root package name */
    public final CountDownLatch f5811a = new CountDownLatch(1);

    /* renamed from: b  reason: collision with root package name */
    public long f5812b = -1;

    /* renamed from: c  reason: collision with root package name */
    public long f5813c = -1;

    public void a() {
        if (this.f5813c == -1) {
            long j = this.f5812b;
            if (j != -1) {
                this.f5813c = j - 1;
                this.f5811a.countDown();
                return;
            }
        }
        throw new IllegalStateException();
    }

    public void b() {
        if (this.f5813c == -1 && this.f5812b != -1) {
            this.f5813c = System.nanoTime();
            this.f5811a.countDown();
            return;
        }
        throw new IllegalStateException();
    }

    public void c() {
        if (this.f5812b == -1) {
            this.f5812b = System.nanoTime();
            return;
        }
        throw new IllegalStateException();
    }
}
