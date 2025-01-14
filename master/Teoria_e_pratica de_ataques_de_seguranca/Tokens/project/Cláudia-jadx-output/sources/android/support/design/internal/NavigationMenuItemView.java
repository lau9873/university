package android.support.design.internal;

import a.b.d.d;
import a.b.d.f;
import a.b.d.h;
import a.b.d.q.e;
import a.b.g.k.b;
import a.b.g.k.e0.c;
import a.b.g.k.u;
import a.b.g.l.p;
import a.b.h.j.j.k;
import a.b.h.j.j.q;
import a.b.h.k.n1;
import a.b.h.k.r0;
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
/* loaded from: classes.dex */
public class NavigationMenuItemView extends e implements q.a {
    public static final int[] G = {16842912};
    public FrameLayout A;
    public k B;
    public ColorStateList C;
    public boolean D;
    public Drawable E;
    public final b F;
    public final int w;
    public boolean x;
    public boolean y;
    public final CheckedTextView z;

    /* loaded from: classes.dex */
    public class a extends b {
        public a() {
        }

        @Override // a.b.g.k.b
        public void a(View view, c cVar) {
            super.a(view, cVar);
            cVar.a(NavigationMenuItemView.this.y);
        }
    }

    public NavigationMenuItemView(Context context) {
        this(context, null);
    }

    private void setActionView(View view) {
        if (view != null) {
            if (this.A == null) {
                this.A = (FrameLayout) ((ViewStub) findViewById(f.design_menu_item_action_area_stub)).inflate();
            }
            this.A.removeAllViews();
            this.A.addView(view);
        }
    }

    @Override // a.b.h.j.j.q.a
    public void a(k kVar, int i2) {
        this.B = kVar;
        setVisibility(kVar.isVisible() ? 0 : 8);
        if (getBackground() == null) {
            u.a(this, e());
        }
        setCheckable(kVar.isCheckable());
        setChecked(kVar.isChecked());
        setEnabled(kVar.isEnabled());
        setTitle(kVar.getTitle());
        setIcon(kVar.getIcon());
        setActionView(kVar.getActionView());
        setContentDescription(kVar.getContentDescription());
        n1.a(this, kVar.getTooltipText());
        d();
    }

    @Override // a.b.h.j.j.q.a
    public boolean a() {
        return false;
    }

    public final void d() {
        if (f()) {
            this.z.setVisibility(8);
            FrameLayout frameLayout = this.A;
            if (frameLayout != null) {
                r0.a aVar = (r0.a) frameLayout.getLayoutParams();
                ((ViewGroup.MarginLayoutParams) aVar).width = -1;
                this.A.setLayoutParams(aVar);
                return;
            }
            return;
        }
        this.z.setVisibility(0);
        FrameLayout frameLayout2 = this.A;
        if (frameLayout2 != null) {
            r0.a aVar2 = (r0.a) frameLayout2.getLayoutParams();
            ((ViewGroup.MarginLayoutParams) aVar2).width = -2;
            this.A.setLayoutParams(aVar2);
        }
    }

    public final StateListDrawable e() {
        TypedValue typedValue = new TypedValue();
        if (getContext().getTheme().resolveAttribute(a.b.h.b.a.colorControlHighlight, typedValue, true)) {
            StateListDrawable stateListDrawable = new StateListDrawable();
            stateListDrawable.addState(G, new ColorDrawable(typedValue.data));
            stateListDrawable.addState(ViewGroup.EMPTY_STATE_SET, new ColorDrawable(0));
            return stateListDrawable;
        }
        return null;
    }

    public final boolean f() {
        return this.B.getTitle() == null && this.B.getIcon() == null && this.B.getActionView() != null;
    }

    @Override // a.b.h.j.j.q.a
    public k getItemData() {
        return this.B;
    }

    @Override // android.view.ViewGroup, android.view.View
    public int[] onCreateDrawableState(int i2) {
        int[] onCreateDrawableState = super.onCreateDrawableState(i2 + 1);
        k kVar = this.B;
        if (kVar != null && kVar.isCheckable() && this.B.isChecked()) {
            ViewGroup.mergeDrawableStates(onCreateDrawableState, G);
        }
        return onCreateDrawableState;
    }

    public void setCheckable(boolean z) {
        refreshDrawableState();
        if (this.y != z) {
            this.y = z;
            this.F.a(this.z, 2048);
        }
    }

    public void setChecked(boolean z) {
        refreshDrawableState();
        this.z.setChecked(z);
    }

    public void setHorizontalPadding(int i2) {
        setPadding(i2, 0, i2, 0);
    }

    public void setIcon(Drawable drawable) {
        if (drawable != null) {
            if (this.D) {
                Drawable.ConstantState constantState = drawable.getConstantState();
                if (constantState != null) {
                    drawable = constantState.newDrawable();
                }
                drawable = a.b.g.c.j.a.i(drawable).mutate();
                a.b.g.c.j.a.a(drawable, this.C);
            }
            int i2 = this.w;
            drawable.setBounds(0, 0, i2, i2);
        } else if (this.x) {
            if (this.E == null) {
                this.E = a.b.g.b.g.f.a(getResources(), a.b.d.e.navigation_empty_icon, getContext().getTheme());
                Drawable drawable2 = this.E;
                if (drawable2 != null) {
                    int i3 = this.w;
                    drawable2.setBounds(0, 0, i3, i3);
                }
            }
            drawable = this.E;
        }
        p.a(this.z, drawable, null, null, null);
    }

    public void setIconPadding(int i2) {
        this.z.setCompoundDrawablePadding(i2);
    }

    public void setIconTintList(ColorStateList colorStateList) {
        this.C = colorStateList;
        this.D = this.C != null;
        k kVar = this.B;
        if (kVar != null) {
            setIcon(kVar.getIcon());
        }
    }

    public void setNeedsEmptyIcon(boolean z) {
        this.x = z;
    }

    public void setTextAppearance(int i2) {
        p.d(this.z, i2);
    }

    public void setTextColor(ColorStateList colorStateList) {
        this.z.setTextColor(colorStateList);
    }

    public void setTitle(CharSequence charSequence) {
        this.z.setText(charSequence);
    }

    public NavigationMenuItemView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public NavigationMenuItemView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.F = new a();
        setOrientation(0);
        LayoutInflater.from(context).inflate(h.design_navigation_menu_item, (ViewGroup) this, true);
        this.w = context.getResources().getDimensionPixelSize(d.design_navigation_icon_size);
        this.z = (CheckedTextView) findViewById(f.design_menu_item_text);
        this.z.setDuplicateParentStateEnabled(true);
        u.a(this.z, this.F);
    }
}
