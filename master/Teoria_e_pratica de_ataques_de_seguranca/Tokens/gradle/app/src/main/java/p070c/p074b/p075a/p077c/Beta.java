package p070c.p074b.p075a.p077c;

import android.annotation.TargetApi;
import android.app.Application;
import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import p136d.p137a.p138a.p139a.Fabric;
import p136d.p137a.p138a.p139a.Kit;
import p136d.p137a.p138a.p139a.Logger;
import p136d.p137a.p138a.p139a.p140m.p141a.MemoryValueCache;
import p136d.p137a.p138a.p139a.p140m.p142b.CommonUtils;
import p136d.p137a.p138a.p139a.p140m.p142b.DeviceIdentifierProvider;
import p136d.p137a.p138a.p139a.p140m.p142b.IdManager;
import p136d.p137a.p138a.p139a.p140m.p142b.SystemCurrentTimeProvider;
import p136d.p137a.p138a.p139a.p140m.p146e.DefaultHttpRequestFactory;
import p136d.p137a.p138a.p139a.p140m.p147f.PreferenceStoreImpl;
import p136d.p137a.p138a.p139a.p140m.p148g.BetaSettingsData;
import p136d.p137a.p138a.p139a.p140m.p148g.Settings;
import p136d.p137a.p138a.p139a.p140m.p148g.SettingsData;

/* renamed from: c.b.a.c.c */
/* loaded from: classes.dex */
public class Beta extends Kit<Boolean> implements DeviceIdentifierProvider {

    /* renamed from: g */
    public final MemoryValueCache<String> f4774g = new MemoryValueCache<>();

    /* renamed from: h */
    public final DeviceTokenLoader f4775h = new DeviceTokenLoader();

    /* renamed from: i */
    public UpdatesController f4776i;

    @TargetApi(14)
    /* renamed from: a */
    public UpdatesController m5994a(int i, Application application) {
        if (i >= 14) {
            return new ActivityLifecycleCheckForUpdatesController(m4176g().m4218a(), m4176g().m4204c());
        }
        return new ImmediateCheckForUpdatesController();
    }

    @Override // p136d.p137a.p138a.p139a.p140m.p142b.DeviceIdentifierProvider
    /* renamed from: c */
    public Map<IdManager.EnumC1497a, String> mo4063c() {
        String m5992a = m5992a(m4178e(), m4175h().m4044i());
        HashMap hashMap = new HashMap();
        if (!TextUtils.isEmpty(m5992a)) {
            hashMap.put(IdManager.EnumC1497a.FONT_TOKEN, m5992a);
        }
        return hashMap;
    }

    @Override // p136d.p137a.p138a.p139a.Kit
    /* renamed from: i */
    public String mo4149i() {
        return "com.crashlytics.sdk.android:beta";
    }

    @Override // p136d.p137a.p138a.p139a.Kit
    /* renamed from: k */
    public String mo4148k() {
        return "1.2.4.dev";
    }

    @Override // p136d.p137a.p138a.p139a.Kit
    @TargetApi(14)
    /* renamed from: n */
    public boolean mo4147n() {
        this.f4776i = m5994a(Build.VERSION.SDK_INT, (Application) m4178e().getApplicationContext());
        return true;
    }

    /* renamed from: o */
    public final BetaSettingsData m5990o() {
        SettingsData m3873a = Settings.m3868d().m3873a();
        if (m3873a != null) {
            return m3873a.f6662f;
        }
        return null;
    }

