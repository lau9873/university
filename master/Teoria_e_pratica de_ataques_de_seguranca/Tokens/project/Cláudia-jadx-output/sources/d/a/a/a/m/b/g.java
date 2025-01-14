package d.a.a.a.m.b;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
/* compiled from: ApiKey.java */
/* loaded from: classes.dex */
public class g {
    public String a() {
        return "Fabric could not be initialized, API key missing from AndroidManifest.xml. Add the following tag to your Application element \n\t<meta-data android:name=\"io.fabric.ApiKey\" android:value=\"YOUR_API_KEY\"/>";
    }

    public String a(Context context) {
        try {
            Bundle bundle = context.getPackageManager().getApplicationInfo(context.getPackageName(), 128).metaData;
            if (bundle != null) {
                String string = bundle.getString("io.fabric.ApiKey");
                if (string == null) {
                    d.a.a.a.c.h().e("Fabric", "Falling back to Crashlytics key lookup from Manifest");
                    return bundle.getString("com.crashlytics.ApiKey");
                }
                return string;
            }
            return null;
        } catch (Exception e2) {
            d.a.a.a.k h2 = d.a.a.a.c.h();
            h2.e("Fabric", "Caught non-fatal exception while retrieving apiKey: " + e2);
            return null;
        }
    }

    public String b(Context context) {
        int a2 = i.a(context, "io.fabric.ApiKey", "string");
        if (a2 == 0) {
            d.a.a.a.c.h().e("Fabric", "Falling back to Crashlytics key lookup from Strings");
            a2 = i.a(context, "com.crashlytics.ApiKey", "string");
        }
        if (a2 != 0) {
            return context.getResources().getString(a2);
        }
        return null;
    }

    public String c(Context context) {
        String a2 = a(context);
        if (TextUtils.isEmpty(a2)) {
            a2 = b(context);
        }
        if (TextUtils.isEmpty(a2)) {
            d(context);
        }
        return a2;
    }

    public void d(Context context) {
        if (!d.a.a.a.c.i() && !i.j(context)) {
            d.a.a.a.c.h().c("Fabric", a());
            return;
        }
        throw new IllegalArgumentException(a());
    }
}
