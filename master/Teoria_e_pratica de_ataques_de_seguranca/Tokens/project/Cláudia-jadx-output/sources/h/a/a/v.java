package h.a.a;

import android.content.Context;
import android.os.Build;
import android.provider.Settings;
import android.text.TextUtils;
import android.util.Log;
import c.f.a;
import java.io.File;
import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import pt.card4b.backendbeacons.App;
import pt.card4b.backendbeacons.DataModels;
/* compiled from: SharedPrefsController.java */
/* loaded from: classes.dex */
public class v {
    public static volatile v c0;
    public c.f.a C;
    public boolean D;

    /* renamed from: a  reason: collision with root package name */
    public String f6863a = "sp_backendbeacons";

    /* renamed from: b  reason: collision with root package name */
    public String f6864b = "savedUser";

    /* renamed from: c  reason: collision with root package name */
    public String f6865c = "appDataLastUpdateDate";

    /* renamed from: d  reason: collision with root package name */
    public String f6866d = "SP_KEY_APPDATA_SAVEDINDB_OPERATORS";

    /* renamed from: e  reason: collision with root package name */
    public String f6867e = "SP_KEY_APPDATA_SAVEDINDB_STOPS";

    /* renamed from: f  reason: collision with root package name */
    public String f6868f = "SP_KEY_APPDATA_SAVEDINDB_LINES";

    /* renamed from: g  reason: collision with root package name */
    public String f6869g = "SP_KEY_APPDATA_SAVEDINDB_ZONES";

    /* renamed from: h  reason: collision with root package name */
    public String f6870h = "SP_KEY_APPDATA_SAVEDINDB_LINEDIRECTIONS";

    /* renamed from: i  reason: collision with root package name */
    public String f6871i = "SP_KEY_APPDATA_SAVEDINDB_LINEVARIANTS";
    public String j = "SP_KEY_APPDATA_SAVEDINDB_BEACONINFORMATIONTYPES";
    public String k = "SP_KEY_APPDATA_SAVEDINDB_CONFIGURATIONS";
    public String l = "SP_KEY_APPDATA_SAVEDINDB_CUSTOMERPROFILES";
    public String m = "SP_KEY_APPDATA_SAVEDINDB_COUNTRIES";
    public String n = "SP_KEY_APPDATA_SAVEDINDB_LANGUAGES";
    public String o = "isInitialized";
    public String p = "registrationKey";
    public String q = "stageRequestList";
    public String r = "stageState";
    public String s = "tripCounter";
    public String t = "startOfflineLimit";
    public String u = "startOfflineLimitExtended";
    public String v = "startOfflineDenyReason";
    public String w = "eventList";
    public String x = "crash";
    public String y = "lastTripActivity";
    public String z = "ongoingStageRestoreCounter";
    public String A = "loginName";
    public String B = "token";
    public Object E = new Object();
    public Object F = new Object();
    public Object G = new Object();
    public Object H = new Object();
    public Object I = new Object();
    public Object J = new Object();
    public Object K = new Object();
    public Object L = new Object();
    public Object M = new Object();
    public Object N = new Object();
    public Object O = new Object();
    public Object P = new Object();
    public Object Q = new Object();
    public Object R = new Object();
    public Object S = new Object();
    public Object T = new Object();
    public Object U = new Object();
    public Object V = new Object();
    public Object W = new Object();
    public Object X = new Object();
    public Object Y = new Object();
    public Object Z = new Object();
    public Object a0 = new Object();
    public Object b0 = new Object();

    /* compiled from: SharedPrefsController.java */
    /* loaded from: classes.dex */
    public class a extends c.d.b.w.a<ArrayList<DataModels.h>> {
        public a(v vVar) {
        }
    }

    /* compiled from: SharedPrefsController.java */
    /* loaded from: classes.dex */
    public class a0 extends c.d.b.w.a<HashMap<String, String>> {
        public a0(v vVar) {
        }
    }

    /* compiled from: SharedPrefsController.java */
    /* loaded from: classes.dex */
    public class b extends c.d.b.w.a<Map<String, DataModels.p>> {
        public b(v vVar) {
        }
    }

