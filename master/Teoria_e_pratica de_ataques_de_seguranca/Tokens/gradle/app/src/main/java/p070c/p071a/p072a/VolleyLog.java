package p070c.p071a.p072a;

import android.os.SystemClock;
import android.util.Log;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

/* renamed from: c.a.a.n */
/* loaded from: classes.dex */
public class VolleyLog {

    /* renamed from: a */
    public static String f4600a = "Volley";

    /* renamed from: b */
    public static boolean f4601b = Log.isLoggable(f4600a, 2);

    /* renamed from: c */
    public static final String f4602c = VolleyLog.class.getName();

    /* renamed from: a */
    public static void m6169a(Throwable th, String str, Object... objArr) {
        Log.e(f4600a, m6170a(str, objArr), th);
    }

    /* renamed from: b */
    public static void m6168b(String str, Object... objArr) {
        Log.d(f4600a, m6170a(str, objArr));
    }

    /* renamed from: c */
    public static void m6167c(String str, Object... objArr) {
        Log.e(f4600a, m6170a(str, objArr));
    }

    /* renamed from: d */
    public static void m6166d(String str, Object... objArr) {
        if (f4601b) {
            Log.v(f4600a, m6170a(str, objArr));
        }
    }

    /* renamed from: e */
    public static void m6165e(String str, Object... objArr) {
        Log.wtf(f4600a, m6170a(str, objArr));
    }

    /* renamed from: a */
    public static String m6170a(String str, Object... objArr) {
        String str2;
        if (objArr != null) {
            str = String.format(Locale.US, str, objArr);
        }
        StackTraceElement[] stackTrace = new Throwable().fillInStackTrace().getStackTrace();
        int i = 2;
        while (true) {
            if (i >= stackTrace.length) {
                str2 = "<unknown>";
                break;
            } else if (!stackTrace[i].getClassName().equals(f4602c)) {
                String className = stackTrace[i].getClassName();
                String substring = className.substring(className.lastIndexOf(46) + 1);
                str2 = substring.substring(substring.lastIndexOf(36) + 1) + "." + stackTrace[i].getMethodName();
                break;
            } else {
                i++;
            }
        }
        return String.format(Locale.US, "[%d] %s: %s", Long.valueOf(Thread.currentThread().getId()), str2, str);
    }

    /* compiled from: VolleyLog.java */
    /* renamed from: c.a.a.n$a */
    /* loaded from: classes.dex */
    public static class C0791a {

        /* renamed from: c */
        public static final boolean f4603c = VolleyLog.f4601b;

        /* renamed from: a */
        public final List<C0792a> f4604a = new ArrayList();

        /* renamed from: b */
        public boolean f4605b = false;

        /* compiled from: VolleyLog.java */
        /* renamed from: c.a.a.n$a$a */
        /* loaded from: classes.dex */
        public static class C0792a {

            /* renamed from: a */
            public final String f4606a;

            /* renamed from: b */
            public final long f4607b;

            /* renamed from: c */
            public final long f4608c;

            public C0792a(String str, long j, long j2) {
                this.f4606a = str;
                this.f4607b = j;
                this.f4608c = j2;
            }
        }

        /* renamed from: a */
        public synchronized void m6162a(String str, long j) {
            if (!this.f4605b) {
                this.f4604a.add(new C0792a(str, j, SystemClock.elapsedRealtime()));
            } else {
                throw new IllegalStateException("Marker added to finished log");
            }
        }

        public void finalize() {
            if (this.f4605b) {
                return;
            }
            m6163a("Request on the loose");
            VolleyLog.m6167c("Marker log finalized without finish() - uncaught exit point for request", new Object[0]);
        }

        /* renamed from: a */
        public synchronized void m6163a(String str) {
            this.f4605b = true;
            long m6164a = m6164a();
            if (m6164a <= 0) {
                return;
            }
            long j = this.f4604a.get(0).f4608c;
            VolleyLog.m6168b("(%-4d ms) %s", Long.valueOf(m6164a), str);
            for (C0792a c0792a : this.f4604a) {
                long j2 = c0792a.f4608c;
                VolleyLog.m6168b("(+%-4d) [%2d] %s", Long.valueOf(j2 - j), Long.valueOf(c0792a.f4607b), c0792a.f4606a);
                j = j2;
            }
        }

        /* renamed from: a */
        public final long m6164a() {
            if (this.f4604a.size() == 0) {
                return 0L;
            }
            long j = this.f4604a.get(0).f4608c;
            List<C0792a> list = this.f4604a;
            return list.get(list.size() - 1).f4608c - j;
        }
    }
}
