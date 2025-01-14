package p070c.p074b.p075a.p078d;

import android.app.Activity;
import android.app.ActivityManager;
import android.content.Context;
import android.os.Build;
import android.os.Environment;
import android.os.StatFs;
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
import p070c.p074b.p075a.p076b.Answers;
import p070c.p074b.p075a.p078d.CrashPromptDialog;
import p070c.p074b.p075a.p078d.CrashlyticsUncaughtExceptionHandler;
import p070c.p074b.p075a.p078d.LogFileManager;
import p070c.p074b.p075a.p078d.ReportUploader;
import p070c.p074b.p075a.p078d.p079o0.p080b.SessionEventData;
import p136d.p137a.p138a.p139a.Fabric;
import p136d.p137a.p138a.p139a.Kit;
import p136d.p137a.p138a.p139a.Logger;
import p136d.p137a.p138a.p139a.p140m.p142b.CommonUtils;
import p136d.p137a.p138a.p139a.p140m.p142b.Crash;
import p136d.p137a.p138a.p139a.p140m.p142b.DeliveryMechanism;
import p136d.p137a.p138a.p139a.p140m.p142b.IdManager;
import p136d.p137a.p138a.p139a.p140m.p146e.HttpRequestFactory;
import p136d.p137a.p138a.p139a.p140m.p147f.FileStore;
import p136d.p137a.p138a.p139a.p140m.p148g.PromptSettingsData;
import p136d.p137a.p138a.p139a.p140m.p148g.SessionSettingsData;
import p136d.p137a.p138a.p139a.p140m.p148g.Settings;
import p136d.p137a.p138a.p139a.p140m.p148g.SettingsData;

/* renamed from: c.b.a.d.h */
/* loaded from: classes.dex */
public class CrashlyticsController {

    /* renamed from: q */
    public static final FilenameFilter f4831q = new C0834f();

    /* renamed from: r */
    public static final Comparator<File> f4832r = new C0835g();

    /* renamed from: s */
    public static final Comparator<File> f4833s = new C0836h();

    /* renamed from: t */
    public static final Pattern f4834t;

    /* renamed from: u */
    public static final Map<String, String> f4835u;

    /* renamed from: v */
    public static final String[] f4836v;

    /* renamed from: a */
    public final AtomicInteger f4837a = new AtomicInteger(0);

    /* renamed from: b */
    public final CrashlyticsCore f4838b;

    /* renamed from: c */
    public final CrashlyticsBackgroundWorker f4839c;

    /* renamed from: d */
    public final HttpRequestFactory f4840d;

    /* renamed from: e */
    public final IdManager f4841e;

    /* renamed from: f */
    public final C0813b0 f4842f;

    /* renamed from: g */
    public final FileStore f4843g;

    /* renamed from: h */
    public final AppData f4844h;

    /* renamed from: i */
    public final C0846r f4845i;

    /* renamed from: j */
    public final LogFileManager f4846j;

    /* renamed from: k */
    public final ReportUploader.InterfaceC0824c f4847k;

    /* renamed from: l */
    public final ReportUploader.InterfaceC0823b f4848l;

    /* renamed from: m */
    public final DevicePowerStateListener f4849m;

    /* renamed from: n */
    public final StackTraceTrimmingStrategy f4850n;

    /* renamed from: o */
    public final String f4851o;

    /* renamed from: p */
    public CrashlyticsUncaughtExceptionHandler f4852p;

    /* compiled from: CrashlyticsController.java */
    /* renamed from: c.b.a.d.h$a */
    /* loaded from: classes.dex */
    public class CallableC0829a implements Callable<Void> {
        public CallableC0829a() {
        }

        @Override // java.util.concurrent.Callable
        public Void call() {
            CrashlyticsController.this.m5822b();
            return null;
        }
    }

    /* compiled from: CrashlyticsController.java */
    /* renamed from: c.b.a.d.h$b */
    /* loaded from: classes.dex */
    public class CallableC0830b implements Callable<Boolean> {

        /* renamed from: a */
        public final /* synthetic */ SessionSettingsData f4854a;

        public CallableC0830b(SessionSettingsData sessionSettingsData) {
            this.f4854a = sessionSettingsData;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // java.util.concurrent.Callable
        public Boolean call() {
            if (CrashlyticsController.this.m5794i()) {
                Fabric.m4197h().mo4157e("CrashlyticsCore", "Skipping session finalization because a crash has already occurred.");
                return Boolean.FALSE;
            }
            Fabric.m4197h().mo4157e("CrashlyticsCore", "Finalizing previously open sessions.");
            CrashlyticsController.this.m5842a(this.f4854a, true);
            Fabric.m4197h().mo4157e("CrashlyticsCore", "Closed all previously open sessions");
            return Boolean.TRUE;
        }
    }

    /* compiled from: CrashlyticsController.java */
    /* renamed from: c.b.a.d.h$c */
    /* loaded from: classes.dex */
    public class RunnableC0831c implements Runnable {
        public RunnableC0831c() {
        }

        @Override // java.lang.Runnable
        public void run() {
            CrashlyticsController crashlyticsController = CrashlyticsController.this;
            crashlyticsController.m5825a(crashlyticsController.m5836a(new C0845q()));
        }
    }

    /* compiled from: CrashlyticsController.java */
    /* renamed from: c.b.a.d.h$d */
    /* loaded from: classes.dex */
    public class C0832d implements FilenameFilter {

        /* renamed from: a */
        public final /* synthetic */ Set f4857a;

        public C0832d(CrashlyticsController crashlyticsController, Set set) {
            this.f4857a = set;
        }

        @Override // java.io.FilenameFilter
        public boolean accept(File file, String str) {
            if (str.length() < 35) {
                return false;
            }
            return this.f4857a.contains(str.substring(0, 35));
        }
    }

    /* compiled from: CrashlyticsController.java */
    /* renamed from: c.b.a.d.h$e */
    /* loaded from: classes.dex */
    public class CallableC0833e implements Callable<Void> {

        /* renamed from: a */
        public final /* synthetic */ SessionEventData f4858a;

        public CallableC0833e(SessionEventData sessionEventData) {
            this.f4858a = sessionEventData;
        }

        @Override // java.util.concurrent.Callable
        public Void call() {
            if (CrashlyticsController.this.m5794i()) {
                return null;
            }
            CrashlyticsController.this.m5844a(this.f4858a);
            return null;
        }
    }

    /* compiled from: CrashlyticsController.java */
    /* renamed from: c.b.a.d.h$f */
    /* loaded from: classes.dex */
    public static class C0834f implements FilenameFilter {
        @Override // java.io.FilenameFilter
        public boolean accept(File file, String str) {
            return str.length() == 39 && str.endsWith(".cls");
        }
    }

    /* compiled from: CrashlyticsController.java */
    /* renamed from: c.b.a.d.h$g */
    /* loaded from: classes.dex */
    public static class C0835g implements Comparator<File> {
        @Override // java.util.Comparator
        /* renamed from: a */
        public int compare(File file, File file2) {
            return file2.getName().compareTo(file.getName());
        }
    }

