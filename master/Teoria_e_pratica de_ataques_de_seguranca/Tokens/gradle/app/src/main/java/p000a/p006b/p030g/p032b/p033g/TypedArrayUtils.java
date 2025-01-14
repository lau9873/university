package p000a.p006b.p030g.p032b.p033g;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.TypedValue;
import org.xmlpull.v1.XmlPullParser;

/* renamed from: a.b.g.b.g.g */
/* loaded from: classes.dex */
public class TypedArrayUtils {
    /* renamed from: a */
    public static boolean m9936a(XmlPullParser xmlPullParser, String str) {
        return xmlPullParser.getAttributeValue("http://schemas.android.com/apk/res/android", str) != null;
    }

    /* renamed from: b */
    public static int m9932b(TypedArray typedArray, XmlPullParser xmlPullParser, String str, int i, int i2) {
        return !m9936a(xmlPullParser, str) ? i2 : typedArray.getInt(i, i2);
    }

    /* renamed from: c */
    public static int m9930c(TypedArray typedArray, XmlPullParser xmlPullParser, String str, int i, int i2) {
        return !m9936a(xmlPullParser, str) ? i2 : typedArray.getResourceId(i, i2);
    }

    /* renamed from: d */
    public static CharSequence[] m9929d(TypedArray typedArray, int i, int i2) {
        CharSequence[] textArray = typedArray.getTextArray(i);
        return textArray == null ? typedArray.getTextArray(i2) : textArray;
    }

    /* renamed from: a */
    public static float m9939a(TypedArray typedArray, XmlPullParser xmlPullParser, String str, int i, float f) {
        return !m9936a(xmlPullParser, str) ? f : typedArray.getFloat(i, f);
    }

    /* renamed from: b */
    public static TypedValue m9933b(TypedArray typedArray, XmlPullParser xmlPullParser, String str, int i) {
        if (m9936a(xmlPullParser, str)) {
            return typedArray.peekValue(i);
        }
        return null;
    }

    /* renamed from: c */
    public static CharSequence m9931c(TypedArray typedArray, int i, int i2) {
        CharSequence text = typedArray.getText(i);
        return text == null ? typedArray.getText(i2) : text;
    }

    /* renamed from: a */
    public static boolean m9937a(TypedArray typedArray, XmlPullParser xmlPullParser, String str, int i, boolean z) {
        return !m9936a(xmlPullParser, str) ? z : typedArray.getBoolean(i, z);
    }

    /* renamed from: b */
    public static int m9934b(TypedArray typedArray, int i, int i2, int i3) {
        return typedArray.getResourceId(i, typedArray.getResourceId(i2, i3));
    }

    /* renamed from: a */
    public static int m9938a(TypedArray typedArray, XmlPullParser xmlPullParser, String str, int i, int i2) {
        return !m9936a(xmlPullParser, str) ? i2 : typedArray.getColor(i, i2);
    }

    /* renamed from: b */
    public static String m9935b(TypedArray typedArray, int i, int i2) {
        String string = typedArray.getString(i);
        return string == null ? typedArray.getString(i2) : string;
    }

    /* renamed from: a */
    public static ComplexColorCompat m9941a(TypedArray typedArray, XmlPullParser xmlPullParser, Resources.Theme theme, String str, int i, int i2) {
        if (m9936a(xmlPullParser, str)) {
            TypedValue typedValue = new TypedValue();
            typedArray.getValue(i, typedValue);
            int i3 = typedValue.type;
            if (i3 >= 28 && i3 <= 31) {
                return ComplexColorCompat.m9982b(typedValue.data);
            }
            ComplexColorCompat m9981b = ComplexColorCompat.m9981b(typedArray.getResources(), typedArray.getResourceId(i, 0), theme);
            if (m9981b != null) {
                return m9981b;
            }
        }
        return ComplexColorCompat.m9982b(i2);
    }

    /* renamed from: a */
    public static String m9940a(TypedArray typedArray, XmlPullParser xmlPullParser, String str, int i) {
        if (m9936a(xmlPullParser, str)) {
            return typedArray.getString(i);
        }
        return null;
    }

    /* renamed from: a */
    public static TypedArray m9945a(Resources resources, Resources.Theme theme, AttributeSet attributeSet, int[] iArr) {
        if (theme == null) {
            return resources.obtainAttributes(attributeSet, iArr);
        }
        return theme.obtainStyledAttributes(attributeSet, iArr, 0, 0);
    }

    /* renamed from: a */
    public static boolean m9942a(TypedArray typedArray, int i, int i2, boolean z) {
        return typedArray.getBoolean(i, typedArray.getBoolean(i2, z));
    }

    /* renamed from: a */
    public static Drawable m9944a(TypedArray typedArray, int i, int i2) {
        Drawable drawable = typedArray.getDrawable(i);
        return drawable == null ? typedArray.getDrawable(i2) : drawable;
    }

    /* renamed from: a */
    public static int m9943a(TypedArray typedArray, int i, int i2, int i3) {
        return typedArray.getInt(i, typedArray.getInt(i2, i3));
    }

    /* renamed from: a */
    public static int m9946a(Context context, int i, int i2) {
        TypedValue typedValue = new TypedValue();
        context.getTheme().resolveAttribute(i, typedValue, true);
        return typedValue.resourceId != 0 ? i : i2;
    }
}
