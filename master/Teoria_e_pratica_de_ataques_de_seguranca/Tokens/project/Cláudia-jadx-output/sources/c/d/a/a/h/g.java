package c.d.a.a.h;

import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: classes.dex */
public final class g implements ThreadFactory {

    /* renamed from: a  reason: collision with root package name */
    public final String f3599a;

    /* renamed from: b  reason: collision with root package name */
    public final AtomicInteger f3600b;

    /* renamed from: c  reason: collision with root package name */
    public final ThreadFactory f3601c;

    public g(String str) {
        this(str, 0);
    }

    public g(String str, int i2) {
        this.f3600b = new AtomicInteger();
        this.f3601c = Executors.defaultThreadFactory();
        c.d.a.a.e.f.c0.a(str, (Object) "Name must not be null");
        this.f3599a = str;
    }

    @Override // java.util.concurrent.ThreadFactory
    public final Thread newThread(Runnable runnable) {
        Thread newThread = this.f3601c.newThread(new h(runnable, 0));
        String str = this.f3599a;
        int andIncrement = this.f3600b.getAndIncrement();
        StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 13);
        sb.append(str);
        sb.append("[");
        sb.append(andIncrement);
        sb.append("]");
        newThread.setName(sb.toString());
        return newThread;
    }
}
