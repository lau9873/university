package h.b.a;

import android.annotation.SuppressLint;
import android.app.DownloadManager;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.bluetooth.BluetoothAdapter;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.database.Cursor;
import android.location.LocationManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.nfc.NfcAdapter;
import android.nfc.NfcManager;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.os.PowerManager;
import android.os.VibrationEffect;
import android.os.Vibrator;
import android.preference.PreferenceManager;
import android.support.design.widget.Snackbar;
import android.util.Log;
import android.view.Window;
import android.webkit.URLUtil;
import h.b.a.c;
import h.b.a.d.f;
import h.b.a.d.m;
import h.b.a.d.n;
import h.b.a.d.o;
import h.b.a.d.p;
import h.b.a.d.q;
import h.b.a.d.u;
import h.b.a.d.w;
import h.b.a.d.z;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Objects;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import pt.card4b.backendbeacons.BackEnd;
import pt.card4b.backendbeacons.BackendListeners;
import pt.card4b.backendbeacons.DataModels;
import pt.opt.anda.TripControllerService;
/* compiled from: Anda.java */
/* loaded from: classes.dex */
public class c implements o.c, BackendListeners.PossibleStopListener, Runnable {
    public static final Intent[] L;
    @SuppressLint({"StaticFieldLeak"})
    public static c M;
    public f.a D;
    public boolean E;
    public final ThreadPoolExecutor F;
    public final DownloadManager H;
    public Context K;

    /* renamed from: e  reason: collision with root package name */
    public h.b.a.d.a f6881e;

    /* renamed from: i  reason: collision with root package name */
    public w f6885i;
    public h.b.a.d.k j;
    public o.c.a k;
    public h.b.a.d.j m;
    public final u n;
    public o o;
    public h.b.a.d.b0.f p;
    public BroadcastReceiver q;
    public boolean r;

    /* renamed from: a  reason: collision with root package name */
    public final List<o.c> f6877a = new ArrayList(4);

    /* renamed from: b  reason: collision with root package name */
    public final List<n> f6878b = new ArrayList(1);

    /* renamed from: c  reason: collision with root package name */
    public final List<h.b.a.d.f> f6879c = new ArrayList(3);

    /* renamed from: d  reason: collision with root package name */
    public final List<h.b.a.d.a> f6880d = new ArrayList();

    /* renamed from: f  reason: collision with root package name */
    public boolean f6882f = false;

    /* renamed from: g  reason: collision with root package name */
    public final List<h.b.a.d.b0.h> f6883g = new ArrayList();

    /* renamed from: h  reason: collision with root package name */
    public boolean f6884h = false;
    public boolean s = false;
    public boolean t = false;
    public boolean u = false;
    public boolean v = true;
    public boolean w = false;
    public boolean x = false;
    public boolean y = false;
    public boolean z = true;
    public boolean A = false;
    public boolean B = false;
    public boolean C = false;
    public boolean G = true;
    public final BackendListeners.InitialConfigurationRequestListener I = new h();
    public final BackendListeners.StageStopListener J = new k();

    /* compiled from: Anda.java */
    /* loaded from: classes.dex */
    public class a implements o {

        /* compiled from: Anda.java */
        /* renamed from: h.b.a.c$a$a  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        public class C0154a implements BackendListeners.FinishStageRequestListener {
            public C0154a(a aVar) {
            }

            @Override // pt.card4b.backendbeacons.BackendListeners.BaseRequestListener
            public void onError(DataModels.Error error) {
                Log.e("Anda", "registerOngoingTrip(): ongoingTrip.end() called with error:" + error.getMessage() + ": " + error.getMessageToUser());
            }

            @Override // pt.card4b.backendbeacons.BackendListeners.FinishStageRequestListener
            public void onSuccess() {
            }
        }

        public a() {
        }

        @Override // h.b.a.d.o
        public o.c.a a() {
            return c.this.k;
        }

        @Override // h.b.a.d.o
        public w b() {
            return c.this.f6885i;
        }

        @Override // h.b.a.d.o
        public o.b c() {
            BackEnd.finishStage(new C0154a(this));
            return null;
        }
    }

    /* compiled from: Anda.java */
    /* loaded from: classes.dex */
    public class b implements BackendListeners.HasOngoingStageListener {
        public b() {
        }

        @Override // pt.card4b.backendbeacons.BackendListeners.BaseRequestListener
        public void onError(DataModels.Error error) {
            if (error.getType() == DataModels.Error.ErrorType.LOGIN_REQUIRED) {
                c.this.n.c();
            }
            if (error.getType() != DataModels.Error.ErrorType.STAGE_ALREADY_STARTED) {
                c.this.a(h.b.a.d.b0.b.a(error));
            }
        }

        @Override // pt.card4b.backendbeacons.BackendListeners.HasOngoingStageListener
        public void onSuccess(boolean z) {
            if (z) {
                c.this.M();
                BackEnd.resumeStage(c.this.J);
                return;
            }
            c.this.u = true;
            if (c.this.z) {
                return;
            }
            c.this.l();
        }
    }

    /* compiled from: Anda.java */
    /* renamed from: h.b.a.c$c  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0155c extends BroadcastReceiver {
        public C0155c() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            Bundle extras = intent.getExtras();
            DownloadManager.Query query = new DownloadManager.Query();
            if (extras != null) {
                query.setFilterById(extras.getLong("extra_download_id"));
            }
            if (c.this.H != null) {
                Cursor query2 = c.this.H.query(query);
                if (query2.moveToFirst() && query2.getInt(query2.getColumnIndex("status")) == 8) {
                    File file = new File(query2.getString(query2.getColumnIndex("local_uri")));
                    File externalStoragePublicDirectory = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS);
                    File file2 = new File(externalStoragePublicDirectory, "/Anda/Invoices/" + file.getName());
                    long longExtra = intent.getLongExtra("extra_download_id", -1L);
                    Log.d("Anda", "onDownloadCompleted: completed download with ID " + String.valueOf(longExtra));
                    if (c.this.m != null) {
                        c.this.m.a(longExtra, file2.getAbsolutePath());
                    }
                }
            }
        }
    }

    /* compiled from: Anda.java */
    /* loaded from: classes.dex */
    public class d implements w {

