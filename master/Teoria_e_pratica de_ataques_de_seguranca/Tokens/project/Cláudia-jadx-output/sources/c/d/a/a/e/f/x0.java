package c.d.a.a.e.f;

import android.content.Context;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.text.TextUtils;
import android.util.Log;
import com.google.android.gms.common.GooglePlayServicesUtil;
/* loaded from: classes.dex */
public final class x0 {

    /* renamed from: a  reason: collision with root package name */
    public static final a.b.g.j.n<String, String> f3553a = new a.b.g.j.n<>();

    public static String a(Context context) {
        String packageName = context.getPackageName();
        try {
            return c.d.a.a.h.j.b(context).a(packageName).toString();
        } catch (PackageManager.NameNotFoundException | NullPointerException unused) {
            String str = context.getApplicationInfo().name;
            return TextUtils.isEmpty(str) ? packageName : str;
        }
    }

    public static String a(Context context, int i2) {
        String str;
        Resources resources = context.getResources();
        switch (i2) {
            case 1:
                return resources.getString(c.d.a.a.b.common_google_play_services_install_title);
            case 2:
                return resources.getString(c.d.a.a.b.common_google_play_services_update_title);
            case 3:
                return resources.getString(c.d.a.a.b.common_google_play_services_enable_title);
            case 4:
            case 6:
            case 18:
                return null;
            case 5:
                Log.e("GoogleApiAvailability", "An invalid account was specified when connecting. Please provide a valid account.");
                return a(context, "common_google_play_services_invalid_account_title");
            case 7:
                Log.e("GoogleApiAvailability", "Network error occurred. Please retry request later.");
                return a(context, "common_google_play_services_network_error_title");
            case 8:
                str = "Internal error occurred. Please see logs for detailed information";
                break;
            case 9:
                str = "Google Play services is invalid. Cannot recover.";
                break;
            case 10:
                str = "Developer error occurred. Please see logs for detailed information";
                break;
            case 11:
                str = "The application is not licensed to the user.";
                break;
            case 12:
            case 13:
            case 14:
            case 15:
            case 19:
            default:
                StringBuilder sb = new StringBuilder(33);
                sb.append("Unexpected error code ");
                sb.append(i2);
                str = sb.toString();
                break;
            case 16:
                str = "One of the API components you attempted to connect to is not available.";
                break;
            case 17:
                Log.e("GoogleApiAvailability", "The specified account could not be signed in.");
                return a(context, "common_google_play_services_sign_in_failed_title");
            case 20:
                Log.e("GoogleApiAvailability", "The current user profile is restricted and could not use authenticated features.");
                return a(context, "common_google_play_services_restricted_profile_title");
        }
        Log.e("GoogleApiAvailability", str);
        return null;
    }

    public static String a(Context context, String str) {
        synchronized (f3553a) {
            String str2 = f3553a.get(str);
            if (str2 != null) {
                return str2;
            }
            Resources remoteResource = GooglePlayServicesUtil.getRemoteResource(context);
            if (remoteResource == null) {
                return null;
            }
            int identifier = remoteResource.getIdentifier(str, "string", "com.google.android.gms");
            if (identifier == 0) {
                String valueOf = String.valueOf(str);
                Log.w("GoogleApiAvailability", valueOf.length() != 0 ? "Missing resource: ".concat(valueOf) : new String("Missing resource: "));
                return null;
            }
            String string = remoteResource.getString(identifier);
            if (!TextUtils.isEmpty(string)) {
                f3553a.put(str, string);
                return string;
            }
            String valueOf2 = String.valueOf(str);
            Log.w("GoogleApiAvailability", valueOf2.length() != 0 ? "Got empty resource: ".concat(valueOf2) : new String("Got empty resource: "));
            return null;
        }
    }

    public static String a(Context context, String str, String str2) {
        Resources resources = context.getResources();
        String a2 = a(context, str);
        if (a2 == null) {
            a2 = resources.getString(c.d.a.a.b.common_google_play_services_unknown_issue);
        }
        return String.format(resources.getConfiguration().locale, a2, str2);
    }

    public static String b(Context context) {
        return context.getResources().getString(c.d.a.a.b.common_google_play_services_notification_channel_name);
    }

    public static String b(Context context, int i2) {
        String a2 = i2 == 6 ? a(context, "common_google_play_services_resolution_required_title") : a(context, i2);
        return a2 == null ? context.getResources().getString(c.d.a.a.b.common_google_play_services_notification_ticker) : a2;
    }

    public static String c(Context context, int i2) {
        Resources resources = context.getResources();
        String a2 = a(context);
        if (i2 != 1) {
            if (i2 == 2) {
                return c.d.a.a.e.h.d.b(context) ? resources.getString(c.d.a.a.b.common_google_play_services_wear_update_text) : resources.getString(c.d.a.a.b.common_google_play_services_update_text, a2);
            } else if (i2 != 3) {
                if (i2 != 5) {
                    if (i2 != 7) {
                        if (i2 != 9) {
                            if (i2 != 20) {
                                switch (i2) {
                                    case 16:
                                        return a(context, "common_google_play_services_api_unavailable_text", a2);
                                    case 17:
                                        return a(context, "common_google_play_services_sign_in_failed_text", a2);
                                    case 18:
                                        return resources.getString(c.d.a.a.b.common_google_play_services_updating_text, a2);
                                    default:
                                        return resources.getString(c.d.a.a.b.common_google_play_services_unknown_issue, a2);
                                }
                            }
                            return a(context, "common_google_play_services_restricted_profile_text", a2);
                        }
                        return resources.getString(c.d.a.a.b.common_google_play_services_unsupported_text, a2);
                    }
                    return a(context, "common_google_play_services_network_error_text", a2);
                }
                return a(context, "common_google_play_services_invalid_account_text", a2);
            } else {
                return resources.getString(c.d.a.a.b.common_google_play_services_enable_text, a2);
            }
        }
        return resources.getString(c.d.a.a.b.common_google_play_services_install_text, a2);
    }

    public static String d(Context context, int i2) {
        return i2 == 6 ? a(context, "common_google_play_services_resolution_required_text", a(context)) : c(context, i2);
    }

    public static String e(Context context, int i2) {
        return context.getResources().getString(i2 != 1 ? i2 != 2 ? i2 != 3 ? 17039370 : c.d.a.a.b.common_google_play_services_enable_button : c.d.a.a.b.common_google_play_services_update_button : c.d.a.a.b.common_google_play_services_install_button);
    }
}