    /* compiled from: SharedPrefsController.java */
    /* loaded from: classes.dex */
    public class b0 extends c.d.b.w.a<HashMap<String, String>> {
        public b0(v vVar) {
        }
    }

    /* compiled from: SharedPrefsController.java */
    /* loaded from: classes.dex */
    public class c extends c.d.b.w.a<ArrayList<DataModels.h>> {
        public c(v vVar) {
        }
    }

    /* compiled from: SharedPrefsController.java */
    /* loaded from: classes.dex */
    public class c0 extends c.d.b.w.a<HashMap<String, String>> {
        public c0(v vVar) {
        }
    }

    /* compiled from: SharedPrefsController.java */
    /* loaded from: classes.dex */
    public class d extends c.d.b.w.a<Map<String, DataModels.p>> {
        public d(v vVar) {
        }
    }

    /* compiled from: SharedPrefsController.java */
    /* loaded from: classes.dex */
    public class d0 extends c.d.b.w.a<HashMap<String, String>> {
        public d0(v vVar) {
        }
    }

    /* compiled from: SharedPrefsController.java */
    /* loaded from: classes.dex */
    public class e extends c.d.b.w.a<ArrayList<DataModels.h>> {
        public e(v vVar) {
        }
    }

    /* compiled from: SharedPrefsController.java */
    /* loaded from: classes.dex */
    public class e0 extends c.d.b.w.a<HashMap<String, String>> {
        public e0(v vVar) {
        }
    }

    /* compiled from: SharedPrefsController.java */
    /* loaded from: classes.dex */
    public class f extends c.d.b.w.a<Map<String, DataModels.p>> {
        public f(v vVar) {
        }
    }

    /* compiled from: SharedPrefsController.java */
    /* loaded from: classes.dex */
    public class f0 extends c.d.b.w.a<HashMap<String, String>> {
        public f0(v vVar) {
        }
    }

    /* compiled from: SharedPrefsController.java */
    /* loaded from: classes.dex */
    public class g extends c.d.b.w.a<ArrayList<DataModels.h>> {
        public g(v vVar) {
        }
    }

    /* compiled from: SharedPrefsController.java */
    /* loaded from: classes.dex */
    public class g0 extends c.d.b.w.a<HashMap<String, String>> {
        public g0(v vVar) {
        }
    }

    /* compiled from: SharedPrefsController.java */
    /* loaded from: classes.dex */
    public class h extends c.d.b.w.a<Map<String, DataModels.p>> {
        public h(v vVar) {
        }
    }

    /* compiled from: SharedPrefsController.java */
    /* loaded from: classes.dex */
    public class h0 extends c.d.b.w.a<ArrayList<DataModels.o>> {
        public h0(v vVar) {
        }
    }

    /* compiled from: SharedPrefsController.java */
    /* loaded from: classes.dex */
    public class i extends c.d.b.w.a<ArrayList<DataModels.h>> {
        public i(v vVar) {
        }
    }

    /* compiled from: SharedPrefsController.java */
    /* loaded from: classes.dex */
    public class i0 extends c.d.b.w.a<HashMap<String, String>> {
        public i0(v vVar) {
        }
    }

    /* compiled from: SharedPrefsController.java */
    /* loaded from: classes.dex */
    public class j extends c.d.b.w.a<Map<String, DataModels.p>> {
        public j(v vVar) {
        }
    }

    /* compiled from: SharedPrefsController.java */
    /* loaded from: classes.dex */
    public class j0 extends c.d.b.w.a<ArrayList<DataModels.h>> {
        public j0(v vVar) {
        }
    }

    /* compiled from: SharedPrefsController.java */
    /* loaded from: classes.dex */
    public class k extends c.d.b.w.a<ArrayList<DataModels.o>> {
        public k(v vVar) {
        }
    }

    /* compiled from: SharedPrefsController.java */
    /* loaded from: classes.dex */
    public class k0 extends c.d.b.w.a<ArrayList<DataModels.h>> {
        public k0(v vVar) {
        }
    }

    /* compiled from: SharedPrefsController.java */
    /* loaded from: classes.dex */
    public class l extends c.d.b.w.a<HashMap<String, Integer>> {
        public l(v vVar) {
        }
    }

