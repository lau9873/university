package p205h.p208b.p209a;

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
import com.hbb20.C1444R;
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
import p000a.p006b.p030g.p031a.FragmentActivity;
import p000a.p006b.p030g.p032b.ContextCompat;
import p000a.p006b.p030g.p041g.ConfigurationCompat;
import p070c.p074b.p075a.Crashlytics;
import p070c.p074b.p075a.p076b.Answers;
import p070c.p074b.p075a.p076b.CustomEvent;
import p205h.p208b.p209a.Anda;
import p205h.p208b.p209a.p210d.AndaActionsListener;
import p205h.p208b.p209a.p210d.CountriesListener;
import p205h.p208b.p209a.p210d.ErrorListener;
import p205h.p208b.p209a.p210d.HceCardInfoListener;
import p205h.p208b.p209a.p210d.InvoiceDownloadListener;
import p205h.p208b.p209a.p210d.Line;
import p205h.p208b.p209a.p210d.NearbyStation;
import p205h.p208b.p209a.p210d.NearbyStationListener;
import p205h.p208b.p209a.p210d.OngoingTrip;
import p205h.p208b.p209a.p210d.Operator;
import p205h.p208b.p209a.p210d.Passing;
import p205h.p208b.p209a.p210d.Session;
import p205h.p208b.p209a.p210d.Trip;
import p205h.p208b.p209a.p210d.VehicleTypes;
import p205h.p208b.p209a.p210d.p211b0.TipErrorConverter;
import p205h.p208b.p209a.p210d.p211b0.TipLine;
import p205h.p208b.p209a.p210d.p211b0.TipNearbyStation;
import p205h.p208b.p209a.p210d.p211b0.TipNearbyStations;
import p205h.p208b.p209a.p210d.p211b0.TipOperators;
import p205h.p208b.p209a.p210d.p211b0.TipPassing;
import p205h.p208b.p209a.p210d.p211b0.TipSession;
import p205h.p208b.p209a.p210d.p211b0.TipStop;
import pt.card4b.backendbeacons.BackEnd;
import pt.card4b.backendbeacons.BackendListeners;
import pt.card4b.backendbeacons.DataModels;
import pt.opt.anda.TripControllerService;

/* renamed from: h.b.a.c */
/* loaded from: classes.dex */
public class Anda implements OngoingTrip.InterfaceC2364c, BackendListeners.PossibleStopListener, Runnable {

    /* renamed from: L */
    public static final Intent[] f9478L;
    @SuppressLint({"StaticFieldLeak"})

    /* renamed from: M */
    public static Anda f9479M;

    /* renamed from: D */
    public ErrorListener.C2358a f9483D;

    /* renamed from: E */
    public boolean f9484E;

    /* renamed from: F */
    public final ThreadPoolExecutor f9485F;

    /* renamed from: H */
    public final DownloadManager f9487H;

    /* renamed from: K */
    public Context f9490K;

    /* renamed from: e */
    public AndaActionsListener f9495e;

    /* renamed from: i */
    public Trip f9499i;

    /* renamed from: j */
    public Line f9500j;

    /* renamed from: k */
    public OngoingTrip.InterfaceC2364c.AbstractRunnableC2365a f9501k;

    /* renamed from: m */
    public InvoiceDownloadListener f9502m;

    /* renamed from: n */
    public final Session f9503n;

    /* renamed from: o */
    public OngoingTrip f9504o;

    /* renamed from: p */
    public TipNearbyStations f9505p;

    /* renamed from: q */
    public BroadcastReceiver f9506q;

    /* renamed from: r */
    public boolean f9507r;

    /* renamed from: a */
    public final List<OngoingTrip.InterfaceC2364c> f9491a = new ArrayList(4);

    /* renamed from: b */
    public final List<NearbyStationListener> f9492b = new ArrayList(1);

    /* renamed from: c */
    public final List<ErrorListener> f9493c = new ArrayList(3);

    /* renamed from: d */
    public final List<AndaActionsListener> f9494d = new ArrayList();

    /* renamed from: f */
    public boolean f9496f = false;

    /* renamed from: g */
    public final List<TipPassing> f9497g = new ArrayList();

    /* renamed from: h */
    public boolean f9498h = false;

    /* renamed from: s */
    public boolean f9508s = false;

    /* renamed from: t */
    public boolean f9509t = false;

    /* renamed from: u */
    public boolean f9510u = false;

    /* renamed from: v */
    public boolean f9511v = true;

    /* renamed from: w */
    public boolean f9512w = false;

    /* renamed from: x */
    public boolean f9513x = false;

    /* renamed from: y */
    public boolean f9514y = false;

    /* renamed from: z */
    public boolean f9515z = true;

    /* renamed from: A */
    public boolean f9480A = false;

    /* renamed from: B */
    public boolean f9481B = false;

    /* renamed from: C */
    public boolean f9482C = false;

    /* renamed from: G */
    public boolean f9486G = true;

    /* renamed from: I */
    public final BackendListeners.InitialConfigurationRequestListener f9488I = new C2272h();

    /* renamed from: J */
    public final BackendListeners.StageStopListener f9489J = new C2275k();

    /* compiled from: Anda.java */
    /* renamed from: h.b.a.c$a */
    /* loaded from: classes.dex */
    public class C2263a implements OngoingTrip {

        /* compiled from: Anda.java */
        /* renamed from: h.b.a.c$a$a */
        /* loaded from: classes.dex */
        public class C2264a implements BackendListeners.FinishStageRequestListener {
            public C2264a(C2263a c2263a) {
            }

            @Override // pt.card4b.backendbeacons.BackendListeners.BaseRequestListener
            public void onError(DataModels.Error error) {
                Log.e("Anda", "registerOngoingTrip(): ongoingTrip.end() called with error:" + error.getMessage() + ": " + error.getMessageToUser());
            }

            @Override // pt.card4b.backendbeacons.BackendListeners.FinishStageRequestListener
            public void onSuccess() {
            }
        }

        public C2263a() {
        }

        @Override // p205h.p208b.p209a.p210d.OngoingTrip
        /* renamed from: a */
        public OngoingTrip.InterfaceC2364c.AbstractRunnableC2365a mo1301a() {
            return Anda.this.f9501k;
        }

        @Override // p205h.p208b.p209a.p210d.OngoingTrip
        /* renamed from: b */
        public Trip mo1300b() {
            return Anda.this.f9499i;
        }

        @Override // p205h.p208b.p209a.p210d.OngoingTrip
        /* renamed from: c */
        public OngoingTrip.InterfaceC2363b mo1299c() {
            BackEnd.finishStage(new C2264a(this));
            return null;
        }
    }

    /* compiled from: Anda.java */
    /* renamed from: h.b.a.c$b */
    /* loaded from: classes.dex */
    public class C2265b implements BackendListeners.HasOngoingStageListener {
        public C2265b() {
        }

        @Override // pt.card4b.backendbeacons.BackendListeners.BaseRequestListener
        public void onError(DataModels.Error error) {
            if (error.getType() == DataModels.Error.ErrorType.LOGIN_REQUIRED) {
                Anda.this.f9503n.mo1276c();
            }
            if (error.getType() != DataModels.Error.ErrorType.STAGE_ALREADY_STARTED) {
                Anda.this.m1455a(TipErrorConverter.m1372a(error));
            }
        }

