package p000a.p006b.p049h.p063k;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import p000a.p006b.p049h.p051b.C0363j;

/* renamed from: a.b.h.k.r0 */
/* loaded from: classes.dex */
public class LinearLayoutCompat extends ViewGroup {

    /* renamed from: a */
    public boolean f2884a;

    /* renamed from: b */
    public int f2885b;

    /* renamed from: c */
    public int f2886c;

    /* renamed from: d */
    public int f2887d;

    /* renamed from: e */
    public int f2888e;

    /* renamed from: f */
    public int f2889f;

    /* renamed from: g */
    public float f2890g;

    /* renamed from: h */
    public boolean f2891h;

    /* renamed from: i */
    public int[] f2892i;

    /* renamed from: j */
    public int[] f2893j;

    /* renamed from: k */
    public Drawable f2894k;

    /* renamed from: m */
    public int f2895m;

    /* renamed from: n */
    public int f2896n;

    /* renamed from: o */
    public int f2897o;

    /* renamed from: p */
    public int f2898p;

    public LinearLayoutCompat(Context context) {
        this(context, null);
    }

    /* renamed from: a */
    public int m8121a(View view) {
        return 0;
    }

    /* renamed from: a */
    public int m8120a(View view, int i) {
        return 0;
    }

    /* renamed from: a */
    public void m8123a(Canvas canvas) {
        int right;
        int left;
        int i;
        int left2;
        int virtualChildCount = getVirtualChildCount();
        boolean m8047a = C0504t1.m8047a(this);
        for (int i2 = 0; i2 < virtualChildCount; i2++) {
            View m8126a = m8126a(i2);
            if (m8126a != null && m8126a.getVisibility() != 8 && m8117b(i2)) {
                C0492a c0492a = (C0492a) m8126a.getLayoutParams();
                if (m8047a) {
                    left2 = m8126a.getRight() + ((ViewGroup.MarginLayoutParams) c0492a).rightMargin;
                } else {
                    left2 = (m8126a.getLeft() - ((ViewGroup.MarginLayoutParams) c0492a).leftMargin) - this.f2895m;
                }
                m8113b(canvas, left2);
            }
        }
        if (m8117b(virtualChildCount)) {
            View m8126a2 = m8126a(virtualChildCount - 1);
            if (m8126a2 != null) {
                C0492a c0492a2 = (C0492a) m8126a2.getLayoutParams();
                if (m8047a) {
                    left = m8126a2.getLeft() - ((ViewGroup.MarginLayoutParams) c0492a2).leftMargin;
                    i = this.f2895m;
                    right = left - i;
                } else {
                    right = m8126a2.getRight() + ((ViewGroup.MarginLayoutParams) c0492a2).rightMargin;
                }
            } else if (m8047a) {
                right = getPaddingLeft();
            } else {
                left = getWidth() - getPaddingRight();
                i = this.f2895m;
                right = left - i;
            }
            m8113b(canvas, right);
        }
    }

    /* renamed from: b */
    public int m8112b(View view) {
        return 0;
    }

    /* renamed from: b */
    public void m8114b(Canvas canvas) {
        int bottom;
        int virtualChildCount = getVirtualChildCount();
        for (int i = 0; i < virtualChildCount; i++) {
            View m8126a = m8126a(i);
            if (m8126a != null && m8126a.getVisibility() != 8 && m8117b(i)) {
                m8122a(canvas, (m8126a.getTop() - ((ViewGroup.MarginLayoutParams) ((C0492a) m8126a.getLayoutParams())).topMargin) - this.f2896n);
            }
        }
        if (m8117b(virtualChildCount)) {
            View m8126a2 = m8126a(virtualChildCount - 1);
            if (m8126a2 == null) {
                bottom = (getHeight() - getPaddingBottom()) - this.f2896n;
            } else {
                bottom = m8126a2.getBottom() + ((ViewGroup.MarginLayoutParams) ((C0492a) m8126a2.getLayoutParams())).bottomMargin;
            }
            m8122a(canvas, bottom);
        }
    }

    /* renamed from: c */
    public int m8111c(int i) {
        return 0;
    }

