package d.a.a.a;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import d.a.a.a.a;
import d.a.a.a.m.b.o;
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
/* compiled from: Fabric.java */
/* loaded from: classes.dex */
public class c {
    public static volatile c l;
    public static final k m = new d.a.a.a.b();

    /* renamed from: a  reason: collision with root package name */
    public final Context f4185a;

    /* renamed from: b  reason: collision with root package name */
    public final Map<Class<? extends h>, h> f4186b;

    /* renamed from: c  reason: collision with root package name */
    public final ExecutorService f4187c;

    /* renamed from: d  reason: collision with root package name */
    public final f<c> f4188d;

    /* renamed from: e  reason: collision with root package name */
    public final f<?> f4189e;

    /* renamed from: f  reason: collision with root package name */
    public final o f4190f;

    /* renamed from: g  reason: collision with root package name */
    public d.a.a.a.a f4191g;

    /* renamed from: h  reason: collision with root package name */
    public WeakReference<Activity> f4192h;

    /* renamed from: i  reason: collision with root package name */
    public AtomicBoolean f4193i = new AtomicBoolean(false);
    public final k j;
    public final boolean k;

    /* compiled from: Fabric.java */
    /* loaded from: classes.dex */
    public class a extends a.b {
        public a() {
        }

        @Override // d.a.a.a.a.b
        public void a(Activity activity, Bundle bundle) {
            c.this.a(activity);
        }

        @Override // d.a.a.a.a.b
        public void c(Activity activity) {
            c.this.a(activity);
        }

        @Override // d.a.a.a.a.b
        public void d(Activity activity) {
            c.this.a(activity);
        }
    }

    public c(Context context, Map<Class<? extends h>, h> map, d.a.a.a.m.c.l lVar, Handler handler, k kVar, boolean z, f fVar, o oVar) {
        this.f4185a = context.getApplicationContext();
        this.f4186b = map;
        this.f4187c = lVar;
        this.j = kVar;
        this.k = z;
        this.f4188d = fVar;
        this.f4189e = a(map.size());
        this.f4190f = oVar;
        a(a(context));
    }

    public static void c(c cVar) {
        l = cVar;
        cVar.g();
    }

    public static k h() {
        if (l == null) {
            return m;
        }
        return l.j;
    }

    public static boolean i() {
        if (l == null) {
            return false;
        }
        return l.k;
    }

    public static c j() {
        if (l != null) {
            return l;
        }
        throw new IllegalStateException("Must Initialize Fabric before using singleton()");
    }

    public String d() {
        return "io.fabric.sdk.android:fabric";
    }

    public Collection<h> e() {
        return this.f4186b.values();
    }

    public String f() {
        return "1.3.16.dev";
    }

    public final void g() {
        this.f4191g = new d.a.a.a.a(this.f4185a);
        this.f4191g.a(new a());
        c(this.f4185a);
    }

    public Activity b() {
        WeakReference<Activity> weakReference = this.f4192h;
        if (weakReference != null) {
            return weakReference.get();
        }
        return null;
    }

    /* compiled from: Fabric.java */
    /* renamed from: d.a.a.a.c$c  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0086c {

        /* renamed from: a  reason: collision with root package name */
        public final Context f4198a;

        /* renamed from: b  reason: collision with root package name */
        public h[] f4199b;

        /* renamed from: c  reason: collision with root package name */
        public d.a.a.a.m.c.l f4200c;

        /* renamed from: d  reason: collision with root package name */
        public Handler f4201d;

        /* renamed from: e  reason: collision with root package name */
        public k f4202e;

        /* renamed from: f  reason: collision with root package name */
        public boolean f4203f;

        /* renamed from: g  reason: collision with root package name */
        public String f4204g;

        /* renamed from: h  reason: collision with root package name */
        public String f4205h;

        /* renamed from: i  reason: collision with root package name */
        public f<c> f4206i;

        public C0086c(Context context) {
            if (context != null) {
                this.f4198a = context;
                return;
            }
            throw new IllegalArgumentException("Context must not be null.");
        }

        public C0086c a(h... hVarArr) {
            if (this.f4199b == null) {
                this.f4199b = hVarArr;
                return this;
            }
            throw new IllegalStateException("Kits already set.");
        }

