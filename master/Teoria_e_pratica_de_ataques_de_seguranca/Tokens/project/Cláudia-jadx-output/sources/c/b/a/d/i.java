package c.b.a.d;

import android.content.Context;
import android.util.Log;
import io.fabric.sdk.android.services.concurrency.UnmetDependencyException;
import java.util.Collections;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
/* compiled from: CrashlyticsCore.java */
@d.a.a.a.m.c.e({c.b.a.d.o0.a.class})
/* loaded from: classes.dex */
public class i extends d.a.a.a.h<Void> {

    /* renamed from: g  reason: collision with root package name */
    public final long f3066g;

    /* renamed from: h  reason: collision with root package name */
    public final ConcurrentHashMap<String, String> f3067h;

    /* renamed from: i  reason: collision with root package name */
    public j f3068i;
    public j j;
    public k k;
    public h m;
    public String n;
    public String o;
    public String p;
    public float q;
    public boolean r;
    public final a0 s;
    public d.a.a.a.m.e.d t;
    public g u;
    public c.b.a.d.o0.a v;

    /* compiled from: CrashlyticsCore.java */
    /* loaded from: classes.dex */
    public class a extends d.a.a.a.m.c.h<Void> {
        public a() {
        }

        @Override // d.a.a.a.m.c.k, d.a.a.a.m.c.j
        public d.a.a.a.m.c.f a() {
            return d.a.a.a.m.c.f.IMMEDIATE;
        }

        @Override // java.util.concurrent.Callable
        public Void call() {
            return i.this.d();
        }
    }

    /* compiled from: CrashlyticsCore.java */
    /* loaded from: classes.dex */
    public class b implements Callable<Void> {
        public b() {
        }

        @Override // java.util.concurrent.Callable
        public Void call() {
            i.this.f3068i.a();
            d.a.a.a.c.h().e("CrashlyticsCore", "Initialization marker file created.");
            return null;
        }
    }

    /* compiled from: CrashlyticsCore.java */
    /* loaded from: classes.dex */
    public class c implements Callable<Boolean> {
        public c() {
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // java.util.concurrent.Callable
        public Boolean call() {
            try {
                boolean d2 = i.this.f3068i.d();
                d.a.a.a.k h2 = d.a.a.a.c.h();
                h2.e("CrashlyticsCore", "Initialization marker file removed: " + d2);
                return Boolean.valueOf(d2);
            } catch (Exception e2) {
                d.a.a.a.c.h().c("CrashlyticsCore", "Problem encountered deleting Crashlytics initialization marker.", e2);
                return false;
            }
        }
    }

    /* compiled from: CrashlyticsCore.java */
    /* loaded from: classes.dex */
    public class d implements Callable<Boolean> {
        public d() {
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // java.util.concurrent.Callable
        public Boolean call() {
            return Boolean.valueOf(i.this.f3068i.c());
        }
    }

    /* compiled from: CrashlyticsCore.java */
    /* loaded from: classes.dex */
    public static final class e implements Callable<Boolean> {

        /* renamed from: a  reason: collision with root package name */
        public final j f3073a;

        public e(j jVar) {
            this.f3073a = jVar;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // java.util.concurrent.Callable
        public Boolean call() {
            if (!this.f3073a.c()) {
                return Boolean.FALSE;
            }
            d.a.a.a.c.h().e("CrashlyticsCore", "Found previous crash marker.");
            this.f3073a.d();
            return Boolean.TRUE;
        }
    }

    /* compiled from: CrashlyticsCore.java */
    /* loaded from: classes.dex */
    public static final class f implements k {
        public f() {
        }

        @Override // c.b.a.d.k
        public void a() {
        }

        public /* synthetic */ f(a aVar) {
            this();
        }
    }

    public i() {
        this(1.0f, null, null, false);
    }

    public static String c(int i2, String str, String str2) {
        return d.a.a.a.m.b.i.a(i2) + "/" + str + " " + str2;
    }

    public static i z() {
        return (i) d.a.a.a.c.a(i.class);
    }

    public void b(int i2, String str, String str2) {
        a(i2, str, str2);
        d.a.a.a.c.h().a(i2, "" + str, "" + str2, true);
    }

    @Override // d.a.a.a.h
    public String i() {
        return "com.crashlytics.sdk.android.crashlytics-core";
    }

    @Override // d.a.a.a.h
    public String k() {
        return "2.3.16.dev";
    }

    @Override // d.a.a.a.h
    public boolean n() {
        return a(super.e());
    }