    /* JADX WARN: Removed duplicated region for block: B:67:0x0196  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x01ca  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x01d5  */
    /* renamed from: c */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void m8110c(int r39, int r40) {
        /*
            Method dump skipped, instructions count: 1300
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: p000a.p006b.p049h.p063k.LinearLayoutCompat.m8110c(int, int):void");
    }

    @Override // android.view.ViewGroup
    public boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof C0492a;
    }

    /* JADX WARN: Removed duplicated region for block: B:151:0x032e  */
    /* renamed from: d */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void m8109d(int r34, int r35) {
        /*
            Method dump skipped, instructions count: 921
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: p000a.p006b.p049h.p063k.LinearLayoutCompat.m8109d(int, int):void");
    }

    @Override // android.view.View
    public int getBaseline() {
        int i;
        if (this.f2885b < 0) {
            return super.getBaseline();
        }
        int childCount = getChildCount();
        int i2 = this.f2885b;
        if (childCount > i2) {
            View childAt = getChildAt(i2);
            int baseline = childAt.getBaseline();
            if (baseline == -1) {
                if (this.f2885b == 0) {
                    return -1;
                }
                throw new RuntimeException("mBaselineAlignedChildIndex of LinearLayout points to a View that doesn't know how to get its baseline.");
            }
            int i3 = this.f2886c;
            if (this.f2887d == 1 && (i = this.f2888e & 112) != 48) {
                if (i == 16) {
                    i3 += ((((getBottom() - getTop()) - getPaddingTop()) - getPaddingBottom()) - this.f2889f) / 2;
                } else if (i == 80) {
                    i3 = ((getBottom() - getTop()) - getPaddingBottom()) - this.f2889f;
                }
            }
            return i3 + ((ViewGroup.MarginLayoutParams) ((C0492a) childAt.getLayoutParams())).topMargin + baseline;
        }
        throw new RuntimeException("mBaselineAlignedChildIndex of LinearLayout set to an index that is out of bounds.");
    }

    public int getBaselineAlignedChildIndex() {
        return this.f2885b;
    }

    public Drawable getDividerDrawable() {
        return this.f2894k;
    }

    public int getDividerPadding() {
        return this.f2898p;
    }

    public int getDividerWidth() {
        return this.f2895m;
    }

    public int getGravity() {
        return this.f2888e;
    }

    public int getOrientation() {
        return this.f2887d;
    }

    public int getShowDividers() {
        return this.f2897o;
    }

    public int getVirtualChildCount() {
        return getChildCount();
    }

    public float getWeightSum() {
        return this.f2890g;
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        if (this.f2894k == null) {
            return;
        }
        if (this.f2887d == 1) {
            m8114b(canvas);
        } else {
            m8123a(canvas);
        }
    }

    @Override // android.view.View
    public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        super.onInitializeAccessibilityEvent(accessibilityEvent);
        accessibilityEvent.setClassName(LinearLayoutCompat.class.getName());
    }

    @Override // android.view.View
    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        accessibilityNodeInfo.setClassName(LinearLayoutCompat.class.getName());
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        if (this.f2887d == 1) {
            m8115b(i, i2, i3, i4);
        } else {
            m8124a(i, i2, i3, i4);
        }
    }

    @Override // android.view.View
    public void onMeasure(int i, int i2) {
        if (this.f2887d == 1) {
            m8109d(i, i2);
        } else {
            m8110c(i, i2);
        }
    }

    public void setBaselineAligned(boolean z) {
        this.f2884a = z;
    }

    public void setBaselineAlignedChildIndex(int i) {
        if (i >= 0 && i < getChildCount()) {
            this.f2885b = i;
            return;
        }
        throw new IllegalArgumentException("base aligned child index out of range (0, " + getChildCount() + ")");
    }

    public void setDividerDrawable(Drawable drawable) {
        if (drawable == this.f2894k) {
            return;
        }
        this.f2894k = drawable;
        if (drawable != null) {
            this.f2895m = drawable.getIntrinsicWidth();
            this.f2896n = drawable.getIntrinsicHeight();
        } else {
            this.f2895m = 0;
            this.f2896n = 0;
        }
        setWillNotDraw(drawable == null);
        requestLayout();
    }

    public void setDividerPadding(int i) {
        this.f2898p = i;
    }

    public void setGravity(int i) {
        if (this.f2888e != i) {
            if ((8388615 & i) == 0) {
                i |= 8388611;
            }
            if ((i & 112) == 0) {
                i |= 48;
            }
            this.f2888e = i;
            requestLayout();
        }
    }

    public void setHorizontalGravity(int i) {
        int i2 = i & 8388615;
        int i3 = this.f2888e;
        if ((8388615 & i3) != i2) {
            this.f2888e = i2 | ((-8388616) & i3);
            requestLayout();
        }
    }

    public void setMeasureWithLargestChildEnabled(boolean z) {
        this.f2891h = z;
    }

    public void setOrientation(int i) {
        if (this.f2887d != i) {
            this.f2887d = i;
            requestLayout();
        }
    }

    public void setShowDividers(int i) {
        if (i != this.f2897o) {
            requestLayout();
        }
        this.f2897o = i;
    }

    public void setVerticalGravity(int i) {
        int i2 = i & 112;
        int i3 = this.f2888e;
        if ((i3 & 112) != i2) {
            this.f2888e = i2 | (i3 & (-113));
            requestLayout();
        }
    }

    public void setWeightSum(float f) {
        this.f2890g = Math.max(0.0f, f);
    }

    @Override // android.view.ViewGroup
    public boolean shouldDelayChildPressedState() {
        return false;
    }

    public LinearLayoutCompat(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    @Override // android.view.ViewGroup
    public C0492a generateDefaultLayoutParams() {
        int i = this.f2887d;
        if (i == 0) {
            return new C0492a(-2, -2);
        }
        if (i == 1) {
            return new C0492a(-1, -2);
        }
        return null;
    }

    public LinearLayoutCompat(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f2884a = true;
        this.f2885b = -1;
        this.f2886c = 0;
        this.f2888e = 8388659;
        TintTypedArray m8257a = TintTypedArray.m8257a(context, attributeSet, C0363j.LinearLayoutCompat, i, 0);
        int m8250d = m8257a.m8250d(C0363j.LinearLayoutCompat_android_orientation, -1);
        if (m8250d >= 0) {
            setOrientation(m8250d);
        }
        int m8250d2 = m8257a.m8250d(C0363j.LinearLayoutCompat_android_gravity, -1);
        if (m8250d2 >= 0) {
            setGravity(m8250d2);
        }
        boolean m8260a = m8257a.m8260a(C0363j.LinearLayoutCompat_android_baselineAligned, true);
        if (!m8260a) {
            setBaselineAligned(m8260a);
        }
        this.f2890g = m8257a.m8255b(C0363j.LinearLayoutCompat_android_weightSum, -1.0f);
        this.f2885b = m8257a.m8250d(C0363j.LinearLayoutCompat_android_baselineAlignedChildIndex, -1);
        this.f2891h = m8257a.m8260a(C0363j.LinearLayoutCompat_measureWithLargestChild, false);
        setDividerDrawable(m8257a.m8256b(C0363j.LinearLayoutCompat_divider));
        this.f2897o = m8257a.m8250d(C0363j.LinearLayoutCompat_showDividers, 0);
        this.f2898p = m8257a.m8252c(C0363j.LinearLayoutCompat_dividerPadding, 0);
        m8257a.m8265a();
    }

    @Override // android.view.ViewGroup
    public C0492a generateLayoutParams(AttributeSet attributeSet) {
        return new C0492a(getContext(), attributeSet);
    }

    @Override // android.view.ViewGroup
    public C0492a generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return new C0492a(layoutParams);
    }

    /* compiled from: LinearLayoutCompat.java */
    /* renamed from: a.b.h.k.r0$a */
    /* loaded from: classes.dex */
    public static class C0492a extends ViewGroup.MarginLayoutParams {

        /* renamed from: a */
        public float f2899a;

        /* renamed from: b */
        public int f2900b;

        public C0492a(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            this.f2900b = -1;
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C0363j.LinearLayoutCompat_Layout);
            this.f2899a = obtainStyledAttributes.getFloat(C0363j.LinearLayoutCompat_Layout_android_layout_weight, 0.0f);
            this.f2900b = obtainStyledAttributes.getInt(C0363j.LinearLayoutCompat_Layout_android_layout_gravity, -1);
            obtainStyledAttributes.recycle();
        }

        public C0492a(int i, int i2) {
            super(i, i2);
            this.f2900b = -1;
            this.f2899a = 0.0f;
        }

        public C0492a(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
            this.f2900b = -1;
        }
    }

    /* renamed from: b */
    public void m8113b(Canvas canvas, int i) {
        this.f2894k.setBounds(i, getPaddingTop() + this.f2898p, this.f2895m + i, (getHeight() - getPaddingBottom()) - this.f2898p);
        this.f2894k.draw(canvas);
    }

    /* renamed from: a */
    public void m8122a(Canvas canvas, int i) {
        this.f2894k.setBounds(getPaddingLeft() + this.f2898p, i, (getWidth() - getPaddingRight()) - this.f2898p, this.f2896n + i);
        this.f2894k.draw(canvas);
    }

    /* renamed from: b */
    public boolean m8117b(int i) {
        if (i == 0) {
            return (this.f2897o & 1) != 0;
        } else if (i == getChildCount()) {
            return (this.f2897o & 4) != 0;
        } else if ((this.f2897o & 2) != 0) {
            for (int i2 = i - 1; i2 >= 0; i2--) {
                if (getChildAt(i2).getVisibility() != 8) {
                    return true;
                }
            }
            return false;
        } else {
            return false;
        }
    }

    /* renamed from: a */
    public View m8126a(int i) {
        return getChildAt(i);
    }

    /* renamed from: a */
    public final void m8125a(int i, int i2) {
        int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(getMeasuredHeight(), 1073741824);
        for (int i3 = 0; i3 < i; i3++) {
            View m8126a = m8126a(i3);
            if (m8126a.getVisibility() != 8) {
                C0492a c0492a = (C0492a) m8126a.getLayoutParams();
                if (((ViewGroup.MarginLayoutParams) c0492a).height == -1) {
                    int i4 = ((ViewGroup.MarginLayoutParams) c0492a).width;
                    ((ViewGroup.MarginLayoutParams) c0492a).width = m8126a.getMeasuredWidth();
                    measureChildWithMargins(m8126a, i2, 0, makeMeasureSpec, 0);
                    ((ViewGroup.MarginLayoutParams) c0492a).width = i4;
                }
            }
        }
    }

    /* renamed from: b */
    public final void m8116b(int i, int i2) {
        int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(getMeasuredWidth(), 1073741824);
        for (int i3 = 0; i3 < i; i3++) {
            View m8126a = m8126a(i3);
            if (m8126a.getVisibility() != 8) {
                C0492a c0492a = (C0492a) m8126a.getLayoutParams();
                if (((ViewGroup.MarginLayoutParams) c0492a).width == -1) {
                    int i4 = ((ViewGroup.MarginLayoutParams) c0492a).height;
                    ((ViewGroup.MarginLayoutParams) c0492a).height = m8126a.getMeasuredHeight();
                    measureChildWithMargins(m8126a, makeMeasureSpec, 0, i2, 0);
                    ((ViewGroup.MarginLayoutParams) c0492a).height = i4;
                }
            }
        }
    }

    /* renamed from: a */
    public void m8118a(View view, int i, int i2, int i3, int i4, int i5) {
        measureChildWithMargins(view, i2, i3, i4, i5);
    }

    /* JADX WARN: Removed duplicated region for block: B:30:0x00a0  */
    /* renamed from: b */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void m8115b(int r18, int r19, int r20, int r21) {
        /*
            r17 = this;
            r6 = r17
            int r7 = r17.getPaddingLeft()
            int r0 = r20 - r18
            int r1 = r17.getPaddingRight()
            int r8 = r0 - r1
            int r0 = r0 - r7
            int r1 = r17.getPaddingRight()
            int r9 = r0 - r1
            int r10 = r17.getVirtualChildCount()
            int r0 = r6.f2888e
            r1 = r0 & 112(0x70, float:1.57E-43)
            r2 = 8388615(0x800007, float:1.1754953E-38)
            r11 = r0 & r2
            r0 = 16
            if (r1 == r0) goto L3b
            r0 = 80
            if (r1 == r0) goto L2f
            int r0 = r17.getPaddingTop()
            goto L47
        L2f:
            int r0 = r17.getPaddingTop()
            int r0 = r0 + r21
            int r0 = r0 - r19
            int r1 = r6.f2889f
            int r0 = r0 - r1
            goto L47
        L3b:
            int r0 = r17.getPaddingTop()
            int r1 = r21 - r19
            int r2 = r6.f2889f
            int r1 = r1 - r2
            int r1 = r1 / 2
            int r0 = r0 + r1
        L47:
            r1 = 0
            r12 = 0
        L49:
            if (r12 >= r10) goto Lc9
            android.view.View r13 = r6.m8126a(r12)
            r14 = 1
            if (r13 != 0) goto L59
            int r1 = r6.m8111c(r12)
            int r0 = r0 + r1
            goto Lc6
        L59:
            int r1 = r13.getVisibility()
            r2 = 8
            if (r1 == r2) goto Lc6
            int r4 = r13.getMeasuredWidth()
            int r15 = r13.getMeasuredHeight()
            android.view.ViewGroup$LayoutParams r1 = r13.getLayoutParams()
            r5 = r1
            a.b.h.k.r0$a r5 = (p000a.p006b.p049h.p063k.LinearLayoutCompat.C0492a) r5
            int r1 = r5.f2900b
            if (r1 >= 0) goto L75
            r1 = r11
        L75:
            int r2 = p000a.p006b.p030g.p045k.ViewCompat.m9422k(r17)
            int r1 = p000a.p006b.p030g.p045k.GravityCompat.m9579a(r1, r2)
            r1 = r1 & 7
            if (r1 == r14) goto L8e
            r2 = 5
            if (r1 == r2) goto L89
            int r1 = r5.leftMargin
            int r1 = r1 + r7
        L87:
            r2 = r1
            goto L9a
        L89:
            int r1 = r8 - r4
            int r2 = r5.rightMargin
            goto L98
        L8e:
            int r1 = r9 - r4
            int r1 = r1 / 2
            int r1 = r1 + r7
            int r2 = r5.leftMargin
            int r1 = r1 + r2
            int r2 = r5.rightMargin
        L98:
            int r1 = r1 - r2
            goto L87
        L9a:
            boolean r1 = r6.m8117b(r12)
            if (r1 == 0) goto La3
            int r1 = r6.f2896n
            int r0 = r0 + r1
        La3:
            int r1 = r5.topMargin
            int r16 = r0 + r1
            int r0 = r6.m8121a(r13)
            int r3 = r16 + r0
            r0 = r17
            r1 = r13
            r14 = r5
            r5 = r15
            r0.m8119a(r1, r2, r3, r4, r5)
            int r0 = r14.bottomMargin
            int r15 = r15 + r0
            int r0 = r6.m8112b(r13)
            int r15 = r15 + r0
            int r16 = r16 + r15
            int r0 = r6.m8120a(r13, r12)
            int r12 = r12 + r0
            r0 = r16
        Lc6:
            r1 = 1
            int r12 = r12 + r1
            goto L49
        Lc9:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: p000a.p006b.p049h.p063k.LinearLayoutCompat.m8115b(int, int, int, int):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:29:0x00a7  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x00b0  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x00e4  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x00f8  */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void m8124a(int r25, int r26, int r27, int r28) {
        /*
            Method dump skipped, instructions count: 321
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: p000a.p006b.p049h.p063k.LinearLayoutCompat.m8124a(int, int, int, int):void");
    }

    /* renamed from: a */
    public final void m8119a(View view, int i, int i2, int i3, int i4) {
        view.layout(i, i2, i3 + i, i4 + i2);
    }
}