    /* compiled from: SharedPrefsController.java */
    /* loaded from: classes.dex */
    public class l0 extends c.d.b.w.a<ArrayList<DataModels.h>> {
        public l0(v vVar) {
        }
    }

    /* compiled from: SharedPrefsController.java */
    /* loaded from: classes.dex */
    public class m extends c.d.b.w.a<ArrayList<DataModels.o>> {
        public m(v vVar) {
        }
    }

    /* compiled from: SharedPrefsController.java */
    /* loaded from: classes.dex */
    public class n extends c.d.b.w.a<HashMap<String, Integer>> {
        public n(v vVar) {
        }
    }

    /* compiled from: SharedPrefsController.java */
    /* loaded from: classes.dex */
    public class o extends c.d.b.w.a<ArrayList<DataModels.o>> {
        public o(v vVar) {
        }
    }

    /* compiled from: SharedPrefsController.java */
    /* loaded from: classes.dex */
    public class p extends c.d.b.w.a<HashMap<String, Integer>> {
        public p(v vVar) {
        }
    }

    /* compiled from: SharedPrefsController.java */
    /* loaded from: classes.dex */
    public class q extends c.d.b.w.a<ArrayList<DataModels.o>> {
        public q(v vVar) {
        }
    }

    /* compiled from: SharedPrefsController.java */
    /* loaded from: classes.dex */
    public class r extends c.d.b.w.a<HashMap<String, Integer>> {
        public r(v vVar) {
        }
    }

    /* compiled from: SharedPrefsController.java */
    /* loaded from: classes.dex */
    public class s extends c.d.b.w.a<ArrayList<DataModels.o>> {
        public s(v vVar) {
        }
    }

    /* compiled from: SharedPrefsController.java */
    /* loaded from: classes.dex */
    public class t extends c.d.b.w.a<HashMap<String, String>> {
        public t(v vVar) {
        }
    }

    /* compiled from: SharedPrefsController.java */
    /* loaded from: classes.dex */
    public class u extends c.d.b.w.a<ArrayList<DataModels.o>> {
        public u(v vVar) {
        }
    }

    /* compiled from: SharedPrefsController.java */
    /* renamed from: h.a.a.v$v  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0153v extends c.d.b.w.a<ArrayList<DataModels.o>> {
        public C0153v(v vVar) {
        }
    }

    /* compiled from: SharedPrefsController.java */
    /* loaded from: classes.dex */
    public class w extends c.d.b.w.a<Map<String, DataModels.p>> {
        public w(v vVar) {
        }
    }

    /* compiled from: SharedPrefsController.java */
    /* loaded from: classes.dex */
    public class x extends c.d.b.w.a<HashMap<String, String>> {
        public x(v vVar) {
        }
    }

    /* compiled from: SharedPrefsController.java */
    /* loaded from: classes.dex */
    public class y extends c.d.b.w.a<HashMap<String, String>> {
        public y(v vVar) {
        }
    }

    /* compiled from: SharedPrefsController.java */
    /* loaded from: classes.dex */
    public class z extends c.d.b.w.a<HashMap<String, String>> {
        public z(v vVar) {
        }
    }

    public v() {
        this.D = false;
        this.D = false;
        File file = new File(App.getInstance().getApplicationInfo().dataDir + "/shared_prefs/" + this.f6863a + ".xml");
        String personalEncryptionPass = App.getPersonalEncryptionPass();
        if (file.exists()) {
            this.D = a(personalEncryptionPass, Settings.Secure.getString(App.getInstance().getContentResolver(), "android_id"));
            h.a.a.c.a("COMM_SP", "SharedPrefsController", "init", "result:" + this.D + " (a)");
            if (!this.D && !h.a.a.p.e().isEmpty()) {
                String e2 = h.a.a.p.e();
                this.D = a(personalEncryptionPass, e2);
                h.a.a.c.a("COMM_SP", "SharedPrefsController", "init", "result:" + this.D + " (sn:" + e2 + ")");
            }
            if (this.D) {
                return;
            }
            String a2 = a(App.getContext());
            this.D = a(personalEncryptionPass, a2);
            h.a.a.c.a("COMM_SP", "SharedPrefsController", "init", "result:" + this.D + " (old:" + a2 + ")");
            return;
        }
        this.D = a(personalEncryptionPass, Settings.Secure.getString(App.getInstance().getContentResolver(), "android_id"));
        h.a.a.c.a("COMM_SP", "SharedPrefsController", "init", "result:" + this.D + " (new)");
    }

