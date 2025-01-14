package a.b.g.l;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.View;
/* compiled from: Space.java */
@Deprecated
/* loaded from: classes.dex */
public class o extends View {
    @Deprecated
    public o(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        if (getVisibility() == 0) {
            setVisibility(4);
        }
    }

    public static int a(int i2, int i3) {
        int mode = View.MeasureSpec.getMode(i3);
        int size = View.MeasureSpec.getSize(i3);
        if (mode != Integer.MIN_VALUE) {
            return (mode == 0 || mode != 1073741824) ? i2 : size;
        }
        return Math.min(i2, size);
    }

    @Override // android.view.View
    @SuppressLint({"MissingSuperCall"})
    @Deprecated
    public void draw(Canvas canvas) {
    }

    @Override // android.view.View
    @Deprecated
    public void onMeasure(int i2, int i3) {
        setMeasuredDimension(a(getSuggestedMinimumWidth(), i2), a(getSuggestedMinimumHeight(), i3));
    }

    @Deprecated
    public o(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    @Deprecated
    public o(Context context) {
        this(context, null);
    }
}
