package android.support.p067v7.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.ActionMode;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import p000a.p006b.p030g.p045k.ViewCompat;
import p000a.p006b.p049h.p051b.C0359f;
import p000a.p006b.p049h.p051b.C0363j;
import p000a.p006b.p049h.p063k.ActionBarBackgroundDrawable;
import p000a.p006b.p049h.p063k.ScrollingTabContainerView;

/* renamed from: android.support.v7.widget.ActionBarContainer */
/* loaded from: classes.dex */
public class ActionBarContainer extends FrameLayout {

    /* renamed from: a */
    public boolean f3953a;

    /* renamed from: b */
    public View f3954b;

    /* renamed from: c */
    public View f3955c;

    /* renamed from: d */
    public View f3956d;

    /* renamed from: e */
    public Drawable f3957e;

    /* renamed from: f */
    public Drawable f3958f;

    /* renamed from: g */
    public Drawable f3959g;

    /* renamed from: h */
    public boolean f3960h;

    /* renamed from: i */
    public boolean f3961i;

    /* renamed from: j */
    public int f3962j;

    public ActionBarContainer(Context context) {
        this(context, null);
    }

    /* renamed from: a */
    public final int m7130a(View view) {
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) view.getLayoutParams();
        return view.getMeasuredHeight() + layoutParams.topMargin + layoutParams.bottomMargin;
    }

    /* renamed from: b */
    public final boolean m7129b(View view) {
        return view == null || view.getVisibility() == 8 || view.getMeasuredHeight() == 0;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void drawableStateChanged() {
        super.drawableStateChanged();
        Drawable drawable = this.f3957e;
        if (drawable != null && drawable.isStateful()) {
            this.f3957e.setState(getDrawableState());
        }
        Drawable drawable2 = this.f3958f;
        if (drawable2 != null && drawable2.isStateful()) {
            this.f3958f.setState(getDrawableState());
        }
        Drawable drawable3 = this.f3959g;
        if (drawable3 == null || !drawable3.isStateful()) {
            return;
        }
        this.f3959g.setState(getDrawableState());
    }

    public View getTabContainer() {
        return this.f3954b;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void jumpDrawablesToCurrentState() {
        super.jumpDrawablesToCurrentState();
        Drawable drawable = this.f3957e;
        if (drawable != null) {
            drawable.jumpToCurrentState();
        }
        Drawable drawable2 = this.f3958f;
        if (drawable2 != null) {
            drawable2.jumpToCurrentState();
        }
        Drawable drawable3 = this.f3959g;
        if (drawable3 != null) {
            drawable3.jumpToCurrentState();
        }
    }

    @Override // android.view.View
    public void onFinishInflate() {
        super.onFinishInflate();
        this.f3955c = findViewById(C0359f.action_bar);
        this.f3956d = findViewById(C0359f.action_context_bar);
    }

    @Override // android.view.View
    public boolean onHoverEvent(MotionEvent motionEvent) {
        super.onHoverEvent(motionEvent);
        return true;
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        return this.f3953a || super.onInterceptTouchEvent(motionEvent);
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        Drawable drawable;
        super.onLayout(z, i, i2, i3, i4);
        View view = this.f3954b;
        boolean z2 = true;
        boolean z3 = false;
        boolean z4 = (view == null || view.getVisibility() == 8) ? false : true;
        if (view != null && view.getVisibility() != 8) {
            int measuredHeight = getMeasuredHeight();
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) view.getLayoutParams();
            view.layout(i, (measuredHeight - view.getMeasuredHeight()) - layoutParams.bottomMargin, i3, measuredHeight - layoutParams.bottomMargin);
        }
        if (this.f3960h) {
            Drawable drawable2 = this.f3959g;
            if (drawable2 != null) {
                drawable2.setBounds(0, 0, getMeasuredWidth(), getMeasuredHeight());
            } else {
                z2 = false;
            }
        } else {
            if (this.f3957e != null) {
                if (this.f3955c.getVisibility() == 0) {
                    this.f3957e.setBounds(this.f3955c.getLeft(), this.f3955c.getTop(), this.f3955c.getRight(), this.f3955c.getBottom());
                } else {
                    View view2 = this.f3956d;
                    if (view2 != null && view2.getVisibility() == 0) {
                        this.f3957e.setBounds(this.f3956d.getLeft(), this.f3956d.getTop(), this.f3956d.getRight(), this.f3956d.getBottom());
                    } else {
                        this.f3957e.setBounds(0, 0, 0, 0);
                    }
                }
                z3 = true;
            }
            this.f3961i = z4;
            if (!z4 || (drawable = this.f3958f) == null) {
                z2 = z3;
            } else {
                drawable.setBounds(view.getLeft(), view.getTop(), view.getRight(), view.getBottom());
            }
        }
        if (z2) {
            invalidate();
        }
    }

    @Override // android.widget.FrameLayout, android.view.View
    public void onMeasure(int i, int i2) {
        int m7130a;
        int i3;
        if (this.f3955c == null && View.MeasureSpec.getMode(i2) == Integer.MIN_VALUE && (i3 = this.f3962j) >= 0) {
            i2 = View.MeasureSpec.makeMeasureSpec(Math.min(i3, View.MeasureSpec.getSize(i2)), Integer.MIN_VALUE);
        }
        super.onMeasure(i, i2);
        if (this.f3955c == null) {
            return;
        }
        int mode = View.MeasureSpec.getMode(i2);
        View view = this.f3954b;
        if (view == null || view.getVisibility() == 8 || mode == 1073741824) {
            return;
        }
        if (!m7129b(this.f3955c)) {
            m7130a = m7130a(this.f3955c);
        } else {
            m7130a = !m7129b(this.f3956d) ? m7130a(this.f3956d) : 0;
        }
        setMeasuredDimension(getMeasuredWidth(), Math.min(m7130a + m7130a(this.f3954b), mode == Integer.MIN_VALUE ? View.MeasureSpec.getSize(i2) : Integer.MAX_VALUE));
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        super.onTouchEvent(motionEvent);
        return true;
    }

    public void setPrimaryBackground(Drawable drawable) {
        Drawable drawable2 = this.f3957e;
        if (drawable2 != null) {
            drawable2.setCallback(null);
            unscheduleDrawable(this.f3957e);
        }
        this.f3957e = drawable;
        if (drawable != null) {
            drawable.setCallback(this);
            View view = this.f3955c;
            if (view != null) {
                this.f3957e.setBounds(view.getLeft(), this.f3955c.getTop(), this.f3955c.getRight(), this.f3955c.getBottom());
            }
        }
        boolean z = true;
        if (!this.f3960h ? this.f3957e != null || this.f3958f != null : this.f3959g != null) {
            z = false;
        }
        setWillNotDraw(z);
        invalidate();
    }

    public void setSplitBackground(Drawable drawable) {
        Drawable drawable2;
        Drawable drawable3 = this.f3959g;
        if (drawable3 != null) {
            drawable3.setCallback(null);
            unscheduleDrawable(this.f3959g);
        }
        this.f3959g = drawable;
        boolean z = false;
        if (drawable != null) {
            drawable.setCallback(this);
            if (this.f3960h && (drawable2 = this.f3959g) != null) {
                drawable2.setBounds(0, 0, getMeasuredWidth(), getMeasuredHeight());
            }
        }
        if (!this.f3960h ? !(this.f3957e != null || this.f3958f != null) : this.f3959g == null) {
            z = true;
        }
        setWillNotDraw(z);
        invalidate();
    }

    public void setStackedBackground(Drawable drawable) {
        Drawable drawable2;
        Drawable drawable3 = this.f3958f;
        if (drawable3 != null) {
            drawable3.setCallback(null);
            unscheduleDrawable(this.f3958f);
        }
        this.f3958f = drawable;
        if (drawable != null) {
            drawable.setCallback(this);
            if (this.f3961i && (drawable2 = this.f3958f) != null) {
                drawable2.setBounds(this.f3954b.getLeft(), this.f3954b.getTop(), this.f3954b.getRight(), this.f3954b.getBottom());
            }
        }
        boolean z = true;
        if (!this.f3960h ? this.f3957e != null || this.f3958f != null : this.f3959g != null) {
            z = false;
        }
        setWillNotDraw(z);
        invalidate();
    }

    public void setTabContainer(ScrollingTabContainerView scrollingTabContainerView) {
        View view = this.f3954b;
        if (view != null) {
            removeView(view);
        }
        this.f3954b = scrollingTabContainerView;
        if (scrollingTabContainerView != null) {
            addView(scrollingTabContainerView);
            ViewGroup.LayoutParams layoutParams = scrollingTabContainerView.getLayoutParams();
            layoutParams.width = -1;
            layoutParams.height = -2;
            scrollingTabContainerView.setAllowCollapse(false);
        }
    }

    public void setTransitioning(boolean z) {
        this.f3953a = z;
        setDescendantFocusability(z ? 393216 : 262144);
    }

    @Override // android.view.View
    public void setVisibility(int i) {
        super.setVisibility(i);
        boolean z = i == 0;
        Drawable drawable = this.f3957e;
        if (drawable != null) {
            drawable.setVisible(z, false);
        }
        Drawable drawable2 = this.f3958f;
        if (drawable2 != null) {
            drawable2.setVisible(z, false);
        }
        Drawable drawable3 = this.f3959g;
        if (drawable3 != null) {
            drawable3.setVisible(z, false);
        }
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public ActionMode startActionModeForChild(View view, ActionMode.Callback callback) {
        return null;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public ActionMode startActionModeForChild(View view, ActionMode.Callback callback, int i) {
        if (i != 0) {
            return super.startActionModeForChild(view, callback, i);
        }
        return null;
    }

    @Override // android.view.View
    public boolean verifyDrawable(Drawable drawable) {
        return (drawable == this.f3957e && !this.f3960h) || (drawable == this.f3958f && this.f3961i) || ((drawable == this.f3959g && this.f3960h) || super.verifyDrawable(drawable));
    }

    public ActionBarContainer(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        ViewCompat.m9447a(this, new ActionBarBackgroundDrawable(this));
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C0363j.ActionBar);
        this.f3957e = obtainStyledAttributes.getDrawable(C0363j.ActionBar_background);
        this.f3958f = obtainStyledAttributes.getDrawable(C0363j.ActionBar_backgroundStacked);
        this.f3962j = obtainStyledAttributes.getDimensionPixelSize(C0363j.ActionBar_height, -1);
        if (getId() == C0359f.split_action_bar) {
            this.f3960h = true;
            this.f3959g = obtainStyledAttributes.getDrawable(C0363j.ActionBar_backgroundSplit);
        }
        obtainStyledAttributes.recycle();
        boolean z = false;
        if (!this.f3960h ? !(this.f3957e != null || this.f3958f != null) : this.f3959g == null) {
            z = true;
        }
        setWillNotDraw(z);
    }
}
