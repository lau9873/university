package pt.opt.anda;

import android.annotation.SuppressLint;
import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.IBinder;
import android.support.design.widget.Snackbar;
import android.util.Log;
import android.widget.Toast;
import com.hbb20.C1444R;
import java.util.concurrent.TimeUnit;
import p000a.p006b.p030g.p031a.NotificationCompat;
import p000a.p006b.p030g.p031a.NotificationManagerCompat;
import p136d.p153c.Observable;
import p136d.p153c.p157c0.Disposable;
import p205h.p208b.p209a.Anda;
import p205h.p208b.p209a.C2262b;
import p205h.p208b.p209a.p210d.AndaActionsListener;
import p205h.p208b.p209a.p210d.ErrorListener;
import p205h.p208b.p209a.p210d.OngoingTrip;
import p205h.p208b.p209a.p210d.Passing;
import pt.card4b.backendbeacons.BackEnd;
import pt.opt.anda.gui.activity.MainActivity;

/* loaded from: classes.dex */
public class TripControllerService extends Service implements OngoingTrip.InterfaceC2364c, ErrorListener, AndaActionsListener {

    /* renamed from: a */
    public Anda f10917a;

    /* renamed from: b */
    public PendingIntent f10918b;

    /* renamed from: c */
    public NotificationCompat.C0189c f10919c;

    /* renamed from: d */
    public OngoingTrip f10920d;

    /* renamed from: e */
    public Disposable f10921e;

