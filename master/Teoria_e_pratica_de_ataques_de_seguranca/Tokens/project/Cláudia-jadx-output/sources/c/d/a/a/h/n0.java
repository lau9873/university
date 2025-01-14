package c.d.a.a.h;

import android.app.PendingIntent;
import android.content.Context;
import android.location.Location;
import android.os.Looper;
import android.util.Log;
import c.d.a.a.e.e.d;
/* loaded from: classes.dex */
public final class n0 extends s {
    public final g0 C;

    public n0(Context context, Looper looper, d.b bVar, d.c cVar, String str) {
        this(context, looper, bVar, cVar, str, c.d.a.a.e.f.u0.a(context));
    }

    public n0(Context context, Looper looper, d.b bVar, d.c cVar, String str, c.d.a.a.e.f.u0 u0Var) {
        super(context, looper, bVar, cVar, str, u0Var);
        this.C = new g0(context, this.B);
    }

    public final Location B() {
        return this.C.a();
    }

    @Override // c.d.a.a.e.f.h0, c.d.a.a.e.e.a.f
    public final void a() {
        synchronized (this.C) {
            if (c()) {
                try {
                    this.C.b();
                    this.C.c();
                } catch (Exception e2) {
                    Log.e("LocationClientImpl", "Client disconnected before listeners could be cleaned up", e2);
                }
            }
            super.a();
        }
    }

    public final void a(long j, PendingIntent pendingIntent) {
        u();
        c.d.a.a.e.f.c0.a(pendingIntent);
        c.d.a.a.e.f.c0.a(j >= 0, "detectionIntervalMillis must be >= 0");
        ((e0) v()).a(j, true, pendingIntent);
    }

    public final void a(PendingIntent pendingIntent) {
        u();
        c.d.a.a.e.f.c0.a(pendingIntent);
        ((e0) v()).a(pendingIntent);
    }
}
