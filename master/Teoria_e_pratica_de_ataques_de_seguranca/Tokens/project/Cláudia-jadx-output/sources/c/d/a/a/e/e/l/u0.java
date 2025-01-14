package c.d.a.a.e.e.l;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
/* loaded from: classes.dex */
public final class u0 extends BroadcastReceiver {

    /* renamed from: a  reason: collision with root package name */
    public Context f3416a;

    /* renamed from: b  reason: collision with root package name */
    public final v0 f3417b;

    public u0(v0 v0Var) {
        this.f3417b = v0Var;
    }

    public final synchronized void a() {
        if (this.f3416a != null) {
            this.f3416a.unregisterReceiver(this);
        }
        this.f3416a = null;
    }

    public final void a(Context context) {
        this.f3416a = context;
    }

    @Override // android.content.BroadcastReceiver
    public final void onReceive(Context context, Intent intent) {
        Uri data = intent.getData();
        if ("com.google.android.gms".equals(data != null ? data.getSchemeSpecificPart() : null)) {
            this.f3417b.a();
            a();
        }
    }
}
