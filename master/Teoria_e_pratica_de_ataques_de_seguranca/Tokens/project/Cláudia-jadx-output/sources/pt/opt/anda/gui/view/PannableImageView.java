package pt.opt.anda.gui.view;

import a.b.h.k.p;
import android.content.Context;
import android.graphics.Matrix;
import android.support.annotation.Keep;
import android.util.AttributeSet;
/* loaded from: classes.dex */
public class PannableImageView extends p {

    /* renamed from: c  reason: collision with root package name */
    public final Matrix f7786c;

    /* renamed from: d  reason: collision with root package name */
    public float f7787d;

    public PannableImageView(Context context) {
        super(context);
        this.f7786c = new Matrix();
    }

    public int getBottomBorder() {
        return (int) (getDrawable().getIntrinsicHeight() * 0.24f);
    }

    public int getBridgePosition() {
        return (int) (getDrawable().getIntrinsicHeight() * 0.558f);
    }

    @Keep
    public float getPanningX() {
        return this.f7787d;
    }

    @Keep
    public void setPanningX(float f2) {
        this.f7787d = f2;
        Matrix matrix = this.f7786c;
        matrix.reset();
        matrix.setTranslate((-(getDrawable().getIntrinsicWidth() - getWidth())) * f2, 0.0f);
        setImageMatrix(matrix);
    }

    public PannableImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f7786c = new Matrix();
    }

    public PannableImageView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.f7786c = new Matrix();
    }
}