        /* compiled from: Anda.java */
        /* loaded from: classes.dex */
        public class a implements Iterator<q> {

            /* renamed from: a  reason: collision with root package name */
            public int f6890a = 0;

            public a() {
            }

            @Override // java.util.Iterator
            public boolean hasNext() {
                return this.f6890a < c.this.f6883g.size();
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // java.util.Iterator
            public q next() {
                List list = c.this.f6883g;
                int i2 = this.f6890a;
                this.f6890a = i2 + 1;
                return (q) list.get(i2);
            }
        }

        public d() {
        }

        @Override // h.b.a.d.w
        public q a(int i2) {
            return (q) c.this.f6883g.get(i2);
        }

        @Override // h.b.a.d.w
        public p b() {
            if (c.this.j == null) {
                if (c.this.f6883g.size() == 0) {
                    return null;
                }
                return h.b.a.d.b0.g.a(((h.b.a.d.b0.h) c.this.f6883g.get(0)).d().h().getOperatorRef());
            }
            return c.this.j.b();
        }

        @Override // h.b.a.d.w
        public q c() {
            if (c.this.f6883g.size() > 0) {
                return (q) c.this.f6883g.get(0);
            }
            return null;
        }

        @Override // h.b.a.d.w
        public String d() {
            return "";
        }

        @Override // h.b.a.d.w
        public long e() {
            q c2 = c();
            if (c2 == null) {
                return -1L;
            }
            return c2.a();
        }

        @Override // h.b.a.d.w
        public q f() {
            int size = c.this.f6883g.size();
            if (size > 0) {
                return (q) c.this.f6883g.get(size - 1);
            }
            return null;
        }

        @Override // h.b.a.d.w
        public boolean g() {
            return false;
        }

        @Override // h.b.a.d.w
        public h.b.a.d.k h() {
            return c.this.j;
        }

        @Override // h.b.a.d.w
        public int i() {
            return c().d().getType();
        }

        @Override // java.lang.Iterable
        public Iterator<q> iterator() {
            return new a();
        }

        @Override // h.b.a.d.w
        public q j() {
            return null;
        }

        @Override // h.b.a.d.w
        public q k() {
            return null;
        }

        @Override // h.b.a.d.w
        public int l() {
            return c.this.f6883g.size();
        }

        @Override // h.b.a.d.w
        public Date m() {
            return new Date(((h.b.a.d.b0.h) c.this.f6883g.get(0)).a());
        }
    }

    /* compiled from: Anda.java */
    /* loaded from: classes.dex */
    public class e implements BackendListeners.GetLanguagesListener {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ h.b.a.d.e f6892a;

        public e(c cVar, h.b.a.d.e eVar) {
            this.f6892a = eVar;
        }

        @Override // pt.card4b.backendbeacons.BackendListeners.BaseRequestListener
        public void onError(DataModels.Error error) {
            Log.w("Anda", String.format("Anda.getAvailableLanguages called with onError. Message is %s", error.getMessageToUser()));
            this.f6892a.a(new ArrayList());
        }

        @Override // pt.card4b.backendbeacons.BackendListeners.GetLanguagesListener
        public void onSuccess(List<DataModels.Language> list) {
            this.f6892a.a(list);
        }
    }

    /* compiled from: Anda.java */
    /* loaded from: classes.dex */
    public class f implements BackendListeners.GetCountriesListener {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ h.b.a.d.e f6893a;

        public f(c cVar, h.b.a.d.e eVar) {
            this.f6893a = eVar;
        }

        @Override // pt.card4b.backendbeacons.BackendListeners.BaseRequestListener
        public void onError(DataModels.Error error) {
            Log.w("Anda", String.format("Anda.getAvailableCountries called with onError. Message is %s", error.getMessageToUser()));
            this.f6893a.b(new ArrayList());
        }

        @Override // pt.card4b.backendbeacons.BackendListeners.GetCountriesListener
        public void onSuccess(List<DataModels.Country> list) {
            this.f6893a.b(list);
        }
    }

    /* compiled from: Anda.java */
    /* loaded from: classes.dex */
    public class g implements BackendListeners.GetCardInfoListener {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ h.b.a.d.g f6894a;

        public g(c cVar, h.b.a.d.g gVar) {
            this.f6894a = gVar;
        }

        @Override // pt.card4b.backendbeacons.BackendListeners.BaseRequestListener
        public void onError(DataModels.Error error) {
            this.f6894a.a(error);
        }

        @Override // pt.card4b.backendbeacons.BackendListeners.GetCardInfoListener
        public void onSucess(DataModels.CardInfo cardInfo) {
            this.f6894a.a(cardInfo.getSerialNumber());
        }
    }

    /* compiled from: Anda.java */
    /* loaded from: classes.dex */
    public class h implements BackendListeners.InitialConfigurationRequestListener {
        public h() {
        }

        public /* synthetic */ void a() {
            c.this.t = true;
            c.this.a();
            c.this.c();
        }

        @Override // pt.card4b.backendbeacons.BackendListeners.BaseRequestListener
        public void onError(DataModels.Error error) {
            if (c.this.w) {
                c.this.R();
                Log.d("Anda", "Failed fetching data.");
                c.this.w = false;
                c.this.v = true;
                Log.e("Anda", "Backend:getApplicationData:Error(" + error.getMessage() + "):" + error.getMessageToUser());
                for (h.b.a.d.a aVar : c.this.f6880d) {
                    aVar.a(c.this.w, c.this.v);
                }
                if (error.getType() != DataModels.Error.ErrorType.STAGE_ALREADY_STARTED) {
                    c cVar = c.this;
                    f.a a2 = h.b.a.d.b0.b.a(error);
                    a2.a(this);
                    cVar.a(a2);
                }
                new Handler().postDelayed(c.X(), 2000L);
            }
        }

        @Override // pt.card4b.backendbeacons.BackendListeners.InitialConfigurationRequestListener
        public void onSuccess() {
            Log.d("Anda", "Done fetching data.");
            c.this.w = false;
            c.this.v = false;
            c.this.R();
            c.this.P();
            if (!c.this.s) {
                c.this.s = true;
                if (!c.this.n.a()) {
                    if (c.this.y) {
                        c.this.y = false;
                        if (!c.this.z) {
                            c.this.l();
                        }
                    }
                } else {
                    c.this.s = true;
                    c.this.n.a(new Runnable() { // from class: h.b.a.a
                        @Override // java.lang.Runnable
                        public final void run() {
                            c.h.this.a();
                        }
                    });
                }
            }
            for (h.b.a.d.a aVar : c.this.f6880d) {
                aVar.a(c.this.w, c.this.v);
            }
        }
    }

