package p070c.p115g.p128c.p129a.p130a;

import android.content.Context;
import android.content.SharedPreferences;

/* renamed from: c.g.c.a.a.f */
/* loaded from: classes.dex */
public class C1429f {

    /* renamed from: c */
    public static C1429f f6052c;

    /* renamed from: a */
    public Context f6053a = null;

    /* renamed from: b */
    public SharedPreferences f6054b = null;

    /* renamed from: b */
    public static C1429f m4445b() {
        C1429f c1429f = f6052c;
        if (c1429f == null || c1429f.f6053a == null) {
            throw new Exception("first getInstance must be getInstance(context) " + f6052c + " ");
        }
        return c1429f;
    }

    /* renamed from: b */
    public static C1429f m4444b(Context context) {
        f6052c = new C1429f();
        f6052c.m4451a(context);
        return f6052c;
    }

    /* renamed from: a */
    public int m4450a(String str) {
        return m4449a(str, 0);
    }

    /* renamed from: a */
    public int m4449a(String str, int i) {
        try {
            return Integer.parseInt(m4447a(str, Integer.toString(i)));
        } catch (Exception unused) {
            return i;
        }
    }

    /* renamed from: a */
    public long m4448a(String str, long j) {
        try {
            return Long.parseLong(m4447a(str, Long.toString(j)));
        } catch (Exception unused) {
            return j;
        }
    }

    /* renamed from: a */
    public final SharedPreferences m4452a() {
        if (this.f6054b == null) {
            this.f6054b = this.f6053a.getSharedPreferences("SPCHprefs", 0);
        }
        return this.f6054b;
    }

    /* renamed from: a */
    public String m4447a(String str, String str2) {
        try {
            return m4452a().getString(str, str2);
        } catch (Exception unused) {
            return str2;
        }
    }

    /* renamed from: a */
    public synchronized void m4451a(Context context) {
        if (this.f6053a == null) {
            this.f6053a = context.getApplicationContext();
            this.f6054b = this.f6053a.getSharedPreferences("SPCHprefs", 0);
        }
    }

    /* renamed from: a */
    public boolean m4446a(String str, boolean z) {
        try {
            return 1 == Integer.parseInt(m4447a(str, Integer.toString(z ? 1 : 0)));
        } catch (Exception unused) {
            return z;
        }
    }

    /* renamed from: b */
    public String m4443b(String str) {
        return m4447a(str, "");
    }

    /* renamed from: b */
    public void m4442b(String str, int i) {
        m4440b(str, Integer.toString(i));
    }

    /* renamed from: b */
    public void m4441b(String str, long j) {
        m4440b(str, Long.toString(j));
    }

    /* renamed from: b */
    public void m4440b(String str, String str2) {
        SharedPreferences.Editor edit = m4452a().edit();
        edit.putString(str, str2);
        edit.commit();
    }

    /* renamed from: b */
    public void m4439b(String str, boolean z) {
        m4440b(str, z ? "1" : "0");
    }
}
