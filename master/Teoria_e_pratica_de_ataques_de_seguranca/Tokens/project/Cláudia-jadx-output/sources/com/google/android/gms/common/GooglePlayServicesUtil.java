package com.google.android.gms.common;

import android.app.Activity;
import android.app.Dialog;
import android.app.PendingIntent;
import android.content.Context;
import android.content.DialogInterface;
import android.content.res.Resources;
import android.support.v4.app.Fragment;
import c.d.a.a.e.c;
import c.d.a.a.e.f.y0;
import c.d.a.a.e.m;
import c.d.a.a.e.u;
/* loaded from: classes.dex */
public final class GooglePlayServicesUtil extends u {
    public static final String GMS_ERROR_DIALOG = "GooglePlayServicesErrorDialog";
    @Deprecated
    public static final String GOOGLE_PLAY_SERVICES_PACKAGE = "com.google.android.gms";
    @Deprecated
    public static final int GOOGLE_PLAY_SERVICES_VERSION_CODE = u.GOOGLE_PLAY_SERVICES_VERSION_CODE;
    public static final String GOOGLE_PLAY_STORE_PACKAGE = "com.android.vending";

    @Deprecated
    public static Dialog getErrorDialog(int i2, Activity activity, int i3) {
        return getErrorDialog(i2, activity, i3, null);
    }

    @Deprecated
    public static Dialog getErrorDialog(int i2, Activity activity, int i3, DialogInterface.OnCancelListener onCancelListener) {
        if (u.zzd(activity, i2)) {
            i2 = 18;
        }
        return c.c().a(activity, i2, i3, onCancelListener);
    }

    @Deprecated
    public static PendingIntent getErrorPendingIntent(int i2, Context context, int i3) {
        return u.getErrorPendingIntent(i2, context, i3);
    }

    @Deprecated
    public static String getErrorString(int i2) {
        return u.getErrorString(i2);
    }

    public static Context getRemoteContext(Context context) {
        return u.getRemoteContext(context);
    }

    public static Resources getRemoteResource(Context context) {
        return u.getRemoteResource(context);
    }

    @Deprecated
    public static int isGooglePlayServicesAvailable(Context context) {
        return u.isGooglePlayServicesAvailable(context);
    }

    @Deprecated
    public static boolean isUserRecoverableError(int i2) {
        return u.isUserRecoverableError(i2);
    }

    @Deprecated
    public static boolean showErrorDialogFragment(int i2, Activity activity, int i3) {
        return showErrorDialogFragment(i2, activity, i3, null);
    }

    @Deprecated
    public static boolean showErrorDialogFragment(int i2, Activity activity, int i3, DialogInterface.OnCancelListener onCancelListener) {
        return showErrorDialogFragment(i2, activity, null, i3, onCancelListener);
    }

    public static boolean showErrorDialogFragment(int i2, Activity activity, Fragment fragment, int i3, DialogInterface.OnCancelListener onCancelListener) {
        if (u.zzd(activity, i2)) {
            i2 = 18;
        }
        c c2 = c.c();
        if (fragment == null) {
            return c2.b(activity, i2, i3, onCancelListener);
        }
        c.c();
        Dialog a2 = c.a(activity, i2, y0.a(fragment, m.a(activity, i2, "d"), i3), onCancelListener);
        if (a2 == null) {
            return false;
        }
        c.a(activity, a2, GMS_ERROR_DIALOG, onCancelListener);
        return true;
    }

    @Deprecated
    public static void showErrorNotification(int i2, Context context) {
        c c2 = c.c();
        if (!u.zzd(context, i2)) {
            if (!(i2 == 9 ? u.zzr(context, "com.android.vending") : false)) {
                c2.c(context, i2);
                return;
            }
        }
        c2.c(context);
    }
}