    /* compiled from: Anda.java */
    /* loaded from: classes.dex */
    public class i implements BackendListeners.EnableHCEValidationsListener {
        public i() {
        }

        @Override // pt.card4b.backendbeacons.BackendListeners.BaseRequestListener
        public void onError(DataModels.Error error) {
            c.this.B = false;
            c.this.A = false;
            f.a a2 = h.b.a.d.b0.b.a(error);
            c.this.D = a2;
            if (a2.b() == f.a.EnumC0164a.unknown) {
                a2 = new f.a(f.a.EnumC0164a.hceError, error.getMessage(), error.getMessageToUser());
            }
            Log.e("Anda", "enableHCEValidations called with error. Message is: " + error.getMessage());
            c.this.a(a2);
        }

        @Override // pt.card4b.backendbeacons.BackendListeners.EnableHCEValidationsListener
        public void onSuccess() {
            Log.d("Anda", "enableHCEValidation called with success");
        }
    }

    /* compiled from: Anda.java */
    /* loaded from: classes.dex */
    public class j implements BackendListeners.DisableHCEValidationsListener {
        public j() {
        }

        @Override // pt.card4b.backendbeacons.BackendListeners.BaseRequestListener
        public void onError(DataModels.Error error) {
            c.this.A = false;
            c.this.C = false;
            Log.e("Anda", "disableHCEValidation called with error. Message is: " + error.getMessage());
        }

        @Override // pt.card4b.backendbeacons.BackendListeners.DisableHCEValidationsListener
        public void onSuccess() {
            Log.d("Anda", "disableHCEValidation called with success");
        }
    }

    /* compiled from: Anda.java */
    /* loaded from: classes.dex */
    public class k implements BackendListeners.StageStopListener {

        /* compiled from: Anda.java */
        /* loaded from: classes.dex */
        public class a extends o.c.a {

            /* compiled from: Anda.java */
            /* renamed from: h.b.a.c$k$a$a  reason: collision with other inner class name */
            /* loaded from: classes.dex */
            public class C0156a implements BackendListeners.FinishStageUserConfirmationListener {
                public C0156a() {
                }

                @Override // pt.card4b.backendbeacons.BackendListeners.BaseRequestListener
                public void onError(DataModels.Error error) {
                    c.this.k = null;
                    c cVar = c.this;
                    cVar.a(cVar.o, h.b.a.d.b0.b.a(error));
                    c.this.G = true;
                }

                @Override // pt.card4b.backendbeacons.BackendListeners.FinishStageUserConfirmationListener
                public void onSuccess(boolean z) {
                    c.this.k = null;
                    c cVar = c.this;
                    cVar.b(cVar.o);
                    c.this.G = true;
                }
            }

            /* compiled from: Anda.java */
            /* loaded from: classes.dex */
            public class b implements BackendListeners.FinishStageUserConfirmationListener {
                public b() {
                }

                @Override // pt.card4b.backendbeacons.BackendListeners.BaseRequestListener
                public void onError(DataModels.Error error) {
                    c.this.k = null;
                    c cVar = c.this;
                    cVar.a(cVar.o, h.b.a.d.b0.b.a(error));
                }

                @Override // pt.card4b.backendbeacons.BackendListeners.FinishStageUserConfirmationListener
                public void onSuccess(boolean z) {
                    c.this.k = null;
                    c cVar = c.this;
                    cVar.c(cVar.o);
                }
            }

            public a(int i2) {
                super(i2);
            }

            @Override // h.b.a.d.o.c.a
            public void b(boolean z) {
                BackEnd.confirmStageFinished(true, z, new b());
            }

            @Override // h.b.a.d.o.c.a
            public void e() {
                BackEnd.confirmStageFinished(false, false, new C0156a());
            }
        }

        public k() {
        }

        @Override // pt.card4b.backendbeacons.BackendListeners.BaseRequestListener
        public void onError(DataModels.Error error) {
            Log.e("Anda", "Error(" + error.getType() + "): " + error.getMessage());
            if (error.getType() == DataModels.Error.ErrorType.STAGE_ALREADY_STARTED) {
                return;
            }
            DataModels.Error.ErrorType type = error.getType();
            if (type == DataModels.Error.ErrorType.BLUETOOTH_DISABLED || type == DataModels.Error.ErrorType.LOCATION_DISABLED || type == DataModels.Error.ErrorType.NFC_DISABLED) {
                c.this.b();
            }
            c cVar = c.this;
            cVar.a(cVar.o, h.b.a.d.b0.b.a(error));
        }

        @Override // pt.card4b.backendbeacons.BackendListeners.StageStopListener
        public void onFinish(boolean z) {
            Log.d("Anda", "onFinish() called with: " + z);
            c cVar = c.this;
            cVar.a(cVar.o, new o.a(z));
            c.this.G = true;
        }

        @Override // pt.card4b.backendbeacons.BackendListeners.StageStopListener
        public void onFinishConfirmation(int i2, boolean z) {
            Log.d("Anda", "onFinishConfirmation() called with: " + i2 + ", " + z);
            if (z) {
                c.this.k.a();
                if (c.this.k != null) {
                    c.this.k.b();
                    c.this.k = null;
                }
                c cVar = c.this;
                cVar.b(cVar.o);
                c.this.G = true;
            } else if (c.this.G && c.this.k == null) {
                c.this.k = new a(i2);
                c.this.G = false;
                c.this.V();
                c cVar2 = c.this;
                cVar2.a(cVar2.o, c.this.k);
            }
        }

        @Override // pt.card4b.backendbeacons.BackendListeners.StageStopListener
        public void onLogoutRequired() {
            Log.d("Anda", "onLogoutRequired() was called. Forcing logout...");
            c.this.n.c();
        }

        @Override // pt.card4b.backendbeacons.BackendListeners.StageStopListener
        public void onReceiveOtherStop(DataModels.StopInfo stopInfo) {
            Log.d("Anda", "onReceiveOtherStop() called with: " + stopInfo);
            c.this.onReceiveStop(stopInfo);
        }

