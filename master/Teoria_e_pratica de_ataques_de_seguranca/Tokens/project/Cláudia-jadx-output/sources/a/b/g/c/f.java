package a.b.g.c;

import a.b.g.b.g.c;
import a.b.g.h.b;
import android.content.Context;
import android.content.res.AssetManager;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.graphics.fonts.FontVariationAxis;
import android.net.Uri;
import android.os.CancellationSignal;
import android.os.ParcelFileDescriptor;
import android.util.Log;
import java.io.IOException;
import java.lang.reflect.Array;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.nio.ByteBuffer;
import java.util.Map;
/* compiled from: TypefaceCompatApi26Impl.java */
/* loaded from: classes.dex */
public class f extends d {

    /* renamed from: a  reason: collision with root package name */
    public final Class f913a;

    /* renamed from: b  reason: collision with root package name */
    public final Constructor f914b;

    /* renamed from: c  reason: collision with root package name */
    public final Method f915c;

    /* renamed from: d  reason: collision with root package name */
    public final Method f916d;

    /* renamed from: e  reason: collision with root package name */
    public final Method f917e;

    /* renamed from: f  reason: collision with root package name */
    public final Method f918f;

    /* renamed from: g  reason: collision with root package name */
    public final Method f919g;

    public f() {
        Method method;
        Constructor constructor;
        Method method2;
        Method method3;
        Method method4;
        Method method5;
        Class cls = null;
        try {
            Class c2 = c();
            constructor = e(c2);
            method2 = b(c2);
            method3 = c(c2);
            method4 = f(c2);
            method5 = a(c2);
            method = d(c2);
            cls = c2;
        } catch (ClassNotFoundException | NoSuchMethodException e2) {
            Log.e("TypefaceCompatApi26Impl", "Unable to collect necessary methods for class " + e2.getClass().getName(), e2);
            method = null;
            constructor = null;
            method2 = null;
            method3 = null;
            method4 = null;
            method5 = null;
        }
        this.f913a = cls;
        this.f914b = constructor;
        this.f915c = method2;
        this.f916d = method3;
        this.f917e = method4;
        this.f918f = method5;
        this.f919g = method;
    }

    public final boolean a() {
        if (this.f915c == null) {
            Log.w("TypefaceCompatApi26Impl", "Unable to collect necessary private methods. Fallback to legacy implementation.");
        }
        return this.f915c != null;
    }

    public final Object b() {
        try {
            return this.f914b.newInstance(new Object[0]);
        } catch (IllegalAccessException | InstantiationException | InvocationTargetException e2) {
            throw new RuntimeException(e2);
        }
    }

    public final boolean c(Object obj) {
        try {
            return ((Boolean) this.f917e.invoke(obj, new Object[0])).booleanValue();
        } catch (IllegalAccessException | InvocationTargetException e2) {
            throw new RuntimeException(e2);
        }
    }

    public Method d(Class cls) {
        Class cls2 = Integer.TYPE;
        Method declaredMethod = Typeface.class.getDeclaredMethod("createFromFamiliesWithDefault", Array.newInstance(cls, 1).getClass(), cls2, cls2);
        declaredMethod.setAccessible(true);
        return declaredMethod;
    }

    public Constructor e(Class cls) {
        return cls.getConstructor(new Class[0]);
    }

    public Method f(Class cls) {
        return cls.getMethod("freeze", new Class[0]);
    }

    public Typeface b(Object obj) {
        try {
            Object newInstance = Array.newInstance(this.f913a, 1);
            Array.set(newInstance, 0, obj);
            return (Typeface) this.f919g.invoke(null, newInstance, -1, -1);
        } catch (IllegalAccessException | InvocationTargetException e2) {
            throw new RuntimeException(e2);
        }
    }

