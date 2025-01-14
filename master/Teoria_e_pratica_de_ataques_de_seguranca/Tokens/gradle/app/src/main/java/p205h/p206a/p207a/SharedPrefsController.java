package p205h.p206a.p207a;

import android.content.Context;
import android.os.Build;
import android.provider.Settings;
import android.text.TextUtils;
import android.util.Log;
import java.io.File;
import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import p070c.p084d.p105b.Gson;
import p070c.p084d.p105b.GsonBuilder;
import p070c.p084d.p105b.p111w.TypeToken;
import p070c.p114f.SecurePreferences;
import pt.card4b.backendbeacons.App;
import pt.card4b.backendbeacons.DataModels;

/* renamed from: h.a.a.v */
/* loaded from: classes.dex */
public class SharedPrefsController {

    /* renamed from: c0 */
    public static volatile SharedPrefsController f9418c0;

    /* renamed from: C */
    public SecurePreferences f9421C;

    /* renamed from: D */
    public boolean f9422D;

    /* renamed from: a */
    public String f9445a = "sp_backendbeacons";

    /* renamed from: b */
    public String f9447b = "savedUser";

    /* renamed from: c */
    public String f9449c = "appDataLastUpdateDate";

    /* renamed from: d */
    public String f9450d = "SP_KEY_APPDATA_SAVEDINDB_OPERATORS";

    /* renamed from: e */
    public String f9451e = "SP_KEY_APPDATA_SAVEDINDB_STOPS";

    /* renamed from: f */
    public String f9452f = "SP_KEY_APPDATA_SAVEDINDB_LINES";

    /* renamed from: g */
    public String f9453g = "SP_KEY_APPDATA_SAVEDINDB_ZONES";

    /* renamed from: h */
    public String f9454h = "SP_KEY_APPDATA_SAVEDINDB_LINEDIRECTIONS";

    /* renamed from: i */
    public String f9455i = "SP_KEY_APPDATA_SAVEDINDB_LINEVARIANTS";

    /* renamed from: j */
    public String f9456j = "SP_KEY_APPDATA_SAVEDINDB_BEACONINFORMATIONTYPES";

    /* renamed from: k */
    public String f9457k = "SP_KEY_APPDATA_SAVEDINDB_CONFIGURATIONS";

    /* renamed from: l */
    public String f9458l = "SP_KEY_APPDATA_SAVEDINDB_CUSTOMERPROFILES";

    /* renamed from: m */
    public String f9459m = "SP_KEY_APPDATA_SAVEDINDB_COUNTRIES";

    /* renamed from: n */
    public String f9460n = "SP_KEY_APPDATA_SAVEDINDB_LANGUAGES";

    /* renamed from: o */
    public String f9461o = "isInitialized";

    /* renamed from: p */
    public String f9462p = "registrationKey";

    /* renamed from: q */
    public String f9463q = "stageRequestList";

    /* renamed from: r */
    public String f9464r = "stageState";

    /* renamed from: s */
    public String f9465s = "tripCounter";

    /* renamed from: t */
    public String f9466t = "startOfflineLimit";

    /* renamed from: u */
    public String f9467u = "startOfflineLimitExtended";

    /* renamed from: v */
    public String f9468v = "startOfflineDenyReason";

    /* renamed from: w */
    public String f9469w = "eventList";

    /* renamed from: x */
    public String f9470x = "crash";

    /* renamed from: y */
    public String f9471y = "lastTripActivity";

    /* renamed from: z */
    public String f9472z = "ongoingStageRestoreCounter";

    /* renamed from: A */
    public String f9419A = "loginName";

    /* renamed from: B */
    public String f9420B = "token";

    /* renamed from: E */
    public Object f9423E = new Object();

    /* renamed from: F */
    public Object f9424F = new Object();

    /* renamed from: G */
    public Object f9425G = new Object();

    /* renamed from: H */
    public Object f9426H = new Object();

    /* renamed from: I */
    public Object f9427I = new Object();

    /* renamed from: J */
    public Object f9428J = new Object();

    /* renamed from: K */
    public Object f9429K = new Object();

    /* renamed from: L */
    public Object f9430L = new Object();

    /* renamed from: M */
    public Object f9431M = new Object();

    /* renamed from: N */
    public Object f9432N = new Object();

    /* renamed from: O */
    public Object f9433O = new Object();

    /* renamed from: P */
    public Object f9434P = new Object();

    /* renamed from: Q */
    public Object f9435Q = new Object();

    /* renamed from: R */
    public Object f9436R = new Object();

    /* renamed from: S */
    public Object f9437S = new Object();

    /* renamed from: T */
    public Object f9438T = new Object();

    /* renamed from: U */
    public Object f9439U = new Object();

    /* renamed from: V */
    public Object f9440V = new Object();

    /* renamed from: W */
    public Object f9441W = new Object();

    /* renamed from: X */
    public Object f9442X = new Object();

    /* renamed from: Y */
    public Object f9443Y = new Object();

    /* renamed from: Z */
    public Object f9444Z = new Object();

    /* renamed from: a0 */
    public Object f9446a0 = new Object();

    /* renamed from: b0 */
    public Object f9448b0 = new Object();

    /* compiled from: SharedPrefsController.java */
    /* renamed from: h.a.a.v$a */
    /* loaded from: classes.dex */
    public class C2224a extends TypeToken<ArrayList<DataModels.C2699h>> {
        public C2224a(SharedPrefsController sharedPrefsController) {
        }
    }

    /* compiled from: SharedPrefsController.java */
    /* renamed from: h.a.a.v$a0 */
    /* loaded from: classes.dex */
    public class C2225a0 extends TypeToken<HashMap<String, String>> {
        public C2225a0(SharedPrefsController sharedPrefsController) {
        }
    }

