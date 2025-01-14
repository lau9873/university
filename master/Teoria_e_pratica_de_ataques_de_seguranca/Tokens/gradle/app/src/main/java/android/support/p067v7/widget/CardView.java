package android.support.p067v7.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import p000a.p006b.p049h.p052c.C0364a;
import p000a.p006b.p049h.p052c.C0365b;
import p000a.p006b.p049h.p052c.C0367d;
import p000a.p006b.p049h.p052c.C0368e;
import p000a.p006b.p049h.p063k.CardViewApi17Impl;
import p000a.p006b.p049h.p063k.CardViewApi21Impl;
import p000a.p006b.p049h.p063k.CardViewBaseImpl;
import p000a.p006b.p049h.p063k.CardViewDelegate;
import p000a.p006b.p049h.p063k.CardViewImpl;

/* renamed from: android.support.v7.widget.CardView */
/* loaded from: classes.dex */
public class CardView extends FrameLayout {

    /* renamed from: h */
    public static final int[] f4029h = {16842801};

    /* renamed from: i */
    public static final CardViewImpl f4030i;

    /* renamed from: a */
    public boolean f4031a;

    /* renamed from: b */
    public boolean f4032b;

    /* renamed from: c */
    public int f4033c;

    /* renamed from: d */
    public int f4034d;

    /* renamed from: e */
    public final Rect f4035e;

    /* renamed from: f */
    public final Rect f4036f;

    /* renamed from: g */
    public final CardViewDelegate f4037g;

    static {
        int i = Build.VERSION.SDK_INT;
        if (i >= 21) {
            f4030i = new CardViewApi21Impl();
        } else if (i >= 17) {
            f4030i = new CardViewApi17Impl();
        } else {
            f4030i = new CardViewBaseImpl();
        }
        f4030i.mo8413a();
    }

    public CardView(Context context) {
        this(context, null);
    }

    public ColorStateList getCardBackgroundColor() {
        return f4030i.mo8401g(this.f4037g);
    }

    public float getCardElevation() {
        return f4030i.mo8402f(this.f4037g);
    }

    public int getContentPaddingBottom() {
        return this.f4035e.bottom;
    }

    public int getContentPaddingLeft() {
        return this.f4035e.left;
    }

    public int getContentPaddingRight() {
        return this.f4035e.right;
    }

    public int getContentPaddingTop() {
        return this.f4035e.top;
    }

    public float getMaxCardElevation() {
        return f4030i.mo8403e(this.f4037g);
    }

    public boolean getPreventCornerOverlap() {
        return this.f4032b;
    }

    public float getRadius() {
        return f4030i.mo8400h(this.f4037g);
    }

    public boolean getUseCompatPadding() {
        return this.f4031a;
    }

    @Override // android.widget.FrameLayout, android.view.View
    public void onMeasure(int i, int i2) {
        if (!(f4030i instanceof CardViewApi21Impl)) {
            int mode = View.MeasureSpec.getMode(i);
            if (mode == Integer.MIN_VALUE || mode == 1073741824) {
                i = View.MeasureSpec.makeMeasureSpec(Math.max((int) Math.ceil(f4030i.mo8408b(this.f4037g)), View.MeasureSpec.getSize(i)), mode);
            }
            int mode2 = View.MeasureSpec.getMode(i2);
            if (mode2 == Integer.MIN_VALUE || mode2 == 1073741824) {
                i2 = View.MeasureSpec.makeMeasureSpec(Math.max((int) Math.ceil(f4030i.mo8412a(this.f4037g)), View.MeasureSpec.getSize(i2)), mode2);
            }
            super.onMeasure(i, i2);
            return;
        }
        super.onMeasure(i, i2);
    }

    public void setCardBackgroundColor(int i) {
        f4030i.mo8409a(this.f4037g, ColorStateList.valueOf(i));
    }

    public void setCardElevation(float f) {
        f4030i.mo8411a(this.f4037g, f);
    }

    public void setMaxCardElevation(float f) {
        f4030i.mo8407b(this.f4037g, f);
    }

    @Override // android.view.View
    public void setMinimumHeight(int i) {
        this.f4034d = i;
        super.setMinimumHeight(i);
    }

    @Override // android.view.View
    public void setMinimumWidth(int i) {
        this.f4033c = i;
        super.setMinimumWidth(i);
    }

    @Override // android.view.View
    public void setPadding(int i, int i2, int i3, int i4) {
    }

    @Override // android.view.View
    public void setPaddingRelative(int i, int i2, int i3, int i4) {
    }

    public void setPreventCornerOverlap(boolean z) {
        if (z != this.f4032b) {
            this.f4032b = z;
            f4030i.mo8404d(this.f4037g);
        }
    }

    public void setRadius(float f) {
        f4030i.mo8405c(this.f4037g, f);
    }

    public void setUseCompatPadding(boolean z) {
        if (this.f4031a != z) {
            this.f4031a = z;
            f4030i.mo8406c(this.f4037g);
        }
    }

    /* renamed from: android.support.v7.widget.CardView$a */
    /* loaded from: classes.dex */
    public class C0691a implements CardViewDelegate {

