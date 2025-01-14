package p070c.p084d.p085a.p086a.p100g.p101a;

import android.content.Context;
import android.content.SharedPreferences;
import p070c.p084d.p085a.p086a.p102h.C1173n;

/* renamed from: c.d.a.a.g.a.j */
/* loaded from: classes.dex */
public final class C1132j {

    /* renamed from: a */
    public static SharedPreferences f5526a;

    /* renamed from: a */
    public static SharedPreferences m5096a(Context context) {
        SharedPreferences sharedPreferences;
        synchronized (SharedPreferences.class) {
            if (f5526a == null) {
                f5526a = (SharedPreferences) C1173n.m5031a(new CallableC1133k(context));
            }
            sharedPreferences = f5526a;
        }
        return sharedPreferences;
    }
}
