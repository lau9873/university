package android.support.design.widget;

import a.b.d.d;
import a.b.d.j;
import a.b.d.k;
import a.b.d.l.h;
import a.b.d.x.e;
import a.b.d.x.g;
import a.b.d.x.n;
import a.b.d.x.t;
import a.b.g.k.u;
import a.b.g.l.r;
import a.b.h.k.o;
import android.animation.Animator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Parcelable;
import android.support.design.widget.CoordinatorLayout;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import java.util.List;
@CoordinatorLayout.d(Behavior.class)
/* loaded from: classes.dex */
public class FloatingActionButton extends t implements a.b.g.k.t, r, a.b.d.p.a {

    /* renamed from: b  reason: collision with root package name */
    public ColorStateList f2196b;

    /* renamed from: c  reason: collision with root package name */
    public PorterDuff.Mode f2197c;

    /* renamed from: d  reason: collision with root package name */
    public ColorStateList f2198d;

    /* renamed from: e  reason: collision with root package name */
    public PorterDuff.Mode f2199e;

    /* renamed from: f  reason: collision with root package name */
    public int f2200f;

    /* renamed from: g  reason: collision with root package name */
    public ColorStateList f2201g;

    /* renamed from: h  reason: collision with root package name */
    public int f2202h;

    /* renamed from: i  reason: collision with root package name */
    public int f2203i;
    public int j;
    public int k;
    public boolean m;
    public final Rect n;
    public final Rect o;
    public final o p;
    public final a.b.d.p.c q;
    public g r;

    /* loaded from: classes.dex */
    public static class BaseBehavior<T extends FloatingActionButton> extends CoordinatorLayout.c<T> {

        /* renamed from: a  reason: collision with root package name */
        public Rect f2204a;

        /* renamed from: b  reason: collision with root package name */
        public b f2205b;

        /* renamed from: c  reason: collision with root package name */
        public boolean f2206c;

        public BaseBehavior() {
            this.f2206c = true;
        }

        public final boolean b(View view, FloatingActionButton floatingActionButton) {
            if (a(view, floatingActionButton)) {
                if (view.getTop() < (floatingActionButton.getHeight() / 2) + ((ViewGroup.MarginLayoutParams) ((CoordinatorLayout.f) floatingActionButton.getLayoutParams())).topMargin) {
                    floatingActionButton.a(this.f2205b, false);
                    return true;
                }
                floatingActionButton.b(this.f2205b, false);
                return true;
            }
            return false;
        }

        public BaseBehavior(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, k.FloatingActionButton_Behavior_Layout);
            this.f2206c = obtainStyledAttributes.getBoolean(k.FloatingActionButton_Behavior_Layout_behavior_autoHide, true);
            obtainStyledAttributes.recycle();
        }

        @Override // android.support.design.widget.CoordinatorLayout.c
        public void a(CoordinatorLayout.f fVar) {
            if (fVar.f2192h == 0) {
                fVar.f2192h = 80;
            }
        }

        @Override // android.support.design.widget.CoordinatorLayout.c
        /* renamed from: a */
        public boolean b(CoordinatorLayout coordinatorLayout, FloatingActionButton floatingActionButton, View view) {
            if (view instanceof AppBarLayout) {
                a(coordinatorLayout, (AppBarLayout) view, floatingActionButton);
                return false;
            } else if (a(view)) {
                b(view, floatingActionButton);
                return false;
            } else {
                return false;
            }
        }

        public static boolean a(View view) {
            ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
            if (layoutParams instanceof CoordinatorLayout.f) {
                return ((CoordinatorLayout.f) layoutParams).d() instanceof BottomSheetBehavior;
            }
            return false;
        }

        public final boolean a(View view, FloatingActionButton floatingActionButton) {
            return this.f2206c && ((CoordinatorLayout.f) floatingActionButton.getLayoutParams()).c() == view.getId() && floatingActionButton.getUserSetVisibility() == 0;
        }

        public final boolean a(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout, FloatingActionButton floatingActionButton) {
            if (a(appBarLayout, floatingActionButton)) {
                if (this.f2204a == null) {
                    this.f2204a = new Rect();
                }
                Rect rect = this.f2204a;
                e.a(coordinatorLayout, appBarLayout, rect);
                if (rect.bottom <= appBarLayout.getMinimumHeightForVisibleOverlappingContent()) {
                    floatingActionButton.a(this.f2205b, false);
                    return true;
                }
                floatingActionButton.b(this.f2205b, false);
                return true;
            }
            return false;
        }

