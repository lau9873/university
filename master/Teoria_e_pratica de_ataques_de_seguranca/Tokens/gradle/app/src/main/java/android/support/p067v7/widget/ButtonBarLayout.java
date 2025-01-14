package android.support.p067v7.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import p000a.p006b.p030g.p045k.ViewCompat;
import p000a.p006b.p049h.p051b.C0359f;
import p000a.p006b.p049h.p051b.C0363j;

/* renamed from: android.support.v7.widget.ButtonBarLayout */
/* loaded from: classes.dex */
public class ButtonBarLayout extends LinearLayout {

    /* renamed from: a */
    public boolean f4026a;

    /* renamed from: b */
    public int f4027b;

    /* renamed from: c */
    public int f4028c;

    public ButtonBarLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f4027b = -1;
        this.f4028c = 0;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C0363j.ButtonBarLayout);
        this.f4026a = obtainStyledAttributes.getBoolean(C0363j.ButtonBarLayout_allowStacking, true);
        obtainStyledAttributes.recycle();
    }

    private void setStacked(boolean z) {
        setOrientation(z ? 1 : 0);
        setGravity(z ? 5 : 80);
        View findViewById = findViewById(C0359f.spacer);
        if (findViewById != null) {
            findViewById.setVisibility(z ? 8 : 4);
        }
        for (int childCount = getChildCount() - 2; childCount >= 0; childCount--) {
            bringChildToFront(getChildAt(childCount));
        }
    }

    /* renamed from: a */
    public final int m7071a(int i) {
        int childCount = getChildCount();
        while (i < childCount) {
            if (getChildAt(i).getVisibility() == 0) {
                return i;
            }
            i++;
        }
        return -1;
    }

    @Override // android.view.View
    public int getMinimumHeight() {
        return Math.max(this.f4028c, super.getMinimumHeight());
    }

    @Override // android.widget.LinearLayout, android.view.View
    public void onMeasure(int i, int i2) {
        int i3;
        boolean z;
        int size = View.MeasureSpec.getSize(i);
        int i4 = 0;
        if (this.f4026a) {
            if (size > this.f4027b && m7072a()) {
                setStacked(false);
            }
            this.f4027b = size;
        }
        if (m7072a() || View.MeasureSpec.getMode(i) != 1073741824) {
            i3 = i;
            z = false;
        } else {
            i3 = View.MeasureSpec.makeMeasureSpec(size, Integer.MIN_VALUE);
            z = true;
        }
        super.onMeasure(i3, i2);
        if (this.f4026a && !m7072a()) {
            if ((getMeasuredWidthAndState() & (-16777216)) == 16777216) {
                setStacked(true);
                z = true;
            }
        }
        if (z) {
            super.onMeasure(i, i2);
        }
        int m7071a = m7071a(0);
        if (m7071a >= 0) {
            View childAt = getChildAt(m7071a);
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) childAt.getLayoutParams();
            int paddingTop = getPaddingTop() + childAt.getMeasuredHeight() + layoutParams.topMargin + layoutParams.bottomMargin + 0;
            if (m7072a()) {
                int m7071a2 = m7071a(m7071a + 1);
                if (m7071a2 >= 0) {
                    paddingTop += getChildAt(m7071a2).getPaddingTop() + ((int) (getResources().getDisplayMetrics().density * 16.0f));
                }
                i4 = paddingTop;
            } else {
                i4 = paddingTop + getPaddingBottom();
            }
        }
        if (ViewCompat.m9421l(this) != i4) {
            setMinimumHeight(i4);
        }
    }

    public void setAllowStacking(boolean z) {
        if (this.f4026a != z) {
            this.f4026a = z;
            if (!this.f4026a && getOrientation() == 1) {
                setStacked(false);
            }
            requestLayout();
        }
    }

    /* renamed from: a */
    public final boolean m7072a() {
        return getOrientation() == 1;
    }
}
