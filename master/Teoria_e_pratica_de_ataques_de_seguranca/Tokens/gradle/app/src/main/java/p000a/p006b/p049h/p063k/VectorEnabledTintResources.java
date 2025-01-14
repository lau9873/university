package p000a.p006b.p049h.p063k;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Build;
import java.lang.ref.WeakReference;

/* renamed from: a.b.h.k.q1 */
/* loaded from: classes.dex */
public class VectorEnabledTintResources extends Resources {

    /* renamed from: b */
    public static boolean f2880b = false;

    /* renamed from: a */
    public final WeakReference<Context> f2881a;

    public VectorEnabledTintResources(Context context, Resources resources) {
        super(resources.getAssets(), resources.getDisplayMetrics(), resources.getConfiguration());
        this.f2881a = new WeakReference<>(context);
    }

    /* renamed from: b */
    public static boolean m8129b() {
        return m8131a() && Build.VERSION.SDK_INT <= 20;
    }

    /* renamed from: a */
    public final Drawable m8130a(int i) {
        return super.getDrawable(i);
    }

    @Override // android.content.res.Resources
    public Drawable getDrawable(int i) {
        Context context = this.f2881a.get();
        if (context != null) {
            return AppCompatDrawableManager.m8318a().m8306a(context, this, i);
        }
        return super.getDrawable(i);
    }

    /* renamed from: a */
    public static boolean m8131a() {
        return f2880b;
    }
}
