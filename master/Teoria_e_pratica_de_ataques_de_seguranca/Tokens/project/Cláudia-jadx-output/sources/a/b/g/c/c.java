package a.b.g.c;

import a.b.g.b.g.c;
import a.b.g.b.g.f;
import a.b.g.h.b;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.os.Build;
import android.os.CancellationSignal;
import android.os.Handler;
/* compiled from: TypefaceCompat.java */
/* loaded from: classes.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    public static final h f907a;

    /* renamed from: b  reason: collision with root package name */
    public static final a.b.g.j.g<String, Typeface> f908b;

    static {
        int i2 = Build.VERSION.SDK_INT;
        if (i2 >= 28) {
            f907a = new g();
        } else if (i2 >= 26) {
            f907a = new f();
        } else if (i2 >= 24 && e.a()) {
            f907a = new e();
        } else if (Build.VERSION.SDK_INT >= 21) {
            f907a = new d();
        } else {
            f907a = new h();
        }
        f908b = new a.b.g.j.g<>(16);
    }

    public static String a(Resources resources, int i2, int i3) {
        return resources.getResourcePackageName(i2) + "-" + i2 + "-" + i3;
    }

    public static Typeface b(Resources resources, int i2, int i3) {
        return f908b.b(a(resources, i2, i3));
    }

    public static Typeface a(Context context, c.a aVar, Resources resources, int i2, int i3, f.a aVar2, Handler handler, boolean z) {
        Typeface a2;
        if (aVar instanceof c.d) {
            c.d dVar = (c.d) aVar;
            boolean z2 = false;
            if (!z ? aVar2 == null : dVar.a() == 0) {
                z2 = true;
            }
            a2 = a.b.g.h.b.a(context, dVar.b(), aVar2, handler, z2, z ? dVar.c() : -1, i3);
        } else {
            a2 = f907a.a(context, (c.b) aVar, resources, i3);
            if (aVar2 != null) {
                if (a2 != null) {
                    aVar2.a(a2, handler);
                } else {
                    aVar2.a(-3, handler);
                }
            }
        }
        if (a2 != null) {
            f908b.a(a(resources, i2, i3), a2);
        }
        return a2;
    }

    public static Typeface a(Context context, Resources resources, int i2, String str, int i3) {
        Typeface a2 = f907a.a(context, resources, i2, str, i3);
        if (a2 != null) {
            f908b.a(a(resources, i2, i3), a2);
        }
        return a2;
    }

    public static Typeface a(Context context, CancellationSignal cancellationSignal, b.f[] fVarArr, int i2) {
        return f907a.a(context, cancellationSignal, fVarArr, i2);
    }
}
