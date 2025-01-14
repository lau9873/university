package p000a.p006b.p027e.p028a;

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
import p000a.p006b.p030g.p032b.p033g.TypedArrayUtils;
import p000a.p006b.p030g.p034c.PathParser;

/* renamed from: a.b.e.a.e */
/* loaded from: classes.dex */
public class AnimatorInflaterCompat {

    /* compiled from: AnimatorInflaterCompat.java */
    /* renamed from: a.b.e.a.e$a */
    /* loaded from: classes.dex */
    public static class C0084a implements TypeEvaluator<PathParser.C0214b[]> {

        /* renamed from: a */
        public PathParser.C0214b[] f774a;

        @Override // android.animation.TypeEvaluator
        /* renamed from: a */
        public PathParser.C0214b[] evaluate(float f, PathParser.C0214b[] c0214bArr, PathParser.C0214b[] c0214bArr2) {
            if (PathParser.m9918a(c0214bArr, c0214bArr2)) {
                PathParser.C0214b[] c0214bArr3 = this.f774a;
                if (c0214bArr3 == null || !PathParser.m9918a(c0214bArr3, c0214bArr)) {
                    this.f774a = PathParser.m9919a(c0214bArr);
                }
                for (int i = 0; i < c0214bArr.length; i++) {
                    this.f774a[i].m9914a(c0214bArr[i], c0214bArr2[i], f);
                }
                return this.f774a;
            }
            throw new IllegalArgumentException("Can't interpolate between two incompatible pathData");
        }
    }

    /* renamed from: a */
    public static Animator m10636a(Context context, int i) {
        if (Build.VERSION.SDK_INT >= 24) {
            return AnimatorInflater.loadAnimator(context, i);
        }
        return m10635a(context, context.getResources(), context.getTheme(), i);
    }

    /* renamed from: a */
    public static boolean m10640a(int i) {
        return i >= 28 && i <= 31;
    }

    /* renamed from: a */
    public static Animator m10635a(Context context, Resources resources, Resources.Theme theme, int i) {
        return m10634a(context, resources, theme, i, 1.0f);
    }

    /* renamed from: a */
    public static Animator m10634a(Context context, Resources resources, Resources.Theme theme, int i, float f) {
        XmlResourceParser xmlResourceParser = null;
        try {
            try {
                try {
                    xmlResourceParser = resources.getAnimation(i);
                    return m10630a(context, resources, theme, xmlResourceParser, f);
                } catch (IOException e) {
                    Resources.NotFoundException notFoundException = new Resources.NotFoundException("Can't load animation resource ID #0x" + Integer.toHexString(i));
                    notFoundException.initCause(e);
                    throw notFoundException;
                }
            } catch (XmlPullParserException e2) {
                Resources.NotFoundException notFoundException2 = new Resources.NotFoundException("Can't load animation resource ID #0x" + Integer.toHexString(i));
                notFoundException2.initCause(e2);
                throw notFoundException2;
            }
        } finally {
            if (xmlResourceParser != null) {
                xmlResourceParser.close();
            }
        }
    }