    public final void o() {
        if (Boolean.TRUE.equals((Boolean) this.u.b(new e(this.j)))) {
            try {
                this.k.a();
            } catch (Exception e2) {
                d.a.a.a.c.h().c("CrashlyticsCore", "Exception thrown by CrashlyticsListener while notifying of previous crash.", e2);
            }
        }
    }

    public void p() {
        this.j.a();
    }

    public boolean q() {
        return ((Boolean) this.u.b(new d())).booleanValue();
    }

    public final void r() {
        a aVar = new a();
        for (d.a.a.a.m.c.m mVar : f()) {
            aVar.a(mVar);
        }
        Future submit = g().c().submit(aVar);
        d.a.a.a.c.h().e("CrashlyticsCore", "Crashlytics detected incomplete initialization on previous app launch. Will initialize synchronously.");
        try {
            submit.get(4L, TimeUnit.SECONDS);
        } catch (InterruptedException e2) {
            d.a.a.a.c.h().c("CrashlyticsCore", "Crashlytics was interrupted during initialization.", e2);
        } catch (ExecutionException e3) {
            d.a.a.a.c.h().c("CrashlyticsCore", "Problem encountered during Crashlytics initialization.", e3);
        } catch (TimeoutException e4) {
            d.a.a.a.c.h().c("CrashlyticsCore", "Crashlytics timed out during initialization.", e4);
        }
    }

    public Map<String, String> s() {
        return Collections.unmodifiableMap(this.f3067h);
    }

    public c.b.a.d.o0.b.d t() {
        c.b.a.d.o0.a aVar = this.v;
        if (aVar != null) {
            return aVar.a();
        }
        return null;
    }

    public String u() {
        if (h().a()) {
            return this.o;
        }
        return null;
    }

    public String v() {
        if (h().a()) {
            return this.n;
        }
        return null;
    }

    public String w() {
        if (h().a()) {
            return this.p;
        }
        return null;
    }

    public void x() {
        this.u.a(new c());
    }

    public void y() {
        this.u.b(new b());
    }

    public i(float f2, k kVar, a0 a0Var, boolean z) {
        this(f2, kVar, a0Var, z, d.a.a.a.m.b.n.a("Crashlytics Exception Handler"));
    }

    public static String c(String str) {
        if (str != null) {
            String trim = str.trim();
            return trim.length() > 1024 ? trim.substring(0, 1024) : trim;
        }
        return str;
    }

    public boolean a(Context context) {
        String c2;
        if (this.r || (c2 = new d.a.a.a.m.b.g().c(context)) == null) {
            return false;
        }
        String n = d.a.a.a.m.b.i.n(context);
        if (a(n, d.a.a.a.m.b.i.a(context, "com.crashlytics.RequireBuildId", true))) {
            try {
                d.a.a.a.k h2 = d.a.a.a.c.h();
                h2.b("CrashlyticsCore", "Initializing Crashlytics " + k());
                d.a.a.a.m.f.b bVar = new d.a.a.a.m.f.b(this);
                this.j = new j("crash_marker", bVar);
                this.f3068i = new j("initialization_marker", bVar);
                b0 a2 = b0.a(new d.a.a.a.m.f.d(e(), "com.crashlytics.android.core.CrashlyticsCore"), this);
                l lVar = this.s != null ? new l(this.s) : null;
                this.t = new d.a.a.a.m.e.b(d.a.a.a.c.h());
                this.t.a(lVar);
                d.a.a.a.m.b.o h3 = h();
                c.b.a.d.a a3 = c.b.a.d.a.a(context, h3, c2, n);
                v vVar = new v(context, a3.f2972d);
                d.a.a.a.k h4 = d.a.a.a.c.h();
                h4.e("CrashlyticsCore", "Installer package name is: " + a3.f2971c);
                this.m = new h(this, this.u, this.t, h3, a2, bVar, a3, vVar);
                boolean q = q();
                o();
                this.m.a(Thread.getDefaultUncaughtExceptionHandler());
                if (q && d.a.a.a.m.b.i.b(context)) {
                    d.a.a.a.c.h().e("CrashlyticsCore", "Crashlytics did not finish previous background initialization. Initializing synchronously.");
                    r();
                    return false;
                }
                d.a.a.a.c.h().e("CrashlyticsCore", "Exception handling initialization successful");
                return true;
            } catch (Exception e2) {
                d.a.a.a.c.h().c("CrashlyticsCore", "Crashlytics was not started due to an exception during initialization", e2);
                this.m = null;
                return false;
            }
        }
        throw new UnmetDependencyException("This app relies on Crashlytics. Please sign up for access at https://fabric.io/sign_up,\ninstall an Android build tool and ask a team member to invite you to this app's organization.");
    }

