package h.b.a.e.d;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.design.widget.TextInputLayout;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.hbb20.CountryCodePicker;
import java.util.HashMap;
import java.util.List;
import pt.card4b.backendbeacons.BackEnd;
import pt.card4b.backendbeacons.BackendListeners;
import pt.card4b.backendbeacons.DataModels;
/* compiled from: RegisterSecondStepFragment.java */
/* loaded from: classes.dex */
public class b4 extends g3 {
    public TextInputLayout c0;
    public TextInputLayout d0;
    public TextInputLayout e0;
    public TextInputLayout f0;
    public TextInputLayout g0;
    public TextInputLayout h0;
    public h.b.a.c i0;
    public CountryCodePicker j0;
    public HashMap<String, DataModels.Country> k0 = new HashMap<>();

    /* compiled from: RegisterSecondStepFragment.java */
    /* loaded from: classes.dex */
    public class a implements BackendListeners.GetCountriesListener {
        public a() {
        }

        @Override // pt.card4b.backendbeacons.BackendListeners.BaseRequestListener
        public void onError(DataModels.Error error) {
            b4.this.k0 = new HashMap();
            b4.this.i0.a(String.format("%s: %s", b4.this.b0.getString(2131755195), error.getMessageToUser()), -1).m();
            BackEnd.addToLog(String.format("[%s] BackEnd.getCountries invoked onError() with messagae: %s", "RegisterSecondStepFragment.class", error.getMessageToUser()));
        }

        @Override // pt.card4b.backendbeacons.BackendListeners.GetCountriesListener
        public void onSuccess(List<DataModels.Country> list) {
            for (DataModels.Country country : list) {
                b4.this.k0.put(country.getCode(), country);
            }
        }
    }

    @Override // android.support.v4.app.Fragment
    public void c(Bundle bundle) {
        super.c(bundle);
        this.i0 = h.b.a.c.b(q());
    }

    public CountryCodePicker p0() {
        return this.j0;
    }

    @SuppressLint({"LongLogTag"})
    public DataModels.Country q0() {
        if (this.k0 == null) {
            Log.w("RegisterSecondStepFragment.class", "countriesMap object was not initialized, returning");
            return null;
        }
        String selectedCountryNameCode = this.j0.getSelectedCountryNameCode();
        if (this.k0.containsKey(selectedCountryNameCode)) {
            return this.k0.get(selectedCountryNameCode);
        }
        Log.e("RegisterSecondStepFragment.class", String.format("countriesMap does not contain key: %s", selectedCountryNameCode));
        return null;
    }

    public TextInputLayout r0() {
        return this.c0;
    }

    public TextInputLayout s0() {
        return this.e0;
    }

    public TextInputLayout t0() {
        return this.g0;
    }

    public TextInputLayout u0() {
        return this.f0;
    }

    public TextInputLayout v0() {
        return this.h0;
    }

    public TextInputLayout w0() {
        return this.d0;
    }

    public final void x0() {
        BackEnd.getCountries(new a());
    }

    @Override // android.support.v4.app.Fragment
    public View a(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(2131427389, viewGroup, false);
        this.c0 = (TextInputLayout) inflate.findViewById(2131231097);
        this.d0 = (TextInputLayout) inflate.findViewById(2131231122);
        this.e0 = (TextInputLayout) inflate.findViewById(2131231098);
        this.f0 = (TextInputLayout) inflate.findViewById(2131231108);
        this.g0 = (TextInputLayout) inflate.findViewById(2131231099);
        this.j0 = (CountryCodePicker) inflate.findViewById(2131230816);
        this.h0 = (TextInputLayout) inflate.findViewById(2131231113);
        x0();
        return inflate;
    }
}
