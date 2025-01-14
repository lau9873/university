package p000a.p006b.p049h.p063k;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.AttributeSet;
import android.view.View;
import android.widget.RatingBar;
import p000a.p006b.p049h.p051b.C0354a;

/* renamed from: a.b.h.k.u */
/* loaded from: classes.dex */
public class AppCompatRatingBar extends RatingBar {

    /* renamed from: a */
    public final AppCompatProgressBarHelper f2961a;

    public AppCompatRatingBar(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, C0354a.ratingBarStyle);
    }

    @Override // android.widget.RatingBar, android.widget.AbsSeekBar, android.widget.ProgressBar, android.view.View
    public synchronized void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        Bitmap m8098b = this.f2961a.m8098b();
        if (m8098b != null) {
            setMeasuredDimension(View.resolveSizeAndState(m8098b.getWidth() * getNumStars(), i, 0), getMeasuredHeight());
        }
    }

    public AppCompatRatingBar(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f2961a = new AppCompatProgressBarHelper(this);
        this.f2961a.mo8027a(attributeSet, i);
    }
}
