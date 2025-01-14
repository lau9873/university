package p205h.p206a.p207a;

import android.os.SystemClock;
import android.util.Log;
import com.j256.ormlite.android.apptools.OrmLiteConfigUtil;
import java.math.BigInteger;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.TimeZone;
import org.json.JSONArray;
import org.json.JSONObject;
import p070c.p115g.p125b.p126a.C1417b;
import p070c.p115g.p125b.p126a.InterfaceC1416a;
import pt.card4b.backendbeacons.App;
import pt.card4b.backendbeacons.DataModels;

/* renamed from: h.a.a.b */
/* loaded from: classes.dex */
public class AndaHCEManager {

    /* renamed from: d */
    public static volatile AndaHCEManager f8747d;

    /* renamed from: a */
    public InterfaceC1416a f8748a = new C1864a();

    /* renamed from: b */
    public InterfaceC1876m f8749b;

    /* renamed from: c */
    public boolean f8750c;

    /* compiled from: AndaHCEManager.java */
    /* renamed from: h.a.a.b$a */
    /* loaded from: classes.dex */
    public class C1864a implements InterfaceC1416a {
        public C1864a() {
        }

        @Override // p070c.p115g.p125b.p126a.InterfaceC1416a
        public void notifyAnswer(int i, int i2, JSONObject jSONObject) {
            String str;
            String str2;
            long parseLong;
            long parseLong2;
            long parseLong3;
            long j;
            long j2;
            Calendar calendar;
            long timeInMillis;
            long m1494g;
            long elapsedRealtime;
            StringBuilder sb;
            String str3 = OrmLiteConfigUtil.RAW_DIR_NAME;
            try {
                if (i2 != 326) {
                    if (i2 == 325) {
                        if (i == 0) {
                            AppLog.m2158a("LOGIC_HCE", "AndaHCEManager", "HCEManager.apiListener", "Card content updated");
                            return;
                        }
                        AppLog.m2158a("LOGIC_HCE", "AndaHCEManager", "HCEManager.apiListener", "Card content update failed with error " + i);
                    }
                } else if (i == 0) {
                    try {
                        AppLog.m2158a("LOGIC_HCE", "AndaHCEManager", "HCEManager.HceListener", "Card validated");
                        if (jSONObject.has("records")) {
                            JSONArray jSONArray = (JSONArray) jSONObject.get("records");
                            for (int i3 = 0; i3 < jSONArray.length(); i3++) {
                                JSONObject jSONObject2 = (JSONObject) jSONArray.get(i3);
                                if (jSONObject2.has("sfi") && jSONObject2.getInt("sfi") == 8 && jSONObject2.has("recnum") && jSONObject2.getInt("recnum") == 1 && jSONObject2.has(OrmLiteConfigUtil.RAW_DIR_NAME)) {
                                    str2 = jSONObject2.getString(OrmLiteConfigUtil.RAW_DIR_NAME);
                                    break;
                                }
                            }
                        }
                        str2 = null;
                        DataModels.C2700i m2172a = jSONObject.has("serialNumber") ? AndaHCEManager.this.m2172a((String) jSONObject.get("serialNumber")) : null;
                        if (str2 != null && str2.length() > 0) {
                            String m2171a = AndaHCEManager.this.m2171a(new BigInteger(str2, 16).toString(2), str2.length() * 4);
                            long parseLong4 = Long.parseLong(m2171a.substring(3, 33), 2);
                            long parseLong5 = Long.parseLong(m2171a.substring(33, 40), 2);
                            try {
                                parseLong = Long.parseLong(m2171a.substring(133, 141), 2);
                                parseLong2 = Long.parseLong(m2171a.substring(141, 157), 2);
                                parseLong3 = Long.parseLong(m2171a.substring(157, 173), 2);
                                j = parseLong2 & 7;
                                j2 = (parseLong2 >> 3) & 7;
                                calendar = Calendar.getInstance(TimeZone.getTimeZone("UTC"));
                            } catch (Throwable th) {
                                th = th;
                            }
                            try {
                                calendar.setTimeInMillis(AndaHCEManager.this.m2183a(parseLong4) * 1000);
                                Calendar calendar2 = Calendar.getInstance(TimeZone.getTimeZone("Europe/Lisbon"));
                                calendar2.set(calendar.get(1), calendar.get(2), calendar.get(5), calendar.get(11), calendar.get(12), calendar.get(13));
                                timeInMillis = calendar2.getTimeInMillis();
                                m1494g = SysDateManager.m1497d().m1494g();
                                elapsedRealtime = SystemClock.elapsedRealtime();
                                sb = new StringBuilder();
                                str = "HCEManager.HceListener";
                            } catch (Throwable th2) {
                                th = th2;
                                str = "HCEManager.HceListener";
                                str3 = "AndaHCEManager";
                                AppLog.m2158a("LOGIC_HCE", str3, str, "Exception processing answer" + Log.getStackTraceString(th));
                                return;
                            }
                            try {
                                sb.append("System date: ");
                                sb.append(GeneralUtils.m1593b(SysDateManager.m1497d().m1495f()));
                                sb.append(" Event data - timestamp:");
                                sb.append(GeneralUtils.m1593b(GeneralUtils.m1602a(timeInMillis)));
                                sb.append(" provider:");
                                sb.append(parseLong);
                                sb.append(" line:");
                                sb.append(parseLong3);
                                sb.append(" zone:");
                                sb.append(parseLong5);
                                sb.append(" location:");
                                sb.append(parseLong2);
                                sb.append(" direction: ");
                                sb.append(j);
                                sb.append(" variant:");
                                sb.append(j2);
                                try {
                                    AppLog.m2158a("LOGIC_HCE", "AndaHCEManager", "Validation notify", sb.toString());
                                } catch (Throwable th3) {
                                    th = th3;
                                }
                                try {
                                    if (AndaHCEManager.this.f8749b != null) {
                                        AndaHCEManager.this.f8749b.mo1715a(m2172a, timeInMillis, m1494g, elapsedRealtime, (int) parseLong, (int) parseLong3, (int) parseLong5, (int) parseLong2, (int) j, (int) j2);
                                        return;
                                    }
                                    return;
                                } catch (Throwable th4) {
                                    th = th4;
                                    str3 = "AndaHCEManager";
                                    AppLog.m2158a("LOGIC_HCE", str3, str, "Exception processing answer" + Log.getStackTraceString(th));
                                    return;
                                }
                            } catch (Throwable th5) {
                                th = th5;
                                str3 = "AndaHCEManager";
                                AppLog.m2158a("LOGIC_HCE", str3, str, "Exception processing answer" + Log.getStackTraceString(th));
                                return;
                            }
                        }
                        throw new Exception("HCEManager.HceListener: Validation event not found or empty");
                    } catch (Throwable th6) {
                        th = th6;
                        str = "HCEManager.HceListener";
                        str3 = "AndaHCEManager";
                    }
                } else {
                    AppLog.m2158a("LOGIC_HCE", "AndaHCEManager", "HCEManager.apiListener", "Card validation failed with error " + i);
                }
            } catch (Throwable th7) {
                th = th7;
            }
        }
    }

