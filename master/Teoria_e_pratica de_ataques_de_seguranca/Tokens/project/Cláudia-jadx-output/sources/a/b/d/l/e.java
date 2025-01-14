package a.b.d.l;

import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.Property;
import java.util.WeakHashMap;
/* compiled from: DrawableAlphaProperty.java */
/* loaded from: classes.dex */
public class e extends Property<Drawable, Integer> {

    /* renamed from: b  reason: collision with root package name */
    public static final Property<Drawable, Integer> f217b = new e();

    /* renamed from: a  reason: collision with root package name */
    public final WeakHashMap<Drawable, Integer> f218a;

    public e() {
        super(Integer.class, "drawableAlphaCompat");
        this.f218a = new WeakHashMap<>();
    }

    @Override // android.util.Property
    /* renamed from: a */
    public Integer get(Drawable drawable) {
        if (Build.VERSION.SDK_INT >= 19) {
            return Integer.valueOf(drawable.getAlpha());
        }
        if (this.f218a.containsKey(drawable)) {
            return this.f218a.get(drawable);
        }
        return 255;
    }

    @Override // android.util.Property
    /* renamed from: a */
    public void set(Drawable drawable, Integer num) {
        if (Build.VERSION.SDK_INT < 19) {
            this.f218a.put(drawable, num);
        }
        drawable.setAlpha(num.intValue());
    }
}
