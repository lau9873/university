package p136d.p137a.p138a.p139a;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import io.fabric.sdk.android.services.concurrency.UnmetDependencyException;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.atomic.AtomicBoolean;
import p136d.p137a.p138a.p139a.ActivityLifecycleManager;
import p136d.p137a.p138a.p139a.p140m.p142b.IdManager;
import p136d.p137a.p138a.p139a.p140m.p143c.DependsOn;
import p136d.p137a.p138a.p139a.p140m.p143c.PriorityThreadPoolExecutor;

/* renamed from: d.a.a.a.c */
/* loaded from: classes.dex */
public class Fabric {

    /* renamed from: l */
    public static volatile Fabric f6364l;

    /* renamed from: m */
    public static final Logger f6365m = new DefaultLogger();

    /* renamed from: a */
    public final Context f6366a;

    /* renamed from: b */
    public final Map<Class<? extends Kit>, Kit> f6367b;

    /* renamed from: c */
    public final ExecutorService f6368c;

    /* renamed from: d */
    public final InitializationCallback<Fabric> f6369d;

    /* renamed from: e */
    public final InitializationCallback<?> f6370e;

    /* renamed from: f */
    public final IdManager f6371f;

    /* renamed from: g */
    public ActivityLifecycleManager f6372g;

    /* renamed from: h */
    public WeakReference<Activity> f6373h;

    /* renamed from: i */
    public AtomicBoolean f6374i = new AtomicBoolean(false);

    /* renamed from: j */
    public final Logger f6375j;

    /* renamed from: k */
    public final boolean f6376k;

    /* compiled from: Fabric.java */
    /* renamed from: d.a.a.a.c$a */
    /* loaded from: classes.dex */
    public class C1481a extends ActivityLifecycleManager.AbstractC1480b {
        public C1481a() {
        }

        @Override // p136d.p137a.p138a.p139a.ActivityLifecycleManager.AbstractC1480b
        /* renamed from: a */
        public void mo4194a(Activity activity, Bundle bundle) {
            Fabric.this.m4216a(activity);
        }

        @Override // p136d.p137a.p138a.p139a.ActivityLifecycleManager.AbstractC1480b
        /* renamed from: c */
        public void mo4193c(Activity activity) {
            Fabric.this.m4216a(activity);
        }

        @Override // p136d.p137a.p138a.p139a.ActivityLifecycleManager.AbstractC1480b
        /* renamed from: d */
        public void mo4192d(Activity activity) {
            Fabric.this.m4216a(activity);
        }
    }

    public Fabric(Context context, Map<Class<? extends Kit>, Kit> map, PriorityThreadPoolExecutor priorityThreadPoolExecutor, Handler handler, Logger logger, boolean z, InitializationCallback initializationCallback, IdManager idManager) {
        this.f6366a = context.getApplicationContext();
        this.f6367b = map;
        this.f6368c = priorityThreadPoolExecutor;
        this.f6375j = logger;
        this.f6376k = z;
        this.f6369d = initializationCallback;
        this.f6370e = m4217a(map.size());
        this.f6371f = idManager;
        m4216a(m4215a(context));
    }

    /* renamed from: c */
    public static void m4202c(Fabric fabric) {
        f6364l = fabric;
        fabric.m4198g();
    }

    /* renamed from: h */
    public static Logger m4197h() {
        if (f6364l == null) {
            return f6365m;
        }
        return f6364l.f6375j;
    }

    /* renamed from: i */
    public static boolean m4196i() {
        if (f6364l == null) {
            return false;
        }
        return f6364l.f6376k;
    }

    /* renamed from: j */
    public static Fabric m4195j() {
        if (f6364l != null) {
            return f6364l;
        }
        throw new IllegalStateException("Must Initialize Fabric before using singleton()");
    }

    /* renamed from: d */
    public String m4201d() {
        return "io.fabric.sdk.android:fabric";
    }

    /* renamed from: e */
    public Collection<Kit> m4200e() {
        return this.f6367b.values();
    }

