package h.b.a.e.d;

import a.b.h.a.c;
import android.annotation.SuppressLint;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.pm.PackageInfo;
import android.location.Location;
import android.os.Build;
import android.os.Bundle;
import android.text.format.DateFormat;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import java.io.IOException;
import org.json.JSONException;
import org.json.JSONObject;
import pt.card4b.backendbeacons.BackEnd;
import pt.card4b.backendbeacons.BackendListeners;
import pt.card4b.backendbeacons.DataModels;
/* compiled from: ReportDialogFragment.java */
/* loaded from: classes.dex */
public class c4 extends a.b.g.a.f {
    public b i0;
    public RadioButton j0;
    public RadioButton k0;
    public CheckBox l0;
    public EditText m0;
    public c.d.a.a.i.e n0;
    public Location o0 = null;
    public a.b.g.a.g p0;
    public Context q0;
    public View r0;

    /* compiled from: ReportDialogFragment.java */
    /* loaded from: classes.dex */
    public static class b {

        /* renamed from: a  reason: collision with root package name */
        public final Context f7118a;

        /* compiled from: ReportDialogFragment.java */
        /* loaded from: classes.dex */
        public class a implements BackendListeners.SendReportListener {

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ h.b.a.c f7119a;

            public a(h.b.a.c cVar) {
                this.f7119a = cVar;
            }

            @Override // pt.card4b.backendbeacons.BackendListeners.BaseRequestListener
            public void onError(DataModels.Error error) {
                this.f7119a.a(String.format("%s: %s", 2131755195, error.getMessageToUser()), -1).m();
            }

            @Override // pt.card4b.backendbeacons.BackendListeners.SendReportListener
            public void onSuccess() {
                this.f7119a.a(b.this.f7118a.getString(2131755327), 0).m();
            }
        }

        public final void b(boolean z, boolean z2, boolean z3, Location location, String str) {
            h.b.a.c b2 = h.b.a.c.b(this.f7118a);
            JSONObject jSONObject = new JSONObject();
            JSONObject jSONObject2 = new JSONObject();
            if (b2.o().a()) {
                jSONObject2.put("username", b2.o().b().b());
            } else {
                jSONObject2.put("username", (Object) null);
            }
            jSONObject.put("session", jSONObject2);
            JSONObject jSONObject3 = new JSONObject();
            if (b2.A()) {
                h.b.a.d.w b3 = b2.m().b();
                h.b.a.d.p b4 = b3.b();
                if (b4 != null) {
                    jSONObject3.put("operator", b4.a());
                } else {
                    jSONObject3.put("operator", (Object) null);
                }
                JSONObject jSONObject4 = new JSONObject();
                jSONObject4.put("time", DateFormat.format("yyyy-MM-dd HH:mm:ss ZZZZ", b3.c().a()).toString());
                jSONObject4.put("stop", b3.c().d().c());
                JSONObject jSONObject5 = new JSONObject();
                jSONObject5.put("time", DateFormat.format("yyyy-MM-dd HH:mm:ss ZZZZ", b3.f().a()).toString());
                jSONObject5.put("stop", b3.f().d().c());
                jSONObject3.put("stopCount", b3.l());
                jSONObject3.put("vehicleType", b3.i());
            }
            jSONObject.put("trip", jSONObject3);
            JSONObject jSONObject6 = new JSONObject();
            jSONObject6.put("branch", Build.BRAND);
            jSONObject6.put("model", Build.MODEL);
            jSONObject6.put("android", Build.VERSION.SDK_INT);
            try {
                PackageInfo packageInfo = this.f7118a.getPackageManager().getPackageInfo(this.f7118a.getPackageName(), 0);
                jSONObject6.put("app", packageInfo.versionName + " (" + packageInfo.versionCode + ")");
            } catch (Exception e2) {
                e2.printStackTrace();
                jSONObject6.put("app", "unknown");
            }
            jSONObject6.put("bluetooth", b2.r() ? "enabled" : "disabled");
            jSONObject6.put("location", b2.y() ? "enabled" : "disabled");
            jSONObject6.put("nfc", b2.z() ? "enabled" : "disabled");
            jSONObject6.put("locale", b2.i().getLanguage());
            jSONObject.put("device", jSONObject6);
            jSONObject.put("description", str);
            JSONObject jSONObject7 = new JSONObject();
            jSONObject7.put("rightNow", z);
            jSONObject7.put("past", z2);
            if (z3) {
                JSONObject jSONObject8 = new JSONObject();
                jSONObject8.put("success", location != null);
                if (location != null) {
                    jSONObject8.put("latitude", location.getLatitude());
                    jSONObject8.put("longitude", location.getLongitude());
                }
                jSONObject7.put("location", jSONObject8);
            }
            jSONObject.put("options", jSONObject7);
            BackEnd.sendLogReport(jSONObject.toString(), new a(b2));
        }

