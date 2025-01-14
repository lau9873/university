package d.c.f0.g;

import d.c.t;
import java.util.concurrent.ThreadFactory;
/* compiled from: NewThreadScheduler.java */
/* loaded from: classes.dex */
public final class c extends t {

    /* renamed from: c  reason: collision with root package name */
    public static final f f5313c = new f("RxNewThreadScheduler", Math.max(1, Math.min(10, Integer.getInteger("rx2.newthread-priority", 5).intValue())));

    /* renamed from: b  reason: collision with root package name */
    public final ThreadFactory f5314b;

    public c() {
        this(f5313c);
    }

    @Override // d.c.t
    public t.c a() {
        return new d(this.f5314b);
    }

    public c(ThreadFactory threadFactory) {
        this.f5314b = threadFactory;
    }
}