    @Override // d.a.a.a.h
    public Void d() {
        d.a.a.a.m.g.u a2;
        y();
        c.b.a.d.o0.b.d t = t();
        if (t != null) {
            this.m.b(t);
        }
        this.m.a();
        try {
            try {
                a2 = d.a.a.a.m.g.r.d().a();
            } catch (Exception e2) {
                d.a.a.a.c.h().c("CrashlyticsCore", "Crashlytics encountered a problem during asynchronous initialization.", e2);
            }
            if (a2 == null) {
                d.a.a.a.c.h().a("CrashlyticsCore", "Received null settings, skipping report submission!");
                return null;
            } else if (!a2.f4454d.f4427b) {
                d.a.a.a.c.h().e("CrashlyticsCore", "Collection of crash reports disabled in Crashlytics settings.");
                return null;
            } else {
                if (!this.m.b(a2.f4452b)) {
                    d.a.a.a.c.h().e("CrashlyticsCore", "Could not finalize previous sessions.");
                }
                this.m.a(this.q, a2);
                return null;
            }
        } finally {
            x();
        }
    }

    public static boolean b(String str) {
        i z = z();
        if (z == null || z.m == null) {
            d.a.a.a.k h2 = d.a.a.a.c.h();
            h2.c("CrashlyticsCore", "Crashlytics must be initialized by calling Fabric.with(Context) " + str, null);
            return false;
        }
        return true;
    }

    public i(float f2, k kVar, a0 a0Var, boolean z, ExecutorService executorService) {
        this.n = null;
        this.o = null;
        this.p = null;
        this.q = f2;
        this.k = kVar == null ? new f(null) : kVar;
        this.s = a0Var;
        this.r = z;
        this.u = new g(executorService);
        this.f3067h = new ConcurrentHashMap<>();
        this.f3066g = System.currentTimeMillis();
    }

    public void a(Throwable th) {
        if (!this.r && b("prior to logging exceptions.")) {
            if (th == null) {
                d.a.a.a.c.h().a(5, "CrashlyticsCore", "Crashlytics is ignoring a request to log a null exception.");
            } else {
                this.m.b(Thread.currentThread(), th);
            }
        }
    }

    public final void a(int i2, String str, String str2) {
        if (!this.r && b("prior to logging messages.")) {
            this.m.a(System.currentTimeMillis() - this.f3066g, c(i2, str, str2));
        }
    }

    public void a(String str) {
        if (!this.r && b("prior to setting user data.")) {
            this.n = c(str);
            this.m.a(this.n, this.p, this.o);
        }
    }

    public static boolean a(String str, boolean z) {
        if (!z) {
            d.a.a.a.c.h().e("CrashlyticsCore", "Configured not to require a build ID.");
            return true;
        } else if (d.a.a.a.m.b.i.b(str)) {
            Log.e("CrashlyticsCore", ".");
            Log.e("CrashlyticsCore", ".     |  | ");
            Log.e("CrashlyticsCore", ".     |  |");
            Log.e("CrashlyticsCore", ".     |  |");
            Log.e("CrashlyticsCore", ".   \\ |  | /");
            Log.e("CrashlyticsCore", ".    \\    /");
            Log.e("CrashlyticsCore", ".     \\  /");
            Log.e("CrashlyticsCore", ".      \\/");
            Log.e("CrashlyticsCore", ".");
            Log.e("CrashlyticsCore", "This app relies on Crashlytics. Please sign up for access at https://fabric.io/sign_up,\ninstall an Android build tool and ask a team member to invite you to this app's organization.");
            Log.e("CrashlyticsCore", ".");
            Log.e("CrashlyticsCore", ".      /\\");
            Log.e("CrashlyticsCore", ".     /  \\");
            Log.e("CrashlyticsCore", ".    /    \\");
            Log.e("CrashlyticsCore", ".   / |  | \\");
            Log.e("CrashlyticsCore", ".     |  |");
            Log.e("CrashlyticsCore", ".     |  |");
            Log.e("CrashlyticsCore", ".     |  |");
            Log.e("CrashlyticsCore", ".");
            return false;
        } else {
            return true;
        }
    }
}