    /* compiled from: SharedPrefsController.java */
    /* renamed from: h.a.a.v$b */
    /* loaded from: classes.dex */
    public class C2226b extends TypeToken<Map<String, DataModels.C2707p>> {
        public C2226b(SharedPrefsController sharedPrefsController) {
        }
    }

    /* compiled from: SharedPrefsController.java */
    /* renamed from: h.a.a.v$b0 */
    /* loaded from: classes.dex */
    public class C2227b0 extends TypeToken<HashMap<String, String>> {
        public C2227b0(SharedPrefsController sharedPrefsController) {
        }
    }

    /* compiled from: SharedPrefsController.java */
    /* renamed from: h.a.a.v$c */
    /* loaded from: classes.dex */
    public class C2228c extends TypeToken<ArrayList<DataModels.C2699h>> {
        public C2228c(SharedPrefsController sharedPrefsController) {
        }
    }

    /* compiled from: SharedPrefsController.java */
    /* renamed from: h.a.a.v$c0 */
    /* loaded from: classes.dex */
    public class C2229c0 extends TypeToken<HashMap<String, String>> {
        public C2229c0(SharedPrefsController sharedPrefsController) {
        }
    }

    /* compiled from: SharedPrefsController.java */
    /* renamed from: h.a.a.v$d */
    /* loaded from: classes.dex */
    public class C2230d extends TypeToken<Map<String, DataModels.C2707p>> {
        public C2230d(SharedPrefsController sharedPrefsController) {
        }
    }

    /* compiled from: SharedPrefsController.java */
    /* renamed from: h.a.a.v$d0 */
    /* loaded from: classes.dex */
    public class C2231d0 extends TypeToken<HashMap<String, String>> {
        public C2231d0(SharedPrefsController sharedPrefsController) {
        }
    }

    /* compiled from: SharedPrefsController.java */
    /* renamed from: h.a.a.v$e */
    /* loaded from: classes.dex */
    public class C2232e extends TypeToken<ArrayList<DataModels.C2699h>> {
        public C2232e(SharedPrefsController sharedPrefsController) {
        }
    }

    /* compiled from: SharedPrefsController.java */
    /* renamed from: h.a.a.v$e0 */
    /* loaded from: classes.dex */
    public class C2233e0 extends TypeToken<HashMap<String, String>> {
        public C2233e0(SharedPrefsController sharedPrefsController) {
        }
    }

    /* compiled from: SharedPrefsController.java */
    /* renamed from: h.a.a.v$f */
    /* loaded from: classes.dex */
    public class C2234f extends TypeToken<Map<String, DataModels.C2707p>> {
        public C2234f(SharedPrefsController sharedPrefsController) {
        }
    }

    /* compiled from: SharedPrefsController.java */
    /* renamed from: h.a.a.v$f0 */
    /* loaded from: classes.dex */
    public class C2235f0 extends TypeToken<HashMap<String, String>> {
        public C2235f0(SharedPrefsController sharedPrefsController) {
        }
    }

    /* compiled from: SharedPrefsController.java */
    /* renamed from: h.a.a.v$g */
    /* loaded from: classes.dex */
    public class C2236g extends TypeToken<ArrayList<DataModels.C2699h>> {
        public C2236g(SharedPrefsController sharedPrefsController) {
        }
    }

    /* compiled from: SharedPrefsController.java */
    /* renamed from: h.a.a.v$g0 */
    /* loaded from: classes.dex */
    public class C2237g0 extends TypeToken<HashMap<String, String>> {
        public C2237g0(SharedPrefsController sharedPrefsController) {
        }
    }

    /* compiled from: SharedPrefsController.java */
    /* renamed from: h.a.a.v$h */
    /* loaded from: classes.dex */
    public class C2238h extends TypeToken<Map<String, DataModels.C2707p>> {
        public C2238h(SharedPrefsController sharedPrefsController) {
        }
    }

    /* compiled from: SharedPrefsController.java */
    /* renamed from: h.a.a.v$h0 */
    /* loaded from: classes.dex */
    public class C2239h0 extends TypeToken<ArrayList<DataModels.C2706o>> {
        public C2239h0(SharedPrefsController sharedPrefsController) {
        }
    }

    /* compiled from: SharedPrefsController.java */
    /* renamed from: h.a.a.v$i */
    /* loaded from: classes.dex */
    public class C2240i extends TypeToken<ArrayList<DataModels.C2699h>> {
        public C2240i(SharedPrefsController sharedPrefsController) {
        }
    }

    /* compiled from: SharedPrefsController.java */
    /* renamed from: h.a.a.v$i0 */
    /* loaded from: classes.dex */
    public class C2241i0 extends TypeToken<HashMap<String, String>> {
        public C2241i0(SharedPrefsController sharedPrefsController) {
        }
    }

    /* compiled from: SharedPrefsController.java */
    /* renamed from: h.a.a.v$j */
    /* loaded from: classes.dex */
    public class C2242j extends TypeToken<Map<String, DataModels.C2707p>> {
        public C2242j(SharedPrefsController sharedPrefsController) {
        }
    }

    /* compiled from: SharedPrefsController.java */
    /* renamed from: h.a.a.v$j0 */
    /* loaded from: classes.dex */
    public class C2243j0 extends TypeToken<ArrayList<DataModels.C2699h>> {
        public C2243j0(SharedPrefsController sharedPrefsController) {
        }
    }

    /* compiled from: SharedPrefsController.java */
    /* renamed from: h.a.a.v$k */
    /* loaded from: classes.dex */
    public class C2244k extends TypeToken<ArrayList<DataModels.C2706o>> {
        public C2244k(SharedPrefsController sharedPrefsController) {
        }
    }

