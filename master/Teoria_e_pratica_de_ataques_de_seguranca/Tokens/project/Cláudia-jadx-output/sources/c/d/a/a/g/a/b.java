package c.d.a.a.g.a;

import android.content.SharedPreferences;
import android.util.Log;
import c.d.a.a.h.n;
/* loaded from: classes.dex */
public final class b extends a<Boolean> {
    public static Boolean a(SharedPreferences sharedPreferences, String str, Boolean bool) {
        try {
            return (Boolean) n.a(new c(sharedPreferences, str, bool));
        } catch (Exception e2) {
            String valueOf = String.valueOf(e2.getMessage());
            Log.w("FlagDataUtils", valueOf.length() != 0 ? "Flag value not available, returning default: ".concat(valueOf) : new String("Flag value not available, returning default: "));
            return bool;
        }
    }
}
