package android.support.p067v7.widget;

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
import p000a.p006b.p030g.p034c.p035j.DrawableCompat;
import p000a.p006b.p030g.p045k.ViewCompat;
import p000a.p006b.p030g.p048l.TextViewCompat;
import p000a.p006b.p049h.p051b.C0354a;
import p000a.p006b.p049h.p051b.C0363j;
import p000a.p006b.p049h.p053d.p054a.AppCompatResources;
import p000a.p006b.p049h.p059h.AllCapsTransformationMethod;
import p000a.p006b.p049h.p063k.C0475k0;
import p000a.p006b.p049h.p063k.C0504t1;
import p000a.p006b.p049h.p063k.TintTypedArray;

/* renamed from: android.support.v7.widget.SwitchCompat */
/* loaded from: classes.dex */
public class SwitchCompat extends CompoundButton {

    /* renamed from: N */
    public static final Property<SwitchCompat, Float> f4421N = new C0768a(Float.class, "thumbPos");

    /* renamed from: O */
    public static final int[] f4422O = {16842912};

    /* renamed from: A */
    public int f4423A;

    /* renamed from: B */
    public int f4424B;

    /* renamed from: C */
    public int f4425C;

    /* renamed from: D */
    public int f4426D;

    /* renamed from: E */
    public int f4427E;

    /* renamed from: F */
    public int f4428F;

    /* renamed from: G */
    public final TextPaint f4429G;

    /* renamed from: H */
    public ColorStateList f4430H;

    /* renamed from: I */
    public Layout f4431I;

    /* renamed from: J */
    public Layout f4432J;

    /* renamed from: K */
    public TransformationMethod f4433K;

    /* renamed from: L */
    public ObjectAnimator f4434L;

    /* renamed from: M */
    public final Rect f4435M;

    /* renamed from: a */
    public Drawable f4436a;

    /* renamed from: b */
    public ColorStateList f4437b;

    /* renamed from: c */
    public PorterDuff.Mode f4438c;

    /* renamed from: d */
    public boolean f4439d;

    /* renamed from: e */
    public boolean f4440e;

    /* renamed from: f */
    public Drawable f4441f;

    /* renamed from: g */
    public ColorStateList f4442g;

    /* renamed from: h */
    public PorterDuff.Mode f4443h;

    /* renamed from: i */
    public boolean f4444i;

    /* renamed from: j */
    public boolean f4445j;

    /* renamed from: k */
    public int f4446k;

    /* renamed from: m */
    public int f4447m;

    /* renamed from: n */
    public int f4448n;

    /* renamed from: o */
    public boolean f4449o;

    /* renamed from: p */
    public CharSequence f4450p;

    /* renamed from: q */
    public CharSequence f4451q;

    /* renamed from: r */
    public boolean f4452r;

    /* renamed from: s */
    public int f4453s;

    /* renamed from: t */
    public int f4454t;

    /* renamed from: u */
    public float f4455u;

    /* renamed from: v */
    public float f4456v;

    /* renamed from: w */
    public VelocityTracker f4457w;

    /* renamed from: x */
    public int f4458x;

    /* renamed from: y */
    public float f4459y;

    /* renamed from: z */
    public int f4460z;

    /* renamed from: android.support.v7.widget.SwitchCompat$a */
    /* loaded from: classes.dex */
    public static class C0768a extends Property<SwitchCompat, Float> {
        public C0768a(Class cls, String str) {
            super(cls, str);
        }

        @Override // android.util.Property
        /* renamed from: a */
        public Float get(SwitchCompat switchCompat) {
            return Float.valueOf(switchCompat.f4459y);
        }

        @Override // android.util.Property
        /* renamed from: a */
        public void set(SwitchCompat switchCompat, Float f) {
            switchCompat.setThumbPosition(f.floatValue());
        }
    }

    public SwitchCompat(Context context) {
        this(context, null);
    }

    /* renamed from: a */
    public static float m6334a(float f, float f2, float f3) {
        return f < f2 ? f2 : f > f3 ? f3 : f;
    }

