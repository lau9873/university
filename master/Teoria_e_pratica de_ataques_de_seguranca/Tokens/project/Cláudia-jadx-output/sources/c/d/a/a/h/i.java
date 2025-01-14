package c.d.a.a.h;

import android.annotation.TargetApi;
import android.app.AppOpsManager;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
/* loaded from: classes.dex */
public final class i {

    /* renamed from: a  reason: collision with root package name */
    public Context f3611a;

    public i(Context context) {
        this.f3611a = context;
    }

    public final ApplicationInfo a(String str, int i2) {
        return this.f3611a.getPackageManager().getApplicationInfo(str, i2);
    }

    public final CharSequence a(String str) {
        return this.f3611a.getPackageManager().getApplicationLabel(this.f3611a.getPackageManager().getApplicationInfo(str, 0));
    }

    @TargetApi(19)
    public final boolean a(int i2, String str) {
        if (c.d.a.a.e.h.e.f()) {
            try {
                ((AppOpsManager) this.f3611a.getSystemService("appops")).checkPackage(i2, str);
                return true;
            } catch (SecurityException unused) {
                return false;
            }
        }
        String[] packagesForUid = this.f3611a.getPackageManager().getPackagesForUid(i2);
        if (str != null && packagesForUid != null) {
            for (String str2 : packagesForUid) {
                if (str.equals(str2)) {
                    return true;
                }
            }
        }
        return false;
    }

    public final PackageInfo b(String str, int i2) {
        return this.f3611a.getPackageManager().getPackageInfo(str, i2);
    }
}
