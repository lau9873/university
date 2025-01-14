package p000a.p006b.p030g.p034c;

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
import p000a.p006b.p030g.p032b.p033g.FontResourcesParserCompat;
import p000a.p006b.p030g.p042h.FontsContractCompat;
import p000a.p006b.p030g.p044j.SimpleArrayMap;

/* renamed from: a.b.g.c.e */
/* loaded from: classes.dex */
public class TypefaceCompatApi24Impl extends TypefaceCompatBaseImpl {

    /* renamed from: a */
    public static final Class f1415a;

    /* renamed from: b */
    public static final Constructor f1416b;

    /* renamed from: c */
    public static final Method f1417c;

    /* renamed from: d */
    public static final Method f1418d;

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
        } catch (ClassNotFoundException | NoSuchMethodException e) {
            Log.e("TypefaceCompatApi24Impl", e.getClass().getName(), e);
            cls = null;
            method = null;
            method2 = null;
        }
        f1416b = constructor;
        f1415a = cls;
        f1417c = method2;
        f1418d = method;
    }

    /* renamed from: a */
    public static boolean m9903a() {
        if (f1417c == null) {
            Log.w("TypefaceCompatApi24Impl", "Unable to collect necessary private methods.Fallback to legacy implementation.");
        }
        return f1417c != null;
    }

    /* renamed from: b */
    public static Object m9900b() {
        try {
            return f1416b.newInstance(new Object[0]);
        } catch (IllegalAccessException | InstantiationException | InvocationTargetException e) {
            throw new RuntimeException(e);
        }
    }

    /* renamed from: a */
    public static boolean m9901a(Object obj, ByteBuffer byteBuffer, int i, int i2, boolean z) {
        try {
            return ((Boolean) f1417c.invoke(obj, byteBuffer, Integer.valueOf(i), null, Integer.valueOf(i2), Boolean.valueOf(z))).booleanValue();
        } catch (IllegalAccessException | InvocationTargetException e) {
            throw new RuntimeException(e);
        }
    }

    /* renamed from: a */
    public static Typeface m9902a(Object obj) {
        try {
            Object newInstance = Array.newInstance(f1415a, 1);
            Array.set(newInstance, 0, obj);
            return (Typeface) f1418d.invoke(null, newInstance);
        } catch (IllegalAccessException | InvocationTargetException e) {
            throw new RuntimeException(e);
        }
    }

    @Override // p000a.p006b.p030g.p034c.TypefaceCompatBaseImpl
    /* renamed from: a */
    public Typeface mo9882a(Context context, CancellationSignal cancellationSignal, FontsContractCompat.C0251f[] c0251fArr, int i) {
        Object m9900b = m9900b();
        SimpleArrayMap simpleArrayMap = new SimpleArrayMap();
        for (FontsContractCompat.C0251f c0251f : c0251fArr) {
            Uri m9713c = c0251f.m9713c();
            ByteBuffer byteBuffer = (ByteBuffer) simpleArrayMap.get(m9713c);
            if (byteBuffer == null) {
                byteBuffer = TypefaceCompatUtil.m9870a(context, cancellationSignal, m9713c);
                simpleArrayMap.put(m9713c, byteBuffer);
            }
            if (!m9901a(m9900b, byteBuffer, c0251f.m9714b(), c0251f.m9712d(), c0251f.m9711e())) {
                return null;
            }
        }
        return Typeface.create(m9902a(m9900b), i);
    }

    @Override // p000a.p006b.p030g.p034c.TypefaceCompatBaseImpl
    /* renamed from: a */
    public Typeface mo9884a(Context context, FontResourcesParserCompat.C0206b c0206b, Resources resources, int i) {
        FontResourcesParserCompat.C0207c[] m9969a;
        Object m9900b = m9900b();
        for (FontResourcesParserCompat.C0207c c0207c : c0206b.m9969a()) {
            ByteBuffer m9871a = TypefaceCompatUtil.m9871a(context, resources, c0207c.m9967b());
            if (m9871a == null || !m9901a(m9900b, m9871a, c0207c.m9966c(), c0207c.m9964e(), c0207c.m9963f())) {
                return null;
            }
        }
        return m9902a(m9900b);
    }
}