        @Override // pt.card4b.backendbeacons.BackendListeners.StageStopListener
        public void onReceiveStageStop(DataModels.StopInfo stopInfo) {
            BackEnd.addToLog(String.format(Locale.getDefault(), "[%s] onReceiveStageStop: called with: %s", "Anda", stopInfo));
            Date datetime = stopInfo.getDatetime();
            if (c.this.f6883g.size() == 0) {
                if (stopInfo.getValidationDatetime() != null) {
                    datetime = stopInfo.getValidationDatetime();
                    BackEnd.addToLog(String.format(Locale.getDefault(), "[%s] onReceiveStageStop: validation time is not null. Received %s", "Anda", datetime));
                } else {
                    BackEnd.addToLog(String.format(Locale.getDefault(), "[%s] getValidationDatetime() is null. getDatetime() will be used instead.", "Anda"));
                }
            }
            if (datetime == null) {
                BackEnd.addToLog(String.format(Locale.getDefault(), "[%s] onReceiveStageStop: tipPassings = %d, stopName = %s, operator = %s", "Anda", Integer.valueOf(c.this.f6883g.size()), stopInfo.getStopName(), stopInfo.getOperatorName()));
            }
            if (stopInfo.getDatetime() == null && stopInfo.getValidationDatetime() == null) {
                BackEnd.addToLog(String.format(Locale.getDefault(), "[%s] onReceiveStageStop: both getDatetime() and getValidationDatetime() are null. Setting time to current time.", "Anda"));
                datetime = Calendar.getInstance().getTime();
            }
            if (c.this.f6883g.size() == 0) {
                c.this.j = new h.b.a.d.b0.d(stopInfo);
            }
            BackEnd.addToLog(String.format(Locale.getDefault(), "[%s] onReceiveStageStop: Ready to build a TipPassing with information %s and time %s", "Anda", stopInfo, datetime));
            h.b.a.d.b0.h hVar = new h.b.a.d.b0.h(new h.b.a.d.b0.j(stopInfo), datetime);
            c.this.f6883g.add(hVar);
            c cVar = c.this;
            cVar.a(cVar.o, hVar);
        }

        @Override // pt.card4b.backendbeacons.BackendListeners.StageStopListener
        public void onRemoveOtherStops(List<DataModels.StopInfo> list) {
            Log.d("Anda", "onRemoveOtherStops() called with: " + list);
            c.this.onRemoveStops(list);
        }

        @Override // pt.card4b.backendbeacons.BackendListeners.StageStopListener
        public void onRestartStageStops(List<DataModels.StopInfo> list) {
            Log.d("Anda", "onRestartStageStops() called with: " + list.size() + " stops");
            c.this.f6883g.clear();
            c.this.a(list);
            c cVar = c.this;
            cVar.a(cVar.o);
        }

        @Override // pt.card4b.backendbeacons.BackendListeners.StageStopListener
        public void onServiceDisabled(DataModels.Service service) {
            if (service == DataModels.Service.HCE_VALIDATION) {
                c.this.G();
            } else if (service == DataModels.Service.INTERNET) {
                c.this.E = false;
            }
        }

        @Override // pt.card4b.backendbeacons.BackendListeners.StageStopListener
        public void onServiceEnabled(DataModels.Service service) {
            if (service != DataModels.Service.HCE_VALIDATION) {
                c.this.c();
            }
            if (service == DataModels.Service.BLUETOOTH) {
                c.this.F();
            } else if (service == DataModels.Service.LOCATION) {
                c.this.J();
            } else if (service == DataModels.Service.NFC) {
                c.this.K();
            } else if (service == DataModels.Service.HCE_VALIDATION) {
                c.this.H();
            } else if (service == DataModels.Service.INTERNET) {
                c.this.I();
            }
        }

        @Override // pt.card4b.backendbeacons.BackendListeners.StageStopListener
        public void onStartStageStops(List<DataModels.StopInfo> list) {
            Log.d("Anda", "onStartStageStops() called with: " + list);
            c.this.a(list);
        }

        @Override // pt.card4b.backendbeacons.BackendListeners.StageStopListener
        public void onSuccess() {
            Log.d("Anda", "onSuccess() - Preparing trip start");
            c.this.Q();
            c.this.M();
            c cVar = c.this;
            cVar.d(cVar.o);
        }

        @Override // pt.card4b.backendbeacons.BackendListeners.StageStopListener
        public void onTripAppActivityBlocked() {
            for (h.b.a.d.a aVar : c.this.f6880d) {
                aVar.onTripAppActivityBlocked();
            }
        }

        @Override // pt.card4b.backendbeacons.BackendListeners.StageStopListener
        public void onWakeUpRequired() {
            BackEnd.addToLog("onWakeUpRequired() was invoked. Trying to turn the screen on...");
            for (h.b.a.d.a aVar : c.this.f6880d) {
                aVar.onWakeUpRequired();
            }
        }
    }

