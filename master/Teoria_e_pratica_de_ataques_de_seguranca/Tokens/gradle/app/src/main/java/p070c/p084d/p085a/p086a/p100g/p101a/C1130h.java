package p070c.p084d.p085a.p086a.p100g.p101a;

import android.content.SharedPreferences;
import android.util.Log;
import p070c.p084d.p085a.p086a.p102h.C1173n;

/* renamed from: c.d.a.a.g.a.h */
/* loaded from: classes.dex */
public final class C1130h extends C1123a<String> {
    /* renamed from: a */
    public static String m5097a(SharedPreferences sharedPreferences, String str, String str2) {
        try {
            return (String) C1173n.m5031a(new CallableC1131i(sharedPreferences, str, str2));
        } catch (Exception e) {
            String valueOf = String.valueOf(e.getMessage());
            Log.w("FlagDataUtils", valueOf.length() != 0 ? "Flag value not available, returning default: ".concat(valueOf) : new String("Flag value not available, returning default: "));
            return str2;
        }
    }
}
