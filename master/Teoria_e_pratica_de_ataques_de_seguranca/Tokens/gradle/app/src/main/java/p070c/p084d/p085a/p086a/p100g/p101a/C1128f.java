package p070c.p084d.p085a.p086a.p100g.p101a;

import android.content.SharedPreferences;
import android.util.Log;
import p070c.p084d.p085a.p086a.p102h.C1173n;

/* renamed from: c.d.a.a.g.a.f */
/* loaded from: classes.dex */
public final class C1128f extends C1123a<Long> {
    /* renamed from: a */
    public static Long m5098a(SharedPreferences sharedPreferences, String str, Long l) {
        try {
            return (Long) C1173n.m5031a(new CallableC1129g(sharedPreferences, str, l));
        } catch (Exception e) {
            String valueOf = String.valueOf(e.getMessage());
            Log.w("FlagDataUtils", valueOf.length() != 0 ? "Flag value not available, returning default: ".concat(valueOf) : new String("Flag value not available, returning default: "));
            return l;
        }
    }
}
