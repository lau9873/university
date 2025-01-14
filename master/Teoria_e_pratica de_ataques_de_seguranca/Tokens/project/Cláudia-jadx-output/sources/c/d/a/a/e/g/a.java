package c.d.a.a.e.g;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.util.Log;
import java.util.Collections;
import java.util.List;
/* loaded from: classes.dex */
public final class a {

    /* renamed from: a  reason: collision with root package name */
    public static final Object f3560a = new Object();

    /* renamed from: b  reason: collision with root package name */
    public static volatile a f3561b;

    public a() {
        List list = Collections.EMPTY_LIST;
    }

    public static a a() {
        if (f3561b == null) {
            synchronized (f3560a) {
                if (f3561b == null) {
                    f3561b = new a();
                }
            }
        }
        return f3561b;
    }

    public final boolean a(Context context, Intent intent, ServiceConnection serviceConnection, int i2) {
        return a(context, context.getClass().getName(), intent, serviceConnection, i2);
    }

    public final boolean a(Context context, String str, Intent intent, ServiceConnection serviceConnection, int i2) {
        ComponentName component = intent.getComponent();
        if (component == null ? false : c.d.a.a.e.h.a.a(context, component.getPackageName())) {
            Log.w("ConnectionTracker", "Attempted to bind to a service in a STOPPED package.");
            return false;
        }
        return context.bindService(intent, serviceConnection, i2);
    }
}
