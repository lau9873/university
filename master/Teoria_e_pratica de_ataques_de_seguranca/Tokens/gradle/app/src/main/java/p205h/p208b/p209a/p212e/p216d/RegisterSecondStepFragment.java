package p205h.p208b.p209a.p212e.p216d;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.design.widget.TextInputLayout;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.hbb20.C1444R;
import com.hbb20.CountryCodePicker;
import java.util.HashMap;
import java.util.List;
import p205h.p208b.p209a.Anda;
import pt.card4b.backendbeacons.BackEnd;
import pt.card4b.backendbeacons.BackendListeners;
import pt.card4b.backendbeacons.DataModels;

/* renamed from: h.b.a.e.d.b4 */
/* loaded from: classes.dex */
public class RegisterSecondStepFragment extends AbstractFragment {

    /* renamed from: c0 */
    public TextInputLayout f9768c0;

    /* renamed from: d0 */
    public TextInputLayout f9769d0;

    /* renamed from: e0 */
    public TextInputLayout f9770e0;

    /* renamed from: f0 */
    public TextInputLayout f9771f0;

    /* renamed from: g0 */
    public TextInputLayout f9772g0;

    /* renamed from: h0 */
    public TextInputLayout f9773h0;

    /* renamed from: i0 */
    public Anda f9774i0;

    /* renamed from: j0 */
    public CountryCodePicker f9775j0;

    /* renamed from: k0 */
    public HashMap<String, DataModels.Country> f9776k0 = new HashMap<>();

    /* compiled from: RegisterSecondStepFragment.java */
    /* renamed from: h.b.a.e.d.b4$a */
    /* loaded from: classes.dex */
    public class C2398a implements BackendListeners.GetCountriesListener {
        public C2398a() {
        }

        @Override // pt.card4b.backendbeacons.BackendListeners.BaseRequestListener
        public void onError(DataModels.Error error) {
            RegisterSecondStepFragment.this.f9776k0 = new HashMap();
            RegisterSecondStepFragment.this.f9774i0.m1447a(String.format("%s: %s", RegisterSecondStepFragment.this.f9860b0.getString(C1444R.string.error), error.getMessageToUser()), -1).mo7619m();
            BackEnd.addToLog(String.format("[%s] BackEnd.getCountries invoked onError() with messagae: %s", "RegisterSecondStepFragment.class", error.getMessageToUser()));
        }

        @Override // pt.card4b.backendbeacons.BackendListeners.GetCountriesListener
        public void onSuccess(List<DataModels.Country> list) {
            for (DataModels.Country country : list) {
                RegisterSecondStepFragment.this.f9776k0.put(country.getCode(), country);
            }
        }
    }

    @Override // android.support.p065v4.app.Fragment
    /* renamed from: c */
    public void mo728c(Bundle bundle) {
        super.mo728c(bundle);
        this.f9774i0 = Anda.m1443b(m7452q());
    }

    /* renamed from: p0 */
    public CountryCodePicker m1188p0() {
        return this.f9775j0;
    }

    @SuppressLint({"LongLogTag"})
    /* renamed from: q0 */
    public DataModels.Country m1187q0() {
        if (this.f9776k0 == null) {
            Log.w("RegisterSecondStepFragment.class", "countriesMap object was not initialized, returning");
            return null;
        }
        String selectedCountryNameCode = this.f9775j0.getSelectedCountryNameCode();
        if (this.f9776k0.containsKey(selectedCountryNameCode)) {
            return this.f9776k0.get(selectedCountryNameCode);
        }
        Log.e("RegisterSecondStepFragment.class", String.format("countriesMap does not contain key: %s", selectedCountryNameCode));
        return null;
    }

    /* renamed from: r0 */
    public TextInputLayout m1186r0() {
        return this.f9768c0;
    }

    /* renamed from: s0 */
    public TextInputLayout m1185s0() {
        return this.f9770e0;
    }

    /* renamed from: t0 */
    public TextInputLayout m1184t0() {
        return this.f9772g0;
    }

    /* renamed from: u0 */
    public TextInputLayout m1183u0() {
        return this.f9771f0;
    }

    /* renamed from: v0 */
    public TextInputLayout m1182v0() {
        return this.f9773h0;
    }

    /* renamed from: w0 */
    public TextInputLayout m1181w0() {
        return this.f9769d0;
    }

    /* renamed from: x0 */
    public final void m1180x0() {
        BackEnd.getCountries(new C2398a());
    }

    @Override // android.support.p065v4.app.Fragment
    /* renamed from: a */
    public View mo717a(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(C1444R.layout.fragment_register_secondstep, viewGroup, false);
        this.f9768c0 = (TextInputLayout) inflate.findViewById(C1444R.C1446id.tAddress);
        this.f9769d0 = (TextInputLayout) inflate.findViewById(C1444R.C1446id.tPostalCode);
        this.f9770e0 = (TextInputLayout) inflate.findViewById(C1444R.C1446id.tBillingName);
        this.f9771f0 = (TextInputLayout) inflate.findViewById(C1444R.C1446id.tFiscalNumber);
        this.f9772g0 = (TextInputLayout) inflate.findViewById(C1444R.C1446id.tCity);
        this.f9775j0 = (CountryCodePicker) inflate.findViewById(C1444R.C1446id.billingCountry);
        this.f9773h0 = (TextInputLayout) inflate.findViewById(C1444R.C1446id.tNotifyEmail);
        m1180x0();
        return inflate;
    }
}
