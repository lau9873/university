package android.support.design.internal;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.CheckedTextView;
import android.widget.FrameLayout;
import p000a.p006b.p012d.C0042d;
import p000a.p006b.p012d.C0043e;
import p000a.p006b.p012d.C0044f;
import p000a.p006b.p012d.C0046h;
import p000a.p006b.p012d.p019q.ForegroundLinearLayout;
import p000a.p006b.p030g.p032b.p033g.ResourcesCompat;
import p000a.p006b.p030g.p034c.p035j.DrawableCompat;
import p000a.p006b.p030g.p045k.AccessibilityDelegateCompat;
import p000a.p006b.p030g.p045k.ViewCompat;
import p000a.p006b.p030g.p045k.p046e0.AccessibilityNodeInfoCompat;
import p000a.p006b.p030g.p048l.TextViewCompat;
import p000a.p006b.p049h.p051b.C0354a;
import p000a.p006b.p049h.p061j.p062j.MenuItemImpl;
import p000a.p006b.p049h.p061j.p062j.MenuView;
import p000a.p006b.p049h.p063k.LinearLayoutCompat;
import p000a.p006b.p049h.p063k.TooltipCompat;

/* loaded from: classes.dex */
public class NavigationMenuItemView extends ForegroundLinearLayout implements MenuView.InterfaceC0435a {

    /* renamed from: G */
    public static final int[] f3160G = {16842912};

    /* renamed from: A */
    public FrameLayout f3161A;

    /* renamed from: B */
    public MenuItemImpl f3162B;

    /* renamed from: C */
    public ColorStateList f3163C;

    /* renamed from: D */
    public boolean f3164D;

    /* renamed from: E */
    public Drawable f3165E;

    /* renamed from: F */
    public final AccessibilityDelegateCompat f3166F;

    /* renamed from: w */
    public final int f3167w;

    /* renamed from: x */
    public boolean f3168x;

    /* renamed from: y */
    public boolean f3169y;

    /* renamed from: z */
    public final CheckedTextView f3170z;

    /* renamed from: android.support.design.internal.NavigationMenuItemView$a */
    /* loaded from: classes.dex */
    public class C0528a extends AccessibilityDelegateCompat {
        public C0528a() {
        }

        @Override // p000a.p006b.p030g.p045k.AccessibilityDelegateCompat
        /* renamed from: a */
        public void mo7332a(View view, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
            super.mo7332a(view, accessibilityNodeInfoCompat);
            accessibilityNodeInfoCompat.m9552a(NavigationMenuItemView.this.f3169y);
        }
    }

    public NavigationMenuItemView(Context context) {
        this(context, null);
    }

    private void setActionView(View view) {
        if (view != null) {
            if (this.f3161A == null) {
                this.f3161A = (FrameLayout) ((ViewStub) findViewById(C0044f.design_menu_item_action_area_stub)).inflate();
            }
            this.f3161A.removeAllViews();
            this.f3161A.addView(view);
        }
    }

    @Override // p000a.p006b.p049h.p061j.p062j.MenuView.InterfaceC0435a
    /* renamed from: a */
    public void mo7137a(MenuItemImpl menuItemImpl, int i) {
        this.f3162B = menuItemImpl;
        setVisibility(menuItemImpl.isVisible() ? 0 : 8);
        if (getBackground() == null) {
            ViewCompat.m9447a(this, m7888e());
        }
        setCheckable(menuItemImpl.isCheckable());
        setChecked(menuItemImpl.isChecked());
        setEnabled(menuItemImpl.isEnabled());
        setTitle(menuItemImpl.getTitle());
        setIcon(menuItemImpl.getIcon());
        setActionView(menuItemImpl.getActionView());
        setContentDescription(menuItemImpl.getContentDescription());
        TooltipCompat.m8181a(this, menuItemImpl.getTooltipText());
        m7889d();
    }

    @Override // p000a.p006b.p049h.p061j.p062j.MenuView.InterfaceC0435a
    /* renamed from: a */
    public boolean mo7138a() {
        return false;
    }

    /* renamed from: d */
    public final void m7889d() {
        if (m7887f()) {
            this.f3170z.setVisibility(8);
            FrameLayout frameLayout = this.f3161A;
            if (frameLayout != null) {
                LinearLayoutCompat.C0492a c0492a = (LinearLayoutCompat.C0492a) frameLayout.getLayoutParams();
                ((ViewGroup.MarginLayoutParams) c0492a).width = -1;
                this.f3161A.setLayoutParams(c0492a);
                return;
            }
            return;
        }
        this.f3170z.setVisibility(0);
        FrameLayout frameLayout2 = this.f3161A;
        if (frameLayout2 != null) {
            LinearLayoutCompat.C0492a c0492a2 = (LinearLayoutCompat.C0492a) frameLayout2.getLayoutParams();
            ((ViewGroup.MarginLayoutParams) c0492a2).width = -2;
            this.f3161A.setLayoutParams(c0492a2);
        }
    }

