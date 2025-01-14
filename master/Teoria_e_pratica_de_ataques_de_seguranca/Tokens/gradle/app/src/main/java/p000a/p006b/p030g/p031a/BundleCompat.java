package p000a.p006b.p030g.p031a;

import android.os.Build;
import android.os.Bundle;
import android.os.IBinder;
import android.util.Log;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* renamed from: a.b.g.a.e */
/* loaded from: classes.dex */
public final class BundleCompat {

    /* compiled from: BundleCompat.java */
    /* renamed from: a.b.g.a.e$a */
    /* loaded from: classes.dex */
    public static class C0144a {

        /* renamed from: a */
        public static Method f1096a;

        /* renamed from: b */
        public static boolean f1097b;

        /* renamed from: a */
        public static IBinder m10351a(Bundle bundle, String str) {
            if (!f1097b) {
                try {
                    f1096a = Bundle.class.getMethod("getIBinder", String.class);
                    f1096a.setAccessible(true);
                } catch (NoSuchMethodException e) {
                    Log.i("BundleCompatBaseImpl", "Failed to retrieve getIBinder method", e);
                }
                f1097b = true;
            }
            Method method = f1096a;
            if (method != null) {
                try {
                    return (IBinder) method.invoke(bundle, str);
                } catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e2) {
                    Log.i("BundleCompatBaseImpl", "Failed to invoke getIBinder via reflection", e2);
                    f1096a = null;
                }
            }
            return null;
        }
    }

    /* renamed from: a */
    public static IBinder m10352a(Bundle bundle, String str) {
        if (Build.VERSION.SDK_INT >= 18) {
            return bundle.getBinder(str);
        }
        return C0144a.m10351a(bundle, str);
    }
}
