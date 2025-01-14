package android.support.v7.view.menu;

import a.b.g.k.u;
import a.b.h.b.a;
import a.b.h.b.f;
import a.b.h.b.g;
import a.b.h.b.j;
import a.b.h.j.j.k;
import a.b.h.j.j.q;
import a.b.h.k.l1;
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
/* loaded from: classes.dex */
public class ListMenuItemView extends LinearLayout implements q.a, AbsListView.SelectionBoundsAdjuster {

    /* renamed from: a  reason: collision with root package name */
    public k f2463a;

    /* renamed from: b  reason: collision with root package name */
    public ImageView f2464b;

    /* renamed from: c  reason: collision with root package name */
    public RadioButton f2465c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f2466d;

    /* renamed from: e  reason: collision with root package name */
    public CheckBox f2467e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f2468f;

    /* renamed from: g  reason: collision with root package name */
    public ImageView f2469g;

    /* renamed from: h  reason: collision with root package name */
    public ImageView f2470h;

    /* renamed from: i  reason: collision with root package name */
    public LinearLayout f2471i;
    public Drawable j;
    public int k;
    public Context m;
    public boolean n;
    public Drawable o;
    public boolean p;
    public LayoutInflater q;
    public boolean r;

    public ListMenuItemView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, a.listMenuViewStyle);
    }

    private LayoutInflater getInflater() {
        if (this.q == null) {
            this.q = LayoutInflater.from(getContext());
        }
        return this.q;
    }

    private void setSubMenuArrowVisible(boolean z) {
        ImageView imageView = this.f2469g;
        if (imageView != null) {
            imageView.setVisibility(z ? 0 : 8);
        }
    }

    @Override // a.b.h.j.j.q.a
    public void a(k kVar, int i2) {
        this.f2463a = kVar;
        setVisibility(kVar.isVisible() ? 0 : 8);
        setTitle(kVar.a(this));
        setCheckable(kVar.isCheckable());
        a(kVar.m(), kVar.d());
        setIcon(kVar.getIcon());
        setEnabled(kVar.isEnabled());
        setSubMenuArrowVisible(kVar.hasSubMenu());
        setContentDescription(kVar.getContentDescription());
    }

    @Override // a.b.h.j.j.q.a
    public boolean a() {
        return false;
    }

    @Override // android.widget.AbsListView.SelectionBoundsAdjuster
    public void adjustListItemSelectionBounds(Rect rect) {
        ImageView imageView = this.f2470h;
        if (imageView == null || imageView.getVisibility() != 0) {
            return;
        }
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.f2470h.getLayoutParams();
        rect.top += this.f2470h.getHeight() + layoutParams.topMargin + layoutParams.bottomMargin;
    }

    public final void b() {
        this.f2467e = (CheckBox) getInflater().inflate(g.abc_list_menu_item_checkbox, (ViewGroup) this, false);
        a(this.f2467e);
    }

    public final void c() {
        this.f2464b = (ImageView) getInflater().inflate(g.abc_list_menu_item_icon, (ViewGroup) this, false);
        a(this.f2464b, 0);
    }

    public final void d() {
        this.f2465c = (RadioButton) getInflater().inflate(g.abc_list_menu_item_radio, (ViewGroup) this, false);
        a(this.f2465c);
    }

    @Override // a.b.h.j.j.q.a
    public k getItemData() {
        return this.f2463a;
    }

    @Override // android.view.View
    public void onFinishInflate() {
        super.onFinishInflate();
        u.a(this, this.j);
        this.f2466d = (TextView) findViewById(f.title);
        int i2 = this.k;
        if (i2 != -1) {
            this.f2466d.setTextAppearance(this.m, i2);
        }
        this.f2468f = (TextView) findViewById(f.shortcut);
        this.f2469g = (ImageView) findViewById(f.submenuarrow);
        ImageView imageView = this.f2469g;
        if (imageView != null) {
            imageView.setImageDrawable(this.o);
        }
        this.f2470h = (ImageView) findViewById(f.group_divider);
        this.f2471i = (LinearLayout) findViewById(f.content);
    }

    @Override // android.widget.LinearLayout, android.view.View
    public void onMeasure(int i2, int i3) {
        if (this.f2464b != null && this.n) {
            ViewGroup.LayoutParams layoutParams = getLayoutParams();
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.f2464b.getLayoutParams();
            if (layoutParams.height > 0 && layoutParams2.width <= 0) {
                layoutParams2.width = layoutParams.height;
            }
        }
        super.onMeasure(i2, i3);
    }

    public void setCheckable(boolean z) {
        CompoundButton compoundButton;
        CompoundButton compoundButton2;
        if (!z && this.f2465c == null && this.f2467e == null) {
            return;
        }
        if (this.f2463a.i()) {
            if (this.f2465c == null) {
                d();
            }
            compoundButton = this.f2465c;
            compoundButton2 = this.f2467e;
        } else {
            if (this.f2467e == null) {
                b();
            }
            compoundButton = this.f2467e;
            compoundButton2 = this.f2465c;
        }
        if (z) {
            compoundButton.setChecked(this.f2463a.isChecked());
            if (compoundButton.getVisibility() != 0) {
                compoundButton.setVisibility(0);
            }
            if (compoundButton2 == null || compoundButton2.getVisibility() == 8) {
                return;
            }
            compoundButton2.setVisibility(8);
            return;
        }
        CheckBox checkBox = this.f2467e;
        if (checkBox != null) {
            checkBox.setVisibility(8);
        }
        RadioButton radioButton = this.f2465c;
        if (radioButton != null) {
            radioButton.setVisibility(8);
        }
    }

    public void setChecked(boolean z) {
        CompoundButton compoundButton;
        if (this.f2463a.i()) {
            if (this.f2465c == null) {
                d();
            }
            compoundButton = this.f2465c;
        } else {
            if (this.f2467e == null) {
                b();
            }
            compoundButton = this.f2467e;
        }
        compoundButton.setChecked(z);
    }

    public void setForceShowIcon(boolean z) {
        this.r = z;
        this.n = z;
    }

    public void setGroupDividerEnabled(boolean z) {
        ImageView imageView = this.f2470h;
        if (imageView != null) {
            imageView.setVisibility((this.p || !z) ? 8 : 0);
        }
    }

    public void setIcon(Drawable drawable) {
        boolean z = this.f2463a.l() || this.r;
        if (z || this.n) {
            if (this.f2464b == null && drawable == null && !this.n) {
                return;
            }
            if (this.f2464b == null) {
                c();
            }
            if (drawable == null && !this.n) {
                this.f2464b.setVisibility(8);
                return;
            }
            ImageView imageView = this.f2464b;
            if (!z) {
                drawable = null;
            }
            imageView.setImageDrawable(drawable);
            if (this.f2464b.getVisibility() != 0) {
                this.f2464b.setVisibility(0);
            }
        }
    }

    public void setTitle(CharSequence charSequence) {
        if (charSequence != null) {
            this.f2466d.setText(charSequence);
            if (this.f2466d.getVisibility() != 0) {
                this.f2466d.setVisibility(0);
            }
        } else if (this.f2466d.getVisibility() != 8) {
            this.f2466d.setVisibility(8);
        }
    }

    public ListMenuItemView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet);
        l1 a2 = l1.a(getContext(), attributeSet, j.MenuView, i2, 0);
        this.j = a2.b(j.MenuView_android_itemBackground);
        this.k = a2.g(j.MenuView_android_itemTextAppearance, -1);
        this.n = a2.a(j.MenuView_preserveIconSpacing, false);
        this.m = context;
        this.o = a2.b(j.MenuView_subMenuArrow);
        TypedArray obtainStyledAttributes = context.getTheme().obtainStyledAttributes(null, new int[]{16843049}, a.dropDownListViewStyle, 0);
        this.p = obtainStyledAttributes.hasValue(0);
        a2.a();
        obtainStyledAttributes.recycle();
    }

    public final void a(View view) {
        a(view, -1);
    }

    public final void a(View view, int i2) {
        LinearLayout linearLayout = this.f2471i;
        if (linearLayout != null) {
            linearLayout.addView(view, i2);
        } else {
            addView(view, i2);
        }
    }

    public void a(boolean z, char c2) {
        int i2 = (z && this.f2463a.m()) ? 0 : 8;
        if (i2 == 0) {
            this.f2468f.setText(this.f2463a.e());
        }
        if (this.f2468f.getVisibility() != i2) {
            this.f2468f.setVisibility(i2);
        }
    }
}
