package p000a.p006b.p030g.p034c;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.os.Build;
import android.os.CancellationSignal;
import android.os.Handler;
import p000a.p006b.p030g.p032b.p033g.FontResourcesParserCompat;
import p000a.p006b.p030g.p032b.p033g.ResourcesCompat;
import p000a.p006b.p030g.p042h.FontsContractCompat;
import p000a.p006b.p030g.p044j.LruCache;

/* renamed from: a.b.g.c.c */
/* loaded from: classes.dex */
public class TypefaceCompat {

    /* renamed from: a */
    public static final TypefaceCompatBaseImpl f1413a;

    /* renamed from: b */
    public static final LruCache<String, Typeface> f1414b;

    static {
        int i = Build.VERSION.SDK_INT;
        if (i >= 28) {
            f1413a = new TypefaceCompatApi28Impl();
        } else if (i >= 26) {
            f1413a = new TypefaceCompatApi26Impl();
        } else if (i >= 24 && TypefaceCompatApi24Impl.m9903a()) {
            f1413a = new TypefaceCompatApi24Impl();
        } else if (Build.VERSION.SDK_INT >= 21) {
            f1413a = new TypefaceCompatApi21Impl();
        } else {
            f1413a = new TypefaceCompatBaseImpl();
        }
        f1414b = new LruCache<>(16);
    }

    /* renamed from: a */
    public static String m9906a(Resources resources, int i, int i2) {
        return resources.getResourcePackageName(i) + "-" + i + "-" + i2;
    }

    /* renamed from: b */
    public static Typeface m9905b(Resources resources, int i, int i2) {
        return f1414b.m9649b(m9906a(resources, i, i2));
    }

    /* renamed from: a */
    public static Typeface m9909a(Context context, FontResourcesParserCompat.InterfaceC0205a interfaceC0205a, Resources resources, int i, int i2, ResourcesCompat.AbstractC0210a abstractC0210a, Handler handler, boolean z) {
        Typeface mo9884a;
        if (interfaceC0205a instanceof FontResourcesParserCompat.C0208d) {
            FontResourcesParserCompat.C0208d c0208d = (FontResourcesParserCompat.C0208d) interfaceC0205a;
            boolean z2 = false;
            if (!z ? abstractC0210a == null : c0208d.m9962a() == 0) {
                z2 = true;
            }
            mo9884a = FontsContractCompat.m9727a(context, c0208d.m9961b(), abstractC0210a, handler, z2, z ? c0208d.m9960c() : -1, i2);
        } else {
            mo9884a = f1413a.mo9884a(context, (FontResourcesParserCompat.C0206b) interfaceC0205a, resources, i2);
            if (abstractC0210a != null) {
                if (mo9884a != null) {
                    abstractC0210a.m9947a(mo9884a, handler);
                } else {
                    abstractC0210a.m9948a(-3, handler);
                }
            }
        }
        if (mo9884a != null) {
            f1414b.m9651a(m9906a(resources, i, i2), mo9884a);
        }
        return mo9884a;
    }

    /* renamed from: a */
    public static Typeface m9908a(Context context, Resources resources, int i, String str, int i2) {
        Typeface mo9883a = f1413a.mo9883a(context, resources, i, str, i2);
        if (mo9883a != null) {
            f1414b.m9651a(m9906a(resources, i, i2), mo9883a);
        }
        return mo9883a;
    }

    /* renamed from: a */
    public static Typeface m9907a(Context context, CancellationSignal cancellationSignal, FontsContractCompat.C0251f[] c0251fArr, int i) {
        return f1413a.mo9882a(context, cancellationSignal, c0251fArr, i);
    }
}
