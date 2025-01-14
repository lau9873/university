package p070c.p074b.p075a.p078d;

import java.io.File;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import p136d.p137a.p138a.p139a.Fabric;
import p136d.p137a.p138a.p139a.Logger;
import p136d.p137a.p138a.p139a.p140m.p142b.BackgroundPriorityRunnable;

/* renamed from: c.b.a.d.f0 */
/* loaded from: classes.dex */
public class ReportUploader {

    /* renamed from: g */
    public static final Map<String, String> f4815g = Collections.singletonMap("X-CRASHLYTICS-INVALID-SESSION", "1");

    /* renamed from: h */
    public static final short[] f4816h = {10, 20, 30, 60, 120, 300};

    /* renamed from: a */
    public final Object f4817a = new Object();

    /* renamed from: b */
    public final CreateReportSpiCall f4818b;

    /* renamed from: c */
    public final String f4819c;

    /* renamed from: d */
    public final InterfaceC0824c f4820d;

    /* renamed from: e */
    public final InterfaceC0823b f4821e;

    /* renamed from: f */
    public Thread f4822f;

    /* compiled from: ReportUploader.java */
    /* renamed from: c.b.a.d.f0$a */
    /* loaded from: classes.dex */
    public static final class C0822a implements InterfaceC0825d {
        @Override // p070c.p074b.p075a.p078d.ReportUploader.InterfaceC0825d
        /* renamed from: a */
        public boolean mo5785a() {
            return true;
        }
    }

    /* compiled from: ReportUploader.java */
    /* renamed from: c.b.a.d.f0$b */
    /* loaded from: classes.dex */
    public interface InterfaceC0823b {
        /* renamed from: a */
        boolean mo5780a();
    }

    /* compiled from: ReportUploader.java */
    /* renamed from: c.b.a.d.f0$c */
    /* loaded from: classes.dex */
    public interface InterfaceC0824c {
        /* renamed from: a */
        File[] mo5782a();

        /* renamed from: b */
        File[] mo5781b();
    }

    /* compiled from: ReportUploader.java */
    /* renamed from: c.b.a.d.f0$d */
    /* loaded from: classes.dex */
    public interface InterfaceC0825d {
        /* renamed from: a */
        boolean mo5785a();
    }

    /* compiled from: ReportUploader.java */
    /* renamed from: c.b.a.d.f0$e */
    /* loaded from: classes.dex */
    public class C0826e extends BackgroundPriorityRunnable {

        /* renamed from: a */
        public final float f4823a;

        /* renamed from: b */
        public final InterfaceC0825d f4824b;

        public C0826e(float f, InterfaceC0825d interfaceC0825d) {
            this.f4823a = f;
            this.f4824b = interfaceC0825d;
        }

        @Override // p136d.p137a.p138a.p139a.p140m.p142b.BackgroundPriorityRunnable
        /* renamed from: a */
        public void mo4057a() {
            try {
                m5894b();
            } catch (Exception e) {
                Fabric.m4197h().mo4159c("CrashlyticsCore", "An unexpected error occurred while attempting to upload crash reports.", e);
            }
            ReportUploader.this.f4822f = null;
        }

        /* renamed from: b */
        public final void m5894b() {
            float f;
            Fabric.m4197h().mo4157e("CrashlyticsCore", "Starting report processing in " + this.f4823a + " second(s)...");
            if (this.f4823a > 0.0f) {
                try {
                    Thread.sleep(f * 1000.0f);
                } catch (InterruptedException unused) {
                    Thread.currentThread().interrupt();
                    return;
                }
            }
            List<Report> m5900a = ReportUploader.this.m5900a();
            if (ReportUploader.this.f4821e.mo5780a()) {
                return;
            }
            if (!m5900a.isEmpty() && !this.f4824b.mo5785a()) {
                Fabric.m4197h().mo4157e("CrashlyticsCore", "User declined to send. Removing " + m5900a.size() + " Report(s).");
                for (Report report : m5900a) {
                    report.remove();
                }
                return;
            }
            int i = 0;
            while (!m5900a.isEmpty() && !ReportUploader.this.f4821e.mo5780a()) {
                Fabric.m4197h().mo4157e("CrashlyticsCore", "Attempting to send " + m5900a.size() + " report(s)");
                for (Report report2 : m5900a) {
                    ReportUploader.this.m5898a(report2);
                }
                m5900a = ReportUploader.this.m5900a();
                if (!m5900a.isEmpty()) {
                    int i2 = i + 1;
                    long j = ReportUploader.f4816h[Math.min(i, ReportUploader.f4816h.length - 1)];
                    Fabric.m4197h().mo4157e("CrashlyticsCore", "Report submisson: scheduling delayed retry in " + j + " seconds");
                    try {
                        Thread.sleep(j * 1000);
                        i = i2;
                    } catch (InterruptedException unused2) {
                        Thread.currentThread().interrupt();
                        return;
                    }
                }
            }
        }
    }

