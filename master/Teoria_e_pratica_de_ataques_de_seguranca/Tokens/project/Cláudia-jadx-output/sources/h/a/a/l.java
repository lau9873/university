package h.a.a;

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
import h.a.a.b;
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
import pt.card4b.backendbeacons.App;
import pt.card4b.backendbeacons.BackendListeners;
import pt.card4b.backendbeacons.DataModels;
import pt.card4b.backendbeacons.Database;
/* compiled from: Consuela.java */
/* loaded from: classes.dex */
public class l {
    public static Handler E;
    public static volatile l F;
    public DataModels.User o;
    public boolean p;

    /* renamed from: a  reason: collision with root package name */
    public SparseArray<DataModels.m> f6537a = new SparseArray<>();

    /* renamed from: b  reason: collision with root package name */
    public List<DataModels.m> f6538b = new ArrayList();

    /* renamed from: c  reason: collision with root package name */
    public Map<String, DataModels.j> f6539c = new HashMap();

    /* renamed from: d  reason: collision with root package name */
    public Map<String, DataModels.j> f6540d = new HashMap();

    /* renamed from: e  reason: collision with root package name */
    public Map<String, DataModels.q> f6541e = new HashMap();

    /* renamed from: f  reason: collision with root package name */
    public Map<String, DataModels.q> f6542f = new HashMap();

    /* renamed from: g  reason: collision with root package name */
    public SparseArray<DataModels.r> f6543g = new SparseArray<>();

    /* renamed from: h  reason: collision with root package name */
    public Map<String, DataModels.f> f6544h = new HashMap();

    /* renamed from: i  reason: collision with root package name */
    public Map<String, DataModels.k> f6545i = new HashMap();
    public SparseArray<DataModels.l> j = new SparseArray<>();
    public Map<String, DataModels.d> k = new HashMap();
    public Map<String, DataModels.CustomerProfile> l = new HashMap();
    public Map<String, DataModels.Country> m = new HashMap();
    public Map<String, DataModels.Language> n = new HashMap();
    public boolean q = false;
    public boolean r = false;
    public short s = 0;
    public boolean t = false;
    public short u = 0;
    public boolean v = false;
    public short w = 0;
    public b.m x = new w0();
    public Runnable y = new y0();
    public Runnable z = new a1();
    public BroadcastReceiver A = new c1();
    public BroadcastReceiver B = new e1(this);
    public BroadcastReceiver C = new h1(this);
    public BroadcastReceiver D = new b(this);

    /* compiled from: Consuela.java */
    /* loaded from: classes.dex */
    public class a implements d.c.e0.f<List<DataModels.PaymentMethod>> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ BackendListeners.PaymentMethodsRequestListener f6546a;

        public a(l lVar, BackendListeners.PaymentMethodsRequestListener paymentMethodsRequestListener) {
            this.f6546a = paymentMethodsRequestListener;
        }

