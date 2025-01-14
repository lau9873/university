package p070c.p084d.p085a.p086a.p093e.p097g;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.util.Log;
import java.util.Collections;
import java.util.List;
import p070c.p084d.p085a.p086a.p093e.p098h.C1098a;

/* renamed from: c.d.a.a.e.g.a */
/* loaded from: classes.dex */
public final class C1097a {

    /* renamed from: a */
    public static final Object f5493a = new Object();

    /* renamed from: b */
    public static volatile C1097a f5494b;

    public C1097a() {
        List list = Collections.EMPTY_LIST;
    }

    /* renamed from: a */
    public static C1097a m5147a() {
        if (f5494b == null) {
            synchronized (f5493a) {
                if (f5494b == null) {
                    f5494b = new C1097a();
                }
            }
        }
        return f5494b;
    }

    /* renamed from: a */
    public final boolean m5146a(Context context, Intent intent, ServiceConnection serviceConnection, int i) {
        return m5145a(context, context.getClass().getName(), intent, serviceConnection, i);
    }

    /* renamed from: a */
    public final boolean m5145a(Context context, String str, Intent intent, ServiceConnection serviceConnection, int i) {
        ComponentName component = intent.getComponent();
        if (component == null ? false : C1098a.m5144a(context, component.getPackageName())) {
            Log.w("ConnectionTracker", "Attempted to bind to a service in a STOPPED package.");
            return false;
        }
        return context.bindService(intent, serviceConnection, i);
    }
}