    /* compiled from: CrashlyticsController.java */
    /* renamed from: c.b.a.d.h$h */
    /* loaded from: classes.dex */
    public static class C0836h implements Comparator<File> {
        @Override // java.util.Comparator
        /* renamed from: a */
        public int compare(File file, File file2) {
            return file.getName().compareTo(file2.getName());
        }
    }

    /* compiled from: CrashlyticsController.java */
    /* renamed from: c.b.a.d.h$i */
    /* loaded from: classes.dex */
    public static class C0837i implements FilenameFilter {
        @Override // java.io.FilenameFilter
        public boolean accept(File file, String str) {
            return CrashlyticsController.f4834t.matcher(str).matches();
        }
    }

    /* compiled from: CrashlyticsController.java */
    /* renamed from: c.b.a.d.h$j */
    /* loaded from: classes.dex */
    public class C0838j implements CrashlyticsUncaughtExceptionHandler.InterfaceC0860a {
        public C0838j() {
        }

        @Override // p070c.p074b.p075a.p078d.CrashlyticsUncaughtExceptionHandler.InterfaceC0860a
        /* renamed from: a */
        public void mo5750a(Thread thread, Throwable th) {
            CrashlyticsController.this.m5827a(thread, th);
        }
    }

    /* compiled from: CrashlyticsController.java */
    /* renamed from: c.b.a.d.h$k */
    /* loaded from: classes.dex */
    public class CallableC0839k implements Callable<Void> {

        /* renamed from: a */
        public final /* synthetic */ Date f4861a;

        /* renamed from: b */
        public final /* synthetic */ Thread f4862b;

        /* renamed from: c */
        public final /* synthetic */ Throwable f4863c;

        public CallableC0839k(Date date, Thread thread, Throwable th) {
            this.f4861a = date;
            this.f4862b = thread;
            this.f4863c = th;
        }

        @Override // java.util.concurrent.Callable
        public Void call() {
            CrashlyticsController.this.f4838b.m5768p();
            CrashlyticsController.this.m5810b(this.f4861a, this.f4862b, this.f4863c);
            SettingsData m3873a = Settings.m3868d().m3873a();
            SessionSettingsData sessionSettingsData = m3873a != null ? m3873a.f6658b : null;
            CrashlyticsController.this.m5843a(sessionSettingsData);
            CrashlyticsController.this.m5822b();
            if (sessionSettingsData != null) {
                CrashlyticsController.this.m5821b(sessionSettingsData.f6647b);
            }
            if (!CrashlyticsController.this.m5815b(m3873a)) {
                CrashlyticsController.this.m5841a(m3873a);
            }
            return null;
        }
    }

    /* compiled from: CrashlyticsController.java */
    /* renamed from: c.b.a.d.h$l */
    /* loaded from: classes.dex */
    public class CallableC0840l implements Callable<Void> {

        /* renamed from: a */
        public final /* synthetic */ long f4865a;

        /* renamed from: b */
        public final /* synthetic */ String f4866b;

        public CallableC0840l(long j, String str) {
            this.f4865a = j;
            this.f4866b = str;
        }

        @Override // java.util.concurrent.Callable
        public Void call() {
            if (CrashlyticsController.this.m5794i()) {
                return null;
            }
            CrashlyticsController.this.f4846j.m5725a(this.f4865a, this.f4866b);
            return null;
        }
    }

    /* compiled from: CrashlyticsController.java */
    /* renamed from: c.b.a.d.h$m */
    /* loaded from: classes.dex */
    public class RunnableC0841m implements Runnable {

        /* renamed from: a */
        public final /* synthetic */ Date f4868a;

        /* renamed from: b */
        public final /* synthetic */ Thread f4869b;

        /* renamed from: c */
        public final /* synthetic */ Throwable f4870c;

        public RunnableC0841m(Date date, Thread thread, Throwable th) {
            this.f4868a = date;
            this.f4869b = thread;
            this.f4870c = th;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (CrashlyticsController.this.m5794i()) {
                return;
            }
            CrashlyticsController.this.m5826a(this.f4868a, this.f4869b, this.f4870c);
        }
    }

    /* compiled from: CrashlyticsController.java */
    /* renamed from: c.b.a.d.h$n */
    /* loaded from: classes.dex */
    public class CallableC0842n implements Callable<Void> {

        /* renamed from: a */
        public final /* synthetic */ String f4872a;

        /* renamed from: b */
        public final /* synthetic */ String f4873b;

        /* renamed from: c */
        public final /* synthetic */ String f4874c;

        public CallableC0842n(String str, String str2, String str3) {
            this.f4872a = str;
            this.f4873b = str2;
            this.f4874c = str3;
        }

        @Override // java.util.concurrent.Callable
        public Void call() {
            new MetaDataStore(CrashlyticsController.this.m5802e()).m5710a(CrashlyticsController.this.m5808c(), new UserMetaData(this.f4872a, this.f4873b, this.f4874c));
            return null;
        }
    }

    /* compiled from: CrashlyticsController.java */
    /* renamed from: c.b.a.d.h$o */
    /* loaded from: classes.dex */
    public static class C0843o implements FilenameFilter {
        public C0843o() {
        }

        @Override // java.io.FilenameFilter
        public boolean accept(File file, String str) {
            return !CrashlyticsController.f4831q.accept(file, str) && CrashlyticsController.f4834t.matcher(str).matches();
        }

        public /* synthetic */ C0843o(C0834f c0834f) {
            this();
        }
    }

    /* compiled from: CrashlyticsController.java */
    /* renamed from: c.b.a.d.h$p */
    /* loaded from: classes.dex */
    public static class C0844p implements FilenameFilter {

        /* renamed from: a */
        public final String f4876a;

        public C0844p(String str) {
            this.f4876a = str;
        }

        @Override // java.io.FilenameFilter
        public boolean accept(File file, String str) {
            return str.contains(this.f4876a) && !str.endsWith(".cls_temp");
        }
    }

    /* compiled from: CrashlyticsController.java */
    /* renamed from: c.b.a.d.h$q */
    /* loaded from: classes.dex */
    public static class C0845q implements FilenameFilter {
        @Override // java.io.FilenameFilter
        public boolean accept(File file, String str) {
            return ClsFileOutputStream.f4798d.accept(file, str) || str.contains("SessionMissingBinaryImages");
        }
    }

    /* compiled from: CrashlyticsController.java */
    /* renamed from: c.b.a.d.h$r */
    /* loaded from: classes.dex */
    public static final class C0846r implements LogFileManager.InterfaceC0866b {

        /* renamed from: a */
        public final FileStore f4877a;

        public C0846r(FileStore fileStore) {
            this.f4877a = fileStore;
        }

        @Override // p070c.p074b.p075a.p078d.LogFileManager.InterfaceC0866b
        /* renamed from: a */
        public File mo5718a() {
            File file = new File(this.f4877a.mo3904a(), "log-files");
            if (!file.exists()) {
                file.mkdirs();
            }
            return file;
        }
    }

    /* compiled from: CrashlyticsController.java */
    /* renamed from: c.b.a.d.h$s */
    /* loaded from: classes.dex */
    public static final class C0847s implements ReportUploader.InterfaceC0825d {

