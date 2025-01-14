package c.d.a.a.h;

import android.app.PendingIntent;
import com.google.android.gms.common.api.Status;
/* loaded from: classes.dex */
public final class p extends r {
    public /* synthetic */ long s;
    public /* synthetic */ PendingIntent t;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public p(o oVar, c.d.a.a.e.e.d dVar, long j, PendingIntent pendingIntent) {
        super(dVar);
        this.s = j;
        this.t = pendingIntent;
    }

    @Override // c.d.a.a.e.e.l.l2
    public final /* synthetic */ void a(n0 n0Var) {
        n0Var.a(this.s, this.t);
        a((p) Status.f4067e);
    }
}
