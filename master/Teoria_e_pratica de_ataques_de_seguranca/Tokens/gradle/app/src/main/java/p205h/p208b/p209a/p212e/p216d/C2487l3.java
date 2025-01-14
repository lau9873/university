package p205h.p208b.p209a.p212e.p216d;

import android.widget.Toast;
import com.hbb20.C1444R;
import p205h.p208b.p209a.p212e.p216d.FaresFragment;
import pt.card4b.backendbeacons.BackendListeners;
import pt.card4b.backendbeacons.DataModels;

/* compiled from: FaresFragment.java */
/* renamed from: h.b.a.e.d.l3 */
/* loaded from: classes.dex */
public class C2487l3 implements BackendListeners.SendInvoiceEmailListener {

    /* renamed from: a */
    public final /* synthetic */ FaresFragment.View$OnClickListenerC2478e f10050a;

    public C2487l3(FaresFragment.View$OnClickListenerC2478e view$OnClickListenerC2478e) {
        this.f10050a = view$OnClickListenerC2478e;
    }

    @Override // pt.card4b.backendbeacons.BackendListeners.BaseRequestListener
    public void onError(DataModels.Error error) {
        Toast.makeText(FaresFragment.this.f9860b0, (int) C1444R.string.invoice_error, 0).show();
    }

    @Override // pt.card4b.backendbeacons.BackendListeners.SendInvoiceEmailListener
    public void onSuccess() {
        Toast.makeText(FaresFragment.this.f9860b0, (int) C1444R.string.invoice_success, 0).show();
    }
}
