package p000a.p006b.p030g.p034c;

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
import p000a.p006b.p030g.p032b.p033g.FontResourcesParserCompat;
import p000a.p006b.p030g.p042h.FontsContractCompat;

/* renamed from: a.b.g.c.f */
/* loaded from: classes.dex */
public class TypefaceCompatApi26Impl extends TypefaceCompatApi21Impl {

    /* renamed from: a */
    public final Class f1419a;

    /* renamed from: b */
    public final Constructor f1420b;

    /* renamed from: c */
    public final Method f1421c;

    /* renamed from: d */
    public final Method f1422d;

    /* renamed from: e */
    public final Method f1423e;

    /* renamed from: f */
    public final Method f1424f;

    /* renamed from: g */
    public final Method f1425g;

    public TypefaceCompatApi26Impl() {
        Method method;
        Constructor constructor;
        Method method2;
        Method method3;
        Method method4;
        Method method5;
        Class cls = null;
        try {
            Class m9892c = m9892c();
            constructor = m9889e(m9892c);
            method2 = m9893b(m9892c);
            method3 = m9891c(m9892c);
            method4 = m9888f(m9892c);
            method5 = m9897a(m9892c);
            method = mo9886d(m9892c);
            cls = m9892c;
        } catch (ClassNotFoundException | NoSuchMethodException e) {
            Log.e("TypefaceCompatApi26Impl", "Unable to collect necessary methods for class " + e.getClass().getName(), e);
            method = null;
            constructor = null;
            method2 = null;
            method3 = null;
            method4 = null;
            method5 = null;
        }
        this.f1419a = cls;
        this.f1420b = constructor;
        this.f1421c = method2;
        this.f1422d = method3;
        this.f1423e = method4;
        this.f1424f = method5;
        this.f1425g = method;
    }

    /* renamed from: a */
    public final boolean m9899a() {
        if (this.f1421c == null) {
            Log.w("TypefaceCompatApi26Impl", "Unable to collect necessary private methods. Fallback to legacy implementation.");
        }
        return this.f1421c != null;
    }

    /* renamed from: b */
    public final Object m9894b() {
        try {
            return this.f1420b.newInstance(new Object[0]);
        } catch (IllegalAccessException | InstantiationException | InvocationTargetException e) {
            throw new RuntimeException(e);
        }
    }

    /* renamed from: c */
    public final boolean m9890c(Object obj) {
        try {
            return ((Boolean) this.f1423e.invoke(obj, new Object[0])).booleanValue();
        } catch (IllegalAccessException | InvocationTargetException e) {
            throw new RuntimeException(e);
        }
    }

    /* renamed from: d */
    public Method mo9886d(Class cls) {
        Class cls2 = Integer.TYPE;
        Method declaredMethod = Typeface.class.getDeclaredMethod("createFromFamiliesWithDefault", Array.newInstance(cls, 1).getClass(), cls2, cls2);
        declaredMethod.setAccessible(true);
        return declaredMethod;
    }

    /* renamed from: e */
    public Constructor m9889e(Class cls) {
        return cls.getConstructor(new Class[0]);
    }

    /* renamed from: f */
    public Method m9888f(Class cls) {
        return cls.getMethod("freeze", new Class[0]);
    }

    /* renamed from: b */
    public Typeface mo9887b(Object obj) {
        try {
            Object newInstance = Array.newInstance(this.f1419a, 1);
            Array.set(newInstance, 0, obj);
            return (Typeface) this.f1425g.invoke(null, newInstance, -1, -1);
        } catch (IllegalAccessException | InvocationTargetException e) {
            throw new RuntimeException(e);
        }
    }