    static {
        Intent[] intentArr = new Intent[18];
        intentArr[0] = new Intent().setComponent(new ComponentName("com.miui.securitycenter", "com.miui.permcenter.autostart.AutoStartManagementActivity"));
        intentArr[1] = new Intent().setComponent(new ComponentName("com.letv.android.letvsafe", "com.letv.android.letvsafe.AutobootManageActivity"));
        intentArr[2] = new Intent().setComponent(new ComponentName("com.huawei.systemmanager", "com.huawei.systemmanager.optimize.process.ProtectActivity"));
        intentArr[3] = new Intent().setComponent(new ComponentName("com.huawei.systemmanager", Build.VERSION.SDK_INT >= 28 ? "com.huawei.systemmanager.startupmgr.ui.StartupNormalAppListActivity" : "com.huawei.systemmanager.appcontrol.activity.StartupAppControlActivity"));
        intentArr[4] = new Intent().setComponent(new ComponentName("com.coloros.oppoguardelf", "com.coloros.powermanager.fuelgaue.PowerUsageModelActivity"));
        intentArr[5] = new Intent().setComponent(new ComponentName("com.coloros.oppoguardelf", "com.coloros.powermanager.fuelgaue.PowerSaverModeActivity"));
        intentArr[6] = new Intent().setComponent(new ComponentName("com.coloros.oppoguardelf", "com.coloros.powermanager.fuelgaue.PowerConsumptionActivity"));
        intentArr[7] = new Intent().setComponent(new ComponentName("com.coloros.safecenter", "com.coloros.safecenter.permission.startup.StartupAppListActivity"));
        intentArr[8] = Build.VERSION.SDK_INT >= 24 ? new Intent().setComponent(new ComponentName("com.coloros.safecenter", "com.coloros.safecenter.startupapp.StartupAppListActivity")).setAction("android.settings.REQUEST_IGNORE_BATTERY_OPTIMIZATIONS").setData(Uri.parse("package:pt.opt.anda")) : null;
        intentArr[9] = new Intent().setComponent(new ComponentName("com.oppo.safe", "com.oppo.safe.permission.startup.StartupAppListActivity"));
        intentArr[10] = new Intent().setComponent(new ComponentName("com.iqoo.secure", "com.iqoo.secure.ui.phoneoptimize.AddWhiteListActivity"));
        intentArr[11] = new Intent().setComponent(new ComponentName("com.iqoo.secure", "com.iqoo.secure.ui.phoneoptimize.BgStartUpManager"));
        intentArr[12] = new Intent().setComponent(new ComponentName("com.vivo.permissionmanager", "com.vivo.permissionmanager.activity.BgStartUpManagerActivity"));
        intentArr[13] = new Intent().setComponent(new ComponentName("com.asus.mobilemanager", "com.asus.mobilemanager.MainActivity"));
        intentArr[14] = new Intent().setComponent(new ComponentName("com.asus.mobilemanager", "com.asus.mobilemanager.entry.FunctionActivity"));
        intentArr[15] = new Intent().setComponent(new ComponentName("com.asus.mobilemanager", "com.asus.mobilemanager.autostart.AutoStartActivity"));
        intentArr[16] = new Intent().setComponent(new ComponentName("com.letv.android.letvsafe", "com.letv.android.letvsafe.AutobootManageActivity")).setData(Uri.parse("mobilemanager://function/entry/AutoStart"));
        intentArr[17] = new Intent().setComponent(new ComponentName("com.meizu.safe", "com.meizu.safe.security.SHOW_APPSEC")).addCategory("android.intent.category.DEFAULT").putExtra("packageName", "pt.opt.anda");
        L = intentArr;
    }

    public c(Context context) {
        this.r = false;
        this.E = false;
        try {
            context.openFileInput("testMode");
        } catch (FileNotFoundException unused) {
        }
        this.K = context;
        this.E = w();
        int availableProcessors = Runtime.getRuntime().availableProcessors();
        this.F = new ThreadPoolExecutor(availableProcessors, availableProcessors, 120L, TimeUnit.SECONDS, new LinkedBlockingQueue());
        if (a.b.g.b.b.a(context, "android.permission.READ_PHONE_STATE") == 0) {
            h();
        }
        this.n = new h.b.a.d.b0.i(this, context);
        this.H = (DownloadManager) context.getSystemService("download");
        this.q = new C0155c();
        context.registerReceiver(this.q, new IntentFilter("android.intent.action.DOWNLOAD_COMPLETE"));
        this.r = true;
    }

    public static Context W() {
        c cVar = M;
        if (cVar == null) {
            return null;
        }
        return cVar.K;
    }

    public static c X() {
        return M;
    }

    public boolean C() {
        return this.x;
    }

    public boolean D() {
        return this.t;
    }

    public final void E() {
        if (this.z) {
            Log.d("Anda", "Leaving power saving mode...");
            this.z = false;
            O();
        }
    }

    public final void F() {
        O();
        for (h.b.a.d.f fVar : this.f6879c) {
            fVar.a(f.b.bluetooth);
        }
    }

    public final void G() {
        this.A = false;
        this.C = false;
        this.B = false;
        O();
        f.a aVar = new f.a(f.a.EnumC0164a.hceOff, "", "");
        this.D = aVar;
        for (h.b.a.d.f fVar : this.f6879c) {
            fVar.a(aVar);
        }
    }

    public final void H() {
        this.A = true;
        this.B = false;
        this.C = false;
        this.D = null;
        O();
        for (h.b.a.d.f fVar : this.f6879c) {
            fVar.a(f.b.hce);
        }
    }

    public final void I() {
        this.E = true;
        O();
        for (h.b.a.d.f fVar : this.f6879c) {
            fVar.a(f.b.internet);
        }
    }

    public final void J() {
        O();
        for (h.b.a.d.f fVar : this.f6879c) {
            fVar.a(f.b.location);
        }
    }

    public final void K() {
        O();
        for (h.b.a.d.f fVar : this.f6879c) {
            fVar.a(f.b.nfc);
        }
    }

    public void L() {
        O();
    }

    public final void M() {
        Log.d("Anda", "Preparing ongoingTrip start...");
        this.x = true;
        if (Build.VERSION.SDK_INT >= 26) {
            Context context = this.K;
            context.startForegroundService(new Intent(context, TripControllerService.class));
        } else {
            Context context2 = this.K;
            context2.startService(new Intent(context2, TripControllerService.class));
        }
        S();
    }

    public void N() {
        if (!this.w) {
            this.v = false;
            h();
            return;
        }
        Log.d("Anda", "Already fetching data...");
    }

    public void O() {
        if (this.u && !this.x && !A()) {
            S();
            return;
        }
        Log.w("Anda", "refreshLookup() called but blocked");
        Log.w("Anda", "readyToUseBeacons==" + this.u + ", startingTrip==" + this.x + ", isOnTrip==" + A());
        c.b.a.a.a(5, "Invalid state", "refreshLookup() called but readyToUseBeacons==" + this.u + ", startingTrip==" + this.x + ", isOnTrip==" + A());
    }

    public final void P() {
        if (this.f6884h) {
            return;
        }
        this.f6885i = new d();
        this.f6884h = true;
    }

    public final void Q() {
        this.o = new a();
    }

    public final void R() {
        if (this.f6882f) {
            return;
        }
        BackEnd.addListeners(this.J);
        this.f6882f = true;
    }

    public final void S() {
        if (this.p != null) {
            for (n nVar : this.f6878b) {
                nVar.f();
            }
            this.p.f6931b.clear();
        }
    }

