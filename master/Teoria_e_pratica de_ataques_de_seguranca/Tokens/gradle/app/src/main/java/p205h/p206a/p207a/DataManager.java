package p205h.p206a.p207a;

import android.os.Build;
import android.os.SystemClock;
import android.util.Log;
import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.TimeZone;
import java.util.UUID;
import p070c.p084d.p105b.Gson;
import p070c.p084d.p105b.GsonBuilder;
import p070c.p084d.p105b.p111w.TypeToken;
import p136d.p153c.Single;
import p136d.p153c.SingleObserver;
import p136d.p153c.p159e0.Consumer;
import p136d.p153c.p159e0.Function4;
import p136d.p153c.p159e0.Function8;
import p136d.p153c.p179j0.Schedulers;
import pt.card4b.backendbeacons.BackEndExceptions$PhoneStatePermissionException;
import pt.card4b.backendbeacons.BackendListeners;
import pt.card4b.backendbeacons.DataModelDBOs$TableBeaconInformationType;
import pt.card4b.backendbeacons.DataModelDBOs$TableConfiguration;
import pt.card4b.backendbeacons.DataModelDBOs$TableCountry;
import pt.card4b.backendbeacons.DataModelDBOs$TableCustomerProfile;
import pt.card4b.backendbeacons.DataModelDBOs$TableLanguage;
import pt.card4b.backendbeacons.DataModelDBOs$TableLine;
import pt.card4b.backendbeacons.DataModelDBOs$TableLineOrientation;
import pt.card4b.backendbeacons.DataModelDBOs$TableLineVariant;
import pt.card4b.backendbeacons.DataModelDBOs$TableOperator;
import pt.card4b.backendbeacons.DataModelDBOs$TableStop;
import pt.card4b.backendbeacons.DataModelDBOs$TableZone;
import pt.card4b.backendbeacons.DataModelDTOs$BeaconInformationTypeDTO;
import pt.card4b.backendbeacons.DataModelDTOs$ConfigurationDTO;
import pt.card4b.backendbeacons.DataModelDTOs$CountryDTO;
import pt.card4b.backendbeacons.DataModelDTOs$CustomerAccountDTO;
import pt.card4b.backendbeacons.DataModelDTOs$CustomerProfileDTO;
import pt.card4b.backendbeacons.DataModelDTOs$IntermodalZoneDTO;
import pt.card4b.backendbeacons.DataModelDTOs$InvoiceDetailsDTO;
import pt.card4b.backendbeacons.DataModelDTOs$LanguageDTO;
import pt.card4b.backendbeacons.DataModelDTOs$LineDTO;
import pt.card4b.backendbeacons.DataModelDTOs$LineDirectionDTO;
import pt.card4b.backendbeacons.DataModelDTOs$LineVariantDTO;
import pt.card4b.backendbeacons.DataModelDTOs$PaymentMethodDTO;
import pt.card4b.backendbeacons.DataModelDTOs$StageDetailsDTO;
import pt.card4b.backendbeacons.DataModelDTOs$StageInformationBeaconDTO;
import pt.card4b.backendbeacons.DataModelDTOs$StageTariffsDTO;
import pt.card4b.backendbeacons.DataModelDTOs$StopDTO;
import pt.card4b.backendbeacons.DataModelDTOs$TransportOperatorDTO;
import pt.card4b.backendbeacons.DataModels;
import pt.card4b.backendbeacons.Database;
import pt.card4b.backendbeacons.ResponseDTOs$DeviceInstallResponseDTO;

/* renamed from: h.a.a.n */
/* loaded from: classes.dex */
public class DataManager {

    /* renamed from: m */
    public static volatile DataManager f9235m;

    /* renamed from: a */
    public final Object f9236a = new Object();

    /* renamed from: b */
    public final Object f9237b = new Object();

    /* renamed from: c */
    public final Object f9238c = new Object();

    /* renamed from: d */
    public final Object f9239d = new Object();

    /* renamed from: e */
    public final Object f9240e = new Object();

    /* renamed from: f */
    public final Object f9241f = new Object();

    /* renamed from: g */
    public final Object f9242g = new Object();

    /* renamed from: h */
    public final Object f9243h = new Object();

    /* renamed from: i */
    public final Object f9244i = new Object();

    /* renamed from: j */
    public final Object f9245j = new Object();

    /* renamed from: k */
    public final Object f9246k = new Object();

    /* renamed from: l */
    public final EnumC2207v0 f9247l = EnumC2207v0.DATABASE;

    /* compiled from: DataManager.java */
    /* renamed from: h.a.a.n$a */
    /* loaded from: classes.dex */
    public class C2122a extends Single<DataModels.User> {

        /* renamed from: a */
        public final /* synthetic */ String f9248a;

        /* renamed from: b */
        public final /* synthetic */ String f9249b;

        /* compiled from: DataManager.java */
        /* renamed from: h.a.a.n$a$a */
        /* loaded from: classes.dex */
        public class C2123a implements BackendListeners.InterfaceC2676d {

            /* renamed from: a */
            public final /* synthetic */ SingleObserver f9251a;

            /* compiled from: DataManager.java */
            /* renamed from: h.a.a.n$a$a$a */
            /* loaded from: classes.dex */
            public class C2124a implements Consumer<Object> {

                /* renamed from: a */
                public final /* synthetic */ DataModels.User f9253a;

                public C2124a(DataModels.User user) {
                    this.f9253a = user;
                }

                @Override // p136d.p153c.p159e0.Consumer
                public void accept(Object obj) {
                    SharedPrefsController.m1540d().m1527h(this.f9253a.getEmail());
                    C2123a.this.f9251a.mo3282b(this.f9253a);
                }
            }

            /* compiled from: DataManager.java */
            /* renamed from: h.a.a.n$a$a$b */
            /* loaded from: classes.dex */
            public class C2125b implements Consumer<Throwable> {
                public C2125b() {
                }

                @Override // p136d.p153c.p159e0.Consumer
                /* renamed from: a */
                public void accept(Throwable th) {
                    C2123a.this.f9251a.mo3283a(th);
                }
            }

            public C2123a(SingleObserver singleObserver) {
                this.f9251a = singleObserver;
            }

            @Override // pt.card4b.backendbeacons.BackendListeners.InterfaceC2676d
            /* renamed from: a */
            public void mo336a(DataModelDTOs$CustomerAccountDTO dataModelDTOs$CustomerAccountDTO) {
                try {
                    AppLog.m2158a("LOGIC_USER", "DataManager", "login:AsyncTask:doInBackground", "Customer is " + dataModelDTOs$CustomerAccountDTO.getName());
                    DataModels.User user = dataModelDTOs$CustomerAccountDTO.toUser();
                    DataManager.this.m1686a(user).subscribe(new C2124a(user), new C2125b());
                } catch (ClassCastException e) {
                    e.printStackTrace();
                    this.f9251a.mo3283a(new DataModels.C2698g(DataModels.Error.internal(e.getLocalizedMessage())));
                }
            }

            @Override // pt.card4b.backendbeacons.BackendListeners.BaseRequestListener
            public void onError(DataModels.Error error) {
                this.f9251a.mo3283a(new DataModels.C2698g(error));
            }
        }

        public C2122a(String str, String str2) {
            this.f9248a = str;
            this.f9249b = str2;
        }

        @Override // p136d.p153c.Single
        public void subscribeActual(SingleObserver<? super DataModels.User> singleObserver) {
            boolean z = SharedPrefsController.m1540d().m1534f() == null;
            String m1528h = SharedPrefsController.m1540d().m1528h();
            if (m1528h == null) {
                singleObserver.mo3283a(new DataModels.C2698g(DataModels.Error.missingRegistrationKey()));
            } else {
                BackendAPIController.m2049d().m2072a(this.f9248a, this.f9249b, GeneralUtils.m1588f(), m1528h, z, new C2123a(singleObserver));
            }
        }
    }

    /* compiled from: DataManager.java */
    /* renamed from: h.a.a.n$a0 */
    /* loaded from: classes.dex */
    public class C2126a0 extends Single<List<DataModels.PaymentMethod>> {

        /* renamed from: a */
        public final /* synthetic */ String f9256a;

        /* compiled from: DataManager.java */
        /* renamed from: h.a.a.n$a0$a */
        /* loaded from: classes.dex */
        public class C2127a implements BackendListeners.InterfaceC2680h<List<DataModelDTOs$PaymentMethodDTO>> {

            /* renamed from: a */
            public final /* synthetic */ SingleObserver f9257a;

            public C2127a(C2126a0 c2126a0, SingleObserver singleObserver) {
                this.f9257a = singleObserver;
            }

            @Override // pt.card4b.backendbeacons.BackendListeners.BaseRequestListener
            public void onError(DataModels.Error error) {
                this.f9257a.mo3283a(new DataModels.C2698g(error));
            }

            @Override // pt.card4b.backendbeacons.BackendListeners.InterfaceC2680h
            /* renamed from: onSuccess */
            public void mo334a(List<DataModelDTOs$PaymentMethodDTO> list) {
                ArrayList arrayList = new ArrayList();
                for (DataModelDTOs$PaymentMethodDTO dataModelDTOs$PaymentMethodDTO : list) {
                    arrayList.add(dataModelDTOs$PaymentMethodDTO.toPaymentMethod());
                }
                this.f9257a.mo3282b(arrayList);
            }
        }

        public C2126a0(DataManager dataManager, String str) {
            this.f9256a = str;
        }

        @Override // p136d.p153c.Single
        public void subscribeActual(SingleObserver<? super List<DataModels.PaymentMethod>> singleObserver) {
            BackendAPIController.m2049d().m2050c(this.f9256a, new C2127a(this, singleObserver));
        }
    }

    /* compiled from: DataManager.java */
    /* renamed from: h.a.a.n$b */
    /* loaded from: classes.dex */
    public class C2128b extends Single<Object> {

        /* renamed from: a */
        public final /* synthetic */ String f9258a;

        /* compiled from: DataManager.java */
        /* renamed from: h.a.a.n$b$a */
        /* loaded from: classes.dex */
        public class C2129a extends TypeToken<ArrayList<DataModelDTOs$LineDirectionDTO>> {
            public C2129a(C2128b c2128b) {
            }
        }

        public C2128b(String str) {
            this.f9258a = str;
        }

        @Override // p136d.p153c.Single
        public void subscribeActual(SingleObserver<? super Object> singleObserver) {
            GsonBuilder gsonBuilder = new GsonBuilder();
            gsonBuilder.m4916a("yyyy-MM-dd'T'hh:mm:ss");
            Gson m4917a = gsonBuilder.m4917a();
            String str = this.f9258a;
            if (str == null) {
                str = "[]";
            }
            List list = (List) m4917a.m4927a(str, new C2129a(this).getType());
            Consuela.m1790k().m1786m().clear();
            if (C2158j0.f9318a[DataManager.this.f9247l.ordinal()] != 1) {
                return;
            }
            DataManager.this.m1650e(list, singleObserver);
        }
    }

    /* compiled from: DataManager.java */
    /* renamed from: h.a.a.n$b0 */
    /* loaded from: classes.dex */
    public class RunnableC2130b0 implements Runnable {

        /* renamed from: a */
        public final /* synthetic */ List f9260a;

