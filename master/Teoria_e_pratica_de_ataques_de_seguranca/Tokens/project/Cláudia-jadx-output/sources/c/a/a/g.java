package c.a.a;

import android.annotation.TargetApi;
import android.net.TrafficStats;
import android.os.Build;
import android.os.Process;
import android.os.SystemClock;
import com.android.volley.VolleyError;
import java.util.concurrent.BlockingQueue;
/* compiled from: NetworkDispatcher.java */
/* loaded from: classes.dex */
public class g extends Thread {

    /* renamed from: a  reason: collision with root package name */
    public final BlockingQueue<i<?>> f2764a;

    /* renamed from: b  reason: collision with root package name */
    public final f f2765b;

    /* renamed from: c  reason: collision with root package name */
    public final a f2766c;

    /* renamed from: d  reason: collision with root package name */
    public final l f2767d;

    /* renamed from: e  reason: collision with root package name */
    public volatile boolean f2768e = false;

    public g(BlockingQueue<i<?>> blockingQueue, f fVar, a aVar, l lVar) {
        this.f2764a = blockingQueue;
        this.f2765b = fVar;
        this.f2766c = aVar;
        this.f2767d = lVar;
    }

    @TargetApi(14)
    public final void a(i<?> iVar) {
        if (Build.VERSION.SDK_INT >= 14) {
            TrafficStats.setThreadStatsTag(iVar.q());
        }
    }

    public void b() {
        this.f2768e = true;
        interrupt();
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        Process.setThreadPriority(10);
        while (true) {
            try {
                a();
            } catch (InterruptedException unused) {
                if (this.f2768e) {
                    Thread.currentThread().interrupt();
                    return;
                }
                n.c("Ignoring spurious interrupt of NetworkDispatcher thread; use quit() to terminate it", new Object[0]);
            }
        }
    }

    public final void a() {
        b(this.f2764a.take());
    }

    public void b(i<?> iVar) {
        long elapsedRealtime = SystemClock.elapsedRealtime();
        try {
            iVar.a("network-queue-take");
            if (iVar.t()) {
                iVar.b("network-discard-cancelled");
                iVar.v();
                return;
            }
            a(iVar);
            h a2 = this.f2765b.a(iVar);
            iVar.a("network-http-complete");
            if (a2.f2772d && iVar.s()) {
                iVar.b("not-modified");
                iVar.v();
                return;
            }
            k<?> a3 = iVar.a(a2);
            iVar.a("network-parse-complete");
            if (iVar.w() && a3.f2800b != null) {
                this.f2766c.a(iVar.f(), a3.f2800b);
                iVar.a("network-cache-written");
            }
            iVar.u();
            this.f2767d.a(iVar, a3);
            iVar.a(a3);
        } catch (VolleyError e2) {
            e2.a(SystemClock.elapsedRealtime() - elapsedRealtime);
            a(iVar, e2);
            iVar.v();
        } catch (Exception e3) {
            n.a(e3, "Unhandled exception %s", e3.toString());
            VolleyError volleyError = new VolleyError(e3);
            volleyError.a(SystemClock.elapsedRealtime() - elapsedRealtime);
            this.f2767d.a(iVar, volleyError);
            iVar.v();
        }
    }

    public final void a(i<?> iVar, VolleyError volleyError) {
        iVar.b(volleyError);
        this.f2767d.a(iVar, volleyError);
    }
}
