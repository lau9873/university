package h.b.a.d.b0;

import android.content.Context;
import android.preference.PreferenceManager;
import android.util.Log;
import h.b.a.d.b;
import h.b.a.d.f;
import h.b.a.d.s;
import h.b.a.d.u;
import h.b.a.d.w;
import h.b.a.d.x;
import h.b.a.d.y;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import pt.card4b.backendbeacons.BackEnd;
import pt.card4b.backendbeacons.BackendListeners;
import pt.card4b.backendbeacons.DataModels;
/* compiled from: TipSession.java */
/* loaded from: classes.dex */
public class i implements u, s {

    /* renamed from: a  reason: collision with root package name */
    public final h.b.a.c f6962a;

    /* renamed from: b  reason: collision with root package name */
    public final Context f6963b;

    /* renamed from: d  reason: collision with root package name */
    public boolean f6965d;

    /* renamed from: c  reason: collision with root package name */
    public List<u.e> f6964c = new ArrayList();

    /* renamed from: e  reason: collision with root package name */
    public DataModels.User f6966e = null;

    /* renamed from: f  reason: collision with root package name */
    public x f6967f = new a();

    /* compiled from: TipSession.java */
    /* loaded from: classes.dex */
    public class b implements BackendListeners.GetSavedUserRequestListener {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ Runnable f6971a;

        public b(Runnable runnable) {
            this.f6971a = runnable;
        }

        @Override // pt.card4b.backendbeacons.BackendListeners.BaseRequestListener
        public void onError(DataModels.Error error) {
            i.this.c();
        }

        @Override // pt.card4b.backendbeacons.BackendListeners.GetSavedUserRequestListener
        public void onSuccess(DataModels.User user) {
            i.this.f6966e = user;
            this.f6971a.run();
        }
    }

    /* compiled from: TipSession.java */
    /* loaded from: classes.dex */
    public class c implements BackendListeners.LoginRequestListener {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ j f6973a;

        public c(j jVar) {
            this.f6973a = jVar;
        }

        @Override // pt.card4b.backendbeacons.BackendListeners.BaseRequestListener
        public void onError(DataModels.Error error) {
            this.f6973a.a(error);
        }

        @Override // pt.card4b.backendbeacons.BackendListeners.LoginRequestListener
        public void onSuccess(DataModels.User user) {
            i.this.f6962a.a(true);
            this.f6973a.a(user);
            i.this.f6962a.a();
            i.this.f6962a.c();
            c.b.a.a.a(user.getName());
        }
    }

    /* compiled from: TipSession.java */
    /* loaded from: classes.dex */
    public class d implements u.b {

        /* renamed from: a  reason: collision with root package name */
        public String f6975a;

        /* renamed from: b  reason: collision with root package name */
        public String f6976b;

        /* renamed from: c  reason: collision with root package name */
        public String f6977c;

        /* renamed from: d  reason: collision with root package name */
        public String f6978d;

        /* renamed from: e  reason: collision with root package name */
        public String f6979e;

        /* renamed from: f  reason: collision with root package name */
        public String f6980f;

        /* renamed from: g  reason: collision with root package name */
        public String f6981g;

        /* renamed from: h  reason: collision with root package name */
        public String f6982h;

        /* renamed from: i  reason: collision with root package name */
        public String f6983i;
        public String j;
        public DataModels.Country k;
        public final l l;

        /* compiled from: TipSession.java */
        /* loaded from: classes.dex */
        public class a implements BackendListeners.CreateCustomerRequestListener {
            public a() {
            }

            @Override // pt.card4b.backendbeacons.BackendListeners.BaseRequestListener
            public void onError(DataModels.Error error) {
                d.this.l.a(error);
            }

            @Override // pt.card4b.backendbeacons.BackendListeners.CreateCustomerRequestListener
            public void onSuccess() {
                d.this.l.d();
            }
        }

        public d() {
            this.l = new l(i.this, null);
        }

        @Override // h.b.a.d.y
        public String a() {
            return this.f6976b;
        }

        @Override // h.b.a.d.y
        public String b() {
            return "";
        }

        @Override // h.b.a.d.y.a
        public void b(String str) {
            this.f6976b = str;
        }

        @Override // h.b.a.d.y
        public String c() {
            return this.f6982h;
        }

        @Override // h.b.a.d.y
        public List<y.c> d() {
            return new ArrayList();
        }

        @Override // h.b.a.d.y
        public String e() {
            return this.f6983i;
        }

