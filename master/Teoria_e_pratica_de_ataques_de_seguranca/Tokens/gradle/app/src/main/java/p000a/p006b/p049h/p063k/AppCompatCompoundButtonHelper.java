package p000a.p006b.p049h.p063k;

import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.AttributeSet;
import android.widget.CompoundButton;
import p000a.p006b.p030g.p034c.p035j.DrawableCompat;
import p000a.p006b.p030g.p048l.CompoundButtonCompat;
import p000a.p006b.p049h.p051b.C0363j;
import p000a.p006b.p049h.p053d.p054a.AppCompatResources;

/* renamed from: a.b.h.k.j */
/* loaded from: classes.dex */
public class AppCompatCompoundButtonHelper {

    /* renamed from: a */
    public final CompoundButton f2656a;

    /* renamed from: b */
    public ColorStateList f2657b = null;

    /* renamed from: c */
    public PorterDuff.Mode f2658c = null;

    /* renamed from: d */
    public boolean f2659d = false;

    /* renamed from: e */
    public boolean f2660e = false;

    /* renamed from: f */
    public boolean f2661f;

    public AppCompatCompoundButtonHelper(CompoundButton compoundButton) {
        this.f2656a = compoundButton;
    }

    /* renamed from: a */
    public void m8337a(AttributeSet attributeSet, int i) {
        int resourceId;
        TypedArray obtainStyledAttributes = this.f2656a.getContext().obtainStyledAttributes(attributeSet, C0363j.CompoundButton, i, 0);
        try {
            if (obtainStyledAttributes.hasValue(C0363j.CompoundButton_android_button) && (resourceId = obtainStyledAttributes.getResourceId(C0363j.CompoundButton_android_button, 0)) != 0) {
                this.f2656a.setButtonDrawable(AppCompatResources.m8967c(this.f2656a.getContext(), resourceId));
            }
            if (obtainStyledAttributes.hasValue(C0363j.CompoundButton_buttonTint)) {
                CompoundButtonCompat.m9249a(this.f2656a, obtainStyledAttributes.getColorStateList(C0363j.CompoundButton_buttonTint));
            }
            if (obtainStyledAttributes.hasValue(C0363j.CompoundButton_buttonTintMode)) {
                CompoundButtonCompat.m9248a(this.f2656a, C0475k0.m8284a(obtainStyledAttributes.getInt(C0363j.CompoundButton_buttonTintMode, -1), null));
            }
        } finally {
            obtainStyledAttributes.recycle();
        }
    }

    /* renamed from: b */
    public ColorStateList m8336b() {
        return this.f2657b;
    }

    /* renamed from: c */
    public PorterDuff.Mode m8335c() {
        return this.f2658c;
    }

    /* renamed from: d */
    public void m8334d() {
        if (this.f2661f) {
            this.f2661f = false;
            return;
        }
        this.f2661f = true;
        m8341a();
    }

    /* renamed from: a */
    public void m8339a(ColorStateList colorStateList) {
        this.f2657b = colorStateList;
        this.f2659d = true;
        m8341a();
    }

    /* renamed from: a */
    public void m8338a(PorterDuff.Mode mode) {
        this.f2658c = mode;
        this.f2660e = true;
        m8341a();
    }

    /* renamed from: a */
    public void m8341a() {
        Drawable m9250a = CompoundButtonCompat.m9250a(this.f2656a);
        if (m9250a != null) {
            if (this.f2659d || this.f2660e) {
                Drawable mutate = DrawableCompat.m9848i(m9250a).mutate();
                if (this.f2659d) {
                    DrawableCompat.m9861a(mutate, this.f2657b);
                }
                if (this.f2660e) {
                    DrawableCompat.m9858a(mutate, this.f2658c);
                }
                if (mutate.isStateful()) {
                    mutate.setState(this.f2656a.getDrawableState());
                }
                this.f2656a.setButtonDrawable(mutate);
            }
        }
    }

    /* renamed from: a */
    public int m8340a(int i) {
        Drawable m9250a;
        return (Build.VERSION.SDK_INT >= 17 || (m9250a = CompoundButtonCompat.m9250a(this.f2656a)) == null) ? i : i + m9250a.getIntrinsicWidth();
    }
}
