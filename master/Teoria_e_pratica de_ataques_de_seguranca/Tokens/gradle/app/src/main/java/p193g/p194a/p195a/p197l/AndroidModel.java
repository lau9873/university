package p193g.p194a.p195a.p197l;

import android.os.Build;
import p193g.p194a.p195a.p198m.LogManager;

/* renamed from: g.a.a.l.a */
/* loaded from: classes.dex */
public class AndroidModel {

    /* renamed from: a */
    public String f8532a;

    /* renamed from: b */
    public String f8533b;

    /* renamed from: c */
    public String f8534c;

    /* renamed from: d */
    public String f8535d;

    public AndroidModel(String str, String str2, String str3, String str4) {
        this.f8532a = str;
        this.f8533b = str2;
        this.f8534c = str3;
        this.f8535d = str4;
    }

    /* renamed from: e */
    public static AndroidModel m2462e() {
        return new AndroidModel(Build.VERSION.RELEASE, Build.ID, Build.MODEL, Build.MANUFACTURER);
    }

    /* renamed from: a */
    public String m2467a() {
        return this.f8533b;
    }

    /* renamed from: b */
    public String m2465b() {
        return this.f8535d;
    }

    /* renamed from: c */
    public String m2464c() {
        return this.f8534c;
    }

    /* renamed from: d */
    public String m2463d() {
        return this.f8532a;
    }

    public String toString() {
        return "" + this.f8535d + ";" + this.f8534c + ";" + this.f8533b + ";" + this.f8532a;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v2 */
    /* JADX WARN: Type inference failed for: r0v7 */
    /* JADX WARN: Type inference failed for: r0v8 */
    /* JADX WARN: Type inference failed for: r0v9 */
    /* renamed from: a */
    public int m2466a(AndroidModel androidModel) {
        boolean equalsIgnoreCase = this.f8535d.equalsIgnoreCase(androidModel.f8535d);
        ?? r0 = equalsIgnoreCase;
        if (equalsIgnoreCase) {
            r0 = equalsIgnoreCase;
            if (this.f8534c.equals(androidModel.f8534c)) {
                r0 = 2;
            }
        }
        int i = r0;
        if (r0 == 2) {
            i = r0;
            if (this.f8533b.equals(androidModel.f8533b)) {
                i = 3;
            }
        }
        if (i == 3 && this.f8532a.equals(androidModel.f8532a)) {
            i = 4;
        }
        LogManager.m2432a("AndroidModel", "Score is %s for %s compared to %s", Integer.valueOf(i), toString(), androidModel);
        return i;
    }
}
