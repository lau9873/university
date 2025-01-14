package a.b.d.n;

import a.b.d.j;
import a.b.d.k;
import a.b.d.q.h;
import a.b.g.k.u;
import a.b.g.l.p;
import a.b.h.k.g;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.AttributeSet;
import android.util.Log;
/* compiled from: MaterialButton.java */
/* loaded from: classes.dex */
public class a extends g {

    /* renamed from: c  reason: collision with root package name */
    public final c f232c;

    /* renamed from: d  reason: collision with root package name */
    public int f233d;

    /* renamed from: e  reason: collision with root package name */
    public PorterDuff.Mode f234e;

    /* renamed from: f  reason: collision with root package name */
    public ColorStateList f235f;

    /* renamed from: g  reason: collision with root package name */
    public Drawable f236g;

    /* renamed from: h  reason: collision with root package name */
    public int f237h;

    /* renamed from: i  reason: collision with root package name */
    public int f238i;
    public int j;

    public a(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, a.b.d.b.materialButtonStyle);
    }

    public final boolean a() {
        return u.k(this) == 1;
    }

    public final boolean b() {
        c cVar = this.f232c;
        return (cVar == null || cVar.i()) ? false : true;
    }

    public final void c() {
        Drawable drawable = this.f236g;
        if (drawable != null) {
            this.f236g = drawable.mutate();
            a.b.g.c.j.a.a(this.f236g, this.f235f);
            PorterDuff.Mode mode = this.f234e;
            if (mode != null) {
                a.b.g.c.j.a.a(this.f236g, mode);
            }
            int i2 = this.f237h;
            if (i2 == 0) {
                i2 = this.f236g.getIntrinsicWidth();
            }
            int i3 = this.f237h;
            if (i3 == 0) {
                i3 = this.f236g.getIntrinsicHeight();
            }
            Drawable drawable2 = this.f236g;
            int i4 = this.f238i;
            drawable2.setBounds(i4, 0, i2 + i4, i3);
        }
        p.a(this, this.f236g, null, null, null);
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
        if (b()) {
            return this.f232c.c();
        }
        return 0;
    }

    public Drawable getIcon() {
        return this.f236g;
    }

    public int getIconGravity() {
        return this.j;
    }

    public int getIconPadding() {
        return this.f233d;
    }

    public int getIconSize() {
        return this.f237h;
    }

    public ColorStateList getIconTint() {
        return this.f235f;
    }

    public PorterDuff.Mode getIconTintMode() {
        return this.f234e;
    }

    public ColorStateList getRippleColor() {
        if (b()) {
            return this.f232c.d();
        }
        return null;
    }

    public ColorStateList getStrokeColor() {
        if (b()) {
            return this.f232c.e();
        }
        return null;
    }

    public int getStrokeWidth() {
        if (b()) {
            return this.f232c.f();
        }
        return 0;
    }

    @Override // a.b.h.k.g, a.b.g.k.t
    public ColorStateList getSupportBackgroundTintList() {
        if (b()) {
            return this.f232c.g();
        }
        return super.getSupportBackgroundTintList();
    }

    @Override // a.b.h.k.g, a.b.g.k.t
    public PorterDuff.Mode getSupportBackgroundTintMode() {
        if (b()) {
            return this.f232c.h();
        }
        return super.getSupportBackgroundTintMode();
    }

    @Override // android.widget.TextView, android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (Build.VERSION.SDK_INT >= 21 || !b()) {
            return;
        }
        this.f232c.a(canvas);
    }

    @Override // a.b.h.k.g, android.widget.TextView, android.view.View
    public void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        c cVar;
        super.onLayout(z, i2, i3, i4, i5);
        if (Build.VERSION.SDK_INT != 21 || (cVar = this.f232c) == null) {
            return;
        }
        cVar.a(i5 - i3, i4 - i2);
    }

    @Override // android.widget.TextView, android.view.View
    public void onMeasure(int i2, int i3) {
        super.onMeasure(i2, i3);
        if (this.f236g == null || this.j != 2) {
            return;
        }
        int measureText = (int) getPaint().measureText(getText().toString());
        int i4 = this.f237h;
        if (i4 == 0) {
            i4 = this.f236g.getIntrinsicWidth();
        }
        int measuredWidth = (((((getMeasuredWidth() - measureText) - u.n(this)) - i4) - this.f233d) - u.o(this)) / 2;
        if (a()) {
            measuredWidth = -measuredWidth;
        }
        if (this.f238i != measuredWidth) {
            this.f238i = measuredWidth;
            c();
        }
    }

    @Override // android.view.View
    public void setBackground(Drawable drawable) {
        setBackgroundDrawable(drawable);
    }

    @Override // android.view.View
    public void setBackgroundColor(int i2) {
        if (b()) {
            this.f232c.a(i2);
        } else {
            super.setBackgroundColor(i2);
        }
    }

    @Override // a.b.h.k.g, android.view.View
    public void setBackgroundDrawable(Drawable drawable) {
        if (b()) {
            if (drawable != getBackground()) {
                Log.i("MaterialButton", "Setting a custom background is not supported.");
                this.f232c.j();
                super.setBackgroundDrawable(drawable);
                return;
            }
            getBackground().setState(drawable.getState());
            return;
        }
        super.setBackgroundDrawable(drawable);
    }

    @Override // a.b.h.k.g, android.view.View
    public void setBackgroundResource(int i2) {
        setBackgroundDrawable(i2 != 0 ? a.b.h.d.a.a.c(getContext(), i2) : null);
    }

    @Override // android.view.View
    public void setBackgroundTintList(ColorStateList colorStateList) {
        setSupportBackgroundTintList(colorStateList);
    }

    @Override // android.view.View
    public void setBackgroundTintMode(PorterDuff.Mode mode) {
        setSupportBackgroundTintMode(mode);
    }

    public void setCornerRadius(int i2) {
        if (b()) {
            this.f232c.b(i2);
        }
    }

    public void setCornerRadiusResource(int i2) {
        if (b()) {
            setCornerRadius(getResources().getDimensionPixelSize(i2));
        }
    }

    public void setIcon(Drawable drawable) {
        if (this.f236g != drawable) {
            this.f236g = drawable;
            c();
        }
    }

    public void setIconGravity(int i2) {
        this.j = i2;
    }

    public void setIconPadding(int i2) {
        if (this.f233d != i2) {
            this.f233d = i2;
            setCompoundDrawablePadding(i2);
        }
    }

    public void setIconResource(int i2) {
        setIcon(i2 != 0 ? a.b.h.d.a.a.c(getContext(), i2) : null);
    }

    public void setIconSize(int i2) {
        if (i2 >= 0) {
            if (this.f237h != i2) {
                this.f237h = i2;
                c();
                return;
            }
            return;
        }
        throw new IllegalArgumentException("iconSize cannot be less than 0");
    }

    public void setIconTint(ColorStateList colorStateList) {
        if (this.f235f != colorStateList) {
            this.f235f = colorStateList;
            c();
        }
    }

    public void setIconTintMode(PorterDuff.Mode mode) {
        if (this.f234e != mode) {
            this.f234e = mode;
            c();
        }
    }

    public void setIconTintResource(int i2) {
        setIconTint(a.b.h.d.a.a.b(getContext(), i2));
    }

    public void setInternalBackground(Drawable drawable) {
        super.setBackgroundDrawable(drawable);
    }

    public void setRippleColor(ColorStateList colorStateList) {
        if (b()) {
            this.f232c.a(colorStateList);
        }
    }

    public void setRippleColorResource(int i2) {
        if (b()) {
            setRippleColor(a.b.h.d.a.a.b(getContext(), i2));
        }
    }

    public void setStrokeColor(ColorStateList colorStateList) {
        if (b()) {
            this.f232c.b(colorStateList);
        }
    }

    public void setStrokeColorResource(int i2) {
        if (b()) {
            setStrokeColor(a.b.h.d.a.a.b(getContext(), i2));
        }
    }

    public void setStrokeWidth(int i2) {
        if (b()) {
            this.f232c.c(i2);
        }
    }

    public void setStrokeWidthResource(int i2) {
        if (b()) {
            setStrokeWidth(getResources().getDimensionPixelSize(i2));
        }
    }

    @Override // a.b.h.k.g, a.b.g.k.t
    public void setSupportBackgroundTintList(ColorStateList colorStateList) {
        if (b()) {
            this.f232c.c(colorStateList);
        } else if (this.f232c != null) {
            super.setSupportBackgroundTintList(colorStateList);
        }
    }

    @Override // a.b.h.k.g, a.b.g.k.t
    public void setSupportBackgroundTintMode(PorterDuff.Mode mode) {
        if (b()) {
            this.f232c.a(mode);
        } else if (this.f232c != null) {
            super.setSupportBackgroundTintMode(mode);
        }
    }

    public a(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        TypedArray c2 = a.b.d.q.g.c(context, attributeSet, k.MaterialButton, i2, j.Widget_MaterialComponents_Button, new int[0]);
        this.f233d = c2.getDimensionPixelSize(k.MaterialButton_iconPadding, 0);
        this.f234e = h.a(c2.getInt(k.MaterialButton_iconTintMode, -1), PorterDuff.Mode.SRC_IN);
        this.f235f = a.b.d.r.a.a(getContext(), c2, k.MaterialButton_iconTint);
        this.f236g = a.b.d.r.a.b(getContext(), c2, k.MaterialButton_icon);
        this.j = c2.getInteger(k.MaterialButton_iconGravity, 1);
        this.f237h = c2.getDimensionPixelSize(k.MaterialButton_iconSize, 0);
        this.f232c = new c(this);
        this.f232c.a(c2);
        c2.recycle();
        setCompoundDrawablePadding(this.f233d);
        c();
    }
}