    /* renamed from: a */
    public static PropertyValuesHolder m10624a(TypedArray typedArray, int i, int i2, int i3, String str) {
        int i4;
        int i5;
        int i6;
        float f;
        PropertyValuesHolder ofFloat;
        float f2;
        float f3;
        PropertyValuesHolder ofObject;
        TypedValue peekValue = typedArray.peekValue(i2);
        boolean z = peekValue != null;
        int i7 = z ? peekValue.type : 0;
        TypedValue peekValue2 = typedArray.peekValue(i3);
        boolean z2 = peekValue2 != null;
        int i8 = z2 ? peekValue2.type : 0;
        if (i == 4) {
            i = ((z && m10640a(i7)) || (z2 && m10640a(i8))) ? 3 : 0;
        }
        boolean z3 = i == 0;
        PropertyValuesHolder propertyValuesHolder = null;
        if (i == 2) {
            String string = typedArray.getString(i2);
            String string2 = typedArray.getString(i3);
            PathParser.C0214b[] m9924a = PathParser.m9924a(string);
            PathParser.C0214b[] m9924a2 = PathParser.m9924a(string2);
            if (m9924a == null && m9924a2 == null) {
                return null;
            }
            if (m9924a == null) {
                if (m9924a2 != null) {
                    return PropertyValuesHolder.ofObject(str, new C0084a(), m9924a2);
                }
                return null;
            }
            C0084a c0084a = new C0084a();
            if (m9924a2 != null) {
                if (PathParser.m9918a(m9924a, m9924a2)) {
                    ofObject = PropertyValuesHolder.ofObject(str, c0084a, m9924a, m9924a2);
                } else {
                    throw new InflateException(" Can't morph from " + string + " to " + string2);
                }
            } else {
                ofObject = PropertyValuesHolder.ofObject(str, c0084a, m9924a);
            }
            return ofObject;
        }
        ArgbEvaluator m10620a = i == 3 ? ArgbEvaluator.m10620a() : null;
        if (z3) {
            if (z) {
                if (i7 == 5) {
                    f2 = typedArray.getDimension(i2, 0.0f);
                } else {
                    f2 = typedArray.getFloat(i2, 0.0f);
                }
                if (z2) {
                    if (i8 == 5) {
                        f3 = typedArray.getDimension(i3, 0.0f);
                    } else {
                        f3 = typedArray.getFloat(i3, 0.0f);
                    }
                    ofFloat = PropertyValuesHolder.ofFloat(str, f2, f3);
                } else {
                    ofFloat = PropertyValuesHolder.ofFloat(str, f2);
                }
            } else {
                if (i8 == 5) {
                    f = typedArray.getDimension(i3, 0.0f);
                } else {
                    f = typedArray.getFloat(i3, 0.0f);
                }
                ofFloat = PropertyValuesHolder.ofFloat(str, f);
            }
            propertyValuesHolder = ofFloat;
        } else if (z) {
            if (i7 == 5) {
                i5 = (int) typedArray.getDimension(i2, 0.0f);
            } else if (m10640a(i7)) {
                i5 = typedArray.getColor(i2, 0);
            } else {
                i5 = typedArray.getInt(i2, 0);
            }
            if (z2) {
                if (i8 == 5) {
                    i6 = (int) typedArray.getDimension(i3, 0.0f);
                } else if (m10640a(i8)) {
                    i6 = typedArray.getColor(i3, 0);
                } else {
                    i6 = typedArray.getInt(i3, 0);
                }
                propertyValuesHolder = PropertyValuesHolder.ofInt(str, i5, i6);
            } else {
                propertyValuesHolder = PropertyValuesHolder.ofInt(str, i5);
            }
        } else if (z2) {
            if (i8 == 5) {
                i4 = (int) typedArray.getDimension(i3, 0.0f);
            } else if (m10640a(i8)) {
                i4 = typedArray.getColor(i3, 0);
            } else {
                i4 = typedArray.getInt(i3, 0);
            }
            propertyValuesHolder = PropertyValuesHolder.ofInt(str, i4);
        }
        if (propertyValuesHolder == null || m10620a == null) {
            return propertyValuesHolder;
        }
        propertyValuesHolder.setEvaluator(m10620a);
        return propertyValuesHolder;
    }

    /* renamed from: a */
    public static void m10637a(ValueAnimator valueAnimator, TypedArray typedArray, TypedArray typedArray2, float f, XmlPullParser xmlPullParser) {
        long m9932b = TypedArrayUtils.m9932b(typedArray, xmlPullParser, "duration", 1, 300);
        long m9932b2 = TypedArrayUtils.m9932b(typedArray, xmlPullParser, "startOffset", 2, 0);
        int m9932b3 = TypedArrayUtils.m9932b(typedArray, xmlPullParser, "valueType", 7, 4);
        if (TypedArrayUtils.m9936a(xmlPullParser, "valueFrom") && TypedArrayUtils.m9936a(xmlPullParser, "valueTo")) {
            if (m9932b3 == 4) {
                m9932b3 = m10625a(typedArray, 5, 6);
            }
            PropertyValuesHolder m10624a = m10624a(typedArray, m9932b3, 5, 6, "");
            if (m10624a != null) {
                valueAnimator.setValues(m10624a);
            }
        }
        valueAnimator.setDuration(m9932b);
        valueAnimator.setStartDelay(m9932b2);
        valueAnimator.setRepeatCount(TypedArrayUtils.m9932b(typedArray, xmlPullParser, "repeatCount", 3, 0));
        valueAnimator.setRepeatMode(TypedArrayUtils.m9932b(typedArray, xmlPullParser, "repeatMode", 4, 1));
        if (typedArray2 != null) {
            m10638a(valueAnimator, typedArray2, m9932b3, f, xmlPullParser);
        }
    }

