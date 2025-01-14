package a.b.h.f;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.preference.Preference;
import android.support.v7.preference.PreferenceScreen;
/* compiled from: PreferenceManager.java */
/* loaded from: classes.dex */
public class j {

    /* renamed from: a  reason: collision with root package name */
    public Context f1436a;

    /* renamed from: c  reason: collision with root package name */
    public SharedPreferences f1438c;

    /* renamed from: d  reason: collision with root package name */
    public e f1439d;

    /* renamed from: e  reason: collision with root package name */
    public SharedPreferences.Editor f1440e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f1441f;

    /* renamed from: g  reason: collision with root package name */
    public String f1442g;

    /* renamed from: h  reason: collision with root package name */
    public int f1443h;
    public PreferenceScreen j;
    public d k;
    public c l;
    public a m;
    public b n;

    /* renamed from: b  reason: collision with root package name */
    public long f1437b = 0;

    /* renamed from: i  reason: collision with root package name */
    public int f1444i = 0;

    /* compiled from: PreferenceManager.java */
    /* loaded from: classes.dex */
    public interface a {
        void b(Preference preference);
    }

    /* compiled from: PreferenceManager.java */
    /* loaded from: classes.dex */
    public interface b {
        void a(PreferenceScreen preferenceScreen);
    }

    /* compiled from: PreferenceManager.java */
    /* loaded from: classes.dex */
    public interface c {
        boolean a(Preference preference);
    }

    /* compiled from: PreferenceManager.java */
    /* loaded from: classes.dex */
    public static abstract class d {
        public abstract boolean a(Preference preference, Preference preference2);

        public abstract boolean b(Preference preference, Preference preference2);
    }

    public j(Context context) {
        this.f1436a = context;
        a(a(context));
    }

    public PreferenceScreen a(Context context, int i2, PreferenceScreen preferenceScreen) {
        a(true);
        PreferenceScreen preferenceScreen2 = (PreferenceScreen) new i(context, this).a(i2, preferenceScreen);
        preferenceScreen2.a(this);
        a(false);
        return preferenceScreen2;
    }

    public long b() {
        long j;
        synchronized (this) {
            j = this.f1437b;
            this.f1437b = 1 + j;
        }
        return j;
    }

    public b c() {
        return this.n;
    }

    public c d() {
        return this.l;
    }

    public d e() {
        return this.k;
    }

    public e f() {
        return this.f1439d;
    }

    public PreferenceScreen g() {
        return this.j;
    }

    public SharedPreferences h() {
        Context a2;
        if (f() != null) {
            return null;
        }
        if (this.f1438c == null) {
            if (this.f1444i != 1) {
                a2 = this.f1436a;
            } else {
                a2 = a.b.g.b.b.a(this.f1436a);
            }
            this.f1438c = a2.getSharedPreferences(this.f1442g, this.f1443h);
        }
        return this.f1438c;
    }

    public boolean i() {
        return !this.f1441f;
    }

    public void a(String str) {
        this.f1442g = str;
        this.f1438c = null;
    }

    public static String a(Context context) {
        return context.getPackageName() + "_preferences";
    }

    public boolean a(PreferenceScreen preferenceScreen) {
        PreferenceScreen preferenceScreen2 = this.j;
        if (preferenceScreen != preferenceScreen2) {
            if (preferenceScreen2 != null) {
                preferenceScreen2.C();
            }
            this.j = preferenceScreen;
            return true;
        }
        return false;
    }

    public Preference a(CharSequence charSequence) {
        PreferenceScreen preferenceScreen = this.j;
        if (preferenceScreen == null) {
            return null;
        }
        return preferenceScreen.c(charSequence);
    }

    public SharedPreferences.Editor a() {
        if (this.f1439d != null) {
            return null;
        }
        if (this.f1441f) {
            if (this.f1440e == null) {
                this.f1440e = h().edit();
            }
            return this.f1440e;
        }
        return h().edit();
    }

    public final void a(boolean z) {
        SharedPreferences.Editor editor;
        if (!z && (editor = this.f1440e) != null) {
            editor.apply();
        }
        this.f1441f = z;
    }

    public void a(a aVar) {
        this.m = aVar;
    }

    public void a(Preference preference) {
        a aVar = this.m;
        if (aVar != null) {
            aVar.b(preference);
        }
    }

    public void a(c cVar) {
        this.l = cVar;
    }

    public void a(b bVar) {
        this.n = bVar;
    }
}
