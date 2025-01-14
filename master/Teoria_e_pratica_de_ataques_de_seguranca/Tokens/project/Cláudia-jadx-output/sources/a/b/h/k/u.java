package a.b.h.k;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.AttributeSet;
import android.view.View;
import android.widget.RatingBar;
/* compiled from: AppCompatRatingBar.java */
/* loaded from: classes.dex */
public class u extends RatingBar {

    /* renamed from: a  reason: collision with root package name */
    public final s f1966a;

    public u(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, a.b.h.b.a.ratingBarStyle);
    }

    @Override // android.widget.RatingBar, android.widget.AbsSeekBar, android.widget.ProgressBar, android.view.View
    public synchronized void onMeasure(int i2, int i3) {
        super.onMeasure(i2, i3);
        Bitmap b2 = this.f1966a.b();
        if (b2 != null) {
            setMeasuredDimension(View.resolveSizeAndState(b2.getWidth() * getNumStars(), i2, 0), getMeasuredHeight());
        }
    }

    public u(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.f1966a = new s(this);
        this.f1966a.a(attributeSet, i2);
    }
}
