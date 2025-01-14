package p070c.p074b.p075a.p076b;

import android.content.Context;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;
import p070c.p074b.p075a.p076b.SessionEvent;
import p136d.p137a.p138a.p139a.Fabric;
import p136d.p137a.p138a.p139a.Kit;
import p136d.p137a.p138a.p139a.Logger;
import p136d.p137a.p138a.p139a.p140m.p142b.ApiKey;
import p136d.p137a.p138a.p139a.p140m.p142b.CommonUtils;
import p136d.p137a.p138a.p139a.p140m.p145d.FilesSender;
import p136d.p137a.p138a.p139a.p140m.p145d.TimeBasedFileRollOverRunnable;
import p136d.p137a.p138a.p139a.p140m.p146e.HttpRequestFactory;
import p136d.p137a.p138a.p139a.p140m.p148g.AnalyticsSettingsData;

/* renamed from: c.b.a.b.m */
/* loaded from: classes.dex */
public class EnabledSessionAnalyticsManagerStrategy implements SessionAnalyticsManagerStrategy {

    /* renamed from: a */
    public final Kit f4690a;

    /* renamed from: b */
    public final HttpRequestFactory f4691b;

    /* renamed from: c */
    public final Context f4692c;

    /* renamed from: d */
    public final SessionAnalyticsFilesManager f4693d;

    /* renamed from: e */
    public final ScheduledExecutorService f4694e;

    /* renamed from: g */
    public final SessionEventMetadata f4696g;

    /* renamed from: h */
    public FilesSender f4697h;

    /* renamed from: f */
    public final AtomicReference<ScheduledFuture<?>> f4695f = new AtomicReference<>();

    /* renamed from: i */
    public ApiKey f4698i = new ApiKey();

    /* renamed from: j */
    public EventFilter f4699j = new KeepAllEventFilter();

    /* renamed from: k */
    public boolean f4700k = true;

    /* renamed from: l */
    public boolean f4701l = true;

    /* renamed from: m */
    public volatile int f4702m = -1;

    public EnabledSessionAnalyticsManagerStrategy(Kit kit, Context context, ScheduledExecutorService scheduledExecutorService, SessionAnalyticsFilesManager sessionAnalyticsFilesManager, HttpRequestFactory httpRequestFactory, SessionEventMetadata sessionEventMetadata) {
        this.f4690a = kit;
        this.f4692c = context;
        this.f4694e = scheduledExecutorService;
        this.f4693d = sessionAnalyticsFilesManager;
        this.f4691b = httpRequestFactory;
        this.f4696g = sessionEventMetadata;
    }

    @Override // p070c.p074b.p075a.p076b.SessionAnalyticsManagerStrategy
    /* renamed from: a */
    public void mo6015a(AnalyticsSettingsData analyticsSettingsData, String str) {
        this.f4697h = AnswersRetryFilesSender.m6044a(new SessionAnalyticsFilesSender(this.f4690a, str, analyticsSettingsData.f6599a, this.f4691b, this.f4698i.m4115c(this.f4692c)));
        this.f4693d.m6029a(analyticsSettingsData);
        this.f4700k = analyticsSettingsData.f6603e;
        Logger m4197h = Fabric.m4197h();
        StringBuilder sb = new StringBuilder();
        sb.append("Custom event tracking ");
        sb.append(this.f4700k ? "enabled" : "disabled");
        m4197h.mo4157e("Answers", sb.toString());
        this.f4701l = analyticsSettingsData.f6604f;
        Logger m4197h2 = Fabric.m4197h();
        StringBuilder sb2 = new StringBuilder();
        sb2.append("Predefined event tracking ");
        sb2.append(this.f4701l ? "enabled" : "disabled");
        m4197h2.mo4157e("Answers", sb2.toString());
        if (analyticsSettingsData.f6606h > 1) {
            Fabric.m4197h().mo4157e("Answers", "Event sampling enabled");
            this.f4699j = new SamplingEventFilter(analyticsSettingsData.f6606h);
        }
        this.f4702m = analyticsSettingsData.f6600b;
        m6036a(0L, this.f4702m);
    }

