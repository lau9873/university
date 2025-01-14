package p205h.p208b.p209a.p210d.p211b0;

import android.content.Context;
import android.preference.PreferenceManager;
import android.util.Log;
import com.hbb20.C1444R;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import p070c.p074b.p075a.Crashlytics;
import p205h.p208b.p209a.Anda;
import p205h.p208b.p209a.p210d.AsyncResult;
import p205h.p208b.p209a.p210d.Billing;
import p205h.p208b.p209a.p210d.BillingProduct;
import p205h.p208b.p209a.p210d.ErrorListener;
import p205h.p208b.p209a.p210d.History;
import p205h.p208b.p209a.p210d.Invoice;
import p205h.p208b.p209a.p210d.RemoteUserListener;
import p205h.p208b.p209a.p210d.Session;
import p205h.p208b.p209a.p210d.Trip;
import p205h.p208b.p209a.p210d.User;
import p205h.p208b.p209a.p210d.UserProfile;
import pt.card4b.backendbeacons.BackEnd;
import pt.card4b.backendbeacons.BackendListeners;
import pt.card4b.backendbeacons.DataModels;

/* renamed from: h.b.a.d.b0.i */
/* loaded from: classes.dex */
public class TipSession implements Session, RemoteUserListener {

    /* renamed from: a */
    public final Anda f9599a;

    /* renamed from: b */
    public final Context f9600b;

    /* renamed from: d */
    public boolean f9602d;

    /* renamed from: c */
    public List<Session.InterfaceC2370e> f9601c = new ArrayList();

    /* renamed from: e */
    public DataModels.User f9603e = null;

    /* renamed from: f */
    public User f9604f = new C2330a();

    /* compiled from: TipSession.java */
    /* renamed from: h.b.a.d.b0.i$b */
    /* loaded from: classes.dex */
    public class C2332b implements BackendListeners.GetSavedUserRequestListener {

        /* renamed from: a */
        public final /* synthetic */ Runnable f9608a;

        public C2332b(Runnable runnable) {
            this.f9608a = runnable;
        }

        @Override // pt.card4b.backendbeacons.BackendListeners.BaseRequestListener
        public void onError(DataModels.Error error) {
            TipSession.this.mo1276c();
        }

        @Override // pt.card4b.backendbeacons.BackendListeners.GetSavedUserRequestListener
        public void onSuccess(DataModels.User user) {
            TipSession.this.f9603e = user;
            this.f9608a.run();
        }
    }

    /* compiled from: TipSession.java */
    /* renamed from: h.b.a.d.b0.i$c */
    /* loaded from: classes.dex */
    public class C2333c implements BackendListeners.LoginRequestListener {

        /* renamed from: a */
        public final /* synthetic */ C2346j f9610a;

        public C2333c(C2346j c2346j) {
            this.f9610a = c2346j;
        }

        @Override // pt.card4b.backendbeacons.BackendListeners.BaseRequestListener
        public void onError(DataModels.Error error) {
            this.f9610a.m1345a(error);
        }

        @Override // pt.card4b.backendbeacons.BackendListeners.LoginRequestListener
        public void onSuccess(DataModels.User user) {
            TipSession.this.f9599a.m1445a(true);
            this.f9610a.m1344a(user);
            TipSession.this.f9599a.m1466a();
            TipSession.this.f9599a.m1434c();
            Crashlytics.m6082a(user.getName());
        }
    }

    /* compiled from: TipSession.java */
    /* renamed from: h.b.a.d.b0.i$d */
    /* loaded from: classes.dex */
    public class C2334d implements Session.InterfaceC2367b {

        /* renamed from: a */
        public String f9612a;

        /* renamed from: b */
        public String f9613b;

        /* renamed from: c */
        public String f9614c;

        /* renamed from: d */
        public String f9615d;

        /* renamed from: e */
        public String f9616e;

        /* renamed from: f */
        public String f9617f;

        /* renamed from: g */
        public String f9618g;

        /* renamed from: h */
        public String f9619h;

        /* renamed from: i */
        public String f9620i;

        /* renamed from: j */
        public String f9621j;

        /* renamed from: k */
        public DataModels.Country f9622k;

        /* renamed from: l */
        public final C2348l f9623l;

        /* compiled from: TipSession.java */
        /* renamed from: h.b.a.d.b0.i$d$a */
        /* loaded from: classes.dex */
        public class C2335a implements BackendListeners.CreateCustomerRequestListener {
            public C2335a() {
            }

            @Override // pt.card4b.backendbeacons.BackendListeners.BaseRequestListener
            public void onError(DataModels.Error error) {
                C2334d.this.f9623l.m1340a(error);
            }

            @Override // pt.card4b.backendbeacons.BackendListeners.CreateCustomerRequestListener
            public void onSuccess() {
                C2334d.this.f9623l.m1339d();
            }
        }

        public C2334d() {
            this.f9623l = new C2348l(TipSession.this, null);
        }

        @Override // p205h.p208b.p209a.p210d.UserProfile
        /* renamed from: a */
        public String mo1248a() {
            return this.f9613b;
        }

        @Override // p205h.p208b.p209a.p210d.UserProfile
        /* renamed from: b */
        public String mo1247b() {
            return "";
        }

        @Override // p205h.p208b.p209a.p210d.UserProfile.InterfaceC2372a
        /* renamed from: b */
        public void mo1233b(String str) {
            this.f9613b = str;
        }

        @Override // p205h.p208b.p209a.p210d.UserProfile
        /* renamed from: c */
        public String mo1246c() {
            return this.f9619h;
        }

        @Override // p205h.p208b.p209a.p210d.UserProfile
        /* renamed from: d */
        public List<UserProfile.InterfaceC2376c> mo1245d() {
            return new ArrayList();
        }

        @Override // p205h.p208b.p209a.p210d.UserProfile
        /* renamed from: e */
        public String mo1244e() {
            return this.f9620i;
        }

        @Override // p205h.p208b.p209a.p210d.UserProfile
        public UserProfile.InterfaceC2377d edit() {
            return null;
        }

        @Override // p205h.p208b.p209a.p210d.UserProfile
        /* renamed from: f */
        public String mo1243f() {
            return this.f9616e;
        }

        @Override // p205h.p208b.p209a.p210d.UserProfile
        /* renamed from: g */
        public String mo1242g() {
            return this.f9617f;
        }

