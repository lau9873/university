package android.support.design.transformation;

import android.content.Context;
import android.support.design.widget.CoordinatorLayout;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewTreeObserver;
import java.util.List;
import p000a.p006b.p012d.p018p.ExpandableWidget;
import p000a.p006b.p030g.p045k.ViewCompat;

/* loaded from: classes.dex */
public abstract class ExpandableBehavior extends CoordinatorLayout.AbstractC0575c<View> {

    /* renamed from: a */
    public int f3172a;

    /* renamed from: android.support.design.transformation.ExpandableBehavior$a */
    /* loaded from: classes.dex */
    public class ViewTreeObserver$OnPreDrawListenerC0529a implements ViewTreeObserver.OnPreDrawListener {

        /* renamed from: a */
        public final /* synthetic */ View f3173a;

        /* renamed from: b */
        public final /* synthetic */ int f3174b;

        /* renamed from: c */
        public final /* synthetic */ ExpandableWidget f3175c;

        public ViewTreeObserver$OnPreDrawListenerC0529a(View view, int i, ExpandableWidget expandableWidget) {
            this.f3173a = view;
            this.f3174b = i;
            this.f3175c = expandableWidget;
        }

        @Override // android.view.ViewTreeObserver.OnPreDrawListener
        public boolean onPreDraw() {
            this.f3173a.getViewTreeObserver().removeOnPreDrawListener(this);
            if (ExpandableBehavior.this.f3172a == this.f3174b) {
                ExpandableBehavior expandableBehavior = ExpandableBehavior.this;
                ExpandableWidget expandableWidget = this.f3175c;
                expandableBehavior.mo7861a((View) expandableWidget, this.f3173a, expandableWidget.mo7667a(), false);
            }
            return false;
        }
    }

    public ExpandableBehavior() {
        this.f3172a = 0;
    }

    /* renamed from: a */
    public abstract boolean mo7861a(View view, View view2, boolean z, boolean z2);

    @Override // android.support.design.widget.CoordinatorLayout.AbstractC0575c
    /* renamed from: b */
    public boolean mo7639b(CoordinatorLayout coordinatorLayout, View view, View view2) {
        ExpandableWidget expandableWidget = (ExpandableWidget) view2;
        if (m7885a(expandableWidget.mo7667a())) {
            this.f3172a = expandableWidget.mo7667a() ? 1 : 2;
            return mo7861a((View) expandableWidget, view, expandableWidget.mo7667a(), true);
        }
        return false;
    }

    /* renamed from: e */
    public ExpandableWidget m7884e(CoordinatorLayout coordinatorLayout, View view) {
        List<View> m7731b = coordinatorLayout.m7731b(view);
        int size = m7731b.size();
        for (int i = 0; i < size; i++) {
            View view2 = m7731b.get(i);
            if (mo7705a(coordinatorLayout, (CoordinatorLayout) view, view2)) {
                return (ExpandableWidget) view2;
            }
        }
        return null;
    }

    @Override // android.support.design.widget.CoordinatorLayout.AbstractC0575c
    /* renamed from: a */
    public boolean mo7643a(CoordinatorLayout coordinatorLayout, View view, int i) {
        ExpandableWidget m7884e;
        if (ViewCompat.m9409x(view) || (m7884e = m7884e(coordinatorLayout, view)) == null || !m7885a(m7884e.mo7667a())) {
            return false;
        }
        this.f3172a = m7884e.mo7667a() ? 1 : 2;
        view.getViewTreeObserver().addOnPreDrawListener(new ViewTreeObserver$OnPreDrawListenerC0529a(view, this.f3172a, m7884e));
        return false;
    }

    public ExpandableBehavior(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f3172a = 0;
    }

    /* renamed from: a */
    public final boolean m7885a(boolean z) {
        if (!z) {
            return this.f3172a == 1;
        }
        int i = this.f3172a;
        return i == 0 || i == 2;
    }
}
