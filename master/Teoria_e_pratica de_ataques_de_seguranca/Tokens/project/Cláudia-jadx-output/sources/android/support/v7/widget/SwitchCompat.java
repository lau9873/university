package android.support.v7.widget;

import a.b.g.k.u;
import a.b.g.l.p;
import a.b.h.b.j;
import a.b.h.k.k0;
import a.b.h.k.l1;
import a.b.h.k.t1;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.Region;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.text.Layout;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.method.TransformationMethod;
import android.util.AttributeSet;
import android.util.Property;
import android.view.ActionMode;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.ViewConfiguration;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.CompoundButton;
/* loaded from: classes.dex */
public class SwitchCompat extends CompoundButton {
    public static final Property<SwitchCompat, Float> N = new a(Float.class, "thumbPos");
    public static final int[] O = {16842912};
    public int A;
    public int B;
    public int C;
    public int D;
    public int E;
    public int F;
    public final TextPaint G;
    public ColorStateList H;
    public Layout I;
    public Layout J;
    public TransformationMethod K;
    public ObjectAnimator L;
    public final Rect M;

    /* renamed from: a  reason: collision with root package name */
    public Drawable f2694a;

    /* renamed from: b  reason: collision with root package name */
    public ColorStateList f2695b;

    /* renamed from: c  reason: collision with root package name */
    public PorterDuff.Mode f2696c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f2697d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f2698e;

    /* renamed from: f  reason: collision with root package name */
    public Drawable f2699f;

    /* renamed from: g  reason: collision with root package name */
    public ColorStateList f2700g;

    /* renamed from: h  reason: collision with root package name */
    public PorterDuff.Mode f2701h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f2702i;
    public boolean j;
    public int k;
    public int m;
    public int n;
    public boolean o;
    public CharSequence p;
    public CharSequence q;
    public boolean r;
    public int s;
    public int t;
    public float u;
    public float v;
    public VelocityTracker w;
    public int x;
    public float y;
    public int z;

    /* loaded from: classes.dex */
    public static class a extends Property<SwitchCompat, Float> {
        public a(Class cls, String str) {
            super(cls, str);
        }

        @Override // android.util.Property
        /* renamed from: a */
        public Float get(SwitchCompat switchCompat) {
            return Float.valueOf(switchCompat.y);
        }

        @Override // android.util.Property
        /* renamed from: a */
        public void set(SwitchCompat switchCompat, Float f2) {
            switchCompat.setThumbPosition(f2.floatValue());
        }
    }

    public SwitchCompat(Context context) {
        this(context, null);
    }

    public static float a(float f2, float f3, float f4) {
        return f2 < f3 ? f3 : f2 > f4 ? f4 : f2;
    }

    private boolean getTargetCheckedState() {
        return this.y > 0.5f;
    }

    private int getThumbOffset() {
        float f2;
        if (t1.a(this)) {
            f2 = 1.0f - this.y;
        } else {
            f2 = this.y;
        }
        return (int) ((f2 * getThumbScrollRange()) + 0.5f);
    }

    private int getThumbScrollRange() {
        Rect rect;
        Drawable drawable = this.f2699f;
        if (drawable != null) {
            Rect rect2 = this.M;
            drawable.getPadding(rect2);
            Drawable drawable2 = this.f2694a;
            if (drawable2 != null) {
                rect = k0.d(drawable2);
            } else {
                rect = k0.f1805a;
            }
            return ((((this.z - this.B) - rect2.left) - rect2.right) - rect.left) - rect.right;
        }
        return 0;
    }

    public void a(Context context, int i2) {
        l1 a2 = l1.a(context, i2, j.TextAppearance);
        ColorStateList a3 = a2.a(j.TextAppearance_android_textColor);
        if (a3 != null) {
            this.H = a3;
        } else {
            this.H = getTextColors();
        }
        int c2 = a2.c(j.TextAppearance_android_textSize, 0);
        if (c2 != 0) {
            float f2 = c2;
            if (f2 != this.G.getTextSize()) {
                this.G.setTextSize(f2);
                requestLayout();
            }
        }
        a(a2.d(j.TextAppearance_android_typeface, -1), a2.d(j.TextAppearance_android_textStyle, -1));
        if (a2.a(j.TextAppearance_textAllCaps, false)) {
            this.K = new a.b.h.h.a(getContext());
        } else {
            this.K = null;
        }
        a2.a();
    }