    private boolean getTargetCheckedState() {
        return this.f4459y > 0.5f;
    }

    private int getThumbOffset() {
        float f;
        if (C0504t1.m8047a(this)) {
            f = 1.0f - this.f4459y;
        } else {
            f = this.f4459y;
        }
        return (int) ((f * getThumbScrollRange()) + 0.5f);
    }

    private int getThumbScrollRange() {
        Rect rect;
        Drawable drawable = this.f4441f;
        if (drawable != null) {
            Rect rect2 = this.f4435M;
            drawable.getPadding(rect2);
            Drawable drawable2 = this.f4436a;
            if (drawable2 != null) {
                rect = C0475k0.m8280d(drawable2);
            } else {
                rect = C0475k0.f2732a;
            }
            return ((((this.f4460z - this.f4424B) - rect2.left) - rect2.right) - rect.left) - rect.right;
        }
        return 0;
    }

    /* renamed from: a */
    public void m6332a(Context context, int i) {
        TintTypedArray m8259a = TintTypedArray.m8259a(context, i, C0363j.TextAppearance);
        ColorStateList m8264a = m8259a.m8264a(C0363j.TextAppearance_android_textColor);
        if (m8264a != null) {
            this.f4430H = m8264a;
        } else {
            this.f4430H = getTextColors();
        }
        int m8252c = m8259a.m8252c(C0363j.TextAppearance_android_textSize, 0);
        if (m8252c != 0) {
            float f = m8252c;
            if (f != this.f4429G.getTextSize()) {
                this.f4429G.setTextSize(f);
                requestLayout();
            }
        }
        m6333a(m8259a.m8250d(C0363j.TextAppearance_android_typeface, -1), m8259a.m8250d(C0363j.TextAppearance_android_textStyle, -1));
        if (m8259a.m8260a(C0363j.TextAppearance_textAllCaps, false)) {
            this.f4433K = new AllCapsTransformationMethod(getContext());
        } else {
            this.f4433K = null;
        }
        m8259a.m8265a();
    }

    /* renamed from: b */
    public final void m6327b() {
        if (this.f4441f != null) {
            if (this.f4444i || this.f4445j) {
                this.f4441f = this.f4441f.mutate();
                if (this.f4444i) {
                    DrawableCompat.m9861a(this.f4441f, this.f4442g);
                }
                if (this.f4445j) {
                    DrawableCompat.m9858a(this.f4441f, this.f4443h);
                }
                if (this.f4441f.isStateful()) {
                    this.f4441f.setState(getDrawableState());
                }
            }
        }
    }

    /* renamed from: c */
    public final void m6325c() {
        ObjectAnimator objectAnimator = this.f4434L;
        if (objectAnimator != null) {
            objectAnimator.cancel();
        }
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        Rect rect;
        int i;
        int i2;
        Rect rect2 = this.f4435M;
        int i3 = this.f4425C;
        int i4 = this.f4426D;
        int i5 = this.f4427E;
        int i6 = this.f4428F;
        int thumbOffset = getThumbOffset() + i3;
        Drawable drawable = this.f4436a;
        if (drawable != null) {
            rect = C0475k0.m8280d(drawable);
        } else {
            rect = C0475k0.f2732a;
        }
        Drawable drawable2 = this.f4441f;
        if (drawable2 != null) {
            drawable2.getPadding(rect2);
            int i7 = rect2.left;
            thumbOffset += i7;
            if (rect != null) {
                int i8 = rect.left;
                if (i8 > i7) {
                    i3 += i8 - i7;
                }
                int i9 = rect.top;
                int i10 = rect2.top;
                i = i9 > i10 ? (i9 - i10) + i4 : i4;
                int i11 = rect.right;
                int i12 = rect2.right;
                if (i11 > i12) {
                    i5 -= i11 - i12;
                }
                int i13 = rect.bottom;
                int i14 = rect2.bottom;
                if (i13 > i14) {
                    i2 = i6 - (i13 - i14);
                    this.f4441f.setBounds(i3, i, i5, i2);
                }
            } else {
                i = i4;
            }
            i2 = i6;
            this.f4441f.setBounds(i3, i, i5, i2);
        }
        Drawable drawable3 = this.f4436a;
        if (drawable3 != null) {
            drawable3.getPadding(rect2);
            int i15 = thumbOffset - rect2.left;
            int i16 = thumbOffset + this.f4424B + rect2.right;
            this.f4436a.setBounds(i15, i4, i16, i6);
            Drawable background = getBackground();
            if (background != null) {
                DrawableCompat.m9862a(background, i15, i4, i16, i6);
            }
        }
        super.draw(canvas);
    }

