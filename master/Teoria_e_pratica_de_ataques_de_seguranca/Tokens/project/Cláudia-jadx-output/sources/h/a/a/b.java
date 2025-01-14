package h.a.a;

import android.os.SystemClock;
import android.util.Log;
import com.j256.ormlite.android.apptools.OrmLiteConfigUtil;
import java.math.BigInteger;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.TimeZone;
import org.json.JSONArray;
import org.json.JSONObject;
import pt.card4b.backendbeacons.App;
import pt.card4b.backendbeacons.DataModels;
/* compiled from: AndaHCEManager.java */
/* loaded from: classes.dex */
public class b {

    /* renamed from: d  reason: collision with root package name */
    public static volatile b f6250d;

    /* renamed from: a  reason: collision with root package name */
    public c.g.b.a.a f6251a = new a();

    /* renamed from: b  reason: collision with root package name */
    public m f6252b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f6253c;

    /* compiled from: AndaHCEManager.java */
    /* loaded from: classes.dex */
    public class a implements c.g.b.a.a {
        public a() {
        }

        @Override // c.g.b.a.a
        public void notifyAnswer(int i2, int i3, JSONObject jSONObject) {
            String str;
            String str2;
            String str3 = OrmLiteConfigUtil.RAW_DIR_NAME;
            try {
                if (i3 != 326) {
                    if (i3 == 325) {
                        if (i2 == 0) {
                            h.a.a.c.a("LOGIC_HCE", "AndaHCEManager", "HCEManager.apiListener", "Card content updated");
                            return;
                        }
                        h.a.a.c.a("LOGIC_HCE", "AndaHCEManager", "HCEManager.apiListener", "Card content update failed with error " + i2);
                    }
                } else if (i2 == 0) {
                    try {
                        h.a.a.c.a("LOGIC_HCE", "AndaHCEManager", "HCEManager.HceListener", "Card validated");
                        if (jSONObject.has("records")) {
                            JSONArray jSONArray = (JSONArray) jSONObject.get("records");
                            for (int i4 = 0; i4 < jSONArray.length(); i4++) {
                                JSONObject jSONObject2 = (JSONObject) jSONArray.get(i4);
                                if (jSONObject2.has("sfi") && jSONObject2.getInt("sfi") == 8 && jSONObject2.has("recnum") && jSONObject2.getInt("recnum") == 1 && jSONObject2.has(OrmLiteConfigUtil.RAW_DIR_NAME)) {
                                    str2 = jSONObject2.getString(OrmLiteConfigUtil.RAW_DIR_NAME);
                                    break;
                                }
                            }
                        }
                        str2 = null;
                        DataModels.i a2 = jSONObject.has("serialNumber") ? b.this.a((String) jSONObject.get("serialNumber")) : null;
                        if (str2 != null && str2.length() > 0) {
                            String a3 = b.this.a(new BigInteger(str2, 16).toString(2), str2.length() * 4);
                            long parseLong = Long.parseLong(a3.substring(3, 33), 2);
                            long parseLong2 = Long.parseLong(a3.substring(33, 40), 2);
                            try {
                                long parseLong3 = Long.parseLong(a3.substring(133, 141), 2);
                                long parseLong4 = Long.parseLong(a3.substring(141, 157), 2);
                                long parseLong5 = Long.parseLong(a3.substring(157, 173), 2);
                                long j = parseLong4 & 7;
                                long j2 = (parseLong4 >> 3) & 7;
                                Calendar calendar = Calendar.getInstance(TimeZone.getTimeZone("UTC"));
                                try {
                                    calendar.setTimeInMillis(b.this.a(parseLong) * 1000);
                                    Calendar calendar2 = Calendar.getInstance(TimeZone.getTimeZone("Europe/Lisbon"));
                                    calendar2.set(calendar.get(1), calendar.get(2), calendar.get(5), calendar.get(11), calendar.get(12), calendar.get(13));
                                    long timeInMillis = calendar2.getTimeInMillis();
                                    long g2 = w.d().g();
                                    long elapsedRealtime = SystemClock.elapsedRealtime();
                                    StringBuilder sb = new StringBuilder();
                                    str = "HCEManager.HceListener";
                                    try {
                                        sb.append("System date: ");
                                        sb.append(p.b(w.d().f()));
                                        sb.append(" Event data - timestamp:");
                                        sb.append(p.b(p.a(timeInMillis)));
                                        sb.append(" provider:");
                                        sb.append(parseLong3);
                                        sb.append(" line:");
                                        sb.append(parseLong5);
                                        sb.append(" zone:");
                                        sb.append(parseLong2);
                                        sb.append(" location:");
                                        sb.append(parseLong4);
                                        sb.append(" direction: ");
                                        sb.append(j);
                                        sb.append(" variant:");
                                        sb.append(j2);
                                        try {
                                            h.a.a.c.a("LOGIC_HCE", "AndaHCEManager", "Validation notify", sb.toString());
                                            try {
                                                if (b.this.f6252b != null) {
                                                    b.this.f6252b.a(a2, timeInMillis, g2, elapsedRealtime, (int) parseLong3, (int) parseLong5, (int) parseLong2, (int) parseLong4, (int) j, (int) j2);
                                                }
                                            } catch (Throwable th) {
                                                th = th;
                                                str3 = "AndaHCEManager";
                                                h.a.a.c.a("LOGIC_HCE", str3, str, "Exception processing answer" + Log.getStackTraceString(th));
                                            }
                                        } catch (Throwable th2) {
                                            th = th2;
                                        }
                                    } catch (Throwable th3) {
                                        th = th3;
                                        str3 = "AndaHCEManager";
                                        h.a.a.c.a("LOGIC_HCE", str3, str, "Exception processing answer" + Log.getStackTraceString(th));
                                    }
                                } catch (Throwable th4) {
                                    th = th4;
                                    str = "HCEManager.HceListener";
                                    str3 = "AndaHCEManager";
                                    h.a.a.c.a("LOGIC_HCE", str3, str, "Exception processing answer" + Log.getStackTraceString(th));
                                }
                            } catch (Throwable th5) {
                                th = th5;
                            }
                        } else {
                            throw new Exception("HCEManager.HceListener: Validation event not found or empty");
                        }
                    } catch (Throwable th6) {
                        th = th6;
                        str = "HCEManager.HceListener";
                        str3 = "AndaHCEManager";
                    }
                } else {
                    h.a.a.c.a("LOGIC_HCE", "AndaHCEManager", "HCEManager.apiListener", "Card validation failed with error " + i2);
                }
            } catch (Throwable th7) {
                th = th7;
            }
        }
    }