    public final void T() {
        if (!this.u || this.x || A()) {
            Log.w("Anda", "startLookingForTripStarters() called but blocked");
            Log.w("Anda", "readyToUseBeacons==" + this.u + ", startingTrip==" + this.x + ", isOnTrip==" + A());
        }
    }

    public void U() {
        BroadcastReceiver broadcastReceiver = this.q;
        if (broadcastReceiver == null || !this.r) {
            return;
        }
        try {
            this.K.unregisterReceiver(broadcastReceiver);
            this.r = false;
        } catch (Exception unused) {
            Log.d("Anda", "unregisterDownloadCompletedReceiver: failed to unregister onDownloadCompleted receiver");
        }
    }

    public final void V() {
        Vibrator vibrator;
        if (PreferenceManager.getDefaultSharedPreferences(this.K).getBoolean("vibration_alerts", false) && (vibrator = (Vibrator) this.K.getSystemService("vibrator")) != null && vibrator.hasVibrator()) {
            long[] jArr = {0, 100, 150, 200};
            if (Build.VERSION.SDK_INT >= 26) {
                NotificationManager notificationManager = (NotificationManager) this.K.getSystemService("notification");
                NotificationChannel notificationChannel = notificationManager != null ? notificationManager.getNotificationChannel(this.K.getString(2131755063)) : null;
                if (notificationChannel == null || notificationChannel.shouldVibrate() || notificationChannel.getImportance() > 2) {
                    return;
                }
                vibrator.vibrate(VibrationEffect.createWaveform(jArr, -1));
                return;
            }
            vibrator.vibrate(jArr, -1);
        }
    }

    public void finalize() {
        Log.d("Anda", "Anda manager exiting...");
        if (this.f6878b.size() > 0 || this.f6877a.size() > 0 || this.f6879c.size() > 0) {
            Log.e("Anda", "There are listeners left to release!");
        }
        super.finalize();
    }

    @Override // pt.card4b.backendbeacons.BackendListeners.BaseRequestListener
    public void onError(DataModels.Error error) {
        Log.e("Anda", "Backend:Error(" + error.getMessage() + "):" + error.getMessageToUser());
        DataModels.Error.ErrorType type = error.getType();
        if (type == DataModels.Error.ErrorType.BLUETOOTH_DISABLED || type == DataModels.Error.ErrorType.LOCATION_DISABLED || type == DataModels.Error.ErrorType.NFC_DISABLED) {
            S();
        } else if (type != DataModels.Error.ErrorType.LOCATION_PERMISSION) {
            c.b.a.a.a((Throwable) new Exception("Error:" + type.toString() + ": " + error.getMessage()));
        }
        if (type != DataModels.Error.ErrorType.STAGE_ALREADY_STARTED) {
            a(h.b.a.d.b0.b.a(error));
        }
    }

    @Override // pt.card4b.backendbeacons.BackendListeners.PossibleStopListener
    public void onReceiveStop(DataModels.StopInfo stopInfo) {
        Log.d("Anda:Trip:Backend", "onReceiveStop() called with: stageInfo = [" + stopInfo.getKey() + ", " + stopInfo.getLineName() + "]");
        if (this.p == null) {
            this.p = new h.b.a.d.b0.f();
        }
        List<m> list = this.p.f6931b;
        String stopCode = stopInfo.getStopCode();
        for (m mVar : list) {
            if ((stopCode == null && ((h.b.a.d.b0.e) mVar).h().getStopName().equals(stopInfo.getStopName())) || (stopCode != null && stopCode.equals(((h.b.a.d.b0.e) mVar).h().getStopCode()))) {
                ((h.b.a.d.b0.e) mVar).a(stopInfo);
                for (n nVar : this.f6878b) {
                    nVar.b(mVar);
                }
                return;
            }
        }
        h.b.a.d.b0.e eVar = new h.b.a.d.b0.e(stopInfo);
        list.add(eVar);
        for (n nVar2 : this.f6878b) {
            nVar2.a(eVar);
        }
    }

    @Override // pt.card4b.backendbeacons.BackendListeners.PossibleStopListener
    public void onRemoveStops(List<DataModels.StopInfo> list) {
        Log.d("Anda:Trip:Backend", "onRemoveStops() called with: arrayList = [" + list.size() + "]");
        h.b.a.d.b0.f fVar = this.p;
        if (fVar == null) {
            Log.w("Anda:Trip", "onRemoveStops() called but we're not keeping track of available stops");
            return;
        }
        List<m> list2 = fVar.f6931b;
        int i2 = 0;
        while (i2 < list2.size()) {
            h.b.a.d.b0.e eVar = (h.b.a.d.b0.e) list2.get(i2);
            if (eVar.f()) {
                if (eVar.a(list)) {
                    eVar.b(list);
                    if (eVar.i()) {
                        i2--;
                        list2.remove(eVar);
                        for (n nVar : this.f6878b) {
                            nVar.c(eVar);
                        }
                    } else {
                        for (n nVar2 : this.f6878b) {
                            nVar2.b(eVar);
                        }
                    }
                }
            } else {
                String key = eVar.h().getKey();
                for (DataModels.StopInfo stopInfo : list) {
                    if (key.equals(stopInfo.getKey())) {
                        i2--;
                        list2.remove(eVar);
                        for (n nVar3 : this.f6878b) {
                            nVar3.c(eVar);
                        }
                    }
                }
            }
            i2++;
        }
    }

    @Override // java.lang.Runnable
    public void run() {
        N();
    }

    public boolean A() {
        return this.o != null;
    }

    public boolean B() {
        return this.s;
    }

    public List<m> l() {
        if (this.u && !this.x) {
            if (this.p == null) {
                this.p = new h.b.a.d.b0.f();
                if (!A()) {
                    T();
                }
            }
            return this.p.f6931b;
        }
        if (!this.u) {
            this.y = true;
        }
        Log.w("Anda", "getNearbyStations() called but blocked");
        Log.w("Anda", "readyToUseBeacons==" + this.u + ", startingTrip==" + this.x + ", isOnTrip==" + A());
        return new ArrayList(0);
    }

    public o m() {
        return this.o;
    }

    public Intent[] n() {
        return L;
    }

    public u o() {
        return this.n;
    }

