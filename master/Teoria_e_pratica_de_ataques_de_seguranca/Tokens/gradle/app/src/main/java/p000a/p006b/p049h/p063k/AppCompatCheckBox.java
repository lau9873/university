package p000a.p006b.p049h.p063k;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.CheckBox;
import p000a.p006b.p030g.p048l.TintableCompoundButton;
import p000a.p006b.p049h.p051b.C0354a;
import p000a.p006b.p049h.p053d.p054a.AppCompatResources;

/* renamed from: a.b.h.k.h */
/* loaded from: classes.dex */
public class AppCompatCheckBox extends CheckBox implements TintableCompoundButton {

    /* renamed from: a */
    public final AppCompatCompoundButtonHelper f2649a;

    public AppCompatCheckBox(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, C0354a.checkboxStyle);
    }

    @Override // android.widget.CompoundButton, android.widget.TextView
    public int getCompoundPaddingLeft() {
        int compoundPaddingLeft = super.getCompoundPaddingLeft();
        AppCompatCompoundButtonHelper appCompatCompoundButtonHelper = this.f2649a;
        return appCompatCompoundButtonHelper != null ? appCompatCompoundButtonHelper.m8340a(compoundPaddingLeft) : compoundPaddingLeft;
    }

    public ColorStateList getSupportButtonTintList() {
        AppCompatCompoundButtonHelper appCompatCompoundButtonHelper = this.f2649a;
        if (appCompatCompoundButtonHelper != null) {
            return appCompatCompoundButtonHelper.m8336b();
        }
        return null;
    }

    public PorterDuff.Mode getSupportButtonTintMode() {
        AppCompatCompoundButtonHelper appCompatCompoundButtonHelper = this.f2649a;
        if (appCompatCompoundButtonHelper != null) {
            return appCompatCompoundButtonHelper.m8335c();
        }
        return null;
    }

    @Override // android.widget.CompoundButton
    public void setButtonDrawable(Drawable drawable) {
        super.setButtonDrawable(drawable);
        AppCompatCompoundButtonHelper appCompatCompoundButtonHelper = this.f2649a;
        if (appCompatCompoundButtonHelper != null) {
            appCompatCompoundButtonHelper.m8334d();
        }
    }

    @Override // p000a.p006b.p030g.p048l.TintableCompoundButton
    public void setSupportButtonTintList(ColorStateList colorStateList) {
        AppCompatCompoundButtonHelper appCompatCompoundButtonHelper = this.f2649a;
        if (appCompatCompoundButtonHelper != null) {
            appCompatCompoundButtonHelper.m8339a(colorStateList);
        }
    }

    @Override // p000a.p006b.p030g.p048l.TintableCompoundButton
    public void setSupportButtonTintMode(PorterDuff.Mode mode) {
        AppCompatCompoundButtonHelper appCompatCompoundButtonHelper = this.f2649a;
        if (appCompatCompoundButtonHelper != null) {
            appCompatCompoundButtonHelper.m8338a(mode);
        }
    }

    public AppCompatCheckBox(Context context, AttributeSet attributeSet, int i) {
        super(TintContextWrapper.m8342b(context), attributeSet, i);
        this.f2649a = new AppCompatCompoundButtonHelper(this);
        this.f2649a.m8337a(attributeSet, i);
    }

    @Override // android.widget.CompoundButton
    public void setButtonDrawable(int i) {
        setButtonDrawable(AppCompatResources.m8967c(getContext(), i));
    }
}
