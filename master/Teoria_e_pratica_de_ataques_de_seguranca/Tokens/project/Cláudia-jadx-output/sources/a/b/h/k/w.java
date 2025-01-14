package a.b.h.k;

import android.content.res.ColorStateList;
import android.graphics.Canvas;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.SeekBar;
/* compiled from: AppCompatSeekBarHelper.java */
/* loaded from: classes.dex */
public class w extends s {

    /* renamed from: d  reason: collision with root package name */
    public final SeekBar f1969d;

    /* renamed from: e  reason: collision with root package name */
    public Drawable f1970e;

    /* renamed from: f  reason: collision with root package name */
    public ColorStateList f1971f;

    /* renamed from: g  reason: collision with root package name */
    public PorterDuff.Mode f1972g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f1973h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f1974i;

    public w(SeekBar seekBar) {
        super(seekBar);
        this.f1971f = null;
        this.f1972g = null;
        this.f1973h = false;
        this.f1974i = false;
        this.f1969d = seekBar;
    }

    @Override // a.b.h.k.s
    public void a(AttributeSet attributeSet, int i2) {
        super.a(attributeSet, i2);
        l1 a2 = l1.a(this.f1969d.getContext(), attributeSet, a.b.h.b.j.AppCompatSeekBar, i2, 0);
        Drawable c2 = a2.c(a.b.h.b.j.AppCompatSeekBar_android_thumb);
        if (c2 != null) {
            this.f1969d.setThumb(c2);
        }
        b(a2.b(a.b.h.b.j.AppCompatSeekBar_tickMark));
        if (a2.g(a.b.h.b.j.AppCompatSeekBar_tickMarkTintMode)) {
            this.f1972g = k0.a(a2.d(a.b.h.b.j.AppCompatSeekBar_tickMarkTintMode, -1), this.f1972g);
            this.f1974i = true;
        }
        if (a2.g(a.b.h.b.j.AppCompatSeekBar_tickMarkTint)) {
            this.f1971f = a2.a(a.b.h.b.j.AppCompatSeekBar_tickMarkTint);
            this.f1973h = true;
        }
        a2.a();
        c();
    }

    public void b(Drawable drawable) {
        Drawable drawable2 = this.f1970e;
        if (drawable2 != null) {
            drawable2.setCallback(null);
        }
        this.f1970e = drawable;
        if (drawable != null) {
            drawable.setCallback(this.f1969d);
            a.b.g.c.j.a.a(drawable, a.b.g.k.u.k(this.f1969d));
            if (drawable.isStateful()) {
                drawable.setState(this.f1969d.getDrawableState());
            }
            c();
        }
        this.f1969d.invalidate();
    }

    public final void c() {
        if (this.f1970e != null) {
            if (this.f1973h || this.f1974i) {
                this.f1970e = a.b.g.c.j.a.i(this.f1970e.mutate());
                if (this.f1973h) {
                    a.b.g.c.j.a.a(this.f1970e, this.f1971f);
                }
                if (this.f1974i) {
                    a.b.g.c.j.a.a(this.f1970e, this.f1972g);
                }
                if (this.f1970e.isStateful()) {
                    this.f1970e.setState(this.f1969d.getDrawableState());
                }
            }
        }
    }

    public void d() {
        Drawable drawable = this.f1970e;
        if (drawable != null && drawable.isStateful() && drawable.setState(this.f1969d.getDrawableState())) {
            this.f1969d.invalidateDrawable(drawable);
        }
    }

    public void e() {
        Drawable drawable = this.f1970e;
        if (drawable != null) {
            drawable.jumpToCurrentState();
        }
    }

    public void a(Canvas canvas) {
        if (this.f1970e != null) {
            int max = this.f1969d.getMax();
            if (max > 1) {
                int intrinsicWidth = this.f1970e.getIntrinsicWidth();
                int intrinsicHeight = this.f1970e.getIntrinsicHeight();
                int i2 = intrinsicWidth >= 0 ? intrinsicWidth / 2 : 1;
                int i3 = intrinsicHeight >= 0 ? intrinsicHeight / 2 : 1;
                this.f1970e.setBounds(-i2, -i3, i2, i3);
                float width = ((this.f1969d.getWidth() - this.f1969d.getPaddingLeft()) - this.f1969d.getPaddingRight()) / max;
                int save = canvas.save();
                canvas.translate(this.f1969d.getPaddingLeft(), this.f1969d.getHeight() / 2);
                for (int i4 = 0; i4 <= max; i4++) {
                    this.f1970e.draw(canvas);
                    canvas.translate(width, 0.0f);
                }
                canvas.restoreToCount(save);
            }
        }
    }
}
