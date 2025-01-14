package p000a.p006b.p012d.p013l;

import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.Property;
import java.util.WeakHashMap;

/* renamed from: a.b.d.l.e */
/* loaded from: classes.dex */
public class DrawableAlphaProperty extends Property<Drawable, Integer> {

    /* renamed from: b */
    public static final Property<Drawable, Integer> f428b = new DrawableAlphaProperty();

    /* renamed from: a */
    public final WeakHashMap<Drawable, Integer> f429a;

    public DrawableAlphaProperty() {
        super(Integer.class, "drawableAlphaCompat");
        this.f429a = new WeakHashMap<>();
    }

    @Override // android.util.Property
    /* renamed from: a */
    public Integer get(Drawable drawable) {
        if (Build.VERSION.SDK_INT >= 19) {
            return Integer.valueOf(drawable.getAlpha());
        }
        if (this.f429a.containsKey(drawable)) {
            return this.f429a.get(drawable);
        }
        return 255;
    }

    @Override // android.util.Property
    /* renamed from: a */
    public void set(Drawable drawable, Integer num) {
        if (Build.VERSION.SDK_INT < 19) {
            this.f429a.put(drawable, num);
        }
        drawable.setAlpha(num.intValue());
    }
}
