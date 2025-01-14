package p136d.p137a.p138a.p139a.p140m.p148g;

import android.annotation.SuppressLint;
import android.content.SharedPreferences;
import org.json.JSONObject;
import p136d.p137a.p138a.p139a.Fabric;
import p136d.p137a.p138a.p139a.Kit;
import p136d.p137a.p138a.p139a.Logger;
import p136d.p137a.p138a.p139a.p140m.p142b.CommonUtils;
import p136d.p137a.p138a.p139a.p140m.p142b.CurrentTimeProvider;
import p136d.p137a.p138a.p139a.p140m.p147f.PreferenceStore;
import p136d.p137a.p138a.p139a.p140m.p147f.PreferenceStoreImpl;

/* renamed from: d.a.a.a.m.g.k */
/* loaded from: classes.dex */
public class DefaultSettingsController implements SettingsController {

    /* renamed from: a */
    public final SettingsRequest f6625a;

    /* renamed from: b */
    public final SettingsJsonTransform f6626b;

    /* renamed from: c */
    public final CurrentTimeProvider f6627c;

    /* renamed from: d */
    public final CachedSettingsIo f6628d;

    /* renamed from: e */
    public final SettingsSpiCall f6629e;

    /* renamed from: f */
    public final Kit f6630f;

    /* renamed from: g */
    public final PreferenceStore f6631g;

    public DefaultSettingsController(Kit kit, SettingsRequest settingsRequest, CurrentTimeProvider currentTimeProvider, SettingsJsonTransform settingsJsonTransform, CachedSettingsIo cachedSettingsIo, SettingsSpiCall settingsSpiCall) {
        this.f6630f = kit;
        this.f6625a = settingsRequest;
        this.f6627c = currentTimeProvider;
        this.f6626b = settingsJsonTransform;
        this.f6628d = cachedSettingsIo;
        this.f6629e = settingsSpiCall;
        this.f6631g = new PreferenceStoreImpl(this.f6630f);
    }

    @Override // p136d.p137a.p138a.p139a.p140m.p148g.SettingsController
    /* renamed from: a */
    public SettingsData mo3866a() {
        return mo3865a(SettingsCacheBehavior.USE_CACHE);
    }

    /* renamed from: b */
    public final SettingsData m3891b(SettingsCacheBehavior settingsCacheBehavior) {
        SettingsData settingsData = null;
        try {
            if (!SettingsCacheBehavior.SKIP_CACHE_LOOKUP.equals(settingsCacheBehavior)) {
                JSONObject mo3896a = this.f6628d.mo3896a();
                if (mo3896a != null) {
                    SettingsData mo3863a = this.f6626b.mo3863a(this.f6627c, mo3896a);
                    if (mo3863a != null) {
                        m3893a(mo3896a, "Loaded cached settings: ");
                        long mo4007a = this.f6627c.mo4007a();
                        if (!SettingsCacheBehavior.IGNORE_CACHE_EXPIRATION.equals(settingsCacheBehavior) && mo3863a.m3864a(mo4007a)) {
                            Fabric.m4197h().mo4157e("Fabric", "Cached settings have expired.");
                        }
                        try {
                            Fabric.m4197h().mo4157e("Fabric", "Returning cached settings.");
                            settingsData = mo3863a;
                        } catch (Exception e) {
                            e = e;
                            settingsData = mo3863a;
                            Fabric.m4197h().mo4159c("Fabric", "Failed to get cached settings", e);
                            return settingsData;
                        }
                    } else {
                        Fabric.m4197h().mo4159c("Fabric", "Failed to transform cached settings data.", null);
                    }
                } else {
                    Fabric.m4197h().mo4157e("Fabric", "No cached settings data found.");
                }
            }
        } catch (Exception e2) {
            e = e2;
        }
        return settingsData;
    }

    /* renamed from: c */
    public String m3890c() {
        return CommonUtils.m4091a(CommonUtils.m4070n(this.f6630f.m4178e()));
    }

    /* renamed from: d */
    public String m3889d() {
        return this.f6631g.get().getString("existing_instance_identifier", "");
    }

    @Override // p136d.p137a.p138a.p139a.p140m.p148g.SettingsController
    /* renamed from: a */
    public SettingsData mo3865a(SettingsCacheBehavior settingsCacheBehavior) {
        JSONObject mo3862a;
        SettingsData settingsData = null;
        try {
            if (!Fabric.m4196i() && !m3892b()) {
                settingsData = m3891b(settingsCacheBehavior);
            }
            if (settingsData == null && (mo3862a = this.f6629e.mo3862a(this.f6625a)) != null) {
                settingsData = this.f6626b.mo3863a(this.f6627c, mo3862a);
                this.f6628d.mo3895a(settingsData.f6663g, mo3862a);
                m3893a(mo3862a, "Loaded settings: ");
                m3894a(m3890c());
            }
            return settingsData == null ? m3891b(SettingsCacheBehavior.IGNORE_CACHE_EXPIRATION) : settingsData;
        } catch (Exception e) {
            Fabric.m4197h().mo4159c("Fabric", "Unknown error while loading Crashlytics settings. Crashes will be cached until settings can be retrieved.", e);
            return null;
        }
    }

    /* renamed from: a */
    public final void m3893a(JSONObject jSONObject, String str) {
        Logger m4197h = Fabric.m4197h();
        m4197h.mo4157e("Fabric", str + jSONObject.toString());
    }

    @SuppressLint({"CommitPrefEdits"})
    /* renamed from: a */
    public boolean m3894a(String str) {
        SharedPreferences.Editor edit = this.f6631g.edit();
        edit.putString("existing_instance_identifier", str);
        return this.f6631g.mo3902a(edit);
    }

    /* renamed from: b */
    public boolean m3892b() {
        return !m3889d().equals(m3890c());
    }
}
