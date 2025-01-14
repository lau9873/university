package c.a.a.o;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.net.http.AndroidHttpClient;
import android.os.Build;
import java.io.File;
/* compiled from: Volley.java */
/* loaded from: classes.dex */
public class o {
    public static c.a.a.j a(Context context, b bVar) {
        c cVar;
        String str;
        if (bVar == null) {
            if (Build.VERSION.SDK_INT >= 9) {
                cVar = new c((b) new j());
            } else {
                try {
                    String packageName = context.getPackageName();
                    PackageInfo packageInfo = context.getPackageManager().getPackageInfo(packageName, 0);
                    str = packageName + "/" + packageInfo.versionCode;
                } catch (PackageManager.NameNotFoundException unused) {
                    str = "volley/0";
                }
                cVar = new c(new f(AndroidHttpClient.newInstance(str)));
            }
        } else {
            cVar = new c(bVar);
        }
        return a(context, cVar);
    }

    public static c.a.a.j a(Context context, c.a.a.f fVar) {
        c.a.a.j jVar = new c.a.a.j(new e(new File(context.getCacheDir(), "volley")), fVar);
        jVar.b();
        return jVar;
    }

    public static c.a.a.j a(Context context) {
        return a(context, (b) null);
    }
}