    /* compiled from: AndaHCEManager.java */
    /* renamed from: h.a.a.b$b  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0128b implements c.g.b.a.a {
        public C0128b(b bVar) {
        }

        @Override // c.g.b.a.a
        public void notifyAnswer(int i2, int i3, JSONObject jSONObject) {
            if (i2 == 0) {
                h.a.a.c.a("LOGIC_HCE", "AndaHCEManager", "HCEManager.getInformation", " ManagerVersion " + jSONObject.optString("ManagerVersion") + " \n ManagerDate " + jSONObject.optString("ManagerDate") + " \n autoupdatesEnabled " + jSONObject.optString("autoupdatesEnabled") + " \n validationsEnabled " + jSONObject.optString("validationsEnabled") + " ");
                return;
            }
            h.a.a.c.a("LOGIC_HCE", "AndaHCEManager", "HCEManager.getInformation", "Error: " + i2);
        }
    }

    /* compiled from: AndaHCEManager.java */
    /* loaded from: classes.dex */
    public class c implements c.g.b.a.a {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ j f6255a;

        public c(b bVar, j jVar) {
            this.f6255a = jVar;
        }

        @Override // c.g.b.a.a
        public void notifyAnswer(int i2, int i3, JSONObject jSONObject) {
            if (i2 == 0) {
                h.a.a.c.a("LOGIC_HCE", "AndaHCEManager", "HCEManager.enroll", "Enroll succeeded");
                j jVar = this.f6255a;
                if (jVar != null) {
                    jVar.onSuccess();
                    return;
                }
                return;
            }
            h.a.a.c.a("LOGIC_HCE", "AndaHCEManager", "HCEManager.enroll", "Enrolment failed with error " + i2);
            j jVar2 = this.f6255a;
            if (jVar2 != null) {
                jVar2.a(i2, "Enrolment failed with error " + i2);
            }
        }
    }

    /* compiled from: AndaHCEManager.java */
    /* loaded from: classes.dex */
    public class d implements c.g.b.a.a {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ i f6256a;

        public d(i iVar) {
            this.f6256a = iVar;
        }

        @Override // c.g.b.a.a
        public void notifyAnswer(int i2, int i3, JSONObject jSONObject) {
            if (i2 == 0) {
                b.this.f6253c = true;
                h.a.a.c.a("LOGIC_HCE", "AndaHCEManager", "HCEManager.enableValidations", "Enabling validations succeeded");
                i iVar = this.f6256a;
                if (iVar != null) {
                    iVar.onSuccess();
                    return;
                }
                return;
            }
            h.a.a.c.a("LOGIC_HCE", "AndaHCEManager", "HCEManager.enableValidations", "Enabling validations failed with error " + i2);
            i iVar2 = this.f6256a;
            if (iVar2 != null) {
                iVar2.a(i2, "Enabling validations failed with error " + i2);
            }
        }
    }