        @Override // p205h.p208b.p209a.p210d.UserProfile
        /* renamed from: h */
        public String mo1241h() {
            return this.f9614c;
        }

        @Override // p205h.p208b.p209a.p210d.UserProfile
        /* renamed from: i */
        public String mo1240i() {
            return this.f9618g;
        }

        @Override // p205h.p208b.p209a.p210d.UserProfile
        /* renamed from: j */
        public UserProfile.InterfaceC2373b mo1239j() {
            return null;
        }

        @Override // p205h.p208b.p209a.p210d.UserProfile.InterfaceC2372a
        /* renamed from: j */
        public void mo1225j(String str) {
            this.f9620i = str;
        }

        @Override // p205h.p208b.p209a.p210d.UserProfile
        /* renamed from: k */
        public String mo1238k() {
            return this.f9615d;
        }

        @Override // p205h.p208b.p209a.p210d.UserProfile
        /* renamed from: l */
        public String mo1237l() {
            return this.f9622k.getCode();
        }

        @Override // p205h.p208b.p209a.p210d.UserProfile
        /* renamed from: m */
        public String mo1236m() {
            return this.f9621j;
        }

        @Override // p205h.p208b.p209a.p210d.Session.InterfaceC2367b
        /* renamed from: n */
        public AsyncResult<Session.AbstractC2368c> mo1272n() {
            return this.f9623l;
        }

        @Override // p205h.p208b.p209a.p210d.Session.InterfaceC2367b
        /* renamed from: p */
        public void mo1271p() {
            BackEnd.createNewCustomerAccount(new DataModels.UserAccountInfo("00000000-0000-0000-0000-000000000000", this.f9613b, this.f9614c, "", this.f9616e, "", "", "", "0", "", new DataModels.UserBillingInfo(null, this.f9618g, this.f9615d, this.f9619h, this.f9617f, this.f9620i, this.f9622k, this.f9621j), null, null), this.f9612a, new C2335a());
        }

        @Override // p205h.p208b.p209a.p210d.UserProfile.InterfaceC2372a
        /* renamed from: a */
        public void mo1234a(DataModels.Country country) {
            this.f9622k = country;
        }

        @Override // p205h.p208b.p209a.p210d.UserProfile.InterfaceC2372a
        /* renamed from: c */
        public void mo1232c(String str) {
            this.f9614c = str;
        }

        @Override // p205h.p208b.p209a.p210d.UserProfile.InterfaceC2372a
        /* renamed from: d */
        public void mo1231d(String str) {
            this.f9615d = str;
        }

        @Override // p205h.p208b.p209a.p210d.UserProfile.InterfaceC2372a
        /* renamed from: e */
        public void mo1230e(String str) {
            this.f9616e = str;
        }

        @Override // p205h.p208b.p209a.p210d.UserProfile.InterfaceC2372a
        /* renamed from: f */
        public void mo1229f(String str) {
            this.f9617f = str;
        }

        @Override // p205h.p208b.p209a.p210d.UserProfile.InterfaceC2372a
        /* renamed from: g */
        public void mo1228g(String str) {
            this.f9618g = str;
        }

        @Override // p205h.p208b.p209a.p210d.UserProfile.InterfaceC2372a
        /* renamed from: h */
        public void mo1227h(String str) {
            this.f9619h = str;
        }

        @Override // p205h.p208b.p209a.p210d.UserProfile.InterfaceC2372a
        /* renamed from: i */
        public void mo1226i(String str) {
            this.f9612a = str;
        }

        @Override // p205h.p208b.p209a.p210d.UserProfile.InterfaceC2372a
        /* renamed from: a */
        public void mo1235a(String str) {
            this.f9621j = str;
        }
    }

    /* compiled from: TipSession.java */
    /* renamed from: h.b.a.d.b0.i$e */
    /* loaded from: classes.dex */
    public class C2336e implements BackendListeners.GetUserAccountListener {

        /* renamed from: a */
        public final /* synthetic */ RemoteUserListener f9626a;

        public C2336e(TipSession tipSession, RemoteUserListener remoteUserListener) {
            this.f9626a = remoteUserListener;
        }

        @Override // pt.card4b.backendbeacons.BackendListeners.BaseRequestListener
        public void onError(DataModels.Error error) {
            Log.d("TipSession.class", "TipSession: getUserAccount onError invoked with error " + error.getMessage());
            this.f9626a.onError(error);
        }

        @Override // pt.card4b.backendbeacons.BackendListeners.GetUserAccountListener
        public void onSuccess(DataModels.UserAccountInfo userAccountInfo) {
            Log.d("TipSession.class", "TipSession: getUserAccount onSuccess invoked");
            this.f9626a.onSuccess(userAccountInfo);
        }
    }

    /* compiled from: TipSession.java */
    /* renamed from: h.b.a.d.b0.i$f */
    /* loaded from: classes.dex */
    public class C2337f implements UserProfile.InterfaceC2373b {

        /* renamed from: a */
        public final /* synthetic */ DataModels.PaymentMethod f9627a;

        /* renamed from: b */
        public final /* synthetic */ boolean f9628b;

        public C2337f(TipSession tipSession, DataModels.PaymentMethod paymentMethod, boolean z) {
            this.f9627a = paymentMethod;
            this.f9628b = z;
        }

        @Override // p205h.p208b.p209a.p210d.UserProfile.InterfaceC2373b
        /* renamed from: a */
        public String mo1224a() {
            return this.f9627a.getName();
        }

        @Override // p205h.p208b.p209a.p210d.UserProfile.InterfaceC2373b
        /* renamed from: b */
        public String mo1223b() {
            return this.f9627a.getThumbnailURL();
        }

        @Override // p205h.p208b.p209a.p210d.UserProfile.InterfaceC2373b
        /* renamed from: c */
        public String mo1222c() {
            return this.f9627a.getCode();
        }

        @Override // p205h.p208b.p209a.p210d.UserProfile.InterfaceC2373b
        /* renamed from: d */
        public String mo1221d() {
            if (!this.f9628b || m1352g().equals(UserProfile.InterfaceC2373b.EnumC2374a.ACTIVE)) {
                return null;
            }
            Context m1468W = Anda.m1468W();
            return m1468W.getString(C1444R.string.payment_instructions) + "\n\n" + m1468W.getString(C1444R.string.payment_lowvalue_instructions_first) + "\n\n" + m1468W.getString(C1444R.string.payment_lowvalue_instructions_second) + "\n\n" + m1468W.getString(C1444R.string.payment_lowvalue_instructions_third) + "\n\n\n" + m1468W.getString(C1444R.string.payment_lowvalue_instructions_fourth);
        }

