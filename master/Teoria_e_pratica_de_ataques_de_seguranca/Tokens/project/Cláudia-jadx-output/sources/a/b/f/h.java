package a.b.f;

import android.graphics.Path;
import android.graphics.PathMeasure;
import android.graphics.PointF;
import android.util.Property;
/* compiled from: PathProperty.java */
/* loaded from: classes.dex */
public class h<T> extends Property<T, Float> {

    /* renamed from: a  reason: collision with root package name */
    public final Property<T, PointF> f532a;

    /* renamed from: b  reason: collision with root package name */
    public final PathMeasure f533b;

    /* renamed from: c  reason: collision with root package name */
    public final float f534c;

    /* renamed from: d  reason: collision with root package name */
    public final float[] f535d;

    /* renamed from: e  reason: collision with root package name */
    public final PointF f536e;

    /* renamed from: f  reason: collision with root package name */
    public float f537f;

    public h(Property<T, PointF> property, Path path) {
        super(Float.class, property.getName());
        this.f535d = new float[2];
        this.f536e = new PointF();
        this.f532a = property;
        this.f533b = new PathMeasure(path, false);
        this.f534c = this.f533b.getLength();
    }

    @Override // android.util.Property
    /* renamed from: a */
    public void set(T t, Float f2) {
        this.f537f = f2.floatValue();
        this.f533b.getPosTan(this.f534c * f2.floatValue(), this.f535d, null);
        PointF pointF = this.f536e;
        float[] fArr = this.f535d;
        pointF.x = fArr[0];
        pointF.y = fArr[1];
        this.f532a.set(t, pointF);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // android.util.Property
    public /* bridge */ /* synthetic */ Float get(Object obj) {
        return get((h<T>) obj);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // android.util.Property
    public Float get(T t) {
        return Float.valueOf(this.f537f);
    }
}