    /* renamed from: a */
    public final boolean m9898a(Context context, Object obj, String str, int i, int i2, int i3, FontVariationAxis[] fontVariationAxisArr) {
        try {
            return ((Boolean) this.f1421c.invoke(obj, context.getAssets(), str, 0, false, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), fontVariationAxisArr)).booleanValue();
        } catch (IllegalAccessException | InvocationTargetException e) {
            throw new RuntimeException(e);
        }
    }

    /* renamed from: c */
    public Class m9892c() {
        return Class.forName("android.graphics.FontFamily");
    }

    /* renamed from: c */
    public Method m9891c(Class cls) {
        Class<?> cls2 = Integer.TYPE;
        return cls.getMethod("addFontFromBuffer", ByteBuffer.class, cls2, FontVariationAxis[].class, cls2, cls2);
    }

    /* renamed from: b */
    public Method m9893b(Class cls) {
        Class<?> cls2 = Integer.TYPE;
        return cls.getMethod("addFontFromAssetManager", AssetManager.class, String.class, Integer.TYPE, Boolean.TYPE, cls2, cls2, cls2, FontVariationAxis[].class);
    }

    /* renamed from: a */
    public final boolean m9895a(Object obj, ByteBuffer byteBuffer, int i, int i2, int i3) {
        try {
            return ((Boolean) this.f1422d.invoke(obj, byteBuffer, Integer.valueOf(i), null, Integer.valueOf(i2), Integer.valueOf(i3))).booleanValue();
        } catch (IllegalAccessException | InvocationTargetException e) {
            throw new RuntimeException(e);
        }
    }

    /* renamed from: a */
    public final void m9896a(Object obj) {
        try {
            this.f1424f.invoke(obj, new Object[0]);
        } catch (IllegalAccessException | InvocationTargetException e) {
            throw new RuntimeException(e);
        }
    }

    @Override // p000a.p006b.p030g.p034c.TypefaceCompatBaseImpl
    /* renamed from: a */
    public Typeface mo9884a(Context context, FontResourcesParserCompat.C0206b c0206b, Resources resources, int i) {
        FontResourcesParserCompat.C0207c[] m9969a;
        if (!m9899a()) {
            return super.mo9884a(context, c0206b, resources, i);
        }
        Object m9894b = m9894b();
        for (FontResourcesParserCompat.C0207c c0207c : c0206b.m9969a()) {
            if (!m9898a(context, m9894b, c0207c.m9968a(), c0207c.m9966c(), c0207c.m9964e(), c0207c.m9963f() ? 1 : 0, FontVariationAxis.fromFontVariationSettings(c0207c.m9965d()))) {
                m9896a(m9894b);
                return null;
            }
        }
        if (m9890c(m9894b)) {
            return mo9887b(m9894b);
        }
        return null;
    }

    @Override // p000a.p006b.p030g.p034c.TypefaceCompatApi21Impl, p000a.p006b.p030g.p034c.TypefaceCompatBaseImpl
    /* renamed from: a */
    public Typeface mo9882a(Context context, CancellationSignal cancellationSignal, FontsContractCompat.C0251f[] c0251fArr, int i) {
        if (c0251fArr.length < 1) {
            return null;
        }
        if (!m9899a()) {
            FontsContractCompat.C0251f m9880a = m9880a(c0251fArr, i);
            try {
                ParcelFileDescriptor openFileDescriptor = context.getContentResolver().openFileDescriptor(m9880a.m9713c(), "r", cancellationSignal);
                if (openFileDescriptor == null) {
                    if (openFileDescriptor != null) {
                        openFileDescriptor.close();
                    }
                    return null;
                }
                Typeface build = new Typeface.Builder(openFileDescriptor.getFileDescriptor()).setWeight(m9880a.m9712d()).setItalic(m9880a.m9711e()).build();
                if (openFileDescriptor != null) {
                    openFileDescriptor.close();
                }
                return build;
            } catch (IOException unused) {
                return null;
            }
        }
        Map<Uri, ByteBuffer> m9724a = FontsContractCompat.m9724a(context, c0251fArr, cancellationSignal);
        Object m9894b = m9894b();
        boolean z = false;
        for (FontsContractCompat.C0251f c0251f : c0251fArr) {
            ByteBuffer byteBuffer = m9724a.get(c0251f.m9713c());
            if (byteBuffer != null) {
                if (!m9895a(m9894b, byteBuffer, c0251f.m9714b(), c0251f.m9712d(), c0251f.m9711e() ? 1 : 0)) {
                    m9896a(m9894b);
                    return null;
                }
                z = true;
            }
        }
        if (!z) {
            m9896a(m9894b);
            return null;
        } else if (m9890c(m9894b)) {
            return Typeface.create(mo9887b(m9894b), i);
        } else {
            return null;
        }
    }

    @Override // p000a.p006b.p030g.p034c.TypefaceCompatBaseImpl
    /* renamed from: a */
    public Typeface mo9883a(Context context, Resources resources, int i, String str, int i2) {
        if (!m9899a()) {
            return super.mo9883a(context, resources, i, str, i2);
        }
        Object m9894b = m9894b();
        if (!m9898a(context, m9894b, str, 0, -1, -1, null)) {
            m9896a(m9894b);
            return null;
        } else if (m9890c(m9894b)) {
            return mo9887b(m9894b);
        } else {
            return null;
        }
    }

    /* renamed from: a */
    public Method m9897a(Class cls) {
        return cls.getMethod("abortCreation", new Class[0]);
    }
}
