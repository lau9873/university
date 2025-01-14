package android.support.p067v7.widget;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;
import android.support.p067v7.widget.ActionMenuView;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.ContextThemeWrapper;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import java.util.ArrayList;
import java.util.List;
import p000a.p006b.p030g.p045k.AbsSavedState;
import p000a.p006b.p030g.p045k.GravityCompat;
import p000a.p006b.p030g.p045k.MarginLayoutParamsCompat;
import p000a.p006b.p030g.p045k.ViewCompat;
import p000a.p006b.p049h.p050a.ActionBar;
import p000a.p006b.p049h.p051b.C0354a;
import p000a.p006b.p049h.p051b.C0363j;
import p000a.p006b.p049h.p053d.p054a.AppCompatResources;
import p000a.p006b.p049h.p061j.CollapsibleActionView;
import p000a.p006b.p049h.p061j.SupportMenuInflater;
import p000a.p006b.p049h.p061j.p062j.MenuBuilder;
import p000a.p006b.p049h.p061j.p062j.MenuItemImpl;
import p000a.p006b.p049h.p061j.p062j.MenuPresenter;
import p000a.p006b.p049h.p061j.p062j.SubMenuBuilder;
import p000a.p006b.p049h.p063k.ActionMenuPresenter;
import p000a.p006b.p049h.p063k.AppCompatImageButton;
import p000a.p006b.p049h.p063k.AppCompatImageView;
import p000a.p006b.p049h.p063k.AppCompatTextView;
import p000a.p006b.p049h.p063k.C0504t1;
import p000a.p006b.p049h.p063k.DecorToolbar;
import p000a.p006b.p049h.p063k.RtlSpacingHelper;
import p000a.p006b.p049h.p063k.TintTypedArray;
import p000a.p006b.p049h.p063k.ToolbarWidgetWrapper;

/* renamed from: android.support.v7.widget.Toolbar */
/* loaded from: classes.dex */
public class Toolbar extends ViewGroup {

    /* renamed from: A */
    public int f4461A;

    /* renamed from: B */
    public int f4462B;

    /* renamed from: C */
    public boolean f4463C;

    /* renamed from: D */
    public boolean f4464D;

    /* renamed from: E */
    public final ArrayList<View> f4465E;

    /* renamed from: F */
    public final ArrayList<View> f4466F;

    /* renamed from: G */
    public final int[] f4467G;

    /* renamed from: H */
    public InterfaceC0774f f4468H;

    /* renamed from: I */
    public final ActionMenuView.InterfaceC0690e f4469I;

    /* renamed from: J */
    public ToolbarWidgetWrapper f4470J;

    /* renamed from: K */
    public ActionMenuPresenter f4471K;

    /* renamed from: L */
    public C0772d f4472L;

    /* renamed from: M */
    public MenuPresenter.InterfaceC0434a f4473M;

    /* renamed from: N */
    public MenuBuilder.InterfaceC0425a f4474N;

    /* renamed from: O */
    public boolean f4475O;

    /* renamed from: P */
    public final Runnable f4476P;

    /* renamed from: a */
    public ActionMenuView f4477a;

    /* renamed from: b */
    public TextView f4478b;

    /* renamed from: c */
    public TextView f4479c;

    /* renamed from: d */
    public ImageButton f4480d;

    /* renamed from: e */
    public ImageView f4481e;

    /* renamed from: f */
    public Drawable f4482f;

    /* renamed from: g */
    public CharSequence f4483g;

    /* renamed from: h */
    public ImageButton f4484h;

    /* renamed from: i */
    public View f4485i;

    /* renamed from: j */
    public Context f4486j;

    /* renamed from: k */
    public int f4487k;

    /* renamed from: m */
    public int f4488m;

    /* renamed from: n */
    public int f4489n;

    /* renamed from: o */
    public int f4490o;

    /* renamed from: p */
    public int f4491p;

    /* renamed from: q */
    public int f4492q;

    /* renamed from: r */
    public int f4493r;

    /* renamed from: s */
    public int f4494s;

    /* renamed from: t */
    public int f4495t;

    /* renamed from: u */
    public RtlSpacingHelper f4496u;

    /* renamed from: v */
    public int f4497v;

    /* renamed from: w */
    public int f4498w;

    /* renamed from: x */
    public int f4499x;

    /* renamed from: y */
    public CharSequence f4500y;

    /* renamed from: z */
    public CharSequence f4501z;

    /* renamed from: android.support.v7.widget.Toolbar$a */
    /* loaded from: classes.dex */
    public class C0769a implements ActionMenuView.InterfaceC0690e {
        public C0769a() {
        }

        @Override // android.support.p067v7.widget.ActionMenuView.InterfaceC0690e
        public boolean onMenuItemClick(MenuItem menuItem) {
            InterfaceC0774f interfaceC0774f = Toolbar.this.f4468H;
            if (interfaceC0774f != null) {
                return interfaceC0774f.onMenuItemClick(menuItem);
            }
            return false;
        }
    }

