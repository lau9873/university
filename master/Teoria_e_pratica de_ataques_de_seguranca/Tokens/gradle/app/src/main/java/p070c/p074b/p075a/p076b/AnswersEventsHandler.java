package p070c.p074b.p075a.p076b;

import android.content.Context;
import java.util.concurrent.ScheduledExecutorService;
import p070c.p074b.p075a.p076b.SessionEvent;
import p136d.p137a.p138a.p139a.Fabric;
import p136d.p137a.p138a.p139a.Kit;
import p136d.p137a.p138a.p139a.p140m.p145d.EventsStorageListener;
import p136d.p137a.p138a.p139a.p140m.p146e.HttpRequestFactory;
import p136d.p137a.p138a.p139a.p140m.p148g.AnalyticsSettingsData;

/* renamed from: c.b.a.b.e */
/* loaded from: classes.dex */
public class AnswersEventsHandler implements EventsStorageListener {

    /* renamed from: a */
    public final Kit f4659a;

    /* renamed from: b */
    public final Context f4660b;

    /* renamed from: c */
    public final AnswersFilesManagerProvider f4661c;

    /* renamed from: d */
    public final SessionMetadataCollector f4662d;

    /* renamed from: e */
    public final HttpRequestFactory f4663e;

    /* renamed from: f */
    public final ScheduledExecutorService f4664f;

    /* renamed from: g */
    public SessionAnalyticsManagerStrategy f4665g = new DisabledSessionAnalyticsManagerStrategy();

    /* compiled from: AnswersEventsHandler.java */
    /* renamed from: c.b.a.b.e$a */
    /* loaded from: classes.dex */
    public class RunnableC0799a implements Runnable {

        /* renamed from: a */
        public final /* synthetic */ AnalyticsSettingsData f4666a;

        /* renamed from: b */
        public final /* synthetic */ String f4667b;