    @Override // android.widget.CompoundButton, android.widget.TextView, android.view.View
    public void drawableHotspotChanged(float f, float f2) {
        if (Build.VERSION.SDK_INT >= 21) {
            super.drawableHotspotChanged(f, f2);
        }
        Drawable drawable = this.f4436a;
        if (drawable != null) {
            DrawableCompat.m9864a(drawable, f, f2);
        }
        Drawable drawable2 = this.f4441f;
        if (drawable2 != null) {
            DrawableCompat.m9864a(drawable2, f, f2);
        }
    }

    @Override // android.widget.CompoundButton, android.widget.TextView, android.view.View
    public void drawableStateChanged() {
        super.drawableStateChanged();
        int[] drawableState = getDrawableState();
        Drawable drawable = this.f4436a;
        boolean z = false;
        if (drawable != null && drawable.isStateful()) {
            z = false | drawable.setState(drawableState);
        }
        Drawable drawable2 = this.f4441f;
        if (drawable2 != null && drawable2.isStateful()) {
            z |= drawable2.setState(drawableState);
        }
        if (z) {
            invalidate();
        }
    }

    @Override // android.widget.CompoundButton, android.widget.TextView
    public int getCompoundPaddingLeft() {
        if (!C0504t1.m8047a(this)) {
            return super.getCompoundPaddingLeft();
        }
        int compoundPaddingLeft = super.getCompoundPaddingLeft() + this.f4460z;
        return !TextUtils.isEmpty(getText()) ? compoundPaddingLeft + this.f4448n : compoundPaddingLeft;
    }

    @Override // android.widget.CompoundButton, android.widget.TextView
    public int getCompoundPaddingRight() {
        if (C0504t1.m8047a(this)) {
            return super.getCompoundPaddingRight();
        }
        int compoundPaddingRight = super.getCompoundPaddingRight() + this.f4460z;
        return !TextUtils.isEmpty(getText()) ? compoundPaddingRight + this.f4448n : compoundPaddingRight;
    }

    public boolean getShowText() {
        return this.f4452r;
    }

    public boolean getSplitTrack() {
        return this.f4449o;
    }

    public int getSwitchMinWidth() {
        return this.f4447m;
    }

    public int getSwitchPadding() {
        return this.f4448n;
    }

    public CharSequence getTextOff() {
        return this.f4451q;
    }

    public CharSequence getTextOn() {
        return this.f4450p;
    }

    public Drawable getThumbDrawable() {
        return this.f4436a;
    }

    public int getThumbTextPadding() {
        return this.f4446k;
    }

    public ColorStateList getThumbTintList() {
        return this.f4437b;
    }

    public PorterDuff.Mode getThumbTintMode() {
        return this.f4438c;
    }

    public Drawable getTrackDrawable() {
        return this.f4441f;
    }

    public ColorStateList getTrackTintList() {
        return this.f4442g;
    }

    public PorterDuff.Mode getTrackTintMode() {
        return this.f4443h;
    }

    @Override // android.widget.CompoundButton, android.widget.TextView, android.view.View
    public void jumpDrawablesToCurrentState() {
        super.jumpDrawablesToCurrentState();
        Drawable drawable = this.f4436a;
        if (drawable != null) {
            drawable.jumpToCurrentState();
        }
        Drawable drawable2 = this.f4441f;
        if (drawable2 != null) {
            drawable2.jumpToCurrentState();
        }
        ObjectAnimator objectAnimator = this.f4434L;
        if (objectAnimator == null || !objectAnimator.isStarted()) {
            return;
        }
        this.f4434L.end();
        this.f4434L = null;
    }

