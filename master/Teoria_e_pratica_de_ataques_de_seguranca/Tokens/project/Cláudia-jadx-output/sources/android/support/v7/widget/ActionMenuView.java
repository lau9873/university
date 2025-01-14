package android.support.v7.widget;

import a.b.h.j.j.h;
import a.b.h.j.j.k;
import a.b.h.j.j.p;
import a.b.h.j.j.q;
import a.b.h.k.r0;
import a.b.h.k.t1;
import android.content.Context;
import android.content.res.Configuration;
import android.graphics.drawable.Drawable;
import android.support.v7.view.menu.ActionMenuItemView;
import android.util.AttributeSet;
import android.view.ContextThemeWrapper;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewDebug;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
/* loaded from: classes.dex */
public class ActionMenuView extends r0 implements h.b, q {
    public int A;
    public e B;
    public h q;
    public Context r;
    public int s;
    public boolean t;
    public a.b.h.k.c u;
    public p.a v;
    public h.a w;
    public boolean x;
    public int y;
    public int z;

    /* loaded from: classes.dex */
    public interface a {
        boolean b();

        boolean c();
    }

    /* loaded from: classes.dex */
    public static class b implements p.a {
        @Override // a.b.h.j.j.p.a
        public void a(h hVar, boolean z) {
        }

        @Override // a.b.h.j.j.p.a
        public boolean a(h hVar) {
            return false;
        }
    }

    /* loaded from: classes.dex */
    public static class c extends r0.a {
        @ViewDebug.ExportedProperty

        /* renamed from: c  reason: collision with root package name */
        public boolean f2495c;
        @ViewDebug.ExportedProperty

        /* renamed from: d  reason: collision with root package name */
        public int f2496d;
        @ViewDebug.ExportedProperty

        /* renamed from: e  reason: collision with root package name */
        public int f2497e;
        @ViewDebug.ExportedProperty

        /* renamed from: f  reason: collision with root package name */
        public boolean f2498f;
        @ViewDebug.ExportedProperty

        /* renamed from: g  reason: collision with root package name */
        public boolean f2499g;

        /* renamed from: h  reason: collision with root package name */
        public boolean f2500h;

        public c(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }

        public c(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
        }

        public c(c cVar) {
            super(cVar);
            this.f2495c = cVar.f2495c;
        }

        public c(int i2, int i3) {
            super(i2, i3);
            this.f2495c = false;
        }
    }

    /* loaded from: classes.dex */
    public interface e {
        boolean onMenuItemClick(MenuItem menuItem);
    }

    public ActionMenuView(Context context) {
        this(context, null);
    }

    public static int b(View view, int i2, int i3, int i4, int i5) {
        c cVar = (c) view.getLayoutParams();
        int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(View.MeasureSpec.getSize(i4) - i5, View.MeasureSpec.getMode(i4));
        ActionMenuItemView actionMenuItemView = view instanceof ActionMenuItemView ? (ActionMenuItemView) view : null;
        boolean z = true;
        boolean z2 = actionMenuItemView != null && actionMenuItemView.e();
        int i6 = 2;
        if (i3 <= 0 || (z2 && i3 < 2)) {
            i6 = 0;
        } else {
            view.measure(View.MeasureSpec.makeMeasureSpec(i3 * i2, Integer.MIN_VALUE), makeMeasureSpec);
            int measuredWidth = view.getMeasuredWidth();
            int i7 = measuredWidth / i2;
            if (measuredWidth % i2 != 0) {
                i7++;
            }
            if (!z2 || i7 >= 2) {
                i6 = i7;
            }
        }
        cVar.f2498f = (cVar.f2495c || !z2) ? false : false;
        cVar.f2496d = i6;
        view.measure(View.MeasureSpec.makeMeasureSpec(i2 * i6, 1073741824), makeMeasureSpec);
        return i6;
    }

    @Override // a.b.h.j.j.h.b
    public boolean a(k kVar) {
        return this.q.a(kVar, 0);
    }