    /* renamed from: p */
    public String m5989p() {
        return CommonUtils.m4087b(m4178e(), "com.crashlytics.ApiEndpoint");
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // p136d.p137a.p138a.p139a.Kit
    /* renamed from: d */
    public Boolean mo4150d() {
        Fabric.m4197h().mo4157e("Beta", "Beta kit initializing...");
        Context m4178e = m4178e();
        IdManager m4175h = m4175h();
        if (TextUtils.isEmpty(m5992a(m4178e, m4175h.m4044i()))) {
            Fabric.m4197h().mo4157e("Beta", "A Beta device token was not found for this app");
            return false;
        }
        Fabric.m4197h().mo4157e("Beta", "Beta device token is present, checking for app updates.");
        BetaSettingsData m5990o = m5990o();
        BuildProperties m5993a = m5993a(m4178e);
        if (m5991a(m5990o, m5993a)) {
            this.f4776i.mo5979a(m4178e, this, m4175h, m5990o, m5993a, new PreferenceStoreImpl(this), new SystemCurrentTimeProvider(), new DefaultHttpRequestFactory(Fabric.m4197h()));
        }
        return true;
    }

    /* renamed from: a */
    public boolean m5991a(BetaSettingsData betaSettingsData, BuildProperties buildProperties) {
        return (betaSettingsData == null || TextUtils.isEmpty(betaSettingsData.f6622a) || buildProperties == null) ? false : true;
    }

    /* renamed from: a */
    public final String m5992a(Context context, String str) {
        String str2 = null;
        try {
            String mo4141a = this.f4774g.mo4141a(context, this.f4775h);
            if (!"".equals(mo4141a)) {
                str2 = mo4141a;
            }
        } catch (Exception e) {
            Fabric.m4197h().mo4159c("Beta", "Failed to load the Beta device token", e);
        }
        Logger m4197h = Fabric.m4197h();
        StringBuilder sb = new StringBuilder();
        sb.append("Beta device token present: ");
        sb.append(!TextUtils.isEmpty(str2));
        m4197h.mo4157e("Beta", sb.toString());
        return str2;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v0 */
    /* JADX WARN: Type inference failed for: r2v1 */
    /* JADX WARN: Type inference failed for: r2v5, types: [java.lang.Throwable, java.io.IOException] */
    /* JADX WARN: Type inference failed for: r3v3, types: [d.a.a.a.k] */
    /* renamed from: a */
    public final BuildProperties m5993a(Context context) {
        BuildProperties buildProperties;
        Throwable th;
        InputStream inputStream;
        ?? e = 0;
        r2 = null;
        BuildProperties buildProperties2 = null;
        InputStream inputStream2 = null;
        try {
            try {
                inputStream = context.getAssets().open("crashlytics-build.properties");
                if (inputStream != null) {
                    try {
                        buildProperties2 = BuildProperties.m5988a(inputStream);
                        Fabric.m4197h().mo4157e("Beta", buildProperties2.f4780d + " build properties: " + buildProperties2.f4778b + " (" + buildProperties2.f4777a + ") - " + buildProperties2.f4779c);
                    } catch (Exception e2) {
                        e = e2;
                        BuildProperties buildProperties3 = buildProperties2;
                        inputStream2 = inputStream;
                        buildProperties = buildProperties3;
                        Fabric.m4197h().mo4159c("Beta", "Error reading Beta build properties", e);
                        if (inputStream2 != null) {
                            try {
                                inputStream2.close();
                                return buildProperties;
                            } catch (IOException e3) {
                                e = e3;
                                Fabric.m4197h().mo4159c("Beta", "Error closing Beta build properties asset", e);
                                return buildProperties;
                            }
                        }
                        return buildProperties;
                    } catch (Throwable th2) {
                        th = th2;
                        if (inputStream != null) {
                            try {
                                inputStream.close();
                            } catch (IOException e4) {
                                Fabric.m4197h().mo4159c("Beta", "Error closing Beta build properties asset", e4);
                            }
                        }
                        throw th;
                    }
                }
                if (inputStream != null) {
                    try {
                        inputStream.close();
                    } catch (IOException e5) {
                        Fabric.m4197h().mo4159c("Beta", "Error closing Beta build properties asset", e5);
                    }
                }
                return buildProperties2;
            } catch (Exception e6) {
                e = e6;
                buildProperties = null;
            }
        } catch (Throwable th3) {
            InputStream inputStream3 = e;
            th = th3;
            inputStream = inputStream3;
        }
    }
}
