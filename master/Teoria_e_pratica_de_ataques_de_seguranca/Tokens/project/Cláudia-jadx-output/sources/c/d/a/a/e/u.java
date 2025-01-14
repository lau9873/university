package c.d.a.a.e;

import android.annotation.TargetApi;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageInstaller;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.os.Build;
import android.os.Bundle;
import android.os.UserManager;
import android.util.Log;
import c.d.a.a.e.f.c0;
import c.d.a.a.e.f.y;
import c.d.a.a.e.h.g;
import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.common.GooglePlayServicesRepairableException;
import g.a.a.n.e;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes.dex */
public class u {
    @Deprecated
    public static final String GOOGLE_PLAY_SERVICES_PACKAGE = "com.google.android.gms";
    @Deprecated
    public static final int GOOGLE_PLAY_SERVICES_VERSION_CODE = 12211000;
    public static final String GOOGLE_PLAY_STORE_PACKAGE = "com.android.vending";
    public static boolean zzfrr = false;
    public static boolean zzfrs = false;
    public static boolean zzfrt = false;
    public static boolean zzfru = false;
    public static final AtomicBoolean zzfrv = new AtomicBoolean();
    public static final AtomicBoolean zzfrw = new AtomicBoolean();

    @Deprecated
    public static PendingIntent getErrorPendingIntent(int i2, Context context, int i3) {
        return m.a().a(context, i2, i3);
    }

    @Deprecated
    public static String getErrorString(int i2) {
        return a.a(i2);
    }

    public static Context getRemoteContext(Context context) {
        try {
            return context.createPackageContext("com.google.android.gms", 3);
        } catch (PackageManager.NameNotFoundException unused) {
            return null;
        }
    }

    public static Resources getRemoteResource(Context context) {
        try {
            return context.getPackageManager().getResourcesForApplication("com.google.android.gms");
        } catch (PackageManager.NameNotFoundException unused) {
            return null;
        }
    }

    @Deprecated
    public static int isGooglePlayServicesAvailable(Context context) {
        return zzc(context, -1);
    }

    @Deprecated
    public static boolean isUserRecoverableError(int i2) {
        return i2 == 1 || i2 == 2 || i2 == 3 || i2 == 9;
    }

    public static int zza(Context context, boolean z, int i2, int i3) {
        String str;
        c0.a(i3 == -1 || i3 >= 0);
        PackageManager packageManager = context.getPackageManager();
        PackageInfo packageInfo = null;
        if (z) {
            try {
                packageInfo = packageManager.getPackageInfo("com.android.vending", 8256);
            } catch (PackageManager.NameNotFoundException unused) {
                str = "Google Play Store is missing.";
            }
        }
        try {
            PackageInfo packageInfo2 = packageManager.getPackageInfo("com.google.android.gms", 64);
            v.a(context);
            if (!v.a(packageInfo2, true)) {
                str = "Google Play services signature invalid.";
            } else if (!z || (v.a(packageInfo, true) && packageInfo.signatures[0].equals(packageInfo2.signatures[0]))) {
                int i4 = i2 / 1000;
                int i5 = packageInfo2.versionCode / 1000;
                if (i5 >= i4 || (i3 != -1 && i5 >= i3 / 1000)) {
                    ApplicationInfo applicationInfo = packageInfo2.applicationInfo;
                    if (applicationInfo == null) {
                        try {
                            applicationInfo = packageManager.getApplicationInfo("com.google.android.gms", 0);
                        } catch (PackageManager.NameNotFoundException e2) {
                            Log.wtf("GooglePlayServicesUtil", "Google Play services missing when getting application info.", e2);
                            return 1;
                        }
                    }
                    return !applicationInfo.enabled ? 3 : 0;
                }
                int i6 = GOOGLE_PLAY_SERVICES_VERSION_CODE;
                int i7 = packageInfo2.versionCode;
                StringBuilder sb = new StringBuilder(77);
                sb.append("Google Play services out of date.  Requires ");
                sb.append(i6);
                sb.append(" but found ");
                sb.append(i7);
                Log.w("GooglePlayServicesUtil", sb.toString());
                return 2;
            } else {
                str = "Google Play Store signature invalid.";
            }
            Log.w("GooglePlayServicesUtil", str);
            return 9;
        } catch (PackageManager.NameNotFoundException unused2) {
            Log.w("GooglePlayServicesUtil", "Google Play services is missing.");
            return 1;
        }
    }

    @TargetApi(19)
    @Deprecated
    public static boolean zzb(Context context, int i2, String str) {
        return g.a(context, i2, str);
    }

