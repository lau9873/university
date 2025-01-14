package c.b.a.b;

import android.content.Context;
import c.b.a.b.w;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;
/* compiled from: EnabledSessionAnalyticsManagerStrategy.java */
/* loaded from: classes.dex */
public class m implements v {

    /* renamed from: a  reason: collision with root package name */
    public final d.a.a.a.h f2889a;

    /* renamed from: b  reason: collision with root package name */
    public final d.a.a.a.m.e.d f2890b;

    /* renamed from: c  reason: collision with root package name */
    public final Context f2891c;

    /* renamed from: d  reason: collision with root package name */
    public final s f2892d;

    /* renamed from: e  reason: collision with root package name */
    public final ScheduledExecutorService f2893e;

    /* renamed from: g  reason: collision with root package name */
    public final x f2895g;

    /* renamed from: h  reason: collision with root package name */
    public d.a.a.a.m.d.f f2896h;

    /* renamed from: f  reason: collision with root package name */
    public final AtomicReference<ScheduledFuture<?>> f2894f = new AtomicReference<>();

    /* renamed from: i  reason: collision with root package name */
    public d.a.a.a.m.b.g f2897i = new d.a.a.a.m.b.g();
    public n j = new o();
    public boolean k = true;
    public boolean l = true;
    public volatile int m = -1;

    public m(d.a.a.a.h hVar, Context context, ScheduledExecutorService scheduledExecutorService, s sVar, d.a.a.a.m.e.d dVar, x xVar) {
        this.f2889a = hVar;
        this.f2891c = context;
        this.f2893e = scheduledExecutorService;
        this.f2892d = sVar;
        this.f2890b = dVar;
        this.f2895g = xVar;
    }

    @Override // c.b.a.b.v
    public void a(d.a.a.a.m.g.b bVar, String str) {
        this.f2896h = i.a(new t(this.f2889a, str, bVar.f4395a, this.f2890b, this.f2897i.c(this.f2891c)));
        this.f2892d.a(bVar);
        this.k = bVar.f4399e;
        d.a.a.a.k h2 = d.a.a.a.c.h();
        StringBuilder sb = new StringBuilder();
        sb.append("Custom event tracking ");
        sb.append(this.k ? "enabled" : "disabled");
        h2.e("Answers", sb.toString());
        this.l = bVar.f4400f;
        d.a.a.a.k h3 = d.a.a.a.c.h();
        StringBuilder sb2 = new StringBuilder();
        sb2.append("Predefined event tracking ");
        sb2.append(this.l ? "enabled" : "disabled");
        h3.e("Answers", sb2.toString());
        if (bVar.f4402h > 1) {
            d.a.a.a.c.h().e("Answers", "Event sampling enabled");
            this.j = new r(bVar.f4402h);
        }
        this.m = bVar.f4396b;
        a(0L, this.m);
    }

    @Override // d.a.a.a.m.d.e
    public boolean b() {
        try {
            return this.f2892d.g();
        } catch (IOException e2) {
            d.a.a.a.m.b.i.a(this.f2891c, "Failed to roll file over.", e2);
            return false;
        }
    }

    @Override // d.a.a.a.m.d.e
    public void c() {
        if (this.f2894f.get() != null) {
            d.a.a.a.m.b.i.c(this.f2891c, "Cancelling time-based rollover because no events are currently being generated.");
            this.f2894f.get().cancel(false);
            this.f2894f.set(null);
        }
    }

    @Override // c.b.a.b.v
    public void d() {
        this.f2892d.a();
    }

    public void e() {
        if (this.m != -1) {
            a(this.m, this.m);
        }
    }

    @Override // c.b.a.b.v
    public void a(w.b bVar) {
        w a2 = bVar.a(this.f2895g);
        if (!this.k && w.c.CUSTOM.equals(a2.f2914c)) {
            d.a.a.a.k h2 = d.a.a.a.c.h();
            h2.e("Answers", "Custom events tracking disabled - skipping event: " + a2);
        } else if (!this.l && w.c.PREDEFINED.equals(a2.f2914c)) {
            d.a.a.a.k h3 = d.a.a.a.c.h();
            h3.e("Answers", "Predefined events tracking disabled - skipping event: " + a2);
        } else if (this.j.a(a2)) {
            d.a.a.a.k h4 = d.a.a.a.c.h();
            h4.e("Answers", "Skipping filtered event: " + a2);
        } else {
            try {
                this.f2892d.a((s) a2);
            } catch (IOException e2) {
                d.a.a.a.k h5 = d.a.a.a.c.h();
                h5.c("Answers", "Failed to write event: " + a2, e2);
            }
            e();
        }
    }

    @Override // c.b.a.b.v
    public void a() {
        if (this.f2896h == null) {
            d.a.a.a.m.b.i.c(this.f2891c, "skipping files send because we don't yet know the target endpoint");
            return;
        }
        d.a.a.a.m.b.i.c(this.f2891c, "Sending all files");
        List<File> d2 = this.f2892d.d();
        int i2 = 0;
        while (d2.size() > 0) {
            try {
                d.a.a.a.m.b.i.c(this.f2891c, String.format(Locale.US, "attempt to send batch of %d files", Integer.valueOf(d2.size())));
                boolean a2 = this.f2896h.a(d2);
                if (a2) {
                    i2 += d2.size();
                    this.f2892d.a(d2);
                }
                if (!a2) {
                    break;
                }
                d2 = this.f2892d.d();
            } catch (Exception e2) {
                Context context = this.f2891c;
                d.a.a.a.m.b.i.a(context, "Failed to send batch of analytics files to server: " + e2.getMessage(), e2);
            }
        }
        if (i2 == 0) {
            this.f2892d.b();
        }
    }

    public void a(long j, long j2) {
        if (this.f2894f.get() == null) {
            d.a.a.a.m.d.i iVar = new d.a.a.a.m.d.i(this.f2891c, this);
            Context context = this.f2891c;
            d.a.a.a.m.b.i.c(context, "Scheduling time based file roll over every " + j2 + " seconds");
            try {
                this.f2894f.set(this.f2893e.scheduleAtFixedRate(iVar, j, j2, TimeUnit.SECONDS));
            } catch (RejectedExecutionException e2) {
                d.a.a.a.m.b.i.a(this.f2891c, "Failed to schedule time based file roll over", e2);
            }
        }
    }
}
