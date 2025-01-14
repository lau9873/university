package p070c.p074b.p075a.p078d;

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
import p070c.p074b.p075a.p078d.p079o0.CrashEventDataProvider;
import p070c.p074b.p075a.p078d.p079o0.p080b.SessionEventData;
import p136d.p137a.p138a.p139a.Fabric;
import p136d.p137a.p138a.p139a.Kit;
import p136d.p137a.p138a.p139a.Logger;
import p136d.p137a.p138a.p139a.p140m.p142b.ApiKey;
import p136d.p137a.p138a.p139a.p140m.p142b.CommonUtils;
import p136d.p137a.p138a.p139a.p140m.p142b.ExecutorUtils;
import p136d.p137a.p138a.p139a.p140m.p142b.IdManager;
import p136d.p137a.p138a.p139a.p140m.p143c.DependsOn;
import p136d.p137a.p138a.p139a.p140m.p143c.Priority;
import p136d.p137a.p138a.p139a.p140m.p143c.PriorityCallable;
import p136d.p137a.p138a.p139a.p140m.p143c.Task;
import p136d.p137a.p138a.p139a.p140m.p146e.DefaultHttpRequestFactory;
import p136d.p137a.p138a.p139a.p140m.p146e.HttpRequestFactory;
import p136d.p137a.p138a.p139a.p140m.p147f.FileStoreImpl;
import p136d.p137a.p138a.p139a.p140m.p147f.PreferenceStoreImpl;
import p136d.p137a.p138a.p139a.p140m.p148g.Settings;
import p136d.p137a.p138a.p139a.p140m.p148g.SettingsData;

@DependsOn({CrashEventDataProvider.class})
/* renamed from: c.b.a.d.i */
/* loaded from: classes.dex */
public class CrashlyticsCore extends Kit<Void> {

    /* renamed from: g */
    public final long f4892g;

    /* renamed from: h */
    public final ConcurrentHashMap<String, String> f4893h;

    /* renamed from: i */
    public CrashlyticsFileMarker f4894i;

    /* renamed from: j */
    public CrashlyticsFileMarker f4895j;

    /* renamed from: k */
    public CrashlyticsListener f4896k;

    /* renamed from: m */
    public CrashlyticsController f4897m;

    /* renamed from: n */
    public String f4898n;

    /* renamed from: o */
    public String f4899o;

    /* renamed from: p */
    public String f4900p;

    /* renamed from: q */
    public float f4901q;

    /* renamed from: r */
    public boolean f4902r;

    /* renamed from: s */
    public final PinningInfoProvider f4903s;

    /* renamed from: t */
    public HttpRequestFactory f4904t;

    /* renamed from: u */
    public CrashlyticsBackgroundWorker f4905u;

    /* renamed from: v */
    public CrashEventDataProvider f4906v;

    /* compiled from: CrashlyticsCore.java */
    /* renamed from: c.b.a.d.i$a */
    /* loaded from: classes.dex */
    public class C0854a extends PriorityCallable<Void> {
        public C0854a() {
        }

        @Override // p136d.p137a.p138a.p139a.p140m.p143c.PriorityTask, p136d.p137a.p138a.p139a.p140m.p143c.PriorityProvider
        /* renamed from: a */
        public Priority mo3972a() {
            return Priority.IMMEDIATE;
        }

        @Override // java.util.concurrent.Callable
        public Void call() {
            return CrashlyticsCore.this.mo4150d();
        }
    }

    /* compiled from: CrashlyticsCore.java */
    /* renamed from: c.b.a.d.i$b */
    /* loaded from: classes.dex */
    public class CallableC0855b implements Callable<Void> {
        public CallableC0855b() {
        }

        @Override // java.util.concurrent.Callable
        public Void call() {
            CrashlyticsCore.this.f4894i.m5757a();
            Fabric.m4197h().mo4157e("CrashlyticsCore", "Initialization marker file created.");
            return null;
        }
    }