    private boolean a(String str, String str2) {
        try {
            this.C = new c.f.a(App.getInstance(), str, str2, this.f6863a, 10000);
            h.a.a.c.a("COMM_SP", "SharedPrefsController", "init", "getAll: " + this.C.getAll().size() + " items");
            if (this.C.getAll().size() == 0) {
                a.b edit = this.C.edit();
                edit.putBoolean(this.o, true);
                edit.apply();
            } else if (!this.C.getBoolean(this.o, false)) {
                return false;
            }
            return true;
        } catch (Throwable th) {
            h.a.a.c.a("COMM_SP", "SharedPrefsController", "init exception", Log.getStackTraceString(th));
            return false;
        }
    }

    private c.d.b.f c() {
        c.d.b.g gVar = new c.d.b.g();
        gVar.a("yyyy-MM-dd HH:mm:ss");
        return gVar.a();
    }

    public static v d() {
        if (c0 == null) {
            synchronized (v.class) {
                if (c0 == null) {
                    c0 = new v();
                }
            }
        }
        return c0;
    }

    public void A() {
        synchronized (this.S) {
            c.d.b.f c2 = c();
            if (!this.C.contains(this.q)) {
                a.b edit = this.C.edit();
                edit.putString(this.q, c2.a(new ArrayList(), new m(this).getType()));
                edit.apply();
            }
            List list = (List) c2.a(this.C.getString(this.q, "[]"), new o(this).getType());
            if (list == null) {
                return;
            }
            list.remove(list.size() - 1);
            a.b edit2 = this.C.edit();
            edit2.putString(this.q, c2.a(list, new q(this).getType()));
            edit2.apply();
        }
    }

    public void B() {
        synchronized (this.F) {
            a.b edit = this.C.edit();
            edit.remove(this.f6865c);
            edit.apply();
        }
    }

    public void C() {
        synchronized (this.E) {
            a.b edit = this.C.edit();
            edit.remove(this.f6864b);
            edit.apply();
        }
    }

    public void D() {
        synchronized (this.b0) {
            a.b edit = this.C.edit();
            edit.remove(this.B);
            edit.apply();
        }
    }

    public void E() {
        synchronized (this.Z) {
            a.b edit = this.C.edit();
            edit.putInt(this.z, 0);
            edit.apply();
        }
    }

    public void b(boolean z2) {
        synchronized (this.N) {
            a.b edit = this.C.edit();
            edit.putBoolean(this.j, z2);
            edit.apply();
        }
    }

    public void e(boolean z2) {
        synchronized (this.P) {
            a.b edit = this.C.edit();
            edit.putBoolean(this.l, z2);
            edit.apply();
        }
    }

    public void f(boolean z2) {
        synchronized (this.R) {
            a.b edit = this.C.edit();
            edit.putBoolean(this.n, z2);
            edit.apply();
        }
    }

    public void g(boolean z2) {
        synchronized (this.L) {
            a.b edit = this.C.edit();
            edit.putBoolean(this.f6870h, z2);
            edit.apply();
        }
    }

    public String h() {
        String string;
        synchronized (this.G) {
            string = this.C.getString(this.p, null);
        }
        return string;
    }

    public void i(String str) {
        synchronized (this.G) {
            a.b edit = this.C.edit();
            edit.putString(this.p, str);
            edit.apply();
        }
    }

    public void j(boolean z2) {
        synchronized (this.H) {
            a.b edit = this.C.edit();
            edit.putBoolean(this.f6866d, z2);
            edit.apply();
        }
    }

