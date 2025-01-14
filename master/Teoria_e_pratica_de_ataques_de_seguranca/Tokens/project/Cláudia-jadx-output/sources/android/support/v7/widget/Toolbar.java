package android.support.v7.widget;

import a.b.g.k.u;
import a.b.h.a.a;
import a.b.h.b.j;
import a.b.h.j.j.h;
import a.b.h.j.j.k;
import a.b.h.j.j.p;
import a.b.h.j.j.v;
import a.b.h.k.b1;
import a.b.h.k.i0;
import a.b.h.k.l1;
import a.b.h.k.m1;
import a.b.h.k.n;
import a.b.h.k.t1;
import a.b.h.k.z;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;
import android.support.v7.widget.ActionMenuView;
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
/* loaded from: classes.dex */
public class Toolbar extends ViewGroup {
    public int A;
    public int B;
    public boolean C;
    public boolean D;
    public final ArrayList<View> E;
    public final ArrayList<View> F;
    public final int[] G;
    public f H;
    public final ActionMenuView.e I;
    public m1 J;
    public a.b.h.k.c K;
    public d L;
    public p.a M;
    public h.a N;
    public boolean O;
    public final Runnable P;

    /* renamed from: a  reason: collision with root package name */
    public ActionMenuView f2703a;

    /* renamed from: b  reason: collision with root package name */
    public TextView f2704b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f2705c;

    /* renamed from: d  reason: collision with root package name */
    public ImageButton f2706d;

    /* renamed from: e  reason: collision with root package name */
    public ImageView f2707e;

    /* renamed from: f  reason: collision with root package name */
    public Drawable f2708f;

    /* renamed from: g  reason: collision with root package name */
    public CharSequence f2709g;

    /* renamed from: h  reason: collision with root package name */
    public ImageButton f2710h;

    /* renamed from: i  reason: collision with root package name */
    public View f2711i;
    public Context j;
    public int k;
    public int m;
    public int n;
    public int o;
    public int p;
    public int q;
    public int r;
    public int s;
    public int t;
    public b1 u;
    public int v;
    public int w;
    public int x;
    public CharSequence y;
    public CharSequence z;

    /* loaded from: classes.dex */
    public class a implements ActionMenuView.e {
        public a() {
        }

        @Override // android.support.v7.widget.ActionMenuView.e
        public boolean onMenuItemClick(MenuItem menuItem) {
            f fVar = Toolbar.this.H;
            if (fVar != null) {
                return fVar.onMenuItemClick(menuItem);
            }
            return false;
        }
    }

