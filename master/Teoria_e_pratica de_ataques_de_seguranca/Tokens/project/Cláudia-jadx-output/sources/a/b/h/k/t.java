package a.b.h.k;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.RadioButton;
/* compiled from: AppCompatRadioButton.java */
/* loaded from: classes.dex */
public class t extends RadioButton implements a.b.g.l.q {

    /* renamed from: a  reason: collision with root package name */
    public final j f1963a;

    /* renamed from: b  reason: collision with root package name */
    public final y f1964b;

    public t(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, a.b.h.b.a.radioButtonStyle);
    }

    @Override // android.widget.CompoundButton, android.widget.TextView
    public int getCompoundPaddingLeft() {
        int compoundPaddingLeft = super.getCompoundPaddingLeft();
        j jVar = this.f1963a;
        return jVar != null ? jVar.a(compoundPaddingLeft) : compoundPaddingLeft;
    }

    public ColorStateList getSupportButtonTintList() {
        j jVar = this.f1963a;
        if (jVar != null) {
            return jVar.b();
        }
        return null;
    }

    public PorterDuff.Mode getSupportButtonTintMode() {
        j jVar = this.f1963a;
        if (jVar != null) {
            return jVar.c();
        }
        return null;
    }

    @Override // android.widget.CompoundButton
    public void setButtonDrawable(Drawable drawable) {
        super.setButtonDrawable(drawable);
        j jVar = this.f1963a;
        if (jVar != null) {
            jVar.d();
        }
    }

    @Override // a.b.g.l.q
    public void setSupportButtonTintList(ColorStateList colorStateList) {
        j jVar = this.f1963a;
        if (jVar != null) {
            jVar.a(colorStateList);
        }
    }

    @Override // a.b.g.l.q
    public void setSupportButtonTintMode(PorterDuff.Mode mode) {
        j jVar = this.f1963a;
        if (jVar != null) {
            jVar.a(mode);
        }
    }

    public t(Context context, AttributeSet attributeSet, int i2) {
        super(i1.b(context), attributeSet, i2);
        this.f1963a = new j(this);
        this.f1963a.a(attributeSet, i2);
        this.f1964b = new y(this);
        this.f1964b.a(attributeSet, i2);
    }

    @Override // android.widget.CompoundButton
    public void setButtonDrawable(int i2) {
        setButtonDrawable(a.b.h.d.a.a.c(getContext(), i2));
    }
}
