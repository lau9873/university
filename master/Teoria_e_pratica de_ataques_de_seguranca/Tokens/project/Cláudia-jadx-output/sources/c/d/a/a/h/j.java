package c.d.a.a.h;

import android.content.Context;
/* loaded from: classes.dex */
public final class j {

    /* renamed from: b  reason: collision with root package name */
    public static j f3614b = new j();

    /* renamed from: a  reason: collision with root package name */
    public i f3615a = null;

    public static i b(Context context) {
        return f3614b.a(context);
    }

    public final synchronized i a(Context context) {
        if (this.f3615a == null) {
            if (context.getApplicationContext() != null) {
                context = context.getApplicationContext();
            }
            this.f3615a = new i(context);
        }
        return this.f3615a;
    }
}
