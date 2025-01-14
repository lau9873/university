package c.d.a.a.g.a;

import android.content.SharedPreferences;
import android.util.Log;
import c.d.a.a.h.n;
/* loaded from: classes.dex */
public final class d extends a<Integer> {
    public static Integer a(SharedPreferences sharedPreferences, String str, Integer num) {
        try {
            return (Integer) n.a(new e(sharedPreferences, str, num));
        } catch (Exception e2) {
            String valueOf = String.valueOf(e2.getMessage());
            Log.w("FlagDataUtils", valueOf.length() != 0 ? "Flag value not available, returning default: ".concat(valueOf) : new String("Flag value not available, returning default: "));
            return num;
        }
    }
}
