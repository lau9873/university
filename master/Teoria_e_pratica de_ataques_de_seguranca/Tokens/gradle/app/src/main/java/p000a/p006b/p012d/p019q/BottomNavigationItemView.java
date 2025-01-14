package p000a.p006b.p012d.p019q;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import p000a.p006b.p012d.C0042d;
import p000a.p006b.p012d.C0043e;
import p000a.p006b.p012d.C0044f;
import p000a.p006b.p012d.C0046h;
import p000a.p006b.p030g.p032b.ContextCompat;
import p000a.p006b.p030g.p034c.p035j.DrawableCompat;
import p000a.p006b.p030g.p045k.PointerIconCompat;
import p000a.p006b.p030g.p045k.ViewCompat;
import p000a.p006b.p030g.p048l.TextViewCompat;
import p000a.p006b.p049h.p061j.p062j.MenuItemImpl;
import p000a.p006b.p049h.p061j.p062j.MenuView;
import p000a.p006b.p049h.p063k.TooltipCompat;

/* renamed from: a.b.d.q.a */
/* loaded from: classes.dex */
public class BottomNavigationItemView extends FrameLayout implements MenuView.InterfaceC0435a {

    /* renamed from: n */
    public static final int[] f488n = {16842912};

    /* renamed from: a */
    public final int f489a;

    /* renamed from: b */
    public float f490b;

    /* renamed from: c */
    public float f491c;

    /* renamed from: d */
    public float f492d;

    /* renamed from: e */
    public int f493e;

    /* renamed from: f */
    public boolean f494f;

    /* renamed from: g */
    public ImageView f495g;

    /* renamed from: h */
    public final TextView f496h;

    /* renamed from: i */
    public final TextView f497i;

    /* renamed from: j */
    public int f498j;

    /* renamed from: k */
    public MenuItemImpl f499k;

    /* renamed from: m */
    public ColorStateList f500m;

    public BottomNavigationItemView(Context context) {
        this(context, null);
    }

    @Override // p000a.p006b.p049h.p061j.p062j.MenuView.InterfaceC0435a
    /* renamed from: a */
    public void mo7137a(MenuItemImpl menuItemImpl, int i) {
        this.f499k = menuItemImpl;
        setCheckable(menuItemImpl.isCheckable());
        setChecked(menuItemImpl.isChecked());
        setEnabled(menuItemImpl.isEnabled());
        setIcon(menuItemImpl.getIcon());
        setTitle(menuItemImpl.getTitle());
        setId(menuItemImpl.getItemId());
        if (!TextUtils.isEmpty(menuItemImpl.getContentDescription())) {
            setContentDescription(menuItemImpl.getContentDescription());
        }
        TooltipCompat.m8181a(this, menuItemImpl.getTooltipText());
        setVisibility(menuItemImpl.isVisible() ? 0 : 8);
    }

    @Override // p000a.p006b.p049h.p061j.p062j.MenuView.InterfaceC0435a
    /* renamed from: a */
    public boolean mo7138a() {
        return false;
    }

    @Override // p000a.p006b.p049h.p061j.p062j.MenuView.InterfaceC0435a
    public MenuItemImpl getItemData() {
        return this.f499k;
    }

    public int getItemPosition() {
        return this.f498j;
    }

    @Override // android.view.ViewGroup, android.view.View
    public int[] onCreateDrawableState(int i) {
        int[] onCreateDrawableState = super.onCreateDrawableState(i + 1);
        MenuItemImpl menuItemImpl = this.f499k;
        if (menuItemImpl != null && menuItemImpl.isCheckable() && this.f499k.isChecked()) {
            FrameLayout.mergeDrawableStates(onCreateDrawableState, f488n);
        }
        return onCreateDrawableState;
    }

    public void setCheckable(boolean z) {
        refreshDrawableState();
    }

    public void setChecked(boolean z) {
        TextView textView = this.f497i;
        textView.setPivotX(textView.getWidth() / 2);
        TextView textView2 = this.f497i;
        textView2.setPivotY(textView2.getBaseline());
        TextView textView3 = this.f496h;
        textView3.setPivotX(textView3.getWidth() / 2);
        TextView textView4 = this.f496h;
        textView4.setPivotY(textView4.getBaseline());
        int i = this.f493e;
        if (i != -1) {
            if (i == 0) {
                if (z) {
                    m10881a(this.f495g, this.f489a, 49);
                    m10882a(this.f497i, 1.0f, 1.0f, 0);
                } else {
                    m10881a(this.f495g, this.f489a, 17);
                    m10882a(this.f497i, 0.5f, 0.5f, 4);
                }
                this.f496h.setVisibility(4);
            } else if (i != 1) {
                if (i == 2) {
                    m10881a(this.f495g, this.f489a, 17);
                    this.f497i.setVisibility(8);
                    this.f496h.setVisibility(8);
                }
            } else if (z) {
                m10881a(this.f495g, (int) (this.f489a + this.f490b), 49);
                m10882a(this.f497i, 1.0f, 1.0f, 0);
                TextView textView5 = this.f496h;
                float f = this.f491c;
                m10882a(textView5, f, f, 4);
            } else {
                m10881a(this.f495g, this.f489a, 49);
                TextView textView6 = this.f497i;
                float f2 = this.f492d;
                m10882a(textView6, f2, f2, 4);
                m10882a(this.f496h, 1.0f, 1.0f, 0);
            }
        } else if (this.f494f) {
            if (z) {
                m10881a(this.f495g, this.f489a, 49);
                m10882a(this.f497i, 1.0f, 1.0f, 0);
            } else {
                m10881a(this.f495g, this.f489a, 17);
                m10882a(this.f497i, 0.5f, 0.5f, 4);
            }
            this.f496h.setVisibility(4);
        } else if (z) {
            m10881a(this.f495g, (int) (this.f489a + this.f490b), 49);
            m10882a(this.f497i, 1.0f, 1.0f, 0);
            TextView textView7 = this.f496h;
            float f3 = this.f491c;
            m10882a(textView7, f3, f3, 4);
        } else {
            m10881a(this.f495g, this.f489a, 49);
            TextView textView8 = this.f497i;
            float f4 = this.f492d;
            m10882a(textView8, f4, f4, 4);
            m10882a(this.f496h, 1.0f, 1.0f, 0);
        }
        refreshDrawableState();
        setSelected(z);
    }

