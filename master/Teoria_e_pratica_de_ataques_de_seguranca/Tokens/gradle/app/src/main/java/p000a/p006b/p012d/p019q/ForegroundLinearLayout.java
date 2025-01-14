package p000a.p006b.p012d.p019q;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.Gravity;
import p000a.p006b.p012d.C0049k;
import p000a.p006b.p049h.p063k.LinearLayoutCompat;

/* renamed from: a.b.d.q.e */
/* loaded from: classes.dex */
public class ForegroundLinearLayout extends LinearLayoutCompat {

    /* renamed from: q */
    public Drawable f533q;

    /* renamed from: r */
    public final Rect f534r;

    /* renamed from: s */
    public final Rect f535s;

    /* renamed from: t */
    public int f536t;

    /* renamed from: u */
    public boolean f537u;

    /* renamed from: v */
    public boolean f538v;

    public ForegroundLinearLayout(Context context) {
        this(context, null);
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        super.draw(canvas);
        Drawable drawable = this.f533q;
        if (drawable != null) {
            if (this.f538v) {
                this.f538v = false;
                Rect rect = this.f534r;
                Rect rect2 = this.f535s;
                int right = getRight() - getLeft();
                int bottom = getBottom() - getTop();
                if (this.f537u) {
                    rect.set(0, 0, right, bottom);
                } else {
                    rect.set(getPaddingLeft(), getPaddingTop(), right - getPaddingRight(), bottom - getPaddingBottom());
                }
                Gravity.apply(this.f536t, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight(), rect, rect2);
                drawable.setBounds(rect2);
            }
            drawable.draw(canvas);
        }
    }

    @Override // android.view.View
    @TargetApi(21)
    public void drawableHotspotChanged(float f, float f2) {
        super.drawableHotspotChanged(f, f2);
        Drawable drawable = this.f533q;
        if (drawable != null) {
            drawable.setHotspot(f, f2);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void drawableStateChanged() {
        super.drawableStateChanged();
        Drawable drawable = this.f533q;
        if (drawable == null || !drawable.isStateful()) {
            return;
        }
        this.f533q.setState(getDrawableState());
    }

    @Override // android.view.View
    public Drawable getForeground() {
        return this.f533q;
    }

    @Override // android.view.View
    public int getForegroundGravity() {
        return this.f536t;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void jumpDrawablesToCurrentState() {
        super.jumpDrawablesToCurrentState();
        Drawable drawable = this.f533q;
        if (drawable != null) {
            drawable.jumpToCurrentState();
        }
    }

    @Override // p000a.p006b.p049h.p063k.LinearLayoutCompat, android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        this.f538v = z | this.f538v;
    }

    @Override // android.view.View
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        this.f538v = true;
    }

    @Override // android.view.View
    public void setForeground(Drawable drawable) {
        Drawable drawable2 = this.f533q;
        if (drawable2 != drawable) {
            if (drawable2 != null) {
                drawable2.setCallback(null);
                unscheduleDrawable(this.f533q);
            }
            this.f533q = drawable;
            if (drawable != null) {
                setWillNotDraw(false);
                drawable.setCallback(this);
                if (drawable.isStateful()) {
                    drawable.setState(getDrawableState());
                }
                if (this.f536t == 119) {
                    drawable.getPadding(new Rect());
                }
            } else {
                setWillNotDraw(true);
            }
            requestLayout();
            invalidate();
        }
    }

    @Override // android.view.View
    public void setForegroundGravity(int i) {
        if (this.f536t != i) {
            if ((8388615 & i) == 0) {
                i |= 8388611;
            }
            if ((i & 112) == 0) {
                i |= 48;
            }
            this.f536t = i;
            if (this.f536t == 119 && this.f533q != null) {
                this.f533q.getPadding(new Rect());
            }
            requestLayout();
        }
    }

    @Override // android.view.View
    public boolean verifyDrawable(Drawable drawable) {
        return super.verifyDrawable(drawable) || drawable == this.f533q;
    }

    public ForegroundLinearLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ForegroundLinearLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f534r = new Rect();
        this.f535s = new Rect();
        this.f536t = 119;
        this.f537u = true;
        this.f538v = false;
        TypedArray m10861c = ThemeEnforcement.m10861c(context, attributeSet, C0049k.ForegroundLinearLayout, i, 0, new int[0]);
        this.f536t = m10861c.getInt(C0049k.ForegroundLinearLayout_android_foregroundGravity, this.f536t);
        Drawable drawable = m10861c.getDrawable(C0049k.ForegroundLinearLayout_android_foreground);
        if (drawable != null) {
            setForeground(drawable);
        }
        this.f537u = m10861c.getBoolean(C0049k.ForegroundLinearLayout_foregroundInsidePadding, true);
        m10861c.recycle();
    }
}
