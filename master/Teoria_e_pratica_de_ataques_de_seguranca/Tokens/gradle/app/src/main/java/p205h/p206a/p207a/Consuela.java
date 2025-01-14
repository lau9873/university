package p205h.p206a.p207a;

import android.bluetooth.BluetoothAdapter;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.BatteryManager;
import android.os.Handler;
import android.provider.Settings;
import android.util.Log;
import android.util.SparseArray;
import io.reactivex.exceptions.UndeliverableException;
import java.io.File;
import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import p136d.p153c.Completable;
import p136d.p153c.CompletableObserver;
import p136d.p153c.p154b0.p156b.AndroidSchedulers;
import p136d.p153c.p159e0.Action;
import p136d.p153c.p159e0.Consumer;
import p136d.p153c.p177h0.RxJavaPlugins;
import p136d.p153c.p179j0.Schedulers;
import p205h.p206a.p207a.AndaHCEManager;
import pt.card4b.backendbeacons.App;
import pt.card4b.backendbeacons.BackendListeners;
import pt.card4b.backendbeacons.DataModels;
import pt.card4b.backendbeacons.Database;

/* renamed from: h.a.a.l */
/* loaded from: classes.dex */
public class Consuela {

    /* renamed from: E */
    public static Handler f9065E;

    /* renamed from: F */
    public static volatile Consuela f9066F;

    /* renamed from: o */
    public DataModels.User f9085o;

    /* renamed from: p */
    public boolean f9086p;

    /* renamed from: a */
    public SparseArray<DataModels.C2704m> f9071a = new SparseArray<>();

    /* renamed from: b */
    public List<DataModels.C2704m> f9072b = new ArrayList();

    /* renamed from: c */
    public Map<String, DataModels.C2701j> f9073c = new HashMap();

    /* renamed from: d */
    public Map<String, DataModels.C2701j> f9074d = new HashMap();

    /* renamed from: e */
    public Map<String, DataModels.C2708q> f9075e = new HashMap();

    /* renamed from: f */
    public Map<String, DataModels.C2708q> f9076f = new HashMap();

    /* renamed from: g */
    public SparseArray<DataModels.C2709r> f9077g = new SparseArray<>();

    /* renamed from: h */
    public Map<String, DataModels.C2697f> f9078h = new HashMap();

    /* renamed from: i */
    public Map<String, DataModels.C2702k> f9079i = new HashMap();

    /* renamed from: j */
    public SparseArray<DataModels.C2703l> f9080j = new SparseArray<>();

    /* renamed from: k */
    public Map<String, DataModels.C2695d> f9081k = new HashMap();

    /* renamed from: l */
    public Map<String, DataModels.CustomerProfile> f9082l = new HashMap();

    /* renamed from: m */
    public Map<String, DataModels.Country> f9083m = new HashMap();

    /* renamed from: n */
    public Map<String, DataModels.Language> f9084n = new HashMap();

    /* renamed from: q */
    public boolean f9087q = false;

    /* renamed from: r */
    public boolean f9088r = false;

    /* renamed from: s */
    public short f9089s = 0;

    /* renamed from: t */
    public boolean f9090t = false;

    /* renamed from: u */
    public short f9091u = 0;

    /* renamed from: v */
    public boolean f9092v = false;

    /* renamed from: w */
    public short f9093w = 0;

    /* renamed from: x */
    public AndaHCEManager.InterfaceC1876m f9094x = new C2105w0();

    /* renamed from: y */
    public Runnable f9095y = new RunnableC2118y0();

    /* renamed from: z */
    public Runnable f9096z = new RunnableC2013a1();

    /* renamed from: A */
    public BroadcastReceiver f9067A = new C2024c1();

    /* renamed from: B */
    public BroadcastReceiver f9068B = new C2032e1(this);

    /* renamed from: C */
    public BroadcastReceiver f9069C = new C2056h1(this);

    /* renamed from: D */
    public BroadcastReceiver f9070D = new C2016b(this);

    /* compiled from: Consuela.java */
    /* renamed from: h.a.a.l$a */
    /* loaded from: classes.dex */
    public class C2011a implements Consumer<List<DataModels.PaymentMethod>> {

        /* renamed from: a */
        public final /* synthetic */ BackendListeners.PaymentMethodsRequestListener f9097a;

        public C2011a(Consuela consuela, BackendListeners.PaymentMethodsRequestListener paymentMethodsRequestListener) {
            this.f9097a = paymentMethodsRequestListener;
        }

        @Override // p136d.p153c.p159e0.Consumer
        /* renamed from: a */
        public void accept(List<DataModels.PaymentMethod> list) {
            this.f9097a.onSuccess(list);
        }
    }

    /* compiled from: Consuela.java */
    /* renamed from: h.a.a.l$a0 */
    /* loaded from: classes.dex */
    public class C2012a0 implements Consumer<Throwable> {

        /* renamed from: a */
        public final /* synthetic */ BackendListeners.InterfaceC2674b f9098a;

        public C2012a0(Consuela consuela, BackendListeners.InterfaceC2674b interfaceC2674b) {
            this.f9098a = interfaceC2674b;
        }

        @Override // p136d.p153c.p159e0.Consumer
        /* renamed from: a */
        public void accept(Throwable th) {
            this.f9098a.onError(GeneralUtils.m1599a(th));
        }
    }

    /* compiled from: Consuela.java */
    /* renamed from: h.a.a.l$a1 */
    /* loaded from: classes.dex */
    public class RunnableC2013a1 implements Runnable {

        /* compiled from: Consuela.java */
        /* renamed from: h.a.a.l$a1$a */
        /* loaded from: classes.dex */
        public class C2014a implements BackendListeners.DisableHCEValidationsListener {
            public C2014a() {
            }

            @Override // pt.card4b.backendbeacons.BackendListeners.BaseRequestListener
            public void onError(DataModels.Error error) {
                Consuela.m1792j().postDelayed(Consuela.this.f9096z, 5000L);
            }

            @Override // pt.card4b.backendbeacons.BackendListeners.DisableHCEValidationsListener
            public void onSuccess() {
                Consuela.m1792j().postDelayed(Consuela.this.f9096z, 60000L);
            }
        }

        /* compiled from: Consuela.java */
        /* renamed from: h.a.a.l$a1$b */
        /* loaded from: classes.dex */
        public class C2015b implements BackendListeners.EnableHCEValidationsListener {
            public C2015b() {
            }

            @Override // pt.card4b.backendbeacons.BackendListeners.BaseRequestListener
            public void onError(DataModels.Error error) {
                Consuela.m1792j().postDelayed(Consuela.this.f9096z, 5000L);
            }

            @Override // pt.card4b.backendbeacons.BackendListeners.EnableHCEValidationsListener
            public void onSuccess() {
                Consuela.m1792j().postDelayed(Consuela.this.f9096z, 60000L);
            }
        }

        public RunnableC2013a1() {
        }

        public void finalize() {
            super.finalize();
        }

        @Override // java.lang.Runnable
        public void run() {
            DataModels.Error m1769x = Consuela.this.m1769x();
            if (m1769x != null && AndaHCEManager.m2184a().m2167c()) {
                Consuela.this.m1810b(new C2014a()).subscribeOn(Schedulers.m3323b()).observeOn(AndroidSchedulers.m3671a()).subscribe();
            } else if (m1769x != null || AndaHCEManager.m2184a().m2167c()) {
                Consuela.m1792j().postDelayed(Consuela.this.f9096z, 60000L);
            } else {
                Consuela.this.m1809b(new C2015b()).subscribeOn(Schedulers.m3323b()).observeOn(AndroidSchedulers.m3671a()).subscribe();
            }
        }
    }

    /* compiled from: Consuela.java */
    /* renamed from: h.a.a.l$b */
    /* loaded from: classes.dex */
    public class C2016b extends BroadcastReceiver {
        public C2016b(Consuela consuela) {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if (intent.getAction().equals("android.net.conn.CONNECTIVITY_CHANGE")) {
                if (GeneralUtils.m1585i()) {
                    AppLog.m2158a("LOGIC_OTHER", "BeaconManager", "connectionStateReceiver", "Internet connection state changed to ON");
                    if (BeaconManager.m1922d().m1913h() != null) {
                        BeaconManager.m1922d().m1913h().onServiceEnabled(DataModels.Service.INTERNET);
                        return;
                    }
                    return;
                }
                AppLog.m2158a("LOGIC_OTHER", "BeaconManager", "connectionStateReceiver", "Internet connection state changed to OFF");
                if (BeaconManager.m1922d().m1913h() != null) {
                    BeaconManager.m1922d().m1913h().onServiceDisabled(DataModels.Service.INTERNET);
                    BeaconManager.m1922d().m1913h().onError(DataModels.Error.noInternet());
                }
            }
        }
    }

    /* compiled from: Consuela.java */
    /* renamed from: h.a.a.l$b0 */
    /* loaded from: classes.dex */
    public class C2017b0 extends Completable {

        /* compiled from: Consuela.java */
        /* renamed from: h.a.a.l$b0$a */
        /* loaded from: classes.dex */
        public class C2018a implements AndaHCEManager.InterfaceC1873j {

            /* renamed from: a */
            public final /* synthetic */ CompletableObserver f9103a;

            public C2018a(C2017b0 c2017b0, CompletableObserver completableObserver) {
                this.f9103a = completableObserver;
            }

            @Override // p205h.p206a.p207a.AndaHCEManager.InterfaceC1873j
            /* renamed from: a */
            public void mo1764a(int i, String str) {
                SharedPrefsController.m1540d().m1549a(new DataModels.C2699h(Consuela.m1790k().m1802e().getId(), null, Boolean.FALSE, null, DataModels.C2699h.f10806o, SysDateManager.m1497d().m1496e(), (str == null || str.equals("")) ? null : null, null));
                this.f9103a.mo3489a();
            }

            @Override // p205h.p206a.p207a.AndaHCEManager.InterfaceC1873j
            public void onSuccess() {
                SharedPrefsController.m1540d().m1549a(new DataModels.C2699h(Consuela.m1790k().m1802e().getId(), null, Boolean.FALSE, null, DataModels.C2699h.f10807p, SysDateManager.m1497d().m1496e(), null, null));
                this.f9103a.mo3489a();
            }
        }

        public C2017b0() {
        }

        @Override // p136d.p153c.Completable
        public void subscribeActual(CompletableObserver completableObserver) {
            if (!AndaHCEManager.m2184a().m2169b()) {
                if (Consuela.this.f9085o != null) {
                    if (!Consuela.this.f9086p) {
                        AppLog.m2158a("LOGIC_BEACONS", "Consuela", "HCEEnroll", "ERROR: " + DataModels.Error.initFailedDataSuspect().getMessage());
                        completableObserver.mo3489a();
                        return;
                    }
                    DataModels.Error m1770w = Consuela.this.m1770w();
                    if (m1770w == null) {
                        AndaHCEManager.m2184a().m2170a(Consuela.this.f9085o.getPhonenumber(), new C2018a(this, completableObserver));
                        return;
                    }
                    AppLog.m2158a("LOGIC_BEACONS", "Consuela", "HCEEnroll", "ERROR: " + m1770w.getMessage());
                    completableObserver.mo3489a();
                    return;
                }
                AppLog.m2158a("LOGIC_BEACONS", "Consuela", "HCEEnroll", "ERROR: " + DataModels.Error.loginRequired().getType().toString());
                completableObserver.mo3489a();
                return;
            }
            completableObserver.mo3489a();
        }
    }

    /* compiled from: Consuela.java */
    /* renamed from: h.a.a.l$b1 */
    /* loaded from: classes.dex */
    public class C2019b1 implements Consumer<Throwable> {

        /* renamed from: a */
        public final /* synthetic */ BackendListeners.GetSavedUserRequestListener f9104a;

        public C2019b1(Consuela consuela, BackendListeners.GetSavedUserRequestListener getSavedUserRequestListener) {
            this.f9104a = getSavedUserRequestListener;
        }

        @Override // p136d.p153c.p159e0.Consumer
        /* renamed from: a */
        public void accept(Throwable th) {
            this.f9104a.onError(GeneralUtils.m1599a(th));
            AppLog.m2158a("LOGIC_USER", "Consuela", "verifyAndGetUser", "onError");
        }
    }

    /* compiled from: Consuela.java */
    /* renamed from: h.a.a.l$c */
    /* loaded from: classes.dex */
    public class C2020c implements Consumer<Throwable> {

        /* renamed from: a */
        public final /* synthetic */ BackendListeners.UpdateUserRequestListener f9105a;

        public C2020c(Consuela consuela, BackendListeners.UpdateUserRequestListener updateUserRequestListener) {
            this.f9105a = updateUserRequestListener;
        }

        @Override // p136d.p153c.p159e0.Consumer
        /* renamed from: a */
        public void accept(Throwable th) {
            this.f9105a.onError(GeneralUtils.m1599a(th));
        }
    }

    /* compiled from: Consuela.java */
    /* renamed from: h.a.a.l$c0 */
    /* loaded from: classes.dex */
    public class C2021c0 implements Consumer<Boolean> {

        /* renamed from: a */
        public final /* synthetic */ DataModels.UserAccountInfo f9106a;

        /* renamed from: b */
        public final /* synthetic */ BackendListeners.UpdateUserRequestListener f9107b;

        /* compiled from: Consuela.java */
        /* renamed from: h.a.a.l$c0$a */
        /* loaded from: classes.dex */
        public class C2022a implements Consumer<Object> {

            /* renamed from: a */
            public final /* synthetic */ Boolean f9109a;

            public C2022a(Boolean bool) {
                this.f9109a = bool;
            }

            @Override // p136d.p153c.p159e0.Consumer
            public void accept(Object obj) {
                C2021c0.this.f9107b.onSuccess(this.f9109a.booleanValue());
            }
        }

        /* compiled from: Consuela.java */
        /* renamed from: h.a.a.l$c0$b */
        /* loaded from: classes.dex */
        public class C2023b implements Consumer<Throwable> {
            public C2023b() {
            }

            @Override // p136d.p153c.p159e0.Consumer
            /* renamed from: a */
            public void accept(Throwable th) {
                C2021c0.this.f9107b.onError(GeneralUtils.m1599a(th));
            }
        }

        public C2021c0(DataModels.UserAccountInfo userAccountInfo, BackendListeners.UpdateUserRequestListener updateUserRequestListener) {
            this.f9106a = userAccountInfo;
            this.f9107b = updateUserRequestListener;
        }

        @Override // p136d.p153c.p159e0.Consumer
        /* renamed from: a */
        public void accept(Boolean bool) {
            Consuela.this.f9085o = this.f9106a.toUser();
            DataManager.m1704a().m1686a(Consuela.this.f9085o).subscribe(new C2022a(bool), new C2023b());
        }
    }

