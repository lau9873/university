package a.b.h.k;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.widget.SeekBar;
/* compiled from: AppCompatSeekBar.java */
/* loaded from: classes.dex */
public class v extends SeekBar {

    /* renamed from: a  reason: collision with root package name */
    public final w f1967a;

    public v(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, a.b.h.b.a.seekBarStyle);
    }

    @Override // android.widget.AbsSeekBar, android.widget.ProgressBar, android.view.View
    public void drawableStateChanged() {
        super.drawableStateChanged();
        this.f1967a.d();
    }

    @Override // android.widget.AbsSeekBar, android.widget.ProgressBar, android.view.View
    public void jumpDrawablesToCurrentState() {
        super.jumpDrawablesToCurrentState();
        this.f1967a.e();
    }

    @Override // android.widget.AbsSeekBar, android.widget.ProgressBar, android.view.View
    public synchronized void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        this.f1967a.a(canvas);
    }

    public v(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.f1967a = new w(this);
        this.f1967a.a(attributeSet, i2);
    }
}
