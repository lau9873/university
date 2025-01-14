package android.support.v7.widget;

import a.b.h.c.b;
import a.b.h.c.d;
import a.b.h.c.e;
import a.b.h.k.b0;
import a.b.h.k.c0;
import a.b.h.k.d0;
import a.b.h.k.e0;
import a.b.h.k.f0;
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
/* loaded from: classes.dex */
public class CardView extends FrameLayout {

    /* renamed from: h  reason: collision with root package name */
    public static final int[] f2506h = {16842801};

    /* renamed from: i  reason: collision with root package name */
    public static final f0 f2507i;

    /* renamed from: a  reason: collision with root package name */
    public boolean f2508a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f2509b;

    /* renamed from: c  reason: collision with root package name */
    public int f2510c;

    /* renamed from: d  reason: collision with root package name */
    public int f2511d;

    /* renamed from: e  reason: collision with root package name */
    public final Rect f2512e;

    /* renamed from: f  reason: collision with root package name */
    public final Rect f2513f;

    /* renamed from: g  reason: collision with root package name */
    public final e0 f2514g;

    static {
        int i2 = Build.VERSION.SDK_INT;
        if (i2 >= 21) {
            f2507i = new c0();
        } else if (i2 >= 17) {
            f2507i = new b0();
        } else {
            f2507i = new d0();
        }
        f2507i.a();
    }

    public CardView(Context context) {
        this(context, null);
    }

    public ColorStateList getCardBackgroundColor() {
        return f2507i.g(this.f2514g);
    }

    public float getCardElevation() {
        return f2507i.f(this.f2514g);
    }

    public int getContentPaddingBottom() {
        return this.f2512e.bottom;
    }

    public int getContentPaddingLeft() {
        return this.f2512e.left;
    }

    public int getContentPaddingRight() {
        return this.f2512e.right;
    }

    public int getContentPaddingTop() {
        return this.f2512e.top;
    }

    public float getMaxCardElevation() {
        return f2507i.e(this.f2514g);
    }

    public boolean getPreventCornerOverlap() {
        return this.f2509b;
    }

    public float getRadius() {
        return f2507i.h(this.f2514g);
    }

    public boolean getUseCompatPadding() {
        return this.f2508a;
    }

    @Override // android.widget.FrameLayout, android.view.View
    public void onMeasure(int i2, int i3) {
        if (!(f2507i instanceof c0)) {
            int mode = View.MeasureSpec.getMode(i2);
            if (mode == Integer.MIN_VALUE || mode == 1073741824) {
                i2 = View.MeasureSpec.makeMeasureSpec(Math.max((int) Math.ceil(f2507i.b(this.f2514g)), View.MeasureSpec.getSize(i2)), mode);
            }
            int mode2 = View.MeasureSpec.getMode(i3);
            if (mode2 == Integer.MIN_VALUE || mode2 == 1073741824) {
                i3 = View.MeasureSpec.makeMeasureSpec(Math.max((int) Math.ceil(f2507i.a(this.f2514g)), View.MeasureSpec.getSize(i3)), mode2);
            }
            super.onMeasure(i2, i3);
            return;
        }
        super.onMeasure(i2, i3);
    }

    public void setCardBackgroundColor(int i2) {
        f2507i.a(this.f2514g, ColorStateList.valueOf(i2));
    }

    public void setCardElevation(float f2) {
        f2507i.a(this.f2514g, f2);
    }

    public void setMaxCardElevation(float f2) {
        f2507i.b(this.f2514g, f2);
    }

    @Override // android.view.View
    public void setMinimumHeight(int i2) {
        this.f2511d = i2;
        super.setMinimumHeight(i2);
    }

    @Override // android.view.View
    public void setMinimumWidth(int i2) {
        this.f2510c = i2;
        super.setMinimumWidth(i2);
    }

    @Override // android.view.View
    public void setPadding(int i2, int i3, int i4, int i5) {
    }

    @Override // android.view.View
    public void setPaddingRelative(int i2, int i3, int i4, int i5) {
    }

    public void setPreventCornerOverlap(boolean z) {
        if (z != this.f2509b) {
            this.f2509b = z;
            f2507i.d(this.f2514g);
        }
    }

    public void setRadius(float f2) {
        f2507i.c(this.f2514g, f2);
    }

    public void setUseCompatPadding(boolean z) {
        if (this.f2508a != z) {
            this.f2508a = z;
            f2507i.c(this.f2514g);
        }
    }

