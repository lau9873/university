package p000a.p006b.p030g.p034c;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.os.CancellationSignal;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import p000a.p006b.p030g.p032b.p033g.FontResourcesParserCompat;
import p000a.p006b.p030g.p042h.FontsContractCompat;

/* renamed from: a.b.g.c.h */
/* loaded from: classes.dex */
public class TypefaceCompatBaseImpl {

    /* compiled from: TypefaceCompatBaseImpl.java */
    /* renamed from: a.b.g.c.h$a */
    /* loaded from: classes.dex */
    public class C0215a implements InterfaceC0217c<FontsContractCompat.C0251f> {
        public C0215a(TypefaceCompatBaseImpl typefaceCompatBaseImpl) {
        }

        @Override // p000a.p006b.p030g.p034c.TypefaceCompatBaseImpl.InterfaceC0217c
        /* renamed from: a  reason: avoid collision after fix types in other method */
        public int mo9874a(FontsContractCompat.C0251f c0251f) {
            return c0251f.m9712d();
        }

        @Override // p000a.p006b.p030g.p034c.TypefaceCompatBaseImpl.InterfaceC0217c
        /* renamed from: b  reason: avoid collision after fix types in other method */
        public boolean mo9873b(FontsContractCompat.C0251f c0251f) {
            return c0251f.m9711e();
        }
    }

    /* compiled from: TypefaceCompatBaseImpl.java */
    /* renamed from: a.b.g.c.h$b */
    /* loaded from: classes.dex */
    public class C0216b implements InterfaceC0217c<FontResourcesParserCompat.C0207c> {
        public C0216b(TypefaceCompatBaseImpl typefaceCompatBaseImpl) {
        }

        @Override // p000a.p006b.p030g.p034c.TypefaceCompatBaseImpl.InterfaceC0217c
        /* renamed from: a  reason: avoid collision after fix types in other method */
        public int mo9874a(FontResourcesParserCompat.C0207c c0207c) {
            return c0207c.m9964e();
        }

        @Override // p000a.p006b.p030g.p034c.TypefaceCompatBaseImpl.InterfaceC0217c
        /* renamed from: b  reason: avoid collision after fix types in other method */
        public boolean mo9873b(FontResourcesParserCompat.C0207c c0207c) {
            return c0207c.m9963f();
        }
    }

    /* compiled from: TypefaceCompatBaseImpl.java */
    /* renamed from: a.b.g.c.h$c */
    /* loaded from: classes.dex */
    public interface InterfaceC0217c<T> {
        /* renamed from: a */
        int mo9874a(T t);

        /* renamed from: b */
        boolean mo9873b(T t);
    }

    /* renamed from: a */
    public static <T> T m9879a(T[] tArr, int i, InterfaceC0217c<T> interfaceC0217c) {
        int i2 = (i & 1) == 0 ? 400 : 700;
        boolean z = (i & 2) != 0;
        T t = null;
        int i3 = Integer.MAX_VALUE;
        for (T t2 : tArr) {
            int abs = (Math.abs(interfaceC0217c.mo9874a(t2) - i2) * 2) + (interfaceC0217c.mo9873b(t2) == z ? 0 : 1);
            if (t == null || i3 > abs) {
                t = t2;
                i3 = abs;
            }
        }
        return t;
    }

    /* renamed from: a */
    public FontsContractCompat.C0251f m9880a(FontsContractCompat.C0251f[] c0251fArr, int i) {
        return (FontsContractCompat.C0251f) m9879a(c0251fArr, i, new C0215a(this));
    }

    /* renamed from: a */
    public Typeface m9881a(Context context, InputStream inputStream) {
        File m9872a = TypefaceCompatUtil.m9872a(context);
        if (m9872a == null) {
            return null;
        }
        try {
            if (TypefaceCompatUtil.m9866a(m9872a, inputStream)) {
                return Typeface.createFromFile(m9872a.getPath());
            }
            return null;
        } catch (RuntimeException unused) {
            return null;
        } finally {
            m9872a.delete();
        }
    }

    /* renamed from: a */
    public Typeface mo9882a(Context context, CancellationSignal cancellationSignal, FontsContractCompat.C0251f[] c0251fArr, int i) {
        InputStream inputStream;
        InputStream inputStream2 = null;
        if (c0251fArr.length < 1) {
            return null;
        }
        try {
            inputStream = context.getContentResolver().openInputStream(m9880a(c0251fArr, i).m9713c());
            try {
                Typeface m9881a = m9881a(context, inputStream);
                TypefaceCompatUtil.m9869a(inputStream);
                return m9881a;
            } catch (IOException unused) {
                TypefaceCompatUtil.m9869a(inputStream);
                return null;
            } catch (Throwable th) {
                th = th;
                inputStream2 = inputStream;
                TypefaceCompatUtil.m9869a(inputStream2);
                throw th;
            }
        } catch (IOException unused2) {
            inputStream = null;
        } catch (Throwable th2) {
            th = th2;
        }
    }

    /* renamed from: a */
    public final FontResourcesParserCompat.C0207c m9885a(FontResourcesParserCompat.C0206b c0206b, int i) {
        return (FontResourcesParserCompat.C0207c) m9879a(c0206b.m9969a(), i, new C0216b(this));
    }

    /* renamed from: a */
    public Typeface mo9884a(Context context, FontResourcesParserCompat.C0206b c0206b, Resources resources, int i) {
        FontResourcesParserCompat.C0207c m9885a = m9885a(c0206b, i);
        if (m9885a == null) {
            return null;
        }
        return TypefaceCompat.m9908a(context, resources, m9885a.m9967b(), m9885a.m9968a(), i);
    }

    /* renamed from: a */
    public Typeface mo9883a(Context context, Resources resources, int i, String str, int i2) {
        File m9872a = TypefaceCompatUtil.m9872a(context);
        if (m9872a == null) {
            return null;
        }
        try {
            if (TypefaceCompatUtil.m9867a(m9872a, resources, i)) {
                return Typeface.createFromFile(m9872a.getPath());
            }
            return null;
        } catch (RuntimeException unused) {
            return null;
        } finally {
            m9872a.delete();
        }
    }
}
