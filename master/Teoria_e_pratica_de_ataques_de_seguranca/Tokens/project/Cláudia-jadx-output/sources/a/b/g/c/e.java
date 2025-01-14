package a.b.g.c;

import a.b.g.b.g.c;
import a.b.g.h.b;
import a.b.g.j.n;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.CancellationSignal;
import android.util.Log;
import java.lang.reflect.Array;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.nio.ByteBuffer;
import java.util.List;
/* compiled from: TypefaceCompatApi24Impl.java */
/* loaded from: classes.dex */
public class e extends h {

    /* renamed from: a  reason: collision with root package name */
    public static final Class f909a;

    /* renamed from: b  reason: collision with root package name */
    public static final Constructor f910b;

    /* renamed from: c  reason: collision with root package name */
    public static final Method f911c;

    /* renamed from: d  reason: collision with root package name */
    public static final Method f912d;

    static {
        Class<?> cls;
        Method method;
        Method method2;
        Constructor<?> constructor = null;
        try {
            cls = Class.forName("android.graphics.FontFamily");
            Constructor<?> constructor2 = cls.getConstructor(new Class[0]);
            method2 = cls.getMethod("addFontWeightStyle", ByteBuffer.class, Integer.TYPE, List.class, Integer.TYPE, Boolean.TYPE);
            method = Typeface.class.getMethod("createFromFamiliesWithDefault", Array.newInstance(cls, 1).getClass());
            constructor = constructor2;
        } catch (ClassNotFoundException | NoSuchMethodException e2) {
            Log.e("TypefaceCompatApi24Impl", e2.getClass().getName(), e2);
            cls = null;
            method = null;
            method2 = null;
        }
        f910b = constructor;
        f909a = cls;
        f911c = method2;
        f912d = method;
    }

    public static boolean a() {
        if (f911c == null) {
            Log.w("TypefaceCompatApi24Impl", "Unable to collect necessary private methods.Fallback to legacy implementation.");
        }
        return f911c != null;
    }

    public static Object b() {
        try {
            return f910b.newInstance(new Object[0]);
        } catch (IllegalAccessException | InstantiationException | InvocationTargetException e2) {
            throw new RuntimeException(e2);
        }
    }

    public static boolean a(Object obj, ByteBuffer byteBuffer, int i2, int i3, boolean z) {
        try {
            return ((Boolean) f911c.invoke(obj, byteBuffer, Integer.valueOf(i2), null, Integer.valueOf(i3), Boolean.valueOf(z))).booleanValue();
        } catch (IllegalAccessException | InvocationTargetException e2) {
            throw new RuntimeException(e2);
        }
    }

    public static Typeface a(Object obj) {
        try {
            Object newInstance = Array.newInstance(f909a, 1);
            Array.set(newInstance, 0, obj);
            return (Typeface) f912d.invoke(null, newInstance);
        } catch (IllegalAccessException | InvocationTargetException e2) {
            throw new RuntimeException(e2);
        }
    }

    @Override // a.b.g.c.h
    public Typeface a(Context context, CancellationSignal cancellationSignal, b.f[] fVarArr, int i2) {
        Object b2 = b();
        n nVar = new n();
        for (b.f fVar : fVarArr) {
            Uri c2 = fVar.c();
            ByteBuffer byteBuffer = (ByteBuffer) nVar.get(c2);
            if (byteBuffer == null) {
                byteBuffer = i.a(context, cancellationSignal, c2);
                nVar.put(c2, byteBuffer);
            }
            if (!a(b2, byteBuffer, fVar.b(), fVar.d(), fVar.e())) {
                return null;
            }
        }
        return Typeface.create(a(b2), i2);
    }

    @Override // a.b.g.c.h
    public Typeface a(Context context, c.b bVar, Resources resources, int i2) {
        c.C0020c[] a2;
        Object b2 = b();
        for (c.C0020c c0020c : bVar.a()) {
            ByteBuffer a3 = i.a(context, resources, c0020c.b());
            if (a3 == null || !a(b2, a3, c0020c.c(), c0020c.e(), c0020c.f())) {
                return null;
            }
        }
        return a(b2);
    }
}