    /* compiled from: AndaHCEManager.java */
    /* renamed from: h.a.a.b$b */
    /* loaded from: classes.dex */
    public class C1865b implements InterfaceC1416a {
        public C1865b(AndaHCEManager andaHCEManager) {
        }

        @Override // p070c.p115g.p125b.p126a.InterfaceC1416a
        public void notifyAnswer(int i, int i2, JSONObject jSONObject) {
            if (i == 0) {
                AppLog.m2158a("LOGIC_HCE", "AndaHCEManager", "HCEManager.getInformation", " ManagerVersion " + jSONObject.optString("ManagerVersion") + " \n ManagerDate " + jSONObject.optString("ManagerDate") + " \n autoupdatesEnabled " + jSONObject.optString("autoupdatesEnabled") + " \n validationsEnabled " + jSONObject.optString("validationsEnabled") + " ");
                return;
            }
            AppLog.m2158a("LOGIC_HCE", "AndaHCEManager", "HCEManager.getInformation", "Error: " + i);
        }
    }

    /* compiled from: AndaHCEManager.java */
    /* renamed from: h.a.a.b$c */
    /* loaded from: classes.dex */
    public class C1866c implements InterfaceC1416a {

        /* renamed from: a */
        public final /* synthetic */ InterfaceC1873j f8752a;