    /* loaded from: classes.dex */
    public class a implements e0 {

        /* renamed from: a  reason: collision with root package name */
        public Drawable f2515a;

        public a() {
        }

        @Override // a.b.h.k.e0
        public void a(Drawable drawable) {
            this.f2515a = drawable;
            CardView.this.setBackgroundDrawable(drawable);
        }

        @Override // a.b.h.k.e0
        public boolean b() {
            return CardView.this.getPreventCornerOverlap();
        }

        @Override // a.b.h.k.e0
        public boolean c() {
            return CardView.this.getUseCompatPadding();
        }

        @Override // a.b.h.k.e0
        public Drawable d() {
            return this.f2515a;
        }

        @Override // a.b.h.k.e0
        public void a(int i2, int i3, int i4, int i5) {
            CardView.this.f2513f.set(i2, i3, i4, i5);
            CardView cardView = CardView.this;
            Rect rect = cardView.f2512e;
            CardView.super.setPadding(i2 + rect.left, i3 + rect.top, i4 + rect.right, i5 + rect.bottom);
        }

        @Override // a.b.h.k.e0
        public void a(int i2, int i3) {
            CardView cardView = CardView.this;
            if (i2 > cardView.f2510c) {
                CardView.super.setMinimumWidth(i2);
            }
            CardView cardView2 = CardView.this;
            if (i3 > cardView2.f2511d) {
                CardView.super.setMinimumHeight(i3);
            }
        }

        @Override // a.b.h.k.e0
        public View a() {
            return CardView.this;
        }
    }

    public CardView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, a.b.h.c.a.cardViewStyle);
    }

    public void setCardBackgroundColor(ColorStateList colorStateList) {
        f2507i.a(this.f2514g, colorStateList);
    }

    public CardView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        int color;
        ColorStateList valueOf;
        this.f2512e = new Rect();
        this.f2513f = new Rect();
        this.f2514g = new a();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, e.CardView, i2, d.CardView);
        if (obtainStyledAttributes.hasValue(e.CardView_cardBackgroundColor)) {
            valueOf = obtainStyledAttributes.getColorStateList(e.CardView_cardBackgroundColor);
        } else {
            TypedArray obtainStyledAttributes2 = getContext().obtainStyledAttributes(f2506h);
            int color2 = obtainStyledAttributes2.getColor(0, 0);
            obtainStyledAttributes2.recycle();
            float[] fArr = new float[3];
            Color.colorToHSV(color2, fArr);
            if (fArr[2] > 0.5f) {
                color = getResources().getColor(b.cardview_light_background);
            } else {
                color = getResources().getColor(b.cardview_dark_background);
            }
            valueOf = ColorStateList.valueOf(color);
        }
        ColorStateList colorStateList = valueOf;
        float dimension = obtainStyledAttributes.getDimension(e.CardView_cardCornerRadius, 0.0f);
        float dimension2 = obtainStyledAttributes.getDimension(e.CardView_cardElevation, 0.0f);
        float dimension3 = obtainStyledAttributes.getDimension(e.CardView_cardMaxElevation, 0.0f);
        this.f2508a = obtainStyledAttributes.getBoolean(e.CardView_cardUseCompatPadding, false);
        this.f2509b = obtainStyledAttributes.getBoolean(e.CardView_cardPreventCornerOverlap, true);
        int dimensionPixelSize = obtainStyledAttributes.getDimensionPixelSize(e.CardView_contentPadding, 0);
        this.f2512e.left = obtainStyledAttributes.getDimensionPixelSize(e.CardView_contentPaddingLeft, dimensionPixelSize);
        this.f2512e.top = obtainStyledAttributes.getDimensionPixelSize(e.CardView_contentPaddingTop, dimensionPixelSize);
        this.f2512e.right = obtainStyledAttributes.getDimensionPixelSize(e.CardView_contentPaddingRight, dimensionPixelSize);
        this.f2512e.bottom = obtainStyledAttributes.getDimensionPixelSize(e.CardView_contentPaddingBottom, dimensionPixelSize);
        float f2 = dimension2 > dimension3 ? dimension2 : dimension3;
        this.f2510c = obtainStyledAttributes.getDimensionPixelSize(e.CardView_android_minWidth, 0);
        this.f2511d = obtainStyledAttributes.getDimensionPixelSize(e.CardView_android_minHeight, 0);
        obtainStyledAttributes.recycle();
        f2507i.a(this.f2514g, context, colorStateList, dimension, dimension2, f2);
    }
}
