package android.support.p067v7.widget;

import android.content.Context;
import android.content.res.Configuration;
import android.graphics.drawable.Drawable;
import android.support.p067v7.view.menu.ActionMenuItemView;
import android.util.AttributeSet;
import android.view.ContextThemeWrapper;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewDebug;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import p000a.p006b.p049h.p061j.p062j.MenuBuilder;
import p000a.p006b.p049h.p061j.p062j.MenuItemImpl;
import p000a.p006b.p049h.p061j.p062j.MenuPresenter;
import p000a.p006b.p049h.p061j.p062j.MenuView;
import p000a.p006b.p049h.p063k.ActionMenuPresenter;
import p000a.p006b.p049h.p063k.C0504t1;
import p000a.p006b.p049h.p063k.LinearLayoutCompat;

/* renamed from: android.support.v7.widget.ActionMenuView */
/* loaded from: classes.dex */
public class ActionMenuView extends LinearLayoutCompat implements MenuBuilder.InterfaceC0426b, MenuView {

    /* renamed from: A */
    public int f4006A;

    /* renamed from: B */
    public InterfaceC0690e f4007B;

    /* renamed from: q */
    public MenuBuilder f4008q;

    /* renamed from: r */
    public Context f4009r;

    /* renamed from: s */
    public int f4010s;

    /* renamed from: t */
    public boolean f4011t;

    /* renamed from: u */
    public ActionMenuPresenter f4012u;

    /* renamed from: v */
    public MenuPresenter.InterfaceC0434a f4013v;

    /* renamed from: w */
    public MenuBuilder.InterfaceC0425a f4014w;

    /* renamed from: x */
    public boolean f4015x;

    /* renamed from: y */
    public int f4016y;

    /* renamed from: z */
    public int f4017z;

    /* renamed from: android.support.v7.widget.ActionMenuView$a */
    /* loaded from: classes.dex */
    public interface InterfaceC0686a {
        /* renamed from: b */
        boolean mo7082b();

        /* renamed from: c */
        boolean mo7081c();
    }

    /* renamed from: android.support.v7.widget.ActionMenuView$b */
    /* loaded from: classes.dex */
    public static class C0687b implements MenuPresenter.InterfaceC0434a {
        @Override // p000a.p006b.p049h.p061j.p062j.MenuPresenter.InterfaceC0434a
        /* renamed from: a */
        public void mo7079a(MenuBuilder menuBuilder, boolean z) {
        }

        @Override // p000a.p006b.p049h.p061j.p062j.MenuPresenter.InterfaceC0434a
        /* renamed from: a */
        public boolean mo7080a(MenuBuilder menuBuilder) {
            return false;
        }
    }

    /* renamed from: android.support.v7.widget.ActionMenuView$c */
    /* loaded from: classes.dex */
    public static class C0688c extends LinearLayoutCompat.C0492a {
        @ViewDebug.ExportedProperty

        /* renamed from: c */
        public boolean f4018c;
        @ViewDebug.ExportedProperty

        /* renamed from: d */
        public int f4019d;
        @ViewDebug.ExportedProperty

        /* renamed from: e */
        public int f4020e;
        @ViewDebug.ExportedProperty

        /* renamed from: f */
        public boolean f4021f;
        @ViewDebug.ExportedProperty

        /* renamed from: g */
        public boolean f4022g;

        /* renamed from: h */
        public boolean f4023h;

        public C0688c(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }

        public C0688c(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
        }

        public C0688c(C0688c c0688c) {
            super(c0688c);
            this.f4018c = c0688c.f4018c;
        }

        public C0688c(int i, int i2) {
            super(i, i2);
            this.f4018c = false;
        }
    }

    /* renamed from: android.support.v7.widget.ActionMenuView$e */
    /* loaded from: classes.dex */
    public interface InterfaceC0690e {
        boolean onMenuItemClick(MenuItem menuItem);
    }

    public ActionMenuView(Context context) {
        this(context, null);
    }

