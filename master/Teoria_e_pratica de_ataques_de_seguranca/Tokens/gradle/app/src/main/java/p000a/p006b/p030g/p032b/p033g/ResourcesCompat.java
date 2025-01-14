package p000a.p006b.p030g.p032b.p033g;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.util.TypedValue;

/* renamed from: a.b.g.b.g.f */
/* loaded from: classes.dex */
public final class ResourcesCompat {
    /* renamed from: a */
    public static Drawable m9949a(Resources resources, int i, Resources.Theme theme) {
        if (Build.VERSION.SDK_INT >= 21) {
            return resources.getDrawable(i, theme);
        }
        return resources.getDrawable(i);
    }

    /* compiled from: ResourcesCompat.java */
    /* renamed from: a.b.g.b.g.f$a */
    /* loaded from: classes.dex */
    public static abstract class AbstractC0210a {

        /* compiled from: ResourcesCompat.java */
        /* renamed from: a.b.g.b.g.f$a$a */
        /* loaded from: classes.dex */
        public class RunnableC0211a implements Runnable {

            /* renamed from: a */
            public final /* synthetic */ Typeface f1405a;

            public RunnableC0211a(Typeface typeface) {
                this.f1405a = typeface;
            }

            @Override // java.lang.Runnable
            public void run() {
                AbstractC0210a.this.mo7971a(this.f1405a);
            }
        }

        /* compiled from: ResourcesCompat.java */
        /* renamed from: a.b.g.b.g.f$a$b */
        /* loaded from: classes.dex */
        public class RunnableC0212b implements Runnable {

            /* renamed from: a */
            public final /* synthetic */ int f1407a;

            public RunnableC0212b(int i) {
                this.f1407a = i;
            }

            @Override // java.lang.Runnable
            public void run() {
                AbstractC0210a.this.mo7972a(this.f1407a);
            }
        }

        /* renamed from: a */
        public abstract void mo7972a(int i);

        /* renamed from: a */
        public abstract void mo7971a(Typeface typeface);

        /* renamed from: a */
        public final void m9947a(Typeface typeface, Handler handler) {
            if (handler == null) {
                handler = new Handler(Looper.getMainLooper());
            }
            handler.post(new RunnableC0211a(typeface));
        }

        /* renamed from: a */
        public final void m9948a(int i, Handler handler) {
            if (handler == null) {
                handler = new Handler(Looper.getMainLooper());
            }
            handler.post(new RunnableC0212b(i));
        }
    }

    /* renamed from: a */
    public static Typeface m9952a(Context context, int i, TypedValue typedValue, int i2, AbstractC0210a abstractC0210a) {
        if (context.isRestricted()) {
            return null;
        }
        return m9951a(context, i, typedValue, i2, abstractC0210a, null, true);
    }

    /* renamed from: a */
    public static Typeface m9951a(Context context, int i, TypedValue typedValue, int i2, AbstractC0210a abstractC0210a, Handler handler, boolean z) {
        Resources resources = context.getResources();
        resources.getValue(i, typedValue, true);
        Typeface m9950a = m9950a(context, resources, typedValue, i, i2, abstractC0210a, handler, z);
        if (m9950a == null && abstractC0210a == null) {
            throw new Resources.NotFoundException("Font resource ID #0x" + Integer.toHexString(i) + " could not be retrieved.");
        }
        return m9950a;
    }