    @Override // android.view.View
    public void setEnabled(boolean z) {
        super.setEnabled(z);
        this.f496h.setEnabled(z);
        this.f497i.setEnabled(z);
        this.f495g.setEnabled(z);
        if (z) {
            ViewCompat.m9451a(this, PointerIconCompat.m9465a(getContext(), 1002));
        } else {
            ViewCompat.m9451a(this, (PointerIconCompat) null);
        }
    }

    public void setIcon(Drawable drawable) {
        if (drawable != null) {
            Drawable.ConstantState constantState = drawable.getConstantState();
            if (constantState != null) {
                drawable = constantState.newDrawable();
            }
            drawable = DrawableCompat.m9848i(drawable).mutate();
            DrawableCompat.m9861a(drawable, this.f500m);
        }
        this.f495g.setImageDrawable(drawable);
    }

    public void setIconSize(int i) {
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.f495g.getLayoutParams();
        layoutParams.width = i;
        layoutParams.height = i;
        this.f495g.setLayoutParams(layoutParams);
    }

    public void setIconTintList(ColorStateList colorStateList) {
        this.f500m = colorStateList;
        MenuItemImpl menuItemImpl = this.f499k;
        if (menuItemImpl != null) {
            setIcon(menuItemImpl.getIcon());
        }
    }

    public void setItemBackground(int i) {
        setItemBackground(i == 0 ? null : ContextCompat.m10016c(getContext(), i));
    }

    public void setItemPosition(int i) {
        this.f498j = i;
    }

    public void setLabelVisibilityMode(int i) {
        if (this.f493e != i) {
            this.f493e = i;
            if (this.f499k != null) {
                setChecked(this.f499k.isChecked());
            }
        }
    }

    public void setShifting(boolean z) {
        if (this.f494f != z) {
            this.f494f = z;
            if (this.f499k != null) {
                setChecked(this.f499k.isChecked());
            }
        }
    }

    public void setTextAppearanceActive(int i) {
        TextViewCompat.m9205d(this.f497i, i);
        m10883a(this.f496h.getTextSize(), this.f497i.getTextSize());
    }

    public void setTextAppearanceInactive(int i) {
        TextViewCompat.m9205d(this.f496h, i);
        m10883a(this.f496h.getTextSize(), this.f497i.getTextSize());
    }

    public void setTextColor(ColorStateList colorStateList) {
        if (colorStateList != null) {
            this.f496h.setTextColor(colorStateList);
            this.f497i.setTextColor(colorStateList);
        }
    }

    public void setTitle(CharSequence charSequence) {
        this.f496h.setText(charSequence);
        this.f497i.setText(charSequence);
        MenuItemImpl menuItemImpl = this.f499k;
        if (menuItemImpl == null || TextUtils.isEmpty(menuItemImpl.getContentDescription())) {
            setContentDescription(charSequence);
        }
    }

    public BottomNavigationItemView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public BottomNavigationItemView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f498j = -1;
        Resources resources = getResources();
        LayoutInflater.from(context).inflate(C0046h.design_bottom_navigation_item, (ViewGroup) this, true);
        setBackgroundResource(C0043e.design_bottom_navigation_item_background);
        this.f489a = resources.getDimensionPixelSize(C0042d.design_bottom_navigation_margin);
        this.f495g = (ImageView) findViewById(C0044f.icon);
        this.f496h = (TextView) findViewById(C0044f.smallLabel);
        this.f497i = (TextView) findViewById(C0044f.largeLabel);
        ViewCompat.m9429f(this.f496h, 2);
        ViewCompat.m9429f(this.f497i, 2);
        setFocusable(true);
        m10883a(this.f496h.getTextSize(), this.f497i.getTextSize());
    }

    public void setItemBackground(Drawable drawable) {
        ViewCompat.m9447a(this, drawable);
    }

    /* renamed from: a */
    public final void m10881a(View view, int i, int i2) {
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) view.getLayoutParams();
        layoutParams.topMargin = i;
        layoutParams.gravity = i2;
        view.setLayoutParams(layoutParams);
    }

    /* renamed from: a */
    public final void m10882a(View view, float f, float f2, int i) {
        view.setScaleX(f);
        view.setScaleY(f2);
        view.setVisibility(i);
    }

    /* renamed from: a */
    public final void m10883a(float f, float f2) {
        this.f490b = f - f2;
        this.f491c = (f2 * 1.0f) / f;
        this.f492d = (f * 1.0f) / f2;
    }
}
