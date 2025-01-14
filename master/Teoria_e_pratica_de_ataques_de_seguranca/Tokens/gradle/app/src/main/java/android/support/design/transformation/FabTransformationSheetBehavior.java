package android.support.design.transformation;

import android.content.Context;
import android.os.Build;
import android.support.design.transformation.FabTransformationBehavior;
import android.support.design.widget.CoordinatorLayout;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewParent;
import java.util.HashMap;
import java.util.Map;
import p000a.p006b.p012d.C0039a;
import p000a.p006b.p012d.p013l.MotionSpec;
import p000a.p006b.p012d.p013l.Positioning;
import p000a.p006b.p030g.p045k.ViewCompat;

/* loaded from: classes.dex */
public class FabTransformationSheetBehavior extends FabTransformationBehavior {

    /* renamed from: g */
    public Map<View, Integer> f3196g;

    public FabTransformationSheetBehavior() {
    }

    @Override // android.support.design.transformation.FabTransformationBehavior
    /* renamed from: a */
    public FabTransformationBehavior.C0535e mo7862a(Context context, boolean z) {
        int i;
        if (z) {
            i = C0039a.mtrl_fab_transformation_sheet_expand_spec;
        } else {
            i = C0039a.mtrl_fab_transformation_sheet_collapse_spec;
        }
        FabTransformationBehavior.C0535e c0535e = new FabTransformationBehavior.C0535e();
        c0535e.f3190a = MotionSpec.m10960a(context, i);
        c0535e.f3191b = new Positioning(17, 0.0f, 0.0f);
        return c0535e;
    }

    public FabTransformationSheetBehavior(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    @Override // android.support.design.transformation.ExpandableTransformationBehavior, android.support.design.transformation.ExpandableBehavior
    /* renamed from: a */
    public boolean mo7861a(View view, View view2, boolean z, boolean z2) {
        m7860a(view2, z);
        return super.mo7861a(view, view2, z, z2);
    }

    /* renamed from: a */
    public final void m7860a(View view, boolean z) {
        ViewParent parent = view.getParent();
        if (parent instanceof CoordinatorLayout) {
            CoordinatorLayout coordinatorLayout = (CoordinatorLayout) parent;
            int childCount = coordinatorLayout.getChildCount();
            if (Build.VERSION.SDK_INT >= 16 && z) {
                this.f3196g = new HashMap(childCount);
            }
            for (int i = 0; i < childCount; i++) {
                View childAt = coordinatorLayout.getChildAt(i);
                boolean z2 = (childAt.getLayoutParams() instanceof CoordinatorLayout.C0578f) && (((CoordinatorLayout.C0578f) childAt.getLayoutParams()).m7673d() instanceof FabTransformationScrimBehavior);
                if (childAt != view && !z2) {
                    if (!z) {
                        Map<View, Integer> map = this.f3196g;
                        if (map != null && map.containsKey(childAt)) {
                            ViewCompat.m9429f(childAt, this.f3196g.get(childAt).intValue());
                        }
                    } else {
                        if (Build.VERSION.SDK_INT >= 16) {
                            this.f3196g.put(childAt, Integer.valueOf(childAt.getImportantForAccessibility()));
                        }
                        ViewCompat.m9429f(childAt, 4);
                    }
                }
            }
            if (z) {
                return;
            }
            this.f3196g = null;
        }
    }
}
