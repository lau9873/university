package c.b.a.d;

import java.io.File;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
/* compiled from: ReportUploader.java */
/* loaded from: classes.dex */
public class f0 {

    /* renamed from: g  reason: collision with root package name */
    public static final Map<String, String> f3002g = Collections.singletonMap("X-CRASHLYTICS-INVALID-SESSION", "1");

    /* renamed from: h  reason: collision with root package name */
    public static final short[] f3003h = {10, 20, 30, 60, 120, 300};

    /* renamed from: a  reason: collision with root package name */
    public final Object f3004a = new Object();

    /* renamed from: b  reason: collision with root package name */
    public final o f3005b;

    /* renamed from: c  reason: collision with root package name */
    public final String f3006c;

    /* renamed from: d  reason: collision with root package name */
    public final c f3007d;

    /* renamed from: e  reason: collision with root package name */
    public final b f3008e;

    /* renamed from: f  reason: collision with root package name */
    public Thread f3009f;

    /* compiled from: ReportUploader.java */
    /* loaded from: classes.dex */
    public static final class a implements d {
        @Override // c.b.a.d.f0.d
        public boolean a() {
            return true;
        }
    }

    /* compiled from: ReportUploader.java */
    /* loaded from: classes.dex */
    public interface b {
        boolean a();
    }

    /* compiled from: ReportUploader.java */
    /* loaded from: classes.dex */
    public interface c {
        File[] a();

        File[] b();
    }

    /* compiled from: ReportUploader.java */
    /* loaded from: classes.dex */
    public interface d {
        boolean a();
    }

    /* compiled from: ReportUploader.java */
    /* loaded from: classes.dex */
    public class e extends d.a.a.a.m.b.h {

        /* renamed from: a  reason: collision with root package name */
        public final float f3010a;

        /* renamed from: b  reason: collision with root package name */
        public final d f3011b;

        public e(float f2, d dVar) {
            this.f3010a = f2;
            this.f3011b = dVar;
        }

        @Override // d.a.a.a.m.b.h
        public void a() {
            try {
                b();
            } catch (Exception e2) {
                d.a.a.a.c.h().c("CrashlyticsCore", "An unexpected error occurred while attempting to upload crash reports.", e2);
            }
            f0.this.f3009f = null;
        }

        public final void b() {
            float f2;
            d.a.a.a.c.h().e("CrashlyticsCore", "Starting report processing in " + this.f3010a + " second(s)...");
            if (this.f3010a > 0.0f) {
                try {
                    Thread.sleep(f2 * 1000.0f);
                } catch (InterruptedException unused) {
                    Thread.currentThread().interrupt();
                    return;
                }
            }
            List<e0> a2 = f0.this.a();
            if (f0.this.f3008e.a()) {
                return;
            }
            if (!a2.isEmpty() && !this.f3011b.a()) {
                d.a.a.a.c.h().e("CrashlyticsCore", "User declined to send. Removing " + a2.size() + " Report(s).");
                for (e0 e0Var : a2) {
                    e0Var.remove();
                }
                return;
            }
            int i2 = 0;
            while (!a2.isEmpty() && !f0.this.f3008e.a()) {
                d.a.a.a.c.h().e("CrashlyticsCore", "Attempting to send " + a2.size() + " report(s)");
                for (e0 e0Var2 : a2) {
                    f0.this.a(e0Var2);
                }
                a2 = f0.this.a();
                if (!a2.isEmpty()) {
                    int i3 = i2 + 1;
                    long j = f0.f3003h[Math.min(i2, f0.f3003h.length - 1)];
                    d.a.a.a.c.h().e("CrashlyticsCore", "Report submisson: scheduling delayed retry in " + j + " seconds");
                    try {
                        Thread.sleep(j * 1000);
                        i2 = i3;
                    } catch (InterruptedException unused2) {
                        Thread.currentThread().interrupt();
                        return;
                    }
                }
            }
        }
    }

    public f0(String str, o oVar, c cVar, b bVar) {
        if (oVar != null) {
            this.f3005b = oVar;
            this.f3006c = str;
            this.f3007d = cVar;
            this.f3008e = bVar;
            return;
        }
        throw new IllegalArgumentException("createReportCall must not be null.");
    }

    public synchronized void a(float f2, d dVar) {
        if (this.f3009f != null) {
            d.a.a.a.c.h().e("CrashlyticsCore", "Report upload has already been started.");
            return;
        }
        this.f3009f = new Thread(new e(f2, dVar), "Crashlytics Report Uploader");
        this.f3009f.start();
    }

    public boolean a(e0 e0Var) {
        boolean z;
        synchronized (this.f3004a) {
            z = false;
            try {
                boolean a2 = this.f3005b.a(new n(this.f3006c, e0Var));
                d.a.a.a.k h2 = d.a.a.a.c.h();
                StringBuilder sb = new StringBuilder();
                sb.append("Crashlytics report upload ");
                sb.append(a2 ? "complete: " : "FAILED: ");
                sb.append(e0Var.d());
                h2.b("CrashlyticsCore", sb.toString());
                if (a2) {
                    e0Var.remove();
                    z = true;
                }
            } catch (Exception e2) {
                d.a.a.a.k h3 = d.a.a.a.c.h();
                h3.c("CrashlyticsCore", "Error occurred sending report " + e0Var, e2);
            }
        }
        return z;
    }

    public List<e0> a() {
        File[] b2;
        File[] a2;
        d.a.a.a.c.h().e("CrashlyticsCore", "Checking for crash reports...");
        synchronized (this.f3004a) {
            b2 = this.f3007d.b();
            a2 = this.f3007d.a();
        }
        LinkedList linkedList = new LinkedList();
        if (b2 != null) {
            for (File file : b2) {
                d.a.a.a.c.h().e("CrashlyticsCore", "Found crash report " + file.getPath());
                linkedList.add(new h0(file));
            }
        }
        HashMap hashMap = new HashMap();
        if (a2 != null) {
            for (File file2 : a2) {
                String b3 = h.b(file2);
                if (!hashMap.containsKey(b3)) {
                    hashMap.put(b3, new LinkedList());
                }
                ((List) hashMap.get(b3)).add(file2);
            }
        }
        for (String str : hashMap.keySet()) {
            d.a.a.a.c.h().e("CrashlyticsCore", "Found invalid session: " + str);
            List list = (List) hashMap.get(str);
            linkedList.add(new t(str, (File[]) list.toArray(new File[list.size()])));
        }
        if (linkedList.isEmpty()) {
            d.a.a.a.c.h().e("CrashlyticsCore", "No reports found.");
        }
        return linkedList;
    }
}
