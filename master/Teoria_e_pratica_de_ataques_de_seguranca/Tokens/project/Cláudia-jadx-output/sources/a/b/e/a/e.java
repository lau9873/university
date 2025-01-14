package a.b.e.a;

import a.b.g.c.b;
import android.animation.Animator;
import android.animation.AnimatorInflater;
import android.animation.Keyframe;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.animation.TypeEvaluator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.graphics.Path;
import android.graphics.PathMeasure;
import android.os.Build;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.util.Xml;
import android.view.InflateException;
import java.io.IOException;
import java.util.ArrayList;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
/* compiled from: AnimatorInflaterCompat.java */
/* loaded from: classes.dex */
public class e {

    /* compiled from: AnimatorInflaterCompat.java */
    /* loaded from: classes.dex */
    public static class a implements TypeEvaluator<b.C0022b[]> {

        /* renamed from: a  reason: collision with root package name */
        public b.C0022b[] f429a;

        @Override // android.animation.TypeEvaluator
        /* renamed from: a */
        public b.C0022b[] evaluate(float f2, b.C0022b[] c0022bArr, b.C0022b[] c0022bArr2) {
            if (a.b.g.c.b.a(c0022bArr, c0022bArr2)) {
                b.C0022b[] c0022bArr3 = this.f429a;
                if (c0022bArr3 == null || !a.b.g.c.b.a(c0022bArr3, c0022bArr)) {
                    this.f429a = a.b.g.c.b.a(c0022bArr);
                }
                for (int i2 = 0; i2 < c0022bArr.length; i2++) {
                    this.f429a[i2].a(c0022bArr[i2], c0022bArr2[i2], f2);
                }
                return this.f429a;
            }
            throw new IllegalArgumentException("Can't interpolate between two incompatible pathData");
        }
    }

    public static Animator a(Context context, int i2) {
        if (Build.VERSION.SDK_INT >= 24) {
            return AnimatorInflater.loadAnimator(context, i2);
        }
        return a(context, context.getResources(), context.getTheme(), i2);
    }

    public static boolean a(int i2) {
        return i2 >= 28 && i2 <= 31;
    }

    public static Animator a(Context context, Resources resources, Resources.Theme theme, int i2) {
        return a(context, resources, theme, i2, 1.0f);
    }

    public static Animator a(Context context, Resources resources, Resources.Theme theme, int i2, float f2) {
        XmlResourceParser xmlResourceParser = null;
        try {
            try {
                try {
                    xmlResourceParser = resources.getAnimation(i2);
                    return a(context, resources, theme, xmlResourceParser, f2);
                } catch (XmlPullParserException e2) {
                    Resources.NotFoundException notFoundException = new Resources.NotFoundException("Can't load animation resource ID #0x" + Integer.toHexString(i2));
                    notFoundException.initCause(e2);
                    throw notFoundException;
                }
            } catch (IOException e3) {
                Resources.NotFoundException notFoundException2 = new Resources.NotFoundException("Can't load animation resource ID #0x" + Integer.toHexString(i2));
                notFoundException2.initCause(e3);
                throw notFoundException2;
            }
        } finally {
            if (xmlResourceParser != null) {
                xmlResourceParser.close();
            }
        }
    }

