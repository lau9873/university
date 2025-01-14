package p070c.p084d.p085a.p086a.p093e;

import android.content.Context;
import android.util.Log;

/* renamed from: c.d.a.a.e.n */
/* loaded from: classes.dex */
public final class C1110n {

    /* renamed from: a */
    public static Context f5505a;

    /* renamed from: a */
    public static synchronized void m5113a(Context context) {
        synchronized (C1110n.class) {
            if (f5505a != null) {
                Log.w("GoogleCertificates", "GoogleCertificates has been initialized already");
            } else if (context != null) {
                f5505a = context.getApplicationContext();
            }
        }
    }
}
