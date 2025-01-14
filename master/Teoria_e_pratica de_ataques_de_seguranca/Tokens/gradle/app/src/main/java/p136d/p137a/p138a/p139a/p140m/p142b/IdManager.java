package p136d.p137a.p138a.p139a.p140m.p142b;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import android.provider.Settings;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.locks.ReentrantLock;
import java.util.regex.Pattern;
import p136d.p137a.p138a.p139a.Fabric;
import p136d.p137a.p138a.p139a.Kit;
import p136d.p137a.p138a.p139a.Logger;

/* renamed from: d.a.a.a.m.b.o */
/* loaded from: classes.dex */
public class IdManager {

    /* renamed from: l */
    public static final Pattern f6465l = Pattern.compile("[^\\p{Alnum}]");

    /* renamed from: m */
    public static final String f6466m = Pattern.quote("/");

    /* renamed from: a */
    public final ReentrantLock f6467a = new ReentrantLock();

    /* renamed from: b */
    public final InstallerPackageNameProvider f6468b;

    /* renamed from: c */
    public final boolean f6469c;

    /* renamed from: d */
    public final boolean f6470d;

    /* renamed from: e */
    public final Context f6471e;

    /* renamed from: f */
    public final String f6472f;

    /* renamed from: g */
    public final String f6473g;

    /* renamed from: h */
    public final Collection<Kit> f6474h;

    /* renamed from: i */
    public AdvertisingInfoProvider f6475i;

    /* renamed from: j */
    public AdvertisingInfo f6476j;

    /* renamed from: k */
    public boolean f6477k;

    /* compiled from: IdManager.java */
    /* renamed from: d.a.a.a.m.b.o$a */
    /* loaded from: classes.dex */
    public enum EnumC1497a {
        WIFI_MAC_ADDRESS(1),
        BLUETOOTH_MAC_ADDRESS(2),
        FONT_TOKEN(53),
        ANDROID_ID(100),
        ANDROID_DEVICE_ID(101),
        ANDROID_SERIAL(102),
        ANDROID_ADVERTISING_ID(103);
        

        /* renamed from: a */
        public final int f6486a;

        EnumC1497a(int i) {
            this.f6486a = i;
        }
    }

    public IdManager(Context context, String str, String str2, Collection<Kit> collection) {
        if (context == null) {
            throw new IllegalArgumentException("appContext must not be null");
        }
        if (str == null) {
            throw new IllegalArgumentException("appIdentifier must not be null");
        }
        if (collection != null) {
            this.f6471e = context;
            this.f6472f = str;
            this.f6473g = str2;
            this.f6474h = collection;
            this.f6468b = new InstallerPackageNameProvider();
            this.f6475i = new AdvertisingInfoProvider(context);
            this.f6469c = CommonUtils.m4106a(context, "com.crashlytics.CollectDeviceIdentifiers", true);
            if (!this.f6469c) {
                Logger m4197h = Fabric.m4197h();
                m4197h.mo4157e("Fabric", "Device ID collection disabled for " + context.getPackageName());
            }
            this.f6470d = CommonUtils.m4106a(context, "com.crashlytics.CollectUserIdentifiers", true);
            if (this.f6470d) {
                return;
            }
            Logger m4197h2 = Fabric.m4197h();
            m4197h2.mo4157e("Fabric", "User information collection disabled for " + context.getPackageName());
            return;
        }
        throw new IllegalArgumentException("kits must not be null");
    }

    /* renamed from: a */
    public boolean m4056a() {
        return this.f6470d;
    }

    /* renamed from: b */
    public final String m4051b(String str) {
        return str.replaceAll(f6466m, "");
    }

    /* renamed from: c */
    public synchronized AdvertisingInfo m4050c() {
        if (!this.f6477k) {
            this.f6476j = this.f6475i.m4136a();
            this.f6477k = true;
        }
        return this.f6476j;
    }

    /* renamed from: d */
    public String m4049d() {
        if (this.f6469c) {
            String string = Settings.Secure.getString(this.f6471e.getContentResolver(), "android_id");
            if (!"9774d56d682e549c".equals(string)) {
                return m4054a(string);
            }
        }
        return null;
    }

    /* renamed from: e */
    public String m4048e() {
        return this.f6472f;
    }

    /* renamed from: f */
    public String m4047f() {
        String str = this.f6473g;
        if (str == null) {
            SharedPreferences m4075i = CommonUtils.m4075i(this.f6471e);
            String string = m4075i.getString("crashlytics.installation.id", null);
            return string == null ? m4055a(m4075i) : string;
        }
        return str;
    }

    /* renamed from: g */
    public Map<EnumC1497a, String> m4046g() {
        HashMap hashMap = new HashMap();
        for (Kit kit : this.f6474h) {
            if (kit instanceof DeviceIdentifierProvider) {
                for (Map.Entry<EnumC1497a, String> entry : ((DeviceIdentifierProvider) kit).mo4063c().entrySet()) {
                    m4053a(hashMap, entry.getKey(), entry.getValue());
                }
            }
        }
        m4053a(hashMap, EnumC1497a.ANDROID_ID, m4049d());
        m4053a(hashMap, EnumC1497a.ANDROID_ADVERTISING_ID, m4052b());
        return Collections.unmodifiableMap(hashMap);
    }

    /* renamed from: h */
    public String m4045h() {
        if (this.f6469c) {
            String m4049d = m4049d();
            if (m4049d == null) {
                SharedPreferences m4075i = CommonUtils.m4075i(this.f6471e);
                String string = m4075i.getString("crashlytics.installation.id", null);
                return string == null ? m4055a(m4075i) : string;
            }
            return m4049d;
        }
        return "";
    }

    /* renamed from: i */
    public String m4044i() {
        return this.f6468b.m4038a(this.f6471e);
    }

    /* renamed from: j */
    public String m4043j() {
        return String.format(Locale.US, "%s/%s", m4051b(Build.MANUFACTURER), m4051b(Build.MODEL));
    }

    /* renamed from: k */
    public String m4042k() {
        return m4051b(Build.VERSION.INCREMENTAL);
    }

    /* renamed from: l */
    public String m4041l() {
        return m4051b(Build.VERSION.RELEASE);
    }

    /* renamed from: m */
    public String m4040m() {
        return m4041l() + "/" + m4042k();
    }

    /* renamed from: n */
    public Boolean m4039n() {
        AdvertisingInfo m4050c;
        if (!this.f6469c || (m4050c = m4050c()) == null) {
            return null;
        }
        return Boolean.valueOf(m4050c.f6424b);
    }

    /* renamed from: a */
    public final String m4054a(String str) {
        if (str == null) {
            return null;
        }
        return f6465l.matcher(str).replaceAll("").toLowerCase(Locale.US);
    }

    /* renamed from: b */
    public String m4052b() {
        AdvertisingInfo m4050c;
        if (!this.f6469c || (m4050c = m4050c()) == null) {
            return null;
        }
        return m4050c.f6423a;
    }

    /* renamed from: a */
    public final String m4055a(SharedPreferences sharedPreferences) {
        this.f6467a.lock();
        try {
            String string = sharedPreferences.getString("crashlytics.installation.id", null);
            if (string == null) {
                string = m4054a(UUID.randomUUID().toString());
                sharedPreferences.edit().putString("crashlytics.installation.id", string).commit();
            }
            return string;
        } finally {
            this.f6467a.unlock();
        }
    }

    /* renamed from: a */
    public final void m4053a(Map<EnumC1497a, String> map, EnumC1497a enumC1497a, String str) {
        if (str != null) {
            map.put(enumC1497a, str);
        }
    }
}