    public static PropertyValuesHolder a(TypedArray typedArray, int i2, int i3, int i4, String str) {
        int i5;
        int i6;
        int i7;
        float f2;
        PropertyValuesHolder ofFloat;
        float f3;
        float f4;
        PropertyValuesHolder ofObject;
        TypedValue peekValue = typedArray.peekValue(i3);
        boolean z = peekValue != null;
        int i8 = z ? peekValue.type : 0;
        TypedValue peekValue2 = typedArray.peekValue(i4);
        boolean z2 = peekValue2 != null;
        int i9 = z2 ? peekValue2.type : 0;
        if (i2 == 4) {
            i2 = ((z && a(i8)) || (z2 && a(i9))) ? 3 : 0;
        }
        boolean z3 = i2 == 0;
        PropertyValuesHolder propertyValuesHolder = null;
        if (i2 == 2) {
            String string = typedArray.getString(i3);
            String string2 = typedArray.getString(i4);
            b.C0022b[] a2 = a.b.g.c.b.a(string);
            b.C0022b[] a3 = a.b.g.c.b.a(string2);
            if (a2 == null && a3 == null) {
                return null;
            }
            if (a2 == null) {
                if (a3 != null) {
                    return PropertyValuesHolder.ofObject(str, new a(), a3);
                }
                return null;
            }
            a aVar = new a();
            if (a3 != null) {
                if (a.b.g.c.b.a(a2, a3)) {
                    ofObject = PropertyValuesHolder.ofObject(str, aVar, a2, a3);
                } else {
                    throw new InflateException(" Can't morph from " + string + " to " + string2);
                }
            } else {
                ofObject = PropertyValuesHolder.ofObject(str, aVar, a2);
            }
            return ofObject;
        }
        f a4 = i2 == 3 ? f.a() : null;
        if (z3) {
            if (z) {
                if (i8 == 5) {
                    f3 = typedArray.getDimension(i3, 0.0f);
                } else {
                    f3 = typedArray.getFloat(i3, 0.0f);
                }
                if (z2) {
                    if (i9 == 5) {
                        f4 = typedArray.getDimension(i4, 0.0f);
                    } else {
                        f4 = typedArray.getFloat(i4, 0.0f);
                    }
                    ofFloat = PropertyValuesHolder.ofFloat(str, f3, f4);
                } else {
                    ofFloat = PropertyValuesHolder.ofFloat(str, f3);
                }
            } else {
                if (i9 == 5) {
                    f2 = typedArray.getDimension(i4, 0.0f);
                } else {
                    f2 = typedArray.getFloat(i4, 0.0f);
                }
                ofFloat = PropertyValuesHolder.ofFloat(str, f2);
            }
            propertyValuesHolder = ofFloat;
        } else if (z) {
            if (i8 == 5) {
                i6 = (int) typedArray.getDimension(i3, 0.0f);
            } else if (a(i8)) {
                i6 = typedArray.getColor(i3, 0);
            } else {
                i6 = typedArray.getInt(i3, 0);
            }
            if (z2) {
                if (i9 == 5) {
                    i7 = (int) typedArray.getDimension(i4, 0.0f);
                } else if (a(i9)) {
                    i7 = typedArray.getColor(i4, 0);
                } else {
                    i7 = typedArray.getInt(i4, 0);
                }
                propertyValuesHolder = PropertyValuesHolder.ofInt(str, i6, i7);
            } else {
                propertyValuesHolder = PropertyValuesHolder.ofInt(str, i6);
            }
        } else if (z2) {
            if (i9 == 5) {
                i5 = (int) typedArray.getDimension(i4, 0.0f);
            } else if (a(i9)) {
                i5 = typedArray.getColor(i4, 0);
            } else {
                i5 = typedArray.getInt(i4, 0);
            }
            propertyValuesHolder = PropertyValuesHolder.ofInt(str, i5);
        }
        if (propertyValuesHolder == null || a4 == null) {
            return propertyValuesHolder;
        }
        propertyValuesHolder.setEvaluator(a4);
        return propertyValuesHolder;
    }

    public static void a(ValueAnimator valueAnimator, TypedArray typedArray, TypedArray typedArray2, float f2, XmlPullParser xmlPullParser) {
        long b2 = a.b.g.b.g.g.b(typedArray, xmlPullParser, "duration", 1, 300);
        long b3 = a.b.g.b.g.g.b(typedArray, xmlPullParser, "startOffset", 2, 0);
        int b4 = a.b.g.b.g.g.b(typedArray, xmlPullParser, "valueType", 7, 4);
        if (a.b.g.b.g.g.a(xmlPullParser, "valueFrom") && a.b.g.b.g.g.a(xmlPullParser, "valueTo")) {
            if (b4 == 4) {
                b4 = a(typedArray, 5, 6);
            }
            PropertyValuesHolder a2 = a(typedArray, b4, 5, 6, "");
            if (a2 != null) {
                valueAnimator.setValues(a2);
            }
        }
        valueAnimator.setDuration(b2);
        valueAnimator.setStartDelay(b3);
        valueAnimator.setRepeatCount(a.b.g.b.g.g.b(typedArray, xmlPullParser, "repeatCount", 3, 0));
        valueAnimator.setRepeatMode(a.b.g.b.g.g.b(typedArray, xmlPullParser, "repeatMode", 4, 1));
        if (typedArray2 != null) {
            a(valueAnimator, typedArray2, b4, f2, xmlPullParser);
        }
    }

