package p070c.p074b.p075a.p076b;

import io.fabric.sdk.android.services.network.HttpRequest;
import java.io.File;
import java.util.List;
import p136d.p137a.p138a.p139a.Fabric;
import p136d.p137a.p138a.p139a.Kit;
import p136d.p137a.p138a.p139a.Logger;
import p136d.p137a.p138a.p139a.p140m.p142b.AbstractSpiCall;
import p136d.p137a.p138a.p139a.p140m.p142b.ResponseParser;
import p136d.p137a.p138a.p139a.p140m.p145d.FilesSender;
import p136d.p137a.p138a.p139a.p140m.p146e.HttpMethod;
import p136d.p137a.p138a.p139a.p140m.p146e.HttpRequestFactory;

/* renamed from: c.b.a.b.t */
/* loaded from: classes.dex */
public class SessionAnalyticsFilesSender extends AbstractSpiCall implements FilesSender {

    /* renamed from: g */
    public final String f4711g;

    public SessionAnalyticsFilesSender(Kit kit, String str, String str2, HttpRequestFactory httpRequestFactory, String str3) {
        super(kit, str, str2, httpRequestFactory, HttpMethod.POST);
        this.f4711g = str3;
    }

    @Override // p136d.p137a.p138a.p139a.p140m.p145d.FilesSender
    /* renamed from: a */
    public boolean mo3939a(List<File> list) {
        HttpRequest m4140a = m4140a();
        m4140a.m530c("X-CRASHLYTICS-API-CLIENT-TYPE", "android");
        m4140a.m530c("X-CRASHLYTICS-API-CLIENT-VERSION", this.f6422e.mo4148k());
        m4140a.m530c("X-CRASHLYTICS-API-KEY", this.f4711g);
        int i = 0;
        for (File file : list) {
            m4140a.m546a("session_analytics_file_" + i, file.getName(), "application/vnd.crashlytics.android.events", file);
            i++;
        }
        Logger m4197h = Fabric.m4197h();
        m4197h.mo4157e("Answers", "Sending " + list.size() + " analytics files to " + m4137b());
        int m517g = m4140a.m517g();
        Logger m4197h2 = Fabric.m4197h();
        m4197h2.mo4157e("Answers", "Response code for analytics file send is " + m517g);
        return ResponseParser.m4008a(m517g) == 0;
    }
}
