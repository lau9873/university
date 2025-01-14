package p000a.p006b.p027e.p028a;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Path;
import android.graphics.PathMeasure;
import android.util.AttributeSet;
import android.view.InflateException;
import android.view.animation.Interpolator;
import org.xmlpull.v1.XmlPullParser;
import p000a.p006b.p030g.p032b.p033g.TypedArrayUtils;
import p000a.p006b.p030g.p034c.PathParser;

/* renamed from: a.b.e.a.g */
/* loaded from: classes.dex */
public class PathInterpolatorCompat implements Interpolator {

    /* renamed from: a */
    public float[] f776a;

    /* renamed from: b */
    public float[] f777b;

    public PathInterpolatorCompat(Context context, AttributeSet attributeSet, XmlPullParser xmlPullParser) {
        this(context.getResources(), context.getTheme(), attributeSet, xmlPullParser);
    }

    /* renamed from: a */
    public final void m10617a(TypedArray typedArray, XmlPullParser xmlPullParser) {
        if (TypedArrayUtils.m9936a(xmlPullParser, "pathData")) {
            String m9940a = TypedArrayUtils.m9940a(typedArray, xmlPullParser, "pathData", 4);
            Path m9917b = PathParser.m9917b(m9940a);
            if (m9917b != null) {
                m10616a(m9917b);
                return;
            }
            throw new InflateException("The path is null, which is created from " + m9940a);
        } else if (TypedArrayUtils.m9936a(xmlPullParser, "controlX1")) {
            if (TypedArrayUtils.m9936a(xmlPullParser, "controlY1")) {
                float m9939a = TypedArrayUtils.m9939a(typedArray, xmlPullParser, "controlX1", 0, 0.0f);
                float m9939a2 = TypedArrayUtils.m9939a(typedArray, xmlPullParser, "controlY1", 1, 0.0f);
                boolean m9936a = TypedArrayUtils.m9936a(xmlPullParser, "controlX2");
                if (m9936a != TypedArrayUtils.m9936a(xmlPullParser, "controlY2")) {
                    throw new InflateException("pathInterpolator requires both controlX2 and controlY2 for cubic Beziers.");
                }
                if (!m9936a) {
                    m10619a(m9939a, m9939a2);
                    return;
                } else {
                    m10618a(m9939a, m9939a2, TypedArrayUtils.m9939a(typedArray, xmlPullParser, "controlX2", 2, 0.0f), TypedArrayUtils.m9939a(typedArray, xmlPullParser, "controlY2", 3, 0.0f));
                    return;
                }
            }
            throw new InflateException("pathInterpolator requires the controlY1 attribute");
        } else {
            throw new InflateException("pathInterpolator requires the controlX1 attribute");
        }
    }

    @Override // android.animation.TimeInterpolator
    public float getInterpolation(float f) {
        if (f <= 0.0f) {
            return 0.0f;
        }
        if (f >= 1.0f) {
            return 1.0f;
        }
        int i = 0;
        int length = this.f776a.length - 1;
        while (length - i > 1) {
            int i2 = (i + length) / 2;
            if (f < this.f776a[i2]) {
                length = i2;
            } else {
                i = i2;
            }
        }
        float[] fArr = this.f776a;
        float f2 = fArr[length] - fArr[i];
        if (f2 == 0.0f) {
            return this.f777b[i];
        }
        float[] fArr2 = this.f777b;
        float f3 = fArr2[i];
        return f3 + (((f - fArr[i]) / f2) * (fArr2[length] - f3));
    }

    public PathInterpolatorCompat(Resources resources, Resources.Theme theme, AttributeSet attributeSet, XmlPullParser xmlPullParser) {
        TypedArray m9945a = TypedArrayUtils.m9945a(resources, theme, attributeSet, AndroidResources.f762l);
        m10617a(m9945a, xmlPullParser);
        m9945a.recycle();
    }

    /* renamed from: a */
    public final void m10619a(float f, float f2) {
        Path path = new Path();
        path.moveTo(0.0f, 0.0f);
        path.quadTo(f, f2, 1.0f, 1.0f);
        m10616a(path);
    }

    /* renamed from: a */
    public final void m10618a(float f, float f2, float f3, float f4) {
        Path path = new Path();
        path.moveTo(0.0f, 0.0f);
        path.cubicTo(f, f2, f3, f4, 1.0f, 1.0f);
        m10616a(path);
    }

    /* renamed from: a */
    public final void m10616a(Path path) {
        int i = 0;
        PathMeasure pathMeasure = new PathMeasure(path, false);
        float length = pathMeasure.getLength();
        int min = Math.min(3000, ((int) (length / 0.002f)) + 1);
        if (min > 0) {
            this.f776a = new float[min];
            this.f777b = new float[min];
            float[] fArr = new float[2];
            for (int i2 = 0; i2 < min; i2++) {
                pathMeasure.getPosTan((i2 * length) / (min - 1), fArr, null);
                this.f776a[i2] = fArr[0];
                this.f777b[i2] = fArr[1];
            }
            if (Math.abs(this.f776a[0]) <= 1.0E-5d && Math.abs(this.f777b[0]) <= 1.0E-5d) {
                int i3 = min - 1;
                if (Math.abs(this.f776a[i3] - 1.0f) <= 1.0E-5d && Math.abs(this.f777b[i3] - 1.0f) <= 1.0E-5d) {
                    int i4 = 0;
                    float f = 0.0f;
                    while (i < min) {
                        float[] fArr2 = this.f776a;
                        int i5 = i4 + 1;
                        float f2 = fArr2[i4];
                        if (f2 >= f) {
                            fArr2[i] = f2;
                            i++;
                            f = f2;
                            i4 = i5;
                        } else {
                            throw new IllegalArgumentException("The Path cannot loop back on itself, x :" + f2);
                        }
                    }
                    if (pathMeasure.nextContour()) {
                        throw new IllegalArgumentException("The Path should be continuous, can't have 2+ contours");
                    }
                    return;
                }
            }
            StringBuilder sb = new StringBuilder();
            sb.append("The Path must start at (0,0) and end at (1,1) start: ");
            sb.append(this.f776a[0]);
            sb.append(",");
            sb.append(this.f777b[0]);
            sb.append(" end:");
            int i6 = min - 1;
            sb.append(this.f776a[i6]);
            sb.append(",");
            sb.append(this.f777b[i6]);
            throw new IllegalArgumentException(sb.toString());
        }
        throw new IllegalArgumentException("The Path has a invalid length " + length);
    }
}
