package c.d.a.a.e;

import android.content.Context;
import android.util.Log;
/* loaded from: classes.dex */
public final class n {

    /* renamed from: a  reason: collision with root package name */
    public static Context f3572a;

    public static synchronized void a(Context context) {
        synchronized (n.class) {
            if (f3572a != null) {
                Log.w("GoogleCertificates", "GoogleCertificates has been initialized already");
            } else if (context != null) {
                f3572a = context.getApplicationContext();
            }
        }
    }
}