    /* compiled from: AndaHCEManager.java */
    /* loaded from: classes.dex */
    public class e implements c.g.b.a.a {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ h f6258a;

        public e(h hVar) {
            this.f6258a = hVar;
        }

        @Override // c.g.b.a.a
        public void notifyAnswer(int i2, int i3, JSONObject jSONObject) {
            if (i2 == 0) {
                b.this.f6253c = false;
                h.a.a.c.a("LOGIC_HCE", "AndaHCEManager", "HCEManager.disableValidations", "Disabling validations succeeded");
                h hVar = this.f6258a;
                if (hVar != null) {
                    hVar.onSuccess();
                    return;
                }
                return;
            }
            h.a.a.c.a("LOGIC_HCE", "AndaHCEManager", "HCEManager.disableValidations", "Disabling validations failed with error " + i2);
            h hVar2 = this.f6258a;
            if (hVar2 != null) {
                hVar2.a(i2, "Disabling validations failed with error " + i2);
            }
        }
    }

    /* compiled from: AndaHCEManager.java */
    /* loaded from: classes.dex */
    public class f implements c.g.b.a.a {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ k f6260a;

        public f(k kVar) {
            this.f6260a = kVar;
        }

        @Override // c.g.b.a.a
        public void notifyAnswer(int i2, int i3, JSONObject jSONObject) {
            try {
                if (i2 == 0) {
                    DataModels.i a2 = jSONObject.has("serialNumber") ? b.this.a((String) jSONObject.get("serialNumber")) : null;
                    if (a2 != null) {
                        k kVar = this.f6260a;
                        if (kVar != null) {
                            kVar.a(a2);
                            return;
                        }
                        return;
                    }
                    k kVar2 = this.f6260a;
                    if (kVar2 != null) {
                        kVar2.a(0, "Get card info failed");
                        return;
                    }
                    return;
                }
                h.a.a.c.a("LOGIC_HCE", "AndaHCEManager", "HCEManager.getCardInfo", "Get card contents failed with error: " + i2);
                k kVar3 = this.f6260a;
                if (kVar3 != null) {
                    kVar3.a(i2, "Error getting card info: " + i2);
                }
            } catch (Throwable th) {
                h.a.a.c.a("LOGIC_HCE", "AndaHCEManager", "HCEManager.getCardInfo", "Exception: " + Log.getStackTraceString(th));
                k kVar4 = this.f6260a;
                if (kVar4 != null) {
                    kVar4.a(0, "Get card info failed");
                }
            }
        }
    }

    /* compiled from: AndaHCEManager.java */
    /* loaded from: classes.dex */
    public class g implements c.g.b.a.a {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ l f6262a;

        public g(b bVar, l lVar) {
            this.f6262a = lVar;
        }

        @Override // c.g.b.a.a
        public void notifyAnswer(int i2, int i3, JSONObject jSONObject) {
            if (i2 == 0) {
                l lVar = this.f6262a;
                if (lVar != null) {
                    lVar.a();
                    return;
                }
                return;
            }
            l lVar2 = this.f6262a;
            if (lVar2 != null) {
                lVar2.a(i2, "Synchronize failed");
            }
        }
    }

    /* compiled from: AndaHCEManager.java */
    /* loaded from: classes.dex */
    public interface h {
        void a(int i2, String str);

        void onSuccess();
    }

    /* compiled from: AndaHCEManager.java */
    /* loaded from: classes.dex */
    public interface i {
        void a(int i2, String str);

        void onSuccess();
    }

    /* compiled from: AndaHCEManager.java */
    /* loaded from: classes.dex */
    public interface j {
        void a(int i2, String str);

        void onSuccess();
    }

    /* compiled from: AndaHCEManager.java */
    /* loaded from: classes.dex */
    public interface k {
        void a(int i2, String str);

        void a(DataModels.i iVar);
    }

    /* compiled from: AndaHCEManager.java */
    /* loaded from: classes.dex */
    public interface l {
        void a();

        void a(int i2, String str);
    }

    /* compiled from: AndaHCEManager.java */
    /* loaded from: classes.dex */
    public interface m {
        void a(DataModels.i iVar, long j, long j2, long j3, int i2, int i3, int i4, int i5, int i6, int i7);
    }

    public b() {
        new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        this.f6253c = false;
        if (f6250d == null) {
            h.a.a.c.a("LOGIC_HCE", "AndaHCEManager", "HCEManager.init", "Initializing HCE Manager");
            c.g.b.a.b.a().a(App.getContext(), App.getPackName());
            c.g.b.a.b.a().a(App.getContext(), new C0128b(this));
            c.g.b.a.b.a().a(this.f6251a);
            return;
        }
        throw new RuntimeException("AndaHCEManager: Use getInstance() method to get the single instance of this class.");
    }

