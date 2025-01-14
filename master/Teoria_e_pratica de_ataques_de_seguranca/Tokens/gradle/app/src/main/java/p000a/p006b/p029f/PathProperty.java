package p000a.p006b.p029f;

import android.graphics.Path;
import android.graphics.PathMeasure;
import android.graphics.PointF;
import android.util.Property;

/* renamed from: a.b.f.h */
/* loaded from: classes.dex */
public class PathProperty<T> extends Property<T, Float> {

    /* renamed from: a */
    public final Property<T, PointF> f912a;

    /* renamed from: b */
    public final PathMeasure f913b;

    /* renamed from: c */
    public final float f914c;

    /* renamed from: d */
    public final float[] f915d;

    /* renamed from: e */
    public final PointF f916e;

    /* renamed from: f */
    public float f917f;

    public PathProperty(Property<T, PointF> property, Path path) {
        super(Float.class, property.getName());
        this.f915d = new float[2];
        this.f916e = new PointF();
        this.f912a = property;
        this.f913b = new PathMeasure(path, false);
        this.f914c = this.f913b.getLength();
    }

    @Override // android.util.Property
    /* renamed from: a */
    public void set(T t, Float f) {
        this.f917f = f.floatValue();
        this.f913b.getPosTan(this.f914c * f.floatValue(), this.f915d, null);
        PointF pointF = this.f916e;
        float[] fArr = this.f915d;
        pointF.x = fArr[0];
        pointF.y = fArr[1];
        this.f912a.set(t, pointF);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // android.util.Property
    public /* bridge */ /* synthetic */ Float get(Object obj) {
        return get((PathProperty<T>) obj);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // android.util.Property
    public Float get(T t) {
        return Float.valueOf(this.f917f);
    }
}
