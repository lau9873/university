package a.b.g.k.f0;

import android.graphics.Path;
import android.graphics.PathMeasure;
import android.view.animation.Interpolator;
/* compiled from: PathInterpolatorApi14.java */
/* loaded from: classes.dex */
public class e implements Interpolator {

    /* renamed from: a  reason: collision with root package name */
    public final float[] f1123a;

    /* renamed from: b  reason: collision with root package name */
    public final float[] f1124b;

    public e(Path path) {
        PathMeasure pathMeasure = new PathMeasure(path, false);
        float length = pathMeasure.getLength();
        int i2 = ((int) (length / 0.002f)) + 1;
        this.f1123a = new float[i2];
        this.f1124b = new float[i2];
        float[] fArr = new float[2];
        for (int i3 = 0; i3 < i2; i3++) {
            pathMeasure.getPosTan((i3 * length) / (i2 - 1), fArr, null);
            this.f1123a[i3] = fArr[0];
            this.f1124b[i3] = fArr[1];
        }
    }

    public static Path a(float f2, float f3, float f4, float f5) {
        Path path = new Path();
        path.moveTo(0.0f, 0.0f);
        path.cubicTo(f2, f3, f4, f5, 1.0f, 1.0f);
        return path;
    }

    @Override // android.animation.TimeInterpolator
    public float getInterpolation(float f2) {
        if (f2 <= 0.0f) {
            return 0.0f;
        }
        if (f2 >= 1.0f) {
            return 1.0f;
        }
        int i2 = 0;
        int length = this.f1123a.length - 1;
        while (length - i2 > 1) {
            int i3 = (i2 + length) / 2;
            if (f2 < this.f1123a[i3]) {
                length = i3;
            } else {
                i2 = i3;
            }
        }
        float[] fArr = this.f1123a;
        float f3 = fArr[length] - fArr[i2];
        if (f3 == 0.0f) {
            return this.f1124b[i2];
        }
        float[] fArr2 = this.f1124b;
        float f4 = fArr2[i2];
        return f4 + (((f2 - fArr[i2]) / f3) * (fArr2[length] - f4));
    }

    public e(float f2, float f3, float f4, float f5) {
        this(a(f2, f3, f4, f5));
    }
}
