package p000a.p006b.p049h.p057f;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.p067v7.preference.Preference;
import android.support.p067v7.preference.PreferenceScreen;
import p000a.p006b.p030g.p032b.ContextCompat;

/* renamed from: a.b.h.f.j */
/* loaded from: classes.dex */
public class PreferenceManager {

    /* renamed from: a */
    public Context f2177a;

    /* renamed from: c */
    public SharedPreferences f2179c;

    /* renamed from: d */
    public PreferenceDataStore f2180d;

    /* renamed from: e */
    public SharedPreferences.Editor f2181e;

    /* renamed from: f */
    public boolean f2182f;

    /* renamed from: g */
    public String f2183g;

    /* renamed from: h */
    public int f2184h;

    /* renamed from: j */
    public PreferenceScreen f2186j;

    /* renamed from: k */
    public AbstractC0397d f2187k;

    /* renamed from: l */
    public InterfaceC0396c f2188l;

    /* renamed from: m */
    public InterfaceC0394a f2189m;

    /* renamed from: n */
    public InterfaceC0395b f2190n;

    /* renamed from: b */
    public long f2178b = 0;

    /* renamed from: i */
    public int f2185i = 0;

    /* compiled from: PreferenceManager.java */
    /* renamed from: a.b.h.f.j$a */
    /* loaded from: classes.dex */
    public interface InterfaceC0394a {
        /* renamed from: b */
        void mo8816b(Preference preference);
    }

    /* compiled from: PreferenceManager.java */
    /* renamed from: a.b.h.f.j$b */
    /* loaded from: classes.dex */
    public interface InterfaceC0395b {
        /* renamed from: a */
        void mo8815a(PreferenceScreen preferenceScreen);
    }

    /* compiled from: PreferenceManager.java */
    /* renamed from: a.b.h.f.j$c */
    /* loaded from: classes.dex */
    public interface InterfaceC0396c {
        /* renamed from: a */
        boolean mo8814a(Preference preference);
    }

    /* compiled from: PreferenceManager.java */
    /* renamed from: a.b.h.f.j$d */
    /* loaded from: classes.dex */
    public static abstract class AbstractC0397d {
        /* renamed from: a */
        public abstract boolean m8813a(Preference preference, Preference preference2);

        /* renamed from: b */
        public abstract boolean m8812b(Preference preference, Preference preference2);
    }

    public PreferenceManager(Context context) {
        this.f2177a = context;
        m8826a(m8831a(context));
    }

    /* renamed from: a */
    public PreferenceScreen m8830a(Context context, int i, PreferenceScreen preferenceScreen) {
        m8825a(true);
        PreferenceScreen preferenceScreen2 = (PreferenceScreen) new PreferenceInflater(context, this).m8845a(i, preferenceScreen);
        preferenceScreen2.m7252a(this);
        m8825a(false);
        return preferenceScreen2;
    }

    /* renamed from: b */
    public long m8824b() {
        long j;
        synchronized (this) {
            j = this.f2178b;
            this.f2178b = 1 + j;
        }
        return j;
    }

    /* renamed from: c */
    public InterfaceC0395b m8823c() {
        return this.f2190n;
    }

    /* renamed from: d */
    public InterfaceC0396c m8822d() {
        return this.f2188l;
    }

    /* renamed from: e */
    public AbstractC0397d m8821e() {
        return this.f2187k;
    }

    /* renamed from: f */
    public PreferenceDataStore m8820f() {
        return this.f2180d;
    }

    /* renamed from: g */
    public PreferenceScreen m8819g() {
        return this.f2186j;
    }

    /* renamed from: h */
    public SharedPreferences m8818h() {
        Context m10023a;
        if (m8820f() != null) {
            return null;
        }
        if (this.f2179c == null) {
            if (this.f2185i != 1) {
                m10023a = this.f2177a;
            } else {
                m10023a = ContextCompat.m10023a(this.f2177a);
            }
            this.f2179c = m10023a.getSharedPreferences(this.f2183g, this.f2184h);
        }
        return this.f2179c;
    }

    /* renamed from: i */
    public boolean m8817i() {
        return !this.f2182f;
    }

    /* renamed from: a */
    public void m8826a(String str) {
        this.f2183g = str;
        this.f2179c = null;
    }

    /* renamed from: a */
    public static String m8831a(Context context) {
        return context.getPackageName() + "_preferences";
    }

    /* renamed from: a */
    public boolean m8828a(PreferenceScreen preferenceScreen) {
        PreferenceScreen preferenceScreen2 = this.f2186j;
        if (preferenceScreen != preferenceScreen2) {
            if (preferenceScreen2 != null) {
                preferenceScreen2.mo7190C();
            }
            this.f2186j = preferenceScreen;
            return true;
        }
        return false;
    }

    /* renamed from: a */
    public Preference m8827a(CharSequence charSequence) {
        PreferenceScreen preferenceScreen = this.f2186j;
        if (preferenceScreen == null) {
            return null;
        }
        return preferenceScreen.m7182c(charSequence);
    }

    /* renamed from: a */
    public SharedPreferences.Editor m8835a() {
        if (this.f2180d != null) {
            return null;
        }
        if (this.f2182f) {
            if (this.f2181e == null) {
                this.f2181e = m8818h().edit();
            }
            return this.f2181e;
        }
        return m8818h().edit();
    }

    /* renamed from: a */
    public final void m8825a(boolean z) {
        SharedPreferences.Editor editor;
        if (!z && (editor = this.f2181e) != null) {
            editor.apply();
        }
        this.f2182f = z;
    }

    /* renamed from: a */
    public void m8834a(InterfaceC0394a interfaceC0394a) {
        this.f2189m = interfaceC0394a;
    }

    /* renamed from: a */
    public void m8829a(Preference preference) {
        InterfaceC0394a interfaceC0394a = this.f2189m;
        if (interfaceC0394a != null) {
            interfaceC0394a.mo8816b(preference);
        }
    }

    /* renamed from: a */
    public void m8832a(InterfaceC0396c interfaceC0396c) {
        this.f2188l = interfaceC0396c;
    }

    /* renamed from: a */
    public void m8833a(InterfaceC0395b interfaceC0395b) {
        this.f2190n = interfaceC0395b;
    }
}
