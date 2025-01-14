package c.d.a.a.h;

import android.app.PendingIntent;
import com.google.android.gms.common.api.Status;
/* loaded from: classes.dex */
public final class o implements c.d.a.a.i.b {
    @Override // c.d.a.a.i.b
    public final c.d.a.a.e.e.e<Status> a(c.d.a.a.e.e.d dVar, long j, PendingIntent pendingIntent) {
        return dVar.a((c.d.a.a.e.e.d) new p(this, dVar, j, pendingIntent));
    }

    @Override // c.d.a.a.i.b
    public final c.d.a.a.e.e.e<Status> a(c.d.a.a.e.e.d dVar, PendingIntent pendingIntent) {
        return dVar.a((c.d.a.a.e.e.d) new q(this, dVar, pendingIntent));
    }
}
