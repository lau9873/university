package d.c.f0.g;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicLong;
/* compiled from: RxThreadFactory.java */
/* loaded from: classes.dex */
public final class f extends AtomicLong implements ThreadFactory {

    /* renamed from: a  reason: collision with root package name */
    public final String f5317a;

    /* renamed from: b  reason: collision with root package name */
    public final int f5318b;

    /* renamed from: c  reason: collision with root package name */
    public final boolean f5319c;

    /* compiled from: RxThreadFactory.java */
    /* loaded from: classes.dex */
    public static final class a extends Thread implements e {
        public a(Runnable runnable, String str) {
            super(runnable, str);
        }
    }

    public f(String str) {
        this(str, 5, false);
    }

    @Override // java.util.concurrent.ThreadFactory
    public Thread newThread(Runnable runnable) {
        String str = this.f5317a + '-' + incrementAndGet();
        Thread aVar = this.f5319c ? new a(runnable, str) : new Thread(runnable, str);
        aVar.setPriority(this.f5318b);
        aVar.setDaemon(true);
        return aVar;
    }

    @Override // java.util.concurrent.atomic.AtomicLong
    public String toString() {
        return "RxThreadFactory[" + this.f5317a + "]";
    }

    public f(String str, int i2) {
        this(str, i2, false);
    }

    public f(String str, int i2, boolean z) {
        this.f5317a = str;
        this.f5318b = i2;
        this.f5319c = z;
    }
}
