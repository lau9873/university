package p000a.p006b.p049h.p063k;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.RadioButton;
import p000a.p006b.p030g.p048l.TintableCompoundButton;
import p000a.p006b.p049h.p051b.C0354a;
import p000a.p006b.p049h.p053d.p054a.AppCompatResources;

/* renamed from: a.b.h.k.t */
/* loaded from: classes.dex */
public class AppCompatRadioButton extends RadioButton implements TintableCompoundButton {

    /* renamed from: a */
    public final AppCompatCompoundButtonHelper f2958a;

    /* renamed from: b */
    public final AppCompatTextHelper f2959b;

    public AppCompatRadioButton(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, C0354a.radioButtonStyle);
    }

    @Override // android.widget.CompoundButton, android.widget.TextView
    public int getCompoundPaddingLeft() {
        int compoundPaddingLeft = super.getCompoundPaddingLeft();
        AppCompatCompoundButtonHelper appCompatCompoundButtonHelper = this.f2958a;
        return appCompatCompoundButtonHelper != null ? appCompatCompoundButtonHelper.m8340a(compoundPaddingLeft) : compoundPaddingLeft;
    }

    public ColorStateList getSupportButtonTintList() {
        AppCompatCompoundButtonHelper appCompatCompoundButtonHelper = this.f2958a;
        if (appCompatCompoundButtonHelper != null) {
            return appCompatCompoundButtonHelper.m8336b();
        }
        return null;
    }

    public PorterDuff.Mode getSupportButtonTintMode() {
        AppCompatCompoundButtonHelper appCompatCompoundButtonHelper = this.f2958a;
        if (appCompatCompoundButtonHelper != null) {
            return appCompatCompoundButtonHelper.m8335c();
        }
        return null;
    }

    @Override // android.widget.CompoundButton
    public void setButtonDrawable(Drawable drawable) {
        super.setButtonDrawable(drawable);
        AppCompatCompoundButtonHelper appCompatCompoundButtonHelper = this.f2958a;
        if (appCompatCompoundButtonHelper != null) {
            appCompatCompoundButtonHelper.m8334d();
        }
    }

    @Override // p000a.p006b.p030g.p048l.TintableCompoundButton
    public void setSupportButtonTintList(ColorStateList colorStateList) {
        AppCompatCompoundButtonHelper appCompatCompoundButtonHelper = this.f2958a;
        if (appCompatCompoundButtonHelper != null) {
            appCompatCompoundButtonHelper.m8339a(colorStateList);
        }
    }

    @Override // p000a.p006b.p030g.p048l.TintableCompoundButton
    public void setSupportButtonTintMode(PorterDuff.Mode mode) {
        AppCompatCompoundButtonHelper appCompatCompoundButtonHelper = this.f2958a;
        if (appCompatCompoundButtonHelper != null) {
            appCompatCompoundButtonHelper.m8338a(mode);
        }
    }

    public AppCompatRadioButton(Context context, AttributeSet attributeSet, int i) {
        super(TintContextWrapper.m8342b(context), attributeSet, i);
        this.f2958a = new AppCompatCompoundButtonHelper(this);
        this.f2958a.m8337a(attributeSet, i);
        this.f2959b = new AppCompatTextHelper(this);
        this.f2959b.m7985a(attributeSet, i);
    }

    @Override // android.widget.CompoundButton
    public void setButtonDrawable(int i) {
        setButtonDrawable(AppCompatResources.m8967c(getContext(), i));
    }
}
