package p070c.p084d.p085a.p086a.p093e.p096f;

import android.content.Context;
import android.content.ServiceConnection;

/* renamed from: c.d.a.a.e.f.h */
/* loaded from: classes.dex */
public abstract class AbstractC1059h {

    /* renamed from: a */
    public static final Object f5410a = new Object();

    /* renamed from: b */
    public static AbstractC1059h f5411b;

    /* renamed from: a */
    public static AbstractC1059h m5270a(Context context) {
        synchronized (f5410a) {
            if (f5411b == null) {
                f5411b = new C1063j(context.getApplicationContext());
            }
        }
        return f5411b;
    }

    /* renamed from: a */
    public final void m5269a(String str, String str2, int i, ServiceConnection serviceConnection, String str3) {
        mo5217b(new C1061i(str, str2, i), serviceConnection, str3);
    }

    /* renamed from: a */
    public abstract boolean mo5219a(C1061i c1061i, ServiceConnection serviceConnection, String str);

    /* renamed from: b */
    public abstract void mo5217b(C1061i c1061i, ServiceConnection serviceConnection, String str);
}
