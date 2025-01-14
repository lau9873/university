package android.support.v7.widget;

import a.b.g.k.u;
import a.b.h.b.f;
import a.b.h.b.j;
import a.b.h.k.b;
import a.b.h.k.d1;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.ActionMode;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
/* loaded from: classes.dex */
public class ActionBarContainer extends FrameLayout {

    /* renamed from: a  reason: collision with root package name */
    public boolean f2472a;

    /* renamed from: b  reason: collision with root package name */
    public View f2473b;

    /* renamed from: c  reason: collision with root package name */
    public View f2474c;

    /* renamed from: d  reason: collision with root package name */
    public View f2475d;

    /* renamed from: e  reason: collision with root package name */
    public Drawable f2476e;

    /* renamed from: f  reason: collision with root package name */
    public Drawable f2477f;

    /* renamed from: g  reason: collision with root package name */
    public Drawable f2478g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f2479h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f2480i;
    public int j;

    public ActionBarContainer(Context context) {
        this(context, null);
    }

    public final int a(View view) {
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) view.getLayoutParams();
        return view.getMeasuredHeight() + layoutParams.topMargin + layoutParams.bottomMargin;
    }

    public final boolean b(View view) {
        return view == null || view.getVisibility() == 8 || view.getMeasuredHeight() == 0;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void drawableStateChanged() {
        super.drawableStateChanged();
        Drawable drawable = this.f2476e;
        if (drawable != null && drawable.isStateful()) {
            this.f2476e.setState(getDrawableState());
        }
        Drawable drawable2 = this.f2477f;
        if (drawable2 != null && drawable2.isStateful()) {
            this.f2477f.setState(getDrawableState());
        }
        Drawable drawable3 = this.f2478g;
        if (drawable3 == null || !drawable3.isStateful()) {
            return;
        }
        this.f2478g.setState(getDrawableState());
    }

    public View getTabContainer() {
        return this.f2473b;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void jumpDrawablesToCurrentState() {
        super.jumpDrawablesToCurrentState();
        Drawable drawable = this.f2476e;
        if (drawable != null) {
            drawable.jumpToCurrentState();
        }
        Drawable drawable2 = this.f2477f;
        if (drawable2 != null) {
            drawable2.jumpToCurrentState();
        }
        Drawable drawable3 = this.f2478g;
        if (drawable3 != null) {
            drawable3.jumpToCurrentState();
        }
    }

    @Override // android.view.View
    public void onFinishInflate() {
        super.onFinishInflate();
        this.f2474c = findViewById(f.action_bar);
        this.f2475d = findViewById(f.action_context_bar);
    }

    @Override // android.view.View
    public boolean onHoverEvent(MotionEvent motionEvent) {
        super.onHoverEvent(motionEvent);
        return true;
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        return this.f2472a || super.onInterceptTouchEvent(motionEvent);
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        Drawable drawable;
        super.onLayout(z, i2, i3, i4, i5);
        View view = this.f2473b;
        boolean z2 = true;
        boolean z3 = false;
        boolean z4 = (view == null || view.getVisibility() == 8) ? false : true;
        if (view != null && view.getVisibility() != 8) {
            int measuredHeight = getMeasuredHeight();
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) view.getLayoutParams();
            view.layout(i2, (measuredHeight - view.getMeasuredHeight()) - layoutParams.bottomMargin, i4, measuredHeight - layoutParams.bottomMargin);
        }
        if (this.f2479h) {
            Drawable drawable2 = this.f2478g;
            if (drawable2 != null) {
                drawable2.setBounds(0, 0, getMeasuredWidth(), getMeasuredHeight());
            } else {
                z2 = false;
            }
        } else {
            if (this.f2476e != null) {
                if (this.f2474c.getVisibility() == 0) {
                    this.f2476e.setBounds(this.f2474c.getLeft(), this.f2474c.getTop(), this.f2474c.getRight(), this.f2474c.getBottom());
                } else {
                    View view2 = this.f2475d;
                    if (view2 != null && view2.getVisibility() == 0) {
                        this.f2476e.setBounds(this.f2475d.getLeft(), this.f2475d.getTop(), this.f2475d.getRight(), this.f2475d.getBottom());
                    } else {
                        this.f2476e.setBounds(0, 0, 0, 0);
                    }
                }
                z3 = true;
            }
            this.f2480i = z4;
            if (!z4 || (drawable = this.f2477f) == null) {
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
    public void onMeasure(int i2, int i3) {
        int a2;
        int i4;
        if (this.f2474c == null && View.MeasureSpec.getMode(i3) == Integer.MIN_VALUE && (i4 = this.j) >= 0) {
            i3 = View.MeasureSpec.makeMeasureSpec(Math.min(i4, View.MeasureSpec.getSize(i3)), Integer.MIN_VALUE);
        }
        super.onMeasure(i2, i3);
        if (this.f2474c == null) {
            return;
        }
        int mode = View.MeasureSpec.getMode(i3);
        View view = this.f2473b;
        if (view == null || view.getVisibility() == 8 || mode == 1073741824) {
            return;
        }
        if (!b(this.f2474c)) {
            a2 = a(this.f2474c);
        } else {
            a2 = !b(this.f2475d) ? a(this.f2475d) : 0;
        }
        setMeasuredDimension(getMeasuredWidth(), Math.min(a2 + a(this.f2473b), mode == Integer.MIN_VALUE ? View.MeasureSpec.getSize(i3) : Integer.MAX_VALUE));
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        super.onTouchEvent(motionEvent);
        return true;
    }

    public void setPrimaryBackground(Drawable drawable) {
        Drawable drawable2 = this.f2476e;
        if (drawable2 != null) {
            drawable2.setCallback(null);
            unscheduleDrawable(this.f2476e);
        }
        this.f2476e = drawable;
        if (drawable != null) {
            drawable.setCallback(this);
            View view = this.f2474c;
            if (view != null) {
                this.f2476e.setBounds(view.getLeft(), this.f2474c.getTop(), this.f2474c.getRight(), this.f2474c.getBottom());
            }
        }
        boolean z = true;
        if (!this.f2479h ? this.f2476e != null || this.f2477f != null : this.f2478g != null) {
            z = false;
        }
        setWillNotDraw(z);
        invalidate();
    }

    public void setSplitBackground(Drawable drawable) {
        Drawable drawable2;
        Drawable drawable3 = this.f2478g;
        if (drawable3 != null) {
            drawable3.setCallback(null);
            unscheduleDrawable(this.f2478g);
        }
        this.f2478g = drawable;
        boolean z = false;
        if (drawable != null) {
            drawable.setCallback(this);
            if (this.f2479h && (drawable2 = this.f2478g) != null) {
                drawable2.setBounds(0, 0, getMeasuredWidth(), getMeasuredHeight());
            }
        }
        if (!this.f2479h ? !(this.f2476e != null || this.f2477f != null) : this.f2478g == null) {
            z = true;
        }
        setWillNotDraw(z);
        invalidate();
    }

    public void setStackedBackground(Drawable drawable) {
        Drawable drawable2;
        Drawable drawable3 = this.f2477f;
        if (drawable3 != null) {
            drawable3.setCallback(null);
            unscheduleDrawable(this.f2477f);
        }
        this.f2477f = drawable;
        if (drawable != null) {
            drawable.setCallback(this);
            if (this.f2480i && (drawable2 = this.f2477f) != null) {
                drawable2.setBounds(this.f2473b.getLeft(), this.f2473b.getTop(), this.f2473b.getRight(), this.f2473b.getBottom());
            }
        }
        boolean z = true;
        if (!this.f2479h ? this.f2476e != null || this.f2477f != null : this.f2478g != null) {
            z = false;
        }
        setWillNotDraw(z);
        invalidate();
    }

    public void setTabContainer(d1 d1Var) {
        View view = this.f2473b;
        if (view != null) {
            removeView(view);
        }
        this.f2473b = d1Var;
        if (d1Var != null) {
            addView(d1Var);
            ViewGroup.LayoutParams layoutParams = d1Var.getLayoutParams();
            layoutParams.width = -1;
            layoutParams.height = -2;
            d1Var.setAllowCollapse(false);
        }
    }

    public void setTransitioning(boolean z) {
        this.f2472a = z;
        setDescendantFocusability(z ? 393216 : 262144);
    }

    @Override // android.view.View
    public void setVisibility(int i2) {
        super.setVisibility(i2);
        boolean z = i2 == 0;
        Drawable drawable = this.f2476e;
        if (drawable != null) {
            drawable.setVisible(z, false);
        }
        Drawable drawable2 = this.f2477f;
        if (drawable2 != null) {
            drawable2.setVisible(z, false);
        }
        Drawable drawable3 = this.f2478g;
        if (drawable3 != null) {
            drawable3.setVisible(z, false);
        }
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public ActionMode startActionModeForChild(View view, ActionMode.Callback callback) {
        return null;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public ActionMode startActionModeForChild(View view, ActionMode.Callback callback, int i2) {
        if (i2 != 0) {
            return super.startActionModeForChild(view, callback, i2);
        }
        return null;
    }

    @Override // android.view.View
    public boolean verifyDrawable(Drawable drawable) {
        return (drawable == this.f2476e && !this.f2479h) || (drawable == this.f2477f && this.f2480i) || ((drawable == this.f2478g && this.f2479h) || super.verifyDrawable(drawable));
    }

    public ActionBarContainer(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        u.a(this, new b(this));
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, j.ActionBar);
        this.f2476e = obtainStyledAttributes.getDrawable(j.ActionBar_background);
        this.f2477f = obtainStyledAttributes.getDrawable(j.ActionBar_backgroundStacked);
        this.j = obtainStyledAttributes.getDimensionPixelSize(j.ActionBar_height, -1);
        if (getId() == f.split_action_bar) {
            this.f2479h = true;
            this.f2478g = obtainStyledAttributes.getDrawable(j.ActionBar_backgroundSplit);
        }
        obtainStyledAttributes.recycle();
        boolean z = false;
        if (!this.f2479h ? !(this.f2476e != null || this.f2477f != null) : this.f2478g == null) {
            z = true;
        }
        setWillNotDraw(z);
    }
}
