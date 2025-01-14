package android.support.design.widget;

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
import p000a.p006b.p012d.C0040b;
import p000a.p006b.p012d.C0042d;
import p000a.p006b.p012d.C0048j;
import p000a.p006b.p012d.C0049k;
import p000a.p006b.p012d.p013l.MotionSpec;
import p000a.p006b.p012d.p018p.ExpandableTransformationWidget;
import p000a.p006b.p012d.p018p.ExpandableWidgetHelper;
import p000a.p006b.p012d.p019q.ThemeEnforcement;
import p000a.p006b.p012d.p019q.ViewUtils;
import p000a.p006b.p012d.p020r.MaterialResources;
import p000a.p006b.p012d.p024v.ExtendableSavedState;
import p000a.p006b.p012d.p026x.DescendantOffsetUtils;
import p000a.p006b.p012d.p026x.FloatingActionButtonImpl;
import p000a.p006b.p012d.p026x.FloatingActionButtonImplLollipop;
import p000a.p006b.p012d.p026x.ShadowViewDelegate;
import p000a.p006b.p012d.p026x.VisibilityAwareImageButton;
import p000a.p006b.p030g.p034c.p035j.DrawableCompat;
import p000a.p006b.p030g.p045k.TintableBackgroundView;
import p000a.p006b.p030g.p045k.ViewCompat;
import p000a.p006b.p030g.p048l.TintableImageSourceView;
import p000a.p006b.p049h.p063k.AppCompatDrawableManager;
import p000a.p006b.p049h.p063k.AppCompatImageHelper;

@CoordinatorLayout.InterfaceC0576d(Behavior.class)
/* loaded from: classes.dex */
public class FloatingActionButton extends VisibilityAwareImageButton implements TintableBackgroundView, TintableImageSourceView, ExpandableTransformationWidget {

    /* renamed from: b */
    public ColorStateList f3346b;

    /* renamed from: c */
    public PorterDuff.Mode f3347c;

    /* renamed from: d */
    public ColorStateList f3348d;

    /* renamed from: e */
    public PorterDuff.Mode f3349e;

    /* renamed from: f */
    public int f3350f;

    /* renamed from: g */
    public ColorStateList f3351g;

    /* renamed from: h */
    public int f3352h;

    /* renamed from: i */
    public int f3353i;

    /* renamed from: j */
    public int f3354j;

    /* renamed from: k */
    public int f3355k;

    /* renamed from: m */
    public boolean f3356m;

    /* renamed from: n */
    public final Rect f3357n;

    /* renamed from: o */
    public final Rect f3358o;

    /* renamed from: p */
    public final AppCompatImageHelper f3359p;

    /* renamed from: q */
    public final ExpandableWidgetHelper f3360q;

    /* renamed from: r */
    public FloatingActionButtonImpl f3361r;

    /* loaded from: classes.dex */
    public static class BaseBehavior<T extends FloatingActionButton> extends CoordinatorLayout.AbstractC0575c<T> {

        /* renamed from: a */
        public Rect f3362a;

        /* renamed from: b */
        public AbstractC0584b f3363b;

        /* renamed from: c */
        public boolean f3364c;

        public BaseBehavior() {
            this.f3364c = true;
        }

        /* renamed from: b */
        public final boolean m7638b(View view, FloatingActionButton floatingActionButton) {
            if (m7640a(view, floatingActionButton)) {
                if (view.getTop() < (floatingActionButton.getHeight() / 2) + ((ViewGroup.MarginLayoutParams) ((CoordinatorLayout.C0578f) floatingActionButton.getLayoutParams())).topMargin) {
                    floatingActionButton.m7661a(this.f3363b, false);
                    return true;
                }
                floatingActionButton.m7655b(this.f3363b, false);
                return true;
            }
            return false;
        }

        public BaseBehavior(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C0049k.FloatingActionButton_Behavior_Layout);
            this.f3364c = obtainStyledAttributes.getBoolean(C0049k.FloatingActionButton_Behavior_Layout_behavior_autoHide, true);
            obtainStyledAttributes.recycle();
        }

        @Override // android.support.design.widget.CoordinatorLayout.AbstractC0575c
        /* renamed from: a */
        public void mo7649a(CoordinatorLayout.C0578f c0578f) {
            if (c0578f.f3334h == 0) {
                c0578f.f3334h = 80;
            }
        }

