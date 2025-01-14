package c.d.a.a.c.a;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;
import c.d.a.a.e.u;
/* loaded from: classes.dex */
public final class b {

    /* renamed from: a  reason: collision with root package name */
    public SharedPreferences f3207a;

    public b(Context context) {
        try {
            Context remoteContext = u.getRemoteContext(context);
            this.f3207a = remoteContext == null ? null : remoteContext.getSharedPreferences("google_ads_flags", 0);
        } catch (Throwable th) {
            Log.w("GmscoreFlag", "Error while getting SharedPreferences ", th);
            this.f3207a = null;
        }
    }

    public final float a(String str, float f2) {
        try {
            if (this.f3207a == null) {
                return 0.0f;
            }
            return this.f3207a.getFloat(str, 0.0f);
        } catch (Throwable th) {
            Log.w("GmscoreFlag", "Error while reading from SharedPreferences ", th);
            return 0.0f;
        }
    }

    public final String a(String str, String str2) {
        try {
            return this.f3207a == null ? str2 : this.f3207a.getString(str, str2);
        } catch (Throwable th) {
            Log.w("GmscoreFlag", "Error while reading from SharedPreferences ", th);
            return str2;
        }
    }

    public final boolean a(String str, boolean z) {
        try {
            if (this.f3207a == null) {
                return false;
            }
            return this.f3207a.getBoolean(str, false);
        } catch (Throwable th) {
            Log.w("GmscoreFlag", "Error while reading from SharedPreferences ", th);
            return false;
        }
    }
}