    @Deprecated
    public static void zzbo(Context context) {
        m.a();
        int a2 = m.a(context, -1);
        if (a2 != 0) {
            m.a();
            Intent a3 = m.a(context, a2, e.f6104e);
            StringBuilder sb = new StringBuilder(57);
            sb.append("GooglePlayServices not available due to error ");
            sb.append(a2);
            Log.e("GooglePlayServicesUtil", sb.toString());
            if (a3 != null) {
                throw new GooglePlayServicesRepairableException(a2, "Google Play Services not available", a3);
            }
            throw new GooglePlayServicesNotAvailableException(a2);
        }
    }

    @Deprecated
    public static int zzc(Context context, int i2) {
        try {
            context.getResources().getString(c.d.a.a.b.common_google_play_services_unknown_issue);
        } catch (Throwable unused) {
            Log.e("GooglePlayServicesUtil", "The Google Play services resources were not found. Check your project configuration to ensure that the resources are included.");
        }
        if (!"com.google.android.gms".equals(context.getPackageName()) && !zzfrw.get()) {
            int a2 = y.a(context);
            if (a2 == 0) {
                throw new IllegalStateException("A required meta-data tag in your app's AndroidManifest.xml does not exist.  You must have the following declaration within the <application> element:     <meta-data android:name=\"com.google.android.gms.version\" android:value=\"@integer/google_play_services_version\" />");
            }
            int i3 = GOOGLE_PLAY_SERVICES_VERSION_CODE;
            if (a2 != i3) {
                StringBuilder sb = new StringBuilder(320);
                sb.append("The meta-data tag in your app's AndroidManifest.xml does not have the right value.  Expected ");
                sb.append(i3);
                sb.append(" but found ");
                sb.append(a2);
                sb.append(".  You must have the following declaration within the <application> element:     <meta-data android:name=\"com.google.android.gms.version\" android:value=\"@integer/google_play_services_version\" />");
                throw new IllegalStateException(sb.toString());
            }
        }
        return zza(context, (c.d.a.a.e.h.d.b(context) || c.d.a.a.e.h.d.d(context)) ? false : true, GOOGLE_PLAY_SERVICES_VERSION_CODE, i2);
    }

    @Deprecated
    public static void zzcf(Context context) {
        if (zzfrv.getAndSet(true)) {
            return;
        }
        try {
            NotificationManager notificationManager = (NotificationManager) context.getSystemService("notification");
            if (notificationManager != null) {
                notificationManager.cancel(10436);
            }
        } catch (SecurityException unused) {
        }
    }

    @Deprecated
    public static int zzcg(Context context) {
        try {
            return context.getPackageManager().getPackageInfo("com.google.android.gms", 0).versionCode;
        } catch (PackageManager.NameNotFoundException unused) {
            Log.w("GooglePlayServicesUtil", "Google Play services is missing.");
            return 0;
        }
    }

    public static boolean zzci(Context context) {
        try {
            if (!zzfru) {
                try {
                    PackageInfo b2 = c.d.a.a.h.j.b(context).b("com.google.android.gms", 64);
                    v.a(context);
                    if (b2 == null || v.a(b2, false) || !v.a(b2, true)) {
                        zzfrt = false;
                    } else {
                        zzfrt = true;
                    }
                } catch (PackageManager.NameNotFoundException e2) {
                    Log.w("GooglePlayServicesUtil", "Cannot find Google Play services package name.", e2);
                }
            }
            return zzfrt || !"user".equals(Build.TYPE);
        } finally {
            zzfru = true;
        }
    }

    @Deprecated
    public static boolean zzd(Context context, int i2) {
        if (i2 == 18) {
            return true;
        }
        if (i2 == 1) {
            return zzr(context, "com.google.android.gms");
        }
        return false;
    }

    @Deprecated
    public static boolean zze(Context context, int i2) {
        return g.a(context, i2);
    }

    @TargetApi(21)
    public static boolean zzr(Context context, String str) {
        ApplicationInfo applicationInfo;
        Bundle applicationRestrictions;
        boolean equals = str.equals("com.google.android.gms");
        if (c.d.a.a.e.h.e.h()) {
            try {
                for (PackageInstaller.SessionInfo sessionInfo : context.getPackageManager().getPackageInstaller().getAllSessions()) {
                    if (str.equals(sessionInfo.getAppPackageName())) {
                        return true;
                    }
                }
            } catch (Exception unused) {
                return false;
            }
        }
        try {
            applicationInfo = context.getPackageManager().getApplicationInfo(str, 8192);
        } catch (PackageManager.NameNotFoundException unused2) {
        }
        if (equals) {
            return applicationInfo.enabled;
        }
        if (applicationInfo.enabled) {
            if (!(c.d.a.a.e.h.e.e() && (applicationRestrictions = ((UserManager) context.getSystemService("user")).getApplicationRestrictions(context.getPackageName())) != null && "true".equals(applicationRestrictions.getString("restricted_profile")))) {
                return true;
            }
        }
        return false;
    }
}