        public b(Context context, View view) {
            this.f7118a = context;
        }

        public final void a(boolean z, boolean z2, boolean z3, Location location, String str) {
            try {
                b(z, z2, z3, location, str);
            } catch (IOException | JSONException e2) {
                e2.printStackTrace();
                c.b.a.a.a((Throwable) e2);
            }
        }
    }

    @Override // a.b.g.a.f, android.support.v4.app.Fragment
    @SuppressLint({"LongLogTag"})
    public void X() {
        super.X();
        Log.i("ReportDialogFragment.class", "ReportDialogFragment: onDetach was called");
        this.p0 = null;
        this.q0 = null;
    }

    @Override // a.b.g.a.f, android.support.v4.app.Fragment
    @SuppressLint({"LongLogTag"})
    public void a(Context context) {
        super.a(context);
        this.q0 = context;
        this.p0 = j();
    }

    public void b(View view) {
        this.r0 = view;
    }

    @Override // a.b.g.a.f
    public Dialog n(Bundle bundle) {
        l(false);
        i(true);
        View inflate = j().getLayoutInflater().inflate(2131427373, (ViewGroup) null);
        this.j0 = (RadioButton) inflate.findViewById(2131231018);
        this.k0 = (RadioButton) inflate.findViewById(2131230992);
        this.l0 = (CheckBox) inflate.findViewById(2131231169);
        this.m0 = (EditText) inflate.findViewById(2131230855);
        this.n0 = c.d.a.a.i.g.a(this.q0);
        if (a.b.g.b.b.a(this.q0, "android.permission.ACCESS_FINE_LOCATION") != 0 && a.b.g.b.b.a(this.q0, "android.permission.ACCESS_COARSE_LOCATION") != 0) {
            this.l0.setEnabled(false);
            a(new String[]{"android.permission.ACCESS_COARSE_LOCATION", "android.permission.ACCESS_FINE_LOCATION"}, 1);
        }
        o0();
        this.i0 = new b(this.q0, this.r0);
        c.a aVar = new c.a(this.q0);
        aVar.b(2131755055);
        aVar.b(inflate);
        aVar.b(2131755311, new DialogInterface.OnClickListener() { // from class: h.b.a.e.d.v1
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i2) {
                c4.this.a(dialogInterface, i2);
            }
        });
        aVar.a(17039360, (DialogInterface.OnClickListener) null);
        return aVar.a();
    }

    @SuppressLint({"LongLogTag"})
    public final void o0() {
        if (this.p0 == null) {
            BackEnd.addToLog(String.format("[%s] activity is null", "ReportDialogFragment.class"));
        } else if (a.b.g.b.b.a(this.q0, "android.permission.ACCESS_FINE_LOCATION") == 0 || a.b.g.b.b.a(this.q0, "android.permission.ACCESS_COARSE_LOCATION") == 0) {
            this.n0.f().a(this.p0, new c.d.a.a.j.b() { // from class: h.b.a.e.d.u1
                @Override // c.d.a.a.j.b
                public final void b(Object obj) {
                    c4.this.a((Location) obj);
                }
            });
        }
    }

    public /* synthetic */ void a(Location location) {
        Log.i("ReportDialogFragment.class", "ReportDialogFragment: getLocation called with onSuccess");
        if (location != null) {
            this.o0 = location;
            if (this.l0.isEnabled()) {
                return;
            }
            this.l0.setEnabled(true);
        }
    }

    public /* synthetic */ void a(DialogInterface dialogInterface, int i2) {
        b bVar = this.i0;
        if (bVar != null) {
            bVar.a(this.j0.isChecked(), this.k0.isChecked(), this.l0.isChecked(), this.o0, this.m0.getText().toString());
        }
    }

    @Override // android.support.v4.app.Fragment
    public void a(int i2, String[] strArr, int[] iArr) {
        if (i2 == 1) {
            if (strArr.length == 2 && iArr[0] == 0 && iArr[1] == 0) {
                o0();
                return;
            }
            return;
        }
        super.a(i2, strArr, iArr);
    }
}