    /* renamed from: b */
    public static int m7093b(View view, int i, int i2, int i3, int i4) {
        C0688c c0688c = (C0688c) view.getLayoutParams();
        int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(View.MeasureSpec.getSize(i3) - i4, View.MeasureSpec.getMode(i3));
        ActionMenuItemView actionMenuItemView = view instanceof ActionMenuItemView ? (ActionMenuItemView) view : null;
        boolean z = true;
        boolean z2 = actionMenuItemView != null && actionMenuItemView.m7144e();
        int i5 = 2;
        if (i2 <= 0 || (z2 && i2 < 2)) {
            i5 = 0;
        } else {
            view.measure(View.MeasureSpec.makeMeasureSpec(i2 * i, Integer.MIN_VALUE), makeMeasureSpec);
            int measuredWidth = view.getMeasuredWidth();
            int i6 = measuredWidth / i;
            if (measuredWidth % i != 0) {
                i6++;
            }
            if (!z2 || i6 >= 2) {
                i5 = i6;
            }
        }
        c0688c.f4021f = (c0688c.f4018c || !z2) ? false : false;
        c0688c.f4019d = i5;
        view.measure(View.MeasureSpec.makeMeasureSpec(i * i5, 1073741824), makeMeasureSpec);
        return i5;
    }

    @Override // p000a.p006b.p049h.p061j.p062j.MenuBuilder.InterfaceC0426b
    /* renamed from: a */
    public boolean mo7095a(MenuItemImpl menuItemImpl) {
        return this.f4008q.m8686a(menuItemImpl, 0);
    }

