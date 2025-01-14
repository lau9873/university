package p000a.p006b.p049h.p063k;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import java.lang.ref.WeakReference;

/* renamed from: a.b.h.k.k1 */
/* loaded from: classes.dex */
public class TintResources extends ResourcesWrapper {

    /* renamed from: b */
    public final WeakReference<Context> f2734b;

    public TintResources(Context context, Resources resources) {
        super(resources);
        this.f2734b = new WeakReference<>(context);
    }

    @Override // p000a.p006b.p049h.p063k.ResourcesWrapper, android.content.res.Resources
    public Drawable getDrawable(int i) {
        Drawable drawable = super.getDrawable(i);
        Context context = this.f2734b.get();
        if (drawable != null && context != null) {
            AppCompatDrawableManager.m8318a();
            AppCompatDrawableManager.m8311a(context, i, drawable);
        }
        return drawable;
    }
}
