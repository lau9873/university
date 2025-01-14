package h.a.a;

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
/* compiled from: DataManager.java */
/* loaded from: classes.dex */
public class n {
    public static volatile n m;

    /* renamed from: a  reason: collision with root package name */
    public final Object f6684a = new Object();

    /* renamed from: b  reason: collision with root package name */
    public final Object f6685b = new Object();

    /* renamed from: c  reason: collision with root package name */
    public final Object f6686c = new Object();

    /* renamed from: d  reason: collision with root package name */
    public final Object f6687d = new Object();

    /* renamed from: e  reason: collision with root package name */
    public final Object f6688e = new Object();

    /* renamed from: f  reason: collision with root package name */
    public final Object f6689f = new Object();

    /* renamed from: g  reason: collision with root package name */
    public final Object f6690g = new Object();

    /* renamed from: h  reason: collision with root package name */
    public final Object f6691h = new Object();

    /* renamed from: i  reason: collision with root package name */
    public final Object f6692i = new Object();
    public final Object j = new Object();
    public final Object k = new Object();
    public final v0 l = v0.DATABASE;

    /* compiled from: DataManager.java */
    /* loaded from: classes.dex */
    public class a extends d.c.u<DataModels.User> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ String f6693a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ String f6694b;

        /* compiled from: DataManager.java */
        /* renamed from: h.a.a.n$a$a  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        public class C0147a implements BackendListeners.d {

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ d.c.w f6696a;

            /* compiled from: DataManager.java */
            /* renamed from: h.a.a.n$a$a$a  reason: collision with other inner class name */
            /* loaded from: classes.dex */
            public class C0148a implements d.c.e0.f<Object> {

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ DataModels.User f6698a;

                public C0148a(DataModels.User user) {
                    this.f6698a = user;
                }

                @Override // d.c.e0.f
                public void accept(Object obj) {
                    h.a.a.v.d().h(this.f6698a.getEmail());
                    C0147a.this.f6696a.b(this.f6698a);
                }
            }

            /* compiled from: DataManager.java */
            /* renamed from: h.a.a.n$a$a$b */
            /* loaded from: classes.dex */
            public class b implements d.c.e0.f<Throwable> {
                public b() {
                }

                @Override // d.c.e0.f
                /* renamed from: a */
                public void accept(Throwable th) {
                    C0147a.this.f6696a.a(th);
                }
            }

            public C0147a(d.c.w wVar) {
                this.f6696a = wVar;
            }

            @Override // pt.card4b.backendbeacons.BackendListeners.d
            public void a(DataModelDTOs$CustomerAccountDTO dataModelDTOs$CustomerAccountDTO) {
                try {
                    h.a.a.c.a("LOGIC_USER", "DataManager", "login:AsyncTask:doInBackground", "Customer is " + dataModelDTOs$CustomerAccountDTO.getName());
                    DataModels.User user = dataModelDTOs$CustomerAccountDTO.toUser();
                    n.this.a(user).subscribe(new C0148a(user), new b());
                } catch (ClassCastException e2) {
                    e2.printStackTrace();
                    this.f6696a.a(new DataModels.g(DataModels.Error.internal(e2.getLocalizedMessage())));
                }
            }