        /* renamed from: a */
        public final Kit f4878a;

        /* renamed from: b */
        public final C0813b0 f4879b;

        /* renamed from: c */
        public final PromptSettingsData f4880c;

        /* compiled from: CrashlyticsController.java */
        /* renamed from: c.b.a.d.h$s$a */
        /* loaded from: classes.dex */
        public class C0848a implements CrashPromptDialog.InterfaceC0820d {
            public C0848a() {
            }

            @Override // p070c.p074b.p075a.p078d.CrashPromptDialog.InterfaceC0820d
            /* renamed from: a */
            public void mo5783a(boolean z) {
                C0847s.this.f4879b.m5967a(z);
            }
        }

        /* compiled from: CrashlyticsController.java */
        /* renamed from: c.b.a.d.h$s$b */
        /* loaded from: classes.dex */
        public class RunnableC0849b implements Runnable {

            /* renamed from: a */
            public final /* synthetic */ CrashPromptDialog f4882a;

            public RunnableC0849b(C0847s c0847s, CrashPromptDialog crashPromptDialog) {
                this.f4882a = crashPromptDialog;
            }

            @Override // java.lang.Runnable
            public void run() {
                this.f4882a.m5904c();
            }
        }

        public C0847s(Kit kit, C0813b0 c0813b0, PromptSettingsData promptSettingsData) {
            this.f4878a = kit;
            this.f4879b = c0813b0;
            this.f4880c = promptSettingsData;
        }

        @Override // p070c.p074b.p075a.p078d.ReportUploader.InterfaceC0825d
        /* renamed from: a */
        public boolean mo5785a() {
            Activity m4208b = this.f4878a.m4176g().m4208b();
            if (m4208b == null || m4208b.isFinishing()) {
                return true;
            }
            CrashPromptDialog m5907a = CrashPromptDialog.m5907a(m4208b, this.f4880c, new C0848a());
            m4208b.runOnUiThread(new RunnableC0849b(this, m5907a));
            Fabric.m4197h().mo4157e("CrashlyticsCore", "Waiting for user opt-in.");
            m5907a.m5909a();
            return m5907a.m5905b();
        }
    }

    /* compiled from: CrashlyticsController.java */
    /* renamed from: c.b.a.d.h$t */
    /* loaded from: classes.dex */
    public final class C0850t implements ReportUploader.InterfaceC0824c {
        public C0850t() {
        }

        @Override // p070c.p074b.p075a.p078d.ReportUploader.InterfaceC0824c
        /* renamed from: a */
        public File[] mo5782a() {
            return CrashlyticsController.this.m5800f().listFiles();
        }

        @Override // p070c.p074b.p075a.p078d.ReportUploader.InterfaceC0824c
        /* renamed from: b */
        public File[] mo5781b() {
            return CrashlyticsController.this.m5793j();
        }

        public /* synthetic */ C0850t(CrashlyticsController crashlyticsController, C0834f c0834f) {
            this();
        }
    }

    /* compiled from: CrashlyticsController.java */
    /* renamed from: c.b.a.d.h$u */
    /* loaded from: classes.dex */
    public final class C0851u implements ReportUploader.InterfaceC0823b {
        public C0851u() {
        }

        @Override // p070c.p074b.p075a.p078d.ReportUploader.InterfaceC0823b
        /* renamed from: a */
        public boolean mo5780a() {
            return CrashlyticsController.this.m5794i();
        }

        public /* synthetic */ C0851u(CrashlyticsController crashlyticsController, C0834f c0834f) {
            this();
        }
    }

    /* compiled from: CrashlyticsController.java */
    /* renamed from: c.b.a.d.h$v */
    /* loaded from: classes.dex */
    public static final class RunnableC0852v implements Runnable {

        /* renamed from: a */
        public final Context f4885a;

        /* renamed from: b */
        public final Report f4886b;

        /* renamed from: c */
        public final ReportUploader f4887c;

        public RunnableC0852v(Context context, Report report, ReportUploader reportUploader) {
            this.f4885a = context;
            this.f4886b = report;
            this.f4887c = reportUploader;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (CommonUtils.m4088b(this.f4885a)) {
                Fabric.m4197h().mo4157e("CrashlyticsCore", "Attempting to send crash report at time of crash...");
                this.f4887c.m5898a(this.f4886b);
            }
        }
    }

    /* compiled from: CrashlyticsController.java */
    /* renamed from: c.b.a.d.h$w */
    /* loaded from: classes.dex */
    public static class C0853w implements FilenameFilter {

        /* renamed from: a */
        public final String f4888a;

        public C0853w(String str) {
            this.f4888a = str;
        }

        @Override // java.io.FilenameFilter
        public boolean accept(File file, String str) {
            StringBuilder sb = new StringBuilder();
            sb.append(this.f4888a);
            sb.append(".cls");
            return (str.equals(sb.toString()) || !str.contains(this.f4888a) || str.endsWith(".cls_temp")) ? false : true;
        }
    }

    static {
        new C0837i();
        f4834t = Pattern.compile("([\\d|A-Z|a-z]{12}\\-[\\d|A-Z|a-z]{4}\\-[\\d|A-Z|a-z]{4}\\-[\\d|A-Z|a-z]{12}).+");
        f4835u = Collections.singletonMap("X-CRASHLYTICS-SEND-FLAGS", "1");
        f4836v = new String[]{"SessionUser", "SessionApp", "SessionOS", "SessionDevice"};
    }

    public CrashlyticsController(CrashlyticsCore crashlyticsCore, CrashlyticsBackgroundWorker crashlyticsBackgroundWorker, HttpRequestFactory httpRequestFactory, IdManager idManager, C0813b0 c0813b0, FileStore fileStore, AppData appData, UnityVersionProvider unityVersionProvider) {
        this.f4838b = crashlyticsCore;
        this.f4839c = crashlyticsBackgroundWorker;
        this.f4840d = httpRequestFactory;
        this.f4841e = idManager;
        this.f4842f = c0813b0;
        this.f4843g = fileStore;
        this.f4844h = appData;
        this.f4851o = unityVersionProvider.mo5713a();
        Context m4178e = crashlyticsCore.m4178e();
        this.f4845i = new C0846r(fileStore);
        this.f4846j = new LogFileManager(m4178e, this.f4845i);
        this.f4847k = new C0850t(this, null);
        this.f4848l = new C0851u(this, null);
        this.f4849m = new DevicePowerStateListener(m4178e);
        this.f4850n = new MiddleOutFallbackStrategy(1024, new RemoveRepeatsStrategy(10));
    }

    /* renamed from: b */
    public final File[] m5809b(File[] fileArr) {
        return fileArr == null ? new File[0] : fileArr;
    }

