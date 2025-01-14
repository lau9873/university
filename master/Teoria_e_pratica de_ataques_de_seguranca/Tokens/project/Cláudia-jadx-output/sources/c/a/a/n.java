package c.a.a;

import android.os.SystemClock;
import android.util.Log;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
/* compiled from: VolleyLog.java */
/* loaded from: classes.dex */
public class n {

    /* renamed from: a  reason: collision with root package name */
    public static String f2803a = "Volley";

    /* renamed from: b  reason: collision with root package name */
    public static boolean f2804b = Log.isLoggable(f2803a, 2);

    /* renamed from: c  reason: collision with root package name */
    public static final String f2805c = n.class.getName();

    public static void a(Throwable th, String str, Object... objArr) {
        Log.e(f2803a, a(str, objArr), th);
    }

    public static void b(String str, Object... objArr) {
        Log.d(f2803a, a(str, objArr));
    }

    public static void c(String str, Object... objArr) {
        Log.e(f2803a, a(str, objArr));
    }

    public static void d(String str, Object... objArr) {
        if (f2804b) {
            Log.v(f2803a, a(str, objArr));
        }
    }

    public static void e(String str, Object... objArr) {
        Log.wtf(f2803a, a(str, objArr));
    }

    public static String a(String str, Object... objArr) {
        String str2;
        if (objArr != null) {
            str = String.format(Locale.US, str, objArr);
        }
        StackTraceElement[] stackTrace = new Throwable().fillInStackTrace().getStackTrace();
        int i2 = 2;
        while (true) {
            if (i2 >= stackTrace.length) {
                str2 = "<unknown>";
                break;
            } else if (!stackTrace[i2].getClassName().equals(f2805c)) {
                String className = stackTrace[i2].getClassName();
                String substring = className.substring(className.lastIndexOf(46) + 1);
                str2 = substring.substring(substring.lastIndexOf(36) + 1) + "." + stackTrace[i2].getMethodName();
                break;
            } else {
                i2++;
            }
        }
        return String.format(Locale.US, "[%d] %s: %s", Long.valueOf(Thread.currentThread().getId()), str2, str);
    }

    /* compiled from: VolleyLog.java */
    /* loaded from: classes.dex */
    public static class a {

        /* renamed from: c  reason: collision with root package name */
        public static final boolean f2806c = n.f2804b;

        /* renamed from: a  reason: collision with root package name */
        public final List<C0053a> f2807a = new ArrayList();

        /* renamed from: b  reason: collision with root package name */
        public boolean f2808b = false;

        /* compiled from: VolleyLog.java */
        /* renamed from: c.a.a.n$a$a  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        public static class C0053a {

            /* renamed from: a  reason: collision with root package name */
            public final String f2809a;

            /* renamed from: b  reason: collision with root package name */
            public final long f2810b;

            /* renamed from: c  reason: collision with root package name */
            public final long f2811c;

            public C0053a(String str, long j, long j2) {
                this.f2809a = str;
                this.f2810b = j;
                this.f2811c = j2;
            }
        }

        public synchronized void a(String str, long j) {
            if (!this.f2808b) {
                this.f2807a.add(new C0053a(str, j, SystemClock.elapsedRealtime()));
            } else {
                throw new IllegalStateException("Marker added to finished log");
            }
        }

        public void finalize() {
            if (this.f2808b) {
                return;
            }
            a("Request on the loose");
            n.c("Marker log finalized without finish() - uncaught exit point for request", new Object[0]);
        }

        public synchronized void a(String str) {
            this.f2808b = true;
            long a2 = a();
            if (a2 <= 0) {
                return;
            }
            long j = this.f2807a.get(0).f2811c;
            n.b("(%-4d ms) %s", Long.valueOf(a2), str);
            for (C0053a c0053a : this.f2807a) {
                long j2 = c0053a.f2811c;
                n.b("(+%-4d) [%2d] %s", Long.valueOf(j2 - j), Long.valueOf(c0053a.f2810b), c0053a.f2809a);
                j = j2;
            }
        }

        public final long a() {
            if (this.f2807a.size() == 0) {
                return 0L;
            }
            long j = this.f2807a.get(0).f2811c;
            List<C0053a> list = this.f2807a;
            return list.get(list.size() - 1).f2811c - j;
        }
    }
}
