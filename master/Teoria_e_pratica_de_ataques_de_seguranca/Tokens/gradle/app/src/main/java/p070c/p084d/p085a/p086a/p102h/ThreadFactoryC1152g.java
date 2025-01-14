package p070c.p084d.p085a.p086a.p102h;

import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;
import p070c.p084d.p085a.p086a.p093e.p096f.C1049c0;

/* renamed from: c.d.a.a.h.g */
/* loaded from: classes.dex */
public final class ThreadFactoryC1152g implements ThreadFactory {

    /* renamed from: a */
    public final String f5532a;

    /* renamed from: b */
    public final AtomicInteger f5533b;

    /* renamed from: c */
    public final ThreadFactory f5534c;

    public ThreadFactoryC1152g(String str) {
        this(str, 0);
    }

    public ThreadFactoryC1152g(String str, int i) {
        this.f5533b = new AtomicInteger();
        this.f5534c = Executors.defaultThreadFactory();
        C1049c0.m5293a(str, (Object) "Name must not be null");
        this.f5532a = str;
    }

    @Override // java.util.concurrent.ThreadFactory
    public final Thread newThread(Runnable runnable) {
        Thread newThread = this.f5534c.newThread(new RunnableC1155h(runnable, 0));
        String str = this.f5532a;
        int andIncrement = this.f5533b.getAndIncrement();
        StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 13);
        sb.append(str);
        sb.append("[");
        sb.append(andIncrement);
        sb.append("]");
        newThread.setName(sb.toString());
        return newThread;
    }
}
