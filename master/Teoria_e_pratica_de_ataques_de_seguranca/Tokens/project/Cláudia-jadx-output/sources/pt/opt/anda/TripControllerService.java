package pt.opt.anda;

import a.b.g.a.b0;
import a.b.g.a.y;
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
import d.c.c0.b;
import h.b.a.c;
import h.b.a.d.f;
import h.b.a.d.o;
import h.b.a.d.q;
import java.util.concurrent.TimeUnit;
import pt.card4b.backendbeacons.BackEnd;
import pt.opt.anda.gui.activity.MainActivity;
/* loaded from: classes.dex */
public class TripControllerService extends Service implements o.c, f, h.b.a.d.a {

    /* renamed from: a  reason: collision with root package name */
    public c f7779a;

    /* renamed from: b  reason: collision with root package name */
    public PendingIntent f7780b;

    /* renamed from: c  reason: collision with root package name */
    public y.c f7781c;

    /* renamed from: d  reason: collision with root package name */
    public o f7782d;

    /* renamed from: e  reason: collision with root package name */
    public b f7783e;

    /* loaded from: classes.dex */
    public static /* synthetic */ class a {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f7784a;

        /* renamed from: b  reason: collision with root package name */
        public static final /* synthetic */ int[] f7785b = new int[f.b.values().length];

        static {
            try {
                f7785b[f.b.bluetooth.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f7785b[f.b.location.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f7785b[f.b.hce.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            f7784a = new int[f.a.EnumC0164a.values().length];
            try {
                f7784a[f.a.EnumC0164a.bluetoothOff.ordinal()] = 1;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f7784a[f.a.EnumC0164a.locationOff.ordinal()] = 2;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f7784a[f.a.EnumC0164a.hceError.ordinal()] = 3;
            } catch (NoSuchFieldError unused6) {
            }
        }
    }

    @Override // h.b.a.d.a
    public Snackbar a(String str, int i2) {
        return null;
    }

    @Override // h.b.a.d.o.c
    public void a(o oVar) {
    }

    @Override // h.b.a.d.o.c
    public void a(o oVar, f.a aVar) {
        a(aVar);
    }

    @Override // h.b.a.d.a
    public void a(boolean z, boolean z2) {
    }

    @Override // h.b.a.d.a
    public void b() {
    }

    @Override // h.b.a.d.f
    public void b(f.b bVar) {
    }

    @Override // h.b.a.d.o.c
    public void b(o oVar) {
        b0.a(this).a(21);
    }

    @Override // h.b.a.d.o.c
    public void c(o oVar) {
        b0.a(this).a(21);
        b0.a(this).a(11);
        b0.a(this).a(12);
        b0.a(this).a(13);
        b0.a(this).a(14);
    }

    @Override // h.b.a.d.o.c
    @SuppressLint({"CheckResult", "LongLogTag"})
    public void d(o oVar) {
        this.f7782d = oVar;
        a();
        this.f7783e = d.c.o.a(10L, TimeUnit.SECONDS).a(h.b.a.b.f6876a);
    }

    public final void e() {
        y.c cVar = new y.c(this, getString(2131755063));
        cVar.c((CharSequence) getString(2131755241));
        cVar.b((CharSequence) getString(2131755241));
        cVar.a((CharSequence) getString(2131755242));
        cVar.b(1);
        cVar.a("err");
        cVar.c(2131165580);
        cVar.b(getResources().getString(2131755063));
        cVar.a(-769226);
        cVar.a(this.f7780b);
        b0.a(this).a(12, cVar.a());
    }

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override // android.app.Service
    public void onCreate() {
        this.f7779a = c.b((Context) this);
        c cVar = this.f7779a;
        if (cVar != null) {
            cVar.a((o.c) this);
            this.f7779a.a((h.b.a.d.a) this);
            this.f7779a.a((f) this);
            a(this);
            this.f7780b = PendingIntent.getActivity(this, 1, MainActivity.a(this), 134217728);
            if (this.f7779a.A()) {
                d(this.f7779a.m());
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
        this.f7779a.b((o.c) this);
        this.f7779a.c(this);
        this.f7779a.b((f) this);
        this.f7779a.e();
        BackEnd.addToLog("[TripControllerService] onDestroy() was invoked");
        Log.d("TripControllerService.class", "onDestroy() was invoked");
        b bVar = this.f7783e;
        if (bVar != null) {
            bVar.b();
        }
    }

    @Override // android.app.Service
    public int onStartCommand(Intent intent, int i2, int i3) {
        return 1;
    }

    @Override // h.b.a.d.a
    public void onTripAppActivityBlocked() {
    }

    @Override // h.b.a.d.a
    public void onWakeUpRequired() {
    }

    public final void a() {
        q a2;
        this.f7781c = new y.c(this, getResources().getString(2131755063));
        String string = getString(2131755335);
        this.f7781c.b((CharSequence) string);
        this.f7781c.c((CharSequence) string);
        this.f7781c.c(2131165597);
        this.f7781c.a(-13615201);
        this.f7781c.b(getString(2131755063));
        this.f7781c.a(PendingIntent.getActivity(this, 1, MainActivity.a(this), 268435456));
        this.f7781c.d(1);
        Intent a3 = MainActivity.a(this);
        a3.addFlags(268435456);
        startActivity(a3);
        if (this.f7782d.b().l() > 0 && (a2 = this.f7782d.b().a(this.f7782d.b().l() - 1)) != null) {
            this.f7781c.a((CharSequence) a2.d().a());
        }
        Notification a4 = this.f7781c.a();
        a4.flags = 2;
        startForeground(1, a4);
    }

    public final void d() {
        y.c cVar = new y.c(this, getString(2131755063));
        cVar.c((CharSequence) getString(2131755212));
        cVar.b((CharSequence) getString(2131755212));
        cVar.a((CharSequence) getString(2131755214));
        cVar.b(1);
        cVar.a("err");
        cVar.b(getString(2131755063));
        cVar.c(2131165580);
        cVar.a(-769226);
        cVar.a(this.f7780b);
        b0.a(this).a(14, cVar.a());
    }

    public final void c() {
        y.c cVar = new y.c(this, getString(2131755063));
        cVar.c((CharSequence) getString(2131755239));
        cVar.b((CharSequence) getString(2131755239));
        cVar.a((CharSequence) getString(2131755240));
        cVar.b(1);
        cVar.a("err");
        cVar.b(getResources().getString(2131755063));
        cVar.c(2131165580);
        cVar.a(-769226);
        cVar.a(this.f7780b);
        b0.a(this).a(11, cVar.a());
    }

    public static /* synthetic */ void a(Long l) {
        Log.d("TripControllerService.class", "Ping from service...");
        BackEnd.addToLog("[TripControllerService] Ping from service...");
    }

    @Override // h.b.a.d.o.c
    public void a(o oVar, q qVar) {
        y.c cVar = this.f7781c;
        if (cVar == null) {
            return;
        }
        cVar.a((CharSequence) qVar.d().a());
        b0.a(this).a(1, this.f7781c.a());
    }

    @Override // h.b.a.d.o.c
    public void a(o oVar, o.a aVar) {
        stopForeground(true);
        Toast.makeText(this, getString(2131755359), 0).show();
        b0.a(this).a(21);
        b0.a(this).a(11);
        b0.a(this).a(12);
        b0.a(this).a(13);
        b0.a(this).a(14);
        b bVar = this.f7783e;
        if (bVar != null) {
            bVar.b();
        }
    }

    @Override // h.b.a.d.o.c
    public void a(o oVar, o.c.a aVar) {
        y.c cVar = new y.c(this, getResources().getString(2131755063));
        cVar.b((CharSequence) getString(2131755347));
        cVar.c((CharSequence) getString(2131755349));
        cVar.b(getResources().getString(2131755063));
        cVar.c(2131165597);
        cVar.a(-13615201);
        cVar.a(PendingIntent.getActivity(this, 21, MainActivity.a(this, 0), 134217728));
        cVar.a(new y.a.C0017a(2131165571, getString(2131755351), PendingIntent.getActivity(this, 22, MainActivity.a(this, 1), 134217728)).a());
        cVar.a(new y.a.C0017a(2131165571, getString(17039360), PendingIntent.getActivity(this, 23, MainActivity.a(this, -1), 134217728)).a());
        cVar.d(1);
        b0.a(this).a(21, cVar.a());
    }

    @Override // h.b.a.d.f
    public void a(f.a aVar) {
        if (aVar.d()) {
            return;
        }
        int i2 = a.f7784a[aVar.b().ordinal()];
        if (i2 == 1) {
            if (this.f7779a.A()) {
                c();
                aVar.e();
            }
        } else if (i2 != 2) {
            if (i2 != 3) {
                return;
            }
            d();
            aVar.e();
        } else if (this.f7779a.A()) {
            e();
            aVar.e();
        }
    }

    @Override // h.b.a.d.f
    public void a(f.b bVar) {
        int i2 = a.f7785b[bVar.ordinal()];
        if (i2 == 1) {
            b0.a(this).a(11);
        } else if (i2 == 2) {
            b0.a(this).a(12);
        } else if (i2 != 3) {
        } else {
            b0.a(this).a(14);
        }
    }

    public final void a(Context context) {
        if (Build.VERSION.SDK_INT < 26) {
            return;
        }
        NotificationManager notificationManager = (NotificationManager) context.getSystemService("notification");
        NotificationChannel notificationChannel = new NotificationChannel(getString(2131755063), getString(2131755062), 4);
        notificationChannel.setDescription(getString(2131755061));
        notificationChannel.enableLights(true);
        notificationChannel.setLightColor(-1);
        notificationChannel.enableVibration(false);
        if (notificationManager != null) {
            notificationManager.createNotificationChannel(notificationChannel);
        }
    }
}
