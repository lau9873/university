package a.b.d.q;

import a.b.f.o;
import a.b.g.j.j;
import a.b.g.j.l;
import a.b.g.k.u;
import a.b.h.j.j.k;
import a.b.h.j.j.q;
import android.animation.TimeInterpolator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
/* compiled from: BottomNavigationMenuView.java */
/* loaded from: classes.dex */
public class c extends ViewGroup implements q {

    /* renamed from: a  reason: collision with root package name */
    public final a.b.f.q f270a;

    /* renamed from: b  reason: collision with root package name */
    public final int f271b;

    /* renamed from: c  reason: collision with root package name */
    public final int f272c;

    /* renamed from: d  reason: collision with root package name */
    public final int f273d;

    /* renamed from: e  reason: collision with root package name */
    public final int f274e;

    /* renamed from: f  reason: collision with root package name */
    public final int f275f;

    /* renamed from: g  reason: collision with root package name */
    public final View.OnClickListener f276g;

    /* renamed from: h  reason: collision with root package name */
    public final j<a.b.d.q.a> f277h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f278i;
    public int j;
    public a.b.d.q.a[] k;
    public int m;
    public int n;
    public ColorStateList o;
    public int p;
    public ColorStateList q;
    public final ColorStateList r;
    public int s;
    public int t;
    public Drawable u;
    public int v;
    public int[] w;
    public d x;
    public a.b.h.j.j.h y;
    public static final int[] z = {16842912};
    public static final int[] A = {-16842910};

