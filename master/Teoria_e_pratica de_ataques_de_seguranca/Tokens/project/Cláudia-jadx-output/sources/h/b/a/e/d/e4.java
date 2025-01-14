package h.b.a.e.d;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.preference.Preference;
import android.support.v7.widget.Toolbar;
import android.view.View;
import com.j256.ormlite.field.DatabaseFieldConfigLoader;
import pt.card4b.backendbeacons.BackEnd;
/* compiled from: SettingsFragment.java */
/* loaded from: classes.dex */
public class e4 extends a.b.h.f.g implements View.OnClickListener {
    public h.b.a.e.a.h j0;
    public h.b.a.c k0;
    public Context l0;

    @Override // a.b.h.f.g, android.support.v4.app.Fragment
    public void c(Bundle bundle) {
        super.c(bundle);
        this.k0 = h.b.a.c.b(this.l0);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        h.b.a.e.a.h hVar = this.j0;
        if (hVar != null) {
            hVar.a(this);
        }
    }

    @Override // a.b.h.f.g
    public void a(Bundle bundle, String str) {
        a(2131951631, str);
        a(DatabaseFieldConfigLoader.FIELD_NAME_VERSION).a("1.2.17.5952 (19:06 25/12/2021)");
        a("force_update_data").a(new Preference.e() { // from class: h.b.a.e.d.w1
            @Override // android.support.v7.preference.Preference.e
            public final boolean a(Preference preference) {
                return e4.this.c(preference);
            }
        });
    }

    public /* synthetic */ boolean c(Preference preference) {
        this.k0.a(this.l0.getString(2131755366), -1).m();
        BackEnd.syncConfigurationData(true, new d4(this));
        return true;
    }

    public void a(h.b.a.e.a.h hVar) {
        this.j0 = hVar;
    }

    @Override // a.b.h.f.g, android.support.v4.app.Fragment
    public void a(View view, Bundle bundle) {
        super.a(view, bundle);
        Toolbar toolbar = (Toolbar) view.findViewById(2131231152);
        toolbar.setNavigationIcon(2131165559);
        toolbar.setNavigationContentDescription(2131755050);
        toolbar.setNavigationOnClickListener(this);
    }

    @Override // android.support.v4.app.Fragment
    public void a(Context context) {
        super.a(context);
        this.l0 = context;
    }
}