        public C1866c(AndaHCEManager andaHCEManager, InterfaceC1873j interfaceC1873j) {
            this.f8752a = interfaceC1873j;
        }

        @Override // p070c.p115g.p125b.p126a.InterfaceC1416a
        public void notifyAnswer(int i, int i2, JSONObject jSONObject) {
            if (i == 0) {
                AppLog.m2158a("LOGIC_HCE", "AndaHCEManager", "HCEManager.enroll", "Enroll succeeded");
                InterfaceC1873j interfaceC1873j = this.f8752a;
                if (interfaceC1873j != null) {
                    interfaceC1873j.onSuccess();
                    return;
                }
                return;
            }
            AppLog.m2158a("LOGIC_HCE", "AndaHCEManager", "HCEManager.enroll", "Enrolment failed with error " + i);
            InterfaceC1873j interfaceC1873j2 = this.f8752a;
            if (interfaceC1873j2 != null) {
                interfaceC1873j2.mo1764a(i, "Enrolment failed with error " + i);
            }
        }
    }

    /* compiled from: AndaHCEManager.java */
    /* renamed from: h.a.a.b$d */
    /* loaded from: classes.dex */
    public class C1867d implements InterfaceC1416a {

        /* renamed from: a */
        public final /* synthetic */ InterfaceC1872i f8753a;

        public C1867d(InterfaceC1872i interfaceC1872i) {
            this.f8753a = interfaceC1872i;
        }

        @Override // p070c.p115g.p125b.p126a.InterfaceC1416a
        public void notifyAnswer(int i, int i2, JSONObject jSONObject) {
            if (i == 0) {
                AndaHCEManager.this.f8750c = true;
                AppLog.m2158a("LOGIC_HCE", "AndaHCEManager", "HCEManager.enableValidations", "Enabling validations succeeded");
                InterfaceC1872i interfaceC1872i = this.f8753a;
                if (interfaceC1872i != null) {
                    interfaceC1872i.onSuccess();
                    return;
                }
                return;
            }
            AppLog.m2158a("LOGIC_HCE", "AndaHCEManager", "HCEManager.enableValidations", "Enabling validations failed with error " + i);
            InterfaceC1872i interfaceC1872i2 = this.f8753a;
            if (interfaceC1872i2 != null) {
                interfaceC1872i2.mo1747a(i, "Enabling validations failed with error " + i);
            }
        }
    }

    /* compiled from: AndaHCEManager.java */
    /* renamed from: h.a.a.b$e */
    /* loaded from: classes.dex */
    public class C1868e implements InterfaceC1416a {

        /* renamed from: a */
        public final /* synthetic */ InterfaceC1871h f8755a;

        public C1868e(InterfaceC1871h interfaceC1871h) {
            this.f8755a = interfaceC1871h;
        }

