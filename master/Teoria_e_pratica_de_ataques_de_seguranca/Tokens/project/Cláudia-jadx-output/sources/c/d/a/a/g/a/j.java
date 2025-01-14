package c.d.a.a.g.a;

import android.content.Context;
import android.content.SharedPreferences;
import c.d.a.a.h.n;
/* loaded from: classes.dex */
public final class j {

    /* renamed from: a  reason: collision with root package name */
    public static SharedPreferences f3593a;

    public static SharedPreferences a(Context context) {
        SharedPreferences sharedPreferences;
        synchronized (SharedPreferences.class) {
            if (f3593a == null) {
                f3593a = (SharedPreferences) n.a(new k(context));
            }
            sharedPreferences = f3593a;
        }
        return sharedPreferences;
    }
}
