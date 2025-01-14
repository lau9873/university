package p070c.p084d.p085a.p086a.p100g.p101a;

import android.content.SharedPreferences;
import android.util.Log;
import p070c.p084d.p085a.p086a.p102h.C1173n;

/* renamed from: c.d.a.a.g.a.d */
/* loaded from: classes.dex */
public final class C1126d extends C1123a<Integer> {
    /* renamed from: a */
    public static Integer m5099a(SharedPreferences sharedPreferences, String str, Integer num) {
        try {
            return (Integer) C1173n.m5031a(new CallableC1127e(sharedPreferences, str, num));
        } catch (Exception e) {
            String valueOf = String.valueOf(e.getMessage());
            Log.w("FlagDataUtils", valueOf.length() != 0 ? "Flag value not available, returning default: ".concat(valueOf) : new String("Flag value not available, returning default: "));
            return num;
        }
    }
}
