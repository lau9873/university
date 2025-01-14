package p070c.p074b.p075a.p076b;

import android.content.Context;
import java.util.UUID;
import p136d.p137a.p138a.p139a.p140m.p142b.CurrentTimeProvider;
import p136d.p137a.p138a.p139a.p140m.p145d.EventsFilesManager;
import p136d.p137a.p138a.p139a.p140m.p145d.EventsStorage;
import p136d.p137a.p138a.p139a.p140m.p148g.AnalyticsSettingsData;

/* renamed from: c.b.a.b.s */
/* loaded from: classes.dex */
public class SessionAnalyticsFilesManager extends EventsFilesManager<SessionEvent> {

    /* renamed from: g */
    public AnalyticsSettingsData f4710g;

    public SessionAnalyticsFilesManager(Context context, SessionEventTransform sessionEventTransform, CurrentTimeProvider currentTimeProvider, EventsStorage eventsStorage) {
        super(context, sessionEventTransform, currentTimeProvider, eventsStorage, 100);
    }

    /* renamed from: a */
    public void m6029a(AnalyticsSettingsData analyticsSettingsData) {
        this.f4710g = analyticsSettingsData;
    }

    @Override // p136d.p137a.p138a.p139a.p140m.p145d.EventsFilesManager
    /* renamed from: c */
    public String mo3948c() {
        UUID randomUUID = UUID.randomUUID();
        return "sa_" + randomUUID.toString() + "_" + this.f6563c.mo4007a() + ".tap";
    }

    @Override // p136d.p137a.p138a.p139a.p140m.p145d.EventsFilesManager
    /* renamed from: e */
    public int mo3946e() {
        AnalyticsSettingsData analyticsSettingsData = this.f4710g;
        return analyticsSettingsData == null ? super.mo3946e() : analyticsSettingsData.f6601c;
    }

    @Override // p136d.p137a.p138a.p139a.p140m.p145d.EventsFilesManager
    /* renamed from: f */
    public int mo3945f() {
        AnalyticsSettingsData analyticsSettingsData = this.f4710g;
        return analyticsSettingsData == null ? super.mo3945f() : analyticsSettingsData.f6602d;
    }
}