    /* compiled from: SharedPrefsController.java */
    /* renamed from: h.a.a.v$k0 */
    /* loaded from: classes.dex */
    public class C2245k0 extends TypeToken<ArrayList<DataModels.C2699h>> {
        public C2245k0(SharedPrefsController sharedPrefsController) {
        }
    }

    /* compiled from: SharedPrefsController.java */
    /* renamed from: h.a.a.v$l */
    /* loaded from: classes.dex */
    public class C2246l extends TypeToken<HashMap<String, Integer>> {
        public C2246l(SharedPrefsController sharedPrefsController) {
        }
    }

    /* compiled from: SharedPrefsController.java */
    /* renamed from: h.a.a.v$l0 */
    /* loaded from: classes.dex */
    public class C2247l0 extends TypeToken<ArrayList<DataModels.C2699h>> {
        public C2247l0(SharedPrefsController sharedPrefsController) {
        }
    }

    /* compiled from: SharedPrefsController.java */
    /* renamed from: h.a.a.v$m */
    /* loaded from: classes.dex */
    public class C2248m extends TypeToken<ArrayList<DataModels.C2706o>> {
        public C2248m(SharedPrefsController sharedPrefsController) {
        }
    }

    /* compiled from: SharedPrefsController.java */
    /* renamed from: h.a.a.v$n */
    /* loaded from: classes.dex */
    public class C2249n extends TypeToken<HashMap<String, Integer>> {
        public C2249n(SharedPrefsController sharedPrefsController) {
        }
    }

    /* compiled from: SharedPrefsController.java */
    /* renamed from: h.a.a.v$o */
    /* loaded from: classes.dex */
    public class C2250o extends TypeToken<ArrayList<DataModels.C2706o>> {
        public C2250o(SharedPrefsController sharedPrefsController) {
        }
    }

    /* compiled from: SharedPrefsController.java */
    /* renamed from: h.a.a.v$p */
    /* loaded from: classes.dex */
    public class C2251p extends TypeToken<HashMap<String, Integer>> {
        public C2251p(SharedPrefsController sharedPrefsController) {
        }
    }

    /* compiled from: SharedPrefsController.java */
    /* renamed from: h.a.a.v$q */
    /* loaded from: classes.dex */
    public class C2252q extends TypeToken<ArrayList<DataModels.C2706o>> {
        public C2252q(SharedPrefsController sharedPrefsController) {
        }
    }

    /* compiled from: SharedPrefsController.java */
    /* renamed from: h.a.a.v$r */
    /* loaded from: classes.dex */
    public class C2253r extends TypeToken<HashMap<String, Integer>> {
        public C2253r(SharedPrefsController sharedPrefsController) {
        }
    }

    /* compiled from: SharedPrefsController.java */
    /* renamed from: h.a.a.v$s */
    /* loaded from: classes.dex */
    public class C2254s extends TypeToken<ArrayList<DataModels.C2706o>> {
        public C2254s(SharedPrefsController sharedPrefsController) {
        }
    }

    /* compiled from: SharedPrefsController.java */
    /* renamed from: h.a.a.v$t */
    /* loaded from: classes.dex */
    public class C2255t extends TypeToken<HashMap<String, String>> {
        public C2255t(SharedPrefsController sharedPrefsController) {
        }
    }

    /* compiled from: SharedPrefsController.java */
    /* renamed from: h.a.a.v$u */
    /* loaded from: classes.dex */
    public class C2256u extends TypeToken<ArrayList<DataModels.C2706o>> {
        public C2256u(SharedPrefsController sharedPrefsController) {
        }
    }

    /* compiled from: SharedPrefsController.java */
    /* renamed from: h.a.a.v$v */
    /* loaded from: classes.dex */
    public class C2257v extends TypeToken<ArrayList<DataModels.C2706o>> {
        public C2257v(SharedPrefsController sharedPrefsController) {
        }
    }

    /* compiled from: SharedPrefsController.java */
    /* renamed from: h.a.a.v$w */
    /* loaded from: classes.dex */
    public class C2258w extends TypeToken<Map<String, DataModels.C2707p>> {
        public C2258w(SharedPrefsController sharedPrefsController) {
        }
    }

    /* compiled from: SharedPrefsController.java */
    /* renamed from: h.a.a.v$x */
    /* loaded from: classes.dex */
    public class C2259x extends TypeToken<HashMap<String, String>> {
        public C2259x(SharedPrefsController sharedPrefsController) {
        }
    }

    /* compiled from: SharedPrefsController.java */
    /* renamed from: h.a.a.v$y */
    /* loaded from: classes.dex */
    public class C2260y extends TypeToken<HashMap<String, String>> {
        public C2260y(SharedPrefsController sharedPrefsController) {
        }
    }

    /* compiled from: SharedPrefsController.java */
    /* renamed from: h.a.a.v$z */
    /* loaded from: classes.dex */
    public class C2261z extends TypeToken<HashMap<String, String>> {
        public C2261z(SharedPrefsController sharedPrefsController) {
        }
    }