        public RunnableC2130b0(List list) {
            this.f9260a = list;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                ArrayList arrayList = new ArrayList();
                for (DataModelDTOs$CountryDTO dataModelDTOs$CountryDTO : this.f9260a) {
                    arrayList.add(new DataModelDBOs$TableCountry(dataModelDTOs$CountryDTO));
                }
                synchronized (DataManager.this.f9245j) {
                    Database.m66r().m89c(arrayList);
                }
                SharedPrefsController.m1540d().m1538d(true);
                AppLog.m2158a("LOGIC_OTHER", "DataManager", "countriesDatabase", "Saved countries to database!");
            } catch (Throwable th) {
                AppLog.m2158a("LOGIC_OTHER", "DataManager", "countriesDatabase", "Error saving countries:" + Log.getStackTraceString(th));
            }
        }
    }

    /* compiled from: DataManager.java */
    /* renamed from: h.a.a.n$c */
    /* loaded from: classes.dex */
    public class C2131c extends Single<Object> {

        /* compiled from: DataManager.java */
        /* renamed from: h.a.a.n$c$a */
        /* loaded from: classes.dex */
        public class C2132a implements BackendListeners.InterfaceC2680h<ResponseDTOs$DeviceInstallResponseDTO> {

            /* renamed from: a */
            public final /* synthetic */ SingleObserver f9262a;

            public C2132a(C2131c c2131c, SingleObserver singleObserver) {
                this.f9262a = singleObserver;
            }

            @Override // pt.card4b.backendbeacons.BackendListeners.BaseRequestListener
            public void onError(DataModels.Error error) {
                this.f9262a.mo3283a(new DataModels.C2698g(error));
            }

            @Override // pt.card4b.backendbeacons.BackendListeners.InterfaceC2680h
            /* renamed from: a  reason: avoid collision after fix types in other method */
            public void mo334a(ResponseDTOs$DeviceInstallResponseDTO responseDTOs$DeviceInstallResponseDTO) {
                SharedPrefsController.m1540d().m1524i(responseDTOs$DeviceInstallResponseDTO.RegistrationKey);
                this.f9262a.mo3282b(DataModels.EMPTY_OBJECT);
            }
        }

        public C2131c(DataManager dataManager) {
        }

        @Override // p136d.p153c.Single
        public void subscribeActual(SingleObserver<? super Object> singleObserver) {
            String m1595b;
            String str;
            try {
                if (!(SharedPrefsController.m1540d().m1528h() != null)) {
                    if (Build.VERSION.SDK_INT >= 29) {
                        str = GeneralUtils.m1604a();
                        m1595b = null;
                    } else {
                        m1595b = GeneralUtils.m1595b();
                        str = null;
                    }
                    BackendAPIController.m2049d().m2074a(GeneralUtils.m1586h(), m1595b, str, GeneralUtils.m1590d(), GeneralUtils.m1588f(), new C2132a(this, singleObserver));
                    return;
                }
                singleObserver.mo3282b(DataModels.EMPTY_OBJECT);
            } catch (Throwable th) {
                if (th instanceof BackEndExceptions$PhoneStatePermissionException) {
                    singleObserver.mo3283a(new DataModels.C2698g(DataModels.Error.phonestatePermission()));
                } else {
                    singleObserver.mo3283a(new DataModels.C2698g(DataModels.Error.internal("Failed to verify/install the device (verifyAndInstallDevice)")));
                }
            }
        }
    }

    /* compiled from: DataManager.java */
    /* renamed from: h.a.a.n$c0 */
    /* loaded from: classes.dex */
    public class C2133c0 extends Single<DataModels.C2696e> {

        /* renamed from: a */
        public final /* synthetic */ String f9263a;

        /* renamed from: b */
        public final /* synthetic */ String f9264b;

        /* compiled from: DataManager.java */
        /* renamed from: h.a.a.n$c0$a */
        /* loaded from: classes.dex */
        public class C2134a implements BackendListeners.InterfaceC2679g {

            /* renamed from: a */
            public final /* synthetic */ SingleObserver f9265a;

            public C2134a(C2133c0 c2133c0, SingleObserver singleObserver) {
                this.f9265a = singleObserver;
            }

            @Override // pt.card4b.backendbeacons.BackendListeners.InterfaceC2679g
            /* renamed from: a */
            public void mo335a(Date date, boolean z, Date date2, boolean z2, String str, String str2) {
                this.f9265a.mo3282b(new DataModels.C2696e(date, z, date2, z2, str, str2));
            }

            @Override // pt.card4b.backendbeacons.BackendListeners.BaseRequestListener
            public void onError(DataModels.Error error) {
                this.f9265a.mo3283a(new DataModels.C2698g(error));
            }
        }

        public C2133c0(DataManager dataManager, String str, String str2) {
            this.f9263a = str;
            this.f9264b = str2;
        }

        @Override // p136d.p153c.Single
        public void subscribeActual(SingleObserver<? super DataModels.C2696e> singleObserver) {
            String m1528h = SharedPrefsController.m1540d().m1528h();
            if (m1528h == null) {
                singleObserver.mo3283a(new DataModels.C2698g(DataModels.Error.missingRegistrationKey()));
            } else {
                BackendAPIController.m2049d().m2070a(this.f9263a, m1528h, this.f9264b, new C2134a(this, singleObserver));
            }
        }
    }

    /* compiled from: DataManager.java */
    /* renamed from: h.a.a.n$d */
    /* loaded from: classes.dex */
    public class C2135d extends Single<Object> {

        /* renamed from: a */
        public final /* synthetic */ String f9266a;

        /* compiled from: DataManager.java */
        /* renamed from: h.a.a.n$d$a */
        /* loaded from: classes.dex */
        public class C2136a extends TypeToken<ArrayList<DataModelDTOs$LineVariantDTO>> {
            public C2136a(C2135d c2135d) {
            }
        }

        public C2135d(String str) {
            this.f9266a = str;
        }

        @Override // p136d.p153c.Single
        public void subscribeActual(SingleObserver<? super Object> singleObserver) {
            GsonBuilder gsonBuilder = new GsonBuilder();
            gsonBuilder.m4916a("yyyy-MM-dd'T'hh:mm:ss");
            Gson m4917a = gsonBuilder.m4917a();
            String str = this.f9266a;
            if (str == null) {
                str = "[]";
            }
            List list = (List) m4917a.m4927a(str, new C2136a(this).getType());
            Consuela.m1790k().m1784n().clear();
            if (C2158j0.f9318a[DataManager.this.f9247l.ordinal()] != 1) {
                return;
            }
            DataManager.this.m1645f(list, singleObserver);
        }
    }

    /* compiled from: DataManager.java */
    /* renamed from: h.a.a.n$d0 */
    /* loaded from: classes.dex */
    public class RunnableC2137d0 implements Runnable {

        /* renamed from: a */
        public final /* synthetic */ List f9268a;

        public RunnableC2137d0(List list) {
            this.f9268a = list;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                ArrayList arrayList = new ArrayList();
                for (DataModelDTOs$LanguageDTO dataModelDTOs$LanguageDTO : this.f9268a) {
                    arrayList.add(new DataModelDBOs$TableLanguage(dataModelDTOs$LanguageDTO));
                }
                synchronized (DataManager.this.f9246k) {
                    Database.m66r().m85e(arrayList);
                }
                SharedPrefsController.m1540d().m1532f(true);
                AppLog.m2158a("LOGIC_OTHER", "DataManager", "languagesDatabase", "Saved languages to database!");
            } catch (Throwable th) {
                AppLog.m2158a("LOGIC_OTHER", "DataManager", "languagesDatabase", "Error saving languages:" + Log.getStackTraceString(th));
            }
        }
    }

    /* compiled from: DataManager.java */
    /* renamed from: h.a.a.n$e */
    /* loaded from: classes.dex */
    public class C2138e extends Single<DataModels.NewStageStartInfo> {

        /* renamed from: a */
        public final /* synthetic */ List f9270a;

        /* renamed from: b */
        public final /* synthetic */ boolean f9271b;

        /* renamed from: c */
        public final /* synthetic */ String f9272c;

        /* renamed from: d */
        public final /* synthetic */ String f9273d;

        /* compiled from: DataManager.java */
        /* renamed from: h.a.a.n$e$a */
        /* loaded from: classes.dex */
        public class C2139a implements BackendListeners.InterfaceC2680h<String> {

            /* renamed from: a */
            public final /* synthetic */ Date f9275a;

            /* renamed from: b */
            public final /* synthetic */ long f9276b;

            /* renamed from: c */
            public final /* synthetic */ SingleObserver f9277c;

            /* renamed from: d */
            public final /* synthetic */ int f9278d;

            public C2139a(Date date, long j, SingleObserver singleObserver, int i) {
                this.f9275a = date;
                this.f9276b = j;
                this.f9277c = singleObserver;
                this.f9278d = i;
            }

            @Override // pt.card4b.backendbeacons.BackendListeners.BaseRequestListener
            public void onError(DataModels.Error error) {
                this.f9277c.mo3283a(new DataModels.C2698g(error));
            }

            @Override // pt.card4b.backendbeacons.BackendListeners.InterfaceC2680h
            /* renamed from: onSuccess */
            public void mo334a(String str) {
                SysDateManager.m1497d().m1500a(this.f9275a, this.f9276b);
                SharedPrefsController.m1540d().m1536e(C2138e.this.f9272c);
                SharedPrefsController.m1540d().m1557a(Long.valueOf(GeneralUtils.m1598a(this.f9275a)));
                SharedPrefsController.m1540d().m1560E();
                if (!C2138e.this.f9271b) {
                    SharedPrefsController.m1540d().m1553a(C2138e.this.f9272c, new Date(GeneralUtils.m1598a(this.f9275a) + ((Consuela.m1790k().m1798g().containsKey("START_OFFLINE_RANGE_MINS") ? Integer.parseInt(Consuela.m1790k().m1798g().get("START_OFFLINE_RANGE_MINS").m187a()) : 720) * 60 * 1000)), null);
                } else {
                    AbstractMap.SimpleEntry<Date, String> m1545b = SharedPrefsController.m1540d().m1545b(C2138e.this.f9272c);
                    int parseInt = Consuela.m1790k().m1798g().containsKey("START_OFFLINE_EXTENSION_MINS") ? Integer.parseInt(Consuela.m1790k().m1798g().get("START_OFFLINE_EXTENSION_MINS").m187a()) : 60;
                    if (m1545b != null && m1545b.getKey().before(new Date(GeneralUtils.m1598a(this.f9275a) + (parseInt * 60 * 1000)))) {
                        SharedPrefsController.m1540d().m1555a(C2138e.this.f9272c, parseInt);
                    }
                }
                this.f9277c.mo3282b(new DataModels.NewStageStartInfo(str, this.f9275a, C2138e.this.f9271b, this.f9278d));
            }
        }

        public C2138e(List list, boolean z, String str, String str2) {
            this.f9270a = list;
            this.f9271b = z;
            this.f9272c = str;
            this.f9273d = str2;
        }

        @Override // p136d.p153c.Single
        public void subscribeActual(SingleObserver<? super DataModels.NewStageStartInfo> singleObserver) {
            String m1588f = GeneralUtils.m1588f();
            List<DataModelDTOs$StageInformationBeaconDTO> m1689a = DataManager.this.m1689a(this.f9270a);
            long j = 0;
            Date date = null;
            for (DataModels.C2692b c2692b : this.f9270a) {
                Iterator<DataModels.C2691a> it = c2692b.m244b().iterator();
                while (true) {
                    if (it.hasNext()) {
                        DataModels.C2691a next = it.next();
                        if (next.m259l() != null) {
                            date = next.m259l();
                            j = next.m258m();
                            continue;
                            break;
                        }
                    }
                }
                if (date != null) {
                    break;
                }
            }
            if (date == null) {
                Date m1495f = SysDateManager.m1497d().m1495f();
                j = SystemClock.elapsedRealtime();
                date = m1495f;
            }
            String uuid = this.f9271b ? UUID.randomUUID().toString() : null;
            int m1542c = SharedPrefsController.m1540d().m1542c(this.f9272c);
            DataModels.Error m1770w = Consuela.m1790k().m1770w();
            if (this.f9271b && m1770w != null) {
                AppLog.m2158a("LOGIC_BEACONS", "DataManager", "stageStart", "start stage offline not authorized");
                singleObserver.mo3283a(new DataModels.C2698g(m1770w));
                return;
            }
            BackendAPIController.m2049d().m2076a(uuid, this.f9272c, m1588f, GeneralUtils.m1593b(date), (String) null, m1689a, this.f9271b, m1542c, this.f9273d, new C2139a(date, j, singleObserver, m1542c));
        }
    }

    /* compiled from: DataManager.java */
    /* renamed from: h.a.a.n$e0 */
    /* loaded from: classes.dex */
    public class C2140e0 extends Single<Object> {

        /* renamed from: a */
        public final /* synthetic */ String f9280a;

        /* renamed from: b */
        public final /* synthetic */ String f9281b;

        /* compiled from: DataManager.java */
        /* renamed from: h.a.a.n$e0$a */
        /* loaded from: classes.dex */
        public class C2141a implements BackendListeners.InterfaceC2684l {

            /* renamed from: a */
            public final /* synthetic */ SingleObserver f9282a;

            public C2141a(C2140e0 c2140e0, SingleObserver singleObserver) {
                this.f9282a = singleObserver;
            }

            @Override // pt.card4b.backendbeacons.BackendListeners.BaseRequestListener
            public void onError(DataModels.Error error) {
                this.f9282a.mo3283a(new DataModels.C2698g(error));
            }

            @Override // pt.card4b.backendbeacons.BackendListeners.InterfaceC2684l
            public void onSuccess() {
                this.f9282a.mo3282b(DataModels.EMPTY_OBJECT);
            }
        }

        public C2140e0(DataManager dataManager, String str, String str2) {
            this.f9280a = str;
            this.f9281b = str2;
        }

        @Override // p136d.p153c.Single
        public void subscribeActual(SingleObserver<? super Object> singleObserver) {
            BackendAPIController.m2049d().m2068a(this.f9280a, this.f9281b, new C2141a(this, singleObserver));
        }
    }

    /* compiled from: DataManager.java */
    /* renamed from: h.a.a.n$f */
    /* loaded from: classes.dex */
    public class C2142f extends Single<Object> {

        /* renamed from: a */
        public final /* synthetic */ String f9283a;

        /* compiled from: DataManager.java */
        /* renamed from: h.a.a.n$f$a */
        /* loaded from: classes.dex */
        public class C2143a extends TypeToken<ArrayList<DataModelDTOs$BeaconInformationTypeDTO>> {
            public C2143a(C2142f c2142f) {
            }
        }

        public C2142f(String str) {
            this.f9283a = str;
        }

        @Override // p136d.p153c.Single
        public void subscribeActual(SingleObserver<? super Object> singleObserver) {
            GsonBuilder gsonBuilder = new GsonBuilder();
            gsonBuilder.m4916a("yyyy-MM-dd'T'hh:mm:ss");
            Gson m4917a = gsonBuilder.m4917a();
            String str = this.f9283a;
            if (str == null) {
                str = "[]";
            }
            List list = (List) m4917a.m4927a(str, new C2143a(this).getType());
            Consuela.m1790k().m1800f().clear();
            if (C2158j0.f9318a[DataManager.this.f9247l.ordinal()] != 1) {
                return;
            }
            DataManager.this.m1688a(list, singleObserver);
        }
    }

    /* compiled from: DataManager.java */
    /* renamed from: h.a.a.n$f0 */
    /* loaded from: classes.dex */
    public class RunnableC2144f0 implements Runnable {

        /* renamed from: a */
        public final /* synthetic */ List f9285a;

        public RunnableC2144f0(List list) {
            this.f9285a = list;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                synchronized (DataManager.this.f9240e) {
                    List<DataModelDBOs$TableConfiguration> m90c = Database.m66r().m90c();
                    HashMap hashMap = new HashMap();
                    for (DataModelDTOs$ConfigurationDTO dataModelDTOs$ConfigurationDTO : this.f9285a) {
                        DataModelDBOs$TableConfiguration dataModelDBOs$TableConfiguration = new DataModelDBOs$TableConfiguration(dataModelDTOs$ConfigurationDTO);
                        hashMap.put(dataModelDBOs$TableConfiguration.m325d(), dataModelDBOs$TableConfiguration);
                    }
                    for (DataModelDBOs$TableConfiguration dataModelDBOs$TableConfiguration2 : m90c) {
                        if (!hashMap.containsKey(dataModelDBOs$TableConfiguration2.m325d())) {
                            Database.m66r().m91b(dataModelDBOs$TableConfiguration2);
                        }
                    }
                    Database.m66r().m92b(new ArrayList(hashMap.values()));
                }
                SharedPrefsController.m1540d().m1541c(true);
                AppLog.m2158a("LOGIC_OTHER", "DataManager", "configurationsDatabase", "Saved configurations to database!");
            } catch (Throwable th) {
                AppLog.m2158a("LOGIC_OTHER", "DataManager", "configurationsDatabase", "Error saving configurations:" + Log.getStackTraceString(th));
                SharedPrefsController.m1540d().m1541c(false);
            }
        }
    }

    /* compiled from: DataManager.java */
    /* renamed from: h.a.a.n$g */
    /* loaded from: classes.dex */
    public class C2145g extends Single<Object> {

        /* renamed from: a */
        public final /* synthetic */ List f9287a;

        /* renamed from: b */
        public final /* synthetic */ String f9288b;

        /* renamed from: c */
        public final /* synthetic */ String f9289c;

        /* renamed from: d */
        public final /* synthetic */ Date f9290d;

        /* renamed from: e */
        public final /* synthetic */ boolean f9291e;

        /* renamed from: f */
        public final /* synthetic */ int f9292f;

        /* renamed from: g */
        public final /* synthetic */ String f9293g;

        /* compiled from: DataManager.java */
        /* renamed from: h.a.a.n$g$a */
        /* loaded from: classes.dex */
        public class C2146a implements BackendListeners.InterfaceC2687o {

            /* renamed from: a */
            public final /* synthetic */ SingleObserver f9295a;

            public C2146a(C2145g c2145g, SingleObserver singleObserver) {
                this.f9295a = singleObserver;
            }

            @Override // pt.card4b.backendbeacons.BackendListeners.BaseRequestListener
            public void onError(DataModels.Error error) {
                this.f9295a.mo3283a(new DataModels.C2698g(error));
            }

            @Override // pt.card4b.backendbeacons.BackendListeners.InterfaceC2687o
            public void onSuccess() {
                this.f9295a.mo3282b(DataModels.EMPTY_OBJECT);
            }
        }

        public C2145g(List list, String str, String str2, Date date, boolean z, int i, String str3) {
            this.f9287a = list;
            this.f9288b = str;
            this.f9289c = str2;
            this.f9290d = date;
            this.f9291e = z;
            this.f9292f = i;
            this.f9293g = str3;
        }

        @Override // p136d.p153c.Single
        public void subscribeActual(SingleObserver<? super Object> singleObserver) {
            AppLog.m2158a("LOGIC_BEACONS", "DataManager", "stageUpdate", "new beaconsDTO");
            List<DataModelDTOs$StageInformationBeaconDTO> m1689a = DataManager.this.m1689a(this.f9287a);
            BackendAPIController.m2049d().m2075a(this.f9288b, this.f9289c, GeneralUtils.m1588f(), GeneralUtils.m1593b(this.f9290d), (String) null, m1689a, this.f9291e, this.f9292f, this.f9293g, new C2146a(this, singleObserver));
        }
    }

    /* compiled from: DataManager.java */
    /* renamed from: h.a.a.n$g0 */
    /* loaded from: classes.dex */
    public class C2147g0 extends Single<DataModels.UserAccountInfo> {

        /* renamed from: a */
        public final /* synthetic */ String f9296a;

        /* compiled from: DataManager.java */
        /* renamed from: h.a.a.n$g0$a */
        /* loaded from: classes.dex */
        public class C2148a implements BackendListeners.InterfaceC2680h<DataModelDTOs$CustomerAccountDTO> {

            /* renamed from: a */
            public final /* synthetic */ SingleObserver f9297a;

            public C2148a(C2147g0 c2147g0, SingleObserver singleObserver) {
                this.f9297a = singleObserver;
            }

            @Override // pt.card4b.backendbeacons.BackendListeners.BaseRequestListener
            public void onError(DataModels.Error error) {
                this.f9297a.mo3283a(new DataModels.C2698g(error));
            }

            @Override // pt.card4b.backendbeacons.BackendListeners.InterfaceC2680h
            /* renamed from: a  reason: avoid collision after fix types in other method */
            public void mo334a(DataModelDTOs$CustomerAccountDTO dataModelDTOs$CustomerAccountDTO) {
                try {
                    this.f9297a.mo3282b(dataModelDTOs$CustomerAccountDTO.toAccountInfo());
                } catch (ClassCastException e) {
                    this.f9297a.mo3283a(new DataModels.C2698g(DataModels.Error.internal(e.getLocalizedMessage())));
                }
            }
        }

        public C2147g0(DataManager dataManager, String str) {
            this.f9296a = str;
        }

        @Override // p136d.p153c.Single
        public void subscribeActual(SingleObserver<? super DataModels.UserAccountInfo> singleObserver) {
            BackendAPIController.m2049d().m2055b(this.f9296a, new C2148a(this, singleObserver));
        }
    }

    /* compiled from: DataManager.java */
    /* renamed from: h.a.a.n$h */
    /* loaded from: classes.dex */
    public class C2149h extends Single<Object> {

        /* renamed from: a */
        public final /* synthetic */ String f9298a;

        /* compiled from: DataManager.java */
        /* renamed from: h.a.a.n$h$a */
        /* loaded from: classes.dex */
        public class C2150a extends TypeToken<ArrayList<DataModelDTOs$CountryDTO>> {
            public C2150a(C2149h c2149h) {
            }
        }

        public C2149h(String str) {
            this.f9298a = str;
        }

        @Override // p136d.p153c.Single
        public void subscribeActual(SingleObserver<? super Object> singleObserver) {
            GsonBuilder gsonBuilder = new GsonBuilder();
            gsonBuilder.m4916a("yyyy-MM-dd'T'hh:mm:ss");
            Gson m4917a = gsonBuilder.m4917a();
            String str = this.f9298a;
            if (str == null) {
                str = "[]";
            }
            List list = (List) m4917a.m4927a(str, new C2150a(this).getType());
            Consuela.m1790k().m1796h().clear();
            if (C2158j0.f9318a[DataManager.this.f9247l.ordinal()] != 1) {
                return;
            }
            DataManager.this.m1674b(list, singleObserver);
        }
    }

    /* compiled from: DataManager.java */
    /* renamed from: h.a.a.n$h0 */
    /* loaded from: classes.dex */
    public class RunnableC2151h0 implements Runnable {

        /* renamed from: a */
        public final /* synthetic */ List f9300a;

        public RunnableC2151h0(List list) {
            this.f9300a = list;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                ArrayList arrayList = new ArrayList();
                for (DataModelDTOs$CustomerProfileDTO dataModelDTOs$CustomerProfileDTO : this.f9300a) {
                    arrayList.add(new DataModelDBOs$TableCustomerProfile(dataModelDTOs$CustomerProfileDTO));
                }
                synchronized (DataManager.this.f9244i) {
                    Database.m66r().m87d(arrayList);
                }
                SharedPrefsController.m1540d().m1535e(true);
                AppLog.m2158a("LOGIC_OTHER", "DataManager", "customerProfilesDatabase", "Saved customer profiles to database!");
            } catch (Throwable th) {
                AppLog.m2158a("LOGIC_OTHER", "DataManager", "customerProfilesDatabase", "Error saving customer profiles:" + Log.getStackTraceString(th));
            }
        }
    }

    /* compiled from: DataManager.java */
    /* renamed from: h.a.a.n$i */
    /* loaded from: classes.dex */
    public class C2152i extends Single<Object> {

        /* renamed from: a */
        public final /* synthetic */ List f9302a;

        /* renamed from: b */
        public final /* synthetic */ String f9303b;

        /* renamed from: c */
        public final /* synthetic */ Date f9304c;

        /* renamed from: d */
        public final /* synthetic */ String f9305d;

        /* renamed from: e */
        public final /* synthetic */ String f9306e;

        /* renamed from: f */
        public final /* synthetic */ boolean f9307f;

        /* renamed from: g */
        public final /* synthetic */ int f9308g;

        /* renamed from: h */
        public final /* synthetic */ String f9309h;

        /* compiled from: DataManager.java */
        /* renamed from: h.a.a.n$i$a */
        /* loaded from: classes.dex */
        public class C2153a implements BackendListeners.InterfaceC2687o {

            /* renamed from: a */
            public final /* synthetic */ SingleObserver f9311a;

            public C2153a(SingleObserver singleObserver) {
                this.f9311a = singleObserver;
            }

            @Override // pt.card4b.backendbeacons.BackendListeners.BaseRequestListener
            public void onError(DataModels.Error error) {
                this.f9311a.mo3283a(new DataModels.C2698g(error));
            }

            @Override // pt.card4b.backendbeacons.BackendListeners.InterfaceC2687o
            public void onSuccess() {
                AppLog.m2143d(C2152i.this.f9305d);
                SharedPrefsController.m1540d().m1557a((Long) 0L);
                SharedPrefsController.m1540d().m1560E();
                SysDateManager.m1497d().m1501a();
                this.f9311a.mo3282b(DataModels.EMPTY_OBJECT);
            }
        }

        public C2152i(List list, String str, Date date, String str2, String str3, boolean z, int i, String str4) {
            this.f9302a = list;
            this.f9303b = str;
            this.f9304c = date;
            this.f9305d = str2;
            this.f9306e = str3;
            this.f9307f = z;
            this.f9308g = i;
            this.f9309h = str4;
        }

        @Override // p136d.p153c.Single
        public void subscribeActual(SingleObserver<? super Object> singleObserver) {
            List<DataModelDTOs$StageInformationBeaconDTO> m1689a = DataManager.this.m1689a(this.f9302a);
            String m1588f = GeneralUtils.m1588f();
            Date m1496e = SysDateManager.m1497d().m1496e();
            if (this.f9303b.equals(DataModels.C2706o.f10847p)) {
                Date date = new Date(SharedPrefsController.m1540d().m1537e().longValue());
                if (date.after(this.f9304c)) {
                    m1496e = date;
                }
            }
            BackendAPIController.m2049d().m2077a(this.f9305d, this.f9306e, this.f9303b, m1588f, GeneralUtils.m1593b(this.f9304c), GeneralUtils.m1593b(m1496e), m1689a, this.f9307f, this.f9308g, this.f9309h, new C2153a(singleObserver));
        }
    }

    /* compiled from: DataManager.java */
    /* renamed from: h.a.a.n$i0 */
    /* loaded from: classes.dex */
    public class C2154i0 extends Single<Object> {

        /* renamed from: a */
        public final /* synthetic */ String f9313a;

        /* renamed from: b */
        public final /* synthetic */ String f9314b;

        /* compiled from: DataManager.java */
        /* renamed from: h.a.a.n$i0$a */
        /* loaded from: classes.dex */
        public class C2155a implements BackendListeners.InterfaceC2685m {

            /* renamed from: a */
            public final /* synthetic */ SingleObserver f9315a;

            public C2155a(C2154i0 c2154i0, SingleObserver singleObserver) {
                this.f9315a = singleObserver;
            }

            @Override // pt.card4b.backendbeacons.BackendListeners.BaseRequestListener
            public void onError(DataModels.Error error) {
                this.f9315a.mo3283a(new DataModels.C2698g(error));
            }

            @Override // pt.card4b.backendbeacons.BackendListeners.InterfaceC2685m
            public void onSuccess() {
                this.f9315a.mo3282b(DataModels.EMPTY_OBJECT);
            }
        }

        public C2154i0(DataManager dataManager, String str, String str2) {
            this.f9313a = str;
            this.f9314b = str2;
        }

        @Override // p136d.p153c.Single
        public void subscribeActual(SingleObserver<? super Object> singleObserver) {
            BackendAPIController.m2049d().m2067a(this.f9313a, this.f9314b, new C2155a(this, singleObserver));
        }
    }

    /* compiled from: DataManager.java */
    /* renamed from: h.a.a.n$j */
    /* loaded from: classes.dex */
    public class C2156j extends Single<Object> {

        /* renamed from: a */
        public final /* synthetic */ String f9316a;

        /* compiled from: DataManager.java */
        /* renamed from: h.a.a.n$j$a */
        /* loaded from: classes.dex */
        public class C2157a extends TypeToken<ArrayList<DataModelDTOs$LanguageDTO>> {
            public C2157a(C2156j c2156j) {
            }
        }

        public C2156j(String str) {
            this.f9316a = str;
        }

        @Override // p136d.p153c.Single
        public void subscribeActual(SingleObserver<? super Object> singleObserver) {
            GsonBuilder gsonBuilder = new GsonBuilder();
            gsonBuilder.m4916a("yyyy-MM-dd'T'hh:mm:ss");
            Gson m4917a = gsonBuilder.m4917a();
            String str = this.f9316a;
            if (str == null) {
                str = "[]";
            }
            List list = (List) m4917a.m4927a(str, new C2157a(this).getType());
            Consuela.m1790k().m1788l().clear();
            if (C2158j0.f9318a[DataManager.this.f9247l.ordinal()] != 1) {
                return;
            }
            DataManager.this.m1656d(list, singleObserver);
        }
    }

    /* compiled from: DataManager.java */
    /* renamed from: h.a.a.n$j0 */
    /* loaded from: classes.dex */
    public static /* synthetic */ class C2158j0 {

        /* renamed from: a */
        public static final /* synthetic */ int[] f9318a;

        static {
            int[] iArr = new int[EnumC2207v0.values().length];
            f9318a = iArr;
            try {
                iArr[EnumC2207v0.DATABASE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
        }
    }

    /* compiled from: DataManager.java */
    /* renamed from: h.a.a.n$k */
    /* loaded from: classes.dex */
    public class RunnableC2159k implements Runnable {

        /* renamed from: a */
        public final /* synthetic */ List f9319a;

        public RunnableC2159k(List list) {
            this.f9319a = list;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                ArrayList arrayList = new ArrayList();
                for (DataModelDTOs$TransportOperatorDTO dataModelDTOs$TransportOperatorDTO : this.f9319a) {
                    arrayList.add(new DataModelDBOs$TableOperator(dataModelDTOs$TransportOperatorDTO));
                }
                synchronized (DataManager.this.f9236a) {
                    Database.m66r().m77i(arrayList);
                }
                SharedPrefsController.m1540d().m1520j(true);
                AppLog.m2158a("LOGIC_OTHER", "DataManager", "operatorsDatabase", "Saved operators to database!");
            } catch (Throwable th) {
                AppLog.m2158a("LOGIC_OTHER", "DataManager", "operatorsDatabase", "Error saving operators:" + Log.getStackTraceString(th));
            }
        }
    }

    /* compiled from: DataManager.java */
    /* renamed from: h.a.a.n$k0 */
    /* loaded from: classes.dex */
    public class C2160k0 extends Single<Object> {

        /* renamed from: a */
        public final /* synthetic */ String f9321a;

        /* compiled from: DataManager.java */
        /* renamed from: h.a.a.n$k0$a */
        /* loaded from: classes.dex */
        public class C2161a extends TypeToken<ArrayList<DataModelDTOs$TransportOperatorDTO>> {
            public C2161a(C2160k0 c2160k0) {
            }
        }

        public C2160k0(String str) {
            this.f9321a = str;
        }

        @Override // p136d.p153c.Single
        public void subscribeActual(SingleObserver<? super Object> singleObserver) {
            GsonBuilder gsonBuilder = new GsonBuilder();
            gsonBuilder.m4916a("yyyy-MM-dd'T'hh:mm:ss");
            Gson m4917a = gsonBuilder.m4917a();
            String str = this.f9321a;
            if (str == null) {
                str = "[]";
            }
            List list = (List) m4917a.m4927a(str, new C2161a(this).getType());
            Consuela.m1790k().m1776r().clear();
            Consuela.m1790k().m1778q().clear();
            if (C2158j0.f9318a[DataManager.this.f9247l.ordinal()] != 1) {
                return;
            }
            DataManager.this.m1635h(list, singleObserver);
        }
    }

    /* compiled from: DataManager.java */
    /* renamed from: h.a.a.n$l */
    /* loaded from: classes.dex */
    public class C2162l extends Single<DataModels.User> {
        public C2162l(DataManager dataManager) {
        }

        @Override // p136d.p153c.Single
        public void subscribeActual(SingleObserver<? super DataModels.User> singleObserver) {
            DataModels.User m1519k = SharedPrefsController.m1540d().m1519k();
            if (m1519k != null) {
                singleObserver.mo3282b(m1519k);
            } else {
                singleObserver.mo3283a(new DataModels.C2698g(DataModels.Error.internal("User session has expired!")));
            }
        }
    }

    /* compiled from: DataManager.java */
    /* renamed from: h.a.a.n$l0 */
    /* loaded from: classes.dex */
    public class C2163l0 extends Single<Object> {

        /* renamed from: a */
        public final /* synthetic */ String f9323a;

        /* compiled from: DataManager.java */
        /* renamed from: h.a.a.n$l0$a */
        /* loaded from: classes.dex */
        public class C2164a implements BackendListeners.InterfaceC2682j {

            /* renamed from: a */
            public final /* synthetic */ SingleObserver f9324a;

            public C2164a(C2163l0 c2163l0, SingleObserver singleObserver) {
                this.f9324a = singleObserver;
            }

            @Override // pt.card4b.backendbeacons.BackendListeners.BaseRequestListener
            public void onError(DataModels.Error error) {
                this.f9324a.mo3283a(new DataModels.C2698g(error));
            }

            @Override // pt.card4b.backendbeacons.BackendListeners.InterfaceC2682j
            public void onSuccess() {
                this.f9324a.mo3282b(DataModels.EMPTY_OBJECT);
            }
        }

        public C2163l0(DataManager dataManager, String str) {
            this.f9323a = str;
        }

        @Override // p136d.p153c.Single
        public void subscribeActual(SingleObserver<? super Object> singleObserver) {
            BackendAPIController.m2049d().m2063a(this.f9323a, new C2164a(this, singleObserver));
        }
    }

    /* compiled from: DataManager.java */
    /* renamed from: h.a.a.n$m */
    /* loaded from: classes.dex */
    public class RunnableC2165m implements Runnable {

        /* renamed from: a */
        public final /* synthetic */ List f9325a;

        public RunnableC2165m(List list) {
            this.f9325a = list;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                ArrayList arrayList = new ArrayList();
                for (DataModelDTOs$StopDTO dataModelDTOs$StopDTO : this.f9325a) {
                    arrayList.add(new DataModelDBOs$TableStop(dataModelDTOs$StopDTO));
                }
                synchronized (DataManager.this.f9237b) {
                    Database.m66r().m107C();
                    Database.m66r().m75j(arrayList);
                    Database.m66r().m109A();
                }
                SharedPrefsController.m1540d().m1518k(true);
                AppLog.m2158a("LOGIC_OTHER", "DataManager", "stopsDatabase", "Saved stops to database!");
            } catch (Throwable th) {
                AppLog.m2158a("LOGIC_OTHER", "DataManager", "stopsDatabase", "Error saving stops:" + Log.getStackTraceString(th));
            }
        }
    }

    /* compiled from: DataManager.java */
    /* renamed from: h.a.a.n$m0 */
    /* loaded from: classes.dex */
    public class C2166m0 extends Single<Object> {

        /* renamed from: a */
        public final /* synthetic */ String f9327a;

        /* compiled from: DataManager.java */
        /* renamed from: h.a.a.n$m0$a */
        /* loaded from: classes.dex */
        public class C2167a extends TypeToken<ArrayList<DataModelDTOs$StopDTO>> {
            public C2167a(C2166m0 c2166m0) {
            }
        }

        public C2166m0(String str) {
            this.f9327a = str;
        }

        @Override // p136d.p153c.Single
        public void subscribeActual(SingleObserver<? super Object> singleObserver) {
            GsonBuilder gsonBuilder = new GsonBuilder();
            gsonBuilder.m4916a("yyyy-MM-dd'T'hh:mm:ss");
            Gson m4917a = gsonBuilder.m4917a();
            String str = this.f9327a;
            if (str == null) {
                str = "[]";
            }
            List list = (List) m4917a.m4927a(str, new C2167a(this).getType());
            Consuela.m1790k().m1774s().clear();
            AppLog.m2158a("LOGIC_OTHER", "DataManager", "dealWithAPIStops", "apiStops.size = " + list.size());
            if (C2158j0.f9318a[DataManager.this.f9247l.ordinal()] != 1) {
                return;
            }
            DataManager.this.m1630i(list, singleObserver);
        }
    }

    /* compiled from: DataManager.java */
    /* renamed from: h.a.a.n$n */
    /* loaded from: classes.dex */
    public class C2168n extends Single<Boolean> {

        /* renamed from: a */
        public final /* synthetic */ String f9329a;

        public C2168n(DataManager dataManager, String str) {
            this.f9329a = str;
        }

        @Override // p136d.p153c.Single
        public void subscribeActual(SingleObserver<? super Boolean> singleObserver) {
            singleObserver.mo3282b(Boolean.valueOf(SharedPrefsController.m1540d().m1539d(this.f9329a)));
        }
    }

    /* compiled from: DataManager.java */
    /* renamed from: h.a.a.n$n0 */
    /* loaded from: classes.dex */
    public class C2169n0 extends Single<Boolean> {

        /* renamed from: a */
        public final /* synthetic */ DataModels.UserAccountInfo f9330a;

        /* compiled from: DataManager.java */
        /* renamed from: h.a.a.n$n0$a */
        /* loaded from: classes.dex */
        public class C2170a implements BackendListeners.InterfaceC2680h<Boolean> {

            /* renamed from: a */
            public final /* synthetic */ SingleObserver f9331a;

            public C2170a(C2169n0 c2169n0, SingleObserver singleObserver) {
                this.f9331a = singleObserver;
            }

            @Override // pt.card4b.backendbeacons.BackendListeners.BaseRequestListener
            public void onError(DataModels.Error error) {
                this.f9331a.mo3283a(new DataModels.C2698g(error));
            }

            @Override // pt.card4b.backendbeacons.BackendListeners.InterfaceC2680h
            /* renamed from: a  reason: avoid collision after fix types in other method */
            public void mo334a(Boolean bool) {
                this.f9331a.mo3282b(bool);
            }
        }

        public C2169n0(DataManager dataManager, DataModels.UserAccountInfo userAccountInfo) {
            this.f9330a = userAccountInfo;
        }

        @Override // p136d.p153c.Single
        public void subscribeActual(SingleObserver<? super Boolean> singleObserver) {
            BackendAPIController.m2049d().m2062a(this.f9330a.getEmail(), new DataModelDTOs$CustomerAccountDTO(this.f9330a), new C2170a(this, singleObserver));
        }
    }

    /* compiled from: DataManager.java */
    /* renamed from: h.a.a.n$o */
    /* loaded from: classes.dex */
    public class C2171o extends Single<Object> {

        /* renamed from: a */
        public final /* synthetic */ DataModels.UserAccountInfo f9332a;

        /* renamed from: b */
        public final /* synthetic */ String f9333b;

        /* compiled from: DataManager.java */
        /* renamed from: h.a.a.n$o$a */
        /* loaded from: classes.dex */
        public class C2172a implements BackendListeners.InterfaceC2680h<String> {

            /* renamed from: a */
            public final /* synthetic */ SingleObserver f9334a;

            public C2172a(C2171o c2171o, SingleObserver singleObserver) {
                this.f9334a = singleObserver;
            }

            @Override // pt.card4b.backendbeacons.BackendListeners.BaseRequestListener
            public void onError(DataModels.Error error) {
                this.f9334a.mo3283a(new DataModels.C2698g(error));
            }

            @Override // pt.card4b.backendbeacons.BackendListeners.InterfaceC2680h
            /* renamed from: onSuccess */
            public void mo334a(String str) {
                this.f9334a.mo3282b(DataModels.EMPTY_OBJECT);
            }
        }

        public C2171o(DataManager dataManager, DataModels.UserAccountInfo userAccountInfo, String str) {
            this.f9332a = userAccountInfo;
            this.f9333b = str;
        }

        @Override // p136d.p153c.Single
        public void subscribeActual(SingleObserver<? super Object> singleObserver) {
            BackendAPIController.m2049d().m2060a(new DataModelDTOs$CustomerAccountDTO(this.f9332a, this.f9333b), GeneralUtils.m1588f(), new C2172a(this, singleObserver));
        }
    }

    /* compiled from: DataManager.java */
    /* renamed from: h.a.a.n$o0 */
    /* loaded from: classes.dex */
    public class C2173o0 extends Single<Object> {

        /* renamed from: a */
        public final /* synthetic */ String f9335a;

        /* compiled from: DataManager.java */
        /* renamed from: h.a.a.n$o0$a */
        /* loaded from: classes.dex */
        public class C2174a extends TypeToken<ArrayList<DataModelDTOs$LineDTO>> {
            public C2174a(C2173o0 c2173o0) {
            }
        }

        public C2173o0(String str) {
            this.f9335a = str;
        }

        @Override // p136d.p153c.Single
        public void subscribeActual(SingleObserver<? super Object> singleObserver) {
            GsonBuilder gsonBuilder = new GsonBuilder();
            gsonBuilder.m4916a("yyyy-MM-dd'T'hh:mm:ss");
            Gson m4917a = gsonBuilder.m4917a();
            String str = this.f9335a;
            if (str == null) {
                str = "[]";
            }
            List list = (List) m4917a.m4927a(str, new C2174a(this).getType());
            Consuela.m1790k().m1782o().clear();
            if (C2158j0.f9318a[DataManager.this.f9247l.ordinal()] != 1) {
                return;
            }
            DataManager.this.m1640g(list, singleObserver);
        }
    }

    /* compiled from: DataManager.java */
    /* renamed from: h.a.a.n$p */
    /* loaded from: classes.dex */
    public class C2175p extends Single<Object> {

        /* renamed from: a */
        public final /* synthetic */ String f9337a;

        /* renamed from: b */
        public final /* synthetic */ DataModels.C2707p f9338b;

        public C2175p(DataManager dataManager, String str, DataModels.C2707p c2707p) {
            this.f9337a = str;
            this.f9338b = c2707p;
        }

        @Override // p136d.p153c.Single
        public void subscribeActual(SingleObserver<? super Object> singleObserver) {
            if (SharedPrefsController.m1540d().m1552a(this.f9337a, this.f9338b)) {
                singleObserver.mo3282b(DataModels.EMPTY_OBJECT);
            } else {
                singleObserver.mo3283a(new DataModels.C2698g(DataModels.Error.internal("failed to save stage state")));
            }
        }
    }

    /* compiled from: DataManager.java */
    /* renamed from: h.a.a.n$p0 */
    /* loaded from: classes.dex */
    public class C2176p0 extends Single<Object> {

        /* renamed from: a */
        public final /* synthetic */ String f9339a;

        /* renamed from: b */
        public final /* synthetic */ String f9340b;

        /* renamed from: c */
        public final /* synthetic */ String f9341c;

        /* compiled from: DataManager.java */
        /* renamed from: h.a.a.n$p0$a */
        /* loaded from: classes.dex */
        public class C2177a implements BackendListeners.DefaultRequestListener {

            /* renamed from: a */
            public final /* synthetic */ SingleObserver f9342a;

            public C2177a(C2176p0 c2176p0, SingleObserver singleObserver) {
                this.f9342a = singleObserver;
            }

            @Override // pt.card4b.backendbeacons.BackendListeners.DefaultRequestListener
            public void onError(DataModels.Error error) {
                this.f9342a.mo3283a(new DataModels.C2698g(error));
            }

            @Override // pt.card4b.backendbeacons.BackendListeners.DefaultRequestListener
            public void onSuccess() {
                this.f9342a.mo3282b(DataModels.EMPTY_OBJECT);
            }
        }

        public C2176p0(DataManager dataManager, String str, String str2, String str3) {
            this.f9339a = str;
            this.f9340b = str2;
            this.f9341c = str3;
        }

        @Override // p136d.p153c.Single
        public void subscribeActual(SingleObserver<? super Object> singleObserver) {
            BackendAPIController.m2049d().m2071a(this.f9339a, this.f9340b, this.f9341c, new C2177a(this, singleObserver));
        }
    }

    /* compiled from: DataManager.java */
    /* renamed from: h.a.a.n$q */
    /* loaded from: classes.dex */
    public class RunnableC2178q implements Runnable {

        /* renamed from: a */
        public final /* synthetic */ List f9343a;

        public RunnableC2178q(List list) {
            this.f9343a = list;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                ArrayList arrayList = new ArrayList();
                for (DataModelDTOs$LineDTO dataModelDTOs$LineDTO : this.f9343a) {
                    arrayList.add(new DataModelDBOs$TableLine(dataModelDTOs$LineDTO));
                }
                synchronized (DataManager.this.f9238c) {
                    Database.m66r().m108B();
                    Database.m66r().m83f(arrayList);
                    Database.m66r().m58z();
                }
                SharedPrefsController.m1540d().m1523i(true);
                AppLog.m2158a("LOGIC_OTHER", "DataManager", "linesDatabase", "Saved lines to database!");
            } catch (Throwable th) {
                AppLog.m2158a("LOGIC_OTHER", "DataManager", "linesDatabase", "Error saving lines:" + Log.getStackTraceString(th));
            }
        }
    }

    /* compiled from: DataManager.java */
    /* renamed from: h.a.a.n$q0 */
    /* loaded from: classes.dex */
    public class C2179q0 extends Single<Object> {

        /* renamed from: a */
        public final /* synthetic */ Boolean f9345a;

        /* renamed from: b */
        public final /* synthetic */ Boolean f9346b;

        /* compiled from: DataManager.java */
        /* renamed from: h.a.a.n$q0$a */
        /* loaded from: classes.dex */
        public class C2180a implements BackendListeners.InterfaceC2680h<Map<String, String>> {

            /* renamed from: a */
            public final /* synthetic */ SingleObserver f9348a;

            /* renamed from: b */
            public final /* synthetic */ Date f9349b;

            /* compiled from: DataManager.java */
            /* renamed from: h.a.a.n$q0$a$a */
            /* loaded from: classes.dex */
            public class C2181a implements Consumer<Object> {
                public C2181a() {
                }

                @Override // p136d.p153c.p159e0.Consumer
                public void accept(Object obj) {
                    AppLog.m2158a("LOGIC_BEACONS", "DataManager", "getApplicationData", "Application data from server loaded successfully");
                    SharedPrefsController.m1540d().m1551a(SysDateManager.m1497d().m1496e());
                    C2180a.this.f9348a.mo3282b(DataModels.EMPTY_OBJECT);
                }
            }

            /* compiled from: DataManager.java */
            /* renamed from: h.a.a.n$q0$a$b */
            /* loaded from: classes.dex */
            public class C2182b implements Consumer<Throwable> {

                /* compiled from: DataManager.java */
                /* renamed from: h.a.a.n$q0$a$b$a */
                /* loaded from: classes.dex */
                public class C2183a implements Consumer<Object> {
                    public C2183a() {
                    }

                    @Override // p136d.p153c.p159e0.Consumer
                    public void accept(Object obj) {
                        AppLog.m2158a("LOGIC_BEACONS", "DataManager", "getApplicationData", "Current data in the database loaded successfully");
                        C2180a.this.f9348a.mo3282b(DataModels.EMPTY_OBJECT);
                    }
                }

                /* compiled from: DataManager.java */
                /* renamed from: h.a.a.n$q0$a$b$b */
                /* loaded from: classes.dex */
                public class C2184b implements Consumer<Throwable> {
                    public C2184b() {
                    }

                    @Override // p136d.p153c.p159e0.Consumer
                    /* renamed from: a */
                    public void accept(Throwable th) {
                        AppLog.m2158a("LOGIC_BEACONS", "DataManager", "getApplicationData", "Failed to load the current data in the database");
                        C2180a.this.f9348a.mo3283a(th);
                    }
                }

                /* compiled from: DataManager.java */
                /* renamed from: h.a.a.n$q0$a$b$c */
                /* loaded from: classes.dex */
                public class C2185c implements Function4<Object, Object, Object, Object, Object> {
                    public C2185c(C2182b c2182b) {
                    }

                    @Override // p136d.p153c.p159e0.Function4
                    public Object apply(Object obj, Object obj2, Object obj3, Object obj4) {
                        return DataModels.EMPTY_OBJECT;
                    }
                }

                /* compiled from: DataManager.java */
                /* renamed from: h.a.a.n$q0$a$b$d */
                /* loaded from: classes.dex */
                public class C2186d implements Function8<Object, Object, Object, Object, Object, Object, Object, Object, Object> {
                    public C2186d(C2182b c2182b) {
                    }

                    @Override // p136d.p153c.p159e0.Function8
                    public Object apply(Object obj, Object obj2, Object obj3, Object obj4, Object obj5, Object obj6, Object obj7, Object obj8) {
                        return DataModels.EMPTY_OBJECT;
                    }
                }

                public C2182b() {
                }

                @Override // p136d.p153c.p159e0.Consumer
                /* renamed from: a */
                public void accept(Throwable th) {
                    AppLog.m2158a("LOGIC_BEACONS", "DataManager", "getApplicationData", "Error processing received application data: " + Log.getStackTraceString(th));
                    DataModels.Error m1599a = GeneralUtils.m1599a(th);
                    C2180a c2180a = C2180a.this;
                    if (c2180a.f9349b != null) {
                        if (C2179q0.this.f9346b.booleanValue()) {
                            Single.zip(Single.zip(DataManager.this.m1631i("[]"), DataManager.this.m1626j("[]"), DataManager.this.m1622k("[]"), DataManager.this.m1646f("[]"), DataManager.this.m1641g("[]"), DataManager.this.m1636h("[]"), DataManager.this.m1697a("[]"), DataManager.this.m1678b("[]"), new C2186d(this)), DataManager.this.m1659d("[]"), DataManager.this.m1668c("[]"), DataManager.this.m1651e("[]"), new C2185c(this)).subscribeOn(Schedulers.m3323b()).subscribe(new C2183a(), new C2184b());
                            return;
                        } else {
                            C2180a.this.f9348a.mo3283a(new DataModels.C2698g(m1599a));
                            return;
                        }
                    }
                    AppLog.m2158a("LOGIC_OTHER", "DataManager", "getApplicationData", "Failed to get the initial data from server.");
                    C2180a.this.f9348a.mo3283a(new DataModels.C2698g(m1599a));
                }
            }

            /* compiled from: DataManager.java */
            /* renamed from: h.a.a.n$q0$a$c */
            /* loaded from: classes.dex */
            public class C2187c implements Function4<Object, Object, Object, Object, Object> {
                public C2187c(C2180a c2180a) {
                }

                @Override // p136d.p153c.p159e0.Function4
                public Object apply(Object obj, Object obj2, Object obj3, Object obj4) {
                    return DataModels.EMPTY_OBJECT;
                }
            }

            /* compiled from: DataManager.java */
            /* renamed from: h.a.a.n$q0$a$d */
            /* loaded from: classes.dex */
            public class C2188d implements Function8<Object, Object, Object, Object, Object, Object, Object, Object, Object> {
                public C2188d(C2180a c2180a) {
                }

                @Override // p136d.p153c.p159e0.Function8
                public Object apply(Object obj, Object obj2, Object obj3, Object obj4, Object obj5, Object obj6, Object obj7, Object obj8) {
                    return DataModels.EMPTY_OBJECT;
                }
            }

            /* compiled from: DataManager.java */
            /* renamed from: h.a.a.n$q0$a$e */
            /* loaded from: classes.dex */
            public class C2189e implements Consumer<Object> {
                public C2189e() {
                }

                @Override // p136d.p153c.p159e0.Consumer
                public void accept(Object obj) {
                    AppLog.m2158a("LOGIC_BEACONS", "DataManager", "getApplicationData", "Current data in the database loaded successfully");
                    C2180a.this.f9348a.mo3282b(DataModels.EMPTY_OBJECT);
                }
            }

            /* compiled from: DataManager.java */
            /* renamed from: h.a.a.n$q0$a$f */
            /* loaded from: classes.dex */
            public class C2190f implements Consumer<Throwable> {
                public C2190f() {
                }

                @Override // p136d.p153c.p159e0.Consumer
                /* renamed from: a */
                public void accept(Throwable th) {
                    AppLog.m2158a("LOGIC_BEACONS", "DataManager", "getApplicationData", "Failed to load the current data in the database");
                    C2180a.this.f9348a.mo3283a(th);
                }
            }

            /* compiled from: DataManager.java */
            /* renamed from: h.a.a.n$q0$a$g */
            /* loaded from: classes.dex */
            public class C2191g implements Function4<Object, Object, Object, Object, Object> {
                public C2191g(C2180a c2180a) {
                }

                @Override // p136d.p153c.p159e0.Function4
                public Object apply(Object obj, Object obj2, Object obj3, Object obj4) {
                    return DataModels.EMPTY_OBJECT;
                }
            }

            /* compiled from: DataManager.java */
            /* renamed from: h.a.a.n$q0$a$h */
            /* loaded from: classes.dex */
            public class C2192h implements Function8<Object, Object, Object, Object, Object, Object, Object, Object, Object> {
                public C2192h(C2180a c2180a) {
                }

                @Override // p136d.p153c.p159e0.Function8
                public Object apply(Object obj, Object obj2, Object obj3, Object obj4, Object obj5, Object obj6, Object obj7, Object obj8) {
                    return DataModels.EMPTY_OBJECT;
                }
            }

            public C2180a(SingleObserver singleObserver, Date date) {
                this.f9348a = singleObserver;
                this.f9349b = date;
            }

            @Override // pt.card4b.backendbeacons.BackendListeners.BaseRequestListener
            public void onError(DataModels.Error error) {
                AppLog.m2158a("LOGIC_BEACONS", "DataManager", "getApplicationData", "Error getting application data: " + error.getMessage());
                if (this.f9349b != null) {
                    if (C2179q0.this.f9346b.booleanValue()) {
                        Single.zip(Single.zip(DataManager.this.m1631i("[]"), DataManager.this.m1626j("[]"), DataManager.this.m1622k("[]"), DataManager.this.m1646f("[]"), DataManager.this.m1641g("[]"), DataManager.this.m1636h("[]"), DataManager.this.m1697a("[]"), DataManager.this.m1678b("[]"), new C2192h(this)), DataManager.this.m1659d("[]"), DataManager.this.m1668c("[]"), DataManager.this.m1651e("[]"), new C2191g(this)).subscribeOn(Schedulers.m3323b()).subscribe(new C2189e(), new C2190f());
                        return;
                    } else {
                        this.f9348a.mo3283a(new DataModels.C2698g(error));
                        return;
                    }
                }
                AppLog.m2158a("LOGIC_OTHER", "DataManager", "getApplicationData", "Failed to get the initial data from server.");
                this.f9348a.mo3283a(new DataModels.C2698g(error));
            }

            @Override // pt.card4b.backendbeacons.BackendListeners.InterfaceC2680h
            /* renamed from: a  reason: avoid collision after fix types in other method */
            public void mo334a(Map<String, String> map) {
                Single.zip(Single.zip(DataManager.this.m1631i(map.get("operators")), DataManager.this.m1626j(map.get("stops")), DataManager.this.m1622k(map.get("zones")), DataManager.this.m1646f(map.get("lineDirections")), DataManager.this.m1641g(map.get("lineVariants")), DataManager.this.m1636h(map.get("lines")), DataManager.this.m1697a(map.get("beaconInformationTypes")), DataManager.this.m1678b(map.get("configurations")), new C2188d(this)), DataManager.this.m1659d(map.get("customerProfiles")), DataManager.this.m1668c(map.get("countries")), DataManager.this.m1651e(map.get("languages")), new C2187c(this)).subscribeOn(Schedulers.m3323b()).subscribe(new C2181a(), new C2182b());
            }
        }

        public C2179q0(Boolean bool, Boolean bool2) {
            this.f9345a = bool;
            this.f9346b = bool2;
        }

        @Override // p136d.p153c.Single
        public void subscribeActual(SingleObserver<? super Object> singleObserver) {
            if (this.f9345a.booleanValue()) {
                SharedPrefsController.m1540d().m1563B();
            }
            Date m1559a = DataManager.m1673c() ? SharedPrefsController.m1540d().m1559a() : null;
            BackendAPIController.m2049d().m2064a(m1559a != null ? GeneralUtils.m1593b(m1559a) : "-1", new C2180a(singleObserver, m1559a));
        }
    }

    /* compiled from: DataManager.java */
    /* renamed from: h.a.a.n$r */
    /* loaded from: classes.dex */
    public class C2193r extends Single<Object> {

        /* renamed from: a */
        public final /* synthetic */ String f9357a;

        public C2193r(DataManager dataManager, String str) {
            this.f9357a = str;
        }

        @Override // p136d.p153c.Single
        public void subscribeActual(SingleObserver<? super Object> singleObserver) {
            if (SharedPrefsController.m1540d().m1533f(this.f9357a)) {
                singleObserver.mo3282b(DataModels.EMPTY_OBJECT);
            } else {
                singleObserver.mo3283a(new DataModels.C2698g(DataModels.Error.internal("failed to remove stage state")));
            }
        }
    }

    /* compiled from: DataManager.java */
    /* renamed from: h.a.a.n$r0 */
    /* loaded from: classes.dex */
    public class C2194r0 extends Single<Object> {

        /* renamed from: a */
        public final /* synthetic */ DataModels.User f9358a;

        public C2194r0(DataManager dataManager, DataModels.User user) {
            this.f9358a = user;
        }

        @Override // p136d.p153c.Single
        public void subscribeActual(SingleObserver<? super Object> singleObserver) {
            SharedPrefsController.m1540d().m1550a(this.f9358a);
            singleObserver.mo3282b(DataModels.EMPTY_OBJECT);
        }
    }

    /* compiled from: DataManager.java */
    /* renamed from: h.a.a.n$s */
    /* loaded from: classes.dex */
    public class RunnableC2195s implements Runnable {

        /* renamed from: a */
        public final /* synthetic */ List f9359a;

        public RunnableC2195s(List list) {
            this.f9359a = list;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                ArrayList arrayList = new ArrayList();
                for (DataModelDTOs$IntermodalZoneDTO dataModelDTOs$IntermodalZoneDTO : this.f9359a) {
                    arrayList.add(new DataModelDBOs$TableZone(dataModelDTOs$IntermodalZoneDTO));
                }
                synchronized (DataManager.this.f9239d) {
                    Database.m66r().m73k(arrayList);
                }
                SharedPrefsController.m1540d().m1516l(true);
                AppLog.m2158a("LOGIC_OTHER", "DataManager", "zonesDatabase", "Saved zones to database!");
            } catch (Throwable th) {
                AppLog.m2158a("LOGIC_OTHER", "DataManager", "zonesDatabase", "Error saving zones:" + Log.getStackTraceString(th));
            }
        }
    }

    /* compiled from: DataManager.java */
    /* renamed from: h.a.a.n$s0 */
    /* loaded from: classes.dex */
    public class C2196s0 extends Single<Object> {

        /* renamed from: a */
        public final /* synthetic */ String f9361a;

        /* compiled from: DataManager.java */
        /* renamed from: h.a.a.n$s0$a */
        /* loaded from: classes.dex */
        public class C2197a implements BackendListeners.InterfaceC2677e {

            /* renamed from: a */
            public final /* synthetic */ SingleObserver f9362a;

            public C2197a(C2196s0 c2196s0, SingleObserver singleObserver) {
                this.f9362a = singleObserver;
            }

            @Override // pt.card4b.backendbeacons.BackendListeners.BaseRequestListener
            public void onError(DataModels.Error error) {
                StringBuilder sb = new StringBuilder();
                sb.append("Failed to logout on server");
                sb.append(error != null ? error.getMessage() : "");
                AppLog.m2158a("LOGIC_USER", "DataManager", "logout", sb.toString());
                SharedPrefsController.m1540d().m1562C();
                SharedPrefsController.m1540d().m1561D();
                this.f9362a.mo3282b(DataModels.EMPTY_OBJECT);
            }

            @Override // pt.card4b.backendbeacons.BackendListeners.InterfaceC2677e
            public void onSuccess() {
                SharedPrefsController.m1540d().m1562C();
                SharedPrefsController.m1540d().m1561D();
                this.f9362a.mo3282b(DataModels.EMPTY_OBJECT);
            }
        }

        public C2196s0(DataManager dataManager, String str) {
            this.f9361a = str;
        }

        @Override // p136d.p153c.Single
        public void subscribeActual(SingleObserver<? super Object> singleObserver) {
            BackendAPIController.m2049d().m2065a(this.f9361a, new C2197a(this, singleObserver));
        }
    }

    /* compiled from: DataManager.java */
    /* renamed from: h.a.a.n$t */
    /* loaded from: classes.dex */
    public class C2198t extends Single<DataModels.C2707p> {

        /* renamed from: a */
        public final /* synthetic */ String f9363a;

        public C2198t(DataManager dataManager, String str) {
            this.f9363a = str;
        }

        @Override // p136d.p153c.Single
        public void subscribeActual(SingleObserver<? super DataModels.C2707p> singleObserver) {
            DataModels.C2707p m1556a = SharedPrefsController.m1540d().m1556a(this.f9363a);
            if (m1556a != null) {
                singleObserver.mo3282b(m1556a);
            } else {
                singleObserver.mo3283a(new DataModels.C2698g(DataModels.Error.internal("No stage state saved")));
            }
        }
    }

    /* compiled from: DataManager.java */
    /* renamed from: h.a.a.n$t0 */
    /* loaded from: classes.dex */
    public class C2199t0 extends Single<Object> {

        /* compiled from: DataManager.java */
        /* renamed from: h.a.a.n$t0$a */
        /* loaded from: classes.dex */
        public class C2200a implements Consumer<Object> {

            /* renamed from: a */
            public final /* synthetic */ SingleObserver f9365a;

            public C2200a(C2199t0 c2199t0, SingleObserver singleObserver) {
                this.f9365a = singleObserver;
            }

            @Override // p136d.p153c.p159e0.Consumer
            public void accept(Object obj) {
                this.f9365a.mo3282b(DataModels.EMPTY_OBJECT);
            }
        }

        /* compiled from: DataManager.java */
        /* renamed from: h.a.a.n$t0$b */
        /* loaded from: classes.dex */
        public class C2201b implements Consumer<Throwable> {

            /* renamed from: a */
            public final /* synthetic */ SingleObserver f9366a;

            public C2201b(C2199t0 c2199t0, SingleObserver singleObserver) {
                this.f9366a = singleObserver;
            }

            @Override // p136d.p153c.p159e0.Consumer
            /* renamed from: a */
            public void accept(Throwable th) {
                this.f9366a.mo3283a(th);
            }
        }

        public C2199t0() {
        }

        @Override // p136d.p153c.Single
        public void subscribeActual(SingleObserver<? super Object> singleObserver) {
            DataManager.this.m1678b("[]").subscribeOn(Schedulers.m3323b()).subscribe(new C2200a(this, singleObserver), new C2201b(this, singleObserver));
        }
    }

    /* compiled from: DataManager.java */
    /* renamed from: h.a.a.n$u */
    /* loaded from: classes.dex */
    public class C2202u extends Single<List<DataModels.StageInfo>> {

        /* renamed from: a */
        public final /* synthetic */ Date f9367a;

        /* renamed from: b */
        public final /* synthetic */ String f9368b;

        /* compiled from: DataManager.java */
        /* renamed from: h.a.a.n$u$a */
        /* loaded from: classes.dex */
        public class C2203a implements BackendListeners.InterfaceC2680h<List<DataModelDTOs$StageDetailsDTO>> {

            /* renamed from: a */
            public final /* synthetic */ SingleObserver f9370a;

            public C2203a(SingleObserver singleObserver) {
                this.f9370a = singleObserver;
            }

            @Override // pt.card4b.backendbeacons.BackendListeners.BaseRequestListener
            public void onError(DataModels.Error error) {
                this.f9370a.mo3283a(new DataModels.C2698g(error));
            }

            @Override // pt.card4b.backendbeacons.BackendListeners.InterfaceC2680h
            /* renamed from: onSuccess */
            public void mo334a(List<DataModelDTOs$StageDetailsDTO> list) {
                this.f9370a.mo3282b(DataManager.this.m1675b(list));
            }
        }

        public C2202u(Date date, String str) {
            this.f9367a = date;
            this.f9368b = str;
        }

        @Override // p136d.p153c.Single
        public void subscribeActual(SingleObserver<? super List<DataModels.StageInfo>> singleObserver) {
            Calendar calendar = Calendar.getInstance(TimeZone.getTimeZone("Europe/Lisbon"));
            calendar.setTime(this.f9367a);
            calendar.set(5, 1);
            calendar.set(5, calendar.getActualMaximum(5));
            BackendAPIController.m2049d().m2073a(GeneralUtils.m1588f(), this.f9368b, GeneralUtils.m1593b((Date) calendar.getTime().clone()), GeneralUtils.m1593b((Date) calendar.getTime().clone()), new C2203a(singleObserver));
        }
    }

    /* compiled from: DataManager.java */
    /* renamed from: h.a.a.n$u0 */
    /* loaded from: classes.dex */
    public class C2204u0 extends Single<Object> {

        /* renamed from: a */
        public final /* synthetic */ String f9372a;

        /* compiled from: DataManager.java */
        /* renamed from: h.a.a.n$u0$a */
        /* loaded from: classes.dex */
        public class C2205a extends TypeToken<ArrayList<DataModelDTOs$IntermodalZoneDTO>> {
            public C2205a(C2204u0 c2204u0) {
            }
        }

        public C2204u0(String str) {
            this.f9372a = str;
        }

        @Override // p136d.p153c.Single
        public void subscribeActual(SingleObserver<? super Object> singleObserver) {
            GsonBuilder gsonBuilder = new GsonBuilder();
            gsonBuilder.m4916a("yyyy-MM-dd'T'hh:mm:ss");
            Gson m4917a = gsonBuilder.m4917a();
            String str = this.f9372a;
            if (str == null) {
                str = "[]";
            }
            List list = (List) m4917a.m4927a(str, new C2205a(this).getType());
            Consuela.m1790k().m1772u().clear();
            if (C2158j0.f9318a[DataManager.this.f9247l.ordinal()] != 1) {
                return;
            }
            DataManager.this.m1625j(list, singleObserver);
        }
    }

    /* compiled from: DataManager.java */
    /* renamed from: h.a.a.n$v */
    /* loaded from: classes.dex */
    public class RunnableC2206v implements Runnable {

        /* renamed from: a */
        public final /* synthetic */ List f9374a;

        public RunnableC2206v(List list) {
            this.f9374a = list;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                ArrayList arrayList = new ArrayList();
                for (DataModelDTOs$LineDirectionDTO dataModelDTOs$LineDirectionDTO : this.f9374a) {
                    arrayList.add(new DataModelDBOs$TableLineOrientation(dataModelDTOs$LineDirectionDTO));
                }
                synchronized (DataManager.this.f9241f) {
                    Database.m66r().m81g(arrayList);
                }
                SharedPrefsController.m1540d().m1529g(true);
                AppLog.m2158a("LOGIC_OTHER", "DataManager", "lineDirectionsDatabase", "Saved lineDirections to database!");
            } catch (Throwable th) {
                AppLog.m2158a("LOGIC_OTHER", "DataManager", "lineDirectionsDatabase", "Error saving linedirections:" + Log.getStackTraceString(th));
            }
        }
    }

    /* compiled from: DataManager.java */
    /* renamed from: h.a.a.n$v0 */
    /* loaded from: classes.dex */
    public enum EnumC2207v0 {
        DATABASE
    }

    /* compiled from: DataManager.java */
    /* renamed from: h.a.a.n$w */
    /* loaded from: classes.dex */
    public class C2208w extends Single<List<DataModels.TariffInfo>> {

        /* renamed from: a */
        public final /* synthetic */ Date f9378a;

        /* renamed from: b */
        public final /* synthetic */ String f9379b;

        /* compiled from: DataManager.java */
        /* renamed from: h.a.a.n$w$a */
        /* loaded from: classes.dex */
        public class C2209a implements BackendListeners.InterfaceC2680h<List<DataModelDTOs$StageTariffsDTO>> {

            /* renamed from: a */
            public final /* synthetic */ SingleObserver f9381a;

            public C2209a(SingleObserver singleObserver) {
                this.f9381a = singleObserver;
            }

            @Override // pt.card4b.backendbeacons.BackendListeners.BaseRequestListener
            public void onError(DataModels.Error error) {
                this.f9381a.mo3283a(new DataModels.C2698g(error));
            }

            @Override // pt.card4b.backendbeacons.BackendListeners.InterfaceC2680h
            /* renamed from: onSuccess */
            public void mo334a(List<DataModelDTOs$StageTariffsDTO> list) {
                this.f9381a.mo3282b(DataManager.this.m1657d(list));
            }
        }

        public C2208w(Date date, String str) {
            this.f9378a = date;
            this.f9379b = str;
        }

        @Override // p136d.p153c.Single
        public void subscribeActual(SingleObserver<? super List<DataModels.TariffInfo>> singleObserver) {
            Calendar calendar = Calendar.getInstance(TimeZone.getTimeZone("Europe/Lisbon"));
            calendar.setTime(this.f9378a);
            calendar.set(5, 1);
            calendar.set(5, calendar.getActualMaximum(5));
            BackendAPIController.m2049d().m2056b(GeneralUtils.m1588f(), this.f9379b, GeneralUtils.m1593b((Date) calendar.getTime().clone()), GeneralUtils.m1593b((Date) calendar.getTime().clone()), new C2209a(singleObserver));
        }
    }

    /* compiled from: DataManager.java */
    /* renamed from: h.a.a.n$w0 */
    /* loaded from: classes.dex */
    public class C2210w0 extends Single<Object> {

        /* renamed from: a */
        public final /* synthetic */ String f9383a;

        /* compiled from: DataManager.java */
        /* renamed from: h.a.a.n$w0$a */
        /* loaded from: classes.dex */
        public class C2211a extends TypeToken<ArrayList<DataModelDTOs$ConfigurationDTO>> {
            public C2211a(C2210w0 c2210w0) {
            }
        }

        public C2210w0(String str) {
            this.f9383a = str;
        }

        @Override // p136d.p153c.Single
        public void subscribeActual(SingleObserver<? super Object> singleObserver) {
            DataModels.User m1519k = SharedPrefsController.m1540d().m1519k();
            String id = m1519k != null ? m1519k.getId() : null;
            GsonBuilder gsonBuilder = new GsonBuilder();
            gsonBuilder.m4916a("yyyy-MM-dd'T'hh:mm:ss");
            Gson m4917a = gsonBuilder.m4917a();
            String str = this.f9383a;
            if (str == null) {
                str = "[]";
            }
            List<DataModelDTOs$ConfigurationDTO> list = (List) m4917a.m4927a(str, new C2211a(this).getType());
            if (list != null && list.size() > 0) {
                for (DataModelDTOs$ConfigurationDTO dataModelDTOs$ConfigurationDTO : list) {
                    if (dataModelDTOs$ConfigurationDTO.getCode() == null || dataModelDTOs$ConfigurationDTO.getCode().trim().isEmpty()) {
                        dataModelDTOs$ConfigurationDTO.setCode(dataModelDTOs$ConfigurationDTO.getName());
                    }
                }
            }
            Consuela.m1790k().m1798g().clear();
            if (C2158j0.f9318a[DataManager.this.f9247l.ordinal()] != 1) {
                return;
            }
            DataManager.this.m1687a(list, id, singleObserver);
        }
    }

    /* compiled from: DataManager.java */
    /* renamed from: h.a.a.n$x */
    /* loaded from: classes.dex */
    public class RunnableC2212x implements Runnable {

        /* renamed from: a */
        public final /* synthetic */ List f9385a;

        public RunnableC2212x(List list) {
            this.f9385a = list;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                ArrayList arrayList = new ArrayList();
                for (DataModelDTOs$LineVariantDTO dataModelDTOs$LineVariantDTO : this.f9385a) {
                    arrayList.add(new DataModelDBOs$TableLineVariant(dataModelDTOs$LineVariantDTO));
                }
                synchronized (DataManager.this.f9242g) {
                    Database.m66r().m79h(arrayList);
                }
                SharedPrefsController.m1540d().m1526h(true);
                AppLog.m2158a("LOGIC_OTHER", "DataManager", "lineVariantsDatabase", "Saved lineVariants to database!");
            } catch (Throwable th) {
                AppLog.m2158a("LOGIC_OTHER", "DataManager", "lineVariantsDatabase", "Error saving linevariants:" + Log.getStackTraceString(th));
            }
        }
    }

    /* compiled from: DataManager.java */
    /* renamed from: h.a.a.n$x0 */
    /* loaded from: classes.dex */
    public class C2213x0 extends Single<Object> {

        /* renamed from: a */
        public final /* synthetic */ String f9387a;

        /* compiled from: DataManager.java */
        /* renamed from: h.a.a.n$x0$a */
        /* loaded from: classes.dex */
        public class C2214a extends TypeToken<ArrayList<DataModelDTOs$CustomerProfileDTO>> {
            public C2214a(C2213x0 c2213x0) {
            }
        }

        public C2213x0(String str) {
            this.f9387a = str;
        }

        @Override // p136d.p153c.Single
        public void subscribeActual(SingleObserver<? super Object> singleObserver) {
            GsonBuilder gsonBuilder = new GsonBuilder();
            gsonBuilder.m4916a("yyyy-MM-dd'T'hh:mm:ss");
            Gson m4917a = gsonBuilder.m4917a();
            String str = this.f9387a;
            if (str == null) {
                str = "[]";
            }
            List list = (List) m4917a.m4927a(str, new C2214a(this).getType());
            Consuela.m1790k().m1794i().clear();
            if (C2158j0.f9318a[DataManager.this.f9247l.ordinal()] != 1) {
                return;
            }
            DataManager.this.m1664c(list, singleObserver);
        }
    }

    /* compiled from: DataManager.java */
    /* renamed from: h.a.a.n$y */
    /* loaded from: classes.dex */
    public class C2215y extends Single<List<DataModels.InvoiceInfo>> {

        /* renamed from: a */
        public final /* synthetic */ Date f9389a;

        /* renamed from: b */
        public final /* synthetic */ String f9390b;

        /* compiled from: DataManager.java */
        /* renamed from: h.a.a.n$y$a */
        /* loaded from: classes.dex */
        public class C2216a implements BackendListeners.InterfaceC2680h<List<DataModelDTOs$InvoiceDetailsDTO>> {

            /* renamed from: a */
            public final /* synthetic */ SingleObserver f9392a;

            public C2216a(SingleObserver singleObserver) {
                this.f9392a = singleObserver;
            }

            @Override // pt.card4b.backendbeacons.BackendListeners.BaseRequestListener
            public void onError(DataModels.Error error) {
                this.f9392a.mo3283a(new DataModels.C2698g(error));
            }

            @Override // pt.card4b.backendbeacons.BackendListeners.InterfaceC2680h
            /* renamed from: onSuccess */
            public void mo334a(List<DataModelDTOs$InvoiceDetailsDTO> list) {
                this.f9392a.mo3282b(DataManager.this.m1665c(list));
            }
        }

        public C2215y(Date date, String str) {
            this.f9389a = date;
            this.f9390b = str;
        }

        @Override // p136d.p153c.Single
        public void subscribeActual(SingleObserver<? super List<DataModels.InvoiceInfo>> singleObserver) {
            Calendar calendar = Calendar.getInstance(TimeZone.getTimeZone("Europe/Lisbon"));
            calendar.setTime(this.f9389a);
            calendar.set(5, 1);
            calendar.set(5, calendar.getActualMaximum(5));
            BackendAPIController.m2049d().m2069a(this.f9390b, GeneralUtils.m1593b((Date) calendar.getTime().clone()), GeneralUtils.m1593b((Date) calendar.getTime().clone()), new C2216a(singleObserver));
        }
    }

    /* compiled from: DataManager.java */
    /* renamed from: h.a.a.n$z */
    /* loaded from: classes.dex */
    public class RunnableC2217z implements Runnable {

        /* renamed from: a */
        public final /* synthetic */ List f9394a;

        public RunnableC2217z(List list) {
            this.f9394a = list;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                ArrayList arrayList = new ArrayList();
                for (DataModelDTOs$BeaconInformationTypeDTO dataModelDTOs$BeaconInformationTypeDTO : this.f9394a) {
                    arrayList.add(new DataModelDBOs$TableBeaconInformationType(dataModelDTOs$BeaconInformationTypeDTO));
                }
                synchronized (DataManager.this.f9243h) {
                    Database.m66r().m105a(arrayList);
                }
                SharedPrefsController.m1540d().m1544b(true);
                AppLog.m2158a("LOGIC_OTHER", "DataManager", "beaconInformationTypesDatabase", "Saved beaconInformationTypes to database!");
            } catch (Throwable th) {
                AppLog.m2158a("LOGIC_OTHER", "DataManager", "beaconInformationTypesDatabase", "Error saving beaconinformationtypes:" + Log.getStackTraceString(th));
            }
        }
    }

    public DataManager() {
        if (f9235m != null) {
            throw new RuntimeException("DataManager: Use getInstance() method to get the single instance of this class.");
        }
    }

    /* renamed from: m */
    public Single<DataModels.C2707p> m1619m(String str) {
        return new C2198t(this, str);
    }

    /* renamed from: n */
    public Single<DataModels.UserAccountInfo> m1618n(String str) {
        return new C2147g0(this, str);
    }

    /* renamed from: o */
    public Single<Boolean> m1617o(String str) {
        return new C2168n(this, str);
    }

    /* renamed from: p */
    public Single<Object> m1616p(String str) {
        return new C2196s0(this, str);
    }

    /* renamed from: q */
    public Single<Object> m1615q(String str) {
        return new C2193r(this, str);
    }

    /* renamed from: r */
    public Single<Object> m1614r(String str) {
        return new C2163l0(this, str);
    }

    /* renamed from: l */
    public Single<List<DataModels.PaymentMethod>> m1620l(String str) {
        return new C2126a0(this, str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: k */
    public Single<Object> m1622k(String str) {
        return new C2204u0(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: f */
    public Single<Object> m1646f(String str) {
        return new C2128b(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: g */
    public Single<Object> m1641g(String str) {
        return new C2135d(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: h */
    public Single<Object> m1636h(String str) {
        return new C2173o0(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: i */
    public Single<Object> m1631i(String str) {
        return new C2160k0(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: j */
    public Single<Object> m1626j(String str) {
        return new C2166m0(str);
    }

    /* renamed from: d */
    public Single<Object> m1663d() {
        return new C2199t0();
    }

    /* renamed from: e */
    public Single<Object> m1655e() {
        return new C2131c(this);
    }

    /* renamed from: c */
    public static boolean m1673c() {
        return SharedPrefsController.m1540d().m1506v() && SharedPrefsController.m1540d().m1505w() && SharedPrefsController.m1540d().m1513o() && SharedPrefsController.m1540d().m1507u() && SharedPrefsController.m1540d().m1504x() && SharedPrefsController.m1540d().m1509s() && SharedPrefsController.m1540d().m1508t() && SharedPrefsController.m1540d().m1514n() && SharedPrefsController.m1540d().m1511q() && SharedPrefsController.m1540d().m1512p() && SharedPrefsController.m1540d().m1510r();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: e */
    public Single<Object> m1651e(String str) {
        return new C2156j(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: f */
    public void m1645f(List<DataModelDTOs$LineVariantDTO> list, SingleObserver<? super Object> singleObserver) {
        if (list != null) {
            try {
                if (list.size() > 0) {
                    new Thread(new RunnableC2212x(list)).start();
                    for (DataModelDTOs$LineVariantDTO dataModelDTOs$LineVariantDTO : list) {
                        DataModels.C2703l lineVariant = dataModelDTOs$LineVariantDTO.toLineVariant();
                        Consuela.m1790k().m1784n().put(lineVariant.m165b(), lineVariant);
                    }
                    AppLog.m2158a("LOGIC_OTHER", "DataManager", "lineVariantsDatabase", "LineVariant count = " + Consuela.m1790k().m1784n().size());
                    singleObserver.mo3282b(DataModels.EMPTY_OBJECT);
                    return;
                }
            } catch (Throwable th) {
                singleObserver.mo3283a(th);
                return;
            }
        }
        List<DataModelDBOs$TableLineVariant> m80h = Database.m66r().m80h();
        if (m80h != null && m80h.size() != 0) {
            for (DataModelDBOs$TableLineVariant dataModelDBOs$TableLineVariant : m80h) {
                DataModels.C2703l m297c = dataModelDBOs$TableLineVariant.m297c();
                Consuela.m1790k().m1784n().put(m297c.m165b(), m297c);
            }
            AppLog.m2158a("LOGIC_OTHER", "DataManager", "lineVariantsDatabase", "LineVariant count = " + Consuela.m1790k().m1784n().size());
            singleObserver.mo3282b(DataModels.EMPTY_OBJECT);
            return;
        }
        SharedPrefsController.m1540d().m1526h(false);
        singleObserver.mo3283a(new DataModels.C2698g(DataModels.Error.internal(GeneralUtils.m1603a(C1863a.errormsg_appdata))));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: g */
    public void m1640g(List<DataModelDTOs$LineDTO> list, SingleObserver<? super Object> singleObserver) {
        if (list != null) {
            try {
                if (list.size() > 0) {
                    new Thread(new RunnableC2178q(list)).start();
                    for (DataModelDTOs$LineDTO dataModelDTOs$LineDTO : list) {
                        DataModels.C2701j line = dataModelDTOs$LineDTO.toLine();
                        Consuela.m1790k().m1782o().put(line.m174a(), line);
                        Map<String, DataModels.C2701j> m1780p = Consuela.m1790k().m1780p();
                        m1780p.put(line.m170e() + "|" + line.m171d(), line);
                    }
                    AppLog.m2158a("LOGIC_OTHER", "DataManager", "linesDatabase", "Line count = " + Consuela.m1790k().m1782o().size());
                    singleObserver.mo3282b(DataModels.EMPTY_OBJECT);
                    return;
                }
            } catch (Throwable th) {
                singleObserver.mo3283a(th);
                return;
            }
        }
        List<DataModelDBOs$TableLine> m78i = Database.m66r().m78i();
        if (m78i != null && m78i.size() != 0) {
            for (DataModelDBOs$TableLine dataModelDBOs$TableLine : m78i) {
                DataModels.C2701j m304f = dataModelDBOs$TableLine.m304f();
                Consuela.m1790k().m1782o().put(m304f.m174a(), m304f);
                Map<String, DataModels.C2701j> m1780p2 = Consuela.m1790k().m1780p();
                m1780p2.put(m304f.m170e() + "|" + m304f.m171d(), m304f);
            }
            AppLog.m2158a("LOGIC_OTHER", "DataManager", "linesDatabase", "Line count = " + Consuela.m1790k().m1782o().size());
            singleObserver.mo3282b(DataModels.EMPTY_OBJECT);
            return;
        }
        SharedPrefsController.m1540d().m1523i(false);
        singleObserver.mo3283a(new DataModels.C2698g(DataModels.Error.internal(GeneralUtils.m1603a(C1863a.errormsg_appdata))));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: h */
    public void m1635h(List<DataModelDTOs$TransportOperatorDTO> list, SingleObserver<? super Object> singleObserver) {
        if (list != null) {
            try {
                if (list.size() > 0) {
                    new Thread(new RunnableC2159k(list)).start();
                    for (DataModelDTOs$TransportOperatorDTO dataModelDTOs$TransportOperatorDTO : list) {
                        DataModels.C2704m operator = dataModelDTOs$TransportOperatorDTO.toOperator();
                        Consuela.m1790k().m1776r().put(operator.m163b(), operator);
                        Consuela.m1790k().m1778q().add(operator);
                    }
                    AppLog.m2158a("LOGIC_OTHER", "DataManager", "operatorsDatabase", "Operator count = " + Consuela.m1790k().m1776r().size());
                    singleObserver.mo3282b(DataModels.EMPTY_OBJECT);
                    return;
                }
            } catch (Throwable th) {
                singleObserver.mo3283a(th);
                return;
            }
        }
        List<DataModelDBOs$TableOperator> m76j = Database.m66r().m76j();
        if (m76j != null && m76j.size() != 0) {
            for (DataModelDBOs$TableOperator dataModelDBOs$TableOperator : m76j) {
                DataModels.C2704m m292e = dataModelDBOs$TableOperator.m292e();
                Consuela.m1790k().m1776r().put(m292e.m163b(), m292e);
                Consuela.m1790k().m1778q().add(m292e);
            }
            AppLog.m2158a("LOGIC_OTHER", "DataManager", "operatorsDatabase", "Operator count = " + Consuela.m1790k().m1776r().size());
            singleObserver.mo3282b(DataModels.EMPTY_OBJECT);
            return;
        }
        SharedPrefsController.m1540d().m1520j(false);
        singleObserver.mo3283a(new DataModels.C2698g(DataModels.Error.internal(GeneralUtils.m1603a(C1863a.errormsg_appdata))));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: i */
    public void m1630i(List<DataModelDTOs$StopDTO> list, SingleObserver<? super Object> singleObserver) {
        if (list != null) {
            try {
                if (list.size() > 0) {
                    new Thread(new RunnableC2165m(list)).start();
                    for (DataModelDTOs$StopDTO dataModelDTOs$StopDTO : list) {
                        DataModels.C2708q stop = dataModelDTOs$StopDTO.toStop();
                        Consuela.m1790k().m1774s().put(stop.m114b(), stop);
                        Map<String, DataModels.C2708q> m1773t = Consuela.m1790k().m1773t();
                        m1773t.put(dataModelDTOs$StopDTO.getBeaconStopRef() + "|" + dataModelDTOs$StopDTO.getTransportOperatorRef(), stop);
                    }
                    AppLog.m2158a("LOGIC_OTHER", "DataManager", "stopsDatabase", "Stop count = " + Consuela.m1790k().m1774s().size());
                    singleObserver.mo3282b(DataModels.EMPTY_OBJECT);
                    return;
                }
            } catch (Throwable th) {
                singleObserver.mo3283a(th);
                return;
            }
        }
        List<DataModelDBOs$TableStop> m74k = Database.m66r().m74k();
        if (m74k != null && m74k.size() != 0) {
            for (DataModelDBOs$TableStop dataModelDBOs$TableStop : m74k) {
                DataModels.C2708q m285g = dataModelDBOs$TableStop.m285g();
                Consuela.m1790k().m1774s().put(m285g.m114b(), m285g);
                Map<String, DataModels.C2708q> m1773t2 = Consuela.m1790k().m1773t();
                m1773t2.put(dataModelDBOs$TableStop.m291a() + "|" + dataModelDBOs$TableStop.m288d(), m285g);
            }
            AppLog.m2158a("LOGIC_OTHER", "DataManager", "stopsDatabase", "Stop count = " + Consuela.m1790k().m1774s().size());
            singleObserver.mo3282b(DataModels.EMPTY_OBJECT);
            return;
        }
        SharedPrefsController.m1540d().m1518k(false);
        singleObserver.mo3283a(new DataModels.C2698g(DataModels.Error.internal(GeneralUtils.m1603a(C1863a.errormsg_appdata))));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: j */
    public void m1625j(List<DataModelDTOs$IntermodalZoneDTO> list, SingleObserver<? super Object> singleObserver) {
        if (list != null) {
            try {
                if (list.size() > 0) {
                    new Thread(new RunnableC2195s(list)).start();
                    for (DataModelDTOs$IntermodalZoneDTO dataModelDTOs$IntermodalZoneDTO : list) {
                        DataModels.C2709r zone = dataModelDTOs$IntermodalZoneDTO.toZone();
                        Consuela.m1790k().m1772u().put(zone.m110b(), zone);
                    }
                    AppLog.m2158a("LOGIC_OTHER", "DataManager", "zonesDatabase", "Zone count = " + Consuela.m1790k().m1772u().size());
                    singleObserver.mo3282b(DataModels.EMPTY_OBJECT);
                    return;
                }
            } catch (Throwable th) {
                singleObserver.mo3283a(th);
                return;
            }
        }
        List<DataModelDBOs$TableZone> m72l = Database.m66r().m72l();
        if (m72l != null && m72l.size() != 0) {
            for (DataModelDBOs$TableZone dataModelDBOs$TableZone : m72l) {
                DataModels.C2709r m280c = dataModelDBOs$TableZone.m280c();
                Consuela.m1790k().m1772u().put(m280c.m110b(), m280c);
            }
            AppLog.m2158a("LOGIC_OTHER", "DataManager", "zonesDatabase", "Zone count = " + Consuela.m1790k().m1772u().size());
            singleObserver.mo3282b(DataModels.EMPTY_OBJECT);
            return;
        }
        SharedPrefsController.m1540d().m1516l(false);
        singleObserver.mo3283a(new DataModels.C2698g(DataModels.Error.internal(GeneralUtils.m1603a(C1863a.errormsg_appdata))));
    }

    /* renamed from: b */
    public Single<DataModels.User> m1683b() {
        return new C2162l(this);
    }

    /* renamed from: d */
    public Single<Object> m1658d(String str, String str2) {
        return new C2154i0(this, str, str2);
    }

    /* renamed from: a */
    public static DataManager m1704a() {
        if (f9235m == null) {
            synchronized (DataManager.class) {
                if (f9235m == null) {
                    f9235m = new DataManager();
                }
            }
        }
        return f9235m;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: d */
    public Single<Object> m1659d(String str) {
        return new C2213x0(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: e */
    public void m1650e(List<DataModelDTOs$LineDirectionDTO> list, SingleObserver<? super Object> singleObserver) {
        if (list != null) {
            try {
                if (list.size() > 0) {
                    new Thread(new RunnableC2206v(list)).start();
                    for (DataModelDTOs$LineDirectionDTO dataModelDTOs$LineDirectionDTO : list) {
                        DataModels.C2702k lineOrientation = dataModelDTOs$LineDirectionDTO.toLineOrientation();
                        Consuela.m1790k().m1786m().put(lineOrientation.m169a(), lineOrientation);
                    }
                    AppLog.m2158a("LOGIC_OTHER", "DataManager", "lineDirectionsDatabase", "LineDirection count = " + Consuela.m1790k().m1786m().size());
                    singleObserver.mo3282b(DataModels.EMPTY_OBJECT);
                    return;
                }
            } catch (Throwable th) {
                singleObserver.mo3283a(th);
                return;
            }
        }
        List<DataModelDBOs$TableLineOrientation> m82g = Database.m66r().m82g();
        if (m82g != null && m82g.size() != 0) {
            for (DataModelDBOs$TableLineOrientation dataModelDBOs$TableLineOrientation : m82g) {
                DataModels.C2702k m300d = dataModelDBOs$TableLineOrientation.m300d();
                Consuela.m1790k().m1786m().put(m300d.m169a(), m300d);
            }
            AppLog.m2158a("LOGIC_OTHER", "DataManager", "lineDirectionsDatabase", "LineDirection count = " + Consuela.m1790k().m1786m().size());
            singleObserver.mo3282b(DataModels.EMPTY_OBJECT);
            return;
        }
        SharedPrefsController.m1540d().m1529g(false);
        singleObserver.mo3283a(new DataModels.C2698g(DataModels.Error.internal(GeneralUtils.m1603a(C1863a.errormsg_appdata))));
    }

    /* renamed from: b */
    public Single<List<DataModels.StageInfo>> m1676b(String str, Date date) {
        return new C2202u(date, str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: d */
    public void m1656d(List<DataModelDTOs$LanguageDTO> list, SingleObserver<? super Object> singleObserver) {
        if (list != null) {
            try {
                if (list.size() > 0) {
                    new Thread(new RunnableC2137d0(list)).start();
                    for (DataModelDTOs$LanguageDTO dataModelDTOs$LanguageDTO : list) {
                        DataModels.Language language = dataModelDTOs$LanguageDTO.toLanguage();
                        Consuela.m1790k().m1788l().put(language.getId(), language);
                    }
                    AppLog.m2158a("LOGIC_OTHER", "DataManager", "languagesDatabase", "Languages count = " + Consuela.m1790k().m1788l().size());
                    singleObserver.mo3282b(DataModels.EMPTY_OBJECT);
                    return;
                }
            } catch (Throwable th) {
                singleObserver.mo3283a(th);
                return;
            }
        }
        List<DataModelDBOs$TableLanguage> m84f = Database.m66r().m84f();
        if (m84f != null && m84f.size() != 0) {
            for (DataModelDBOs$TableLanguage dataModelDBOs$TableLanguage : m84f) {
                DataModels.Language m310d = dataModelDBOs$TableLanguage.m310d();
                Consuela.m1790k().m1788l().put(m310d.getId(), m310d);
            }
            AppLog.m2158a("LOGIC_OTHER", "DataManager", "languagesDatabase", "Languages count = " + Consuela.m1790k().m1788l().size());
            singleObserver.mo3282b(DataModels.EMPTY_OBJECT);
            return;
        }
        SharedPrefsController.m1540d().m1532f(false);
        singleObserver.mo3283a(new DataModels.C2698g(DataModels.Error.internal(GeneralUtils.m1603a(C1863a.errormsg_appdata))));
    }

    /* renamed from: b */
    public Single<DataModels.C2696e> m1677b(String str, String str2) {
        return new C2133c0(this, str, str2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: b */
    public Single<Object> m1678b(String str) {
        return new C2210w0(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: b */
    public void m1674b(List<DataModelDTOs$CountryDTO> list, SingleObserver<? super Object> singleObserver) {
        if (list != null) {
            try {
                if (list.size() > 0) {
                    new Thread(new RunnableC2130b0(list)).start();
                    for (DataModelDTOs$CountryDTO dataModelDTOs$CountryDTO : list) {
                        DataModels.Country country = dataModelDTOs$CountryDTO.toCountry();
                        Consuela.m1790k().m1796h().put(country.getId(), country);
                    }
                    AppLog.m2158a("LOGIC_OTHER", "DataManager", "countriesDatabase", "Countries count = " + Consuela.m1790k().m1796h().size());
                    singleObserver.mo3282b(DataModels.EMPTY_OBJECT);
                    return;
                }
            } catch (Throwable th) {
                singleObserver.mo3283a(th);
                return;
            }
        }
        List<DataModelDBOs$TableCountry> m88d = Database.m66r().m88d();
        if (m88d != null && m88d.size() != 0) {
            for (DataModelDBOs$TableCountry dataModelDBOs$TableCountry : m88d) {
                DataModels.Country m318d = dataModelDBOs$TableCountry.m318d();
                Consuela.m1790k().m1796h().put(m318d.getId(), m318d);
            }
            AppLog.m2158a("LOGIC_OTHER", "DataManager", "countriesDatabase", "Countries count = " + Consuela.m1790k().m1796h().size());
            singleObserver.mo3282b(DataModels.EMPTY_OBJECT);
            return;
        }
        SharedPrefsController.m1540d().m1538d(false);
        singleObserver.mo3283a(new DataModels.C2698g(DataModels.Error.internal(GeneralUtils.m1603a(C1863a.errormsg_appdata))));
    }

    /* renamed from: a */
    public Single<DataModels.User> m1696a(String str, String str2) {
        return new C2122a(str, str2);
    }

    /* renamed from: a */
    public Single<Object> m1686a(DataModels.User user) {
        return new C2194r0(this, user);
    }

    /* renamed from: a */
    public Single<Object> m1684a(DataModels.UserAccountInfo userAccountInfo, String str) {
        return new C2171o(this, userAccountInfo, str);
    }

    /* renamed from: a */
    public Single<Boolean> m1685a(DataModels.UserAccountInfo userAccountInfo) {
        return new C2169n0(this, userAccountInfo);
    }

    /* renamed from: a */
    public Single<Object> m1695a(String str, String str2, String str3) {
        return new C2176p0(this, str, str2, str3);
    }

    /* renamed from: c */
    public Single<List<DataModels.TariffInfo>> m1666c(String str, Date date) {
        return new C2208w(date, str);
    }

    /* renamed from: a */
    public Single<Object> m1698a(Boolean bool, Boolean bool2) {
        return new C2179q0(bool2, bool);
    }

    /* renamed from: c */
    public Single<Object> m1667c(String str, String str2) {
        return new C2140e0(this, str, str2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: c */
    public Single<Object> m1668c(String str) {
        return new C2149h(str);
    }

    /* renamed from: a */
    public Single<DataModels.NewStageStartInfo> m1691a(String str, List<DataModels.C2692b> list, boolean z, String str2) {
        return new C2138e(list, z, str, str2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: c */
    public void m1664c(List<DataModelDTOs$CustomerProfileDTO> list, SingleObserver<? super Object> singleObserver) {
        if (list != null) {
            try {
                if (list.size() > 0) {
                    new Thread(new RunnableC2151h0(list)).start();
                    for (DataModelDTOs$CustomerProfileDTO dataModelDTOs$CustomerProfileDTO : list) {
                        DataModels.CustomerProfile customerProfile = dataModelDTOs$CustomerProfileDTO.toCustomerProfile();
                        Consuela.m1790k().m1794i().put(customerProfile.getID(), customerProfile);
                    }
                    AppLog.m2158a("LOGIC_OTHER", "DataManager", "customerProfilesDatabase", "Customer profiles count = " + Consuela.m1790k().m1794i().size());
                    singleObserver.mo3282b(DataModels.EMPTY_OBJECT);
                    return;
                }
            } catch (Throwable th) {
                singleObserver.mo3283a(th);
                return;
            }
        }
        List<DataModelDBOs$TableCustomerProfile> m86e = Database.m66r().m86e();
        if (m86e != null && m86e.size() != 0) {
            for (DataModelDBOs$TableCustomerProfile dataModelDBOs$TableCustomerProfile : m86e) {
                DataModels.CustomerProfile m314d = dataModelDBOs$TableCustomerProfile.m314d();
                Consuela.m1790k().m1794i().put(m314d.getID(), m314d);
            }
            AppLog.m2158a("LOGIC_OTHER", "DataManager", "customerProfilesDatabase", "Customer profiles count = " + Consuela.m1790k().m1794i().size());
            singleObserver.mo3282b(DataModels.EMPTY_OBJECT);
            return;
        }
        SharedPrefsController.m1540d().m1535e(false);
        singleObserver.mo3283a(new DataModels.C2698g(DataModels.Error.internal(GeneralUtils.m1603a(C1863a.errormsg_appdata))));
    }

    /* renamed from: a */
    public Single<Object> m1693a(String str, String str2, List<DataModels.C2692b> list, boolean z, Date date, int i, String str3) {
        return new C2145g(list, str, str2, date, z, i, str3);
    }

    /* renamed from: a */
    public Single<Object> m1694a(String str, String str2, String str3, List<DataModels.C2692b> list, boolean z, Date date, int i, String str4) {
        return new C2152i(list, str3, date, str, str2, z, i, str4);
    }

    /* renamed from: a */
    public Single<Object> m1690a(String str, DataModels.C2707p c2707p) {
        return new C2175p(this, str, c2707p);
    }

    /* renamed from: a */
    public Single<List<DataModels.InvoiceInfo>> m1692a(String str, Date date) {
        return new C2215y(date, str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public Single<Object> m1697a(String str) {
        return new C2142f(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: d */
    public List<DataModels.TariffInfo> m1657d(List<DataModelDTOs$StageTariffsDTO> list) {
        ArrayList arrayList = new ArrayList();
        for (DataModelDTOs$StageTariffsDTO dataModelDTOs$StageTariffsDTO : list) {
            arrayList.add(dataModelDTOs$StageTariffsDTO.toTariffInfo());
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m1688a(List<DataModelDTOs$BeaconInformationTypeDTO> list, SingleObserver<? super Object> singleObserver) {
        if (list != null) {
            try {
                if (list.size() > 0) {
                    new Thread(new RunnableC2217z(list)).start();
                    for (DataModelDTOs$BeaconInformationTypeDTO dataModelDTOs$BeaconInformationTypeDTO : list) {
                        DataModels.C2695d beaconInformationType = dataModelDTOs$BeaconInformationTypeDTO.toBeaconInformationType();
                        Consuela.m1790k().m1800f().put(beaconInformationType.m196a(), beaconInformationType);
                    }
                    AppLog.m2158a("LOGIC_OTHER", "DataManager", "beaconInformationTypesDatabase", "BeaconInformationType count = " + Consuela.m1790k().m1800f().size());
                    singleObserver.mo3282b(DataModels.EMPTY_OBJECT);
                    return;
                }
            } catch (Throwable th) {
                singleObserver.mo3283a(th);
                return;
            }
        }
        List<DataModelDBOs$TableBeaconInformationType> m93b = Database.m66r().m93b();
        if (m93b != null && m93b.size() != 0) {
            for (DataModelDBOs$TableBeaconInformationType dataModelDBOs$TableBeaconInformationType : m93b) {
                DataModels.C2695d m329d = dataModelDBOs$TableBeaconInformationType.m329d();
                Consuela.m1790k().m1800f().put(m329d.m196a(), m329d);
            }
            AppLog.m2158a("LOGIC_OTHER", "DataManager", "beaconInformationTypesDatabase", "BeaconInformationType count = " + Consuela.m1790k().m1800f().size());
            singleObserver.mo3282b(DataModels.EMPTY_OBJECT);
            return;
        }
        SharedPrefsController.m1540d().m1544b(false);
        singleObserver.mo3283a(new DataModels.C2698g(DataModels.Error.internal(GeneralUtils.m1603a(C1863a.errormsg_appdata))));
    }

    /* renamed from: b */
    public List<DataModels.StageInfo> m1675b(List<DataModelDTOs$StageDetailsDTO> list) {
        ArrayList arrayList = new ArrayList();
        for (DataModelDTOs$StageDetailsDTO dataModelDTOs$StageDetailsDTO : list) {
            arrayList.add(dataModelDTOs$StageDetailsDTO.toStageInfo());
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: c */
    public List<DataModels.InvoiceInfo> m1665c(List<DataModelDTOs$InvoiceDetailsDTO> list) {
        ArrayList arrayList = new ArrayList();
        for (DataModelDTOs$InvoiceDetailsDTO dataModelDTOs$InvoiceDetailsDTO : list) {
            arrayList.add(dataModelDTOs$InvoiceDetailsDTO.toInvoiceInfo());
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m1687a(List<DataModelDTOs$ConfigurationDTO> list, String str, SingleObserver<? super Object> singleObserver) {
        if (list != null) {
            try {
                if (list.size() > 0) {
                    new Thread(new RunnableC2144f0(list)).start();
                    for (DataModelDTOs$ConfigurationDTO dataModelDTOs$ConfigurationDTO : list) {
                        if (dataModelDTOs$ConfigurationDTO.getCustomerId() == null || (str != null && dataModelDTOs$ConfigurationDTO.getCustomerId().toUpperCase().equals(str.toUpperCase()))) {
                            if (!Consuela.m1790k().m1798g().containsKey(dataModelDTOs$ConfigurationDTO.getCode()) || dataModelDTOs$ConfigurationDTO.getCustomerId() != null) {
                                Consuela.m1790k().m1798g().put(dataModelDTOs$ConfigurationDTO.getCode(), dataModelDTOs$ConfigurationDTO.toConfiguration());
                            }
                        }
                    }
                    AppLog.m2158a("LOGIC_OTHER", "DataManager", "configurationsDatabase", "Configurations count = " + Consuela.m1790k().m1798g().size());
                    singleObserver.mo3282b(DataModels.EMPTY_OBJECT);
                    return;
                }
            } catch (Throwable th) {
                singleObserver.mo3283a(th);
                return;
            }
        }
        if (Consuela.m1790k().m1802e() != null) {
            Consuela.m1790k().m1802e().getId();
        }
        List<DataModelDBOs$TableConfiguration> m90c = Database.m66r().m90c();
        if (m90c != null && m90c.size() != 0) {
            for (DataModelDBOs$TableConfiguration dataModelDBOs$TableConfiguration : m90c) {
                if (dataModelDBOs$TableConfiguration.m326c() == null || (str != null && dataModelDBOs$TableConfiguration.m326c().toUpperCase().equals(str.toUpperCase()))) {
                    if (!Consuela.m1790k().m1798g().containsKey(dataModelDBOs$TableConfiguration.m327b()) || dataModelDBOs$TableConfiguration.m326c() != null) {
                        Consuela.m1790k().m1798g().put(dataModelDBOs$TableConfiguration.m327b(), dataModelDBOs$TableConfiguration.m322g());
                    }
                }
            }
            AppLog.m2158a("LOGIC_OTHER", "DataManager", "configurationsDatabase", "Configurations count = " + Consuela.m1790k().m1798g().size());
            singleObserver.mo3282b(DataModels.EMPTY_OBJECT);
            return;
        }
        SharedPrefsController.m1540d().m1541c(false);
        singleObserver.mo3283a(new DataModels.C2698g(DataModels.Error.internal(GeneralUtils.m1603a(C1863a.errormsg_appdata))));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public List<DataModelDTOs$StageInformationBeaconDTO> m1689a(List<DataModels.C2692b> list) {
        AppLog.m2158a("LOGIC_BEACONS", "DataManager", "beaconDatasToStageInformationBeaconDTOs", "entered method");
        ArrayList arrayList = new ArrayList();
        for (DataModels.C2692b c2692b : list) {
            ArrayList<DataModels.C2691a> arrayList2 = new ArrayList(c2692b.m244b());
            String m195b = c2692b.m257a() == null ? null : c2692b.m257a().m195b();
            int m163b = c2692b.m233k() == null ? 0 : c2692b.m233k().m163b();
            int m112d = c2692b.m231m() == null ? 0 : c2692b.m231m().m112d();
            int m170e = c2692b.m236h() == null ? 0 : c2692b.m236h().m170e();
            int m110b = c2692b.m227q() == null ? 0 : c2692b.m227q().m110b();
            final int m228p = c2692b.m228p();
            int m165b = c2692b.m234j() == null ? 0 : c2692b.m234j().m165b();
            int m167c = c2692b.m235i() == null ? 0 : c2692b.m235i().m167c();
            final int m232l = c2692b.m232l();
            for (DataModels.C2691a c2691a : arrayList2) {
                if (c2692b.m233k() != null && c2692b.m231m() != null && c2692b.m257a() != null) {
                    final String m261j = c2691a.m261j();
                    final String m1593b = c2691a.m279a() != null ? GeneralUtils.m1593b(c2691a.m279a()) : null;
                    final String m1593b2 = c2691a.m265f() != null ? GeneralUtils.m1593b(c2691a.m265f()) : null;
                    final int m260k = c2691a.m260k();
                    final boolean booleanValue = c2691a.m266e().booleanValue();
                    final String m1593b3 = c2691a.m259l() != null ? GeneralUtils.m1593b(c2691a.m259l()) : null;
                    final double m264g = c2691a.m264g();
                    final double m262i = c2691a.m262i();
                    final double m263h = c2691a.m263h();
                    final String m271c = c2691a.m271c();
                    final String m1593b4 = c2691a.m268d() != null ? GeneralUtils.m1593b(c2691a.m268d()) : null;
                    final String str = m195b;
                    final int i = m163b;
                    final int i2 = m112d;
                    final int i3 = m110b;
                    final int i4 = m170e;
                    final int i5 = m165b;
                    final int i6 = m167c;
                    arrayList.add(new Object(m261j, m1593b, m1593b2, str, m260k, i, i2, i3, i4, m228p, i5, i6, m232l, booleanValue, m1593b3, m264g, m262i, m263h, m271c, m1593b4) { // from class: pt.card4b.backendbeacons.DataModelDTOs$StageInformationBeaconDTO
                        public String BeaconInfoTypeId;
                        public String BeaconSerialNumber;
                        public String EndDeviceTimeStamp;
                        public String HceCardSerialNr;
                        public String HceCardValidity;
                        public boolean IsHCE;
                        public double Latitude;
                        public int LineOrientationRef;
                        public int LineRef;
                        public int LineVariantRef;
                        public double LocationAccuracy;
                        public double Longitude;
                        public int OperatorRef;
                        public int Position;
                        public int Rssi;
                        public String StartDeviceTimeStamp;
                        public int StopRef;
                        public String ValidationTimestamp;
                        public int Vehicle;
                        public int ZoneRef;

                        {
                            this.BeaconSerialNumber = m261j;
                            this.StartDeviceTimeStamp = m1593b;
                            this.EndDeviceTimeStamp = m1593b2;
                            this.BeaconInfoTypeId = str;
                            this.Rssi = m260k;
                            this.OperatorRef = i;
                            this.StopRef = i2;
                            this.ZoneRef = i3;
                            this.LineRef = i4;
                            this.Vehicle = m228p;
                            this.LineVariantRef = i5;
                            this.LineOrientationRef = i6;
                            this.Position = m232l;
                            this.IsHCE = booleanValue;
                            this.ValidationTimestamp = m1593b3;
                            this.Latitude = m264g;
                            this.Longitude = m262i;
                            this.LocationAccuracy = m263h;
                            this.HceCardSerialNr = m271c;
                            this.HceCardValidity = m1593b4;
                        }

                        public String getBeaconInfoTypeId() {
                            return this.BeaconInfoTypeId;
                        }

                        public String getBeaconSerialNumber() {
                            return this.BeaconSerialNumber;
                        }

                        public String getEndDeviceTimeStamp() {
                            return this.EndDeviceTimeStamp;
                        }

                        public String getHceCardSerialNr() {
                            return this.HceCardSerialNr;
                        }

                        public String getHceCardValidity() {
                            return this.HceCardValidity;
                        }

                        public Boolean getIsHCE() {
                            return Boolean.valueOf(this.IsHCE);
                        }

                        public double getLatitude() {
                            return this.Latitude;
                        }

                        public int getLineOrientationRef() {
                            return this.LineOrientationRef;
                        }

                        public int getLineRef() {
                            return this.LineRef;
                        }

                        public int getLineVariantRef() {
                            return this.LineVariantRef;
                        }

                        public double getLocationAccuracy() {
                            return this.LocationAccuracy;
                        }

                        public double getLongitude() {
                            return this.Longitude;
                        }

                        public int getOperatorRef() {
                            return this.OperatorRef;
                        }

                        public int getPosition() {
                            return this.Position;
                        }

                        public int getRssi() {
                            return this.Rssi;
                        }

                        public String getStartDeviceTimeStamp() {
                            return this.StartDeviceTimeStamp;
                        }

                        public int getStopRef() {
                            return this.StopRef;
                        }

                        public String getValidationTimestamp() {
                            return this.ValidationTimestamp;
                        }

                        public int getVehicle() {
                            return this.Vehicle;
                        }

                        public int getZoneRef() {
                            return this.ZoneRef;
                        }

                        public void setBeaconInfoTypeId(String str2) {
                            this.BeaconInfoTypeId = str2;
                        }

                        public void setBeaconSerialNumber(String str2) {
                            this.BeaconSerialNumber = str2;
                        }

                        public void setEndDeviceTimeStamp(String str2) {
                            this.EndDeviceTimeStamp = str2;
                        }

                        public void setHceCardSerialNr(String str2) {
                            this.HceCardSerialNr = str2;
                        }

                        public void setHceCardValidity(String str2) {
                            this.HceCardValidity = str2;
                        }

                        public void setIsHCE(Boolean bool) {
                            this.IsHCE = bool.booleanValue();
                        }

                        public void setLatitude(double d) {
                            this.Latitude = d;
                        }

                        public void setLineOrientationRef(int i7) {
                            this.LineOrientationRef = i7;
                        }

                        public void setLineRef(int i7) {
                            this.LineRef = i7;
                        }

                        public void setLineVariantRef(int i7) {
                            this.LineVariantRef = i7;
                        }

                        public void setLocationAccuracy(double d) {
                            this.LocationAccuracy = d;
                        }

                        public void setLongitude(double d) {
                            this.Longitude = d;
                        }

                        public void setOperatorRef(int i7) {
                            this.OperatorRef = i7;
                        }

                        public void setPosition(int i7) {
                            this.Position = i7;
                        }

                        public void setRssi(int i7) {
                            this.Rssi = i7;
                        }

                        public void setStartDeviceTimeStamp(String str2) {
                            this.StartDeviceTimeStamp = str2;
                        }

                        public void setStopRef(int i7) {
                            this.StopRef = i7;
                        }

                        public void setValidationTimestamp(String str2) {
                            this.ValidationTimestamp = str2;
                        }

                        public void setVehicle(int i7) {
                            this.Vehicle = i7;
                        }

                        public void setZoneRef(int i7) {
                            this.ZoneRef = i7;
                        }
                    });
                }
            }
        }
        return arrayList;
    }
}