    /* JADX WARN: Removed duplicated region for block: B:35:0x00a3  */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static android.graphics.Typeface m9950a(android.content.Context r15, android.content.res.Resources r16, android.util.TypedValue r17, int r18, int r19, p000a.p006b.p030g.p032b.p033g.ResourcesCompat.AbstractC0210a r20, android.os.Handler r21, boolean r22) {
        /*
            r0 = r16
            r1 = r17
            r4 = r18
            r5 = r19
            r9 = r20
            r10 = r21
            java.lang.String r11 = "ResourcesCompat"
            java.lang.CharSequence r2 = r1.string
            if (r2 == 0) goto La7
            java.lang.String r12 = r2.toString()
            java.lang.String r1 = "res/"
            boolean r1 = r12.startsWith(r1)
            r13 = 0
            r14 = -3
            if (r1 != 0) goto L26
            if (r9 == 0) goto L25
            r9.m9948a(r14, r10)
        L25:
            return r13
        L26:
            android.graphics.Typeface r1 = p000a.p006b.p030g.p034c.TypefaceCompat.m9905b(r0, r4, r5)
            if (r1 == 0) goto L32
            if (r9 == 0) goto L31
            r9.m9947a(r1, r10)
        L31:
            return r1
        L32:
            java.lang.String r1 = r12.toLowerCase()     // Catch: java.io.IOException -> L76 org.xmlpull.v1.XmlPullParserException -> L8c
            java.lang.String r2 = ".xml"
            boolean r1 = r1.endsWith(r2)     // Catch: java.io.IOException -> L76 org.xmlpull.v1.XmlPullParserException -> L8c
            if (r1 == 0) goto L65
            android.content.res.XmlResourceParser r1 = r0.getXml(r4)     // Catch: java.io.IOException -> L76 org.xmlpull.v1.XmlPullParserException -> L8c
            a.b.g.b.g.c$a r2 = p000a.p006b.p030g.p032b.p033g.FontResourcesParserCompat.m9974a(r1, r0)     // Catch: java.io.IOException -> L76 org.xmlpull.v1.XmlPullParserException -> L8c
            if (r2 != 0) goto L53
            java.lang.String r0 = "Failed to find font-family tag"
            android.util.Log.e(r11, r0)     // Catch: java.io.IOException -> L76 org.xmlpull.v1.XmlPullParserException -> L8c
            if (r9 == 0) goto L52
            r9.m9948a(r14, r10)     // Catch: java.io.IOException -> L76 org.xmlpull.v1.XmlPullParserException -> L8c
        L52:
            return r13
        L53:
            r1 = r15
            r3 = r16
            r4 = r18
            r5 = r19
            r6 = r20
            r7 = r21
            r8 = r22
            android.graphics.Typeface r0 = p000a.p006b.p030g.p034c.TypefaceCompat.m9909a(r1, r2, r3, r4, r5, r6, r7, r8)     // Catch: java.io.IOException -> L76 org.xmlpull.v1.XmlPullParserException -> L8c
            return r0
        L65:
            r1 = r15
            android.graphics.Typeface r0 = p000a.p006b.p030g.p034c.TypefaceCompat.m9908a(r15, r0, r4, r12, r5)     // Catch: java.io.IOException -> L76 org.xmlpull.v1.XmlPullParserException -> L8c
            if (r9 == 0) goto L75
            if (r0 == 0) goto L72
            r9.m9947a(r0, r10)     // Catch: java.io.IOException -> L76 org.xmlpull.v1.XmlPullParserException -> L8c
            goto L75
        L72:
            r9.m9948a(r14, r10)     // Catch: java.io.IOException -> L76 org.xmlpull.v1.XmlPullParserException -> L8c
        L75:
            return r0
        L76:
            r0 = move-exception
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "Failed to read xml resource "
            r1.append(r2)
            r1.append(r12)
            java.lang.String r1 = r1.toString()
            android.util.Log.e(r11, r1, r0)
            goto La1
        L8c:
            r0 = move-exception
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "Failed to parse xml resource "
            r1.append(r2)
            r1.append(r12)
            java.lang.String r1 = r1.toString()
            android.util.Log.e(r11, r1, r0)
        La1:
            if (r9 == 0) goto La6
            r9.m9948a(r14, r10)
        La6:
            return r13
        La7:
            android.content.res.Resources$NotFoundException r2 = new android.content.res.Resources$NotFoundException
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r5 = "Resource \""
            r3.append(r5)
            java.lang.String r0 = r0.getResourceName(r4)
            r3.append(r0)
            java.lang.String r0 = "\" ("
            r3.append(r0)
            java.lang.String r0 = java.lang.Integer.toHexString(r18)
            r3.append(r0)
            java.lang.String r0 = ") is not a Font: "
            r3.append(r0)
            r3.append(r1)
            java.lang.String r0 = r3.toString()
            r2.<init>(r0)
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: p000a.p006b.p030g.p032b.p033g.ResourcesCompat.m9950a(android.content.Context, android.content.res.Resources, android.util.TypedValue, int, int, a.b.g.b.g.f$a, android.os.Handler, boolean):android.graphics.Typeface");
    }
}
