package android.support.p067v7.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import p000a.p006b.p030g.p045k.ViewCompat;
import p000a.p006b.p049h.p051b.C0359f;
import p000a.p006b.p049h.p063k.LinearLayoutCompat;

/* renamed from: android.support.v7.widget.AlertDialogLayout */
/* loaded from: classes.dex */
public class AlertDialogLayout extends LinearLayoutCompat {
    public AlertDialogLayout(Context context) {
        super(context);
    }

    /* renamed from: a */
    private void m7076a(View view, int i, int i2, int i3, int i4) {
        view.layout(i, i2, i3 + i, i4 + i2);
    }

    /* renamed from: b */
    private void m7075b(int i, int i2) {
        int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(getMeasuredWidth(), 1073741824);
        for (int i3 = 0; i3 < i; i3++) {
            View childAt = getChildAt(i3);
            if (childAt.getVisibility() != 8) {
                LinearLayoutCompat.C0492a c0492a = (LinearLayoutCompat.C0492a) childAt.getLayoutParams();
                if (((ViewGroup.MarginLayoutParams) c0492a).width == -1) {
                    int i4 = ((ViewGroup.MarginLayoutParams) c0492a).height;
                    ((ViewGroup.MarginLayoutParams) c0492a).height = childAt.getMeasuredHeight();
                    measureChildWithMargins(childAt, makeMeasureSpec, 0, i2, 0);
                    ((ViewGroup.MarginLayoutParams) c0492a).height = i4;
                }
            }
        }
    }

