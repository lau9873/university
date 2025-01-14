package p000a.p006b.p012d.p015n;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.AttributeSet;
import android.util.Log;
import p000a.p006b.p012d.C0040b;
import p000a.p006b.p012d.C0048j;
import p000a.p006b.p012d.C0049k;
import p000a.p006b.p012d.p019q.ThemeEnforcement;
import p000a.p006b.p012d.p019q.ViewUtils;
import p000a.p006b.p012d.p020r.MaterialResources;
import p000a.p006b.p030g.p034c.p035j.DrawableCompat;
import p000a.p006b.p030g.p045k.ViewCompat;
import p000a.p006b.p030g.p048l.TextViewCompat;
import p000a.p006b.p049h.p053d.p054a.AppCompatResources;
import p000a.p006b.p049h.p063k.AppCompatButton;

/* renamed from: a.b.d.n.a */
/* loaded from: classes.dex */
public class MaterialButton extends AppCompatButton {

    /* renamed from: c */
    public final MaterialButtonHelper f443c;

    /* renamed from: d */
    public int f444d;

    /* renamed from: e */
    public PorterDuff.Mode f445e;

    /* renamed from: f */
    public ColorStateList f446f;

    /* renamed from: g */
    public Drawable f447g;

    /* renamed from: h */
    public int f448h;

    /* renamed from: i */
    public int f449i;

    /* renamed from: j */
    public int f450j;

