package p070c.p071a.p072a;

import android.annotation.TargetApi;
import android.net.TrafficStats;
import android.os.Build;
import android.os.Process;
import android.os.SystemClock;
import com.android.volley.VolleyError;
import java.util.concurrent.BlockingQueue;

/* renamed from: c.a.a.g */
/* loaded from: classes.dex */
public class NetworkDispatcher extends Thread {

    /* renamed from: a */
    public final BlockingQueue<Request<?>> f4554a;

    /* renamed from: b */
    public final Network f4555b;

    /* renamed from: c */
    public final InterfaceC0779a f4556c;

    /* renamed from: d */
    public final ResponseDelivery f4557d;

    /* renamed from: e */
    public volatile boolean f4558e = false;

    public NetworkDispatcher(BlockingQueue<Request<?>> blockingQueue, Network network, InterfaceC0779a interfaceC0779a, ResponseDelivery responseDelivery) {
        this.f4554a = blockingQueue;
        this.f4555b = network;
        this.f4556c = interfaceC0779a;
        this.f4557d = responseDelivery;
    }

    @TargetApi(14)
    /* renamed from: a */
    public final void m6226a(Request<?> request) {
        if (Build.VERSION.SDK_INT >= 14) {
            TrafficStats.setThreadStatsTag(request.m6195q());
        }
    }

    /* renamed from: b */
    public void m6224b() {
        this.f4558e = true;
        interrupt();
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        Process.setThreadPriority(10);
        while (true) {
            try {
                m6227a();
            } catch (InterruptedException unused) {
                if (this.f4558e) {
                    Thread.currentThread().interrupt();
                    return;
                }
                VolleyLog.m6167c("Ignoring spurious interrupt of NetworkDispatcher thread; use quit() to terminate it", new Object[0]);
            }
        }
    }

    /* renamed from: a */
    public final void m6227a() {
        m6223b(this.f4554a.take());
    }

    /* renamed from: b */
    public void m6223b(Request<?> request) {
        long elapsedRealtime = SystemClock.elapsedRealtime();
        try {
            request.m6211a("network-queue-take");
            if (request.m6192t()) {
                request.m6207b("network-discard-cancelled");
                request.m6190v();
                return;
            }
            m6226a(request);
            NetworkResponse mo6159a = this.f4555b.mo6159a(request);
            request.m6211a("network-http-complete");
            if (mo6159a.f4562d && request.m6193s()) {
                request.m6207b("not-modified");
                request.m6190v();
                return;
            }
            Response<?> mo6098a = request.mo6098a(mo6159a);
            request.m6211a("network-parse-complete");
            if (request.m6189w() && mo6098a.f4597b != null) {
                this.f4556c.mo6141a(request.m6204f(), mo6098a.f4597b);
                request.m6211a("network-cache-written");
            }
            request.m6191u();
            this.f4557d.mo6176a(request, mo6098a);
            request.m6214a(mo6098a);
        } catch (VolleyError e) {
            e.m4406a(SystemClock.elapsedRealtime() - elapsedRealtime);
            m6225a(request, e);
            request.m6190v();
        } catch (Exception e2) {
            VolleyLog.m6169a(e2, "Unhandled exception %s", e2.toString());
            VolleyError volleyError = new VolleyError(e2);
            volleyError.m4406a(SystemClock.elapsedRealtime() - elapsedRealtime);
            this.f4557d.mo6174a(request, volleyError);
            request.m6190v();
        }
    }

    /* renamed from: a */
    public final void m6225a(Request<?> request, VolleyError volleyError) {
        request.m6208b(volleyError);
        this.f4557d.mo6174a(request, volleyError);
    }
}