    /* compiled from: CrashlyticsCore.java */
    /* renamed from: c.b.a.d.i$c */
    /* loaded from: classes.dex */
    public class CallableC0856c implements Callable<Boolean> {
        public CallableC0856c() {
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // java.util.concurrent.Callable
        public Boolean call() {
            try {
                boolean m5754d = CrashlyticsCore.this.f4894i.m5754d();
                Logger m4197h = Fabric.m4197h();
                m4197h.mo4157e("CrashlyticsCore", "Initialization marker file removed: " + m5754d);
                return Boolean.valueOf(m5754d);
            } catch (Exception e) {
                Fabric.m4197h().mo4159c("CrashlyticsCore", "Problem encountered deleting Crashlytics initialization marker.", e);
                return false;
            }
        }
    }

    /* compiled from: CrashlyticsCore.java */
    /* renamed from: c.b.a.d.i$d */
    /* loaded from: classes.dex */
    public class CallableC0857d implements Callable<Boolean> {
        public CallableC0857d() {
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // java.util.concurrent.Callable
        public Boolean call() {
            return Boolean.valueOf(CrashlyticsCore.this.f4894i.m5755c());
        }
    }

    /* compiled from: CrashlyticsCore.java */
    /* renamed from: c.b.a.d.i$e */
    /* loaded from: classes.dex */
    public static final class CallableC0858e implements Callable<Boolean> {

        /* renamed from: a */
        public final CrashlyticsFileMarker f4911a;

        public CallableC0858e(CrashlyticsFileMarker crashlyticsFileMarker) {
            this.f4911a = crashlyticsFileMarker;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // java.util.concurrent.Callable
        public Boolean call() {
            if (!this.f4911a.m5755c()) {
                return Boolean.FALSE;
            }
            Fabric.m4197h().mo4157e("CrashlyticsCore", "Found previous crash marker.");
            this.f4911a.m5754d();
            return Boolean.TRUE;
        }
    }

    /* compiled from: CrashlyticsCore.java */
    /* renamed from: c.b.a.d.i$f */
    /* loaded from: classes.dex */
    public static final class C0859f implements CrashlyticsListener {
        public C0859f() {
        }

        @Override // p070c.p074b.p075a.p078d.CrashlyticsListener
        /* renamed from: a */
        public void mo5753a() {
        }

        public /* synthetic */ C0859f(C0854a c0854a) {
            this();
        }
    }

    public CrashlyticsCore() {
        this(1.0f, null, null, false);
    }

    /* renamed from: c */
    public static String m5771c(int i, String str, String str2) {
        return CommonUtils.m4112a(i) + "/" + str + " " + str2;
    }

    /* renamed from: z */
    public static CrashlyticsCore m5758z() {
        return (CrashlyticsCore) Fabric.m4212a(CrashlyticsCore.class);
    }

    /* renamed from: b */
    public void m5773b(int i, String str, String str2) {
        m5779a(i, str, str2);
        Fabric.m4197h().mo4166a(i, "" + str, "" + str2, true);
    }

    @Override // p136d.p137a.p138a.p139a.Kit
    /* renamed from: i */
    public String mo4149i() {
        return "com.crashlytics.sdk.android.crashlytics-core";
    }

    @Override // p136d.p137a.p138a.p139a.Kit
    /* renamed from: k */
    public String mo4148k() {
        return "2.3.16.dev";
    }

    @Override // p136d.p137a.p138a.p139a.Kit
    /* renamed from: n */
    public boolean mo4147n() {
        return m5778a(super.m4178e());
    }

    /* renamed from: o */
    public final void m5769o() {
        if (Boolean.TRUE.equals((Boolean) this.f4905u.m5891b(new CallableC0858e(this.f4895j)))) {
            try {
                this.f4896k.mo5753a();
            } catch (Exception e) {
                Fabric.m4197h().mo4159c("CrashlyticsCore", "Exception thrown by CrashlyticsListener while notifying of previous crash.", e);
            }
        }
    }

    /* renamed from: p */
    public void m5768p() {
        this.f4895j.m5757a();
    }

    /* renamed from: q */
    public boolean m5767q() {
        return ((Boolean) this.f4905u.m5891b(new CallableC0857d())).booleanValue();
    }