    public final boolean a(Context context, Object obj, String str, int i2, int i3, int i4, FontVariationAxis[] fontVariationAxisArr) {
        try {
            return ((Boolean) this.f915c.invoke(obj, context.getAssets(), str, 0, false, Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), fontVariationAxisArr)).booleanValue();
        } catch (IllegalAccessException | InvocationTargetException e2) {
            throw new RuntimeException(e2);
        }
    }

    public Class c() {
        return Class.forName("android.graphics.FontFamily");
    }

    public Method c(Class cls) {
        Class<?> cls2 = Integer.TYPE;
        return cls.getMethod("addFontFromBuffer", ByteBuffer.class, cls2, FontVariationAxis[].class, cls2, cls2);
    }

    public Method b(Class cls) {
        Class<?> cls2 = Integer.TYPE;
        return cls.getMethod("addFontFromAssetManager", AssetManager.class, String.class, Integer.TYPE, Boolean.TYPE, cls2, cls2, cls2, FontVariationAxis[].class);
    }

    public final boolean a(Object obj, ByteBuffer byteBuffer, int i2, int i3, int i4) {
        try {
            return ((Boolean) this.f916d.invoke(obj, byteBuffer, Integer.valueOf(i2), null, Integer.valueOf(i3), Integer.valueOf(i4))).booleanValue();
        } catch (IllegalAccessException | InvocationTargetException e2) {
            throw new RuntimeException(e2);
        }
    }

    public final void a(Object obj) {
        try {
            this.f918f.invoke(obj, new Object[0]);
        } catch (IllegalAccessException | InvocationTargetException e2) {
            throw new RuntimeException(e2);
        }
    }

    @Override // a.b.g.c.h
    public Typeface a(Context context, c.b bVar, Resources resources, int i2) {
        c.C0020c[] a2;
        if (!a()) {
            return super.a(context, bVar, resources, i2);
        }
        Object b2 = b();
        for (c.C0020c c0020c : bVar.a()) {
            if (!a(context, b2, c0020c.a(), c0020c.c(), c0020c.e(), c0020c.f() ? 1 : 0, FontVariationAxis.fromFontVariationSettings(c0020c.d()))) {
                a(b2);
                return null;
            }
        }
        if (c(b2)) {
            return b(b2);
        }
        return null;
    }

    @Override // a.b.g.c.d, a.b.g.c.h
    public Typeface a(Context context, CancellationSignal cancellationSignal, b.f[] fVarArr, int i2) {
        if (fVarArr.length < 1) {
            return null;
        }
        if (!a()) {
            b.f a2 = a(fVarArr, i2);
            try {
                ParcelFileDescriptor openFileDescriptor = context.getContentResolver().openFileDescriptor(a2.c(), "r", cancellationSignal);
                if (openFileDescriptor == null) {
                    if (openFileDescriptor != null) {
                        openFileDescriptor.close();
                    }
                    return null;
                }
                Typeface build = new Typeface.Builder(openFileDescriptor.getFileDescriptor()).setWeight(a2.d()).setItalic(a2.e()).build();
                if (openFileDescriptor != null) {
                    openFileDescriptor.close();
                }
                return build;
            } catch (IOException unused) {
                return null;
            }
        }
        Map<Uri, ByteBuffer> a3 = a.b.g.h.b.a(context, fVarArr, cancellationSignal);
        Object b2 = b();
        boolean z = false;
        for (b.f fVar : fVarArr) {
            ByteBuffer byteBuffer = a3.get(fVar.c());
            if (byteBuffer != null) {
                if (!a(b2, byteBuffer, fVar.b(), fVar.d(), fVar.e() ? 1 : 0)) {
                    a(b2);
                    return null;
                }
                z = true;
            }
        }
        if (!z) {
            a(b2);
            return null;
        } else if (c(b2)) {
            return Typeface.create(b(b2), i2);
        } else {
            return null;
        }
    }

    @Override // a.b.g.c.h
    public Typeface a(Context context, Resources resources, int i2, String str, int i3) {
        if (!a()) {
            return super.a(context, resources, i2, str, i3);
        }
        Object b2 = b();
        if (!a(context, b2, str, 0, -1, -1, null)) {
            a(b2);
            return null;
        } else if (c(b2)) {
            return b(b2);
        } else {
            return null;
        }
    }

    public Method a(Class cls) {
        return cls.getMethod("abortCreation", new Class[0]);
    }
}
