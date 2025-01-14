package android.support.p067v7.view.menu;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.TextView;
import p000a.p006b.p030g.p045k.ViewCompat;
import p000a.p006b.p049h.p051b.C0354a;
import p000a.p006b.p049h.p051b.C0359f;
import p000a.p006b.p049h.p051b.C0360g;
import p000a.p006b.p049h.p051b.C0363j;
import p000a.p006b.p049h.p061j.p062j.MenuItemImpl;
import p000a.p006b.p049h.p061j.p062j.MenuView;
import p000a.p006b.p049h.p063k.TintTypedArray;

/* renamed from: android.support.v7.view.menu.ListMenuItemView */
/* loaded from: classes.dex */
public class ListMenuItemView extends LinearLayout implements MenuView.InterfaceC0435a, AbsListView.SelectionBoundsAdjuster {

    /* renamed from: a */
    public MenuItemImpl f3936a;

    /* renamed from: b */
    public ImageView f3937b;

    /* renamed from: c */
    public RadioButton f3938c;

    /* renamed from: d */
    public TextView f3939d;

    /* renamed from: e */
    public CheckBox f3940e;

    /* renamed from: f */
    public TextView f3941f;

    /* renamed from: g */
    public ImageView f3942g;

    /* renamed from: h */
    public ImageView f3943h;

    /* renamed from: i */
    public LinearLayout f3944i;

    /* renamed from: j */
    public Drawable f3945j;

    /* renamed from: k */
    public int f3946k;

    /* renamed from: m */
    public Context f3947m;

    /* renamed from: n */
    public boolean f3948n;

    /* renamed from: o */
    public Drawable f3949o;

    /* renamed from: p */
    public boolean f3950p;

    /* renamed from: q */
    public LayoutInflater f3951q;

    /* renamed from: r */
    public boolean f3952r;

