package c.d.a.a.e;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.text.TextUtils;
/* loaded from: classes.dex */
public class m {

    /* renamed from: a  reason: collision with root package name */
    public static final int f3570a = u.GOOGLE_PLAY_SERVICES_VERSION_CODE;

    /* renamed from: b  reason: collision with root package name */
    public static final m f3571b = new m();

    public static int a(Context context, int i2) {
        int zzc = u.zzc(context, i2);
        if (u.zzd(context, zzc)) {
            return 18;
        }
        return zzc;
    }

    public static Intent a(Context context, int i2, String str) {
        if (i2 == 1 || i2 == 2) {
            return (context == null || !c.d.a.a.e.h.d.b(context)) ? c.d.a.a.e.f.l.a("com.google.android.gms", a(context, str)) : c.d.a.a.e.f.l.a();
        } else if (i2 != 3) {
            return null;
        } else {
            return c.d.a.a.e.f.l.a("com.google.android.gms");
        }
    }

    public static m a() {
        return f3571b;
    }

    public static String a(Context context, String str) {
        StringBuilder sb = new StringBuilder();
        sb.append("gcore_");
        sb.append(f3570a);
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
                sb.append(c.d.a.a.h.j.b(context).b(context.getPackageName(), 0).versionCode);
            } catch (PackageManager.NameNotFoundException unused) {
            }
        }
        return sb.toString();
    }

    public static void b(Context context) {
        u.zzcf(context);
    }

    public static boolean b(Context context, int i2) {
        return u.zzd(context, i2);
    }

    public int a(Context context) {
        return a(context, -1);
    }

    public PendingIntent a(Context context, int i2, int i3) {
        return a(context, i2, i3, null);
    }

    public final PendingIntent a(Context context, int i2, int i3, String str) {
        Intent a2 = a(context, i2, str);
        if (a2 == null) {
            return null;
        }
        return PendingIntent.getActivity(context, i3, a2, 268435456);
    }

    public String a(int i2) {
        return u.getErrorString(i2);
    }

    public boolean b(int i2) {
        return u.isUserRecoverableError(i2);
    }

    @Deprecated
    public final Intent c(int i2) {
        return a((Context) null, i2, (String) null);
    }
}
