package p205h.p208b.p209a.p212e.p216d;

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
import com.hbb20.C1444R;
import java.io.IOException;
import org.json.JSONException;
import org.json.JSONObject;
import p000a.p006b.p030g.p031a.DialogFragment;
import p000a.p006b.p030g.p031a.FragmentActivity;
import p000a.p006b.p030g.p032b.ContextCompat;
import p000a.p006b.p049h.p050a.AlertDialog;
import p070c.p074b.p075a.Crashlytics;
import p070c.p084d.p085a.p086a.p103i.C1213e;
import p070c.p084d.p085a.p086a.p103i.C1215g;
import p070c.p084d.p085a.p086a.p104j.InterfaceC1236b;
import p205h.p208b.p209a.Anda;
import p205h.p208b.p209a.p210d.Operator;
import p205h.p208b.p209a.p210d.Trip;
import pt.card4b.backendbeacons.BackEnd;
import pt.card4b.backendbeacons.BackendListeners;
import pt.card4b.backendbeacons.DataModels;

/* renamed from: h.b.a.e.d.c4 */
/* loaded from: classes.dex */
public class ReportDialogFragment extends DialogFragment {

    /* renamed from: i0 */
    public C2405b f9787i0;

    /* renamed from: j0 */
    public RadioButton f9788j0;

    /* renamed from: k0 */
    public RadioButton f9789k0;

    /* renamed from: l0 */
    public CheckBox f9790l0;

    /* renamed from: m0 */
    public EditText f9791m0;

    /* renamed from: n0 */
    public C1213e f9792n0;

    /* renamed from: o0 */
    public Location f9793o0 = null;

    /* renamed from: p0 */
    public FragmentActivity f9794p0;

    /* renamed from: q0 */
    public Context f9795q0;

    /* renamed from: r0 */
    public View f9796r0;

    /* compiled from: ReportDialogFragment.java */
    /* renamed from: h.b.a.e.d.c4$b */
    /* loaded from: classes.dex */
    public static class C2405b {

        /* renamed from: a */
        public final Context f9797a;

        /* compiled from: ReportDialogFragment.java */
        /* renamed from: h.b.a.e.d.c4$b$a */
        /* loaded from: classes.dex */
        public class C2406a implements BackendListeners.SendReportListener {

            /* renamed from: a */
            public final /* synthetic */ Anda f9798a;

            public C2406a(Anda anda) {
                this.f9798a = anda;
            }

            @Override // pt.card4b.backendbeacons.BackendListeners.BaseRequestListener
            public void onError(DataModels.Error error) {
                this.f9798a.m1447a(String.format("%s: %s", Integer.valueOf((int) C1444R.string.error), error.getMessageToUser()), -1).mo7619m();
            }

            @Override // pt.card4b.backendbeacons.BackendListeners.SendReportListener
            public void onSuccess() {
                this.f9798a.m1447a(C2405b.this.f9797a.getString(C1444R.string.sending_app_report_success), 0).mo7619m();
            }
        }

        /* renamed from: b */
        public final void m1172b(boolean z, boolean z2, boolean z3, Location location, String str) {
            Anda m1443b = Anda.m1443b(this.f9797a);
            JSONObject jSONObject = new JSONObject();
            JSONObject jSONObject2 = new JSONObject();
            if (m1443b.m1400o().mo1284a()) {
                jSONObject2.put("username", m1443b.m1400o().mo1278b().mo1249b());
            } else {
                jSONObject2.put("username", (Object) null);
            }
            jSONObject.put("session", jSONObject2);
            JSONObject jSONObject3 = new JSONObject();
            if (m1443b.m1492A()) {
                Trip mo1300b = m1443b.m1404m().mo1300b();
                Operator mo1263b = mo1300b.mo1263b();
                if (mo1263b != null) {
                    jSONObject3.put("operator", mo1263b.mo1290a());
                } else {
                    jSONObject3.put("operator", (Object) null);
                }
                JSONObject jSONObject4 = new JSONObject();
                jSONObject4.put("time", DateFormat.format("yyyy-MM-dd HH:mm:ss ZZZZ", mo1300b.mo1262c().mo1286a()).toString());
                jSONObject4.put("stop", mo1300b.mo1262c().mo1285d().mo1266c());
                JSONObject jSONObject5 = new JSONObject();
                jSONObject5.put("time", DateFormat.format("yyyy-MM-dd HH:mm:ss ZZZZ", mo1300b.mo1259f().mo1286a()).toString());
                jSONObject5.put("stop", mo1300b.mo1259f().mo1285d().mo1266c());
                jSONObject3.put("stopCount", mo1300b.mo1253l());
                jSONObject3.put("vehicleType", mo1300b.mo1256i());
            }
            jSONObject.put("trip", jSONObject3);
            JSONObject jSONObject6 = new JSONObject();
            jSONObject6.put("branch", Build.BRAND);
            jSONObject6.put("model", Build.MODEL);
            jSONObject6.put("android", Build.VERSION.SDK_INT);
            try {
                PackageInfo packageInfo = this.f9797a.getPackageManager().getPackageInfo(this.f9797a.getPackageName(), 0);
                jSONObject6.put("app", packageInfo.versionName + " (" + packageInfo.versionCode + ")");
            } catch (Exception e) {
                e.printStackTrace();
                jSONObject6.put("app", "unknown");
            }
            jSONObject6.put("bluetooth", m1443b.m1394r() ? "enabled" : "disabled");
            jSONObject6.put("location", m1443b.m1380y() ? "enabled" : "disabled");
            jSONObject6.put("nfc", m1443b.m1378z() ? "enabled" : "disabled");
            jSONObject6.put("locale", m1443b.m1415i().getLanguage());
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
            BackEnd.sendLogReport(jSONObject.toString(), new C2406a(m1443b));
        }