    public ListMenuItemView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, C0354a.listMenuViewStyle);
    }

    private LayoutInflater getInflater() {
        if (this.f3951q == null) {
            this.f3951q = LayoutInflater.from(getContext());
        }
        return this.f3951q;
    }

    private void setSubMenuArrowVisible(boolean z) {
        ImageView imageView = this.f3942g;
        if (imageView != null) {
            imageView.setVisibility(z ? 0 : 8);
        }
    }

    @Override // p000a.p006b.p049h.p061j.p062j.MenuView.InterfaceC0435a
    /* renamed from: a */
    public void mo7137a(MenuItemImpl menuItemImpl, int i) {
        this.f3936a = menuItemImpl;
        setVisibility(menuItemImpl.isVisible() ? 0 : 8);
        setTitle(menuItemImpl.m8645a(this));
        setCheckable(menuItemImpl.isCheckable());
        m7134a(menuItemImpl.m8624m(), menuItemImpl.m8635d());
        setIcon(menuItemImpl.getIcon());
        setEnabled(menuItemImpl.isEnabled());
        setSubMenuArrowVisible(menuItemImpl.hasSubMenu());
        setContentDescription(menuItemImpl.getContentDescription());
    }

    @Override // p000a.p006b.p049h.p061j.p062j.MenuView.InterfaceC0435a
    /* renamed from: a */
    public boolean mo7138a() {
        return false;
    }

    @Override // android.widget.AbsListView.SelectionBoundsAdjuster
    public void adjustListItemSelectionBounds(Rect rect) {
        ImageView imageView = this.f3943h;
        if (imageView == null || imageView.getVisibility() != 0) {
            return;
        }
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.f3943h.getLayoutParams();
        rect.top += this.f3943h.getHeight() + layoutParams.topMargin + layoutParams.bottomMargin;
    }

    /* renamed from: b */
    public final void m7133b() {
        this.f3940e = (CheckBox) getInflater().inflate(C0360g.abc_list_menu_item_checkbox, (ViewGroup) this, false);
        m7136a(this.f3940e);
    }

    /* renamed from: c */
    public final void m7132c() {
        this.f3937b = (ImageView) getInflater().inflate(C0360g.abc_list_menu_item_icon, (ViewGroup) this, false);
        m7135a(this.f3937b, 0);
    }

    /* renamed from: d */
    public final void m7131d() {
        this.f3938c = (RadioButton) getInflater().inflate(C0360g.abc_list_menu_item_radio, (ViewGroup) this, false);
        m7136a(this.f3938c);
    }

    @Override // p000a.p006b.p049h.p061j.p062j.MenuView.InterfaceC0435a
    public MenuItemImpl getItemData() {
        return this.f3936a;
    }

    @Override // android.view.View
    public void onFinishInflate() {
        super.onFinishInflate();
        ViewCompat.m9447a(this, this.f3945j);
        this.f3939d = (TextView) findViewById(C0359f.title);
        int i = this.f3946k;
        if (i != -1) {
            this.f3939d.setTextAppearance(this.f3947m, i);
        }
        this.f3941f = (TextView) findViewById(C0359f.shortcut);
        this.f3942g = (ImageView) findViewById(C0359f.submenuarrow);
        ImageView imageView = this.f3942g;
        if (imageView != null) {
            imageView.setImageDrawable(this.f3949o);
        }
        this.f3943h = (ImageView) findViewById(C0359f.group_divider);
        this.f3944i = (LinearLayout) findViewById(C0359f.content);
    }

    @Override // android.widget.LinearLayout, android.view.View
    public void onMeasure(int i, int i2) {
        if (this.f3937b != null && this.f3948n) {
            ViewGroup.LayoutParams layoutParams = getLayoutParams();
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.f3937b.getLayoutParams();
            if (layoutParams.height > 0 && layoutParams2.width <= 0) {
                layoutParams2.width = layoutParams.height;
            }
        }
        super.onMeasure(i, i2);
    }

    public void setCheckable(boolean z) {
        CompoundButton compoundButton;
        CompoundButton compoundButton2;
        if (!z && this.f3938c == null && this.f3940e == null) {
            return;
        }
        if (this.f3936a.m8628i()) {
            if (this.f3938c == null) {
                m7131d();
            }
            compoundButton = this.f3938c;
            compoundButton2 = this.f3940e;
        } else {
            if (this.f3940e == null) {
                m7133b();
            }
            compoundButton = this.f3940e;
            compoundButton2 = this.f3938c;
        }
        if (z) {
            compoundButton.setChecked(this.f3936a.isChecked());
            if (compoundButton.getVisibility() != 0) {
                compoundButton.setVisibility(0);
            }
            if (compoundButton2 == null || compoundButton2.getVisibility() == 8) {
                return;
            }
            compoundButton2.setVisibility(8);
            return;
        }
        CheckBox checkBox = this.f3940e;
        if (checkBox != null) {
            checkBox.setVisibility(8);
        }
        RadioButton radioButton = this.f3938c;
        if (radioButton != null) {
            radioButton.setVisibility(8);
        }
    }

    public void setChecked(boolean z) {
        CompoundButton compoundButton;
        if (this.f3936a.m8628i()) {
            if (this.f3938c == null) {
                m7131d();
            }
            compoundButton = this.f3938c;
        } else {
            if (this.f3940e == null) {
                m7133b();
            }
            compoundButton = this.f3940e;
        }
        compoundButton.setChecked(z);
    }

    public void setForceShowIcon(boolean z) {
        this.f3952r = z;
        this.f3948n = z;
    }

    public void setGroupDividerEnabled(boolean z) {
        ImageView imageView = this.f3943h;
        if (imageView != null) {
            imageView.setVisibility((this.f3950p || !z) ? 8 : 0);
        }
    }

    public void setIcon(Drawable drawable) {
        boolean z = this.f3936a.m8625l() || this.f3952r;
        if (z || this.f3948n) {
            if (this.f3937b == null && drawable == null && !this.f3948n) {
                return;
            }
            if (this.f3937b == null) {
                m7132c();
            }
            if (drawable == null && !this.f3948n) {
                this.f3937b.setVisibility(8);
                return;
            }
            ImageView imageView = this.f3937b;
            if (!z) {
                drawable = null;
            }
            imageView.setImageDrawable(drawable);
            if (this.f3937b.getVisibility() != 0) {
                this.f3937b.setVisibility(0);
            }
        }
    }

    public void setTitle(CharSequence charSequence) {
        if (charSequence != null) {
            this.f3939d.setText(charSequence);
            if (this.f3939d.getVisibility() != 0) {
                this.f3939d.setVisibility(0);
            }
        } else if (this.f3939d.getVisibility() != 8) {
            this.f3939d.setVisibility(8);
        }
    }

    public ListMenuItemView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet);
        TintTypedArray m8257a = TintTypedArray.m8257a(getContext(), attributeSet, C0363j.MenuView, i, 0);
        this.f3945j = m8257a.m8256b(C0363j.MenuView_android_itemBackground);
        this.f3946k = m8257a.m8244g(C0363j.MenuView_android_itemTextAppearance, -1);
        this.f3948n = m8257a.m8260a(C0363j.MenuView_preserveIconSpacing, false);
        this.f3947m = context;
        this.f3949o = m8257a.m8256b(C0363j.MenuView_subMenuArrow);
        TypedArray obtainStyledAttributes = context.getTheme().obtainStyledAttributes(null, new int[]{16843049}, C0354a.dropDownListViewStyle, 0);
        this.f3950p = obtainStyledAttributes.hasValue(0);
        m8257a.m8265a();
        obtainStyledAttributes.recycle();
    }

    /* renamed from: a */
    public final void m7136a(View view) {
        m7135a(view, -1);
    }

    /* renamed from: a */
    public final void m7135a(View view, int i) {
        LinearLayout linearLayout = this.f3944i;
        if (linearLayout != null) {
            linearLayout.addView(view, i);
        } else {
            addView(view, i);
        }
    }

    /* renamed from: a */
    public void m7134a(boolean z, char c) {
        int i = (z && this.f3936a.m8624m()) ? 0 : 8;
        if (i == 0) {
            this.f3941f.setText(this.f3936a.m8633e());
        }
        if (this.f3941f.getVisibility() != i) {
            this.f3941f.setVisibility(i);
        }
    }
}
