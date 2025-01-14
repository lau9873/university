package a.b.d.l;

import android.graphics.Matrix;
import android.util.Property;
import android.widget.ImageView;
/* compiled from: ImageMatrixProperty.java */
/* loaded from: classes.dex */
public class f extends Property<ImageView, Matrix> {

    /* renamed from: a  reason: collision with root package name */
    public final Matrix f219a;

    public f() {
        super(Matrix.class, "imageMatrixProperty");
        this.f219a = new Matrix();
    }

    @Override // android.util.Property
    /* renamed from: a */
    public void set(ImageView imageView, Matrix matrix) {
        imageView.setImageMatrix(matrix);
    }

    @Override // android.util.Property
    /* renamed from: a */
    public Matrix get(ImageView imageView) {
        this.f219a.set(imageView.getImageMatrix());
        return this.f219a;
    }
}
