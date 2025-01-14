package a.b.d.q;

import a.b.g.k.r;
import a.b.g.k.u;
import a.b.g.l.p;
import a.b.h.j.j.k;
import a.b.h.j.j.q;
import a.b.h.k.n1;
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
/* compiled from: BottomNavigationItemView.java */
/* loaded from: classes.dex */
public class a extends FrameLayout implements q.a {
    public static final int[] n = {16842912};

    /* renamed from: a  reason: collision with root package name */
    public final int f261a;

    /* renamed from: b  reason: collision with root package name */
    public float f262b;

    /* renamed from: c  reason: collision with root package name */
    public float f263c;

    /* renamed from: d  reason: collision with root package name */
    public float f264d;

    /* renamed from: e  reason: collision with root package name */
    public int f265e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f266f;

    /* renamed from: g  reason: collision with root package name */
    public ImageView f267g;

    /* renamed from: h  reason: collision with root package name */
    public final TextView f268h;

    /* renamed from: i  reason: collision with root package name */
    public final TextView f269i;
    public int j;
    public k k;
    public ColorStateList m;

    public a(Context context) {
        this(context, null);
    }

    @Override // a.b.h.j.j.q.a
    public void a(k kVar, int i2) {
        this.k = kVar;
        setCheckable(kVar.isCheckable());
        setChecked(kVar.isChecked());
        setEnabled(kVar.isEnabled());
        setIcon(kVar.getIcon());
        setTitle(kVar.getTitle());
        setId(kVar.getItemId());
        if (!TextUtils.isEmpty(kVar.getContentDescription())) {
            setContentDescription(kVar.getContentDescription());
        }
        n1.a(this, kVar.getTooltipText());
        setVisibility(kVar.isVisible() ? 0 : 8);
    }

    @Override // a.b.h.j.j.q.a
    public boolean a() {
        return false;
    }

    @Override // a.b.h.j.j.q.a
    public k getItemData() {
        return this.k;
    }

    public int getItemPosition() {
        return this.j;
    }

    @Override // android.view.ViewGroup, android.view.View
    public int[] onCreateDrawableState(int i2) {
        int[] onCreateDrawableState = super.onCreateDrawableState(i2 + 1);
        k kVar = this.k;
        if (kVar != null && kVar.isCheckable() && this.k.isChecked()) {
            FrameLayout.mergeDrawableStates(onCreateDrawableState, n);
        }
        return onCreateDrawableState;
    }

    public void setCheckable(boolean z) {
        refreshDrawableState();
    }

    public void setChecked(boolean z) {
        TextView textView = this.f269i;
        textView.setPivotX(textView.getWidth() / 2);
        TextView textView2 = this.f269i;
        textView2.setPivotY(textView2.getBaseline());
        TextView textView3 = this.f268h;
        textView3.setPivotX(textView3.getWidth() / 2);
        TextView textView4 = this.f268h;
        textView4.setPivotY(textView4.getBaseline());
        int i2 = this.f265e;
        if (i2 != -1) {
            if (i2 == 0) {
                if (z) {
                    a(this.f267g, this.f261a, 49);
                    a(this.f269i, 1.0f, 1.0f, 0);
                } else {
                    a(this.f267g, this.f261a, 17);
                    a(this.f269i, 0.5f, 0.5f, 4);
                }
                this.f268h.setVisibility(4);
            } else if (i2 != 1) {
                if (i2 == 2) {
                    a(this.f267g, this.f261a, 17);
                    this.f269i.setVisibility(8);
                    this.f268h.setVisibility(8);
                }
            } else if (z) {
                a(this.f267g, (int) (this.f261a + this.f262b), 49);
                a(this.f269i, 1.0f, 1.0f, 0);
                TextView textView5 = this.f268h;
                float f2 = this.f263c;
                a(textView5, f2, f2, 4);
            } else {
                a(this.f267g, this.f261a, 49);
                TextView textView6 = this.f269i;
                float f3 = this.f264d;
                a(textView6, f3, f3, 4);
                a(this.f268h, 1.0f, 1.0f, 0);
            }
        } else if (this.f266f) {
            if (z) {
                a(this.f267g, this.f261a, 49);
                a(this.f269i, 1.0f, 1.0f, 0);
            } else {
                a(this.f267g, this.f261a, 17);
                a(this.f269i, 0.5f, 0.5f, 4);
            }
            this.f268h.setVisibility(4);
        } else if (z) {
            a(this.f267g, (int) (this.f261a + this.f262b), 49);
            a(this.f269i, 1.0f, 1.0f, 0);
            TextView textView7 = this.f268h;
            float f4 = this.f263c;
            a(textView7, f4, f4, 4);
        } else {
            a(this.f267g, this.f261a, 49);
            TextView textView8 = this.f269i;
            float f5 = this.f264d;
            a(textView8, f5, f5, 4);
            a(this.f268h, 1.0f, 1.0f, 0);
        }
        refreshDrawableState();
        setSelected(z);
    }

