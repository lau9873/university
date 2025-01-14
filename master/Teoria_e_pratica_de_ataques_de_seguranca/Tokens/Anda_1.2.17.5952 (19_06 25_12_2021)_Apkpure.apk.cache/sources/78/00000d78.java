package p205h.p198a.p199a;

import android.os.SystemClock;
import android.util.Log;
import com.j256.ormlite.android.apptools.OrmLiteConfigUtil;
import java.math.BigInteger;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.TimeZone;
import org.json.JSONArray;
import org.json.JSONObject;
import p215c.p112g.p122b.p123a.AbstractC2059a;
import p215c.p112g.p122b.p123a.C2060b;
import p227pt.card4b.backendbeacons.App;
import p227pt.card4b.backendbeacons.DataModels;

/* compiled from: AndaHCEManager.java */
/* renamed from: h.a.a.b */
/* loaded from: classes.dex */
public class C3034b {

    /* renamed from: d */
    public static volatile C3034b f8745d;

    /* renamed from: a */
    public AbstractC2059a f8746a = new C3035a();

    /* renamed from: b */
    public AbstractC3047m f8747b;

    /* renamed from: c */
    public boolean f8748c;

    /* compiled from: AndaHCEManager.java */
    /* renamed from: h.a.a.b$a */
    /* loaded from: classes.dex */
    public class C3035a implements AbstractC2059a {
        public C3035a() {
        }

