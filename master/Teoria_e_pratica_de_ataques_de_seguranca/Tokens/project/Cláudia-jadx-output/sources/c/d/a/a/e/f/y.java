package c.d.a.a.e.f;

import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.util.Log;
/* loaded from: classes.dex */
public final class y {

    /* renamed from: a  reason: collision with root package name */
    public static Object f3554a = new Object();

    /* renamed from: b  reason: collision with root package name */
    public static boolean f3555b;

    /* renamed from: c  reason: collision with root package name */
    public static int f3556c;

    public static int a(Context context) {
        b(context);
        return f3556c;
    }

    public static void b(Context context) {
        Bundle bundle;
        synchronized (f3554a) {
            if (f3555b) {
                return;
            }
            f3555b = true;
            try {
                bundle = c.d.a.a.h.j.b(context).a(context.getPackageName(), 128).metaData;
            } catch (PackageManager.NameNotFoundException e2) {
                Log.wtf("MetadataValueReader", "This should never happen.", e2);
            }
            if (bundle == null) {
                return;
            }
            bundle.getString("com.google.app.id");
            f3556c = bundle.getInt("com.google.android.gms.version");
        }
    }
}
