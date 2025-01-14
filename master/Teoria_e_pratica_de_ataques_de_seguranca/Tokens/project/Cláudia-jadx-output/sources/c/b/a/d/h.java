package c.b.a.d;

import android.app.Activity;
import android.app.ActivityManager;
import android.content.Context;
import android.os.Build;
import android.os.Environment;
import android.os.StatFs;
import c.b.a.d.f;
import c.b.a.d.f0;
import c.b.a.d.m;
import c.b.a.d.u;
import d.a.a.a.m.b.j;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FilenameFilter;
import java.io.Flushable;
import java.io.IOException;
import java.io.InputStream;
import java.lang.Thread;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
/* compiled from: CrashlyticsController.java */
/* loaded from: classes.dex */
public class h {
    public static final FilenameFilter q = new f();
    public static final Comparator<File> r = new g();
    public static final Comparator<File> s = new C0056h();
    public static final Pattern t;
    public static final Map<String, String> u;
    public static final String[] v;

    /* renamed from: a  reason: collision with root package name */
    public final AtomicInteger f3018a = new AtomicInteger(0);

    /* renamed from: b  reason: collision with root package name */
    public final c.b.a.d.i f3019b;

    /* renamed from: c  reason: collision with root package name */
    public final c.b.a.d.g f3020c;

    /* renamed from: d  reason: collision with root package name */
    public final d.a.a.a.m.e.d f3021d;

    /* renamed from: e  reason: collision with root package name */
    public final d.a.a.a.m.b.o f3022e;

    /* renamed from: f  reason: collision with root package name */
    public final b0 f3023f;

    /* renamed from: g  reason: collision with root package name */
    public final d.a.a.a.m.f.a f3024g;

    /* renamed from: h  reason: collision with root package name */
    public final c.b.a.d.a f3025h;

    /* renamed from: i  reason: collision with root package name */
    public final r f3026i;
    public final c.b.a.d.u j;
    public final f0.c k;
    public final f0.b l;
    public final c.b.a.d.q m;
    public final i0 n;
    public final String o;
    public c.b.a.d.m p;

    /* compiled from: CrashlyticsController.java */
    /* loaded from: classes.dex */
    public class a implements Callable<Void> {
        public a() {
        }

        @Override // java.util.concurrent.Callable
        public Void call() {
            h.this.b();
            return null;
        }
    }

    /* compiled from: CrashlyticsController.java */
    /* loaded from: classes.dex */
    public class b implements Callable<Boolean> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d.a.a.a.m.g.q f3028a;

        public b(d.a.a.a.m.g.q qVar) {
            this.f3028a = qVar;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // java.util.concurrent.Callable
        public Boolean call() {
            if (h.this.i()) {
                d.a.a.a.c.h().e("CrashlyticsCore", "Skipping session finalization because a crash has already occurred.");
                return Boolean.FALSE;
            }
            d.a.a.a.c.h().e("CrashlyticsCore", "Finalizing previously open sessions.");
            h.this.a(this.f3028a, true);
            d.a.a.a.c.h().e("CrashlyticsCore", "Closed all previously open sessions");
            return Boolean.TRUE;
        }
    }

    /* compiled from: CrashlyticsController.java */
    /* loaded from: classes.dex */
    public class c implements Runnable {
        public c() {
        }

        @Override // java.lang.Runnable
        public void run() {
            h hVar = h.this;
            hVar.a(hVar.a(new q()));
        }
    }

    /* compiled from: CrashlyticsController.java */
    /* loaded from: classes.dex */
    public class d implements FilenameFilter {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ Set f3031a;

        public d(h hVar, Set set) {
            this.f3031a = set;
        }

        @Override // java.io.FilenameFilter
        public boolean accept(File file, String str) {
            if (str.length() < 35) {
                return false;
            }
            return this.f3031a.contains(str.substring(0, 35));
        }
    }

    /* compiled from: CrashlyticsController.java */
    /* loaded from: classes.dex */
    public class e implements Callable<Void> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ c.b.a.d.o0.b.d f3032a;

        public e(c.b.a.d.o0.b.d dVar) {
            this.f3032a = dVar;
        }