        @Override // p215c.p112g.p122b.p123a.AbstractC2059a
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
                            C3048c.m2158a("LOGIC_HCE", "AndaHCEManager", "HCEManager.apiListener", "Card content updated");
                            return;
                        }
                        C3048c.m2158a("LOGIC_HCE", "AndaHCEManager", "HCEManager.apiListener", "Card content update failed with error " + i);
                    }
                } else if (i == 0) {
                    try {
                        C3048c.m2158a("LOGIC_HCE", "AndaHCEManager", "HCEManager.HceListener", "Card validated");
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
                        DataModels.C3999i m2172a = jSONObject.has("serialNumber") ? C3034b.this.m2172a((String) jSONObject.get("serialNumber")) : null;
                        if (str2 != null && str2.length() > 0) {
                            String m2171a = C3034b.this.m2171a(new BigInteger(str2, 16).toString(2), str2.length() * 4);
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
                                calendar.setTimeInMillis(C3034b.this.m2183a(parseLong4) * 1000);
                                Calendar calendar2 = Calendar.getInstance(TimeZone.getTimeZone("Europe/Lisbon"));
                                calendar2.set(calendar.get(1), calendar.get(2), calendar.get(5), calendar.get(11), calendar.get(12), calendar.get(13));
                                timeInMillis = calendar2.getTimeInMillis();
                                m1494g = C3452w.m1497d().m1494g();
                                elapsedRealtime = SystemClock.elapsedRealtime();
                                sb = new StringBuilder();
                                str = "HCEManager.HceListener";
                            } catch (Throwable th2) {
                                th = th2;
                                str = "HCEManager.HceListener";
                                str3 = "AndaHCEManager";
                                C3048c.m2158a("LOGIC_HCE", str3, str, "Exception processing answer" + Log.getStackTraceString(th));
                                return;
                            }
                            try {
                                sb.append("System date: ");
                                sb.append(C3402p.m1593b(C3452w.m1497d().m1495f()));
                                sb.append(" Event data - timestamp:");
                                sb.append(C3402p.m1593b(C3402p.m1602a(timeInMillis)));
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
                                    C3048c.m2158a("LOGIC_HCE", "AndaHCEManager", "Validation notify", sb.toString());
                                } catch (Throwable th3) {
                                    th = th3;
                                }
                                try {
                                    if (C3034b.this.f8747b != null) {
                                        C3034b.this.f8747b.mo1715a(m2172a, timeInMillis, m1494g, elapsedRealtime, (int) parseLong, (int) parseLong3, (int) parseLong5, (int) parseLong2, (int) j, (int) j2);
                                        return;
                                    }
                                    return;
                                } catch (Throwable th4) {
                                    th = th4;
                                    str3 = "AndaHCEManager";
                                    C3048c.m2158a("LOGIC_HCE", str3, str, "Exception processing answer" + Log.getStackTraceString(th));
                                    return;
                                }
                            } catch (Throwable th5) {
                                th = th5;
                                str3 = "AndaHCEManager";
                                C3048c.m2158a("LOGIC_HCE", str3, str, "Exception processing answer" + Log.getStackTraceString(th));
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
                    C3048c.m2158a("LOGIC_HCE", "AndaHCEManager", "HCEManager.apiListener", "Card validation failed with error " + i);
                }
            } catch (Throwable th7) {
                th = th7;
            }
        }
    }

    /* compiled from: AndaHCEManager.java */
    /* renamed from: h.a.a.b$b */
    /* loaded from: classes.dex */
    public class C3036b implements AbstractC2059a {
        public C3036b(C3034b c3034b) {
        }

        @Override // p215c.p112g.p122b.p123a.AbstractC2059a
        public void notifyAnswer(int i, int i2, JSONObject jSONObject) {
            if (i == 0) {
                C3048c.m2158a("LOGIC_HCE", "AndaHCEManager", "HCEManager.getInformation", " ManagerVersion " + jSONObject.optString("ManagerVersion") + " \n ManagerDate " + jSONObject.optString("ManagerDate") + " \n autoupdatesEnabled " + jSONObject.optString("autoupdatesEnabled") + " \n validationsEnabled " + jSONObject.optString("validationsEnabled") + " ");
                return;
            }
            C3048c.m2158a("LOGIC_HCE", "AndaHCEManager", "HCEManager.getInformation", "Error: " + i);
        }
    }

    /* compiled from: AndaHCEManager.java */
    /* renamed from: h.a.a.b$c */
    /* loaded from: classes.dex */
    public class C3037c implements AbstractC2059a {

        /* renamed from: a */
        public final /* synthetic */ AbstractC3044j f8750a;

        public C3037c(C3034b c3034b, AbstractC3044j abstractC3044j) {
            this.f8750a = abstractC3044j;
        }

        @Override // p215c.p112g.p122b.p123a.AbstractC2059a
        public void notifyAnswer(int i, int i2, JSONObject jSONObject) {
            if (i == 0) {
                C3048c.m2158a("LOGIC_HCE", "AndaHCEManager", "HCEManager.enroll", "Enroll succeeded");
                AbstractC3044j abstractC3044j = this.f8750a;
                if (abstractC3044j != null) {
                    abstractC3044j.onSuccess();
                    return;
                }
                return;
            }
            C3048c.m2158a("LOGIC_HCE", "AndaHCEManager", "HCEManager.enroll", "Enrolment failed with error " + i);
            AbstractC3044j abstractC3044j2 = this.f8750a;
            if (abstractC3044j2 != null) {
                abstractC3044j2.mo1764a(i, "Enrolment failed with error " + i);
            }
        }
    }

    /* compiled from: AndaHCEManager.java */
    /* renamed from: h.a.a.b$d */
    /* loaded from: classes.dex */
    public class C3038d implements AbstractC2059a {

        /* renamed from: a */
        public final /* synthetic */ AbstractC3043i f8751a;

        public C3038d(AbstractC3043i abstractC3043i) {
            this.f8751a = abstractC3043i;
        }

        @Override // p215c.p112g.p122b.p123a.AbstractC2059a
        public void notifyAnswer(int i, int i2, JSONObject jSONObject) {
            if (i == 0) {
                C3034b.this.f8748c = true;
                C3048c.m2158a("LOGIC_HCE", "AndaHCEManager", "HCEManager.enableValidations", "Enabling validations succeeded");
                AbstractC3043i abstractC3043i = this.f8751a;
                if (abstractC3043i != null) {
                    abstractC3043i.onSuccess();
                    return;
                }
                return;
            }
            C3048c.m2158a("LOGIC_HCE", "AndaHCEManager", "HCEManager.enableValidations", "Enabling validations failed with error " + i);
            AbstractC3043i abstractC3043i2 = this.f8751a;
            if (abstractC3043i2 != null) {
                abstractC3043i2.mo1747a(i, "Enabling validations failed with error " + i);
            }
        }
    }

    /* compiled from: AndaHCEManager.java */
    /* renamed from: h.a.a.b$e */
    /* loaded from: classes.dex */
    public class C3039e implements AbstractC2059a {

        /* renamed from: a */
        public final /* synthetic */ AbstractC3042h f8753a;

        public C3039e(AbstractC3042h abstractC3042h) {
            this.f8753a = abstractC3042h;
        }

        @Override // p215c.p112g.p122b.p123a.AbstractC2059a
        public void notifyAnswer(int i, int i2, JSONObject jSONObject) {
            if (i == 0) {
                C3034b.this.f8748c = false;
                C3048c.m2158a("LOGIC_HCE", "AndaHCEManager", "HCEManager.disableValidations", "Disabling validations succeeded");
                AbstractC3042h abstractC3042h = this.f8753a;
                if (abstractC3042h != null) {
                    abstractC3042h.onSuccess();
                    return;
                }
                return;
            }
            C3048c.m2158a("LOGIC_HCE", "AndaHCEManager", "HCEManager.disableValidations", "Disabling validations failed with error " + i);
            AbstractC3042h abstractC3042h2 = this.f8753a;
            if (abstractC3042h2 != null) {
                abstractC3042h2.mo1745a(i, "Disabling validations failed with error " + i);
            }
        }
    }

    /* compiled from: AndaHCEManager.java */
    /* renamed from: h.a.a.b$f */
    /* loaded from: classes.dex */
    public class C3040f implements AbstractC2059a {

        /* renamed from: a */
        public final /* synthetic */ AbstractC3045k f8755a;

        public C3040f(AbstractC3045k abstractC3045k) {
            this.f8755a = abstractC3045k;
        }

        @Override // p215c.p112g.p122b.p123a.AbstractC2059a
        public void notifyAnswer(int i, int i2, JSONObject jSONObject) {
            try {
                if (i == 0) {
                    DataModels.C3999i m2172a = jSONObject.has("serialNumber") ? C3034b.this.m2172a((String) jSONObject.get("serialNumber")) : null;
                    if (m2172a != null) {
                        AbstractC3045k abstractC3045k = this.f8755a;
                        if (abstractC3045k != null) {
                            abstractC3045k.mo1724a(m2172a);
                            return;
                        }
                        return;
                    }
                    AbstractC3045k abstractC3045k2 = this.f8755a;
                    if (abstractC3045k2 != null) {
                        abstractC3045k2.mo1725a(0, "Get card info failed");
                        return;
                    }
                    return;
                }
                C3048c.m2158a("LOGIC_HCE", "AndaHCEManager", "HCEManager.getCardInfo", "Get card contents failed with error: " + i);
                AbstractC3045k abstractC3045k3 = this.f8755a;
                if (abstractC3045k3 != null) {
                    abstractC3045k3.mo1725a(i, "Error getting card info: " + i);
                }
            } catch (Throwable th) {
                C3048c.m2158a("LOGIC_HCE", "AndaHCEManager", "HCEManager.getCardInfo", "Exception: " + Log.getStackTraceString(th));
                AbstractC3045k abstractC3045k4 = this.f8755a;
                if (abstractC3045k4 != null) {
                    abstractC3045k4.mo1725a(0, "Get card info failed");
                }
            }
        }
    }

    /* compiled from: AndaHCEManager.java */
    /* renamed from: h.a.a.b$g */
    /* loaded from: classes.dex */
    public class C3041g implements AbstractC2059a {

        /* renamed from: a */
        public final /* synthetic */ AbstractC3046l f8757a;

        public C3041g(C3034b c3034b, AbstractC3046l abstractC3046l) {
            this.f8757a = abstractC3046l;
        }

        @Override // p215c.p112g.p122b.p123a.AbstractC2059a
        public void notifyAnswer(int i, int i2, JSONObject jSONObject) {
            if (i == 0) {
                AbstractC3046l abstractC3046l = this.f8757a;
                if (abstractC3046l != null) {
                    abstractC3046l.mo1740a();
                    return;
                }
                return;
            }
            AbstractC3046l abstractC3046l2 = this.f8757a;
            if (abstractC3046l2 != null) {
                abstractC3046l2.mo1739a(i, "Synchronize failed");
            }
        }
    }

    /* compiled from: AndaHCEManager.java */
    /* renamed from: h.a.a.b$h */
    /* loaded from: classes.dex */
    public interface AbstractC3042h {
        /* renamed from: a */
        void mo1745a(int i, String str);

        void onSuccess();
    }

    /* compiled from: AndaHCEManager.java */
    /* renamed from: h.a.a.b$i */
    /* loaded from: classes.dex */
    public interface AbstractC3043i {
        /* renamed from: a */
        void mo1747a(int i, String str);

        void onSuccess();
    }

    /* compiled from: AndaHCEManager.java */
    /* renamed from: h.a.a.b$j */
    /* loaded from: classes.dex */
    public interface AbstractC3044j {
        /* renamed from: a */
        void mo1764a(int i, String str);

        void onSuccess();
    }

    /* compiled from: AndaHCEManager.java */
    /* renamed from: h.a.a.b$k */
    /* loaded from: classes.dex */
    public interface AbstractC3045k {
        /* renamed from: a */
        void mo1725a(int i, String str);

        /* renamed from: a */
        void mo1724a(DataModels.C3999i c3999i);
    }

    /* compiled from: AndaHCEManager.java */
    /* renamed from: h.a.a.b$l */
    /* loaded from: classes.dex */
    public interface AbstractC3046l {
        /* renamed from: a */
        void mo1740a();

        /* renamed from: a */
        void mo1739a(int i, String str);
    }

    /* compiled from: AndaHCEManager.java */
    /* renamed from: h.a.a.b$m */
    /* loaded from: classes.dex */
    public interface AbstractC3047m {
        /* renamed from: a */
        void mo1715a(DataModels.C3999i c3999i, long j, long j2, long j3, int i, int i2, int i3, int i4, int i5, int i6);
    }

    public C3034b() {
        new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        this.f8748c = false;
        if (f8745d == null) {
            C3048c.m2158a("LOGIC_HCE", "AndaHCEManager", "HCEManager.init", "Initializing HCE Manager");
            C2060b.m4518a().m4510a(App.getContext(), App.getPackName());
            C2060b.m4518a().m4511a(App.getContext(), new C3036b(this));
            C2060b.m4518a().m4505a(this.f8746a);
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
            return C2060b.m4518a().m4515a(App.getContext());
        } catch (Throwable th) {
            C3048c.m2158a("LOGIC_HCE", "AndaHCEManager", "HCEManager.isEnrolled", "Exception: " + Log.getStackTraceString(th));
            return false;
        }
    }

    /* renamed from: c */
    public boolean m2167c() {
        return this.f8748c;
    }

    /* renamed from: a */
    public static C3034b m2184a() {
        if (f8745d == null) {
            synchronized (C3034b.class) {
                if (f8745d == null) {
                    f8745d = new C3034b();
                }
            }
        }
        return f8745d;
    }

    /* renamed from: a */
    public void m2178a(AbstractC3047m abstractC3047m) {
        this.f8747b = abstractC3047m;
    }

    /* renamed from: a */
    public void m2170a(String str, AbstractC3044j abstractC3044j) {
        try {
            C3048c.m2158a("LOGIC_HCE", "AndaHCEManager", "HCEManager.Enroll", "Enrolling new card for phone nr " + str);
            C2060b.m4518a().m4512a(App.getContext(), 1, str, new C3037c(this, abstractC3044j));
        } catch (Throwable th) {
            C3048c.m2158a("LOGIC_HCE", "AndaHCEManager", "HCEManager.enroll", "Exception: " + Log.getStackTraceString(th));
            if (abstractC3044j != null) {
                abstractC3044j.mo1764a(0, "Enrolment failed");
            }
        }
    }

    /* renamed from: a */
    public void m2181a(AbstractC3043i abstractC3043i) {
        try {
            C3048c.m2158a("LOGIC_HCE", "AndaHCEManager", "HCEManager.enableValidations", "Enabling validations");
            C2060b.m4518a().m4506a(App.getContext(), true, true, (AbstractC2059a) new C3038d(abstractC3043i));
        } catch (Throwable th) {
            C3048c.m2158a("LOGIC_HCE", "AndaHCEManager", "HCEManager.enableValidations", "Exception: " + Log.getStackTraceString(th));
        }
    }

    /* renamed from: a */
    public void m2182a(AbstractC3042h abstractC3042h) {
        try {
            C3048c.m2158a("LOGIC_HCE", "AndaHCEManager", "HCEManager.disableValidations", "Disabling validations");
            C2060b.m4518a().m4506a(App.getContext(), true, false, (AbstractC2059a) new C3039e(abstractC3042h));
        } catch (Throwable th) {
            C3048c.m2158a("LOGIC_HCE", "AndaHCEManager", "HCEManager.disableValidations", "Exception: " + Log.getStackTraceString(th));
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
    public DataModels.C3999i m2172a(String str) {
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
            return new DataModels.C3999i(upperCase, upperCase2, "5" + new BigInteger(m2171a2.substring(8, 16), 16).toString(10), calendar2.getTimeInMillis());
        } catch (Throwable th) {
            C3048c.m2158a("LOGIC_HCE", "AndaHCEManager", "HCEManager.getCardInfo", "Failed to get the card info:" + Log.getStackTraceString(th));
            return null;
        }
    }

    /* renamed from: a */
    public void m2180a(AbstractC3045k abstractC3045k) {
        try {
            C2060b.m4518a().m4507a(App.getContext(), m2166d(), new C3040f(abstractC3045k));
        } catch (Throwable th) {
            C3048c.m2158a("LOGIC_HCE", "AndaHCEManager", "HCEManager.getCardInfo", "Exception: " + Log.getStackTraceString(th));
            if (abstractC3045k != null) {
                abstractC3045k.mo1725a(0, "Get card info failed");
            }
        }
    }

    /* renamed from: a */
    public void m2179a(AbstractC3046l abstractC3046l) {
        try {
            C2060b.m4518a().m4501b(App.getContext(), new C3041g(this, abstractC3046l));
        } catch (Throwable th) {
            C3048c.m2158a("LOGIC_HCE", "AndaHCEManager", "HCEManager.Synchronize", "Exception: " + Log.getStackTraceString(th));
            if (abstractC3046l != null) {
                abstractC3046l.mo1739a(0, "Synchronize failed");
            }
        }
    }
}