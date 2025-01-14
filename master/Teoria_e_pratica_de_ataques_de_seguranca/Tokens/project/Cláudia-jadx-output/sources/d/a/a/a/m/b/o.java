package d.a.a.a.m.b;

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
/* compiled from: IdManager.java */
/* loaded from: classes.dex */
public class o {
    public static final Pattern l = Pattern.compile("[^\\p{Alnum}]");
    public static final String m = Pattern.quote("/");

    /* renamed from: a  reason: collision with root package name */
    public final ReentrantLock f4270a = new ReentrantLock();

    /* renamed from: b  reason: collision with root package name */
    public final p f4271b;

    /* renamed from: c  reason: collision with root package name */
    public final boolean f4272c;

    /* renamed from: d  reason: collision with root package name */
    public final boolean f4273d;

    /* renamed from: e  reason: collision with root package name */
    public final Context f4274e;

    /* renamed from: f  reason: collision with root package name */
    public final String f4275f;

    /* renamed from: g  reason: collision with root package name */
    public final String f4276g;

    /* renamed from: h  reason: collision with root package name */
    public final Collection<d.a.a.a.h> f4277h;

    /* renamed from: i  reason: collision with root package name */
    public c f4278i;
    public b j;
    public boolean k;

    /* compiled from: IdManager.java */
    /* loaded from: classes.dex */
    public enum a {
        WIFI_MAC_ADDRESS(1),
        BLUETOOTH_MAC_ADDRESS(2),
        FONT_TOKEN(53),
        ANDROID_ID(100),
        ANDROID_DEVICE_ID(101),
        ANDROID_SERIAL(102),
        ANDROID_ADVERTISING_ID(103);
        

        /* renamed from: a  reason: collision with root package name */
        public final int f4287a;

        a(int i2) {
            this.f4287a = i2;
        }
    }

    public o(Context context, String str, String str2, Collection<d.a.a.a.h> collection) {
        if (context == null) {
            throw new IllegalArgumentException("appContext must not be null");
        }
        if (str == null) {
            throw new IllegalArgumentException("appIdentifier must not be null");
        }
        if (collection != null) {
            this.f4274e = context;
            this.f4275f = str;
            this.f4276g = str2;
            this.f4277h = collection;
            this.f4271b = new p();
            this.f4278i = new c(context);
            this.f4272c = i.a(context, "com.crashlytics.CollectDeviceIdentifiers", true);
            if (!this.f4272c) {
                d.a.a.a.k h2 = d.a.a.a.c.h();
                h2.e("Fabric", "Device ID collection disabled for " + context.getPackageName());
            }
            this.f4273d = i.a(context, "com.crashlytics.CollectUserIdentifiers", true);
            if (this.f4273d) {
                return;
            }
            d.a.a.a.k h3 = d.a.a.a.c.h();
            h3.e("Fabric", "User information collection disabled for " + context.getPackageName());
            return;
        }
        throw new IllegalArgumentException("kits must not be null");
    }

    public boolean a() {
        return this.f4273d;
    }

    public final String b(String str) {
        return str.replaceAll(m, "");
    }

    public synchronized b c() {
        if (!this.k) {
            this.j = this.f4278i.a();
            this.k = true;
        }
        return this.j;
    }

    public String d() {
        if (this.f4272c) {
            String string = Settings.Secure.getString(this.f4274e.getContentResolver(), "android_id");
            if (!"9774d56d682e549c".equals(string)) {
                return a(string);
            }
        }
        return null;
    }

    public String e() {
        return this.f4275f;
    }

    public String f() {
        String str = this.f4276g;
        if (str == null) {
            SharedPreferences i2 = i.i(this.f4274e);
            String string = i2.getString("crashlytics.installation.id", null);
            return string == null ? a(i2) : string;
        }
        return str;
    }

    public Map<a, String> g() {
        HashMap hashMap = new HashMap();
        for (d.a.a.a.h hVar : this.f4277h) {
            if (hVar instanceof m) {
                for (Map.Entry<a, String> entry : ((m) hVar).c().entrySet()) {
                    a(hashMap, entry.getKey(), entry.getValue());
                }
            }
        }
        a(hashMap, a.ANDROID_ID, d());
        a(hashMap, a.ANDROID_ADVERTISING_ID, b());
        return Collections.unmodifiableMap(hashMap);
    }

    public String h() {
        if (this.f4272c) {
            String d2 = d();
            if (d2 == null) {
                SharedPreferences i2 = i.i(this.f4274e);
                String string = i2.getString("crashlytics.installation.id", null);
                return string == null ? a(i2) : string;
            }
            return d2;
        }
        return "";
    }

    public String i() {
        return this.f4271b.a(this.f4274e);
    }

    public String j() {
        return String.format(Locale.US, "%s/%s", b(Build.MANUFACTURER), b(Build.MODEL));
    }

    public String k() {
        return b(Build.VERSION.INCREMENTAL);
    }

    public String l() {
        return b(Build.VERSION.RELEASE);
    }

    public String m() {
        return l() + "/" + k();
    }

    public Boolean n() {
        b c2;
        if (!this.f4272c || (c2 = c()) == null) {
            return null;
        }
        return Boolean.valueOf(c2.f4232b);
    }

    public final String a(String str) {
        if (str == null) {
            return null;
        }
        return l.matcher(str).replaceAll("").toLowerCase(Locale.US);
    }

    public String b() {
        b c2;
        if (!this.f4272c || (c2 = c()) == null) {
            return null;
        }
        return c2.f4231a;
    }

    public final String a(SharedPreferences sharedPreferences) {
        this.f4270a.lock();
        try {
            String string = sharedPreferences.getString("crashlytics.installation.id", null);
            if (string == null) {
                string = a(UUID.randomUUID().toString());
                sharedPreferences.edit().putString("crashlytics.installation.id", string).commit();
            }
            return string;
        } finally {
            this.f4270a.unlock();
        }
    }

    public final void a(Map<a, String> map, a aVar, String str) {
        if (str != null) {
            map.put(aVar, str);
        }
    }
}
