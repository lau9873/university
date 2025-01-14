package p070c.p084d.p085a.p086a.p100g.p101a;

import android.content.SharedPreferences;
import android.util.Log;
import p070c.p084d.p085a.p086a.p102h.C1173n;

/* renamed from: c.d.a.a.g.a.b */
/* loaded from: classes.dex */
public final class C1124b extends C1123a<Boolean> {
    /* renamed from: a */
    public static Boolean m5100a(SharedPreferences sharedPreferences, String str, Boolean bool) {
        try {
            return (Boolean) C1173n.m5031a(new CallableC1125c(sharedPreferences, str, bool));
        } catch (Exception e) {
            String valueOf = String.valueOf(e.getMessage());
            Log.w("FlagDataUtils", valueOf.length() != 0 ? "Flag value not available, returning default: ".concat(valueOf) : new String("Flag value not available, returning default: "));
            return bool;
        }
    }
}