    public final void b() {
        if (this.f2699f != null) {
            if (this.f2702i || this.j) {
                this.f2699f = this.f2699f.mutate();
                if (this.f2702i) {
                    a.b.g.c.j.a.a(this.f2699f, this.f2700g);
                }
                if (this.j) {
                    a.b.g.c.j.a.a(this.f2699f, this.f2701h);
                }
                if (this.f2699f.isStateful()) {
                    this.f2699f.setState(getDrawableState());
                }
            }
        }
    }

    public final void c() {
        ObjectAnimator objectAnimator = this.L;
        if (objectAnimator != null) {
            objectAnimator.cancel();
        }
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        Rect rect;
        int i2;
        int i3;
        Rect rect2 = this.M;
        int i4 = this.C;
        int i5 = this.D;
        int i6 = this.E;
        int i7 = this.F;
        int thumbOffset = getThumbOffset() + i4;
        Drawable drawable = this.f2694a;
        if (drawable != null) {
            rect = k0.d(drawable);
        } else {
            rect = k0.f1805a;
        }
        Drawable drawable2 = this.f2699f;
        if (drawable2 != null) {
            drawable2.getPadding(rect2);
            int i8 = rect2.left;
            thumbOffset += i8;
            if (rect != null) {
                int i9 = rect.left;
                if (i9 > i8) {
                    i4 += i9 - i8;
                }
                int i10 = rect.top;
                int i11 = rect2.top;
                i2 = i10 > i11 ? (i10 - i11) + i5 : i5;
                int i12 = rect.right;
                int i13 = rect2.right;
                if (i12 > i13) {
                    i6 -= i12 - i13;
                }
                int i14 = rect.bottom;
                int i15 = rect2.bottom;
                if (i14 > i15) {
                    i3 = i7 - (i14 - i15);
                    this.f2699f.setBounds(i4, i2, i6, i3);
                }
            } else {
                i2 = i5;
            }
            i3 = i7;
            this.f2699f.setBounds(i4, i2, i6, i3);
        }
        Drawable drawable3 = this.f2694a;
        if (drawable3 != null) {
            drawable3.getPadding(rect2);
            int i16 = thumbOffset - rect2.left;
            int i17 = thumbOffset + this.B + rect2.right;
            this.f2694a.setBounds(i16, i5, i17, i7);
            Drawable background = getBackground();
            if (background != null) {
                a.b.g.c.j.a.a(background, i16, i5, i17, i7);
            }
        }
        super.draw(canvas);
    }

    @Override // android.widget.CompoundButton, android.widget.TextView, android.view.View
    public void drawableHotspotChanged(float f2, float f3) {
        if (Build.VERSION.SDK_INT >= 21) {
            super.drawableHotspotChanged(f2, f3);
        }
        Drawable drawable = this.f2694a;
        if (drawable != null) {
            a.b.g.c.j.a.a(drawable, f2, f3);
        }
        Drawable drawable2 = this.f2699f;
        if (drawable2 != null) {
            a.b.g.c.j.a.a(drawable2, f2, f3);
        }
    }

    @Override // android.widget.CompoundButton, android.widget.TextView, android.view.View
    public void drawableStateChanged() {
        super.drawableStateChanged();
        int[] drawableState = getDrawableState();
        Drawable drawable = this.f2694a;
        boolean z = false;
        if (drawable != null && drawable.isStateful()) {
            z = false | drawable.setState(drawableState);
        }
        Drawable drawable2 = this.f2699f;
        if (drawable2 != null && drawable2.isStateful()) {
            z |= drawable2.setState(drawableState);
        }
        if (z) {
            invalidate();
        }
    }

    @Override // android.widget.CompoundButton, android.widget.TextView
    public int getCompoundPaddingLeft() {
        if (!t1.a(this)) {
            return super.getCompoundPaddingLeft();
        }
        int compoundPaddingLeft = super.getCompoundPaddingLeft() + this.z;
        return !TextUtils.isEmpty(getText()) ? compoundPaddingLeft + this.n : compoundPaddingLeft;
    }

    @Override // android.widget.CompoundButton, android.widget.TextView
    public int getCompoundPaddingRight() {
        if (t1.a(this)) {
            return super.getCompoundPaddingRight();
        }
        int compoundPaddingRight = super.getCompoundPaddingRight() + this.z;
        return !TextUtils.isEmpty(getText()) ? compoundPaddingRight + this.n : compoundPaddingRight;
    }

