package p000a.p006b.p012d.p018p;

import android.os.Bundle;
import android.support.design.widget.CoordinatorLayout;
import android.view.View;
import android.view.ViewParent;

/* renamed from: a.b.d.p.c */
/* loaded from: classes.dex */
public final class ExpandableWidgetHelper {

    /* renamed from: a */
    public final View f485a;

    /* renamed from: b */
    public boolean f486b = false;

    /* renamed from: c */
    public int f487c = 0;

    public ExpandableWidgetHelper(ExpandableWidget expandableWidget) {
        this.f485a = (View) expandableWidget;
    }

    /* renamed from: a */
    public void m10887a(Bundle bundle) {
        this.f486b = bundle.getBoolean("expanded", false);
        this.f487c = bundle.getInt("expandedComponentIdHint", 0);
        if (this.f486b) {
            m10889a();
        }
    }

    /* renamed from: b */
    public int m10886b() {
        return this.f487c;
    }

    /* renamed from: c */
    public boolean m10885c() {
        return this.f486b;
    }

    /* renamed from: d */
    public Bundle m10884d() {
        Bundle bundle = new Bundle();
        bundle.putBoolean("expanded", this.f486b);
        bundle.putInt("expandedComponentIdHint", this.f487c);
        return bundle;
    }

    /* renamed from: a */
    public void m10888a(int i) {
        this.f487c = i;
    }

    /* renamed from: a */
    public final void m10889a() {
        ViewParent parent = this.f485a.getParent();
        if (parent instanceof CoordinatorLayout) {
            ((CoordinatorLayout) parent).m7745a(this.f485a);
        }
    }
}
