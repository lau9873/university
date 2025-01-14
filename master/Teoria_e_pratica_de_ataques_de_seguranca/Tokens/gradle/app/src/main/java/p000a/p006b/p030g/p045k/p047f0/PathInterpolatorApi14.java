package p000a.p006b.p030g.p045k.p047f0;

import android.graphics.Path;
import android.graphics.PathMeasure;
import android.view.animation.Interpolator;

/* renamed from: a.b.g.k.f0.e */
/* loaded from: classes.dex */
public class PathInterpolatorApi14 implements Interpolator {

    /* renamed from: a */
    public final float[] f1634a;

    /* renamed from: b */
    public final float[] f1635b;

    public PathInterpolatorApi14(Path path) {
        PathMeasure pathMeasure = new PathMeasure(path, false);
        float length = pathMeasure.getLength();
        int i = ((int) (length / 0.002f)) + 1;
        this.f1634a = new float[i];
        this.f1635b = new float[i];
        float[] fArr = new float[2];
        for (int i2 = 0; i2 < i; i2++) {
            pathMeasure.getPosTan((i2 * length) / (i - 1), fArr, null);
            this.f1634a[i2] = fArr[0];
            this.f1635b[i2] = fArr[1];
        }
    }

    /* renamed from: a */
    public static Path m9510a(float f, float f2, float f3, float f4) {
        Path path = new Path();
        path.moveTo(0.0f, 0.0f);
        path.cubicTo(f, f2, f3, f4, 1.0f, 1.0f);
        return path;
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
        int length = this.f1634a.length - 1;
        while (length - i > 1) {
            int i2 = (i + length) / 2;
            if (f < this.f1634a[i2]) {
                length = i2;
            } else {
                i = i2;
            }
        }
        float[] fArr = this.f1634a;
        float f2 = fArr[length] - fArr[i];
        if (f2 == 0.0f) {
            return this.f1635b[i];
        }
        float[] fArr2 = this.f1635b;
        float f3 = fArr2[i];
        return f3 + (((f - fArr[i]) / f2) * (fArr2[length] - f3));
    }

    public PathInterpolatorApi14(float f, float f2, float f3, float f4) {
        this(m9510a(f, f2, f3, f4));
    }
}