    /* renamed from: e */
    public final void m5801e(String str) {
        ClsFileOutputStream clsFileOutputStream;
        Throwable th;
        CodedOutputStream codedOutputStream;
        try {
            clsFileOutputStream = new ClsFileOutputStream(m5802e(), str + "SessionApp");
            try {
                codedOutputStream = CodedOutputStream.m5945a(clsFileOutputStream);
            } catch (Throwable th2) {
                th = th2;
                codedOutputStream = null;
            }
        } catch (Throwable th3) {
            clsFileOutputStream = null;
            th = th3;
            codedOutputStream = null;
        }
        try {
            SessionProtobufHelper.m5873a(codedOutputStream, this.f4841e.m4048e(), this.f4844h.f4782a, this.f4844h.f4786e, this.f4844h.f4787f, this.f4841e.m4047f(), DeliveryMechanism.m4065a(this.f4844h.f4784c).m4064b(), this.f4851o);
            CommonUtils.m4101a(codedOutputStream, "Failed to flush to session app file.");
            CommonUtils.m4103a((Closeable) clsFileOutputStream, "Failed to close session app file.");
        } catch (Throwable th4) {
            th = th4;
            CommonUtils.m4101a(codedOutputStream, "Failed to flush to session app file.");
            CommonUtils.m4103a((Closeable) clsFileOutputStream, "Failed to close session app file.");
            throw th;
        }
    }

    /* renamed from: f */
    public final void m5799f(String str) {
        ClsFileOutputStream clsFileOutputStream;
        CodedOutputStream codedOutputStream = null;
        try {
            clsFileOutputStream = new ClsFileOutputStream(m5802e(), str + "SessionDevice");
        } catch (Throwable th) {
            th = th;
            clsFileOutputStream = null;
        }
        try {
            codedOutputStream = CodedOutputStream.m5945a(clsFileOutputStream);
            Context m4178e = this.f4838b.m4178e();
            StatFs statFs = new StatFs(Environment.getDataDirectory().getPath());
            SessionProtobufHelper.m5876a(codedOutputStream, this.f4841e.m4045h(), CommonUtils.m4113a(), Build.MODEL, Runtime.getRuntime().availableProcessors(), CommonUtils.m4090b(), statFs.getBlockCount() * statFs.getBlockSize(), CommonUtils.m4072l(m4178e), this.f4841e.m4046g(), CommonUtils.m4078f(m4178e), Build.MANUFACTURER, Build.PRODUCT);
            CommonUtils.m4101a(codedOutputStream, "Failed to flush session device info.");
            CommonUtils.m4103a((Closeable) clsFileOutputStream, "Failed to close session device file.");
        } catch (Throwable th2) {
            th = th2;
            CommonUtils.m4101a(codedOutputStream, "Failed to flush session device info.");
            CommonUtils.m4103a((Closeable) clsFileOutputStream, "Failed to close session device file.");
            throw th;
        }
    }

    /* renamed from: g */
    public final void m5797g(String str) {
        ClsFileOutputStream clsFileOutputStream;
        CodedOutputStream codedOutputStream = null;
        try {
            clsFileOutputStream = new ClsFileOutputStream(m5802e(), str + "SessionOS");
        } catch (Throwable th) {
            th = th;
            clsFileOutputStream = null;
        }
        try {
            codedOutputStream = CodedOutputStream.m5945a(clsFileOutputStream);
            SessionProtobufHelper.m5870a(codedOutputStream, CommonUtils.m4071m(this.f4838b.m4178e()));
            CommonUtils.m4101a(codedOutputStream, "Failed to flush to session OS file.");
            CommonUtils.m4103a((Closeable) clsFileOutputStream, "Failed to close session OS file.");
        } catch (Throwable th2) {
            th = th2;
            CommonUtils.m4101a(codedOutputStream, "Failed to flush to session OS file.");
            CommonUtils.m4103a((Closeable) clsFileOutputStream, "Failed to close session OS file.");
            throw th;
        }
    }

    /* renamed from: h */
    public final String m5796h() {
        File[] m5791l = m5791l();
        if (m5791l.length > 1) {
            return m5814b(m5791l[1]);
        }
        return null;
    }

    /* renamed from: i */
    public boolean m5794i() {
        CrashlyticsUncaughtExceptionHandler crashlyticsUncaughtExceptionHandler = this.f4852p;
        return crashlyticsUncaughtExceptionHandler != null && crashlyticsUncaughtExceptionHandler.m5751a();
    }

    /* renamed from: j */
    public File[] m5793j() {
        LinkedList linkedList = new LinkedList();
        Collections.addAll(linkedList, m5839a(m5805d(), f4831q));
        Collections.addAll(linkedList, m5839a(m5798g(), f4831q));
        Collections.addAll(linkedList, m5839a(m5802e(), f4831q));
        return (File[]) linkedList.toArray(new File[linkedList.size()]);
    }

    /* renamed from: k */
    public File[] m5792k() {
        return m5836a(new C0844p("BeginSession"));
    }

    /* renamed from: l */
    public final File[] m5791l() {
        File[] m5792k = m5792k();
        Arrays.sort(m5792k, f4832r);
        return m5792k;
    }

    /* renamed from: m */
    public void m5790m() {
        this.f4839c.m5892a(new CallableC0829a());
    }

    /* renamed from: n */
    public final void m5789n() {
        File m5800f = m5800f();
        if (m5800f.exists()) {
            File[] m5839a = m5839a(m5800f, new C0845q());
            Arrays.sort(m5839a, Collections.reverseOrder());
            HashSet hashSet = new HashSet();
            for (int i = 0; i < m5839a.length && hashSet.size() < 4; i++) {
                hashSet.add(m5814b(m5839a[i]));
            }
            m5823a(m5840a(m5800f), hashSet);
        }
    }

    /* renamed from: c */
    public final String m5808c() {
        File[] m5791l = m5791l();
        if (m5791l.length > 0) {
            return m5814b(m5791l[0]);
        }
        return null;
    }

    /* renamed from: d */
    public final File[] m5803d(String str) {
        return m5836a(new C0853w(str));
    }

    /* renamed from: d */
    public File m5805d() {
        return new File(m5802e(), "fatal-sessions");
    }

    /* renamed from: b */
    public void m5811b(Thread thread, Throwable th) {
        this.f4839c.m5893a(new RunnableC0841m(new Date(), thread, th));
    }

    /* renamed from: h */
    public final void m5795h(String str) {
        ClsFileOutputStream clsFileOutputStream;
        CodedOutputStream codedOutputStream = null;
        try {
            clsFileOutputStream = new ClsFileOutputStream(m5802e(), str + "SessionUser");
        } catch (Throwable th) {
            th = th;
            clsFileOutputStream = null;
        }
        try {
            codedOutputStream = CodedOutputStream.m5945a(clsFileOutputStream);
            UserMetaData m5806c = m5806c(str);
            if (m5806c.m5752a()) {
                CommonUtils.m4101a(codedOutputStream, "Failed to flush session user file.");
                CommonUtils.m4103a((Closeable) clsFileOutputStream, "Failed to close session user file.");
                return;
            }
            SessionProtobufHelper.m5874a(codedOutputStream, m5806c.f4920a, m5806c.f4921b, m5806c.f4922c);
            CommonUtils.m4101a(codedOutputStream, "Failed to flush session user file.");
            CommonUtils.m4103a((Closeable) clsFileOutputStream, "Failed to close session user file.");
        } catch (Throwable th2) {
            th = th2;
            CommonUtils.m4101a(codedOutputStream, "Failed to flush session user file.");
            CommonUtils.m4103a((Closeable) clsFileOutputStream, "Failed to close session user file.");
            throw th;
        }
    }

