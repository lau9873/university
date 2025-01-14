package p181e.p182i0.p187i;

import java.util.concurrent.CountDownLatch;

/* renamed from: e.i0.i.k */
/* loaded from: classes.dex */
public final class Ping {

    /* renamed from: a */
    public final CountDownLatch f8219a = new CountDownLatch(1);

    /* renamed from: b */
    public long f8220b = -1;

    /* renamed from: c */
    public long f8221c = -1;

    /* renamed from: a */
    public void m2892a() {
        if (this.f8221c == -1) {
            long j = this.f8220b;
            if (j != -1) {
                this.f8221c = j - 1;
                this.f8219a.countDown();
                return;
            }
        }
        throw new IllegalStateException();
    }

    /* renamed from: b */
    public void m2891b() {
        if (this.f8221c == -1 && this.f8220b != -1) {
            this.f8221c = System.nanoTime();
            this.f8219a.countDown();
            return;
        }
        throw new IllegalStateException();
    }

    /* renamed from: c */
    public void m2890c() {
        if (this.f8220b == -1) {
            this.f8220b = System.nanoTime();
            return;
        }
        throw new IllegalStateException();
    }
}
