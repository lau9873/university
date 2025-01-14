package p070c.p074b.p075a.p076b;

import android.app.Activity;
import android.content.Context;
import android.os.Looper;
import java.util.concurrent.ScheduledExecutorService;
import p070c.p074b.p075a.p076b.BackgroundManager;
import p070c.p074b.p075a.p076b.SessionEvent;
import p136d.p137a.p138a.p139a.ActivityLifecycleManager;
import p136d.p137a.p138a.p139a.Fabric;
import p136d.p137a.p138a.p139a.Kit;
import p136d.p137a.p138a.p139a.Logger;
import p136d.p137a.p138a.p139a.p140m.p142b.ExecutorUtils;
import p136d.p137a.p138a.p139a.p140m.p142b.IdManager;
import p136d.p137a.p138a.p139a.p140m.p146e.DefaultHttpRequestFactory;
import p136d.p137a.p138a.p139a.p140m.p147f.FileStoreImpl;
import p136d.p137a.p138a.p139a.p140m.p148g.AnalyticsSettingsData;

/* renamed from: c.b.a.b.u */
/* loaded from: classes.dex */
public class SessionAnalyticsManager implements BackgroundManager.InterfaceC0806b {

    /* renamed from: a */
    public final long f4712a;

    /* renamed from: b */
    public final AnswersEventsHandler f4713b;

    /* renamed from: c */
    public final ActivityLifecycleManager f4714c;

    /* renamed from: d */
    public final BackgroundManager f4715d;

    /* renamed from: e */
    public final AnswersPreferenceManager f4716e;

    public SessionAnalyticsManager(AnswersEventsHandler answersEventsHandler, ActivityLifecycleManager activityLifecycleManager, BackgroundManager backgroundManager, AnswersPreferenceManager answersPreferenceManager, long j) {
        this.f4713b = answersEventsHandler;
        this.f4714c = activityLifecycleManager;
        this.f4715d = backgroundManager;
        this.f4716e = answersPreferenceManager;
        this.f4712a = j;
    }

    /* renamed from: a */
    public static SessionAnalyticsManager m6024a(Kit kit, Context context, IdManager idManager, String str, String str2, long j) {
        SessionMetadataCollector sessionMetadataCollector = new SessionMetadataCollector(context, idManager, str, str2);
        AnswersFilesManagerProvider answersFilesManagerProvider = new AnswersFilesManagerProvider(context, new FileStoreImpl(kit));
        DefaultHttpRequestFactory defaultHttpRequestFactory = new DefaultHttpRequestFactory(Fabric.m4197h());
        ActivityLifecycleManager activityLifecycleManager = new ActivityLifecycleManager(context);
        ScheduledExecutorService m4059b = ExecutorUtils.m4059b("Answers Events Handler");
        return new SessionAnalyticsManager(new AnswersEventsHandler(kit, context, answersFilesManagerProvider, sessionMetadataCollector, defaultHttpRequestFactory, m4059b), activityLifecycleManager, new BackgroundManager(m4059b), AnswersPreferenceManager.m6046a(context), j);
    }

    /* renamed from: a */
    public void m6022a(String str) {
    }

    /* renamed from: b */
    public void m6020b() {
        this.f4714c.m4230a();
        this.f4713b.m6063a();
    }

    /* renamed from: c */
    public void m6019c() {
        this.f4713b.m6057b();
        this.f4714c.m4229a(new AnswersLifecycleCallbacks(this, this.f4715d));
        this.f4715d.m6042a(this);
        if (m6018d()) {
            m6027a(this.f4712a);
            this.f4716e.m6045b();
        }
    }

    /* renamed from: d */
    public boolean m6018d() {
        return !this.f4716e.m6047a();
    }

    /* renamed from: a */
    public void m6025a(CustomEvent customEvent) {
        Logger m4197h = Fabric.m4197h();
        m4197h.mo4157e("Answers", "Logged custom event: " + customEvent);
        this.f4713b.m6061a(SessionEvent.m6012a(customEvent));
    }

    /* renamed from: a */
    public void m6021a(String str, String str2) {
        if (Looper.myLooper() != Looper.getMainLooper()) {
            Fabric.m4197h().mo4157e("Answers", "Logged crash");
            this.f4713b.m6051c(SessionEvent.m6009a(str, str2));
            return;
        }
        throw new IllegalStateException("onCrash called from main thread!!!");
    }

    /* renamed from: a */
    public void m6027a(long j) {
        Fabric.m4197h().mo4157e("Answers", "Logged install");
        this.f4713b.m6055b(SessionEvent.m6013a(j));
    }

    /* renamed from: a */
    public void m6026a(Activity activity, SessionEvent.EnumC0810c enumC0810c) {
        Logger m4197h = Fabric.m4197h();
        m4197h.mo4157e("Answers", "Logged lifecycle event: " + enumC0810c.name());
        this.f4713b.m6061a(SessionEvent.m6011a(enumC0810c, activity));
    }

    @Override // p070c.p074b.p075a.p076b.BackgroundManager.InterfaceC0806b
    /* renamed from: a */
    public void mo6028a() {
        Fabric.m4197h().mo4157e("Answers", "Flush events when app is backgrounded");
        this.f4713b.m6053c();
    }

    /* renamed from: a */
    public void m6023a(AnalyticsSettingsData analyticsSettingsData, String str) {
        this.f4715d.m6040a(analyticsSettingsData.f6605g);
        this.f4713b.m6059a(analyticsSettingsData, str);
    }
}