    /* renamed from: a */
    public static void m10638a(ValueAnimator valueAnimator, TypedArray typedArray, int i, float f, XmlPullParser xmlPullParser) {
        ObjectAnimator objectAnimator = (ObjectAnimator) valueAnimator;
        String m9940a = TypedArrayUtils.m9940a(typedArray, xmlPullParser, "pathData", 1);
        if (m9940a != null) {
            String m9940a2 = TypedArrayUtils.m9940a(typedArray, xmlPullParser, "propertyXName", 2);
            String m9940a3 = TypedArrayUtils.m9940a(typedArray, xmlPullParser, "propertyYName", 3);
            if (i != 2) {
            }
            if (m9940a2 == null && m9940a3 == null) {
                throw new InflateException(typedArray.getPositionDescription() + " propertyXName or propertyYName is needed for PathData");
            }
            m10623a(PathParser.m9917b(m9940a), objectAnimator, f * 0.5f, m9940a2, m9940a3);
            return;
        }
        objectAnimator.setPropertyName(TypedArrayUtils.m9940a(typedArray, xmlPullParser, "propertyName", 0));
    }

    /* renamed from: a */
    public static void m10623a(Path path, ObjectAnimator objectAnimator, float f, String str, String str2) {
        PathMeasure pathMeasure = new PathMeasure(path, false);
        ArrayList arrayList = new ArrayList();
        arrayList.add(Float.valueOf(0.0f));
        float f2 = 0.0f;
        do {
            f2 += pathMeasure.getLength();
            arrayList.add(Float.valueOf(f2));
        } while (pathMeasure.nextContour());
        PathMeasure pathMeasure2 = new PathMeasure(path, false);
        int min = Math.min(100, ((int) (f2 / f)) + 1);
        float[] fArr = new float[min];
        float[] fArr2 = new float[min];
        float[] fArr3 = new float[2];
        float f3 = f2 / (min - 1);
        int i = 0;
        float f4 = 0.0f;
        int i2 = 0;
        while (true) {
            if (i >= min) {
                break;
            }
            pathMeasure2.getPosTan(f4 - ((Float) arrayList.get(i2)).floatValue(), fArr3, null);
            fArr[i] = fArr3[0];
            fArr2[i] = fArr3[1];
            f4 += f3;
            int i3 = i2 + 1;
            if (i3 < arrayList.size() && f4 > ((Float) arrayList.get(i3)).floatValue()) {
                pathMeasure2.nextContour();
                i2 = i3;
            }
            i++;
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

    /* renamed from: a */
    public static Animator m10630a(Context context, Resources resources, Resources.Theme theme, XmlPullParser xmlPullParser, float f) {
        return m10628a(context, resources, theme, xmlPullParser, Xml.asAttributeSet(xmlPullParser), null, 0, f);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:34:0x00ba  */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static android.animation.Animator m10628a(android.content.Context r18, android.content.res.Resources r19, android.content.res.Resources.Theme r20, org.xmlpull.v1.XmlPullParser r21, android.util.AttributeSet r22, android.animation.AnimatorSet r23, int r24, float r25) {
        /*
            Method dump skipped, instructions count: 265
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: p000a.p006b.p027e.p028a.AnimatorInflaterCompat.m10628a(android.content.Context, android.content.res.Resources, android.content.res.Resources$Theme, org.xmlpull.v1.XmlPullParser, android.util.AttributeSet, android.animation.AnimatorSet, int, float):android.animation.Animator");
    }

    /* renamed from: a */
    public static PropertyValuesHolder[] m10629a(Context context, Resources resources, Resources.Theme theme, XmlPullParser xmlPullParser, AttributeSet attributeSet) {
        int i;
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
                    TypedArray m9945a = TypedArrayUtils.m9945a(resources, theme, attributeSet, AndroidResources.f759i);
                    String m9940a = TypedArrayUtils.m9940a(m9945a, xmlPullParser, "propertyName", 3);
                    int m9932b = TypedArrayUtils.m9932b(m9945a, xmlPullParser, "valueType", 2, 4);
                    PropertyValuesHolder m10627a = m10627a(context, resources, theme, xmlPullParser, m9940a, m9932b);
                    if (m10627a == null) {
                        m10627a = m10624a(m9945a, m9932b, 0, 1, m9940a);
                    }
                    if (m10627a != null) {
                        if (arrayList == null) {
                            arrayList = new ArrayList();
                        }
                        arrayList.add(m10627a);
                    }
                    m9945a.recycle();
                }
                xmlPullParser.next();
            }
        }
        if (arrayList != null) {
            int size = arrayList.size();
            propertyValuesHolderArr = new PropertyValuesHolder[size];
            for (i = 0; i < size; i++) {
                propertyValuesHolderArr[i] = (PropertyValuesHolder) arrayList.get(i);
            }
        }
        return propertyValuesHolderArr;
    }

    /* renamed from: a */
    public static int m10626a(Resources resources, Resources.Theme theme, AttributeSet attributeSet, XmlPullParser xmlPullParser) {
        TypedArray m9945a = TypedArrayUtils.m9945a(resources, theme, attributeSet, AndroidResources.f760j);
        int i = 0;
        TypedValue m9933b = TypedArrayUtils.m9933b(m9945a, xmlPullParser, "value", 0);
        if ((m9933b != null) && m10640a(m9933b.type)) {
            i = 3;
        }
        m9945a.recycle();
        return i;
    }

    /* renamed from: a */
    public static int m10625a(TypedArray typedArray, int i, int i2) {
        TypedValue peekValue = typedArray.peekValue(i);
        boolean z = peekValue != null;
        int i3 = z ? peekValue.type : 0;
        TypedValue peekValue2 = typedArray.peekValue(i2);
        boolean z2 = peekValue2 != null;
        return ((z && m10640a(i3)) || (z2 && m10640a(z2 ? peekValue2.type : 0))) ? 3 : 0;
    }

    /* renamed from: a */
    public static PropertyValuesHolder m10627a(Context context, Resources resources, Resources.Theme theme, XmlPullParser xmlPullParser, String str, int i) {
        int size;
        PropertyValuesHolder propertyValuesHolder = null;
        int i2 = i;
        ArrayList arrayList = null;
        while (true) {
            int next = xmlPullParser.next();
            if (next == 3 || next == 1) {
                break;
            } else if (xmlPullParser.getName().equals("keyframe")) {
                if (i2 == 4) {
                    i2 = m10626a(resources, theme, Xml.asAttributeSet(xmlPullParser), xmlPullParser);
                }
                Keyframe m10632a = m10632a(context, resources, theme, Xml.asAttributeSet(xmlPullParser), i2, xmlPullParser);
                if (m10632a != null) {
                    if (arrayList == null) {
                        arrayList = new ArrayList();
                    }
                    arrayList.add(m10632a);
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
                    arrayList.add(arrayList.size(), m10639a(keyframe2, 1.0f));
                    size++;
                }
            }
            float fraction2 = keyframe.getFraction();
            if (fraction2 != 0.0f) {
                if (fraction2 < 0.0f) {
                    keyframe.setFraction(0.0f);
                } else {
                    arrayList.add(0, m10639a(keyframe, 0.0f));
                    size++;
                }
            }
            Keyframe[] keyframeArr = new Keyframe[size];
            arrayList.toArray(keyframeArr);
            for (int i3 = 0; i3 < size; i3++) {
                Keyframe keyframe3 = keyframeArr[i3];
                if (keyframe3.getFraction() < 0.0f) {
                    if (i3 == 0) {
                        keyframe3.setFraction(0.0f);
                    } else {
                        int i4 = size - 1;
                        if (i3 == i4) {
                            keyframe3.setFraction(1.0f);
                        } else {
                            int i5 = i3;
                            for (int i6 = i3 + 1; i6 < i4 && keyframeArr[i6].getFraction() < 0.0f; i6++) {
                                i5 = i6;
                            }
                            m10622a(keyframeArr, keyframeArr[i5 + 1].getFraction() - keyframeArr[i3 - 1].getFraction(), i3, i5);
                        }
                    }
                }
            }
            propertyValuesHolder = PropertyValuesHolder.ofKeyframe(str, keyframeArr);
            if (i2 == 3) {
                propertyValuesHolder.setEvaluator(ArgbEvaluator.m10620a());
            }
        }
        return propertyValuesHolder;
    }

    /* renamed from: a */
    public static Keyframe m10639a(Keyframe keyframe, float f) {
        if (keyframe.getType() == Float.TYPE) {
            return Keyframe.ofFloat(f);
        }
        if (keyframe.getType() == Integer.TYPE) {
            return Keyframe.ofInt(f);
        }
        return Keyframe.ofObject(f);
    }

    /* renamed from: a */
    public static void m10622a(Keyframe[] keyframeArr, float f, int i, int i2) {
        float f2 = f / ((i2 - i) + 2);
        while (i <= i2) {
            keyframeArr[i].setFraction(keyframeArr[i - 1].getFraction() + f2);
            i++;
        }
    }

    /* renamed from: a */
    public static Keyframe m10632a(Context context, Resources resources, Resources.Theme theme, AttributeSet attributeSet, int i, XmlPullParser xmlPullParser) {
        Keyframe ofInt;
        TypedArray m9945a = TypedArrayUtils.m9945a(resources, theme, attributeSet, AndroidResources.f760j);
        float m9939a = TypedArrayUtils.m9939a(m9945a, xmlPullParser, "fraction", 3, -1.0f);
        TypedValue m9933b = TypedArrayUtils.m9933b(m9945a, xmlPullParser, "value", 0);
        boolean z = m9933b != null;
        if (i == 4) {
            i = (z && m10640a(m9933b.type)) ? 3 : 0;
        }
        if (z) {
            if (i != 0) {
                ofInt = (i == 1 || i == 3) ? Keyframe.ofInt(m9939a, TypedArrayUtils.m9932b(m9945a, xmlPullParser, "value", 0, 0)) : null;
            } else {
                ofInt = Keyframe.ofFloat(m9939a, TypedArrayUtils.m9939a(m9945a, xmlPullParser, "value", 0, 0.0f));
            }
        } else if (i == 0) {
            ofInt = Keyframe.ofFloat(m9939a);
        } else {
            ofInt = Keyframe.ofInt(m9939a);
        }
        int m9930c = TypedArrayUtils.m9930c(m9945a, xmlPullParser, "interpolator", 1, 0);
        if (m9930c > 0) {
            ofInt.setInterpolator(AnimationUtilsCompat.m10642a(context, m9930c));
        }
        m9945a.recycle();
        return ofInt;
    }

    /* renamed from: a */
    public static ObjectAnimator m10633a(Context context, Resources resources, Resources.Theme theme, AttributeSet attributeSet, float f, XmlPullParser xmlPullParser) {
        ObjectAnimator objectAnimator = new ObjectAnimator();
        m10631a(context, resources, theme, attributeSet, objectAnimator, f, xmlPullParser);
        return objectAnimator;
    }

    /* renamed from: a */
    public static ValueAnimator m10631a(Context context, Resources resources, Resources.Theme theme, AttributeSet attributeSet, ValueAnimator valueAnimator, float f, XmlPullParser xmlPullParser) {
        TypedArray m9945a = TypedArrayUtils.m9945a(resources, theme, attributeSet, AndroidResources.f757g);
        TypedArray m9945a2 = TypedArrayUtils.m9945a(resources, theme, attributeSet, AndroidResources.f761k);
        if (valueAnimator == null) {
            valueAnimator = new ValueAnimator();
        }
        m10637a(valueAnimator, m9945a, m9945a2, f, xmlPullParser);
        int m9930c = TypedArrayUtils.m9930c(m9945a, xmlPullParser, "interpolator", 0, 0);
        if (m9930c > 0) {
            valueAnimator.setInterpolator(AnimationUtilsCompat.m10642a(context, m9930c));
        }
        m9945a.recycle();
        if (m9945a2 != null) {
            m9945a2.recycle();
        }
        return valueAnimator;
    }
}