        @Override // h.b.a.d.y
        public y.d edit() {
            return null;
        }

        @Override // h.b.a.d.y
        public String f() {
            return this.f6979e;
        }

        @Override // h.b.a.d.y
        public String g() {
            return this.f6980f;
        }

        @Override // h.b.a.d.y
        public String h() {
            return this.f6977c;
        }

        @Override // h.b.a.d.y
        public String i() {
            return this.f6981g;
        }

        @Override // h.b.a.d.y
        public y.b j() {
            return null;
        }

        @Override // h.b.a.d.y.a
        public void j(String str) {
            this.f6983i = str;
        }

        @Override // h.b.a.d.y
        public String k() {
            return this.f6978d;
        }

        @Override // h.b.a.d.y
        public String l() {
            return this.k.getCode();
        }

        @Override // h.b.a.d.y
        public String m() {
            return this.j;
        }

        @Override // h.b.a.d.u.b
        public h.b.a.d.b<u.c> n() {
            return this.l;
        }

        @Override // h.b.a.d.u.b
        public void p() {
            BackEnd.createNewCustomerAccount(new DataModels.UserAccountInfo("00000000-0000-0000-0000-000000000000", this.f6976b, this.f6977c, "", this.f6979e, "", "", "", "0", "", new DataModels.UserBillingInfo(null, this.f6981g, this.f6978d, this.f6982h, this.f6980f, this.f6983i, this.k, this.j), null, null), this.f6975a, new a());
        }

        @Override // h.b.a.d.y.a
        public void a(DataModels.Country country) {
            this.k = country;
        }

        @Override // h.b.a.d.y.a
        public void c(String str) {
            this.f6977c = str;
        }

        @Override // h.b.a.d.y.a
        public void d(String str) {
            this.f6978d = str;
        }

        @Override // h.b.a.d.y.a
        public void e(String str) {
            this.f6979e = str;
        }

        @Override // h.b.a.d.y.a
        public void f(String str) {
            this.f6980f = str;
        }

        @Override // h.b.a.d.y.a
        public void g(String str) {
            this.f6981g = str;
        }

        @Override // h.b.a.d.y.a
        public void h(String str) {
            this.f6982h = str;
        }

        @Override // h.b.a.d.y.a
        public void i(String str) {
            this.f6975a = str;
        }

        @Override // h.b.a.d.y.a
        public void a(String str) {
            this.j = str;
        }
    }

    /* compiled from: TipSession.java */
    /* loaded from: classes.dex */
    public class e implements BackendListeners.GetUserAccountListener {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ s f6985a;

        public e(i iVar, s sVar) {
            this.f6985a = sVar;
        }

        @Override // pt.card4b.backendbeacons.BackendListeners.BaseRequestListener
        public void onError(DataModels.Error error) {
            Log.d("TipSession.class", "TipSession: getUserAccount onError invoked with error " + error.getMessage());
            this.f6985a.onError(error);
        }

        @Override // pt.card4b.backendbeacons.BackendListeners.GetUserAccountListener
        public void onSuccess(DataModels.UserAccountInfo userAccountInfo) {
            Log.d("TipSession.class", "TipSession: getUserAccount onSuccess invoked");
            this.f6985a.onSuccess(userAccountInfo);
        }
    }

    /* compiled from: TipSession.java */
    /* loaded from: classes.dex */
    public class f implements y.b {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ DataModels.PaymentMethod f6986a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ boolean f6987b;

        public f(i iVar, DataModels.PaymentMethod paymentMethod, boolean z) {
            this.f6986a = paymentMethod;
            this.f6987b = z;
        }

        @Override // h.b.a.d.y.b
        public String a() {
            return this.f6986a.getName();
        }

        @Override // h.b.a.d.y.b
        public String b() {
            return this.f6986a.getThumbnailURL();
        }

        @Override // h.b.a.d.y.b
        public String c() {
            return this.f6986a.getCode();
        }

        @Override // h.b.a.d.y.b
        public String d() {
            if (!this.f6987b || g().equals(y.b.a.ACTIVE)) {
                return null;
            }
            Context W = h.b.a.c.W();
            return W.getString(2131755296) + "\n\n" + W.getString(2131755297) + "\n\n" + W.getString(2131755299) + "\n\n" + W.getString(2131755300) + "\n\n\n" + W.getString(2131755298);
        }

        @Override // h.b.a.d.y.b
        public y.b.EnumC0165b e() {
            if (this.f6987b) {
                return y.b.EnumC0165b.LOW_VALUE;
            }
            return y.b.EnumC0165b.CREDIT_CARD;
        }

