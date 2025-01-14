package pt.opt.anda.gui.activity;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.support.design.widget.Snackbar;
import android.support.p065v4.app.Fragment;
import android.support.p065v4.content.FileProvider;
import android.view.View;
import android.view.Window;
import android.webkit.MimeTypeMap;
import android.widget.TextView;
import com.hbb20.C1444R;
import java.io.File;
import java.text.DateFormat;
import java.util.List;
import java.util.concurrent.TimeUnit;
import p000a.p006b.p030g.p031a.FragmentManager;
import p000a.p006b.p030g.p031a.FragmentTransaction;
import p000a.p006b.p049h.p050a.AlertDialog;
import p000a.p006b.p049h.p050a.AppCompatActivity;
import p136d.p153c.Observable;
import p136d.p153c.ObservableEmitter;
import p136d.p153c.ObservableOnSubscribe;
import p193g.p194a.p203b.BluetoothMedic;
import p205h.p208b.p209a.Anda;
import p205h.p208b.p209a.p210d.AndaActionsListener;
import p205h.p208b.p209a.p210d.ErrorListener;
import p205h.p208b.p209a.p210d.OngoingTrip;
import p205h.p208b.p209a.p210d.Passing;
import p205h.p208b.p209a.p212e.p213a.NavigationActivity;
import p205h.p208b.p209a.p212e.p216d.AbstractFragment;
import p205h.p208b.p209a.p212e.p216d.HomeFragment;
import p205h.p208b.p209a.p212e.p216d.IntroFragment;
import pt.opt.anda.gui.activity.MainActivity;

/* loaded from: classes.dex */
public class MainActivity extends AppCompatActivity implements NavigationActivity, ErrorListener, AndaActionsListener, OngoingTrip.InterfaceC2364c {

    /* renamed from: q */
    public Anda f10924q;

    /* renamed from: r */
    public DateFormat f10925r;

    /* renamed from: s */
    public boolean f10926s = false;

    /* renamed from: t */
    public boolean f10927t = false;

    /* renamed from: u */
    public boolean f10928u;

    /* renamed from: v */
    public AlertDialog f10929v;

    /* renamed from: w */
    public AlertDialog f10930w;

    /* renamed from: d */
    public static /* synthetic */ void m11d(Window window, ObservableEmitter observableEmitter) {
        window.clearFlags(6815744);
        observableEmitter.mo3365a();
    }

    @Override // p205h.p208b.p209a.p210d.OngoingTrip.InterfaceC2364c
    /* renamed from: a */
    public void mo30a(OngoingTrip ongoingTrip) {
    }

    @Override // p205h.p208b.p209a.p210d.OngoingTrip.InterfaceC2364c
    /* renamed from: a */
    public void mo29a(OngoingTrip ongoingTrip, ErrorListener.C2358a c2358a) {
    }

    @Override // p205h.p208b.p209a.p210d.OngoingTrip.InterfaceC2364c
    /* renamed from: a */
    public void mo27a(OngoingTrip ongoingTrip, OngoingTrip.InterfaceC2364c.AbstractRunnableC2365a abstractRunnableC2365a) {
    }

    @Override // p205h.p208b.p209a.p210d.OngoingTrip.InterfaceC2364c
    /* renamed from: a */
    public void mo26a(OngoingTrip ongoingTrip, Passing passing) {
    }

    @Override // p205h.p208b.p209a.p212e.p213a.NavigationActivity
    /* renamed from: a */
    public void mo24a(AbstractFragment abstractFragment, Fragment fragment, boolean z) {
        if (this.f10928u) {
            FragmentTransaction mo10264a = m10333f().mo10264a();
            mo10264a.mo10139b(C1444R.C1446id.root, fragment);
            if (fragment.m7451r() == null) {
                mo10264a.mo10145a(16973825);
            }
            if (z) {
                mo10264a.mo10141a((String) null);
            }
            mo10264a.mo10146a();
        }
    }

    @Override // p205h.p208b.p209a.p210d.AndaActionsListener
    /* renamed from: a */
    public void mo21a(boolean z, boolean z2) {
    }

    @Override // p205h.p208b.p209a.p210d.AndaActionsListener
    /* renamed from: b */
    public void mo20b() {
    }

    /* renamed from: b */
    public /* synthetic */ void m19b(View view) {
        m6r();
    }

