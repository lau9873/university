package p070c.p084d.p085a.p086a.p087c.p088a;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;
import p070c.p084d.p085a.p086a.p093e.C1117u;

/* renamed from: c.d.a.a.c.a.b */
/* loaded from: classes.dex */
public final class C0896b {

    /* renamed from: a */
    public SharedPreferences f5045a;

    public C0896b(Context context) {
        try {
            Context remoteContext = C1117u.getRemoteContext(context);
            this.f5045a = remoteContext == null ? null : remoteContext.getSharedPreferences("google_ads_flags", 0);
        } catch (Throwable th) {
            Log.w("GmscoreFlag", "Error while getting SharedPreferences ", th);
            this.f5045a = null;
        }
    }

    /* renamed from: a */
    public final float m5654a(String str, float f) {
        try {
            if (this.f5045a == null) {
                return 0.0f;
            }
            return this.f5045a.getFloat(str, 0.0f);
        } catch (Throwable th) {
            Log.w("GmscoreFlag", "Error while reading from SharedPreferences ", th);
            return 0.0f;
        }
    }

    /* renamed from: a */
    public final String m5653a(String str, String str2) {
        try {
            return this.f5045a == null ? str2 : this.f5045a.getString(str, str2);
        } catch (Throwable th) {
            Log.w("GmscoreFlag", "Error while reading from SharedPreferences ", th);
            return str2;
        }
    }

    /* renamed from: a */
    public final boolean m5652a(String str, boolean z) {
        try {
            if (this.f5045a == null) {
                return false;
            }
            return this.f5045a.getBoolean(str, false);
        } catch (Throwable th) {
            Log.w("GmscoreFlag", "Error while reading from SharedPreferences ", th);
            return false;
        }
    }
}
