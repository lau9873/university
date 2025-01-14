package p136d.p153c.p160f0.p172g;

import java.util.concurrent.ThreadFactory;
import p136d.p153c.Scheduler;

/* renamed from: d.c.f0.g.c */
/* loaded from: classes.dex */
public final class NewThreadScheduler extends Scheduler {

    /* renamed from: c */
    public static final RxThreadFactory f7649c = new RxThreadFactory("RxNewThreadScheduler", Math.max(1, Math.min(10, Integer.getInteger("rx2.newthread-priority", 5).intValue())));

    /* renamed from: b */
    public final ThreadFactory f7650b;

    public NewThreadScheduler() {
        this(f7649c);
    }

    @Override // p136d.p153c.Scheduler
    /* renamed from: a */
    public Scheduler.AbstractC1733c mo3293a() {
        return new NewThreadWorker(this.f7650b);
    }

    public NewThreadScheduler(ThreadFactory threadFactory) {
        this.f7650b = threadFactory;
    }
}