    @Override // p205h.p208b.p209a.p210d.ErrorListener
    /* renamed from: b */
    public void mo17b(ErrorListener.EnumC2360b enumC2360b) {
    }

    @Override // p205h.p208b.p209a.p210d.OngoingTrip.InterfaceC2364c
    /* renamed from: b */
    public void mo16b(OngoingTrip ongoingTrip) {
    }

    @SuppressLint({"RestrictedApi"})
    /* renamed from: c */
    public final void m14c(Intent intent) {
        if (intent.getIntExtra("p", 0) != 0) {
            for (Fragment fragment : m10333f().mo10206c()) {
                if (fragment instanceof HomeFragment) {
                    if (intent.getBooleanExtra(BluetoothMedic.f8724j, false)) {
                        ((HomeFragment) fragment).m918q0();
                        return;
                    } else if (!intent.hasExtra("ce")) {
                        ((HomeFragment) fragment).m956C0();
                        return;
                    } else {
                        ((HomeFragment) fragment).m928d(intent.getIntExtra("ce", 0));
                        return;
                    }
                }
            }
        }
    }

    @Override // p205h.p208b.p209a.p210d.OngoingTrip.InterfaceC2364c
    /* renamed from: c */
    public void mo12c(OngoingTrip ongoingTrip) {
    }

    @Override // p205h.p208b.p209a.p210d.OngoingTrip.InterfaceC2364c
    /* renamed from: d */
    public void mo10d(OngoingTrip ongoingTrip) {
    }

    /* renamed from: o */
    public boolean m9o() {
        return this.f10926s;
    }

    @Override // p000a.p006b.p030g.p031a.FragmentActivity, android.app.Activity
    public void onBackPressed() {
        if (this.f10927t) {
            this.f10924q.m1430d();
        } else {
            super.onBackPressed();
        }
    }

