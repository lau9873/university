package p070c.p074b.p075a.p078d;

import android.content.Context;
import java.io.File;
import java.util.Set;
import p136d.p137a.p138a.p139a.Fabric;
import p136d.p137a.p138a.p139a.p140m.p142b.CommonUtils;

/* renamed from: c.b.a.d.u */
/* loaded from: classes.dex */
public class LogFileManager {

    /* renamed from: d */
    public static final C0867c f4975d = new C0867c();

    /* renamed from: a */
    public final Context f4976a;

    /* renamed from: b */
    public final InterfaceC0866b f4977b;

    /* renamed from: c */
    public FileLogStore f4978c;

    /* compiled from: LogFileManager.java */
    /* renamed from: c.b.a.d.u$b */
    /* loaded from: classes.dex */
    public interface InterfaceC0866b {
        /* renamed from: a */
        File mo5718a();
    }

    /* compiled from: LogFileManager.java */
    /* renamed from: c.b.a.d.u$c */
    /* loaded from: classes.dex */
    public static final class C0867c implements FileLogStore {
        public C0867c() {
        }

        @Override // p070c.p074b.p075a.p078d.FileLogStore
        /* renamed from: a */
        public void mo5717a() {
        }

        @Override // p070c.p074b.p075a.p078d.FileLogStore
        /* renamed from: a */
        public void mo5716a(long j, String str) {
        }

        @Override // p070c.p074b.p075a.p078d.FileLogStore
        /* renamed from: b */
        public ByteString mo5715b() {
            return null;
        }

        @Override // p070c.p074b.p075a.p078d.FileLogStore
        /* renamed from: c */
        public void mo5714c() {
        }
    }

    public LogFileManager(Context context, InterfaceC0866b interfaceC0866b) {
        this(context, interfaceC0866b, null);
    }

    /* renamed from: a */
    public void m5725a(long j, String str) {
        this.f4978c.mo5716a(j, str);
    }

    /* renamed from: b */
    public final void m5719b(String str) {
        this.f4978c.mo5717a();
        this.f4978c = f4975d;
        if (str == null) {
            return;
        }
        if (!CommonUtils.m4106a(this.f4976a, "com.crashlytics.CollectCustomLogs", true)) {
            Fabric.m4197h().mo4157e("CrashlyticsCore", "Preferences requested no custom logs. Aborting log file creation.");
        } else {
            m5723a(m5722a(str), 65536);
        }
    }

    public LogFileManager(Context context, InterfaceC0866b interfaceC0866b, String str) {
        this.f4976a = context;
        this.f4977b = interfaceC0866b;
        this.f4978c = f4975d;
        m5719b(str);
    }

    /* renamed from: a */
    public void m5726a() {
        this.f4978c.mo5714c();
    }

    /* renamed from: a */
    public void m5721a(Set<String> set) {
        File[] listFiles = this.f4977b.mo5718a().listFiles();
        if (listFiles != null) {
            for (File file : listFiles) {
                if (!set.contains(m5724a(file))) {
                    file.delete();
                }
            }
        }
    }

    /* renamed from: a */
    public void m5723a(File file, int i) {
        this.f4978c = new QueueFileLogStore(file, i);
    }

    /* renamed from: b */
    public ByteString m5720b() {
        return this.f4978c.mo5715b();
    }

    /* renamed from: a */
    public final File m5722a(String str) {
        return new File(this.f4977b.mo5718a(), "crashlytics-userlog-" + str + ".temp");
    }

    /* renamed from: a */
    public final String m5724a(File file) {
        String name = file.getName();
        int lastIndexOf = name.lastIndexOf(".temp");
        return lastIndexOf == -1 ? name : name.substring(20, lastIndexOf);
    }
}