        @Override // p205h.p208b.p209a.p210d.UserProfile.InterfaceC2373b
        /* renamed from: e */
        public UserProfile.InterfaceC2373b.EnumC2375b mo1220e() {
            if (this.f9628b) {
                return UserProfile.InterfaceC2373b.EnumC2375b.LOW_VALUE;
            }
            return UserProfile.InterfaceC2373b.EnumC2375b.CREDIT_CARD;
        }

        @Override // p205h.p208b.p209a.p210d.UserProfile.InterfaceC2373b
        /* renamed from: f */
        public String mo1219f() {
            return this.f9627a.getInfoToCustomer();
        }

        /* renamed from: g */
        public UserProfile.InterfaceC2373b.EnumC2374a m1352g() {
            int i = C2338g.f9629a[this.f9627a.getStatus().ordinal()];
            if (i != 1) {
                if (i != 2) {
                    if (i != 3) {
                        return UserProfile.InterfaceC2373b.EnumC2374a.UNKNOWN;
                    }
                    return UserProfile.InterfaceC2373b.EnumC2374a.CANCELLED;
                }
                return UserProfile.InterfaceC2373b.EnumC2374a.ACTIVATION_PENDING;
            }
            return UserProfile.InterfaceC2373b.EnumC2374a.ACTIVE;
        }
    }

