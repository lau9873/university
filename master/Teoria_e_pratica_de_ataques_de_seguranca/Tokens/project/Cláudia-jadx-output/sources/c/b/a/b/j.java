package c.b.a.b;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;
/* compiled from: BackgroundManager.java */
/* loaded from: classes.dex */
public class j {

    /* renamed from: a  reason: collision with root package name */
    public final ScheduledExecutorService f2882a;

    /* renamed from: b  reason: collision with root package name */
    public final List<b> f2883b = new ArrayList();

    /* renamed from: c  reason: collision with root package name */
    public volatile boolean f2884c = true;

    /* renamed from: d  reason: collision with root package name */
    public final AtomicReference<ScheduledFuture<?>> f2885d = new AtomicReference<>();

    /* renamed from: e  reason: collision with root package name */
    public boolean f2886e = true;

    /* compiled from: BackgroundManager.java */
    /* loaded from: classes.dex */
    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            j.this.f2885d.set(null);
            j.this.a();
        }
    }

    /* compiled from: BackgroundManager.java */
    /* loaded from: classes.dex */
    public interface b {
        void a();
    }

    public j(ScheduledExecutorService scheduledExecutorService) {
        this.f2882a = scheduledExecutorService;
    }

    public void b() {
        if (!this.f2884c || this.f2886e) {
            return;
        }
        this.f2886e = true;
        try {
            this.f2885d.compareAndSet(null, this.f2882a.schedule(new a(), 5000L, TimeUnit.MILLISECONDS));
        } catch (RejectedExecutionException e2) {
            d.a.a.a.c.h().a("Answers", "Failed to schedule background detector", e2);
        }
    }

    public void c() {
        this.f2886e = false;
        ScheduledFuture<?> andSet = this.f2885d.getAndSet(null);
        if (andSet != null) {
            andSet.cancel(false);
        }
    }

    public void a(boolean z) {
        this.f2884c = z;
    }

    public final void a() {
        for (b bVar : this.f2883b) {
            bVar.a();
        }
    }

    public void a(b bVar) {
        this.f2883b.add(bVar);
    }
}