        public c a() {
            Map b2;
            if (this.f4200c == null) {
                this.f4200c = d.a.a.a.m.c.l.a();
            }
            if (this.f4201d == null) {
                this.f4201d = new Handler(Looper.getMainLooper());
            }
            if (this.f4202e == null) {
                if (this.f4203f) {
                    this.f4202e = new d.a.a.a.b(3);
                } else {
                    this.f4202e = new d.a.a.a.b();
                }
            }
            if (this.f4205h == null) {
                this.f4205h = this.f4198a.getPackageName();
            }
            if (this.f4206i == null) {
                this.f4206i = f.f4210a;
            }
            h[] hVarArr = this.f4199b;
            if (hVarArr != null) {
                b2 = c.b(Arrays.asList(hVarArr));
            } else {
                b2 = new HashMap();
            }
            Map map = b2;
            return new c(this.f4198a, map, this.f4200c, this.f4201d, this.f4202e, this.f4203f, this.f4206i, new o(this.f4198a, this.f4205h, this.f4204g, map.values()));
        }
    }

    public static c a(Context context, h... hVarArr) {
        if (l == null) {
            synchronized (c.class) {
                if (l == null) {
                    C0086c c0086c = new C0086c(context);
                    c0086c.a(hVarArr);
                    c(c0086c.a());
                }
            }
        }
        return l;
    }

    public void c(Context context) {
        StringBuilder sb;
        Future<Map<String, j>> b2 = b(context);
        Collection<h> e2 = e();
        l lVar = new l(b2, e2);
        ArrayList<h> arrayList = new ArrayList(e2);
        Collections.sort(arrayList);
        lVar.a(context, this, f.f4210a, this.f4190f);
        for (h hVar : arrayList) {
            hVar.a(context, this, this.f4189e, this.f4190f);
        }
        lVar.m();
        if (h().a("Fabric", 3)) {
            sb = new StringBuilder("Initializing ");
            sb.append(d());
            sb.append(" [Version: ");
            sb.append(f());
            sb.append("], with the following kits:\n");
        } else {
            sb = null;
        }
        for (h hVar2 : arrayList) {
            hVar2.f4212b.a(lVar.f4212b);
            a(this.f4186b, hVar2);
            hVar2.m();
            if (sb != null) {
                sb.append(hVar2.i());
                sb.append(" [Version: ");
                sb.append(hVar2.k());
                sb.append("]\n");
            }
        }
        if (sb != null) {
            h().e("Fabric", sb.toString());
        }
    }

    /* compiled from: Fabric.java */
    /* loaded from: classes.dex */
    public class b implements f {

        /* renamed from: b  reason: collision with root package name */
        public final CountDownLatch f4195b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ int f4196c;

        public b(int i2) {
            this.f4196c = i2;
            this.f4195b = new CountDownLatch(this.f4196c);
        }

        @Override // d.a.a.a.f
        public void a(Object obj) {
            this.f4195b.countDown();
            if (this.f4195b.getCount() == 0) {
                c.this.f4193i.set(true);
                c.this.f4188d.a((f) c.this);
            }
        }

        @Override // d.a.a.a.f
        public void a(Exception exc) {
            c.this.f4188d.a(exc);
        }
    }

    public static Map<Class<? extends h>, h> b(Collection<? extends h> collection) {
        HashMap hashMap = new HashMap(collection.size());
        a(hashMap, collection);
        return hashMap;
    }

    public Future<Map<String, j>> b(Context context) {
        return c().submit(new e(context.getPackageCodePath()));
    }

    public c a(Activity activity) {
        this.f4192h = new WeakReference<>(activity);
        return this;
    }

    public void a(Map<Class<? extends h>, h> map, h hVar) {
        Class<?>[] value;
        d.a.a.a.m.c.e eVar = hVar.f4216f;
        if (eVar != null) {
            for (Class<?> cls : eVar.value()) {
                if (cls.isInterface()) {
                    for (h hVar2 : map.values()) {
                        if (cls.isAssignableFrom(hVar2.getClass())) {
                            hVar.f4212b.a(hVar2.f4212b);
                        }
                    }
                } else if (map.get(cls) != null) {
                    hVar.f4212b.a(map.get(cls).f4212b);
                } else {
                    throw new UnmetDependencyException("Referenced Kit was null, does the kit exist?");
                }
            }
        }
    }

    public final Activity a(Context context) {
        if (context instanceof Activity) {
            return (Activity) context;
        }
        return null;
    }

    public d.a.a.a.a a() {
        return this.f4191g;
    }

    public static <T extends h> T a(Class<T> cls) {
        return (T) j().f4186b.get(cls);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void a(Map<Class<? extends h>, h> map, Collection<? extends h> collection) {
        for (h hVar : collection) {
            map.put(hVar.getClass(), hVar);
            if (hVar instanceof i) {
                a(map, ((i) hVar).b());
            }
        }
    }

    public ExecutorService c() {
        return this.f4187c;
    }

    public f<?> a(int i2) {
        return new b(i2);
    }
}
