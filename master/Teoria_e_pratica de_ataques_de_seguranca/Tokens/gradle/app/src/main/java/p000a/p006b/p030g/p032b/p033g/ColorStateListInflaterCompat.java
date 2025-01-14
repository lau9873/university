package p000a.p006b.p030g.p032b.p033g;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.util.AttributeSet;
import android.util.StateSet;
import android.util.Xml;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import p000a.p006b.p007a.C0018c;
import p000a.p006b.p007a.R;

/* renamed from: a.b.g.b.g.a */
/* loaded from: classes.dex */
public final class ColorStateListInflaterCompat {
    /* renamed from: a */
    public static ColorStateList m9992a(Resources resources, XmlPullParser xmlPullParser, Resources.Theme theme) {
        int next;
        AttributeSet asAttributeSet = Xml.asAttributeSet(xmlPullParser);
        do {
            next = xmlPullParser.next();
            if (next == 2) {
                break;
            }
        } while (next != 1);
        if (next == 2) {
            return m9991a(resources, xmlPullParser, asAttributeSet, theme);
        }
        throw new XmlPullParserException("No start tag found");
    }

    /* renamed from: b */
    public static ColorStateList m9990b(Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) {
        int depth;
        int i = 1;
        int depth2 = xmlPullParser.getDepth() + 1;
        int[][] iArr = new int[20];
        int[] iArr2 = new int[iArr.length];
        int i2 = 0;
        while (true) {
            int next = xmlPullParser.next();
            if (next == i || ((depth = xmlPullParser.getDepth()) < depth2 && next == 3)) {
                break;
            }
            if (next == 2 && depth <= depth2 && xmlPullParser.getName().equals("item")) {
                TypedArray m9993a = m9993a(resources, theme, attributeSet, C0018c.ColorStateListItem);
                int color = m9993a.getColor(C0018c.ColorStateListItem_android_color, -65281);
                float f = 1.0f;
                if (m9993a.hasValue(C0018c.ColorStateListItem_android_alpha)) {
                    f = m9993a.getFloat(C0018c.ColorStateListItem_android_alpha, 1.0f);
                } else if (m9993a.hasValue(C0018c.ColorStateListItem_alpha)) {
                    f = m9993a.getFloat(C0018c.ColorStateListItem_alpha, 1.0f);
                }
                m9993a.recycle();
                int attributeCount = attributeSet.getAttributeCount();
                int[] iArr3 = new int[attributeCount];
                int i3 = 0;
                for (int i4 = 0; i4 < attributeCount; i4++) {
                    int attributeNameResource = attributeSet.getAttributeNameResource(i4);
                    if (attributeNameResource != 16843173 && attributeNameResource != 16843551 && attributeNameResource != R.alpha) {
                        int i5 = i3 + 1;
                        if (!attributeSet.getAttributeBooleanValue(i4, false)) {
                            attributeNameResource = -attributeNameResource;
                        }
                        iArr3[i3] = attributeNameResource;
                        i3 = i5;
                    }
                }
                int[] trimStateSet = StateSet.trimStateSet(iArr3, i3);
                int m9994a = m9994a(color, f);
                if (i2 != 0) {
                    int length = trimStateSet.length;
                }
                iArr2 = GrowingArrayUtils.m9954a(iArr2, i2, m9994a);
                iArr = (int[][]) GrowingArrayUtils.m9953a(iArr, i2, trimStateSet);
                i2++;
            }
            i = 1;
        }
        int[] iArr4 = new int[i2];
        int[][] iArr5 = new int[i2];
        System.arraycopy(iArr2, 0, iArr4, 0, i2);
        System.arraycopy(iArr, 0, iArr5, 0, i2);
        return new ColorStateList(iArr5, iArr4);
    }

    /* renamed from: a */
    public static ColorStateList m9991a(Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) {
        String name = xmlPullParser.getName();
        if (name.equals("selector")) {
            return m9990b(resources, xmlPullParser, attributeSet, theme);
        }
        throw new XmlPullParserException(xmlPullParser.getPositionDescription() + ": invalid color state list tag " + name);
    }

    /* renamed from: a */
    public static TypedArray m9993a(Resources resources, Resources.Theme theme, AttributeSet attributeSet, int[] iArr) {
        if (theme == null) {
            return resources.obtainAttributes(attributeSet, iArr);
        }
        return theme.obtainStyledAttributes(attributeSet, iArr, 0, 0);
    }

    /* renamed from: a */
    public static int m9994a(int i, float f) {
        return (i & 16777215) | (Math.round(Color.alpha(i) * f) << 24);
    }
}
