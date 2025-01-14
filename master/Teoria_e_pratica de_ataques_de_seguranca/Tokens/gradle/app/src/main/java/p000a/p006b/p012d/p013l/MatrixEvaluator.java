package p000a.p006b.p012d.p013l;

import android.animation.TypeEvaluator;
import android.graphics.Matrix;

/* renamed from: a.b.d.l.g */
/* loaded from: classes.dex */
public class MatrixEvaluator implements TypeEvaluator<Matrix> {

    /* renamed from: a */
    public final float[] f431a = new float[9];

    /* renamed from: b */
    public final float[] f432b = new float[9];

    /* renamed from: c */
    public final Matrix f433c = new Matrix();

    @Override // android.animation.TypeEvaluator
    /* renamed from: a */
    public Matrix evaluate(float f, Matrix matrix, Matrix matrix2) {
        matrix.getValues(this.f431a);
        matrix2.getValues(this.f432b);
        for (int i = 0; i < 9; i++) {
            float[] fArr = this.f432b;
            float f2 = fArr[i];
            float[] fArr2 = this.f431a;
            fArr[i] = fArr2[i] + ((f2 - fArr2[i]) * f);
        }
        this.f433c.setValues(this.f432b);
        return this.f433c;
    }
}
