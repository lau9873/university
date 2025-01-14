package a.b.g.b.g;

import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.LinearGradient;
import android.graphics.RadialGradient;
import android.graphics.Shader;
import android.graphics.SweepGradient;
import android.util.AttributeSet;
import java.util.List;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
/* compiled from: GradientColorInflaterCompat.java */
/* loaded from: classes.dex */
public final class d {
    public static Shader a(Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) {
        String name = xmlPullParser.getName();
        if (name.equals("gradient")) {
            TypedArray a2 = g.a(resources, theme, attributeSet, a.b.a.c.GradientColor);
            float a3 = g.a(a2, xmlPullParser, "startX", a.b.a.c.GradientColor_android_startX, 0.0f);
            float a4 = g.a(a2, xmlPullParser, "startY", a.b.a.c.GradientColor_android_startY, 0.0f);
            float a5 = g.a(a2, xmlPullParser, "endX", a.b.a.c.GradientColor_android_endX, 0.0f);
            float a6 = g.a(a2, xmlPullParser, "endY", a.b.a.c.GradientColor_android_endY, 0.0f);
            float a7 = g.a(a2, xmlPullParser, "centerX", a.b.a.c.GradientColor_android_centerX, 0.0f);
            float a8 = g.a(a2, xmlPullParser, "centerY", a.b.a.c.GradientColor_android_centerY, 0.0f);
            int b2 = g.b(a2, xmlPullParser, "type", a.b.a.c.GradientColor_android_type, 0);
            int a9 = g.a(a2, xmlPullParser, "startColor", a.b.a.c.GradientColor_android_startColor, 0);
            boolean a10 = g.a(xmlPullParser, "centerColor");
            int a11 = g.a(a2, xmlPullParser, "centerColor", a.b.a.c.GradientColor_android_centerColor, 0);
            int a12 = g.a(a2, xmlPullParser, "endColor", a.b.a.c.GradientColor_android_endColor, 0);
            int b3 = g.b(a2, xmlPullParser, "tileMode", a.b.a.c.GradientColor_android_tileMode, 0);
            float a13 = g.a(a2, xmlPullParser, "gradientRadius", a.b.a.c.GradientColor_android_gradientRadius, 0.0f);
            a2.recycle();
            a a14 = a(b(resources, xmlPullParser, attributeSet, theme), a9, a12, a10, a11);
            if (b2 != 1) {
                if (b2 != 2) {
                    return new LinearGradient(a3, a4, a5, a6, a14.f897a, a14.f898b, a(b3));
                }
                return new SweepGradient(a7, a8, a14.f897a, a14.f898b);
            } else if (a13 > 0.0f) {
                return new RadialGradient(a7, a8, a13, a14.f897a, a14.f898b, a(b3));
            } else {
                throw new XmlPullParserException("<gradient> tag requires 'gradientRadius' attribute with radial type");
            }
        }
        throw new XmlPullParserException(xmlPullParser.getPositionDescription() + ": invalid gradient color tag " + name);
    }