    /* compiled from: Consuela.java */
    /* renamed from: h.a.a.l$c1 */
    /* loaded from: classes.dex */
    public class C2024c1 extends BroadcastReceiver {
        public C2024c1() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if (intent.getAction().equals("android.bluetooth.adapter.action.STATE_CHANGED")) {
                int intExtra = intent.getIntExtra("android.bluetooth.adapter.extra.STATE", 10);
                if (intExtra == 10) {
                    AppLog.m2158a("LOGIC_OTHER", "BeaconManager", "bluetoothStateReceiver", "Bluetooth state changed to OFF");
                    if (BeaconManager.m1922d().m1913h() != null) {
                        BeaconManager.m1922d().m1913h().onServiceDisabled(DataModels.Service.BLUETOOTH);
                        BeaconManager.m1922d().m1913h().onError(DataModels.Error.bluetoothDisabled());
                    }
                    BeaconManager.m1922d().m1941a(false);
                    if (Consuela.this.f9085o == null || BeaconManager.m1922d().m1915g() == null) {
                        return;
                    }
                    SharedPrefsController.m1540d().m1549a(new DataModels.C2699h(Consuela.this.f9085o.getId(), BeaconManager.m1922d().m1915g().m121l(), BeaconManager.m1922d().m1915g().m119n(), BeaconManager.m1922d().m1915g().m120m(), DataModels.C2699h.f10801j, SysDateManager.m1497d().m1496e(), null, null));
                } else if (intExtra != 12) {
                } else {
                    AppLog.m2158a("LOGIC_OTHER", "BeaconManager", "bluetoothStateReceiver", "Bluetooth state changed to ON");
                    if (BeaconManager.m1922d().m1913h() != null) {
                        BeaconManager.m1922d().m1913h().onServiceEnabled(DataModels.Service.BLUETOOTH);
                    }
                    BeaconManager.m1922d().m1941a(true);
                    if (Consuela.this.f9085o == null || BeaconManager.m1922d().m1915g() == null) {
                        return;
                    }
                    SharedPrefsController.m1540d().m1549a(new DataModels.C2699h(Consuela.this.f9085o.getId(), BeaconManager.m1922d().m1915g().m121l(), BeaconManager.m1922d().m1915g().m119n(), BeaconManager.m1922d().m1915g().m120m(), DataModels.C2699h.f10800i, SysDateManager.m1497d().m1496e(), null, null));
                }
            }
        }
    }

    /* compiled from: Consuela.java */
    /* renamed from: h.a.a.l$d */
    /* loaded from: classes.dex */
    public class C2025d implements Consumer<Throwable> {

        /* renamed from: a */
        public final /* synthetic */ BackendListeners.PaymentMethodsRequestListener f9113a;

        public C2025d(Consuela consuela, BackendListeners.PaymentMethodsRequestListener paymentMethodsRequestListener) {
            this.f9113a = paymentMethodsRequestListener;
        }

        @Override // p136d.p153c.p159e0.Consumer
        /* renamed from: a */
        public void accept(Throwable th) {
            this.f9113a.onError(GeneralUtils.m1599a(th));
        }
    }

    /* compiled from: Consuela.java */
    /* renamed from: h.a.a.l$d0 */
    /* loaded from: classes.dex */
    public class C2026d0 implements Consumer<Throwable> {
        public C2026d0(Consuela consuela) {
        }

        @Override // p136d.p153c.p159e0.Consumer
        /* renamed from: a */
        public void accept(Throwable th) {
            if (!(th instanceof UndeliverableException)) {
                throw new Exception(th);
            }
        }
    }

    /* compiled from: Consuela.java */
    /* renamed from: h.a.a.l$d1 */
    /* loaded from: classes.dex */
    public class C2027d1 implements Consumer<List<DataModels.StageInfo>> {

        /* renamed from: a */
        public final /* synthetic */ BackendListeners.HistoricInfoRequestListener f9114a;

        public C2027d1(Consuela consuela, BackendListeners.HistoricInfoRequestListener historicInfoRequestListener) {
            this.f9114a = historicInfoRequestListener;
        }

        @Override // p136d.p153c.p159e0.Consumer
        /* renamed from: a */
        public void accept(List<DataModels.StageInfo> list) {
            this.f9114a.onSuccess(list);
        }
    }

    /* compiled from: Consuela.java */
    /* renamed from: h.a.a.l$e */
    /* loaded from: classes.dex */
    public class C2028e implements Consumer<Object> {

        /* renamed from: a */
        public final /* synthetic */ String f9115a;

        /* renamed from: b */
        public final /* synthetic */ BackendListeners.SendReportListener f9116b;

        public C2028e(String str, BackendListeners.SendReportListener sendReportListener) {
            this.f9115a = str;
            this.f9116b = sendReportListener;
        }

        @Override // p136d.p153c.p159e0.Consumer
        public void accept(Object obj) {
            if (obj != null && (obj instanceof File)) {
                Consuela consuela = Consuela.this;
                String id = consuela.f9085o != null ? Consuela.this.f9085o.getId() : null;
                String str = this.f9115a;
                consuela.m1852a(id, str, "Reports/" + ((File) obj).getName());
                BackendListeners.SendReportListener sendReportListener = this.f9116b;
                if (sendReportListener != null) {
                    sendReportListener.onSuccess();
                    return;
                }
                return;
            }
            BackendListeners.SendReportListener sendReportListener2 = this.f9116b;
            if (sendReportListener2 != null) {
                sendReportListener2.onError(DataModels.Error.failed_to_send_report());
            }
        }
    }

    /* compiled from: Consuela.java */
    /* renamed from: h.a.a.l$e0 */
    /* loaded from: classes.dex */
    public class C2029e0 implements Consumer<DataModels.User> {

        /* renamed from: a */
        public final /* synthetic */ BackendListeners.LoginRequestListener f9118a;

        /* compiled from: Consuela.java */
        /* renamed from: h.a.a.l$e0$a */
        /* loaded from: classes.dex */
        public class C2030a implements Consumer<Throwable> {
            public C2030a() {
            }

            @Override // p136d.p153c.p159e0.Consumer
            /* renamed from: a */
            public void accept(Throwable th) {
                C2029e0.this.f9118a.onError(GeneralUtils.m1599a(th));
            }
        }

        /* compiled from: Consuela.java */
        /* renamed from: h.a.a.l$e0$b */
        /* loaded from: classes.dex */
        public class C2031b implements Action {
            public C2031b() {
            }

            @Override // p136d.p153c.p159e0.Action
            public void run() {
                Consuela.this.m1809b((BackendListeners.EnableHCEValidationsListener) null).subscribeOn(Schedulers.m3323b()).observeOn(AndroidSchedulers.m3671a()).subscribe();
                DataManager.m1704a().m1663d().subscribeOn(Schedulers.m3323b()).subscribe();
                C2029e0 c2029e0 = C2029e0.this;
                c2029e0.f9118a.onSuccess(Consuela.this.f9085o.getCopy());
                AppLog.m2158a("LOGIC_USER", "Consuela", "login", "onSuccess");
            }
        }

        public C2029e0(BackendListeners.LoginRequestListener loginRequestListener) {
            this.f9118a = loginRequestListener;
        }

        @Override // p136d.p153c.p159e0.Consumer
        /* renamed from: a */
        public void accept(DataModels.User user) {
            try {
                Consuela.this.f9085o = user;
                Consuela.m1792j().post(Consuela.this.f9095y);
                Consuela.this.m1855a(DataModels.C2706o.f10847p).doOnComplete(new C2031b()).doOnError(new C2030a()).subscribeOn(Schedulers.m3323b()).observeOn(AndroidSchedulers.m3671a()).subscribe();
            } catch (ClassCastException e) {
                e.printStackTrace();
                this.f9118a.onError(DataModels.Error.internal(e.getLocalizedMessage()));
                AppLog.m2158a("LOGIC_USER", "Consuela", "login", "onSuccess - ClassCastException: " + DataModels.Error.ErrorType.INTERNAL + ";" + e.getMessage());
            }
        }
    }

    /* compiled from: Consuela.java */
    /* renamed from: h.a.a.l$e1 */
    /* loaded from: classes.dex */
    public class C2032e1 extends BroadcastReceiver {
        public C2032e1(Consuela consuela) {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if (intent.getAction().equals("android.location.PROVIDERS_CHANGED")) {
                if (Settings.Secure.getInt(App.getContext().getContentResolver(), "location_mode", 0) == 0) {
                    AppLog.m2158a("LOGIC_OTHER", "BeaconManager", "locationStateReceiver", "location state changed to OFF");
                    if (BeaconManager.m1922d().m1913h() != null) {
                        BeaconManager.m1922d().m1913h().onServiceDisabled(DataModels.Service.LOCATION);
                        BeaconManager.m1922d().m1913h().onError(DataModels.Error.locationDisabled());
                        return;
                    }
                    return;
                }
                AppLog.m2158a("LOGIC_OTHER", "BeaconManager", "locationStateReceiver", "location state changed to ON");
                if (BeaconManager.m1922d().m1913h() != null) {
                    BeaconManager.m1922d().m1913h().onServiceEnabled(DataModels.Service.LOCATION);
                }
            }
        }
    }

    /* compiled from: Consuela.java */
    /* renamed from: h.a.a.l$f */
    /* loaded from: classes.dex */
    public class C2033f implements Consumer<Object> {

        /* renamed from: a */
        public final /* synthetic */ BackendListeners.DefaultRequestListener f9122a;

        public C2033f(Consuela consuela, BackendListeners.DefaultRequestListener defaultRequestListener) {
            this.f9122a = defaultRequestListener;
        }

        @Override // p136d.p153c.p159e0.Consumer
        public void accept(Object obj) {
            this.f9122a.onSuccess();
        }
    }

    /* compiled from: Consuela.java */
    /* renamed from: h.a.a.l$f0 */
    /* loaded from: classes.dex */
    public class C2034f0 implements BackendListeners.InterfaceC2678f {

        /* renamed from: a */
        public final /* synthetic */ BackendListeners.EnableHCEValidationsListener f9123a;

        public C2034f0(BackendListeners.EnableHCEValidationsListener enableHCEValidationsListener) {
            this.f9123a = enableHCEValidationsListener;
        }

        @Override // pt.card4b.backendbeacons.BackendListeners.BaseRequestListener
        public void onError(DataModels.Error error) {
            Consuela.this.m1809b(this.f9123a).subscribeOn(Schedulers.m3323b()).observeOn(AndroidSchedulers.m3671a()).subscribe();
        }

        @Override // pt.card4b.backendbeacons.BackendListeners.InterfaceC2678f
        public void onSuccess(boolean z) {
            Consuela.this.m1809b(this.f9123a).subscribeOn(Schedulers.m3323b()).observeOn(AndroidSchedulers.m3671a()).subscribe();
        }
    }

    /* compiled from: Consuela.java */
    /* renamed from: h.a.a.l$f1 */
    /* loaded from: classes.dex */
    public class C2035f1 implements Consumer<Throwable> {

        /* renamed from: a */
        public final /* synthetic */ BackendListeners.HistoricInfoRequestListener f9125a;

        public C2035f1(Consuela consuela, BackendListeners.HistoricInfoRequestListener historicInfoRequestListener) {
            this.f9125a = historicInfoRequestListener;
        }

        @Override // p136d.p153c.p159e0.Consumer
        /* renamed from: a */
        public void accept(Throwable th) {
            this.f9125a.onError(GeneralUtils.m1599a(th));
        }
    }

    /* compiled from: Consuela.java */
    /* renamed from: h.a.a.l$g */
    /* loaded from: classes.dex */
    public class C2036g implements Consumer<Object> {

        /* renamed from: a */
        public final /* synthetic */ BackendListeners.SelectPaymentMethodRequestListener f9126a;

        public C2036g(Consuela consuela, BackendListeners.SelectPaymentMethodRequestListener selectPaymentMethodRequestListener) {
            this.f9126a = selectPaymentMethodRequestListener;
        }

        @Override // p136d.p153c.p159e0.Consumer
        public void accept(Object obj) {
            this.f9126a.onSuccess(DataModels.PaymentAction.NO_ACTION_NEEDED, null);
        }
    }

    /* compiled from: Consuela.java */
    /* renamed from: h.a.a.l$g0 */
    /* loaded from: classes.dex */
    public class C2037g0 extends Completable {

        /* renamed from: a */
        public final /* synthetic */ boolean f9127a;

        /* renamed from: b */
        public final /* synthetic */ DataModels.C2707p f9128b;

        /* renamed from: c */
        public final /* synthetic */ BackendListeners.InterfaceC2683k f9129c;

        /* compiled from: Consuela.java */
        /* renamed from: h.a.a.l$g0$a */
        /* loaded from: classes.dex */
        public class C2038a implements Action {
            public C2038a() {
            }

            @Override // p136d.p153c.p159e0.Action
            public void run() {
                C2037g0 c2037g0 = C2037g0.this;
                Consuela.this.m1817a(c2037g0.f9128b, c2037g0.f9129c, true).subscribeOn(Schedulers.m3323b()).observeOn(AndroidSchedulers.m3671a()).subscribe();
            }
        }

        /* compiled from: Consuela.java */
        /* renamed from: h.a.a.l$g0$b */
        /* loaded from: classes.dex */
        public class C2039b implements Consumer<Object> {
            public C2039b() {
            }

            @Override // p136d.p153c.p159e0.Consumer
            public void accept(Object obj) {
                AppLog.m2158a("LOGIC_BEACONS", "Consuela", "saveOngoingStage", "Stage state saved successfully");
                Consuela.this.f9092v = false;
                C2037g0.this.f9129c.onSuccess();
            }
        }

        /* compiled from: Consuela.java */
        /* renamed from: h.a.a.l$g0$c */
        /* loaded from: classes.dex */
        public class C2040c implements Consumer<Throwable> {

            /* compiled from: Consuela.java */
            /* renamed from: h.a.a.l$g0$c$a */
            /* loaded from: classes.dex */
            public class C2041a implements Action {
                public C2041a() {
                }

                @Override // p136d.p153c.p159e0.Action
                public void run() {
                    C2037g0 c2037g0 = C2037g0.this;
                    Consuela.this.m1817a(c2037g0.f9128b, c2037g0.f9129c, true).subscribeOn(Schedulers.m3323b()).observeOn(AndroidSchedulers.m3671a()).subscribe();
                }
            }

            public C2040c() {
            }

            @Override // p136d.p153c.p159e0.Consumer
            /* renamed from: a */
            public void accept(Throwable th) {
                Consuela.this.f9092v = false;
                AppLog.m2158a("LOGIC_BEACONS", "Consuela", "saveOngoingStage", "Already saving stage stage, will try again");
                Completable.timer(5L, TimeUnit.SECONDS).subscribeOn(Schedulers.m3323b()).observeOn(AndroidSchedulers.m3671a()).doOnComplete(new C2041a()).subscribe();
            }
        }

        public C2037g0(boolean z, DataModels.C2707p c2707p, BackendListeners.InterfaceC2683k interfaceC2683k) {
            this.f9127a = z;
            this.f9128b = c2707p;
            this.f9129c = interfaceC2683k;
        }

        @Override // p136d.p153c.Completable
        public void subscribeActual(CompletableObserver completableObserver) {
            try {
                if (this.f9127a) {
                    Consuela.m1779p(Consuela.this);
                } else {
                    Consuela.this.f9093w = (short) 0;
                }
            } catch (Throwable th) {
                Consuela.this.f9092v = false;
                BackendListeners.InterfaceC2683k interfaceC2683k = this.f9129c;
                if (interfaceC2683k != null) {
                    interfaceC2683k.onError(GeneralUtils.m1599a(th));
                }
            }
            if (this.f9128b == null) {
                this.f9129c.onError(new DataModels.Error(DataModels.Error.ErrorType.INTERNAL, "Error saving stage state: stage state is null", "Error saving stage state: stage state is null"));
                completableObserver.mo3489a();
            } else if (!this.f9127a || Consuela.this.f9093w < 3) {
                if (!Consuela.this.f9092v) {
                    Consuela.this.f9092v = true;
                    DataManager.m1704a().m1690a(Consuela.this.f9085o.getEmail(), this.f9128b).subscribeOn(Schedulers.m3323b()).observeOn(AndroidSchedulers.m3671a()).subscribe(new C2039b(), new C2040c());
                    completableObserver.mo3489a();
                    return;
                }
                AppLog.m2158a("LOGIC_BEACONS", "Consuela", "saveOngoingStage", "Already saving stage state, will try again ");
                Completable.timer(5L, TimeUnit.SECONDS).subscribeOn(Schedulers.m3323b()).observeOn(AndroidSchedulers.m3671a()).doOnComplete(new C2038a()).subscribe();
                completableObserver.mo3489a();
            } else {
                Consuela.this.f9092v = false;
                BackendListeners.InterfaceC2683k interfaceC2683k2 = this.f9129c;
                if (interfaceC2683k2 != null) {
                    interfaceC2683k2.onError(new DataModels.Error(DataModels.Error.ErrorType.INTERNAL, "ERROR saving stage state", "ERROR saving stage state"));
                }
                completableObserver.mo3489a();
            }
        }
    }

    /* compiled from: Consuela.java */
    /* renamed from: h.a.a.l$g1 */
    /* loaded from: classes.dex */
    public class C2042g1 implements Consumer<List<DataModels.TariffInfo>> {

        /* renamed from: a */
        public final /* synthetic */ Date f9135a;

        /* renamed from: b */
        public final /* synthetic */ BackendListeners.TariffInfoRequestListener f9136b;

        /* compiled from: Consuela.java */
        /* renamed from: h.a.a.l$g1$a */
        /* loaded from: classes.dex */
        public class C2043a implements Consumer<List<DataModels.InvoiceInfo>> {

            /* renamed from: a */
            public final /* synthetic */ List f9138a;

            public C2043a(List list) {
                this.f9138a = list;
            }

            @Override // p136d.p153c.p159e0.Consumer
            /* renamed from: a */
            public void accept(List<DataModels.InvoiceInfo> list) {
                C2042g1.this.f9136b.onSuccess(this.f9138a, list);
            }
        }

        /* compiled from: Consuela.java */
        /* renamed from: h.a.a.l$g1$b */
        /* loaded from: classes.dex */
        public class C2044b implements Consumer<Throwable> {

            /* renamed from: a */
            public final /* synthetic */ List f9140a;

            public C2044b(List list) {
                this.f9140a = list;
            }

            @Override // p136d.p153c.p159e0.Consumer
            /* renamed from: a */
            public void accept(Throwable th) {
                if (GeneralUtils.m1599a(th).getType() == DataModels.Error.ErrorType.NO_RESULTS) {
                    C2042g1.this.f9136b.onSuccess(this.f9140a, new ArrayList());
                } else {
                    C2042g1.this.f9136b.onError(GeneralUtils.m1599a(th));
                }
            }
        }

        public C2042g1(Date date, BackendListeners.TariffInfoRequestListener tariffInfoRequestListener) {
            this.f9135a = date;
            this.f9136b = tariffInfoRequestListener;
        }

        @Override // p136d.p153c.p159e0.Consumer
        /* renamed from: a */
        public void accept(List<DataModels.TariffInfo> list) {
            DataManager.m1704a().m1692a(Consuela.this.f9085o.getEmail(), this.f9135a).subscribeOn(Schedulers.m3323b()).observeOn(AndroidSchedulers.m3671a()).subscribe(new C2043a(list), new C2044b(list));
        }
    }

    /* compiled from: Consuela.java */
    /* renamed from: h.a.a.l$h */
    /* loaded from: classes.dex */
    public class C2045h implements Consumer<Throwable> {

        /* renamed from: a */
        public final /* synthetic */ BackendListeners.SendReportListener f9142a;

        public C2045h(Consuela consuela, BackendListeners.SendReportListener sendReportListener) {
            this.f9142a = sendReportListener;
        }

        @Override // p136d.p153c.p159e0.Consumer
        /* renamed from: a */
        public void accept(Throwable th) {
            BackendListeners.SendReportListener sendReportListener = this.f9142a;
            if (sendReportListener != null) {
                sendReportListener.onError(DataModels.Error.failed_to_send_report());
            }
        }
    }

    /* compiled from: Consuela.java */
    /* renamed from: h.a.a.l$h0 */
    /* loaded from: classes.dex */
    public class C2046h0 extends Completable {

        /* renamed from: a */
        public final /* synthetic */ boolean f9143a;

        /* renamed from: b */
        public final /* synthetic */ BackendListeners.EnableHCEValidationsListener f9144b;

        /* renamed from: c */
        public final /* synthetic */ DataModels.Error f9145c;

        /* compiled from: Consuela.java */
        /* renamed from: h.a.a.l$h0$a */
        /* loaded from: classes.dex */
        public class C2047a implements Action {
            public C2047a() {
            }

            @Override // p136d.p153c.p159e0.Action
            public void run() {
                C2046h0 c2046h0 = C2046h0.this;
                Consuela.this.m1838a(c2046h0.f9144b, true, c2046h0.f9145c).subscribeOn(Schedulers.m3323b()).observeOn(AndroidSchedulers.m3671a()).subscribe();
            }
        }

        /* compiled from: Consuela.java */
        /* renamed from: h.a.a.l$h0$b */
        /* loaded from: classes.dex */
        public class C2048b implements Consumer<Object> {

            /* compiled from: Consuela.java */
            /* renamed from: h.a.a.l$h0$b$a */
            /* loaded from: classes.dex */
            public class C2049a implements Action {
                public C2049a() {
                }

                @Override // p136d.p153c.p159e0.Action
                public void run() {
                    C2046h0 c2046h0 = C2046h0.this;
                    Consuela.this.m1838a(c2046h0.f9144b, true, (DataModels.Error) null).subscribeOn(Schedulers.m3323b()).observeOn(AndroidSchedulers.m3671a()).subscribe();
                }
            }

            public C2048b() {
            }

            @Override // p136d.p153c.p159e0.Consumer
            public void accept(Object obj) {
                Consuela.this.f9088r = false;
                Completable.timer(1L, TimeUnit.SECONDS).subscribeOn(Schedulers.m3323b()).observeOn(AndroidSchedulers.m3671a()).doOnComplete(new C2049a()).subscribe();
            }
        }

        /* compiled from: Consuela.java */
        /* renamed from: h.a.a.l$h0$c */
        /* loaded from: classes.dex */
        public class C2050c implements Consumer<Throwable> {

            /* compiled from: Consuela.java */
            /* renamed from: h.a.a.l$h0$c$a */
            /* loaded from: classes.dex */
            public class C2051a implements Action {

                /* renamed from: a */
                public final /* synthetic */ DataModels.Error f9151a;

                public C2051a(DataModels.Error error) {
                    this.f9151a = error;
                }

                @Override // p136d.p153c.p159e0.Action
                public void run() {
                    C2046h0 c2046h0 = C2046h0.this;
                    Consuela.this.m1838a(c2046h0.f9144b, true, this.f9151a).subscribeOn(Schedulers.m3323b()).observeOn(AndroidSchedulers.m3671a()).subscribe();
                }
            }

            public C2050c() {
            }

            @Override // p136d.p153c.p159e0.Consumer
            /* renamed from: a */
            public void accept(Throwable th) {
                Consuela.this.f9088r = false;
                Completable.timer(1L, TimeUnit.SECONDS).subscribeOn(Schedulers.m3323b()).observeOn(AndroidSchedulers.m3671a()).doOnComplete(new C2051a(SharedPrefsController.m1540d().m1528h() == null ? DataModels.Error.missingRegistrationKey() : null)).subscribe();
            }
        }

        /* compiled from: Consuela.java */
        /* renamed from: h.a.a.l$h0$d */
        /* loaded from: classes.dex */
        public class C2052d implements Action {

            /* compiled from: Consuela.java */
            /* renamed from: h.a.a.l$h0$d$a */
            /* loaded from: classes.dex */
            public class C2053a implements Action {

                /* renamed from: a */
                public final /* synthetic */ DataModels.Error f9154a;

                public C2053a(DataModels.Error error) {
                    this.f9154a = error;
                }

                @Override // p136d.p153c.p159e0.Action
                public void run() {
                    C2046h0 c2046h0 = C2046h0.this;
                    Consuela.this.m1838a(c2046h0.f9144b, true, this.f9154a).subscribeOn(Schedulers.m3323b()).observeOn(AndroidSchedulers.m3671a()).subscribe();
                }
            }

            public C2052d() {
            }

            @Override // p136d.p153c.p159e0.Action
            public void run() {
                Consuela.this.f9088r = false;
                Completable.timer(1L, TimeUnit.SECONDS).subscribeOn(Schedulers.m3323b()).observeOn(AndroidSchedulers.m3671a()).doOnComplete(new C2053a(!AndaHCEManager.m2184a().m2169b() ? DataModels.Error.failed_to_enroll_card() : null)).subscribe();
            }
        }

        /* compiled from: Consuela.java */
        /* renamed from: h.a.a.l$h0$e */
        /* loaded from: classes.dex */
        public class C2054e implements AndaHCEManager.InterfaceC1872i {

            /* compiled from: Consuela.java */
            /* renamed from: h.a.a.l$h0$e$a */
            /* loaded from: classes.dex */
            public class C2055a implements Action {
                public C2055a() {
                }

                @Override // p136d.p153c.p159e0.Action
                public void run() {
                    C2046h0 c2046h0 = C2046h0.this;
                    Consuela.this.m1838a(c2046h0.f9144b, true, (DataModels.Error) null).subscribeOn(Schedulers.m3323b()).observeOn(AndroidSchedulers.m3671a()).subscribe();
                }
            }

            public C2054e() {
            }

            @Override // p205h.p206a.p207a.AndaHCEManager.InterfaceC1872i
            /* renamed from: a */
            public void mo1747a(int i, String str) {
                Consuela.this.f9088r = false;
                AppLog.m2158a("LOGIC_BEACONS", "Consuela", "enableHCEValidations", "Error enabling validations. Will try again");
                Completable.timer(5L, TimeUnit.SECONDS).subscribeOn(Schedulers.m3323b()).observeOn(AndroidSchedulers.m3671a()).doOnComplete(new C2055a()).subscribe();
            }

            @Override // p205h.p206a.p207a.AndaHCEManager.InterfaceC1872i
            public void onSuccess() {
                BackendListeners.EnableHCEValidationsListener enableHCEValidationsListener = C2046h0.this.f9144b;
                if (enableHCEValidationsListener != null) {
                    enableHCEValidationsListener.onSuccess();
                }
                if (BeaconManager.m1922d().m1913h() != null) {
                    BeaconManager.m1922d().m1913h().onServiceEnabled(DataModels.Service.HCE_VALIDATION);
                }
                Consuela.this.f9088r = false;
            }
        }

        public C2046h0(boolean z, BackendListeners.EnableHCEValidationsListener enableHCEValidationsListener, DataModels.Error error) {
            this.f9143a = z;
            this.f9144b = enableHCEValidationsListener;
            this.f9145c = error;
        }

        @Override // p136d.p153c.Completable
        public void subscribeActual(CompletableObserver completableObserver) {
            try {
                if (this.f9143a) {
                    Consuela.m1799f(Consuela.this);
                } else {
                    Consuela.this.f9089s = (short) 0;
                }
                if (AndaHCEManager.m2184a().m2167c()) {
                    BackendListeners.EnableHCEValidationsListener enableHCEValidationsListener = this.f9144b;
                    if (enableHCEValidationsListener != null) {
                        enableHCEValidationsListener.onSuccess();
                    }
                    completableObserver.mo3489a();
                } else if (!this.f9143a || Consuela.this.f9089s < 3) {
                    if (!Consuela.this.f9088r) {
                        Consuela.this.f9088r = true;
                        DataModels.Error m1769x = Consuela.this.m1769x();
                        if (m1769x != null) {
                            if (m1769x.getType() == DataModels.Error.ErrorType.MISSING_REGISTRATION_KEY) {
                                AppLog.m2158a("LOGIC_BEACONS", "Consuela", "enableHCEValidations", "Missing registration key. Will install the device and try again");
                                DataManager.m1704a().m1655e().subscribeOn(Schedulers.m3323b()).observeOn(AndroidSchedulers.m3671a()).subscribe(new C2048b(), new C2050c());
                                completableObserver.mo3489a();
                                return;
                            } else if (m1769x.getType() == DataModels.Error.ErrorType.CARD_NOT_ENROLLED) {
                                AppLog.m2158a("LOGIC_BEACONS", "Consuela", "enableHCEValidations", "Card not enrolled. Will enroll the card and try again");
                                Consuela.this.m1871a().doOnComplete(new C2052d()).subscribeOn(Schedulers.m3323b()).observeOn(AndroidSchedulers.m3671a()).subscribe();
                                completableObserver.mo3489a();
                                return;
                            } else {
                                AppLog.m2158a("LOGIC_BEACONS", "Consuela", "enableHCEValidations", "Enable validations not allowed: " + m1769x.getMessage());
                                BackendListeners.EnableHCEValidationsListener enableHCEValidationsListener2 = this.f9144b;
                                if (enableHCEValidationsListener2 != null) {
                                    enableHCEValidationsListener2.onError(m1769x);
                                }
                                completableObserver.mo3489a();
                                Consuela.this.f9088r = false;
                                return;
                            }
                        }
                        AndaHCEManager.m2184a().m2181a(new C2054e());
                        completableObserver.mo3489a();
                        return;
                    }
                    AppLog.m2158a("LOGIC_BEACONS", "Consuela", "enableHCEValidations", "Already enabling validations. Will try again");
                    Completable.timer(5L, TimeUnit.SECONDS).subscribeOn(Schedulers.m3323b()).observeOn(AndroidSchedulers.m3671a()).doOnComplete(new C2047a()).subscribe();
                    completableObserver.mo3489a();
                } else {
                    Consuela.this.f9088r = false;
                    BackendListeners.EnableHCEValidationsListener enableHCEValidationsListener3 = this.f9144b;
                    if (enableHCEValidationsListener3 != null) {
                        DataModels.Error error = this.f9145c;
                        if (error == null) {
                            error = new DataModels.Error(DataModels.Error.ErrorType.INTERNAL, "ERROR enabling HCE validations", "ERROR enabling HCE validations");
                        }
                        enableHCEValidationsListener3.onError(error);
                    }
                    completableObserver.mo3489a();
                }
            } catch (Throwable th) {
                BackendListeners.EnableHCEValidationsListener enableHCEValidationsListener4 = this.f9144b;
                if (enableHCEValidationsListener4 != null) {
                    enableHCEValidationsListener4.onError(GeneralUtils.m1599a(th));
                }
                Consuela.this.f9088r = false;
                completableObserver.mo3489a();
            }
        }
    }

    /* compiled from: Consuela.java */
    /* renamed from: h.a.a.l$h1 */
    /* loaded from: classes.dex */
    public class C2056h1 extends BroadcastReceiver {
        public C2056h1(Consuela consuela) {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if (intent.getAction().equals("android.nfc.action.ADAPTER_STATE_CHANGED")) {
                int intExtra = intent.getIntExtra("android.nfc.extra.ADAPTER_STATE", 1);
                if (intExtra == 1) {
                    AppLog.m2158a("LOGIC_OTHER", "BeaconManager", "nfcStateReceiver", "NFC state changed to OFF");
                    if (BeaconManager.m1922d().m1913h() != null) {
                        BeaconManager.m1922d().m1913h().onServiceDisabled(DataModels.Service.NFC);
                        BeaconManager.m1922d().m1913h().onError(DataModels.Error.nfcDisabled());
                    }
                } else if (intExtra != 3) {
                } else {
                    AppLog.m2158a("LOGIC_OTHER", "BeaconManager", "nfcStateReceiver", "NFC state changed to ON");
                    if (BeaconManager.m1922d().m1913h() != null) {
                        BeaconManager.m1922d().m1913h().onServiceEnabled(DataModels.Service.NFC);
                    }
                }
            }
        }
    }

    /* compiled from: Consuela.java */
    /* renamed from: h.a.a.l$i */
    /* loaded from: classes.dex */
    public class C2057i implements Consumer<Throwable> {

        /* renamed from: a */
        public final /* synthetic */ BackendListeners.DefaultRequestListener f9158a;

        public C2057i(Consuela consuela, BackendListeners.DefaultRequestListener defaultRequestListener) {
            this.f9158a = defaultRequestListener;
        }

        @Override // p136d.p153c.p159e0.Consumer
        /* renamed from: a */
        public void accept(Throwable th) {
            this.f9158a.onError(GeneralUtils.m1599a(th));
        }
    }

    /* compiled from: Consuela.java */
    /* renamed from: h.a.a.l$i0 */
    /* loaded from: classes.dex */
    public class C2058i0 extends Completable {

        /* renamed from: a */
        public final /* synthetic */ boolean f9159a;

        /* renamed from: b */
        public final /* synthetic */ BackendListeners.DisableHCEValidationsListener f9160b;

        /* compiled from: Consuela.java */
        /* renamed from: h.a.a.l$i0$a */
        /* loaded from: classes.dex */
        public class C2059a implements Action {
            public C2059a() {
            }

            @Override // p136d.p153c.p159e0.Action
            public void run() {
                C2058i0 c2058i0 = C2058i0.this;
                Consuela.this.m1840a(c2058i0.f9160b, true).subscribeOn(Schedulers.m3323b()).observeOn(AndroidSchedulers.m3671a()).subscribe();
            }
        }

        /* compiled from: Consuela.java */
        /* renamed from: h.a.a.l$i0$b */
        /* loaded from: classes.dex */
        public class C2060b implements AndaHCEManager.InterfaceC1871h {

            /* compiled from: Consuela.java */
            /* renamed from: h.a.a.l$i0$b$a */
            /* loaded from: classes.dex */
            public class C2061a implements Action {
                public C2061a() {
                }

                @Override // p136d.p153c.p159e0.Action
                public void run() {
                    C2058i0 c2058i0 = C2058i0.this;
                    Consuela.this.m1840a(c2058i0.f9160b, true).subscribeOn(Schedulers.m3323b()).observeOn(AndroidSchedulers.m3671a()).subscribe();
                }
            }

            public C2060b() {
            }

            @Override // p205h.p206a.p207a.AndaHCEManager.InterfaceC1871h
            /* renamed from: a */
            public void mo1745a(int i, String str) {
                Consuela.this.f9090t = false;
                AppLog.m2158a("LOGIC_BEACONS", "Consuela", "disableHCEValidations", "Error disabling validations. Will try again");
                Completable.timer(5L, TimeUnit.SECONDS).subscribeOn(Schedulers.m3323b()).observeOn(AndroidSchedulers.m3671a()).doOnComplete(new C2061a()).subscribe();
            }

            @Override // p205h.p206a.p207a.AndaHCEManager.InterfaceC1871h
            public void onSuccess() {
                Consuela.this.f9090t = false;
                BackendListeners.DisableHCEValidationsListener disableHCEValidationsListener = C2058i0.this.f9160b;
                if (disableHCEValidationsListener != null) {
                    disableHCEValidationsListener.onSuccess();
                }
                if (BeaconManager.m1922d().m1913h() != null) {
                    BeaconManager.m1922d().m1913h().onServiceDisabled(DataModels.Service.HCE_VALIDATION);
                }
            }
        }

        public C2058i0(boolean z, BackendListeners.DisableHCEValidationsListener disableHCEValidationsListener) {
            this.f9159a = z;
            this.f9160b = disableHCEValidationsListener;
        }

        @Override // p136d.p153c.Completable
        public void subscribeActual(CompletableObserver completableObserver) {
            try {
                if (this.f9159a) {
                    Consuela.m1789k(Consuela.this);
                } else {
                    Consuela.this.f9091u = (short) 0;
                }
            } catch (Throwable th) {
                Consuela.this.f9090t = false;
                BackendListeners.DisableHCEValidationsListener disableHCEValidationsListener = this.f9160b;
                if (disableHCEValidationsListener != null) {
                    disableHCEValidationsListener.onError(GeneralUtils.m1599a(th));
                }
            }
            if (!AndaHCEManager.m2184a().m2167c()) {
                BackendListeners.DisableHCEValidationsListener disableHCEValidationsListener2 = this.f9160b;
                if (disableHCEValidationsListener2 != null) {
                    disableHCEValidationsListener2.onSuccess();
                }
                completableObserver.mo3489a();
            } else if (!this.f9159a || Consuela.this.f9091u < 3) {
                if (!Consuela.this.f9090t) {
                    Consuela.this.f9090t = true;
                    AndaHCEManager.m2184a().m2182a(new C2060b());
                    completableObserver.mo3489a();
                    return;
                }
                AppLog.m2158a("LOGIC_BEACONS", "Consuela", "disableHCEValidations", "Already disabling validations. Will try again");
                Completable.timer(5L, TimeUnit.SECONDS).subscribeOn(Schedulers.m3323b()).observeOn(AndroidSchedulers.m3671a()).doOnComplete(new C2059a()).subscribe();
                completableObserver.mo3489a();
            } else {
                Consuela.this.f9090t = false;
                BackendListeners.DisableHCEValidationsListener disableHCEValidationsListener3 = this.f9160b;
                if (disableHCEValidationsListener3 != null) {
                    disableHCEValidationsListener3.onError(new DataModels.Error(DataModels.Error.ErrorType.INTERNAL, "ERROR disabling HCE validations", "ERROR disabling HCE validations"));
                }
                completableObserver.mo3489a();
            }
        }
    }

    /* compiled from: Consuela.java */
    /* renamed from: h.a.a.l$i1 */
    /* loaded from: classes.dex */
    public class C2062i1 implements Consumer<Object> {

        /* renamed from: a */
        public final /* synthetic */ BackendListeners.CreateCustomerRequestListener f9165a;

        public C2062i1(Consuela consuela, BackendListeners.CreateCustomerRequestListener createCustomerRequestListener) {
            this.f9165a = createCustomerRequestListener;
        }

        @Override // p136d.p153c.p159e0.Consumer
        public void accept(Object obj) {
            this.f9165a.onSuccess();
        }
    }

    /* compiled from: Consuela.java */
    /* renamed from: h.a.a.l$j */
    /* loaded from: classes.dex */
    public class C2063j implements Consumer<Object> {

        /* renamed from: a */
        public final /* synthetic */ BackendListeners.InitialConfigurationRequestListener f9166a;

        /* compiled from: Consuela.java */
        /* renamed from: h.a.a.l$j$a */
        /* loaded from: classes.dex */
        public class C2064a implements Consumer<Object> {

            /* compiled from: Consuela.java */
            /* renamed from: h.a.a.l$j$a$a */
            /* loaded from: classes.dex */
            public class C2065a implements Consumer<Throwable> {
                public C2065a() {
                }

                @Override // p136d.p153c.p159e0.Consumer
                /* renamed from: a */
                public void accept(Throwable th) {
                    C2063j.this.f9166a.onError(GeneralUtils.m1599a(th));
                }
            }

            /* compiled from: Consuela.java */
            /* renamed from: h.a.a.l$j$a$b */
            /* loaded from: classes.dex */
            public class C2066b implements Action {
                public C2066b() {
                }

                @Override // p136d.p153c.p159e0.Action
                public void run() {
                    SharedPrefsController.m1540d().m1547a(false);
                    C2063j.this.f9166a.onSuccess();
                }
            }

            public C2064a() {
            }

            @Override // p136d.p153c.p159e0.Consumer
            public void accept(Object obj) {
                Consuela.this.m1855a(DataModels.C2706o.f10847p).doOnComplete(new C2066b()).doOnError(new C2065a()).subscribeOn(Schedulers.m3323b()).observeOn(AndroidSchedulers.m3671a()).subscribe();
            }
        }

        /* compiled from: Consuela.java */
        /* renamed from: h.a.a.l$j$b */
        /* loaded from: classes.dex */
        public class C2067b implements Consumer<Throwable> {
            public C2067b() {
            }

            @Override // p136d.p153c.p159e0.Consumer
            /* renamed from: a */
            public void accept(Throwable th) {
                C2063j.this.f9166a.onError(GeneralUtils.m1599a(th));
            }
        }

        public C2063j(BackendListeners.InitialConfigurationRequestListener initialConfigurationRequestListener) {
            this.f9166a = initialConfigurationRequestListener;
        }

        @Override // p136d.p153c.p159e0.Consumer
        public void accept(Object obj) {
            DataManager.m1704a().m1698a(Boolean.TRUE, Boolean.FALSE).subscribeOn(Schedulers.m3323b()).observeOn(AndroidSchedulers.m3671a()).subscribe(new C2064a(), new C2067b());
        }
    }

    /* compiled from: Consuela.java */
    /* renamed from: h.a.a.l$j0 */
    /* loaded from: classes.dex */
    public class C2068j0 implements Consumer<Object> {

        /* renamed from: a */
        public final /* synthetic */ BackendListeners.InterfaceC2681i f9172a;

        public C2068j0(Consuela consuela, BackendListeners.InterfaceC2681i interfaceC2681i) {
            this.f9172a = interfaceC2681i;
        }

        @Override // p136d.p153c.p159e0.Consumer
        public void accept(Object obj) {
            this.f9172a.onSuccess();
        }
    }

    /* compiled from: Consuela.java */
    /* renamed from: h.a.a.l$j1 */
    /* loaded from: classes.dex */
    public class C2069j1 implements Consumer<Throwable> {

        /* renamed from: a */
        public final /* synthetic */ BackendListeners.TariffInfoRequestListener f9173a;

        public C2069j1(Consuela consuela, BackendListeners.TariffInfoRequestListener tariffInfoRequestListener) {
            this.f9173a = tariffInfoRequestListener;
        }

        @Override // p136d.p153c.p159e0.Consumer
        /* renamed from: a */
        public void accept(Throwable th) {
            this.f9173a.onError(GeneralUtils.m1599a(th));
        }
    }

    /* compiled from: Consuela.java */
    /* renamed from: h.a.a.l$k */
    /* loaded from: classes.dex */
    public class C2070k implements Consumer<Throwable> {

        /* renamed from: a */
        public final /* synthetic */ BackendListeners.SelectPaymentMethodRequestListener f9174a;

        public C2070k(Consuela consuela, BackendListeners.SelectPaymentMethodRequestListener selectPaymentMethodRequestListener) {
            this.f9174a = selectPaymentMethodRequestListener;
        }

        @Override // p136d.p153c.p159e0.Consumer
        /* renamed from: a */
        public void accept(Throwable th) {
            this.f9174a.onError(GeneralUtils.m1599a(th));
        }
    }

    /* compiled from: Consuela.java */
    /* renamed from: h.a.a.l$k0 */
    /* loaded from: classes.dex */
    public class C2071k0 implements AndaHCEManager.InterfaceC1875l {
        public C2071k0(Consuela consuela) {
        }

        @Override // p205h.p206a.p207a.AndaHCEManager.InterfaceC1875l
        /* renamed from: a */
        public void mo1740a() {
        }

        @Override // p205h.p206a.p207a.AndaHCEManager.InterfaceC1875l
        /* renamed from: a */
        public void mo1739a(int i, String str) {
            AppLog.m2158a("LOGIC_HCE", "Consuela", "Synchronize Failed", "Code: " + i + " errorMessage: " + str);
        }
    }

    /* compiled from: Consuela.java */
    /* renamed from: h.a.a.l$l */
    /* loaded from: classes.dex */
    public class C2072l implements Consumer<Object> {

        /* renamed from: a */
        public final /* synthetic */ BackendListeners.SyncConfigurationDataRequestListener f9175a;

        public C2072l(Consuela consuela, BackendListeners.SyncConfigurationDataRequestListener syncConfigurationDataRequestListener) {
            this.f9175a = syncConfigurationDataRequestListener;
        }

        @Override // p136d.p153c.p159e0.Consumer
        public void accept(Object obj) {
            BackendListeners.SyncConfigurationDataRequestListener syncConfigurationDataRequestListener = this.f9175a;
            if (syncConfigurationDataRequestListener != null) {
                syncConfigurationDataRequestListener.onSuccess();
            }
        }
    }

    /* compiled from: Consuela.java */
    /* renamed from: h.a.a.l$l0 */
    /* loaded from: classes.dex */
    public class C2073l0 implements Consumer<Throwable> {

        /* renamed from: a */
        public final /* synthetic */ BackendListeners.InterfaceC2681i f9176a;

        public C2073l0(Consuela consuela, BackendListeners.InterfaceC2681i interfaceC2681i) {
            this.f9176a = interfaceC2681i;
        }

        @Override // p136d.p153c.p159e0.Consumer
        /* renamed from: a */
        public void accept(Throwable th) {
            this.f9176a.onError(GeneralUtils.m1599a(th));
        }
    }

    /* compiled from: Consuela.java */
    /* renamed from: h.a.a.l$m */
    /* loaded from: classes.dex */
    public class C2074m implements Consumer<Throwable> {

        /* renamed from: a */
        public final /* synthetic */ BackendListeners.LoginRequestListener f9177a;

        public C2074m(Consuela consuela, BackendListeners.LoginRequestListener loginRequestListener) {
            this.f9177a = loginRequestListener;
        }

        @Override // p136d.p153c.p159e0.Consumer
        /* renamed from: a */
        public void accept(Throwable th) {
            this.f9177a.onError(GeneralUtils.m1599a(th));
        }
    }

    /* compiled from: Consuela.java */
    /* renamed from: h.a.a.l$m0 */
    /* loaded from: classes.dex */
    public class C2075m0 implements Consumer<DataModels.C2696e> {

        /* renamed from: a */
        public final /* synthetic */ String f9178a;

        /* renamed from: b */
        public final /* synthetic */ BackendListeners.InterfaceC2678f f9179b;

        /* compiled from: Consuela.java */
        /* renamed from: h.a.a.l$m0$a */
        /* loaded from: classes.dex */
        public class C2076a implements Consumer<Throwable> {
            public C2076a(C2075m0 c2075m0) {
            }

            @Override // p136d.p153c.p159e0.Consumer
            /* renamed from: a */
            public void accept(Throwable th) {
            }
        }

        /* compiled from: Consuela.java */
        /* renamed from: h.a.a.l$m0$b */
        /* loaded from: classes.dex */
        public class C2077b implements Action {
            public C2077b() {
            }

            @Override // p136d.p153c.p159e0.Action
            public void run() {
                BeaconManager m1922d = BeaconManager.m1922d();
                if (Consuela.this.f9085o == null || m1922d.m1913h() == null) {
                    return;
                }
                m1922d.m1913h().onLogoutRequired();
            }
        }

        /* compiled from: Consuela.java */
        /* renamed from: h.a.a.l$m0$c */
        /* loaded from: classes.dex */
        public class C2078c implements Consumer<Object> {
            public C2078c(C2075m0 c2075m0) {
            }

            @Override // p136d.p153c.p159e0.Consumer
            public void accept(Object obj) {
            }
        }

        /* compiled from: Consuela.java */
        /* renamed from: h.a.a.l$m0$d */
        /* loaded from: classes.dex */
        public class C2079d implements Consumer<Throwable> {
            public C2079d(C2075m0 c2075m0) {
            }

            @Override // p136d.p153c.p159e0.Consumer
            /* renamed from: a */
            public void accept(Throwable th) {
            }
        }

        public C2075m0(String str, BackendListeners.InterfaceC2678f interfaceC2678f) {
            this.f9178a = str;
            this.f9179b = interfaceC2678f;
        }

        @Override // p136d.p153c.p159e0.Consumer
        /* renamed from: a */
        public void accept(DataModels.C2696e c2696e) {
            String str;
            if (c2696e.m189e()) {
                SharedPrefsController.m1540d().m1553a(this.f9178a, new Date(GeneralUtils.m1598a(c2696e.m188f()) + ((Consuela.this.f9078h.containsKey("START_OFFLINE_RANGE_MINS") ? Integer.parseInt(((DataModels.C2697f) Consuela.this.f9078h.get("START_OFFLINE_RANGE_MINS")).m187a()) : 60) * 60 * 1000)), null);
                Consuela.this.m1809b((BackendListeners.EnableHCEValidationsListener) null).subscribeOn(Schedulers.m3323b()).observeOn(AndroidSchedulers.m3671a()).subscribe();
            } else {
                SharedPrefsController m1540d = SharedPrefsController.m1540d();
                String str2 = this.f9178a;
                Date date = new Date(0L);
                StringBuilder sb = new StringBuilder();
                if (c2696e.m192b() != null) {
                    str = c2696e.m192b() + ";";
                } else {
                    str = "";
                }
                sb.append(str);
                sb.append(c2696e.m193a() != null ? c2696e.m193a() : "");
                m1540d.m1553a(str2, date, sb.toString());
                Consuela.this.m1810b((BackendListeners.DisableHCEValidationsListener) null).subscribeOn(Schedulers.m3323b()).observeOn(AndroidSchedulers.m3671a()).subscribe();
            }
            if (c2696e.m190d()) {
                Consuela.this.m1810b((BackendListeners.DisableHCEValidationsListener) null).subscribeOn(Schedulers.m3323b()).observeOn(AndroidSchedulers.m3671a()).subscribe();
                Consuela.this.m1855a(DataModels.C2706o.f10839C).doOnComplete(new C2077b()).doOnError(new C2076a(this)).subscribeOn(Schedulers.m3323b()).observeOn(AndroidSchedulers.m3671a()).subscribe();
            }
            if (c2696e.m191c() != null) {
                DataManager.m1704a();
                Date m1559a = DataManager.m1673c() ? SharedPrefsController.m1540d().m1559a() : null;
                if (m1559a == null || m1559a.before(c2696e.m191c())) {
                    DataManager m1704a = DataManager.m1704a();
                    Boolean bool = Boolean.FALSE;
                    m1704a.m1698a(bool, bool).subscribeOn(Schedulers.m3323b()).observeOn(AndroidSchedulers.m3671a()).subscribe(new C2078c(this), new C2079d(this));
                }
            }
            BackendListeners.InterfaceC2678f interfaceC2678f = this.f9179b;
            if (interfaceC2678f != null) {
                interfaceC2678f.onSuccess(c2696e.m189e());
            }
        }
    }

    /* compiled from: Consuela.java */
    /* renamed from: h.a.a.l$n */
    /* loaded from: classes.dex */
    public class C2080n implements Consumer<Throwable> {

        /* renamed from: a */
        public final /* synthetic */ BackendListeners.SyncConfigurationDataRequestListener f9182a;

        public C2080n(Consuela consuela, BackendListeners.SyncConfigurationDataRequestListener syncConfigurationDataRequestListener) {
            this.f9182a = syncConfigurationDataRequestListener;
        }

        @Override // p136d.p153c.p159e0.Consumer
        /* renamed from: a */
        public void accept(Throwable th) {
            BackendListeners.SyncConfigurationDataRequestListener syncConfigurationDataRequestListener = this.f9182a;
            if (syncConfigurationDataRequestListener != null) {
                syncConfigurationDataRequestListener.onError(GeneralUtils.m1599a(th));
            }
        }
    }

    /* compiled from: Consuela.java */
    /* renamed from: h.a.a.l$n0 */
    /* loaded from: classes.dex */
    public class C2081n0 implements Consumer<DataModels.NewStageStartInfo> {

        /* renamed from: a */
        public final /* synthetic */ BackendListeners.InterfaceC2688p f9183a;

        public C2081n0(BackendListeners.InterfaceC2688p interfaceC2688p) {
            this.f9183a = interfaceC2688p;
        }

        @Override // p136d.p153c.p159e0.Consumer
        /* renamed from: a */
        public void accept(DataModels.NewStageStartInfo newStageStartInfo) {
            AppLog.m2141e(newStageStartInfo.getId());
            Consuela consuela = Consuela.this;
            consuela.m1853a(consuela.f9085o.getId(), newStageStartInfo.getId(), Boolean.valueOf(newStageStartInfo.getStartOffline()), newStageStartInfo.getStartDate());
            this.f9183a.mo333a(newStageStartInfo);
        }
    }

    /* compiled from: Consuela.java */
    /* renamed from: h.a.a.l$o */
    /* loaded from: classes.dex */
    public class C2082o implements Consumer<Throwable> {

        /* renamed from: a */
        public final /* synthetic */ BackendListeners.InitialConfigurationRequestListener f9185a;

        public C2082o(Consuela consuela, BackendListeners.InitialConfigurationRequestListener initialConfigurationRequestListener) {
            this.f9185a = initialConfigurationRequestListener;
        }

        @Override // p136d.p153c.p159e0.Consumer
        /* renamed from: a */
        public void accept(Throwable th) {
            this.f9185a.onError(GeneralUtils.m1599a(th));
        }
    }

    /* compiled from: Consuela.java */
    /* renamed from: h.a.a.l$o0 */
    /* loaded from: classes.dex */
    public class C2083o0 implements Consumer<Throwable> {

        /* renamed from: a */
        public final /* synthetic */ Collection f9186a;

        /* renamed from: b */
        public final /* synthetic */ BackendListeners.InterfaceC2688p f9187b;

        /* compiled from: Consuela.java */
        /* renamed from: h.a.a.l$o0$a */
        /* loaded from: classes.dex */
        public class C2084a implements Consumer<DataModels.NewStageStartInfo> {
            public C2084a() {
            }

            @Override // p136d.p153c.p159e0.Consumer
            /* renamed from: a */
            public void accept(DataModels.NewStageStartInfo newStageStartInfo) {
                AppLog.m2141e(newStageStartInfo.getId());
                Consuela consuela = Consuela.this;
                consuela.m1853a(consuela.f9085o.getId(), newStageStartInfo.getId(), Boolean.valueOf(newStageStartInfo.getStartOffline()), newStageStartInfo.getStartDate());
                C2083o0.this.f9187b.mo333a(newStageStartInfo);
            }
        }

        /* compiled from: Consuela.java */
        /* renamed from: h.a.a.l$o0$b */
        /* loaded from: classes.dex */
        public class C2085b implements Consumer<Throwable> {
            public C2085b() {
            }

            @Override // p136d.p153c.p159e0.Consumer
            /* renamed from: a */
            public void accept(Throwable th) {
                DataModels.Error m1599a = GeneralUtils.m1599a(th);
                AppLog.m2158a("LOGIC_BEACONS", "Consuela", "stageStart", "Online start - ERROR: " + m1599a.getType().toString());
                C2083o0.this.f9187b.onError(GeneralUtils.m1599a(th));
            }
        }

        public C2083o0(Collection collection, BackendListeners.InterfaceC2688p interfaceC2688p) {
            this.f9186a = collection;
            this.f9187b = interfaceC2688p;
        }

        @Override // p136d.p153c.p159e0.Consumer
        /* renamed from: a */
        public void accept(Throwable th) {
            DataModels.Error m1599a = GeneralUtils.m1599a(th);
            AppLog.m2158a("LOGIC_BEACONS", "Consuela", "stageStart", "Offline start - ERROR: " + m1599a.getType().toString());
            DataManager.m1704a().m1691a(String.valueOf(Consuela.this.f9085o.getId()), (List<DataModels.C2692b>) new ArrayList(this.f9186a), false, Consuela.this.f9085o.getEmail()).subscribeOn(Schedulers.m3323b()).observeOn(AndroidSchedulers.m3671a()).subscribe(new C2084a(), new C2085b());
        }
    }

    /* compiled from: Consuela.java */
    /* renamed from: h.a.a.l$p */
    /* loaded from: classes.dex */
    public class C2086p implements BackendListeners.HasOngoingStageListener {

        /* renamed from: a */
        public final /* synthetic */ BackendListeners.LogoutRequestListener f9191a;

        /* compiled from: Consuela.java */
        /* renamed from: h.a.a.l$p$a */
        /* loaded from: classes.dex */
        public class C2087a implements Consumer<Object> {
            public C2087a() {
            }

            @Override // p136d.p153c.p159e0.Consumer
            public void accept(Object obj) {
                Consuela.this.f9085o = null;
                Consuela.this.m1810b((BackendListeners.DisableHCEValidationsListener) null).subscribeOn(Schedulers.m3323b()).observeOn(AndroidSchedulers.m3671a()).subscribe();
                DataManager.m1704a().m1663d().subscribeOn(Schedulers.m3323b()).subscribe();
                C2086p.this.f9191a.onSuccess();
            }
        }

        /* compiled from: Consuela.java */
        /* renamed from: h.a.a.l$p$b */
        /* loaded from: classes.dex */
        public class C2088b implements Consumer<Throwable> {
            public C2088b() {
            }

            @Override // p136d.p153c.p159e0.Consumer
            /* renamed from: a */
            public void accept(Throwable th) {
                C2086p.this.f9191a.onError(GeneralUtils.m1599a(th));
            }
        }

        public C2086p(BackendListeners.LogoutRequestListener logoutRequestListener) {
            this.f9191a = logoutRequestListener;
        }

        @Override // pt.card4b.backendbeacons.BackendListeners.BaseRequestListener
        public void onError(DataModels.Error error) {
            this.f9191a.onError(error);
        }

        @Override // pt.card4b.backendbeacons.BackendListeners.HasOngoingStageListener
        public void onSuccess(boolean z) {
            if (z) {
                this.f9191a.onError(DataModels.Error.stageOngoing());
            } else {
                DataManager.m1704a().m1616p(Consuela.this.f9085o.getEmail()).subscribeOn(Schedulers.m3323b()).observeOn(AndroidSchedulers.m3671a()).subscribe(new C2087a(), new C2088b());
            }
        }
    }

    /* compiled from: Consuela.java */
    /* renamed from: h.a.a.l$p0 */
    /* loaded from: classes.dex */
    public class C2089p0 implements Consumer<Throwable> {

        /* renamed from: a */
        public final /* synthetic */ BackendListeners.InterfaceC2678f f9195a;

        public C2089p0(Consuela consuela, BackendListeners.InterfaceC2678f interfaceC2678f) {
            this.f9195a = interfaceC2678f;
        }

        @Override // p136d.p153c.p159e0.Consumer
        /* renamed from: a */
        public void accept(Throwable th) {
            BackendListeners.InterfaceC2678f interfaceC2678f = this.f9195a;
            if (interfaceC2678f != null) {
                interfaceC2678f.onError(GeneralUtils.m1599a(th));
            }
        }
    }

    /* compiled from: Consuela.java */
    /* renamed from: h.a.a.l$q0 */
    /* loaded from: classes.dex */
    public class C2091q0 implements Consumer<Object> {

        /* renamed from: a */
        public final /* synthetic */ BackendListeners.GetLogListener f9197a;

        public C2091q0(Consuela consuela, BackendListeners.GetLogListener getLogListener) {
            this.f9197a = getLogListener;
        }

        @Override // p136d.p153c.p159e0.Consumer
        public void accept(Object obj) {
            if (obj != null && (obj instanceof File)) {
                BackendListeners.GetLogListener getLogListener = this.f9197a;
                if (getLogListener != null) {
                    getLogListener.onSuccess(((File) obj).getPath());
                    return;
                }
                return;
            }
            BackendListeners.GetLogListener getLogListener2 = this.f9197a;
            if (getLogListener2 != null) {
                getLogListener2.onError(new DataModels.Error(DataModels.Error.ErrorType.INTERNAL, "Error getting lib log", "Error getting lib log"));
            }
        }
    }

    /* compiled from: Consuela.java */
    /* renamed from: h.a.a.l$r */
    /* loaded from: classes.dex */
    public class C2092r implements Consumer<Boolean> {

        /* renamed from: a */
        public final /* synthetic */ BackendListeners.HasOngoingStageListener f9198a;

        public C2092r(Consuela consuela, BackendListeners.HasOngoingStageListener hasOngoingStageListener) {
            this.f9198a = hasOngoingStageListener;
        }

        @Override // p136d.p153c.p159e0.Consumer
        /* renamed from: a */
        public void accept(Boolean bool) {
            this.f9198a.onSuccess(bool.booleanValue());
        }
    }

    /* compiled from: Consuela.java */
    /* renamed from: h.a.a.l$r0 */
    /* loaded from: classes.dex */
    public class C2093r0 implements Consumer<Object> {

        /* renamed from: a */
        public final /* synthetic */ BackendListeners.InterfaceC2686n f9199a;

        public C2093r0(Consuela consuela, BackendListeners.InterfaceC2686n interfaceC2686n) {
            this.f9199a = interfaceC2686n;
        }

        @Override // p136d.p153c.p159e0.Consumer
        public void accept(Object obj) {
            this.f9199a.onSuccess();
        }
    }

    /* compiled from: Consuela.java */
    /* renamed from: h.a.a.l$s */
    /* loaded from: classes.dex */
    public class C2094s implements Consumer<Object> {

        /* renamed from: a */
        public final /* synthetic */ BackendListeners.SendInvoiceEmailListener f9200a;

        public C2094s(Consuela consuela, BackendListeners.SendInvoiceEmailListener sendInvoiceEmailListener) {
            this.f9200a = sendInvoiceEmailListener;
        }

        @Override // p136d.p153c.p159e0.Consumer
        public void accept(Object obj) {
            BackendListeners.SendInvoiceEmailListener sendInvoiceEmailListener = this.f9200a;
            if (sendInvoiceEmailListener != null) {
                sendInvoiceEmailListener.onSuccess();
            }
        }
    }

    /* compiled from: Consuela.java */
    /* renamed from: h.a.a.l$s0 */
    /* loaded from: classes.dex */
    public class C2095s0 implements Consumer<DataModels.UserAccountInfo> {

        /* renamed from: a */
        public final /* synthetic */ BackendListeners.GetUserAccountListener f9201a;

        /* compiled from: Consuela.java */
        /* renamed from: h.a.a.l$s0$a */
        /* loaded from: classes.dex */
        public class C2096a implements Consumer<Object> {

            /* renamed from: a */
            public final /* synthetic */ DataModels.UserAccountInfo f9203a;

            public C2096a(DataModels.UserAccountInfo userAccountInfo) {
                this.f9203a = userAccountInfo;
            }

            @Override // p136d.p153c.p159e0.Consumer
            public void accept(Object obj) {
                BackendListeners.GetUserAccountListener getUserAccountListener = C2095s0.this.f9201a;
                if (getUserAccountListener != null) {
                    getUserAccountListener.onSuccess(this.f9203a);
                }
            }
        }

        /* compiled from: Consuela.java */
        /* renamed from: h.a.a.l$s0$b */
        /* loaded from: classes.dex */
        public class C2097b implements Consumer<Throwable> {
            public C2097b() {
            }

            @Override // p136d.p153c.p159e0.Consumer
            /* renamed from: a */
            public void accept(Throwable th) {
                C2095s0.this.f9201a.onError(GeneralUtils.m1599a(th));
            }
        }

        public C2095s0(BackendListeners.GetUserAccountListener getUserAccountListener) {
            this.f9201a = getUserAccountListener;
        }

        @Override // p136d.p153c.p159e0.Consumer
        /* renamed from: a */
        public void accept(DataModels.UserAccountInfo userAccountInfo) {
            Consuela.this.f9085o = userAccountInfo.toUser();
            DataManager.m1704a().m1686a(Consuela.this.f9085o).subscribe(new C2096a(userAccountInfo), new C2097b());
        }
    }

    /* compiled from: Consuela.java */
    /* renamed from: h.a.a.l$t */
    /* loaded from: classes.dex */
    public class C2098t implements Consumer<Throwable> {

        /* renamed from: a */
        public final /* synthetic */ BackendListeners.CreateCustomerRequestListener f9206a;

        public C2098t(Consuela consuela, BackendListeners.CreateCustomerRequestListener createCustomerRequestListener) {
            this.f9206a = createCustomerRequestListener;
        }

        @Override // p136d.p153c.p159e0.Consumer
        /* renamed from: a */
        public void accept(Throwable th) {
            this.f9206a.onError(GeneralUtils.m1599a(th));
        }
    }

    /* compiled from: Consuela.java */
    /* renamed from: h.a.a.l$t0 */
    /* loaded from: classes.dex */
    public class C2099t0 implements Consumer<Throwable> {

        /* renamed from: a */
        public final /* synthetic */ BackendListeners.InterfaceC2686n f9207a;

        public C2099t0(Consuela consuela, BackendListeners.InterfaceC2686n interfaceC2686n) {
            this.f9207a = interfaceC2686n;
        }

        @Override // p136d.p153c.p159e0.Consumer
        /* renamed from: a */
        public void accept(Throwable th) {
            this.f9207a.onError(GeneralUtils.m1599a(th));
        }
    }

    /* compiled from: Consuela.java */
    /* renamed from: h.a.a.l$u */
    /* loaded from: classes.dex */
    public class C2100u implements Consumer<Throwable> {

        /* renamed from: a */
        public final /* synthetic */ BackendListeners.HasOngoingStageListener f9208a;

        public C2100u(Consuela consuela, BackendListeners.HasOngoingStageListener hasOngoingStageListener) {
            this.f9208a = hasOngoingStageListener;
        }

        @Override // p136d.p153c.p159e0.Consumer
        /* renamed from: a */
        public void accept(Throwable th) {
            this.f9208a.onError(GeneralUtils.m1599a(th));
        }
    }

    /* compiled from: Consuela.java */
    /* renamed from: h.a.a.l$u0 */
    /* loaded from: classes.dex */
    public class C2101u0 implements Consumer<Throwable> {

        /* renamed from: a */
        public final /* synthetic */ BackendListeners.GetUserAccountListener f9209a;

        public C2101u0(Consuela consuela, BackendListeners.GetUserAccountListener getUserAccountListener) {
            this.f9209a = getUserAccountListener;
        }

        @Override // p136d.p153c.p159e0.Consumer
        /* renamed from: a */
        public void accept(Throwable th) {
            BackendListeners.GetUserAccountListener getUserAccountListener = this.f9209a;
            if (getUserAccountListener != null) {
                getUserAccountListener.onError(GeneralUtils.m1599a(th));
            }
        }
    }

    /* compiled from: Consuela.java */
    /* renamed from: h.a.a.l$v */
    /* loaded from: classes.dex */
    public class C2102v implements Consumer<Throwable> {

        /* renamed from: a */
        public final /* synthetic */ BackendListeners.SendInvoiceEmailListener f9210a;

        public C2102v(Consuela consuela, BackendListeners.SendInvoiceEmailListener sendInvoiceEmailListener) {
            this.f9210a = sendInvoiceEmailListener;
        }

        @Override // p136d.p153c.p159e0.Consumer
        /* renamed from: a */
        public void accept(Throwable th) {
            BackendListeners.SendInvoiceEmailListener sendInvoiceEmailListener = this.f9210a;
            if (sendInvoiceEmailListener != null) {
                sendInvoiceEmailListener.onError(GeneralUtils.m1599a(th));
            }
        }
    }

    /* compiled from: Consuela.java */
    /* renamed from: h.a.a.l$v0 */
    /* loaded from: classes.dex */
    public class C2103v0 implements Consumer<Object> {

        /* renamed from: a */
        public final /* synthetic */ BackendListeners.InterfaceC2686n f9211a;

        public C2103v0(Consuela consuela, BackendListeners.InterfaceC2686n interfaceC2686n) {
            this.f9211a = interfaceC2686n;
        }

        @Override // p136d.p153c.p159e0.Consumer
        public void accept(Object obj) {
            this.f9211a.onSuccess();
        }
    }

    /* compiled from: Consuela.java */
    /* renamed from: h.a.a.l$w */
    /* loaded from: classes.dex */
    public class C2104w implements Consumer<Object> {

        /* renamed from: a */
        public final /* synthetic */ BackendListeners.ResetPasswordRequestListener f9212a;

        public C2104w(Consuela consuela, BackendListeners.ResetPasswordRequestListener resetPasswordRequestListener) {
            this.f9212a = resetPasswordRequestListener;
        }

        @Override // p136d.p153c.p159e0.Consumer
        public void accept(Object obj) {
            this.f9212a.onSuccess();
        }
    }

    /* compiled from: Consuela.java */
    /* renamed from: h.a.a.l$w0 */
    /* loaded from: classes.dex */
    public class C2105w0 implements AndaHCEManager.InterfaceC1876m {
        public C2105w0() {
        }

        @Override // p205h.p206a.p207a.AndaHCEManager.InterfaceC1876m
        /* renamed from: a */
        public void mo1715a(DataModels.C2700i c2700i, long j, long j2, long j3, int i, int i2, int i3, int i4, int i5, int i6) {
            int i7;
            int i8;
            int i9;
            int i10;
            int i11 = i;
            if (Consuela.this.f9085o == null) {
                AppLog.m2158a("LOGIC_BEACONS", "Consuela", "HCEValidationListener", "Validation success but no active user!");
                return;
            }
            AppLog.m2158a("LOGIC_BEACONS", "Consuela", "HCEValidationListener", "Validation success, going to validate info");
            DataModels.C2704m c2704m = (DataModels.C2704m) Consuela.this.f9071a.get(i11);
            if (c2704m != null) {
                if (c2704m.m160e() == null || c2704m.m160e().m159a() != DataModels.C2705n.f10834c) {
                    Map<String, DataModels.C2708q> m1774s = Consuela.this.m1774s();
                    StringBuilder sb = new StringBuilder();
                    sb.append(i4);
                    sb.append("|");
                    sb.append(i11);
                    i7 = m1774s.get(sb.toString()) != null ? i4 : 9999;
                    i8 = 0;
                    i9 = 0;
                    i10 = 0;
                } else {
                    i8 = i2;
                    i10 = i5;
                    i9 = i6;
                    i7 = 9999;
                }
                if (i8 > 0) {
                    Map<String, DataModels.C2701j> m1780p = Consuela.this.m1780p();
                    DataModels.C2701j c2701j = m1780p.get(i8 + "|" + i11);
                    if (c2701j != null) {
                        i11 = c2701j.m172c();
                    } else {
                        AppLog.m2158a("LOGIC_BEACONS", "Consuela", "onValidationSuccess", "Line with ref =" + i8 + " and owner " + i11 + " not found");
                    }
                }
                DataModels.C2693c c2693c = new DataModels.C2693c(i11 + "|0|" + i8 + "|" + i9 + "|" + i10 + "|" + i7 + "|" + i3, "HCE_VALIDATOR", "FF:FF:FF:FF:FF:FF", 0, 52, j, j2, true, j, 0.0d, 0.0d, 0.0d, j3, c2700i != null ? c2700i.m175c() : null, c2700i != null ? c2700i.m177a() : 0L);
                c2693c.m223a(1, i11, 0, 0, i8, i9, i10, i7, i3, 0, 0);
                BeaconManager.m1922d().m1920d(c2693c);
                return;
            }
            AppLog.m2158a("LOGIC_BEACONS", "Consuela", "onValidationSuccess", "Invalid operator " + i11);
        }
    }

    /* compiled from: Consuela.java */
    /* renamed from: h.a.a.l$x */
    /* loaded from: classes.dex */
    public class C2106x implements Consumer<DataModels.C2707p> {

        /* renamed from: a */
        public final /* synthetic */ BackendListeners.InterfaceC2674b f9214a;

        public C2106x(Consuela consuela, BackendListeners.InterfaceC2674b interfaceC2674b) {
            this.f9214a = interfaceC2674b;
        }

        @Override // p136d.p153c.p159e0.Consumer
        /* renamed from: a */
        public void accept(DataModels.C2707p c2707p) {
            AppLog.m2141e(c2707p.m121l());
            this.f9214a.mo338a(c2707p);
        }
    }

    /* compiled from: Consuela.java */
    /* renamed from: h.a.a.l$x0 */
    /* loaded from: classes.dex */
    public class C2107x0 implements Consumer<Throwable> {

        /* renamed from: a */
        public final /* synthetic */ BackendListeners.InterfaceC2686n f9215a;

        public C2107x0(Consuela consuela, BackendListeners.InterfaceC2686n interfaceC2686n) {
            this.f9215a = interfaceC2686n;
        }

        @Override // p136d.p153c.p159e0.Consumer
        /* renamed from: a */
        public void accept(Throwable th) {
            this.f9215a.onError(GeneralUtils.m1599a(th));
        }
    }

    /* compiled from: Consuela.java */
    /* renamed from: h.a.a.l$y */
    /* loaded from: classes.dex */
    public class C2108y extends Completable {

        /* renamed from: a */
        public final /* synthetic */ String f9216a;

        /* compiled from: Consuela.java */
        /* renamed from: h.a.a.l$y$a */
        /* loaded from: classes.dex */
        public class C2109a implements Consumer<Boolean> {

            /* renamed from: a */
            public final /* synthetic */ CompletableObserver f9218a;

            /* renamed from: b */
            public final /* synthetic */ DataModels.User f9219b;

            /* compiled from: Consuela.java */
            /* renamed from: h.a.a.l$y$a$a */
            /* loaded from: classes.dex */
            public class C2110a implements BackendListeners.FinishStageRequestListener {
                public C2110a() {
                }

                @Override // pt.card4b.backendbeacons.BackendListeners.BaseRequestListener
                public void onError(DataModels.Error error) {
                    String str;
                    StringBuilder sb = new StringBuilder();
                    sb.append("ERROR: ");
                    if (error == null || error.getType() == null) {
                        str = "";
                    } else {
                        str = "type:" + error.getType().toString();
                    }
                    sb.append(str);
                    AppLog.m2158a("LOGIC_BEACONS", "Consuela", "finishOngoingTrip:BeaconManager:finishStage", sb.toString());
                    C2109a.this.f9218a.mo3501a(new Exception());
                }

                @Override // pt.card4b.backendbeacons.BackendListeners.FinishStageRequestListener
                public void onSuccess() {
                    AppLog.m2158a("LOGIC_BEACONS", "Consuela", "finishOngoingTrip:BeaconManager:finishStage", "finishOngoingTrip succeeded");
                    C2109a.this.f9218a.mo3489a();
                }
            }

            /* compiled from: Consuela.java */
            /* renamed from: h.a.a.l$y$a$b */
            /* loaded from: classes.dex */
            public class C2111b implements Consumer<DataModels.C2707p> {

                /* compiled from: Consuela.java */
                /* renamed from: h.a.a.l$y$a$b$a */
                /* loaded from: classes.dex */
                public class C2112a implements Consumer<Object> {

                    /* compiled from: Consuela.java */
                    /* renamed from: h.a.a.l$y$a$b$a$a */
                    /* loaded from: classes.dex */
                    public class C2113a implements Consumer<Object> {
                        public C2113a() {
                        }

                        @Override // p136d.p153c.p159e0.Consumer
                        public void accept(Object obj) {
                            AppLog.m2158a("LOGIC_BEACONS", "Consuela", "finishOngoingTrip:removeStageState", "finishOngoingTrip succeeded");
                            C2109a.this.f9218a.mo3489a();
                        }
                    }

                    /* compiled from: Consuela.java */
                    /* renamed from: h.a.a.l$y$a$b$a$b */
                    /* loaded from: classes.dex */
                    public class C2114b implements Consumer<Throwable> {
                        public C2114b() {
                        }

                        @Override // p136d.p153c.p159e0.Consumer
                        /* renamed from: a */
                        public void accept(Throwable th) {
                            String str;
                            DataModels.Error m1599a = GeneralUtils.m1599a(th);
                            StringBuilder sb = new StringBuilder();
                            sb.append("ERROR: ");
                            if (m1599a == null || m1599a.getType() == null) {
                                str = "";
                            } else {
                                str = "type:" + m1599a.getType().toString();
                            }
                            sb.append(str);
                            AppLog.m2158a("LOGIC_BEACONS", "Consuela", "finishOngoingTrip:removeStageState", sb.toString());
                            C2109a.this.f9218a.mo3501a(new Exception());
                        }
                    }

                    public C2112a() {
                    }

                    @Override // p136d.p153c.p159e0.Consumer
                    public void accept(Object obj) {
                        DataManager.m1704a().m1615q(C2109a.this.f9219b.getEmail()).subscribeOn(Schedulers.m3323b()).observeOn(AndroidSchedulers.m3671a()).subscribe(new C2113a(), new C2114b());
                    }
                }

                /* compiled from: Consuela.java */
                /* renamed from: h.a.a.l$y$a$b$b */
                /* loaded from: classes.dex */
                public class C2115b implements Consumer<Throwable> {
                    public C2115b() {
                    }

                    @Override // p136d.p153c.p159e0.Consumer
                    /* renamed from: a */
                    public void accept(Throwable th) {
                        String str;
                        DataModels.Error m1599a = GeneralUtils.m1599a(th);
                        StringBuilder sb = new StringBuilder();
                        sb.append("ERROR: ");
                        if (m1599a == null || m1599a.getType() == null) {
                            str = "";
                        } else {
                            str = "type:" + m1599a.getType().toString();
                        }
                        sb.append(str);
                        AppLog.m2158a("LOGIC_BEACONS", "Consuela", "finishOngoingTrip:stageFinish", sb.toString());
                        C2109a.this.f9218a.mo3501a(new Exception());
                    }
                }

                public C2111b() {
                }

                /* JADX WARN: Removed duplicated region for block: B:23:0x0135  */
                /* JADX WARN: Removed duplicated region for block: B:28:0x0185 A[ADDED_TO_REGION] */
                @Override // p136d.p153c.p159e0.Consumer
                /* renamed from: a */
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                    To view partially-correct code enable 'Show inconsistent code' option in preferences
                */
                public void accept(pt.card4b.backendbeacons.DataModels.C2707p r19) {
                    /*
                        Method dump skipped, instructions count: 612
                        To view this dump change 'Code comments level' option to 'DEBUG'
                    */
                    throw new UnsupportedOperationException("Method not decompiled: p205h.p206a.p207a.Consuela.C2108y.C2109a.C2111b.accept(pt.card4b.backendbeacons.DataModels$p):void");
                }
            }

            /* compiled from: Consuela.java */
            /* renamed from: h.a.a.l$y$a$c */
            /* loaded from: classes.dex */
            public class C2116c implements Consumer<Throwable> {
                public C2116c() {
                }

                @Override // p136d.p153c.p159e0.Consumer
                /* renamed from: a */
                public void accept(Throwable th) {
                    String str;
                    DataModels.Error m1599a = GeneralUtils.m1599a(th);
                    StringBuilder sb = new StringBuilder();
                    sb.append("ERROR: ");
                    if (m1599a == null || m1599a.getType() == null) {
                        str = "";
                    } else {
                        str = "type:" + m1599a.getType().toString();
                    }
                    sb.append(str);
                    AppLog.m2158a("LOGIC_BEACONS", "Consuela", "finishOngoingTrip:getStageState", sb.toString());
                    C2109a.this.f9218a.mo3501a(new Exception());
                }
            }

            public C2109a(CompletableObserver completableObserver, DataModels.User user) {
                this.f9218a = completableObserver;
                this.f9219b = user;
            }

            /* JADX WARN: Removed duplicated region for block: B:26:0x016a  */
            @Override // p136d.p153c.p159e0.Consumer
            /* renamed from: a */
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct code enable 'Show inconsistent code' option in preferences
            */
            public void accept(java.lang.Boolean r18) {
                /*
                    Method dump skipped, instructions count: 516
                    To view this dump change 'Code comments level' option to 'DEBUG'
                */
                throw new UnsupportedOperationException("Method not decompiled: p205h.p206a.p207a.Consuela.C2108y.C2109a.accept(java.lang.Boolean):void");
            }
        }

        /* compiled from: Consuela.java */
        /* renamed from: h.a.a.l$y$b */
        /* loaded from: classes.dex */
        public class C2117b implements Consumer<Throwable> {

            /* renamed from: a */
            public final /* synthetic */ CompletableObserver f9228a;

            public C2117b(C2108y c2108y, CompletableObserver completableObserver) {
                this.f9228a = completableObserver;
            }

            @Override // p136d.p153c.p159e0.Consumer
            /* renamed from: a */
            public void accept(Throwable th) {
                String str;
                DataModels.Error m1599a = GeneralUtils.m1599a(th);
                StringBuilder sb = new StringBuilder();
                sb.append("ERROR: ");
                if (m1599a == null || m1599a.getType() == null) {
                    str = "";
                } else {
                    str = "type:" + m1599a.getType().toString();
                }
                sb.append(str);
                AppLog.m2158a("LOGIC_BEACONS", "Consuela", "finishOngoingTrip", sb.toString());
                this.f9228a.mo3501a(new Exception());
            }
        }

        public C2108y(String str) {
            this.f9216a = str;
        }

        @Override // p136d.p153c.Completable
        public void subscribeActual(CompletableObserver completableObserver) {
            DataModels.User m1519k = SharedPrefsController.m1540d().m1519k();
            if (m1519k == null) {
                AppLog.m2158a("LOGIC_BEACONS", "Consuela", "finishOngoingTrip", "No user logged in");
                completableObserver.mo3489a();
            } else if (SharedPrefsController.m1540d().m1517l()) {
                AppLog.m2158a("LOGIC_BEACONS", "Consuela", "finishOngoingTrip", "The app is restarting from crash");
                completableObserver.mo3489a();
            } else {
                DataManager.m1704a().m1617o(m1519k.getEmail()).subscribeOn(Schedulers.m3323b()).observeOn(AndroidSchedulers.m3671a()).subscribe(new C2109a(completableObserver, m1519k), new C2117b(this, completableObserver));
            }
        }
    }

    /* compiled from: Consuela.java */
    /* renamed from: h.a.a.l$y0 */
    /* loaded from: classes.dex */
    public class RunnableC2118y0 implements Runnable {

        /* compiled from: Consuela.java */
        /* renamed from: h.a.a.l$y0$a */
        /* loaded from: classes.dex */
        public class C2119a implements BackendListeners.InterfaceC2678f {
            public C2119a() {
            }

            @Override // pt.card4b.backendbeacons.BackendListeners.BaseRequestListener
            public void onError(DataModels.Error error) {
                AbstractMap.SimpleEntry<Date, String> m1545b = SharedPrefsController.m1540d().m1545b(Consuela.this.f9085o.getId());
                if (m1545b == null || m1545b.getKey().before(new Date(SysDateManager.m1497d().m1493h() + 3600000))) {
                    Consuela.this.m1869a(60000L);
                } else {
                    Consuela.this.m1869a(600000L);
                }
            }

            @Override // pt.card4b.backendbeacons.BackendListeners.InterfaceC2678f
            public void onSuccess(boolean z) {
                Consuela.this.m1869a(3600000L);
            }
        }

        public RunnableC2118y0() {
        }

        public void finalize() {
            AppLog.m2158a("LOGIC_OTHER", "BeaconManager", "offlineStartPermitRunnable:finalize", "entered method");
            super.finalize();
        }

        @Override // java.lang.Runnable
        public void run() {
            if (Consuela.this.f9085o != null) {
                Consuela.this.m1823a(new C2119a());
            } else {
                Consuela.this.m1869a(600000L);
            }
        }
    }

    /* compiled from: Consuela.java */
    /* renamed from: h.a.a.l$z */
    /* loaded from: classes.dex */
    public class C2120z implements Consumer<Throwable> {

        /* renamed from: a */
        public final /* synthetic */ BackendListeners.ResetPasswordRequestListener f9231a;

        public C2120z(Consuela consuela, BackendListeners.ResetPasswordRequestListener resetPasswordRequestListener) {
            this.f9231a = resetPasswordRequestListener;
        }

        @Override // p136d.p153c.p159e0.Consumer
        /* renamed from: a */
        public void accept(Throwable th) {
            this.f9231a.onError(GeneralUtils.m1599a(th));
        }
    }

    /* compiled from: Consuela.java */
    /* renamed from: h.a.a.l$z0 */
    /* loaded from: classes.dex */
    public class C2121z0 implements Consumer<DataModels.User> {

        /* renamed from: a */
        public final /* synthetic */ BackendListeners.GetSavedUserRequestListener f9232a;

        public C2121z0(BackendListeners.GetSavedUserRequestListener getSavedUserRequestListener) {
            this.f9232a = getSavedUserRequestListener;
        }

        @Override // p136d.p153c.p159e0.Consumer
        /* renamed from: a */
        public void accept(DataModels.User user) {
            Consuela.this.f9085o = user;
            Consuela.m1792j().post(Consuela.this.f9095y);
            Consuela.this.m1809b((BackendListeners.EnableHCEValidationsListener) null).subscribeOn(Schedulers.m3323b()).observeOn(AndroidSchedulers.m3671a()).subscribe();
            this.f9232a.onSuccess(Consuela.this.f9085o.getCopy());
            AppLog.m2158a("LOGIC_USER", "Consuela", "verifyAndGetUser", "onSuccess");
        }
    }

    static {
        System.loadLibrary("native-lib");
    }

    public Consuela() {
        DataModels.User m1519k;
        boolean z = false;
        this.f9086p = false;
        if (f9066F == null) {
            RxJavaPlugins.m3387a(new C2026d0(this));
            App.getContext().registerReceiver(this.f9067A, new IntentFilter("android.bluetooth.adapter.action.STATE_CHANGED"));
            App.getContext().registerReceiver(this.f9069C, new IntentFilter("android.nfc.action.ADAPTER_STATE_CHANGED"));
            App.getContext().registerReceiver(this.f9068B, new IntentFilter("android.location.PROVIDERS_CHANGED"));
            App.getContext().registerReceiver(this.f9070D, new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"));
            boolean initializeNative = App.initializeNative();
            boolean m1503y = SharedPrefsController.m1540d().m1503y();
            if (!initializeNative && m1503y) {
                SharedPrefsController.m1540d().m1562C();
            }
            Database.m66r();
            DataManager.m1704a();
            String m1534f = SharedPrefsController.m1540d().m1534f();
            if ((m1534f == null || m1534f.equals("")) && (m1519k = SharedPrefsController.m1540d().m1519k()) != null) {
                SharedPrefsController.m1540d().m1527h(m1519k.getEmail());
            }
            if (SharedPrefsController.m1540d().m1522j() == null) {
                SharedPrefsController.m1540d().m1562C();
            }
            BackendAPIController.m2049d();
            AndaHCEManager.m2184a().m2178a(this.f9094x);
            m1768y();
            BeaconManager.m1922d();
            AppLog.m2158a("LOGIC_BEACONS", "Consuela", "init", "init nt: " + initializeNative + " sp:" + m1503y);
            if (initializeNative && m1503y) {
                z = true;
            }
            this.f9086p = z;
            return;
        }
        throw new RuntimeException("Consuela: Use getInstance() method to get the single instance of this class.");
    }

    /* renamed from: f */
    public static /* synthetic */ short m1799f(Consuela consuela) {
        short s = consuela.f9089s;
        consuela.f9089s = (short) (s + 1);
        return s;
    }

    /* renamed from: k */
    public static /* synthetic */ short m1789k(Consuela consuela) {
        short s = consuela.f9091u;
        consuela.f9091u = (short) (s + 1);
        return s;
    }

    /* renamed from: p */
    public static /* synthetic */ short m1779p(Consuela consuela) {
        short s = consuela.f9093w;
        consuela.f9093w = (short) (s + 1);
        return s;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: x */
    public DataModels.Error m1769x() {
        String m1522j = SharedPrefsController.m1540d().m1522j();
        DataModels.User user = this.f9085o;
        if (user != null && (user == null || (m1522j != null && !m1522j.equals("")))) {
            if (!this.f9086p) {
                return DataModels.Error.initFailedDataSuspect();
            }
            if (SharedPrefsController.m1540d().m1528h() == null) {
                return DataModels.Error.missingRegistrationKey();
            }
            if (!this.f9087q) {
                return new DataModels.Error(DataModels.Error.ErrorType.INTERNAL, "App is not ready to receive a stage start", "App is not ready to receive a stage start");
            }
            DataModels.Error m1770w = m1770w();
            if (m1770w != null) {
                return m1770w;
            }
            if (!AndaHCEManager.m2184a().m2169b()) {
                return DataModels.Error.card_not_enrolled();
            }
            try {
                BluetoothAdapter defaultAdapter = BluetoothAdapter.getDefaultAdapter();
                if (defaultAdapter == null) {
                    return DataModels.Error.noBluetooth();
                }
                if (!defaultAdapter.isEnabled()) {
                    return DataModels.Error.bluetoothDisabled();
                }
                try {
                    if (Settings.Secure.getInt(App.getContext().getContentResolver(), "location_mode") == 0) {
                        return DataModels.Error.locationDisabled();
                    }
                    return null;
                } catch (Throwable th) {
                    AppLog.m2158a("LOGIC_BEACONS", "Consuela", "isValidationHCEAllowed", "location services mode could not be resolved: " + Log.getStackTraceString(th));
                    return DataModels.Error.locationDisabled();
                }
            } catch (Throwable th2) {
                AppLog.m2158a("LOGIC_BEACONS", "Consuela", "isValidationHCEAllowed", "bluetooth adapter exception: " + Log.getStackTraceString(th2));
                return DataModels.Error.bluetoothDisabled();
            }
        }
        return DataModels.Error.loginRequired();
    }

    /* renamed from: s */
    public Map<String, DataModels.C2708q> m1774s() {
        return this.f9075e;
    }

    /* renamed from: t */
    public Map<String, DataModels.C2708q> m1773t() {
        return this.f9076f;
    }

    /* renamed from: u */
    public SparseArray<DataModels.C2709r> m1772u() {
        return this.f9077g;
    }

    /* renamed from: v */
    public boolean m1771v() {
        return this.f9086p;
    }

    /* renamed from: w */
    public DataModels.Error m1770w() {
        AbstractMap.SimpleEntry<Date, String> m1545b = SharedPrefsController.m1540d().m1545b(this.f9085o.getId());
        if (m1545b == null || m1545b.getKey().before(SysDateManager.m1497d().m1496e())) {
            return DataModels.Error.getOfflinePermitError(m1545b != null ? m1545b.getValue() : null);
        }
        return null;
    }

    /* renamed from: y */
    public void m1768y() {
        m1792j().post(this.f9095y);
        m1792j().post(this.f9096z);
    }

    /* renamed from: z */
    public void m1767z() {
        try {
            if (BeaconManager.m1922d().m1913h() != null) {
                AppLog.m2158a("LOGIC_BEACONS", "Consuela", "wakeUpScreen", "Alert the app to wake up the screen");
                BeaconManager.m1922d().m1913h().onWakeUpRequired();
            }
        } catch (Throwable th) {
            AppLog.m2158a("LOGIC_BEACONS", "Consuela", "wakeUpScreen", "Exception: " + Log.getStackTraceString(th));
        }
    }

    /* renamed from: j */
    public static Handler m1792j() {
        if (f9065E == null) {
            f9065E = new Handler();
        }
        return f9065E;
    }

    /* renamed from: k */
    public static Consuela m1790k() {
        if (f9066F == null) {
            synchronized (Consuela.class) {
                if (f9066F == null) {
                    f9066F = new Consuela();
                }
            }
        }
        return f9066F;
    }

    /* renamed from: d */
    public boolean m1804d() {
        return (this.f9071a == null || this.f9072b == null || this.f9073c == null || this.f9075e == null || this.f9077g == null || this.f9079i == null || this.f9080j == null || this.f9081k == null || this.f9078h == null || this.f9082l == null) ? false : true;
    }

    /* renamed from: e */
    public DataModels.User m1802e() {
        return this.f9085o;
    }

    /* renamed from: f */
    public Map<String, DataModels.C2695d> m1800f() {
        return this.f9081k;
    }

    /* renamed from: g */
    public Map<String, DataModels.C2697f> m1798g() {
        return this.f9078h;
    }

    /* renamed from: h */
    public Map<String, DataModels.Country> m1796h() {
        return this.f9083m;
    }

    /* renamed from: i */
    public Map<String, DataModels.CustomerProfile> m1794i() {
        return this.f9082l;
    }

    /* renamed from: l */
    public Map<String, DataModels.Language> m1788l() {
        return this.f9084n;
    }

    /* renamed from: m */
    public Map<String, DataModels.C2702k> m1786m() {
        return this.f9079i;
    }

    /* renamed from: n */
    public SparseArray<DataModels.C2703l> m1784n() {
        return this.f9080j;
    }

    /* renamed from: o */
    public Map<String, DataModels.C2701j> m1782o() {
        return this.f9073c;
    }

    /* renamed from: p */
    public Map<String, DataModels.C2701j> m1780p() {
        return this.f9074d;
    }

    /* renamed from: q */
    public List<DataModels.C2704m> m1778q() {
        return this.f9072b;
    }

    /* renamed from: r */
    public SparseArray<DataModels.C2704m> m1776r() {
        return this.f9071a;
    }

    /* compiled from: Consuela.java */
    /* renamed from: h.a.a.l$q */
    /* loaded from: classes.dex */
    public class C2090q implements AndaHCEManager.InterfaceC1874k {

        /* renamed from: a */
        public final /* synthetic */ BackendListeners.GetCardInfoListener f9196a;

        public C2090q(Consuela consuela, BackendListeners.GetCardInfoListener getCardInfoListener) {
            this.f9196a = getCardInfoListener;
        }

        @Override // p205h.p206a.p207a.AndaHCEManager.InterfaceC1874k
        /* renamed from: a */
        public void mo1724a(DataModels.C2700i c2700i) {
            if (c2700i != null) {
                BackendListeners.GetCardInfoListener getCardInfoListener = this.f9196a;
                if (getCardInfoListener != null) {
                    getCardInfoListener.onSucess(new DataModels.CardInfo(c2700i.m176b()));
                    return;
                }
                return;
            }
            BackendListeners.GetCardInfoListener getCardInfoListener2 = this.f9196a;
            if (getCardInfoListener2 != null) {
                getCardInfoListener2.onError(DataModels.Error.internal("Failed to get card info"));
            }
        }

        @Override // p205h.p206a.p207a.AndaHCEManager.InterfaceC1874k
        /* renamed from: a */
        public void mo1725a(int i, String str) {
            BackendListeners.GetCardInfoListener getCardInfoListener = this.f9196a;
            if (getCardInfoListener != null) {
                getCardInfoListener.onError(DataModels.Error.internal("Failed to get card info"));
            }
        }
    }

    /* renamed from: c */
    public void m1808c() {
        Boolean bool;
        String str;
        Date date;
        try {
            if (BeaconManager.m1922d().m1913h() != null) {
                AppLog.m2158a("LOGIC_BEACONS", "Consuela", "alertOnTripAppActivityBlocked", "Alert the app that the trip runnable is not running for a long time, it may be blocked.");
                BeaconManager.m1922d().m1913h().onTripAppActivityBlocked();
            }
            Boolean bool2 = Boolean.FALSE;
            if (BeaconManager.m1922d().m1915g() != null) {
                String m121l = BeaconManager.m1922d().m1915g().m121l();
                date = BeaconManager.m1922d().m1915g().m120m();
                bool = BeaconManager.m1922d().m1915g().m119n();
                str = m121l;
            } else {
                bool = bool2;
                str = null;
                date = null;
            }
            DataModels.User user = this.f9085o;
            SharedPrefsController.m1540d().m1549a(new DataModels.C2699h(user != null ? user.getId() : null, str, bool, date, DataModels.C2699h.f10805n, SysDateManager.m1497d().m1496e(), null, null));
        } catch (Throwable th) {
            AppLog.m2158a("LOGIC_BEACONS", "Consuela", "alertOnTripAppActivityBlocked", "Exception: " + Log.getStackTraceString(th));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: b */
    public Completable m1809b(BackendListeners.EnableHCEValidationsListener enableHCEValidationsListener) {
        return m1838a(enableHCEValidationsListener, false, (DataModels.Error) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: b */
    public Completable m1810b(BackendListeners.DisableHCEValidationsListener disableHCEValidationsListener) {
        return m1840a(disableHCEValidationsListener, false);
    }

    /* renamed from: b */
    public void m1811b(String str) {
        String m1522j = SharedPrefsController.m1540d().m1522j();
        if ((m1522j != null || str == null) && ((m1522j == null || str != null) && (m1522j == null || str == null || m1522j.equals(str)))) {
            return;
        }
        if (str != null && !str.equals("")) {
            SharedPrefsController.m1540d().m1521j(str);
            return;
        }
        SharedPrefsController.m1540d().m1561D();
        if (this.f9085o == null || BeaconManager.m1922d().m1915g() != null || BeaconManager.m1922d().m1913h() == null) {
            return;
        }
        BeaconManager.m1922d().m1913h().onLogoutRequired();
    }

    /* renamed from: a */
    public void m1849a(String str, String str2, BackendListeners.LoginRequestListener loginRequestListener) {
        AppLog.m2158a("LOGIC_BEACONS", "Consuela", "login", "entered method");
        if (str != null && !str.equals("")) {
            String m1534f = SharedPrefsController.m1540d().m1534f();
            if (m1534f != null && !m1534f.equals("") && !m1534f.equalsIgnoreCase(str)) {
                loginRequestListener.onError(DataModels.Error.account_mismatch(m1534f));
                AppLog.m2158a("LOGIC_BEACONS", "Consuela", "login", "ERROR: " + DataModels.Error.account_mismatch(m1534f).getMessage());
                return;
            } else if (str2 != null && !str2.equals("")) {
                if (!this.f9086p) {
                    loginRequestListener.onError(DataModels.Error.initFailedDataSuspect());
                    AppLog.m2158a("LOGIC_BEACONS", "Consuela", "login", "ERROR: " + DataModels.Error.initFailedDataSuspect().getMessage());
                    return;
                }
                DataManager.m1704a().m1696a(str, str2).subscribeOn(Schedulers.m3323b()).observeOn(AndroidSchedulers.m3671a()).subscribe(new C2029e0(loginRequestListener), new C2074m(this, loginRequestListener));
                return;
            } else {
                loginRequestListener.onError(DataModels.Error.fieldRequired(GeneralUtils.m1603a(C1863a.password)));
                AppLog.m2158a("LOGIC_BEACONS", "Consuela", "login", "ERROR: " + DataModels.Error.fieldRequired(GeneralUtils.m1603a(C1863a.password)).getMessage());
                return;
            }
        }
        loginRequestListener.onError(DataModels.Error.fieldRequired(GeneralUtils.m1603a(C1863a.email)));
        AppLog.m2158a("LOGIC_BEACONS", "Consuela", "login", "ERROR: " + DataModels.Error.fieldRequired(GeneralUtils.m1603a(C1863a.email)).getMessage());
    }

    /* renamed from: a */
    public void m1827a(BackendListeners.LogoutRequestListener logoutRequestListener) {
        if (this.f9085o == null) {
            logoutRequestListener.onError(DataModels.Error.loginRequired());
        } else {
            m1829a(new C2086p(logoutRequestListener));
        }
    }

    /* renamed from: a */
    public void m1820a(DataModels.UserAccountInfo userAccountInfo, String str, BackendListeners.CreateCustomerRequestListener createCustomerRequestListener) {
        if (userAccountInfo.getName() == null || userAccountInfo.getName().equals("")) {
            createCustomerRequestListener.onError(DataModels.Error.fieldRequired(GeneralUtils.m1603a(C1863a.name)));
        } else if (userAccountInfo.getEmail() == null || userAccountInfo.getEmail().equals("")) {
            createCustomerRequestListener.onError(DataModels.Error.fieldRequired(GeneralUtils.m1603a(C1863a.email)));
        } else if (str == null || str.equals("")) {
            createCustomerRequestListener.onError(DataModels.Error.fieldRequired(GeneralUtils.m1603a(C1863a.password)));
        } else if (userAccountInfo.getPhonenumber() == null || userAccountInfo.getPhonenumber().equals("")) {
            createCustomerRequestListener.onError(DataModels.Error.fieldRequired(GeneralUtils.m1603a(C1863a.phonenumber)));
        } else {
            DataManager.m1704a().m1684a(userAccountInfo, str).subscribeOn(Schedulers.m3323b()).observeOn(AndroidSchedulers.m3671a()).subscribe(new C2062i1(this, createCustomerRequestListener), new C2098t(this, createCustomerRequestListener));
        }
    }

    /* renamed from: a */
    public void m1848a(String str, BackendListeners.ResetPasswordRequestListener resetPasswordRequestListener) {
        if (str == null || str.equals("")) {
            resetPasswordRequestListener.onError(DataModels.Error.fieldRequired(GeneralUtils.m1603a(C1863a.email)));
        } else {
            DataManager.m1704a().m1614r(str).subscribeOn(Schedulers.m3323b()).observeOn(AndroidSchedulers.m3671a()).subscribe(new C2104w(this, resetPasswordRequestListener), new C2120z(this, resetPasswordRequestListener));
        }
    }

    /* renamed from: a */
    public void m1819a(DataModels.UserAccountInfo userAccountInfo, BackendListeners.UpdateUserRequestListener updateUserRequestListener) {
        if (userAccountInfo.getName() == null || userAccountInfo.getName().equals("")) {
            updateUserRequestListener.onError(DataModels.Error.fieldRequired(GeneralUtils.m1603a(C1863a.name)));
        } else if (userAccountInfo.getEmail() == null || userAccountInfo.getEmail().equals("")) {
            updateUserRequestListener.onError(DataModels.Error.fieldRequired(GeneralUtils.m1603a(C1863a.email)));
        } else if (userAccountInfo.getPhonenumber() == null || userAccountInfo.getPhonenumber().equals("")) {
            updateUserRequestListener.onError(DataModels.Error.fieldRequired(GeneralUtils.m1603a(C1863a.phonenumber)));
        } else if (this.f9085o == null) {
            updateUserRequestListener.onError(DataModels.Error.loginRequired());
        } else {
            DataManager.m1704a().m1685a(userAccountInfo).subscribeOn(Schedulers.m3323b()).observeOn(AndroidSchedulers.m3671a()).subscribe(new C2021c0(userAccountInfo, updateUserRequestListener), new C2020c(this, updateUserRequestListener));
        }
    }

    /* renamed from: a */
    public void m1851a(String str, String str2, String str3, BackendListeners.DefaultRequestListener defaultRequestListener) {
        if (str == null || str.equals("")) {
            defaultRequestListener.onError(DataModels.Error.fieldRequired(GeneralUtils.m1603a(C1863a.email)));
        } else if (str2 == null || str2.equals("")) {
            defaultRequestListener.onError(DataModels.Error.fieldRequired(GeneralUtils.m1603a(C1863a.currentpassword)));
        } else if (str3 == null || str3.equals("")) {
            defaultRequestListener.onError(DataModels.Error.fieldRequired(GeneralUtils.m1603a(C1863a.newpassword)));
        } else {
            DataManager.m1704a().m1695a(str, str2, str3).subscribeOn(Schedulers.m3323b()).observeOn(AndroidSchedulers.m3671a()).subscribe(new C2033f(this, defaultRequestListener), new C2057i(this, defaultRequestListener));
        }
    }

    /* renamed from: a */
    public void m1828a(BackendListeners.InitialConfigurationRequestListener initialConfigurationRequestListener) {
        DataManager.m1704a().m1655e().subscribeOn(Schedulers.m3323b()).observeOn(AndroidSchedulers.m3671a()).subscribe(new C2063j(initialConfigurationRequestListener), new C2082o(this, initialConfigurationRequestListener));
    }

    /* renamed from: a */
    public void m1829a(BackendListeners.HasOngoingStageListener hasOngoingStageListener) {
        AppLog.m2158a("LOGIC_BEACONS", "Consuela", "hasOngoingStage", "entered method");
        if (this.f9085o == null) {
            hasOngoingStageListener.onError(DataModels.Error.loginRequired());
            AppLog.m2158a("LOGIC_BEACONS", "Consuela", "hasOngoingStage", "ERROR: " + DataModels.Error.loginRequired().getType().toString());
        } else if (!this.f9086p) {
            hasOngoingStageListener.onError(DataModels.Error.initFailedDataSuspect());
            AppLog.m2158a("LOGIC_BEACONS", "Consuela", "hasOngoingStage", "ERROR: " + DataModels.Error.initFailedDataSuspect().getType().toString());
        } else {
            DataManager.m1704a().m1617o(this.f9085o.getEmail()).subscribeOn(Schedulers.m3323b()).observeOn(AndroidSchedulers.m3671a()).subscribe(new C2092r(this, hasOngoingStageListener), new C2100u(this, hasOngoingStageListener));
        }
    }

    /* renamed from: a */
    public void m1824a(BackendListeners.InterfaceC2674b interfaceC2674b) {
        AppLog.m2158a("LOGIC_BEACONS", "Consuela", "hasOngoingStage", "entered method");
        if (this.f9085o == null) {
            interfaceC2674b.onError(DataModels.Error.loginRequired());
            AppLog.m2158a("LOGIC_BEACONS", "Consuela", "hasOngoingStage", "ERROR: " + DataModels.Error.loginRequired().getType().toString());
            return;
        }
        DataManager.m1704a().m1619m(this.f9085o.getEmail()).subscribeOn(Schedulers.m3323b()).observeOn(AndroidSchedulers.m3671a()).subscribe(new C2106x(this, interfaceC2674b), new C2012a0(this, interfaceC2674b));
    }

    /* renamed from: a */
    public Completable m1818a(DataModels.C2707p c2707p, BackendListeners.InterfaceC2683k interfaceC2683k) {
        return m1817a(c2707p, interfaceC2683k, false);
    }

    /* renamed from: a */
    public Completable m1817a(DataModels.C2707p c2707p, BackendListeners.InterfaceC2683k interfaceC2683k, boolean z) {
        return new C2037g0(z, c2707p, interfaceC2683k);
    }

    /* renamed from: a */
    public void m1822a(BackendListeners.InterfaceC2681i interfaceC2681i) {
        AppLog.m2158a("LOGIC_BEACONS", "Consuela", "hasOngoingStage", "entered method");
        if (this.f9085o == null) {
            interfaceC2681i.onError(DataModels.Error.loginRequired());
            AppLog.m2158a("LOGIC_BEACONS", "Consuela", "hasOngoingStage", "ERROR: " + DataModels.Error.loginRequired().getType().toString());
            return;
        }
        DataManager.m1704a().m1615q(this.f9085o.getEmail()).subscribeOn(Schedulers.m3323b()).observeOn(AndroidSchedulers.m3671a()).subscribe(new C2068j0(this, interfaceC2681i), new C2073l0(this, interfaceC2681i));
    }

    /* renamed from: a */
    public void m1845a(Collection<DataModels.C2692b> collection, BackendListeners.InterfaceC2688p interfaceC2688p) {
        if (this.f9085o == null) {
            interfaceC2688p.onError(DataModels.Error.loginRequired());
            AppLog.m2158a("LOGIC_BEACONS", "Consuela", "hasOngoingStage", "ERROR: " + DataModels.Error.loginRequired().getType().toString());
            return;
        }
        DataManager.m1704a().m1691a(String.valueOf(this.f9085o.getId()), (List<DataModels.C2692b>) new ArrayList(collection), true, this.f9085o.getEmail()).subscribeOn(Schedulers.m3323b()).observeOn(AndroidSchedulers.m3671a()).subscribe(new C2081n0(interfaceC2688p), new C2083o0(collection, interfaceC2688p));
    }

    /* renamed from: a */
    public void m1842a(List<DataModels.C2692b> list, BackendListeners.InterfaceC2686n interfaceC2686n) {
        if (this.f9085o == null) {
            interfaceC2686n.onError(DataModels.Error.loginRequired());
            AppLog.m2158a("LOGIC_BEACONS", "Consuela", "stageUpdate", "ERROR: " + DataModels.Error.loginRequired().getType().toString());
        } else if (BeaconManager.m1922d().m1915g() == null) {
            AppLog.m2158a("LOGIC_BEACONS", "Consuela", "stageUpdate", "ERROR: stage state is null!");
        } else {
            DataManager.m1704a().m1693a(BeaconManager.m1922d().m1915g().m121l(), this.f9085o.getId(), new ArrayList(list), BeaconManager.m1922d().m1915g().m119n().booleanValue(), BeaconManager.m1922d().m1915g().m120m(), BeaconManager.m1922d().m1915g().m117p(), this.f9085o.getEmail()).subscribeOn(Schedulers.m3323b()).observeOn(AndroidSchedulers.m3671a()).subscribe(new C2093r0(this, interfaceC2686n), new C2099t0(this, interfaceC2686n));
        }
    }

    /* renamed from: a */
    public void m1850a(String str, String str2, List<DataModels.C2692b> list, BackendListeners.InterfaceC2686n interfaceC2686n) {
        if (this.f9085o == null) {
            interfaceC2686n.onError(DataModels.Error.loginRequired());
            AppLog.m2158a("LOGIC_BEACONS", "Consuela", "stageFinish", "ERROR: " + DataModels.Error.loginRequired().getType().toString());
        } else if (BeaconManager.m1922d().m1915g() == null) {
            AppLog.m2158a("LOGIC_BEACONS", "Consuela", "stageFinish", "ERROR: stage state is null!");
        } else {
            m1853a(this.f9085o.getId(), BeaconManager.m1922d().m1915g().m121l(), BeaconManager.m1922d().m1915g().m119n(), BeaconManager.m1922d().m1915g().m120m());
            DataManager.m1704a().m1694a(str, this.f9085o.getId(), str2, new ArrayList(list), BeaconManager.m1922d().m1915g().m119n().booleanValue(), BeaconManager.m1922d().m1915g().m120m(), BeaconManager.m1922d().m1915g().m117p(), this.f9085o.getEmail()).subscribeOn(Schedulers.m3323b()).observeOn(AndroidSchedulers.m3671a()).subscribe(new C2103v0(this, interfaceC2686n), new C2107x0(this, interfaceC2686n));
        }
    }

    /* renamed from: a */
    public void m1832a(BackendListeners.GetSavedUserRequestListener getSavedUserRequestListener) {
        AppLog.m2158a("LOGIC_USER", "Consuela", "verifyAndGetUser", "entered method");
        if (!this.f9086p) {
            getSavedUserRequestListener.onError(DataModels.Error.initFailedDataSuspect());
            AppLog.m2158a("LOGIC_BEACONS", "Consuela", "verifyAndGetUser", "ERROR: " + DataModels.Error.initFailedDataSuspect().getMessage());
            return;
        }
        DataManager.m1704a().m1683b().subscribeOn(Schedulers.m3323b()).observeOn(AndroidSchedulers.m3671a()).subscribe(new C2121z0(getSavedUserRequestListener), new C2019b1(this, getSavedUserRequestListener));
    }

    /* renamed from: a */
    public void m1844a(Date date, BackendListeners.HistoricInfoRequestListener historicInfoRequestListener) {
        if (date == null) {
            historicInfoRequestListener.onError(DataModels.Error.fieldRequired(GeneralUtils.m1603a(C1863a.month)));
        } else if (this.f9085o == null) {
            historicInfoRequestListener.onError(DataModels.Error.loginRequired());
        } else {
            DataManager.m1704a().m1676b(this.f9085o.getEmail(), date).subscribeOn(Schedulers.m3323b()).observeOn(AndroidSchedulers.m3671a()).subscribe(new C2027d1(this, historicInfoRequestListener), new C2035f1(this, historicInfoRequestListener));
        }
    }

    /* renamed from: a */
    public void m1843a(Date date, BackendListeners.TariffInfoRequestListener tariffInfoRequestListener) {
        if (date == null) {
            tariffInfoRequestListener.onError(DataModels.Error.fieldRequired(GeneralUtils.m1603a(C1863a.month)));
        } else if (this.f9085o == null) {
            tariffInfoRequestListener.onError(DataModels.Error.loginRequired());
        } else {
            DataManager.m1704a().m1666c(this.f9085o.getEmail(), date).subscribeOn(Schedulers.m3323b()).observeOn(AndroidSchedulers.m3671a()).subscribe(new C2042g1(date, tariffInfoRequestListener), new C2069j1(this, tariffInfoRequestListener));
        }
    }

    /* renamed from: a */
    public void m1826a(BackendListeners.PaymentMethodsRequestListener paymentMethodsRequestListener) {
        if (this.f9085o == null) {
            paymentMethodsRequestListener.onError(DataModels.Error.loginRequired());
        } else {
            DataManager.m1704a().m1620l(this.f9085o.getEmail()).subscribeOn(Schedulers.m3323b()).observeOn(AndroidSchedulers.m3671a()).subscribe(new C2011a(this, paymentMethodsRequestListener), new C2025d(this, paymentMethodsRequestListener));
        }
    }

    /* renamed from: a */
    public void m1821a(DataModels.PaymentMethod paymentMethod, BackendListeners.SelectPaymentMethodRequestListener selectPaymentMethodRequestListener) {
        if (this.f9085o == null) {
            selectPaymentMethodRequestListener.onError(DataModels.Error.loginRequired());
        } else if (paymentMethod == null) {
            selectPaymentMethodRequestListener.onError(DataModels.Error.missingData());
        } else if (paymentMethod.getMode() != null && paymentMethod.getMode().toUpperCase().equals("WEB_PAGE_REGIST")) {
            AppLog.m2158a("LOGIC_BEACONS", "Consuela", "selectPaymentMethod", paymentMethod.getMode() + ";" + paymentMethod.getCode());
            DataModels.PaymentInfo paymentInfo = new DataModels.PaymentInfo();
            paymentInfo.setProcedureURL(paymentMethod.getUrl());
            selectPaymentMethodRequestListener.onSuccess(DataModels.PaymentAction.URL, paymentInfo);
        } else if (paymentMethod.getMode() != null && paymentMethod.getMode().toUpperCase().equals("APP_REGIST")) {
            AppLog.m2158a("LOGIC_BEACONS", "Consuela", "selectPaymentMethod", paymentMethod.getMode() + ";" + paymentMethod.getCode());
            DataManager.m1704a().m1658d(this.f9085o.getEmail(), paymentMethod.getCode()).subscribeOn(Schedulers.m3323b()).observeOn(AndroidSchedulers.m3671a()).subscribe(new C2036g(this, selectPaymentMethodRequestListener), new C2070k(this, selectPaymentMethodRequestListener));
        } else {
            AppLog.m2158a("LOGIC_BEACONS", "Consuela", "selectPaymentMethod", "Payment method not recognized");
            selectPaymentMethodRequestListener.onError(DataModels.Error.paymentMethodNotRecognized());
        }
    }

    /* renamed from: a */
    public void m1847a(String str, BackendListeners.SendInvoiceEmailListener sendInvoiceEmailListener) {
        if (this.f9085o == null) {
            sendInvoiceEmailListener.onError(DataModels.Error.loginRequired());
        } else {
            DataManager.m1704a().m1667c(str, this.f9085o.getEmail()).subscribeOn(Schedulers.m3323b()).observeOn(AndroidSchedulers.m3671a()).subscribe(new C2094s(this, sendInvoiceEmailListener), new C2102v(this, sendInvoiceEmailListener));
        }
    }

    /* renamed from: a */
    public void m1825a(BackendListeners.StageStopListener stageStopListener) {
        if (stageStopListener != null) {
            BeaconManager.m1922d().m1932b(stageStopListener);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public Completable m1855a(String str) {
        return new C2108y(str);
    }

    /* renamed from: a */
    public void m1870a(int i, BackendListeners.ScheduleStageStartListener scheduleStageStartListener) {
        if (this.f9085o == null) {
            scheduleStageStartListener.onError(DataModels.Error.loginRequired());
            AppLog.m2158a("LOGIC_BEACONS", "Consuela", "scheduleStageStart", "ERROR: " + DataModels.Error.loginRequired().getType().toString());
            return;
        }
        BeaconManager.m1922d().m1965a(i, scheduleStageStartListener);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public Completable m1871a() {
        return new C2017b0();
    }

    /* renamed from: a */
    public void m1839a(BackendListeners.EnableHCEValidationsListener enableHCEValidationsListener) {
        AppLog.m2158a("LOGIC_BEACONS", "Consuela", "appEnableHCEValidations", "App requested to enable the validations");
        this.f9087q = true;
        if (this.f9085o != null && m1770w() != null) {
            m1823a(new C2034f0(enableHCEValidationsListener));
        } else {
            m1809b(enableHCEValidationsListener).subscribeOn(Schedulers.m3323b()).observeOn(AndroidSchedulers.m3671a()).subscribe();
        }
    }

    /* renamed from: a */
    public void m1841a(BackendListeners.DisableHCEValidationsListener disableHCEValidationsListener) {
        AppLog.m2158a("LOGIC_BEACONS", "Consuela", "appDisableHCEValidations", "App requested to disable the validations");
        this.f9087q = false;
        m1810b(disableHCEValidationsListener).subscribeOn(Schedulers.m3323b()).observeOn(AndroidSchedulers.m3671a()).subscribe();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public Completable m1838a(BackendListeners.EnableHCEValidationsListener enableHCEValidationsListener, boolean z, DataModels.Error error) {
        return new C2046h0(z, enableHCEValidationsListener, error);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public Completable m1840a(BackendListeners.DisableHCEValidationsListener disableHCEValidationsListener, boolean z) {
        return new C2058i0(z, disableHCEValidationsListener);
    }

    /* renamed from: a */
    public void m1823a(BackendListeners.InterfaceC2678f interfaceC2678f) {
        if (this.f9085o == null) {
            if (interfaceC2678f != null) {
                interfaceC2678f.onError(DataModels.Error.loginRequired());
                return;
            }
            return;
        }
        String m1522j = SharedPrefsController.m1540d().m1522j();
        if (m1522j != null && !m1522j.equals("")) {
            String id = this.f9085o.getId();
            AndaHCEManager.m2184a().m2179a(new C2071k0(this));
            DataManager.m1704a().m1677b(id, this.f9085o.getEmail()).subscribeOn(Schedulers.m3323b()).observeOn(AndroidSchedulers.m3671a()).subscribe(new C2075m0(id, interfaceC2678f), new C2089p0(this, interfaceC2678f));
            return;
        }
        if (BeaconManager.m1922d().m1913h() != null) {
            BeaconManager.m1922d().m1913h().onLogoutRequired();
        }
        if (interfaceC2678f != null) {
            interfaceC2678f.onError(DataModels.Error.loginRequired());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m1869a(long j) {
        m1792j().postDelayed(this.f9095y, j);
    }

    /* renamed from: a */
    public void m1854a(String str, String str2) {
        AppLog.m2159a(str, str2);
    }

    /* renamed from: a */
    public void m1833a(BackendListeners.GetLogListener getLogListener) {
        AppLog.m2140f().subscribeOn(Schedulers.m3323b()).observeOn(AndroidSchedulers.m3671a()).subscribe(new C2091q0(this, getLogListener));
    }

    /* renamed from: a */
    public void m1816a(boolean z, DataModels.Service service) {
        if (BeaconManager.m1922d().m1913h() != null) {
            if (z) {
                BeaconManager.m1922d().m1913h().onServiceEnabled(service);
            } else {
                BeaconManager.m1922d().m1913h().onServiceDisabled(service);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m1853a(String str, String str2, Boolean bool, Date date) {
        if (str != null) {
            try {
                if (str.equals("")) {
                    return;
                }
                BatteryManager batteryManager = (BatteryManager) App.getContext().getSystemService("batterymanager");
                int intProperty = batteryManager != null ? batteryManager.getIntProperty(4) : -1;
                if (intProperty != -1) {
                    SharedPrefsController.m1540d().m1549a(new DataModels.C2699h(str, str2, bool, date, DataModels.C2699h.f10803l, SysDateManager.m1497d().m1496e(), Integer.toString(intProperty), null));
                }
            } catch (Throwable th) {
                AppLog.m2158a("LOGIC_OTHER", "BeaconManager", "sendBatteryLevelEvent", Log.getStackTraceString(th));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m1852a(String str, String str2, String str3) {
        try {
            SharedPrefsController.m1540d().m1549a(new DataModels.C2699h(str, null, Boolean.FALSE, null, DataModels.C2699h.f10804m, SysDateManager.m1497d().m1496e(), str2, str3));
        } catch (Throwable th) {
            AppLog.m2158a("LOGIC_OTHER", "BeaconManager", "sendBatteryLevelEvent", Log.getStackTraceString(th));
        }
    }

    /* renamed from: a */
    public void m1830a(BackendListeners.GetUserAccountListener getUserAccountListener) {
        if (this.f9085o != null) {
            DataManager.m1704a().m1618n(this.f9085o.getEmail()).subscribeOn(Schedulers.m3323b()).observeOn(AndroidSchedulers.m3671a()).subscribe(new C2095s0(getUserAccountListener), new C2101u0(this, getUserAccountListener));
        } else if (getUserAccountListener != null) {
            getUserAccountListener.onError(DataModels.Error.loginRequired());
        }
    }

    /* renamed from: a */
    public void m1831a(BackendListeners.GetTermsAndConditionsListener getTermsAndConditionsListener) {
        Map<String, DataModels.C2697f> map = this.f9078h;
        if (map != null) {
            if (map.containsKey("TERMS_AND_CONDITIONS_" + GeneralUtils.m1587g())) {
                Map<String, DataModels.C2697f> map2 = this.f9078h;
                getTermsAndConditionsListener.onSuccess(map2.get("TERMS_AND_CONDITIONS_" + GeneralUtils.m1587g()).m187a().trim());
                return;
            }
        }
        Map<String, DataModels.C2697f> map3 = this.f9078h;
        if (map3 != null && map3.containsKey(GeneralUtils.m1603a(C1863a.termsandconditionsconfig))) {
            getTermsAndConditionsListener.onSuccess(this.f9078h.get(GeneralUtils.m1603a(C1863a.termsandconditionsconfig)).m187a().trim());
        } else {
            getTermsAndConditionsListener.onError(DataModels.Error.missingData());
        }
    }

    /* renamed from: a */
    public void m1835a(BackendListeners.GetFAQsListener getFAQsListener) {
        Map<String, DataModels.C2697f> map = this.f9078h;
        if (map != null && map.containsKey("FAQS")) {
            getFAQsListener.onSuccess(this.f9078h.get("FAQS").m187a().trim());
        } else {
            getFAQsListener.onError(DataModels.Error.missingData());
        }
    }

    /* renamed from: a */
    public void m1836a(BackendListeners.GetCountriesListener getCountriesListener) {
        if (getCountriesListener != null) {
            getCountriesListener.onSuccess(new ArrayList(m1796h().values()));
        }
    }

    /* renamed from: a */
    public void m1834a(BackendListeners.GetLanguagesListener getLanguagesListener) {
        if (getLanguagesListener != null) {
            getLanguagesListener.onSuccess(new ArrayList(m1788l().values()));
        }
    }

    /* renamed from: a */
    public void m1846a(String str, BackendListeners.SendReportListener sendReportListener) {
        try {
            AppLog.m2160a(str).subscribeOn(Schedulers.m3323b()).observeOn(AndroidSchedulers.m3671a()).subscribe(new C2028e(str, sendReportListener), new C2045h(this, sendReportListener));
        } catch (Throwable th) {
            AppLog.m2158a("LOGIC_USER", "Consuela", "sendLogReport", Log.getStackTraceString(th));
            if (sendReportListener != null) {
                sendReportListener.onError(DataModels.Error.failed_to_send_report());
            }
        }
    }

    /* renamed from: a */
    public void m1856a(Boolean bool, BackendListeners.SyncConfigurationDataRequestListener syncConfigurationDataRequestListener) {
        DataManager.m1704a().m1698a(Boolean.TRUE, bool).subscribeOn(Schedulers.m3323b()).observeOn(AndroidSchedulers.m3671a()).subscribe(new C2072l(this, syncConfigurationDataRequestListener), new C2080n(this, syncConfigurationDataRequestListener));
    }

    /* renamed from: a */
    public void m1837a(BackendListeners.GetCardInfoListener getCardInfoListener) {
        try {
            if (AndaHCEManager.m2184a().m2169b()) {
                AndaHCEManager.m2184a().m2180a(new C2090q(this, getCardInfoListener));
            } else if (getCardInfoListener != null) {
                getCardInfoListener.onError(DataModels.Error.card_not_enrolled());
            }
        } catch (Throwable th) {
            AppLog.m2158a("LOGIC_HCE", "Consuela", "getCardInfo", Log.getStackTraceString(th));
            if (getCardInfoListener != null) {
                getCardInfoListener.onError(DataModels.Error.internal("Exception"));
            }
        }
    }
}