    /* renamed from: r */
    public final void m5766r() {
        C0854a c0854a = new C0854a();
        for (Task task : m4177f()) {
            c0854a.mo3970a(task);
        }
        Future submit = m4176g().m4204c().submit(c0854a);
        Fabric.m4197h().mo4157e("CrashlyticsCore", "Crashlytics detected incomplete initialization on previous app launch. Will initialize synchronously.");
        try {
            submit.get(4L, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            Fabric.m4197h().mo4159c("CrashlyticsCore", "Crashlytics was interrupted during initialization.", e);
        } catch (ExecutionException e2) {
            Fabric.m4197h().mo4159c("CrashlyticsCore", "Problem encountered during Crashlytics initialization.", e2);
        } catch (TimeoutException e3) {
            Fabric.m4197h().mo4159c("CrashlyticsCore", "Crashlytics timed out during initialization.", e3);
        }
    }

    /* renamed from: s */
    public Map<String, String> m5765s() {
        return Collections.unmodifiableMap(this.f4893h);
    }

    /* renamed from: t */
    public SessionEventData m5764t() {
        CrashEventDataProvider crashEventDataProvider = this.f4906v;
        if (crashEventDataProvider != null) {
            return crashEventDataProvider.m5746a();
        }
        return null;
    }

    /* renamed from: u */
    public String m5763u() {
        if (m4175h().m4056a()) {
            return this.f4899o;
        }
        return null;
    }

    /* renamed from: v */
    public String m5762v() {
        if (m4175h().m4056a()) {
            return this.f4898n;
        }
        return null;
    }

    /* renamed from: w */
    public String m5761w() {
        if (m4175h().m4056a()) {
            return this.f4900p;
        }
        return null;
    }

    /* renamed from: x */
    public void m5760x() {
        this.f4905u.m5892a(new CallableC0856c());
    }

    /* renamed from: y */
    public void m5759y() {
        this.f4905u.m5891b(new CallableC0855b());
    }

    public CrashlyticsCore(float f, CrashlyticsListener crashlyticsListener, PinningInfoProvider pinningInfoProvider, boolean z) {
        this(f, crashlyticsListener, pinningInfoProvider, z, ExecutorUtils.m4062a("Crashlytics Exception Handler"));
    }

    /* renamed from: c */
    public static String m5770c(String str) {
        if (str != null) {
            String trim = str.trim();
            return trim.length() > 1024 ? trim.substring(0, 1024) : trim;
        }
        return str;
    }

    /* renamed from: a */
    public boolean m5778a(Context context) {
        String m4115c;
        if (this.f4902r || (m4115c = new ApiKey().m4115c(context)) == null) {
            return false;
        }
        String m4070n = CommonUtils.m4070n(context);
        if (m5775a(m4070n, CommonUtils.m4106a(context, "com.crashlytics.RequireBuildId", true))) {
            try {
                Logger m4197h = Fabric.m4197h();
                m4197h.mo4162b("CrashlyticsCore", "Initializing Crashlytics " + mo4148k());
                FileStoreImpl fileStoreImpl = new FileStoreImpl(this);
                this.f4895j = new CrashlyticsFileMarker("crash_marker", fileStoreImpl);
                this.f4894i = new CrashlyticsFileMarker("initialization_marker", fileStoreImpl);
                C0813b0 m5968a = C0813b0.m5968a(new PreferenceStoreImpl(m4178e(), "com.crashlytics.android.core.CrashlyticsCore"), this);
                CrashlyticsPinningInfoProvider crashlyticsPinningInfoProvider = this.f4903s != null ? new CrashlyticsPinningInfoProvider(this.f4903s) : null;
                this.f4904t = new DefaultHttpRequestFactory(Fabric.m4197h());
                this.f4904t.mo3919a(crashlyticsPinningInfoProvider);
                IdManager m4175h = m4175h();
                AppData m5978a = AppData.m5978a(context, m4175h, m4115c, m4070n);
                ManifestUnityVersionProvider manifestUnityVersionProvider = new ManifestUnityVersionProvider(context, m5978a.f4785d);
                Logger m4197h2 = Fabric.m4197h();
                m4197h2.mo4157e("CrashlyticsCore", "Installer package name is: " + m5978a.f4784c);
                this.f4897m = new CrashlyticsController(this, this.f4905u, this.f4904t, m4175h, m5968a, fileStoreImpl, m5978a, manifestUnityVersionProvider);
                boolean m5767q = m5767q();
                m5769o();
                this.f4897m.m5828a(Thread.getDefaultUncaughtExceptionHandler());
                if (m5767q && CommonUtils.m4088b(context)) {
                    Fabric.m4197h().mo4157e("CrashlyticsCore", "Crashlytics did not finish previous background initialization. Initializing synchronously.");
                    m5766r();
                    return false;
                }
                Fabric.m4197h().mo4157e("CrashlyticsCore", "Exception handling initialization successful");
                return true;
            } catch (Exception e) {
                Fabric.m4197h().mo4159c("CrashlyticsCore", "Crashlytics was not started due to an exception during initialization", e);
                this.f4897m = null;
                return false;
            }
        }
        throw new UnmetDependencyException("This app relies on Crashlytics. Please sign up for access at https://fabric.io/sign_up,\ninstall an Android build tool and ask a team member to invite you to this app's organization.");
    }

    @Override // p136d.p137a.p138a.p139a.Kit
    /* renamed from: d  reason: avoid collision after fix types in other method */
    public Void mo4150d() {
        SettingsData m3873a;
        m5759y();
        SessionEventData m5764t = m5764t();
        if (m5764t != null) {
            this.f4897m.m5817b(m5764t);
        }
        this.f4897m.m5859a();
        try {
            try {
                m3873a = Settings.m3868d().m3873a();
            } catch (Exception e) {
                Fabric.m4197h().mo4159c("CrashlyticsCore", "Crashlytics encountered a problem during asynchronous initialization.", e);
            }
            if (m3873a == null) {
                Fabric.m4197h().mo4164a("CrashlyticsCore", "Received null settings, skipping report submission!");
                return null;
            } else if (!m3873a.f6660d.f6633b) {
                Fabric.m4197h().mo4157e("CrashlyticsCore", "Collection of crash reports disabled in Crashlytics settings.");
                return null;
            } else {
                if (!this.f4897m.m5816b(m3873a.f6658b)) {
                    Fabric.m4197h().mo4157e("CrashlyticsCore", "Could not finalize previous sessions.");
                }
                this.f4897m.m5858a(this.f4901q, m3873a);
                return null;
            }
        } finally {
            m5760x();
        }
    }

    /* renamed from: b */
    public static boolean m5772b(String str) {
        CrashlyticsCore m5758z = m5758z();
        if (m5758z == null || m5758z.f4897m == null) {
            Logger m4197h = Fabric.m4197h();
            m4197h.mo4159c("CrashlyticsCore", "Crashlytics must be initialized by calling Fabric.with(Context) " + str, null);
            return false;
        }
        return true;
    }

    public CrashlyticsCore(float f, CrashlyticsListener crashlyticsListener, PinningInfoProvider pinningInfoProvider, boolean z, ExecutorService executorService) {
        this.f4898n = null;
        this.f4899o = null;
        this.f4900p = null;
        this.f4901q = f;
        this.f4896k = crashlyticsListener == null ? new C0859f(null) : crashlyticsListener;
        this.f4903s = pinningInfoProvider;
        this.f4902r = z;
        this.f4905u = new CrashlyticsBackgroundWorker(executorService);
        this.f4893h = new ConcurrentHashMap<>();
        this.f4892g = System.currentTimeMillis();
    }

    /* renamed from: a */
    public void m5774a(Throwable th) {
        if (!this.f4902r && m5772b("prior to logging exceptions.")) {
            if (th == null) {
                Fabric.m4197h().mo4167a(5, "CrashlyticsCore", "Crashlytics is ignoring a request to log a null exception.");
            } else {
                this.f4897m.m5811b(Thread.currentThread(), th);
            }
        }
    }

    /* renamed from: a */
    public final void m5779a(int i, String str, String str2) {
        if (!this.f4902r && m5772b("prior to logging messages.")) {
            this.f4897m.m5856a(System.currentTimeMillis() - this.f4892g, m5771c(i, str, str2));
        }
    }

    /* renamed from: a */
    public void m5776a(String str) {
        if (!this.f4902r && m5772b("prior to setting user data.")) {
            this.f4898n = m5770c(str);
            this.f4897m.m5831a(this.f4898n, this.f4900p, this.f4899o);
        }
    }

    /* renamed from: a */
    public static boolean m5775a(String str, boolean z) {
        if (!z) {
            Fabric.m4197h().mo4157e("CrashlyticsCore", "Configured not to require a build ID.");
            return true;
        } else if (CommonUtils.m4085b(str)) {
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