        @Override // h.b.a.d.y.b
        public String f() {
            return this.f6986a.getInfoToCustomer();
        }

        public y.b.a g() {
            int i2 = g.f6988a[this.f6986a.getStatus().ordinal()];
            if (i2 != 1) {
                if (i2 != 2) {
                    if (i2 != 3) {
                        return y.b.a.UNKNOWN;
                    }
                    return y.b.a.CANCELLED;
                }
                return y.b.a.ACTIVATION_PENDING;
            }
            return y.b.a.ACTIVE;
        }
    }

    /* compiled from: TipSession.java */
    /* loaded from: classes.dex */
    public static /* synthetic */ class g {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f6988a = new int[DataModels.PaymentStatus.values().length];

        static {
            try {
                f6988a[DataModels.PaymentStatus.ACTIVE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f6988a[DataModels.PaymentStatus.ACTIVATION_PENDING.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f6988a[DataModels.PaymentStatus.CANCELLED.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    /* compiled from: TipSession.java */
    /* loaded from: classes.dex */
    public static class h extends b.AbstractC0157b<h.b.a.d.c> implements BackendListeners.TariffInfoRequestListener {

        /* renamed from: e  reason: collision with root package name */
        public h.b.a.d.c f6992e;

        /* renamed from: b  reason: collision with root package name */
        public final List<h.b.a.d.d> f6989b = new ArrayList();

        /* renamed from: c  reason: collision with root package name */
        public final List<h.b.a.d.i> f6990c = new ArrayList();

        /* renamed from: d  reason: collision with root package name */
        public final HashMap<String, List<w>> f6991d = new HashMap<>();

        /* renamed from: f  reason: collision with root package name */
        public boolean f6993f = false;

        /* renamed from: g  reason: collision with root package name */
        public f.a f6994g = null;

        /* compiled from: TipSession.java */
        /* loaded from: classes.dex */
        public class a implements h.b.a.d.d {

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ List f6995a;

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ DataModels.TariffInfo f6996b;

            public a(h hVar, List list, DataModels.TariffInfo tariffInfo) {
                this.f6995a = list;
                this.f6996b = tariffInfo;
            }

            @Override // h.b.a.d.d
            public String a() {
                return this.f6996b.getStageInfo().get(0).getTariffInfo();
            }

            @Override // h.b.a.d.d
            public double b() {
                return this.f6996b.getTotalDebt() / 100.0f;
            }

            @Override // h.b.a.d.d
            public List<w> c() {
                return this.f6995a;
            }
        }

        /* compiled from: TipSession.java */
        /* loaded from: classes.dex */
        public class b implements h.b.a.d.i {

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ DataModels.InvoiceInfo f6997a;

            public b(h hVar, DataModels.InvoiceInfo invoiceInfo) {
                this.f6997a = invoiceInfo;
            }

            @Override // h.b.a.d.i
            public Date a() {
                return this.f6997a.getIssueDate();
            }

            @Override // h.b.a.d.i
            public float b() {
                return this.f6997a.getTotal();
            }

            @Override // h.b.a.d.i
            public String c() {
                return this.f6997a.getDocumentLink();
            }

            @Override // h.b.a.d.i
            public String d() {
                return this.f6997a.getInvoiceId();
            }

            @Override // h.b.a.d.i
            public String e() {
                return this.f6997a.getDocumentNumber();
            }
        }

        /* compiled from: TipSession.java */
        /* loaded from: classes.dex */
        public class c implements h.b.a.d.c {
            public c() {
            }

            @Override // h.b.a.d.c
            public List<h.b.a.d.d> a() {
                return h.this.f6989b;
            }

            @Override // h.b.a.d.c
            public List<h.b.a.d.i> b() {
                return h.this.f6990c;
            }
        }

        public h(long j) {
            Calendar calendar = Calendar.getInstance();
            calendar.setTimeInMillis(j);
            calendar.set(5, 1);
            calendar.set(11, 0);
            calendar.set(12, 0);
            calendar.set(13, 0);
            calendar.set(14, 0);
            BackEnd.getTariffInfo(calendar.getTime(), this);
        }

        @Override // h.b.a.d.b.AbstractC0157b
        public f.a d() {
            return this.f6994g;
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
            this.f6994g = h.b.a.d.b0.b.a(error);
            this.f6993f = true;
            c();
        }

        @Override // pt.card4b.backendbeacons.BackendListeners.TariffInfoRequestListener
        public void onSuccess(List<DataModels.TariffInfo> list, List<DataModels.InvoiceInfo> list2) {
            for (DataModels.TariffInfo tariffInfo : list) {
                ArrayList arrayList = new ArrayList();
                for (DataModels.StageInfo stageInfo : tariffInfo.getStageInfo()) {
                    w a2 = h.b.a.d.b0.c.a(stageInfo);
                    arrayList.add(a2);
                    if (a2.g()) {
                        if (!this.f6991d.containsKey(a2.d())) {
                            this.f6991d.put(a2.d(), new ArrayList());
                        }
                        List<w> list3 = this.f6991d.get(a2.d());
                        list3.add(a2);
                        this.f6991d.put(a2.d(), list3);
                    }
                }
                this.f6989b.add(new a(this, arrayList, tariffInfo));
            }
            for (DataModels.InvoiceInfo invoiceInfo : list2) {
                this.f6990c.add(new b(this, invoiceInfo));
            }
            this.f6992e = new c();
            this.f6993f = true;
            c();
        }

        @Override // h.b.a.d.b
        public boolean b() {
            return this.f6993f;
        }

        @Override // h.b.a.d.b
        public h.b.a.d.c a() {
            return this.f6992e;
        }
    }

    /* compiled from: TipSession.java */
    /* renamed from: h.b.a.d.b0.i$i  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0163i extends h.b.a.d.b<y> {

        /* renamed from: b  reason: collision with root package name */
        public DataModels.UserAccountInfo f6999b;

        /* renamed from: c  reason: collision with root package name */
        public List<y.c> f7000c = new ArrayList();

        /* compiled from: TipSession.java */
        /* renamed from: h.b.a.d.b0.i$i$a */
        /* loaded from: classes.dex */
        public class a implements y.c {

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ DataModels.UserProfileInfo f7002a;

            public a(C0163i c0163i, i iVar, DataModels.UserProfileInfo userProfileInfo) {
                this.f7002a = userProfileInfo;
            }

            @Override // h.b.a.d.y.c
            public String a() {
                return this.f7002a.getProfileName();
            }

            @Override // h.b.a.d.y.c
            public Date b() {
                return this.f7002a.getEndDate();
            }

            @Override // h.b.a.d.y.c
            public Date c() {
                return this.f7002a.getStartDate();
            }
        }

        /* compiled from: TipSession.java */
        /* renamed from: h.b.a.d.b0.i$i$b */
        /* loaded from: classes.dex */
        public class b implements y {
            public b() {
            }

            @Override // h.b.a.d.y
            public String a() {
                return C0163i.this.f6999b.getName();
            }

            @Override // h.b.a.d.y
            public String b() {
                return C0163i.this.f6999b.getPhoto();
            }

            @Override // h.b.a.d.y
            public String c() {
                return C0163i.this.f6999b.getBillingInfo().getCity();
            }

            @Override // h.b.a.d.y
            public List<y.c> d() {
                return C0163i.this.f7000c;
            }

            @Override // h.b.a.d.y
            public String e() {
                return C0163i.this.f6999b.getBillingInfo().getFiscalNumber();
            }

            @Override // h.b.a.d.y
            public y.d edit() {
                C0163i c0163i = C0163i.this;
                return new m(i.this, c0163i.f6999b, null);
            }

            @Override // h.b.a.d.y
            public String f() {
                return C0163i.this.f6999b.getPhonenumber();
            }

            @Override // h.b.a.d.y
            public String g() {
                return C0163i.this.f6999b.getBillingInfo().getPostalCode();
            }

            @Override // h.b.a.d.y
            public String h() {
                return C0163i.this.f6999b.getEmail();
            }

            @Override // h.b.a.d.y
            public String i() {
                return C0163i.this.f6999b.getBillingInfo().getName();
            }

            @Override // h.b.a.d.y
            public y.b j() {
                return i.this.a(C0163i.this.f6999b.getPaymentMethod());
            }

            @Override // h.b.a.d.y
            public String k() {
                return C0163i.this.f6999b.getBillingInfo().getAddress();
            }

            @Override // h.b.a.d.y
            public String l() {
                return C0163i.this.f6999b.getBillingInfo().getCountry().getCode();
            }

            @Override // h.b.a.d.y
            public String m() {
                return C0163i.this.f6999b.getBillingInfo().getNotifyEmail();
            }
        }

        public C0163i(DataModels.UserAccountInfo userAccountInfo) {
            this.f6999b = userAccountInfo;
            List<DataModels.UserProfileInfo> profileInfo = userAccountInfo.getProfileInfo();
            if (profileInfo != null) {
                for (DataModels.UserProfileInfo userProfileInfo : profileInfo) {
                    this.f7000c.add(new a(this, i.this, userProfileInfo));
                }
                Collections.sort(this.f7000c, h.b.a.d.b0.a.f6903a);
            }
        }

        @Override // h.b.a.d.b
        public boolean b() {
            return this.f6999b != null;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // h.b.a.d.b
        public y a() {
            return new b();
        }
    }

    /* compiled from: TipSession.java */
    /* loaded from: classes.dex */
    public class j extends h.b.a.d.b<u.a> {

        /* renamed from: b  reason: collision with root package name */
        public final String f7004b;

        /* renamed from: c  reason: collision with root package name */
        public byte f7005c;

        /* renamed from: d  reason: collision with root package name */
        public DataModels.Error f7006d;

        public /* synthetic */ j(i iVar, String str, String str2, a aVar) {
            this(str, str2);
        }

        @Override // h.b.a.d.b
        public boolean b() {
            return this.f7005c != 0;
        }

        public j(String str, String str2) {
            this.f7005c = (byte) 0;
            this.f7004b = str;
        }

        public void a(DataModels.User user) {
            i.this.f6966e = user;
            i.this.f6965d = true;
            PreferenceManager.getDefaultSharedPreferences(i.this.f6963b).edit().putBoolean("session", true).apply();
            this.f7005c = (byte) 1;
            c();
        }

        public void a(DataModels.Error error) {
            this.f7006d = error;
            i.this.f();
            this.f7005c = (byte) -1;
            c();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // h.b.a.d.b
        public u.a a() {
            byte b2 = this.f7005c;
            if (b2 == 0) {
                return null;
            }
            boolean z = b2 == 1;
            String str = this.f7004b;
            DataModels.Error error = this.f7006d;
            return new u.a(z, str, error != null ? error.getMessageToUser() : null);
        }
    }

    /* compiled from: TipSession.java */
    /* loaded from: classes.dex */
    public class k extends h.b.a.d.b<x.a> {

        /* renamed from: b  reason: collision with root package name */
        public byte f7008b;

        public k() {
            this.f7008b = (byte) 0;
        }

        @Override // h.b.a.d.b
        public boolean b() {
            return this.f7008b != 0;
        }

        public void d() {
            this.f7008b = (byte) -1;
            c();
        }

        public void e() {
            i.this.f();
            this.f7008b = (byte) 1;
            c();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // h.b.a.d.b
        public x.a a() {
            byte b2 = this.f7008b;
            if (b2 == 0) {
                return null;
            }
            return new x.a(b2 == 1);
        }

        public /* synthetic */ k(i iVar, a aVar) {
            this();
        }
    }

    /* compiled from: TipSession.java */
    /* loaded from: classes.dex */
    public class m implements y.d {

        /* renamed from: a  reason: collision with root package name */
        public final DataModels.UserAccountInfo f7013a;

        /* compiled from: TipSession.java */
        /* loaded from: classes.dex */
        public class a implements BackendListeners.UpdateUserRequestListener {

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ c f7015a;

            public a(c cVar) {
                this.f7015a = cVar;
            }

            @Override // pt.card4b.backendbeacons.BackendListeners.BaseRequestListener
            public void onError(DataModels.Error error) {
                this.f7015a.a(error);
            }

            @Override // pt.card4b.backendbeacons.BackendListeners.UpdateUserRequestListener
            public void onSuccess(boolean z) {
                m mVar = m.this;
                i.this.f6966e = new DataModels.User(mVar.f7013a.getId(), m.this.f7013a.getName(), m.this.f7013a.getEmail(), m.this.f7013a.getPhonenumber(), m.this.f7013a.getPhoto(), Boolean.valueOf(m.this.f7013a.getPaymentMethod() != null));
                this.f7015a.d();
                if (z) {
                    i.this.b().a();
                }
            }
        }

        /* compiled from: TipSession.java */
        /* loaded from: classes.dex */
        public class b implements BackendListeners.DefaultRequestListener {

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ c f7017a;

            public b(c cVar) {
                this.f7017a = cVar;
            }

            @Override // pt.card4b.backendbeacons.BackendListeners.DefaultRequestListener
            public void onError(DataModels.Error error) {
                this.f7017a.a(error);
            }

            @Override // pt.card4b.backendbeacons.BackendListeners.DefaultRequestListener
            public void onSuccess() {
                m mVar = m.this;
                i.this.f6966e = new DataModels.User(mVar.f7013a.getId(), m.this.f7013a.getName(), m.this.f7013a.getEmail(), m.this.f7013a.getPhonenumber(), m.this.f7013a.getPhoto(), Boolean.valueOf(m.this.f7013a.getPaymentMethod() != null));
                this.f7017a.d();
            }
        }

        public /* synthetic */ m(i iVar, DataModels.UserAccountInfo userAccountInfo, a aVar) {
            this(userAccountInfo);
        }

        @Override // h.b.a.d.y.a
        public void b(String str) {
            this.f7013a.setName(str);
        }

        @Override // h.b.a.d.y.a
        public void c(String str) {
            this.f7013a.setEmail(str);
        }

        @Override // h.b.a.d.y.a
        public void d(String str) {
            this.f7013a.getBillingInfo().setAddress(str);
        }

        @Override // h.b.a.d.y.a
        public void e(String str) {
            this.f7013a.setPhonenumber(str);
        }

        @Override // h.b.a.d.y
        public y.d edit() {
            return this;
        }

        @Override // h.b.a.d.y
        public String f() {
            return this.f7013a.getPhonenumber();
        }

        @Override // h.b.a.d.y
        public String g() {
            return this.f7013a.getBillingInfo().getPostalCode();
        }

        @Override // h.b.a.d.y
        public String h() {
            return this.f7013a.getEmail();
        }

        @Override // h.b.a.d.y
        public String i() {
            return this.f7013a.getBillingInfo().getName();
        }

        @Override // h.b.a.d.y.a
        public void j(String str) {
            this.f7013a.getBillingInfo().setFiscalNumber(str);
        }

        @Override // h.b.a.d.y
        public String k() {
            return this.f7013a.getBillingInfo().getAddress();
        }

        @Override // h.b.a.d.y
        public String l() {
            return this.f7013a.getBillingInfo().getCountry().getCode();
        }

        @Override // h.b.a.d.y
        public String m() {
            return this.f7013a.getBillingInfo().getNotifyEmail();
        }

        @Override // h.b.a.d.y.d
        public h.b.a.d.b<u.d> o() {
            c cVar = new c(this, null);
            BackEnd.updateUserData(this.f7013a, new a(cVar));
            return cVar;
        }

        /* compiled from: TipSession.java */
        /* loaded from: classes.dex */
        public class c extends h.b.a.d.b<u.d> {

            /* renamed from: b  reason: collision with root package name */
            public byte f7019b;

            /* renamed from: c  reason: collision with root package name */
            public DataModels.Error f7020c;

            /* compiled from: TipSession.java */
            /* loaded from: classes.dex */
            public class a extends u.d {
                public a(boolean z) {
                    super(z);
                }

                @Override // h.b.a.d.u.d
                public String b() {
                    if (c.this.f7020c == null) {
                        return null;
                    }
                    return c.this.f7020c.getMessageToUser();
                }
            }

            public c(m mVar) {
                this.f7019b = (byte) 0;
            }

            @Override // h.b.a.d.b
            public boolean b() {
                return this.f7019b != 0;
            }

            public void d() {
                this.f7019b = (byte) 1;
                c();
            }

            public /* synthetic */ c(m mVar, a aVar) {
                this(mVar);
            }

            public void a(DataModels.Error error) {
                this.f7019b = (byte) -1;
                this.f7020c = error;
                c();
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // h.b.a.d.b
            public u.d a() {
                return new a(this.f7019b == 1);
            }
        }

        public m(DataModels.UserAccountInfo userAccountInfo) {
            this.f7013a = new DataModels.UserAccountInfo(userAccountInfo.getId(), userAccountInfo.getName(), userAccountInfo.getEmail(), userAccountInfo.getAddress(), userAccountInfo.getPhonenumber(), userAccountInfo.getPostalcode(), userAccountInfo.getFiscalnumber(), userAccountInfo.getIdnumber(), userAccountInfo.getTipCode(), userAccountInfo.getPhoto(), userAccountInfo.getBillingInfo(), userAccountInfo.getProfileInfo(), userAccountInfo.getPaymentMethod());
        }

        @Override // h.b.a.d.y
        public String a() {
            return this.f7013a.getName();
        }

        @Override // h.b.a.d.y
        public String b() {
            return this.f7013a.getPhoto();
        }

        @Override // h.b.a.d.y
        public String c() {
            return this.f7013a.getBillingInfo().getCity();
        }

        @Override // h.b.a.d.y
        public List<y.c> d() {
            return new ArrayList();
        }

        @Override // h.b.a.d.y
        public String e() {
            return this.f7013a.getBillingInfo().getFiscalNumber();
        }

        @Override // h.b.a.d.y.a
        public void f(String str) {
            this.f7013a.getBillingInfo().setPostalCode(str);
        }

        @Override // h.b.a.d.y.a
        public void g(String str) {
            this.f7013a.getBillingInfo().setName(str);
        }

        @Override // h.b.a.d.y.a
        public void h(String str) {
            this.f7013a.getBillingInfo().setCity(str);
        }

        @Override // h.b.a.d.y
        public y.b j() {
            return i.this.a(this.f7013a.getPaymentMethod());
        }

        @Override // h.b.a.d.y.a
        public void a(DataModels.Country country) {
            this.f7013a.getBillingInfo().setCountry(country);
        }

        @Override // h.b.a.d.y.a
        public void a(String str) {
            this.f7013a.getBillingInfo().setNotifyEmail(str);
        }

        @Override // h.b.a.d.y.d
        public h.b.a.d.b<u.d> a(String str, String str2, String str3) {
            c cVar = new c(this, null);
            BackEnd.changeUserPwd(str, str2, str3, new b(cVar));
            return cVar;
        }
    }

    /* compiled from: TipSession.java */
    /* loaded from: classes.dex */
    public class n extends h.b.a.d.b<y> {

        /* compiled from: TipSession.java */
        /* loaded from: classes.dex */
        public class a implements y {
            public a() {
            }

            @Override // h.b.a.d.y
            public String a() {
                return i.this.f6966e.getName();
            }

            @Override // h.b.a.d.y
            public String b() {
                return i.this.f6966e.getPhoto();
            }

            @Override // h.b.a.d.y
            public String c() {
                return "";
            }

            @Override // h.b.a.d.y
            public List<y.c> d() {
                return new ArrayList();
            }

            @Override // h.b.a.d.y
            public String e() {
                return "";
            }

            @Override // h.b.a.d.y
            public y.d edit() {
                return null;
            }

            @Override // h.b.a.d.y
            public String f() {
                return i.this.f6966e.getPhonenumber();
            }

            @Override // h.b.a.d.y
            public String g() {
                return "";
            }

            @Override // h.b.a.d.y
            public String h() {
                return i.this.f6966e.getEmail();
            }

            @Override // h.b.a.d.y
            public String i() {
                return "";
            }

            @Override // h.b.a.d.y
            public y.b j() {
                return null;
            }

            @Override // h.b.a.d.y
            public String k() {
                return "";
            }

            @Override // h.b.a.d.y
            public String l() {
                return "";
            }

            @Override // h.b.a.d.y
            public String m() {
                return "";
            }
        }

        public n() {
        }

        @Override // h.b.a.d.b
        public boolean b() {
            return i.this.f6966e != null;
        }

        public /* synthetic */ n(i iVar, a aVar) {
            this();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // h.b.a.d.b
        public y a() {
            return new a();
        }
    }

    public i(h.b.a.c cVar, Context context) {
        this.f6962a = cVar;
        this.f6963b = context;
        if (PreferenceManager.getDefaultSharedPreferences(context).getBoolean("session", false)) {
            this.f6965d = true;
        }
    }

    @Override // h.b.a.d.s
    public void onError(DataModels.Error error) {
    }

    @Override // h.b.a.d.s
    public void onSuccess(DataModels.UserAccountInfo userAccountInfo) {
    }

    /* compiled from: TipSession.java */
    /* loaded from: classes.dex */
    public class a implements x {

        /* compiled from: TipSession.java */
        /* renamed from: h.b.a.d.b0.i$a$a  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        public class C0162a implements BackendListeners.LogoutRequestListener {

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ k f6969a;

            public C0162a(k kVar) {
                this.f6969a = kVar;
            }

            @Override // pt.card4b.backendbeacons.BackendListeners.BaseRequestListener
            public void onError(DataModels.Error error) {
                this.f6969a.d();
            }

            @Override // pt.card4b.backendbeacons.BackendListeners.LogoutRequestListener
            public void onSuccess() {
                this.f6969a.e();
                i.this.f6962a.e();
                for (u.e eVar : i.this.f6964c) {
                    eVar.a(i.this.f6967f);
                }
            }
        }

        public a() {
        }

        @Override // h.b.a.d.x
        public h.b.a.d.b<y> a(DataModels.UserAccountInfo userAccountInfo) {
            if (userAccountInfo != null) {
                return new C0163i(userAccountInfo);
            }
            if (i.this.f6966e == null) {
                return null;
            }
            return new n(i.this, null);
        }

        @Override // h.b.a.d.x
        public String b() {
            if (i.this.f6966e == null) {
                return null;
            }
            return i.this.f6966e.getName();
        }

        @Override // h.b.a.d.x
        public h.b.a.d.b<x.a> a() {
            k kVar = new k(i.this, null);
            BackEnd.logout(new C0162a(kVar));
            return kVar;
        }
    }

    /* compiled from: TipSession.java */
    /* loaded from: classes.dex */
    public class l extends h.b.a.d.b<u.c> {

        /* renamed from: b  reason: collision with root package name */
        public byte f7010b;

        /* renamed from: c  reason: collision with root package name */
        public DataModels.Error f7011c;

        /* compiled from: TipSession.java */
        /* loaded from: classes.dex */
        public class a extends u.c {
            public a(boolean z) {
                super(z);
            }

            @Override // h.b.a.d.u.d
            public String a() {
                if (l.this.f7011c == null) {
                    return null;
                }
                return l.this.f7011c.getMessage();
            }

            @Override // h.b.a.d.u.d
            public String b() {
                if (l.this.f7011c == null) {
                    return null;
                }
                return l.this.f7011c.getMessageToUser();
            }
        }

        public l(i iVar) {
            this.f7010b = (byte) 0;
        }

        @Override // h.b.a.d.b
        public boolean b() {
            return this.f7010b != 0;
        }

        public void d() {
            this.f7010b = (byte) 1;
            h.b.a.c.X().a(true);
            c();
        }

        public /* synthetic */ l(i iVar, a aVar) {
            this(iVar);
        }

        public void a(DataModels.Error error) {
            this.f7010b = (byte) -1;
            this.f7011c = error;
            c();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // h.b.a.d.b
        public u.c a() {
            byte b2 = this.f7010b;
            if (b2 == 0) {
                return null;
            }
            return new a(b2 == 1);
        }
    }

    @Override // h.b.a.d.u
    public x b() {
        if (this.f6965d) {
            return this.f6967f;
        }
        return null;
    }

    @Override // h.b.a.d.u
    public void c() {
        x xVar = this.f6967f;
        f();
        for (u.e eVar : this.f6964c) {
            eVar.a(xVar);
        }
    }

    @Override // h.b.a.d.u
    public h.b.a.d.h d() {
        return new h.b.a.d.b0.c();
    }

    @Override // h.b.a.d.u
    public u.b e() {
        return new d();
    }

    public final void f() {
        try {
            c.b.a.a.a((String) null);
        } catch (Exception unused) {
        }
        this.f6966e = null;
        this.f6965d = false;
        PreferenceManager.getDefaultSharedPreferences(this.f6963b).edit().remove("session").apply();
    }

    @Override // h.b.a.d.u
    public void b(u.e eVar) {
        this.f6964c.remove(eVar);
    }

    @Override // h.b.a.d.u
    public void a(Runnable runnable) {
        BackEnd.getSavedUser(new b(runnable));
    }

    @Override // h.b.a.d.u
    public boolean a() {
        return this.f6965d;
    }

    @Override // h.b.a.d.u
    public h.b.a.d.b<u.a> a(String str, String str2) {
        j jVar = new j(this, str, str2, null);
        BackEnd.login(str, str2, new c(jVar));
        return jVar;
    }

    @Override // h.b.a.d.u
    public void a(s sVar) {
        BackEnd.getUserAccount(new e(this, sVar));
    }

    @Override // h.b.a.d.u
    public b.AbstractC0157b<h.b.a.d.c> a(long j2, long j3) {
        return new h(j2);
    }

    @Override // h.b.a.d.u
    public void a(u.e eVar) {
        if (this.f6964c.contains(eVar)) {
            return;
        }
        this.f6964c.add(eVar);
    }

    public final y.b a(DataModels.PaymentMethod paymentMethod) {
        if (paymentMethod != null) {
            return new f(this, paymentMethod, paymentMethod.getCode().equals("PBV"));
        }
        return null;
    }
}
