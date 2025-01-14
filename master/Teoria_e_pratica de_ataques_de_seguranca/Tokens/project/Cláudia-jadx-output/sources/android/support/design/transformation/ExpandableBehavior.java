package android.support.design.transformation;

import a.b.d.p.b;
import a.b.g.k.u;
import android.content.Context;
import android.support.design.widget.CoordinatorLayout;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewTreeObserver;
import java.util.List;
/* loaded from: classes.dex */
public abstract class ExpandableBehavior extends CoordinatorLayout.c<View> {

    /* renamed from: a  reason: collision with root package name */
    public int f2077a;

    /* loaded from: classes.dex */
    public class a implements ViewTreeObserver.OnPreDrawListener {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ View f2078a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ int f2079b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ b f2080c;

        public a(View view, int i2, b bVar) {
            this.f2078a = view;
            this.f2079b = i2;
            this.f2080c = bVar;
        }

        @Override // android.view.ViewTreeObserver.OnPreDrawListener
        public boolean onPreDraw() {
            this.f2078a.getViewTreeObserver().removeOnPreDrawListener(this);
            if (ExpandableBehavior.this.f2077a == this.f2079b) {
                ExpandableBehavior expandableBehavior = ExpandableBehavior.this;
                b bVar = this.f2080c;
                expandableBehavior.a((View) bVar, this.f2078a, bVar.a(), false);
            }
            return false;
        }
    }

    public ExpandableBehavior() {
        this.f2077a = 0;
    }

    public abstract boolean a(View view, View view2, boolean z, boolean z2);

    @Override // android.support.design.widget.CoordinatorLayout.c
    public boolean b(CoordinatorLayout coordinatorLayout, View view, View view2) {
        b bVar = (b) view2;
        if (a(bVar.a())) {
            this.f2077a = bVar.a() ? 1 : 2;
            return a((View) bVar, view, bVar.a(), true);
        }
        return false;
    }

    public b e(CoordinatorLayout coordinatorLayout, View view) {
        List<View> b2 = coordinatorLayout.b(view);
        int size = b2.size();
        for (int i2 = 0; i2 < size; i2++) {
            View view2 = b2.get(i2);
            if (a(coordinatorLayout, (CoordinatorLayout) view, view2)) {
                return (b) view2;
            }
        }
        return null;
    }

    @Override // android.support.design.widget.CoordinatorLayout.c
    public boolean a(CoordinatorLayout coordinatorLayout, View view, int i2) {
        b e2;
        if (u.x(view) || (e2 = e(coordinatorLayout, view)) == null || !a(e2.a())) {
            return false;
        }
        this.f2077a = e2.a() ? 1 : 2;
        view.getViewTreeObserver().addOnPreDrawListener(new a(view, this.f2077a, e2));
        return false;
    }

    public ExpandableBehavior(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f2077a = 0;
    }

    public final boolean a(boolean z) {
        if (!z) {
            return this.f2077a == 1;
        }
        int i2 = this.f2077a;
        return i2 == 0 || i2 == 2;
    }
}
