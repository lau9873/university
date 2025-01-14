package p136d.p137a.p138a.p139a.p140m.p148g;

import android.content.Context;
import java.util.Locale;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicReference;
import p136d.p137a.p138a.p139a.Fabric;
import p136d.p137a.p138a.p139a.Kit;
import p136d.p137a.p138a.p139a.p140m.p142b.ApiKey;
import p136d.p137a.p138a.p139a.p140m.p142b.CommonUtils;
import p136d.p137a.p138a.p139a.p140m.p142b.DeliveryMechanism;
import p136d.p137a.p138a.p139a.p140m.p142b.IdManager;
import p136d.p137a.p138a.p139a.p140m.p142b.SystemCurrentTimeProvider;
import p136d.p137a.p138a.p139a.p140m.p146e.HttpRequestFactory;

/* renamed from: d.a.a.a.m.g.r */
/* loaded from: classes.dex */
public class Settings {

    /* renamed from: a */
    public final AtomicReference<SettingsData> f6648a;

    /* renamed from: b */
    public final CountDownLatch f6649b;

    /* renamed from: c */
    public SettingsController f6650c;

    /* renamed from: d */
    public boolean f6651d;

    /* compiled from: Settings.java */
    /* renamed from: d.a.a.a.m.g.r$b */
    /* loaded from: classes.dex */
    public static class C1523b {

        /* renamed from: a */
        public static final Settings f6652a = new Settings();
    }

    /* renamed from: d */
    public static Settings m3868d() {
        return C1523b.f6652a;
    }

    /* renamed from: a */
    public synchronized Settings m3872a(Kit kit, IdManager idManager, HttpRequestFactory httpRequestFactory, String str, String str2, String str3) {
        if (this.f6651d) {
            return this;
        }
        if (this.f6650c == null) {
            Context m4178e = kit.m4178e();
            String m4048e = idManager.m4048e();
            String m4115c = new ApiKey().m4115c(m4178e);
            String m4044i = idManager.m4044i();
            this.f6650c = new DefaultSettingsController(kit, new SettingsRequest(m4115c, idManager.m4043j(), idManager.m4042k(), idManager.m4041l(), idManager.m4052b(), idManager.m4047f(), idManager.m4049d(), CommonUtils.m4091a(CommonUtils.m4070n(m4178e)), str2, str, DeliveryMechanism.m4065a(m4044i).m4064b(), CommonUtils.m4083c(m4178e)), new SystemCurrentTimeProvider(), new DefaultSettingsJsonTransform(), new DefaultCachedSettingsIo(kit), new DefaultSettingsSpiCall(kit, str3, String.format(Locale.US, "https://settings.crashlytics.com/spi/v2/platforms/android/apps/%s/settings", m4048e), httpRequestFactory));
        }
        this.f6651d = true;
        return this;
    }

    /* renamed from: b */
    public synchronized boolean m3870b() {
        SettingsData mo3866a;
        mo3866a = this.f6650c.mo3866a();
        m3871a(mo3866a);
        return mo3866a != null;
    }

    /* renamed from: c */
    public synchronized boolean m3869c() {
        SettingsData mo3865a;
        mo3865a = this.f6650c.mo3865a(SettingsCacheBehavior.SKIP_CACHE_LOOKUP);
        m3871a(mo3865a);
        if (mo3865a == null) {
            Fabric.m4197h().mo4159c("Fabric", "Failed to force reload of settings from Crashlytics.", null);
        }
        return mo3865a != null;
    }

    public Settings() {
        this.f6648a = new AtomicReference<>();
        this.f6649b = new CountDownLatch(1);
        this.f6651d = false;
    }

    /* renamed from: a */
    public SettingsData m3873a() {
        try {
            this.f6649b.await();
            return this.f6648a.get();
        } catch (InterruptedException unused) {
            Fabric.m4197h().mo4160c("Fabric", "Interrupted while waiting for settings data.");
            return null;
        }
    }

    /* renamed from: a */
    public final void m3871a(SettingsData settingsData) {
        this.f6648a.set(settingsData);
        this.f6649b.countDown();
    }
}