    public DataModels.User k() {
        synchronized (this.E) {
            c.d.b.f c2 = c();
            String string = this.C.getString(this.f6864b, null);
            if (string == null) {
                return null;
            }
            return (DataModels.User) c2.a(string, (Class<Object>) DataModels.User.class);
        }
    }

    public void l(boolean z2) {
        synchronized (this.K) {
            a.b edit = this.C.edit();
            edit.putBoolean(this.f6869g, z2);
            edit.apply();
        }
    }

    public void m() {
        synchronized (this.Z) {
            int g2 = g();
            a.b edit = this.C.edit();
            edit.putInt(this.z, g2 + 1);
            edit.apply();
        }
    }

    public boolean n() {
        boolean z2;
        synchronized (this.N) {
            z2 = this.C.getBoolean(this.j, false);
        }
        return z2;
    }

    public boolean o() {
        boolean z2;
        synchronized (this.O) {
            z2 = this.C.getBoolean(this.k, false);
        }
        return z2;
    }

    public boolean p() {
        boolean z2;
        synchronized (this.Q) {
            z2 = this.C.getBoolean(this.m, false);
        }
        return z2;
    }

    public boolean q() {
        boolean z2;
        synchronized (this.P) {
            z2 = this.C.getBoolean(this.l, false);
        }
        return z2;
    }

    public boolean r() {
        boolean z2;
        synchronized (this.R) {
            z2 = this.C.getBoolean(this.n, false);
        }
        return z2;
    }

    public boolean s() {
        boolean z2;
        synchronized (this.L) {
            z2 = this.C.getBoolean(this.f6870h, false);
        }
        return z2;
    }

    public boolean t() {
        boolean z2;
        synchronized (this.M) {
            z2 = this.C.getBoolean(this.f6871i, false);
        }
        return z2;
    }

    public boolean u() {
        boolean z2;
        synchronized (this.J) {
            z2 = this.C.getBoolean(this.f6868f, false);
        }
        return z2;
    }

    public boolean v() {
        boolean z2;
        synchronized (this.H) {
            z2 = this.C.getBoolean(this.f6866d, false);
        }
        return z2;
    }

    public boolean w() {
        boolean z2;
        synchronized (this.I) {
            z2 = this.C.getBoolean(this.f6867e, false);
        }
        return z2;
    }

    public boolean x() {
        boolean z2;
        synchronized (this.K) {
            z2 = this.C.getBoolean(this.f6869g, false);
        }
        return z2;
    }

    public boolean y() {
        return this.D;
    }

    public void z() {
        synchronized (this.W) {
            c.d.b.f c2 = c();
            if (!this.C.contains(this.w)) {
                a.b edit = this.C.edit();
                edit.putString(this.w, c2.a(new ArrayList(), new a(this).getType()));
                edit.apply();
            }
            List list = (List) c2.a(this.C.getString(this.w, "[]"), new c(this).getType());
            if (list == null) {
                return;
            }
            list.remove(list.size() - 1);
            a.b edit2 = this.C.edit();
            edit2.putString(this.w, c2.a(list, new e(this).getType()));
            edit2.apply();
        }
    }

    public void c(boolean z2) {
        synchronized (this.O) {
            a.b edit = this.C.edit();
            edit.putBoolean(this.k, z2);
            edit.apply();
        }
    }