            @Override // pt.card4b.backendbeacons.BackendListeners.BaseRequestListener
            public void onError(DataModels.Error error) {
                this.f6696a.a(new DataModels.g(error));
            }
        }

        public a(String str, String str2) {
            this.f6693a = str;
            this.f6694b = str2;
        }

        @Override // d.c.u
        public void subscribeActual(d.c.w<? super DataModels.User> wVar) {
            boolean z = h.a.a.v.d().f() == null;
            String h2 = h.a.a.v.d().h();
            if (h2 == null) {
                wVar.a(new DataModels.g(DataModels.Error.missingRegistrationKey()));
            } else {
                h.a.a.h.d().a(this.f6693a, this.f6694b, h.a.a.p.f(), h2, z, new C0147a(wVar));
            }
        }
    }

    /* compiled from: DataManager.java */
    /* loaded from: classes.dex */
    public class a0 extends d.c.u<List<DataModels.PaymentMethod>> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ String f6701a;

        /* compiled from: DataManager.java */
        /* loaded from: classes.dex */
        public class a implements BackendListeners.h<List<DataModelDTOs$PaymentMethodDTO>> {

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ d.c.w f6702a;

            public a(a0 a0Var, d.c.w wVar) {
                this.f6702a = wVar;
            }

            @Override // pt.card4b.backendbeacons.BackendListeners.BaseRequestListener
            public void onError(DataModels.Error error) {
                this.f6702a.a(new DataModels.g(error));
            }

            @Override // pt.card4b.backendbeacons.BackendListeners.h
            /* renamed from: onSuccess */
            public void a(List<DataModelDTOs$PaymentMethodDTO> list) {
                ArrayList arrayList = new ArrayList();
                for (DataModelDTOs$PaymentMethodDTO dataModelDTOs$PaymentMethodDTO : list) {
                    arrayList.add(dataModelDTOs$PaymentMethodDTO.toPaymentMethod());
                }
                this.f6702a.b(arrayList);
            }
        }

        public a0(n nVar, String str) {
            this.f6701a = str;
        }

        @Override // d.c.u
        public void subscribeActual(d.c.w<? super List<DataModels.PaymentMethod>> wVar) {
            h.a.a.h.d().c(this.f6701a, new a(this, wVar));
        }
    }

    /* compiled from: DataManager.java */
    /* loaded from: classes.dex */
    public class b extends d.c.u<Object> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ String f6703a;

        /* compiled from: DataManager.java */
        /* loaded from: classes.dex */
        public class a extends c.d.b.w.a<ArrayList<DataModelDTOs$LineDirectionDTO>> {
            public a(b bVar) {
            }
        }

        public b(String str) {
            this.f6703a = str;
        }

        @Override // d.c.u
        public void subscribeActual(d.c.w<? super Object> wVar) {
            c.d.b.g gVar = new c.d.b.g();
            gVar.a("yyyy-MM-dd'T'hh:mm:ss");
            c.d.b.f a2 = gVar.a();
            String str = this.f6703a;
            if (str == null) {
                str = "[]";
            }
            List list = (List) a2.a(str, new a(this).getType());
            h.a.a.l.k().m().clear();
            if (j0.f6763a[n.this.l.ordinal()] != 1) {
                return;
            }
            n.this.e(list, wVar);
        }
    }

    /* compiled from: DataManager.java */
    /* loaded from: classes.dex */
    public class b0 implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ List f6705a;

        public b0(List list) {
            this.f6705a = list;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                ArrayList arrayList = new ArrayList();
                for (DataModelDTOs$CountryDTO dataModelDTOs$CountryDTO : this.f6705a) {
                    arrayList.add(new DataModelDBOs$TableCountry(dataModelDTOs$CountryDTO));
                }
                synchronized (n.this.j) {
                    Database.r().c(arrayList);
                }
                h.a.a.v.d().d(true);
                h.a.a.c.a("LOGIC_OTHER", "DataManager", "countriesDatabase", "Saved countries to database!");
            } catch (Throwable th) {
                h.a.a.c.a("LOGIC_OTHER", "DataManager", "countriesDatabase", "Error saving countries:" + Log.getStackTraceString(th));
            }
        }
    }

    /* compiled from: DataManager.java */
    /* loaded from: classes.dex */
    public class c extends d.c.u<Object> {

        /* compiled from: DataManager.java */
        /* loaded from: classes.dex */
        public class a implements BackendListeners.h<ResponseDTOs$DeviceInstallResponseDTO> {

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ d.c.w f6707a;

            public a(c cVar, d.c.w wVar) {
                this.f6707a = wVar;
            }

            @Override // pt.card4b.backendbeacons.BackendListeners.BaseRequestListener
            public void onError(DataModels.Error error) {
                this.f6707a.a(new DataModels.g(error));
            }

            @Override // pt.card4b.backendbeacons.BackendListeners.h
            public void a(ResponseDTOs$DeviceInstallResponseDTO responseDTOs$DeviceInstallResponseDTO) {
                h.a.a.v.d().i(responseDTOs$DeviceInstallResponseDTO.RegistrationKey);
                this.f6707a.b(DataModels.EMPTY_OBJECT);
            }
        }

        public c(n nVar) {
        }

        @Override // d.c.u
        public void subscribeActual(d.c.w<? super Object> wVar) {
            String b2;
            String str;
            try {
                if (!(h.a.a.v.d().h() != null)) {
                    if (Build.VERSION.SDK_INT >= 29) {
                        str = h.a.a.p.a();
                        b2 = null;
                    } else {
                        b2 = h.a.a.p.b();
                        str = null;
                    }
                    h.a.a.h.d().a(h.a.a.p.h(), b2, str, h.a.a.p.d(), h.a.a.p.f(), new a(this, wVar));
                    return;
                }
                wVar.b(DataModels.EMPTY_OBJECT);
            } catch (Throwable th) {
                if (th instanceof BackEndExceptions$PhoneStatePermissionException) {
                    wVar.a(new DataModels.g(DataModels.Error.phonestatePermission()));
                } else {
                    wVar.a(new DataModels.g(DataModels.Error.internal("Failed to verify/install the device (verifyAndInstallDevice)")));
                }
            }
        }
    }

    /* compiled from: DataManager.java */
    /* loaded from: classes.dex */
    public class c0 extends d.c.u<DataModels.e> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ String f6708a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ String f6709b;

        /* compiled from: DataManager.java */
        /* loaded from: classes.dex */
        public class a implements BackendListeners.g {

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ d.c.w f6710a;

            public a(c0 c0Var, d.c.w wVar) {
                this.f6710a = wVar;
            }

            @Override // pt.card4b.backendbeacons.BackendListeners.g
            public void a(Date date, boolean z, Date date2, boolean z2, String str, String str2) {
                this.f6710a.b(new DataModels.e(date, z, date2, z2, str, str2));
            }

            @Override // pt.card4b.backendbeacons.BackendListeners.BaseRequestListener
            public void onError(DataModels.Error error) {
                this.f6710a.a(new DataModels.g(error));
            }
        }

        public c0(n nVar, String str, String str2) {
            this.f6708a = str;
            this.f6709b = str2;
        }

        @Override // d.c.u
        public void subscribeActual(d.c.w<? super DataModels.e> wVar) {
            String h2 = h.a.a.v.d().h();
            if (h2 == null) {
                wVar.a(new DataModels.g(DataModels.Error.missingRegistrationKey()));
            } else {
                h.a.a.h.d().a(this.f6708a, h2, this.f6709b, new a(this, wVar));
            }
        }
    }

    /* compiled from: DataManager.java */
    /* loaded from: classes.dex */
    public class d extends d.c.u<Object> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ String f6711a;

        /* compiled from: DataManager.java */
        /* loaded from: classes.dex */
        public class a extends c.d.b.w.a<ArrayList<DataModelDTOs$LineVariantDTO>> {
            public a(d dVar) {
            }
        }

        public d(String str) {
            this.f6711a = str;
        }

        @Override // d.c.u
        public void subscribeActual(d.c.w<? super Object> wVar) {
            c.d.b.g gVar = new c.d.b.g();
            gVar.a("yyyy-MM-dd'T'hh:mm:ss");
            c.d.b.f a2 = gVar.a();
            String str = this.f6711a;
            if (str == null) {
                str = "[]";
            }
            List list = (List) a2.a(str, new a(this).getType());
            h.a.a.l.k().n().clear();
            if (j0.f6763a[n.this.l.ordinal()] != 1) {
                return;
            }
            n.this.f(list, wVar);
        }
    }

    /* compiled from: DataManager.java */
    /* loaded from: classes.dex */
    public class d0 implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ List f6713a;

        public d0(List list) {
            this.f6713a = list;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                ArrayList arrayList = new ArrayList();
                for (DataModelDTOs$LanguageDTO dataModelDTOs$LanguageDTO : this.f6713a) {
                    arrayList.add(new DataModelDBOs$TableLanguage(dataModelDTOs$LanguageDTO));
                }
                synchronized (n.this.k) {
                    Database.r().e(arrayList);
                }
                h.a.a.v.d().f(true);
                h.a.a.c.a("LOGIC_OTHER", "DataManager", "languagesDatabase", "Saved languages to database!");
            } catch (Throwable th) {
                h.a.a.c.a("LOGIC_OTHER", "DataManager", "languagesDatabase", "Error saving languages:" + Log.getStackTraceString(th));
            }
        }
    }

    /* compiled from: DataManager.java */
    /* loaded from: classes.dex */
    public class e extends d.c.u<DataModels.NewStageStartInfo> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ List f6715a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ boolean f6716b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ String f6717c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ String f6718d;

        /* compiled from: DataManager.java */
        /* loaded from: classes.dex */
        public class a implements BackendListeners.h<String> {

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ Date f6720a;

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ long f6721b;

            /* renamed from: c  reason: collision with root package name */
            public final /* synthetic */ d.c.w f6722c;

            /* renamed from: d  reason: collision with root package name */
            public final /* synthetic */ int f6723d;

            public a(Date date, long j, d.c.w wVar, int i2) {
                this.f6720a = date;
                this.f6721b = j;
                this.f6722c = wVar;
                this.f6723d = i2;
            }

            @Override // pt.card4b.backendbeacons.BackendListeners.BaseRequestListener
            public void onError(DataModels.Error error) {
                this.f6722c.a(new DataModels.g(error));
            }

            @Override // pt.card4b.backendbeacons.BackendListeners.h
            /* renamed from: onSuccess */
            public void a(String str) {
                h.a.a.w.d().a(this.f6720a, this.f6721b);
                h.a.a.v.d().e(e.this.f6717c);
                h.a.a.v.d().a(Long.valueOf(h.a.a.p.a(this.f6720a)));
                h.a.a.v.d().E();
                if (!e.this.f6716b) {
                    h.a.a.v.d().a(e.this.f6717c, new Date(h.a.a.p.a(this.f6720a) + ((h.a.a.l.k().g().containsKey("START_OFFLINE_RANGE_MINS") ? Integer.parseInt(h.a.a.l.k().g().get("START_OFFLINE_RANGE_MINS").a()) : 720) * 60 * 1000)), null);
                } else {
                    AbstractMap.SimpleEntry<Date, String> b2 = h.a.a.v.d().b(e.this.f6717c);
                    int parseInt = h.a.a.l.k().g().containsKey("START_OFFLINE_EXTENSION_MINS") ? Integer.parseInt(h.a.a.l.k().g().get("START_OFFLINE_EXTENSION_MINS").a()) : 60;
                    if (b2 != null && b2.getKey().before(new Date(h.a.a.p.a(this.f6720a) + (parseInt * 60 * 1000)))) {
                        h.a.a.v.d().a(e.this.f6717c, parseInt);
                    }
                }
                this.f6722c.b(new DataModels.NewStageStartInfo(str, this.f6720a, e.this.f6716b, this.f6723d));
            }
        }

        public e(List list, boolean z, String str, String str2) {
            this.f6715a = list;
            this.f6716b = z;
            this.f6717c = str;
            this.f6718d = str2;
        }

        @Override // d.c.u
        public void subscribeActual(d.c.w<? super DataModels.NewStageStartInfo> wVar) {
            String f2 = h.a.a.p.f();
            List<DataModelDTOs$StageInformationBeaconDTO> a2 = n.this.a(this.f6715a);
            long j = 0;
            Date date = null;
            for (DataModels.b bVar : this.f6715a) {
                Iterator<DataModels.a> it = bVar.b().iterator();
                while (true) {
                    if (it.hasNext()) {
                        DataModels.a next = it.next();
                        if (next.l() != null) {
                            date = next.l();
                            j = next.m();
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
                Date f3 = h.a.a.w.d().f();
                j = SystemClock.elapsedRealtime();
                date = f3;
            }
            String uuid = this.f6716b ? UUID.randomUUID().toString() : null;
            int c2 = h.a.a.v.d().c(this.f6717c);
            DataModels.Error w = h.a.a.l.k().w();
            if (this.f6716b && w != null) {
                h.a.a.c.a("LOGIC_BEACONS", "DataManager", "stageStart", "start stage offline not authorized");
                wVar.a(new DataModels.g(w));
                return;
            }
            h.a.a.h.d().a(uuid, this.f6717c, f2, h.a.a.p.b(date), (String) null, a2, this.f6716b, c2, this.f6718d, new a(date, j, wVar, c2));
        }
    }

    /* compiled from: DataManager.java */
    /* loaded from: classes.dex */
    public class e0 extends d.c.u<Object> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ String f6725a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ String f6726b;

        /* compiled from: DataManager.java */
        /* loaded from: classes.dex */
        public class a implements BackendListeners.l {

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ d.c.w f6727a;

            public a(e0 e0Var, d.c.w wVar) {
                this.f6727a = wVar;
            }

            @Override // pt.card4b.backendbeacons.BackendListeners.BaseRequestListener
            public void onError(DataModels.Error error) {
                this.f6727a.a(new DataModels.g(error));
            }

            @Override // pt.card4b.backendbeacons.BackendListeners.l
            public void onSuccess() {
                this.f6727a.b(DataModels.EMPTY_OBJECT);
            }
        }

        public e0(n nVar, String str, String str2) {
            this.f6725a = str;
            this.f6726b = str2;
        }

        @Override // d.c.u
        public void subscribeActual(d.c.w<? super Object> wVar) {
            h.a.a.h.d().a(this.f6725a, this.f6726b, new a(this, wVar));
        }
    }

    /* compiled from: DataManager.java */
    /* loaded from: classes.dex */
    public class f extends d.c.u<Object> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ String f6728a;

        /* compiled from: DataManager.java */
        /* loaded from: classes.dex */
        public class a extends c.d.b.w.a<ArrayList<DataModelDTOs$BeaconInformationTypeDTO>> {
            public a(f fVar) {
            }
        }

        public f(String str) {
            this.f6728a = str;
        }

        @Override // d.c.u
        public void subscribeActual(d.c.w<? super Object> wVar) {
            c.d.b.g gVar = new c.d.b.g();
            gVar.a("yyyy-MM-dd'T'hh:mm:ss");
            c.d.b.f a2 = gVar.a();
            String str = this.f6728a;
            if (str == null) {
                str = "[]";
            }
            List list = (List) a2.a(str, new a(this).getType());
            h.a.a.l.k().f().clear();
            if (j0.f6763a[n.this.l.ordinal()] != 1) {
                return;
            }
            n.this.a(list, wVar);
        }
    }

    /* compiled from: DataManager.java */
    /* loaded from: classes.dex */
    public class f0 implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ List f6730a;

        public f0(List list) {
            this.f6730a = list;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                synchronized (n.this.f6688e) {
                    List<DataModelDBOs$TableConfiguration> c2 = Database.r().c();
                    HashMap hashMap = new HashMap();
                    for (DataModelDTOs$ConfigurationDTO dataModelDTOs$ConfigurationDTO : this.f6730a) {
                        DataModelDBOs$TableConfiguration dataModelDBOs$TableConfiguration = new DataModelDBOs$TableConfiguration(dataModelDTOs$ConfigurationDTO);
                        hashMap.put(dataModelDBOs$TableConfiguration.d(), dataModelDBOs$TableConfiguration);
                    }
                    for (DataModelDBOs$TableConfiguration dataModelDBOs$TableConfiguration2 : c2) {
                        if (!hashMap.containsKey(dataModelDBOs$TableConfiguration2.d())) {
                            Database.r().b(dataModelDBOs$TableConfiguration2);
                        }
                    }
                    Database.r().b(new ArrayList(hashMap.values()));
                }
                h.a.a.v.d().c(true);
                h.a.a.c.a("LOGIC_OTHER", "DataManager", "configurationsDatabase", "Saved configurations to database!");
            } catch (Throwable th) {
                h.a.a.c.a("LOGIC_OTHER", "DataManager", "configurationsDatabase", "Error saving configurations:" + Log.getStackTraceString(th));
                h.a.a.v.d().c(false);
            }
        }
    }

    /* compiled from: DataManager.java */
    /* loaded from: classes.dex */
    public class g extends d.c.u<Object> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ List f6732a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ String f6733b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ String f6734c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ Date f6735d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ boolean f6736e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ int f6737f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ String f6738g;

        /* compiled from: DataManager.java */
        /* loaded from: classes.dex */
        public class a implements BackendListeners.o {

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ d.c.w f6740a;

            public a(g gVar, d.c.w wVar) {
                this.f6740a = wVar;
            }

            @Override // pt.card4b.backendbeacons.BackendListeners.BaseRequestListener
            public void onError(DataModels.Error error) {
                this.f6740a.a(new DataModels.g(error));
            }

            @Override // pt.card4b.backendbeacons.BackendListeners.o
            public void onSuccess() {
                this.f6740a.b(DataModels.EMPTY_OBJECT);
            }
        }

        public g(List list, String str, String str2, Date date, boolean z, int i2, String str3) {
            this.f6732a = list;
            this.f6733b = str;
            this.f6734c = str2;
            this.f6735d = date;
            this.f6736e = z;
            this.f6737f = i2;
            this.f6738g = str3;
        }

        @Override // d.c.u
        public void subscribeActual(d.c.w<? super Object> wVar) {
            h.a.a.c.a("LOGIC_BEACONS", "DataManager", "stageUpdate", "new beaconsDTO");
            List<DataModelDTOs$StageInformationBeaconDTO> a2 = n.this.a(this.f6732a);
            h.a.a.h.d().a(this.f6733b, this.f6734c, h.a.a.p.f(), h.a.a.p.b(this.f6735d), (String) null, a2, this.f6736e, this.f6737f, this.f6738g, new a(this, wVar));
        }
    }

    /* compiled from: DataManager.java */
    /* loaded from: classes.dex */
    public class g0 extends d.c.u<DataModels.UserAccountInfo> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ String f6741a;

        /* compiled from: DataManager.java */
        /* loaded from: classes.dex */
        public class a implements BackendListeners.h<DataModelDTOs$CustomerAccountDTO> {

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ d.c.w f6742a;

            public a(g0 g0Var, d.c.w wVar) {
                this.f6742a = wVar;
            }

            @Override // pt.card4b.backendbeacons.BackendListeners.BaseRequestListener
            public void onError(DataModels.Error error) {
                this.f6742a.a(new DataModels.g(error));
            }

            @Override // pt.card4b.backendbeacons.BackendListeners.h
            public void a(DataModelDTOs$CustomerAccountDTO dataModelDTOs$CustomerAccountDTO) {
                try {
                    this.f6742a.b(dataModelDTOs$CustomerAccountDTO.toAccountInfo());
                } catch (ClassCastException e2) {
                    this.f6742a.a(new DataModels.g(DataModels.Error.internal(e2.getLocalizedMessage())));
                }
            }
        }

        public g0(n nVar, String str) {
            this.f6741a = str;
        }

        @Override // d.c.u
        public void subscribeActual(d.c.w<? super DataModels.UserAccountInfo> wVar) {
            h.a.a.h.d().b(this.f6741a, new a(this, wVar));
        }
    }

    /* compiled from: DataManager.java */
    /* loaded from: classes.dex */
    public class h extends d.c.u<Object> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ String f6743a;

        /* compiled from: DataManager.java */
        /* loaded from: classes.dex */
        public class a extends c.d.b.w.a<ArrayList<DataModelDTOs$CountryDTO>> {
            public a(h hVar) {
            }
        }

        public h(String str) {
            this.f6743a = str;
        }

        @Override // d.c.u
        public void subscribeActual(d.c.w<? super Object> wVar) {
            c.d.b.g gVar = new c.d.b.g();
            gVar.a("yyyy-MM-dd'T'hh:mm:ss");
            c.d.b.f a2 = gVar.a();
            String str = this.f6743a;
            if (str == null) {
                str = "[]";
            }
            List list = (List) a2.a(str, new a(this).getType());
            h.a.a.l.k().h().clear();
            if (j0.f6763a[n.this.l.ordinal()] != 1) {
                return;
            }
            n.this.b(list, wVar);
        }
    }

    /* compiled from: DataManager.java */
    /* loaded from: classes.dex */
    public class h0 implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ List f6745a;

        public h0(List list) {
            this.f6745a = list;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                ArrayList arrayList = new ArrayList();
                for (DataModelDTOs$CustomerProfileDTO dataModelDTOs$CustomerProfileDTO : this.f6745a) {
                    arrayList.add(new DataModelDBOs$TableCustomerProfile(dataModelDTOs$CustomerProfileDTO));
                }
                synchronized (n.this.f6692i) {
                    Database.r().d(arrayList);
                }
                h.a.a.v.d().e(true);
                h.a.a.c.a("LOGIC_OTHER", "DataManager", "customerProfilesDatabase", "Saved customer profiles to database!");
            } catch (Throwable th) {
                h.a.a.c.a("LOGIC_OTHER", "DataManager", "customerProfilesDatabase", "Error saving customer profiles:" + Log.getStackTraceString(th));
            }
        }
    }

    /* compiled from: DataManager.java */
    /* loaded from: classes.dex */
    public class i extends d.c.u<Object> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ List f6747a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ String f6748b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ Date f6749c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ String f6750d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f6751e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ boolean f6752f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ int f6753g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ String f6754h;

        /* compiled from: DataManager.java */
        /* loaded from: classes.dex */
        public class a implements BackendListeners.o {

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ d.c.w f6756a;

            public a(d.c.w wVar) {
                this.f6756a = wVar;
            }

            @Override // pt.card4b.backendbeacons.BackendListeners.BaseRequestListener
            public void onError(DataModels.Error error) {
                this.f6756a.a(new DataModels.g(error));
            }

            @Override // pt.card4b.backendbeacons.BackendListeners.o
            public void onSuccess() {
                h.a.a.c.d(i.this.f6750d);
                h.a.a.v.d().a((Long) 0L);
                h.a.a.v.d().E();
                h.a.a.w.d().a();
                this.f6756a.b(DataModels.EMPTY_OBJECT);
            }
        }

        public i(List list, String str, Date date, String str2, String str3, boolean z, int i2, String str4) {
            this.f6747a = list;
            this.f6748b = str;
            this.f6749c = date;
            this.f6750d = str2;
            this.f6751e = str3;
            this.f6752f = z;
            this.f6753g = i2;
            this.f6754h = str4;
        }

        @Override // d.c.u
        public void subscribeActual(d.c.w<? super Object> wVar) {
            List<DataModelDTOs$StageInformationBeaconDTO> a2 = n.this.a(this.f6747a);
            String f2 = h.a.a.p.f();
            Date e2 = h.a.a.w.d().e();
            if (this.f6748b.equals(DataModels.o.p)) {
                Date date = new Date(h.a.a.v.d().e().longValue());
                if (date.after(this.f6749c)) {
                    e2 = date;
                }
            }
            h.a.a.h.d().a(this.f6750d, this.f6751e, this.f6748b, f2, h.a.a.p.b(this.f6749c), h.a.a.p.b(e2), a2, this.f6752f, this.f6753g, this.f6754h, new a(wVar));
        }
    }

    /* compiled from: DataManager.java */
    /* loaded from: classes.dex */
    public class i0 extends d.c.u<Object> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ String f6758a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ String f6759b;

        /* compiled from: DataManager.java */
        /* loaded from: classes.dex */
        public class a implements BackendListeners.m {

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ d.c.w f6760a;

            public a(i0 i0Var, d.c.w wVar) {
                this.f6760a = wVar;
            }

            @Override // pt.card4b.backendbeacons.BackendListeners.BaseRequestListener
            public void onError(DataModels.Error error) {
                this.f6760a.a(new DataModels.g(error));
            }

            @Override // pt.card4b.backendbeacons.BackendListeners.m
            public void onSuccess() {
                this.f6760a.b(DataModels.EMPTY_OBJECT);
            }
        }

        public i0(n nVar, String str, String str2) {
            this.f6758a = str;
            this.f6759b = str2;
        }

        @Override // d.c.u
        public void subscribeActual(d.c.w<? super Object> wVar) {
            h.a.a.h.d().a(this.f6758a, this.f6759b, new a(this, wVar));
        }
    }

    /* compiled from: DataManager.java */
    /* loaded from: classes.dex */
    public class j extends d.c.u<Object> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ String f6761a;

        /* compiled from: DataManager.java */
        /* loaded from: classes.dex */
        public class a extends c.d.b.w.a<ArrayList<DataModelDTOs$LanguageDTO>> {
            public a(j jVar) {
            }
        }

        public j(String str) {
            this.f6761a = str;
        }

        @Override // d.c.u
        public void subscribeActual(d.c.w<? super Object> wVar) {
            c.d.b.g gVar = new c.d.b.g();
            gVar.a("yyyy-MM-dd'T'hh:mm:ss");
            c.d.b.f a2 = gVar.a();
            String str = this.f6761a;
            if (str == null) {
                str = "[]";
            }
            List list = (List) a2.a(str, new a(this).getType());
            h.a.a.l.k().l().clear();
            if (j0.f6763a[n.this.l.ordinal()] != 1) {
                return;
            }
            n.this.d(list, wVar);
        }
    }

    /* compiled from: DataManager.java */
    /* loaded from: classes.dex */
    public static /* synthetic */ class j0 {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f6763a;

        static {
            int[] iArr = new int[v0.values().length];
            f6763a = iArr;
            try {
                iArr[v0.DATABASE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
        }
    }

    /* compiled from: DataManager.java */
    /* loaded from: classes.dex */
    public class k implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ List f6764a;

        public k(List list) {
            this.f6764a = list;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                ArrayList arrayList = new ArrayList();
                for (DataModelDTOs$TransportOperatorDTO dataModelDTOs$TransportOperatorDTO : this.f6764a) {
                    arrayList.add(new DataModelDBOs$TableOperator(dataModelDTOs$TransportOperatorDTO));
                }
                synchronized (n.this.f6684a) {
                    Database.r().i(arrayList);
                }
                h.a.a.v.d().j(true);
                h.a.a.c.a("LOGIC_OTHER", "DataManager", "operatorsDatabase", "Saved operators to database!");
            } catch (Throwable th) {
                h.a.a.c.a("LOGIC_OTHER", "DataManager", "operatorsDatabase", "Error saving operators:" + Log.getStackTraceString(th));
            }
        }
    }

    /* compiled from: DataManager.java */
    /* loaded from: classes.dex */
    public class k0 extends d.c.u<Object> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ String f6766a;

        /* compiled from: DataManager.java */
        /* loaded from: classes.dex */
        public class a extends c.d.b.w.a<ArrayList<DataModelDTOs$TransportOperatorDTO>> {
            public a(k0 k0Var) {
            }
        }

        public k0(String str) {
            this.f6766a = str;
        }

        @Override // d.c.u
        public void subscribeActual(d.c.w<? super Object> wVar) {
            c.d.b.g gVar = new c.d.b.g();
            gVar.a("yyyy-MM-dd'T'hh:mm:ss");
            c.d.b.f a2 = gVar.a();
            String str = this.f6766a;
            if (str == null) {
                str = "[]";
            }
            List list = (List) a2.a(str, new a(this).getType());
            h.a.a.l.k().r().clear();
            h.a.a.l.k().q().clear();
            if (j0.f6763a[n.this.l.ordinal()] != 1) {
                return;
            }
            n.this.h(list, wVar);
        }
    }

    /* compiled from: DataManager.java */
    /* loaded from: classes.dex */
    public class l extends d.c.u<DataModels.User> {
        public l(n nVar) {
        }

        @Override // d.c.u
        public void subscribeActual(d.c.w<? super DataModels.User> wVar) {
            DataModels.User k = h.a.a.v.d().k();
            if (k != null) {
                wVar.b(k);
            } else {
                wVar.a(new DataModels.g(DataModels.Error.internal("User session has expired!")));
            }
        }
    }

    /* compiled from: DataManager.java */
    /* loaded from: classes.dex */
    public class l0 extends d.c.u<Object> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ String f6768a;

        /* compiled from: DataManager.java */
        /* loaded from: classes.dex */
        public class a implements BackendListeners.j {

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ d.c.w f6769a;

            public a(l0 l0Var, d.c.w wVar) {
                this.f6769a = wVar;
            }

            @Override // pt.card4b.backendbeacons.BackendListeners.BaseRequestListener
            public void onError(DataModels.Error error) {
                this.f6769a.a(new DataModels.g(error));
            }

            @Override // pt.card4b.backendbeacons.BackendListeners.j
            public void onSuccess() {
                this.f6769a.b(DataModels.EMPTY_OBJECT);
            }
        }

        public l0(n nVar, String str) {
            this.f6768a = str;
        }

        @Override // d.c.u
        public void subscribeActual(d.c.w<? super Object> wVar) {
            h.a.a.h.d().a(this.f6768a, new a(this, wVar));
        }
    }

    /* compiled from: DataManager.java */
    /* loaded from: classes.dex */
    public class m implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ List f6770a;

        public m(List list) {
            this.f6770a = list;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                ArrayList arrayList = new ArrayList();
                for (DataModelDTOs$StopDTO dataModelDTOs$StopDTO : this.f6770a) {
                    arrayList.add(new DataModelDBOs$TableStop(dataModelDTOs$StopDTO));
                }
                synchronized (n.this.f6685b) {
                    Database.r().C();
                    Database.r().j(arrayList);
                    Database.r().A();
                }
                h.a.a.v.d().k(true);
                h.a.a.c.a("LOGIC_OTHER", "DataManager", "stopsDatabase", "Saved stops to database!");
            } catch (Throwable th) {
                h.a.a.c.a("LOGIC_OTHER", "DataManager", "stopsDatabase", "Error saving stops:" + Log.getStackTraceString(th));
            }
        }
    }

    /* compiled from: DataManager.java */
    /* loaded from: classes.dex */
    public class m0 extends d.c.u<Object> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ String f6772a;

        /* compiled from: DataManager.java */
        /* loaded from: classes.dex */
        public class a extends c.d.b.w.a<ArrayList<DataModelDTOs$StopDTO>> {
            public a(m0 m0Var) {
            }
        }

        public m0(String str) {
            this.f6772a = str;
        }

        @Override // d.c.u
        public void subscribeActual(d.c.w<? super Object> wVar) {
            c.d.b.g gVar = new c.d.b.g();
            gVar.a("yyyy-MM-dd'T'hh:mm:ss");
            c.d.b.f a2 = gVar.a();
            String str = this.f6772a;
            if (str == null) {
                str = "[]";
            }
            List list = (List) a2.a(str, new a(this).getType());
            h.a.a.l.k().s().clear();
            h.a.a.c.a("LOGIC_OTHER", "DataManager", "dealWithAPIStops", "apiStops.size = " + list.size());
            if (j0.f6763a[n.this.l.ordinal()] != 1) {
                return;
            }
            n.this.i(list, wVar);
        }
    }

    /* compiled from: DataManager.java */
    /* renamed from: h.a.a.n$n  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0149n extends d.c.u<Boolean> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ String f6774a;

        public C0149n(n nVar, String str) {
            this.f6774a = str;
        }

        @Override // d.c.u
        public void subscribeActual(d.c.w<? super Boolean> wVar) {
            wVar.b(Boolean.valueOf(h.a.a.v.d().d(this.f6774a)));
        }
    }

    /* compiled from: DataManager.java */
    /* loaded from: classes.dex */
    public class n0 extends d.c.u<Boolean> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ DataModels.UserAccountInfo f6775a;

        /* compiled from: DataManager.java */
        /* loaded from: classes.dex */
        public class a implements BackendListeners.h<Boolean> {

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ d.c.w f6776a;

            public a(n0 n0Var, d.c.w wVar) {
                this.f6776a = wVar;
            }

            @Override // pt.card4b.backendbeacons.BackendListeners.BaseRequestListener
            public void onError(DataModels.Error error) {
                this.f6776a.a(new DataModels.g(error));
            }

            @Override // pt.card4b.backendbeacons.BackendListeners.h
            public void a(Boolean bool) {
                this.f6776a.b(bool);
            }
        }

        public n0(n nVar, DataModels.UserAccountInfo userAccountInfo) {
            this.f6775a = userAccountInfo;
        }

        @Override // d.c.u
        public void subscribeActual(d.c.w<? super Boolean> wVar) {
            h.a.a.h.d().a(this.f6775a.getEmail(), new DataModelDTOs$CustomerAccountDTO(this.f6775a), new a(this, wVar));
        }
    }

    /* compiled from: DataManager.java */
    /* loaded from: classes.dex */
    public class o extends d.c.u<Object> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ DataModels.UserAccountInfo f6777a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ String f6778b;

        /* compiled from: DataManager.java */
        /* loaded from: classes.dex */
        public class a implements BackendListeners.h<String> {

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ d.c.w f6779a;

            public a(o oVar, d.c.w wVar) {
                this.f6779a = wVar;
            }

            @Override // pt.card4b.backendbeacons.BackendListeners.BaseRequestListener
            public void onError(DataModels.Error error) {
                this.f6779a.a(new DataModels.g(error));
            }

            @Override // pt.card4b.backendbeacons.BackendListeners.h
            /* renamed from: onSuccess */
            public void a(String str) {
                this.f6779a.b(DataModels.EMPTY_OBJECT);
            }
        }

        public o(n nVar, DataModels.UserAccountInfo userAccountInfo, String str) {
            this.f6777a = userAccountInfo;
            this.f6778b = str;
        }

        @Override // d.c.u
        public void subscribeActual(d.c.w<? super Object> wVar) {
            h.a.a.h.d().a(new DataModelDTOs$CustomerAccountDTO(this.f6777a, this.f6778b), h.a.a.p.f(), new a(this, wVar));
        }
    }

    /* compiled from: DataManager.java */
    /* loaded from: classes.dex */
    public class o0 extends d.c.u<Object> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ String f6780a;

        /* compiled from: DataManager.java */
        /* loaded from: classes.dex */
        public class a extends c.d.b.w.a<ArrayList<DataModelDTOs$LineDTO>> {
            public a(o0 o0Var) {
            }
        }

        public o0(String str) {
            this.f6780a = str;
        }

        @Override // d.c.u
        public void subscribeActual(d.c.w<? super Object> wVar) {
            c.d.b.g gVar = new c.d.b.g();
            gVar.a("yyyy-MM-dd'T'hh:mm:ss");
            c.d.b.f a2 = gVar.a();
            String str = this.f6780a;
            if (str == null) {
                str = "[]";
            }
            List list = (List) a2.a(str, new a(this).getType());
            h.a.a.l.k().o().clear();
            if (j0.f6763a[n.this.l.ordinal()] != 1) {
                return;
            }
            n.this.g(list, wVar);
        }
    }

    /* compiled from: DataManager.java */
    /* loaded from: classes.dex */
    public class p extends d.c.u<Object> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ String f6782a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ DataModels.p f6783b;

        public p(n nVar, String str, DataModels.p pVar) {
            this.f6782a = str;
            this.f6783b = pVar;
        }

        @Override // d.c.u
        public void subscribeActual(d.c.w<? super Object> wVar) {
            if (h.a.a.v.d().a(this.f6782a, this.f6783b)) {
                wVar.b(DataModels.EMPTY_OBJECT);
            } else {
                wVar.a(new DataModels.g(DataModels.Error.internal("failed to save stage state")));
            }
        }
    }

    /* compiled from: DataManager.java */
    /* loaded from: classes.dex */
    public class p0 extends d.c.u<Object> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ String f6784a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ String f6785b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ String f6786c;

        /* compiled from: DataManager.java */
        /* loaded from: classes.dex */
        public class a implements BackendListeners.DefaultRequestListener {

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ d.c.w f6787a;

            public a(p0 p0Var, d.c.w wVar) {
                this.f6787a = wVar;
            }

            @Override // pt.card4b.backendbeacons.BackendListeners.DefaultRequestListener
            public void onError(DataModels.Error error) {
                this.f6787a.a(new DataModels.g(error));
            }

            @Override // pt.card4b.backendbeacons.BackendListeners.DefaultRequestListener
            public void onSuccess() {
                this.f6787a.b(DataModels.EMPTY_OBJECT);
            }
        }

        public p0(n nVar, String str, String str2, String str3) {
            this.f6784a = str;
            this.f6785b = str2;
            this.f6786c = str3;
        }

        @Override // d.c.u
        public void subscribeActual(d.c.w<? super Object> wVar) {
            h.a.a.h.d().a(this.f6784a, this.f6785b, this.f6786c, new a(this, wVar));
        }
    }

    /* compiled from: DataManager.java */
    /* loaded from: classes.dex */
    public class q implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ List f6788a;

        public q(List list) {
            this.f6788a = list;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                ArrayList arrayList = new ArrayList();
                for (DataModelDTOs$LineDTO dataModelDTOs$LineDTO : this.f6788a) {
                    arrayList.add(new DataModelDBOs$TableLine(dataModelDTOs$LineDTO));
                }
                synchronized (n.this.f6686c) {
                    Database.r().B();
                    Database.r().f(arrayList);
                    Database.r().z();
                }
                h.a.a.v.d().i(true);
                h.a.a.c.a("LOGIC_OTHER", "DataManager", "linesDatabase", "Saved lines to database!");
            } catch (Throwable th) {
                h.a.a.c.a("LOGIC_OTHER", "DataManager", "linesDatabase", "Error saving lines:" + Log.getStackTraceString(th));
            }
        }
    }

    /* compiled from: DataManager.java */
    /* loaded from: classes.dex */
    public class q0 extends d.c.u<Object> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ Boolean f6790a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ Boolean f6791b;

        /* compiled from: DataManager.java */
        /* loaded from: classes.dex */
        public class a implements BackendListeners.h<Map<String, String>> {

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ d.c.w f6793a;

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ Date f6794b;

            /* compiled from: DataManager.java */
            /* renamed from: h.a.a.n$q0$a$a  reason: collision with other inner class name */
            /* loaded from: classes.dex */
            public class C0150a implements d.c.e0.f<Object> {
                public C0150a() {
                }

                @Override // d.c.e0.f
                public void accept(Object obj) {
                    h.a.a.c.a("LOGIC_BEACONS", "DataManager", "getApplicationData", "Application data from server loaded successfully");
                    h.a.a.v.d().a(h.a.a.w.d().e());
                    a.this.f6793a.b(DataModels.EMPTY_OBJECT);
                }
            }

            /* compiled from: DataManager.java */
            /* loaded from: classes.dex */
            public class b implements d.c.e0.f<Throwable> {

                /* compiled from: DataManager.java */
                /* renamed from: h.a.a.n$q0$a$b$a  reason: collision with other inner class name */
                /* loaded from: classes.dex */
                public class C0151a implements d.c.e0.f<Object> {
                    public C0151a() {
                    }

                    @Override // d.c.e0.f
                    public void accept(Object obj) {
                        h.a.a.c.a("LOGIC_BEACONS", "DataManager", "getApplicationData", "Current data in the database loaded successfully");
                        a.this.f6793a.b(DataModels.EMPTY_OBJECT);
                    }
                }

                /* compiled from: DataManager.java */
                /* renamed from: h.a.a.n$q0$a$b$b  reason: collision with other inner class name */
                /* loaded from: classes.dex */
                public class C0152b implements d.c.e0.f<Throwable> {
                    public C0152b() {
                    }

                    @Override // d.c.e0.f
                    /* renamed from: a */
                    public void accept(Throwable th) {
                        h.a.a.c.a("LOGIC_BEACONS", "DataManager", "getApplicationData", "Failed to load the current data in the database");
                        a.this.f6793a.a(th);
                    }
                }

                /* compiled from: DataManager.java */
                /* loaded from: classes.dex */
                public class c implements d.c.e0.h<Object, Object, Object, Object, Object> {
                    public c(b bVar) {
                    }

                    @Override // d.c.e0.h
                    public Object apply(Object obj, Object obj2, Object obj3, Object obj4) {
                        return DataModels.EMPTY_OBJECT;
                    }
                }

                /* compiled from: DataManager.java */
                /* loaded from: classes.dex */
                public class d implements d.c.e0.l<Object, Object, Object, Object, Object, Object, Object, Object, Object> {
                    public d(b bVar) {
                    }

                    @Override // d.c.e0.l
                    public Object apply(Object obj, Object obj2, Object obj3, Object obj4, Object obj5, Object obj6, Object obj7, Object obj8) {
                        return DataModels.EMPTY_OBJECT;
                    }
                }

                public b() {
                }

                @Override // d.c.e0.f
                /* renamed from: a */
                public void accept(Throwable th) {
                    h.a.a.c.a("LOGIC_BEACONS", "DataManager", "getApplicationData", "Error processing received application data: " + Log.getStackTraceString(th));
                    DataModels.Error a2 = h.a.a.p.a(th);
                    a aVar = a.this;
                    if (aVar.f6794b != null) {
                        if (q0.this.f6791b.booleanValue()) {
                            d.c.u.zip(d.c.u.zip(n.this.i("[]"), n.this.j("[]"), n.this.k("[]"), n.this.f("[]"), n.this.g("[]"), n.this.h("[]"), n.this.a("[]"), n.this.b("[]"), new d(this)), n.this.d("[]"), n.this.c("[]"), n.this.e("[]"), new c(this)).subscribeOn(d.c.j0.a.b()).subscribe(new C0151a(), new C0152b());
                            return;
                        } else {
                            a.this.f6793a.a(new DataModels.g(a2));
                            return;
                        }
                    }
                    h.a.a.c.a("LOGIC_OTHER", "DataManager", "getApplicationData", "Failed to get the initial data from server.");
                    a.this.f6793a.a(new DataModels.g(a2));
                }
            }

            /* compiled from: DataManager.java */
            /* loaded from: classes.dex */
            public class c implements d.c.e0.h<Object, Object, Object, Object, Object> {
                public c(a aVar) {
                }

                @Override // d.c.e0.h
                public Object apply(Object obj, Object obj2, Object obj3, Object obj4) {
                    return DataModels.EMPTY_OBJECT;
                }
            }

            /* compiled from: DataManager.java */
            /* loaded from: classes.dex */
            public class d implements d.c.e0.l<Object, Object, Object, Object, Object, Object, Object, Object, Object> {
                public d(a aVar) {
                }

                @Override // d.c.e0.l
                public Object apply(Object obj, Object obj2, Object obj3, Object obj4, Object obj5, Object obj6, Object obj7, Object obj8) {
                    return DataModels.EMPTY_OBJECT;
                }
            }

            /* compiled from: DataManager.java */
            /* loaded from: classes.dex */
            public class e implements d.c.e0.f<Object> {
                public e() {
                }

                @Override // d.c.e0.f
                public void accept(Object obj) {
                    h.a.a.c.a("LOGIC_BEACONS", "DataManager", "getApplicationData", "Current data in the database loaded successfully");
                    a.this.f6793a.b(DataModels.EMPTY_OBJECT);
                }
            }

            /* compiled from: DataManager.java */
            /* loaded from: classes.dex */
            public class f implements d.c.e0.f<Throwable> {
                public f() {
                }

                @Override // d.c.e0.f
                /* renamed from: a */
                public void accept(Throwable th) {
                    h.a.a.c.a("LOGIC_BEACONS", "DataManager", "getApplicationData", "Failed to load the current data in the database");
                    a.this.f6793a.a(th);
                }
            }

            /* compiled from: DataManager.java */
            /* loaded from: classes.dex */
            public class g implements d.c.e0.h<Object, Object, Object, Object, Object> {
                public g(a aVar) {
                }

                @Override // d.c.e0.h
                public Object apply(Object obj, Object obj2, Object obj3, Object obj4) {
                    return DataModels.EMPTY_OBJECT;
                }
            }

            /* compiled from: DataManager.java */
            /* loaded from: classes.dex */
            public class h implements d.c.e0.l<Object, Object, Object, Object, Object, Object, Object, Object, Object> {
                public h(a aVar) {
                }

                @Override // d.c.e0.l
                public Object apply(Object obj, Object obj2, Object obj3, Object obj4, Object obj5, Object obj6, Object obj7, Object obj8) {
                    return DataModels.EMPTY_OBJECT;
                }
            }

            public a(d.c.w wVar, Date date) {
                this.f6793a = wVar;
                this.f6794b = date;
            }

            @Override // pt.card4b.backendbeacons.BackendListeners.BaseRequestListener
            public void onError(DataModels.Error error) {
                h.a.a.c.a("LOGIC_BEACONS", "DataManager", "getApplicationData", "Error getting application data: " + error.getMessage());
                if (this.f6794b != null) {
                    if (q0.this.f6791b.booleanValue()) {
                        d.c.u.zip(d.c.u.zip(n.this.i("[]"), n.this.j("[]"), n.this.k("[]"), n.this.f("[]"), n.this.g("[]"), n.this.h("[]"), n.this.a("[]"), n.this.b("[]"), new h(this)), n.this.d("[]"), n.this.c("[]"), n.this.e("[]"), new g(this)).subscribeOn(d.c.j0.a.b()).subscribe(new e(), new f());
                        return;
                    } else {
                        this.f6793a.a(new DataModels.g(error));
                        return;
                    }
                }
                h.a.a.c.a("LOGIC_OTHER", "DataManager", "getApplicationData", "Failed to get the initial data from server.");
                this.f6793a.a(new DataModels.g(error));
            }

            @Override // pt.card4b.backendbeacons.BackendListeners.h
            public void a(Map<String, String> map) {
                d.c.u.zip(d.c.u.zip(n.this.i(map.get("operators")), n.this.j(map.get("stops")), n.this.k(map.get("zones")), n.this.f(map.get("lineDirections")), n.this.g(map.get("lineVariants")), n.this.h(map.get("lines")), n.this.a(map.get("beaconInformationTypes")), n.this.b(map.get("configurations")), new d(this)), n.this.d(map.get("customerProfiles")), n.this.c(map.get("countries")), n.this.e(map.get("languages")), new c(this)).subscribeOn(d.c.j0.a.b()).subscribe(new C0150a(), new b());
            }
        }

        public q0(Boolean bool, Boolean bool2) {
            this.f6790a = bool;
            this.f6791b = bool2;
        }

        @Override // d.c.u
        public void subscribeActual(d.c.w<? super Object> wVar) {
            if (this.f6790a.booleanValue()) {
                h.a.a.v.d().B();
            }
            Date a2 = n.c() ? h.a.a.v.d().a() : null;
            h.a.a.h.d().a(a2 != null ? h.a.a.p.b(a2) : "-1", new a(wVar, a2));
        }
    }

    /* compiled from: DataManager.java */
    /* loaded from: classes.dex */
    public class r extends d.c.u<Object> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ String f6802a;

        public r(n nVar, String str) {
            this.f6802a = str;
        }

        @Override // d.c.u
        public void subscribeActual(d.c.w<? super Object> wVar) {
            if (h.a.a.v.d().f(this.f6802a)) {
                wVar.b(DataModels.EMPTY_OBJECT);
            } else {
                wVar.a(new DataModels.g(DataModels.Error.internal("failed to remove stage state")));
            }
        }
    }

    /* compiled from: DataManager.java */
    /* loaded from: classes.dex */
    public class r0 extends d.c.u<Object> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ DataModels.User f6803a;

        public r0(n nVar, DataModels.User user) {
            this.f6803a = user;
        }

        @Override // d.c.u
        public void subscribeActual(d.c.w<? super Object> wVar) {
            h.a.a.v.d().a(this.f6803a);
            wVar.b(DataModels.EMPTY_OBJECT);
        }
    }

    /* compiled from: DataManager.java */
    /* loaded from: classes.dex */
    public class s implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ List f6804a;

        public s(List list) {
            this.f6804a = list;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                ArrayList arrayList = new ArrayList();
                for (DataModelDTOs$IntermodalZoneDTO dataModelDTOs$IntermodalZoneDTO : this.f6804a) {
                    arrayList.add(new DataModelDBOs$TableZone(dataModelDTOs$IntermodalZoneDTO));
                }
                synchronized (n.this.f6687d) {
                    Database.r().k(arrayList);
                }
                h.a.a.v.d().l(true);
                h.a.a.c.a("LOGIC_OTHER", "DataManager", "zonesDatabase", "Saved zones to database!");
            } catch (Throwable th) {
                h.a.a.c.a("LOGIC_OTHER", "DataManager", "zonesDatabase", "Error saving zones:" + Log.getStackTraceString(th));
            }
        }
    }

    /* compiled from: DataManager.java */
    /* loaded from: classes.dex */
    public class s0 extends d.c.u<Object> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ String f6806a;

        /* compiled from: DataManager.java */
        /* loaded from: classes.dex */
        public class a implements BackendListeners.e {

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ d.c.w f6807a;

            public a(s0 s0Var, d.c.w wVar) {
                this.f6807a = wVar;
            }

            @Override // pt.card4b.backendbeacons.BackendListeners.BaseRequestListener
            public void onError(DataModels.Error error) {
                StringBuilder sb = new StringBuilder();
                sb.append("Failed to logout on server");
                sb.append(error != null ? error.getMessage() : "");
                h.a.a.c.a("LOGIC_USER", "DataManager", "logout", sb.toString());
                h.a.a.v.d().C();
                h.a.a.v.d().D();
                this.f6807a.b(DataModels.EMPTY_OBJECT);
            }

            @Override // pt.card4b.backendbeacons.BackendListeners.e
            public void onSuccess() {
                h.a.a.v.d().C();
                h.a.a.v.d().D();
                this.f6807a.b(DataModels.EMPTY_OBJECT);
            }
        }

        public s0(n nVar, String str) {
            this.f6806a = str;
        }

        @Override // d.c.u
        public void subscribeActual(d.c.w<? super Object> wVar) {
            h.a.a.h.d().a(this.f6806a, new a(this, wVar));
        }
    }

    /* compiled from: DataManager.java */
    /* loaded from: classes.dex */
    public class t extends d.c.u<DataModels.p> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ String f6808a;

        public t(n nVar, String str) {
            this.f6808a = str;
        }

        @Override // d.c.u
        public void subscribeActual(d.c.w<? super DataModels.p> wVar) {
            DataModels.p a2 = h.a.a.v.d().a(this.f6808a);
            if (a2 != null) {
                wVar.b(a2);
            } else {
                wVar.a(new DataModels.g(DataModels.Error.internal("No stage state saved")));
            }
        }
    }

    /* compiled from: DataManager.java */
    /* loaded from: classes.dex */
    public class t0 extends d.c.u<Object> {

        /* compiled from: DataManager.java */
        /* loaded from: classes.dex */
        public class a implements d.c.e0.f<Object> {

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ d.c.w f6810a;

            public a(t0 t0Var, d.c.w wVar) {
                this.f6810a = wVar;
            }

            @Override // d.c.e0.f
            public void accept(Object obj) {
                this.f6810a.b(DataModels.EMPTY_OBJECT);
            }
        }

        /* compiled from: DataManager.java */
        /* loaded from: classes.dex */
        public class b implements d.c.e0.f<Throwable> {

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ d.c.w f6811a;

            public b(t0 t0Var, d.c.w wVar) {
                this.f6811a = wVar;
            }

            @Override // d.c.e0.f
            /* renamed from: a */
            public void accept(Throwable th) {
                this.f6811a.a(th);
            }
        }

        public t0() {
        }

        @Override // d.c.u
        public void subscribeActual(d.c.w<? super Object> wVar) {
            n.this.b("[]").subscribeOn(d.c.j0.a.b()).subscribe(new a(this, wVar), new b(this, wVar));
        }
    }

    /* compiled from: DataManager.java */
    /* loaded from: classes.dex */
    public class u extends d.c.u<List<DataModels.StageInfo>> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ Date f6812a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ String f6813b;

        /* compiled from: DataManager.java */
        /* loaded from: classes.dex */
        public class a implements BackendListeners.h<List<DataModelDTOs$StageDetailsDTO>> {

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ d.c.w f6815a;

            public a(d.c.w wVar) {
                this.f6815a = wVar;
            }

            @Override // pt.card4b.backendbeacons.BackendListeners.BaseRequestListener
            public void onError(DataModels.Error error) {
                this.f6815a.a(new DataModels.g(error));
            }

            @Override // pt.card4b.backendbeacons.BackendListeners.h
            /* renamed from: onSuccess */
            public void a(List<DataModelDTOs$StageDetailsDTO> list) {
                this.f6815a.b(n.this.b(list));
            }
        }

        public u(Date date, String str) {
            this.f6812a = date;
            this.f6813b = str;
        }

        @Override // d.c.u
        public void subscribeActual(d.c.w<? super List<DataModels.StageInfo>> wVar) {
            Calendar calendar = Calendar.getInstance(TimeZone.getTimeZone("Europe/Lisbon"));
            calendar.setTime(this.f6812a);
            calendar.set(5, 1);
            calendar.set(5, calendar.getActualMaximum(5));
            h.a.a.h.d().a(h.a.a.p.f(), this.f6813b, h.a.a.p.b((Date) calendar.getTime().clone()), h.a.a.p.b((Date) calendar.getTime().clone()), new a(wVar));
        }
    }

    /* compiled from: DataManager.java */
    /* loaded from: classes.dex */
    public class u0 extends d.c.u<Object> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ String f6817a;

        /* compiled from: DataManager.java */
        /* loaded from: classes.dex */
        public class a extends c.d.b.w.a<ArrayList<DataModelDTOs$IntermodalZoneDTO>> {
            public a(u0 u0Var) {
            }
        }

        public u0(String str) {
            this.f6817a = str;
        }

        @Override // d.c.u
        public void subscribeActual(d.c.w<? super Object> wVar) {
            c.d.b.g gVar = new c.d.b.g();
            gVar.a("yyyy-MM-dd'T'hh:mm:ss");
            c.d.b.f a2 = gVar.a();
            String str = this.f6817a;
            if (str == null) {
                str = "[]";
            }
            List list = (List) a2.a(str, new a(this).getType());
            h.a.a.l.k().u().clear();
            if (j0.f6763a[n.this.l.ordinal()] != 1) {
                return;
            }
            n.this.j(list, wVar);
        }
    }

    /* compiled from: DataManager.java */
    /* loaded from: classes.dex */
    public class v implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ List f6819a;

        public v(List list) {
            this.f6819a = list;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                ArrayList arrayList = new ArrayList();
                for (DataModelDTOs$LineDirectionDTO dataModelDTOs$LineDirectionDTO : this.f6819a) {
                    arrayList.add(new DataModelDBOs$TableLineOrientation(dataModelDTOs$LineDirectionDTO));
                }
                synchronized (n.this.f6689f) {
                    Database.r().g(arrayList);
                }
                h.a.a.v.d().g(true);
                h.a.a.c.a("LOGIC_OTHER", "DataManager", "lineDirectionsDatabase", "Saved lineDirections to database!");
            } catch (Throwable th) {
                h.a.a.c.a("LOGIC_OTHER", "DataManager", "lineDirectionsDatabase", "Error saving linedirections:" + Log.getStackTraceString(th));
            }
        }
    }

    /* compiled from: DataManager.java */
    /* loaded from: classes.dex */
    public enum v0 {
        DATABASE
    }

    /* compiled from: DataManager.java */
    /* loaded from: classes.dex */
    public class w extends d.c.u<List<DataModels.TariffInfo>> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ Date f6823a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ String f6824b;

        /* compiled from: DataManager.java */
        /* loaded from: classes.dex */
        public class a implements BackendListeners.h<List<DataModelDTOs$StageTariffsDTO>> {

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ d.c.w f6826a;

            public a(d.c.w wVar) {
                this.f6826a = wVar;
            }

            @Override // pt.card4b.backendbeacons.BackendListeners.BaseRequestListener
            public void onError(DataModels.Error error) {
                this.f6826a.a(new DataModels.g(error));
            }

            @Override // pt.card4b.backendbeacons.BackendListeners.h
            /* renamed from: onSuccess */
            public void a(List<DataModelDTOs$StageTariffsDTO> list) {
                this.f6826a.b(n.this.d(list));
            }
        }

        public w(Date date, String str) {
            this.f6823a = date;
            this.f6824b = str;
        }

        @Override // d.c.u
        public void subscribeActual(d.c.w<? super List<DataModels.TariffInfo>> wVar) {
            Calendar calendar = Calendar.getInstance(TimeZone.getTimeZone("Europe/Lisbon"));
            calendar.setTime(this.f6823a);
            calendar.set(5, 1);
            calendar.set(5, calendar.getActualMaximum(5));
            h.a.a.h.d().b(h.a.a.p.f(), this.f6824b, h.a.a.p.b((Date) calendar.getTime().clone()), h.a.a.p.b((Date) calendar.getTime().clone()), new a(wVar));
        }
    }

    /* compiled from: DataManager.java */
    /* loaded from: classes.dex */
    public class w0 extends d.c.u<Object> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ String f6828a;

        /* compiled from: DataManager.java */
        /* loaded from: classes.dex */
        public class a extends c.d.b.w.a<ArrayList<DataModelDTOs$ConfigurationDTO>> {
            public a(w0 w0Var) {
            }
        }

        public w0(String str) {
            this.f6828a = str;
        }

        @Override // d.c.u
        public void subscribeActual(d.c.w<? super Object> wVar) {
            DataModels.User k = h.a.a.v.d().k();
            String id = k != null ? k.getId() : null;
            c.d.b.g gVar = new c.d.b.g();
            gVar.a("yyyy-MM-dd'T'hh:mm:ss");
            c.d.b.f a2 = gVar.a();
            String str = this.f6828a;
            if (str == null) {
                str = "[]";
            }
            List<DataModelDTOs$ConfigurationDTO> list = (List) a2.a(str, new a(this).getType());
            if (list != null && list.size() > 0) {
                for (DataModelDTOs$ConfigurationDTO dataModelDTOs$ConfigurationDTO : list) {
                    if (dataModelDTOs$ConfigurationDTO.getCode() == null || dataModelDTOs$ConfigurationDTO.getCode().trim().isEmpty()) {
                        dataModelDTOs$ConfigurationDTO.setCode(dataModelDTOs$ConfigurationDTO.getName());
                    }
                }
            }
            h.a.a.l.k().g().clear();
            if (j0.f6763a[n.this.l.ordinal()] != 1) {
                return;
            }
            n.this.a(list, id, wVar);
        }
    }

    /* compiled from: DataManager.java */
    /* loaded from: classes.dex */
    public class x implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ List f6830a;

        public x(List list) {
            this.f6830a = list;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                ArrayList arrayList = new ArrayList();
                for (DataModelDTOs$LineVariantDTO dataModelDTOs$LineVariantDTO : this.f6830a) {
                    arrayList.add(new DataModelDBOs$TableLineVariant(dataModelDTOs$LineVariantDTO));
                }
                synchronized (n.this.f6690g) {
                    Database.r().h(arrayList);
                }
                h.a.a.v.d().h(true);
                h.a.a.c.a("LOGIC_OTHER", "DataManager", "lineVariantsDatabase", "Saved lineVariants to database!");
            } catch (Throwable th) {
                h.a.a.c.a("LOGIC_OTHER", "DataManager", "lineVariantsDatabase", "Error saving linevariants:" + Log.getStackTraceString(th));
            }
        }
    }

    /* compiled from: DataManager.java */
    /* loaded from: classes.dex */
    public class x0 extends d.c.u<Object> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ String f6832a;

        /* compiled from: DataManager.java */
        /* loaded from: classes.dex */
        public class a extends c.d.b.w.a<ArrayList<DataModelDTOs$CustomerProfileDTO>> {
            public a(x0 x0Var) {
            }
        }

        public x0(String str) {
            this.f6832a = str;
        }

        @Override // d.c.u
        public void subscribeActual(d.c.w<? super Object> wVar) {
            c.d.b.g gVar = new c.d.b.g();
            gVar.a("yyyy-MM-dd'T'hh:mm:ss");
            c.d.b.f a2 = gVar.a();
            String str = this.f6832a;
            if (str == null) {
                str = "[]";
            }
            List list = (List) a2.a(str, new a(this).getType());
            h.a.a.l.k().i().clear();
            if (j0.f6763a[n.this.l.ordinal()] != 1) {
                return;
            }
            n.this.c(list, wVar);
        }
    }

    /* compiled from: DataManager.java */
    /* loaded from: classes.dex */
    public class y extends d.c.u<List<DataModels.InvoiceInfo>> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ Date f6834a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ String f6835b;

        /* compiled from: DataManager.java */
        /* loaded from: classes.dex */
        public class a implements BackendListeners.h<List<DataModelDTOs$InvoiceDetailsDTO>> {

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ d.c.w f6837a;

            public a(d.c.w wVar) {
                this.f6837a = wVar;
            }

            @Override // pt.card4b.backendbeacons.BackendListeners.BaseRequestListener
            public void onError(DataModels.Error error) {
                this.f6837a.a(new DataModels.g(error));
            }

            @Override // pt.card4b.backendbeacons.BackendListeners.h
            /* renamed from: onSuccess */
            public void a(List<DataModelDTOs$InvoiceDetailsDTO> list) {
                this.f6837a.b(n.this.c(list));
            }
        }

        public y(Date date, String str) {
            this.f6834a = date;
            this.f6835b = str;
        }

        @Override // d.c.u
        public void subscribeActual(d.c.w<? super List<DataModels.InvoiceInfo>> wVar) {
            Calendar calendar = Calendar.getInstance(TimeZone.getTimeZone("Europe/Lisbon"));
            calendar.setTime(this.f6834a);
            calendar.set(5, 1);
            calendar.set(5, calendar.getActualMaximum(5));
            h.a.a.h.d().a(this.f6835b, h.a.a.p.b((Date) calendar.getTime().clone()), h.a.a.p.b((Date) calendar.getTime().clone()), new a(wVar));
        }
    }

    /* compiled from: DataManager.java */
    /* loaded from: classes.dex */
    public class z implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ List f6839a;

        public z(List list) {
            this.f6839a = list;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                ArrayList arrayList = new ArrayList();
                for (DataModelDTOs$BeaconInformationTypeDTO dataModelDTOs$BeaconInformationTypeDTO : this.f6839a) {
                    arrayList.add(new DataModelDBOs$TableBeaconInformationType(dataModelDTOs$BeaconInformationTypeDTO));
                }
                synchronized (n.this.f6691h) {
                    Database.r().a(arrayList);
                }
                h.a.a.v.d().b(true);
                h.a.a.c.a("LOGIC_OTHER", "DataManager", "beaconInformationTypesDatabase", "Saved beaconInformationTypes to database!");
            } catch (Throwable th) {
                h.a.a.c.a("LOGIC_OTHER", "DataManager", "beaconInformationTypesDatabase", "Error saving beaconinformationtypes:" + Log.getStackTraceString(th));
            }
        }
    }

    public n() {
        if (m != null) {
            throw new RuntimeException("DataManager: Use getInstance() method to get the single instance of this class.");
        }
    }

    public d.c.u<DataModels.p> m(String str) {
        return new t(this, str);
    }

    public d.c.u<DataModels.UserAccountInfo> n(String str) {
        return new g0(this, str);
    }

    public d.c.u<Boolean> o(String str) {
        return new C0149n(this, str);
    }

    public d.c.u<Object> p(String str) {
        return new s0(this, str);
    }

    public d.c.u<Object> q(String str) {
        return new r(this, str);
    }

    public d.c.u<Object> r(String str) {
        return new l0(this, str);
    }

    public d.c.u<List<DataModels.PaymentMethod>> l(String str) {
        return new a0(this, str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public d.c.u<Object> k(String str) {
        return new u0(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public d.c.u<Object> f(String str) {
        return new b(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public d.c.u<Object> g(String str) {
        return new d(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public d.c.u<Object> h(String str) {
        return new o0(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public d.c.u<Object> i(String str) {
        return new k0(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public d.c.u<Object> j(String str) {
        return new m0(str);
    }

    public d.c.u<Object> d() {
        return new t0();
    }

    public d.c.u<Object> e() {
        return new c(this);
    }

    public static boolean c() {
        return h.a.a.v.d().v() && h.a.a.v.d().w() && h.a.a.v.d().o() && h.a.a.v.d().u() && h.a.a.v.d().x() && h.a.a.v.d().s() && h.a.a.v.d().t() && h.a.a.v.d().n() && h.a.a.v.d().q() && h.a.a.v.d().p() && h.a.a.v.d().r();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public d.c.u<Object> e(String str) {
        return new j(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f(List<DataModelDTOs$LineVariantDTO> list, d.c.w<? super Object> wVar) {
        if (list != null) {
            try {
                if (list.size() > 0) {
                    new Thread(new x(list)).start();
                    for (DataModelDTOs$LineVariantDTO dataModelDTOs$LineVariantDTO : list) {
                        DataModels.l lineVariant = dataModelDTOs$LineVariantDTO.toLineVariant();
                        h.a.a.l.k().n().put(lineVariant.b(), lineVariant);
                    }
                    h.a.a.c.a("LOGIC_OTHER", "DataManager", "lineVariantsDatabase", "LineVariant count = " + h.a.a.l.k().n().size());
                    wVar.b(DataModels.EMPTY_OBJECT);
                    return;
                }
            } catch (Throwable th) {
                wVar.a(th);
                return;
            }
        }
        List<DataModelDBOs$TableLineVariant> h2 = Database.r().h();
        if (h2 != null && h2.size() != 0) {
            for (DataModelDBOs$TableLineVariant dataModelDBOs$TableLineVariant : h2) {
                DataModels.l c2 = dataModelDBOs$TableLineVariant.c();
                h.a.a.l.k().n().put(c2.b(), c2);
            }
            h.a.a.c.a("LOGIC_OTHER", "DataManager", "lineVariantsDatabase", "LineVariant count = " + h.a.a.l.k().n().size());
            wVar.b(DataModels.EMPTY_OBJECT);
            return;
        }
        h.a.a.v.d().h(false);
        wVar.a(new DataModels.g(DataModels.Error.internal(h.a.a.p.a(h.a.a.a.errormsg_appdata))));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g(List<DataModelDTOs$LineDTO> list, d.c.w<? super Object> wVar) {
        if (list != null) {
            try {
                if (list.size() > 0) {
                    new Thread(new q(list)).start();
                    for (DataModelDTOs$LineDTO dataModelDTOs$LineDTO : list) {
                        DataModels.j line = dataModelDTOs$LineDTO.toLine();
                        h.a.a.l.k().o().put(line.a(), line);
                        Map<String, DataModels.j> p2 = h.a.a.l.k().p();
                        p2.put(line.e() + "|" + line.d(), line);
                    }
                    h.a.a.c.a("LOGIC_OTHER", "DataManager", "linesDatabase", "Line count = " + h.a.a.l.k().o().size());
                    wVar.b(DataModels.EMPTY_OBJECT);
                    return;
                }
            } catch (Throwable th) {
                wVar.a(th);
                return;
            }
        }
        List<DataModelDBOs$TableLine> i2 = Database.r().i();
        if (i2 != null && i2.size() != 0) {
            for (DataModelDBOs$TableLine dataModelDBOs$TableLine : i2) {
                DataModels.j f2 = dataModelDBOs$TableLine.f();
                h.a.a.l.k().o().put(f2.a(), f2);
                Map<String, DataModels.j> p3 = h.a.a.l.k().p();
                p3.put(f2.e() + "|" + f2.d(), f2);
            }
            h.a.a.c.a("LOGIC_OTHER", "DataManager", "linesDatabase", "Line count = " + h.a.a.l.k().o().size());
            wVar.b(DataModels.EMPTY_OBJECT);
            return;
        }
        h.a.a.v.d().i(false);
        wVar.a(new DataModels.g(DataModels.Error.internal(h.a.a.p.a(h.a.a.a.errormsg_appdata))));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h(List<DataModelDTOs$TransportOperatorDTO> list, d.c.w<? super Object> wVar) {
        if (list != null) {
            try {
                if (list.size() > 0) {
                    new Thread(new k(list)).start();
                    for (DataModelDTOs$TransportOperatorDTO dataModelDTOs$TransportOperatorDTO : list) {
                        DataModels.m operator = dataModelDTOs$TransportOperatorDTO.toOperator();
                        h.a.a.l.k().r().put(operator.b(), operator);
                        h.a.a.l.k().q().add(operator);
                    }
                    h.a.a.c.a("LOGIC_OTHER", "DataManager", "operatorsDatabase", "Operator count = " + h.a.a.l.k().r().size());
                    wVar.b(DataModels.EMPTY_OBJECT);
                    return;
                }
            } catch (Throwable th) {
                wVar.a(th);
                return;
            }
        }
        List<DataModelDBOs$TableOperator> j2 = Database.r().j();
        if (j2 != null && j2.size() != 0) {
            for (DataModelDBOs$TableOperator dataModelDBOs$TableOperator : j2) {
                DataModels.m e2 = dataModelDBOs$TableOperator.e();
                h.a.a.l.k().r().put(e2.b(), e2);
                h.a.a.l.k().q().add(e2);
            }
            h.a.a.c.a("LOGIC_OTHER", "DataManager", "operatorsDatabase", "Operator count = " + h.a.a.l.k().r().size());
            wVar.b(DataModels.EMPTY_OBJECT);
            return;
        }
        h.a.a.v.d().j(false);
        wVar.a(new DataModels.g(DataModels.Error.internal(h.a.a.p.a(h.a.a.a.errormsg_appdata))));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i(List<DataModelDTOs$StopDTO> list, d.c.w<? super Object> wVar) {
        if (list != null) {
            try {
                if (list.size() > 0) {
                    new Thread(new m(list)).start();
                    for (DataModelDTOs$StopDTO dataModelDTOs$StopDTO : list) {
                        DataModels.q stop = dataModelDTOs$StopDTO.toStop();
                        h.a.a.l.k().s().put(stop.b(), stop);
                        Map<String, DataModels.q> t2 = h.a.a.l.k().t();
                        t2.put(dataModelDTOs$StopDTO.getBeaconStopRef() + "|" + dataModelDTOs$StopDTO.getTransportOperatorRef(), stop);
                    }
                    h.a.a.c.a("LOGIC_OTHER", "DataManager", "stopsDatabase", "Stop count = " + h.a.a.l.k().s().size());
                    wVar.b(DataModels.EMPTY_OBJECT);
                    return;
                }
            } catch (Throwable th) {
                wVar.a(th);
                return;
            }
        }
        List<DataModelDBOs$TableStop> k2 = Database.r().k();
        if (k2 != null && k2.size() != 0) {
            for (DataModelDBOs$TableStop dataModelDBOs$TableStop : k2) {
                DataModels.q g2 = dataModelDBOs$TableStop.g();
                h.a.a.l.k().s().put(g2.b(), g2);
                Map<String, DataModels.q> t3 = h.a.a.l.k().t();
                t3.put(dataModelDBOs$TableStop.a() + "|" + dataModelDBOs$TableStop.d(), g2);
            }
            h.a.a.c.a("LOGIC_OTHER", "DataManager", "stopsDatabase", "Stop count = " + h.a.a.l.k().s().size());
            wVar.b(DataModels.EMPTY_OBJECT);
            return;
        }
        h.a.a.v.d().k(false);
        wVar.a(new DataModels.g(DataModels.Error.internal(h.a.a.p.a(h.a.a.a.errormsg_appdata))));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j(List<DataModelDTOs$IntermodalZoneDTO> list, d.c.w<? super Object> wVar) {
        if (list != null) {
            try {
                if (list.size() > 0) {
                    new Thread(new s(list)).start();
                    for (DataModelDTOs$IntermodalZoneDTO dataModelDTOs$IntermodalZoneDTO : list) {
                        DataModels.r zone = dataModelDTOs$IntermodalZoneDTO.toZone();
                        h.a.a.l.k().u().put(zone.b(), zone);
                    }
                    h.a.a.c.a("LOGIC_OTHER", "DataManager", "zonesDatabase", "Zone count = " + h.a.a.l.k().u().size());
                    wVar.b(DataModels.EMPTY_OBJECT);
                    return;
                }
            } catch (Throwable th) {
                wVar.a(th);
                return;
            }
        }
        List<DataModelDBOs$TableZone> l2 = Database.r().l();
        if (l2 != null && l2.size() != 0) {
            for (DataModelDBOs$TableZone dataModelDBOs$TableZone : l2) {
                DataModels.r c2 = dataModelDBOs$TableZone.c();
                h.a.a.l.k().u().put(c2.b(), c2);
            }
            h.a.a.c.a("LOGIC_OTHER", "DataManager", "zonesDatabase", "Zone count = " + h.a.a.l.k().u().size());
            wVar.b(DataModels.EMPTY_OBJECT);
            return;
        }
        h.a.a.v.d().l(false);
        wVar.a(new DataModels.g(DataModels.Error.internal(h.a.a.p.a(h.a.a.a.errormsg_appdata))));
    }

    public d.c.u<DataModels.User> b() {
        return new l(this);
    }

    public d.c.u<Object> d(String str, String str2) {
        return new i0(this, str, str2);
    }

    public static n a() {
        if (m == null) {
            synchronized (n.class) {
                if (m == null) {
                    m = new n();
                }
            }
        }
        return m;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public d.c.u<Object> d(String str) {
        return new x0(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(List<DataModelDTOs$LineDirectionDTO> list, d.c.w<? super Object> wVar) {
        if (list != null) {
            try {
                if (list.size() > 0) {
                    new Thread(new v(list)).start();
                    for (DataModelDTOs$LineDirectionDTO dataModelDTOs$LineDirectionDTO : list) {
                        DataModels.k lineOrientation = dataModelDTOs$LineDirectionDTO.toLineOrientation();
                        h.a.a.l.k().m().put(lineOrientation.a(), lineOrientation);
                    }
                    h.a.a.c.a("LOGIC_OTHER", "DataManager", "lineDirectionsDatabase", "LineDirection count = " + h.a.a.l.k().m().size());
                    wVar.b(DataModels.EMPTY_OBJECT);
                    return;
                }
            } catch (Throwable th) {
                wVar.a(th);
                return;
            }
        }
        List<DataModelDBOs$TableLineOrientation> g2 = Database.r().g();
        if (g2 != null && g2.size() != 0) {
            for (DataModelDBOs$TableLineOrientation dataModelDBOs$TableLineOrientation : g2) {
                DataModels.k d2 = dataModelDBOs$TableLineOrientation.d();
                h.a.a.l.k().m().put(d2.a(), d2);
            }
            h.a.a.c.a("LOGIC_OTHER", "DataManager", "lineDirectionsDatabase", "LineDirection count = " + h.a.a.l.k().m().size());
            wVar.b(DataModels.EMPTY_OBJECT);
            return;
        }
        h.a.a.v.d().g(false);
        wVar.a(new DataModels.g(DataModels.Error.internal(h.a.a.p.a(h.a.a.a.errormsg_appdata))));
    }

    public d.c.u<List<DataModels.StageInfo>> b(String str, Date date) {
        return new u(date, str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(List<DataModelDTOs$LanguageDTO> list, d.c.w<? super Object> wVar) {
        if (list != null) {
            try {
                if (list.size() > 0) {
                    new Thread(new d0(list)).start();
                    for (DataModelDTOs$LanguageDTO dataModelDTOs$LanguageDTO : list) {
                        DataModels.Language language = dataModelDTOs$LanguageDTO.toLanguage();
                        h.a.a.l.k().l().put(language.getId(), language);
                    }
                    h.a.a.c.a("LOGIC_OTHER", "DataManager", "languagesDatabase", "Languages count = " + h.a.a.l.k().l().size());
                    wVar.b(DataModels.EMPTY_OBJECT);
                    return;
                }
            } catch (Throwable th) {
                wVar.a(th);
                return;
            }
        }
        List<DataModelDBOs$TableLanguage> f2 = Database.r().f();
        if (f2 != null && f2.size() != 0) {
            for (DataModelDBOs$TableLanguage dataModelDBOs$TableLanguage : f2) {
                DataModels.Language d2 = dataModelDBOs$TableLanguage.d();
                h.a.a.l.k().l().put(d2.getId(), d2);
            }
            h.a.a.c.a("LOGIC_OTHER", "DataManager", "languagesDatabase", "Languages count = " + h.a.a.l.k().l().size());
            wVar.b(DataModels.EMPTY_OBJECT);
            return;
        }
        h.a.a.v.d().f(false);
        wVar.a(new DataModels.g(DataModels.Error.internal(h.a.a.p.a(h.a.a.a.errormsg_appdata))));
    }

    public d.c.u<DataModels.e> b(String str, String str2) {
        return new c0(this, str, str2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public d.c.u<Object> b(String str) {
        return new w0(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(List<DataModelDTOs$CountryDTO> list, d.c.w<? super Object> wVar) {
        if (list != null) {
            try {
                if (list.size() > 0) {
                    new Thread(new b0(list)).start();
                    for (DataModelDTOs$CountryDTO dataModelDTOs$CountryDTO : list) {
                        DataModels.Country country = dataModelDTOs$CountryDTO.toCountry();
                        h.a.a.l.k().h().put(country.getId(), country);
                    }
                    h.a.a.c.a("LOGIC_OTHER", "DataManager", "countriesDatabase", "Countries count = " + h.a.a.l.k().h().size());
                    wVar.b(DataModels.EMPTY_OBJECT);
                    return;
                }
            } catch (Throwable th) {
                wVar.a(th);
                return;
            }
        }
        List<DataModelDBOs$TableCountry> d2 = Database.r().d();
        if (d2 != null && d2.size() != 0) {
            for (DataModelDBOs$TableCountry dataModelDBOs$TableCountry : d2) {
                DataModels.Country d3 = dataModelDBOs$TableCountry.d();
                h.a.a.l.k().h().put(d3.getId(), d3);
            }
            h.a.a.c.a("LOGIC_OTHER", "DataManager", "countriesDatabase", "Countries count = " + h.a.a.l.k().h().size());
            wVar.b(DataModels.EMPTY_OBJECT);
            return;
        }
        h.a.a.v.d().d(false);
        wVar.a(new DataModels.g(DataModels.Error.internal(h.a.a.p.a(h.a.a.a.errormsg_appdata))));
    }

    public d.c.u<DataModels.User> a(String str, String str2) {
        return new a(str, str2);
    }

    public d.c.u<Object> a(DataModels.User user) {
        return new r0(this, user);
    }

    public d.c.u<Object> a(DataModels.UserAccountInfo userAccountInfo, String str) {
        return new o(this, userAccountInfo, str);
    }

    public d.c.u<Boolean> a(DataModels.UserAccountInfo userAccountInfo) {
        return new n0(this, userAccountInfo);
    }

    public d.c.u<Object> a(String str, String str2, String str3) {
        return new p0(this, str, str2, str3);
    }

    public d.c.u<List<DataModels.TariffInfo>> c(String str, Date date) {
        return new w(date, str);
    }

    public d.c.u<Object> a(Boolean bool, Boolean bool2) {
        return new q0(bool2, bool);
    }

    public d.c.u<Object> c(String str, String str2) {
        return new e0(this, str, str2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public d.c.u<Object> c(String str) {
        return new h(str);
    }

    public d.c.u<DataModels.NewStageStartInfo> a(String str, List<DataModels.b> list, boolean z2, String str2) {
        return new e(list, z2, str, str2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(List<DataModelDTOs$CustomerProfileDTO> list, d.c.w<? super Object> wVar) {
        if (list != null) {
            try {
                if (list.size() > 0) {
                    new Thread(new h0(list)).start();
                    for (DataModelDTOs$CustomerProfileDTO dataModelDTOs$CustomerProfileDTO : list) {
                        DataModels.CustomerProfile customerProfile = dataModelDTOs$CustomerProfileDTO.toCustomerProfile();
                        h.a.a.l.k().i().put(customerProfile.getID(), customerProfile);
                    }
                    h.a.a.c.a("LOGIC_OTHER", "DataManager", "customerProfilesDatabase", "Customer profiles count = " + h.a.a.l.k().i().size());
                    wVar.b(DataModels.EMPTY_OBJECT);
                    return;
                }
            } catch (Throwable th) {
                wVar.a(th);
                return;
            }
        }
        List<DataModelDBOs$TableCustomerProfile> e2 = Database.r().e();
        if (e2 != null && e2.size() != 0) {
            for (DataModelDBOs$TableCustomerProfile dataModelDBOs$TableCustomerProfile : e2) {
                DataModels.CustomerProfile d2 = dataModelDBOs$TableCustomerProfile.d();
                h.a.a.l.k().i().put(d2.getID(), d2);
            }
            h.a.a.c.a("LOGIC_OTHER", "DataManager", "customerProfilesDatabase", "Customer profiles count = " + h.a.a.l.k().i().size());
            wVar.b(DataModels.EMPTY_OBJECT);
            return;
        }
        h.a.a.v.d().e(false);
        wVar.a(new DataModels.g(DataModels.Error.internal(h.a.a.p.a(h.a.a.a.errormsg_appdata))));
    }

    public d.c.u<Object> a(String str, String str2, List<DataModels.b> list, boolean z2, Date date, int i2, String str3) {
        return new g(list, str, str2, date, z2, i2, str3);
    }

    public d.c.u<Object> a(String str, String str2, String str3, List<DataModels.b> list, boolean z2, Date date, int i2, String str4) {
        return new i(list, str3, date, str, str2, z2, i2, str4);
    }

    public d.c.u<Object> a(String str, DataModels.p pVar) {
        return new p(this, str, pVar);
    }

    public d.c.u<List<DataModels.InvoiceInfo>> a(String str, Date date) {
        return new y(date, str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public d.c.u<Object> a(String str) {
        return new f(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public List<DataModels.TariffInfo> d(List<DataModelDTOs$StageTariffsDTO> list) {
        ArrayList arrayList = new ArrayList();
        for (DataModelDTOs$StageTariffsDTO dataModelDTOs$StageTariffsDTO : list) {
            arrayList.add(dataModelDTOs$StageTariffsDTO.toTariffInfo());
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(List<DataModelDTOs$BeaconInformationTypeDTO> list, d.c.w<? super Object> wVar) {
        if (list != null) {
            try {
                if (list.size() > 0) {
                    new Thread(new z(list)).start();
                    for (DataModelDTOs$BeaconInformationTypeDTO dataModelDTOs$BeaconInformationTypeDTO : list) {
                        DataModels.d beaconInformationType = dataModelDTOs$BeaconInformationTypeDTO.toBeaconInformationType();
                        h.a.a.l.k().f().put(beaconInformationType.a(), beaconInformationType);
                    }
                    h.a.a.c.a("LOGIC_OTHER", "DataManager", "beaconInformationTypesDatabase", "BeaconInformationType count = " + h.a.a.l.k().f().size());
                    wVar.b(DataModels.EMPTY_OBJECT);
                    return;
                }
            } catch (Throwable th) {
                wVar.a(th);
                return;
            }
        }
        List<DataModelDBOs$TableBeaconInformationType> b2 = Database.r().b();
        if (b2 != null && b2.size() != 0) {
            for (DataModelDBOs$TableBeaconInformationType dataModelDBOs$TableBeaconInformationType : b2) {
                DataModels.d d2 = dataModelDBOs$TableBeaconInformationType.d();
                h.a.a.l.k().f().put(d2.a(), d2);
            }
            h.a.a.c.a("LOGIC_OTHER", "DataManager", "beaconInformationTypesDatabase", "BeaconInformationType count = " + h.a.a.l.k().f().size());
            wVar.b(DataModels.EMPTY_OBJECT);
            return;
        }
        h.a.a.v.d().b(false);
        wVar.a(new DataModels.g(DataModels.Error.internal(h.a.a.p.a(h.a.a.a.errormsg_appdata))));
    }

    public List<DataModels.StageInfo> b(List<DataModelDTOs$StageDetailsDTO> list) {
        ArrayList arrayList = new ArrayList();
        for (DataModelDTOs$StageDetailsDTO dataModelDTOs$StageDetailsDTO : list) {
            arrayList.add(dataModelDTOs$StageDetailsDTO.toStageInfo());
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public List<DataModels.InvoiceInfo> c(List<DataModelDTOs$InvoiceDetailsDTO> list) {
        ArrayList arrayList = new ArrayList();
        for (DataModelDTOs$InvoiceDetailsDTO dataModelDTOs$InvoiceDetailsDTO : list) {
            arrayList.add(dataModelDTOs$InvoiceDetailsDTO.toInvoiceInfo());
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(List<DataModelDTOs$ConfigurationDTO> list, String str, d.c.w<? super Object> wVar) {
        if (list != null) {
            try {
                if (list.size() > 0) {
                    new Thread(new f0(list)).start();
                    for (DataModelDTOs$ConfigurationDTO dataModelDTOs$ConfigurationDTO : list) {
                        if (dataModelDTOs$ConfigurationDTO.getCustomerId() == null || (str != null && dataModelDTOs$ConfigurationDTO.getCustomerId().toUpperCase().equals(str.toUpperCase()))) {
                            if (!h.a.a.l.k().g().containsKey(dataModelDTOs$ConfigurationDTO.getCode()) || dataModelDTOs$ConfigurationDTO.getCustomerId() != null) {
                                h.a.a.l.k().g().put(dataModelDTOs$ConfigurationDTO.getCode(), dataModelDTOs$ConfigurationDTO.toConfiguration());
                            }
                        }
                    }
                    h.a.a.c.a("LOGIC_OTHER", "DataManager", "configurationsDatabase", "Configurations count = " + h.a.a.l.k().g().size());
                    wVar.b(DataModels.EMPTY_OBJECT);
                    return;
                }
            } catch (Throwable th) {
                wVar.a(th);
                return;
            }
        }
        if (h.a.a.l.k().e() != null) {
            h.a.a.l.k().e().getId();
        }
        List<DataModelDBOs$TableConfiguration> c2 = Database.r().c();
        if (c2 != null && c2.size() != 0) {
            for (DataModelDBOs$TableConfiguration dataModelDBOs$TableConfiguration : c2) {
                if (dataModelDBOs$TableConfiguration.c() == null || (str != null && dataModelDBOs$TableConfiguration.c().toUpperCase().equals(str.toUpperCase()))) {
                    if (!h.a.a.l.k().g().containsKey(dataModelDBOs$TableConfiguration.b()) || dataModelDBOs$TableConfiguration.c() != null) {
                        h.a.a.l.k().g().put(dataModelDBOs$TableConfiguration.b(), dataModelDBOs$TableConfiguration.g());
                    }
                }
            }
            h.a.a.c.a("LOGIC_OTHER", "DataManager", "configurationsDatabase", "Configurations count = " + h.a.a.l.k().g().size());
            wVar.b(DataModels.EMPTY_OBJECT);
            return;
        }
        h.a.a.v.d().c(false);
        wVar.a(new DataModels.g(DataModels.Error.internal(h.a.a.p.a(h.a.a.a.errormsg_appdata))));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public List<DataModelDTOs$StageInformationBeaconDTO> a(List<DataModels.b> list) {
        h.a.a.c.a("LOGIC_BEACONS", "DataManager", "beaconDatasToStageInformationBeaconDTOs", "entered method");
        ArrayList arrayList = new ArrayList();
        for (DataModels.b bVar : list) {
            ArrayList<DataModels.a> arrayList2 = new ArrayList(bVar.b());
            String b2 = bVar.a() == null ? null : bVar.a().b();
            int b3 = bVar.k() == null ? 0 : bVar.k().b();
            int d2 = bVar.m() == null ? 0 : bVar.m().d();
            int e2 = bVar.h() == null ? 0 : bVar.h().e();
            int b4 = bVar.q() == null ? 0 : bVar.q().b();
            int p2 = bVar.p();
            int b5 = bVar.j() == null ? 0 : bVar.j().b();
            int c2 = bVar.i() == null ? 0 : bVar.i().c();
            int l2 = bVar.l();
            for (DataModels.a aVar : arrayList2) {
                if (bVar.k() != null && bVar.m() != null && bVar.a() != null) {
                    arrayList.add(new Object(aVar.j(), aVar.a() != null ? h.a.a.p.b(aVar.a()) : null, aVar.f() != null ? h.a.a.p.b(aVar.f()) : null, b2, aVar.k(), b3, d2, b4, e2, p2, b5, c2, l2, aVar.e().booleanValue(), aVar.l() != null ? h.a.a.p.b(aVar.l()) : null, aVar.g(), aVar.i(), aVar.h(), aVar.c(), aVar.d() != null ? h.a.a.p.b(aVar.d()) : null) { // from class: pt.card4b.backendbeacons.DataModelDTOs$StageInformationBeaconDTO
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
                            this.BeaconSerialNumber = r4;
                            this.StartDeviceTimeStamp = r5;
                            this.EndDeviceTimeStamp = r6;
                            this.BeaconInfoTypeId = b2;
                            this.Rssi = r8;
                            this.OperatorRef = b3;
                            this.StopRef = d2;
                            this.ZoneRef = b4;
                            this.LineRef = e2;
                            this.Vehicle = p2;
                            this.LineVariantRef = b5;
                            this.LineOrientationRef = c2;
                            this.Position = l2;
                            this.IsHCE = r17;
                            this.ValidationTimestamp = r18;
                            this.Latitude = r19;
                            this.Longitude = r21;
                            this.LocationAccuracy = r23;
                            this.HceCardSerialNr = r25;
                            this.HceCardValidity = r26;
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

                        public void setBeaconInfoTypeId(String str) {
                            this.BeaconInfoTypeId = str;
                        }

                        public void setBeaconSerialNumber(String str) {
                            this.BeaconSerialNumber = str;
                        }

                        public void setEndDeviceTimeStamp(String str) {
                            this.EndDeviceTimeStamp = str;
                        }

                        public void setHceCardSerialNr(String str) {
                            this.HceCardSerialNr = str;
                        }

                        public void setHceCardValidity(String str) {
                            this.HceCardValidity = str;
                        }

                        public void setIsHCE(Boolean bool) {
                            this.IsHCE = bool.booleanValue();
                        }

                        public void setLatitude(double d3) {
                            this.Latitude = d3;
                        }

                        public void setLineOrientationRef(int i2) {
                            this.LineOrientationRef = i2;
                        }

                        public void setLineRef(int i2) {
                            this.LineRef = i2;
                        }

                        public void setLineVariantRef(int i2) {
                            this.LineVariantRef = i2;
                        }

                        public void setLocationAccuracy(double d3) {
                            this.LocationAccuracy = d3;
                        }

                        public void setLongitude(double d3) {
                            this.Longitude = d3;
                        }

                        public void setOperatorRef(int i2) {
                            this.OperatorRef = i2;
                        }

                        public void setPosition(int i2) {
                            this.Position = i2;
                        }

                        public void setRssi(int i2) {
                            this.Rssi = i2;
                        }

                        public void setStartDeviceTimeStamp(String str) {
                            this.StartDeviceTimeStamp = str;
                        }

                        public void setStopRef(int i2) {
                            this.StopRef = i2;
                        }

                        public void setValidationTimestamp(String str) {
                            this.ValidationTimestamp = str;
                        }

                        public void setVehicle(int i2) {
                            this.Vehicle = i2;
                        }

                        public void setZoneRef(int i2) {
                            this.ZoneRef = i2;
                        }
                    });
                }
            }
        }
        return arrayList;
    }
}
