package p000a.p006b.p012d.p019q;

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
import p000a.p006b.p012d.C0042d;
import p000a.p006b.p029f.AutoTransition;
import p000a.p006b.p029f.TransitionManager;
import p000a.p006b.p029f.TransitionSet;
import p000a.p006b.p030g.p044j.C0275l;
import p000a.p006b.p030g.p044j.InterfaceC0273j;
import p000a.p006b.p030g.p045k.ViewCompat;
import p000a.p006b.p030g.p045k.p047f0.FastOutSlowInInterpolator;
import p000a.p006b.p049h.p051b.C0354a;
import p000a.p006b.p049h.p053d.p054a.AppCompatResources;
import p000a.p006b.p049h.p061j.p062j.MenuBuilder;
import p000a.p006b.p049h.p061j.p062j.MenuItemImpl;
import p000a.p006b.p049h.p061j.p062j.MenuView;

/* renamed from: a.b.d.q.c */
/* loaded from: classes.dex */
public class BottomNavigationMenuView extends ViewGroup implements MenuView {

    /* renamed from: a */
    public final TransitionSet f503a;

    /* renamed from: b */
    public final int f504b;

    /* renamed from: c */
    public final int f505c;

    /* renamed from: d */
    public final int f506d;

    /* renamed from: e */
    public final int f507e;

    /* renamed from: f */
    public final int f508f;

    /* renamed from: g */
    public final View.OnClickListener f509g;

    /* renamed from: h */
    public final InterfaceC0273j<BottomNavigationItemView> f510h;

    /* renamed from: i */
    public boolean f511i;

    /* renamed from: j */
    public int f512j;

    /* renamed from: k */
    public BottomNavigationItemView[] f513k;

    /* renamed from: m */
    public int f514m;

    /* renamed from: n */
    public int f515n;

    /* renamed from: o */
    public ColorStateList f516o;

    /* renamed from: p */
    public int f517p;

    /* renamed from: q */
    public ColorStateList f518q;

    /* renamed from: r */
    public final ColorStateList f519r;

    /* renamed from: s */
    public int f520s;

    /* renamed from: t */
    public int f521t;

    /* renamed from: u */
    public Drawable f522u;

    /* renamed from: v */
    public int f523v;

    /* renamed from: w */
    public int[] f524w;

    /* renamed from: x */
    public BottomNavigationPresenter f525x;

    /* renamed from: y */
    public MenuBuilder f526y;

    /* renamed from: z */
    public static final int[] f502z = {16842912};

    /* renamed from: A */
    public static final int[] f501A = {-16842910};

