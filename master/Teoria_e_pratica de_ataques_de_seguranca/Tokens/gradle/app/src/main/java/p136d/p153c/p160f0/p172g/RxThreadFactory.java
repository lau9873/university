package p136d.p153c.p160f0.p172g;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicLong;

/* renamed from: d.c.f0.g.f */
/* loaded from: classes.dex */
public final class RxThreadFactory extends AtomicLong implements ThreadFactory {

    /* renamed from: a */
    public final String f7653a;

    /* renamed from: b */
    public final int f7654b;

    /* renamed from: c */
    public final boolean f7655c;

    /* compiled from: RxThreadFactory.java */
    /* renamed from: d.c.f0.g.f$a */
    /* loaded from: classes.dex */
    public static final class C1708a extends Thread implements NonBlockingThread {
        public C1708a(Runnable runnable, String str) {
            super(runnable, str);
        }
    }

    public RxThreadFactory(String str) {
        this(str, 5, false);
    }

    @Override // java.util.concurrent.ThreadFactory
    public Thread newThread(Runnable runnable) {
        String str = this.f7653a + '-' + incrementAndGet();
        Thread c1708a = this.f7655c ? new C1708a(runnable, str) : new Thread(runnable, str);
        c1708a.setPriority(this.f7654b);
        c1708a.setDaemon(true);
        return c1708a;
    }

    @Override // java.util.concurrent.atomic.AtomicLong
    public String toString() {
        return "RxThreadFactory[" + this.f7653a + "]";
    }

    public RxThreadFactory(String str, int i) {
        this(str, i, false);
    }

    public RxThreadFactory(String str, int i, boolean z) {
        this.f7653a = str;
        this.f7654b = i;
        this.f7655c = z;
    }
}