        @Override // d.c.e0.f
        /* renamed from: a */
        public void accept(List<DataModels.PaymentMethod> list) {
            this.f6546a.onSuccess(list);
        }
    }

    /* compiled from: Consuela.java */
    /* loaded from: classes.dex */
    public class a0 implements d.c.e0.f<Throwable> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ BackendListeners.b f6547a;

        public a0(l lVar, BackendListeners.b bVar) {
            this.f6547a = bVar;
        }

        @Override // d.c.e0.f
        /* renamed from: a */
        public void accept(Throwable th) {
            this.f6547a.onError(h.a.a.p.a(th));
        }
    }

    /* compiled from: Consuela.java */
    /* loaded from: classes.dex */
    public class a1 implements Runnable {

        /* compiled from: Consuela.java */
        /* loaded from: classes.dex */
        public class a implements BackendListeners.DisableHCEValidationsListener {
            public a() {
            }

            @Override // pt.card4b.backendbeacons.BackendListeners.BaseRequestListener
            public void onError(DataModels.Error error) {
                l.j().postDelayed(l.this.z, 5000L);
            }

            @Override // pt.card4b.backendbeacons.BackendListeners.DisableHCEValidationsListener
            public void onSuccess() {
                l.j().postDelayed(l.this.z, 60000L);
            }
        }

        /* compiled from: Consuela.java */
        /* loaded from: classes.dex */
        public class b implements BackendListeners.EnableHCEValidationsListener {
            public b() {
            }

            @Override // pt.card4b.backendbeacons.BackendListeners.BaseRequestListener
            public void onError(DataModels.Error error) {
                l.j().postDelayed(l.this.z, 5000L);
            }

            @Override // pt.card4b.backendbeacons.BackendListeners.EnableHCEValidationsListener
            public void onSuccess() {
                l.j().postDelayed(l.this.z, 60000L);
            }
        }

        public a1() {
        }

        public void finalize() {
            super.finalize();
        }

        @Override // java.lang.Runnable
        public void run() {
            DataModels.Error x = l.this.x();
            if (x != null && h.a.a.b.a().c()) {
                l.this.b(new a()).subscribeOn(d.c.j0.a.b()).observeOn(d.c.b0.b.a.a()).subscribe();
            } else if (x != null || h.a.a.b.a().c()) {
                l.j().postDelayed(l.this.z, 60000L);
            } else {
                l.this.b(new b()).subscribeOn(d.c.j0.a.b()).observeOn(d.c.b0.b.a.a()).subscribe();
            }
        }
    }

    /* compiled from: Consuela.java */
    /* loaded from: classes.dex */
    public class b extends BroadcastReceiver {
        public b(l lVar) {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if (intent.getAction().equals("android.net.conn.CONNECTIVITY_CHANGE")) {
                if (h.a.a.p.i()) {
                    h.a.a.c.a("LOGIC_OTHER", "BeaconManager", "connectionStateReceiver", "Internet connection state changed to ON");
                    if (h.a.a.j.d().h() != null) {
                        h.a.a.j.d().h().onServiceEnabled(DataModels.Service.INTERNET);
                        return;
                    }
                    return;
                }
                h.a.a.c.a("LOGIC_OTHER", "BeaconManager", "connectionStateReceiver", "Internet connection state changed to OFF");
                if (h.a.a.j.d().h() != null) {
                    h.a.a.j.d().h().onServiceDisabled(DataModels.Service.INTERNET);
                    h.a.a.j.d().h().onError(DataModels.Error.noInternet());
                }
            }
        }
    }

    /* compiled from: Consuela.java */
    /* loaded from: classes.dex */
    public class b0 extends d.c.b {

        /* compiled from: Consuela.java */
        /* loaded from: classes.dex */
        public class a implements b.j {

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ d.c.d f6552a;

            public a(b0 b0Var, d.c.d dVar) {
                this.f6552a = dVar;
            }

            @Override // h.a.a.b.j
            public void a(int i2, String str) {
                h.a.a.v.d().a(new DataModels.h(l.k().e().getId(), null, Boolean.FALSE, null, DataModels.h.o, h.a.a.w.d().e(), (str == null || str.equals("")) ? null : null, null));
                this.f6552a.a();
            }

            @Override // h.a.a.b.j
            public void onSuccess() {
                h.a.a.v.d().a(new DataModels.h(l.k().e().getId(), null, Boolean.FALSE, null, DataModels.h.p, h.a.a.w.d().e(), null, null));
                this.f6552a.a();
            }
        }

        public b0() {
        }

        @Override // d.c.b
        public void subscribeActual(d.c.d dVar) {
            if (!h.a.a.b.a().b()) {
                if (l.this.o != null) {
                    if (!l.this.p) {
                        h.a.a.c.a("LOGIC_BEACONS", "Consuela", "HCEEnroll", "ERROR: " + DataModels.Error.initFailedDataSuspect().getMessage());
                        dVar.a();
                        return;
                    }
                    DataModels.Error w = l.this.w();
                    if (w == null) {
                        h.a.a.b.a().a(l.this.o.getPhonenumber(), new a(this, dVar));
                        return;
                    }
                    h.a.a.c.a("LOGIC_BEACONS", "Consuela", "HCEEnroll", "ERROR: " + w.getMessage());
                    dVar.a();
                    return;
                }
                h.a.a.c.a("LOGIC_BEACONS", "Consuela", "HCEEnroll", "ERROR: " + DataModels.Error.loginRequired().getType().toString());
                dVar.a();
                return;
            }
            dVar.a();
        }
    }

    /* compiled from: Consuela.java */
    /* loaded from: classes.dex */
    public class b1 implements d.c.e0.f<Throwable> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ BackendListeners.GetSavedUserRequestListener f6553a;

        public b1(l lVar, BackendListeners.GetSavedUserRequestListener getSavedUserRequestListener) {
            this.f6553a = getSavedUserRequestListener;
        }

        @Override // d.c.e0.f
        /* renamed from: a */
        public void accept(Throwable th) {
            this.f6553a.onError(h.a.a.p.a(th));
            h.a.a.c.a("LOGIC_USER", "Consuela", "verifyAndGetUser", "onError");
        }
    }

    /* compiled from: Consuela.java */
    /* loaded from: classes.dex */
    public class c implements d.c.e0.f<Throwable> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ BackendListeners.UpdateUserRequestListener f6554a;

        public c(l lVar, BackendListeners.UpdateUserRequestListener updateUserRequestListener) {
            this.f6554a = updateUserRequestListener;
        }

        @Override // d.c.e0.f
        /* renamed from: a */
        public void accept(Throwable th) {
            this.f6554a.onError(h.a.a.p.a(th));
        }
    }

    /* compiled from: Consuela.java */
    /* loaded from: classes.dex */
    public class c0 implements d.c.e0.f<Boolean> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ DataModels.UserAccountInfo f6555a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ BackendListeners.UpdateUserRequestListener f6556b;

        /* compiled from: Consuela.java */
        /* loaded from: classes.dex */
        public class a implements d.c.e0.f<Object> {

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ Boolean f6558a;

            public a(Boolean bool) {
                this.f6558a = bool;
            }

            @Override // d.c.e0.f
            public void accept(Object obj) {
                c0.this.f6556b.onSuccess(this.f6558a.booleanValue());
            }
        }

        /* compiled from: Consuela.java */
        /* loaded from: classes.dex */
        public class b implements d.c.e0.f<Throwable> {
            public b() {
            }

            @Override // d.c.e0.f
            /* renamed from: a */
            public void accept(Throwable th) {
                c0.this.f6556b.onError(h.a.a.p.a(th));
            }
        }

        public c0(DataModels.UserAccountInfo userAccountInfo, BackendListeners.UpdateUserRequestListener updateUserRequestListener) {
            this.f6555a = userAccountInfo;
            this.f6556b = updateUserRequestListener;
        }

        @Override // d.c.e0.f
        /* renamed from: a */
        public void accept(Boolean bool) {
            l.this.o = this.f6555a.toUser();
            h.a.a.n.a().a(l.this.o).subscribe(new a(bool), new b());
        }
    }

    /* compiled from: Consuela.java */
    /* loaded from: classes.dex */
    public class c1 extends BroadcastReceiver {
        public c1() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if (intent.getAction().equals("android.bluetooth.adapter.action.STATE_CHANGED")) {
                int intExtra = intent.getIntExtra("android.bluetooth.adapter.extra.STATE", 10);
                if (intExtra == 10) {
                    h.a.a.c.a("LOGIC_OTHER", "BeaconManager", "bluetoothStateReceiver", "Bluetooth state changed to OFF");
                    if (h.a.a.j.d().h() != null) {
                        h.a.a.j.d().h().onServiceDisabled(DataModels.Service.BLUETOOTH);
                        h.a.a.j.d().h().onError(DataModels.Error.bluetoothDisabled());
                    }
                    h.a.a.j.d().a(false);
                    if (l.this.o == null || h.a.a.j.d().g() == null) {
                        return;
                    }
                    h.a.a.v.d().a(new DataModels.h(l.this.o.getId(), h.a.a.j.d().g().l(), h.a.a.j.d().g().n(), h.a.a.j.d().g().m(), DataModels.h.j, h.a.a.w.d().e(), null, null));
                } else if (intExtra != 12) {
                } else {
                    h.a.a.c.a("LOGIC_OTHER", "BeaconManager", "bluetoothStateReceiver", "Bluetooth state changed to ON");
                    if (h.a.a.j.d().h() != null) {
                        h.a.a.j.d().h().onServiceEnabled(DataModels.Service.BLUETOOTH);
                    }
                    h.a.a.j.d().a(true);
                    if (l.this.o == null || h.a.a.j.d().g() == null) {
                        return;
                    }
                    h.a.a.v.d().a(new DataModels.h(l.this.o.getId(), h.a.a.j.d().g().l(), h.a.a.j.d().g().n(), h.a.a.j.d().g().m(), DataModels.h.f7708i, h.a.a.w.d().e(), null, null));
                }
            }
        }
    }

    /* compiled from: Consuela.java */
    /* loaded from: classes.dex */
    public class d implements d.c.e0.f<Throwable> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ BackendListeners.PaymentMethodsRequestListener f6562a;

        public d(l lVar, BackendListeners.PaymentMethodsRequestListener paymentMethodsRequestListener) {
            this.f6562a = paymentMethodsRequestListener;
        }

        @Override // d.c.e0.f
        /* renamed from: a */
        public void accept(Throwable th) {
            this.f6562a.onError(h.a.a.p.a(th));
        }
    }

    /* compiled from: Consuela.java */
    /* loaded from: classes.dex */
    public class d0 implements d.c.e0.f<Throwable> {
        public d0(l lVar) {
        }

        @Override // d.c.e0.f
        /* renamed from: a */
        public void accept(Throwable th) {
            if (!(th instanceof UndeliverableException)) {
                throw new Exception(th);
            }
        }
    }

    /* compiled from: Consuela.java */
    /* loaded from: classes.dex */
    public class d1 implements d.c.e0.f<List<DataModels.StageInfo>> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ BackendListeners.HistoricInfoRequestListener f6563a;

        public d1(l lVar, BackendListeners.HistoricInfoRequestListener historicInfoRequestListener) {
            this.f6563a = historicInfoRequestListener;
        }

        @Override // d.c.e0.f
        /* renamed from: a */
        public void accept(List<DataModels.StageInfo> list) {
            this.f6563a.onSuccess(list);
        }
    }

    /* compiled from: Consuela.java */
    /* loaded from: classes.dex */
    public class e implements d.c.e0.f<Object> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ String f6564a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ BackendListeners.SendReportListener f6565b;

        public e(String str, BackendListeners.SendReportListener sendReportListener) {
            this.f6564a = str;
            this.f6565b = sendReportListener;
        }

        @Override // d.c.e0.f
        public void accept(Object obj) {
            if (obj != null && (obj instanceof File)) {
                l lVar = l.this;
                String id = lVar.o != null ? l.this.o.getId() : null;
                String str = this.f6564a;
                lVar.a(id, str, "Reports/" + ((File) obj).getName());
                BackendListeners.SendReportListener sendReportListener = this.f6565b;
                if (sendReportListener != null) {
                    sendReportListener.onSuccess();
                    return;
                }
                return;
            }
            BackendListeners.SendReportListener sendReportListener2 = this.f6565b;
            if (sendReportListener2 != null) {
                sendReportListener2.onError(DataModels.Error.failed_to_send_report());
            }
        }
    }

    /* compiled from: Consuela.java */
    /* loaded from: classes.dex */
    public class e0 implements d.c.e0.f<DataModels.User> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ BackendListeners.LoginRequestListener f6567a;

        /* compiled from: Consuela.java */
        /* loaded from: classes.dex */
        public class a implements d.c.e0.f<Throwable> {
            public a() {
            }

            @Override // d.c.e0.f
            /* renamed from: a */
            public void accept(Throwable th) {
                e0.this.f6567a.onError(h.a.a.p.a(th));
            }
        }

        /* compiled from: Consuela.java */
        /* loaded from: classes.dex */
        public class b implements d.c.e0.a {
            public b() {
            }

            @Override // d.c.e0.a
            public void run() {
                l.this.b((BackendListeners.EnableHCEValidationsListener) null).subscribeOn(d.c.j0.a.b()).observeOn(d.c.b0.b.a.a()).subscribe();
                h.a.a.n.a().d().subscribeOn(d.c.j0.a.b()).subscribe();
                e0 e0Var = e0.this;
                e0Var.f6567a.onSuccess(l.this.o.getCopy());
                h.a.a.c.a("LOGIC_USER", "Consuela", "login", "onSuccess");
            }
        }

        public e0(BackendListeners.LoginRequestListener loginRequestListener) {
            this.f6567a = loginRequestListener;
        }

        @Override // d.c.e0.f
        /* renamed from: a */
        public void accept(DataModels.User user) {
            try {
                l.this.o = user;
                l.j().post(l.this.y);
                l.this.a(DataModels.o.p).doOnComplete(new b()).doOnError(new a()).subscribeOn(d.c.j0.a.b()).observeOn(d.c.b0.b.a.a()).subscribe();
            } catch (ClassCastException e2) {
                e2.printStackTrace();
                this.f6567a.onError(DataModels.Error.internal(e2.getLocalizedMessage()));
                h.a.a.c.a("LOGIC_USER", "Consuela", "login", "onSuccess - ClassCastException: " + DataModels.Error.ErrorType.INTERNAL + ";" + e2.getMessage());
            }
        }
    }

    /* compiled from: Consuela.java */
    /* loaded from: classes.dex */
    public class e1 extends BroadcastReceiver {
        public e1(l lVar) {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if (intent.getAction().equals("android.location.PROVIDERS_CHANGED")) {
                if (Settings.Secure.getInt(App.getContext().getContentResolver(), "location_mode", 0) == 0) {
                    h.a.a.c.a("LOGIC_OTHER", "BeaconManager", "locationStateReceiver", "location state changed to OFF");
                    if (h.a.a.j.d().h() != null) {
                        h.a.a.j.d().h().onServiceDisabled(DataModels.Service.LOCATION);
                        h.a.a.j.d().h().onError(DataModels.Error.locationDisabled());
                        return;
                    }
                    return;
                }
                h.a.a.c.a("LOGIC_OTHER", "BeaconManager", "locationStateReceiver", "location state changed to ON");
                if (h.a.a.j.d().h() != null) {
                    h.a.a.j.d().h().onServiceEnabled(DataModels.Service.LOCATION);
                }
            }
        }
    }

    /* compiled from: Consuela.java */
    /* loaded from: classes.dex */
    public class f implements d.c.e0.f<Object> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ BackendListeners.DefaultRequestListener f6571a;

        public f(l lVar, BackendListeners.DefaultRequestListener defaultRequestListener) {
            this.f6571a = defaultRequestListener;
        }

        @Override // d.c.e0.f
        public void accept(Object obj) {
            this.f6571a.onSuccess();
        }
    }

    /* compiled from: Consuela.java */
    /* loaded from: classes.dex */
    public class f0 implements BackendListeners.f {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ BackendListeners.EnableHCEValidationsListener f6572a;

        public f0(BackendListeners.EnableHCEValidationsListener enableHCEValidationsListener) {
            this.f6572a = enableHCEValidationsListener;
        }

        @Override // pt.card4b.backendbeacons.BackendListeners.BaseRequestListener
        public void onError(DataModels.Error error) {
            l.this.b(this.f6572a).subscribeOn(d.c.j0.a.b()).observeOn(d.c.b0.b.a.a()).subscribe();
        }

        @Override // pt.card4b.backendbeacons.BackendListeners.f
        public void onSuccess(boolean z) {
            l.this.b(this.f6572a).subscribeOn(d.c.j0.a.b()).observeOn(d.c.b0.b.a.a()).subscribe();
        }
    }

    /* compiled from: Consuela.java */
    /* loaded from: classes.dex */
    public class f1 implements d.c.e0.f<Throwable> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ BackendListeners.HistoricInfoRequestListener f6574a;

        public f1(l lVar, BackendListeners.HistoricInfoRequestListener historicInfoRequestListener) {
            this.f6574a = historicInfoRequestListener;
        }

        @Override // d.c.e0.f
        /* renamed from: a */
        public void accept(Throwable th) {
            this.f6574a.onError(h.a.a.p.a(th));
        }
    }

    /* compiled from: Consuela.java */
    /* loaded from: classes.dex */
    public class g implements d.c.e0.f<Object> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ BackendListeners.SelectPaymentMethodRequestListener f6575a;

        public g(l lVar, BackendListeners.SelectPaymentMethodRequestListener selectPaymentMethodRequestListener) {
            this.f6575a = selectPaymentMethodRequestListener;
        }

        @Override // d.c.e0.f
        public void accept(Object obj) {
            this.f6575a.onSuccess(DataModels.PaymentAction.NO_ACTION_NEEDED, null);
        }
    }

    /* compiled from: Consuela.java */
    /* loaded from: classes.dex */
    public class g0 extends d.c.b {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ boolean f6576a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ DataModels.p f6577b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ BackendListeners.k f6578c;

        /* compiled from: Consuela.java */
        /* loaded from: classes.dex */
        public class a implements d.c.e0.a {
            public a() {
            }

            @Override // d.c.e0.a
            public void run() {
                g0 g0Var = g0.this;
                l.this.a(g0Var.f6577b, g0Var.f6578c, true).subscribeOn(d.c.j0.a.b()).observeOn(d.c.b0.b.a.a()).subscribe();
            }
        }

        /* compiled from: Consuela.java */
        /* loaded from: classes.dex */
        public class b implements d.c.e0.f<Object> {
            public b() {
            }

            @Override // d.c.e0.f
            public void accept(Object obj) {
                h.a.a.c.a("LOGIC_BEACONS", "Consuela", "saveOngoingStage", "Stage state saved successfully");
                l.this.v = false;
                g0.this.f6578c.onSuccess();
            }
        }

        /* compiled from: Consuela.java */
        /* loaded from: classes.dex */
        public class c implements d.c.e0.f<Throwable> {

            /* compiled from: Consuela.java */
            /* loaded from: classes.dex */
            public class a implements d.c.e0.a {
                public a() {
                }

                @Override // d.c.e0.a
                public void run() {
                    g0 g0Var = g0.this;
                    l.this.a(g0Var.f6577b, g0Var.f6578c, true).subscribeOn(d.c.j0.a.b()).observeOn(d.c.b0.b.a.a()).subscribe();
                }
            }

            public c() {
            }

            @Override // d.c.e0.f
            /* renamed from: a */
            public void accept(Throwable th) {
                l.this.v = false;
                h.a.a.c.a("LOGIC_BEACONS", "Consuela", "saveOngoingStage", "Already saving stage stage, will try again");
                d.c.b.timer(5L, TimeUnit.SECONDS).subscribeOn(d.c.j0.a.b()).observeOn(d.c.b0.b.a.a()).doOnComplete(new a()).subscribe();
            }
        }

        public g0(boolean z, DataModels.p pVar, BackendListeners.k kVar) {
            this.f6576a = z;
            this.f6577b = pVar;
            this.f6578c = kVar;
        }

        @Override // d.c.b
        public void subscribeActual(d.c.d dVar) {
            try {
                if (this.f6576a) {
                    l.p(l.this);
                } else {
                    l.this.w = (short) 0;
                }
            } catch (Throwable th) {
                l.this.v = false;
                BackendListeners.k kVar = this.f6578c;
                if (kVar != null) {
                    kVar.onError(h.a.a.p.a(th));
                }
            }
            if (this.f6577b == null) {
                this.f6578c.onError(new DataModels.Error(DataModels.Error.ErrorType.INTERNAL, "Error saving stage state: stage state is null", "Error saving stage state: stage state is null"));
                dVar.a();
            } else if (!this.f6576a || l.this.w < 3) {
                if (!l.this.v) {
                    l.this.v = true;
                    h.a.a.n.a().a(l.this.o.getEmail(), this.f6577b).subscribeOn(d.c.j0.a.b()).observeOn(d.c.b0.b.a.a()).subscribe(new b(), new c());
                    dVar.a();
                    return;
                }
                h.a.a.c.a("LOGIC_BEACONS", "Consuela", "saveOngoingStage", "Already saving stage state, will try again ");
                d.c.b.timer(5L, TimeUnit.SECONDS).subscribeOn(d.c.j0.a.b()).observeOn(d.c.b0.b.a.a()).doOnComplete(new a()).subscribe();
                dVar.a();
            } else {
                l.this.v = false;
                BackendListeners.k kVar2 = this.f6578c;
                if (kVar2 != null) {
                    kVar2.onError(new DataModels.Error(DataModels.Error.ErrorType.INTERNAL, "ERROR saving stage state", "ERROR saving stage state"));
                }
                dVar.a();
            }
        }
    }

    /* compiled from: Consuela.java */
    /* loaded from: classes.dex */
    public class g1 implements d.c.e0.f<List<DataModels.TariffInfo>> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ Date f6584a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ BackendListeners.TariffInfoRequestListener f6585b;

        /* compiled from: Consuela.java */
        /* loaded from: classes.dex */
        public class a implements d.c.e0.f<List<DataModels.InvoiceInfo>> {

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ List f6587a;

            public a(List list) {
                this.f6587a = list;
            }

            @Override // d.c.e0.f
            /* renamed from: a */
            public void accept(List<DataModels.InvoiceInfo> list) {
                g1.this.f6585b.onSuccess(this.f6587a, list);
            }
        }

        /* compiled from: Consuela.java */
        /* loaded from: classes.dex */
        public class b implements d.c.e0.f<Throwable> {

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ List f6589a;

            public b(List list) {
                this.f6589a = list;
            }

            @Override // d.c.e0.f
            /* renamed from: a */
            public void accept(Throwable th) {
                if (h.a.a.p.a(th).getType() == DataModels.Error.ErrorType.NO_RESULTS) {
                    g1.this.f6585b.onSuccess(this.f6589a, new ArrayList());
                } else {
                    g1.this.f6585b.onError(h.a.a.p.a(th));
                }
            }
        }

        public g1(Date date, BackendListeners.TariffInfoRequestListener tariffInfoRequestListener) {
            this.f6584a = date;
            this.f6585b = tariffInfoRequestListener;
        }

        @Override // d.c.e0.f
        /* renamed from: a */
        public void accept(List<DataModels.TariffInfo> list) {
            h.a.a.n.a().a(l.this.o.getEmail(), this.f6584a).subscribeOn(d.c.j0.a.b()).observeOn(d.c.b0.b.a.a()).subscribe(new a(list), new b(list));
        }
    }

    /* compiled from: Consuela.java */
    /* loaded from: classes.dex */
    public class h implements d.c.e0.f<Throwable> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ BackendListeners.SendReportListener f6591a;

        public h(l lVar, BackendListeners.SendReportListener sendReportListener) {
            this.f6591a = sendReportListener;
        }

        @Override // d.c.e0.f
        /* renamed from: a */
        public void accept(Throwable th) {
            BackendListeners.SendReportListener sendReportListener = this.f6591a;
            if (sendReportListener != null) {
                sendReportListener.onError(DataModels.Error.failed_to_send_report());
            }
        }
    }

    /* compiled from: Consuela.java */
    /* loaded from: classes.dex */
    public class h0 extends d.c.b {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ boolean f6592a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ BackendListeners.EnableHCEValidationsListener f6593b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ DataModels.Error f6594c;

        /* compiled from: Consuela.java */
        /* loaded from: classes.dex */
        public class a implements d.c.e0.a {
            public a() {
            }

            @Override // d.c.e0.a
            public void run() {
                h0 h0Var = h0.this;
                l.this.a(h0Var.f6593b, true, h0Var.f6594c).subscribeOn(d.c.j0.a.b()).observeOn(d.c.b0.b.a.a()).subscribe();
            }
        }

        /* compiled from: Consuela.java */
        /* loaded from: classes.dex */
        public class b implements d.c.e0.f<Object> {

            /* compiled from: Consuela.java */
            /* loaded from: classes.dex */
            public class a implements d.c.e0.a {
                public a() {
                }

                @Override // d.c.e0.a
                public void run() {
                    h0 h0Var = h0.this;
                    l.this.a(h0Var.f6593b, true, (DataModels.Error) null).subscribeOn(d.c.j0.a.b()).observeOn(d.c.b0.b.a.a()).subscribe();
                }
            }

            public b() {
            }

            @Override // d.c.e0.f
            public void accept(Object obj) {
                l.this.r = false;
                d.c.b.timer(1L, TimeUnit.SECONDS).subscribeOn(d.c.j0.a.b()).observeOn(d.c.b0.b.a.a()).doOnComplete(new a()).subscribe();
            }
        }

        /* compiled from: Consuela.java */
        /* loaded from: classes.dex */
        public class c implements d.c.e0.f<Throwable> {

            /* compiled from: Consuela.java */
            /* loaded from: classes.dex */
            public class a implements d.c.e0.a {

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ DataModels.Error f6600a;

                public a(DataModels.Error error) {
                    this.f6600a = error;
                }

                @Override // d.c.e0.a
                public void run() {
                    h0 h0Var = h0.this;
                    l.this.a(h0Var.f6593b, true, this.f6600a).subscribeOn(d.c.j0.a.b()).observeOn(d.c.b0.b.a.a()).subscribe();
                }
            }

            public c() {
            }

            @Override // d.c.e0.f
            /* renamed from: a */
            public void accept(Throwable th) {
                l.this.r = false;
                d.c.b.timer(1L, TimeUnit.SECONDS).subscribeOn(d.c.j0.a.b()).observeOn(d.c.b0.b.a.a()).doOnComplete(new a(h.a.a.v.d().h() == null ? DataModels.Error.missingRegistrationKey() : null)).subscribe();
            }
        }

        /* compiled from: Consuela.java */
        /* loaded from: classes.dex */
        public class d implements d.c.e0.a {

            /* compiled from: Consuela.java */
            /* loaded from: classes.dex */
            public class a implements d.c.e0.a {

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ DataModels.Error f6603a;

                public a(DataModels.Error error) {
                    this.f6603a = error;
                }

                @Override // d.c.e0.a
                public void run() {
                    h0 h0Var = h0.this;
                    l.this.a(h0Var.f6593b, true, this.f6603a).subscribeOn(d.c.j0.a.b()).observeOn(d.c.b0.b.a.a()).subscribe();
                }
            }

            public d() {
            }

            @Override // d.c.e0.a
            public void run() {
                l.this.r = false;
                d.c.b.timer(1L, TimeUnit.SECONDS).subscribeOn(d.c.j0.a.b()).observeOn(d.c.b0.b.a.a()).doOnComplete(new a(!h.a.a.b.a().b() ? DataModels.Error.failed_to_enroll_card() : null)).subscribe();
            }
        }

        /* compiled from: Consuela.java */
        /* loaded from: classes.dex */
        public class e implements b.i {

            /* compiled from: Consuela.java */
            /* loaded from: classes.dex */
            public class a implements d.c.e0.a {
                public a() {
                }

                @Override // d.c.e0.a
                public void run() {
                    h0 h0Var = h0.this;
                    l.this.a(h0Var.f6593b, true, (DataModels.Error) null).subscribeOn(d.c.j0.a.b()).observeOn(d.c.b0.b.a.a()).subscribe();
                }
            }

            public e() {
            }

            @Override // h.a.a.b.i
            public void a(int i2, String str) {
                l.this.r = false;
                h.a.a.c.a("LOGIC_BEACONS", "Consuela", "enableHCEValidations", "Error enabling validations. Will try again");
                d.c.b.timer(5L, TimeUnit.SECONDS).subscribeOn(d.c.j0.a.b()).observeOn(d.c.b0.b.a.a()).doOnComplete(new a()).subscribe();
            }

            @Override // h.a.a.b.i
            public void onSuccess() {
                BackendListeners.EnableHCEValidationsListener enableHCEValidationsListener = h0.this.f6593b;
                if (enableHCEValidationsListener != null) {
                    enableHCEValidationsListener.onSuccess();
                }
                if (h.a.a.j.d().h() != null) {
                    h.a.a.j.d().h().onServiceEnabled(DataModels.Service.HCE_VALIDATION);
                }
                l.this.r = false;
            }
        }

        public h0(boolean z, BackendListeners.EnableHCEValidationsListener enableHCEValidationsListener, DataModels.Error error) {
            this.f6592a = z;
            this.f6593b = enableHCEValidationsListener;
            this.f6594c = error;
        }

        @Override // d.c.b
        public void subscribeActual(d.c.d dVar) {
            try {
                if (this.f6592a) {
                    l.f(l.this);
                } else {
                    l.this.s = (short) 0;
                }
                if (h.a.a.b.a().c()) {
                    BackendListeners.EnableHCEValidationsListener enableHCEValidationsListener = this.f6593b;
                    if (enableHCEValidationsListener != null) {
                        enableHCEValidationsListener.onSuccess();
                    }
                    dVar.a();
                } else if (!this.f6592a || l.this.s < 3) {
                    if (!l.this.r) {
                        l.this.r = true;
                        DataModels.Error x = l.this.x();
                        if (x != null) {
                            if (x.getType() == DataModels.Error.ErrorType.MISSING_REGISTRATION_KEY) {
                                h.a.a.c.a("LOGIC_BEACONS", "Consuela", "enableHCEValidations", "Missing registration key. Will install the device and try again");
                                h.a.a.n.a().e().subscribeOn(d.c.j0.a.b()).observeOn(d.c.b0.b.a.a()).subscribe(new b(), new c());
                                dVar.a();
                                return;
                            } else if (x.getType() == DataModels.Error.ErrorType.CARD_NOT_ENROLLED) {
                                h.a.a.c.a("LOGIC_BEACONS", "Consuela", "enableHCEValidations", "Card not enrolled. Will enroll the card and try again");
                                l.this.a().doOnComplete(new d()).subscribeOn(d.c.j0.a.b()).observeOn(d.c.b0.b.a.a()).subscribe();
                                dVar.a();
                                return;
                            } else {
                                h.a.a.c.a("LOGIC_BEACONS", "Consuela", "enableHCEValidations", "Enable validations not allowed: " + x.getMessage());
                                BackendListeners.EnableHCEValidationsListener enableHCEValidationsListener2 = this.f6593b;
                                if (enableHCEValidationsListener2 != null) {
                                    enableHCEValidationsListener2.onError(x);
                                }
                                dVar.a();
                                l.this.r = false;
                                return;
                            }
                        }
                        h.a.a.b.a().a(new e());
                        dVar.a();
                        return;
                    }
                    h.a.a.c.a("LOGIC_BEACONS", "Consuela", "enableHCEValidations", "Already enabling validations. Will try again");
                    d.c.b.timer(5L, TimeUnit.SECONDS).subscribeOn(d.c.j0.a.b()).observeOn(d.c.b0.b.a.a()).doOnComplete(new a()).subscribe();
                    dVar.a();
                } else {
                    l.this.r = false;
                    BackendListeners.EnableHCEValidationsListener enableHCEValidationsListener3 = this.f6593b;
                    if (enableHCEValidationsListener3 != null) {
                        DataModels.Error error = this.f6594c;
                        if (error == null) {
                            error = new DataModels.Error(DataModels.Error.ErrorType.INTERNAL, "ERROR enabling HCE validations", "ERROR enabling HCE validations");
                        }
                        enableHCEValidationsListener3.onError(error);
                    }
                    dVar.a();
                }
            } catch (Throwable th) {
                BackendListeners.EnableHCEValidationsListener enableHCEValidationsListener4 = this.f6593b;
                if (enableHCEValidationsListener4 != null) {
                    enableHCEValidationsListener4.onError(h.a.a.p.a(th));
                }
                l.this.r = false;
                dVar.a();
            }
        }
    }

    /* compiled from: Consuela.java */
    /* loaded from: classes.dex */
    public class h1 extends BroadcastReceiver {
        public h1(l lVar) {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if (intent.getAction().equals("android.nfc.action.ADAPTER_STATE_CHANGED")) {
                int intExtra = intent.getIntExtra("android.nfc.extra.ADAPTER_STATE", 1);
                if (intExtra == 1) {
                    h.a.a.c.a("LOGIC_OTHER", "BeaconManager", "nfcStateReceiver", "NFC state changed to OFF");
                    if (h.a.a.j.d().h() != null) {
                        h.a.a.j.d().h().onServiceDisabled(DataModels.Service.NFC);
                        h.a.a.j.d().h().onError(DataModels.Error.nfcDisabled());
                    }
                } else if (intExtra != 3) {
                } else {
                    h.a.a.c.a("LOGIC_OTHER", "BeaconManager", "nfcStateReceiver", "NFC state changed to ON");
                    if (h.a.a.j.d().h() != null) {
                        h.a.a.j.d().h().onServiceEnabled(DataModels.Service.NFC);
                    }
                }
            }
        }
    }

    /* compiled from: Consuela.java */
    /* loaded from: classes.dex */
    public class i implements d.c.e0.f<Throwable> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ BackendListeners.DefaultRequestListener f6607a;

        public i(l lVar, BackendListeners.DefaultRequestListener defaultRequestListener) {
            this.f6607a = defaultRequestListener;
        }

        @Override // d.c.e0.f
        /* renamed from: a */
        public void accept(Throwable th) {
            this.f6607a.onError(h.a.a.p.a(th));
        }
    }

    /* compiled from: Consuela.java */
    /* loaded from: classes.dex */
    public class i0 extends d.c.b {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ boolean f6608a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ BackendListeners.DisableHCEValidationsListener f6609b;

        /* compiled from: Consuela.java */
        /* loaded from: classes.dex */
        public class a implements d.c.e0.a {
            public a() {
            }

            @Override // d.c.e0.a
            public void run() {
                i0 i0Var = i0.this;
                l.this.a(i0Var.f6609b, true).subscribeOn(d.c.j0.a.b()).observeOn(d.c.b0.b.a.a()).subscribe();
            }
        }

        /* compiled from: Consuela.java */
        /* loaded from: classes.dex */
        public class b implements b.h {

            /* compiled from: Consuela.java */
            /* loaded from: classes.dex */
            public class a implements d.c.e0.a {
                public a() {
                }

                @Override // d.c.e0.a
                public void run() {
                    i0 i0Var = i0.this;
                    l.this.a(i0Var.f6609b, true).subscribeOn(d.c.j0.a.b()).observeOn(d.c.b0.b.a.a()).subscribe();
                }
            }

            public b() {
            }

            @Override // h.a.a.b.h
            public void a(int i2, String str) {
                l.this.t = false;
                h.a.a.c.a("LOGIC_BEACONS", "Consuela", "disableHCEValidations", "Error disabling validations. Will try again");
                d.c.b.timer(5L, TimeUnit.SECONDS).subscribeOn(d.c.j0.a.b()).observeOn(d.c.b0.b.a.a()).doOnComplete(new a()).subscribe();
            }

            @Override // h.a.a.b.h
            public void onSuccess() {
                l.this.t = false;
                BackendListeners.DisableHCEValidationsListener disableHCEValidationsListener = i0.this.f6609b;
                if (disableHCEValidationsListener != null) {
                    disableHCEValidationsListener.onSuccess();
                }
                if (h.a.a.j.d().h() != null) {
                    h.a.a.j.d().h().onServiceDisabled(DataModels.Service.HCE_VALIDATION);
                }
            }
        }

        public i0(boolean z, BackendListeners.DisableHCEValidationsListener disableHCEValidationsListener) {
            this.f6608a = z;
            this.f6609b = disableHCEValidationsListener;
        }

        @Override // d.c.b
        public void subscribeActual(d.c.d dVar) {
            try {
                if (this.f6608a) {
                    l.k(l.this);
                } else {
                    l.this.u = (short) 0;
                }
            } catch (Throwable th) {
                l.this.t = false;
                BackendListeners.DisableHCEValidationsListener disableHCEValidationsListener = this.f6609b;
                if (disableHCEValidationsListener != null) {
                    disableHCEValidationsListener.onError(h.a.a.p.a(th));
                }
            }
            if (!h.a.a.b.a().c()) {
                BackendListeners.DisableHCEValidationsListener disableHCEValidationsListener2 = this.f6609b;
                if (disableHCEValidationsListener2 != null) {
                    disableHCEValidationsListener2.onSuccess();
                }
                dVar.a();
            } else if (!this.f6608a || l.this.u < 3) {
                if (!l.this.t) {
                    l.this.t = true;
                    h.a.a.b.a().a(new b());
                    dVar.a();
                    return;
                }
                h.a.a.c.a("LOGIC_BEACONS", "Consuela", "disableHCEValidations", "Already disabling validations. Will try again");
                d.c.b.timer(5L, TimeUnit.SECONDS).subscribeOn(d.c.j0.a.b()).observeOn(d.c.b0.b.a.a()).doOnComplete(new a()).subscribe();
                dVar.a();
            } else {
                l.this.t = false;
                BackendListeners.DisableHCEValidationsListener disableHCEValidationsListener3 = this.f6609b;
                if (disableHCEValidationsListener3 != null) {
                    disableHCEValidationsListener3.onError(new DataModels.Error(DataModels.Error.ErrorType.INTERNAL, "ERROR disabling HCE validations", "ERROR disabling HCE validations"));
                }
                dVar.a();
            }
        }
    }

    /* compiled from: Consuela.java */
    /* loaded from: classes.dex */
    public class i1 implements d.c.e0.f<Object> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ BackendListeners.CreateCustomerRequestListener f6614a;

        public i1(l lVar, BackendListeners.CreateCustomerRequestListener createCustomerRequestListener) {
            this.f6614a = createCustomerRequestListener;
        }

        @Override // d.c.e0.f
        public void accept(Object obj) {
            this.f6614a.onSuccess();
        }
    }

    /* compiled from: Consuela.java */
    /* loaded from: classes.dex */
    public class j implements d.c.e0.f<Object> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ BackendListeners.InitialConfigurationRequestListener f6615a;

        /* compiled from: Consuela.java */
        /* loaded from: classes.dex */
        public class a implements d.c.e0.f<Object> {

            /* compiled from: Consuela.java */
            /* renamed from: h.a.a.l$j$a$a  reason: collision with other inner class name */
            /* loaded from: classes.dex */
            public class C0140a implements d.c.e0.f<Throwable> {
                public C0140a() {
                }

                @Override // d.c.e0.f
                /* renamed from: a */
                public void accept(Throwable th) {
                    j.this.f6615a.onError(h.a.a.p.a(th));
                }
            }

            /* compiled from: Consuela.java */
            /* loaded from: classes.dex */
            public class b implements d.c.e0.a {
                public b() {
                }

                @Override // d.c.e0.a
                public void run() {
                    h.a.a.v.d().a(false);
                    j.this.f6615a.onSuccess();
                }
            }

            public a() {
            }

            @Override // d.c.e0.f
            public void accept(Object obj) {
                l.this.a(DataModels.o.p).doOnComplete(new b()).doOnError(new C0140a()).subscribeOn(d.c.j0.a.b()).observeOn(d.c.b0.b.a.a()).subscribe();
            }
        }

        /* compiled from: Consuela.java */
        /* loaded from: classes.dex */
        public class b implements d.c.e0.f<Throwable> {
            public b() {
            }

            @Override // d.c.e0.f
            /* renamed from: a */
            public void accept(Throwable th) {
                j.this.f6615a.onError(h.a.a.p.a(th));
            }
        }

        public j(BackendListeners.InitialConfigurationRequestListener initialConfigurationRequestListener) {
            this.f6615a = initialConfigurationRequestListener;
        }

        @Override // d.c.e0.f
        public void accept(Object obj) {
            h.a.a.n.a().a(Boolean.TRUE, Boolean.FALSE).subscribeOn(d.c.j0.a.b()).observeOn(d.c.b0.b.a.a()).subscribe(new a(), new b());
        }
    }

    /* compiled from: Consuela.java */
    /* loaded from: classes.dex */
    public class j0 implements d.c.e0.f<Object> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ BackendListeners.i f6621a;

        public j0(l lVar, BackendListeners.i iVar) {
            this.f6621a = iVar;
        }

        @Override // d.c.e0.f
        public void accept(Object obj) {
            this.f6621a.onSuccess();
        }
    }

    /* compiled from: Consuela.java */
    /* loaded from: classes.dex */
    public class j1 implements d.c.e0.f<Throwable> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ BackendListeners.TariffInfoRequestListener f6622a;

        public j1(l lVar, BackendListeners.TariffInfoRequestListener tariffInfoRequestListener) {
            this.f6622a = tariffInfoRequestListener;
        }

        @Override // d.c.e0.f
        /* renamed from: a */
        public void accept(Throwable th) {
            this.f6622a.onError(h.a.a.p.a(th));
        }
    }

    /* compiled from: Consuela.java */
    /* loaded from: classes.dex */
    public class k implements d.c.e0.f<Throwable> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ BackendListeners.SelectPaymentMethodRequestListener f6623a;

        public k(l lVar, BackendListeners.SelectPaymentMethodRequestListener selectPaymentMethodRequestListener) {
            this.f6623a = selectPaymentMethodRequestListener;
        }

        @Override // d.c.e0.f
        /* renamed from: a */
        public void accept(Throwable th) {
            this.f6623a.onError(h.a.a.p.a(th));
        }
    }

    /* compiled from: Consuela.java */
    /* loaded from: classes.dex */
    public class k0 implements b.l {
        public k0(l lVar) {
        }

        @Override // h.a.a.b.l
        public void a() {
        }

        @Override // h.a.a.b.l
        public void a(int i2, String str) {
            h.a.a.c.a("LOGIC_HCE", "Consuela", "Synchronize Failed", "Code: " + i2 + " errorMessage: " + str);
        }
    }

    /* compiled from: Consuela.java */
    /* renamed from: h.a.a.l$l  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0141l implements d.c.e0.f<Object> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ BackendListeners.SyncConfigurationDataRequestListener f6624a;

        public C0141l(l lVar, BackendListeners.SyncConfigurationDataRequestListener syncConfigurationDataRequestListener) {
            this.f6624a = syncConfigurationDataRequestListener;
        }

        @Override // d.c.e0.f
        public void accept(Object obj) {
            BackendListeners.SyncConfigurationDataRequestListener syncConfigurationDataRequestListener = this.f6624a;
            if (syncConfigurationDataRequestListener != null) {
                syncConfigurationDataRequestListener.onSuccess();
            }
        }
    }

    /* compiled from: Consuela.java */
    /* loaded from: classes.dex */
    public class l0 implements d.c.e0.f<Throwable> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ BackendListeners.i f6625a;

        public l0(l lVar, BackendListeners.i iVar) {
            this.f6625a = iVar;
        }

        @Override // d.c.e0.f
        /* renamed from: a */
        public void accept(Throwable th) {
            this.f6625a.onError(h.a.a.p.a(th));
        }
    }

    /* compiled from: Consuela.java */
    /* loaded from: classes.dex */
    public class m implements d.c.e0.f<Throwable> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ BackendListeners.LoginRequestListener f6626a;

        public m(l lVar, BackendListeners.LoginRequestListener loginRequestListener) {
            this.f6626a = loginRequestListener;
        }

        @Override // d.c.e0.f
        /* renamed from: a */
        public void accept(Throwable th) {
            this.f6626a.onError(h.a.a.p.a(th));
        }
    }

    /* compiled from: Consuela.java */
    /* loaded from: classes.dex */
    public class m0 implements d.c.e0.f<DataModels.e> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ String f6627a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ BackendListeners.f f6628b;

        /* compiled from: Consuela.java */
        /* loaded from: classes.dex */
        public class a implements d.c.e0.f<Throwable> {
            public a(m0 m0Var) {
            }

            @Override // d.c.e0.f
            /* renamed from: a */
            public void accept(Throwable th) {
            }
        }

        /* compiled from: Consuela.java */
        /* loaded from: classes.dex */
        public class b implements d.c.e0.a {
            public b() {
            }

            @Override // d.c.e0.a
            public void run() {
                h.a.a.j d2 = h.a.a.j.d();
                if (l.this.o == null || d2.h() == null) {
                    return;
                }
                d2.h().onLogoutRequired();
            }
        }

        /* compiled from: Consuela.java */
        /* loaded from: classes.dex */
        public class c implements d.c.e0.f<Object> {
            public c(m0 m0Var) {
            }

            @Override // d.c.e0.f
            public void accept(Object obj) {
            }
        }

        /* compiled from: Consuela.java */
        /* loaded from: classes.dex */
        public class d implements d.c.e0.f<Throwable> {
            public d(m0 m0Var) {
            }

            @Override // d.c.e0.f
            /* renamed from: a */
            public void accept(Throwable th) {
            }
        }

        public m0(String str, BackendListeners.f fVar) {
            this.f6627a = str;
            this.f6628b = fVar;
        }

        @Override // d.c.e0.f
        /* renamed from: a */
        public void accept(DataModels.e eVar) {
            String str;
            if (eVar.e()) {
                h.a.a.v.d().a(this.f6627a, new Date(h.a.a.p.a(eVar.f()) + ((l.this.f6544h.containsKey("START_OFFLINE_RANGE_MINS") ? Integer.parseInt(((DataModels.f) l.this.f6544h.get("START_OFFLINE_RANGE_MINS")).a()) : 60) * 60 * 1000)), null);
                l.this.b((BackendListeners.EnableHCEValidationsListener) null).subscribeOn(d.c.j0.a.b()).observeOn(d.c.b0.b.a.a()).subscribe();
            } else {
                h.a.a.v d2 = h.a.a.v.d();
                String str2 = this.f6627a;
                Date date = new Date(0L);
                StringBuilder sb = new StringBuilder();
                if (eVar.b() != null) {
                    str = eVar.b() + ";";
                } else {
                    str = "";
                }
                sb.append(str);
                sb.append(eVar.a() != null ? eVar.a() : "");
                d2.a(str2, date, sb.toString());
                l.this.b((BackendListeners.DisableHCEValidationsListener) null).subscribeOn(d.c.j0.a.b()).observeOn(d.c.b0.b.a.a()).subscribe();
            }
            if (eVar.d()) {
                l.this.b((BackendListeners.DisableHCEValidationsListener) null).subscribeOn(d.c.j0.a.b()).observeOn(d.c.b0.b.a.a()).subscribe();
                l.this.a(DataModels.o.C).doOnComplete(new b()).doOnError(new a(this)).subscribeOn(d.c.j0.a.b()).observeOn(d.c.b0.b.a.a()).subscribe();
            }
            if (eVar.c() != null) {
                h.a.a.n.a();
                Date a2 = h.a.a.n.c() ? h.a.a.v.d().a() : null;
                if (a2 == null || a2.before(eVar.c())) {
                    h.a.a.n a3 = h.a.a.n.a();
                    Boolean bool = Boolean.FALSE;
                    a3.a(bool, bool).subscribeOn(d.c.j0.a.b()).observeOn(d.c.b0.b.a.a()).subscribe(new c(this), new d(this));
                }
            }
            BackendListeners.f fVar = this.f6628b;
            if (fVar != null) {
                fVar.onSuccess(eVar.e());
            }
        }
    }

    /* compiled from: Consuela.java */
    /* loaded from: classes.dex */
    public class n implements d.c.e0.f<Throwable> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ BackendListeners.SyncConfigurationDataRequestListener f6631a;

        public n(l lVar, BackendListeners.SyncConfigurationDataRequestListener syncConfigurationDataRequestListener) {
            this.f6631a = syncConfigurationDataRequestListener;
        }

        @Override // d.c.e0.f
        /* renamed from: a */
        public void accept(Throwable th) {
            BackendListeners.SyncConfigurationDataRequestListener syncConfigurationDataRequestListener = this.f6631a;
            if (syncConfigurationDataRequestListener != null) {
                syncConfigurationDataRequestListener.onError(h.a.a.p.a(th));
            }
        }
    }

    /* compiled from: Consuela.java */
    /* loaded from: classes.dex */
    public class n0 implements d.c.e0.f<DataModels.NewStageStartInfo> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ BackendListeners.p f6632a;

        public n0(BackendListeners.p pVar) {
            this.f6632a = pVar;
        }

        @Override // d.c.e0.f
        /* renamed from: a */
        public void accept(DataModels.NewStageStartInfo newStageStartInfo) {
            h.a.a.c.e(newStageStartInfo.getId());
            l lVar = l.this;
            lVar.a(lVar.o.getId(), newStageStartInfo.getId(), Boolean.valueOf(newStageStartInfo.getStartOffline()), newStageStartInfo.getStartDate());
            this.f6632a.a(newStageStartInfo);
        }
    }

    /* compiled from: Consuela.java */
    /* loaded from: classes.dex */
    public class o implements d.c.e0.f<Throwable> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ BackendListeners.InitialConfigurationRequestListener f6634a;

        public o(l lVar, BackendListeners.InitialConfigurationRequestListener initialConfigurationRequestListener) {
            this.f6634a = initialConfigurationRequestListener;
        }

        @Override // d.c.e0.f
        /* renamed from: a */
        public void accept(Throwable th) {
            this.f6634a.onError(h.a.a.p.a(th));
        }
    }

    /* compiled from: Consuela.java */
    /* loaded from: classes.dex */
    public class o0 implements d.c.e0.f<Throwable> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ Collection f6635a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ BackendListeners.p f6636b;

        /* compiled from: Consuela.java */
        /* loaded from: classes.dex */
        public class a implements d.c.e0.f<DataModels.NewStageStartInfo> {
            public a() {
            }

            @Override // d.c.e0.f
            /* renamed from: a */
            public void accept(DataModels.NewStageStartInfo newStageStartInfo) {
                h.a.a.c.e(newStageStartInfo.getId());
                l lVar = l.this;
                lVar.a(lVar.o.getId(), newStageStartInfo.getId(), Boolean.valueOf(newStageStartInfo.getStartOffline()), newStageStartInfo.getStartDate());
                o0.this.f6636b.a(newStageStartInfo);
            }
        }

        /* compiled from: Consuela.java */
        /* loaded from: classes.dex */
        public class b implements d.c.e0.f<Throwable> {
            public b() {
            }

            @Override // d.c.e0.f
            /* renamed from: a */
            public void accept(Throwable th) {
                DataModels.Error a2 = h.a.a.p.a(th);
                h.a.a.c.a("LOGIC_BEACONS", "Consuela", "stageStart", "Online start - ERROR: " + a2.getType().toString());
                o0.this.f6636b.onError(h.a.a.p.a(th));
            }
        }

        public o0(Collection collection, BackendListeners.p pVar) {
            this.f6635a = collection;
            this.f6636b = pVar;
        }

        @Override // d.c.e0.f
        /* renamed from: a */
        public void accept(Throwable th) {
            DataModels.Error a2 = h.a.a.p.a(th);
            h.a.a.c.a("LOGIC_BEACONS", "Consuela", "stageStart", "Offline start - ERROR: " + a2.getType().toString());
            h.a.a.n.a().a(String.valueOf(l.this.o.getId()), (List<DataModels.b>) new ArrayList(this.f6635a), false, l.this.o.getEmail()).subscribeOn(d.c.j0.a.b()).observeOn(d.c.b0.b.a.a()).subscribe(new a(), new b());
        }
    }

    /* compiled from: Consuela.java */
    /* loaded from: classes.dex */
    public class p implements BackendListeners.HasOngoingStageListener {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ BackendListeners.LogoutRequestListener f6640a;

        /* compiled from: Consuela.java */
        /* loaded from: classes.dex */
        public class a implements d.c.e0.f<Object> {
            public a() {
            }

            @Override // d.c.e0.f
            public void accept(Object obj) {
                l.this.o = null;
                l.this.b((BackendListeners.DisableHCEValidationsListener) null).subscribeOn(d.c.j0.a.b()).observeOn(d.c.b0.b.a.a()).subscribe();
                h.a.a.n.a().d().subscribeOn(d.c.j0.a.b()).subscribe();
                p.this.f6640a.onSuccess();
            }
        }

        /* compiled from: Consuela.java */
        /* loaded from: classes.dex */
        public class b implements d.c.e0.f<Throwable> {
            public b() {
            }

            @Override // d.c.e0.f
            /* renamed from: a */
            public void accept(Throwable th) {
                p.this.f6640a.onError(h.a.a.p.a(th));
            }
        }

        public p(BackendListeners.LogoutRequestListener logoutRequestListener) {
            this.f6640a = logoutRequestListener;
        }

        @Override // pt.card4b.backendbeacons.BackendListeners.BaseRequestListener
        public void onError(DataModels.Error error) {
            this.f6640a.onError(error);
        }

        @Override // pt.card4b.backendbeacons.BackendListeners.HasOngoingStageListener
        public void onSuccess(boolean z) {
            if (z) {
                this.f6640a.onError(DataModels.Error.stageOngoing());
            } else {
                h.a.a.n.a().p(l.this.o.getEmail()).subscribeOn(d.c.j0.a.b()).observeOn(d.c.b0.b.a.a()).subscribe(new a(), new b());
            }
        }
    }

    /* compiled from: Consuela.java */
    /* loaded from: classes.dex */
    public class p0 implements d.c.e0.f<Throwable> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ BackendListeners.f f6644a;

        public p0(l lVar, BackendListeners.f fVar) {
            this.f6644a = fVar;
        }

        @Override // d.c.e0.f
        /* renamed from: a */
        public void accept(Throwable th) {
            BackendListeners.f fVar = this.f6644a;
            if (fVar != null) {
                fVar.onError(h.a.a.p.a(th));
            }
        }
    }

    /* compiled from: Consuela.java */
    /* loaded from: classes.dex */
    public class q0 implements d.c.e0.f<Object> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ BackendListeners.GetLogListener f6646a;

        public q0(l lVar, BackendListeners.GetLogListener getLogListener) {
            this.f6646a = getLogListener;
        }

        @Override // d.c.e0.f
        public void accept(Object obj) {
            if (obj != null && (obj instanceof File)) {
                BackendListeners.GetLogListener getLogListener = this.f6646a;
                if (getLogListener != null) {
                    getLogListener.onSuccess(((File) obj).getPath());
                    return;
                }
                return;
            }
            BackendListeners.GetLogListener getLogListener2 = this.f6646a;
            if (getLogListener2 != null) {
                getLogListener2.onError(new DataModels.Error(DataModels.Error.ErrorType.INTERNAL, "Error getting lib log", "Error getting lib log"));
            }
        }
    }

    /* compiled from: Consuela.java */
    /* loaded from: classes.dex */
    public class r implements d.c.e0.f<Boolean> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ BackendListeners.HasOngoingStageListener f6647a;

        public r(l lVar, BackendListeners.HasOngoingStageListener hasOngoingStageListener) {
            this.f6647a = hasOngoingStageListener;
        }

        @Override // d.c.e0.f
        /* renamed from: a */
        public void accept(Boolean bool) {
            this.f6647a.onSuccess(bool.booleanValue());
        }
    }

    /* compiled from: Consuela.java */
    /* loaded from: classes.dex */
    public class r0 implements d.c.e0.f<Object> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ BackendListeners.n f6648a;

        public r0(l lVar, BackendListeners.n nVar) {
            this.f6648a = nVar;
        }

        @Override // d.c.e0.f
        public void accept(Object obj) {
            this.f6648a.onSuccess();
        }
    }

    /* compiled from: Consuela.java */
    /* loaded from: classes.dex */
    public class s implements d.c.e0.f<Object> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ BackendListeners.SendInvoiceEmailListener f6649a;

        public s(l lVar, BackendListeners.SendInvoiceEmailListener sendInvoiceEmailListener) {
            this.f6649a = sendInvoiceEmailListener;
        }

        @Override // d.c.e0.f
        public void accept(Object obj) {
            BackendListeners.SendInvoiceEmailListener sendInvoiceEmailListener = this.f6649a;
            if (sendInvoiceEmailListener != null) {
                sendInvoiceEmailListener.onSuccess();
            }
        }
    }

    /* compiled from: Consuela.java */
    /* loaded from: classes.dex */
    public class s0 implements d.c.e0.f<DataModels.UserAccountInfo> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ BackendListeners.GetUserAccountListener f6650a;

        /* compiled from: Consuela.java */
        /* loaded from: classes.dex */
        public class a implements d.c.e0.f<Object> {

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ DataModels.UserAccountInfo f6652a;

            public a(DataModels.UserAccountInfo userAccountInfo) {
                this.f6652a = userAccountInfo;
            }

            @Override // d.c.e0.f
            public void accept(Object obj) {
                BackendListeners.GetUserAccountListener getUserAccountListener = s0.this.f6650a;
                if (getUserAccountListener != null) {
                    getUserAccountListener.onSuccess(this.f6652a);
                }
            }
        }

        /* compiled from: Consuela.java */
        /* loaded from: classes.dex */
        public class b implements d.c.e0.f<Throwable> {
            public b() {
            }

            @Override // d.c.e0.f
            /* renamed from: a */
            public void accept(Throwable th) {
                s0.this.f6650a.onError(h.a.a.p.a(th));
            }
        }

        public s0(BackendListeners.GetUserAccountListener getUserAccountListener) {
            this.f6650a = getUserAccountListener;
        }

        @Override // d.c.e0.f
        /* renamed from: a */
        public void accept(DataModels.UserAccountInfo userAccountInfo) {
            l.this.o = userAccountInfo.toUser();
            h.a.a.n.a().a(l.this.o).subscribe(new a(userAccountInfo), new b());
        }
    }

    /* compiled from: Consuela.java */
    /* loaded from: classes.dex */
    public class t implements d.c.e0.f<Throwable> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ BackendListeners.CreateCustomerRequestListener f6655a;

        public t(l lVar, BackendListeners.CreateCustomerRequestListener createCustomerRequestListener) {
            this.f6655a = createCustomerRequestListener;
        }

        @Override // d.c.e0.f
        /* renamed from: a */
        public void accept(Throwable th) {
            this.f6655a.onError(h.a.a.p.a(th));
        }
    }

    /* compiled from: Consuela.java */
    /* loaded from: classes.dex */
    public class t0 implements d.c.e0.f<Throwable> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ BackendListeners.n f6656a;

        public t0(l lVar, BackendListeners.n nVar) {
            this.f6656a = nVar;
        }

        @Override // d.c.e0.f
        /* renamed from: a */
        public void accept(Throwable th) {
            this.f6656a.onError(h.a.a.p.a(th));
        }
    }

    /* compiled from: Consuela.java */
    /* loaded from: classes.dex */
    public class u implements d.c.e0.f<Throwable> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ BackendListeners.HasOngoingStageListener f6657a;

        public u(l lVar, BackendListeners.HasOngoingStageListener hasOngoingStageListener) {
            this.f6657a = hasOngoingStageListener;
        }

        @Override // d.c.e0.f
        /* renamed from: a */
        public void accept(Throwable th) {
            this.f6657a.onError(h.a.a.p.a(th));
        }
    }

    /* compiled from: Consuela.java */
    /* loaded from: classes.dex */
    public class u0 implements d.c.e0.f<Throwable> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ BackendListeners.GetUserAccountListener f6658a;

        public u0(l lVar, BackendListeners.GetUserAccountListener getUserAccountListener) {
            this.f6658a = getUserAccountListener;
        }

        @Override // d.c.e0.f
        /* renamed from: a */
        public void accept(Throwable th) {
            BackendListeners.GetUserAccountListener getUserAccountListener = this.f6658a;
            if (getUserAccountListener != null) {
                getUserAccountListener.onError(h.a.a.p.a(th));
            }
        }
    }

    /* compiled from: Consuela.java */
    /* loaded from: classes.dex */
    public class v implements d.c.e0.f<Throwable> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ BackendListeners.SendInvoiceEmailListener f6659a;

        public v(l lVar, BackendListeners.SendInvoiceEmailListener sendInvoiceEmailListener) {
            this.f6659a = sendInvoiceEmailListener;
        }

        @Override // d.c.e0.f
        /* renamed from: a */
        public void accept(Throwable th) {
            BackendListeners.SendInvoiceEmailListener sendInvoiceEmailListener = this.f6659a;
            if (sendInvoiceEmailListener != null) {
                sendInvoiceEmailListener.onError(h.a.a.p.a(th));
            }
        }
    }

    /* compiled from: Consuela.java */
    /* loaded from: classes.dex */
    public class v0 implements d.c.e0.f<Object> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ BackendListeners.n f6660a;

        public v0(l lVar, BackendListeners.n nVar) {
            this.f6660a = nVar;
        }

        @Override // d.c.e0.f
        public void accept(Object obj) {
            this.f6660a.onSuccess();
        }
    }

    /* compiled from: Consuela.java */
    /* loaded from: classes.dex */
    public class w implements d.c.e0.f<Object> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ BackendListeners.ResetPasswordRequestListener f6661a;

        public w(l lVar, BackendListeners.ResetPasswordRequestListener resetPasswordRequestListener) {
            this.f6661a = resetPasswordRequestListener;
        }

        @Override // d.c.e0.f
        public void accept(Object obj) {
            this.f6661a.onSuccess();
        }
    }

    /* compiled from: Consuela.java */
    /* loaded from: classes.dex */
    public class w0 implements b.m {
        public w0() {
        }

        @Override // h.a.a.b.m
        public void a(DataModels.i iVar, long j, long j2, long j3, int i2, int i3, int i4, int i5, int i6, int i7) {
            int i8;
            int i9;
            int i10;
            int i11;
            int i12 = i2;
            if (l.this.o == null) {
                h.a.a.c.a("LOGIC_BEACONS", "Consuela", "HCEValidationListener", "Validation success but no active user!");
                return;
            }
            h.a.a.c.a("LOGIC_BEACONS", "Consuela", "HCEValidationListener", "Validation success, going to validate info");
            DataModels.m mVar = (DataModels.m) l.this.f6537a.get(i12);
            if (mVar != null) {
                if (mVar.e() == null || mVar.e().a() != DataModels.n.f7735c) {
                    Map<String, DataModels.q> s = l.this.s();
                    StringBuilder sb = new StringBuilder();
                    sb.append(i5);
                    sb.append("|");
                    sb.append(i12);
                    i8 = s.get(sb.toString()) != null ? i5 : 9999;
                    i9 = 0;
                    i10 = 0;
                    i11 = 0;
                } else {
                    i9 = i3;
                    i11 = i6;
                    i10 = i7;
                    i8 = 9999;
                }
                if (i9 > 0) {
                    Map<String, DataModels.j> p = l.this.p();
                    DataModels.j jVar = p.get(i9 + "|" + i12);
                    if (jVar != null) {
                        i12 = jVar.c();
                    } else {
                        h.a.a.c.a("LOGIC_BEACONS", "Consuela", "onValidationSuccess", "Line with ref =" + i9 + " and owner " + i12 + " not found");
                    }
                }
                DataModels.c cVar = new DataModels.c(i12 + "|0|" + i9 + "|" + i10 + "|" + i11 + "|" + i8 + "|" + i4, "HCE_VALIDATOR", "FF:FF:FF:FF:FF:FF", 0, 52, j, j2, true, j, 0.0d, 0.0d, 0.0d, j3, iVar != null ? iVar.c() : null, iVar != null ? iVar.a() : 0L);
                cVar.a(1, i12, 0, 0, i9, i10, i11, i8, i4, 0, 0);
                h.a.a.j.d().d(cVar);
                return;
            }
            h.a.a.c.a("LOGIC_BEACONS", "Consuela", "onValidationSuccess", "Invalid operator " + i12);
        }
    }

    /* compiled from: Consuela.java */
    /* loaded from: classes.dex */
    public class x implements d.c.e0.f<DataModels.p> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ BackendListeners.b f6663a;

        public x(l lVar, BackendListeners.b bVar) {
            this.f6663a = bVar;
        }

        @Override // d.c.e0.f
        /* renamed from: a */
        public void accept(DataModels.p pVar) {
            h.a.a.c.e(pVar.l());
            this.f6663a.a(pVar);
        }
    }

    /* compiled from: Consuela.java */
    /* loaded from: classes.dex */
    public class x0 implements d.c.e0.f<Throwable> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ BackendListeners.n f6664a;

        public x0(l lVar, BackendListeners.n nVar) {
            this.f6664a = nVar;
        }

        @Override // d.c.e0.f
        /* renamed from: a */
        public void accept(Throwable th) {
            this.f6664a.onError(h.a.a.p.a(th));
        }
    }

    /* compiled from: Consuela.java */
    /* loaded from: classes.dex */
    public class y extends d.c.b {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ String f6665a;

        /* compiled from: Consuela.java */
        /* loaded from: classes.dex */
        public class a implements d.c.e0.f<Boolean> {

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ d.c.d f6667a;

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ DataModels.User f6668b;

            /* compiled from: Consuela.java */
            /* renamed from: h.a.a.l$y$a$a  reason: collision with other inner class name */
            /* loaded from: classes.dex */
            public class C0142a implements BackendListeners.FinishStageRequestListener {
                public C0142a() {
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
                    h.a.a.c.a("LOGIC_BEACONS", "Consuela", "finishOngoingTrip:BeaconManager:finishStage", sb.toString());
                    a.this.f6667a.a(new Exception());
                }

                @Override // pt.card4b.backendbeacons.BackendListeners.FinishStageRequestListener
                public void onSuccess() {
                    h.a.a.c.a("LOGIC_BEACONS", "Consuela", "finishOngoingTrip:BeaconManager:finishStage", "finishOngoingTrip succeeded");
                    a.this.f6667a.a();
                }
            }

            /* compiled from: Consuela.java */
            /* loaded from: classes.dex */
            public class b implements d.c.e0.f<DataModels.p> {

                /* compiled from: Consuela.java */
                /* renamed from: h.a.a.l$y$a$b$a  reason: collision with other inner class name */
                /* loaded from: classes.dex */
                public class C0143a implements d.c.e0.f<Object> {

                    /* compiled from: Consuela.java */
                    /* renamed from: h.a.a.l$y$a$b$a$a  reason: collision with other inner class name */
                    /* loaded from: classes.dex */
                    public class C0144a implements d.c.e0.f<Object> {
                        public C0144a() {
                        }

                        @Override // d.c.e0.f
                        public void accept(Object obj) {
                            h.a.a.c.a("LOGIC_BEACONS", "Consuela", "finishOngoingTrip:removeStageState", "finishOngoingTrip succeeded");
                            a.this.f6667a.a();
                        }
                    }

                    /* compiled from: Consuela.java */
                    /* renamed from: h.a.a.l$y$a$b$a$b  reason: collision with other inner class name */
                    /* loaded from: classes.dex */
                    public class C0145b implements d.c.e0.f<Throwable> {
                        public C0145b() {
                        }

                        @Override // d.c.e0.f
                        /* renamed from: a */
                        public void accept(Throwable th) {
                            String str;
                            DataModels.Error a2 = h.a.a.p.a(th);
                            StringBuilder sb = new StringBuilder();
                            sb.append("ERROR: ");
                            if (a2 == null || a2.getType() == null) {
                                str = "";
                            } else {
                                str = "type:" + a2.getType().toString();
                            }
                            sb.append(str);
                            h.a.a.c.a("LOGIC_BEACONS", "Consuela", "finishOngoingTrip:removeStageState", sb.toString());
                            a.this.f6667a.a(new Exception());
                        }
                    }

                    public C0143a() {
                    }

                    @Override // d.c.e0.f
                    public void accept(Object obj) {
                        h.a.a.n.a().q(a.this.f6668b.getEmail()).subscribeOn(d.c.j0.a.b()).observeOn(d.c.b0.b.a.a()).subscribe(new C0144a(), new C0145b());
                    }
                }

                /* compiled from: Consuela.java */
                /* renamed from: h.a.a.l$y$a$b$b  reason: collision with other inner class name */
                /* loaded from: classes.dex */
                public class C0146b implements d.c.e0.f<Throwable> {
                    public C0146b() {
                    }

                    @Override // d.c.e0.f
                    /* renamed from: a */
                    public void accept(Throwable th) {
                        String str;
                        DataModels.Error a2 = h.a.a.p.a(th);
                        StringBuilder sb = new StringBuilder();
                        sb.append("ERROR: ");
                        if (a2 == null || a2.getType() == null) {
                            str = "";
                        } else {
                            str = "type:" + a2.getType().toString();
                        }
                        sb.append(str);
                        h.a.a.c.a("LOGIC_BEACONS", "Consuela", "finishOngoingTrip:stageFinish", sb.toString());
                        a.this.f6667a.a(new Exception());
                    }
                }

                public b() {
                }

                /* JADX WARN: Removed duplicated region for block: B:23:0x0135  */
                /* JADX WARN: Removed duplicated region for block: B:28:0x0185 A[ADDED_TO_REGION] */
                @Override // d.c.e0.f
                /* renamed from: a */
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                    To view partially-correct add '--show-bad-code' argument
                */
                public void accept(pt.card4b.backendbeacons.DataModels.p r19) {
                    /*
                        Method dump skipped, instructions count: 612
                        To view this dump add '--comments-level debug' option
                    */
                    throw new UnsupportedOperationException("Method not decompiled: h.a.a.l.y.a.b.accept(pt.card4b.backendbeacons.DataModels$p):void");
                }
            }

            /* compiled from: Consuela.java */
            /* loaded from: classes.dex */
            public class c implements d.c.e0.f<Throwable> {
                public c() {
                }

                @Override // d.c.e0.f
                /* renamed from: a */
                public void accept(Throwable th) {
                    String str;
                    DataModels.Error a2 = h.a.a.p.a(th);
                    StringBuilder sb = new StringBuilder();
                    sb.append("ERROR: ");
                    if (a2 == null || a2.getType() == null) {
                        str = "";
                    } else {
                        str = "type:" + a2.getType().toString();
                    }
                    sb.append(str);
                    h.a.a.c.a("LOGIC_BEACONS", "Consuela", "finishOngoingTrip:getStageState", sb.toString());
                    a.this.f6667a.a(new Exception());
                }
            }

            public a(d.c.d dVar, DataModels.User user) {
                this.f6667a = dVar;
                this.f6668b = user;
            }

            /* JADX WARN: Removed duplicated region for block: B:26:0x016a  */
            @Override // d.c.e0.f
            /* renamed from: a */
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct add '--show-bad-code' argument
            */
            public void accept(java.lang.Boolean r18) {
                /*
                    Method dump skipped, instructions count: 516
                    To view this dump add '--comments-level debug' option
                */
                throw new UnsupportedOperationException("Method not decompiled: h.a.a.l.y.a.accept(java.lang.Boolean):void");
            }
        }

        /* compiled from: Consuela.java */
        /* loaded from: classes.dex */
        public class b implements d.c.e0.f<Throwable> {

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ d.c.d f6677a;

            public b(y yVar, d.c.d dVar) {
                this.f6677a = dVar;
            }

            @Override // d.c.e0.f
            /* renamed from: a */
            public void accept(Throwable th) {
                String str;
                DataModels.Error a2 = h.a.a.p.a(th);
                StringBuilder sb = new StringBuilder();
                sb.append("ERROR: ");
                if (a2 == null || a2.getType() == null) {
                    str = "";
                } else {
                    str = "type:" + a2.getType().toString();
                }
                sb.append(str);
                h.a.a.c.a("LOGIC_BEACONS", "Consuela", "finishOngoingTrip", sb.toString());
                this.f6677a.a(new Exception());
            }
        }

        public y(String str) {
            this.f6665a = str;
        }

        @Override // d.c.b
        public void subscribeActual(d.c.d dVar) {
            DataModels.User k = h.a.a.v.d().k();
            if (k == null) {
                h.a.a.c.a("LOGIC_BEACONS", "Consuela", "finishOngoingTrip", "No user logged in");
                dVar.a();
            } else if (h.a.a.v.d().l()) {
                h.a.a.c.a("LOGIC_BEACONS", "Consuela", "finishOngoingTrip", "The app is restarting from crash");
                dVar.a();
            } else {
                h.a.a.n.a().o(k.getEmail()).subscribeOn(d.c.j0.a.b()).observeOn(d.c.b0.b.a.a()).subscribe(new a(dVar, k), new b(this, dVar));
            }
        }
    }

    /* compiled from: Consuela.java */
    /* loaded from: classes.dex */
    public class y0 implements Runnable {

        /* compiled from: Consuela.java */
        /* loaded from: classes.dex */
        public class a implements BackendListeners.f {
            public a() {
            }

            @Override // pt.card4b.backendbeacons.BackendListeners.BaseRequestListener
            public void onError(DataModels.Error error) {
                AbstractMap.SimpleEntry<Date, String> b2 = h.a.a.v.d().b(l.this.o.getId());
                if (b2 == null || b2.getKey().before(new Date(h.a.a.w.d().h() + 3600000))) {
                    l.this.a(60000L);
                } else {
                    l.this.a(600000L);
                }
            }

            @Override // pt.card4b.backendbeacons.BackendListeners.f
            public void onSuccess(boolean z) {
                l.this.a(3600000L);
            }
        }

        public y0() {
        }

        public void finalize() {
            h.a.a.c.a("LOGIC_OTHER", "BeaconManager", "offlineStartPermitRunnable:finalize", "entered method");
            super.finalize();
        }

        @Override // java.lang.Runnable
        public void run() {
            if (l.this.o != null) {
                l.this.a(new a());
            } else {
                l.this.a(600000L);
            }
        }
    }

    /* compiled from: Consuela.java */
    /* loaded from: classes.dex */
    public class z implements d.c.e0.f<Throwable> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ BackendListeners.ResetPasswordRequestListener f6680a;

        public z(l lVar, BackendListeners.ResetPasswordRequestListener resetPasswordRequestListener) {
            this.f6680a = resetPasswordRequestListener;
        }

        @Override // d.c.e0.f
        /* renamed from: a */
        public void accept(Throwable th) {
            this.f6680a.onError(h.a.a.p.a(th));
        }
    }

    /* compiled from: Consuela.java */
    /* loaded from: classes.dex */
    public class z0 implements d.c.e0.f<DataModels.User> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ BackendListeners.GetSavedUserRequestListener f6681a;

        public z0(BackendListeners.GetSavedUserRequestListener getSavedUserRequestListener) {
            this.f6681a = getSavedUserRequestListener;
        }

        @Override // d.c.e0.f
        /* renamed from: a */
        public void accept(DataModels.User user) {
            l.this.o = user;
            l.j().post(l.this.y);
            l.this.b((BackendListeners.EnableHCEValidationsListener) null).subscribeOn(d.c.j0.a.b()).observeOn(d.c.b0.b.a.a()).subscribe();
            this.f6681a.onSuccess(l.this.o.getCopy());
            h.a.a.c.a("LOGIC_USER", "Consuela", "verifyAndGetUser", "onSuccess");
        }
    }

    static {
        System.loadLibrary("native-lib");
    }

    public l() {
        DataModels.User k2;
        boolean z2 = false;
        this.p = false;
        if (F == null) {
            d.c.h0.a.a(new d0(this));
            App.getContext().registerReceiver(this.A, new IntentFilter("android.bluetooth.adapter.action.STATE_CHANGED"));
            App.getContext().registerReceiver(this.C, new IntentFilter("android.nfc.action.ADAPTER_STATE_CHANGED"));
            App.getContext().registerReceiver(this.B, new IntentFilter("android.location.PROVIDERS_CHANGED"));
            App.getContext().registerReceiver(this.D, new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"));
            boolean initializeNative = App.initializeNative();
            boolean y2 = h.a.a.v.d().y();
            if (!initializeNative && y2) {
                h.a.a.v.d().C();
            }
            Database.r();
            h.a.a.n.a();
            String f2 = h.a.a.v.d().f();
            if ((f2 == null || f2.equals("")) && (k2 = h.a.a.v.d().k()) != null) {
                h.a.a.v.d().h(k2.getEmail());
            }
            if (h.a.a.v.d().j() == null) {
                h.a.a.v.d().C();
            }
            h.a.a.h.d();
            h.a.a.b.a().a(this.x);
            y();
            h.a.a.j.d();
            h.a.a.c.a("LOGIC_BEACONS", "Consuela", "init", "init nt: " + initializeNative + " sp:" + y2);
            if (initializeNative && y2) {
                z2 = true;
            }
            this.p = z2;
            return;
        }
        throw new RuntimeException("Consuela: Use getInstance() method to get the single instance of this class.");
    }

    public static /* synthetic */ short f(l lVar) {
        short s2 = lVar.s;
        lVar.s = (short) (s2 + 1);
        return s2;
    }

    public static /* synthetic */ short k(l lVar) {
        short s2 = lVar.u;
        lVar.u = (short) (s2 + 1);
        return s2;
    }

    public static /* synthetic */ short p(l lVar) {
        short s2 = lVar.w;
        lVar.w = (short) (s2 + 1);
        return s2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public DataModels.Error x() {
        String j2 = h.a.a.v.d().j();
        DataModels.User user = this.o;
        if (user != null && (user == null || (j2 != null && !j2.equals("")))) {
            if (!this.p) {
                return DataModels.Error.initFailedDataSuspect();
            }
            if (h.a.a.v.d().h() == null) {
                return DataModels.Error.missingRegistrationKey();
            }
            if (!this.q) {
                return new DataModels.Error(DataModels.Error.ErrorType.INTERNAL, "App is not ready to receive a stage start", "App is not ready to receive a stage start");
            }
            DataModels.Error w2 = w();
            if (w2 != null) {
                return w2;
            }
            if (!h.a.a.b.a().b()) {
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
                    h.a.a.c.a("LOGIC_BEACONS", "Consuela", "isValidationHCEAllowed", "location services mode could not be resolved: " + Log.getStackTraceString(th));
                    return DataModels.Error.locationDisabled();
                }
            } catch (Throwable th2) {
                h.a.a.c.a("LOGIC_BEACONS", "Consuela", "isValidationHCEAllowed", "bluetooth adapter exception: " + Log.getStackTraceString(th2));
                return DataModels.Error.bluetoothDisabled();
            }
        }
        return DataModels.Error.loginRequired();
    }

    public Map<String, DataModels.q> s() {
        return this.f6541e;
    }

    public Map<String, DataModels.q> t() {
        return this.f6542f;
    }

    public SparseArray<DataModels.r> u() {
        return this.f6543g;
    }

    public boolean v() {
        return this.p;
    }

    public DataModels.Error w() {
        AbstractMap.SimpleEntry<Date, String> b2 = h.a.a.v.d().b(this.o.getId());
        if (b2 == null || b2.getKey().before(h.a.a.w.d().e())) {
            return DataModels.Error.getOfflinePermitError(b2 != null ? b2.getValue() : null);
        }
        return null;
    }

    public void y() {
        j().post(this.y);
        j().post(this.z);
    }

    public void z() {
        try {
            if (h.a.a.j.d().h() != null) {
                h.a.a.c.a("LOGIC_BEACONS", "Consuela", "wakeUpScreen", "Alert the app to wake up the screen");
                h.a.a.j.d().h().onWakeUpRequired();
            }
        } catch (Throwable th) {
            h.a.a.c.a("LOGIC_BEACONS", "Consuela", "wakeUpScreen", "Exception: " + Log.getStackTraceString(th));
        }
    }

    public static Handler j() {
        if (E == null) {
            E = new Handler();
        }
        return E;
    }

    public static l k() {
        if (F == null) {
            synchronized (l.class) {
                if (F == null) {
                    F = new l();
                }
            }
        }
        return F;
    }

    public boolean d() {
        return (this.f6537a == null || this.f6538b == null || this.f6539c == null || this.f6541e == null || this.f6543g == null || this.f6545i == null || this.j == null || this.k == null || this.f6544h == null || this.l == null) ? false : true;
    }

    public DataModels.User e() {
        return this.o;
    }

    public Map<String, DataModels.d> f() {
        return this.k;
    }

    public Map<String, DataModels.f> g() {
        return this.f6544h;
    }

    public Map<String, DataModels.Country> h() {
        return this.m;
    }

    public Map<String, DataModels.CustomerProfile> i() {
        return this.l;
    }

    public Map<String, DataModels.Language> l() {
        return this.n;
    }

    public Map<String, DataModels.k> m() {
        return this.f6545i;
    }

    public SparseArray<DataModels.l> n() {
        return this.j;
    }

    public Map<String, DataModels.j> o() {
        return this.f6539c;
    }

    public Map<String, DataModels.j> p() {
        return this.f6540d;
    }

    public List<DataModels.m> q() {
        return this.f6538b;
    }

    public SparseArray<DataModels.m> r() {
        return this.f6537a;
    }

    /* compiled from: Consuela.java */
    /* loaded from: classes.dex */
    public class q implements b.k {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ BackendListeners.GetCardInfoListener f6645a;

        public q(l lVar, BackendListeners.GetCardInfoListener getCardInfoListener) {
            this.f6645a = getCardInfoListener;
        }

        @Override // h.a.a.b.k
        public void a(DataModels.i iVar) {
            if (iVar != null) {
                BackendListeners.GetCardInfoListener getCardInfoListener = this.f6645a;
                if (getCardInfoListener != null) {
                    getCardInfoListener.onSucess(new DataModels.CardInfo(iVar.b()));
                    return;
                }
                return;
            }
            BackendListeners.GetCardInfoListener getCardInfoListener2 = this.f6645a;
            if (getCardInfoListener2 != null) {
                getCardInfoListener2.onError(DataModels.Error.internal("Failed to get card info"));
            }
        }

        @Override // h.a.a.b.k
        public void a(int i2, String str) {
            BackendListeners.GetCardInfoListener getCardInfoListener = this.f6645a;
            if (getCardInfoListener != null) {
                getCardInfoListener.onError(DataModels.Error.internal("Failed to get card info"));
            }
        }
    }

    public void c() {
        Boolean bool;
        String str;
        Date date;
        try {
            if (h.a.a.j.d().h() != null) {
                h.a.a.c.a("LOGIC_BEACONS", "Consuela", "alertOnTripAppActivityBlocked", "Alert the app that the trip runnable is not running for a long time, it may be blocked.");
                h.a.a.j.d().h().onTripAppActivityBlocked();
            }
            Boolean bool2 = Boolean.FALSE;
            if (h.a.a.j.d().g() != null) {
                String l = h.a.a.j.d().g().l();
                date = h.a.a.j.d().g().m();
                bool = h.a.a.j.d().g().n();
                str = l;
            } else {
                bool = bool2;
                str = null;
                date = null;
            }
            DataModels.User user = this.o;
            h.a.a.v.d().a(new DataModels.h(user != null ? user.getId() : null, str, bool, date, DataModels.h.n, h.a.a.w.d().e(), null, null));
        } catch (Throwable th) {
            h.a.a.c.a("LOGIC_BEACONS", "Consuela", "alertOnTripAppActivityBlocked", "Exception: " + Log.getStackTraceString(th));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public d.c.b b(BackendListeners.EnableHCEValidationsListener enableHCEValidationsListener) {
        return a(enableHCEValidationsListener, false, (DataModels.Error) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public d.c.b b(BackendListeners.DisableHCEValidationsListener disableHCEValidationsListener) {
        return a(disableHCEValidationsListener, false);
    }

    public void b(String str) {
        String j2 = h.a.a.v.d().j();
        if ((j2 != null || str == null) && ((j2 == null || str != null) && (j2 == null || str == null || j2.equals(str)))) {
            return;
        }
        if (str != null && !str.equals("")) {
            h.a.a.v.d().j(str);
            return;
        }
        h.a.a.v.d().D();
        if (this.o == null || h.a.a.j.d().g() != null || h.a.a.j.d().h() == null) {
            return;
        }
        h.a.a.j.d().h().onLogoutRequired();
    }

    public void a(String str, String str2, BackendListeners.LoginRequestListener loginRequestListener) {
        h.a.a.c.a("LOGIC_BEACONS", "Consuela", "login", "entered method");
        if (str != null && !str.equals("")) {
            String f2 = h.a.a.v.d().f();
            if (f2 != null && !f2.equals("") && !f2.equalsIgnoreCase(str)) {
                loginRequestListener.onError(DataModels.Error.account_mismatch(f2));
                h.a.a.c.a("LOGIC_BEACONS", "Consuela", "login", "ERROR: " + DataModels.Error.account_mismatch(f2).getMessage());
                return;
            } else if (str2 != null && !str2.equals("")) {
                if (!this.p) {
                    loginRequestListener.onError(DataModels.Error.initFailedDataSuspect());
                    h.a.a.c.a("LOGIC_BEACONS", "Consuela", "login", "ERROR: " + DataModels.Error.initFailedDataSuspect().getMessage());
                    return;
                }
                h.a.a.n.a().a(str, str2).subscribeOn(d.c.j0.a.b()).observeOn(d.c.b0.b.a.a()).subscribe(new e0(loginRequestListener), new m(this, loginRequestListener));
                return;
            } else {
                loginRequestListener.onError(DataModels.Error.fieldRequired(h.a.a.p.a(h.a.a.a.password)));
                h.a.a.c.a("LOGIC_BEACONS", "Consuela", "login", "ERROR: " + DataModels.Error.fieldRequired(h.a.a.p.a(h.a.a.a.password)).getMessage());
                return;
            }
        }
        loginRequestListener.onError(DataModels.Error.fieldRequired(h.a.a.p.a(h.a.a.a.email)));
        h.a.a.c.a("LOGIC_BEACONS", "Consuela", "login", "ERROR: " + DataModels.Error.fieldRequired(h.a.a.p.a(h.a.a.a.email)).getMessage());
    }

    public void a(BackendListeners.LogoutRequestListener logoutRequestListener) {
        if (this.o == null) {
            logoutRequestListener.onError(DataModels.Error.loginRequired());
        } else {
            a(new p(logoutRequestListener));
        }
    }

    public void a(DataModels.UserAccountInfo userAccountInfo, String str, BackendListeners.CreateCustomerRequestListener createCustomerRequestListener) {
        if (userAccountInfo.getName() == null || userAccountInfo.getName().equals("")) {
            createCustomerRequestListener.onError(DataModels.Error.fieldRequired(h.a.a.p.a(h.a.a.a.name)));
        } else if (userAccountInfo.getEmail() == null || userAccountInfo.getEmail().equals("")) {
            createCustomerRequestListener.onError(DataModels.Error.fieldRequired(h.a.a.p.a(h.a.a.a.email)));
        } else if (str == null || str.equals("")) {
            createCustomerRequestListener.onError(DataModels.Error.fieldRequired(h.a.a.p.a(h.a.a.a.password)));
        } else if (userAccountInfo.getPhonenumber() == null || userAccountInfo.getPhonenumber().equals("")) {
            createCustomerRequestListener.onError(DataModels.Error.fieldRequired(h.a.a.p.a(h.a.a.a.phonenumber)));
        } else {
            h.a.a.n.a().a(userAccountInfo, str).subscribeOn(d.c.j0.a.b()).observeOn(d.c.b0.b.a.a()).subscribe(new i1(this, createCustomerRequestListener), new t(this, createCustomerRequestListener));
        }
    }

    public void a(String str, BackendListeners.ResetPasswordRequestListener resetPasswordRequestListener) {
        if (str == null || str.equals("")) {
            resetPasswordRequestListener.onError(DataModels.Error.fieldRequired(h.a.a.p.a(h.a.a.a.email)));
        } else {
            h.a.a.n.a().r(str).subscribeOn(d.c.j0.a.b()).observeOn(d.c.b0.b.a.a()).subscribe(new w(this, resetPasswordRequestListener), new z(this, resetPasswordRequestListener));
        }
    }

    public void a(DataModels.UserAccountInfo userAccountInfo, BackendListeners.UpdateUserRequestListener updateUserRequestListener) {
        if (userAccountInfo.getName() == null || userAccountInfo.getName().equals("")) {
            updateUserRequestListener.onError(DataModels.Error.fieldRequired(h.a.a.p.a(h.a.a.a.name)));
        } else if (userAccountInfo.getEmail() == null || userAccountInfo.getEmail().equals("")) {
            updateUserRequestListener.onError(DataModels.Error.fieldRequired(h.a.a.p.a(h.a.a.a.email)));
        } else if (userAccountInfo.getPhonenumber() == null || userAccountInfo.getPhonenumber().equals("")) {
            updateUserRequestListener.onError(DataModels.Error.fieldRequired(h.a.a.p.a(h.a.a.a.phonenumber)));
        } else if (this.o == null) {
            updateUserRequestListener.onError(DataModels.Error.loginRequired());
        } else {
            h.a.a.n.a().a(userAccountInfo).subscribeOn(d.c.j0.a.b()).observeOn(d.c.b0.b.a.a()).subscribe(new c0(userAccountInfo, updateUserRequestListener), new c(this, updateUserRequestListener));
        }
    }

    public void a(String str, String str2, String str3, BackendListeners.DefaultRequestListener defaultRequestListener) {
        if (str == null || str.equals("")) {
            defaultRequestListener.onError(DataModels.Error.fieldRequired(h.a.a.p.a(h.a.a.a.email)));
        } else if (str2 == null || str2.equals("")) {
            defaultRequestListener.onError(DataModels.Error.fieldRequired(h.a.a.p.a(h.a.a.a.currentpassword)));
        } else if (str3 == null || str3.equals("")) {
            defaultRequestListener.onError(DataModels.Error.fieldRequired(h.a.a.p.a(h.a.a.a.newpassword)));
        } else {
            h.a.a.n.a().a(str, str2, str3).subscribeOn(d.c.j0.a.b()).observeOn(d.c.b0.b.a.a()).subscribe(new f(this, defaultRequestListener), new i(this, defaultRequestListener));
        }
    }

    public void a(BackendListeners.InitialConfigurationRequestListener initialConfigurationRequestListener) {
        h.a.a.n.a().e().subscribeOn(d.c.j0.a.b()).observeOn(d.c.b0.b.a.a()).subscribe(new j(initialConfigurationRequestListener), new o(this, initialConfigurationRequestListener));
    }

    public void a(BackendListeners.HasOngoingStageListener hasOngoingStageListener) {
        h.a.a.c.a("LOGIC_BEACONS", "Consuela", "hasOngoingStage", "entered method");
        if (this.o == null) {
            hasOngoingStageListener.onError(DataModels.Error.loginRequired());
            h.a.a.c.a("LOGIC_BEACONS", "Consuela", "hasOngoingStage", "ERROR: " + DataModels.Error.loginRequired().getType().toString());
        } else if (!this.p) {
            hasOngoingStageListener.onError(DataModels.Error.initFailedDataSuspect());
            h.a.a.c.a("LOGIC_BEACONS", "Consuela", "hasOngoingStage", "ERROR: " + DataModels.Error.initFailedDataSuspect().getType().toString());
        } else {
            h.a.a.n.a().o(this.o.getEmail()).subscribeOn(d.c.j0.a.b()).observeOn(d.c.b0.b.a.a()).subscribe(new r(this, hasOngoingStageListener), new u(this, hasOngoingStageListener));
        }
    }

    public void a(BackendListeners.b bVar) {
        h.a.a.c.a("LOGIC_BEACONS", "Consuela", "hasOngoingStage", "entered method");
        if (this.o == null) {
            bVar.onError(DataModels.Error.loginRequired());
            h.a.a.c.a("LOGIC_BEACONS", "Consuela", "hasOngoingStage", "ERROR: " + DataModels.Error.loginRequired().getType().toString());
            return;
        }
        h.a.a.n.a().m(this.o.getEmail()).subscribeOn(d.c.j0.a.b()).observeOn(d.c.b0.b.a.a()).subscribe(new x(this, bVar), new a0(this, bVar));
    }

    public d.c.b a(DataModels.p pVar, BackendListeners.k kVar) {
        return a(pVar, kVar, false);
    }

    public d.c.b a(DataModels.p pVar, BackendListeners.k kVar, boolean z2) {
        return new g0(z2, pVar, kVar);
    }

    public void a(BackendListeners.i iVar) {
        h.a.a.c.a("LOGIC_BEACONS", "Consuela", "hasOngoingStage", "entered method");
        if (this.o == null) {
            iVar.onError(DataModels.Error.loginRequired());
            h.a.a.c.a("LOGIC_BEACONS", "Consuela", "hasOngoingStage", "ERROR: " + DataModels.Error.loginRequired().getType().toString());
            return;
        }
        h.a.a.n.a().q(this.o.getEmail()).subscribeOn(d.c.j0.a.b()).observeOn(d.c.b0.b.a.a()).subscribe(new j0(this, iVar), new l0(this, iVar));
    }

    public void a(Collection<DataModels.b> collection, BackendListeners.p pVar) {
        if (this.o == null) {
            pVar.onError(DataModels.Error.loginRequired());
            h.a.a.c.a("LOGIC_BEACONS", "Consuela", "hasOngoingStage", "ERROR: " + DataModels.Error.loginRequired().getType().toString());
            return;
        }
        h.a.a.n.a().a(String.valueOf(this.o.getId()), (List<DataModels.b>) new ArrayList(collection), true, this.o.getEmail()).subscribeOn(d.c.j0.a.b()).observeOn(d.c.b0.b.a.a()).subscribe(new n0(pVar), new o0(collection, pVar));
    }

    public void a(List<DataModels.b> list, BackendListeners.n nVar) {
        if (this.o == null) {
            nVar.onError(DataModels.Error.loginRequired());
            h.a.a.c.a("LOGIC_BEACONS", "Consuela", "stageUpdate", "ERROR: " + DataModels.Error.loginRequired().getType().toString());
        } else if (h.a.a.j.d().g() == null) {
            h.a.a.c.a("LOGIC_BEACONS", "Consuela", "stageUpdate", "ERROR: stage state is null!");
        } else {
            h.a.a.n.a().a(h.a.a.j.d().g().l(), this.o.getId(), new ArrayList(list), h.a.a.j.d().g().n().booleanValue(), h.a.a.j.d().g().m(), h.a.a.j.d().g().p(), this.o.getEmail()).subscribeOn(d.c.j0.a.b()).observeOn(d.c.b0.b.a.a()).subscribe(new r0(this, nVar), new t0(this, nVar));
        }
    }

    public void a(String str, String str2, List<DataModels.b> list, BackendListeners.n nVar) {
        if (this.o == null) {
            nVar.onError(DataModels.Error.loginRequired());
            h.a.a.c.a("LOGIC_BEACONS", "Consuela", "stageFinish", "ERROR: " + DataModels.Error.loginRequired().getType().toString());
        } else if (h.a.a.j.d().g() == null) {
            h.a.a.c.a("LOGIC_BEACONS", "Consuela", "stageFinish", "ERROR: stage state is null!");
        } else {
            a(this.o.getId(), h.a.a.j.d().g().l(), h.a.a.j.d().g().n(), h.a.a.j.d().g().m());
            h.a.a.n.a().a(str, this.o.getId(), str2, new ArrayList(list), h.a.a.j.d().g().n().booleanValue(), h.a.a.j.d().g().m(), h.a.a.j.d().g().p(), this.o.getEmail()).subscribeOn(d.c.j0.a.b()).observeOn(d.c.b0.b.a.a()).subscribe(new v0(this, nVar), new x0(this, nVar));
        }
    }

    public void a(BackendListeners.GetSavedUserRequestListener getSavedUserRequestListener) {
        h.a.a.c.a("LOGIC_USER", "Consuela", "verifyAndGetUser", "entered method");
        if (!this.p) {
            getSavedUserRequestListener.onError(DataModels.Error.initFailedDataSuspect());
            h.a.a.c.a("LOGIC_BEACONS", "Consuela", "verifyAndGetUser", "ERROR: " + DataModels.Error.initFailedDataSuspect().getMessage());
            return;
        }
        h.a.a.n.a().b().subscribeOn(d.c.j0.a.b()).observeOn(d.c.b0.b.a.a()).subscribe(new z0(getSavedUserRequestListener), new b1(this, getSavedUserRequestListener));
    }

    public void a(Date date, BackendListeners.HistoricInfoRequestListener historicInfoRequestListener) {
        if (date == null) {
            historicInfoRequestListener.onError(DataModels.Error.fieldRequired(h.a.a.p.a(h.a.a.a.month)));
        } else if (this.o == null) {
            historicInfoRequestListener.onError(DataModels.Error.loginRequired());
        } else {
            h.a.a.n.a().b(this.o.getEmail(), date).subscribeOn(d.c.j0.a.b()).observeOn(d.c.b0.b.a.a()).subscribe(new d1(this, historicInfoRequestListener), new f1(this, historicInfoRequestListener));
        }
    }

    public void a(Date date, BackendListeners.TariffInfoRequestListener tariffInfoRequestListener) {
        if (date == null) {
            tariffInfoRequestListener.onError(DataModels.Error.fieldRequired(h.a.a.p.a(h.a.a.a.month)));
        } else if (this.o == null) {
            tariffInfoRequestListener.onError(DataModels.Error.loginRequired());
        } else {
            h.a.a.n.a().c(this.o.getEmail(), date).subscribeOn(d.c.j0.a.b()).observeOn(d.c.b0.b.a.a()).subscribe(new g1(date, tariffInfoRequestListener), new j1(this, tariffInfoRequestListener));
        }
    }

    public void a(BackendListeners.PaymentMethodsRequestListener paymentMethodsRequestListener) {
        if (this.o == null) {
            paymentMethodsRequestListener.onError(DataModels.Error.loginRequired());
        } else {
            h.a.a.n.a().l(this.o.getEmail()).subscribeOn(d.c.j0.a.b()).observeOn(d.c.b0.b.a.a()).subscribe(new a(this, paymentMethodsRequestListener), new d(this, paymentMethodsRequestListener));
        }
    }

    public void a(DataModels.PaymentMethod paymentMethod, BackendListeners.SelectPaymentMethodRequestListener selectPaymentMethodRequestListener) {
        if (this.o == null) {
            selectPaymentMethodRequestListener.onError(DataModels.Error.loginRequired());
        } else if (paymentMethod == null) {
            selectPaymentMethodRequestListener.onError(DataModels.Error.missingData());
        } else if (paymentMethod.getMode() != null && paymentMethod.getMode().toUpperCase().equals("WEB_PAGE_REGIST")) {
            h.a.a.c.a("LOGIC_BEACONS", "Consuela", "selectPaymentMethod", paymentMethod.getMode() + ";" + paymentMethod.getCode());
            DataModels.PaymentInfo paymentInfo = new DataModels.PaymentInfo();
            paymentInfo.setProcedureURL(paymentMethod.getUrl());
            selectPaymentMethodRequestListener.onSuccess(DataModels.PaymentAction.URL, paymentInfo);
        } else if (paymentMethod.getMode() != null && paymentMethod.getMode().toUpperCase().equals("APP_REGIST")) {
            h.a.a.c.a("LOGIC_BEACONS", "Consuela", "selectPaymentMethod", paymentMethod.getMode() + ";" + paymentMethod.getCode());
            h.a.a.n.a().d(this.o.getEmail(), paymentMethod.getCode()).subscribeOn(d.c.j0.a.b()).observeOn(d.c.b0.b.a.a()).subscribe(new g(this, selectPaymentMethodRequestListener), new k(this, selectPaymentMethodRequestListener));
        } else {
            h.a.a.c.a("LOGIC_BEACONS", "Consuela", "selectPaymentMethod", "Payment method not recognized");
            selectPaymentMethodRequestListener.onError(DataModels.Error.paymentMethodNotRecognized());
        }
    }

    public void a(String str, BackendListeners.SendInvoiceEmailListener sendInvoiceEmailListener) {
        if (this.o == null) {
            sendInvoiceEmailListener.onError(DataModels.Error.loginRequired());
        } else {
            h.a.a.n.a().c(str, this.o.getEmail()).subscribeOn(d.c.j0.a.b()).observeOn(d.c.b0.b.a.a()).subscribe(new s(this, sendInvoiceEmailListener), new v(this, sendInvoiceEmailListener));
        }
    }

    public void a(BackendListeners.StageStopListener stageStopListener) {
        if (stageStopListener != null) {
            h.a.a.j.d().b(stageStopListener);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public d.c.b a(String str) {
        return new y(str);
    }

    public void a(int i2, BackendListeners.ScheduleStageStartListener scheduleStageStartListener) {
        if (this.o == null) {
            scheduleStageStartListener.onError(DataModels.Error.loginRequired());
            h.a.a.c.a("LOGIC_BEACONS", "Consuela", "scheduleStageStart", "ERROR: " + DataModels.Error.loginRequired().getType().toString());
            return;
        }
        h.a.a.j.d().a(i2, scheduleStageStartListener);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public d.c.b a() {
        return new b0();
    }

    public void a(BackendListeners.EnableHCEValidationsListener enableHCEValidationsListener) {
        h.a.a.c.a("LOGIC_BEACONS", "Consuela", "appEnableHCEValidations", "App requested to enable the validations");
        this.q = true;
        if (this.o != null && w() != null) {
            a(new f0(enableHCEValidationsListener));
        } else {
            b(enableHCEValidationsListener).subscribeOn(d.c.j0.a.b()).observeOn(d.c.b0.b.a.a()).subscribe();
        }
    }

    public void a(BackendListeners.DisableHCEValidationsListener disableHCEValidationsListener) {
        h.a.a.c.a("LOGIC_BEACONS", "Consuela", "appDisableHCEValidations", "App requested to disable the validations");
        this.q = false;
        b(disableHCEValidationsListener).subscribeOn(d.c.j0.a.b()).observeOn(d.c.b0.b.a.a()).subscribe();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public d.c.b a(BackendListeners.EnableHCEValidationsListener enableHCEValidationsListener, boolean z2, DataModels.Error error) {
        return new h0(z2, enableHCEValidationsListener, error);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public d.c.b a(BackendListeners.DisableHCEValidationsListener disableHCEValidationsListener, boolean z2) {
        return new i0(z2, disableHCEValidationsListener);
    }

    public void a(BackendListeners.f fVar) {
        if (this.o == null) {
            if (fVar != null) {
                fVar.onError(DataModels.Error.loginRequired());
                return;
            }
            return;
        }
        String j2 = h.a.a.v.d().j();
        if (j2 != null && !j2.equals("")) {
            String id = this.o.getId();
            h.a.a.b.a().a(new k0(this));
            h.a.a.n.a().b(id, this.o.getEmail()).subscribeOn(d.c.j0.a.b()).observeOn(d.c.b0.b.a.a()).subscribe(new m0(id, fVar), new p0(this, fVar));
            return;
        }
        if (h.a.a.j.d().h() != null) {
            h.a.a.j.d().h().onLogoutRequired();
        }
        if (fVar != null) {
            fVar.onError(DataModels.Error.loginRequired());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(long j2) {
        j().postDelayed(this.y, j2);
    }

    public void a(String str, String str2) {
        h.a.a.c.a(str, str2);
    }

    public void a(BackendListeners.GetLogListener getLogListener) {
        h.a.a.c.f().subscribeOn(d.c.j0.a.b()).observeOn(d.c.b0.b.a.a()).subscribe(new q0(this, getLogListener));
    }

    public void a(boolean z2, DataModels.Service service) {
        if (h.a.a.j.d().h() != null) {
            if (z2) {
                h.a.a.j.d().h().onServiceEnabled(service);
            } else {
                h.a.a.j.d().h().onServiceDisabled(service);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, String str2, Boolean bool, Date date) {
        if (str != null) {
            try {
                if (str.equals("")) {
                    return;
                }
                BatteryManager batteryManager = (BatteryManager) App.getContext().getSystemService("batterymanager");
                int intProperty = batteryManager != null ? batteryManager.getIntProperty(4) : -1;
                if (intProperty != -1) {
                    h.a.a.v.d().a(new DataModels.h(str, str2, bool, date, DataModels.h.l, h.a.a.w.d().e(), Integer.toString(intProperty), null));
                }
            } catch (Throwable th) {
                h.a.a.c.a("LOGIC_OTHER", "BeaconManager", "sendBatteryLevelEvent", Log.getStackTraceString(th));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, String str2, String str3) {
        try {
            h.a.a.v.d().a(new DataModels.h(str, null, Boolean.FALSE, null, DataModels.h.m, h.a.a.w.d().e(), str2, str3));
        } catch (Throwable th) {
            h.a.a.c.a("LOGIC_OTHER", "BeaconManager", "sendBatteryLevelEvent", Log.getStackTraceString(th));
        }
    }

    public void a(BackendListeners.GetUserAccountListener getUserAccountListener) {
        if (this.o != null) {
            h.a.a.n.a().n(this.o.getEmail()).subscribeOn(d.c.j0.a.b()).observeOn(d.c.b0.b.a.a()).subscribe(new s0(getUserAccountListener), new u0(this, getUserAccountListener));
        } else if (getUserAccountListener != null) {
            getUserAccountListener.onError(DataModels.Error.loginRequired());
        }
    }

    public void a(BackendListeners.GetTermsAndConditionsListener getTermsAndConditionsListener) {
        Map<String, DataModels.f> map = this.f6544h;
        if (map != null) {
            if (map.containsKey("TERMS_AND_CONDITIONS_" + h.a.a.p.g())) {
                Map<String, DataModels.f> map2 = this.f6544h;
                getTermsAndConditionsListener.onSuccess(map2.get("TERMS_AND_CONDITIONS_" + h.a.a.p.g()).a().trim());
                return;
            }
        }
        Map<String, DataModels.f> map3 = this.f6544h;
        if (map3 != null && map3.containsKey(h.a.a.p.a(h.a.a.a.termsandconditionsconfig))) {
            getTermsAndConditionsListener.onSuccess(this.f6544h.get(h.a.a.p.a(h.a.a.a.termsandconditionsconfig)).a().trim());
        } else {
            getTermsAndConditionsListener.onError(DataModels.Error.missingData());
        }
    }

    public void a(BackendListeners.GetFAQsListener getFAQsListener) {
        Map<String, DataModels.f> map = this.f6544h;
        if (map != null && map.containsKey("FAQS")) {
            getFAQsListener.onSuccess(this.f6544h.get("FAQS").a().trim());
        } else {
            getFAQsListener.onError(DataModels.Error.missingData());
        }
    }

    public void a(BackendListeners.GetCountriesListener getCountriesListener) {
        if (getCountriesListener != null) {
            getCountriesListener.onSuccess(new ArrayList(h().values()));
        }
    }

    public void a(BackendListeners.GetLanguagesListener getLanguagesListener) {
        if (getLanguagesListener != null) {
            getLanguagesListener.onSuccess(new ArrayList(l().values()));
        }
    }

    public void a(String str, BackendListeners.SendReportListener sendReportListener) {
        try {
            h.a.a.c.a(str).subscribeOn(d.c.j0.a.b()).observeOn(d.c.b0.b.a.a()).subscribe(new e(str, sendReportListener), new h(this, sendReportListener));
        } catch (Throwable th) {
            h.a.a.c.a("LOGIC_USER", "Consuela", "sendLogReport", Log.getStackTraceString(th));
            if (sendReportListener != null) {
                sendReportListener.onError(DataModels.Error.failed_to_send_report());
            }
        }
    }

    public void a(Boolean bool, BackendListeners.SyncConfigurationDataRequestListener syncConfigurationDataRequestListener) {
        h.a.a.n.a().a(Boolean.TRUE, bool).subscribeOn(d.c.j0.a.b()).observeOn(d.c.b0.b.a.a()).subscribe(new C0141l(this, syncConfigurationDataRequestListener), new n(this, syncConfigurationDataRequestListener));
    }

    public void a(BackendListeners.GetCardInfoListener getCardInfoListener) {
        try {
            if (h.a.a.b.a().b()) {
                h.a.a.b.a().a(new q(this, getCardInfoListener));
            } else if (getCardInfoListener != null) {
                getCardInfoListener.onError(DataModels.Error.card_not_enrolled());
            }
        } catch (Throwable th) {
            h.a.a.c.a("LOGIC_HCE", "Consuela", "getCardInfo", Log.getStackTraceString(th));
            if (getCardInfoListener != null) {
                getCardInfoListener.onError(DataModels.Error.internal("Exception"));
            }
        }
    }
}
