package p070c.p084d.p085a.p086a.p093e;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.text.TextUtils;
import p070c.p084d.p085a.p086a.p093e.p096f.C1067l;
import p070c.p084d.p085a.p086a.p093e.p098h.C1101d;
import p070c.p084d.p085a.p086a.p102h.C1161j;

/* renamed from: c.d.a.a.e.m */
/* loaded from: classes.dex */
public class C1109m {

    /* renamed from: a */
    public static final int f5503a = C1117u.GOOGLE_PLAY_SERVICES_VERSION_CODE;

    /* renamed from: b */
    public static final C1109m f5504b = new C1109m();

    /* renamed from: a */
    public static int m5122a(Context context, int i) {
        int zzc = C1117u.zzc(context, i);
        if (C1117u.zzd(context, zzc)) {
            return 18;
        }
        return zzc;
    }

    /* renamed from: a */
    public static Intent m5119a(Context context, int i, String str) {
        if (i == 1 || i == 2) {
            return (context == null || !C1101d.m5140b(context)) ? C1067l.m5200a("com.google.android.gms", m5118a(context, str)) : C1067l.m5202a();
        } else if (i != 3) {
            return null;
        } else {
            return C1067l.m5201a("com.google.android.gms");
        }
    }

    /* renamed from: a */
    public static C1109m m5125a() {
        return f5504b;
    }

    /* renamed from: a */
    public static String m5118a(Context context, String str) {
        StringBuilder sb = new StringBuilder();
        sb.append("gcore_");
        sb.append(f5503a);
        sb.append("-");
        if (!TextUtils.isEmpty(str)) {
            sb.append(str);
        }
        sb.append("-");
        if (context != null) {
            sb.append(context.getPackageName());
        }
        sb.append("-");
        if (context != null) {
            try {
                sb.append(C1161j.m5037b(context).m5039b(context.getPackageName(), 0).versionCode);
            } catch (PackageManager.NameNotFoundException unused) {
            }
        }
        return sb.toString();
    }

    /* renamed from: b */
    public static void m5116b(Context context) {
        C1117u.zzcf(context);
    }

    /* renamed from: b */
    public static boolean m5115b(Context context, int i) {
        return C1117u.zzd(context, i);
    }

    /* renamed from: a */
    public int mo5123a(Context context) {
        return m5122a(context, -1);
    }

    /* renamed from: a */
    public PendingIntent mo5121a(Context context, int i, int i2) {
        return m5120a(context, i, i2, null);
    }

    /* renamed from: a */
    public final PendingIntent m5120a(Context context, int i, int i2, String str) {
        Intent m5119a = m5119a(context, i, str);
        if (m5119a == null) {
            return null;
        }
        return PendingIntent.getActivity(context, i2, m5119a, 268435456);
    }

    /* renamed from: a */
    public String mo5124a(int i) {
        return C1117u.getErrorString(i);
    }

    /* renamed from: b */
    public boolean mo5117b(int i) {
        return C1117u.isUserRecoverableError(i);
    }

    @Deprecated
    /* renamed from: c */
    public final Intent m5114c(int i) {
        return m5119a((Context) null, i, (String) null);
    }
}
