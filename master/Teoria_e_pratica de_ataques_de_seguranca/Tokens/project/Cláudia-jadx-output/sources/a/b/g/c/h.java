package a.b.g.c;

import a.b.g.b.g.c;
import a.b.g.h.b;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.os.CancellationSignal;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
/* compiled from: TypefaceCompatBaseImpl.java */
/* loaded from: classes.dex */
public class h {

    /* compiled from: TypefaceCompatBaseImpl.java */
    /* loaded from: classes.dex */
    public class a implements c<b.f> {
        public a(h hVar) {
        }

        @Override // a.b.g.c.h.c
        public int a(b.f fVar) {
            return fVar.d();
        }

        @Override // a.b.g.c.h.c
        public boolean b(b.f fVar) {
            return fVar.e();
        }
    }

    /* compiled from: TypefaceCompatBaseImpl.java */
    /* loaded from: classes.dex */
    public class b implements c<c.C0020c> {
        public b(h hVar) {
        }

        @Override // a.b.g.c.h.c
        public int a(c.C0020c c0020c) {
            return c0020c.e();
        }

        @Override // a.b.g.c.h.c
        public boolean b(c.C0020c c0020c) {
            return c0020c.f();
        }
    }

    /* compiled from: TypefaceCompatBaseImpl.java */
    /* loaded from: classes.dex */
    public interface c<T> {
        int a(T t);

        boolean b(T t);
    }

    public static <T> T a(T[] tArr, int i2, c<T> cVar) {
        int i3 = (i2 & 1) == 0 ? 400 : 700;
        boolean z = (i2 & 2) != 0;
        T t = null;
        int i4 = Integer.MAX_VALUE;
        for (T t2 : tArr) {
            int abs = (Math.abs(cVar.a(t2) - i3) * 2) + (cVar.b(t2) == z ? 0 : 1);
            if (t == null || i4 > abs) {
                t = t2;
                i4 = abs;
            }
        }
        return t;
    }

    public b.f a(b.f[] fVarArr, int i2) {
        return (b.f) a(fVarArr, i2, new a(this));
    }

    public Typeface a(Context context, InputStream inputStream) {
        File a2 = i.a(context);
        if (a2 == null) {
            return null;
        }
        try {
            if (i.a(a2, inputStream)) {
                return Typeface.createFromFile(a2.getPath());
            }
            return null;
        } catch (RuntimeException unused) {
            return null;
        } finally {
            a2.delete();
        }
    }

    public Typeface a(Context context, CancellationSignal cancellationSignal, b.f[] fVarArr, int i2) {
        InputStream inputStream;
        InputStream inputStream2 = null;
        if (fVarArr.length < 1) {
            return null;
        }
        try {
            inputStream = context.getContentResolver().openInputStream(a(fVarArr, i2).c());
        } catch (IOException unused) {
            inputStream = null;
        } catch (Throwable th) {
            th = th;
        }
        try {
            Typeface a2 = a(context, inputStream);
            i.a(inputStream);
            return a2;
        } catch (IOException unused2) {
            i.a(inputStream);
            return null;
        } catch (Throwable th2) {
            th = th2;
            inputStream2 = inputStream;
            i.a(inputStream2);
            throw th;
        }
    }

    public final c.C0020c a(c.b bVar, int i2) {
        return (c.C0020c) a(bVar.a(), i2, new b(this));
    }

    public Typeface a(Context context, c.b bVar, Resources resources, int i2) {
        c.C0020c a2 = a(bVar, i2);
        if (a2 == null) {
            return null;
        }
        return a.b.g.c.c.a(context, resources, a2.b(), a2.a(), i2);
    }

    public Typeface a(Context context, Resources resources, int i2, String str, int i3) {
        File a2 = i.a(context);
        if (a2 == null) {
            return null;
        }
        try {
            if (i.a(a2, resources, i2)) {
                return Typeface.createFromFile(a2.getPath());
            }
            return null;
        } catch (RuntimeException unused) {
            return null;
        } finally {
            a2.delete();
        }
    }
}