    /* renamed from: f */
    public String m4199f() {
        return "1.3.16.dev";
    }

    /* renamed from: g */
    public final void m4198g() {
        this.f6372g = new ActivityLifecycleManager(this.f6366a);
        this.f6372g.m4229a(new C1481a());
        m4203c(this.f6366a);
    }

    /* renamed from: b */
    public Activity m4208b() {
        WeakReference<Activity> weakReference = this.f6373h;
        if (weakReference != null) {
            return weakReference.get();
        }
        return null;
    }

    /* compiled from: Fabric.java */
    /* renamed from: d.a.a.a.c$c */
    /* loaded from: classes.dex */
    public static class C1483c {

        /* renamed from: a */
        public final Context f6381a;

        /* renamed from: b */
        public Kit[] f6382b;

        /* renamed from: c */
        public PriorityThreadPoolExecutor f6383c;

        /* renamed from: d */
        public Handler f6384d;

        /* renamed from: e */
        public Logger f6385e;

        /* renamed from: f */
        public boolean f6386f;

        /* renamed from: g */
        public String f6387g;

        /* renamed from: h */
        public String f6388h;

        /* renamed from: i */
        public InitializationCallback<Fabric> f6389i;

        public C1483c(Context context) {
            if (context != null) {
                this.f6381a = context;
                return;
            }
            throw new IllegalArgumentException("Context must not be null.");
        }

        /* renamed from: a */
        public C1483c m4190a(Kit... kitArr) {
            if (this.f6382b == null) {
                this.f6382b = kitArr;
                return this;
            }
            throw new IllegalStateException("Kits already set.");
        }

        /* renamed from: a */
        public Fabric m4191a() {
            Map m4205b;
            if (this.f6383c == null) {
                this.f6383c = PriorityThreadPoolExecutor.m3966a();
            }
            if (this.f6384d == null) {
                this.f6384d = new Handler(Looper.getMainLooper());
            }
            if (this.f6385e == null) {
                if (this.f6386f) {
                    this.f6385e = new DefaultLogger(3);
                } else {
                    this.f6385e = new DefaultLogger();
                }
            }
            if (this.f6388h == null) {
                this.f6388h = this.f6381a.getPackageName();
            }
            if (this.f6389i == null) {
                this.f6389i = InitializationCallback.f6393a;
            }
            Kit[] kitArr = this.f6382b;
            if (kitArr != null) {
                m4205b = Fabric.m4205b(Arrays.asList(kitArr));
            } else {
                m4205b = new HashMap();
            }
            Map map = m4205b;
            return new Fabric(this.f6381a, map, this.f6383c, this.f6384d, this.f6385e, this.f6386f, this.f6389i, new IdManager(this.f6381a, this.f6388h, this.f6387g, map.values()));
        }
    }

    /* renamed from: a */
    public static Fabric m4214a(Context context, Kit... kitArr) {
        if (f6364l == null) {
            synchronized (Fabric.class) {
                if (f6364l == null) {
                    C1483c c1483c = new C1483c(context);
                    c1483c.m4190a(kitArr);
                    m4202c(c1483c.m4191a());
                }
            }
        }
        return f6364l;
    }

    /* renamed from: c */
    public void m4203c(Context context) {
        StringBuilder sb;
        Future<Map<String, KitInfo>> m4207b = m4207b(context);
        Collection<Kit> m4200e = m4200e();
        Onboarding onboarding = new Onboarding(m4207b, m4200e);
        ArrayList<Kit> arrayList = new ArrayList(m4200e);
        Collections.sort(arrayList);
        onboarding.m4183a(context, this, InitializationCallback.f6393a, this.f6371f);
        for (Kit kit : arrayList) {
            kit.m4183a(context, this, this.f6370e, this.f6371f);
        }
        onboarding.m4172m();
        if (m4197h().mo4165a("Fabric", 3)) {
            sb = new StringBuilder("Initializing ");
            sb.append(m4201d());
            sb.append(" [Version: ");
            sb.append(m4199f());
            sb.append("], with the following kits:\n");
        } else {
            sb = null;
        }
        for (Kit kit2 : arrayList) {
            kit2.f6396b.mo3970a(onboarding.f6396b);
            m4210a(this.f6367b, kit2);
            kit2.m4172m();
            if (sb != null) {
                sb.append(kit2.mo4149i());
                sb.append(" [Version: ");
                sb.append(kit2.mo4148k());
                sb.append("]\n");
            }
        }
        if (sb != null) {
            m4197h().mo4157e("Fabric", sb.toString());
        }
    }

