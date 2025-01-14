package p070c.p084d.p085a.p086a.p093e;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.Signature;
import android.util.Log;
import p070c.p084d.p085a.p086a.p093e.p096f.C1049c0;

/* renamed from: c.d.a.a.e.v */
/* loaded from: classes.dex */
public class C1118v {

    /* renamed from: b */
    public static C1118v f5511b;

    /* renamed from: a */
    public final Context f5512a;

    public C1118v(Context context) {
        this.f5512a = context.getApplicationContext();
    }

    /* renamed from: a */
    public static AbstractBinderC1111o m5104a(PackageInfo packageInfo, AbstractBinderC1111o... abstractBinderC1111oArr) {
        Signature[] signatureArr = packageInfo.signatures;
        if (signatureArr == null) {
            return null;
        }
        if (signatureArr.length != 1) {
            Log.w("GoogleSignatureVerifier", "Package has more than one signature.");
            return null;
        }
        BinderC1112p binderC1112p = new BinderC1112p(signatureArr[0].toByteArray());
        for (int i = 0; i < abstractBinderC1111oArr.length; i++) {
            if (abstractBinderC1111oArr[i].equals(binderC1112p)) {
                return abstractBinderC1111oArr[i];
            }
        }
        return null;
    }

    /* renamed from: a */
    public static C1118v m5107a(Context context) {
        C1049c0.m5294a(context);
        synchronized (C1118v.class) {
            if (f5511b == null) {
                C1110n.m5113a(context);
                f5511b = new C1118v(context);
            }
        }
        return f5511b;
    }

    /* renamed from: a */
    public static boolean m5105a(PackageInfo packageInfo, boolean z) {
        if (packageInfo != null && packageInfo.signatures != null) {
            if ((z ? m5104a(packageInfo, C1114r.f5510a) : m5104a(packageInfo, C1114r.f5510a[0])) != null) {
                return true;
            }
        }
        return false;
    }

    /* renamed from: a */
    public final boolean m5106a(PackageInfo packageInfo) {
        if (packageInfo == null) {
            return false;
        }
        if (m5105a(packageInfo, false)) {
            return true;
        }
        if (m5105a(packageInfo, true)) {
            if (C1117u.zzci(this.f5512a)) {
                return true;
            }
            Log.w("GoogleSignatureVerifier", "Test-keys aren't accepted on this build.");
        }
        return false;
    }
}