    public static void a(ValueAnimator valueAnimator, TypedArray typedArray, int i2, float f2, XmlPullParser xmlPullParser) {
        ObjectAnimator objectAnimator = (ObjectAnimator) valueAnimator;
        String a2 = a.b.g.b.g.g.a(typedArray, xmlPullParser, "pathData", 1);
        if (a2 != null) {
            String a3 = a.b.g.b.g.g.a(typedArray, xmlPullParser, "propertyXName", 2);
            String a4 = a.b.g.b.g.g.a(typedArray, xmlPullParser, "propertyYName", 3);
            if (i2 != 2) {
            }
            if (a3 == null && a4 == null) {
                throw new InflateException(typedArray.getPositionDescription() + " propertyXName or propertyYName is needed for PathData");
            }
            a(a.b.g.c.b.b(a2), objectAnimator, f2 * 0.5f, a3, a4);
            return;
        }
        objectAnimator.setPropertyName(a.b.g.b.g.g.a(typedArray, xmlPullParser, "propertyName", 0));
    }

    public static void a(Path path, ObjectAnimator objectAnimator, float f2, String str, String str2) {
        PathMeasure pathMeasure = new PathMeasure(path, false);
        ArrayList arrayList = new ArrayList();
        arrayList.add(Float.valueOf(0.0f));
        float f3 = 0.0f;
        do {
            f3 += pathMeasure.getLength();
            arrayList.add(Float.valueOf(f3));
        } while (pathMeasure.nextContour());
        PathMeasure pathMeasure2 = new PathMeasure(path, false);
        int min = Math.min(100, ((int) (f3 / f2)) + 1);
        float[] fArr = new float[min];
        float[] fArr2 = new float[min];
        float[] fArr3 = new float[2];
        float f4 = f3 / (min - 1);
        int i2 = 0;
        float f5 = 0.0f;
        int i3 = 0;
        while (true) {
            if (i2 >= min) {
                break;
            }
            pathMeasure2.getPosTan(f5 - ((Float) arrayList.get(i3)).floatValue(), fArr3, null);
            fArr[i2] = fArr3[0];
            fArr2[i2] = fArr3[1];
            f5 += f4;
            int i4 = i3 + 1;
            if (i4 < arrayList.size() && f5 > ((Float) arrayList.get(i4)).floatValue()) {
                pathMeasure2.nextContour();
                i3 = i4;
            }
            i2++;
        }
        PropertyValuesHolder ofFloat = str != null ? PropertyValuesHolder.ofFloat(str, fArr) : null;
        PropertyValuesHolder ofFloat2 = str2 != null ? PropertyValuesHolder.ofFloat(str2, fArr2) : null;
        if (ofFloat == null) {
            objectAnimator.setValues(ofFloat2);
        } else if (ofFloat2 == null) {
            objectAnimator.setValues(ofFloat);
        } else {
            objectAnimator.setValues(ofFloat, ofFloat2);
        }
    }