    /* renamed from: c */
    public final UserMetaData m5806c(String str) {
        if (m5794i()) {
            return new UserMetaData(this.f4838b.m5762v(), this.f4838b.m5761w(), this.f4838b.m5763u());
        }
        return new MetaDataStore(m5802e()).m5706d(str);
    }

    /* renamed from: b */
    public static String m5814b(File file) {
        return file.getName().substring(0, 35);
    }

    /* renamed from: a */
    public void m5828a(Thread.UncaughtExceptionHandler uncaughtExceptionHandler) {
        m5790m();
        this.f4852p = new CrashlyticsUncaughtExceptionHandler(new C0838j(), uncaughtExceptionHandler);
        Thread.setDefaultUncaughtExceptionHandler(this.f4852p);
    }

    /* renamed from: b */
    public boolean m5816b(SessionSettingsData sessionSettingsData) {
        return ((Boolean) this.f4839c.m5891b(new CallableC0830b(sessionSettingsData))).booleanValue();
    }

    /* renamed from: b */
    public final void m5822b() {
        Date date = new Date();
        String clsuuid = new CLSUUID(this.f4841e).toString();
        Logger m4197h = Fabric.m4197h();
        m4197h.mo4157e("CrashlyticsCore", "Opening a new session with ID " + clsuuid);
        m5830a(clsuuid, date);
        m5801e(clsuuid);
        m5797g(clsuuid);
        m5799f(clsuuid);
        this.f4846j.m5719b(clsuuid);
    }

    /* renamed from: g */
    public File m5798g() {
        return new File(m5802e(), "nonfatal-sessions");
    }

    /* renamed from: a */
    public synchronized void m5827a(Thread thread, Throwable th) {
        Logger m4197h = Fabric.m4197h();
        m4197h.mo4157e("CrashlyticsCore", "Crashlytics is handling uncaught exception \"" + th + "\" from thread " + thread.getName());
        this.f4849m.m5742a();
        this.f4839c.m5891b(new CallableC0839k(new Date(), thread, th));
    }

    /* renamed from: e */
    public File m5802e() {
        return this.f4843g.mo3904a();
    }

    /* renamed from: b */
    public void m5821b(int i) {
        int m5749a = i - Utils.m5749a(m5805d(), i, f4833s);
        Utils.m5748a(m5802e(), f4831q, m5749a - Utils.m5749a(m5798g(), m5749a, f4833s), f4833s);
    }

    /* renamed from: a */
    public void m5858a(float f, SettingsData settingsData) {
        if (settingsData == null) {
            Fabric.m4197h().mo4164a("CrashlyticsCore", "Could not send reports. Settings are not available.");
            return;
        }
        new ReportUploader(this.f4844h.f4782a, m5813b(settingsData.f6657a.f6620c), this.f4847k, this.f4848l).m5899a(f, m5815b(settingsData) ? new C0847s(this.f4838b, this.f4842f, settingsData.f6659c) : new ReportUploader.C0822a());
    }

    /* renamed from: b */
    public final void m5810b(Date date, Thread thread, Throwable th) {
        ClsFileOutputStream clsFileOutputStream;
        String m5808c;
        CodedOutputStream codedOutputStream = null;
        try {
            try {
                m5808c = m5808c();
            } catch (Exception e) {
                e = e;
                clsFileOutputStream = null;
            } catch (Throwable th2) {
                th = th2;
                clsFileOutputStream = null;
                CommonUtils.m4101a(codedOutputStream, "Failed to flush to session begin file.");
                CommonUtils.m4103a((Closeable) clsFileOutputStream, "Failed to close fatal exception file output stream.");
                throw th;
            }
            if (m5808c == null) {
                Fabric.m4197h().mo4159c("CrashlyticsCore", "Tried to write a fatal exception while no session was open.", null);
                CommonUtils.m4101a((Flushable) null, "Failed to flush to session begin file.");
                CommonUtils.m4103a((Closeable) null, "Failed to close fatal exception file output stream.");
                return;
            }
            m5832a(m5808c, th.getClass().getName());
            clsFileOutputStream = new ClsFileOutputStream(m5802e(), m5808c + "SessionCrash");
            try {
                codedOutputStream = CodedOutputStream.m5945a(clsFileOutputStream);
                m5852a(codedOutputStream, date, thread, th, "crash", true);
            } catch (Exception e2) {
                e = e2;
                Fabric.m4197h().mo4159c("CrashlyticsCore", "An error occurred in the fatal exception logger", e);
                CommonUtils.m4101a(codedOutputStream, "Failed to flush to session begin file.");
                CommonUtils.m4103a((Closeable) clsFileOutputStream, "Failed to close fatal exception file output stream.");
            }
            CommonUtils.m4101a(codedOutputStream, "Failed to flush to session begin file.");
            CommonUtils.m4103a((Closeable) clsFileOutputStream, "Failed to close fatal exception file output stream.");
        } catch (Throwable th3) {
            th = th3;
            CommonUtils.m4101a(codedOutputStream, "Failed to flush to session begin file.");
            CommonUtils.m4103a((Closeable) clsFileOutputStream, "Failed to close fatal exception file output stream.");
            throw th;
        }
    }

    /* renamed from: f */
    public File m5800f() {
        return new File(m5802e(), "invalidClsFiles");
    }

    /* renamed from: a */
    public void m5856a(long j, String str) {
        this.f4839c.m5892a(new CallableC0840l(j, str));
    }

    /* renamed from: a */
    public void m5831a(String str, String str2, String str3) {
        this.f4839c.m5892a(new CallableC0842n(str, str2, str3));
    }