    public SharedPrefsController() {
        this.f9422D = false;
        this.f9422D = false;
        File file = new File(App.getInstance().getApplicationInfo().dataDir + "/shared_prefs/" + this.f9445a + ".xml");
        String personalEncryptionPass = App.getPersonalEncryptionPass();
        if (file.exists()) {
            this.f9422D = m1554a(personalEncryptionPass, Settings.Secure.getString(App.getInstance().getContentResolver(), "android_id"));
            AppLog.m2158a("COMM_SP", "SharedPrefsController", "init", "result:" + this.f9422D + " (a)");
            if (!this.f9422D && !GeneralUtils.m1589e().isEmpty()) {
                String m1589e = GeneralUtils.m1589e();
                this.f9422D = m1554a(personalEncryptionPass, m1589e);
                AppLog.m2158a("COMM_SP", "SharedPrefsController", "init", "result:" + this.f9422D + " (sn:" + m1589e + ")");
            }
            if (this.f9422D) {
                return;
            }
            String m1558a = m1558a(App.getContext());
            this.f9422D = m1554a(personalEncryptionPass, m1558a);
            AppLog.m2158a("COMM_SP", "SharedPrefsController", "init", "result:" + this.f9422D + " (old:" + m1558a + ")");
            return;
        }
        this.f9422D = m1554a(personalEncryptionPass, Settings.Secure.getString(App.getInstance().getContentResolver(), "android_id"));
        AppLog.m2158a("COMM_SP", "SharedPrefsController", "init", "result:" + this.f9422D + " (new)");
    }

    /* renamed from: a */
    private boolean m1554a(String str, String str2) {
        try {
            this.f9421C = new SecurePreferences(App.getInstance(), str, str2, this.f9445a, 10000);
            AppLog.m2158a("COMM_SP", "SharedPrefsController", "init", "getAll: " + this.f9421C.getAll().size() + " items");
            if (this.f9421C.getAll().size() == 0) {
                SecurePreferences.SharedPreferences$EditorC1361b edit = this.f9421C.edit();
                edit.putBoolean(this.f9461o, true);
                edit.apply();
            } else if (!this.f9421C.getBoolean(this.f9461o, false)) {
                return false;
            }
            return true;
        } catch (Throwable th) {
            AppLog.m2158a("COMM_SP", "SharedPrefsController", "init exception", Log.getStackTraceString(th));
            return false;
        }
    }

    /* renamed from: c */
    private Gson m1543c() {
        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.m4916a("yyyy-MM-dd HH:mm:ss");
        return gsonBuilder.m4917a();
    }

    /* renamed from: d */
    public static SharedPrefsController m1540d() {
        if (f9418c0 == null) {
            synchronized (SharedPrefsController.class) {
                if (f9418c0 == null) {
                    f9418c0 = new SharedPrefsController();
                }
            }
        }
        return f9418c0;
    }

    /* renamed from: A */
    public void m1564A() {
        synchronized (this.f9437S) {
            Gson m1543c = m1543c();
            if (!this.f9421C.contains(this.f9463q)) {
                SecurePreferences.SharedPreferences$EditorC1361b edit = this.f9421C.edit();
                edit.putString(this.f9463q, m1543c.m4931a(new ArrayList(), new C2248m(this).getType()));
                edit.apply();
            }
            List list = (List) m1543c.m4927a(this.f9421C.getString(this.f9463q, "[]"), new C2250o(this).getType());
            if (list == null) {
                return;
            }
            list.remove(list.size() - 1);
            SecurePreferences.SharedPreferences$EditorC1361b edit2 = this.f9421C.edit();
            edit2.putString(this.f9463q, m1543c.m4931a(list, new C2252q(this).getType()));
            edit2.apply();
        }
    }

    /* renamed from: B */
    public void m1563B() {
        synchronized (this.f9424F) {
            SecurePreferences.SharedPreferences$EditorC1361b edit = this.f9421C.edit();
            edit.remove(this.f9449c);
            edit.apply();
        }
    }

    /* renamed from: C */
    public void m1562C() {
        synchronized (this.f9423E) {
            SecurePreferences.SharedPreferences$EditorC1361b edit = this.f9421C.edit();
            edit.remove(this.f9447b);
            edit.apply();
        }
    }

    /* renamed from: D */
    public void m1561D() {
        synchronized (this.f9448b0) {
            SecurePreferences.SharedPreferences$EditorC1361b edit = this.f9421C.edit();
            edit.remove(this.f9420B);
            edit.apply();
        }
    }

    /* renamed from: E */
    public void m1560E() {
        synchronized (this.f9444Z) {
            SecurePreferences.SharedPreferences$EditorC1361b edit = this.f9421C.edit();
            edit.putInt(this.f9472z, 0);
            edit.apply();
        }
    }

    /* renamed from: b */
    public void m1544b(boolean z) {
        synchronized (this.f9432N) {
            SecurePreferences.SharedPreferences$EditorC1361b edit = this.f9421C.edit();
            edit.putBoolean(this.f9456j, z);
            edit.apply();
        }
    }

    /* renamed from: e */
    public void m1535e(boolean z) {
        synchronized (this.f9434P) {
            SecurePreferences.SharedPreferences$EditorC1361b edit = this.f9421C.edit();
            edit.putBoolean(this.f9458l, z);
            edit.apply();
        }
    }

    /* renamed from: f */
    public void m1532f(boolean z) {
        synchronized (this.f9436R) {
            SecurePreferences.SharedPreferences$EditorC1361b edit = this.f9421C.edit();
            edit.putBoolean(this.f9460n, z);
            edit.apply();
        }
    }

    /* renamed from: g */
    public void m1529g(boolean z) {
        synchronized (this.f9430L) {
            SecurePreferences.SharedPreferences$EditorC1361b edit = this.f9421C.edit();
            edit.putBoolean(this.f9454h, z);
            edit.apply();
        }
    }

    /* renamed from: h */
    public String m1528h() {
        String string;
        synchronized (this.f9425G) {
            string = this.f9421C.getString(this.f9462p, null);
        }
        return string;
    }

    /* renamed from: i */
    public void m1524i(String str) {
        synchronized (this.f9425G) {
            SecurePreferences.SharedPreferences$EditorC1361b edit = this.f9421C.edit();
            edit.putString(this.f9462p, str);
            edit.apply();
        }
    }