    public boolean p() {
        return this.v;
    }

    public boolean q() {
        PowerManager powerManager;
        if (Build.VERSION.SDK_INT < 23 || (powerManager = (PowerManager) this.K.getSystemService("power")) == null) {
            return true;
        }
        return powerManager.isIgnoringBatteryOptimizations(this.K.getPackageName());
    }

    @SuppressLint({"MissingPermission"})
    public boolean r() {
        BluetoothAdapter defaultAdapter = BluetoothAdapter.getDefaultAdapter();
        return defaultAdapter != null && defaultAdapter.isEnabled();
    }

    public boolean s() {
        return this.w;
    }

    public final boolean t() {
        return this.C;
    }

    public final boolean u() {
        return this.A;
    }

    public boolean v() {
        return this.B;
    }

    public final boolean w() {
        NetworkInfo activeNetworkInfo = ((ConnectivityManager) Objects.requireNonNull((ConnectivityManager) this.K.getSystemService("connectivity"))).getActiveNetworkInfo();
        return activeNetworkInfo != null && activeNetworkInfo.isConnectedOrConnecting();
    }

    public boolean x() {
        return this.E;
    }

    public boolean y() {
        LocationManager locationManager = (LocationManager) this.K.getSystemService("location");
        return locationManager != null && locationManager.isProviderEnabled("network");
    }

    public boolean z() {
        NfcAdapter defaultAdapter;
        NfcManager nfcManager = (NfcManager) this.K.getSystemService("nfc");
        return (nfcManager == null || (defaultAdapter = nfcManager.getDefaultAdapter()) == null || !defaultAdapter.isEnabled()) ? false : true;
    }

    public void c(h.b.a.d.a aVar) {
        if (this.f6880d.contains(aVar)) {
            this.f6880d.remove(aVar);
        }
    }

    public void d() {
        for (h.b.a.d.a aVar : this.f6880d) {
            aVar.b();
        }
    }

    public void e() {
        this.C = true;
        BackEnd.disableHCEValidation(new j());
    }

    public final void f() {
        if (this.A || this.B) {
            return;
        }
        this.B = true;
        for (h.b.a.d.f fVar : this.f6879c) {
            fVar.b(f.b.hce);
        }
        BackEnd.enableHCEValidation(new i());
    }

    public void g() {
        if (this.z) {
            return;
        }
        if (this.u && !this.x && !A()) {
            Log.d("Anda", "Entering in power saving mode...");
            this.z = true;
            BackEnd.stopBeaconService();
            S();
            return;
        }
        Log.d("Anda", "Will enter in power saving mode as soon as possible");
        this.z = true;
    }

    public final void h() {
        Log.d("Anda", "Fetching data...");
        this.w = true;
        BackEnd.doInitialConfiguration(this.I);
    }

    public Locale i() {
        return a.b.g.g.a.a(this.K.getResources().getConfiguration()).a(0);
    }

    public f.a j() {
        return this.D;
    }

    public String k() {
        return PreferenceManager.getDefaultSharedPreferences(this.K).getString("lastUsername", null);
    }

    public void b(o.c cVar) {
        if (this.f6877a.remove(cVar)) {
            Log.d("Anda", "Listener " + cVar + " removed");
        }
    }

    @Override // h.b.a.d.o.c
    public void c(o oVar) {
        for (o.c cVar : this.f6877a) {
            cVar.c(oVar);
        }
    }

    @Override // h.b.a.d.o.c
    public void d(o oVar) {
        Log.d("Anda:Trip", "onTripStarted() called with: ongoingTrip = [" + oVar + "]");
        this.x = false;
        this.o = oVar;
        E();
        for (o.c cVar : this.f6877a) {
            cVar.d(oVar);
        }
        this.u = true;
        V();
    }

    public void b(n nVar) {
        this.f6878b.remove(nVar);
    }

    public Intent[] a(Context context) {
        return new Intent[]{new Intent().setComponent(new ComponentName("com.miui.powerkeeper", "com.miui.powerkeeper.ui.HiddenAppsConfigActivity")).putExtra("package_name", context.getPackageName()).putExtra("package_label", context.getString(2131755064))};
    }

    public void b(h.b.a.d.a aVar) {
        this.f6881e = aVar;
    }

    public void c() {
        if (this.n.a() && this.s) {
            if (!u() && !v() && y() && z() && r() && q()) {
                f();
                return;
            }
            if (!q()) {
                BackEnd.addToLog("checkServicesAndEnableHCE: app not excluded from battery optimizations. Disabling HCE!");
                e();
            }
            BackEnd.addToLog(String.format("checkServicesAndEnableHCE:: isHceEnabled: %b, isHceEnabling: %b, isLocationOn: %b, isNfcOn: %b, isBluetoothOn: %b", Boolean.valueOf(u()), Boolean.valueOf(v()), Boolean.valueOf(y()), Boolean.valueOf(z()), Boolean.valueOf(r())));
            return;
        }
        BackEnd.addToLog(String.format("checkServicesAndEnableHCE:: isLoggedIn: %b, readyToUse: %b", Boolean.valueOf(this.n.a()), Boolean.valueOf(this.s)));
    }

    public void b(h.b.a.d.f fVar) {
        this.f6879c.remove(fVar);
    }

    public void b(h.b.a.d.e eVar) {
        BackEnd.getLanguages(new e(this, eVar));
    }

    @Override // h.b.a.d.o.c
    public void b(o oVar) {
        for (o.c cVar : this.f6877a) {
            cVar.b(oVar);
        }
    }

    public void a(boolean z) {
        this.t = z;
    }

    public void a(h.b.a.d.j jVar) {
        this.m = jVar;
    }

    public final void b() {
        if (!u() || t()) {
            return;
        }
        if (y() && z() && r() && q()) {
            return;
        }
        e();
    }

    public void a(o.c cVar) {
        if (this.f6877a.contains(cVar)) {
            return;
        }
        this.f6877a.add(cVar);
    }

    public static c b(Context context) {
        if (M == null) {
            M = new c(context);
        }
        return M;
    }

    public void a(n nVar) {
        if (this.f6878b.contains(nVar)) {
            return;
        }
        this.f6878b.add(nVar);
    }