        @Override // android.support.design.widget.CoordinatorLayout.AbstractC0575c
        /* renamed from: a */
        public boolean mo7639b(CoordinatorLayout coordinatorLayout, FloatingActionButton floatingActionButton, View view) {
            if (view instanceof AppBarLayout) {
                m7648a(coordinatorLayout, (AppBarLayout) view, floatingActionButton);
                return false;
            } else if (m7641a(view)) {
                m7638b(view, floatingActionButton);
                return false;
            } else {
                return false;
            }
        }

        /* renamed from: a */
        public static boolean m7641a(View view) {
            ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
            if (layoutParams instanceof CoordinatorLayout.C0578f) {
                return ((CoordinatorLayout.C0578f) layoutParams).m7673d() instanceof BottomSheetBehavior;
            }
            return false;
        }

        /* renamed from: a */
        public final boolean m7640a(View view, FloatingActionButton floatingActionButton) {
            return this.f3364c && ((CoordinatorLayout.C0578f) floatingActionButton.getLayoutParams()).m7674c() == view.getId() && floatingActionButton.getUserSetVisibility() == 0;
        }

        /* renamed from: a */
        public final boolean m7648a(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout, FloatingActionButton floatingActionButton) {
            if (m7640a(appBarLayout, floatingActionButton)) {
                if (this.f3362a == null) {
                    this.f3362a = new Rect();
                }
                Rect rect = this.f3362a;
                DescendantOffsetUtils.m10797a(coordinatorLayout, appBarLayout, rect);
                if (rect.bottom <= appBarLayout.getMinimumHeightForVisibleOverlappingContent()) {
                    floatingActionButton.m7661a(this.f3363b, false);
                    return true;
                }
                floatingActionButton.m7655b(this.f3363b, false);
                return true;
            }
            return false;
        }

        @Override // android.support.design.widget.CoordinatorLayout.AbstractC0575c
        /* renamed from: a */
        public boolean mo7643a(CoordinatorLayout coordinatorLayout, FloatingActionButton floatingActionButton, int i) {
            List<View> m7731b = coordinatorLayout.m7731b(floatingActionButton);
            int size = m7731b.size();
            for (int i2 = 0; i2 < size; i2++) {
                View view = m7731b.get(i2);
                if (view instanceof AppBarLayout) {
                    if (m7648a(coordinatorLayout, (AppBarLayout) view, floatingActionButton)) {
                        break;
                    }
                } else {
                    if (m7641a(view) && m7638b(view, floatingActionButton)) {
                        break;
                    }
                }
            }
            coordinatorLayout.m7719d(floatingActionButton, i);
            m7647a(coordinatorLayout, floatingActionButton);
            return true;
        }

        @Override // android.support.design.widget.CoordinatorLayout.AbstractC0575c
        /* renamed from: a */
        public boolean mo7642a(CoordinatorLayout coordinatorLayout, FloatingActionButton floatingActionButton, Rect rect) {
            Rect rect2 = floatingActionButton.f3357n;
            rect.set(floatingActionButton.getLeft() + rect2.left, floatingActionButton.getTop() + rect2.top, floatingActionButton.getRight() - rect2.right, floatingActionButton.getBottom() - rect2.bottom);
            return true;
        }

