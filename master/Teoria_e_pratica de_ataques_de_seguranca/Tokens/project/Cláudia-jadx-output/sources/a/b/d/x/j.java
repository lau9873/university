package a.b.d.x;

import a.b.g.k.d0;
import a.b.g.k.u;
import android.content.Context;
import android.graphics.Rect;
import android.support.design.widget.CoordinatorLayout;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import java.util.List;
/* compiled from: HeaderScrollingViewBehavior.java */
/* loaded from: classes.dex */
public abstract class j extends q<View> {

    /* renamed from: d  reason: collision with root package name */
    public final Rect f357d;

    /* renamed from: e  reason: collision with root package name */
    public final Rect f358e;

    /* renamed from: f  reason: collision with root package name */
    public int f359f;

    /* renamed from: g  reason: collision with root package name */
    public int f360g;

    public j() {
        this.f357d = new Rect();
        this.f358e = new Rect();
        this.f359f = 0;
    }

    public static int c(int i2) {
        if (i2 == 0) {
            return 8388659;
        }
        return i2;
    }

    public abstract View a(List<View> list);

    @Override // android.support.design.widget.CoordinatorLayout.c
    public boolean a(CoordinatorLayout coordinatorLayout, View view, int i2, int i3, int i4, int i5) {
        View a2;
        int i6 = view.getLayoutParams().height;
        if ((i6 == -1 || i6 == -2) && (a2 = a(coordinatorLayout.b(view))) != null) {
            if (u.h(a2) && !u.h(view)) {
                u.a(view, true);
                if (u.h(view)) {
                    view.requestLayout();
                    return true;
                }
            }
            int size = View.MeasureSpec.getSize(i4);
            if (size == 0) {
                size = coordinatorLayout.getHeight();
            }
            coordinatorLayout.a(view, i2, i3, View.MeasureSpec.makeMeasureSpec((size - a2.getMeasuredHeight()) + c(a2), i6 == -1 ? 1073741824 : Integer.MIN_VALUE), i5);
            return true;
        }
        return false;
    }

    public abstract float b(View view);

    @Override // a.b.d.x.q
    public void b(CoordinatorLayout coordinatorLayout, View view, int i2) {
        View a2 = a(coordinatorLayout.b(view));
        if (a2 != null) {
            CoordinatorLayout.f fVar = (CoordinatorLayout.f) view.getLayoutParams();
            Rect rect = this.f357d;
            rect.set(coordinatorLayout.getPaddingLeft() + ((ViewGroup.MarginLayoutParams) fVar).leftMargin, a2.getBottom() + ((ViewGroup.MarginLayoutParams) fVar).topMargin, (coordinatorLayout.getWidth() - coordinatorLayout.getPaddingRight()) - ((ViewGroup.MarginLayoutParams) fVar).rightMargin, ((coordinatorLayout.getHeight() + a2.getBottom()) - coordinatorLayout.getPaddingBottom()) - ((ViewGroup.MarginLayoutParams) fVar).bottomMargin);
            d0 lastWindowInsets = coordinatorLayout.getLastWindowInsets();
            if (lastWindowInsets != null && u.h(coordinatorLayout) && !u.h(view)) {
                rect.left += lastWindowInsets.b();
                rect.right -= lastWindowInsets.c();
            }
            Rect rect2 = this.f358e;
            a.b.g.k.d.a(c(fVar.f2187c), view.getMeasuredWidth(), view.getMeasuredHeight(), rect, rect2, i2);
            int a3 = a(a2);
            view.layout(rect2.left, rect2.top - a3, rect2.right, rect2.bottom - a3);
            this.f359f = rect2.top - a2.getBottom();
            return;
        }
        super.b(coordinatorLayout, (CoordinatorLayout) view, i2);
        this.f359f = 0;
    }

    public int c(View view) {
        return view.getMeasuredHeight();
    }

    public final int d() {
        return this.f359f;
    }

    public final int c() {
        return this.f360g;
    }

    public j(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f357d = new Rect();
        this.f358e = new Rect();
        this.f359f = 0;
    }

    public final int a(View view) {
        if (this.f360g == 0) {
            return 0;
        }
        float b2 = b(view);
        int i2 = this.f360g;
        return a.b.g.e.a.a((int) (b2 * i2), 0, i2);
    }

    public final void b(int i2) {
        this.f360g = i2;
    }
}
