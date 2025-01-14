package android.support.v7.widget;

import a.b.g.k.u;
import a.b.h.b.f;
import a.b.h.b.g;
import a.b.h.b.j;
import a.b.h.j.b;
import a.b.h.j.j.h;
import a.b.h.k.c;
import a.b.h.k.l1;
import a.b.h.k.t1;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import android.widget.LinearLayout;
import android.widget.TextView;
/* loaded from: classes.dex */
public class ActionBarContextView extends a.b.h.k.a {

    /* renamed from: i  reason: collision with root package name */
    public CharSequence f2481i;
    public CharSequence j;
    public View k;
    public View m;
    public LinearLayout n;
    public TextView o;
    public TextView p;
    public int q;
    public int r;
    public boolean s;
    public int t;

    /* loaded from: classes.dex */
    public class a implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ b f2482a;

        public a(ActionBarContextView actionBarContextView, b bVar) {
            this.f2482a = bVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            this.f2482a.a();
        }
    }

    public ActionBarContextView(Context context) {
        this(context, null);
    }

    public void a(b bVar) {
        View view = this.k;
        if (view == null) {
            this.k = LayoutInflater.from(getContext()).inflate(this.t, (ViewGroup) this, false);
            addView(this.k);
        } else if (view.getParent() == null) {
            addView(this.k);
        }
        this.k.findViewById(f.action_mode_close_button).setOnClickListener(new a(this, bVar));
        h hVar = (h) bVar.c();
        c cVar = this.f1635d;
        if (cVar != null) {
            cVar.e();
        }
        this.f1635d = new c(getContext());
        this.f1635d.c(true);
        ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(-2, -1);
        hVar.a(this.f1635d, this.f1633b);
        this.f1634c = (ActionMenuView) this.f1635d.b(this);
        u.a(this.f1634c, (Drawable) null);
        addView(this.f1634c, layoutParams);
    }

    public final void b() {
        if (this.n == null) {
            LayoutInflater.from(getContext()).inflate(g.abc_action_bar_title_item, this);
            this.n = (LinearLayout) getChildAt(getChildCount() - 1);
            this.o = (TextView) this.n.findViewById(f.action_bar_title);
            this.p = (TextView) this.n.findViewById(f.action_bar_subtitle);
            if (this.q != 0) {
                this.o.setTextAppearance(getContext(), this.q);
            }
            if (this.r != 0) {
                this.p.setTextAppearance(getContext(), this.r);
            }
        }
        this.o.setText(this.f2481i);
        this.p.setText(this.j);
        boolean z = !TextUtils.isEmpty(this.f2481i);
        boolean z2 = !TextUtils.isEmpty(this.j);
        int i2 = 0;
        this.p.setVisibility(z2 ? 0 : 8);
        LinearLayout linearLayout = this.n;
        if (!z && !z2) {
            i2 = 8;
        }
        linearLayout.setVisibility(i2);
        if (this.n.getParent() == null) {
            addView(this.n);
        }
    }

    public boolean c() {
        return this.s;
    }

    public void d() {
        removeAllViews();
        this.m = null;
        this.f1634c = null;
    }

    public boolean e() {
        c cVar = this.f1635d;
        if (cVar != null) {
            return cVar.k();
        }
        return false;
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return new ViewGroup.MarginLayoutParams(-1, -2);
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new ViewGroup.MarginLayoutParams(getContext(), attributeSet);
    }

    @Override // a.b.h.k.a
    public /* bridge */ /* synthetic */ int getAnimatedVisibility() {
        return super.getAnimatedVisibility();
    }

    @Override // a.b.h.k.a
    public /* bridge */ /* synthetic */ int getContentHeight() {
        return super.getContentHeight();
    }

    public CharSequence getSubtitle() {
        return this.j;
    }

    public CharSequence getTitle() {
        return this.f2481i;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        c cVar = this.f1635d;
        if (cVar != null) {
            cVar.g();
            this.f1635d.h();
        }
    }

    @Override // android.view.View
    public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        if (accessibilityEvent.getEventType() == 32) {
            accessibilityEvent.setSource(this);
            accessibilityEvent.setClassName(ActionBarContextView.class.getName());
            accessibilityEvent.setPackageName(getContext().getPackageName());
            accessibilityEvent.setContentDescription(this.f2481i);
            return;
        }
        super.onInitializeAccessibilityEvent(accessibilityEvent);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        int i6;
        boolean a2 = t1.a(this);
        int paddingRight = a2 ? (i4 - i2) - getPaddingRight() : getPaddingLeft();
        int paddingTop = getPaddingTop();
        int paddingTop2 = ((i5 - i3) - getPaddingTop()) - getPaddingBottom();
        View view = this.k;
        if (view == null || view.getVisibility() == 8) {
            i6 = paddingRight;
        } else {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.k.getLayoutParams();
            int i7 = a2 ? marginLayoutParams.rightMargin : marginLayoutParams.leftMargin;
            int i8 = a2 ? marginLayoutParams.leftMargin : marginLayoutParams.rightMargin;
            int a3 = a.b.h.k.a.a(paddingRight, i7, a2);
            i6 = a.b.h.k.a.a(a3 + a(this.k, a3, paddingTop, paddingTop2, a2), i8, a2);
        }
        LinearLayout linearLayout = this.n;
        if (linearLayout != null && this.m == null && linearLayout.getVisibility() != 8) {
            i6 += a(this.n, i6, paddingTop, paddingTop2, a2);
        }
        int i9 = i6;
        View view2 = this.m;
        if (view2 != null) {
            a(view2, i9, paddingTop, paddingTop2, a2);
        }
        int paddingLeft = a2 ? getPaddingLeft() : (i4 - i2) - getPaddingRight();
        ActionMenuView actionMenuView = this.f1634c;
        if (actionMenuView != null) {
            a(actionMenuView, paddingLeft, paddingTop, paddingTop2, !a2);
        }
    }

    @Override // android.view.View
    public void onMeasure(int i2, int i3) {
        if (View.MeasureSpec.getMode(i2) == 1073741824) {
            if (View.MeasureSpec.getMode(i3) != 0) {
                int size = View.MeasureSpec.getSize(i2);
                int i4 = this.f1636e;
                if (i4 <= 0) {
                    i4 = View.MeasureSpec.getSize(i3);
                }
                int paddingTop = getPaddingTop() + getPaddingBottom();
                int paddingLeft = (size - getPaddingLeft()) - getPaddingRight();
                int i5 = i4 - paddingTop;
                int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(i5, Integer.MIN_VALUE);
                View view = this.k;
                if (view != null) {
                    int a2 = a(view, paddingLeft, makeMeasureSpec, 0);
                    ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.k.getLayoutParams();
                    paddingLeft = a2 - (marginLayoutParams.leftMargin + marginLayoutParams.rightMargin);
                }
                ActionMenuView actionMenuView = this.f1634c;
                if (actionMenuView != null && actionMenuView.getParent() == this) {
                    paddingLeft = a(this.f1634c, paddingLeft, makeMeasureSpec, 0);
                }
                LinearLayout linearLayout = this.n;
                if (linearLayout != null && this.m == null) {
                    if (this.s) {
                        this.n.measure(View.MeasureSpec.makeMeasureSpec(0, 0), makeMeasureSpec);
                        int measuredWidth = this.n.getMeasuredWidth();
                        boolean z = measuredWidth <= paddingLeft;
                        if (z) {
                            paddingLeft -= measuredWidth;
                        }
                        this.n.setVisibility(z ? 0 : 8);
                    } else {
                        paddingLeft = a(linearLayout, paddingLeft, makeMeasureSpec, 0);
                    }
                }
                View view2 = this.m;
                if (view2 != null) {
                    ViewGroup.LayoutParams layoutParams = view2.getLayoutParams();
                    int i6 = layoutParams.width != -2 ? 1073741824 : Integer.MIN_VALUE;
                    int i7 = layoutParams.width;
                    if (i7 >= 0) {
                        paddingLeft = Math.min(i7, paddingLeft);
                    }
                    int i8 = layoutParams.height == -2 ? Integer.MIN_VALUE : 1073741824;
                    int i9 = layoutParams.height;
                    if (i9 >= 0) {
                        i5 = Math.min(i9, i5);
                    }
                    this.m.measure(View.MeasureSpec.makeMeasureSpec(paddingLeft, i6), View.MeasureSpec.makeMeasureSpec(i5, i8));
                }
                if (this.f1636e <= 0) {
                    int childCount = getChildCount();
                    int i10 = 0;
                    for (int i11 = 0; i11 < childCount; i11++) {
                        int measuredHeight = getChildAt(i11).getMeasuredHeight() + paddingTop;
                        if (measuredHeight > i10) {
                            i10 = measuredHeight;
                        }
                    }
                    setMeasuredDimension(size, i10);
                    return;
                }
                setMeasuredDimension(size, i4);
                return;
            }
            throw new IllegalStateException(ActionBarContextView.class.getSimpleName() + " can only be used with android:layout_height=\"wrap_content\"");
        }
        throw new IllegalStateException(ActionBarContextView.class.getSimpleName() + " can only be used with android:layout_width=\"match_parent\" (or fill_parent)");
    }

    @Override // a.b.h.k.a
    public void setContentHeight(int i2) {
        this.f1636e = i2;
    }

    public void setCustomView(View view) {
        LinearLayout linearLayout;
        View view2 = this.m;
        if (view2 != null) {
            removeView(view2);
        }
        this.m = view;
        if (view != null && (linearLayout = this.n) != null) {
            removeView(linearLayout);
            this.n = null;
        }
        if (view != null) {
            addView(view);
        }
        requestLayout();
    }

    public void setSubtitle(CharSequence charSequence) {
        this.j = charSequence;
        b();
    }

    public void setTitle(CharSequence charSequence) {
        this.f2481i = charSequence;
        b();
    }

    public void setTitleOptional(boolean z) {
        if (z != this.s) {
            requestLayout();
        }
        this.s = z;
    }

    @Override // a.b.h.k.a, android.view.View
    public /* bridge */ /* synthetic */ void setVisibility(int i2) {
        super.setVisibility(i2);
    }

    @Override // android.view.ViewGroup
    public boolean shouldDelayChildPressedState() {
        return false;
    }

    public ActionBarContextView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, a.b.h.b.a.actionModeStyle);
    }

    public ActionBarContextView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        l1 a2 = l1.a(context, attributeSet, j.ActionMode, i2, 0);
        u.a(this, a2.b(j.ActionMode_background));
        this.q = a2.g(j.ActionMode_titleTextStyle, 0);
        this.r = a2.g(j.ActionMode_subtitleTextStyle, 0);
        this.f1636e = a2.f(j.ActionMode_height, 0);
        this.t = a2.g(j.ActionMode_closeItemLayout, g.abc_action_mode_close_item_material);
        a2.a();
    }

    public void a() {
        if (this.k == null) {
            d();
        }
    }
}
