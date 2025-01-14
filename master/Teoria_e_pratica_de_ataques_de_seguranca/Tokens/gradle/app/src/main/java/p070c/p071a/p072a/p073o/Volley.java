package p070c.p071a.p072a.p073o;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.net.http.AndroidHttpClient;
import android.os.Build;
import java.io.File;
import p070c.p071a.p072a.Network;
import p070c.p071a.p072a.RequestQueue;

/* renamed from: c.a.a.o.o */
/* loaded from: classes.dex */
public class Volley {
    /* renamed from: a */
    public static RequestQueue m6084a(Context context, BaseHttpStack baseHttpStack) {
        BasicNetwork basicNetwork;
        String str;
        if (baseHttpStack == null) {
            if (Build.VERSION.SDK_INT >= 9) {
                basicNetwork = new BasicNetwork((BaseHttpStack) new HurlStack());
            } else {
                try {
                    String packageName = context.getPackageName();
                    PackageInfo packageInfo = context.getPackageManager().getPackageInfo(packageName, 0);
                    str = packageName + "/" + packageInfo.versionCode;
                } catch (PackageManager.NameNotFoundException unused) {
                    str = "volley/0";
                }
                basicNetwork = new BasicNetwork(new HttpClientStack(AndroidHttpClient.newInstance(str)));
            }
        } else {
            basicNetwork = new BasicNetwork(baseHttpStack);
        }
        return m6085a(context, basicNetwork);
    }

    /* renamed from: a */
    public static RequestQueue m6085a(Context context, Network network) {
        RequestQueue requestQueue = new RequestQueue(new DiskBasedCache(new File(context.getCacheDir(), "volley")), network);
        requestQueue.m6183b();
        return requestQueue;
    }

    /* renamed from: a */
    public static RequestQueue m6086a(Context context) {
        return m6084a(context, (BaseHttpStack) null);
    }
}