    /* renamed from: a */
    public void m5843a(SessionSettingsData sessionSettingsData) {
        m5842a(sessionSettingsData, false);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: a */
    public final void m5842a(SessionSettingsData sessionSettingsData, boolean z) {
        m5857a((z ? 1 : 0) + 8);
        File[] m5791l = m5791l();
        if (m5791l.length <= z) {
            Fabric.m4197h().mo4157e("CrashlyticsCore", "No open sessions to be closed.");
            return;
        }
        m5795h(m5814b(m5791l[z ? 1 : 0]));
        if (sessionSettingsData == null) {
            Fabric.m4197h().mo4157e("CrashlyticsCore", "Unable to close session. Settings are not loaded.");
            return;
        }
        m5824a(m5791l, z ? 1 : 0, sessionSettingsData.f6646a);
    }

    /* renamed from: b */
    public void m5817b(SessionEventData sessionEventData) {
        this.f4839c.m5892a(new CallableC0833e(sessionEventData));
    }

    /* renamed from: b */
    public final boolean m5815b(SettingsData settingsData) {
        return (settingsData == null || !settingsData.f6660d.f6632a || this.f4842f.m5969a()) ? false : true;
    }

    /* renamed from: b */
    public final CreateReportSpiCall m5813b(String str) {
        return new DefaultCreateReportSpiCall(this.f4838b, CommonUtils.m4087b(this.f4838b.m4178e(), "com.crashlytics.ApiEndpoint"), str, this.f4840d);
    }

    /* renamed from: a */
    public final void m5824a(File[] fileArr, int i, int i2) {
        Fabric.m4197h().mo4157e("CrashlyticsCore", "Closing open sessions.");
        while (i < fileArr.length) {
            File file = fileArr[i];
            String m5814b = m5814b(file);
            Logger m4197h = Fabric.m4197h();
            m4197h.mo4157e("CrashlyticsCore", "Closing session: " + m5814b);
            m5838a(file, m5814b, i2);
            i++;
        }
    }

    /* renamed from: b */
    public static void m5812b(String str, String str2) {
        Answers answers = (Answers) Fabric.m4212a(Answers.class);
        if (answers == null) {
            Fabric.m4197h().mo4157e("CrashlyticsCore", "Answers is not available");
        } else {
            answers.m6076a(new Crash.C1493b(str, str2));
        }
    }

    /* renamed from: a */
    public final void m5855a(ClsFileOutputStream clsFileOutputStream) {
        if (clsFileOutputStream == null) {
            return;
        }
        try {
            clsFileOutputStream.m5959j();
        } catch (IOException e) {
            Fabric.m4197h().mo4159c("CrashlyticsCore", "Error closing session file stream in the presence of an exception", e);
        }
    }

    /* renamed from: a */
    public final void m5834a(String str) {
        for (File file : m5803d(str)) {
            file.delete();
        }
    }

    /* renamed from: a */
    public final File[] m5836a(FilenameFilter filenameFilter) {
        return m5839a(m5802e(), filenameFilter);
    }

    /* renamed from: a */
    public final File[] m5839a(File file, FilenameFilter filenameFilter) {
        return m5809b(file.listFiles(filenameFilter));
    }

    /* renamed from: a */
    public final File[] m5840a(File file) {
        return m5809b(file.listFiles());
    }

    /* renamed from: a */
    public final void m5833a(String str, int i) {
        File m5802e = m5802e();
        Utils.m5748a(m5802e, new C0844p(str + "SessionEvent"), i, f4833s);
    }

    /* renamed from: a */
    public final void m5857a(int i) {
        HashSet hashSet = new HashSet();
        File[] m5791l = m5791l();
        int min = Math.min(i, m5791l.length);
        for (int i2 = 0; i2 < min; i2++) {
            hashSet.add(m5814b(m5791l[i2]));
        }
        this.f4846j.m5721a(hashSet);
        m5823a(m5836a(new C0843o(null)), hashSet);
    }

    /* renamed from: a */
    public final void m5823a(File[] fileArr, Set<String> set) {
        for (File file : fileArr) {
            String name = file.getName();
            Matcher matcher = f4834t.matcher(name);
            if (!matcher.matches()) {
                Fabric.m4197h().mo4157e("CrashlyticsCore", "Deleting unknown file: " + name);
                file.delete();
                return;
            }
            if (!set.contains(matcher.group(1))) {
                Fabric.m4197h().mo4157e("CrashlyticsCore", "Trimming session file: " + name);
                file.delete();
            }
        }
    }

    /* renamed from: a */
    public final File[] m5829a(String str, File[] fileArr, int i) {
        if (fileArr.length > i) {
            Fabric.m4197h().mo4157e("CrashlyticsCore", String.format(Locale.US, "Trimming down to %d logged exceptions.", Integer.valueOf(i)));
            m5833a(str, i);
            return m5836a(new C0844p(str + "SessionEvent"));
        }
        return fileArr;
    }

    /* renamed from: a */
    public void m5859a() {
        this.f4839c.m5893a(new RunnableC0831c());
    }

    /* renamed from: a */
    public void m5825a(File[] fileArr) {
        File[] m5836a;
        HashSet hashSet = new HashSet();
        for (File file : fileArr) {
            Fabric.m4197h().mo4157e("CrashlyticsCore", "Found invalid session part file: " + file);
            hashSet.add(m5814b(file));
        }
        if (hashSet.isEmpty()) {
            return;
        }
        File m5800f = m5800f();
        if (!m5800f.exists()) {
            m5800f.mkdir();
        }
        for (File file2 : m5836a(new C0832d(this, hashSet))) {
            Fabric.m4197h().mo4157e("CrashlyticsCore", "Moving session file: " + file2);
            if (!file2.renameTo(new File(m5800f, file2.getName()))) {
                Fabric.m4197h().mo4157e("CrashlyticsCore", "Could not move session file. Deleting " + file2);
                file2.delete();
            }
        }
        m5789n();
    }

    /* renamed from: a */
    public final void m5844a(SessionEventData sessionEventData) {
        ClsFileOutputStream clsFileOutputStream;
        String m5796h;
        CodedOutputStream codedOutputStream = null;
        try {
            try {
                m5796h = m5796h();
            } catch (Exception e) {
                e = e;
                clsFileOutputStream = null;
            } catch (Throwable th) {
                th = th;
                clsFileOutputStream = null;
                CommonUtils.m4101a(codedOutputStream, "Failed to flush to session begin file.");
                CommonUtils.m4103a((Closeable) clsFileOutputStream, "Failed to close fatal exception file output stream.");
                throw th;
            }
            if (m5796h == null) {
                Fabric.m4197h().mo4159c("CrashlyticsCore", "Tried to write a native crash while no session was open.", null);
                CommonUtils.m4101a((Flushable) null, "Failed to flush to session begin file.");
                CommonUtils.m4103a((Closeable) null, "Failed to close fatal exception file output stream.");
                return;
            }
            boolean z = false;
            m5832a(m5796h, String.format(Locale.US, "<native-crash [%s (%s)]>", sessionEventData.f4944b.f4950b, sessionEventData.f4944b.f4949a));
            if (sessionEventData.f4946d != null && sessionEventData.f4946d.length > 0) {
                z = true;
            }
            String str = z ? "SessionCrash" : "SessionMissingBinaryImages";
            clsFileOutputStream = new ClsFileOutputStream(m5802e(), m5796h + str);
            try {
                codedOutputStream = CodedOutputStream.m5945a(clsFileOutputStream);
                NativeCrashWriter.m5699a(sessionEventData, new LogFileManager(this.f4838b.m4178e(), this.f4845i, m5796h), new MetaDataStore(m5802e()).m5707c(m5796h), codedOutputStream);
            } catch (Exception e2) {
                e = e2;
                Fabric.m4197h().mo4159c("CrashlyticsCore", "An error occurred in the native crash logger", e);
                CommonUtils.m4101a(codedOutputStream, "Failed to flush to session begin file.");
                CommonUtils.m4103a((Closeable) clsFileOutputStream, "Failed to close fatal exception file output stream.");
            }
            CommonUtils.m4101a(codedOutputStream, "Failed to flush to session begin file.");
            CommonUtils.m4103a((Closeable) clsFileOutputStream, "Failed to close fatal exception file output stream.");
        } catch (Throwable th2) {
            th = th2;
            CommonUtils.m4101a(codedOutputStream, "Failed to flush to session begin file.");
            CommonUtils.m4103a((Closeable) clsFileOutputStream, "Failed to close fatal exception file output stream.");
            throw th;
        }
    }

    /* renamed from: a */
    public final void m5826a(Date date, Thread thread, Throwable th) {
        ClsFileOutputStream clsFileOutputStream;
        String m5808c = m5808c();
        CodedOutputStream codedOutputStream = null;
        if (m5808c == null) {
            Fabric.m4197h().mo4159c("CrashlyticsCore", "Tried to write a non-fatal exception while no session was open.", null);
            return;
        }
        m5812b(m5808c, th.getClass().getName());
        try {
            try {
                Fabric.m4197h().mo4157e("CrashlyticsCore", "Crashlytics is logging non-fatal exception \"" + th + "\" from thread " + thread.getName());
                clsFileOutputStream = new ClsFileOutputStream(m5802e(), m5808c + "SessionEvent" + CommonUtils.m4089b(this.f4837a.getAndIncrement()));
                try {
                    CodedOutputStream m5945a = CodedOutputStream.m5945a(clsFileOutputStream);
                    try {
                        CrashlyticsController crashlyticsController = this;
                        crashlyticsController.m5852a(m5945a, date, thread, th, "error", false);
                        CommonUtils.m4101a(m5945a, "Failed to flush to non-fatal file.");
                        codedOutputStream = crashlyticsController;
                    } catch (Exception e) {
                        e = e;
                        codedOutputStream = m5945a;
                        Fabric.m4197h().mo4159c("CrashlyticsCore", "An error occurred in the non-fatal exception logger", e);
                        CommonUtils.m4101a(codedOutputStream, "Failed to flush to non-fatal file.");
                        codedOutputStream = codedOutputStream;
                        CommonUtils.m4103a((Closeable) clsFileOutputStream, "Failed to close non-fatal file output stream.");
                        m5833a(m5808c, 64);
                    } catch (Throwable th2) {
                        th = th2;
                        codedOutputStream = m5945a;
                        CommonUtils.m4101a(codedOutputStream, "Failed to flush to non-fatal file.");
                        CommonUtils.m4103a((Closeable) clsFileOutputStream, "Failed to close non-fatal file output stream.");
                        throw th;
                    }
                } catch (Exception e2) {
                    e = e2;
                }
            } catch (Exception e3) {
                e = e3;
                clsFileOutputStream = null;
            } catch (Throwable th3) {
                th = th3;
                clsFileOutputStream = null;
            }
            CommonUtils.m4103a((Closeable) clsFileOutputStream, "Failed to close non-fatal file output stream.");
            try {
                m5833a(m5808c, 64);
            } catch (Exception e4) {
                Fabric.m4197h().mo4159c("CrashlyticsCore", "An error occurred when trimming non-fatal files.", e4);
            }
        } catch (Throwable th4) {
            th = th4;
        }
    }

    /* renamed from: a */
    public final void m5830a(String str, Date date) {
        ClsFileOutputStream clsFileOutputStream;
        CodedOutputStream codedOutputStream = null;
        try {
            clsFileOutputStream = new ClsFileOutputStream(m5802e(), str + "BeginSession");
        } catch (Throwable th) {
            th = th;
            clsFileOutputStream = null;
        }
        try {
            codedOutputStream = CodedOutputStream.m5945a(clsFileOutputStream);
            SessionProtobufHelper.m5875a(codedOutputStream, str, String.format(Locale.US, "Crashlytics Android SDK/%s", this.f4838b.mo4148k()), date.getTime() / 1000);
            CommonUtils.m4101a(codedOutputStream, "Failed to flush to session begin file.");
            CommonUtils.m4103a((Closeable) clsFileOutputStream, "Failed to close begin session file.");
        } catch (Throwable th2) {
            th = th2;
            CommonUtils.m4101a(codedOutputStream, "Failed to flush to session begin file.");
            CommonUtils.m4103a((Closeable) clsFileOutputStream, "Failed to close begin session file.");
            throw th;
        }
    }

    /* JADX WARN: Type inference failed for: r6v2 */
    /* JADX WARN: Type inference failed for: r6v3, types: [boolean] */
    /* JADX WARN: Type inference failed for: r6v5 */
    /* renamed from: a */
    public final void m5852a(CodedOutputStream codedOutputStream, Date date, Thread thread, Throwable th, String str, boolean z) {
        ?? r6;
        Thread[] threadArr;
        Map<String, String> m5765s;
        TreeMap treeMap;
        TrimmedThrowableData trimmedThrowableData = new TrimmedThrowableData(th, this.f4850n);
        Context m4178e = this.f4838b.m4178e();
        long time = date.getTime() / 1000;
        Float m4079e = CommonUtils.m4079e(m4178e);
        int m4105a = CommonUtils.m4105a(m4178e, this.f4849m.m5740b());
        boolean m4077g = CommonUtils.m4077g(m4178e);
        int i = m4178e.getResources().getConfiguration().orientation;
        long m4090b = CommonUtils.m4090b() - CommonUtils.m4111a(m4178e);
        long m4097a = CommonUtils.m4097a(Environment.getDataDirectory().getPath());
        ActivityManager.RunningAppProcessInfo m4096a = CommonUtils.m4096a(m4178e.getPackageName(), m4178e);
        LinkedList linkedList = new LinkedList();
        StackTraceElement[] stackTraceElementArr = trimmedThrowableData.f4916c;
        String str2 = this.f4844h.f4783b;
        String m4048e = this.f4841e.m4048e();
        int i2 = 0;
        if (z) {
            Map<Thread, StackTraceElement[]> allStackTraces = Thread.getAllStackTraces();
            Thread[] threadArr2 = new Thread[allStackTraces.size()];
            for (Map.Entry<Thread, StackTraceElement[]> entry : allStackTraces.entrySet()) {
                threadArr2[i2] = entry.getKey();
                linkedList.add(this.f4850n.mo5703a(entry.getValue()));
                i2++;
            }
            r6 = 1;
            threadArr = threadArr2;
        } else {
            r6 = 1;
            threadArr = new Thread[0];
        }
        if (!CommonUtils.m4106a(m4178e, "com.crashlytics.CollectCustomKeys", (boolean) r6)) {
            m5765s = new TreeMap<>();
        } else {
            m5765s = this.f4838b.m5765s();
            if (m5765s != null && m5765s.size() > r6) {
                treeMap = new TreeMap(m5765s);
                SessionProtobufHelper.m5882a(codedOutputStream, time, str, trimmedThrowableData, thread, stackTraceElementArr, threadArr, linkedList, treeMap, this.f4846j, m4096a, i, m4048e, str2, m4079e, m4105a, m4077g, m4090b, m4097a);
            }
        }
        treeMap = m5765s;
        SessionProtobufHelper.m5882a(codedOutputStream, time, str, trimmedThrowableData, thread, stackTraceElementArr, threadArr, linkedList, treeMap, this.f4846j, m4096a, i, m4048e, str2, m4079e, m4105a, m4077g, m4090b, m4097a);
    }

    /* renamed from: a */
    public final void m5838a(File file, String str, int i) {
        Logger m4197h = Fabric.m4197h();
        m4197h.mo4157e("CrashlyticsCore", "Collecting session parts for ID " + str);
        File[] m5836a = m5836a(new C0844p(str + "SessionCrash"));
        boolean z = m5836a != null && m5836a.length > 0;
        Fabric.m4197h().mo4157e("CrashlyticsCore", String.format(Locale.US, "Session %s has fatal exception: %s", str, Boolean.valueOf(z)));
        File[] m5836a2 = m5836a(new C0844p(str + "SessionEvent"));
        boolean z2 = m5836a2 != null && m5836a2.length > 0;
        Fabric.m4197h().mo4157e("CrashlyticsCore", String.format(Locale.US, "Session %s has non-fatal exceptions: %s", str, Boolean.valueOf(z2)));
        if (!z && !z2) {
            Logger m4197h2 = Fabric.m4197h();
            m4197h2.mo4157e("CrashlyticsCore", "No events present for session ID " + str);
        } else {
            m5837a(file, str, m5829a(str, m5836a2, i), z ? m5836a[0] : null);
        }
        Logger m4197h3 = Fabric.m4197h();
        m4197h3.mo4157e("CrashlyticsCore", "Removing session part files for ID " + str);
        m5834a(str);
    }

    /* renamed from: a */
    public final void m5837a(File file, String str, File[] fileArr, File file2) {
        ClsFileOutputStream clsFileOutputStream;
        boolean z = file2 != null;
        File m5805d = z ? m5805d() : m5798g();
        if (!m5805d.exists()) {
            m5805d.mkdirs();
        }
        CodedOutputStream codedOutputStream = null;
        try {
            clsFileOutputStream = new ClsFileOutputStream(m5805d, str);
        } catch (Exception e) {
            e = e;
            clsFileOutputStream = null;
        } catch (Throwable th) {
            th = th;
            clsFileOutputStream = null;
            CommonUtils.m4101a(codedOutputStream, "Error flushing session file stream");
            CommonUtils.m4103a((Closeable) clsFileOutputStream, "Failed to close CLS file");
            throw th;
        }
        try {
            try {
                codedOutputStream = CodedOutputStream.m5945a(clsFileOutputStream);
                Fabric.m4197h().mo4157e("CrashlyticsCore", "Collecting SessionStart data for session ID " + str);
                m5854a(codedOutputStream, file);
                codedOutputStream.m5951a(4, new Date().getTime() / 1000);
                codedOutputStream.m5949a(5, z);
                codedOutputStream.m5924d(11, 1);
                codedOutputStream.m5952a(12, 3);
                m5853a(codedOutputStream, str);
                m5851a(codedOutputStream, fileArr, str);
                if (z) {
                    m5854a(codedOutputStream, file2);
                }
                CommonUtils.m4101a(codedOutputStream, "Error flushing session file stream");
                CommonUtils.m4103a((Closeable) clsFileOutputStream, "Failed to close CLS file");
            } catch (Throwable th2) {
                th = th2;
                CommonUtils.m4101a(codedOutputStream, "Error flushing session file stream");
                CommonUtils.m4103a((Closeable) clsFileOutputStream, "Failed to close CLS file");
                throw th;
            }
        } catch (Exception e2) {
            e = e2;
            Fabric.m4197h().mo4159c("CrashlyticsCore", "Failed to write session file for session ID: " + str, e);
            CommonUtils.m4101a(codedOutputStream, "Error flushing session file stream");
            m5855a(clsFileOutputStream);
        }
    }

    /* renamed from: a */
    public static void m5851a(CodedOutputStream codedOutputStream, File[] fileArr, String str) {
        Arrays.sort(fileArr, CommonUtils.f6437d);
        for (File file : fileArr) {
            try {
                Fabric.m4197h().mo4157e("CrashlyticsCore", String.format(Locale.US, "Found Non Fatal for session ID %s in %s ", str, file.getName()));
                m5854a(codedOutputStream, file);
            } catch (Exception e) {
                Fabric.m4197h().mo4159c("CrashlyticsCore", "Error writting non-fatal to session.", e);
            }
        }
    }

    /* renamed from: a */
    public final void m5853a(CodedOutputStream codedOutputStream, String str) {
        String[] strArr;
        for (String str2 : f4836v) {
            File[] m5836a = m5836a(new C0844p(str + str2));
            if (m5836a.length == 0) {
                Fabric.m4197h().mo4159c("CrashlyticsCore", "Can't find " + str2 + " data for session ID " + str, null);
            } else {
                Fabric.m4197h().mo4157e("CrashlyticsCore", "Collecting " + str2 + " data for session ID " + str);
                m5854a(codedOutputStream, m5836a[0]);
            }
        }
    }

    /* renamed from: a */
    public static void m5854a(CodedOutputStream codedOutputStream, File file) {
        FileInputStream fileInputStream;
        if (!file.exists()) {
            Fabric.m4197h().mo4159c("CrashlyticsCore", "Tried to include a file that doesn't exist: " + file.getName(), null);
            return;
        }
        try {
            fileInputStream = new FileInputStream(file);
        } catch (Throwable th) {
            th = th;
            fileInputStream = null;
        }
        try {
            m5835a(fileInputStream, codedOutputStream, (int) file.length());
            CommonUtils.m4103a((Closeable) fileInputStream, "Failed to close file input stream.");
        } catch (Throwable th2) {
            th = th2;
            CommonUtils.m4103a((Closeable) fileInputStream, "Failed to close file input stream.");
            throw th;
        }
    }

    /* renamed from: a */
    public static void m5835a(InputStream inputStream, CodedOutputStream codedOutputStream, int i) {
        int read;
        byte[] bArr = new byte[i];
        int i2 = 0;
        while (i2 < bArr.length && (read = inputStream.read(bArr, i2, bArr.length - i2)) >= 0) {
            i2 += read;
        }
        codedOutputStream.m5942a(bArr);
    }

    /* renamed from: a */
    public final void m5841a(SettingsData settingsData) {
        if (settingsData == null) {
            Fabric.m4197h().mo4164a("CrashlyticsCore", "Cannot send reports. Settings are unavailable.");
            return;
        }
        Context m4178e = this.f4838b.m4178e();
        ReportUploader reportUploader = new ReportUploader(this.f4844h.f4782a, m5813b(settingsData.f6657a.f6620c), this.f4847k, this.f4848l);
        for (File file : m5793j()) {
            this.f4839c.m5893a(new RunnableC0852v(m4178e, new SessionReport(file, f4835u), reportUploader));
        }
    }

    /* renamed from: a */
    public static void m5832a(String str, String str2) {
        Answers answers = (Answers) Fabric.m4212a(Answers.class);
        if (answers == null) {
            Fabric.m4197h().mo4157e("CrashlyticsCore", "Answers is not available");
        } else {
            answers.m6077a(new Crash.C1492a(str, str2));
        }
    }
}