    @Override // a.b.h.k.r0, android.view.ViewGroup
    public boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams != null && (layoutParams instanceof c);
    }

    public void d() {
        a.b.h.k.c cVar = this.u;
        if (cVar != null) {
            cVar.e();
        }
    }

    @Override // android.view.View
    public boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        return false;
    }

    /* JADX WARN: Type inference failed for: r13v12 */
    /* JADX WARN: Type inference failed for: r13v13, types: [boolean, int] */
    /* JADX WARN: Type inference failed for: r13v16 */
    public final void e(int i2, int i3) {
        int i4;
        int i5;
        boolean z;
        int i6;
        int i7;
        int i8;
        int i9;
        ?? r13;
        int mode = View.MeasureSpec.getMode(i3);
        int size = View.MeasureSpec.getSize(i2);
        int size2 = View.MeasureSpec.getSize(i3);
        int paddingLeft = getPaddingLeft() + getPaddingRight();
        int paddingTop = getPaddingTop() + getPaddingBottom();
        int childMeasureSpec = ViewGroup.getChildMeasureSpec(i3, paddingTop, -2);
        int i10 = size - paddingLeft;
        int i11 = this.z;
        int i12 = i10 / i11;
        int i13 = i10 % i11;
        if (i12 == 0) {
            setMeasuredDimension(i10, 0);
            return;
        }
        int i14 = i11 + (i13 / i12);
        int childCount = getChildCount();
        int i15 = i12;
        int i16 = 0;
        int i17 = 0;
        boolean z2 = false;
        int i18 = 0;
        int i19 = 0;
        int i20 = 0;
        long j = 0;
        while (i16 < childCount) {
            View childAt = getChildAt(i16);
            int i21 = size2;
            if (childAt.getVisibility() != 8) {
                boolean z3 = childAt instanceof ActionMenuItemView;
                int i22 = i18 + 1;
                if (z3) {
                    int i23 = this.A;
                    i9 = i22;
                    r13 = 0;
                    childAt.setPadding(i23, 0, i23, 0);
                } else {
                    i9 = i22;
                    r13 = 0;
                }
                c cVar = (c) childAt.getLayoutParams();
                cVar.f2500h = r13;
                cVar.f2497e = r13;
                cVar.f2496d = r13;
                cVar.f2498f = r13;
                ((ViewGroup.MarginLayoutParams) cVar).leftMargin = r13;
                ((ViewGroup.MarginLayoutParams) cVar).rightMargin = r13;
                cVar.f2499g = z3 && ((ActionMenuItemView) childAt).e();
                int b2 = b(childAt, i14, cVar.f2495c ? 1 : i15, childMeasureSpec, paddingTop);
                int max = Math.max(i19, b2);
                if (cVar.f2498f) {
                    i20++;
                }
                if (cVar.f2495c) {
                    z2 = true;
                }
                i15 -= b2;
                i17 = Math.max(i17, childAt.getMeasuredHeight());
                if (b2 == 1) {
                    j |= 1 << i16;
                    i17 = i17;
                }
                i19 = max;
                i18 = i9;
            }
            i16++;
            size2 = i21;
        }
        int i24 = size2;
        boolean z4 = z2 && i18 == 2;
        boolean z5 = false;
        while (i20 > 0 && i15 > 0) {
            int i25 = Integer.MAX_VALUE;
            int i26 = 0;
            int i27 = 0;
            long j2 = 0;
            while (i26 < childCount) {
                boolean z6 = z5;
                c cVar2 = (c) getChildAt(i26).getLayoutParams();
                int i28 = i17;
                if (cVar2.f2498f) {
                    int i29 = cVar2.f2496d;
                    if (i29 < i25) {
                        i25 = i29;
                        j2 = 1 << i26;
                        i27 = 1;
                    } else if (i29 == i25) {
                        j2 |= 1 << i26;
                        i27++;
                    }
                }
                i26++;
                i17 = i28;
                z5 = z6;
            }
            z = z5;
            i6 = i17;
            j |= j2;
            if (i27 > i15) {
                i4 = mode;
                i5 = i10;
                break;
            }
            int i30 = i25 + 1;
            int i31 = 0;
            while (i31 < childCount) {
                View childAt2 = getChildAt(i31);
                c cVar3 = (c) childAt2.getLayoutParams();
                int i32 = i10;
                int i33 = mode;
                long j3 = 1 << i31;
                if ((j2 & j3) == 0) {
                    if (cVar3.f2496d == i30) {
                        j |= j3;
                    }
                    i8 = i30;
                } else {
                    if (z4 && cVar3.f2499g && i15 == 1) {
                        int i34 = this.A;
                        i8 = i30;
                        childAt2.setPadding(i34 + i14, 0, i34, 0);
                    } else {
                        i8 = i30;
                    }
                    cVar3.f2496d++;
                    cVar3.f2500h = true;
                    i15--;
                }
                i31++;
                mode = i33;
                i30 = i8;
                i10 = i32;
            }
            i17 = i6;
            z5 = true;
        }
        i4 = mode;
        i5 = i10;
        z = z5;
        i6 = i17;
        boolean z7 = !z2 && i18 == 1;
        if (i15 <= 0 || j == 0 || (i15 >= i18 - 1 && !z7 && i19 <= 1)) {
            i7 = 0;
        } else {
            float bitCount = Long.bitCount(j);
            if (z7) {
                i7 = 0;
            } else {
                i7 = 0;
                if ((j & 1) != 0 && !((c) getChildAt(0).getLayoutParams()).f2499g) {
                    bitCount -= 0.5f;
                }
                int i35 = childCount - 1;
                if ((j & (1 << i35)) != 0 && !((c) getChildAt(i35).getLayoutParams()).f2499g) {
                    bitCount -= 0.5f;
                }
            }
            int i36 = bitCount > 0.0f ? (int) ((i15 * i14) / bitCount) : 0;
            for (int i37 = 0; i37 < childCount; i37++) {
                if ((j & (1 << i37)) != 0) {
                    View childAt3 = getChildAt(i37);
                    c cVar4 = (c) childAt3.getLayoutParams();
                    if (childAt3 instanceof ActionMenuItemView) {
                        cVar4.f2497e = i36;
                        cVar4.f2500h = true;
                        if (i37 == 0 && !cVar4.f2499g) {
                            ((ViewGroup.MarginLayoutParams) cVar4).leftMargin = (-i36) / 2;
                        }
                    } else if (cVar4.f2495c) {
                        cVar4.f2497e = i36;
                        cVar4.f2500h = true;
                        ((ViewGroup.MarginLayoutParams) cVar4).rightMargin = (-i36) / 2;
                    } else {
                        if (i37 != 0) {
                            ((ViewGroup.MarginLayoutParams) cVar4).leftMargin = i36 / 2;
                        }
                        if (i37 != childCount - 1) {
                            ((ViewGroup.MarginLayoutParams) cVar4).rightMargin = i36 / 2;
                        }
                    }
                    z = true;
                }
            }
        }
        if (z) {
            while (i7 < childCount) {
                View childAt4 = getChildAt(i7);
                c cVar5 = (c) childAt4.getLayoutParams();
                if (cVar5.f2500h) {
                    childAt4.measure(View.MeasureSpec.makeMeasureSpec((cVar5.f2496d * i14) + cVar5.f2497e, 1073741824), childMeasureSpec);
                }
                i7++;
            }
        }
        setMeasuredDimension(i5, i4 != 1073741824 ? i6 : i24);
    }

    public boolean f() {
        a.b.h.k.c cVar = this.u;
        return cVar != null && cVar.g();
    }

    public boolean g() {
        a.b.h.k.c cVar = this.u;
        return cVar != null && cVar.i();
    }

    public Menu getMenu() {
        if (this.q == null) {
            Context context = getContext();
            this.q = new h(context);
            this.q.a(new d());
            this.u = new a.b.h.k.c(context);
            this.u.c(true);
            a.b.h.k.c cVar = this.u;
            p.a aVar = this.v;
            if (aVar == null) {
                aVar = new b();
            }
            cVar.a(aVar);
            this.q.a(this.u, this.r);
            this.u.a(this);
        }
        return this.q;
    }

    public Drawable getOverflowIcon() {
        getMenu();
        return this.u.f();
    }

    public int getPopupTheme() {
        return this.s;
    }

    public int getWindowAnimations() {
        return 0;
    }

    public boolean h() {
        a.b.h.k.c cVar = this.u;
        return cVar != null && cVar.j();
    }

    public boolean i() {
        return this.t;
    }

    public h j() {
        return this.q;
    }

    public boolean k() {
        a.b.h.k.c cVar = this.u;
        return cVar != null && cVar.k();
    }

    @Override // android.view.View
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        a.b.h.k.c cVar = this.u;
        if (cVar != null) {
            cVar.a(false);
            if (this.u.j()) {
                this.u.g();
                this.u.k();
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        d();
    }

    @Override // a.b.h.k.r0, android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        int i6;
        int i7;
        int width;
        int i8;
        if (!this.x) {
            super.onLayout(z, i2, i3, i4, i5);
            return;
        }
        int childCount = getChildCount();
        int i9 = (i5 - i3) / 2;
        int dividerWidth = getDividerWidth();
        int i10 = i4 - i2;
        int paddingRight = (i10 - getPaddingRight()) - getPaddingLeft();
        boolean a2 = t1.a(this);
        int i11 = paddingRight;
        int i12 = 0;
        int i13 = 0;
        for (int i14 = 0; i14 < childCount; i14++) {
            View childAt = getChildAt(i14);
            if (childAt.getVisibility() != 8) {
                c cVar = (c) childAt.getLayoutParams();
                if (cVar.f2495c) {
                    int measuredWidth = childAt.getMeasuredWidth();
                    if (d(i14)) {
                        measuredWidth += dividerWidth;
                    }
                    int measuredHeight = childAt.getMeasuredHeight();
                    if (a2) {
                        i8 = getPaddingLeft() + ((ViewGroup.MarginLayoutParams) cVar).leftMargin;
                        width = i8 + measuredWidth;
                    } else {
                        width = (getWidth() - getPaddingRight()) - ((ViewGroup.MarginLayoutParams) cVar).rightMargin;
                        i8 = width - measuredWidth;
                    }
                    int i15 = i9 - (measuredHeight / 2);
                    childAt.layout(i8, i15, width, measuredHeight + i15);
                    i11 -= measuredWidth;
                    i12 = 1;
                } else {
                    i11 -= (childAt.getMeasuredWidth() + ((ViewGroup.MarginLayoutParams) cVar).leftMargin) + ((ViewGroup.MarginLayoutParams) cVar).rightMargin;
                    d(i14);
                    i13++;
                }
            }
        }
        if (childCount == 1 && i12 == 0) {
            View childAt2 = getChildAt(0);
            int measuredWidth2 = childAt2.getMeasuredWidth();
            int measuredHeight2 = childAt2.getMeasuredHeight();
            int i16 = (i10 / 2) - (measuredWidth2 / 2);
            int i17 = i9 - (measuredHeight2 / 2);
            childAt2.layout(i16, i17, measuredWidth2 + i16, measuredHeight2 + i17);
            return;
        }
        int i18 = i13 - (i12 ^ 1);
        if (i18 > 0) {
            i7 = i11 / i18;
            i6 = 0;
        } else {
            i6 = 0;
            i7 = 0;
        }
        int max = Math.max(i6, i7);
        if (a2) {
            int width2 = getWidth() - getPaddingRight();
            while (i6 < childCount) {
                View childAt3 = getChildAt(i6);
                c cVar2 = (c) childAt3.getLayoutParams();
                if (childAt3.getVisibility() != 8 && !cVar2.f2495c) {
                    int i19 = width2 - ((ViewGroup.MarginLayoutParams) cVar2).rightMargin;
                    int measuredWidth3 = childAt3.getMeasuredWidth();
                    int measuredHeight3 = childAt3.getMeasuredHeight();
                    int i20 = i9 - (measuredHeight3 / 2);
                    childAt3.layout(i19 - measuredWidth3, i20, i19, measuredHeight3 + i20);
                    width2 = i19 - ((measuredWidth3 + ((ViewGroup.MarginLayoutParams) cVar2).leftMargin) + max);
                }
                i6++;
            }
            return;
        }
        int paddingLeft = getPaddingLeft();
        while (i6 < childCount) {
            View childAt4 = getChildAt(i6);
            c cVar3 = (c) childAt4.getLayoutParams();
            if (childAt4.getVisibility() != 8 && !cVar3.f2495c) {
                int i21 = paddingLeft + ((ViewGroup.MarginLayoutParams) cVar3).leftMargin;
                int measuredWidth4 = childAt4.getMeasuredWidth();
                int measuredHeight4 = childAt4.getMeasuredHeight();
                int i22 = i9 - (measuredHeight4 / 2);
                childAt4.layout(i21, i22, i21 + measuredWidth4, measuredHeight4 + i22);
                paddingLeft = i21 + measuredWidth4 + ((ViewGroup.MarginLayoutParams) cVar3).rightMargin + max;
            }
            i6++;
        }
    }

    @Override // a.b.h.k.r0, android.view.View
    public void onMeasure(int i2, int i3) {
        h hVar;
        boolean z = this.x;
        this.x = View.MeasureSpec.getMode(i2) == 1073741824;
        if (z != this.x) {
            this.y = 0;
        }
        int size = View.MeasureSpec.getSize(i2);
        if (this.x && (hVar = this.q) != null && size != this.y) {
            this.y = size;
            hVar.c(true);
        }
        int childCount = getChildCount();
        if (this.x && childCount > 0) {
            e(i2, i3);
            return;
        }
        for (int i4 = 0; i4 < childCount; i4++) {
            c cVar = (c) getChildAt(i4).getLayoutParams();
            ((ViewGroup.MarginLayoutParams) cVar).rightMargin = 0;
            ((ViewGroup.MarginLayoutParams) cVar).leftMargin = 0;
        }
        super.onMeasure(i2, i3);
    }

    public void setExpandedActionViewsExclusive(boolean z) {
        this.u.b(z);
    }

    public void setOnMenuItemClickListener(e eVar) {
        this.B = eVar;
    }

    public void setOverflowIcon(Drawable drawable) {
        getMenu();
        this.u.a(drawable);
    }

    public void setOverflowReserved(boolean z) {
        this.t = z;
    }

    public void setPopupTheme(int i2) {
        if (this.s != i2) {
            this.s = i2;
            if (i2 == 0) {
                this.r = getContext();
            } else {
                this.r = new ContextThemeWrapper(getContext(), i2);
            }
        }
    }

    public void setPresenter(a.b.h.k.c cVar) {
        this.u = cVar;
        this.u.a(this);
    }

    /* loaded from: classes.dex */
    public class d implements h.a {
        public d() {
        }

        @Override // a.b.h.j.j.h.a
        public boolean a(h hVar, MenuItem menuItem) {
            e eVar = ActionMenuView.this.B;
            return eVar != null && eVar.onMenuItemClick(menuItem);
        }

        @Override // a.b.h.j.j.h.a
        public void a(h hVar) {
            h.a aVar = ActionMenuView.this.w;
            if (aVar != null) {
                aVar.a(hVar);
            }
        }
    }

    public ActionMenuView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        setBaselineAligned(false);
        float f2 = context.getResources().getDisplayMetrics().density;
        this.z = (int) (56.0f * f2);
        this.A = (int) (f2 * 4.0f);
        this.r = context;
        this.s = 0;
    }

    @Override // a.b.h.j.j.q
    public void a(h hVar) {
        this.q = hVar;
    }

    public void a(p.a aVar, h.a aVar2) {
        this.v = aVar;
        this.w = aVar2;
    }

    public boolean d(int i2) {
        boolean z = false;
        if (i2 == 0) {
            return false;
        }
        View childAt = getChildAt(i2 - 1);
        View childAt2 = getChildAt(i2);
        if (i2 < getChildCount() && (childAt instanceof a)) {
            z = false | ((a) childAt).b();
        }
        return (i2 <= 0 || !(childAt2 instanceof a)) ? z : z | ((a) childAt2).c();
    }

    @Override // a.b.h.k.r0, android.view.ViewGroup
    public c generateDefaultLayoutParams() {
        c cVar = new c(-2, -2);
        cVar.f1930b = 16;
        return cVar;
    }

    @Override // a.b.h.k.r0, android.view.ViewGroup
    public c generateLayoutParams(AttributeSet attributeSet) {
        return new c(getContext(), attributeSet);
    }

    @Override // a.b.h.k.r0, android.view.ViewGroup
    public c generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        if (layoutParams != null) {
            c cVar = layoutParams instanceof c ? new c((c) layoutParams) : new c(layoutParams);
            if (cVar.f1930b <= 0) {
                cVar.f1930b = 16;
            }
            return cVar;
        }
        return generateDefaultLayoutParams();
    }

    public c e() {
        c generateDefaultLayoutParams = generateDefaultLayoutParams();
        generateDefaultLayoutParams.f2495c = true;
        return generateDefaultLayoutParams;
    }
}