    /* renamed from: c */
    public static int m7074c(View view) {
        int m9421l = ViewCompat.m9421l(view);
        if (m9421l > 0) {
            return m9421l;
        }
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            if (viewGroup.getChildCount() == 1) {
                return m7074c(viewGroup.getChildAt(0));
            }
        }
        return 0;
    }

    /* renamed from: e */
    public final boolean m7073e(int i, int i2) {
        int i3;
        int i4;
        int i5;
        int i6;
        int childCount = getChildCount();
        View view = null;
        View view2 = null;
        View view3 = null;
        for (int i7 = 0; i7 < childCount; i7++) {
            View childAt = getChildAt(i7);
            if (childAt.getVisibility() != 8) {
                int id = childAt.getId();
                if (id == C0359f.topPanel) {
                    view = childAt;
                } else if (id == C0359f.buttonPanel) {
                    view2 = childAt;
                } else if ((id != C0359f.contentPanel && id != C0359f.customPanel) || view3 != null) {
                    return false;
                } else {
                    view3 = childAt;
                }
            }
        }
        int mode = View.MeasureSpec.getMode(i2);
        int size = View.MeasureSpec.getSize(i2);
        int mode2 = View.MeasureSpec.getMode(i);
        int paddingTop = getPaddingTop() + getPaddingBottom();
        if (view != null) {
            view.measure(i, 0);
            paddingTop += view.getMeasuredHeight();
            i3 = View.combineMeasuredStates(0, view.getMeasuredState());
        } else {
            i3 = 0;
        }
        if (view2 != null) {
            view2.measure(i, 0);
            i4 = m7074c(view2);
            i5 = view2.getMeasuredHeight() - i4;
            paddingTop += i4;
            i3 = View.combineMeasuredStates(i3, view2.getMeasuredState());
        } else {
            i4 = 0;
            i5 = 0;
        }
        if (view3 != null) {
            view3.measure(i, mode == 0 ? 0 : View.MeasureSpec.makeMeasureSpec(Math.max(0, size - paddingTop), mode));
            i6 = view3.getMeasuredHeight();
            paddingTop += i6;
            i3 = View.combineMeasuredStates(i3, view3.getMeasuredState());
        } else {
            i6 = 0;
        }
        int i8 = size - paddingTop;
        if (view2 != null) {
            int i9 = paddingTop - i4;
            int min = Math.min(i8, i5);
            if (min > 0) {
                i8 -= min;
                i4 += min;
            }
            view2.measure(i, View.MeasureSpec.makeMeasureSpec(i4, 1073741824));
            paddingTop = i9 + view2.getMeasuredHeight();
            i3 = View.combineMeasuredStates(i3, view2.getMeasuredState());
        }
        if (view3 != null && i8 > 0) {
            view3.measure(i, View.MeasureSpec.makeMeasureSpec(i6 + i8, mode));
            paddingTop = (paddingTop - i6) + view3.getMeasuredHeight();
            i3 = View.combineMeasuredStates(i3, view3.getMeasuredState());
        }
        int i10 = 0;
        for (int i11 = 0; i11 < childCount; i11++) {
            View childAt2 = getChildAt(i11);
            if (childAt2.getVisibility() != 8) {
                i10 = Math.max(i10, childAt2.getMeasuredWidth());
            }
        }
        setMeasuredDimension(View.resolveSizeAndState(i10 + getPaddingLeft() + getPaddingRight(), i, i3), View.resolveSizeAndState(paddingTop, i2, 0));
        if (mode2 != 1073741824) {
            m7075b(childCount, i2);
            return true;
        }
        return true;
    }

    /* JADX WARN: Removed duplicated region for block: B:32:0x00a8  */
    @Override // p000a.p006b.p049h.p063k.LinearLayoutCompat, android.view.ViewGroup, android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void onLayout(boolean r18, int r19, int r20, int r21, int r22) {
        /*
            r17 = this;
            r6 = r17
            int r7 = r17.getPaddingLeft()
            int r0 = r21 - r19
            int r1 = r17.getPaddingRight()
            int r8 = r0 - r1
            int r0 = r0 - r7
            int r1 = r17.getPaddingRight()
            int r9 = r0 - r1
            int r0 = r17.getMeasuredHeight()
            int r10 = r17.getChildCount()
            int r1 = r17.getGravity()
            r2 = r1 & 112(0x70, float:1.57E-43)
            r3 = 8388615(0x800007, float:1.1754953E-38)
            r11 = r1 & r3
            r1 = 16
            if (r2 == r1) goto L40
            r1 = 80
            if (r2 == r1) goto L35
            int r0 = r17.getPaddingTop()
            goto L4b
        L35:
            int r1 = r17.getPaddingTop()
            int r1 = r1 + r22
            int r1 = r1 - r20
            int r0 = r1 - r0
            goto L4b
        L40:
            int r1 = r17.getPaddingTop()
            int r2 = r22 - r20
            int r2 = r2 - r0
            int r2 = r2 / 2
            int r0 = r1 + r2
        L4b:
            android.graphics.drawable.Drawable r1 = r17.getDividerDrawable()
            r2 = 0
            if (r1 != 0) goto L54
            r12 = 0
            goto L59
        L54:
            int r1 = r1.getIntrinsicHeight()
            r12 = r1
        L59:
            r13 = 0
        L5a:
            if (r13 >= r10) goto Lbf
            android.view.View r1 = r6.getChildAt(r13)
            if (r1 == 0) goto Lbc
            int r2 = r1.getVisibility()
            r3 = 8
            if (r2 == r3) goto Lbc
            int r4 = r1.getMeasuredWidth()
            int r14 = r1.getMeasuredHeight()
            android.view.ViewGroup$LayoutParams r2 = r1.getLayoutParams()
            r15 = r2
            a.b.h.k.r0$a r15 = (p000a.p006b.p049h.p063k.LinearLayoutCompat.C0492a) r15
            int r2 = r15.f2900b
            if (r2 >= 0) goto L7e
            r2 = r11
        L7e:
            int r3 = p000a.p006b.p030g.p045k.ViewCompat.m9422k(r17)
            int r2 = p000a.p006b.p030g.p045k.GravityCompat.m9579a(r2, r3)
            r2 = r2 & 7
            r3 = 1
            if (r2 == r3) goto L97
            r3 = 5
            if (r2 == r3) goto L92
            int r2 = r15.leftMargin
            int r2 = r2 + r7
            goto La2
        L92:
            int r2 = r8 - r4
            int r3 = r15.rightMargin
            goto La1
        L97:
            int r2 = r9 - r4
            int r2 = r2 / 2
            int r2 = r2 + r7
            int r3 = r15.leftMargin
            int r2 = r2 + r3
            int r3 = r15.rightMargin
        La1:
            int r2 = r2 - r3
        La2:
            boolean r3 = r6.m8117b(r13)
            if (r3 == 0) goto La9
            int r0 = r0 + r12
        La9:
            int r3 = r15.topMargin
            int r16 = r0 + r3
            r0 = r17
            r3 = r16
            r5 = r14
            r0.m7076a(r1, r2, r3, r4, r5)
            int r0 = r15.bottomMargin
            int r14 = r14 + r0
            int r16 = r16 + r14
            r0 = r16
        Lbc:
            int r13 = r13 + 1
            goto L5a
        Lbf:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.p067v7.widget.AlertDialogLayout.onLayout(boolean, int, int, int, int):void");
    }

    @Override // p000a.p006b.p049h.p063k.LinearLayoutCompat, android.view.View
    public void onMeasure(int i, int i2) {
        if (m7073e(i, i2)) {
            return;
        }
        super.onMeasure(i, i2);
    }

    public AlertDialogLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }
}
