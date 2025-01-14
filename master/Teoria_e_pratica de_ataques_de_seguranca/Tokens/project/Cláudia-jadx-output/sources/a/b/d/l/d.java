package a.b.d.l;

import android.util.Property;
import android.view.ViewGroup;
/* compiled from: ChildrenAlphaProperty.java */
/* loaded from: classes.dex */
public class d extends Property<ViewGroup, Float> {

    /* renamed from: a  reason: collision with root package name */
    public static final Property<ViewGroup, Float> f216a = new d("childrenAlpha");

    public d(String str) {
        super(Float.class, str);
    }

    @Override // android.util.Property
    /* renamed from: a */
    public Float get(ViewGroup viewGroup) {
        Float f2 = (Float) viewGroup.getTag(a.b.d.f.mtrl_internal_children_alpha_tag);
        return f2 != null ? f2 : Float.valueOf(1.0f);
    }

    @Override // android.util.Property
    /* renamed from: a */
    public void set(ViewGroup viewGroup, Float f2) {
        float floatValue = f2.floatValue();
        viewGroup.setTag(a.b.d.f.mtrl_internal_children_alpha_tag, Float.valueOf(floatValue));
        int childCount = viewGroup.getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            viewGroup.getChildAt(i2).setAlpha(floatValue);
        }
    }
}