        @Override // pt.card4b.backendbeacons.BackendListeners.HasOngoingStageListener
        public void onSuccess(boolean z) {
            if (z) {
                Anda.this.m1478M();
                BackEnd.resumeStage(Anda.this.f9489J);
                return;
            }
            Anda.this.f9510u = true;
            if (Anda.this.f9515z) {
                return;
            }
            Anda.this.m1406l();
        }
    }

    /* compiled from: Anda.java */
    /* renamed from: h.b.a.c$c */
    /* loaded from: classes.dex */
    public class C2266c extends BroadcastReceiver {
        public C2266c() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            Bundle extras = intent.getExtras();
            DownloadManager.Query query = new DownloadManager.Query();
            if (extras != null) {
                query.setFilterById(extras.getLong("extra_download_id"));
            }
            if (Anda.this.f9487H != null) {
                Cursor query2 = Anda.this.f9487H.query(query);
                if (query2.moveToFirst() && query2.getInt(query2.getColumnIndex("status")) == 8) {
                    File file = new File(query2.getString(query2.getColumnIndex("local_uri")));
                    File externalStoragePublicDirectory = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS);
                    File file2 = new File(externalStoragePublicDirectory, "/Anda/Invoices/" + file.getName());
                    long longExtra = intent.getLongExtra("extra_download_id", -1L);
                    Log.d("Anda", "onDownloadCompleted: completed download with ID " + String.valueOf(longExtra));
                    if (Anda.this.f9502m != null) {
                        Anda.this.f9502m.mo986a(longExtra, file2.getAbsolutePath());
                    }
                }
            }
        }
    }

    /* compiled from: Anda.java */
    /* renamed from: h.b.a.c$d */
    /* loaded from: classes.dex */
    public class C2267d implements Trip {

        /* compiled from: Anda.java */
        /* renamed from: h.b.a.c$d$a */
        /* loaded from: classes.dex */
        public class C2268a implements Iterator<Passing> {

            /* renamed from: a */
            public int f9520a = 0;

            public C2268a() {
            }

            @Override // java.util.Iterator
            public boolean hasNext() {
                return this.f9520a < Anda.this.f9497g.size();
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // java.util.Iterator
            public Passing next() {
                List list = Anda.this.f9497g;
                int i = this.f9520a;
                this.f9520a = i + 1;
                return (Passing) list.get(i);
            }
        }

        public C2267d() {
        }

        @Override // p205h.p208b.p209a.p210d.Trip
        /* renamed from: a */
        public Passing mo1264a(int i) {
            return (Passing) Anda.this.f9497g.get(i);
        }

        @Override // p205h.p208b.p209a.p210d.Trip
        /* renamed from: b */
        public Operator mo1263b() {
            if (Anda.this.f9500j == null) {
                if (Anda.this.f9497g.size() == 0) {
                    return null;
                }
                return TipOperators.m1365a(((TipPassing) Anda.this.f9497g.get(0)).mo1285d().m1332h().getOperatorRef());
            }
            return Anda.this.f9500j.mo1312b();
        }

        @Override // p205h.p208b.p209a.p210d.Trip
        /* renamed from: c */
        public Passing mo1262c() {
            if (Anda.this.f9497g.size() > 0) {
                return (Passing) Anda.this.f9497g.get(0);
            }
            return null;
        }

        @Override // p205h.p208b.p209a.p210d.Trip
        /* renamed from: d */
        public String mo1261d() {
            return "";
        }

        @Override // p205h.p208b.p209a.p210d.Trip
        /* renamed from: e */
        public long mo1260e() {
            Passing mo1262c = mo1262c();
            if (mo1262c == null) {
                return -1L;
            }
            return mo1262c.mo1286a();
        }

        @Override // p205h.p208b.p209a.p210d.Trip
        /* renamed from: f */
        public Passing mo1259f() {
            int size = Anda.this.f9497g.size();
            if (size > 0) {
                return (Passing) Anda.this.f9497g.get(size - 1);
            }
            return null;
        }

        @Override // p205h.p208b.p209a.p210d.Trip
        /* renamed from: g */
        public boolean mo1258g() {
            return false;
        }

        @Override // p205h.p208b.p209a.p210d.Trip
        /* renamed from: h */
        public Line mo1257h() {
            return Anda.this.f9500j;
        }

        @Override // p205h.p208b.p209a.p210d.Trip
        /* renamed from: i */
        public int mo1256i() {
            return mo1262c().mo1285d().getType();
        }

        @Override // java.lang.Iterable
        public Iterator<Passing> iterator() {
            return new C2268a();
        }

        @Override // p205h.p208b.p209a.p210d.Trip
        /* renamed from: j */
        public Passing mo1255j() {
            return null;
        }

        @Override // p205h.p208b.p209a.p210d.Trip
        /* renamed from: k */
        public Passing mo1254k() {
            return null;
        }

        @Override // p205h.p208b.p209a.p210d.Trip
        /* renamed from: l */
        public int mo1253l() {
            return Anda.this.f9497g.size();
        }

        @Override // p205h.p208b.p209a.p210d.Trip
        /* renamed from: m */
        public Date mo1252m() {
            return new Date(((TipPassing) Anda.this.f9497g.get(0)).mo1286a());
        }
    }

    /* compiled from: Anda.java */
    /* renamed from: h.b.a.c$e */
    /* loaded from: classes.dex */
    public class C2269e implements BackendListeners.GetLanguagesListener {

        /* renamed from: a */
        public final /* synthetic */ CountriesListener f9522a;

        public C2269e(Anda anda, CountriesListener countriesListener) {
            this.f9522a = countriesListener;
        }

        @Override // pt.card4b.backendbeacons.BackendListeners.BaseRequestListener
        public void onError(DataModels.Error error) {
            Log.w("Anda", String.format("Anda.getAvailableLanguages called with onError. Message is %s", error.getMessageToUser()));
            this.f9522a.mo738a(new ArrayList());
        }

        @Override // pt.card4b.backendbeacons.BackendListeners.GetLanguagesListener
        public void onSuccess(List<DataModels.Language> list) {
            this.f9522a.mo738a(list);
        }
    }

    /* compiled from: Anda.java */
    /* renamed from: h.b.a.c$f */
    /* loaded from: classes.dex */
    public class C2270f implements BackendListeners.GetCountriesListener {

        /* renamed from: a */
        public final /* synthetic */ CountriesListener f9523a;

        public C2270f(Anda anda, CountriesListener countriesListener) {
            this.f9523a = countriesListener;
        }

        @Override // pt.card4b.backendbeacons.BackendListeners.BaseRequestListener
        public void onError(DataModels.Error error) {
            Log.w("Anda", String.format("Anda.getAvailableCountries called with onError. Message is %s", error.getMessageToUser()));
            this.f9523a.mo737b(new ArrayList());
        }

        @Override // pt.card4b.backendbeacons.BackendListeners.GetCountriesListener
        public void onSuccess(List<DataModels.Country> list) {
            this.f9523a.mo737b(list);
        }
    }

    /* compiled from: Anda.java */
    /* renamed from: h.b.a.c$g */
    /* loaded from: classes.dex */
    public class C2271g implements BackendListeners.GetCardInfoListener {

        /* renamed from: a */
        public final /* synthetic */ HceCardInfoListener f9524a;

        public C2271g(Anda anda, HceCardInfoListener hceCardInfoListener) {
            this.f9524a = hceCardInfoListener;
        }

        @Override // pt.card4b.backendbeacons.BackendListeners.BaseRequestListener
        public void onError(DataModels.Error error) {
            this.f9524a.mo888a(error);
        }

        @Override // pt.card4b.backendbeacons.BackendListeners.GetCardInfoListener
        public void onSucess(DataModels.CardInfo cardInfo) {
            this.f9524a.mo889a(cardInfo.getSerialNumber());
        }
    }

    /* compiled from: Anda.java */
    /* renamed from: h.b.a.c$h */
    /* loaded from: classes.dex */
    public class C2272h implements BackendListeners.InitialConfigurationRequestListener {
        public C2272h() {
        }

        /* renamed from: a */
        public /* synthetic */ void m1376a() {
            Anda.this.f9509t = true;
            Anda.this.m1466a();
            Anda.this.m1434c();
        }

        @Override // pt.card4b.backendbeacons.BackendListeners.BaseRequestListener
        public void onError(DataModels.Error error) {
            if (Anda.this.f9512w) {
                Anda.this.m1473R();
                Log.d("Anda", "Failed fetching data.");
                Anda.this.f9512w = false;
                Anda.this.f9511v = true;
                Log.e("Anda", "Backend:getApplicationData:Error(" + error.getMessage() + "):" + error.getMessageToUser());
                for (AndaActionsListener andaActionsListener : Anda.this.f9494d) {
                    andaActionsListener.mo21a(Anda.this.f9512w, Anda.this.f9511v);
                }
                if (error.getType() != DataModels.Error.ErrorType.STAGE_ALREADY_STARTED) {
                    Anda anda = Anda.this;
                    ErrorListener.C2358a m1372a = TipErrorConverter.m1372a(error);
                    m1372a.m1324a(this);
                    anda.m1455a(m1372a);
                }
                new Handler().postDelayed(Anda.m1467X(), 2000L);
            }
        }

        @Override // pt.card4b.backendbeacons.BackendListeners.InitialConfigurationRequestListener
        public void onSuccess() {
            Log.d("Anda", "Done fetching data.");
            Anda.this.f9512w = false;
            Anda.this.f9511v = false;
            Anda.this.m1473R();
            Anda.this.m1475P();
            if (!Anda.this.f9508s) {
                Anda.this.f9508s = true;
                if (!Anda.this.f9503n.mo1284a()) {
                    if (Anda.this.f9514y) {
                        Anda.this.f9514y = false;
                        if (!Anda.this.f9515z) {
                            Anda.this.m1406l();
                        }
                    }
                } else {
                    Anda.this.f9508s = true;
                    Anda.this.f9503n.mo1280a(new Runnable() { // from class: h.b.a.a
                        @Override // java.lang.Runnable
                        public final void run() {
                            Anda.C2272h.this.m1376a();
                        }
                    });
                }
            }
            for (AndaActionsListener andaActionsListener : Anda.this.f9494d) {
                andaActionsListener.mo21a(Anda.this.f9512w, Anda.this.f9511v);
            }
        }
    }

    /* compiled from: Anda.java */
    /* renamed from: h.b.a.c$i */
    /* loaded from: classes.dex */
    public class C2273i implements BackendListeners.EnableHCEValidationsListener {
        public C2273i() {
        }

        @Override // pt.card4b.backendbeacons.BackendListeners.BaseRequestListener
        public void onError(DataModels.Error error) {
            Anda.this.f9481B = false;
            Anda.this.f9480A = false;
            ErrorListener.C2358a m1372a = TipErrorConverter.m1372a(error);
            Anda.this.f9483D = m1372a;
            if (m1372a.m1323b() == ErrorListener.C2358a.EnumC2359a.unknown) {
                m1372a = new ErrorListener.C2358a(ErrorListener.C2358a.EnumC2359a.hceError, error.getMessage(), error.getMessageToUser());
            }
            Log.e("Anda", "enableHCEValidations called with error. Message is: " + error.getMessage());
            Anda.this.m1455a(m1372a);
        }

        @Override // pt.card4b.backendbeacons.BackendListeners.EnableHCEValidationsListener
        public void onSuccess() {
            Log.d("Anda", "enableHCEValidation called with success");
        }
    }

    /* compiled from: Anda.java */
    /* renamed from: h.b.a.c$j */
    /* loaded from: classes.dex */
    public class C2274j implements BackendListeners.DisableHCEValidationsListener {
        public C2274j() {
        }

        @Override // pt.card4b.backendbeacons.BackendListeners.BaseRequestListener
        public void onError(DataModels.Error error) {
            Anda.this.f9480A = false;
            Anda.this.f9482C = false;
            Log.e("Anda", "disableHCEValidation called with error. Message is: " + error.getMessage());
        }

        @Override // pt.card4b.backendbeacons.BackendListeners.DisableHCEValidationsListener
        public void onSuccess() {
            Log.d("Anda", "disableHCEValidation called with success");
        }
    }

    /* compiled from: Anda.java */
    /* renamed from: h.b.a.c$k */
    /* loaded from: classes.dex */
    public class C2275k implements BackendListeners.StageStopListener {

        /* compiled from: Anda.java */
        /* renamed from: h.b.a.c$k$a */
        /* loaded from: classes.dex */
        public class C2276a extends OngoingTrip.InterfaceC2364c.AbstractRunnableC2365a {

            /* compiled from: Anda.java */
            /* renamed from: h.b.a.c$k$a$a */
            /* loaded from: classes.dex */
            public class C2277a implements BackendListeners.FinishStageUserConfirmationListener {
                public C2277a() {
                }

                @Override // pt.card4b.backendbeacons.BackendListeners.BaseRequestListener
                public void onError(DataModels.Error error) {
                    Anda.this.f9501k = null;
                    Anda anda = Anda.this;
                    anda.mo29a(anda.f9504o, TipErrorConverter.m1372a(error));
                    Anda.this.f9486G = true;
                }

                @Override // pt.card4b.backendbeacons.BackendListeners.FinishStageUserConfirmationListener
                public void onSuccess(boolean z) {
                    Anda.this.f9501k = null;
                    Anda anda = Anda.this;
                    anda.mo16b(anda.f9504o);
                    Anda.this.f9486G = true;
                }
            }

            /* compiled from: Anda.java */
            /* renamed from: h.b.a.c$k$a$b */
            /* loaded from: classes.dex */
            public class C2278b implements BackendListeners.FinishStageUserConfirmationListener {
                public C2278b() {
                }

                @Override // pt.card4b.backendbeacons.BackendListeners.BaseRequestListener
                public void onError(DataModels.Error error) {
                    Anda.this.f9501k = null;
                    Anda anda = Anda.this;
                    anda.mo29a(anda.f9504o, TipErrorConverter.m1372a(error));
                }

                @Override // pt.card4b.backendbeacons.BackendListeners.FinishStageUserConfirmationListener
                public void onSuccess(boolean z) {
                    Anda.this.f9501k = null;
                    Anda anda = Anda.this;
                    anda.mo12c(anda.f9504o);
                }
            }

            public C2276a(int i) {
                super(i);
            }

            @Override // p205h.p208b.p209a.p210d.OngoingTrip.InterfaceC2364c.AbstractRunnableC2365a
            /* renamed from: b */
            public void mo1294b(boolean z) {
                BackEnd.confirmStageFinished(true, z, new C2278b());
            }

            @Override // p205h.p208b.p209a.p210d.OngoingTrip.InterfaceC2364c.AbstractRunnableC2365a
            /* renamed from: e */
            public void mo1291e() {
                BackEnd.confirmStageFinished(false, false, new C2277a());
            }
        }

        public C2275k() {
        }

        @Override // pt.card4b.backendbeacons.BackendListeners.BaseRequestListener
        public void onError(DataModels.Error error) {
            Log.e("Anda", "Error(" + error.getType() + "): " + error.getMessage());
            if (error.getType() == DataModels.Error.ErrorType.STAGE_ALREADY_STARTED) {
                return;
            }
            DataModels.Error.ErrorType type = error.getType();
            if (type == DataModels.Error.ErrorType.BLUETOOTH_DISABLED || type == DataModels.Error.ErrorType.LOCATION_DISABLED || type == DataModels.Error.ErrorType.NFC_DISABLED) {
                Anda.this.m1444b();
            }
            Anda anda = Anda.this;
            anda.mo29a(anda.f9504o, TipErrorConverter.m1372a(error));
        }

        @Override // pt.card4b.backendbeacons.BackendListeners.StageStopListener
        public void onFinish(boolean z) {
            Log.d("Anda", "onFinish() called with: " + z);
            Anda anda = Anda.this;
            anda.mo28a(anda.f9504o, new OngoingTrip.C2362a(z));
            Anda.this.f9486G = true;
        }

        @Override // pt.card4b.backendbeacons.BackendListeners.StageStopListener
        public void onFinishConfirmation(int i, boolean z) {
            Log.d("Anda", "onFinishConfirmation() called with: " + i + ", " + z);
            if (z) {
                Anda.this.f9501k.m1297a();
                if (Anda.this.f9501k != null) {
                    Anda.this.f9501k.m1295b();
                    Anda.this.f9501k = null;
                }
                Anda anda = Anda.this;
                anda.mo16b(anda.f9504o);
                Anda.this.f9486G = true;
            } else if (Anda.this.f9486G && Anda.this.f9501k == null) {
                Anda.this.f9501k = new C2276a(i);
                Anda.this.f9486G = false;
                Anda.this.m1469V();
                Anda anda2 = Anda.this;
                anda2.mo27a(anda2.f9504o, Anda.this.f9501k);
            }
        }

        @Override // pt.card4b.backendbeacons.BackendListeners.StageStopListener
        public void onLogoutRequired() {
            Log.d("Anda", "onLogoutRequired() was called. Forcing logout...");
            Anda.this.f9503n.mo1276c();
        }

        @Override // pt.card4b.backendbeacons.BackendListeners.StageStopListener
        public void onReceiveOtherStop(DataModels.StopInfo stopInfo) {
            Log.d("Anda", "onReceiveOtherStop() called with: " + stopInfo);
            Anda.this.onReceiveStop(stopInfo);
        }

        @Override // pt.card4b.backendbeacons.BackendListeners.StageStopListener
        public void onReceiveStageStop(DataModels.StopInfo stopInfo) {
            BackEnd.addToLog(String.format(Locale.getDefault(), "[%s] onReceiveStageStop: called with: %s", "Anda", stopInfo));
            Date datetime = stopInfo.getDatetime();
            if (Anda.this.f9497g.size() == 0) {
                if (stopInfo.getValidationDatetime() != null) {
                    datetime = stopInfo.getValidationDatetime();
                    BackEnd.addToLog(String.format(Locale.getDefault(), "[%s] onReceiveStageStop: validation time is not null. Received %s", "Anda", datetime));
                } else {
                    BackEnd.addToLog(String.format(Locale.getDefault(), "[%s] getValidationDatetime() is null. getDatetime() will be used instead.", "Anda"));
                }
            }
            if (datetime == null) {
                BackEnd.addToLog(String.format(Locale.getDefault(), "[%s] onReceiveStageStop: tipPassings = %d, stopName = %s, operator = %s", "Anda", Integer.valueOf(Anda.this.f9497g.size()), stopInfo.getStopName(), stopInfo.getOperatorName()));
            }
            if (stopInfo.getDatetime() == null && stopInfo.getValidationDatetime() == null) {
                BackEnd.addToLog(String.format(Locale.getDefault(), "[%s] onReceiveStageStop: both getDatetime() and getValidationDatetime() are null. Setting time to current time.", "Anda"));
                datetime = Calendar.getInstance().getTime();
            }
            if (Anda.this.f9497g.size() == 0) {
                Anda.this.f9500j = new TipLine(stopInfo);
            }
            BackEnd.addToLog(String.format(Locale.getDefault(), "[%s] onReceiveStageStop: Ready to build a TipPassing with information %s and time %s", "Anda", stopInfo, datetime));
            TipPassing tipPassing = new TipPassing(new TipStop(stopInfo), datetime);
            Anda.this.f9497g.add(tipPassing);
            Anda anda = Anda.this;
            anda.mo26a(anda.f9504o, tipPassing);
        }

        @Override // pt.card4b.backendbeacons.BackendListeners.StageStopListener
        public void onRemoveOtherStops(List<DataModels.StopInfo> list) {
            Log.d("Anda", "onRemoveOtherStops() called with: " + list);
            Anda.this.onRemoveStops(list);
        }

        @Override // pt.card4b.backendbeacons.BackendListeners.StageStopListener
        public void onRestartStageStops(List<DataModels.StopInfo> list) {
            Log.d("Anda", "onRestartStageStops() called with: " + list.size() + " stops");
            Anda.this.f9497g.clear();
            Anda.this.m1446a(list);
            Anda anda = Anda.this;
            anda.mo30a(anda.f9504o);
        }

        @Override // pt.card4b.backendbeacons.BackendListeners.StageStopListener
        public void onServiceDisabled(DataModels.Service service) {
            if (service == DataModels.Service.HCE_VALIDATION) {
                Anda.this.m1484G();
            } else if (service == DataModels.Service.INTERNET) {
                Anda.this.f9484E = false;
            }
        }

        @Override // pt.card4b.backendbeacons.BackendListeners.StageStopListener
        public void onServiceEnabled(DataModels.Service service) {
            if (service != DataModels.Service.HCE_VALIDATION) {
                Anda.this.m1434c();
            }
            if (service == DataModels.Service.BLUETOOTH) {
                Anda.this.m1485F();
            } else if (service == DataModels.Service.LOCATION) {
                Anda.this.m1481J();
            } else if (service == DataModels.Service.NFC) {
                Anda.this.m1480K();
            } else if (service == DataModels.Service.HCE_VALIDATION) {
                Anda.this.m1483H();
            } else if (service == DataModels.Service.INTERNET) {
                Anda.this.m1482I();
            }
        }

        @Override // pt.card4b.backendbeacons.BackendListeners.StageStopListener
        public void onStartStageStops(List<DataModels.StopInfo> list) {
            Log.d("Anda", "onStartStageStops() called with: " + list);
            Anda.this.m1446a(list);
        }

        @Override // pt.card4b.backendbeacons.BackendListeners.StageStopListener
        public void onSuccess() {
            Log.d("Anda", "onSuccess() - Preparing trip start");
            Anda.this.m1474Q();
            Anda.this.m1478M();
            Anda anda = Anda.this;
            anda.mo10d(anda.f9504o);
        }

        @Override // pt.card4b.backendbeacons.BackendListeners.StageStopListener
        public void onTripAppActivityBlocked() {
            for (AndaActionsListener andaActionsListener : Anda.this.f9494d) {
                andaActionsListener.onTripAppActivityBlocked();
            }
        }

        @Override // pt.card4b.backendbeacons.BackendListeners.StageStopListener
        public void onWakeUpRequired() {
            BackEnd.addToLog("onWakeUpRequired() was invoked. Trying to turn the screen on...");
            for (AndaActionsListener andaActionsListener : Anda.this.f9494d) {
                andaActionsListener.onWakeUpRequired();
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
        f9478L = intentArr;
    }

    public Anda(Context context) {
        this.f9507r = false;
        this.f9484E = false;
        try {
            context.openFileInput("testMode");
        } catch (FileNotFoundException unused) {
        }
        this.f9490K = context;
        this.f9484E = m1384w();
        int availableProcessors = Runtime.getRuntime().availableProcessors();
        this.f9485F = new ThreadPoolExecutor(availableProcessors, availableProcessors, 120L, TimeUnit.SECONDS, new LinkedBlockingQueue());
        if (ContextCompat.m10021a(context, "android.permission.READ_PHONE_STATE") == 0) {
            m1418h();
        }
        this.f9503n = new TipSession(this, context);
        this.f9487H = (DownloadManager) context.getSystemService("download");
        this.f9506q = new C2266c();
        context.registerReceiver(this.f9506q, new IntentFilter("android.intent.action.DOWNLOAD_COMPLETE"));
        this.f9507r = true;
    }

    /* renamed from: W */
    public static Context m1468W() {
        Anda anda = f9479M;
        if (anda == null) {
            return null;
        }
        return anda.f9490K;
    }

    /* renamed from: X */
    public static Anda m1467X() {
        return f9479M;
    }

    /* renamed from: C */
    public boolean m1488C() {
        return this.f9513x;
    }

    /* renamed from: D */
    public boolean m1487D() {
        return this.f9509t;
    }

    /* renamed from: E */
    public final void m1486E() {
        if (this.f9515z) {
            Log.d("Anda", "Leaving power saving mode...");
            this.f9515z = false;
            m1476O();
        }
    }

    /* renamed from: F */
    public final void m1485F() {
        m1476O();
        for (ErrorListener errorListener : this.f9493c) {
            errorListener.mo31a(ErrorListener.EnumC2360b.bluetooth);
        }
    }

    /* renamed from: G */
    public final void m1484G() {
        this.f9480A = false;
        this.f9482C = false;
        this.f9481B = false;
        m1476O();
        ErrorListener.C2358a c2358a = new ErrorListener.C2358a(ErrorListener.C2358a.EnumC2359a.hceOff, "", "");
        this.f9483D = c2358a;
        for (ErrorListener errorListener : this.f9493c) {
            errorListener.mo32a(c2358a);
        }
    }

    /* renamed from: H */
    public final void m1483H() {
        this.f9480A = true;
        this.f9481B = false;
        this.f9482C = false;
        this.f9483D = null;
        m1476O();
        for (ErrorListener errorListener : this.f9493c) {
            errorListener.mo31a(ErrorListener.EnumC2360b.hce);
        }
    }

    /* renamed from: I */
    public final void m1482I() {
        this.f9484E = true;
        m1476O();
        for (ErrorListener errorListener : this.f9493c) {
            errorListener.mo31a(ErrorListener.EnumC2360b.internet);
        }
    }

    /* renamed from: J */
    public final void m1481J() {
        m1476O();
        for (ErrorListener errorListener : this.f9493c) {
            errorListener.mo31a(ErrorListener.EnumC2360b.location);
        }
    }

    /* renamed from: K */
    public final void m1480K() {
        m1476O();
        for (ErrorListener errorListener : this.f9493c) {
            errorListener.mo31a(ErrorListener.EnumC2360b.nfc);
        }
    }

    /* renamed from: L */
    public void m1479L() {
        m1476O();
    }

    /* renamed from: M */
    public final void m1478M() {
        Log.d("Anda", "Preparing ongoingTrip start...");
        this.f9513x = true;
        if (Build.VERSION.SDK_INT >= 26) {
            Context context = this.f9490K;
            context.startForegroundService(new Intent(context, TripControllerService.class));
        } else {
            Context context2 = this.f9490K;
            context2.startService(new Intent(context2, TripControllerService.class));
        }
        m1472S();
    }

    /* renamed from: N */
    public void m1477N() {
        if (!this.f9512w) {
            this.f9511v = false;
            m1418h();
            return;
        }
        Log.d("Anda", "Already fetching data...");
    }

    /* renamed from: O */
    public void m1476O() {
        if (this.f9510u && !this.f9513x && !m1492A()) {
            m1472S();
            return;
        }
        Log.w("Anda", "refreshLookup() called but blocked");
        Log.w("Anda", "readyToUseBeacons==" + this.f9510u + ", startingTrip==" + this.f9513x + ", isOnTrip==" + m1492A());
        Crashlytics.m6083a(5, "Invalid state", "refreshLookup() called but readyToUseBeacons==" + this.f9510u + ", startingTrip==" + this.f9513x + ", isOnTrip==" + m1492A());
    }

    /* renamed from: P */
    public final void m1475P() {
        if (this.f9498h) {
            return;
        }
        this.f9499i = new C2267d();
        this.f9498h = true;
    }

    /* renamed from: Q */
    public final void m1474Q() {
        this.f9504o = new C2263a();
    }

    /* renamed from: R */
    public final void m1473R() {
        if (this.f9496f) {
            return;
        }
        BackEnd.addListeners(this.f9489J);
        this.f9496f = true;
    }

    /* renamed from: S */
    public final void m1472S() {
        if (this.f9505p != null) {
            for (NearbyStationListener nearbyStationListener : this.f9492b) {
                nearbyStationListener.mo1094f();
            }
            this.f9505p.f9561b.clear();
        }
    }

    /* renamed from: T */
    public final void m1471T() {
        if (!this.f9510u || this.f9513x || m1492A()) {
            Log.w("Anda", "startLookingForTripStarters() called but blocked");
            Log.w("Anda", "readyToUseBeacons==" + this.f9510u + ", startingTrip==" + this.f9513x + ", isOnTrip==" + m1492A());
        }
    }

    /* renamed from: U */
    public void m1470U() {
        BroadcastReceiver broadcastReceiver = this.f9506q;
        if (broadcastReceiver == null || !this.f9507r) {
            return;
        }
        try {
            this.f9490K.unregisterReceiver(broadcastReceiver);
            this.f9507r = false;
        } catch (Exception unused) {
            Log.d("Anda", "unregisterDownloadCompletedReceiver: failed to unregister onDownloadCompleted receiver");
        }
    }

    /* renamed from: V */
    public final void m1469V() {
        Vibrator vibrator;
        if (PreferenceManager.getDefaultSharedPreferences(this.f9490K).getBoolean("vibration_alerts", false) && (vibrator = (Vibrator) this.f9490K.getSystemService("vibrator")) != null && vibrator.hasVibrator()) {
            long[] jArr = {0, 100, 150, 200};
            if (Build.VERSION.SDK_INT >= 26) {
                NotificationManager notificationManager = (NotificationManager) this.f9490K.getSystemService("notification");
                NotificationChannel notificationChannel = notificationManager != null ? notificationManager.getNotificationChannel(this.f9490K.getString(C1444R.string.anda_notificationChannel)) : null;
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
        if (this.f9492b.size() > 0 || this.f9491a.size() > 0 || this.f9493c.size() > 0) {
            Log.e("Anda", "There are listeners left to release!");
        }
        super.finalize();
    }

    @Override // pt.card4b.backendbeacons.BackendListeners.BaseRequestListener
    public void onError(DataModels.Error error) {
        Log.e("Anda", "Backend:Error(" + error.getMessage() + "):" + error.getMessageToUser());
        DataModels.Error.ErrorType type = error.getType();
        if (type == DataModels.Error.ErrorType.BLUETOOTH_DISABLED || type == DataModels.Error.ErrorType.LOCATION_DISABLED || type == DataModels.Error.ErrorType.NFC_DISABLED) {
            m1472S();
        } else if (type != DataModels.Error.ErrorType.LOCATION_PERMISSION) {
            Crashlytics.m6081a((Throwable) new Exception("Error:" + type.toString() + ": " + error.getMessage()));
        }
        if (type != DataModels.Error.ErrorType.STAGE_ALREADY_STARTED) {
            m1455a(TipErrorConverter.m1372a(error));
        }
    }

    @Override // pt.card4b.backendbeacons.BackendListeners.PossibleStopListener
    public void onReceiveStop(DataModels.StopInfo stopInfo) {
        Log.d("Anda:Trip:Backend", "onReceiveStop() called with: stageInfo = [" + stopInfo.getKey() + ", " + stopInfo.getLineName() + "]");
        if (this.f9505p == null) {
            this.f9505p = new TipNearbyStations();
        }
        List<NearbyStation> list = this.f9505p.f9561b;
        String stopCode = stopInfo.getStopCode();
        for (NearbyStation nearbyStation : list) {
            if ((stopCode == null && ((TipNearbyStation) nearbyStation).m1332h().getStopName().equals(stopInfo.getStopName())) || (stopCode != null && stopCode.equals(((TipNearbyStation) nearbyStation).m1332h().getStopCode()))) {
                ((TipNearbyStation) nearbyStation).m1368a(stopInfo);
                for (NearbyStationListener nearbyStationListener : this.f9492b) {
                    nearbyStationListener.mo1110b(nearbyStation);
                }
                return;
            }
        }
        TipNearbyStation tipNearbyStation = new TipNearbyStation(stopInfo);
        list.add(tipNearbyStation);
        for (NearbyStationListener nearbyStationListener2 : this.f9492b) {
            nearbyStationListener2.mo1123a(tipNearbyStation);
        }
    }

    @Override // pt.card4b.backendbeacons.BackendListeners.PossibleStopListener
    public void onRemoveStops(List<DataModels.StopInfo> list) {
        Log.d("Anda:Trip:Backend", "onRemoveStops() called with: arrayList = [" + list.size() + "]");
        TipNearbyStations tipNearbyStations = this.f9505p;
        if (tipNearbyStations == null) {
            Log.w("Anda:Trip", "onRemoveStops() called but we're not keeping track of available stops");
            return;
        }
        List<NearbyStation> list2 = tipNearbyStations.f9561b;
        int i = 0;
        while (i < list2.size()) {
            TipNearbyStation tipNearbyStation = (TipNearbyStation) list2.get(i);
            if (tipNearbyStation.mo1303f()) {
                if (tipNearbyStation.m1369a(list)) {
                    tipNearbyStation.m1367b(list);
                    if (tipNearbyStation.m1366i()) {
                        i--;
                        list2.remove(tipNearbyStation);
                        for (NearbyStationListener nearbyStationListener : this.f9492b) {
                            nearbyStationListener.mo1104c(tipNearbyStation);
                        }
                    } else {
                        for (NearbyStationListener nearbyStationListener2 : this.f9492b) {
                            nearbyStationListener2.mo1110b(tipNearbyStation);
                        }
                    }
                }
            } else {
                String key = tipNearbyStation.m1332h().getKey();
                for (DataModels.StopInfo stopInfo : list) {
                    if (key.equals(stopInfo.getKey())) {
                        i--;
                        list2.remove(tipNearbyStation);
                        for (NearbyStationListener nearbyStationListener3 : this.f9492b) {
                            nearbyStationListener3.mo1104c(tipNearbyStation);
                        }
                    }
                }
            }
            i++;
        }
    }

    @Override // java.lang.Runnable
    public void run() {
        m1477N();
    }

    /* renamed from: A */
    public boolean m1492A() {
        return this.f9504o != null;
    }

    /* renamed from: B */
    public boolean m1490B() {
        return this.f9508s;
    }

    /* renamed from: l */
    public List<NearbyStation> m1406l() {
        if (this.f9510u && !this.f9513x) {
            if (this.f9505p == null) {
                this.f9505p = new TipNearbyStations();
                if (!m1492A()) {
                    m1471T();
                }
            }
            return this.f9505p.f9561b;
        }
        if (!this.f9510u) {
            this.f9514y = true;
        }
        Log.w("Anda", "getNearbyStations() called but blocked");
        Log.w("Anda", "readyToUseBeacons==" + this.f9510u + ", startingTrip==" + this.f9513x + ", isOnTrip==" + m1492A());
        return new ArrayList(0);
    }

    /* renamed from: m */
    public OngoingTrip m1404m() {
        return this.f9504o;
    }

    /* renamed from: n */
    public Intent[] m1402n() {
        return f9478L;
    }

    /* renamed from: o */
    public Session m1400o() {
        return this.f9503n;
    }

    /* renamed from: p */
    public boolean m1398p() {
        return this.f9511v;
    }

    /* renamed from: q */
    public boolean m1396q() {
        PowerManager powerManager;
        if (Build.VERSION.SDK_INT < 23 || (powerManager = (PowerManager) this.f9490K.getSystemService("power")) == null) {
            return true;
        }
        return powerManager.isIgnoringBatteryOptimizations(this.f9490K.getPackageName());
    }

    @SuppressLint({"MissingPermission"})
    /* renamed from: r */
    public boolean m1394r() {
        BluetoothAdapter defaultAdapter = BluetoothAdapter.getDefaultAdapter();
        return defaultAdapter != null && defaultAdapter.isEnabled();
    }

    /* renamed from: s */
    public boolean m1392s() {
        return this.f9512w;
    }

    /* renamed from: t */
    public final boolean m1390t() {
        return this.f9482C;
    }

    /* renamed from: u */
    public final boolean m1388u() {
        return this.f9480A;
    }

    /* renamed from: v */
    public boolean m1386v() {
        return this.f9481B;
    }

    /* renamed from: w */
    public final boolean m1384w() {
        NetworkInfo activeNetworkInfo = ((ConnectivityManager) Objects.requireNonNull((ConnectivityManager) this.f9490K.getSystemService("connectivity"))).getActiveNetworkInfo();
        return activeNetworkInfo != null && activeNetworkInfo.isConnectedOrConnecting();
    }

    /* renamed from: x */
    public boolean m1382x() {
        return this.f9484E;
    }

    /* renamed from: y */
    public boolean m1380y() {
        LocationManager locationManager = (LocationManager) this.f9490K.getSystemService("location");
        return locationManager != null && locationManager.isProviderEnabled("network");
    }

    /* renamed from: z */
    public boolean m1378z() {
        NfcAdapter defaultAdapter;
        NfcManager nfcManager = (NfcManager) this.f9490K.getSystemService("nfc");
        return (nfcManager == null || (defaultAdapter = nfcManager.getDefaultAdapter()) == null || !defaultAdapter.isEnabled()) ? false : true;
    }

    /* renamed from: c */
    public void m1431c(AndaActionsListener andaActionsListener) {
        if (this.f9494d.contains(andaActionsListener)) {
            this.f9494d.remove(andaActionsListener);
        }
    }

    /* renamed from: d */
    public void m1430d() {
        for (AndaActionsListener andaActionsListener : this.f9494d) {
            andaActionsListener.mo20b();
        }
    }

    /* renamed from: e */
    public void m1427e() {
        this.f9482C = true;
        BackEnd.disableHCEValidation(new C2274j());
    }

    /* renamed from: f */
    public final void m1424f() {
        if (this.f9480A || this.f9481B) {
            return;
        }
        this.f9481B = true;
        for (ErrorListener errorListener : this.f9493c) {
            errorListener.mo17b(ErrorListener.EnumC2360b.hce);
        }
        BackEnd.enableHCEValidation(new C2273i());
    }

    /* renamed from: g */
    public void m1421g() {
        if (this.f9515z) {
            return;
        }
        if (this.f9510u && !this.f9513x && !m1492A()) {
            Log.d("Anda", "Entering in power saving mode...");
            this.f9515z = true;
            BackEnd.stopBeaconService();
            m1472S();
            return;
        }
        Log.d("Anda", "Will enter in power saving mode as soon as possible");
        this.f9515z = true;
    }

    /* renamed from: h */
    public final void m1418h() {
        Log.d("Anda", "Fetching data...");
        this.f9512w = true;
        BackEnd.doInitialConfiguration(this.f9488I);
    }

    /* renamed from: i */
    public Locale m1415i() {
        return ConfigurationCompat.m9751a(this.f9490K.getResources().getConfiguration()).m9746a(0);
    }

    /* renamed from: j */
    public ErrorListener.C2358a m1412j() {
        return this.f9483D;
    }

    /* renamed from: k */
    public String m1409k() {
        return PreferenceManager.getDefaultSharedPreferences(this.f9490K).getString("lastUsername", null);
    }

    /* renamed from: b */
    public void m1435b(OngoingTrip.InterfaceC2364c interfaceC2364c) {
        if (this.f9491a.remove(interfaceC2364c)) {
            Log.d("Anda", "Listener " + interfaceC2364c + " removed");
        }
    }

    @Override // p205h.p208b.p209a.p210d.OngoingTrip.InterfaceC2364c
    /* renamed from: c */
    public void mo12c(OngoingTrip ongoingTrip) {
        for (OngoingTrip.InterfaceC2364c interfaceC2364c : this.f9491a) {
            interfaceC2364c.mo12c(ongoingTrip);
        }
    }

    @Override // p205h.p208b.p209a.p210d.OngoingTrip.InterfaceC2364c
    /* renamed from: d */
    public void mo10d(OngoingTrip ongoingTrip) {
        Log.d("Anda:Trip", "onTripStarted() called with: ongoingTrip = [" + ongoingTrip + "]");
        this.f9513x = false;
        this.f9504o = ongoingTrip;
        m1486E();
        for (OngoingTrip.InterfaceC2364c interfaceC2364c : this.f9491a) {
            interfaceC2364c.mo10d(ongoingTrip);
        }
        this.f9510u = true;
        m1469V();
    }

    /* renamed from: b */
    public void m1436b(NearbyStationListener nearbyStationListener) {
        this.f9492b.remove(nearbyStationListener);
    }

    /* renamed from: a */
    public Intent[] m1464a(Context context) {
        return new Intent[]{new Intent().setComponent(new ComponentName("com.miui.powerkeeper", "com.miui.powerkeeper.ui.HiddenAppsConfigActivity")).putExtra("package_name", context.getPackageName()).putExtra("package_label", context.getString(C1444R.string.app_anda_name))};
    }

    /* renamed from: b */
    public void m1439b(AndaActionsListener andaActionsListener) {
        this.f9495e = andaActionsListener;
    }

    /* renamed from: c */
    public void m1434c() {
        if (this.f9503n.mo1284a() && this.f9508s) {
            if (!m1388u() && !m1386v() && m1380y() && m1378z() && m1394r() && m1396q()) {
                m1424f();
                return;
            }
            if (!m1396q()) {
                BackEnd.addToLog("checkServicesAndEnableHCE: app not excluded from battery optimizations. Disabling HCE!");
                m1427e();
            }
            BackEnd.addToLog(String.format("checkServicesAndEnableHCE:: isHceEnabled: %b, isHceEnabling: %b, isLocationOn: %b, isNfcOn: %b, isBluetoothOn: %b", Boolean.valueOf(m1388u()), Boolean.valueOf(m1386v()), Boolean.valueOf(m1380y()), Boolean.valueOf(m1378z()), Boolean.valueOf(m1394r())));
            return;
        }
        BackEnd.addToLog(String.format("checkServicesAndEnableHCE:: isLoggedIn: %b, readyToUse: %b", Boolean.valueOf(this.f9503n.mo1284a()), Boolean.valueOf(this.f9508s)));
    }

    /* renamed from: b */
    public void m1437b(ErrorListener errorListener) {
        this.f9493c.remove(errorListener);
    }

    /* renamed from: b */
    public void m1438b(CountriesListener countriesListener) {
        BackEnd.getLanguages(new C2269e(this, countriesListener));
    }

    @Override // p205h.p208b.p209a.p210d.OngoingTrip.InterfaceC2364c
    /* renamed from: b */
    public void mo16b(OngoingTrip ongoingTrip) {
        for (OngoingTrip.InterfaceC2364c interfaceC2364c : this.f9491a) {
            interfaceC2364c.mo16b(ongoingTrip);
        }
    }

    /* renamed from: a */
    public void m1445a(boolean z) {
        this.f9509t = z;
    }

    /* renamed from: a */
    public void m1452a(InvoiceDownloadListener invoiceDownloadListener) {
        this.f9502m = invoiceDownloadListener;
    }

    /* renamed from: b */
    public final void m1444b() {
        if (!m1388u() || m1390t()) {
            return;
        }
        if (m1380y() && m1378z() && m1394r() && m1396q()) {
            return;
        }
        m1427e();
    }

    /* renamed from: a */
    public void m1450a(OngoingTrip.InterfaceC2364c interfaceC2364c) {
        if (this.f9491a.contains(interfaceC2364c)) {
            return;
        }
        this.f9491a.add(interfaceC2364c);
    }

    /* renamed from: b */
    public static Anda m1443b(Context context) {
        if (f9479M == null) {
            f9479M = new Anda(context);
        }
        return f9479M;
    }

    /* renamed from: a */
    public void m1451a(NearbyStationListener nearbyStationListener) {
        if (this.f9492b.contains(nearbyStationListener)) {
            return;
        }
        this.f9492b.add(nearbyStationListener);
    }

    /* renamed from: a */
    public void m1454a(ErrorListener errorListener) {
        if (this.f9493c.contains(errorListener)) {
            return;
        }
        this.f9493c.add(errorListener);
    }

    /* renamed from: a */
    public void m1457a(AndaActionsListener andaActionsListener) {
        if (this.f9494d.contains(andaActionsListener)) {
            return;
        }
        this.f9494d.add(andaActionsListener);
    }

    /* renamed from: a */
    public final void m1446a(List<DataModels.StopInfo> list) {
        if (list.size() > 0) {
            this.f9500j = new TipLine(list.get(0));
        }
        for (DataModels.StopInfo stopInfo : list) {
            Date datetime = stopInfo.getDatetime();
            if (this.f9497g.size() == 0) {
                if (stopInfo.getValidationDatetime() != null) {
                    datetime = stopInfo.getValidationDatetime();
                } else {
                    BackEnd.addToLog(String.format("[%s] getValidationDatetime() is null. getDatetime() will be used instead.", "Anda"));
                }
            }
            if (datetime == null) {
                BackEnd.addToLog(String.format(Locale.getDefault(), "[%s] tipPassings = %d, stopName = %s, operator = %s", "Anda", Integer.valueOf(this.f9497g.size()), stopInfo.getStopName(), stopInfo.getOperatorName()));
            }
            if (stopInfo.getDatetime() == null && stopInfo.getValidationDatetime() == null) {
                BackEnd.addToLog(String.format(Locale.getDefault(), "[%s] Both getDatetime() and getValidationDatetime() are null. Setting time to current time.", "Anda"));
                datetime = Calendar.getInstance().getTime();
            }
            TipPassing tipPassing = new TipPassing(new TipStop(stopInfo), datetime);
            this.f9497g.add(tipPassing);
            mo26a(this.f9504o, tipPassing);
        }
    }

    /* renamed from: a */
    public Snackbar m1447a(String str, int i) {
        return this.f9495e.mo23a(str, i);
    }

    /* renamed from: a */
    public void m1456a(CountriesListener countriesListener) {
        BackEnd.getCountries(new C2270f(this, countriesListener));
    }

    /* renamed from: a */
    public void m1453a(HceCardInfoListener hceCardInfoListener) {
        BackEnd.getCardInfo(new C2271g(this, hceCardInfoListener));
    }

    @Override // p205h.p208b.p209a.p210d.OngoingTrip.InterfaceC2364c
    /* renamed from: a */
    public void mo26a(OngoingTrip ongoingTrip, Passing passing) {
        Log.d("Anda:Trip", "onStopReached() called with: ongoingTrip = [" + ongoingTrip + "], passing = [" + passing + "]");
        if (ongoingTrip != this.f9504o) {
            Crashlytics.m6081a((Throwable) new RuntimeException(new IllegalStateException("Wrong ongoingTrip (" + ongoingTrip + ") ending, it should be " + this.f9504o + ".")));
        }
        for (OngoingTrip.InterfaceC2364c interfaceC2364c : this.f9491a) {
            interfaceC2364c.mo26a(ongoingTrip, passing);
        }
    }

    @Override // p205h.p208b.p209a.p210d.OngoingTrip.InterfaceC2364c
    /* renamed from: a */
    public void mo28a(OngoingTrip ongoingTrip, OngoingTrip.C2362a c2362a) {
        Log.d("Anda:Trip", "onTripEnded() called with: ongoingTrip = [" + ongoingTrip + "]");
        if (ongoingTrip != this.f9504o) {
            Crashlytics.m6081a((Throwable) new RuntimeException(new IllegalStateException("Wrong ongoingTrip (" + ongoingTrip + ") ending, it should be " + this.f9504o + ".")));
        }
        try {
            Trip mo1300b = ongoingTrip.mo1300b();
            CustomEvent customEvent = new CustomEvent("Trip Ended");
            customEvent.m6069a("Stop Count", Integer.valueOf(mo1300b.mo1253l()));
            CustomEvent customEvent2 = customEvent;
            customEvent2.m6069a("Duration (minutes)", Long.valueOf((mo1300b.mo1259f().mo1286a() - mo1300b.mo1260e()) / 60000));
            CustomEvent customEvent3 = customEvent2;
            customEvent3.m6068a("Vehicle Type", VehicleTypes.m1213a(mo1300b.mo1256i()));
            CustomEvent customEvent4 = customEvent3;
            Operator mo1263b = mo1300b.mo1263b();
            if (mo1263b != null) {
                customEvent4.m6068a("Operator", mo1263b.mo1290a());
            }
            Answers.m6074p().m6078a(customEvent4);
        } catch (Exception e) {
            Crashlytics.m6081a((Throwable) e);
        }
        this.f9504o = null;
        this.f9497g.clear();
        if (this.f9505p == null) {
            this.f9505p = new TipNearbyStations();
        } else {
            m1472S();
        }
        if (!c2362a.m1298a()) {
            m1476O();
        }
        for (OngoingTrip.InterfaceC2364c interfaceC2364c : this.f9491a) {
            interfaceC2364c.mo28a(ongoingTrip, c2362a);
        }
    }

    @Override // p205h.p208b.p209a.p210d.OngoingTrip.InterfaceC2364c
    /* renamed from: a */
    public void mo30a(OngoingTrip ongoingTrip) {
        for (OngoingTrip.InterfaceC2364c interfaceC2364c : this.f9491a) {
            interfaceC2364c.mo30a(ongoingTrip);
        }
    }

    @Override // p205h.p208b.p209a.p210d.OngoingTrip.InterfaceC2364c
    /* renamed from: a */
    public void mo27a(OngoingTrip ongoingTrip, OngoingTrip.InterfaceC2364c.AbstractRunnableC2365a abstractRunnableC2365a) {
        for (OngoingTrip.InterfaceC2364c interfaceC2364c : this.f9491a) {
            interfaceC2364c.mo27a(ongoingTrip, abstractRunnableC2365a);
        }
    }

    @Override // p205h.p208b.p209a.p210d.OngoingTrip.InterfaceC2364c
    /* renamed from: a */
    public void mo29a(OngoingTrip ongoingTrip, ErrorListener.C2358a c2358a) {
        this.f9513x = false;
        Crashlytics.m6081a((Throwable) new Exception("Error:Trip:" + c2358a.m1323b().toString() + ": " + c2358a.m1325a()));
        m1476O();
        for (OngoingTrip.InterfaceC2364c interfaceC2364c : this.f9491a) {
            interfaceC2364c.mo29a(ongoingTrip, c2358a);
        }
        m1455a(c2358a);
    }

    /* renamed from: a */
    public final void m1455a(ErrorListener.C2358a c2358a) {
        for (ErrorListener errorListener : this.f9493c) {
            errorListener.mo32a(c2358a);
        }
    }

    /* renamed from: a */
    public void m1448a(String str) {
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
                DownloadManager downloadManager = this.f9487H;
                if (downloadManager != null) {
                    downloadManager.enqueue(request);
                }
            }
        }
    }

    /* renamed from: a */
    public void m1466a() {
        if (this.f9508s) {
            BackEnd.hasOngoingStage(new C2265b());
        }
    }

    /* renamed from: a */
    public void m1449a(Runnable runnable) {
        this.f9485F.execute(runnable);
    }

    /* renamed from: a */
    public void m1465a(FragmentActivity fragmentActivity, boolean z) {
        if (Build.VERSION.SDK_INT >= 21) {
            Window window = fragmentActivity.getWindow();
            if (z) {
                window.setFlags(67108864, 67108864);
            } else {
                window.clearFlags(67108864);
            }
        }
    }
}
