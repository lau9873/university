package c.d.a.a.g.a;

import android.content.SharedPreferences;
import android.util.Log;
import c.d.a.a.h.n;
/* loaded from: classes.dex */
public final class f extends a<Long> {
    public static Long a(SharedPreferences sharedPreferences, String str, Long l) {
        try {
            return (Long) n.a(new g(sharedPreferences, str, l));
        } catch (Exception e2) {
            String valueOf = String.valueOf(e2.getMessage());
            Log.w("FlagDataUtils", valueOf.length() != 0 ? "Flag value not available, returning default: ".concat(valueOf) : new String("Flag value not available, returning default: "));
            return l;
        }
    }
}