    /* renamed from: j */
    public void m1520j(boolean z) {
        synchronized (this.f9426H) {
            SecurePreferences.SharedPreferences$EditorC1361b edit = this.f9421C.edit();
            edit.putBoolean(this.f9450d, z);
            edit.apply();
        }
    }

    /* renamed from: k */
    public DataModels.User m1519k() {
        synchronized (this.f9423E) {
            Gson m1543c = m1543c();
            String string = this.f9421C.getString(this.f9447b, null);
            if (string == null) {
                return null;
            }
            return (DataModels.User) m1543c.m4928a(string, (Class<Object>) DataModels.User.class);
        }
    }

    /* renamed from: l */
    public void m1516l(boolean z) {
        synchronized (this.f9429K) {
            SecurePreferences.SharedPreferences$EditorC1361b edit = this.f9421C.edit();
            edit.putBoolean(this.f9453g, z);
            edit.apply();
        }
    }

    /* renamed from: m */
    public void m1515m() {
        synchronized (this.f9444Z) {
            int m1531g = m1531g();
            SecurePreferences.SharedPreferences$EditorC1361b edit = this.f9421C.edit();
            edit.putInt(this.f9472z, m1531g + 1);
            edit.apply();
        }
    }

    /* renamed from: n */
    public boolean m1514n() {
        boolean z;
        synchronized (this.f9432N) {
            z = this.f9421C.getBoolean(this.f9456j, false);
        }
        return z;
    }

    /* renamed from: o */
    public boolean m1513o() {
        boolean z;
        synchronized (this.f9433O) {
            z = this.f9421C.getBoolean(this.f9457k, false);
        }
        return z;
    }

    /* renamed from: p */
    public boolean m1512p() {
        boolean z;
        synchronized (this.f9435Q) {
            z = this.f9421C.getBoolean(this.f9459m, false);
        }
        return z;
    }

    /* renamed from: q */
    public boolean m1511q() {
        boolean z;
        synchronized (this.f9434P) {
            z = this.f9421C.getBoolean(this.f9458l, false);
        }
        return z;
    }

    /* renamed from: r */
    public boolean m1510r() {
        boolean z;
        synchronized (this.f9436R) {
            z = this.f9421C.getBoolean(this.f9460n, false);
        }
        return z;
    }

    /* renamed from: s */
    public boolean m1509s() {
        boolean z;
        synchronized (this.f9430L) {
            z = this.f9421C.getBoolean(this.f9454h, false);
        }
        return z;
    }

    /* renamed from: t */
    public boolean m1508t() {
        boolean z;
        synchronized (this.f9431M) {
            z = this.f9421C.getBoolean(this.f9455i, false);
        }
        return z;
    }

    /* renamed from: u */
    public boolean m1507u() {
        boolean z;
        synchronized (this.f9428J) {
            z = this.f9421C.getBoolean(this.f9452f, false);
        }
        return z;
    }

    /* renamed from: v */
    public boolean m1506v() {
        boolean z;
        synchronized (this.f9426H) {
            z = this.f9421C.getBoolean(this.f9450d, false);
        }
        return z;
    }

    /* renamed from: w */
    public boolean m1505w() {
        boolean z;
        synchronized (this.f9427I) {
            z = this.f9421C.getBoolean(this.f9451e, false);
        }
        return z;
    }

    /* renamed from: x */
    public boolean m1504x() {
        boolean z;
        synchronized (this.f9429K) {
            z = this.f9421C.getBoolean(this.f9453g, false);
        }
        return z;
    }

    /* renamed from: y */
    public boolean m1503y() {
        return this.f9422D;
    }

    /* renamed from: z */
    public void m1502z() {
        synchronized (this.f9441W) {
            Gson m1543c = m1543c();
            if (!this.f9421C.contains(this.f9469w)) {
                SecurePreferences.SharedPreferences$EditorC1361b edit = this.f9421C.edit();
                edit.putString(this.f9469w, m1543c.m4931a(new ArrayList(), new C2224a(this).getType()));
                edit.apply();
            }
            List list = (List) m1543c.m4927a(this.f9421C.getString(this.f9469w, "[]"), new C2228c(this).getType());
            if (list == null) {
                return;
            }
            list.remove(list.size() - 1);
            SecurePreferences.SharedPreferences$EditorC1361b edit2 = this.f9421C.edit();
            edit2.putString(this.f9469w, m1543c.m4931a(list, new C2232e(this).getType()));
            edit2.apply();
        }
    }

    /* renamed from: c */
    public void m1541c(boolean z) {
        synchronized (this.f9433O) {
            SecurePreferences.SharedPreferences$EditorC1361b edit = this.f9421C.edit();
            edit.putBoolean(this.f9457k, z);
            edit.apply();
        }
    }

