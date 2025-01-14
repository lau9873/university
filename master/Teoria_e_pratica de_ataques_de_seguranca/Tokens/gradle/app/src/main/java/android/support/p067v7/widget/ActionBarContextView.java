package android.support.p067v7.widget;

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
import p000a.p006b.p030g.p045k.ViewCompat;
import p000a.p006b.p049h.p051b.C0354a;
import p000a.p006b.p049h.p051b.C0359f;
import p000a.p006b.p049h.p051b.C0360g;
import p000a.p006b.p049h.p051b.C0363j;
import p000a.p006b.p049h.p061j.ActionMode;
import p000a.p006b.p049h.p061j.p062j.MenuBuilder;
import p000a.p006b.p049h.p063k.AbsActionBarView;
import p000a.p006b.p049h.p063k.ActionMenuPresenter;
import p000a.p006b.p049h.p063k.C0504t1;
import p000a.p006b.p049h.p063k.TintTypedArray;

/* renamed from: android.support.v7.widget.ActionBarContextView */
/* loaded from: classes.dex */
public class ActionBarContextView extends AbsActionBarView {

    /* renamed from: i */
    public CharSequence f3963i;

    /* renamed from: j */
    public CharSequence f3964j;

    /* renamed from: k */
    public View f3965k;

    /* renamed from: m */
    public View f3966m;

    /* renamed from: n */
    public LinearLayout f3967n;

    /* renamed from: o */
    public TextView f3968o;

    /* renamed from: p */
    public TextView f3969p;

    /* renamed from: q */
    public int f3970q;

    /* renamed from: r */
    public int f3971r;

    /* renamed from: s */
    public boolean f3972s;

    /* renamed from: t */
    public int f3973t;

    /* renamed from: android.support.v7.widget.ActionBarContextView$a */
    /* loaded from: classes.dex */
    public class View$OnClickListenerC0680a implements View.OnClickListener {

        /* renamed from: a */
        public final /* synthetic */ ActionMode f3974a;

        public View$OnClickListenerC0680a(ActionBarContextView actionBarContextView, ActionMode actionMode) {
            this.f3974a = actionMode;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            this.f3974a.mo8767a();
        }
    }

    public ActionBarContextView(Context context) {
        this(context, null);
    }

    /* renamed from: a */
    public void m7127a(ActionMode actionMode) {
        View view = this.f3965k;
        if (view == null) {
            this.f3965k = LayoutInflater.from(getContext()).inflate(this.f3973t, (ViewGroup) this, false);
            addView(this.f3965k);
        } else if (view.getParent() == null) {
            addView(this.f3965k);
        }
        this.f3965k.findViewById(C0359f.action_mode_close_button).setOnClickListener(new View$OnClickListenerC0680a(this, actionMode));
        MenuBuilder menuBuilder = (MenuBuilder) actionMode.mo8759c();
        ActionMenuPresenter actionMenuPresenter = this.f2496d;
        if (actionMenuPresenter != null) {
            actionMenuPresenter.m8493e();
        }
        this.f2496d = new ActionMenuPresenter(getContext());
        this.f2496d.m8495c(true);
        ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(-2, -1);
        menuBuilder.m8691a(this.f2496d, this.f2494b);
        this.f2495c = (ActionMenuView) this.f2496d.mo8498b(this);
        ViewCompat.m9447a(this.f2495c, (Drawable) null);
        addView(this.f2495c, layoutParams);
    }

    /* renamed from: b */
    public final void m7126b() {
        if (this.f3967n == null) {
            LayoutInflater.from(getContext()).inflate(C0360g.abc_action_bar_title_item, this);
            this.f3967n = (LinearLayout) getChildAt(getChildCount() - 1);
            this.f3968o = (TextView) this.f3967n.findViewById(C0359f.action_bar_title);
            this.f3969p = (TextView) this.f3967n.findViewById(C0359f.action_bar_subtitle);
            if (this.f3970q != 0) {
                this.f3968o.setTextAppearance(getContext(), this.f3970q);
            }
            if (this.f3971r != 0) {
                this.f3969p.setTextAppearance(getContext(), this.f3971r);
            }
        }
        this.f3968o.setText(this.f3963i);
        this.f3969p.setText(this.f3964j);
        boolean z = !TextUtils.isEmpty(this.f3963i);
        boolean z2 = !TextUtils.isEmpty(this.f3964j);
        int i = 0;
        this.f3969p.setVisibility(z2 ? 0 : 8);
        LinearLayout linearLayout = this.f3967n;
        if (!z && !z2) {
            i = 8;
        }
        linearLayout.setVisibility(i);
        if (this.f3967n.getParent() == null) {
            addView(this.f3967n);
        }
    }

