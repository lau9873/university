package p000a.p006b.p030g.p031a;

import android.app.AppOpsManager;
import android.content.Context;
import android.os.Build;

/* renamed from: a.b.g.a.b */
/* loaded from: classes.dex */
public final class AppOpsManagerCompat {
    /* renamed from: a */
    public static String m10403a(String str) {
        if (Build.VERSION.SDK_INT >= 23) {
            return AppOpsManager.permissionToOp(str);
        }
        return null;
    }

    /* renamed from: a */
    public static int m10404a(Context context, String str, String str2) {
        if (Build.VERSION.SDK_INT >= 23) {
            return ((AppOpsManager) context.getSystemService(AppOpsManager.class)).noteProxyOpNoThrow(str, str2);
        }
        return 1;
    }
}
