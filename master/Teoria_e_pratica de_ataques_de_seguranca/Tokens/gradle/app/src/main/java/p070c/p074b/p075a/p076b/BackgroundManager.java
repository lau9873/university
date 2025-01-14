package p070c.p074b.p075a.p076b;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;
import p136d.p137a.p138a.p139a.Fabric;

/* renamed from: c.b.a.b.j */
/* loaded from: classes.dex */
public class BackgroundManager {

    /* renamed from: a */
    public final ScheduledExecutorService f4683a;

    /* renamed from: b */
    public final List<InterfaceC0806b> f4684b = new ArrayList();

    /* renamed from: c */
    public volatile boolean f4685c = true;

    /* renamed from: d */
    public final AtomicReference<ScheduledFuture<?>> f4686d = new AtomicReference<>();

    /* renamed from: e */
    public boolean f4687e = true;

    /* compiled from: BackgroundManager.java */
    /* renamed from: c.b.a.b.j$a */
    /* loaded from: classes.dex */
    public class RunnableC0805a implements Runnable {
        public RunnableC0805a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            BackgroundManager.this.f4686d.set(null);
            BackgroundManager.this.m6043a();
        }
    }

    /* compiled from: BackgroundManager.java */
    /* renamed from: c.b.a.b.j$b */
    /* loaded from: classes.dex */
    public interface InterfaceC0806b {
        /* renamed from: a */
        void mo6028a();
    }

    public BackgroundManager(ScheduledExecutorService scheduledExecutorService) {
        this.f4683a = scheduledExecutorService;
    }

    /* renamed from: b */
    public void m6039b() {
        if (!this.f4685c || this.f4687e) {
            return;
        }
        this.f4687e = true;
        try {
            this.f4686d.compareAndSet(null, this.f4683a.schedule(new RunnableC0805a(), 5000L, TimeUnit.MILLISECONDS));
        } catch (RejectedExecutionException e) {
            Fabric.m4197h().mo4163a("Answers", "Failed to schedule background detector", e);
        }
    }

    /* renamed from: c */
    public void m6038c() {
        this.f4687e = false;
        ScheduledFuture<?> andSet = this.f4686d.getAndSet(null);
        if (andSet != null) {
            andSet.cancel(false);
        }
    }

    /* renamed from: a */
    public void m6040a(boolean z) {
        this.f4685c = z;
    }

    /* renamed from: a */
    public final void m6043a() {
        for (InterfaceC0806b interfaceC0806b : this.f4684b) {
            interfaceC0806b.mo6028a();
        }
    }

    /* renamed from: a */
    public void m6042a(InterfaceC0806b interfaceC0806b) {
        this.f4684b.add(interfaceC0806b);
    }
}
