package p070c.p084d.p085a.p086a.p093e;

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
import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.common.GooglePlayServicesRepairableException;
import java.util.concurrent.atomic.AtomicBoolean;
import p070c.p084d.p085a.p086a.C0894b;
import p070c.p084d.p085a.p086a.p093e.p096f.C1049c0;
import p070c.p084d.p085a.p086a.p093e.p096f.C1093y;
import p070c.p084d.p085a.p086a.p093e.p098h.C1101d;
import p070c.p084d.p085a.p086a.p093e.p098h.C1102e;
import p070c.p084d.p085a.p086a.p093e.p098h.C1104g;
import p070c.p084d.p085a.p086a.p102h.C1161j;
import p193g.p194a.p195a.p199n.MonitoringStatus;

/* renamed from: c.d.a.a.e.u */
/* loaded from: classes.dex */
public class C1117u {
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
    public static PendingIntent getErrorPendingIntent(int i, Context context, int i2) {
        return C1109m.m5125a().mo5121a(context, i, i2);
    }

    @Deprecated
    public static String getErrorString(int i) {
        return C0900a.m5646a(i);
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
    public static boolean isUserRecoverableError(int i) {
        return i == 1 || i == 2 || i == 3 || i == 9;
    }

    public static int zza(Context context, boolean z, int i, int i2) {
        String str;
        C1049c0.m5290a(i2 == -1 || i2 >= 0);
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
            C1118v.m5107a(context);
            if (!C1118v.m5105a(packageInfo2, true)) {
                str = "Google Play services signature invalid.";
            } else if (!z || (C1118v.m5105a(packageInfo, true) && packageInfo.signatures[0].equals(packageInfo2.signatures[0]))) {
                int i3 = i / 1000;
                int i4 = packageInfo2.versionCode / 1000;
                if (i4 >= i3 || (i2 != -1 && i4 >= i2 / 1000)) {
                    ApplicationInfo applicationInfo = packageInfo2.applicationInfo;
                    if (applicationInfo == null) {
                        try {
                            applicationInfo = packageManager.getApplicationInfo("com.google.android.gms", 0);
                        } catch (PackageManager.NameNotFoundException e) {
                            Log.wtf("GooglePlayServicesUtil", "Google Play services missing when getting application info.", e);
                            return 1;
                        }
                    }
                    return !applicationInfo.enabled ? 3 : 0;
                }
                int i5 = GOOGLE_PLAY_SERVICES_VERSION_CODE;
                int i6 = packageInfo2.versionCode;
                StringBuilder sb = new StringBuilder(77);
                sb.append("Google Play services out of date.  Requires ");
                sb.append(i5);
                sb.append(" but found ");
                sb.append(i6);
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
    public static boolean zzb(Context context, int i, String str) {
        return C1104g.m5127a(context, i, str);
    }

    @Deprecated
    public static void zzbo(Context context) {
        C1109m.m5125a();
        int m5122a = C1109m.m5122a(context, -1);
        if (m5122a != 0) {
            C1109m.m5125a();
            Intent m5119a = C1109m.m5119a(context, m5122a, MonitoringStatus.f8566e);
            StringBuilder sb = new StringBuilder(57);
            sb.append("GooglePlayServices not available due to error ");
            sb.append(m5122a);
            Log.e("GooglePlayServicesUtil", sb.toString());
            if (m5119a != null) {
                throw new GooglePlayServicesRepairableException(m5122a, "Google Play Services not available", m5119a);
            }
            throw new GooglePlayServicesNotAvailableException(m5122a);
        }
    }

    @Deprecated
    public static int zzc(Context context, int i) {
        try {
            context.getResources().getString(C0894b.common_google_play_services_unknown_issue);
        } catch (Throwable unused) {
            Log.e("GooglePlayServicesUtil", "The Google Play services resources were not found. Check your project configuration to ensure that the resources are included.");
        }
        if (!"com.google.android.gms".equals(context.getPackageName()) && !zzfrw.get()) {
            int m5155a = C1093y.m5155a(context);
            if (m5155a == 0) {
                throw new IllegalStateException("A required meta-data tag in your app's AndroidManifest.xml does not exist.  You must have the following declaration within the <application> element:     <meta-data android:name=\"com.google.android.gms.version\" android:value=\"@integer/google_play_services_version\" />");
            }
            int i2 = GOOGLE_PLAY_SERVICES_VERSION_CODE;
            if (m5155a != i2) {
                StringBuilder sb = new StringBuilder(320);
                sb.append("The meta-data tag in your app's AndroidManifest.xml does not have the right value.  Expected ");
                sb.append(i2);
                sb.append(" but found ");
                sb.append(m5155a);
                sb.append(".  You must have the following declaration within the <application> element:     <meta-data android:name=\"com.google.android.gms.version\" android:value=\"@integer/google_play_services_version\" />");
                throw new IllegalStateException(sb.toString());
            }
        }
        return zza(context, (C1101d.m5140b(context) || C1101d.m5138d(context)) ? false : true, GOOGLE_PLAY_SERVICES_VERSION_CODE, i);
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
                    PackageInfo m5039b = C1161j.m5037b(context).m5039b("com.google.android.gms", 64);
                    C1118v.m5107a(context);
                    if (m5039b == null || C1118v.m5105a(m5039b, false) || !C1118v.m5105a(m5039b, true)) {
                        zzfrt = false;
                    } else {
                        zzfrt = true;
                    }
                } catch (PackageManager.NameNotFoundException e) {
                    Log.w("GooglePlayServicesUtil", "Cannot find Google Play services package name.", e);
                }
            }
            return zzfrt || !"user".equals(Build.TYPE);
        } finally {
            zzfru = true;
        }
    }

    @Deprecated
    public static boolean zzd(Context context, int i) {
        if (i == 18) {
            return true;
        }
        if (i == 1) {
            return zzr(context, "com.google.android.gms");
        }
        return false;
    }

    @Deprecated
    public static boolean zze(Context context, int i) {
        return C1104g.m5128a(context, i);
    }

    @TargetApi(21)
    public static boolean zzr(Context context, String str) {
        ApplicationInfo applicationInfo;
        Bundle applicationRestrictions;
        boolean equals = str.equals("com.google.android.gms");
        if (C1102e.m5130h()) {
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
            if (!(C1102e.m5133e() && (applicationRestrictions = ((UserManager) context.getSystemService("user")).getApplicationRestrictions(context.getPackageName())) != null && "true".equals(applicationRestrictions.getString("restricted_profile")))) {
                return true;
            }
        }
        return false;
    }
}