        @Override // p070c.p115g.p125b.p126a.InterfaceC1416a
        public void notifyAnswer(int i, int i2, JSONObject jSONObject) {
            if (i == 0) {
                AndaHCEManager.this.f8750c = false;
                AppLog.m2158a("LOGIC_HCE", "AndaHCEManager", "HCEManager.disableValidations", "Disabling validations succeeded");
                InterfaceC1871h interfaceC1871h = this.f8755a;
                if (interfaceC1871h != null) {
                    interfaceC1871h.onSuccess();
                    return;
                }
                return;
            }
            AppLog.m2158a("LOGIC_HCE", "AndaHCEManager", "HCEManager.disableValidations", "Disabling validations failed with error " + i);
            InterfaceC1871h interfaceC1871h2 = this.f8755a;
            if (interfaceC1871h2 != null) {
                interfaceC1871h2.mo1745a(i, "Disabling validations failed with error " + i);
            }
        }
    }

    /* compiled from: AndaHCEManager.java */
    /* renamed from: h.a.a.b$f */
    /* loaded from: classes.dex */
    public class C1869f implements InterfaceC1416a {

        /* renamed from: a */
        public final /* synthetic */ InterfaceC1874k f8757a;

        public C1869f(InterfaceC1874k interfaceC1874k) {
            this.f8757a = interfaceC1874k;
        }

        @Override // p070c.p115g.p125b.p126a.InterfaceC1416a
        public void notifyAnswer(int i, int i2, JSONObject jSONObject) {
            try {
                if (i == 0) {
                    DataModels.C2700i m2172a = jSONObject.has("serialNumber") ? AndaHCEManager.this.m2172a((String) jSONObject.get("serialNumber")) : null;
                    if (m2172a != null) {
                        InterfaceC1874k interfaceC1874k = this.f8757a;
                        if (interfaceC1874k != null) {
                            interfaceC1874k.mo1724a(m2172a);
                            return;
                        }
                        return;
                    }
                    InterfaceC1874k interfaceC1874k2 = this.f8757a;
                    if (interfaceC1874k2 != null) {
                        interfaceC1874k2.mo1725a(0, "Get card info failed");
                        return;
                    }
                    return;
                }
                AppLog.m2158a("LOGIC_HCE", "AndaHCEManager", "HCEManager.getCardInfo", "Get card contents failed with error: " + i);
                InterfaceC1874k interfaceC1874k3 = this.f8757a;
                if (interfaceC1874k3 != null) {
                    interfaceC1874k3.mo1725a(i, "Error getting card info: " + i);
                }
            } catch (Throwable th) {
                AppLog.m2158a("LOGIC_HCE", "AndaHCEManager", "HCEManager.getCardInfo", "Exception: " + Log.getStackTraceString(th));
                InterfaceC1874k interfaceC1874k4 = this.f8757a;
                if (interfaceC1874k4 != null) {
                    interfaceC1874k4.mo1725a(0, "Get card info failed");
                }
            }
        }
    }

    /* compiled from: AndaHCEManager.java */
    /* renamed from: h.a.a.b$g */
    /* loaded from: classes.dex */
    public class C1870g implements InterfaceC1416a {

        /* renamed from: a */
        public final /* synthetic */ InterfaceC1875l f8759a;

        public C1870g(AndaHCEManager andaHCEManager, InterfaceC1875l interfaceC1875l) {
            this.f8759a = interfaceC1875l;
        }

        @Override // p070c.p115g.p125b.p126a.InterfaceC1416a
        public void notifyAnswer(int i, int i2, JSONObject jSONObject) {
            if (i == 0) {
                InterfaceC1875l interfaceC1875l = this.f8759a;
                if (interfaceC1875l != null) {
                    interfaceC1875l.mo1740a();
                    return;
                }
                return;
            }
            InterfaceC1875l interfaceC1875l2 = this.f8759a;
            if (interfaceC1875l2 != null) {
                interfaceC1875l2.mo1739a(i, "Synchronize failed");
            }
        }
    }

    /* compiled from: AndaHCEManager.java */
    /* renamed from: h.a.a.b$h */
    /* loaded from: classes.dex */
    public interface InterfaceC1871h {
        /* renamed from: a */
        void mo1745a(int i, String str);

        void onSuccess();
    }

