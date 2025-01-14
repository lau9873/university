package c.d.a.a.e;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.Signature;
import android.util.Log;
import c.d.a.a.e.f.c0;
/* loaded from: classes.dex */
public class v {

    /* renamed from: b  reason: collision with root package name */
    public static v f3578b;

    /* renamed from: a  reason: collision with root package name */
    public final Context f3579a;

    public v(Context context) {
        this.f3579a = context.getApplicationContext();
    }

    public static o a(PackageInfo packageInfo, o... oVarArr) {
        Signature[] signatureArr = packageInfo.signatures;
        if (signatureArr == null) {
            return null;
        }
        if (signatureArr.length != 1) {
            Log.w("GoogleSignatureVerifier", "Package has more than one signature.");
            return null;
        }
        p pVar = new p(signatureArr[0].toByteArray());
        for (int i2 = 0; i2 < oVarArr.length; i2++) {
            if (oVarArr[i2].equals(pVar)) {
                return oVarArr[i2];
            }
        }
        return null;
    }

    public static v a(Context context) {
        c0.a(context);
        synchronized (v.class) {
            if (f3578b == null) {
                n.a(context);
                f3578b = new v(context);
            }
        }
        return f3578b;
    }

    public static boolean a(PackageInfo packageInfo, boolean z) {
        if (packageInfo != null && packageInfo.signatures != null) {
            if ((z ? a(packageInfo, r.f3577a) : a(packageInfo, r.f3577a[0])) != null) {
                return true;
            }
        }
        return false;
    }

    public final boolean a(PackageInfo packageInfo) {
        if (packageInfo == null) {
            return false;
        }
        if (a(packageInfo, false)) {
            return true;
        }
        if (a(packageInfo, true)) {
            if (u.zzci(this.f3579a)) {
                return true;
            }
            Log.w("GoogleSignatureVerifier", "Test-keys aren't accepted on this build.");
        }
        return false;
    }
}
