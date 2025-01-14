package c.b.a.d;

import android.content.Context;
import android.content.pm.PackageInfo;
/* compiled from: AppData.java */
/* loaded from: classes.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public final String f2969a;

    /* renamed from: b  reason: collision with root package name */
    public final String f2970b;

    /* renamed from: c  reason: collision with root package name */
    public final String f2971c;

    /* renamed from: d  reason: collision with root package name */
    public final String f2972d;

    /* renamed from: e  reason: collision with root package name */
    public final String f2973e;

    /* renamed from: f  reason: collision with root package name */
    public final String f2974f;

    public a(String str, String str2, String str3, String str4, String str5, String str6) {
        this.f2969a = str;
        this.f2970b = str2;
        this.f2971c = str3;
        this.f2972d = str4;
        this.f2973e = str5;
        this.f2974f = str6;
    }

    public static a a(Context context, d.a.a.a.m.b.o oVar, String str, String str2) {
        String packageName = context.getPackageName();
        String i2 = oVar.i();
        PackageInfo packageInfo = context.getPackageManager().getPackageInfo(packageName, 0);
        String num = Integer.toString(packageInfo.versionCode);
        String str3 = packageInfo.versionName;
        if (str3 == null) {
            str3 = "0.0";
        }
        return new a(str, str2, i2, packageName, num, str3);
    }
}