    @Override // p000a.p006b.p049h.p050a.AppCompatActivity, p000a.p006b.p030g.p031a.FragmentActivity, p000a.p006b.p030g.p031a.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        getWindow().requestFeature(12);
        this.f10924q = Anda.m1443b((Context) this);
        this.f10924q.m1454a((ErrorListener) this);
        this.f10924q.m1457a((AndaActionsListener) this);
        this.f10924q.m1450a((OngoingTrip.InterfaceC2364c) this);
        this.f10924q.m1439b((AndaActionsListener) this);
        setContentView(C1444R.layout.activity_main);
        if (bundle == null) {
            FragmentTransaction mo10264a = m10333f().mo10264a();
            mo10264a.mo10139b(C1444R.C1446id.root, this.f10924q.m1400o().mo1284a() ? new HomeFragment() : new IntroFragment());
            mo10264a.mo10146a();
            new Handler().post(new Runnable() { // from class: h.b.a.e.a.a
                @Override // java.lang.Runnable
                public final void run() {
                    MainActivity.this.m8p();
                }
            });
        }
    }

    @Override // p000a.p006b.p049h.p050a.AppCompatActivity, p000a.p006b.p030g.p031a.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        this.f10924q.m1437b((ErrorListener) this);
        this.f10924q.m1435b((OngoingTrip.InterfaceC2364c) this);
        this.f10924q.m1470U();
    }

    @Override // p000a.p006b.p030g.p031a.FragmentActivity, android.app.Activity
    public void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        m14c(intent);
    }

    @Override // p000a.p006b.p030g.p031a.FragmentActivity, android.app.Activity
    public void onPause() {
        this.f10926s = false;
        this.f10928u = false;
        super.onPause();
    }

    @Override // p000a.p006b.p049h.p050a.AppCompatActivity, android.app.Activity
    public void onPostCreate(Bundle bundle) {
        super.onPostCreate(bundle);
    }

    @Override // p000a.p006b.p049h.p050a.AppCompatActivity, p000a.p006b.p030g.p031a.FragmentActivity, android.app.Activity
    public void onPostResume() {
        super.onPostResume();
        this.f10928u = true;
    }

    @Override // p000a.p006b.p030g.p031a.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        this.f10926s = true;
        this.f10924q.m1434c();
    }

    @Override // p000a.p006b.p049h.p050a.AppCompatActivity, p000a.p006b.p030g.p031a.FragmentActivity, p000a.p006b.p030g.p031a.ComponentActivity, android.app.Activity
    @SuppressLint({"MissingSuperCall"})
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
    }

    @Override // p205h.p208b.p209a.p210d.AndaActionsListener
    public void onTripAppActivityBlocked() {
    }

    @Override // p205h.p208b.p209a.p210d.AndaActionsListener
    @SuppressLint({"CheckResult"})
    public void onWakeUpRequired() {
        Intent intent = new Intent(getApplicationContext(), MainActivity.class);
        intent.setFlags(131072);
        startActivityIfNeeded(intent, 100, null);
        m2v();
    }

    /* renamed from: p */
    public /* synthetic */ void m8p() {
        m14c(getIntent());
    }

    /* renamed from: q */
    public void m7q() {
        startActivityForResult(new Intent("android.bluetooth.adapter.action.REQUEST_ENABLE"), 101);
    }

    /* renamed from: r */
    public void m6r() {
        startActivity(new Intent("android.settings.LOCATION_SOURCE_SETTINGS"));
    }

    /* renamed from: s */
    public void m5s() {
        startActivity(new Intent("android.settings.NFC_SETTINGS"));
    }

    /* renamed from: t */
    public final void m4t() {
        if (this.f10929v == null) {
            this.f10929v = m37a(this, (int) C1444R.string.error_bluetooth, getString(C1444R.string.error_bluetooth_hint).replace("\n", " "), new View.OnClickListener() { // from class: h.b.a.e.a.b
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    MainActivity.this.m34a(view);
                }
            });
        }
        this.f10929v.show();
    }

    /* renamed from: u */
    public final void m3u() {
        if (this.f10930w == null) {
            this.f10930w = m37a(this, (int) C1444R.string.error_location, getString(C1444R.string.error_location_hint).replace("\n", " "), new View.OnClickListener() { // from class: h.b.a.e.a.f
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    MainActivity.this.m19b(view);
                }
            });
        }
        this.f10930w.show();
    }

    /* renamed from: v */
    public final void m2v() {
        final Window window = getWindow();
        Observable.m3306a(Observable.m3309a(new ObservableOnSubscribe() { // from class: h.b.a.e.a.d
            @Override // p136d.p153c.ObservableOnSubscribe
            /* renamed from: a */
            public final void mo1212a(ObservableEmitter observableEmitter) {
                MainActivity.this.m33a(window, observableEmitter);
            }
        }), Observable.m3300b(2L, TimeUnit.SECONDS), Observable.m3309a(new ObservableOnSubscribe() { // from class: h.b.a.e.a.g
            @Override // p136d.p153c.ObservableOnSubscribe
            /* renamed from: a */
            public final void mo1212a(ObservableEmitter observableEmitter) {
                MainActivity.this.m18b(window, observableEmitter);
            }
        })).m3297d();
    }

    /* renamed from: b */
    public /* synthetic */ void m18b(final Window window, final ObservableEmitter observableEmitter) {
        runOnUiThread(new Runnable() { // from class: h.b.a.e.a.c
            @Override // java.lang.Runnable
            public final void run() {
                MainActivity.m11d(window, observableEmitter);
            }
        });
    }

    @Override // p205h.p208b.p209a.p212e.p213a.NavigationActivity
    /* renamed from: a */
    public void mo35a(Fragment fragment) {
        if (this.f10926s) {
            try {
                m10333f().mo10190f();
            } catch (Exception unused) {
                m10333f().mo10194e();
            }
        }
    }

    @Override // p205h.p208b.p209a.p212e.p213a.NavigationActivity
    /* renamed from: c */
    public DateFormat mo15c() {
        this.f10925r = android.text.format.DateFormat.getTimeFormat(this);
        return this.f10925r;
    }

    /* renamed from: c */
    public static /* synthetic */ void m13c(Window window, ObservableEmitter observableEmitter) {
        window.addFlags(6815744);
        observableEmitter.mo3365a();
    }

    @Override // p205h.p208b.p209a.p212e.p213a.NavigationActivity
    /* renamed from: a */
    public void mo25a(AbstractFragment abstractFragment, Fragment fragment) {
        FragmentManager m10333f = m10333f();
        for (int i = 0; i < m10333f.mo10223b(); i++) {
            m10333f.mo10194e();
        }
        List<Fragment> mo10206c = m10333f.mo10206c();
        FragmentTransaction mo10264a = m10333f.mo10264a();
        if (mo10206c != null) {
            for (Fragment fragment2 : mo10206c) {
                if (fragment2 != null) {
                    mo10264a.mo10143a(fragment2);
                }
            }
        }
        mo10264a.mo10139b(C1444R.C1446id.root, fragment);
        mo10264a.mo10146a();
    }

    @Override // p205h.p208b.p209a.p212e.p213a.NavigationActivity
    /* renamed from: a */
    public void mo22a(boolean z) {
        this.f10927t = z;
    }

    /* renamed from: a */
    public static Intent m39a(Context context) {
        Intent intent = new Intent(context, MainActivity.class);
        intent.putExtra("p", 1);
        return intent;
    }

    /* renamed from: a */
    public static Intent m38a(Context context, int i) {
        Intent intent = new Intent(context, MainActivity.class);
        intent.putExtra("p", 1);
        intent.putExtra("ce", i);
        return intent;
    }

    /* renamed from: a */
    public static Intent m36a(Context context, String str, String str2) {
        Uri m7416a = FileProvider.m7416a(context, str2, new File(str));
        String mimeTypeFromExtension = MimeTypeMap.getSingleton().getMimeTypeFromExtension(MimeTypeMap.getFileExtensionFromUrl(m7416a.toString()).toLowerCase());
        Intent intent = new Intent("android.intent.action.VIEW");
        intent.setDataAndType(m7416a, mimeTypeFromExtension);
        intent.addFlags(1);
        return intent;
    }

    @Override // p205h.p208b.p209a.p210d.ErrorListener
    /* renamed from: a */
    public void mo32a(ErrorListener.C2358a c2358a) {
        if (this.f10924q.m1492A() || this.f10924q.m1488C()) {
            ErrorListener.C2358a.EnumC2359a m1323b = c2358a.m1323b();
            if (m1323b == ErrorListener.C2358a.EnumC2359a.bluetoothOff) {
                m4t();
            } else if (m1323b != ErrorListener.C2358a.EnumC2359a.locationOff) {
                return;
            } else {
                m3u();
            }
            if (this.f10926s) {
                c2358a.m1320e();
            }
        }
    }

    @Override // p205h.p208b.p209a.p210d.ErrorListener
    /* renamed from: a */
    public void mo31a(ErrorListener.EnumC2360b enumC2360b) {
        AlertDialog alertDialog;
        AlertDialog alertDialog2;
        if (enumC2360b == ErrorListener.EnumC2360b.bluetooth && (alertDialog2 = this.f10929v) != null) {
            alertDialog2.dismiss();
        } else if (enumC2360b != ErrorListener.EnumC2360b.location || (alertDialog = this.f10930w) == null) {
        } else {
            alertDialog.dismiss();
        }
    }

    /* renamed from: a */
    public /* synthetic */ void m34a(View view) {
        m7q();
    }

    /* renamed from: a */
    public static AlertDialog m37a(Context context, int i, String str, View.OnClickListener onClickListener) {
        AlertDialog.C0325a c0325a = new AlertDialog.C0325a(context);
        c0325a.m9134b(i);
        View inflate = View.inflate(context, C1444R.layout.dialog_service_disabled, null);
        TextView textView = (TextView) inflate.findViewById(C1444R.C1446id.message);
        textView.setText(str);
        textView.setOnClickListener(onClickListener);
        inflate.findViewById(C1444R.C1446id.button).setOnClickListener(onClickListener);
        c0325a.m9132b(inflate);
        c0325a.m9138a(false);
        return c0325a.m9148a();
    }

    /* renamed from: a */
    public /* synthetic */ void m33a(final Window window, final ObservableEmitter observableEmitter) {
        runOnUiThread(new Runnable() { // from class: h.b.a.e.a.e
            @Override // java.lang.Runnable
            public final void run() {
                MainActivity.m13c(window, observableEmitter);
            }
        });
    }

    @Override // p205h.p208b.p209a.p210d.AndaActionsListener
    /* renamed from: a */
    public Snackbar mo23a(String str, int i) {
        return Snackbar.m7626a(findViewById(16908290), str, i);
    }

    @Override // p205h.p208b.p209a.p210d.OngoingTrip.InterfaceC2364c
    /* renamed from: a */
    public void mo28a(OngoingTrip ongoingTrip, OngoingTrip.C2362a c2362a) {
        AlertDialog alertDialog = this.f10929v;
        if (alertDialog != null) {
            alertDialog.dismiss();
        }
        AlertDialog alertDialog2 = this.f10930w;
        if (alertDialog2 != null) {
            alertDialog2.dismiss();
        }
    }
}