    /* renamed from: pt.opt.anda.TripControllerService$a */
    /* loaded from: classes.dex */
    public static /* synthetic */ class C2713a {

        /* renamed from: a */
        public static final /* synthetic */ int[] f10922a;

        /* renamed from: b */
        public static final /* synthetic */ int[] f10923b = new int[ErrorListener.EnumC2360b.values().length];

        static {
            try {
                f10923b[ErrorListener.EnumC2360b.bluetooth.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f10923b[ErrorListener.EnumC2360b.location.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f10923b[ErrorListener.EnumC2360b.hce.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            f10922a = new int[ErrorListener.C2358a.EnumC2359a.values().length];
            try {
                f10922a[ErrorListener.C2358a.EnumC2359a.bluetoothOff.ordinal()] = 1;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f10922a[ErrorListener.C2358a.EnumC2359a.locationOff.ordinal()] = 2;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f10922a[ErrorListener.C2358a.EnumC2359a.hceError.ordinal()] = 3;
            } catch (NoSuchFieldError unused6) {
            }
        }
    }

    @Override // p205h.p208b.p209a.p210d.AndaActionsListener
    /* renamed from: a */
    public Snackbar mo23a(String str, int i) {
        return null;
    }

    @Override // p205h.p208b.p209a.p210d.OngoingTrip.InterfaceC2364c
    /* renamed from: a */
    public void mo30a(OngoingTrip ongoingTrip) {
    }

    @Override // p205h.p208b.p209a.p210d.OngoingTrip.InterfaceC2364c
    /* renamed from: a */
    public void mo29a(OngoingTrip ongoingTrip, ErrorListener.C2358a c2358a) {
        mo32a(c2358a);
    }

    @Override // p205h.p208b.p209a.p210d.AndaActionsListener
    /* renamed from: a */
    public void mo21a(boolean z, boolean z2) {
    }

    @Override // p205h.p208b.p209a.p210d.AndaActionsListener
    /* renamed from: b */
    public void mo20b() {
    }

    @Override // p205h.p208b.p209a.p210d.ErrorListener
    /* renamed from: b */
    public void mo17b(ErrorListener.EnumC2360b enumC2360b) {
    }

    @Override // p205h.p208b.p209a.p210d.OngoingTrip.InterfaceC2364c
    /* renamed from: b */
    public void mo16b(OngoingTrip ongoingTrip) {
        NotificationManagerCompat.m10398a(this).m10402a(21);
    }

    @Override // p205h.p208b.p209a.p210d.OngoingTrip.InterfaceC2364c
    /* renamed from: c */
    public void mo12c(OngoingTrip ongoingTrip) {
        NotificationManagerCompat.m10398a(this).m10402a(21);
        NotificationManagerCompat.m10398a(this).m10402a(11);
        NotificationManagerCompat.m10398a(this).m10402a(12);
        NotificationManagerCompat.m10398a(this).m10402a(13);
        NotificationManagerCompat.m10398a(this).m10402a(14);
    }

    @Override // p205h.p208b.p209a.p210d.OngoingTrip.InterfaceC2364c
    @SuppressLint({"CheckResult", "LongLogTag"})
    /* renamed from: d */
    public void mo10d(OngoingTrip ongoingTrip) {
        this.f10920d = ongoingTrip;
        m45a();
        this.f10921e = Observable.m3319a(10L, TimeUnit.SECONDS).m3316a(C2262b.f9477a);
    }

    /* renamed from: e */
    public final void m40e() {
        NotificationCompat.C0189c c0189c = new NotificationCompat.C0189c(this, getString(C1444R.string.anda_notificationChannel));
        c0189c.m10040c((CharSequence) getString(C1444R.string.error_trip_location));
        c0189c.m10044b((CharSequence) getString(C1444R.string.error_trip_location));
        c0189c.m10050a((CharSequence) getString(C1444R.string.error_trip_location_hint));
        c0189c.m10045b(1);
        c0189c.m10049a("err");
        c0189c.m10041c(C1444R.C1445drawable.ic_error_white_18dp);
        c0189c.m10043b(getResources().getString(C1444R.string.anda_notificationChannel));
        c0189c.m10056a(-769226);
        c0189c.m10051a(this.f10918b);
        NotificationManagerCompat.m10398a(this).m10401a(12, c0189c.m10057a());
    }

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override // android.app.Service
    public void onCreate() {
        this.f10917a = Anda.m1443b((Context) this);
        Anda anda = this.f10917a;
        if (anda != null) {
            anda.m1450a((OngoingTrip.InterfaceC2364c) this);
            this.f10917a.m1457a((AndaActionsListener) this);
            this.f10917a.m1454a((ErrorListener) this);
            m44a(this);
            this.f10918b = PendingIntent.getActivity(this, 1, MainActivity.m39a(this), 134217728);
            if (this.f10917a.m1492A()) {
                mo10d(this.f10917a.m1404m());
                return;
            } else {
                stopForeground(true);
                return;
            }
        }
        BackEnd.addToLog(String.format("[%s] anda is null. The service will not receive notifications about trips and error events", "TripControllerService.class"));
        stopForeground(true);
    }

    @Override // android.app.Service
    @SuppressLint({"LongLogTag"})
    public void onDestroy() {
        super.onDestroy();
        this.f10917a.m1435b((OngoingTrip.InterfaceC2364c) this);
        this.f10917a.m1431c(this);
        this.f10917a.m1437b((ErrorListener) this);
        this.f10917a.m1427e();
        BackEnd.addToLog("[TripControllerService] onDestroy() was invoked");
        Log.d("TripControllerService.class", "onDestroy() was invoked");
        Disposable disposable = this.f10921e;
        if (disposable != null) {
            disposable.mo578b();
        }
    }

    @Override // android.app.Service
    public int onStartCommand(Intent intent, int i, int i2) {
        return 1;
    }

    @Override // p205h.p208b.p209a.p210d.AndaActionsListener
    public void onTripAppActivityBlocked() {
    }

    @Override // p205h.p208b.p209a.p210d.AndaActionsListener
    public void onWakeUpRequired() {
    }

    /* renamed from: a */
    public final void m45a() {
        Passing mo1264a;
        this.f10919c = new NotificationCompat.C0189c(this, getResources().getString(C1444R.string.anda_notificationChannel));
        String string = getString(C1444R.string.state_onTrip);
        this.f10919c.m10044b((CharSequence) string);
        this.f10919c.m10040c((CharSequence) string);
        this.f10919c.m10041c(C1444R.C1445drawable.ic_notification);
        this.f10919c.m10056a(-13615201);
        this.f10919c.m10043b(getString(C1444R.string.anda_notificationChannel));
        this.f10919c.m10051a(PendingIntent.getActivity(this, 1, MainActivity.m39a(this), 268435456));
        this.f10919c.m10038d(1);
        Intent m39a = MainActivity.m39a(this);
        m39a.addFlags(268435456);
        startActivity(m39a);
        if (this.f10920d.mo1300b().mo1253l() > 0 && (mo1264a = this.f10920d.mo1300b().mo1264a(this.f10920d.mo1300b().mo1253l() - 1)) != null) {
            this.f10919c.m10050a((CharSequence) mo1264a.mo1285d().mo1267a());
        }
        Notification m10057a = this.f10919c.m10057a();
        m10057a.flags = 2;
        startForeground(1, m10057a);
    }

    /* renamed from: d */
    public final void m41d() {
        NotificationCompat.C0189c c0189c = new NotificationCompat.C0189c(this, getString(C1444R.string.anda_notificationChannel));
        c0189c.m10040c((CharSequence) getString(C1444R.string.error_hce_lib));
        c0189c.m10044b((CharSequence) getString(C1444R.string.error_hce_lib));
        c0189c.m10050a((CharSequence) getString(C1444R.string.error_hce_service_hint));
        c0189c.m10045b(1);
        c0189c.m10049a("err");
        c0189c.m10043b(getString(C1444R.string.anda_notificationChannel));
        c0189c.m10041c(C1444R.C1445drawable.ic_error_white_18dp);
        c0189c.m10056a(-769226);
        c0189c.m10051a(this.f10918b);
        NotificationManagerCompat.m10398a(this).m10401a(14, c0189c.m10057a());
    }

    /* renamed from: c */
    public final void m42c() {
        NotificationCompat.C0189c c0189c = new NotificationCompat.C0189c(this, getString(C1444R.string.anda_notificationChannel));
        c0189c.m10040c((CharSequence) getString(C1444R.string.error_trip_bluetooth));
        c0189c.m10044b((CharSequence) getString(C1444R.string.error_trip_bluetooth));
        c0189c.m10050a((CharSequence) getString(C1444R.string.error_trip_bluetooth_hint));
        c0189c.m10045b(1);
        c0189c.m10049a("err");
        c0189c.m10043b(getResources().getString(C1444R.string.anda_notificationChannel));
        c0189c.m10041c(C1444R.C1445drawable.ic_error_white_18dp);
        c0189c.m10056a(-769226);
        c0189c.m10051a(this.f10918b);
        NotificationManagerCompat.m10398a(this).m10401a(11, c0189c.m10057a());
    }

    /* renamed from: a */
    public static /* synthetic */ void m43a(Long l) {
        Log.d("TripControllerService.class", "Ping from service...");
        BackEnd.addToLog("[TripControllerService] Ping from service...");
    }

    @Override // p205h.p208b.p209a.p210d.OngoingTrip.InterfaceC2364c
    /* renamed from: a */
    public void mo26a(OngoingTrip ongoingTrip, Passing passing) {
        NotificationCompat.C0189c c0189c = this.f10919c;
        if (c0189c == null) {
            return;
        }
        c0189c.m10050a((CharSequence) passing.mo1285d().mo1267a());
        NotificationManagerCompat.m10398a(this).m10401a(1, this.f10919c.m10057a());
    }

    @Override // p205h.p208b.p209a.p210d.OngoingTrip.InterfaceC2364c
    /* renamed from: a */
    public void mo28a(OngoingTrip ongoingTrip, OngoingTrip.C2362a c2362a) {
        stopForeground(true);
        Toast.makeText(this, getString(C1444R.string.trip_event_ended), 0).show();
        NotificationManagerCompat.m10398a(this).m10402a(21);
        NotificationManagerCompat.m10398a(this).m10402a(11);
        NotificationManagerCompat.m10398a(this).m10402a(12);
        NotificationManagerCompat.m10398a(this).m10402a(13);
        NotificationManagerCompat.m10398a(this).m10402a(14);
        Disposable disposable = this.f10921e;
        if (disposable != null) {
            disposable.mo578b();
        }
    }

    @Override // p205h.p208b.p209a.p210d.OngoingTrip.InterfaceC2364c
    /* renamed from: a */
    public void mo27a(OngoingTrip ongoingTrip, OngoingTrip.InterfaceC2364c.AbstractRunnableC2365a abstractRunnableC2365a) {
        NotificationCompat.C0189c c0189c = new NotificationCompat.C0189c(this, getResources().getString(C1444R.string.anda_notificationChannel));
        c0189c.m10044b((CharSequence) getString(C1444R.string.trip_action_automaticEnd_accept));
        c0189c.m10040c((CharSequence) getString(C1444R.string.trip_action_automaticEnd_message));
        c0189c.m10043b(getResources().getString(C1444R.string.anda_notificationChannel));
        c0189c.m10041c(C1444R.C1445drawable.ic_notification);
        c0189c.m10056a(-13615201);
        c0189c.m10051a(PendingIntent.getActivity(this, 21, MainActivity.m38a(this, 0), 134217728));
        c0189c.m10053a(new NotificationCompat.C0186a.C0187a(C1444R.C1445drawable.ic_close_white_24dp, getString(C1444R.string.trip_action_end), PendingIntent.getActivity(this, 22, MainActivity.m38a(this, 1), 134217728)).m10059a());
        c0189c.m10053a(new NotificationCompat.C0186a.C0187a(C1444R.C1445drawable.ic_close_white_24dp, getString(17039360), PendingIntent.getActivity(this, 23, MainActivity.m38a(this, -1), 134217728)).m10059a());
        c0189c.m10038d(1);
        NotificationManagerCompat.m10398a(this).m10401a(21, c0189c.m10057a());
    }

    @Override // p205h.p208b.p209a.p210d.ErrorListener
    /* renamed from: a */
    public void mo32a(ErrorListener.C2358a c2358a) {
        if (c2358a.m1321d()) {
            return;
        }
        int i = C2713a.f10922a[c2358a.m1323b().ordinal()];
        if (i == 1) {
            if (this.f10917a.m1492A()) {
                m42c();
                c2358a.m1320e();
            }
        } else if (i != 2) {
            if (i != 3) {
                return;
            }
            m41d();
            c2358a.m1320e();
        } else if (this.f10917a.m1492A()) {
            m40e();
            c2358a.m1320e();
        }
    }

    @Override // p205h.p208b.p209a.p210d.ErrorListener
    /* renamed from: a */
    public void mo31a(ErrorListener.EnumC2360b enumC2360b) {
        int i = C2713a.f10923b[enumC2360b.ordinal()];
        if (i == 1) {
            NotificationManagerCompat.m10398a(this).m10402a(11);
        } else if (i == 2) {
            NotificationManagerCompat.m10398a(this).m10402a(12);
        } else if (i != 3) {
        } else {
            NotificationManagerCompat.m10398a(this).m10402a(14);
        }
    }

    /* renamed from: a */
    public final void m44a(Context context) {
        if (Build.VERSION.SDK_INT < 26) {
            return;
        }
        NotificationManager notificationManager = (NotificationManager) context.getSystemService("notification");
        NotificationChannel notificationChannel = new NotificationChannel(getString(C1444R.string.anda_notificationChannel), getString(C1444R.string.anda_channelName), 4);
        notificationChannel.setDescription(getString(C1444R.string.anda_channelDescription));
        notificationChannel.enableLights(true);
        notificationChannel.setLightColor(-1);
        notificationChannel.enableVibration(false);
        if (notificationManager != null) {
            notificationManager.createNotificationChannel(notificationChannel);
        }
    }
}
