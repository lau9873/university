package p070c.p084d.p085a.p086a.p102h;

import android.annotation.TargetApi;
import android.app.AppOpsManager;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import p070c.p084d.p085a.p086a.p093e.p098h.C1102e;

/* renamed from: c.d.a.a.h.i */
/* loaded from: classes.dex */
public final class C1158i {

    /* renamed from: a */
    public Context f5548a;

    public C1158i(Context context) {
        this.f5548a = context;
    }

    /* renamed from: a */
    public final ApplicationInfo m5040a(String str, int i) {
        return this.f5548a.getPackageManager().getApplicationInfo(str, i);
    }

    /* renamed from: a */
    public final CharSequence m5041a(String str) {
        return this.f5548a.getPackageManager().getApplicationLabel(this.f5548a.getPackageManager().getApplicationInfo(str, 0));
    }

    @TargetApi(19)
    /* renamed from: a */
    public final boolean m5042a(int i, String str) {
        if (C1102e.m5132f()) {
            try {
                ((AppOpsManager) this.f5548a.getSystemService("appops")).checkPackage(i, str);
                return true;
            } catch (SecurityException unused) {
                return false;
            }
        }
        String[] packagesForUid = this.f5548a.getPackageManager().getPackagesForUid(i);
        if (str != null && packagesForUid != null) {
            for (String str2 : packagesForUid) {
                if (str.equals(str2)) {
                    return true;
                }
            }
        }
        return false;
    }

    /* renamed from: b */
    public final PackageInfo m5039b(String str, int i) {
        return this.f5548a.getPackageManager().getPackageInfo(str, i);
    }
}
