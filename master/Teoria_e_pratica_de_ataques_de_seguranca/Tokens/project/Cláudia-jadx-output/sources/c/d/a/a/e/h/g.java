package c.d.a.a.e.h;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.pm.PackageManager;
import android.util.Log;
import c.d.a.a.e.v;
import c.d.a.a.h.j;
/* loaded from: classes.dex */
public final class g {
    public static boolean a(Context context, int i2) {
        if (a(context, i2, "com.google.android.gms")) {
            try {
                return v.a(context).a(context.getPackageManager().getPackageInfo("com.google.android.gms", 64));
            } catch (PackageManager.NameNotFoundException unused) {
                if (Log.isLoggable("UidVerifier", 3)) {
                    Log.d("UidVerifier", "Package manager can't find google play services package, defaulting to false");
                }
                return false;
            }
        }
        return false;
    }

    @TargetApi(19)
    public static boolean a(Context context, int i2, String str) {
        return j.b(context).a(i2, str);
    }
}
