package a.b.g.b.g;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.TypedValue;
import org.xmlpull.v1.XmlPullParser;
/* compiled from: TypedArrayUtils.java */
/* loaded from: classes.dex */
public class g {
    public static boolean a(XmlPullParser xmlPullParser, String str) {
        return xmlPullParser.getAttributeValue("http://schemas.android.com/apk/res/android", str) != null;
    }

    public static int b(TypedArray typedArray, XmlPullParser xmlPullParser, String str, int i2, int i3) {
        return !a(xmlPullParser, str) ? i3 : typedArray.getInt(i2, i3);
    }

    public static int c(TypedArray typedArray, XmlPullParser xmlPullParser, String str, int i2, int i3) {
        return !a(xmlPullParser, str) ? i3 : typedArray.getResourceId(i2, i3);
    }

    public static CharSequence[] d(TypedArray typedArray, int i2, int i3) {
        CharSequence[] textArray = typedArray.getTextArray(i2);
        return textArray == null ? typedArray.getTextArray(i3) : textArray;
    }

    public static float a(TypedArray typedArray, XmlPullParser xmlPullParser, String str, int i2, float f2) {
        return !a(xmlPullParser, str) ? f2 : typedArray.getFloat(i2, f2);
    }

    public static TypedValue b(TypedArray typedArray, XmlPullParser xmlPullParser, String str, int i2) {
        if (a(xmlPullParser, str)) {
            return typedArray.peekValue(i2);
        }
        return null;
    }

    public static CharSequence c(TypedArray typedArray, int i2, int i3) {
        CharSequence text = typedArray.getText(i2);
        return text == null ? typedArray.getText(i3) : text;
    }

    public static boolean a(TypedArray typedArray, XmlPullParser xmlPullParser, String str, int i2, boolean z) {
        return !a(xmlPullParser, str) ? z : typedArray.getBoolean(i2, z);
    }

    public static int b(TypedArray typedArray, int i2, int i3, int i4) {
        return typedArray.getResourceId(i2, typedArray.getResourceId(i3, i4));
    }

    public static int a(TypedArray typedArray, XmlPullParser xmlPullParser, String str, int i2, int i3) {
        return !a(xmlPullParser, str) ? i3 : typedArray.getColor(i2, i3);
    }

    public static String b(TypedArray typedArray, int i2, int i3) {
        String string = typedArray.getString(i2);
        return string == null ? typedArray.getString(i3) : string;
    }

    public static b a(TypedArray typedArray, XmlPullParser xmlPullParser, Resources.Theme theme, String str, int i2, int i3) {
        if (a(xmlPullParser, str)) {
            TypedValue typedValue = new TypedValue();
            typedArray.getValue(i2, typedValue);
            int i4 = typedValue.type;
            if (i4 >= 28 && i4 <= 31) {
                return b.b(typedValue.data);
            }
            b b2 = b.b(typedArray.getResources(), typedArray.getResourceId(i2, 0), theme);
            if (b2 != null) {
                return b2;
            }
        }
        return b.b(i3);
    }

    public static String a(TypedArray typedArray, XmlPullParser xmlPullParser, String str, int i2) {
        if (a(xmlPullParser, str)) {
            return typedArray.getString(i2);
        }
        return null;
    }

    public static TypedArray a(Resources resources, Resources.Theme theme, AttributeSet attributeSet, int[] iArr) {
        if (theme == null) {
            return resources.obtainAttributes(attributeSet, iArr);
        }
        return theme.obtainStyledAttributes(attributeSet, iArr, 0, 0);
    }

    public static boolean a(TypedArray typedArray, int i2, int i3, boolean z) {
        return typedArray.getBoolean(i2, typedArray.getBoolean(i3, z));
    }

    public static Drawable a(TypedArray typedArray, int i2, int i3) {
        Drawable drawable = typedArray.getDrawable(i2);
        return drawable == null ? typedArray.getDrawable(i3) : drawable;
    }

    public static int a(TypedArray typedArray, int i2, int i3, int i4) {
        return typedArray.getInt(i2, typedArray.getInt(i3, i4));
    }

    public static int a(Context context, int i2, int i3) {
        TypedValue typedValue = new TypedValue();
        context.getTheme().resolveAttribute(i2, typedValue, true);
        return typedValue.resourceId != 0 ? i2 : i3;
    }
}