    private long b(long j2) {
        if (j2 <= 2147483647L) {
            return j2;
        }
        return 2147483647L;
    }

    private JSONObject d() {
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

    public boolean b() {
        try {
            return c.g.b.a.b.a().a(App.getContext());
        } catch (Throwable th) {
            h.a.a.c.a("LOGIC_HCE", "AndaHCEManager", "HCEManager.isEnrolled", "Exception: " + Log.getStackTraceString(th));
            return false;
        }
    }

    public boolean c() {
        return this.f6253c;
    }

    public static b a() {
        if (f6250d == null) {
            synchronized (b.class) {
                if (f6250d == null) {
                    f6250d = new b();
                }
            }
        }
        return f6250d;
    }

    public void a(m mVar) {
        this.f6252b = mVar;
    }

    public void a(String str, j jVar) {
        try {
            h.a.a.c.a("LOGIC_HCE", "AndaHCEManager", "HCEManager.Enroll", "Enrolling new card for phone nr " + str);
            c.g.b.a.b.a().a(App.getContext(), 1, str, new c(this, jVar));
        } catch (Throwable th) {
            h.a.a.c.a("LOGIC_HCE", "AndaHCEManager", "HCEManager.enroll", "Exception: " + Log.getStackTraceString(th));
            if (jVar != null) {
                jVar.a(0, "Enrolment failed");
            }
        }
    }

    public void a(i iVar) {
        try {
            h.a.a.c.a("LOGIC_HCE", "AndaHCEManager", "HCEManager.enableValidations", "Enabling validations");
            c.g.b.a.b.a().a(App.getContext(), true, true, (c.g.b.a.a) new d(iVar));
        } catch (Throwable th) {
            h.a.a.c.a("LOGIC_HCE", "AndaHCEManager", "HCEManager.enableValidations", "Exception: " + Log.getStackTraceString(th));
        }
    }

    public void a(h hVar) {
        try {
            h.a.a.c.a("LOGIC_HCE", "AndaHCEManager", "HCEManager.disableValidations", "Disabling validations");
            c.g.b.a.b.a().a(App.getContext(), true, false, (c.g.b.a.a) new e(hVar));
        } catch (Throwable th) {
            h.a.a.c.a("LOGIC_HCE", "AndaHCEManager", "HCEManager.disableValidations", "Exception: " + Log.getStackTraceString(th));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String a(String str, int i2) {
        return String.format("%" + i2 + "s", str).replace(' ', '0');
    }

    /* JADX INFO: Access modifiers changed from: private */
    public long a(long j2) {
        return b(j2 + 852076800);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public DataModels.i a(String str) {
        try {
            String a2 = a(new BigInteger(str, 10).toString(16), 16);
            String a3 = a(a2.substring(4, 16), 16);
            int parseInt = Integer.parseInt(a2.substring(0, 4), 16);
            Calendar calendar = Calendar.getInstance(TimeZone.getTimeZone("UTC"));
            calendar.set(2010, 0, 1, 0, 0, 0);
            calendar.add(11, (parseInt * 12) + 12);
            Calendar calendar2 = Calendar.getInstance(TimeZone.getTimeZone("Europe/Lisbon"));
            calendar2.set(calendar.get(1), calendar.get(2), calendar.get(5), calendar.get(11), calendar.get(12), calendar.get(13));
            String upperCase = a2.toUpperCase();
            String upperCase2 = a3.toUpperCase();
            return new DataModels.i(upperCase, upperCase2, "5" + new BigInteger(a3.substring(8, 16), 16).toString(10), calendar2.getTimeInMillis());
        } catch (Throwable th) {
            h.a.a.c.a("LOGIC_HCE", "AndaHCEManager", "HCEManager.getCardInfo", "Failed to get the card info:" + Log.getStackTraceString(th));
            return null;
        }
    }

    public void a(k kVar) {
        try {
            c.g.b.a.b.a().a(App.getContext(), d(), new f(kVar));
        } catch (Throwable th) {
            h.a.a.c.a("LOGIC_HCE", "AndaHCEManager", "HCEManager.getCardInfo", "Exception: " + Log.getStackTraceString(th));
            if (kVar != null) {
                kVar.a(0, "Get card info failed");
            }
        }
    }

    public void a(l lVar) {
        try {
            c.g.b.a.b.a().b(App.getContext(), new g(this, lVar));
        } catch (Throwable th) {
            h.a.a.c.a("LOGIC_HCE", "AndaHCEManager", "HCEManager.Synchronize", "Exception: " + Log.getStackTraceString(th));
            if (lVar != null) {
                lVar.a(0, "Synchronize failed");
            }
        }
    }
}
