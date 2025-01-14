package h.b.a.e.d;

import android.content.Context;
import pt.card4b.backendbeacons.BackendListeners;
import pt.card4b.backendbeacons.DataModels;
/* compiled from: SettingsFragment.java */
/* loaded from: classes.dex */
public class d4 implements BackendListeners.SyncConfigurationDataRequestListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ e4 f7129a;

    public d4(e4 e4Var) {
        this.f7129a = e4Var;
    }

    @Override // pt.card4b.backendbeacons.BackendListeners.BaseRequestListener
    public void onError(DataModels.Error error) {
        h.b.a.c cVar;
        Context context;
        cVar = this.f7129a.k0;
        context = this.f7129a.l0;
        cVar.a(String.format("%s: %s", context.getString(2131755195), error.getMessageToUser()), -1).m();
    }

    @Override // pt.card4b.backendbeacons.BackendListeners.SyncConfigurationDataRequestListener
    public void onSuccess() {
        h.b.a.c cVar;
        Context context;
        cVar = this.f7129a.k0;
        context = this.f7129a.l0;
        cVar.a(context.getString(2131755066), -1).m();
    }
}