    public AbstractMap.SimpleEntry<Date, String> b(String str) {
        HashMap hashMap;
        HashMap hashMap2;
        AbstractMap.SimpleEntry<Date, String> simpleEntry;
        HashMap hashMap3;
        synchronized (this.V) {
            c.d.b.f c2 = c();
            if (this.C.contains(this.u)) {
                hashMap = (HashMap) c2.a(this.C.getString(this.u, null), new t(this).getType());
            } else {
                hashMap = new HashMap();
            }
            if (hashMap.containsKey(str) && hashMap.get(str) != null) {
                simpleEntry = new AbstractMap.SimpleEntry<>(h.a.a.p.b((String) hashMap.get(str)), "");
            } else {
                if (this.C.contains(this.t)) {
                    hashMap2 = (HashMap) c2.a(this.C.getString(this.t, null), new x(this).getType());
                } else {
                    hashMap2 = new HashMap();
                }
                simpleEntry = (!hashMap2.containsKey(str) || hashMap2.get(str) == null) ? null : new AbstractMap.SimpleEntry<>(h.a.a.p.b((String) hashMap2.get(str)), "");
            }
            if (this.C.contains(this.v)) {
                hashMap3 = (HashMap) c2.a(this.C.getString(this.v, null), new y(this).getType());
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

    public void e(String str) {
        HashMap hashMap;
        synchronized (this.U) {
            c.d.b.f c2 = c();
            if (this.C.contains(this.s)) {
                hashMap = (HashMap) c2.a(this.C.getString(this.s, null), new p(this).getType());
            } else {
                hashMap = new HashMap();
            }
            if (hashMap.containsKey(str)) {
                int intValue = ((Integer) hashMap.get(str)).intValue();
                hashMap.put(str, Integer.valueOf(intValue < Integer.MAX_VALUE ? 1 + intValue : 1));
            }
            a.b edit = this.C.edit();
            edit.putString(this.s, c2.a(hashMap, new r(this).getType()));
            edit.apply();
        }
    }

    public boolean f(String str) {
        synchronized (this.T) {
            if (str.isEmpty()) {
                return false;
            }
            if (this.C.contains(this.r)) {
                c.d.b.f c2 = c();
                String string = this.C.getString(this.r, null);
                Map map = string != null ? (Map) c2.a(string, new h(this).getType()) : null;
                if (map != null) {
                    map.remove(str);
                    if (map.isEmpty()) {
                        a.b edit = this.C.edit();
                        edit.remove(this.r);
                        edit.apply();
                    } else {
                        a.b edit2 = this.C.edit();
                        edit2.putString(this.r, c2.a(map, new j(this).getType()));
                        edit2.apply();
                    }
                }
                return true;
            }
            return true;
        }
    }

    public void g(String str) {
        synchronized (this.V) {
            c.d.b.f c2 = c();
            if (this.C.contains(this.u)) {
                HashMap hashMap = (HashMap) c2.a(this.C.getString(this.u, null), new g0(this).getType());
                hashMap.remove(str);
                a.b edit = this.C.edit();
                edit.putString(this.u, c2.a(hashMap, new i0(this).getType()));
                edit.apply();
            }
        }
    }

    public void h(boolean z2) {
        synchronized (this.M) {
            a.b edit = this.C.edit();
            edit.putBoolean(this.f6871i, z2);
            edit.apply();
        }
    }

    public void i(boolean z2) {
        synchronized (this.J) {
            a.b edit = this.C.edit();
            edit.putBoolean(this.f6868f, z2);
            edit.apply();
        }
    }

    public String j() {
        String string;
        synchronized (this.b0) {
            string = this.C.getString(this.B, null);
        }
        return string;
    }

    public boolean l() {
        boolean z2;
        synchronized (this.X) {
            z2 = this.C.getBoolean(this.x, false);
        }
        return z2;
    }

    public int c(String str) {
        HashMap hashMap;
        synchronized (this.U) {
            c.d.b.f c2 = c();
            if (this.C.contains(this.s)) {
                hashMap = (HashMap) c2.a(this.C.getString(this.s, null), new l(this).getType());
            } else {
                hashMap = new HashMap();
            }
            if (hashMap.containsKey(str)) {
                return ((Integer) hashMap.get(str)).intValue();
            }
            hashMap.put(str, 1);
            a.b edit = this.C.edit();
            edit.putString(this.s, c2.a(hashMap, new n(this).getType()));
            edit.apply();
            return ((Integer) hashMap.get(str)).intValue();
        }
    }

    public void a(DataModels.User user) {
        synchronized (this.E) {
            String a2 = c().a(user);
            a.b edit = this.C.edit();
            edit.putString(this.f6864b, a2);
            edit.apply();
        }
    }

    public void d(boolean z2) {
        synchronized (this.Q) {
            a.b edit = this.C.edit();
            edit.putBoolean(this.m, z2);
            edit.apply();
        }
    }

    public void h(String str) {
        synchronized (this.a0) {
            a.b edit = this.C.edit();
            edit.putString(this.A, str);
            edit.apply();
        }
    }

    public DataModels.o i() {
        synchronized (this.S) {
            c.d.b.f c2 = c();
            if (!this.C.contains(this.q)) {
                a.b edit = this.C.edit();
                edit.putString(this.q, c2.a(new ArrayList(), new s(this).getType()));
                edit.apply();
            }
            List list = (List) c2.a(this.C.getString(this.q, "[]"), new u(this).getType());
            DataModels.o oVar = null;
            if (list == null) {
                return null;
            }
            if (list.size() != 0) {
                oVar = (DataModels.o) list.get(list.size() - 1);
            }
            return oVar;
        }
    }

    public void j(String str) {
        synchronized (this.b0) {
            a.b edit = this.C.edit();
            edit.putString(this.B, str);
            edit.apply();
        }
    }

    public void k(boolean z2) {
        synchronized (this.I) {
            a.b edit = this.C.edit();
            edit.putBoolean(this.f6867e, z2);
            edit.apply();
        }
    }

    public boolean d(String str) {
        synchronized (this.T) {
            boolean z2 = false;
            if (str.isEmpty()) {
                return false;
            }
            if (this.C.contains(this.r)) {
                String string = this.C.getString(this.r, null);
                if (string == null) {
                    return false;
                }
                Map map = (Map) c().a(string, new w(this).getType());
                if (map != null && map.containsKey(str)) {
                    z2 = true;
                }
                return z2;
            }
            return false;
        }
    }

    public Date a() {
        Date b2;
        synchronized (this.F) {
            String string = this.C.getString(this.f6865c, null);
            b2 = string != null ? h.a.a.p.b(string) : null;
        }
        return b2;
    }

    public int g() {
        int i2;
        synchronized (this.Z) {
            i2 = this.C.getInt(this.z, 0);
        }
        return i2;
    }

    public void a(Date date) {
        synchronized (this.F) {
            String b2 = h.a.a.p.b(date);
            a.b edit = this.C.edit();
            edit.putString(this.f6865c, b2);
            edit.apply();
        }
    }

    public Long e() {
        Long valueOf;
        synchronized (this.Y) {
            valueOf = Long.valueOf(this.C.getLong(this.y, 0L));
        }
        return valueOf;
    }

    public void a(DataModels.o oVar) {
        synchronized (this.S) {
            c.d.b.f c2 = c();
            if (!this.C.contains(this.q)) {
                a.b edit = this.C.edit();
                edit.putString(this.q, c2.a(new ArrayList(), new C0153v(this).getType()));
                edit.apply();
            }
            List list = (List) c2.a(this.C.getString(this.q, "[]"), new h0(this).getType());
            if (list == null) {
                return;
            }
            list.add(0, oVar);
            a.b edit2 = this.C.edit();
            edit2.putString(this.q, c2.a(list, new k(this).getType()));
            edit2.apply();
        }
    }

    public String f() {
        String string;
        synchronized (this.a0) {
            string = this.C.getString(this.A, null);
        }
        return string;
    }

    public DataModels.h b() {
        synchronized (this.W) {
            c.d.b.f c2 = c();
            if (!this.C.contains(this.w)) {
                a.b edit = this.C.edit();
                edit.putString(this.w, c2.a(new ArrayList(), new g(this).getType()));
                edit.apply();
            }
            List list = (List) c2.a(this.C.getString(this.w, "[]"), new i(this).getType());
            DataModels.h hVar = null;
            if (list == null) {
                return null;
            }
            if (list.size() != 0) {
                hVar = (DataModels.h) list.get(list.size() - 1);
            }
            return hVar;
        }
    }

    public DataModels.p a(String str) {
        synchronized (this.T) {
            if (str.isEmpty()) {
                return null;
            }
            if (this.C.contains(this.r)) {
                String string = this.C.getString(this.r, null);
                if (string == null) {
                    return null;
                }
                Map map = (Map) c().a(string, new b(this).getType());
                if (map == null) {
                    return null;
                }
                return (DataModels.p) map.get(str);
            }
            return null;
        }
    }

    public boolean a(String str, DataModels.p pVar) {
        boolean z2 = false;
        try {
        } catch (Throwable th) {
            h.a.a.c.a("COMM_SP", "SharedPrefsController", "saveStageState", "Failed to save stage stage: " + Log.getStackTraceString(th));
        }
        synchronized (this.T) {
            if (str.isEmpty()) {
                return false;
            }
            c.d.b.f c2 = c();
            String string = this.C.getString(this.r, null);
            Map map = string != null ? (Map) c2.a(string, new d(this).getType()) : null;
            if (map == null) {
                map = new HashMap();
            }
            map.put(str, pVar);
            a.b edit = this.C.edit();
            edit.putString(this.r, c2.a(map, new f(this).getType()));
            edit.apply();
            z2 = true;
            return z2;
        }
    }

    public void a(String str, Date date, String str2) {
        HashMap hashMap;
        HashMap hashMap2;
        synchronized (this.V) {
            c.d.b.f c2 = c();
            g(str);
            if (this.C.contains(this.t)) {
                hashMap = (HashMap) c2.a(this.C.getString(this.t, null), new z(this).getType());
            } else {
                hashMap = new HashMap();
            }
            if (date == null) {
                date = new Date(0L);
            }
            hashMap.put(str, h.a.a.p.b(date));
            if (this.C.contains(this.v)) {
                hashMap2 = (HashMap) c2.a(this.C.getString(this.v, null), new a0(this).getType());
            } else {
                hashMap2 = new HashMap();
            }
            hashMap2.put(str, str2 != null ? str2.trim() : "");
            a.b edit = this.C.edit();
            edit.putString(this.t, c2.a(hashMap, new b0(this).getType()));
            edit.putString(this.v, c2.a(hashMap2, new c0(this).getType()));
            edit.apply();
        }
    }

    public void a(String str, int i2) {
        HashMap hashMap;
        HashMap hashMap2;
        synchronized (this.V) {
            c.d.b.f c2 = c();
            if (this.C.contains(this.t)) {
                hashMap = (HashMap) c2.a(this.C.getString(this.t, null), new d0(this).getType());
            } else {
                hashMap = new HashMap();
            }
            if (hashMap.containsKey(str)) {
                if (this.C.contains(this.u)) {
                    hashMap2 = (HashMap) c2.a(this.C.getString(this.u, null), new e0(this).getType());
                } else {
                    hashMap2 = new HashMap();
                }
                if (!hashMap2.containsKey(str)) {
                    hashMap2.put(str, h.a.a.p.b(new Date(h.a.a.p.a(h.a.a.p.b((String) hashMap.get(str))) + (i2 * 60 * 1000))));
                    a.b edit = this.C.edit();
                    edit.putString(this.u, c2.a(hashMap2, new f0(this).getType()));
                    edit.apply();
                }
            }
        }
    }

    public void a(DataModels.h hVar) {
        synchronized (this.W) {
            c.d.b.f c2 = c();
            if (!this.C.contains(this.w)) {
                a.b edit = this.C.edit();
                edit.putString(this.w, c2.a(new ArrayList(), new j0(this).getType()));
                edit.apply();
            }
            List list = (List) c2.a(this.C.getString(this.w, "[]"), new k0(this).getType());
            if (list == null) {
                return;
            }
            list.add(0, hVar);
            a.b edit2 = this.C.edit();
            edit2.putString(this.w, c2.a(list, new l0(this).getType()));
            edit2.apply();
        }
    }

    public void a(boolean z2) {
        synchronized (this.X) {
            a.b edit = this.C.edit();
            edit.putBoolean(this.x, z2);
            edit.apply();
        }
    }

    public void a(Long l2) {
        synchronized (this.Y) {
            a.b edit = this.C.edit();
            edit.putLong(this.y, l2.longValue());
            edit.apply();
        }
    }

    private String a(Context context) {
        try {
            String str = (String) Build.class.getField("SERIAL").get(null);
            return TextUtils.isEmpty(str) ? Settings.Secure.getString(context.getContentResolver(), "android_id") : str;
        } catch (Exception unused) {
            return Settings.Secure.getString(context.getContentResolver(), "android_id");
        }
    }
}
