package com.google.android.gms.common;

import android.app.Activity;
import android.app.Dialog;
import android.app.PendingIntent;
import android.content.Context;
import android.content.DialogInterface;
import android.content.res.Resources;
import android.support.p065v4.app.Fragment;
import p070c.p084d.p085a.p086a.p093e.C0902c;
import p070c.p084d.p085a.p086a.p093e.C1109m;
import p070c.p084d.p085a.p086a.p093e.C1117u;
import p070c.p084d.p085a.p086a.p093e.p096f.AbstractDialogInterface$OnClickListenerC1094y0;

/* loaded from: classes.dex */
public final class GooglePlayServicesUtil extends C1117u {
    public static final String GMS_ERROR_DIALOG = "GooglePlayServicesErrorDialog";
    @Deprecated
    public static final String GOOGLE_PLAY_SERVICES_PACKAGE = "com.google.android.gms";
    @Deprecated
    public static final int GOOGLE_PLAY_SERVICES_VERSION_CODE = C1117u.GOOGLE_PLAY_SERVICES_VERSION_CODE;
    public static final String GOOGLE_PLAY_STORE_PACKAGE = "com.android.vending";

    @Deprecated
    public static Dialog getErrorDialog(int i, Activity activity, int i2) {
        return getErrorDialog(i, activity, i2, null);
    }

    @Deprecated
    public static Dialog getErrorDialog(int i, Activity activity, int i2, DialogInterface.OnCancelListener onCancelListener) {
        if (C1117u.zzd(activity, i)) {
            i = 18;
        }
        return C0902c.m5627c().m5639a(activity, i, i2, onCancelListener);
    }

    @Deprecated
    public static PendingIntent getErrorPendingIntent(int i, Context context, int i2) {
        return C1117u.getErrorPendingIntent(i, context, i2);
    }

    @Deprecated
    public static String getErrorString(int i) {
        return C1117u.getErrorString(i);
    }

    public static Context getRemoteContext(Context context) {
        return C1117u.getRemoteContext(context);
    }

    public static Resources getRemoteResource(Context context) {
        return C1117u.getRemoteResource(context);
    }

    @Deprecated
    public static int isGooglePlayServicesAvailable(Context context) {
        return C1117u.isGooglePlayServicesAvailable(context);
    }

    @Deprecated
    public static boolean isUserRecoverableError(int i) {
        return C1117u.isUserRecoverableError(i);
    }

    @Deprecated
    public static boolean showErrorDialogFragment(int i, Activity activity, int i2) {
        return showErrorDialogFragment(i, activity, i2, null);
    }

    @Deprecated
    public static boolean showErrorDialogFragment(int i, Activity activity, int i2, DialogInterface.OnCancelListener onCancelListener) {
        return showErrorDialogFragment(i, activity, null, i2, onCancelListener);
    }

    public static boolean showErrorDialogFragment(int i, Activity activity, Fragment fragment, int i2, DialogInterface.OnCancelListener onCancelListener) {
        if (C1117u.zzd(activity, i)) {
            i = 18;
        }
        C0902c m5627c = C0902c.m5627c();
        if (fragment == null) {
            return m5627c.m5628b(activity, i, i2, onCancelListener);
        }
        C0902c.m5627c();
        Dialog m5635a = C0902c.m5635a(activity, i, AbstractDialogInterface$OnClickListenerC1094y0.m5152a(fragment, C1109m.m5119a(activity, i, "d"), i2), onCancelListener);
        if (m5635a == null) {
            return false;
        }
        C0902c.m5638a(activity, m5635a, GMS_ERROR_DIALOG, onCancelListener);
        return true;
    }

    @Deprecated
    public static void showErrorNotification(int i, Context context) {
        C0902c m5627c = C0902c.m5627c();
        if (!C1117u.zzd(context, i)) {
            if (!(i == 9 ? C1117u.zzr(context, "com.android.vending") : false)) {
                m5627c.m5625c(context, i);
                return;
            }
        }
        m5627c.m5626c(context);
    }
}
