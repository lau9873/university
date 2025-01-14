package p000a.p006b.p030g.p032b.p033g;

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
import p000a.p006b.p007a.C0018c;

/* renamed from: a.b.g.b.g.d */
/* loaded from: classes.dex */
public final class GradientColorInflaterCompat {
    /* renamed from: a */
    public static Shader m9957a(Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) {
        String name = xmlPullParser.getName();
        if (name.equals("gradient")) {
            TypedArray m9945a = TypedArrayUtils.m9945a(resources, theme, attributeSet, C0018c.GradientColor);
            float m9939a = TypedArrayUtils.m9939a(m9945a, xmlPullParser, "startX", C0018c.GradientColor_android_startX, 0.0f);
            float m9939a2 = TypedArrayUtils.m9939a(m9945a, xmlPullParser, "startY", C0018c.GradientColor_android_startY, 0.0f);
            float m9939a3 = TypedArrayUtils.m9939a(m9945a, xmlPullParser, "endX", C0018c.GradientColor_android_endX, 0.0f);
            float m9939a4 = TypedArrayUtils.m9939a(m9945a, xmlPullParser, "endY", C0018c.GradientColor_android_endY, 0.0f);
            float m9939a5 = TypedArrayUtils.m9939a(m9945a, xmlPullParser, "centerX", C0018c.GradientColor_android_centerX, 0.0f);
            float m9939a6 = TypedArrayUtils.m9939a(m9945a, xmlPullParser, "centerY", C0018c.GradientColor_android_centerY, 0.0f);
            int m9932b = TypedArrayUtils.m9932b(m9945a, xmlPullParser, "type", C0018c.GradientColor_android_type, 0);
            int m9938a = TypedArrayUtils.m9938a(m9945a, xmlPullParser, "startColor", C0018c.GradientColor_android_startColor, 0);
            boolean m9936a = TypedArrayUtils.m9936a(xmlPullParser, "centerColor");
            int m9938a2 = TypedArrayUtils.m9938a(m9945a, xmlPullParser, "centerColor", C0018c.GradientColor_android_centerColor, 0);
            int m9938a3 = TypedArrayUtils.m9938a(m9945a, xmlPullParser, "endColor", C0018c.GradientColor_android_endColor, 0);
            int m9932b2 = TypedArrayUtils.m9932b(m9945a, xmlPullParser, "tileMode", C0018c.GradientColor_android_tileMode, 0);
            float m9939a7 = TypedArrayUtils.m9939a(m9945a, xmlPullParser, "gradientRadius", C0018c.GradientColor_android_gradientRadius, 0.0f);
            m9945a.recycle();
            C0209a m9958a = m9958a(m9956b(resources, xmlPullParser, attributeSet, theme), m9938a, m9938a3, m9936a, m9938a2);
            if (m9932b != 1) {
                if (m9932b != 2) {
                    return new LinearGradient(m9939a, m9939a2, m9939a3, m9939a4, m9958a.f1403a, m9958a.f1404b, m9959a(m9932b2));
                }
                return new SweepGradient(m9939a5, m9939a6, m9958a.f1403a, m9958a.f1404b);
            } else if (m9939a7 > 0.0f) {
                return new RadialGradient(m9939a5, m9939a6, m9939a7, m9958a.f1403a, m9958a.f1404b, m9959a(m9932b2));
            } else {
                throw new XmlPullParserException("<gradient> tag requires 'gradientRadius' attribute with radial type");
            }
        }
        throw new XmlPullParserException(xmlPullParser.getPositionDescription() + ": invalid gradient color tag " + name);
    }

    /* JADX WARN: Code restructure failed: missing block: B:21:0x0089, code lost:
        throw new org.xmlpull.v1.XmlPullParserException(r9.getPositionDescription() + ": <item> tag requires a 'color' attribute and a 'offset' attribute!");
     */
    /* renamed from: b */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static p000a.p006b.p030g.p032b.p033g.GradientColorInflaterCompat.C0209a m9956b(android.content.res.Resources r8, org.xmlpull.v1.XmlPullParser r9, android.util.AttributeSet r10, android.content.res.Resources.Theme r11) {
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
            int[] r3 = p000a.p006b.p007a.C0018c.GradientColorItem
            android.content.res.TypedArray r3 = p000a.p006b.p030g.p032b.p033g.TypedArrayUtils.m9945a(r8, r11, r10, r3)
            int r5 = p000a.p006b.p007a.C0018c.GradientColorItem_android_color
            boolean r5 = r3.hasValue(r5)
            int r6 = p000a.p006b.p007a.C0018c.GradientColorItem_android_offset
            boolean r6 = r3.hasValue(r6)
            if (r5 == 0) goto L6a
            if (r6 == 0) goto L6a
            int r5 = p000a.p006b.p007a.C0018c.GradientColorItem_android_color
            r6 = 0
            int r5 = r3.getColor(r5, r6)
            int r6 = p000a.p006b.p007a.C0018c.GradientColorItem_android_offset
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
        throw new UnsupportedOperationException("Method not decompiled: p000a.p006b.p030g.p032b.p033g.GradientColorInflaterCompat.m9956b(android.content.res.Resources, org.xmlpull.v1.XmlPullParser, android.util.AttributeSet, android.content.res.Resources$Theme):a.b.g.b.g.d$a");
    }

    /* compiled from: GradientColorInflaterCompat.java */
    /* renamed from: a.b.g.b.g.d$a */
    /* loaded from: classes.dex */
    public static final class C0209a {

        /* renamed from: a */
        public final int[] f1403a;

        /* renamed from: b */
        public final float[] f1404b;

        public C0209a(List<Integer> list, List<Float> list2) {
            int size = list.size();
            this.f1403a = new int[size];
            this.f1404b = new float[size];
            for (int i = 0; i < size; i++) {
                this.f1403a[i] = list.get(i).intValue();
                this.f1404b[i] = list2.get(i).floatValue();
            }
        }

        public C0209a(int i, int i2) {
            this.f1403a = new int[]{i, i2};
            this.f1404b = new float[]{0.0f, 1.0f};
        }

        public C0209a(int i, int i2, int i3) {
            this.f1403a = new int[]{i, i2, i3};
            this.f1404b = new float[]{0.0f, 0.5f, 1.0f};
        }
    }

    /* renamed from: a */
    public static C0209a m9958a(C0209a c0209a, int i, int i2, boolean z, int i3) {
        if (c0209a != null) {
            return c0209a;
        }
        if (z) {
            return new C0209a(i, i3, i2);
        }
        return new C0209a(i, i2);
    }

    /* renamed from: a */
    public static Shader.TileMode m9959a(int i) {
        if (i != 1) {
            if (i != 2) {
                return Shader.TileMode.CLAMP;
            }
            return Shader.TileMode.MIRROR;
        }
        return Shader.TileMode.REPEAT;
    }
}