    public static Animator a(Context context, Resources resources, Resources.Theme theme, XmlPullParser xmlPullParser, float f2) {
        return a(context, resources, theme, xmlPullParser, Xml.asAttributeSet(xmlPullParser), null, 0, f2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:34:0x00ba  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static android.animation.Animator a(android.content.Context r18, android.content.res.Resources r19, android.content.res.Resources.Theme r20, org.xmlpull.v1.XmlPullParser r21, android.util.AttributeSet r22, android.animation.AnimatorSet r23, int r24, float r25) {
        /*
            Method dump skipped, instructions count: 265
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: a.b.e.a.e.a(android.content.Context, android.content.res.Resources, android.content.res.Resources$Theme, org.xmlpull.v1.XmlPullParser, android.util.AttributeSet, android.animation.AnimatorSet, int, float):android.animation.Animator");
    }

    public static PropertyValuesHolder[] a(Context context, Resources resources, Resources.Theme theme, XmlPullParser xmlPullParser, AttributeSet attributeSet) {
        int i2;
        PropertyValuesHolder[] propertyValuesHolderArr = null;
        ArrayList arrayList = null;
        while (true) {
            int eventType = xmlPullParser.getEventType();
            if (eventType == 3 || eventType == 1) {
                break;
            } else if (eventType != 2) {
                xmlPullParser.next();
            } else {
                if (xmlPullParser.getName().equals("propertyValuesHolder")) {
                    TypedArray a2 = a.b.g.b.g.g.a(resources, theme, attributeSet, a.b.e.a.a.f417i);
                    String a3 = a.b.g.b.g.g.a(a2, xmlPullParser, "propertyName", 3);
                    int b2 = a.b.g.b.g.g.b(a2, xmlPullParser, "valueType", 2, 4);
                    PropertyValuesHolder a4 = a(context, resources, theme, xmlPullParser, a3, b2);
                    if (a4 == null) {
                        a4 = a(a2, b2, 0, 1, a3);
                    }
                    if (a4 != null) {
                        if (arrayList == null) {
                            arrayList = new ArrayList();
                        }
                        arrayList.add(a4);
                    }
                    a2.recycle();
                }
                xmlPullParser.next();
            }
        }
        if (arrayList != null) {
            int size = arrayList.size();
            propertyValuesHolderArr = new PropertyValuesHolder[size];
            for (i2 = 0; i2 < size; i2++) {
                propertyValuesHolderArr[i2] = (PropertyValuesHolder) arrayList.get(i2);
            }
        }
        return propertyValuesHolderArr;
    }

    public static int a(Resources resources, Resources.Theme theme, AttributeSet attributeSet, XmlPullParser xmlPullParser) {
        TypedArray a2 = a.b.g.b.g.g.a(resources, theme, attributeSet, a.b.e.a.a.j);
        int i2 = 0;
        TypedValue b2 = a.b.g.b.g.g.b(a2, xmlPullParser, "value", 0);
        if ((b2 != null) && a(b2.type)) {
            i2 = 3;
        }
        a2.recycle();
        return i2;
    }

    public static int a(TypedArray typedArray, int i2, int i3) {
        TypedValue peekValue = typedArray.peekValue(i2);
        boolean z = peekValue != null;
        int i4 = z ? peekValue.type : 0;
        TypedValue peekValue2 = typedArray.peekValue(i3);
        boolean z2 = peekValue2 != null;
        return ((z && a(i4)) || (z2 && a(z2 ? peekValue2.type : 0))) ? 3 : 0;
    }

    public static PropertyValuesHolder a(Context context, Resources resources, Resources.Theme theme, XmlPullParser xmlPullParser, String str, int i2) {
        int size;
        PropertyValuesHolder propertyValuesHolder = null;
        int i3 = i2;
        ArrayList arrayList = null;
        while (true) {
            int next = xmlPullParser.next();
            if (next == 3 || next == 1) {
                break;
            } else if (xmlPullParser.getName().equals("keyframe")) {
                if (i3 == 4) {
                    i3 = a(resources, theme, Xml.asAttributeSet(xmlPullParser), xmlPullParser);
                }
                Keyframe a2 = a(context, resources, theme, Xml.asAttributeSet(xmlPullParser), i3, xmlPullParser);
                if (a2 != null) {
                    if (arrayList == null) {
                        arrayList = new ArrayList();
                    }
                    arrayList.add(a2);
                }
                xmlPullParser.next();
            }
        }
        if (arrayList != null && (size = arrayList.size()) > 0) {
            Keyframe keyframe = (Keyframe) arrayList.get(0);
            Keyframe keyframe2 = (Keyframe) arrayList.get(size - 1);
            float fraction = keyframe2.getFraction();
            if (fraction < 1.0f) {
                if (fraction < 0.0f) {
                    keyframe2.setFraction(1.0f);
                } else {
                    arrayList.add(arrayList.size(), a(keyframe2, 1.0f));
                    size++;
                }
            }
            float fraction2 = keyframe.getFraction();
            if (fraction2 != 0.0f) {
                if (fraction2 < 0.0f) {
                    keyframe.setFraction(0.0f);
                } else {
                    arrayList.add(0, a(keyframe, 0.0f));
                    size++;
                }
            }
            Keyframe[] keyframeArr = new Keyframe[size];
            arrayList.toArray(keyframeArr);
            for (int i4 = 0; i4 < size; i4++) {
                Keyframe keyframe3 = keyframeArr[i4];
                if (keyframe3.getFraction() < 0.0f) {
                    if (i4 == 0) {
                        keyframe3.setFraction(0.0f);
                    } else {
                        int i5 = size - 1;
                        if (i4 == i5) {
                            keyframe3.setFraction(1.0f);
                        } else {
                            int i6 = i4;
                            for (int i7 = i4 + 1; i7 < i5 && keyframeArr[i7].getFraction() < 0.0f; i7++) {
                                i6 = i7;
                            }
                            a(keyframeArr, keyframeArr[i6 + 1].getFraction() - keyframeArr[i4 - 1].getFraction(), i4, i6);
                        }
                    }
                }
            }
            propertyValuesHolder = PropertyValuesHolder.ofKeyframe(str, keyframeArr);
            if (i3 == 3) {
                propertyValuesHolder.setEvaluator(f.a());
            }
        }
        return propertyValuesHolder;
    }

    public static Keyframe a(Keyframe keyframe, float f2) {
        if (keyframe.getType() == Float.TYPE) {
            return Keyframe.ofFloat(f2);
        }
        if (keyframe.getType() == Integer.TYPE) {
            return Keyframe.ofInt(f2);
        }
        return Keyframe.ofObject(f2);
    }

    public static void a(Keyframe[] keyframeArr, float f2, int i2, int i3) {
        float f3 = f2 / ((i3 - i2) + 2);
        while (i2 <= i3) {
            keyframeArr[i2].setFraction(keyframeArr[i2 - 1].getFraction() + f3);
            i2++;
        }
    }

    public static Keyframe a(Context context, Resources resources, Resources.Theme theme, AttributeSet attributeSet, int i2, XmlPullParser xmlPullParser) {
        Keyframe ofInt;
        TypedArray a2 = a.b.g.b.g.g.a(resources, theme, attributeSet, a.b.e.a.a.j);
        float a3 = a.b.g.b.g.g.a(a2, xmlPullParser, "fraction", 3, -1.0f);
        TypedValue b2 = a.b.g.b.g.g.b(a2, xmlPullParser, "value", 0);
        boolean z = b2 != null;
        if (i2 == 4) {
            i2 = (z && a(b2.type)) ? 3 : 0;
        }
        if (z) {
            if (i2 != 0) {
                ofInt = (i2 == 1 || i2 == 3) ? Keyframe.ofInt(a3, a.b.g.b.g.g.b(a2, xmlPullParser, "value", 0, 0)) : null;
            } else {
                ofInt = Keyframe.ofFloat(a3, a.b.g.b.g.g.a(a2, xmlPullParser, "value", 0, 0.0f));
            }
        } else if (i2 == 0) {
            ofInt = Keyframe.ofFloat(a3);
        } else {
            ofInt = Keyframe.ofInt(a3);
        }
        int c2 = a.b.g.b.g.g.c(a2, xmlPullParser, "interpolator", 1, 0);
        if (c2 > 0) {
            ofInt.setInterpolator(d.a(context, c2));
        }
        a2.recycle();
        return ofInt;
    }

    public static ObjectAnimator a(Context context, Resources resources, Resources.Theme theme, AttributeSet attributeSet, float f2, XmlPullParser xmlPullParser) {
        ObjectAnimator objectAnimator = new ObjectAnimator();
        a(context, resources, theme, attributeSet, objectAnimator, f2, xmlPullParser);
        return objectAnimator;
    }

    public static ValueAnimator a(Context context, Resources resources, Resources.Theme theme, AttributeSet attributeSet, ValueAnimator valueAnimator, float f2, XmlPullParser xmlPullParser) {
        TypedArray a2 = a.b.g.b.g.g.a(resources, theme, attributeSet, a.b.e.a.a.f415g);
        TypedArray a3 = a.b.g.b.g.g.a(resources, theme, attributeSet, a.b.e.a.a.k);
        if (valueAnimator == null) {
            valueAnimator = new ValueAnimator();
        }
        a(valueAnimator, a2, a3, f2, xmlPullParser);
        int c2 = a.b.g.b.g.g.c(a2, xmlPullParser, "interpolator", 0, 0);
        if (c2 > 0) {
            valueAnimator.setInterpolator(d.a(context, c2));
        }
        a2.recycle();
        if (a3 != null) {
            a3.recycle();
        }
        return valueAnimator;
    }
}
