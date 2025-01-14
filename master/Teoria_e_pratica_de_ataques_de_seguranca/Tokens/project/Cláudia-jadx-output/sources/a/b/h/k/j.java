package a.b.h.k;

import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.AttributeSet;
import android.widget.CompoundButton;
/* compiled from: AppCompatCompoundButtonHelper.java */
/* loaded from: classes.dex */
public class j {

    /* renamed from: a  reason: collision with root package name */
    public final CompoundButton f1745a;

    /* renamed from: b  reason: collision with root package name */
    public ColorStateList f1746b = null;

    /* renamed from: c  reason: collision with root package name */
    public PorterDuff.Mode f1747c = null;

    /* renamed from: d  reason: collision with root package name */
    public boolean f1748d = false;

    /* renamed from: e  reason: collision with root package name */
    public boolean f1749e = false;

    /* renamed from: f  reason: collision with root package name */
    public boolean f1750f;

    public j(CompoundButton compoundButton) {
        this.f1745a = compoundButton;
    }

    public void a(AttributeSet attributeSet, int i2) {
        int resourceId;
        TypedArray obtainStyledAttributes = this.f1745a.getContext().obtainStyledAttributes(attributeSet, a.b.h.b.j.CompoundButton, i2, 0);
        try {
            if (obtainStyledAttributes.hasValue(a.b.h.b.j.CompoundButton_android_button) && (resourceId = obtainStyledAttributes.getResourceId(a.b.h.b.j.CompoundButton_android_button, 0)) != 0) {
                this.f1745a.setButtonDrawable(a.b.h.d.a.a.c(this.f1745a.getContext(), resourceId));
            }
            if (obtainStyledAttributes.hasValue(a.b.h.b.j.CompoundButton_buttonTint)) {
                a.b.g.l.e.a(this.f1745a, obtainStyledAttributes.getColorStateList(a.b.h.b.j.CompoundButton_buttonTint));
            }
            if (obtainStyledAttributes.hasValue(a.b.h.b.j.CompoundButton_buttonTintMode)) {
                a.b.g.l.e.a(this.f1745a, k0.a(obtainStyledAttributes.getInt(a.b.h.b.j.CompoundButton_buttonTintMode, -1), null));
            }
        } finally {
            obtainStyledAttributes.recycle();
        }
    }

    public ColorStateList b() {
        return this.f1746b;
    }

    public PorterDuff.Mode c() {
        return this.f1747c;
    }

    public void d() {
        if (this.f1750f) {
            this.f1750f = false;
            return;
        }
        this.f1750f = true;
        a();
    }

    public void a(ColorStateList colorStateList) {
        this.f1746b = colorStateList;
        this.f1748d = true;
        a();
    }

    public void a(PorterDuff.Mode mode) {
        this.f1747c = mode;
        this.f1749e = true;
        a();
    }

    public void a() {
        Drawable a2 = a.b.g.l.e.a(this.f1745a);
        if (a2 != null) {
            if (this.f1748d || this.f1749e) {
                Drawable mutate = a.b.g.c.j.a.i(a2).mutate();
                if (this.f1748d) {
                    a.b.g.c.j.a.a(mutate, this.f1746b);
                }
                if (this.f1749e) {
                    a.b.g.c.j.a.a(mutate, this.f1747c);
                }
                if (mutate.isStateful()) {
                    mutate.setState(this.f1745a.getDrawableState());
                }
                this.f1745a.setButtonDrawable(mutate);
            }
        }
    }

    public int a(int i2) {
        Drawable a2;
        return (Build.VERSION.SDK_INT >= 17 || (a2 = a.b.g.l.e.a(this.f1745a)) == null) ? i2 : i2 + a2.getIntrinsicWidth();
    }
}