    /* renamed from: c */
    public boolean m7125c() {
        return this.f3972s;
    }

    /* renamed from: d */
    public void m7124d() {
        removeAllViews();
        this.f3966m = null;
        this.f2495c = null;
    }

    /* renamed from: e */
    public boolean m7123e() {
        ActionMenuPresenter actionMenuPresenter = this.f2496d;
        if (actionMenuPresenter != null) {
            return actionMenuPresenter.m8485k();
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

    @Override // p000a.p006b.p049h.p063k.AbsActionBarView
    public /* bridge */ /* synthetic */ int getAnimatedVisibility() {
        return super.getAnimatedVisibility();
    }

    @Override // p000a.p006b.p049h.p063k.AbsActionBarView
    public /* bridge */ /* synthetic */ int getContentHeight() {
        return super.getContentHeight();
    }

    public CharSequence getSubtitle() {
        return this.f3964j;
    }

    public CharSequence getTitle() {
        return this.f3963i;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        ActionMenuPresenter actionMenuPresenter = this.f2496d;
        if (actionMenuPresenter != null) {
            actionMenuPresenter.m8489g();
            this.f2496d.m8488h();
        }
    }

    @Override // android.view.View
    public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        if (accessibilityEvent.getEventType() == 32) {
            accessibilityEvent.setSource(this);
            accessibilityEvent.setClassName(ActionBarContextView.class.getName());
            accessibilityEvent.setPackageName(getContext().getPackageName());
            accessibilityEvent.setContentDescription(this.f3963i);
            return;
        }
        super.onInitializeAccessibilityEvent(accessibilityEvent);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int i5;
        boolean m8047a = C0504t1.m8047a(this);
        int paddingRight = m8047a ? (i3 - i) - getPaddingRight() : getPaddingLeft();
        int paddingTop = getPaddingTop();
        int paddingTop2 = ((i4 - i2) - getPaddingTop()) - getPaddingBottom();
        View view = this.f3965k;
        if (view == null || view.getVisibility() == 8) {
            i5 = paddingRight;
        } else {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.f3965k.getLayoutParams();
            int i6 = m8047a ? marginLayoutParams.rightMargin : marginLayoutParams.leftMargin;
            int i7 = m8047a ? marginLayoutParams.leftMargin : marginLayoutParams.rightMargin;
            int m8568a = AbsActionBarView.m8568a(paddingRight, i6, m8047a);
            i5 = AbsActionBarView.m8568a(m8568a + m8564a(this.f3965k, m8568a, paddingTop, paddingTop2, m8047a), i7, m8047a);
        }
        LinearLayout linearLayout = this.f3967n;
        if (linearLayout != null && this.f3966m == null && linearLayout.getVisibility() != 8) {
            i5 += m8564a(this.f3967n, i5, paddingTop, paddingTop2, m8047a);
        }
        int i8 = i5;
        View view2 = this.f3966m;
        if (view2 != null) {
            m8564a(view2, i8, paddingTop, paddingTop2, m8047a);
        }
        int paddingLeft = m8047a ? getPaddingLeft() : (i3 - i) - getPaddingRight();
        ActionMenuView actionMenuView = this.f2495c;
        if (actionMenuView != null) {
            m8564a(actionMenuView, paddingLeft, paddingTop, paddingTop2, !m8047a);
        }
    }

    @Override // android.view.View
    public void onMeasure(int i, int i2) {
        if (View.MeasureSpec.getMode(i) == 1073741824) {
            if (View.MeasureSpec.getMode(i2) != 0) {
                int size = View.MeasureSpec.getSize(i);
                int i3 = this.f2497e;
                if (i3 <= 0) {
                    i3 = View.MeasureSpec.getSize(i2);
                }
                int paddingTop = getPaddingTop() + getPaddingBottom();
                int paddingLeft = (size - getPaddingLeft()) - getPaddingRight();
                int i4 = i3 - paddingTop;
                int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(i4, Integer.MIN_VALUE);
                View view = this.f3965k;
                if (view != null) {
                    int m8565a = m8565a(view, paddingLeft, makeMeasureSpec, 0);
                    ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.f3965k.getLayoutParams();
                    paddingLeft = m8565a - (marginLayoutParams.leftMargin + marginLayoutParams.rightMargin);
                }
                ActionMenuView actionMenuView = this.f2495c;
                if (actionMenuView != null && actionMenuView.getParent() == this) {
                    paddingLeft = m8565a(this.f2495c, paddingLeft, makeMeasureSpec, 0);
                }
                LinearLayout linearLayout = this.f3967n;
                if (linearLayout != null && this.f3966m == null) {
                    if (this.f3972s) {
                        this.f3967n.measure(View.MeasureSpec.makeMeasureSpec(0, 0), makeMeasureSpec);
                        int measuredWidth = this.f3967n.getMeasuredWidth();
                        boolean z = measuredWidth <= paddingLeft;
                        if (z) {
                            paddingLeft -= measuredWidth;
                        }
                        this.f3967n.setVisibility(z ? 0 : 8);
                    } else {
                        paddingLeft = m8565a(linearLayout, paddingLeft, makeMeasureSpec, 0);
                    }
                }
                View view2 = this.f3966m;
                if (view2 != null) {
                    ViewGroup.LayoutParams layoutParams = view2.getLayoutParams();
                    int i5 = layoutParams.width != -2 ? 1073741824 : Integer.MIN_VALUE;
                    int i6 = layoutParams.width;
                    if (i6 >= 0) {
                        paddingLeft = Math.min(i6, paddingLeft);
                    }
                    int i7 = layoutParams.height == -2 ? Integer.MIN_VALUE : 1073741824;
                    int i8 = layoutParams.height;
                    if (i8 >= 0) {
                        i4 = Math.min(i8, i4);
                    }
                    this.f3966m.measure(View.MeasureSpec.makeMeasureSpec(paddingLeft, i5), View.MeasureSpec.makeMeasureSpec(i4, i7));
                }
                if (this.f2497e <= 0) {
                    int childCount = getChildCount();
                    int i9 = 0;
                    for (int i10 = 0; i10 < childCount; i10++) {
                        int measuredHeight = getChildAt(i10).getMeasuredHeight() + paddingTop;
                        if (measuredHeight > i9) {
                            i9 = measuredHeight;
                        }
                    }
                    setMeasuredDimension(size, i9);
                    return;
                }
                setMeasuredDimension(size, i3);
                return;
            }
            throw new IllegalStateException(ActionBarContextView.class.getSimpleName() + " can only be used with android:layout_height=\"wrap_content\"");
        }
        throw new IllegalStateException(ActionBarContextView.class.getSimpleName() + " can only be used with android:layout_width=\"match_parent\" (or fill_parent)");
    }

    @Override // p000a.p006b.p049h.p063k.AbsActionBarView
    public void setContentHeight(int i) {
        this.f2497e = i;
    }

    public void setCustomView(View view) {
        LinearLayout linearLayout;
        View view2 = this.f3966m;
        if (view2 != null) {
            removeView(view2);
        }
        this.f3966m = view;
        if (view != null && (linearLayout = this.f3967n) != null) {
            removeView(linearLayout);
            this.f3967n = null;
        }
        if (view != null) {
            addView(view);
        }
        requestLayout();
    }

    public void setSubtitle(CharSequence charSequence) {
        this.f3964j = charSequence;
        m7126b();
    }

    public void setTitle(CharSequence charSequence) {
        this.f3963i = charSequence;
        m7126b();
    }

    public void setTitleOptional(boolean z) {
        if (z != this.f3972s) {
            requestLayout();
        }
        this.f3972s = z;
    }

    @Override // p000a.p006b.p049h.p063k.AbsActionBarView, android.view.View
    public /* bridge */ /* synthetic */ void setVisibility(int i) {
        super.setVisibility(i);
    }

    @Override // android.view.ViewGroup
    public boolean shouldDelayChildPressedState() {
        return false;
    }

    public ActionBarContextView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, C0354a.actionModeStyle);
    }

    public ActionBarContextView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        TintTypedArray m8257a = TintTypedArray.m8257a(context, attributeSet, C0363j.ActionMode, i, 0);
        ViewCompat.m9447a(this, m8257a.m8256b(C0363j.ActionMode_background));
        this.f3970q = m8257a.m8244g(C0363j.ActionMode_titleTextStyle, 0);
        this.f3971r = m8257a.m8244g(C0363j.ActionMode_subtitleTextStyle, 0);
        this.f2497e = m8257a.m8246f(C0363j.ActionMode_height, 0);
        this.f3973t = m8257a.m8244g(C0363j.ActionMode_closeItemLayout, C0360g.abc_action_mode_close_item_material);
        m8257a.m8265a();
    }

    /* renamed from: a */
    public void m7128a() {
        if (this.f3965k == null) {
            m7124d();
        }
    }
}