        public C2405b(Context context, View view) {
            this.f9797a = context;
        }

        /* renamed from: a */
        public final void m1173a(boolean z, boolean z2, boolean z3, Location location, String str) {
            try {
                m1172b(z, z2, z3, location, str);
            } catch (IOException | JSONException e) {
                e.printStackTrace();
                Crashlytics.m6081a((Throwable) e);
            }
        }
    }

    @Override // p000a.p006b.p030g.p031a.DialogFragment, android.support.p065v4.app.Fragment
    @SuppressLint({"LongLogTag"})
    /* renamed from: X */
    public void mo779X() {
        super.mo779X();
        Log.i("ReportDialogFragment.class", "ReportDialogFragment: onDetach was called");
        this.f9794p0 = null;
        this.f9795q0 = null;
    }

    @Override // p000a.p006b.p030g.p031a.DialogFragment, android.support.p065v4.app.Fragment
    @SuppressLint({"LongLogTag"})
    /* renamed from: a */
    public void mo778a(Context context) {
        super.mo778a(context);
        this.f9795q0 = context;
        this.f9794p0 = m7468j();
    }

    /* renamed from: b */
    public void m1177b(View view) {
        this.f9796r0 = view;
    }

    @Override // p000a.p006b.p030g.p031a.DialogFragment
    /* renamed from: n */
    public Dialog mo769n(Bundle bundle) {
        m10345l(false);
        m7470i(true);
        View inflate = m7468j().getLayoutInflater().inflate(C1444R.layout.dialog_report, (ViewGroup) null);
        this.f9788j0 = (RadioButton) inflate.findViewById(C1444R.C1446id.rightNow);
        this.f9789k0 = (RadioButton) inflate.findViewById(C1444R.C1446id.past);
        this.f9790l0 = (CheckBox) inflate.findViewById(C1444R.C1446id.useLocation);
        this.f9791m0 = (EditText) inflate.findViewById(C1444R.C1446id.description);
        this.f9792n0 = C1215g.m4988a(this.f9795q0);
        if (ContextCompat.m10021a(this.f9795q0, "android.permission.ACCESS_FINE_LOCATION") != 0 && ContextCompat.m10021a(this.f9795q0, "android.permission.ACCESS_COARSE_LOCATION") != 0) {
            this.f9790l0.setEnabled(false);
            m7506a(new String[]{"android.permission.ACCESS_COARSE_LOCATION", "android.permission.ACCESS_FINE_LOCATION"}, 1);
        }
        m1176o0();
        this.f9787i0 = new C2405b(this.f9795q0, this.f9796r0);
        AlertDialog.C0325a c0325a = new AlertDialog.C0325a(this.f9795q0);
        c0325a.m9134b(C1444R.string.action_report);
        c0325a.m9132b(inflate);
        c0325a.m9133b(C1444R.string.report_action_continue, new DialogInterface.OnClickListener() { // from class: h.b.a.e.d.v1
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                ReportDialogFragment.this.m1179a(dialogInterface, i);
            }
        });
        c0325a.m9146a(17039360, (DialogInterface.OnClickListener) null);
        return c0325a.m9148a();
    }

    @SuppressLint({"LongLogTag"})
    /* renamed from: o0 */
    public final void m1176o0() {
        if (this.f9794p0 == null) {
            BackEnd.addToLog(String.format("[%s] activity is null", "ReportDialogFragment.class"));
        } else if (ContextCompat.m10021a(this.f9795q0, "android.permission.ACCESS_FINE_LOCATION") == 0 || ContextCompat.m10021a(this.f9795q0, "android.permission.ACCESS_COARSE_LOCATION") == 0) {
            this.f9792n0.m4989f().mo4969a(this.f9794p0, new InterfaceC1236b() { // from class: h.b.a.e.d.u1
                @Override // p070c.p084d.p085a.p086a.p104j.InterfaceC1236b
                /* renamed from: b */
                public final void mo781b(Object obj) {
                    ReportDialogFragment.this.m1178a((Location) obj);
                }
            });
        }
    }

    /* renamed from: a */
    public /* synthetic */ void m1178a(Location location) {
        Log.i("ReportDialogFragment.class", "ReportDialogFragment: getLocation called with onSuccess");
        if (location != null) {
            this.f9793o0 = location;
            if (this.f9790l0.isEnabled()) {
                return;
            }
            this.f9790l0.setEnabled(true);
        }
    }

    /* renamed from: a */
    public /* synthetic */ void m1179a(DialogInterface dialogInterface, int i) {
        C2405b c2405b = this.f9787i0;
        if (c2405b != null) {
            c2405b.m1173a(this.f9788j0.isChecked(), this.f9789k0.isChecked(), this.f9790l0.isChecked(), this.f9793o0, this.f9791m0.getText().toString());
        }
    }

    @Override // android.support.p065v4.app.Fragment
    /* renamed from: a */
    public void mo872a(int i, String[] strArr, int[] iArr) {
        if (i == 1) {
            if (strArr.length == 2 && iArr[0] == 0 && iArr[1] == 0) {
                m1176o0();
                return;
            }
            return;
        }
        super.mo872a(i, strArr, iArr);
    }
}