    /* loaded from: classes.dex */
    public class b implements Runnable {
        public b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            Toolbar.this.r();
        }
    }

    /* loaded from: classes.dex */
    public class c implements View.OnClickListener {
        public c() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Toolbar.this.c();
        }
    }

    /* loaded from: classes.dex */
    public interface f {
        boolean onMenuItemClick(MenuItem menuItem);
    }

    public Toolbar(Context context) {
        this(context, null);
    }

    private MenuInflater getMenuInflater() {
        return new a.b.h.j.g(getContext());
    }

    public void a(h hVar, a.b.h.k.c cVar) {
        if (hVar == null && this.f2703a == null) {
            return;
        }
        i();
        h j = this.f2703a.j();
        if (j == hVar) {
            return;
        }
        if (j != null) {
            j.b(this.K);
            j.b(this.L);
        }
        if (this.L == null) {
            this.L = new d();
        }
        cVar.b(true);
        if (hVar != null) {
            hVar.a(cVar, this.j);
            hVar.a(this.L, this.j);
        } else {
            cVar.a(this.j, (h) null);
            this.L.a(this.j, (h) null);
            cVar.a(true);
            this.L.a(true);
        }
        this.f2703a.setPopupTheme(this.k);
        this.f2703a.setPresenter(cVar);
        this.K = cVar;
    }

    public boolean b() {
        ActionMenuView actionMenuView;
        return getVisibility() == 0 && (actionMenuView = this.f2703a) != null && actionMenuView.i();
    }

    public void c() {
        d dVar = this.L;
        k kVar = dVar == null ? null : dVar.f2716b;
        if (kVar != null) {
            kVar.collapseActionView();
        }
    }

    @Override // android.view.ViewGroup
    public boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return super.checkLayoutParams(layoutParams) && (layoutParams instanceof e);
    }

    public void d() {
        ActionMenuView actionMenuView = this.f2703a;
        if (actionMenuView != null) {
            actionMenuView.d();
        }
    }

    public void e() {
        if (this.f2710h == null) {
            this.f2710h = new n(getContext(), null, a.b.h.b.a.toolbarNavigationButtonStyle);
            this.f2710h.setImageDrawable(this.f2708f);
            this.f2710h.setContentDescription(this.f2709g);
            e generateDefaultLayoutParams = generateDefaultLayoutParams();
            generateDefaultLayoutParams.f1271a = 8388611 | (this.o & 112);
            generateDefaultLayoutParams.f2718b = 2;
            this.f2710h.setLayoutParams(generateDefaultLayoutParams);
            this.f2710h.setOnClickListener(new c());
        }
    }

    public final void f() {
        if (this.u == null) {
            this.u = new b1();
        }
    }

    public final void g() {
        if (this.f2707e == null) {
            this.f2707e = new a.b.h.k.p(getContext());
        }
    }

    public int getContentInsetEnd() {
        b1 b1Var = this.u;
        if (b1Var != null) {
            return b1Var.a();
        }
        return 0;
    }

    public int getContentInsetEndWithActions() {
        int i2 = this.w;
        return i2 != Integer.MIN_VALUE ? i2 : getContentInsetEnd();
    }

    public int getContentInsetLeft() {
        b1 b1Var = this.u;
        if (b1Var != null) {
            return b1Var.b();
        }
        return 0;
    }

    public int getContentInsetRight() {
        b1 b1Var = this.u;
        if (b1Var != null) {
            return b1Var.c();
        }
        return 0;
    }

    public int getContentInsetStart() {
        b1 b1Var = this.u;
        if (b1Var != null) {
            return b1Var.d();
        }
        return 0;
    }

    public int getContentInsetStartWithNavigation() {
        int i2 = this.v;
        return i2 != Integer.MIN_VALUE ? i2 : getContentInsetStart();
    }

    public int getCurrentContentInsetEnd() {
        h j;
        ActionMenuView actionMenuView = this.f2703a;
        if ((actionMenuView == null || (j = actionMenuView.j()) == null || !j.hasVisibleItems()) ? false : true) {
            return Math.max(getContentInsetEnd(), Math.max(this.w, 0));
        }
        return getContentInsetEnd();
    }

    public int getCurrentContentInsetLeft() {
        if (u.k(this) == 1) {
            return getCurrentContentInsetEnd();
        }
        return getCurrentContentInsetStart();
    }

    public int getCurrentContentInsetRight() {
        if (u.k(this) == 1) {
            return getCurrentContentInsetStart();
        }
        return getCurrentContentInsetEnd();
    }

    public int getCurrentContentInsetStart() {
        if (getNavigationIcon() != null) {
            return Math.max(getContentInsetStart(), Math.max(this.v, 0));
        }
        return getContentInsetStart();
    }

    public Drawable getLogo() {
        ImageView imageView = this.f2707e;
        if (imageView != null) {
            return imageView.getDrawable();
        }
        return null;
    }

    public CharSequence getLogoDescription() {
        ImageView imageView = this.f2707e;
        if (imageView != null) {
            return imageView.getContentDescription();
        }
        return null;
    }

    public Menu getMenu() {
        h();
        return this.f2703a.getMenu();
    }

    public CharSequence getNavigationContentDescription() {
        ImageButton imageButton = this.f2706d;
        if (imageButton != null) {
            return imageButton.getContentDescription();
        }
        return null;
    }

    public Drawable getNavigationIcon() {
        ImageButton imageButton = this.f2706d;
        if (imageButton != null) {
            return imageButton.getDrawable();
        }
        return null;
    }

    public a.b.h.k.c getOuterActionMenuPresenter() {
        return this.K;
    }

    public Drawable getOverflowIcon() {
        h();
        return this.f2703a.getOverflowIcon();
    }

    public Context getPopupContext() {
        return this.j;
    }

    public int getPopupTheme() {
        return this.k;
    }

    public CharSequence getSubtitle() {
        return this.z;
    }

    public CharSequence getTitle() {
        return this.y;
    }

    public int getTitleMarginBottom() {
        return this.t;
    }

    public int getTitleMarginEnd() {
        return this.r;
    }

    public int getTitleMarginStart() {
        return this.q;
    }

    public int getTitleMarginTop() {
        return this.s;
    }

    public i0 getWrapper() {
        if (this.J == null) {
            this.J = new m1(this, true);
        }
        return this.J;
    }

    public final void h() {
        i();
        if (this.f2703a.j() == null) {
            h hVar = (h) this.f2703a.getMenu();
            if (this.L == null) {
                this.L = new d();
            }
            this.f2703a.setExpandedActionViewsExclusive(true);
            hVar.a(this.L, this.j);
        }
    }

    public final void i() {
        if (this.f2703a == null) {
            this.f2703a = new ActionMenuView(getContext());
            this.f2703a.setPopupTheme(this.k);
            this.f2703a.setOnMenuItemClickListener(this.I);
            this.f2703a.a(this.M, this.N);
            e generateDefaultLayoutParams = generateDefaultLayoutParams();
            generateDefaultLayoutParams.f1271a = 8388613 | (this.o & 112);
            this.f2703a.setLayoutParams(generateDefaultLayoutParams);
            a((View) this.f2703a, false);
        }
    }

    public final void j() {
        if (this.f2706d == null) {
            this.f2706d = new n(getContext(), null, a.b.h.b.a.toolbarNavigationButtonStyle);
            e generateDefaultLayoutParams = generateDefaultLayoutParams();
            generateDefaultLayoutParams.f1271a = 8388611 | (this.o & 112);
            this.f2706d.setLayoutParams(generateDefaultLayoutParams);
        }
    }

    public boolean k() {
        d dVar = this.L;
        return (dVar == null || dVar.f2716b == null) ? false : true;
    }

    public boolean l() {
        ActionMenuView actionMenuView = this.f2703a;
        return actionMenuView != null && actionMenuView.f();
    }

    public boolean m() {
        ActionMenuView actionMenuView = this.f2703a;
        return actionMenuView != null && actionMenuView.g();
    }

    public boolean n() {
        ActionMenuView actionMenuView = this.f2703a;
        return actionMenuView != null && actionMenuView.h();
    }

    public final void o() {
        removeCallbacks(this.P);
        post(this.P);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        removeCallbacks(this.P);
    }

    @Override // android.view.View
    public boolean onHoverEvent(MotionEvent motionEvent) {
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 9) {
            this.D = false;
        }
        if (!this.D) {
            boolean onHoverEvent = super.onHoverEvent(motionEvent);
            if (actionMasked == 9 && !onHoverEvent) {
                this.D = true;
            }
        }
        if (actionMasked == 10 || actionMasked == 3) {
            this.D = false;
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
        To view partially-correct add '--show-bad-code' argument
    */
    public void onLayout(boolean r20, int r21, int r22, int r23, int r24) {
        /*
            Method dump skipped, instructions count: 791
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v7.widget.Toolbar.onLayout(boolean, int, int, int, int):void");
    }

    @Override // android.view.View
    public void onMeasure(int i2, int i3) {
        char c2;
        char c3;
        int i4;
        int i5;
        int i6;
        int i7;
        int i8;
        int i9;
        int i10;
        int[] iArr = this.G;
        if (t1.a(this)) {
            c2 = 1;
            c3 = 0;
        } else {
            c2 = 0;
            c3 = 1;
        }
        if (d(this.f2706d)) {
            a(this.f2706d, i2, 0, i3, 0, this.p);
            i4 = this.f2706d.getMeasuredWidth() + a(this.f2706d);
            i5 = Math.max(0, this.f2706d.getMeasuredHeight() + b(this.f2706d));
            i6 = View.combineMeasuredStates(0, this.f2706d.getMeasuredState());
        } else {
            i4 = 0;
            i5 = 0;
            i6 = 0;
        }
        if (d(this.f2710h)) {
            a(this.f2710h, i2, 0, i3, 0, this.p);
            i4 = this.f2710h.getMeasuredWidth() + a(this.f2710h);
            i5 = Math.max(i5, this.f2710h.getMeasuredHeight() + b(this.f2710h));
            i6 = View.combineMeasuredStates(i6, this.f2710h.getMeasuredState());
        }
        int currentContentInsetStart = getCurrentContentInsetStart();
        int max = 0 + Math.max(currentContentInsetStart, i4);
        iArr[c2] = Math.max(0, currentContentInsetStart - i4);
        if (d(this.f2703a)) {
            a(this.f2703a, i2, max, i3, 0, this.p);
            i7 = this.f2703a.getMeasuredWidth() + a(this.f2703a);
            i5 = Math.max(i5, this.f2703a.getMeasuredHeight() + b(this.f2703a));
            i6 = View.combineMeasuredStates(i6, this.f2703a.getMeasuredState());
        } else {
            i7 = 0;
        }
        int currentContentInsetEnd = getCurrentContentInsetEnd();
        int max2 = max + Math.max(currentContentInsetEnd, i7);
        iArr[c3] = Math.max(0, currentContentInsetEnd - i7);
        if (d(this.f2711i)) {
            max2 += a(this.f2711i, i2, max2, i3, 0, iArr);
            i5 = Math.max(i5, this.f2711i.getMeasuredHeight() + b(this.f2711i));
            i6 = View.combineMeasuredStates(i6, this.f2711i.getMeasuredState());
        }
        if (d(this.f2707e)) {
            max2 += a(this.f2707e, i2, max2, i3, 0, iArr);
            i5 = Math.max(i5, this.f2707e.getMeasuredHeight() + b(this.f2707e));
            i6 = View.combineMeasuredStates(i6, this.f2707e.getMeasuredState());
        }
        int childCount = getChildCount();
        int i11 = i5;
        int i12 = max2;
        for (int i13 = 0; i13 < childCount; i13++) {
            View childAt = getChildAt(i13);
            if (((e) childAt.getLayoutParams()).f2718b == 0 && d(childAt)) {
                i12 += a(childAt, i2, i12, i3, 0, iArr);
                i11 = Math.max(i11, childAt.getMeasuredHeight() + b(childAt));
                i6 = View.combineMeasuredStates(i6, childAt.getMeasuredState());
            }
        }
        int i14 = this.s + this.t;
        int i15 = this.q + this.r;
        if (d(this.f2704b)) {
            a(this.f2704b, i2, i12 + i15, i3, i14, iArr);
            int measuredWidth = this.f2704b.getMeasuredWidth() + a(this.f2704b);
            i10 = this.f2704b.getMeasuredHeight() + b(this.f2704b);
            i8 = View.combineMeasuredStates(i6, this.f2704b.getMeasuredState());
            i9 = measuredWidth;
        } else {
            i8 = i6;
            i9 = 0;
            i10 = 0;
        }
        if (d(this.f2705c)) {
            i9 = Math.max(i9, a(this.f2705c, i2, i12 + i15, i3, i10 + i14, iArr));
            i10 += this.f2705c.getMeasuredHeight() + b(this.f2705c);
            i8 = View.combineMeasuredStates(i8, this.f2705c.getMeasuredState());
        }
        int max3 = Math.max(i11, i10);
        int paddingLeft = i12 + i9 + getPaddingLeft() + getPaddingRight();
        int paddingTop = max3 + getPaddingTop() + getPaddingBottom();
        int resolveSizeAndState = View.resolveSizeAndState(Math.max(paddingLeft, getSuggestedMinimumWidth()), i2, (-16777216) & i8);
        int resolveSizeAndState2 = View.resolveSizeAndState(Math.max(paddingTop, getSuggestedMinimumHeight()), i3, i8 << 16);
        if (q()) {
            resolveSizeAndState2 = 0;
        }
        setMeasuredDimension(resolveSizeAndState, resolveSizeAndState2);
    }

    @Override // android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        MenuItem findItem;
        if (!(parcelable instanceof g)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        g gVar = (g) parcelable;
        super.onRestoreInstanceState(gVar.a());
        ActionMenuView actionMenuView = this.f2703a;
        h j = actionMenuView != null ? actionMenuView.j() : null;
        int i2 = gVar.f2719c;
        if (i2 != 0 && this.L != null && j != null && (findItem = j.findItem(i2)) != null) {
            findItem.expandActionView();
        }
        if (gVar.f2720d) {
            o();
        }
    }

    @Override // android.view.View
    public void onRtlPropertiesChanged(int i2) {
        if (Build.VERSION.SDK_INT >= 17) {
            super.onRtlPropertiesChanged(i2);
        }
        f();
        this.u.a(i2 == 1);
    }

    @Override // android.view.View
    public Parcelable onSaveInstanceState() {
        k kVar;
        g gVar = new g(super.onSaveInstanceState());
        d dVar = this.L;
        if (dVar != null && (kVar = dVar.f2716b) != null) {
            gVar.f2719c = kVar.getItemId();
        }
        gVar.f2720d = n();
        return gVar;
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 0) {
            this.C = false;
        }
        if (!this.C) {
            boolean onTouchEvent = super.onTouchEvent(motionEvent);
            if (actionMasked == 0 && !onTouchEvent) {
                this.C = true;
            }
        }
        if (actionMasked == 1 || actionMasked == 3) {
            this.C = false;
        }
        return true;
    }

    public void p() {
        for (int childCount = getChildCount() - 1; childCount >= 0; childCount--) {
            View childAt = getChildAt(childCount);
            if (((e) childAt.getLayoutParams()).f2718b != 2 && childAt != this.f2703a) {
                removeViewAt(childCount);
                this.F.add(childAt);
            }
        }
    }

    public final boolean q() {
        if (this.O) {
            int childCount = getChildCount();
            for (int i2 = 0; i2 < childCount; i2++) {
                View childAt = getChildAt(i2);
                if (d(childAt) && childAt.getMeasuredWidth() > 0 && childAt.getMeasuredHeight() > 0) {
                    return false;
                }
            }
            return true;
        }
        return false;
    }

    public boolean r() {
        ActionMenuView actionMenuView = this.f2703a;
        return actionMenuView != null && actionMenuView.k();
    }

    public void setCollapsible(boolean z) {
        this.O = z;
        requestLayout();
    }

    public void setContentInsetEndWithActions(int i2) {
        if (i2 < 0) {
            i2 = Integer.MIN_VALUE;
        }
        if (i2 != this.w) {
            this.w = i2;
            if (getNavigationIcon() != null) {
                requestLayout();
            }
        }
    }

    public void setContentInsetStartWithNavigation(int i2) {
        if (i2 < 0) {
            i2 = Integer.MIN_VALUE;
        }
        if (i2 != this.v) {
            this.v = i2;
            if (getNavigationIcon() != null) {
                requestLayout();
            }
        }
    }

    public void setLogo(int i2) {
        setLogo(a.b.h.d.a.a.c(getContext(), i2));
    }

    public void setLogoDescription(int i2) {
        setLogoDescription(getContext().getText(i2));
    }

    public void setNavigationContentDescription(int i2) {
        setNavigationContentDescription(i2 != 0 ? getContext().getText(i2) : null);
    }

    public void setNavigationIcon(int i2) {
        setNavigationIcon(a.b.h.d.a.a.c(getContext(), i2));
    }

    public void setNavigationOnClickListener(View.OnClickListener onClickListener) {
        j();
        this.f2706d.setOnClickListener(onClickListener);
    }

    public void setOnMenuItemClickListener(f fVar) {
        this.H = fVar;
    }

    public void setOverflowIcon(Drawable drawable) {
        h();
        this.f2703a.setOverflowIcon(drawable);
    }

    public void setPopupTheme(int i2) {
        if (this.k != i2) {
            this.k = i2;
            if (i2 == 0) {
                this.j = getContext();
            } else {
                this.j = new ContextThemeWrapper(getContext(), i2);
            }
        }
    }

    public void setSubtitle(int i2) {
        setSubtitle(getContext().getText(i2));
    }

    public void setSubtitleTextColor(int i2) {
        this.B = i2;
        TextView textView = this.f2705c;
        if (textView != null) {
            textView.setTextColor(i2);
        }
    }

    public void setTitle(int i2) {
        setTitle(getContext().getText(i2));
    }

    public void setTitleMarginBottom(int i2) {
        this.t = i2;
        requestLayout();
    }

    public void setTitleMarginEnd(int i2) {
        this.r = i2;
        requestLayout();
    }

    public void setTitleMarginStart(int i2) {
        this.q = i2;
        requestLayout();
    }

    public void setTitleMarginTop(int i2) {
        this.s = i2;
        requestLayout();
    }

    public void setTitleTextColor(int i2) {
        this.A = i2;
        TextView textView = this.f2704b;
        if (textView != null) {
            textView.setTextColor(i2);
        }
    }

    /* loaded from: classes.dex */
    public static class e extends a.C0035a {

        /* renamed from: b  reason: collision with root package name */
        public int f2718b;

        public e(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            this.f2718b = 0;
        }

        public void a(ViewGroup.MarginLayoutParams marginLayoutParams) {
            ((ViewGroup.MarginLayoutParams) this).leftMargin = marginLayoutParams.leftMargin;
            ((ViewGroup.MarginLayoutParams) this).topMargin = marginLayoutParams.topMargin;
            ((ViewGroup.MarginLayoutParams) this).rightMargin = marginLayoutParams.rightMargin;
            ((ViewGroup.MarginLayoutParams) this).bottomMargin = marginLayoutParams.bottomMargin;
        }

        public e(int i2, int i3) {
            super(i2, i3);
            this.f2718b = 0;
            this.f1271a = 8388627;
        }

        public e(e eVar) {
            super((a.C0035a) eVar);
            this.f2718b = 0;
            this.f2718b = eVar.f2718b;
        }

        public e(a.C0035a c0035a) {
            super(c0035a);
            this.f2718b = 0;
        }

        public e(ViewGroup.MarginLayoutParams marginLayoutParams) {
            super(marginLayoutParams);
            this.f2718b = 0;
            a(marginLayoutParams);
        }

        public e(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
            this.f2718b = 0;
        }
    }

    public Toolbar(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, a.b.h.b.a.toolbarStyle);
    }

    public void b(Context context, int i2) {
        this.m = i2;
        TextView textView = this.f2704b;
        if (textView != null) {
            textView.setTextAppearance(context, i2);
        }
    }

    @Override // android.view.ViewGroup
    public e generateDefaultLayoutParams() {
        return new e(-2, -2);
    }

    public void setLogo(Drawable drawable) {
        if (drawable != null) {
            g();
            if (!c(this.f2707e)) {
                a((View) this.f2707e, true);
            }
        } else {
            ImageView imageView = this.f2707e;
            if (imageView != null && c(imageView)) {
                removeView(this.f2707e);
                this.F.remove(this.f2707e);
            }
        }
        ImageView imageView2 = this.f2707e;
        if (imageView2 != null) {
            imageView2.setImageDrawable(drawable);
        }
    }

    public void setLogoDescription(CharSequence charSequence) {
        if (!TextUtils.isEmpty(charSequence)) {
            g();
        }
        ImageView imageView = this.f2707e;
        if (imageView != null) {
            imageView.setContentDescription(charSequence);
        }
    }

    public void setNavigationContentDescription(CharSequence charSequence) {
        if (!TextUtils.isEmpty(charSequence)) {
            j();
        }
        ImageButton imageButton = this.f2706d;
        if (imageButton != null) {
            imageButton.setContentDescription(charSequence);
        }
    }

    public void setNavigationIcon(Drawable drawable) {
        if (drawable != null) {
            j();
            if (!c(this.f2706d)) {
                a((View) this.f2706d, true);
            }
        } else {
            ImageButton imageButton = this.f2706d;
            if (imageButton != null && c(imageButton)) {
                removeView(this.f2706d);
                this.F.remove(this.f2706d);
            }
        }
        ImageButton imageButton2 = this.f2706d;
        if (imageButton2 != null) {
            imageButton2.setImageDrawable(drawable);
        }
    }

    public void setSubtitle(CharSequence charSequence) {
        if (!TextUtils.isEmpty(charSequence)) {
            if (this.f2705c == null) {
                Context context = getContext();
                this.f2705c = new z(context);
                this.f2705c.setSingleLine();
                this.f2705c.setEllipsize(TextUtils.TruncateAt.END);
                int i2 = this.n;
                if (i2 != 0) {
                    this.f2705c.setTextAppearance(context, i2);
                }
                int i3 = this.B;
                if (i3 != 0) {
                    this.f2705c.setTextColor(i3);
                }
            }
            if (!c(this.f2705c)) {
                a((View) this.f2705c, true);
            }
        } else {
            TextView textView = this.f2705c;
            if (textView != null && c(textView)) {
                removeView(this.f2705c);
                this.F.remove(this.f2705c);
            }
        }
        TextView textView2 = this.f2705c;
        if (textView2 != null) {
            textView2.setText(charSequence);
        }
        this.z = charSequence;
    }

    public void setTitle(CharSequence charSequence) {
        if (!TextUtils.isEmpty(charSequence)) {
            if (this.f2704b == null) {
                Context context = getContext();
                this.f2704b = new z(context);
                this.f2704b.setSingleLine();
                this.f2704b.setEllipsize(TextUtils.TruncateAt.END);
                int i2 = this.m;
                if (i2 != 0) {
                    this.f2704b.setTextAppearance(context, i2);
                }
                int i3 = this.A;
                if (i3 != 0) {
                    this.f2704b.setTextColor(i3);
                }
            }
            if (!c(this.f2704b)) {
                a((View) this.f2704b, true);
            }
        } else {
            TextView textView = this.f2704b;
            if (textView != null && c(textView)) {
                removeView(this.f2704b);
                this.F.remove(this.f2704b);
            }
        }
        TextView textView2 = this.f2704b;
        if (textView2 != null) {
            textView2.setText(charSequence);
        }
        this.y = charSequence;
    }

    /* loaded from: classes.dex */
    public class d implements p {

        /* renamed from: a  reason: collision with root package name */
        public h f2715a;

        /* renamed from: b  reason: collision with root package name */
        public k f2716b;

        public d() {
        }

        @Override // a.b.h.j.j.p
        public int a() {
            return 0;
        }

        @Override // a.b.h.j.j.p
        public void a(h hVar, boolean z) {
        }

        @Override // a.b.h.j.j.p
        public void a(Context context, h hVar) {
            k kVar;
            h hVar2 = this.f2715a;
            if (hVar2 != null && (kVar = this.f2716b) != null) {
                hVar2.a(kVar);
            }
            this.f2715a = hVar;
        }

        @Override // a.b.h.j.j.p
        public void a(Parcelable parcelable) {
        }

        @Override // a.b.h.j.j.p
        public boolean a(v vVar) {
            return false;
        }

        @Override // a.b.h.j.j.p
        public boolean b() {
            return false;
        }

        @Override // a.b.h.j.j.p
        public boolean b(h hVar, k kVar) {
            View view = Toolbar.this.f2711i;
            if (view instanceof a.b.h.j.c) {
                ((a.b.h.j.c) view).c();
            }
            Toolbar toolbar = Toolbar.this;
            toolbar.removeView(toolbar.f2711i);
            Toolbar toolbar2 = Toolbar.this;
            toolbar2.removeView(toolbar2.f2710h);
            Toolbar toolbar3 = Toolbar.this;
            toolbar3.f2711i = null;
            toolbar3.a();
            this.f2716b = null;
            Toolbar.this.requestLayout();
            kVar.a(false);
            return true;
        }

        @Override // a.b.h.j.j.p
        public Parcelable c() {
            return null;
        }

        @Override // a.b.h.j.j.p
        public void a(boolean z) {
            if (this.f2716b != null) {
                h hVar = this.f2715a;
                boolean z2 = false;
                if (hVar != null) {
                    int size = hVar.size();
                    int i2 = 0;
                    while (true) {
                        if (i2 >= size) {
                            break;
                        } else if (this.f2715a.getItem(i2) == this.f2716b) {
                            z2 = true;
                            break;
                        } else {
                            i2++;
                        }
                    }
                }
                if (z2) {
                    return;
                }
                b(this.f2715a, this.f2716b);
            }
        }

        @Override // a.b.h.j.j.p
        public boolean a(h hVar, k kVar) {
            Toolbar.this.e();
            ViewParent parent = Toolbar.this.f2710h.getParent();
            Toolbar toolbar = Toolbar.this;
            if (parent != toolbar) {
                if (parent instanceof ViewGroup) {
                    ((ViewGroup) parent).removeView(toolbar.f2710h);
                }
                Toolbar toolbar2 = Toolbar.this;
                toolbar2.addView(toolbar2.f2710h);
            }
            Toolbar.this.f2711i = kVar.getActionView();
            this.f2716b = kVar;
            ViewParent parent2 = Toolbar.this.f2711i.getParent();
            Toolbar toolbar3 = Toolbar.this;
            if (parent2 != toolbar3) {
                if (parent2 instanceof ViewGroup) {
                    ((ViewGroup) parent2).removeView(toolbar3.f2711i);
                }
                e generateDefaultLayoutParams = Toolbar.this.generateDefaultLayoutParams();
                Toolbar toolbar4 = Toolbar.this;
                generateDefaultLayoutParams.f1271a = 8388611 | (toolbar4.o & 112);
                generateDefaultLayoutParams.f2718b = 2;
                toolbar4.f2711i.setLayoutParams(generateDefaultLayoutParams);
                Toolbar toolbar5 = Toolbar.this;
                toolbar5.addView(toolbar5.f2711i);
            }
            Toolbar.this.p();
            Toolbar.this.requestLayout();
            kVar.a(true);
            View view = Toolbar.this.f2711i;
            if (view instanceof a.b.h.j.c) {
                ((a.b.h.j.c) view).b();
            }
            return true;
        }
    }

    /* loaded from: classes.dex */
    public static class g extends a.b.g.k.a {
        public static final Parcelable.Creator<g> CREATOR = new a();

        /* renamed from: c  reason: collision with root package name */
        public int f2719c;

        /* renamed from: d  reason: collision with root package name */
        public boolean f2720d;

        /* loaded from: classes.dex */
        public static class a implements Parcelable.ClassLoaderCreator<g> {
            @Override // android.os.Parcelable.Creator
            public g[] newArray(int i2) {
                return new g[i2];
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.ClassLoaderCreator
            public g createFromParcel(Parcel parcel, ClassLoader classLoader) {
                return new g(parcel, classLoader);
            }

            @Override // android.os.Parcelable.Creator
            public g createFromParcel(Parcel parcel) {
                return new g(parcel, null);
            }
        }

        public g(Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            this.f2719c = parcel.readInt();
            this.f2720d = parcel.readInt() != 0;
        }

        @Override // a.b.g.k.a, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i2) {
            super.writeToParcel(parcel, i2);
            parcel.writeInt(this.f2719c);
            parcel.writeInt(this.f2720d ? 1 : 0);
        }

        public g(Parcelable parcelable) {
            super(parcelable);
        }
    }

    public Toolbar(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.x = 8388627;
        this.E = new ArrayList<>();
        this.F = new ArrayList<>();
        this.G = new int[2];
        this.I = new a();
        this.P = new b();
        l1 a2 = l1.a(getContext(), attributeSet, j.Toolbar, i2, 0);
        this.m = a2.g(j.Toolbar_titleTextAppearance, 0);
        this.n = a2.g(j.Toolbar_subtitleTextAppearance, 0);
        this.x = a2.e(j.Toolbar_android_gravity, this.x);
        this.o = a2.e(j.Toolbar_buttonGravity, 48);
        int b2 = a2.b(j.Toolbar_titleMargin, 0);
        b2 = a2.g(j.Toolbar_titleMargins) ? a2.b(j.Toolbar_titleMargins, b2) : b2;
        this.t = b2;
        this.s = b2;
        this.r = b2;
        this.q = b2;
        int b3 = a2.b(j.Toolbar_titleMarginStart, -1);
        if (b3 >= 0) {
            this.q = b3;
        }
        int b4 = a2.b(j.Toolbar_titleMarginEnd, -1);
        if (b4 >= 0) {
            this.r = b4;
        }
        int b5 = a2.b(j.Toolbar_titleMarginTop, -1);
        if (b5 >= 0) {
            this.s = b5;
        }
        int b6 = a2.b(j.Toolbar_titleMarginBottom, -1);
        if (b6 >= 0) {
            this.t = b6;
        }
        this.p = a2.c(j.Toolbar_maxButtonHeight, -1);
        int b7 = a2.b(j.Toolbar_contentInsetStart, Integer.MIN_VALUE);
        int b8 = a2.b(j.Toolbar_contentInsetEnd, Integer.MIN_VALUE);
        int c2 = a2.c(j.Toolbar_contentInsetLeft, 0);
        int c3 = a2.c(j.Toolbar_contentInsetRight, 0);
        f();
        this.u.a(c2, c3);
        if (b7 != Integer.MIN_VALUE || b8 != Integer.MIN_VALUE) {
            this.u.b(b7, b8);
        }
        this.v = a2.b(j.Toolbar_contentInsetStartWithNavigation, Integer.MIN_VALUE);
        this.w = a2.b(j.Toolbar_contentInsetEndWithActions, Integer.MIN_VALUE);
        this.f2708f = a2.b(j.Toolbar_collapseIcon);
        this.f2709g = a2.e(j.Toolbar_collapseContentDescription);
        CharSequence e2 = a2.e(j.Toolbar_title);
        if (!TextUtils.isEmpty(e2)) {
            setTitle(e2);
        }
        CharSequence e3 = a2.e(j.Toolbar_subtitle);
        if (!TextUtils.isEmpty(e3)) {
            setSubtitle(e3);
        }
        this.j = getContext();
        setPopupTheme(a2.g(j.Toolbar_popupTheme, 0));
        Drawable b9 = a2.b(j.Toolbar_navigationIcon);
        if (b9 != null) {
            setNavigationIcon(b9);
        }
        CharSequence e4 = a2.e(j.Toolbar_navigationContentDescription);
        if (!TextUtils.isEmpty(e4)) {
            setNavigationContentDescription(e4);
        }
        Drawable b10 = a2.b(j.Toolbar_logo);
        if (b10 != null) {
            setLogo(b10);
        }
        CharSequence e5 = a2.e(j.Toolbar_logoDescription);
        if (!TextUtils.isEmpty(e5)) {
            setLogoDescription(e5);
        }
        if (a2.g(j.Toolbar_titleTextColor)) {
            setTitleTextColor(a2.a(j.Toolbar_titleTextColor, -1));
        }
        if (a2.g(j.Toolbar_subtitleTextColor)) {
            setSubtitleTextColor(a2.a(j.Toolbar_subtitleTextColor, -1));
        }
        a2.a();
    }

    public void c(int i2) {
        getMenuInflater().inflate(i2, getMenu());
    }

    public final boolean d(View view) {
        return (view == null || view.getParent() != this || view.getVisibility() == 8) ? false : true;
    }

    @Override // android.view.ViewGroup
    public e generateLayoutParams(AttributeSet attributeSet) {
        return new e(getContext(), attributeSet);
    }

    public final boolean c(View view) {
        return view.getParent() == this || this.F.contains(view);
    }

    @Override // android.view.ViewGroup
    public e generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        if (layoutParams instanceof e) {
            return new e((e) layoutParams);
        }
        if (layoutParams instanceof a.C0035a) {
            return new e((a.C0035a) layoutParams);
        }
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            return new e((ViewGroup.MarginLayoutParams) layoutParams);
        }
        return new e(layoutParams);
    }

    public final int b(View view, int i2, int[] iArr, int i3) {
        e eVar = (e) view.getLayoutParams();
        int i4 = ((ViewGroup.MarginLayoutParams) eVar).rightMargin - iArr[1];
        int max = i2 - Math.max(0, i4);
        iArr[1] = Math.max(0, -i4);
        int a2 = a(view, i3);
        int measuredWidth = view.getMeasuredWidth();
        view.layout(max - measuredWidth, a2, max, view.getMeasuredHeight() + a2);
        return max - (measuredWidth + ((ViewGroup.MarginLayoutParams) eVar).leftMargin);
    }

    public final int b(int i2) {
        int i3 = i2 & 112;
        return (i3 == 16 || i3 == 48 || i3 == 80) ? i3 : this.x & 112;
    }

    public final int b(View view) {
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
        return marginLayoutParams.topMargin + marginLayoutParams.bottomMargin;
    }

    public void a(Context context, int i2) {
        this.n = i2;
        TextView textView = this.f2705c;
        if (textView != null) {
            textView.setTextAppearance(context, i2);
        }
    }

    public void a(int i2, int i3) {
        f();
        this.u.b(i2, i3);
    }

    public final void a(View view, boolean z) {
        e eVar;
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (layoutParams == null) {
            eVar = generateDefaultLayoutParams();
        } else if (!checkLayoutParams(layoutParams)) {
            eVar = generateLayoutParams(layoutParams);
        } else {
            eVar = (e) layoutParams;
        }
        eVar.f2718b = 1;
        if (z && this.f2711i != null) {
            view.setLayoutParams(eVar);
            this.F.add(view);
            return;
        }
        addView(view, eVar);
    }

    public final void a(View view, int i2, int i3, int i4, int i5, int i6) {
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
        int childMeasureSpec = ViewGroup.getChildMeasureSpec(i2, getPaddingLeft() + getPaddingRight() + marginLayoutParams.leftMargin + marginLayoutParams.rightMargin + i3, marginLayoutParams.width);
        int childMeasureSpec2 = ViewGroup.getChildMeasureSpec(i4, getPaddingTop() + getPaddingBottom() + marginLayoutParams.topMargin + marginLayoutParams.bottomMargin + i5, marginLayoutParams.height);
        int mode = View.MeasureSpec.getMode(childMeasureSpec2);
        if (mode != 1073741824 && i6 >= 0) {
            if (mode != 0) {
                i6 = Math.min(View.MeasureSpec.getSize(childMeasureSpec2), i6);
            }
            childMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(i6, 1073741824);
        }
        view.measure(childMeasureSpec, childMeasureSpec2);
    }

    public final int a(View view, int i2, int i3, int i4, int i5, int[] iArr) {
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
        int i6 = marginLayoutParams.leftMargin - iArr[0];
        int i7 = marginLayoutParams.rightMargin - iArr[1];
        int max = Math.max(0, i6) + Math.max(0, i7);
        iArr[0] = Math.max(0, -i6);
        iArr[1] = Math.max(0, -i7);
        view.measure(ViewGroup.getChildMeasureSpec(i2, getPaddingLeft() + getPaddingRight() + max + i3, marginLayoutParams.width), ViewGroup.getChildMeasureSpec(i4, getPaddingTop() + getPaddingBottom() + marginLayoutParams.topMargin + marginLayoutParams.bottomMargin + i5, marginLayoutParams.height));
        return view.getMeasuredWidth() + max;
    }

    public final int a(List<View> list, int[] iArr) {
        int i2 = iArr[0];
        int i3 = iArr[1];
        int size = list.size();
        int i4 = i3;
        int i5 = i2;
        int i6 = 0;
        int i7 = 0;
        while (i6 < size) {
            View view = list.get(i6);
            e eVar = (e) view.getLayoutParams();
            int i8 = ((ViewGroup.MarginLayoutParams) eVar).leftMargin - i5;
            int i9 = ((ViewGroup.MarginLayoutParams) eVar).rightMargin - i4;
            int max = Math.max(0, i8);
            int max2 = Math.max(0, i9);
            int max3 = Math.max(0, -i8);
            int max4 = Math.max(0, -i9);
            i7 += max + view.getMeasuredWidth() + max2;
            i6++;
            i4 = max4;
            i5 = max3;
        }
        return i7;
    }

    public final int a(View view, int i2, int[] iArr, int i3) {
        e eVar = (e) view.getLayoutParams();
        int i4 = ((ViewGroup.MarginLayoutParams) eVar).leftMargin - iArr[0];
        int max = i2 + Math.max(0, i4);
        iArr[0] = Math.max(0, -i4);
        int a2 = a(view, i3);
        int measuredWidth = view.getMeasuredWidth();
        view.layout(max, a2, max + measuredWidth, view.getMeasuredHeight() + a2);
        return max + measuredWidth + ((ViewGroup.MarginLayoutParams) eVar).rightMargin;
    }

    public final int a(View view, int i2) {
        e eVar = (e) view.getLayoutParams();
        int measuredHeight = view.getMeasuredHeight();
        int i3 = i2 > 0 ? (measuredHeight - i2) / 2 : 0;
        int b2 = b(eVar.f1271a);
        if (b2 != 48) {
            if (b2 != 80) {
                int paddingTop = getPaddingTop();
                int paddingBottom = getPaddingBottom();
                int height = getHeight();
                int i4 = (((height - paddingTop) - paddingBottom) - measuredHeight) / 2;
                int i5 = ((ViewGroup.MarginLayoutParams) eVar).topMargin;
                if (i4 < i5) {
                    i4 = i5;
                } else {
                    int i6 = (((height - paddingBottom) - measuredHeight) - i4) - paddingTop;
                    int i7 = ((ViewGroup.MarginLayoutParams) eVar).bottomMargin;
                    if (i6 < i7) {
                        i4 = Math.max(0, i4 - (i7 - i6));
                    }
                }
                return paddingTop + i4;
            }
            return (((getHeight() - getPaddingBottom()) - measuredHeight) - ((ViewGroup.MarginLayoutParams) eVar).bottomMargin) - i3;
        }
        return getPaddingTop() - i3;
    }

    public final void a(List<View> list, int i2) {
        boolean z = u.k(this) == 1;
        int childCount = getChildCount();
        int a2 = a.b.g.k.d.a(i2, u.k(this));
        list.clear();
        if (!z) {
            for (int i3 = 0; i3 < childCount; i3++) {
                View childAt = getChildAt(i3);
                e eVar = (e) childAt.getLayoutParams();
                if (eVar.f2718b == 0 && d(childAt) && a(eVar.f1271a) == a2) {
                    list.add(childAt);
                }
            }
            return;
        }
        for (int i4 = childCount - 1; i4 >= 0; i4--) {
            View childAt2 = getChildAt(i4);
            e eVar2 = (e) childAt2.getLayoutParams();
            if (eVar2.f2718b == 0 && d(childAt2) && a(eVar2.f1271a) == a2) {
                list.add(childAt2);
            }
        }
    }

    public final int a(int i2) {
        int k = u.k(this);
        int a2 = a.b.g.k.d.a(i2, k) & 7;
        return (a2 == 1 || a2 == 3 || a2 == 5) ? a2 : k == 1 ? 5 : 3;
    }

    public final int a(View view) {
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
        return a.b.g.k.g.b(marginLayoutParams) + a.b.g.k.g.a(marginLayoutParams);
    }

    public void a() {
        for (int size = this.F.size() - 1; size >= 0; size--) {
            addView(this.F.get(size));
        }
        this.F.clear();
    }

    public void a(p.a aVar, h.a aVar2) {
        this.M = aVar;
        this.N = aVar2;
        ActionMenuView actionMenuView = this.f2703a;
        if (actionMenuView != null) {
            actionMenuView.a(aVar, aVar2);
        }
    }
}