    /* renamed from: e */
    public final StateListDrawable m7888e() {
        TypedValue typedValue = new TypedValue();
        if (getContext().getTheme().resolveAttribute(C0354a.colorControlHighlight, typedValue, true)) {
            StateListDrawable stateListDrawable = new StateListDrawable();
            stateListDrawable.addState(f3160G, new ColorDrawable(typedValue.data));
            stateListDrawable.addState(ViewGroup.EMPTY_STATE_SET, new ColorDrawable(0));
            return stateListDrawable;
        }
        return null;
    }

    /* renamed from: f */
    public final boolean m7887f() {
        return this.f3162B.getTitle() == null && this.f3162B.getIcon() == null && this.f3162B.getActionView() != null;
    }

    @Override // p000a.p006b.p049h.p061j.p062j.MenuView.InterfaceC0435a
    public MenuItemImpl getItemData() {
        return this.f3162B;
    }

    @Override // android.view.ViewGroup, android.view.View
    public int[] onCreateDrawableState(int i) {
        int[] onCreateDrawableState = super.onCreateDrawableState(i + 1);
        MenuItemImpl menuItemImpl = this.f3162B;
        if (menuItemImpl != null && menuItemImpl.isCheckable() && this.f3162B.isChecked()) {
            ViewGroup.mergeDrawableStates(onCreateDrawableState, f3160G);
        }
        return onCreateDrawableState;
    }

    public void setCheckable(boolean z) {
        refreshDrawableState();
        if (this.f3169y != z) {
            this.f3169y = z;
            this.f3166F.m9585a(this.f3170z, 2048);
        }
    }

    public void setChecked(boolean z) {
        refreshDrawableState();
        this.f3170z.setChecked(z);
    }

    public void setHorizontalPadding(int i) {
        setPadding(i, 0, i, 0);
    }

    public void setIcon(Drawable drawable) {
        if (drawable != null) {
            if (this.f3164D) {
                Drawable.ConstantState constantState = drawable.getConstantState();
                if (constantState != null) {
                    drawable = constantState.newDrawable();
                }
                drawable = DrawableCompat.m9848i(drawable).mutate();
                DrawableCompat.m9861a(drawable, this.f3163C);
            }
            int i = this.f3167w;
            drawable.setBounds(0, 0, i, i);
        } else if (this.f3168x) {
            if (this.f3165E == null) {
                this.f3165E = ResourcesCompat.m9949a(getResources(), C0043e.navigation_empty_icon, getContext().getTheme());
                Drawable drawable2 = this.f3165E;
                if (drawable2 != null) {
                    int i2 = this.f3167w;
                    drawable2.setBounds(0, 0, i2, i2);
                }
            }
            drawable = this.f3165E;
        }
        TextViewCompat.m9212a(this.f3170z, drawable, null, null, null);
    }

    public void setIconPadding(int i) {
        this.f3170z.setCompoundDrawablePadding(i);
    }

    public void setIconTintList(ColorStateList colorStateList) {
        this.f3163C = colorStateList;
        this.f3164D = this.f3163C != null;
        MenuItemImpl menuItemImpl = this.f3162B;
        if (menuItemImpl != null) {
            setIcon(menuItemImpl.getIcon());
        }
    }

    public void setNeedsEmptyIcon(boolean z) {
        this.f3168x = z;
    }

    public void setTextAppearance(int i) {
        TextViewCompat.m9205d(this.f3170z, i);
    }

    public void setTextColor(ColorStateList colorStateList) {
        this.f3170z.setTextColor(colorStateList);
    }

    public void setTitle(CharSequence charSequence) {
        this.f3170z.setText(charSequence);
    }

    public NavigationMenuItemView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public NavigationMenuItemView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f3166F = new C0528a();
        setOrientation(0);
        LayoutInflater.from(context).inflate(C0046h.design_navigation_menu_item, (ViewGroup) this, true);
        this.f3167w = context.getResources().getDimensionPixelSize(C0042d.design_navigation_icon_size);
        this.f3170z = (CheckedTextView) findViewById(C0044f.design_menu_item_text);
        this.f3170z.setDuplicateParentStateEnabled(true);
        ViewCompat.m9454a(this.f3170z, this.f3166F);
    }
}
