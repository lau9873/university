package android.support.constraint;

import android.content.Context;
import android.graphics.Canvas;
import android.support.constraint.ConstraintLayout;
import android.util.AttributeSet;
import android.view.View;

/* loaded from: classes.dex */
public class Guideline extends View {
    public Guideline(Context context) {
        super(context);
        super.setVisibility(8);
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
    }

    @Override // android.view.View
    public void onMeasure(int i, int i2) {
        setMeasuredDimension(0, 0);
    }

    public void setGuidelineBegin(int i) {
        ConstraintLayout.C0520a c0520a = (ConstraintLayout.C0520a) getLayoutParams();
        c0520a.f3096a = i;
        setLayoutParams(c0520a);
    }

    public void setGuidelineEnd(int i) {
        ConstraintLayout.C0520a c0520a = (ConstraintLayout.C0520a) getLayoutParams();
        c0520a.f3098b = i;
        setLayoutParams(c0520a);
    }

    public void setGuidelinePercent(float f) {
        ConstraintLayout.C0520a c0520a = (ConstraintLayout.C0520a) getLayoutParams();
        c0520a.f3100c = f;
        setLayoutParams(c0520a);
    }

    @Override // android.view.View
    public void setVisibility(int i) {
    }

    public Guideline(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        super.setVisibility(8);
    }

    public Guideline(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        super.setVisibility(8);
    }

    public Guideline(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i);
        super.setVisibility(8);
    }
}
