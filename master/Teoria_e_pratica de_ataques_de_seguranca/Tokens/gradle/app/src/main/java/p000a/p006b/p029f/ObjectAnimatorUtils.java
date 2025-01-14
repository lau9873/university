package p000a.p006b.p029f;

import android.animation.ObjectAnimator;
import android.animation.TypeConverter;
import android.graphics.Path;
import android.graphics.PointF;
import android.os.Build;
import android.util.Property;

/* renamed from: a.b.f.f */
/* loaded from: classes.dex */
public class ObjectAnimatorUtils {
    /* renamed from: a */
    public static <T> ObjectAnimator m10527a(T t, Property<T, PointF> property, Path path) {
        if (Build.VERSION.SDK_INT >= 21) {
            return ObjectAnimator.ofObject(t, property, (TypeConverter) null, path);
        }
        return ObjectAnimator.ofFloat(t, new PathProperty(property, path), 0.0f, 1.0f);
    }
}
