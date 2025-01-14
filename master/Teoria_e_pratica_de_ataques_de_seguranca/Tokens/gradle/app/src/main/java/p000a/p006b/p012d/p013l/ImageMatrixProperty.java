package p000a.p006b.p012d.p013l;

import android.graphics.Matrix;
import android.util.Property;
import android.widget.ImageView;

/* renamed from: a.b.d.l.f */
/* loaded from: classes.dex */
public class ImageMatrixProperty extends Property<ImageView, Matrix> {

    /* renamed from: a */
    public final Matrix f430a;

    public ImageMatrixProperty() {
        super(Matrix.class, "imageMatrixProperty");
        this.f430a = new Matrix();
    }

    @Override // android.util.Property
    /* renamed from: a */
    public void set(ImageView imageView, Matrix matrix) {
        imageView.setImageMatrix(matrix);
    }

    @Override // android.util.Property
    /* renamed from: a */
    public Matrix get(ImageView imageView) {
        this.f430a.set(imageView.getImageMatrix());
        return this.f430a;
    }
}
