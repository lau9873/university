package p000a.p006b.p049h.p063k;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.widget.SeekBar;
import p000a.p006b.p049h.p051b.C0354a;

/* renamed from: a.b.h.k.v */
/* loaded from: classes.dex */
public class AppCompatSeekBar extends SeekBar {

    /* renamed from: a */
    public final AppCompatSeekBarHelper f2968a;

    public AppCompatSeekBar(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, C0354a.seekBarStyle);
    }

    @Override // android.widget.AbsSeekBar, android.widget.ProgressBar, android.view.View
    public void drawableStateChanged() {
        super.drawableStateChanged();
        this.f2968a.m8024d();
    }

    @Override // android.widget.AbsSeekBar, android.widget.ProgressBar, android.view.View
    public void jumpDrawablesToCurrentState() {
        super.jumpDrawablesToCurrentState();
        this.f2968a.m8023e();
    }

    @Override // android.widget.AbsSeekBar, android.widget.ProgressBar, android.view.View
    public synchronized void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        this.f2968a.m8028a(canvas);
    }

    public AppCompatSeekBar(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f2968a = new AppCompatSeekBarHelper(this);
        this.f2968a.mo8027a(attributeSet, i);
    }
}