        /* renamed from: a */
        public Drawable f4038a;

        public C0691a() {
        }

        @Override // p000a.p006b.p049h.p063k.CardViewDelegate
        /* renamed from: a */
        public void mo7064a(Drawable drawable) {
            this.f4038a = drawable;
            CardView.this.setBackgroundDrawable(drawable);
        }

        @Override // p000a.p006b.p049h.p063k.CardViewDelegate
        /* renamed from: b */
        public boolean mo7063b() {
            return CardView.this.getPreventCornerOverlap();
        }

        @Override // p000a.p006b.p049h.p063k.CardViewDelegate
        /* renamed from: c */
        public boolean mo7062c() {
            return CardView.this.getUseCompatPadding();
        }

        @Override // p000a.p006b.p049h.p063k.CardViewDelegate
        /* renamed from: d */
        public Drawable mo7061d() {
            return this.f4038a;
        }

        @Override // p000a.p006b.p049h.p063k.CardViewDelegate
        /* renamed from: a */
        public void mo7065a(int i, int i2, int i3, int i4) {
            CardView.this.f4036f.set(i, i2, i3, i4);
            CardView cardView = CardView.this;
            Rect rect = cardView.f4035e;
            CardView.super.setPadding(i + rect.left, i2 + rect.top, i3 + rect.right, i4 + rect.bottom);
        }

        @Override // p000a.p006b.p049h.p063k.CardViewDelegate
        /* renamed from: a */
        public void mo7066a(int i, int i2) {
            CardView cardView = CardView.this;
            if (i > cardView.f4033c) {
                CardView.super.setMinimumWidth(i);
            }
            CardView cardView2 = CardView.this;
            if (i2 > cardView2.f4034d) {
                CardView.super.setMinimumHeight(i2);
            }
        }

        @Override // p000a.p006b.p049h.p063k.CardViewDelegate
        /* renamed from: a */
        public View mo7067a() {
            return CardView.this;
        }
    }

    public CardView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, C0364a.cardViewStyle);
    }

    public void setCardBackgroundColor(ColorStateList colorStateList) {
        f4030i.mo8409a(this.f4037g, colorStateList);
    }

    public CardView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        int color;
        ColorStateList valueOf;
        this.f4035e = new Rect();
        this.f4036f = new Rect();
        this.f4037g = new C0691a();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C0368e.CardView, i, C0367d.CardView);
        if (obtainStyledAttributes.hasValue(C0368e.CardView_cardBackgroundColor)) {
            valueOf = obtainStyledAttributes.getColorStateList(C0368e.CardView_cardBackgroundColor);
        } else {
            TypedArray obtainStyledAttributes2 = getContext().obtainStyledAttributes(f4029h);
            int color2 = obtainStyledAttributes2.getColor(0, 0);
            obtainStyledAttributes2.recycle();
            float[] fArr = new float[3];
            Color.colorToHSV(color2, fArr);
            if (fArr[2] > 0.5f) {
                color = getResources().getColor(C0365b.cardview_light_background);
            } else {
                color = getResources().getColor(C0365b.cardview_dark_background);
            }
            valueOf = ColorStateList.valueOf(color);
        }
        ColorStateList colorStateList = valueOf;
        float dimension = obtainStyledAttributes.getDimension(C0368e.CardView_cardCornerRadius, 0.0f);
        float dimension2 = obtainStyledAttributes.getDimension(C0368e.CardView_cardElevation, 0.0f);
        float dimension3 = obtainStyledAttributes.getDimension(C0368e.CardView_cardMaxElevation, 0.0f);
        this.f4031a = obtainStyledAttributes.getBoolean(C0368e.CardView_cardUseCompatPadding, false);
        this.f4032b = obtainStyledAttributes.getBoolean(C0368e.CardView_cardPreventCornerOverlap, true);
        int dimensionPixelSize = obtainStyledAttributes.getDimensionPixelSize(C0368e.CardView_contentPadding, 0);
        this.f4035e.left = obtainStyledAttributes.getDimensionPixelSize(C0368e.CardView_contentPaddingLeft, dimensionPixelSize);
        this.f4035e.top = obtainStyledAttributes.getDimensionPixelSize(C0368e.CardView_contentPaddingTop, dimensionPixelSize);
        this.f4035e.right = obtainStyledAttributes.getDimensionPixelSize(C0368e.CardView_contentPaddingRight, dimensionPixelSize);
        this.f4035e.bottom = obtainStyledAttributes.getDimensionPixelSize(C0368e.CardView_contentPaddingBottom, dimensionPixelSize);
        float f = dimension2 > dimension3 ? dimension2 : dimension3;
        this.f4033c = obtainStyledAttributes.getDimensionPixelSize(C0368e.CardView_android_minWidth, 0);
        this.f4034d = obtainStyledAttributes.getDimensionPixelSize(C0368e.CardView_android_minHeight, 0);
        obtainStyledAttributes.recycle();
        f4030i.mo8410a(this.f4037g, context, colorStateList, dimension, dimension2, f);
    }
}
