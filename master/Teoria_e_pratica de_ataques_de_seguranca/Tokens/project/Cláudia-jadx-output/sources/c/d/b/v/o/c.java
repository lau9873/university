package c.d.b.v.o;

import com.google.gson.JsonIOException;
import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Field;
/* compiled from: UnsafeReflectionAccessor.java */
/* loaded from: classes.dex */
public final class c extends b {

    /* renamed from: d  reason: collision with root package name */
    public static Class f3888d;

    /* renamed from: b  reason: collision with root package name */
    public final Object f3889b = c();

    /* renamed from: c  reason: collision with root package name */
    public final Field f3890c = b();

    public static Object c() {
        try {
            f3888d = Class.forName("sun.misc.Unsafe");
            Field declaredField = f3888d.getDeclaredField("theUnsafe");
            declaredField.setAccessible(true);
            return declaredField.get(null);
        } catch (Exception unused) {
            return null;
        }
    }

    @Override // c.d.b.v.o.b
    public void a(AccessibleObject accessibleObject) {
        if (b(accessibleObject)) {
            return;
        }
        try {
            accessibleObject.setAccessible(true);
        } catch (SecurityException e2) {
            throw new JsonIOException("Gson couldn't modify fields for " + accessibleObject + "\nand sun.misc.Unsafe not found.\nEither write a custom type adapter, or make fields accessible, or include sun.misc.Unsafe.", e2);
        }
    }

    public boolean b(AccessibleObject accessibleObject) {
        if (this.f3889b != null && this.f3890c != null) {
            try {
                f3888d.getMethod("putBoolean", Object.class, Long.TYPE, Boolean.TYPE).invoke(this.f3889b, accessibleObject, Long.valueOf(((Long) f3888d.getMethod("objectFieldOffset", Field.class).invoke(this.f3889b, this.f3890c)).longValue()), true);
                return true;
            } catch (Exception unused) {
            }
        }
        return false;
    }

    public static Field b() {
        try {
            return AccessibleObject.class.getDeclaredField("override");
        } catch (NoSuchFieldException unused) {
            return null;
        }
    }
}