    /* compiled from: BottomNavigationMenuView.java */
    /* renamed from: a.b.d.q.c$a */
    /* loaded from: classes.dex */
    public class View$OnClickListenerC0057a implements View.OnClickListener {
        public View$OnClickListenerC0057a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            MenuItemImpl itemData = ((BottomNavigationItemView) view).getItemData();
            if (BottomNavigationMenuView.this.f526y.m8685a(itemData, BottomNavigationMenuView.this.f525x, 0)) {
                return;
            }
            itemData.setChecked(true);
        }
    }

    public BottomNavigationMenuView(Context context) {
        this(context, null);
    }

    private BottomNavigationItemView getNewItem() {
        BottomNavigationItemView mo9624a = this.f510h.mo9624a();
        return mo9624a == null ? new BottomNavigationItemView(getContext()) : mo9624a;
    }

    /* renamed from: a */
    public final boolean m10878a(int i, int i2) {
        if (i == -1) {
            if (i2 > 3) {
                return true;
            }
        } else if (i == 0) {
            return true;
        }
        return false;
    }

    /* renamed from: c */
    public void m10873c() {
        MenuBuilder menuBuilder = this.f526y;
        if (menuBuilder == null || this.f513k == null) {
            return;
        }
        int size = menuBuilder.size();
        if (size != this.f513k.length) {
            m10880a();
            return;
        }
        int i = this.f514m;
        for (int i2 = 0; i2 < size; i2++) {
            MenuItem item = this.f526y.getItem(i2);
            if (item.isChecked()) {
                this.f514m = item.getItemId();
                this.f515n = i2;
            }
        }
        if (i != this.f514m) {
            TransitionManager.m10463a(this, this.f503a);
        }
        boolean m10878a = m10878a(this.f512j, this.f526y.m8652n().size());
        for (int i3 = 0; i3 < size; i3++) {
            this.f525x.m10870b(true);
            this.f513k[i3].setLabelVisibilityMode(this.f512j);
            this.f513k[i3].setShifting(m10878a);
            this.f513k[i3].mo7137a((MenuItemImpl) this.f526y.getItem(i3), 0);
            this.f525x.m10870b(false);
        }
    }

    public ColorStateList getIconTintList() {
        return this.f516o;
    }

    public Drawable getItemBackground() {
        BottomNavigationItemView[] bottomNavigationItemViewArr = this.f513k;
        if (bottomNavigationItemViewArr != null && bottomNavigationItemViewArr.length > 0) {
            return bottomNavigationItemViewArr[0].getBackground();
        }
        return this.f522u;
    }

    @Deprecated
    public int getItemBackgroundRes() {
        return this.f523v;
    }

    public int getItemIconSize() {
        return this.f517p;
    }

    public int getItemTextAppearanceActive() {
        return this.f521t;
    }

    public int getItemTextAppearanceInactive() {
        return this.f520s;
    }

    public ColorStateList getItemTextColor() {
        return this.f518q;
    }

    public int getLabelVisibilityMode() {
        return this.f512j;
    }

    public int getSelectedItemId() {
        return this.f514m;
    }

    public int getWindowAnimations() {
        return 0;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int childCount = getChildCount();
        int i5 = i3 - i;
        int i6 = i4 - i2;
        int i7 = 0;
        for (int i8 = 0; i8 < childCount; i8++) {
            View childAt = getChildAt(i8);
            if (childAt.getVisibility() != 8) {
                if (ViewCompat.m9422k(this) == 1) {
                    int i9 = i5 - i7;
                    childAt.layout(i9 - childAt.getMeasuredWidth(), 0, i9, i6);
                } else {
                    childAt.layout(i7, 0, childAt.getMeasuredWidth() + i7, i6);
                }
                i7 += childAt.getMeasuredWidth();
            }
        }
    }

    @Override // android.view.View
    public void onMeasure(int i, int i2) {
        int size = View.MeasureSpec.getSize(i);
        int size2 = this.f526y.m8652n().size();
        int childCount = getChildCount();
        int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(this.f508f, 1073741824);
        if (m10878a(this.f512j, size2) && this.f511i) {
            View childAt = getChildAt(this.f515n);
            int i3 = this.f507e;
            if (childAt.getVisibility() != 8) {
                childAt.measure(View.MeasureSpec.makeMeasureSpec(this.f506d, Integer.MIN_VALUE), makeMeasureSpec);
                i3 = Math.max(i3, childAt.getMeasuredWidth());
            }
            int i4 = size2 - (childAt.getVisibility() != 8 ? 1 : 0);
            int min = Math.min(size - (this.f505c * i4), Math.min(i3, this.f506d));
            int i5 = size - min;
            int min2 = Math.min(i5 / (i4 == 0 ? 1 : i4), this.f504b);
            int i6 = i5 - (i4 * min2);
            int i7 = 0;
            while (i7 < childCount) {
                if (getChildAt(i7).getVisibility() != 8) {
                    this.f524w[i7] = i7 == this.f515n ? min : min2;
                    if (i6 > 0) {
                        int[] iArr = this.f524w;
                        iArr[i7] = iArr[i7] + 1;
                        i6--;
                    }
                } else {
                    this.f524w[i7] = 0;
                }
                i7++;
            }
        } else {
            int min3 = Math.min(size / (size2 == 0 ? 1 : size2), this.f506d);
            int i8 = size - (size2 * min3);
            for (int i9 = 0; i9 < childCount; i9++) {
                if (getChildAt(i9).getVisibility() != 8) {
                    int[] iArr2 = this.f524w;
                    iArr2[i9] = min3;
                    if (i8 > 0) {
                        iArr2[i9] = iArr2[i9] + 1;
                        i8--;
                    }
                } else {
                    this.f524w[i9] = 0;
                }
            }
        }
        int i10 = 0;
        for (int i11 = 0; i11 < childCount; i11++) {
            View childAt2 = getChildAt(i11);
            if (childAt2.getVisibility() != 8) {
                childAt2.measure(View.MeasureSpec.makeMeasureSpec(this.f524w[i11], 1073741824), makeMeasureSpec);
                childAt2.getLayoutParams().width = childAt2.getMeasuredWidth();
                i10 += childAt2.getMeasuredWidth();
            }
        }
        setMeasuredDimension(View.resolveSizeAndState(i10, View.MeasureSpec.makeMeasureSpec(i10, 1073741824), 0), View.resolveSizeAndState(this.f508f, makeMeasureSpec, 0));
    }

    public void setIconTintList(ColorStateList colorStateList) {
        this.f516o = colorStateList;
        BottomNavigationItemView[] bottomNavigationItemViewArr = this.f513k;
        if (bottomNavigationItemViewArr != null) {
            for (BottomNavigationItemView bottomNavigationItemView : bottomNavigationItemViewArr) {
                bottomNavigationItemView.setIconTintList(colorStateList);
            }
        }
    }

    public void setItemBackground(Drawable drawable) {
        this.f522u = drawable;
        BottomNavigationItemView[] bottomNavigationItemViewArr = this.f513k;
        if (bottomNavigationItemViewArr != null) {
            for (BottomNavigationItemView bottomNavigationItemView : bottomNavigationItemViewArr) {
                bottomNavigationItemView.setItemBackground(drawable);
            }
        }
    }

    public void setItemBackgroundRes(int i) {
        this.f523v = i;
        BottomNavigationItemView[] bottomNavigationItemViewArr = this.f513k;
        if (bottomNavigationItemViewArr != null) {
            for (BottomNavigationItemView bottomNavigationItemView : bottomNavigationItemViewArr) {
                bottomNavigationItemView.setItemBackground(i);
            }
        }
    }

    public void setItemHorizontalTranslationEnabled(boolean z) {
        this.f511i = z;
    }

    public void setItemIconSize(int i) {
        this.f517p = i;
        BottomNavigationItemView[] bottomNavigationItemViewArr = this.f513k;
        if (bottomNavigationItemViewArr != null) {
            for (BottomNavigationItemView bottomNavigationItemView : bottomNavigationItemViewArr) {
                bottomNavigationItemView.setIconSize(i);
            }
        }
    }

    public void setItemTextAppearanceActive(int i) {
        this.f521t = i;
        BottomNavigationItemView[] bottomNavigationItemViewArr = this.f513k;
        if (bottomNavigationItemViewArr != null) {
            for (BottomNavigationItemView bottomNavigationItemView : bottomNavigationItemViewArr) {
                bottomNavigationItemView.setTextAppearanceActive(i);
                ColorStateList colorStateList = this.f518q;
                if (colorStateList != null) {
                    bottomNavigationItemView.setTextColor(colorStateList);
                }
            }
        }
    }

    public void setItemTextAppearanceInactive(int i) {
        this.f520s = i;
        BottomNavigationItemView[] bottomNavigationItemViewArr = this.f513k;
        if (bottomNavigationItemViewArr != null) {
            for (BottomNavigationItemView bottomNavigationItemView : bottomNavigationItemViewArr) {
                bottomNavigationItemView.setTextAppearanceInactive(i);
                ColorStateList colorStateList = this.f518q;
                if (colorStateList != null) {
                    bottomNavigationItemView.setTextColor(colorStateList);
                }
            }
        }
    }

    public void setItemTextColor(ColorStateList colorStateList) {
        this.f518q = colorStateList;
        BottomNavigationItemView[] bottomNavigationItemViewArr = this.f513k;
        if (bottomNavigationItemViewArr != null) {
            for (BottomNavigationItemView bottomNavigationItemView : bottomNavigationItemViewArr) {
                bottomNavigationItemView.setTextColor(colorStateList);
            }
        }
    }

    public void setLabelVisibilityMode(int i) {
        this.f512j = i;
    }

    public void setPresenter(BottomNavigationPresenter bottomNavigationPresenter) {
        this.f525x = bottomNavigationPresenter;
    }

    public BottomNavigationMenuView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f510h = new C0275l(5);
        this.f514m = 0;
        this.f515n = 0;
        Resources resources = getResources();
        this.f504b = resources.getDimensionPixelSize(C0042d.design_bottom_navigation_item_max_width);
        this.f505c = resources.getDimensionPixelSize(C0042d.design_bottom_navigation_item_min_width);
        this.f506d = resources.getDimensionPixelSize(C0042d.design_bottom_navigation_active_item_max_width);
        this.f507e = resources.getDimensionPixelSize(C0042d.design_bottom_navigation_active_item_min_width);
        this.f508f = resources.getDimensionPixelSize(C0042d.design_bottom_navigation_height);
        this.f519r = m10879a(16842808);
        this.f503a = new AutoTransition();
        this.f503a.m10444b(0);
        this.f503a.mo10455a(115L);
        this.f503a.mo10448a((TimeInterpolator) new FastOutSlowInInterpolator());
        this.f503a.m10451a(new TextScale());
        this.f509g = new View$OnClickListenerC0057a();
        this.f524w = new int[5];
    }

    @Override // p000a.p006b.p049h.p061j.p062j.MenuView
    /* renamed from: a */
    public void mo7096a(MenuBuilder menuBuilder) {
        this.f526y = menuBuilder;
    }

    /* renamed from: b */
    public boolean m10876b() {
        return this.f511i;
    }

    /* renamed from: a */
    public ColorStateList m10879a(int i) {
        TypedValue typedValue = new TypedValue();
        if (getContext().getTheme().resolveAttribute(i, typedValue, true)) {
            ColorStateList m8968b = AppCompatResources.m8968b(getContext(), typedValue.resourceId);
            if (getContext().getTheme().resolveAttribute(C0354a.colorPrimary, typedValue, true)) {
                int i2 = typedValue.data;
                int defaultColor = m8968b.getDefaultColor();
                return new ColorStateList(new int[][]{f501A, f502z, ViewGroup.EMPTY_STATE_SET}, new int[]{m8968b.getColorForState(f501A, defaultColor), i2, defaultColor});
            }
            return null;
        }
        return null;
    }

    /* renamed from: b */
    public void m10875b(int i) {
        int size = this.f526y.size();
        for (int i2 = 0; i2 < size; i2++) {
            MenuItem item = this.f526y.getItem(i2);
            if (i == item.getItemId()) {
                this.f514m = i;
                this.f515n = i2;
                item.setChecked(true);
                return;
            }
        }
    }

    /* renamed from: a */
    public void m10880a() {
        removeAllViews();
        BottomNavigationItemView[] bottomNavigationItemViewArr = this.f513k;
        if (bottomNavigationItemViewArr != null) {
            for (BottomNavigationItemView bottomNavigationItemView : bottomNavigationItemViewArr) {
                if (bottomNavigationItemView != null) {
                    this.f510h.mo9623a(bottomNavigationItemView);
                }
            }
        }
        if (this.f526y.size() == 0) {
            this.f514m = 0;
            this.f515n = 0;
            this.f513k = null;
            return;
        }
        this.f513k = new BottomNavigationItemView[this.f526y.size()];
        boolean m10878a = m10878a(this.f512j, this.f526y.m8652n().size());
        for (int i = 0; i < this.f526y.size(); i++) {
            this.f525x.m10870b(true);
            this.f526y.getItem(i).setCheckable(true);
            this.f525x.m10870b(false);
            BottomNavigationItemView newItem = getNewItem();
            this.f513k[i] = newItem;
            newItem.setIconTintList(this.f516o);
            newItem.setIconSize(this.f517p);
            newItem.setTextColor(this.f519r);
            newItem.setTextAppearanceInactive(this.f520s);
            newItem.setTextAppearanceActive(this.f521t);
            newItem.setTextColor(this.f518q);
            Drawable drawable = this.f522u;
            if (drawable != null) {
                newItem.setItemBackground(drawable);
            } else {
                newItem.setItemBackground(this.f523v);
            }
            newItem.setShifting(m10878a);
            newItem.setLabelVisibilityMode(this.f512j);
            newItem.mo7137a((MenuItemImpl) this.f526y.getItem(i), 0);
            newItem.setItemPosition(i);
            newItem.setOnClickListener(this.f509g);
            addView(newItem);
        }
        this.f515n = Math.min(this.f526y.size() - 1, this.f515n);
        this.f526y.getItem(this.f515n).setChecked(true);
    }
}
