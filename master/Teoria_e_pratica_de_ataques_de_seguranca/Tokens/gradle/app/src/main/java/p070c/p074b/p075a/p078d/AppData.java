package p070c.p074b.p075a.p078d;

import android.content.Context;
import android.content.pm.PackageInfo;
import p136d.p137a.p138a.p139a.p140m.p142b.IdManager;

/* renamed from: c.b.a.d.a */
/* loaded from: classes.dex */
public class AppData {

    /* renamed from: a */
    public final String f4782a;

    /* renamed from: b */
    public final String f4783b;

    /* renamed from: c */
    public final String f4784c;

    /* renamed from: d */
    public final String f4785d;

    /* renamed from: e */
    public final String f4786e;

    /* renamed from: f */
    public final String f4787f;

    public AppData(String str, String str2, String str3, String str4, String str5, String str6) {
        this.f4782a = str;
        this.f4783b = str2;
        this.f4784c = str3;
        this.f4785d = str4;
        this.f4786e = str5;
        this.f4787f = str6;
    }

    /* renamed from: a */
    public static AppData m5978a(Context context, IdManager idManager, String str, String str2) {
        String packageName = context.getPackageName();
        String m4044i = idManager.m4044i();
        PackageInfo packageInfo = context.getPackageManager().getPackageInfo(packageName, 0);
        String num = Integer.toString(packageInfo.versionCode);
        String str3 = packageInfo.versionName;
        if (str3 == null) {
            str3 = "0.0";
        }
        return new AppData(str, str2, m4044i, packageName, num, str3);
    }
}