    /* renamed from: android.support.v7.widget.Toolbar$b */
    /* loaded from: classes.dex */
    public class RunnableC0770b implements Runnable {
        public RunnableC0770b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            Toolbar.this.m6285r();
        }
    }

    /* renamed from: android.support.v7.widget.Toolbar$c */
    /* loaded from: classes.dex */
    public class View$OnClickListenerC0771c implements View.OnClickListener {
        public View$OnClickListenerC0771c() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Toolbar.this.m6303c();
        }
    }

    /* renamed from: android.support.v7.widget.Toolbar$f */
    /* loaded from: classes.dex */
    public interface InterfaceC0774f {
        boolean onMenuItemClick(MenuItem menuItem);
    }

    public Toolbar(Context context) {
        this(context, null);
    }

    private MenuInflater getMenuInflater() {
        return new SupportMenuInflater(getContext());
    }

    /* renamed from: a */
    public void m6319a(MenuBuilder menuBuilder, ActionMenuPresenter actionMenuPresenter) {
        if (menuBuilder == null && this.f4477a == null) {
            return;
        }
        m6294i();
        MenuBuilder m7084j = this.f4477a.m7084j();
        if (m7084j == menuBuilder) {
            return;
        }
        if (m7084j != null) {
            m7084j.m8677b(this.f4471K);
            m7084j.m8677b(this.f4472L);
        }
        if (this.f4472L == null) {
            this.f4472L = new C0772d();
        }
        actionMenuPresenter.m8497b(true);
        if (menuBuilder != null) {
            menuBuilder.m8691a(actionMenuPresenter, this.f4486j);
            menuBuilder.m8691a(this.f4472L, this.f4486j);
        } else {
            actionMenuPresenter.mo6280a(this.f4486j, (MenuBuilder) null);
            this.f4472L.mo6280a(this.f4486j, (MenuBuilder) null);
            actionMenuPresenter.mo6278a(true);
            this.f4472L.mo6278a(true);
        }
        this.f4477a.setPopupTheme(this.f4487k);
        this.f4477a.setPresenter(actionMenuPresenter);
        this.f4471K = actionMenuPresenter;
    }

    /* renamed from: b */
    public boolean m6308b() {
        ActionMenuView actionMenuView;
        return getVisibility() == 0 && (actionMenuView = this.f4477a) != null && actionMenuView.m7085i();
    }

    /* renamed from: c */
    public void m6303c() {
        C0772d c0772d = this.f4472L;
        MenuItemImpl menuItemImpl = c0772d == null ? null : c0772d.f4506b;
        if (menuItemImpl != null) {
            menuItemImpl.collapseActionView();
        }
    }

    @Override // android.view.ViewGroup
    public boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return super.checkLayoutParams(layoutParams) && (layoutParams instanceof C0773e);
    }

    /* renamed from: d */
    public void m6300d() {
        ActionMenuView actionMenuView = this.f4477a;
        if (actionMenuView != null) {
            actionMenuView.m7092d();
        }
    }

    /* renamed from: e */
    public void m6298e() {
        if (this.f4484h == null) {
            this.f4484h = new AppCompatImageButton(getContext(), null, C0354a.toolbarNavigationButtonStyle);
            this.f4484h.setImageDrawable(this.f4482f);
            this.f4484h.setContentDescription(this.f4483g);
            C0773e generateDefaultLayoutParams = generateDefaultLayoutParams();
            generateDefaultLayoutParams.f1872a = 8388611 | (this.f4490o & 112);
            generateDefaultLayoutParams.f4508b = 2;
            this.f4484h.setLayoutParams(generateDefaultLayoutParams);
            this.f4484h.setOnClickListener(new View$OnClickListenerC0771c());
        }
    }

    /* renamed from: f */
    public final void m6297f() {
        if (this.f4496u == null) {
            this.f4496u = new RtlSpacingHelper();
        }
    }

    /* renamed from: g */
    public final void m6296g() {
        if (this.f4481e == null) {
            this.f4481e = new AppCompatImageView(getContext());
        }
    }

    public int getContentInsetEnd() {
        RtlSpacingHelper rtlSpacingHelper = this.f4496u;
        if (rtlSpacingHelper != null) {
            return rtlSpacingHelper.m8515a();
        }
        return 0;
    }

    public int getContentInsetEndWithActions() {
        int i = this.f4498w;
        return i != Integer.MIN_VALUE ? i : getContentInsetEnd();
    }

    public int getContentInsetLeft() {
        RtlSpacingHelper rtlSpacingHelper = this.f4496u;
        if (rtlSpacingHelper != null) {
            return rtlSpacingHelper.m8512b();
        }
        return 0;
    }

    public int getContentInsetRight() {
        RtlSpacingHelper rtlSpacingHelper = this.f4496u;
        if (rtlSpacingHelper != null) {
            return rtlSpacingHelper.m8510c();
        }
        return 0;
    }

    public int getContentInsetStart() {
        RtlSpacingHelper rtlSpacingHelper = this.f4496u;
        if (rtlSpacingHelper != null) {
            return rtlSpacingHelper.m8509d();
        }
        return 0;
    }

    public int getContentInsetStartWithNavigation() {
        int i = this.f4497v;
        return i != Integer.MIN_VALUE ? i : getContentInsetStart();
    }

    public int getCurrentContentInsetEnd() {
        MenuBuilder m7084j;
        ActionMenuView actionMenuView = this.f4477a;
        if ((actionMenuView == null || (m7084j = actionMenuView.m7084j()) == null || !m7084j.hasVisibleItems()) ? false : true) {
            return Math.max(getContentInsetEnd(), Math.max(this.f4498w, 0));
        }
        return getContentInsetEnd();
    }

    public int getCurrentContentInsetLeft() {
        if (ViewCompat.m9422k(this) == 1) {
            return getCurrentContentInsetEnd();
        }
        return getCurrentContentInsetStart();
    }

    public int getCurrentContentInsetRight() {
        if (ViewCompat.m9422k(this) == 1) {
            return getCurrentContentInsetStart();
        }
        return getCurrentContentInsetEnd();
    }

    public int getCurrentContentInsetStart() {
        if (getNavigationIcon() != null) {
            return Math.max(getContentInsetStart(), Math.max(this.f4497v, 0));
        }
        return getContentInsetStart();
    }

    public Drawable getLogo() {
        ImageView imageView = this.f4481e;
        if (imageView != null) {
            return imageView.getDrawable();
        }
        return null;
    }

    public CharSequence getLogoDescription() {
        ImageView imageView = this.f4481e;
        if (imageView != null) {
            return imageView.getContentDescription();
        }
        return null;
    }

    public Menu getMenu() {
        m6295h();
        return this.f4477a.getMenu();
    }

    public CharSequence getNavigationContentDescription() {
        ImageButton imageButton = this.f4480d;
        if (imageButton != null) {
            return imageButton.getContentDescription();
        }
        return null;
    }

    public Drawable getNavigationIcon() {
        ImageButton imageButton = this.f4480d;
        if (imageButton != null) {
            return imageButton.getDrawable();
        }
        return null;
    }

    public ActionMenuPresenter getOuterActionMenuPresenter() {
        return this.f4471K;
    }

    public Drawable getOverflowIcon() {
        m6295h();
        return this.f4477a.getOverflowIcon();
    }

    public Context getPopupContext() {
        return this.f4486j;
    }

    public int getPopupTheme() {
        return this.f4487k;
    }

    public CharSequence getSubtitle() {
        return this.f4501z;
    }

    public CharSequence getTitle() {
        return this.f4500y;
    }

    public int getTitleMarginBottom() {
        return this.f4495t;
    }

    public int getTitleMarginEnd() {
        return this.f4493r;
    }

    public int getTitleMarginStart() {
        return this.f4492q;
    }

    public int getTitleMarginTop() {
        return this.f4494s;
    }

    public DecorToolbar getWrapper() {
        if (this.f4470J == null) {
            this.f4470J = new ToolbarWidgetWrapper(this, true);
        }
        return this.f4470J;
    }

    /* renamed from: h */
    public final void m6295h() {
        m6294i();
        if (this.f4477a.m7084j() == null) {
            MenuBuilder menuBuilder = (MenuBuilder) this.f4477a.getMenu();
            if (this.f4472L == null) {
                this.f4472L = new C0772d();
            }
            this.f4477a.setExpandedActionViewsExclusive(true);
            menuBuilder.m8691a(this.f4472L, this.f4486j);
        }
    }

    /* renamed from: i */
    public final void m6294i() {
        if (this.f4477a == null) {
            this.f4477a = new ActionMenuView(getContext());
            this.f4477a.setPopupTheme(this.f4487k);
            this.f4477a.setOnMenuItemClickListener(this.f4469I);
            this.f4477a.m7094a(this.f4473M, this.f4474N);
            C0773e generateDefaultLayoutParams = generateDefaultLayoutParams();
            generateDefaultLayoutParams.f1872a = 8388613 | (this.f4490o & 112);
            this.f4477a.setLayoutParams(generateDefaultLayoutParams);
            m6311a((View) this.f4477a, false);
        }
    }

    /* renamed from: j */
    public final void m6293j() {
        if (this.f4480d == null) {
            this.f4480d = new AppCompatImageButton(getContext(), null, C0354a.toolbarNavigationButtonStyle);
            C0773e generateDefaultLayoutParams = generateDefaultLayoutParams();
            generateDefaultLayoutParams.f1872a = 8388611 | (this.f4490o & 112);
            this.f4480d.setLayoutParams(generateDefaultLayoutParams);
        }
    }

    /* renamed from: k */
    public boolean m6292k() {
        C0772d c0772d = this.f4472L;
        return (c0772d == null || c0772d.f4506b == null) ? false : true;
    }

    /* renamed from: l */
    public boolean m6291l() {
        ActionMenuView actionMenuView = this.f4477a;
        return actionMenuView != null && actionMenuView.m7088f();
    }

    /* renamed from: m */
    public boolean m6290m() {
        ActionMenuView actionMenuView = this.f4477a;
        return actionMenuView != null && actionMenuView.m7087g();
    }

    /* renamed from: n */
    public boolean m6289n() {
        ActionMenuView actionMenuView = this.f4477a;
        return actionMenuView != null && actionMenuView.m7086h();
    }

    /* renamed from: o */
    public final void m6288o() {
        removeCallbacks(this.f4476P);
        post(this.f4476P);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        removeCallbacks(this.f4476P);
    }

    @Override // android.view.View
    public boolean onHoverEvent(MotionEvent motionEvent) {
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 9) {
            this.f4464D = false;
        }
        if (!this.f4464D) {
            boolean onHoverEvent = super.onHoverEvent(motionEvent);
            if (actionMasked == 9 && !onHoverEvent) {
                this.f4464D = true;
            }
        }
        if (actionMasked == 10 || actionMasked == 3) {
            this.f4464D = false;
        }
        return true;
    }

    /* JADX WARN: Removed duplicated region for block: B:105:0x02a6 A[LOOP:0: B:104:0x02a4->B:105:0x02a6, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:108:0x02c8 A[LOOP:1: B:107:0x02c6->B:108:0x02c8, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:112:0x02f3  */
    /* JADX WARN: Removed duplicated region for block: B:117:0x0302 A[LOOP:2: B:116:0x0300->B:117:0x0302, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:19:0x005f  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0076  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x00b3  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x00ca  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x00e7  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x0100  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x0105  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x011d  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x012d  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x0130  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x0134  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x0137  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x016a  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x01a8  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x01b9  */
    /* JADX WARN: Removed duplicated region for block: B:91:0x022c  */
    @Override // android.view.ViewGroup, android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void onLayout(boolean r20, int r21, int r22, int r23, int r24) {
        /*
            Method dump skipped, instructions count: 791
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.p067v7.widget.Toolbar.onLayout(boolean, int, int, int, int):void");
    }

    @Override // android.view.View
    public void onMeasure(int i, int i2) {
        char c;
        char c2;
        int i3;
        int i4;
        int i5;
        int i6;
        int i7;
        int i8;
        int i9;
        int[] iArr = this.f4467G;
        if (C0504t1.m8047a(this)) {
            c = 1;
            c2 = 0;
        } else {
            c = 0;
            c2 = 1;
        }
        if (m6299d(this.f4480d)) {
            m6314a(this.f4480d, i, 0, i2, 0, this.f4491p);
            i3 = this.f4480d.getMeasuredWidth() + m6316a(this.f4480d);
            i4 = Math.max(0, this.f4480d.getMeasuredHeight() + m6305b(this.f4480d));
            i5 = View.combineMeasuredStates(0, this.f4480d.getMeasuredState());
        } else {
            i3 = 0;
            i4 = 0;
            i5 = 0;
        }
        if (m6299d(this.f4484h)) {
            m6314a(this.f4484h, i, 0, i2, 0, this.f4491p);
            i3 = this.f4484h.getMeasuredWidth() + m6316a(this.f4484h);
            i4 = Math.max(i4, this.f4484h.getMeasuredHeight() + m6305b(this.f4484h));
            i5 = View.combineMeasuredStates(i5, this.f4484h.getMeasuredState());
        }
        int currentContentInsetStart = getCurrentContentInsetStart();
        int max = 0 + Math.max(currentContentInsetStart, i3);
        iArr[c] = Math.max(0, currentContentInsetStart - i3);
        if (m6299d(this.f4477a)) {
            m6314a(this.f4477a, i, max, i2, 0, this.f4491p);
            i6 = this.f4477a.getMeasuredWidth() + m6316a(this.f4477a);
            i4 = Math.max(i4, this.f4477a.getMeasuredHeight() + m6305b(this.f4477a));
            i5 = View.combineMeasuredStates(i5, this.f4477a.getMeasuredState());
        } else {
            i6 = 0;
        }
        int currentContentInsetEnd = getCurrentContentInsetEnd();
        int max2 = max + Math.max(currentContentInsetEnd, i6);
        iArr[c2] = Math.max(0, currentContentInsetEnd - i6);
        if (m6299d(this.f4485i)) {
            max2 += m6313a(this.f4485i, i, max2, i2, 0, iArr);
            i4 = Math.max(i4, this.f4485i.getMeasuredHeight() + m6305b(this.f4485i));
            i5 = View.combineMeasuredStates(i5, this.f4485i.getMeasuredState());
        }
        if (m6299d(this.f4481e)) {
            max2 += m6313a(this.f4481e, i, max2, i2, 0, iArr);
            i4 = Math.max(i4, this.f4481e.getMeasuredHeight() + m6305b(this.f4481e));
            i5 = View.combineMeasuredStates(i5, this.f4481e.getMeasuredState());
        }
        int childCount = getChildCount();
        int i10 = i4;
        int i11 = max2;
        for (int i12 = 0; i12 < childCount; i12++) {
            View childAt = getChildAt(i12);
            if (((C0773e) childAt.getLayoutParams()).f4508b == 0 && m6299d(childAt)) {
                i11 += m6313a(childAt, i, i11, i2, 0, iArr);
                i10 = Math.max(i10, childAt.getMeasuredHeight() + m6305b(childAt));
                i5 = View.combineMeasuredStates(i5, childAt.getMeasuredState());
            }
        }
        int i13 = this.f4494s + this.f4495t;
        int i14 = this.f4492q + this.f4493r;
        if (m6299d(this.f4478b)) {
            m6313a(this.f4478b, i, i11 + i14, i2, i13, iArr);
            int measuredWidth = this.f4478b.getMeasuredWidth() + m6316a(this.f4478b);
            i9 = this.f4478b.getMeasuredHeight() + m6305b(this.f4478b);
            i7 = View.combineMeasuredStates(i5, this.f4478b.getMeasuredState());
            i8 = measuredWidth;
        } else {
            i7 = i5;
            i8 = 0;
            i9 = 0;
        }
        if (m6299d(this.f4479c)) {
            i8 = Math.max(i8, m6313a(this.f4479c, i, i11 + i14, i2, i9 + i13, iArr));
            i9 += this.f4479c.getMeasuredHeight() + m6305b(this.f4479c);
            i7 = View.combineMeasuredStates(i7, this.f4479c.getMeasuredState());
        }
        int max3 = Math.max(i10, i9);
        int paddingLeft = i11 + i8 + getPaddingLeft() + getPaddingRight();
        int paddingTop = max3 + getPaddingTop() + getPaddingBottom();
        int resolveSizeAndState = View.resolveSizeAndState(Math.max(paddingLeft, getSuggestedMinimumWidth()), i, (-16777216) & i7);
        int resolveSizeAndState2 = View.resolveSizeAndState(Math.max(paddingTop, getSuggestedMinimumHeight()), i2, i7 << 16);
        if (m6286q()) {
            resolveSizeAndState2 = 0;
        }
        setMeasuredDimension(resolveSizeAndState, resolveSizeAndState2);
    }

    @Override // android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        MenuItem findItem;
        if (!(parcelable instanceof C0775g)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        C0775g c0775g = (C0775g) parcelable;
        super.onRestoreInstanceState(c0775g.m9588a());
        ActionMenuView actionMenuView = this.f4477a;
        MenuBuilder m7084j = actionMenuView != null ? actionMenuView.m7084j() : null;
        int i = c0775g.f4509c;
        if (i != 0 && this.f4472L != null && m7084j != null && (findItem = m7084j.findItem(i)) != null) {
            findItem.expandActionView();
        }
        if (c0775g.f4510d) {
            m6288o();
        }
    }

    @Override // android.view.View
    public void onRtlPropertiesChanged(int i) {
        if (Build.VERSION.SDK_INT >= 17) {
            super.onRtlPropertiesChanged(i);
        }
        m6297f();
        this.f4496u.m8513a(i == 1);
    }

    @Override // android.view.View
    public Parcelable onSaveInstanceState() {
        MenuItemImpl menuItemImpl;
        C0775g c0775g = new C0775g(super.onSaveInstanceState());
        C0772d c0772d = this.f4472L;
        if (c0772d != null && (menuItemImpl = c0772d.f4506b) != null) {
            c0775g.f4509c = menuItemImpl.getItemId();
        }
        c0775g.f4510d = m6289n();
        return c0775g;
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 0) {
            this.f4463C = false;
        }
        if (!this.f4463C) {
            boolean onTouchEvent = super.onTouchEvent(motionEvent);
            if (actionMasked == 0 && !onTouchEvent) {
                this.f4463C = true;
            }
        }
        if (actionMasked == 1 || actionMasked == 3) {
            this.f4463C = false;
        }
        return true;
    }

    /* renamed from: p */
    public void m6287p() {
        for (int childCount = getChildCount() - 1; childCount >= 0; childCount--) {
            View childAt = getChildAt(childCount);
            if (((C0773e) childAt.getLayoutParams()).f4508b != 2 && childAt != this.f4477a) {
                removeViewAt(childCount);
                this.f4466F.add(childAt);
            }
        }
    }

    /* renamed from: q */
    public final boolean m6286q() {
        if (this.f4475O) {
            int childCount = getChildCount();
            for (int i = 0; i < childCount; i++) {
                View childAt = getChildAt(i);
                if (m6299d(childAt) && childAt.getMeasuredWidth() > 0 && childAt.getMeasuredHeight() > 0) {
                    return false;
                }
            }
            return true;
        }
        return false;
    }

    /* renamed from: r */
    public boolean m6285r() {
        ActionMenuView actionMenuView = this.f4477a;
        return actionMenuView != null && actionMenuView.m7083k();
    }

    public void setCollapsible(boolean z) {
        this.f4475O = z;
        requestLayout();
    }

    public void setContentInsetEndWithActions(int i) {
        if (i < 0) {
            i = Integer.MIN_VALUE;
        }
        if (i != this.f4498w) {
            this.f4498w = i;
            if (getNavigationIcon() != null) {
                requestLayout();
            }
        }
    }

    public void setContentInsetStartWithNavigation(int i) {
        if (i < 0) {
            i = Integer.MIN_VALUE;
        }
        if (i != this.f4497v) {
            this.f4497v = i;
            if (getNavigationIcon() != null) {
                requestLayout();
            }
        }
    }

    public void setLogo(int i) {
        setLogo(AppCompatResources.m8967c(getContext(), i));
    }

    public void setLogoDescription(int i) {
        setLogoDescription(getContext().getText(i));
    }

    public void setNavigationContentDescription(int i) {
        setNavigationContentDescription(i != 0 ? getContext().getText(i) : null);
    }

    public void setNavigationIcon(int i) {
        setNavigationIcon(AppCompatResources.m8967c(getContext(), i));
    }

    public void setNavigationOnClickListener(View.OnClickListener onClickListener) {
        m6293j();
        this.f4480d.setOnClickListener(onClickListener);
    }

    public void setOnMenuItemClickListener(InterfaceC0774f interfaceC0774f) {
        this.f4468H = interfaceC0774f;
    }

    public void setOverflowIcon(Drawable drawable) {
        m6295h();
        this.f4477a.setOverflowIcon(drawable);
    }

    public void setPopupTheme(int i) {
        if (this.f4487k != i) {
            this.f4487k = i;
            if (i == 0) {
                this.f4486j = getContext();
            } else {
                this.f4486j = new ContextThemeWrapper(getContext(), i);
            }
        }
    }

    public void setSubtitle(int i) {
        setSubtitle(getContext().getText(i));
    }

    public void setSubtitleTextColor(int i) {
        this.f4462B = i;
        TextView textView = this.f4479c;
        if (textView != null) {
            textView.setTextColor(i);
        }
    }

    public void setTitle(int i) {
        setTitle(getContext().getText(i));
    }

    public void setTitleMarginBottom(int i) {
        this.f4495t = i;
        requestLayout();
    }

    public void setTitleMarginEnd(int i) {
        this.f4493r = i;
        requestLayout();
    }

    public void setTitleMarginStart(int i) {
        this.f4492q = i;
        requestLayout();
    }

    public void setTitleMarginTop(int i) {
        this.f4494s = i;
        requestLayout();
    }

    public void setTitleTextColor(int i) {
        this.f4461A = i;
        TextView textView = this.f4478b;
        if (textView != null) {
            textView.setTextColor(i);
        }
    }

    /* renamed from: android.support.v7.widget.Toolbar$e */
    /* loaded from: classes.dex */
    public static class C0773e extends ActionBar.C0322a {

        /* renamed from: b */
        public int f4508b;

        public C0773e(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            this.f4508b = 0;
        }

        /* renamed from: a */
        public void m6274a(ViewGroup.MarginLayoutParams marginLayoutParams) {
            ((ViewGroup.MarginLayoutParams) this).leftMargin = marginLayoutParams.leftMargin;
            ((ViewGroup.MarginLayoutParams) this).topMargin = marginLayoutParams.topMargin;
            ((ViewGroup.MarginLayoutParams) this).rightMargin = marginLayoutParams.rightMargin;
            ((ViewGroup.MarginLayoutParams) this).bottomMargin = marginLayoutParams.bottomMargin;
        }

        public C0773e(int i, int i2) {
            super(i, i2);
            this.f4508b = 0;
            this.f1872a = 8388627;
        }

        public C0773e(C0773e c0773e) {
            super((ActionBar.C0322a) c0773e);
            this.f4508b = 0;
            this.f4508b = c0773e.f4508b;
        }

        public C0773e(ActionBar.C0322a c0322a) {
            super(c0322a);
            this.f4508b = 0;
        }

        public C0773e(ViewGroup.MarginLayoutParams marginLayoutParams) {
            super(marginLayoutParams);
            this.f4508b = 0;
            m6274a(marginLayoutParams);
        }

        public C0773e(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
            this.f4508b = 0;
        }
    }

    public Toolbar(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, C0354a.toolbarStyle);
    }

    /* renamed from: b */
    public void m6306b(Context context, int i) {
        this.f4488m = i;
        TextView textView = this.f4478b;
        if (textView != null) {
            textView.setTextAppearance(context, i);
        }
    }

    @Override // android.view.ViewGroup
    public C0773e generateDefaultLayoutParams() {
        return new C0773e(-2, -2);
    }

    public void setLogo(Drawable drawable) {
        if (drawable != null) {
            m6296g();
            if (!m6301c(this.f4481e)) {
                m6311a((View) this.f4481e, true);
            }
        } else {
            ImageView imageView = this.f4481e;
            if (imageView != null && m6301c(imageView)) {
                removeView(this.f4481e);
                this.f4466F.remove(this.f4481e);
            }
        }
        ImageView imageView2 = this.f4481e;
        if (imageView2 != null) {
            imageView2.setImageDrawable(drawable);
        }
    }

    public void setLogoDescription(CharSequence charSequence) {
        if (!TextUtils.isEmpty(charSequence)) {
            m6296g();
        }
        ImageView imageView = this.f4481e;
        if (imageView != null) {
            imageView.setContentDescription(charSequence);
        }
    }

    public void setNavigationContentDescription(CharSequence charSequence) {
        if (!TextUtils.isEmpty(charSequence)) {
            m6293j();
        }
        ImageButton imageButton = this.f4480d;
        if (imageButton != null) {
            imageButton.setContentDescription(charSequence);
        }
    }

    public void setNavigationIcon(Drawable drawable) {
        if (drawable != null) {
            m6293j();
            if (!m6301c(this.f4480d)) {
                m6311a((View) this.f4480d, true);
            }
        } else {
            ImageButton imageButton = this.f4480d;
            if (imageButton != null && m6301c(imageButton)) {
                removeView(this.f4480d);
                this.f4466F.remove(this.f4480d);
            }
        }
        ImageButton imageButton2 = this.f4480d;
        if (imageButton2 != null) {
            imageButton2.setImageDrawable(drawable);
        }
    }

    public void setSubtitle(CharSequence charSequence) {
        if (!TextUtils.isEmpty(charSequence)) {
            if (this.f4479c == null) {
                Context context = getContext();
                this.f4479c = new AppCompatTextView(context);
                this.f4479c.setSingleLine();
                this.f4479c.setEllipsize(TextUtils.TruncateAt.END);
                int i = this.f4489n;
                if (i != 0) {
                    this.f4479c.setTextAppearance(context, i);
                }
                int i2 = this.f4462B;
                if (i2 != 0) {
                    this.f4479c.setTextColor(i2);
                }
            }
            if (!m6301c(this.f4479c)) {
                m6311a((View) this.f4479c, true);
            }
        } else {
            TextView textView = this.f4479c;
            if (textView != null && m6301c(textView)) {
                removeView(this.f4479c);
                this.f4466F.remove(this.f4479c);
            }
        }
        TextView textView2 = this.f4479c;
        if (textView2 != null) {
            textView2.setText(charSequence);
        }
        this.f4501z = charSequence;
    }

    public void setTitle(CharSequence charSequence) {
        if (!TextUtils.isEmpty(charSequence)) {
            if (this.f4478b == null) {
                Context context = getContext();
                this.f4478b = new AppCompatTextView(context);
                this.f4478b.setSingleLine();
                this.f4478b.setEllipsize(TextUtils.TruncateAt.END);
                int i = this.f4488m;
                if (i != 0) {
                    this.f4478b.setTextAppearance(context, i);
                }
                int i2 = this.f4461A;
                if (i2 != 0) {
                    this.f4478b.setTextColor(i2);
                }
            }
            if (!m6301c(this.f4478b)) {
                m6311a((View) this.f4478b, true);
            }
        } else {
            TextView textView = this.f4478b;
            if (textView != null && m6301c(textView)) {
                removeView(this.f4478b);
                this.f4466F.remove(this.f4478b);
            }
        }
        TextView textView2 = this.f4478b;
        if (textView2 != null) {
            textView2.setText(charSequence);
        }
        this.f4500y = charSequence;
    }

    /* renamed from: android.support.v7.widget.Toolbar$d */
    /* loaded from: classes.dex */
    public class C0772d implements MenuPresenter {

        /* renamed from: a */
        public MenuBuilder f4505a;

        /* renamed from: b */
        public MenuItemImpl f4506b;

        public C0772d() {
        }

        @Override // p000a.p006b.p049h.p061j.p062j.MenuPresenter
        /* renamed from: a */
        public int mo6284a() {
            return 0;
        }

        @Override // p000a.p006b.p049h.p061j.p062j.MenuPresenter
        /* renamed from: a */
        public void mo6282a(MenuBuilder menuBuilder, boolean z) {
        }

        @Override // p000a.p006b.p049h.p061j.p062j.MenuPresenter
        /* renamed from: a */
        public void mo6280a(Context context, MenuBuilder menuBuilder) {
            MenuItemImpl menuItemImpl;
            MenuBuilder menuBuilder2 = this.f4505a;
            if (menuBuilder2 != null && (menuItemImpl = this.f4506b) != null) {
                menuBuilder2.mo8577a(menuItemImpl);
            }
            this.f4505a = menuBuilder;
        }

        @Override // p000a.p006b.p049h.p061j.p062j.MenuPresenter
        /* renamed from: a */
        public void mo6279a(Parcelable parcelable) {
        }

        @Override // p000a.p006b.p049h.p061j.p062j.MenuPresenter
        /* renamed from: a */
        public boolean mo6281a(SubMenuBuilder subMenuBuilder) {
            return false;
        }

        @Override // p000a.p006b.p049h.p061j.p062j.MenuPresenter
        /* renamed from: b */
        public boolean mo6277b() {
            return false;
        }

        @Override // p000a.p006b.p049h.p061j.p062j.MenuPresenter
        /* renamed from: b */
        public boolean mo6276b(MenuBuilder menuBuilder, MenuItemImpl menuItemImpl) {
            View view = Toolbar.this.f4485i;
            if (view instanceof CollapsibleActionView) {
                ((CollapsibleActionView) view).mo6511c();
            }
            Toolbar toolbar = Toolbar.this;
            toolbar.removeView(toolbar.f4485i);
            Toolbar toolbar2 = Toolbar.this;
            toolbar2.removeView(toolbar2.f4484h);
            Toolbar toolbar3 = Toolbar.this;
            toolbar3.f4485i = null;
            toolbar3.m6322a();
            this.f4506b = null;
            Toolbar.this.requestLayout();
            menuItemImpl.m8640a(false);
            return true;
        }

        @Override // p000a.p006b.p049h.p061j.p062j.MenuPresenter
        /* renamed from: c */
        public Parcelable mo6275c() {
            return null;
        }

        @Override // p000a.p006b.p049h.p061j.p062j.MenuPresenter
        /* renamed from: a */
        public void mo6278a(boolean z) {
            if (this.f4506b != null) {
                MenuBuilder menuBuilder = this.f4505a;
                boolean z2 = false;
                if (menuBuilder != null) {
                    int size = menuBuilder.size();
                    int i = 0;
                    while (true) {
                        if (i >= size) {
                            break;
                        } else if (this.f4505a.getItem(i) == this.f4506b) {
                            z2 = true;
                            break;
                        } else {
                            i++;
                        }
                    }
                }
                if (z2) {
                    return;
                }
                mo6276b(this.f4505a, this.f4506b);
            }
        }

        @Override // p000a.p006b.p049h.p061j.p062j.MenuPresenter
        /* renamed from: a */
        public boolean mo6283a(MenuBuilder menuBuilder, MenuItemImpl menuItemImpl) {
            Toolbar.this.m6298e();
            ViewParent parent = Toolbar.this.f4484h.getParent();
            Toolbar toolbar = Toolbar.this;
            if (parent != toolbar) {
                if (parent instanceof ViewGroup) {
                    ((ViewGroup) parent).removeView(toolbar.f4484h);
                }
                Toolbar toolbar2 = Toolbar.this;
                toolbar2.addView(toolbar2.f4484h);
            }
            Toolbar.this.f4485i = menuItemImpl.getActionView();
            this.f4506b = menuItemImpl;
            ViewParent parent2 = Toolbar.this.f4485i.getParent();
            Toolbar toolbar3 = Toolbar.this;
            if (parent2 != toolbar3) {
                if (parent2 instanceof ViewGroup) {
                    ((ViewGroup) parent2).removeView(toolbar3.f4485i);
                }
                C0773e generateDefaultLayoutParams = Toolbar.this.generateDefaultLayoutParams();
                Toolbar toolbar4 = Toolbar.this;
                generateDefaultLayoutParams.f1872a = 8388611 | (toolbar4.f4490o & 112);
                generateDefaultLayoutParams.f4508b = 2;
                toolbar4.f4485i.setLayoutParams(generateDefaultLayoutParams);
                Toolbar toolbar5 = Toolbar.this;
                toolbar5.addView(toolbar5.f4485i);
            }
            Toolbar.this.m6287p();
            Toolbar.this.requestLayout();
            menuItemImpl.m8640a(true);
            View view = Toolbar.this.f4485i;
            if (view instanceof CollapsibleActionView) {
                ((CollapsibleActionView) view).mo6516b();
            }
            return true;
        }
    }

    /* renamed from: android.support.v7.widget.Toolbar$g */
    /* loaded from: classes.dex */
    public static class C0775g extends AbsSavedState {
        public static final Parcelable.Creator<C0775g> CREATOR = new C0776a();

        /* renamed from: c */
        public int f4509c;

        /* renamed from: d */
        public boolean f4510d;

        /* renamed from: android.support.v7.widget.Toolbar$g$a */
        /* loaded from: classes.dex */
        public static class C0776a implements Parcelable.ClassLoaderCreator<C0775g> {
            @Override // android.os.Parcelable.Creator
            public C0775g[] newArray(int i) {
                return new C0775g[i];
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.ClassLoaderCreator
            public C0775g createFromParcel(Parcel parcel, ClassLoader classLoader) {
                return new C0775g(parcel, classLoader);
            }

            @Override // android.os.Parcelable.Creator
            public C0775g createFromParcel(Parcel parcel) {
                return new C0775g(parcel, null);
            }
        }

        public C0775g(Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            this.f4509c = parcel.readInt();
            this.f4510d = parcel.readInt() != 0;
        }

        @Override // p000a.p006b.p030g.p045k.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeInt(this.f4509c);
            parcel.writeInt(this.f4510d ? 1 : 0);
        }

        public C0775g(Parcelable parcelable) {
            super(parcelable);
        }
    }

    public Toolbar(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f4499x = 8388627;
        this.f4465E = new ArrayList<>();
        this.f4466F = new ArrayList<>();
        this.f4467G = new int[2];
        this.f4469I = new C0769a();
        this.f4476P = new RunnableC0770b();
        TintTypedArray m8257a = TintTypedArray.m8257a(getContext(), attributeSet, C0363j.Toolbar, i, 0);
        this.f4488m = m8257a.m8244g(C0363j.Toolbar_titleTextAppearance, 0);
        this.f4489n = m8257a.m8244g(C0363j.Toolbar_subtitleTextAppearance, 0);
        this.f4499x = m8257a.m8248e(C0363j.Toolbar_android_gravity, this.f4499x);
        this.f4490o = m8257a.m8248e(C0363j.Toolbar_buttonGravity, 48);
        int m8254b = m8257a.m8254b(C0363j.Toolbar_titleMargin, 0);
        m8254b = m8257a.m8245g(C0363j.Toolbar_titleMargins) ? m8257a.m8254b(C0363j.Toolbar_titleMargins, m8254b) : m8254b;
        this.f4495t = m8254b;
        this.f4494s = m8254b;
        this.f4493r = m8254b;
        this.f4492q = m8254b;
        int m8254b2 = m8257a.m8254b(C0363j.Toolbar_titleMarginStart, -1);
        if (m8254b2 >= 0) {
            this.f4492q = m8254b2;
        }
        int m8254b3 = m8257a.m8254b(C0363j.Toolbar_titleMarginEnd, -1);
        if (m8254b3 >= 0) {
            this.f4493r = m8254b3;
        }
        int m8254b4 = m8257a.m8254b(C0363j.Toolbar_titleMarginTop, -1);
        if (m8254b4 >= 0) {
            this.f4494s = m8254b4;
        }
        int m8254b5 = m8257a.m8254b(C0363j.Toolbar_titleMarginBottom, -1);
        if (m8254b5 >= 0) {
            this.f4495t = m8254b5;
        }
        this.f4491p = m8257a.m8252c(C0363j.Toolbar_maxButtonHeight, -1);
        int m8254b6 = m8257a.m8254b(C0363j.Toolbar_contentInsetStart, Integer.MIN_VALUE);
        int m8254b7 = m8257a.m8254b(C0363j.Toolbar_contentInsetEnd, Integer.MIN_VALUE);
        int m8252c = m8257a.m8252c(C0363j.Toolbar_contentInsetLeft, 0);
        int m8252c2 = m8257a.m8252c(C0363j.Toolbar_contentInsetRight, 0);
        m6297f();
        this.f4496u.m8514a(m8252c, m8252c2);
        if (m8254b6 != Integer.MIN_VALUE || m8254b7 != Integer.MIN_VALUE) {
            this.f4496u.m8511b(m8254b6, m8254b7);
        }
        this.f4497v = m8257a.m8254b(C0363j.Toolbar_contentInsetStartWithNavigation, Integer.MIN_VALUE);
        this.f4498w = m8257a.m8254b(C0363j.Toolbar_contentInsetEndWithActions, Integer.MIN_VALUE);
        this.f4482f = m8257a.m8256b(C0363j.Toolbar_collapseIcon);
        this.f4483g = m8257a.m8249e(C0363j.Toolbar_collapseContentDescription);
        CharSequence m8249e = m8257a.m8249e(C0363j.Toolbar_title);
        if (!TextUtils.isEmpty(m8249e)) {
            setTitle(m8249e);
        }
        CharSequence m8249e2 = m8257a.m8249e(C0363j.Toolbar_subtitle);
        if (!TextUtils.isEmpty(m8249e2)) {
            setSubtitle(m8249e2);
        }
        this.f4486j = getContext();
        setPopupTheme(m8257a.m8244g(C0363j.Toolbar_popupTheme, 0));
        Drawable m8256b = m8257a.m8256b(C0363j.Toolbar_navigationIcon);
        if (m8256b != null) {
            setNavigationIcon(m8256b);
        }
        CharSequence m8249e3 = m8257a.m8249e(C0363j.Toolbar_navigationContentDescription);
        if (!TextUtils.isEmpty(m8249e3)) {
            setNavigationContentDescription(m8249e3);
        }
        Drawable m8256b2 = m8257a.m8256b(C0363j.Toolbar_logo);
        if (m8256b2 != null) {
            setLogo(m8256b2);
        }
        CharSequence m8249e4 = m8257a.m8249e(C0363j.Toolbar_logoDescription);
        if (!TextUtils.isEmpty(m8249e4)) {
            setLogoDescription(m8249e4);
        }
        if (m8257a.m8245g(C0363j.Toolbar_titleTextColor)) {
            setTitleTextColor(m8257a.m8262a(C0363j.Toolbar_titleTextColor, -1));
        }
        if (m8257a.m8245g(C0363j.Toolbar_subtitleTextColor)) {
            setSubtitleTextColor(m8257a.m8262a(C0363j.Toolbar_subtitleTextColor, -1));
        }
        m8257a.m8265a();
    }

    /* renamed from: c */
    public void m6302c(int i) {
        getMenuInflater().inflate(i, getMenu());
    }

    /* renamed from: d */
    public final boolean m6299d(View view) {
        return (view == null || view.getParent() != this || view.getVisibility() == 8) ? false : true;
    }

    @Override // android.view.ViewGroup
    public C0773e generateLayoutParams(AttributeSet attributeSet) {
        return new C0773e(getContext(), attributeSet);
    }

    /* renamed from: c */
    public final boolean m6301c(View view) {
        return view.getParent() == this || this.f4466F.contains(view);
    }

    @Override // android.view.ViewGroup
    public C0773e generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        if (layoutParams instanceof C0773e) {
            return new C0773e((C0773e) layoutParams);
        }
        if (layoutParams instanceof ActionBar.C0322a) {
            return new C0773e((ActionBar.C0322a) layoutParams);
        }
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            return new C0773e((ViewGroup.MarginLayoutParams) layoutParams);
        }
        return new C0773e(layoutParams);
    }

    /* renamed from: b */
    public final int m6304b(View view, int i, int[] iArr, int i2) {
        C0773e c0773e = (C0773e) view.getLayoutParams();
        int i3 = ((ViewGroup.MarginLayoutParams) c0773e).rightMargin - iArr[1];
        int max = i - Math.max(0, i3);
        iArr[1] = Math.max(0, -i3);
        int m6315a = m6315a(view, i2);
        int measuredWidth = view.getMeasuredWidth();
        view.layout(max - measuredWidth, m6315a, max, view.getMeasuredHeight() + m6315a);
        return max - (measuredWidth + ((ViewGroup.MarginLayoutParams) c0773e).leftMargin);
    }

    /* renamed from: b */
    public final int m6307b(int i) {
        int i2 = i & 112;
        return (i2 == 16 || i2 == 48 || i2 == 80) ? i2 : this.f4499x & 112;
    }

    /* renamed from: b */
    public final int m6305b(View view) {
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
        return marginLayoutParams.topMargin + marginLayoutParams.bottomMargin;
    }

    /* renamed from: a */
    public void m6317a(Context context, int i) {
        this.f4489n = i;
        TextView textView = this.f4479c;
        if (textView != null) {
            textView.setTextAppearance(context, i);
        }
    }

    /* renamed from: a */
    public void m6320a(int i, int i2) {
        m6297f();
        this.f4496u.m8511b(i, i2);
    }

    /* renamed from: a */
    public final void m6311a(View view, boolean z) {
        C0773e c0773e;
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (layoutParams == null) {
            c0773e = generateDefaultLayoutParams();
        } else if (!checkLayoutParams(layoutParams)) {
            c0773e = generateLayoutParams(layoutParams);
        } else {
            c0773e = (C0773e) layoutParams;
        }
        c0773e.f4508b = 1;
        if (z && this.f4485i != null) {
            view.setLayoutParams(c0773e);
            this.f4466F.add(view);
            return;
        }
        addView(view, c0773e);
    }

    /* renamed from: a */
    public final void m6314a(View view, int i, int i2, int i3, int i4, int i5) {
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
        int childMeasureSpec = ViewGroup.getChildMeasureSpec(i, getPaddingLeft() + getPaddingRight() + marginLayoutParams.leftMargin + marginLayoutParams.rightMargin + i2, marginLayoutParams.width);
        int childMeasureSpec2 = ViewGroup.getChildMeasureSpec(i3, getPaddingTop() + getPaddingBottom() + marginLayoutParams.topMargin + marginLayoutParams.bottomMargin + i4, marginLayoutParams.height);
        int mode = View.MeasureSpec.getMode(childMeasureSpec2);
        if (mode != 1073741824 && i5 >= 0) {
            if (mode != 0) {
                i5 = Math.min(View.MeasureSpec.getSize(childMeasureSpec2), i5);
            }
            childMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(i5, 1073741824);
        }
        view.measure(childMeasureSpec, childMeasureSpec2);
    }

    /* renamed from: a */
    public final int m6313a(View view, int i, int i2, int i3, int i4, int[] iArr) {
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
        int i5 = marginLayoutParams.leftMargin - iArr[0];
        int i6 = marginLayoutParams.rightMargin - iArr[1];
        int max = Math.max(0, i5) + Math.max(0, i6);
        iArr[0] = Math.max(0, -i5);
        iArr[1] = Math.max(0, -i6);
        view.measure(ViewGroup.getChildMeasureSpec(i, getPaddingLeft() + getPaddingRight() + max + i2, marginLayoutParams.width), ViewGroup.getChildMeasureSpec(i3, getPaddingTop() + getPaddingBottom() + marginLayoutParams.topMargin + marginLayoutParams.bottomMargin + i4, marginLayoutParams.height));
        return view.getMeasuredWidth() + max;
    }

    /* renamed from: a */
    public final int m6309a(List<View> list, int[] iArr) {
        int i = iArr[0];
        int i2 = iArr[1];
        int size = list.size();
        int i3 = i2;
        int i4 = i;
        int i5 = 0;
        int i6 = 0;
        while (i5 < size) {
            View view = list.get(i5);
            C0773e c0773e = (C0773e) view.getLayoutParams();
            int i7 = ((ViewGroup.MarginLayoutParams) c0773e).leftMargin - i4;
            int i8 = ((ViewGroup.MarginLayoutParams) c0773e).rightMargin - i3;
            int max = Math.max(0, i7);
            int max2 = Math.max(0, i8);
            int max3 = Math.max(0, -i7);
            int max4 = Math.max(0, -i8);
            i6 += max + view.getMeasuredWidth() + max2;
            i5++;
            i3 = max4;
            i4 = max3;
        }
        return i6;
    }

    /* renamed from: a */
    public final int m6312a(View view, int i, int[] iArr, int i2) {
        C0773e c0773e = (C0773e) view.getLayoutParams();
        int i3 = ((ViewGroup.MarginLayoutParams) c0773e).leftMargin - iArr[0];
        int max = i + Math.max(0, i3);
        iArr[0] = Math.max(0, -i3);
        int m6315a = m6315a(view, i2);
        int measuredWidth = view.getMeasuredWidth();
        view.layout(max, m6315a, max + measuredWidth, view.getMeasuredHeight() + m6315a);
        return max + measuredWidth + ((ViewGroup.MarginLayoutParams) c0773e).rightMargin;
    }

    /* renamed from: a */
    public final int m6315a(View view, int i) {
        C0773e c0773e = (C0773e) view.getLayoutParams();
        int measuredHeight = view.getMeasuredHeight();
        int i2 = i > 0 ? (measuredHeight - i) / 2 : 0;
        int m6307b = m6307b(c0773e.f1872a);
        if (m6307b != 48) {
            if (m6307b != 80) {
                int paddingTop = getPaddingTop();
                int paddingBottom = getPaddingBottom();
                int height = getHeight();
                int i3 = (((height - paddingTop) - paddingBottom) - measuredHeight) / 2;
                int i4 = ((ViewGroup.MarginLayoutParams) c0773e).topMargin;
                if (i3 < i4) {
                    i3 = i4;
                } else {
                    int i5 = (((height - paddingBottom) - measuredHeight) - i3) - paddingTop;
                    int i6 = ((ViewGroup.MarginLayoutParams) c0773e).bottomMargin;
                    if (i5 < i6) {
                        i3 = Math.max(0, i3 - (i6 - i5));
                    }
                }
                return paddingTop + i3;
            }
            return (((getHeight() - getPaddingBottom()) - measuredHeight) - ((ViewGroup.MarginLayoutParams) c0773e).bottomMargin) - i2;
        }
        return getPaddingTop() - i2;
    }

    /* renamed from: a */
    public final void m6310a(List<View> list, int i) {
        boolean z = ViewCompat.m9422k(this) == 1;
        int childCount = getChildCount();
        int m9579a = GravityCompat.m9579a(i, ViewCompat.m9422k(this));
        list.clear();
        if (!z) {
            for (int i2 = 0; i2 < childCount; i2++) {
                View childAt = getChildAt(i2);
                C0773e c0773e = (C0773e) childAt.getLayoutParams();
                if (c0773e.f4508b == 0 && m6299d(childAt) && m6321a(c0773e.f1872a) == m9579a) {
                    list.add(childAt);
                }
            }
            return;
        }
        for (int i3 = childCount - 1; i3 >= 0; i3--) {
            View childAt2 = getChildAt(i3);
            C0773e c0773e2 = (C0773e) childAt2.getLayoutParams();
            if (c0773e2.f4508b == 0 && m6299d(childAt2) && m6321a(c0773e2.f1872a) == m9579a) {
                list.add(childAt2);
            }
        }
    }

    /* renamed from: a */
    public final int m6321a(int i) {
        int m9422k = ViewCompat.m9422k(this);
        int m9579a = GravityCompat.m9579a(i, m9422k) & 7;
        return (m9579a == 1 || m9579a == 3 || m9579a == 5) ? m9579a : m9422k == 1 ? 5 : 3;
    }

    /* renamed from: a */
    public final int m6316a(View view) {
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
        return MarginLayoutParamsCompat.m9507b(marginLayoutParams) + MarginLayoutParamsCompat.m9508a(marginLayoutParams);
    }

    /* renamed from: a */
    public void m6322a() {
        for (int size = this.f4466F.size() - 1; size >= 0; size--) {
            addView(this.f4466F.get(size));
        }
        this.f4466F.clear();
    }

    /* renamed from: a */
    public void m6318a(MenuPresenter.InterfaceC0434a interfaceC0434a, MenuBuilder.InterfaceC0425a interfaceC0425a) {
        this.f4473M = interfaceC0434a;
        this.f4474N = interfaceC0425a;
        ActionMenuView actionMenuView = this.f4477a;
        if (actionMenuView != null) {
            actionMenuView.m7094a(interfaceC0434a, interfaceC0425a);
        }
    }
}