    /* compiled from: Fabric.java */
    /* renamed from: d.a.a.a.c$b */
    /* loaded from: classes.dex */
    public class C1482b implements InitializationCallback {

        /* renamed from: b */
        public final CountDownLatch f6378b;

        /* renamed from: c */
        public final /* synthetic */ int f6379c;

        public C1482b(int i) {
            this.f6379c = i;
            this.f6378b = new CountDownLatch(this.f6379c);
        }

        @Override // p136d.p137a.p138a.p139a.InitializationCallback
        /* renamed from: a */
        public void mo4186a(Object obj) {
            this.f6378b.countDown();
            if (this.f6378b.getCount() == 0) {
                Fabric.this.f6374i.set(true);
                Fabric.this.f6369d.mo4186a((InitializationCallback) Fabric.this);
            }
        }

        @Override // p136d.p137a.p138a.p139a.InitializationCallback
        /* renamed from: a */
        public void mo4187a(Exception exc) {
            Fabric.this.f6369d.mo4187a(exc);
        }
    }

    /* renamed from: b */
    public static Map<Class<? extends Kit>, Kit> m4205b(Collection<? extends Kit> collection) {
        HashMap hashMap = new HashMap(collection.size());
        m4209a(hashMap, collection);
        return hashMap;
    }

    /* renamed from: b */
    public Future<Map<String, KitInfo>> m4207b(Context context) {
        return m4204c().submit(new FabricKitsFinder(context.getPackageCodePath()));
    }

    /* renamed from: a */
    public Fabric m4216a(Activity activity) {
        this.f6373h = new WeakReference<>(activity);
        return this;
    }

    /* renamed from: a */
    public void m4210a(Map<Class<? extends Kit>, Kit> map, Kit kit) {
        Class<?>[] value;
        DependsOn dependsOn = kit.f6400f;
        if (dependsOn != null) {
            for (Class<?> cls : dependsOn.value()) {
                if (cls.isInterface()) {
                    for (Kit kit2 : map.values()) {
                        if (cls.isAssignableFrom(kit2.getClass())) {
                            kit.f6396b.mo3970a(kit2.f6396b);
                        }
                    }
                } else if (map.get(cls) != null) {
                    kit.f6396b.mo3970a(map.get(cls).f6396b);
                } else {
                    throw new UnmetDependencyException("Referenced Kit was null, does the kit exist?");
                }
            }
        }
    }

    /* renamed from: a */
    public final Activity m4215a(Context context) {
        if (context instanceof Activity) {
            return (Activity) context;
        }
        return null;
    }

    /* renamed from: a */
    public ActivityLifecycleManager m4218a() {
        return this.f6372g;
    }

    /* renamed from: a */
    public static <T extends Kit> T m4212a(Class<T> cls) {
        return (T) m4195j().f6367b.get(cls);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: a */
    public static void m4209a(Map<Class<? extends Kit>, Kit> map, Collection<? extends Kit> collection) {
        for (Kit kit : collection) {
            map.put(kit.getClass(), kit);
            if (kit instanceof KitGroup) {
                m4209a(map, ((KitGroup) kit).mo4171b());
            }
        }
    }

    /* renamed from: c */
    public ExecutorService m4204c() {
        return this.f6368c;
    }

    /* renamed from: a */
    public InitializationCallback<?> m4217a(int i) {
        return new C1482b(i);
    }
}