    /* renamed from: b */
    public AbstractMap.SimpleEntry<Date, String> m1545b(String str) {
        HashMap hashMap;
        HashMap hashMap2;
        AbstractMap.SimpleEntry<Date, String> simpleEntry;
        HashMap hashMap3;
        synchronized (this.f9440V) {
            Gson m1543c = m1543c();
            if (this.f9421C.contains(this.f9467u)) {
                hashMap = (HashMap) m1543c.m4927a(this.f9421C.getString(this.f9467u, null), new C2255t(this).getType());
            } else {
                hashMap = new HashMap();
            }
            if (hashMap.containsKey(str) && hashMap.get(str) != null) {
                simpleEntry = new AbstractMap.SimpleEntry<>(GeneralUtils.m1594b((String) hashMap.get(str)), "");
            } else {
                if (this.f9421C.contains(this.f9466t)) {
                    hashMap2 = (HashMap) m1543c.m4927a(this.f9421C.getString(this.f9466t, null), new C2259x(this).getType());
                } else {
                    hashMap2 = new HashMap();
                }
                simpleEntry = (!hashMap2.containsKey(str) || hashMap2.get(str) == null) ? null : new AbstractMap.SimpleEntry<>(GeneralUtils.m1594b((String) hashMap2.get(str)), "");
            }
            if (this.f9421C.contains(this.f9468v)) {
                hashMap3 = (HashMap) m1543c.m4927a(this.f9421C.getString(this.f9468v, null), new C2260y(this).getType());
            } else {
                hashMap3 = new HashMap();
            }
            if (hashMap3.containsKey(str) && hashMap3.get(str) != null) {
                if (simpleEntry == null) {
                    simpleEntry = new AbstractMap.SimpleEntry<>(new Date(0L), "");
                }
                simpleEntry.setValue(((String) hashMap3.get(str)).trim());
            }
        }
        return simpleEntry;
    }

    /* renamed from: e */
    public void m1536e(String str) {
        HashMap hashMap;
        synchronized (this.f9439U) {
            Gson m1543c = m1543c();
            if (this.f9421C.contains(this.f9465s)) {
                hashMap = (HashMap) m1543c.m4927a(this.f9421C.getString(this.f9465s, null), new C2251p(this).getType());
            } else {
                hashMap = new HashMap();
            }
            if (hashMap.containsKey(str)) {
                int intValue = ((Integer) hashMap.get(str)).intValue();
                hashMap.put(str, Integer.valueOf(intValue < Integer.MAX_VALUE ? 1 + intValue : 1));
            }
            SecurePreferences.SharedPreferences$EditorC1361b edit = this.f9421C.edit();
            edit.putString(this.f9465s, m1543c.m4931a(hashMap, new C2253r(this).getType()));
            edit.apply();
        }
    }

    /* renamed from: f */
    public boolean m1533f(String str) {
        synchronized (this.f9438T) {
            if (str.isEmpty()) {
                return false;
            }
            if (this.f9421C.contains(this.f9464r)) {
                Gson m1543c = m1543c();
                String string = this.f9421C.getString(this.f9464r, null);
                Map map = string != null ? (Map) m1543c.m4927a(string, new C2238h(this).getType()) : null;
                if (map != null) {
                    map.remove(str);
                    if (map.isEmpty()) {
                        SecurePreferences.SharedPreferences$EditorC1361b edit = this.f9421C.edit();
                        edit.remove(this.f9464r);
                        edit.apply();
                    } else {
                        SecurePreferences.SharedPreferences$EditorC1361b edit2 = this.f9421C.edit();
                        edit2.putString(this.f9464r, m1543c.m4931a(map, new C2242j(this).getType()));
                        edit2.apply();
                    }
                }
                return true;
            }
            return true;
        }
    }

    /* renamed from: g */
    public void m1530g(String str) {
        synchronized (this.f9440V) {
            Gson m1543c = m1543c();
            if (this.f9421C.contains(this.f9467u)) {
                HashMap hashMap = (HashMap) m1543c.m4927a(this.f9421C.getString(this.f9467u, null), new C2237g0(this).getType());
                hashMap.remove(str);
                SecurePreferences.SharedPreferences$EditorC1361b edit = this.f9421C.edit();
                edit.putString(this.f9467u, m1543c.m4931a(hashMap, new C2241i0(this).getType()));
                edit.apply();
            }
        }
    }

    /* renamed from: h */
    public void m1526h(boolean z) {
        synchronized (this.f9431M) {
            SecurePreferences.SharedPreferences$EditorC1361b edit = this.f9421C.edit();
            edit.putBoolean(this.f9455i, z);
            edit.apply();
        }
    }

    /* renamed from: i */
    public void m1523i(boolean z) {
        synchronized (this.f9428J) {
            SecurePreferences.SharedPreferences$EditorC1361b edit = this.f9421C.edit();
            edit.putBoolean(this.f9452f, z);
            edit.apply();
        }
    }

    /* renamed from: j */
    public String m1522j() {
        String string;
        synchronized (this.f9448b0) {
            string = this.f9421C.getString(this.f9420B, null);
        }
        return string;
    }

    /* renamed from: l */
    public boolean m1517l() {
        boolean z;
        synchronized (this.f9442X) {
            z = this.f9421C.getBoolean(this.f9470x, false);
        }
        return z;
    }

    /* renamed from: c */
    public int m1542c(String str) {
        HashMap hashMap;
        synchronized (this.f9439U) {
            Gson m1543c = m1543c();
            if (this.f9421C.contains(this.f9465s)) {
                hashMap = (HashMap) m1543c.m4927a(this.f9421C.getString(this.f9465s, null), new C2246l(this).getType());
            } else {
                hashMap = new HashMap();
            }
            if (hashMap.containsKey(str)) {
                return ((Integer) hashMap.get(str)).intValue();
            }
            hashMap.put(str, 1);
            SecurePreferences.SharedPreferences$EditorC1361b edit = this.f9421C.edit();
            edit.putString(this.f9465s, m1543c.m4931a(hashMap, new C2249n(this).getType()));
            edit.apply();
            return ((Integer) hashMap.get(str)).intValue();
        }
    }

    /* renamed from: a */
    public void m1550a(DataModels.User user) {
        synchronized (this.f9423E) {
            String m4933a = m1543c().m4933a(user);
            SecurePreferences.SharedPreferences$EditorC1361b edit = this.f9421C.edit();
            edit.putString(this.f9447b, m4933a);
            edit.apply();
        }
    }

