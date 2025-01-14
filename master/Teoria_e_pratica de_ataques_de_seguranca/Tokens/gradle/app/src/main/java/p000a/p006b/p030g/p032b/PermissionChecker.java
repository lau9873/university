package p000a.p006b.p030g.p032b;

import android.content.Context;
import android.os.Process;
import p000a.p006b.p030g.p031a.AppOpsManagerCompat;

/* renamed from: a.b.g.b.f */
/* loaded from: classes.dex */
public final class PermissionChecker {
    /* renamed from: a */
    public static int m9995a(Context context, String str, int i, int i2, String str2) {
        if (context.checkPermission(str, i, i2) == -1) {
            return -1;
        }
        String m10403a = AppOpsManagerCompat.m10403a(str);
        if (m10403a == null) {
            return 0;
        }
        if (str2 == null) {
            String[] packagesForUid = context.getPackageManager().getPackagesForUid(i2);
            if (packagesForUid == null || packagesForUid.length <= 0) {
                return -1;
            }
            str2 = packagesForUid[0];
        }
        return AppOpsManagerCompat.m10404a(context, m10403a, str2) != 0 ? -2 : 0;
    }

    /* renamed from: a */
    public static int m9996a(Context context, String str) {
        return m9995a(context, str, Process.myPid(), Process.myUid(), context.getPackageName());
    }
}
