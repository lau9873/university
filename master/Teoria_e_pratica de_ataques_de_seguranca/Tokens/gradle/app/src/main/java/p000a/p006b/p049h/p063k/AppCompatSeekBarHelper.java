package p000a.p006b.p049h.p063k;

import android.content.res.ColorStateList;
import android.graphics.Canvas;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.SeekBar;
import p000a.p006b.p030g.p034c.p035j.DrawableCompat;
import p000a.p006b.p030g.p045k.ViewCompat;
import p000a.p006b.p049h.p051b.C0363j;

/* renamed from: a.b.h.k.w */
/* loaded from: classes.dex */
public class AppCompatSeekBarHelper extends AppCompatProgressBarHelper {

    /* renamed from: d */
    public final SeekBar f2970d;

    /* renamed from: e */
    public Drawable f2971e;

    /* renamed from: f */
    public ColorStateList f2972f;

    /* renamed from: g */
    public PorterDuff.Mode f2973g;

    /* renamed from: h */
    public boolean f2974h;

    /* renamed from: i */
    public boolean f2975i;

    public AppCompatSeekBarHelper(SeekBar seekBar) {
        super(seekBar);
        this.f2972f = null;
        this.f2973g = null;
        this.f2974h = false;
        this.f2975i = false;
        this.f2970d = seekBar;
    }

    @Override // p000a.p006b.p049h.p063k.AppCompatProgressBarHelper
    /* renamed from: a */
    public void mo8027a(AttributeSet attributeSet, int i) {
        super.mo8027a(attributeSet, i);
        TintTypedArray m8257a = TintTypedArray.m8257a(this.f2970d.getContext(), attributeSet, C0363j.AppCompatSeekBar, i, 0);
        Drawable m8253c = m8257a.m8253c(C0363j.AppCompatSeekBar_android_thumb);
        if (m8253c != null) {
            this.f2970d.setThumb(m8253c);
        }
        m8026b(m8257a.m8256b(C0363j.AppCompatSeekBar_tickMark));
        if (m8257a.m8245g(C0363j.AppCompatSeekBar_tickMarkTintMode)) {
            this.f2973g = C0475k0.m8284a(m8257a.m8250d(C0363j.AppCompatSeekBar_tickMarkTintMode, -1), this.f2973g);
            this.f2975i = true;
        }
        if (m8257a.m8245g(C0363j.AppCompatSeekBar_tickMarkTint)) {
            this.f2972f = m8257a.m8264a(C0363j.AppCompatSeekBar_tickMarkTint);
            this.f2974h = true;
        }
        m8257a.m8265a();
        m8025c();
    }

    /* renamed from: b */
    public void m8026b(Drawable drawable) {
        Drawable drawable2 = this.f2971e;
        if (drawable2 != null) {
            drawable2.setCallback(null);
        }
        this.f2971e = drawable;
        if (drawable != null) {
            drawable.setCallback(this.f2970d);
            DrawableCompat.m9863a(drawable, ViewCompat.m9422k(this.f2970d));
            if (drawable.isStateful()) {
                drawable.setState(this.f2970d.getDrawableState());
            }
            m8025c();
        }
        this.f2970d.invalidate();
    }

    /* renamed from: c */
    public final void m8025c() {
        if (this.f2971e != null) {
            if (this.f2974h || this.f2975i) {
                this.f2971e = DrawableCompat.m9848i(this.f2971e.mutate());
                if (this.f2974h) {
                    DrawableCompat.m9861a(this.f2971e, this.f2972f);
                }
                if (this.f2975i) {
                    DrawableCompat.m9858a(this.f2971e, this.f2973g);
                }
                if (this.f2971e.isStateful()) {
                    this.f2971e.setState(this.f2970d.getDrawableState());
                }
            }
        }
    }

    /* renamed from: d */
    public void m8024d() {
        Drawable drawable = this.f2971e;
        if (drawable != null && drawable.isStateful() && drawable.setState(this.f2970d.getDrawableState())) {
            this.f2970d.invalidateDrawable(drawable);
        }
    }

    /* renamed from: e */
    public void m8023e() {
        Drawable drawable = this.f2971e;
        if (drawable != null) {
            drawable.jumpToCurrentState();
        }
    }

    /* renamed from: a */
    public void m8028a(Canvas canvas) {
        if (this.f2971e != null) {
            int max = this.f2970d.getMax();
            if (max > 1) {
                int intrinsicWidth = this.f2971e.getIntrinsicWidth();
                int intrinsicHeight = this.f2971e.getIntrinsicHeight();
                int i = intrinsicWidth >= 0 ? intrinsicWidth / 2 : 1;
                int i2 = intrinsicHeight >= 0 ? intrinsicHeight / 2 : 1;
                this.f2971e.setBounds(-i, -i2, i, i2);
                float width = ((this.f2970d.getWidth() - this.f2970d.getPaddingLeft()) - this.f2970d.getPaddingRight()) / max;
                int save = canvas.save();
                canvas.translate(this.f2970d.getPaddingLeft(), this.f2970d.getHeight() / 2);
                for (int i3 = 0; i3 <= max; i3++) {
                    this.f2971e.draw(canvas);
                    canvas.translate(width, 0.0f);
                }
                canvas.restoreToCount(save);
            }
        }
    }
}