        /* renamed from: a */
        public final void m7647a(CoordinatorLayout coordinatorLayout, FloatingActionButton floatingActionButton) {
            int i;
            Rect rect = floatingActionButton.f3357n;
            if (rect == null || rect.centerX() <= 0 || rect.centerY() <= 0) {
                return;
            }
            CoordinatorLayout.C0578f c0578f = (CoordinatorLayout.C0578f) floatingActionButton.getLayoutParams();
            int i2 = 0;
            if (floatingActionButton.getRight() >= coordinatorLayout.getWidth() - ((ViewGroup.MarginLayoutParams) c0578f).rightMargin) {
                i = rect.right;
            } else {
                i = floatingActionButton.getLeft() <= ((ViewGroup.MarginLayoutParams) c0578f).leftMargin ? -rect.left : 0;
            }
            if (floatingActionButton.getBottom() >= coordinatorLayout.getHeight() - ((ViewGroup.MarginLayoutParams) c0578f).bottomMargin) {
                i2 = rect.bottom;
            } else if (floatingActionButton.getTop() <= ((ViewGroup.MarginLayoutParams) c0578f).topMargin) {
                i2 = -rect.top;
            }
            if (i2 != 0) {
                ViewCompat.m9433d(floatingActionButton, i2);
            }
            if (i != 0) {
                ViewCompat.m9435c(floatingActionButton, i);
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

    /* renamed from: android.support.design.widget.FloatingActionButton$a */
    /* loaded from: classes.dex */
    public class C0583a implements FloatingActionButtonImpl.InterfaceC0070g {

        /* renamed from: a */
        public final /* synthetic */ AbstractC0584b f3365a;

        public C0583a(AbstractC0584b abstractC0584b) {
            this.f3365a = abstractC0584b;
        }

        @Override // p000a.p006b.p012d.p026x.FloatingActionButtonImpl.InterfaceC0070g
        /* renamed from: a */
        public void mo7637a() {
            this.f3365a.m7634b(FloatingActionButton.this);
        }

        @Override // p000a.p006b.p012d.p026x.FloatingActionButtonImpl.InterfaceC0070g
        /* renamed from: b */
        public void mo7636b() {
            this.f3365a.m7635a(FloatingActionButton.this);
        }
    }

    /* renamed from: android.support.design.widget.FloatingActionButton$b */
    /* loaded from: classes.dex */
    public static abstract class AbstractC0584b {
        /* renamed from: a */
        public abstract void m7635a(FloatingActionButton floatingActionButton);

        /* renamed from: b */
        public abstract void m7634b(FloatingActionButton floatingActionButton);
    }

    public FloatingActionButton(Context context) {
        this(context, null);
    }

    private FloatingActionButtonImpl getImpl() {
        if (this.f3361r == null) {
            this.f3361r = m7658b();
        }
        return this.f3361r;
    }

    /* renamed from: b */
    public void m7655b(AbstractC0584b abstractC0584b, boolean z) {
        getImpl().m10777b(m7662a(abstractC0584b), z);
    }

    /* renamed from: c */
    public void m7653c(Animator.AnimatorListener animatorListener) {
        getImpl().m10773c(animatorListener);
    }

    /* renamed from: d */
    public final void m7651d() {
        Drawable drawable = getDrawable();
        if (drawable == null) {
            return;
        }
        ColorStateList colorStateList = this.f3348d;
        if (colorStateList == null) {
            DrawableCompat.m9856b(drawable);
            return;
        }
        int colorForState = colorStateList.getColorForState(getDrawableState(), 0);
        PorterDuff.Mode mode = this.f3349e;
        if (mode == null) {
            mode = PorterDuff.Mode.SRC_IN;
        }
        drawable.mutate().setColorFilter(AppCompatDrawableManager.m8316a(colorForState, mode));
    }

    @Override // android.widget.ImageView, android.view.View
    public void drawableStateChanged() {
        super.drawableStateChanged();
        getImpl().mo10750a(getDrawableState());
    }

    @Override // android.view.View
    public ColorStateList getBackgroundTintList() {
        return this.f3346b;
    }

    @Override // android.view.View
    public PorterDuff.Mode getBackgroundTintMode() {
        return this.f3347c;
    }

    public float getCompatElevation() {
        return getImpl().mo10747f();
    }

    public float getCompatHoveredFocusedTranslationZ() {
        return getImpl().m10767h();
    }

    public float getCompatPressedTranslationZ() {
        return getImpl().m10766i();
    }

    public Drawable getContentBackground() {
        return getImpl().m10775c();
    }

    public int getCustomSize() {
        return this.f3353i;
    }

    public int getExpandedComponentIdHint() {
        return this.f3360q.m10886b();
    }

    public MotionSpec getHideMotionSpec() {
        return getImpl().m10768g();
    }

    @Deprecated
    public int getRippleColor() {
        ColorStateList colorStateList = this.f3351g;
        if (colorStateList != null) {
            return colorStateList.getDefaultColor();
        }
        return 0;
    }

    public ColorStateList getRippleColorStateList() {
        return this.f3351g;
    }

    public MotionSpec getShowMotionSpec() {
        return getImpl().m10765j();
    }

    public int getSize() {
        return this.f3352h;
    }

    public int getSizeDimension() {
        return m7666a(this.f3352h);
    }

    @Override // p000a.p006b.p030g.p045k.TintableBackgroundView
    public ColorStateList getSupportBackgroundTintList() {
        return getBackgroundTintList();
    }

    @Override // p000a.p006b.p030g.p045k.TintableBackgroundView
    public PorterDuff.Mode getSupportBackgroundTintMode() {
        return getBackgroundTintMode();
    }

    @Override // p000a.p006b.p030g.p048l.TintableImageSourceView
    public ColorStateList getSupportImageTintList() {
        return this.f3348d;
    }

    @Override // p000a.p006b.p030g.p048l.TintableImageSourceView
    public PorterDuff.Mode getSupportImageTintMode() {
        return this.f3349e;
    }

    public boolean getUseCompatPadding() {
        return this.f3356m;
    }

    @Override // android.widget.ImageView, android.view.View
    public void jumpDrawablesToCurrentState() {
        super.jumpDrawablesToCurrentState();
        getImpl().mo10746m();
    }

    @Override // android.widget.ImageView, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        getImpl().m10762p();
    }

    @Override // android.widget.ImageView, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        getImpl().m10761r();
    }