    public MaterialButton(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, C0040b.materialButtonStyle);
    }

    /* renamed from: a */
    public final boolean m10937a() {
        return ViewCompat.m9422k(this) == 1;
    }

    /* renamed from: b */
    public final boolean m10936b() {
        MaterialButtonHelper materialButtonHelper = this.f443c;
        return (materialButtonHelper == null || materialButtonHelper.m10915i()) ? false : true;
    }

    /* renamed from: c */
    public final void m10935c() {
        Drawable drawable = this.f447g;
        if (drawable != null) {
            this.f447g = drawable.mutate();
            DrawableCompat.m9861a(this.f447g, this.f446f);
            PorterDuff.Mode mode = this.f445e;
            if (mode != null) {
                DrawableCompat.m9858a(this.f447g, mode);
            }
            int i = this.f448h;
            if (i == 0) {
                i = this.f447g.getIntrinsicWidth();
            }
            int i2 = this.f448h;
            if (i2 == 0) {
                i2 = this.f447g.getIntrinsicHeight();
            }
            Drawable drawable2 = this.f447g;
            int i3 = this.f449i;
            drawable2.setBounds(i3, 0, i + i3, i2);
        }
        TextViewCompat.m9212a(this, this.f447g, null, null, null);
    }

    @Override // android.view.View
    public ColorStateList getBackgroundTintList() {
        return getSupportBackgroundTintList();
    }

    @Override // android.view.View
    public PorterDuff.Mode getBackgroundTintMode() {
        return getSupportBackgroundTintMode();
    }

    public int getCornerRadius() {
        if (m10936b()) {
            return this.f443c.m10923c();
        }
        return 0;
    }

    public Drawable getIcon() {
        return this.f447g;
    }

    public int getIconGravity() {
        return this.f450j;
    }

    public int getIconPadding() {
        return this.f444d;
    }

    public int getIconSize() {
        return this.f448h;
    }

    public ColorStateList getIconTint() {
        return this.f446f;
    }

    public PorterDuff.Mode getIconTintMode() {
        return this.f445e;
    }

    public ColorStateList getRippleColor() {
        if (m10936b()) {
            return this.f443c.m10920d();
        }
        return null;
    }

    public ColorStateList getStrokeColor() {
        if (m10936b()) {
            return this.f443c.m10919e();
        }
        return null;
    }

    public int getStrokeWidth() {
        if (m10936b()) {
            return this.f443c.m10918f();
        }
        return 0;
    }

    @Override // p000a.p006b.p049h.p063k.AppCompatButton, p000a.p006b.p030g.p045k.TintableBackgroundView
    public ColorStateList getSupportBackgroundTintList() {
        if (m10936b()) {
            return this.f443c.m10917g();
        }
        return super.getSupportBackgroundTintList();
    }

    @Override // p000a.p006b.p049h.p063k.AppCompatButton, p000a.p006b.p030g.p045k.TintableBackgroundView
    public PorterDuff.Mode getSupportBackgroundTintMode() {
        if (m10936b()) {
            return this.f443c.m10916h();
        }
        return super.getSupportBackgroundTintMode();
    }

    @Override // android.widget.TextView, android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (Build.VERSION.SDK_INT >= 21 || !m10936b()) {
            return;
        }
        this.f443c.m10929a(canvas);
    }

    @Override // p000a.p006b.p049h.p063k.AppCompatButton, android.widget.TextView, android.view.View
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        MaterialButtonHelper materialButtonHelper;
        super.onLayout(z, i, i2, i3, i4);
        if (Build.VERSION.SDK_INT != 21 || (materialButtonHelper = this.f443c) == null) {
            return;
        }
        materialButtonHelper.m10932a(i4 - i2, i3 - i);
    }

    @Override // android.widget.TextView, android.view.View
    public void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        if (this.f447g == null || this.f450j != 2) {
            return;
        }
        int measureText = (int) getPaint().measureText(getText().toString());
        int i3 = this.f448h;
        if (i3 == 0) {
            i3 = this.f447g.getIntrinsicWidth();
        }
        int measuredWidth = (((((getMeasuredWidth() - measureText) - ViewCompat.m9419n(this)) - i3) - this.f444d) - ViewCompat.m9418o(this)) / 2;
        if (m10937a()) {
            measuredWidth = -measuredWidth;
        }
        if (this.f449i != measuredWidth) {
            this.f449i = measuredWidth;
            m10935c();
        }
    }

    @Override // android.view.View
    public void setBackground(Drawable drawable) {
        setBackgroundDrawable(drawable);
    }

    @Override // android.view.View
    public void setBackgroundColor(int i) {
        if (m10936b()) {
            this.f443c.m10933a(i);
        } else {
            super.setBackgroundColor(i);
        }
    }

    @Override // p000a.p006b.p049h.p063k.AppCompatButton, android.view.View
    public void setBackgroundDrawable(Drawable drawable) {
        if (m10936b()) {
            if (drawable != getBackground()) {
                Log.i("MaterialButton", "Setting a custom background is not supported.");
                this.f443c.m10914j();
                super.setBackgroundDrawable(drawable);
                return;
            }
            getBackground().setState(drawable.getState());
            return;
        }
        super.setBackgroundDrawable(drawable);
    }

    @Override // p000a.p006b.p049h.p063k.AppCompatButton, android.view.View
    public void setBackgroundResource(int i) {
        setBackgroundDrawable(i != 0 ? AppCompatResources.m8967c(getContext(), i) : null);
    }

    @Override // android.view.View
    public void setBackgroundTintList(ColorStateList colorStateList) {
        setSupportBackgroundTintList(colorStateList);
    }

    @Override // android.view.View
    public void setBackgroundTintMode(PorterDuff.Mode mode) {
        setSupportBackgroundTintMode(mode);
    }

    public void setCornerRadius(int i) {
        if (m10936b()) {
            this.f443c.m10925b(i);
        }
    }

    public void setCornerRadiusResource(int i) {
        if (m10936b()) {
            setCornerRadius(getResources().getDimensionPixelSize(i));
        }
    }

    public void setIcon(Drawable drawable) {
        if (this.f447g != drawable) {
            this.f447g = drawable;
            m10935c();
        }
    }

    public void setIconGravity(int i) {
        this.f450j = i;
    }

    public void setIconPadding(int i) {
        if (this.f444d != i) {
            this.f444d = i;
            setCompoundDrawablePadding(i);
        }
    }

    public void setIconResource(int i) {
        setIcon(i != 0 ? AppCompatResources.m8967c(getContext(), i) : null);
    }

    public void setIconSize(int i) {
        if (i >= 0) {
            if (this.f448h != i) {
                this.f448h = i;
                m10935c();
                return;
            }
            return;
        }
        throw new IllegalArgumentException("iconSize cannot be less than 0");
    }

    public void setIconTint(ColorStateList colorStateList) {
        if (this.f446f != colorStateList) {
            this.f446f = colorStateList;
            m10935c();
        }
    }

    public void setIconTintMode(PorterDuff.Mode mode) {
        if (this.f445e != mode) {
            this.f445e = mode;
            m10935c();
        }
    }

    public void setIconTintResource(int i) {
        setIconTint(AppCompatResources.m8968b(getContext(), i));
    }

    public void setInternalBackground(Drawable drawable) {
        super.setBackgroundDrawable(drawable);
    }

    public void setRippleColor(ColorStateList colorStateList) {
        if (m10936b()) {
            this.f443c.m10931a(colorStateList);
        }
    }

    public void setRippleColorResource(int i) {
        if (m10936b()) {
            setRippleColor(AppCompatResources.m8968b(getContext(), i));
        }
    }

    public void setStrokeColor(ColorStateList colorStateList) {
        if (m10936b()) {
            this.f443c.m10924b(colorStateList);
        }
    }

    public void setStrokeColorResource(int i) {
        if (m10936b()) {
            setStrokeColor(AppCompatResources.m8968b(getContext(), i));
        }
    }

    public void setStrokeWidth(int i) {
        if (m10936b()) {
            this.f443c.m10922c(i);
        }
    }

    public void setStrokeWidthResource(int i) {
        if (m10936b()) {
            setStrokeWidth(getResources().getDimensionPixelSize(i));
        }
    }

    @Override // p000a.p006b.p049h.p063k.AppCompatButton, p000a.p006b.p030g.p045k.TintableBackgroundView
    public void setSupportBackgroundTintList(ColorStateList colorStateList) {
        if (m10936b()) {
            this.f443c.m10921c(colorStateList);
        } else if (this.f443c != null) {
            super.setSupportBackgroundTintList(colorStateList);
        }
    }

    @Override // p000a.p006b.p049h.p063k.AppCompatButton, p000a.p006b.p030g.p045k.TintableBackgroundView
    public void setSupportBackgroundTintMode(PorterDuff.Mode mode) {
        if (m10936b()) {
            this.f443c.m10928a(mode);
        } else if (this.f443c != null) {
            super.setSupportBackgroundTintMode(mode);
        }
    }

    public MaterialButton(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        TypedArray m10861c = ThemeEnforcement.m10861c(context, attributeSet, C0049k.MaterialButton, i, C0048j.Widget_MaterialComponents_Button, new int[0]);
        this.f444d = m10861c.getDimensionPixelSize(C0049k.MaterialButton_iconPadding, 0);
        this.f445e = ViewUtils.m10859a(m10861c.getInt(C0049k.MaterialButton_iconTintMode, -1), PorterDuff.Mode.SRC_IN);
        this.f446f = MaterialResources.m10857a(getContext(), m10861c, C0049k.MaterialButton_iconTint);
        this.f447g = MaterialResources.m10856b(getContext(), m10861c, C0049k.MaterialButton_icon);
        this.f450j = m10861c.getInteger(C0049k.MaterialButton_iconGravity, 1);
        this.f448h = m10861c.getDimensionPixelSize(C0049k.MaterialButton_iconSize, 0);
        this.f443c = new MaterialButtonHelper(this);
        this.f443c.m10930a(m10861c);
        m10861c.recycle();
        setCompoundDrawablePadding(this.f444d);
        m10935c();
    }
}