        public RunnableC0799a(AnalyticsSettingsData analyticsSettingsData, String str) {
            this.f4666a = analyticsSettingsData;
            this.f4667b = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                AnswersEventsHandler.this.f4665g.mo6015a(this.f4666a, this.f4667b);
            } catch (Exception e) {
                Fabric.m4197h().mo4159c("Answers", "Failed to set analytics settings data", e);
            }
        }
    }

    /* compiled from: AnswersEventsHandler.java */
    /* renamed from: c.b.a.b.e$b */
    /* loaded from: classes.dex */
    public class RunnableC0800b implements Runnable {
        public RunnableC0800b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                SessionAnalyticsManagerStrategy sessionAnalyticsManagerStrategy = AnswersEventsHandler.this.f4665g;
                AnswersEventsHandler.this.f4665g = new DisabledSessionAnalyticsManagerStrategy();
                sessionAnalyticsManagerStrategy.mo6014d();
            } catch (Exception e) {
                Fabric.m4197h().mo4159c("Answers", "Failed to disable events", e);
            }
        }
    }

    /* compiled from: AnswersEventsHandler.java */
    /* renamed from: c.b.a.b.e$c */
    /* loaded from: classes.dex */
    public class RunnableC0801c implements Runnable {
        public RunnableC0801c() {
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                AnswersEventsHandler.this.f4665g.mo6017a();
            } catch (Exception e) {
                Fabric.m4197h().mo4159c("Answers", "Failed to send events files", e);
            }
        }
    }

    /* compiled from: AnswersEventsHandler.java */
    /* renamed from: c.b.a.b.e$d */
    /* loaded from: classes.dex */
    public class RunnableC0802d implements Runnable {
        public RunnableC0802d() {
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                SessionEventMetadata m6002a = AnswersEventsHandler.this.f4662d.m6002a();
                SessionAnalyticsFilesManager m6048a = AnswersEventsHandler.this.f4661c.m6048a();
                m6048a.m3954a((EventsStorageListener) AnswersEventsHandler.this);
                AnswersEventsHandler.this.f4665g = new EnabledSessionAnalyticsManagerStrategy(AnswersEventsHandler.this.f4659a, AnswersEventsHandler.this.f4660b, AnswersEventsHandler.this.f4664f, m6048a, AnswersEventsHandler.this.f4663e, m6002a);
            } catch (Exception e) {
                Fabric.m4197h().mo4159c("Answers", "Failed to enable events", e);
            }
        }
    }

    /* compiled from: AnswersEventsHandler.java */
    /* renamed from: c.b.a.b.e$e */
    /* loaded from: classes.dex */
    public class RunnableC0803e implements Runnable {
        public RunnableC0803e() {
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                AnswersEventsHandler.this.f4665g.mo3941b();
            } catch (Exception e) {
                Fabric.m4197h().mo4159c("Answers", "Failed to flush events", e);
            }
        }
    }

    /* compiled from: AnswersEventsHandler.java */
    /* renamed from: c.b.a.b.e$f */
    /* loaded from: classes.dex */
    public class RunnableC0804f implements Runnable {

        /* renamed from: a */
        public final /* synthetic */ SessionEvent.C0809b f4673a;

        /* renamed from: b */
        public final /* synthetic */ boolean f4674b;

        public RunnableC0804f(SessionEvent.C0809b c0809b, boolean z) {
            this.f4673a = c0809b;
            this.f4674b = z;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                AnswersEventsHandler.this.f4665g.mo6016a(this.f4673a);
                if (this.f4674b) {
                    AnswersEventsHandler.this.f4665g.mo3941b();
                }
            } catch (Exception e) {
                Fabric.m4197h().mo4159c("Answers", "Failed to process event", e);
            }
        }
    }

    public AnswersEventsHandler(Kit kit, Context context, AnswersFilesManagerProvider answersFilesManagerProvider, SessionMetadataCollector sessionMetadataCollector, HttpRequestFactory httpRequestFactory, ScheduledExecutorService scheduledExecutorService) {
        this.f4659a = kit;
        this.f4660b = context;
        this.f4661c = answersFilesManagerProvider;
        this.f4662d = sessionMetadataCollector;
        this.f4663e = httpRequestFactory;
        this.f4664f = scheduledExecutorService;
    }

    /* renamed from: a */
    public void m6061a(SessionEvent.C0809b c0809b) {
        m6060a(c0809b, false, false);
    }

    /* renamed from: b */
    public void m6055b(SessionEvent.C0809b c0809b) {
        m6060a(c0809b, false, true);
    }

    /* renamed from: c */
    public void m6051c(SessionEvent.C0809b c0809b) {
        m6060a(c0809b, true, false);
    }

    /* renamed from: a */
    public void m6059a(AnalyticsSettingsData analyticsSettingsData, String str) {
        m6058a(new RunnableC0799a(analyticsSettingsData, str));
    }

    /* renamed from: b */
    public void m6057b() {
        m6058a(new RunnableC0802d());
    }

    /* renamed from: c */
    public void m6053c() {
        m6058a(new RunnableC0803e());
    }

    /* renamed from: a */
    public void m6063a() {
        m6058a(new RunnableC0800b());
    }

    /* renamed from: b */
    public final void m6054b(Runnable runnable) {
        try {
            this.f4664f.submit(runnable).get();
        } catch (Exception e) {
            Fabric.m4197h().mo4159c("Answers", "Failed to run events task", e);
        }
    }

    @Override // p136d.p137a.p138a.p139a.p140m.p145d.EventsStorageListener
    /* renamed from: a */
    public void mo3942a(String str) {
        m6058a(new RunnableC0801c());
    }

    /* renamed from: a */
    public void m6060a(SessionEvent.C0809b c0809b, boolean z, boolean z2) {
        RunnableC0804f runnableC0804f = new RunnableC0804f(c0809b, z2);
        if (z) {
            m6054b(runnableC0804f);
        } else {
            m6058a(runnableC0804f);
        }
    }

    /* renamed from: a */
    public final void m6058a(Runnable runnable) {
        try {
            this.f4664f.submit(runnable);
        } catch (Exception e) {
            Fabric.m4197h().mo4159c("Answers", "Failed to submit events task", e);
        }
    }
}
