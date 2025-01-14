package p205h.p208b.p209a.p212e.p216d;

import android.content.Context;
import android.os.Bundle;
import android.support.p067v7.preference.Preference;
import android.support.p067v7.widget.Toolbar;
import android.view.View;
import com.hbb20.C1444R;
import com.j256.ormlite.field.DatabaseFieldConfigLoader;
import p000a.p006b.p049h.p057f.PreferenceFragmentCompat;
import p205h.p208b.p209a.Anda;
import p205h.p208b.p209a.p212e.p213a.NavigationActivity;
import pt.card4b.backendbeacons.BackEnd;

/* compiled from: SettingsFragment.java */
/* renamed from: h.b.a.e.d.e4 */
/* loaded from: classes.dex */
public class View$OnClickListenerC2417e4 extends PreferenceFragmentCompat implements View.OnClickListener {

    /* renamed from: j0 */
    public NavigationActivity f9815j0;

    /* renamed from: k0 */
    public Anda f9816k0;

    /* renamed from: l0 */
    public Context f9817l0;

    @Override // p000a.p006b.p049h.p057f.PreferenceFragmentCompat, android.support.p065v4.app.Fragment
    /* renamed from: c */
    public void mo728c(Bundle bundle) {
        super.mo728c(bundle);
        this.f9816k0 = Anda.m1443b(this.f9817l0);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        NavigationActivity navigationActivity = this.f9815j0;
        if (navigationActivity != null) {
            navigationActivity.mo35a(this);
        }
    }

    @Override // p000a.p006b.p049h.p057f.PreferenceFragmentCompat
    /* renamed from: a */
    public void mo1171a(Bundle bundle, String str) {
        m8875a(C1444R.xml.prefs_app, str);
        mo7270a(DatabaseFieldConfigLoader.FIELD_NAME_VERSION).mo7241a("1.2.17.5952 (19:06 25/12/2021)");
        mo7270a("force_update_data").m7246a(new Preference.InterfaceC0665e() { // from class: h.b.a.e.d.w1
            @Override // android.support.p067v7.preference.Preference.InterfaceC0665e
            /* renamed from: a */
            public final boolean mo764a(Preference preference) {
                return View$OnClickListenerC2417e4.this.m1167c(preference);
            }
        });
    }

    /* renamed from: c */
    public /* synthetic */ boolean m1167c(Preference preference) {
        this.f9816k0.m1447a(this.f9817l0.getString(C1444R.string.updating_app_data), -1).mo7619m();
        BackEnd.syncConfigurationData(true, new SettingsFragment(this));
        return true;
    }

    /* renamed from: a */
    public void m1170a(NavigationActivity navigationActivity) {
        this.f9815j0 = navigationActivity;
    }

    @Override // p000a.p006b.p049h.p057f.PreferenceFragmentCompat, android.support.p065v4.app.Fragment
    /* renamed from: a */
    public void mo715a(View view, Bundle bundle) {
        super.mo715a(view, bundle);
        Toolbar toolbar = (Toolbar) view.findViewById(C1444R.C1446id.toolbar);
        toolbar.setNavigationIcon(C1444R.C1445drawable.ic_arrow_back_white_24dp);
        toolbar.setNavigationContentDescription(C1444R.string.action_back);
        toolbar.setNavigationOnClickListener(this);
    }

    @Override // android.support.p065v4.app.Fragment
    /* renamed from: a */
    public void mo778a(Context context) {
        super.mo778a(context);
        this.f9817l0 = context;
    }
}
