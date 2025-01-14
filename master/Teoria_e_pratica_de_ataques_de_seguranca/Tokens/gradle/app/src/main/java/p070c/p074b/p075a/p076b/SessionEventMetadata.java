package p070c.p074b.p075a.p076b;

/* renamed from: c.b.a.b.x */
/* loaded from: classes.dex */
public final class SessionEventMetadata {

    /* renamed from: a */
    public final String f4742a;

    /* renamed from: b */
    public final String f4743b;

    /* renamed from: c */
    public final String f4744c;

    /* renamed from: d */
    public final String f4745d;

    /* renamed from: e */
    public final String f4746e;

    /* renamed from: f */
    public final Boolean f4747f;

    /* renamed from: g */
    public final String f4748g;

    /* renamed from: h */
    public final String f4749h;

    /* renamed from: i */
    public final String f4750i;

    /* renamed from: j */
    public final String f4751j;

    /* renamed from: k */
    public final String f4752k;

    /* renamed from: l */
    public final String f4753l;

    /* renamed from: m */
    public String f4754m;

    public SessionEventMetadata(String str, String str2, String str3, String str4, String str5, Boolean bool, String str6, String str7, String str8, String str9, String str10, String str11) {
        this.f4742a = str;
        this.f4743b = str2;
        this.f4744c = str3;
        this.f4745d = str4;
        this.f4746e = str5;
        this.f4747f = bool;
        this.f4748g = str6;
        this.f4749h = str7;
        this.f4750i = str8;
        this.f4751j = str9;
        this.f4752k = str10;
        this.f4753l = str11;
    }

    public String toString() {
        if (this.f4754m == null) {
            this.f4754m = "appBundleId=" + this.f4742a + ", executionId=" + this.f4743b + ", installationId=" + this.f4744c + ", androidId=" + this.f4745d + ", advertisingId=" + this.f4746e + ", limitAdTrackingEnabled=" + this.f4747f + ", betaDeviceToken=" + this.f4748g + ", buildId=" + this.f4749h + ", osVersion=" + this.f4750i + ", deviceModel=" + this.f4751j + ", appVersionCode=" + this.f4752k + ", appVersionName=" + this.f4753l;
        }
        return this.f4754m;
    }
}
