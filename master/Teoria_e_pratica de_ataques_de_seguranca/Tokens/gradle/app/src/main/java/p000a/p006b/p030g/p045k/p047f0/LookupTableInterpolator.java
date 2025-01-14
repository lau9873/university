package p000a.p006b.p030g.p045k.p047f0;

import android.view.animation.Interpolator;

/* renamed from: a.b.g.k.f0.d */
/* loaded from: classes.dex */
public abstract class LookupTableInterpolator implements Interpolator {

    /* renamed from: a */
    public final float[] f1632a;

    /* renamed from: b */
    public final float f1633b;

    public LookupTableInterpolator(float[] fArr) {
        this.f1632a = fArr;
        this.f1633b = 1.0f / (this.f1632a.length - 1);
    }

    @Override // android.animation.TimeInterpolator
    public float getInterpolation(float f) {
        if (f >= 1.0f) {
            return 1.0f;
        }
        if (f <= 0.0f) {
            return 0.0f;
        }
        float[] fArr = this.f1632a;
        int min = Math.min((int) ((fArr.length - 1) * f), fArr.length - 2);
        float f2 = this.f1633b;
        float f3 = (f - (min * f2)) / f2;
        float[] fArr2 = this.f1632a;
        return fArr2[min] + (f3 * (fArr2[min + 1] - fArr2[min]));
    }
}