    /* compiled from: AndaHCEManager.java */
    /* renamed from: h.a.a.b$i */
    /* loaded from: classes.dex */
    public interface InterfaceC1872i {
        /* renamed from: a */
        void mo1747a(int i, String str);

        void onSuccess();
    }

    /* compiled from: AndaHCEManager.java */
    /* renamed from: h.a.a.b$j */
    /* loaded from: classes.dex */
    public interface InterfaceC1873j {
        /* renamed from: a */
        void mo1764a(int i, String str);

        void onSuccess();
    }

    /* compiled from: AndaHCEManager.java */
    /* renamed from: h.a.a.b$k */
    /* loaded from: classes.dex */
    public interface InterfaceC1874k {
        /* renamed from: a */
        void mo1725a(int i, String str);

        /* renamed from: a */
        void mo1724a(DataModels.C2700i c2700i);
    }

    /* compiled from: AndaHCEManager.java */
    /* renamed from: h.a.a.b$l */
    /* loaded from: classes.dex */
    public interface InterfaceC1875l {
        /* renamed from: a */
        void mo1740a();

        /* renamed from: a */
        void mo1739a(int i, String str);
    }

    /* compiled from: AndaHCEManager.java */
    /* renamed from: h.a.a.b$m */
    /* loaded from: classes.dex */
    public interface InterfaceC1876m {
        /* renamed from: a */
        void mo1715a(DataModels.C2700i c2700i, long j, long j2, long j3, int i, int i2, int i3, int i4, int i5, int i6);
    }

    public AndaHCEManager() {
        new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        this.f8750c = false;
        if (f8747d == null) {
            AppLog.m2158a("LOGIC_HCE", "AndaHCEManager", "HCEManager.init", "Initializing HCE Manager");
            C1417b.m4518a().m4510a(App.getContext(), App.getPackName());
            C1417b.m4518a().m4511a(App.getContext(), new C1865b(this));
            C1417b.m4518a().m4505a(this.f8748a);
            return;
        }
        throw new RuntimeException("AndaHCEManager: Use getInstance() method to get the single instance of this class.");
    }

    /* renamed from: b */
    private long m2168b(long j) {
        if (j <= 2147483647L) {
            return j;
        }
        return 2147483647L;
    }

