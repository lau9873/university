package c.g.c.a.a;

import android.content.Context;
import android.content.SharedPreferences;
/* loaded from: classes.dex */
public class f {

    /* renamed from: c  reason: collision with root package name */
    public static f f4023c;

    /* renamed from: a  reason: collision with root package name */
    public Context f4024a = null;

    /* renamed from: b  reason: collision with root package name */
    public SharedPreferences f4025b = null;

    public static f b() {
        f fVar = f4023c;
        if (fVar == null || fVar.f4024a == null) {
            throw new Exception("first getInstance must be getInstance(context) " + f4023c + " ");
        }
        return fVar;
    }

    public static f b(Context context) {
        f4023c = new f();
        f4023c.a(context);
        return f4023c;
    }

    public int a(String str) {
        return a(str, 0);
    }

    public int a(String str, int i2) {
        try {
            return Integer.parseInt(a(str, Integer.toString(i2)));
        } catch (Exception unused) {
            return i2;
        }
    }

    public long a(String str, long j) {
        try {
            return Long.parseLong(a(str, Long.toString(j)));
        } catch (Exception unused) {
            return j;
        }
    }

    public final SharedPreferences a() {
        if (this.f4025b == null) {
            this.f4025b = this.f4024a.getSharedPreferences("SPCHprefs", 0);
        }
        return this.f4025b;
    }

    public String a(String str, String str2) {
        try {
            return a().getString(str, str2);
        } catch (Exception unused) {
            return str2;
        }
    }

    public synchronized void a(Context context) {
        if (this.f4024a == null) {
            this.f4024a = context.getApplicationContext();
            this.f4025b = this.f4024a.getSharedPreferences("SPCHprefs", 0);
        }
    }

    public boolean a(String str, boolean z) {
        try {
            return 1 == Integer.parseInt(a(str, Integer.toString(z ? 1 : 0)));
        } catch (Exception unused) {
            return z;
        }
    }

    public String b(String str) {
        return a(str, "");
    }

    public void b(String str, int i2) {
        b(str, Integer.toString(i2));
    }

    public void b(String str, long j) {
        b(str, Long.toString(j));
    }

    public void b(String str, String str2) {
        SharedPreferences.Editor edit = a().edit();
        edit.putString(str, str2);
        edit.commit();
    }

    public void b(String str, boolean z) {
        b(str, z ? "1" : "0");
    }
}
