package android.support.design.transformation;

import a.b.d.a;
import a.b.d.l.h;
import a.b.d.l.j;
import a.b.g.k.u;
import android.content.Context;
import android.os.Build;
import android.support.design.transformation.FabTransformationBehavior;
import android.support.design.widget.CoordinatorLayout;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewParent;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes.dex */
public class FabTransformationSheetBehavior extends FabTransformationBehavior {

    /* renamed from: g  reason: collision with root package name */
    public Map<View, Integer> f2101g;

    public FabTransformationSheetBehavior() {
    }

    @Override // android.support.design.transformation.FabTransformationBehavior
    public FabTransformationBehavior.e a(Context context, boolean z) {
        int i2;
        if (z) {
            i2 = a.mtrl_fab_transformation_sheet_expand_spec;
        } else {
            i2 = a.mtrl_fab_transformation_sheet_collapse_spec;
        }
        FabTransformationBehavior.e eVar = new FabTransformationBehavior.e();
        eVar.f2095a = h.a(context, i2);
        eVar.f2096b = new j(17, 0.0f, 0.0f);
        return eVar;
    }

    public FabTransformationSheetBehavior(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    @Override // android.support.design.transformation.ExpandableTransformationBehavior, android.support.design.transformation.ExpandableBehavior
    public boolean a(View view, View view2, boolean z, boolean z2) {
        a(view2, z);
        return super.a(view, view2, z, z2);
    }

    public final void a(View view, boolean z) {
        ViewParent parent = view.getParent();
        if (parent instanceof CoordinatorLayout) {
            CoordinatorLayout coordinatorLayout = (CoordinatorLayout) parent;
            int childCount = coordinatorLayout.getChildCount();
            if (Build.VERSION.SDK_INT >= 16 && z) {
                this.f2101g = new HashMap(childCount);
            }
            for (int i2 = 0; i2 < childCount; i2++) {
                View childAt = coordinatorLayout.getChildAt(i2);
                boolean z2 = (childAt.getLayoutParams() instanceof CoordinatorLayout.f) && (((CoordinatorLayout.f) childAt.getLayoutParams()).d() instanceof FabTransformationScrimBehavior);
                if (childAt != view && !z2) {
                    if (!z) {
                        Map<View, Integer> map = this.f2101g;
                        if (map != null && map.containsKey(childAt)) {
                            u.f(childAt, this.f2101g.get(childAt).intValue());
                        }
                    } else {
                        if (Build.VERSION.SDK_INT >= 16) {
                            this.f2101g.put(childAt, Integer.valueOf(childAt.getImportantForAccessibility()));
                        }
                        u.f(childAt, 4);
                    }
                }
            }
            if (z) {
                return;
            }
            this.f2101g = null;
        }
    }
}