    @Override // p000a.p006b.p049h.p063k.LinearLayoutCompat, android.view.ViewGroup
    public boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams != null && (layoutParams instanceof C0688c);
    }

    /* renamed from: d */
    public void m7092d() {
        ActionMenuPresenter actionMenuPresenter = this.f4012u;
        if (actionMenuPresenter != null) {
            actionMenuPresenter.m8493e();
        }
    }

    @Override // android.view.View
    public boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        return false;
    }

    /* JADX WARN: Type inference failed for: r13v12 */
    /* JADX WARN: Type inference failed for: r13v13, types: [boolean, int] */
    /* JADX WARN: Type inference failed for: r13v16 */
    /* renamed from: e */
    public final void m7089e(int i, int i2) {
        int i3;
        int i4;
        boolean z;
        int i5;
        int i6;
        int i7;
        int i8;
        ?? r13;
        int mode = View.MeasureSpec.getMode(i2);
        int size = View.MeasureSpec.getSize(i);
        int size2 = View.MeasureSpec.getSize(i2);
        int paddingLeft = getPaddingLeft() + getPaddingRight();
        int paddingTop = getPaddingTop() + getPaddingBottom();
        int childMeasureSpec = ViewGroup.getChildMeasureSpec(i2, paddingTop, -2);
        int i9 = size - paddingLeft;
        int i10 = this.f4017z;
        int i11 = i9 / i10;
        int i12 = i9 % i10;
        if (i11 == 0) {
            setMeasuredDimension(i9, 0);
            return;
        }
        int i13 = i10 + (i12 / i11);
        int childCount = getChildCount();
        int i14 = i11;
        int i15 = 0;
        int i16 = 0;
        boolean z2 = false;
        int i17 = 0;
        int i18 = 0;
        int i19 = 0;
        long j = 0;
        while (i15 < childCount) {
            View childAt = getChildAt(i15);
            int i20 = size2;
            if (childAt.getVisibility() != 8) {
                boolean z3 = childAt instanceof ActionMenuItemView;
                int i21 = i17 + 1;
                if (z3) {
                    int i22 = this.f4006A;
                    i8 = i21;
                    r13 = 0;
                    childAt.setPadding(i22, 0, i22, 0);
                } else {
                    i8 = i21;
                    r13 = 0;
                }
                C0688c c0688c = (C0688c) childAt.getLayoutParams();
                c0688c.f4023h = r13;
                c0688c.f4020e = r13;
                c0688c.f4019d = r13;
                c0688c.f4021f = r13;
                ((ViewGroup.MarginLayoutParams) c0688c).leftMargin = r13;
                ((ViewGroup.MarginLayoutParams) c0688c).rightMargin = r13;
                c0688c.f4022g = z3 && ((ActionMenuItemView) childAt).m7144e();
                int m7093b = m7093b(childAt, i13, c0688c.f4018c ? 1 : i14, childMeasureSpec, paddingTop);
                int max = Math.max(i18, m7093b);
                if (c0688c.f4021f) {
                    i19++;
                }
                if (c0688c.f4018c) {
                    z2 = true;
                }
                i14 -= m7093b;
                i16 = Math.max(i16, childAt.getMeasuredHeight());
                if (m7093b == 1) {
                    j |= 1 << i15;
                    i16 = i16;
                }
                i18 = max;
                i17 = i8;
            }
            i15++;
            size2 = i20;
        }
        int i23 = size2;
        boolean z4 = z2 && i17 == 2;
        boolean z5 = false;
        while (i19 > 0 && i14 > 0) {
            int i24 = Integer.MAX_VALUE;
            int i25 = 0;
            int i26 = 0;
            long j2 = 0;
            while (i25 < childCount) {
                boolean z6 = z5;
                C0688c c0688c2 = (C0688c) getChildAt(i25).getLayoutParams();
                int i27 = i16;
                if (c0688c2.f4021f) {
                    int i28 = c0688c2.f4019d;
                    if (i28 < i24) {
                        i24 = i28;
                        j2 = 1 << i25;
                        i26 = 1;
                    } else if (i28 == i24) {
                        j2 |= 1 << i25;
                        i26++;
                    }
                }
                i25++;
                i16 = i27;
                z5 = z6;
            }
            z = z5;
            i5 = i16;
            j |= j2;
            if (i26 > i14) {
                i3 = mode;
                i4 = i9;
                break;
            }
            int i29 = i24 + 1;
            int i30 = 0;
            while (i30 < childCount) {
                View childAt2 = getChildAt(i30);
                C0688c c0688c3 = (C0688c) childAt2.getLayoutParams();
                int i31 = i9;
                int i32 = mode;
                long j3 = 1 << i30;
                if ((j2 & j3) == 0) {
                    if (c0688c3.f4019d == i29) {
                        j |= j3;
                    }
                    i7 = i29;
                } else {
                    if (z4 && c0688c3.f4022g && i14 == 1) {
                        int i33 = this.f4006A;
                        i7 = i29;
                        childAt2.setPadding(i33 + i13, 0, i33, 0);
                    } else {
                        i7 = i29;
                    }
                    c0688c3.f4019d++;
                    c0688c3.f4023h = true;
                    i14--;
                }
                i30++;
                mode = i32;
                i29 = i7;
                i9 = i31;
            }
            i16 = i5;
            z5 = true;
        }
        i3 = mode;
        i4 = i9;
        z = z5;
        i5 = i16;
        boolean z7 = !z2 && i17 == 1;
        if (i14 <= 0 || j == 0 || (i14 >= i17 - 1 && !z7 && i18 <= 1)) {
            i6 = 0;
        } else {
            float bitCount = Long.bitCount(j);
            if (z7) {
                i6 = 0;
            } else {
                i6 = 0;
                if ((j & 1) != 0 && !((C0688c) getChildAt(0).getLayoutParams()).f4022g) {
                    bitCount -= 0.5f;
                }
                int i34 = childCount - 1;
                if ((j & (1 << i34)) != 0 && !((C0688c) getChildAt(i34).getLayoutParams()).f4022g) {
                    bitCount -= 0.5f;
                }
            }
            int i35 = bitCount > 0.0f ? (int) ((i14 * i13) / bitCount) : 0;
            for (int i36 = 0; i36 < childCount; i36++) {
                if ((j & (1 << i36)) != 0) {
                    View childAt3 = getChildAt(i36);
                    C0688c c0688c4 = (C0688c) childAt3.getLayoutParams();
                    if (childAt3 instanceof ActionMenuItemView) {
                        c0688c4.f4020e = i35;
                        c0688c4.f4023h = true;
                        if (i36 == 0 && !c0688c4.f4022g) {
                            ((ViewGroup.MarginLayoutParams) c0688c4).leftMargin = (-i35) / 2;
                        }
                    } else if (c0688c4.f4018c) {
                        c0688c4.f4020e = i35;
                        c0688c4.f4023h = true;
                        ((ViewGroup.MarginLayoutParams) c0688c4).rightMargin = (-i35) / 2;
                    } else {
                        if (i36 != 0) {
                            ((ViewGroup.MarginLayoutParams) c0688c4).leftMargin = i35 / 2;
                        }
                        if (i36 != childCount - 1) {
                            ((ViewGroup.MarginLayoutParams) c0688c4).rightMargin = i35 / 2;
                        }
                    }
                    z = true;
                }
            }
        }
        if (z) {
            while (i6 < childCount) {
                View childAt4 = getChildAt(i6);
                C0688c c0688c5 = (C0688c) childAt4.getLayoutParams();
                if (c0688c5.f4023h) {
                    childAt4.measure(View.MeasureSpec.makeMeasureSpec((c0688c5.f4019d * i13) + c0688c5.f4020e, 1073741824), childMeasureSpec);
                }
                i6++;
            }
        }
        setMeasuredDimension(i4, i3 != 1073741824 ? i5 : i23);
    }

    /* renamed from: f */
    public boolean m7088f() {
        ActionMenuPresenter actionMenuPresenter = this.f4012u;
        return actionMenuPresenter != null && actionMenuPresenter.m8489g();
    }

    /* renamed from: g */
    public boolean m7087g() {
        ActionMenuPresenter actionMenuPresenter = this.f4012u;
        return actionMenuPresenter != null && actionMenuPresenter.m8487i();
    }

    public Menu getMenu() {
        if (this.f4008q == null) {
            Context context = getContext();
            this.f4008q = new MenuBuilder(context);
            this.f4008q.mo8579a(new C0689d());
            this.f4012u = new ActionMenuPresenter(context);
            this.f4012u.m8495c(true);
            ActionMenuPresenter actionMenuPresenter = this.f4012u;
            MenuPresenter.InterfaceC0434a interfaceC0434a = this.f4013v;
            if (interfaceC0434a == null) {
                interfaceC0434a = new C0687b();
            }
            actionMenuPresenter.mo8587a(interfaceC0434a);
            this.f4008q.m8691a(this.f4012u, this.f4009r);
            this.f4012u.m8502a(this);
        }
        return this.f4008q;
    }

    public Drawable getOverflowIcon() {
        getMenu();
        return this.f4012u.m8491f();
    }

    public int getPopupTheme() {
        return this.f4010s;
    }

    public int getWindowAnimations() {
        return 0;
    }

    /* renamed from: h */
    public boolean m7086h() {
        ActionMenuPresenter actionMenuPresenter = this.f4012u;
        return actionMenuPresenter != null && actionMenuPresenter.m8486j();
    }

    /* renamed from: i */
    public boolean m7085i() {
        return this.f4011t;
    }

    /* renamed from: j */
    public MenuBuilder m7084j() {
        return this.f4008q;
    }

    /* renamed from: k */
    public boolean m7083k() {
        ActionMenuPresenter actionMenuPresenter = this.f4012u;
        return actionMenuPresenter != null && actionMenuPresenter.m8485k();
    }

    @Override // android.view.View
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        ActionMenuPresenter actionMenuPresenter = this.f4012u;
        if (actionMenuPresenter != null) {
            actionMenuPresenter.mo6278a(false);
            if (this.f4012u.m8486j()) {
                this.f4012u.m8489g();
                this.f4012u.m8485k();
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        m7092d();
    }

    @Override // p000a.p006b.p049h.p063k.LinearLayoutCompat, android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int i5;
        int i6;
        int width;
        int i7;
        if (!this.f4015x) {
            super.onLayout(z, i, i2, i3, i4);
            return;
        }
        int childCount = getChildCount();
        int i8 = (i4 - i2) / 2;
        int dividerWidth = getDividerWidth();
        int i9 = i3 - i;
        int paddingRight = (i9 - getPaddingRight()) - getPaddingLeft();
        boolean m8047a = C0504t1.m8047a(this);
        int i10 = paddingRight;
        int i11 = 0;
        int i12 = 0;
        for (int i13 = 0; i13 < childCount; i13++) {
            View childAt = getChildAt(i13);
            if (childAt.getVisibility() != 8) {
                C0688c c0688c = (C0688c) childAt.getLayoutParams();
                if (c0688c.f4018c) {
                    int measuredWidth = childAt.getMeasuredWidth();
                    if (m7091d(i13)) {
                        measuredWidth += dividerWidth;
                    }
                    int measuredHeight = childAt.getMeasuredHeight();
                    if (m8047a) {
                        i7 = getPaddingLeft() + ((ViewGroup.MarginLayoutParams) c0688c).leftMargin;
                        width = i7 + measuredWidth;
                    } else {
                        width = (getWidth() - getPaddingRight()) - ((ViewGroup.MarginLayoutParams) c0688c).rightMargin;
                        i7 = width - measuredWidth;
                    }
                    int i14 = i8 - (measuredHeight / 2);
                    childAt.layout(i7, i14, width, measuredHeight + i14);
                    i10 -= measuredWidth;
                    i11 = 1;
                } else {
                    i10 -= (childAt.getMeasuredWidth() + ((ViewGroup.MarginLayoutParams) c0688c).leftMargin) + ((ViewGroup.MarginLayoutParams) c0688c).rightMargin;
                    m7091d(i13);
                    i12++;
                }
            }
        }
        if (childCount == 1 && i11 == 0) {
            View childAt2 = getChildAt(0);
            int measuredWidth2 = childAt2.getMeasuredWidth();
            int measuredHeight2 = childAt2.getMeasuredHeight();
            int i15 = (i9 / 2) - (measuredWidth2 / 2);
            int i16 = i8 - (measuredHeight2 / 2);
            childAt2.layout(i15, i16, measuredWidth2 + i15, measuredHeight2 + i16);
            return;
        }
        int i17 = i12 - (i11 ^ 1);
        if (i17 > 0) {
            i6 = i10 / i17;
            i5 = 0;
        } else {
            i5 = 0;
            i6 = 0;
        }
        int max = Math.max(i5, i6);
        if (m8047a) {
            int width2 = getWidth() - getPaddingRight();
            while (i5 < childCount) {
                View childAt3 = getChildAt(i5);
                C0688c c0688c2 = (C0688c) childAt3.getLayoutParams();
                if (childAt3.getVisibility() != 8 && !c0688c2.f4018c) {
                    int i18 = width2 - ((ViewGroup.MarginLayoutParams) c0688c2).rightMargin;
                    int measuredWidth3 = childAt3.getMeasuredWidth();
                    int measuredHeight3 = childAt3.getMeasuredHeight();
                    int i19 = i8 - (measuredHeight3 / 2);
                    childAt3.layout(i18 - measuredWidth3, i19, i18, measuredHeight3 + i19);
                    width2 = i18 - ((measuredWidth3 + ((ViewGroup.MarginLayoutParams) c0688c2).leftMargin) + max);
                }
                i5++;
            }
            return;
        }
        int paddingLeft = getPaddingLeft();
        while (i5 < childCount) {
            View childAt4 = getChildAt(i5);
            C0688c c0688c3 = (C0688c) childAt4.getLayoutParams();
            if (childAt4.getVisibility() != 8 && !c0688c3.f4018c) {
                int i20 = paddingLeft + ((ViewGroup.MarginLayoutParams) c0688c3).leftMargin;
                int measuredWidth4 = childAt4.getMeasuredWidth();
                int measuredHeight4 = childAt4.getMeasuredHeight();
                int i21 = i8 - (measuredHeight4 / 2);
                childAt4.layout(i20, i21, i20 + measuredWidth4, measuredHeight4 + i21);
                paddingLeft = i20 + measuredWidth4 + ((ViewGroup.MarginLayoutParams) c0688c3).rightMargin + max;
            }
            i5++;
        }
    }

    @Override // p000a.p006b.p049h.p063k.LinearLayoutCompat, android.view.View
    public void onMeasure(int i, int i2) {
        MenuBuilder menuBuilder;
        boolean z = this.f4015x;
        this.f4015x = View.MeasureSpec.getMode(i) == 1073741824;
        if (z != this.f4015x) {
            this.f4016y = 0;
        }
        int size = View.MeasureSpec.getSize(i);
        if (this.f4015x && (menuBuilder = this.f4008q) != null && size != this.f4016y) {
            this.f4016y = size;
            menuBuilder.m8670c(true);
        }
        int childCount = getChildCount();
        if (this.f4015x && childCount > 0) {
            m7089e(i, i2);
            return;
        }
        for (int i3 = 0; i3 < childCount; i3++) {
            C0688c c0688c = (C0688c) getChildAt(i3).getLayoutParams();
            ((ViewGroup.MarginLayoutParams) c0688c).rightMargin = 0;
            ((ViewGroup.MarginLayoutParams) c0688c).leftMargin = 0;
        }
        super.onMeasure(i, i2);
    }

    public void setExpandedActionViewsExclusive(boolean z) {
        this.f4012u.m8497b(z);
    }

    public void setOnMenuItemClickListener(InterfaceC0690e interfaceC0690e) {
        this.f4007B = interfaceC0690e;
    }

    public void setOverflowIcon(Drawable drawable) {
        getMenu();
        this.f4012u.m8503a(drawable);
    }

    public void setOverflowReserved(boolean z) {
        this.f4011t = z;
    }

    public void setPopupTheme(int i) {
        if (this.f4010s != i) {
            this.f4010s = i;
            if (i == 0) {
                this.f4009r = getContext();
            } else {
                this.f4009r = new ContextThemeWrapper(getContext(), i);
            }
        }
    }

    public void setPresenter(ActionMenuPresenter actionMenuPresenter) {
        this.f4012u = actionMenuPresenter;
        this.f4012u.m8502a(this);
    }

    /* renamed from: android.support.v7.widget.ActionMenuView$d */
    /* loaded from: classes.dex */
    public class C0689d implements MenuBuilder.InterfaceC0425a {
        public C0689d() {
        }

        @Override // p000a.p006b.p049h.p061j.p062j.MenuBuilder.InterfaceC0425a
        /* renamed from: a */
        public boolean mo7077a(MenuBuilder menuBuilder, MenuItem menuItem) {
            InterfaceC0690e interfaceC0690e = ActionMenuView.this.f4007B;
            return interfaceC0690e != null && interfaceC0690e.onMenuItemClick(menuItem);
        }

        @Override // p000a.p006b.p049h.p061j.p062j.MenuBuilder.InterfaceC0425a
        /* renamed from: a */
        public void mo7078a(MenuBuilder menuBuilder) {
            MenuBuilder.InterfaceC0425a interfaceC0425a = ActionMenuView.this.f4014w;
            if (interfaceC0425a != null) {
                interfaceC0425a.mo7078a(menuBuilder);
            }
        }
    }

    public ActionMenuView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        setBaselineAligned(false);
        float f = context.getResources().getDisplayMetrics().density;
        this.f4017z = (int) (56.0f * f);
        this.f4006A = (int) (f * 4.0f);
        this.f4009r = context;
        this.f4010s = 0;
    }

    @Override // p000a.p006b.p049h.p061j.p062j.MenuView
    /* renamed from: a */
    public void mo7096a(MenuBuilder menuBuilder) {
        this.f4008q = menuBuilder;
    }

    /* renamed from: a */
    public void m7094a(MenuPresenter.InterfaceC0434a interfaceC0434a, MenuBuilder.InterfaceC0425a interfaceC0425a) {
        this.f4013v = interfaceC0434a;
        this.f4014w = interfaceC0425a;
    }

    /* renamed from: d */
    public boolean m7091d(int i) {
        boolean z = false;
        if (i == 0) {
            return false;
        }
        View childAt = getChildAt(i - 1);
        View childAt2 = getChildAt(i);
        if (i < getChildCount() && (childAt instanceof InterfaceC0686a)) {
            z = false | ((InterfaceC0686a) childAt).mo7082b();
        }
        return (i <= 0 || !(childAt2 instanceof InterfaceC0686a)) ? z : z | ((InterfaceC0686a) childAt2).mo7081c();
    }

    @Override // p000a.p006b.p049h.p063k.LinearLayoutCompat, android.view.ViewGroup
    public C0688c generateDefaultLayoutParams() {
        C0688c c0688c = new C0688c(-2, -2);
        c0688c.f2900b = 16;
        return c0688c;
    }

    @Override // p000a.p006b.p049h.p063k.LinearLayoutCompat, android.view.ViewGroup
    public C0688c generateLayoutParams(AttributeSet attributeSet) {
        return new C0688c(getContext(), attributeSet);
    }

    @Override // p000a.p006b.p049h.p063k.LinearLayoutCompat, android.view.ViewGroup
    public C0688c generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        if (layoutParams != null) {
            C0688c c0688c = layoutParams instanceof C0688c ? new C0688c((C0688c) layoutParams) : new C0688c(layoutParams);
            if (c0688c.f2900b <= 0) {
                c0688c.f2900b = 16;
            }
            return c0688c;
        }
        return generateDefaultLayoutParams();
    }

    /* renamed from: e */
    public C0688c m7090e() {
        C0688c generateDefaultLayoutParams = generateDefaultLayoutParams();
        generateDefaultLayoutParams.f4018c = true;
        return generateDefaultLayoutParams;
    }
}