    /* compiled from: TipSession.java */
    /* renamed from: h.b.a.d.b0.i$g */
    /* loaded from: classes.dex */
    public static /* synthetic */ class C2338g {

        /* renamed from: a */
        public static final /* synthetic */ int[] f9629a = new int[DataModels.PaymentStatus.values().length];

        static {
            try {
                f9629a[DataModels.PaymentStatus.ACTIVE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f9629a[DataModels.PaymentStatus.ACTIVATION_PENDING.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f9629a[DataModels.PaymentStatus.CANCELLED.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    /* compiled from: TipSession.java */
    /* renamed from: h.b.a.d.b0.i$h */
    /* loaded from: classes.dex */
    public static class C2339h extends AsyncResult.AbstractC2280b<Billing> implements BackendListeners.TariffInfoRequestListener {

        /* renamed from: e */
        public Billing f9633e;

        /* renamed from: b */
        public final List<BillingProduct> f9630b = new ArrayList();

        /* renamed from: c */
        public final List<Invoice> f9631c = new ArrayList();

        /* renamed from: d */
        public final HashMap<String, List<Trip>> f9632d = new HashMap<>();

        /* renamed from: f */
        public boolean f9634f = false;

        /* renamed from: g */
        public ErrorListener.C2358a f9635g = null;

        /* compiled from: TipSession.java */
        /* renamed from: h.b.a.d.b0.i$h$a */
        /* loaded from: classes.dex */
        public class C2340a implements BillingProduct {

            /* renamed from: a */
            public final /* synthetic */ List f9636a;

            /* renamed from: b */
            public final /* synthetic */ DataModels.TariffInfo f9637b;

            public C2340a(C2339h c2339h, List list, DataModels.TariffInfo tariffInfo) {
                this.f9636a = list;
                this.f9637b = tariffInfo;
            }

            @Override // p205h.p208b.p209a.p210d.BillingProduct
            /* renamed from: a */
            public String mo1328a() {
                return this.f9637b.getStageInfo().get(0).getTariffInfo();
            }

            @Override // p205h.p208b.p209a.p210d.BillingProduct
            /* renamed from: b */
            public double mo1327b() {
                return this.f9637b.getTotalDebt() / 100.0f;
            }

            @Override // p205h.p208b.p209a.p210d.BillingProduct
            /* renamed from: c */
            public List<Trip> mo1326c() {
                return this.f9636a;
            }
        }

        /* compiled from: TipSession.java */
        /* renamed from: h.b.a.d.b0.i$h$b */
        /* loaded from: classes.dex */
        public class C2341b implements Invoice {

            /* renamed from: a */
            public final /* synthetic */ DataModels.InvoiceInfo f9638a;

            public C2341b(C2339h c2339h, DataModels.InvoiceInfo invoiceInfo) {
                this.f9638a = invoiceInfo;
            }

            @Override // p205h.p208b.p209a.p210d.Invoice
            /* renamed from: a */
            public Date mo1318a() {
                return this.f9638a.getIssueDate();
            }

            @Override // p205h.p208b.p209a.p210d.Invoice
            /* renamed from: b */
            public float mo1317b() {
                return this.f9638a.getTotal();
            }

            @Override // p205h.p208b.p209a.p210d.Invoice
            /* renamed from: c */
            public String mo1316c() {
                return this.f9638a.getDocumentLink();
            }

            @Override // p205h.p208b.p209a.p210d.Invoice
            /* renamed from: d */
            public String mo1315d() {
                return this.f9638a.getInvoiceId();
            }

            @Override // p205h.p208b.p209a.p210d.Invoice
            /* renamed from: e */
            public String mo1314e() {
                return this.f9638a.getDocumentNumber();
            }
        }

        /* compiled from: TipSession.java */
        /* renamed from: h.b.a.d.b0.i$h$c */
        /* loaded from: classes.dex */
        public class C2342c implements Billing {
            public C2342c() {
            }

            @Override // p205h.p208b.p209a.p210d.Billing
            /* renamed from: a */
            public List<BillingProduct> mo1330a() {
                return C2339h.this.f9630b;
            }

            @Override // p205h.p208b.p209a.p210d.Billing
            /* renamed from: b */
            public List<Invoice> mo1329b() {
                return C2339h.this.f9631c;
            }
        }

        public C2339h(long j) {
            Calendar calendar = Calendar.getInstance();
            calendar.setTimeInMillis(j);
            calendar.set(5, 1);
            calendar.set(11, 0);
            calendar.set(12, 0);
            calendar.set(13, 0);
            calendar.set(14, 0);
            BackEnd.getTariffInfo(calendar.getTime(), this);
        }

        @Override // p205h.p208b.p209a.p210d.AsyncResult.AbstractC2280b
        /* renamed from: d */
        public ErrorListener.C2358a mo1349d() {
            return this.f9635g;
        }

        @Override // pt.card4b.backendbeacons.BackendListeners.BaseRequestListener
        public void onError(DataModels.Error error) {
            String str;
            StringBuilder sb = new StringBuilder();
            sb.append("Error:");
            if (error == null) {
                str = "null";
            } else {
                str = error.getMessage() + ": " + error.getMessageToUser();
            }
            sb.append(str);
            Log.e("Anda:Billing", sb.toString());
            this.f9635g = TipErrorConverter.m1372a(error);
            this.f9634f = true;
            m1374c();
        }

        @Override // pt.card4b.backendbeacons.BackendListeners.TariffInfoRequestListener
        public void onSuccess(List<DataModels.TariffInfo> list, List<DataModels.InvoiceInfo> list2) {
            for (DataModels.TariffInfo tariffInfo : list) {
                ArrayList arrayList = new ArrayList();
                for (DataModels.StageInfo stageInfo : tariffInfo.getStageInfo()) {
                    Trip m1371a = TipHistory.m1371a(stageInfo);
                    arrayList.add(m1371a);
                    if (m1371a.mo1258g()) {
                        if (!this.f9632d.containsKey(m1371a.mo1261d())) {
                            this.f9632d.put(m1371a.mo1261d(), new ArrayList());
                        }
                        List<Trip> list3 = this.f9632d.get(m1371a.mo1261d());
                        list3.add(m1371a);
                        this.f9632d.put(m1371a.mo1261d(), list3);
                    }
                }
                this.f9630b.add(new C2340a(this, arrayList, tariffInfo));
            }
            for (DataModels.InvoiceInfo invoiceInfo : list2) {
                this.f9631c.add(new C2341b(this, invoiceInfo));
            }
            this.f9633e = new C2342c();
            this.f9634f = true;
            m1374c();
        }

        @Override // p205h.p208b.p209a.p210d.AsyncResult
        /* renamed from: b */
        public boolean mo1333b() {
            return this.f9634f;
        }

        @Override // p205h.p208b.p209a.p210d.AsyncResult
        /* renamed from: a */
        public Billing mo1334a() {
            return this.f9633e;
        }
    }

    /* compiled from: TipSession.java */
    /* renamed from: h.b.a.d.b0.i$i */
    /* loaded from: classes.dex */
    public class C2343i extends AsyncResult<UserProfile> {

        /* renamed from: b */
        public DataModels.UserAccountInfo f9640b;

        /* renamed from: c */
        public List<UserProfile.InterfaceC2376c> f9641c = new ArrayList();

        /* compiled from: TipSession.java */
        /* renamed from: h.b.a.d.b0.i$i$a */
        /* loaded from: classes.dex */
        public class C2344a implements UserProfile.InterfaceC2376c {

            /* renamed from: a */
            public final /* synthetic */ DataModels.UserProfileInfo f9643a;

            public C2344a(C2343i c2343i, TipSession tipSession, DataModels.UserProfileInfo userProfileInfo) {
                this.f9643a = userProfileInfo;
            }

            @Override // p205h.p208b.p209a.p210d.UserProfile.InterfaceC2376c
            /* renamed from: a */
            public String mo1218a() {
                return this.f9643a.getProfileName();
            }

            @Override // p205h.p208b.p209a.p210d.UserProfile.InterfaceC2376c
            /* renamed from: b */
            public Date mo1217b() {
                return this.f9643a.getEndDate();
            }

            @Override // p205h.p208b.p209a.p210d.UserProfile.InterfaceC2376c
            /* renamed from: c */
            public Date mo1216c() {
                return this.f9643a.getStartDate();
            }
        }

        /* compiled from: TipSession.java */
        /* renamed from: h.b.a.d.b0.i$i$b */
        /* loaded from: classes.dex */
        public class C2345b implements UserProfile {
            public C2345b() {
            }

            @Override // p205h.p208b.p209a.p210d.UserProfile
            /* renamed from: a */
            public String mo1248a() {
                return C2343i.this.f9640b.getName();
            }

            @Override // p205h.p208b.p209a.p210d.UserProfile
            /* renamed from: b */
            public String mo1247b() {
                return C2343i.this.f9640b.getPhoto();
            }

            @Override // p205h.p208b.p209a.p210d.UserProfile
            /* renamed from: c */
            public String mo1246c() {
                return C2343i.this.f9640b.getBillingInfo().getCity();
            }

            @Override // p205h.p208b.p209a.p210d.UserProfile
            /* renamed from: d */
            public List<UserProfile.InterfaceC2376c> mo1245d() {
                return C2343i.this.f9641c;
            }

            @Override // p205h.p208b.p209a.p210d.UserProfile
            /* renamed from: e */
            public String mo1244e() {
                return C2343i.this.f9640b.getBillingInfo().getFiscalNumber();
            }

            @Override // p205h.p208b.p209a.p210d.UserProfile
            public UserProfile.InterfaceC2377d edit() {
                C2343i c2343i = C2343i.this;
                return new C2350m(TipSession.this, c2343i.f9640b, null);
            }

            @Override // p205h.p208b.p209a.p210d.UserProfile
            /* renamed from: f */
            public String mo1243f() {
                return C2343i.this.f9640b.getPhonenumber();
            }

            @Override // p205h.p208b.p209a.p210d.UserProfile
            /* renamed from: g */
            public String mo1242g() {
                return C2343i.this.f9640b.getBillingInfo().getPostalCode();
            }

            @Override // p205h.p208b.p209a.p210d.UserProfile
            /* renamed from: h */
            public String mo1241h() {
                return C2343i.this.f9640b.getEmail();
            }

            @Override // p205h.p208b.p209a.p210d.UserProfile
            /* renamed from: i */
            public String mo1240i() {
                return C2343i.this.f9640b.getBillingInfo().getName();
            }

            @Override // p205h.p208b.p209a.p210d.UserProfile
            /* renamed from: j */
            public UserProfile.InterfaceC2373b mo1239j() {
                return TipSession.this.m1359a(C2343i.this.f9640b.getPaymentMethod());
            }

            @Override // p205h.p208b.p209a.p210d.UserProfile
            /* renamed from: k */
            public String mo1238k() {
                return C2343i.this.f9640b.getBillingInfo().getAddress();
            }

            @Override // p205h.p208b.p209a.p210d.UserProfile
            /* renamed from: l */
            public String mo1237l() {
                return C2343i.this.f9640b.getBillingInfo().getCountry().getCode();
            }

            @Override // p205h.p208b.p209a.p210d.UserProfile
            /* renamed from: m */
            public String mo1236m() {
                return C2343i.this.f9640b.getBillingInfo().getNotifyEmail();
            }
        }

        public C2343i(DataModels.UserAccountInfo userAccountInfo) {
            this.f9640b = userAccountInfo;
            List<DataModels.UserProfileInfo> profileInfo = userAccountInfo.getProfileInfo();
            if (profileInfo != null) {
                for (DataModels.UserProfileInfo userProfileInfo : profileInfo) {
                    this.f9641c.add(new C2344a(this, TipSession.this, userProfileInfo));
                }
                Collections.sort(this.f9641c, C2281a.f9533a);
            }
        }

        @Override // p205h.p208b.p209a.p210d.AsyncResult
        /* renamed from: b */
        public boolean mo1333b() {
            return this.f9640b != null;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // p205h.p208b.p209a.p210d.AsyncResult
        /* renamed from: a */
        public UserProfile mo1334a() {
            return new C2345b();
        }
    }

    /* compiled from: TipSession.java */
    /* renamed from: h.b.a.d.b0.i$j */
    /* loaded from: classes.dex */
    public class C2346j extends AsyncResult<Session.C2366a> {

        /* renamed from: b */
        public final String f9645b;

        /* renamed from: c */
        public byte f9646c;

        /* renamed from: d */
        public DataModels.Error f9647d;

        public /* synthetic */ C2346j(TipSession tipSession, String str, String str2, C2330a c2330a) {
            this(str, str2);
        }

        @Override // p205h.p208b.p209a.p210d.AsyncResult
        /* renamed from: b */
        public boolean mo1333b() {
            return this.f9646c != 0;
        }

        public C2346j(String str, String str2) {
            this.f9646c = (byte) 0;
            this.f9645b = str;
        }

        /* renamed from: a */
        public void m1344a(DataModels.User user) {
            TipSession.this.f9603e = user;
            TipSession.this.f9602d = true;
            PreferenceManager.getDefaultSharedPreferences(TipSession.this.f9600b).edit().putBoolean("session", true).apply();
            this.f9646c = (byte) 1;
            m1374c();
        }

        /* renamed from: a */
        public void m1345a(DataModels.Error error) {
            this.f9647d = error;
            TipSession.this.m1354f();
            this.f9646c = (byte) -1;
            m1374c();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // p205h.p208b.p209a.p210d.AsyncResult
        /* renamed from: a */
        public Session.C2366a mo1334a() {
            byte b = this.f9646c;
            if (b == 0) {
                return null;
            }
            boolean z = b == 1;
            String str = this.f9645b;
            DataModels.Error error = this.f9647d;
            return new Session.C2366a(z, str, error != null ? error.getMessageToUser() : null);
        }
    }

    /* compiled from: TipSession.java */
    /* renamed from: h.b.a.d.b0.i$k */
    /* loaded from: classes.dex */
    public class C2347k extends AsyncResult<User.C2371a> {

        /* renamed from: b */
        public byte f9649b;

        public C2347k() {
            this.f9649b = (byte) 0;
        }

        @Override // p205h.p208b.p209a.p210d.AsyncResult
        /* renamed from: b */
        public boolean mo1333b() {
            return this.f9649b != 0;
        }

        /* renamed from: d */
        public void m1343d() {
            this.f9649b = (byte) -1;
            m1374c();
        }

        /* renamed from: e */
        public void m1342e() {
            TipSession.this.m1354f();
            this.f9649b = (byte) 1;
            m1374c();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // p205h.p208b.p209a.p210d.AsyncResult
        /* renamed from: a */
        public User.C2371a mo1334a() {
            byte b = this.f9649b;
            if (b == 0) {
                return null;
            }
            return new User.C2371a(b == 1);
        }

        public /* synthetic */ C2347k(TipSession tipSession, C2330a c2330a) {
            this();
        }
    }

    /* compiled from: TipSession.java */
    /* renamed from: h.b.a.d.b0.i$m */
    /* loaded from: classes.dex */
    public class C2350m implements UserProfile.InterfaceC2377d {

        /* renamed from: a */
        public final DataModels.UserAccountInfo f9654a;

        /* compiled from: TipSession.java */
        /* renamed from: h.b.a.d.b0.i$m$a */
        /* loaded from: classes.dex */
        public class C2351a implements BackendListeners.UpdateUserRequestListener {

            /* renamed from: a */
            public final /* synthetic */ C2353c f9656a;

            public C2351a(C2353c c2353c) {
                this.f9656a = c2353c;
            }

            @Override // pt.card4b.backendbeacons.BackendListeners.BaseRequestListener
            public void onError(DataModels.Error error) {
                this.f9656a.m1336a(error);
            }

            @Override // pt.card4b.backendbeacons.BackendListeners.UpdateUserRequestListener
            public void onSuccess(boolean z) {
                C2350m c2350m = C2350m.this;
                TipSession.this.f9603e = new DataModels.User(c2350m.f9654a.getId(), C2350m.this.f9654a.getName(), C2350m.this.f9654a.getEmail(), C2350m.this.f9654a.getPhonenumber(), C2350m.this.f9654a.getPhoto(), Boolean.valueOf(C2350m.this.f9654a.getPaymentMethod() != null));
                this.f9656a.m1335d();
                if (z) {
                    TipSession.this.mo1278b().mo1251a();
                }
            }
        }

        /* compiled from: TipSession.java */
        /* renamed from: h.b.a.d.b0.i$m$b */
        /* loaded from: classes.dex */
        public class C2352b implements BackendListeners.DefaultRequestListener {

            /* renamed from: a */
            public final /* synthetic */ C2353c f9658a;

            public C2352b(C2353c c2353c) {
                this.f9658a = c2353c;
            }

            @Override // pt.card4b.backendbeacons.BackendListeners.DefaultRequestListener
            public void onError(DataModels.Error error) {
                this.f9658a.m1336a(error);
            }

            @Override // pt.card4b.backendbeacons.BackendListeners.DefaultRequestListener
            public void onSuccess() {
                C2350m c2350m = C2350m.this;
                TipSession.this.f9603e = new DataModels.User(c2350m.f9654a.getId(), C2350m.this.f9654a.getName(), C2350m.this.f9654a.getEmail(), C2350m.this.f9654a.getPhonenumber(), C2350m.this.f9654a.getPhoto(), Boolean.valueOf(C2350m.this.f9654a.getPaymentMethod() != null));
                this.f9658a.m1335d();
            }
        }

        public /* synthetic */ C2350m(TipSession tipSession, DataModels.UserAccountInfo userAccountInfo, C2330a c2330a) {
            this(userAccountInfo);
        }

        @Override // p205h.p208b.p209a.p210d.UserProfile.InterfaceC2372a
        /* renamed from: b */
        public void mo1233b(String str) {
            this.f9654a.setName(str);
        }

        @Override // p205h.p208b.p209a.p210d.UserProfile.InterfaceC2372a
        /* renamed from: c */
        public void mo1232c(String str) {
            this.f9654a.setEmail(str);
        }

        @Override // p205h.p208b.p209a.p210d.UserProfile.InterfaceC2372a
        /* renamed from: d */
        public void mo1231d(String str) {
            this.f9654a.getBillingInfo().setAddress(str);
        }

        @Override // p205h.p208b.p209a.p210d.UserProfile.InterfaceC2372a
        /* renamed from: e */
        public void mo1230e(String str) {
            this.f9654a.setPhonenumber(str);
        }

        @Override // p205h.p208b.p209a.p210d.UserProfile
        public UserProfile.InterfaceC2377d edit() {
            return this;
        }

        @Override // p205h.p208b.p209a.p210d.UserProfile
        /* renamed from: f */
        public String mo1243f() {
            return this.f9654a.getPhonenumber();
        }

        @Override // p205h.p208b.p209a.p210d.UserProfile
        /* renamed from: g */
        public String mo1242g() {
            return this.f9654a.getBillingInfo().getPostalCode();
        }

        @Override // p205h.p208b.p209a.p210d.UserProfile
        /* renamed from: h */
        public String mo1241h() {
            return this.f9654a.getEmail();
        }

        @Override // p205h.p208b.p209a.p210d.UserProfile
        /* renamed from: i */
        public String mo1240i() {
            return this.f9654a.getBillingInfo().getName();
        }

        @Override // p205h.p208b.p209a.p210d.UserProfile.InterfaceC2372a
        /* renamed from: j */
        public void mo1225j(String str) {
            this.f9654a.getBillingInfo().setFiscalNumber(str);
        }

        @Override // p205h.p208b.p209a.p210d.UserProfile
        /* renamed from: k */
        public String mo1238k() {
            return this.f9654a.getBillingInfo().getAddress();
        }

        @Override // p205h.p208b.p209a.p210d.UserProfile
        /* renamed from: l */
        public String mo1237l() {
            return this.f9654a.getBillingInfo().getCountry().getCode();
        }

        @Override // p205h.p208b.p209a.p210d.UserProfile
        /* renamed from: m */
        public String mo1236m() {
            return this.f9654a.getBillingInfo().getNotifyEmail();
        }

        @Override // p205h.p208b.p209a.p210d.UserProfile.InterfaceC2377d
        /* renamed from: o */
        public AsyncResult<Session.AbstractC2369d> mo1214o() {
            C2353c c2353c = new C2353c(this, null);
            BackEnd.updateUserData(this.f9654a, new C2351a(c2353c));
            return c2353c;
        }

        /* compiled from: TipSession.java */
        /* renamed from: h.b.a.d.b0.i$m$c */
        /* loaded from: classes.dex */
        public class C2353c extends AsyncResult<Session.AbstractC2369d> {

            /* renamed from: b */
            public byte f9660b;

            /* renamed from: c */
            public DataModels.Error f9661c;

            /* compiled from: TipSession.java */
            /* renamed from: h.b.a.d.b0.i$m$c$a */
            /* loaded from: classes.dex */
            public class C2354a extends Session.AbstractC2369d {
                public C2354a(boolean z) {
                    super(z);
                }

                @Override // p205h.p208b.p209a.p210d.Session.AbstractC2369d
                /* renamed from: b */
                public String mo1269b() {
                    if (C2353c.this.f9661c == null) {
                        return null;
                    }
                    return C2353c.this.f9661c.getMessageToUser();
                }
            }

            public C2353c(C2350m c2350m) {
                this.f9660b = (byte) 0;
            }

            @Override // p205h.p208b.p209a.p210d.AsyncResult
            /* renamed from: b */
            public boolean mo1333b() {
                return this.f9660b != 0;
            }

            /* renamed from: d */
            public void m1335d() {
                this.f9660b = (byte) 1;
                m1374c();
            }

            public /* synthetic */ C2353c(C2350m c2350m, C2330a c2330a) {
                this(c2350m);
            }

            /* renamed from: a */
            public void m1336a(DataModels.Error error) {
                this.f9660b = (byte) -1;
                this.f9661c = error;
                m1374c();
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // p205h.p208b.p209a.p210d.AsyncResult
            /* renamed from: a */
            public Session.AbstractC2369d mo1334a() {
                return new C2354a(this.f9660b == 1);
            }
        }

        public C2350m(DataModels.UserAccountInfo userAccountInfo) {
            this.f9654a = new DataModels.UserAccountInfo(userAccountInfo.getId(), userAccountInfo.getName(), userAccountInfo.getEmail(), userAccountInfo.getAddress(), userAccountInfo.getPhonenumber(), userAccountInfo.getPostalcode(), userAccountInfo.getFiscalnumber(), userAccountInfo.getIdnumber(), userAccountInfo.getTipCode(), userAccountInfo.getPhoto(), userAccountInfo.getBillingInfo(), userAccountInfo.getProfileInfo(), userAccountInfo.getPaymentMethod());
        }

        @Override // p205h.p208b.p209a.p210d.UserProfile
        /* renamed from: a */
        public String mo1248a() {
            return this.f9654a.getName();
        }

        @Override // p205h.p208b.p209a.p210d.UserProfile
        /* renamed from: b */
        public String mo1247b() {
            return this.f9654a.getPhoto();
        }

        @Override // p205h.p208b.p209a.p210d.UserProfile
        /* renamed from: c */
        public String mo1246c() {
            return this.f9654a.getBillingInfo().getCity();
        }

        @Override // p205h.p208b.p209a.p210d.UserProfile
        /* renamed from: d */
        public List<UserProfile.InterfaceC2376c> mo1245d() {
            return new ArrayList();
        }

        @Override // p205h.p208b.p209a.p210d.UserProfile
        /* renamed from: e */
        public String mo1244e() {
            return this.f9654a.getBillingInfo().getFiscalNumber();
        }

        @Override // p205h.p208b.p209a.p210d.UserProfile.InterfaceC2372a
        /* renamed from: f */
        public void mo1229f(String str) {
            this.f9654a.getBillingInfo().setPostalCode(str);
        }

        @Override // p205h.p208b.p209a.p210d.UserProfile.InterfaceC2372a
        /* renamed from: g */
        public void mo1228g(String str) {
            this.f9654a.getBillingInfo().setName(str);
        }

        @Override // p205h.p208b.p209a.p210d.UserProfile.InterfaceC2372a
        /* renamed from: h */
        public void mo1227h(String str) {
            this.f9654a.getBillingInfo().setCity(str);
        }

        @Override // p205h.p208b.p209a.p210d.UserProfile
        /* renamed from: j */
        public UserProfile.InterfaceC2373b mo1239j() {
            return TipSession.this.m1359a(this.f9654a.getPaymentMethod());
        }

        @Override // p205h.p208b.p209a.p210d.UserProfile.InterfaceC2372a
        /* renamed from: a */
        public void mo1234a(DataModels.Country country) {
            this.f9654a.getBillingInfo().setCountry(country);
        }

        @Override // p205h.p208b.p209a.p210d.UserProfile.InterfaceC2372a
        /* renamed from: a */
        public void mo1235a(String str) {
            this.f9654a.getBillingInfo().setNotifyEmail(str);
        }

        @Override // p205h.p208b.p209a.p210d.UserProfile.InterfaceC2377d
        /* renamed from: a */
        public AsyncResult<Session.AbstractC2369d> mo1215a(String str, String str2, String str3) {
            C2353c c2353c = new C2353c(this, null);
            BackEnd.changeUserPwd(str, str2, str3, new C2352b(c2353c));
            return c2353c;
        }
    }

    /* compiled from: TipSession.java */
    /* renamed from: h.b.a.d.b0.i$n */
    /* loaded from: classes.dex */
    public class C2355n extends AsyncResult<UserProfile> {

        /* compiled from: TipSession.java */
        /* renamed from: h.b.a.d.b0.i$n$a */
        /* loaded from: classes.dex */
        public class C2356a implements UserProfile {
            public C2356a() {
            }

            @Override // p205h.p208b.p209a.p210d.UserProfile
            /* renamed from: a */
            public String mo1248a() {
                return TipSession.this.f9603e.getName();
            }

            @Override // p205h.p208b.p209a.p210d.UserProfile
            /* renamed from: b */
            public String mo1247b() {
                return TipSession.this.f9603e.getPhoto();
            }

            @Override // p205h.p208b.p209a.p210d.UserProfile
            /* renamed from: c */
            public String mo1246c() {
                return "";
            }

            @Override // p205h.p208b.p209a.p210d.UserProfile
            /* renamed from: d */
            public List<UserProfile.InterfaceC2376c> mo1245d() {
                return new ArrayList();
            }

            @Override // p205h.p208b.p209a.p210d.UserProfile
            /* renamed from: e */
            public String mo1244e() {
                return "";
            }

            @Override // p205h.p208b.p209a.p210d.UserProfile
            public UserProfile.InterfaceC2377d edit() {
                return null;
            }

            @Override // p205h.p208b.p209a.p210d.UserProfile
            /* renamed from: f */
            public String mo1243f() {
                return TipSession.this.f9603e.getPhonenumber();
            }

            @Override // p205h.p208b.p209a.p210d.UserProfile
            /* renamed from: g */
            public String mo1242g() {
                return "";
            }

            @Override // p205h.p208b.p209a.p210d.UserProfile
            /* renamed from: h */
            public String mo1241h() {
                return TipSession.this.f9603e.getEmail();
            }

            @Override // p205h.p208b.p209a.p210d.UserProfile
            /* renamed from: i */
            public String mo1240i() {
                return "";
            }

            @Override // p205h.p208b.p209a.p210d.UserProfile
            /* renamed from: j */
            public UserProfile.InterfaceC2373b mo1239j() {
                return null;
            }

            @Override // p205h.p208b.p209a.p210d.UserProfile
            /* renamed from: k */
            public String mo1238k() {
                return "";
            }

            @Override // p205h.p208b.p209a.p210d.UserProfile
            /* renamed from: l */
            public String mo1237l() {
                return "";
            }

            @Override // p205h.p208b.p209a.p210d.UserProfile
            /* renamed from: m */
            public String mo1236m() {
                return "";
            }
        }

        public C2355n() {
        }

        @Override // p205h.p208b.p209a.p210d.AsyncResult
        /* renamed from: b */
        public boolean mo1333b() {
            return TipSession.this.f9603e != null;
        }

        public /* synthetic */ C2355n(TipSession tipSession, C2330a c2330a) {
            this();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // p205h.p208b.p209a.p210d.AsyncResult
        /* renamed from: a */
        public UserProfile mo1334a() {
            return new C2356a();
        }
    }

    public TipSession(Anda anda, Context context) {
        this.f9599a = anda;
        this.f9600b = context;
        if (PreferenceManager.getDefaultSharedPreferences(context).getBoolean("session", false)) {
            this.f9602d = true;
        }
    }

    @Override // p205h.p208b.p209a.p210d.RemoteUserListener
    public void onError(DataModels.Error error) {
    }

    @Override // p205h.p208b.p209a.p210d.RemoteUserListener
    public void onSuccess(DataModels.UserAccountInfo userAccountInfo) {
    }

    /* compiled from: TipSession.java */
    /* renamed from: h.b.a.d.b0.i$a */
    /* loaded from: classes.dex */
    public class C2330a implements User {

        /* compiled from: TipSession.java */
        /* renamed from: h.b.a.d.b0.i$a$a */
        /* loaded from: classes.dex */
        public class C2331a implements BackendListeners.LogoutRequestListener {

            /* renamed from: a */
            public final /* synthetic */ C2347k f9606a;

            public C2331a(C2347k c2347k) {
                this.f9606a = c2347k;
            }

            @Override // pt.card4b.backendbeacons.BackendListeners.BaseRequestListener
            public void onError(DataModels.Error error) {
                this.f9606a.m1343d();
            }

            @Override // pt.card4b.backendbeacons.BackendListeners.LogoutRequestListener
            public void onSuccess() {
                this.f9606a.m1342e();
                TipSession.this.f9599a.m1427e();
                for (Session.InterfaceC2370e interfaceC2370e : TipSession.this.f9601c) {
                    interfaceC2370e.mo943a(TipSession.this.f9604f);
                }
            }
        }

        public C2330a() {
        }

        @Override // p205h.p208b.p209a.p210d.User
        /* renamed from: a */
        public AsyncResult<UserProfile> mo1250a(DataModels.UserAccountInfo userAccountInfo) {
            if (userAccountInfo != null) {
                return new C2343i(userAccountInfo);
            }
            if (TipSession.this.f9603e == null) {
                return null;
            }
            return new C2355n(TipSession.this, null);
        }

        @Override // p205h.p208b.p209a.p210d.User
        /* renamed from: b */
        public String mo1249b() {
            if (TipSession.this.f9603e == null) {
                return null;
            }
            return TipSession.this.f9603e.getName();
        }

        @Override // p205h.p208b.p209a.p210d.User
        /* renamed from: a */
        public AsyncResult<User.C2371a> mo1251a() {
            C2347k c2347k = new C2347k(TipSession.this, null);
            BackEnd.logout(new C2331a(c2347k));
            return c2347k;
        }
    }

    /* compiled from: TipSession.java */
    /* renamed from: h.b.a.d.b0.i$l */
    /* loaded from: classes.dex */
    public class C2348l extends AsyncResult<Session.AbstractC2368c> {

        /* renamed from: b */
        public byte f9651b;

        /* renamed from: c */
        public DataModels.Error f9652c;

        /* compiled from: TipSession.java */
        /* renamed from: h.b.a.d.b0.i$l$a */
        /* loaded from: classes.dex */
        public class C2349a extends Session.AbstractC2368c {
            public C2349a(boolean z) {
                super(z);
            }

            @Override // p205h.p208b.p209a.p210d.Session.AbstractC2369d
            /* renamed from: a */
            public String mo1270a() {
                if (C2348l.this.f9652c == null) {
                    return null;
                }
                return C2348l.this.f9652c.getMessage();
            }

            @Override // p205h.p208b.p209a.p210d.Session.AbstractC2369d
            /* renamed from: b */
            public String mo1269b() {
                if (C2348l.this.f9652c == null) {
                    return null;
                }
                return C2348l.this.f9652c.getMessageToUser();
            }
        }

        public C2348l(TipSession tipSession) {
            this.f9651b = (byte) 0;
        }

        @Override // p205h.p208b.p209a.p210d.AsyncResult
        /* renamed from: b */
        public boolean mo1333b() {
            return this.f9651b != 0;
        }

        /* renamed from: d */
        public void m1339d() {
            this.f9651b = (byte) 1;
            Anda.m1467X().m1445a(true);
            m1374c();
        }

        public /* synthetic */ C2348l(TipSession tipSession, C2330a c2330a) {
            this(tipSession);
        }

        /* renamed from: a */
        public void m1340a(DataModels.Error error) {
            this.f9651b = (byte) -1;
            this.f9652c = error;
            m1374c();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // p205h.p208b.p209a.p210d.AsyncResult
        /* renamed from: a */
        public Session.AbstractC2368c mo1334a() {
            byte b = this.f9651b;
            if (b == 0) {
                return null;
            }
            return new C2349a(b == 1);
        }
    }

    @Override // p205h.p208b.p209a.p210d.Session
    /* renamed from: b */
    public User mo1278b() {
        if (this.f9602d) {
            return this.f9604f;
        }
        return null;
    }

    @Override // p205h.p208b.p209a.p210d.Session
    /* renamed from: c */
    public void mo1276c() {
        User user = this.f9604f;
        m1354f();
        for (Session.InterfaceC2370e interfaceC2370e : this.f9601c) {
            interfaceC2370e.mo943a(user);
        }
    }

    @Override // p205h.p208b.p209a.p210d.Session
    /* renamed from: d */
    public History mo1275d() {
        return new TipHistory();
    }

    @Override // p205h.p208b.p209a.p210d.Session
    /* renamed from: e */
    public Session.InterfaceC2367b mo1274e() {
        return new C2334d();
    }

    /* renamed from: f */
    public final void m1354f() {
        try {
            Crashlytics.m6082a((String) null);
        } catch (Exception unused) {
        }
        this.f9603e = null;
        this.f9602d = false;
        PreferenceManager.getDefaultSharedPreferences(this.f9600b).edit().remove("session").apply();
    }

    @Override // p205h.p208b.p209a.p210d.Session
    /* renamed from: b */
    public void mo1277b(Session.InterfaceC2370e interfaceC2370e) {
        this.f9601c.remove(interfaceC2370e);
    }

    @Override // p205h.p208b.p209a.p210d.Session
    /* renamed from: a */
    public void mo1280a(Runnable runnable) {
        BackEnd.getSavedUser(new C2332b(runnable));
    }

    @Override // p205h.p208b.p209a.p210d.Session
    /* renamed from: a */
    public boolean mo1284a() {
        return this.f9602d;
    }

    @Override // p205h.p208b.p209a.p210d.Session
    /* renamed from: a */
    public AsyncResult<Session.C2366a> mo1279a(String str, String str2) {
        C2346j c2346j = new C2346j(this, str, str2, null);
        BackEnd.login(str, str2, new C2333c(c2346j));
        return c2346j;
    }

    @Override // p205h.p208b.p209a.p210d.Session
    /* renamed from: a */
    public void mo1282a(RemoteUserListener remoteUserListener) {
        BackEnd.getUserAccount(new C2336e(this, remoteUserListener));
    }

    @Override // p205h.p208b.p209a.p210d.Session
    /* renamed from: a */
    public AsyncResult.AbstractC2280b<Billing> mo1283a(long j, long j2) {
        return new C2339h(j);
    }

    @Override // p205h.p208b.p209a.p210d.Session
    /* renamed from: a */
    public void mo1281a(Session.InterfaceC2370e interfaceC2370e) {
        if (this.f9601c.contains(interfaceC2370e)) {
            return;
        }
        this.f9601c.add(interfaceC2370e);
    }

    /* renamed from: a */
    public final UserProfile.InterfaceC2373b m1359a(DataModels.PaymentMethod paymentMethod) {
        if (paymentMethod != null) {
            return new C2337f(this, paymentMethod, paymentMethod.getCode().equals("PBV"));
        }
        return null;
    }
}