    public void a(h.b.a.d.f fVar) {
        if (this.f6879c.contains(fVar)) {
            return;
        }
        this.f6879c.add(fVar);
    }

    public void a(h.b.a.d.a aVar) {
        if (this.f6880d.contains(aVar)) {
            return;
        }
        this.f6880d.add(aVar);
    }

    public final void a(List<DataModels.StopInfo> list) {
        if (list.size() > 0) {
            this.j = new h.b.a.d.b0.d(list.get(0));
        }
        for (DataModels.StopInfo stopInfo : list) {
            Date datetime = stopInfo.getDatetime();
            if (this.f6883g.size() == 0) {
                if (stopInfo.getValidationDatetime() != null) {
                    datetime = stopInfo.getValidationDatetime();
                } else {
                    BackEnd.addToLog(String.format("[%s] getValidationDatetime() is null. getDatetime() will be used instead.", "Anda"));
                }
            }
            if (datetime == null) {
                BackEnd.addToLog(String.format(Locale.getDefault(), "[%s] tipPassings = %d, stopName = %s, operator = %s", "Anda", Integer.valueOf(this.f6883g.size()), stopInfo.getStopName(), stopInfo.getOperatorName()));
            }
            if (stopInfo.getDatetime() == null && stopInfo.getValidationDatetime() == null) {
                BackEnd.addToLog(String.format(Locale.getDefault(), "[%s] Both getDatetime() and getValidationDatetime() are null. Setting time to current time.", "Anda"));
                datetime = Calendar.getInstance().getTime();
            }
            h.b.a.d.b0.h hVar = new h.b.a.d.b0.h(new h.b.a.d.b0.j(stopInfo), datetime);
            this.f6883g.add(hVar);
            a(this.o, hVar);
        }
    }

    public Snackbar a(String str, int i2) {
        return this.f6881e.a(str, i2);
    }

    public void a(h.b.a.d.e eVar) {
        BackEnd.getCountries(new f(this, eVar));
    }

    public void a(h.b.a.d.g gVar) {
        BackEnd.getCardInfo(new g(this, gVar));
    }

    @Override // h.b.a.d.o.c
    public void a(o oVar, q qVar) {
        Log.d("Anda:Trip", "onStopReached() called with: ongoingTrip = [" + oVar + "], passing = [" + qVar + "]");
        if (oVar != this.o) {
            c.b.a.a.a((Throwable) new RuntimeException(new IllegalStateException("Wrong ongoingTrip (" + oVar + ") ending, it should be " + this.o + ".")));
        }
        for (o.c cVar : this.f6877a) {
            cVar.a(oVar, qVar);
        }
    }

    @Override // h.b.a.d.o.c
    public void a(o oVar, o.a aVar) {
        Log.d("Anda:Trip", "onTripEnded() called with: ongoingTrip = [" + oVar + "]");
        if (oVar != this.o) {
            c.b.a.a.a((Throwable) new RuntimeException(new IllegalStateException("Wrong ongoingTrip (" + oVar + ") ending, it should be " + this.o + ".")));
        }
        try {
            w b2 = oVar.b();
            c.b.a.b.k kVar = new c.b.a.b.k("Trip Ended");
            kVar.a("Stop Count", Integer.valueOf(b2.l()));
            c.b.a.b.k kVar2 = kVar;
            kVar2.a("Duration (minutes)", Long.valueOf((b2.f().a() - b2.e()) / 60000));
            c.b.a.b.k kVar3 = kVar2;
            kVar3.a("Vehicle Type", z.a(b2.i()));
            c.b.a.b.k kVar4 = kVar3;
            p b3 = b2.b();
            if (b3 != null) {
                kVar4.a("Operator", b3.a());
            }
            c.b.a.b.a.p().a(kVar4);
        } catch (Exception e2) {
            c.b.a.a.a((Throwable) e2);
        }
        this.o = null;
        this.f6883g.clear();
        if (this.p == null) {
            this.p = new h.b.a.d.b0.f();
        } else {
            S();
        }
        if (!aVar.a()) {
            O();
        }
        for (o.c cVar : this.f6877a) {
            cVar.a(oVar, aVar);
        }
    }

    @Override // h.b.a.d.o.c
    public void a(o oVar) {
        for (o.c cVar : this.f6877a) {
            cVar.a(oVar);
        }
    }

    @Override // h.b.a.d.o.c
    public void a(o oVar, o.c.a aVar) {
        for (o.c cVar : this.f6877a) {
            cVar.a(oVar, aVar);
        }
    }

    @Override // h.b.a.d.o.c
    public void a(o oVar, f.a aVar) {
        this.x = false;
        c.b.a.a.a((Throwable) new Exception("Error:Trip:" + aVar.b().toString() + ": " + aVar.a()));
        O();
        for (o.c cVar : this.f6877a) {
            cVar.a(oVar, aVar);
        }
        a(aVar);
    }

    public final void a(f.a aVar) {
        for (h.b.a.d.f fVar : this.f6879c) {
            fVar.a(aVar);
        }
    }

    public void a(String str) {
        if (URLUtil.isValidUrl(str)) {
            Uri parse = Uri.parse(str);
            String guessFileName = URLUtil.guessFileName(str, null, null);
            if (guessFileName.endsWith(".pdf")) {
                DownloadManager.Request request = new DownloadManager.Request(parse);
                request.setAllowedOverRoaming(false);
                request.setTitle(parse.getLastPathSegment());
                request.setAllowedNetworkTypes(3);
                request.setVisibleInDownloadsUi(true);
                String str2 = Environment.DIRECTORY_DOWNLOADS;
                request.setDestinationInExternalPublicDir(str2, "/Anda/Invoices/" + guessFileName);
                DownloadManager downloadManager = this.H;
                if (downloadManager != null) {
                    downloadManager.enqueue(request);
                }
            }
        }
    }

    public void a() {
        if (this.s) {
            BackEnd.hasOngoingStage(new b());
        }
    }

    public void a(Runnable runnable) {
        this.F.execute(runnable);
    }

    public void a(a.b.g.a.g gVar, boolean z) {
        if (Build.VERSION.SDK_INT >= 21) {
            Window window = gVar.getWindow();
            if (z) {
                window.setFlags(67108864, 67108864);
            } else {
                window.clearFlags(67108864);
            }
        }
    }
}