    /* JADX WARN: Code restructure failed: missing block: B:21:0x0089, code lost:
        throw new org.xmlpull.v1.XmlPullParserException(r9.getPositionDescription() + ": <item> tag requires a 'color' attribute and a 'offset' attribute!");
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static a.b.g.b.g.d.a b(android.content.res.Resources r8, org.xmlpull.v1.XmlPullParser r9, android.util.AttributeSet r10, android.content.res.Resources.Theme r11) {
        /*
            int r0 = r9.getDepth()
            r1 = 1
            int r0 = r0 + r1
            java.util.ArrayList r2 = new java.util.ArrayList
            r3 = 20
            r2.<init>(r3)
            java.util.ArrayList r4 = new java.util.ArrayList
            r4.<init>(r3)
        L12:
            int r3 = r9.next()
            if (r3 == r1) goto L8a
            int r5 = r9.getDepth()
            if (r5 >= r0) goto L21
            r6 = 3
            if (r3 == r6) goto L8a
        L21:
            r6 = 2
            if (r3 == r6) goto L25
            goto L12
        L25:
            if (r5 > r0) goto L12
            java.lang.String r3 = r9.getName()
            java.lang.String r5 = "item"
            boolean r3 = r3.equals(r5)
            if (r3 != 0) goto L34
            goto L12
        L34:
            int[] r3 = a.b.a.c.GradientColorItem
            android.content.res.TypedArray r3 = a.b.g.b.g.g.a(r8, r11, r10, r3)
            int r5 = a.b.a.c.GradientColorItem_android_color
            boolean r5 = r3.hasValue(r5)
            int r6 = a.b.a.c.GradientColorItem_android_offset
            boolean r6 = r3.hasValue(r6)
            if (r5 == 0) goto L6a
            if (r6 == 0) goto L6a
            int r5 = a.b.a.c.GradientColorItem_android_color
            r6 = 0
            int r5 = r3.getColor(r5, r6)
            int r6 = a.b.a.c.GradientColorItem_android_offset
            r7 = 0
            float r6 = r3.getFloat(r6, r7)
            r3.recycle()
            java.lang.Integer r3 = java.lang.Integer.valueOf(r5)
            r4.add(r3)
            java.lang.Float r3 = java.lang.Float.valueOf(r6)
            r2.add(r3)
            goto L12
        L6a:
            org.xmlpull.v1.XmlPullParserException r8 = new org.xmlpull.v1.XmlPullParserException
            java.lang.StringBuilder r10 = new java.lang.StringBuilder
            r10.<init>()
            java.lang.String r9 = r9.getPositionDescription()
            r10.append(r9)
            java.lang.String r9 = ": <item> tag requires a 'color' attribute and a 'offset' "
            r10.append(r9)
            java.lang.String r9 = "attribute!"
            r10.append(r9)
            java.lang.String r9 = r10.toString()
            r8.<init>(r9)
            throw r8
        L8a:
            int r8 = r4.size()
            if (r8 <= 0) goto L96
            a.b.g.b.g.d$a r8 = new a.b.g.b.g.d$a
            r8.<init>(r4, r2)
            return r8
        L96:
            r8 = 0
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: a.b.g.b.g.d.b(android.content.res.Resources, org.xmlpull.v1.XmlPullParser, android.util.AttributeSet, android.content.res.Resources$Theme):a.b.g.b.g.d$a");
    }

    /* compiled from: GradientColorInflaterCompat.java */
    /* loaded from: classes.dex */
    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        public final int[] f897a;

        /* renamed from: b  reason: collision with root package name */
        public final float[] f898b;

        public a(List<Integer> list, List<Float> list2) {
            int size = list.size();
            this.f897a = new int[size];
            this.f898b = new float[size];
            for (int i2 = 0; i2 < size; i2++) {
                this.f897a[i2] = list.get(i2).intValue();
                this.f898b[i2] = list2.get(i2).floatValue();
            }
        }

        public a(int i2, int i3) {
            this.f897a = new int[]{i2, i3};
            this.f898b = new float[]{0.0f, 1.0f};
        }

        public a(int i2, int i3, int i4) {
            this.f897a = new int[]{i2, i3, i4};
            this.f898b = new float[]{0.0f, 0.5f, 1.0f};
        }
    }

    public static a a(a aVar, int i2, int i3, boolean z, int i4) {
        if (aVar != null) {
            return aVar;
        }
        if (z) {
            return new a(i2, i4, i3);
        }
        return new a(i2, i3);
    }

    public static Shader.TileMode a(int i2) {
        if (i2 != 1) {
            if (i2 != 2) {
                return Shader.TileMode.CLAMP;
            }
            return Shader.TileMode.MIRROR;
        }
        return Shader.TileMode.REPEAT;
    }
}
