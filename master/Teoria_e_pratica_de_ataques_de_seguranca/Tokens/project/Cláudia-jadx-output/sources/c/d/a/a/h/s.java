package c.d.a.a.h;

import android.content.Context;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import c.d.a.a.e.e.d;
/* loaded from: classes.dex */
public class s extends c.d.a.a.e.f.c<e0> {
    public final String A;
    public final s0<e0> B;

    public s(Context context, Looper looper, d.b bVar, d.c cVar, String str, c.d.a.a.e.f.u0 u0Var) {
        super(context, looper, 23, u0Var, bVar, cVar);
        this.B = new t(this);
        this.A = str;
    }

    @Override // c.d.a.a.e.f.h0
    public final String A() {
        return "com.google.android.gms.location.internal.IGoogleLocationManagerService";
    }

    @Override // c.d.a.a.e.f.h0
    public final /* synthetic */ IInterface a(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.location.internal.IGoogleLocationManagerService");
        return queryLocalInterface instanceof e0 ? (e0) queryLocalInterface : new f0(iBinder);
    }

    @Override // c.d.a.a.e.f.h0
    public final Bundle p() {
        Bundle bundle = new Bundle();
        bundle.putString("client_name", this.A);
        return bundle;
    }

    @Override // c.d.a.a.e.f.h0
    public final String z() {
        return "com.google.android.location.internal.GoogleLocationManagerService.START";
    }
}
