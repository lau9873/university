package p136d.p137a.p138a.p139a.p140m.p142b;

import android.annotation.SuppressLint;
import android.content.Context;
import android.text.TextUtils;
import p136d.p137a.p138a.p139a.Fabric;
import p136d.p137a.p138a.p139a.p140m.p147f.PreferenceStore;
import p136d.p137a.p138a.p139a.p140m.p147f.PreferenceStoreImpl;

/* renamed from: d.a.a.a.m.b.c */
/* loaded from: classes.dex */
public class AdvertisingInfoProvider {

    /* renamed from: a */
    public final Context f6425a;

    /* renamed from: b */
    public final PreferenceStore f6426b;

    /* compiled from: AdvertisingInfoProvider.java */
    /* renamed from: d.a.a.a.m.b.c$a */
    /* loaded from: classes.dex */
    public class C1486a extends BackgroundPriorityRunnable {

        /* renamed from: a */
        public final /* synthetic */ AdvertisingInfo f6427a;

        public C1486a(AdvertisingInfo advertisingInfo) {
            this.f6427a = advertisingInfo;
        }

        @Override // p136d.p137a.p138a.p139a.p140m.p142b.BackgroundPriorityRunnable
        /* renamed from: a */
        public void mo4057a() {
            AdvertisingInfo m4132b = AdvertisingInfoProvider.this.m4132b();
            if (this.f6427a.equals(m4132b)) {
                return;
            }
            Fabric.m4197h().mo4157e("Fabric", "Asychronously getting Advertising Info and storing it to preferences");
            AdvertisingInfoProvider.this.m4129c(m4132b);
        }
    }

    public AdvertisingInfoProvider(Context context) {
        this.f6425a = context.getApplicationContext();
        this.f6426b = new PreferenceStoreImpl(context, "TwitterAdvertisingInfoPreferences");
    }

    /* renamed from: b */
    public final void m4131b(AdvertisingInfo advertisingInfo) {
        new Thread(new C1486a(advertisingInfo)).start();
    }

    @SuppressLint({"CommitPrefEdits"})
    /* renamed from: c */
    public final void m4129c(AdvertisingInfo advertisingInfo) {
        if (m4135a(advertisingInfo)) {
            PreferenceStore preferenceStore = this.f6426b;
            preferenceStore.mo3902a(preferenceStore.edit().putString("advertising_id", advertisingInfo.f6423a).putBoolean("limit_ad_tracking_enabled", advertisingInfo.f6424b));
            return;
        }
        PreferenceStore preferenceStore2 = this.f6426b;
        preferenceStore2.mo3902a(preferenceStore2.edit().remove("advertising_id").remove("limit_ad_tracking_enabled"));
    }

    /* renamed from: d */
    public AdvertisingInfoStrategy m4128d() {
        return new AdvertisingInfoReflectionStrategy(this.f6425a);
    }

    /* renamed from: e */
    public AdvertisingInfoStrategy m4127e() {
        return new AdvertisingInfoServiceStrategy(this.f6425a);
    }

    /* renamed from: a */
    public AdvertisingInfo m4136a() {
        AdvertisingInfo m4130c = m4130c();
        if (m4135a(m4130c)) {
            Fabric.m4197h().mo4157e("Fabric", "Using AdvertisingInfo from Preference Store");
            m4131b(m4130c);
            return m4130c;
        }
        AdvertisingInfo m4132b = m4132b();
        m4129c(m4132b);
        return m4132b;
    }

    /* renamed from: b */
    public final AdvertisingInfo m4132b() {
        AdvertisingInfo mo4119a = m4128d().mo4119a();
        if (!m4135a(mo4119a)) {
            mo4119a = m4127e().mo4119a();
            if (!m4135a(mo4119a)) {
                Fabric.m4197h().mo4157e("Fabric", "AdvertisingInfo not present");
            } else {
                Fabric.m4197h().mo4157e("Fabric", "Using AdvertisingInfo from Service Provider");
            }
        } else {
            Fabric.m4197h().mo4157e("Fabric", "Using AdvertisingInfo from Reflection Provider");
        }
        return mo4119a;
    }

    /* renamed from: a */
    public final boolean m4135a(AdvertisingInfo advertisingInfo) {
        return (advertisingInfo == null || TextUtils.isEmpty(advertisingInfo.f6423a)) ? false : true;
    }

    /* renamed from: c */
    public AdvertisingInfo m4130c() {
        return new AdvertisingInfo(this.f6426b.get().getString("advertising_id", ""), this.f6426b.get().getBoolean("limit_ad_tracking_enabled", false));
    }
}
