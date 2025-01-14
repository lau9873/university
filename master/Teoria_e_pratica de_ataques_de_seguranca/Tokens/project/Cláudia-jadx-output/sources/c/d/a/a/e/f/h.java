package c.d.a.a.e.f;

import android.content.Context;
import android.content.ServiceConnection;
/* loaded from: classes.dex */
public abstract class h {

    /* renamed from: a  reason: collision with root package name */
    public static final Object f3492a = new Object();

    /* renamed from: b  reason: collision with root package name */
    public static h f3493b;

    public static h a(Context context) {
        synchronized (f3492a) {
            if (f3493b == null) {
                f3493b = new j(context.getApplicationContext());
            }
        }
        return f3493b;
    }

    public final void a(String str, String str2, int i2, ServiceConnection serviceConnection, String str3) {
        b(new i(str, str2, i2), serviceConnection, str3);
    }

    public abstract boolean a(i iVar, ServiceConnection serviceConnection, String str);

    public abstract void b(i iVar, ServiceConnection serviceConnection, String str);
}