    @Override // android.widget.ImageView, android.view.View
    public void onMeasure(int i, int i2) {
        int sizeDimension = getSizeDimension();
        this.f3354j = (sizeDimension - this.f3355k) / 2;
        getImpl().m10756x();
        int min = Math.min(m7665a(sizeDimension, i), m7665a(sizeDimension, i2));
        Rect rect = this.f3357n;
        setMeasuredDimension(rect.left + min + rect.right, min + rect.top + rect.bottom);
    }

    @Override // android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof ExtendableSavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        ExtendableSavedState extendableSavedState = (ExtendableSavedState) parcelable;
        super.onRestoreInstanceState(extendableSavedState.m9588a());
        this.f3360q.m10887a(extendableSavedState.f552c.get("expandableWidgetHelper"));
    }

    @Override // android.view.View
    public Parcelable onSaveInstanceState() {
        ExtendableSavedState extendableSavedState = new ExtendableSavedState(super.onSaveInstanceState());
        extendableSavedState.f552c.put("expandableWidgetHelper", this.f3360q.m10884d());
        return extendableSavedState;
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (motionEvent.getAction() == 0 && m7663a(this.f3358o) && !this.f3358o.contains((int) motionEvent.getX(), (int) motionEvent.getY())) {
            return false;
        }
        return super.onTouchEvent(motionEvent);
    }

    @Override // android.view.View
    public void setBackgroundColor(int i) {
        Log.i("FloatingActionButton", "Setting a custom background is not supported.");
    }

    @Override // android.view.View
    public void setBackgroundDrawable(Drawable drawable) {
        Log.i("FloatingActionButton", "Setting a custom background is not supported.");
    }

    @Override // android.view.View
    public void setBackgroundResource(int i) {
        Log.i("FloatingActionButton", "Setting a custom background is not supported.");
    }

    @Override // android.view.View
    public void setBackgroundTintList(ColorStateList colorStateList) {
        if (this.f3346b != colorStateList) {
            this.f3346b = colorStateList;
            getImpl().m10782a(colorStateList);
        }
    }

    @Override // android.view.View
    public void setBackgroundTintMode(PorterDuff.Mode mode) {
        if (this.f3347c != mode) {
            this.f3347c = mode;
            getImpl().m10781a(mode);
        }
    }

    public void setCompatElevation(float f) {
        getImpl().m10791a(f);
    }

    public void setCompatElevationResource(int i) {
        setCompatElevation(getResources().getDimension(i));
    }

    public void setCompatHoveredFocusedTranslationZ(float f) {
        getImpl().m10779b(f);
    }

    public void setCompatHoveredFocusedTranslationZResource(int i) {
        setCompatHoveredFocusedTranslationZ(getResources().getDimension(i));
    }

    public void setCompatPressedTranslationZ(float f) {
        getImpl().m10771d(f);
    }

    public void setCompatPressedTranslationZResource(int i) {
        setCompatPressedTranslationZ(getResources().getDimension(i));
    }

    public void setCustomSize(int i) {
        if (i >= 0) {
            this.f3353i = i;
            return;
        }
        throw new IllegalArgumentException("Custom size must be non-negative");
    }

    public void setExpandedComponentIdHint(int i) {
        this.f3360q.m10888a(i);
    }

    public void setHideMotionSpec(MotionSpec motionSpec) {
        getImpl().m10787a(motionSpec);
    }

    public void setHideMotionSpecResource(int i) {
        setHideMotionSpec(MotionSpec.m10960a(getContext(), i));
    }

    @Override // android.widget.ImageView
    public void setImageDrawable(Drawable drawable) {
        super.setImageDrawable(drawable);
        getImpl().m10757w();
    }

    @Override // android.widget.ImageView
    public void setImageResource(int i) {
        this.f3359p.m8179a(i);
    }

    public void setRippleColor(int i) {
        setRippleColor(ColorStateList.valueOf(i));
    }

    public void setShowMotionSpec(MotionSpec motionSpec) {
        getImpl().m10778b(motionSpec);
    }

    public void setShowMotionSpecResource(int i) {
        setShowMotionSpec(MotionSpec.m10960a(getContext(), i));
    }

    public void setSize(int i) {
        this.f3353i = 0;
        if (i != this.f3352h) {
            this.f3352h = i;
            requestLayout();
        }
    }

    @Override // p000a.p006b.p030g.p045k.TintableBackgroundView
    public void setSupportBackgroundTintList(ColorStateList colorStateList) {
        setBackgroundTintList(colorStateList);
    }

    @Override // p000a.p006b.p030g.p045k.TintableBackgroundView
    public void setSupportBackgroundTintMode(PorterDuff.Mode mode) {
        setBackgroundTintMode(mode);
    }

    @Override // p000a.p006b.p030g.p048l.TintableImageSourceView
    public void setSupportImageTintList(ColorStateList colorStateList) {
        if (this.f3348d != colorStateList) {
            this.f3348d = colorStateList;
            m7651d();
        }
    }

    @Override // p000a.p006b.p030g.p048l.TintableImageSourceView
    public void setSupportImageTintMode(PorterDuff.Mode mode) {
        if (this.f3349e != mode) {
            this.f3349e = mode;
            m7651d();
        }
    }

    public void setUseCompatPadding(boolean z) {
        if (this.f3356m != z) {
            this.f3356m = z;
            getImpl().mo10743q();
        }
    }

    public FloatingActionButton(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, C0040b.floatingActionButtonStyle);
    }

    /* renamed from: b */
    public void m7657b(Animator.AnimatorListener animatorListener) {
        getImpl().m10776b(animatorListener);
    }

    /* renamed from: c */
    public boolean m7654c() {
        return getImpl().m10763l();
    }

    public void setRippleColor(ColorStateList colorStateList) {
        if (this.f3351g != colorStateList) {
            this.f3351g = colorStateList;
            getImpl().mo10749b(this.f3351g);
        }
    }

    public FloatingActionButton(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f3357n = new Rect();
        this.f3358o = new Rect();
        TypedArray m10861c = ThemeEnforcement.m10861c(context, attributeSet, C0049k.FloatingActionButton, i, C0048j.Widget_Design_FloatingActionButton, new int[0]);
        this.f3346b = MaterialResources.m10857a(context, m10861c, C0049k.FloatingActionButton_backgroundTint);
        this.f3347c = ViewUtils.m10859a(m10861c.getInt(C0049k.FloatingActionButton_backgroundTintMode, -1), null);
        this.f3351g = MaterialResources.m10857a(context, m10861c, C0049k.FloatingActionButton_rippleColor);
        this.f3352h = m10861c.getInt(C0049k.FloatingActionButton_fabSize, -1);
        this.f3353i = m10861c.getDimensionPixelSize(C0049k.FloatingActionButton_fabCustomSize, 0);
        this.f3350f = m10861c.getDimensionPixelSize(C0049k.FloatingActionButton_borderWidth, 0);
        float dimension = m10861c.getDimension(C0049k.FloatingActionButton_elevation, 0.0f);
        float dimension2 = m10861c.getDimension(C0049k.FloatingActionButton_hoveredFocusedTranslationZ, 0.0f);
        float dimension3 = m10861c.getDimension(C0049k.FloatingActionButton_pressedTranslationZ, 0.0f);
        this.f3356m = m10861c.getBoolean(C0049k.FloatingActionButton_useCompatPadding, false);
        this.f3355k = m10861c.getDimensionPixelSize(C0049k.FloatingActionButton_maxImageSize, 0);
        MotionSpec m10959a = MotionSpec.m10959a(context, m10861c, C0049k.FloatingActionButton_showMotionSpec);
        MotionSpec m10959a2 = MotionSpec.m10959a(context, m10861c, C0049k.FloatingActionButton_hideMotionSpec);
        m10861c.recycle();
        this.f3359p = new AppCompatImageHelper(this);
        this.f3359p.m8175a(attributeSet, i);
        this.f3360q = new ExpandableWidgetHelper(this);
        getImpl().mo10752a(this.f3346b, this.f3347c, this.f3351g, this.f3350f);
        getImpl().m10791a(dimension);
        getImpl().m10779b(dimension2);
        getImpl().m10771d(dimension3);
        getImpl().m10789a(this.f3355k);
        getImpl().m10778b(m10959a);
        getImpl().m10787a(m10959a2);
        setScaleType(ImageView.ScaleType.MATRIX);
    }

    /* renamed from: a */
    public void m7661a(AbstractC0584b abstractC0584b, boolean z) {
        getImpl().m10785a(m7662a(abstractC0584b), z);
    }

    /* renamed from: b */
    public void m7656b(Rect rect) {
        rect.set(0, 0, getMeasuredWidth(), getMeasuredHeight());
        m7652c(rect);
    }

    /* renamed from: c */
    public final void m7652c(Rect rect) {
        int i = rect.left;
        Rect rect2 = this.f3357n;
        rect.left = i + rect2.left;
        rect.top += rect2.top;
        rect.right -= rect2.right;
        rect.bottom -= rect2.bottom;
    }

    /* renamed from: android.support.design.widget.FloatingActionButton$c */
    /* loaded from: classes.dex */
    public class C0585c implements ShadowViewDelegate {
        public C0585c() {
        }

        @Override // p000a.p006b.p012d.p026x.ShadowViewDelegate
        /* renamed from: a */
        public void mo7632a(int i, int i2, int i3, int i4) {
            FloatingActionButton.this.f3357n.set(i, i2, i3, i4);
            FloatingActionButton floatingActionButton = FloatingActionButton.this;
            floatingActionButton.setPadding(i + floatingActionButton.f3354j, i2 + FloatingActionButton.this.f3354j, i3 + FloatingActionButton.this.f3354j, i4 + FloatingActionButton.this.f3354j);
        }

        @Override // p000a.p006b.p012d.p026x.ShadowViewDelegate
        /* renamed from: b */
        public float mo7630b() {
            return FloatingActionButton.this.getSizeDimension() / 2.0f;
        }

        @Override // p000a.p006b.p012d.p026x.ShadowViewDelegate
        /* renamed from: a */
        public void mo7631a(Drawable drawable) {
            FloatingActionButton.super.setBackgroundDrawable(drawable);
        }

        @Override // p000a.p006b.p012d.p026x.ShadowViewDelegate
        /* renamed from: a */
        public boolean mo7633a() {
            return FloatingActionButton.this.f3356m;
        }
    }

    /* renamed from: a */
    public void m7664a(Animator.AnimatorListener animatorListener) {
        getImpl().m10783a(animatorListener);
    }

    @Override // p000a.p006b.p012d.p018p.ExpandableWidget
    /* renamed from: a */
    public boolean mo7667a() {
        return this.f3360q.m10885c();
    }

    /* renamed from: b */
    public final FloatingActionButtonImpl m7658b() {
        if (Build.VERSION.SDK_INT >= 21) {
            return new FloatingActionButtonImplLollipop(this, new C0585c());
        }
        return new FloatingActionButtonImpl(this, new C0585c());
    }

    /* renamed from: a */
    public final FloatingActionButtonImpl.InterfaceC0070g m7662a(AbstractC0584b abstractC0584b) {
        if (abstractC0584b == null) {
            return null;
        }
        return new C0583a(abstractC0584b);
    }

    /* renamed from: a */
    public final int m7666a(int i) {
        int i2 = this.f3353i;
        if (i2 != 0) {
            return i2;
        }
        Resources resources = getResources();
        if (i != -1) {
            if (i != 1) {
                return resources.getDimensionPixelSize(C0042d.design_fab_size_normal);
            }
            return resources.getDimensionPixelSize(C0042d.design_fab_size_mini);
        } else if (Math.max(resources.getConfiguration().screenWidthDp, resources.getConfiguration().screenHeightDp) < 470) {
            return m7666a(1);
        } else {
            return m7666a(0);
        }
    }

    /* renamed from: d */
    public void m7650d(Animator.AnimatorListener animatorListener) {
        getImpl().m10770d(animatorListener);
    }

    @Deprecated
    /* renamed from: a */
    public boolean m7663a(Rect rect) {
        if (ViewCompat.m9409x(this)) {
            rect.set(0, 0, getWidth(), getHeight());
            m7652c(rect);
            return true;
        }
        return false;
    }

    /* renamed from: a */
    public static int m7665a(int i, int i2) {
        int mode = View.MeasureSpec.getMode(i2);
        int size = View.MeasureSpec.getSize(i2);
        if (mode != Integer.MIN_VALUE) {
            if (mode != 0) {
                if (mode == 1073741824) {
                    return size;
                }
                throw new IllegalArgumentException();
            }
            return i;
        }
        return Math.min(i, size);
    }
}
