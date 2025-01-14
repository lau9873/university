package p000a.p006b.p012d.p026x;

import android.content.Context;
import android.graphics.Rect;
import android.support.design.widget.CoordinatorLayout;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import java.util.List;
import p000a.p006b.p030g.p038e.C0222a;
import p000a.p006b.p030g.p045k.GravityCompat;
import p000a.p006b.p030g.p045k.ViewCompat;
import p000a.p006b.p030g.p045k.WindowInsetsCompat;

/* renamed from: a.b.d.x.j */
/* loaded from: classes.dex */
public abstract class HeaderScrollingViewBehavior extends ViewOffsetBehavior<View> {

    /* renamed from: d */
    public final Rect f681d;

    /* renamed from: e */
    public final Rect f682e;

    /* renamed from: f */
    public int f683f;

    /* renamed from: g */
    public int f684g;

    public HeaderScrollingViewBehavior() {
        this.f681d = new Rect();
        this.f682e = new Rect();
        this.f683f = 0;
    }

    /* renamed from: c */
    public static int m10734c(int i) {
        if (i == 0) {
            return 8388659;
        }
        return i;
    }

    /* renamed from: a */
    public abstract View mo7812a(List<View> list);

    @Override // android.support.design.widget.CoordinatorLayout.AbstractC0575c
    /* renamed from: a */
    public boolean mo7709a(CoordinatorLayout coordinatorLayout, View view, int i, int i2, int i3, int i4) {
        View mo7812a;
        int i5 = view.getLayoutParams().height;
        if ((i5 == -1 || i5 == -2) && (mo7812a = mo7812a(coordinatorLayout.m7731b(view))) != null) {
            if (ViewCompat.m9426h(mo7812a) && !ViewCompat.m9426h(view)) {
                ViewCompat.m9442a(view, true);
                if (ViewCompat.m9426h(view)) {
                    view.requestLayout();
                    return true;
                }
            }
            int size = View.MeasureSpec.getSize(i3);
            if (size == 0) {
                size = coordinatorLayout.getHeight();
            }
            coordinatorLayout.m7743a(view, i, i2, View.MeasureSpec.makeMeasureSpec((size - mo7812a.getMeasuredHeight()) + mo7809c(mo7812a), i5 == -1 ? 1073741824 : Integer.MIN_VALUE), i4);
            return true;
        }
        return false;
    }

    /* renamed from: b */
    public abstract float mo7811b(View view);

    @Override // p000a.p006b.p012d.p026x.ViewOffsetBehavior
    /* renamed from: b */
    public void mo10656b(CoordinatorLayout coordinatorLayout, View view, int i) {
        View mo7812a = mo7812a(coordinatorLayout.m7731b(view));
        if (mo7812a != null) {
            CoordinatorLayout.C0578f c0578f = (CoordinatorLayout.C0578f) view.getLayoutParams();
            Rect rect = this.f681d;
            rect.set(coordinatorLayout.getPaddingLeft() + ((ViewGroup.MarginLayoutParams) c0578f).leftMargin, mo7812a.getBottom() + ((ViewGroup.MarginLayoutParams) c0578f).topMargin, (coordinatorLayout.getWidth() - coordinatorLayout.getPaddingRight()) - ((ViewGroup.MarginLayoutParams) c0578f).rightMargin, ((coordinatorLayout.getHeight() + mo7812a.getBottom()) - coordinatorLayout.getPaddingBottom()) - ((ViewGroup.MarginLayoutParams) c0578f).bottomMargin);
            WindowInsetsCompat lastWindowInsets = coordinatorLayout.getLastWindowInsets();
            if (lastWindowInsets != null && ViewCompat.m9426h(coordinatorLayout) && !ViewCompat.m9426h(view)) {
                rect.left += lastWindowInsets.m9573b();
                rect.right -= lastWindowInsets.m9572c();
            }
            Rect rect2 = this.f682e;
            GravityCompat.m9578a(m10734c(c0578f.f3329c), view.getMeasuredWidth(), view.getMeasuredHeight(), rect, rect2, i);
            int m10737a = m10737a(mo7812a);
            view.layout(rect2.left, rect2.top - m10737a, rect2.right, rect2.bottom - m10737a);
            this.f683f = rect2.top - mo7812a.getBottom();
            return;
        }
        super.mo10656b(coordinatorLayout, (CoordinatorLayout) view, i);
        this.f683f = 0;
    }

    /* renamed from: c */
    public int mo7809c(View view) {
        return view.getMeasuredHeight();
    }

    /* renamed from: d */
    public final int m10733d() {
        return this.f683f;
    }

    /* renamed from: c */
    public final int m10735c() {
        return this.f684g;
    }

    public HeaderScrollingViewBehavior(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f681d = new Rect();
        this.f682e = new Rect();
        this.f683f = 0;
    }

    /* renamed from: a */
    public final int m10737a(View view) {
        if (this.f684g == 0) {
            return 0;
        }
        float mo7811b = mo7811b(view);
        int i = this.f684g;
        return C0222a.m9830a((int) (mo7811b * i), 0, i);
    }

    /* renamed from: b */
    public final void m10736b(int i) {
        this.f684g = i;
    }
}
