package p070c.p084d.p105b.p107v.p110o;

import com.google.gson.JsonIOException;
import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Field;

/* renamed from: c.d.b.v.o.c */
/* loaded from: classes.dex */
public final class UnsafeReflectionAccessor extends ReflectionAccessor {

    /* renamed from: d */
    public static Class f5893d;

    /* renamed from: b */
    public final Object f5894b = m4741c();

    /* renamed from: c */
    public final Field f5895c = m4743b();

    /* renamed from: c */
    public static Object m4741c() {
        try {
            f5893d = Class.forName("sun.misc.Unsafe");
            Field declaredField = f5893d.getDeclaredField("theUnsafe");
            declaredField.setAccessible(true);
            return declaredField.get(null);
        } catch (Exception unused) {
            return null;
        }
    }

    @Override // p070c.p084d.p105b.p107v.p110o.ReflectionAccessor
    /* renamed from: a */
    public void mo4744a(AccessibleObject accessibleObject) {
        if (m4742b(accessibleObject)) {
            return;
        }
        try {
            accessibleObject.setAccessible(true);
        } catch (SecurityException e) {
            throw new JsonIOException("Gson couldn't modify fields for " + accessibleObject + "\nand sun.misc.Unsafe not found.\nEither write a custom type adapter, or make fields accessible, or include sun.misc.Unsafe.", e);
        }
    }

    /* renamed from: b */
    public boolean m4742b(AccessibleObject accessibleObject) {
        if (this.f5894b != null && this.f5895c != null) {
            try {
                f5893d.getMethod("putBoolean", Object.class, Long.TYPE, Boolean.TYPE).invoke(this.f5894b, accessibleObject, Long.valueOf(((Long) f5893d.getMethod("objectFieldOffset", Field.class).invoke(this.f5894b, this.f5895c)).longValue()), true);
                return true;
            } catch (Exception unused) {
            }
        }
        return false;
    }

    /* renamed from: b */
    public static Field m4743b() {
        try {
            return AccessibleObject.class.getDeclaredField("override");
        } catch (NoSuchFieldException unused) {
            return null;
        }
    }
}
