package p070c.p084d.p085a.p086a.p093e.p098h;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.pm.PackageManager;
import android.util.Log;
import p070c.p084d.p085a.p086a.p093e.C1118v;
import p070c.p084d.p085a.p086a.p102h.C1161j;

/* renamed from: c.d.a.a.e.h.g */
/* loaded from: classes.dex */
public final class C1104g {
    /* renamed from: a */
    public static boolean m5128a(Context context, int i) {
        if (m5127a(context, i, "com.google.android.gms")) {
            try {
                return C1118v.m5107a(context).m5106a(context.getPackageManager().getPackageInfo("com.google.android.gms", 64));
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
    /* renamed from: a */
    public static boolean m5127a(Context context, int i, String str) {
        return C1161j.m5037b(context).m5042a(i, str);
    }
}