    /* renamed from: d */
    public void m1538d(boolean z) {
        synchronized (this.f9435Q) {
            SecurePreferences.SharedPreferences$EditorC1361b edit = this.f9421C.edit();
            edit.putBoolean(this.f9459m, z);
            edit.apply();
        }
    }

    /* renamed from: h */
    public void m1527h(String str) {
        synchronized (this.f9446a0) {
            SecurePreferences.SharedPreferences$EditorC1361b edit = this.f9421C.edit();
            edit.putString(this.f9419A, str);
            edit.apply();
        }
    }

    /* renamed from: i */
    public DataModels.C2706o m1525i() {
        synchronized (this.f9437S) {
            Gson m1543c = m1543c();
            if (!this.f9421C.contains(this.f9463q)) {
                SecurePreferences.SharedPreferences$EditorC1361b edit = this.f9421C.edit();
                edit.putString(this.f9463q, m1543c.m4931a(new ArrayList(), new C2254s(this).getType()));
                edit.apply();
            }
            List list = (List) m1543c.m4927a(this.f9421C.getString(this.f9463q, "[]"), new C2256u(this).getType());
            DataModels.C2706o c2706o = null;
            if (list == null) {
                return null;
            }
            if (list.size() != 0) {
                c2706o = (DataModels.C2706o) list.get(list.size() - 1);
            }
            return c2706o;
        }
    }

    /* renamed from: j */
    public void m1521j(String str) {
        synchronized (this.f9448b0) {
            SecurePreferences.SharedPreferences$EditorC1361b edit = this.f9421C.edit();
            edit.putString(this.f9420B, str);
            edit.apply();
        }
    }

    /* renamed from: k */
    public void m1518k(boolean z) {
        synchronized (this.f9427I) {
            SecurePreferences.SharedPreferences$EditorC1361b edit = this.f9421C.edit();
            edit.putBoolean(this.f9451e, z);
            edit.apply();
        }
    }

    /* renamed from: d */
    public boolean m1539d(String str) {
        synchronized (this.f9438T) {
            boolean z = false;
            if (str.isEmpty()) {
                return false;
            }
            if (this.f9421C.contains(this.f9464r)) {
                String string = this.f9421C.getString(this.f9464r, null);
                if (string == null) {
                    return false;
                }
                Map map = (Map) m1543c().m4927a(string, new C2258w(this).getType());
                if (map != null && map.containsKey(str)) {
                    z = true;
                }
                return z;
            }
            return false;
        }
    }

    /* renamed from: a */
    public Date m1559a() {
        Date m1594b;
        synchronized (this.f9424F) {
            String string = this.f9421C.getString(this.f9449c, null);
            m1594b = string != null ? GeneralUtils.m1594b(string) : null;
        }
        return m1594b;
    }

    /* renamed from: g */
    public int m1531g() {
        int i;
        synchronized (this.f9444Z) {
            i = this.f9421C.getInt(this.f9472z, 0);
        }
        return i;
    }

    /* renamed from: a */
    public void m1551a(Date date) {
        synchronized (this.f9424F) {
            String m1593b = GeneralUtils.m1593b(date);
            SecurePreferences.SharedPreferences$EditorC1361b edit = this.f9421C.edit();
            edit.putString(this.f9449c, m1593b);
            edit.apply();
        }
    }

    /* renamed from: e */
    public Long m1537e() {
        Long valueOf;
        synchronized (this.f9443Y) {
            valueOf = Long.valueOf(this.f9421C.getLong(this.f9471y, 0L));
        }
        return valueOf;
    }

    /* renamed from: a */
    public void m1548a(DataModels.C2706o c2706o) {
        synchronized (this.f9437S) {
            Gson m1543c = m1543c();
            if (!this.f9421C.contains(this.f9463q)) {
                SecurePreferences.SharedPreferences$EditorC1361b edit = this.f9421C.edit();
                edit.putString(this.f9463q, m1543c.m4931a(new ArrayList(), new C2257v(this).getType()));
                edit.apply();
            }
            List list = (List) m1543c.m4927a(this.f9421C.getString(this.f9463q, "[]"), new C2239h0(this).getType());
            if (list == null) {
                return;
            }
            list.add(0, c2706o);
            SecurePreferences.SharedPreferences$EditorC1361b edit2 = this.f9421C.edit();
            edit2.putString(this.f9463q, m1543c.m4931a(list, new C2244k(this).getType()));
            edit2.apply();
        }
    }

    /* renamed from: f */
    public String m1534f() {
        String string;
        synchronized (this.f9446a0) {
            string = this.f9421C.getString(this.f9419A, null);
        }
        return string;
    }

    /* renamed from: b */
    public DataModels.C2699h m1546b() {
        synchronized (this.f9441W) {
            Gson m1543c = m1543c();
            if (!this.f9421C.contains(this.f9469w)) {
                SecurePreferences.SharedPreferences$EditorC1361b edit = this.f9421C.edit();
                edit.putString(this.f9469w, m1543c.m4931a(new ArrayList(), new C2236g(this).getType()));
                edit.apply();
            }
            List list = (List) m1543c.m4927a(this.f9421C.getString(this.f9469w, "[]"), new C2240i(this).getType());
            DataModels.C2699h c2699h = null;
            if (list == null) {
                return null;
            }
            if (list.size() != 0) {
                c2699h = (DataModels.C2699h) list.get(list.size() - 1);
            }
            return c2699h;
        }
    }