    public boolean getShowText() {
        return this.r;
    }

    public boolean getSplitTrack() {
        return this.o;
    }

    public int getSwitchMinWidth() {
        return this.m;
    }

    public int getSwitchPadding() {
        return this.n;
    }

    public CharSequence getTextOff() {
        return this.q;
    }

    public CharSequence getTextOn() {
        return this.p;
    }

    public Drawable getThumbDrawable() {
        return this.f2694a;
    }

    public int getThumbTextPadding() {
        return this.k;
    }

    public ColorStateList getThumbTintList() {
        return this.f2695b;
    }

    public PorterDuff.Mode getThumbTintMode() {
        return this.f2696c;
    }

    public Drawable getTrackDrawable() {
        return this.f2699f;
    }

    public ColorStateList getTrackTintList() {
        return this.f2700g;
    }

    public PorterDuff.Mode getTrackTintMode() {
        return this.f2701h;
    }

    @Override // android.widget.CompoundButton, android.widget.TextView, android.view.View
    public void jumpDrawablesToCurrentState() {
        super.jumpDrawablesToCurrentState();
        Drawable drawable = this.f2694a;
        if (drawable != null) {
            drawable.jumpToCurrentState();
        }
        Drawable drawable2 = this.f2699f;
        if (drawable2 != null) {
            drawable2.jumpToCurrentState();
        }
        ObjectAnimator objectAnimator = this.L;
        if (objectAnimator == null || !objectAnimator.isStarted()) {
            return;
        }
        this.L.end();
        this.L = null;
    }

    @Override // android.widget.CompoundButton, android.widget.TextView, android.view.View
    public int[] onCreateDrawableState(int i2) {
        int[] onCreateDrawableState = super.onCreateDrawableState(i2 + 1);
        if (isChecked()) {
            CompoundButton.mergeDrawableStates(onCreateDrawableState, O);
        }
        return onCreateDrawableState;
    }

    @Override // android.widget.CompoundButton, android.widget.TextView, android.view.View
    public void onDraw(Canvas canvas) {
        int width;
        super.onDraw(canvas);
        Rect rect = this.M;
        Drawable drawable = this.f2699f;
        if (drawable != null) {
            drawable.getPadding(rect);
        } else {
            rect.setEmpty();
        }
        int i2 = this.D;
        int i3 = this.F;
        int i4 = i2 + rect.top;
        int i5 = i3 - rect.bottom;
        Drawable drawable2 = this.f2694a;
        if (drawable != null) {
            if (this.o && drawable2 != null) {
                Rect d2 = k0.d(drawable2);
                drawable2.copyBounds(rect);
                rect.left += d2.left;
                rect.right -= d2.right;
                int save = canvas.save();
                canvas.clipRect(rect, Region.Op.DIFFERENCE);
                drawable.draw(canvas);
                canvas.restoreToCount(save);
            } else {
                drawable.draw(canvas);
            }
        }
        int save2 = canvas.save();
        if (drawable2 != null) {
            drawable2.draw(canvas);
        }
        Layout layout = getTargetCheckedState() ? this.I : this.J;
        if (layout != null) {
            int[] drawableState = getDrawableState();
            ColorStateList colorStateList = this.H;
            if (colorStateList != null) {
                this.G.setColor(colorStateList.getColorForState(drawableState, 0));
            }
            this.G.drawableState = drawableState;
            if (drawable2 != null) {
                Rect bounds = drawable2.getBounds();
                width = bounds.left + bounds.right;
            } else {
                width = getWidth();
            }
            canvas.translate((width / 2) - (layout.getWidth() / 2), ((i4 + i5) / 2) - (layout.getHeight() / 2));
            layout.draw(canvas);
        }
        canvas.restoreToCount(save2);
    }

