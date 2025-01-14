package pt.opt.anda.gui.view;

import android.content.Context;
import android.graphics.Matrix;
import android.support.annotation.Keep;
import android.util.AttributeSet;
import p000a.p006b.p049h.p063k.AppCompatImageView;

/* loaded from: classes.dex */
public class PannableImageView extends AppCompatImageView {

    /* renamed from: c */
    public final Matrix f10932c;

    /* renamed from: d */
    public float f10933d;

    public PannableImageView(Context context) {
        super(context);
        this.f10932c = new Matrix();
    }

    public int getBottomBorder() {
        return (int) (getDrawable().getIntrinsicHeight() * 0.24f);
    }

    public int getBridgePosition() {
        return (int) (getDrawable().getIntrinsicHeight() * 0.558f);
    }

    @Keep
    public float getPanningX() {
        return this.f10933d;
    }

    @Keep
    public void setPanningX(float f) {
        this.f10933d = f;
        Matrix matrix = this.f10932c;
        matrix.reset();
        matrix.setTranslate((-(getDrawable().getIntrinsicWidth() - getWidth())) * f, 0.0f);
        setImageMatrix(matrix);
    }

    public PannableImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f10932c = new Matrix();
    }

    public PannableImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f10932c = new Matrix();
    }
}
