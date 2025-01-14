package c.d.a.a.g.a;

import android.content.SharedPreferences;
import android.util.Log;
import c.d.a.a.h.n;
/* loaded from: classes.dex */
public final class h extends a<String> {
    public static String a(SharedPreferences sharedPreferences, String str, String str2) {
        try {
            return (String) n.a(new i(sharedPreferences, str, str2));
        } catch (Exception e2) {
            String valueOf = String.valueOf(e2.getMessage());
            Log.w("FlagDataUtils", valueOf.length() != 0 ? "Flag value not available, returning default: ".concat(valueOf) : new String("Flag value not available, returning default: "));
            return str2;
        }
    }
}