    /* compiled from: BottomNavigationMenuView.java */
    /* loaded from: classes.dex */
    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            k itemData = ((a.b.d.q.a) view).getItemData();
            if (c.this.y.a(itemData, c.this.x, 0)) {
                return;
            }
            itemData.setChecked(true);
        }
    }

    public c(Context context) {
        this(context, null);
    }

    private a.b.d.q.a getNewItem() {
        a.b.d.q.a a2 = this.f277h.a();
        return a2 == null ? new a.b.d.q.a(getContext()) : a2;
    }

    public final boolean a(int i2, int i3) {
        if (i2 == -1) {
            if (i3 > 3) {
                return true;
            }
        } else if (i2 == 0) {
            return true;
        }
        return false;
    }

    public void c() {
        a.b.h.j.j.h hVar = this.y;
        if (hVar == null || this.k == null) {
            return;
        }
        int size = hVar.size();
        if (size != this.k.length) {
            a();
            return;
        }
        int i2 = this.m;
        for (int i3 = 0; i3 < size; i3++) {
            MenuItem item = this.y.getItem(i3);
            if (item.isChecked()) {
                this.m = item.getItemId();
                this.n = i3;
            }
        }
        if (i2 != this.m) {
            o.a(this, this.f270a);
        }
        boolean a2 = a(this.j, this.y.n().size());
        for (int i4 = 0; i4 < size; i4++) {
            this.x.b(true);
            this.k[i4].setLabelVisibilityMode(this.j);
            this.k[i4].setShifting(a2);
            this.k[i4].a((k) this.y.getItem(i4), 0);
            this.x.b(false);
        }
    }

    public ColorStateList getIconTintList() {
        return this.o;
    }

    public Drawable getItemBackground() {
        a.b.d.q.a[] aVarArr = this.k;
        if (aVarArr != null && aVarArr.length > 0) {
            return aVarArr[0].getBackground();
        }
        return this.u;
    }

    @Deprecated
    public int getItemBackgroundRes() {
        return this.v;
    }

    public int getItemIconSize() {
        return this.p;
    }

    public int getItemTextAppearanceActive() {
        return this.t;
    }

    public int getItemTextAppearanceInactive() {
        return this.s;
    }

    public ColorStateList getItemTextColor() {
        return this.q;
    }

    public int getLabelVisibilityMode() {
        return this.j;
    }

    public int getSelectedItemId() {
        return this.m;
    }

    public int getWindowAnimations() {
        return 0;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onLayout(boolean z2, int i2, int i3, int i4, int i5) {
        int childCount = getChildCount();
        int i6 = i4 - i2;
        int i7 = i5 - i3;
        int i8 = 0;
        for (int i9 = 0; i9 < childCount; i9++) {
            View childAt = getChildAt(i9);
            if (childAt.getVisibility() != 8) {
                if (u.k(this) == 1) {
                    int i10 = i6 - i8;
                    childAt.layout(i10 - childAt.getMeasuredWidth(), 0, i10, i7);
                } else {
                    childAt.layout(i8, 0, childAt.getMeasuredWidth() + i8, i7);
                }
                i8 += childAt.getMeasuredWidth();
            }
        }
    }

    @Override // android.view.View
    public void onMeasure(int i2, int i3) {
        int size = View.MeasureSpec.getSize(i2);
        int size2 = this.y.n().size();
        int childCount = getChildCount();
        int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(this.f275f, 1073741824);
        if (a(this.j, size2) && this.f278i) {
            View childAt = getChildAt(this.n);
            int i4 = this.f274e;
            if (childAt.getVisibility() != 8) {
                childAt.measure(View.MeasureSpec.makeMeasureSpec(this.f273d, Integer.MIN_VALUE), makeMeasureSpec);
                i4 = Math.max(i4, childAt.getMeasuredWidth());
            }
            int i5 = size2 - (childAt.getVisibility() != 8 ? 1 : 0);
            int min = Math.min(size - (this.f272c * i5), Math.min(i4, this.f273d));
            int i6 = size - min;
            int min2 = Math.min(i6 / (i5 == 0 ? 1 : i5), this.f271b);
            int i7 = i6 - (i5 * min2);
            int i8 = 0;
            while (i8 < childCount) {
                if (getChildAt(i8).getVisibility() != 8) {
                    this.w[i8] = i8 == this.n ? min : min2;
                    if (i7 > 0) {
                        int[] iArr = this.w;
                        iArr[i8] = iArr[i8] + 1;
                        i7--;
                    }
                } else {
                    this.w[i8] = 0;
                }
                i8++;
            }
        } else {
            int min3 = Math.min(size / (size2 == 0 ? 1 : size2), this.f273d);
            int i9 = size - (size2 * min3);
            for (int i10 = 0; i10 < childCount; i10++) {
                if (getChildAt(i10).getVisibility() != 8) {
                    int[] iArr2 = this.w;
                    iArr2[i10] = min3;
                    if (i9 > 0) {
                        iArr2[i10] = iArr2[i10] + 1;
                        i9--;
                    }
                } else {
                    this.w[i10] = 0;
                }
            }
        }
        int i11 = 0;
        for (int i12 = 0; i12 < childCount; i12++) {
            View childAt2 = getChildAt(i12);
            if (childAt2.getVisibility() != 8) {
                childAt2.measure(View.MeasureSpec.makeMeasureSpec(this.w[i12], 1073741824), makeMeasureSpec);
                childAt2.getLayoutParams().width = childAt2.getMeasuredWidth();
                i11 += childAt2.getMeasuredWidth();
            }
        }
        setMeasuredDimension(View.resolveSizeAndState(i11, View.MeasureSpec.makeMeasureSpec(i11, 1073741824), 0), View.resolveSizeAndState(this.f275f, makeMeasureSpec, 0));
    }

    public void setIconTintList(ColorStateList colorStateList) {
        this.o = colorStateList;
        a.b.d.q.a[] aVarArr = this.k;
        if (aVarArr != null) {
            for (a.b.d.q.a aVar : aVarArr) {
                aVar.setIconTintList(colorStateList);
            }
        }
    }

    public void setItemBackground(Drawable drawable) {
        this.u = drawable;
        a.b.d.q.a[] aVarArr = this.k;
        if (aVarArr != null) {
            for (a.b.d.q.a aVar : aVarArr) {
                aVar.setItemBackground(drawable);
            }
        }
    }

    public void setItemBackgroundRes(int i2) {
        this.v = i2;
        a.b.d.q.a[] aVarArr = this.k;
        if (aVarArr != null) {
            for (a.b.d.q.a aVar : aVarArr) {
                aVar.setItemBackground(i2);
            }
        }
    }

    public void setItemHorizontalTranslationEnabled(boolean z2) {
        this.f278i = z2;
    }

    public void setItemIconSize(int i2) {
        this.p = i2;
        a.b.d.q.a[] aVarArr = this.k;
        if (aVarArr != null) {
            for (a.b.d.q.a aVar : aVarArr) {
                aVar.setIconSize(i2);
            }
        }
    }

    public void setItemTextAppearanceActive(int i2) {
        this.t = i2;
        a.b.d.q.a[] aVarArr = this.k;
        if (aVarArr != null) {
            for (a.b.d.q.a aVar : aVarArr) {
                aVar.setTextAppearanceActive(i2);
                ColorStateList colorStateList = this.q;
                if (colorStateList != null) {
                    aVar.setTextColor(colorStateList);
                }
            }
        }
    }

    public void setItemTextAppearanceInactive(int i2) {
        this.s = i2;
        a.b.d.q.a[] aVarArr = this.k;
        if (aVarArr != null) {
            for (a.b.d.q.a aVar : aVarArr) {
                aVar.setTextAppearanceInactive(i2);
                ColorStateList colorStateList = this.q;
                if (colorStateList != null) {
                    aVar.setTextColor(colorStateList);
                }
            }
        }
    }

    public void setItemTextColor(ColorStateList colorStateList) {
        this.q = colorStateList;
        a.b.d.q.a[] aVarArr = this.k;
        if (aVarArr != null) {
            for (a.b.d.q.a aVar : aVarArr) {
                aVar.setTextColor(colorStateList);
            }
        }
    }

    public void setLabelVisibilityMode(int i2) {
        this.j = i2;
    }

    public void setPresenter(d dVar) {
        this.x = dVar;
    }

    public c(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f277h = new l(5);
        this.m = 0;
        this.n = 0;
        Resources resources = getResources();
        this.f271b = resources.getDimensionPixelSize(a.b.d.d.design_bottom_navigation_item_max_width);
        this.f272c = resources.getDimensionPixelSize(a.b.d.d.design_bottom_navigation_item_min_width);
        this.f273d = resources.getDimensionPixelSize(a.b.d.d.design_bottom_navigation_active_item_max_width);
        this.f274e = resources.getDimensionPixelSize(a.b.d.d.design_bottom_navigation_active_item_min_width);
        this.f275f = resources.getDimensionPixelSize(a.b.d.d.design_bottom_navigation_height);
        this.r = a(16842808);
        this.f270a = new a.b.f.b();
        this.f270a.b(0);
        this.f270a.a(115L);
        this.f270a.a((TimeInterpolator) new a.b.g.k.f0.b());
        this.f270a.a(new f());
        this.f276g = new a();
        this.w = new int[5];
    }

    @Override // a.b.h.j.j.q
    public void a(a.b.h.j.j.h hVar) {
        this.y = hVar;
    }

    public boolean b() {
        return this.f278i;
    }

    public ColorStateList a(int i2) {
        TypedValue typedValue = new TypedValue();
        if (getContext().getTheme().resolveAttribute(i2, typedValue, true)) {
            ColorStateList b2 = a.b.h.d.a.a.b(getContext(), typedValue.resourceId);
            if (getContext().getTheme().resolveAttribute(a.b.h.b.a.colorPrimary, typedValue, true)) {
                int i3 = typedValue.data;
                int defaultColor = b2.getDefaultColor();
                return new ColorStateList(new int[][]{A, z, ViewGroup.EMPTY_STATE_SET}, new int[]{b2.getColorForState(A, defaultColor), i3, defaultColor});
            }
            return null;
        }
        return null;
    }

    public void b(int i2) {
        int size = this.y.size();
        for (int i3 = 0; i3 < size; i3++) {
            MenuItem item = this.y.getItem(i3);
            if (i2 == item.getItemId()) {
                this.m = i2;
                this.n = i3;
                item.setChecked(true);
                return;
            }
        }
    }

    public void a() {
        removeAllViews();
        a.b.d.q.a[] aVarArr = this.k;
        if (aVarArr != null) {
            for (a.b.d.q.a aVar : aVarArr) {
                if (aVar != null) {
                    this.f277h.a(aVar);
                }
            }
        }
        if (this.y.size() == 0) {
            this.m = 0;
            this.n = 0;
            this.k = null;
            return;
        }
        this.k = new a.b.d.q.a[this.y.size()];
        boolean a2 = a(this.j, this.y.n().size());
        for (int i2 = 0; i2 < this.y.size(); i2++) {
            this.x.b(true);
            this.y.getItem(i2).setCheckable(true);
            this.x.b(false);
            a.b.d.q.a newItem = getNewItem();
            this.k[i2] = newItem;
            newItem.setIconTintList(this.o);
            newItem.setIconSize(this.p);
            newItem.setTextColor(this.r);
            newItem.setTextAppearanceInactive(this.s);
            newItem.setTextAppearanceActive(this.t);
            newItem.setTextColor(this.q);
            Drawable drawable = this.u;
            if (drawable != null) {
                newItem.setItemBackground(drawable);
            } else {
                newItem.setItemBackground(this.v);
            }
            newItem.setShifting(a2);
            newItem.setLabelVisibilityMode(this.j);
            newItem.a((k) this.y.getItem(i2), 0);
            newItem.setItemPosition(i2);
            newItem.setOnClickListener(this.f276g);
            addView(newItem);
        }
        this.n = Math.min(this.y.size() - 1, this.n);
        this.y.getItem(this.n).setChecked(true);
    }
}
