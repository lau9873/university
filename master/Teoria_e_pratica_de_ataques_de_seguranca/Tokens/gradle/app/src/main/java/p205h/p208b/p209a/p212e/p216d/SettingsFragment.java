package p205h.p208b.p209a.p212e.p216d;

import android.content.Context;
import com.hbb20.C1444R;
import p205h.p208b.p209a.Anda;
import pt.card4b.backendbeacons.BackendListeners;
import pt.card4b.backendbeacons.DataModels;

/* renamed from: h.b.a.e.d.d4 */
/* loaded from: classes.dex */
public class SettingsFragment implements BackendListeners.SyncConfigurationDataRequestListener {

    /* renamed from: a */
    public final /* synthetic */ View$OnClickListenerC2417e4 f9808a;

    public SettingsFragment(View$OnClickListenerC2417e4 view$OnClickListenerC2417e4) {
        this.f9808a = view$OnClickListenerC2417e4;
    }

    @Override // pt.card4b.backendbeacons.BackendListeners.BaseRequestListener
    public void onError(DataModels.Error error) {
        Anda anda;
        Context context;
        anda = this.f9808a.f9816k0;
        context = this.f9808a.f9817l0;
        anda.m1447a(String.format("%s: %s", context.getString(C1444R.string.error), error.getMessageToUser()), -1).mo7619m();
    }

    @Override // pt.card4b.backendbeacons.BackendListeners.SyncConfigurationDataRequestListener
    public void onSuccess() {
        Anda anda;
        Context context;
        anda = this.f9808a.f9816k0;
        context = this.f9808a.f9817l0;
        anda.m1447a(context.getString(C1444R.string.app_data_updated), -1).mo7619m();
    }
}
