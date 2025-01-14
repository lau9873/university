package p070c.p084d.p085a.p086a.p102h;

import android.os.StrictMode;
import java.util.concurrent.Callable;

/* renamed from: c.d.a.a.h.n */
/* loaded from: classes.dex */
public final class C1173n {
    /* renamed from: a */
    public static <T> T m5031a(Callable<T> callable) {
        StrictMode.ThreadPolicy threadPolicy = StrictMode.getThreadPolicy();
        try {
            StrictMode.setThreadPolicy(StrictMode.ThreadPolicy.LAX);
            return callable.call();
        } finally {
            StrictMode.setThreadPolicy(threadPolicy);
        }
    }
}
