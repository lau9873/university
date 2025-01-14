package a.b.h.k;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Build;
import java.lang.ref.WeakReference;
/* compiled from: VectorEnabledTintResources.java */
/* loaded from: classes.dex */
public class q1 extends Resources {

    /* renamed from: b  reason: collision with root package name */
    public static boolean f1916b = false;

    /* renamed from: a  reason: collision with root package name */
    public final WeakReference<Context> f1917a;

    public q1(Context context, Resources resources) {
        super(resources.getAssets(), resources.getDisplayMetrics(), resources.getConfiguration());
        this.f1917a = new WeakReference<>(context);
    }

    public static boolean b() {
        return a() && Build.VERSION.SDK_INT <= 20;
    }

    public final Drawable a(int i2) {
        return super.getDrawable(i2);
    }

    @Override // android.content.res.Resources
    public Drawable getDrawable(int i2) {
        Context context = this.f1917a.get();
        if (context != null) {
            return k.a().a(context, this, i2);
        }
        return super.getDrawable(i2);
    }

    public static boolean a() {
        return f1916b;
    }
}
