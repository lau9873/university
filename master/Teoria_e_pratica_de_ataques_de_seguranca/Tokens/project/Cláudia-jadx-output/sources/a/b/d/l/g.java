package a.b.d.l;

import android.animation.TypeEvaluator;
import android.graphics.Matrix;
/* compiled from: MatrixEvaluator.java */
/* loaded from: classes.dex */
public class g implements TypeEvaluator<Matrix> {

    /* renamed from: a  reason: collision with root package name */
    public final float[] f220a = new float[9];

    /* renamed from: b  reason: collision with root package name */
    public final float[] f221b = new float[9];

    /* renamed from: c  reason: collision with root package name */
    public final Matrix f222c = new Matrix();

    @Override // android.animation.TypeEvaluator
    /* renamed from: a */
    public Matrix evaluate(float f2, Matrix matrix, Matrix matrix2) {
        matrix.getValues(this.f220a);
        matrix2.getValues(this.f221b);
        for (int i2 = 0; i2 < 9; i2++) {
            float[] fArr = this.f221b;
            float f3 = fArr[i2];
            float[] fArr2 = this.f220a;
            fArr[i2] = fArr2[i2] + ((f3 - fArr2[i2]) * f2);
        }
        this.f222c.setValues(this.f221b);
        return this.f222c;
    }
}