        @Override // java.util.concurrent.Callable
        public Void call() {
            if (h.this.i()) {
                return null;
            }
            h.this.a(this.f3032a);
            return null;
        }
    }

    /* compiled from: CrashlyticsController.java */
    /* loaded from: classes.dex */
    public static class f implements FilenameFilter {
        @Override // java.io.FilenameFilter
        public boolean accept(File file, String str) {
            return str.length() == 39 && str.endsWith(".cls");
        }
    }

    /* compiled from: CrashlyticsController.java */
    /* loaded from: classes.dex */
    public static class g implements Comparator<File> {
        @Override // java.util.Comparator
        /* renamed from: a */
        public int compare(File file, File file2) {
            return file2.getName().compareTo(file.getName());
        }
    }

    /* compiled from: CrashlyticsController.java */
    /* renamed from: c.b.a.d.h$h  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0056h implements Comparator<File> {
        @Override // java.util.Comparator
        /* renamed from: a */
        public int compare(File file, File file2) {
            return file.getName().compareTo(file2.getName());
        }
    }

    /* compiled from: CrashlyticsController.java */
    /* loaded from: classes.dex */
    public static class i implements FilenameFilter {
        @Override // java.io.FilenameFilter
        public boolean accept(File file, String str) {
            return h.t.matcher(str).matches();
        }
    }

    /* compiled from: CrashlyticsController.java */
    /* loaded from: classes.dex */
    public class j implements m.a {
        public j() {
        }

        @Override // c.b.a.d.m.a
        public void a(Thread thread, Throwable th) {
            h.this.a(thread, th);
        }
    }

    /* compiled from: CrashlyticsController.java */
    /* loaded from: classes.dex */
    public class k implements Callable<Void> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ Date f3035a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ Thread f3036b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ Throwable f3037c;

        public k(Date date, Thread thread, Throwable th) {
            this.f3035a = date;
            this.f3036b = thread;
            this.f3037c = th;
        }

        @Override // java.util.concurrent.Callable
        public Void call() {
            h.this.f3019b.p();
            h.this.b(this.f3035a, this.f3036b, this.f3037c);
            d.a.a.a.m.g.u a2 = d.a.a.a.m.g.r.d().a();
            d.a.a.a.m.g.q qVar = a2 != null ? a2.f4452b : null;
            h.this.a(qVar);
            h.this.b();
            if (qVar != null) {
                h.this.b(qVar.f4441b);
            }
            if (!h.this.b(a2)) {
                h.this.a(a2);
            }
            return null;
        }
    }

    /* compiled from: CrashlyticsController.java */
    /* loaded from: classes.dex */
    public class l implements Callable<Void> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ long f3039a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ String f3040b;

        public l(long j, String str) {
            this.f3039a = j;
            this.f3040b = str;
        }

        @Override // java.util.concurrent.Callable
        public Void call() {
            if (h.this.i()) {
                return null;
            }
            h.this.j.a(this.f3039a, this.f3040b);
            return null;
        }
    }

    /* compiled from: CrashlyticsController.java */
    /* loaded from: classes.dex */
    public class m implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ Date f3042a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ Thread f3043b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ Throwable f3044c;

        public m(Date date, Thread thread, Throwable th) {
            this.f3042a = date;
            this.f3043b = thread;
            this.f3044c = th;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (h.this.i()) {
                return;
            }
            h.this.a(this.f3042a, this.f3043b, this.f3044c);
        }
    }

    /* compiled from: CrashlyticsController.java */
    /* loaded from: classes.dex */
    public class n implements Callable<Void> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ String f3046a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ String f3047b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ String f3048c;

        public n(String str, String str2, String str3) {
            this.f3046a = str;
            this.f3047b = str2;
            this.f3048c = str3;
        }

        @Override // java.util.concurrent.Callable
        public Void call() {
            new c.b.a.d.w(h.this.e()).a(h.this.c(), new l0(this.f3046a, this.f3047b, this.f3048c));
            return null;
        }
    }

    /* compiled from: CrashlyticsController.java */
    /* loaded from: classes.dex */
    public static class o implements FilenameFilter {
        public o() {
        }

        @Override // java.io.FilenameFilter
        public boolean accept(File file, String str) {
            return !h.q.accept(file, str) && h.t.matcher(str).matches();
        }

        public /* synthetic */ o(f fVar) {
            this();
        }
    }

    /* compiled from: CrashlyticsController.java */
    /* loaded from: classes.dex */
    public static class p implements FilenameFilter {

        /* renamed from: a  reason: collision with root package name */
        public final String f3050a;

        public p(String str) {
            this.f3050a = str;
        }

        @Override // java.io.FilenameFilter
        public boolean accept(File file, String str) {
            return str.contains(this.f3050a) && !str.endsWith(".cls_temp");
        }
    }

    /* compiled from: CrashlyticsController.java */
    /* loaded from: classes.dex */
    public static class q implements FilenameFilter {
        @Override // java.io.FilenameFilter
        public boolean accept(File file, String str) {
            return c.b.a.d.d.f2985d.accept(file, str) || str.contains("SessionMissingBinaryImages");
        }
    }

    /* compiled from: CrashlyticsController.java */
    /* loaded from: classes.dex */
    public static final class r implements u.b {

        /* renamed from: a  reason: collision with root package name */
        public final d.a.a.a.m.f.a f3051a;

        public r(d.a.a.a.m.f.a aVar) {
            this.f3051a = aVar;
        }

        @Override // c.b.a.d.u.b
        public File a() {
            File file = new File(this.f3051a.a(), "log-files");
            if (!file.exists()) {
                file.mkdirs();
            }
            return file;
        }
    }

    /* compiled from: CrashlyticsController.java */
    /* loaded from: classes.dex */
    public static final class s implements f0.d {

        /* renamed from: a  reason: collision with root package name */
        public final d.a.a.a.h f3052a;

        /* renamed from: b  reason: collision with root package name */
        public final b0 f3053b;

        /* renamed from: c  reason: collision with root package name */
        public final d.a.a.a.m.g.p f3054c;

        /* compiled from: CrashlyticsController.java */
        /* loaded from: classes.dex */
        public class a implements f.d {
            public a() {
            }

            @Override // c.b.a.d.f.d
            public void a(boolean z) {
                s.this.f3053b.a(z);
            }
        }

        /* compiled from: CrashlyticsController.java */
        /* loaded from: classes.dex */
        public class b implements Runnable {

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ c.b.a.d.f f3056a;

            public b(s sVar, c.b.a.d.f fVar) {
                this.f3056a = fVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                this.f3056a.c();
            }
        }

        public s(d.a.a.a.h hVar, b0 b0Var, d.a.a.a.m.g.p pVar) {
            this.f3052a = hVar;
            this.f3053b = b0Var;
            this.f3054c = pVar;
        }

        @Override // c.b.a.d.f0.d
        public boolean a() {
            Activity b2 = this.f3052a.g().b();
            if (b2 == null || b2.isFinishing()) {
                return true;
            }
            c.b.a.d.f a2 = c.b.a.d.f.a(b2, this.f3054c, new a());
            b2.runOnUiThread(new b(this, a2));
            d.a.a.a.c.h().e("CrashlyticsCore", "Waiting for user opt-in.");
            a2.a();
            return a2.b();
        }
    }

    /* compiled from: CrashlyticsController.java */
    /* loaded from: classes.dex */
    public final class t implements f0.c {
        public t() {
        }

        @Override // c.b.a.d.f0.c
        public File[] a() {
            return h.this.f().listFiles();
        }

        @Override // c.b.a.d.f0.c
        public File[] b() {
            return h.this.j();
        }

        public /* synthetic */ t(h hVar, f fVar) {
            this();
        }
    }

    /* compiled from: CrashlyticsController.java */
    /* loaded from: classes.dex */
    public final class u implements f0.b {
        public u() {
        }

        @Override // c.b.a.d.f0.b
        public boolean a() {
            return h.this.i();
        }

        public /* synthetic */ u(h hVar, f fVar) {
            this();
        }
    }

    /* compiled from: CrashlyticsController.java */
    /* loaded from: classes.dex */
    public static final class v implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        public final Context f3059a;

        /* renamed from: b  reason: collision with root package name */
        public final e0 f3060b;

        /* renamed from: c  reason: collision with root package name */
        public final f0 f3061c;

        public v(Context context, e0 e0Var, f0 f0Var) {
            this.f3059a = context;
            this.f3060b = e0Var;
            this.f3061c = f0Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (d.a.a.a.m.b.i.b(this.f3059a)) {
                d.a.a.a.c.h().e("CrashlyticsCore", "Attempting to send crash report at time of crash...");
                this.f3061c.a(this.f3060b);
            }
        }
    }

    /* compiled from: CrashlyticsController.java */
    /* loaded from: classes.dex */
    public static class w implements FilenameFilter {

        /* renamed from: a  reason: collision with root package name */
        public final String f3062a;

        public w(String str) {
            this.f3062a = str;
        }

        @Override // java.io.FilenameFilter
        public boolean accept(File file, String str) {
            StringBuilder sb = new StringBuilder();
            sb.append(this.f3062a);
            sb.append(".cls");
            return (str.equals(sb.toString()) || !str.contains(this.f3062a) || str.endsWith(".cls_temp")) ? false : true;
        }
    }

    static {
        new i();
        t = Pattern.compile("([\\d|A-Z|a-z]{12}\\-[\\d|A-Z|a-z]{4}\\-[\\d|A-Z|a-z]{4}\\-[\\d|A-Z|a-z]{12}).+");
        u = Collections.singletonMap("X-CRASHLYTICS-SEND-FLAGS", "1");
        v = new String[]{"SessionUser", "SessionApp", "SessionOS", "SessionDevice"};
    }

    public h(c.b.a.d.i iVar, c.b.a.d.g gVar, d.a.a.a.m.e.d dVar, d.a.a.a.m.b.o oVar, b0 b0Var, d.a.a.a.m.f.a aVar, c.b.a.d.a aVar2, k0 k0Var) {
        this.f3019b = iVar;
        this.f3020c = gVar;
        this.f3021d = dVar;
        this.f3022e = oVar;
        this.f3023f = b0Var;
        this.f3024g = aVar;
        this.f3025h = aVar2;
        this.o = k0Var.a();
        Context e2 = iVar.e();
        this.f3026i = new r(aVar);
        this.j = new c.b.a.d.u(e2, this.f3026i);
        this.k = new t(this, null);
        this.l = new u(this, null);
        this.m = new c.b.a.d.q(e2);
        this.n = new x(1024, new d0(10));
    }

    public final File[] b(File[] fileArr) {
        return fileArr == null ? new File[0] : fileArr;
    }

    public final void e(String str) {
        c.b.a.d.d dVar;
        Throwable th;
        c.b.a.d.e eVar;
        try {
            dVar = new c.b.a.d.d(e(), str + "SessionApp");
            try {
                eVar = c.b.a.d.e.a(dVar);
                try {
                    g0.a(eVar, this.f3022e.e(), this.f3025h.f2969a, this.f3025h.f2973e, this.f3025h.f2974f, this.f3022e.f(), d.a.a.a.m.b.l.a(this.f3025h.f2971c).b(), this.o);
                    d.a.a.a.m.b.i.a(eVar, "Failed to flush to session app file.");
                    d.a.a.a.m.b.i.a((Closeable) dVar, "Failed to close session app file.");
                } catch (Throwable th2) {
                    th = th2;
                    d.a.a.a.m.b.i.a(eVar, "Failed to flush to session app file.");
                    d.a.a.a.m.b.i.a((Closeable) dVar, "Failed to close session app file.");
                    throw th;
                }
            } catch (Throwable th3) {
                th = th3;
                eVar = null;
            }
        } catch (Throwable th4) {
            dVar = null;
            th = th4;
            eVar = null;
        }
    }

    public final void f(String str) {
        c.b.a.d.d dVar;
        c.b.a.d.e eVar = null;
        try {
            dVar = new c.b.a.d.d(e(), str + "SessionDevice");
            try {
                eVar = c.b.a.d.e.a(dVar);
                Context e2 = this.f3019b.e();
                StatFs statFs = new StatFs(Environment.getDataDirectory().getPath());
                g0.a(eVar, this.f3022e.h(), d.a.a.a.m.b.i.a(), Build.MODEL, Runtime.getRuntime().availableProcessors(), d.a.a.a.m.b.i.b(), statFs.getBlockCount() * statFs.getBlockSize(), d.a.a.a.m.b.i.l(e2), this.f3022e.g(), d.a.a.a.m.b.i.f(e2), Build.MANUFACTURER, Build.PRODUCT);
                d.a.a.a.m.b.i.a(eVar, "Failed to flush session device info.");
                d.a.a.a.m.b.i.a((Closeable) dVar, "Failed to close session device file.");
            } catch (Throwable th) {
                th = th;
                d.a.a.a.m.b.i.a(eVar, "Failed to flush session device info.");
                d.a.a.a.m.b.i.a((Closeable) dVar, "Failed to close session device file.");
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
            dVar = null;
        }
    }

    public final void g(String str) {
        c.b.a.d.d dVar;
        c.b.a.d.e eVar = null;
        try {
            dVar = new c.b.a.d.d(e(), str + "SessionOS");
            try {
                eVar = c.b.a.d.e.a(dVar);
                g0.a(eVar, d.a.a.a.m.b.i.m(this.f3019b.e()));
                d.a.a.a.m.b.i.a(eVar, "Failed to flush to session OS file.");
                d.a.a.a.m.b.i.a((Closeable) dVar, "Failed to close session OS file.");
            } catch (Throwable th) {
                th = th;
                d.a.a.a.m.b.i.a(eVar, "Failed to flush to session OS file.");
                d.a.a.a.m.b.i.a((Closeable) dVar, "Failed to close session OS file.");
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
            dVar = null;
        }
    }

    public final String h() {
        File[] l2 = l();
        if (l2.length > 1) {
            return b(l2[1]);
        }
        return null;
    }

    public boolean i() {
        c.b.a.d.m mVar = this.p;
        return mVar != null && mVar.a();
    }

    public File[] j() {
        LinkedList linkedList = new LinkedList();
        Collections.addAll(linkedList, a(d(), q));
        Collections.addAll(linkedList, a(g(), q));
        Collections.addAll(linkedList, a(e(), q));
        return (File[]) linkedList.toArray(new File[linkedList.size()]);
    }

    public File[] k() {
        return a(new p("BeginSession"));
    }

    public final File[] l() {
        File[] k2 = k();
        Arrays.sort(k2, r);
        return k2;
    }

    public void m() {
        this.f3020c.a(new a());
    }

    public final void n() {
        File f2 = f();
        if (f2.exists()) {
            File[] a2 = a(f2, new q());
            Arrays.sort(a2, Collections.reverseOrder());
            HashSet hashSet = new HashSet();
            for (int i2 = 0; i2 < a2.length && hashSet.size() < 4; i2++) {
                hashSet.add(b(a2[i2]));
            }
            a(a(f2), hashSet);
        }
    }

    public final String c() {
        File[] l2 = l();
        if (l2.length > 0) {
            return b(l2[0]);
        }
        return null;
    }

    public final File[] d(String str) {
        return a(new w(str));
    }

    public File d() {
        return new File(e(), "fatal-sessions");
    }

    public void b(Thread thread, Throwable th) {
        this.f3020c.a(new m(new Date(), thread, th));
    }

    public final void h(String str) {
        c.b.a.d.d dVar;
        c.b.a.d.e eVar = null;
        try {
            dVar = new c.b.a.d.d(e(), str + "SessionUser");
            try {
                eVar = c.b.a.d.e.a(dVar);
                l0 c2 = c(str);
                if (c2.a()) {
                    d.a.a.a.m.b.i.a(eVar, "Failed to flush session user file.");
                    d.a.a.a.m.b.i.a((Closeable) dVar, "Failed to close session user file.");
                    return;
                }
                g0.a(eVar, c2.f3082a, c2.f3083b, c2.f3084c);
                d.a.a.a.m.b.i.a(eVar, "Failed to flush session user file.");
                d.a.a.a.m.b.i.a((Closeable) dVar, "Failed to close session user file.");
            } catch (Throwable th) {
                th = th;
                d.a.a.a.m.b.i.a(eVar, "Failed to flush session user file.");
                d.a.a.a.m.b.i.a((Closeable) dVar, "Failed to close session user file.");
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
            dVar = null;
        }
    }

    public final l0 c(String str) {
        if (i()) {
            return new l0(this.f3019b.v(), this.f3019b.w(), this.f3019b.u());
        }
        return new c.b.a.d.w(e()).d(str);
    }

    public static String b(File file) {
        return file.getName().substring(0, 35);
    }

    public void a(Thread.UncaughtExceptionHandler uncaughtExceptionHandler) {
        m();
        this.p = new c.b.a.d.m(new j(), uncaughtExceptionHandler);
        Thread.setDefaultUncaughtExceptionHandler(this.p);
    }

    public boolean b(d.a.a.a.m.g.q qVar) {
        return ((Boolean) this.f3020c.b(new b(qVar))).booleanValue();
    }

    public final void b() {
        Date date = new Date();
        String cVar = new c.b.a.d.c(this.f3022e).toString();
        d.a.a.a.k h2 = d.a.a.a.c.h();
        h2.e("CrashlyticsCore", "Opening a new session with ID " + cVar);
        a(cVar, date);
        e(cVar);
        g(cVar);
        f(cVar);
        this.j.b(cVar);
    }

    public File g() {
        return new File(e(), "nonfatal-sessions");
    }

    public synchronized void a(Thread thread, Throwable th) {
        d.a.a.a.k h2 = d.a.a.a.c.h();
        h2.e("CrashlyticsCore", "Crashlytics is handling uncaught exception \"" + th + "\" from thread " + thread.getName());
        this.m.a();
        this.f3020c.b(new k(new Date(), thread, th));
    }

    public File e() {
        return this.f3024g.a();
    }

    public void b(int i2) {
        int a2 = i2 - m0.a(d(), i2, s);
        m0.a(e(), q, a2 - m0.a(g(), a2, s), s);
    }

    public void a(float f2, d.a.a.a.m.g.u uVar) {
        if (uVar == null) {
            d.a.a.a.c.h().a("CrashlyticsCore", "Could not send reports. Settings are not available.");
            return;
        }
        new f0(this.f3025h.f2969a, b(uVar.f4451a.f4414c), this.k, this.l).a(f2, b(uVar) ? new s(this.f3019b, this.f3023f, uVar.f4453c) : new f0.a());
    }

    public final void b(Date date, Thread thread, Throwable th) {
        c.b.a.d.d dVar;
        String c2;
        c.b.a.d.e eVar = null;
        try {
            try {
                c2 = c();
            } catch (Throwable th2) {
                th = th2;
                d.a.a.a.m.b.i.a(eVar, "Failed to flush to session begin file.");
                d.a.a.a.m.b.i.a((Closeable) dVar, "Failed to close fatal exception file output stream.");
                throw th;
            }
        } catch (Exception e2) {
            e = e2;
            dVar = null;
        } catch (Throwable th3) {
            th = th3;
            dVar = null;
            d.a.a.a.m.b.i.a(eVar, "Failed to flush to session begin file.");
            d.a.a.a.m.b.i.a((Closeable) dVar, "Failed to close fatal exception file output stream.");
            throw th;
        }
        if (c2 == null) {
            d.a.a.a.c.h().c("CrashlyticsCore", "Tried to write a fatal exception while no session was open.", null);
            d.a.a.a.m.b.i.a((Flushable) null, "Failed to flush to session begin file.");
            d.a.a.a.m.b.i.a((Closeable) null, "Failed to close fatal exception file output stream.");
            return;
        }
        a(c2, th.getClass().getName());
        dVar = new c.b.a.d.d(e(), c2 + "SessionCrash");
        try {
            eVar = c.b.a.d.e.a(dVar);
            a(eVar, date, thread, th, "crash", true);
        } catch (Exception e3) {
            e = e3;
            d.a.a.a.c.h().c("CrashlyticsCore", "An error occurred in the fatal exception logger", e);
            d.a.a.a.m.b.i.a(eVar, "Failed to flush to session begin file.");
            d.a.a.a.m.b.i.a((Closeable) dVar, "Failed to close fatal exception file output stream.");
        }
        d.a.a.a.m.b.i.a(eVar, "Failed to flush to session begin file.");
        d.a.a.a.m.b.i.a((Closeable) dVar, "Failed to close fatal exception file output stream.");
    }

    public File f() {
        return new File(e(), "invalidClsFiles");
    }

    public void a(long j2, String str) {
        this.f3020c.a(new l(j2, str));
    }

    public void a(String str, String str2, String str3) {
        this.f3020c.a(new n(str, str2, str3));
    }

    public void a(d.a.a.a.m.g.q qVar) {
        a(qVar, false);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void a(d.a.a.a.m.g.q qVar, boolean z) {
        a((z ? 1 : 0) + 8);
        File[] l2 = l();
        if (l2.length <= z) {
            d.a.a.a.c.h().e("CrashlyticsCore", "No open sessions to be closed.");
            return;
        }
        h(b(l2[z ? 1 : 0]));
        if (qVar == null) {
            d.a.a.a.c.h().e("CrashlyticsCore", "Unable to close session. Settings are not loaded.");
            return;
        }
        a(l2, z ? 1 : 0, qVar.f4440a);
    }

    public void b(c.b.a.d.o0.b.d dVar) {
        this.f3020c.a(new e(dVar));
    }

    public final boolean b(d.a.a.a.m.g.u uVar) {
        return (uVar == null || !uVar.f4454d.f4426a || this.f3023f.a()) ? false : true;
    }

    public final c.b.a.d.o b(String str) {
        return new c.b.a.d.p(this.f3019b, d.a.a.a.m.b.i.b(this.f3019b.e(), "com.crashlytics.ApiEndpoint"), str, this.f3021d);
    }

    public final void a(File[] fileArr, int i2, int i3) {
        d.a.a.a.c.h().e("CrashlyticsCore", "Closing open sessions.");
        while (i2 < fileArr.length) {
            File file = fileArr[i2];
            String b2 = b(file);
            d.a.a.a.k h2 = d.a.a.a.c.h();
            h2.e("CrashlyticsCore", "Closing session: " + b2);
            a(file, b2, i3);
            i2++;
        }
    }

    public static void b(String str, String str2) {
        c.b.a.b.a aVar = (c.b.a.b.a) d.a.a.a.c.a(c.b.a.b.a.class);
        if (aVar == null) {
            d.a.a.a.c.h().e("CrashlyticsCore", "Answers is not available");
        } else {
            aVar.a(new j.b(str, str2));
        }
    }

    public final void a(c.b.a.d.d dVar) {
        if (dVar == null) {
            return;
        }
        try {
            dVar.j();
        } catch (IOException e2) {
            d.a.a.a.c.h().c("CrashlyticsCore", "Error closing session file stream in the presence of an exception", e2);
        }
    }

    public final void a(String str) {
        for (File file : d(str)) {
            file.delete();
        }
    }

    public final File[] a(FilenameFilter filenameFilter) {
        return a(e(), filenameFilter);
    }

    public final File[] a(File file, FilenameFilter filenameFilter) {
        return b(file.listFiles(filenameFilter));
    }

    public final File[] a(File file) {
        return b(file.listFiles());
    }

    public final void a(String str, int i2) {
        File e2 = e();
        m0.a(e2, new p(str + "SessionEvent"), i2, s);
    }

    public final void a(int i2) {
        HashSet hashSet = new HashSet();
        File[] l2 = l();
        int min = Math.min(i2, l2.length);
        for (int i3 = 0; i3 < min; i3++) {
            hashSet.add(b(l2[i3]));
        }
        this.j.a(hashSet);
        a(a(new o(null)), hashSet);
    }

    public final void a(File[] fileArr, Set<String> set) {
        for (File file : fileArr) {
            String name = file.getName();
            Matcher matcher = t.matcher(name);
            if (!matcher.matches()) {
                d.a.a.a.c.h().e("CrashlyticsCore", "Deleting unknown file: " + name);
                file.delete();
                return;
            }
            if (!set.contains(matcher.group(1))) {
                d.a.a.a.c.h().e("CrashlyticsCore", "Trimming session file: " + name);
                file.delete();
            }
        }
    }

    public final File[] a(String str, File[] fileArr, int i2) {
        if (fileArr.length > i2) {
            d.a.a.a.c.h().e("CrashlyticsCore", String.format(Locale.US, "Trimming down to %d logged exceptions.", Integer.valueOf(i2)));
            a(str, i2);
            return a(new p(str + "SessionEvent"));
        }
        return fileArr;
    }

    public void a() {
        this.f3020c.a(new c());
    }

    public void a(File[] fileArr) {
        File[] a2;
        HashSet hashSet = new HashSet();
        for (File file : fileArr) {
            d.a.a.a.c.h().e("CrashlyticsCore", "Found invalid session part file: " + file);
            hashSet.add(b(file));
        }
        if (hashSet.isEmpty()) {
            return;
        }
        File f2 = f();
        if (!f2.exists()) {
            f2.mkdir();
        }
        for (File file2 : a(new d(this, hashSet))) {
            d.a.a.a.c.h().e("CrashlyticsCore", "Moving session file: " + file2);
            if (!file2.renameTo(new File(f2, file2.getName()))) {
                d.a.a.a.c.h().e("CrashlyticsCore", "Could not move session file. Deleting " + file2);
                file2.delete();
            }
        }
        n();
    }

    public final void a(c.b.a.d.o0.b.d dVar) {
        c.b.a.d.d dVar2;
        String h2;
        c.b.a.d.e eVar = null;
        try {
            try {
                h2 = h();
            } catch (Throwable th) {
                th = th;
                d.a.a.a.m.b.i.a(eVar, "Failed to flush to session begin file.");
                d.a.a.a.m.b.i.a((Closeable) dVar2, "Failed to close fatal exception file output stream.");
                throw th;
            }
        } catch (Exception e2) {
            e = e2;
            dVar2 = null;
        } catch (Throwable th2) {
            th = th2;
            dVar2 = null;
            d.a.a.a.m.b.i.a(eVar, "Failed to flush to session begin file.");
            d.a.a.a.m.b.i.a((Closeable) dVar2, "Failed to close fatal exception file output stream.");
            throw th;
        }
        if (h2 == null) {
            d.a.a.a.c.h().c("CrashlyticsCore", "Tried to write a native crash while no session was open.", null);
            d.a.a.a.m.b.i.a((Flushable) null, "Failed to flush to session begin file.");
            d.a.a.a.m.b.i.a((Closeable) null, "Failed to close fatal exception file output stream.");
            return;
        }
        boolean z = false;
        a(h2, String.format(Locale.US, "<native-crash [%s (%s)]>", dVar.f3106b.f3112b, dVar.f3106b.f3111a));
        if (dVar.f3108d != null && dVar.f3108d.length > 0) {
            z = true;
        }
        String str = z ? "SessionCrash" : "SessionMissingBinaryImages";
        dVar2 = new c.b.a.d.d(e(), h2 + str);
        try {
            eVar = c.b.a.d.e.a(dVar2);
            z.a(dVar, new c.b.a.d.u(this.f3019b.e(), this.f3026i, h2), new c.b.a.d.w(e()).c(h2), eVar);
        } catch (Exception e3) {
            e = e3;
            d.a.a.a.c.h().c("CrashlyticsCore", "An error occurred in the native crash logger", e);
            d.a.a.a.m.b.i.a(eVar, "Failed to flush to session begin file.");
            d.a.a.a.m.b.i.a((Closeable) dVar2, "Failed to close fatal exception file output stream.");
        }
        d.a.a.a.m.b.i.a(eVar, "Failed to flush to session begin file.");
        d.a.a.a.m.b.i.a((Closeable) dVar2, "Failed to close fatal exception file output stream.");
    }

    public final void a(Date date, Thread thread, Throwable th) {
        c.b.a.d.d dVar;
        c.b.a.d.e a2;
        String c2 = c();
        c.b.a.d.e eVar = null;
        if (c2 == null) {
            d.a.a.a.c.h().c("CrashlyticsCore", "Tried to write a non-fatal exception while no session was open.", null);
            return;
        }
        b(c2, th.getClass().getName());
        try {
            try {
                d.a.a.a.c.h().e("CrashlyticsCore", "Crashlytics is logging non-fatal exception \"" + th + "\" from thread " + thread.getName());
                dVar = new c.b.a.d.d(e(), c2 + "SessionEvent" + d.a.a.a.m.b.i.b(this.f3018a.getAndIncrement()));
                try {
                    a2 = c.b.a.d.e.a(dVar);
                } catch (Exception e2) {
                    e = e2;
                }
            } catch (Throwable th2) {
                th = th2;
            }
            try {
                h hVar = this;
                hVar.a(a2, date, thread, th, "error", false);
                d.a.a.a.m.b.i.a(a2, "Failed to flush to non-fatal file.");
                eVar = hVar;
            } catch (Exception e3) {
                e = e3;
                eVar = a2;
                d.a.a.a.c.h().c("CrashlyticsCore", "An error occurred in the non-fatal exception logger", e);
                d.a.a.a.m.b.i.a(eVar, "Failed to flush to non-fatal file.");
                eVar = eVar;
                d.a.a.a.m.b.i.a((Closeable) dVar, "Failed to close non-fatal file output stream.");
                a(c2, 64);
            } catch (Throwable th3) {
                th = th3;
                eVar = a2;
                d.a.a.a.m.b.i.a(eVar, "Failed to flush to non-fatal file.");
                d.a.a.a.m.b.i.a((Closeable) dVar, "Failed to close non-fatal file output stream.");
                throw th;
            }
        } catch (Exception e4) {
            e = e4;
            dVar = null;
        } catch (Throwable th4) {
            th = th4;
            dVar = null;
        }
        d.a.a.a.m.b.i.a((Closeable) dVar, "Failed to close non-fatal file output stream.");
        try {
            a(c2, 64);
        } catch (Exception e5) {
            d.a.a.a.c.h().c("CrashlyticsCore", "An error occurred when trimming non-fatal files.", e5);
        }
    }

    public final void a(String str, Date date) {
        c.b.a.d.d dVar;
        c.b.a.d.e eVar = null;
        try {
            dVar = new c.b.a.d.d(e(), str + "BeginSession");
            try {
                eVar = c.b.a.d.e.a(dVar);
                g0.a(eVar, str, String.format(Locale.US, "Crashlytics Android SDK/%s", this.f3019b.k()), date.getTime() / 1000);
                d.a.a.a.m.b.i.a(eVar, "Failed to flush to session begin file.");
                d.a.a.a.m.b.i.a((Closeable) dVar, "Failed to close begin session file.");
            } catch (Throwable th) {
                th = th;
                d.a.a.a.m.b.i.a(eVar, "Failed to flush to session begin file.");
                d.a.a.a.m.b.i.a((Closeable) dVar, "Failed to close begin session file.");
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
            dVar = null;
        }
    }

    /* JADX WARN: Type inference failed for: r6v2 */
    /* JADX WARN: Type inference failed for: r6v3, types: [boolean] */
    /* JADX WARN: Type inference failed for: r6v5 */
    public final void a(c.b.a.d.e eVar, Date date, Thread thread, Throwable th, String str, boolean z) {
        ?? r6;
        Thread[] threadArr;
        Map<String, String> s2;
        TreeMap treeMap;
        j0 j0Var = new j0(th, this.n);
        Context e2 = this.f3019b.e();
        long time = date.getTime() / 1000;
        Float e3 = d.a.a.a.m.b.i.e(e2);
        int a2 = d.a.a.a.m.b.i.a(e2, this.m.b());
        boolean g2 = d.a.a.a.m.b.i.g(e2);
        int i2 = e2.getResources().getConfiguration().orientation;
        long b2 = d.a.a.a.m.b.i.b() - d.a.a.a.m.b.i.a(e2);
        long a3 = d.a.a.a.m.b.i.a(Environment.getDataDirectory().getPath());
        ActivityManager.RunningAppProcessInfo a4 = d.a.a.a.m.b.i.a(e2.getPackageName(), e2);
        LinkedList linkedList = new LinkedList();
        StackTraceElement[] stackTraceElementArr = j0Var.f3078c;
        String str2 = this.f3025h.f2970b;
        String e4 = this.f3022e.e();
        int i3 = 0;
        if (z) {
            Map<Thread, StackTraceElement[]> allStackTraces = Thread.getAllStackTraces();
            Thread[] threadArr2 = new Thread[allStackTraces.size()];
            for (Map.Entry<Thread, StackTraceElement[]> entry : allStackTraces.entrySet()) {
                threadArr2[i3] = entry.getKey();
                linkedList.add(this.n.a(entry.getValue()));
                i3++;
            }
            r6 = 1;
            threadArr = threadArr2;
        } else {
            r6 = 1;
            threadArr = new Thread[0];
        }
        if (!d.a.a.a.m.b.i.a(e2, "com.crashlytics.CollectCustomKeys", (boolean) r6)) {
            s2 = new TreeMap<>();
        } else {
            s2 = this.f3019b.s();
            if (s2 != null && s2.size() > r6) {
                treeMap = new TreeMap(s2);
                g0.a(eVar, time, str, j0Var, thread, stackTraceElementArr, threadArr, linkedList, treeMap, this.j, a4, i2, e4, str2, e3, a2, g2, b2, a3);
            }
        }
        treeMap = s2;
        g0.a(eVar, time, str, j0Var, thread, stackTraceElementArr, threadArr, linkedList, treeMap, this.j, a4, i2, e4, str2, e3, a2, g2, b2, a3);
    }

    public final void a(File file, String str, int i2) {
        d.a.a.a.k h2 = d.a.a.a.c.h();
        h2.e("CrashlyticsCore", "Collecting session parts for ID " + str);
        File[] a2 = a(new p(str + "SessionCrash"));
        boolean z = a2 != null && a2.length > 0;
        d.a.a.a.c.h().e("CrashlyticsCore", String.format(Locale.US, "Session %s has fatal exception: %s", str, Boolean.valueOf(z)));
        File[] a3 = a(new p(str + "SessionEvent"));
        boolean z2 = a3 != null && a3.length > 0;
        d.a.a.a.c.h().e("CrashlyticsCore", String.format(Locale.US, "Session %s has non-fatal exceptions: %s", str, Boolean.valueOf(z2)));
        if (!z && !z2) {
            d.a.a.a.k h3 = d.a.a.a.c.h();
            h3.e("CrashlyticsCore", "No events present for session ID " + str);
        } else {
            a(file, str, a(str, a3, i2), z ? a2[0] : null);
        }
        d.a.a.a.k h4 = d.a.a.a.c.h();
        h4.e("CrashlyticsCore", "Removing session part files for ID " + str);
        a(str);
    }

    public final void a(File file, String str, File[] fileArr, File file2) {
        c.b.a.d.d dVar;
        boolean z = file2 != null;
        File d2 = z ? d() : g();
        if (!d2.exists()) {
            d2.mkdirs();
        }
        c.b.a.d.e eVar = null;
        try {
            dVar = new c.b.a.d.d(d2, str);
            try {
                try {
                    eVar = c.b.a.d.e.a(dVar);
                    d.a.a.a.c.h().e("CrashlyticsCore", "Collecting SessionStart data for session ID " + str);
                    a(eVar, file);
                    eVar.a(4, new Date().getTime() / 1000);
                    eVar.a(5, z);
                    eVar.d(11, 1);
                    eVar.a(12, 3);
                    a(eVar, str);
                    a(eVar, fileArr, str);
                    if (z) {
                        a(eVar, file2);
                    }
                    d.a.a.a.m.b.i.a(eVar, "Error flushing session file stream");
                    d.a.a.a.m.b.i.a((Closeable) dVar, "Failed to close CLS file");
                } catch (Exception e2) {
                    e = e2;
                    d.a.a.a.c.h().c("CrashlyticsCore", "Failed to write session file for session ID: " + str, e);
                    d.a.a.a.m.b.i.a(eVar, "Error flushing session file stream");
                    a(dVar);
                }
            } catch (Throwable th) {
                th = th;
                d.a.a.a.m.b.i.a(eVar, "Error flushing session file stream");
                d.a.a.a.m.b.i.a((Closeable) dVar, "Failed to close CLS file");
                throw th;
            }
        } catch (Exception e3) {
            e = e3;
            dVar = null;
        } catch (Throwable th2) {
            th = th2;
            dVar = null;
            d.a.a.a.m.b.i.a(eVar, "Error flushing session file stream");
            d.a.a.a.m.b.i.a((Closeable) dVar, "Failed to close CLS file");
            throw th;
        }
    }

    public static void a(c.b.a.d.e eVar, File[] fileArr, String str) {
        Arrays.sort(fileArr, d.a.a.a.m.b.i.f4245d);
        for (File file : fileArr) {
            try {
                d.a.a.a.c.h().e("CrashlyticsCore", String.format(Locale.US, "Found Non Fatal for session ID %s in %s ", str, file.getName()));
                a(eVar, file);
            } catch (Exception e2) {
                d.a.a.a.c.h().c("CrashlyticsCore", "Error writting non-fatal to session.", e2);
            }
        }
    }

    public final void a(c.b.a.d.e eVar, String str) {
        String[] strArr;
        for (String str2 : v) {
            File[] a2 = a(new p(str + str2));
            if (a2.length == 0) {
                d.a.a.a.c.h().c("CrashlyticsCore", "Can't find " + str2 + " data for session ID " + str, null);
            } else {
                d.a.a.a.c.h().e("CrashlyticsCore", "Collecting " + str2 + " data for session ID " + str);
                a(eVar, a2[0]);
            }
        }
    }

    public static void a(c.b.a.d.e eVar, File file) {
        FileInputStream fileInputStream;
        if (!file.exists()) {
            d.a.a.a.c.h().c("CrashlyticsCore", "Tried to include a file that doesn't exist: " + file.getName(), null);
            return;
        }
        try {
            fileInputStream = new FileInputStream(file);
            try {
                a(fileInputStream, eVar, (int) file.length());
                d.a.a.a.m.b.i.a((Closeable) fileInputStream, "Failed to close file input stream.");
            } catch (Throwable th) {
                th = th;
                d.a.a.a.m.b.i.a((Closeable) fileInputStream, "Failed to close file input stream.");
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
            fileInputStream = null;
        }
    }

    public static void a(InputStream inputStream, c.b.a.d.e eVar, int i2) {
        int read;
        byte[] bArr = new byte[i2];
        int i3 = 0;
        while (i3 < bArr.length && (read = inputStream.read(bArr, i3, bArr.length - i3)) >= 0) {
            i3 += read;
        }
        eVar.a(bArr);
    }

    public final void a(d.a.a.a.m.g.u uVar) {
        if (uVar == null) {
            d.a.a.a.c.h().a("CrashlyticsCore", "Cannot send reports. Settings are unavailable.");
            return;
        }
        Context e2 = this.f3019b.e();
        f0 f0Var = new f0(this.f3025h.f2969a, b(uVar.f4451a.f4414c), this.k, this.l);
        for (File file : j()) {
            this.f3020c.a(new v(e2, new h0(file, u), f0Var));
        }
    }

    public static void a(String str, String str2) {
        c.b.a.b.a aVar = (c.b.a.b.a) d.a.a.a.c.a(c.b.a.b.a.class);
        if (aVar == null) {
            d.a.a.a.c.h().e("CrashlyticsCore", "Answers is not available");
        } else {
            aVar.a(new j.a(str, str2));
        }
    }
}