    /* renamed from: d */
    private JSONObject m2166d() {
        try {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("AID", "A0000004040125");
                return jSONObject;
            } catch (Exception unused) {
                return jSONObject;
            }
        } catch (Exception unused2) {
            return null;
        }
    }

    /* renamed from: b */
    public boolean m2169b() {
        try {
            return C1417b.m4518a().m4515a(App.getContext());
        } catch (Throwable th) {
            AppLog.m2158a("LOGIC_HCE", "AndaHCEManager", "HCEManager.isEnrolled", "Exception: " + Log.getStackTraceString(th));
            return false;
        }
    }

    /* renamed from: c */
    public boolean m2167c() {
        return this.f8750c;
    }

    /* renamed from: a */
    public static AndaHCEManager m2184a() {
        if (f8747d == null) {
            synchronized (AndaHCEManager.class) {
                if (f8747d == null) {
                    f8747d = new AndaHCEManager();
                }
            }
        }
        return f8747d;
    }

    /* renamed from: a */
    public void m2178a(InterfaceC1876m interfaceC1876m) {
        this.f8749b = interfaceC1876m;
    }

    /* renamed from: a */
    public void m2170a(String str, InterfaceC1873j interfaceC1873j) {
        try {
            AppLog.m2158a("LOGIC_HCE", "AndaHCEManager", "HCEManager.Enroll", "Enrolling new card for phone nr " + str);
            C1417b.m4518a().m4512a(App.getContext(), 1, str, new C1866c(this, interfaceC1873j));
        } catch (Throwable th) {
            AppLog.m2158a("LOGIC_HCE", "AndaHCEManager", "HCEManager.enroll", "Exception: " + Log.getStackTraceString(th));
            if (interfaceC1873j != null) {
                interfaceC1873j.mo1764a(0, "Enrolment failed");
            }
        }
    }

    /* renamed from: a */
    public void m2181a(InterfaceC1872i interfaceC1872i) {
        try {
            AppLog.m2158a("LOGIC_HCE", "AndaHCEManager", "HCEManager.enableValidations", "Enabling validations");
            C1417b.m4518a().m4506a(App.getContext(), true, true, (InterfaceC1416a) new C1867d(interfaceC1872i));
        } catch (Throwable th) {
            AppLog.m2158a("LOGIC_HCE", "AndaHCEManager", "HCEManager.enableValidations", "Exception: " + Log.getStackTraceString(th));
        }
    }

    /* renamed from: a */
    public void m2182a(InterfaceC1871h interfaceC1871h) {
        try {
            AppLog.m2158a("LOGIC_HCE", "AndaHCEManager", "HCEManager.disableValidations", "Disabling validations");
            C1417b.m4518a().m4506a(App.getContext(), true, false, (InterfaceC1416a) new C1868e(interfaceC1871h));
        } catch (Throwable th) {
            AppLog.m2158a("LOGIC_HCE", "AndaHCEManager", "HCEManager.disableValidations", "Exception: " + Log.getStackTraceString(th));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public String m2171a(String str, int i) {
        return String.format("%" + i + "s", str).replace(' ', '0');
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public long m2183a(long j) {
        return m2168b(j + 852076800);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public DataModels.C2700i m2172a(String str) {
        try {
            String m2171a = m2171a(new BigInteger(str, 10).toString(16), 16);
            String m2171a2 = m2171a(m2171a.substring(4, 16), 16);
            int parseInt = Integer.parseInt(m2171a.substring(0, 4), 16);
            Calendar calendar = Calendar.getInstance(TimeZone.getTimeZone("UTC"));
            calendar.set(2010, 0, 1, 0, 0, 0);
            calendar.add(11, (parseInt * 12) + 12);
            Calendar calendar2 = Calendar.getInstance(TimeZone.getTimeZone("Europe/Lisbon"));
            calendar2.set(calendar.get(1), calendar.get(2), calendar.get(5), calendar.get(11), calendar.get(12), calendar.get(13));
            String upperCase = m2171a.toUpperCase();
            String upperCase2 = m2171a2.toUpperCase();
            return new DataModels.C2700i(upperCase, upperCase2, "5" + new BigInteger(m2171a2.substring(8, 16), 16).toString(10), calendar2.getTimeInMillis());
        } catch (Throwable th) {
            AppLog.m2158a("LOGIC_HCE", "AndaHCEManager", "HCEManager.getCardInfo", "Failed to get the card info:" + Log.getStackTraceString(th));
            return null;
        }
    }

    /* renamed from: a */
    public void m2180a(InterfaceC1874k interfaceC1874k) {
        try {
            C1417b.m4518a().m4507a(App.getContext(), m2166d(), new C1869f(interfaceC1874k));
        } catch (Throwable th) {
            AppLog.m2158a("LOGIC_HCE", "AndaHCEManager", "HCEManager.getCardInfo", "Exception: " + Log.getStackTraceString(th));
            if (interfaceC1874k != null) {
                interfaceC1874k.mo1725a(0, "Get card info failed");
            }
        }
    }

    /* renamed from: a */
    public void m2179a(InterfaceC1875l interfaceC1875l) {
        try {
            C1417b.m4518a().m4501b(App.getContext(), new C1870g(this, interfaceC1875l));
        } catch (Throwable th) {
            AppLog.m2158a("LOGIC_HCE", "AndaHCEManager", "HCEManager.Synchronize", "Exception: " + Log.getStackTraceString(th));
            if (interfaceC1875l != null) {
                interfaceC1875l.mo1739a(0, "Synchronize failed");
            }
        }
    }
}
