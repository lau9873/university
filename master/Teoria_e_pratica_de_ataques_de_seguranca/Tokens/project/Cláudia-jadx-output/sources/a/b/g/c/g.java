package a.b.g.c;

import android.graphics.Typeface;
import java.lang.reflect.Array;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
/* compiled from: TypefaceCompatApi28Impl.java */
/* loaded from: classes.dex */
public class g extends f {
    @Override // a.b.g.c.f
    public Typeface b(Object obj) {
        try {
            Object newInstance = Array.newInstance(this.f913a, 1);
            Array.set(newInstance, 0, obj);
            return (Typeface) this.f919g.invoke(null, newInstance, "sans-serif", -1, -1);
        } catch (IllegalAccessException | InvocationTargetException e2) {
            throw new RuntimeException(e2);
        }
    }

    @Override // a.b.g.c.f
    public Method d(Class cls) {
        Class cls2 = Integer.TYPE;
        Method declaredMethod = Typeface.class.getDeclaredMethod("createFromFamiliesWithDefault", Array.newInstance(cls, 1).getClass(), String.class, cls2, cls2);
        declaredMethod.setAccessible(true);
        return declaredMethod;
    }
}