    public ReportUploader(String str, CreateReportSpiCall createReportSpiCall, InterfaceC0824c interfaceC0824c, InterfaceC0823b interfaceC0823b) {
        if (createReportSpiCall != null) {
            this.f4818b = createReportSpiCall;
            this.f4819c = str;
            this.f4820d = interfaceC0824c;
            this.f4821e = interfaceC0823b;
            return;
        }
        throw new IllegalArgumentException("createReportCall must not be null.");
    }

    /* renamed from: a */
    public synchronized void m5899a(float f, InterfaceC0825d interfaceC0825d) {
        if (this.f4822f != null) {
            Fabric.m4197h().mo4157e("CrashlyticsCore", "Report upload has already been started.");
            return;
        }
        this.f4822f = new Thread(new C0826e(f, interfaceC0825d), "Crashlytics Report Uploader");
        this.f4822f.start();
    }

    /* renamed from: a */
    public boolean m5898a(Report report) {
        boolean z;
        synchronized (this.f4817a) {
            z = false;
            try {
                boolean mo5745a = this.f4818b.mo5745a(new CreateReportRequest(this.f4819c, report));
                Logger m4197h = Fabric.m4197h();
                StringBuilder sb = new StringBuilder();
                sb.append("Crashlytics report upload ");
                sb.append(mo5745a ? "complete: " : "FAILED: ");
                sb.append(report.mo5728d());
                m4197h.mo4162b("CrashlyticsCore", sb.toString());
                if (mo5745a) {
                    report.remove();
                    z = true;
                }
            } catch (Exception e) {
                Logger m4197h2 = Fabric.m4197h();
                m4197h2.mo4159c("CrashlyticsCore", "Error occurred sending report " + report, e);
            }
        }
        return z;
    }

    /* renamed from: a */
    public List<Report> m5900a() {
        File[] mo5781b;
        File[] mo5782a;
        Fabric.m4197h().mo4157e("CrashlyticsCore", "Checking for crash reports...");
        synchronized (this.f4817a) {
            mo5781b = this.f4820d.mo5781b();
            mo5782a = this.f4820d.mo5782a();
        }
        LinkedList linkedList = new LinkedList();
        if (mo5781b != null) {
            for (File file : mo5781b) {
                Fabric.m4197h().mo4157e("CrashlyticsCore", "Found crash report " + file.getPath());
                linkedList.add(new SessionReport(file));
            }
        }
        HashMap hashMap = new HashMap();
        if (mo5782a != null) {
            for (File file2 : mo5782a) {
                String m5814b = CrashlyticsController.m5814b(file2);
                if (!hashMap.containsKey(m5814b)) {
                    hashMap.put(m5814b, new LinkedList());
                }
                ((List) hashMap.get(m5814b)).add(file2);
            }
        }
        for (String str : hashMap.keySet()) {
            Fabric.m4197h().mo4157e("CrashlyticsCore", "Found invalid session: " + str);
            List list = (List) hashMap.get(str);
            linkedList.add(new InvalidSessionReport(str, (File[]) list.toArray(new File[list.size()])));
        }
        if (linkedList.isEmpty()) {
            Fabric.m4197h().mo4157e("CrashlyticsCore", "No reports found.");
        }
        return linkedList;
    }
}