    @Override // android.view.View
    public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        super.onInitializeAccessibilityEvent(accessibilityEvent);
        accessibilityEvent.setClassName("android.widget.Switch");
    }

    @Override // android.view.View
    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        accessibilityNodeInfo.setClassName("android.widget.Switch");
        CharSequence charSequence = isChecked() ? this.p : this.q;
        if (TextUtils.isEmpty(charSequence)) {
            return;
        }
        CharSequence text = accessibilityNodeInfo.getText();
        if (TextUtils.isEmpty(text)) {
            accessibilityNodeInfo.setText(charSequence);
            return;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(text);
        sb.append(' ');
        sb.append(charSequence);
        accessibilityNodeInfo.setText(sb);
    }

    @Override // android.widget.TextView, android.view.View
    public void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        int i6;
        int width;
        int i7;
        int i8;
        int paddingTop;
        int i9;
        super.onLayout(z, i2, i3, i4, i5);
        int i10 = 0;
        if (this.f2694a != null) {
            Rect rect = this.M;
            Drawable drawable = this.f2699f;
            if (drawable != null) {
                drawable.getPadding(rect);
            } else {
                rect.setEmpty();
            }
            Rect d2 = k0.d(this.f2694a);
            i6 = Math.max(0, d2.left - rect.left);
            i10 = Math.max(0, d2.right - rect.right);
        } else {
            i6 = 0;
        }
        if (t1.a(this)) {
            i7 = getPaddingLeft() + i6;
            width = ((this.z + i7) - i6) - i10;
        } else {
            width = (getWidth() - getPaddingRight()) - i10;
            i7 = (width - this.z) + i6 + i10;
        }
        int gravity = getGravity() & 112;
        if (gravity == 16) {
            i8 = this.A;
            paddingTop = (((getPaddingTop() + getHeight()) - getPaddingBottom()) / 2) - (i8 / 2);
        } else if (gravity != 80) {
            paddingTop = getPaddingTop();
            i8 = this.A;
        } else {
            i9 = getHeight() - getPaddingBottom();
            paddingTop = i9 - this.A;
            this.C = i7;
            this.D = paddingTop;
            this.F = i9;
            this.E = width;
        }
        i9 = i8 + paddingTop;
        this.C = i7;
        this.D = paddingTop;
        this.F = i9;
        this.E = width;
    }

    @Override // android.widget.TextView, android.view.View
    public void onMeasure(int i2, int i3) {
        int i4;
        int i5;
        if (this.r) {
            if (this.I == null) {
                this.I = a(this.p);
            }
            if (this.J == null) {
                this.J = a(this.q);
            }
        }
        Rect rect = this.M;
        Drawable drawable = this.f2694a;
        int i6 = 0;
        if (drawable != null) {
            drawable.getPadding(rect);
            i4 = (this.f2694a.getIntrinsicWidth() - rect.left) - rect.right;
            i5 = this.f2694a.getIntrinsicHeight();
        } else {
            i4 = 0;
            i5 = 0;
        }
        this.B = Math.max(this.r ? Math.max(this.I.getWidth(), this.J.getWidth()) + (this.k * 2) : 0, i4);
        Drawable drawable2 = this.f2699f;
        if (drawable2 != null) {
            drawable2.getPadding(rect);
            i6 = this.f2699f.getIntrinsicHeight();
        } else {
            rect.setEmpty();
        }
        int i7 = rect.left;
        int i8 = rect.right;
        Drawable drawable3 = this.f2694a;
        if (drawable3 != null) {
            Rect d2 = k0.d(drawable3);
            i7 = Math.max(i7, d2.left);
            i8 = Math.max(i8, d2.right);
        }
        int max = Math.max(this.m, (this.B * 2) + i7 + i8);
        int max2 = Math.max(i6, i5);
        this.z = max;
        this.A = max2;
        super.onMeasure(i2, i3);
        if (getMeasuredHeight() < max2) {
            setMeasuredDimension(getMeasuredWidthAndState(), max2);
        }
    }

    @Override // android.view.View
    public void onPopulateAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        super.onPopulateAccessibilityEvent(accessibilityEvent);
        CharSequence charSequence = isChecked() ? this.p : this.q;
        if (charSequence != null) {
            accessibilityEvent.getText().add(charSequence);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:8:0x0012, code lost:
        if (r0 != 3) goto L8;
     */
    @Override // android.widget.TextView, android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean onTouchEvent(android.view.MotionEvent r7) {
        /*
            r6 = this;
            android.view.VelocityTracker r0 = r6.w
            r0.addMovement(r7)
            int r0 = r7.getActionMasked()
            r1 = 1
            if (r0 == 0) goto La1
            r2 = 2
            if (r0 == r1) goto L8d
            if (r0 == r2) goto L16
            r3 = 3
            if (r0 == r3) goto L8d
            goto Lbb
        L16:
            int r0 = r6.s
            if (r0 == 0) goto Lbb
            if (r0 == r1) goto L59
            if (r0 == r2) goto L20
            goto Lbb
        L20:
            float r7 = r7.getX()
            int r0 = r6.getThumbScrollRange()
            float r2 = r6.u
            float r2 = r7 - r2
            r3 = 1065353216(0x3f800000, float:1.0)
            r4 = 0
            if (r0 == 0) goto L34
            float r0 = (float) r0
            float r2 = r2 / r0
            goto L3f
        L34:
            int r0 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r0 <= 0) goto L3b
            r2 = 1065353216(0x3f800000, float:1.0)
            goto L3f
        L3b:
            r0 = -1082130432(0xffffffffbf800000, float:-1.0)
            r2 = -1082130432(0xffffffffbf800000, float:-1.0)
        L3f:
            boolean r0 = a.b.h.k.t1.a(r6)
            if (r0 == 0) goto L46
            float r2 = -r2
        L46:
            float r0 = r6.y
            float r0 = r0 + r2
            float r0 = a(r0, r4, r3)
            float r2 = r6.y
            int r2 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r2 == 0) goto L58
            r6.u = r7
            r6.setThumbPosition(r0)
        L58:
            return r1
        L59:
            float r0 = r7.getX()
            float r3 = r7.getY()
            float r4 = r6.u
            float r4 = r0 - r4
            float r4 = java.lang.Math.abs(r4)
            int r5 = r6.t
            float r5 = (float) r5
            int r4 = (r4 > r5 ? 1 : (r4 == r5 ? 0 : -1))
            if (r4 > 0) goto L7f
            float r4 = r6.v
            float r4 = r3 - r4
            float r4 = java.lang.Math.abs(r4)
            int r5 = r6.t
            float r5 = (float) r5
            int r4 = (r4 > r5 ? 1 : (r4 == r5 ? 0 : -1))
            if (r4 <= 0) goto Lbb
        L7f:
            r6.s = r2
            android.view.ViewParent r7 = r6.getParent()
            r7.requestDisallowInterceptTouchEvent(r1)
            r6.u = r0
            r6.v = r3
            return r1
        L8d:
            int r0 = r6.s
            if (r0 != r2) goto L98
            r6.b(r7)
            super.onTouchEvent(r7)
            return r1
        L98:
            r0 = 0
            r6.s = r0
            android.view.VelocityTracker r0 = r6.w
            r0.clear()
            goto Lbb
        La1:
            float r0 = r7.getX()
            float r2 = r7.getY()
            boolean r3 = r6.isEnabled()
            if (r3 == 0) goto Lbb
            boolean r3 = r6.a(r0, r2)
            if (r3 == 0) goto Lbb
            r6.s = r1
            r6.u = r0
            r6.v = r2
        Lbb:
            boolean r7 = super.onTouchEvent(r7)
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v7.widget.SwitchCompat.onTouchEvent(android.view.MotionEvent):boolean");
    }

    @Override // android.widget.CompoundButton, android.widget.Checkable
    public void setChecked(boolean z) {
        super.setChecked(z);
        boolean isChecked = isChecked();
        if (getWindowToken() != null && u.x(this)) {
            a(isChecked);
            return;
        }
        c();
        setThumbPosition(isChecked ? 1.0f : 0.0f);
    }

    @Override // android.widget.TextView
    public void setCustomSelectionActionModeCallback(ActionMode.Callback callback) {
        super.setCustomSelectionActionModeCallback(p.a(this, callback));
    }

    public void setShowText(boolean z) {
        if (this.r != z) {
            this.r = z;
            requestLayout();
        }
    }

    public void setSplitTrack(boolean z) {
        this.o = z;
        invalidate();
    }

    public void setSwitchMinWidth(int i2) {
        this.m = i2;
        requestLayout();
    }

    public void setSwitchPadding(int i2) {
        this.n = i2;
        requestLayout();
    }

    public void setSwitchTypeface(Typeface typeface) {
        if ((this.G.getTypeface() == null || this.G.getTypeface().equals(typeface)) && (this.G.getTypeface() != null || typeface == null)) {
            return;
        }
        this.G.setTypeface(typeface);
        requestLayout();
        invalidate();
    }

    public void setTextOff(CharSequence charSequence) {
        this.q = charSequence;
        requestLayout();
    }

    public void setTextOn(CharSequence charSequence) {
        this.p = charSequence;
        requestLayout();
    }

    public void setThumbDrawable(Drawable drawable) {
        Drawable drawable2 = this.f2694a;
        if (drawable2 != null) {
            drawable2.setCallback(null);
        }
        this.f2694a = drawable;
        if (drawable != null) {
            drawable.setCallback(this);
        }
        requestLayout();
    }

    public void setThumbPosition(float f2) {
        this.y = f2;
        invalidate();
    }

    public void setThumbResource(int i2) {
        setThumbDrawable(a.b.h.d.a.a.c(getContext(), i2));
    }

    public void setThumbTextPadding(int i2) {
        this.k = i2;
        requestLayout();
    }

    public void setThumbTintList(ColorStateList colorStateList) {
        this.f2695b = colorStateList;
        this.f2697d = true;
        a();
    }

    public void setThumbTintMode(PorterDuff.Mode mode) {
        this.f2696c = mode;
        this.f2698e = true;
        a();
    }

    public void setTrackDrawable(Drawable drawable) {
        Drawable drawable2 = this.f2699f;
        if (drawable2 != null) {
            drawable2.setCallback(null);
        }
        this.f2699f = drawable;
        if (drawable != null) {
            drawable.setCallback(this);
        }
        requestLayout();
    }

    public void setTrackResource(int i2) {
        setTrackDrawable(a.b.h.d.a.a.c(getContext(), i2));
    }

    public void setTrackTintList(ColorStateList colorStateList) {
        this.f2700g = colorStateList;
        this.f2702i = true;
        b();
    }

    public void setTrackTintMode(PorterDuff.Mode mode) {
        this.f2701h = mode;
        this.j = true;
        b();
    }

    @Override // android.widget.CompoundButton, android.widget.Checkable
    public void toggle() {
        setChecked(!isChecked());
    }

    @Override // android.widget.CompoundButton, android.widget.TextView, android.view.View
    public boolean verifyDrawable(Drawable drawable) {
        return super.verifyDrawable(drawable) || drawable == this.f2694a || drawable == this.f2699f;
    }

    public SwitchCompat(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, a.b.h.b.a.switchStyle);
    }

    public SwitchCompat(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.f2695b = null;
        this.f2696c = null;
        this.f2697d = false;
        this.f2698e = false;
        this.f2700g = null;
        this.f2701h = null;
        this.f2702i = false;
        this.j = false;
        this.w = VelocityTracker.obtain();
        this.M = new Rect();
        this.G = new TextPaint(1);
        Resources resources = getResources();
        this.G.density = resources.getDisplayMetrics().density;
        l1 a2 = l1.a(context, attributeSet, j.SwitchCompat, i2, 0);
        this.f2694a = a2.b(j.SwitchCompat_android_thumb);
        Drawable drawable = this.f2694a;
        if (drawable != null) {
            drawable.setCallback(this);
        }
        this.f2699f = a2.b(j.SwitchCompat_track);
        Drawable drawable2 = this.f2699f;
        if (drawable2 != null) {
            drawable2.setCallback(this);
        }
        this.p = a2.e(j.SwitchCompat_android_textOn);
        this.q = a2.e(j.SwitchCompat_android_textOff);
        this.r = a2.a(j.SwitchCompat_showText, true);
        this.k = a2.c(j.SwitchCompat_thumbTextPadding, 0);
        this.m = a2.c(j.SwitchCompat_switchMinWidth, 0);
        this.n = a2.c(j.SwitchCompat_switchPadding, 0);
        this.o = a2.a(j.SwitchCompat_splitTrack, false);
        ColorStateList a3 = a2.a(j.SwitchCompat_thumbTint);
        if (a3 != null) {
            this.f2695b = a3;
            this.f2697d = true;
        }
        PorterDuff.Mode a4 = k0.a(a2.d(j.SwitchCompat_thumbTintMode, -1), null);
        if (this.f2696c != a4) {
            this.f2696c = a4;
            this.f2698e = true;
        }
        if (this.f2697d || this.f2698e) {
            a();
        }
        ColorStateList a5 = a2.a(j.SwitchCompat_trackTint);
        if (a5 != null) {
            this.f2700g = a5;
            this.f2702i = true;
        }
        PorterDuff.Mode a6 = k0.a(a2.d(j.SwitchCompat_trackTintMode, -1), null);
        if (this.f2701h != a6) {
            this.f2701h = a6;
            this.j = true;
        }
        if (this.f2702i || this.j) {
            b();
        }
        int g2 = a2.g(j.SwitchCompat_switchTextAppearance, 0);
        if (g2 != 0) {
            a(context, g2);
        }
        a2.a();
        ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
        this.t = viewConfiguration.getScaledTouchSlop();
        this.x = viewConfiguration.getScaledMinimumFlingVelocity();
        refreshDrawableState();
        setChecked(isChecked());
    }

    public final void b(MotionEvent motionEvent) {
        boolean z;
        this.s = 0;
        boolean z2 = true;
        boolean z3 = motionEvent.getAction() == 1 && isEnabled();
        boolean isChecked = isChecked();
        if (z3) {
            this.w.computeCurrentVelocity(1000);
            float xVelocity = this.w.getXVelocity();
            if (Math.abs(xVelocity) > this.x) {
                if (!t1.a(this) ? xVelocity <= 0.0f : xVelocity >= 0.0f) {
                    z2 = false;
                }
                z = z2;
            } else {
                z = getTargetCheckedState();
            }
        } else {
            z = isChecked;
        }
        if (z != isChecked) {
            playSoundEffect(0);
        }
        setChecked(z);
        a(motionEvent);
    }

    public final void a(int i2, int i3) {
        Typeface typeface;
        if (i2 == 1) {
            typeface = Typeface.SANS_SERIF;
        } else if (i2 != 2) {
            typeface = i2 != 3 ? null : Typeface.MONOSPACE;
        } else {
            typeface = Typeface.SERIF;
        }
        a(typeface, i3);
    }

    public void a(Typeface typeface, int i2) {
        Typeface create;
        if (i2 > 0) {
            if (typeface == null) {
                create = Typeface.defaultFromStyle(i2);
            } else {
                create = Typeface.create(typeface, i2);
            }
            setSwitchTypeface(create);
            int i3 = (~(create != null ? create.getStyle() : 0)) & i2;
            this.G.setFakeBoldText((i3 & 1) != 0);
            this.G.setTextSkewX((i3 & 2) != 0 ? -0.25f : 0.0f);
            return;
        }
        this.G.setFakeBoldText(false);
        this.G.setTextSkewX(0.0f);
        setSwitchTypeface(typeface);
    }

    public final void a() {
        if (this.f2694a != null) {
            if (this.f2697d || this.f2698e) {
                this.f2694a = this.f2694a.mutate();
                if (this.f2697d) {
                    a.b.g.c.j.a.a(this.f2694a, this.f2695b);
                }
                if (this.f2698e) {
                    a.b.g.c.j.a.a(this.f2694a, this.f2696c);
                }
                if (this.f2694a.isStateful()) {
                    this.f2694a.setState(getDrawableState());
                }
            }
        }
    }

    public final Layout a(CharSequence charSequence) {
        TransformationMethod transformationMethod = this.K;
        if (transformationMethod != null) {
            charSequence = transformationMethod.getTransformation(charSequence, this);
        }
        CharSequence charSequence2 = charSequence;
        TextPaint textPaint = this.G;
        return new StaticLayout(charSequence2, textPaint, charSequence2 != null ? (int) Math.ceil(Layout.getDesiredWidth(charSequence2, textPaint)) : 0, Layout.Alignment.ALIGN_NORMAL, 1.0f, 0.0f, true);
    }

    public final boolean a(float f2, float f3) {
        if (this.f2694a == null) {
            return false;
        }
        int thumbOffset = getThumbOffset();
        this.f2694a.getPadding(this.M);
        int i2 = this.D;
        int i3 = this.t;
        int i4 = i2 - i3;
        int i5 = (this.C + thumbOffset) - i3;
        Rect rect = this.M;
        return f2 > ((float) i5) && f2 < ((float) ((((this.B + i5) + rect.left) + rect.right) + i3)) && f3 > ((float) i4) && f3 < ((float) (this.F + i3));
    }

    public final void a(MotionEvent motionEvent) {
        MotionEvent obtain = MotionEvent.obtain(motionEvent);
        obtain.setAction(3);
        super.onTouchEvent(obtain);
        obtain.recycle();
    }

    public final void a(boolean z) {
        this.L = ObjectAnimator.ofFloat(this, N, z ? 1.0f : 0.0f);
        this.L.setDuration(250L);
        if (Build.VERSION.SDK_INT >= 18) {
            this.L.setAutoCancel(true);
        }
        this.L.start();
    }
}