    @Override // p136d.p137a.p138a.p139a.p140m.p145d.FileRollOverManager
    /* renamed from: b */
    public boolean mo3941b() {
        try {
            return this.f4693d.m3944g();
        } catch (IOException e) {
            CommonUtils.m4107a(this.f4692c, "Failed to roll file over.", e);
            return false;
        }
    }

    @Override // p136d.p137a.p138a.p139a.p140m.p145d.FileRollOverManager
    /* renamed from: c */
    public void mo3940c() {
        if (this.f4695f.get() != null) {
            CommonUtils.m4082c(this.f4692c, "Cancelling time-based rollover because no events are currently being generated.");
            this.f4695f.get().cancel(false);
            this.f4695f.set(null);
        }
    }

    @Override // p070c.p074b.p075a.p076b.SessionAnalyticsManagerStrategy
    /* renamed from: d */
    public void mo6014d() {
        this.f4693d.m3956a();
    }

    /* renamed from: e */
    public void m6035e() {
        if (this.f4702m != -1) {
            m6036a(this.f4702m, this.f4702m);
        }
    }

    @Override // p070c.p074b.p075a.p076b.SessionAnalyticsManagerStrategy
    /* renamed from: a */
    public void mo6016a(SessionEvent.C0809b c0809b) {
        SessionEvent m6008a = c0809b.m6008a(this.f4696g);
        if (!this.f4700k && SessionEvent.EnumC0810c.CUSTOM.equals(m6008a.f4719c)) {
            Logger m4197h = Fabric.m4197h();
            m4197h.mo4157e("Answers", "Custom events tracking disabled - skipping event: " + m6008a);
        } else if (!this.f4701l && SessionEvent.EnumC0810c.PREDEFINED.equals(m6008a.f4719c)) {
            Logger m4197h2 = Fabric.m4197h();
            m4197h2.mo4157e("Answers", "Predefined events tracking disabled - skipping event: " + m6008a);
        } else if (this.f4699j.mo6030a(m6008a)) {
            Logger m4197h3 = Fabric.m4197h();
            m4197h3.mo4157e("Answers", "Skipping filtered event: " + m6008a);
        } else {
            try {
                this.f4693d.m3953a((SessionAnalyticsFilesManager) m6008a);
            } catch (IOException e) {
                Logger m4197h4 = Fabric.m4197h();
                m4197h4.mo4159c("Answers", "Failed to write event: " + m6008a, e);
            }
            m6035e();
        }
    }

    @Override // p070c.p074b.p075a.p076b.SessionAnalyticsManagerStrategy
    /* renamed from: a */
    public void mo6017a() {
        if (this.f4697h == null) {
            CommonUtils.m4082c(this.f4692c, "skipping files send because we don't yet know the target endpoint");
            return;
        }
        CommonUtils.m4082c(this.f4692c, "Sending all files");
        List<File> m3947d = this.f4693d.m3947d();
        int i = 0;
        while (m3947d.size() > 0) {
            try {
                CommonUtils.m4082c(this.f4692c, String.format(Locale.US, "attempt to send batch of %d files", Integer.valueOf(m3947d.size())));
                boolean mo3939a = this.f4697h.mo3939a(m3947d);
                if (mo3939a) {
                    i += m3947d.size();
                    this.f4693d.m3951a(m3947d);
                }
                if (!mo3939a) {
                    break;
                }
                m3947d = this.f4693d.m3947d();
            } catch (Exception e) {
                Context context = this.f4692c;
                CommonUtils.m4107a(context, "Failed to send batch of analytics files to server: " + e.getMessage(), e);
            }
        }
        if (i == 0) {
            this.f4693d.m3950b();
        }
    }

    /* renamed from: a */
    public void m6036a(long j, long j2) {
        if (this.f4695f.get() == null) {
            TimeBasedFileRollOverRunnable timeBasedFileRollOverRunnable = new TimeBasedFileRollOverRunnable(this.f4692c, this);
            Context context = this.f4692c;
            CommonUtils.m4082c(context, "Scheduling time based file roll over every " + j2 + " seconds");
            try {
                this.f4695f.set(this.f4694e.scheduleAtFixedRate(timeBasedFileRollOverRunnable, j, j2, TimeUnit.SECONDS));
            } catch (RejectedExecutionException e) {
                CommonUtils.m4107a(this.f4692c, "Failed to schedule time based file roll over", e);
            }
        }
    }
}
