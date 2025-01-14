package g.a.a.l;

import android.os.Build;
/* compiled from: AndroidModel.java */
/* loaded from: classes.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public String f6070a;

    /* renamed from: b  reason: collision with root package name */
    public String f6071b;

    /* renamed from: c  reason: collision with root package name */
    public String f6072c;

    /* renamed from: d  reason: collision with root package name */
    public String f6073d;

    public a(String str, String str2, String str3, String str4) {
        this.f6070a = str;
        this.f6071b = str2;
        this.f6072c = str3;
        this.f6073d = str4;
    }

    public static a e() {
        return new a(Build.VERSION.RELEASE, Build.ID, Build.MODEL, Build.MANUFACTURER);
    }

    public String a() {
        return this.f6071b;
    }

    public String b() {
        return this.f6073d;
    }

    public String c() {
        return this.f6072c;
    }

    public String d() {
        return this.f6070a;
    }

    public String toString() {
        return "" + this.f6073d + ";" + this.f6072c + ";" + this.f6071b + ";" + this.f6070a;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v2 */
    /* JADX WARN: Type inference failed for: r0v7 */
    /* JADX WARN: Type inference failed for: r0v8 */
    /* JADX WARN: Type inference failed for: r0v9 */
    public int a(a aVar) {
        boolean equalsIgnoreCase = this.f6073d.equalsIgnoreCase(aVar.f6073d);
        ?? r0 = equalsIgnoreCase;
        if (equalsIgnoreCase) {
            r0 = equalsIgnoreCase;
            if (this.f6072c.equals(aVar.f6072c)) {
                r0 = 2;
            }
        }
        int i2 = r0;
        if (r0 == 2) {
            i2 = r0;
            if (this.f6071b.equals(aVar.f6071b)) {
                i2 = 3;
            }
        }
        if (i2 == 3 && this.f6070a.equals(aVar.f6070a)) {
            i2 = 4;
        }
        g.a.a.m.d.a("AndroidModel", "Score is %s for %s compared to %s", Integer.valueOf(i2), toString(), aVar);
        return i2;
    }
}
