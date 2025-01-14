package p136d.p137a.p138a.p139a;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Future;
import p136d.p137a.p138a.p139a.p140m.p142b.ApiKey;
import p136d.p137a.p138a.p139a.p140m.p142b.CommonUtils;
import p136d.p137a.p138a.p139a.p140m.p142b.DeliveryMechanism;
import p136d.p137a.p138a.p139a.p140m.p146e.DefaultHttpRequestFactory;
import p136d.p137a.p138a.p139a.p140m.p146e.HttpRequestFactory;
import p136d.p137a.p138a.p139a.p140m.p148g.AppRequestData;
import p136d.p137a.p138a.p139a.p140m.p148g.AppSettingsData;
import p136d.p137a.p138a.p139a.p140m.p148g.CreateAppSpiCall;
import p136d.p137a.p138a.p139a.p140m.p148g.IconRequest;
import p136d.p137a.p138a.p139a.p140m.p148g.Settings;
import p136d.p137a.p138a.p139a.p140m.p148g.SettingsData;
import p136d.p137a.p138a.p139a.p140m.p148g.UpdateAppSpiCall;

/* renamed from: d.a.a.a.l */
/* loaded from: classes.dex */
public class Onboarding extends Kit<Boolean> {

    /* renamed from: g */
    public final HttpRequestFactory f6404g = new DefaultHttpRequestFactory();

    /* renamed from: h */
    public PackageManager f6405h;

    /* renamed from: i */
    public String f6406i;

    /* renamed from: j */
    public PackageInfo f6407j;

    /* renamed from: k */
    public String f6408k;

    /* renamed from: m */
    public String f6409m;

    /* renamed from: n */
    public String f6410n;

    /* renamed from: o */
    public String f6411o;

    /* renamed from: p */
    public String f6412p;

    /* renamed from: q */
    public final Future<Map<String, KitInfo>> f6413q;

    /* renamed from: r */
    public final Collection<Kit> f6414r;

    public Onboarding(Future<Map<String, KitInfo>> future, Collection<Kit> collection) {
        this.f6413q = future;
        this.f6414r = collection;
    }

    /* renamed from: a */
    public Map<String, KitInfo> m4153a(Map<String, KitInfo> map, Collection<Kit> collection) {
        for (Kit kit : collection) {
            if (!map.containsKey(kit.mo4149i())) {
                map.put(kit.mo4149i(), new KitInfo(kit.mo4149i(), kit.mo4148k(), "binary"));
            }
        }
        return map;
    }

    /* renamed from: b */
    public final boolean m4152b(String str, AppSettingsData appSettingsData, Collection<KitInfo> collection) {
        return new CreateAppSpiCall(this, m4146o(), appSettingsData.f6619b, this.f6404g).m3900a(m4155a(IconRequest.m3874a(m4178e(), str), collection));
    }

    /* renamed from: c */
    public final boolean m4151c(String str, AppSettingsData appSettingsData, Collection<KitInfo> collection) {
        return m4156a(appSettingsData, IconRequest.m3874a(m4178e(), str), collection);
    }

    @Override // p136d.p137a.p138a.p139a.Kit
    /* renamed from: i */
    public String mo4149i() {
        return "io.fabric.sdk.android:fabric";
    }

    @Override // p136d.p137a.p138a.p139a.Kit
    /* renamed from: k */
    public String mo4148k() {
        return "1.3.16.dev";
    }

    @Override // p136d.p137a.p138a.p139a.Kit
    /* renamed from: n */
    public boolean mo4147n() {
        try {
            this.f6410n = m4175h().m4044i();
            this.f6405h = m4178e().getPackageManager();
            this.f6406i = m4178e().getPackageName();
            this.f6407j = this.f6405h.getPackageInfo(this.f6406i, 0);
            this.f6408k = Integer.toString(this.f6407j.versionCode);
            this.f6409m = this.f6407j.versionName == null ? "0.0" : this.f6407j.versionName;
            this.f6411o = this.f6405h.getApplicationLabel(m4178e().getApplicationInfo()).toString();
            this.f6412p = Integer.toString(m4178e().getApplicationInfo().targetSdkVersion);
            return true;
        } catch (PackageManager.NameNotFoundException e) {
            Fabric.m4197h().mo4159c("Fabric", "Failed init", e);
            return false;
        }
    }

    /* renamed from: o */
    public String m4146o() {
        return CommonUtils.m4087b(m4178e(), "com.crashlytics.ApiEndpoint");
    }

    /* renamed from: p */
    public final SettingsData m4145p() {
        try {
            Settings m3868d = Settings.m3868d();
            m3868d.m3872a(this, this.f6399e, this.f6404g, this.f6408k, this.f6409m, m4146o());
            m3868d.m3870b();
            return Settings.m3868d().m3873a();
        } catch (Exception e) {
            Fabric.m4197h().mo4159c("Fabric", "Error dealing with settings", e);
            return null;
        }
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // p136d.p137a.p138a.p139a.Kit
    /* renamed from: d */
    public Boolean mo4150d() {
        Map<String, KitInfo> hashMap;
        boolean m4154a;
        String m4083c = CommonUtils.m4083c(m4178e());
        SettingsData m4145p = m4145p();
        if (m4145p != null) {
            try {
                if (this.f6413q != null) {
                    hashMap = this.f6413q.get();
                } else {
                    hashMap = new HashMap<>();
                }
                m4153a(hashMap, this.f6414r);
                m4154a = m4154a(m4083c, m4145p.f6657a, hashMap.values());
            } catch (Exception e) {
                Fabric.m4197h().mo4159c("Fabric", "Error performing auto configuration.", e);
            }
            return Boolean.valueOf(m4154a);
        }
        m4154a = false;
        return Boolean.valueOf(m4154a);
    }

    /* renamed from: a */
    public final boolean m4154a(String str, AppSettingsData appSettingsData, Collection<KitInfo> collection) {
        if ("new".equals(appSettingsData.f6618a)) {
            if (m4152b(str, appSettingsData, collection)) {
                return Settings.m3868d().m3869c();
            }
            Fabric.m4197h().mo4159c("Fabric", "Failed to create app with Crashlytics service.", null);
            return false;
        } else if ("configured".equals(appSettingsData.f6618a)) {
            return Settings.m3868d().m3869c();
        } else {
            if (appSettingsData.f6621d) {
                Fabric.m4197h().mo4157e("Fabric", "Server says an update is required - forcing a full App update.");
                m4151c(str, appSettingsData, collection);
            }
            return true;
        }
    }

    /* renamed from: a */
    public final boolean m4156a(AppSettingsData appSettingsData, IconRequest iconRequest, Collection<KitInfo> collection) {
        return new UpdateAppSpiCall(this, m4146o(), appSettingsData.f6619b, this.f6404g).m3900a(m4155a(iconRequest, collection));
    }

    /* renamed from: a */
    public final AppRequestData m4155a(IconRequest iconRequest, Collection<KitInfo> collection) {
        Context m4178e = m4178e();
        return new AppRequestData(new ApiKey().m4115c(m4178e), m4175h().m4048e(), this.f6409m, this.f6408k, CommonUtils.m4091a(CommonUtils.m4070n(m4178e)), this.f6411o, DeliveryMechanism.m4065a(this.f6410n).m4064b(), this.f6412p, "0", iconRequest, collection);
    }
}
