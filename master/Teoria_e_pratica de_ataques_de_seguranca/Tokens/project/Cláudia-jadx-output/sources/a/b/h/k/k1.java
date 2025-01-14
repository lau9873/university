package a.b.h.k;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import java.lang.ref.WeakReference;
/* compiled from: TintResources.java */
/* loaded from: classes.dex */
public class k1 extends y0 {

    /* renamed from: b  reason: collision with root package name */
    public final WeakReference<Context> f1807b;

    public k1(Context context, Resources resources) {
        super(resources);
        this.f1807b = new WeakReference<>(context);
    }

    @Override // a.b.h.k.y0, android.content.res.Resources
    public Drawable getDrawable(int i2) {
        Drawable drawable = super.getDrawable(i2);
        Context context = this.f1807b.get();
        if (drawable != null && context != null) {
            k.a();
            k.a(context, i2, drawable);
        }
        return drawable;
    }
}
