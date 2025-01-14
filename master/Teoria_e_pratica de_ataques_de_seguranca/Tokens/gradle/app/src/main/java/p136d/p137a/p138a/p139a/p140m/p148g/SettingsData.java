package p136d.p137a.p138a.p139a.p140m.p148g;

/* renamed from: d.a.a.a.m.g.u */
/* loaded from: classes.dex */
public class SettingsData {

    /* renamed from: a */
    public final AppSettingsData f6657a;

    /* renamed from: b */
    public final SessionSettingsData f6658b;

    /* renamed from: c */
    public final PromptSettingsData f6659c;

    /* renamed from: d */
    public final FeaturesSettingsData f6660d;

    /* renamed from: e */
    public final AnalyticsSettingsData f6661e;

    /* renamed from: f */
    public final BetaSettingsData f6662f;

    /* renamed from: g */
    public final long f6663g;

    public SettingsData(long j, AppSettingsData appSettingsData, SessionSettingsData sessionSettingsData, PromptSettingsData promptSettingsData, FeaturesSettingsData featuresSettingsData, AnalyticsSettingsData analyticsSettingsData, BetaSettingsData betaSettingsData, int i, int i2) {
        this.f6663g = j;
        this.f6657a = appSettingsData;
        this.f6658b = sessionSettingsData;
        this.f6659c = promptSettingsData;
        this.f6660d = featuresSettingsData;
        this.f6661e = analyticsSettingsData;
        this.f6662f = betaSettingsData;
    }

    /* renamed from: a */
    public boolean m3864a(long j) {
        return this.f6663g < j;
    }
}