        @Override // android.support.design.widget.CoordinatorLayout.c
        public boolean a(CoordinatorLayout coordinatorLayout, FloatingActionButton floatingActionButton, int i2) {
            List<View> b2 = coordinatorLayout.b(floatingActionButton);
            int size = b2.size();
            for (int i3 = 0; i3 < size; i3++) {
                View view = b2.get(i3);
                if (view instanceof AppBarLayout) {
                    if (a(coordinatorLayout, (AppBarLayout) view, floatingActionButton)) {
                        break;
                    }
                } else {
                    if (a(view) && b(view, floatingActionButton)) {
                        break;
                    }
                }
            }
            coordinatorLayout.d(floatingActionButton, i2);
            a(coordinatorLayout, floatingActionButton);
            return true;
        }

        @Override // android.support.design.widget.CoordinatorLayout.c
        public boolean a(CoordinatorLayout coordinatorLayout, FloatingActionButton floatingActionButton, Rect rect) {
            Rect rect2 = floatingActionButton.n;
            rect.set(floatingActionButton.getLeft() + rect2.left, floatingActionButton.getTop() + rect2.top, floatingActionButton.getRight() - rect2.right, floatingActionButton.getBottom() - rect2.bottom);
            return true;
        }

        public final void a(CoordinatorLayout coordinatorLayout, FloatingActionButton floatingActionButton) {
            int i2;
            Rect rect = floatingActionButton.n;
            if (rect == null || rect.centerX() <= 0 || rect.centerY() <= 0) {
                return;
            }
            CoordinatorLayout.f fVar = (CoordinatorLayout.f) floatingActionButton.getLayoutParams();
            int i3 = 0;
            if (floatingActionButton.getRight() >= coordinatorLayout.getWidth() - ((ViewGroup.MarginLayoutParams) fVar).rightMargin) {
                i2 = rect.right;
            } else {
                i2 = floatingActionButton.getLeft() <= ((ViewGroup.MarginLayoutParams) fVar).leftMargin ? -rect.left : 0;
            }
            if (floatingActionButton.getBottom() >= coordinatorLayout.getHeight() - ((ViewGroup.MarginLayoutParams) fVar).bottomMargin) {
                i3 = rect.bottom;
            } else if (floatingActionButton.getTop() <= ((ViewGroup.MarginLayoutParams) fVar).topMargin) {
                i3 = -rect.top;
            }
            if (i3 != 0) {
                u.d(floatingActionButton, i3);
            }
            if (i2 != 0) {
                u.c(floatingActionButton, i2);
            }
        }
    }

    /* loaded from: classes.dex */
    public static class Behavior extends BaseBehavior<FloatingActionButton> {
        public Behavior() {
        }

        public Behavior(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }
    }

    /* loaded from: classes.dex */
    public class a implements g.InterfaceC0008g {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ b f2207a;

        public a(b bVar) {
            this.f2207a = bVar;
        }

        @Override // a.b.d.x.g.InterfaceC0008g
        public void a() {
            this.f2207a.b(FloatingActionButton.this);
        }

        @Override // a.b.d.x.g.InterfaceC0008g
        public void b() {
            this.f2207a.a(FloatingActionButton.this);
        }
    }

    /* loaded from: classes.dex */
    public static abstract class b {
        public abstract void a(FloatingActionButton floatingActionButton);

        public abstract void b(FloatingActionButton floatingActionButton);
    }

    public FloatingActionButton(Context context) {
        this(context, null);
    }

    private g getImpl() {
        if (this.r == null) {
            this.r = b();
        }
        return this.r;
    }

    public void b(b bVar, boolean z) {
        getImpl().b(a(bVar), z);
    }

    public void c(Animator.AnimatorListener animatorListener) {
        getImpl().c(animatorListener);
    }

    public final void d() {
        Drawable drawable = getDrawable();
        if (drawable == null) {
            return;
        }
        ColorStateList colorStateList = this.f2198d;
        if (colorStateList == null) {
            a.b.g.c.j.a.b(drawable);
            return;
        }
        int colorForState = colorStateList.getColorForState(getDrawableState(), 0);
        PorterDuff.Mode mode = this.f2199e;
        if (mode == null) {
            mode = PorterDuff.Mode.SRC_IN;
        }
        drawable.mutate().setColorFilter(a.b.h.k.k.a(colorForState, mode));
    }

    @Override // android.widget.ImageView, android.view.View
    public void drawableStateChanged() {
        super.drawableStateChanged();
        getImpl().a(getDrawableState());
    }

    @Override // android.view.View
    public ColorStateList getBackgroundTintList() {
        return this.f2196b;
    }

    @Override // android.view.View
    public PorterDuff.Mode getBackgroundTintMode() {
        return this.f2197c;
    }

    public float getCompatElevation() {
        return getImpl().f();
    }

    public float getCompatHoveredFocusedTranslationZ() {
        return getImpl().h();
    }

    public float getCompatPressedTranslationZ() {
        return getImpl().i();
    }

    public Drawable getContentBackground() {
        return getImpl().c();
    }

    public int getCustomSize() {
        return this.f2203i;
    }

    public int getExpandedComponentIdHint() {
        return this.q.b();
    }

    public h getHideMotionSpec() {
        return getImpl().g();
    }

    @Deprecated
    public int getRippleColor() {
        ColorStateList colorStateList = this.f2201g;
        if (colorStateList != null) {
            return colorStateList.getDefaultColor();
        }
        return 0;
    }

    public ColorStateList getRippleColorStateList() {
        return this.f2201g;
    }

    public h getShowMotionSpec() {
        return getImpl().j();
    }

    public int getSize() {
        return this.f2202h;
    }

    public int getSizeDimension() {
        return a(this.f2202h);
    }

    @Override // a.b.g.k.t
    public ColorStateList getSupportBackgroundTintList() {
        return getBackgroundTintList();
    }

    @Override // a.b.g.k.t
    public PorterDuff.Mode getSupportBackgroundTintMode() {
        return getBackgroundTintMode();
    }

    @Override // a.b.g.l.r
    public ColorStateList getSupportImageTintList() {
        return this.f2198d;
    }

    @Override // a.b.g.l.r
    public PorterDuff.Mode getSupportImageTintMode() {
        return this.f2199e;
    }

    public boolean getUseCompatPadding() {
        return this.m;
    }

    @Override // android.widget.ImageView, android.view.View
    public void jumpDrawablesToCurrentState() {
        super.jumpDrawablesToCurrentState();
        getImpl().m();
    }

    @Override // android.widget.ImageView, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        getImpl().p();
    }

    @Override // android.widget.ImageView, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        getImpl().r();
    }

    @Override // android.widget.ImageView, android.view.View
    public void onMeasure(int i2, int i3) {
        int sizeDimension = getSizeDimension();
        this.j = (sizeDimension - this.k) / 2;
        getImpl().x();
        int min = Math.min(a(sizeDimension, i2), a(sizeDimension, i3));
        Rect rect = this.n;
        setMeasuredDimension(rect.left + min + rect.right, min + rect.top + rect.bottom);
    }

    @Override // android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof a.b.d.v.a)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        a.b.d.v.a aVar = (a.b.d.v.a) parcelable;
        super.onRestoreInstanceState(aVar.a());
        this.q.a(aVar.f297c.get("expandableWidgetHelper"));
    }

    @Override // android.view.View
    public Parcelable onSaveInstanceState() {
        a.b.d.v.a aVar = new a.b.d.v.a(super.onSaveInstanceState());
        aVar.f297c.put("expandableWidgetHelper", this.q.d());
        return aVar;
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (motionEvent.getAction() == 0 && a(this.o) && !this.o.contains((int) motionEvent.getX(), (int) motionEvent.getY())) {
            return false;
        }
        return super.onTouchEvent(motionEvent);
    }

    @Override // android.view.View
    public void setBackgroundColor(int i2) {
        Log.i("FloatingActionButton", "Setting a custom background is not supported.");
    }

    @Override // android.view.View
    public void setBackgroundDrawable(Drawable drawable) {
        Log.i("FloatingActionButton", "Setting a custom background is not supported.");
    }

    @Override // android.view.View
    public void setBackgroundResource(int i2) {
        Log.i("FloatingActionButton", "Setting a custom background is not supported.");
    }

    @Override // android.view.View
    public void setBackgroundTintList(ColorStateList colorStateList) {
        if (this.f2196b != colorStateList) {
            this.f2196b = colorStateList;
            getImpl().a(colorStateList);
        }
    }

    @Override // android.view.View
    public void setBackgroundTintMode(PorterDuff.Mode mode) {
        if (this.f2197c != mode) {
            this.f2197c = mode;
            getImpl().a(mode);
        }
    }

    public void setCompatElevation(float f2) {
        getImpl().a(f2);
    }

    public void setCompatElevationResource(int i2) {
        setCompatElevation(getResources().getDimension(i2));
    }

    public void setCompatHoveredFocusedTranslationZ(float f2) {
        getImpl().b(f2);
    }

    public void setCompatHoveredFocusedTranslationZResource(int i2) {
        setCompatHoveredFocusedTranslationZ(getResources().getDimension(i2));
    }

    public void setCompatPressedTranslationZ(float f2) {
        getImpl().d(f2);
    }

    public void setCompatPressedTranslationZResource(int i2) {
        setCompatPressedTranslationZ(getResources().getDimension(i2));
    }

    public void setCustomSize(int i2) {
        if (i2 >= 0) {
            this.f2203i = i2;
            return;
        }
        throw new IllegalArgumentException("Custom size must be non-negative");
    }

    public void setExpandedComponentIdHint(int i2) {
        this.q.a(i2);
    }

    public void setHideMotionSpec(h hVar) {
        getImpl().a(hVar);
    }

    public void setHideMotionSpecResource(int i2) {
        setHideMotionSpec(h.a(getContext(), i2));
    }

    @Override // android.widget.ImageView
    public void setImageDrawable(Drawable drawable) {
        super.setImageDrawable(drawable);
        getImpl().w();
    }

    @Override // android.widget.ImageView
    public void setImageResource(int i2) {
        this.p.a(i2);
    }

    public void setRippleColor(int i2) {
        setRippleColor(ColorStateList.valueOf(i2));
    }

    public void setShowMotionSpec(h hVar) {
        getImpl().b(hVar);
    }

    public void setShowMotionSpecResource(int i2) {
        setShowMotionSpec(h.a(getContext(), i2));
    }

    public void setSize(int i2) {
        this.f2203i = 0;
        if (i2 != this.f2202h) {
            this.f2202h = i2;
            requestLayout();
        }
    }

    @Override // a.b.g.k.t
    public void setSupportBackgroundTintList(ColorStateList colorStateList) {
        setBackgroundTintList(colorStateList);
    }

    @Override // a.b.g.k.t
    public void setSupportBackgroundTintMode(PorterDuff.Mode mode) {
        setBackgroundTintMode(mode);
    }

    @Override // a.b.g.l.r
    public void setSupportImageTintList(ColorStateList colorStateList) {
        if (this.f2198d != colorStateList) {
            this.f2198d = colorStateList;
            d();
        }
    }

    @Override // a.b.g.l.r
    public void setSupportImageTintMode(PorterDuff.Mode mode) {
        if (this.f2199e != mode) {
            this.f2199e = mode;
            d();
        }
    }

    public void setUseCompatPadding(boolean z) {
        if (this.m != z) {
            this.m = z;
            getImpl().q();
        }
    }

    public FloatingActionButton(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, a.b.d.b.floatingActionButtonStyle);
    }

    public void b(Animator.AnimatorListener animatorListener) {
        getImpl().b(animatorListener);
    }

    public boolean c() {
        return getImpl().l();
    }

    public void setRippleColor(ColorStateList colorStateList) {
        if (this.f2201g != colorStateList) {
            this.f2201g = colorStateList;
            getImpl().b(this.f2201g);
        }
    }

    public FloatingActionButton(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.n = new Rect();
        this.o = new Rect();
        TypedArray c2 = a.b.d.q.g.c(context, attributeSet, k.FloatingActionButton, i2, j.Widget_Design_FloatingActionButton, new int[0]);
        this.f2196b = a.b.d.r.a.a(context, c2, k.FloatingActionButton_backgroundTint);
        this.f2197c = a.b.d.q.h.a(c2.getInt(k.FloatingActionButton_backgroundTintMode, -1), null);
        this.f2201g = a.b.d.r.a.a(context, c2, k.FloatingActionButton_rippleColor);
        this.f2202h = c2.getInt(k.FloatingActionButton_fabSize, -1);
        this.f2203i = c2.getDimensionPixelSize(k.FloatingActionButton_fabCustomSize, 0);
        this.f2200f = c2.getDimensionPixelSize(k.FloatingActionButton_borderWidth, 0);
        float dimension = c2.getDimension(k.FloatingActionButton_elevation, 0.0f);
        float dimension2 = c2.getDimension(k.FloatingActionButton_hoveredFocusedTranslationZ, 0.0f);
        float dimension3 = c2.getDimension(k.FloatingActionButton_pressedTranslationZ, 0.0f);
        this.m = c2.getBoolean(k.FloatingActionButton_useCompatPadding, false);
        this.k = c2.getDimensionPixelSize(k.FloatingActionButton_maxImageSize, 0);
        h a2 = h.a(context, c2, k.FloatingActionButton_showMotionSpec);
        h a3 = h.a(context, c2, k.FloatingActionButton_hideMotionSpec);
        c2.recycle();
        this.p = new o(this);
        this.p.a(attributeSet, i2);
        this.q = new a.b.d.p.c(this);
        getImpl().a(this.f2196b, this.f2197c, this.f2201g, this.f2200f);
        getImpl().a(dimension);
        getImpl().b(dimension2);
        getImpl().d(dimension3);
        getImpl().a(this.k);
        getImpl().b(a2);
        getImpl().a(a3);
        setScaleType(ImageView.ScaleType.MATRIX);
    }

    public void a(b bVar, boolean z) {
        getImpl().a(a(bVar), z);
    }

    public void b(Rect rect) {
        rect.set(0, 0, getMeasuredWidth(), getMeasuredHeight());
        c(rect);
    }

    public final void c(Rect rect) {
        int i2 = rect.left;
        Rect rect2 = this.n;
        rect.left = i2 + rect2.left;
        rect.top += rect2.top;
        rect.right -= rect2.right;
        rect.bottom -= rect2.bottom;
    }

    /* loaded from: classes.dex */
    public class c implements n {
        public c() {
        }

        @Override // a.b.d.x.n
        public void a(int i2, int i3, int i4, int i5) {
            FloatingActionButton.this.n.set(i2, i3, i4, i5);
            FloatingActionButton floatingActionButton = FloatingActionButton.this;
            floatingActionButton.setPadding(i2 + floatingActionButton.j, i3 + FloatingActionButton.this.j, i4 + FloatingActionButton.this.j, i5 + FloatingActionButton.this.j);
        }

        @Override // a.b.d.x.n
        public float b() {
            return FloatingActionButton.this.getSizeDimension() / 2.0f;
        }

        @Override // a.b.d.x.n
        public void a(Drawable drawable) {
            FloatingActionButton.super.setBackgroundDrawable(drawable);
        }

        @Override // a.b.d.x.n
        public boolean a() {
            return FloatingActionButton.this.m;
        }
    }

    public void a(Animator.AnimatorListener animatorListener) {
        getImpl().a(animatorListener);
    }

    @Override // a.b.d.p.b
    public boolean a() {
        return this.q.c();
    }

    public final g b() {
        if (Build.VERSION.SDK_INT >= 21) {
            return new a.b.d.x.h(this, new c());
        }
        return new g(this, new c());
    }

    public final g.InterfaceC0008g a(b bVar) {
        if (bVar == null) {
            return null;
        }
        return new a(bVar);
    }

    public final int a(int i2) {
        int i3 = this.f2203i;
        if (i3 != 0) {
            return i3;
        }
        Resources resources = getResources();
        if (i2 != -1) {
            if (i2 != 1) {
                return resources.getDimensionPixelSize(d.design_fab_size_normal);
            }
            return resources.getDimensionPixelSize(d.design_fab_size_mini);
        } else if (Math.max(resources.getConfiguration().screenWidthDp, resources.getConfiguration().screenHeightDp) < 470) {
            return a(1);
        } else {
            return a(0);
        }
    }

    public void d(Animator.AnimatorListener animatorListener) {
        getImpl().d(animatorListener);
    }

    @Deprecated
    public boolean a(Rect rect) {
        if (u.x(this)) {
            rect.set(0, 0, getWidth(), getHeight());
            c(rect);
            return true;
        }
        return false;
    }

    public static int a(int i2, int i3) {
        int mode = View.MeasureSpec.getMode(i3);
        int size = View.MeasureSpec.getSize(i3);
        if (mode != Integer.MIN_VALUE) {
            if (mode != 0) {
                if (mode == 1073741824) {
                    return size;
                }
                throw new IllegalArgumentException();
            }
            return i2;
        }
        return Math.min(i2, size);
    }
}
