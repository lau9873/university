package p000a.p006b.p030g.p034c;

import android.graphics.Typeface;
import java.lang.reflect.Array;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* renamed from: a.b.g.c.g */
/* loaded from: classes.dex */
public class TypefaceCompatApi28Impl extends TypefaceCompatApi26Impl {
    @Override // p000a.p006b.p030g.p034c.TypefaceCompatApi26Impl
    /* renamed from: b */
    public Typeface mo9887b(Object obj) {
        try {
            Object newInstance = Array.newInstance(this.f1419a, 1);
            Array.set(newInstance, 0, obj);
            return (Typeface) this.f1425g.invoke(null, newInstance, "sans-serif", -1, -1);
        } catch (IllegalAccessException | InvocationTargetException e) {
            throw new RuntimeException(e);
        }
    }

    @Override // p000a.p006b.p030g.p034c.TypefaceCompatApi26Impl
    /* renamed from: d */
    public Method mo9886d(Class cls) {
        Class cls2 = Integer.TYPE;
        Method declaredMethod = Typeface.class.getDeclaredMethod("createFromFamiliesWithDefault", Array.newInstance(cls, 1).getClass(), String.class, cls2, cls2);
        declaredMethod.setAccessible(true);
        return declaredMethod;
    }
}
