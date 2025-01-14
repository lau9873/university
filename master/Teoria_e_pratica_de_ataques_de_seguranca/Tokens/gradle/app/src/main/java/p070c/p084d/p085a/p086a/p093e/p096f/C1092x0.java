package p070c.p084d.p085a.p086a.p093e.p096f;

import android.content.Context;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.text.TextUtils;
import android.util.Log;
import com.google.android.gms.common.GooglePlayServicesUtil;
import p000a.p006b.p030g.p044j.SimpleArrayMap;
import p070c.p084d.p085a.p086a.C0894b;
import p070c.p084d.p085a.p086a.p093e.p098h.C1101d;
import p070c.p084d.p085a.p086a.p102h.C1161j;

/* renamed from: c.d.a.a.e.f.x0 */
/* loaded from: classes.dex */
public final class C1092x0 {

    /* renamed from: a */
    public static final SimpleArrayMap<String, String> f5486a = new SimpleArrayMap<>();

    /* renamed from: a */
    public static String m5164a(Context context) {
        String packageName = context.getPackageName();
        try {
            return C1161j.m5037b(context).m5041a(packageName).toString();
        } catch (PackageManager.NameNotFoundException | NullPointerException unused) {
            String str = context.getApplicationInfo().name;
            return TextUtils.isEmpty(str) ? packageName : str;
        }
    }

    /* renamed from: a */
    public static String m5163a(Context context, int i) {
        String str;
        Resources resources = context.getResources();
        switch (i) {
            case 1:
                return resources.getString(C0894b.common_google_play_services_install_title);
            case 2:
                return resources.getString(C0894b.common_google_play_services_update_title);
            case 3:
                return resources.getString(C0894b.common_google_play_services_enable_title);
            case 4:
            case 6:
            case 18:
                return null;
            case 5:
                Log.e("GoogleApiAvailability", "An invalid account was specified when connecting. Please provide a valid account.");
                return m5162a(context, "common_google_play_services_invalid_account_title");
            case 7:
                Log.e("GoogleApiAvailability", "Network error occurred. Please retry request later.");
                return m5162a(context, "common_google_play_services_network_error_title");
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
                sb.append(i);
                str = sb.toString();
                break;
            case 16:
                str = "One of the API components you attempted to connect to is not available.";
                break;
            case 17:
                Log.e("GoogleApiAvailability", "The specified account could not be signed in.");
                return m5162a(context, "common_google_play_services_sign_in_failed_title");
            case 20:
                Log.e("GoogleApiAvailability", "The current user profile is restricted and could not use authenticated features.");
                return m5162a(context, "common_google_play_services_restricted_profile_title");
        }
        Log.e("GoogleApiAvailability", str);
        return null;
    }

    /* renamed from: a */
    public static String m5162a(Context context, String str) {
        synchronized (f5486a) {
            String str2 = f5486a.get(str);
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
                f5486a.put(str, string);
                return string;
            }
            String valueOf2 = String.valueOf(str);
            Log.w("GoogleApiAvailability", valueOf2.length() != 0 ? "Got empty resource: ".concat(valueOf2) : new String("Got empty resource: "));
            return null;
        }
    }

    /* renamed from: a */
    public static String m5161a(Context context, String str, String str2) {
        Resources resources = context.getResources();
        String m5162a = m5162a(context, str);
        if (m5162a == null) {
            m5162a = resources.getString(C0894b.common_google_play_services_unknown_issue);
        }
        return String.format(resources.getConfiguration().locale, m5162a, str2);
    }

    /* renamed from: b */
    public static String m5160b(Context context) {
        return context.getResources().getString(C0894b.common_google_play_services_notification_channel_name);
    }

    /* renamed from: b */
    public static String m5159b(Context context, int i) {
        String m5162a = i == 6 ? m5162a(context, "common_google_play_services_resolution_required_title") : m5163a(context, i);
        return m5162a == null ? context.getResources().getString(C0894b.common_google_play_services_notification_ticker) : m5162a;
    }

    /* renamed from: c */
    public static String m5158c(Context context, int i) {
        Resources resources = context.getResources();
        String m5164a = m5164a(context);
        if (i != 1) {
            if (i == 2) {
                return C1101d.m5140b(context) ? resources.getString(C0894b.common_google_play_services_wear_update_text) : resources.getString(C0894b.common_google_play_services_update_text, m5164a);
            } else if (i != 3) {
                if (i != 5) {
                    if (i != 7) {
                        if (i != 9) {
                            if (i != 20) {
                                switch (i) {
                                    case 16:
                                        return m5161a(context, "common_google_play_services_api_unavailable_text", m5164a);
                                    case 17:
                                        return m5161a(context, "common_google_play_services_sign_in_failed_text", m5164a);
                                    case 18:
                                        return resources.getString(C0894b.common_google_play_services_updating_text, m5164a);
                                    default:
                                        return resources.getString(C0894b.common_google_play_services_unknown_issue, m5164a);
                                }
                            }
                            return m5161a(context, "common_google_play_services_restricted_profile_text", m5164a);
                        }
                        return resources.getString(C0894b.common_google_play_services_unsupported_text, m5164a);
                    }
                    return m5161a(context, "common_google_play_services_network_error_text", m5164a);
                }
                return m5161a(context, "common_google_play_services_invalid_account_text", m5164a);
            } else {
                return resources.getString(C0894b.common_google_play_services_enable_text, m5164a);
            }
        }
        return resources.getString(C0894b.common_google_play_services_install_text, m5164a);
    }

    /* renamed from: d */
    public static String m5157d(Context context, int i) {
        return i == 6 ? m5161a(context, "common_google_play_services_resolution_required_text", m5164a(context)) : m5158c(context, i);
    }

    /* renamed from: e */
    public static String m5156e(Context context, int i) {
        return context.getResources().getString(i != 1 ? i != 2 ? i != 3 ? 17039370 : C0894b.common_google_play_services_enable_button : C0894b.common_google_play_services_update_button : C0894b.common_google_play_services_install_button);
    }
}