    @Override // android.widget.CompoundButton, android.widget.TextView, android.view.View
    public int[] onCreateDrawableState(int i) {
        int[] onCreateDrawableState = super.onCreateDrawableState(i + 1);
        if (isChecked()) {
            CompoundButton.mergeDrawableStates(onCreateDrawableState, f4422O);
        }
        return onCreateDrawableState;
    }

    @Override // android.widget.CompoundButton, android.widget.TextView, android.view.View
    public void onDraw(Canvas canvas) {
        int width;
        super.onDraw(canvas);
        Rect rect = this.f4435M;
        Drawable drawable = this.f4441f;
        if (drawable != null) {
            drawable.getPadding(rect);
        } else {
            rect.setEmpty();
        }
        int i = this.f4426D;
        int i2 = this.f4428F;
        int i3 = i + rect.top;
        int i4 = i2 - rect.bottom;
        Drawable drawable2 = this.f4436a;
        if (drawable != null) {
            if (this.f4449o && drawable2 != null) {
                Rect m8280d = C0475k0.m8280d(drawable2);
                drawable2.copyBounds(rect);
                rect.left += m8280d.left;
                rect.right -= m8280d.right;
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
        Layout layout = getTargetCheckedState() ? this.f4431I : this.f4432J;
        if (layout != null) {
            int[] drawableState = getDrawableState();
            ColorStateList colorStateList = this.f4430H;
            if (colorStateList != null) {
                this.f4429G.setColor(colorStateList.getColorForState(drawableState, 0));
            }
            this.f4429G.drawableState = drawableState;
            if (drawable2 != null) {
                Rect bounds = drawable2.getBounds();
                width = bounds.left + bounds.right;
            } else {
                width = getWidth();
            }
            canvas.translate((width / 2) - (layout.getWidth() / 2), ((i3 + i4) / 2) - (layout.getHeight() / 2));
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
        CharSequence charSequence = isChecked() ? this.f4450p : this.f4451q;
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
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int i5;
        int width;
        int i6;
        int i7;
        int paddingTop;
        int i8;
        super.onLayout(z, i, i2, i3, i4);
        int i9 = 0;
        if (this.f4436a != null) {
            Rect rect = this.f4435M;
            Drawable drawable = this.f4441f;
            if (drawable != null) {
                drawable.getPadding(rect);
            } else {
                rect.setEmpty();
            }
            Rect m8280d = C0475k0.m8280d(this.f4436a);
            i5 = Math.max(0, m8280d.left - rect.left);
            i9 = Math.max(0, m8280d.right - rect.right);
        } else {
            i5 = 0;
        }
        if (C0504t1.m8047a(this)) {
            i6 = getPaddingLeft() + i5;
            width = ((this.f4460z + i6) - i5) - i9;
        } else {
            width = (getWidth() - getPaddingRight()) - i9;
            i6 = (width - this.f4460z) + i5 + i9;
        }
        int gravity = getGravity() & 112;
        if (gravity == 16) {
            i7 = this.f4423A;
            paddingTop = (((getPaddingTop() + getHeight()) - getPaddingBottom()) / 2) - (i7 / 2);
        } else if (gravity != 80) {
            paddingTop = getPaddingTop();
            i7 = this.f4423A;
        } else {
            i8 = getHeight() - getPaddingBottom();
            paddingTop = i8 - this.f4423A;
            this.f4425C = i6;
            this.f4426D = paddingTop;
            this.f4428F = i8;
            this.f4427E = width;
        }
        i8 = i7 + paddingTop;
        this.f4425C = i6;
        this.f4426D = paddingTop;
        this.f4428F = i8;
        this.f4427E = width;
    }

    @Override // android.widget.TextView, android.view.View
    public void onMeasure(int i, int i2) {
        int i3;
        int i4;
        if (this.f4452r) {
            if (this.f4431I == null) {
                this.f4431I = m6329a(this.f4450p);
            }
            if (this.f4432J == null) {
                this.f4432J = m6329a(this.f4451q);
            }
        }
        Rect rect = this.f4435M;
        Drawable drawable = this.f4436a;
        int i5 = 0;
        if (drawable != null) {
            drawable.getPadding(rect);
            i3 = (this.f4436a.getIntrinsicWidth() - rect.left) - rect.right;
            i4 = this.f4436a.getIntrinsicHeight();
        } else {
            i3 = 0;
            i4 = 0;
        }
        this.f4424B = Math.max(this.f4452r ? Math.max(this.f4431I.getWidth(), this.f4432J.getWidth()) + (this.f4446k * 2) : 0, i3);
        Drawable drawable2 = this.f4441f;
        if (drawable2 != null) {
            drawable2.getPadding(rect);
            i5 = this.f4441f.getIntrinsicHeight();
        } else {
            rect.setEmpty();
        }
        int i6 = rect.left;
        int i7 = rect.right;
        Drawable drawable3 = this.f4436a;
        if (drawable3 != null) {
            Rect m8280d = C0475k0.m8280d(drawable3);
            i6 = Math.max(i6, m8280d.left);
            i7 = Math.max(i7, m8280d.right);
        }
        int max = Math.max(this.f4447m, (this.f4424B * 2) + i6 + i7);
        int max2 = Math.max(i5, i4);
        this.f4460z = max;
        this.f4423A = max2;
        super.onMeasure(i, i2);
        if (getMeasuredHeight() < max2) {
            setMeasuredDimension(getMeasuredWidthAndState(), max2);
        }
    }

    @Override // android.view.View
    public void onPopulateAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        super.onPopulateAccessibilityEvent(accessibilityEvent);
        CharSequence charSequence = isChecked() ? this.f4450p : this.f4451q;
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
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean onTouchEvent(android.view.MotionEvent r7) {
        /*
            r6 = this;
            android.view.VelocityTracker r0 = r6.f4457w
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
            int r0 = r6.f4453s
            if (r0 == 0) goto Lbb
            if (r0 == r1) goto L59
            if (r0 == r2) goto L20
            goto Lbb
        L20:
            float r7 = r7.getX()
            int r0 = r6.getThumbScrollRange()
            float r2 = r6.f4455u
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
            boolean r0 = p000a.p006b.p049h.p063k.C0504t1.m8047a(r6)
            if (r0 == 0) goto L46
            float r2 = -r2
        L46:
            float r0 = r6.f4459y
            float r0 = r0 + r2
            float r0 = m6334a(r0, r4, r3)
            float r2 = r6.f4459y
            int r2 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r2 == 0) goto L58
            r6.f4455u = r7
            r6.setThumbPosition(r0)
        L58:
            return r1
        L59:
            float r0 = r7.getX()
            float r3 = r7.getY()
            float r4 = r6.f4455u
            float r4 = r0 - r4
            float r4 = java.lang.Math.abs(r4)
            int r5 = r6.f4454t
            float r5 = (float) r5
            int r4 = (r4 > r5 ? 1 : (r4 == r5 ? 0 : -1))
            if (r4 > 0) goto L7f
            float r4 = r6.f4456v
            float r4 = r3 - r4
            float r4 = java.lang.Math.abs(r4)
            int r5 = r6.f4454t
            float r5 = (float) r5
            int r4 = (r4 > r5 ? 1 : (r4 == r5 ? 0 : -1))
            if (r4 <= 0) goto Lbb
        L7f:
            r6.f4453s = r2
            android.view.ViewParent r7 = r6.getParent()
            r7.requestDisallowInterceptTouchEvent(r1)
            r6.f4455u = r0
            r6.f4456v = r3
            return r1
        L8d:
            int r0 = r6.f4453s
            if (r0 != r2) goto L98
            r6.m6326b(r7)
            super.onTouchEvent(r7)
            return r1
        L98:
            r0 = 0
            r6.f4453s = r0
            android.view.VelocityTracker r0 = r6.f4457w
            r0.clear()
            goto Lbb
        La1:
            float r0 = r7.getX()
            float r2 = r7.getY()
            boolean r3 = r6.isEnabled()
            if (r3 == 0) goto Lbb
            boolean r3 = r6.m6335a(r0, r2)
            if (r3 == 0) goto Lbb
            r6.f4453s = r1
            r6.f4455u = r0
            r6.f4456v = r2
        Lbb:
            boolean r7 = super.onTouchEvent(r7)
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.p067v7.widget.SwitchCompat.onTouchEvent(android.view.MotionEvent):boolean");
    }

    @Override // android.widget.CompoundButton, android.widget.Checkable
    public void setChecked(boolean z) {
        super.setChecked(z);
        boolean isChecked = isChecked();
        if (getWindowToken() != null && ViewCompat.m9409x(this)) {
            m6328a(isChecked);
            return;
        }
        m6325c();
        setThumbPosition(isChecked ? 1.0f : 0.0f);
    }

    @Override // android.widget.TextView
    public void setCustomSelectionActionModeCallback(ActionMode.Callback callback) {
        super.setCustomSelectionActionModeCallback(TextViewCompat.m9211a(this, callback));
    }

    public void setShowText(boolean z) {
        if (this.f4452r != z) {
            this.f4452r = z;
            requestLayout();
        }
    }

    public void setSplitTrack(boolean z) {
        this.f4449o = z;
        invalidate();
    }

    public void setSwitchMinWidth(int i) {
        this.f4447m = i;
        requestLayout();
    }

    public void setSwitchPadding(int i) {
        this.f4448n = i;
        requestLayout();
    }

    public void setSwitchTypeface(Typeface typeface) {
        if ((this.f4429G.getTypeface() == null || this.f4429G.getTypeface().equals(typeface)) && (this.f4429G.getTypeface() != null || typeface == null)) {
            return;
        }
        this.f4429G.setTypeface(typeface);
        requestLayout();
        invalidate();
    }

    public void setTextOff(CharSequence charSequence) {
        this.f4451q = charSequence;
        requestLayout();
    }

    public void setTextOn(CharSequence charSequence) {
        this.f4450p = charSequence;
        requestLayout();
    }

    public void setThumbDrawable(Drawable drawable) {
        Drawable drawable2 = this.f4436a;
        if (drawable2 != null) {
            drawable2.setCallback(null);
        }
        this.f4436a = drawable;
        if (drawable != null) {
            drawable.setCallback(this);
        }
        requestLayout();
    }

    public void setThumbPosition(float f) {
        this.f4459y = f;
        invalidate();
    }

    public void setThumbResource(int i) {
        setThumbDrawable(AppCompatResources.m8967c(getContext(), i));
    }

    public void setThumbTextPadding(int i) {
        this.f4446k = i;
        requestLayout();
    }

    public void setThumbTintList(ColorStateList colorStateList) {
        this.f4437b = colorStateList;
        this.f4439d = true;
        m6336a();
    }

    public void setThumbTintMode(PorterDuff.Mode mode) {
        this.f4438c = mode;
        this.f4440e = true;
        m6336a();
    }

    public void setTrackDrawable(Drawable drawable) {
        Drawable drawable2 = this.f4441f;
        if (drawable2 != null) {
            drawable2.setCallback(null);
        }
        this.f4441f = drawable;
        if (drawable != null) {
            drawable.setCallback(this);
        }
        requestLayout();
    }

    public void setTrackResource(int i) {
        setTrackDrawable(AppCompatResources.m8967c(getContext(), i));
    }

    public void setTrackTintList(ColorStateList colorStateList) {
        this.f4442g = colorStateList;
        this.f4444i = true;
        m6327b();
    }

    public void setTrackTintMode(PorterDuff.Mode mode) {
        this.f4443h = mode;
        this.f4445j = true;
        m6327b();
    }

    @Override // android.widget.CompoundButton, android.widget.Checkable
    public void toggle() {
        setChecked(!isChecked());
    }

    @Override // android.widget.CompoundButton, android.widget.TextView, android.view.View
    public boolean verifyDrawable(Drawable drawable) {
        return super.verifyDrawable(drawable) || drawable == this.f4436a || drawable == this.f4441f;
    }

    public SwitchCompat(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, C0354a.switchStyle);
    }

    public SwitchCompat(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f4437b = null;
        this.f4438c = null;
        this.f4439d = false;
        this.f4440e = false;
        this.f4442g = null;
        this.f4443h = null;
        this.f4444i = false;
        this.f4445j = false;
        this.f4457w = VelocityTracker.obtain();
        this.f4435M = new Rect();
        this.f4429G = new TextPaint(1);
        Resources resources = getResources();
        this.f4429G.density = resources.getDisplayMetrics().density;
        TintTypedArray m8257a = TintTypedArray.m8257a(context, attributeSet, C0363j.SwitchCompat, i, 0);
        this.f4436a = m8257a.m8256b(C0363j.SwitchCompat_android_thumb);
        Drawable drawable = this.f4436a;
        if (drawable != null) {
            drawable.setCallback(this);
        }
        this.f4441f = m8257a.m8256b(C0363j.SwitchCompat_track);
        Drawable drawable2 = this.f4441f;
        if (drawable2 != null) {
            drawable2.setCallback(this);
        }
        this.f4450p = m8257a.m8249e(C0363j.SwitchCompat_android_textOn);
        this.f4451q = m8257a.m8249e(C0363j.SwitchCompat_android_textOff);
        this.f4452r = m8257a.m8260a(C0363j.SwitchCompat_showText, true);
        this.f4446k = m8257a.m8252c(C0363j.SwitchCompat_thumbTextPadding, 0);
        this.f4447m = m8257a.m8252c(C0363j.SwitchCompat_switchMinWidth, 0);
        this.f4448n = m8257a.m8252c(C0363j.SwitchCompat_switchPadding, 0);
        this.f4449o = m8257a.m8260a(C0363j.SwitchCompat_splitTrack, false);
        ColorStateList m8264a = m8257a.m8264a(C0363j.SwitchCompat_thumbTint);
        if (m8264a != null) {
            this.f4437b = m8264a;
            this.f4439d = true;
        }
        PorterDuff.Mode m8284a = C0475k0.m8284a(m8257a.m8250d(C0363j.SwitchCompat_thumbTintMode, -1), null);
        if (this.f4438c != m8284a) {
            this.f4438c = m8284a;
            this.f4440e = true;
        }
        if (this.f4439d || this.f4440e) {
            m6336a();
        }
        ColorStateList m8264a2 = m8257a.m8264a(C0363j.SwitchCompat_trackTint);
        if (m8264a2 != null) {
            this.f4442g = m8264a2;
            this.f4444i = true;
        }
        PorterDuff.Mode m8284a2 = C0475k0.m8284a(m8257a.m8250d(C0363j.SwitchCompat_trackTintMode, -1), null);
        if (this.f4443h != m8284a2) {
            this.f4443h = m8284a2;
            this.f4445j = true;
        }
        if (this.f4444i || this.f4445j) {
            m6327b();
        }
        int m8244g = m8257a.m8244g(C0363j.SwitchCompat_switchTextAppearance, 0);
        if (m8244g != 0) {
            m6332a(context, m8244g);
        }
        m8257a.m8265a();
        ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
        this.f4454t = viewConfiguration.getScaledTouchSlop();
        this.f4458x = viewConfiguration.getScaledMinimumFlingVelocity();
        refreshDrawableState();
        setChecked(isChecked());
    }

    /* renamed from: b */
    public final void m6326b(MotionEvent motionEvent) {
        boolean z;
        this.f4453s = 0;
        boolean z2 = true;
        boolean z3 = motionEvent.getAction() == 1 && isEnabled();
        boolean isChecked = isChecked();
        if (z3) {
            this.f4457w.computeCurrentVelocity(1000);
            float xVelocity = this.f4457w.getXVelocity();
            if (Math.abs(xVelocity) > this.f4458x) {
                if (!C0504t1.m8047a(this) ? xVelocity <= 0.0f : xVelocity >= 0.0f) {
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
        m6330a(motionEvent);
    }

    /* renamed from: a */
    public final void m6333a(int i, int i2) {
        Typeface typeface;
        if (i == 1) {
            typeface = Typeface.SANS_SERIF;
        } else if (i != 2) {
            typeface = i != 3 ? null : Typeface.MONOSPACE;
        } else {
            typeface = Typeface.SERIF;
        }
        m6331a(typeface, i2);
    }

    /* renamed from: a */
    public void m6331a(Typeface typeface, int i) {
        Typeface create;
        if (i > 0) {
            if (typeface == null) {
                create = Typeface.defaultFromStyle(i);
            } else {
                create = Typeface.create(typeface, i);
            }
            setSwitchTypeface(create);
            int i2 = (~(create != null ? create.getStyle() : 0)) & i;
            this.f4429G.setFakeBoldText((i2 & 1) != 0);
            this.f4429G.setTextSkewX((i2 & 2) != 0 ? -0.25f : 0.0f);
            return;
        }
        this.f4429G.setFakeBoldText(false);
        this.f4429G.setTextSkewX(0.0f);
        setSwitchTypeface(typeface);
    }

    /* renamed from: a */
    public final void m6336a() {
        if (this.f4436a != null) {
            if (this.f4439d || this.f4440e) {
                this.f4436a = this.f4436a.mutate();
                if (this.f4439d) {
                    DrawableCompat.m9861a(this.f4436a, this.f4437b);
                }
                if (this.f4440e) {
                    DrawableCompat.m9858a(this.f4436a, this.f4438c);
                }
                if (this.f4436a.isStateful()) {
                    this.f4436a.setState(getDrawableState());
                }
            }
        }
    }

    /* renamed from: a */
    public final Layout m6329a(CharSequence charSequence) {
        TransformationMethod transformationMethod = this.f4433K;
        if (transformationMethod != null) {
            charSequence = transformationMethod.getTransformation(charSequence, this);
        }
        CharSequence charSequence2 = charSequence;
        TextPaint textPaint = this.f4429G;
        return new StaticLayout(charSequence2, textPaint, charSequence2 != null ? (int) Math.ceil(Layout.getDesiredWidth(charSequence2, textPaint)) : 0, Layout.Alignment.ALIGN_NORMAL, 1.0f, 0.0f, true);
    }

    /* renamed from: a */
    public final boolean m6335a(float f, float f2) {
        if (this.f4436a == null) {
            return false;
        }
        int thumbOffset = getThumbOffset();
        this.f4436a.getPadding(this.f4435M);
        int i = this.f4426D;
        int i2 = this.f4454t;
        int i3 = i - i2;
        int i4 = (this.f4425C + thumbOffset) - i2;
        Rect rect = this.f4435M;
        return f > ((float) i4) && f < ((float) ((((this.f4424B + i4) + rect.left) + rect.right) + i2)) && f2 > ((float) i3) && f2 < ((float) (this.f4428F + i2));
    }

    /* renamed from: a */
    public final void m6330a(MotionEvent motionEvent) {
        MotionEvent obtain = MotionEvent.obtain(motionEvent);
        obtain.setAction(3);
        super.onTouchEvent(obtain);
        obtain.recycle();
    }

    /* renamed from: a */
    public final void m6328a(boolean z) {
        this.f4434L = ObjectAnimator.ofFloat(this, f4421N, z ? 1.0f : 0.0f);
        this.f4434L.setDuration(250L);
        if (Build.VERSION.SDK_INT >= 18) {
            this.f4434L.setAutoCancel(true);
        }
        this.f4434L.start();
    }
}