    /* renamed from: a */
    public DataModels.C2707p m1556a(String str) {
        synchronized (this.f9438T) {
            if (str.isEmpty()) {
                return null;
            }
            if (this.f9421C.contains(this.f9464r)) {
                String string = this.f9421C.getString(this.f9464r, null);
                if (string == null) {
                    return null;
                }
                Map map = (Map) m1543c().m4927a(string, new C2226b(this).getType());
                if (map == null) {
                    return null;
                }
                return (DataModels.C2707p) map.get(str);
            }
            return null;
        }
    }

    /* renamed from: a */
    public boolean m1552a(String str, DataModels.C2707p c2707p) {
        boolean z = false;
        try {
        } catch (Throwable th) {
            AppLog.m2158a("COMM_SP", "SharedPrefsController", "saveStageState", "Failed to save stage stage: " + Log.getStackTraceString(th));
        }
        synchronized (this.f9438T) {
            if (str.isEmpty()) {
                return false;
            }
            Gson m1543c = m1543c();
            String string = this.f9421C.getString(this.f9464r, null);
            Map map = string != null ? (Map) m1543c.m4927a(string, new C2230d(this).getType()) : null;
            if (map == null) {
                map = new HashMap();
            }
            map.put(str, c2707p);
            SecurePreferences.SharedPreferences$EditorC1361b edit = this.f9421C.edit();
            edit.putString(this.f9464r, m1543c.m4931a(map, new C2234f(this).getType()));
            edit.apply();
            z = true;
            return z;
        }
    }

    /* renamed from: a */
    public void m1553a(String str, Date date, String str2) {
        HashMap hashMap;
        HashMap hashMap2;
        synchronized (this.f9440V) {
            Gson m1543c = m1543c();
            m1530g(str);
            if (this.f9421C.contains(this.f9466t)) {
                hashMap = (HashMap) m1543c.m4927a(this.f9421C.getString(this.f9466t, null), new C2261z(this).getType());
            } else {
                hashMap = new HashMap();
            }
            if (date == null) {
                date = new Date(0L);
            }
            hashMap.put(str, GeneralUtils.m1593b(date));
            if (this.f9421C.contains(this.f9468v)) {
                hashMap2 = (HashMap) m1543c.m4927a(this.f9421C.getString(this.f9468v, null), new C2225a0(this).getType());
            } else {
                hashMap2 = new HashMap();
            }
            hashMap2.put(str, str2 != null ? str2.trim() : "");
            SecurePreferences.SharedPreferences$EditorC1361b edit = this.f9421C.edit();
            edit.putString(this.f9466t, m1543c.m4931a(hashMap, new C2227b0(this).getType()));
            edit.putString(this.f9468v, m1543c.m4931a(hashMap2, new C2229c0(this).getType()));
            edit.apply();
        }
    }

    /* renamed from: a */
    public void m1555a(String str, int i) {
        HashMap hashMap;
        HashMap hashMap2;
        synchronized (this.f9440V) {
            Gson m1543c = m1543c();
            if (this.f9421C.contains(this.f9466t)) {
                hashMap = (HashMap) m1543c.m4927a(this.f9421C.getString(this.f9466t, null), new C2231d0(this).getType());
            } else {
                hashMap = new HashMap();
            }
            if (hashMap.containsKey(str)) {
                if (this.f9421C.contains(this.f9467u)) {
                    hashMap2 = (HashMap) m1543c.m4927a(this.f9421C.getString(this.f9467u, null), new C2233e0(this).getType());
                } else {
                    hashMap2 = new HashMap();
                }
                if (!hashMap2.containsKey(str)) {
                    hashMap2.put(str, GeneralUtils.m1593b(new Date(GeneralUtils.m1598a(GeneralUtils.m1594b((String) hashMap.get(str))) + (i * 60 * 1000))));
                    SecurePreferences.SharedPreferences$EditorC1361b edit = this.f9421C.edit();
                    edit.putString(this.f9467u, m1543c.m4931a(hashMap2, new C2235f0(this).getType()));
                    edit.apply();
                }
            }
        }
    }

    /* renamed from: a */
    public void m1549a(DataModels.C2699h c2699h) {
        synchronized (this.f9441W) {
            Gson m1543c = m1543c();
            if (!this.f9421C.contains(this.f9469w)) {
                SecurePreferences.SharedPreferences$EditorC1361b edit = this.f9421C.edit();
                edit.putString(this.f9469w, m1543c.m4931a(new ArrayList(), new C2243j0(this).getType()));
                edit.apply();
            }
            List list = (List) m1543c.m4927a(this.f9421C.getString(this.f9469w, "[]"), new C2245k0(this).getType());
            if (list == null) {
                return;
            }
            list.add(0, c2699h);
            SecurePreferences.SharedPreferences$EditorC1361b edit2 = this.f9421C.edit();
            edit2.putString(this.f9469w, m1543c.m4931a(list, new C2247l0(this).getType()));
            edit2.apply();
        }
    }

    /* renamed from: a */
    public void m1547a(boolean z) {
        synchronized (this.f9442X) {
            SecurePreferences.SharedPreferences$EditorC1361b edit = this.f9421C.edit();
            edit.putBoolean(this.f9470x, z);
            edit.apply();
        }
    }

    /* renamed from: a */
    public void m1557a(Long l) {
        synchronized (this.f9443Y) {
            SecurePreferences.SharedPreferences$EditorC1361b edit = this.f9421C.edit();
            edit.putLong(this.f9471y, l.longValue());
            edit.apply();
        }
    }

    /* renamed from: a */
    private String m1558a(Context context) {
        try {
            String str = (String) Build.class.getField("SERIAL").get(null);
            return TextUtils.isEmpty(str) ? Settings.Secure.getString(context.getContentResolver(), "android_id") : str;
        } catch (Exception unused) {
            return Settings.Secure.getString(context.getContentResolver(), "android_id");
        }
    }
}