    @Override // android.view.View
    public void setEnabled(boolean z) {
        super.setEnabled(z);
        this.f268h.setEnabled(z);
        this.f269i.setEnabled(z);
        this.f267g.setEnabled(z);
        if (z) {
            u.a(this, r.a(getContext(), 1002));
        } else {
            u.a(this, (r) null);
        }
    }

    public void setIcon(Drawable drawable) {
        if (drawable != null) {
            Drawable.ConstantState constantState = drawable.getConstantState();
            if (constantState != null) {
                drawable = constantState.newDrawable();
            }
            drawable = a.b.g.c.j.a.i(drawable).mutate();
            a.b.g.c.j.a.a(drawable, this.m);
        }
        this.f267g.setImageDrawable(drawable);
    }

    public void setIconSize(int i2) {
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.f267g.getLayoutParams();
        layoutParams.width = i2;
        layoutParams.height = i2;
        this.f267g.setLayoutParams(layoutParams);
    }

    public void setIconTintList(ColorStateList colorStateList) {
        this.m = colorStateList;
        k kVar = this.k;
        if (kVar != null) {
            setIcon(kVar.getIcon());
        }
    }

    public void setItemBackground(int i2) {
        setItemBackground(i2 == 0 ? null : a.b.g.b.b.c(getContext(), i2));
    }

    public void setItemPosition(int i2) {
        this.j = i2;
    }

    public void setLabelVisibilityMode(int i2) {
        if (this.f265e != i2) {
            this.f265e = i2;
            if (this.k != null) {
                setChecked(this.k.isChecked());
            }
        }
    }

    public void setShifting(boolean z) {
        if (this.f266f != z) {
            this.f266f = z;
            if (this.k != null) {
                setChecked(this.k.isChecked());
            }
        }
    }

    public void setTextAppearanceActive(int i2) {
        p.d(this.f269i, i2);
        a(this.f268h.getTextSize(), this.f269i.getTextSize());
    }

    public void setTextAppearanceInactive(int i2) {
        p.d(this.f268h, i2);
        a(this.f268h.getTextSize(), this.f269i.getTextSize());
    }

    public void setTextColor(ColorStateList colorStateList) {
        if (colorStateList != null) {
            this.f268h.setTextColor(colorStateList);
            this.f269i.setTextColor(colorStateList);
        }
    }

    public void setTitle(CharSequence charSequence) {
        this.f268h.setText(charSequence);
        this.f269i.setText(charSequence);
        k kVar = this.k;
        if (kVar == null || TextUtils.isEmpty(kVar.getContentDescription())) {
            setContentDescription(charSequence);
        }
    }

    public a(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public a(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.j = -1;
        Resources resources = getResources();
        LayoutInflater.from(context).inflate(a.b.d.h.design_bottom_navigation_item, (ViewGroup) this, true);
        setBackgroundResource(a.b.d.e.design_bottom_navigation_item_background);
        this.f261a = resources.getDimensionPixelSize(a.b.d.d.design_bottom_navigation_margin);
        this.f267g = (ImageView) findViewById(a.b.d.f.icon);
        this.f268h = (TextView) findViewById(a.b.d.f.smallLabel);
        this.f269i = (TextView) findViewById(a.b.d.f.largeLabel);
        u.f(this.f268h, 2);
        u.f(this.f269i, 2);
        setFocusable(true);
        a(this.f268h.getTextSize(), this.f269i.getTextSize());
    }

    public void setItemBackground(Drawable drawable) {
        u.a(this, drawable);
    }

    public final void a(View view, int i2, int i3) {
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) view.getLayoutParams();
        layoutParams.topMargin = i2;
        layoutParams.gravity = i3;
        view.setLayoutParams(layoutParams);
    }

    public final void a(View view, float f2, float f3, int i2) {
        view.setScaleX(f2);
        view.setScaleY(f3);
        view.setVisibility(i2);
    }

    public final void a(float f2, float f3) {
        this.f262b = f2 - f3;
        this.f263c = (f3 * 1.0f) / f2;
        this.f264d = (f2 * 1.0f) / f3;
    }
}
