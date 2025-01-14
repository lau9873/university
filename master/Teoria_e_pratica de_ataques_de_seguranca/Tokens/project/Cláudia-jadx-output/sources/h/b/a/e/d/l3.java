package h.b.a.e.d;

import android.widget.Toast;
import h.b.a.e.d.k3;
import pt.card4b.backendbeacons.BackendListeners;
import pt.card4b.backendbeacons.DataModels;
/* compiled from: FaresFragment.java */
/* loaded from: classes.dex */
public class l3 implements BackendListeners.SendInvoiceEmailListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ k3.e f7252a;

    public l3(k3.e eVar) {
        this.f7252a = eVar;
    }

    @Override // pt.card4b.backendbeacons.BackendListeners.BaseRequestListener
    public void onError(DataModels.Error error) {
        Toast.makeText(k3.this.b0, 2131755261, 0).show();
    }

    @Override // pt.card4b.backendbeacons.BackendListeners.SendInvoiceEmailListener
    public void onSuccess() {
        Toast.makeText(k3.this.b0, 2131755263, 0).show();
    }
}
