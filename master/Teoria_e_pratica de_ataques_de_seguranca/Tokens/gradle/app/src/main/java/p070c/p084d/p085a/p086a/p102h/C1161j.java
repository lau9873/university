package p070c.p084d.p085a.p086a.p102h;

import android.content.Context;

/* renamed from: c.d.a.a.h.j */
/* loaded from: classes.dex */
public final class C1161j {

    /* renamed from: b */
    public static C1161j f5551b = new C1161j();

    /* renamed from: a */
    public C1158i f5552a = null;

    /* renamed from: b */
    public static C1158i m5037b(Context context) {
        return f5551b.m5038a(context);
    }

    /* renamed from: a */
    public final synchronized C1158i m5038a(Context context) {
        if (this.f5552a == null) {
            if (context.getApplicationContext() != null) {
                context = context.getApplicationContext();
            }
            this.f5552a = new C1158i(context);
        }
        return this.f5552a;
    }
}
